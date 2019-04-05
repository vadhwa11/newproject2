<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
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
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>



<style type="text/css">
html,body {
	overflow: auto;
}

#contentHolder {
	width: 600px;
}

<!--
.locatorArrow {
	COLOR: #666666;
	FONT-FAMILY: Verdana;
	FONT-SIZE: 12px
}
</style>

<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	String hiddenFieldForRecords="";
	String itemIdForNextRecord=null;
	Box box = HMSUtil.getBox(request);
	boolean rites = false;
	
	Vector mmfTItems = new Vector();
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
		}
 	
  	Map map = new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	List existingTenderNumbersList = null;
	List mmfyears = null;
	String tender_no;
	int currentYear=0;
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
	}
	
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	int mmfMasterId = 0;
	String storeType="";
	if (map.get("storeType")!=null)
	{
		storeType =(String) map.get("storeType"); 
	}
	if (box.getInt("mmfMasterId")!=0)
	{
		mmfMasterId = box.getInt("mmfMasterId");
	}
	else if (map.get("newmmfMasterId")!=null) 
	{
		mmfMasterId = (Integer)map.get("newmmfMasterId");
	}
	
	
	if(map.get("hiddenFieldForRecords")!= null)
	{
		hiddenFieldForRecords=(String)map.get("hiddenFieldForRecords");
	}
	if(map.get("itemIdForNextRecord")!= null)
	{
		itemIdForNextRecord=(String)map.get("itemIdForNextRecord");
	}
	
	if(map.get("rites") != null){
		rites = (Boolean)map.get("rites");
	}
%>

<title>MMF Addition</title>


<script>

//this function will be called by the Bean (not from JSP)
  function goPage(pidx) {	
	mmfForm.currPage.value = pidx;
	mmfForm.method="post";
	var mmfMasterId = document.mmfForm.<%=MMF_DEPARTMENT_M_ID %>.value;
	
	var valueOfHiddenField=document.mmfForm.hiddenFieldForRecords.value;
	
	if(valueOfHiddenField =="true"){
		submitForm('mmfForm','stores?method=showAddMmfDepartmentJspForNextRecord&mmfMasterId='+mmfMasterId);
	}else{
		submitForm('mmfForm','stores?method=showAddMmfDepartmentJsp&mmfMasterId='+mmfMasterId);
	}
}

function jsSubmit()
{
		mmfForm.method="post";
		var mmfMasterId = document.mmfForm.<%=MMF_DEPARTMENT_M_ID%>.value;
		var storeType= document.mmfForm.storeType.value;
		var pvms=document.mmfForm.pvms1.value;
		var search_text=document.mmfForm.search_text1.value;
		if(pvms.length!=0){
		if(pvms.length<3 ){
		alert("search text should be at least 3 characters");
		}}
		else{
		submitForm('mmfForm','stores?method=showAddMmfDepartmentJsp&pvms='+pvms+'&search_text='+search_text+'&mmfMasterId='+mmfMasterId);
		}
		if(search_text.length!=0){
		if(search_text.length<3 ){
		alert("search text should be at least 3 characters");
		}}
		else{
		submitForm('mmfForm','stores?method=showAddMmfDepartmentJsp&pvms='+pvms+'&search_text='+search_text+'&mmfMasterId='+mmfMasterId);
		}
		submitForm('mmfForm','stores?method=showAddMmfDepartmentJsp&pvms='+pvms+'&search_text='+search_text+'&mmfMasterId='+mmfMasterId);
}

