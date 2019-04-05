<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * storeBalance.jsp
 * Purpose of the JSP -  This is for indentBD.
 * Revision Date:
 * Revision By:
 * @version 1.4
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreBalanceM"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%--For AutoComplete Through Ajax--%>

<%@page import="jkt.hms.masters.business.MasDepartment"%><script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/stores.js"></script>

<script type="text/javascript"><!--
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
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int pageNo=1;
	List<StoreBalanceM> searchStoreBalanceMList = new ArrayList<StoreBalanceM>();
	List<MasStoreGroup> storeGroupList = new ArrayList<MasStoreGroup>();
	List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
	List<MasStoreSection>sectionList = new ArrayList<MasStoreSection>();
	List<MasItemCategory>categoryList = new ArrayList<MasItemCategory>();
	List<MasItemClass> itemClassList = new ArrayList<MasItemClass>();
	List<Object[]> rcList = new ArrayList<Object[]>();
	String maxBalanceNo="";
	//--------Hearder Variables-------
	int balanceId=0;
	//--------End -------- Hearder Variables-------
	if (request.getAttribute("map") != null)
		map = (Map<String,Object>) request.getAttribute("map");
	if(map.get("balanceId")!=null)
		balanceId= Integer.parseInt(""+map.get("balanceId")) ;
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}
	if(map.get("max")!=null)
		maxBalanceNo=(""+map.get("max"));
	if(map.get("searchStoreBalanceMList")!=null)
	searchStoreBalanceMList = (List) map.get("searchStoreBalanceMList");
	List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("approvedByList") != null)
		approvedByEmployeeList = (ArrayList) map.get("approvedByList");
	List<MasManufacturer> manufacturerList =new ArrayList<MasManufacturer>();
	if(map.get("manufacturerList") != null)
		manufacturerList = (ArrayList) map.get("manufacturerList");
	String balanceNo = "";
	Date balanceDate = new Date();
	int approvedById =0 ;
	String remarks = "";
	if(map.get("balanceNo")!=null)
		balanceNo= (String)map.get("balanceNo");

	if(map.get("balanceDate")!=null)
		balanceDate= (Date)map.get("balanceDate");

	if(map.get("approvedByEmployeeId")!=null)
		approvedById= (Integer)map.get("approvedByEmployeeId");

	if(map.get("remarks")!=null)
		remarks= (String)map.get("remarks");
	
	if(map.get("storeGroupList") != null){
		storeGroupList = (List<MasStoreGroup>)map.get("storeGroupList");
	}
	if(map.get("itemTypeList") != null){
		itemTypeList = (List<MasItemType>)map.get("itemTypeList");
	}
	if(map.get("categoryList") != null){
		categoryList = (List<MasItemCategory>)map.get("categoryList");
	}
	if(map.get("itemClassList") != null){
		itemClassList =(List<MasItemClass>)map.get("itemClassList");
	}
	if(map.get("sectionList") != null){
		sectionList = (List<MasStoreSection>)map.get("sectionList");
	}
	if(map.get("rcList") != null){
		rcList = (List<Object[]>)map.get("rcList");
	}
	System.out.println("Size--->"+rcList.size());
	Object [][]obj=null;
	if(map.get("obj")!=null){
		obj=(Object[][])map.get("obj");
	}
	String msg = "";
	if(map.get("msg") != null){
		msg = (String)map.get("msg");
	}
	
	if(msg != null){%>
	<h4><span><%=msg %></span></h4>
		
	<% }
%>



<script type="text/javascript">


  function checkForIndentToDepot(val,a,inc){
		var pageNo =parseInt(document.getElementById('pageNo').value)
		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;

	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	   // for(i=1;i<=8;i++){
	    //if(pvms !="")
	    //if(document.getElementById('codeItem'+i).value==pvms){
	    //if(document.getElementById('codeItem'+inc).value!=pvms){
	    	//alert("Item already selected...!")
	    	//document.getElementById('nameItem'+inc).value=""

	    	//return false;
	    	//}
	    //}}
	    if(pvms !=""){
			ajaxFunctionForAutoAA('departmentIndent','stores?method=fillItemsForIndentToSOC&pvmsNo=' +  encodeURIComponent(pvms) , inc);
			}else{
				document.getElementById("nameItem"+inc).value = "";
				//document.getElementById("mrp"+inc).value = "";
				//document.getElementById("dispensingPrice"+inc).value = "";
				document.getElementById("batchNoVarTemp"+inc).value = "";
				document.getElementById("expDateVarTemp"+inc).value = "";
				document.getElementById("qtyVarTemp"+inc).value = "";
				document.getElementById("unitRateVarTemp"+inc).value = "";
				document.getElementById("codeItem"+inc).value = "";
				document.getElementById("manuId"+inc).value = "";
				document.getElementById("idAu"+inc).value = "";
				document.getElementById("noOfRows").value = parseInt(document.getElementById("noOfRows").value)-1;

			}
}
  function checkBeforeSubmit(inc){
   var itemName=document.getElementById("nameItem"+inc).value
     var idAu=document.getElementById("idAu"+inc).value
     var batchNoVarTemp=document.getElementById("batchNoVarTemp"+inc).value
      var expDateVarTemp=document.getElementById("expDateVarTemp"+inc).value
   var qtyVarTemp=document.getElementById("qtyVarTemp"+inc).value
     var unitRateVarTemp=document.getElementById("unitRateVarTemp"+inc).value
     var amountVarTemp=document.getElementById("amountVarTemp"+inc).value
     if(itemName==""){
     alert("pls fill Item Name... for row  "+inc);
     return false;
     }
      if(batchNoVarTemp==""){
     alert("pls fill Batch No..for row  "+inc);
     return false;
     }
    /*  if(expDateVarTemp==""){
     alert("pls fill expiry Date.. for row  "+inc);
     return false;
     } */
     if(qtyVarTemp==""){
     alert("pls fill qnty.. for row  "+inc);
     return false;
     }
     if(unitRateVarTemp==""){
     alert("pls fill Unit Rate.. for row  "+inc);
     return false;
     }
     if(amountVarTemp==""){
         alert("pls fill Amount.. for row  "+inc);
         return false;
         }
  }
  
  function ajaxFunctionForAutoAA(formName,action,rowVal) {
	  var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
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
	      
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	   //   	var brandId="brandId"+rowVal;
		//	obj =document.getElementById(brandId); 
		//	obj.length = 1;
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		        var name  = item.getElementsByTagName("name")[0];
		        //var manufacturerName=item.getElementsByTagName("manufacturerName")[0];
		       // var manufacturerId=item.getElementsByTagName("manufacturerId")[0];
		       var costPrice=item.getElementsByTagName("costPrice")[0];
		      
		       var expiry=item.getElementsByTagName("expiry")[0];
		       // var brandLength  = item.getElementsByTagName("brands")[0];
		      // var obj= document.getElementById('manuId'+rowVal);
		      // obj.length=1;
		      // obj.options[ obj.length-1].value = manufacturerId.childNodes[0].nodeValue;
		       // obj.options[ obj.length-1].text = manufacturerName.childNodes[0].nodeValue;
	        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
	        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
	        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
	        	document.getElementById('unitRateVarTemp'+rowVal).value = costPrice.childNodes[0].nodeValue
	        	 
	        	var expiryFlag = expiry.childNodes[0].nodeValue;
	        	if(expiryFlag == "y"){
	        		
	        		document.getElementById('expDateVarTemp'+rowVal).setAttribute('validate','Expiry Date'+rowVal+',date,yes');
	        	}else{
	        		
	        		document.getElementById('expDateVarTemp'+rowVal).setAttribute('validate','Expiry Date,date,no');
	        	}
	        	/*for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++){
	        	//	var brand = brandLength.childNodes[innerLoop];
		        	var brandId  = brand.getElementsByTagName("brandId")[0];
		        	var brandName  = brand.getElementsByTagName("brandName")[0];
		        	obj.length++;
					obj.options[obj.length-1].value=brandId.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=brandName.childNodes[0].nodeValue;
		        	
	        	}*/
	      	} 
	      }
	    }
	   // var url=action+"&"+getNameAndData(formName)
	    var url=action;
	 	//url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	 	url = url;
	     
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	    
	  }
  
  function checkForBalance(val,a,inc){
		var pageNo =parseInt(document.getElementById('pageNo').value)
		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;

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
		ajaxFunctionForAutoCompleteInBalance('departmentIndent','stores?method=fillItemsForBalance&pvmsNo=' + pvms ,inc);
}
	function checkBatchNo(val,inc,itemId){


		var pageNo =parseInt(document.getElementById('pageNo').value)

		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;

        for(i=start;i<=end;i++){
			var itemName = document.getElementById("nameItem"+i).value;

         	var index1 = itemName.lastIndexOf("[");
	    	var index2 = itemName.lastIndexOf("]");
	    	index1++;
	    	var pvms = itemName.substring(index1,index2);
	    	  if(i != inc){
		     	if(pvms !=""){
		     	   		if(document.getElementById('codeItem'+inc).value==pvms && document.getElementById('batchNoVarTemp'+i).value == val){
				    		alert("Batch No already entered for this item...!")
				    		document.getElementById('nameItem'+inc).value=""
				    		document.getElementById('batchNoVarTemp'+i).value = ""
				    		return false;
		   			}
		   		}
		   	}
		}
   }


