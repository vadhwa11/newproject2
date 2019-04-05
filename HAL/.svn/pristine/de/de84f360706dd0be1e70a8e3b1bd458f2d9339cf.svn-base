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
<%@ page import="jkt.hms.masters.business.DgMasOrganism"%>
<%@ page import="jkt.hms.masters.business.DgMasOrganismGroup"%>
<%@ page import="jkt.hms.masters.business.DgOrgGrpDtl"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<DgMasOrganismGroup> organismGroupList = new ArrayList<DgMasOrganismGroup>();
	List<DgMasOrganism> organismList = new ArrayList<DgMasOrganism>();
	List<DgOrgGrpDtl> organismGroupDetailList  = new ArrayList<DgOrgGrpDtl>();
	
	organismList = (ArrayList)map.get("organismList");
	organismGroupList = (ArrayList)map.get("organismGroupList");
	Integer organismGroupId = 0;
	
	if(map.get("organismGroupDetailList") != null){
		organismGroupDetailList = (List)map.get("organismGroupDetailList");		
	}
	if(map.get("organismGroupId") != null && !map.get("organismGroupId").equals("")){
		organismGroupId = Integer.parseInt((String)map.get("organismGroupId"));		
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

%>
<div id="contentHolder">
<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %> <h4><%=message %></h4> <% 
	  }
%>

<div class="titleBg"><h2>Organism Group Detail</h2></div>
<div class="Clear"></div>
  <form name="orgGroupDetail" method="post" action="">
 	<div class="Block">
 		<input type="hidden" name="organismGroupIdToShowSelected" value="<%=organismGroupId%>" id="organismGroupIdToShowSelected"/>
 		<label>Organism Group <span>*</span> </label>
		<select name="<%= ORGANISM_GROUP_ID %>" class="large2" id="<%=ORGANISM_GROUP_ID%>" validate="Organism Group,string,yes" tabindex=1 >
		<option value="">Select</option>
			  <% 
				for (DgMasOrganismGroup  organismGroup : organismGroupList){
				%>
			  		<option value="<%=organismGroup.getId()%>" onclick="showOrgForSelectedOrgGrpAjax(this);"><%=organismGroup.getOrganismGroupName()%></option>
			  <%}%>
			</select>
			
			
		<script type="text/javascript">
			var organismGroupId = document.getElementById('organismGroupIdToShowSelected').value;
			if(organismGroupId != '0'){
				document.getElementById('<%=ORGANISM_GROUP_ID%>').value = organismGroupId; 
			}
		</script>
		</div>
		<div class="Clear"></div>
		<div id="orgDtlView">
			<input type="hidden" name="totalRowsCount" value="0" id="totalRowsCount"/>
		</div>
		
		<div class="Clear"></div>
		<div class="division"></div>
<div id="edited"></div>
			<input type="button" name="submitForDisable" id="submitForDisable" value="Submit" class="button" 
			  onclick="if(checkFilledRow()){submitFormToDisableSubmit('orgGroupDetail','laboratory?method=editOrganismGroupDetail');}"
			 accesskey="a" tabindex="1"/>

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
		
	<!-- 		<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('orgGroupDetail','laboratory?method=editOrganismGroupDetail')" tabindex=1 />
			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('orgGroupDetail','laboratory?method=deleteOrganismGroupDetail&flag='+this.value)" accesskey="d" tabindex=1/>		
 -->		
			
	</form>		
	</div>

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
				document.getElementById('<%=ORGANISM_NAME%>'+inc).value="";
			    return;
			}
			for(i=1;i<inc;i++){
				if(inc != 1){
					if(document.getElementById('<%=ORGANISM_NAME%>'+i).value==val) {
						alert("Organism name already selected...!");
						document.getElementById('<%=ORGANISM_NAME%>'+inc).value="";
						var e = eval(document.getElementById('<%=ORGANISM_NAME%>'+(inc))); 
						//document.getElementById('<%=ORGANISM_NAME%>'+inc).focus();
						e.focus();
						return false;
					} 
				}
			}
		}else{
			document.getElementById('<%=ORGANISM_NAME%>'+inc).value = "";
		}
}
function checkFilledRow(){
	var msg ="";
	if(checkForWrongOrganismName()){
		var rowCounter = 1;
		var filledFlag = false;
		var totalRecord = document.getElementById('totalRowsCount').value;
		while(rowCounter <= totalRecord){
			if(document.getElementById('<%=ORGANISM_NAME%>'+ rowCounter).value != ''){
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
		var tempOrganism = document.getElementById('<%=ORGANISM_NAME%>'+ c).value;
		if(tempOrganism != ''){
			var index1 = tempOrganism.lastIndexOf("[");
			var index2 = tempOrganism.lastIndexOf("]");
			var tempParseOrganismId = tempOrganism.substring(index1,index2);
			if(tempParseOrganismId == ""){
				alert('Organism Name ' + document.getElementById('<%=ORGANISM_NAME%>'+ c).value + ' is incorrect.' );
				document.getElementById('<%=ORGANISM_NAME%>'+ c).value = '';
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
									document.getElementById('<%=ORGANISM_NAME%>'+iteration).value="";
								    return;
								}
								for(i=1;i<iteration;i++){
									if(iteration != 1){
										if(document.getElementById('<%=ORGANISM_NAME%>'+i).value==val) {
											alert("Organism name already selected...!")
											document.getElementById('<%=ORGANISM_NAME%>'+iteration).value=""
											var e = eval(document.getElementById('<%=ORGANISM_NAME%>'+iteration)); 
											e.focus();
											return false;
										} 
									}
								}
							}else{
								document.getElementById('<%=ORGANISM_NAME%>'+iteration).value = "";
							}
	  					  };
	  organismNameToAdd.name = '<%=ORGANISM_NAME%>' + iteration;
	  organismNameToAdd.id = '<%=ORGANISM_NAME%>' + iteration;
	 
	  organismNameToAdd.size = '180';
	 // organismNameToAdd.style.width ="100%";
	  organismNameToAdd.setAttribute('tabindex','1');	 
	  cellOrganismName.appendChild(organismNameToAdd);

	  new Ajax.Autocompleter('<%=ORGANISM_NAME%>'+iteration,'ac2update','laboratory?method=getOrganismListAutoComplete',{parameters:'requiredField=<%=ORGANISM_NAME%>'+iteration});
 }
 function showOrganismForSelectedOrgGrp(){
 	var orgGrpObj = document.getElementById('<%=ORGANISM_GROUP_ID%>');
 	if(orgGrpObj.value == ''){
 		alert('Please select any organism group.');
 		return false;
 	}
 	orgGrpObj.setAttribute('validate','Organism Group,string,no'); 
 	submitForm('orgGroupDetail','laboratory?method=searchOrganismGroupDetail')
 }
 function showOrgForSelectedOrgGrpAjax(orgGrpObj){
 	if(checkId(orgGrpObj.value)){
		submitProtoAjaxWithDivNameToShowStatus('orgGroupDetail','laboratory?method=searchOrganismGroupDetailAjax','orgDtlView')
	}
 }
 function checkId(Id){
	if(Id=="0"){
    	return false;
    }else{ 
      	return true;
    }
 }
 
</script>
