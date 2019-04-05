<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import = "static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasReference"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>

<form name="cardicClaimAdvance" method="post" action=""><script>
function checkSpecialChar(){
var treatment;
	 treatment = document.getElementById('treatment').value;
	  var cdaPay ;
	 cdaPay= document.getElementById('cdaPay').value;
	  var mark ;
	 mark= document.getElementById('mark').value;
	  var dgmsTo ;
	 dgmsTo= document.getElementById('dgmsTo').value;
	   var copyTo1 ;
	 copyTo1= document.getElementById('copyTo1').value;
	  var copyTo2 ;
	 copyTo2= document.getElementById('copyTo2').value;
	  var copyTo3 ;
	 copyTo3= document.getElementById('copyTo3').value;
	 
	 if(treatment.match("\"")|| cdaPay.match("\"")|| dgmsTo.match("\"")|| copyTo1.match("\"")|| copyTo2.match("\"")|| copyTo3.match("\"")|| mark.match("\"")){
	 alert('Please Do not enter " as Entry field')
	 document.getElementById('treatment').value=""
	  document.getElementById('cdaPay').value=""
	   document.getElementById('mark').value=""
	    document.getElementById('dgmsTo').value=""
	     document.getElementById('copyTo1').value=""
	      document.getElementById('copyTo2').value=""
	       document.getElementById('copyTo3').value=""
	 
	 return false;
	 }else if(treatment.match("\<")|| cdaPay.match("\<")|| dgmsTo.match("\<")|| copyTo1.match("\<")|| copyTo2.match("\<")|| copyTo3.match("\<")|| mark.match("\<")){
	 alert('Please Do not enter < as Entry field')
	 document.getElementById('treatment').value=""
	  document.getElementById('cdaPay').value=""
	   document.getElementById('mark').value=""
	    document.getElementById('dgmsTo').value=""
	     document.getElementById('copyTo1').value=""
	      document.getElementById('copyTo2').value=""
	       document.getElementById('copyTo3').value=""
	 return false;
	 }
	 else{
	 return true;
	 }
}

</script> <script type="text/javascript">
		history.forward();
</script> <script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
	var selectedTestType="MEDCLAIMS";
                 function checkedfunctions(){
                           if(document.getElementById('testType1').checked){
                            selectedTestType = document.getElementById('testType1').value;
                           }else{
                             selectedTestType = document.getElementById('testType2').value;
                           }
                              alert("selectedTestType::"+selectedTestType);
                             
                          }
</script> <%
	int pageNo=1;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<Patient> patientList = new ArrayList<Patient>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasReference> hospitalList = new ArrayList<MasReference>();
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	String userName="";
	int hospitalId=0;
	int hinId=0;
	String payableToAmount="";
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
		if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if (session.getAttribute("userName") != null) {
			  userName = (String) session.getAttribute("userName");
			}
		if(map.get("pageNo") != null){
			pageNo=(Integer)map.get("pageNo");
		}
		if(map.get("hospitalList") != null){
			hospitalList= (List)map.get("hospitalList");
		}
		if(map.get("patientList") != null){
			patientList= (List<Patient>)map.get("patientList");
		}
		if(detailsMap.get("employeeList") != null){
			employeeList = (List<MasEmployee>)detailsMap.get("employeeList");
		}
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		%>
<div class="titlebg">
<h2>Cardiac claim for Advance, Undertaking & Willingness Entry</h2>
</div>
<div class="Block">

<input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /> <%
		String entrySeqNo="";
		if(map.get("entrySeqNo") != null){
			entrySeqNo = (String)map.get("entrySeqNo");
		}
%> 
			<label>Entry No</label>
			<input id="entryNoId" type=hidden name="<%=ENTRY_NO %>" value="<%=entrySeqNo %>" title="Entry No"  />
			<label class="value"><%=entrySeqNo %></label>
			
	<label>
Entry Date <span>*</span></label> <input type="text" class="calDate" id="fromDateId"
	name="<%=ENTRY_DATE %>" value="<%=currentDate %>" readonly="readonly"
	MAXLENGTH="30" validate="Entry Date,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.cardicClaimAdvance.<%=ENTRY_DATE%>,event)" />

