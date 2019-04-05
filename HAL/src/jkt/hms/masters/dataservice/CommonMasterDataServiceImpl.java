package jkt.hms.masters.dataservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import jkt.hms.masters.business.MasApplication;
import jkt.hms.masters.business.UserButtonRights;
import jkt.hms.masters.business.Users;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CommonMasterDataServiceImpl extends HibernateDaoSupport implements
		CommonMasterDataService {

	// -----------------General Methods for All Masters By Deepti
	// Tevatia-------------------

	public List getMastersList(Map<String, Object> generalMap) {
		String pojoName = (String) generalMap.get("pojoName");
		String pojoPropertyName = (String) generalMap.get("pojoPropertyName");

		List mastersList = getHibernateTemplate().find(
				"from jkt.hms.masters.business." + pojoName
						+ " as g where g.Status = 'y' order by "
						+ pojoPropertyName + " ");
		return mastersList;
	}

	public Map checkForExistingMasters(Map<String, Object> generalMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List duplicateMastersList = new ArrayList();
		List duplicateGeneralNameList = new ArrayList();
		List duplicateGeneralCodeList = new ArrayList();
		List duplicateGeneralAddressList = new ArrayList();
		
		int id = 0;
		int deptId=0;
		String pojoPropertyCode = "";
		String pojoPropertyAddress = "";
		String pojoPropertyName = "";
		String pojoDepartmentName = "";

		if (generalMap.get("id") != null) {
			id = (Integer) generalMap.get("id");
		}
		if (generalMap.get("deptId") != null) {
			deptId = (Integer) generalMap.get("deptId");
		}
		String name = (String) generalMap.get("name");
		String pojoName = (String) generalMap.get("pojoName");
		int departmentId=0;
		if(generalMap.get("departmentId")!=null)
		{
			 departmentId = Integer.parseInt(generalMap.get("departmentId").toString());
		}
		
		if (generalMap.get("pojoPropertyName") != null)
			pojoPropertyName = (String) generalMap.get("pojoPropertyName");

		if (generalMap.get("pojoPropertyCode") != null) {
			pojoPropertyCode = (String) generalMap.get("pojoPropertyCode");
			//System.out.println("pojoproperty code" + pojoPropertyCode);
		}
		if (generalMap.get("pojoDepartmentName") != null) {
			pojoDepartmentName = (String) generalMap.get("pojoDepartmentName");
			
		}
		if (generalMap.get("pojoPropertyAddress") != null) {
			pojoPropertyAddress = (String) generalMap
					.get("pojoPropertyAddress");
		}
		System.out.println("pojoName--- "+pojoName);
		if(!pojoName.equals("MasStoreSupplier"))
		{
		if (generalMap.get("flag") == null) {
			
			String code = (String) generalMap.get("code");
			String address = (String) generalMap.get("address");
			if (!pojoPropertyCode.equals("")) {
				duplicateGeneralCodeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business." + pojoName
								+ " as g where g." + pojoPropertyCode + " = '"
								+ code + "'");
			}
			System.out.println("pojoPropertyName--- "+pojoPropertyName);
			if (!pojoPropertyName.equals("")) {
				/*duplicateGeneralNameList = getHibernateTemplate().find(
						"from jkt.hms.masters.business." + pojoName
								+ " as g where g." + pojoPropertyName + " = '"
								+ name + "' and g.DepartmentId.Id="+departmentId);*/
				duplicateGeneralNameList = getHibernateTemplate().find(
						"from jkt.hms.masters.business." + pojoName
								+ " as g where g." + pojoPropertyName + " = '"
								+ name + "'");
			}
			if (!pojoPropertyAddress.equals("")) {
				duplicateGeneralAddressList = getHibernateTemplate().find(
						"from jkt.hms.masters.business." + pojoName
								+ " as g where g." + pojoPropertyAddress
								+ " ='" + address + "'");
			
		}

		}else if (generalMap.get("flag") != null){
			boolean flag = (Boolean) generalMap.get("flag");

/*
duplicateMastersList = getHibernateTemplate().find(
					"from jkt.hms.masters.business." + pojoName
							+ " as g where g." + pojoPropertyName + " = '"
							+ name + "' and g.DepartmentId.Id="+departmentId);
*/
			duplicateMastersList = getHibernateTemplate().find(
					"from jkt.hms.masters.business." + pojoName
							+ " as g where g." + pojoPropertyName + " = '"
							+ name + "' and g.Id != " + id);
			
		}
		}
		map.put("duplicateGeneralNameList", duplicateGeneralNameList);
		map.put("duplicateGeneralCodeList", duplicateGeneralCodeList);
		map.put("duplicateGeneralAddressList", duplicateGeneralAddressList);
		map.put("duplicateMastersList", duplicateMastersList);

		return map;
	}

	public List getMastersInformationOnChange(Map<String, Object> generalMap) {
		int id = (Integer) generalMap.get("id");
		String pojoName = (String) generalMap.get("pojoName");
		String pojoPropertyName = (String) generalMap.get("pojoPropertyName");

		List onChangeMastersList = getHibernateTemplate().find(
				"from jkt.hms.masters.business." + pojoName
						+ " as g where g.Id = " + id + " order by "
						+ pojoPropertyName + " ");
		return onChangeMastersList;
	}

	public List getMastersListByName(Map mastersEnquiryMap, String status) {
		List listByMastersName = new ArrayList();

		String name = (String) mastersEnquiryMap.get("name");
		String pojoPropertyName = (String) mastersEnquiryMap
				.get("pojoPropertyName");
		String pojoName = (String) mastersEnquiryMap.get("pojoName");

		if (status.equals("y"))
			listByMastersName = getHibernateTemplate().find(
					"from jkt.hms.masters.business." + pojoName + " as g "
							+ "where g." + pojoPropertyName + " like '" + name
							+ "%' and g.Status = 'y' order by "
							+ pojoPropertyName + " ");

		else
			listByMastersName = getHibernateTemplate().find(
					"from jkt.hms.masters.business." + pojoName + " as g "
							+ "where g." + pojoPropertyName + " like '" + name
							+ "%' order by " + pojoPropertyName + " ");

		return listByMastersName;
	}

	public List getTableRecords(Map<String, Object> mapForDs) {
		List enquiryList = new ArrayList();
		String pojoName = (String) mapForDs.get("pojoName");
		String searchName = (String) mapForDs.get("searchName");
		String pojoPropertyName = (String) mapForDs.get("pojoPropertyName");
		try {
			enquiryList = getHibernateTemplate().find(
					"from jkt.hms.masters.business." + pojoName
							+ " as master where master." + pojoPropertyName
							+ " like '" + searchName + "%'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return enquiryList;
	}

	public List getAllMasterRecords(String masterName) {
		List masterList = getHibernateTemplate().find(
				"from jkt.hms.masters.business." + masterName
						+ " as  master where master.Status = 'y'");
		return masterList;
	}

	public MasApplication getAppIdObject(String appId) {
		List list = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasApplication as am where am.Id = '"
						+ appId + "'");
		return (MasApplication) list.get(0);

	}

	public Map<String, Object> getBreadCrumbs(String appId) {

		Map<String, Object> map = new HashMap<String, Object>();
		List appList = getAppList();
		List<MasApplication> parentList = new Vector<MasApplication>();
		parentList = getParentLink(appList, appId, parentList);
		String parentLink = "";
		if (parentList.size() == 0) {
			parentLink = "<a href='../hms/common?method=showHome"
					+ "'>Home</a>";
		} else if (parentList.size() > 0) {
			for (int i = 0; i < parentList.size(); i++) {
				MasApplication appObj = (MasApplication) parentList.get(i);
				if (appObj.getParentId() == null
						&& !(appObj.getId().equals(appId))) {
					parentLink = " > " + appObj.getName() + " " + parentLink;
				} else if (appObj.getParentId() != null
						&& !(appObj.getId().equals(appId))) {
					parentLink = " > " + appObj.getName() + " " + parentLink;
				}
			}
			parentLink = "<a href='../hms/common?method=showHome"
					+ "'>Home</a>" + parentLink;
		}
		map.put("breadCrumbs", parentLink);
		return map;
	}

	public List getAppList() {
		Session session = getSession();
		List appList = new ArrayList();
		try {
			appList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasApplication as am");
		} finally {
			try {
				session.close();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
		return appList;
	}

	protected List<MasApplication> getParentLink(List _fullList, String appId,
			List<MasApplication> parentList) {
		for (Iterator iter = _fullList.iterator(); iter.hasNext();) {
			MasApplication app = (MasApplication) iter.next();
			if (app.getId().equals(appId)) {
				if (app.getParentId() == null) {
					parentList.add(app);
					break;
				} else {
					parentList.add(app);
					String parentId = app.getParentId();
					parentList = getParentLink(_fullList, parentId, parentList);
				}
			}
		}
		return parentList;
	}

	public Map<String, Object> getUserButtonRights(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<UserButtonRights> userRightsList = new ArrayList<UserButtonRights>();
		Users users = (Users) dataMap.get("users");
		int userId = users.getId();
		try {
			userRightsList = session.createCriteria(UserButtonRights.class)
					.createAlias("Button", "button")
					.createAlias("User", "user").add(
							Restrictions.eq("button.Status", "y")).add(
							Restrictions.eq("user.Id", userId)).list();

			map.put("userRightsList", userRightsList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		//System.out.println("size of userRightsList------------"+ userRightsList.size());
		return map;
	}

	// added by yogesh on 08/10/2009
	public Object loadObject(Class clazz, Integer id) {
		return getHibernateTemplate().load(clazz, id);
	}

}