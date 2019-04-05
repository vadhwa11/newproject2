
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
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasUnit"%><script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
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
	List<MasRank> masRankList = new ArrayList<MasRank>();
	if(map.get("masRankList")!=null)
	{
		masRankList = (List<MasRank>) map.get("masRankList");

	}
	Set<PatientInvestigationDetails> patientInvestigationdetails=null;
	PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
	if(map.get("patientInvestigationHeader")!=null){
		
		patientInvestigationHeader=(PatientInvestigationHeader)map.get("patientInvestigationHeader");
		System.out.println(" patientInvestigationHeader is not null");
		patientInvestigationdetails=patientInvestigationHeader.getPatientInvestigationDetails();
	}
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();	
	if(map.get("employeeList") != null){
		employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	List<MasUnit> unitList = new ArrayList<MasUnit>();
	if(map.get("masUnitList")!=null)
	{
		unitList = (List<MasUnit>)map.get("masUnitList");

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
<h2>OPINION OF THE MEDICAL BOARD</h2>
</div>

<form name="SpecialCaseSheet" method="post" action="">
<div class="Block">

<label class="max">2.Did the disability exist before service? (Y/N/Could be)</label>
<% if(medExam.getLR7()!=null && !medExam.getLR7().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MLR_7%>" class="auto" size="60" maxlength="300" value="<%=medExam.getLR7() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MLR_7%>" class="auto" size="60" maxlength="300" />
 <% }%>
 <div class="clear"></div>
<label class="max">3.In the case of disability existed at the time of the entry,is it possible that it could not be detected during the routine medical examination carried out at the time of the entry?</label>
<% if(medExam.getLR8()!=null && !medExam.getLR8().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MLR_8%>" class="auto" size="60" maxlength="300" value="<%=medExam.getLR8() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MLR_8%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>
<label class="max">4.In case of disability awarded Aggravation,weather the effects of such aggravation still persist? If yes wheather  the effect of Aggravation will persist for a material period.</label>
<% if(medExam.getLL1()!=null && !medExam.getLL1().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MLL_1%>" class="auto" size="60" maxlength="300" value="<%=medExam.getLL1() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MLL_1%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>
<label class="max">5.(a) Was the disability attributable to the individual's own negligence or misconduct? If yes,in what way ?</label>
<% if(medExam.getLL2()!=null && !medExam.getLL2().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MLL_2%>" class="auto" size="60" maxlength="300" value="<%=medExam.getLL2() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MLL_2%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>
<label class="max">(b) If not attributable, was it aggravated by the negligence or misconduct/ If so, in what way and to what percentage of the total disablement?</label>
<% if(medExam.getLL3()!=null && !medExam.getLL3().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MLL_3%>" class="auto" size="60" maxlength="300" value="<%=medExam.getLL3() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MLL_3%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>
<label class="max">( c) Has the individual refused to undergo operation/ Treatment? If so,Individual's reason will be recorded</label>
<% if(medExam.getLL4()!=null && !medExam.getLL4().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MLL_4%>" class="auto" size="60" maxlength="300" value="<%=medExam.getLL4() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MLL_4%>" class="auto" size="60" maxlength="300" />
 <% }%>
 <div class="clear"></div>
<label class="max">(d)Has the effect of the refusal been explained to and fully understood by him/her. Viz,a reduction in. or the entire withholding of any disability pension to which he/she might otherwise might be entitled?</label>
<% if(medExam.getLL5()!=null && !medExam.getLL5().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MLL_5%>" class="auto" size="60" maxlength="300" value="<%=medExam.getLL5() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MLL_5%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>
<label class="max">(e) Does the Medical Board consider it prabable that the operation/Treatment would have cured the disability or reduced by operation/ Treatment</label>
<% if(medExam.getLL6()!=null && !medExam.getLL6().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MLL_6%>" class="auto" size="60" maxlength="300" value="<%=medExam.getLL6() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MLL_6%>" class="auto" size="60" maxlength="300" />
 <% }%>
 <div class="clear"></div>
<label class="max">(f) If the reply to (e) is in affirmative,what is the probable  percentage to which the disabement could be reduced by operation/ treatment?</label>
<% if(medExam.getLL7()!=null && !medExam.getLL7().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MLL_7%>" class="auto" size="60" maxlength="300" value="<%=medExam.getLL7() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MLL_7%>" class="auto" size="60" maxlength="300" />
 <% }%>
 <div class="clear"></div>
<label class="max">(g) Does the Medical Board consider individual's refusal to submit to operation/treatment reasonable? Give reasons in support of the opinion specifying the operation/treatment recommended</label>
<% if(medExam.getLL8()!=null && !medExam.getLL8().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MLL_8%>" class="auto" size="60" maxlength="300" value="<%=medExam.getLL8() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MLL_8%>" class="auto" size="60" maxlength="300" />
 <% }%>
 <div class="clear"></div>
<label class="max">7.Is the Individual in need of further treatment and , if so , of what nature and for how long is it likely to be required?</label>
<% if(medExam.getUR1()!=null && !medExam.getUR1().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=UUR_1%>" class="auto" size="60" maxlength="300" value="<%=medExam.getUR1() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=UUR_1%>" class="auto" size="60" maxlength="300" />
 <% }%>
 <div class="clear"></div>
<label class="max">8.Does the individual require an attendent? If so how long ?</label>
<% if(medExam.getUR2()!=null && !medExam.getUR2().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=UUR_2%>" class="auto" size="60" maxlength="300" value="<%=medExam.getUR2() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=UUR_2%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>
<label class="max">Opinion of Medical Board</label>
<% if(medExam.getUR3()!=null && !medExam.getUR3().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=UUR_3%>" class="auto" size="60" maxlength="300" value="<%=medExam.getUR3() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=UUR_3%>" class="auto" size="60" maxlength="300" />
 <% }%>

<div class="clear"></div>
<%if(medExam.getId()!=null)
{

%>
<input tabindex="1" name="Button"	type="button" class="button" value="Save"	onClick="submitForm('SpecialCaseSheet','medicalBoard?method=SaveCommaningofficerOpenion&medExamId=<%=medExam.getId() %>&Labresult=present&specialOpenion=casesheet&method12=<%=method12%>&visitId=<%=visitId%>&medExamType=<%=jspheading %>&accessjsp=<%=accessjsp%>&search=<%=search%>&requestedjsp=<%=requestedjsp %>');" />
<% }else{%>
<input type="button" onclick="submitdata()" value="Submit" class="button" name="Button" tabindex="1">
<% }%>
<input tabindex="1" class=button id=reset accessKey=r	onclick=resetCheck(); type=reset value=Reset name=Reset>
<input name="Back" type="button"	alt="Back" value="Back" class="button"	onClick="submitForm('SpecialCaseSheet','medicalBoard?&method=<%=method12%>&medExamId=<%=medExam.getId() %>&visitId=<%=visitId%>&medExamType=<%=jspheading %>&accessjsp=<%=accessjsp%>&search=<%=search%>')" />

 </div>
 
</form>
<script type="text/javascript">
function FileUploadWindow()
{
	<%if(medExam.getVisit()!=null){%>
	var url="/hms/hms/medicalBoard?method=displayFileUpload&visitId=<%=medExam.getVisit().getId()%>&hinNo=<%=medExam.getVisit().getHin().getHinNo()%>&hinId=<%=medExam.getVisit().getHin().getId()%>";
	newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
    <%}%>
}
</script>