<div class="Clear"></div>
		<% 
		System.out.println("patientList  "+patientList.size());
		for (Patient patient:patientList) {%> <label>Service No.</label> <label
	class="value"><%=patient.getServiceNo()%></label> <label>HIN</label> <label
	class="value"><%=patient.getHinNo()%></label> <input type="hidden"
	name="<%=HIN_NO %>" value="<%=patient.getHinNo() %>" /> <label>Name</label>
<label class="value"><%=patient.getSFirstName()+" "+patient.getSMiddleName()+" "+patient.getSLastName() %></label>

<div class="Clear"></div>

<label>Rank </label> <%if(patient.getRank() !=null){ %> <label
	class="value"><%=patient.getRank().getRankName()%></label> <%}else{ %> <label
	class="value"> - </label> <%} %> <label>Branch/Trade </label> <%if(patient.getTrade() !=null){ %>
<label class="value"><%=patient.getTrade().getTradeName()%></label> <%}else{ %>
<label class="value"> - </label> <%} %> <label>Unit </label> <%if(patient.getUnit() !=null){ %>
<label class="value"><%=patient.getUnit().getUnitName()%></label> <%}else{ %>
<label class="value"> - </label> <%} %>

<div class="Clear"></div>

<label>Relation </label> <%if(patient.getRelation() !=null){ %> <label
	class="value"><%=patient.getRelation().getRelationName()%></label> <%}else{ %>
<label class="value"> - </label> <%} %> <label>Patient Name</label> <label
	class="value"><%=patient.getPFirstName()+" "+patient.getPMiddleName()+" "+patient.getPLastName() %></label>

<label>PAO <span>*</span></label> <input type="test" name="<%=PAO %>"
	id="<%=PAO %>" onblur="fillpao();" value="" 
	maxlength="75" tabindex="1" validate="PAO,string,yes" /> <%      if(patient.getServiceNo()!=null){
		    payableToAmount=patient.getServiceNo()+" ";
	        }
	        if(patient.getRank()!=null){
	        	payableToAmount +=patient.getRank().getRankName()+" ";
	        }
	        if(patient.getSFirstName()!=null){
	        	payableToAmount +=patient.getSFirstName()+" ";
	        }
	        if(patient.getSMiddleName()!=null){
	        	payableToAmount +=patient.getSMiddleName()+" ";
	        }
	        if(patient.getSLastName()!=null){
	        	payableToAmount +=patient.getSLastName()+" ";
	        }
	        if(patient.getTrade()!=null){
	        	payableToAmount +=patient.getTrade().getTradeName();
	        }
	        int inpatientId =0;
			String flag = "";
			Set<Inpatient> set = new HashSet<Inpatient>();
			set = patient.getInpatients();
			for(Inpatient inpatient : set){
				if(inpatient.getAdStatus().equals("A")){
					inpatientId = inpatient.getId();
				}
%> <input type="hidden" name="<%=INPATIENT_ID %>"
	value="<%=inpatient.getId()%>" /> <input type="hidden"
	name="<%=DEPARTMENT_ID %>"
	value="<%=inpatient.getDepartment().getId() %>" /> <%System.out.println("inpatientId::"+inpatient.getId()); %>

<%}%> <input type="hidden" name="<%=HIN_ID %>"
	value="<%=patient.getId() %>" /> <%System.out.println("::hinId::"+patient.getId()); 

%> <%} %>

<div class="Clear"></div>
</div>

<div class="Clear"></div>

<h4>For Medical Advance</h4>
<div class="Block">

<div class="Clear"></div>
<label>Working Diagnosis<span>*</span></label>
<input type="text" 	tabindex="1" class="" align="right" name="diagnosis"
	onblur="fillcghs();" id="diagnosis" validate="Diagnosis,string,yes" />
	<!-- hide drop-down as discussed with Grijesh Sir -->
<%--<label> Referred To <span>*</span></label> <select
	name="<%= REFERRED_TO %>" validate="Referred To,string,yes" tabindex=1>
	<option value="">Select</option>
	<% 
			  if(hospitalList != null){ 	
				for (MasReference  masReferecne : hospitalList){
				%>
	<option value="<%=masReferecne.getId ()%>"><%=masReferecne.getReferenceName()%></option>

	<%} }%>
