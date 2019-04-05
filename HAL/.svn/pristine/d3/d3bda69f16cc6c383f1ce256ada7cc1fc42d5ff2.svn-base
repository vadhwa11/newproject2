<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * issueToDispensaryManual.jsp  
 * Purpose of the JSP -  This is for Issue to Dispensary Manual.
 * @author  Deepti
 * @author  Vivek
 * Create Date: 12st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<%@page import="jkt.hms.masters.business.StoreLoanoutExpendM"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script language="javascript">
	
	function checkForIssueToLoanout(val,a,inc)
	{
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*20)+1;
    	var end=((pageNo-1)*20)+20;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    
	    for(i=start;i<=end;i++){
	    if(pvms ==""){
	    	document.getElementById('nameItem'+inc).value=""
	    	
	    	return ;
	    	}
	   }
	    /* for(i=start;i<=end;i++)
	    {
	    if(pvms !="")
	    if(document.getElementById('codeItem'+i).value==pvms)
	    {
		    if(document.getElementById('codeItem'+inc).value!=pvms)
		    {
		    	alert("Item already selected...!")
		    	document.getElementById('nameItem'+inc).value=""
		    	return false;
		    } 
	    }
	    } */
	    
		ajaxFunctionForAutoCompleteIssueToDispensary('issueDispensaryManualForm','stores?method=fillItemsForIssueToDispensary&pvmsNo=' +  pvms , inc);
}
 
	
	function test()
	{
		if(document.getElementById('mmfForTheYear').value ==0){
			alert("Please Select MMF Year..!");
			return false;
		}else{
			return true;
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
function testForLotNo(value){
		if(value ==""){
			return false;
		}else{
			return true;
		}
}

	function fillValuesForPvms(pvmsNo,rowVal){
   // alert("In fillValuesForPvms----- "+document.getElementById('nameItem'+rowVal).value)
    //alert(pvmsNo)
   document.getElementById('nameItem'+rowVal).value="";
   document.getElementById('idAu'+rowVal).value="";
    	//ajaxFunctionForAutoCompleteIssueToDispensaryByPvmsNo('issueDispensaryManualForm','stores?method=fillItemsForIssueToDispensaryByPvmsNo&pvmsNo=' +  pvmsNo , rowVal);
    	
if(pvmsNo != ""){
   if(validatePvms(pvmsNo)){
	   ajaxFunctionForAutoCompleteIssueToDispensaryPvms('issueDispensaryManualForm','stores?method=fillItemsForIssueToDispensary&pvmsNo=' +  pvmsNo , rowVal);
   	   	
   	}else{
   	    return false;
   	}
}	
    
    
    }

 </script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
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
	Map valueMap = new HashMap();
	String includedJsp = null;
	String previousPage="no";
	int nrs=0;
	String indentOption="";
	int pageNo=1;
	int indentId=0;
	int internalIndentId=0;
	int listSize=0;
	String userName="";
	String date="";
	String time="";
	String max="";
	List<MasStoreBrand> masStoreBrandList= new ArrayList<MasStoreBrand>();
	List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
	
	List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
	List<MasStoreAirForceDepot> masStoreAirForceDepotList= new ArrayList<MasStoreAirForceDepot>();
	List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
	List<Patient> patientList= new ArrayList<Patient>();
	List <StoreIssueM> searchListForPopup=new ArrayList<StoreIssueM>();
	List issueTList=new ArrayList();
	
		int maxIndentNo=0;
		Box bos = null;
		Box box=HMSUtil.getBox(request);
		System.out.println("box inside JSP .>>>>>>>>>>>>" + box);
		if (request.getAttribute("map") != null) 
		{
		map = (Map) request.getAttribute("map");
		
		}
		
		if(map.get("employeeList")!=null)
		{
			employeeList = (List) map.get("employeeList");
		}
		
		if (map.get("valueMap")!=null)
		{
			valueMap = (Map) map.get("valueMap");	
			box.put("approvedBy",valueMap.get("approvedBy"));
			box.put("docNo",valueMap.get("reference"));
			box.put("deptName",valueMap.get("deptName"));
			box.put("issueNo",valueMap.get("issueNo"));
			box.put("requestBy",valueMap.get("requestBy"));
			box.put("departmentIdTemp",valueMap.get("departmentIdTemp"));
			box.put("issuedBy",valueMap.get("issuedBy"));
			box.put("issueId",valueMap.get("issueId"));
		}
		
		if(map.get("issueTList")!=null)
		{
			issueTList=(List)map.get("issueTList");
		}
		
		if(map.get("departmentList")!=null)
			departmentList = (List) map.get("departmentList");
		if(map.get("masStoreAirForceDepotList")!=null)
			masStoreAirForceDepotList = (List) map.get("masStoreAirForceDepotList");
		if(map.get("itemList")!=null)
			itemList = (List) map.get("itemList");
		if(map.get("patientList")!=null)
			patientList = (List) map.get("patientList");
		if(map.get("internalIndentId")!=null){
			internalIndentId=Integer.parseInt(""+map.get("internalIndentId"));
			System.out.println("internalIndentId  "+internalIndentId);
		}
		if(map.get("masStoreBrandList")!=null)
			masStoreBrandList = (List) map.get("masStoreBrandList");
		
		if(map.get("max")!=null)
			max = (String) map.get("max");
		System.out.println("max .>>>>>>>>>>>>" + max);
		
		if(map.get("pageNo")!=null)
			pageNo = Integer.parseInt(""+map.get("pageNo"));
		
		 int totalPages=0;
		 if(map.get("totalPages")!=null){
			 totalPages=(Integer)map.get("totalPages");
			}

	
		if(map.get("listSize")!=null)
			listSize = Integer.parseInt(""+map.get("listSize"));
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		 date = (String)utilMap.get("currentDate");	 
		 time = (String)utilMap.get("currentTime");
		 if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}

		 if(map.get("searchListForPopup")!=null){
				searchListForPopup=(List<StoreIssueM>)map.get("searchListForPopup");
				System.out.println("searchListForPopup..........." + searchListForPopup.size());
			}
		 List<StoreLoanoutExpendM> searchListForPopup1 = new ArrayList<StoreLoanoutExpendM>(); // javed khan
		 if(map.get("searchListForPopup1")!=null){
				searchListForPopup1=(List<StoreLoanoutExpendM>)map.get("searchListForPopup1");
				System.out.println("searchListForPopup1..........." + searchListForPopup1.size());
			}
		 
%>
<br />
<h2 >Loan Out </h2>
<div class="clear"></div>
<div class="clear"></div>

<!-- 

<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
		<table width="20%" align="right" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" value="Delete"
					class="toolbutton" onclick="openDeletePopupForIssueLoanOut();" /></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="print" type="submit" class="toolbutton"
					value="Print"></td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
 -->
<%--------------- Start of Search Panel ---------------------------%>
 <div id="searchBlock" style="display:none;">
 <form name="loanout" method="post" action="">
 <div class="clear"></div>
<h6>SEARCH</h6>
<div class="clear"></div>
<div class="Block">
<form name="" method="" >
 <!-- 
<div align="center">
<div style="padding: 0px 25px 0px 25px">
-->
<!-- thread search menu -->
<!-- 
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form name="searchPanel" method="post">
 
<table width="330" border="0" cellpadding="2" cellspacing="1"
	style="border: 1px solid #245E83;">
	<tr>
		<td width="324" class="thead">Search Panel<a
			name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite">
		-->
		<label>Loan Out No.</label> <select
			name="<%= RequestConstants.ISSUE_UNIT_ID%>">
			<option value="">Select</option>
			<%for (StoreLoanoutExpendM slem :searchListForPopup1 ) {%>
			<option value=<%=slem.getId()%>><%=slem.getIssueNo()%></option>
			<%}%>
		</select>
		
		<!-- <input type="button" name="sss" class="button" value="SEARCH"  onClick="submitForm('loanout','stores?method=searchIssueLoanout');" /> -->
		<input type="button" name="sss" class="button" value="SEARCH"  onClick="submitForm('loanout','stores?method=searchIssueLoanout1');" />
		<input type="button" name="sss" class="button" value="CLOSE"  onClick="closeSearch();" />
		
		<!--
		 <input type="button" class="morebutton" value=" "
			onClick="submitForm('loanout','stores?method=searchIssueLoanout');" />
			
		</td>
	</tr>

</table>
  
</form>
</div>

</div>
</div>
-->



</div>
</form>
</form>
</div>
<%-------------------- End of Search Panel ---------------------------%>

<br />


<form name="issueDispensaryManualForm" method="post">
<!-- 
<div style="width: 15px; height: 20px; float: left;"></div
-->
<!-- 
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle"></font></div> -->
<h4>Issue Details</h4>

<!-- 
<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 89px; background-color: #f4f9fe; padding-top: 10px; padding-bottom: 5px;"> -->
<div class="Block">

<%if(box.get("issueId").equals("")){ %> <input type="hidden"
	name="<%=RequestConstants.ISSUE_ID %>" value="0" id="issueId" /> <%}else{ %>
<input type="hidden" name="<%=RequestConstants.ISSUE_ID %>"
	value="<%=box.get("issueId") %>" id="issueId" /> <%} %> <input
	type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" /> 
	<label> Loan Out No. </label> <%if(map.get("max")!= null){ %>
<input type="text" name="<%=RequestConstants.ISSUE_NO %>"
	value="<%=max %>" id="issueNo" MAXLENGTH="8"/  > <%}else{ %> <input
	type="text" name="<%=RequestConstants.ISSUE_NO %>"
	value="<%=box.get("issueNo") %>" id="issueNo"  MAXLENGTH="8"/  > <%} %>
	
	 <label>Loan Out Date</label> 
	<input type="text" name="<%=RequestConstants.ISSUE_DATE%>" readonly="readonly"
	value="<%=currentDate %>" id="isssueDate" /> 
	

<label >Loan Out To</label> 
<input type="text" value="Dispensary"/>
<input type="hidden" name="<%= RequestConstants.DEPARTMENT_ID_TEMP%>" id="departmentIdTemp" validate="Loan Out To,string,yes" value="35"/>
<!--<select
	name="<%= RequestConstants.DEPARTMENT_ID_TEMP%>" id="departmentIdTemp" validate="Loan Out To,string,yes">
	<option value="">Select</option>
	<%for (MasDepartment department :departmentList ) {%>
	<option value=<%=department.getId()%>
		<%=HMSUtil.isSelected(department.getId().toString(),box.get(DEPARTMENT_ID_TEMP)) %>><%=department.getDepartmentName()%></option>
	<%}%>
		
</select>  -->


<div class="clear"></div>
<!-- 
<label >Ref No.</label> <input
	type="text" name="<%= RequestConstants.DOC_NO%>"  value="<%=box.get("docNo")%>" id="docNo"
	maxlength="12" /> 
	
	<label >Hin No</label>
 <input type="text" name="<%= RequestConstants.PATIENT_NAME%>"
	 value="<%=box.get("patientName")%>"
	id="<%= RequestConstants.PATIENT_NAME%>"
	onblur="checkHinExistence('issueDispensaryManualForm','stores?method=checkHinExistence&hinNo='+this.value,this.value)" />
<div id="ac2update"
	style="display: none; padding-right: 550px; background-color: white;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
							  new Ajax.Autocompleter('<%= RequestConstants.PATIENT_NAME%>','ac2update','stores?method=getHinNo');
					</script> 
 -->
<label>Requested By</label> <select
	name="<%= RequestConstants.REQUEST_BY%>" id="requestBy" validate="Requested By,string,yes" >
	<option value="">Select</option>
	<%for (MasEmployee masEmployee:employeeList ) {	%>
	<option value=<%=masEmployee.getId()%>
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("requestBy")) %>><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select>
<!-- 
<label>Approved By</label> <select
	name="<%= RequestConstants.APPROVED_BY%>" id="approvedBy">
	<option value="">Select</option>
	<%for (MasEmployee masEmployee:employeeList ) {%>
	<option value=<%=masEmployee.getId()%>
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("approvedBy")) %>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select>  -->
<label >Issued By</label> <select
	name="<%= RequestConstants.ISSUED_BY%>" id="issuedBy" validate="Issued By,string,yes" >
	<option value="">Select</option>
	<%for (MasEmployee masEmployee:employeeList ) {%>
	<option value=<%=masEmployee.getId()%>
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("issuedBy")) %>><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select> <input type="hidden" name="<%=RequestConstants.NO_OF_ROWS%>"
	id="noOfRows" value="22" /></div>




<div style="float: left; padding-left: 15px;">
<!--  <input type="button"
	class="button" value="Next"
	onclick="submitForm('issueDispensaryManualForm','stores?method=addNextOrSubmitIssueForLoanOut&buttonName=next');"
	align="right" /> -->
	
	<!--    	<input type="button" name="sss" align="right" class="button" value="Submit" onclick="if(checkForSubmit()&&test()){{submitForm('issueDispensaryManualForm','stores?method=addNextOrSubmitIssueForLoanOut&buttonName=submit');}}"/>  -->
</div>
<div class="clear"></div>
	<div class="clear"></div>

<!-- 
<div style="float: left; padding-left: 15px; padding-bottom: 10px;">
<label class="bodytextB">Page No:</label>
<div class="changebydt" style="width: 65px;"><%=pageNo%></div>
<td width="9%"><input type="text" name="ValueOfPage"
	<%if(box.getString("pvmsNo1").equals("")){ %> value="<%=pageNo+1%>"
	<%}else{ %> value="" <%}%> id="page" class="textbox_small_size"
	MAXLENGTH="3" /></td>
<td width="21%"><input type="button" name="goToPage" value="Go"
	onClick="goPage()" class="smbutton"
	style="background: url(/hms/jsp/images/smbutton.gif) !important; width: 31px; height: 21px; font-size: 11px; color: #FFFFFF !important; margin-right: 8px; border: none;" />
</td>
</div>
<label class="bodytextB">Total Pages:</label>
<div class="changebydt" style="width: 65px;"><%=totalPages%></div>

<input type="button" name="Refresh" value="Refresh"
	onClick="goRefresh();" class="button" />
	<input type="hidden" name="totalPages" id="totalPages" value="<%=totalPages%>" id="hdb" />
	<input type="hidden" name="<%=RequestConstants.NO_OF_ROWS%>" id="<%=RequestConstants.NO_OF_ROWS%>" value="0" />
	<input type="hidden" name="<%=RequestConstants.INDENT_ID %>" value="<%=indentId%>" id="hdb" />
	<br/> <label >PVMS/NIV No.</label>
	<input type="text" name="pvmsNo1" id="pvmsNo1" value="<%=box.getString("pvmsNo1") %>" tabindex=1 class="textbox_size20" />
	<IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" tabindex=1 HEIGHT="26" style="cursor:pointer;" onClick="javascript:pvmsNomenclatureSearch();" title="Click here to Search Pvms/Niv"/>
	<div style="width: 15px; height: 20px; float:left;"></div>
	 -->
	<h4>Item Details</h4>
	<div class="clear"></div>
	<div class="clear"></div>
	 <div style="height:350px; width:1000px; overflow-x:  scroll; overflow-y: scroll ;">  
	<!-- <table width="200px" colspan="7" id="indentDetails" class="grid_header" border="1" cellpadding="0" cellspacing="0"> -->
	<table width="98%" colspan="7" id="indentDetails" 	border="0" cellpadding="0" cellspacing="0">
  <thead>
    <tr>
      
       <th width="5%">Sl No.</th>
			<th width="8%">PVMS/ NIV No.</th>
			<th width="15%">Nomenclature</th>
			<th width="5%">A/ U</th>	
    <th width="13%">Batch No.</th>
			<th width="2%">B/G</th>
			<th width="10%">Barcode</th> 
      <th width="13%">DOM</th> 			 
			<th width="13%">DOE</th> 
			<th width="13%">Source</th>
			
			<th width="13%">Available</br>Stock</th>
			<th width="13%">Batch</br>Stock</th>
			<th width="13%">MMF</th>
     <!--  <th>Qty Demanded </th>-->	
      <th>Qty</br>Issued </th>
      <th width="13%">Balance</br>after Issue</th>
    <!--  <th>Add </th> --> 
      
      
      
      
      
      
    </tr>
    
  </thead>
  <tbody>
           
    	<%try{
    	int detailCounter=10; 
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idSection="idSection";
    	String nameSection="nameSection";
    	String idAu="idAu";
    	
    	String stockInVar="stockInVar";
    	String mmfVar="mmfVar";
    	String demandVar="demandVar";
    	
    	String stockInVarTemp="stockInVarTemp";
    	String mmfVarTemp="mmfVarTemp";
    	String demandVarTemp="demandVarTemp";
    	String incVar="incVar";
    	
    	
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idSection2="idSection";
    	String nameSection2="nameSection";
    	String idAu2="idAu";
    	
    	String stockInVar2="stockInVar";
    	String mmfVar2="mmfVar";
    	String demandVar2="demandVar";

    	String stockInVarTemp2="stockInVarTemp";
    	String mmfVarTemp2="mmfVarTemp";
    	String demandVarTemp2="demandVarTemp";
    	String incVar2="incVar2";
    	
    	
    	String issuedName = "issuedName";
    	String issuedName2 = "issuedName";
    	String qtyIssued="qtyIssued";
    	String qtyIssued2="qtyIssued";
    	String issuedItemId="issuedItemId";
    	String issuedItemId2="issuedItemId";
    	String lotNo="lotNo";
    	String lotNo2="lotNo";
    	
       	int inc=((pageNo-1)*20)+1;
    	int tempVar=((pageNo-1)*20)+1;
 	   
 	   int incTemp2=inc+20;
 	   
 	  	for (Iterator iterator = issueTList.iterator(); iterator.hasNext();) 
		{
		 Object[] object = (Object[]) iterator.next();
		
 		  tempVar--;
 		 
 		  if(inc<incTemp2){
     		 
 				idItem=idItem2+(""+inc);
 	     		codeItem=codeItem2+(""+inc);
 	     		nameItem=nameItem2+(""+inc);
 	     		idSection=idSection2+(""+inc);
 	     		nameSection=nameSection2+(""+inc);
 	     		idAu=idAu2+(""+inc);
 	     		
 	     		stockInVar=stockInVar2+(""+inc);
 	     		mmfVar=mmfVar2+(""+inc);
 	     		demandVar=demandVar2+(""+inc);
 	     		

 	     		stockInVarTemp=stockInVarTemp2+(""+inc);
 	     		mmfVarTemp=mmfVarTemp2+(""+inc);
 	     		demandVarTemp=demandVarTemp2+(""+inc);
 	     		incVar=incVar2+(""+inc);
 	     		
 	     		issuedName = issuedName2+(""+inc);
 	     		qtyIssued=qtyIssued2+(""+inc);
 	     		issuedItemId=issuedItemId2+(""+inc);
 	     		lotNo=lotNo2+(""+inc);
 	     		
    	  %>
    	  
			<tr>
			
			<td width="5%"><input type="text" size="2"	value="<%=temp+inc%>" class="smcaption" name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
			<td width="5%">
			<input type="text" name="<%=RequestConstants.ITEM_CODE%>" value="<%=object[1].toString() %>" class="medcaption" id="<%=codeItem%>" readonly="readonly"/>
			<input type="hidden" size="2"	value="0" class="smcaption" name="<%=RequestConstants.ITEM_ID%>" id="idItem<%=temp+inc%>" />
			</td>
			
			<td width="17%">
			<input type="text" value="<%=object[2].toString() %>"	tabindex="1" id="<%=nameItem%>" class="bigcaption" readonly="readonly" />
			</td>  
		
		    
			<td width="10%"><input type="hidden" value="0"	id="<%=issuedItemId%>" class="medcaption"  />
			<input type="text"	value="<%=object[7].toString()==null?0:object[7].toString() %>" validate="Qty Requested Year,floatWithoutSpaces,no" maxlength="7"  class="medcaption"  readonly="readonly" name="<%=RequestConstants.QTY_IN_REQUEST%>"  />
			</td>
			 <td width="10%"><input type="text"	value="<%=object[8].toString()==null?0:object[8].toString()%>" class="medcaption" name="<%=RequestConstants.QTY_ISSUED%>" tabindex="2" id="<%=qtyIssued%>" readonly="readonly"/>
			</td>
			<td width="10%">
			<input type="text"	value="<%=object[3].toString() %>" class="smcaption"  name="<%=RequestConstants.AU%>" id="<%=idAu %>" tabindex="2" readonly="readonly"/>
			</td>
			
			<input type="hidden" value=""	id="<%=issuedName%>" class="bigcaption"    />
			
			<td width="10%"><input type="text" value=""	id="<%=lotNo%>" class="medcaption" readonly="readonly" /></td><td width="3%">
			
			<input type="button" class="morebutton" tabindex="1" onclick="openPopupForBrandForLoanOut(<%=inc%>);" name="Submit2" value=" "  /> 
			</td>
			 </tr>
    
       <% inc++;}  } 
	
 	  	if(inc<=(pageNo-1)*20+20){
			  for(;inc<=(pageNo-1)*20+20;inc++)
			  {
					idItem=idItem2+(""+inc);
	 	     		codeItem=codeItem2+(""+inc);
	 	     		nameItem=nameItem2+(""+inc);
	 	     		idSection=idSection2+(""+inc);
	 	     		nameSection=nameSection2+(""+inc);
	 	     		idAu=idAu2+(""+inc);
	 	     		
	 	     		stockInVar=stockInVar2+(""+inc);
	 	     		mmfVar=mmfVar2+(""+inc);
	 	     		demandVar=demandVar2+(""+inc);
	 	     		

	 	     		stockInVarTemp=stockInVarTemp2+(""+inc);
	 	     		mmfVarTemp=mmfVarTemp2+(""+inc);
	 	     		demandVarTemp=demandVarTemp2+(""+inc);
	 	     		incVar=incVar2+(""+inc);
	 	     		
	 	     		issuedName = issuedName2+(""+inc);
	 	     		qtyIssued=qtyIssued2+(""+inc);
	 	     		issuedItemId=issuedItemId2+(""+inc);
	 	     		lotNo=lotNo2+(""+inc);
	 	     		System.out.println(inc+"temp+inc>>>"+(temp+inc));
			  
			  %>
  	
     <tr>
      <td width="5%"><input type="text" size="2"	value="<%=temp+inc%>" class="smcaption" name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
      <td width="5%">
      <input type="text" size="8" name="<%=RequestConstants.ITEM_CODE%>" value="" class="medcaption" id="<%=codeItem%>" onblur="fillValuesForPvms(this.value,'<%=inc %>')"/>
      <input type="hidden" size="2"	value="0" class="smcaption" name="<%=RequestConstants.ITEM_ID%>" id="idItem<%=temp+inc%>" />
      
      </td>
       <td width="17%">
      	<input type="text" size="30" value=""	tabindex="1" id="<%=nameItem%>" class="bigcaption" onblur="if(fillSrNo('<%=inc %>')){checkForIssueToLoanout(this.value, '<%=nameItem%>','<%=inc %>');}"  name="<%=nameItem%>" />
			<div id="ac2update" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForIssueToDispensary',{parameters:'requiredField=<%=nameItem%>&issueId='+document.getElementById('issueId').value });
			</script>
		</td> 
		  
		 
      <td width="5%">
      
      <input type="text"	value=""  name="<%=RequestConstants.AU%>" id="<%=idAu %>"  size="7" tabindex="2" />
      </td>
      
      
       <input type="hidden" value=""	id="<%=issuedName%>" class="bigcaption"    />
       <td width="10%">
       <!-- <input type="text" value=""	id="<%=lotNo%>" class="medcaption" onblur="if(testForLotNo(this.value))fillGridIssueToOTAFU('issueDispensaryManualForm','stores?method=fillIssueToOTAFUBasedOnLotNo&lotNo='+this.value , <%=inc %>);" /> -->
      
       <!-- <select name="<%=RequestConstants.BATCH_NO%>" id="<%=lotNo%>" onchange="getDataForBarcode(this.value,<%=inc%>)" onblur="if(testForLotNo(this.value))fillGridIssueToOTAFU('issueDispensaryManualForm','stores?method=fillIssueToOTAFUBasedOnLotNo&lotNo='+this.value , <%=inc %>);"  > -->
       <select name="<%=RequestConstants.BATCH_NO%>" id="<%=lotNo%>" onchange="getDataForBarcode(this.value,<%=inc%>)"  >
			<option value="0">Select Batch</option></select>
			<input type="hidden" name="batchId" id="batchId<%=inc%>" size="10" readonly="readonly" value="" />
			<input type="hidden" name="brandId" id="brandId<%=inc%>" size="10" readonly="readonly" value="" /> 
			</td>
      <td width="2%"><input type="text" tabindex="1" size="1" value="" 
			    readonly="readonly"	name="<%=RequestConstants.BRAND_GENERIC%>" id="BG<%=inc%>"/></td>
			    
			    <td width="10%"><input type="text" size="8" value="" maxlength="30" tabindex="1" name="barCodeNo<%=inc%>" 
			id="barCodeNo<%=inc%>" onchange="getDataForBarcode(this.value,<%=inc%>)" onblur="" /></td> <td width="8%"><input type="text" name="manuDate<%=inc%>" id="manuDate<%=inc%>"	size="10" readonly="readonly" value="" />
			</td>
			</td>
			<td width="8%"><input type="text" name="<%=RequestConstants.EXPIRY_DATE%>" id="expiryDate<%=inc%>"	size="10"  value="" />
			</td>
			<td width="8%"><input type="text" size="4" name="source<%=inc%>" id="source<%=inc%>"	 readonly="readonly" value="" />
			</td>
			
			<td width="10%">
			<input type="text"  size="8" value="" id="stockAvailable<%=inc%>" class="medcaption" readonly />
				</td>
				<td width="8%">
				<input type="text" size="8" value="" id="batchStock<%=inc%>" class="medcaption" readonly /> 
				</td>
				<td width="8%"><input type="text" size="4" name="mmf<%=inc%>" id="mmf<%=inc%>"	 readonly="readonly" value="" />
			</td>
				
			<!--  
        <td width="10%"><input type="hidden" value="0"	id="<%=issuedItemId%>" class="medcaption"  />
        	<input type="text"	value="" validate="Qty Requested Year,floatWithoutSpaces,no" MAXLENGTH="7"  class="medcaption"  readonly="readonly" name="<%=RequestConstants.QTY_IN_REQUEST%>"  "/>
        </td>-->	
         <td width="10%"><input type="text"	size="8" value="" class="medcaption" name="<%=RequestConstants.QTY_ISSUED%>" tabindex="2" id="<%=qtyIssued%>" onblur="checkQty(<%=inc%>)" />
         <td width="8%"><input type="text"  size="8" name="qtyAftrIssued<%=inc%>" id="qtyAftrIssued<%=inc%>" value="" />
    <!--  </td>
      <td width="8%"> <input name="Button" type="button" class="buttonAdd" value="" onclick="" />
      
       <input type="button" class="button" tabindex="1" onclick="openPopupForBrandForLoanOut(<%=inc%>);" name="Submit2" value="Issue "  /> 
         </td> --> 
          </tr>
          
   	   <%
   	   %><input type="hidden" name="counter" id="count"	value="<%=inc%>" />
			 <% }} }catch(Exception e ){e.printStackTrace();} %>
      
         </tbody>
  
</table>
<div class="clear paddingTop15"></div>
</div>
<input type="button" class="button" tabindex="1" onclick="submitForm('issueDispensaryManualForm','/hms/hms/stores?method=addBrandDetailsForLoanOut');" name="Submit2" value="Submit"  />
<input type="button" class="button" value="Next"
	onclick="submitForm('issueDispensaryManualForm','stores?method=addNextOrSubmitIssueForLoanOut&buttonName=next');"
	align="right" /> 
	
	<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" /> 
</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <br />
<%--Start of Change Panel--%> <div class="Clear"></div>
<div class="Clear"></div>
	<div class="bottom">
		<label>Changed By:</label>			
		<label class="value"><%=userName%></label>
        
        <label>Changed Date:</label>			
		<label class="value"><%=date%></label>

        <label>Changed Time:</label>			
		<label class="value"><%=time%></label>

		<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
		<input type="hidden" name="<%=CHANGED_DATE%>" value="<%=date%>"  />
		<input type="hidden" name="<%=CHANGED_TIME%>"  value="<%=time%>" />
</div> <input
	type="hidden" id="totalQty" /> <%--End of Change Panel--%></div>
<script type="text/javascript">

function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
}

