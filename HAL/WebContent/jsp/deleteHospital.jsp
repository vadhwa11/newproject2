<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * deleteHospital.jsp  
 * Purpose of the JSP -  This is for Deleting Hospital.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 02nd Nov,2007 
 * Revision Date:      
 * Revision By: 
 * @version 1.3  
--%>

<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital;"%>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<title>Main</title>
<div id=contentspace>
<h2 align="left" class="style1">Masters</h2>
<fieldset align="center" style="width: 80%" class="tableBorder">

<legend class="bodytextB">Delete Hospital - Main </legend> <script
	type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script> <script type="text/javascript"
	language="javascript" src="/hms/jsp/js/hms.js"></script> <%
	
	Map map = new HashMap();
	if(request.getAttribute("map") != null)
		map = (Map) request.getAttribute("map");
		
	List<MasHospital> hospitalNameList = new ArrayList<MasHospital>();
	if(map.get("hospitalNameList") != null)
		hospitalNameList = (List<MasHospital>) map.get("hospitalNameList");
		
	
	List<MasHospital> hospitalMasterList = new ArrayList<MasHospital>();
	MasHospital hospitalMaster = new MasHospital();
	String hospitalName = "";

	if(map.get("hospitalMasterList") != null){
		hospitalMasterList = (List<MasHospital>) map.get("hospitalMasterList");
		hospitalMaster = (MasHospital)hospitalMasterList.get(0);
	  	hospitalName = hospitalMaster.getHospitalName();
	  	
	}
 
 	
 
%>
<form name="deleteHospital" method="post" action=""><br>
<br>
<label class="bodytextB_blue">Hospital Code:</label> <%
              	if(hospitalMasterList.size() != 0 && hospitalMasterList != null){
              	
              %> <input name=<%=RequestConstants.HOSPITAL_CODE%>
	type="text" value="<%=hospitalMaster.getHospitalCode()%>"
	class="textbox_size5_disb" readonly> <%
              	}else{
			  %> <input name=<%=RequestConstants.HOSPITAL_CODE%> type="text"
	value="" class="textbox_size5_disb" readonly> <%}
              %> <br>
<br>
<label class="bodytextB_blue">Hospital Name:</label> <select
	name=<%=RequestConstants.HOSPITAL_ID%>
	onChange="showDeleteHospitalDetails('deleteHospital','/security/security/superAdmin?method=deleteHospital')"
	validate='Name,string,yes'>
	<option value="">--Select--</option>

	<% 
          
          for (Iterator iter = hospitalNameList.iterator(); iter.hasNext();)
          {
        	  MasHospital objHospitalMaster = (MasHospital) iter.next();
        
          	if(hospitalMasterList.size() != 0 && hospitalMasterList != null){
          		
          		if(objHospitalMaster.getHospitalName().equals(hospitalName)){
          			int hospitalId = hospitalMaster.getId();
          	
	%>
	<option value="<%=hospitalId%>" selected><%=hospitalName%></option>


	<%      	}
			}
			if(!objHospitalMaster.getHospitalName().equals(hospitalName)){
  %>
	<option value="<%=objHospitalMaster.getId()%>"><%=objHospitalMaster.getHospitalName()%></option>

	<% 			}
			
 		}
          
%>
</select> <br>
<br>
<label class="bodytextB_blue">Address:</label> <%
              	if(hospitalMasterList.size() != 0 && hospitalMasterList != null){
              	
              %> <input name=<%=RequestConstants.ADDRESS%> type="text"
	value="<%=hospitalMaster.getAddress ()%>" class="textbox_size20_disb"
	readonly> <%
              	}else{
			  %> <input name=<%=RequestConstants.ADDRESS%> type="text" value=""
	class="textbox_size20_disb" readonly> <%}
              %> <br>
<br>
<label class="bodytextB_blue">Contact Number:</label> <%
              	if(hospitalMasterList.size() != 0 && hospitalMasterList != null){
              	
              %> <input name=<%=RequestConstants.CONTACT_NUMBER%>
	type="text" value="<%=hospitalMaster.getContactNumber ()%>"
	class="textbox_size20_disb" readonly> <%
              	}else{
			  %> <input name=<%=RequestConstants.CONTACT_NUMBER%> type="text"
	value="" class="textbox_size20_disb" readonly> <%}
              %> <br>
<br>
<label class="bodytextB_blue">Status</label> <input
	name="<%=RequestConstants.STATUS  %>" type="radio" class="checkbox"
	value="y" /> <font class="bodytextB_blue">Active</font> <input
	type="radio" name="<%=RequestConstants.STATUS %>" value="n"
	class="checkbox" checked="checked" /> <font class="bodytextB_blue">Inactive</font>

<br />
<br />

<label></label> <label class="bodytextB_blue">Changed By :</label> <label
	class="bodytextB_blue">Changed Date:</label> <label
	class="bodytextB_blue">Changed Time:</label> <br />

<%
              	if(hospitalMasterList.size() != 0 && hospitalMasterList != null){
              	
            	  %> <label></label> <label class="changelabel"><%=hospitalMaster.getLastChgBy()%></label>
<label class="changelabel"><%=hospitalMaster.getLastChgDate()%>
</label> <label class="changelabel"><%=hospitalMaster.getLastChgTime() %>
</label> <br>
<br>
<%		}else{
                    %> <label></label> <label class="changelabel">
</label> <label class="changelabel"> </label> <label class="changelabel">
</label> <%}
		                    %> <br>
<br>
<label>&nbsp;</label> <label>&nbsp;</label> <input type="button"
	name="delete" value="delete" class="button"
	onClick="submitForm('deleteHospital','/hms/hms/superAdmin?method=deleteHospital');" />
<input type="button" name="back" value="Back" class="button"
	onClick="showDetails('deleteHospital','/hms/hms/superAdmin?method=showHospitalMasterJsp');" />
<input type="hidden" value="0" name="count2" /> <br>
<br>
</form>
</fieldset>
</div>