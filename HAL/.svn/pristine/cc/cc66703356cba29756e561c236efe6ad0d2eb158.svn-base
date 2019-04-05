<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.MasZonal"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Properties"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js"></script>




<%
String contractCode = "";
String transferedCode = "";
String extentionCode="";
String activeCode="";
String departmentNameToRestrictMalePatient = "";


try {
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	properties.load(resourcePath.openStream());
	contractCode = properties.getProperty("empStatusCodeForContract");			
	extentionCode = properties.getProperty("empStatusCodeForExtention");
	departmentNameToRestrictMalePatient = properties.getProperty("departmentNameToRestrictMalePatient");
	activeCode = properties.getProperty("empStatusCodeForActive");

	
} catch (Exception e) {
	e.printStackTrace();
}
%>
<script>

function changerel(sex, id, src)
{
	document.getElementById("sex").value= sex;
	document.getElementById("reltnId").value= id;
	var serviceNo = document.getElementById("serviceNo").value;	
	submitFormForButton('facPriscription','opd?method=showPatientDirectPrescriptionResponse&serviceNo='+serviceNo+'&relationId='+id);
	/* document.getElementById("tab").click(); */
	/* document.getElementById("dobId").onblur(); */
	/* document.getElementById("photoImageId").setAttribute("src", src);	 */
	
}

function checkStatusDependent(statusName, status, contractDate, extentionDate)
{
	var contractDate = new Date(contractDate);
	var extentionDate = new Date(extentionDate);
	var date = new Date();
	var returnFlag = false;	
	
	contractDate.setHours(0, 0, 0, 0);	
	extentionDate.setHours(0, 0, 0, 0);	
	date.setHours(0, 0, 0, 0);
	
	
	if(status == <%=activeCode%>)
		{
		
		returnFlag = true;
		}
	else if(status == <%=contractCode%>)
		{
		if(date>contractDate)
			{
			alert("Contract has expired");
			returnFlag = false;
			}
		else{
			returnFlag = true;	
		}
		}
	else if(status == <%=extentionCode%>)
	{
		if(date>extentionDate)
		{
		alert("Extension has expired");
		returnFlag = false;
		}
		else{
			returnFlag = true;	
		}
		
	}
	else
	{
		alert(statusName + " Employee");
	returnFlag = false;
	}
	return returnFlag;
}
	
function checkStatusEmp(statusName, status, contractDate, extentionDate)
{
	var contractDate = new Date(contractDate);
	var extentionDate = new Date(extentionDate);
	var date = new Date();
	var returnFlag = false;
	
	contractDate.setHours(0, 0, 0, 0);	
	extentionDate.setHours(0, 0, 0, 0);	
	date.setHours(0, 0, 0, 0);
	
	
	if(status == <%=activeCode%>)
	{
	
	returnFlag = true;
	}
	else if(status == <%=contractCode%>)
		{
		
		if(date>contractDate)
			{
			alert("Contract has expired");
			returnFlag = false;
			}	
		else
			{
			returnFlag = true;
			}
		}
	else if(status == <%=extentionCode%>)
	{
		
		alert("Employee has been transferred");
		returnFlag = false;
		
		
	}
	else
	{
		alert(statusName + " Employee");
	returnFlag = false;
	}
	return returnFlag;
	
}

	 function validateMetaCharacters(val){
		if(val!=''){document.getElementById("prescription").style.display='Block';
		return true;
		}else{
			document.getElementById("prescription").style.display='none';
			return false;
		} 
	}
	 function fillDiagnosisCombo(val) {
	  	  var index1 = val.lastIndexOf("[");
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var id = val.substring(index1,index2);
		    if(id ==""){
			  return;
			}else{
			   		obj =document.getElementById('diagnosisId');
					obj.length = document.getElementById('diagnosisId').length;
                   var valu=obj.options[obj.length-1].value;
					var b="false";
					for(var i=1;i<obj.length;i++){
							    
		                    	var val1=obj.options[i].value;
		                    	var length=obj.length-1;
                               	
		                    	if(id==val1)
		                    	{
		                        	alert("ICD  Already taken");
		                        	document.getElementById('icd').value =""
		                        	b=true;
		                       	}
		                              	
		                    }
                   
		                    if(b=="false")
		                    {
		                    	obj.length++;
		    					obj.options[obj.length-1].value=id
		    					obj.options[obj.length-1].text=val
		    					obj.options[obj.length-1].selected=true
		    					document.getElementById('icd').value =""
		    			                    
		                    }
				}
	  }
	 var icdArray=new Array();
	   var itemClassCodeArray = new Array();
</script>

<%

