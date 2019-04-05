<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * indentBD.jsp  
 * Purpose of the JSP -  This is for indentBD.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="jkt.hms.util.RequestConstants.*"%>
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
<%@page import="jkt.hms.masters.business.StoreMmfDepartmentM"%>
<%@page import="jkt.hms.masters.business.StoreMmfDepartmentT"%>
<%@page import="java.util.StringTokenizer"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.SimpleDateFormat"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />

<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
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


<script type="text/javascript">
  function fillValuesBalance(inc)
  {
    	var mmfVar="mmfVar";
    	var mmfVarTemp="mmfVarTemp";
    
    if(document.getElementById(mmfVarTemp+inc).value!=""){
      		document.getElementById(mmfVar+inc).value=document.getElementById(mmfVarTemp+inc).value
     }
     else
      		document.getElementById(mmfVar+inc).value="0";
             
	

    
  }


function fillClinical(inc)
  {
   	 var incRemarks="incRemarks";
     var incRemarksTemp="incRemarksTemp";
     
     if(document.getElementById(incRemarksTemp+inc).value!=""){
      document.getElementById(incRemarks+inc).value=document.getElementById(incRemarksTemp+inc).value
     }
     else
      document.getElementById(incRemarks+inc).value="emptyString"
  }



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
	int pageNo=1;
	String noDetailRecords="no";
	List<StoreMmfDepartmentM> searchStoreMmfDepartmentMList = new ArrayList<StoreMmfDepartmentM>();
	List<StoreMmfDepartmentM> gridIndentMList = new ArrayList<StoreMmfDepartmentM>();
	List<StoreMmfDepartmentT> gridIndentTList = new ArrayList<StoreMmfDepartmentT>();
	List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
	
	String max="";
	List objectList=new ArrayList();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	//--------Hearder Variables-------
	String docNo="";
	int mmfDepartmentId=0;
	String mmfDepartmentDate="";
	
	//--------End -------- Hearder Variables-------

	if (request.getAttribute("map") != null) 
		map = (Map) request.getAttribute("map");
	
	if(map.get("docNo")!=null)
		docNo=""+map.get("docNo");
	
	if(map.get("mmfDepartmentId")!=null)
		mmfDepartmentId= Integer.parseInt(""+map.get("mmfDepartmentId")) ;
	
	if(map.get("mmfDepartmentDate")!=null)
		mmfDepartmentDate =""+ map.get("mmfDepartmentDate");
	
	
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}
	if(map.get("max")!=null)
		max=(""+map.get("max"));
	

		
	if(map.get("itemList")!=null)
		itemList=(List) map.get("itemList");

	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	if(map.get("departmentList") != null)
		departmentList = (ArrayList) map.get("departmentList");
	
	
	List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("approvedByList") != null)
		approvedByEmployeeList = (ArrayList) map.get("approvedByList");
	

	
	
	if(map.get("objectList")!=null)
		objectList=(List) map.get("objectList");
	
	if(map.get("searchStoreMmfDepartmentMList")!=null)
		searchStoreMmfDepartmentMList = (List) map.get("searchStoreMmfDepartmentMList");
	
	
	
	if(map.get("gridIndentMList")!=null)
		gridIndentMList=(List) map.get("gridIndentMList");
	
	
	if(map.get("gridIndentTList")!=null)
		gridIndentTList=(List) map.get("gridIndentTList");
	

	if(map.get("noDetailRecords")!=null){
		noDetailRecords=(""+map.get("noDetailRecords"));
		
	}

%>
<script><%
	
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
<script>
		var nameArray=new Array();
		var itemsArray1=new Array();
	</script>



