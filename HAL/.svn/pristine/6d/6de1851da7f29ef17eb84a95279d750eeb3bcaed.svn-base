<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/opd.js"></script>
	

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>


<!--<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
-->
<!--</script>
-->
<!--<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
-->
<!--  By Vishnu -->
<%



Map map = new HashMap();
//String includedJsp = null;
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

}

String userName = "";
if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
}
int hospitalId=0;
if (session.getAttribute("hospitalId") != null) {
	hospitalId = (Integer) session.getAttribute("hospitalId");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");	 
String currentTime = (String)utilMap.get("currentTime");

 List <OtPreAnesthesiaHd>otPreAnesthesiaDetailsList = new ArrayList<OtPreAnesthesiaHd>();
  List 	opdPatientHistoryList= new ArrayList();	
 List otPreOPDrugsList= new ArrayList();
if(map.get("otPreAnesthesiaDetailsList") != null){
	otPreAnesthesiaDetailsList=(List<OtPreAnesthesiaHd>)map.get("otPreAnesthesiaDetailsList");
}
if(map.get("opdPatientHistoryList") != null){
	opdPatientHistoryList=(List)map.get("opdPatientHistoryList");
}
if(map.get("otPreOPDrugsList") != null){
	otPreOPDrugsList=(List)map.get("otPreOPDrugsList");
}
List<OtPreAnesthesiaDetail> otPreAnesthesiaSurgeryList = new ArrayList<OtPreAnesthesiaDetail>();
if(map.get("otPreAnesthesiaSurgeryList") != null){
	otPreAnesthesiaSurgeryList=(List)map.get("otPreAnesthesiaSurgeryList");
}
List<OtPreAnesthesiaDetail> pacDt = new ArrayList<OtPreAnesthesiaDetail>();
if(map.get("pacDt") != null){
	pacDt = (List<OtPreAnesthesiaDetail>) map.get("pacDt");
}

List<PreAnesthesiaConsultDoctorDt> ConsultDoctorDtList = new ArrayList<PreAnesthesiaConsultDoctorDt>();
String remarks =null;
if(map.get("remarks") != null){
	remarks = (String) map.get("remarks");
}

OtPreAnesthesiaHd otPreAnesthesiaDetails =null;

 
%>
<div class="clear"></div>
<div class="clear"></div>
		<label>Surgery Notes</label>
			<label class="value" style="width: 700px"><%=remarks!=null?remarks:"-"%></label>
		
	<!-- 	<h2>No record</h2>   -->

<%-- <div class="Block">
<h4>Others</h4>
<div class="clear"></div>

<label>Abdomen</label> <textarea name="abdomen" class="textareaMediua"
	cols="" rows="" maxlength="100" onkeyup="return ismaxlength(this)"></textarea>

<label>Liver</label> <textarea name="liver" cols="" rows="" class="textareaMediua"
	maxlength="100" onkeyup="return ismaxlength(this)"></textarea> <label>Spleen</label>
<textarea name="spleen" cols="" rows="" maxlength="100" class="textareaMediua"
	onkeyup="return ismaxlength(this)"></textarea>

<div class="clear"></div>

<input type="text" value="" id="anaesthicPlanned" name="anaesthicPlanned" style="width:160px;" />
<div class="clear"></div>
 <label>Blood Component </label> 
<!--  <input name="blood" type="text" maxlength="25" /> -->
 <select name="blood" multiple="multiple" class="list" size="25" >
 <option value="">Select</option>
 <%for(BloodMasComponent BloodMasComponent:BloodMasComponentList){ %>
 <option value="<%=BloodMasComponent.getComponentName().concat("[").concat(""+BloodMasComponent.getQtyUnit()+" "+"ml").concat("]")%>"><%=BloodMasComponent.getComponentName().concat("[").concat(""+BloodMasComponent.getQtyUnit()+" "+"ml").concat("]") %></option>
 <%} %>
 </select>
 <label>Unit</label>
 <input type="text" name="unitForBloodComponent" id="unitForBloodComponentId" value=""  maxlength="4" />
 
	<div class="clear"></div>
	<label>In</label> <select name="">
	<option>select</option>
	<option>OT</option>
</select>
<div class="clear"></div>
<label>Any Special Instruction</label> <textarea name="instructions" class="textareaMediua"
	cols="" rows="" maxlength="100" onkeyup="return ismaxlength(this)"></textarea>
<label>ASA Grade</label> <select name="asa" id="asa">
	<option value="">Select</option>
	<option value="I">I</option>
	<option value="II">II</option>
	<option value="III">III</option>
	<option value="IV">IV</option>
	<option value="V">V</option>
</select> <label>Patient Type</label> 
<select name="patientType" id="patientType">
	<option value="">Select</option>
	<option value="new">New</option>
	<option value="Review">Review</option>

</select>
<div class="clear"></div>
<label>Fit for surgery</label>
<select name="fitForSurgery" id="fitForSurgery1" onchange="getFitForSurgery(this.value);">
<option value="">-Select-</option>
<option value="y">Yes</option>
<option value="n">Pending</option>
</select>
<div id="fitForSurgery" style="display: none;"><label>Doctor</label>
<select name="doctorName" id="doctorId">
<option value="0">Select</option>
<%for(MasEmployee emp:doctorList){ %>
<option value="<%=emp.getId()%>"><%=emp.getFirstName()%></option>
<%} %>
</select>
<label>Remarks</label>
<textarea name="remarks" ></textarea>

</div>
<div class="clear"></div>
<label>Summary</label>
<textarea name="summary" id="summaryId" class="textareaMediua">

</textarea>
<div class="clear"></div>
<input name="investigation"
	type="button" value="View Patient History" class="inputButtonAutu"
	onclick="showPatientHistory();" />
	
	<input name="investigation"
	type="button" value="Blood request" class="inputButtonAutu"
	onclick="getBloodRequest('<%=opdSurgeryHeader.getHin().getHinNo() %>')" />

<input name="patientStatus" type="hidden"
	value="<%=opdSurgeryHeader.getPatientStatus() %>" />
	<input type="hidden" id="requestId" value="<%=opdSurgeryHeader.getHin().getId() %>"/>
	
	
	
	 <input	name="hinId" id="hinId" type="hidden"	value="<%=opdSurgeryHeader.getHin().getId() %>" /> 
	 <input	name="hospitalId" type="hidden" value="<%=hospitalId %>" /> 
	 <input	name="deptId" type="hidden" value="<%=deptId %>" /> 
	 <input	name="orderNo" type="hidden" value="<%=opdSurgeryHeader.getOrderNo() %>" /> 
	 <input name="changedBy"
	type="hidden" value="<%=userName %>" /> <input name="changedDate"
	type="hidden" value="<%=currentDate %>" /> <input name="changedTime"
	type="hidden" value="<%=currentTime %>" /> <input type="button"
	name="Submit" class="button" value="Submit"
	onclick="if(checkGrade()){submitForm('preAnesthesia','ot?method=submitPreAnesthesiaDetails&pastHistory=<%=pastHistory%>&presentHistory=<%=presentHistory%>');}" />

<input name="back" type="button" class="button" value="Back"
	onclick="submitForm ('preAnesthesia','ot?method=showPACClearanceList')" />
<div class="clear"></div>
</div> 
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=currentDate %></label>

<label>Changed Time</label> <label class="value"><%=currentTime %></label>
<div class="clear"></div>
<div class="paddingTop40"></div>
</div>
</form>
--%>
<!--main content placeholder ends here-->


<script type="text/javascript">
	
	
		function ismaxlength(obj){
		var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
		if (obj.getAttribute && obj.value.length>mlength)
		obj.value=obj.value.substring(0,mlength)
		}
		
		function checkGrade(){
		var grade=document.getElementById('grade').value;
		if (grade== ""){
		
			if(!displayAlert("Please Enter the Anesthtic Technique Planned."))
				alert("Please Enter the Anesthtic Technique Planned.");
			getShadow('grade');
		    return false;
		}
		  return true;
		}
		
		
		function openPopupForInvestigation(patientStatus){
			
			var hinId=document.getElementById('hinId').value;
			if(patientStatus=="OutPatient"){
			var visitId=document.getElementById('visitId').value
			   var url="/hms/hms/ot?method=openPopUPWindowForInvestigationJsp&patientStatus="+patientStatus+"&visitId="+visitId+"&hinId="+hinId;
			}else{
			 var inpatientId=document.getElementById('inPatientId').value
			   var url="/hms/hms/ot?method=openPopUPWindowForInvestigationJsp&patientStatus="+patientStatus+"&hinId="+hinId+"&inpatientId="+inpatientId;
			}
		   popwindow(url);
		}
		var newwindow;
		function popwindow(url)
		{
		 newwindow=window.open(url,'name',"height=300,width=700,status=1");
		
		}

		function validateBpValue(obj){
			var bpObj = document.getElementById('bp');
			 var bool =validateBpWithSlash(obj)
			if(bool)
			{

			if(obj != ""){
			var index=obj.indexOf('/');
			if(index != 3){
				if(!displayAlert("BP should be in max/min Format."))
					alert("BP should be in max/min Format.");
				showShadow(bpObj);
				 bpObj.value="";
				 //bpObj.focus();
				 return false;
				 }


				 var pairs2 = obj.substring(0,obj.length).split('/');
				 if (pairs2.length!=2) {
					 if(!displayAlert("Invalid  Format."))
						 alert("Invalid  Format.");
					 showShadow(bpObj);
					return false;
					}

				val3=eval(pairs2[0]);
				if (val3>240) {
					if(!displayAlert("Maximum BP should be less than 240."))
						alert("Maximum BP should be less than 240.");
					showShadow(bpObj);
				 return false;}

				val2=eval(pairs2[1]);
				if (val2<60 ) {
					if(!displayAlert("Maximum BP should be less than 240."))
						alert("Minimum BP should be greater than 60");
					showShadow(bpObj);
				  return false;}


			}
			return true;
			}
			showShadow(bpObj);
			bpObj.value="";
			return false;
			}
		function stValueToAnaesthicPlanned(val){
				val=val+" ";
				var valForAna=document.getElementById('anaesthicPlanned').value;
				val=valForAna+val+",";
				document.getElementById('anaesthicPlanned').value=val;
			     
				}
	</script>
<script>
function getBloodRequest(hinNo){
	submitForm('preAnesthesia','bloodBank?method=searchPatientForBloodRequest&<%=HIN_NO%>='+ hinNo);

	}
</script>

<script type="text/javascript">
	function openPopupWindow() {
		var requestId = document.getElementById("requestId").value.trim();

		//window.open("/hms/hms/ot?method=showAllergy&requestId="+requestId+"&"+csrfTokenName+"="+csrfTokenValue,"_blank", "toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=850, height=400");
		window
				.open(
						"/hms/hms/ot?method=showAllergy&requestId=" + requestId,
						"_blank",
						"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=850, height=400");
	}
</script>
<script>
	function getFitForSurgery(val) {
		//alert(""+val)
		if (val == 'n') {
			document.getElementById('fitForSurgery').style.display = "inline";
		} else if (val == 'y') {
			document.getElementById('fitForSurgery').style.display = "none";
		} else //if(val=='')
		{
			document.getElementById('fitForSurgery').style.display = "none";
		}
	}
</script>
<script>
	function calculateBMI() {
		document.getElementById('bmiId').value = '';
		if (document.getElementById('heightId').value != ""
				&& document.getElementById('weightId').value != "") {
			var height = parseFloat(document.getElementById('heightId').value) / 100;
			var weight = document.getElementById('weightId').value;
			document.getElementById('bmiId').value = (weight / (height * height))
					.toFixed(2);
		}
		bmiCat();
	}

	function bmiCat() {
		var bmicat;
		document.getElementById('bmiId').value = '';
		if (document.getElementById('heightId').value != ""
				&& document.getElementById('weightId').value != "") {
			var height = parseFloat(document.getElementById('heightId').value) / 100;
			var weight = document.getElementById('weightId').value;
			document.getElementById('bmiId').value = (weight / (height * height))
					.toFixed(2);
			bmicat = (weight / (height * height)).toFixed(2);
		}
		document.getElementById('bmiStatusId').value = ' ';
		if (bmicat < 18.5) {
			document.getElementById('bmiStatusId').value = 'Underweight';
		} else if (bmicat >= 18.5 && bmicat < 25) {
			document.getElementById('bmiStatusId').value = 'Healthy Range';
		} else if (bmicat >= 25 && bmicat <= 30) {
			document.getElementById('bmiStatusId').value = 'Overweight';
		} else if (bmicat >= 30 && bmicat <= 35) {
			document.getElementById('bmiStatusId').value = 'Obese';
		} else if (bmicat > 35) {

			document.getElementById('bmiStatusId').value = 'Severely obese';
		} else {
			document.getElementById('bmiStatusId').value = '';
		}
	}
	function setBedStatus() {
		if (document.getElementById('arrangeBedId').checked == true) {
			document.getElementById('ventilatorId').style.display = "inline";
			document.getElementById('arrangeBedId1').value = 'y';
		} else if (document.getElementById('arrangeBedId').checked == false) {
			document.getElementById('ventilatorId').style.display = "none";
			document.getElementById('arrangeBedId1').value = 'n';
		}

	}
	function showPatientHistory() {
		//document.opdMain.action="/hms/hms/enquiry?method=showPatientDetails&hinNo="+hinNo;
		//document.opdMain.submit();
		// var visitId = document.getElementById("visitId").value;
		var hinNo = document.getElementById('hinNoUHID').value;
		var url = '/hms/hms/enquiry?method=showPatientDetails&hinNo=' + hinNo
				+ '&' + csrfTokenName + '=' + csrfTokenValue;
		newwindow = window
				.open(url, 'opd_window',
						"left=100,top=100,height=700,width=1024,status=1,scrollbars=yes,resizable=0");
	}

	function addRowForInvestigation() {

		var tbl = document.getElementById('investigationGrid');
		var lastRow = tbl.rows.length;

		// if there's no header row in the table, then iteration = lastRow + 1
		var iteration = lastRow;
		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('hiddenValue');
		var iteration = parseInt(hdb.value) + 1;
		hdb.value = iteration
		// alert("iteration row--"+iteration)

		var cellRight0 = row.insertCell(0);
		var e0 = document.createElement('input');
		e0.type = 'text';
		// e0.innerHTML = iteration+':'
		e0.onblur = function() {

			if (validateInvestigationAutoComplete(this.value, iteration)) {
				checkForChargeCode(this.value, iteration, 'chargeCodeVal'
						+ iteration);
			}

		};
		var newdiv1 = document.createElement('div');
		newdiv1.id = 'ac2update' + iteration;
		newdiv1.className = 'autocomplete';
		newdiv1.style.display = 'none';

		e0.name = 'chargeCodeName' + iteration;
		e0.id = 'chargeCodeName' + iteration;
		e0.setAttribute('tabindex', '1');
		//alert("name--"+e0.name)
		e0.size = '100'
		cellRight0.appendChild(newdiv1);

		cellRight0.appendChild(e0);
		e0.focus();

		new Ajax.Autocompleter(
				'chargeCodeName' + iteration,
				'ac2update' + iteration,
				'opd?method=getInvestigationListForAutoComplete',
				{
					callback : function(element, entry) {
						return entry
								+ '&labradiologyCheck='
								+ document
										.getElementById('investigationCategory').value;
					},
					parameters : 'requiredField=chargeCodeName' + iteration
				});
		var sel = document.createElement('input');

		sel.type = 'hidden';
		sel.name = 'chargeCode' + iteration;
		sel.id = 'chargeCode' + iteration
		sel.size = '10';
		sel.setAttribute('tabindex', '1');
		cellRight0.appendChild(sel);

		var e2 = document.createElement('input');
		e2.type = 'hidden';
		e2.name = 'qty' + iteration;
		e2.id = 'qty' + iteration
		e2.size = '10';
		e2.setAttribute('tabindex', '1');
		cellRight0.appendChild(e2);

		/* 	  var cellRight1 = row.insertCell(1);
		 var e3 = document.createElement('input');
		 e3.type = 'checkbox';
		 e3.name='referToMh'+iteration;
		 e3.id='referToMhId'+iteration
		 e3.size='10';
		 e3.className='radio';
		 e3.value='y';
		 e3.setAttribute('tabindex','1');
		 cellRight1.appendChild(e3); */

		var cellRight2 = row.insertCell(1);
		var e4 = document.createElement('input');
		e4.type = 'button';
		e4.className = 'buttonAdd';
		e4.name = 'Button';
		e4.setAttribute('tabindex', '1');
		//e4.setAttribute('onClick','addRowForInvestigation();');
		e4.onclick = function() {
			addRowForInvestigation();
		};
		cellRight2.appendChild(e4);

		var cellRight3 = row.insertCell(2);
		var e5 = document.createElement('input');
		e5.type = 'button';
		e5.className = 'buttonDel';
		e5.name = 'deldddete';
		e5.setAttribute('tabindex', '1');
		e5.onclick = function() {
			removeRow("investigationGrid", "hdb", this);
		};
		//e5.setAttribute('onClick','removeRow("investigationGrid","hdb",this);');
		cellRight3.appendChild(e5);

		//fayaz removed
		//var cellRight3 = row.insertCell(1);
		// var e3 = document.createElement('input');
		// e3.type = 'text';
		// e3.name='clinicalNotes'+iteration;
		// e3.id='clinicalNotes'+iteration;
		// e3.setAttribute('tabindex','1');
		// e3.size='60'
		// cellRight3.appendChild(e3);

	}


	function removeRow(idName,countId,obj)
	{
	  var tbl = document.getElementById(idName);
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	  //	tbl.deleteRow(lastRow - 1);
	    var i=obj.parentNode.parentNode.rowIndex;
	    tbl.deleteRow(i);
	  }
	}

	function fnGetDoctorDepartment(departmentId, divName) {
		// new Ajax.Request('opd?method=getDoctorDepartment&departmentId='+departmentId+'&'+csrfTokenName+'='+csrfTokenValue, {
		new Ajax.Request(
				'opd?method=getDoctorDetails&departmentId=' + departmentId,
				{
					onSuccess : function(response) {
						if (response.responseText.trim() != '') {
							document.getElementById(divName).innerHTML = response.responseText
									.trim();
						}
					}
				});
	}

	 function OPDHistoryPopup(hinId,inpatientId)
		{
		//var url='/hms/hms/opd?method=showPopUpPresentComplaint&'+csrf+'&'+csrfTokenName+'='+csrfTokenValue;
			 var url='/hms/hms/ot?method=openPopupWindowForOPDHistory&hinId='+hinId+"&inpatientId="+inpatientId;
		 //popwindow(url);
		 window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
		} 
	 
	 function IPDHistoryPopup(tempCode)
		{
		//var url='/hms/hms/opd?method=showPopUpPresentComplaint&'+csrf+'&'+csrfTokenName+'='+csrfTokenValue;
			 var url='/hms/hms/ot?method=showPopUpHistoryTemplate&tempCode='+tempCode;
		// popwindow(url);
		 window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
		} 
		
	jQuery(function($) {

		$("#referDiv").hide();

		$("#refer_consult").change(function() {
			if ($("#refer_consult").val() == 'y') {
				$("#referDiv").show();
			} else {
				$("#referDiv").hide();

			}
		});

	});
	
	
	
	
</script>