</select> --%>

<label> Referred To <span>*</span></label>
<input type="text"  value="" tabindex="1" class="large2"  name="sugestTo" id="sugestTo" validate="SuggestTo,string,yes"   maxlength="30"/>
<div class="Clear"></div>


<label class="large2">
Details of treatment for which medical advance is asked<span>*</span></label> 
<input
	class="" id="treatment" name="<%=DETAILS_OF_TREATMENT %>"
	type="text" value="" validate="Details of treatment,string,yes"
	maxlength="150" 
	onblur="if(fillSrNo){fillChargeId(this.value);}" />

<script type="text/javascript" language="javascript" charset="utf-8">
		function eventCallback(element, entry){
					return entry + "&testType="+selectedTestType; 
				}
				
                          new Ajax.Autocompleter(document.getElementById('treatment'),'ac2update','mediClaim?method=getChargeName',{parameters:'requiredField=<%=DETAILS_OF_TREATMENT %>',callback:eventCallback});
		</script> <input type="hidden" value="" name="chargeCodeId" id="chargeCodeId" />
<label class="auto">ALL Test</label> <input
	type="radio" name="testType" id="testType1" value="ALL"
	onclick="checkedfunctions();" class="radioAuto" /> 
	
<label	class="auto">MedicalClaims Specific Test </label>
<input type="radio" class="radioAuto"  name="testType" id="testType2"	value="MEDCLAIMS" checked="checked" onclick="checkedfunctions();" />

<div class="Clear"></div>
<label class="large2">Specialist Name<span>*</span></label> <select name="<%=SPECIALIST_NAME %>"
	validate="Specialist Name,String,yes">
	<option value="0">Select</option>
	<% 
		for (MasEmployee  obj : employeeList){
			if(obj.getEmpCategory().getEmpCategoryCode() != null){
			if(obj.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
				String doctorMiddleName = "";
				String doctorLastName = "";
				String rankName ="";
				if(obj.getMiddleName() != null){
					doctorMiddleName = obj.getMiddleName();
				}
				if(obj.getLastName() != null){
					doctorLastName = obj.getLastName();
				}
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getFirstName()+" "+doctorMiddleName+" "+doctorLastName%></option>
	<%  } }
	}%>
</select>
<div class="Clear"></div>
<label class="large2" >
Amount as advance(90% of CGHS rates): Rs<span>*</span> </label> <input id="advanceAmount"
	name="<%=ADVANCE_AMOUNT %>" type="text" value=""
	validate="Amount as advance,float,yes" maxlength="8" />

<div class="Clear"></div>
<div class="Clear"></div>
<label class="large2">
Amount qualifying for re-imbursement(as per CGHS rates): Rs<span>*</span></label> <input
	id="qualifyAmount" name="<%=QUALIFYING_RS %>" type="text" value=""
	validate="Amount qualifying,float,yes" maxlength="8" />

<div class="Clear"></div>

<%--<label class="large2" style="width: 400px;">Amount Payable
to(Name of civil hospital)</label> <select name="<%= PAYABLE_TO %>"
	id="<%= PAYABLE_TO %>" tabindex=1>
	<option value="">Select</option>
	<% 
				for (MasReference  masHospital : hospitalList){
				%>

	<option value="<%=masHospital.getId ()%>"><%=masHospital.getReferenceName()%></option>

	<%}%>
</select> --%> 
<label class="large2"> Amount Payable to(Name of civil hospital)</label>
<input type="text" 	tabindex="1" class="" align="right" name="amountPayableToCivilHospital"
	id="amountPayableToCivilHospital" validate="amountPayableToCivilHospital,string,yes" />



<label class="auto">Name of Service Personnel </label> 
<input
	type="checkbox" id="ammoutPayableTo" name="ammoutPayableTo"
	value="<%=payableToAmount %>" onclick="ammountPaybleTo();"
	class="radioAuto" />
<div class="Clear"></div>


<label class="large2" > Name
of CDA/Pay Account office in which individuals CDA account/ IRDA is
maintained<span>*</span></label> <input class="" id="cdaPay" name="<%=CDA_PAY_OFFICE %>"
	type="text" value=""
	validate="Name of CDA/Pay Account office,string,yes" maxlength="20" />

