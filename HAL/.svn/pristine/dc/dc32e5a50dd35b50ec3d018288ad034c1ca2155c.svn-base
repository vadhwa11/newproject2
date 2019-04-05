<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>

	<%
		Map<String,Object> map = new HashMap<String,Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		
		if(map.get("accountList")!= null){
			accountList = (List<FaMasAccount>)map.get("accountList");
		}
		
		String message = "";
		if (map.get("message") != null) {
			 message = (String) map.get("message");
			out.println(message);
		}
		
		List<MasHospital> centreHList = new ArrayList<MasHospital>();
		centreHList = (ArrayList)map.get("centreHList");
	%> 


<form name="bankBook" method="post" action="">
<div class="paddingTop15"></div>
<div class="titleBg"> <h4>Bank Book</h4></div>
<div class="Block"> 

<label><span>*</span>Bank Account</label>
<select id="mainAccountId"  name="<%=ACCOUNT_ID %>"  validate="Bank Account,String,yes" onchange="getAccountName();">
	<option value="">Select</option>
	<%if(accountList.size()>0){
		for(FaMasAccount faMasAccount :accountList){
			
		%>
	<option value="<%=faMasAccount.getId() %>"><%=faMasAccount.getAccDesc() %></option>
		
	<%	}
	}
		%>
</select>

<input type="hidden" name="accountName" id="accountNameId" value=""/>
<input type="hidden" name="accId" id="accId" value=""/>
<label><span>*</span> From Date</label> 
<input type="text" name="<%= FROM_DATE%>" id="from_date" value="" validate="From Date,yes" class="calDate" MAXLENGTH="30" readonly="readonly" /> 

<label><span>*</span> To Date</label> 
<input type="text" name="<%= TO_DATE%>" id="to_date" value="" validate="To Date,yes"	class="calDate" MAXLENGTH="30" readonly="readonly" /> 
<div class="clear"></div>
<%
int locationId=0;
if(session.getAttribute("locationId") != null){
	locationId = (Integer)session.getAttribute("locationId");
}
if(locationId==1)
{
%>
<label>Centre<span>*</span></label>
<select name="centreHSearchId" validate="Centre ,string,yes" id="centreHSearchId" tabindex=1 >
<option value="0">Select</option>
	<% 	for (MasHospital  masHospital : centreHList){%>
		
	<option value="<%=masHospital.getId ()%>"><%=masHospital.getHospitalName()%></option>
	<%}%>
</select>
<%}else{%>
<input type="hidden" name="centreHSearchId" value="0">
<%} %>


</div>
<div class="division"></div>
<%--- Report Button   --%>
<%-- <input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="if(chkDate()){submitForm('report','account?method=printBankVoucherReport','displayFinancialYearMsg')};" accesskey="g" tabindex=1 />--%>
<input type="button" name="OK" id="addbutton" value="OK" class="button" onClick="submitForm('bankBook','account?method=displayBankBook');" accesskey="a" tabindex=1 />
<input type="button" name="OK" id="addbutton" value="Print" class="button" onClick="submitForm('bankBook','account?method=printBankBookReport');" accesskey="a" tabindex=1 />
<input type="reset" name="clear"  id="clearbutton" value="Clear" class="button"  accesskey="a"  tabindex=1 />
<div class="clear"></div>
<div class="division"></div>

</form>
<script>
function chkDate(){
	var fromDate=document.getElementById('from_date').value;
	var toDate=document.getElementById('to_date').value;
	
	if(toDate<fromDate){
		alert("To Date Is Smaller Than From Date");
		return false;
	}
	else 
		return true;
		
}
function getAccountName(){
	var accountId = document.getElementById('mainAccountId').value;
   <%if(accountList.size()>0){
   		for(FaMasAccount faMasAccount :accountList){%>
   			if(accountId == '<%=faMasAccount.getId()%>'){
   	   			var accountDesc = '<%=faMasAccount.getAccDesc()%>'
   			document.getElementById('accountNameId').value =accountDesc;
   		   		document.getElementById('accId').value =accountId;
   	   			
   			}
   		
  <%}} %>
 }
</script>