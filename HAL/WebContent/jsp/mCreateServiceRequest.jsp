
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MasPriorityCodes"%>
<%@page import="jkt.hms.masters.business.HesEquipmentAssessories"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

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
	Map<String ,Object> map = new HashMap<String ,Object>();
	String entryNo = "";
	String userName = "";
	String el="";
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<HesEquipmentMaster> hesEquipmentMaster = new ArrayList<HesEquipmentMaster>();
	List<MasItemType> masItemTypes = new ArrayList<MasItemType>();
	List<MasStoreSection> masStoreSection = new ArrayList<MasStoreSection>();
	List<MasItemClass> masItemClass = new ArrayList<MasItemClass>();
	List<MasItemCategory> masCategories = new ArrayList<MasItemCategory>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Date cd=new Date();
	List<Object[]> hesEquipmentList = new ArrayList<Object[]>();
	String prty="";
	if(request.getAttribute("map")!=null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	if (map.get("num")!=null)
		entryNo = (String)map.get("num").toString();
	if (map.get("departmentList")!= null){
		departmentList = (List<MasDepartment>)map.get("departmentList");
	}if (map.get("hesEquipmentMaster")!= null){
		hesEquipmentMaster= (List<HesEquipmentMaster>)map.get("hesEquipmentMaster");
	}if (map.get("masItemTypes")!= null){
		masItemTypes = (List<MasItemType>)map.get("masItemTypes");
	}if (map.get("masStoreSection")!= null){
		masStoreSection = (List<MasStoreSection>)map.get("masStoreSection");
	}if (map.get("masItemClass")!= null){
		masItemClass = (List<MasItemClass>)map.get("masItemClass");
	}if (map.get("masCategories")!= null){
		masCategories = (List<MasItemCategory>)map.get("masCategories");
	}
	if(request.getParameter("eL")!=null){
		el=request.getParameter("eL");
	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");

	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("msg") != null){
		   String message = (String)map.get("msg");
		   out.println(message);
	}
	int searchDepartmentId =0;
	if(map.get("searchDepartmentId") != null){
		searchDepartmentId= (Integer)map.get("searchDepartmentId");
	}
	System.out.println("");
// 	for(MasPriorityCodes mp:priority){
// 		prty+="<option value="+mp.getId()+">"+mp.getCodesName()+"</option>";
// 	}
%>

<div class="titleBg">
<h2>Search Equipment For Service Request</h2>
</div>
<form name="mSelectEquipment" method="post">
<div class="Block" >
<%--------------- Start of Search Panel using text box equipment no master ---------------------------%>
<label><span>*</span> Department</label>
<!-- onchange="if(this.value!=''){submitProtoAjaxWithDivNameToShowStatus('mSelectEquipment','/hms/hms/maintenance?method=getEquipmentList','equipmentList');}" -->
	<select name="department" id="de" validate="Department,alphanumeric,yes" >
	<option value="">Select Department</option>
	<% for(MasDepartment masDepartment:departmentList){
		if(masDepartment.getId().equals(searchDepartmentId)){
		
		%>
	<option value="<%=masDepartment.getId() %>" selected="selected"><%=masDepartment.getDepartmentName() %></option>
	<%}else{ %>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%}} %>
	</select>
	<label>Item Type</label>
	<select name="ItemType"><option value="">Select Item Type</option>
	<% for(MasItemType masItemType:masItemTypes){ %>
	<option value="<%=masItemType.getId() %>"><%=masItemType.getItemTypeName() %></option>
	<%} %>
	</select>
	<label>Section</label>
	<select name="Section"><option value="">Select Section</option>
	<% for(MasStoreSection masStoreSec:masStoreSection){ %>
	<option value="<%=masStoreSec.getId() %>"><%=masStoreSec.getSectionName() %></option>
	<%} %>
	</select>
	<div class="clear"></div>	
	<label>Category</label>
	<select name="Category"><option value="">Select Category</option>
	<% for(MasItemCategory masCategor:masCategories){ %>
	<option value="<%=masCategor.getId() %>"><%=masCategor.getItemCategoryName() %></option>
	<%} %>
	</select>
	<label>Class</label>
		<select name="Class"><option value="">Select Class</option>
		<% for(MasItemClass masItemClas:masItemClass){ %>
		<option value="<%=masItemClas.getId() %>"><%=masItemClas.getItemClassName() %></option>
		<%} %>
		</select>
	<div class="clear"></div>	
	<input class="button" type="button" align="right" onclick="return addE()" value="Search" name="sss">
	</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
	<div class="Block">
	<h4>Equipment List</h4>
	<%if(hesEquipmentMaster.size()>0){ %>
	<table>
		<tr><th>S.No</th><th>Item Name </th><th>Model No</th><th>Serial No</th><th>Manufacturer</th></tr>
		<% int sn=1;
		for(HesEquipmentMaster equipmentMaster:hesEquipmentMaster){ %>
<!-- 		+" -|||---  "+equipmentMaster.getItem().getItemType().getItemTypeName()+" ------  "+equipmentMaster.getItem().getSection().getSectionName()+" ----  "+equipmentMaster.getItem().getItemCategory().getItemCategoryName()+" ----- "+equipmentMaster.getItem().getItemClass().getItemClassName() -->
		<form name="Equipment<%=sn%>" method="post"><input type="hidden" name="requestId" value="<%=equipmentMaster.getId() %>" validate="Equipment,alphanumeric,no" /><tr onclick="submitForm('Equipment<%=sn%>', 'fm?method=showCreateServiceRequestDetails')" style="cursor: pointer;"><td><%=sn %></td><td><%=equipmentMaster.getItem().getNomenclature() %></td><td><%= equipmentMaster.getModelName()%></td><td><%= equipmentMaster.getSerialNo()%></td><td><%=equipmentMaster.getManufacturer()!=null?equipmentMaster.getManufacturer().getManufacturerName():"" %></td></tr>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
 </form>
		<% sn++;} %>
	</table>
	<%}else{ %>No Record Available.
	<%} %>
	</div>
<div class="clear"></div>
<div class="bottom">
		<label>Changed By:</label>
		<label class="value"><%=userName%></label>
		<label>Changed Date:</label>
		<label class="value"><%=currentDate%></label>
		<label>Changed Time:</label>
		<label class="value"><%=currentTime%></label>
<!--Block Two Ends-->
	
	<!--Bottom labels starts-->
	
	<input type="hidden" name="lastChgBy" value="<%=userName%>" />
	<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
	<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
	<input type="hidden" name="eL" id="eL" value="<%=el %>" />
	</div>
<script type="text/javascript">
	function addE(){
	/* 	var requestType=document.getElementsByName("RequestType");
		var priority=document.getElementsByName("Priority");
		var remarks=document.getElementsByName("description");
		for(var i=0;i<requestType.length;i++){
			var d1=requestType[i].getAttribute("validate").replace('yes','no');
			requestType[i].setAttribute("validate",requestType[i].getAttribute("validate").replace('yes','no'));
			priority[i].setAttribute("validate",priority[i].getAttribute("validate").replace('yes','no'));
			remarks[i].setAttribute("validate",remarks[i].getAttribute("validate").replace('yes','no'));
		} */
		
		if(document.getElementById("de").value=="")
			{alert("Department not selected."); return false;}
		/* if(document.getElementById("eq").value==""){
			alert("Equipment not selected."); return false;
		}
		if(document.getElementById("de").value=="")
		{alert("Department is Empty."); return false;}
		var el=document.getElementById("eL").value;
		if(el==null)
			document.getElementById("eL").value="";
		var dep=document.getElementById("de").value;
		var equ=document.getElementById("eq").value;
		document.getElementById("eL").value+=equ+"#"; */
		submitForm('mSelectEquipment','/hms/hms/fm?method=showCreateServiceRequestJsp');
	}

	function submitData(){
		var requestType=document.getElementsByName("RequestType");
		var priority=document.getElementsByName("Priority");
		var remarks=document.getElementsByName("description");
		for(var i=0;i<requestType.length;i++){
			var d1=requestType[i].getAttribute("validate").replace('no','yes');
			requestType[i].setAttribute("validate",requestType[i].getAttribute("validate").replace('no','yes'));
			priority[i].setAttribute("validate",priority[i].getAttribute("validate").replace('no','yes'));
			remarks[i].setAttribute("validate",remarks[i].getAttribute("validate").replace('no','yes'));
		}
		submitForm('mSelectEquipment','/hms/hms/fm?method=submitCreateServiceRequest');
	}
	
	
	function addEquipment(){
		var dep=document.getElementById('department').value;
		var equ=document.getElementById('equipment').value;
		submitProtoAjaxWithDivNameToShowStatus('mCreateServiceRequest','/fm?method=getEquipmentList','equipmentDetail');
	}

	function removeRow()
	{
		var tbl = document.getElementById('eqDetails');
		 var tblRows  = tbl.getElementsByTagName("tr");
// 	  	if(tblRows.length-1==0){
// 	         	alert("Can not delete all rows")
// 	         	return false;
// 	     }
	  	for(abc=0;abc<document.getElementsByName('selectedChrage').length;abc++)
		{
			if (document.getElementsByName('selectedChrage')[abc].checked == true)
			{
				var el=document.getElementById("eL").value.replace(document.getElementsByName('selectedChrage')[abc].value, '');
			  	document.getElementById("eL").value=el;
				tbl.deleteRow(abc+1);
			}
		}
// 	  	alert(document.getElementById("eL").value);
	}
</script>
