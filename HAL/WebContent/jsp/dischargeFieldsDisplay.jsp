<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name:  dischargeFieldsDisplay.jsp
	 * Tables Used: discharge_items, discharge_items_category, discharge_summary 
	 * Entry Screen to feed Discharge Summary Details
	 * @author  Create Date: 11.02.2008    Name: Othivadivel K R   
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 * @see DischargeController.java, DischargeHandlerService.java, DischargeHandlerServiceImpl.java, 
	 *      DischargeDataService.java, DischargeDataServiceImpl.java, dischargeFieldDisplay.jsp
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.DischargeItemsCategory"%>
<%@page import="jkt.hms.masters.business.DischargeItems"%>


<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>



<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
	</script>


<%	
		String userName = "";
		String date ="";
		String time = "";
		String reply = "";
		Map map = new HashMap();
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		List dischargeItemsCategoryList = new ArrayList();
		DischargeItemsCategory dischargeItemsCategory = null;

		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		date = (String)utilMap.get("currentDate");	
		time = (String)utilMap.get("currentTime");
		
  	    if (map.get("dischargeItemsCategoryList") != null)
  	    	dischargeItemsCategoryList =(List)map.get("dischargeItemsCategoryList");

  	    if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
%>
<%
String department = null;
if (request.getParameter("casetype").equals("G"))
	department = "Department: General";
else if (request.getParameter("casetype").equals("O"))
	department = "Department: Obe & Gynaecology";
else if (request.getParameter("casetype").equals("P"))
	department = "Department: Paediatrics";
else if (request.getParameter("casetype").equals("N"))
	department = "NABH";

%>


