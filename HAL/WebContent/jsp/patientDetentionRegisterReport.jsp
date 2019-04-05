<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasServiceType"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasRank"%>

<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
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
	Map<String, Object> map = new HashMap<String, Object>();
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	List<MasRank> rankList = new ArrayList<MasRank>();
	if(map.get("doctorList")!=null){
		doctorList = (List<MasEmployee>)map.get("doctorList");
	}
	if(map.get("rankList")!=null){
		rankList = (List<MasRank>)map.get("rankList");
	}
	
	List<Object[]> unitList = null;
	List<MasTrade> tradeList = null;
	
	if(map.get("unitList") != null){
		unitList= (List<Object[]>)map.get("unitList");
	}
	if(map.get("tradeList") != null){
		tradeList = (List<MasTrade>)map.get("tradeList");
	}
	List<MasNursingCare> procedureList = new ArrayList<MasNursingCare>();
	if(map.get("procedureList") != null){
		procedureList= (List<MasNursingCare>)map.get("procedureList");
	}
	%>

<form name="detentionReport"  method="post" action="">
<div class="titleBg"><h2>Patient Detention Register</h2></div>
<div class="Clear"></div>

<div class="Clear"></div>
<div class="Block">
<div class="Clear"></div>
<label>Date </label>
<label class="medium"> From <span>*</span> </label>
<input type="text" id="FromDateId" name="<%=FROM_DATE %>"value="<%=currentDate %>" class="calDate" readonly="readonly"MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate%>',document.detentionReport.<%=FROM_DATE%>,event)" />

<label> To <span>*</span> </label>
 <input type="text" id="ToDateId"name="<%=TO_DATE %>" value="<%=currentDate %>" class="calDate"	readonly="readonly" MAXLENGTH="30" /> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate%>',document.detentionReport.<%=TO_DATE%>,event)" />
	<div class="Clear"></div>	
<label>Rank</label> 
<label class="medium">&nbsp;</label>
	<select	id="rankId" name="<%=RANK_ID%>" validate="Rank,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasRank masRank : rankList) 
				{
			 		%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			 		}%>
</select> 



<label>Unit </label> 
<select id="unitId" name="<%=UNIT_ID %>" tabindex="1"	validate="Unit,string,no" >
	<option value="0">Select</option>
	<%
		 for(Object[] masUnit : unitList){
		 %>
	<option value="<%=masUnit[0]%>"><%=masUnit[1]%></option>
	<%
	 }%>
	<option value="other">Other</option>
</select>
	<div class="Clear"></div>
<label> Trade/Branch</label> 
<label class="medium">&nbsp;</label>
<select id="tradeId" name="<%=TRADE_ID%>"	validate="Trade,string,no" tabindex="1">
	<option value="0">Select</option>
	<%for(MasTrade trade :tradeList){ %>
	<option value=<%=trade.getId()%>><%=trade.getTradeName() %></option>
	<%} %>
	<option value="other">Other</option>
</select>

	
	<label> Medical Officer </label> 
<select name="<%= REFERRED_BY %>" validate="Referred By,string,no" >
<option value="0">Select</option>
<%
	for(MasEmployee employee : doctorList){
%>
<option value="<%= employee.getId() %>"><%=employee.getRank().getRankName()+" "+employee.getFirstName()+" "+(employee.getMiddleName()!=null?employee.getMiddleName():"")+" "+(employee.getLastName()!=null?employee.getLastName():"")%></option>
<%} %>
</select>
	<div class="Clear"></div>

</div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button" onClick="if(datevalidation()){submitForm('detentionReport','/hms/hms/registration?method=showprintDetentionRegisterReport');}" />
<input type="button" name="PRINT" value="print" class="button"
	onClick="if(datevalidation()){submitForm('detentionReport','/hms/hms/registration?method=printDetentionRegisterReport');}" />
<input type="reset" name="Reset" value="Reset" class="button" accesskey="r" />
<input type="button" name="graph" value="Show Graph" class="button" onClick="openGraph();" />
<div class="Clear"></div>

</form>
<script>
function openGraph(){
	var url = "registration?method=showDetentionRegisterGraph&"+getNameAndData('detentionReport');
	window.open(url,'windowRef','width=600,height=400,scrollbars = yes');
	
}
</script>