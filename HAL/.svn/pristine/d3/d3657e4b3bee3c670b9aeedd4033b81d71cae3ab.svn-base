

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.FamilyPlanning"%>
<%@page import="jkt.hms.masters.business.MasReligion"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.net.URL"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> -->
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->

<script type="text/javascript" language="javascript"src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
<script type="text/javascript" language="javascript">
<%
Calendar calendar=Calendar.getInstance();
String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
String getDate=String.valueOf(calendar.get(Calendar.DATE));
int year=calendar.get(calendar.YEAR);
if(month.length()<2){
month="0"+month;
}
if(getDate.length()<2){
getDate="0"+getDate;
}

%>
serverdate = '<%=getDate+"/"+month+"/"+year%>'
</script>

<%
	Map map = new HashMap();
	List<Visit>familyPlanningList = new ArrayList<Visit>();
	List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	String Labresult="NotPresent";
	if(map.get("familyPlanningList") != null){
		familyPlanningList = (List<Visit>)map.get("familyPlanningList");
	}
	List<MasReligion>religionList = new ArrayList<MasReligion>();
	if(map.get("religionList")!=null){
		religionList=(List<MasReligion>)map.get("religionList");
	}
	PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
	if(map.get("patientInvestigationHeader")!=null){
		patientInvestigationHeader=(PatientInvestigationHeader)map.get("patientInvestigationHeader");
	}
	List<PatientInvestigationDetails> patientInvestigationdetails= new ArrayList<PatientInvestigationDetails>(); 
	if(map.get("patientInvestigationDetailsList")!=null){
		patientInvestigationdetails=(List<PatientInvestigationDetails>)map.get("patientInvestigationDetailsList");
	}
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	if(map.get("resultList") != null){
		resultList=(List)map.get("resultList");
	}
    List<MasChargeCode>chargeCodeList = new ArrayList<MasChargeCode>();
    if(map.get("chargeCodeList") != null){
    	chargeCodeList=(List)map.get("chargeCodeList");
	}
	DgOrderhd dgOrderhd=null;
	if(map.get("dgOrderhd")!=null){
		dgOrderhd=(DgOrderhd)map.get("dgOrderhd");
	}
	List<DgOrderdt> getDgOrderdts=null;
	if(map.get("dgOrderdtList")!=null)
	{
		getDgOrderdts=(List<DgOrderdt>)map.get("dgOrderdtList");
	}
	List<FamilyPlanning>planningList = new ArrayList<FamilyPlanning>();
	if(map.get("planningList")!=null){
		planningList=(List<FamilyPlanning>)map.get("planningList");
	}
	FamilyPlanning familyPlanning = new FamilyPlanning();
	if(planningList.size() > 0){
		familyPlanning = planningList.get(0);
	}
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	if(map.get("employeeList")!=null){
		employeeList=(List<MasEmployee>)map.get("employeeList");
	}
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	try {
	properties.load(resourcePath.openStream());
	} catch (Exception e) {
	e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	String patientName="";
	Patient patient = new Patient();
	String servicePersionName="";
	Visit visit = new Visit();
	if(familyPlanningList.size()>0){
	 visit=(Visit)familyPlanningList.get(0);
	 patient = (Patient)visit.getHin();
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
	 servicePersionName=patient.getSFirstName();
	}
	if(patient.getSMiddleName()!= null){
	servicePersionName=servicePersionName+" "+patient.getSMiddleName();
	}
	if(patient.getSLastName()!= null){
	servicePersionName=servicePersionName+" "+patient.getSLastName();
	}
}

%>
<!--main content placeholder starts here-->
<form name="familyPlanning" action="" method="post">

<div class="titleBg">
<h2>FAMILY PLANNING</h2>
</div>

<div class="clear"></div>

<h4>PATIENT DETAILS</h4>
<div class="clear paddingTop15"></div>
<div class="Block">

<div class="Block">

<label>Service No.</label>
 
<label class="value"><%=patient.getServiceNo()!=null ?patient.getServiceNo(): ""  %></label>
 
