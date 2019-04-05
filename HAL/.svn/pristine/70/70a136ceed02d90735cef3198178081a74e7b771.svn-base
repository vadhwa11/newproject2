<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * modifyDepartmentIndentjsp  
 * Purpose of the JSP -  This is for Modify Department Indent.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
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

<script type="text/javascript" language="javascript">
var itemsArray1=new Array();
 var numLinesAdded = 1;
  var tt;
  function fillItems(idVal,rowVal){
  		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idAu="idAu";
    	
    	idItem=idItem+rowVal;
    	
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	
    	idAu=idAu+rowVal;
    	document.getElementById('noOfRecords').value=rowVal
		for(i=0;i<itemsArray1.length;i++){
		if(itemsArray1[i][0]==idVal){
		document.getElementById(idItem).value=itemsArray1[i][0]
		document.getElementById(nameItem).value=itemsArray1[i][2]
		document.getElementById(idAu).value=itemsArray1[i][3]
		}
		}
	
  }
  function fillValues(inc)
  {
  	 	var stockInVar="stockInVar";
    	var mmfVar="mmfVar";
    	var demandVar="demandVar";
    	var stockInVarTemp="stockInVarTemp";
    	var mmfVarTemp="mmfVarTemp";
    	var demandVarTemp="demandVarTemp";
    	document.getElementById(stockInVar+inc).value=document.getElementById(stockInVarTemp+inc).value
    	document.getElementById(mmfVar+inc).value=document.getElementById(mmfVarTemp+inc).value
    	document.getElementById(demandVar+inc).value=document.getElementById(demandVarTemp+inc).value
  }
  function checkForNext(){
  if(document.getElementById('noOfRecords').value<10)
  {
  	alert("All rows are not filled.To continue press Submit ")
  	return false;
  }else{
  return true;
  }
  }
  
  function checkForSubmit(){
  if(document.getElementById('noOfRecords').value==0)
  {alert("There must be one detail row");
  return false;
  }else{
  return true;
  }
  }
   function removeRow(obj)
 		
	{
	   
		if(document.getElementById("departmentIndentDetails").childNodes[1].childNodes.length>1)	
		{
			
			//tt = document.getElementById("indentDetails");
		   // tt = document.getElementById("indentDetails").childNodes[1].removeChild(obj.parentNode.parentNode);
			//tt.deleteRow(document.getElementById("indentDetails").childNodes[1])
			
			document.getElementById('departmentIndentDetails').deleteRow(2)
			
      		alert(" ifww")
      		
      		
		}
		else
		{
			
		 	alert("Bill should have atleast one row");
		}
		numLinesAdded--;
	}
 
	function generateRow() {
	
		var d=document.getElementById("departmentIndentDetails").getElementsByTagName("tr");
		lastTr = d[d.length-1]		
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);
		numLinesAdded++;
		
		 
        lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
        
        obj1 = document.getElementById('SRNo');          
     	obj1.value=numLinesAdded;
        
        
       
       
	}
	


	
function get_value()
{
 var url="/hms/jsp/window.jsp";
   popwindow(url);
 }  