function closeSearch()
{

document.getElementById('searchBlock').style.display = 'none';
}


function goRefresh()
{
var issueUnit = document.getElementById('issueId').value;
submitForm('issueDispensaryManualForm','stores?method=searchIssueLoanout&issueUnit='+issueUnit);
}


 function pvmsNomenclatureSearch() 
 {
	var pvmsNo1=document.getElementById("pvmsNo1").value;
	//var ValueOfPage=document.getElementById("page").value;
	var ValueOfPage=1;
	var pageNo =parseInt(document.getElementById('pageNo').value) 
	submitForm('issueDispensaryManualForm','stores?method=addNextOrSubmitIssueForLoanOut&buttonName=goToPage&ValueOfPage='+ValueOfPage+'&pvmsSearch='+pvmsNo1+'');
 }



function goPage()
{
var page = parseInt(document.getElementById('page').value);
var totalPages = parseInt(document.getElementById('totalPages').value);
if (page > totalPages)
{
alert('Kindly provide valid Page No!...');
document.getElementById('page').value="";
return;
}
submitForm('issueDispensaryManualForm','stores?method=addNextOrSubmitIssueForLoanOut&buttonName=goToPage');
}


function test(){
	var errorMessage="";
	formName="issueDispensaryManualForm"
	obj = eval('document.'+formName)
	if(document.getElementById('issuedBy').value == "")
		errorMessage=errorMessage+"Please Select Issue By \n"; 
	if(document.getElementById('approvedBy').value == "")
		errorMessage=errorMessage+"Please Select Approved By \n";
	if(document.getElementById('requestBy').value == "")
		errorMessage=errorMessage+"Please Select Requested By \n";
	if(document.getElementById('departmentIdTemp').value == "")
		errorMessage=errorMessage+"Please Select Dispensary \n";
	if(document.getElementById('docNo').value == "")
		errorMessage=errorMessage+"Please Fill Reference No \n";
	
	if((document.getElementById('issuedBy').value != "") &&(document.getElementById('docNo').value != "") &&(document.getElementById('departmentIdTemp').value != "") &&(document.getElementById('requestBy').value != "")&&(document.getElementById('approvedBy').value != "")){
		return true;
	}else{
		alert(errorMessage)
		return false
	}

}

