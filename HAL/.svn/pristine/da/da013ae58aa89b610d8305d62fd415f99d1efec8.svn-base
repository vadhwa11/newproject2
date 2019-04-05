<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import = "static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link  rel="stylesheet" type="text/css" href="/erp/jsp/css/hms_style.css" />
<form name="printhrloan" method="post" action="">

<%Map<String,Object> map =new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map) request.getAttribute("map");
}
List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
if(map.get("employeeList")!=null){
	employeeList=(List<MasEmployee>)map.get("employeeList");
}
List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
if(map.get("departmentList")!=null){
	departmentList=(List<MasDepartment>)map.get("departmentList");
}

%>

<script type="text/javascript">

var empArr = new Array();
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



<div class="titleBg">
<h2>Loan Statement</h2></div>

<div class="clear"></div>
 <div class="Block">        
         
         <label><span>*</span>Department</label>
		<select name="department" validate="Department,string,no" onChange="populateEmployee1(this.value,'printhrloan')"  >
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
empArr[<%=counter%>][2] = "<%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%>";
<%
counter++;
}
}
}
}
%>
</script> 
    	 <label><span>*</span>Employee</label>
    	<select name="fromempcode" id="employeeId" validate = "Employee string,no">
    	<option value="0">All</option>
    	<%
			for(MasEmployee masEmployee:employeeList)
			{				
		%>
		<option value="<%= masEmployee.getId() %>"><%=masEmployee.getFirstName()%>  <%=masEmployee.getLastName()%></option>
		
		<%} %>
    	</select>
    
    	<div class="clear"></div>
    	<input type="button" class="button" value="View" name="print" onclick="submitForm('printhrloan','/hms/hms/loan?method=printloanstatement');"/>

  	<div class="clear"></div> 
 	</div>
   </form>
