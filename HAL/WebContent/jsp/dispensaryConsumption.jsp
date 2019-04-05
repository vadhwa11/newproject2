<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreOpPatientIssueM"%>
<%@page import="jkt.hms.masters.business.StoreOpPatientIssueT"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>


<script type="text/javascript">
 var nameArray=new Array();
 var codeArray=new Array();
</script>

<script>
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
<%
		Map map = new HashMap();
		Box box = HMSUtil.getBox(request);
		String opdIssueno = "";
		String search = "n";
		int pageNo=1;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currDate = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		List<MasEmployee> empList= new ArrayList<MasEmployee>();
		List<StoreOpPatientIssueM> opPatientIssueList = new ArrayList<StoreOpPatientIssueM>();
		List<StoreOpPatientIssueT> opPatientIssueTList = new ArrayList<StoreOpPatientIssueT>();
		List<StoreOpPatientIssueM> opPatientIssueMList = new ArrayList<StoreOpPatientIssueM>();
		
		String buttonFlag="";
		
		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		int deptId=0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if(map.get("empList") != null)
		{
			empList=(List)map.get("empList");
		}
		if(map.get("opPatientIssueList") != null)
		{
			opPatientIssueList=(List)map.get("opPatientIssueList");
		}
		if(map.get("opPatientIssueMList") != null)
		{
			opPatientIssueMList=(List)map.get("opPatientIssueMList");
		}
		if(map.get("opPatientIssueTList") != null)
		{
			opPatientIssueTList=(List)map.get("opPatientIssueTList");
		}
	//	System.out.println(":::::::::ssss:::::::::::::::::"+opPatientIssueTList.size());
		
		if(map.get("pageNo") != null)
		{
			pageNo=(Integer)map.get("pageNo");
		}
		if(map.get("opdIssueno") != null)
		{
			opdIssueno=(String)map.get("opdIssueno");
		}
		if(map.get("search") != null)
		{
			search=(String)map.get("search");
		}
		int employeeId = 0;
		int issueId = 0;
		
		if(map.get("opPatientIssueMList") != null){
			opPatientIssueMList=(List)map.get("opPatientIssueMList");
			if (opPatientIssueMList!=null && opPatientIssueMList.size() >0)
			{
				if(opPatientIssueMList.get(0).getEmp() != null){
				employeeId = opPatientIssueMList.get(0).getEmp().getId();
				}
				box.put(RequestConstants.PRESCRIPTION_NO,opPatientIssueMList.get(0).getPrescriptionNo());
				box.put("issueId",opPatientIssueMList.get(0).getId());
			}
		}
	%>
