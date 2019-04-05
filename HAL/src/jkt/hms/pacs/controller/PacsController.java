package jkt.hms.pacs.controller;

import static jkt.hms.util.RequestConstants.USERS;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;
import jkt.hms.masters.business.PacsTemplate;
import jkt.hms.masters.business.Users;
import jkt.hms.pacs.handler.PacsHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//Ranjesh Prasad: PACS Integration
public class PacsController extends MultiActionController{

	PacsHandlerService pacsHandlerService = null;
	String jsp = "";
	String title = "";
	String message = "";
	String userName = "";
	Map<String, Object> map = new HashMap<String, Object>();
	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();

	public PacsHandlerService getPacsHandlerService() {
		return pacsHandlerService;
	}

	public void setPacsHandlerService(PacsHandlerService pacsHandlerService) {
		this.pacsHandlerService = pacsHandlerService;
	}
	
	public ModelAndView showPacsPendingJsp(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int depId=0;
		String gsonURL="";
		if(request.getParameter("patientId")!=null && request.getParameter("patientId")!=""){
			gsonURL+="&patientId="+request.getParameter("patientId");
		}if(request.getParameter("patientName")!=null && request.getParameter("patientName")!=""){
			gsonURL+="&patientName="+request.getParameter("patientName");
		}if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			gsonURL+="&fromDate="+request.getParameter("fromDate");
			map.put("fromDate", request.getParameter("fromDate"));
		}if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			gsonURL+="&toDate="+request.getParameter("toDate");
			map.put("toDate", request.getParameter("toDate"));
		}
		if(request.getParameter("chk_cr")!=null && request.getParameter("chk_cr")!=""){
			gsonURL+="&chk_cr="+request.getParameter("chk_cr");
		}
		if(request.getParameter("chk_ct")!=null && request.getParameter("chk_ct")!=""){
			gsonURL+="&chk_ct="+request.getParameter("chk_ct");
		}
		if(request.getParameter("chk_us")!=null && request.getParameter("chk_us")!=""){
			gsonURL+="&chk_us="+request.getParameter("chk_us");
		}
		if(request.getParameter("chk_mr")!=null && request.getParameter("chk_mr")!=""){
			gsonURL+="&chk_mr="+request.getParameter("chk_mr");
		}
		if(request.getParameter("chk_dx")!=null && request.getParameter("chk_dx")!=""){
			gsonURL+="&chk_dx="+request.getParameter("chk_dx");
		} 
		 
		jsp = "pacs/pacsPatientPendingList";
		jsp += ".jsp";
		title = "Pacs Waiting List";
		map.put("cr",request.getParameter("chk_cr"));
		map.put("ct",request.getParameter("chk_ct"));
		map.put("mr",request.getParameter("chk_mr"));
		map.put("us",request.getParameter("chk_us"));
		map.put("dx",request.getParameter("chk_dx"));
		map.put("gsonURL", gsonURL);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map); 
	}
	
	public ModelAndView showRadiologyReportList(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int depId=0;
		String gsonURL="";
		if(request.getParameter("patientId")!=null && request.getParameter("patientId")!=""){
			gsonURL+="&patientId="+request.getParameter("patientId");
		}if(request.getParameter("patientName")!=null && request.getParameter("patientName")!=""){
			gsonURL+="&patientName="+request.getParameter("patientName");
		}if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			gsonURL+="&fromDate="+request.getParameter("fromDate");
			map.put("fromDate", request.getParameter("fromDate"));
		}if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			gsonURL+="&toDate="+request.getParameter("toDate");
			map.put("toDate", request.getParameter("toDate"));
		}
		if(request.getParameter("chk_cr")!=null && request.getParameter("chk_cr")!=""){
			gsonURL+="&chk_cr="+request.getParameter("chk_cr");
		}
		if(request.getParameter("chk_ct")!=null && request.getParameter("chk_ct")!=""){
			gsonURL+="&chk_ct="+request.getParameter("chk_ct");
		}
		if(request.getParameter("chk_us")!=null && request.getParameter("chk_us")!=""){
			gsonURL+="&chk_us="+request.getParameter("chk_us");
		}
		if(request.getParameter("chk_mr")!=null && request.getParameter("chk_mr")!=""){
			gsonURL+="&chk_mr="+request.getParameter("chk_mr");
		}
		if(request.getParameter("chk_dx")!=null && request.getParameter("chk_dx")!=""){
			gsonURL+="&chk_dx="+request.getParameter("chk_dx");
		} 
		 
		jsp = "pacs/pacsReportList";
		jsp += ".jsp";
		title = "Pacs Waiting List";
		map.put("cr",request.getParameter("chk_cr"));
		map.put("ct",request.getParameter("chk_ct"));
		map.put("mr",request.getParameter("chk_mr"));
		map.put("us",request.getParameter("chk_us"));
		map.put("dx",request.getParameter("chk_dx"));
		map.put("gsonURL", gsonURL);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map); 
	}
	
	public ModelAndView pacsUtil(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		Map<String, Object> map=new HashMap<String, Object>();
		String action = request.getParameter("action");
		List<PacsPatient> patientList = new ArrayList<PacsPatient>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		response.setContentType("application/json");
		String filePath=getServletContext().getRealPath("src/jdbc.properties");
		map.put("filePath", filePath);
		HttpSession session = request.getSession();
		if (session.getAttribute("empId") != null) {
			map.put("radioDocId", (Integer)session.getAttribute("empId"));
		}
		if (action != null) {
				try {
					if (action.equals("list")) {
						// Fetch Data from User Table
						int startPageIndex = Integer.parseInt(request.getParameter("jtStartIndex"));
						int recordsPerPage = Integer.parseInt(request.getParameter("jtPageSize"));
						String query="";
						map.put("startPageIndex", startPageIndex);
						map.put("recordsPerPage", recordsPerPage);
						if(request.getParameter("patientId")!=null && request.getParameter("patientId")!=""){
							query+=" and p.pat_id like '1"+request.getParameter("patientId")+"%'"; 
						}if(request.getParameter("patientName")!=null && request.getParameter("patientName")!=""){
							query+=" and p.pat_name like '%"+request.getParameter("patientName")+"%'";
						}
						/*if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!="" && request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
							String[] fromDate=(""+request.getParameter("fromDate")).split("/");
							String[] toDate=(""+request.getParameter("toDate")).split("/");
							query+=" and p.created_time between '"+fromDate[0]+"/"+fromDate[1]+"/"+fromDate[2]+"' and '"+toDate[0]+"/"+toDate[1]+"/"+toDate[2]+"'";
						 
						}*/
						/*System.out.println("chkct="+request.getParameter("chk_ct"));
						System.out.println("chkus="+request.getParameter("chk_us"));
						System.out.println("chkdx="+request.getParameter("chk_dr"));
						System.out.println("chkmr="+request.getParameter("chk_mr"));*/
						if(request.getParameter("chk_ct")!=null && request.getParameter("chk_ct")!=""){ 
								query+=" and s.mods_in_study like '%"+request.getParameter("chk_ct")+"%'"; 
						} 
						
						
						
						/*if(request.getParameter("chk_mr")!=null && request.getParameter("chk_mr")!=""){
							if(request.getParameter("chk_ct")!=null && request.getParameter("chk_ct")!="" ){
								query+=" or s.mods_in_study like '%"+request.getParameter("chk_mr")+"%'";
							}
							else{
								query+=" and s.mods_in_study like '%"+request.getParameter("chk_mr")+"%'";
							}
						} */
						
						if(request.getParameter("chk_us")!=null && request.getParameter("chk_us")!=""){
							if(request.getParameter("chk_ct")!=null && request.getParameter("chk_ct")!="" ){
								query+=" or s.mods_in_study like '%"+request.getParameter("chk_us")+"%'";
							}
							else{
								query+=" and s.mods_in_study like '%"+request.getParameter("chk_us")+"%'";
							}
						} 

						if(request.getParameter("chk_dx")!=null && request.getParameter("chk_dx")!=""){
							if(request.getParameter("chk_us")!=null && request.getParameter("chk_us")!="" || request.getParameter("chk_ct")!=null && request.getParameter("chk_ct")!="" ){
								query+=" or s.mods_in_study like '%"+request.getParameter("chk_dx")+"%'";
							}
							else{
								query+=" and s.mods_in_study like '%"+request.getParameter("chk_dx")+"%'";
							}
						} 
						System.out.println("reportStatus="+request.getParameter("reportTypeId"));
						
						if(request.getParameter("reportTypeId") !=null && request.getParameter("reportTypeId") != "-1")
						{
							query+=" and p.report_status="+request.getParameter("reportTypeId")+"" ;
						}
						
						 
						map.put("query", query);
						// Fetch Data from Student Table
						patientList = pacsHandlerService.getAllPacsPatients(map);
						// Get Total Record Count for Pagination
						int userCount = pacsHandlerService.getPacsPatientsCount(map);
						// Return in the format required by jTable plugin
						JSONROOT.put("Result", "OK");
						JSONROOT.put("Records", patientList);
						JSONROOT.put("TotalRecordCount", userCount);
						// Convert Java Object to Json
						String jsonArray = gson.toJson(JSONROOT);
						response.getWriter().print(jsonArray);
					}else if (action.equals("create") || action.equals("update")) {/*
					}
						Student student = new Student();
						if (request.getParameter("studentId") != null) {
							int studentId = Integer.parseInt(request.getParameter("studentId"));
							student.setStudentId(studentId);
						}

						if (request.getParameter("name") != null) {
							String name = request.getParameter("name");
							student.setName(name);
						}

						if (request.getParameter("department") != null) {
							String department = request.getParameter("department");
							student.setDepartment(department);
						}

						if (request.getParameter("emailId") != null) {
							String emailId = request.getParameter("emailId");
							student.setEmailId(emailId);
						}

						if (action.equals("create")) {
							// Create new record
							dao.addStudent(student);
						} else if (action.equals("update")) {
							// Update existing record
							dao.updateStudent(student);
						}

						// Return in the format required by jTable plugin
						JSONROOT.put("Result", "OK");
						JSONROOT.put("Record", student);

						// Convert Java Object to Json
						String jsonArray = gson.toJson(JSONROOT);
						response.getWriter().print(jsonArray);
					*/} else if (action.equals("delete")) {
						// Delete record
						if (request.getParameter("studentId") != null) {
							int patientId = Integer.parseInt(request.getParameter("patientId"));
							pacsHandlerService.deletePatient(patientId);

							// Return in the format required by jTable plugin
							JSONROOT.put("Result", "OK");

							// Convert Java Object to Json
							String jsonArray = gson.toJson(JSONROOT);
							response.getWriter().print(jsonArray);
						}
					}
				} catch (Exception ex) {
					JSONROOT.put("Result", "ERROR");
					JSONROOT.put("Message", ex.getMessage());
					String error = gson.toJson(JSONROOT);
					response.getWriter().print(error);
				}
			}
		return null;
	}
	
	public ModelAndView pacsUtilforRadiologyReport(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		Map<String, Object> map=new HashMap<String, Object>();
		String action = request.getParameter("action");
		List<PacsPatient> patientList = new ArrayList<PacsPatient>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		response.setContentType("application/json");
		String filePath=getServletContext().getRealPath("src/jdbc.properties");
		map.put("filePath", filePath);
		HttpSession session = request.getSession();
		if (session.getAttribute("empId") != null) {
			map.put("radioDocId", (Integer)session.getAttribute("empId"));
		}
		if (action != null) {
				try {
					if (action.equals("list")) {
						// Fetch Data from User Table
						int startPageIndex = Integer.parseInt(request.getParameter("jtStartIndex"));
						int recordsPerPage = Integer.parseInt(request.getParameter("jtPageSize"));
						String query="";
						map.put("startPageIndex", startPageIndex);
						map.put("recordsPerPage", recordsPerPage);
						if(request.getParameter("patientId")!=null && request.getParameter("patientId")!=""){
							query+=" and p.pat_id like '1"+request.getParameter("patientId")+"%'"; 
						}if(request.getParameter("patientName")!=null && request.getParameter("patientName")!=""){
							query+=" and p.pat_name like '%"+request.getParameter("patientName")+"%'";
						}
						/*if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!="" && request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
							String[] fromDate=(""+request.getParameter("fromDate")).split("/");
							String[] toDate=(""+request.getParameter("toDate")).split("/");
							query+=" and p.created_time between '"+fromDate[0]+"/"+fromDate[1]+"/"+fromDate[2]+"' and '"+toDate[0]+"/"+toDate[1]+"/"+toDate[2]+"'";
						 
						}*/
						/*System.out.println("chkct="+request.getParameter("chk_ct"));
						System.out.println("chkus="+request.getParameter("chk_us"));
						System.out.println("chkdx="+request.getParameter("chk_dr"));
						System.out.println("chkmr="+request.getParameter("chk_mr"));*/
						if(request.getParameter("chk_ct")!=null && request.getParameter("chk_ct")!=""){ 
								query+=" and s.mods_in_study like '%"+request.getParameter("chk_ct")+"%'"; 
						} 
						
						
						
						/*if(request.getParameter("chk_mr")!=null && request.getParameter("chk_mr")!=""){
							if(request.getParameter("chk_ct")!=null && request.getParameter("chk_ct")!="" ){
								query+=" or s.mods_in_study like '%"+request.getParameter("chk_mr")+"%'";
							}
							else{
								query+=" and s.mods_in_study like '%"+request.getParameter("chk_mr")+"%'";
							}
						} */
						
						if(request.getParameter("chk_us")!=null && request.getParameter("chk_us")!=""){
							if(request.getParameter("chk_ct")!=null && request.getParameter("chk_ct")!="" ){
								query+=" or s.mods_in_study like '%"+request.getParameter("chk_us")+"%'";
							}
							else{
								query+=" and s.mods_in_study like '%"+request.getParameter("chk_us")+"%'";
							}
						} 

						if(request.getParameter("chk_dx")!=null && request.getParameter("chk_dx")!=""){
							if(request.getParameter("chk_us")!=null && request.getParameter("chk_us")!="" || request.getParameter("chk_ct")!=null && request.getParameter("chk_ct")!="" ){
								query+=" or s.mods_in_study like '%"+request.getParameter("chk_dx")+"%'";
							}
							else{
								query+=" and s.mods_in_study like '%"+request.getParameter("chk_dx")+"%'";
							}
						} 
						System.out.println("reportStatus="+request.getParameter("reportTypeId"));
						
						if(request.getParameter("reportTypeId") !=null && request.getParameter("reportTypeId") != "-1")
						{
							query+=" and p.report_status="+request.getParameter("reportTypeId")+"" ;
						}
						
						 
						map.put("query", query);
						// Fetch Data from Student Table
						patientList = pacsHandlerService.getAllPacsPatientsforRadiologyReport(map);
						// Get Total Record Count for Pagination
						int userCount = pacsHandlerService.getPacsPatientsCount(map);
						// Return in the format required by jTable plugin
						JSONROOT.put("Result", "OK");
						JSONROOT.put("Records", patientList);
						JSONROOT.put("TotalRecordCount", userCount);
						// Convert Java Object to Json
						String jsonArray = gson.toJson(JSONROOT);
						response.getWriter().print(jsonArray);
					}else if (action.equals("create") || action.equals("update")) {/*
					}
						Student student = new Student();
						if (request.getParameter("studentId") != null) {
							int studentId = Integer.parseInt(request.getParameter("studentId"));
							student.setStudentId(studentId);
						}

						if (request.getParameter("name") != null) {
							String name = request.getParameter("name");
							student.setName(name);
						}

						if (request.getParameter("department") != null) {
							String department = request.getParameter("department");
							student.setDepartment(department);
						}

						if (request.getParameter("emailId") != null) {
							String emailId = request.getParameter("emailId");
							student.setEmailId(emailId);
						}

						if (action.equals("create")) {
							// Create new record
							dao.addStudent(student);
						} else if (action.equals("update")) {
							// Update existing record
							dao.updateStudent(student);
						}

						// Return in the format required by jTable plugin
						JSONROOT.put("Result", "OK");
						JSONROOT.put("Record", student);

						// Convert Java Object to Json
						String jsonArray = gson.toJson(JSONROOT);
						response.getWriter().print(jsonArray);
					*/} else if (action.equals("delete")) {
						// Delete record
						if (request.getParameter("studentId") != null) {
							int patientId = Integer.parseInt(request.getParameter("patientId"));
							pacsHandlerService.deletePatient(patientId);

							// Return in the format required by jTable plugin
							JSONROOT.put("Result", "OK");

							// Convert Java Object to Json
							String jsonArray = gson.toJson(JSONROOT);
							response.getWriter().print(jsonArray);
						}
					}
				} catch (Exception ex) {
					JSONROOT.put("Result", "ERROR");
					JSONROOT.put("Message", ex.getMessage());
					String error = gson.toJson(JSONROOT);
					response.getWriter().print(error);
				}
			}
		return null;
	}
	
	public ModelAndView getPreviousVisit(HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> details=new HashMap<String, Object>();
		String patientId="";
		String visitDate="";
		String visitId="";
		if(request.getParameter("patientId")!=null && request.getParameter("patientId")!=""){
			patientId=request.getParameter("patientId");
			details.put("patientId", patientId);
		}
		if(request.getParameter("visitDate")!=null && request.getParameter("visitDate")!=""){
			visitDate=request.getParameter("visitDate");
			details.put("visitDate", visitDate);
		}
		if(request.getParameter("visitId")!=null && request.getParameter("visitId")!=""){
			visitId=request.getParameter("visitId");
			details.put("visitId", visitId);
		}
		map = pacsHandlerService.getPreviousVisit(details);
		jsp = "/pacs/pacsPreviousVisitDetails";
		title = "Pacs Waiting List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getPacs(HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> dataMap=new HashMap<String, Object>();
		HttpSession session=request.getSession();
		int userId=0;
		int hospitalId=0;
		if(session.getAttribute("userId")!=null){
			userId=(Integer)session.getAttribute("userId");
		}
		if(session.getAttribute("hospitalId")!=null){
			hospitalId=(Integer)session.getAttribute("hospitalId");
		}
		dataMap.put("userId", userId);
		dataMap.put("hospitalId", hospitalId);
		map = pacsHandlerService.getPacsAuthenticationService(dataMap);
		jsp = "pacs/pacs";
		title = "Pacs Waiting List";
//		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView pacsRight(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> dataMap=new HashMap<String, Object>();
		map= pacsHandlerService.pacsRightsList(dataMap);
		jsp = "pacs/pacsRight.jsp";
		title = "Pacs Security Rights";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView getUsers(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> dataMap=new HashMap<String, Object>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		HttpSession session=request.getSession();
		int hospitalId=0;
		String loginName="";
		try{
			if(session.getAttribute("hospitalId")!=null){
				hospitalId=(Integer)session.getAttribute("hospitalId");
			}
			if(request.getParameter("loginName")!=null){
				loginName=(String)request.getParameter("loginName");
			}
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("loginName", loginName);
			JSONROOT.put("Result", "OK");
			JSONROOT.putAll(pacsHandlerService.getUsers(dataMap));
			// Convert Java Object to Json
			String jsonArray = gson.toJson(JSONROOT);
			response.getWriter().print(jsonArray);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public ModelAndView pacsRightSave(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> dataMap=new HashMap<String, Object>();
		InputStream inputStream = null; // input stream of the upload file
		MultipartFormDataRequest mrequest = null;
        if (MultipartFormDataRequest.isMultipartFormData(request))
           {
                try
                {
                    mrequest = new MultipartFormDataRequest(request);
                }
                catch (UploadException | IOException e)
                {
                    e.printStackTrace();
                }
           } 
    	Hashtable files = mrequest.getFiles();
		UploadFile signature = (UploadFile) files.get("signature");
		dataMap.put("signature", signature);
        Box box = HMSUtil.getBox(mrequest);
		dataMap.put("box", box);
		map= pacsHandlerService.pacsRightSave(dataMap);
		
		jsp = "pacs/pacsRight.jsp";
		title = "Pacs Security Rights";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	//for Pacs Reporting Template Creation JSP
		@SuppressWarnings("unchecked")
		public ModelAndView showPacsTemplate(HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession(); 
			Map<String, Object> map = new HashMap<String, Object>(); 
			String	jsp ="";
		 
			jsp="pacs/PacsTemplates.jsp";
			map.put("contentJsp", jsp); 
			return new ModelAndView("index", "map", map);
		}
		
		//for pacs save templates
		@SuppressWarnings("unchecked")
		public ModelAndView submitPacsTemplate(HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession(); 
			Map<String, Object> parameterMap = new HashMap<String, Object>(); 
			Map<String, Object> map = new HashMap<String, Object>(); 
			String	jsp ="";
			MultipartFormDataRequest mrequest = null;
			String tempcode=request.getParameter("tempcode");
			String tempname=request.getParameter("tempname");
			String temptype=request.getParameter("temptype");
			String result="";
			String message="";
			Users users = null;
			if (MultipartFormDataRequest.isMultipartFormData(request)) {
				try {

					mrequest = new MultipartFormDataRequest(request);
					if (mrequest.getParameter("abc") != null) {
						result = mrequest.getParameter("abc");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (session.getAttribute(USERS) != null) {
				users = (Users) session.getAttribute(USERS); 
			}
			
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
			
			PacsTemplate pacstemplate=new PacsTemplate();
			pacstemplate.setCode(tempcode);
			pacstemplate.setTemplateName(tempname);
			pacstemplate.setDescription(result);
			pacstemplate.setTemplateType(temptype);
			pacstemplate.setLastChgBy(users);
			pacstemplate.setLastChgDate(date);
			pacstemplate.setLastChgTime(time);
			pacstemplate.setStatus("y");
			parameterMap.put("pacstemplate", pacstemplate); 
			map = pacsHandlerService.submitPacsTemplate(parameterMap);
			Boolean saved = (Boolean) map.get("saved");
			if (saved == true) {
				message = "Template Saved Successfully !!";
			} else {
				message = "Some Problem Occured !!";
			}
			
			jsp="pacs/PacsTemplates.jsp";
			map.put("message", message);
			map.put("contentJsp", jsp); 
			return new ModelAndView("index", "map", map);
		}
		
		//search pacs templates
		@SuppressWarnings("unused")
		public ModelAndView getTemplatesForAutoComplete(HttpServletRequest request, HttpServletResponse response) {

			HttpSession session = request.getSession();
			String itemNameField = "";
			int deptId = 0;
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
				map = pacsHandlerService.getTemplatesForAutoComplete(map);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 
			String jsp = "pacs/responseForAutocompleteTemplates";  
			return new ModelAndView(jsp, "map", map);
		}
		
		//for get pacs templates
		@SuppressWarnings("unchecked")
		public ModelAndView searchtemplates(HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession(); 
			Map<String, Object> parameterMap = new HashMap<String, Object>(); 
			Map<String, Object> map = new HashMap<String, Object>(); 
			String	jsp ="";
			MultipartFormDataRequest mrequest = null;  
			String tempname=request.getParameter("tempname").toString();
			int index1=tempname.indexOf("[");
			int index2=tempname.indexOf("]");
			try {  
				String templateid=tempname.substring(index1+1, index2); 
				parameterMap.put("templateid",templateid);
				map = pacsHandlerService.getsearchtemplates(parameterMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp="pacs/PacsTemplates.jsp";
			map.put("message", message);
			map.put("contentJsp", jsp); 
			return new ModelAndView("index", "map", map);
		}
		
		//for pacs update templates
		@SuppressWarnings("unchecked")
		public ModelAndView updatePacsTemplate(HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession(); 
			Map<String, Object> parameterMap = new HashMap<String, Object>(); 
			Map<String, Object> map = new HashMap<String, Object>(); 
			String	jsp ="";
			MultipartFormDataRequest mrequest = null;
			String tempcode=request.getParameter("tempcode");
			String tempname=request.getParameter("tempname");
			String temptype=request.getParameter("temptype");
			String tempid=request.getParameter("tempid");
			String result="";
			String message="";
			Users users = null;
			if (MultipartFormDataRequest.isMultipartFormData(request)) {
				try {

					mrequest = new MultipartFormDataRequest(request);
					if (mrequest.getParameter("abc") != null) {
						result = mrequest.getParameter("abc");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (session.getAttribute(USERS) != null) {
				users = (Users) session.getAttribute(USERS); 
			}
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
			
			parameterMap.put("tempid", tempid);
			parameterMap.put("date", date);
			parameterMap.put("time", time);
			parameterMap.put("users", users);
			parameterMap.put("tempcode", tempcode); 
			parameterMap.put("tempname", tempname); 
			parameterMap.put("result", result); 
			parameterMap.put("temptype", temptype); 
			map = pacsHandlerService.updatePacsTemplate(parameterMap);
			Boolean saved = (Boolean) map.get("saved");
			if (saved == true) {
				message = "Template Updated Successfully !!";
			} else {
				message = "Some Problem Occured !!";
			}
			
			jsp="pacs/PacsTemplates.jsp";
			map.put("message", message);
			map.put("contentJsp", jsp); 
			return new ModelAndView("index", "map", map);
		}
		
		//for open history popup
		@SuppressWarnings("unchecked")
		public ModelAndView getPatientDetailForpacsHistory(HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession(); 
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> dataMap = new HashMap<String, Object>();
			String	jsp =""; 
			boolean createHistory =false;
			if(request.getParameter("createHistory")!=null && request.getParameter("createHistory").equalsIgnoreCase("y"))
				createHistory = true;

			String patientId=request.getParameter("patientId"); 
			dataMap.put("patientId",patientId); 
			map= pacsHandlerService.pacsPatientDetails(dataMap); 
			jsp="pacs/history"; 

			map.put("createHistory", createHistory);
			return new ModelAndView(jsp, "map", map);
		}
		
	//for pacs save patient history
	@SuppressWarnings("unchecked")
	public ModelAndView submitPatientHistory(HttpServletRequest request, HttpServletResponse response) throws UploadException, IOException {
		HttpSession session = request.getSession(); 
		boolean createHistory =false;
		if(request.getParameter("createHistory")!=null && request.getParameter("createHistory").equalsIgnoreCase("y"))
			createHistory = true;
		Map<String, Object> parameterMap = new HashMap<String, Object>(); 
		Map<String, Object> map = new HashMap<String, Object>(); 
		String	jsp =""; 
		String history=request.getParameter("history"); 
		String patientId=request.getParameter("patientId"); 
		String result="";
		String message="";
		Users users = null;
		MultipartFormDataRequest mrequest = new MultipartFormDataRequest(request);
		UploadFile file = null;
		InputStream is = null;
		 
		java.util.Hashtable files = mrequest.getFiles(); 
		if ((files != null) && (!files.isEmpty())) { 
			file = (UploadFile) files.get("hisfile"); 
			try {
				is = file.getInpuStream(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (session.getAttribute(USERS) != null) {
			users = (Users) session.getAttribute(USERS); 
		} 
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		
		parameterMap.put("date", date);
		parameterMap.put("time", time);
		parameterMap.put("users", users.getId());
		parameterMap.put("image", is); 
		parameterMap.put("history", history); 
		parameterMap.put("patientId", patientId);   
		map = pacsHandlerService.submitPatientHistory(parameterMap);
		Boolean saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "History Saved Successfully !!";
		} else {
			message = "Some Problem Occured !!";
		}
		
		jsp="pacs/pacsPatientPendingList.jsp";
		map.put("createHistory", createHistory);
		map.put("message", message);
		map.put("contentJsp", jsp); 
		return new ModelAndView("index", "map", map);
	}
	
	//for download history referral file
	public ModelAndView downloadHistoryFile(HttpServletRequest request,HttpServletResponse response) throws IOException { 
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>(); 
		String historyId=request.getParameter("historyId");	
		parameterMap.put("historyId", historyId);
		map = pacsHandlerService.downloadHistoryFile(parameterMap);
		InputStream is=(InputStream)map.get("is");  
        int fileLength = is.available();
        String fileName=request.getParameter("patientName")+"HistoryReferralFile.jpg";    
        int BUFFER_SIZE = 4096; 
        
       ServletContext context = getServletContext();

        // sets MIME type for the file download
        String mimeType = context.getMimeType(fileName);
        if (mimeType == null) {        
            mimeType = "application/octet-stream";
        }              
             
        // set content properties and header attributes for the response
        response.setContentType(mimeType);
        response.setContentLength(fileLength);
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", fileName);
        response.setHeader(headerKey, headerValue);

        // writes the file to the client
        OutputStream outStream = response.getOutputStream();
         
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;
         
        while ((bytesRead = is.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
             
        is.close();
        outStream.close();             
        
		return null; 
	}
	
	//for open Report popup
	@SuppressWarnings("unchecked")
	public ModelAndView getPatientDetailForpacsReport(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(); 
		Map<String, Object> map = new HashMap<String, Object>();  
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String	jsp =""; 
		boolean createReport =false;
		if(request.getParameter("createReport")!=null && request.getParameter("createReport").equalsIgnoreCase("y"))
			createReport = true;
		String patientId=request.getParameter("patientId"); 
		dataMap.put("patientId",patientId);
		map= pacsHandlerService.pacsPatientReportDetails(dataMap); 
		map.put("createReport", createReport);
		jsp="pacs/reportmain"; 
		return new ModelAndView(jsp, "map", map);
	}
	
	//Get template for report
	public ModelAndView getTemplateForRepors(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>(); 
		Map<String, Object> datamap = new HashMap<String, Object>(); 
		HttpSession session = request.getSession(); 
		Map<String, Object> parameterMap = new HashMap<String, Object>();   
		List<PacsTemplate> templateList = new ArrayList<PacsTemplate>();
		MultipartFormDataRequest mrequest = null;  
		boolean createReport =false;
		if(request.getParameter("createReport")!=null && request.getParameter("createReport").equalsIgnoreCase("y"))
			createReport = true;
		String tempname=(request.getParameter("tempname").toString()).trim();
		String patientId=request.getParameter("patientId");
		int index1=tempname.indexOf("[");
		int index2=tempname.indexOf("]");
		try { 
			String templateid=tempname.substring(index1+1, index2); 
			parameterMap.put("templateid",templateid); 
			datamap = pacsHandlerService.getsearchtemplates(parameterMap); 
		} catch (Exception e) {
			e.printStackTrace();
		}  
		parameterMap.put("patientId",patientId); 
		if(datamap.get("templateList")!=null){
			templateList=(List<PacsTemplate>)datamap.get("templateList");
		}
		map= pacsHandlerService.pacsPatientReportDetails(parameterMap);
		map.put("templateList",templateList); 
		jsp="pacs/reportmain";  
		map.put("createReport", createReport);
		return new ModelAndView(jsp, "map", map);
	}
	

	//for  save patient report
	@SuppressWarnings("unchecked")
	public ModelAndView submitPatientReport(HttpServletRequest request, HttpServletResponse response) throws UploadException, IOException {
		HttpSession session = request.getSession(); 
		Map<String, Object> parameterMap = new HashMap<String, Object>(); 
		Map<String, Object> map = new HashMap<String, Object>(); 
		String	jsp =""; 
		String reportStatus=request.getParameter("reportStatus"); 
		String patientId=request.getParameter("patientId"); 
		String result="";
		String message="";
		Users users = null;
		String patientReg=request.getParameter("patientReg");
		boolean createReport =false;
		if(request.getParameter("createReport")!=null && request.getParameter("createReport").equalsIgnoreCase("y"))
			createReport = true;
		
	
		MultipartFormDataRequest mrequest = new MultipartFormDataRequest(request);
	  
		UploadFile file = null;
		InputStream is = null;
		 
		java.util.Hashtable files = mrequest.getFiles(); 
		if ((files != null) && (!files.isEmpty())) { 
			file = (UploadFile) files.get("hisfile"); 
			try {
				is = file.getInpuStream(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (session.getAttribute(USERS) != null) {
			users = (Users) session.getAttribute(USERS); 
		} 
		
		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try { 
				if (mrequest.getParameter("abc") != null) {
					result = mrequest.getParameter("abc");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		
		parameterMap.put("date", date);
		parameterMap.put("time", time);
		parameterMap.put("users", users.getId());
		parameterMap.put("image", is); 
		parameterMap.put("reportStatus", reportStatus); 
		parameterMap.put("patientId", patientId);  
		parameterMap.put("patientReg", patientReg);  
		parameterMap.put("description", result);   
		map = pacsHandlerService.submitPatientReport(parameterMap); 
		Boolean saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "History Saved Successfully !!";
		} else {
			message = "Some Problem Occured !!";
		}
		map.put("message", message); 
		map= pacsHandlerService.pacsPatientReportDetails(parameterMap); 
		jsp="pacs/reportmain";  
		map.put("createReport", createReport);
		return new ModelAndView(jsp, "map", map);
	}
	
	//for download report referral file
	public ModelAndView downloadReportFile(HttpServletRequest request,HttpServletResponse response) throws IOException { 
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>(); 
		String reportId=request.getParameter("reportId");	
		parameterMap.put("reportId", reportId);
		map = pacsHandlerService.downloadReportFile(parameterMap);
		InputStream is=(InputStream)map.get("is");  
        int fileLength = is.available();
        String fileName=request.getParameter("patientName")+"_ReportFile.pdf";    
        int BUFFER_SIZE = 4096; 
        
       ServletContext context = getServletContext();

        // sets MIME type for the file download
        String mimeType = context.getMimeType(fileName);
        if (mimeType == null) {        
            mimeType = "application/octet-stream";
        }              
             
        // set content properties and header attributes for the response
        response.setContentType(mimeType);
        response.setContentLength(fileLength);
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", fileName);
        response.setHeader(headerKey, headerValue);

        // writes the file to the client
        OutputStream outStream = response.getOutputStream();
         
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;
         
        while ((bytesRead = is.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
             
        is.close();
        outStream.close();             
        
		return null; 
	}
	
	//for Delete report
	public ModelAndView deleteReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();   
		Map<String, Object> datamap = new HashMap<String, Object>();   
		HttpSession session = request.getSession(); 
		Map<String, Object> parameterMap = new HashMap<String, Object>();  
		boolean createReport =false;
		if(request.getParameter("createReport")!=null && request.getParameter("createReport").equalsIgnoreCase("y"))
			createReport = true;
		String reportId=request.getParameter("reportId");
		String patientId=request.getParameter("patientId");
		parameterMap.put("reportId",reportId);
		parameterMap.put("patientId",patientId);
		datamap=pacsHandlerService.deleteReport(parameterMap);  
		Boolean saved = (Boolean) datamap.get("saved");
		if (saved == true) {
			message = "Report Delete Successfully !!";
		} else {
			message = "Some Problem Occured !!";
		}
		map= pacsHandlerService.pacsPatientReportDetails(parameterMap); 
		jsp="pacs/reportmain";  
		map.put("createReport", createReport);
		return new ModelAndView(jsp, "map", map);
	}
	
	//for Delete report
	public ModelAndView editReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();   
		Map<String, Object> datamap = new HashMap<String, Object>();   
		HttpSession session = request.getSession(); 
		Map<String, Object> parameterMap = new HashMap<String, Object>();  
		boolean createReport =false;
		if(request.getParameter("createReport")!=null && request.getParameter("createReport").equalsIgnoreCase("y"))
			createReport = true;
		String reportId=request.getParameter("reportId");
		String patientId=request.getParameter("patientId");
		parameterMap.put("reportId",reportId);
		parameterMap.put("patientId",patientId);
		datamap=pacsHandlerService.editReport(parameterMap);   
		
		map= pacsHandlerService.pacsPatientReportDetails(parameterMap);  
		if(datamap.get("editrepotList")!=null){
			List<PacsReport> editrepotList=(List<PacsReport>) datamap.get("editrepotList");
			map.put("editrepotList", editrepotList);
		}
		
		jsp="pacs/reportmain";   
		map.put("createReport", createReport);
		return new ModelAndView(jsp, "map", map);
	}
	
	//Print report popup
	@SuppressWarnings("unchecked")
	public ModelAndView printReport(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(); 
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String	jsp =""; 
		String reportId=request.getParameter("reportId"); 
		String patientId=request.getParameter("patientId"); 
		dataMap.put("patientId",patientId); 
		dataMap.put("reportId",reportId); 
		map= pacsHandlerService.PrintPatientPacsReportDetails(dataMap); 
		jsp="pacs/PrintReport"; 
		return new ModelAndView(jsp, "map", map);
	}
	
	//Print report image
	@SuppressWarnings("unchecked")
	public ModelAndView getimageReport(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(); 
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String	jsp =""; 
		String userId =request.getParameter("userId");
		dataMap.put("userId",userId);  
		map= pacsHandlerService.getsignatureDetails(dataMap); 
		jsp="pacs/reportSignature"; 
		return new ModelAndView(jsp, "map", map);
	}
	
	/*//Lean Server Test
		@SuppressWarnings("unchecked")
		public ModelAndView serverTest(HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession(); 
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> dataMap = new HashMap<String, Object>();
			Gson gson=new Gson();
			String tableName =request.getParameter("tableName"); 
			int leanHospitalId=Integer.parseInt((String)request.getParameter("hospitalId"));
			int lock =Integer.parseInt((String)request.getParameter("lock"));
			String jsonData;
			 switch (tableName) {
				case "DgResultEntryDetail":
					jsonData=((String)request.getParameter("jsonData")).replace('^', '%');
					break;
				case "DischargeSummary":
					jsonData=((String)request.getParameter("jsonData")).replace('^', '%');
					break;
				default:
					jsonData=((String)request.getParameter("jsonData"));
					break;
				}
			dataMap.put("jsonData", jsonData);
			dataMap.put("lock", lock);
			dataMap.put("tableName", tableName);
			dataMap.put("leanHospitalId", leanHospitalId);
			System.out.println("Data:  "+jsonData);
			map = pacsHandlerService.centralServerService(dataMap); 
			JSONROOT.put("msg", map.get("msg"));
			JSONROOT.put("flag", map.get("flag"));
			JSONROOT.put("tableId", map.get("tableId"));
			String jsonArray = gson.toJson(JSONROOT);
			//System.err.println("Ok! Data send successfully.");
			try{
			response.getWriter().print(jsonArray);
			}catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
		
		//Ranjesh Prasad: For Lean To Server Processing...
		public ModelAndView sendData(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> mapData = new HashMap<String, Object>();
			HttpSession session=request.getSession();
			Box box = HMSUtil.getBox(request);
			int hospitalId = 0;
			int userId=0;
				if(session.getAttribute("userId")!=null)
					userId=Integer.parseInt(""+session.getAttribute("userId"));
				if(session.getAttribute("hospitalId")!=null)
					hospitalId=Integer.parseInt(""+session.getAttribute("hospitalId"));
				mapData.put("box", box);
				mapData.put("hospitalId", hospitalId);
				mapData.put("userId", userId);
			map=pacsHandlerService.sendData(mapData);
			String jsp = "";
			String title = "";
			jsp = "leanServerUtils.jsp";
			map.put("jsp", jsp);
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		public ModelAndView sendDataServerToLean(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> mapData = new HashMap<String, Object>();
			HttpSession session=request.getSession();
			Box box = HMSUtil.getBox(request);
			int hospitalId = 0;
			int userId=0;
				if(session.getAttribute("userId")!=null)
					userId=Integer.parseInt(""+session.getAttribute("userId"));
				if(session.getAttribute("hospitalId")!=null)
					hospitalId=Integer.parseInt(""+session.getAttribute("hospitalId"));
				mapData.put("box", box);
				mapData.put("hospitalId", hospitalId);
				mapData.put("userId", userId);
			map=pacsHandlerService.sendDataServerToLean(mapData);
			String jsp = "";
			String title = "";
			jsp = "leanServerUtils.jsp";
			map.put("jsp", jsp);
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		public ModelAndView receiveDataServerToLean(HttpServletRequest request,HttpServletResponse response) {
			HttpSession session = request.getSession(); 
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> dataMap = new HashMap<String, Object>();
			Gson gson=new Gson();
			String tableName =request.getParameter("tableName"); 
			int leanHospitalId=Integer.parseInt((String)request.getParameter("hospitalId"));
			int lock =Integer.parseInt((String)request.getParameter("lock"));
			String jsonData;
			 switch (tableName) {
				case "DgResultEntryDetail":
					jsonData=((String)request.getParameter("jsonData")).replace('^', '%');
					break;
				case "DischargeSummary":
					jsonData=((String)request.getParameter("jsonData")).replace('^', '%');
					break;
				case "MasStoreItem":
					jsonData=((String)request.getParameter("jsonData")).replace('^', '%');
					break;
				default:
					jsonData=((String)request.getParameter("jsonData"));
					break;
				}
			dataMap.put("jsonData", jsonData);
			dataMap.put("lock", lock);
			dataMap.put("tableName", tableName);
			dataMap.put("leanHospitalId", leanHospitalId);
			System.out.println("Data:  "+jsonData);
			map = pacsHandlerService.receiveDataServerToLean(dataMap); 
			JSONROOT.put("msg", map.get("msg"));
			JSONROOT.put("flag", map.get("flag"));
			JSONROOT.put("tableId", map.get("tableId"));
			String jsonArray = gson.toJson(JSONROOT);
			//System.err.println("Ok! Data send successfully.");
			try{
			response.getWriter().print(jsonArray);
			}catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}*/
}

