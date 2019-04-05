

<%@page import="jkt.hms.masters.business.MasGrade"%>
<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

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
	
	List<MasGrade> masGradeList = new ArrayList<MasGrade>();
	if(map.get("masGradeList")!=null){
		masGradeList=(List<MasGrade>)map.get("masGradeList");
	}
	
	
	%>
<div id=gradeDiv>
 
		<label>Grade<span>*</span></label> 
		<select id="<%=EMPLOYEE_GRADE_ID%>" name="<%=EMPLOYEE_GRADE_ID%>" validate="Grade ,string,yes">
			<option value="0">Select</option>
<%
				         		if(masGradeList.size()>0){ 	
				         			for (Iterator iter = masGradeList.iterator(); iter.hasNext();) {
				         				MasGrade grade = (MasGrade) iter.next();
				         %>
			<option value="<%=grade.getId() %>"><%=grade.getGradeName() %></option>
			<%		
				        			}
				        		 } else{
				        %>
			<option value="0">No Record</option>	        
				        <%} %>
				        </div>
		</select> </div>