var newwindow;
function popwindow(url)
{

 newwindow=window.open(url,'name',"height=500,width=600,status=1");
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();

}

	
</script>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	String previousPage="no";
	int pageNo=1;
	int internalIndentId=0;

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}

	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	if(map.get("departmentList") != null){
		departmentList = (ArrayList) map.get("departmentList");
		session.setAttribute("departmentList",departmentList);
	}else if(session.getAttribute("departmentList") != null){
		departmentList = (ArrayList)session.getAttribute("departmentList");
		
	}


	List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("approvedByList") != null){
		approvedByEmployeeList = (ArrayList) map.get("approvedByList");
		session.setAttribute("approvedByList",approvedByEmployeeList);
	}else if(session.getAttribute("approvedByList") != null){
		approvedByEmployeeList = (ArrayList)session.getAttribute("approvedByList");
		
	}

	List<MasEmployee> requestByEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("requestByList") != null){
		requestByEmployeeList = (ArrayList) map.get("requestByList");
		session.setAttribute("requestByList",requestByEmployeeList);
	}else if(session.getAttribute("requestByList") != null){
		requestByEmployeeList = (ArrayList)session.getAttribute("requestByList");
		
	}

	List<MasStoreItem> masStoreItemList= new ArrayList<MasStoreItem>();
	if(map.get("masStoreItemList")!=null)
		masStoreItemList=(List) map.get("masStoreItemList");

	List<MasStoreSection> sectionList= new ArrayList<MasStoreSection>();
	if(map.get("sectionList")!=null)
		sectionList=(List) map.get("sectionList");


	List<StoreInternalIndentM> searchStoreInternalIndentMList= new ArrayList<StoreInternalIndentM>();
	if(map.get("searchStoreInternalIndentMList")!=null)
		searchStoreInternalIndentMList=(List) map.get("searchStoreInternalIndentMList");

	List<StoreInternalIndentM> gridStoreInternalIndentMList = new ArrayList<StoreInternalIndentM>();
	if (map.get("storeInternalIndentMList") != null)
		gridStoreInternalIndentMList = (List) map.get("storeInternalIndentMList");

	List<StoreInternalIndentT> gridStoreInternalIndentTList = new ArrayList<StoreInternalIndentT>();
	if (map.get("storeInternalIndentTList") != null)
		gridStoreInternalIndentTList = (List) map.get("storeInternalIndentTList");

	List<StoreInternalIndentM> previousStoreInternalIndentMList=new ArrayList<StoreInternalIndentM>();
	
	
	
	
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
<br>
<br>
<%
		   out.println(message);
		  }
	int maxDemandNo=0;
	if(map.get("internalIndentId")!=null){
		internalIndentId=Integer.parseInt(""+map.get("internalIndentId"));
	}
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}

	if(map.get("maxDemandNo")!=null)
		maxDemandNo=Integer.parseInt(""+map.get("maxDemandNo"));
	
	if(map.get("sectionList")!=null)
	sectionList=(List) map.get("sectionList");
	
%>
<%
  int k=0;
  					if(masStoreItemList.size()>0)
  						
 						for (MasStoreItem masStoreItem:masStoreItemList){
 			%>
<script>
         		 
         		itemsArray1[<%=k%>]= new Array();
         		itemsArray1[<%=k%>][0] = "<%=masStoreItem.getId()%>";
				itemsArray1[<%=k%>][1] = "<%=masStoreItem.getPvmsNo()%>";
				itemsArray1[<%=k%>][2] = "<%=masStoreItem.getNomenclature()%>";
				itemsArray1[<%=k%>][3] = "<%=masStoreItem.getItemConversion().getItemUnitName()%>";
				itemsArray1[<%=k%>][4] = "<%=masStoreItem.getItemConversion().getId()%>";
         		
         		</script>
<%
          k++;
 						} %>

<div id="contentspace">

<form name="departmentIndent" method="post"><br />

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
					class="toolbutton"></td>
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



<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form name="searchPanel" method="post">
<table cellpadding="4" cellspacing="1" border="0">
	<tr>
		<td class="thead">Search Panel<a name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><input type="hidden"
			name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> <input
			type="hidden" name="do" value="process" /> <input type="hidden"
			name="searchthread" value="1" /> <input type="hidden"
			name="showposts" value="1" /> <input type="hidden"
			name="searchthreadid" value="85875" /> <label class="bodytextB_blue">From
		Date :</label> <input type="text" name="<%= FROM_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.departmentIndent.<%= FROM_DATE%>,true);"
			class="calender" /> <label class="bodytextB_blue">To Date :</label>

		<input type="text" name="<%= TO_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.departmentIndent.<%= TO_DATE%>,true);"
			class="calender" /> <br />
		<label class="bodytextB_blue">Demand No:</label> <select
			name="<%= SEARCH_DEMAND_NO%>">
			<option value="0">Select</option>
			<%
					if(searchStoreInternalIndentMList.size()!=0)
					for (StoreInternalIndentM storeInternalIndentM :searchStoreInternalIndentMList ) {
				%>

			<option value=<%=storeInternalIndentM.getDemandNo()%>><%=storeInternalIndentM.getDemandNo()%></option>

			<%
					}
				%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('departmentIndent','stores?method=searchDepartmentIndent');" />
		</td>
	</tr>

</table>
</form>
</div>
</div>
</div>
<jsp:include page="searchResultPO.jsp" /> <br />








</form>

<form name="departmentIndentGrid" method="post">


