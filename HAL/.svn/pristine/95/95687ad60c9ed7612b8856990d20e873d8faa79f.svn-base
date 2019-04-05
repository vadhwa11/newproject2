<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.Visit"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
	function checkSubmitSurgery() {
 			 var chargeCode=document.getElementById('chargeCodeName1').value
 			var index1 = chargeCode.lastIndexOf("[");
		    var index2 = chargeCode.lastIndexOf("]");
		    index1++;
		    var id = chargeCode.substring(index1,index2);
		    if(id ==""){
		    	alert("Please Enter The Surgery For the patient.")
				return false ;
 			}
 			return true;
		}

</script>

<%
		Map map = new HashMap();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}

		int hospitalId=0;
		int orderNo=0;
		String userName = "";
		String empName="";
		String patientName="";
		String servicePersonName="";
	 List patientDetailList = new ArrayList();
	 List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	 List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	 List<Visit> visitList = new ArrayList<Visit>();

	if(map.get("patientDetailList") != null){
		patientDetailList=(List)map.get("patientDetailList");
	}

	if(map.get("departmentList") != null){
		departmentList=(List)map.get("departmentList");
	}

	if(map.get("visitList") != null){
		visitList=(List)map.get("visitList");
	}
	int vdeptId = 0;
	int vempId = 0;
	for(Visit visit:visitList){
		vdeptId = visit.getDepartment().getId();
		if(visit.getDoctor()!=null){
		vempId = visit.getDoctor().getId();
		}
	}
	if(map.get("empName") != null){
		empName=(String)map.get("empName");
	}

	if(map.get("doctorList") != null){
		doctorList=(List)map.get("doctorList");
	}

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");

	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if(map.get("orderNo") != null){
		orderNo=(Integer)map.get("orderNo");
		}
	int prescribedDepartmentId=0;
	if(map.get("deptId") != null){
		prescribedDepartmentId=(Integer)map.get("deptId");
		}
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	Patient patient=(Patient)patientDetailList.get(0);
	if(patient.getPFirstName()!= null){
		patientName=patient.getPFirstName();
	}
	if(patient.getPMiddleName()!= null){
		patientName=patientName+" "+patient.getPMiddleName();
	}
	if(patient.getPLastName()!= null){
		patientName=patientName+" "+patient.getPLastName();
	}

	if(patient.getSFirstName()!= null){
		servicePersonName=patient.getSFirstName();
	}
	if(patient.getSMiddleName()!= null){
		servicePersonName=servicePersonName+" "+patient.getSMiddleName();
	}
	if(patient.getSLastName()!= null){
		servicePersonName=servicePersonName+" "+patient.getSLastName();
	}
	String workingDiag = "";
	Visit visit=null;
	if(visitList.size()>0){
		visit=(Visit)visitList.get(0);
		if(visit.getDiagnosisString()!=null && !visit.getDiagnosisString().equals("")){
	       workingDiag=visit.getDiagnosisString();
	    }else{
		   workingDiag="-";
	    }
	}
%>

<div id="contentHolder">
	<form name="inpatientSurgeryRequisition" action="" method="post">
	<%if(patient.getPatientStatus().equals("In Patient")){ %>
	<h6>Surgery Requisition For In-Patient </h6>
	<%}else{ %>
	<h6>Surgery Requisition For Out-Patient </h6>
	<%} %>
	<div class="Clear"></div>

<script type="text/javascript">
   var icdArray=new Array();
</script>
<!--Block One Starts-->
	<div class="blockTitle">Service Personnel Details</div><div class="blockTitleCurve"></div>
	<div class="Clear"></div>