<label>Patient Name</label> 
 <label class="value"><%=patientName %></label>
<label>Relation</label>
 
<label class="value"><%=patient.getRelation()!=null ?patient.getRelation().getRelationName(): ""  %></label>
 

<div class="clear"></div>
<label>Rank</label>

<label class="value"><%=patient.getRank() != null ? patient.getRank().getRankName():"" %></label>


<label>Name</label> 
 <label class="value"><%=servicePersionName %></label>


<label>Trade/Branch</label>
 
<label class="value"><%=patient.getTrade()!= null?patient.getTrade().getTradeName():"" %></label>

<div class="clear"></div>
<label>Unit</label>
 
<label class="value"><%=patient.getUnit()!= null?patient.getUnit().getUnitName():"" %></label>


<label>Age</label> 

<label class="value"><%=patient.getAge()!= null?patient.getAge():"" %></label> 


<input type="hidden" value="37 Years" id="ageId" name="ageId">

 <label>Gender</label>
 
<label class="value"><%=patient.getSex()!= null?patient.getSex().getAdministrativeSexName():"" %></label>
<input type="hidden" value="2" id="genderId" name="genderId">


<div class="clear"></div>

<label>Marital Status</label> 

<label class="value"><%=patient.getMaritalStatus()!= null?patient.getMaritalStatus().getMaritalStatusName():"" %></label> 
 

<label>Blood Group</label>

<label class="value"><%=patient.getBloodGroup()!= null?patient.getBloodGroup().getBloodGroupName():"" %></label>
<label>Medical Disability</label>
<input type="text" name="medicalDisability"></input>
<input type="hidden" name="visitId" value="<%=visit.getId()%>">
<input type="hidden" name="hinId" value="<%=patient.getId()%>">
<%-- <input name="departmentId"	type="hidden" value="<%=visit.getDepartment().getId()%>" />--%>
<input	name="<%=VISIT_NUMBER%>" type="hidden" value="<%=visit.getVisitNo()%>" />
<input	name="<%=SERVICE_NO%>" type="hidden" value="<%=patient.getServiceNo()%>" />
<%-- <input name="deptId" type="hidden" value="<%=visit.getDepartment().getId()%>" />--%>
<input name="<%=HIN_NO%>" type="hidden"	value="<%=patient.getHinNo()%>" />
<input name="familyPlanningId" type="hidden" value="<%=familyPlanning.getId() != null?familyPlanning.getId():"" %>" />


</div>
<div class="clear paddingTop15"></div>
<h4>Sterilisation Details</h4>
<div class="clear"></div>

<div class="Block">

<label>Year No.</label>
<input type="text" name="yearNo" maxlength="4" value="<%=familyPlanning.getYearNo()!= null?familyPlanning.getYearNo():"" %>" />

<label>Month No.</label>
<input type="text" name="monthNo" maxlength="2" value="<%=familyPlanning.getMonthNo()!= null?familyPlanning.getMonthNo():"" %>"/>

<label>Family Planning</label>
<select name="familyPlanning">
<%if(familyPlanning.getFamilyPlanning() != null){ %>
<option value="<%=familyPlanning.getFamilyPlanning() %>" selected="selected"><%=familyPlanning.getFamilyPlanning() %></option>
<%}else{ %>
<option value="Vascotomy">Vascotomy</option>
<option value="Tubectomy">Tubectomy</option>
<%} %>
</select>

<div class="clear"></div>

<label>Registration No.</label>
<input type="text" name="regNo" class="" value="<%=familyPlanning.getRegistrationNo()!= null?familyPlanning.getRegistrationNo():"" %>" size="" />

