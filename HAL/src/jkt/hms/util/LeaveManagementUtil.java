package jkt.hms.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import jkt.hms.masters.business.Holidaycalendar;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class LeaveManagementUtil extends HibernateDaoSupport{
	Session session=null;
	public static int getNumberOfDaysBetweenTwoDates(Date fromDate,Date toDate,List listOfHolidays) {
		boolean flag=true;
		int days=0;
		Date startDate=fromDate;
		Date nextDate=toDate;
		if(startDate.compareTo(nextDate)==0){
		if(isSatOrSun(nextDate)){
				flag=false;
			}
			else{
				if(isHoliday(nextDate,listOfHolidays))
					 flag=false;
			}
			if(flag)
			 days++;
		}
		else{
			while(startDate.compareTo(nextDate)!=1){
				if(isSatOrSun(nextDate)){
					flag=false;
				}
				else
				{
					if(isHoliday(nextDate,listOfHolidays))
					 flag=false;
				
				}
				
				nextDate=getPastDate(nextDate);
				if(flag){
					  days++;
					} 
				else{
					
					flag=true;
				}
					
			}
			
		}
	return days;
	}
	public static int getCountOfDaysBetweenTwoDates(Date fromDate,Date toDate,List listOfHolidays) {
		boolean flag=true;
		int days=0;
		Date startDate=fromDate;
		Date nextDate=toDate;
		int sunOrSatCount = 0;
		if(startDate.compareTo(nextDate)==0){
		if(isSatOrSun(nextDate)){
				flag=false;
				sunOrSatCount =1;
			}else{
				if(isHoliday(nextDate,listOfHolidays)){
					// flag=false;
					// holidayFlag="y";
				}
			}
			
			if(flag)
			 days++;
		}
		else{
			while(startDate.compareTo(nextDate)!=1){
				if(isSatOrSun(nextDate)){
					flag=false;
					sunOrSatCount++;
				}
				else
				{
					
				
				}
				
				nextDate=getPastDate(nextDate);
				if(flag){
					  days++;
					} 
				else{
					
					flag=true;
				}
					
			}
			
		}
	System.out.println("No Of sundays=="+sunOrSatCount);
	return days;
	}
	public static boolean isSatOrSun(Date nextDate){
		Date checkdate=nextDate;
		int isday = checkdate.getDay();
		/* if(isday==0 || isday==6){ // for Saturday and Sunday */
		if(isday==0 || checkSecondSat(checkdate)){ // for only Sunday and second Saturday
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("deprecation")
	private static boolean checkSecondSat(Date checkdate) {
		// TODO Auto-generated method stub
		 Calendar calCheckDate = getCalendarDate(checkdate);
		 if(calCheckDate.get(Calendar.WEEK_OF_MONTH)==2 && checkdate.getDay()==6 )
		{
			return true;
		}
		return false;
	}
	public static boolean isHoliday(Date nextDate,List listOfHolidays ){
	
	for (Iterator iter = listOfHolidays.iterator(); iter.hasNext();){
		Holidaycalendar element = (Holidaycalendar) iter.next();
		String holiday=LeaveManagementUtil.convertDateToStringWithoutTime(element.getHolidayDate());
		String nextDate1=LeaveManagementUtil.convertDateToStringWithoutTime(nextDate);
		if(nextDate1.equals(holiday)){
			return true;
		 }
    }
	return false;
	}
	
	public static Date getPastDate(Date nextDate)
	{
	  //This method returns the previous date than the nextDate	
		int month=0;
		int day=0;
		int year=0;
		Date todayDate=nextDate;
		Date compareDate=new Date();
		day = todayDate.getDate();
		month=todayDate.getMonth();
		year =todayDate.getYear();
		day -=1;
		
		if((month == 3) || (month == 5) || (month == 8) || (month == 10)){
		//	if(day > 0){
		//		day--;
		//	}
			
			if(day==0){
				day=31;
				month--;
			}
		}
		
		if(month == 1){
			
		//	if(day > 0){
		//		day=day--;
		//	}
			
			if(day==0){
				day=31;
				month--;
				
			}
			
					
		}
		
		if(month ==0){
			
		//	if(day>0){
		//		day=day--;
		//	}
			if(day==0)
			{
				day=31;
				year--;
				month=11;
			}
			
		}
		
		 if(month==2){
		//	 if(day>0)
		//	 { 
		//		day--;
		//	 }
			   if(day==0)
			 {
				   if(year %4 == 0) {
						day = 29+day;
					}
					else if((year %4 != 0)){
						day =28+day;
					}
					 month--;
			 }
			   	 
			 
		 }
		
		
		if( (month == 4) ||  (month == 9) ||  (month == 11)||(month==6)){
		//	if(day >0)
		//	{
		//		day =day--;
		//	}
				if(day==0)
				{
					day=30;
					month--;
				}
		}
		
		if(month == 7)
		{
		//	if(day>0)
		//	{
		//	   day=day-1;
		//	}
			
			if(day==0)
			{
				day=31;
				month--;
			}
			
		}   	
			
		
		compareDate.setDate(day);
		compareDate.setMonth(month);
		compareDate.setYear(year);
		return compareDate;
	}
	

	public static synchronized boolean emailFunctionLeave(String recepientAddress,String senderEmailId, String emailMessage, String subject)
	{
		
		boolean emailSentSuccesfully = false;
		Authenticator a1 = new PopupAuthenticator();
		Properties props=new Properties();
		//props.put("mail.smtp.auth", "false");
	    
		try
		{
			URL resourcePath =  Thread.currentThread().getContextClassLoader().getResource("mail.properties");

			Session sessionForJavaMail = Session.getInstance(props, a1);
			props.load(new FileInputStream(new File(resourcePath.getFile())));
			Message msg = new MimeMessage(sessionForJavaMail);
			InternetAddress[] toAddress = new InternetAddress[2];
			
			toAddress= InternetAddress.parse(recepientAddress);
			msg.addRecipients(Message.RecipientType.TO, toAddress);

			Address ccAddress = new InternetAddress(senderEmailId);
			msg.setRecipient(Message.RecipientType.CC, ccAddress);

			Address fromAddress = new InternetAddress(senderEmailId);
			msg.setFrom(fromAddress);
			
//			Address bcc = new InternetAddress(recepientAddress);
//			msg.setRecipient(Message.RecipientType.BCC, bcc);
		
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText( emailMessage );
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart( messageBodyPart );
			msg.setContent(multipart);
			msg.setSubject(subject);
			Transport.send(msg);
			emailSentSuccesfully = true;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return emailSentSuccesfully; 
	}
	public static synchronized boolean sendMailUsingAuthenticator(List<String> addressTo,String senderEmailId,
			List<String> ccTo,List<String> bccTo,
			String emailMessage, String subject) {
		
		boolean emailSentSuccesfully = false;
		//Authenticator authenticator = new SMTPAuthenticator();
		Properties props=new Properties();
	    
		try
		{
			URL resourcePath =  Thread.currentThread().getContextClassLoader().getResource("mail.properties");
			props.load(new FileInputStream(new File(resourcePath.getFile())));
			//TestAuthenticator  authenticator= new TestAuthenticator(props.getProperty("mailUserName"),props.getProperty("mailPassword"));
			TestAuthenticator  authenticator= new TestAuthenticator(props.getProperty("mail.stmp.user"),props.getProperty("mail.smtp.password"));
			Session sessionForJavaMail = Session.getInstance(props,authenticator);
			Message msg = new MimeMessage(sessionForJavaMail);

			InternetAddress[] toAddress = new InternetAddress[addressTo.size()];
			int i = 0;
			for (String to : addressTo) {
				toAddress[i] = new InternetAddress(to);
				i++;
			}
			msg.addRecipients(Message.RecipientType.TO, toAddress);

        	InternetAddress[] ccAddress = new InternetAddress[ccTo.size()];
        	i = 0;
        	for (String cc : ccTo) {
        			ccAddress[i] = new InternetAddress(cc);
        			i++;
        	}
			msg.addRecipients(Message.RecipientType.CC, ccAddress);

        	InternetAddress[] bccAddress = new InternetAddress[bccTo.size()];
        	i = 0;
        	for (String bcc : bccTo) {
    			bccAddress[i] = new InternetAddress(bcc);
    			i++;
        	}
        	msg.addRecipients(Message.RecipientType.BCC, bccAddress);

            Address fromAddress = new InternetAddress(senderEmailId);
			msg.setFrom(fromAddress);
			
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText( emailMessage );
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart( messageBodyPart );
			msg.setContent(multipart);
			msg.setSubject(subject);
			Transport.send(msg);
			emailSentSuccesfully = true;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return emailSentSuccesfully; 
	}
	

	

	public static String getNumberOfDays(Date fromDate, Date toDate) {
		
	      Calendar calStart = getCalendarDate(fromDate);
	      Calendar calFinish = getCalendarDate(toDate);

	      int dayNumberForRequestTime = fromDate.getDay();
	      int dayNumberForRespondedAt = toDate.getDay();
	      int monthNumberForRequestTime = fromDate.getMonth();
	      int monthNumberForRespondedAt = toDate.getMonth();
	      int yearNumberForRequestTime = fromDate.getYear();
	      int yearNumberForRespondedAt = toDate.getYear();
	      
		  long dateDiffInSec = (calFinish.getTimeInMillis()- calStart.getTimeInMillis())/1000;
	      long days,hours, minutes, seconds,actualHours;
	      int actualDays;
		   String timeDifference;
		   
		   days = dateDiffInSec / 86400;
		   actualDays = (int) Math.ceil((double) dateDiffInSec / 86400); 
		   dateDiffInSec = dateDiffInSec - (days * 86400);
		   actualHours = dateDiffInSec / 3600;
		   dateDiffInSec = dateDiffInSec - (actualHours * 3600);
	       minutes = dateDiffInSec / 60;
		   dateDiffInSec = dateDiffInSec - (minutes * 60);
	       seconds = dateDiffInSec;
	       
	       if((dayNumberForRequestTime == dayNumberForRespondedAt) && (monthNumberForRequestTime == monthNumberForRespondedAt) && (yearNumberForRequestTime == yearNumberForRespondedAt)){
			   hours = actualHours;
//			   System.out.println("   in IF    ");
		   }
		   else{
			   if(dayNumberForRequestTime == 5 && dayNumberForRespondedAt == 1){
				   hours = actualHours - 59;
				   //System.out.println("   in ELSE thn IF    ");
			   }
			   else{
				   hours = actualHours - (11 * actualDays);
				   //System.out.println("   in Else thn Else    ");
			   }
		   }
		   //System.out.println("ACtual Hours  :   "+actualHours);
	       
	       
	       
		   if (days <= 0 && hours > 0 && minutes > 0 && seconds > 0)
		   {
			   timeDifference = ( hours + " hr " + minutes + " min " + seconds + " sec");
		   }
		   else if(days <= 0 && hours <= 0 && minutes > 0 && seconds <= 0)
		   {
			   timeDifference = (minutes + " min");
		   }
		   else if(days <= 0 && hours <= 0 && minutes > 0 && seconds > 0)
		   {
			   timeDifference = ( minutes + " min " + seconds + " sec");
		   }
		   else if(days <= 0 && hours > 0 && minutes <= 0 && seconds <= 0)
		   {
			   timeDifference = (hours + " hr");
		   }
		   else if(days <= 0 && hours <= 0 && minutes <= 0 && seconds > 0)
		   {
			   timeDifference = ( seconds + " sec");
		   }
		   else if(days <= 0 && hours > 0 && minutes <= 0 && seconds > 0)
		   {
			   timeDifference = (hours + " hr " + seconds +" sec");
		   }
		   else if(days <= 0 && hours > 0 && minutes > 0 && seconds <= 0)
		   {
			   timeDifference = (hours + " hr " + minutes +" min");
		   }
		   else if(days > 0 && hours <= 0 && minutes <= 0 && seconds <= 0)
		   {
			   timeDifference = (days + " days");
		   }
		   else if(days > 0 && hours <= 0 && minutes <= 0 && seconds > 0)
		   {
			   timeDifference = (days + " days " + seconds + " sec");
		   }
		   else if(days > 0 && hours <= 0 && minutes > 0 && seconds <= 0)
		   {
			   timeDifference = (days + " days " + minutes + " min" );
		   }
		   else if(days > 0 && hours <= 0 && minutes > 0 && seconds > 0)
		   {
			   timeDifference = (days + " days " + minutes + " min " + seconds + " sec");
		   }
		   else if(days > 0 && hours > 0 && minutes <= 0 && seconds <= 0)
		   {
			   timeDifference = (days + " days " + hours + " hr");
		   }
		   else if(days > 0 && hours > 0 && minutes <= 0 && seconds > 0)
		   {
			   timeDifference = (days + " days " + hours + " hr " + seconds + " sec");
		   }
		   else if(days > 0 && hours > 0 && minutes > 0 && seconds <= 0)
		   {
			   timeDifference = (days + " days " + hours + " hr " + minutes + " min");
		   }
		   else
		   {   
			   timeDifference = (days + " days   " + hours + " hr " + minutes + " min " + seconds + " sec");
		   }
		   return timeDifference;
	    }
	private static Calendar getCalendarDate(Date da)
    {
		Calendar cal = Calendar.getInstance();
		cal.setTime(da);
      return cal;
    }

	public static long daysDifferenceBetweenTwoDates(Date appliedDate, Date currentDate) {
		int year = appliedDate.getYear()+1900;
		int month = appliedDate.getMonth();
		int date = appliedDate.getDate();
		//System.out.println("year>>  "+year+"month>>>"+month+"date>>>"+date);
		Date d1 = new GregorianCalendar(year, month, date).getTime();
		long diff = currentDate.getTime() - d1.getTime();
		/*System.out.println("Real difference>>"+diff);
		System.out.println("\nApplied Leave>>"+appliedDate+"   "+new GregorianCalendar(year, month-1, date));
		System.out.println("\ncurrent date>>>"+currentDate);
	    System.out.println("\nThe "+appliedDate+" (up to " + currentDate + ") is "+ (diff / (1000 * 60 * 60 * 24)) + " days old.");
	    */
		return (diff / (1000 * 60 * 60 * 24));
	}
	public static Map<String ,String> getNumberOfDaysWithoutDateOfBirthOrHolidays(Date fromDate,Date toDate,Date dobFromDB,List listOfHolidays,Date anniversary) {
		boolean flag=true;
		Integer days=0;
		Date startDate=fromDate;
		Date nextDate=toDate;
		String holidayFlag ="n";
		String typeFlag = null;
		Map<String,String> calculateDaysMap = new HashMap<String, String>();  
		if(startDate.compareTo(nextDate)==0){
			if(isSatOrSun(nextDate) ){
				//holidayFlag="y";
				flag=false;
			}
			else{
				if(isHoliday(nextDate,listOfHolidays)){
					// flag=false;
					// holidayFlag="y";
				}
			}
			if(flag){
				days++;
				if(dobFromDB!=null) {
					if(isDateOfBirth(nextDate,dobFromDB)){
						//days--;
						//typeFlag="dob";
					}
				}
				if(anniversary!=null) {
					if(isAnniversary(nextDate,anniversary)){
						//days--;
						//typeFlag="anvsy";
					}
				}
			}
		}
		

		else{
			while(startDate.compareTo(nextDate)!= 1){
				if(isSatOrSun(nextDate)){
					flag=false;
					//holidayFlag="y";
				}
				else
				{
					if(isHoliday(nextDate,listOfHolidays)){
					 flag=false;
					 holidayFlag="y";
					}
				}
				
				nextDate=getPastDate(nextDate);
				if(flag){
					days++;
					if(dobFromDB!=null) {
						if(isDateOfBirth(nextDate,dobFromDB)){
							//days--;
							//typeFlag="dob";
						}
					}
					if(anniversary!=null) {
						if(isAnniversary(nextDate,anniversary)){
							//days--;
							//typeFlag="anvsy";
						}
					}
					
				}
				else{
					flag=true;
				}
					
			}
			
		}
		calculateDaysMap.put("days", days.toString());
		calculateDaysMap.put("holidayFlag", holidayFlag);
		calculateDaysMap.put("typeFlag", typeFlag);
	return calculateDaysMap;
	}
	private static boolean isDateOfBirth(Date nextDate,Date dob ){
			boolean flag =false;
			Integer nextDateDayValue=new Integer(nextDate.getDate());
			Integer nextDateMonthValue=new Integer(nextDate.getMonth()+1);
			Integer dobDayValue=new Integer(dob.getDate());
			Integer dobMonthValue=new Integer(dob.getMonth()+1);
			if((nextDateDayValue.compareTo(dobDayValue)== 0)&&((nextDateMonthValue.compareTo(dobMonthValue)== 0))){
				flag = true;
			 }
		return flag;
	}
	private static boolean isAnniversary(Date nextDate,Date anniversary ){
		boolean flag =false;
		if(anniversary != null){
		Integer nextDateDayValue=new Integer(nextDate.getDate());
		Integer nextDateMonthValue=new Integer(nextDate.getMonth()+1);
		Integer anniversaryDayValue=new Integer(anniversary.getDate());
		Integer anniversaryMonthValue=new Integer(anniversary.getMonth()+1);
		if((nextDateDayValue.compareTo(anniversaryDayValue)== 0)&&((nextDateMonthValue.compareTo(anniversaryMonthValue)== 0))){
			flag = true;
		 }
		}
	  return flag;
}
	public static String convertDateToStringWithoutTime(Date date) {
		int dateOfMonth, month, year;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime( date );
		StringBuffer dateOnly = new StringBuffer();
		dateOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		if (dateOfMonth < 10)
			dateOnly.append("0");
		dateOnly.append( dateOfMonth );
		dateOnly.append("/");
		month = calendar.get(Calendar.MONTH) + 1;
		if (month < 10)
			dateOnly.append("0");
		dateOnly.append(month);
		dateOnly.append("/");
		year = calendar.get(Calendar.YEAR);
		dateOnly.append(year);
		return dateOnly.toString();
	}
	public static Properties loadProperyFile(String propertyFile) throws IOException {
		Properties properties = new Properties();
        URL resourcePath = Thread.currentThread().getContextClassLoader().getResource(propertyFile);
        properties.load(resourcePath.openStream());
        return properties;
	}
	public static int compareDates(Date fromDate, Date toDate)
	 {
		 Calendar fDate = getCalendarDate(fromDate);
	    Calendar tDate = getCalendarDate(toDate);
	    return fDate.getTime().compareTo(tDate.getTime());
	 }
	public static String getNumberOfDaysBetweenTwoDates(Date requestTime, Date respondedAt) {
			
		      Calendar calStart = getCalendarDate(requestTime);
		      Calendar calFinish = getCalendarDate(respondedAt);

		      int dayNumberForRequestTime = requestTime.getDay();
		      int dayNumberForRespondedAt = respondedAt.getDay();
		      int monthNumberForRequestTime = requestTime.getDay();
		      int monthNumberForRespondedAt = respondedAt.getDay();
		      int yearNumberForRequestTime = requestTime.getDay();
		      int yearNumberForRespondedAt = respondedAt.getDay();
		      
			  long dateDiffInSec = (calFinish.getTimeInMillis()- calStart.getTimeInMillis())/1000;
		      long days,hours, minutes, seconds,actualHours;
		      int actualDays;
			   String timeDifference;
			   
			   days = dateDiffInSec / 86400;
			   actualDays = (int) Math.ceil((double) dateDiffInSec / 86400); 
			   dateDiffInSec = dateDiffInSec - (days * 86400);
			   actualHours = dateDiffInSec / 3600;
			   dateDiffInSec = dateDiffInSec - (actualHours * 3600);
		       minutes = dateDiffInSec / 60;
			   dateDiffInSec = dateDiffInSec - (minutes * 60);
		       seconds = dateDiffInSec;
		       
		       if((dayNumberForRequestTime == dayNumberForRespondedAt) && (monthNumberForRequestTime == monthNumberForRespondedAt) && (yearNumberForRequestTime == yearNumberForRespondedAt)){
				   hours = actualHours;
//				   System.out.println("   in IF    ");
			   }
			   else{
				   if(dayNumberForRequestTime == 5 && dayNumberForRespondedAt == 1){
					   hours = actualHours - 59;
					   //System.out.println("   in ELSE thn IF    ");
				   }
				   else{
					   hours = actualHours - (11 * actualDays);
					   //System.out.println("   in Else thn Else    ");
				   }
			   }
			   //System.out.println("ACtual Hours  :   "+actualHours);
		       
		       
		       
			   if (days <= 0 && hours > 0 && minutes > 0 && seconds > 0)
			   {
				   timeDifference = ( hours + " hr " + minutes + " min " + seconds + " sec");
			   }
			   else if(days <= 0 && hours <= 0 && minutes > 0 && seconds <= 0)
			   {
				   timeDifference = (minutes + " min");
			   }
			   else if(days <= 0 && hours <= 0 && minutes > 0 && seconds > 0)
			   {
				   timeDifference = ( minutes + " min " + seconds + " sec");
			   }
			   else if(days <= 0 && hours > 0 && minutes <= 0 && seconds <= 0)
			   {
				   timeDifference = (hours + " hr");
			   }
			   else if(days <= 0 && hours <= 0 && minutes <= 0 && seconds > 0)
			   {
				   timeDifference = ( seconds + " sec");
			   }
			   else if(days <= 0 && hours > 0 && minutes <= 0 && seconds > 0)
			   {
				   timeDifference = (hours + " hr " + seconds +" sec");
			   }
			   else if(days <= 0 && hours > 0 && minutes > 0 && seconds <= 0)
			   {
				   timeDifference = (hours + " hr " + minutes +" min");
			   }
			   else if(days > 0 && hours <= 0 && minutes <= 0 && seconds <= 0)
			   {
				   timeDifference = (days + " days");
			   }
			   else if(days > 0 && hours <= 0 && minutes <= 0 && seconds > 0)
			   {
				   timeDifference = (days + " days " + seconds + " sec");
			   }
			   else if(days > 0 && hours <= 0 && minutes > 0 && seconds <= 0)
			   {
				   timeDifference = (days + " days " + minutes + " min" );
			   }
			   else if(days > 0 && hours <= 0 && minutes > 0 && seconds > 0)
			   {
				   timeDifference = (days + " days " + minutes + " min " + seconds + " sec");
			   }
			   else if(days > 0 && hours > 0 && minutes <= 0 && seconds <= 0)
			   {
				   timeDifference = (days + " days " + hours + " hr");
			   }
			   else if(days > 0 && hours > 0 && minutes <= 0 && seconds > 0)
			   {
				   timeDifference = (days + " days " + hours + " hr " + seconds + " sec");
			   }
			   else if(days > 0 && hours > 0 && minutes > 0 && seconds <= 0)
			   {
				   timeDifference = (days + " days " + hours + " hr " + minutes + " min");
			   }
			   else
			   {   
				   timeDifference = (days + " days   " + hours + " hr " + minutes + " min " + seconds + " sec");
			   }
			   return timeDifference;
		    }

	public static int getMinHrsForTimeSheet(int noOfDays,int countOfSatSun, Date fromDate,Date toDate)
	{
		int count= 0;
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(fromDate);
		int endOfFromMonth = cal.getActualMaximum(Calendar.DATE);
		int fromMonth = (cal.get(Calendar.MONTH))+1;
		int fromYear = (cal.get(Calendar.YEAR));
		cal.setTime(toDate);
		
		
		
		int toMonth = (cal.get(Calendar.MONTH))+1;
		int toYear = (cal.get(Calendar.YEAR));
		return count;
	}
}
class TestAuthenticator extends javax.mail.Authenticator {
	private PasswordAuthentication authentication;
	String username="";
	String password ="";

	public TestAuthenticator(String username,String password) {
		 this.username = username;
		 this.password = password;
		authentication = new PasswordAuthentication(username, password);
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return authentication;
	}
}
