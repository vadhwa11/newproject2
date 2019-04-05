<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * issueToDispensary.jsp
 * Purpose of the JSP -  This is for issue to Dispensary.
 * @author  Vivek
 * Create Date: 21th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.8
--%>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreIssueT"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

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
	Map map = new HashMap();
	String userName="";
	String date="";
	String time="";

	String includedJsp = null;
	String previousPage="no";
	int nrs=0;
	String indentOption="";
	int pageNo=1;
	int indentId=0;
	int internalIndentId=0;
	int listSize=0;
	int issueId=0;
	String max="";
	String pvmsNo1="";
	String issuemstatus = "";
	String message = "";
	List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
	List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
	List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
	List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
	List<MasStoreAirForceDepot> masStoreAirForceDepotList= new ArrayList<MasStoreAirForceDepot>();
	List issueTList=new ArrayList();
	List <StoreIssueM> searchListForPopup=new ArrayList<StoreIssueM>();
		int maxIndentNo=0;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	Box box=HMSUtil.getBox(request);
		if(map.get("employeeList")!=null){
			employeeList = (List) map.get("employeeList");
		}
		if(map.get("storeInternalIndentMList")!=null)
			storeInternalIndentMList = (List) map.get("storeInternalIndentMList");
		if(map.get("storeInternalIndentTList")!=null)
			storeInternalIndentTList = (List) map.get("storeInternalIndentTList");
		if(map.get("departmentList")!=null)
			departmentList = (List) map.get("departmentList");

		// not used in jsp and not known from where it is coming
		if(map.get("masStoreAirForceDepotList")!=null)
			masStoreAirForceDepotList = (List) map.get("masStoreAirForceDepotList");

		if(map.get("internalIndentId")!=null){
			internalIndentId=Integer.parseInt(""+map.get("internalIndentId"));
		}
		// not used in jsp and not known from where it is coming
		if(map.get("issueMStatus")!=null){
			issuemstatus=(String)map.get("issueMStatus");
		}

		if(map.get("issueTList")!=null){
			issueTList=(List)map.get("issueTList");
			System.out.println("issueTList " +issueTList.size());
		}
		if(map.get("searchListForPopup")!=null){
			searchListForPopup=(List<StoreIssueM>)map.get("searchListForPopup");
		}
		List stockList= new ArrayList();
		if(map.get("stockList")!=null){
			stockList=(List)map.get("stockList");
		}
		List loanOutQtyList= new ArrayList();
		if(map.get("loanOutQtyList")!=null){
			loanOutQtyList=(List)map.get("loanOutQtyList");
		}
		if(map.get("max")!=null)
			max = (String) map.get("max");
		if(map.get("pageNo")!=null)
			pageNo = Integer.parseInt(""+map.get("pageNo"));
		if(map.get("listSize")!=null)
			listSize = Integer.parseInt(""+map.get("listSize"));
		String deptName="";
		if(map.get("deptName")!=null){
			deptName=(String)map.get("deptName");
		}

		if(map.get("pvmsNo1")!=null){
			pvmsNo1=(String)map.get("pvmsNo1");
			box.put("pvmsNo1",pvmsNo1);
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		 date = (String)utilMap.get("currentDate");
		 time = (String)utilMap.get("currentTime");
		 if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
		 if(map.get("issueId")!=null)
			 issueId = Integer.parseInt(""+map.get("issueId")) ;

		 if(map.get("message")!=null)
			 message = (String)map.get("message") ;

		 if(map.get("box")!=null)
			 box =(Box) map.get("box") ;
		 if(box.get("requestDate")!=null){
				box.put(RequestConstants.REQUEST_DATE,box.get("requestDate"));
			}
		 if(map.get("requestNo")!=null){
			 box.put("requestNo",(Integer)map.get("requestNo"));
		 }

		 if(box.get("issueDate")!=null){
				box.put(RequestConstants.ISSUE_DATE,box.get("issueDate"));
			}
		 if(map.get("requestDate")!=null){
				box.put(RequestConstants.REQUEST_DATE,(String)map.get("requestDate"));
			}
		 if(map.get("issueDate")!=null){
			 box.put(RequestConstants.ISSUE_DATE,(String)map.get("issueDate"));
			}
		 List<UserButtonRights> userRightsList= new ArrayList<UserButtonRights>();
			if (map.get("userRightsList") != null) {
				userRightsList = (List<UserButtonRights>)map.get("userRightsList") ;
			}

		int totalPages=0;
		 if(map.get("totalPages")!=null){
			 totalPages=(Integer)map.get("totalPages");
			}
		 
		// add by javed khan
			Map mapbatch = new HashMap();
			if (map.get("mapbatch") != null) {
				mapbatch = (Map) map.get("mapbatch");
				System.out.println("this is my batchlist  " + mapbatch.size()
						+ ">>>>>>>>>>");	
			}
			
			List<StoreIssueT> loanList = new ArrayList<StoreIssueT>();
			if(map.get("loanList")!=null){
				loanList=(List<StoreIssueT>)map.get("loanList");
			}
%>
<script language="javascript">

	function checkForIssueToDispensary(val,a,inc)
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

		ajaxFunctionForAutoCompleteIssueToDispensary('issueDispensaryForm','stores?method=fillItemsForIssueToDispensary&pvmsNo=' +  pvms , inc);
}
	function test(){
		if(document.getElementById('mmfForTheYear').value ==0){
			alert("Please Select MMF Year..!");
			return false;
		}else{
			return true;
		}
}

    function fillValuesForPvms(pvmsNo,rowVal){
    //alert("In fillValuesForPvms----- "+document.getElementById('nameItem'+rowVal).value)
   document.getElementById('nameItem'+rowVal).value="";
   document.getElementById('idAu'+rowVal).value="";
    	ajaxFunctionForAutoCompleteIssueToDispensaryByPvmsNo('issueDispensaryForm','stores?method=fillItemsForIssueToDispensaryByPvmsNo&pvmsNo=' +  pvmsNo , rowVal);


    }

   function pvmsNomenclatureSearch()
   {
		var pvmsNo1=document.getElementById("pvmsNo1").value;
		//var ValueOfPage=document.getElementById("page").value;
		var ValueOfPage=1;
		var pageNo =parseInt(document.getElementById('pageNo').value)
		submitForm('issueGrid','stores?method=updateNextOrSubmitIssueToCiv&buttonName=goToPage&ValueOfPage='+ValueOfPage+'&pvmsSearch='+pvmsNo1+'');
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

submitForm('issueGrid','stores?method=updateNextOrSubmitIssueToCiv&buttonName=goToPage');
}

