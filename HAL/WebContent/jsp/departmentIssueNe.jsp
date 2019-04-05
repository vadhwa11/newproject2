<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * ToDispensaryManual.jsp  
 * Purpose of the JSP -  This is for  to Dispensary Manual.
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
	
	function checkForDepartmentIssueNE(val,a,inc)
{
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
	    
		ajaxFunctionForAutoCompleteDepartmentIssueNE('departmentIssueNE','nonExp?method=fillItemsForIssueToDispensary&pvmsNo='+pvms , inc);
}
 
	
	function test(){
		if(document.getElementById('mmfForTheYear').value ==0){
			alert("Please Select MMF Year..!");
			return false;
		}else{
			return true;
		}
}
function testForLotNo(value){
	alert(value)
		if(value ==""){
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
		int maxIndentNo=0;
		int issueId =0;
		Box box=HMSUtil.getBox(request);
		if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		}
		if(map.get("employeeList")!=null){
			employeeList = (List) map.get("employeeList");
			System.out.print("employeeList      "+employeeList.size());
		}
		if(map.get("box")!=null){
			box=(Box)map.get("box");
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
		System.out.println("masStoreBrandList  "+masStoreBrandList.size());
		if(map.get("max")!=null)
			max = (String) map.get("max");
		if(map.get("pageNo")!=null)
			pageNo = Integer.parseInt(""+map.get("pageNo"));
		
		if(map.get("issueId")!=null)
			issueId = Integer.parseInt(""+map.get("issueId"));
	
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
			}
%>
<br />
<h2 align="left" class="style1">Department Issue(CIV)</h2>

<div id="contentspace">

<form name="departmentIssueNE" method="post">

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
				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Add" type="submit" value="Add"
					class="toolbutton"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"
					onClick="submitForm('poMain','purchaseOrder?method=poModifyJsp');"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Reset" type="submit" value="Reset"
					class="toolbutton"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" value="Delete"
					class="toolbutton" onclick="openDeletePopupForDepartmentIssueNE();" />
				</td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="print" type="submit" class="toolbutton"
					value=" " onClick=""></td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<%--------------- Start of Search Panel ---------------------------%>
<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form name="searchPanel" method="post"><%-- Start of Search Form --%>
<table width="302" border="0" cellpadding="2" cellspacing="1">
	<tr>
		<td class="thead">Search Panel<a name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><label
			class="bodytextB">Issue No:</label> <select
			name="<%= RequestConstants.ISSUE_UNIT_ID%>"">
			<option value="">Select</option>
			<%for (StoreIssueM storeIssueM :searchListForPopup ) {%>
			<option value=<%=storeIssueM.getId()%>><%=storeIssueM.getIssueNo()%></option>
			<%}%>
		</select> <input type="button" class="morebutton" value=" "
			onClick="submitForm('departmentIssueNE','nonExp?method=searchDepartmentIssueNE');" />
		</td>
	</tr>
</table>
</form>
<%-- End of Search Form --%></div>
</div>
</div>
<%-------------------- End of Search Panel ---------------------------%>
</form>
<br />



<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Issue Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 89px; background-color: #f4f9fe; padding-top: 10px; padding-bottom: 5px;">


<%if(box.get("issueId").equals("")){ %> <input type="hidden"
	name="<%=RequestConstants.ISSUE_ID %>" value="0" id="issueId" /> <%}else{ %>
<input type="hidden" name="<%=RequestConstants.ISSUE_ID %>"
	value="<%=box.get("issueId") %>" id="issueId" /> <%} %> <input
	type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" /> <label
	class="bodytextB"><font id="error"></font> Civ No: </label> <input
	type="text" name="<%=RequestConstants.ISSUE_NO %>"
	value="<%=max+box.get("issueNo") %>" id="issueNo"
	class="textbox_size20" MAXLENGTH="8"/  > <label
	class="bodytextB"><font id="error"></font>Issue Date:</label> <input
	type="text" name="<%=RequestConstants.ISSUE_DATE%>" readonly="readonly"
	value="<%=currentDate %>" class="textbox_size20" id="isssueDate" /> <label
	class="bodytextB"><font id="error"></font>Dept Name :</label> <select
	name="<%= RequestConstants.DEPARTMENT_ID_TEMP%>" id="departmentIdTemp">
	<option value="">Select</option>
	<%for (MasDepartment department :departmentList ) {%>
	<option value=<%=department.getId()%>
		<%=HMSUtil.isSelected(department.getId().toString(),box.get("departmentIdTemp")) %>><%=department.getDepartmentName()%></option>
	<%}%>
</select> <br />
<label class="bodytextB"><font id="error"></font>Ref No:</label> <input
	type="text" name="<%= RequestConstants.DOC_NO%>" class="textbox_size20"
	value="<%=box.get("docNo")%>" id="docNo" /> <label class="bodytextB"><font
	id="error"></font>Issued By:</label> <select
	name="<%= RequestConstants.ISSUED_BY%>" id="issuedBy">
	<option value="">Select</option>
	<%for (MasEmployee masEmployee:employeeList ) {%>
	<option value=<%=masEmployee.getId()%>
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("issuedBy")) %>><%=masEmployee.getFirstName()%></option>
	<%}%>
</select> <input type="hidden" name="<%=RequestConstants.NO_OF_ROWS%>"
	id="noOfRows" value="0" /></div>
