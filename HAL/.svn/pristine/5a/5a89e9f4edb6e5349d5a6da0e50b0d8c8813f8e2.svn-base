<%@page import="java.util.*"%>
<%@page	import="static jkt.hms.util.RequestConstants.*,java.math.BigDecimal"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueM"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreInternalReturnM"%>
<script type="text/javascript" src="/hms/jsp/js/autocomplete.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">

var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);


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
<script type="text/javascript">


//javed khan
/*  function checkForReturnDispensary1(val,a,inc)
{
	   if(!validateMetaCharacters(this.value)
			   {
	   			 ajaxFunctionForAutoCompleteInReturn1('returnSearch','stores?method=fillItemsForDefectiveDrugs&pvmsNo=' + val , inc);
			   }
	   else
		
		   return false; 
		  
		
} 
 */
//javed khan
function checkForReturnDispensary(val,a,inc)
{
	
		//var pageNo =parseInt(document.getElementById('pageNo').value) 
		//var start=((pageNo-1)*8)+1;
    	//var end=((pageNo-1)*8)+8;
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
		   
	   // alert("checkForDefectiveDrugs"+pvms);
	  
	    ajaxFunctionForAutoCompleteInReturn('returnSearch','stores?method=fillItemsForDrugDisposal&pvmsNo=' + pvms , inc);
	  
		
}

//javed khan

  function getExpiryDateByAjax(batchId,rowVal,id){
		  
	if(batchId != 0)
		{
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

		      	for (loop = 0; loop < items.childNodes.length; loop++) {
			   	    var item = items.childNodes[loop];
			        var expiryDate  = item.getElementsByTagName("expiryDate")[0];
			        var manufacturingDate=item.getElementsByTagName("manuDate")[0];
			      
			        if(manufacturingDate.childNodes[0].nodeValue != 'NA')
			        document.getElementById('manuDate'+rowVal).value = manufacturingDate.childNodes[0].nodeValue
			        var mId  = item.getElementsByTagName("mId")[0];
			        if(expiryDate.childNodes[0].nodeValue != 'NA')
		        	document.getElementById('expiryDate'+rowVal).value = expiryDate.childNodes[0].nodeValue
		        	
		        	
		        	var stock = item.getElementsByTagName("stock")[0];
		        	//alert(stock);
		        	document.getElementById('stockAvailable'+rowVal).value = stock.childNodes[0].nodeValue

		        	var brand = item.getElementsByTagName("brand")[0];
		        	document.getElementById('brandName'+rowVal).value = brand.childNodes[0].nodeValue
		        	
		        	
		          	} 
		      }
		    }
		     url="stores?method=getExpiryDateForReturnDispensary&batchId="+batchId;
		    xmlHttp.open("GET",url,true);
		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(null);
		}
	else
		{
		
		    document.getElementById('manuDate'+rowVal).value = "";
		       
	     	document.getElementById('expiryDate'+rowVal).value = "";
	     	
	     	document.getElementById('stockAvailable'+rowVal).value = "";
	     	
	     	document.getElementById('brandName'+rowVal).value = "";
		}
  
    
 }



  // javed  for  retrun dispensary
  function ajaxFunctionForAutoCompleteInReturn1(formName,action,rowVal) {
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
       
       	
       	var batchId="batchId"+rowVal;
 		      
 		obj = document.getElementById(batchId);
 		obj.length = 1;
       
 				
       	for (loop = 0; loop < items.childNodes.length; loop++) {
 	   	    var item = items.childNodes[loop];
 	   	    var nomen = item.getElementsByTagName("nomen")[0];
 	        var id  = item.getElementsByTagName("id")[0];
 	        var pvms  = item.getElementsByTagName("pvms")[0];
 	        var au  = item.getElementsByTagName("au")[0];
 	        var name  = item.getElementsByTagName("name")[0];
 	        var brandLength  = item.getElementsByTagName("brands")[0];
 	         var batchLength  = item.getElementsByTagName("batchsForTurn")[0];
         
         	//alert("nomen.childNodes[0].nodeValue "+nomen.childNodes[0].nodeValue);
         	
         	document.getElementById('itemId'+rowVal).value = id.childNodes[0].nodeValue
         	document.getElementById('pvmsNo'+rowVal).value = pvms.childNodes[0].nodeValue
         	//document.getElementById('nomenclature'+rowVal).value = name.childNodes[0].nodeValue
         	document.getElementById('au'+rowVal).value = au.childNodes[0].nodeValue
         	//document.getElementById('batchNo'+rowVal).value = batchno.childNodes[0].nodeValue
         	//document.getElementById('expiryDate'+rowVal).value = expirydate.childNodes[0].nodeValue 
         	//document.getElementById('stockId'+rowVal).value = BatchStockId.childNodes[0].nodeValue 
         	document.getElementById('nomenclature'+rowVal).value = nomen.childNodes[0].nodeValue+"["+pvms.childNodes[0].nodeValue+"]"
         	//alert(batchLength.childNodes.length);
         	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
         	{
         		var batch = batchLength.childNodes[innerLoop];
 	        	var batchId  = batch.getElementsByTagName("batchIdForTurn")[0];
 	        	var batchName  = batch.getElementsByTagName("batchNameForTurn")[0];
 	        	obj.length++;
 				obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
 				obj.options[obj.length-1].text=batchName.childNodes[0].nodeValue;
 				//alert(batchId.childNodes[0].nodeValue+"  "+batchName.childNodes[0].nodeValue);
         	}
        
         
         		
       	} 
       }
     }
     var url=action+"&"+getNameAndData(formName)
      
     xmlHttp.open("GET",url,true);
     xmlHttp.setRequestHeader("Content-Type", "text/xml");
     xmlHttp.send(null);
     
     
   }
  
  function ajaxFunctionForAutoCompleteInReturn(formName,action,rowVal) {
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
	      
	      	
	      	var batchId="batchId"+rowVal;
			      
			obj = document.getElementById(batchId);
			obj.length = 1;
	      
					
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		        var name  = item.getElementsByTagName("name")[0];
		        var brandLength  = item.getElementsByTagName("brands")[0];
		         var batchLength  = item.getElementsByTagName("batchsForTurn")[0];
	        
	        	
	        	
	        	document.getElementById('itemId'+rowVal).value = id.childNodes[0].nodeValue
	        	document.getElementById('pvmsNo'+rowVal).value = pvms.childNodes[0].nodeValue
	        	//document.getElementById('nomenclature'+rowVal).value = name.childNodes[0].nodeValue
	        	document.getElementById('au'+rowVal).value = au.childNodes[0].nodeValue
	        	//document.getElementById('batchNo'+rowVal).value = batchno.childNodes[0].nodeValue
	        	//document.getElementById('expiryDate'+rowVal).value = expirydate.childNodes[0].nodeValue 
	        	//document.getElementById('stockId'+rowVal).value = BatchStockId.childNodes[0].nodeValue 
	        	
	        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
	        	{
	        		var batch = batchLength.childNodes[innerLoop];
		        	var batchId  = batch.getElementsByTagName("batchIdForTurn")[0];
		        	var batchName  = batch.getElementsByTagName("batchNameForTurn")[0];
		        	obj.length++;
					obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=batchName.childNodes[0].nodeValue;
		        	
	        	}
	       
	        
	        		
	      	} 
	      }
	    }
	    /*var url=action+"&"+getNameAndData(formName)*/
	    var url=action;
	     
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	    
	  }

