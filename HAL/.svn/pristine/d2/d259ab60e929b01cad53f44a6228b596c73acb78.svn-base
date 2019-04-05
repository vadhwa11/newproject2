<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * modifyBalance.jsp  
 * Purpose of the JSP -  This is for indentBD.
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>


<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreBalanceM"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>

<%@page import="java.util.StringTokenizer"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.StoreBalanceT"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script>
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year1=calendar.get(calendar.YEAR);
		if(month1.length()<2){
			month1="0"+month1;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
			
	%>
		serverdate = '<%=date1+"/"+month1+"/"+year1%>'
	</script>
<%
	StringBuffer orderDateOnly = new StringBuffer();
	GregorianCalendar gregorianCalendar1 = new GregorianCalendar();

	int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
	if (dateOfMonth < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(dateOfMonth);
	} else {
		orderDateOnly.append(dateOfMonth);
	}

	orderDateOnly.append("/");

	int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (month < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(month);
	} else {
		orderDateOnly.append(month);
	}

	orderDateOnly.append("/");
	int year = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year);
	String currentDate = new String(orderDateOnly);
%>
<%
	Map map = new HashMap();
	String includedJsp = null;
	String previousPage = "no";
	int pageNo = 1;
	String noDetailRecords = "no";
	List<StoreBalanceM> searchStoreBalanceMList = new ArrayList<StoreBalanceM>();
	List<StoreBalanceM> gridIndentMList = new ArrayList<StoreBalanceM>();
	List<StoreBalanceT> gridIndentTList = new ArrayList<StoreBalanceT>();
	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
	List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();

	String maxBalanceNo = "";
	String date = "";
	String time = "";
	String userName = "";
	List objectList = new ArrayList();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	date = (String) utilMap.get("currentDate");
	time = (String) utilMap.get("currentTime");
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	//--------Hearder Variables-------
	String balanceNo = "";
	int balanceId = 0;
	String balanceDate = "";
	int approvedByEmployeeId = 0;
	int totalPages = 0;
	//--------End -------- Hearder Variables-------

	if (request.getAttribute("map") != null)
		map = (Map) request.getAttribute("map");

	if (map.get("balanceNo") != null)
		balanceNo = "" + map.get("balanceNo");

	if (map.get("balanceId") != null)
		balanceId = Integer.parseInt("" + map.get("balanceId"));

	if (map.get("balanceDate") != null)
		balanceDate = "" + map.get("balanceDate");

	if (map.get("approvedByEmployeeId") != null)
		approvedByEmployeeId = Integer.parseInt(""
				+ map.get("approvedByEmployeeId"));

	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt("" + map.get("pageNo"));
	}
	if (map.get("max") != null)
		maxBalanceNo = ("" + map.get("max"));

	if (map.get("approvedByEmployeeList") != null)
		approvedByEmployeeList = (List) map.get("approvedByEmployeeList");

	if (map.get("objectList") != null)
		objectList = (List) map.get("objectList");

	if (map.get("brandList") != null)
		brandList = (List) map.get("brandList");

	if (map.get("approvedByEmployeeList") != null)
		approvedByEmployeeList = (List) map.get("approvedByEmployeeList");

	if (map.get("searchStoreBalanceMList") != null)
		searchStoreBalanceMList = (List) map.get("searchStoreBalanceMList");

	if (map.get("gridIndentMList") != null)
		gridIndentMList = (List) map.get("gridIndentMList");

	
	boolean check= false;
	if (gridIndentMList != null && gridIndentMList.size() > 0){
		StoreBalanceM storeBalanceM = (StoreBalanceM) gridIndentMList.get(0);
		if(storeBalanceM.getStatus()!= null && storeBalanceM.getStatus() != "o"){
			if(storeBalanceM.getStatus().equals("p")){
				check = true;
			}
		}
	}
	
	if (map.get("gridIndentTList") != null)
		gridIndentTList = (List) map.get("gridIndentTList");

	if (map.get("noDetailRecords") != null) {
		noDetailRecords = ("" + map.get("noDetailRecords"));

	}
	if (map.get("totalPages") != null) {
		totalPages = Integer.parseInt("" + map.get("totalPages"));

	}
%>