String []ItemClassCodeForLiquid = HMSUtil.getProperties("adt.properties", "ItemClassCodeForDrop").trim().split(",");
for(int i=0;i<ItemClassCodeForLiquid.length;i++)
{
%>
<script>

itemClassCodeArray[<%=i%>]= new Array();
itemClassCodeArray[<%=i%>][0] = "<%=ItemClassCodeForLiquid[i]%>";

			
    </script>
<%	}
		Map map = new HashMap();
		if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		}
		List templateList= new ArrayList();
		/* List<MasEmployee> employees = new ArrayList<MasEmployee>(); */
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasZonal> masZonal = new ArrayList<MasZonal>();
		String flag = "none";
		String patientName = "none";
		String gender = "---";
		String dob = "---";
		String serviceNo = "";
		String age = "";
		int employeeId = 0;
		int hinId =0;
		if(map.get("templateList") != null){
		templateList=(List)map.get("templateList");
		}
		if(map.get("patientList") != null){
			patientList=(List<Patient>)map.get("patientList");
		}
		if(map.get("masZonal") != null){
			masZonal=(List<MasZonal>)map.get("masZonal");
		}
		if(patientList.size()>0){
			flag = "Block";
			patientName = patientList.get(0).getPFirstName()+" "+patientList.get(0).getPMiddleName()!=null?patientList.get(0).getPMiddleName()+" ":""+patientList.get(0).getPLastName()!=null?patientList.get(0).getPLastName():"";
			gender = patientList.get(0).getSex().getAdministrativeSexName();
			dob = HMSUtil.getDateFormat(patientList.get(0).getDateOfBirth(), "dd/MM/yyyy");
			serviceNo = patientList.get(0).getServiceNo();
			age = HMSUtil.calculateAge(patientList.get(0).getDateOfBirth());
			employeeId = patientList.get(0).getId();
			if(map.get("hinId")!=null){
				hinId = (Integer)map.get("hinId");
			}
			
			
		}
		String msg = "";
		if(map.get("msg")!=null){
			msg = (String)map.get("msg");
		}
		int visitId = 0;
		if(map.get("visitId")!=null){
			visitId = (Integer)map.get("visitId");
		}
		String hinNo = "";
		if(map.get("hinNo")!=null){
			hinNo = (String)map.get("hinNo");
		}
		List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
		if(map.get("frequencyList") != null){
		frequencyList=(List)map.get("frequencyList");
		}
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		InputStream in = resourcePath.openStream();
		Properties prop = new Properties();
		prop.load(in);
		String familyHistoryCode = null;
		String complaintHistoryCode = null;
		try
		{
			  prop.load(resourcePath.openStream());
			  familyHistoryCode = prop.getProperty("templateCodeForFamilyHistory");
			  complaintHistoryCode = prop.getProperty("templateCodeForComplaintHistory");
		}
		catch (Exception e)
		{ e.printStackTrace();}
%>
<form name="Print" id="Print" method="post" >
<div class="clear"></div>
<%if(msg!=""){if(msg=="Try Again!"){out.write("<div class='alertDiv'>"+msg+"</div>");}else{out.write("<div class='successDiv'>"+msg+"</div>");}} %>

<%
if(visitId !=0)
{
	%>
		 <input name="OK" value="Print Prescription" class="button" onclick="generateReport();" type="button"> 
	<%
}
%>


</form>

<form name="facPriscription" id="facPriscription" method="post" action="showPatientDirectPrescriptionResponse">
<div class="clear"></div>
<div class="titleBg">
<h2>FAC Prescription</h2>
</div>
<div class="clear"></div>

<!-- <ul id="countrytabsIn" class="shadetabsIn">
	<label><a href="#"  rel="country1" class="selected" ><span  >Employee Personnel Details</span></a></label>
	<label><a href="#" id ="tab" rel="country2"><span > Patient Details </span></a></label>
	
	<div id="srPhoto" class="photo">
	<div class="clear"></div>
	<img src="/hms/jsp/images/na.jpg" name="img1" width="105" height="80" id="img1" />
	<span style="color:#ddd">Date/ Time</span>
	</div>
</ul> -->


<input type="hidden" name="employeeId" value="<%=employeeId %>" />
<div class="clear"></div>
<div class="tabcontainerIn">
<div id="" class="">
<div class="Block">

<div class="clear"></div>
<label>Employee No. </label>