function checkForVendorReturn(inc){
	    var val=document.getElementById('nomenclature'+inc).value
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;
	    for(i=1;i<=8;i++){
	   
	    if(val !="")
	    if(document.getElementById('nomenclature'+i).value==val){
	    if(document.getElementById('nomenclature'+inc).value!=val){
	    	alert("Item already selected...!")
	    	document.getElementById('nomenclature'+inc).value=""
	    
	    	return false;
	    	}
	    }
}
		ajaxFunctionForDepartmentReturn('returnSearch','stores?method=fillItemsForIndentToVendorReturn&brandName=' +  val , inc);
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
		var errorMessage="";
		
		if(document.getElementById('referenceNo').value == "")
		errorMessage=errorMessage+"Please fill referenceNo  \n"; 
		
		if(document.getElementById('toWard').value == 0)
		errorMessage=errorMessage+"Please Select To Deparment \n";
		
		if(document.getElementById('returnBy').value == 0)
		errorMessage=errorMessage+"Please select return By \n";
		
		if(document.getElementById('receiveBy').value == 0)
		errorMessage=errorMessage+"Please selct Received By \n";
		
		if(document.getElementById('remarks').innerHTML =="")
		errorMessage=errorMessage+"Please fill remarks \n";
		
		if(document.getElementById('reason').innerHTML == "")
		errorMessage=errorMessage+"Please fill reason \n";
	
	if((document.getElementById('referenceNo').value != "")  &&(document.getElementById('toWard').value != "") && (document.getElementById('returnBy').value != 0)&&(document.getElementById('receiveBy').value != 0)&&(document.getElementById('reason').innerHTML != "") &&	(document.getElementById('remarks').innerHTML != "")){
		return true;
	}else{
		alert(errorMessage)
		return false
	}
}