function goNext()
{
if (checkDateForIssueCiv()&&checkDateForIssueCiv())
{
	var pvmsNo1=document.getElementById("pvmsNo1").value;
	var ValueOfPage=document.getElementById("page").value;
	submitForm('issueGrid','stores?method=updateNextOrSubmitIssueToCiv&buttonName=next&pvmsSearch='+pvmsNo1+'');
}
}


function goRefresh()
{
var issueUnit = document.getElementById('issueId').value;
submitForm('issueDispensaryForm','stores?method=searchIssueCiv&issueUnit='+issueUnit);
}

function civclose(){
var issueUnit = document.getElementById('issueId').value;
       if(confirm("Are You sure, You want to close the CIV ?")){
	       submitForm('issueDispensaryForm','stores?method=closeIssueCiv&issueUnit='+issueUnit);
			return true;
	   }else{
		  return false;
       }
}

function del()
	{
    	if (validateDeleteButton())
		{
		document.issueGrid.method="post";
		submitForm('issueGrid','stores?method=deleteGridItemsIssueToDispensary&issueId='+<%=issueId%>);
		}
		else
		{
		alert('No Item(s) Selected for delete!....');
		}
	}
	function validateDeleteButton()
	{
		if (document.issueGrid.<%=ITEMS_TO_BE_DELETED%>.length)
		{
				 for(var i = 0; i < document.issueGrid.<%=ITEMS_TO_BE_DELETED%>.length; i++)
				 {
				  if (document.issueGrid.<%=ITEMS_TO_BE_DELETED%>[i].checked == true){
	             		return true;
	              }
				 }
		}
		else
		{
			if (document.issueGrid.<%=ITEMS_TO_BE_DELETED%>.checked == true)
				return true;
		}
		return false;
	}

	function searchPvmsOnEnter(myfield,e)
	{

		obj1 = true;
		var keycode;
		if (window.event)
			 keycode = window.event.keyCode;
		else if (e)
			keycode = e.which;
		else return true;
		if (keycode == 13)
		   {
			pvmsNomenclatureSearch();
		   }

	}
 </script>
 
<form name="issueDispensaryForm" method="post">
<%-- Start of Main Form --%>
 
<div class="titleBg"><h2>Department Issue-Modify</h2></div>
<!--  
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>-->
<div class="clear"></div>

		<%if(issuemstatus.equalsIgnoreCase("p") && message.equals("")){%>
		<h4>
		<%="'"+max+box.get("issueNo")+"' CIV is closed" %>
		</h4>
		<%} else if(!message.equals("")) { %>
		
		<h4 id="errorMsg">
			<%=message%>
		</h4>

		<%} %>


<%--------------- Start of Search Panel ---------------------------%>
<!-- 
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<form name="searchPanel" method="post">
<label>CIV No.</label>
<select	name="<%= RequestConstants.ISSUE_UNIT_ID%>"">
			<option value="">Select</option>
			<%for (StoreIssueM storeIssueM :searchListForPopup ) {%>
			<option value=<%=storeIssueM.getId()%>><%=storeIssueM.getIssueNo()%></option>
			<%}%>
		</select>
		<input type="image" class="button" value="" onClick="submitForm('issueDispensaryForm','stores?method=searchIssueCiv');" />

</form>
</div>
 -->
<%-------------------- End of Search Panel ---------------------------%>
</form> 
<form name="issueGrid" method="post">
<input type="hidden" name="listSize" value="<%=listSize%>" />
<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" />
<div class="clear"></div>
<h4>Issue Details</h4>
<div class="Block">
<label> CIV No. </label>
<input	type="text" name="<%=RequestConstants.ISSUE_NO %>"	value="<%=box.get("issueNo")%>" id="issueNo"  MAXLENGTH="8" readonly />

<label>CIV Date</label>
<input type="text" name="<%=RequestConstants.ISSUE_DATE%>"	class="date" id="<%= RequestConstants.ISSUE_DATE %>" readonly="readonly"	value="<%=box.get("issueDate") %>"   MAXLENGTH="30" />
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=date1%>',document.issueGrid.<%=RequestConstants.ISSUE_DATE%>,event)" />

<label>Department</label>
<select	name="<%= RequestConstants.DEPARTMENT_ID_TEMP%>" disabled="disabled" id="departmentIdTemp" validate='Dispensery Name,num,Yes'>
<option value="">Select</option>
	<%for (MasDepartment department :departmentList ) {	%>
<option value=<%=department.getId()%>
		<%=HMSUtil.isSelected(department.getId().toString(),box.get("departmentIdTemp")) %>><%=department.getDepartmentName()%></option>
	<%}	%>
</select>

<div class="clear"></div>

<%if(deptName.equalsIgnoreCase("Dispensary Store")){ %>
<label>Reference No.</label>
<input	type="text" name="<%= RequestConstants.REFERENCE %>" id="reference"	value="<%=box.get("reference") %>"  MAXLENGTH="30" />
<%} %>

<label>Indent Date</label>
<input type="text"	name="<%= RequestConstants.REQUEST_DATE %>"	id="<%= RequestConstants.REQUEST_DATE %>"	value="<%=box.get("requestDate") %>"  disabled MAXLENGTH="30" />

