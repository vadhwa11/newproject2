package jkt.hms.dental.controller;

import static jkt.hms.util.RequestConstants.CONSULTING_DOCTOR;
import static jkt.hms.util.RequestConstants.DIAGNOSIS_ID;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.HIN_NO_FOR_REPORT;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.MARITAL_STATUS_ID;
import static jkt.hms.util.RequestConstants.OPD_REGISTER_REPORT_JSP;
import static jkt.hms.util.RequestConstants.RANK_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.RELATION_ID;
import static jkt.hms.util.RequestConstants.SECTION_ID;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SERVICE_NO_FOR_REPORT;
import static jkt.hms.util.RequestConstants.SERVICE_STATUS_ID;
import static jkt.hms.util.RequestConstants.SERVICE_TYPE_ID;
import static jkt.hms.util.RequestConstants.SEX_ID;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.TRADE_ID;
import static jkt.hms.util.RequestConstants.UNIT_ID;
import static jkt.hms.util.RequestConstants.VISIT_ID;
import static jkt.hms.util.RequestConstants.VISIT_NUMBER;
import static jkt.hms.util.RequestConstants.VISIT_NUMBER_FOR_REPORT;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.dental.handler.DentalHandlerService;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.OpdTemplate;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.opd.handler.OPDHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


public class DentalController extends MultiActionController {
	 HttpSession session = null;
	 DentalHandlerService dentalHandlerService = null;
	 OPDHandlerService opdHandlerService = null;
	 public OPDHandlerService getOpdHandlerService() {
		return opdHandlerService;
	}

	public void setOpdHandlerService(OPDHandlerService opdHandlerService) {
		this.opdHandlerService = opdHandlerService;
	}

	public DentalHandlerService getDentalHandlerService() {
		return dentalHandlerService;
	}

	public void setDentalHandlerService(DentalHandlerService dentalHandlerService) {
		this.dentalHandlerService = dentalHandlerService;
	}

	 String jsp = "";
	 String title = "";
	 String pojoPropertyName = "";
	 String pojoPropertyCode = "";
   	 String pojoName = "";
	 String userName = "";
	 String currentDate = "";
	 String currentTime = "";
	 String message = "";
	 String code = "";
	 String name = "";
	 String changedBy = "";
	 String jspName = "";
	 String url = "";
	 
