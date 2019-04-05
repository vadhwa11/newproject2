
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreTenderT"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/tender?method=showTenderForPVMSNIVReportJsp";
  obj.submit();
  }
</script>

<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	
	

	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<StoreTenderT> itemList = new ArrayList<StoreTenderT>();
	if(map.get("itemList") != null){
		itemList = (List<StoreTenderT>)map.get("itemList");
	}
%>
<div id="contentspace">
<form name="tenderForPvmsNiv" method="post" action=""><br />
<br />
<div class="panelbar">
<div class="paneltext">Tender For Pvms/Niv Report</div>
</div>
<br />

<label class="bodytextB1"><font id="error">*</font>Nomenclature:</label>
<input type="text" value="" id="pvmsNo" class="bigcaption"
	validate="Nomenclature,String,yes" name="<%=NOMENCLATURE%>" />
<div id="ac2update"
	style="display: none; padding-right: 550px; background-color: white;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=NOMENCLATURE%>','ac2update','tender?method=getItemListForTenderForNomenclatureByAutocomplete',{parameters:'requiredField=<%=NOMENCLATURE%>'});
		</script> <br />


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" name="add"
	id="addbutton" value="Ok" class="button"
	onClick="submitForm('tenderForPvmsNiv','tender?method=generateTenderForNomenclatureReport','check()');"
	accesskey="a" tabindex=1 /> <input type="button" name="clear"
	id="clearbutton" value="Clear" class="button"
	onClick="clearButton('tenderForPvmsNiv');" accesskey="a" tabindex=1 />

</form>

</div>






