<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * storeBalance.jsp
 * Purpose of the JSP -  This is for indentBD.
 * Revision Date:
 * Revision By:
 * @version 1.4
--%>
<%@page import="jkt.hms.masters.business.RcDetails"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.RcDetails"%>
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
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>

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
	List<RcDetails> ipdRcDetailsList = new ArrayList<RcDetails>();
	if(map.get("ipdRcDetailsList") != null){
		ipdRcDetailsList = (List<RcDetails>)map.get("ipdRcDetailsList");
	}
	Object [][]obj=null;
	if(map.get("obj")!=null){
		obj=(Object[][])map.get("obj");
	}
	String msg = "";
	if(map.get("msg") != null){
		msg = (String)map.get("msg");
	}
	List<Object[]> employeeList = new ArrayList<Object[]>();
	if(map.get("employeeList") != null)
	 {
		employeeList =  (List<Object[]>)map.get("employeeList");	  		 
		   
	  }
	

	int userId = 0;
	if(session.getAttribute("userId") != null){
		userId = (Integer)session.getAttribute("userId");
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
<h2>RC Received Entry</h2>
</div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>

<form name="departmentIndentGrid" method="post"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
if(ipdRcDetailsList.size()>0)
{ %>
<div class="Block">
<label>RC No</label><input type="text" readonly="readonly" value="<%=ipdRcDetailsList.get(0).getHeader().getRcNo()%>"/>
<label>RC Date</label><input type="text" readonly="readonly" value="<%=HMSUtil.convertDateToStringTypeDateOnly(ipdRcDetailsList.get(0).getHeader().getRcDate())%>" />

<label>Department Name</label><input type="text" readonly="readonly" value="<%=ipdRcDetailsList.get(0).getHeader().getDepartment().getDepartmentName()%>"/>
<div class="Clear"></div>
<label>Vendor Name</label><input type="text" readonly="readonly" value='<%=ipdRcDetailsList.get(0).getHeader().getSupplier()!=null?ipdRcDetailsList.get(0).getHeader().getSupplier().getSupplierName():""%>'/>
<label> RR Date <span>*</span></label>
<input  type="text" class="input_date"  id="todate-pick" name="rcDate" placeholder="DD/MM/YYYY" validate="Due Date,string,yes" value="<%out.print(date); %>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10" style="width: 127px"/>



<label>Checked By<span>*</span></label>

<select name ="ddlEmployee" id="ddlEmployee" validate="Checked By,string,yes" >
<option value="0">Select</option>
	<%
		if(employeeList.size()>0)
		{
			for(Object[] emp : employeeList)
			{
				%>
					<option value="<%=emp[0]%>"><%=emp[1]%></option>
				<%
			}
		}
	%>
</select>
<%-- <label>From Date</label><input type="text" readonly="readonly" value="<%=HMSUtil.convertDateToStringTypeDateOnly(ipdRcDetailsList.get(0).getHeader().getFromDate())%>" />
<label>To Date</label><input type="text" readonly="readonly" value="<%=HMSUtil.convertDateToStringTypeDateOnly(ipdRcDetailsList.get(0).getHeader().getToDate())%>"  /> --%>
<%-- <label>Status</label><input type="text" readonly="readonly" value="<%=ipdRcDetailsList.get(0).getHeader().getDepartment().getDepartmentName()%>"/> --%>
<div class="Clear"></div>


<label> DC  Date <span>*</span></label>
<input  type="text" class="input_date"  id="todate-pick" name="invoiceDate" placeholder="DD/MM/YYYY" validate="Invoice Date,string,yes" value="<%out.print(date); %>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mprDate');" maxlength="10" style="width: 127px"/>


<label>DC No<span>*</span></label>
<input  size="20" type="text" value=""  validate="DC No,string,yes" id="invoiceNo" name="invoiceNo" maxlength="30" /></td>

<!-- <label>Discount %<span>*</span></label>
<input  size="20" type="text" value="" validate="Discount %,int,yes" onkeypress ="return isNumber(event);"   id="discount" name="discount"  maxlength="10" /></td>
 -->


<!-- <div class="clear" style="height:5px;"></div> -->



<!-- <label> Received Partially</label>
<input id="partiallyReceive" type="checkbox" maxlength="30" value="y" name="partiallyReceive"> -->

 </div> 
 <%} %>
<div class="Block">
<input type="hidden" name="pageNo"	value="<%=pageNo%>" id="pageNo" validate="pageNo,int,no"/>
<input type="hidden" size="2"	value="0" name="<%=NO_OF_ROWS%>" id="<%=NO_OF_ROWS%>" validate="NoOfRows,int,no"/>
<input	type="hidden" name="<%=BALANCE_ID %>" value="<%=balanceId%>"	id="balanceId" validate="balanceId,int,no"/>



<div class="clear"></div>
<div class="clear"></div>
<%-- <div id="pagination">Page No. >> <span><%=pageNo%></span></div>--%>
<div class="clear"></div>
<!-- <h4>Opening Balance details</h4>
<div class="clear"></div>
<input type="button" name="Add" type="submit" class="buttonAdd" value="" onClick="addRow();" />
  <input type="button" name="Delete" type="submit" class="buttonDel" value="" onClick="removeRow();" /> -->
  <div class="clear"></div>
  <div class="clear"></div>
  <div class="clear"></div>
<div class="cmntable">
<table colspan="7" id="indentDetails" border="0" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
 			<th>Select</th>
 			<th>From</th>
			<th>Mat Code</th>
			<th>Item Name</th>
			<th>Unit</th>
			<!--  <td width="10%"><label valign="left" class="smalllabel">Brand Name</label>      </td>-->
			<th>Manufacturer</th>
			<th>Brand</th>
			<th>Batch No./Serial No.</th>
			<th>&nbsp;&nbsp; DOM / DOS &nbsp;&nbsp;</th>
			<th>&nbsp;&nbsp; DOE/DWE &nbsp;&nbsp;</th>
			<th>Ordered Qty.</th>
			<th>Received Qty.</th>
			<th>Rejected Qty.</th>
			<th>Accepted Qty.</th>
			<th>Unit Rate</th>
			<th>Item Value</th>
			<th>Discount(%)</th>
			<th>Discount Amount</th>
			<th>Final Value</th>
			<th width="3%">&nbsp;</th>
			<th width="3%">&nbsp;</th>
 		</tr>
</thead>
<tbody>
	
	<%	int count = 0;
	System.out.println("ipdRcDetailsList"+ipdRcDetailsList.size());
	int supplierId =0;
	int rcId =0;
	double itemValue = 0;
	double costPrize = 0;
	boolean submitFlag = false;
	for(RcDetails ipdRcDetail: ipdRcDetailsList)
		{
		if(ipdRcDetail.getRcStatus().equalsIgnoreCase("P")){
			submitFlag=true;
		++count;
		supplierId = ipdRcDetail.getHeader().getSupplier().getId();
		rcId = ipdRcDetail.getHeader().getId();
		%>
		
		<tr>

	<td><input type="checkbox"  value="<%=ipdRcDetail.getId() %>" name="detailsId<%=count%>" onblur="validate(<%=count%>);" id="detailsId<%=count%>" class="radioCheck"  /></td>
	 <td>
		<input type="text" id="from<%=count%>" value="<%=ipdRcDetail.getFromDepartments()%>"  name="from<%=count%>" readOnly="true" tabindex=1 />
		
	</td>
	<td><input type="text" name="itemCode" readonly="readonly" value="<%=ipdRcDetail.getItem().getPvmsNo()%>" id="itemCode<%=count%>" />
	 <input type="hidden" size="2" value="<%=ipdRcDetail.getItem().getId()%>" class="smcaption" name="itemId<%=count%>" id="itemId<%=count%>" validate="itemId,int,no"/>
	 </td>
	
	 
	<td>
		<input type="text" size="50"  id="itemName<%=count%>" value="<%=ipdRcDetail.getItem().getNomenclature()%>"  name="itemName<%=count%>" readOnly="true" tabindex=1 />
		
	</td>
	<td><input type="text" value="<%=ipdRcDetail.getItem().getItemConversion().getItemUnitName()%>" size="8" readonly="readonly" name="unit<%=count%>" id="unit<%=count%>" /></td>
	
 	<td>
 		<input type="text" value="" size="30" class="MasterData" tabindex="1"   name="ManufacturerName<%=count%>" id="Manufacturer_<%=count%>" />
 		<p class="addNew" style="display:none" onclick="addNew(<%=count %>,'Manufacturer', 'masManufacturer')" id="<%="Manufacturer_addNew"+count%>">Add New?</p>
		<input type="hidden" name="ManufacturerId<%=count%>" id="ManufacturerId<%=count%>" value="" />
		<div id="ac6update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('<%="Manufacturer_"+count%>','ac6update','stores?method=getMasterByAutocomplete',{parameters:'masterName=masManufacturer'});	
		</script>
 	
	</td>
	<td>
		<input type="text" value="" size="30" class="MasterData" tabindex="1" name="BrandName<%=count %>" id="<%="Brand_"+count%>" />
		<p class="addNew" style="display:none" onclick="addNew(<%=count %>,'Brand', 'masStoreBrand')" id="<%="Brand_addNew"+count%>">Add New?</p>
		<input type="hidden" name="BrandId<%=count%>" id="BrandId<%=count%>" value="" />
		<div id="ac6update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('<%="Brand_"+count%>','ac6update','stores?method=getMasterByAutocomplete',{parameters:'masterName=masStoreBrand'});	
		</script>
	</td>
	<td><input type="text" value="" size="20" tabindex=1 name="batch<%=count%>" id="batch<%=count%>" onblur="fillValuesBalance(<%=count%>);checkBatchNo(this.value,'<%=count%>');"  maxlength="10" tabindex=1 />

	 		<%--  fillDate('<%=temp+inc%>');  --%>
	 <td><input type="text" value="" name="manufactureDate<%=count%>" onblur="checkExpiryDate(<%=count%>)" size="8" id="manufactureDate<%=count%>" tabindex=1 validate="Manufacture Date,date,no"/>
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('manufactureDate<%=count%>'),event);" />
	 <input type="hidden" value="<%=date%>" name="manufacturingDate<%=count%>" id="manufacturingDate<%=count%>" /> </td>
	 		
	<td><input type="text" value="" name="expiryDate<%=count%>"  size="8" id="expiryDate<%=count%>" onblur="checkExpiryDate(<%=count%>)" tabindex=1 validate="Expiry Date,date,no"/>
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('expiryDate<%=count%>'),event);" />
	 <input type="hidden" value="<%=date%>" name="exp<%=count%>" id="exp<%=count%>" /> </td>

	<td><input type="text" size="8" value="<%=ipdRcDetail.getFinalQty()%>" name="qtyBalanceTemp<%=count%>" maxlength="9" tabindex="1" id="qtyBalanceTemp<%=count%>" validate="Ordered Qty,float,no" readOnly="true"<%-- onblur="fillValuesBalance(<%=count%>);calculateAmount(<%=count%>);" --%> tabindex=1 />
	 <input type="hidden" value="0" name="qtyBalance<%=count%>" tabindex="2" id="qtyBalance<%=count%>" /> </td>
	 <td><input id="txtReceivedQty<%=count%>" class="medium3" size="20" name="txtReceivedQty<%=count%>" onblur="calculateQty(<%=count%>); calculateAmount(<%=count%>);" onkeypress="return isNumber(event);" type="text">
	 </td>
	 <td>
	 <input id="txtRejectedQty<%=count%>" class="medium3" size="20" name="txtRejectedQty<%=count%>" onblur="calculateQty(<%=count%>); calculateAmount(<%=count%>);" onkeypress="return isNumber(event);" value="0" type="text">
	 </td>
	 <td>
<input id="txtAcceptedQty<%=count%>" class="medium3" size="20" name="txtAcceptedQty<%=count%>" onblur="calculateAmount(<%=count%>)" onkeypress="return isNumber(event);" type="text">
	 </td>
	<td><input type="text" size="8" value="" name="unitRateBalanceTemp<%=count%>" maxlength="9" tabindex="1" id="unitRateBalanceTemp<%=count%>" validate="Unit Rate,float,no" onblur="calculateAmount(<%=count%>);" <%-- onblur="fillValuesBalance(<%=count%>);calculateAmount(<%=count %>);checkBeforeSubmit(<%=count %>)" --%> />
	  </td>
				
	<td><input type="text" size="8" name="unitRateBalance<%=count%>" maxlength="9" tabindex="1" id="unitRateBalance<%=count%>" validate="Item Value,float,no"  />
			<%-- <input type="hidden" value="0" name="<%=AMOUNT_BALANCE%>" tabindex="2" id="<%=count%>" alidate="amountBalance,float,no"/> --%>
			</td>
			<td><input type="text" size="8" name="discount<%=count%>" value = "30" maxlength="9" onblur="calculateAmount(<%=count%>)" tabindex="1" id="discount<%=count%>" validate="Discount Percentage,float,no"  />
			
			</td>
			<td><input type="text" size="8" name="discountAmount<%=count%>" maxlength="9" onblur="calculateAmount(<%=count%>)" tabindex="1" id="discountAmount<%=count%>" validate="Discount Amount,float,no"  />
			
			</td>
			<td><input type="text" size="8" name="finalAmount<%=count%>" maxlength="9" tabindex="1" id="finalAmount<%=count%>" validate="Item Value,float,no"  />
			
			</td>
			<td width="8%"> <input name="Button" type="button" class="buttonAdd" value="" onclick="generateRowIssueCIV(<%=count%>);" /></td>
		<td width="8%"> 	<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('indentDetails','hdb',this);"  tabindex="1" /> 
		
				
				
 		</tr>
 		<%
 		}
		else
		{
			if(ipdRcDetail.getStock()!=null)
			{
				costPrize = ipdRcDetail.getStock().getCostPrice().doubleValue();
			}
			else
			{
				costPrize=0;
			}
			itemValue = (ipdRcDetail.getAcceptedQty().doubleValue() * costPrize);
			
 		%>
 		
 		<tr>

	<td></td>
	 <td>
		<input type="text" id="from" value="<%=ipdRcDetail.getFromDepartments()%>"  name="from" readOnly="true" tabindex=1 />
		
	</td>
	<td><input type="text" size="8" value="<%=ipdRcDetail.getItem().getPvmsNo()%>"  readonly="readonly"  />
	
	 </td>
	 
	<td>
		<input type="text" size="50"   value="<%=ipdRcDetail.getItem().getNomenclature()%>"   readOnly="readonly" tabindex=1 />
		
	</td>
	<td><input type="text" value="<%=ipdRcDetail.getItem().getItemConversion().getItemUnitName()%>" size="8" readonly="readonly"  /></td>
	
 	<td>
 		<input type="text" value="<%=ipdRcDetail.getManufacturer().getManufacturerName()%>" size="30" class="MasterData" tabindex="1"    readonly="readonly" />
 		
 	
	</td>
	<td>
		<input type="text" value="<%=ipdRcDetail.getBrand().getBrandName()%>" size="30" class="MasterData" tabindex="1" readonly="readonly"/>
		
	</td>
	<td><input type="text"  size="20" tabindex=1 maxlength="10" value='<%=ipdRcDetail.getStock()!=null?ipdRcDetail.getStock().getBatchNo():""%>' readonly="readonly"/></td>

	 		
	 <td><input type="text"  size="8" tabindex=1 value='<%=ipdRcDetail.getStock()!=null?HMSUtil.convertDateToStringTypeDateOnly(ipdRcDetail.getStock().getManufactureDate()):""%>' readonly="readonly"/>
	
	 		
	<td><input type="text"    size="8"  tabindex=1 value='<%=ipdRcDetail.getStock()!=null?HMSUtil.convertDateToStringTypeDateOnly(ipdRcDetail.getStock().getExpiryDate()):""%>' readonly="readonly"/>
	 </td>

	<td><input type="text" size="8" value="<%=ipdRcDetail.getRequestedQty()%>"  maxlength="9" tabindex="1"  readOnly="true" readonly="readonly" tabindex=1 />
	</td>
	 <td><input  class="medium3" size="20" value="<%=ipdRcDetail.getReceivedQty()%>" type="text" readonly="readonly"/>
	 </td>
	 <td>
	 <input value="0" type="text" 	value="<%=ipdRcDetail.getRejectedQty()%>" readonly="readonly"/>
	 </td>
	 <td>
<input  type="text" readonly="readonly" value="<%=ipdRcDetail.getAcceptedQty()%>"/>
	 </td>
	<td><input type="text" size="8" value='<%=ipdRcDetail.getStock()!=null?ipdRcDetail.getStock().getCostPrice():""%>' readonly="readonly" />
	  </td>
				
	<td><input type="text" size="8" value="<%=itemValue%>" readonly="readonly"  />
			</td> 
				<td><input type="text" size="8" value="<%=itemValue%>" readonly="readonly"  />
			</td> 
			<td><input type="text" size="8" value="<%=itemValue%>" readonly="readonly"  />
			</td> 
			<td><input type="text" size="8" value="<%=itemValue%>" readonly="readonly"  />
			</td>
			<td>
			</td>
			<td>
			</td>
					
 		</tr>
 		
 		<%}
	}
 		
		%>
 		<input type = "hidden" value="<%=count%>" id="count" name="count"/>
 		<input type = "hidden" value="<%=supplierId%>" name="supplierId"/>
 		<input type = "hidden" value="<%=rcId%>" name="rcId"/>
 	</tbody>