// javed khan

  function ajaxFunctionForAutoCompleteIssueToDispensary(formName,action,rowVal) {
	 // alert(formName+" >>>>javed >>> ajaxFunctionForAutoCompleteIssueToDispensary"+action)
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
	    	  var lotNo="lotNo"+rowVal;
	    	 // alert("javed 1>>> "+lotNo)
	    	  
	    	  obj = document.getElementById(lotNo);
				obj.length = 1;
				// alert("javed 2>>> "+obj.length)
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	//var stock =xmlHttp.responseXML.getElementsByTagName('items')[1];
	      	
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		        var name  = item.getElementsByTagName("name")[0];
		        var BG  = item.getElementsByTagName("BrandG")[0];
		        var stock  = item.getElementsByTagName("stock")[0];
		        var batchLength  = item.getElementsByTagName("batches")[0];
	        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
	        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
	        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
	        	document.getElementById('issuedName'+rowVal).value = name.childNodes[0].nodeValue
	        	
	        	//document.getElementById('issuedItemId'+rowVal).value = id.childNodes[0].nodeValue
	        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
	        	//document.getElementById('BG'+rowVal).value = BG.childNodes[0].nodeValue
	        	document.getElementById("stockAvailable"+rowVal).value=stock.childNodes[0].nodeValue;
	        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
	        	{
	        		var batch = batchLength.childNodes[innerLoop];
		        	var batchId  = batch.getElementsByTagName("batchId")[0];
		        	var batchName  = batch.getElementsByTagName("batchName")[0];
		        	//alert(batchId.childNodes[0].nodeValue+"<<<abtch >  "+batchName.childNodes[0].nodeValue)
		        	obj.length++;
					//obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
		        	obj.options[obj.length-1].value=batchName.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=batchName.childNodes[0].nodeValue;
		        	
	        	}
	       
	        	
	      	} 
	      	
	     /* 	for (loop = 0; loop < stock.childNodes.length; loop++) 
	      	{
		   	    var stk = stock.childNodes[loop];
		   	    var stock_value = stk.getElementsByTagName("stk")[0];
		        alert(stock_value);
	      	} */
	      	
	      }
	    }
	    //var url=action+"&"+getNameAndData(formName)
	    var url=action
	    // alert(url)
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	    
	  }



