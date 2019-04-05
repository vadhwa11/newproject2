package jkt.hms.agendapoints.controller;

import static jkt.hms.util.RequestConstants.AGENDA_DATE;
import static jkt.hms.util.RequestConstants.AGENDA_NO;
import static jkt.hms.util.RequestConstants.AGENDA_PLACE;
import static jkt.hms.util.RequestConstants.AGENDA_POINT_UPDATE_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.AGENDA_SUMMARY;
import static jkt.hms.util.RequestConstants.AGENDA_TIME;
import static jkt.hms.util.RequestConstants.AGENDA_TYPE;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.ENDING_TIME;
import static jkt.hms.util.RequestConstants.STARTING_TIME;
import static jkt.hms.util.RequestConstants.UPDATE_AGENDA_POINTS__JSP;

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
import jkt.hms.agendapoints.handler.AgendaPointUpdateSearchHandlerService;
import jkt.hms.agendapoints.handler.UpdateAgendaPointsHandlerService;
import jkt.hms.masters.business.MasAgendaPointForWorkServices;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UpdateAgendaPointsController extends MultiActionController {
	private UpdateAgendaPointsHandlerService updateAgendaPointsHandlerService = null;
	private AgendaPointUpdateSearchHandlerService agendaPointUpdateSearchHandlerService = null;

	private int agendaId;

	@SuppressWarnings("unchecked")
	public ModelAndView showUpdateAgendaPointsForWorkServicesJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = null;
		String title = "";
		String message = "";
		setAgendaId(Integer.parseInt(request.getParameter("agendaId")));
		int Id = getAgendaId();
		Map map = new HashMap();
		if (request.getParameter("message") != null) {
			message = request.getParameter("message");
		}
		map = updateAgendaPointsHandlerService
				.showUpdateAgendaPointsForWorkServicesJsp(Id);
		jsp = UPDATE_AGENDA_POINTS__JSP;
		jsp += ".jsp";
		title = "Update Agenda Points";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
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
		String whiteList = "*.doc";
		int id = agendaid;
		String fileNameToBeAssigned = "";
		List fileUploadedList = null;

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

				if (mrequest.getParameter(CHANGED_BY) != null) {
					changed_by = request.getParameter(CHANGED_BY);
				}

			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			String uploadURL = properties.getProperty("uploadAgendaPoints");
			String[] agendaNoFile = agendaNo.split("/");
			fileNameToBeAssigned = "Agenda Points " + agendaNoFile[0] + ".doc";

			if (mrequest != null && uploadURL != null) {
				// fileUploadedList =
				// HMSUtil.uploadFileWithMaxSizeLimit(mrequest, uploadURL,
				// whiteList, fileNameToBeAssigned);
			}
			Boolean fileUploaded = false;
			if (fileUploadedList != null && fileUploadedList.size() != 0) {
				fileUploaded = (Boolean) fileUploadedList.get(0);
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
			generalMap.put("changed_by", changed_by);
			generalMap.put("departmentName", departmentName);
			generalMap.put("resoursePath", resoursePath);
			generalMap.put("id", getAgendaId());

			masAgendaPointForWorkServices.setAgendaNo(agendaNo);
			masAgendaPointForWorkServices.setAgendaDate(agendaDate);
			masAgendaPointForWorkServices.setAgendaTime(agendaTime);
			masAgendaPointForWorkServices.setAgendaType(agendaType);
			masAgendaPointForWorkServices.setAgendaPlace(agendaPlace);
			masAgendaPointForWorkServices.setStatus("y");
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
			List existingMinorWorkDetailNameList = (List) listMap
					.get("duplicateMastersList");
			boolean dataUpdated = false;
			if (existingMinorWorkDetailNameList == null
					|| existingMinorWorkDetailNameList.size() == 0) {

				dataUpdated = updateAgendaPointsHandlerService
						.editUpdateAgendaPointsForWorkServicesToDatabase(generalMap);

				if (dataUpdated == true) {
					message = "Data updated Successfully !!";
				} else {
					message = "Data Cant be updated !!";
				}
			} else if (existingMinorWorkDetailNameList != null
					&& existingMinorWorkDetailNameList.size() > 0) {

				message = "Name already exists.";
			}

			map = agendaPointUpdateSearchHandlerService
					.showAgendaPointSearchJsp();
			//System.out.println("mapSize1111" + map.size());
			jsp = AGENDA_POINT_UPDATE_SEARCH_JSP;
			title = "Agenda Points Update";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
		} else {
			int id1 = getAgendaId();
			try {
				message = "Data Can't be updated please select file up to 2 MB";

				response
						.sendRedirect("/hms/hms/updateAgendaPoints?method=showUpdateAgendaPointsForWorkServicesJsp&agendaId="
								+ id1 + "&message=" + message);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		return new ModelAndView("index", "map", map);
	}

	// *********************************************************************************************************
	public int getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(int agendaId) {
		this.agendaId = agendaId;
	}

	public AgendaPointUpdateSearchHandlerService getAgendaPointUpdateSearchHandlerService() {
		return agendaPointUpdateSearchHandlerService;
	}

	public void setAgendaPointSearchHandlerService(
			AgendaPointSearchHandlerService agendaPointSearchHandlerService) {
		this.agendaPointUpdateSearchHandlerService = agendaPointUpdateSearchHandlerService;
	}

	public UpdateAgendaPointsHandlerService getUpdateAgendaPointsHandlerService() {
		return updateAgendaPointsHandlerService;
	}

	public void setUpdateAgendaPointsHandlerService(
			UpdateAgendaPointsHandlerService updateAgendaPointsHandlerService) {
		this.updateAgendaPointsHandlerService = updateAgendaPointsHandlerService;
	}

	public void setAgendaPointUpdateSearchHandlerService(
			AgendaPointUpdateSearchHandlerService agendaPointUpdateSearchHandlerService) {
		this.agendaPointUpdateSearchHandlerService = agendaPointUpdateSearchHandlerService;
	}

}