<%-- <input type="text" id="serviceNo" name="<%=SERVICE_NO%>" value="<%=serviceNo %>"	 MAXLENGTH="30"	onblur="if(this.value!='' ){document.getElementById('facPriscription').setAttribute('action', 'opd?method=showPatientDirectPrescription');document.getElementById('facPriscription').submit();}" /> --%>
<input type="text" id="serviceNo" name="<%=SERVICE_NO%>" value="<%=serviceNo %>"	 MAXLENGTH="30"	onblur="if(this.value!='' ){submitProtoAjaxNew('facPriscription','/hms/hms/registration?method=getServiceNoDetailsForFAC&serviceNo='+this.value,'depenedentDiv');}" />
<div id="depenedentDiv">
</div>
</div>
</div>
<div id="" class="">
<div class="Block">
<div id="hinDiv" style="display: <%=flag %>" >
<label> Patient Name </label>
<label class="value"> <%=patientName %> </label>
<label> Gender </label>
<label class="value"> <%=gender %> </label>
<div class="clear"></div>
<label> DOB </label>
<label class="value"> <%=dob %> </label>
<label> Age </label>
<label class="value"> <%=age %> </label>
</div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div style="display: <%=flag %>" id="prescription">
<div class="clear"></div>
<div class="Block">
<label>Zonal Name </label>
<select id="masZonal" name="masZonal">

<option value="0">Select</option>
<%

for(MasZonal list: masZonal)
{
	%>
		<option value="<% out.print(list.getId()); %>"><% out.print(list.getZonalName()); %></option>
	<%
}
%>
</select>
<div class="clear"></div>
</div>
<h4>Diagnosis</h4>
<div class="clear"></div>

<div class="Block">

<div class="leftDivblock">
<div class="clear"></div>
<label>Present Complaint <span>*</span></label>
<div class="clear"></div>
<div class="clear"></div>
<textarea class="auto" style="width:360px; height:103px;" name="presentComplain" id="presentComplain" tabindex="1" validate="Present Complaint,string,yes" cols="0" rows="0" maxlength="300"></textarea>
<input class="button" tabindex="3" name="" value="+" onclick="getPresentTemplate('CH');" type="button">
</div>

<div class="leftDivblock" style="margin-left:50px;">
<input id="systamicExam" class="large" name="systamicExam" maxlength="200" type="hidden">

<div class="clear"></div>
<label>ICD Diagnosis<span>*</span></label>
<div class="clear"></div>
<input tabindex="1" value="" id="icd" name="icd" class="auto" size="53" onblur="fillDiagnosisCombo(this.value);" autocomplete="off" type="text">
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDList',{parameters:'requiredField=icd'});
		   //document.getElementById('slide0').style.display="hide"
</script>
<select name="diagnosisId" multiple="4" size="5" tabindex="1" id="diagnosisId" class="listBig" validate="ICD Daignosis,string,yes">
	<option value="0">Select</option>
</select>
<input class="buttonDel" value="" onclick="deleteDgItems(this,'diagnosisId');" type="button" align="right">
</div>
</div>

<div class="clear"></div>
<div id="templateDivToShowHide" class="floatLeft">

<div class="Block">
<h4>Treatment</h4>
<%--<div class="Block">
 <label>Template</label>
<div id="treatmentDiv">
<select name="templateId" id="templateId" tabindex="1" onchange="showHideDrugTemplateCombo(this.value);">
	<option value="0">Select</option>
	<%
	   Iterator itr=templateList.iterator();
	   while(itr.hasNext())
	   {
		   OpdTemplate opdTemplate=(OpdTemplate)itr.next();
		   String templateType=opdTemplate.getTemplateType();
		   if(templateType.equalsIgnoreCase("p"))
		   {
	%>
	<option value="<%=opdTemplate.getId()%>"><%=opdTemplate.getTemplateName()%></option>
	<%}}%>
</select>
</div>
<div id="createPresDivToShowHide">
<input 	name="createPrescriptionTemplate" tabindex="1" type="button" value="Create Template"    class="buttonBig" onclick="showCreatePrescriptionTempate();" />
</div>
<div id="prescriptionImportButton" class="floatLeft" >
<input	name="prescriptionImportButton1" tabindex="1" type="button"	value="Import New" class="button"	onclick="getListForTreatment('treatmentDiv');" /> 
</div> 
 </div>--%>
 <div class="floatRight">
				<a href="#"
					onclick="getTodayAllPrescriptionPopup('<%=hinId%>');">Current Medication</a>
			</div>
<div id="testDiv1">
	<div class="cmntable" style="min-height: 85px">
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		 <th>Nomenclature/Material Code</th>
	    <th colspan="1">Other Drug</th>
		<th scope="col">Dispensing Unit</th>
		<th scope="col">Dosage<span>*</span></th>
		<th scope="col">Frequency<span>*</span></th>
		<th scope="col">Days<span>*</span></th>
		<th scope="col">Total<span>*</span></th>
		<th scope="col">Route</th>
		<th scope="col">Remarks</th>
		<th scope="col">Stock</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	<tr>
		<td>
		 <input type="hidden" name="itemId1" id="itemId1" value="" />
	    <input type="text" value="" tabindex="1" id="nomenclature1" size="30"  name="nomenclature1" onblur="checkForAlreadyIssuedPrescription(this.value,'1','0');populatePVMS(this.value,'1');checkItem(1);displayAu(this.value,'1','5555');checkForPurchase(this.value, '1');"  />
	     <div id="ac2update1" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" tabindex="1" charset="utf-8">