<%int k=0;
  			try{
  			if(objectList.size()>0)
			for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
					
				Object[] object = (Object[]) iterator.next();
				
				Integer itemIdFromObject = (Integer)object[0];
				String  itemPvmsNoFromObject = (""+object[1]);
				String  itemNomenclatureFromObject = (""+object[2]) ;
				
				String  itemStrengthFromObject = (""+object[3]);
				
				String  itemAuFromObject = (""+object[4]) ;
				%>
<script>
	         			itemsArray1[<%=k%>]= new Array();
	         			itemsArray1[<%=k%>][0] = "<%=itemIdFromObject%>";
	         			itemsArray1[<%=k%>][1] = "<%=itemPvmsNoFromObject%>";
						<%
						StringBuffer output_str = new StringBuffer();
						
						StringTokenizer s = new StringTokenizer(itemNomenclatureFromObject,"\""); 
						
						while (s.hasMoreTokens())
						{	output_str.append(s.nextToken());
							if (s.hasMoreTokens()){
							output_str.append("\\");
					 	    output_str.append("\"");
							}
						}
						
				%>
				<%
				
				if(itemStrengthFromObject.equals("")){
				%>
				nameArray[<%=k%>]="<%=output_str.toString()+itemStrengthFromObject%>"
				itemsArray1[<%=k%>][2]="<%=output_str.toString()+itemStrengthFromObject%>"
				<%}else{%>
				nameArray[<%=k%>]="<%=output_str.toString()%>"
				itemsArray1[<%=k%>][2]="<%=output_str.toString()%>"
				<%}%>
				itemsArray1[<%=k%>][3]="<%=itemAuFromObject%>"
				
         		</script>

<% k++;}
  			
  			}catch(Exception ee){
  				ee.printStackTrace();
  			}%>

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
			validate="Pick a date" class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.departmentIndent.<%= FROM_DATE%>,event)" />

		<label class="bodytextB_blue">To Date :</label> <input type="text"
			name="<%= TO_DATE %>" class="textbox_date" MAXLENGTH="30"
			/ tabindex=1 /> <img id="calendar" src="/hms/jsp/images/cal.gif"
			width="16" height="16" border="0" validate="Pick a date"
			class="calender" tabindex="1"
			onClick="setdate('<%=currentDate%>',document.departmentIndent.<%= TO_DATE%>,event)" />

		<br />
		<label class="bodytextB_blue">Store/Dept/Ward Name:</label> <select
			name="<%= SEARCH_STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>">
			<option value="0">Select</option>
			<%
					for (MasDepartment storeMmfDepartmentM :departmentList ) {
				%>

			<option value=<%=storeMmfDepartmentM.getId()%>><%=storeMmfDepartmentM.getDepartmentName()%></option>

			<%
					}
				%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('departmentIndent','stores?method=searchMmfDepartment');" />
		</td>
	</tr>

</table>
</form>
</div>

<jsp:include page="searchResultPO.jsp" /> <br />
</form>

<form name="departmentIndentGrid" method="post">

