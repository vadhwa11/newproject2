<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> -->
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->

<script type="text/javascript" language="javascript"src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/list.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
<script type="text/javascript" language="javascript">
<%
Calendar calendar=Calendar.getInstance();
String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
String getDate=String.valueOf(calendar.get(Calendar.DATE));
int year=calendar.get(calendar.YEAR);
if(month.length()<2){
month="0"+month;
}
if(getDate.length()<2){
getDate="0"+getDate;
}

%>
serverdate = '<%=getDate+"/"+month+"/"+year%>'
</script>

<%
	Map map = new HashMap();
	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}

	if(map.get("hospitalList")!=null)
	{
		hospitalList=(List)map.get("hospitalList");
	}
	
	if(map.get("departmentList")!=null)
	{
		departmentList=(List)map.get("departmentList");
	}
%>
<!--main content placeholder starts here-->
<form name="budgetAndExpense" action="" method="post">

<div class="titleBg">
<h2>Department Allocation</h2>
</div>

<div class="clear paddingTop15"></div>
<div class="Block">

<label class="auto" size="14">SMC</label>
<select name="hospitalId" id="hospitalId"  onchange="getDepartment(this.value)">
     	<option value="0">Select</option>
       <%
       for(MasHospital mh:hospitalList){
    	   %>
       <option value="<%=mh.getId() %>"><%=mh.getHospitalName()%></option>
       
       <%} %>
</select>
<div class="clear"></div>
<label class="hdTitle">Available Department</label>
<label class="hdTitle">Assigned Department</label>
 <div class="clear"></div>
 
<select name="availableDept" id="availableDept"  multiple="multiple" size="3" class="listBig3">
    <%
       for(MasDepartment md:departmentList){
    	   %>
       <option value="<%=md.getId() %>"><%=md.getDepartmentName()%></option>
       
       <%} %>
</select>



<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="button" value=">>" onclick="copySelectedOptions();" />

<input type="button" name="send" class="button" value="<<" onclick="removeSelectedOptions();"/>
</div>
<div id="DeptDiv">  

<select name="assignDept" id="assignDept"  multiple="multiple" size="3" class="listBig3">
</select>

</div>
<input type="hidden"  name="code"  value="" />
<input type="hidden"  name="desc"  value="" />
<input type="button" class="button" name="assign" value="Assign" onclick="confirmSubmit();"/>

<div class="clear"></div>
</div>



<script type="text/javascript">


function confirmSubmit()
{
	var hospitalId= parseInt(document.getElementById('hospitalId').value);

if(hospitalId!=0)
{
 var x = confirm('Are you sure , you want to assign selected department to selected record ?');
 if(x)
 {
 	var objTemp = document.getElementById("assignDept");
	    for (var k=0; k<objTemp.options.length; k++) {
		  objTemp.options[k].selected=true
	 }
		
 submitForm('budgetAndExpense','stores?method=AssignDepartmentForStoreFyDocument');
 }
 else
 {
 	return false;
 }
}else
{
alert("Please Select SMC!!");
document.getElementById('hospitalId').focus();
return false;
}
}

function getDepartment(val)
{
submitProtoAjaxforDepartment('budgetAndExpense','/hms/hms/stores?method=getDepartmentForDepartmentAllocation&hospitalId='+val);
}

function submitProtoAjaxforDepartment(formName,action){
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)
        	new Ajax.Updater('DeptDiv',url,
			   {asynchronous:true, evalScripts:true });
	       	return true;
    	}  


function copySelectedOptions() {
	   from =document.getElementById("availableDept")
	   to =document.getElementById("assignDept")
		var options = new Object();
		if (hasOptions(to)) {
			for (var i=0; i<to.options.length; i++) {
				options[to.options[i].value] = to.options[i].text;
				}
			}
		if (!hasOptions(from)) { return; }
		for (var i=0; i<from.options.length; i++) {
			var o = from.options[i];
			if (o.selected) {
				if (options[o.value] == null || options[o.value] == "undefined" || options[o.value]!=o.text) {
					if (!hasOptions(to)) { var index = 0; } else { var index=to.options.length; }
					to.options[index] = new Option( o.text, o.value, true, false);
					}
				}
			}
		if ((arguments.length<3) || (arguments[2]==true)) {
			sortSelect(to);
			}
		from.selectedIndex = -1;
		to.selectedIndex = -1;
		var objTemp = document.getElementById("tempId");
		for (var k=0; k<objTemp.options.length; k++) {
			objTemp.options[k].selected=true
			}
		}


function removeSelectedOptions() {
	 from =document.getElementById("assignDept") 
		if (!hasOptions(from)) { return; }
		if (from.type=="select-one") {
			from.options[from.selectedIndex] = null;
			}
		else {
			for (var i=(from.options.length-1); i>=0; i--) { 
				var o=from.options[i]; 
				if (o.selected) { 
					from.options[i] = null; 
					} 
				}
			}
		from.selectedIndex = -1; 
		} 
</script>




</form>