<div class="blockFrame">
	<div class="Clear"></div>
	<label class="medium">Service Type</label>
	<%if(patient.getServiceType()!= null){ %>
	<label class="valuemedium"><%=patient.getServiceType().getServiceTypeName() %></label>
	<%}else{ %>
	<label class="valuemedium">-</label>
	<%} %>
	<label class="medium">Service No.</label>
	<%if(patient.getServiceNo()!= null){ %>
	<label class="valuemedium"><%=patient.getServiceNo() %></label>
	<%}else{ %>
	<label class="valuemedium">-</label>
	<%} %>
	<label class="medium"> Serv. Status </label>
	<%if(patient.getServiceStatus()!= null){ %>
	<label class="valuemedium"><%=patient.getServiceStatus().getServiceStatusName() %></label>
	<%}else{ %>
	<label class="valuemedium">-</label>
	<%} %>

	<label class="medium">Name</label>
	<%if(servicePersonName != null){ %>
	<label class="valuemedium" style="width: auto;"><%=servicePersonName %></label>
	<%}else{ %>
	<label class="valuemedium">-</label>
	<%} %>
	<div class="Clear"></div>

	<label class="medium">Relation</label>
	<%if(patient.getRelation() != null){ %>
	<label class="valuemedium"><%=patient.getRelation().getRelationName() %></label>
	<%}else{ %>
	<label class="valuemedium">-</label>
	<%} %>
	<label class="medium">Rank</label>
	<%if(patient.getRank()!= null){ %>
	<label class="valuemedium"><%=patient.getRank().getRankName() %></label>
	<%}else{ %>
	<label class="valuemedium">-</label>
	<%} %>

	<label class="medium">Unit</label>
	<%if(patient.getUnit()!= null){ %>
	<label class="valuemedium"><%=patient.getUnit().getUnitName() %></label>
	<%}else{ %>
	<label class="valuemedium">-</label>
	<%} %>

	<label class="medium">Unit Address</label>
	<% if(patient.getUnit()!= null){%>
	<label class="valuemedium"><%=patient.getUnit().getUnitAddress() %></label>
	<%}else{ %>
	<label class="valuemedium">-</label>
	<%} %>
	</div>
	<div class="Clear"></div>
	<!--Block One Ends-->

	<div class="blockTitle">Patient Details</div><div class="blockTitleCurve"></div>
		<div class="Clear"></div>
		<div class="blockFrame">
		<label>HIN No.</label>
		<%if(patient.getHinNo()!= null){ %>
		<label class="value"><%=patient.getHinNo() %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<label>Patient Name </label>
		<%if(patientName!= null){ %>
		<label class="value" ><%=patientName %> </label>
		<%}else{ %>
		<label class="value">- </label>
		<%} %>

		<label>Age</label>
		<%if(patient.getAge()!= null){ %>
		<label class="value"><%=HMSUtil.calculateAge(patient.getAge() , patient.getRegDate(), patient.getDateOfBirth()) %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>

		<div class="Clear"></div>

		<label>Patient Status </label>
		<%if(patient.getPatientStatus() != null){ %>
		<label class="value"><%=patient.getPatientStatus() %></label>
		<input type="hidden" name="patientStatus" id="patientStatus" value="<%=patient.getPatientStatus() %>" />
		<%}else{ %>
		<label class="valuem">-</label>
		<%} %>

		<label>Reg.Date </label>
		<%if(patient.getRegDate()!= null){ %>
		<label class="value"><%=HMSUtil.convertDateToStringWithoutTime(patient.getRegDate())%></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>

		<label>Order No: </label>
		<label class="value"><%=orderNo %></label>

		<label>Working Diagnosis: </label>
		<label class="valueNoWidth"><%=workingDiag %></label>

		<div class="Clear"></div>
	</div>
<div class="Clear"></div>
	<label class="small">Department</label>
	<select name="departmentId" id="departmentId" onchange="changeValue(this.value)">
    <option value="0">Select</option>
    <%
       int deptId=0;
       int empId =0;
	   //Iterator itr= departmentList.iterator();
       for(MasDepartment masDepartment : departmentList)
       {
    	if(vdeptId == masDepartment.getId()){
	%>
    <option value="<%=masDepartment.getId() %>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
    <%}else{ %>
    <option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
    <% 	}
     }
	%>
  </select>
   <!--
   <label class="medium">Prescribed By: </label>
   <label class="valuemedium"><%=empName %></label>

   <div id="ajaxResponse"></div>
   -->
   <label class="small"><span>*</span> Surgeon Name</label>
	<select name="surgeonName" id="surgeonName" onchange="" validate="Surgeon Name,String,yes">
    <option value="0">Select</option>
    <%

	  // Iterator itr1= doctorList.iterator();
       for(MasEmployee masEmployee : doctorList)
       {
    	   if(vempId == masEmployee.getId()){
 	%>
    <option value="<%=masEmployee.getId() %>" selected="selected"><%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName() %></option>
    <%}else{ %>
    <option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName() %></option>
    <%
      } }
	%>
  </select>

<label> PAC required </label>
<input	type="checkbox" class="radio2" name="pacRequird" value="y" checked="checked"/>
   <div class="colA" style="width: 700px; float:left;padding: 10px; 0px; 0px; 0px;margin:  0px; 0px; 0px; 0px;">
<div class="title">Surgery</div>
<div class="Clear"></div>


			 <input type="button" class="ButtonDel"  alt="Delete" value=" " onclick="removeRow();" align="right" />
			 <input type="button" class="ButtonAdd"  alt="Add" value=" " onclick="addRowForSurgery(document.getElementById('departmentId').value);" align="right" />

<div class="Clear"></div>

	<div class="tableHolderAuto" style="width: 700px; float:left;padding: 0px; 0px; 0px; 0px;margin:  0px; 0px; 0px; 0px;">

		<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid">
		  <tr>
		   <th scope="col" style="width: 20px;">S.No</th>
		   <th scope="col">Surgery Name</th>
		 <!--   <th scope="col">Surgery Code </th> -->

	    </tr>

		  <tr>
		    <td><input type="text"  size="2" value="1"  /></td>
		    <td>
		     <%int inc=1; %>
		    <input type="text" value="" style="width: 600px;"	tabindex="1" id="chargeCodeName1" size="43"  name="chargeCodeName"  onblur="fillChargeCodeId(this.value , '<%=inc %>');" />
			<div id="ac2update2" style="display:none;height: 150px; font-weight:normal;overflow:scroll; border:1px solid black; padding-right: 10px; background-color:white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			   function eventCallback(element, entry){
					return entry + "&deptId="+document.getElementById("departmentId").value;
				}
			  new Ajax.Autocompleter('chargeCodeName1','ac2update2','fwc?method=getChargeCodeListForAutoComplete',{parameters:'requiredField=chargeCodeName',callback: eventCallback});
			</script>
		   	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
		   	<input type="hidden" value="" name="<%=CHARGE_CODE_ID%>" id="chargeCodeId1" />
		   	<input type="hidden" name="chargeCode" id="chargeCode1" size="10"  />
		    </td>
		    <div id="chargeCodeVal">
		    </div>
		  <!--   <td id="chargeCodeVal">
		    	<input type="text" name="chargeCode1" id="chargeCode1" size="10"  />
		    </td>  -->
		    </tr>
		</table>

	<div class="Clear"></div>

		</div>


	</div>
	<div class="Clear"></div>
	<input name="Submit" type="button" align="right" class="button" value="Submit"  onclick="if(checkSubmitSurgery()){submitForm('inpatientSurgeryRequisition','fwc?method=submitSurgeryRequisitionDetailsForInpatient&orderNo=<%=orderNo %>');}" />

	</div>



  <input type="hidden" name="hinId" value="<%=patient.getId() %>"/>

  <input type="hidden" name="prescribedDepartmentId" value="<%=prescribedDepartmentId %>"/>
  <input type="hidden" name="deptId" value="<%=deptId %>"/>
  <input type="hidden" name="date" value="<%=date %>"/>
  <input type="hidden" name="time" value="<%=time %>"/>

  <input type="hidden" name="userName" value="<%=userName %>"/>
	</form>
	</div>
<script type="text/javascript">

	function removeRow()
	{
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	}
 function addRowForSurgery(departmentId){

	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration

	  var cellRightSel = row.insertCell(0);
	  var sel = document.createElement('input');
	  sel.value=hdb.value;
	  sel.size='2'

	  cellRightSel.appendChild(sel);

	  var cellRight1 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){

	  	if(fillChargeCodeId(this.value,iteration)){checkForChargeCode(this.value,'iteration','chargeCodeVal'+iteration);}

	  };
	  e0.name = 'chargeCodeName';
	  e0.id = 'chargeCodeName' + iteration;
	  e0.size = '106'
	  cellRight1.appendChild(e0);
		new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update2','fwc?method=getChargeCodeListForAutoComplete&deptId='+departmentId,{parameters:'requiredField=chargeCodeName'});

	  var cellRightSel = row.insertCell(2);
	//  cellRightSel.id='chargeCodeVal'+iteration;
	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='chargeCodeId';
	  sel.id='chargeCodeId'+iteration
	  sel.size = '10'
	  cellRightSel.appendChild(sel);
	   var div = document.createElement('div');
	   div.id = 'chargeCodeVal'+iteration ;
	 cellRightSel.appendChild(div);

	}
	function checkForChargeCode(val,inc,chargeCodeTdDiv){

	if(val != ""){

		var index1 = val.lastIndexOf("[");
		var indexForChargeCode = index1;
		var index2 = val.lastIndexOf("]");
		index1++;
		var chargeId = val.substring(index1,index2);
		var indexForChargeCode = indexForChargeCode--;
		var chargeCode = val.substring(0,indexForChargeCode);


		if(chargeId == "" ) {
	      	document.getElementById('chargeCodeName'+inc).value="";
	      	document.getElementById('chargeCodeId'+inc).value="";
	      	//document.getElementById('clinicalNotes'+inc).value="";
	 	  	//document.getElementById('qty'+inc).value="";
	      	return;
		}
		for(i=1;i<inc;i++){
			if(inc != 1){
				if(document.getElementById('chargeCodeName'+i).value==val) {
					alert("Test name already selected...!")
					document.getElementById('chargeCodeId'+inc).value=""
					var e=eval(document.getElementById('chargeCodeName'+inc));
					e.focus();
					return false;
				}
			}
		}

		var nameOfChargeCodeArray = chargeCode.split('&');
		var tempChargeCodeString = "";
		for(var m=0; m<nameOfChargeCodeArray.length;m++) {
			tempChargeCodeString = tempChargeCodeString + nameOfChargeCodeArray[m]+"0";
		}

		submitProtoAjaxWithDivNameToShowStatus('inpatientSurgeryRequisition','/hms/hms/fwc?method=fillChargeCode&chargeCodeNAmeForAjax='+ tempChargeCodeString+'&rowVal=1',chargeCodeTdDiv);

		}else{
			document.getElementById('chargeCodeName'+inc).value = "";
			document.getElementById('qty'+inc).value = "";
			document.getElementById('chargeCodeId'+inc).value = "";
			//document.getElementById('qty'+inc).value = "";
			//document.getElementById('qty'+inc).value = "";
		}
	}
	function fillChargeCodeId(val , inc){
		//alert("in method--")

		if(val != "") {
		    var index1 = val.lastIndexOf("[");
		    var indexForChargeCode=index1;
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var chargeCodeId = val.substring(index1,index2);
		    var indexForChargeCode=indexForChargeCode--;
		    var chargeCodeName=val.substring(0,indexForChargeCode);
			if(chargeCodeId == "") {
		   		document.getElementById('chargeCodeName'+inc).value="";
		    	document.getElementById('chargeCodeId'+inc).value="";
		   		return;
		   	} else {
	   		      document.getElementById('chargeCodeId'+inc).value=chargeCodeId;
	      	}
	 	}
	}

</script>