function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=printReturnFromDispensaryJsp";
  obj.submit();
}
</script>
<%
String expiryDate="expiryDate";
String manuDate="manuDate";
int pageNo=1;
	int storeFyDocumentNoId = 0;
	Map map = new HashMap();
	String buttonFlag="";
	
    
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("stores.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	//int departmentIdForReturnFromDispensary = Integer.parseInt(properties.getProperty("departmentIdForReturnFromDispensary"));
	
	int deptId = 0 ;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String timeInHHmm="";
	String [] tempArr = null;
	tempArr = time.split(":");
	for (int i = 0 ; i < tempArr.length-1 ; i++) {
		
		timeInHHmm=timeInHHmm+(String)tempArr[i];
    	 if(i==0)
    	 {
    		 timeInHHmm=timeInHHmm+":";
    	 }
	}
	
	if(map.get("buttonFlag") != null)
	{
		buttonFlag=(String)map.get("buttonFlag");
	}
	if(map.get("pageNo") != null)
	{
		pageNo=(Integer)map.get("pageNo");
	}
	
	if(map.get("deptId") != null)
	{
		deptId=(Integer)map.get("deptId");
		System.out.println("deptartment id in  list jsp==="+deptId);
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	String fromDateToDate=(String)map.get("fromDateToDate");
	
	List listOfItemsInStock=new ArrayList();
	List brandList= new ArrayList();
	List returnNoList= new ArrayList();
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	try {
		if(map.get("listOfItemsInStock") != null){
			listOfItemsInStock=(List)map.get("listOfItemsInStock");
		}
		if (map.get("deptList") != null) {
			deptList = (List)map.get("deptList");
		}
		if (map.get("brandList") != null) {
			brandList = (List)map.get("brandList");
		}
		if (map.get("returnNoList") != null) {
			returnNoList = (List)map.get("returnNoList");
		}
		if (map.get("employeeList") != null) {
			employeeList = (List<MasEmployee>)map.get("employeeList");
		}
		if(map.get("storeFyDocumentNoId") != null){
			storeFyDocumentNoId = (Integer)map.get("storeFyDocumentNoId");
		}
	} catch (Exception exp) {
		exp.printStackTrace();
	}
  %>



<!-- 
<div class="titleBg">

<h2>Return to Store</h2> </div>-->
<div class="clear"></div>
<!-- </form> -->
<!--<form name="search" method="post">
<div id="testDiv"> -->
<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" />
<!--  code to make the search panel -->
<!-- 
<div class="search" id="threadsearch" >
<a href=""></a> 
<script type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
 -->
 
 
 
 <div id="searchBlock" style="display:none;">
 
<form name="depCiv" method="post" action="">
<!--<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">-->
<div class="clear"></div>
<h6>SEARCH</h6>

<div class="clear"></div>
<div class="Block">
<form name="" method="">
<div class="clear"></div>
<div class="clear"></div>
 
 <!-- 
<form name="search" method="post">
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
 -->
 <input	type="hidden" name="do" value="process" /> 
 <input type="hidden" name="searchthread" value="1" /> 
 <input type="hidden" name="showposts" value="1" /> 
 <input type="hidden" name="searchthreadid" value="85875" />
 <!-- 
 <label>From Date </label> 
 <input type="text" name="<%=FROM_DATE%>" id="fromDate" value="<%=date %>" class="date" validate="From Date,dateOfAdmission,no" MAXLENGTH="30" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'fromDate')" /> 
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=date%>',document.depCiv.<%=FROM_DATE%>,event)" />
  <label>To Date </label> 
 <input type="text" name="<%=TO_DATE%>" id="toDate" value="<%=date %>" class="date"	validate="To Date,dateOfAdmission,no" MAXLENGTH="30" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'toDate')"/> 
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=date%>',document.depCiv.<%=TO_DATE%>,event)" />
  <div class="clear"></div>
  -->
  <label>Return No.</label> 
 <select name="<%=ISSUE_RETURN_ID%>">
 			<option value="0">Select</option>
			<%
				
						Iterator iterator = returnNoList.iterator();
			   			 while(iterator.hasNext()){
			    			StoreInternalReturnM mObj = (StoreInternalReturnM) iterator.next();
			    			
						%>
			<option value=<%=mObj.getId()%>><%=mObj.getReturnNo()%></option>

			<%
						
			  		  }	
					%>
		</select> 
		<!-- 
		<input type="image" class="button" value=""
			onClick="submitForm('search','stores?method=searchReturnToDispensary&pageNo=<%=pageNo-1%>&deptId=<%=deptId%>&buttonFlag=<%=buttonFlag%>');" />
			 -->
			 <input type="button" name="sss" class="button" value="SEARCH" onClick="if(validateMetaCharacters(this.value)){submitForm('depCiv','stores?method=searchReturnToDispensary&pageNo=<%=pageNo-1%>&deptId=<%=deptId%>&buttonFlag=<%=buttonFlag%>')};" />
			 <input type="button" name="sss" class="button" value="Print" onClick="if(validateMetaCharacters(this.value)){submitForm('depCiv','stores?method=printDepartmentReturnJsp&deptId=<%=deptId%>')};" />