<script type="text/javascript">

  
 function checkForIndentToDepot(val,a,inc){
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*10)+1;
    	var end=((pageNo-1)*10)+10;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    for(i=start;i<=end;i++){
	    if(pvms !="")
	    if(document.getElementById('codeItem'+i).value==pvms){
	    if(document.getElementById('codeItem'+inc).value!=pvms){
	    	alert("Item already selected...!")
	    	document.getElementById('nameItem'+inc).value=""
	    	
	    	return false;
	    	}
	    }}
		ajaxFunctionForAutoAA('indentGrid','stores?method=fillItemsForIndentToSOC&pvmsNo=' +  pvms , inc);
}
 function checkForIndentToDepotPvsm(val,a,inc){

		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*10)+1;
    	var end=((pageNo-1)*10)+10;
    		  
	    var pvms = val;
	    for(i=start;i<=end;i++){
	    if(pvms !="")
	    if(document.getElementById('codeItem'+i).value==pvms){
	    if(document.getElementById('codeItem'+inc).value!=pvms){
	    	alert("Item already selected...!")
	    	document.getElementById('nameItem'+inc).value=""
	    	
	    	return false;
	    	}
	    }}	  
		ajaxFunctionForAutoAA('indentGrid','stores?method=fillItemsForIndentToPvsm&pvmsNo=' +  pvms , inc);
}
  

function fillSrNo(rowVal){

	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%10
   		if(rowVal==0){
   			rowVal=10
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	return true;
}


  function fillValuesBalance(inc)
  {
    	
    	var batchNoVar="batchNoVar";
    	var batchNoVarTemp="batchNoVarTemp";
    	
    	
    	var expDateVar="expDateVar";
    	var expDateVarTemp="expDateVarTemp";
    	
    	
    	var qtyVar="qtyVar";
    	var qtyVarTemp="qtyVarTemp";
    	
    	var unitRateVar="unitRateVar";
    	var unitRateVarTemp="unitRateVarTemp";
    	
     	   	
    if(document.getElementById(batchNoVarTemp+inc).value!=""){
      		document.getElementById(batchNoVar+inc).value=document.getElementById(batchNoVarTemp+inc).value
     }
     else{
      		document.getElementById(batchNoVar+inc).value="emptyString";
     }
      
         if(document.getElementById(expDateVarTemp+inc).value!=""){
      		document.getElementById(expDateVar+inc).value=document.getElementById(expDateVarTemp+inc).value
     }
     else{
      		document.getElementById(expDateVar+inc).value="emptyString";
     }
       if(document.getElementById(qtyVarTemp+inc).value!=""){
      		document.getElementById(qtyVar+inc).value=document.getElementById(qtyVarTemp+inc).value
     }
     else{
      		document.getElementById(qtyVar+inc).value="0";
      }		
      
      if(document.getElementById(unitRateVarTemp+inc).value!=""){
      		document.getElementById(unitRateVar+inc).value=document.getElementById(unitRateVarTemp+inc).value
      		
     }
     else{
      		document.getElementById(unitRateVar+inc).value="0";
      }
     
     
    
  }

 function validateDateSOC( strValue ) {
  var objRegExp = /^\d{1,2}(\/)\d{1,2}\1\d{4}$/

  if(!objRegExp.test(strValue))
    return false; 
  else{
    var strSeparator = strValue.substring(2,3) 

    var arrayDate = strValue.split(strSeparator); 
    var arrayLookup = { '01' : 31,'03' : 31, '04' : 30,'05' : 31,'06' : 30,'07' : 31,
                        '08' : 31,'09' : 30,'10' : 31,'11' : 30,'12' : 31}
var intDay = parseInt(arrayDate[0],10);


    if(arrayLookup[arrayDate[1]] != null) {
      if(intDay <= arrayLookup[arrayDate[1]] && intDay != 0)
        return true; 
    }
var intMonth = parseInt(arrayDate[1], 10);

    if (intMonth == 2) { 
       var intYear = parseInt(arrayDate[2]);
       if( ((intYear % 4 == 0 && intDay <= 29) || (intYear % 4 != 0 && intDay <=28)) && intDay !=0)
          return true;
       }
  }
  return false; 
}
 function fillDate(inc)
  {
  if(validateDateSOC(document.getElementById('expDateVarTemp'+inc).value)){
  }else{
  document.getElementById('expDateVarTemp'+inc).value=""
  	alert("Invalid Date..!")
  	return false
  }
   	if(document.getElementById('expDateVarTemp'+inc).value!=""){
    	document.getElementById('expDateVar'+inc).value=document.getElementById('expDateVarTemp'+inc).value
    	}
  }

function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=printOpeningBalanceJsp";
  obj.submit();
}

function validateItem(formName)
{
 if(confirm("Are you Sure, you want to Validate ?")){
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=validateBalanceJsp";
  obj.submit();
  return true;
  }else{ 
  return false;
  }
  
  
}

