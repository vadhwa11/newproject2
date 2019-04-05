<%@page import="java.util.*"%>  
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.pacs.controller.PacsPatientHistory"%> 
<%@page import="jkt.hms.util.Box"%>  
<%@page import="jkt.hms.masters.business.PacsTemplate"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>
<script type="text/javascript" src="/hms/jsp/js/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/wysiwyg-color.js"></script>
<script type="text/javascript" src="/hms/jsp/js/wysiwyg-settings.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>


<%--For AutoComplete Through Ajax--%>
<%@page import="javax.swing.text.StyledEditorKit.BoldAction"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<link rel="stylesheet" href="/hms/jsp/css/style.css" type="text/css" />
 
<script type="text/javascript">
 

WYSIWYG.attach('abc', full); // full featured setup
 
</script>
<% 
	Map map = new HashMap(); 
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<PacsTemplate> templateList = new ArrayList<PacsTemplate>();
	if(map.get("templateList") != null){
		templateList = (List<PacsTemplate>)map.get("templateList");
	} 
	 
	if(templateList.size()!=0){
%>
 
	<textarea value="" id="abc" name="abc" class="tableTextareaEditor"><%=templateList.get(0).getDescription() %></textarea>
	 	
<%} %>	 
 