<label>Indent No.</label>
<input type="text" name="<%= RequestConstants.REQUEST_NO%>" value="<%=box.get("indentNo") %>" readonly="readonly">
<%-- commented by ritu --%>
<%-- 
<%if(box.get("requestNo")!="") {%>
<select name="<%= RequestConstants.REQUEST_NO%>" onchange="submitForm('issueDispensaryForm','stores?method=searchInternalIndentDetails');" >
<option value="0">Select</option>
	<%try{
					for (StoreInternalIndentM storeInternalIndentM :storeInternalIndentMList ) {
					System.out.println(HMSUtil.isSelected(storeInternalIndentM.getId().toString(),box.get("requestNo"))+"<123>"+storeInternalIndentM.getId());
					if(storeInternalIndentM.getDemandNo()!=null){
					%>
<option value=<%=storeInternalIndentM.getId()%>
		<%=HMSUtil.isSelected(storeInternalIndentM.getId().toString(),box.get("requestNo")) %>><%=storeInternalIndentM.getDemandNo()%></option>
	<%}}}catch(Exception e){	e.printStackTrace();
					}%>
</select>


<%}else{ %>
<select name="<%= RequestConstants.REQUEST_NO%>">
<option value="0">Select</option>
	<%try{for (StoreInternalIndentM storeInternalIndentM :storeInternalIndentMList ) {%>
<option value=<%=storeInternalIndentM.getId()%>
		<%=HMSUtil.isSelected(storeInternalIndentM.getId().toString(),box.get("requestNo")) %>><%=storeInternalIndentM.getDemandNo()%></option>
	<%	}
					}catch(Exception e){
					e.printStackTrace();
					}%>
</select>
<%} %> --%>

<label>Requested By</label>
<select	name="<%= RequestConstants.REQUEST_BY%>" id="requestBy"	validate="Request By,String,Yes">
<option value="">Select</option>
<%for (MasEmployee masEmployee :employeeList ) {%>
<option value=<%=masEmployee.getId()%>
<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("requestBy")) %>><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select>

<div class="clear"></div>
<!--  
<label>Approved By</label>
<select	name="<%= RequestConstants.APPROVED_BY%>" id="approvedBy"	validate="Approved By,String,Yes">
	<option value="">Select</option>
	<%for (MasEmployee masEmployee :employeeList ) {%>
	<option value=<%=masEmployee.getId()%>
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("approvedBy")) %>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select>
-->
<input type="hidden" name="<%=RequestConstants.DEPARTMENT_ID_TEMP%>" id="departmentIdTemp"	  validate='Dispensery Name,num,Yes' value="35">
<label>Issued By</label>
<select	name="<%= RequestConstants.ISSUED_BY%>" id="issuedBy" validate="Issued By,String,Yes">
<option value="">Select</option>
	<%for (MasEmployee masEmployee :employeeList ) {%>
<option value=<%=masEmployee.getId()%>
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("issuedBy")) %>><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select>


<input type="hidden" name="<%=RequestConstants.ISSUE_ID%>"	id="issueId" value="<%=issueId %>" />
<% if(!issuemstatus.equalsIgnoreCase("p")){
					 for(UserButtonRights  userButtonRights : userRightsList){
							String buttonName=userButtonRights.getButton().getButtonName();
						    if(userButtonRights.getButton().getFormName().equals("CIV Close")){
							String formulaUsed=userButtonRights.getButton().getFormulaUsed();

				%>
				


<!--   <input type="button" name="sss" align="right" class="button" value="Submit" onclick="if(checkDateForIssueCiv()&&checkForSubmit()){submitForm('issueGrid','stores?method=updateNextOrSubmitIssueToCiv&buttonName=submit');}"/>  -->

<div class="Clear"></div>
<input type="button" name="closeciv" value="<%=userButtonRights.getButton().getButtonName() %>"	onClick="<%=userButtonRights.getButton().getUrl()%>" class="<%=userButtonRights.getButton().getClassName() %>" /> <%}}}%>
</div>
<div class="clear"></div>
<div class="clear"></div>
<!--  
<input type="button" class="button" value="Next" onclick="javascript:goNext();"	align="right" />
-->
<div class="Clear"></div>
<%-- 
<div id="pagination">
Page No.
<span  class="selected"><%=pageNo%></span>
<input type="text" name="ValueOfPage" class="small"	<%if(box.getString("pvmsNo1").equals("")){ %> value="<%=pageNo+1%>"	<%}else{%> value="" <%}%> id="page" MAXLENGTH="3" />
<input type="button" name="goToPage" type= "submit" value="Go"	onClick="goPage()" class="buttonSm" />

Total Pages:
<span  class="selected"><%=totalPages%><span  class="selected">

<input type="button" name="Refresh" value="Refresh"	onClick="goRefresh();" class="button" />
<input type="hidden" value="0" name="noOfRows" id="noOfRows" />
<input type="hidden" name="<%=RequestConstants.INDENT_ID %>" value="<%=indentId%>" id="hdb" />
<input type="hidden" name="totalPages" id="totalPages"	value="<%=totalPages%>" />
</div>--%>
<input type="hidden" name="<%=RequestConstants.INDENT_ID %>" value="<%=indentId%>" id="hdb" />
<div class="Clear"></div>
<!-- 
<label>PVMS/NIV</label>
<input type="text"	name="pvmsNo1" id="pvmsNo1" value="<%=box.getString("pvmsNo1") %>"	tabindex=1 onkeypress="searchPvmsOnEnter(this,event);" />
<IMG SRC="/hms/jsp/images/search.gif" tabindex=1 style="cursor: pointer;float:left;" onClick="javascript:pvmsNomenclatureSearch();" title="Click here to Search Pvms/Niv" />
 -->
 	<%
		String itemId = "";
		Object I = null;
	%>