//javed khan

  function ajaxFunctionForAutoCompleteIssueToDispensaryPvms(formName,action,rowVal) {
	 // alert(formName+" >>>>javed >>> ajaxFunctionForAutoCompleteIssueToDispensary"+action)
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
	    	  var lotNo="lotNo"+rowVal;
	    	 // alert("javed 1>>> "+lotNo)
	    	  
	    	  obj = document.getElementById(lotNo);
				obj.length = 1;
				// alert("javed 2>>> "+obj.length)
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	//var stock =xmlHttp.responseXML.getElementsByTagName('items')[1];
	      	
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		   	 var nomen  = item.getElementsByTagName("nomen")[0];
		        var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		        var name  = item.getElementsByTagName("name")[0];
		        var BG  = item.getElementsByTagName("BrandG")[0];
		        var stock  = item.getElementsByTagName("stock")[0];
		        var batchLength  = item.getElementsByTagName("batches")[0];
		        document.getElementById('nameItem'+rowVal).value = nomen.childNodes[0].nodeValue
	        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
	        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
	        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
	        	document.getElementById('issuedName'+rowVal).value = name.childNodes[0].nodeValue
	        	
	        	//document.getElementById('issuedItemId'+rowVal).value = id.childNodes[0].nodeValue
	        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
	        	//document.getElementById('BG'+rowVal).value = BG.childNodes[0].nodeValue
	        	document.getElementById("stockAvailable"+rowVal).value=stock.childNodes[0].nodeValue;
	        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
	        	{
	        		var batch = batchLength.childNodes[innerLoop];
		        	var batchId  = batch.getElementsByTagName("batchId")[0];
		        	var batchName  = batch.getElementsByTagName("batchName")[0];
		        	//alert(batchId.childNodes[0].nodeValue+"<<<abtch >  "+batchName.childNodes[0].nodeValue)
		        	obj.length++;
					//obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
		        	obj.options[obj.length-1].value=batchName.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=batchName.childNodes[0].nodeValue;
		        	
	        	}
	       
	        	
	      	} 
	      	
	     /* 	for (loop = 0; loop < stock.childNodes.length; loop++) 
	      	{
		   	    var stk = stock.childNodes[loop];
		   	    var stock_value = stk.getElementsByTagName("stk")[0];
		        alert(stock_value);
	      	} */
	      	
	      }
	    }
	    //var url=action+"&"+getNameAndData(formName)
	    var url=action
	    // alert(url)
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	    
	  }
  
  function getDataForBarcode(val,rowVal)
  {
  	
      var itemId=document.getElementById('idItem'+rowVal).value;
  	submitProtoAjaxForBarcodeData('issueDispensaryManualForm','stores?method=getDataForBarcode&barCode='+val+'&itemId='+itemId,rowVal);
  }

  function submitProtoAjaxForBarcodeData(formName,action,rowVal)
  {
  	  //alert("submitProtoAjax in issue other unit");
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
  	      if(xmlHttp.readyState==4)
  		  {
  	    	  
  	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
  	      	if(items.childNodes.length!=0)
  		    {
  	      	for (loop = 0; loop < items.childNodes.length; loop++)
  		    {
  		       
 		   	    var item = items.childNodes[loop];
 		   	var availableStock=item.getElementsByTagName("availableStock")[0];
 		        var pvms  = item.getElementsByTagName("pvms")[0];
 		        var au  = item.getElementsByTagName("au")[0];
  		      
  		       var batchNo=item.getElementsByTagName("batchNo")[0];
  		       var batchId=item.getElementsByTagName("batchId")[0];
  		       var brandId=item.getElementsByTagName("brandId")[0];
  		       var expiryDate=item.getElementsByTagName("expiryDate")[0];
  		       var source=item.getElementsByTagName("source")[0];
  		     var mmf=item.getElementsByTagName("mmf")[0];
  		   var BG  = item.getElementsByTagName("BG")[0];
  		   
  		      	 //var barcodeNo=item.getElementsByTagName("barCodeNo")[0];
  		       	//  var id  = item.getElementsByTagName("id")[0];
  		        //var name  = item.getElementsByTagName("name")[0];
  		      
  		   		 //   var manuDate=item.getElementsByTagName("dom")[0];
  		     
  		     	//  var costPrice=item.getElementsByTagName("costPrice")[0];
  	        	
  	        	//document.getElementById("au"+rowVal).value=au.childNodes[0].nodeValue;
  	        	document.getElementById("lotNo"+rowVal).value=batchNo.childNodes[0].nodeValue;
  	        	
  	        	document.getElementById("batchId"+rowVal).value=batchId.childNodes[0].nodeValue;
  	        	
  	        	document.getElementById("expiryDate"+rowVal).value=expiryDate.childNodes[0].nodeValue;
  	        	//document.getElementById("qtyStock"+rowVal).value=availableStock.childNodes[0].nodeValue;
  	        	document.getElementById("batchStock"+rowVal).value=availableStock.childNodes[0].nodeValue;
  	        	
  	        	document.getElementById("brandId"+rowVal).value=brandId.childNodes[0].nodeValue;
  	        	//document.getElementById("costPrice"+rowVal).value=costPrice.childNodes[0].nodeValue;
  	        	
  	        	// add javed khan on 16-08-2012
  	        	document.getElementById('BG'+rowVal).value = BG.childNodes[0].nodeValue
  	       // add javed khan on 16-08-2012
  	        	document.getElementById("mmf"+rowVal).value=mmf.childNodes[0].nodeValue;
  	        	//document.getElementById("manuDate"+rowVal).value=manuDate.childNodes[0].nodeValue;
  	        	
  	        	document.getElementById("qtyIssued"+rowVal).focus();
  	        	document.getElementById("source"+rowVal).value=source.childNodes[0].nodeValue;
  	         }
  	      	}
  	      	else{
  	      		 document.getElementById("barCodeNo"+rowVal).value="";
  	      	   alert("Invalid Barcode ");
  	     
  	      	}
  	      }
  	    }
  	   // var url=action+"&"+getNameAndData(formName)
var url=action
  	    xmlHttp.open("GET",url,true);
  	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
  	    xmlHttp.send(null);

  	  }

  function checkQty(rowVal)
  {// javed khan
	
  	var val = document.getElementById('qtyIssued'+rowVal).value
  
  
  	//if(!val.equals("")){
  		 if(parseInt(document.getElementById('qtyIssued'+rowVal).value) > parseInt(document.getElementById('batchStock'+rowVal).value))
  		{
  			alert("Issued Quantity can't be greater than Batch stock Quantity .");
  			document.getElementById('qtyIssued'+rowVal).value="";
  			document.getElementById("qtyIssued"+rowVal).focus();
  		}else{
  					var a=document.getElementById('qtyIssued'+rowVal).value;
  				var b=document.getElementById('batchStock'+rowVal).value;
          	
  			document.getElementById("qtyAftrIssued"+rowVal).value=b-a;
  		}
  	//}
  	
  }
  
</script>