</form>
</div>
</form>

</div>
<div class="clear"></div>
<form name="returnSearch" method="post">
<!--  code to make the search panel -->
<%
	String returnNo = "";
	
	if(map.get("finalReturnNo") != null){
		returnNo = (String)map.get("finalReturnNo");
	}else if(map.get("returnNo") != null){
		returnNo = (String)map.get("returnNo");
	}
		
	%>
<input type="hidden"  name="<%=RETURN_NO %>"	id="returnNo" value="<%= returnNo%>" readonly="readonly" validate="Return No ,String,yes" tabindex=1 />
<div class="clear"></div>
<div class="titlebg">
<h2>Department Return</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>Return No.  </label>
<label class="value ">&nbsp;<%=returnNo %></label>
<label>Return Date </label>
<input type="text"	name="<%=RETURN_DATE%>" id="returnDate" value="<%=date %>"	class="calDate" validate="Return Date,dateOfAdmission,yes" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=date%>',document.returnSearch.<%=RETURN_DATE%>,event)" />
<!--  <label><span>*</span> Reference No.</label>-->
<input type="hidden"  id="referenceNo" name="<%=REFERENCE_NO %>" value="" validate="Reference No ,String,yes"	tabindex=1 />
<label>To Department<span>*</span></label>
<select name="<%=TO_WARD %>" id="toWard" validate="To Department ,String,yes">
	<option value="0">Select</option>
	<%
		
		Iterator itrDeptTo=deptList.iterator();
	    while(itrDeptTo.hasNext()){
	    	MasDepartment masDepartment= (MasDepartment) itrDeptTo.next();
	    	String deptName=masDepartment.getDepartmentName();
	    	int idFromList=masDepartment.getId();
			//if (deptId==idFromList) { 
			
			%>
	<!-- <option value=<%=masDepartment.getId()%> selected><%=masDepartment.getDepartmentName()%></option> -->
	<% //} else {  %>
	<option value=<%=masDepartment.getId()%>><%=masDepartment.getDepartmentName()%></option>
	<% //} %>
	<%
		
	  }	
	%>
</select> 
<input type="hidden" name="<%=FROM_WARD %>" id="fromWard"	value="<%=deptId%>">
<div class="clear"></div>
<label> Returned By<span>*</span></label>
<select	name="<%=RETURN_BY_ID %>" id="returnBy" validate="Return By,String,yes">
	<option value="0">Select</option>
	<%
	for (MasEmployee masEmployee : employeeList) {
	%>
	<option value="<%=masEmployee.getId() %>"><%out.print(masEmployee.getFirstName()!=null?masEmployee.getFirstName():"");%> <%out.print(masEmployee.getLastName()!=null?masEmployee.getLastName():"");%></option>
	<%
	}
	%>
</select>

<%-- <label> Received By<span>*</span></label>
<select name="<%=RECEIVED_BY_ID %>" id="receiveBy" validate="Received By ,String,yes">
	<option value="0">Select</option>
	<%
	for (MasEmployee masEmployee : employeeList) {
	%>
	<option value="<%=masEmployee.getId() %>"><%out.print(masEmployee.getFirstName()!=null?masEmployee.getFirstName():"");%> <%out.print(masEmployee.getLastName()!=null?masEmployee.getLastName():"");%></option>
	<%
	}
	%>
</select> 
 --%>
<label>Reason</label>
<textarea value=""	name="<%=REASON %>" id="reason" validate="Reason ,String,no" tabindex=1	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"	maxlength="250" />
 </textarea>
 <!--  
 
<label>Remarks</label>
<textarea value=""	name="<%=REMARKS %>" id="remarks" validate="Remarks ,String,no"	tabindex=1 onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"	maxlength="250" />
 </textarea> -->
<input type="hidden" id="returnNo" value="<%= returnNo%>" readonly />
<input type="hidden" name="storeFyDocumentNoId" id="storeFyDocumentNoId" value="<%=storeFyDocumentNoId %>" />
</div>

<div class="clear"></div>


