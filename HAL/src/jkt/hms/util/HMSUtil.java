package jkt.hms.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDivision;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.TransactionSequence;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.dcm4che.util.Base64;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.web.bind.RequestUtils;
import org.springframework.web.bind.ServletRequestBindingException;

// for excel reading and writing

import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

/*import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;*/



public class HMSUtil extends RequestUtils {
	String string;
    String st1[] = { "", "one", "two", "three", "four", "five", "six", "seven",
                    "eight", "nine", };
    String st2[] = { "hundred", "thousand", "lakh", "crore" };
    String st3[] = { "ten", "eleven", "twelve", "thirteen", "fourteen",
                    "fifteen", "sixteen", "seventeen", "eighteen", "ninteen", };
    String st4[] = { "twenty", "thirty", "fourty", "fifty", "sixty", "seventy",
                    "eighty", "ninty" };
	

	public static Map<String, Object> getKeyValuesFromURL(String urlPath) {
		Map<String, Object> valueMap = new HashMap<String, Object>();
		String[] keyValueArray = urlPath.split("&");
		for (int i = 1; i < keyValueArray.length; i++) {
			int indexOfEqualSign = keyValueArray[i].indexOf("=");
			String keyName = keyValueArray[i].substring(0, indexOfEqualSign);
			String keyValue = keyValueArray[i].substring(indexOfEqualSign + 1,
					keyValueArray[i].length());
			valueMap.put(keyName, keyValue);
		}		
		return valueMap;
	}
	
	 public static String now(String dateFormat) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			return sdf.format(cal.getTime());
		}
	 
	 public static String convertDatetoString(Date DOB) throws ParseException
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			return sdf.format(DOB);
		}
	    
    public static String convertSimple(int i) {
		return "" + i;
	}
    
    public static String PacsEncrypt(String password) {
		byte[] hashBytes = null;
		try {
		MessageDigest digest = MessageDigest.getInstance("SHA");
		hashBytes = digest.digest(password.getBytes("UTF-8"));
		} catch (Exception ex) {
		System.out.println("Unable to encrypt password: " + password);
		}
		String encryptedPassword = Base64.byteArrayToBase64(hashBytes);
		return encryptedPassword;
		}
	    
	public static String generateTransactionSequence(Map<String, Object> map, org.hibernate.Session session, HibernateTemplate hibernateTemplateObject) throws Exception{
		// Instance variable declaration
		int serviceTypeId = 0;
		String seqNumber = "1";
		String divisionName = "";
		List<TransactionSequence> transactionSequenceList = new ArrayList<TransactionSequence>();
		TransactionSequence tansSeqObj = new TransactionSequence();
		List<MasStoreFinancial> finacialList = new ArrayList<MasStoreFinancial>();
		MasDivision division = new MasDivision();
		/*String serviceTypeCode = (String)adMap.get("serviceTypeCode");*/
		/*serviceTypeId = Integer.parseInt(""+adMap.get("serviceTypeId"));*/
		/*Date date = new Date();
		String year = String.valueOf(date.getYear());
		int month = date.getMonth();*/
		Calendar date = Calendar.getInstance();
		System.out.println("Date"+date);
		/*String year = String.valueOf(date.get(Calendar.YEAR));*/
		String year = "";
		int month =(date.get(Calendar.MONTH) + 1);
		/*System.out.println("year"+year);*/
		System.out.println("month"+month);
		
		/*currentMonth =Integer.parseInt(""+date.substring(date.indexOf("/")+1, date.lastIndexOf("/"))) ;*/
		Integer hospitalId = null;
		Integer departmentId = null;
		Integer divisionId = null;
		String tableObjectName = (String)map.get("tableObjectName");
		String isMonthly = (String)(map.get("isMonthly"));
		String isYearly = (String)map.get("isYearly");
		String isHospitalWise =(String)map.get("isHospitalWise");
		String isDepartmentWise =(String)map.get("isDepartmentWise");
		String isDivisionWise =(String)map.get("isDivisionWise");
		String isPrefix = (String)map.get("isPrefix");
		String isPostfix = (String)map.get("isPostfix");
		String transactionPrefixProperty = "";
		String transactionPrefix = "";
		String transactionPostfixProperty = "";
		String transactionPostfix = "";
		
		/*String transactionPrefix = (String)map.get("transactionPrefix");
		String transactionSequenceName = (String)map.get("transactionSequenceName");*/
		int lastAdmMonth = 0;
		int currentMonth = 0;
		HibernateTemplate hbt = hibernateTemplateObject;
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		
		try{
			
			/*transactionSequenceList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionPrefix", "AD")).add(Restrictions.eq("ServiceType.Id",serviceTypeId)).add(Restrictions.eq("Hospital.Id", hospitalId)).list();*/
			/*finacialList = session.createCriteria(MasStoreFinancial.class)
					        .add(Restrictions.eq("Status", "y").ignoreCase())
					        .add(Restrictions.like("FinancialYear", year+"%").ignoreCase()).list();*/
			Date dt = new Date();
			finacialList = session.createCriteria(MasStoreFinancial.class)
			        .add(Restrictions.eq("Status", "y").ignoreCase())
			        .add(Restrictions.le("StartDate", dt))
			        .add(Restrictions.ge("EndDate", dt)).list();
			Criteria cr = session.createCriteria(TransactionSequence.class)
					     .add(Restrictions.eq("Tablename", tableObjectName));
			tansSeqObj.setTablename(tableObjectName);
			
			if(isHospitalWise!=null && isHospitalWise.trim().equalsIgnoreCase("y"))
			{
				System.out.println("hospoitalWise True");
				hospitalId = (Integer)map.get("hospitalId");
				cr.add(Restrictions.eq("Hospital.Id", hospitalId));
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				tansSeqObj.setHospital(masHospital);
			}
			if(isDepartmentWise!=null && isDepartmentWise.trim().equalsIgnoreCase("y"))
			{
				System.out.println("hospoitalWise True");
				departmentId = (Integer)map.get("departmentId");
				cr.add(Restrictions.eq("Department.Id", departmentId));
				MasDepartment department = new MasDepartment();
				department.setId(departmentId);
				tansSeqObj.setDepartment(department);
			}
		
			if(isPrefix!=null && isPrefix.trim().equalsIgnoreCase("y"))
			{
				System.out.println("prefix True");
				transactionPrefixProperty = (String)map.get("transactionPrefixProperty");
				transactionPrefix = HMSUtil.getProperties("adt.properties", transactionPrefixProperty).trim();
				cr.add(Restrictions.eq("TransactionPrefix", transactionPrefix));
				tansSeqObj.setTransactionPrefix(transactionPrefix);
				seqNumber=transactionPrefix+"/"+seqNumber;
			}
			if(isMonthly!=null && isMonthly.trim().equalsIgnoreCase("y"))
			{
				System.out.println("monthly True");
				cr.add(Restrictions.eq("Month", month));
				tansSeqObj.setMonth(month);
				seqNumber=seqNumber +"/"+month;
			}
			if(isYearly!=null && isYearly.trim().equalsIgnoreCase("y"))
			{ 
				System.out.println("yearly True");
				if(finacialList.size()>0)
				{
					cr.add(Restrictions.eq("Financial.Id", finacialList.get(0).getId()));
					tansSeqObj.setFinancial(finacialList.get(0));
					year = finacialList.get(0).getFinancialYear();
					seqNumber=seqNumber +"/"+year;
				}
				
			}
			if(isDivisionWise!=null && isDivisionWise.trim().equalsIgnoreCase("y"))
			{
				System.out.println("Division True");
				divisionId = (Integer)map.get("divisionId");
				cr.add(Restrictions.eq("Division.Id", divisionId));
				division = (MasDivision)session.get(MasDivision.class, divisionId);
				/*division.setId(divisionId);*/
				tansSeqObj.setDivision(division);
				divisionName=division.getDivisionName();
				seqNumber=divisionName+"/"+seqNumber;
			}
			
			if(isPostfix!=null && isPostfix.trim().equalsIgnoreCase("y"))
			{
				System.out.println("postfix True");
				transactionPostfixProperty = (String)map.get("transactionPostfixProperty");
				transactionPostfix = HMSUtil.getProperties("adt.properties", transactionPostfixProperty).trim();
				cr.add(Restrictions.eq("TransactionPostfix", transactionPostfix));
				tansSeqObj.setTransactionPostfix(transactionPostfix);
				seqNumber=seqNumber+"/"+transactionPostfix;
			}
			
			
			transactionSequenceList = cr.list();		
            System.out.println("transactionSequenceList.size()"+transactionSequenceList.size());
			if(transactionSequenceList.size() > 0 ){
			TransactionSequence transactionSequence = transactionSequenceList.get(0);
			transactionSequence.setTransactionSequenceNumber(transactionSequence.getTransactionSequenceNumber()+1);		
			hbt.update(transactionSequence);
			/*hbt.flush();*/
			seqNumber = String.valueOf(transactionSequence.getTransactionSequenceNumber());
		
			
			if(isPrefix!=null && isPrefix.trim().equalsIgnoreCase("y"))
			{
				seqNumber=transactionPrefix+"/"+seqNumber;
			}
			if(isMonthly!=null && isMonthly.trim().equalsIgnoreCase("y"))
			{
				seqNumber=seqNumber +"/"+month;
			}
			if(isYearly!=null && isYearly.trim().equalsIgnoreCase("y"))
			{
				if(finacialList.size()>0)
				{
					year = finacialList.get(0).getFinancialYear();
					seqNumber=seqNumber +"/"+year;
				}
				
			}
			if(isDivisionWise!=null && isDivisionWise.trim().equalsIgnoreCase("y"))
			{
				seqNumber=divisionName+"/"+seqNumber;
			}
			if(isPostfix!=null && isPostfix.trim().equalsIgnoreCase("y"))
			{
				seqNumber=seqNumber+"/"+transactionPostfix;
			}
			
			/*hbt.clear();*/
			
		}else if(transactionSequenceList.size() == 0){			
			tansSeqObj.setStatus("y");			
			tansSeqObj.setTransactionSequenceNumber(1);				
			hbt.save(tansSeqObj);	
			/*hbt.flush();*/
			
			//adNo="NO";
		}
		
		}catch(Exception e){		
			
			e.printStackTrace();
			throw e;

		}
		return seqNumber;
	}
	
	 public static String convertMonth(int month) {
			String pMonth = "";
			if(month == 1){
				pMonth = "January";
			}else if(month == 2){
				pMonth = "February";
			}else if(month == 3){
				pMonth = "March";
			}else if(month == 4){
				pMonth = "April";
			}else if(month == 5){
				pMonth = "May";
			}else if(month == 6){
				pMonth = "June";
			}else if(month == 7){
				pMonth = "July";
			}else if(month == 8){
				pMonth = "August";
			}else if(month == 9){
				pMonth = "September";
			}else if(month == 10){
				pMonth = "October";
			}else if(month == 11){
				pMonth = "November";
			}else if(month == 12){
				pMonth = "December";
			}
			return pMonth;
		}
	 
	public static boolean isInteger( String input )
	{
	   try
	   {
	      Integer.parseInt( input );
	      return true;
	   }
	   catch( Exception e)
	   {
	      return false;
	   }
	}
