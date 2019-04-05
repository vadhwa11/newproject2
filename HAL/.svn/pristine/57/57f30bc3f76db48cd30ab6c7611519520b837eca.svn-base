







<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * updateHospitalMaster.jsp  
 * Purpose of the JSP -  This is for Updating Hospital Master.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 02nd Nov,2007 
 * Revision Date:      
 * Revision By:  
 * @version 1.4
--%>

<%@ page import="jkt.hms.util.RequestConstants"%>

<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital;"%>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<title>Main</title>
<div id=contentspace>
<h2 align="left" class="style1">Masters</h2>
<fieldset align="center" style="width: 80%" class="tableBorder">

<legend class="bodytextB">Update Hospital - Main </legend> <script
	type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script> <script type="text/javascript"
	language="javascript" src="/hms/jsp/js/hms.js"></script> <%
	
	Map map = new HashMap();
	if(request.getAttribute("map") != null)
		map = (Map) request.getAttribute("map");
		
	List<MasHospital> hospitalNameList = new ArrayList<MasHospital>();
	if(map.get("hospitalNameList") != null)
		hospitalNameList = (List<MasHospital>) map.get("hospitalNameList");
		
	
%>

<form name="updateHospital" method="post" action=""><br>
<br>
<label class="bodytextB_blue">Code:</label> <input
	name=<%=RequestConstants.HOSPITAL_CODE%> type="text"
	class="textbox_size20_disb" readonly="readonly"> <br>
<br>
<label class="bodytextB_blue"><font id="error">*</font>Name:</label> <select
	id="commonid" name=<%=RequestConstants.HOSPITAL_ID%>
	onChange="fetchHospitalDetails(this,'updateHospital')">

	<option value="">--Select--</option>

	<% 
         	 
              MasHospital objHospitalMaster = new MasHospital();
	  		  for (int i =0;i< hospitalNameList.size(); i++)
			  {
	  			objHospitalMaster = (MasHospital)hospitalNameList.get(i);
				int id = objHospitalMaster.getId();
				String code = objHospitalMaster.getHospitalCode();
		        String name = objHospitalMaster.getHospitalName();
		        String address = objHospitalMaster.getAddress();
		        String contactNo = objHospitalMaster.getContactNumber();
		        String changeBy = objHospitalMaster.getLastChgBy();
	            Date changeDate = objHospitalMaster.getLastChgDate();
	            String  changeTime = objHospitalMaster.getLastChgTime();
		        String status = objHospitalMaster.getStatus(); 
%>

	<script>
				commonArray[<%=i%>]= new Array();
				commonArray[<%=i%>][0] = "<%=id%>";
				commonArray[<%=i%>][1] = "<%=code%>";
				commonArray[<%=i%>][2] = "<%=name%>";
				commonArray[<%=i%>][3] = "<%=address%>";
				commonArray[<%=i%>][4] = "<%=contactNo%>";
				commonArray[<%=i%>][5] = "<%=status%>";
				commonArray[<%=i%>][6] = "<%=changeBy%>";
				commonArray[<%=i%>][7] = "<%=changeDate%>";
				commonArray[<%=i%>][8] = "<%=changeTime%>";
				
</script>

	<option value="<%=objHospitalMaster.getId()%>"><%=objHospitalMaster.getHospitalName()%></option>
	<%}%>
</select> <input id="searchname" name=<%=RequestConstants.SEARCH_NAME%>
	type="text" value="" class="textbox_size20"> <br />
<br />
<label class="bodytextB_blue">Address :</label> <input
	name=<%=RequestConstants.ADDRESS%> type="text" value=""
	class="textbox_size20"> <br />
<br />
<label class="bodytextB_blue">Contact Number :</label> <input
	name=<%=RequestConstants.CONTACT_NUMBER%> type="text" value=""
	class="textbox_size20"> <br />
<br />
<label class="bodytextB_blue">Status :</label> <input
	name="<%=RequestConstants.STATUS  %>" type="radio" class="checkbox"
	value="y" checked="checked" /> <font class="bodytextB_blue">Active</font>
<input type="radio" name="<%=RequestConstants.STATUS %>" value="n"
	class="checkbox" /> <font class="bodytextB_blue">Inactive</font> <br />
<br />
<label>&nbsp;</label> <label class="bodytextB_blue">Changed by:
</label> <label class="bodytextB_blue"> Changed Date: </label> <label
	class="bodytextB_blue"> Changed Time: </label> <br />
<label>&nbsp;</label> <input name=<%=RequestConstants.CHANGED_BY%>
	type="text" class="textbox_size20_disb" readonly="readonly"> <input
	name=<%=RequestConstants.CHANGED_DATE%> type="text"
	class="textbox_size20_disb" readonly="readonly"> <input
	name=<%=RequestConstants.CHANGED_TIME%> type="text"
	class="textbox_size20_disb" readonly="readonly"> <br>
<br>
<label>&nbsp;</label> <input type="button" name="update" value="Update"
	class="button"
	onClick="submitForm('updateHospital','/security/security/superAdmin?method=updateHospital','checkBlank');" />
<input type="button" name="back" value="Back" class="button"
	onClick="showDetails('updateHospital','/security/security/superAdmin?method=showHospitalMasterJsp');" />
<input type="hidden" value="0" name="count2" /> <br />
<br />
</form>
</fieldset>
</div>