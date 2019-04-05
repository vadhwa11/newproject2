<%@page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasRank> rankList = new ArrayList<MasRank>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if (map.get("employeeList") != null) {
		employeeList = (List) map.get("employeeList");
	}
	if (map.get("departmentList") != null) {
		departmentList = (List) map.get("departmentList");
	}
	if (map.get("rankList") != null) {
		rankList = (List) map.get("rankList");
	}
%>
		


<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<form name="advanceStatement" method="post" action="" >
<div class="titleBg"> <h2>Advance Statement</h2></div>
<div class="clear"></div>
<div class="Block">

<label><span>*</span>Department</label>
		<select name="department" validate="Department,string,no" onChange="populateEmployee1(this.value,'advanceStatement')"  >
		<option value="0">All</option>
		<%
			for (MasDepartment masDepartment : departmentList) {
		%>
		<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
					
		<%
						}
					%>
		</select>
		
		<script>    
		 var empArr = new Array();
    	 <%
    
int counter=0;
for (MasDepartment masDepartment :departmentList) 
{
for (MasEmployee masEmployee :employeeList) 
{
	if(masEmployee.getDepartment() != null){
		if(masDepartment.getId().equals(masEmployee.getDepartment().getId())){
%>
empArr[<%=counter%>] = new Array();
empArr[<%=counter%>][0] = <%=masDepartment.getId()%>;
empArr[<%=counter%>][1] = <%=masEmployee.getId()%>;									
empArr[<%=counter%>][2] = "<%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%>";
<%
counter++;
}
}
}
}
%>
</script> 
    	 <label><span>*</span>Employee</label>
    	<select name="employeeId" id="employeeId" validate = "Employee string,no">
    	<option value="0">All</option>
    	<%
			for(MasEmployee masEmployee:employeeList)
			{				
		%>
		<option value="<%= masEmployee.getId() %>"><%=masEmployee.getFirstName()%> <%=masEmployee.getLastName()%></option>
		
		<%} %>
    	</select>
<div class="clear"></div>


<div class="clear"></div>


<input name="Ok" type="button" class="button" value="View" onclick="submitForm('advanceStatement','loan?method=printAdvanceStatementReport');"/>

<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<div class="clear"></div>


</div>

<script type="text/javascript">


function populateEmployee1(val,formName){
	obj = eval('document.'+formName+'.employeeId');
	obj.length = 1;

	for(i=0;i<empArr.length;i++){
		if(empArr[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=empArr[i][1];
			obj.options[obj.length-1].text=empArr[i][2];			
		}
	}
}

</script>

</form>