<div class="Clear paddingTop20"></div>
<label> The CGHS code for<span>*</span></label> <input
	id="<%=CGHS_CODE %>" name="<%=CGHS_CODE %>" type="text" value=""
	validate="The CGHS code for,string,yes" maxlength="30" /> <label
	class=""> is <span>*</span></label> <input id="<%=IS1 %>"
	name="<%=IS1 %>" type="text" value="" validate="is,string,yes"
	maxlength="20" />

<div class="Clear"></div>

<label> CGHS rates in<span>*</span> </label> <select
	name="<%=CGHS_RATE%>" validate="CGHS rates in,string,yes">
	<option value="General Ward">General Ward</option>
	<option value="private">Private Ward</option>
	<option value="Semi-Private Ward">Semi-Private Ward</option>
</select> <label class=""> is <span>*</span></label> <input id="is1"
	name="<%=IS2 %>" type="text" value="" validate="is,float,yes"
	maxlength="8" />

<div class="Clear"></div>

<label> Date of retirement<span>*</span></label> <input
	type="text" class="retDate" id="retDateId" name="<%=RETIREMENT_DATE %>"
	value="<%=currentDate %>" MAXLENGTH="10"
	validate="Date of retirement,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.cardicClaimAdvance.<%=RETIREMENT_DATE%>,event)" />

<div class="Clear"></div>

<div class="Clear"></div>


<h4>Undertaking Details</h4>
<div class="Clear"></div>
<label>Basic Pay: Rs </label> <input id="basicPay"
	name="<%=BASIC_PAY %>" type="text" value=""
	validate="Basic pay,float,no" maxlength="8" />

<div class="Clear"></div>

<h4>Undertaking Details</h4>
<div class="Clear"></div>
<label> Identification Mark </label> <input id="mark" class="large"
	name="<%=IDENTIFICATION_MARKS1 %>" type="text" value="" maxlength="30" />

<div class="Clear"></div>
<%int serviceType=((Patient)patientList.get(0)).getRank().getServiceType().getId();
  String dgmsDetails="";
  if(serviceType==1){
	  dgmsDetails ="DGMS(ARMY)";
  }else if(serviceType==2){
	  dgmsDetails="DGMS(AIR)";
  }else if(serviceType==7){
	  dgmsDetails="DGMS(NAVY)";
  }
  System.out.println("serviceType::::"+serviceType);
%>
<h4>DGMS Letter Details</h4>
<div class="Clear"></div>
<label> To <span>*</span> </label> <input id="dgmsTo" class="large"
	name="<%=DGMS_TO %>" value="<%=dgmsDetails %>" type="text" value=""
	validate="To in DGMS,string,yes" maxlength="30" /> <label>
Dispatch Date<span>*</span></label> <input type="text" class="disDate" id="disDateId"
	name="<%=DISPATCH_DATE %>" value="<%=currentDate %>" MAXLENGTH="10"
	validate="Dispatch Date,date,yes" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.cardicClaimAdvance.<%=DISPATCH_DATE%>,event)" />
<div class="Clear"></div>

<label>Copy To <span>*</span></label> <%if(((Patient)patientList.get(0)).getUnit()!=null){ %>
<input id="copyTo1" class="" name="<%=COPY1 %>" type="text"
	value="<%=((Patient)patientList.get(0)).getUnit().getUnitName()%>"
	validate="Copy To,string,yes" maxlength="30" /> <%}else{ %> <input
	id="copyTo1" class="" name="<%=COPY1 %>" type="text" value=""
	validate="Copy To,string,yes" maxlength="30" /> <%} %> <input
	id="copyTo2" class="" name="<%=COPY2 %>" type="text" value=""
	validate="Copy To,string,no" maxlength="30" /> <input id="copyTo3"
	class="auto" size="18" name="<%=COPY3 %>" type="text" value=""
	validate="Copy To,string,no" maxlength="30" />

<div class="Clear"></div>

