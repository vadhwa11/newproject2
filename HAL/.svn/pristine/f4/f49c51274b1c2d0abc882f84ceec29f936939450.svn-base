<%@ page import = "static jkt.hms.util.RequestConstants.*" %>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasDiet"%>
<%@page import="jkt.hms.masters.business.MasDietType"%>
<%@page import="jkt.hms.masters.business.MasDietCombination"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DietDetails"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<div id="contentHolder">
<form name="dietChange" method="post" action="">
	         
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<DietDetails> dietDetailsList = new ArrayList<DietDetails>();
	List<MasDiet> dietList = new ArrayList<MasDiet>();
	List<MasDietType> dietTypeList = new ArrayList<MasDietType>();
	List<MasDietCombination> dietCombinationList = new ArrayList<MasDietCombination>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("dietDetailsList") != null){
		dietDetailsList = (List<DietDetails>)map.get("dietDetailsList");
	}
	if(map.get("dietList") != null){
		dietList = (List<MasDiet>)map.get("dietList");
	}
	if(map.get("dietTypeList") != null){
		dietTypeList = (List<MasDietType>)map.get("dietTypeList");
	}
	if(map.get("dietCombinationList") != null){
		dietCombinationList = (List<MasDietCombination>)map.get("dietCombinationList");
	}
	String deptName="";
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

%>
	        
	         
<!--Block One Starts-->
<div class="Clear"></div>
	 	
<h6>Patient Diet Change</h6><h4><%=deptName %></h4>

<div class="blockFrame">
<div class="Clear"></div>
  			<label>Service No.</label>
			<input type="text" id="serviceNo" name="<%=SERVICE_NO%>" value="" size="10" MAXLENGTH="30"/>		
			<label class="medium"> Hin:</label>
			<input type="text" name="<%=HIN_NO%>" value="" MAXLENGTH="30" size="10"/>
			<label> Admission No:</label>
			<input type="text" name="<%=AD_NO%>" value="" MAXLENGTH="30" size="10"/>
     <input name="search" type="button" value="Search" class="cmnButton" onclick="submitForm('dietChange','diet?method=searchDietDetails');" />
</div>
	 <div class="Clear"></div>

