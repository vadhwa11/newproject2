<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MdCardicClaimAdvance"%>
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
	 }else if(treatment.match("\<")|| cdaPay.match("\<")|| dgmsTo.match("\<")|| copyTo1.match("\<")|| copyTo2.match("\<")|| copyTo3.match("\<")|| mark.match("\<"){
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
</script> <%
	int pageNo=1;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	 List<MdCardicClaimAdvance> cardicClaimList = new ArrayList<MdCardicClaimAdvance>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	String userName="";
	int hospitalId=0;
	int hinId=0;
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
		if(map.get("cardicClaimList") != null){
			cardicClaimList= (List<MdCardicClaimAdvance>)map.get("cardicClaimList");
		}
		MdCardicClaimAdvance cardicClaimAdvance = new MdCardicClaimAdvance();
		if(cardicClaimList != null && cardicClaimList.size()>0){
			cardicClaimAdvance = cardicClaimList.get(0);	
		}
		if(cardicClaimAdvance.getHin()!=null){
			hinId = cardicClaimAdvance.getHin().getId();			
		}
		if(map.get("employeeList") != null){
			employeeList = (List<MasEmployee>)map.get("employeeList");
		}
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		String message="";
		if (map.get("message") != null) {
	             message = (String) map.get("message");
	      }
			if(!message.equalsIgnoreCase("")){
				%>
<h2><%=message %></h2>
<%} %>

<div id="contentHolder">
<h6>Cardiac claim for Advance, Undertaking & Willingness Entry</h6>
<div class="Clear"></div>
<div class="blockFrame" id="testDiv"><input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /> <%
		String entrySeqNo="";
		if(map.get("entrySeqNo") != null){
			entrySeqNo = (String)map.get("entrySeqNo");
		}
%> <label>Entry No</label> <input id="entryNoId" type=hidden
	name="<%=ENTRY_NO %>" value="<%=cardicClaimAdvance.getEntryNo() %>"
	title="Entry No" /> <label class="value"><%=cardicClaimAdvance.getEntryNo() %></label>

<label> Entry Date</label> <%if(cardicClaimAdvance.getEntryDate() != null){ %>
<label class="value"><%=HMSUtil.changeDateToddMMyyyy(cardicClaimAdvance.getEntryDate()) %></label>
<%} %>
<div class="Clear"></div>
<label>Service No.</label> <%if(cardicClaimAdvance.getHin()!= null){ %> <label
	class="value"><%=cardicClaimAdvance.getHin().getServiceNo()%></label> <%} %>
<label>HIN</label> <%if(cardicClaimAdvance.getHin()!= null){ %> <label
	class="value"><%=cardicClaimAdvance.getHin().getHinNo()%></label> <%} %>
<label>Name</label> <%if(cardicClaimAdvance.getHin()!= null){ %> <label
	class="value"><%=cardicClaimAdvance.getHin().getSFirstName()+" "+cardicClaimAdvance.getHin().getSMiddleName()+" "+cardicClaimAdvance.getHin().getSLastName() %></label>
<%} %>
<div class="Clear"></div>

<label>Rank </label> <%if(cardicClaimAdvance.getHin().getRank() !=null){ %>
<label class="value"><%=cardicClaimAdvance.getHin().getRank().getRankName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %> <label>Branch/Trade
</label> <%if(cardicClaimAdvance.getHin().getTrade() !=null){ %> <label
	class="value"><%=cardicClaimAdvance.getHin().getTrade().getTradeName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %> <label>Unit </label> <%if(cardicClaimAdvance.getHin().getUnit() !=null){ %>
<label class="value"><%=cardicClaimAdvance.getHin().getUnit().getUnitName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %>

<div class="Clear"></div>

<label>Relation </label> <%if(cardicClaimAdvance.getHin().getRelation() !=null){ %>
<label class="value"><%=cardicClaimAdvance.getHin().getRelation().getRelationName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %> <label>Patient
Name</label> <%if(cardicClaimAdvance.getHin()!= null){ %> <label class="value"><%=cardicClaimAdvance.getHin().getPFirstName()+" "+cardicClaimAdvance.getHin().getPMiddleName()+" "+cardicClaimAdvance.getHin().getPLastName() %></label>
<%} %> <label><span>*</span>PAO </label> <%if(cardicClaimAdvance.getPao()!= null){ %>
<input type="text" name="<%=PAO %>"
	value="<%=cardicClaimAdvance.getPao() %>" validate="PAO,string,yes"
	maxlength="75" /> <%}else {%> <input type="text" name="<%=PAO %>"
	value="" validate="PAO,string,yes" maxlength="75" /> <%} %> <%
	int inpatientId=0;
			Set<Inpatient> set = new HashSet<Inpatient>();
			if(cardicClaimAdvance.getHin()!= null){ 
			set = cardicClaimAdvance.getHin().getInpatients();
		
			for(Inpatient inpatient : set){
				if(inpatient.getAdStatus().equals("A")){
					inpatientId =  cardicClaimAdvance.getHin().getId();
				}
%> <input type="hidden" name="<%=INPATIENT_ID %>"
	value="<%=cardicClaimAdvance.getInpatient().getId()%>" /> <input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=cardicClaimAdvance.getInpatient().getDepartment().getId() %>" />


<input type="hidden" name="<%=HIN_ID %>"
	value="<%=cardicClaimAdvance.getHin().getId() %>" /> <%}  }%> <input
	type="hidden" name="cardicAdvanceId"
	value="<%=cardicClaimAdvance.getId() %>" id="cardicAdvanceId" /></div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<!--Block Two Starts-->
<div class="blockFrame">
<div class="Clear"></div>
<label><span>*</span> Diagnosis </label> <%if(cardicClaimAdvance.getDiagnosis()!= null){%>
<input type="text" tabindex="1" name="diagnosis" class="large2"
	value="<%=cardicClaimAdvance.getDiagnosis().getIcdName() %>"
	id="diagnosis" onblur="fillDiagnosisId(this.value);"
	validate="Diagnosis,string,yes" /> <input type="hidden"
	value="<%=cardicClaimAdvance.getDiagnosis().getId()%>"
	name="diagnosisId" id="diagnosisId" /> <%}else{ %> <input type="text"
	tabindex="1" name="diagnosis" class="large2" id="diagnosis"
	onblur="fillDiagnosisId(this.value);" validate="Diagnosis,string,yes" />
<%} %> <input type="hidden" value="" name="diagnosisId" id="diagnosisId" />
<div id="ac2update" style="display: none; border: 1px solid #000"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
				
			    new Ajax.Autocompleter(document.getElementById('diagnosis'),'ac2update','mediClaim?method=getDiagnosis',{parameters:'requiredField=diagnosis'});
			  
    </script>

<div class="Clear"></div>
<label class="large2"><span>*</span> Details of treatment for
which medical advance is asked</label> <%if(cardicClaimAdvance.getTreatmentDetail()!= null){%>
<input id="treatment" class="large2" name="<%=DETAILS_OF_TREATMENT %>"
	type="text" value="<%=cardicClaimAdvance.getTreatmentDetail()%>"
	validate="Details of treatment,string,yes" maxlength="50" /> <%}else{ %>
<input id="treatment" class="large2" name="<%=DETAILS_OF_TREATMENT %>"
	type="text" value="" validate="Details of treatment,string,yes"
	maxlength="50" /> <%} %>
<div class="Clear"></div>
<label><span>*</span> Specialist Name</label> <select
	name="<%=SPECIALIST_NAME %>" validate="Specialist Name,String,no"
	class="large">
	<option value="0">Select</option>
	<% 
	
		for (MasEmployee  obj : employeeList){
			if(obj.getEmpCategory().getEmpCategoryCode() != null){
			if(obj.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
				String doctorMiddleName = "";
				String doctorLastName = "";
				if(obj.getMiddleName() != null){
					doctorMiddleName = obj.getMiddleName();
				}
				if(obj.getLastName() != null){
					doctorLastName = obj.getLastName();
				}
	%>

	<%if(cardicClaimAdvance.getSpecialistName().getId() .equals(obj.getId())){ %>
	<option value="<%=cardicClaimAdvance.getSpecialistName().getId()%>"
		selected="selected"><%=cardicClaimAdvance.getSpecialistName().getFirstName()+" "+cardicClaimAdvance.getSpecialistName().getMiddleName()+" "+cardicClaimAdvance.getSpecialistName().getLastName()%></option>
	<%}else{ %>
	<option value="<%=obj.getId ()%>"><%=obj.getFirstName()+" "+doctorMiddleName+" "+doctorLastName%></option>
	<%  } } } }
	%>
</select> <label class="large2"><span>*</span> Amount as advance(90% of
CGHS rates): Rs </label> <%if(cardicClaimAdvance.getAdvanceAmount()!= null){%> <input
	id="advanceAmount" name="<%=ADVANCE_AMOUNT %>" type="text"
	value="<%=cardicClaimAdvance.getAdvanceAmount() %>"
	validate="Amount as advance,float,yes" maxlength="8" /> <%}else{ %> <input
	id="advanceAmount" name="<%=ADVANCE_AMOUNT %>" type="text" value=""
	validate="Amount as advance,float,yes" maxlength="8" /> <%} %>

<div class="Clear"></div>

<label class="large2"><span>*</span> Amount qualifying for
re-imbursement(as per CGHS rates): Rs</label> <%if(cardicClaimAdvance.getQualifyingAmount()!= null){%>
<input id="qualifyAmount" name="<%=QUALIFYING_RS %>" type="text"
	value="<%=cardicClaimAdvance.getQualifyingAmount() %>"
	validate="Amount qualifying,float,yes" maxlength="8" /> <%}else{ %> <input
	id="qualifyAmount" name="<%=QUALIFYING_RS %>" type="text" value=""
	validate="Amount qualifying,float,yes" maxlength="8" /> <%} %>

<div class="Clear"></div>

<label class="large2"><span>*</span> Amount Payable to(Name of
civil hospital)</label> <select name="<%= PAYABLE_TO %>"
	validate="Amount Payable to,string,yes" tabindex=1>
	<option value="0">Select</option>
	<%
				         		if(hospitalList != null){ 	
				         			for (Iterator iter = hospitalList.iterator(); iter.hasNext();) {
				         				MasHospital hospital = (MasHospital) iter.next();
				         %>
	<%if(cardicClaimAdvance.getPayableTo().getId() .equals(hospital.getId())){ %>
	<option value="<%=cardicClaimAdvance.getPayableTo().getId()%>"
		selected="selected"><%=cardicClaimAdvance.getPayableTo().getHospitalName()%></option>
	<%}else{ %>
	<option value="<%=cardicClaimAdvance.getId() %>"><%=hospital.getHospitalName()%></option>
	<%		}} } %>
</select>

<div class="Clear"></div>

<label class="large2"><span>*</span> Name of CDA/Pay Account
office in which individuals CDA account/ IRDA is maintained</label> <%if(cardicClaimAdvance.getCdaName()!= null){%>
<input id="cdaPay" name="cdaPayOffice" type="text"
	value="<%=cardicClaimAdvance.getCdaName() %>"
	validate="Name of CDA/Pay Account office,string,yes" maxlength="20" />
<%}else{ %> <input id="cdaPay" name="cdaPayOffice" type="text" value=""
	validate="Name of CDA/Pay Account office,string,yes" maxlength="20" />
<%} %>

<div class="Clear"></div>

<label><span>*</span> The CGHS code for</label> <%if(cardicClaimAdvance.getCghsCode()!= null){%>
<input id="is" name="<%=CGHS_CODE %>" type="text"
	value="<%=cardicClaimAdvance.getCdaName()%>"
	validate="The CGHS code for,string,yes" maxlength="30" /> <%}else{ %> <input
	id="is" name="<%=CGHS_CODE %>" type="text" value=""
	validate="The CGHS code for,string,yes" maxlength="30" /> <%} %> <label
	class="small"><span>*</span> is</label> <%if(cardicClaimAdvance.getIs1()!= null){%>
<input id="is" name="<%=IS1 %>" type="text"
	value="<%=cardicClaimAdvance.getIs1() %>" validate="is,string,yes"
	maxlength="20" /> <%}else{ %> <input id="is" name="<%=IS1 %>" type="text"
	value="" validate="is,string,yes" maxlength="20" /> <%} %>
<div class="Clear"></div>

<label><span>*</span> CGHS rates in </label> <select
	name="<%=CGHS_RATE%>" validate="CGHS rates in,string,yes">
	<option value="private">Private Ward</option>

</select> <label class="small"><span>*</span> is</label> <%if(cardicClaimAdvance.getIs2()!= null){%>
<input id="is1" name="<%=IS2 %>" type="text"
	value="<%=cardicClaimAdvance.getIs2() %>" validate="is,foat,yes"
	maxlength="8" /> <%}else{ %> <input id="is" name="<%=IS2 %>" type="text"
	value="" validate="is,string,yes" maxlength="8" /> <%} %>
<div class="Clear"></div>

<label><span>*</span> Date of retirement</label> <%if(cardicClaimAdvance.getRetirementDate()!= null){%>
<input type="text" class="calDate" id="retDateId"
	name="<%=RETIREMENT_DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(cardicClaimAdvance.getRetirementDate()) %>"
	validate="Date of retirement,date,yes" MAXLENGTH="10" /> <%}else{ %> <input
	type="text" class="calDate" id="retDateId" name="<%=RETIREMENT_DATE %>"
	value="<%=currentDate %>" validate="Date of retirement,date,yes"
	MAXLENGTH="10" /> <%} %> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.cardicClaimAdvance.<%=RETIREMENT_DATE%>,event)" />
</div>
<div class="Clear"></div>
<div class="blockFrame">
<h5>Undertaking Details</h5>
<div class="Clear"></div>
<label>Basic Pay: Rs </label> <%if(cardicClaimAdvance.getBasicPay()!= null){%>
<input id="basicPay" name="<%=BASIC_PAY %>" type="text"
	value="<%=cardicClaimAdvance.getBasicPay() %>"
	validate="Basic pay,float,no" maxlength="8" /> <%}else{ %><input
	id="basicPay" name="<%=BASIC_PAY %>" type="text" value=""
	validate="Basic pay,float,no" maxlength="8" />
<%} %>

<div class="Clear"></div>

<h5>Dependency Details</h5>
<div class="Clear"></div>
<label><span>*</span> Identification Mark </label> <%if(cardicClaimAdvance.getIdentificationMark()!= null){%>
<input id="mark" class="large" name="identificationMarks1" type="text"
	value="<%=cardicClaimAdvance.getIdentificationMark() %>"
	validate="Identification Mark,string,yes" maxlength="30" /> <%}else{ %> <input
	id="mark" class="large" name="identificationMarks1" type="text"
	value="" validate="Identification Mark,string,yes" maxlength="30" /> <%} %>
<div class="Clear"></div>

<h5>DGMS Letter Details</h5>
<div class="Clear"></div>
<label><span>*</span> To </label> <%if(cardicClaimAdvance.getDgmsTo()!= null){%>
<input id="dgmsTo" class="large" name="<%=DGMS_TO %>" type="text"
	value="<%=cardicClaimAdvance.getDgmsTo() %>"
	validate="To in DGMS,string,yes" maxlength="30" /> <%}else{ %> <input
	id="dgmsTo" class="large" name="<%=DGMS_TO %>" type="text" value=""
	validate="To in DGMS,string,yes" maxlength="30" /> <%} %> <label><span>*</span>
Dispatch Date</label> <%if(cardicClaimAdvance.getDgmsDispatchDate()!= null){%> <input
	type="text" class="calDate" id="retDateId" name="<%=DISPATCH_DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(cardicClaimAdvance.getDgmsDispatchDate()) %>"
	validate="Disposal Date,date,yes" MAXLENGTH="10" /> <%}else{ %> <input
	type="text" class="calDate" id="retDateId" name="<%=DISPATCH_DATE %>"
	value="<%=currentDate %>" validate="Disposal Date,date,yes"
	MAXLENGTH="10" /> <%} %> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.cardicClaimAdvance.<%=DISPATCH_DATE%>,event)" />

<div class="Clear"></div>

<label><span>*</span> Copy To</label> <%if(cardicClaimAdvance.getCopy1()!= null){%>
<input id="copyTo1" class="large" name="<%=COPY1 %>" type="text"
	value="<%= cardicClaimAdvance.getCopy1()%>"
	validate="Copy To,string,yes" maxlength="30" /> <% }else{%> <input
	id="copyTo1" class="large" name="<%=COPY1 %>" type="text" value=""
	validate="Copy To,string,yes" maxlength="30" /> <%} %> <%if(cardicClaimAdvance.getCopy2()!= null){%>
<input id="copyTo2" class="large" name="<%=COPY2 %>" type="text"
	value="<%=cardicClaimAdvance.getCopy2() %>"
	validate="Copy To,string,no" maxlength="30" /> <%}else{ %> <input
	id="copyTo2" class="large" name="<%=COPY2 %>" type="text" value=""
	validate="Copy To,string,no" maxlength="30" /> <%} %> <%if(cardicClaimAdvance.getCopy3()!= null){%>
<input id="copyTo3" class="large" name="<%=COPY3 %>" type="text"
	value="<%= cardicClaimAdvance.getCopy3()%>"
	validate="Copy To,string,no" maxlength="30" /> <%}else{ %> <input
	id="copyTo3" class="large" name="<%=COPY3 %>" type="text" value=""
	validate="Copy To,string,no" maxlength="30" /> <%} %>



<div class="Clear"></div>
<h5>Unit Details</h5>
<div class="Clear"></div>

<label>To</label> <%if(cardicClaimAdvance.getUnitTo()!= null){%> <input
	type="text" class="large" tabindex="1" align="right" name="unit"
	id="unit"
	value="<%=cardicClaimAdvance.getUnitTo().getUnitName()+"["+cardicClaimAdvance.getUnitTo().getId()+"]" %>"
	onblur="fillUnitId(this.value);" /> <input type="hidden"
	value="<%=cardicClaimAdvance.getUnitTo().getId()%>" name="unitId"
	id="unitId" /> <%}else{ %> <input type="text" class="large" tabindex="1"
	align="right" name="unit" id="unit" onblur="fillUnitId(this.value);" />
<%} %> <input type="hidden" value="" name="<%=UNIT_ID%>" id="unitId" />
<div id="ac2update" style="display: none; border: 1px solid #000"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
				
			    new Ajax.Autocompleter(document.getElementById('unit'),'ac2update','mediClaim?method=getUnitName',{parameters:'requiredField=unit'});
			  
    </script>

<div class="Clear"></div>

<label>Dispatched Date</label> <%if(cardicClaimAdvance.getUnitDispatchDate()!= null){%>
<input type="text" class="retDate" id="dispatchDateId"
	name="cdaDispatchDate"
	value="<%=HMSUtil.convertDateToStringWithoutTime(cardicClaimAdvance.getUnitDispatchDate()) %>"
	validate="Dispatch Date,date,yes " MAXLENGTH="10" /> <%}else{ %> <input
	type="text" class="dispatchDate" id="dispatchDateId"
	name="cdaDispatchDate" value="<%=currentDate %>"
	validate="Dispatch Date,date,yes " MAXLENGTH="10" /> <%} %> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.cardicClaimAdvance.<%=DISPATCH_DATE%>,event)" />

<div class="Clear"></div>

</div>
<div class="Height10"></div>
<div class="Clear"></div>
<!--Bottom labels starts-->
<div class="bottom">
<div class="division"></div>
<input type="button" class="button" value="Update"
	onclick="submitForm('cardicClaimAdvance','mediClaim?method=updateAdvanceClaim');"
	align="right" /> <input type="reset" class="button" name="Reset"
	id="reset" value="Reset" onclick="resetClicked('contingentBill');"
	accesskey="r" />
<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <input
	type="hidden" name="changed_by" value="<%=userName%>"> <label>Changed
Date</label> <label class="value"><%=currentDate%></label> <input type="hidden"
	name="changed_date" value="<%=currentDate%>"> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="changed_time" value="<%=time%>">

<div class="Clear"></div>
</div>
</div>
</form>

<script type="text/javascript">
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