<script type="text/javascript">
	function resetForm()
	{
	  window.location.href = "stores?method=showDispensaryComsumptionJsp";
	}
	function fillItemsInGrid(itemId,rowVal,deptId){
			document.getElementById('empId').value=document.getElementById('consultant').value;
			document.getElementById('prescription').value=document.getElementById('prescriptionNo').value;
		//	var lotNo=document.getElementById('lotNo'+rowVal)
		//	lotNo.disabled = true
		//	var combo=document.getElementById('nomenclature'+rowVal);
		//		combo.disabled=true
	}	
	
	function fillItemsInGridForLotNo(lotNo,rowVal,deptId,formName)
	{
		var bool="false";
		for(var i=0;i<nameArray.length;i++){
		
		if(nameArray[i][4]==lotNo){
			 bool="true";
			
			alert("nameArray[i][6]=="+nameArray[i][6])
			document.getElementById('pvmsNo'+rowVal).value=nameArray[i][1]
			document.getElementById('itemId'+rowVal).value=nameArray[i][2]
			//document.getElementById('nomenclature'+rowVal).value=nameArray[i][6]
			document.getElementById('noOfRecords').value=rowVal+1;
			document.getElementById('empId').value=document.getElementById('consultant').value;
			document.getElementById('prescription').value=document.getElementById('prescriptionNo').value;
			
		//	formname=formName.name
		//	var obj3 = eval('document.'+formname+'.lotNo'+rowVal);
		//	obj3.disabled = true
			
			var obj3=document.getElementById('lotNo'+rowVal);
			obj3.disabled = true
			
			var combo=document.getElementById('nomenclature'+rowVal);
				combo.disabled=true
			}
		}
		if(bool == "false")
		{
		  alert("Lot Number not matched")
		  return false
		}
		openPopupForLotNo(lotNo,rowVal,deptId);
		return true
}	
	function popwindow(url)
	{
		 newwindow=window.open(url,'name',"height=500,width=950,status=1,scrollbars=1,resizable=0");
    }
	function checkForNext(){
	  if(document.getElementById('noOfRecords').value<8)
	  {
	  	alert("All rows are not filled.Please Select the Nomenclature/LotNo to Enter ")
	  	return false;
	  }else{
	  return true;
	  }
  }
  
	function openPopupForDelete(OPDIssueNo)
	{
		//alert("opdIssueNo:---"+OPDIssueNo)
		var url="/hms/hms/stores?method=showModifyOPDPatientIssueJsp&OPDIssueNo="+OPDIssueNo;
        popwindowForDelete(url);
    }
     
	function popwindowForDelete(url)
	{
		// newwindow=window.open(url,'name',"height=500,width=700,status=1, scrollbars=yes ");
		 
		 newwindow=window.open(url,'name','status=yes,resizable,scrollbars=1,height=400,width=980,');
    }
    	
    function checkForNomenclature(val,inc,deptId){
		if(val != "")
		{
	    var index1 = val.lastIndexOf("[");
	    var indexForBrandName=index1;
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var itemId = val.substring(index1,index2);
	    var indexForBrandName=indexForBrandName--;
	    var nomenclature=val.substring(0,indexForBrandName);
	    
	     if(itemId =="")
	     {
	     return;
	     }
	     
	     var page = document.getElementById('pageNo').value
	     temp=((pageNo-1)*20)+1;
	     for(i=temp;i<inc;i++)
	     {
	      if(inc != 1){
	        if(document.getElementById('nomenclature'+i).value==val)
	        {
	    		alert("Item already selected...!")
	    		document.getElementById('nomenclature'+inc).value=""
	     	    return false;
	        }
	      }  
	   }
	   	
		ajaxFunctionForAutoCompleteOPDPatient('dispensaryConsumption','stores?method=fillItemsInGridForOPD&itemId='+itemId , inc);
		document.getElementById('empId').value=document.getElementById('consultant').value;
		document.getElementById('prescription').value=document.getElementById('prescriptionNo').value;
		
		openPopup(nomenclature,itemId,deptId,inc,document.getElementById('flag').value,document.getElementById('opdIssueMasterId').value);
		var nomenclature=document.getElementById('nomenclature'+inc)
			//nomenclature.disabled = true
		var lotNo=document.getElementById('lotNo'+inc)
			lotNo.disabled = true
			
	  }
	}
	
    function openPopup(nomenclature,itemId,deptId,rowVal,flag,opdIssueMasterId)
    {
		var url="/hms/hms/stores?method=showOPDStockDetailsJsp&itemId="+itemId+"&deptId="+deptId+"&rowVal="+rowVal + "&flag=" + flag + "&opdIssueMasterId="+opdIssueMasterId+"&itemName="+nomenclature;
        popwindow(url);
     }
     
     function jsDisplay() 
     {	
		if (document.searchForm.<%= ISSUE_NO%>.value=="")
		{
		alert('Pl. select Prescription No....');
		return;
		}
		
		dispensaryConsumption.method="post";
		submitForm('searchForm','stores?method=showDispensaryComsumptionJsp');
    }
    
    function printPrescriptionReport()
    {
    var issueId = document.getElementById('opdIssueMasterId').value;
    if (issueId=="")
    {
    	alert('Pl. select any IssueNo to Print!.....');
    	return;
    }
    dispensaryConsumption.method="post";
	submitForm('searchForm','stores?method=showDispensaryConsumptionReportJsp&issueId='+issueId);
    }
    
     function checkForPvsm(val,inc){

		//var pageNo =parseInt(document.getElementById('pageNo').value) 
		//var start=((pageNo-1)*8)+1;
    	//var end=((pageNo-1)*8)+8;
	   
	    var pvms = val;
	   // for(i=1;i<=8;i++){
	    //if(pvms !="")
	    //if(document.getElementById('nameItem'+i).value==pvms){
	   // if(document.getElementById('nameItem'+inc).value!=pvms){
	    //	alert("Item already selected...!")
	    //	document.getElementById('codeItem'+inc).value=""
	  //    	return false;
	  //  	}
	 //   }}	  
		checkForPvsm1('dispensaryConsumption','stores?method=fillItemsCommon&pvmsNo='+pvms , inc);
   }