function jsAdd()
{
	mmfForm.method="post";
		//alert("jsAdd")
		var mmfMasterId = document.mmfForm.<%=MMF_DEPARTMENT_M_ID %>.value;
		var mmfDate = document.mmfForm.<%=MMF_DEPARTMENT_DATE%>.value;
		var deptId = document.mmfForm.<%= STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>.value;
		var mmfNo = document.mmfForm.mmfNo.value;
		var remarks  = document.mmfForm.<%=REMARKS %>.value;
		var storeType= document.mmfForm.storeType.value;
		var checkedBy=document.mmfForm.<%=CHECKED_BY %>.value;
		var preparedBy=document.mmfForm.<%=PREPARED_BY %>.value;
		var monForMMF=document.mmfForm.<%=MONTH %>.value;
		//alert("jsAdd 1")
		submitForm('mmfForm','stores?method=doAddMmfItems&storeType='+storeType+'&mmfMasterId=' +mmfMasterId +'&<%=MMF_DEPARTMENT_DATE%>=' + mmfDate + '&<%=STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>=' + deptId+'&mmfNo='+mmfNo+'&remarks='+remarks+'&checkedBy='+<%=CHECKED_BY%>+'&preparedBy='+<%=PREPARED_BY%>+'&monthForMMF='+monForMMF); 
}
	function callNext()
	{
	 if(validateNextRecordButton()){						
			//alert("In cal Next method value of itemid---"+itemIdField)
		mmfForm.method="post";
		var mmfDate = document.mmfForm.<%=MMF_DEPARTMENT_DATE %>.value;
		var mmfMasterId = document.mmfForm.<%=MMF_DEPARTMENT_M_ID %>.value;
		var deptId = document.mmfForm.<%= STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>.value;
		var mmfNo = document.mmfForm.mmfNo.value;
		var remarks = document.mmfForm.<%=REMARKS %>.value;
		var storeType = document.mmfForm.storeType.value;
		var checkedBy=document.mmfForm.<%=CHECKED_BY %>.value;
		var preparedBy=document.mmfForm.<%=PREPARED_BY %>.value;
		var monForMMF=document.mmfForm.<%=MONTH %>.value;
		var approvedBy = document.mmfForm.<%=APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT%>.value;


		//document.indentForm.hiddenFieldForRecords.value="true";
		submitForm('mmfForm','/hms/hms/stores?method=showAddMmfDepartmentJspForNextRecord&mmfMasterId='+mmfMasterId + '&<%=MMF_DEPARTMENT_DATE%>=' + mmfDate +'&<%=STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>='+deptId+'&mmfNo='+mmfNo+'&<%=REMARKS%>='+remarks+'&<%=APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT%>='+approvedBy+'&storeType='+storeType+'&currPage=1&buttonName=next&checkedBy='+<%=CHECKED_BY%>+'&preparedBy='+<%=PREPARED_BY%>+'&monthForMMF='+monForMMF);
		}
	}						
	function validateNextRecordButton()
	{	
		//for(var i = 0; i < document.getElementsByName('itemId').length; i++){
		//alert("document.getElementsByName('itemId').length"+document.getElementsByName('itemId').length +"document.getElementsByName('itemId')[i].value------"+document.getElementsByName('itemId')[i].value)
		if(document.getElementsByName('itemId').length==0){
			alert("Please Go to previous Record and then Click for next 1000 records.")
			return false;
		}else{
		   return true; 
	   }
	}  

	function jsClose()
	{
		var storeType= document.mmfForm.storeType.value;
		var preparedBy=document.mmfForm.<%=PREPARED_BY %>.value;
			var checkedBy=document.mmfForm.<%=CHECKED_BY %>.value;
			var monForMMF=document.mmfForm.<%=MONTH %>.value;
		   var approvedBy = document.mmfForm.<%=APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT%>.value;

	  window.opener.location.href = "stores?method=getMmfDepartmentData&&numOfRows=10&pageCount=10&currPage=1&storeType="+storeType+ "&<%=MMF_DEPARTMENT_DATE%>="+mmfForm.<%=MMF_DEPARTMENT_DATE%>.value+"&<%=STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>="+mmfForm.<%=STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>.value+"&<%=REMARKS%>="+mmfForm.<%=REMARKS%>.value + "&checkedBy="+<%=CHECKED_BY%>+"&preparedBy="+<%=PREPARED_BY%>+'&monthForMMF='+monForMMF;
	  if (window.opener.progressWindow)
		 {
	    	window.opener.progressWindow.close()
	  	 } 
	  window.close();
	}

</script>


<h2>MMF Addition</h2>
<div class="Clear"></div>
<form name="mmfForm"><input type="hidden" name="numOfRows"
	size="5" value="15"> <input type="hidden" name="pageCount"
	size="5" value="10"> <input type="hidden" name="search"
	size="5" value="true"> <input type="hidden"
	name="<%=MMF_DEPARTMENT_M_ID %>" value="<%=mmfMasterId%>" /> <input
	type="hidden" name="<%=MMF_DEPARTMENT_DATE %>"
	value="<%=box.get(MMF_DEPARTMENT_DATE)%>" /> <input type="hidden"
	name="<%=STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT %>"
	value="<%=box.get(STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT) %>" />
<input type="hidden" name="mmfNo" value="<%=box.get("mmfNo") %>" /> <input
	type="hidden" name="<%=REMARKS %>" value="<%=box.get(REMARKS) %>" /> <input
	type="hidden" name="<%=PREPARED_BY%>"
	value="<%=box.get(PREPARED_BY) %>" /> 
	 <input
	type="hidden" name="<%=MONTH%>"
	value="<%=box.get(MONTH) %>" />
	<input type="hidden"
	name="<%=CHECKED_BY %>" value="<%=box.get(CHECKED_BY) %>" /> <input
	type="hidden" name="hospitalId" value="<%=hospitalId%>" /> <input
	type="hidden" name="<%=APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT%>"
	value="<%=box.get(APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT)%>" /> <input
	type="hidden" name="storeType" value="<%=box.get("storeType") %>" /> <input
	type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

<h4>Store Item(s) Search</h4>
<div class="Clear"></div>
<div class="block"><label>Nomenclature</label> <input
	type="text" name="search_text1" value="" MAXLENGTH="50"
	onkeypress="submitenter(this,event,'stores?method=showAddMmfDepartmentJsp&mmfMasterId='+document.mmfForm.<%=MMF_DEPARTMENT_M_ID%>.value)" />
