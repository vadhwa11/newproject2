<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasServiceType"%>

<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
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
	
	/*
	* Code Check Service No & complaint
	* Code By Mukesh 15 Aug 2012
	*/

	 var loopErrorList=new Array();
	 var counter=0;
	 var serviceNo="";
	 var complaint="";
	 serviceNo=document.getElementById('serviceNo').value;
	 complaint=document.getElementById('complaint').value;
	 if(trimAll(serviceNo) == "" || trimAll(complaint) == "")
		{
		 if(trimAll(serviceNo) != ""){
			if(validateAlphaNumeric(serviceNo)==false){
				loopErrorList[counter]="Service No is not valid.";
				++counter;
			}
		 }

			if(trimAll(complaint) != ""){
				if(validateGoodString(complaint)==false){
					loopErrorList[counter]="Complaint is not valid.";
					++counter;
				}
			}
		}
	 if(counter>0){
		 var msg="";
		 for(i=0;i<loopErrorList.length;i++){
			 msg=msg+"\n "+loopErrorList[i];	
			}
			alert(msg);
			return false;	
		}
	
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
	List<MasTrade> tradeList = null;
	List<Object[]> unitList = null;
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
	if(map.get("employeeList") != null){
		doctorList = (List<MasEmployee>)map.get("employeeList");
	}
	%>

<form name="dmaRegisterReport" target="_blank" method="post" action="">
<div class="titleBg"><h2>DMA Register</h2></div>
<div class="Clear"></div>

<div class="Clear"></div>
<div class="Block">
<div class="Clear"></div>
<label>Date: </label>
<label class="medium"> From <span>*</span></label>
<input type="text" id="FromDateId" name="<%=FROM_DATE %>"value="<%=currentDate %>" class="calDate" readonly="readonly"MAXLENGTH="10" validate="From Date,frdate,yes" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate%>',document.dmaRegisterReport.<%=FROM_DATE%>,event)" />

<label>To <span>*</span></label>
 <input type="text" id="ToDateId"name="<%=TO_DATE %>" value="<%=currentDate %>" class="calDate"	readonly="readonly" MAXLENGTH="10" validate="To Date,frdate,yes" /> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate%>',document.dmaRegisterReport.<%=TO_DATE%>,event)" />
	
<div class="Clear"></div>
<label>Age:</label>
<label class="medium"> From </label>

<select id="fromageId"	name="fromAge" tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="fromageUnitId" name="fromAgeUnit"	 tabindex="1" class="small">
	<option value="">Select</option>
	<option value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 

<label> To </label>

<select id="toageId"	name="toAge"  tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="toageUnitId" name="toAgeUnit"	tabindex="1" class="small">
	<option value="">Select</option>
	<option value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 
<div class="Clear"></div>
<label>Unit </label> 
<label class="medium">&nbsp;</label>
<select id="unitId" name="<%=UNIT_ID %>" tabindex="1"	validate="Unit,string,no" >
	<option value="0">Select</option>
	<%
		 for(Object[] masUnit : unitList){
		 %>
	<option value="<%=masUnit[0]%>"><%=masUnit[1]%></option>
	<%
	 }%>
	
</select>


<label> Trade/Branch</label> 
<select id="tradeId" name="<%=TRADE_ID%>"	validate="Trade,string,no" tabindex="1">
	<option value="0">Select</option>
	<%for(MasTrade trade :tradeList){ %>
	<option value=<%=trade.getId()%>><%=trade.getTradeName() %></option>
	<%} %>
	
</select>
<div class="Clear"></div>	
<label> Rank</label> 
<label class="medium">&nbsp;</label>
	<select	id="rankId" name="rankId"tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasRank masRank : rankList) 
				{
			 		%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			 		}%>
</select> 

<label>Doctor(MO)</label> 
<select	id="consultingDocId" name="<%=CONSULTING_DOCTOR %>"	tabindex="1">
	<option value="0">Select</option>
	<%

for(MasEmployee masEmployee : doctorList){
	
%>
	<option value="<%=masEmployee.getId() %>"><%= masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+(masEmployee.getMiddleName()!=null?masEmployee.getMiddleName():"")+" "+(masEmployee.getLastName()!=null?masEmployee.getLastName():"") %></option>
	<%				
} %>
</select> 
<div class="Clear"></div>

<div class="Clear"></div>
<label> Complaint</label>
<label class="medium">&nbsp;</label>
<input type="text" name="complaint" id="complaint" value=""MAXLENGTH="50" validate="Complaint,metachar,no"/>

<label> Service No.</label>
<input type="text" name="<%=SERVICE_NO %>" id="serviceNo" value=""MAXLENGTH="30" validate="Service No.,metachar,no"/>	
<div class="Clear"></div>
<label> DMO Called</label>
<label class="medium">&nbsp;</label>
<input type="checkbox" name="dmoCalled" value="y" class="radioCheck" />	
<label> Treatment Details</label>
<input type="checkbox" name="treatment" value="y"  class="radioCheck" />
<div class="Clear"></div>	
<label> Procedure Details</label>
<label class="medium">&nbsp;</label>
<input type="checkbox" name="procedure" value="y"  class="radioCheck" />	
<label> Inj.Admin.Details</label>
<input type="checkbox" name="injection" value="y"  class="radioCheck" />	
<div class="Clear"></div>
<label> Detention Details</label>
<label class="medium">&nbsp;</label>
<input type="checkbox" name="detention" value="y"  class="radioCheck" />	

<div class="Clear"></div>
</div>

<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="if(datevalidation()){submitForm('dmaRegisterReport','/hms/hms/registration?method=printDMARegisterReport');}" />
<input type="reset" name="Reset" value="Reset" class="button" accesskey="r" />
<div class="Clear"></div>

</form>