<label class="">Date</label>
<input	type="text" name="planDate" id="physioAppDate" validate="Date,date,yes" value="<%=familyPlanning.getPlanDate()!= null?HMSUtil.convertDateToStringWithoutTime(familyPlanning.getPlanDate()):""%>" class="date" readonly="readonly" MAXLENGTH="8" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender" onClick="setdate('<%=currentDate %>',document.familyPlanning.planDate,event)" />
<label class="">Time</label>
<input type="text" name="planTime" maxlength="5" onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);" onBlur="IsValidTimeWithBlankCheck(this.value,this.id);"  value="<%=familyPlanning.getPlanTime() !=null?familyPlanning.getPlanTime():"" %>" />

<div class="clear"></div>

<label class="">Age</label>
<label class="auto">Husband</label>
<input type="text" name="husbandAge" value="<%=familyPlanning.getHusbandAge()!= null?familyPlanning.getHusbandAge().substring(0,2):"" %>" class="auto" size="5" /><label class="unit">years</label>

<!--  <input class="transparent" size="1" /> -->

<label class="">Wife</label>
<input type="text" name="wifeAge" class="auto" value="<%=familyPlanning.getWifeAge()!= null?familyPlanning.getWifeAge().substring(0,2):"" %>" size="17" /><label class="unit2">years</label>



<label>Religion</label>
<select name="<%=RELIGION_ID %>">
<option>Select</option>
<%
if(religionList.size()>0){
	for(MasReligion masReligion :religionList){
	 if(familyPlanning.getReligion() != null){
	 if(familyPlanning.getReligion().getId()==(masReligion.getId())){
	%>
<option value="<%=masReligion.getId() %>" selected="selected"><%=masReligion.getReligionName() %></option>
<%}}else{ %>
<option value="<%=masReligion.getId() %>"><%=masReligion.getReligionName() %></option>

<%}}} %>
</select>

<div class="clear"></div>

<label>Education</label>
<label class="auto">Husband</label>
<select name="husbandEdu" class="small">
<%if(familyPlanning.getHusbandEducation() != null){ %>
<option value="<%=familyPlanning.getHusbandEducation() %>" selected="selected"><%=familyPlanning.getHusbandEducation() %></option>
<%}else{ %>
<option value="">Select</option>
<option value="MCA">MCA</option>
<option value="BCA">BCA</option>
<option value="MSc">MSc</option>
<option value="BTech">BTech</option>
<option value="MTech">MTech</option>
<%} %>
</select>

<!-- <input class="transparent" size="1"></input> -->

<label class="">Wife</label>
<select name="wifeEdu" class="">
<%if(familyPlanning.getWifeEducation() != null){ %>
<option value="<%=familyPlanning.getWifeEducation() %>" selected="selected"><%=familyPlanning.getWifeEducation() %></option>
<%}else{ %>
<option value="">Select</option>
<option value="MCA">MCA</option>
<option value="BCA">BCA</option>
<option value="MSc">MSc</option>
<option value="BTech">BTech</option>
<option value="MTech">MTech</option>
<option value="BSc">BSc</option>
<%} %>
</select>



<label>No. of Children</label>
<input type="text" name="noOfChildren" value="<%=familyPlanning.getNoOfChild()!= null?familyPlanning.getNoOfChild():"" %>"/>

<label>Doctor's Name</label>
<% if(familyPlanning.getDoctorName() != null){ %>
<input type="text" name="doctorName" value="<%=familyPlanning.getDoctorName()%>" />
<%}else{ %>
<input type="text" name="doctorName" value="" maxlength="50"/>
<%} %>

<label>Hospital Name</label>
<% if(familyPlanning.getHospitalName()!= null){ %>
<input type="text" name="hospitalName" value="<%=familyPlanning.getHospitalName() %>" />
<%}else{ %>
<input type="text" name="hospitalName" value=""  maxlength="30"/>
<%} %>
<label>Address</label>
<% if(familyPlanning.getAddress()!= null){ %>
<textarea rows="" cols="" name="address"  ><%=familyPlanning.getAddress() %></textarea>
<%}else{ %>
<textarea rows="" cols="" name="address"  maxlength="200"></textarea>
<%} %>

</div>

<div class="clear paddingTop15"></div>

<h4>INVESTIGATION</h4>