<h4>Undertaking Details</h4>
<div class="Clear"></div>
<label>CDA Dispatched Date</label> <input type="text" class="calDate"
	id="cdaDispatchDateId" name="<%=CDA_DISPATCH_DATE %>"
	value="<%=currentDate %>" validate="CDA Dispatched Date,date,no "
	MAXLENGTH="10" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.cardicClaimAdvance.<%=CDA_DISPATCH_DATE%>,event)" />

<div class="Clear"></div>
<h4>Unit Details</h4>
<div class="Clear"></div>

<label>To</label> <input type="text" class="large" tabindex="1"
	align="right" name="unit" id="unit" onblur="fillUnitId(this.value);" />
<input type="hidden" value="" name="<%=UNIT_ID%>" id="unitId" />
<div id="ac1update" style="display: none; border: 1px solid #000"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
				
			    new Ajax.Autocompleter(document.getElementById('unit'),'ac1update','mediClaim?method=getUnitName',{parameters:'requiredField=unit'});
			  
    </script> <label>Dispatched Date</label> <input type="text"
	class="dispatchDate" id="dispatchDateId"
	name="<%=UNIT_DISPATCH_DATE %>" value="<%=currentDate %>"
	validate="Disposal Date " MAXLENGTH="10" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.cardicClaimAdvance.<%=UNIT_DISPATCH_DATE%>,event)" />
<div class="Clear"></div>


<label>Sanction Type </label> <select class="small" name="<%=EX_POST%>"
	validate="Ex Post,string,yes">
	<option value="Pre-Post Facto">Pre-Post Facto</option>
	<option value="Ex Post Facto">Ex Post Facto</option>
</select>


</div>

<div class="Clear paddingTop15"></div>
<!--Bottom labels starts-->

<div class="division"></div>
<input type="button" class="button" value="Submit"
	onclick="if(checkSpecialChar())submitForm('cardicClaimAdvance','mediClaim?method=submitCardicClaimAdvance');"
	align="right" /> 
	
<input type="reset" class="button" name="Reset"
	id="reset" value="Reset" onclick="resetClicked('contingentBill');"
	accesskey="r" />

<div class="Clear paddingTop15"></div>
<div class="bottom">
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=currentDate%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>

<div class="Clear"></div>
</div>

</form>

<script type="text/javascript">
function fillSrNo(){

	if(document.getElementById('treatment').value != ""){
		return true ;
	}
		return false ;
}
 function fillChargeId(val){
		if(val != "")
		{
			var index1 = val.lastIndexOf("[");
			var indexForInvestigationName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var chargeId = val.substring(index1,index2);
			var indexForChargeName = indexForChargeName--;
			var ChargeName = val.substring(0,indexForChargeName);
		document.getElementById('chargeCodeId').value = chargeId;
		 
			
}
}

function fillcghs()
{
var diagnosis = document.getElementById('diagnosis').value;
var cghsobj=document.getElementById('<%=CGHS_CODE %>');
cghsobj.value=diagnosis;
}
function fillpao()
{
var pao = document.getElementById('<%=PAO %>').value;
var Apao = document.getElementById('cdaPay');
Apao.value=pao;
}
function ammountPaybleTo(){
var var1=document.getElementById('ammoutPayableTo');

if(var1.checked)
{

document.getElementById('<%= PAYABLE_TO %>').value="";
document.getElementById('<%= PAYABLE_TO %>').disabled=true;
}
else
{

document.getElementById('<%= PAYABLE_TO %>').disabled=false;
}
}

function fillDiagnosisId(val){
		if(val != "")
		{
			var index1 = val.lastIndexOf("[");
			var indexForDiagnosisName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var diagnosisId = val.substring(index1,index2);
			var indexForDiagnosisName = indexForDiagnosisName--;
			var DiagnosisName = val.substring(0,indexForDiagnosisName);
		document.getElementById('diagnosisId').value = diagnosisId;
			
}
}
function fillUnitId(val){
		if(val != "")
		{
			var index1 = val.lastIndexOf("[");
			var indexForUnitName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var unitId = val.substring(index1,index2);
			var indexForUnitName = indexForUnitName--;
			var UnitName = val.substring(0,indexForUnitName);
		document.getElementById('unitId').value = unitId;
			
}
}
</script>