<%
if(dietDetailsList.size() > 0 ){
%>
<div class="tableHolderAuto">
    <table width="100%" border="0" cellpadding="0" cellspacing="0" id="chargeDetails" colspan="7">
      <tr> 
       <th> </th>
	  <th >SR No</th>
	  <th width="18%" >Service No</th>
	   <th width="10%" >Relation</th>
      <th width="22%" >S.Person Name</th>
      <th width="18%" >Admission No</th>
      <th width="18%" >Diet Name</th>
      <th width="18%" >Therapeutic Diet</th>
      <th width="18%" >Diet Type</th>
      <th width="10%" >Walking/Bed Patient</th>
   	    </tr>
     	<%
     			int count = 1;
     			String patientName = "";
     			for(DietDetails dietDetails : dietDetailsList){
     				Patient patient = dietDetails.getHin();
     				Inpatient inpatient = dietDetails.getInpatient();
     				String middleName = "";
					String lastName = "";
					if(patient.getPMiddleName() != null){
						middleName = patient.getSMiddleName();
					}
					if(patient.getPLastName() != null){
						lastName = patient.getSLastName();
					}
    					patientName = patient.getSFirstName()+" "+middleName+" "+lastName;
     	%>
     	
	  <tr> 
		   <td><input type="checkbox" id="checkId<%=count %>" name="<%=DIET_DETAILS_ID %><%=count %>" value="<%=dietDetails.getId() %>"/></td>	    
		<td>
      <input type="text" size="2" value="<%=count %>"  name="<%=SR_NO%><%=count %>" readonly="readonly" /></td>
		    <td >
		    <input type="text" align="right" name="<%=SERVICE_NO %><%=count %>" value="<%=patient.getServiceNo() %>" tabindex="1"/>
		    </td>
		    <td >
		    <input type="text" size="13" align="right" name="<%=RELATION_NAME %><%=count %>" value="<%=patient.getRelation().getRelationName() %>" tabindex="1"/>
		    </td>
		    <td>
       		  <input type="text" size="30" name="<%=PATIENT_NAME %><%=count %>" value="<%=patientName %>" maxlength="4"  tabindex="1"/>
		    </td>
		    <td>
		    <input type="text" value="<%=inpatient.getAdNo() %>" name="<%=AD_NO %><%=count %>"  maxlength="12"  />
		    </td>
		    <td>
		    <script type="text/javascript">
		    	var dietDataId<%=count%> = '<%=dietDetails.getDiet().getId()%>'
		    	var dietTypeDataId<%=count%> = '<%=dietDetails.getDietType().getId()%>'
		    	var dietCatDataId<%=count%> = '<%=dietDetails.getDiet().getDietCategory()%>'
		    	
		    </script>
		   <select name="<%=DIET_ID %><%=count %>" id="dietId<%=count %>" onchange="checkCheckbox(this.value,<%=count %>);populateDietCombination(this,<%=count %>);">
		   		<option value="0">Select</option>
		   	<%
		   		for(MasDiet diet : dietList){
		   			
		   			if(!diet.getDietCategory().equals("T")){
		   				if(dietDetails.getDiet().getId() == diet.getId()){
		   				
		   	%>
		   		<option value="<%=diet.getId() %>" selected="selected"><%=diet.getDietName()%></option>
		   	<%			}else{ %>
		   		<option value="<%=diet.getId() %>"><%=diet.getDietName()%></option>
		   	<%} 
		   			}
		   	}%>
		   </select>
		
		    </td>
		    <td>
		    <select name="<%=THERAPEUTIC_DIET_ID %><%=count %>" id="therapeuticDietId<%=count %>" onchange="checkCheckbox(this.value,<%=count %>);">
		   		<option value="0">Select</option>
		   	<%
		   		for(MasDiet diet : dietList){
		   			
		   			if(diet.getDietCategory().equals("T")){
		   				if(dietDetails.getTherapeuticDiet() != null){
		   					if(dietDetails.getTherapeuticDiet().getId() == diet.getId()){
		   				
		   	%>
		   		<option value="<%=diet.getId() %>" selected="selected"><%=diet.getDietName()%></option>
		   	<%			}else{ %>
		   		<option value="<%=diet.getId() %>"><%=diet.getDietName()%></option>
		   	<%} 
		   					}else{ %>
		   			   		<option value="<%=diet.getId() %>"><%=diet.getDietName()%></option>
		   				   	<%} 
		   				}
		   	}%>
		   </select>
		    
		    </td>
		    <td>
		    <select name="<%=DIET_TYPE_ID %><%=count %>" id="dietTypeId<%=count %>"  onchange="checkCheckbox(this.id,<%=count %>);populateDietCombination(this,<%=count %>);">
		   		<option value="0">Select</option>
		   		<%
		   		for(MasDietType dietType : dietTypeList){
		   			if(dietType.getId() == dietDetails.getDietType().getId()){
		   				
		   		%>
		   			<option value="<%=dietType.getId() %>" selected="selected"><%=dietType.getDietTypeName() %></option>
		   		<%		}
		   				if(dietDetails.getDietType().getId() != dietType.getId()){
		  	%>
		  		<option value="<%=dietType.getId() %>" ><%=dietType.getDietTypeName() %></option>
		  	<%
		   				
		   			}
		  				}%>
				
		   </select>
		   
		    </td>
		    <td>
		    <select name="<%=CONDITION %><%=count %>" onchange="checkCheckbox(this.value,<%=count %>);">
		   		<option value="">Select</option>
		   		<%
		   		if(dietDetails.getPatientCondition() != null){
		   			if(dietDetails.getPatientCondition().equalsIgnoreCase("W")){
		   		%>
		   			<option value="W" selected="selected">Walking</option>
		   			<option value="B">Bed Patient</option>
		   		<%}
		   		if(dietDetails.getPatientCondition().equalsIgnoreCase("B")){%>
		 	   	<option value="W">Walking</option>
		 	   	<option value="B" selected="selected">Bed Patient</option>
		   	<%}
		   		}else{
		   		%>
		   		 	<option value="W">Walking</option>
		 	   	<option value="B">Bed Patient</option>
		   		<%} %>
		   </select>
		  <input type="hidden" name="<%=DIET_COMBINATION_ID %><%=count %>" id="dietCombinationId<%=count %>" value=""/>
		    </td>
		   
</tr>
<script type="text/javascript">
		var dietId = document.getElementById('dietId<%=count %>').value;
		var dietTypeId = document.getElementById('dietTypeId<%=count %>').value;
		
		<%
			for(MasDietCombination dietCombination : dietCombinationList){
		%>
				var dId = '<%=dietCombination.getDiet().getId()%>'
				var dtId = '<%=dietCombination.getDietType().getId()%>'
				var demandDisplay = '<%=dietCombination.getDemandDisplay()%>'
				if(dietId == dId && dietTypeId == dtId && demandDisplay == 'n'){
					document.getElementById('dietCombinationId<%=count %>').value = '<%=dietCombination.getId()%>'
				}
		<%}%>
		</script><!--		 
		<input type="hidden" name="<%=DIET_DETAILS_ID %>" value="<%=dietDetails.getId() %>"/>
		 --><input type="hidden" name="<%=HIN_ID %><%=count %>" value="<%=patient.getId() %>"/>
		  <input type="hidden" name="<%=INPATIENT_ID %><%=count %>" value="<%=inpatient.getId() %>"/>
<%  count++;
} 
%>

 </table>
  </div>
  <div class="Clear"></div>

<input type="hidden" name="counter" id="counter" value="<%=count %>"/>
<div class="Clear"></div>	
				 <input type="button" class="button" value="Update" align="right" onclick="if(validateCheckbox()){submitForm('dietChange','diet?method=updatePatientDietDetails');}"/>
	   <input type="hidden" name="rows" id="rr" value="1"/>	
		 <div class="Clear"></div>
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
	         
	  
 <%}else{ %>
 No Record Found!!
 <!--
  <input type="button" class="button" value="Back" align="right" onclick="submitForm('dietChange','diet?method=showPatientDietChangeJsp');"/>
 --><%} %>

	   
