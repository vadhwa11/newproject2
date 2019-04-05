<%@page import="jkt.hms.masters.business.DgOrgGrpDtl"%>
<%@page import="java.util.*"%>
<!--main content placeholder starts here-->
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<%@page import="jkt.hms.masters.business.DgMasOrganism"%>
<%@page import="jkt.hms.masters.business.MasAntibioticLab"%>
<%@page import="jkt.hms.masters.business.DgMasOrganismGroup"%>
<%@page import="jkt.hms.masters.business.DgOrgDtl"%>
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
<%
Map map = new HashMap();
List<DgResultEntryDetailSen> dgResultEntryDetailSenList = new ArrayList<DgResultEntryDetailSen>();
List<DgMasOrganism> dgMasOrganismList = new ArrayList<DgMasOrganism>();
List<DgMasOrganismGroup> dgMasOrganismGroupList = new ArrayList<DgMasOrganismGroup>();
List<MasAntibioticLab> masAntibioticLabList = new ArrayList<MasAntibioticLab>();
List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
List<DgOrgGrpDtl> dgOrgGrpDtlList = new ArrayList<DgOrgGrpDtl>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
if(map.get("dgOrgDtlList") != null){
	
	dgOrgDtlList = (List<DgOrgDtl>)map.get("dgOrgDtlList");
}

if(map.get("dgOrgGrpDtlList") != null){
	dgOrgGrpDtlList = (List<DgOrgGrpDtl>)map.get("dgOrgGrpDtlList");
}
if(map.get("dgMasOrganismGroupList") != null){
	
	dgMasOrganismGroupList = (List<DgMasOrganismGroup>)map.get("dgMasOrganismGroupList");
}

if(map.get("masAntibioticLabList") != null){
	masAntibioticLabList = (List<MasAntibioticLab>)map.get("masAntibioticLabList");
}
if(map.get("dgMasOrganismList") != null){
	
	dgMasOrganismList = (List<DgMasOrganism>)map.get("dgMasOrganismList");
}

if(map.get("dgResultEntryDetailSenList") != null){
	dgResultEntryDetailSenList = (List<DgResultEntryDetailSen>)map.get("dgResultEntryDetailSenList");
}
List<Integer> organismGrpIds = new ArrayList<Integer>();
List<Integer> organismIds = new ArrayList<Integer>();
//List<Integer> antibioticsIds = new ArrayList<Integer>();
//List<String> results = new ArrayList<String>();
Map<String, String> antibioticResultMap = new Hashtable<String, String>();


for(DgResultEntryDetailSen dgResultEntryDetailSen : dgResultEntryDetailSenList){
	if(dgResultEntryDetailSen.getOrganismGroup() != null){
		organismGrpIds.add(dgResultEntryDetailSen.getOrganismGroup().getId());
		organismIds.add(dgResultEntryDetailSen.getOrganism().getId());
		antibioticResultMap.put(dgResultEntryDetailSen.getSensitivity().getId()
						+"@"+dgResultEntryDetailSen.getOrganism().getId()
						+"@"+dgResultEntryDetailSen.getOrganismGroup().getId()
				, dgResultEntryDetailSen.getResult());
		//antibioticsIds.add(dgResultEntryDetailSen.getSensitivity().getId());
		//results.add(dgResultEntryDetailSen.getResult());
	}

}
System.out.println("========  "+dgResultEntryDetailSenList.size());
%>
<!--  -->
<div id="growthDiv" style="display: block;">
<div class="Clear"></div>
<div
	style="width: 320px; height: 150px; float: left; border: 1px solid #3C8AD7;">
