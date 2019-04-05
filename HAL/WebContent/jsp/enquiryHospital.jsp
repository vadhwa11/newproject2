<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * enquiryHospital.jsp  
 * Purpose of the JSP -  This is for Enquiry for Hospital.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 12th Nov,2007 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasHospital;"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<%
	
String nextState="enable"; 
String previousState="disable";

int i=0;
int min;
int max;

	Map<String,Object> map = new HashMap<String,Object>();
	
	if(request.getAttribute("map") != null)
		map = (Map<String,Object>) request.getAttribute("map");
		
	List hospitalMasterList = new ArrayList();
	if(map.get("enquiryList") != null){
		hospitalMasterList = (List)map.get("enquiryList");}
	
	 if(map.get("min")!=null){
		 min=Integer.parseInt((String)map.get("min"));
	 }
	 else
	 	min=0;
	 
	 if(map.get("max")!=null)
		 max=Integer.parseInt((String)map.get("max"));
	 else 
	 	max=9;
	
	
	String viewPage = "enquiryHospital";
	String pojoName = "HospitalMaster";
	String pojoPropertyName = "HospitalName";

	session.setAttribute("viewPage",viewPage);
	session.setAttribute("pojoName",pojoName);
	session.setAttribute("pojoPropertyName",pojoPropertyName);
	 
	 session.setAttribute("min", min+"");
	 session.setAttribute("max", max+"");
	 
	 if(map.get("previousState")!=null)
		 previousState=(String)map.get("previousState");
	
	 if(map.get("nextState")!=null)
		 nextState=(String)map.get("nextState");
	 
	
	%>
<form name="enquiryHospital" method="post" action=""><input
	type="hidden" name="<%= RequestConstants.VIEW_PAGE %>"
	value="enquiryHospital"> <input type="hidden"
	name="<%= RequestConstants.POJO_NAME %>" value="HospitalMaster">
<input type="hidden" name="<%=RequestConstants.POJO_PROPERTY_NAME %>"
	value="HospitalName">

<div id=contentspace>
<h2 align="left" class="style1">Masters</h2>
<fieldset align="center" style="width: 80%" class="tableBorder">
<legend class="bodytextB">Hospital - Enquiry </legend> <br />
<%
                   if(hospitalMasterList != null && hospitalMasterList.size() !=0){
                	%> <label></label>
<table width="81%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td class="today">
		<table width="100%" border="0" align="center" cellpadding="1"
			cellspacing="1" class="tableBorder" height="46">
			<tr>
				<td width="23%" height="19" valign="middle" class="bg_yellow">Hospital
				Code:</td>
				<td width="27%" height="19" valign="middle" class="bg_yellow">Hospital
				Name:</td>
				<td width="27%" height="19" valign="middle" class="bg_yellow">Address:</td>
				<td width="27%" height="19" valign="middle" class="bg_yellow">Phone
				Number:</td>
				<td width="25%" height="19" valign="middle" class="bg_yellow">Status</td>
			</tr>
			<% for(Iterator iter = hospitalMasterList.iterator(); iter.hasNext();)
                	   {
                    	MasHospital hospitalMaster = (MasHospital) iter.next();
                         
           				 if((min<=i)&&(max>=i)){  
                  %>
			<tr>
				<td width="23%" class="table_grid" bordercolor="#333333">&nbsp;&nbsp;&nbsp;
				<%=hospitalMaster.getHospitalCode()%></td>
				<td width="27%" class="table_grid" bordercolor="#333333">&nbsp;&nbsp;&nbsp;<%=hospitalMaster.getHospitalName()%></td>
				<td width="27%" class="table_grid" bordercolor="#333333">&nbsp;&nbsp;&nbsp;
				<%=hospitalMaster.getAddress()%></td>
				<td width="27%" class="table_grid" bordercolor="#333333">&nbsp;&nbsp;&nbsp;<%=hospitalMaster.getContactNumber()%></td>
				<%
                   		
                    	if(hospitalMaster.getStatus().equals("y")){
                    %>
				<td width="25%" class="table_grid" bordercolor="#333333">Active</td>
				<%}else{
                    
                    %>
				<td width="25%" class="table_grid" bordercolor="#333333">In-Active</td>
				<%}
					%>

				<%	}i++;
					}%>

			</tr>
		</table>
		</td>
	</tr>
</table>
<br />
<br />
<label>&nbsp;</label> <input type="button" name="previous"
	value="Previous" class="button"
	onclick="if(previousButtonState('enquiryHospital','<%=previousState %>')){submitForm('enquiryHospital','/security/security/common?method=previous');}" />
<input type="button" name="next" value="Next" class="button"
	onclick="if(nextButtonState('enquiryHospital','<%=nextState%>')){submitForm('enquiryHospital','/security/security/common?method=next');}" />

<%             }   else{           
%> <label class="labeGreen">No Record Found!</label> <%}
				%> <input type="button" name="back22" value="Back" class="button"
	onClick="showDetails('enquiryHospital','/security/security/superAdmin?method=showHospitalMasterJsp');" />
<input type="hidden" value="0" name="count2" class="table_grid" /> <br />
<br />
</form>
</fieldset>
</div>