<input type="hidden" name="searchFirstTime" id="searchFirstTime" value="" />
<div class="clear"></div>
<div class="clear"></div>
<div class="Clear"></div>
<h4>Item Details</h4>
<div class="clear"></div>
<div class="clear"></div>
<div class="Clear"></div>
<!-- <input	type="button" name="delete" type="submit" class="button" value="Delete" onClick="del();" /> -->
<div style="height:350px; width:1000px; overflow-x:  scroll; overflow-y: scroll ;">  
<table colspan="7" id="indentDetails"  cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th width="5%">Sl No.</th>
			<th width="13%">PVMS/NIV No.</th>
			<th width="10%">Nomenclature</th>
			<th width="13%">B/G</th>
			<th width="13%">Barcode</th>
			<th width="13%">A/U</th>
			<th width="13%">Batch No.</th>
			<th width="13%">DOM</th> 			 
			<th width="13%">DOE</th>
			<th width="6%">Available</br>Stock</th>
			<th width="13%">Batch</br>Stock</th> 
			<th width="13%">Qty</br>Demanded</th>
			
			<!-- -
			<th width="6%">Loan	Out Qty</th> -->
			<th width="13%">Qty</br>On Loan</th>
			<th width="13%">Qty</br>Issued</th>
			
			<th width="10%">Add</th>
			<th width="10%">Delete</th>
		</tr>

	</thead>
	<tbody>


		<%try{
    	int detailCounter=10;
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idAu="idAu";
    	String qtyRequested="qtyRequested";
    	String incVar="incVar";
    	String issuedItemId="issuedItemId";
    	String loanOutQty="loanOutQty";
    	String issued="";

    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idAu2="idAu";
    	String qtyRequested2="qtyRequested";
    	String incVar2="incVar2";
    	String issuedItemId2="issuedItemId";
    	String loanOutQty2="loanOutQty";
    	String qtyIssued="qtyIssued";
    	String qtyIssued2="qtyIssued";
    	String detailId="detailId";
    	String detailId2="detailId";

    	String issuedName="issuedName";
    	String issuedName2="issuedName";
    //	String lotNo="lotNo";
    //  String lotNo2="lotNo";
    	int inc=((pageNo-1)*20)+1;
    	int tempVar=((pageNo-1)*20)+1;
 	   int tempInc=0;
 	  int tempInc2=0;
 	   int incTemp2=inc+20;

 		for (Iterator iterator = issueTList.iterator(); iterator.hasNext();)
		{
		 Object[] object = (Object[]) iterator.next();
System.out.println("object"+object[9]);
 		  tempVar--;

 		 // if(inc<incTemp2){
 			 tempInc=tempInc2++;
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idAu=idAu2+(""+inc);
     		qtyRequested=qtyRequested2+(""+inc);
     		incVar=incVar2+(""+inc);
     		issuedItemId=issuedItemId2+(""+inc);
     		qtyIssued=qtyIssued2+(""+inc);
     		detailId=detailId2+(""+inc);
     		issuedName=issuedName2+(""+inc);
     		loanOutQty=loanOutQty2+(""+inc);
     		//lotNo=lotNo2+(""+inc);
     		if(object[12]== null){
    	  %>
    	  
		<tr>
			<td width="5%">
			<input type="text" size="2" value="<%=temp+inc%>" name="<%=RequestConstants.SR_NO%>" readonly="readonly" />
			</td>
			<td width="10%">
			<input type="text"	size="10" name="<%=RequestConstants.ITEM_CODE%>"	value="<%=object[1].toString() %>" id="pvmsNo<%=inc%>" />
			<input type="hidden" value="<%=object[0].toString() %>"	name="itemId<%=inc%>"  id="itemId<%=inc%>" />
			<input	type="hidden" value="<%=object[6].toString() %>" name="<%=RequestConstants.DETAIL_ID%>" id="<%=detailId%>" />
			<input type="hidden"	name="<%=RequestConstants.ITEM_CODE%>"	value="<%=object[1].toString() %>" id="<%=codeItem%>" />
			
			
			</td>
			<td width="10%">
			<input type="text"	value="<%=object[2].toString() %>" size="45" readonly="readonly" name="<%=RequestConstants.NOMENCLATURE%>"
			id="nomenclature<%=inc%>"  />
			</td>
			 <td width="2%"><input type="text" tabindex="1" size="2" value="<%=object[10].toString()%>" 
			    readonly="readonly"	name="<%=RequestConstants.BRAND_GENERIC%>" id="BG<%=inc%>"/></td>

			<td width="10%"><input type="text" size="8" value="" maxlength="30" tabindex="1" name="barCodeNo<%=inc%>" 
			id="barCodeNo<%=inc%>" onchange="getDataForBarcode(this.value,<%=inc%>)" onblur="getDataForBarcode(this.value,<%=inc%>)" /></td>

			<td width="10%">
			<%try{ %>
			<input type="text" size="7" value="<%=object[3].toString() %>" readonly="readonly" name="<%=RequestConstants.AV%>" id="au<%=inc%>" />
			<%}catch(Exception e){ %>
			<input type="text" size="7" value=""  readonly="readonly" name="<%=RequestConstants.AV%>" id="au<%=inc%>" />
			<%} %>
			</td>
			
			 <%if(object[11].equals("0")){ %>
			<td width="10%">
			<%
				List lis = new ArrayList();
								lis = (List) mapbatch.get(object[0]);
								itemId = object[0].toString();
								I = object[0];
								System.out.println("this is noth" + lis.size());
			%>
			<select name="batchNo<%=inc%>" id="batchNo<%=inc%>" onchange="if(cheackForBatch(<%=inc%>)){getDataForBarcode(this.value,<%=inc%>)}" >
			<option value="0">Select Batch</option>
			<%
				for (int j = 0; j < lis.size(); j++) {
			%>
			<option value="<%=lis.get(j)%>" ><%=lis.get(j)%></option>
			<%
				}
			%>
			</select>
			<input type="hidden" name="batchId<%=inc%>" id="batchId<%=inc%>" size="10" readonly="readonly" value="" />
			<input type="hidden" name="brandId<%=inc%>" id="brandId<%=inc%>" size="10" readonly="readonly" value="" />
			</td>
			<%}else{ %>
			<td width="10%">
			<%
				List lis = new ArrayList();
								lis = (List) mapbatch.get(object[0]);
								itemId = object[0].toString();
								I = object[0];
								System.out.println("this is noth" + lis.size());
			%>
			<select name="batchNo<%=inc%>" id="batchNo<%=inc%>" onchange="getDataForBarcode(this.value,<%=inc%>)" >
			<option value="<%=""+ object[11]%>"><%=""+ object[11]%></option>
			<%
				for (int j = 0; j < lis.size(); j++) {
			%>
			<option value="<%=lis.get(j)%>" ><%=lis.get(j)%></option>
			<%
				}
			%>
			</select>
			<input type="hidden" name="batchId<%=inc%>" id="batchId<%=inc%>" size="10" readonly="readonly" value="" />
			<input type="hidden" name="brandId<%=inc%>" id="brandId<%=inc%>" size="10" readonly="readonly" value="" />
			</td>
			<%} %>
			
			<td width="8%"><input type="text" name="manuDate<%=inc%>" id="manuDate<%=inc%>"	size="10" readonly="readonly" value="" />
			</td>
			<%if(object[7] != null){ %>
			</td>
			<td width="8%"><input type="text" name="expiryDate<%=inc%>" id="expiryDate<%=inc%>"	size="10" readonly="readonly"
			 value="<%=HMSUtil.changeDateToddMMyyyy((Date)object[7])%>" />
			</td>
			<%}else{ %>
			<td width="8%"><input type="text" name="expiryDate<%=inc%>" id="expiryDate<%=inc%>"	size="10" readonly="readonly"
			 value="" />
			</td>
			<%} %>
			
			
			<!-- Available stock -->
			<td width="10%">
			<%if(stockList.size()>0){
    	   %> <input type="text" size="8" value="<%=stockList.get(tempInc) %>"	id="stockAvailable<%=inc%>"  readonly />
    	   <%}else{ %>
    	   <input type="text" size="8" value="0" id="stockAvailable<%=inc%>" readonly />
    	   <%} %>
			</td>
			
			<td width="7%">
			
			 <input type="text" size="8"
				value="" id="batchStock<%=inc%>"
				class="medcaption" readonly />
 </td>
			
			<!-- Available stock -->
			<td width="10%">
			<input type="text" size="8"	value="<%=object[8]%>" readonly="readonly" name="<%=RequestConstants.QTY_IN_REQUEST+""+inc%>" id="<%=qtyRequested%>" />
			</td>
			<input type="hidden" value="<%=object[2].toString() %>"	id="<%=nameItem%>" name="<%=RequestConstants.NOMENCLATURE%>" />
			<input type="hidden" name="" value="0" id="<%=issuedItemId%>" />
			<!-- to display loan out quantity -->
		<!-- -	<td width="10%">
			<%if(loanOutQtyList.size()>0){%>
			<input type="text"	value="<%=loanOutQtyList.get(tempInc) %>" id="<%=loanOutQty %>"	 readonly />
			<%}else{ %>
			<input type="text"	value="0" id="<%=loanOutQty%>"  readonly />
			<%} %>
			</td> -->
			<!-- to display loan out quantity -->
			
			
			
			<td width="10%">
			<%if(loanList.size()>0){
				int lQty=0;
				for(StoreIssueT sit : loanList){
					System.out.println(Integer.parseInt(object[0].toString())+" in jsp "+sit.getItem().getId());
					if(Integer.parseInt(object[0].toString())==sit.getItem().getId()){
						lQty= lQty+sit.getQtyIssued().intValue();
					}
				}
				if(lQty > 0){
				
			%>
			<input type="text"	size="8" value="<%=lQty %>" id="<%=loanOutQty %>"	 readonly />
			<%}else{ %>
			<input type="text"	 size="8" value="0" id="<%=loanOutQty%>"  readonly />
			<%} }else{%>
			<input type="text" size="8"	value="0" id="<%=loanOutQty%>"  readonly />
			<%} %>
			</td>
			
			
			<%if( object[9] != null){ %>
			<td width="10%">
			<input type="text" size="8" readonly="readonly"	value="<%=object[9] %>" name="qtyIssued<%=inc %>" tabindex="2"	id="qtyIssued<%=inc %>" />
			</td>
			<%}else{ %>
			<td width="10%">
			<input type="text"  size="8" 	value="" name="qtyIssued<%=inc %>" tabindex="2"	id="qtyIssued<%=inc %>"
			onblur="checkQty(<%=inc%>)" />
			</td>
			<%} %>
			
			<td width="3%">
			<%-- <input type="button" class="Button" value="Go"	onclick="{openPopupForBrand(this.value,'<%=object[8].toString() %>',<%=inc%>,<%=issueId %>,<%=object[6].toString() %>);}"	name="Submit" />  --%>
			<input name="Button" type="button" class="buttonAdd" value="" onclick="generateRowIssueCIV(<%=inc%>);" /></td>

			<td width="3%">
			<!-- <input type="checkbox" class="radio" name=<%=ITEMS_TO_BE_DELETED%> value="<%=object[0].toString()%>"> -->
			 <input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('indentDetails','hdb',this);"  tabindex="1" />
			</td>
		</tr>
		<% inc++;}  }
 		  //}
       					if(inc<=(pageNo-1)*20+20){
	    			  for(;inc<=(pageNo-1)*20+20;inc++){
	    				  	idItem=idItem2+(""+inc);
	    		     		codeItem=codeItem2+(""+inc);
	    		     		nameItem=nameItem2+(""+inc);
	    		     		idAu=idAu2+(""+inc);
	    		     		qtyRequested=qtyRequested2+(""+inc);
	    		     		incVar=incVar2+(""+inc);
	    		     		issuedItemId=issuedItemId2+(""+inc);
	    		     		qtyIssued=qtyIssued2+(""+inc);
	    		     		detailId=detailId2+(""+inc);
	    		     		issuedName=issuedName2+(""+inc);
	    		     		loanOutQty=loanOutQty2+(""+inc);
	    			  %>
	    			 
		<%}} }catch(Exception e ){e.printStackTrace();}
	    			  %> 
	</tbody>