<div class="auto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Organism Group</th>
	</tr>
	<tr>
		<td><select name="organism" id="organismId" class="list"
			multiple="multiple" size="10" tabindex="1" onchange="fillOrganism();">
			<%for(DgMasOrganismGroup dgMasOrganismGroup : dgMasOrganismGroupList ){
			if(organismGrpIds.contains(dgMasOrganismGroup.getId())){%>
			<option value="<%=dgMasOrganismGroup.getId() %>" selected="selected"><%=dgMasOrganismGroup.getOrganismGroupName() %></option>
			<%  }else{ %>
			<option value="<%=dgMasOrganismGroup.getId() %>"><%=dgMasOrganismGroup.getOrganismGroupName() %></option>
			<%	}	
		} %>
		</select></td>
	</tr>
</table>
</div>
</div>

<div id="organismDiv">
<div
	style="width: 585px; border: 1px solid #3C8AD7; height: 150px; float: left; margin-left: 20px; display: inline; overflow: auto;">
<div class="auto">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th width="8%" scope="col">&nbsp;</th>
		<th colspan="2" scope="col">Organism</th>
	</tr>
	<%
    int srNo =1;
    int noOfOrg = 0;
    for(DgMasOrganism masOrganism : dgMasOrganismList){
    	if(organismIds.contains(masOrganism.getId())){
    		
    	 noOfOrg++;	 %>
	<tr>
		<td><%=srNo%></td>
		<td width="9%"><input type="checkbox" name="checkbox"
			checked="checked" id="chkBox<%=noOfOrg%>"
			value="<%=masOrganism.getId() %>" class="radio"
			onchange="fillSensitivity(this.value);" /></td>
		<td width="71%"><%=masOrganism.getOrganismName()%></td>
	</tr>
	<%
    	srNo++;
    	}
	} %>
</table>
<input id="noOfOrg" name="noOfOrg" type="hidden" value="<%=noOfOrg%>" />
</div>
</div>
</div>
<!--End of Organism Div-->
<div class="Clear"></div>
<div class="division"></div>


<div
	style="width: 585px; border: 1px solid #3C8AD7; height: 150px; float: left; margin-right: 20px; display: inline; overflow: auto;">
<div class="auto"><!--Start of Sensitivity Div-->
<div id="sensitivityDiv">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th width="7%" scope="col">&nbsp;</th>
		<th colspan="2" scope="col">Sensitivity</th>
		<th width="12%" scope="col">&nbsp;</th>
	</tr>
	<%
    srNo =1;
    int noOfSensitivity = 0;
    for(DgOrgDtl dgOrgDtl : dgOrgDtlList){
    	if(antibioticResultMap.containsKey(dgOrgDtl.getAntibioticLab().getId()
    							+"@"+dgOrgDtl.getOrganism().getId()
    							+"@"+dgOrgDtl.getOrganismGroup().getId()
    							)
    		&& organismIds.contains(dgOrgDtl.getOrganism().getId()) 
    		&& organismGrpIds.contains(dgOrgDtl.getOrganismGroup().getId()) ){
    		
    		noOfSensitivity++;
    	String result = antibioticResultMap.get(dgOrgDtl.getAntibioticLab().getId()
    												+"@"+dgOrgDtl.getOrganism().getId()
    												+"@"+dgOrgDtl.getOrganismGroup().getId()
    												);
    	
    	%>
	<tr>
		<td><%=srNo%></td>
		<td width="9%"><input type="checkbox"
			name="chkBoxSensitive<%=srNo%>" checked="checked"
			id="chkBoxSensitive<%=srNo%>"
			value="<%=dgOrgDtl.getAntibioticLab().getId()%>@<%=dgOrgDtl.getOrganism().getId()%>@<%=dgOrgDtl.getOrganismGroup().getId()%>"
			class="radio" /></td>
		<td width="72%"><%=dgOrgDtl.getAntibioticLab().getAntibioticLabName()%></td>

		<td><select name="res<%=srNo%>" id="res<%=srNo%>">
			<% 
		  System.out.println("Result :"+result);
		  
		  if(result.equals("SENSITIVE")){%>
			<option value="SENSITIVE" selected="selected">SENSITIVE</option>
			<option value="NON-SENSITIVE">RESISTANT</option>
			<option value="MS">MS</option>
			<option value="NOT APPLICABLE">NO RESULT</option>
			<%}
		  if(result.equals("NON-SENSITIVE")){%>
			<option value="SENSITIVE">SENSITIVE</option>
			<option value="NON-SENSITIVE" selected="selected">RESISTANT</option>
			<option value="MS">MS</option>
			<option value="NOT APPLICABLE">NO RESULT</option>
			<%}
		  if(result.equals("MS")){%>
			<option value="SENSITIVE">SENSITIVE</option>
			<option value="NON-SENSITIVE">RESISTANT</option>
			<option value="MS" selected="selected">MS</option>
			<option value="NOT APPLICABLE">NO RESULT</option>
			<%} %>
			<%if(result.equalsIgnoreCase("NOT APPLICABLE")){ %>
			<option value="SENSITIVE">SENSITIVE</option>
			<option value="NON-SENSITIVE">RESISTANT</option>
			<option value="MS">MS</option>
			<option value="NOT APPLICABLE" selected="selected">NO RESULT</option>
			<%} %>

		</select></td>
	</tr>
	<%
    	srNo++;
    	}
	} %>
