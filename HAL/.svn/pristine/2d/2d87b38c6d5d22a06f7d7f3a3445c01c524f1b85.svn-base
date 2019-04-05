<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<link rel="stylesheet" href="/hms/jsp/css/style.css" type="text/css" />
<%Map<String,Object> map = new HashMap<String,Object>();
  Box box = HMSUtil.getBox(request);
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasDepartment> deptList= new ArrayList<MasDepartment>();
if(map.get("departmentList") != null){
	deptList = (List)map.get("departmentList");
}

%>
<script type="text/javascript" language="javascript">
function add(){
addDepartmentMMF.method="post";
	 var err ="";
	 var dept =  document.getElementById('Department').value
	 var qty = document.getElementById('MMFQTY').value
	 
	   if(dept == 0){
	    err = err + "Please select Department.";
	   }
	   if(qty == ""){
 	    err = err + "\n Enter mmf qty."
	   }
	   if(err == ""){
	     if(confirm("Are you Sure, you want to add the New Department ?")){
		 submitForm('addDepartmentMMF','/hms/hms/stores?method=additionNewDepartmentMMF');
	     window.opener.jsGetGrid();
	     self.close();
	     }else{
	     return false;
	     }
	   }else{ 
	     alert(err);
	   }
	}

</script>
<div id="contentHolder">
<form name="addDepartmentMMF"><br>
<div class="blockTitle">New Department MMF Addition</div>
<div class="blockTitleCurve"></div>
<div class="blockFrame"><label class="bodytextB">Year: </label> <label
	style="color: black"><%= box.getString("year") %></label> <label
	class="bodytextB">Mmf For Store: </label> <label style="color: black"><%=  box.getString("sType").equals("e")?"Expendable Store":"ECHS" %></label>

<label class="bodytextB">PVMS No/NIV: </label> <label
	style="color: black"><%=   box.getString("pvmsNo") %></label> </br>
<label class="bodytextB">Nomenclature: </label> <label
	style="color: black"><%=  box.getString("nomenclature") %></label> <input
	type="hidden" name="year" id="year" value="<%= box.getString("year")%>">
<input type="hidden" name="storeType" id="storeType"
	value="<%=box.getString("sType")%>"> <input type="hidden"
	name="pvms" id="pvms" value="<%= box.getString("pvmsNo")%>"> <input
	type="hidden" name="nomenclature" id="nomenclature"
	value="<%= box.getString("nomenclature")%>"></div>

<br>
<div class="blockFrame"><label class="bodytextB">Department:
</label> <select name="<%=DEPARTMENT_ID%>" id="Department" tabindex="1"
	onchange="" style="width: 150px;" validate="Year,String,no">
	<option value="0">Select</option>
	<%	if(deptList.size() !=0){
		for (MasDepartment dept : deptList) { %>
	<option value="<%=dept.getId()%>"><%=dept.getDepartmentName()%></option>
	<%}} %>
</select> <label>MMF QTY</label> <input type="text" name="MMFQTY" tabindex="1"
	id="MMFQTY" />
<div class="Clear"></div>
<label>Remarks:</label> <textarea name="remarks" tabindex="1"
	class="txtareammf" MAXLENGTH="30">
</textarea></div>
<div class="Clear"></div>
<input type="button" name="addition" value="Add" class="button"
	onClick="add();" /></form>
</div>