<div id="testDiv" size="height:500px;"><input type="hidden"
	name="pageNo" value="<%=pageNo%>" /> <input type="hidden" size="2"
	value="0" name="<%=NO_OF_ROWS%>" id="<%=NO_OF_ROWS%>" /> <input
	type="hidden" name="<%=MMF_DEPARTMENT_M_ID %>"
	value="<%=mmfDepartmentId%>" id="hdb" /> <input type="hidden"
	name="<%=NO_DETAIL_RECORDS%>" value="<%=noDetailRecords%>" /> <%if(pageNo==1){
				for(StoreMmfDepartmentM storeMmfDepartmentM:gridIndentMList){
			%> <input type="hidden" name="<%=DOC_NO %>"
	value="<%=storeMmfDepartmentM.getDocNo()%>" readonly="readonly"
	class="textbox_size20" MAXLENGTH="8"/  > <span
	class="bodytextB_blue">Store/Dept/Ward Name:</span> <select
	name="<%=STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>">
	<option value="0">Select</option>
	<%
							for (MasDepartment masDepartment :departmentList ) {
								if(storeMmfDepartmentM.getStoreWardDept().getId() == masDepartment.getId()){
						%>
	<option value="<%=masDepartment.getId()%>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%}else{ %>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%}
							}
						%>
</select> <span class="bodytextB_blue">Date:</span> <select
	name="<%=MMF_DEPARTMENT_DATE %>">
	<option value="0">Select</option>
	<%
			if(!storeMmfDepartmentM.getMmfForTheYear().equals(0))
			{%>
	<option value="<%=storeMmfDepartmentM.getMmfForTheYear()%>"
		selected="selected"><%=storeMmfDepartmentM.getMmfForTheYear()%>
	</option>
	<option value="<%=Integer.parseInt(date.substring(6))+1%>"><%=Integer.parseInt(date.substring(6))+1%>
	</option>


	<%} else { %>
	<option value="<%=date.substring(6) %>"><%=date.substring(6) %>
	</option>
	<option value="<%=Integer.parseInt(date.substring(6))+1%>"><%=Integer.parseInt(date.substring(6))+1%>
	</option>
	<%} %>
</select> <br>
<span class="bodytextB_blue">Remarks:</span> <input type="text"
	name="<%=REMARKS %>" value="<%=storeMmfDepartmentM.getRemarks()%>"
	value=" " class="textbox_size20" tabindex=3 MAXLENGTH="30" /> <span
	class="bodytextB_blue">Approved By:</span> <select
	name="<%=APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT%>">
	<option value="0">Select</option>
	<%
					for (MasEmployee approvedBy :approvedByEmployeeList ) {
						if(storeMmfDepartmentM.getApprovedBy().getId() == approvedBy.getId()){
				%>

	<option value=<%=approvedBy.getId()%> selected="selected"><%=approvedBy.getId()%></option>

	<%}else{ %>
	<option value="<%=approvedBy.getId()%>"><%=approvedBy.getId()%></option>
	<%}
							}
						%>
</select> <%}}else{ %> <span class="bodytextB_blue">Store/Dept/Ward Name:</span> <select
	name="<%=STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>"
	validate="From store/Dept/Ward,String,yes">
	<option value="0">Select</option>
	<%
				for (MasDepartment masDepartment :departmentList ) {
			%>

	<option value=<%=masDepartment.getId()%>><%=masDepartment.getDepartmentName()%></option>

	<%
				}
			%>

</select> <input type="hidden" name="<%=DOC_NO %>" value="<%=max%>"
	readonly="readonly" class="textbox_size20" MAXLENGTH="8"/  > <span
	class="bodytextB_blue">Year:</span> <select
	name="<%=MMF_DEPARTMENT_DATE %>">
	<option value="0">Select</option>
	<option value="<%=date.substring(6) %>"><%=date.substring(6) %>
	</option>
	<option value="<%=Integer.parseInt(date.substring(6))+1%>"><%=Integer.parseInt(date.substring(6))+1%>
	</option>
</select> <br>

<label class="bodytextB_blue"><font id="error"></font>Remarks</label> <input
	type="text" name="<%=REMARKS %>" value=" " class="textbox_size20"
	tabindex=3 maxlength="30" /> <label class="bodytextB_blue"><font
	id="error"></font>Approved By:</label> <select
	name="<%=APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT%>"
	validate="Approved By,String,yes">
	<option value="0">Select</option>
	<%
				for (MasEmployee approvedBy :approvedByEmployeeList ) {
			%>

	<option value=<%=approvedBy.getId()%>><%=approvedBy.getId()%></option>

	<%
				}
			%>
</select> <%} %> <br />


<input type="button" class="button" value="Next"
	onclick="if(checkForNext()){submitForm('departmentIndentGrid','stores?method=updateNextOrSubmitMmfDepartment&buttonName=next');}"
	align="right" /> <input type="button" name="sss" align="right"
	class="button" value="Submit"
	onclick="if(checkForSubmit()){submitForm('departmentIndentGrid','stores?method=updateNextOrSubmitMmfDepartment&buttonName=submit');}" />
Page No:<%=pageNo%> <br />
<fieldset style="width: 99%; padding-left: 9px;"><legend>MMF
Department Details</legend>


<div
	style="overflow: auto; width: 100%; height: 260px; padding-left: 9px;">
<table width="200px" colspan="7" id="mmfDepartmentDetails"
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
			<td width="13%"><label valign="left" class="smalllabel">Qty
			in MMF</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Remarks</label></td>
		</tr>

	</thead>
	<tbody>
		<%
    	int inc=1;
    	int detailCounter=8; 
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idAu="idAu";
    	    	
    	String mmfVar="mmfVar";
    	String incRemarks="incRemarks";
    	
    	
    	String mmfVarTemp="mmfVarTemp";
       	String incRemarksTemp="incRemarksTemp";
    	String incVar="incVar";
    	
    	
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idAu2="idAu";
    	
    	String mmfVar2="mmfVar";
      	String incRemarks2="incRemarks";

    	String mmfVarTemp2="mmfVarTemp";
    	String incRemarksTemp2="incRemarksTemp";
      	String incVar2="incVar2";
    	if(pageNo!=1){
    	inc=((pageNo-1)*8)+1;
    	}
 	   
 	   int incTemp2=inc+8;
 	   for(StoreMmfDepartmentT storeMmfDepartmentT:gridIndentTList){
 		 
 		  if(inc<=incTemp2){
 	     		idItem=idItem2+(""+inc);
 	     		codeItem=codeItem2+(""+inc);
 	     		nameItem=nameItem2+(""+inc);
 	     		
 	     		idAu=idAu2+(""+inc);
 	     		
 	     		mmfVar=mmfVar2+(""+inc);
 	     		incRemarks=incRemarks2+(""+inc);
 	     		
 	     		mmfVarTemp=mmfVarTemp2+(""+inc);
 	     		incRemarksTemp=incRemarksTemp2+(""+inc);
 	     		incVar=incVar2+(""+inc);
     	
    	  %>
		<tr>
			<td width="5%"><input type="text" size="2"
				value="<%=storeMmfDepartmentT.getSrNo()%>" class="smcaption"
				name="<%=SR_NO%>" readonly="readonly" /></td>

			<input type="hidden" name="<%=MMF_DEPARTMENT_T_ID %>"
				value="<%=storeMmfDepartmentT.getId() %>" id="hdb" />

			<td width="10%"><input type="text" class="medcaption"
				name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>"
				value="<%=storeMmfDepartmentT.getItem().getPvmsNo() %>" /> <input
				type="hidden" value="<%=storeMmfDepartmentT.getItem().getId()%>"
				name="<%=ITEM_ID%>" id="<%=idItem%>" /></td>
			<td width="10%"><input type="text"
				value="<%=storeMmfDepartmentT.getItem().getNomenclature() %>"
				tabindex=1 id="<%=nameItem%>" class="bigcaption"
				name="<%=NOMENCLATURE%>"
				onblur="fillItemsInMmfDepartment(this.value,<%=inc%>);" /></td>
			<script>
		var obj = actb(document.getElementById('<%=nameItem%>'),nameArray);
		</script>
			<td width="10%"><input type="text"
				value="<%=storeMmfDepartmentT.getItem().getItemConversion().getItemUnitName() %>"
				class="smcaption" readonly="readonly" name="<%=AV%>" id="<%=idAu%>" /></td>

			<%if(storeMmfDepartmentT.getMmfInQty()!=null){ %>
			<td width="10%"><input type="text" maxlength="6"
				value="<%=storeMmfDepartmentT.getMmfInQty() %>" class="medcaption"
				tabindex=1 name="<%=QTY_IN_MMF_TEMP%>" tabindex="2"
				id="<%=mmfVarTemp%>" validate="Qty In MMF,num,no"
				onblur="fillValuesBalance(<%=inc%>);" /> <input type="hidden"
				value="<%=storeMmfDepartmentT.getMmfInQty() %>" class="medcaption"
				name="<%=QTY_IN_MMF%>" tabindex="2" id="<%=mmfVar%>" /></td>
			<%}else{ %>
			<td width="10%"><input type="text" maxlength="6"
				value="<%=storeMmfDepartmentT.getMmfInQty() %>" class="medcaption"
				tabindex=1 name="0" tabindex="2" id="<%=mmfVarTemp%>"
				validate="Qty In MMF,num,no" onblur="fillValuesBalance(<%=inc%>);" />
			<input type="hidden" value="<%=storeMmfDepartmentT.getMmfInQty() %>"
				class="medcaption" name="0" tabindex="2" id="<%=mmfVar%>" /></td>
			<%} %>
			<td width="10%"><input type="text" class="medcaption"
				value="<%=storeMmfDepartmentT.getRemarks() %>"
				name="<%=REMARKS_TEMP%>" tabindex="1" id="<%=incRemarksTemp%>"
				onblur="fillClinical(<%=inc %>);" /> <input type="hidden"
				class="medcaption" value="<%=storeMmfDepartmentT.getRemarks() %>"
				name="<%=REMARKS_VAR%>" tabindex="2" id="<%=incRemarks%>" /></td>
		</tr>
		<% inc++;}}%>
		<script>
	    	 document.departmentIndentGrid.noOfRows.value=<%=inc-((pageNo-1)*8)-1%>
	    	 </script>

		<%if(inc<incTemp2){
			  for(;inc<incTemp2;inc++){
				  idItem=idItem2+(""+inc);
		     		codeItem=codeItem2+(""+inc);
		     		nameItem=nameItem2+(""+inc);
		     		idAu=idAu2+(""+inc);
		     		mmfVar=mmfVar2+(""+inc);
		     		incRemarks=incRemarks2+(""+inc);

		     		mmfVarTemp=mmfVarTemp2+(""+inc);
		     		incRemarksTemp=incRemarksTemp2+(""+inc);
		     		incVar=incVar2+(""+inc);
			  %>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text" class="medcaption"
				name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>" /> <input
				type="hidden" value="0" name="<%=ITEM_ID%>" id="<%=idItem%>" /></td>
			<td width="10%"><input type="text" value="" tabindex=1
				id="<%=nameItem%>" class="bigcaption" name="<%=NOMENCLATURE%>"
				onblur="fillItemsInMmfDepartment(this.value,<%=inc%>);" /></td>
			<script>
		var obj = actb(document.getElementById('<%=nameItem%>'),nameArray);
		</script>
			<td width="10%"><input type="text" value="" class="smcaption"
				readonly="readonly" name="<%=AV%>" id="<%=idAu%>" /></td>


			<td width="10%"><input type="text" maxlength="6" value=""
				class="medcaption" name="<%=QTY_IN_MMF_TEMP%>" tabindex="1"
				id="<%=mmfVarTemp%>" validate="Qty in MMF,num,no"
				onblur="fillValuesBalance(<%=inc%>);" /> <input type="hidden"
				value="0" class="medcaption" name="<%=QTY_IN_MMF%>" tabindex="2"
				id="<%=mmfVar%>" /></td>

			<td width="10%"><input type="text" value="" tabindex="1"
				name="<%=REMARKS_TEMP%>" id="<%=incRemarksTemp%>"
				onblur="fillClinical(<%=inc %>);" maxlength="30" /> <input
				type="hidden" size="2" value="emptyString" name="<%=REMARKS_VAR%>"
				id="<%=incRemarks%>" validate="Remarks,string,no" /></td>
			</td>



		</tr>

		<% }}%>

	</tbody>

</table>
</fieldset>


</div>

<span class="bodytextB_blue">Changed By:</span> <input type="text"
	name="<%=CHANGED_BY%>" value="<%=userName%>" class="textbox_size20"
	readonly="readonly" MAXLENGTH="8" / tabindex=3 /> <span
	class="bodytextB_blue"> Changed Date:</span> <input type="text"
	name="<%=CHANGED_DATE %>" value="<%=date%>" class="textbox_size20"
	readonly="readonly" tabindex=3 /> <span class="bodytextB_blue">Changed
Time:</span> <input type="text" name="<%=CHANGED_TIME %>" value="<%=time%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /></form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" />

</form>

</div>