<% if (department!=null) {
		
	//if(!department.equalsIgnoreCase("Department: NABH")){
	%>
<h4><%=department%></h4>
<div class="Clear"></div>

<%if(!department.equalsIgnoreCase("NABH")){ %>
<div class="Block">
<%}%> <% if (dischargeItemsCategoryList.size() > 0 ) { %> <%  
					    for (int i=0;i<dischargeItemsCategoryList.size();i++)
					    {
					    	reply="";
					    	dischargeItemsCategory = (DischargeItemsCategory)dischargeItemsCategoryList.get(i);
			    	%> <% if (i%4 == 0) { %> <% }
				    		if (!dischargeItemsCategory.getLabelDataType().equals("TEXTAREABIG")){
				    		%>
<div class="clear"></div>
<label><%=dischargeItemsCategory.getLabel()%></label> <%}
								if (map.get(dischargeItemsCategory.getId().toString())!=null)
										reply = map.get(dischargeItemsCategory.getId().toString()).toString();						
							
								if (dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("DIAG"))
								{
										if (map.get("DIAG")!=null) reply = map.get("DIAG").toString();
								}
							
							%> <%
								if (dischargeItemsCategory.getLabelDataType().equals("TEXTAREA"))
								{
							%> <% if (dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("DIAG"))
									{ 
									%> <textarea
	name="<%=dischargeItemsCategory.getId().intValue()%>" cols="40"
	rows="2" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="1024" readonly class="large"><%=reply%></textarea>
<div class="Clear"></div>
<%
									} else { %> <textarea
	name="<%=dischargeItemsCategory.getId().intValue()%>" cols="40"
	rows="2" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" class="large"
	onkeyup="finalCheck(this)" maxlength="1024"><%=reply%></textarea>
<div class="Clear"></div>
<% } %> <%
								} else if (dischargeItemsCategory.getLabelDataType().equals("TEXT")) { 
									String str = "";	
									System.out.println("in if111   "+dischargeItemsCategory.getLabel());
									if(dischargeItemsCategory.getLabel().equals("Body Weight") || dischargeItemsCategory.getLabel().equals("Weight") ||  dischargeItemsCategory.getLabel().equals("Height")){
									System.out.println("in if");
										str = dischargeItemsCategory.getLabel()+",float,no";
									}
								
							%> <input type="text" validate="<%= str %>"
	name="<%=dischargeItemsCategory.getId().intValue()%>"
	value="<%=reply%>" class="large2" />
<div class="Clear"></div>
<%
								} else if (dischargeItemsCategory.getLabelDataType().equals("DATE")) { 
									
								if(!reply.equals("")){
							%> <input type="text"
	name="date<%=dischargeItemsCategory.getId().intValue()%>"
	value="<%=reply%>"
	validate="<%=dischargeItemsCategory.getLabel()%>,dateOfAdmission,no"
	class="calDate" readonly />
	<%}else{ %>
	<input type="text"
	name="date<%=dischargeItemsCategory.getId().intValue()%>"
	value="<%=date%>"
	validate="<%=dischargeItemsCategory.getLabel()%>,dateOfAdmission,no"
	class="calDate" readonly />
	
	<%} %> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.dischargePatient.date<%=dischargeItemsCategory.getId().intValue()%>,event);"
	class="calender" />
<div class="Clear"></div>
<%
							} else if(dischargeItemsCategory.getLabelDataType().equals("COMBO_NAME")){
							%> <select name="<%=dischargeItemsCategory.getId().intValue()%>">
</select> <% } %> <%
				    }
				    %> <%if(!department.equalsIgnoreCase("NABH")){%>
<div class="Clear"></div>
</div>

<%} %>
<div class="Clear"></div>
<div class="blockFrame">
<%
		String val ="";
		if (dischargeItemsCategoryList.size() > 0 ) { %> <%for (int j=0;j<dischargeItemsCategoryList.size();j++){
		  dischargeItemsCategory = (DischargeItemsCategory)dischargeItemsCategoryList.get(j);
		  if (dischargeItemsCategory.getLabelDataType().equals("TEXTAREABIG")){
		  if (map.get(dischargeItemsCategory.getId().toString())!=null)
				val = map.get(dischargeItemsCategory.getId().toString()).toString();
	  %> <%
	  	 if(department.equalsIgnoreCase("NABH")){
	  	  if(dischargeItemsCategory.getLabel().equalsIgnoreCase("Brief Case Summary(For Printing on Discharge slip)")){
	  		 if(val.equals("") || val.equalsIgnoreCase("Detailed discharge summary attached")){ %>
<label><%=dischargeItemsCategory.getLabel()%></label> <textarea
	name="<%=dischargeItemsCategory.getId().intValue()%>" cols="60"
	rows="3" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" class="large"
	onkeyup="finalCheck(this)" maxlength="1024"><%="Detailed discharge Summary attached"%></textarea>
<div class="Clear"></div>
<%}else{ %> <label><%=dischargeItemsCategory.getLabel()%></label>
<textarea name="<%=dischargeItemsCategory.getId().intValue()%>"
	cols="60" rows="3" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" class="large"
	onkeyup="finalCheck(this)" maxlength="1024"><%=val%></textarea>
<div class="Clear"></div>
<% }}else{ %> <label><%=dischargeItemsCategory.getLabel()%></label>
<textarea name="<%=dischargeItemsCategory.getId().intValue()%>"
	class="large" cols="60" rows="3" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="1024"><%=val%></textarea>
<div class="Clear"></div>
<%}}else{ %> <label><%=dischargeItemsCategory.getLabel()%></label>
<textarea name="<%=dischargeItemsCategory.getId().intValue()%>"
	class="large" cols="60" rows="3" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="1024"><%=val%></textarea>
<div class="Clear"></div>
<%}%> <%if(department.equalsIgnoreCase("NABH") && dischargeItemsCategory.getLabel().equalsIgnoreCase("Taken up advice & medical")){%>
<%}%> <%}}}%>
<div class="Clear"></div>
</div>



<% } %> <% } %>

<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="PatientDiagnosis" id="addbutton"
	value="Patient Diagnosis" class="buttonBig"
	onClick="submitForm('dischargePatient','discharge?method=addDischargeSummary&flag=PatientDiagnosis');"
	accesskey="a" /> <input type="button" name="Add" id="addbutton"
	value="Submit" class="button"
	onClick="submitForm('dischargePatient','discharge?method=addDischargeSummary');"
	accesskey="a" /> <!--<input type="button" name="Print" value="Print"
	class="button"
	onClick="if(checkpoint()){submitForm('dischargePatient','/hms/hms/discharge?method=showDischargeSummaryReport');}"
	accesskey="p" /> <input type="button" name="DischargeSlip"
	value="Discharge Slip" class="buttonbig"
	onClick="submitForm('dischargePatient','/hms/hms/ipd?method=showDischargeSlipReport');"
	accesskey="d" />--> <input type="reset" name="Back" value="Back"
	class="button" onclick="history.back()" accesskey="r" /> <input
	type="hidden" name="isRecordAlreadyExists"
	value="<%=map.get("isRecordAlreadyExists")%>" />

<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label	class="value"> <%=userName%> </label>
<label class="">Changed Date:</label>
<label class="value"> <%=date%> </label>
<label class="">Changed Time:</label>
<label class="value"> <%=time %> </label>
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />
<input type="hidden"	name="itemcount" id="itemcount"	value="<%=dischargeItemsCategoryList.size() %>">
<div class="Clear"></div>
</div>