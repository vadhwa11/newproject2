
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
		Map map = new HashMap();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
	
		String sampleSeqNo="";
		if(map.get("sampleSeqNo") != null){
			sampleSeqNo = (String)map.get("sampleSeqNo");
		}
		int inc = 0; 
		if(map.get("inc") != null){
			inc = (Integer)map.get("inc");
		}
%>
<div id="sampleDiv<%=inc %>"><input id="sampleNoId<%=inc%>"
	type=text name="<%=SAMPLE_NO %>" value="<%=sampleSeqNo %>" size="5"
	title="Sample No." tabindex=1 readonly="readonly" /></div>