<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%

    System.out.println("Size of patientDetailList list in jsp--");
		Map map = new HashMap();
		//String includedJsp = null;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");

		}

		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");

	 List patientDetailList = new ArrayList();
	 List departmentList = new ArrayList();
	 List<MasEmployee> employeeList = new ArrayList<MasEmployee>();

	if(map.get("patientDetailList") != null){

		patientDetailList=(List)map.get("patientDetailList");

	}
	if(map.get("departmentList") != null){

		departmentList=(List)map.get("departmentList");

		}
	if(map.get("employeeList") != null){
		employeeList=(List)map.get("employeeList");
	}

	String empName="";
	if(map.get("empName") != null){
		empName=(String)map.get("empName");
		}

	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	int orderNo=0;
	if(map.get("orderNo") != null){
		orderNo=(Integer)map.get("orderNo");
	}


	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	Visit visit=(Visit)patientDetailList.get(0);

	String patientName="";
	if(visit.getHin().getPFirstName()!= null){
		patientName=visit.getHin().getPFirstName();
	}
	if(visit.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+visit.getHin().getPMiddleName();
	}
	if(visit.getHin().getPLastName()!= null){
		patientName=patientName+" "+visit.getHin().getPLastName();
	}
	 String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
	int hinId=visit.getHin().getId();
	int prescribedDepartmentId=visit.getDepartment().getId();
%>



<script type="text/javascript">
	function checkSubmitSurgery() {
 			 var chargeCode=document.getElementById('chargeCodeName1').value
 			var index1 = chargeCode.lastIndexOf("[");
		    var index2 = chargeCode.lastIndexOf("]");
		    index1++;
		    var id = chargeCode.substring(index1,index2);
		    //alert("id----"+id)

		    if(id =="")
		    {
		    	alert("Please Enter The Surgery For the patient.")
				return false ;
 			}
 			return true;
		}
</script>


<div id="contentHolder">
	<form name="opdSurgery" action="" method="post">
	<%if(visit.getDepartment()!= null){ %>
<h4><%=visit.getDepartment().getDepartmentName() %></h4><h6>Surgery Requisition For OPD-Patient </h6>
	<div class="Clear"></div>
	<%} %>
<script type="text/javascript">
   var icdArray=new Array();
</script>
<!--Block One Starts-->
	<div class="blockTitle">Service Personnel Details</div><div class="blockTitleCurve"></div>
	<div class="Clear"></div>