</table>
<input id="noOfSensitivity" name="noOfSensitivity" type="hidden"
	value="<%=noOfSensitivity%>" /></div>
<!--End of Organism Div--></div>
</div>
</div>
<!--  -->

<script type="text/javascript">
function getSelect(index)
{
 if(document.getElementById('sensitivityResult'+index).disabled==true)
 {
 	document.getElementById('sensitivityResult'+index).disabled=false;
 }
 if(document.getElementById('antibioId'+index).checked==true){
 	//alert("Please select the result for senitivity");
 }
}
function fillOrganism(){
  var orGroupId ="";
   var x=document.getElementById("organismId")
	for (var i=0; i<x.options.length-1;i++) {
		if (x.options[i].selected) {
			orGroupId=orGroupId+x.options[i].value+"."
		}
	}
	 //----------------------AJAX PART------------Start------
  
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
    xmlHttp.onreadystatechange=function()
    {
    if (xmlHttp.readyState>0 && xmlHttp.readyState<4){
      document.getElementById("organismDiv").innerHTML='<font id="error">Loading...</font>'
      document.getElementById("sensitivityDiv").innerHTML='<table width="100%" border="0" cellspacing="0" cellpadding="0"><tr><th width="7%" scope="col">&nbsp;</th><th colspan="2" scope="col">Sensitivity</th><th width="12%" scope="col">&nbsp;</th></tr><tr><td>&nbsp;</td><td width="9%">&nbsp;</td><td width="72%">&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></table>';
    }else
      if(xmlHttp.readyState==4){
         document.getElementById("organismDiv").innerHTML = xmlHttp.responseText;
      }
    }
     
    xmlHttp.open("GET","/hms/hms/investigation?method=getOrganismList&orGroupId="+orGroupId,true);
    
    xmlHttp.send(null);
//----------------------AJAX PART------------End------

}
function fillSensitivity(val){
var noOfOrg=document.getElementById("noOfOrg").value
 var x=document.getElementById("organismId")
 var orIds="";

	for (var i=1; i<=noOfOrg;i++) {

		if (document.getElementById(("chkBox"+i)).checked) {
			orIds=orIds+document.getElementById(("chkBox"+i)).value+"."
		}
	}
 //----------------------AJAX PART------------Start------
  
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
    xmlHttp.onreadystatechange=function()
    {
    if (xmlHttp.readyState>0 && xmlHttp.readyState<4){
     document.getElementById("sensitivityDiv").innerHTML='<font id="error">Loading...</font>'
    }else
      if(xmlHttp.readyState==4){
         document.getElementById("sensitivityDiv").innerHTML = xmlHttp.responseText;
      }
    }
     
    xmlHttp.open("GET","/hms/hms/investigation?method=getSensitivityList&orIds="+orIds,true);
    
    xmlHttp.send(null);
//----------------------AJAX PART------------End------
}

</script>
