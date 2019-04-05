<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForDischarge.jsp  
 * Purpose of the JSP -  This is for Response Discharge.
 * @author  shailesh
* Create Date: 13 march 2009 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>


<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/addRow.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar2.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script>
 var flag;
 </script>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<MasDepartment> masDepartmentNoList = new ArrayList<MasDepartment>();
	if(map.get("masDepartmentNoList")!=null){
		masDepartmentNoList=(List<MasDepartment>)map.get("masDepartmentNoList");
	}
	
	
	%>
<div id="departmentNoDiv">
			<label>Department No.<span>*</span></label>
<%
String departmentNo="";
				         		if(masDepartmentNoList.size()>0){ 	
				         			for (Iterator iter = masDepartmentNoList.iterator(); iter.hasNext();) {
				         				MasDepartment department = (MasDepartment) iter.next();
				         				departmentNo=department.getDepartmentNo();
				         			}
				         		}
				         %>
				     <input type="text" id="deptNo" name="deptNo" value="<%=departmentNo %>"	 readonly="readonly" validate="Department No.,alphanumeric,yes" MAXLENGTH="50" />
	    		        

</div>