<div class="blockFrame">
	<div class="Clear"></div>
	<label class="medium">Service Type</label>
	<%if(visit.getHin().getServiceType()!= null){ %>
	<label class="valuemedium"><%=visit.getHin().getServiceType().getServiceTypeName() %></label>
	<%}else{ %>
	<label class="valuemedium">-</label>
	<%} %>
	<label class="medium">Service No.</label>
	<%if(visit.getHin().getServiceNo()!= null){ %>
	<label class="valuemedium"><%=visit.getHin().getServiceNo() %></label>
	<%}else{ %>
	<label class="valuemedium">-</label>
	<%} %>
	<label class="medium"> Serv. Status </label>
	<%if(visit.getHin().getServiceStatus()!= null){ %>
	<label class="valuemedium"><%=visit.getHin().getServiceStatus().getServiceStatusName() %></label>
	<%}else{ %>
	<label class="valuemedium">-</label>
	<%} %>

	<label class="medium">Name</label>
	<%if(patientName != null){ %>
	<label class="valuemedium"><%=patientName %></label>
	<%}else{ %>
	<label class="valuemedium">-</label>
	<%} %>
	<div class="Clear"></div>

	<label class="medium">Relation</label>
	<%if(visit.getHin().getRelation() != null){ %>
	<label class="valuemedium"><%=visit.getHin().getRelation().getRelationName() %></label>
	<%}else{ %>
	<label class="valuemedium">-</label>
	<%} %>
	<label class="medium">Rank</label>
	<%if(visit.getHin().getRank()!= null){ %>
	<label class="valuemedium"><%=visit.getHin().getRank().getRankName() %></label>
	<%}else{ %>
	<label class="valuemedium">-</label>
	<%} %>




	<label class="medium">Unit</label>
	<%if(visit.getHin().getUnit()!= null){ %>
	<label class="valuemedium"><%=visit.getHin().getUnit().getUnitName() %></label>
	<%}else{ %>
	<label class="valuemedium">-</label>
	<%} %>

	<label class="medium">Unit Address</label>
	<% if(visit.getHin().getUnit()!= null){%>
	<label class="medium"><%=visit.getHin().getUnit().getUnitAddress() %></label>
	<%}else{ %>
	<label class="medium">-</label>
	<%} %>
	<div class="division"></div>
	<div class="blockTitle">Patient Details</div><div class="blockTitleCurve"></div>
	<div class="Clear"></div>
	<label class="medium">HIN No.</label>
	<%if(visit.getHin().getHinNo()!= null){ %>
	<label class="valuemedium"><%=visit.getHin().getHinNo() %></label>
	<%}else{ %>
	<label class="valuemedium">-</label>
	<%} %>
	<label class="medium">Patient Name</label>
	<%if(patientName!= null){ %>
	<label class="valuemedium"><%=patientName %> </label>
	<%}else{ %>
	<label class="valuemedium">- </label>
	<%} %>

	<label class="medium">Age</label>
	<%if(visit.getAge()!= null){ %>
	<label class="valuemedium"><%=visit.getAge() %></label>
	<%}else{ %>
	<label class="valuemedium">-</label>
	<%} %>

	<label class="medium">Visit Date </label>
	<%if(visitDateInString != null){ %>
	<label class="valuemedium"><%=visitDateInString %></label>
	<%}else{ %>
	<label class="valuemedium">-</label>
	<%} %>
	<div class="Clear"></div>



	<label class="medium">Visit no. </label>
	<%if(visit.getVisitNo()!= null){ %>
	<label class="valuemedium"><%=visit.getVisitNo() %></label>
	<%}else{ %>
	<label class="valuemedium">-</label>
	<%} %>



	<label class="medium">Token No. </label>
	<%if(visit.getTokenNo()!= null){ %>
	<label class="valuemedium"><%=visit.getTokenNo() %></label>
	<%}else{ %>
	<label class="valuemedium">-</label>
	<%} %>


	<label class="medium">Prev. Diag </label>
	<%if(visit.getDiagnosis()!= null){ %>
	<label class="valueNoWidth"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
	<%}else{ %>
	<label class="valueNoWidth">-</label>
	<%} %>

	<label class="medium">Order No: </label>
	<%if(map.get("orderNo") != null){ %>
	<label class="valuemedium"><%=orderNo %></label>
	<%}else{ %>
	<label class="valuemedium">-</label>
	<%} %>
	<div class="Clear"></div>
</div>

	<label class="medium">Department</label>
	<select name="departmentId" id="departmentId" onchange="submitProtoAjaxWithDivName('opdSurgery','/hms/hms/fwc?method=showAjaxResponseForSurgeryRequisitionJsp','ajaxResponse');">
    <option value="0">Select</option>
    <%
    	int deptId=0;
	   Iterator itr= departmentList.iterator();
       while(itr.hasNext())
       {
			MasDepartment masDepartment=(MasDepartment) itr.next();
    	   	deptId=masDepartment.getId();
    	   	System.out.println("deptId :"+deptId);
    	   	String deptName=masDepartment.getDepartmentName();
	%>
    <option value="<%=deptId %>"><%=deptName %></option>
    <%
       }
	%>
	  </select>

	  <label class="medium">Prescribed By</label>
	  <label class="valueNoWidth"><%=empName %></label>
	<div id="ajaxResponse">
	  <label class="small">Referred To</label>
			<select name="empId" id="empId ">
		    <option value="0">Select</option>
		    <% for(MasEmployee employee : employeeList){
		    	String doctorName = employee.getFirstName();
		    	if(employee.getMiddleName() != null){
		    		doctorName = doctorName + " " + employee.getMiddleName();
		    	}
		    	if(employee.getLastName() != null){
		    		doctorName = doctorName + " " + employee.getLastName();
		    	} %>
		    <option value="<%=employee.getId()%>"><%=doctorName%></option>
		   <% }%>
		  </select>

		  <label> PAC required </label>
