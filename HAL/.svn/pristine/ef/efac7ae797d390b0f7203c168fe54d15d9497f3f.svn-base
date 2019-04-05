

<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
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



<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<MasDistrict> districtList = new ArrayList<MasDistrict>();
	if(map.get("districtList")!=null){
		districtList=(List<MasDistrict>)map.get("districtList");
	}
	
	System.out.println("districtList----" +districtList.size());
	%>
	<div id="localDistrictDiv">
 
		<label>District<span>*</span></label> 
		<select id="localDistrict" name="localDistrict" validate="District ,string,no">
			<option value="0">Select</option>
<%
				         		if(districtList.size()>0){ 	
				         			for (Iterator iter = districtList.iterator(); iter.hasNext();) {
				         				MasDistrict s = (MasDistrict) iter.next();
				         %>
			<option value="<%=s.getId() %>"><%=s.getDistrictName() %></option>
			<%		
				        			}
				        		 } else{
				        %>
			<option value="0">No Record</option>	        
				        <%} %>
				      
		</select> </div>
