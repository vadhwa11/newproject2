
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>


<%@page import="jkt.hms.masters.business.MasRank"%>

<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>

<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%><script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.6.pack.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/opd?method=showDailyDoctorWiseReportJsp";
  obj.submit();
  }
</script>
<script type="text/javascript" language="javascript">
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}

	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>

<script type="text/javascript">
function check(){
var SDate = document.dailyDoctorWise.<%= FROM_DATE%>.value;
var EDate = document.dailyDoctorWise.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>
<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasMedicalExaminationReportOnEntry> medicalDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	if (map.get("medicalDetailList") != null) {
		medicalDetailList = (List) map.get("medicalDetailList");
		System.out.println("medicalDetailList size -----"+medicalDetailList.size());
	}
	
	MasMedicalExaminationReportOnEntry medExam=null;
	int length=medicalDetailList.size();
	System.out.println("length  -----"+length);

	if(medicalDetailList!= null && medicalDetailList.size()>0)
	{
		medExam=medicalDetailList.get(0);
	}
	String jspheading=null;
	if(map.get("jspheading") != null){
		jspheading = (String)map.get("jspheading");
	}
	String requestedjsp=null;
	if(map.get("requestedjsp") != null){
		requestedjsp = (String)map.get("requestedjsp");
		
	}
	System.out.println("requestedjsp---jsp--"+requestedjsp);
	String search=null;
	if (map.get("search") != null) {
		search = (String) map.get("search");
	      System.out.println("jsp search"+search);
	   }
	String accessjsp=null;
	if (map.get("accessjsp") != null) {
		accessjsp = (String) map.get("accessjsp");
	      System.out.println("jsp accessjsp"+accessjsp);
	   }
	String method12=null;
	if (map.get("method12") != null) {
		method12 = (String) map.get("method12");
	      System.out.println("jsp method"+method12);
	   }
	int visitId=0;
	if (map.get("visitId") != null) {
		visitId = (Integer) map.get("visitId");
	      System.out.println("jsp visitId--"+visitId);
	   }
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	if(map.get("resultList") != null){
		resultList=(List)map.get("resultList");
	System.out.println("jsp resultList----"+resultList.size());
	}
	Set<PatientInvestigationDetails> patientInvestigationdetails=null;
	PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
	if(map.get("patientInvestigationHeader")!=null){
		
		patientInvestigationHeader=(PatientInvestigationHeader)map.get("patientInvestigationHeader");
		System.out.println(" patientInvestigationHeader is not null");
		patientInvestigationdetails=patientInvestigationHeader.getPatientInvestigationDetails();
	}
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
%>
<% 
String message="";
if (map.get("message") != null) {
       message = (String) map.get("message");
       method12 = (String) map.get("method12");
       System.out.println("method12"+method12);
      System.out.println("messssssss"+message);
   }
if(!message.equalsIgnoreCase("")){
	 System.out.println("messssssss bbbbbllllll"+message);
%>
<h4><%=message %></h4>
<%} %>
<div class="titleBg">
<h2>Medical Case Sheet Entry</h2>
</div>

<form name="SpecialCaseSheet" method="post" action="">
<div class="Block">
<label>Service No.</label>
 <%if(medExam.getYearlySerialNo()!= null){ %>
<label class="value"><%=medExam.getYearlySerialNo() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>
<label>Rank</label>
 <%if(medExam.getRank()!= null){ %>
<label class="value"><%=medExam.getRank().getRankName() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>
<label>Name</label>
 <%if(medExam.getNameInFull()!= null){ %>
<label class="value"><%=medExam.getNameInFull() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>
<div class="clear"></div>
<label>Unit</label>
 <%if(medExam.getUnit()!= null){ %>
<label class="value"><%=medExam.getUnit().getUnitName() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>
<label>Branch/Trade</label>
 <%if(medExam.getTrade()!= null){ %>
<label class="value"><%=medExam.getTrade().getTradeName() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>
<label>Service</label>
 <%if(medExam.getServiceiaf()!= null){ %>
<label class="value"><%=medExam.getServiceiaf() %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>

<div class="clear"></div>

<label>Med Cat:</label>
 <%if(medExam.getPastMedicalCategory()!= null){ %>
 <label class="value"><%= medExam.getPastMedicalCategory().getCategories() %></label>
 <%}else{ %>
  <label class="value">&nbsp;</label><%} %>
  <label>Last Med Board:</label>
 <%if(medExam.getPastMedicalCategory()!= null){ %>
 <label class="value"><%= medExam.getPastMedicalCategory().getCategories() %></label>
 <%}else{ %>
  <label class="value">&nbsp;</label><%} %>
  <label>Next Board Due:</label>
 <%if(medExam.getPastMedicalCategory()!= null){ %>
 <label  class="value"><%= medExam.getPastMedicalCategory().getCategories() %></label>
 <%}else{ %>
  <label class="value">&nbsp;</label><%} %>
  <div class="clear"></div>
  <label>Diagnosis</label>
 <%if(medExam.getDiagnosis()!= null){ %>
  <input	type="text" value="<%=medExam.getDiagnosis()%>" name="Diagnosis"	maxlength="50"  id="typeOfCommunication"/>
 <%}else{ %>
  <input	type="text"  name="Diagnosis"	maxlength="50"  id="typeOfCommunication"/>
<%} %>
<label>Onset</label>
 <%if(medExam.getOnset()!= null){ %>
  <input	type="text" value="<%=medExam.getOnset()%>" name="Onset"	maxlength="50"  id="typeOfCommunication"/>
 <%}else{ %>
  <input	type="text"  name="Onset"	maxlength="50"  id="typeOfCommunication"/>
<%} %>
  <label>Present Condition :</label>
 <%if(medExam.getPresentCondition()!= null){ %>
  <input	type="text" value="<%=medExam.getPresentCondition()%>" name="PresentCondition"	maxlength="50"  id="typeOfCommunication"/>
 <%}else{ %>
  <input	type="text"  name="PresentCondition"	maxlength="50"  id="typeOfCommunication"/>
<%} %>
<label>Medication</label>
 <%if(medExam.getMedication()!= null){ %>
  <input	type="text" value="<%=medExam.getMedication()%>" name="Medication"	maxlength="50"  id="typeOfCommunication"/>
 <%}else{ %>
  <input	type="text"  name="Medication"	maxlength="50"  id="typeOfCommunication"/>
<%} %>
<div class="clear"></div>
<label>ON EXAMINATION</label>
<div class="clear"></div>

<label  class="medium">Height</label> 
 <%if(medExam.getHeight()!= null){ %>
<input name="<%=HEIGHT_WITHOUT_SHOOSE %>"  tabindex="1" type="text" value="<%=medExam.getHeight() %>" id="height" class="auto" onblur="calculateBMI()" size="5" validate="height,int,no"  maxlength="3" />
 <%}else{%>
 <input name="<%=HEIGHT_WITHOUT_SHOOSE %>"  tabindex="1" type="text" id="height" class="auto" onblur="calculateBMI()" size="5" validate="height,int,no"  maxlength="3" />
 <% }%>
<label	class="small">cm</label>

<label class="medium">ABW</label>
 <%if(medExam.getWeight()!= null){ %>
<input name="<%=ACTUAL_WEIGHT %>" tabindex="1" type="text"	value="<%=medExam.getWeight()%>" id="weight"   onblur="calculateBMI()" class="auto" size="5" validate="weight,int,no" maxlength="3" />
 <%}else{%>
<input name="<%=ACTUAL_WEIGHT %>" tabindex="1" type="text"	 id="weight"   onblur="calculateBMI()" class="auto" size="5" validate="weight,int,no" maxlength="3" />
 <% }%>

<label class="small">kg</label> 
<label class="medium">IBW</label>
 <%if(medExam.getIdealweight()!= null){ %>
<input name="<%=IDEAL_WEIGHT %>" tabindex="1" type="text"	value="<%=medExam.getIdealweight()%>" id="weight"   onblur="calculateBMI()" class="auto" size="5" validate="weight,int,no" maxlength="3" />
 <%}else{%>
<input name="<%=IDEAL_WEIGHT %>" tabindex="1" type="text"	 id="weight"   onblur="calculateBMI()" class="auto" size="5" validate="weight,int,no" maxlength="3" />
 <% }%>

<label class="small">kg</label> 
<label class="medium">Over Wt%</label>
 <%if(medExam.getOverweight()!= null){ %>
<input name="<%=OVER_WEIGHT %>" tabindex="1" type="text"	value="<%=medExam.getOverweight()%>" id="weight"   onblur="calculateBMI()" class="auto" size="5" validate="weight,int,no" maxlength="3" />
 <%}else{%>
<input name="<%=OVER_WEIGHT %>" tabindex="1" type="text"	 id="weight"   onblur="calculateBMI()" class="auto" size="5" validate="weight,int,no" maxlength="3" />
 <% }%>
<label class="small">kg</label> 
<div class="clear"></div>
 <label	class="medium">BMI</label> 
  <%if(medExam.getBhi()!= null){ %>
<input tabindex="1" type="text" id="bmi"  name="<%=BHI %>"  value="<%=medExam.getBhi() %>"  maxlength="6" onKeyUp="limitText(this,6);" class="auto" size="5" />
 <%}else{%>
 <input tabindex="1" type="text" id="bmi"  name="<%=BHI %>" maxlength="6" onKeyUp="limitText(this,6);" class="auto" size="5" />
  <% }%>
<label class="small">kg/m</label> 
<label	class="medium">Waist</label> 
  <%if(medExam.getWaist()!= null){ %>
<input tabindex="1" type="text" id="bmi" name="<%=WAIST %>"   value="<%=medExam.getWaist() %>"  maxlength="6" onKeyUp="limitText(this,6);" class="auto" size="5" />
 <%}else{%>
 <input tabindex="1" type="text" id="bmi" name="<%=WAIST %>"   maxlength="6" onKeyUp="limitText(this,6);" class="auto" size="5" />
  <% }%>
  <label class="small">cm</label> 
<label	class="medium">Hips</label> 
  <%if(medExam.getHips()!= null){ %>
<input tabindex="1" type="text" id="bmi" name="Hips" value="<%=medExam.getHips() %>"  maxlength="6" onKeyUp="limitText(this,6);" class="auto" size="5" />
 <%}else{%>
 <input tabindex="1" type="text" id="bmi" name="Hips"  maxlength="6" onKeyUp="limitText(this,6);" class="auto" size="5" />
  <% }%>
  <label class="small">cm</label> 
  
   <label	class="medium">WHR</label> 
  <%if(medExam.getWhr()!= null){ %>
<input tabindex="1" type="text" id="bmi" name="WHR" value="<%=medExam.getWhr() %>"  maxlength="6" onKeyUp="limitText(this,6);" class="auto" size="5" />
 <%}else{%>
 <input tabindex="1" type="text" id="bmi" name="WHR"  maxlength="6" onKeyUp="limitText(this,6);" class="auto" size="5" />
  <% }%>
  <label class="small">cm</label> 
    <div class="clear"></div>
<label	class="medium">Pulse</label>
 <%if(medExam.getPulseRates()!= null){ %>
 <input name="pulserate" type="text" tabindex="1" value="<%=medExam.getPulseRates() %>" class="auto" size="5" tabindex="1" validate="pulse,int,no" maxlength="3" />
  <%}else{%>
<input name="pulserate" type="text" tabindex="1" class="auto" size="5" tabindex="1" validate="pulse,int,no" maxlength="3" />
<% }%>
 <label class="small">/min</label> 
 <label class="medium">BP</label>
  <%if(medExam.getBp()!= null){ %>
 <input	name="bp" id="bp" type="text" value="<%=medExam.getBp() %>"  tabindex="1" class="auto" size="5" onblur="validateBpValue(this.value);" maxlength="7" />
  <%}else{%>
<input	name="bp" id="bp" type="text" tabindex="1" class="auto" size="5" onblur="validateBpValue(this.value);" maxlength="7" />
 <% }%>
 <label	class="small">mm/Hg</label>
<div class="clear"></div>

 <label>Syst Exam:</label>
 <%if(medExam.getSystExam()!= null){ %>
  <input type="text" name="SystExam" value=<%=medExam.getSystExam() %> tabindex="1" size="123" maxlength="150" class="auto" />
 <%}else{ %>
  <input type="text" name="SystExam" tabindex="1" size="123" maxlength="150" class="auto" />
<%} %>
<div class="clear"></div>
<label>Local Examination:</label>
 <%if(medExam.getLocalExamination()!= null){ %>
  <input type="text" name="LocalExamination" value=<%=medExam.getLocalExamination() %> tabindex="1" size="123" maxlength="150" class="auto" />
 <%}else{ %>
  <input type="text" name="LocalExamination" tabindex="1" size="123" maxlength="150" class="auto" />
<%} %>

<%if(requestedjsp==null || requestedjsp.equalsIgnoreCase("")){%>
<label>Opinion :</label>
 <%if(medExam.getOpinion()!= null){ %>
  <input type="text" name="Opinion" value=<%=medExam.getOpinion() %> tabindex="1" size="123" maxlength="150" class="auto" />
 <%}else{ %>
  <input type="text" name="Opinion" tabindex="1" size="123" maxlength="150" class="auto" />
<%} %>
<% }%>

<div class="clear"></div>
<div class="clear paddingTop15"></div>
<label>Investigation:</label>

<div class="clear"></div>
<div id="gridview">
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Test Name</th>
		<th scope="col">Test Result</th>
	
		</tr>

<%int inc=1;
String Labresult="NotPresent";


String template="";
int resultid=0;
if(patientInvestigationdetails!=null && patientInvestigationdetails.size()>0){
	   HashMap first = new HashMap();
	   HashMap second = new HashMap();
	   HashMap third = new HashMap();
	   int inc1=1;
		    for(PatientInvestigationDetails patientInvestigation : patientInvestigationdetails){
				String investigationName="";
		    	investigationName=patientInvestigation.getChargeCode().getChargeCodeName()+"["+patientInvestigation.getChargeCode().getId()+"]";
		    	first.put(investigationName,patientInvestigation.getChargeCode().getId());    
		    	third.put(investigationName,patientInvestigation.getId());
		    	String val="";
		    	String val1="";
		    	String val2="";
		    	int investigationId=0;
		    	
		    	if(resultList.size()>0 && inc1<=resultList.size())
		    	{
		    	DgResultEntryHeader dgEH=(DgResultEntryHeader)resultList.get(inc1-1);
		    	for(DgResultEntryDetail dgre:dgEH.getDgResultEntryDetails())
		    	{   if(dgre.getSubInvestigation()!=null)
		    		val1=dgre.getSubInvestigation().getSubInvestigationName();
		    	if(!dgre.getResultType().equalsIgnoreCase("t"))
	    		{
		    		if(dgre.getResult()!=null)
		    			val2=dgre.getResult();
		    	    val=val+","+val1+":"+val2;
	    		}
		    	    investigationId=dgre.getInvestigation().getId();
		    		System.out.println("dgre---id---"+dgre.getInvestigation().getId());
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
		    	
		    	}
		    	if(investigationId!=0&&!second.containsKey(investigationId))
		    	second.put(investigationId,val);
		    	++inc1;
		    	//
		    }
		   // System.out.println("first---"+first);
		  // System.out.println("second---"+second);
		    for (Iterator i = new InvestigationDetailByInvestigationId().sortByValue(first).iterator(); i.hasNext(); ) {
            String key = (String) i.next();
         //   System.out.printf("key: %s, value: %s\n", key, first.get(key));
            
		    

		    %>
	<tr>
	<input type="hidden" value="<%=third.get(key) %>" name="patientInvestigationdetailsId<%=inc %>"" id="patientInvestigationdetailsId<%=inc %>" />
		<td><input type="text" value="<%=key%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="chargeCodeName<%=inc %>"
			size="100" name="chargeCodeName<%=inc %>" />
</td>
<%

if(second.get(first.get(key))!=null)
	{ 
	Labresult="present";
//	System.out.println("template---"+template);
//	System.out.println("value---"+second.get(first.get(key)));
	String st=(String)second.get(first.get(key));
	String[] mySplitResult = st.split("/");
	if(!mySplitResult[0].equalsIgnoreCase("template"))
	{%>
	<td><input type="text" value="<%=second.get(first.get(key))%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
</td>
<% }else{%>
	<td><input name="resultIdTemplate<%=inc %>"
		id="resultIdTemplate<%=inc %>" type="hidden"
		value="<%=mySplitResult[1]%>"/>
		<input	type="Button" class="Button" value="Result"
		onclick="openTemplateScreen(<%=inc %>);"  /></td>
	
<%}}else{%>
<td><input type="text" value="" readonly="readonly"
			readonly="readonly" tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
</td>
<% }%>
	</tr>
	
	<% inc++;
		    }
		   
%>
<input type="hidden" value="<%=inc-1 %>" name="hiddenValue" id="hiddenValue" />

<%
}else{ %>
	<tr>
		<td>
		 <input type="text" value="" tabindex="1"
			id="chargeCodeName1" size="100" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');,'parent'}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
			size="10" maxlength="5" validate="Qty,num,no" /> <input type="hidden"
			tabindex="1" id="chargeCode1" name="chargeCode1" size="10" readonly />
		<!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
<td>
<input type="text" value="" readonly="readonly" name="Result" id="Result" />
</td>


	</tr>
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
	

<% }%>


</table>
</div>

<%if(medExam.getId()!=null)
{

%>
<input tabindex="1" name="Button"	type="button" class="button" value="Save"	onClick="submitForm('SpecialCaseSheet','medicalBoard?method=SaveCaseSheetDetails&medExamId=<%=medExam.getId() %>&Labresult=<%=Labresult.trim() %>&specialOpenion=casesheet&method12=<%=method12%>&visitId=<%=visitId%>&medExamType=<%=jspheading %>&accessjsp=<%=accessjsp%>&search=<%=search%>&requestedjsp=<%=requestedjsp %>');" />
<% }else{%>
<input type="button" onclick="submitdata()" value="Submit" class="button" name="Button" tabindex="1">
<% }%>
<input tabindex="1" class=button id=reset accessKey=r	onclick=resetCheck(); type=reset value=Reset name=Reset>
<input name="Back" type="button"	alt="Back" value="Back" class="button"	onClick="submitForm('SpecialCaseSheet','medicalBoard?&method=<%=method12%>&medExamId=<%=medExam.getId() %>&visitId=<%=visitId%>&medExamType=<%=jspheading %>&accessjsp=<%=accessjsp%>&search=<%=search%>')" />

 </div>
</form>

