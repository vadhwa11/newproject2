<%@ page isErrorPage="true"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="org.apache.log4j.Logger"%>
<div class="clear"></div>
<div class="error">
<div class="clear"></div>
<h2>Error Page!</h2>
<div class="clear"></div>
<div class="clear"></div>

<%
String exceptionMsg1="java.lang.NullPointerException";
String exceptionMsg2="java.lang.ClassNotFoundException";
String exceptionMsg3="java.io.IOException";
String exceptionMsg4="java.io.FileNotFoundException";
String exceptionMsg5="java.lang.NumberFormatException";
String exceptionMsg6="java.lang.IllegalArgumentException";
String exceptionOcured=exception.toString();
if(exceptionOcured.equalsIgnoreCase(exceptionMsg1)){
%>
<h4>Mandatory Values are null</h4>
<%	
}else if(exceptionOcured.equalsIgnoreCase(exceptionMsg2)){
	%>
	<h4>Class Not Found</h4>
	<%		
}else if(exceptionOcured.equalsIgnoreCase(exceptionMsg3)){
	%>
	<h4>IO Exception</h4>
	<%		
}else if(exceptionOcured.equalsIgnoreCase(exceptionMsg4)){
	%>
	<h4>File Not Found</h4>
	<%		
}else if(exceptionOcured.equalsIgnoreCase(exceptionMsg5)){
	%>
	<h4>Number Format</h4>
	<%		
}else if(exceptionOcured.equalsIgnoreCase(exceptionMsg6)){
	%>
	<h4>Illegal Argument</h4>
	<%		
}else{
	%>
	<h4>Error Occurred</h4>
	<%		
}
%>
<div class="clear"></div>

<div class="clear"></div>

 <%
		//out.println("<br><br>----------------------------------------<br><br><h1 style=color:red;>Work in progress.<h1>");
		//out.println("<h6>Click here to go <a href=javascript:history.back();>Back</a></h6>");
		
		Map utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		String exceptionText = date+"-"+time+"-"+exception.toString();
		
		StringBuffer sb = new StringBuffer(exception.toString()+"::::::"+exception.getCause()+exception.getClass());
		for(int i = 0 ; i<exception.getStackTrace().length ;i++){
			sb.append("\n");
			sb.append(exception.getStackTrace()[i]);
		}
		System.out.println(":::::::::"+sb.toString());
		Logger logger = Logger.getRootLogger();
		logger.error(sb.toString());
		HMSUtil.writeTextFile(exceptionText,getServletContext());
		//String outputFileName =getServletContext().getRealPath("/WEB-INF/hms_log" + ".txt");
		//HMSUtil.doReadWriteTextFile(outputFileName,getServletContext());
		
	
		%> 
		<div class="clear"></div>
</div>


                                             