function deleteItem(formName){

  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=deleteOpeningBalanceItemJsp";
  obj.submit();
}

function checkForOPBalanceGrid()
 {
 
 var pageNo = document.getElementById('pageNo').value
 var start=((pageNo-1)*10)+1;
 var end=((pageNo-1)*10)+10;
     for(i=start;i<=end;i++)
	    {
		   if(document.getElementById('codeItem'+i) != null){
		    var pvms = document.getElementById('codeItem'+i).value;
		   
		    if(pvms !="")
		    {

			    if (document.getElementById('brandId'+i).value=="" || document.getElementById('brandId'+i).value == 0)
			    { 
			    alert('Pl. Check Brand in Row No:' + i);
			    document.getElementById('brandId'+i).focus();
			    return false;
			    }
			    
			    if (document.getElementById('manuId'+i).value=="" || document.getElementById('manuId'+i).value== 0)
			    { 
			    alert('Pl. Check Manufacturer in Row No:' + i);
			    document.getElementById('manuId'+i).focus();
			    return false;
			    }
		
				
		   		if (document.getElementById('batchNoVarTemp'+i).value=="")
			    { 
			    alert('Pl. Check Batch No in Row No:' + i);
			    document.getElementById('batchNoVarTemp'+i).focus();
			    return false;
			    } 
				
			    if (document.getElementById('qtyVarTemp'+i).value=="" || isNaN(document.getElementById('qtyVarTemp'+i).value))
			    { 
			    alert('Pl. Check Quantity in Row No:' + i);
			    document.getElementById('qtyVarTemp'+i).focus();
			    return false;
			    }
			    
			  	    
			  
			    
			    if (document.getElementById('unitRateVarTemp'+i).value=="" || isNaN(document.getElementById('unitRateVarTemp'+i).value))
			    { 
			    alert('Pl. Check Unit Rate in Row No:' + i);
			    document.getElementById('unitRateVarTemp'+i).focus();
			    return false;
			    }
			    
			   	if (document.getElementById('expDateVarTemp'+i).value=="")
			    	{
			    	  alert('Expiry Date in Row No:' + i + ' is Mandatory!..');
			    	  document.getElementById('expDateVarTemp'+i).focus();
			    	  return false;
			    }
			    	
					var strValue = document.getElementById('expDateVarTemp'+i).value;
				    dateOfJoining = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
				 	currentDate = new Date();
					var month = currentDate.getMonth() + 1
					var day = currentDate.getDate()
					var year = currentDate.getFullYear()
					var seperator = "/"
					currentDate = new Date(month + seperator + day + seperator + year);
					if(dateOfJoining < currentDate)
				 	{
						alert('Expiry Date is Not Valid in Row No: ' + i );
						//document.getElementById('expDateVarTemp'+i).value = ""
						//document.getElementById('expDateVar'+i).value = ""
						return false;
				 	}
			    }	
		    }
		 }
	    return true;
}

 </script>
<div id="searchBlock" style="display:none;">
<form name="departmentIndent" method="post">

<div class="clear"></div>
<h6>SEARCH</h6>
<div class="Block">
<form name="" method="">
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> 
<input type="hidden" name="do" value="process" /> 
<input type="hidden" name="searchthread" value="1" /> 
<input type="hidden" name="showposts" value="1" /> 
<input type="hidden" name="searchthreadid" value="85875" />  
<label>From Date </label> 
<input type="text" name="<%= FROM_DATE %>"	 MAXLENGTH="30" tabindex=1 />
<img id="calendar"  src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
				          onClick="setdate('<%=currentDate%>',document.departmentIndent.<%= FROM_DATE%>,event)" />

<label >To Date </label> 
<input type="text" name="<%= TO_DATE %>" MAXLENGTH="30"  tabindex=1 />
 <img id="calendar"  src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
				 onClick="setdate('<%=currentDate%>',document.departmentIndent.<%= TO_DATE%>,event)" />
<div class="clear"></div>				 
<label >Opening Balance No.</label> 
<select name="<%= SEARCH_BALANCE_NO%>">
				   <option value="0">Select</option>
				  <%
					for (StoreBalanceM storeBalanceM :searchStoreBalanceMList ) {
				  %>
				   <option value=<%=storeBalanceM.getBalanceNo()%>><%=storeBalanceM.getBalanceNo()%></option>
	 			  <%
					}
			      %>
			     </select>
			     
			     
			
			 <input type="button" name="sss" class="button" value="SEARCH" onClick="submitForm('departmentIndent','stores?method=searchBalance');" />
		