function checkForPvsm1(formName,action,rowVal) {
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
      	//var brandId="brandId"+rowVal;
		//obj =document.getElementById(brandId); 
		//obj.length = 1;
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var nomenclature  = item.getElementsByTagName("name")[0];
	        var au  = item.getElementsByTagName("au")[0];
	        var name  = item.getElementsByTagName("name")[0];
	    	document.getElementById('nomenclature'+rowVal).value = nomenclature.childNodes[0].nodeValue +"["+id.childNodes[0].nodeValue+"]"
	    	document.getElementById('nomenclature'+rowVal).focus();
      	} 
      }
    }
    var url=action+"&"+getNameAndData(formName)
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }
  
  function jsNext(){
  var page = document.getElementById('page').value
   if(document.getElementById('opdIssueMasterId').value == ""){
   alert("please create the consumption !");
   }else{
    dispensaryConsumption.method="post";
    submitForm('searchForm','stores?method=showDispensaryComsumptionJsp&page=next&issueNo='+document.getElementById('opdIssueMasterId').value+'&pageNo='+page);
    }
  }
  
  function goPage(){
  var page = document.getElementById('page').value
   if(document.getElementById('opdIssueMasterId').value == ""){
   alert("please create the consumption !");
   }else{
    dispensaryConsumption.method="post";
    submitForm('dispensaryConsumption','stores?method=showDispensaryComsumptionJsp&page=next&issueNo='+document.getElementById('opdIssueMasterId').value+'&pageNo='+page);
    }
  }
  
  function goRefresh(){
  var page = parseFloat(document.getElementById('page').value)
  page = page -1 ;  
   if(document.getElementById('opdIssueMasterId').value == ""){
   alert("please create the consumption !");
   }else{
    dispensaryConsumption.method="post";
    submitForm('dispensaryConsumption','stores?method=showDispensaryComsumptionJsp&page=next&issueNo='+document.getElementById('opdIssueMasterId').value+'&pageNo='+page);
    }
  }
  
  function pvmsNomenclatureSearch(){
  var page = 1;
  var pvmsNo = document.getElementById('pvmsNoS').value
   if(document.getElementById('opdIssueMasterId').value == ""){
   alert("please create the consumption !");
   }else{
    dispensaryConsumption.method="post";
    submitForm('dispensaryConsumption','stores?method=showDispensaryComsumptionJsp&page=next&issueNo='+document.getElementById('opdIssueMasterId').value+'&pageNo='+page+'&pvmsNo='+pvmsNo);
    }
  }
  
  function jsSubmit(){
   var page = parseFloat(document.getElementById('page').value)
  page = page -1 ; 
  document.getElementById('empId').value=document.getElementById('consultant').value;
  var empId = document.getElementById('empId').value
  var remarks = document.getElementById('remarks').value;
  var issue_date = document.getElementById('issue_date').value
  var issue_to_date = document.getElementById('issue_to_date').value
  var pre= document.getElementById('prescriptionNo').value;
  //var empId = 
  //var Remarks = 
  //var fromDate=
  //var toDate =
  //var prew
   if(document.getElementById('opdIssueMasterId').value == ""){
    alert("please create the consumption !");
    }else{
    dispensaryConsumption.method="post";
    submitForm('dispensaryConsumption','stores?method=showDispensaryComsumptionJsp&page=submit&issueNo='+document.getElementById('opdIssueMasterId').value+'&pageNo='+page+'&empId='+empId+'&remarks='+remarks+'&issue_date='+issue_date+'&issue_to_date='+issue_to_date+'&prescription='+pre);
    }
  }
    
</script>
<div class="titleBg"><h2>Dispensary Consumption</h2></div>
<div class="Clear"></div>
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>

<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: none">
<div class="clear"></div>
<form name="searchForm" method="post">
<label >Issue No. </label>
<select name="<%=ISSUE_NO%>">
			<option value="">Select Issue No</option>
			<%
			for(int i=0;i<opPatientIssueList.size();i++)
			{%>
			<option value="<%=opPatientIssueList.get(i).getId()%>"><%=opPatientIssueList.get(i).getIssueNo()%></option>
			<% } %>
		</select>
<input type="image" name="Submit" id="addbutton" value=" "	class="button" onClick="jsDisplay();" />

</form>
</div>
<div class="Clear"></div>