<input	type="checkbox" class="radio2" name="pacRequird" value="y" checked="checked"/>
  	</div>
  	<div class="Clear"></div>
  	  <div class="colA" style="width: 700px; float:left;padding: 10px; 0px; 0px; 0px;margin:  0px; 0px; 0px; 0px;">
		<div class="title">Surgery</div>
		<div class="Clear"></div>


			<!--  <input type="button" class="ButtonDel"  alt="Delete" value=" " onclick="removeRow();" align="right" />
			 <input type="button" class="ButtonAdd"  alt="Add" value=" " onclick="" align="right" />
			  -->
	<div class="Clear"></div>

	<div class="tableHolderAuto" style="width: 700px; float:left;padding: 0px; 0px; 0px; 0px;
										margin:  0px; 0px; 0px; 0px;">

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
		    <input type="text" value="" style="width: 600px;"	tabindex="1" id="chargeCodeName1" size="43"  name="chargeCodeName1"  onblur="if(validateSurgeryForAutoComplete(this.value,'<%=inc %>')){fillChargeCodeId(this.value);}" />
			<div id="ac2update2" style="height: 130px;overflow: scroll;  display:none; border:1px solid #000; "></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
				function eventCallback(element, entry){
					return entry + "&deptId="+document.getElementById("departmentId").value;
				}
				new Ajax.Autocompleter('chargeCodeName1','ac2update2','fwc?method=getChargeCodeListForAutoComplete',{parameters:'requiredField=chargeCodeName1', callback: eventCallback});
			</script>
		   	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
		    </td>
		    <div id="chargeCodeVal">
		    	<input type="hidden" name="chargeCode1" id="chargeCode1" size="10"  />
		    	<input type="hidden" value="" name="<%=CHARGE_CODE_ID%>" id="chargeCodeId" />
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
		<input name="Submit" type="button" align="right" class="button" value="Submit"  onclick="if(checkSubmitSurgery()){submitForm('opdSurgery','fwc?method=submitSurgeryRequisitionDetailsFWC&orderNo=<%=orderNo %>');}" />
		<input name="Back" type="button" alt="Back" value="Back" class="button" onclick="submitForm('opdSurgery','fwc?method=showFWCMainJsp&visitId=<%=visit.getId()%>&deptId=<%=visit.getDepartment().getId()%>');"  align="right"/>

  <input type="hidden" name="visitId" value="<%=visit.getId() %>"/>
  <input type="hidden" name="hinId" value="<%=hinId %>"/>

  <input type="hidden" name="deptId" value="<%=deptId %>"/>
  <input type="hidden" name="date" value="<%=date %>"/>
  <input type="hidden" name="time" value="<%=time %>"/>
  <input type="hidden" name="prescribedDepartmentId" value="<%=prescribedDepartmentId %>"/>
  <input type="hidden" name="userName" value="<%=userName %>"/>

	</form>
	<div class="Clear"></div>
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
	  // alert("iteration row--"+iteration)


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

	  						if(validateSurgeryForAutoComplete(this.value,iteration)){checkForChargeCode(this.value,'iteration','chargeCodeVal'+iteration);}

	  					  };
	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  //alert("name--"+e0.name)
	  e0.size = '43'
	  cellRight1.appendChild(e0);
	new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update2','fwc?method=getChargeCodeListForAutoComplete&deptId='+departmentId,{parameters:'requiredField=chargeCodeName'+iteration});




	  var cellRightSel = row.insertCell(2);
	  cellRightSel.id='chargeCodeVal'+iteration;
	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='chargeCode'+iteration;
	  sel.id='chargeCode'+iteration;
	  sel.size = '10'
	  cellRightSel.appendChild(sel);


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
	      	document.getElementById('chargeCode'+inc).value="";
	      	document.getElementById('clinicalNotes'+inc).value="";
	 	  	document.getElementById('qty'+inc).value="";
	      	return;
		}
		for(i=1;i<inc;i++){
			if(inc != 1){
				if(document.getElementById('chargeCodeName'+i).value==val) {
					alert("Test name already selected...!")
					document.getElementById('chargeCode'+inc).value=""
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

		//ajaxFunctionForAutoCompleteChargeCodeName('orderBooking','lab?method=fillItemsForChargeCode&chargeCode=' +  tempChargeCodeString , inc);
		submitProtoAjaxWithDivNameToShowStatus('opdSurgery','/hms/hms/fwc?method=fillChargeCode&chargeCodeNAmeForAjax='+ tempChargeCodeString+'&rowVal=1',chargeCodeTdDiv);

		}else{
			document.getElementById('chargeCodeName'+inc).value = "";
			document.getElementById('qty'+inc).value = "";
			document.getElementById('chargeCode'+inc).value = "";
			//document.getElementById('qty'+inc).value = "";
			//document.getElementById('qty'+inc).value = "";
		}
	}
	function fillChargeCodeId(val){
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
		   		document.getElementById('chargeCodeName1').value="";
		    	document.getElementById('chargeCodeId').value="";
		   		return;
		   	} else {
	   		      document.getElementById('chargeCodeId').value=chargeCodeId;
	      	}
	 	}
	}
</script>

