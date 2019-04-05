package jkt.hms.workservices.controller;

import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.MONTH;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.YEAR;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.util.HMSUtil;
import jkt.hms.workservices.handler.ReportHandlerService;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ReportController extends MultiActionController {
	private ReportHandlerService reportHandlerService = null;

	public ReportHandlerService getReportHandlerService() {
		return reportHandlerService;
	}

	public void setReportHandlerService(
			ReportHandlerService reportHandlerService) {
		this.reportHandlerService = reportHandlerService;
	}

	public ModelAndView showMinorWorkRegister(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "minorWorkRegister.jsp";
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showMinorWorkRegister();
		//System.out.println("hii this is jsp");
		map.put("contentJsp", jsp);
		//System.out.println("hello we in success");
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printMinorWorkRegister(HttpServletRequest request,
			HttpServletResponse response) {

		byte[] bytes = null;
		//ServletContext context = request.getSession().getServletContext();
		// Map parameters = new HashMap();
		Map<String, Object> parameters = new HashMap();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate = null;
		Date toDate = null;
		int workid = 0;
		int status = 0;
		String title = "";
		String stringvariable = "";
		String query = "";
		title = "Minor Work Register Report For The Period(";
		try {

			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				title += HMSUtil.convertDateToStringWithoutTime(fromDate) + "-";
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				title += HMSUtil.convertDateToStringWithoutTime(toDate) + ")";
			}
			if (request.getParameter("work") != null
					&& !(request.getParameter("work").equals(""))) {
				workid = Integer.parseInt(request.getParameter("work"));
			}

			if (workid != 0) {
				stringvariable = " and mas_minor_work_detail.work_type_id="
						+ workid;
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals("0"))) {
				status = Integer.parseInt(request.getParameter(SELECTED_RADIO));
			}

			parameters.put("fromdate", fromDate);
			parameters.put("todate", toDate);
			parameters.put("worktype", workid);
			parameters.put("status", status);
			parameters.put("title", title);
			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("MinorWorkRegister", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView showMajorWorkRegister(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "majorWorkRegister.jsp";
		Map<String, Object> map = new HashMap<String, Object>();
		map = reportHandlerService.showMajorWorkRegister();
		//System.out.println("hii this is majorjsp");
		map.put("contentJsp", jsp);
		//System.out.println("hello we in success");
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printMajorWorkRegister(HttpServletRequest request,
			HttpServletResponse response) {

		byte[] bytes = null;
		//ServletContext context = request.getSession().getServletContext();
		Map<String, Object> parameters = new HashMap();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate = null;
		String toDate = null;
		String workid = "";
		int status = 0;
		String stringvariable = "";
		String query = "";

		try {

			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE)));

				// toDate =
				// HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			}
			if (request.getParameter("work") != null
					&& !(request.getParameter("work").equals(""))) {
				workid = request.getParameter("work");
				//System.out.println("worktype" + workid);
			}

			if (!workid.equals("")) {
				stringvariable = " and mas_major_work_detail.work_type_id="
						+ workid;
			}
			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals("0"))) {
				status = Integer.parseInt(request.getParameter(SELECTED_RADIO));
				if (status == 1) {
					query = "and mas_major_work_detail.major_work_detail_status = 'p'";
				}
				if (status == 2) {
					query = query
							+ "and mas_major_work_detail.major_work_detail_status = 'a'";
				}
				if (status == 3) {
					query = query
							+ "and mas_major_work_detail.major_work_detail_status = 'w'";
				}
				if (status == 4) {
					query = query
							+ "and mas_major_work_detail.major_work_detail_status = 'c'";
				}
			}

			parameters.put("fromdate", fromDate);
			parameters.put("todate", toDate);
			parameters.put("stringvariable", stringvariable);
			parameters.put("QUERY", query);
			//System.out.println("in printttttttttttttt");
			//System.out.println("fromDate-- " + fromDate);
			//System.out.println("toDate-- " + toDate);
			//System.out.println("work-- " + workid);

			Map<String, Object> connectionMap = reportHandlerService
					.getConnectionForReport();
			//System.out.println("connectionMap.........."+ (Connection) connectionMap.get("conn"));
			HMSUtil.generateReport("MajorWorkRegister", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ============================================================
	public ModelAndView showAraogyaReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "araogyaReport.jsp";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printAraogyaReport(HttpServletRequest request,

	HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		}
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
			mapForDs.put("toDate", toDate);
		}

		HSSFWorkbook wb = new HSSFWorkbook();
		HttpSession session = request.getSession(true);

		map = reportHandlerService.printAraogyaReport(mapForDs);
		wb = (HSSFWorkbook) map.get("wb");
		try {
			String file = "TB_MED_ADMISSION_DISCHARGE.xls";
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment; filename="
					+ file);

			wb.write(response.getOutputStream());
		} catch (IOException ioe) {
			ioe.printStackTrace();

		}
		return null;
	}

	public ModelAndView showMedAddmissionDiagJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "medAdmissionDiagReport.jsp";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printMedAdmissionDiagReport(HttpServletRequest request,

	HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		}
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
			mapForDs.put("toDate", toDate);
		}

		HSSFWorkbook wb = new HSSFWorkbook();
		HttpSession session = request.getSession(true);

		map = reportHandlerService.printMedAdmissionDiagReport(mapForDs);
		wb = (HSSFWorkbook) map.get("wb");
		try {
			String file = "TB_MED_ADMISSION_DIAGNOSIS.xls";
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment; filename="
					+ file);

			wb.write(response.getOutputStream());
		} catch (IOException ioe) {
			ioe.printStackTrace();

		}
		return null;
	}

	// =============================================================

	public ModelAndView showMisBedReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "mis_bed_stats.jsp";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printMisBedReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		String month = null;

		if (request.getParameter(MONTH) != null
				&& !(request.getParameter(MONTH).equals(""))) {
			month = (request.getParameter(MONTH));
			mapForDs.put("month", month);
			//System.out.println("month---" + month);
		}

		if (request.getParameter(YEAR) != null
				&& !(request.getParameter(YEAR).equals(""))) {
			String year = (request.getParameter(YEAR));
			mapForDs.put("year", year);
			//System.out.println("year---" + year);
		}

		if (request.getParameter("monthString") != null) {
			String monthString = (request.getParameter("monthString"));
			mapForDs.put("monthString", monthString);
			//System.out.println("monthString---" + monthString);
		}

		HSSFWorkbook wb = new HSSFWorkbook();
		HttpSession session = request.getSession(true);

		map = reportHandlerService.printMisBedReport(mapForDs);
		wb = (HSSFWorkbook) map.get("wb");
		try {
			String file = "MisBedReport.xls";
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment; filename="
					+ file);

			wb.write(response.getOutputStream());
		} catch (IOException ioe) {
			ioe.printStackTrace();

		}
		return null;
	}

}