<!--  Search Menu       -->
<form name="dispensaryConsumption" method="post" action="">
<input type="hidden" value="<%=deptId %>" name="deptId" id="deptId" />
<input type="hidden" name="<%=ISSUE_NO%>" value="<%=box.get("issueId")%>"	id="issueId" />
<input type="hidden" size="2" value=""	name="noOfRecords" id="noOfRecords" />
<input type="hidden" value="" name="empId" id="empId" />
<input type="hidden" value="<%=box.get("issueId")%>" name="prescription" id="prescription" />
<input type="hidden" name="date" id="date" value="<%=currDate %>" />
<input type="hidden" name="time" id="time" value="<%=time %>" />
<input type="hidden" name="flag" id="flag" value="C" />
<input type="hidden" name="opdIssueMasterId" id="opdIssueMasterId"	value="<%=box.get("issueId")%>" />
<input type="hidden" name="issueId"	value="<%=box.get("issueId")%>" id="issueId" />
<input type="hidden" name="opdIssueno" value="<%=opdIssueno%>" id="opdIssueno" />

<h4>Issue Details</h4>
<div class="Block">
<% if (opPatientIssueMList!=null && opPatientIssueMList.size() > 0)	{ %>

<label >Issue From Date</label>
<input	type="text" name="issue_date" id="issue_date" readonly="readonly"	value="<%=HMSUtil.convertDateToStringWithoutTime(opPatientIssueMList.get(0).getIssueDate())%>"	class="calDate" tabindex="1" MAXLENGTH="30" />
<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currDate %>',document.dispensaryConsumption.<%="issue_date"%>,event)" />
<label >Issue To Date</label>
<input type="text" name="issue_to_date" id="issue_to_date"	readonly="readonly"	value="<%=HMSUtil.convertDateToStringWithoutTime(opPatientIssueMList.get(0).getIssueToDate())%>"	class="calDate" tabindex="1" MAXLENGTH="30" />
<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currDate %>',document.dispensaryConsumption.<%="issue_to_date"%>,event)" />
<% } else { %>
<label >Issue From Date</label>
<input type="text" class="calDate" name="issue_date" id="issue_date" readonly="readonly" value="" tabindex="1"	MAXLENGTH="30" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	class="calender" onClick="setdate('<%=currDate %>',document.dispensaryConsumption.<%="issue_date"%>,event)" />
<label >Issue To Date</label>
<input type="text" name="issue_to_date" class="calDate" id="issue_to_date"	readonly="readonly" value=""  tabindex="1" MAXLENGTH="30" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currDate %>',document.dispensaryConsumption.<%="issue_to_date"%>,event)" />
<!-- <img  id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=date%>',document.getElementById('issue_date'),event)" />  -->
<%}%>
<label >Prescription No.</label>
<input type="text" name="<%=PRESCRIPTION_NO%>" id="prescriptionNo"	value="<%=box.get(PRESCRIPTION_NO)%>" MAXLENGTH="20" tabindex="1" />

<div class="Clear"></div>

<label >Approved By</label>
<select name="<%=CONSULTING_DOCTOR%>" id="consultant"	validate="" tabindex="1">
	<option value="0">Select</option>
	<% 
	     	MasEmployee masEmployee=null;
	     	String consultantName="";
	     	if (empList!=null && empList.size() > 0 ) 
	     	{ 
	     		for (Iterator iterator = empList.iterator(); iterator.hasNext();) {
	     			masEmployee = (MasEmployee)iterator.next();
	    				
	    				if(masEmployee.getFirstName() != null)
	    				{
	    					consultantName=masEmployee.getFirstName();
	    				}
	    				if(masEmployee.getMiddleName() != null)
	    				{
	    					consultantName+=masEmployee.getMiddleName();
	    				}
	    				if(masEmployee.getLastName() != null)
	    				{
	    					consultantName+=masEmployee.getLastName();
	    				}
	    				
				%>
	<option value="<%=masEmployee.getId()%>"
		<%=HMSUtil.isSelected(masEmployee.getId(),employeeId) %>><%=consultantName%>
	</option>
	<% } 
			} %>
</select> 

<label > Remarks</label>
<%	 if (opPatientIssueMList != null && opPatientIssueMList.size() != 0)	{      %>
<textarea name="<%=REMARKS %>" id="remarks" cols="30" rows="2"	validate="Remarks,string,no" MAXLENGTH="50"	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)" tabindex="1"> <%= opPatientIssueMList.get(0).getRemarks() == null ?"":opPatientIssueMList.get(0).getRemarks()%> </textarea>
<%}else{ %>
<textarea name="<%=REMARKS %>" id="remarks" cols="30" rows="2"	validate="Remarks,string,no" MAXLENGTH="50"	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)" tabindex="1"> </textarea> <%} %>
</div>

<div class="Clear"></div>