<input type="hidden" name="search_text"
	value="<%= box.get("search_text")%>" /> 
	<label>PVMS No.</label>
	<input 	type="text" name="pvms1" value="" MAXLENGTH="30"
	onkeypress="submitenter(this,event,'stores?method=showAddMmfDepartmentJsp&mmfMasterId='+document.mmfForm.<%=MMF_DEPARTMENT_M_ID%>.value)" />
<input type="hidden" name="pvms" value="<%=box.get("pvms") %>" /></div>
<div class="Clear"></div>
<input type="button" name="Submit" id="addbutton" onClick="jsSubmit()"
	value="Search" class="button" />
<div class="Clear"></div>
<input type="hidden" name="itemIdForNextRecord"
	value="<%=itemIdForNextRecord %>" /> <%if(hiddenFieldForRecords.equals("true")){ %>
<input type="hidden" name="hiddenFieldForRecords" value="true" /> <%} else{%>
<input type="hidden" name="hiddenFieldForRecords" value="" /> <%} %>

<div style="padding-left: 350px;"><input type="button"
	name="nextRecords" id="nextRecords" onClick="callNext()"
	value="Next 1000 Records" class="buttonBig"  /></div>
<div class="Clear"></div>
<%		
		if (pagedArray == null) {
		%>

<h4>Store MMF Item Details</h4>
<div class="Clear"></div>

<div class="tableHholder">
<table align="center" width="100%" colspan="7" class="grid_header"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="5%">Sl No.</th>
			<th width="10%">PVMS No</th>
			<th width="30%">Nomenclature</th>
			<th width="10%">A/U</th>
			<th width="10%">MMF</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=8 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<input type="button" name="Close" onClick="jsClose()" value="Close"
	class="button" />
<div class="Clear"></div>

<%  } else { %>

<h4>Store MMF Item Details</h4>
<div class="Clear"></div>
<div class="tableHholder">
<table align="center" width="100%" colspan="7" class="grid_header"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>Sl No.</th>
			<th>PVMS No</th>
			<th>Nomenclature</th>
			<th>A/U</th>
			<th>MMF</th>
			<th>ADD</th>

		</tr>
	</thead>
	<tbody>


		<%
			    gridData = (HashMap[])pagedArray.getPagedArray();
				int iFirstRow = pagedArray.getFirstRowIdx();
				 mmfTItems = (Vector)map.get("mmfTItems");
			    for(int i=0;i<gridData.length;i++)
			    { 
			    %>

		<tr>
			<td><input type="text" value="<%=iFirstRow++%>" name="srno"
				size="2" readonly="readonly" /></td>
			<td><input type="text" value="<%=gridData[i].get("pvms" )%>"
				size="10" name="pvms" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=gridData[i].get("nomenclature")%>" size="55"
				name="nomenclature" readonly="readonly" /></td>

			<td><input type="text" value="<%=gridData[i].get("au")%>"
				name="au" size="12" readonly="readonly" /></td>
			<td><input type="text"
				value="<%=(gridData[i].get("qtymmf")==null)?"":gridData[i].get("qtymmf")%>"
				size="10" name="qtymmf" validate="MMF Qty,num,no" maxlength="10" />
			</td>
			<% if(mmfTItems.contains(gridData[i].get("itemId")) || gridData[i].get("approvedStatus")!=null){
				%><td>
			<%if(mmfTItems.contains(gridData[i].get("itemId"))) {%> <input
				type="checkbox" name=<%=ITEMS_TO_BE_ADDED%>
				value="<%=gridData[i].get("itemId")%>" disabled> <%} else { 
				           if(rites){  %> <input type="checkbox"
				name=<%=ITEMS_TO_BE_ADDED%> value="<%=gridData[i].get("itemId")%>">
			<%}else {%> <input type="checkbox" name=<%=ITEMS_TO_BE_ADDED%>
				value="<%=gridData[i].get("itemId")%>" disabled> <%} 
				       } %>
			</td>
			<%}else{%>
			<td><input type="checkbox" name=<%=ITEMS_TO_BE_ADDED%>
				value="<%=gridData[i].get("itemId")%>"></td>
			<%} %>
			<td><input type="hidden" value="<%=gridData[i].get("itemId")%>"
				name="itemId" /></td>

		</tr>
		<% } %>

	</tbody>
</table>
</div>

<div class="Clear"></div>

<div id="pagination"><%= pagedArray.showIndex()%> <%= pagedArray.getPageIndexHiddenTag()%>
</div>
<div class="Clear"></div>
<div class="Height10"></div>


<input type="button" name="Add" onClick="jsAdd();" value="Add"
	class="button" /> <input type="button" name="Close"
	onClick="jsClose()" value="Close" class="button" />

<div class="Clear"></div>
<%box.put("mmfTItems",mmfTItems);}%>
</form>