<div id="testDiv" size="height:500px;">
<%if(previousPage.equals("no")){ 
				for (StoreInternalIndentM grStoreInternalIndentM : gridStoreInternalIndentMList) {
			%> <input type="hidden" name="totalRecords"
	value="<%=gridStoreInternalIndentMList.size() %>" /> <input
	type="hidden" name="pageNo" value="<%=pageNo%>" /> <label
	class="bodytextB_blue"><font id="error"></font> Demand No: </label> <input
	type="text" name="<%=DEMAND_NO %>"
	value="<%=grStoreInternalIndentM.getDemandNo()%>" readonly="readonly"
	class="textbox_size20" MAXLENGTH="8"/  > <span
	class="bodytextB_blue">Demand Date:</span> <input type="text"
	name="<%=DEMAND_DATE %>"
	value="<%=HMSUtil.changeDateToddMMyyyy(grStoreInternalIndentM.getDemandDate())%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /> <br>
<span class="bodytextB_blue">From Store/Dept/Ward:</span> <select
	name="<%=FORM_STORE_DEPT_WARD_DEPARTMENT_ID_DEPENDENT_INDENT%>">
	<option value="0">Select</option>
	<%
						for (MasDepartment masDepartment :departmentList ) {
							if(grStoreInternalIndentM.getDepartment().getId() == masDepartment.getId()){
					%>
	<option value="<%=masDepartment.getId()%>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%}else{ %>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%}
						}
					%>
</select> <span class="bodytextB_blue">Approved By:</span> <select
	name="<%=APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>">
	<option value="0">Select</option>
	<%
				for (MasEmployee approvedBy :approvedByEmployeeList ) {
					if(grStoreInternalIndentM.getApprovedBy().getId() == approvedBy.getId()){
			%>

	<option value=<%=approvedBy.getId()%> selected="selected"><%=approvedBy.getId()%></option>

	<%}else{ %>
	<option value="<%=approvedBy.getId()%>"><%=approvedBy.getId()%></option>
	<%}
						}
					%>
</select> <br>

<span class="bodytextB_blue">To Store:</span> <select
	name="<%=SECTION_ID_DEPENDENT_INDENT%>">
	<option value="0">Select</option>
	<%
				for (MasStoreSection masSection :sectionList ) {
					if(grStoreInternalIndentM.getToStore().getId() == masSection.getId()){
			%>

	<option value=<%=masSection.getId()%> selected="selected"><%=masSection.getSectionName()%></option>
	<%}else{ %>
	<option value="<%=masSection.getId()%>"><%=masSection.getSectionName()%></option>
	<%}
						}
					%>
</select> <span class="bodytextB_blue">Request By:</span> <select
	name="<%=REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>">
	<option value="0">Select</option>
	<%
				for (MasEmployee requestedBy :requestByEmployeeList ) {
					if(grStoreInternalIndentM.getRequestedBy().getId() == requestedBy.getId()){
			%>

	<option value=<%=requestedBy.getId()%> selected="selected"><%=requestedBy.getId()%></option>

	<%}else{ %>
	<option value="<%=requestedBy.getId()%>"><%=requestedBy.getId()%></option>
	<%}
						}
					%>
</select> <input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=NO_OF_ROWS%>" id="rr" value="22" /> <%}
				}
			
	else{ 
					for(StoreInternalIndentM storeInternalIndentM:previousStoreInternalIndentMList){

				%> <input type="hidden" name="pageNo" value="<%=pageNo%>" /> <label
	class="bodytextB_blue"><font id="error"></font> Demand No: </label> <input
	type="text" name="<%=DEMAND_NO %>"
	value="<%=storeInternalIndentM.getDemandNo()%>" readonly="readonly"
	class="textbox_size20" MAXLENGTH="8"/  > <span
	class="bodytextB_blue">Demand Date:</span> <input type="text"
	name="<%=DEMAND_DATE %>" value="<%=date%>" class="textbox_size20"
	readonly="readonly" tabindex=3 /> <br>
<span class="bodytextB_blue">From Store/Dept/Ward:</span> <select
	name="<%=FORM_STORE_DEPT_WARD_DEPARTMENT_ID_DEPENDENT_INDENT%>"
	validate="From store/Dept/Ward,Strinf,yes">
	<option value="0">Select</option>
	<%
				for (MasDepartment masDepartment :departmentList ) {
			%>

	<option value=<%=masDepartment.getId()%>><%=masDepartment.getDepartmentName()%></option>

	<%
				}
			%>
</select> <span class="bodytextB_blue">Approved By:</span> <select
	name="<%=APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>"
	validate="Approved By,Strinf,yes">
	<option value="0">Select</option>
	<%
				for (MasEmployee approvedBy :approvedByEmployeeList ) {
			%>

	<option value=<%=approvedBy.getId()%>><%=approvedBy.getId()%></option>

	<%
				}
			%>
</select> <br>
<span class="bodytextB_blue">To Store:</span> <select
	name="<%=SECTION_ID_DEPENDENT_INDENT%>" validate="To Store,String,yes">
	<option value="0">Select</option>
	<%
				for (MasStoreSection masSection :sectionList ) {
			%>

	<option value=<%=masSection.getId()%>><%=masSection.getSectionName()%></option>

	<%
				}
			%>
</select> <span class="bodytextB_blue">Request By:</span> <select
	name="<%=REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>"
	validate="Request By,Strinf,yes">
	<option value="0">Select</option>
	<%
				for (MasEmployee requestedBy :requestByEmployeeList ) {
			%>

	<option value=<%=requestedBy.getId()%>><%=requestedBy.getId()%></option>

	<%
				}
			%>
</select> <input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <%}} %>

<br>

<br />
<input type="hidden" class="button" value="Add Row"
	onclick="generateRow();" align="right" /> <input type="hidden"
	class="button" value="Remove Row" onclick="removeRow(this)"
	align="right" /> <input type="button" class="button" value="Previous"
	d
	onclick="submitForm('departmentIndentGrid','stores?method=previousDepartmentIndent');"
	align="right" /> <input type="button" class="button" value="Next"
	onclick="if(checkForNext()){submitForm('departmentIndentGrid','stores?method=updateNextDepartmentIndent');}"
	align="right" /> <input type="button" name="sss" align="right"
	class="button" value="Submit"
	onclick="if(checkForSubmit()){submitForm('departmentIndentGrid','stores?method=updateNextDepartmentIndent');}" />
Page No:<%=pageNo%> <input type="hidden" size="2" value="10"
	name="noOfRecords" id="noOfRecords" /> <input type="hidden"
	name="<%=DEPARTMENT_INDENT_ID %>" value="<%=internalIndentId%>"
	id="hdb" /> <br />
<fieldset style="width: 99%; padding-left: 9px;"><legend>Department
Indent details</legend>


<div
	style="overflow: auto; width: 100%; height: 260px; padding-left: 9px;">
<table width="200px" colspan="7" id="departmentIndentDetails"
	class="grid_header" border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<td width="5%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">Stock
			in Hand</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Qty
			in MMF</label></td>
			<td width="6%"><label valign="left" class="smalllabel">Qty
			in Request</label></td>

		</tr>

	</thead>
	<tbody>


		<%
		 
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
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
    	String idAu2="idAu";
    	
    	String stockInVar2="stockInVar";
    	String mmfVar2="mmfVar";
    	String demandVar2="demandVar";

    	String stockInVarTemp2="stockInVarTemp";
    	String mmfVarTemp2="mmfVarTemp";
    	String demandVarTemp2="demandVarTemp";
    	String incVar2="incVar2";
    	

		

		if(previousPage.equals("no")){ 
			int inc=((pageNo-1)*10)+1;
	    	   int incTemp2=inc+10;
	    	   for(StoreInternalIndentT storeInternalIndentT:gridStoreInternalIndentTList){
	    		 
	    		  if(inc<=incTemp2){
		
		%>
		<td width="10%">

		<td width="10%">
		<%
    	    	
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idAu=idAu2+(""+inc);
     		
     		stockInVar=stockInVar2+(""+inc);
     		mmfVar=mmfVar2+(""+inc);
     		demandVar=demandVar2+(""+inc);
     		

     		stockInVarTemp=stockInVarTemp2+(""+inc);
     		mmfVarTemp=mmfVarTemp2+(""+inc);
     		demandVarTemp=demandVarTemp2+(""+inc);
     		incVar=incVar2+(""+inc);
    	  %>
		<tr>
			<td width="5%"><input type="text" size="2"
				value="<%=storeInternalIndentT.getSrNo()%>" class="smcaption"
				name="<%=SR_NO%>" readonly="readonly" /></td>
			<input type="hidden" name="<%= INTERNAL_INDENTT_ID%>"
				value="<%=storeInternalIndentT.getId()%>" />
			<input type="hidden" size="2"
				value="<%=storeInternalIndentT.getItem().getId() %>"
				class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem%>" />
			<td width="10%"><select name="<%= ITEM_CODE%>"
				onchange="fillItems(this.value,this.id)" id="<%=inc%>">
				<option value="0">Select</option>
				<%
					for (MasStoreItem masStoreItem :masStoreItemList ) {
						if(storeInternalIndentT.getItem().getId() == masStoreItem.getId()){
				%>

				<option value=<%=masStoreItem.getId()%> selected="selected"><%=masStoreItem.getPvmsNo()%></option>

				<%
					}else{
				%>
				<option value=<%=masStoreItem.getId()%>><%=masStoreItem.getPvmsNo()%></option>
				<%
					}}
				%>
			</td>
			<td width="10%"><input type="text"
				value="<%=storeInternalIndentT.getItem().getNomenclature() %>"
				id="<%=nameItem%>" class="bigcaption" readonly="readonly"
				name="<%=NOMENCLATURE%>" /></td>
			<td width="10%"><input type="text"
				value="<%=storeInternalIndentT.getItem().getItemConversion().getItemUnitName()%>"
				class="smcaption" readonly="readonly" name="<%=AV%>" id="<%=idAu%>" /></td>

			<td width="10%"><input type="text"
				value="<%=storeInternalIndentT.getStockInHand() %>"
				class="medcaption" name="<%=STOCK_IN_HAND_DEPARTMENT_INDENT%>"
				id="<%=stockInVarTemp %>" tabindex="2" /> <input type="hidden"
				value="<%=storeInternalIndentT.getStockInHand() %>"
				class="medcaption" name="<%=STOCKING%>" tabindex="2"
				id="<%=stockInVar%>" /></td>
			<td width="10%"><input type="text"
				value="<%=storeInternalIndentT.getMmfQty() %>" class="medcaption"
				name="<%=QTY_IN_MMF_DEPARTMENT_INDENT%>" tabindex="2"
				id="<%=mmfVarTemp%>" /> <input type="hidden"
				value="<%=storeInternalIndentT.getMmfQty() %>" class="medcaption"
				name="<%=QTY_IN_MMF%>" tabindex="2" id="<%=mmfVar%>" /></td>
			<td width="3%"><input type="text" class="medcaption"
				value="<%=storeInternalIndentT.getQtyRequest() %>"
				name="<%=QTY_IN_REQUEST_DEPARTMENT_INDENT%>" tabindex="2"
				id="<%=demandVarTemp%>" onblur="fillValues(<%=inc%>);" /> <input
				type="hidden" class="medcaption"
				value="<%=storeInternalIndentT.getQtyRequest() %>"
				name="<%=QTY_IN_REQUEST%>" tabindex="2" id="<%=demandVar%>" /></td>
		</tr>
		<% inc++;
     	 }
     	 }
	    		  if(inc<=10){
	    			  for(;inc<10;inc++){%>

		<tr>

			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><select name="<%= ITEM_CODE%>"
				onchange="fillItems(this.value,this.id)" id="<%=inc%>">
				<option value="0">Select</option>
				<%
					for (MasStoreItem masStoreItem :masStoreItemList ) {
				%>

				<option value=<%=masStoreItem.getId()%>><%=masStoreItem.getPvmsNo()%></option>

				<%
					}
				%>

				<input type="hidden" size="2" value="0" class="smcaption"
					name="<%=ITEM_ID%>" id="<%=idItem%>" /></td>
			<td width="10%"><input type="text" value="" id="<%=nameItem%>"
				class="bigcaption" readonly="readonly" name="<%=NOMENCLATURE%>" /></td>
			<td width="10%"><input type="text" value="" class="smcaption"
				readonly="readonly" name="<%=AV%>" id="<%=idAu%>" /></td>
			<td width="10%"><input type="text" value="" class="medcaption"
				name="<%=STOCK_IN_HAND_DEPARTMENT_INDENT%>"
				id="<%=stockInVarTemp %>" tabindex="2" /> <input type="hidden"
				value="0" class="medcaption" name="<%=STOCKING%>" tabindex="2"
				id="<%=stockInVar%>" /></td>
			<td width="10%"><input type="text" value="" class="medcaption"
				name="<%=QTY_IN_MMF_DEPARTMENT_INDENT%>" tabindex="2"
				id="<%=mmfVarTemp%>" /> <input type="hidden" value="0"
				class="medcaption" name="<%=QTY_IN_MMF%>" tabindex="2"
				id="<%=mmfVar%>" /></td>
			<td width="3%"><input type="text" class="medcaption" value=""
				name="<%=QTY_IN_REQUEST_DEPARTMENT_INDENT%>" tabindex="2"
				id="<%=demandVarTemp%>" onblur="fillValues(<%=inc%>);" /> <input
				type="hidden" class="medcaption" value="0"
				name="<%=QTY_IN_REQUEST%>" tabindex="2" id="<%=demandVar%>" /></td>
		</tr>

		<% }
	    		  }
     	    %> <%}//this is if(previousPage.equals("no")) end
       else{}%>
		
	</tbody>

</table>
</fieldset>


</div>



</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" />

</form>

</div>