</table><input type="hidden" name="counter" id="listsize"	value="<%=issueTList.size()%>" />
</div>
<input type="button" class="button" tabindex="1" onclick="if(validateIssue()){submitForm('issueGrid','stores?method=submitUpdateIssueForIndent');}" name="Submit2" value="Submit"  />
<input	type="button" name="print" type="submit" class="button"	value="Print"	onClick="submitForm('issueDispensaryForm','stores?method=printIssueToDispensary&issueId='+<%=issueId%>);" />

<!--<input type="button" name="sss" align="right" class="button" value="Submit" onclick="submitForm('issueGrid','stores?method=updateNextOrSubmitIssueToCiv&buttonName=submit');"/>-->
<div class="clear paddingTop12"></div>

<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
<div class="Clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName%></label>

<label>Changed Date:</label>
<label class="value"><%=date%></label>

<label>Changed Time:</label>
<label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> </br>
</div>
</form>
<div class="clear"></div>
<script type="text/javascript">
function generateRowIssueCIV(rowVal)
{
	  var tbl = document.getElementById('indentDetails');
	  var lastRow = tbl.rows.length;
	 // var deptId = document.getElementById('deptId').value;
	  var listSize=document.getElementById('listsize').value;
	  listSize=(parseInt(listSize))+1;
	  var iteration = listSize;
	
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size = '2';
	  e0.name='<%=SR_NO%>';
	  e0.readOnly=true;
	  e0.value=iteration;
	  cellRight0.appendChild(e0);


	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='pvmsNo'+iteration;
	  e1.id = 'pvmsNo'+iteration;
	  e1.size='10';
	 // e1.value=document.getElementById('pvmsNo'+rowVal).value;
	  e1.readOnly=true;
	  var e11 = document.createElement('input');
	  e11.type = 'hidden';
	  e11.name='itemId'+iteration;
	  e11.id = 'itemId'+iteration;
	  e11.value=document.getElementById('itemId'+rowVal).value;
	  cellRight1.appendChild(e1);
	  cellRight1.appendChild(e11);

	  /*var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name = 'nomenclature' + iteration;
	  e2.id = 'nomenclature' + iteration;
	  e2.size = '50';
	  e2.value=document.getElementById('nomenclature'+rowVal).value;
	  e2.readOnly=true;
		 
	 // e2.onblur = function(){checkForNomenclature(this.value, iteration,deptId,'prescription');};
	  //e2.onblur = function(){if(validateConsultant(opdPatient,iteration)){checkForNomenclature(this.value, iteration,deptId,'prescription');}};
		
	  cellRight2.appendChild(e2);*/


	  var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.value=document.getElementById('nomenclature'+rowVal).value;

	e2.name = 'nomenclature' + iteration;
	  e2.id = 'nomenclature' + iteration;
	  e2.onblur = function(){fillItem(document.getElementById('pvmsNo'+rowVal).value, iteration)}
	  
	  var newdiv = document.createElement('div');
  	newdiv.setAttribute('id', 'ac2update'+iteration);
  	newdiv.setAttribute('class', 'autocomplete');
  	newdiv.style.display = 'none';
	
 e2.size = '45';

	  e2.setAttribute('tabindex','1');

	          cellRight2.appendChild(newdiv);
	  cellRight2.appendChild(e2);
	  e2.focus();

	 new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'stores?method=getItemListForIssueToDispensary',{parameters:'requiredField=nomenclature'+iteration});



	  


	  var cellRight222 = row.insertCell(3);
	  var e222 = document.createElement('input');
	  e222.type = 'text';
	  e222.name = 'brandGeneric' + iteration;
	  e222.id = 'BG' + iteration;
	  e222.size = '2';
	 // e222.value=document.getElementById('BG'+rowVal).value;
	  e222.readOnly=true;
	  cellRight222.appendChild(e222);

	  var cellRight21 = row.insertCell(4);
	  var e21 = document.createElement('input');
	  e21.type = 'text';
	  e21.name = 'barCodeNo' + iteration;
	  e21.id = 'barCodeNo' + iteration;
	  e21.size = '8';
	  e21.onblur = function(){getDataForBarcode(this.value,iteration);};
	  e21.onchange=function(){getDataForBarcode(this.value,iteration);};
	  cellRight21.appendChild(e21);
	  			 
	  var cellRight22 = row.insertCell(5);
	  var e22 = document.createElement('input');
	  e22.type = 'text';
	  e22.name = 'au' + iteration;
	  e22.id = 'au' + iteration;
	  e22.size = '7';
	  e22.readOnly=true;
	  cellRight22.appendChild(e22);

	  //var cellRight23 = row.insertCell(6);
	  //var e23 = document.createElement('input');
	  //e23.type = 'text';
	  //e23.name = 'batchNo' + iteration;
	  //e23.id = 'batchNo' + iteration;
	  //e23.size = '10';
	 // e23.readOnly=true;
			

           
            
	  var cellRight23 = row.insertCell(6);
	  var e23 = document.createElement('Select');
	e23.name = 'batchNo' + iteration;
	  e23.id = 'batchNo' + iteration;
	  e23.options[0] = new Option('Select Batch', '0');
	  e23.onchange=function(){if(cheackForBatch(iteration)){ getDataForBarcode(this.value,iteration)}};
		
		  //alert(li);	  
 // for(var i = 0;i<li;i++ ){
	//  e23.options[i+1] = new Option(batchArray[i][1],batchArray [i][0]);
	   
	  
	   // }

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

	  var cellRight251 = row.insertCell(7);
	  var e251 = document.createElement('input');
	  e251.type = 'text';
	  e251.name = 'manuDate' + iteration;
	  e251.id = 'manuDate' + iteration;
	  e251.size = '10';
	  e251.readOnly=true;	  
	  cellRight251.appendChild(e251);
	  
	  var cellRight25 = row.insertCell(8);
	  var e25 = document.createElement('input');
	  e25.type = 'text';
	  e25.name = 'expiryDate' + iteration;
	  e25.id = 'expiryDate' + iteration;
	  e25.size = '10';
	  e25.readOnly=true;	  
	  cellRight25.appendChild(e25);

	/*  var cellRight25 = row.insertCell(9);
	  var e25 = document.createElement('input');
	  e25.type = 'text';
	  e25.name = 'source' + iteration;
	  e25.id = 'source' + iteration;
	  e25.size = '10';
	  e25.readOnly=true;	  
	  cellRight25.appendChild(e25);*/
	  
	  
	  var cellRight6 = row.insertCell(9);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name = 'stockAvailable' + iteration;
	  e6.id = 'stockAvailable' + iteration;
	  e6.size = '8';
	 // e6.value=document.getElementById('stockAvailable'+rowVal).value;
	  e6.readOnly=true;
	  cellRight6.appendChild(e6);



	  var cellRight613 = row.insertCell(10);
	  var e613 = document.createElement('input');
	  e613.type = 'text';
	  e613.name = 'batchStock' + iteration;
	  e613.id = 'batchStock' + iteration;
	  e613.size = '8';
	  e613.readOnly=true;
	  cellRight613.appendChild(e613);

	  var cellRight34 = row.insertCell(11);
	  var e34 = document.createElement('input');
	  e34.type = 'text';
	  e34.name = 'qtyRequest' + iteration;
	  e34.id = 'qtyRequested' + iteration;
	  e34.size = '8';


	  
	  

	  if(document.getElementById('qtyIssued'+rowVal).value=="")
	  {	  
	   e34.value=parseInt(document.getElementById('qtyRequested'+rowVal).value);
	  }else{
		  e34.value=parseInt(document.getElementById('qtyRequested'+rowVal).value)-parseInt(document.getElementById('qtyIssued'+rowVal).value);
		  document.getElementById('qtyRequested'+rowVal).value=parseInt(document.getElementById('qtyIssued'+rowVal).value);
	  }
	   
	   cellRight34.appendChild(e34);



	   

	   var cellRight341 = row.insertCell(12);
		  var e341 = document.createElement('input');
		  e341.type = 'text';
		  e341.name = 'qtyOnLoan' + iteration;
		  e341.id = 'qtyOnLoan' + iteration;
		  e341.size = '8';
		  cellRight341.appendChild(e341);
	  
	  var cellRight35 = row.insertCell(13);
	  var e35 = document.createElement('input');
	  e35.type = 'text';
	  e35.name = 'qtyIssued' + iteration;
	  e35.id = 'qtyIssued' + iteration;
	  e35.size = '8';
	  e35.onblur = function(){checkQty(iteration)};
	  cellRight35.appendChild(e35); 

	  /*var cellRight351 = row.insertCell(15);
	  var e351 = document.createElement('input');
	  e351.type = 'text';
	  e351.name = 'qtyAftrIssued' + iteration;
	  e351.id = 'qtyAftrIssued' + iteration;
	  e351.size = '10';
	  e351.readOnly=true;
	  cellRight351.appendChild(e351); 


	  var cellRight10 = row.insertCell(13);*/
	


	  var cellRight21 = row.insertCell(14);
	  var e21 = document.createElement('input');
	  e21.type = 'button';
	  e21.name='remarks'+iteration;
	  e21.className = 'buttonAdd';
	  e21.setAttribute('tabindex', 1);
	  e21.onclick= function(){generateRowIssueCIV(iteration)};
	  cellRight21.appendChild(e21);
	  
	  var cellRight212 = row.insertCell(15);
	  var e19 = document.createElement('input');
	  e19.type = 'button';
	  e19.className = 'buttonDel';
	  e19.name='remarks'+iteration;
	 // e19.setAttribute('onClick', 'removeRow("issueDispensaryForm","hdb",this);'); 
	  e19.onclick= function(){removeRow("indentDetails","hdb",this)};
	  e19.setAttribute('tabindex','1');
	  cellRight212.appendChild(e19);
	  
	   
	 document.getElementById('listsize').value=listSize;
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
  }
}
function fillItem(val,inc)
{
	//var pageNo =parseInt(document.getElementById('pageNo').value) 
	//var start=((pageNo-1)*20)+1;
	//var end=((pageNo-1)*20)+20;
	
    var index1 = val.lastIndexOf("[");
    var index2 = val.lastIndexOf("]");
    index1++;
    var pvms = val.substring(index1,index2);
   // alert(pvms)
   // alert(val)
   // alert(inc)
    
   /* for(i=start;i<=end;i++){
    if(pvms ==""){
    	document.getElementById('nameItem'+inc).value=""
    	
    	return ;
    	}
   }*/
    
    
	//ajaxFunctionForAutoCompleteIssueToDispensary('issueDispensaryForm','stores?method=fillItemsForIssueToDispensary&pvmsNo=' +  pvms , inc);
    ajaxFunctionForAutoCompleteIssueToDispensary('issueGrid','stores?method=fillItemsForIssueToDispensary&pvmsNo=' +  val , inc);
}


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
	    	  var lotNo="batchNo"+rowVal;
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
		       // alert("pvms.childNodes[0].nodeValue"+pvms.childNodes[0].nodeValue)
	        	document.getElementById('pvmsNo'+rowVal).value = pvms.childNodes[0].nodeValue
	        	// alert("id.childNodes[0].nodeValue"+id.childNodes[0].nodeValue)
	        	document.getElementById('itemId'+rowVal).value = id.childNodes[0].nodeValue
	        	// alert("au.childNodes[0].nodeValue"+au.childNodes[0].nodeValue)
	        	document.getElementById('au'+rowVal).value = au.childNodes[0].nodeValue
	        	// alert("name.childNodes[0].nodeValue"+name.childNodes[0].nodeValue)
	        	document.getElementById('nomenclature'+rowVal).value = name.childNodes[0].nodeValue
	        	
	        	//document.getElementById('issuedItemId'+rowVal).value = id.childNodes[0].nodeValue
	        	//document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
	        	// alert("BG.childNodes[0].nodeValue"+BG.childNodes[0].nodeValue)
	        	document.getElementById('BG'+rowVal).value = BG.childNodes[0].nodeValue
	        	//alert("stock..childNodes[0].nodeValue"+stock.childNodes[0].nodeValue)
	        	document.getElementById("stockAvailable"+rowVal).value=stock.childNodes[0].nodeValue;
	        	//alert("len>>"+batchLength.childNodes.length)
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
	
      var itemId=document.getElementById('itemId'+rowVal).value;
   
	submitProtoAjaxForBarcodeData('issueGrid','stores?method=getDataForBarcode&barCode='+val+'&itemId='+itemId,rowVal);
}

