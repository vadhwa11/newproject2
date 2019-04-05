package jkt.hms.masters.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasApplication;
import jkt.hms.masters.handler.CommonMasterHandlerService;

public class BreadCrumbMaster {
	CommonMasterHandlerService commonMasterHandlerService;
	HttpSession session = null;

	public Map showInsidePageWithAppIdOnly(HttpServletRequest request) {
		session = request.getSession();
		String appId = "";
		appId = request.getParameter("appId");
		MasApplication appObj = commonMasterHandlerService
				.getAppIdObject(appId);
		String parentId = "";
		Map<String, Object> model = new HashMap<String, Object>();
		List dataList = new ArrayList();
		if (appObj != null)
			parentId = appObj.getParentId();
		String jspName = String.valueOf(parentId);
		if (model != null && model.get(jspName) != null) {
			dataList = (List) model.get(jspName);
		}
		MasApplication selectedApp = null;
		List<MasApplication> remainingDataList = new ArrayList<MasApplication>();
		if (dataList != null || appObj != null) {
			if (dataList != null && dataList.size() > 0) {
				for (Iterator iterator = dataList.iterator(); iterator
						.hasNext();) {
					appObj = (MasApplication) iterator.next();
					if (appObj.getId().equals(appId))
						remainingDataList.add(appObj);
					else
						selectedApp = appObj;
				}
			} else {
				selectedApp = appObj;
				jspName = "";
			}
			if (appObj != null) {
				parentId = appObj.getParentId();

			}
			Map<String, Object> mapMenu = commonMasterHandlerService
					.getBreadCrumbs(appId);
			model.put("remainingDataList", remainingDataList);
			model.put("selectedApp", selectedApp);
			model.put("jspName", jspName);
			model.put("breadCrumbs", (String) mapMenu.get("breadCrumbs"));
			model.put("insideJsp", "breadCrumb.jsp");
		}

		return model;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}