</form>
</div>
</form>
</div>

<div class="Clear"></div>
<h6>Opening Balance Entry</h6>
<div class="Clear"></div>
<form name="indentGrid" method="post">
<div id="testDiv">
<div class="Block">
<% 
	String validate = "Opening Balance Validation done";
	     if(check){ 
	%>
<%} %>



<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" />
 <input	name="<%=NO_DETAIL_RECORDS %>" type="hidden" value="<%=noDetailRecords %>" /> 
 
 <%
	for (StoreBalanceM storeBalanceM : gridIndentMList) {
				%> 
<label>Opening Balance No.<span>*</span></label>
 <input type="text" name="<%=BALANCE_NO %>" tabindex=1	value="<%=storeBalanceM.getBalanceNo()%>" readonly="readonly"
	 MAXLENGTH="8"/  >
 <input type="hidden" name="tempRadioValue" id="tempRadioValue"	value="<%=storeBalanceM.getId() %>">
 
  <label >Opening Balance Date<span>*</span></label>
  
  <input type="text" name="<%=BALANCE_DATE%>" tabindex=1 readonly="readonly" value="<%=HMSUtil.changeDateToddMMyyyy(storeBalanceM.getBalanceDate())%>"
	 MAXLENGTH="30" />
	 
<label>Approved By<span>*</span></label>
	  
 <select
	name="<%=APPROVED_BY_EMPLOYEE_ID_BALANCE%>" tabindex=1>
	<option value="0">Select</option>
	<%
					String rankName="";
					for (MasEmployee approvedBy : approvedByEmployeeList) {
						if(approvedBy.getRank().getRankName()!="")
						{
							rankName=" - "+approvedBy.getRank().getRankName();
						}
							if (storeBalanceM.getApprovedBy().getId() == approvedBy
									.getId()) {
				%>
	<option value=<%=approvedBy.getId()%> selected="selected"><%=approvedBy.getFirstName()%>
	<%=approvedBy.getLastName()%></option>
	<%
		    		} else {
		    	%>
	<option value="<%=approvedBy.getId()%>"><%=approvedBy.getFirstName()%>
	<%=approvedBy.getLastName()%><%=rankName%></option>
	<%
					}
						}
				%>
</select>

<div class="clear"></div>

 <label>Remarks</label> 
<%
	if(storeBalanceM.getRemarks()!= null){
%>
<textarea value="" name="<%=REMARKS %>" validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" va onkeyup="finalCheck(this)" maxlength="200"><%=storeBalanceM.getRemarks()%></textarea>

	
	<%}else{%>
	<textarea value="" name="<%=REMARKS %>" validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="200"></textarea>
	
	<%}
						}
					%>
					



</div>

<div class="Clear"></div>

	  	   



<inputtype="image" class="button"  name="goToPage" value="Go" onClick="{submitForm('indentGrid','stores?method=modifyBalance&buttonName=next');}"
	class="cmnButton" /> 
<input type="hidden" name="" value="222" id="currentRow" /> <input
	type="hidden" size="2" value="0"
	name="<%=RequestConstants.NO_OF_ROWS %>"
	id="<%=RequestConstants.NO_OF_ROWS %>" /> <input type="hidden"
	name="<%=BALANCE_ID %>" value="<%=balanceId%>" id="balanceId" /> <br />


<h4>Opening Balance details</div>
<div class="Clear"></div>
<div class="cmntable">
<table colspan="7" id="indentDetails" cellpadding="0" cellspacing="0">
	<thead>
