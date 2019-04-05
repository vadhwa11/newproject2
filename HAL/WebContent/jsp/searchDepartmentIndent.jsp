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
List<StoreInternalIndentM> searchStoreInternalIndentMExistList = new ArrayList<StoreInternalIndentM>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}

if(map.get("searchStoreInternalIndentMList")!= null){
	searchStoreInternalIndentMList = (List<StoreInternalIndentM>)map.get("searchStoreInternalIndentMList");
}

if(map.get("searchStoreInternalIndentMExistList")!= null){
	searchStoreInternalIndentMExistList = (List<StoreInternalIndentM>)map.get("searchStoreInternalIndentMExistList");
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
<div class="titleBg"><h2>Material Requisition To Stores</h2></div>
<div class="Clear"></div>

<div class="Block">


<!--  
<label class="auto">Add Items To Existing Indent</label>

<label class="auto"> Import Previous Indent </label>-->
<input type="hidden" name="indentType" id="indentType" value="old" class="radioAuto"  onclick="displayField(this.value);"/>

<div id="dmdNoDiv" >
<!--<label> Indent No. </label>--->
<!--<select id="demandNo" name="<%=DEMAND_NO%>" >-->

	<%
		for (StoreInternalIndentM mObj :searchStoreInternalIndentMList ) {
	%>
	<!--<option value=<%=mObj.getId()%>><%=mObj.getDemandNo()%></option>--->
	<%
		}
	%>
<!--</select>--->
<input type="hidden" name="<%=FROM_WARD %>" value="<%=deptId%>" />

</div>
<label>Create New MR</label>
<input type="radio" name="indentType" id="indentType" value="new" class="radioAuto" onclick="displayField(this.value);" />

<!-- add by javed khan  -->

<label class="auto">Add Items to Existing MR</label>
<input type="radio" name="indentType" id="indentType" value="exist" class="radioAuto" checked="checked" onclick="displayField(this.value);" />
<input type="hidden" name="existingIndentSize" id="existingIndentSize" value="<%=searchStoreInternalIndentMExistList.size()%>" />
<%if(searchStoreInternalIndentMExistList.size()> 0){ %>
<input type="hidden" name="existingIndent" id="existingIndent"  value="<%=searchStoreInternalIndentMExistList.get(0).getId()%>" />
<%} %>
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
  				if(document.getElementById('existingIndentSize').value>0 ){
   	  	  		   alert("Please first submit existing indent.")
   	  			}else{
  				submitForm('searchDeptIndent','/hms/hms/stores?method=showDepartmentIndentJsp');
   	  			}
  			}else if(document.getElementsByName('indentType')[i].value == "old") {
  	  			var demandNo = document.getElementById('demandNo').value;
  	  			if(demandNo != ""){
  	  			if(document.getElementById('existingIndentSize').value>0 ){
    	  	  		   alert("Please first submit existing indent.")
    	  			}else{
  				submitForm('searchDeptIndent','stores?method=getDepartmentIndentData&<%=DEMAND_NO%>='+demandNo);
    	  			}
  	  			}else{

					alert("Please select indent no.");
  	  	  			}
  			}
  			else{
  				var existingIndent= document.getElementById('existingIndentSize').value ;
  				//alert("-- "+existingIndent);
  				if(existingIndent >0){
  					var demandNo= document.getElementById('existingIndent').value ;
  				submitForm('searchDeptIndent','stores?method=getDepartmentIndentData&<%=DEMAND_NO%>='+demandNo);
  				}
  				else{
  					alert("There is no existing  MR.");
  	  				
  				}
           }
	}

}
	}
function displayField(val){
	if(val == "old"){
		document.getElementById('dmdNoDiv').style.display = 'inline';
	}else if(val == "new"){
		document.getElementById('dmdNoDiv').style.display = 'none';
	}else if(val == "exist"){
		document.getElementById('dmdNoDiv').style.display = 'inline';
	}
}

</script>
</form>