<label class="auto">PVMS/NIV</label>
<input type="text"	name="pvmsNoS" id="pvmsNoS" value="" tabindex=1 />
<IMG SRC="/hms/jsp/images/search.gif" WIDTH="26" tabindex=1	HEIGHT="24" style="cursor: pointer;float:left; padding-top:4px;" onClick="javascript:pvmsNomenclatureSearch();"	title="Click here to Search Pvms/Niv" />
<input type="hidden" name="searchFirstTime" id="searchFirstTime" value="" />
<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" />
<div class="Clear paddingTop15"></div>
<!--<input type="button" value="Next Prescription" class="buttonbig" onclick="resetForm()"/>-->
<div id="pagination">
Total Pages
<span>1</span>
Page No.
<span class="selected"><%=pageNo%></span>
<%if(search.equals("y")){ %>
<input type="text" name="ValueOfPage" value="<%=2%>" id="page" MAXLENGTH="3" />
	<%}else{ %>
<input type="text" name="ValueOfPage" <%if(box.getString("pvmsNoS").equals("")){ %> value="<%=pageNo+1%>"	<%}else{%> value="" <%}%> id="page"	MAXLENGTH="3" />
<%} %>

<input type="button" name="goToPage" value=""	onClick="goPage()" class="button" />


</div>
<input type="hidden" value="0" name="noOfRows" id="noOfRows" />
<input type="hidden" name="<%=RequestConstants.INDENT_ID %>" value="" id="hdb" />
<input	type="hidden" name="totalPages" id="totalPages" value=">" />

<div class="Clear"></div>


<div class="Clear"></div>

