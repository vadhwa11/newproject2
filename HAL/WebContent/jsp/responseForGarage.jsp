
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<%	
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map<String,Object>) request.getAttribute("map");
		}
	
		String garageNo="";
		if(map.get("garageNo") != null){
			garageNo = (String)map.get("garageNo");
		}
		int inc = 0; 
		if(map.get("inc") != null){
			inc = (Integer)map.get("inc");
		}
%>
<div id="sampleDiv<%=inc %>"><input id="<%=GARAGE_NAME%><%=inc%>"
	type=text name="<%=GARAGE_NAME %>" value="<%=garageNo %>" size="5"
	tabindex=1 readonly="readonly" /></div>