function fillSrNo(rowVal){
	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%8
   		if(rowVal==0){
   			rowVal=8
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	return true;
}

function test(){
	var errorMessage="";
	formName="departmentIndent"
	obj = eval('document.'+formName)
	if(document.getElementById('approvedBy').value == 0)
		errorMessage=errorMessage+"Please Select Approved By  \n";



	if((document.getElementById('approvedBy').value != 0)){
		return true;
	}else{
		alert(errorMessage)
		return false
	}

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

    	var amountVar="amountVar";
    	var amountVarTemp="amountVarTemp";


    if(document.getElementById("batchNoVarTemp"+inc).value!=""){
      		document.getElementById("batchNoVar"+inc).value=document.getElementById("batchNoVarTemp"+inc).value
     }
     else
      		document.getElementById("batchNoVar"+inc).value="emptyString";


         if(document.getElementById("expDateVarTemp"+inc).value!=""){
      		document.getElementById("expDateVar"+inc).value=document.getElementById("expDateVarTemp"+inc).value
     }
     else
      		document.getElementById("expDateVar"+inc).value="emptyString";


       if(document.getElementById("qtyVarTemp"+inc).value!=""){
      		document.getElementById("qtyVar"+inc).value=document.getElementById("qtyVarTemp"+inc).value
     }
     else
      		document.getElementById("qtyVar"+inc).value="0";


      if(document.getElementById("unitRateVarTemp"+inc).value!=""){
      		document.getElementById("unitRateVar"+inc).value=document.getElementById("unitRateVarTemp"+inc).value
     }
     else{
      		document.getElementById("unitRateVar"+inc).value="0";
      }

      if(document.getElementById("amountVarTemp"+inc).value!=""){
    		document.getElementById("amountVar"+inc).value=document.getElementById("amountVarTemp"+inc).value
   }
   else{
    		document.getElementById("amountVar"+inc).value="0";
    }
      //document.getElementById("mrp"+inc).value=0;


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
jQuery(document).ready(function(){
	jQuery(".MasterData").blur(function(){
		var val = this.value;
		var thisId= this.id;
	if(val!=''){
		var index1 = val.lastIndexOf("[");
		var index2 = val.lastIndexOf("]");
		var masId = val.substring(index1+1,index2);
		var countStr = thisId.substring(thisId.lastIndexOf("_")+1);
		var id1 = thisId.substring(0, thisId.lastIndexOf("_"));
		 if(index1==-1 || index2==-1){
			 jQuery('#'+id1+'_addNew'+countStr).css('display', 'Block');
			 }else{
				 jQuery('#'+id1+'Id'+countStr).val(masId);
			 }
    }});
});
	 function dataCheck(val1, id2){
		var val = val1;
		var thisId= id2;
		if(val!=''){
			var index1 = val.lastIndexOf("[");
			var index2 = val.lastIndexOf("]");
			var masId = val.substring(index1+1,index2);
			var countStr = thisId.substring(thisId.lastIndexOf("_")+1);
			var id1 = thisId.substring(0, thisId.lastIndexOf("_"));
			 if(index1==-1 || index2==-1){
				 jQuery('#'+id1+'_addNew'+countStr).css('display', 'Block');
				 }else{
					 jQuery('#'+id1+'Id'+countStr).val(masId); 
				 }
	    }
	} 
	function addNew(countId, strId, masterName){ 
			var val = jQuery('#'+strId+'_'+countId).val();
			//var flag=confirm("Add new entry!");
			 //if(flag){
					jQuery.getJSON("stores?method=jsonForMasterAdd&entryName="+val+"&masterName="+masterName, function(result){
					var str = result.entryResponce;
					jQuery('#'+strId+'_'+countId).val(str);	
					jQuery('#'+strId+'Id'+countId).val(str.substring(str.lastIndexOf("[")+1, str.lastIndexOf("]")));
					jQuery('#'+strId+'_addNew'+countId).css('display', 'none');
			        });
			/*  }else{
				 jQuery('#'+strId+'_'+countId).val('');
			 } */
	}
 </script>
 <form name="departmentInd" method="post" action="">
 <div class="clear"></div>
<div class="titleBg">
<h2>Rate Contract Receive</h2>
</div>
<div class="clear"></div>
<%-- <div class="Block">

<label>Select File</label> <input
	type="file" name="<%=UPLOAD_FILENAME%>" id="uploadFilename" value="" />
	<input type="button" name="Export" value="Export Items" class="buttonBig" onclick="submitFormForButton('departmentInd','stores?method=createPvmsItemExcelList')" />
	  <input type="button" name="impbutton" id="submitForDisable" value="Import Item Stock " class="buttonBig" onClick="jsImportForPVMS()">
</div> --%>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
<%-- 
<form name="departmentIndent" method="post">


<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
 thread search menu
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<form name="searchPanel" method="post">
<div class="paddingTop40"></div>
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" />
<input type="hidden" name="do" value="process" /> <input type="hidden"	name="searchthread" value="1" />
<input type="hidden" name="showposts"	value="1" />
<input type="hidden" name="searchthreadid" value="85875" />
<label>From Date </label>
<input type="text" name="<%= FROM_DATE %>"	value="<%=currentDate %>" MAXLENGTH="30" tabindex=1 class="date" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=currentDate%>',document.departmentIndent.<%= FROM_DATE%>,event)" />
<label>To Date </label>
<input type="text" name="<%= TO_DATE %>" value="<%=currentDate %>" MAXLENGTH="30" tabindex=1 class="date" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=currentDate%>',document.departmentIndent.<%= TO_DATE%>,event)" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<label>Opening Balance No. </label>
<select	name="<%= SEARCH_BALANCE_NO%>">
	<option value="0">Select</option>
	<%
					for (StoreBalanceM storeBalanceM :searchStoreBalanceMList ) {
				%>

	<option value=<%=storeBalanceM.getBalanceNo()%>><%=storeBalanceM.getBalanceNo()%></option>
	<%
	}
				%>
</select>
<input type="image"  name="Submit"	id="addbutton" class="button"	onClick="submitForm('departmentIndent','stores?method=searchBalance');" />
</form>
</div> --%>
<form name="departmentIndentGrid" method="post"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="Block">
<input type="hidden" name="pageNo"	value="<%=pageNo%>" id="pageNo" validate="pageNo,int,no"/>
<input type="hidden" size="2"	value="0" name="<%=NO_OF_ROWS%>" id="<%=NO_OF_ROWS%>" validate="NoOfRows,int,no"/>
<input	type="hidden" name="<%=BALANCE_ID %>" value="<%=balanceId%>"	id="balanceId" validate="balanceId,int,no"/>
<%if(balanceId==0){ %>
<label> Balance Entry No.<span>*</span> </label>
<input	type="text" name="<%=BALANCE_NO %>" value="<%=maxBalanceNo%>"  readonly="readonly" MAXLENGTH="8"   tabindex=1 />
<label>Balance Entry Date<span>*</span></label>
<input type="text"	name="<%=BALANCE_DATE%>" readonly="readonly" validate="Balance Entry Date,date,yes"	value="<%=currentDate %>" MAXLENGTH="30" tabindex=1 />

<label><span>*</span> Requested By</label>
<select	name="<%=APPROVED_BY_EMPLOYEE_ID_BALANCE%>"	validate="Requested By,String,yes" id="approvedBy" tabindex=1>
	<option value="0">Select</option>
	<%
				for (MasEmployee approvedBy :approvedByEmployeeList ) {
			%>
	<option value=<%=approvedBy.getId()%>><%=approvedBy.getFirstName()%>
	<%=approvedBy.getLastName()%></option>
	<%
	}
			%>
</select>

<div class="clear"></div>
<label>Remarks</label>
<input type="text" name="<%=REMARKS %>"	value="" class="large" tabindex=1 maxlength="90" style="width:477px;" /> <%}else{ %>
<label> Balance No. </label>
<input type="text" name="<%=BALANCE_NO %>"	value="<%=balanceNo%>" class="readOnly" readonly="readonly"	MAXLENGTH="8"   tabindex=1 />
<label>Opening Balance Date</label>
<input type="text" name="<%=BALANCE_DATE%>" class="readOnly"	readonly="readonly"	value="<%=HMSUtil.convertDateToStringWithoutTime(balanceDate) %>" MAXLENGTH="30" tabindex=1 validate="balanceDate,date,no"/>
<div class="clear"></div>
<label><span>*</span> Requested By</label>
<select	name="<%=APPROVED_BY_EMPLOYEE_ID_BALANCE%>"	 id="approvedBy"  tabindex=1>
	<option value="0">Select</option>
	<%
			for (MasEmployee approvedBy :approvedByEmployeeList ) {
		%>
	<option value=<%=approvedBy.getId()%>><%=approvedBy.getFirstName()%>
	<%=approvedBy.getLastName()%></option>
	<%
			}
		%>
</select>
<script type="text/javascript">
<%
				if(approvedById != 0){
			%>
			document.getElementById('approvedBy').value = '<%=approvedById%>';
			<%}%>
			</script> <label>Remarks</label> <input type="text" name="<%=REMARKS %>"
	value="<%=remarks %> " tabindex=1 maxlength="30" /> <% } %>

<div class="clear"></div></div>
<div class="Block">
<div class="clear"></div>
<label> Item Group</label> 
<select name="itemGroupId" id="itemGroupId"  onblur="submitProtoAjaxWithDivName(this.form.name,'stores?method=getItemTypeList&group='+this.value,'nameDiv');" >
	<option value="0">Select</option>
	<%if(storeGroupList.size()>0){
		for(MasStoreGroup masStoreGroup:storeGroupList){
		%>
		<option value="<%=masStoreGroup.getId() %>"><%=masStoreGroup.getGroupName() %></option>
	<%}} %>
</select>
<div id="nameDiv">
<label> Item Type</label>
<select name="itemTypeId" id="itemTypeId" >
	<option value="0">Select</option>
	<%if(itemTypeList.size()>0){
		for(MasItemType masItemType:itemTypeList){
		%>
		<option value="<%=masItemType.getId() %>"><%=masItemType.getItemTypeName() %></option>
	<%}} %>
</select>
<label>Item Section</label>
<select name="sectionId" id="sectionId" >
	<option value="0">Select</option>
	<%if(storeGroupList.size()>0){
		for(MasStoreSection masStoreSection:sectionList){
		%>
		<option value="<%=masStoreSection.getId() %>"><%=masStoreSection.getSectionName()%></option>
	<%}} %>
</select>

<label>Item Category</label>
<select name="categoryId"  id="categoryId"  >
	<option value="0">Select</option>
	<%if(categoryList.size()>0){
		for(MasItemCategory masItemCategory:categoryList){
		%>
		<option value="<%=masItemCategory.getId() %>"><%=masItemCategory.getItemCategoryName() %></option>
	<%}} %>
</select>
<label>Item Class</label>
<select name="classId" id="classId" >
	<option value="0">Select</option>
	<%if(itemClassList.size()>0){
		for(MasItemClass masItemClass:itemClassList){
		%>
		<option value="<%=masItemClass.getId() %>"><%=masItemClass.getItemClassName() %></option>
	<%}} %>
</select>
</div>



</div>

<div class="clear"></div>
<div class="clear"></div> 
<%-- <div id="pagination">Page No. >> <span><%=pageNo%></span></div>--%>
<div class="clear"></div>
<h4>Rate Contract details</h4>
<%if(rcList.size()>0){ %>
<div class="clear"></div>
<!-- <input type="button" name="Add" type="submit" class="buttonAdd" value="" onClick="addRow();" />
  <input type="button" name="Delete" type="submit" class="buttonDel" value="" onClick="removeRow();" /> -->
  <div class="clear"></div>
  <div class="clear"></div>
  <div class="clear"></div>
<div class="cmntable">
<table colspan="7" id="indentDetails" border="0" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
 			<th>S.No.</th>
			<th>Mat Code</th>
			<th>Item Name</th>
			<th>Unit</th>
			<!--  <td width="10%"><label valign="left" class="smalllabel">Brand Name</label>      </td>-->
			<th>Manufacturer</th>
			<th>Brand</th>
			<th>Batch No./Serial No.</th>
			<th>&nbsp;&nbsp; DOM / DOS &nbsp;&nbsp;</th>
			<th>&nbsp;&nbsp; DOE/DWE &nbsp;&nbsp;</th>
			<th>Qty</th>
			<th>Unit Rate</th>
			<th>Amount</th>
			<%-- <th>Mrp</th>
			<th>Dispensing Price</th>--%>
 		</tr>
</thead>
<tbody>
 		<%
    	int detailCounter=8;
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idAu="idAu";
    	String brandId="brandId";


    	String batchNoVar="batchNoVar";
    	String expDateVar="expDateVar";
    	String manufactureDateVar="manufatureDateVar";
    	String qtyVar="qtyVar";
    	String unitRateVar="unitRateVar";
    	String amountVar="amountVar";

    	String batchNoVarTemp="batchNoVarTemp";
    	String expDateVarTemp="expDateVarTemp";
    	String manufactureDateVarTemp="manufactureDateVarTemp";
    	String qtyVarTemp="qtyVarTemp";
    	String unitRateVarTemp="unitRateVarTemp";
    	String amountVarTemp="amountVarTemp";
    	String incVar="incVar";

    	String brandId2="brandId";
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idAu2="idAu";

    	String batchNoVar2="batchNoVar";
    	String manufactureDateVar2="manufactureDateVar";
    	String expDateVar2="expDateVar";
    	String qtyVar2="qtyVar";
    	String unitRateVar2="unitRateVar";
    	String amountVar2="amountVar";
    	String manuId="manuId";
    	String manuId2="manuId";

    	String manuIdTemp="manuIdTemp";
    	String manuIdTemp2="manuIdTemp";
    	String batchNoVarTemp2="batchNoVarTemp";
    	String expDateVarTemp2="expDateVarTemp";
    	String manufactureDateVarTemp2="manufactureDateVarTemp";
    	String qtyVarTemp2="qtyVarTemp";
    	String unitRateVarTemp2="unitRateVarTemp";
    	String amountVarTemp2="amountVarTemp";
    	String incVar2="incVar2";

    	String dispensingPrice="dispensingPrice";
    	String dispensingPrice2="dispensingPrice";
    	String mrp="mrp";
    	String mrp2="mrp";
	int inc = 0;
	int k = 0;
    	
     		List itemIdList = new ArrayList();
     		List itemCodeList = new ArrayList();
     		List itemNameList = new ArrayList();
     		List itemUnitList = new ArrayList();
     		
     		List itemBatch1List = new ArrayList();
     		List itemBatch2List = new ArrayList();
     		List itemBatch3List = new ArrayList();
     		List itemBatch4List = new ArrayList();
     		List itemBatch5List = new ArrayList();
     		List itemBatch6List = new ArrayList();
     		List itemBatch7List = new ArrayList();
     		List itemBatch8List = new ArrayList();
     		List itemBatch9List = new ArrayList();
     		List itemBatch10List = new ArrayList();
     		
     		
     		List itemExpiry1List = new ArrayList();
     		List itemExpiry2List = new ArrayList();
     		List itemExpiry3List = new ArrayList();
     		List itemExpiry4List = new ArrayList();
     		List itemExpiry5List = new ArrayList();
     		List itemExpiry6List = new ArrayList();
     		List itemExpiry7List = new ArrayList();
     		List itemExpiry8List = new ArrayList();
     		List itemExpiry9List = new ArrayList();
     		List itemExpiry10List = new ArrayList();
     		
     		List itemQty1List = new ArrayList();
     		List itemQty2List = new ArrayList();
     		List itemQty3List = new ArrayList();
     		List itemQty4List = new ArrayList();
     		List itemQty5List = new ArrayList();
     		List itemQty6List = new ArrayList();
     		List itemQty7List = new ArrayList();
     		List itemQty8List = new ArrayList();
     		List itemQty9List = new ArrayList();
     		List itemQty10List = new ArrayList();
     	if(obj!=null){
     		int l=obj.length;
			//System.out.println("l----"+l);
			for(int i=1;i<l;i++){
				/* if(obj[i][4] != null || obj[i][7] != null || obj[i][10]!= null || obj[i][13] != null ||obj[i][16] != null || obj[i][19] != null || obj[i][22] != null  || obj[i][25]!= null  || obj[i][28]!= null || obj[i][31]!= null){ */
				if(obj[i][0] != null){
					itemIdList.add((String)obj[i][0]);
				}
				if(obj[i][1] != null){
					itemCodeList.add((String)obj[i][1]);
				}
				if(obj[i][2] != null){
					itemNameList.add((String)obj[i][2]);
				}
				if(obj[i][3] != null){
					itemUnitList.add((String)obj[i][3]);
				}
				
				//System.out.println(obj[i][4]);
				if(obj[i][4] != null){
					itemBatch1List.add((String)obj[i][4]);
				}else{
					itemBatch1List.add("");
				}
				if(obj[i][5] != null){
					itemExpiry1List.add((String)obj[i][5]);
				}else{
					itemExpiry1List.add("");
				}
				if(obj[i][6] != null){
					itemQty1List.add((String)obj[i][6]);
				}else{
					itemQty1List.add("");
				}
				
				
				if(obj[i][7] != null){
					itemBatch2List.add((String)obj[i][7]);
				}else{
					itemBatch2List.add("");
				}
				
				if(obj[i][8] != null){
					itemExpiry2List.add((String)obj[i][8]);
				}else{
					itemExpiry2List.add("");
				}
				if(obj[i][9] != null){
					itemQty2List.add((String)obj[i][9]);
				}else{
					itemQty2List.add("");
				}
				
				if(obj[i][10] != null){
					itemBatch3List.add((String)obj[i][10]);
				}else{
					itemBatch3List.add("");
				}
				if(obj[i][11] != null){
					itemExpiry3List.add((String)obj[i][11]);
				}else{
					itemExpiry3List.add("");
				}
				if(obj[i][12] != null){
					itemQty3List.add((String)obj[i][12]);
				}else{
					itemQty3List.add("");
				}
				
				if(obj[i][13] != null){
					itemBatch4List.add((String)obj[i][13]);
				}else{
					itemBatch4List.add("");
				}
				if(obj[i][14] != null){
					itemExpiry4List.add((String)obj[i][14]);
				}else{
					itemExpiry4List.add("");
				}
				if(obj[i][15] != null){
					itemQty4List.add((String)obj[i][15]);
				}else{
					itemQty4List.add("");
				}
				
				if(obj[i][16] != null){
					itemBatch5List.add((String)obj[i][16]);
				}else{
					itemBatch5List.add("");
				}
				if(obj[i][17] != null){
					itemExpiry5List.add((String)obj[i][17]);
				}else{
					itemExpiry5List.add("");
				}
				if(obj[i][18] != null){
					itemQty5List.add((String)obj[i][18]);
				}else{
					itemQty5List.add("");
				}
				
				if(obj[i][19] != null){
					itemBatch6List.add((String)obj[i][19]);
				}else{
					itemBatch6List.add("");
				}
				if(obj[i][20] != null){
					itemExpiry6List.add((String)obj[i][20]);
				}else{
					itemExpiry6List.add("");
				}
				if(obj[i][21] != null){
					itemQty6List.add((String)obj[i][21]);
				}else{
					itemQty6List.add("");
				}
				
				if(obj[i][22] != null){
					itemBatch7List.add((String)obj[i][22]);
				}else{
					itemBatch7List.add("");
				}
				if(obj[i][23] != null){
					itemExpiry7List.add((String)obj[i][23]);
				}else{
					itemExpiry7List.add("");
				}
				if(obj[i][24] != null){
					itemQty7List.add((String)obj[i][24]);
				}else{
					itemQty7List.add("");
				}
				
				if(obj[i][25] != null){
					itemBatch8List.add((String)obj[i][25]);
				}else{
					itemBatch8List.add("");
				}
				if(obj[i][26] != null){
					itemExpiry8List.add((String)obj[i][26]);
				}else{
					itemExpiry8List.add("");
				}
				if(obj[i][27] != null){
					itemQty8List.add((String)obj[i][27]);
				}else{
					itemQty8List.add("");
				}
				
				if(obj[i][28] != null){
					itemBatch9List.add((String)obj[i][28]);
				}else{
					itemBatch9List.add("");
				}
				if(obj[i][29] != null){
					itemExpiry9List.add((String)obj[i][29]);
				}else{
					itemExpiry9List.add("");
				}
				if(obj[i][30] != null){
					itemQty9List.add((String)obj[i][30]);
				}else{
					itemQty9List.add("");
				}
				
				if(obj[i][31] != null){
					itemBatch10List.add((String)obj[i][31]);
				}else{
					itemBatch10List.add("");
				}
				if(obj[i][32] != null){
					itemExpiry10List.add((String)obj[i][32]);
				}else{
					itemExpiry10List.add("");
				}
				if(obj[i][33] != null){
					itemQty10List.add((String)obj[i][33]);
				}else{
					itemQty10List.add("");
				}
			}
     	}
     	
     	if (itemIdList.size()>0) {
     		int j=1; 
     	
			System.out.println("itemBatch1List----"+itemBatch1List.get(5));
			for (k =0; k < itemIdList.size(); k++) {
    	  %>
<%if(!itemBatch1List.get(k).toString().equals("")){ 
	
				//System.out.println("itemBatch1List----"+itemBatch1List.get(k));
	
%>
		<tr>
			<td><input type="checkbox" style="display: none;" value="" name="<%=SR_NO%>" id="srNoId<%=j %>" class="radioCheck" readonly="readonly" /></td>
			<%if (itemCodeList.get(k).toString() != null && !itemCodeList.get(k).toString().equals("")) { %>
			<td><input type="text" name="<%=ITEM_CODE %>" size="8" value="<%=itemCodeList.get(k).toString() %>" readonly="readonly" id="<%=codeItem+j%>" />
			<%} %>
			<%if(itemIdList.get(k).toString() != null && !itemIdList.get(k).toString().equals("")) { %>
			 <input type="hidden" size="2" value="<%=itemIdList.get(k).toString() %>"  name="<%=ITEM_ID%>" id="<%=idItem+j%>" validate="itemId,int,no"/></td>
			<%} %>
		
		<%if (itemNameList.get(k).toString() != null && !itemNameList.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemNameList.get(k).toString() %>" size="40"  id="<%=nameItem+j%>" onblur="if(fillSrNo(<%=j+temp %>)){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=j+temp %>');}" name="<%=nameItem%>" tabindex=1 />
			<%} %>
			<div id="ac6update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem+j%>','ac6update','stores?method=getItemListForLoanoutByAutocompleteBalance&',{parameters:'requiredField=<%=nameItem%>&balanceId='+document.getElementById('balanceId').value,callback: eventCallback});
				</script></td>
		<%if (itemUnitList.get(k).toString() != null && !itemUnitList.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemUnitList.get(k).toString() %>" size="8" readonly="readonly" name="<%=AV%>" id="<%=idAu+j%>" /></td>
			<%} %>
				
		 	<td><select name="<%=RequestConstants.MANUFACTURER_ID%>" id=<%=manuId+j%> tabindex=1  validate="Manufacture,string,yes">
				<option value="0">Select</option>
				<%
				for (MasManufacturer masManufacturer :manufacturerList ) {
			%>
					<option value=<%=masManufacturer.getId()%>><%=masManufacturer.getManufacturerName()%></option>
					<%
				}
			%>
			</select></td>
			
			
			
			<%if (itemBatch1List.get(k).toString() != null && !itemBatch1List.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemBatch1List.get(k).toString() %>" size="8" tabindex=1 name="<%=BATCH%>" id="<%=batchNoVarTemp+j%>" onblur="fillValuesBalance(<%=temp+j%>);checkBatchNo(this.value,'<%=temp+j%>');"  maxlength="10" tabindex=1 />
			<input type="hidden" size="2" value="emptyString" name="<%=BATCH_NO%>" id="<%=batchNoVar+j%>" /></td>
			<%} %>
			 		<%--  fillDate('<%=temp+j%>');  --%>
			 <td><input type="text" value="" name="manufactureDate" onblur="checkExpiryDate(<%=j%>)" size="8" id="<%=manufactureDateVarTemp+j%>" tabindex=1 validate="manufactureDate,date,no"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufactureDateVarTemp+j%>'),event);" />
			 <input type="hidden" value="<%=date%>" name="<%=RequestConstants.MANUFACTURING_DATE %>" id="<%=manufactureDateVar+j %>" /> </td>
		 <%if (itemExpiry1List.get(k).toString() != null && !itemExpiry1List.get(k).toString().equals("")) {
			 String inputDateStr = itemExpiry1List.get(k).toString();
		     SimpleDateFormat inputFormatter = new SimpleDateFormat("dd-MMM-yyyy");
		     SimpleDateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy");
		     java.util.Date inputDateDate = inputFormatter.parse(inputDateStr);
		    
			 
			 %>	
		
			<td><input type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(inputDateDate) %>" name="expiryDate"  size="8" id="<%=expDateVarTemp+j%>" onblur="checkExpiryDate(<%=j%>)" tabindex=1 validate="expiryDate,date,no"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=expDateVarTemp+j%>'),event);" />
			 <input type="hidden" value="<%=date%>" name="exp" id="<%=expDateVar+j %>" /> </td>
		<%} %>
		<%if (itemQty1List.get(k).toString() != null && !itemQty1List.get(k).toString().equals("")) { %>	
			<td><input type="text" size="8" value="<%=itemQty1List.get(k).toString() %>" name="<%=QTY_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=qtyVarTemp+j%>" validate="Qty,float,no" onblur="fillValuesBalance(<%=j%>);calculateAmount(<%=j %>);" tabindex=1 />
			 <input type="hidden" value="0" name="<%=QTY_BALANCE%>" tabindex="2" id="<%=qtyVar+j%>" /> </td>
		<%} %>	 
			<td><input type="text" size="8" value="" name="<%=UNIT_RATE_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=unitRateVarTemp+j%>" validate="unitRateBalanceTemp,float,no" onblur="fillValuesBalance(<%=j%>);calculateAmount(<%=j %>);checkBeforeSubmit(<%=j %>)" />
			 <input type="hidden" value="0" name="<%=UNIT_RATE_BALANCE%>" tabindex="2" id="<%=unitRateVar+j%>" /> </td>
						
			<td><input type="text" size="8" value="" name="<%=AMOUNT_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=amountVarTemp+j%>" validate="amountBalanceTemp,float,no" onblur="fillValuesBalance(<%=j%>);checkBeforeSubmit(<%=j %>);"  />
					<input type="hidden" value="0" name="<%=AMOUNT_BALANCE%>" tabindex="2" id="<%=amountVar+j%>" alidate="amountBalance,float,no"/></td>
</tr>						
<%j++;} %>	
<%if(!itemBatch2List.get(k).toString().equals("")){ 
	System.out.println("itemBatch1List---if-"+itemBatch2List.get(k));
%>
<tr>
			<td><input type="checkbox"  value="" name="<%=SR_NO%>" id="srNoId<%=j %>" class="radioCheck" readonly="readonly" /></td>
			<%if (itemCodeList.get(k).toString() != null && !itemCodeList.get(k).toString().equals("")) { %>
			<td><input type="text" name="<%=ITEM_CODE %>" size="8" value="<%=itemCodeList.get(k).toString() %>" readonly="readonly" id="<%=codeItem+j%>" />
			<%} %>
			<%if(itemIdList.get(k).toString() != null && !itemIdList.get(k).toString().equals("")) { %>
			 <input type="hidden" size="2" value="<%=itemIdList.get(k).toString() %>" class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem+j%>" validate="itemId,int,no"/></td>
			<%} %>
		
		<%if (itemNameList.get(k).toString() != null && !itemNameList.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemNameList.get(k).toString() %>" size="40"  id="<%=nameItem+j%>" onblur="if(fillSrNo(<%=j+temp %>)){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=j+temp %>');}" name="<%=nameItem%>" tabindex=1 />
			<%} %>
			<div id="ac6update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem+j%>','ac6update','stores?method=getItemListForLoanoutByAutocompleteBalance&',{parameters:'requiredField=<%=nameItem%>&balanceId='+document.getElementById('balanceId').value,callback: eventCallback});
				</script></td>
		<%if (itemUnitList.get(k).toString() != null && !itemUnitList.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemUnitList.get(k).toString() %>" size="8" readonly="readonly" name="<%=AV%>" id="<%=idAu+j%>" /></td>
			<%} %>
				
		 	<td><select name="<%=RequestConstants.MANUFACTURER_ID%>" id=<%=manuId+j%> tabindex=1  validate="Manufacture,string,yes">
				<option value="0">Select</option>
				<%
				for (MasManufacturer masManufacturer :manufacturerList ) {
			%>
					<option value=<%=masManufacturer.getId()%>><%=masManufacturer.getManufacturerName()%></option>
					<%
				}
			%>
			</select></td>
			
			<%if (itemBatch2List.get(k).toString() != null && !itemBatch2List.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemBatch2List.get(k).toString() %>" size="8" tabindex=1 name="<%=BATCH%>" id="<%=batchNoVarTemp+j%>" onblur="fillValuesBalance(<%=temp+j%>);checkBatchNo(this.value,'<%=temp+j%>');"  maxlength="10" tabindex=1 />
			<input type="hidden" size="2" value="emptyString" name="<%=BATCH_NO%>" id="<%=batchNoVar+j%>" /></td>
			<%} %>
			 		<%--  fillDate('<%=temp+j%>');  --%>
			 <td><input type="text" value="" name="manufactureDate" onblur="checkExpiryDate(<%=j%>)" size="8" id="<%=manufactureDateVarTemp+j%>" tabindex=1 validate="manufactureDate,date,no"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufactureDateVarTemp+j%>'),event);" />
			 <input type="hidden" value="<%=date%>" name="<%=RequestConstants.MANUFACTURING_DATE %>" id="<%=manufactureDateVar+j %>" /> </td>
		 <%if (itemExpiry2List.get(k).toString() != null && !itemExpiry2List.get(k).toString().equals("")) {
			 String inputDateStr = itemExpiry2List.get(k).toString();
		     SimpleDateFormat inputFormatter = new SimpleDateFormat("dd-MMM-yyyy");
		     SimpleDateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy");
		     java.util.Date inputDateDate = inputFormatter.parse(inputDateStr);
			 %>	
		
			<td><input type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(inputDateDate) %>" name="expiryDate"  size="8" id="<%=expDateVarTemp+j%>" onblur="checkExpiryDate(<%=j%>)" tabindex=1 validate="expiryDate,date,no"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=expDateVarTemp+j%>'),event);" />
			 <input type="hidden" value="<%=date%>" name="exp" id="<%=expDateVar+j %>" /> </td>
		<%} %>
		<%if (itemQty2List.get(k).toString() != null && !itemQty2List.get(k).toString().equals("")) { %>	
			<td><input type="text" size="8" value="<%=itemQty2List.get(k).toString() %>" name="<%=QTY_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=qtyVarTemp+j%>" validate="Qty,float,no" onblur="fillValuesBalance(<%=j%>);calculateAmount(<%=j %>);" tabindex=1 />
			 <input type="hidden" value="0" name="<%=QTY_BALANCE%>" tabindex="2" id="<%=qtyVar+j%>" /> </td>
		<%} %>	 
			<td><input type="text" size="8" value="" name="<%=UNIT_RATE_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=unitRateVarTemp+j%>" validate="unitRateBalanceTemp,float,no" onblur="fillValuesBalance(<%=j%>);calculateAmount(<%=j %>);checkBeforeSubmit(<%=j %>)" />
			 <input type="hidden" value="0" name="<%=UNIT_RATE_BALANCE%>" tabindex="2" id="<%=unitRateVar+j%>" /> </td>
						
			<td><input type="text" size="8" value="" name="<%=AMOUNT_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=amountVarTemp+j%>" validate="amountBalanceTemp,float,no" onblur="fillValuesBalance(<%=j%>);checkBeforeSubmit(<%=j %>);"  />
					<input type="hidden" value="0" name="<%=AMOUNT_BALANCE%>" tabindex="2" id="<%=amountVar+j%>" alidate="amountBalance,float,no"/></td>
		</tr>					
<%j++;} %>
<%if(!itemBatch3List.get(k).toString().equals("")){ %>
<tr>
			<td><input type="checkbox"  value="" name="<%=SR_NO%>" id="srNoId<%=j %>" class="radioCheck" readonly="readonly" /></td>
			<%if (itemCodeList.get(k).toString() != null && !itemCodeList.get(k).toString().equals("")) { %>
			<td><input type="text" name="<%=ITEM_CODE %>" size="8" value="<%=itemCodeList.get(k).toString() %>" readonly="readonly" id="<%=codeItem+j%>" />
			<%} %>
			<%if(itemIdList.get(k).toString() != null && !itemIdList.get(k).toString().equals("")) { %>
			 <input type="hidden" size="2" value="<%=itemIdList.get(k).toString() %>" class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem+j%>" validate="itemId,int,no"/></td>
			<%} %>
		
		<%if (itemNameList.get(k).toString() != null && !itemNameList.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemNameList.get(k).toString() %>" size="40"  id="<%=nameItem+j%>" onblur="if(fillSrNo(<%=j+temp %>)){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=j+temp %>');}" name="<%=nameItem%>" tabindex=1 />
			<%} %>
			<div id="ac6update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem+j%>','ac6update','stores?method=getItemListForLoanoutByAutocompleteBalance&',{parameters:'requiredField=<%=nameItem%>&balanceId='+document.getElementById('balanceId').value,callback: eventCallback});
				</script></td>
		<%if (itemUnitList.get(k).toString() != null && !itemUnitList.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemUnitList.get(k).toString() %>" size="8" readonly="readonly" name="<%=AV%>" id="<%=idAu+j%>" /></td>
			<%} %>
				
		 	<td><select name="<%=RequestConstants.MANUFACTURER_ID%>" id=<%=manuId+j%> tabindex=1  validate="Manufacture,string,yes">
				<option value="0">Select</option>
				<%
				for (MasManufacturer masManufacturer :manufacturerList ) {
			%>
					<option value=<%=masManufacturer.getId()%>><%=masManufacturer.getManufacturerName()%></option>
					<%
				}
			%>
			</select></td>
			
			<%if (itemBatch3List.get(k).toString() != null && !itemBatch3List.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemBatch3List.get(k).toString() %>" size="8" tabindex=1 name="<%=BATCH%>" id="<%=batchNoVarTemp+j%>" onblur="fillValuesBalance(<%=temp+j%>);checkBatchNo(this.value,'<%=temp+j%>');"  maxlength="10" tabindex=1 />
			<input type="hidden" size="2" value="emptyString" name="<%=BATCH_NO%>" id="<%=batchNoVar+j%>" /></td>
			<%} %>
			 		<%--  fillDate('<%=temp+j%>');  --%>
			 <td><input type="text" value="" name="manufactureDate" onblur="checkExpiryDate(<%=j%>)" size="8" id="<%=manufactureDateVarTemp+j%>" tabindex=1 validate="manufactureDate,date,no"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufactureDateVarTemp+j%>'),event);" />
			 <input type="hidden" value="<%=date%>" name="<%=RequestConstants.MANUFACTURING_DATE %>" id="<%=manufactureDateVar+j %>" /> </td>
		 <%if (itemExpiry3List.get(k).toString() != null && !itemExpiry3List.get(k).toString().equals("")) {
			 String inputDateStr = itemExpiry3List.get(k).toString();
		     SimpleDateFormat inputFormatter = new SimpleDateFormat("dd-MMM-yyyy");
		     SimpleDateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy");
		     java.util.Date inputDateDate = inputFormatter.parse(inputDateStr);
		    
			 
			 %>	
		
			<td><input type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(inputDateDate) %>" name="expiryDate"  size="8" id="<%=expDateVarTemp+j%>" onblur="checkExpiryDate(<%=j%>)" tabindex=1 validate="expiryDate,date,no"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=expDateVarTemp+j%>'),event);" />
			 <input type="hidden" value="<%=date%>" name="exp" id="<%=expDateVar+j %>" /> </td>
		<%} %>
		<%if (itemQty3List.get(k).toString() != null && !itemQty3List.get(k).toString().equals("")) { %>	
			<td><input type="text" size="8" value="<%=itemQty3List.get(k).toString() %>" name="<%=QTY_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=qtyVarTemp+j%>" validate="Qty,float,no" onblur="fillValuesBalance(<%=j%>);calculateAmount(<%=j %>);" tabindex=1 />
			 <input type="hidden" value="0" name="<%=QTY_BALANCE%>" tabindex="2" id="<%=qtyVar+j%>" /> </td>
		<%} %>	 
			<td><input type="text" size="8" value="" name="<%=UNIT_RATE_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=unitRateVarTemp+j%>" validate="unitRateBalanceTemp,float,no" onblur="fillValuesBalance(<%=j%>);calculateAmount(<%=j %>);checkBeforeSubmit(<%=j %>)" />
			 <input type="hidden" value="0" name="<%=UNIT_RATE_BALANCE%>" tabindex="2" id="<%=unitRateVar+j%>" /> </td>
						
			<td><input type="text" size="8" value="" name="<%=AMOUNT_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=amountVarTemp+j%>" validate="amountBalanceTemp,float,no" onblur="fillValuesBalance(<%=j%>);checkBeforeSubmit(<%=j %>);"  />
					<input type="hidden" value="0" name="<%=AMOUNT_BALANCE%>" tabindex="2" id="<%=amountVar+j%>" alidate="amountBalance,float,no"/></td>
	</tr>						
<%j++;} %>
<%if(!itemBatch4List.get(k).toString().equals("")){ %>
<tr>
			<td><input type="checkbox"  value="" name="<%=SR_NO%>" id="srNoId<%=j %>" class="radioCheck" readonly="readonly" /></td>
			<%if (itemCodeList.get(k).toString() != null && !itemCodeList.get(k).toString().equals("")) { %>
			<td><input type="text" name="<%=ITEM_CODE %>" size="8" value="<%=itemCodeList.get(k).toString() %>" readonly="readonly" id="<%=codeItem+j%>" />
			<%} %>
			<%if(itemIdList.get(k).toString() != null && !itemIdList.get(k).toString().equals("")) { %>
			 <input type="hidden" size="2" value="<%=itemIdList.get(k).toString() %>" class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem+j%>" validate="itemId,int,no"/></td>
			<%} %>
		
		<%if (itemNameList.get(k).toString() != null && !itemNameList.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemNameList.get(k).toString() %>" size="40"  id="<%=nameItem+j%>" onblur="if(fillSrNo(<%=j+temp %>)){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=j+temp %>');}" name="<%=nameItem%>" tabindex=1 />
			<%} %>
			<div id="ac6update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem+j%>','ac6update','stores?method=getItemListForLoanoutByAutocompleteBalance&',{parameters:'requiredField=<%=nameItem%>&balanceId='+document.getElementById('balanceId').value,callback: eventCallback});
				</script></td>
		<%if (itemUnitList.get(k).toString() != null && !itemUnitList.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemUnitList.get(k).toString() %>" size="8" readonly="readonly" name="<%=AV%>" id="<%=idAu+j%>" /></td>
			<%} %>
				
		 	<td><select name="<%=RequestConstants.MANUFACTURER_ID%>" id=<%=manuId+j%> tabindex=1  validate="Manufacture,string,yes">
				<option value="0">Select</option>
				<%
				for (MasManufacturer masManufacturer :manufacturerList ) {
			%>
					<option value=<%=masManufacturer.getId()%>><%=masManufacturer.getManufacturerName()%></option>
					<%
				}
			%>
			</select></td>
			
			<%if (itemBatch4List.get(k).toString() != null && !itemBatch4List.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemBatch4List.get(k).toString() %>" size="8" tabindex=1 name="<%=BATCH%>" id="<%=batchNoVarTemp+j%>" onblur="fillValuesBalance(<%=temp+j%>);checkBatchNo(this.value,'<%=temp+j%>');"  maxlength="10" tabindex=1 />
			<input type="hidden" size="2" value="emptyString" name="<%=BATCH_NO%>" id="<%=batchNoVar+j%>" /></td>
			<%} %>
			 		<%--  fillDate('<%=temp+j%>');  --%>
			 <td><input type="text" value="" name="manufactureDate" onblur="checkExpiryDate(<%=j%>)" size="8" id="<%=manufactureDateVarTemp+j%>" tabindex=1 validate="manufactureDate,date,no"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufactureDateVarTemp+j%>'),event);" />
			 <input type="hidden" value="<%=date%>" name="<%=RequestConstants.MANUFACTURING_DATE %>" id="<%=manufactureDateVar+j %>" /> </td>
		 <%if (itemExpiry4List.get(k).toString() != null && !itemExpiry4List.get(k).toString().equals("")) {
			 String inputDateStr = itemExpiry4List.get(k).toString();
		     SimpleDateFormat inputFormatter = new SimpleDateFormat("dd-MMM-yyyy");
		     SimpleDateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy");
		     java.util.Date inputDateDate = inputFormatter.parse(inputDateStr);
		    
			 
			 %>	
		
			<td><input type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(inputDateDate) %>" name="expiryDate"  size="8" id="<%=expDateVarTemp+j%>" onblur="checkExpiryDate(<%=j%>)" tabindex=1 validate="expiryDate,date,no"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=expDateVarTemp+j%>'),event);" />
			 <input type="hidden" value="<%=date%>" name="exp" id="<%=expDateVar+j %>" /> </td>
		<%} %>
		<%if (itemQty4List.get(k).toString() != null && !itemQty4List.get(k).toString().equals("")) { %>	
			<td><input type="text" size="8" value="<%=itemQty4List.get(k).toString() %>" name="<%=QTY_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=qtyVarTemp+j%>" validate="Qty,float,no" onblur="fillValuesBalance(<%=j%>);calculateAmount(<%=j %>);" tabindex=1 />
			 <input type="hidden" value="0" name="<%=QTY_BALANCE%>" tabindex="2" id="<%=qtyVar+j%>" /> </td>
		<%} %>	 
			<td><input type="text" size="8" value="" name="<%=UNIT_RATE_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=unitRateVarTemp+j%>" validate="unitRateBalanceTemp,float,no" onblur="fillValuesBalance(<%=j%>);calculateAmount(<%=j %>);checkBeforeSubmit(<%=j %>)" />
			 <input type="hidden" value="0" name="<%=UNIT_RATE_BALANCE%>" tabindex="2" id="<%=unitRateVar+j%>" /> </td>
						
			<td><input type="text" size="8" value="" name="<%=AMOUNT_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=amountVarTemp+j%>" validate="amountBalanceTemp,float,no" onblur="fillValuesBalance(<%=j%>);checkBeforeSubmit(<%=j %>);"  />
					<input type="hidden" value="0" name="<%=AMOUNT_BALANCE%>" tabindex="2" id="<%=amountVar+j%>" alidate="amountBalance,float,no"/></td>
	</tr>					
<%j++;} %>
<%if(!itemBatch5List.get(k).toString().equals("")){ %>
<tr>
			<td><input type="checkbox"  value="" name="<%=SR_NO%>" id="srNoId<%=j %>" class="radioCheck" readonly="readonly" /></td>
			<%if (itemCodeList.get(k).toString() != null && !itemCodeList.get(k).toString().equals("")) { %>
			<td><input type="text" name="<%=ITEM_CODE %>" size="8" value="<%=itemCodeList.get(k).toString() %>" readonly="readonly" id="<%=codeItem+j%>" />
			<%} %>
			<%if(itemIdList.get(k).toString() != null && !itemIdList.get(k).toString().equals("")) { %>
			 <input type="hidden" size="2" value="<%=itemIdList.get(k).toString() %>" class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem+j%>" validate="itemId,int,no"/></td>
			<%} %>
		
		<%if (itemNameList.get(k).toString() != null && !itemNameList.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemNameList.get(k).toString() %>" size="40"  id="<%=nameItem+j%>" onblur="if(fillSrNo(<%=j+temp %>)){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=j+temp %>');}" name="<%=nameItem%>" tabindex=1 />
			<%} %>
			<div id="ac6update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem+j%>','ac6update','stores?method=getItemListForLoanoutByAutocompleteBalance&',{parameters:'requiredField=<%=nameItem%>&balanceId='+document.getElementById('balanceId').value,callback: eventCallback});
				</script></td>
		<%if (itemUnitList.get(k).toString() != null && !itemUnitList.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemUnitList.get(k).toString() %>" size="8" readonly="readonly" name="<%=AV%>" id="<%=idAu+j%>" /></td>
			<%} %>
				
		 	<td><select name="<%=RequestConstants.MANUFACTURER_ID%>" id=<%=manuId+j%> tabindex=1  validate="Manufacture,string,yes">
				<option value="0">Select</option>
				<%
				for (MasManufacturer masManufacturer :manufacturerList ) {
			%>
					<option value=<%=masManufacturer.getId()%>><%=masManufacturer.getManufacturerName()%></option>
					<%
				}
			%>
			</select></td>
			
			<%if (itemBatch5List.get(k).toString() != null && !itemBatch5List.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemBatch5List.get(k).toString() %>" size="8" tabindex=1 name="<%=BATCH%>" id="<%=batchNoVarTemp+j%>" onblur="fillValuesBalance(<%=temp+j%>);checkBatchNo(this.value,'<%=temp+j%>');"  maxlength="10" tabindex=1 />
			<input type="hidden" size="2" value="emptyString" name="<%=BATCH_NO%>" id="<%=batchNoVar+j%>" /></td>
			<%} %>
			 		<%--  fillDate('<%=temp+j%>');  --%>
			 <td><input type="text" value="" name="manufactureDate" onblur="checkExpiryDate(<%=j%>)" size="8" id="<%=manufactureDateVarTemp+j%>" tabindex=1 validate="manufactureDate,date,no"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufactureDateVarTemp+j%>'),event);" />
			 <input type="hidden" value="<%=date%>" name="<%=RequestConstants.MANUFACTURING_DATE %>" id="<%=manufactureDateVar+j %>" /> </td>
		 <%if (itemExpiry5List.get(k).toString() != null && !itemExpiry5List.get(k).toString().equals("")) {
			 String inputDateStr = itemExpiry5List.get(k).toString();
		     SimpleDateFormat inputFormatter = new SimpleDateFormat("dd-MMM-yyyy");
		     SimpleDateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy");
		     java.util.Date inputDateDate = inputFormatter.parse(inputDateStr);
		    
			 
			 %>	
		
			<td><input type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(inputDateDate) %>" name="expiryDate"  size="8" id="<%=expDateVarTemp+j%>" onblur="checkExpiryDate(<%=j%>)" tabindex=1 validate="expiryDate,date,no"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=expDateVarTemp+j%>'),event);" />
			 <input type="hidden" value="<%=date%>" name="exp" id="<%=expDateVar+j %>" /> </td>
		<%} %>
		<%if (itemQty5List.get(k).toString() != null && !itemQty5List.get(k).toString().equals("")) { %>	
			<td><input type="text" size="8" value="<%=itemQty5List.get(k).toString() %>" name="<%=QTY_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=qtyVarTemp+j%>" validate="Qty,float,no" onblur="fillValuesBalance(<%=j%>);calculateAmount(<%=j %>);" tabindex=1 />
			 <input type="hidden" value="0" name="<%=QTY_BALANCE%>" tabindex="2" id="<%=qtyVar+j%>" /> </td>
		<%} %>	 
			<td><input type="text" size="8" value="" name="<%=UNIT_RATE_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=unitRateVarTemp+j%>" validate="unitRateBalanceTemp,float,no" onblur="fillValuesBalance(<%=j%>);calculateAmount(<%=j %>);checkBeforeSubmit(<%=j %>)" />
			 <input type="hidden" value="0" name="<%=UNIT_RATE_BALANCE%>" tabindex="2" id="<%=unitRateVar+j%>" /> </td>
						
			<td><input type="text" size="8" value="" name="<%=AMOUNT_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=amountVarTemp+j%>" validate="amountBalanceTemp,float,no" onblur="fillValuesBalance(<%=j%>);checkBeforeSubmit(<%=j %>);"  />
					<input type="hidden" value="0" name="<%=AMOUNT_BALANCE%>" tabindex="2" id="<%=amountVar+j%>" alidate="amountBalance,float,no"/></td>
		</tr>					
<%j++;} %>
<%if(!itemBatch6List.get(k).toString().equals("")){ %>
<tr>
			<td><input type="checkbox"  value="" name="<%=SR_NO%>" id="srNoId<%=j %>" class="radioCheck" readonly="readonly" /></td>
			<%if (itemCodeList.get(k).toString() != null && !itemCodeList.get(k).toString().equals("")) { %>
			<td><input type="text" name="<%=ITEM_CODE %>" size="8" value="<%=itemCodeList.get(k).toString() %>" readonly="readonly" id="<%=codeItem+j%>" />
			<%} %>
			<%if(itemIdList.get(k).toString() != null && !itemIdList.get(k).toString().equals("")) { %>
			 <input type="hidden" size="2" value="<%=itemIdList.get(k).toString() %>" class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem+j%>" validate="itemId,int,no"/></td>
			<%} %>
		
		<%if (itemNameList.get(k).toString() != null && !itemNameList.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemNameList.get(k).toString() %>" size="40"  id="<%=nameItem+j%>" onblur="if(fillSrNo(<%=j+temp %>)){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=j+temp %>');}" name="<%=nameItem%>" tabindex=1 />
			<%} %>
			<div id="ac6update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem+j%>','ac6update','stores?method=getItemListForLoanoutByAutocompleteBalance&',{parameters:'requiredField=<%=nameItem%>&balanceId='+document.getElementById('balanceId').value,callback: eventCallback});
				</script></td>
		<%if (itemUnitList.get(k).toString() != null && !itemUnitList.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemUnitList.get(k).toString() %>" size="8" readonly="readonly" name="<%=AV%>" id="<%=idAu+j%>" /></td>
			<%} %>
				
		 	<td><select name="<%=RequestConstants.MANUFACTURER_ID%>" id=<%=manuId+j%> tabindex=1  validate="Manufacture,string,yes">
				<option value="0">Select</option>
				<%
				for (MasManufacturer masManufacturer :manufacturerList ) {
			%>
					<option value=<%=masManufacturer.getId()%>><%=masManufacturer.getManufacturerName()%></option>
					<%
				}
			%>
			</select></td>
			
			<%if (itemBatch6List.get(k).toString() != null && !itemBatch6List.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemBatch6List.get(k).toString() %>" size="8" tabindex=1 name="<%=BATCH%>" id="<%=batchNoVarTemp+j%>" onblur="fillValuesBalance(<%=temp+j%>);checkBatchNo(this.value,'<%=temp+j%>');"  maxlength="10" tabindex=1 />
			<input type="hidden" size="2" value="emptyString" name="<%=BATCH_NO%>" id="<%=batchNoVar+j%>" /></td>
			<%} %>
			 		<%--  fillDate('<%=temp+j%>');  --%>
			 <td><input type="text" value="" name="manufactureDate" onblur="checkExpiryDate(<%=j%>)" size="8" id="<%=manufactureDateVarTemp+j%>" tabindex=1 validate="manufactureDate,date,no"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufactureDateVarTemp+j%>'),event);" />
			 <input type="hidden" value="<%=date%>" name="<%=RequestConstants.MANUFACTURING_DATE %>" id="<%=manufactureDateVar+j %>" /> </td>
		 <%if (itemExpiry6List.get(k).toString() != null && !itemExpiry6List.get(k).toString().equals("")) {
			 String inputDateStr = itemExpiry6List.get(k).toString();
		     SimpleDateFormat inputFormatter = new SimpleDateFormat("dd-MMM-yyyy");
		     SimpleDateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy");
		     java.util.Date inputDateDate = inputFormatter.parse(inputDateStr);
		    
			 
			 %>	
		
			<td><input type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(inputDateDate) %>" name="expiryDate"  size="8" id="<%=expDateVarTemp+j%>" onblur="checkExpiryDate(<%=j%>)" tabindex=1 validate="expiryDate,date,no"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=expDateVarTemp+j%>'),event);" />
			 <input type="hidden" value="<%=date%>" name="exp" id="<%=expDateVar+j %>" /> </td>
		<%} %>
		<%if (itemQty6List.get(k).toString() != null && !itemQty6List.get(k).toString().equals("")) { %>	
			<td><input type="text" size="8" value="<%=itemQty6List.get(k).toString() %>" name="<%=QTY_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=qtyVarTemp+j%>" validate="Qty,float,no" onblur="fillValuesBalance(<%=j%>);calculateAmount(<%=j %>);" tabindex=1 />
			 <input type="hidden" value="0" name="<%=QTY_BALANCE%>" tabindex="2" id="<%=qtyVar+j%>" /> </td>
		<%} %>	 
			<td><input type="text" size="8" value="" name="<%=UNIT_RATE_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=unitRateVarTemp+j%>" validate="unitRateBalanceTemp,float,no" onblur="fillValuesBalance(<%=j%>);calculateAmount(<%=j %>);checkBeforeSubmit(<%=j %>)" />
			 <input type="hidden" value="0" name="<%=UNIT_RATE_BALANCE%>" tabindex="2" id="<%=unitRateVar+j%>" /> </td>
						
			<td><input type="text" size="8" value="" name="<%=AMOUNT_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=amountVarTemp+j%>" validate="amountBalanceTemp,float,no" onblur="fillValuesBalance(<%=j%>);checkBeforeSubmit(<%=j %>);"  />
					<input type="hidden" value="0" name="<%=AMOUNT_BALANCE%>" tabindex="2" id="<%=amountVar+j%>" alidate="amountBalance,float,no"/></td>
		</tr>					
<%j++;} %>
<%if(!itemBatch7List.get(k).toString().equals("")){ %>
<tr>
			<td><input type="checkbox"  value="" name="<%=SR_NO%>" id="srNoId<%=j %>" class="radioCheck" readonly="readonly" /></td>
			<%if (itemCodeList.get(k).toString() != null && !itemCodeList.get(k).toString().equals("")) { %>
			<td><input type="text" name="<%=ITEM_CODE %>" size="8" value="<%=itemCodeList.get(k).toString() %>" readonly="readonly" id="<%=codeItem+j%>" />
			<%} %>
			<%if(itemIdList.get(k).toString() != null && !itemIdList.get(k).toString().equals("")) { %>
			 <input type="hidden" size="2" value="<%=itemIdList.get(k).toString() %>" class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem+j%>" validate="itemId,int,no"/></td>
			<%} %>
		
		<%if (itemNameList.get(k).toString() != null && !itemNameList.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemNameList.get(k).toString() %>" size="40"  id="<%=nameItem+j%>" onblur="if(fillSrNo(<%=j+temp %>)){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=j+temp %>');}" name="<%=nameItem%>" tabindex=1 />
			<%} %>
			<div id="ac6update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem+j%>','ac6update','stores?method=getItemListForLoanoutByAutocompleteBalance&',{parameters:'requiredField=<%=nameItem%>&balanceId='+document.getElementById('balanceId').value,callback: eventCallback});
				</script></td>
		<%if (itemUnitList.get(k).toString() != null && !itemUnitList.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemUnitList.get(k).toString() %>" size="8" readonly="readonly" name="<%=AV%>" id="<%=idAu+j%>" /></td>
			<%} %>
				
		 	<td><select name="<%=RequestConstants.MANUFACTURER_ID%>" id=<%=manuId+j%> tabindex=1  validate="Manufacture,string,yes">
				<option value="0">Select</option>
				<%
				for (MasManufacturer masManufacturer :manufacturerList ) {
			%>
					<option value=<%=masManufacturer.getId()%>><%=masManufacturer.getManufacturerName()%></option>
					<%
				}
			%>
			</select></td>
			
			<%if (itemBatch7List.get(k).toString() != null && !itemBatch7List.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemBatch7List.get(k).toString() %>" size="8" tabindex=1 name="<%=BATCH%>" id="<%=batchNoVarTemp+j%>" onblur="fillValuesBalance(<%=temp+j%>);checkBatchNo(this.value,'<%=temp+j%>');"  maxlength="10" tabindex=1 />
			<input type="hidden" size="2" value="emptyString" name="<%=BATCH_NO%>" id="<%=batchNoVar+j%>" /></td>
			<%} %>
			 		<%--  fillDate('<%=temp+j%>');  --%>
			 <td><input type="text" value="" name="manufactureDate" onblur="checkExpiryDate(<%=j%>)" size="8" id="<%=manufactureDateVarTemp+j%>" tabindex=1 validate="manufactureDate,date,no"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufactureDateVarTemp+j%>'),event);" />
			 <input type="hidden" value="<%=date%>" name="<%=RequestConstants.MANUFACTURING_DATE %>" id="<%=manufactureDateVar+j %>" /> </td>
		 <%if (itemExpiry7List.get(k).toString() != null && !itemExpiry7List.get(k).toString().equals("")) {
			 String inputDateStr = itemExpiry7List.get(k).toString();
		     SimpleDateFormat inputFormatter = new SimpleDateFormat("dd-MMM-yyyy");
		     SimpleDateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy");
		     java.util.Date inputDateDate = inputFormatter.parse(inputDateStr);
		    
			 
			 %>	
		
			<td><input type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(inputDateDate) %>" name="expiryDate"  size="8" id="<%=expDateVarTemp+j%>" onblur="checkExpiryDate(<%=j%>)" tabindex=1 validate="expiryDate,date,no"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=expDateVarTemp+j%>'),event);" />
			 <input type="hidden" value="<%=date%>" name="exp" id="<%=expDateVar+j %>" /> </td>
		<%} %>
		<%if (itemQty7List.get(k).toString() != null && !itemQty7List.get(k).toString().equals("")) { %>	
			<td><input type="text" size="8" value="<%=itemQty7List.get(k).toString() %>" name="<%=QTY_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=qtyVarTemp+j%>" validate="Qty,float,no" onblur="fillValuesBalance(<%=j%>);calculateAmount(<%=j %>);" tabindex=1 />
			 <input type="hidden" value="0" name="<%=QTY_BALANCE%>" tabindex="2" id="<%=qtyVar+j%>" /> </td>
		<%} %>	 
			<td><input type="text" size="8" value="" name="<%=UNIT_RATE_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=unitRateVarTemp+j%>" validate="unitRateBalanceTemp,float,no" onblur="fillValuesBalance(<%=j%>);calculateAmount(<%=j %>);checkBeforeSubmit(<%=j %>)" />
			 <input type="hidden" value="0" name="<%=UNIT_RATE_BALANCE%>" tabindex="2" id="<%=unitRateVar+j%>" /> </td>
						
			<td><input type="text" size="8" value="" name="<%=AMOUNT_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=amountVarTemp+j%>" validate="amountBalanceTemp,float,no" onblur="fillValuesBalance(<%=j%>);checkBeforeSubmit(<%=j %>);"  />
					<input type="hidden" value="0" name="<%=AMOUNT_BALANCE%>" tabindex="2" id="<%=amountVar+j%>" alidate="amountBalance,float,no"/></td>
		</tr>					
<%j++;} %>
<%if(!itemBatch8List.get(k).toString().equals("")){ %>
<tr>
			<td><input type="checkbox"  value="" name="<%=SR_NO%>" id="srNoId<%=j %>" class="radioCheck" readonly="readonly" /></td>
			<%if (itemCodeList.get(k).toString() != null && !itemCodeList.get(k).toString().equals("")) { %>
			<td><input type="text" name="<%=ITEM_CODE %>" size="8" value="<%=itemCodeList.get(k).toString() %>" readonly="readonly" id="<%=codeItem+j%>" />
			<%} %>
			<%if(itemIdList.get(k).toString() != null && !itemIdList.get(k).toString().equals("")) { %>
			 <input type="hidden" size="2" value="<%=itemIdList.get(k).toString() %>" class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem+j%>" validate="itemId,int,no"/></td>
			<%} %>
		
		<%if (itemNameList.get(k).toString() != null && !itemNameList.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemNameList.get(k).toString() %>" size="40"  id="<%=nameItem+j%>" onblur="if(fillSrNo(<%=j+temp %>)){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=j+temp %>');}" name="<%=nameItem%>" tabindex=1 />
			<%} %>
			<div id="ac6update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem+j%>','ac6update','stores?method=getItemListForLoanoutByAutocompleteBalance&',{parameters:'requiredField=<%=nameItem%>&balanceId='+document.getElementById('balanceId').value,callback: eventCallback});
				</script></td>
		<%if (itemUnitList.get(k).toString() != null && !itemUnitList.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemUnitList.get(k).toString() %>" size="8" readonly="readonly" name="<%=AV%>" id="<%=idAu+j%>" /></td>
			<%} %>
				
		 	<td><select name="<%=RequestConstants.MANUFACTURER_ID%>" id=<%=manuId+j%> tabindex=1  validate="Manufacture,string,yes">
				<option value="0">Select</option>
				<%
				for (MasManufacturer masManufacturer :manufacturerList ) {
			%>
					<option value=<%=masManufacturer.getId()%>><%=masManufacturer.getManufacturerName()%></option>
					<%
				}
			%>
			</select></td>
			
			<%if (itemBatch8List.get(k).toString() != null && !itemBatch8List.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemBatch8List.get(k).toString() %>" size="8" tabindex=1 name="<%=BATCH%>" id="<%=batchNoVarTemp+j%>" onblur="fillValuesBalance(<%=temp+j%>);checkBatchNo(this.value,'<%=temp+j%>');"  maxlength="10" tabindex=1 />
			<input type="hidden" size="2" value="emptyString" name="<%=BATCH_NO%>" id="<%=batchNoVar+j%>" /></td>
			<%} %>
			 		<%--  fillDate('<%=temp+j%>');  --%>
			 <td><input type="text" value="" name="manufactureDate" onblur="checkExpiryDate(<%=j%>)" size="8" id="<%=manufactureDateVarTemp+j%>" tabindex=1 validate="manufactureDate,date,no"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufactureDateVarTemp+j%>'),event);" />
			 <input type="hidden" value="<%=date%>" name="<%=RequestConstants.MANUFACTURING_DATE %>" id="<%=manufactureDateVar+j %>" /> </td>
		 <%if (itemExpiry8List.get(k).toString() != null && !itemExpiry8List.get(k).toString().equals("")) {
			 String inputDateStr = itemExpiry8List.get(k).toString();
		     SimpleDateFormat inputFormatter = new SimpleDateFormat("dd-MMM-yyyy");
		     SimpleDateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy");
		     java.util.Date inputDateDate = inputFormatter.parse(inputDateStr);
		    
			 
			 %>	
		
			<td><input type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(inputDateDate) %>" name="expiryDate"  size="8" id="<%=expDateVarTemp+j%>" onblur="checkExpiryDate(<%=j%>)" tabindex=1 validate="expiryDate,date,no"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=expDateVarTemp+j%>'),event);" />
			 <input type="hidden" value="<%=date%>" name="exp" id="<%=expDateVar+j %>" /> </td>
		<%} %>
		<%if (itemQty8List.get(k).toString() != null && !itemQty8List.get(k).toString().equals("")) { %>	
			<td><input type="text" size="8" value="<%=itemQty8List.get(k).toString() %>" name="<%=QTY_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=qtyVarTemp+j%>" validate="Qty,float,no" onblur="fillValuesBalance(<%=j%>);calculateAmount(<%=j %>);" tabindex=1 />
			 <input type="hidden" value="0" name="<%=QTY_BALANCE%>" tabindex="2" id="<%=qtyVar+j%>" /> </td>
		<%} %>	 
			<td><input type="text" size="8" value="" name="<%=UNIT_RATE_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=unitRateVarTemp+j%>" validate="unitRateBalanceTemp,float,no" onblur="fillValuesBalance(<%=j%>);calculateAmount(<%=j %>);checkBeforeSubmit(<%=j %>)" />
			 <input type="hidden" value="0" name="<%=UNIT_RATE_BALANCE%>" tabindex="2" id="<%=unitRateVar+j%>" /> </td>
						
			<td><input type="text" size="8" value="" name="<%=AMOUNT_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=amountVarTemp+j%>" validate="amountBalanceTemp,float,no" onblur="fillValuesBalance(<%=j%>);checkBeforeSubmit(<%=j %>);"  />
					<input type="hidden" value="0" name="<%=AMOUNT_BALANCE%>" tabindex="2" id="<%=amountVar+j%>" alidate="amountBalance,float,no"/></td>
	</tr>					
<%j++;} %>
<%if(!itemBatch9List.get(k).toString().equals("")){ %>
<tr>
			<td><input type="checkbox"  value="" name="<%=SR_NO%>" id="srNoId<%=j %>" class="radioCheck" readonly="readonly" /></td>
			<%if (itemCodeList.get(k).toString() != null && !itemCodeList.get(k).toString().equals("")) { %>
			<td><input type="text" name="<%=ITEM_CODE %>" size="8" value="<%=itemCodeList.get(k).toString() %>" readonly="readonly" id="<%=codeItem+j%>" />
			<%} %>
			<%if(itemIdList.get(k).toString() != null && !itemIdList.get(k).toString().equals("")) { %>
			 <input type="hidden" size="2" value="<%=itemIdList.get(k).toString() %>" class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem+j%>" validate="itemId,int,no"/></td>
			<%} %>
		
		<%if (itemNameList.get(k).toString() != null && !itemNameList.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemNameList.get(k).toString() %>" size="40"  id="<%=nameItem+j%>" onblur="if(fillSrNo(<%=j+temp %>)){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=j+temp %>');}" name="<%=nameItem%>" tabindex=1 />
			<%} %>
			<div id="ac6update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem+j%>','ac6update','stores?method=getItemListForLoanoutByAutocompleteBalance&',{parameters:'requiredField=<%=nameItem%>&balanceId='+document.getElementById('balanceId').value,callback: eventCallback});
				</script></td>
		<%if (itemUnitList.get(k).toString() != null && !itemUnitList.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemUnitList.get(k).toString() %>" size="8" readonly="readonly" name="<%=AV%>" id="<%=idAu+j%>" /></td>
			<%} %>
				
		 	<td><select name="<%=RequestConstants.MANUFACTURER_ID%>" id=<%=manuId+j%> tabindex=1  validate="Manufacture,string,yes">
				<option value="0">Select</option>
				<%
				for (MasManufacturer masManufacturer :manufacturerList ) {
			%>
					<option value=<%=masManufacturer.getId()%>><%=masManufacturer.getManufacturerName()%></option>
					<%
				}
			%>
			</select></td>
			
			<%if (itemBatch9List.get(k).toString() != null && !itemBatch9List.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemBatch9List.get(k).toString() %>" size="8" tabindex=1 name="<%=BATCH%>" id="<%=batchNoVarTemp+j%>" onblur="fillValuesBalance(<%=temp+j%>);checkBatchNo(this.value,'<%=temp+j%>');"  maxlength="10" tabindex=1 />
			<input type="hidden" size="2" value="emptyString" name="<%=BATCH_NO%>" id="<%=batchNoVar+j%>" /></td>
			<%} %>
			 		<%--  fillDate('<%=temp+j%>');  --%>
			 <td><input type="text" value="" name="manufactureDate" onblur="checkExpiryDate(<%=j%>)" size="8" id="<%=manufactureDateVarTemp+j%>" tabindex=1 validate="manufactureDate,date,no"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufactureDateVarTemp+j%>'),event);" />
			 <input type="hidden" value="<%=date%>" name="<%=RequestConstants.MANUFACTURING_DATE %>" id="<%=manufactureDateVar+j %>" /> </td>
		 <%if (itemExpiry9List.get(k).toString() != null && !itemExpiry9List.get(k).toString().equals("")) {
			 String inputDateStr = itemExpiry9List.get(k).toString();
		     SimpleDateFormat inputFormatter = new SimpleDateFormat("dd-MMM-yyyy");
		     SimpleDateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy");
		     java.util.Date inputDateDate = inputFormatter.parse(inputDateStr);
		    
			 
			 %>	
		
			<td><input type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(inputDateDate) %>" name="expiryDate"  size="8" id="<%=expDateVarTemp+j%>" onblur="checkExpiryDate(<%=j%>)" tabindex=1 validate="expiryDate,date,no"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=expDateVarTemp+j%>'),event);" />
			 <input type="hidden" value="<%=date%>" name="exp" id="<%=expDateVar+j %>" /> </td>
		<%} %>
		<%if (itemQty9List.get(k).toString() != null && !itemQty9List.get(k).toString().equals("")) { %>	
			<td><input type="text" size="8" value="<%=itemQty9List.get(k).toString() %>" name="<%=QTY_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=qtyVarTemp+j%>" validate="Qty,float,no" onblur="fillValuesBalance(<%=j%>);calculateAmount(<%=j %>);" tabindex=1 />
			 <input type="hidden" value="0" name="<%=QTY_BALANCE%>" tabindex="2" id="<%=qtyVar+j%>" /> </td>
		<%} %>	 
			<td><input type="text" size="8" value="" name="<%=UNIT_RATE_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=unitRateVarTemp+j%>" validate="unitRateBalanceTemp,float,no" onblur="fillValuesBalance(<%=j%>);calculateAmount(<%=j %>);checkBeforeSubmit(<%=j %>)" />
			 <input type="hidden" value="0" name="<%=UNIT_RATE_BALANCE%>" tabindex="2" id="<%=unitRateVar+j%>" /> </td>
						
			<td><input type="text" size="8" value="" name="<%=AMOUNT_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=amountVarTemp+j%>" validate="amountBalanceTemp,float,no" onblur="fillValuesBalance(<%=j%>);checkBeforeSubmit(<%=j %>);"  />
					<input type="hidden" value="0" name="<%=AMOUNT_BALANCE%>" tabindex="2" id="<%=amountVar+j%>" alidate="amountBalance,float,no"/></td>
		</tr>					
<%j++;} %>
<%if(!itemBatch10List.get(k).toString().equals("")){ %>
<tr>
			<td><input type="checkbox"  value="" name="<%=SR_NO%>" id="srNoId<%=j %>" class="radioCheck" readonly="readonly" /></td>
			<%if (itemCodeList.get(k).toString() != null && !itemCodeList.get(k).toString().equals("")) { %>
			<td><input type="text" name="<%=ITEM_CODE %>" size="8" value="<%=itemCodeList.get(k).toString() %>" readonly="readonly" id="<%=codeItem+j%>" />
			<%} %>
			<%if(itemIdList.get(k).toString() != null && !itemIdList.get(k).toString().equals("")) { %>
			 <input type="hidden" size="2" value="<%=itemIdList.get(k).toString() %>" class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem+j%>" validate="itemId,int,no"/></td>
			<%} %>
		
		<%if (itemNameList.get(k).toString() != null && !itemNameList.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemNameList.get(k).toString() %>" size="40"  id="<%=nameItem+j%>" onblur="if(fillSrNo(<%=j+temp %>)){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=j+temp %>');}" name="<%=nameItem%>" tabindex=1 />
			<%} %>
			<div id="ac6update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem+j%>','ac6update','stores?method=getItemListForLoanoutByAutocompleteBalance&',{parameters:'requiredField=<%=nameItem%>&balanceId='+document.getElementById('balanceId').value,callback: eventCallback});
				</script></td>
		<%if (itemUnitList.get(k).toString() != null && !itemUnitList.get(k).toString().equals("")) { %>
			<td><input type="text" value="<%=itemUnitList.get(k).toString() %>" size="8" readonly="readonly" name="<%=AV%>" id="<%=idAu+j%>" /></td>
			<%} %>
		 	<td><select name="<%=RequestConstants.MANUFACTURER_ID%>" id=<%=manuId+j%> tabindex=1  validate="Manufacture,string,yes">
				<option value="0">Select</option>
			<%for (MasManufacturer masManufacturer :manufacturerList ) {%>
				<option value=<%=masManufacturer.getId()%>><%=masManufacturer.getManufacturerName()%></option>
			<%}%>
			</select></td>
			<%if (itemBatch10List.get(k).toString() != null && !itemBatch10List.get(k).toString().equals("")) { %>
			<td>
				<input type="text" value="<%=itemBatch10List.get(k).toString() %>" size="8" tabindex=1 name="<%=BATCH%>" id="<%=batchNoVarTemp+j%>" onblur="fillValuesBalance(<%=temp+j%>);checkBatchNo(this.value,'<%=temp+j%>');"  maxlength="10" tabindex=1 />
				<input type="hidden" size="2" value="emptyString" name="<%=BATCH_NO%>" id="<%=batchNoVar+j%>" />
			</td>
			<%} %>
			 <td>
				 <input type="text" value="" name="manufactureDate" onblur="checkExpiryDate(<%=j%>)" size="8" id="<%=manufactureDateVarTemp+j%>" tabindex=1 validate="manufactureDate,date,no"/>
				 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufactureDateVarTemp+j%>'),event);" />
				 <input type="hidden" value="<%=date%>" name="<%=RequestConstants.MANUFACTURING_DATE %>" id="<%=manufactureDateVar+j %>" /> 
			</td>
		 <%if (itemExpiry10List.get(k).toString() != null && !itemExpiry10List.get(k).toString().equals("")) {
			 String inputDateStr = itemExpiry10List.get(k).toString();
		     SimpleDateFormat inputFormatter = new SimpleDateFormat("dd-MMM-yyyy");
		     SimpleDateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy");
		     java.util.Date inputDateDate = inputFormatter.parse(inputDateStr);
			 %>	
			<td><input type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(inputDateDate) %>" name="expiryDate"  size="8" id="<%=expDateVarTemp+j%>" onblur="checkExpiryDate(<%=j%>)" tabindex=1 validate="expiryDate,date,no"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=expDateVarTemp+j%>'),event);" />
			 <input type="hidden" value="<%=date%>" name="exp" id="<%=expDateVar+j %>" /> </td>
		<%} %>
		<%if (itemQty10List.get(k).toString() != null && !itemQty10List.get(k).toString().equals("")) { %>	
			<td><input type="text" size="8" value="<%=itemQty10List.get(k).toString() %>" name="<%=QTY_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=qtyVarTemp+j%>" validate="Qty,float,no" onblur="fillValuesBalance(<%=j%>);calculateAmount(<%=j %>);" tabindex=1 />
			 <input type="hidden" value="0" name="<%=QTY_BALANCE%>" tabindex="2" id="<%=qtyVar+j%>" /> </td>
		<%} %>	 
			<td>
				<input type="text" size="8" value="" name="<%=UNIT_RATE_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=unitRateVarTemp+j%>" validate="unitRateBalanceTemp,float,no" onblur="fillValuesBalance(<%=j%>);calculateAmount(<%=j %>);checkBeforeSubmit(<%=j %>)" />
				<input type="hidden" value="0" name="<%=UNIT_RATE_BALANCE%>" tabindex="2" id="<%=unitRateVar+j%>" /> 
			</td>
			<td>
				<input type="text" size="8" value="" name="<%=AMOUNT_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=amountVarTemp+j%>" validate="amountBalanceTemp,float,no" onblur="fillValuesBalance(<%=j%>);checkBeforeSubmit(<%=j %>);"  />
				<input type="hidden" value="0" name="<%=AMOUNT_BALANCE%>" tabindex="2" id="<%=amountVar+j%>" alidate="amountBalance,float,no"/>
			</td>
 		</tr>
		<%j++;} %>
		<%}}else{%>
		<tr>

	<td><input type="checkbox" value="" name="<%=SR_NO%>" id="srNoId<%=inc %>" class="radioCheck" readonly="readonly" />
		</td>
	<td><input type="text" name="<%=ITEM_CODE %>" size="8" readonly="readonly" id="<%=codeItem+inc%>" />
	 <input type="hidden" size="2" value="0" class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem+inc%>" validate="itemId,int,no"/></td>
	 <script>
				function eventCallback(element, entry){
				//alert("group-=="+document.getElementById('itemGroupId').value);
					return entry + "&itemGroupId=" + document.getElementById('itemGroupId').value+"&itemTypeId="+document.getElementById('itemTypeId').value+"&sectionId="+document.getElementById('sectionId').value+"&categoryId="+document.getElementById('categoryId').value+"&classId="+document.getElementById('classId').value                                                                       
				}
	</script> 
	<td>
		<input type="text" value="" size="30"  id="<%=nameItem+inc%>" onblur="if(fillSrNo(<%=inc+temp %>)){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=inc+temp %>');}" name="<%=nameItem%>" tabindex=1 />
		<div id="ac6update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem+inc%>','ac6update','stores?method=getItemListForLoanoutByAutocompleteBalance',{parameters:'requiredField=<%=nameItem%>&balanceId='+document.getElementById('balanceId').value,callback: eventCallback});
		</script>
	</td>
	<td><input type="text" value="" size="8" readonly="readonly" name="<%=AV%>" id="<%=idAu+inc%>" /></td>
	<%--<td width="10%">
      <select name="<%=RequestConstants.BRAND_ID%>"  id="<%=brandId%>" onchange="getManufacturerNameInAjax(this.value,<%=inc%>);" tabindex=1 >
	  <option value="0">Select</option>
      </select>
      </td> --%>
		<!--
 	    <select name="RequestConstants.MANUFACTURER_ID %>" tabindex=1 id=manuId%> tabindex="1" >
	   	<option value="">--Select Manufacturer--</option>
	   	</select>
	   	-->
 	<td>
 		<input type="text" value="" size="30" class="MasterData" tabindex="1"   name="ManufacturerName" id="<%="Manufacturer_"+inc%>" />
 		<p class="addNew" style="display:none" onclick="addNew(<%=inc %>,'Manufacturer', 'masManufacturer')" id="<%="Manufacturer_addNew"+inc%>">Add New?</p>
		<input type="hidden" name="<%=RequestConstants.MANUFACTURER_ID%>" id="<%="ManufacturerId"+inc%>" value="" />
		<div id="ac6update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('<%="Manufacturer_"+inc%>','ac6update','stores?method=getMasterByAutocomplete',{parameters:'masterName=masManufacturer'});	
		</script>
 		<%-- <select name="<%=RequestConstants.MANUFACTURER_ID%>" id=<%=manuId+inc%> tabindex=1  validate="Manufacture,string,yes">
		<option value="0">Select</option>
		<%for (MasManufacturer masManufacturer :manufacturerList ) {%>
			<option value=<%=masManufacturer.getId()%>><%=masManufacturer.getManufacturerName()%></option>
		<%}%>
		</select> --%>
	</td>
	<td>
		<input type="text" value="" size="30" class="MasterData" tabindex="1" name="BrandName" id="<%="Brand_"+inc%>" />
		<p class="addNew" style="display:none" onclick="addNew(<%=inc %>,'Brand', 'masStoreBrand')" id="<%="Brand_addNew"+inc%>">Add New?</p>
		<input type="hidden" name="brandId" id="<%="BrandId"+inc%>" value="" />
		<div id="ac6update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('<%="Brand_"+inc%>','ac6update','stores?method=getMasterByAutocomplete',{parameters:'masterName=masStoreBrand'});	
		</script>
	</td>
	<td><input type="text" value="" size="20" tabindex=1 name="<%=BATCH%>" id="<%=batchNoVarTemp+inc%>" onblur="fillValuesBalance(<%=temp+inc%>);checkBatchNo(this.value,'<%=temp+inc%>');"  maxlength="10" tabindex=1 />
	<input type="hidden" size="2" value="emptyString" name="<%=BATCH_NO%>" id="<%=batchNoVar+inc%>" /></td>
	 		<%--  fillDate('<%=temp+inc%>');  --%>
	 <td><input type="text" value="" name="manufactureDate" onblur="checkExpiryDate(<%=inc%>)" size="8" id="<%=manufactureDateVarTemp+inc%>" tabindex=1 validate="manufactureDate,date,no"/>
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufactureDateVarTemp+inc%>'),event);" />
	 <input type="hidden" value="<%=date%>" name="<%=RequestConstants.MANUFACTURING_DATE %>" id="<%=manufactureDateVar+inc %>" /> </td>
	 		
	<td><input type="text" value="" name="expiryDate"  size="8" id="<%=expDateVarTemp+inc%>" onblur="checkExpiryDate(<%=inc%>)" tabindex=1 validate="expiryDate,date,no"/>
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=expDateVarTemp+inc%>'),event);" />
	 <input type="hidden" value="<%=date%>" name="exp" id="<%=expDateVar+inc %>" /> </td>

	<td><input type="text" size="8" value="" name="<%=QTY_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=qtyVarTemp+inc%>" validate="Qty,float,no" onblur="fillValuesBalance(<%=inc%>);calculateAmount(<%=inc %>);" tabindex=1 />
	 <input type="hidden" value="0" name="<%=QTY_BALANCE%>" tabindex="2" id="<%=qtyVar+inc%>" /> </td>
	 
	<td><input type="text" size="8" value="" name="<%=UNIT_RATE_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=unitRateVarTemp+inc%>" validate="unitRateBalanceTemp,float,no" onblur="fillValuesBalance(<%=inc%>);calculateAmount(<%=inc %>);checkBeforeSubmit(<%=inc %>)" />
	 <input type="hidden" value="0" name="<%=UNIT_RATE_BALANCE%>" tabindex="2" id="<%=unitRateVar+inc%>" /> </td>
				
	<td><input type="text" size="8" value="" name="<%=AMOUNT_BALANCE_TEMP%>" maxlength="9" tabindex="1" id="<%=amountVarTemp+inc%>" validate="amountBalanceTemp,float,no" onblur="fillValuesBalance(<%=inc%>);checkBeforeSubmit(<%=inc %>);"  />
			<input type="hidden" value="0" name="<%=AMOUNT_BALANCE%>" tabindex="2" id="<%=amountVar+inc%>" alidate="amountBalance,float,no"/></td>
				
				
				<%-- 
 			<td width="10%"><input type="text" size="8" value="" name="mrp"
				maxlength="9" tabindex="1" id="<%=mrp%>" validate="mrp,num,no" /></td>

			<td width="10%"><input type="text" size="8" value=""
				name="dispensingPrice" maxlength="9" tabindex="1"
				id="<%=dispensingPrice%>" validate="dispensing price,num,no" /></td>--%>
 		</tr>
 		<%} %>
 	</tbody>
</table>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<%-- <input type="button" class="button" value="Next"	onclick="if( checkSave()&& checkForNext()&&validateGridData()){submitForm('departmentIndentGrid','stores?method=addNextOrSubmitBalance&buttonName=next');}"	align="right" />--%>
<input type="button" name="sss" align="right"	class="button" value="Submit"	onclick="if( checkSave()&&checkForSubmit()&&validateGridData()){submitForm('departmentIndentGrid','stores?method=rcReceive&buttonName=submit');}" />
<input	type="button" name="Reset" type="submit" value="Reset" 	class="button" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</form>
<script type="text/javascript">vBulletin_init();</script>

<%if(k>0){ %>
		
<input	type="hidden" name="hdb" id="hdb"	value="<%=k %>" />
<%}else{ %>
<input	type="hidden" name="hdb" id="hdb"	value="<%=inc %>" />
<%} %>

<script type="text/javascript">
var manufactArray =new Array();
</script>
<%  int m=0;

for(MasManufacturer masManufacturer:manufacturerList){
%>
<script>

//alert("ss");
manufactArray[<%=m%>]= new Array();
manufactArray[<%=m%>][0] = "<%=masManufacturer.getId()%>";
manufactArray[<%=m%>][1] = "<%=masManufacturer.getManufacturerName()%>";

		</script>
<%m++;} %>
	
	<script type="text/javascript">
	
	function removeRow()
	{
		var tbl = document.getElementById('indentDetails');
		 var tblRows  = tbl.getElementsByTagName("tr");
		
	  	if(tblRows.length-2==0){
	         	alert("Can not delete all rows")
	         	return false;
	     }
		     
	  	for(i=0;i<document.getElementsByName('srno').length;i++)
		{
			
	  		if (document.getElementsByName('srno')[i].checked == true)
			{
			  	tbl.deleteRow(i+1);
			}
		}
	}
	
	function addRow(){
		  var tbl = document.getElementById('indentDetails');
		  var lastRow = tbl.rows.length;
		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var hdb = document.getElementById('hdb');
		  var iteration = parseInt(hdb.value)+1;
		  hdb.value = iteration;

		  var cellRight1 = row.insertCell(0);
		  var e0 = document.createElement('input');
		  e0.type = 'checkBox';
		  e0.name='srno';
		  e0.id='srNoId'+iteration;
		  e0.size='3'
		  e0.className = 'radioCheck'
		  cellRight1.appendChild(e0);

		  var cellRight2 = row.insertCell(1);
		  var e1 = document.createElement('input');
		  e1.type = 'text';
		  e1.name='<%=ITEM_CODE %>';
		  e1.id='<%=codeItem%>'+iteration;
		  e1.size='8'
		  cellRight2.appendChild(e1);

		  var cellRight3 = row.insertCell(2);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.onblur=function(){checkForIndentToDepot(this.value, '<%=nameItem%>',iteration);};
		  e2.name = '<%=nameItem%>';
		  e2.id = '<%=nameItem%>' + iteration;
		  e2.size = '30';
		  var newdiv = document.createElement('div');
		  newdiv.setAttribute('id', 'ac6update'+iteration);
		  newdiv.style.display = 'none';
		  newdiv.className = "autocomplete";
		  cellRight3.appendChild(newdiv);
		  cellRight3.appendChild(e2);
		  new Ajax.Autocompleter('<%=nameItem%>'+iteration,'ac6update','stores?method=getItemListForLoanoutByAutocompleteBalance',{minChars:1,parameters:'requiredField=<%=nameItem%>',callback: eventCallback});

		  var cellRight4 = row.insertCell(3);
		  var e3 = document.createElement('input');
		  e3.type = 'text';
		  e3.name='av';
		  e3.id='idAu'+iteration;
		  e3.size='8'
		  cellRight4.appendChild(e3);
		  
		  var cellRight5 = row.insertCell(4);
		  var e4 = document.createElement('input');
		  e4.name='ManufacturerName';
		  e4.type = 'text';
		  e4.id='Manufacturer_' + iteration;
		  e4.size = 30;
		  e4.tabindex = 1;
		  e4.className = 'MasterData';
		  e4.onblur = function(){dataCheck(this.value, 'Manufacturer_' + iteration);};
		  var e41 = document.createElement('input');
		  e41.type = 'hidden';
		  e41.name = 'manufacturerId';
		  e41.value = '';
		  e41.id = 'ManufacturerId' + iteration;
		  var e42 = document.createElement('p');
		  e42.className = 'addNew';
		  e42.style.display = 'none';
		  e42.innerHTML = 'Add New?';
		  e42.id = 'Manufacturer_addNew' + iteration;
		  e42.onclick = function(){addNew(iteration, 'Manufacturer', 'masManufacturer');};
		  cellRight5.appendChild(e4);
		  cellRight5.appendChild(e41);
		  cellRight5.appendChild(e42);
		  new Ajax.Autocompleter('Manufacturer_'+iteration,'ac6update','stores?method=getMasterByAutocomplete',{parameters:'masterName=masManufacturer'});
		
		  var cellRight51 = row.insertCell(5);
		  var e41 = document.createElement('input');
		  e41.name='BrandName';
		  e41.type = 'text';
		  e41.id='Brand_' + iteration;
		  e41.size = 30;
		  e41.tabindex = 1;
		  e41.className = 'MasterData';
		  e41.onblur = function(){dataCheck(this.value, 'Brand_' + iteration);};
		  var e411 = document.createElement('input');
		  e411.type = 'hidden';
		  e411.name = 'brandId';
		  e411.value = '';
		  e411.id = 'BrandId' + iteration;
		  var e422 = document.createElement('p');
		  e422.className = 'addNew';
		  e422.style.display = 'none';
		  e422.innerHTML = 'Add New?';
		  e422.id = 'Brand_addNew' + iteration;
		  e422.onclick = function(){addNew(iteration, 'Brand', 'masStoreBrand');};
		  cellRight51.appendChild(e41);
		  cellRight51.appendChild(e411);
		  cellRight51.appendChild(e422);
		  new Ajax.Autocompleter('Brand_'+iteration,'ac6update','stores?method=getMasterByAutocomplete',{parameters:'masterName=masStoreBrand'});

		  
		  var cellRight6 = row.insertCell(6);
		  var e5 = document.createElement('input');
		  e5.type = 'text';
		  e5.size='20';
		  e5.name='<%=BATCH%>';
		  e5.id='<%=batchNoVarTemp%>'+iteration
		  cellRight6.appendChild(e5);
		  
		  var e51 = document.createElement('input');
		  e51.type = 'hidden';
		  e51.size='8';
		  e51.name='<%=BATCH_NO%>';
		  e51.id='<%=batchNoVar%>'+iteration
		  cellRight6.appendChild(e51);

		  var cellRight7 = row.insertCell(7);
		  var e6 = document.createElement('input');
		  e6.type = 'text';
		  e6.size='8';
		  e6.name='manufactureDate';
		  e6.setAttribute("readonly", "readonly");
		  e6.id='<%=manufactureDateVarTemp%>'+iteration;
		  cellRight7.appendChild(e6);
		  var eImg = document.createElement('img');
			eImg.src = '/hms/jsp/images/cal.gif';
			eImg.class = 'calender';
			eImg.style.display ='inline';
			eImg.onclick = function(event){
							setdate('',document.getElementById('<%=manufactureDateVarTemp%>'+iteration),event) };
			cellRight7.appendChild(eImg);
			
			 var e61 = document.createElement('input');
			  e61.type = 'hidden';
			  e61.size='8';
			  e61.name='<%=RequestConstants.MANUFACTURING_DATE%>';
			  e61.setAttribute("readonly", "readonly");
			  e61.id='<%=manufactureDateVar%>'+iteration;
			  cellRight7.appendChild(e61);
			
			var cellRight8 = row.insertCell(8);
			  var e7 = document.createElement('input');
			  e7.type = 'text';
			  e7.size='8';
			  e7.name='expiryDate';
			  e7.onblur=function(){checkExpiryDate(iteration)}
			  e7.setAttribute("readonly", "readonly");
			  e7.id='<%=expDateVarTemp%>'+iteration;
			  cellRight8.appendChild(e7);
			  var eImg = document.createElement('img');
				eImg.src = '/hms/jsp/images/cal.gif';
				eImg.class = 'calender';
				eImg.style.display ='inline';
				eImg.onclick = function(event){
								setdate('',document.getElementById('<%=expDateVarTemp%>'+iteration),event) };
				cellRight8.appendChild(eImg);
				
				 var e71 = document.createElement('input');
				  e71.type = 'hidden';
				  e71.size='8';
				  e71.name='exp';
				 // e71.setAttribute("readonly", "readonly");
				  e71.id='<%=expDateVar%>'+iteration;
				  cellRight8.appendChild(e71);
				
		  var cellRight9 = row.insertCell(9);
		  var e8 = document.createElement('input');
		  e8.type = 'text';
		  e8.size='8';
		  e8.name='<%=QTY_BALANCE_TEMP%>';
		  e8.id='<%=qtyVarTemp%>'+iteration
		  cellRight9.appendChild(e8);
		  
		  var e81 = document.createElement('input');
		  e81.type = 'hidden';
		  e81.size='8';
		  e81.name='<%=QTY_BALANCE%>';
		  e81.id='<%=qtyVar%>'+iteration
		  cellRight9.appendChild(e81);
		  
		  var cellRight10 = row.insertCell(10);
		  var e9 = document.createElement('input');
		  e9.type = 'text';
		  e9.size='8';
		  e9.name='<%=UNIT_RATE_BALANCE_TEMP%>';
		  e9.id='<%=unitRateVarTemp%>'+iteration
		  e9.onblur=function(){fillValuesBalance(iteration);calculateAmount(iteration);checkBeforeSubmit(iteration);};
		  cellRight10.appendChild(e9);
		  
		  var e91 = document.createElement('input');
		  e91.type = 'hidden';
		  e91.size='8';
		  e91.name='<%=UNIT_RATE_BALANCE%>';
		  e91.id='<%=unitRateVar%>'+iteration
		 // e91.onblur=function(){fillValuesBalance(iteration);calculateAmount(iteration);checkBeforeSubmit(iteration);};
		  cellRight10.appendChild(e91);
		  
		  var cellRight11 = row.insertCell(11);
		  var e10 = document.createElement('input');
		  e10.type = 'text';
		  e10.size='8';
		  e10.name='<%=AMOUNT_BALANCE_TEMP%>';
		  e10.id='<%=amountVarTemp%>'+iteration
		  cellRight11.appendChild(e10);
		  
		  var e11 = document.createElement('input');
		  e11.type = 'hidden';
		  e11.size='8';
		  e11.name='<%=AMOUNT_BALANCE%>';
		  e11.id='<%=amountVar%>'+iteration
		  cellRight11.appendChild(e11);
		 

		  var e13 = document.createElement('input');
		  e13.type = 'hidden';
		  e13.size='8';
		  e13.name='<%=ITEM_ID%>';
		  e13.id='<%=idItem%>'+iteration
		  cellRight11.appendChild(e13);
		}
	
	
	
	
	function calculateAmount(inc){
		var pageNo =parseInt(document.getElementById('pageNo').value)
		var start=((pageNo-1)*10)+1;
		var end=((pageNo-1)*10)+10;
		var quantity = 0;
		var unitRate = 0;
		var amount = 0;
		if (!isNaN(document.getElementById('qtyVarTemp'+inc).value))
		quantity = parseFloat(document.getElementById('qtyVarTemp'+inc).value);
		
		if (!isNaN(document.getElementById('unitRateVarTemp'+inc).value))
			unitRate = parseFloat(document.getElementById('unitRateVarTemp'+inc).value);
		// Amount Calculation
		
		if (unitRate > 0 && quantity > 0)
		{
			amount = quantity * unitRate;
			document.getElementById('amountVarTemp'+inc).value =  Math.round(amount.toFixed(2));
		}else
		{
			return;
		}

	}


	
 		function checkForFilledRows(){
		 var count = document.getElementById('hdb').value;

			if(count<= 0){
				alert("Please fill at least one row to submit.");
				return false;
			}
			return true;
		}
 		
 		
 		function jsImportForPVMS()
 		{
 			var fname =document.getElementById('uploadFilename').value;
 			if (document.departmentInd.<%=UPLOAD_FILENAME%>.value=="")
 			{
 			alert('Pl. Select the Excel file to Import!.....');
 			return;
 			}
 			var fname = document.departmentInd.<%=UPLOAD_FILENAME%>.value;
 			var st = fname.length;
 			st = st-3;
 			if (fname.substring(st)!="xls")
 			{
 			alert('Only Excel files are Allowed.');
 			return;
 			}
 			//var deptId= document.getElementById('departmentId').value;
 			document.departmentInd.encoding="multipart/form-data";
 				//alert(document.departmentIndentGrid.encoding);
 			var ind = fname.lastIndexOf("\\");
 			var filename = fname.substring(ind+1);
 			//document.departmentIndentGrid.method="post";
 			/* submitForm('departmentInd','stores?method=importPVMSOpeningBalance&filename='+filename,'checkDepartment'); */
 			submitForm('departmentInd','stores?method=importPVMSOpeningBalanceForDisplay&filename='+filename,'checkDepartment');
 		} 	
 		
 		function checkExpiryDate(inc){
 			var exp ="";
 			var manu = "";
 			var expiryDate = "";
 			var manufacturingDate = "";
 			
 			  exp = document.getElementById('expDateVarTemp'+inc).value;
 			  manu = document.getElementById('manufactureDateVarTemp'+inc).value;
		
 			 if(exp!=''){
 				 expiryDate = new Date(exp.substring(6),(exp.substring(3,5) - 1) ,exp.substring(0,2));
 			 }
 			 if(manu!=''){
 				 manufacturingDate = new Date(manu.substring(6),(manu.substring(3,5) - 1) ,manu.substring(0,2));
 			 }
			  currentDate = new Date();
 			 var month = currentDate.getMonth() + 1
 			 var day = currentDate.getDate()
 			 var year = currentDate.getFullYear()
 			 var seperator = "/"
 			 currentDate = new Date(month + seperator + day + seperator + year);
 			
 			 if(expiryDate != ""){
	 			 if(expiryDate < currentDate )
	 			  {
		 			  errorMsg +="Expiry Date Should  be greater than current date.\n"
		 			  alert("Expiry Date Should  be greater than current date")
					  document.getElementById('expDateVarTemp'+inc).value ="";
	 				  return false;
	 			  }
 			  	}

 			 if(manufacturingDate != ""){
 				
	 			 if(manufacturingDate > currentDate )
	 			  {
		 			  errorMsg +="Manufacturing Date Should  be less than current date.\n"
		 			  alert("Manufacturing Date Should  be less than current date")
					  document.getElementById('manufactureDateVarTemp'+inc).value ="";
		 			  return false;
	 			  }
 			  	}
 			 
 			 if(manufacturingDate != "" && expiryDate != "" ){
 	 			 if(expiryDate < manufacturingDate )
 	 			  {
	 	 			  errorMsg +="Expiry Date Should  be greater than Manufacture date.\n"
	 	 			  alert("Expiry Date Should  be greater than Manufacture date")
					  document.getElementById('expDateVarTemp'+inc).value ="";
	 	 			  return false;
 	 			  }
 	 			  	}
 			  return true;
		  
 			}
 		
 		function validateGridData() {
 			//alert("sdfds=="+document.getElementById("hdb").value);
 		
 			var count =  document.getElementById("hdb").value;
 			
 			/* var pageNo = document.getElementById("pageNo").value;
 			var fisrtIndex = 1;
 			var lastIndex = 8;
 			if (pageNo != 1) {
 				fisrtIndex = parseInt(8 * (pageNo - 1)) + parseInt(1);
 				lastIndex = 8 * pageNo;

 			} */
 			
 			for (var inc = 0; inc < count; inc++) {
 				// var mrp=document.getElementById("mrp"+inc).value;
 				// var
 				// dispensingPrice=document.getElementById("dispensingPrice"+inc).value;
 				
 				if(document.getElementById("nameItem" + inc)){
 				
 				
 				var itemName = document.getElementById("nameItem" + inc).value
 				var batchNoVarTemp = document.getElementById("batchNoVarTemp" + inc).value
 				var manufactureDateVarTemp = document.getElementById("manufactureDateVarTemp" + inc).value
 				var expDateVarTemp = document.getElementById("expDateVarTemp" + inc).value
 				var qtyVarTemp = document.getElementById("qtyVarTemp" + inc).value
 				var unitRateVarTemp = document.getElementById("unitRateVarTemp" + inc).value
 				var amountVarTemp = document.getElementById("amountVarTemp" + inc).value
 				/*
 				 * if(mrp==""&&itemName!=""){ alert("pls cheack the mrp in row "+inc);
 				 * document.getElementById("mrp"+inc).focus(); return false; }
 				 * if(dispensingPrice==""&&itemName!=""){ alert("pls cheack the
 				 * dispensingPrice in row "+inc);
 				 * document.getElementById("dispensingPrice"+inc).focus(); return false; }
 				 */
 				if (batchNoVarTemp == "" && itemName != "") {
 					alert("pls cheack the batch No in row " + inc);
 					document.getElementById("batchNoVarTemp" + inc).focus();
 					return false;

 				}
 				if (manufactureDateVarTemp == "" && itemName != "") {
 					alert("pls cheack the Manufature date in row " + inc);
 					document.getElementById("manufactureDateVarTemp" + inc).focus();
 					return false;

 				}
 				/* if (expDateVarTemp == "" && itemName != "") {
 					alert("pls cheack the expiry date in row " + inc);
 					document.getElementById("expDateVarTemp" + inc).focus();
 					return false;

 				} */
 				if (qtyVarTemp == "" && itemName != "") {
 					alert("pls cheack the qty. in row " + inc);
 					document.getElementById("qtyVarTemp" + inc).focus();
 					return false;

 				}
 				if (unitRateVarTemp == "" && itemName != "") {
 					alert("pls cheack the unit rate. in row " + inc);
 					document.getElementById("unitRateVarTemp" + inc).focus();
 					return false;

 				}
 				if (amountVarTemp == "" && itemName != "") {
 					alert("pls cheack the Amount. in row " + inc);
 					document.getElementById("amountVarTemp" + inc).focus();
 					return false;

 				}
 				/*
 				 * if(dispensingPrice>mrp&&itemName!=""){ alert("dispensing price cant
 				 * be greater than Mrp in row "+inc)
 				 * document.getElementById("dispensingPrice"+inc).focus(); return false; }
 				 */

 			}
 			}
 			return true;
 		}

//  For Data Put
    var listSize = parseInt(''+<%=rcList.size()%>);
    var countList = 0;
	if(listSize>0){
		<%for(Object[] ob:rcList){%>
		document.getElementById("nameItem"+countList).value='<%=ob[1]+"["+ob[0]+"]"%>';
		document.getElementById("srNoId"+countList).setAttribute("type", "text");
		document.getElementById("srNoId"+countList).setAttribute("readOnly", "readOnly");
		document.getElementById("srNoId"+countList).style.width='25px';
		document.getElementById("srNoId"+countList).value=countList+1;
		checkForIndentToDepot('<%=ob[1]+"["+ob[0]+"]"%>', 'nameItem', countList);
		document.getElementById("nameItem"+countList).setAttribute("readOnly", "readOnly");
		document.getElementById("qtyVarTemp"+countList).value='<%=ob[2]%>';
		countList = countList+1;
		if(countList<listSize)
			addRow();
		<%}%>
	}
 		
 		
 		
 		
</script>
<%}else{out.write("<span> Not Available.</span>");} %>