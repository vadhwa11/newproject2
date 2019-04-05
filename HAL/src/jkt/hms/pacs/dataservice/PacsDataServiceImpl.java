package jkt.hms.pacs.dataservice;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javazoom.upload.UploadFile;
import jkt.hms.masters.business.PacsTemplate;
import jkt.hms.masters.business.RadiologyCommunication;
import jkt.hms.masters.business.Users;
import jkt.hms.pacs.controller.PacsPatient;
import jkt.hms.pacs.controller.PacsPatientHistory;
import jkt.hms.pacs.controller.PacsReport;
import jkt.hms.pacs.controller.PrintPacsReport;
import jkt.hms.security.AesUtil;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PacsDataServiceImpl extends HibernateDaoSupport implements PacsDataService{
	
	//  For Pacs JDBC Connection
	public static Connection getPacsConnection(){
		Connection con=null;
		Properties prop = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("jdbc.properties");
		try{
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			Class.forName((String)prop.get("pacs.database.driver"));
			con=DriverManager.getConnection((String)prop.get("pacs.database.url"), (String)prop.get("pacs.database.user"), (String)prop.get("pacs.database.password"));
		}catch(Exception e){e.printStackTrace();}
		return con;
	}
	// For Application Connector
	public static String getApplicationWebViewerURL(){
		String appURL="";
		Properties prop = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("jdbc.properties");
		try{
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			appURL=prop.get("pacs.application.connection")+"/weasis-pacs-connector/viewer?patientID=";
		}catch(Exception e){e.printStackTrace();}
		return appURL;
	}
	// For Application Connector
		public static String getApplicationURL(){
			String appURL="";
			Properties prop = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("jdbc.properties");
			try{
				prop.load(new FileInputStream(new File(resourcePath.getFile())));
				appURL=prop.get("pacs.application.connection")+"/"+prop.get("pacs.application.name")+"/";
			}catch(Exception e){e.printStackTrace();}
			return appURL;
		}
		
	@Override
	public List<PacsPatient> getAllPacsPatients(Map<String, Object> map) {
		List<PacsPatient> patients=new ArrayList<PacsPatient>();
		List<RadiologyCommunication> rcList = new ArrayList<RadiologyCommunication>();
		Session session = (Session) getSession();
		Connection con=getPacsConnection();
		String appUrl=getApplicationWebViewerURL();
		String studyUrl=getApplicationStudyWebViewerURL();
		int startPageIndex=0;
		int recordsPerPage=0;
		String qr="";
		String pacsRights="";
		String shortType="desc";
		int radioDocId=0;
		 if(map.get("radioDocId")!=null){
				
			 radioDocId=(Integer)map.get("radioDocId");
		 }
		if(map.get("startPageIndex")!=null){
			startPageIndex=(Integer)map.get("startPageIndex");
		}
		if(map.get("recordsPerPage")!=null){
			recordsPerPage=(Integer)map.get("recordsPerPage");
		}
		if(map.get("query")!=null){
			qr=(String)map.get("query");
		} 
		if(map.get("shortType")!=null){
			shortType=(String)map.get("shortType");
		} 
		if(map.get("pacsRights")!=null){
			pacsRights=(String)map.get("pacsRights");
		} 
		 
		if(shortType.equals("null")){	shortType="desc";		}
		
		String searchImg="<img src='../jsp/pacs/images/search.png' title='Open Image Selection' />";
		String viewer="<img src='../jsp/pacs/images/viewer.png' title='Open Study In Web Viewer' onclick='cngRowColor(this)' />";
		String studyviewer="<img src='../jsp/pacs/images/studyviewer.png' title='Open All Study In Web Viewer' onclick='cngRowColor(this)' />";
		
		String query = "select p.pk,p.pat_id,p.pat_name, p.pat_sex,p.created_time,p.report_status,p.history_status,p.last_cng_by,s.study_iuid,s.study_desc,s.mods_in_study from  patient p  inner join study s on p.pk = s.patient_fk where p.pk in (select patient_fk from study)  "+qr+" order by p.created_time "+shortType+" offset "+startPageIndex+" rows fetch next "+recordsPerPage+" rows only";
		//String query = "select p.pk,p.pat_id,p.pat_name, p.pat_sex,p.created_time,p.report_status,p.history_status,p.last_cng_by,s.study_iuid,s.study_desc,s.mods_in_study from  patient p  inner join study s on p.pk = s.patient_fk where p.pk in (select patient_fk from study)  "+qr+" order by p.created_time "+shortType;
		System.out.println(query);
		//String query = "select  pk,pat_id, pat_name, pat_sex, created_time::timestamp::date from  patient where pk in (select patient_fk from study) "+qr+" order by created_time::timestamp::date desc offset "+startPageIndex+" limit "+recordsPerPage;
		 
		try{
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery(query);  
		while(rs.next()) {
			PacsPatient pacsPatient=new PacsPatient();
			String pName=rs.getString("pat_name").replace("^^^^", "#");
			String[] patientDetail=pName.split("#");
			String patientName=patientDetail[0].replaceAll("[^a-zA-Z0-9]", " ");
			String appId=rs.getString("pat_id");
			String studyId=rs.getString("study_iuid");
			String patientSex=rs.getString("pat_sex");
			String temprelation=appId.substring(appId.length()-3, appId.length());
			String relation="NA";
			if(temprelation.indexOf("01") !=-1)
			{
				relation="Father";
			}
			if(temprelation.indexOf("02") !=-1)
			{
				relation="Mother";
			}
			if(temprelation.indexOf("03") !=-1)
			{
				relation="Wife";
			}
			if(temprelation.indexOf("04") !=-1)
			{
				relation="Husband";
			}
			if(temprelation.indexOf("06") !=-1)
			{
				relation="Self";
			}
			if(temprelation.indexOf("07") !=-1)
			{
				relation="Son";
			}
			if(temprelation.indexOf("08") !=-1)
			{
				relation="Daughter";
			}
			String investigation="";
			String reportstatus=rs.getString("report_status");
			String historystatus=rs.getString("history_status");
			String doctorName=rs.getString("last_cng_by");
			if(rs.getString("study_desc")!=null){investigation=rs.getString("study_desc");} 
			int patientId=rs.getInt("pk");
			Timestamp date = rs.getTimestamp("created_time");
			if(pacsRights.equals("d")){	pacsPatient.setPatientId("<lable style='cursor: pointer;' title='Delete Study' ondblclick='DeleteStudy("+patientId+")'>"+appId+"</lable>");}
			else{pacsPatient.setPatientId(appId);}
			if(pacsRights.equals("y") || pacsRights.equals("d")){	pacsPatient.setPatientName("<lable style='cursor: pointer;' title='Study Add to Academics' ondblclick='AddToAcademicsStudy("+patientId+")'>"+patientName+"</lable>");}
			else{pacsPatient.setPatientName(patientName);} 
			pacsPatient.setGender(relation+"-"+patientSex); 
			pacsPatient.setStudyurl("<a href='"+appUrl+appId+"'>"+studyviewer+"</a>");
			pacsPatient.setWebViewer("<a href='"+studyUrl+studyId+"'>"+viewer+"</a>");
			pacsPatient.setImg(searchImg);
			pacsPatient.setCreateDate(date); 
			pacsPatient.setInvestigation(investigation);
			pacsPatient.setMessage("<img src='../jsp/pacs/images/msg1.png' width='20px' height='20'style='cursor: pointer;' title='Radiology-OPD communication' onclick='openPopupForPatientPacsCommunication("+patientId+")'/>");
			pacsPatient.setModality(rs.getString("mods_in_study"));
			if(doctorName==null){pacsPatient.setReportedBy("");}
			else{pacsPatient.setReportedBy(doctorName);}
			
			
			
			/*if(historystatus.equals("n")){
				pacsPatient.setHistory("<img src='../jsp/pacs/images/historyred.png' style='cursor: pointer;' title='Open History' onclick='openPopupForPatientPacsHistory("+patientId+")'/>");
				//pacsPatient.setHistory("<img src='../jsp/pacs/images/historygreen.png' style='cursor: pointer;' title='Radiology-OPD communication' onclick='openPopupForPatientPacsCommunication("+patientId+")'/>");
			}else{
				pacsPatient.setHistory("<img src='../jsp/pacs/images/historygreen.png' style='cursor: pointer;' title='Open History' onclick='openPopupForPatientPacsHistory("+patientId+")'/>");
				//pacsPatient.setHistory("<img src='../jsp/pacs/images/historygreen.png' style='cursor: pointer;' title='Radiology-OPD communication' onclick='openPopupForPatientPacsCommunication("+patientId+")'/>");
			}*/
			if(reportstatus.equals("0")){
				pacsPatient.setReports("<img src='../jsp/pacs/images/reportred.png' style='cursor: pointer;' title='Open Report' onclick='openPopupForPatientPacsReport("+patientId+")'/>");
				pacsPatient.setReportstatus("UNREPORTED");
			}
			else if(reportstatus.equals("1")){
				pacsPatient.setReports("<img src='../jsp/pacs/images/report.png' style='cursor: pointer;' title='Open Report' onclick='openPopupForPatientPacsReport("+patientId+")'/>");
				pacsPatient.setReportstatus("DRAFTED");  
			}
			else if(reportstatus.equals("2")){
				pacsPatient.setReports("<img src='../jsp/pacs/images/reportgreen.png' style='cursor: pointer;' title='Open Report' onclick='openPopupForPatientPacsReport("+patientId+")'/>");
				pacsPatient.setReportstatus("REVIEWED");  
			}
			else if(reportstatus.equals("3")){
				pacsPatient.setReports("<img src='../jsp/pacs/images/reportblue.png' style='cursor: pointer;' title='Open Report' onclick='openPopupForPatientPacsReport("+patientId+")'/>");
				pacsPatient.setReportstatus("SIGN OFF");  
			}
			
			
			
			//msgStatus
			rcList = session.createCriteria(RadiologyCommunication.class)
					   .add(Restrictions.eq("ToRadioDoctor.Id",radioDocId))
					    .add(Restrictions.eq("PatientId",patientId))
					.list();
			if(rcList.size()>0)
			{
			rcList = session.createCriteria(RadiologyCommunication.class)
			   .add(Restrictions.eq("ToRadioDoctor.Id",radioDocId))
			    .add(Restrictions.eq("PatientId",patientId))
			    .add(Restrictions.eq("Flag","n"))
			.list();
			if(rcList.size()==0)
				pacsPatient.setMessage("<img src='../jsp/pacs/images/msgGreen.png' width='20px' height='20'style='cursor: pointer;' title='Radiology-OPD communication' onclick='openPopupForPatientPacsCommunication("+patientId+")'/>");
			else if(rcList.size()>0)
				pacsPatient.setMessage("<img src='../jsp/pacs/images/msgRed.png' width='20px' height='20'style='cursor: pointer;' title='Radiology-OPD communication' onclick='openPopupForPatientPacsCommunication("+patientId+")'/>");
			
			}
			else
				pacsPatient.setMessage("<img src='../jsp/pacs/images/msgDisable.png' width='20px' height='20'style='cursor: pointer;' title='Radiology-OPD communication' onclick='openPopupForPatientPacsCommunication("+patientId+")'/>");
			pacsPatient.setReportedBy("");
			rcList.clear();
			patients.add(pacsPatient);
		}
			con.close(); 
			  
		}catch (Exception e){
			e.printStackTrace();
		}
		return patients;
	}
	
	@Override
	public List<PacsPatient> getAllPacsPatientsforRadiologyReport(Map<String, Object> map) {
		List<PacsPatient> patients=new ArrayList<PacsPatient>();
		List<RadiologyCommunication> rcList = new ArrayList<RadiologyCommunication>();
		Session session = (Session) getSession();
		Connection con=getPacsConnection();
		String appUrl=getApplicationWebViewerURL();
		String studyUrl=getApplicationStudyWebViewerURL();
		int startPageIndex=0;
		int recordsPerPage=0;
		String qr="";
		String pacsRights="";
		String shortType="desc";
		int radioDocId=0;
		 if(map.get("radioDocId")!=null){
				
			 radioDocId=(Integer)map.get("radioDocId");
		 }
		if(map.get("startPageIndex")!=null){
			startPageIndex=(Integer)map.get("startPageIndex");
		}
		if(map.get("recordsPerPage")!=null){
			recordsPerPage=(Integer)map.get("recordsPerPage");
		}
		if(map.get("query")!=null){
			qr=(String)map.get("query");
		} 
		if(map.get("shortType")!=null){
			shortType=(String)map.get("shortType");
		} 
		if(map.get("pacsRights")!=null){
			pacsRights=(String)map.get("pacsRights");
		} 
		 
		if(shortType.equals("null")){	shortType="desc";		}
		
		String searchImg="<img src='../jsp/pacs/images/search.png' title='Open Image Selection' />";
		String viewer="<img src='../jsp/pacs/images/viewer.png' title='Open Study In Web Viewer' onclick='cngRowColor(this)' />";
		String studyviewer="<img src='../jsp/pacs/images/studyviewer.png' title='Open All Study In Web Viewer' onclick='cngRowColor(this)' />";
		
		String query = "select p.pk,p.pat_id,p.pat_name, p.pat_sex,p.created_time,p.report_status,p.history_status,p.last_cng_by,s.study_iuid,s.study_desc,s.mods_in_study from  patient p  inner join study s on p.pk = s.patient_fk where p.pk in (select patient_fk from study)  "+qr+" order by p.created_time "+shortType+" offset "+startPageIndex+" rows fetch next "+recordsPerPage+" rows only";
		//String query = "select p.pk,p.pat_id,p.pat_name, p.pat_sex,p.created_time,p.report_status,p.history_status,p.last_cng_by,s.study_iuid,s.study_desc,s.mods_in_study from  patient p  inner join study s on p.pk = s.patient_fk where p.pk in (select patient_fk from study)  "+qr+" order by p.created_time "+shortType;
		System.out.println(query);
		//String query = "select  pk,pat_id, pat_name, pat_sex, created_time::timestamp::date from  patient where pk in (select patient_fk from study) "+qr+" order by created_time::timestamp::date desc offset "+startPageIndex+" limit "+recordsPerPage;
		 
		try{
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery(query);  
		while(rs.next()) {
			PacsPatient pacsPatient=new PacsPatient();
			String pName=rs.getString("pat_name").replace("^^^^", "#");
			String[] patientDetail=pName.split("#");
			String patientName=patientDetail[0].replaceAll("[^a-zA-Z0-9]", " ");
			String appId=rs.getString("pat_id");
			String studyId=rs.getString("study_iuid");
			String patientSex=rs.getString("pat_sex");
			String temprelation=appId.substring(appId.length()-3, appId.length());
			String relation="NA";
			if(temprelation.indexOf("01") !=-1)
			{
				relation="Father";
			}
			if(temprelation.indexOf("02") !=-1)
			{
				relation="Mother";
			}
			if(temprelation.indexOf("03") !=-1)
			{
				relation="Wife";
			}
			if(temprelation.indexOf("04") !=-1)
			{
				relation="Husband";
			}
			if(temprelation.indexOf("06") !=-1)
			{
				relation="Self";
			}
			if(temprelation.indexOf("07") !=-1)
			{
				relation="Son";
			}
			if(temprelation.indexOf("08") !=-1)
			{
				relation="Daughter";
			}
			String investigation="";
			String reportstatus=rs.getString("report_status");
			String historystatus=rs.getString("history_status");
			String doctorName=rs.getString("last_cng_by");
			if(rs.getString("study_desc")!=null){investigation=rs.getString("study_desc");} 
			int patientId=rs.getInt("pk");
			Timestamp date = rs.getTimestamp("created_time");
			if(pacsRights.equals("d")){	pacsPatient.setPatientId("<lable style='cursor: pointer;' title='Delete Study' ondblclick='DeleteStudy("+patientId+")'>"+appId+"</lable>");}
			else{pacsPatient.setPatientId(appId);}
			if(pacsRights.equals("y") || pacsRights.equals("d")){	pacsPatient.setPatientName("<lable style='cursor: pointer;' title='Study Add to Academics' ondblclick='AddToAcademicsStudy("+patientId+")'>"+patientName+"</lable>");}
			else{pacsPatient.setPatientName(patientName);} 
			pacsPatient.setGender(relation+"-"+patientSex); 
			pacsPatient.setStudyurl("<a href='"+appUrl+appId+"'>"+studyviewer+"</a>");
			pacsPatient.setWebViewer("<a href='"+studyUrl+studyId+"'>"+viewer+"</a>");
			pacsPatient.setImg(searchImg);
			pacsPatient.setCreateDate(date); 
			pacsPatient.setInvestigation(investigation);
			pacsPatient.setMessage("<img src='../jsp/pacs/images/msg1.png' width='20px' height='20'style='cursor: pointer;' title='Radiology-OPD communication' onclick='openPopupForPatientPacsCommunication("+patientId+")'/>");
			pacsPatient.setModality(rs.getString("mods_in_study"));
			if(doctorName==null){pacsPatient.setReportedBy("");}
			else{pacsPatient.setReportedBy(doctorName);}
			
			
			
			/*if(historystatus.equals("n")){
				pacsPatient.setHistory("<img src='../jsp/pacs/images/historyred.png' style='cursor: pointer;' title='Open History' onclick='openPopupForPatientPacsHistory("+patientId+")'/>");
				//pacsPatient.setHistory("<img src='../jsp/pacs/images/historygreen.png' style='cursor: pointer;' title='Radiology-OPD communication' onclick='openPopupForPatientPacsCommunication("+patientId+")'/>");
			}else{
				pacsPatient.setHistory("<img src='../jsp/pacs/images/historygreen.png' style='cursor: pointer;' title='Open History' onclick='openPopupForPatientPacsHistory("+patientId+")'/>");
				//pacsPatient.setHistory("<img src='../jsp/pacs/images/historygreen.png' style='cursor: pointer;' title='Radiology-OPD communication' onclick='openPopupForPatientPacsCommunication("+patientId+")'/>");
			}*/
			if(reportstatus.equals("0")){
				pacsPatient.setReports("<img src='../jsp/pacs/images/reportred.png' style='cursor: pointer;' title='Open Report' onclick='openPopupForPatientPacsViewReport("+patientId+")'/>");
				pacsPatient.setReportstatus("UNREPORTED");
			}
			else if(reportstatus.equals("1")){
				pacsPatient.setReports("<img src='../jsp/pacs/images/report.png' style='cursor: pointer;' title='Open Report' onclick='openPopupForPatientPacsViewReport("+patientId+")'/>");
				pacsPatient.setReportstatus("DRAFTED");  
			}
			else if(reportstatus.equals("2")){
				pacsPatient.setReports("<img src='../jsp/pacs/images/reportgreen.png' style='cursor: pointer;' title='Open Report' onclick='openPopupForPatientPacsViewReport("+patientId+")'/>");
				pacsPatient.setReportstatus("REVIEWED");  
			}
			else if(reportstatus.equals("3")){
				pacsPatient.setReports("<img src='../jsp/pacs/images/reportblue.png' style='cursor: pointer;' title='Open Report' onclick='openPopupForPatientPacsViewReport("+patientId+")'/>");
				pacsPatient.setReportstatus("SIGN OFF");  
			}
			
			
			
			//msgStatus
			rcList = session.createCriteria(RadiologyCommunication.class)
					   .add(Restrictions.eq("ToRadioDoctor.Id",radioDocId))
					    .add(Restrictions.eq("PatientId",patientId))
					.list();
			if(rcList.size()>0)
			{
			rcList = session.createCriteria(RadiologyCommunication.class)
			   .add(Restrictions.eq("ToRadioDoctor.Id",radioDocId))
			    .add(Restrictions.eq("PatientId",patientId))
			    .add(Restrictions.eq("Flag","n"))
			.list();
			if(rcList.size()==0)
				pacsPatient.setMessage("<img src='../jsp/pacs/images/msgGreen.png' width='20px' height='20'style='cursor: pointer;' title='Radiology-OPD communication' onclick='openPopupForPatientPacsCommunicationForDoctor("+patientId+")'/>");
			else if(rcList.size()>0)
				pacsPatient.setMessage("<img src='../jsp/pacs/images/msgRed.png' width='20px' height='20'style='cursor: pointer;' title='Radiology-OPD communication' onclick='openPopupForPatientPacsCommunicationForDoctor("+patientId+")'/>");
			
			}
			else
				pacsPatient.setMessage("<img src='../jsp/pacs/images/msgDisable.png' width='20px' height='20'style='cursor: pointer;' title='Radiology-OPD communication' onclick='openPopupForPatientPacsCommunicationForDoctor("+patientId+")'/>");
			pacsPatient.setReportedBy("");
			rcList.clear();
			patients.add(pacsPatient);
		}
			con.close(); 
			  
		}catch (Exception e){
			e.printStackTrace();
		}
		return patients;
	}

	// For Application Connector
		public static String getApplicationStudyWebViewerURL(){
			String studyURL="";
			Properties prop = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("jdbc.properties");
			try{
				prop.load(new FileInputStream(new File(resourcePath.getFile())));
				studyURL=prop.get("pacs.application.connection")+"/weasis-pacs-connector/viewer?studyUID=";
			}catch(Exception e){e.printStackTrace();}
			return studyURL;
		}
		
	@Override
	public int getPacsPatientsCount(Map<String, Object> map) {
		int count=0;
		String qr="";
		if(map.get("query")!=null){
			qr=(String)map.get("query");
		}
		try 
		{
			Statement stmt = getPacsConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select count(distinct pat_id) AS COUNT from  patient where pk in (select patient_fk from study) "+qr);		
			while (rs.next()) 
			{
				count=rs.getInt("COUNT");
			}
		} 
		catch (SQLException e) 
		{
			System.err.println(e.getMessage());
		}
		return count;
	}

	@Override
	public void deletePatient(int patientId) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Map<String, Object> getPreviousVisit(Map<String, Object> details) {
		Map<String, Object> map=new HashMap<String, Object>();
		PacsPatient patient=new PacsPatient();
		List<PacsPatient> patients=new ArrayList<PacsPatient>();
		String viewer="<img src='../jsp/pacs/images/viewer.png' title='Open Web Viewer' />";
		String appUrl=getApplicationWebViewerURL();
		String msg="";
		String visitId="";
		String patientId="";
		String visitDate="";
		if(details.get("visitId")!=null){
			visitId=(String)details.get("visitId");
		}
		if(details.get("patientId")!=null){
			patientId=(String)details.get("patientId");
		}
		if(details.get("visitDate")!=null){
			visitDate=(String)details.get("visitDate");
		}
		try{
			Statement stmt = getPacsConnection().createStatement();
			String query="select p.pat_id, p.pat_name,p.pat_id from patient p left join mwl_item mi on p.pk=mi.patient_fk where  p.pat_id='"+patientId+"' and mi.req_proc_id='"+visitId+"' and mi.created_time::date='"+visitDate+"'";
			ResultSet rs = stmt.executeQuery(query);		
			while (rs.next()) 
			{
				patient.setPatientId(rs.getString("pat_id"));
				patient.setPatientName(rs.getString("pat_name"));
				patient.setCreateDate(rs.getDate("p.created_time"));
				patients.add(patient);
			}
		}catch (SQLException e) 
		{
			System.err.println(e.getMessage());
		}
		map.put("viewer", viewer);
		map.put("appUrl", appUrl);
		map.put("patientList", patients);
		return map;
	}
	
	@Override
	public Map<String, Object> getPacsAuthenticationService(
			Map<String, Object> dataMap) {
		Map<String, Object> map=new HashMap<String, Object>();
		int userId = (Integer)dataMap.get("userId");
		int hospitalId = (Integer)dataMap.get("hospitalId");
		String msg=" You are not Authorised Person!";
		boolean flag=false;
		String userName="";
		String userPassword="";
		try{
			Statement stmt = getPacsConnection().createStatement();
			String query="select user_id, eaarogya_pass from users where eaarogya_user_id ='"+userId+"' and eaarogya_hospital_id='"+hospitalId+"'";
			ResultSet rs = stmt.executeQuery(query);		
			while (rs.next()) 
			{
				userName=rs.getString("user_id");
				userPassword=AesUtil.Decrypt(rs.getString("eaarogya_pass"));
				flag=true;
				msg="";
			}
		}catch (SQLException e) 
		{
			System.err.println(e.getMessage());
		}
		map.put("msg", msg);
		map.put("flag", flag);
		map.put("userName", userName);
		map.put("userPassword", userPassword);
		map.put("appURL", getApplicationURL());
		return map;
	}
	
	@Override
	public Map<String, Object> getUsers(Map<String, Object> dataMap) {
		Map<String, Object> map=new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<Object[]> usersList=new ArrayList<Object[]>();
		int hospitalId=(Integer)dataMap.get("hospitalId");
		String loginName=(String)dataMap.get("loginName")+"%";
		usersList=session.createCriteria(Users.class, "u").createAlias("u.Employee", "e")
				.add(Restrictions.eq("u.Hospital.Id", hospitalId))
				.add(Restrictions.eq("e.Status", "y").ignoreCase())
				.add(Restrictions.eq("u.Status", "y").ignoreCase())
				.add(Restrictions.like("e.FirstName", loginName).ignoreCase())
				.setProjection(Projections.projectionList()
						.add(Projections.property("u.Id"),"userId")
						.add(Projections.property("u.Hospital.Id"), "hospitalId")
						.add(Projections.property("u.LoginName"), "loginName")
						.add(Projections.property("e.FirstName"), "firstName")
						.add(Projections.property("e.MiddleName"), "middleName")
						.add(Projections.property("e.LastName"), "lastName"))
						.addOrder(Order.asc("e.FirstName")).setMaxResults(10).list();
		map.put("usersList", usersList);
		return map;
	}
	
	@Override
	public Map<String, Object> pacsRightSave(Map<String, Object> dataMap) {
		Map<String, Object> map=new HashMap<String, Object>();
		Box box=(Box)dataMap.get("box");
		String loginName=box.getString("loginName");
		String msg="";
		int userId=box.getInt("userId");
		int hospitalId=box.getInt("hospitalId");
		String studyStatus="n";
		String eArrogyaPass=box.getString("password");
		String pass=AesUtil.Decrypt(eArrogyaPass);
		String pacsPass=HMSUtil.PacsEncrypt(pass);
		InputStream inputStream = null;
		boolean flag=false;
		byte[] b=null;
		byte[] signatureBytes=null;
		if(dataMap.get("signature")!=null){
		UploadFile signature = (UploadFile) dataMap.get("signature");
		inputStream = signature.getInpuStream();
		 b = signature.getData();
		 flag=true;
		}
		
		//for insput stream conver into bytes 
		if(inputStream!=null) 
		{ 
			 ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
			 byte[] buf = new byte[1024]; 
	 	     try {  
	            for (int readNum; (readNum = inputStream.read(buf)) != -1;) { 
	                bos.write(buf, 0, readNum);    
	            }  
	         } catch (IOException ex) { 
	         } 
	 	     
	 	    signatureBytes = bos.toByteArray();
		}
		
		Connection con=getPacsConnection();
		if(box.getString("studyStatus")!=""){studyStatus="y";}
		try{
			String query="";
			if(flag){
				query="INSERT INTO users(user_id, passwd, eaarogya_user_id, eaarogya_hospital_id, eaarogya_pass, status,signature) VALUES (?, ?, ?, ?, ?, ?, ?)";
			}else{
				query="INSERT INTO users(user_id, passwd, eaarogya_user_id, eaarogya_hospital_id, eaarogya_pass, status) VALUES (?, ?, ?, ?, ?, ?);";
			}
			PreparedStatement statement = con.prepareStatement(query);
			 statement.setString(1, loginName);
			 statement.setString(2, pacsPass);
			 statement.setInt(3, userId);
			 statement.setInt(4, hospitalId);
			 statement.setString(5, eArrogyaPass);
			 statement.setString(6, studyStatus);
			 if(flag){
			 statement.setBytes(7, signatureBytes);
			 }
			 int row = statement.executeUpdate();
	            if (row > 0) {
	            	msg = loginName+" is Successfully Updated!";
	            }
		}catch (SQLException e) 
		{
			msg="User Already Exists!";
			System.err.println(e.getMessage());
		}finally{
			try{con.close();}catch(SQLException e){e.printStackTrace();}
		}
		map.put("msg", msg);
		return map;
	}
	
	@Override
	public Map<String, Object> pacsRightsList(Map<String, Object> dataMap)  {
		Map<String, Object> map=new HashMap<String, Object>();
		List<Object[]> users=new ArrayList<Object[]>();
		Connection con=getPacsConnection(); 
		try{
			Statement stmt = con.createStatement();
			String query="select user_id, passwd, eaarogya_user_id, eaarogya_hospital_id, eaarogya_pass, status,signature from users ";
			ResultSet rs = stmt.executeQuery(query);		
			while (rs.next()) 
			{
				users.add(new Object[]{rs.getObject("user_id"),rs.getObject("passwd"),rs.getObject("eaarogya_user_id"), rs.getObject("eaarogya_hospital_id"), rs.getObject("eaarogya_pass"), rs.getObject("status"), rs.getObject("signature")});
			}
		}catch (SQLException e) 
		{
			System.err.println(e.getMessage());
		}
		map.put("users", users);
		return map;
	}
	
	@Override
	public Map<String, Object> submitPacsTemplate(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>(); 
		boolean saved = false; 
		PacsTemplate pacstemplate = (PacsTemplate) parameterMap.get("pacstemplate");
		Session session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(pacstemplate);
			tx.commit();
			saved = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			} 
			e.printStackTrace();
		}

		map.put("saved", saved);
		return map;
	}
	@Override
	public Map<String, Object> getTemplatesForAutoComplete(Map<String, Object> map) {
		List<PacsTemplate> templateList = new ArrayList<PacsTemplate>();
		Map<String, Object> maps = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String str = "%" + map.get("autoHint") + "%";
		Criteria crit = session
				.createCriteria(PacsTemplate.class)
				.add(Restrictions.like("TemplateName", str).ignoreCase()) 
				.add(Restrictions.eq("Status", "y").ignoreCase());
		crit.setFirstResult(0);
		crit.setMaxResults(10);
		templateList = crit.list(); 
		map.put("templateList", templateList);
		return map;
	}
	@Override
	public Map<String, Object> getsearchtemplates(Map<String, Object> parameterMap) {
		List<PacsTemplate> templateList = new ArrayList<PacsTemplate>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int templateid=0;
		if(parameterMap.get("templateid")!=null){
		String strtempid =(String) parameterMap.get("templateid");
		templateid=Integer.parseInt(strtempid);
		}
		templateList= session
				.createCriteria(PacsTemplate.class)
				.add(Restrictions.eq("Id", templateid)) 
				.add(Restrictions.eq("Status", "y").ignoreCase()).list(); 
		map.put("templateList", templateList);  
		return map;
	}
	
	@Override
	public Map<String, Object> updatePacsTemplate(	Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>(); 
		boolean saved = false;  
		Session session = (Session) getSession();
		Transaction tx = null;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int tempid=0;
		String tempcode="";
		String tempname="";
		String temptype="";
		String description="";
		String time="";
		Users users=null;
		 
		if(parameterMap.get("tempid")!=null){
			String strtempid =(String) parameterMap.get("tempid");
			tempid=Integer.parseInt(strtempid);
		}
		if(parameterMap.get("tempcode")!=null){
			tempcode =(String) parameterMap.get("tempcode"); 
		}
		if(parameterMap.get("tempname")!=null){
			tempname =(String) parameterMap.get("tempname"); 
		}
		if(parameterMap.get("temptype")!=null){
			temptype =(String) parameterMap.get("temptype"); 
		}
		if(parameterMap.get("result")!=null){
			description =(String) parameterMap.get("result"); 
		}
		if(parameterMap.get("time")!=null){
			time =(String) parameterMap.get("time"); 
		}
		 
		if(parameterMap.get("users")!=null){
			users =(Users) parameterMap.get("users"); 
		} 
		
		
			try {
				tx = session.beginTransaction(); 
				
				
				PacsTemplate   pacsTemplate=(PacsTemplate)hbt.get(PacsTemplate.class, tempid);
				pacsTemplate.setCode(tempcode);
				pacsTemplate.setTemplateName(tempname);
				pacsTemplate.setTemplateType(temptype);
				pacsTemplate.setDescription(description);
				pacsTemplate.setStatus("y");
				pacsTemplate.setLastChgBy(users);
				pacsTemplate.setLastChgTime(time); 
				hbt.update(pacsTemplate);  
				tx.commit();
				saved=true;
			} catch (Exception e) { 
				if (tx != null) {
					tx.rollback();
				} 
				e.printStackTrace();
			} 
		
		map.put("saved", saved);
		return map;
	}
	
	 //for get patient details and history details
	@Override
	public Map<String, Object> pacsPatientDetails(Map<String, Object> dataMap) {
		 
		Map<String, Object> map = new HashMap<String, Object>(); 
		List<PacsPatientHistory> patientsHistoryList=new ArrayList<PacsPatientHistory>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		Session session = (Session) getSession();
		Connection con=getPacsConnection(); 
		String qr=""; 
		int patientId=0;
		 if(dataMap.get("patientId")!=null){
			 patientId=Integer.parseInt((String)dataMap.get("patientId"));
		 }
		 
		String query = "select p.pk,p.pat_id,p.pat_name, p.pat_sex,p.created_time,s.study_desc from  patient p  inner join study s on p.pk = s.patient_fk where p.pk = "+patientId;
		String historyList = "select id,description,ref_file,user_id,last_chg_date,last_chg_time from patient_history where patient_id = "+patientId;
		
		try{
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery(query);  
		while(rs.next()) {
			 
			String patientsId=rs.getString("pk");
			String appId=rs.getString("pat_id");
			String pName=rs.getString("pat_name").replace("^^^^", "#");
			String[] patientDetail=pName.split("#");
			String patientName=patientDetail[0]; 
			String patientSex=rs.getString("pat_sex");
			Date date=rs.getDate("created_time");
			String patientsType=rs.getString("study_desc");
			 
			String datetime=sdf.format(date);
			String[] datetime1=datetime.split("-");
			String datetimes=datetime1[2]+"-"+datetime1[1]+"-"+datetime1[0];
			
			map.put("patientsReg", appId);
			map.put("patientsName", patientName);
			map.put("patientsSex", patientSex);
			map.put("patientsDate", datetimes); 
			map.put("patientsType", patientsType); 
			map.put("patientsId", patientsId); 
		}
		
		rs=stmt.executeQuery(historyList); 
		while(rs.next()) {
			PacsPatientHistory history=new PacsPatientHistory(); 
			int historyid=rs.getInt("id");
			int userid=rs.getInt("user_id");
			String desc=rs.getString("description");
			byte[] file=rs.getBytes("ref_file");  
			Date date=rs.getDate("last_chg_date");
			String time=rs.getString("last_chg_time");
			String datetime=sdf.format(date);
			String[] datetime1=datetime.split("-");
			String datetimes=datetime1[2]+"-"+datetime1[1]+"-"+datetime1[0]+" "+time;
			Users user=(Users) session.createCriteria(Users.class).add(Restrictions.eq("Id",userid)).list().get(0);
			String employeeName=user.getEmployee().getFirstName();
			if(user.getEmployee().getMiddleName()!=null){employeeName+=" "+user.getEmployee().getMiddleName();}
			if(user.getEmployee().getLastName()!=null){employeeName+=" "+user.getEmployee().getLastName();} 
			
			history.setEmployeeName(employeeName);
			history.setDescription(desc);
			history.setHistoryid(historyid);
			history.setLastchangetime(datetimes);
			if(file==null){
				history.setFileStatus("N");
			}
			else{
				history.setFileStatus("Y");
			}
			patientsHistoryList.add(history); 
		}
		con.close();  
		
		}catch (Exception e){
			e.printStackTrace();
		}
		map.put("patientsHistoryList", patientsHistoryList);
		return map;
	}
	
	// save patient history
	@Override
	public Map<String, Object> submitPatientHistory(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>(); 
		
		boolean saved = false; 
		Connection con=getPacsConnection();
		String description="";
		String time="";
		int userid=0;
		int patid=0;
		InputStream is = null;
		byte[] filebytes =null;
		
		if(parameterMap.get("history")!=null){
			description =(String) parameterMap.get("history"); 
		}
		if(parameterMap.get("time")!=null){
			time =(String) parameterMap.get("time"); 
		}
		if(parameterMap.get("patientId")!=null){
			String patient =(String) parameterMap.get("patientId");
			patid=Integer.parseInt(patient);
		}
		if(parameterMap.get("users")!=null){
			userid =(Integer) parameterMap.get("users"); 
		}     
		if(parameterMap.get("image")!=null){
			is =(InputStream) parameterMap.get("image"); 
		}
		
		//for insput stream conver into bytes 
		if(is!=null) 
		{ 
			 ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
			 byte[] buf = new byte[1024]; 
	 	     try {  
	            for (int readNum; (readNum = is.read(buf)) != -1;) { 
	                bos.write(buf, 0, readNum);    
	            }  
	         } catch (IOException ex) { 
	         } 
	 	     
	 	    filebytes = bos.toByteArray();
		}
		
 	    java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());	
		
 	    
 	    int hid=0;
 	    try{  
 	    	Statement stmt=con.createStatement();  
			ResultSet rs=null;
			/*String query = "select top(1) id from  patient_history order by id desc "; 
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(query);  
			while(rs.next()) { 
				hid=rs.getInt("id");  
			}   
			hid=hid+1;*/  //System.out.println("File Size:"+filebytes.length);
			PreparedStatement ps = con.prepareStatement("INSERT INTO patient_history(patient_id,description,ref_file,user_id,last_chg_date,last_chg_time) VALUES (?, ?, ?, ?, ?, ?)");
			//ps.setInt(1,hid);
			ps.setInt(1,patid);
			ps.setString(2,description);
			ps.setBytes(3,filebytes);
			ps.setInt(4,userid);
			ps.setDate(5, sqlDate);
			ps.setString(6,time);
			ps.executeUpdate();	  
			
			//update history status
			ps = con.prepareStatement("update patient set history_status =? where pk = ?");
			ps.setString(1,"y"); 
			ps.setInt(2,patid); 
			ps.executeUpdate();	 
			
			saved = true;
		}catch (SQLException e) 
		{ 
			e.printStackTrace();
		}  
		map.put("saved", saved);
		return map;
	}
	
	
	//download history referral file
	@Override
	public Map<String, Object> downloadHistoryFile(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>(); 
		
		boolean saved = false; 
		Connection con=getPacsConnection(); 
		InputStream is = null;
		int historyId=0; 
		 
		
		if(parameterMap.get("historyId")!=null){
			historyId =Integer.parseInt((String) parameterMap.get("historyId")); 
		}
		
		String historyList = "select id,ref_file from patient_history where id = "+historyId;
	 
		try{
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery(historyList);   
		while(rs.next()) {  
			PacsPatientHistory history=new PacsPatientHistory(); 
			int historyid=rs.getInt("id"); 
			byte[] file=rs.getBytes("ref_file");  
			is = new ByteArrayInputStream(file); 
		}
		con.close();  
		
		}catch (Exception e){
			e.printStackTrace();
		}
		map.put("is",is);
		return map;
	}
	
	//for save patient report
	@Override
	public Map<String, Object> submitPatientReport(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>(); 
		
		boolean saved = false; 
		Connection con=getPacsConnection();
		String description="";
		String time="";
		String reportStatus="";
		int userid=0;
		int patid=0;
		InputStream is = null;
		byte[] filebytes =null;
		String patientReg="";
		
		if(parameterMap.get("patientReg")!=null){
			patientReg =(String) parameterMap.get("patientReg"); 
		}
		
		if(parameterMap.get("reportStatus")!=null){
			reportStatus =(String) parameterMap.get("reportStatus"); 
		}
		
		if(parameterMap.get("description")!=null){
			description =(String) parameterMap.get("description"); 
		}
		if(parameterMap.get("time")!=null){
			time =(String) parameterMap.get("time"); 
		}
		if(parameterMap.get("patientId")!=null){
			String patient =(String) parameterMap.get("patientId");
			patid=Integer.parseInt(patient);
		}
		if(parameterMap.get("users")!=null){
			userid =(Integer) parameterMap.get("users"); 
		}     
		if(parameterMap.get("image")!=null){
			is =(InputStream) parameterMap.get("image"); 
		}
		
		//for insput stream conver into bytes 
		if(is!=null) 
		{ 
			 ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
			 byte[] buf = new byte[1024]; 
	 	     try {  
	            for (int readNum; (readNum = is.read(buf)) != -1;) { 
	                bos.write(buf, 0, readNum);    
	            }  
	         } catch (IOException ex) { 
	         } 
	 	     
	 	    filebytes = bos.toByteArray();
		}
		
 	    java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());	
		
 	    
 	    int hid=0;
 	    try{  
 	    	Statement stmt=con.createStatement();  
			ResultSet rs=null;
			/*String query = "select top(1) id from  patient_report order by id desc "; 
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(query);  
			while(rs.next()) { 
				hid=rs.getInt("id");  
			}   
			hid=hid+1;*/
			
			String queryReport = "select id from  patient_report where patient_id="+patid;  
			rs=stmt.executeQuery(queryReport);
			int counter=1; while(rs.next()) {counter++;}   
			 
			PreparedStatement ps = con.prepareStatement("INSERT INTO patient_report(patient_id, description, ref_file, createdby, last_chg_date, last_chg_time, report_status, active_status, report_no) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			//ps.setInt(1,hid);
			ps.setInt(1,patid);
			ps.setString(2,description);
			ps.setBytes(3,filebytes); 
			ps.setInt(4,userid);
			ps.setDate(5, sqlDate);
			ps.setString(6,time);
			ps.setString(7,reportStatus);
			ps.setString(8,"Y");
			ps.setString(9,patientReg+"-"+counter);
			ps.executeUpdate();	
			
			//update history status
			ps = con.prepareStatement("update patient set report_status =? where pk = ?");
			ps.setString(1,reportStatus); 
			ps.setInt(2,patid); 
			ps.executeUpdate();	 
			
			saved = true; 
		}catch (SQLException e) 
		{ 
			e.printStackTrace();
		}  
		map.put("saved", saved);
		return map;
	}
	
	//get report main details
	@Override
	public Map<String, Object> pacsPatientReportDetails(Map<String, Object> parameterMap) { 
			 
			Map<String, Object> map = new HashMap<String, Object>(); 
			List<PacsReport> patientPacsReportList=new ArrayList<PacsReport>();
			List<PacsPatientHistory> patientsHistoryList=new ArrayList<PacsPatientHistory>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			Session session = (Session) getSession();
			Connection con=getPacsConnection(); 
			String qr=""; 
			int patId=0;
			if(parameterMap.get("patientId")!=null){
				patId=Integer.parseInt((String)parameterMap.get("patientId"));
			}
			
			String query = "select id,patient_id,description,ref_file,createdby,last_chg_date,last_chg_time,report_status,report_no from patient_Report where active_status='y' and patient_id = "+patId+" order by id desc";
	 	try{
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(query);  
			while(rs.next()) {
				  
					int userid=rs.getInt("createdby");
					int reportId=rs.getInt("id");
					int patientId=rs.getInt("patient_id");
					String desc=rs.getString("description");
					String reportStatus=rs.getString("report_status");
					String time=rs.getString("last_chg_time");
					Date date=rs.getDate("last_chg_date");
					String reportNo=rs.getString("report_no");
					String datetime=sdf.format(date);
					String[] datetime1=datetime.split("-");
					String datetimes=datetime1[2]+"-"+datetime1[1]+"-"+datetime1[0]+" "+time; 
					byte[] file=rs.getBytes("ref_file");  
					 
					Users user=(Users) session.createCriteria(Users.class).add(Restrictions.eq("Id",userid)).list().get(0);
					String employeeName=user.getEmployee().getFirstName();
					if(user.getEmployee().getMiddleName()!=null){employeeName+=" "+user.getEmployee().getMiddleName();}
					if(user.getEmployee().getLastName()!=null){employeeName+=" "+user.getEmployee().getLastName();} 
					
					PacsReport report=new PacsReport();
					if(file==null){
						report.setFileStatus("N");
					}
					else{
						report.setFileStatus("Y");
					}
					
					if(reportStatus.equals("0")){report.setReportStatus("UNREPORTED");}
					else if(reportStatus.equals("1")){report.setReportStatus("DRAFTED");}
					else if(reportStatus.equals("2")){report.setReportStatus("REVIEWED");}
					report.setPatientId(patientId);
					report.setReportId(reportId);
					report.setEmployeeName(employeeName);
					report.setDescription(desc);
					report.setLastchangetime(datetimes);
					report.setReportno(reportNo);
					patientPacsReportList.add(report);  
			}  
			
			String querys = "select p.pk,p.pat_id,p.pat_name, p.pat_sex,p.created_time,s.study_desc from  patient p  inner join study s on p.pk = s.patient_fk where p.pk = "+patId;
			String historyList = "select id,description,ref_file,user_id,last_chg_date,last_chg_time from patient_history where patient_id = "+patId;
			 
			rs=stmt.executeQuery(querys);  
			while(rs.next()) {
				 
				String patientsId=rs.getString("pk");
				String appId=rs.getString("pat_id");
				String pName=rs.getString("pat_name").replace("^^^^", "#");
				String[] patientDetail=pName.split("#");
				String patientName=patientDetail[0]; 
				String patientSex=rs.getString("pat_sex");
				Date date=rs.getDate("created_time");
				String patientsType=rs.getString("study_desc");
				 
				String datetime=sdf.format(date);
				String[] datetime1=datetime.split("-");
				String datetimes=datetime1[2]+"-"+datetime1[1]+"-"+datetime1[0];
				
				map.put("patientsReg", appId);
				map.put("patientsName", patientName);
				map.put("patientsSex", patientSex);
				map.put("patientsDate", datetimes); 
				map.put("patientsType", patientsType); 
				map.put("patientsId", patientsId); 
			}
			
			rs=stmt.executeQuery(historyList); 
			while(rs.next()) {
				PacsPatientHistory history=new PacsPatientHistory(); 
				int historyid=rs.getInt("id");
				int userid=rs.getInt("user_id");
				String desc=rs.getString("description");
				byte[] file=rs.getBytes("ref_file");  
				Date date=rs.getDate("last_chg_date");
				String time=rs.getString("last_chg_time");
				String datetime=sdf.format(date);
				String[] datetime1=datetime.split("-");
				String datetimes=datetime1[2]+"-"+datetime1[1]+"-"+datetime1[0]+" "+time;
				Users user=(Users) session.createCriteria(Users.class).add(Restrictions.eq("Id",userid)).list().get(0);
				String employeeName=user.getEmployee().getFirstName();
				if(user.getEmployee().getMiddleName()!=null){employeeName+=" "+user.getEmployee().getMiddleName();}
				if(user.getEmployee().getLastName()!=null){employeeName+=" "+user.getEmployee().getLastName();} 
				
				history.setEmployeeName(employeeName);
				history.setDescription(desc);
				history.setHistoryid(historyid);
				history.setLastchangetime(datetimes);
				if(file==null){
					history.setFileStatus("N");
				}
				else{
					history.setFileStatus("Y");
				}
				patientsHistoryList.add(history); 
			}
			con.close();   
		}catch (Exception e){
			e.printStackTrace();
		}
	 		map.put("patientsHistoryList", patientsHistoryList);
			map.put("patientPacsReportList", patientPacsReportList);
			return map;
		}
	
	//dowload reports referral file
	@Override
	public Map<String, Object> downloadReportFile(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>(); 
		
		boolean saved = false; 
		Connection con=getPacsConnection(); 
		InputStream is = null;
		int reportId=0; 
		 
		
		if(parameterMap.get("reportId")!=null){
			reportId =Integer.parseInt((String) parameterMap.get("reportId")); 
		}
		
		String historyList = "select id,ref_file from patient_report where id = "+reportId;
	 
		try{
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery(historyList);   
		while(rs.next()) {  
			PacsPatientHistory history=new PacsPatientHistory(); 
			int historyid=rs.getInt("id"); 
			byte[] file=rs.getBytes("ref_file");  
			is = new ByteArrayInputStream(file); 
		}
		con.close();  
		
		}catch (Exception e){
			e.printStackTrace();
		}
		map.put("is",is);
		return map;
	}
	
	//for delete  patient report
	@Override
	public Map<String, Object> deleteReport(Map<String, Object> parameterMap) {
		 Map<String, Object> map = new HashMap<String, Object>();  
		boolean saved = false; 
		Connection con=getPacsConnection();
		int reportId=0;
		int patientId=0;
		if(parameterMap.get("reportId")!=null){
			reportId =Integer.parseInt((String) parameterMap.get("reportId")); 
		}  
		
		if(parameterMap.get("patientId")!=null){
			patientId =Integer.parseInt((String) parameterMap.get("patientId")); 
		}  
 	     
 	    try{  
 	    	
			PreparedStatement ps = con.prepareStatement("update patient_report set active_status =? where id = ?");
			ps.setString(1,"N"); 
			ps.setInt(2,reportId); 
			ps.executeUpdate();	  
			
			//update patient report status
			String reportStatus="0";
			String rquery = "select top(1) report_status from patient_report where patient_id ="+patientId+" and active_status='Y' order by id desc "; 
 			Statement stmt=con.createStatement();  
 			ResultSet rs=stmt.executeQuery(rquery);   
 			while(rs.next()) {    
 				reportStatus=rs.getString("report_status");  
 			}
 			//update history status 
 			ps = con.prepareStatement("update patient set report_status =? where pk = ?");
			ps.setString(1,reportStatus); 
			ps.setInt(2,patientId); 
			ps.executeUpdate();	 
			
			saved = true; 
		}catch (SQLException e) 
		{ 
			e.printStackTrace();
		}  
		map.put("saved", saved);
		return map;
	}
	
	//for edit report details
	@Override
	public Map<String, Object> editReport(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();   
		Connection con=getPacsConnection();
		PacsReport report=new PacsReport();
		int reportId=0; 
		if(parameterMap.get("reportId")!=null){
			reportId =Integer.parseInt((String) parameterMap.get("reportId")); 
		}    
 	     List<PacsReport> editrepotList=new ArrayList<PacsReport>();
		String query = "select id,patient_id,description,report_status from patient_Report where active_status like 'y' and id = "+reportId;
	 	try{
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(query);  
			while(rs.next()) {
				   
					int reportsId=rs.getInt("id");
					int patientId=rs.getInt("patient_id");
					String desc=rs.getString("description");
					String reportStatus=rs.getString("report_status");  
					report.setReportStatus(reportStatus);
					report.setPatientId(patientId);
					report.setReportId(reportId); 
					report.setDescription(desc); 
					editrepotList.add(report);
			}  
	 	}catch (SQLException e) 
		{ 
			e.printStackTrace();
		}  	
		map.put("editrepotList", editrepotList);
		return map;
	}
	
	@Override
	public Map<String, Object> PrintPatientPacsReportDetails(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();   
		Connection con=getPacsConnection();
		Session session = (Session)getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		List<PrintPacsReport> printPacsReportList=new ArrayList<PrintPacsReport>();
 		int reportId=0; 
		int patientId=0;
		String doctorname="Dr.";
		String hospitalname="";
		String department="";
		String designation=""; 
		if(dataMap.get("reportId")!=null){
			reportId =Integer.parseInt((String) dataMap.get("reportId")); 
		}    
		if(dataMap.get("patientId")!=null){
			patientId =Integer.parseInt((String) dataMap.get("patientId")); 
		}    
 	    
		String query = "select p.pat_id,p.pat_name,p.pat_sex,p.created_time,s.study_desc,s.mods_in_study,pr.patient_id,pr.description,pr.last_chg_date, pr.createdby from patient_report pr inner join patient p on pr.patient_id = p.pk inner join study s on s.patient_fk = p.pk where pr.id="+reportId+" and pr.patient_id="+patientId;
	 	try{
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(query);  
			while(rs.next()) {
					PrintPacsReport report=new PrintPacsReport(); 
					int userid=rs.getInt("createdby");   
				    String regno=rs.getString("pat_id");
				    String pName=rs.getString("pat_name").replace("^^^^", "#");
					String[] patientDetail=pName.split("#");
					String patientName=patientDetail[0];  
					String patientSex=rs.getString("pat_sex");
					Date date=rs.getDate("created_time");
					String investigation=rs.getString("study_desc"); 
					String datetime=sdf.format(date);
					String[] datetime1=datetime.split("-");
					String Studydate=datetime1[2]+"-"+datetime1[1]+"-"+datetime1[0]; 
					String mods=rs.getString("mods_in_study"); 
					String desc=rs.getString("description");
					Date rdate=rs.getDate("last_chg_date");
					String rdatetime=sdf.format(rdate);
					String[] rdatetime1=rdatetime.split("-");
					String Reportdate=rdatetime1[2]+"-"+rdatetime1[1]+"-"+rdatetime1[0]; 
					
					Users user=(Users) session.createCriteria(Users.class).add(Restrictions.eq("Id",userid)).list().get(0);
					doctorname+=user.getEmployee().getFirstName(); 
					if(user.getEmployee().getMiddleName()!=null){doctorname+=" "+user.getEmployee().getMiddleName();}
					if(user.getEmployee().getLastName()!=null){doctorname+=" "+user.getEmployee().getLastName();} 
					//hospitalname=user.getHospital().getHospitalName();
					department=user.getEmployee().getDepartment().getDepartmentName();
					designation=user.getEmployee().getRank().getRankName();
					
					report.setPatientid(Integer.toString(patientId));
					report.setReportid(Integer.toString(reportId));
					report.setRegno(regno);
					report.setPatientname(patientName);
					report.setSex(patientSex);
					report.setInvestigation(investigation);
					report.setStudydate(Studydate);
					report.setMods(mods);
					report.setDescription(desc);
					report.setRepordate(Reportdate); 
					report.setUserId(Integer.toString(userid)); 
					report.setDepartment(department);
					report.setDesignation(designation);
					report.setDoctorname(doctorname);
					report.setHospitalname(hospitalname);
					printPacsReportList.add(report);
					 
			}  
	 	}catch (SQLException e) 
		{ 
			e.printStackTrace();
		}  	
	 	 
		map.put("printPacsReportList", printPacsReportList);
		return map;
	}
	
	
	@Override
	public Map<String, Object> getsignatureDetails(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();   
		Connection con=getPacsConnection();
 		int userId=0;  
		if(dataMap.get("userId")!=null){
			userId =Integer.parseInt((String) dataMap.get("userId")); 
		}
	    byte[] signature=null;
		String query="select signature from users where signature is not null and eaarogya_user_id= "+userId;
		try{
		    Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(query);  
			while(rs.next()) {   
				signature=rs.getBytes("signature");  
			}  
	 	}catch (SQLException e) 
		{ 
			e.printStackTrace();
		}   
		map.put("signature", signature);
		return map;
	}
	
	/*@Override
	public Map<String, Object> centralServerService(Map<String, Object> dataMap) {
		Map<String, Object> map=new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;	
		String jsonData=(String)dataMap.get("jsonData");
		String tableName=(String)dataMap.get("tableName");
		int lock=(Integer)dataMap.get("lock");
		int leanHospitalId=(Integer)dataMap.get("leanHospitalId");
		String[] tableColumn=null;
		String[] manyToOne=null;
		int tableId=0;
		SynchronizationUtils synchronizationUtils=new SynchronizationUtils();
		try{
			char[] tName=tableName.toCharArray();
			tName[0] = Character.toLowerCase(tName[0]);
			String tableName1=new String(tName);		
			tableColumn=((String) SynchronizationUtils.class.getField(tableName1+"TableColumn").get(synchronizationUtils)).split(",");
			manyToOne=((String) SynchronizationUtils.class.getField(tableName1+"ManyToOne").get(synchronizationUtils)).split(",");
		}catch(NoSuchFieldException|SecurityException|IllegalArgumentException| IllegalAccessException e){
			e.printStackTrace();
		}
		tableId = tableColumn.length;
		JsonParser parser = new JsonParser();
		JsonElement patientsElement = parser.parse((String)jsonData);
	    JsonArray patientArray = patientsElement.getAsJsonArray();
	    Gson gson = new Gson();
	    boolean flag=false;
	    String msg="";
		try {
			tx = session.beginTransaction();
			for(int i=0;i<patientArray.size();i++){
	        	JsonArray array=patientArray.get(i).getAsJsonArray();
	        	int count=0;
	        	Object patient;
	        	 switch (tableName) {
					case "HrEmployeePersonelDetails": 
						patient =(Object) Class.forName("jkt.hrms.masters.business."+tableName).newInstance();
						break;
					default:
						patient=(Object) Class.forName("jkt.hms.masters.business."+tableName).newInstance();
						break;
					}
	        	
	        	for(int d=0;d<lock;d++){
	        	//for(String dataSet:patientTableColumn){
	        		String dataSet=tableColumn[d];
	        		String[] data=dataSet.split("#");
	        		Method method;
	        		Object arrDataSet=gson.fromJson(array.get(count), Object.class);
	        		if(arrDataSet!=null){
	        		try{
	        		switch (data[1]) {
					case "i":
						method=patient.getClass().getMethod("set"+data[0], Integer.class);
						method.invoke(patient, gson.fromJson(array.get(count), Integer.class));
						break;
					case "f":
						method=patient.getClass().getMethod("set"+data[0], Float.class);
						method.invoke(patient, gson.fromJson(array.get(count), Float.class));
						break;
					case "b":
//						method=patient.getClass().getMethod("set"+data[0], Byte[].class);
//						method.invoke(patient, gson.fromJson(array.get(count), Byte[].class));
						break;
					case "d":
						java.util.Date date=HMSUtil.convertStringTypeDateToDateType(gson.fromJson(array.get(count), String.class),"MMM d, yyyy");
						method=patient.getClass().getMethod("set"+data[0], java.util.Date.class);
						method.invoke(patient, date);
						break;
					case "t":
						java.util.Date date1=HMSUtil.convertStringTypeDateToDateType(gson.fromJson(array.get(count), String.class),"MMM d, yyyy HH:mm:ss");
						method=patient.getClass().getMethod("set"+data[0], java.util.Date.class);
						method.invoke(patient, date1);
						break;
					case "l":
						method=patient.getClass().getMethod("set"+data[0], Long.class);
						method.invoke(patient, gson.fromJson(array.get(count), Long.class));
						break;
					case "bd":
						method=patient.getClass().getMethod("set"+data[0], BigDecimal.class);
						method.invoke(patient, gson.fromJson(array.get(count), BigDecimal.class));
						break;
					case "s":
						method=patient.getClass().getMethod("set"+data[0], String.class);
						method.invoke(patient, gson.fromJson(array.get(count), String.class));
						break;
					}
	        		}catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
						e.printStackTrace();
					}
	        		}
	        		++count;
	        	}
	        	for(int u=lock;u<tableColumn.length-1;u++){
	        		String[] columnName=tableColumn[u].replace('.', '@').split("#");
	        		String[] className=columnName[0].split("@"); 
	        		switch (className[0]) {
					case "AddEditBy":
						List<Users> users=(List<Users>)session.createCriteria(Users.class, "u").add(Restrictions.eq(className[1], gson.fromJson(array.get(count), Integer.class)))
						.add(Restrictions.eq("Hospital.Id", leanHospitalId)).list();
						System.out.println("User Id -->"+array.get(count));
						if(users.size()>0){
							Users user = (Users)users.get(0);
							Method method=patient.getClass().getMethod("set"+className[0], Users.class);
							method.invoke(patient, (Users)users.get(0));
						}
						
						break;
					case "ChangedBy":
						List<Users> users1=(List<Users>)session.createCriteria(Users.class, "u").add(Restrictions.eq(className[1], gson.fromJson(array.get(count), String.class)))
						.add(Restrictions.eq("Hospital.Id", leanHospitalId)).list();
						if(users1.size()>0){
							Users user = (Users)users1.get(0);
							Method method=patient.getClass().getMethod("set"+className[0], Users.class);
							method.invoke(patient, user);
						}
						break;
					case "Visit":
						String hinNo="";
						int visitNo=0;
						switch (className[1]) {
						case "Hin":
							hinNo=gson.fromJson(array.get(count), String.class);
							visitNo=gson.fromJson(array.get(count+1), Integer.class);
							//++u;
							break;
						case "HinNo":
							hinNo=gson.fromJson(array.get(count-1), String.class);
							visitNo=gson.fromJson(array.get(count), Integer.class);
							break;
						case "VisitNo":
							hinNo=gson.fromJson(array.get(count-1), String.class);
							if(gson.fromJson(array.get(count), Object.class)==null)
							    visitNo=0;	
							else
							    visitNo=gson.fromJson(array.get(count), Integer.class);
							break;
						}
						List<Patient> patientsForV=(List<Patient>)session.createCriteria(Patient.class, "p")
						.add(Restrictions.eq("p.HinNo", hinNo))
								.add(Restrictions.eq("Hospital.Id", leanHospitalId)).list();
						if(patientsForV.size()==0){
							patientsForV=(List<Patient>)session.createCriteria(Patient.class, "p")
									.add(Restrictions.eq("p.HinNo", hinNo)).list();
						}
						if(patientsForV.size()>0){
						List<Visit> visits=(List<Visit>)session.createCriteria(Visit.class, "v")
						.add(Restrictions.eq("v.Hin.Id", patientsForV.get(0).getId()))
						.add(Restrictions.eq("v.VisitNo", visitNo)).list();
						if(visits.size()>0){
							Method method=patient.getClass().getMethod("set"+className[0], Visit.class);
							method.invoke(patient, (Visit)visits.get(0));
						}
						}
						break;
					case "Hin":
						System.out.println("Patient: "+className[1]+"  "+array.get(count)+"   count "+count);
						List<Patient> patients=(List<Patient>)session.createCriteria(Patient.class, "p")
						.add(Restrictions.eq(className[1], gson.fromJson(array.get(count), String.class)))
								.add(Restrictions.eq("Hospital.Id", leanHospitalId)).list(); 
						if(patients.size()==0){
							patients=(List<Patient>)session.createCriteria(Patient.class, "p")
									.add(Restrictions.eq(className[1], gson.fromJson(array.get(count), String.class))).list();
						}
						//System.out.println(patients.get(0).getId()+"<----->"+patients.get(0).getHinNo());
						if(patients.size()>0){
							Method method=patient.getClass().getMethod("set"+className[0], Patient.class);
							method.invoke(patient, (Patient)patients.get(0));
						}
						break;
					case "OpBillHeader":
						switch(className[1]){
						case "HinNo":
						List<BlOpBillHeader> billHeaders=(List<BlOpBillHeader>)session.createCriteria(BlOpBillHeader.class, "bh")
							.add(Restrictions.eq("bh.HinNo", gson.fromJson(array.get(count), String.class)))
							.add(Restrictions.eq("bh.BillNo", gson.fromJson(array.get(count+1), String.class)))
							.add(Restrictions.eq("bh.Hospital.Id", gson.fromJson(array.get(count+2), Integer.class))).list();
						if(billHeaders.size()>0){
							Method method2=patient.getClass().getMethod("set"+className[0], BlOpBillHeader.class);
							method2.invoke(patient, (BlOpBillHeader)billHeaders.get(0));
						}
						}
						u=u+2;
						count=count+2;
						break;
					case "PatientInvestigationDetails":
						String piHinNo = gson.fromJson(array.get(count), String.class);
						int piHospitalId = gson.fromJson(array.get(count+1), Integer.class);
						Date piDate = gson.fromJson(array.get(count+2), Date.class);
						String piTime = gson.fromJson(array.get(count+3), String.class);
						List<PatientInvestigationHeader> patientInvestigationHeaders = (List<PatientInvestigationHeader>)session.createCriteria(PatientInvestigationHeader.class, "pi")
								.add(Restrictions.eq("pi.Hin.HinNo", piHinNo))
								.add(Restrictions.eq("pi.Hospital.Id", piHospitalId))
								.add(Restrictions.eq("pi.InvestigationDate", piDate))
								.add(Restrictions.eq("pi.InvestigationTime", piTime)).list();
						if(patientInvestigationHeaders.size()>0){
							Method method2=patient.getClass().getMethod("set"+className[0], PatientInvestigationHeader.class);
							method2.invoke(patient, (PatientInvestigationHeader)patientInvestigationHeaders.get(0));
						}
						u=u+3;
						break;
					case "InvestigationRequestionNo":
						String iHinNo = gson.fromJson(array.get(count-3), String.class);
						int iHospitalId = gson.fromJson(array.get(count-1), Integer.class);
						Date iDate = gson.fromJson(array.get(count), Date.class);
						String iTime = gson.fromJson(array.get(count+1), String.class);
						List<PatientInvestigationHeader> patientInvestigationHeaders1 = (List<PatientInvestigationHeader>)session.createCriteria(PatientInvestigationHeader.class, "pi")
								.createAlias("pi.Hin", "p")
								.add(Restrictions.eq("p.HinNo", iHinNo))
								.add(Restrictions.eq("pi.Hospital.Id", iHospitalId))
								.add(Restrictions.eq("pi.InvestigationDate", iDate))
								.add(Restrictions.eq("pi.InvestigationTime", iTime)).list();
						if(patientInvestigationHeaders1.size()>0){
							Method method2=patient.getClass().getMethod("set"+className[0], PatientInvestigationHeader.class);
							method2.invoke(patient, (PatientInvestigationHeader)patientInvestigationHeaders1.get(0));
						}
						++u;
						++count;
						break;
					case "Orderhd":
						String hdHinNo=gson.fromJson(array.get(count), String.class);
						String hdOrderNo=gson.fromJson(array.get(count-1), String.class);
						List<DgOrderhd> dgOrderhds = (List<DgOrderhd>)session.createCriteria(DgOrderhd.class, "hd")
								.createAlias("hd.Hin", "h").add(Restrictions.eq("h.HinNo", hdHinNo))
								.add(Restrictions.eq("hd.OrderNo", hdOrderNo)).add(Restrictions.eq("hd.Hospital.Id", leanHospitalId)).list();
						if(dgOrderhds.size()>0){
							Method method2=patient.getClass().getMethod("set"+className[0], DgOrderhd.class);
							method2.invoke(patient, (DgOrderhd)dgOrderhds.get(0));
						}
						++u;
						++count;
						break;
					case "Inpatient":
						String inHinNo = gson.fromJson(array.get(count+1), String.class);
						String inAdNo = gson.fromJson(array.get(count), String.class); 
						List<Inpatient> inpatients = (List<Inpatient>)session.createCriteria(Inpatient.class,"ip")
								.createAlias("ip.Hin","p").add(Restrictions.eq("ip.AdNo", inAdNo)).add(Restrictions.eq("p.HinNo", inHinNo))
								.add(Restrictions.eq("ip.Hospital.Id", leanHospitalId)).list(); 
						if(inpatients.size()==0){
							inpatients = (List<Inpatient>)session.createCriteria(Inpatient.class,"ip")
									.createAlias("ip.Hin","p").add(Restrictions.eq("ip.AdNo", inAdNo)).add(Restrictions.eq("p.HinNo", inHinNo)).list();
						}
						if(inpatients.size()>0){
							Method method2=patient.getClass().getMethod("set"+className[0], Inpatient.class);
							method2.invoke(patient, (Inpatient)inpatients.get(0));
						} 
						break;
					case "SampleCollectionHeader":
						String scHinNo = "";
						Date scDate = null;
						String scTime = "";
									switch (tableName) {
									case "DgSampleCollectionDetails":
										scHinNo = gson.fromJson(array.get(count), String.class);
										scDate = gson.fromJson(array.get(count+1), Date.class);
										scTime = gson.fromJson(array.get(count+2), String.class);
										++u;
										++count;
										break;
									default:
										scHinNo = gson.fromJson(array.get(count-1), String.class);
										scDate = gson.fromJson(array.get(count), Date.class);
										scTime = gson.fromJson(array.get(count+1), String.class);
			//							++u;
			//							++count;
										break;
									}
						List<DgSampleCollectionHeader> dgscHeaderList = (List<DgSampleCollectionHeader>)session.createCriteria(DgSampleCollectionHeader.class,"sch")
								.createAlias("sch.Hin", "p").add(Restrictions.eq("p.HinNo", scHinNo)).add(Restrictions.eq("sch.LastChgDate", scDate)).add(Restrictions.eq("sch.LastChgTime", scTime))
								.add(Restrictions.eq("p.Hospital.Id", leanHospitalId)).list();
						if(dgscHeaderList.size()==0){
							dgscHeaderList = (List<DgSampleCollectionHeader>)session.createCriteria(DgSampleCollectionHeader.class,"sch")
									.createAlias("sch.Hin", "p").add(Restrictions.eq("p.HinNo", scHinNo)).add(Restrictions.eq("sch.LastChgDate", scDate)).add(Restrictions.eq("sch.LastChgTime", scTime))
									.list();
						}
						if(dgscHeaderList.size()>0){
							Method method2=patient.getClass().getMethod("set"+className[0], DgSampleCollectionHeader.class);
							method2.invoke(patient, (DgSampleCollectionHeader)dgscHeaderList.get(0));
						}
						++u;
						++count;
						break;
					case "ResultEntry":
						String rehHinNo = gson.fromJson(array.get(count), String.class);
						String resultEntryNo = gson.fromJson(array.get(count+1), String.class);
						List<DgResultEntryHeader> dgResultEntryHeaders = (List<DgResultEntryHeader>)session.createCriteria(DgResultEntryHeader.class,"reh")
								.createAlias("reh.Hin", "p").add(Restrictions.eq("p.HinNo", rehHinNo)).add(Restrictions.eq("reh.ResultNo", resultEntryNo)).add(Restrictions.eq("reh.Hospital.Id", leanHospitalId)).list();
						if(dgResultEntryHeaders.size()>0){
							Method method2=patient.getClass().getMethod("set"+className[0], DgResultEntryHeader.class);
							method2.invoke(patient, (DgResultEntryHeader)dgResultEntryHeaders.get(0));
						}
						++u;
						++count;
						break;
					case "SampleCollectionDetails":
						Date scdDate=gson.fromJson(array.get(count), Date.class);
						String scdTime = gson.fromJson(array.get(count+1), String.class);
						String scdHinNo = gson.fromJson(array.get(count-2), String.class);
						List<DgSampleCollectionDetails> dgSampleCollectionDetails = (List<DgSampleCollectionDetails>)session.createCriteria(DgSampleCollectionDetails.class,"scd")
								.createAlias("scd.SampleCollectionHeader", "sch").createAlias("sch.Hin", "p").add(Restrictions.eq("p.HinNo", scdHinNo))
								.add(Restrictions.eq("scd.LastChgDate", scdDate)).add(Restrictions.eq("scd.LastChgTime", scdTime)).add(Restrictions.eq("sch.Hospital.Id", leanHospitalId)).list();
						if(dgSampleCollectionDetails.size()>0){
							Method method2=patient.getClass().getMethod("set"+className[0], DgSampleCollectionDetails.class);
							method2.invoke(patient, (DgSampleCollectionDetails)dgSampleCollectionDetails.get(0));
						}
						++u;
						++count;
						break;
					case "FinalBill":  
						String csmHinNo = gson.fromJson(array.get(count-1), String.class);
						String csmAdNo = gson.fromJson(array.get(count-2), String.class);
						List<BlFinalBillDetails> blFinalBillDetails = (List<BlFinalBillDetails>)session.createCriteria(BlFinalBillDetails.class,"fbd")
								.createAlias("fbd.Hin", "p").createAlias("fbd.Inpatient", "ip")
								.add(Restrictions.eq("p.HinNo", csmHinNo)).add(Restrictions.eq("ip.AdNo", csmAdNo))
								.add(Restrictions.eq("fbd.Hospital.Id", leanHospitalId)).list(); 
						if(blFinalBillDetails.size()>0){  
							Method method2=patient.getClass().getMethod("set"+className[0], BlFinalBillDetails.class);
							method2.invoke(patient, (BlFinalBillDetails)blFinalBillDetails.get(0));
						}  
						break;
					case "IpFinalBill":  
						String bdhHinNo = gson.fromJson(array.get(count-1), String.class);
						String bdhAdNo = gson.fromJson(array.get(count-2), String.class);
						List<BlDispensingHeader> blDispensingHeader = (List<BlDispensingHeader>)session.createCriteria(BlDispensingHeader.class,"bdh")
								.createAlias("bdh.Hin", "p").createAlias("bdh.Inpatient", "ip")
								.add(Restrictions.eq("p.HinNo", bdhHinNo)).add(Restrictions.eq("ip.AdNo", bdhAdNo))
								.add(Restrictions.eq("bdh.Hospital.Id", leanHospitalId)).list(); 
						if(blDispensingHeader.size()>0){  
							Method method2=patient.getClass().getMethod("set"+className[0], BlDispensingHeader.class);
							method2.invoke(patient, (BlDispensingHeader)blDispensingHeader.get(0));
						}  
						break;
					case "ChargeSlipMain":  
						String csdHinNo = gson.fromJson(array.get(count), String.class); 
						List<BlChargeSlipMain> blChargeSlipMain = (List<BlChargeSlipMain>)session.createCriteria(BlChargeSlipMain.class,"csm")
								.createAlias("csm.Hin", "p").add(Restrictions.eq("p.HinNo", csdHinNo))
								.add(Restrictions.eq("csm.Hospital.Id", leanHospitalId)).list(); 
						if(blChargeSlipMain.size()>0){  
							Method method2=patient.getClass().getMethod("set"+className[0], BlChargeSlipMain.class);
							method2.invoke(patient, (BlChargeSlipMain)blChargeSlipMain.get(0));
						}  
						break;
					case "PatientStoreIndentHeader":  
						String psihHinNo = gson.fromJson(array.get(count+1), String.class);
						String psihAdNo = gson.fromJson(array.get(count), String.class);
						List<PatientStoreIndentHeader> patientStoreIndentHeader = (List<PatientStoreIndentHeader>)session.createCriteria(PatientStoreIndentHeader.class,"psih")
								.createAlias("psih.Hin", "p").createAlias("psih.Inpatient", "ip")
								.add(Restrictions.eq("p.HinNo", psihHinNo)).add(Restrictions.eq("ip.AdNo", psihAdNo))
								.add(Restrictions.eq("psih.Hospital.Id", leanHospitalId)).list(); 
						if(patientStoreIndentHeader.size()>0){  
							Method method2=patient.getClass().getMethod("set"+className[0], PatientStoreIndentHeader.class);
							method2.invoke(patient, (PatientStoreIndentHeader)patientStoreIndentHeader.get(0));
						} 
						++u;
						++count;
						break;
					case "DispensingHeader":  
						String dhHinNo = gson.fromJson(array.get(count+1), String.class);
						String dhAdNo = gson.fromJson(array.get(count), String.class);
						List<BlDispensingHeader> blDispensingHeader1 = (List<BlDispensingHeader>)session.createCriteria(BlDispensingHeader.class,"bdh")
								.createAlias("bdh.Hin", "p").createAlias("bdh.Inpatient", "ip")
								.add(Restrictions.eq("p.HinNo", dhHinNo)).add(Restrictions.eq("ip.AdNo", dhAdNo))
								.add(Restrictions.eq("bdh.Hospital.Id", leanHospitalId)).list(); 
						if(blDispensingHeader1.size()>0){  
							Method method2=patient.getClass().getMethod("set"+className[0], BlDispensingHeader.class);
							method2.invoke(patient, (BlDispensingHeader)blDispensingHeader1.get(0));
						} 
						++u;
						++count;
						break;
					case "Batch":  
						String dhPvmsNo = gson.fromJson(array.get(count), String.class); 
						List<StoreItemBatchStock> storeItemBatchStock = (List<StoreItemBatchStock>)session.createCriteria(StoreItemBatchStock.class,"sibs")
								.createAlias("sibs.Item", "i").add(Restrictions.eq("i.PvmsNo", dhPvmsNo)).add(Restrictions.eq("sibs.Hospital.Id", leanHospitalId)).list(); 
						if(storeItemBatchStock.size()>0){  
							Method method2=patient.getClass().getMethod("set"+className[0], StoreItemBatchStock.class);
							method2.invoke(patient, (StoreItemBatchStock)storeItemBatchStock.get(0));
						}  
						break;
					case "ReceiptHeader":  
						String rhNo = gson.fromJson(array.get(count), String.class); 
						List<BlReceiptHeader> blReceiptHeader = (List<BlReceiptHeader>)session.createCriteria(BlReceiptHeader.class,"rh")
								.createAlias("rh.Hin", "p").add(Restrictions.eq("p.HinNo", rhNo)).add(Restrictions.eq("rh.Hospital.Id", leanHospitalId)).list(); 
						if(blReceiptHeader.size()>0){  
							Method method2=patient.getClass().getMethod("set"+className[0], BlReceiptHeader.class);
							method2.invoke(patient, (BlReceiptHeader)blReceiptHeader.get(0));
						}  
						break;
					case "Prescription":  
						String iphNo = gson.fromJson(array.get(count), String.class); 
						List<InpatientPrescriptionHeader> inpatientPrescriptionHeader = (List<InpatientPrescriptionHeader>)session.createCriteria(InpatientPrescriptionHeader.class,"rh")
								.createAlias("rh.Hin", "p").add(Restrictions.eq("p.HinNo", iphNo)).add(Restrictions.eq("rh.Hospital.Id", leanHospitalId)).list(); 
						if(inpatientPrescriptionHeader.size()>0){  
							Method method2=patient.getClass().getMethod("set"+className[0], InpatientPrescriptionHeader.class);
							method2.invoke(patient, (InpatientPrescriptionHeader)inpatientPrescriptionHeader.get(0));
						}  
						break;
					case "IpIssue":
						Date imDate = gson.fromJson(array.get(count), Date.class);
						String imtime = gson.fromJson(array.get(count+1), String.class); 
						List<StoreIpIssueM> storeIpIssueM = (List<StoreIpIssueM>)session.createCriteria(StoreIpIssueM.class,"sipim")
								.add(Restrictions.eq("sipim.LastChgDate", imDate)).add(Restrictions.eq("sipim.LastChgTime", imtime)).add(Restrictions.eq("sipim.Hospital.Id", leanHospitalId)).list(); 
						if(storeIpIssueM.size()>0){  
							Method method2=patient.getClass().getMethod("set"+className[0], StoreIpIssueM.class);
							method2.invoke(patient, (StoreIpIssueM)storeIpIssueM.get(0));
						}  
						++u;
						++count;
						break;
					case "Internal":
						System.out.println("array.get(count) : "+array.get(count));
						int siitDeptId = gson.fromJson(array.get(count), Integer.class); 
						String siitDemandno = gson.fromJson(array.get(count+1), String.class);  
						Date siitDate = gson.fromJson(array.get(count+2), Date.class); 
						List<StoreInternalIndentM> storeInternalIndentM = (List<StoreInternalIndentM>)session.createCriteria(StoreInternalIndentM.class,"siim")
								.add(Restrictions.eq("siim.DemandNo", siitDemandno)).add(Restrictions.eq("siim.DemandDate", siitDate))
								.add(Restrictions.eq("siim.Department.Id", siitDeptId)).add(Restrictions.eq("siim.Hospital.Id", leanHospitalId)).list(); 
						if(storeInternalIndentM.size()>0){  
							Method method2=patient.getClass().getMethod("set"+className[0], StoreInternalIndentM.class);
							method2.invoke(patient, (StoreInternalIndentM)storeInternalIndentM.get(0));
						}  
						u=u+2;
						count=count+2;
						break;
					case "RequestNo":
						 siitDemandno = gson.fromJson(array.get(count), String.class);  
						 siitDeptId = gson.fromJson(array.get(count+1), Integer.class);
						 siitDate = gson.fromJson(array.get(count+2), Date.class);
						 String status = gson.fromJson(array.get(count+3), String.class);
						 storeInternalIndentM = (List<StoreInternalIndentM>)session.createCriteria(StoreInternalIndentM.class,"siim")
						.add(Restrictions.eq("siim.DemandNo", siitDemandno)).add(Restrictions.eq("siim.DemandDate", siitDate))
						//.add(Restrictions.eq("siim.Department.Id", siitDeptId))
						.add(Restrictions.eq("siim.Hospital.Id", leanHospitalId)).list(); 
						 if(storeInternalIndentM.size()>0){  
								Method method2=patient.getClass().getMethod("set"+className[0], StoreInternalIndentM.class);
								method2.invoke(patient, (StoreInternalIndentM)storeInternalIndentM.get(0));
								StoreInternalIndentM indentM=(StoreInternalIndentM)storeInternalIndentM.get(0);
								indentM.setStatus(status);
								hbt.update(indentM);
							}
						 u=u+3;
						count=count+3;
						break;
					case "IssueM":
						String issueNo = gson.fromJson(array.get(count), String.class);
						List<StoreIssueM> issueMs = (List<StoreIssueM>)session.createCriteria(StoreIssueM.class)
								.add(Restrictions.eq("IssueNo", issueNo)).add(Restrictions.eq("ToHospital.Id", leanHospitalId)).list();
						if(issueMs.size()>0){
							Method method2=patient.getClass().getMethod("set"+className[0], StoreIssueM.class);
							method2.invoke(patient, (StoreIssueM)issueMs.get(0));
						}
						break;
					case "Employee":
						String ecode = gson.fromJson(array.get(count), String.class);
						String efname = gson.fromJson(array.get(count+1), String.class);
						String elname = gson.fromJson(array.get(count+2), String.class);
						Date edoj = gson.fromJson(array.get(count+3), Date.class); 
						List<MasEmployee> employee = (List<MasEmployee>)session.createCriteria(MasEmployee.class)
								.add(Restrictions.eq("EmployeeCode", ecode)).add(Restrictions.eq("FirstName", efname))
								.add(Restrictions.eq("LastName", elname)).add(Restrictions.eq("JoinDate", edoj)).list();
						if(employee.size()>0){
							Method method2=patient.getClass().getMethod("set"+className[0], MasEmployee.class);
							method2.invoke(patient, (MasEmployee)employee.get(0));
						}
						u=u+3;
						count=count+3;
						break;
					case "User":
						int userId = gson.fromJson(array.get(count), Integer.class);
						String userName = gson.fromJson(array.get(count+1), String.class);
						List<Users> userlist = (List<Users>)session.createCriteria(Users.class)
								.add(Restrictions.eq("Id", userId)).add(Restrictions.eq("UserName", userName)).list();
						if(userlist.size()>0){
							Method method2=patient.getClass().getMethod("set"+className[0], Users.class);
							method2.invoke(patient, (Users)userlist.get(0));
						}
						System.out.println("userId : +"+userId+"\nuser name : "+userName);
						++u;
						++count;
						break;
					case "MasDepartment":
						String deptcode = gson.fromJson(array.get(count), String.class);
						String deptName = gson.fromJson(array.get(count+1), String.class);
						List<MasDepartment> deptlist = (List<MasDepartment>)session.createCriteria(MasDepartment.class)
								.add(Restrictions.eq("DepartmentCode", deptcode)).add(Restrictions.eq("DepartmentName", deptName)).list();
						if(deptlist.size()>0){
							Method method2=patient.getClass().getMethod("set"+className[0], MasDepartment.class);
							method2.invoke(patient, (MasDepartment)deptlist.get(0));
						}
						System.out.println("DepartmentCode : +"+deptcode+"\nDepartmentName : "+deptName);
						++u;
						++count;
						break;
	        		} 
	        	}
	        	++count;
	        	for(String dataSet:manyToOne){  
		        	//System.out.println(array.size()+"====Array Size===  "+array.get(count));
		        	//System.out.println(" count <-----> "+count);
		        	String[] data=dataSet.replace('.', '@').split("#");
		        	String[] methodName=data[0].split("@");
		        	Integer arrData=gson.fromJson(array.get(count), Integer.class);
		        	if(arrData!=null){
		        	try{
	        		Class dataClass = null;
	        		if(data[1].equals("MasLocation") || data[1].equals("MasEmployeeType") || data[1].equals("HrMasTrip") || data[1].equals("HrEmployeeExperience") || data[1].equals("HrEmployeePersonelDetails")){
	        			dataClass=Class.forName("jkt.hrms.masters.business."+data[1]);
	        		}else{
	        			dataClass=Class.forName("jkt.hms.masters.business."+data[1]);
	        		} 
	        		Method method=dataClass.getMethod("set"+methodName[1], Integer.class);
	        		Object ob=dataClass.newInstance();
	        		method.invoke(ob, arrData);
	        		Method method1=patient.getClass().getMethod("set"+methodName[0], dataClass);
	        		method1.invoke(patient, ob);
		        	}catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException e){
		        		e.printStackTrace();
		        	}
		        	}
	        		++count;
		         }
		         try{
		        	 Method method=patient.getClass().getMethod("setSynchStatus", Integer.class);
		        	 method.invoke(patient, 1);
		         }catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException  e){
		        		e.printStackTrace();
		        	}
		        // For StoreItemBatchStock
		         switch (tableName) {
				case "StoreItemBatchStock": 
					String sBatchNo=gson.fromJson(array.get(0), String.class);
					int sHospitalId=gson.fromJson(array.get(26), Integer.class);
					int sDepartmentId=gson.fromJson(array.get(27), Integer.class);
					int sItemId=gson.fromJson(array.get(29), Integer.class);
					//System.out.println(sBatchNo+" "+sHospitalId+" "+sDepartmentId+" "+sItemId);
					List<StoreItemBatchStock> batchStocks=session.createCriteria(StoreItemBatchStock.class, "sibs").add(Restrictions.eq("sibs.Item.Id", sItemId))
							.add(Restrictions.eq("sibs.Department.Id", sDepartmentId)).add(Restrictions.eq("sibs.BatchNo", sBatchNo)).add(Restrictions.eq("sibs.Hospital.Id", sHospitalId)).list();
					if(batchStocks.size()>0){
						StoreItemBatchStock batchStock=batchStocks.get(0);
						BigDecimal closingstock=gson.fromJson(array.get(11), BigDecimal.class);
						BigDecimal openingqty=gson.fromJson(array.get(3), BigDecimal.class);
						BigDecimal recivedqty=gson.fromJson(array.get(5), BigDecimal.class);
						BigDecimal issueqty=gson.fromJson(array.get(6), BigDecimal.class);
						Date lastChgDate=gson.fromJson(array.get(23), Date.class);
						batchStock.setClosingStock(closingstock);
						batchStock.setOpeningBalanceQty(openingqty);
						batchStock.setReceivedQty(recivedqty);
						batchStock.setIssueQty(issueqty);  
						batchStock.setLastChgDate(lastChgDate);
					  //System.out.println("Data Update "+batchStocks.get(0).getId());  
						hbt.update(batchStock);
					}else{
						hbt.save(patient);
					}
					break;
				default:
					 hbt.save(patient);
					break;
				}
		         hbt.flush();
		         hbt.clear();
				}
			msg="Successfully Synchronized.";
			flag=true;
			tx.commit();
		}catch(Exception e){
			msg="Try Again!";
			flag=false;
			e.printStackTrace();
			tx.rollback();
		}
		map.put("tableId", tableId);
		map.put("msg", msg);
		map.put("flag", flag);
		return map;
	}*/
	
	/*public Map<String, Object> sendData(Map<String, Object> dataMap){
		Map<String, Object> map = new HashMap<String, Object>();
		HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
		List<Object[]> dataList=new ArrayList<Object[]>();
		Gson gson = new Gson();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		String msg="";
		boolean flag=false;
		int leanHospitalId=0;
		int setMaxSize=0;
		String[] dataPackage;
		String[] packs;
		int lock=0;
		Properties prop = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("synchronized.properties");
				try {
					tx = session.beginTransaction();
					prop.load(new FileInputStream(new File(resourcePath.getFile())));
					leanHospitalId=Integer.parseInt(prop.get("lean.hospital.id")+"");
					setMaxSize=Integer.parseInt(prop.get("lean.data.size")+"");
					//dataPackage=((String)prop.get("lean.hospital.data.package")).split("#");
					dataPackage=((String)prop.get("lean.LeanToServer.data.package")).split("#");//for Store Data
					for(String dataPack:dataPackage){
						packs=((String)prop.get(dataPack)).split("#");
						//Each Package Making
						for(String pac:packs){
							String pack=pac.split("@")[0];
							lock=Integer.parseInt(pac.split("@")[1]);
							String query=SynchronizationUtils.getQuery(pack,lock,leanHospitalId);
							String subQuery="";
							switch(pack){
							case "BlOpBillDetails":
								subQuery="and OpBillHeader.Hospital.Id="+leanHospitalId;
								break;
							case "PatientInvestigationDetails":
								subQuery="and InvestigationHeader.Hospital.Id="+leanHospitalId;
								break;
							case "DgOrderdt":
								subQuery="and Orderhd.Hospital.Id="+leanHospitalId;
								break;
							case "DgSampleCollectionDetails":
								subQuery="and SampleCollectionHeader.Hospital.Id="+leanHospitalId;
								break;
							case "DgResultEntryDetail":
								subQuery="and ResultEntry.Hospital.Id="+leanHospitalId;
								break;
							case "PatientStoreIndentDetails":
								subQuery="and PatientStoreIndentHeader.Hospital.Id="+leanHospitalId;
								break; 
							case "BlDispensingDetails":
								subQuery="and DispensingHeader.Hospital.Id="+leanHospitalId;
								break; 
							case "BlReceiptDetails":
								subQuery="and ReceiptHeader.Hospital.Id="+leanHospitalId;
								break; 
							case "InpatientPrescriptionDetails":
								subQuery="and Prescription.Hospital.Id="+leanHospitalId;
								break; 
							case "StoreIpIssueT":
								subQuery="and IpIssue.Hospital.Id="+leanHospitalId;
								break; 
							case "StoreInternalIndentT":
								subQuery="and Internal.Hospital.Id="+leanHospitalId;
								break; 
							default: 
							subQuery="and Hospital.Id="+leanHospitalId;
							}
							 
							List<Long> totData=(List<Long>)session.createQuery("select count(Id) as int from "+pack+" where (SynchStatus=0 or SynchStatus is null) "+subQuery).list();
						 	long totList=totData.get(0);
						 	System.out.println(totList+"--Query: "+query);
							while(totList>0){
							dataList = session.createQuery(query).setMaxResults(setMaxSize).list();
							System.out.println(totList+"  DataSize: "+dataList.size()+" --- "+pack); 
							if(dataList.size()>0){
								tx = session.beginTransaction();
								 String jsonArray = "";
								 switch (pack) {
									case "DgResultEntryDetail":
										jsonArray = gson.toJson(dataList).replace('%', '^');
										break;
									case "DischargeSummary":
										jsonArray = gson.toJson(dataList).replace('%', '^');
										break;
									default:
										jsonArray = gson.toJson(dataList);
										break;
									}
								 String response =SynchronizationUtils.sendDataLeanToServer("&jsonData="+jsonArray+"&lock="+lock+"&tableName="+pack+"&hospitalId="+leanHospitalId);
								 JSONObject jsonObject = new JSONObject(response);
								 boolean synchFlag = (Boolean)jsonObject.get("flag");
								 int tableId = (Integer)jsonObject.get("tableId");
								 System.out.println(synchFlag+"  flag  ");
								 if(synchFlag){
									 for(int p=0;p<dataList.size();p++){
										 Query update=session.createQuery("update  "+pack+" set SynchStatus=:synchStatus where Id=:id");
										 update.setInteger("id", (Integer)dataList.get(p)[tableId-1]);
										 update.setInteger("synchStatus", 1);
										 int id=update.executeUpdate();
										 System.out.println(id+"  DataId: "+(Integer)dataList.get(p)[tableId-1]);
									 }
								 }
								 tx.commit();
								}
							//totList=0; 
							totList=totList-dataList.size(); 
							}
						}
					}
					 //tx.commit();
				}catch(Exception e){
					e.printStackTrace();
					tx.rollback();
				}
		
		map.put("msg", msg);
		return map;

	}*/
	
	/*@Override
	public Map<String, Object> receiveDataServerToLean(
			Map<String, Object> dataMap) {
		return null;
	}*/
	
	/*@Override
	public Map<String, Object> sendDataServerToLean(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
		List<Object[]> dataList=new ArrayList<Object[]>();
		List<SynchronizedUtil> synchronizationUtils = null;
		Gson gson = new Gson();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		Transaction tx = null;
		String msg="";
		int leanHospitalId=0;
		int serverHospitalId=0;
		int setMaxSize=0;
		String[] dataPackage;
		String[] packs;
		int lock=0;
		String leanUrl="";
		Properties prop = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("synchronized.properties");
				try {
					tx = session.beginTransaction();
					prop.load(new FileInputStream(new File(resourcePath.getFile())));
					serverHospitalId=Integer.parseInt(prop.get("server.hospital.id").toString());
					String[] leanHospital=prop.get("all.lean.hospital.id").toString().split("#");
					setMaxSize=Integer.parseInt(prop.get("lean.data.size")+"");
					dataPackage=((String)prop.get("server.ServerToLean.data.package")).split("#");
				for(String hospital:leanHospital){
					leanHospitalId=Integer.parseInt(hospital);
					leanUrl=prop.get(hospital).toString();
					// For Master Data
					synchronizationUtils = (List<SynchronizedUtil>)session.createCriteria(SynchronizedUtil.class).add(Restrictions.eq("Hospital.Id", leanHospitalId)).list();
				
					for(String dataPack:dataPackage){
						packs=((String)prop.get(dataPack)).split("#");
						//Each Package Making
						for(String pac:packs){
							String pack=pac.split("@")[0];
							lock=Integer.parseInt(pac.split("@")[1]);
							String query=SynchronizationUtils.getQueryForServerToLean(pack,lock,leanHospitalId);
							String subQuery="";
							switch(pack){
							case "MasStoreGroup":
								query=query+"and masstoregroup.Id > ";
								subQuery = " and Id>"+synchronizationUtils.get(0).getLastLeanStoregroup().getId();
								break;
							case "MasStoreSection":
								query=query+"and masstoresection.Id > ";
								subQuery = " and Id>"+synchronizationUtils.get(0).getLastLeanStoresection().getId();
								break;
							case "StoreIssueM":
								subQuery = " and ToHospital.Id="+leanHospitalId;
								break;
							case "StoreIssueT":
								subQuery = " and IssueM.ToHospital.Id="+leanHospitalId;
								break;
							case "MasStoreItem":
								query=query+" masstoreitem.Id > ";
								subQuery = " and Id>"+synchronizationUtils.get(0).getLeanLastItem().getId();
								break;
							case "MasCountry": 
								query=query+" mascountry.Id > ";
								subQuery = " and Id>"+synchronizationUtils.get(0).getLeanLastCountry().getId();
								break;
							case "MasState": 
								query=query+"and masstate.Id > ";
								subQuery = " and Id>"+synchronizationUtils.get(0).getLeanLastState().getId();
								break;
							case "MasDistrict": 
								query=query+"and masdistrict.Id > ";
								subQuery = " and Id>"+synchronizationUtils.get(0).getLeanLastDistrict().getId();
								break;
							case "MasManufacturer": 
								query=query+"and masmanufacturer.Id > ";
								subQuery = " and Id>"+synchronizationUtils.get(0).getLeanLastManufacturer().getId();
								break;
							case "MasStoreBrand": 
								query=query+"and masstorebrand.Id > ";
								subQuery = " and Id>"+synchronizationUtils.get(0).getLeanLastStorebrand().getId();
								break;
							case "MasDepartment":
								query=query+" masdepartment.Id > ";
								subQuery = " and Id>"+synchronizationUtils.get(0).getLeanLastDepartment().getId();
								break; 
							case "MasChargeCode":
								query=query+" maschargecode.Id > ";
								subQuery = " and Id>"+synchronizationUtils.get(0).getLastLeanCharge().getId();
								break;
							case "MasChargeCodeRates":
								query=query+" maschargecoderates.Id > ";
								subQuery = " and Id>"+synchronizationUtils.get(0).getLastLeanChargecoderates().getId();
								break; 
							case "MasRoomType":
								query=query+" masroomtype.Id > ";
								subQuery = " and Id>"+synchronizationUtils.get(0).getLastLeanRoomtype().getId();
								break;
							case "MasRoom":
								query=query+" masroom.Id > ";
								subQuery = " and Id>"+synchronizationUtils.get(0).getLastLeanRoom().getId();
								break;
							case "HrEmployeePersonelDetails":
								query=query+"and hremployeepersoneldetails.Id > ";
								subQuery = " and Id>"+synchronizationUtils.get(0).getLeanLastPersonaldetails().getId();
								break; 	
							case "MasEmployee":
								query=query+"and masemployee.Id > ";
								subQuery = " and Id>"+synchronizationUtils.get(0).getLeanLastEmployee().getId();
								break;
							case "MasBed":
								query=query+"and masbed.Id > ";
								subQuery = " and Id>"+synchronizationUtils.get(0).getLastLeanBed().getId();
								break; 
							case "UserHospital":
								query=query+"and userhospital.Id > ";
								subQuery = " and Id>"+synchronizationUtils.get(0).getLastLeanUserHospital().getId();
								break; 	
							case "Users":
								query=query+"and users.Id > ";
								subQuery = " and Id>"+synchronizationUtils.get(0).getLeanLastUser().getId();
								break; 	
							case "UserDepartment":
								query=query+"and userdepartment.Id > ";
								subQuery = " and Id>"+synchronizationUtils.get(0).getLastLeanUserDepartment().getId();
								break; 	
							case "StoreItemBatchStock":
								query=query+"  and storeitembatchstock.LastChgDate>='"+HMSUtil.convertDateToStringFormat(synchronizationUtils.get(0).getLastUpdateSibs(), "yyyy-MM-dd")+"'";
								subQuery = " and Hospital.Id=1 and LastChgDate>='"+HMSUtil.convertDateToStringFormat(synchronizationUtils.get(0).getLastUpdateSibs(), "yyyy-MM-dd")+"'";
								break; 	
							default: 
							subQuery="and Hospital.Id="+serverHospitalId;
							}
							List<Long> totData=(List<Long>)session.createQuery("select count(Id) as int from "+pack+" where (SynchStatus=0 or SynchStatus is null) "+subQuery).list();
							long totList=totData.get(0);
							String dynamicQuery = "";
							while(totList>0){
								SynchronizedUtil synchronizedUtil = (SynchronizedUtil)hbt.get(SynchronizedUtil.class, synchronizationUtils.get(0).getId());
								switch (pack) {
								case "MasStoreGroup": 
									dynamicQuery = ""+synchronizedUtil.getLastLeanStoregroup().getId();
									break;
								case "MasStoreSection": 
									dynamicQuery = ""+synchronizedUtil.getLastLeanStoresection().getId();
									break;
								case "MasStoreItem":
									dynamicQuery = ""+synchronizedUtil.getLeanLastItem().getId();
									break;
								case "MasCountry":
									dynamicQuery = ""+synchronizedUtil.getLeanLastCountry().getId();
									break;
								case "MasState":
									dynamicQuery = ""+synchronizedUtil.getLeanLastState().getId();
									break;
								case "MasDistrict":
									dynamicQuery = ""+synchronizedUtil.getLeanLastDistrict().getId();
									break;
								case "MasManufacturer":
									dynamicQuery = ""+synchronizedUtil.getLeanLastManufacturer().getId();
									break;
								case "MasStoreBrand":
									dynamicQuery = ""+synchronizedUtil.getLeanLastStorebrand().getId();
									break;
								case "MasDepartment":
									dynamicQuery = ""+synchronizedUtil.getLeanLastDepartment().getId();
									break;
								case "MasChargeCode":
									dynamicQuery = ""+synchronizedUtil.getLastLeanCharge().getId();
									break; 
								case "MasChargeCodeRates":
									dynamicQuery = ""+synchronizedUtil.getLastLeanChargecoderates().getId();
									break;
								case "MasRoomType":
									dynamicQuery = ""+synchronizedUtil.getLastLeanRoomtype().getId();
									break;
								case "MasRoom":
									dynamicQuery = ""+synchronizedUtil.getLastLeanRoom().getId();
									break;	
								case "HrEmployeePersonelDetails":
									dynamicQuery = ""+synchronizedUtil.getLeanLastPersonaldetails().getId();
									break;
								case "MasEmployee":
									dynamicQuery = ""+synchronizedUtil.getLeanLastEmployee().getId();
									break;
								case "MasBed":
									dynamicQuery = ""+synchronizedUtil.getLastLeanBed().getId();
									break;
								case "UserHospital":
									dynamicQuery = ""+synchronizedUtil.getLastLeanUserHospital().getId();
									break;
								case "Users":
									dynamicQuery = ""+synchronizedUtil.getLeanLastUser().getId();
									break;
								case "UserDepartment":
									dynamicQuery = ""+synchronizedUtil.getLastLeanUserDepartment().getId();
									break;
								case "StoreItemBatchStock":
									dynamicQuery = "  order by storeitembatchstock.Id asc";
									break;
								default:
									break;
								}
								System.out.println("Query: "+query);
								dataList = session.createQuery(query+dynamicQuery).setMaxResults(setMaxSize).list();
							// For Any Foreign key null 
							if(dataList.size()>0){
								tx = session.beginTransaction();
								 String jsonArray = "";
								 switch (pack) {
									case "MasStoreItem":
										jsonArray = gson.toJson(dataList).replace('%', '^');
										break;
									default:
										jsonArray = gson.toJson(dataList);
										break;
									}
								 String response =SynchronizationUtils.sendDataServerToLean(leanUrl, "&jsonData="+jsonArray+"&lock="+lock+"&tableName="+pack+"&hospitalId="+leanHospitalId);
								 JSONObject jsonObject = new JSONObject(response);
								 boolean synchFlag = (Boolean)jsonObject.get("flag");
								 int tableId = (Integer)jsonObject.get("tableId");
								 System.out.println(synchFlag+"  flag  ");
								 switch (pack) {
									case "MasStoreGroup":
										if(synchFlag){
											synchronizedUtil.setLastLeanStoregroup(new MasStoreGroup((Integer)dataList.get(dataList.size()-1)[tableId-1]));
											hbt.update(synchronizedUtil);
											synchFlag=false;
										}
										break;
									case "MasStoreSection":
										if(synchFlag){
											synchronizedUtil.setLastLeanStoresection(new MasStoreSection((Integer)dataList.get(dataList.size()-1)[tableId-1]));
											hbt.update(synchronizedUtil);
											synchFlag=false;
										}
										break;
									case "MasStoreItem":
										if(synchFlag){
											synchronizedUtil.setLeanLastItem(new MasStoreItem((Integer)dataList.get(dataList.size()-1)[tableId-1]));
											hbt.update(synchronizedUtil);
											synchFlag=false;
										}
										break;
									case "MasCountry":
										if(synchFlag){ 
											synchronizedUtil.setLeanLastCountry(new MasCountry((Integer)dataList.get(dataList.size()-1)[tableId-1]));
											hbt.update(synchronizedUtil);
											synchFlag=false;
										}
										break;
									case "MasState":
										if(synchFlag){ 
											synchronizedUtil.setLeanLastState(new MasState((Integer)dataList.get(dataList.size()-1)[tableId-1]));
											hbt.update(synchronizedUtil);
											synchFlag=false;
										}
										break;
									case "MasDistrict":
										if(synchFlag){ 
											synchronizedUtil.setLeanLastDistrict(new MasDistrict((Integer)dataList.get(dataList.size()-1)[tableId-1]));
											hbt.update(synchronizedUtil);
											synchFlag=false;
										}
										break;
									case "MasManufacturer":
										if(synchFlag){ 
											synchronizedUtil.setLeanLastManufacturer(new MasManufacturer((Integer)dataList.get(dataList.size()-1)[tableId-1]));
											hbt.update(synchronizedUtil);
											synchFlag=false;
										}
										break;
									case "MasStoreBrand":
										if(synchFlag){ 
											synchronizedUtil.setLeanLastStorebrand(new MasStoreBrand((Integer)dataList.get(dataList.size()-1)[tableId-1]));
											hbt.update(synchronizedUtil);
											synchFlag=false;
										}
										break;
									case "MasDepartment":
										if(synchFlag){
											synchronizedUtil.setLeanLastDepartment(new MasDepartment((Integer)dataList.get(dataList.size()-1)[tableId-1]));
											hbt.update(synchronizedUtil);
											synchFlag=false;
										}
										break;
									case "MasChargeCode":
										if(synchFlag){
											synchronizedUtil.setLastLeanCharge(new MasChargeCode((Integer)dataList.get(dataList.size()-1)[tableId-1]));
											hbt.update(synchronizedUtil);
											synchFlag=false;
										}
										break;
									case "MasChargeCodeRates":
										if(synchFlag){
											synchronizedUtil.setLastLeanChargecoderates(new MasChargeCodeRates((Integer)dataList.get(dataList.size()-1)[tableId-1]));
											hbt.update(synchronizedUtil);
											synchFlag=false;
										}
										
									case "MasRoomType":
										if(synchFlag){
											synchronizedUtil.setLastLeanRoomtype(new MasRoomType((Integer)dataList.get(dataList.size()-1)[tableId-1]));
											hbt.update(synchronizedUtil);
											synchFlag=false;
										}	
										break;
									case "MasRoom":
										if(synchFlag){
											synchronizedUtil.setLastLeanRoom(new MasRoom((Integer)dataList.get(dataList.size()-1)[tableId-1]));
											hbt.update(synchronizedUtil);
											synchFlag=false;
										}	
										break;
									case "HrEmployeePersonelDetails":
										if(synchFlag){
											synchronizedUtil.setLeanLastPersonaldetails(new HrEmployeePersonelDetails((Integer)dataList.get(dataList.size()-1)[tableId-1]));
											hbt.update(synchronizedUtil);
											synchFlag=false;
										}
										break;	
									case "MasEmployee":
										if(synchFlag){
											synchronizedUtil.setLeanLastEmployee(new MasEmployee((Integer)dataList.get(dataList.size()-1)[tableId-1]));
											hbt.update(synchronizedUtil);
											synchFlag=false;
										}
										break;
									case "MasBed":
										if(synchFlag){
											synchronizedUtil.setLastLeanBed(new MasBed((Integer)dataList.get(dataList.size()-1)[tableId-1]));
											hbt.update(synchronizedUtil);
											synchFlag=false;
										}
										break;
									case "UserHospital":
										if(synchFlag){
											synchronizedUtil.setLastLeanUserHospital(new UserHospital((Integer)dataList.get(dataList.size()-1)[tableId-1]));
											hbt.update(synchronizedUtil);
											synchFlag=false;
										}
										break;	
									case "Users":
										if(synchFlag){
											synchronizedUtil.setLeanLastUser(new Users((Integer)dataList.get(dataList.size()-1)[tableId-1]));
											hbt.update(synchronizedUtil);
											synchFlag=false;
										}
									case "StoreItemBatchStock":
										if(synchFlag){
											synchronizedUtil.setLastUpdateSibs(HMSUtil.getCurrentDateAndTimeObject());
											hbt.update(synchronizedUtil);
											synchFlag=false;
										}
										break;	
									case "UserDepartment":
										if(synchFlag){
											synchronizedUtil.setLastLeanUserDepartment(new UserDepartment((Integer)dataList.get(dataList.size()-1)[tableId-1]));
											hbt.update(synchronizedUtil);
											synchFlag=false;
										}
										break;	
									default:
										break;
								   }
								 int id=0;
								 if(synchFlag){
									 for(int p=0;p<dataList.size();p++){
										 Query update=session.createQuery("update  "+pack+" set SynchStatus=:synchStatus where Id=:id");
										 update.setInteger("id", (Integer)dataList.get(p)[tableId-1]);
										 update.setInteger("synchStatus", 1);
										 id=update.executeUpdate();
										 System.out.println(id+"  DataId: "+(Integer)dataList.get(p)[tableId-1]);
									 }
								 }
								 tx.commit();
								}
							//totList=0; 
							totList=totList-dataList.size(); 
							}
						}
					}
				}
				}catch(Exception e){
					e.printStackTrace();
					tx.rollback();
				}
		map.put("msg", msg);
		return map;
		}*/
}