<!-- if(checkForNext()){submitForm('wardConsumption','ipd?method=showWardConsumptionJsp&buttonFlag=next');} -->
<input type="hidden" size="2" value="" name="noOfRecords" id="noOfRows" />
<!-- <input type="hidden" name="<%=STORE_ITEM_BATCH_STOCK_ID %>" value="" id="hdb" /> -->
<input type="hidden" value="<%= deptId%>" name="deptId" id="deptId" />
<div class="clear"></div>
<!-- <input type="button" class="button" value="Submit"	onclick="submitForm('returnSearch','stores?method=submitReturnDispensaryDetails','checkSave');" /> -->
<div class="clear paddingTop15"></div>
<h4>Details</h4> 
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<!--<jsp:include page="searchResultPO.jsp" />-->
<div class="clear"></div>
<div id="searchtable"></div>
<div class="cmntable">  
<table  colspan="7" id="stockDetails" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="5%">Sl</br>No.</th>
			<th width="10%">Mat Code</th>
			<th width="10%">Nomenclature</th>
			<th width="16%">A/U</th>
			<th width="10%">Barcode</th>
			<th width="16%">Batch No.</th>
			<th width="16%">DOM</th>
			<th width="16%">DOE</th>
			<th width="16%">Brand</th>
			<th width="16%">Available</br>Stock</th>
			<th width="16%">Qty</br>Returned</th>
			<th width="16%">Add</th>
			<th width="16%">Delete</th>

		</tr>
	</thead>
	<tbody>
		<%
    	String batchId="batchId";
		String batchId2="batchId";

    	int detailCounter=8; 
    	int temp=0;
    	int count=0;
    	    	
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=1;inc++){
     		batchId = batchId2+(""+inc);
     %>
		<tr>
			<td><input type="text" size="1" value="<%=temp+inc%>"
				name="<%=SR_NO%>" readonly="readonly" /></td>
			<td>
			<input type="text" name="pvmsNo1<%=inc%>" size="8"  id="pvmsNo<%=inc%>" value="" onblur="checkForReturnDispensary1(this.value, 'pvmsNo1','<%=inc%>');"/> 
	
			<input type="hidden" name="itemId<%=inc%>" id="itemId<%=inc %>" value="" /> 
			<input type="hidden" name="date" id="date" value="<%=date %>" /> 
				<input type="hidden" name="time" id="time" value="<%=time %>" /> 
				<input type="hidden" value="" name="storeItemBatchStockId" id="stockId<%=inc %>" />
				 <input type="hidden" value="0" name="costprice" id="costprice<%=inc%>" />
			<input type="hidden" value="0" name="amount" id="amount<%=inc%>" />
			<input type="hidden" value="<%=inc%>" name="counter" id="counter<%=inc%>" />
			</td>
           <!--  <td width="10%"><input type="text" value=""	id="nomenclature<%=inc%>" size="40"	name="<%=NOMENCLATURE%>" onblur="if(fillSrNo('<%=inc %>')){checkForVendorReturn('<%=inc %>');}" />-->
           <td>
            <input type="text" value=""  size="50" name="<%=NOMENCLATURE%><%=inc%>" id="nomenclature<%=inc%>" onblur="checkForReturnDispensary(this.value, '<%=NOMENCLATURE%>','<%=inc%>');"/>
			<div id="ac2update"	style="display: none;"  class="autocomplete"></div>
			 <script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('nomenclature<%=inc%>','ac2update','stores?method=getItemListForDepartmentReturn',{parameters:'requiredField=<%=NOMENCLATURE%><%=inc%>&returnId='+document.getElementById('returnNo').value });
			</script>
			<!-- <script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('nomenclature<%=inc%>','ac2update','stores?method=getItemListForDefectiveDrugsByAutocomplete',{parameters:'requiredField=<%=NOMENCLATURE%>'});
			</script>-->
			</td>
			<td width="16%"><input type="text" value="" size="6" name="aU<%=inc%>" id="au<%=inc%>" value="" readonly /></td>
			
			
			<td width="9%">
			    <input type="text" name="bar<%=inc%>" id="bar"	size="12" onBlur="getExpiryDateByAjax(this.value,<%=inc%>,document.getElementById('itemId<%=inc %>').value);" tabindex="1">
				
			</td>
			<!-- <td width="16%"><input type="text" value="" size="12" name="batchNo" id="batchNo<%=inc%>" value="" readonly /></td>-->
			
				<td>
			    <select name="<%=BATCH_ID%><%=inc%>"  id="<%=batchId%>"	class="small3"  validate="Batch No,String,yes" onchange="getExpiryDateByAjax(this.value,<%=inc%>,document.getElementById('itemId<%=inc %>').value);" tabindex="1">
				<option value="0" >Select</option>
				<input type="hidden" value="" size="10" name="brand<%=inc%>" id="brand<%=inc%>"  value="" readonly />
			</select>
			
			</td>
			
			<td>
			<input type="text" value=""	name="<%=MANUFACTURING_DATE%><%=inc%>" size="12" id="<%=manuDate +""+inc %>" MAXLENGTH="30" tabindex="1" readonly="readonly" tabindex="1"/>
			<!-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=date%>',document.getElementById('<%=manuDate+""+inc%>'),event);" />
			-->
			</td>

			<td>
			<input type="text" value=""	name="<%=EXPIRY_DATE%><%=inc%>" size="12" id="<%=expiryDate +""+inc %>" MAXLENGTH="30" tabindex="1" readonly="readonly" tabindex="1"/>
			<!--  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=date%>',document.getElementById('<%=expiryDate+""+inc%>'),event);" />
			-->
			</td>
				<td><input type="text" value=""  size="20" name="brandName<%=inc%>" id="brandName<%=inc%>" />
				</td>
				<td>
			<input type="text" size="10" value="" id="stockAvailable<%=inc%>"
				  readonly /> </td>
				
			</td>
				<td><input type="text" value=""  size="10" name="issueQty<%=inc%>" id="qtyIssued<%=inc%>"  onblur="checkQty(<%=inc%>)" validate="Returned Qty,string,yes" />
				</td>
				<td>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
			</td>
			<td>
			<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('stockDetails','hdb',this);" tabindex="1" />
			</td>
		</tr>
		<%
     	}
     
     %>
	</tbody>
	<input type="hidden" name="hdb" value="1" id="hdb" />
