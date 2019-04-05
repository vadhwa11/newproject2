<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<%
Map<String, Object> map = new HashMap<String, Object>();
List<StoreInternalIndentM> searchStoreInternalIndentMList = new ArrayList<StoreInternalIndentM>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}

if(map.get("searchStoreInternalIndentMList")!= null){
	searchStoreInternalIndentMList = (List<StoreInternalIndentM>)map.get("searchStoreInternalIndentMList");
}
String message="";
if(map.get("message")!= null){
	message = (String)map.get("message");
	//System.out.println("message ---- "+message);
}
int deptId = 0;
if(session.getAttribute("deptId") != null)
{
	deptId = Integer.parseInt(""+session.getAttribute("deptId"));
}
%>
<form name="searchDeptIndent" method="post">
<h4><%=message %></h4>
<div class="titleBg"><h2>Indent to Dispensary</h2></div>
<div class="Clear"></div>

<div class="Block">


<label class="auto">Add Items To Existing Indent</label>
<input type="radio" name="indentType" id="indentType" value="old" class="radioAuto" checked="checked" onclick="displayField(this.value);"/>

<div id="dmdNoDiv" >
<label> Indent No. </label>
<select id="demandNo" name="<%=DEMAND_NO%>">

	<%
		for (StoreInternalIndentM mObj :searchStoreInternalIndentMList ) {
	%>
	<option value=<%=mObj.getId()%>><%=mObj.getDemandNo()%></option>
	<%
		}
	%>
</select>
<input type="hidden" name="<%=FROM_WARD %>" value="<%=deptId%>" />
</div>
<label>Create New Indent</label>
<input type="radio" name="indentType" id="indentType" value="new" class="radioAuto" onclick="displayField(this.value);" />
<div class="Clear"></div>

</div>
<div class="Clear"></div>
<div class="division"></div>
<input name="Button2" type="button" class="buttonSm" value="Ok" onclick="checkIndentType()"/>
<div class="Clear"></div>
<div class="division"></div>
<script type="text/javascript">
function checkIndentType(){
	for(var i = 0; i < document.getElementsByName('indentType').length; i++){
  		if(document.getElementsByName('indentType')[i].checked == true)
           {
  			if(document.getElementsByName('indentType')[i].value == "new"){
  				submitForm('searchDeptIndent','/hms/hms/stores?method=showDepartmentIndentToDisensaryJsp');
  			}else{
  	  			var demandNo = document.getElementById('demandNo').value;
  				submitForm('searchDeptIndent','stores?method=getDepartmentIndentData&<%=DEMAND_NO%>='+demandNo);
  			}
           }
	}

}
function displayField(val){
	if(val == "old"){
		document.getElementById('dmdNoDiv').style.display = 'inline';
	}else if(val == "new"){
		document.getElementById('dmdNoDiv').style.display = 'none';
	}
}

</script>
</form>