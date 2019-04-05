package jkt.hms.agendapoints.controller;

import static jkt.hms.util.RequestConstants.AGENDA_ACCEPTED;
import static jkt.hms.util.RequestConstants.AGENDA_DATE;
import static jkt.hms.util.RequestConstants.AGENDA_NO;
import static jkt.hms.util.RequestConstants.AGENDA_PLACE;
import static jkt.hms.util.RequestConstants.AGENDA_POINT_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.AGENDA_SUMMARY;
import static jkt.hms.util.RequestConstants.AGENDA_TIME;
import static jkt.hms.util.RequestConstants.AGENDA_TYPE;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.ENDING_TIME;
import static jkt.hms.util.RequestConstants.REMARKS;
import static jkt.hms.util.RequestConstants.STARTING_TIME;
import static jkt.hms.util.RequestConstants.UPDATE_AGENDA_POINTS_FOR_WORK_SERVICES_JSP;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.agendapoints.handler.AgendaPointSearchHandlerService;
import jkt.hms.agendapoints.handler.UpdateAgendaPointsForWorkServicesHandlerService;
import jkt.hms.masters.business.MasAgendaPointForWorkServices;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UpdateAgendaPointsForWorkServicesController extends
		MultiActionController {

	private UpdateAgendaPointsForWorkServicesHandlerService updateAgendaPointsForWorkServicesHandlerService = null;
	private CommonMasterHandlerService commonMasterHandlerService = null;
	private AgendaPointSearchHandlerService agendaPointSearchHandlerService = null;
	private int agendaId;

	@SuppressWarnings("unchecked")
	public ModelAndView showUpdateAgendaPointsForWorkServicesJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = null;
		String title = "";
		String message = "";
		setAgendaId(Integer.parseInt(request.getParameter("agendaId")));
		if (request.getParameter("message") != null) {
			message = request.getParameter("message");
		}
		int Id = getAgendaId();
		Map map = new HashMap();
		map = updateAgendaPointsForWorkServicesHandlerService
				.showUpdateAgendaPointsForWorkServicesJsp(Id);
		jsp = UPDATE_AGENDA_POINTS_FOR_WORK_SERVICES_JSP;
		jsp += ".jsp";
		title = "Update Agenda Points";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editUpdateAgendaPointsForWorkServices(
			HttpServletRequest request, HttpServletResponse response) {
		MultipartFormDataRequest mrequest = null;
		MasAgendaPointForWorkServices masAgendaPointForWorkServices = new MasAgendaPointForWorkServices();
		Map<String, Object> addagendaPoints = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int agendaid = 1;
		String jsp = "";
		String title = "";
		String agendaNo = "";
		String departmentName = "";
		Date agendaDate = null;
		String agendaTime = null;
		String changed_by = "";
		String agendaType = null;
		String agendaPlace = null;
		String startingTime = null;
		String endingTime = null;
		String agendaSummary = null;
		String message = "";
		String accepted = "";

		String remarks = "";
		String whiteList = "*.doc";
		int id = agendaid;
		String fileNameToBeAssigned = "";
		List fileUploadedList = null;
		String uploadURL = "";
		Boolean fileUploaded = false;
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		Properties properties = new Properties();
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		int fileSize = request.getContentLength();
		// UploadFile file = (UploadFile)
		// files.get(RequestConstants.UPLOAD_FILENAME);
		if (MultipartFormDataRequest.isMultipartFormData(request)
				&& fileSize <= 2180096) {
			try {
				mrequest = new MultipartFormDataRequest(request);
				if (mrequest.getParameter(AGENDA_NO) != null) {
					agendaNo = mrequest.getParameter(AGENDA_NO);
				}
				if (mrequest.getParameter(AGENDA_DATE) != null) {
					agendaDate = HMSUtil.dateFormatterDDMMYYYY(mrequest
							.getParameter(AGENDA_DATE));

				}
				if (mrequest.getParameter(AGENDA_TIME) != null) {
					agendaTime = mrequest.getParameter(AGENDA_TIME);
				}
				if (mrequest.getParameter(AGENDA_TYPE) != null) {
					agendaType = mrequest.getParameter(AGENDA_TYPE);
				}
				if (mrequest.getParameter(AGENDA_PLACE) != null) {
					agendaPlace = mrequest.getParameter(AGENDA_PLACE);
				}
				if (mrequest.getParameter(DEPARTMENT_ID) != null
						&& !mrequest.getParameter(DEPARTMENT_ID).equals("")) {
					departmentName = mrequest.getParameter(DEPARTMENT_ID);

				}
				if (mrequest.getParameter(STARTING_TIME) != null) {
					startingTime = mrequest.getParameter(STARTING_TIME);
				}
				if (mrequest.getParameter(ENDING_TIME) != null) {
					endingTime = mrequest.getParameter(ENDING_TIME);
				}
				if (mrequest.getParameter(AGENDA_SUMMARY) != null) {
					agendaSummary = mrequest.getParameter(AGENDA_SUMMARY);
				}
				if (mrequest.getParameter(AGENDA_ACCEPTED) != null) {
					accepted = mrequest.getParameter(AGENDA_ACCEPTED);
					//System.out.println("accepted" + accepted);
				}

				if (mrequest.getParameter(REMARKS) != null) {
					remarks = mrequest.getParameter(REMARKS);
					//System.out.println("remarks" + remarks);
				}

				if (mrequest.getParameter(CHANGED_BY) != null) {
					changed_by = mrequest.getParameter(CHANGED_BY);
				}

				uploadURL = properties.getProperty("uploadAgendaPoints");
				String[] agendaNoFile = agendaNo.split("/");
				fileNameToBeAssigned = "Agenda Points " + agendaNoFile[0]
						+ ".doc";

				if (mrequest != null && uploadURL != null) {
					// fileUploadedList =
					// HMSUtil.uploadFileWithMaxSizeLimit(mrequest, uploadURL,
					// whiteList,
					// fileNameToBeAssigned);
				}

				if (fileUploadedList != null && fileUploadedList.size() != 0) {
					fileUploaded = (Boolean) fileUploadedList.get(0);
				}

			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			String resoursePath = uploadURL.concat(fileNameToBeAssigned);
			generalMap.put("agendaNo", agendaNo);
			generalMap.put("agendaDate", agendaDate);
			generalMap.put("agendaTime", agendaTime);
			generalMap.put("agendaType", agendaType);
			generalMap.put("agendaPlace", agendaPlace);
			generalMap.put("startingTime", startingTime);
			generalMap.put("endingTime", endingTime);
			generalMap.put("agendaSummary", agendaSummary);
			generalMap.put("accepted", accepted);

			generalMap.put("remarks", remarks);
			generalMap.put("changed_by", changed_by);
			generalMap.put("departmentName", departmentName);
			generalMap.put("resoursePath", resoursePath);
			generalMap.put("id", getAgendaId());

			masAgendaPointForWorkServices.setAgendaNo(agendaNo);
			masAgendaPointForWorkServices.setAgendaDate(agendaDate);
			masAgendaPointForWorkServices.setAgendaTime(agendaTime);
			masAgendaPointForWorkServices.setAgendaType(agendaType);
			masAgendaPointForWorkServices.setAgendaPlace(agendaPlace);

			masAgendaPointForWorkServices.setLstChgBy(changed_by);
			masAgendaPointForWorkServices.setResoursePath(resoursePath);
			masAgendaPointForWorkServices.setDepartmentName(departmentName);

			masAgendaPointForWorkServices.setStartingTime(startingTime);
			masAgendaPointForWorkServices.setEndingTime(endingTime);
			masAgendaPointForWorkServices.setAgendaSummary(agendaSummary);
			addagendaPoints.put("isUploaded", fileUploaded);

			/*
			 * listMap = commonMasterHandlerService
			 * .checkForExistingMasters(generalMap);
			 */
			boolean dataUpdated = false;

			dataUpdated = updateAgendaPointsForWorkServicesHandlerService
					.editUpdateAgendaPointsForWorkServicesToDatabase(generalMap);

			if (dataUpdated == true) {
				message += "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}

			map = agendaPointSearchHandlerService.showAgendaPointSearchJsp();
			jsp = AGENDA_POINT_SEARCH_JSP;
			title = "Agenda Points Update";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
		} else {
			try {
				message = "Data Can't be updated please select file up to 2 MB";
				int id1 = getAgendaId();
				response
						.sendRedirect("/hms/hms/updateAgendaPointsForWorkServices?method=showUpdateAgendaPointsForWorkServicesJsp&agendaId="
								+ id1 + "&message=" + message);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		return new ModelAndView("index", "map", map);
	}

	// ---------------------------------------------------------------------------------------------
	public UpdateAgendaPointsForWorkServicesHandlerService getUpdateAgendaPointsForWorkServicesHandlerService() {
		return updateAgendaPointsForWorkServicesHandlerService;
	}

	public void setUpdateAgendaPointsForWorkServicesHandlerService(
			UpdateAgendaPointsForWorkServicesHandlerService updateAgendaPointsForWorkServicesHandlerService) {
		this.updateAgendaPointsForWorkServicesHandlerService = updateAgendaPointsForWorkServicesHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	public int getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(int agendaId) {
		this.agendaId = agendaId;
	}

	public AgendaPointSearchHandlerService getAgendaPointSearchHandlerService() {
		return agendaPointSearchHandlerService;
	}

	public void setAgendaPointSearchHandlerService(
			AgendaPointSearchHandlerService agendaPointSearchHandlerService) {
		this.agendaPointSearchHandlerService = agendaPointSearchHandlerService;
	}
}
