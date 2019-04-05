
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
<h2>Statement Of Commanding Officer</h2>
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
<label>DOB</label>
 <%if(medExam.getDateOfBirth()!= null){ %>
<label class="value"><%=HMSUtil.convertDateToStringWithoutTime(medExam.getDateOfBirth()) %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>
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
<label>Date of Comm/Enrol</label>
 <%if(medExam.getDateofcommun()!= null){ %>
<label class="value"><%=HMSUtil.convertDateToStringWithoutTime(medExam.getDateofcommun()) %></label>
 <%}else{ %>
<label class="value">&nbsp;</label><%} %>

<div class="clear"></div>
 <label class="max">1. Date the Individual Joined your unit/ship</label>

<% if(medExam.getDatetheIndividual()!=null){%>
<input	tabindex="1" name="DatetheIndividual" class="date" 	 maxlength="10" id="DatetheIndividual"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
    <% }else{%>
<input	tabindex="1" name="DatetheIndividual" class="date" value=<%=currentDate %>	  maxlength="10" id="DatetheIndividual"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
  <% }%>
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReleaseDischarge.DatetheIndividual,event);" />
<div class="clear"></div>
<label class="max">2. Was he in Low Medical Category</label>
<% if(medExam.getUR1()!=null && !medExam.getUR1().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MUR_1%>" class="auto" size="60" maxlength="300" value="<%=medExam.getUR1() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MUR_1%>" class="auto" size="60" maxlength="300" />
 <% }%>
 <div class="clear"></div>
