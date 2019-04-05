<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasBankMaster"%>
<%@page import="jkt.hms.masters.business.FaMasFdRegister"%>

<%@ page import="static jkt.hms.util.RequestConstants.JASPER_FILE_NAME"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="net.sf.jasperreports.engine.util.BigDecimalUtils"%>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>
<form name="fdRegister" method="post" action="">

<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
	List<FaMasFdRegister> fdRegisterList = new ArrayList<FaMasFdRegister>();
	List<FaMasFdRegister> fdRegisterIdList = new ArrayList<FaMasFdRegister>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("bankList") != null){
		bankList = (List<MasBankMaster>)map.get("bankList");
	}
	if(map.get("fdRegisterList") != null){
		fdRegisterList = (List<FaMasFdRegister>)map.get("fdRegisterList");
	}
	if(map.get("fdRegisterIdList") != null){
		fdRegisterIdList = (List<FaMasFdRegister>)map.get("fdRegisterIdList");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	String fdrNo = "";
	String issueDate ="";
	String maturityDate ="";
	BigDecimal amount = new BigDecimal(0);
	BigDecimal rateOfInterst = new BigDecimal(0);
	int bankId = 0;
	int days = 0;
	String remarks = "";
	int fdId = 0;
	if(fdRegisterIdList.size()>0){
		for(FaMasFdRegister fdRegister :fdRegisterIdList){
			if(fdRegister.getFdrNo() != null){
				fdrNo = fdRegister.getFdrNo();
			}
			if(fdRegister.getDateOfIssue() != null){
				issueDate =HMSUtil.convertDateToStringWithoutTime(fdRegister.getDateOfIssue());
			}
			if(fdRegister.getDateOfMaturity() != null){
				maturityDate =HMSUtil.convertDateToStringWithoutTime(fdRegister.getDateOfMaturity());
			}
			if(fdRegister.getAmount()!= null){
				amount = fdRegister.getAmount();
			}
			if(fdRegister.getRateOfInterest() != null){
				rateOfInterst = fdRegister.getRateOfInterest();
			}
			if(fdRegister.getNoOfDays() != null){
				days = fdRegister.getNoOfDays();
			}
			if(fdRegister.getRemarks() != null){
				remarks = fdRegister.getRemarks();
			}
			if(fdRegister.getBank() != null){
				bankId = fdRegister.getBank().getId();
			}
			fdId = fdRegister.getId();
		}
		
	}

	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
		%>
<h4><span><%=message %></span></h4>
	<%}
%>


<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="titleBg">
<h4>Fixed Deposit Register</h4>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<div id="fixedDiv">
<label>Bank Name<span>*</span></label>
<select id="bankId"  name="bankId" validate="Bank,string,yes" >
<option value="0">Select</option>
	<%if(bankList.size()>0){
		for(MasBankMaster masBankMaster :bankList){
			if(masBankMaster.getId().equals(bankId)){
		%>
		<option value="<%=masBankMaster.getId() %>" selected="selected"><%=masBankMaster.getBankName() %></option>
	<%}else{ %>
	<option value="<%=masBankMaster.getId() %>"><%=masBankMaster.getBankName() %></option>
	<%}}} %>
</select>
<input type="hidden" name="fdId" value="<%=fdId %>">
<label>FDR No.<span>*</span></label>
<input type="text" name="fdrNo" id="fdrNoId" value=""  validate="FDR No.,string,yes"/>
<script>document.getElementById('fdrNoId').value = '<%=fdrNo%>'</script>
<div class="clear"></div>

<label id="Label1">Date of Issue<span>*</span></label>
<input type="text" name="issueDate" class="calDate" id="issueDateId" value="" validate="Date of Issue,date,yes" onChange="startEndDateValidate()"/>
<script>document.getElementById('issueDateId').value = '<%=issueDate%>'</script>
<label id="Label2">Maturity Date<span>*</span></label>
<input type="text" name="dateOfMaturity"  class="calDate" id="dateOfMaturityId" value="" validate="Maturity date,date,yes" onChange="startEndDateValidate()"/>

<script>

