<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<%Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	List treatmentTemplateList= new ArrayList();
	 List employeeList = new ArrayList();
	 if(map.get("employeeList") != null){
			employeeList=(List)map.get("employeeList");
			}
	int departmentId=0;
	 if(map.get("departmentId") != null){
		 departmentId=(Integer)map.get("departmentId");
			}
	%>

<%@page import="jkt.hms.masters.business.OpdTemplateTreatment"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<label class="small">Referred To</label>
<select name="empId" id="empId ">
	<option value="0">Select</option>
	<%
		   Iterator itr1= employeeList.iterator();
	       while(itr1.hasNext())
	       {
	    	   MasEmployee masEmployee=(MasEmployee) itr1.next();
	    	   int empId=masEmployee.getId();
	    	   String empName="";
	    		if(masEmployee.getFirstName()!= null){
	    			empName=masEmployee.getFirstName();
	    		}
	    		if(masEmployee.getMiddleName()!= null){
	    			empName=empName+" "+masEmployee.getMiddleName();
	    		}
	    		if(masEmployee.getLastName()!= null){
	    			empName=empName+" "+masEmployee.getLastName();
	    		}
	       
		%>
	<option value="<%=empId %>"><%=empName %></option>
	<%
	       }
		%>
</select>





