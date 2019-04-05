package jkt.hms.workservices.controller;

import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.TO_DATE;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.HMSUtil;
import jkt.hms.workservices.handler.MinorWorkNotYetReleasedReportHandlerService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MinorWorkNotYetReleasedReportController extends
		MultiActionController {
	private MinorWorkNotYetReleasedReportHandlerService minorWorkNotYetReleasedReportHandlerService = null;
	private CommonMasterHandlerService commonMasterHandlerService = null;

	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	String jsp = "";
	HttpSession session = null;
	String title = "";

	// ************************************************************************************************************

	// Minor Work NotYetRealesed
	// ************************************************************************************************************

	public ModelAndView showMinorWorkYetReleased(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "minorWorkYetReleased.jsp";
		Map<String, Object> map = new HashMap<String, Object>();
		map = minorWorkNotYetReleasedReportHandlerService
				.showMinorWorkYetReleased();

		map.put("contentJsp", jsp);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printMinorworkyetrealesed(HttpServletRequest request,
			HttpServletResponse response) {

		byte[] bytes = null;
		//ServletContext context = request.getSession().getServletContext();
		Map<String, Object> parameters = new HashMap();

		Map<String, Object> connectionMap = minorWorkNotYetReleasedReportHandlerService
				.getConnectionForReport();
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		HMSUtil.generateReport("minorWorkReleased", parameters,
				(Connection) connectionMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView showMinorWorkNotYetReleased(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "minorWorkNotYetReleased.jsp";
		Map<String, Object> map = new HashMap<String, Object>();
		map = minorWorkNotYetReleasedReportHandlerService
				.showMinorWorkNotYetReleased();

		map.put("contentJsp", jsp);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printMinorworknotyetrealesed(
			HttpServletRequest request, HttpServletResponse response) {

		byte[] bytes = null;
		//ServletContext context = request.getSession().getServletContext();
		Map<String, Object> parameters = new HashMap();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate = null;
		Date toDate = null;
		String workid = "";
		int status = 0;
		String workType = "";
		String query = "";

		try {

			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter("work") != null
					&& !(request.getParameter("work").equals(""))) {
				workType = request.getParameter("work");
				//System.out.println("worktype" + workType);
			}

			parameters.put("fromDate", fromDate);
			parameters.put("toDate", toDate);
			parameters.put("workType", workType);

			//System.out.println("in printttttttttttttt");
			//System.out.println("fromDate-- " + fromDate);
			//System.out.println("toDate-- " + toDate);
			//System.out.println("work-- " + workid);

			Map<String, Object> connectionMap = minorWorkNotYetReleasedReportHandlerService
					.getConnectionForReport();
			//System.out.println("connectionMap.........."+ (Connection) connectionMap.get("conn"));
			HMSUtil.generateReport("minorworknotyetrealesed", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public MinorWorkNotYetReleasedReportHandlerService getMinorWorkNotYetReleasedReportHandlerService() {
		return minorWorkNotYetReleasedReportHandlerService;
	}

	public void setMinorWorkNotYetReleasedReportHandlerService(
			MinorWorkNotYetReleasedReportHandlerService minorWorkNotYetReleasedReportHandlerService) {
		this.minorWorkNotYetReleasedReportHandlerService = minorWorkNotYetReleasedReportHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}