document.getElementById('dateOfMaturityId').value = '<%=maturityDate%>'
	
	function startEndDateValidate(){
	var day1, day2;
	var month1, month2;
	var year1, year2;
	var starDate = document.getElementById('issueDateId').value;
	var endDate = document.getElementById('dateOfMaturityId').value;
	
	var sDate= document.getElementById('Label1').innerText.replace(/\*/g, ' ');
	var lDate= document.getElementById('Label2').innerText.replace(/\*/g, ' '); 
	
	
	day1 = starDate.substring (0, starDate.indexOf ("/"));
	month1 = starDate.substring (starDate.indexOf ("/")+1, starDate.lastIndexOf ("/"));
	year1 = starDate.substring (starDate.lastIndexOf ("/")+1, starDate.length);

	day2 = endDate.substring (0, endDate.indexOf ("/"));
	month2 = endDate.substring (endDate.indexOf ("/")+1, endDate.lastIndexOf ("/"));
	year2 = endDate.substring (endDate.lastIndexOf ("/")+1, endDate.length); 


	var chDate1 = new Date(year1, month1, day1); 
	var chDate2 = new Date(year2, month2, day2); 

	/* var date1 = year1+"/"+month1+"/"+day1;
	var date2 = year2+"/"+month2+"/"+day2; */

	/* var firstDate = Date.parse(date1);
	var secondDate= Date.parse(date2); */
	
	
	var timeDiff = Math.abs(chDate2.getTime() - chDate1.getTime());
	var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24)); 
	document.getElementById("noOfDaysId").value=diffDays;
	/*  document.getElementById("noOfDaysId").value=diffDays;*/
	<%--var diffDays = date1.getDate() - date2.getDate(); 
	alert(diffDays);--%>
	if(chDate2 < chDate1) 
	{ 
		
	alert(lDate+" cannot less than "+sDate);
	
	document.getElementById("noOfDaysId").value="";
	document.getElementById('dateOfMaturityId').value="";
	return false; 
	
	}
	}
	
	function disableSubmit(){
	 document.getElementById('addbutton').style.display = 'none';
	 document.getElementById('editbutton').style.display = 'inline';
	}
	
	function editRowRecord(val){
		var xmlHttp;
		try {
		  // Firefox, Opera 8.0+, Safari
		  xmlHttp=new XMLHttpRequest();
		}catch (e){
		  // Internet Explorer
		  try{
		    xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		  }catch (e){
		  	alert(e);
		    try{
		      xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		    }catch (e){
		      alert("Your browser does not support AJAX!");
		      return false;
		    }
		   }
		 }
		xmlHttp.onreadystatechange=function()
	    {
			if(xmlHttp.readyState==4){
		         document.getElementById("fixedDiv").innerHTML = xmlHttp.responseText;
		      }
	    };
		 	var url = 'account?method=editFixedDepositRegister&fdRegisterId='+val;
			 url = url+'&'+tokenName+'='+tokenValue;
		     xmlHttp.open("POST",url,true);
		     xmlHttp.setRequestHeader("Content-Type", "text/xml");
		     xmlHttp.send(null);
	}
	
</script>

<div class="clear"></div>
<label>Amount<span>*</span></label>
<input type="text" name="amount" id="amountId"  value="" validate="Amount,folat,yes" />
<script>document.getElementById('amountId').value = '<%=amount%>'</script>
<label>Rate of Interest<span>*</span></label>
<input type="text" name="rateOfInterst" id="rateOfInterstId"  value=""  validate="Rate of Interst,float,yes"/>
<script>document.getElementById('rateOfInterstId').value = '<%=rateOfInterst%>'</script>
<div class="clear"></div>
<label>No. of Days<span>*</span></label>
<input type="text" name="noOfDays" id="noOfDaysId"  value="" validate="No. of Days,int,yes" readonly/>
<script>document.getElementById('noOfDaysId').value = '<%=days%>'</script>
<label>Remarks</label>
<input type="text" name="remarks" id="remarksId" value="" />
<script>document.getElementById('remarksId').value ='<%=remarks%>'</script>
<div class="clear"></div>
</div>
</div>
<table>
<tr>
		<th scope="col">Bank</th>
		<th scope="col">FDR No.</th>
		<th scope="col">Issue Date</th>
		<th scope="col">Maturity Date</th>
		<th scope="col">Amount</th>
		<th scope="col">Rate of Interest</th>
		<th scope="col">Days</th>
	</tr>
	<%
	if(fdRegisterList.size()>0){
		for(FaMasFdRegister fdRegister : fdRegisterList){
	
	
	%>
	<tr  onclick="editRowRecord(<%=fdRegister.getId()%>);disableSubmit();">
	
	<%
		for(MasBankMaster masBankMaster : bankList){
			
		if(fdRegister.getBank().getId().equals(masBankMaster.getId())){
			
		%>
	
	<td><%=masBankMaster.getBankName() %></td>
	<%}} %>
	<td><%=fdRegister.getFdrNo()!= null?fdRegister.getFdrNo():""  %></td>
	<td><%=fdRegister.getDateOfIssue() != null?HMSUtil.convertDateToStringWithoutTime(fdRegister.getDateOfIssue()):"" %></td>
	<td><%=fdRegister.getDateOfMaturity() != null?HMSUtil.convertDateToStringWithoutTime(fdRegister.getDateOfMaturity()):"" %></td>
	<td><%=fdRegister.getAmount() != null?fdRegister.getAmount():"" %></td>
	<td><%=fdRegister.getRateOfInterest()!= null?fdRegister.getRateOfInterest():"" %></td>
	<td><%=fdRegister.getNoOfDays()!=null?fdRegister.getNoOfDays():"" %></td>
	
	</tr>

<%}} %>
</table>
<div class="clear"></div>
<div class="paddingTop5"></div>
<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('fdRegister','account?method=submitFixedDepositRegister');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" style="display:none" class="button" onClick="submitForm('fdRegister','account?method=updateFixedDepositRegister');" accesskey="a" tabindex=1 />
<input type="reset" name="Reset" id="reset"  value="Reset" class="button" onClick="submitFormForButton('fdRegister','account?method=showFixedDepositRegisterJsp');" accesskey="r" />
<input type="button" name="Report" value="Generate Report" class="buttonBig" onclick="submitFormForButton('fdRegister','account?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="fixedDeposits"/>



<div class="clear"></div>
<div class="clear"></div>




</form>