<br />



<div style="float: left; padding-left: 15px;"><input type="button"
	class="button" value="Next"
	onclick="if(checkForNext()&&test()&&checkSave()){submitForm('departmentIssueNE','nonExp?method=addNextOrSubmitIssue&buttonName=next');}"
	align="right" /> <input type="button" name="sss" align="right"
	class="button" value="Submit"
	onclick="if(checkForSubmit()&&test()&&checkSave()){{submitForm('departmentIssueNE','nonExp?method=addNextOrSubmitIssue&buttonName=submit');}}" />
</div>
<div style="float: left; padding-left: 15px; padding-bottom: 10px;">
<label class="bodytextB">Page No:</label>
<div class="changebydt" style="width: 65px;"><%=pageNo%></div>
</div>
<input type="hidden" name="<%=RequestConstants.NO_OF_ROWS%>"
	id="<%=RequestConstants.NO_OF_ROWS%>" value="0" /> <input
	type="hidden" name="<%=RequestConstants.INDENT_ID %>"
	value="<%=indentId%>" id="hdb" /> <br />

<table width="200px" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<td width="5%"><label valign="left" class="gridsmlabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="13%"><label valign="left" class="gridsmlabel">A/U</label>
			</td>
			<td width="6%"><label valign="left" class="smalllabel">Serial
			No</label></td>
			<td width="6%"><label valign="left" class="smalllabel">Stock
			In</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Qty
			Issued</label></td>
		</tr>

	</thead>
	<tbody>



		<td width="10%">
		<%
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
    	String issuedQty="issuedQty";
    	String issuedQty2="issuedQty";
    	
    	  String issuedQtyTemp="issuedQtyTemp";
    	  String issuedQtyTemp2="issuedQtyTemp";
    	  
    	  String stockIn="stockIn";
    	  String stockIn2="stockIn";
    	int inc = 1;
    	int incTemp2=8;
    	
    		 inc=((pageNo-1)*8)+1;
    		  incTemp2=inc+8;
    	
     	 for(;inc<incTemp2;inc++){
     		 
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
     		 issuedQty=issuedQty2+(""+inc);
     		  issuedQtyTemp=issuedQtyTemp2+(""+inc);
     		 stockIn=stockIn2+(""+inc);
    	  %>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=RequestConstants.SR_NO%>"
				readonly="readonly" /></td>
			<td width="10%"><input type="text"
				name="<%=RequestConstants.ITEM_CODE%>" value="" readonly="readonly"
				class="medcaption" id="<%=codeItem%>" /> <input type="hidden"
				size="2" value="0" class="smcaption"
				name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" /></td>
			<td width="17%"><input type="text" value="" tabindex="1"
				id="<%=nameItem%>" class="bigcaption"
				onblur="if(fillSrNo('<%=inc %>')){checkForDepartmentIssueNE(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" />
			<div id="ac2update"
				style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','nonExp?method=getItemListForDepartmentIssueNE',{parameters:'requiredField=<%=nameItem%>&issueId='+document.getElementById('issueId').value });
			</script></td>
			<td width="10%"><input type="text" value="" class="smcaption"
				name="<%=RequestConstants.AU%>" id="<%=idAu %>" tabindex="2" /></td>

			<td width="10%"><input type="text" value="" id="<%=lotNo%>"
				class="medcaption"
				onblur="if(testForLotNo(this.value)){fillGridIssueToOTAFU('departmentIssueNE','nonExp?method=fillIssueToOTAFUBasedOnLotNo&lotNo='+this.value , <%=inc %>);}" /></td>
			<td width="10%"><input type="text" readonly="readonly" value=""
				class="medcaption" name="" MAXLENGTH="7" id="<%=stockIn%>"
				validate="Qty In Stock,num,no" /></td>
			<td width="10%"><input type="text" value="" tabindex="1"
				validate="Qty in MMF,floatWithoutSpaces,no" class="medcaption"
				MAXLENGTH="7" name="<%=RequestConstants.QTY_IN_MMF_TEMP%>"
				id="<%=issuedQtyTemp%>"
				onchange="fillQtyIssuedForIssueCiv(<%=inc%>);" /> <input
				type="hidden" value="0" name="<%=RequestConstants.QTY_ISSUED%>"
				id="<%=issuedQty%>" /></td>

		</tr>
		<% }   %>
		
	</tbody>

</table>

</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <br />
<%--Start of Change Panel--%> <label class="bodytextB">Changed
By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" id="totalQty" /> <%--End of Change Panel--%>

</form>

</div>

<script type="text/javascript">

function test(){
	var errorMessage="";
	formName="departmentIssueNE"
	obj = eval('document.'+formName)
	if(document.getElementById('issuedBy').value == "")
		errorMessage=errorMessage+"Please Select Issue By \n"; 
	if(document.getElementById('departmentIdTemp').value == "")
		errorMessage=errorMessage+"Please Select Dispensary \n";
	if(document.getElementById('docNo').value == "")
		errorMessage=errorMessage+"Please Fill Reference No \n";
	
	if((document.getElementById('issuedBy').value != "") &&(document.getElementById('docNo').value != "") &&(document.getElementById('departmentIdTemp').value != "") ){
		return true;
	}else{
		alert(errorMessage)
		return false
	}

}
</script>