	 public ModelAndView showDentalWaitingList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int deptId = 0;
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int hospitalId  = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (request.getParameter("consultingDoc") != null) {
			int empId = Integer.parseInt(request.getParameter("consultingDoc"));
			box.put("empId", empId);
		}else{
			Users user = new Users();
			if(session.getAttribute("users")!=null){
				user = (Users)session.getAttribute("users");
				box.put("empId", user.getEmployee().getId());
			}
		}

		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
			box.put("deptId", deptId);
		} else {
			deptId = (Integer) session.getAttribute("deptId");
			box.put("deptId", deptId);
		}
		mapForDS.put("box", box);
		map = dentalHandlerService.getDentalWaitingList(mapForDS);
		 jsp = "dentalWaitingList";
		 jsp = jsp + ".jsp";
	   	 title = "Dental Treatment";
	 	 map.put("contentJsp", jsp);
		 map.put("title", title);

		 return new ModelAndView("indexB", "map", map);
	 }

	 public ModelAndView showDentalTreatmentJsp(HttpServletRequest request,
			       HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		 int visitId = 0;
		 if(request.getParameter("visitId") != null){
			 visitId = Integer.parseInt(request.getParameter("visitId"));
			 dataMap.put("visitId", visitId);
		 }
		map = dentalHandlerService.getDentalPatientDataList(dataMap);
		 jsp = "dentalTreatment.jsp";
	   	 title = "Dental Treatment";
	 	 map.put("contentJsp", jsp);
		 map.put("title", title);

		 return new ModelAndView("indexB", "map", map);
	 }
	 public ModelAndView submitDentalTreatmentDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int hospitalId  = 0;
		int userId = 0;
		int deptId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
			mapForDS.put("hospitalId", hospitalId);
		}
		if (request.getParameter("deptId") != null && !request.getParameter("deptId").equals("0")) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
			box.put("deptId", deptId);
			mapForDS.put("deptId", deptId);
		} else {
			deptId = (Integer) session.getAttribute("deptId");
			box.put("deptId", deptId);
			mapForDS.put("deptId", deptId);
		}
		Users user = new Users();
		if(session.getAttribute("users")!=null){
			user = (Users)session.getAttribute("users");
			box.put("userId", user.getId());
			box.put("empId", user.getEmployee().getId());
			mapForDS.put("userId", user.getId());
		}
		String userName = "";
		if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
		box.put("userName", userName);
		mapForDS.put("userName", userName);
		}
		String referedToMH="";
		if (request.getParameter("referedToMH") != null && !request.getParameter("referedToMH").equals("")) {
			referedToMH = request.getParameter("referedToMH");
		}else{
			referedToMH="n";
		}
		String mh = "";
		if (request.getParameter("mh") != null) {
			mh = request.getParameter("mh");
		}
		String mhDepartment = "";
		if (request.getParameter("mhDepartment") != null) {
			mhDepartment = request.getParameter("mhDepartment");
		}
		String mhReferredFor = "";
		if (request.getParameter("mhReferredFor") != null) {
			mhReferredFor = request.getParameter("mhReferredFor");
		}
		String disposal = "";
		if (request.getParameter("disposal") != null) {
			disposal = request.getParameter("disposal");
		}
		String days = "";
		if (request.getParameter("days") != null) {
			days = request.getParameter("days");
		}
		
		String orderSeqNo = opdHandlerService.generateOrderNumber(hospitalId);
		box.put("orderSeqNo", orderSeqNo);
		int hdb = 1;
		if (Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hdb"));
		}
		List<String> pvmsNoList = new ArrayList<String>();
		List<Integer> frequencyList = new ArrayList<Integer>();
		List<String> dosageList = new ArrayList<String>();
		List<String> remarksList = new ArrayList<String>();
		List<Integer> totalList = new ArrayList<Integer>();
		List<Integer> noOfDaysList = new ArrayList<Integer>();
		List<String> routeList = new ArrayList<String>();
		String[] pvmsArr = new String[hdb];
		String otherMedicine = "";
		List<String> otherMedicineList = new ArrayList<String>();
		List<String> ctList = new ArrayList<String>();
		//-----------------code for ICDE Diagnosis---------------------//
		String[] diagnosisIdAray = null;
		if (request.getParameterValues(DIAGNOSIS_ID) != null) {
			diagnosisIdAray = (String[]) request.getParameterValues(DIAGNOSIS_ID);
		}
		int systemDiagnosisId = 0;
		if(request.getParameter("systemDiagnosis") != null && !request.getParameter("systemDiagnosis").equals("")){
			String systemDiagnosis = request.getParameter("systemDiagnosis");
			int index1 = systemDiagnosis.lastIndexOf("[");
			int index2 = systemDiagnosis.lastIndexOf("]");
			index1++;
			systemDiagnosisId =Integer.parseInt(systemDiagnosis.substring(index1, index2));
		}
		//----------------code for investigation-----------------------//
			List<String> chargeCodeIdList = new ArrayList<String>();
			List<String> referToMhList = new ArrayList<String>();
			String clinicalNotes1 = "";
			if (request.getParameter("clinicalNotes1") != null
					&& !(request.getParameter("clinicalNotes1").equals(""))) {
				clinicalNotes1 = request.getParameter("clinicalNotes1");
			}
			int hiddenValue = 1;
			if (Integer.parseInt(request.getParameter("hiddenValue")) != 1) {
				hiddenValue = Integer.parseInt(request.getParameter("hiddenValue"));
			}
			int temp = 1;
			String[] chargeCodeIdArr = new String[hiddenValue];
			for (int i = 0; i < hiddenValue; i++) {
				if (request.getParameter("chargeCodeName" + temp) != null
						&& !request.getParameter("chargeCodeName" + temp)
								.equals("")) {

					String chargeCodeNameWithId = request
							.getParameter("chargeCodeName" + temp);
					int index1 = chargeCodeNameWithId.lastIndexOf("[");
					int index2 = chargeCodeNameWithId.lastIndexOf("]");
					index1++;
					String chargeCodeId = chargeCodeNameWithId.substring(index1,
							index2);
					if (!chargeCodeId.equals("")) {
						chargeCodeIdArr[i] = chargeCodeId;
						int qty = 1;
						if(request.getParameter("referToMh" + i) != null && !request.getParameter("referToMh" + i).equals("")){
							String referToMh = request.getParameter("referToMh" + i);
							referToMhList.add(referToMh);
						}else{
							String referToMh = "n";
							referToMhList.add(referToMh);
						}
						chargeCodeIdList.add(chargeCodeIdArr[i]);
						
					}
				}
				temp++;
			}
		//------------------end of the code investogation-------------------//
		
		int j = 1;
		for (int i = 0; i < hdb; i++) {
			String pvmsNo = "";
			if (request.getParameter("nomenclature" + j) != null && !request.getParameter("nomenclature" + j).equals("")) {

				String nomenclature = request.getParameter("nomenclature" + j);
				int index1 = nomenclature.lastIndexOf("[");
				int index2 = nomenclature.lastIndexOf("]");
				index1++;
				pvmsNo = nomenclature.substring(index1, index2);
				if (!pvmsNo.equals("")) {
					pvmsArr[i] = pvmsNo;
				}
			}else{
				if(request.getParameter("otherMedicine"+ j) != null && !request.getParameter("otherMedicine"+ j).equals("")){
					otherMedicine = request.getParameter("otherMedicine"+ j);
					otherMedicineList.add(otherMedicine);
				}
			}
		
			int frequencyId = 0;
			if(request.getParameter("frequency" + j) != null && !request.getParameter("frequency" + j).equals("")){
				frequencyId = Integer.parseInt(request.getParameter("frequency" + j));
				frequencyList.add(frequencyId);
			}else {
				frequencyList.add(0);
			}
			if(request.getParameter("ct" + j) != null){
				ctList.add("y");
			}	else {
				ctList.add("n");
			}

			String route = "";
			if(request.getParameter("route" + j) != null && !request.getParameter("route" + j).equals("")){
				route = request.getParameter("route" + j);
				routeList.add(route);
			}	else {
				routeList.add("");
			}
			
			int frequenceValue = 0;
			if(request.getParameter("frequencyValue" + j) != null && !request.getParameter("frequencyValue" + j).equals("")){
				frequenceValue =Integer.parseInt(request.getParameter("frequencyValue" + j));
			}	
			String dosage = "";
			if(request.getParameter("dosage" + j) != null && !request.getParameter("dosage" + j).equals("")){
				dosage = request.getParameter("dosage" + j);
				dosageList.add(dosage);
			}else{
				dosageList.add("");
			}
			
			if(request.getParameter("noOfDays" + j) != null && !request.getParameter("noOfDays" + j).equals("")){
				int noOfDays = Integer.parseInt(request.getParameter("noOfDays" + j));
				noOfDaysList.add(noOfDays);
								
			}else {
				noOfDaysList.add(0);
			}
			
			if(request.getParameter("total" + j) != null && !request.getParameter("total" + j).equals("")){
				int total = Integer.parseInt(request.getParameter("total" + j));
				totalList.add(total);
			}else {
				totalList.add(0);
			}
		
			String remarks = "";
			if(request.getParameter("remarks" + j) != null && !request.getParameter("remarks" + j).equals("")){
				remarks = request.getParameter("remarks" + j);
				remarksList.add(remarks);
			}else {
				remarksList.add("");
			}
		
			if(!pvmsNo.equals("")){
				pvmsNoList.add(pvmsNo);
			}

			j++;
		}
		mapForDS.put("referedToMH", referedToMH);
		mapForDS.put("mh", mh);
		mapForDS.put("mhDepartment", mhDepartment);
		mapForDS.put("mhReferredFor", mhReferredFor);
		mapForDS.put("disposal", disposal);
		mapForDS.put("days", days);
		mapForDS.put("systemDiagnosisId", systemDiagnosisId);
		mapForDS.put("diagnosisIdAray", diagnosisIdAray);
		mapForDS.put("chargeCodeIdList", chargeCodeIdList);
		mapForDS.put("referToMhList", referToMhList);
		mapForDS.put("pvmsNoList", pvmsNoList);
		mapForDS.put("frequencyList", frequencyList);
		mapForDS.put("ctList", ctList);
		mapForDS.put("dosageList", dosageList);
		mapForDS.put("remarksList", remarksList);
		mapForDS.put("routeList", routeList);
		mapForDS.put("otherMedicineList", otherMedicineList);
		mapForDS.put("totalList", totalList);
		mapForDS.put("noOfDaysList", noOfDaysList);
		mapForDS.put("box", box);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean bool = false;
		boolean bool1 = false;
		returnMap = dentalHandlerService.submitDentalTreatmentDetails(box,mapForDS);
		if (returnMap.get("succesfullyAdded") != null) {
			bool = (Boolean) returnMap.get("succesfullyAdded");
		}
		if (returnMap.get("orderSeqNo") != null) {
			orderSeqNo = (String) returnMap.get("orderSeqNo");
		}
		String message = null;
		String jsp ="";
		boolean submitData = false;
		if (bool) {
			String departmentName = "";			
			String departmentCode = "";
			if(box.getInt("departmentId")!=0){
				Map<String, Object> deptMap = opdHandlerService
				.getDepartmentNameFromId(box.getInt("departmentId"));
				if (deptMap.get("deptName") != null) {
					departmentName = (String) deptMap.get("deptName");
				}
				if (deptMap.get("deptCode") != null) {
					departmentCode = (String) deptMap.get("deptCode");
				}
				mapForDS.put("deptId",deptId);
			}
			if (box.getString("flag").equals("dental")) {
				map = dentalHandlerService.getDentalWaitingList(mapForDS);
				message = "Patient Details Submitted.";
				jsp = "dentalMessage.jsp";
				submitData = true;
			}
		} else {
			map = dentalHandlerService.getDentalWaitingList(mapForDS);
			message = "Error Occurred in Submitting Details.";
			jsp = "dentalWaitingList.jsp";
		}
		
		map.put("message", message);
		map.put("deptId", box.getInt("departmentId"));
		map.put("visitNoForReport", box.getInt(VISIT_NUMBER));
		map.put("orderNoForReport", orderSeqNo);
		map.put("serviceNoForReport", box.getString(SERVICE_NO));
		map.put("visitId", box.getInt("visitId"));
		map.put("hinNoForReport", box.getString(HIN_NO));
		map.put("hospitalIdForReport", box.getString("hospitalIdForReport"));
		//map.put("referedToMH", referedToMH);
		map.put("submitData", submitData);
		//jsp = jsp + ".jsp";
	   	 title = "Dental Treatment";
	 	 map.put("contentJsp", jsp);
		 map.put("title", title);

		 return new ModelAndView("indexB", "map", map);
	 }
	 
	 public ModelAndView getDentalProcedureForAutoComplete(HttpServletRequest request, HttpServletResponse response) {
			String itemNameField = "";
			String autoHint = "";
			Map<String, Object> map = new HashMap<String, Object>();

			try {
				if (request.getParameter("requiredField") != null) {
					itemNameField = (request.getParameter("requiredField"));
				}
				if (request.getParameter(itemNameField) != null) {
					autoHint = (request.getParameter(itemNameField));
				}
				map.put("autoHint", autoHint);
				map = dentalHandlerService.getDentalProcedureForAutoComplete(map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			String jsp = "responseProcedureList";

			return new ModelAndView(jsp, "map", map);
		}
	 public ModelAndView showPatientMedicalDentalCaseSheetReport(HttpServletRequest request, HttpServletResponse response) {
		 Map<String, Object> map = new HashMap<String, Object>();
			int visiNo = 0;
			String serviceNo = "";
			String hinNo = "";
			int visit_id = 0;
			int hospitalIdForReport=0;
			if (request.getParameter(SERVICE_NO_FOR_REPORT) != null) {
				serviceNo = request.getParameter(SERVICE_NO_FOR_REPORT);
			}
			if (request.getParameter(VISIT_NUMBER_FOR_REPORT) != null) {
				visiNo = Integer.parseInt(request
						.getParameter(VISIT_NUMBER_FOR_REPORT));
			}
			if (request.getParameter(HIN_NO_FOR_REPORT) != null) {
				hinNo = request.getParameter(HIN_NO_FOR_REPORT);
			}
			if(request.getParameter(VISIT_ID)!= null){
				visit_id = Integer.parseInt(request.getParameter(VISIT_ID));
			}
			
			System.out.println("vis="+visit_id);
			
			if(request.getParameter("hospitalIdForReport")!= null){
				hospitalIdForReport = Integer.parseInt(request.getParameter("hospitalIdForReport"));
			}
			
			HttpSession session = request.getSession();
			//int hospitalId = (Integer) session.getAttribute("hospitalId");
			
			Map<String, Object> detailsMap = new HashMap<String, Object>();

			System.out.println("hospitalId=="+hospitalIdForReport);
			detailsMap = opdHandlerService.getConnectionForReport();
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("visit_id", visit_id);
			parameters.put("hospitalId", hospitalIdForReport);
			parameters.put("visitNo", visiNo);
			parameters.put("serviceNo", serviceNo);
			parameters.put("hinNo", hinNo);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
					"/reports/"));
			
			HMSUtil.generateReport("dentalCaseSheet", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		
			return null;
	}
	 private JasperReport getCompiledReport(String fileName) throws JRException {

			File reportFile = new File(getServletContext().getRealPath(
					"/reports/" + fileName + ".jasper"));
			JasperReport jasperReport = (JasperReport) JRLoader
					.loadObject(reportFile.getPath());

			return jasperReport;
		}

//---Dental Help
	 
	 public void showDentalHelp(HttpServletRequest request,HttpServletResponse response) {

			
			String userHome = getServletContext().getRealPath("");
			String fileSeparator = System.getProperty("file.separator");
			String uploadURL = userHome
					+ fileSeparator
					+ "help"
					+ fileSeparator;
					
		
			
			try {
				
				response.setContentType("application/pdf");
				
				response.setHeader("Content-Disposition", "attachment;filename="
						+ java.net.URLEncoder.encode("Dental.pdf")
						+ "");

				File f = new File(uploadURL + "/Dental.pdf");
				InputStream in = new FileInputStream(f);
				response.getOutputStream().flush();
				ServletOutputStream outs = response.getOutputStream();

				long length = f.length();

				if (length > Integer.MAX_VALUE) {
					// File is too large
				}

				// Create the byte array to hold the data
				byte[] bytes = new byte[(int) length];

				int offset = 0;
				int numRead = 0;
				while (offset < bytes.length
						&& (numRead = in.read(bytes, offset, bytes.length - offset)) >= 0) {
					offset += numRead;
				}

				if (offset < bytes.length) {
				}
				outs.write(bytes);
				in.close();

			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

		
		}
	 
	 public ModelAndView showPatientPreviousVisitForDental(
				HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession();
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> mapForDS = new HashMap<String, Object>();
			int hinId = Integer.parseInt(request.getParameter("hinId"));
			if(request.getParameter("deptId")!=null){
				int deptId = Integer.parseInt(request.getParameter("deptId"));
				mapForDS.put("deptId", deptId);
			}
			int visitNo = 0;
			if(request.getParameter("visitNo")!=null){
			Integer.parseInt(request.getParameter("visitNo"));
				mapForDS.put("visitNo", visitNo);
			}
		
			mapForDS.put("hinId", hinId);
			String backFlag = "";
			if(request.getParameter("backFlag")!=null){
				backFlag = request.getParameter("backFlag");
			}
			
			map = dentalHandlerService.getPreviousPatientVisitForDental(mapForDS);
			if(request.getParameter("visitId")!=null){
				int visitId = Integer.parseInt(request.getParameter("visitId"));
				map.put("visitId", visitId);
			}
			if(request.getParameter("token")!=null){
				int token = Integer.parseInt(request.getParameter("token"));
				map.put("token", token);
			}
			if(request.getParameter("flag")!=null){
				map.put("flag", request.getParameter("flag"));
			}
			String medExamType = "";		
			if(request.getParameter("jspheading")!= null)
			  {
				medExamType = request.getParameter("jspheading");	
			  }
		   String url= "/hms/hms/medicalExam?method=showAnnualMedExamJsp";
			map.put("visitNoForJsp", visitNo);
			map.put("url",url);
			if(backFlag.equals("OPD") || backFlag.equals("dental")){
				jsp = "dental_previousVisitForViewScreen";
			}else{
				
				map.put("contentJsp", "dental_previousVisitForViewScreen");
				jsp = "index";
			}
			title = "Patient Previous Visit";
			map.put("backFlag", backFlag);
			map.put("medExamType",medExamType);
		
		
			map.put("title", title);

			return new ModelAndView(jsp, "map", map);
		}
	 public ModelAndView getPatientOpdDentalDetails(HttpServletRequest request,HttpServletResponse response) {
		 Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Map<String, Object> dataMap = new HashMap<String, Object>();

			int hinId = 0;
			int visitNo = 0;
			int deptId = 0;
			int current_visitNo = 0;
			int token = 0;
			String flag = null;
			if (request.getParameter(HIN_ID) != null) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
			}
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
			}

			if (request.getParameter(VISIT_NUMBER) != null) {
				visitNo = Integer.parseInt(request.getParameter(VISIT_NUMBER));
			}
			current_visitNo = visitNo;
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (request.getParameter("token") != null) {
				token = Integer.parseInt(request.getParameter("token"));
			}
			if (flag.equalsIgnoreCase("prev")) {
				visitNo = visitNo - 1;
			}
			if (flag.equalsIgnoreCase("next")) {
				visitNo = visitNo + 1;
			}
			if (flag.equalsIgnoreCase("current")) {
				visitNo = visitNo;
			}

			dataMap.put("current_visitNo", current_visitNo);
			dataMap.put("visitNo", visitNo);
			dataMap.put("hinId", hinId);
			dataMap.put("deptId", deptId);
			map = dentalHandlerService.getPatientOpdDentalDetails(dataMap);
			dataMap = dentalHandlerService.getOPDDetailsForOpdDentalUpdate(dataMap);
			/*if (dataMap.get("listOfOpd3") != null) {
				map.put("listOfOpd3", (List) dataMap.get("listOfOpd3"));

			}
			if (dataMap.get("listOfOpd2") != null) {
				map.put("listOfOpd2", (List) dataMap.get("listOfOpd2"));

			}
			if (dataMap.get("listOfOpd1") != null) {
				map.put("listOfOpd1", (List) dataMap.get("listOfOpd1"));

			}
			if (dataMap.get("deptList") != null) {
				map.put("deptList", (List<MasDepartment>) dataMap.get("deptList"));

			}*/
			if (dataMap.get("templateList") != null) {
				map.put("templateList", (List<OpdTemplate>) dataMap
						.get("templateList"));
			}
			if (dataMap.get("frequencyList") != null) {
				map.put("frequencyList", (List<MasFrequency>) dataMap
						.get("frequencyList"));
			}

			// String jsp = "";

			String jsp = "dental_viewPreviousVisit.jsp";
			// String includedJsp = "updateOpdMain.jsp";
			map.put("token", token);
			map.put("includedJsp", jsp);
			// jsp = "updateOpd.jsp";
			map.put("contentJsp", jsp);

			return new ModelAndView("indexB", "map", map);
		}
	 
	 public ModelAndView showDentalPopupTokenJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> mapForDS = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId = 0;
			if (session.getAttribute("hospitalId") != null)
				hospitalId = (Integer)session.getAttribute("hospitalId");
				mapForDS.put("hospitalId", hospitalId);
			if(session.getAttribute("deptId")!=null){
				int deptId = (Integer) session.getAttribute("deptId");
				mapForDS.put("deptId", deptId);
			}else if(request.getParameter("deptId")!=null){
				int deptId = Integer.parseInt(request.getParameter("deptId"));
			 	mapForDS.put("deptId", deptId);
			}
			Users user = new Users();
			int empId = 0;
			if(session.getAttribute("users")!=null){
				user = (Users)session.getAttribute("users");
				mapForDS.put("empId", user.getEmployee().getId());
			}
			map = dentalHandlerService.showDentalPopupTokenJsp(mapForDS);
			List<Visit> visitTokenList = new ArrayList<Visit>();
			if (map.get("visitTokenList") != null) {
				visitTokenList = (List<Visit>)map.get("visitTokenList");
			}
			jsp = "window_popupForDentalJsp";
			title = "Token Number";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView(jsp, "map", map);
		}
	 public ModelAndView showDentalRegisterReportJsp(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			String jsp = "";
			int hospitalId = 0;
			HttpSession session = request.getSession();
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			map = dentalHandlerService.getDetailsForReport(hospitalId);
			jsp ="dentalRegisterReport"+ ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
	 public ModelAndView showDentalRegisterOnScreen(HttpServletRequest request,HttpServletResponse response) {
		 Map<String, Object> map = new HashMap<String, Object>();
			int hospitalId = 0;
			HttpSession session = request.getSession();
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			Box box = HMSUtil.getBox(request);
			box.put("hospitalId", hospitalId);
			map = dentalHandlerService.getDentalRegisterData(box);
			String jsp = "dentalRegister.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
	 public ModelAndView showDentalRegisterReport(HttpServletRequest request,
				HttpServletResponse response) {
			Date fromDate = null;
			Date toDate = null;
			int hospitalId = 0;
			HttpSession session = request.getSession();
			Box box = null;
			if(session.getAttribute("box")!=null){
				box = (Box)session.getAttribute("box");
			}else{
				box = HMSUtil.getBox(request);
			}
			
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			if (!box.getString(FROM_DATE).equals("")) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE));
			}
			
			if (!box.getString(TO_DATE).equals("")) {
				toDate = HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE));
			}
			String qry = "";
			if(box.getInt(SERVICE_TYPE_ID)!=0){
				qry += " and patient.service_type_id = "+box.getInt(SERVICE_TYPE_ID)+"";
			}
			if(box.getInt(SERVICE_STATUS_ID)!=0){
				qry += " and patient.service_status_id = "+box.getInt(SERVICE_STATUS_ID)+"";
			}
			if(box.getInt("fromRankId")!=0 && box.getInt("toRankId")!=0){
				qry += " and patient.rank_id between "+box.getInt("fromRankId")+" and "+box.getInt("toRankId");
			}
			if(box.getInt(RANK_CATEGORY_ID)!=0){
				qry += " and mas_rank.rank_category_id = "+box.getInt(RANK_CATEGORY_ID)+"";
			}
			if(box.getInt(TRADE_ID)!=0){
				qry += " and patient.trade_id = "+box.getInt(TRADE_ID)+"";
			}
			if(box.getInt(UNIT_ID)!=0){
				qry += " and patient.unit_id = "+box.getInt(UNIT_ID)+"";
			}
			if(box.getInt(SECTION_ID)!=0){
				qry += " and patient.section_id = "+box.getInt(SECTION_ID)+"";
			}
			if(box.getInt(MARITAL_STATUS_ID)!=0){
				qry += " and patient.marital_status_id = "+box.getInt(MARITAL_STATUS_ID)+"";
			}
			if(box.getInt(SEX_ID)!=0){
				qry += " and patient.sex_id = "+box.getInt(SEX_ID)+"";
			}
			if(box.getInt(RELATION_ID)!=0){
				qry += " and patient.relation_id = "+box.getInt(RELATION_ID)+"";
			}
			if (!(box.getString(SERVICE_NO).equals(""))) {
				qry += " and patient.service_no='"+HMSUtil.restrictMetaChar(box.getString(SERVICE_NO))+"'";
			}
			if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
					&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
				String fromAge = box.getString("fromAge");
				String toAge = box.getString("toAge");
				qry +=" and substr(patient.age,0,INSTR(patient.age,' ')) >="+fromAge+" " +
						" and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))='"+box.getString("fromAgeUnit")+"'" +
						" and substr(patient.age,0,INSTR(patient.age,' ')) <="+toAge+" " +
						" and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))='"+box.getString("toAgeUnit")+"'";
				
			}
			if (!(box.getString("fromServ").equals("")) && !(box.getString("fromServUnit").equals(""))
					&& !(box.getString("toServ").equals("")) && !(box.getString("toServUnit").equals(""))) {
				String fromServ = box.getString("fromServ");
				String toServ =box.getString("toServ");
				qry +=" and patient.service_years >="+fromServ+" " +
						" and  total_service_period='"+box.getString("fromServUnit")+"'" +
						" and patient.service_years <="+toServ+" " +
						" and  total_service_period='"+box.getString("toServUnit")+"'";
				
			}
			if(box.getInt(CONSULTING_DOCTOR)!=0){
				qry += " and visit.doctor_id = "+box.getInt(CONSULTING_DOCTOR)+"";
			}
		/*	if (!(box.getString("icd").equals(""))) {
				String icd = box.getString("icd");
				 int index1=icd.lastIndexOf("[");
				  int index2=icd.lastIndexOf("]");
				   index1++;
				   String icdCode =""+icd.substring(index1, index2);
				qry += " and icd.icd_code='"+icdCode+"'";
			}
			if (!(box.getString("icdNo").equals(""))) {
				qry += " and icd.icd_code='"+box.getString("icdNo")+"'";
			}*/
			if (!(box.getString("procedure").equals(""))) {
				String procedure = box.getString("procedure");
				 int index1=procedure.lastIndexOf("[");
				  int index2=procedure.lastIndexOf("]");
				   index1++;
				   int procedureId =Integer.parseInt(procedure.substring(index1, index2));
				qry += " and mas_nursing_care.nursing_id ="+procedureId+" ";
			}
			
			if(!(box.getString("disposal").equals(""))){
				qry += " and opd.disposal = '"+HMSUtil.restrictMetaChar(box.getString("disposal"))+"'";
			}
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			detailsMap = dentalHandlerService.getConnectionForReport();
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("fromDate", fromDate);
			parameters.put("toDate", toDate);
			parameters.put("qry", qry);
			parameters.put("hospitalId", hospitalId);
			HMSUtil.generateReport("DENTAL STATISTICS", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
			return null;
		}
	 public ModelAndView getPocedureList(HttpServletRequest request,
				HttpServletResponse response) {

			HttpSession session = request.getSession();
			String itemNameField = "";
			String autoHint = "";

			Map<String, Object> map = new HashMap<String, Object>();
			try {
				if (request.getParameter("requiredField") != null) {
					itemNameField = (request.getParameter("requiredField"));
				}
				if (request.getParameter(itemNameField) != null) {
					autoHint = (request.getParameter(itemNameField));
				}

				map.put("autoHint", autoHint);
				map = dentalHandlerService.getPocedureList(map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "responseForProcedureAutoComplete";
			return new ModelAndView(jsp, "map", map);
		}

	 
}