<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Investigation</th>
		<th scope="col">Refer to MH</th>
		<th scope="col">Result</th>
		<th scope="col">Upload/View</th>
		<th scope="col">Add</th>
		<th scope="col">Delete</th>
	</tr>
	<%int inc=1;
if(resultList!=null && resultList.size()>0)
{ %>
	<input type="hidden" name="Investigated" tabindex="2" value="yes" />
	<% }else{%>
	<input type="hidden" name="Investigated" tabindex="2" value="No" />
	<%  }

if(patientInvestigationHeader.getId()!=null)
{
%>
	<input type="hidden" value="<%=patientInvestigationHeader.getId() %>"
		name="patientInvestigationHeaderId" id="patientInvestigationHeaderId" />
	<%
}else{%>
	<input type="hidden" name="patientInvestigationHeaderId"
		id="patientInvestigationHeaderId" />
	<% }
if(dgOrderhd!=null)
{
%>
	<input type="hidden" value="<%=dgOrderhd.getId() %>" name="dgOrderhdId"
		id="dgOrderhdId" />
	<%
}else{%>
	<input type="hidden" name="dgOrderhdId" id="dgOrderhdId" />
	<% }

String template="";
int resultid=0;
if(patientInvestigationdetails!=null && patientInvestigationdetails.size()>0)
{
	HashMap second = new HashMap();
	   List<String> firstKeyList=new ArrayList<String>();
	   List<Integer> firstValueList=new ArrayList<Integer>();
	   List<Integer> secondKeyList=new ArrayList<Integer>();
	   List<String> secondValueList=new ArrayList<String>();
	   List<String> thirdKeyList=new ArrayList<String>();
	   List<Integer> thirdValueList=new ArrayList<Integer>();
	   List<String> referToMHList=new ArrayList<String>();
	   int inc21=1;
	   System.out.println("set size==="+patientInvestigationdetails.size());
		    for(PatientInvestigationDetails patientInvestigation : patientInvestigationdetails)
		    {   	int cnt=0;
				String investigationName="";
				System.out.println("charge code ==="+patientInvestigation.getChargeCode());
				if(chargeCodeList.size()>0){
					for(MasChargeCode chargeCode :chargeCodeList){
						if(chargeCode.getId().equals(patientInvestigation.getChargeCode().getId())){
				System.out.println("charge code name==="+patientInvestigation.getChargeCode().getChargeCodeName());
		    	investigationName=chargeCode.getChargeCodeName()+"["+chargeCode.getId()+"]";
		    	System.out.println("investigationName==="+investigationName);
						}
					}
				}
		    	//first.put(investigationName,patientInvestigation.getChargeCode().getId());
		    	//third.put(investigationName,patientInvestigation.getId());
		    	firstKeyList.add(investigationName);
		    	firstValueList.add(patientInvestigation.getChargeCode().getId());
		    	thirdKeyList.add(investigationName);
		    	thirdValueList.add(patientInvestigation.getId());
		    	referToMHList.add(patientInvestigation.getReferToMh());

		    	String val="";
		    	String val1="";
		    	String val2="";
		    	int investigationId=0;
		    	if(resultList.size()>0 && inc21<=resultList.size())
		    	{
		    	DgResultEntryHeader dgEH=(DgResultEntryHeader)resultList.get(inc21-1);
		    	int masInvestId=dgEH.getDgMasInvestigation().getId();
		       	if(patientInvestigation.getChargeCode().getId()==masInvestId)
		    	{
		    	for(DgResultEntryDetail dgre:dgEH.getDgResultEntryDetails())
		    	{   
		    		if(dgre.getSubInvestigation()!=null)
		    		val1=dgre.getSubInvestigation().getSubInvestigationName();
		    	if(!dgre.getResultType().equalsIgnoreCase("t"))
	    		{
		      	    ++cnt;
		    		if(dgre.getResult()!=null)
		    			val2=dgre.getResult();
		    		if(cnt==1){
		    	    	val=" "+val1+":"+val2;
		    	    }else{
		    	    	val=" "+val+","+val1+":"+val2;
		    	    }

	    		}
		    	    investigationId=dgre.getInvestigation().getId();
		    		if(dgre.getResultType().equalsIgnoreCase("s"))
		    		{
		    		    	val=val.substring(2);
		    				resultid=0;			
		    		}
		    		if(dgre.getResultType().equalsIgnoreCase("m"))
		    		{
		    			val=val.substring(1);
		    			resultid=0;
		    		}
		    		if(dgre.getResultType().equalsIgnoreCase("t"))
		    		{

		    			resultid=dgre.getResultEntry().getId();
		    			template="template"+"/"+resultid;
		    			val=template;
		    		}
		    	}
		    	++inc21;
		    	}else
		    	{
		    		val=" ";
		    		investigationId=patientInvestigation.getChargeCode().getId();
		    	}

		    	}else{
		    		++inc21;
		    	}
		    	
		    	if(investigationId!=0)
		    	{	
		    		secondKeyList.add(investigationId);
		    		secondValueList.add(val);
		    	
		    	}
		    	if(investigationId!=0&&!second.containsKey(investigationId))
			    	second.put(investigationId,val);
			    	//++inc21;
		    }
		    int i=0;
	          
				
			 for(String firstKey:firstKeyList)
			 {
		%>
 <tr>
	<input type="hidden" value="<%=thirdValueList.get(i) %>" name="patientInvestigationdetailsId<%=inc %>"" id="patientInvestigationdetailsId<%=inc %>" />
		<td><input type="text" value="<%=firstKey%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="chargeCodeName<%=inc %>"
			size="45" name="chargeCodeName<%=inc %>" />
				</td>
		<%

 if(secondValueList.size()>0)	
{
	  if(i<secondValueList.size())
	  {	  
		  Labresult="present";
	//String st=(String)second.get(first.get(key));
	String st=secondValueList.get(i);

	String[] mySplitResult = st.split("/");
	if(!mySplitResult[0].equalsIgnoreCase("template"))
	{
	%>
	<td>
	<% if(referToMHList.get(i).equalsIgnoreCase("y")){System.out.println("in if condition For if Lab result present");
	%>
	 <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" disabled="disabled" checked="checked" value="y"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
   <%}else{
	   %>
  <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" disabled="disabled" value="n"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
<%} %>
 </td>
	<td><input type="text" value="<%=secondValueList.get(i)%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>
<% }else{
%>
<td>&nbsp;</td>
	<td><input name="resultIdTemplate<%=inc %>"
		id="resultIdTemplate<%=inc %>" type="hidden"
		value="<%=mySplitResult[1]%>"/>
		<input	type="Button" class="Button" value="Result"
		onclick="openTemplateScreen(<%=inc %>);"  /></td>

<%}}else
{ 
	%>
	<td> <% if(referToMHList.get(i).equalsIgnoreCase("y")){
	%>
	 <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" disabled="disabled" checked="checked" value="y"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
   <%}else{
	   %>
  <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" disabled="disabled" value="n"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
<%} %>	 </td>
		<td><input type="text" value="" readonly="readonly"
				readonly="readonly" tabindex="2" id="Result<%=inc %>"
				 name="Result<%=inc %>" size="65" />
	</td>
<%
}
	  }else{
		  
	String investigationVal=firstKey;
	StringTokenizer st = new StringTokenizer(investigationVal, "[");
	st.nextToken();
	String val = st.nextToken();
	StringTokenizer st1 = new StringTokenizer(val, "]");
	String finalInvestVal=st1.nextToken();
	%>
		<td>
		<%
	if(getDgOrderdts!=null)
    {
	for(DgOrderdt dgOrderdt : getDgOrderdts)
	{
	    int finalVal=Integer.parseInt(finalInvestVal);
	    if(dgOrderdt.getInvestigation().getId()==finalVal)
	    {
	    	if(dgOrderdt.getInvestigationToMH()!=null)
	    	{
		    	if(dgOrderdt.getInvestigationToMH().equalsIgnoreCase("y"))
		    	{

		    		%><input tabindex="1" type="checkbox"
		    			name="investigationReferToMH<%=inc %>" value="y" disabled="disabled" checked="checked" id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
	<td><input type="text" value=""  tabindex="2" id="Result<%=inc %>"
				 name="Result<%=inc %>" />
	</td>
	<% 	    	}else
	            {
		%>
	            <input tabindex="1" type="checkbox"
		name="investigationReferToMH<%=inc %>" value="n" disabled="disabled"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
	    <td><input type="text" value="" readonly="readonly"
				 tabindex="2" id="Result<%=inc %>"
				 name="Result<%=inc %>" />
	</td>
	            <%

	             }
		    	}else
	    	{%> <input tabindex="1" type="checkbox"
			name="investigationReferToMH<%=inc %>" value="n"
			id="investigationReferToMH<%=inc %>"
			onclick="checkForInvestigationMH(<%=inc %>);" />
		<td><input type="text" value="" readonly="readonly" tabindex="2"
			id="Result<%=inc %>" name="Result<%=inc %>" size="65"  /></td>
		<%	}
	    }
	}}else{
	%> <input tabindex="1" type="checkbox"
			name="investigationReferToMH<%=inc %>" value="n"
			id="investigationReferToMH<%=inc %>"
			onclick="checkForInvestigationMH(<%=inc %>);" />
		<td><input type="text" value="" readonly="readonly" tabindex="2"
			id="Result<%=inc %>" name="Result<%=inc %>" size="65" /></td>
		<% }%>
		</td>

		<% }%>
		<td><input name="uploadReport<%=inc %>"
			id="uploadReport<%=inc %>" type="button" class="button"
			value="UPLOAD/VIEW" style="display: none;"
			onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" /></td>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRowForInvestigation();" /></td>
	</tr>
	<% inc++;i++;
		    }

%>
	<input type="hidden" value="<%=inc-1 %>" name="hiddenValue"
		id="hiddenValue" />

	<%
}else{
	%>
           
	<tr>
		<td><input type="text" value="" tabindex="1" id="chargeCodeName1"
			size="45" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal','parent')}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
			size="10" maxlength="5" validate="Qty,num,no" /> <input
			type="hidden" tabindex="1" id="chargeCode1" name="chargeCode1"
			size="10" readonly /> <!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
		<td><input tabindex="1" type="checkbox"
			name="investigationReferToMH1" value="n" id="investigationReferToMH1"
			onclick="checkForInvestigationMH(1);" /></td>
		<td><input type="text" value="" readonly="readonly"
			name="Result1" id="Result1" size="65" /></td>
		<td><input name="uploadReport1" id="uploadReport1" type="button"
			class="button" value="UPLOAD/VIEW" style="display: none;"
			onClick="javascript:fileUploadWindowInvestigation(1);" /></td>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRowForInvestigation();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRowForInvestigation(this);" /> </td>

	</tr>
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />


	<% }%>