<script type="text/javascript">



function checkCheckbox(val,inc){
	if(val == "0" || val == ""){
		document.getElementById('checkId'+inc).checked = false;
	}else {
		document.getElementById('checkId'+inc).checked = true;
	}
}

function validateCheckbox(){

		 for(var i = 1; i < document.getElementById("counter").value; i++){
			  if(document.getElementById('checkId'+i).checked == true)
              {
				return true;
			  }		
  		}
  		alert("Please select the patient")
		return false;

}

function populateDietCombination(obj,inc){
	var dietForChange;
	var dietTypeForChange;
	var dietCatForChange;
	
	if(obj.name == '<%=DIET_ID %>'+inc){
		dietForChange = obj.value;
		dietTypeForChange = document.getElementById('dietTypeId'+inc).value;
	}
	if(obj.name == '<%=DIET_TYPE_ID %>'+inc){
		dietForChange = document.getElementById('dietId'+inc).value;
		dietTypeForChange = obj.value;
	}
	
	<%
			for(MasDietCombination dietComb : dietCombinationList){
		%>
				var dId = '<%=dietComb.getDiet().getId()%>'
				var dtId = '<%=dietComb.getDietType().getId()%>'
				var demand = '<%=dietComb.getDemandDisplay()%>'	
				if(dietForChange == dId && dietTypeForChange == dtId  && demand == 'n'){
					document.getElementById('dietCombinationId'+inc).value = '<%=dietComb.getId()%>';
				}
		<%}%>

}

</script>
</form>
</div>