<label class="max">If yes (a) What was/were the disability/disablities?</label>
<% if(medExam.getUR2()!=null && !medExam.getUR2().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MUR_2%>" class="auto" size="60" maxlength="300" value="<%=medExam.getUR2() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MUR_2%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>
<label class="max">(b)What was has medical category</label>
<% if(medExam.getUR3()!=null && !medExam.getUR3().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MUR_3%>" class="auto" size="60" maxlength="300" value="<%=medExam.getUR3() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MUR_3%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>
<label class="max"> ( c) How long has he been lower medical category?</label>
<% if(medExam.getHowlonghashe()!=null){%>
<input tabindex="1" onKeyUp="mask(this.value,this,'2,5','/');"	name="Howlonghashe" class="date" 	  size="20" maxlength="20" value="<%=medExam.getHowlonghashe() %>"/>
   <% }else{%>
<input tabindex="1" onKeyUp="mask(this.value,this,'2,5','/');" name="Howlonghashe" class="date" value=<%=currentDate %>	  size="20" maxlength="20" />
 <% }%>
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReleaseDischarge.Howlonghashe,event);" />
<div class="clear"></div>
<label class="max">3.Was he excused any duty?</label>
<% if(medExam.getUR4()!=null && !medExam.getUR4().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MUR_4%>" class="auto" size="60" maxlength="300" value="<%=medExam.getUR4() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MUR_4%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>
<label class="max">4.nature of duties in the Unit</label>
<% if(medExam.getUR5()!=null && !medExam.getUR5().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MUR_5%>" class="auto" size="60" maxlength="300" value="<%=medExam.getUR5() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MUR_5%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>
<label class="max">5.Did the duties involve severe/exceptional stress and strain?</label>
<% if(medExam.getUR6()!=null && !medExam.getUR6().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MUR_6%>" class="auto" size="60" maxlength="300" value="<%=medExam.getUR6() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MUR_6%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>
<label class="max">(a) Since When</label>
<% if(medExam.getSinceWhen()!=null){%>
<input tabindex="1" onKeyUp="mask(this.value,this,'2,5','/');"	name="SinceWhen" class="date" 	  size="20" maxlength="20" value="<%=medExam.getSinceWhen() %>"/>
   <% }else{%>
<input tabindex="1" onKeyUp="mask(this.value,this,'2,5','/');"	name="SinceWhen" class="date" value=<%=currentDate %> 	  size="20" maxlength="20" />
 <% }%>
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReleaseDischarge.SinceWhen,event);" />
 <div class="clear"></div>
<label class="max">(b) On Special day/Occasions</label>
<% if(medExam.getUR7()!=null && !medExam.getUR7().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MUR_7%>" class="auto" size="60" maxlength="300" value="<%=medExam.getUR7() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MUR_7%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>
<label class="max">6.Was he living with his family if So?</label>
<% if(medExam.getUR8()!=null && !medExam.getUR8().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MUR_8%>" class="auto" size="60" maxlength="300" value="<%=medExam.getUR8() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MUR_8%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>
<label class="max">a) Since When </label>
<% if(medExam.getSinceWhen1()!=null){%>
<input tabindex="1"  onKeyUp="mask(this.value,this,'2,5','/');"	name="SinceWhen1"  class="date" 	  size="20" maxlength="20" value="<%=medExam.getSinceWhen1() %>"/>
   <% }else{%>
<input tabindex="1" onKeyUp="mask(this.value,this,'2,5','/');"	name="SinceWhen1" class="date" value=<%=date %>	  size="20" maxlength="20" />
 <% }%>
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReleaseDischarge.SinceWhen1,event);" />
 <div class="clear"></div>
<label class="max">(b) In Govt. Accommodation/Own arrangement</label>
<% if(medExam.getUL1()!=null && !medExam.getUL1().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MUL_1%>" class="auto" size="60" maxlength="300" value="<%=medExam.getUL1() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MUL_1%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>

 <div class="clear"></div>
<label class="max">7.Was he living in Unit lines?</label>
<% if(medExam.getUL2()!=null && !medExam.getUL2().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MUL_2%>" class="auto" size="60" maxlength="300" value="<%=medExam.getUL2() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MUL_2%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>
<label class="max">8.Dates of last leave and where spent?</label>
<% if(medExam.getDatesoflastleave()!=null){%>
<input tabindex="1" class="date" onKeyUp="mask(this.value,this,'2,5','/');"	 	name="Datesoflastleave" size="20" maxlength="20" value="<%=medExam.getDatesoflastleave() %>"/>
   <% }else{%>
<input tabindex="1" class="date" onKeyUp="mask(this.value,this,'2,5','/');"	 	value=<%=currentDate %> name="Datesoflastleave"  size="20" maxlength="20" />
 <% }%>
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReleaseDischarge.Datesoflastleave,event);" />
 <div class="clear"></div>
<label class="max">9.If disability is due to infection</label>
<% if(medExam.getUL3()!=null && !medExam.getUL3().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MUL_3%>" class="auto" size="60" maxlength="300" value="<%=medExam.getUL3() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MUL_3%>" class="auto" size="60" maxlength="300" />
 <% }%>
 <div class="clear"></div>
<label class="max">(a) Any other case in the unit</label>
<% if(medExam.getUL4()!=null && !medExam.getUL4().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MUL_4%>" class="auto" size="60" maxlength="300" value="<%=medExam.getUL4() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MUL_4%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>
<label class="max">(b) Is the disease endemic in the town in the surrounding areas?</label>
<% if(medExam.getUL5()!=null && !medExam.getUL5().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MUL_5%>" class="auto" size="60" maxlength="300" value="<%=medExam.getUL5() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MUL_5%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>

<label class="max">( c) Preventive measures taken?</label>
<% if(medExam.getUL6()!=null && !medExam.getUL6().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MUL_6%>" class="auto" size="60" maxlength="300" value="<%=medExam.getUL6() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MUL_6%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>

<label class="max">10.In case of sexually Tranmitted diseases</label>
<% if(medExam.getUL7()!=null && !medExam.getUL7().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MUL_7%>" class="auto" size="60" maxlength="300" value="<%=medExam.getUL7() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MUL_7%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>

<label class="max">(a) When & Where was it contacted?</label>
<% if(medExam.getUL8()!=null&& !medExam.getUL8().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MUL_8%>" class="auto" size="60" maxlength="300" value="<%=medExam.getUL8() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MUL_8%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>
<label class="max">(b) Name of Hospital /STD Centre when treated </label>
<% if(medExam.getLR1()!=null&& !medExam.getLR1().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MLR_1%>" class="auto" size="60" maxlength="300" value="<%=medExam.getLR1() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MLR_1%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>
<label class="max">( c) Was surveillance and follow up treatment completed ? </label>
<% if(medExam.getLR2()!=null && !medExam.getLR2().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MLR_2%>" class="auto" size="60" maxlength="300" value="<%=medExam.getLR2() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MLR_2%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>
<label class="max">(d)If surveillance and follow up treatment was not completed ,state service factors responsible</label>
<% if(medExam.getLR3()!=null && !medExam.getLR3().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=MLR_3%>" class="auto" size="60" maxlength="300" value="<%=medExam.getLR3() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=MLR_3%>" class="auto" size="60" maxlength="300" />
 <% }%>

<div class="clear"></div>
<label class="max">11.Injury Report/ IHD Case/ Any other </label>
<% if(medExam.getUR5()!=null && !medExam.getUR5().equalsIgnoreCase("NNN")){%>
<input tabindex="1" type="text" 	name="<%=UUR_5%>" class="auto" size="60" maxlength="300" value="<%=medExam.getUR5() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=UUR_5%>" class="auto" size="60" maxlength="300" />
 <% }%>
<div class="clear"></div>
<div class="clear"></div>

<label class="max">Injury Report/14 days charter of duties/any other document </label>
<input name="Send" type="button"  class="buttonBig" value="Upload Document" onClick="javascript:FileUploadWindow();" />
<div class="clear"></div>
<div class="clear"></div>

<label >Rank</label>

<select   id="<%=MLR_4 %>"	name="<%= MLR_4 %>" 	validate="Approved By,string,no" tabindex=1>
	<option value="">Select</option>
	<%	for (MasRank masrank : masRankList) {
						if ((medExam.getLR4()!=null)&&(!medExam.getLR4().equalsIgnoreCase("NNN"))&&(masrank.getId()==Integer.parseInt(medExam.getLR4()))) {
					
						%>
	<option value="<%=masrank.getId ()%>" selected="selected"><%=masrank.getRankName()%></option>
	<%}else{
		
		%>
	<option value="<%=masrank.getId ()%>" selected="selected"><%=masrank.getRankName()%></option>
	<%	}	}	%>
</select> 
<label >Name</label>

<select   id="<%=MLR_5 %>"	name="<%= MLR_5 %>" 	validate="Approved By,string,no" tabindex=1>
	<option value="">Select</option>
	<%
		String mname1=" ";
			for (MasEmployee masEmployeecode : employeeList) {
						if ((medExam.getLR5()!=null)&&(!medExam.getLR5().equalsIgnoreCase("NNN"))&&(masEmployeecode.getId()==Integer.parseInt(medExam.getLR5()))) {
					if(masEmployeecode.getMiddleName()!=null)
					{
						mname1=masEmployeecode.getMiddleName();
					}
						%>
	<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getFirstName()%> <%=mname1%>
	<%=masEmployeecode.getLastName()%></option>
	<%}else{
		
		%>
	<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getFirstName()%> <%=mname1%>
	<%=masEmployeecode.getLastName()%></option>
	<%	}	}	%>
</select> 
<label>Unit </label> 
<select id="unitId" name="<%= MLR_6 %>"  tabindex="1"	validate="Unit,string,yes" onchange="displayOtherUnit(this.value)">
	<option value="0">Select</option>
	<%
		 for(MasUnit masUnit : unitList){
			 if ((medExam.getLR6()!=null)&&(!medExam.getLR6().equalsIgnoreCase("NNN"))&&(masUnit.getId()==Integer.parseInt(medExam.getLR6()))) {
					
						%>
	<option value="<%=masUnit.getId ()%>" selected="selected"><%=masUnit.getUnitName()%></option>
	<%}else{
		
		%>
	<option value="<%=masUnit.getId ()%>" selected="selected"><%=masUnit.getUnitName()%></option>
	<%	}	}	%>
</select> 
<label><span>*</span> Date</label>
 <% if(medExam.getCommandingOfficerDate()!=null){%>
  <input	tabindex="1" name="CommandingOfficerDate"  class="date" value="<%= HMSUtil.convertDateToStringWithoutTime(medExam.getCommandingOfficerDate()) %>"
	  maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
	<% }else{%>
<input	tabindex="1" name="CommandingOfficerDate" class="date"  value="<%=currentDate %>"
	  maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
	
	<% }%>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationReleaseDischarge.CommandingOfficerDate,event);" />

 
<div class="clear"></div>
<%if(medExam.getId()!=null)
{

%>
<input tabindex="1" name="Button"	type="button" class="button" value="Save"	onClick="submitForm('SpecialCaseSheet','medicalBoard?method=SaveCommaningofficer&medExamId=<%=medExam.getId() %>&Labresult=present&specialOpenion=casesheet&method12=<%=method12%>&visitId=<%=visitId%>&medExamType=<%=jspheading %>&accessjsp=<%=accessjsp%>&search=<%=search%>&requestedjsp=<%=requestedjsp %>');" />
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