<tr>
<th width="5%">Sl. No.</th>
<th width="5%">PVMS/NIV	No.</th>
<th width="10%">Nomenclature</th>
<th width="10%">A/U</th>
<th width="10%">Brand Name</th>
<th width="10%">Manufacturer</th>
<th width="5%">Batch No.</th>
<th width="5%" colspan="2" >Expiry Date</th>
<th width="10%">Qty.</th>
<th width="10%">Unit Rate</th>
<th width="10%">Amount</th>
</tr>
</thead>
	<tbody>
		<%
    		int inc = 1;
    		int detailCounter = 10;
    		int temp = 0;
    		String idItem = "idItem";
    		String codeItem = "codeItem";
    		String nameItem = "nameItem";
    		String idBrand = "idBrand";
    		String nameManufacturer = "nameManufacturer";
    		String idAu = "idAu";
    		String brandId = "brandId";

    		String batchNoVar = "batchNoVar";
    		String expDateVar = "expDateVar";
    		String qtyVar = "qtyVar";
    		String unitRateVar = "unitRateVar";

    		String batchNoVarTemp = "batchNoVarTemp";
    		String expDateVarTemp = "expDateVarTemp";
    		String qtyVarTemp = "qtyVarTemp";
    		String unitRateVarTemp = "unitRateVarTemp";
    		String incVar = "incVar";

    		String brandId2 = "brandId";
    		String idItem2 = "idItem";
    		String codeItem2 = "codeItem";
    		String nameItem2 = "nameItem";
    		String idBrand2 = "idBrand";
    		String nameManufacturer2 = "nameManufacturer";
    		String idAu2 = "idAu";

    		String batchNoVar2 = "batchNoVar";
    		String expDateVar2 = "expDateVar";
    		String qtyVar2 = "qtyVar";
    		String unitRateVar2 = "unitRateVar";
    		String manuId = "manuId";
    		String manuId2 = "manuId";
    		String balanceTId = "balanceTId";
    		String balanceTId2 = "balanceTId";
    		String manuIdTemp = "manuIdTemp";
    		String manuIdTemp2 = "manuIdTemp";
    		String batchNoVarTemp2 = "batchNoVarTemp";
    		String expDateVarTemp2 = "expDateVarTemp";
    		String qtyVarTemp2 = "qtyVarTemp";
    		String unitRateVarTemp2 = "unitRateVarTemp";
    		String incVar2 = "incVar2";
    		String amountVarTemp = "amountVarTemp";
        	String amountVarTemp2 = "amountVarTemp";
        	String amountVar = "amountVar";
        	String amountVar2 = "amountVar";

    		if (pageNo != 1) {
    			inc = ((pageNo - 1) * 10) + 1;
    		}

    		int incTemp2 = inc + 10;
    		for (StoreBalanceT storeBalanceT : gridIndentTList) {

    			if (inc <= incTemp2) {
    				idItem = idItem2 + ("" + inc);
    				codeItem = codeItem2 + ("" + inc);
    				nameItem = nameItem2 + ("" + inc);
    				idBrand = idBrand2 + ("" + inc);
    				nameManufacturer = nameManufacturer2 + ("" + inc);
    				idAu = idAu2 + ("" + inc);
    				batchNoVar = batchNoVar2 + ("" + inc);
    				expDateVar = expDateVar2 + ("" + inc);
    				qtyVar = qtyVar2 + ("" + inc);
    				unitRateVar = unitRateVar2 + ("" + inc);
    				brandId = brandId2 + ("" + inc);
    				manuId = manuId2 + ("" + inc);
    				batchNoVarTemp = batchNoVarTemp2 + ("" + inc);
    				expDateVarTemp = expDateVarTemp2 + ("" + inc);
    				qtyVarTemp = qtyVarTemp2 + ("" + inc);
    				unitRateVarTemp = unitRateVarTemp2 + ("" + inc);
    				incVar = incVar2 + ("" + inc);
    				balanceTId = balanceTId2 + ("" + inc);
    				manuIdTemp = manuIdTemp2 + ("" + inc);
    				
    				amountVarTemp = amountVarTemp2+(""+inc);
    	     		amountVar = amountVar2+(""+inc);
    	%>
		<tr>
			<input type="hidden" name="<%=BALANCE_T_ID %>"	value="<%=storeBalanceT.getId() %>" id="<%=balanceTId %>" />

			<td width="5%">
			<input type="text" size="2"	value="<%=storeBalanceT.getSrNo()%>" name="<%=SR_NO%>" readonly="readonly" />
			</td>
			<td width="5%">
			<input type="text"  name="<%=ITEM_CODE %>" size="8" readonly="readonly" id="<%=codeItem%>"	value="<%=storeBalanceT.getItem().getPvmsNo() %>" /> 
			<input type="hidden" value="<%=storeBalanceT.getItem().getId()%>" name="<%=ITEM_ID%>" id="<%=idItem%>" />
			</td>
            <td width="10%">
            <input type="text" value="<%=storeBalanceT.getItem().getNomenclature() %>"  size="40" tabindex=1 readonly="readonly" id="<%=nameItem%>" onblur="if(fillSrNo(<%=inc%>)){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" />
			<div id="ac2update"	style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForLoanoutByAutocompleteBalance',{parameters:'requiredField=<%=nameItem%>&balanceId='+document.getElementById('balanceId').value});
		    </script>
		    </td>

			<td width="10%">
			<input type="text" size="8" 
				value="<%=storeBalanceT.getItem().getItemConversion().getItemUnitName() %>"
				 readonly="readonly" name="<%=AV%>" id="<%=idAu%>" />
			</td>


			<td width="10%">
			<%
 			if (storeBalanceT.getBrand() != null) {
 		%> <select name="<%=BRAND_ID%>" id="<%=brandId%>">
				<option value="<%=storeBalanceT.getBrand().getId()%>"><%=storeBalanceT.getBrand().getBrandName()%></option>
			</select> <%
	   	} else {
	   %> <select name="<%=BRAND_ID%>" id="<%=brandId%>">
				<option value=""></option>
			</select> <%
	   	}
	   %>
			</td>

			<td width="10%">
			<%
      	if (storeBalanceT.getBrand() != null) {
      %> <select name="<%=MANUFACTURER_ID %>" id=<%=manuId%>
				tabindex="1">
				<option
					value="<%=storeBalanceT.getBrand().getManufacturer().getId()%>"><%=storeBalanceT.getBrand().getManufacturer()
										.getManufacturerName()%></option>
			</select> <%
      	} else {
      %> <select name="<%=MANUFACTURER_ID %>" id=<%=manuId%>
				tabindex="1">
				<option value=""></option>
			</select> <%
      	}
      %>
			</td>
			<td width="5%">
			<%
    	if (storeBalanceT.getBatchNo() != null) {
    %> <input type="text" value="<%=storeBalanceT.getBatchNo() %>"
				name="<%=BATCH%>" id="<%=batchNoVarTemp%>"
				onblur="fillValuesBalance(<%=inc%>); %>);" MAXLENGTH="20" tabindex=1 />
			<input type="hidden" size="2"
				value="<%=storeBalanceT.getBatchNo() %>" name="<%=BATCH_NO%>"
				id="<%=batchNoVar%>" /> <%
    	} else {
    %> <input type="text" value="" tabindex=1 name="<%=BATCH%>"
				 id="<%=batchNoVarTemp%>"
				onblur="fillValuesBalance(<%=inc%>);" validate="Batch No.,string,no"
				maxlength="20" tabindex=1 /> <input type="hidden" size="2"
				value="emptyString" name="<%=BATCH_NO%>" id="<%=batchNoVar%>" />
			<%
		}
	%>
			</td>
			
			<%
    	if (storeBalanceT.getExpiryDate() != null) {
    %> 
    <td width="5%">
    <input type="text"  size="10" value="<%=HMSUtil.changeDateToddMMyyyy(storeBalanceT.getExpiryDate())%>" id="<%=expDateVarTemp%>" readonly
				onblur="fillValuesBalance(<%=inc%>);" tabindex="1" />
				
				 <input	type="hidden" name="<%=RequestConstants.EXPIRY_DATE %>"	value="<%=HMSUtil.changeDateToddMMyyyy(storeBalanceT.getExpiryDate())%>"
				 id="<%=expDateVar%>" tabindex="1" /> 
				 
				 </td>
				<td>
		<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate%>',document.getElementById('<%=expDateVarTemp %>'),event);" />
		
		</td>
			<%
     	} else {
     %>
      <td width="5%">
			<input type="text" id="<%=expDateVarTemp%>" value="" readonly onblur="fillValuesBalance(<%=inc%>);" tabindex="1" />
			 
				<input type="hidden" name="<%=RequestConstants.EXPIRY_DATE %>" value="" id="<%=expDateVar%>" tabindex="1" />
				</td>
				<td>
		<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate%>',document.getElementById('<%=expDateVarTemp %>'),event);" />
		
		</td>
			<%
    	}
    %>
		
			<td width="10%"><input type="text"	size="10" value="<%=storeBalanceT.getQty() %>" maxlength="9" name="<%=QTY_BALANCE_TEMP%>" tabindex="1"
				id="<%=qtyVarTemp%>" validate="Qty,num,no"
				onblur="fillValuesBalance(<%=inc%>);calculateTotalAmount(<%=inc %>)" /> <input type="hidden"
				value="<%=storeBalanceT.getQty() %>" 
				name="<%=QTY_BALANCE%>" tabindex="1" id="<%=qtyVar%>" />
				
			</td>
			<td width="10%">
			<%
    	if (storeBalanceT.getUnitRate() != null) {
    %> <input type="text" size="10" id="<%=unitRateVarTemp%>"
				value="<%=storeBalanceT.getUnitRate() %>" 
				maxlength="9" tabindex="1" validate="Unit Rate,num,no"
				onblur="fillValuesBalance(<%=inc%>);calculateTotalAmount(<%=inc %>)" /> <input type="hidden"
				name="<%=UNIT_RATE_BALANCE%>" id="<%=unitRateVar%>"
				value="<%=storeBalanceT.getUnitRate() %>" 
				tabindex="1" /> <%
    	} else {
    %> <input type="text"  value="" size="10" maxlength="9"
				name="<%=UNIT_RATE_BALANCE_TEMP%>" tabindex="1"
				id="<%=unitRateVarTemp%>" validate="Unit Rate,num,no"
				onblur="fillValuesBalance(<%=inc%>);calculateTotalAmount(<%=inc %>)" /> <input type="hidden"
				value=""  name="<%=UNIT_RATE_BALANCE%>"
				tabindex="1" id="<%=unitRateVar%>" /> <%
    	}
    %>
			</td>
			<td width="3%">
			<%if(storeBalanceT.getTotalAmount() != null ){ %>
      <input type="text" size="10" name="" id="<%=amountVarTemp%>" readonly="readonly"  tabindex="1" value="<%=storeBalanceT.getTotalAmount() %>"/>
      <input type="hidden"  value="<%=storeBalanceT.getTotalAmount() %>" name="<%=AMOUNT%>"  id="<%=amountVar%>"/>
      <%}else{ %>
        <input type="text" size="10" name="" id="<%=amountVarTemp%>" readonly="readonly"  tabindex="1" value="0" />
      <input type="hidden"  value="0" name="<%=AMOUNT%>"  id="<%=amountVar%>"/>
      <%} %>
      </td>
			<!--<td width="6%"> <input type="checkbox"
				name=<%=ITEMS_TO_BE_DELETED%> value="<%=storeBalanceT.getId()%>"> </td>-->
		</tr>
		<%
              	inc++;
              		}
              	}
              %>
		<script>
	    	 document.indentGrid.noOfRows.value=<%=inc-((pageNo-1)*10)-1%>
	    	 </script>

		<%
       			if (inc < incTemp2) {
       				for (; inc < incTemp2; inc++) {

       					idItem = idItem2 + ("" + inc);
       					codeItem = codeItem2 + ("" + inc);
       					nameItem = nameItem2 + ("" + inc);
       					idBrand = idBrand2 + ("" + inc);
       					nameManufacturer = nameManufacturer2 + ("" + inc);
       					idAu = idAu2 + ("" + inc);
       					batchNoVar = batchNoVar2 + ("" + inc);
       					expDateVar = expDateVar2 + ("" + inc);
       					qtyVar = qtyVar2 + ("" + inc);
       					unitRateVar = unitRateVar2 + ("" + inc);
       					brandId = brandId2 + ("" + inc);
       					manuId = manuId2 + ("" + inc);
       					batchNoVarTemp = batchNoVarTemp2 + ("" + inc);
       					expDateVarTemp = expDateVarTemp2 + ("" + inc);
       					qtyVarTemp = qtyVarTemp2 + ("" + inc);
       					unitRateVarTemp = unitRateVarTemp2 + ("" + inc);
       					incVar = incVar2 + ("" + inc);
       					balanceTId = balanceTId2 + ("" + inc);
       					manuIdTemp = manuIdTemp2 + ("" + inc);
       		%>
       		<tr>
		<td width="5%">
		<input type="text" size="2" value="<%=temp+inc%>"
			 name="<%=SR_NO%>" readonly="readonly" /></td>

		<td width="5%">
		<!--<input type="text" class="medcaption" name="<%=codeItem %>"  id="<%=codeItem%>" onblur="checkForIndentToDepotPvsm(this.value, '<%=codeItem%>','<%=inc %>');" />-->
		<input type="text" size="8"  value="" id="<%=codeItem%>" 
			onblur="checkForIndentToDepotPvsm(this.value, '<%=codeItem%>','<%=inc %>');"
			name="<%=codeItem%>" tabindex=1 /> <input type="hidden" value="0"
			class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem%>" />
			
		</td>

		<td width="10%">
		
		<input type="text" value="" size="40" id="<%=nameItem%>" onblur="if(fillSrNo(<%=inc %>)){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=inc %>');}"
			name="<%=nameItem%>" tabindex=1 />
		<div id="ac2update"
			style="display: none; padding-right: 550px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForLoanoutByAutocompleteBalance',{parameters:'requiredField=<%=nameItem%>&balanceId='+document.getElementById('balanceId').value});
		</script>
		
		</td>

		<td width="10%">
		<input type="text" value="" size="8" readonly="readonly" name="<%=AV%>" id="<%=idAu%>"
			validate="A/U ,String,no" />
			
		</td>
		
		<td width="10%">
		<select name="<%=RequestConstants.BRAND_ID%>"
			id="<%=brandId%>" onchange="" tabindex=1>
			<option value="0">Select</option>
		</select></td>
		<td width="10%"><select
			name="<%=RequestConstants.MANUFACTURER_ID%>" id="<%=manuId%>"
			onchange="" tabindex=1>
			<option value="0">Select</option>
		</select></td>


		<td width="5%">
		<input type="text" value="" tabindex=1
			name="<%=BATCH%>" id="<%=batchNoVarTemp%>"
			onblur="fillValuesBalance(<%=inc%>);" validate="Batch No.,string,no"
			maxlength="20" tabindex=1 /> <input type="hidden" size="2"
			value="emptyString" name="<%=BATCH_NO%>" id="<%=batchNoVar%>" />
			
		</td>
		
		<td width="5%">
		
			<input type="text" id="<%=expDateVarTemp%>"size="10"   value="" readonly onblur="fillValuesBalance(<%=inc%>);" tabindex="1" /> 
			
			
			</td>
		<td>
		<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate%>',document.getElementById('<%=expDateVarTemp %>'),event);" />
		<input type="hidden" value="<%=date%>" 	name="<%=RequestConstants.EXPIRY_DATE %>" id="<%=expDateVar %>" />
		</td>
		
		<td width="10%">
		<input type="text" value="" size="10" name="<%=QTY_BALANCE_TEMP%>" maxlength="9" tabindex="1"
			id="<%=qtyVarTemp%>" validate="Qty,num,no"	onblur="fillValuesBalance(<%=inc%>);calculateTotalAmount(<%=inc %>)" tabindex=1 /> 
		<input	type="hidden" value="0" class="medcaption" name="<%=QTY_BALANCE%>"	tabindex="2" id="<%=qtyVar%>" />
		</td>
		<td width="10%">
		<input type="text" value="" size="10" 	name="<%=UNIT_RATE_BALANCE_TEMP%>" maxlength="9" tabindex="1"
			id="<%=unitRateVarTemp%>" validate="unit Rate,num,no" onblur="fillValuesBalance(<%=inc%>);calculateTotalAmount(<%=inc %>)" /> 
		<input type="hidden" value="0" class="medcaption" name="<%=UNIT_RATE_BALANCE%>" tabindex="2" id="<%=unitRateVar%>" />
		</td>
<td width="3%">
      <input type="text"size="10" value="" name="" id="<%=amountVarTemp%>" readonly="readonly"  tabindex="1"/>
      <input type="hidden" class="medcaption" value="" name="<%=AMOUNT%>"  id="<%=amountVar%>"/>
      </td>
		<!--<td width="6%"> 
      <input type="checkbox" name=<%=ITEMS_TO_BE_DELETED%> disabled value=""> </td>-->

		</tr>


		<%
              	}
              	}
              %>

	</tbody>