//hms
	public static Map<String, Object> getCurrentDateAndTime() {

		Map<String, Object> map = new HashMap<String, Object>();
		String currentDate = "";
		String currentTime = "";
		String currentTimeWithoutSc = "";
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String datetime = dateFormat.format(date);
		StringTokenizer s = new StringTokenizer(datetime, " ");
		while (s.hasMoreTokens()) {
			currentDate = s.nextToken();
			currentTime = s.nextToken();
		}
		map.put("currentDate", currentDate);
		/**
		 * Added By Ritu
		 */
		SimpleDateFormat dateFormatWithoutSc = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String datetimeWithoutSc = dateFormatWithoutSc.format(date);
		StringTokenizer strWithoutSc = new StringTokenizer(datetimeWithoutSc, " ");
		while (strWithoutSc.hasMoreTokens()) {
			strWithoutSc.nextToken();
			currentTimeWithoutSc = strWithoutSc.nextToken();
		}
		map.put("currentTime", currentTimeWithoutSc);
		map.put("currentTimeWithoutSc", currentTimeWithoutSc);
		return map;
	}

	public static Date addDaysToDate(String date, int daysToAdd) throws Exception {
		Date todayDate = new Date();
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = sdf.format(todayDate);
		Date parsedDate = sdf.parse(date);
		Calendar now = Calendar.getInstance();
		now.setTime(parsedDate);
		now.add(Calendar.DAY_OF_MONTH, daysToAdd);
		return now.getTime();
		}
	public static Map<String, Object> getCurrentTimeWithoutSecond() {

		Map<String, Object> map = new HashMap<String, Object>();
		String currentDate = "";
		String currentTime = "";
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		String datetime = dateFormat.format(date);
		StringTokenizer s = new StringTokenizer(datetime, " ");
		while (s.hasMoreTokens()) {
			currentDate = s.nextToken();
			currentTime = s.nextToken();
		}
		map.put("currentDate", currentDate);
		map.put("currentTime", currentTime);
		return map;
	}
	
		public static String getValuesFromPropertiesFile(String propertiesFileName,
				String key) {
			Properties properties = new Properties();
			String value = "";
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource(propertiesFileName);
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				value = properties.getProperty(key);
			} catch (Exception e) {
				e.printStackTrace();

			}

			// -value- "+value);
			return value;

		}

	
	public static String currentTime() {
		String newTime="";
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			
			Calendar now = Calendar.getInstance();
			
			
			newTime=now.get(now.HOUR_OF_DAY)+":"+now.get(now.MINUTE)+":"+now.get(now.SECOND);
		}catch(Exception e){
			e.printStackTrace();
		}
		return newTime;

	}

	public static String convertDateToStringWithoutTime(Date date) {
		int dateOfMonth, month, year;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		StringBuffer dateOnly = new StringBuffer();
		dateOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		if (dateOfMonth < 10)
			dateOnly.append("0");
		dateOnly.append(dateOfMonth);
		dateOnly.append("/");
		month = calendar.get(Calendar.MONTH) + 1;
		if (month < 10)
			dateOnly.append("0");
		dateOnly.append(month);
		dateOnly.append("/");
		year = calendar.get(Calendar.YEAR);
		dateOnly.append(year);
		// .append(" ").append(calendar.get(Calendar.HOUR_OF_DAY)).append(":").append(calendar.get(Calendar.MINUTE)).append(":").append(calendar.get(Calendar.SECOND));
		return dateOnly.toString();
	}

	public static Date dateFormatterDDMMYYYY(String stringDate) {
		SimpleDateFormat dateFormatterDDMMYYYY = new SimpleDateFormat(
				"dd/MM/yyyy");
		try {
			return (dateFormatterDDMMYYYY.parse(stringDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date convertStringTypeDateToDateType(String date) {
		Date orderDateTime = null;

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		if (date != null) {
			try {
				orderDateTime = df.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return orderDateTime;
	}

	@SuppressWarnings("deprecation")
	public static Object getParameterOrAttribute(HttpServletRequest request,
			String name, String type) {
		if (type.equals("String")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				try {
					return getStringParameter(request, name);
				} catch (ServletRequestBindingException e) {
				}
			}
		}
		if (type.equals("Int")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				try {
					return getIntParameter(request, name);
				} catch (ServletRequestBindingException e) {
				}
			}
		}
		if (type.equals("Float")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				try {
					return getFloatParameter(request, name);
				} catch (ServletRequestBindingException e) {
				}
			}
		}
		if (type.equals("Long")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				try {
					return getLongParameter(request, name);
				} catch (ServletRequestBindingException e) {
				}
			}
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	public static Object getParameterOrAttribute(HttpServletRequest request,
			String name, String type, String defaultValue) {
		if (type.equals("String")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				return getStringParameter(request, name, defaultValue);
			}
		}
		if (type.equals("Int")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				return getIntParameter(request, name, Integer
						.parseInt(defaultValue));
			}
		}
		if (type.equals("Float")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				return getFloatParameter(request, name, Float
						.parseFloat(defaultValue));
			}
		}
		if (type.equals("Long")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				return getLongParameter(request, name, Long
						.parseLong(defaultValue));
			}
		}
		return null;
	}

	public static String getDateFormat(Date date, String format) {
		SimpleDateFormat sdf;
		Date time = date;
		sdf = new SimpleDateFormat(format);
		String strDate = sdf.format(time);

		return strDate;
	}

	public static String changeDateToddMMyyyy(Date dbDate) {
		String strDate = dbDate.toString();
		String strNewDate = "", year = "", dt = "", month = "";
		year = strDate.substring(0, 4);
		month = strDate.substring(5, 7);
		dt = strDate.substring(8, 10);
		strNewDate = (dt + "/" + month + "/" + year);
		return strNewDate;
	}

	/**
	 *This is for calculate age for registation screen..
	 **/

	public static String calculateAge(Date birthDate) {
		// get todays date
		Calendar now = Calendar.getInstance();
		// get a calendar representing their birth date

		Calendar cal = Calendar.getInstance();
		cal.setTime(birthDate);

		// calculate age as the difference in years.
		@SuppressWarnings("unused")
		int calculatedDays, calculatedMonth, calculatedYear;
		int currentDays = now.get(Calendar.DATE);
		int birthDays = cal.get(Calendar.DATE);
		int currentMonth = now.get(Calendar.MONTH);
		int birthMonth = cal.get(Calendar.MONTH);
		int currentYear = now.get(Calendar.YEAR);
		int birthYear = cal.get(Calendar.YEAR);
		

		if (currentDays < birthDays) {
			currentDays = currentDays + 30;
			calculatedDays = currentDays - birthDays;
			currentMonth = currentMonth - 1;
		} else {
			calculatedDays = currentDays - birthDays;
		}

		if (currentMonth < birthMonth) {
			currentMonth = currentMonth + 12;
			calculatedMonth = currentMonth - birthMonth;
			currentYear = currentYear - 1;
		} else {
			calculatedMonth = currentMonth - birthMonth;
		}

		int age = currentYear - birthYear;
		String patientAge = "";

		if (age == 0 && calculatedMonth != 0 && calculatedDays != 0) {
			patientAge = calculatedMonth + " Months ";
		} else if (age == 0 && calculatedMonth == 0 && calculatedDays != 0) {
			patientAge = calculatedDays + "  Days";
		} 
		else if (age == 0 && calculatedMonth != 0 && calculatedDays == 0) {
			patientAge = calculatedMonth + " Months ";
		}
		else if (age == 0 && calculatedMonth == 0 && calculatedDays == 0) {
			patientAge = "1 Days";
		}
		else {
			patientAge = age + " Years ";
		}
		return patientAge;
	}

	/**
	 * Method Name : generateReport(String jasper_filename, Map parameters,
	 * Connection conn, HttpServletResponse response, ServletContext context)
	 * getCompiledReport(ServletContext context, String jasper_filename)
	 * Description : getCompiledReport() is a public static method used to
	 * compile the Jasper Report generateReport() is public static method used
	 * to call the compiled Jasper Report from Java Application.
	 * 
	 * @author Name: Othivadivel K R Create Date: 20.02.2008 Revision Date:
	 *         Revision By:
	 * @version 1.0
	 * @see
	 **/

	public synchronized static void generateReport(String jasper_filename, Map parameters,
			Connection conn, HttpServletResponse response,
			ServletContext context) {
		byte bytes[] = null;
		try {
			bytes = JasperRunManager.runReportToPdf(getCompiledReport(context,
					jasper_filename), parameters, conn);
			
			    
			if(!conn.isClosed())
			conn.close();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment; filename="
				+ jasper_filename + ".pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void generateReportDirectPrint(String jasper_filename, Map parameters,
			Connection conn, HttpServletResponse response,
			ServletContext context) {
		byte bytes[] = null;
		try {
		/*	bytes = JasperRunManager.runReportToPdf(getCompiledReport(context,
					jasper_filename), parameters, conn);*/
			
			    JasperPrint jp = JasperFillManager.fillReport(getCompiledReport(context,
						jasper_filename), parameters, conn);
			    JasperPrintManager.printReport(jp,false);
			    /*JasperViewer.viewReport(jp, false);*/
			    
			if(!conn.isClosed())
			conn.close();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*response.setHeader("Content-Disposition", "attachment; filename="
				+ jasper_filename + ".pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;*/
	/*	try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
*/
	}
	
	public static JasperPrint generateReportDirectPrintClientSide(String jasper_filename, Map parameters,
			Connection conn, HttpServletResponse response,
			ServletContext context) {
		byte bytes[] = null;
		JasperPrint jp = new JasperPrint();
		try {
		/*	bytes = JasperRunManager.runReportToPdf(getCompiledReport(context,
					jasper_filename), parameters, conn);*/
			
			    jp = JasperFillManager.fillReport(getCompiledReport(context,
						jasper_filename), parameters, conn);
			   /* JasperPrintManager.printReport(jp,false);*/
			    /*JasperViewer.viewReport(jp, false);*/
			    
			if(!conn.isClosed())
			conn.close();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*response.setHeader("Content-Disposition", "attachment; filename="
				+ jasper_filename + ".pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;*/
	/*	try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
*/
		return jp;
	}
	
	public static void generateHISReport(String jasper_filename, Map parameters,
			Connection conn, HttpServletResponse response,
			ServletContext context) {
		System.out.println("jasper_filename="+jasper_filename);
		byte bytes[] = null;
		try {
			bytes = JasperRunManager.runReportToPdf(getCompiledHISReport(context,
					jasper_filename), parameters, conn);
			if(!conn.isClosed())
			conn.close();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment; filename="
				+ jasper_filename + ".pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void generateReport1(String jasper_filename, Map parameters,
			Connection conn, HttpServletResponse response,
			ServletContext context) {
		byte bytes[] = null;
		try {
			bytes = JasperRunManager.runReportToPdf(getCompiledReport(context,
					jasper_filename), parameters, conn);
			if(!conn.isClosed())
			conn.close();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment; filename="
				+ jasper_filename + ".pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	

public static void generateReportInWord(String jasper_filename, Map parameters,
		Connection conn, HttpServletResponse response, ServletContext context){
		
		
		try{
			 ServletOutputStream ouputStream;
				
				ouputStream = response.getOutputStream();
				response.setContentType("application/x-download");
	            response.setHeader("Content-Disposition", "attachment; filename="+jasper_filename+".rtf");
	            
	            
			//String jasper_filename1 = context.getRealPath("/reports/" + jasper_filename + ".jrxml");
			//JasperCompileManager.compileReportToFile(jasper_filename1);
			
			String jasper_filename2 = context.getRealPath("/reports/" + jasper_filename + ".jasper");
			JasperFillManager.fillReportToFile(jasper_filename2, parameters, conn);
			
			String jasper_filename3 = context.getRealPath("/reports/" + jasper_filename + ".jrprint");
			File sourceFile = new File(jasper_filename3);
            JasperPrint jasperPrint = (JasperPrint)JRLoader.loadObject(sourceFile);
            JRRtfExporter exporter = new JRRtfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
            exporter.exportReport();
           
			ouputStream.flush();
			ouputStream.close();
			if(!conn.isClosed())
			conn.close();
			} catch (Exception e) 
			{
				e.printStackTrace();
			}

	}

	public static JasperReport getCompiledReport(ServletContext context,
			String fileName) throws JRException {
		File reportFile = new File(context.getRealPath("/reports/" + fileName
				+ ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile.getPath());
		return jasperReport;
	}
	
	public static JasperReport getCompiledHISReport(ServletContext context,
			String fileName) throws JRException {
		File reportFile = new File(context.getRealPath("/reports/HISReport/" + fileName
				+ ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile.getPath());
		return jasperReport;
	}

	/**
	 * This Method is for calculate patient age
	 **/
	public static String calculateAgeForADT(String ageAtRegTime,
			Date dateForCalculation) {
		Calendar now = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateForCalculation);

		int calculatedDays, calculatedMonth, calculatedYear;

		int currentDays = now.get(Calendar.DATE);
		int regDays = cal.get(Calendar.DATE);
		int currentMonth = now.get(Calendar.MONTH) + 1;
		int regMonth = cal.get(Calendar.MONTH) + 1;
		int currentYear = now.get(Calendar.YEAR);
		int regYear = cal.get(Calendar.YEAR);

		String patientAge = "";

		if (currentDays < regDays) {
			currentDays = currentDays + 30;
			calculatedDays = currentDays - regDays;
			currentMonth = currentMonth - 1;
		} else {
			calculatedDays = currentDays - regDays;
		}

		if (currentMonth < regMonth) {
			currentMonth = currentMonth + 12;
			calculatedMonth = currentMonth - regMonth;
			currentYear = currentYear - 1;
		} else {
			calculatedMonth = currentMonth - regMonth;
		}
		
		calculatedYear = currentYear - regYear;
		
		String oldAge = ageAtRegTime.substring(0, (ageAtRegTime.trim())
				.indexOf(" "));
		String ageUnit = ageAtRegTime.substring((ageAtRegTime.trim())
				.lastIndexOf(" ") + 1);
		int currentAge = Integer.parseInt(oldAge.trim());
		int newAgeYear = 0;
		if ((ageUnit.trim()).equals("Years")) {
			newAgeYear = currentAge + calculatedYear;
			patientAge = newAgeYear + " Years ";
		} else if ((ageUnit.trim()).equals("Months")) {
			if (calculatedYear > 0) {
				newAgeYear = calculatedYear;
				patientAge = newAgeYear + " Years ";
			} else {
				newAgeYear = currentAge + calculatedMonth;
				patientAge = newAgeYear + " Months ";
			}

		} else if ((ageUnit.trim()).equals("Days")) {
			if (calculatedYear > 0) {
				newAgeYear = calculatedYear;
				patientAge = newAgeYear + " Years ";
			} else if (calculatedMonth > 0) {
				newAgeYear = calculatedMonth;
				patientAge = newAgeYear + " Months ";
			} else {
				newAgeYear = currentAge + calculatedDays;
				patientAge = newAgeYear + " Days ";
			}
		}
		
		
		return patientAge;
	}
/**
 * This Method For Age Calculate with respect to date of birth 
 * 
 */
	public static String calculateAge(String ageAtRegTime,Date dateForCalculation , Date dateOfBirth) {

		Calendar now = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		String patientAge ="";
		if(dateOfBirth== null){
			int yr = (now.get(Calendar.YEAR));
			int hh= yr - (Integer.parseInt(ageAtRegTime.split(" ")[0]));
			String calDate ="01/"+"01/"+hh;
			System.out.println(calDate);
			dateOfBirth= new Date(calDate);
		}
		if(dateOfBirth !=null){
			patientAge = calculateAgeWithDateOfBirth(ageAtRegTime ,dateOfBirth);
		}else{
			patientAge = calculateAgeForADT(ageAtRegTime ,dateForCalculation);
		}
		
		return patientAge ;

	}
	public static String calculateAgeWithDateOfBirth(String ageAtRegTime,Date dateForCalculation)
	{   
		Calendar now = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateForCalculation);
		int calculatedDays, calculatedMonth, calculatedYear;

		int currentDays = now.get(Calendar.DATE);
		int regDays = cal.get(Calendar.DATE);
		int currentMonth = now.get(Calendar.MONTH) + 1;
		int regMonth = cal.get(Calendar.MONTH) + 1;
		int currentYear = now.get(Calendar.YEAR);
		int regYear = cal.get(Calendar.YEAR);

		String patientAge = "";

		if (currentDays < regDays) {
			currentDays = currentDays + 30;
			calculatedDays = currentDays - regDays;
			currentMonth = currentMonth - 1;
		} else {
			calculatedDays = currentDays - regDays;
		}

	if (currentMonth < regMonth) {
		currentMonth = currentMonth + 12;
		calculatedMonth = currentMonth - regMonth;
		currentYear = currentYear - 1;
	} else {
		calculatedMonth = currentMonth - regMonth;
	}

	calculatedYear = currentYear - regYear;
	double finalAge = calculatedYear +((calculatedMonth +(calculatedDays/30.00))/12.00);
	BigDecimal bd = new BigDecimal(finalAge);
	bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
	
    String oldAge = ageAtRegTime.substring(0, (ageAtRegTime.trim())
			.indexOf(" "));
	String ageUnit = ageAtRegTime.substring((ageAtRegTime.trim())
			.lastIndexOf(" ") + 1);
	int currentAge = Integer.parseInt(oldAge.trim());
	int newAgeYear = 0;
	if ((ageUnit.trim()).equals("Years")) {
		newAgeYear = calculatedYear;
		patientAge = newAgeYear + " Years ";
	} else if ((ageUnit.trim()).equals("Months")) {
		if (calculatedYear > 0) {
			newAgeYear = calculatedYear;
			patientAge = newAgeYear + " Years ";
		} else {
			newAgeYear = calculatedMonth;
			patientAge = newAgeYear + " Months ";
		}

	} else if ((ageUnit.trim()).equals("Days")) {
		if (calculatedYear > 0) {
			newAgeYear = calculatedYear;
			patientAge = newAgeYear + " Years ";
		} else if (calculatedMonth > 0) {
			newAgeYear = calculatedMonth;
			patientAge = newAgeYear + " Months ";
		} else {
			newAgeYear = calculatedDays;
			patientAge = newAgeYear + " Days ";
		}
	}
	     
		return patientAge;
	}
/**
 * End of Age Calculation with respect to date of birth 
 */	
	/**
	 * This Method is for calculate patient age
	 **/
	public static String calculateAgeForADT2(String ageAtRegTime,
			Date dateForCalculation) {
		Calendar now = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateForCalculation);

		int calculatedDays, calculatedMonth, calculatedYear;

		int currentDays = now.get(Calendar.DATE);
		int regDays = cal.get(Calendar.DATE);
		int currentMonth = now.get(Calendar.MONTH) + 1;
		int regMonth = cal.get(Calendar.MONTH) + 1;
		int currentYear = now.get(Calendar.YEAR);
		int regYear = cal.get(Calendar.YEAR);

		String patientAge = "0";

		if (currentDays < regDays) {
			currentDays = currentDays + 30;
			calculatedDays = currentDays - regDays;
			currentMonth = currentMonth - 1;
		} else {
			calculatedDays = currentDays - regDays;
		}

		if (currentMonth < regMonth) {
			currentMonth = currentMonth + 12;
			calculatedMonth = currentMonth - regMonth;
			currentYear = currentYear - 1;
		} else {
			calculatedMonth = currentMonth - regMonth;
		}

		calculatedYear = currentYear - regYear;

		String oldAge = ageAtRegTime.substring(0, (ageAtRegTime.trim())
				.indexOf(" "));
		String ageUnit = ageAtRegTime.substring((ageAtRegTime.trim())
				.lastIndexOf(" ") + 1);
		int currentAge = Integer.parseInt(oldAge.trim());
		int newAgeYear = 0;
		if ((ageUnit.trim()).equals("Years")) {
			newAgeYear = currentAge + calculatedYear;
			patientAge = newAgeYear + "";
		} else if ((ageUnit.trim()).equals("Months")) {
			if (calculatedYear > 0) {
				newAgeYear = calculatedYear;
				patientAge = newAgeYear + "";
			}

		} else if ((ageUnit.trim()).equals("Days")) {
			if (calculatedYear > 0) {
				newAgeYear = calculatedYear;
				patientAge = newAgeYear + "";
			}
		}
		return patientAge;
	}

	/**
	 * Method Name : getBox(HttpServletRequest request) Description : Make Box
	 * object with request parameter values
	 * 
	 * @author Name: Othivadivel K R Create Date: 17.03.2008 Revision Date:
	 *         Revision By:
	 * @param request
	 *            - HttpServletRequest
	 * @return box
	 * @version 1.0
	 * @see
	 **/
	public static Box getBox(HttpServletRequest request) {
		Box box = new Box("requestbox");
		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			box.put(key, request.getParameterValues(key));
		}
		return box;
	}
	
	public static Box getBox(MultipartFormDataRequest request) {
		Box box = new Box("requestbox");

		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			box.put(key, request.getParameterValues(key));
		}

		return box;
	}
	/**
	 * Method Name : isSelected(Object option_val, Object select_val)
	 * Description : To retain the selected value in Combo when the Page is
	 * submitted.
	 * 
	 * @author Name: Othivadivel K R Create Date: 17.03.2008 Revision Date:
	 *         Revision By:
	 * @return String
	 * @version 1.0
	 * @see
	 **/

	public static String isSelected(Object option_val, Object select_val) {
		if (option_val == null || select_val == null) {
			return "";
		}

		return (option_val).equals(select_val) ? "SELECTED" : "";
	}

	public static List<Object> uploadFile(MultipartFormDataRequest mrequest,
			String uploadURL, String whiteList, String fileNameToBeAssigned) {

		List fileUploadedList = new ArrayList();
		boolean fileUploaded = false;
		try {

			UploadBean upBean = new UploadBean();

			upBean.setFolderstore(uploadURL);
			upBean.setOverwrite(true);
			upBean.setWhitelist(whiteList);
			// upBean.setFilesizelimit(fileSizeLimit);
			Hashtable files = mrequest.getFiles();
			UploadFile file = (UploadFile) files
					.get(RequestConstants.UPLOAD_FILENAME);
			String fileName = file.getFileName();

			Long fileSize = file.getFileSize();

			if (fileName != null && fileSize > 0) // && fileSize <= 2097152 )
			{
				// SimpleDateFormat sdf = new
				// SimpleDateFormat("yyyyMMdd_HHmmss");
				// String date = sdf.format(new Date());
				int length = fileName.length();
				int index = fileName.indexOf(".");
				String ext = fileName.substring(index, length);
				file.setFileName(fileNameToBeAssigned);
				upBean.store(mrequest, RequestConstants.UPLOAD_FILENAME);
				fileUploaded = true;
				fileUploadedList.add(fileUploaded);
				if (fileUploaded) {
					fileUploadedList.add(fileName);
					fileUploadedList.add(file.getFileName());
				}
			}
		} catch (UploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileUploadedList;
	}

	public static List<Object> uploadFileForDiognistic(
			MultipartFormDataRequest mrequest, String uploadURL,
			String whiteList, String fileNameToBeAssigned) {

		List fileUploadedList = new ArrayList();
		boolean fileUploaded = false;
		try {

			UploadBean upBean = new UploadBean();

			upBean.setFolderstore(uploadURL);
			upBean.setOverwrite(true);
			upBean.setWhitelist(whiteList);
			// upBean.setFilesizelimit(fileSizeLimit);
			Hashtable files = mrequest.getFiles();
			UploadFile file = (UploadFile) files
					.get(RequestConstants.UPLOAD_FILENAME);
			String fileName = file.getFileName();

			Long fileSize = file.getFileSize();

			if (fileName != null && fileSize > 0) // && fileSize <= 2097152 )
			{
				// SimpleDateFormat sdf = new
				// SimpleDateFormat("yyyyMMdd_HHmmss");
				// String date = sdf.format(new Date());
				int length = fileName.length();

				int index = fileName.indexOf(".");
				String ext = fileName.substring(index, length);
				file.setFileName(fileNameToBeAssigned);
				upBean.store(mrequest, RequestConstants.UPLOAD_FILENAME);
				fileUploaded = true;
				fileUploadedList.add(fileUploaded);
				if (fileUploaded) {
					fileUploadedList.add(fileName);
					fileUploadedList.add(file.getFileName());
				}
			}
		} catch (UploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileUploadedList;
	}

	/**
	 * made by Priyanka Garg method is overloaded for uploading multiple files.
	 */
	public static List<Object> uploadFile(MultipartFormDataRequest mrequest,
			String uploadURL, String whiteList, String fileNameToBeAssigned,
			int i) {

		List fileUploadedList = new ArrayList();
		boolean fileUploaded = false;
		try {

			UploadBean upBean = new UploadBean();
			upBean.setFolderstore(uploadURL);
			upBean.setOverwrite(true);
			upBean.setWhitelist(whiteList);
			// upBean.setFilesizelimit(fileSizeLimit);
			System.out.println("mrequest-->"+mrequest);
			Hashtable files = mrequest.getFiles();
			UploadFile file = (UploadFile) files
					.get(RequestConstants.UPLOAD_FILENAME + i);
				String fileName = file.getFileName();

			Long fileSize = file.getFileSize();

			if (fileName != null && fileSize > 0) // && fileSize <= 2097152 )
			{
				// SimpleDateFormat sdf = new
				// SimpleDateFormat("yyyyMMdd_HHmmss");
				// String date = sdf.format(new Date());
				int length = fileName.length();
				int index = fileName.indexOf(".");
				String ext = fileName.substring(index, length);
				file.setFileName(fileNameToBeAssigned);
				upBean.store(mrequest, RequestConstants.UPLOAD_FILENAME + i);
				fileUploaded = true;
				fileUploadedList.add(fileUploaded);
				if (fileUploaded) {
					fileUploadedList.add(fileName);
					fileUploadedList.add(file.getFileName());
				}
			}
		} catch (UploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileUploadedList;
	}

	public static List<Object> uploadFileMedicalExam(MultipartFormDataRequest mrequest,
			String uploadURL, String whiteList, String fileNameToBeAssigned)
	{

		List fileUploadedList = new ArrayList();
		boolean fileUploaded = false;
		try {
			UploadBean upBean = new UploadBean();

			upBean.setFolderstore(uploadURL);
			upBean.setOverwrite(true);
			upBean.setWhitelist(whiteList);
			// upBean.setFilesizelimit(fileSizeLimit);
			Hashtable files = mrequest.getFiles();
			UploadFile file = (UploadFile) files
					.get(RequestConstants.UPLOAD_FILENAME);
			String fileName = file.getFileName();
            //System.out.println("fileName =====>"+fileName);
			Long fileSize = file.getFileSize();

			if (fileName != null && fileSize > 0) // && fileSize <= 2097152 )
			{
				// SimpleDateFormat sdf = new
				// SimpleDateFormat("yyyyMMdd_HHmmss");
				// String date = sdf.format(new Date());
				int length = fileName.length();
				int index = fileName.indexOf(".");
				String ext = fileName.substring(index, length);
				file.setFileName(fileNameToBeAssigned);
				upBean.store(mrequest, RequestConstants.UPLOAD_FILENAME );
				fileUploaded = true;
				fileUploadedList.add(fileUploaded);
				if (fileUploaded) {
					fileUploadedList.add(fileName);
					fileUploadedList.add(file.getFileName());
				}
			}
		} catch (UploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileUploadedList;
	}

	public static String getContent(String filePath) {
		File file = new File(filePath);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;
		StringBuffer content = new StringBuffer();

		try {
			fis = new FileInputStream(file);

			// Here BufferedInputStream is added for fast reading.
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);

			// dis.available() returns 0 if the file does not have more lines.
			while (dis.available() != 0) {

				// this statement reads the line from the file and print it to
				// the console.
				content.append(dis.readLine());
				// //System.out.println(dis.readLine());

			}

			// dispose all the resources after using them.
			fis.close();
			bis.close();
			dis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content.toString();
	}

	public static String getTextFromFile(String filePath) {
		// Opens a text file and returns the text from it.
		StringBuffer contents = new StringBuffer();

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = null;
			while ((line = reader.readLine()) != null) {
				contents.append(line);
				contents.append(System.getProperty("line.separator"));
			}
		} catch (FileNotFoundException ex1) {
			System.err.println("Invalid file path :" + ex1);
		} catch (IOException ex2) {
			System.err.println("cannot read from the file :" + ex2);
		} finally {
			try {
				reader.close();
			} catch (IOException ex3) {
				System.err.println("cannot close the file :" + ex3);
			}
		}
		//System.out.println("CONTENT TO STRING " + contents.toString());
		return contents.toString();
	}

	public static String encryptPassword(String password) {

		MessageDigest md = null;
		byte[] msg = null;
		try {
			md = MessageDigest.getInstance("MD5");
			msg = password.getBytes("UTF8");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md.update(msg);
		byte[] aMessageDigest = md.digest();
		String encrpyptedPassword = new sun.misc.BASE64Encoder()
				.encode(aMessageDigest);
		return encrpyptedPassword;
	}

	public static boolean validatePassword(String passwordFromDB,
			String passwordFromRequest) {

		byte[] bMessageDigest = null;
		byte[] byteArrayFromDatabase = null;
		byte[] byteArrayFromRequest = null;
		MessageDigest md = null;
		boolean bool = false;
		try {
			md = MessageDigest.getInstance("MD5");
			bMessageDigest = passwordFromRequest.getBytes("UTF8");
			md.update(bMessageDigest);
			byteArrayFromRequest = md.digest();
			byteArrayFromDatabase = new sun.misc.BASE64Decoder()
					.decodeBuffer(passwordFromDB);
			bool = MessageDigest.isEqual(byteArrayFromRequest,
					byteArrayFromDatabase);
			//System.out.println("bool===========" + bool);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	public static Date dateFormatterddmmyy(String stringDate) {
		SimpleDateFormat dateFormatterDDMMYYYY = new SimpleDateFormat(
				"dd-MM-yyyy");
		try {
			return (dateFormatterDDMMYYYY.parse(stringDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date dateFormatteryyyymmdd(String stringDate) throws Exception {
		SimpleDateFormat dateFormatterYYYYMMDD = new SimpleDateFormat(
				"yyyy-MM-dd");
		try {
			return (dateFormatterYYYYMMDD.parse(stringDate));
		} catch (ParseException e) {
			e.printStackTrace();
			throw e;			
		}
		
	}
	
	public static Date dateFormatterddmmmyyyy(String stringDate) {
		SimpleDateFormat dateFormatterYYYYMMDD = new SimpleDateFormat(
				"dd-MMM-yyyy");
		try {
			return (dateFormatterYYYYMMDD.parse(stringDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Integer getDayOfWeek(String day) {
		Integer dayCode = null;
		if (day == null) {
			return null;
		}

		if (day.equalsIgnoreCase("Sunday")) {
			dayCode = 0;
		} else if (day.equalsIgnoreCase("Monday")) {
			dayCode = 1;
		} else if (day.equalsIgnoreCase("Tuesday")) {
			dayCode = 2;
		} else if (day.equalsIgnoreCase("Wednesday")) {
			dayCode = 3;
		} else if (day.equalsIgnoreCase("Thursday")) {
			dayCode = 4;
		} else if (day.equalsIgnoreCase("Friday")) {
			dayCode = 5;
		} else if (day.equalsIgnoreCase("Saturday")) {
			dayCode = 6;
		}

		return dayCode;
	}

	public static String convertDateTypeToStringWithoutTime(Date date) {
		int dateOfMonth, month, year;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		StringBuffer dateOnly = new StringBuffer();
		dateOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		if (dateOfMonth < 10)
			dateOnly.append("0");
		dateOnly.append(dateOfMonth);
		dateOnly.append("-");
		month = calendar.get(Calendar.MONTH) + 1;
		if (month < 10)
			dateOnly.append("0");
		dateOnly.append(month);
		dateOnly.append("-");
		year = calendar.get(Calendar.YEAR);
		dateOnly.append(year);
		// .append("
		// ").append(calendar.get(Calendar.HOUR_OF_DAY)).append(":").append(calendar.get(Calendar.MINUTE)).append(":").append(calendar.get(Calendar.SECOND));
		return dateOnly.toString();
	}
	public static void writeTextFile(String exc,ServletContext context){
	   
		BufferedWriter output = null;
	    String text = exc;
	    String osName = System.getProperty("os.name");
 		String userHome = context.getRealPath("");
 		String fileSeparator = System.getProperty("file.separator");
 		String finalHomePath = userHome.substring(0,userHome.lastIndexOf(fileSeparator))+fileSeparator+"HMSDocumentFolder"+fileSeparator+"LogFolder"+fileSeparator+"hms_log" + ".txt";
 		File file = new File(finalHomePath);
	   
	    try {
	    	output = new BufferedWriter(new FileWriter(file , true));
			output.append(text);
			output.newLine();
			output.close();
			////System.out.println("Your file has been written");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
	    }
	
	 
	 @SuppressWarnings("unused")
	public static void doReadWriteTextFile(String outputFileName,ServletContext context) {
	        try {
	       
	        	 File inputFileName = new File(context.getRealPath("/TempFolder/hms_log" + ".txt"));
	            
	            FileReader inputFileReader   = new FileReader(inputFileName);
	            FileWriter outputFileReader  = new FileWriter(outputFileName , true);

	            BufferedReader inputStream   = new BufferedReader(inputFileReader);
	            PrintWriter    outputStream  = new PrintWriter(outputFileReader);

	            String inLine = null;
	            while ((inLine = inputStream.readLine()) != null) {
	                outputStream.println(inLine);
	              
	            }

	            outputStream.close();
	            inputStream.close();

	        } catch (IOException e) {

	            //System.out.println("IOException:");
	            e.printStackTrace();

	        }
	 }
	//----------For upload photo...
	 

     public static List<Object> uploadTicketFile(MultipartFormDataRequest mrequest, String uploadURL,String whiteList,String fileNameToBeAssigned )
        {

                    List fileUploadedList = new ArrayList();
                boolean fileUploaded = false;
                      try {

                      UploadBean upBean = new UploadBean();
                upBean.setFolderstore(uploadURL);
                upBean.setOverwrite(true);
                upBean.setWhitelist(whiteList);

                //upBean.setFilesizelimit(fileSizeLimit);
                Hashtable files = mrequest.getFiles();

                UploadFile file = (UploadFile)
                files.get(RequestConstants.UPLOAD_FILENAME);

                String fileName = file.getFileName();

                      Long fileSize = file.getFileSize();

                if (fileName != null && fileSize > 0 ) //&& fileSize <=2097152 )
                {
                    //SimpleDateFormat sdf = newSimpleDateFormat("yyyyMMdd_HHmmss");
                    //String date = sdf.format(new Date());
                    int length = fileName.length();
                    int index = fileName.indexOf(".");

                    String ext = fileName.substring(index, length);
System.out.println("fileNameToBeAssigned--- "+fileNameToBeAssigned);
                    file.setFileName(fileNameToBeAssigned);
                    //System.out.println("upbean::"+upBean.getFolderstore());
                    //System.out.println("UPLOAD_FILENAME::"+mrequest.getParameter(RequestConstants.UPLOAD_FILENAME));
                     upBean.store(mrequest,RequestConstants.UPLOAD_FILENAME);

                    fileUploaded = true;
                    fileUploadedList.add(fileUploaded);
                    if(fileUploaded)
                    {
                        fileUploadedList.add(fileName);

                        fileUploadedList.add(file.getFileName());
                    }
                }

              } catch (UploadException e) 

              {
                  e.printStackTrace();

              }catch(IOException e)
              {
                  e.printStackTrace();

              }
              return fileUploadedList;
        }
     public static String createFileAndFolder(HttpServletRequest request)
     {
    	
 		String osName = System.getProperty("os.name");
 		String userHome = request.getRealPath("");
 		String fileSeparator = System.getProperty("file.separator");
 		String finalHomePath = userHome.substring(0,userHome.lastIndexOf(fileSeparator))+fileSeparator+"HMSDocumentFolder";
 		File fileDirectory = null ;
		
		   fileDirectory = new File(finalHomePath);	
		   if(!fileDirectory.exists()){
			   fileDirectory.mkdir();
		   }
		   fileDirectory = new File(""+finalHomePath+fileSeparator+"LogFolder");
		   if(!fileDirectory.exists()){
			   fileDirectory.mkdir();
		   }
		   fileDirectory = new File(""+finalHomePath+fileSeparator+"photo");
		   if(!fileDirectory.exists()){
			   fileDirectory.mkdir();
		   }
		   fileDirectory = new File(""+finalHomePath+fileSeparator+"upload");
		   if(!fileDirectory.exists()){
			   fileDirectory.mkdir();
		   }
		   try {
					Properties prop = new Properties();
					FileInputStream fis = new FileInputStream(userHome+fileSeparator+"WEB-INF"+fileSeparator+"log4j.properties");
					File file = new File(userHome+fileSeparator+"WEB-INF"+ fileSeparator+"log4j.properties");
					prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return "test";
     }
     
     public static void copyfile(File in, File out) 
     throws IOException 
 {
     FileChannel inChannel = new
         FileInputStream(in).getChannel();
     FileChannel outChannel = new
         FileOutputStream(out).getChannel();
     try {
         inChannel.transferTo(0, inChannel.size(),
                 outChannel);
     } 
     catch (IOException e) {
         throw e;
     }
     finally {
         if (inChannel != null) inChannel.close();
         if (outChannel != null) outChannel.close();
     }
 }
 public static void createFolderFroDocument(String folderName , String pathName)
 {
	 File folder = new File(pathName+folderName);
	 if(!folder.exists())
	 {
		 folder.mkdir();
	 }
 }
private static void copyFolder(File src, File dest)
	throws IOException{

	if(src.isDirectory()){

		//if directory not exists, create it
		if(!dest.exists()){
		   dest.mkdir();
		   //System.out.println("Directory copied from " + src + "  to " + dest);
		}

		//list all the directory contents
		String files[] = src.list();

		for (String file : files) {
		   //construct the src and dest file structure
		   File srcFile = new File(src, file);
		   File destFile = new File(dest, file);
		   //recursive copy
		   copyFolder(srcFile,destFile);
		}

	}else{
		//if file, then copy it
		//Use bytes stream to support all file types
		InputStream in = new FileInputStream(src);
	        OutputStream out = new FileOutputStream(dest); 

	        byte[] buffer = new byte[1024];

	        int length;
	        //copy the file content in bytes 
	        while ((length = in.read(buffer)) > 0){
	    	   out.write(buffer, 0, length);
	        }

	        in.close();
	        out.close();
	        //System.out.println("File copied from " + src + " to " + dest);
	}
 }
 public static void copyCompletlyFolder(File srcFolder , File destFolder)
 {
	 try{
 	//make sure source exists
 	if(!srcFolder.exists()){

        //System.out.println("Directory does not exist.");
        return ;

     }else{

       
     	copyFolder(srcFolder,destFolder);
        }}catch(IOException e){
     	e.printStackTrace();
     	//error, just exit
         return ;
        }
     

 	//System.out.println("Done");
 	return ;

 }
 public static String calculateTotalYearsForADT(Float serviceYears,String serviceUnit,
			Date dateForCalculation) {
		Calendar now = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateForCalculation);

		int calculatedDays, calculatedMonth, calculatedYear;

		int currentDays = now.get(Calendar.DATE);
		int regDays = cal.get(Calendar.DATE);
		int currentMonth = now.get(Calendar.MONTH) + 1;
		int regMonth = cal.get(Calendar.MONTH) + 1;
		int currentYear = now.get(Calendar.YEAR);
		int regYear = cal.get(Calendar.YEAR);

		String totalServiceYear = "0";

		if (currentDays < regDays) {
			currentDays = currentDays + 30;
			calculatedDays = currentDays - regDays;
			currentMonth = currentMonth - 1;
		} else {
			calculatedDays = currentDays - regDays;
		}

		if (currentMonth < regMonth) {
			currentMonth = currentMonth + 12;
			calculatedMonth = currentMonth - regMonth;
			currentYear = currentYear - 1;
		} else {
			calculatedMonth = currentMonth - regMonth;
		}

		calculatedYear = currentYear - regYear;

		
		int currentServYr = serviceYears.intValue();
		
		int newServiceYear = 0;
		if ((serviceUnit.trim()).equals("Years")) {
			newServiceYear = currentServYr + calculatedYear;
			
			totalServiceYear = newServiceYear + "";
			
		} else if ((serviceUnit.trim()).equals("Months")) {
			if (calculatedYear > 0) {
				newServiceYear = calculatedYear;
				totalServiceYear = newServiceYear + "";
			}

		} else if ((serviceUnit.trim()).equals("Days")) {
			if (calculatedYear > 0) {
				newServiceYear = calculatedYear;
				totalServiceYear = newServiceYear + "";
			}
		}
		return totalServiceYear;
	}
 public static String getConvertDateYYYYMMDD(String currentDate) {
	 String date="";
	 try{
		 String[] str = currentDate.split("/");
		 /*int month=Integer.parseInt(str[1]);
		 int temp=0;
		 int temp1=0;
		 if(month<=3){
			 temp1=Integer.parseInt(str[2].substring(1));
			 temp=Integer.parseInt(str[2])-1;
			 financialYear=temp+"-"+temp1;
		 }else{
			 temp1=Integer.parseInt(str[2].substring(1));
			 temp=Integer.parseInt(str[2].substring(1))+1;
			 financialYear=temp1+"-"+temp;
		 }*/
		 date=str[2]+"-"+str[1]+"-"+str[0];
	 }catch (Exception e) {
		 e.printStackTrace();
	 }

	 return date;
 }
 public static String getPrevDate(int diffDays) {
		String nextDate="";
		try{
			Map<String, Object> mapDate = new HashMap<String, Object>();
			mapDate=getCurrentDateAndTime();
			String currentDate="";
			if(mapDate.get("currentDate")!=null){
				currentDate=(String)mapDate.get("currentDate");
			}

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(convertStringTypeDateToDateType(currentDate));
			int dateValue = calendar.get(Calendar.DATE);
			calendar.set(Calendar.DATE, dateValue - diffDays);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			date=calendar.getTime();
			String datetime = dateFormat.format(date);
			StringTokenizer s = new StringTokenizer(datetime," ");
			while(s.hasMoreTokens())
			{
				nextDate  = s.nextToken();
				s.nextToken();
			}


		}catch (Exception e) {
			e.printStackTrace();
		}
		return nextDate;
	}
 public static String convertDateToStringTypeDateOnly(Date date) {
		int dateOfMonth, month, year;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		StringBuffer dateOnly = new StringBuffer();
		dateOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		if (dateOfMonth < 10) {
			dateOnly.append("0");
		}
		dateOnly.append(dateOfMonth);
		dateOnly.append("/");
		month = calendar.get(Calendar.MONTH) + 1;
		if (month < 10) {
			dateOnly.append("0");
		}
		dateOnly.append(month);
		dateOnly.append("/");
		year = calendar.get(Calendar.YEAR);

		dateOnly.append(year).append(" ");
		/*.append(calendar.get(Calendar.HOUR_OF_DAY)).append(":")
		  .append(calendar.get(Calendar.MINUTE)).append(":")
	   	  .append(calendar.get(Calendar.SECOND));*/
		return dateOnly.toString();
	}
 public static String getFinancialYearYY_YY(String currentDate) {
	 String financialYear="";
	 try{
		 String[] str = currentDate.split("/");
		 int month=Integer.parseInt(str[1]);
		 int temp=0;
		 int temp1=0;
		 if(month<=3){
			 temp1=Integer.parseInt(str[2].substring(1));
			 temp=Integer.parseInt(str[2])-1;
			 financialYear=temp+"-"+temp1;
		 }else{
			 temp1=Integer.parseInt(str[2].substring(1));
			 temp=Integer.parseInt(str[2].substring(1))+1;
			 financialYear=temp1+"-"+temp;
		 }
	 }catch (Exception e) {
		 e.printStackTrace();
	 }

	 return financialYear;
 }
//Code By Mukesh 27-06-08
 	/**
	 * Get Leap Year
	 * @author Mukesh Narayan Singh 
	 * @param request stringDate
	 * @param boolean
	 * @throws IOException
	 */
	public static boolean getLeapYearOfDate(String stringDate)
	{
		boolean flag=false;
		String date="";
		String splitDate[]=stringDate.split("/");
		date=splitDate[2]+"-"+splitDate[1]+"-"+splitDate[0];
		int year=Integer.parseInt(splitDate[2]);
		if(year%4 == 0)
		{
			if(year%100 != 0)
			{
				flag=true;
			}
			else
			{
				if(year%400 == 0)
					flag=true;
				else
					flag=false;
			}
		}
		return flag;
	}
	/**
	 * Get Leap Year
	 * @author Mukesh Narayan Singh 
	 * @param request year
	 * @param boolean
	 * @throws IOException
	 */
	public static boolean getLeapYear(int year)
	{
		boolean flag=false;
		if(year%4 == 0)
		{
			if(year%100 != 0)
			{
				flag=true;
			}
			else
			{
				if(year%400 == 0)
					flag=true;
				else
					flag=false;
			}
		}
		return flag;
	}
	/**
	 * Get Start And EndDate Of Month
	 * @author Mukesh Narayan Singh 
	 * @param month
	 * @param year
	 * @throws IOException
	 */
	public static Map<String,Object> getStartAndEndDateOfMonth(int month,int year) {
		Map<String, Object> map = new HashMap<String, Object>();
		/*Map<String, Object> mapDate = new HashMap<String, Object>();
		mapDate=getCurrentDateAndTime();
		String currentDate="";
		if(mapDate.get("currentDate")!=null){
			currentDate=(String)mapDate.get("currentDate");
		}*/
		//27/06/2008
		boolean flag=false; 
		
		flag=getLeapYear(year);
		String fristDate="";
		String lastDate="";
		String startDate1="01";
		String endDate28="28";
		String endDate29="29";
		String endDate30="30";
		String endDate31="31";
		if(flag){
				fristDate=year+"-0"+month+"-"+startDate1;
			if(month==1){
				lastDate=year+"-0"+month+"-"+endDate31;	
			}else if (month==2) {
				lastDate=year+"-0"+month+"-"+endDate29;	
			}else if (month==3) {
				lastDate=year+"-0"+month+"-"+endDate31;
			}else if (month==4) {
				lastDate=year+"-0"+month+"-"+endDate30;
			}else if (month==5) {
				lastDate=year+"-0"+month+"-"+endDate31;
			}else if (month==6) {
				lastDate=year+"-0"+month+"-"+endDate30;
			}else if (month==7) {
				lastDate=year+"-0"+month+"-"+endDate31;
			}else if (month==8) {
				lastDate=year+"-0"+month+"-"+endDate31;
			}else if (month==9) {
				lastDate=year+"-0"+month+"-"+endDate30;
			}else if (month==10) {
				lastDate=year+"-"+month+"-"+endDate31;
			}else if (month==11) {
				lastDate=year+"-"+month+"-"+endDate30;
			}else if (month==12) {
				lastDate=year+"-"+month+"-"+endDate31;
			}  
			map.put("fristDate", fristDate);
			map.put("lastDate", lastDate);
		}else {
			fristDate=year+"-0"+month+"-"+startDate1;
			if(month==1){
				lastDate=year+"-0"+month+"-"+endDate31;	
			}else if (month==2) {
				lastDate=year+"-0"+month+"-"+endDate28;	
			}else if (month==3) {
				lastDate=year+"-0"+month+"-"+endDate31;
			}else if (month==4) {
				lastDate=year+"-0"+month+"-"+endDate30;
			}else if (month==5) {
				lastDate=year+"-0"+month+"-"+endDate31;
			}else if (month==6) {
				lastDate=year+"-0"+month+"-"+endDate30;
			}else if (month==7) {
				lastDate=year+"-0"+month+"-"+endDate31;
			}else if (month==8) {
				lastDate=year+"-0"+month+"-"+endDate31;
			}else if (month==9) {
				lastDate=year+"-0"+month+"-"+endDate30;
			}else if (month==10) {
				lastDate=year+"-"+month+"-"+endDate31;
			}else if (month==11) {
				lastDate=year+"-"+month+"-"+endDate30;
			}else if (month==12) {
				lastDate=year+"-"+month+"-"+endDate31;
			}  
			map.put("fristDate", fristDate);
			map.put("lastDate", lastDate);
		}
		return map;
	}
	
	  public String convert(int number) {
          int n = 1;
          int word;
          string = "";
          while (number != 0) {
                  switch (n) {
                  case 1:
                          word = number % 100;
                          pass(word);
                          if (number > 100 && number % 100 != 0) {
                                  show("and ");
                          }
                          number /= 100;
                          break;

                  case 2:
                          word = number % 10;
                          if (word != 0) {
                                  show(" ");
                                  show(st2[0]);
                                  show(" ");
                                  pass(word);
                          }
                          number /= 10;
                          break;

                  case 3:
                          word = number % 100;
                          if (word != 0) {
                                  show(" ");
                                  show(st2[1]);
                                  show(" ");
                                  pass(word);
                          }
                          number /= 100;
                          break;

                  case 4:
                          word = number % 100;
                          if (word != 0) {
                                  show(" ");
                                  show(st2[2]);
                                  show(" ");
                                  pass(word);
                          }
                          number /= 100;
                          break;

                  case 5:
                          word = number % 100;
                          if (word != 0) {
                                  show(" ");
                                  show(st2[3]);
                                  show(" ");
                                  pass(word);
                          }
                          number /= 100;
                          break;

                  }
                  n++;
          }
          return string;
  }

  public void pass(int number) {
          int word, q;
          if (number < 10) {
                  show(st1[number]);
          }
          if (number > 9 && number < 20) {
                  show(st3[number - 10]);
          }
          if (number > 19) {
                  word = number % 10;
                  if (word == 0) {
                          q = number / 10;
                          show(st4[q - 2]);
                  } else {
                          q = number / 10;
                          show(st1[word]);
                          show(" ");
                          show(st4[q - 2]);
                  }
          }
  }

  public void show(String s) {
          String st;
          st = string;
          string = s;
          string += st;
  }

  public static void generateReportInWordForWard(String FileName,String jasper_filename, Map parameters,
			Connection conn, HttpServletResponse response, ServletContext context){
			
			
			try{
				 ServletOutputStream ouputStream;
					
					ouputStream = response.getOutputStream();
					response.setContentType("application/x-download");
		            response.setHeader("Content-Disposition", "attachment; filename="+FileName+".rtf");
		            
		            
				//String jasper_filename1 = context.getRealPath("/reports/" + jasper_filename + ".jrxml");
				//JasperCompileManager.compileReportToFile(jasper_filename1);
				
				String jasper_filename2 = context.getRealPath("/reports/" + jasper_filename + ".jasper");
				JasperFillManager.fillReportToFile(jasper_filename2, parameters, conn);
				
				String jasper_filename3 = context.getRealPath("/reports/" + jasper_filename + ".jrprint");
				File sourceFile = new File(jasper_filename3);
	            JasperPrint jasperPrint = (JasperPrint)JRLoader.loadObject(sourceFile);
	            JRRtfExporter exporter = new JRRtfExporter();
	            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
	            exporter.exportReport();
	           
				ouputStream.flush();
				ouputStream.close();
				if(!conn.isClosed())
				conn.close();
				} catch (Exception e) 
				{
					e.printStackTrace();
				}

		}
  /**
	 * Validate meta characters in request string
	 * @author Mukesh Narayan Singh 
	 * @param String value
	 * @return validated string value
	 */
	public static String restrictMetaChar(String values) 
	{

	String values1 = values; 
	values1 = values1.replace(

	"--", " "); 
	values1 = values1.replace(

	"'", " "); 
	values1 = values1.replace(

	",", " "); 
	values1 = values1.replace(

	";", " "); 
	values1 = values1.replace(

	"<", " "); 
	values1 = values1.replace(

	">", " "); 
	values1 = values1.replace(

	")", " "); 
	values1 = values1.replace(

	"(", " "); 
	values1 = values1.replace(

	"=", " "); 
	values1 = values1.replace(

	"script", " "); 
	values1 = values1.replace(

	"delete", " "); 
	values1 = values1.replace(

	"drop", " "); 
	values1 = values1.replace(

	"update", " "); 
	values1 = values1.replace(

	"truncate", " "); 
	values1 = values1.replace(

	"insert", " "); 
	values1 = values1.replace(

	"java", " "); 
	values1 = values1.replace(

	"alert", " "); 

	values1 = values1.replace(

	"java alert", " "); 
	values1 = values1.replace(

	"style", " "); 
	values1 = values1.replace(

	"onMouseOver", " "); 
	values1 = values1.replace(

	"expression", " "); return values1; 
	}
	
	public static List<Map<String, Object>> listLDAPData = new ArrayList<Map<String, Object>>();
	public static String INITCTX = "com.sun.jndi.ldap.LdapCtxFactory"; // driver
	public static String MY_HOST = "ldap://192.168.10.11:389"; // server and port
	public static String MY_FILTER = "(&(sAMAccountName=ritu.sahu)(!(objectclass=computer)))"; //filter
	public static String MY_ATTRS[] = { "cn","sn","givenName","distinguishedName","instanceType","whenCreated","displayName","uSNCreated","uSNChanged","name","userAccountControl","badPwdCount","codePage","countryCode","badPasswordTime","lastLogoff","lastLogon","pwdLastSet","primaryGroupID","accountExpires","logonCount","sAMAccountName","sAMAccountType","objectCategory","dSCorePropagationData","objectGUID","objectSid","apptMain","bloodgroup","branch","department","dob","initials","mail","objectClass","rank"};
	//public static String MY_SEARCHBASE = "dc=iaf,dc=in"; // base DC
	public static String MY_SEARCHBASE = "dc=noida,dc=jkt,dc=in"; // base DC
	
	public static void main(String[] args) {
		
		System.out.println("validate-->"+LDAPAuthAndSearch.getAuthentcateUserAndPwd("ritu.sahu","hms@2012"));	
		List<Map<String, Object>> listLDAPDataTemp = new ArrayList<Map<String, Object>>();
		try {
			listLDAPDataTemp=LDAPAuthAndSearch.searchFromLdap("ritu.sahu","noida\\ritu.sahu","hms@2012",MY_FILTER,MY_ATTRS,MY_SEARCHBASE,INITCTX,MY_HOST);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(listLDAPDataTemp.size()>0){
			for (int i = 0; i < listLDAPDataTemp.size(); i++) {
				Map<String, Object> mapLDAPDataTemp = new HashMap<String, Object>();

				mapLDAPDataTemp=(HashMap<String, Object>)listLDAPDataTemp.get(i);
				/*
				 * Key Nme for respective value
				 * Service No   =cn,sAMAccountName,name
				 * Rank         =rank
				 * F Name       =givenName
				 * L Name       =sn
				 * Trade/Branch =branch
				 * DOB			=dob
				 * E-mail       =mail
				 * 
				 */
				for (Map.Entry<String, Object> entry : mapLDAPDataTemp.entrySet()) {
					if(entry.getKey().equalsIgnoreCase("cn")){
						System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
					}else if(entry.getKey().equalsIgnoreCase("rank")){
						System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
					}else if(entry.getKey().equalsIgnoreCase("givenName")){
						System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
					}else if(entry.getKey().equalsIgnoreCase("sn")){
						System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
					}else if(entry.getKey().equalsIgnoreCase("branch")){
						System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
					}else if(entry.getKey().equalsIgnoreCase("dob")){
						System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
					}else if(entry.getKey().equalsIgnoreCase("mail")){
						System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
					}
					
					
				}
			}
		}
	}
	

	
	
	@SuppressWarnings("deprecation")
	public static Map<String, Object> getConnectionForReportForHIS() {
		Map<String, Object> map = new HashMap<String, Object>();
   	    Connection conn=null;
		try {
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "his", "his");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@mcc-25-smc-db1:1521:mednetdb1", "his", "his");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in connecting="+e);
		}

		
		
		map.put("conn", conn);
		return map;
	}
	public static String convertDateToStringFormat(Date date, String format){
            String dateFormat="";
	        SimpleDateFormat format1 = new SimpleDateFormat(format);
	        dateFormat=format1.format(date);    
	        return dateFormat;	
	
    }
	
	
	public static String convertFromDateStringToDateString(String from, String to, String date) throws ParseException{
		if(date!=null && !date.trim().equals("")){
			Date temp_date=new SimpleDateFormat(from).parse(date);          
	        SimpleDateFormat toFormat = new SimpleDateFormat(to);      
	        return toFormat.format(temp_date);	
		}
		else
		{
			return date;
		}
	
    }
	
	public static List<Object> uploadFileMaintenance(MultipartFormDataRequest mrequest, String uploadURL,String whiteList,Long fileSizeLimit,String fileNameToBeAssigned)
    {
        
            List fileUploadedList = new ArrayList();
            boolean fileUploaded = false;
            try {
          
            UploadBean upBean = new UploadBean();
          
            upBean.setFolderstore(uploadURL);
            
            upBean.setOverwrite(true);
            upBean.setWhitelist(whiteList);
            upBean.setFilesizelimit(fileSizeLimit);
           
            Hashtable files = mrequest.getFiles();
            
           // UploadFile file = (UploadFile) files.get(RequestConstants.UPLOAD);
             UploadFile file = (UploadFile) files.get("upload_filename");
        
            String fileName = file.getFileName();

             Long fileSize = file.getFileSize();
             //System.out.println(file+"file11>>"+fileName+"   "+fileSize);
            if (fileName != null && fileSize > 0 && fileSize <= RequestConstants.MAX_FILE_SIZE )
            {//System.out.println(file+"file222>>"+fileName+"   "+fileSize);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
                String date = sdf.format(new Date());
                int length = fileName.length();
                int index = fileName.indexOf(".");
                String ext = fileName.substring(index, length);
               // file.setFileName(fileNameToBeAssigned+"_"+date+ext);
               // file.setFileName(fileNameToBeAssigned+"_"+date);
                System.out.println(upBean.SQLUPLOADID);
                upBean.store(mrequest, "upload_filename");
                fileUploaded = true;
                fileUploadedList.add(fileUploaded);
                if(fileUploaded)
                {
                    fileUploadedList.add(fileName);
                    fileUploadedList.add(file.getFileName());
                }
            
            }
          } catch (UploadException e)
          {
              e.printStackTrace();
          }catch(IOException e)
          {
              e.printStackTrace();
          }
          return fileUploadedList;
    }
	public static Date convertStringToTime (String time)
	{
	    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

	    Date date = null;
	    try {
	        date = sdf.parse(time);
	        
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    return date;
	}
	
	public static Date getExpiryDateYYYYMMDD()
	{
		Calendar cal = Calendar.getInstance();
		//cal.add(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		/*cal.add(Calendar.DATE, 30);*/ 
	    Date expiryDate = cal.getTime();
	    return expiryDate;
	}
	
	public static String getProperties(String fileName, String propName){
		String propertyValue = null;
		try{
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource(fileName);
			Properties properties= new Properties();
			properties.load(resourcePath.openStream());
			propertyValue = properties.getProperty(propName);
		}catch(Exception e){e.printStackTrace();}
		return propertyValue;
	}
	
    public static int getNoOfDays(Date date1,Date date2){
    	int days=0;
		int year = date1.getYear()+1900;
		int month = date1.getMonth();
		int date = date1.getDate();
		Date d1 = new GregorianCalendar(year, month, date).getTime();
		long diff = date2.getTime() - d1.getTime();
		days=Integer.parseInt(""+diff / (1000 * 60 * 60 * 24));
	
    	return days;
    } 
	
	public static String getDICOM(String studuID){
		String dicom = "<a href='"+getProperties("jdbc.properties", "pacs.application.connection")+"/weasis-pacs-connector/viewer?patientID="+studuID+"' ><img title='Open Web Viewer' src='../jsp/pacs/images/viewer.png'></a>";
		return dicom;
	}
	
	public static void excelWriter(List<List<Object[]>> sheetList, Map<String, Object> map, HttpServletResponse response, List<String> sheetNames) throws Exception { 

		
		try{
			HSSFWorkbook workbook = new HSSFWorkbook();
			
			String fileName = map.get("fileName").toString();
	       /* Object[][] bookData = {
	                {"Head First Java", "Kathy Serria", 79},
	                {"Effective Java", "Joshua Bloch", 36},
	                {"Clean Code", "Robert martin", 42},
	                {"Thinking in Java", "Bruce Eckel", 35},
	        };*/
	 
	        int rowCount = 0;
	        int sheetCount = 0;
	        for (List<Object[]> objectList : sheetList) {
	        	rowCount = 0;
	        HSSFSheet sheet = workbook.createSheet(sheetNames.get(sheetCount++));
	        
	        for (Object[] aBook : objectList) {
	        	
	        	HSSFRow row = sheet.createRow(rowCount++);
	             
	            int columnCount = 0;
	             
	            for (Object field : aBook) {
	            	HSSFCell cell = row.createCell((short)columnCount++);
	            	 if (field == null) {
		                    cell.setCellValue(" ");	            		
		                }
	            	 else if (field instanceof Integer) {
	                    cell.setCellValue((Integer) field);
	                }
	                else if (field instanceof Long) {
	                    cell.setCellValue((Long) field);
	                } else if (field instanceof Float) {
	                    cell.setCellValue((Float) field);
	                }
	                else if (field instanceof Double) {
	                    cell.setCellValue((Double) field);
	                } else if (field.toString().trim().equals("")) {
	                	 cell.setCellValue((String) field.toString()+" ");
	                }
	               
	                else {
	                    cell.setCellValue((String) field.toString());
	                }
	              
	            }
	             
	        }}
	          
	         
	         FileOutputStream outputStream = new FileOutputStream(fileName+".xls");
	            workbook.write(outputStream);
	       System.out.println("fileName"+fileName);
	         
	      
			response.setContentType("application/vnd.ms-excel");
			/*response.setHeader("Content-Disposition",
					"attachment; filename="
							+ map.get("download_path").toString());
			File f = new File(map.get("download_path").toString());*/
			response.setHeader("Content-Disposition",
					"attachment; filename="+fileName+".xls");
			File f = new File(fileName+".xls");
			System.out.println("fileName"+fileName);
			InputStream in = new FileInputStream(f);
			ServletOutputStream outs = response.getOutputStream();
			int bit = 256;
			int i = 0;
			while ((bit) >= 0) {
				bit = in.read();
				outs.write(bit);
			}
			outs.flush();
			outs.close();
			in.close();
			if (f.exists())
				f.delete();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}
	    
	 
	}
	
	public static List<Object[][]> excelReader(HttpServletRequest request) {
		Box box = HMSUtil.getBox(request);
		
		MultipartFormDataRequest mrequest = null;
		List<Object[][]> sheetList = new ArrayList<Object[][]>();
	
			
			
			Vector sheetVector = new Vector();
			
			if (MultipartFormDataRequest.isMultipartFormData(request)) {
					try {
						mrequest = new MultipartFormDataRequest(request);
					} catch (UploadException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
					
					java.util.Hashtable files = mrequest.getFiles();	
					
					UploadFile file = (UploadFile) files.get("uploadFilename");
					/*System.out.println("flename"+file.getFileName());*/
					/*System.out.println("RequestConstants.UPLOAD_FILENAME"+RequestConstants.UPLOAD_FILENAME);*/
					/*String filePath=mrequest.getParameter(RequestConstants.UPLOAD_FILENAME);*/
					
					InputStream is=file.getInpuStream();
					/*FileInputStream inputStream = new FileInputStream(new File(file.getFileName()));*/
					//System.out.println("file=="+file);
					

					
						POIFSFileSystem myFileSystem = new POIFSFileSystem(is);
						HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);	
						FormulaEvaluator evaluator = myWorkBook.getCreationHelper().createFormulaEvaluator();
						
						
						int sheetCount = myWorkBook.getNumberOfSheets();
						
						for(int s = 0; s<sheetCount; s++)
						{
							
	                    HSSFSheet mySheet = myWorkBook.getSheetAt(s);
	                    Iterator rowIter = mySheet.rowIterator();
	                    Vector rowVector = new Vector();
	                    
	                    while (rowIter.hasNext()) {
	                            HSSFRow myRow = (HSSFRow) rowIter.next();
	                            Iterator cellIter = myRow.cellIterator();
	                            Vector cellVector = new Vector();
	                            while (cellIter.hasNext()) {
	                            	    HSSFCell myCell = (HSSFCell) cellIter.next();
	                            	   /* if(myCell.getCellType() == HSSFCell.class)
	                            	    {
	                            	    	cellVector.addElement(myCell.getDateCellValue());
	                            	    }
	                            	    else
	                            	    {
	                            	    	cellVector.addElement(myCell);
	                            	    }*/
	                                    
	                            	    cellVector.addElement(myCell);
	                                   /* System.out.println("myCell"+myCell.toString());*/
	                                    
	                            }
	                            rowVector.addElement(cellVector);
	                    }
					
					if(rowVector.size()>0)
					{						
					
					Object[][] obj=new Object[rowVector.size()][(((Vector)(rowVector.elementAt(0))).size()+1)];
					/*System.out.println("((Vector)(rowVector.elementAt(0))).size()"+((Vector)(rowVector.elementAt(0))).size());
					System.out.println("rowVector"+rowVector.size());*/
	                for (int i = 0; i < rowVector.size(); i++) {
	                        Vector cellVector = (Vector) rowVector.elementAt(i);
	                        for (int j = 0; j < cellVector.size(); j++) {
	                                HSSFCell myCell = (HSSFCell) cellVector.elementAt(j);
	                                
	                                String stringCellValue = myCell.toString();
	                          	    CellValue cellValue = evaluator.evaluate(myCell);
	                          	  if (myCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
	                          	  {
	                          		if (HSSFDateUtil.isCellDateFormatted(myCell)) {
		                          		 DataFormatter df = new DataFormatter();
		 	                          	stringCellValue = df.formatCellValue(myCell);
		 	                          	System.out.println("datestringCellValue"+i+","+j+"="+stringCellValue);
		                              }
	                          	  else
	                          	  {
	                          		stringCellValue = cellValue.formatAsString();
	                          	  }
	                          	  }
	                          	  
	                          	  else
	                          	  {
	                          		stringCellValue = cellValue.formatAsString();
	                          	  }
	                          	   
	                          	 
	                          	    
	                          	   /* System.out.println("stringCellValue"+stringCellValue);*/
	                          	    if(stringCellValue.contains("\"") && !stringCellValue.trim().equals(""))
	                          	    {
	                          	    	 stringCellValue = stringCellValue.substring(1,(stringCellValue.length()-1));
	                          	    }
	                          	   
	                          	  
                            	/*    switch (cellValue.getCellType()) {
                            	        case HSSFCell.CELL_TYPE_BOOLEAN:
                            	            System.out.println(cellValue.getBooleanValue());
                            	            break;
                            	        case HSSFCell.CELL_TYPE_NUMERIC:
                            	            System.out.println(cellValue.getNumberValue());
                            	            break;
                            	        case HSSFCell.CELL_TYPE_STRING:
                            	            System.out.println(cellValue.getStringValue());
                            	            break;
                            	        case HSSFCell.CELL_TYPE_BLANK:
                            	            break;
                            	        case HSSFCell.CELL_TYPE_ERROR:
                            	            break;

                            	        // CELL_TYPE_FORMULA will never happen
                            	        case HSSFCell.CELL_TYPE_FORMULA: 
                            	            break;
                            	        default:stringCellValue = cellValue.toString();  
                            	    }		
	                                */
	                          	    /*System.out.println("cellValue"+cellValue);*/
	                                System.out.println("stringCellValue"+i+","+j+"="+stringCellValue);
	                                
	                               
	                             /*   if(myCell.toString().contains("."))
                                    {
	                                	stringCellValue = myCell.toString().substring(0, stringCellValue.indexOf("."));
	                                	stringCellValue = myCell.toString();
                                    }else if(myCell.toString().trim().equals("")){
                                    	 stringCellValue = null;
                                    }else{
                                   	 stringCellValue = myCell.toString();
                                   }*/
	                             
	                             
	                                obj[i][j]=stringCellValue;
	                                
	                        }
	                }
	                sheetList.add(obj);
						}
					}
	                } catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}	
	
		return sheetList;
	}
	
	@SuppressWarnings("unchecked")
	public synchronized static void generateReportForDirectPrintPatient(String jasper_filename, Map parameters,
			Connection conn, HttpServletResponse response,
			ServletContext context, String path,String hinNo) {
		byte bytes[] = null;
		try {
			
		/*	System.out.println("compiler path is == "+getCompiledReport(context, jasper_filename));
			Set<String> keySet=parameters.keySet();
			for (String key : keySet) {
				System.out.println(key + "/" + parameters.get(key));
			}
			
			System.out.println("connection is == "+conn.toString());
			
			*/
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(context, jasper_filename), parameters,
					conn);
			
	
			System.out.println("path"+path);
			System.out.println("visit_id"+hinNo);
			FileUtils.writeByteArrayToFile(new File(path+"/"+jasper_filename+hinNo+""+".pdf"), bytes);
		      
		} catch (JRException e) {
			e.printStackTrace();
		}catch ( IOException e) {
			e.printStackTrace();
		}
		
		
	}	
	
	
	public static boolean alreadyPrescribedMedicine(PatientPrescriptionDetails pDt ) {
		
		boolean matched =false;
		int totalPrescribedDays = 0;
		Date prescribedDate = null;
		Date curentDate = new Date();
		int subtractDateDays = 0;
		String categoryCode = "";
		//for( PatientPrescriptionDetails pDt:prescriptionDetail)
		//{
			if(pDt.getItem().getItemCategory()!=null)
			categoryCode = pDt.getItem().getItemCategory().getItemCategoryCode();
			totalPrescribedDays = pDt.getNoOfDays();
			prescribedDate = pDt.getPrescription().getPrescriptionDate();
			//break;
			
		//}
		//System.out.println(curentDate.getTime()  +" "+ prescribedDate.getTime());
	//	subtractDateDays = curentDate - prescribedDate; 
		 int diffInDays = (int) ((curentDate.getTime() - prescribedDate.getTime()) / (1000 * 60 * 60 * 24));
		
		 if(diffInDays >= totalPrescribedDays)
		 {
			 matched=false;
		 }
		 else
			 matched=true;
		 
		if(matched){
			String  categoryCodeForDiabetes = "";
			try
			{
				categoryCodeForDiabetes = getValuesFromPropertiesFile("adt.properties", "categoryCodeForDaibetes");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			 if(categoryCode!=null && categoryCodeForDiabetes.equalsIgnoreCase(categoryCode)){
				 String dt = prescribedDate.toString(); 
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				 Calendar c = Calendar.getInstance();
				 try {
					c.setTime(sdf.parse(dt));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				 c.add(Calendar.DATE, totalPrescribedDays-7);  
				
				 dt = sdf.format(c.getTime()); 
				
				 if(curentDate.compareTo(c.getTime()) >0)
					  matched=false;
				 
		
			 }
	  }
		return matched;
	}
	
	
	public static int calculateAgeInYears(Date birthDate) {
		// get todays date
		Calendar now = Calendar.getInstance();
		// get a calendar representing their birth date

		Calendar cal = Calendar.getInstance();
		cal.setTime(birthDate);

		// calculate age as the difference in years.
		@SuppressWarnings("unused")
		int calculatedDays, calculatedMonth, calculatedYear;
		int currentDays = now.get(Calendar.DATE);
		int birthDays = cal.get(Calendar.DATE);
		int currentMonth = now.get(Calendar.MONTH);
		int birthMonth = cal.get(Calendar.MONTH);
		int currentYear = now.get(Calendar.YEAR);
		int birthYear = cal.get(Calendar.YEAR);

		if (currentDays < birthDays) {
		currentDays = currentDays + 30;
		calculatedDays = currentDays - birthDays;
		currentMonth = currentMonth - 1;
		} else {
		calculatedDays = currentDays - birthDays;
		}

		if (currentMonth < birthMonth) {
		currentMonth = currentMonth + 12;
		calculatedMonth = currentMonth - birthMonth;
		currentYear = currentYear - 1;
		} else {
		calculatedMonth = currentMonth - birthMonth;
		}

		int age = currentYear - birthYear;
		return age;
		}
	
	@SuppressWarnings("deprecation")
	public static Map<String, Object> getConnectionForReportForPG() {
		Map<String, Object> map = new HashMap<String, Object>();
   	    Connection conn=null;
		try {
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "his", "his");
			conn = DriverManager.getConnection("jdbc:postgresql://172.129.44.175:5432/E2", "postgres", "postgres");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in connecting="+e);
		}

		
		
		map.put("conn", conn);
		return map;
	}
	public static String  getAgeFromDOB(Date dob) {
		Date currentDate1 = new Date();
		 Calendar dobCal = new GregorianCalendar();
		 dobCal.setTime(dob);
		 Calendar currentDate = new GregorianCalendar();
		 currentDate.setTime(currentDate1);
		 int ageInMonth =0;
		 double monthsBetween =0;
		 String returnAge = null;
	       monthsBetween = (currentDate.get(Calendar.YEAR)-dobCal.get(Calendar.YEAR))*12;
	       monthsBetween += currentDate.get(Calendar.MONTH)-dobCal.get(Calendar.MONTH);
	        if(currentDate.get(Calendar.DAY_OF_MONTH)!=currentDate.getActualMaximum(Calendar.DAY_OF_MONTH)){
	            monthsBetween += ((currentDate.get(Calendar.DAY_OF_MONTH)-dobCal.get(Calendar.DAY_OF_MONTH))/31d);
	        }
		  
	        ageInMonth = (int)monthsBetween;
		  if(ageInMonth>1)
		  {
			  returnAge= ageInMonth +" Months";
		  }
		  else if(ageInMonth==1)
		  {
			  returnAge= ageInMonth +" Month";
		  }
		  else if(ageInMonth<=0)
		  {
			  int day= (int)((currentDate1.getTime() - dob.getTime())/(1000*60*60*24))+1 ;
			  if(day==1)
				  returnAge = day+" Day";
			  else
				  returnAge = day+" Days";
		  }
		 
		  
		  return returnAge!=null?returnAge:"";
	
	      
	   
	}
	
	public static int ordinalIndexOf(String str, String substr, int n) {
	    int pos = str.indexOf(substr);
	    while (--n > 0 && pos != -1)
	        pos = str.indexOf(substr, pos + 1);
	    return pos;
	}
	
	public static String getPrevDate(String currentDate,int diffDays) {
		String nextDate="";
		try{
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(convertStringTypeDateToDateType(currentDate));
			int dateValue = calendar.get(Calendar.DATE);
			calendar.set(Calendar.DATE, dateValue - diffDays);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			date=calendar.getTime();
			String datetime = dateFormat.format(date);
			StringTokenizer s = new StringTokenizer(datetime," ");
			while(s.hasMoreTokens())
			{
				nextDate  = s.nextToken();
				s.nextToken();
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return nextDate;
	}
	
	 public static void generateReportExl(String jasper_filename, Map parameters,
				Connection conn, HttpServletResponse response,
				ServletContext context) {
		
			byte bytes[] = null;
			try {
				
				JasperReport jasperReport=getCompiledReport(context,jasper_filename);
				JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, parameters,conn);
				JRXlsExporter exporterXLS = new JRXlsExporter();
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				exporterXLS.setExporterInput(new SimpleExporterInput(jasperPrint));
				exporterXLS.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));
				
				SimpleXlsReportConfiguration  configuration = new SimpleXlsReportConfiguration ();
				configuration.setCellLocked(true);
				configuration.setPassword("Kssc_erp@2014");
				exporterXLS.setConfiguration(configuration);
			
				
				exporterXLS.exportReport(); 
				bytes = byteArrayOutputStream.toByteArray();
				ServletOutputStream output=response.getOutputStream();	
		        if (response != null) {
		            response.setContentLength(bytes.length);
		            response.setContentType("application/vnd.ms-excel");
		            response.setHeader("Content-Disposition", "attachment; filename="+jasper_filename+".xls");
		            output.write(bytes);
		        }
				if(!conn.isClosed())
				conn.close();
			} catch (JRException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	 
	 public static List<Object> uploadDocProof(MultipartFormDataRequest mrequest, String uploadURL,String whiteList,Long fileSizeLimit,String fileNameToBeAssigned,Connection connection,String inputFieldName)
		{
			List fileUploadedList = new ArrayList();
			boolean fileUploaded = false;
			try {

				UploadBean upBean = new UploadBean();
				try {
					
					upBean.setFolderstore(uploadURL);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				upBean.setOverwrite(true);
				upBean.setWhitelist(whiteList);
				upBean.setFilesizelimit(fileSizeLimit);

				Hashtable files = mrequest.getFiles();

				UploadFile file = (UploadFile) files.get(inputFieldName);
				String fileName = file.getFileName();

				Long fileSize = file.getFileSize();

				if (fileName != null && fileSize > 0 && fileSize <= RequestConstants.MAX_FILE_SIZE )
				{
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
					String date = sdf.format(new Date());
					int length = fileName.length();
					int index = fileName.indexOf(".");
					String ext = fileName.substring(index, length);
					file.setFileName(fileNameToBeAssigned+"_"+date+ext);
					System.out.println(upBean.SQLUPLOADID);
					upBean.store(mrequest, inputFieldName);
					fileUploaded = true;
					fileUploadedList.add(fileUploaded);
					if(fileUploaded)
					{
						fileUploadedList.add(fileName);
						fileUploadedList.add(file.getFileName());
					}

				}
			} catch (UploadException e) 
			{
				e.printStackTrace();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			return fileUploadedList;
		}
		
	 
}