//			  new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1'});
			   new Ajax.Autocompleter('nomenclature1','ac2update','purchaseOrder?method=getItemListForPurchaseOrderForFAC',{parameters:'requiredField=nomenclature1'});
			</script>
		</td>
		<td><input type="text" name="otherMedicine1" tabindex="1" id="otherMedicine1"  size="20" onblur="checkDuplicateOtherMedicine(this.value,'1');readOnlyNomenclature(this.value,'1');showSimilarMedicineNames(this.value);" validate="other Medicine,string,no" readonly="readonly"/></td>
		<td><input type="text" name="dispensingUnit1" tabindex="1" id="dispensingUnit1"  size="6"  validate="AU,string,no"  readonly="readonly"/>
		<input type="hidden" name="au1" tabindex="1" value="" id="au1"
							size="6" validate="AU,string,no" /> <input type="hidden"
							name="actualDispensingQty1" tabindex="1"
							id="actualDispensingQty1" value="" size="6"
							validate="AU,string,no" /> 
							<input type="hidden" tabindex="1"
							id="itemClassCode1" name="itemClassCode1"
							validate="itemClassCode,string,no" value="" />
		<input type="hidden" tabindex="1" id="highValueMedicine1" name="highValueMedicine1" validate="AU,string,no" value=""/>  
		<td><input type="hidden" name="pvmsNo1" tabindex="1" id="pvmsNo1"	size="10" readonly="readonly" />
		<input type="text" name="dosage1" tabindex="1" value="" id="dosage1"	size="5" maxlength="5" onblur="checkDosageValidation(this.value,'1');fillValue('1')" /></td>
		<td><select name="frequency1" id="frequency1" tabindex="1" class="medium" onchange="getFrequencyValue(this.value,'1');fillValueFromFrequency(this.value,'1');displaySOSQty(this.value,'1');fillValue('1')" >
			<option value="0">Select</option>
			<%
		      for(MasFrequency masFrequency : frequencyList){
		       int id = masFrequency.getId();
		       String name = masFrequency.getFrequencyName();
          %>
			<option value="<%=id %>"><%=name%></option>
			<%} %>
		</select> <%
	    		MasFrequency  masFrequency = new MasFrequency();
			     for (int i = 0; i < frequencyList.size(); i++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(i);
     			 %> <script>
	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <% }%>
            <input type="hidden" name="frequencyValue1" id="frequencyValue1" value="">
            <input type="text" name="sosQty1" tabindex="1" id="sosQty1" style="display: none;"   size="3" onblur="fillValue('1')"	maxlength="3" validate="Sos Qty,num,no" />
		</td>
		<td><input type="text" name="noOfDays1" tabindex="1" id="noOfDays1" onblur="fillValue('1')"  size="3"	maxlength="3" validate="No of Days,num,no" /></td>
			<td>	<input type="text" name="total1" tabindex="1" id="total1" validate="total,num,no"/></td>
		<td><input type="text" name="route1" tabindex="1" id="route1" value=""  size="5" maxlength="20"	 validate="Route,string,no" />
		
		</td>
	
		<td><input type="text" name="remarks1" tabindex="1" id="remarks1" size="10" maxlength="40"/></td>
		<td><input type="text" name="closingStock1" tabindex="1" value="" id="closingStock1"  size="3"  validate="closingStock,string,no" /></td>
		<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> </td>
		<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grid','hdb',this);" tabindex="1" /></td>
	</tr>
	<input type="hidden" name="hdb" value="1" id="hdb" />
</table>
<div class="clear"></div>
</div>
</div>
</div>
</div>