</table>
</div>


<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
  <%if(!check){ %> 
<input type="button" class="button"	value="Next" onclick="if(checkForOPBalanceGrid() && checkSave()&& checkForNext()){submitForm('departmentIndentGrid','stores?method=updateNextOrSubmitBalance&buttonName=next');}"	align="right" />
<input type="button" name="sss" class="button" value="Submit" onclick="if(checkForOPBalanceGrid() && checkSave()&&checkForSubmit()){submitForm('departmentIndentGrid','stores?method=updateNextOrSubmitBalance&buttonName=submit');}" />
<%} %>
<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" />
<label class="noWidth">Page No:</label>
<label class="valueNoWidth"><%=pageNo%></label>
<div id="contentHolder">
<div class="Clear"></div>
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label>

<div class="Clear"></div>
</div>
</div>
</div>
</br>

</form>
<script type="text/javascript">
function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
}
function calculateTotalAmount(rowVal){
	var quantity = parseFloat(document.getElementById('qtyVarTemp'+rowVal).value)
	var unitRate = parseFloat(document.getElementById('unitRateVarTemp'+rowVal).value)
	var total;
	if(!isNaN(quantity) && !isNaN(unitRate)){
		total = quantity*unitRate;
	document.getElementById('amountVarTemp'+rowVal).value=roundVal(total,2);
	document.getElementById('amountVar'+rowVal).value=roundVal(total,2);
	}
}
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" />

</form>

</div>
