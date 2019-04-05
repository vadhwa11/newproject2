<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * department.jsp  
 * Purpose of the JSP -  This is for Department details 
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.DgOrgDtl"%>
<%@page import="jkt.hms.masters.business.MasAntibioticLab"%>
<%@page import="jkt.hms.masters.business.DgMasOrganism"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%
	Map map = new HashMap();
	int organismId = 0;
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<DgOrgDtl> organismDetailList = new ArrayList<DgOrgDtl>();
	List<DgMasOrganism> organismList = new ArrayList<DgMasOrganism>();
	
	organismList = (ArrayList)map.get("organismList");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
		if(map.get("organismId") != null && !map.get("organismId").equals("")){
		organismId = Integer.parseInt((String)map.get("organismId"));		
	}
	if(map.get("organismDetailList") != null && !map.get("organismDetailList").equals("")){
		organismDetailList = (List)map.get("organismDetailList");		
	}
%>

<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %> <h4><%=message %></h4> <% 
	  }
%>
<div class="titleBg"><h2>Organism Detail</h2></div>
<div class="Clear"></div>
  <form name="orgDetail" method="post" action="">
  
 	<div class="Block">
 		<input type="hidden" name="organismIdToShowSelected" value="<%=organismId%>" id="organismIdToShowSelected"/>
		<label> Organism <span>*</span></label>
		<select name="<%= ORGANISM_ID %>" id="<%= ORGANISM_ID %>" class="large2" validate="Organism,string,yes" tabindex="1">
			<option onclick="" value="">Select</option>
			  <% for (DgMasOrganism  dgMasOrganism : organismList){ %>
			  	<option onclick="showOrgGrpForSelectedOrgAjax(this);" value="<%=dgMasOrganism.getId ()%>"><%=dgMasOrganism.getOrganismName()%></option>
			  <%}%>
		</select>
		
		<script type="text/javascript">
			var organismId = document.getElementById('organismIdToShowSelected').value;
			if(organismId != '0'){
				document.getElementById('<%=ORGANISM_ID%>').value = organismId; 
			}
		</script>
	
		<div id="orgGrpListView">
			<label> Organism Group <span>*</span></label>
			<select name="<%=ORGANISM_GROUP_ID%>" id="<%=ORGANISM_GROUP_ID%>"   validate="Organism Group,string,yes" tabindex="1">
				<option onclick="" value="">Select</option>
			</select>
			</div>
		</div>
	
<div class="Clear"></div>

	<!-- <input	type="button" name="searchOrganismForSelectedOrgGrp" id="searchOrganismForSelectedOrgGrp" 
			value="Go" class="cmnButton"  
			style="width: 20px;margin-left: 2px;" onclick="showSensitivityForSelectedOrg();" tabindex=1 /> -->
	
<div class="Clear"></div>
<div id="sensitivityListView">
			<input type="hidden" name="totalRowsCount" value="0" id="totalRowsCount"/>
		
		</div>
			
		<div class="Clear"></div>		
	<div class="Clear"></div>
	<div class="division"></div>	
<div id="edited"></div>
			<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="if(checkFilledRow()){submitFormToDisableSubmit('orgDetail','laboratory?method=editOrganismDetail');}" accesskey="a" tabindex=1/>