</table>
</div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Submit"	onclick="submitForm('returnSearch','stores?method=submitReturnDispensaryDetails');" />
<!-- <input type="button" class="button" value="Next" onclick="if(checkForNext()){submitForm('returnSearch','stores?method=showReturnFromDispensaryJsp&buttonFlag=next&pageNo=<%=pageNo%>&returnNo=<%=returnNo%>&deptId=<%=deptId%>&storeFyDocumentNoId=<%=storeFyDocumentNoId %>');}" align="right" /> 
<!-- <input type="button" class="button" value="Delete"	onclick="openPopupForDelete(1,'<%=returnNo%>');" align="right" /> 
<input type="button" name="print" type="submit" class="button"	value="Print" onClick="showReport('returnSearch');"/>-->
<input type="button" name="sss" class="button" value="Search And Print" onclick="getSearchBlock();" /> 
<input type="button" name="sss" class="button" value="Reset" onclick="submitFormForButton('returnSearch','stores?method=showReturnFromDispensaryJsp');" />
<div class="clear"></div>
<div class="division"></div>
</form>
<script type="text/javascript">


// javed khan

function civDisplay() {
	var civNo = document.depCiv.<%=DEMAND_NO%>.value	
	if (civNo == "0")
	{
	alert('Pl. select Return No.');
	return;
	}
	
	document.depCiv.method="post";
	'stores?method=searchReturnToDispensary&pageNo=<%=pageNo-1%>&deptId=<%=deptId%>&buttonFlag=<%=buttonFlag%>'
	submitForm('depCiv','stores?method=getDepartmentIssueData&<%=DEMAND_NO%>='+civNo);
}

function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
}



function fillItemsInGrid(brandId,rowVal,deptId){
	var err = "";
	var referenceNo = document.getElementById('referenceNo').value
	var toWard = document.getElementById('toWard').value
	var returnBy = document.getElementById('returnBy').value
	var receiveBy = document.getElementById('receiveBy').value
	
		for(var i=0;i<nameArray.length;i++){
		if(nameArray[i][5]==brandId){
			document.getElementById('pvmsNo'+rowVal).value=nameArray[i][1]
			document.getElementById('itemId'+rowVal).value=nameArray[i][2]
			document.getElementById('nomenclature'+rowVal).value=nameArray[i][6]
			document.getElementById('noOfRows').value=rowVal+1;
			
			}
		}
		if(referenceNo == ""){
			err += "Please Enter Reference Number. \n";
		}
		if(toWard == 0){
			err += "Please Enter To Department. \n";
		}
		if(returnBy == 0){
			err += "Please select Return By. \n";
		}
		if(receiveBy == 0){
			err += "Please select Received By.";
		}
		
		if(referenceNo != "" && toWard != 0 && returnBy != 0 && receiveBy != 0){
			if(err == ""){
				openPopup(brandId,deptId,rowVal);
			}
		}else{
			alert(err);
		}
}	
	
	
	function openPopup(brandId,deptId,rowVal){
		var url="/hms/hms/stores?method=showStockDetailsForReturnDispensary&brandId="+brandId+"&deptId="+deptId+"&rowVal="+rowVal;
        popwindow(url);
     }
	function popwindow(url)
	{
		 newwindow=window.open(url,'name',"height=400,width=950,status=1");
    }
	function checkForNext(){
		//alert("noOfRow "+document.getElementById('noOfRows').value)
	  if(document.getElementById('noOfRows').value<8)
	  {
	  	alert("All rows are not filled.Please Select the Brand Names to Enter ")
	  	return false;
	  }else{
	  return true;
	  }
  }
  
	function openPopupForDelete(brandId,returnNo){
		var url="/hms/hms/stores?method=showDeleteReturnFromDispensary&brandId="+brandId+"&returnNo="+returnNo;
        popwindowForDelete(url);
     }
	function popwindowForDelete(url)
	{
		// newwindow=window.open(url,'name',"height=500,width=700,status=1, scrollbars=yes ");
		 newwindow=window.open(url,'name','status=yes,resizable,scrollbars=1,height=400,width=1000,');
    }