function submitProtoAjaxForBarcodeData(formName,action,rowVal)
{
	  //alert("submitProtoAjax");
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
		      //  var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		        //var name  = item.getElementsByTagName("name")[0];
		       var batchNo=item.getElementsByTagName("batchNo")[0];
		       var batchId=item.getElementsByTagName("batchId")[0];
		       //var barcodeNo=item.getElementsByTagName("barCodeNo")[0];
		       var availableStock=item.getElementsByTagName("availableStock")[0];
		      
		       var brandId=item.getElementsByTagName("brandId")[0];
		       var expiryDate=item.getElementsByTagName("expiryDate")[0];
		       var manuDate=item.getElementsByTagName("dom")[0];
		       var source=item.getElementsByTagName("source")[0];
		       
		     //  var costPrice=item.getElementsByTagName("costPrice")[0];
	        	
	        	document.getElementById("au"+rowVal).value=au.childNodes[0].nodeValue;
	        	document.getElementById("batchNo"+rowVal).value=batchNo.childNodes[0].nodeValue;
	        	document.getElementById("batchId"+rowVal).value=batchId.childNodes[0].nodeValue;
	        	document.getElementById("expiryDate"+rowVal).value=expiryDate.childNodes[0].nodeValue;
	        	//document.getElementById("stockAvailable"+rowVal).value=availableStock.childNodes[0].nodeValue;
	        	document.getElementById("batchStock"+rowVal).value=availableStock.childNodes[0].nodeValue;
	        	document.getElementById("source"+rowVal).value=source.childNodes[0].nodeValue;
	        	//alert("brand  "+brandId.childNodes[0].nodeValue)
	        	document.getElementById("brandId"+rowVal).value=brandId.childNodes[0].nodeValue;
	        	//document.getElementById("costPrice"+rowVal).value=costPrice.childNodes[0].nodeValue;
	        	
	        	document.getElementById("manuDate"+rowVal).value=manuDate.childNodes[0].nodeValue;
	        	
	        	document.getElementById("qtyIssued"+rowVal).focus();
	        	
	        	
	      	 }
	      	}
	      	else{
	      		 document.getElementById("barCodeNo"+rowVal).value="";
	      	alert("Invalid Barcode ");
	     
	      	}
	      }
	    }
	   // javed khan
	   // var url=action+"&"+getNameAndData(formName)
	   
	   var url=action
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

	  }