</table>
<script>
//checkForInvestReferToMH();

</script> <input type="hidden" id="investigationDataStatus"
	name="investigationDataStatus" value="no" />

<div class="clear paddingTop15"></div>
<div class="Block">

<!--<label>Remarks</label>
<textarea rows="" cols="" name="remarks" ></textarea>

-->
<label>Forward To</label>
<select	id="moId" name="mo"	validate="Forward To,metachar,no"  class="auto" tabindex="1">
	<option value="0">Select</option>
	<%

for(MasEmployee  masEmployee : employeeList){
	if(masEmployee.getEmpCategory() != null){
		if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getRank().getRankName()+" "+ masEmployee.getFirstName()+" "+(masEmployee.getMiddleName()!=null?masEmployee.getMiddleName():"")+" "+(masEmployee.getLastName()!=null?masEmployee.getLastName():"") %></option>
	<%				}
	}
} %>
</select> 
</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear paddingTop15"></div>

<input type="button" name="Button" class="button" value="Submit" onclick="submitForm('familyPlanning','fwc?method=submitfamilyPlanningDetails&flag=FAMILY PLANNING');" />
<%
if(resultList.size() > 0){
%>
<input type="button" name="Button" class="buttonBig" value="Forward To Mo" onclick="submitForm('familyPlanning','fwc?method=forwardToMoFamilyPlanning&hinId=<%=patient.getId()%>&visitId=<%=visit.getId() %>');" />
<%} %>
<!--<input type="button" name="Button" class="buttonBig" value="Forward To Mo" onclick="submitForm('familyPlanning','fwc?method=showSterilisationWaitinglistJsp&hinId=<%=patient.getId()%>&visitId=<%=visit.getId() %>');" />
--><script type="text/javascript">
function checkForInvestReferToMH()
{
	var inc=document.getElementById('hiddenValue').value;
	var i;
	for(i=1;i<=inc;i++)
	{
		if(document.getElementById('investigationReferToMH'+i).checked==true)
		{
			document.getElementById('uploadReport'+i).style.display='inline';
		}
	}
}
function addRowForInvestigation(){

	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  document.getElementById('investigationDataStatus').value="yes";
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration
	  // alert("iteration row--"+iteration)

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){

	  						if(validateInvestigationAutoComplete(this.value,iteration)){checkForChargeCode(this.value,iteration,'chargeCodeVal'+iteration,'parent');}

	  					  };
	   var newdiv1 = document.createElement('div');
	  newdiv1.setAttribute('id', 'ac2update'+iteration);
	  newdiv1.setAttribute('class', 'autocomplete');
	  newdiv1.style.display = 'none';

	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  e0.setAttribute('tabindex','1');
	  //alert("name--"+e0.name)
	  e0.size = '45'
	  cellRight0.appendChild(newdiv1);

	  cellRight0.appendChild(e0);

	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update'+iteration,'opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName'+iteration});	  var sel = document.createElement('input');

	  var cellRight11 = row.insertCell(1);
	  var e11 = document.createElement('input');
	  e11.type = 'checkbox';
	  e11.name = 'investigationReferToMH' + iteration;
	  e11.id = 'investigationReferToMH' + iteration;
	  // e1.size = '30';
	  e11.value='n';
	  e11.className = 'radioAuto';
	  e11.setAttribute('tabindex','1');
	  e11.onclick = function(){checkForInvestigationMH(iteration)};
	  cellRight11.appendChild(e11);

	  var cellRight1 = row.insertCell(2);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.size = '65';
	  e1.name = 'Result' + iteration;
	  e1.id = 'Result' + iteration;
	  e1.setAttribute('readonly','readonly');
	  e1.setAttribute('maxlength', 20);
	  e1.setAttribute('tabindex','1');
    cellRight1.appendChild(e1);

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
	  var cellRight30 = row.insertCell(3);
	  var e30 = document.createElement('input');
	  e30.type = 'button';
	  e30.className = 'button';
	  e30.name='uploadReport'+iteration;
	  e30.id='uploadReport'+iteration;
	  e30.value='UPLOAD/VIEW';
	  e30.style.display='none';
	  e30.setAttribute('onClick','fileUploadWindowInvestigation(iteration);');
	  cellRight30.appendChild(e30);

	  var cellRight1 = row.insertCell(4);
	  var e3 = document.createElement('input');
	  e3.type = 'button';
	  e3.className = 'buttonAdd';
	  e3.name='Button';
	  //e3.setAttribute('onClick','addRowForInvestigation();');
	  e3.onclick = function(){addRowForInvestigation();};
	  cellRight1.appendChild(e3);

	  var cellRight2 = row.insertCell(5);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonDel';
	  e4.name='delete';
	 // e4.setAttribute('onClick','removeRowForInvestigation(this);');
	 e4.onclick = function(){removeRowForInvestigation(this);};
	  cellRight2.appendChild(e4);


	}

</script>

</form>