// add  javed khan
function addRow(){
  
	  var tbl = document.getElementById('stockDetails');
	 
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size = '1';
	  e0.name='<%=SR_NO%>';
	  e0.readOnly=true;
	  e0.value=iteration;
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='pvmsNo1'+iteration;
	  e1.id='pvmsNo'+iteration
	  e1.onblur=function(){checkForReturnDispensary1(this.value, document.getElementById('pvmsNo'+iteration).value,iteration)}
	  e1.size='8';
	  e1.setAttribute('tabindex','1');
	 // e1.onblur=function(){readOnlyNomenclature(this.value,iteration)};
	  cellRight1.appendChild(e1);

	  var sel11 = document.createElement('input');
	  sel11.type = 'hidden';
	  sel11.name='itemId'+iteration;
	  sel11.id='itemId'+iteration
	  sel11.size = '10';
	  sel11.setAttribute('tabindex','1');
	  cellRight1.appendChild(sel11);
	  
	  
	//  alert("1---");
	  var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	 
	 // e0.innerHTML = iteration+':'
	//  alert("2---");
	e2.name = 'Nomenclature' + iteration;
	  e2.id = 'nomenclature' + iteration;
	  e2.onblur=function(){checkForReturnDispensary(this.value, document.getElementById('nomenclature'+iteration).value,iteration)}
	  var newdiv = document.createElement('div');
  	newdiv.setAttribute('id', 'ac2update'+iteration);
  	newdiv.setAttribute('class', 'autocomplete');
   	newdiv.style.display = 'none';
	
  e2.size = '50';
	//  alert("3-1--");
	  e2.setAttribute('tabindex','1');
	//  alert("3-2--");
	            cellRight2.appendChild(newdiv);
	  cellRight2.appendChild(e2);
	  e2.focus();
	
	//  alert("3--3-"+iteration);
	 new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'stores?method=getItemListForDepartmentReturn',{parameters:'requiredField=Nomenclature'+iteration});
	   //alert("name--"+e0.name)
 //alert("4---");
	    
	//  alert("5---");
	
	 var cellRight3 = row.insertCell(3);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.name='au'+iteration;
	  e11.id='au'+iteration
	  e11.size='6';
	  e11.setAttribute('tabindex','1');
	  //e11.onblur=function(){readOnlyNomenclature(this.value,iteration)};
	  cellRight3.appendChild(e11);
	  
	  

	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='pvmsNo'+iteration;
	  sel.id='pvmsNo'+iteration
	  sel.size = '5';
	  sel.setAttribute('tabindex','1');
	  cellRight3.appendChild(sel);
	
	 
	  var cellRight5 = row.insertCell(4);
	  var e21 = document.createElement('input');
	  e21.name='bar'+iteration;
	  e21.id='bar'+iteration;
	  //e21.classname='smalllabel';
	 // e21.setAttribute('tabindex','1');
	  e21.size = '9';
	  e21.onBlur=function(){getExpiryDateByAjax(this.value,iteration,document.getElementById('itemId'+iteration).value)};
	  cellRight5.appendChild(e21);
	 
	 
	 
	 
	  var cellRight51 = row.insertCell(5);
	  var e215 = document.createElement('Select');
	  e215.name='batchId'+iteration;
	  e215.id='batchId'+iteration;
	
	  e215.className='small3';
	 // e21.setAttribute('tabindex','1');
	  e215.options[0] = new Option('Select', '0');
	  e215.onchange=function(){getExpiryDateByAjax(this.value,iteration,document.getElementById('itemId'+iteration).value)};
	  e215.setAttribute('validate','Batch No,string,yes');
	  cellRight51.appendChild(e215);
	  



	   

	  var cellRight611 = row.insertCell(6);
	  var e51 = document.createElement('input');
	  e51.type = 'text';
	  e51.className='date';
	  e51.name='manuDate'+iteration;
	  e51.id='manuDate'+iteration;
	  e51.size='12';
	  e51.setAttribute('maxlength', 10); 
	  e51.setAttribute('tabindex','1');
	  cellRight611.appendChild(e51);
	  

	  var cellRight61 = row.insertCell(7);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.className='date';
	  e5.name='expiryDate'+iteration;
	  e5.id='expiryDate'+iteration;
	  e5.size='12';
	  e5.setAttribute('maxlength', 10); 
	  e5.setAttribute('tabindex','1');
	  cellRight61.appendChild(e5);

	  var cellRight612 = row.insertCell(8);
	  var e512 = document.createElement('input');
	  e512.type = 'text';
	  e512.className='date';
	  e512.name='brandName'+iteration;
	  e512.id='brandName'+iteration;
	  e512.size='20';
	  e512.setAttribute('maxlength', 10); 
	  e512.setAttribute('tabindex','1');
	  cellRight612.appendChild(e512);

