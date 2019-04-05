<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * edReturnFrom.jsp  
 * Purpose of the JSP -  This is for ed Return.
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.3
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
	
<script type="text/javascript"
	language="javascript">
 <%
  Calendar calendar=Calendar.getInstance();
  String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
  String date=String.valueOf(calendar.get(Calendar.DATE));
  int year=calendar.get(calendar.YEAR);
  if(month.length()<2){
   month="0"+month;
  }
  if(date.length()<2){
   date="0"+date;
  }
 %>
  serverdate = '<%=date+"/"+month+"/"+year%>'
     function check(browser){
     document.getElementById("ff").value=browser
     }
  function noOfDayCheck(rowVal)
  {
     var noOfDayBlank =document.getElementById('noOfDay'+rowVal).value;
     var noOfDay = parseInt(document.getElementById('noOfDay'+rowVal).value)
	  if(noOfDayBlank=="")
	  { 	  
         alert("Please Enter the No. Of Days"); 
	  }else if(isNaN(noOfDay))
	  {	  
	    alert("Please Enter Numeric Value.");
	    document.getElementById('noOfDay'+rowVal).value="";
	    document.getElementById('noOfDay'+rowVal).focus(); 
	 }	  
  }
  function checkValue()
  {
     var n=parseInt(document.getElementById('inc').value)
     alert("n >>>."+n)
     for(var i=0;i<n;i++)
     {
        if(document.getElementById('noOfDay'+i).value!="")
        {
            alert("no of =========>"+document.getElementById('noOfDay'+i).value)
            if(document.getElementById('edDate'+i).value=="")
            { 
                alert("Please Enter Date.")
                document.getElementById('edDate'+i).focus();
               return false;   
           }
            if(document.getElementById('edDispose'+i).value=="0")
            {    
             alert("Please Select Disposal.")
             document.getElementById('edDispose'+i).focus();
             return false;  
            }            
        }    
     }
     return true;           
  }	  
 </script>

<div class="titleBg">
<h2>Excuse Duty Returns Entry Form</h2>
</div>
<div class="Clear"></div>
<%
     String userName = "";
     if (session.getAttribute("userName") != null) {
      userName = (String) session.getAttribute("userName");
     }
          Map<String, Object> utilMap = new HashMap<String, Object>();
     utilMap = (Map) HMSUtil.getCurrentDateAndTime();
     String currenDate = (String) utilMap.get("currentDate");
     String time = (String) utilMap.get("currentTime");

     Map<String, Object> map = new HashMap<String, Object>();
     if (request.getAttribute("map") != null) {
      map = (Map<String, Object>) request.getAttribute("map");
     }
     List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
     List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
     List<Patient> patientList = new ArrayList<Patient>();
     List<Visit> visitList = new ArrayList<Visit>();
     List<Object> list = null;
     Date toDate  = null;
     Date fromDate=null;
     String category=null;
     
    
     if (map.get("rankCategoryList") != null) {
      rankCategoryList = (List<MasRankCategory>) map.get("rankCategoryList");
     }
     if (map.get("disposalList") != null) {
      disposalList = (List<MasDisposal>) map.get("disposalList");
     }
     if (map.get("patientList") != null) {
      patientList = (List<Patient>) map.get("patientList");
     }
    
     if (map.get("showList") != null) {
      list = (List<Object>) map.get("showList");
      
     }
     if (map.get("toDate") != null) {
      toDate = (Date) map.get("toDate");
      
     }
     if (map.get("fromDate") != null) {
      fromDate = (Date) map.get("fromDate");
      
     }
     if (map.get("category") != null) {
      category = (String) map.get("category");
      
     }
     int hospitalId =0;
     if(map.get("hospitalId")!=null){
    	 hospitalId = (Integer)map.get("hospitalId");
    	 System.out.println("hospitalId in EDReturnForm"+hospitalId);
     }
     if(map.get("message") != null){
     String message = (String)map.get("message");
     
     %> <label class="auto"> <span> <%=message %> </span> </label>
<div class="Clear"></div>
<%    
       }
    %>
<form name="EDDetails" method="post" action="">
<input type="hidden" name="hospitalId" value="<%=hospitalId %>" validate="hospital id,metachar,yes"/>
<h4>Enter Details</h4>
<div class="Block">
<label>From Date</label> 
<input
	type="text" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currenDate %>" class="calDate" readonly="readonly" 
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currenDate%>',document.EDDetails.<%=FROM_DATE%>,event)" />

<label> To Date</label> <input type="text" id="toDateId"
	name="<%=TO_DATE %>" value="<%=currenDate %>" class="calDate"
	readonly="readonly" MAXLENGTH="30" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate%>',document.EDDetails.<%=TO_DATE%>,event)" />

<label>Category </label> <select id="categoryId"
	name="<%=CATEGORY_ID %>" >
	<option value="0">Select</option>
	<%for (MasRankCategory masRankCategory : rankCategoryList) {
		if(masRankCategory.getId()!=3 && masRankCategory.getId()!=4 && masRankCategory.getId()!=5 && masRankCategory.getId()!=6){
	%>
	<option value="<%=masRankCategory.getId() %>"><%=masRankCategory.getRankCategoryName()%></option>
	<%}
	}%>
</select></div>

<div class="Clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" name="show" value="Show" class="button" onClick="submitProtoAjaxForEDReturns('EDDetails','mis?method=showEDReturns','show');" />
<input type="hidden" name="<%= POJO_NAME %>" value="Visit"> 
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="VisitNo">
<input type="hidden" name="title" value="EDDetails"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="EDDetails"> 
<input	type="hidden" name="pojoPropertyCode" value="VisitNo">
<div class="Clear"></div>
<div id="show"></div>

<div class="Clear"></div>
<div class="division"></div>
<div class="clear"></div>
<jsp:include page="currentUserDetails.jsp"></jsp:include>
	

<div class="Clear"></div>

</form>