<div class="clear"></div>
<h4>Investigation1</h4>
	<div class="Block">
		<div id="gridview">
			<table border="0" align="center" cellpadding="0" cellspacing="0"
				id="investigationGrid">
				<tr>
					<td colspan="3">
						<div class="floatleft">
							<input type="radio" value="Lab" class="radioCheckCol2"
								style="margin-right: 5px;" name="labradiologyCheck"
								checked="checked" onchange="" />
							<div class="labRadiologyDivfixed">LAB</div>
							<input type="radio" value="Radio" class="radioCheckCol2"
								style="margin-right: 5px;" name="labradiologyCheck" onchange="" />
							<div class="labRadiologyDivfixed">Radiology</div>
							<input type="hidden" name="investigationCategory"
								id="investigationCategory" />
							<div class="clear"></div>
						</div>
					</td>
				</tr>
				<tr>
					<th scope="col">Investigation</th>
					<!-- <th scope="col">Refer to MH</th> -->
					<th scope="col">Add</th>
					<th scope="col">Delete</th>
				</tr>


				<%int inc=1;
			String investigationName = "";
	%>

				<tr>
					<td><input type="text" value="<%=investigationName %>"
						tabindex="1" id="chargeCodeName<%=inc %>" size="100"
						name="chargeCodeName<%=inc %>"
						onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
						<div id="ac2update2" style="display: none;" class="autocomplete"></div>
						<%-- <script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName<%=inc %>&labradiologyCheck='+ document.getElementById('investigationCategory').value});
				</script>  --%> <script type="text/javascript" language="javascript"
							charset="utf-8">
						  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{
							  callback: function(element, entry) {
						            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
						        },
							  parameters:'requiredField=chargeCodeName<%=inc %>'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
						size="10" maxlength="6" validate="Qty,num,no" /> <input
						type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1"
						size="10" readonly /> <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

					</td>

					<%-- <td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td> --%>

					<td><input name="Button" type="button" class="buttonAdd"
						value="" tabindex="1" onclick="addRowForInvestigation();" /></td>
					<td><input type="button" name="delete" value=""
						class="buttonDel" tabindex="1"
						onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>
				</tr>

				<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />

			


			</table>
		</div>
		<div class="clear paddingTop15"></div>
	
	</div>

<div class="division"></div>
	<input type="button" name="Submit" value="Submit" class="button" onClick="if(validateFrequency()){submitForm('search','opd?method=saveDirectPrescription');}" />
	<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
</div>
<div class="clear"></div>
<div class="clear"></div>

</div></div>
</form>

<script>
function addRow(){
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = 'nomenclature' + iteration;
	  e0.id = 'nomenclature' + iteration;
	  e0.onblur=function(){
	                       var val=e0.value
	                       if(val != "")
							{
						    var index1 = val.lastIndexOf("[");
						    var indexForPvms=index1;
						    var index2 = val.lastIndexOf("]");
						    index1++;
						    var pvmsNo = val.substring(index1,index2);
						    var indexForPvms=indexForPvms--;
						    var nomenclature=val.substring(0,indexForPvms);

						   	if(pvmsNo =="")
						    {
						    		document.getElementById('nomenclature'+iteration).value="";
	   								document.getElementById('pvmsNo'+iteration).value="";
						     return;
						    }
						    else
	      						document.getElementById('pvmsNo'+iteration).value=pvmsNo
	      						checkItem(iteration);checkForAlreadyIssuedPrescription(this.value,iteration,'0');displayAu(this.value,iteration,'0');checkForPurchase(this.value, iteration);
						   }
	  					  };
	  
	  					var newdiv = document.createElement('div');
	  		     	    newdiv.id='ac2update'+iteration;
	  		     	    newdiv.className='autocomplete';
	  		       	newdiv.style.display = 'none';
	  		          e0.size = '30';
	  			        e0.setAttribute('tabindex','1');

	  				var e01 = document.createElement('input');
	  			  e01.type = 'hidden';
	  			  e01.name = 'itemId' + iteration;
	  			  e01.id = 'itemId' + iteration;
	  			  e0.focus();
	  			  cellRight0.appendChild(e0);
	  			  cellRight0.appendChild(e01);
	  			  cellRight0.appendChild(newdiv);
	  
	 new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'purchaseOrder?method=getItemListForPurchaseOrderForFAC',{parameters:'requiredField=nomenclature'+iteration});
	 
	 var cellRight1 = row.insertCell(1);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.name='otherMedicine'+iteration;
	  e11.id='otherMedicine'+iteration
	  e11.size='20';
	  e11.readOnly=true;
	  e11.setAttribute('tabindex','1');
	  e11.onblur=function(){if(this.value!=''){checkDuplicateOtherMedicine(this.value,iteration);readOnlyNomenclature(this.value,iteration);showSimilarMedicineNames(this.value)}};
	  cellRight1.appendChild(e11);

	  var cellRight3 = row.insertCell(2);
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='actualDispensingQty'+iteration;
	  e1.id='actualDispensingQty'+iteration
	  e1.size='6';
	  e1.setAttribute('tabindex','1');
	 
	  //added by Babita
	  
	  
	  
	  var e15 = document.createElement('input');
	  e15.type = 'hidden';
	  e15.name='highValueMedicine'+iteration;
	  e15.id='highValueMedicine'+iteration
	  e15.size='1';
	  e15.setAttribute('tabindex','1');
	  cellRight3.appendChild(e15);
	  
	  var e016 = document.createElement('input');
	  e016.type = 'hidden';
	  e016.name='itemClassCode'+iteration;
	  e016.id='itemClassCode'+iteration
	  e016.size='6';
	  e016.setAttribute('tabindex','1');
	  cellRight3.appendChild(e016);
	  
	  //end
	  var e13 = document.createElement('input');
	  e13.type = 'text';
	  e13.name='dispensingUnit'+iteration;
	  e13.id='dispensingUnit'+iteration
	  e13.readOnly=true;
	  e13.size='6';
	  e13.setAttribute('tabindex','1');
	  //e12.onblur=function(){displayAU(this.value,iteration)};
	  cellRight3.appendChild(e13);

	 
	  cellRight3.appendChild(e1);
	  
	  var cellRight4 = row.insertCell(3);
	  var e14 = document.createElement('input');
	  e14.type = 'text';
	  e14.name='dosage'+iteration;
	  e14.id='dosage'+iteration
	  e14.size='5';
	  e14.setAttribute('maxlength', 5); 
	  e14.setAttribute('tabindex','1');
	  e14.onblur = function(){checkDosageValidation(this.value,iteration);fillValue(iteration)};
	  cellRight4.appendChild(e14);
	  
	  

	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='pvmsNo'+iteration;
	  sel.id='pvmsNo'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight4.appendChild(sel);
	
	 
	//  var cellRightSel = row.insertCell(2);
	 
	  var cellRight5 = row.insertCell(4);
	  var e2 = document.createElement('Select');
	  e2.name='frequency'+iteration;
	  e2.id='frequency'+iteration;
	  e2.className='medium';
	  //e2.class = 'medium';
	  e2.setAttribute('tabindex','1');
	  e2.options[0] = new Option('Select', '0');
	  e2.onblur=function(){getFrequencyValue(this.value,iteration);fillValueFromFrequency(this.value,iteration);displaySOSQty(this.value,iteration);fillValue(iteration)};
	    for(var i = 0;i<icdArray.length;i++ ){
	      e2.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	      } 
	  cellRight5.appendChild(e2);
	  var e52 = document.createElement('input');
		e52.type = 'text';
		e52.name='sosQty'+iteration;
		e52.id='sosQty'+iteration;
		e52.tabIndex='1';
		e52.size='3';
		e52.style.display='none';
		e52.setAttribute('maxlength', 3); 
	    e52.onblur=function(){fillValue(iteration)};
		cellRight5.appendChild(e52);

	  var e21 = document.createElement('input');
	  e21.type = 'hidden';
	  e21.name='frequencyValue'+iteration;
	  e21.id='frequencyValue'+iteration;
	  e21.size='5';
	  e21.setAttribute('tabindex','1');
	  cellRight5.appendChild(e21);
	  	  
	  var cellRight6 = row.insertCell(5);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='noOfDays'+iteration;
	  e4.id='noOfDays'+iteration;
	  e4.size='5';
	  e4.setAttribute('maxlength', 3); 
	  e4.setAttribute('tabindex','1');
	  e4.setAttribute('validate','No. of Days,int,no');
	  e4.onblur=function(){fillValue(iteration)};
	  cellRight6.appendChild(e4);


	  var cellRight7 = row.insertCell(6);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name='total'+iteration;
	  e5.id='total'+iteration;
	  e5.setAttribute('validate','total,num,no');
	  e5.size='5';
	  e5.setAttribute('tabindex','1');
	  cellRight7.appendChild(e5);
	  
		var cellRight8 = row.insertCell(7);
		var e6 = document.createElement('input');
		e6.type = 'text';
		e6.name='route'+iteration;
		e6.id='route'+iteration
		e6.size='5';
		e6.value=''
		e6.setAttribute('maxlength', 20); 
		e6.setAttribute('tabindex','1');
		cellRight8.appendChild(e6);

	  var cellRight9 = row.insertCell(8);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.name='remarks'+iteration;
	  e7.id='remarks'+iteration
	  e7.size='10';
	  e7.setAttribute('maxlength', 40); 
	  e7.setAttribute('tabindex','1');
	  cellRight9.appendChild(e7);

	  var cellRight11 = row.insertCell(9);
	  var e72 = document.createElement('input');
	  e72.type = 'text';
	  e72.name='closingStock'+iteration;
	  e72.id='closingStock'+iteration
	  e72.size='3';
	  e72.setAttribute('tabindex','1');
	  cellRight11.appendChild(e72);

	  var cellRight12 = row.insertCell(10);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonAdd';
	  e8.name='remarks'+iteration;
	 // e8.setAttribute('onClick', 'addRow();'); 
	  e8.onclick = function(){addRow();}; 
	  e8.setAttribute('tabindex','1');
	  cellRight12.appendChild(e8);

	  var cellRight13 = row.insertCell(11);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonDel';
	  e9.name='remarks'+iteration;
	  //e9.setAttribute('onClick', 'removeRow("grid","hdb",this);');
	  e9.onclick = function(){removeRow("grid","hdb",this);};  
	  e9.setAttribute('tabindex','1');
	  cellRight13.appendChild(e9);
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
		
		function populatePVMS(val,inc){
			if(val != "")
			{
			    var index1 = val.lastIndexOf("[");
			    var indexForBrandName=index1;
			    var index2 = val.lastIndexOf("]");
			    index1++;
			    var pvmsNo = val.substring(index1,index2);
			    var indexForBrandName=indexForBrandName--;
			    var brandName=val.substring(0,indexForBrandName);
			if(pvmsNo == "")
			  {
			   	document.getElementById('nomenclature'+inc).value="";
			    document.getElementById('pvmsNo'+inc).value="";
			   return;
			   }
			   else
			      document.getElementById('pvmsNo'+inc).value=pvmsNo
			 }
		}
		
	/* 	function disableOtherMedicine(val,inc){
		  if(val != "")
				{
			   document.getElementById('otherMedicine'+inc).disabled = true;		
			   document.getElementById('otherMedicine'+inc).value ="";
			}else{
					document.getElementById('otherMedicine'+inc).disabled = false;
				}
			} */
		
function validateFrequency(){
			var count = document.getElementById('hdb').value;
			for(var i = 1; i <= count;i++){
				//var nomenclature = document.getElementById('nomenclature'+i).value;
				if(document.getElementById('nomenclature'+i)){
				if(document.getElementById('nomenclature'+i).value != ''){
					if(document.getElementById('frequency'+i)){
					if(document.getElementById('frequency'+i).value == '0'){
						alert('Please select frequency.');
						return false;
					  }
					 }
		            if(document.getElementById('dosage'+i)){
					if(document.getElementById('dosage'+i).value == ''){
						alert('Please Enter dosage.');
						return false;
					 }
					}
					if(document.getElementById('frequency'+i).value != '13'){
					if(document.getElementById('noOfDays'+i)){
					if(document.getElementById('noOfDays'+i).value == ''){
						alert('Please Enter No. of Days.');
						return false;
					 }
					 }
					}else{
						if(document.getElementById('sosQty'+i)){
							if(document.getElementById('sosQty'+i).value == ''){
								alert('Please Enter SOS Qty.');
								return false;
							 }
							 }
					}
					if(document.getElementById('noOfDays'+i)){
					if(document.getElementById('noOfDays'+i).value!="")
					{
					if( isNaN(document.getElementById('noOfDays'+i).value))
			    	{
						document.getElementById('noOfDays'+i).value =""; //Babita
			        	alert("No. of Days should be a number");
			        	return false;
			    	 }
					 }
				   }
			 }
			}
			return true;
		}
}

/* function checkItem(iteration){
	var pvmsNo='';
	if(document.getElementById("pvmsNo"+iteration))
		pvmsNo = document.getElementById("pvmsNo"+iteration).value;
	var nomenclature = '';

	if(document.getElementById("nomenclature"+iteration))
		nomenclature = document.getElementById("nomenclature"+iteration).value

	var visitId=0;
	if(document.getElementById("visitId"))
		visitId = document.getElementById("visitId").value
	var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
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
	      if(xmlHttp.readyState==4){

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var bedStatus  = item.getElementsByTagName("bedStatus")[0];
		         if(bedStatus.childNodes[0].nodeValue=='yes'){
		           	alert("This Drug is Alergic for this patient..!")
		        if(document.getElementById("nomenclature"+iteration))
		        	document.getElementById("nomenclature"+iteration).value = ""
	       		if(document.getElementById("pvmsNo"+iteration))
	       			document.getElementById("pvmsNo"+iteration).value= ""
		       	pvmsNo=pvmsNo.childNodes[0].nodeValue
		       return true
		       }else{
	    	   if(document.getElementById("visitId"))
	    		   document.getElementById("visitId").selectedIndex=0
		        pvmsNo=0
		       	return false;
		       }

	      	}
	      	
	      }
	      
	      }
	  	  checkForNomenclature(nomenclature,iteration)
	    var url="/hms/hms/opd?method=checkItem&pvmsNo="+pvmsNo+"&visitId="+visitId
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	} */
	
/* function displayAu(val, inc, hinId) {
	if (val != "") {

		var index1 = val.lastIndexOf("[");
		var indexForBrandName = index1;
		var index2 = val.lastIndexOf("]");
		index1++;
		var pvmsNo = val.substring(index1, index2);
		var indexForBrandName = indexForBrandName--;
		var brandName = val.substring(0, indexForBrandName);
		if (pvmsNo == "") {
			document.getElementById('nomenclature' + inc).value = "";
			document.getElementById('pvmsNo' + inc).value = "";
			return;
		} else
			var xmlHttp;
		try {
			// Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			// Internet Explorer
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				alert(e)
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					alert("Your browser does not support AJAX!");
					return false;
				}
			}
		}

		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				var items = xmlHttp.responseXML.getElementsByTagName('items')[0];
				for (loop = 0; loop < items.childNodes.length; loop++) {
					var item = items.childNodes[loop];

					var au = item.getElementsByTagName("au")[0];
					var actualDispensingQty = item
							.getElementsByTagName("actualDispensingQty")[0];
					var stock = item.getElementsByTagName("stock")[0];

					if (document.getElementById('au' + inc)
							&& au.childNodes[0] != undefined) {
						document.getElementById('au' + inc).value = au.childNodes[0].nodeValue;
					}
					if (document.getElementById('closingStock' + inc)
							&& stock.childNodes[0] != undefined) {
						document.getElementById('closingStock' + inc).value = stock.childNodes[0].nodeValue;
						if (stock.childNodes[0].nodeValue == 0) {
							alert("Stock is not available...");
						}
					} else {
					}
					if (document.getElementById('actualDispensingQty' + inc)) {
						if (actualDispensingQty.childNodes[0] != undefined) {
							document
									.getElementById('actualDispensingQty' + inc).value = actualDispensingQty.childNodes[0].nodeValue;
						} else {
							document
									.getElementById('actualDispensingQty' + inc).value = 0;

						}
					}
					var dangerousDrug = item
							.getElementsByTagName("dangerousDrug")[0];
					if (dangerousDrug.childNodes[0] != undefined
							&& dangerousDrug.childNodes[0].nodeValue == 'y') {
						alert("This drug is dangerous.");
					}

					var highValueMedicine = item
							.getElementsByTagName("highValueMedicine")[0];
					if (highValueMedicine.childNodes[0] != undefined
							&& highValueMedicine.childNodes[0].nodeValue == 'y') {
						document.getElementById('highValueMedicine' + inc).value = 'y';
						checkHighValueMedicine(pvmsNo, inc, hinId);
					} else {
						document.getElementById('highValueMedicine' + inc).value = 'n';
					}

				}
			}
		}
		var url = "/hms/hms/opd?method=displayAU&pvmsNo=" + pvmsNo;
		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
	}
} */
function getFrequencyValue(feqValue,inc){
	var feqQty;
<%
if(frequencyList.size()>0){	
	for(MasFrequency masFrequency1 :frequencyList){
%>
 if(feqValue == '<%=masFrequency1.getId()%>'){
	 feqQty = '<%=masFrequency1.getFeq()%>'
	
  }

<%}
}%>
 document.getElementById('frequencyValue'+inc).value = feqQty;
}


function addRowForInvestigation(){

	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration
	  // alert("iteration row--"+iteration)
  
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){
	  						if(validateInvestigationAutoComplete(this.value,iteration)){checkForChargeCode(this.value,iteration,'chargeCodeVal'+iteration);}
	  					  };
	   var newdiv1 = document.createElement('div');
	  newdiv1.id='ac2update'+iteration;
	  newdiv1.className='autocomplete';
	  newdiv1.style.display = 'none';
	  					
	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  e0.setAttribute('tabindex','1');
	  //alert("name--"+e0.name)
	  e0.size = '100'
	  cellRight0.appendChild(newdiv1);
	  
	  cellRight0.appendChild(e0);
	  e0.focus();
	
	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update'+iteration,'opd?method=getInvestigationListForAutoComplete',{callback: function(element, entry) { return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;},parameters:'requiredField=chargeCodeName'+iteration});	  var sel = document.createElement('input');
	  																																								
	  sel.type = 'hidden';
	  sel.name='chargeCode'+iteration;
	  sel.id='chargeCode'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight0.appendChild(sel);

	  var e2 = document.createElement('input');
	  e2.type = 'hidden';
	  e2.name='qty'+iteration;
	  e2.id='qty'+iteration
	  e2.size='10';
	  e2.setAttribute('tabindex','1');
	  cellRight0.appendChild(e2);
	
	 var cellRight2 = row.insertCell(1);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonAdd';
	  e4.value = "";
	  e4.name='Button';
	  e4.setAttribute('tabindex','1');
	  //e4.setAttribute('onClick','addRowForInvestigation();');
	  e4.onclick = function(){addRowForInvestigation();}; 
	  cellRight2.appendChild(e4);

	  var cellRight3 = row.insertCell(2);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonDel';
	  e5.value = ""
	  e5.name='delete';
	  e5.setAttribute('tabindex','1');
	  e5.onclick = function(){removeRow("investigationGrid","hdb",this);}; 
	  cellRight3.appendChild(e5);
	  
	  
	}
	
	function generateReport()
	
	{
		var hinNo='<% out.print(hinNo);%>';
		var visitId=<% out.print(visitId);%>;
		var url ="opd?method=printPatientPrescriptionReport&hinNo="+hinNo+"&visitId="+visitId;
		submitForm('Print',url);
	}
</script>



