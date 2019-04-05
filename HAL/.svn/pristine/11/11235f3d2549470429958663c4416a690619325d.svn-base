<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * masterCountryHome.jsp  
 * Purpose of the JSP -  This is for Master Country Home.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 28th Jun,2007 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>

<%@ page import="jkt.hms.masters.business.*"%>
<%@ page import="java.util.*"%>
<center>
<h1>Master Home</h1>
</center>
<br>

<br>
<br>
<% 
    String userMessage="";
	Map map = new HashMap();
	map = (Map) request.getAttribute("map");
	List userNameList = new ArrayList();
		if(map.get("countryList") != null){
	    userNameList = (List)map.get("countryList");}
		 Iterator userNameListitr=userNameList.iterator();
	     String country_code= null;
	 	 String country_name= null;
	 	  userMessage=(String)map.get("messageTOBeVisibleToTheUser");%>
<center><font color="red"> <% 
			if(userMessage!=null){
	 		 out.println(userMessage);
		}
	 	 %> </font></center>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<form name="masterForm" action="" method="post">

<table width="38%" height="195" border="1" align="center">
	<thead>
		<tr>
			<td width="15"></td>
			<td><b>Country Code</b></td>
			<td><b>Country Name</b></td>
		</tr>
	</thead>


	<tbody>

		<% while (userNameListitr.hasNext()){
            	MasterCountry userObject=(MasterCountry) userNameListitr.next();
             int userId= userObject.getId();
             country_code= userObject.getCountryCode();
             country_name =userObject.getCountryName();
                        
           %>

		<tr>
			<td><input type="radio" name="radio_button" class=checkbox
				onclick="checked" value=<%=userId %>></td>
			<td>&nbsp;&nbsp;&nbsp;<%=country_code%></td>
			<td>&nbsp;&nbsp;&nbsp;<%=country_name%></td>
		</tr>
		<% }%>


	</tbody>

</table>

<center><input type="hidden" name="hidName"> <input
	type="button" name="new" value="New"
	onclick="submitForm('masterForm','/hms/hms/master?method=showAddCountry');" />
<input type="button" name="update" value="Update"
	onclick="if(RadioCheck('masterForm','radio_button','hidName')){submitForm('masterForm','/hms/hms/master?method=showUpdateCountry');}" />
<input type="button" name="delete" value="Delete"
	onclick="if(RadioCheck('masterForm','radio_button','hidName') && checkDelete()){submitForm('masterForm','/hms/hms/master?method=deleteMasterCountryJsp');}" />
</center>


</form>
