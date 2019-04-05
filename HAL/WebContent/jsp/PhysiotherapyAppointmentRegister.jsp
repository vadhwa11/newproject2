<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasServiceType"%>

<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasSection"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasRank"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript"language="javascript">
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
		
	function datevalidation(){
	
	
	var fdate = document.getElementById('FromDateId');
	var tdate = document.getElementById('ToDateId');
	
	frdate  = new Date(fdate.value.substring(6),(fdate.value.substring(3,5) - 1) ,fdate.value.substring(0,2));
	todate  = new Date(tdate.value.substring(6),(tdate.value.substring(3,5) - 1) ,tdate.value.substring(0,2));
	
	
	if(fdate.value != "" && todate.value != ""){
	 if(frdate > todate){
	  alert("To Date should be greater than or equal to the From Date.");
	   return false;
	  }
	}else{
	 return false;
	}
	return true;	
		
		}
		
	
	</script>
	<%
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	Map<String, Object> map = new HashMap<String, Object>();
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	List<MasRank> rankList = new ArrayList<MasRank>();
	List<MasServiceType> serviceTypeList =null;
	List<MasServiceStatus> serviceStatusList =null;
	List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
	List<MasTrade> tradeList = null;
	List<Object[]> unitList = null;
	List<MasSection> sectionList = null;
	List<MasAdministrativeSex> sexList = null;
	List<MasMaritalStatus> maritalStatusList = null;
	List<MasEmployee> doctorList = null;
	
	if(map.get("rankList")!=null){
		rankList = (List<MasRank>)map.get("rankList");
	}

	if(map.get("tradeList") != null){
		tradeList = (List<MasTrade>)map.get("tradeList");
	}
	if(map.get("unitList") != null){
		unitList= (List<Object[]>)map.get("unitList");
	}
	if(map.get("sectionList") != null){
		sectionList = (List<MasSection>)map.get("sectionList");
	}
	if(map.get("sexList") != null){
		sexList = (List<MasAdministrativeSex>)map.get("sexList");
	}
	if(map.get("maritalStatusList") != null){
		maritalStatusList = (List<MasMaritalStatus>)map.get("maritalStatusList");
	}
	if(map.get("employeeList") != null){
		doctorList = (List<MasEmployee>)map.get("employeeList");
	}
	%>

<form name="phyAppointmentRegister" method="post" action="">
<div class="titleBg"><h2>Physiotherapy Appointment Register</h2></div>
<div class="Clear"></div>

<div class="Clear"></div>
<div class="Block">
<div class="Clear"></div>
<label>Date:</label>
<label class="">From </label> 

<input type="text" id="FromDateId" name="<%=FROM_DATE %>"value="<%=currentDate %>" class="date" readonly="readonly" MAXLENGTH="30" validate="From Date,frdate,yes"
	onClick="setdate('<%=currentDate%>',document.phyAppointmentRegister.<%=FROM_DATE%>,event)" /> 
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" class="calender"
	onClick="setdate('<%=currentDate%>',document.phyAppointmentRegister.<%=FROM_DATE%>,event)" />

<label> To <span>*</span> </label>
 <input type="text" id="ToDateId"name="<%=TO_DATE %>" value="<%=currentDate %>" class="date"	readonly="readonly" MAXLENGTH="30" validate="To Date,frdate,yes"	onClick="setdate('<%=currentDate%>',document.phyAppointmentRegister.<%=TO_DATE%>,event)" />
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" class="calender"	onClick="setdate('<%=currentDate%>',document.phyAppointmentRegister.<%=TO_DATE%>,event)" />
	
<div class="Clear"></div>
<label>Rank:</label>
	<select	id="fromrankId" name="fromRankId" tabindex="1" validate="Rank,metachar,no">
	<option value="0">Select</option>
	<%
			 	for (MasRank masRank : rankList) 
				{
			 		%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			 		}%>
</select> 
	

<label> Trade/Branch</label> 
<select id="tradeId" name="<%=TRADE_ID%>"	validate="Trade,metachar,no" tabindex="1">
	<option value="0">Select</option>
	<%for(MasTrade trade :tradeList){ %>
	<option value=<%=trade.getId()%>><%=trade.getTradeName() %></option>
	<%} %>
	
</select>
<div class="Clear"></div>
<label>Unit </label> 

<select id="unitId" name="<%=UNIT_ID %>" tabindex="1"	validate="Unit,metachar,no" >
	<option value="0">Select</option>
	<%
		 for(Object[] masUnit : unitList){
		 %>
	<option value="<%=masUnit[0]%>"><%=masUnit[1]%></option>
	<%
	 }%>
	
</select>
<label>Section</label> 
<select id="sectionId" name="<%=SECTION_ID%>" tabindex="1" validate="Section,metachar,no">
	<option value="0">Select</option>
	<%
	 for(MasSection masSection : sectionList){
		
	 %>
	<option value="<%=masSection.getId()%>"><%=masSection.getSectionName()%></option>

	<%}
	%>

</select>
<div class="Clear"></div>
<label> Service No.</label>

<input type="text" name="<%=SERVICE_NO %>" value="" MAXLENGTH="30" validate="Service No.,metachar,no"/>
<label>Gender </label>
<select name="<%=SEX_ID %>" id="srSexId" validate="" tabindex="1" validate="Gender,metachar,no">
<option value="0">Select</option>
	<%
		   	 		for(MasAdministrativeSex masAdministrativeSex : sexList){
			%>
	
	<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
	<%
				
		   	 	} %>
</select> 

<div class="Clear"></div>

<label>Medical Officer</label> 
<select	id="consultingDocId" name="<%=CONSULTING_DOCTOR %>"	tabindex="1" validate="Medical Officer,metachar,no">
	<option value="0">Select</option>
	<%

for(MasEmployee masEmployee : doctorList){
	
%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%				
} %>
</select> 
<div class="Clear"></div>
<div class="Clear"></div>
</div>	
	
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button" onClick="if(datevalidation()){submitForm('phyAppointmentRegister','/hms/hms/physiotherapy?method=showPhyAppointmentRegisterReport');}" />
<input type="button" name="Print" value="Print" class="button" onClick="if(datevalidation()){checkTargetForYes();submitForm('phyAppointmentRegister','/hms/hms/physiotherapy?method=printPhyAppintmentRegisterReport');checkTargetForNo();}" />
<input type="reset" name="Reset" value="Reset" class="button" accesskey="r" />
<div class="Clear"></div>
</form>
