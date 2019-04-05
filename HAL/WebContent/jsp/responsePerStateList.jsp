

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

<script>
 var flag;
 </script>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<MasState> stateList = new ArrayList<MasState>();
	if(map.get("stateList")!=null){
		stateList=(List<MasState>)map.get("stateList");
	}
	
	
	%>
<div id="perStatetDiv">
 
		<label>State<span>*</span></label> 
		<select id="perState" name="perState" validate="State ,string,no"  onchange="submitProtoAjaxWithDivNameToShowStatus('employee','/hms/hms/personnel?method=getPerDistrictList','perDistrictDiv');"> 
			<option value="0">Select</option>
<%
				         		if(stateList.size()>0){ 	
				         			for (Iterator iter = stateList.iterator(); iter.hasNext();) {
				         				MasState s = (MasState) iter.next();
				         %>
			<option value="<%=s.getId()%>"><%=s.getStateName() %></option>
			<%		
				        			}
				        		 } else{
				        %>
			<option value="0">No Record</option>	        
				        <%} %>
				        
		</select>
		<div id="perDistrictDiv">
		<label> District <span>*</span></label> 
		<select name="perDistrict"			id="perDistrict" validate="Permanent District,string,yes"	tabindex="1">
			<option value="0">Select</option>
		
		</select>
		</div>
		 </div>
