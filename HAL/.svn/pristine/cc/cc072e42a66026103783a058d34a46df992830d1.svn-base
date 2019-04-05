<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<div id="contentHolder">
 <%
		Map<String, Object> map = new HashMap<String, Object>();
	 	List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("unitList") != null){
			unitList = (List<MasUnit>)map.get("unitList");
		}
		if(map.get("rankList") != null){
			rankList = (List<MasRank>)map.get("rankList");
		}
	%>

<form name="ameLmcReport" target="_blank" action="" method="post">
<div class="titleBg">
<h2>AME / LMC Report</h2>
</div>
<div class="Block">

	<label>Service No. :</label> 
	<input	type="text" id="serviceNo" name="<%=SERVICE_NO %>"	value="" MAXLENGTH="30" validate="Service No.,string,no"/>
	 
	<label>Rank :</label>
	<select id="rankId" name="<%=RANK_ID %>">
		<option value="0">Select</option>
		<%	for(MasRank masRank : rankList){  %>
		<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
		<%}%>
	</select>

	<label>Unit :</label> 
	<select id="unitId" name="<%=UNIT_ID %>">
		<option value="0">Select</option>
		<%		for(MasUnit masUnit : unitList){	%>
		<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
		<%}%>
	</select> 
	
	<label >AME:</label> 
	<input type="radio" id="ame" name="<%=AME_LMC %>" value="a"  class="radio" tabindex="1" checked="checked"/>
	<label >LMC:</label> 
	<input type="radio"	id="ame" name="<%=AME_LMC %>" value="l" class="radio" tabindex="1"/>
	<div class="Clear"></div>
	<div class="Clear"></div>
	<div class="bottom">
	<input type="button" name="OK" value="OK"	class="button"	onClick="if(checkBlankSearch()){submitForm('ameLmcReport','mis?method=printAmeLmc');}" />
	<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" /></div>
	</div>
</form>
<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=errorMsg+document.getElementById("serviceNo").value;
	if(document.getElementById("rankId").value !=0)
	errorMsg=errorMsg+document.getElementById("rankId").value;
	if(document.getElementById("unitId").value !=0)
	errorMsg=errorMsg+document.getElementById("unitId").value;
	if(errorMsg==""){
		alert("Please fill any one of value...!");
		return false
	}else{
		return true
	}
}
</script>