<!-- 			<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('orgDetail','laboratory?method=editOrganismDetail')" accesskey="u" tabindex=1 /> -->
<!-- 			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('orgDetail','laboratory?method=deleteOrganismDetail&flag='+this.value)" accesskey="d" tabindex=1/>		
			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />  -->
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />			
			<div class="Clear"></div>
		<div class="division"></div>
			<div class="bottom">
			<label >Changed By:</label>   
			<label class="value"><%=userName%></label>
			        
			<label >Changed Date:</label>   
			<label class="value"><%=date%></label>
			 
			<label >Changed Time:</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
   </div>
	<div class="Clear"></div>

	</form>
	<script type="text/javascript">
	function checkForOrganism(val,inc){
		if(val != "") {
			var index1 = val.lastIndexOf("[");
			var indexForOrganism = index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var organismId = val.substring(index1,index2);
			var indexForOrganism = indexForOrganism--;
			var organismName = val.substring(0,indexForOrganism);
			if(organismId == "" ) {
				document.getElementById('<%=ANTIBIOTIC_NAME%>'+inc).value="";
			    return;
			}
			for(i=1;i<inc;i++){
				if(inc != 1){
					if(document.getElementById('<%=ANTIBIOTIC_NAME%>'+i).value==val) {
						alert("Sensitivity name already selected...!")
						document.getElementById('<%=ANTIBIOTIC_NAME%>'+inc).value=""
						var e = eval(document.getElementById('<%=ANTIBIOTIC_NAME%>'+inc)); 
						e.focus();
						return false;
					} 
				}
			}
		}else{
			document.getElementById('<%=ANTIBIOTIC_NAME%>'+inc).value = "";
		}
}
function checkFilledRow(){
	var msg ="";
	if(checkForWrongOrganismName()){
		var rowCounter = 1;
		var filledFlag = false;
		var totalRecord = document.getElementById('totalRowsCount').value;
		while(rowCounter <= totalRecord){
			if(document.getElementById('<%=ANTIBIOTIC_NAME%>'+ rowCounter).value != ''){
				filledFlag = true;
				break;
			}
			rowCounter++;
		}
		if(filledFlag == true){
			return true;
		}else{
			alert("Please fill atleast one row to submit.");
			return false;
		}
	}
}
function checkForWrongOrganismName(){
	var c = 1;
	var totalRecord = document.getElementById('totalRowsCount').value;
	while(c <= totalRecord){
		var tempOrganism = document.getElementById('<%=ANTIBIOTIC_NAME%>'+ c).value;
		if(tempOrganism != ''){
			var index1 = tempOrganism.lastIndexOf("[");
			var index2 = tempOrganism.lastIndexOf("]");
			var tempParseOrganismId = tempOrganism.substring(index1,index2);
			if(tempParseOrganismId == ""){
				alert('Sensitivity Name ' + document.getElementById('<%=ANTIBIOTIC_NAME%>'+ c).value + ' is incorrect.' );
				document.getElementById('<%=ANTIBIOTIC_NAME%>'+ c).value = '';
				return false;
			}
		}
		c++;
	}
	return true;
}
	function addRow(){
		var tbl = document.getElementById('organismGrid');
	  	var lastRow = tbl.rows.length;
		// if there's no header row in the table, then iteration = lastRow + 1
	  	var iteration = lastRow;
	  	var row = tbl.insertRow(lastRow);
	  	var totalRowsCount = document.getElementById('totalRowsCount');
	  	totalRowsCount.value=iteration
	  	
	  	var cellSrNo = row.insertCell(0);
	  	var srNo = document.createElement('input');
	  	srNo.type = 'text';
	  	srNo.name = '<%=SR_NO%>';
	  	srNo.id = '<%=SR_NO%>'+iteration;
	  	srNo.size = '2';
	  	srNo.value = iteration;
	  	cellSrNo.appendChild(srNo);
	  
	  	var cellOrganismName = row.insertCell(1);
	  	var organismNameToAdd = document.createElement('input');
	  	organismNameToAdd.type = 'text';

	  	organismNameToAdd.onblur=function(){
	                       var val=organismNameToAdd.value
						   if(val != "") {
								var index1 = val.lastIndexOf("[");
								var indexForOrganism = index1;
								var index2 = val.lastIndexOf("]");
								index1++;
								var organismId = val.substring(index1,index2);
								var indexForOrganism = indexForOrganism--;
								var organismName = val.substring(0,indexForOrganism);
								if(organismId == "" ) {
									document.getElementById('<%=ANTIBIOTIC_NAME%>'+iteration).value="";
								    return;
								}
								for(i=1;i<iteration;i++){
									if(iteration != 1){
										if(document.getElementById('<%=ANTIBIOTIC_NAME%>'+i).value==val) {
											alert("Sensitivity name already selected...!")
											document.getElementById('<%=ANTIBIOTIC_NAME%>'+iteration).value=""
											var e = eval(document.getElementById('<%=ANTIBIOTIC_NAME%>'+iteration)); 
											e.focus();
											return false;
										} 
									}
								}
							}else{
								document.getElementById('<%=ANTIBIOTIC_NAME%>'+iteration).value = "";
							}
	  					  };
	  organismNameToAdd.name = '<%=ANTIBIOTIC_NAME%>' + iteration;
	  organismNameToAdd.id = '<%=ANTIBIOTIC_NAME%>' + iteration;
	 
	  organismNameToAdd.size = '180';
	  //organismNameToAdd.style.width ="100%";
	  organismNameToAdd.setAttribute('tabindex','1');	 
	  cellOrganismName.appendChild(organismNameToAdd);

	  new Ajax.Autocompleter('<%=ANTIBIOTIC_NAME%>'+iteration,'ac2update','laboratory?method=getSensitivityListAutoComplete',{parameters:'requiredField=<%=ANTIBIOTIC_NAME%>'+iteration});
 }
 function showSensitivityForSelectedOrg(){
 	var orgObj = document.getElementById('<%=ORGANISM_ID%>');
 	if(orgObj.value == ''){
 		alert('Please select any organism.');
 		return false;
 	}
 	orgObj.setAttribute('validate','Organism,string,no'); 
 	submitForm('orgDetail','laboratory?method=searchOrganismDetail')
 }
 function  showOrgGrpForSelectedOrgAjax(obj) {
		if(checkId(obj.value)){
			submitProtoAjaxWithDivNameToShowStatus('orgDetail','laboratory?method=searchOrganismDetailAjax','orgGrpListView');
		}
	}
 
 function checkId(Id){
	if(Id=="0"){
    	return false;
    }else{ 
      	return true;
    }
 }
 function  showSensitivityForSelectedOrgGrpAjax(obj) {
		if(checkId(obj.value)){
			submitProtoAjaxWithDivNameToShowStatus('orgDetail','laboratory?method=searchSensitivityDetailAjax','sensitivityListView');
		}
	}
 
 function checkOrgGrpId(Id){
	if(Id=="0"){
    	return false;
    }else{ 
      	return true;
    }
 }
 
</script>  