</table>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<%-- <input type="button" class="button" value="Next"	onclick="if( checkSave()&& checkForNext()&&validateGridData()){submitForm('departmentIndentGrid','stores?method=addNextOrSubmitBalance&buttonName=next');}"	align="right" />--%>
<%if(submitFlag)
	{
	%>
	<input type="button" name="sss" align="right"	class="button" value="Submit"	onclick="if(validateCheckBox()){submitForm('departmentIndentGrid','stores?method=submitRCEntry&buttonName=submit');}" />
<input	type="button" name="Reset" type="submit" value="Reset" 	class="button" />
	<%
	}
	
	%>
	<%-- <input type="button" value="PRINT" class="button" onClick="submitForm('departmentIndentGrid','stores?method=submitRCEntry=<%=poId %>');" /> --%>

</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userId%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</form>

<!-- var manufactArray =new Array(); -->
</script>


	
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
 			
 			  exp = document.getElementById('expiryDate'+inc).value;
 			  manu = document.getElementById('manufactureDate'+inc).value;
		
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
					  document.getElementById('expiryDate'+inc).value ="";
	 				  return false;
	 			  }
 			  	}

 			 if(manufacturingDate != ""){
 				
	 			 if(manufacturingDate > currentDate )
	 			  {
		 			  errorMsg +="Manufacturing Date Should  be less than current date.\n"
		 			  alert("Manufacturing Date Should  be less than current date")
					  document.getElementById('manufactureDate'+inc).value ="";
		 			  return false;
	 			  }
 			  	}
 			 
 			 if(manufacturingDate != "" && expiryDate != "" ){
 	 			 if(expiryDate < manufacturingDate )
 	 			  {
	 	 			  errorMsg +="Expiry Date Should  be greater than Manufacture date.\n"
	 	 			  alert("Expiry Date Should  be greater than Manufacture date")
					  document.getElementById('expiryDate'+inc).value ="";
	 	 			  return false;
 	 			  }
 	 			  	}
 			
 			 if(manufacturingDate != "" && expiryDate != "" ){
 				 var oldDate = new Date();
 				var newDate = new Date(oldDate.toDateString());
 				var oneDay = 24*60*60*1000;
 				var diffDays = Math.round(Math.abs((expiryDate.getTime() - manufacturingDate.getTime())/(oneDay)));
 	 			var diffDaysFromCurrentDate = Math.round(Math.abs(((newDate).getTime() - expiryDate.getTime())/(oneDay)));
 	 			
 	 			 if(diffDaysFromCurrentDate < (diffDays/2) )
 	 			  {
	 	 			  alert("Medicine has less than 50% of self life");	 	 			
					  /* document.getElementById('expiryDate'+inc).value =""; */
	 	 			  return false;
 	 			  }
 	 			  	}
 			  return true;
		  
 			}
 		

 		
        
        function calculateAmount(inc){
        
            var quantity = 0;
            var unitRate = 0;
            var amount = 0;
            var discount = 0;
            var discountAmount = 0;
            var finalAmount = 0;
            
            if (!isNaN(document.getElementById('txtAcceptedQty'+inc).value))
            quantity = parseFloat(document.getElementById('txtAcceptedQty'+inc).value);
            
            if (!isNaN(document.getElementById('unitRateBalanceTemp'+inc).value))
                unitRate = parseFloat(document.getElementById('unitRateBalanceTemp'+inc).value);
            // Amount Calculation
          
            if (!isNaN(document.getElementById('discount'+inc).value))
                discount = parseFloat(document.getElementById('discount'+inc).value);
            
          
            if (unitRate > 0 && quantity > 0)
            {
                amount = quantity * unitRate;
               
                document.getElementById('unitRateBalance'+inc).value = amount;
                /* document.getElementById('unitRateBalance'+inc).value =  Math.round(amount.toFixed(2)); */
                if(discount > 0)
                	{
                	discountAmount =amount*discount/100;
                	finalAmount = amount-discountAmount;
                	document.getElementById('discountAmount'+inc).value = discountAmount;
                	document.getElementById('finalAmount'+inc).value = finalAmount;
                	}
            }else
            {
            
                return;
            }

        }
        
        
        function calculateQty(inc)
        {
            if (!isNaN(document.getElementById('qtyBalanceTemp'+inc).value))
                {
                    var OrderedQty = document.getElementById('qtyBalanceTemp'+inc).value
                    OrderedQty =OrderedQty *1;
                    var ReceivedQty = document.getElementById('txtReceivedQty'+inc).value
                    ReceivedQty =ReceivedQty *1;
                    var RejectedQty = document.getElementById('txtRejectedQty'+inc).value
                    RejectedQty= RejectedQty *1;
                    
                    var AcceptedQty = document.getElementById('txtAcceptedQty'+inc).value
                    AcceptedQty= AcceptedQty *1;
                    
                  /*   if(ReceivedQty>OrderedQty)
                        {
                            alert("Received Qty can not be greater than Ordered Qty");
                            document.getElementById('txtReceivedQty'+inc).value="";
                            return;
                        } */
                    
                    if(RejectedQty>OrderedQty || RejectedQty>ReceivedQty)
                    {
                        alert("Rejected Qty can not be greater.");
                        document.getElementById('txtRejectedQty'+inc).value="";
                        calculateAmount(inc);
                        return;
                    }
                    
                    if(RejectedQty>OrderedQty || RejectedQty>ReceivedQty)
                    {
                        alert("Rejected Qty can not be greater.");
                        document.getElementById('txtRejectedQty'+inc).value="";
                        calculateAmount(inc);
                        return;
                    }
                    
                    if(AcceptedQty>ReceivedQty)
                    {
                        alert("Accepted Qty can not be greater.");
                        document.getElementById('txtRejectedQty'+inc).value="";
                        calculateAmount(inc);
                        return;
                    }
                    
                    var AcceptedQty = ReceivedQty-RejectedQty;
                    document.getElementById('txtAcceptedQty'+inc).value=AcceptedQty;
                    
                }
        }
        function validate(count)
        {
        	
        	if(document.getElementById("detailsId"+count).checked)
        		{
        		document.getElementById("batch"+count).setAttribute("validate","Batch No, string, yes");
        		document.getElementById("manufactureDate"+count).setAttribute("validate","Manufacture Date,date,yes");
        		document.getElementById("expiryDate"+count).setAttribute("validate","Expiry Date,date,yes");
        		document.getElementById("qtyBalanceTemp"+count).setAttribute("validate","Ordered Qty,float,yes");
        		document.getElementById("txtReceivedQty"+count).setAttribute("validate","Received Qty,float,yes");
        		/* document.getElementById("txtRejectedQty"+count).setAttribute("validate","Rejected Qty,float,yes"); */
        		document.getElementById("txtAcceptedQty"+count).setAttribute("validate","Accepted Qty,float,yes");
        		document.getElementById("unitRateBalanceTemp"+count).setAttribute("validate","Unit rate,float,yes");
        		document.getElementById("unitRateBalance"+count).setAttribute("validate","Item value,float,yes");
        		document.getElementById("Manufacturer_"+count).setAttribute("validate","Manufacturer,string,yes");
        		document.getElementById("Brand_"+count).setAttribute("validate","Brand,string,yes");
        		
        		}
        	else
        		{
        		document.getElementById("batch"+count).setAttribute("validate","Batch No, string, no");
        		document.getElementById("manufactureDate"+count).setAttribute("validate","Manufacture Date,date,no");
        		document.getElementById("expiryDate"+count).setAttribute("validate","Expiry Date,date,no");
        		document.getElementById("qtyBalanceTemp"+count).setAttribute("validate","Ordered Qty,float,no");
        		document.getElementById("txtReceivedQty"+count).setAttribute("validate","Received Qty,float,no");
        		/* document.getElementById("txtRejectedQty"+count).setAttribute("validate","Rejected Qty,float,no"); */
        		document.getElementById("txtAcceptedQty"+count).setAttribute("validate","Accepted Qty,float,no");
        		document.getElementById("unitRateBalanceTemp"+count).setAttribute("validate","Unit rate,float,no");
        		document.getElementById("unitRateBalance"+count).setAttribute("validate","Item value,float,no");
        		document.getElementById("Manufacturer_"+count).setAttribute("validate","Manufacturer,string,no");
        		document.getElementById("Brand_"+count).setAttribute("validate","Brand,string,no");
        		}
        }
        function validateCheckBox()
        {
        	var count = parseInt(document.getElementById("count").value);
        	var flag = false;
        	for(var i=1; i<=count; i++)
        		{
        		if(document.getElementById("detailsId"+i).checked)
        			{
        			flag=true;
        			}
        		}
        	if(!flag)
        		{
        		alert("Please select at least one checkbox");        	
        		}
        	
        	return flag;
        }
        function generateRowIssueCIV(rowVal)
        {
        	  var tbl = document.getElementById('indentDetails');
        	  var lastRow = tbl.rows.length;
        	
        	  var count=document.getElementById('count').value;
        
        	  var iteration = lastRow;
        	  var row = tbl.insertRow(lastRow);
        	
        	  var cellRight0 = row.insertCell(0);
        	  var e0 = document.createElement('input');
        	  e0.type = 'checkbox';
        	  e0.className = "radioCheck" ;
        	  e0.id='detailsId'+iteration;
        	  e0.name='detailsId'+iteration;        	 
        	  e0.value=document.getElementById('detailsId'+rowVal).value;
        	  cellRight0.appendChild(e0);


        	  var cellRight1 = row.insertCell(1);
        	  var e1 = document.createElement('input');
        	  e1.type = 'text';
        	  e1.name='from'+iteration;
        	  e1.id = 'from'+iteration;
        	  
        	  e1.value=document.getElementById('from'+rowVal).value;
        	  e1.readOnly=true;
        	  cellRight1.appendChild(e1);
        	  
        	  
        	  var cellRight2 = row.insertCell(2);
        	  var e2 = document.createElement('input');
        	  e2.type = 'text';
        	  e2.name='itemCode'+iteration;
        	  e2.id = 'itemCode'+iteration;
        	 
        	  
        	  e2.value=document.getElementById('itemCode'+rowVal).value;
        	  e2.readOnly=true;
        	  var e21 = document.createElement('input');
        	  e21.type = 'hidden';
        	  e21.name='itemId'+iteration;
        	  e21.id = 'itemId'+iteration;
        	  e21.value=document.getElementById('itemId'+rowVal).value;
        	  cellRight2.appendChild(e2);
        	  cellRight2.appendChild(e21);

        	

        	  var cellRight3 = row.insertCell(3);
        	  var e3 = document.createElement('input');
        	  e3.type = 'text';
        	  e3.value=document.getElementById('itemName'+rowVal).value;

        	  e3.name = 'itemName' + iteration;
        	  e3.id = 'itemName' + iteration;
        	  e3.size = '50';
        	  cellRight3.appendChild(e3);
        	  
        	        
        	  var cellRight4 = row.insertCell(4);
        	  var e4 = document.createElement('input');
        	  e4.type = 'text';
        	  e4.name = 'unit' + iteration;
        	  e4.id = 'unit' + iteration;
        	  e4.size = '8';
        	  e4.value=document.getElementById('unit'+rowVal).value;
        	  e4.readOnly=true;
        	  cellRight4.appendChild(e4);

        			
        	  var cellRight5 = row.insertCell(5);
        	  var e5 = document.createElement('input');
        	  e5.type = 'text';
        	  e5.size = '30';
        	  e5.className = 'MasterData';
        	  e5.autocomplete = 'off';
        	  e5.name = 'ManufacturerName' + iteration;
        	  e5.id = 'Manufacturer_' + iteration;
        	  
        	 
        	    cellRight5.appendChild(e5);
        	  
        		var newP = document.createElement('p');
          	    newP.id='Manufacturer_addNew'+iteration;
          	    newP.className='addNew';
            	newP.style.display = 'none';
            	newP.onclick =  function(){addNew(iteration,'Manufacturer', 'masManufacturer')}; 
            	newP.textContent="Add New?";
            	
            	cellRight5.appendChild(newP);
            	
            	var e51 = document.createElement('input');
          	  e51.type = 'hidden';
          	  e51.name = 'ManufacturerId' + iteration;
          	  e51.id = 'ManufacturerId' + iteration;
          	
          	    cellRight5.appendChild(e51);
          	
            	var newdiv = document.createElement('div');
          	    newdiv.id='ac6update';
          	    newdiv.className='autocomplete';
            	newdiv.style.display = 'none';
            	
            	cellRight5.appendChild(newdiv);    
            	
            	new Ajax.Autocompleter('Manufacturer_'+iteration,'ac6update','stores?method=getMasterByAutocomplete',{parameters:'masterName=masManufacturer'});	
       
            	 

        	
        	  
                   
        	  var cellRight6 = row.insertCell(6);
        	  var e6 = document.createElement('input');
        	  e6.type = 'text';
        	  e6.name = 'BrandName' + iteration;
        	  e6.size = '30';
        	  e5.className = 'MasterData';
        	  e5.autocomplete = 'off';
        	  e6.id = 'Brand_' + iteration;
        	  
        	  cellRight6.appendChild(e6);
        	  
        	  var newPB = document.createElement('p');
        	  newPB.id='Brand_addNew'+iteration;
        	  newPB.className='addNew';
        	  newPB.style.display = 'none';
        	  newPB.onclick =  function(){addNew(iteration,'Brand', 'masStoreBrand')}; 	          	
          	  cellRight6.appendChild(newPB);
          	
          	var e61 = document.createElement('input');
        	  e61.type = 'hidden';
        	  e61.name = 'BrandId' + iteration;
        	  e61.id = 'BrandId' + iteration;
        	
        	  cellRight6.appendChild(e61);
        	
          	var newdivB = document.createElement('div');
          	newdivB.id='ac6update';
          	newdivB.className='autocomplete';
          	newdivB.style.display = 'none';
          	
          	new Ajax.Autocompleter('Brand_'+iteration,'ac6update','stores?method=getMasterByAutocomplete',{parameters:'masterName=masStoreBrand'});	
     
          	cellRight6.appendChild(newdivB);     

      	

                    
          	  var cellRight7 = row.insertCell(7);
        	  var e7 = document.createElement('input');
        	  e7.type = 'text';
        	  e7.name = 'batch' + iteration;
        	  e7.id = 'batch' + iteration;
        	  
        	  cellRight7.appendChild(e7);
        		 
        /* 

          var e242 = document.createElement('input');
          e242.type = 'hidden';
          e242.name = 'batchId' + iteration;
          e242.id = 'batchId' + iteration;
          e242.size = '10';
        	  
        	  var e24 = document.createElement('input');
        	  e24.type = 'hidden';
        	  e24.name = 'brandId' + iteration;
        	  e24.id = 'brandId' + iteration;
        	  e24.size = '10';
        	  cellRight23.appendChild(e23);
        	  cellRight23.appendChild(e24);
        	  cellRight23.appendChild(e242);
 */
        	  var cellRight8 = row.insertCell(8);
        	  var e8 = document.createElement('input');
        	  e8.type = 'text';
        	  e8.name = 'manufactureDate' + iteration;
        	  e8.id = 'manufactureDate' + iteration;
        	  e8.size = '8';
        	   
        	  e8.validate = "Manufacture Date,date,no";
        	  e8.onblur = function(){checkExpiryDate(iteration);};
        	  cellRight8.appendChild(e8);
        	  
        	  var e81 = document.createElement('img');
        	  e81.src="/hms/jsp/images/cal.gif";
        	  e81.border="0";
        	  e81.height="16";
        	  e81.width="16";
        	  e81.className="calender";	 
        	  e81.validate = "Manufacture Date,date,no";        	  
        	  e81.onClick=function(){setdate(<%=currentDate%>,document.getElementById('manufactureDate'+iteration),this);};
        		  cellRight8.appendChild(e81);
        	  
        	  var e82 = document.createElement('input');
        	  e82.type = 'hidden';
        	  e82.name = 'manufacturingDate' + iteration;
        	  e82.id = 'manufacturingDate' + iteration;
        	  e82.size = '8';
        	           	  
        	  e82.value="<%=date%>";
        	  cellRight8.appendChild(e82);
        	 
        	         	  
  
        		
        	  
        	  var cellRight9 = row.insertCell(9);
        	  var e9 = document.createElement('input');
        	  e9.type = 'text';
        	  e9.name = 'expiryDate' + iteration;
        	  e9.id = 'expiryDate' + iteration;
        	  e9.size = '8';        	 
        	  cellRight9.appendChild(e9);

        	  var e91 = document.createElement('img');
        	  e91.src="/hms/jsp/images/cal.gif";
        	  e91.border="0";
        	  e91.height="16";
        	  e91.width="16";
        	  e91.className="calender";	 
        	  e91.validate = "Expiry Date,date,no";        	  
        	  e91.onClick=function(){setdate(<%=currentDate%>,document.getElementById('expiryDate'+iteration),this);};
        		  cellRight9.appendChild(e91);
        	  
        	  var e92 = document.createElement('input');
        	  e92.type = 'hidden';
        	  e92.name = 'exp' + iteration;
        	  e92.id = 'exp' + iteration;
        	  e92.size = '8';
        	           	  
        	  e92.value="<%=date%>";
        	  cellRight9.appendChild(e92);
        	 
        	  var cellRight10 = row.insertCell(10);
        	  var e10 = document.createElement('input');
        	  e10.type = 'text';
        	  e10.name = 'qtyBalanceTemp' + iteration;
        	  e10.id = 'qtyBalanceTemp' + iteration;
        	  e10.size = '8';
        	  e10.value=document.getElementById('qtyBalanceTemp'+rowVal).value;
        	 
        	  e10.readOnly=true;	  
        	  cellRight10.appendChild(e10);
        	  
        	  
        	  var cellRight11 = row.insertCell(11);
        	  var e11 = document.createElement('input');
        	  e11.type = 'text';
        	  e11.name = 'txtReceivedQty' + iteration;
        	  e11.onblur = function(){calculateQty(iteration); calculateAmount(iteration);};
        	  e11.onkeypress=function(){return isNumber(event);};
        	  e11.id = 'txtReceivedQty' + iteration;
        	  
        	 
        	  cellRight11.appendChild(e11);



        	  var cellRight12 = row.insertCell(12);
        	  var e12 = document.createElement('input');
        	  e12.type = 'text';
        	  e12.name = 'txtRejectedQty' + iteration;
        	  e12.id = 'txtRejectedQty' + iteration;
        	  e12.value = '0';
        	  e12.onblur = function(){calculateQty(iteration); calculateAmount(iteration);};
        	  e12.onkeypress=function(){return isNumber(event);};
        	  cellRight12.appendChild(e12);

        	  var cellRight13 = row.insertCell(13);
        	  var e13 = document.createElement('input');
        	  e13.type = 'text';
        	  e13.name = 'txtAcceptedQty' + iteration;
        	  e13.id = 'txtAcceptedQty' + iteration;
        	  e13.onblur = function(){calculateAmount(iteration);};
        	  e13.onkeypress=function(){return isNumber(event);};
        	  cellRight13.appendChild(e13);

        	
        	  var cellRight14 = row.insertCell(14);
        	  var e14 = document.createElement('input');
        	  e14.type = 'text';
        	  e14.name = 'unitRateBalanceTemp' + iteration;
        	  e14.id = 'unitRateBalanceTemp' + iteration;
        	  e14.size = '8';
        	  e14.onblur = function(){calculateAmount(iteration);};
        	  e14.onkeypress=function(){return isNumber(event);};
        	  cellRight14.appendChild(e14); 

        	  var cellRight15 = row.insertCell(15);
        	  var e15 = document.createElement('input');
        	  e15.type = 'text';
        	  e15.name = 'unitRateBalance' + iteration;
        	  e15.id = 'unitRateBalance' + iteration;
        	  e15.onblur = function(){calculateAmount(iteration);};
        	  e15.onkeypress=function(){return isNumber(event);};
        	  e15.size = '8';
        	  
        	  cellRight15.appendChild(e15); 

        	  var cellRight16 = row.insertCell(16);
        	  var e16 = document.createElement('input');
        	  e16.type = 'text';
        	  e16.name = 'discount' + iteration;
        	  e16.id = 'discount' + iteration;
        	  e16.onblur = function(){calculateAmount(iteration);};
        	  e16.onkeypress=function(){return isNumber(event);};
        	  e16.value=document.getElementById('discount'+rowVal).value;
        	  e16.size = '8';
        	  cellRight16.appendChild(e16);

        	
        	  var cellRight17 = row.insertCell(17);
        	  var e17 = document.createElement('input');
        	  e17.type = 'text';
        	  e17.name = 'discountAmount' + iteration;
        	  e17.id = 'discountAmount' + iteration;
        	  e17.onblur = function(){calculateAmount(iteration);};
        	  e17.onkeypress=function(){return isNumber(event);};
        	  e17.size = '8';
        	  /* e35.onblur = function(){checkQty(iteration)}; */
        	  cellRight17.appendChild(e17); 

        	  var cellRight18 = row.insertCell(18);
        	  var e18 = document.createElement('input');
        	  e18.type = 'text';
        	  e18.name = 'finalAmount' + iteration;
        	  e18.id = 'finalAmount' + iteration;
        	  e18.size = '8';
        	  e18.readOnly=true;
        	  cellRight18.appendChild(e18);
        	  
        /* 	  if(document.getElementById('qtyIssued'+rowVal).value=="")
        	  {	  
        	   e34.value=parseInt(document.getElementById('qtyRequested'+rowVal).value);
        	  }else{
        		  e34.value=parseInt(document.getElementById('qtyRequested'+rowVal).value)-parseInt(document.getElementById('qtyIssued'+rowVal).value);
        		  document.getElementById('qtyRequested'+rowVal).value=parseInt(document.getElementById('qtyIssued'+rowVal).value);
        	  }
        	   
        	   cellRight34.appendChild(e34); */


        	  var cellRight19 = row.insertCell(19);
        	  var e19 = document.createElement('input');
        	  e19.type = 'button';
        	  e19.name='remarks'+iteration;
        	  e19.className = 'buttonAdd';
        	  e19.setAttribute('tabindex', 1);
        	  e19.onclick= function(){generateRowIssueCIV(iteration)};
        	  cellRight19.appendChild(e19);
        	  
        	  var cellRight20 = row.insertCell(20);
        	  var e20 = document.createElement('input');
        	  e20.type = 'button';
        	  e20.className = 'buttonDel';
        	  e20.name='remarks'+iteration;
        	 // 19.setAttribute('onClick', 'removeRow("issueDispensaryForm","hdb",this);'); 
        	  e20.onclick= function(){removeRow("indentDetails","hdb",this)};
        	  e20.setAttribute('tabindex','1');
        	  cellRight20.appendChild(e20);
        	   
        	  
        	 document.getElementById('count').value=(parseInt(count)+1);
        }
        
        function removeRow(idName,countId,obj)
        {
        	//alert(countId)
        	//alert(idName)
        	//alert(obj)
          var tbl = document.getElementById(idName);
        	//alert(tbl)
          var lastRow = tbl.rows.length;
          
          if (lastRow > 2){
          //	tbl.deleteRow(lastRow - 1);
            var i=obj.parentNode.parentNode.rowIndex;
            tbl.deleteRow(i);
            document.getElementById('count').value=parseInt(document.getElementById('count').value)-1;
            
          }
        }
       
</script>
