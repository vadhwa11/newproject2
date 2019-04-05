<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * edReport.jsp  
 * Purpose of the JSP -  This is for ed Report.
 * * @author  
 * Create Date: 22nd Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
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
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<div id="contentHolder"><script type="text/javascript"
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
	</script>
<h2>Medical Claim Entry</h2>
<div class="Clear"></div>
<form name="medicalClaimEntry" method="post" action="">
<div class="Block">
<label>Service No.</label>
<input	type="text" id="serviceNo1" name="serviceNo1"	title="Fill Service No. first." value="" MAXLENGTH="30"	onblur="submitProtoAjaxWithDivName('fatalDocumentForm','/hms/hms/mis?method=getPatientDetails&serviceNo='+this.value,'deficientId');" />
</div>

<div class="clear"></div>

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
			 	List<MasRank> rankList=null;
			 	if (map.get("rankList") != null) {
			 	rankList = (List<MasRank>) map.get("rankList");
			 		
			 	}
			 	List<MasUnit> unitList=null;
			 	if (map.get("unitList") != null) {
			 		unitList = (List<MasUnit>) map.get("unitList");
			 		
			 	}
			 	
			 	List<MasTrade> tradeList=null;
			 	if (map.get("tradeList") != null) {
			 		tradeList = (List<MasTrade>) map.get("tradeList");
			 		
			 	}
			 	
			 %>

<div class="Block">
<label><span>*</span>Service No.</label>
 <input	type="text" name="serviceNo" id="serviceNo" tabindex="1"  value="" validate="Service No,string,yes" readonly="readonly"/>
 <label>Hin No.</label>
 <input	type="text" name="hinNo" id="hinNo" tabindex="1"  value="" readonly="readonly"/>
 
<label><span>*</span> Rank</label> 
<select	name="rank" id="rank" tabindex="1" >
<%for(MasRank masRankList:rankList){ %>
	<option value="<%=masRankList.getId() %>"><%=masRankList.getRankName()%></option>
	<%} %>
</select> 

<div class="Clear"></div>

<label><span>*</span>Name</label> 
<input type="text" name="sPerName" tabindex="1"  id="sPerName" value="" MAXLENGTH="30" validate="Ser Pers Name No,string,yes" />
<label><span>*</span> Unit</label>
<select	name="unit" id="unit" tabindex="1" >
<%for(MasUnit masUnitList:unitList){ %>
	<option value="<%=masUnitList.getId() %>"><%=masUnitList.getUnitName()%></option>
	<%} %>
</select> 
<label><span>*</span>Branch/Trade</label>
<select id="tradeId" name="<%=TRADE_ID%>"	validate="Branch/Trade,string,yes" tabindex="1"  	onchange="displayOtherTrade(this.value);">
	<option value="0">Select</option>
	<%for(MasTrade trade :tradeList){ %>
	<option value=<%=trade.getId()%>><%=trade.getTradeName() %></option>
	<%} %>
	</select>
	
<div class="Clear"></div>
<label>Type of Claim</label> 
<input type="text" name="typeOfClaim" tabindex="1"  id="typeOfClaim" value="" MAXLENGTH="30" validate="Type of Claim,string,yes" />
<label>Period of Claim</label> 
<input type="text" name="periodOfClaim" tabindex="1"  id="periodOfClaim" value="" MAXLENGTH="30" validate="Period of Claim,string,yes" />
<label>Total Financial Effect</label> 
<input type="text" name="totalFinancial" tabindex="1"  id="totalFinancial" value="" MAXLENGTH="30" validate="Total Financial Effect,string,yes" />
<div class="Clear"></div>
<label>Reason for delay</label> 
<input type="text" name="rForDelay" tabindex="1"  id="rForDelay" value="" MAXLENGTH="30" validate="Reason for delay,string,yes" />
<label>Step Taken</label> 
<input type="text" name="stepTaken" tabindex="1"  id="stepTaken" value="" MAXLENGTH="30" validate="Step Taken,string,yes" />
<div class="Clear"></div>
<h2>Dependent Details</h2>
<div class="Clear"></div>
<label>Dependent POR No.</label> 
<input type="text" name="dependentPORNo" tabindex="1"  id="dependentPORNo" value="" MAXLENGTH="30" validate=",string,yes" />

<input type="text" id="dobId"	name="<%=DATE_OF_BIRTH %>" tabindex="1" value=""	onblur="calculateAgeInAjaxFunction();" readonly="readonly"	validate="Date of Birth,date,yes" MAXLENGTH="30" class="calDate" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate %>',document.fatalDocumentForm.<%=DATE_OF_BIRTH%>,event)" />


<label><span>*</span> Age</label>
<div id="ageDiv" style="display: block;">
<select id="ageId"	name="<%=AGE%>" validate="Age of Patient,string,yes" tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="ageUnitId" name="<%=AGE_UNIT %>"	validate="AgeUnit,string,yes" tabindex="1" class="small">
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 
<input type="hidden" id="idForAge" value=""/>
</div>

<label><span>*</span>Sex </label>
<select	name="sex" id="sex" tabindex="1" >
<%for(MasAdministrativeSex masSexList:sexList){ %>
	<option value="<%=masSexList.getId() %>"><%=masSexList.getAdministrativeSexName() %></option>
	<%} %>
</select> 

<label><span>*</span> From Date:</label> <input
	type="text" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currenDate %>" class="calDate" readonly="readonly"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currenDate%>',document.edreport.<%= FROM_DATE%>,event)" />

<label><span>*</span> To Date:</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currenDate %>" class="calDate"
	readonly="readonly" MAXLENGTH="30" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate%>',document.edreport.<%= TO_DATE%>,event)" />

<div class="Clear"></div>
<label>Category Wise:</label>
 <select id="categoryId" name="<%=CATEGORY_ID %>" >
	<option value="0">Select</option>
	<%for (MasRankCategory masRankCategory : rankCategoryList) {%>
	<option value="<%=masRankCategory.getId() %>"><%=masRankCategory.getRankCategoryName()%></option>
	<%}%>
</select>
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('edreport','mis?method=showEDreports','checkFromNTodata');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" />
<div class="Clear"></div>
<div class="division"></div>
<div class="clear"></div>
<jsp:include page="currentUserDetails.jsp"></jsp:include>
	
</form>
<div class="Clear"></div>