/*

	 // var cellRight311 = row.insertCell(6);
		 var e311 = document.createElement('img');
	     e311.src = '/hms/jsp/images/cal.gif';
	    // e3.style.display ='none';
	     e311.id = 'calId'+iteration;
	     e311.onclick = function(event){
	     setdate('',document.getElementById('expiryDate'+iteration),event) };
	     cellRight61.appendChild(e311);
		 */


		 var cellRight612 = row.insertCell(9);
		  var e612 = document.createElement('input');
		  e612.type = 'text';
		  e612.name = 'stockAvailable' + iteration;
		  e612.id = 'stockAvailable' + iteration;
		  e612.size = '10';
		  //e6.value=document.getElementById('stockAvailable'+rowVal).value;
		  e612.readOnly=true;
		  cellRight612.appendChild(e612);
		  
	  var cellRight6 = row.insertCell(10);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='issueQty'+iteration;
	  e4.id='qtyIssued'+iteration;
	  e4.size='10';
	  e4.setAttribute('maxlength', 3); 
	  e4.setAttribute('tabindex','1');
	  e4.setAttribute('validate','noOfDays,int,yes');
	  e4.onblur = function(){checkQty(iteration)};
	  e4.setAttribute('validate','Returned Qty,string,yes');
	  cellRight6.appendChild(e4);

	  var e5 = document.createElement('input');
	  e5.type = 'hidden';
	  e5.name='total'+iteration;
	  e5.id='total'+iteration;
	  e5.size='5';
	  e5.setAttribute('tabindex','1');
	  cellRight6.appendChild(e5);




	  var cellRight10 = row.insertCell(11);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonAdd';
	  e8.name='remarks'+iteration;
	  e8.setAttribute('onClick', 'addRow();'); 
	  e8.setAttribute('tabindex','1');
	  cellRight10.appendChild(e8);

	  var cellRight11 = row.insertCell(12);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonDel';
	  e9.name='remarks'+iteration;
	  e9.setAttribute('onClick', 'removeRow("stockDetails","hdb",this);'); 
	  e9.setAttribute('tabindex','1');
	  cellRight11.appendChild(e9);

	 
	  
	   //added - fayaz
	//  var cellRight9 = row.insertCell(9);
   //   var e9 = document.createElement('input');
 //     e9.id = 'a'
 //     e9.type = 'checkbox';
  //    cellRight9.appendChild(e9);


	  

	}


function removeRow(idName,countId,obj)
{
  var tbl = document.getElementById(idName);
  
  var lastRow = tbl.rows.length;
  if (lastRow > 2){
  //	tbl.deleteRow(lastRow - 1);
    var i=obj.parentNode.parentNode.rowIndex;
    tbl.deleteRow(i);
  }
}

function checkQty(rowVal)
{	
		if(parseInt(document.getElementById('qtyIssued'+rowVal).value) <= parseInt(document.getElementById('stockAvailable'+rowVal).value))
		{
			//var a=document.getElementById('qtyIssued'+rowVal).value;
			//var b=document.getElementById('batchStock'+rowVal).value;
    		//document.getElementById("qtyAftrIssued"+rowVal).value=b-a;
			return true;
		}else if(parseInt(document.getElementById('qtyIssued'+rowVal).value) > parseInt(document.getElementById('stockAvailable'+rowVal).value)){
			alert("Qty Retured  can't be greater than Qty Available.");
			document.getElementById('qtyIssued'+rowVal).value="";
			document.getElementById("qtyIssued"+rowVal).focus();
			return false;
		}
		
		return true;
}

    	
</script>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>

<input type="hidden" name="rows" id="rr" value="1" />

