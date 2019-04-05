
<%@page import="jkt.hms.masters.business.MasBed"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.io.IOException"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.HashMap"%>


<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHEQUE_DATE "%>
<%@ page import="static jkt.hms.util.RequestConstants.CHEQUE_NO "%>
<%@ page import="static jkt.hms.util.RequestConstants.BANK_NAME "%>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	int val=0;
	if(map.get("val")!=null){
		val=(Integer)map.get("val");
	}
	List<MasBed>bedList=new ArrayList<MasBed>();
	if(map.get("bedList")!=null){
		bedList=(List<MasBed>)map.get("bedList");
	}
	int occupied=0;
	int vacant=0;
	
for(MasBed bed:bedList){
	if(bed.getBedStatus().getId()==5){
		occupied++;
	}else if(bed.getBedStatus().getId()==6){
		vacant++;
	}
	
}
	%>
<div class="clear"></div>
<label>Occupied Bed &nbsp;&nbsp;&nbsp;&nbsp;<%=occupied %></label>
<label>Vacant Bed &nbsp;&nbsp;&nbsp;&nbsp;<%=vacant %></label>
