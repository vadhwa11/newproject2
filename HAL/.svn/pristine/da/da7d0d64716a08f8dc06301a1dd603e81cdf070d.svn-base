<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * enquiry.jsp  
 * Purpose of the JSP -  This is for Enquiry.
 * @author  Vikas
 * @author  Deepali
 * Create Date: 12th Nov,2007 
 * Revision Date:      
 * Revision By: 
 * @version 1.3
--%>

<%@ page import="jkt.hms.masters.business.*"%>
<%@ page import="java.util.*"%>
<center>
<h1>Master Home</h1>
</center>
<br>

<br>
<br>
<%   String nextState="enable"; 
	 String previousState="disable";
	 String pojoName="MasterCountry";
	 String viewPage="";
     int i=0;
	 int min;
	 int max;
	 
	Map map = new HashMap();
	map = (Map) request.getAttribute("map");
	List userNameList = new ArrayList();
		if(map.get("enquiryList") != null){
	    userNameList = (List)map.get("enquiryList");}

		 Iterator userNameListitr=userNameList.iterator();
	     String country_code= null;
	 	 String country_name= null;
		
		 if(map.get("min")!=null){
		 min=Integer.parseInt((String)map.get("min"));}
		 else min=0;
		 if(map.get("max")!=null)
		 max=Integer.parseInt((String)map.get("max"));
		 else max=9;
		
		 session.setAttribute("viewPage", viewPage);
		 session.setAttribute("pojoName", pojoName);
		 session.setAttribute("min", min+"");
 		 session.setAttribute("max", max+"");
 		 String pageName="enquiry";
		 session.setAttribute("pageName",pageName);
	 	 if(map.get("previousState")!=null)
		 previousState=(String)map.get("previousState");
		
		 if(map.get("nextState")!=null)
	 	 nextState=(String)map.get("nextState");
	 	 
	 	  %>
<center><font color="red"> </font></center>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<form name="enquiryForm" action="" method="post">

<table width="38%" height="195" border="1" align="center">
	<thead>
		<tr>

			<td><b>Country Code</b></td>
			<td><b>Country Name</b></td>
		</tr>
	</thead>


	<tbody>

		<% while (userNameListitr.hasNext()){
            	//int userId;
            	MasterCountry userObject=(MasterCountry) userNameListitr.next();	
             int userId= userObject.getId();
             country_code= userObject.getCountryCode();
             country_name =userObject.getCountryName();
            if((min<=i)&&(max>=i)){   
           %>

		<tr>

			<td>&nbsp;&nbsp;&nbsp;<%=country_code%></td>
			<td>&nbsp;&nbsp;&nbsp;<%=country_name%></td>
		</tr>
		<%}i++;
				
				}%>


	</tbody>

</table>

<center><input type="hidden" name="hidName"> <input
	type="button" name="next" value="Next"
	onclick="if(nextButtonState('enquiryForm','<%=nextState%>')){submitForm('enquiryForm','/hms/hms/master?method=next');}" />
<input type="button" name="previous" value="Previous"
	onclick="if(previousButtonState('enquiryForm','<%=previousState %>')){submitForm('enquiryForm','/hms/hms/master?method=previous');}" />



</center>


</form>