<h4>Dispensary Consumption Details</h4>
<%
			if (opPatientIssueMList!=null && opPatientIssueMList.size() > 0)	{
			%>

<table width="78%" colspan="7" id="stockDetails"  cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="5%">SR No</th>
			<th width="13%">PVMS No</th>
			<th width="10%">Nomenclature</th>
			<th width="16%">Quantity Issued</th>
		</tr>
	</thead>
	<tbody>
		<%
		   int temp=((pageNo-1)*20);
		   int count = ((pageNo-1)*20)+ opPatientIssueTList.size();
		   String check = search;
		   if (opPatientIssueTList!=null && opPatientIssueTList.size() > 0 && search.equals("n"))	{
			 
		     	 for(int inc1 = temp;inc1 < count; inc1++){
		     	
		     		 int inc=0;
		     		 inc = inc1;
		     		 int sub = ((pageNo-1)*20);
		     		 inc = inc - sub;
		  
		     %>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=inc1+1%>"	 name="<%=RequestConstants.SR_NO%>"	readonly="readonly" /></td>
			<td width="13%"><input type="text" size="10"	value="<%=opPatientIssueTList.get(inc).getItemIdIssue().getPvmsNo() %>"	 name="pvmsNo<%=inc%>" readonly="readonly" id="pvmsNo<%=inc%>" readonly="readonly" /></td>
			<td width="13%">
			<input type="text"	value="<%=opPatientIssueTList.get(inc).getItemIdIssue().getNomenclature()%>" tabindex="1" name="nomenclatureTemp<%=inc%>"	id="nomenclatureTemp<%=inc%>" size="50" readonly="readonly" />
			<input type="hidden" value="<%=opPatientIssueTList.get(inc).getItemIdIssue().getNomenclature()+"["+ opPatientIssueTList.get(inc).getItemIdIssue().getId()+"]"%>" tabindex="1" name="nomenclature<%=inc%>" id="nomenclature<%=inc%>"	size="40" />
			<input type="hidden" name="itemId<%=inc%>"	id="itemId<%=inc %>" value="" />
			<input type="hidden" value="<%=opPatientIssueTList.get(inc).getBatchNo()%>"	 name="batch<%=inc%>" readonly="readonly"	id="batch<%=inc%>" readonly="readonly" />
			</td>
			<input type="hidden" value="<%=opPatientIssueTList.get(inc).getBrand().getBrandName() %>"  name="brand<%=inc%>" readonly="readonly"	id="brand<%=inc%>" readonly="readonly" />
			</td>
			</td>
			<td width="16%">
			<input type="text" value="<%=opPatientIssueTList.get(inc).getQtyIssued() %>"  name="<%=RequestConstants.QTY_ISSUED%>"	id="qtyIssued<%=inc%>" value="" readonly="readonly" />
			</td>
			</tr>
		<%
		     	}
		     %>

		<%
		     int temp1 = ((pageNo-1)*20)+1+19;
		     int start = ((pageNo-1)*20)+ opPatientIssueTList.size() + 1;
		     
		     for(int inc=start;inc<=temp1;inc++){
		    	
		     %>
		<tr>
			<td width="5%">
			<input type="text" size="2" value="<%=inc%>"  name="<%=RequestConstants.SR_NO%>"	readonly="readonly" />
			</td>
			<!-- <td width="5%">     <input type="text" size="2"	value=""  name="lotNo<%=inc %>" id="lotNo<%=inc %>"  onblur="if(validateConsultant(dispensaryConsumption,<%=inc %>)){fillValuesForLotNo(this.value,<%=inc%>,<%=deptId %>,dispensaryConsumption);}"  /></td>   -->
			<td width="13%">
			<input type="text" size="10" 	name="pvmsNo<%=inc%>" id="pvmsNo<%=inc%>" onblur="checkForPvsm(this.value,'<%=inc %>')" /></td>
			<td width="13%">
			<input type="text" value="" tabindex="1" size="50" name="nomenclature<%=inc%>" id="nomenclature<%=inc%>"	onblur="if(validateConsultant(dispensaryConsumption,<%=inc %>)){checkForNomenclature(this.value, '<%=inc %>','<%=deptId %>');}" />
				<div id="ac2update"	style="display: none;" class="autocomplete"></div>
				<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('nomenclature<%=inc%>','ac2update','stores?method=getItemListForOPD',{parameters:'requiredField=nomenclature<%=inc%>'});
					</script>
					</td>

			<input type="hidden" name="itemId<%=inc%>" id="itemId<%=inc %>"		value="" />
			<td width="16%"><input type="text" value="" 	name="<%=RequestConstants.QTY_ISSUED%>" id="qtyIssued<%=inc%>"	value="" readonly /></td>
		</tr>
		<% } }
		   else if (opPatientIssueTList!=null && opPatientIssueTList.size() > 0 && search.equals("y"))	{
			 	 for(int inc1 = temp;inc1 < count; inc1++){
		     	
		     		 int inc=0;
		     		 inc = inc1;
		     		 int sub = ((pageNo-1)*20);
		     		 inc = inc - sub;
		  
		     %>
		<tr>
			<td width="5%">
			<input type="text" size="2" value="<%=inc1+1%>"	 name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
			<td width="13%">
			<input type="text" size="10"	value="<%=opPatientIssueTList.get(inc).getItemIdIssue().getPvmsNo() %>"		 name="pvmsNo<%=inc%>" readonly="readonly"	id="pvmsNo<%=inc%>" readonly="readonly" /></td>
				<td width="13%">
				<input type="text"	value="<%=opPatientIssueTList.get(inc).getItemIdIssue().getNomenclature()%>" tabindex="1" name="nomenclatureTemp<%=inc%>" id="nomenclatureTemp<%=inc%>" size="50" readonly="readonly" />
				<input type="hidden" value="<%=opPatientIssueTList.get(inc).getItemIdIssue().getNomenclature()+"["+ opPatientIssueTList.get(inc).getItemIdIssue().getId()+"]"%>"	tabindex="1" name="nomenclature<%=inc%>" id="nomenclature<%=inc%>"	size="50" />
				<input type="hidden" name="itemId<%=inc%>"	id="itemId<%=inc %>" value="" />
				<input type="hidden"	value="<%=opPatientIssueTList.get(inc).getBatchNo()%>"	 name="batch<%=inc%>" readonly="readonly"	id="batch<%=inc%>" readonly="readonly" /></td>
				<input type="hidden" value="<%=opPatientIssueTList.get(inc).getBrand().getBrandName() %>"	 name="brand<%=inc%>" readonly="readonly"	id="brand<%=inc%>" readonly="readonly" /></td>
			</td>
			<td width="16%"><input type="text"	value="<%=opPatientIssueTList.get(inc).getQtyIssued() %>"	 name="<%=RequestConstants.QTY_ISSUED%>"	id="qtyIssued<%=inc%>" value="" readonly="readonly" /></td>	</tr>
		<%
		     	}
		     %>

		<%
		     int temp1 = ((pageNo-1)*20)+1+19;
		     int start = ((pageNo-1)*20)+ opPatientIssueTList.size() + 1;
		     
		     for(int inc=start;inc<=temp1;inc++){
		    	
		     %>
		<tr>
			<td width="5%">
			<input type="text" size="2" value="<%=inc%>"  name="<%=RequestConstants.SR_NO%>"	readonly="readonly" /></td>
				<!-- 
		      <td width="5%">
		      <input type="text" size="2"	value=""  name="lotNo<%=inc %>" id="lotNo<%=inc %>"  onblur="if(validateConsultant(dispensaryConsumption,<%=inc %>)){fillValuesForLotNo(this.value,<%=inc%>,<%=deptId %>,dispensaryConsumption);}"  /></td>
		       -->
			<td width="13%">
			<input type="text" size="10" 	name="pvmsNo<%=inc%>" id="pvmsNo<%=inc%>" onblur="checkForPvsm(this.value,'<%=inc %>')" /></td>
			<td width="13%"><input type="text" value="" tabindex="1" name="nomenclature<%=inc%>" id="nomenclature<%=inc%>"	size="50"	onblur="if(validateConsultant(dispensaryConsumption,<%=inc %>)){checkForNomenclature(this.value, '<%=inc %>','<%=deptId %>');}" />
			<div id="ac2update"	style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
					  new Ajax.Autocompleter('nomenclature<%=inc%>','ac2update','stores?method=getItemListForOPD',{parameters:'requiredField=nomenclature<%=inc%>'});
					</script>
					</td>

			<input type="hidden" name="itemId<%=inc%>" id="itemId<%=inc %>"	value="" />
			<td width="16%">
			<input type="text" value="" 	name="<%=RequestConstants.QTY_ISSUED%>" id="qtyIssued<%=inc%>"	value="" readonly /></td>
		</tr>
		<% } }
		   else if (opPatientIssueTList.size() == 0 && search.equals("n"))	{
			 	 for(int inc1 = temp;inc1 < count; inc1++){
		     	
		     		 int inc=0;
		     		 inc = inc1;
		     		 int sub = ((pageNo-1)*20);
		     		 inc = inc - sub;
		     		 
		       %>
		<tr>
			<td width="5%">
			<input type="text" size="2" value="<%=inc1+1%>"	name="<%=RequestConstants.SR_NO%>" readonly="readonly" />
			</td>
			<td width="13%">
			<input type="text" size="10"	value="<%=opPatientIssueTList.get(inc).getItemIdIssue().getPvmsNo() %>"	 name="pvmsNo<%=inc%>" readonly="readonly" id="pvmsNo<%=inc%>" readonly="readonly" /></td>
			<td width="13%">
			<input type="text"	value="<%=opPatientIssueTList.get(inc).getItemIdIssue().getNomenclature()%>" tabindex="1" name="nomenclatureTemp<%=inc%>"	id="nomenclatureTemp<%=inc%>" size="50" readonly="readonly" />
			<input type="hidden" value="<%=opPatientIssueTList.get(inc).getItemIdIssue().getNomenclature()+"["+ opPatientIssueTList.get(inc).getItemIdIssue().getId()+"]"%>"	tabindex="1" name="nomenclature<%=inc%>" id="nomenclature<%=inc%>"	size="40" />
			<input type="hidden" name="itemId<%=inc%>"	id="itemId<%=inc %>" value="" />
			<input type="hidden" value="<%=opPatientIssueTList.get(inc).getBatchNo()%>"	 name="batch<%=inc%>" readonly="readonly"	id="batch<%=inc%>" readonly="readonly" /></td>
			<input type="hidden" value="<%=opPatientIssueTList.get(inc).getBrand().getBrandName() %>"	 name="brand<%=inc%>" readonly="readonly"	id="brand<%=inc%>" readonly="readonly" /></td>
			</td>
			<td width="16%">
			<input type="text"	value="<%=opPatientIssueTList.get(inc).getQtyIssued() %>"	 name="<%=RequestConstants.QTY_ISSUED%>"	id="qtyIssued<%=inc%>" value="" readonly="readonly" /></td>
			</tr>
		<%
		     	}
		     %>

		<%
		     int temp1 = ((pageNo-1)*20)+1+19;
		     int start = ((pageNo-1)*20)+ opPatientIssueTList.size() + 1;
		     for(int inc=start;inc<=temp1;inc++){
		    	
		     %>
		<tr>
			<td width="5%">
			<input type="text" size="2" value="<%=inc%>"  name="<%=RequestConstants.SR_NO%>" readonly="readonly" />
			</td>
			<!-- 
		      <td width="5%">
		      <input type="text" size="2"	value=""  name="lotNo<%=inc %>" id="lotNo<%=inc %>"  onblur="if(validateConsultant(dispensaryConsumption,<%=inc %>)){fillValuesForLotNo(this.value,<%=inc%>,<%=deptId %>,dispensaryConsumption);}"  /></td>
		       -->
			<td width="13%">
			<input type="text" 	name="pvmsNo<%=inc%>" id="pvmsNo<%=inc%>"	onblur="checkForPvsm(this.value,'<%=inc %>')" /></td>
			<td width="13%">
			<input type="text" value="" tabindex="1" name="nomenclature<%=inc%>" id="nomenclature<%=inc%>"	size="40"	onblur="if(validateConsultant(dispensaryConsumption,<%=inc %>)){checkForNomenclature(this.value, '<%=inc %>','<%=deptId %>');}" />
			<div id="ac2update"	style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('nomenclature<%=inc%>','ac2update','stores?method=getItemListForOPD',{parameters:'requiredField=nomenclature<%=inc%>'});
   </script>
</td>

			<input type="hidden" name="itemId<%=inc%>" id="itemId<%=inc %>" value="" />
			<td width="16%">
			<input type="text" value="" 	name="<%=RequestConstants.QTY_ISSUED%>" id="qtyIssued<%=inc%>"	value="" readonly /></td>
		</tr>
		<% } }
		   else if(opPatientIssueTList == null && opPatientIssueTList.size() == 0 && search.equals("y")){
			   %>
		<tr>
			<td colspan=8 align="center">No data Found</td>
		</tr>
		<% } %>
	</tbody>
</table>

<% }else { %>
<table width="78%" colspan="7" id="stockDetails" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="5%">SR No.</th>
			<!-- <td width="10%">Lot Number</td>  -->
			<th width="13%">PVMS No.</th>
			<th width="10%">Nomenclature</th>
			<th width="16%">Quantity Issued</th>
		</tr>
	</thead>
	<tbody>
		<%
		    int detailCounter=0; 
	    	int temp=0;
	    		temp=((pageNo-1)*20)+1;
	    	
	    	detailCounter = ((pageNo-1)*20)+20;
	     	 for(int inc=temp;inc<=detailCounter;inc++){
		     		
		     %>
		<tr>
			<td width="5%">
			<input type="text" size="2" value="<%=inc%>"  name="<%=RequestConstants.SR_NO%>"	readonly="readonly" /></td>
			<!--   <td width="5%">  <input type="text" size="2"	value=""  name="lotNo<%=inc %>" id="lotNo<%=inc %>"  onblur="if(validateConsultant(dispensaryConsumption,<%=inc %>)){fillValuesForLotNo(this.value,<%=inc%>,<%=deptId %>,dispensaryConsumption);}"  /></td>    -->
			<td width="13%">
			<input type="text" 	name="pvmsNo<%=inc%>" id="pvmsNo<%=inc%>"	onblur="checkForPvsm(this.value,'<%=inc %>')" /></td>
			<td width="13%"><input type="text" value=""  name="nomenclature<%=inc%>" id="nomenclature<%=inc%>"	size="50"	onblur="if(validateConsultant(dispensaryConsumption,<%=inc %>)){checkForNomenclature(this.value, '<%=inc %>','<%=deptId %>');}" />
			<div id="ac2update"	style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
					  new Ajax.Autocompleter('nomenclature<%=inc%>','ac2update','stores?method=getItemListForOPD',{parameters:'requiredField=nomenclature<%=inc%>'});
					</script>
					</td>
			<input type="hidden" name="itemId<%=inc%>" id="itemId<%=inc %>"	value="" />
			<td width="16%">
			<input type="text" value="" 	name="<%=RequestConstants.QTY_ISSUED%>" id="qtyIssued<%=inc%>"	value="" readonly />
			</td>
		</tr>
		<%
		     	}
		     %>
	</tbody>
</table>
<% } %> 
<div class="Clear"></div>
<div class="division"></div>
<input type="button" value="Next Page" class="button"	onclick="jsNext()" />
<input type="button" value="Submit"	class="button" onclick="jsSubmit()" />
<input type="button" name="Refresh" value="Refresh" onClick="goRefresh();" class="button" />
<input type="button" name="Print" type="submit" value="Print" class="button" onClick="printPrescriptionReport();">

<div class="Clear"></div>
<div class="division"></div>

<div class="bottom">
<label>Changed By:</label>
<label	class="value"><%=userName%></label>
<label>Changed Date:</label>
<label class="value"><%=currDate%></label>
<label>Changed Time:</label>
<label	class="value"><%=time%></label>
<div class="Clear"></div>
</div>
</form>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
