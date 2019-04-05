
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=showDrugListBodySystemWiseReportJsp";
  obj.submit();
  }
</script>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasStoreSection> searchMasStoreSectionList = new ArrayList<MasStoreSection>();
	if(map.get("searchMasStoreSectionList")!=null)
		searchMasStoreSectionList = (List) map.get("searchMasStoreSectionList");
	
%>
<form name="drugListBodySystemWise" method="post" action="">
<div class="titleBg">
<h2>Drugs List Body System Wise</h2>
</div>
<div class="Block">
<label ><span>*</span> Pharma Index </label>
<select name="<%=SECTION_ID%>" validate="Pharma Index,String,yes">
<option value=0>Select</option>
	<%
				for (MasStoreSection masStoreItem :searchMasStoreSectionList ) {
				%>

<option value=<%=masStoreItem.getId()%>><%=masStoreItem.getSectionName()%>
</option>
	<%	}	%>
</select> 
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add"	id="addbutton" value="Ok" class="button" onClick="submitForm('drugListBodySystemWise','stores?method=generateDrugListBodySystemWiseReport');" accesskey="a" tabindex=1 /> 
	
<input type="button" name="clear" id="clearbutton" value="Cancel" class="button" onClick="clearButton('drugListBodySystemWise');" accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>