function validateIssue()
{

	if(document.getElementById("departmentIdTemp").value=="")
	{
		alert('Select The Department !!!');
		document.getElementById("departmentIdTemp").focus();
		return false;
	}
	if(document.getElementById("requestBy").value=="")
	{
		alert('Select The Requested BY !!!');
		document.getElementById("requestBy").focus();
		return false;
	}
	/*if(document.getElementById("approvedBy").value=="")
	{
		alert('Select The Approved By !!!');
		document.getElementById("approvedBy").focus();
		return false;
	}*/

	if(document.getElementById("issuedBy").value=="")
	{
		alert('Select The Issue By !!!');
		document.getElementById("issuedBy").focus();
		return false;
	}

	/*if(document.getElementById("requestNo").value=="")
	{
		alert('Select The Demand No !!!');
		document.getElementById("requestNo").focus();
		return false;
	}*/else{
		return true;
	}
}


function checkQty(rowVal)
{// javed khan
		if(parseInt(document.getElementById('qtyIssued'+rowVal).value) > parseInt(document.getElementById('qtyRequested'+rowVal).value))
		{
			alert("Issued Quantity can't be greater than Quantity Prescribed.");
			document.getElementById('qtyIssued'+rowVal).value="";
			document.getElementById("qtyIssued"+rowVal).focus();
		}else if(parseInt(document.getElementById('qtyIssued'+rowVal).value) > parseInt(document.getElementById('batchStock'+rowVal).value))
		{
			alert("Issued Quantity can't be greater than Batch stock Quantity .");
			document.getElementById('qtyIssued'+rowVal).value="";
			document.getElementById("qtyIssued"+rowVal).focus();
		}else{
					var a=document.getElementById('qtyIssued'+rowVal).value;
				var b=document.getElementById('batchStock'+rowVal).value;
        	
			document.getElementById("qtyAftrIssued"+rowVal).value=b-a;
		}
}

function cheackForBatch(rowVal){
    // alert(rowVal+" --- "+document.getElementById("batchNo"+rowVal).value)
		if(rowVal>1){
	for(i=1;i<rowVal;i++){
		//alert(i+" --i- "+document.getElementById("batchNo"+i).value)
		if(document.getElementById("batchNo"+rowVal).value==document.getElementById("batchNo"+i).value)
		{
			alert("Please select another Batch !!!");
			document.getElementById("batchNo"+rowVal).value="0";
			return false;
		
		}
	
	}
		
}
	return true;
}
	</script>
<%-- End of Main form --%>
