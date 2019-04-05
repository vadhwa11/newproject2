
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MbTypeOfEntryMaster"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>


<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<SCRIPT>
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
		Map<String, Object> utilMap = new HashMap<String, Object>();
		String userName="";
		if(session.getAttribute("userName")!=null)
		 userName=(String)session.getAttribute("userName");
		
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		//String Session=(String) utilMap.get("session");
		String time = (String) utilMap.get("currentTime");		
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	
	</script>

<script type="text/javascript">

animatedcollapse.addDiv('jason', 'fade=1,height=80px')
animatedcollapse.addDiv('kelly', 'fade=1,height=100px')
animatedcollapse.addDiv('michael', 'fade=1,height=120px')

animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide3', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide4', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide5', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide6', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide7', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide8', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide9', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide10', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide11', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide12', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide13', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()


</script>

<script type="text/javascript">
<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<MbTypeOfEntryMaster> typeOfEntryMasterList = new ArrayList<MbTypeOfEntryMaster>();
List<MasUnit> masUnitList = new ArrayList<MasUnit>();
List<MasMaritalStatus> masMaritalStatusList = new ArrayList<MasMaritalStatus>();
List<MasRank> masRankList1 = new ArrayList<MasRank>();
String entryno="";
String entryno1="";
if(map.get("medicalEntryNo")!=null)
{
	entryno = (String) map.get("medicalEntryNo");

}
if(map.get("medicalEntryNo1")!=null)
{
	entryno1 = (String) map.get("medicalEntryNo1");

}

if(map.get("mbTypeOfEntryMaster")!=null)
{
	typeOfEntryMasterList = (List) map.get("mbTypeOfEntryMaster");

}
if(map.get("masUnitList")!=null)
{
	masUnitList = (List) map.get("masUnitList");

}
if(map.get("masMaritalStatusList")!=null)
{
	masMaritalStatusList = (List) map.get("masMaritalStatusList");

}

List templateList= new ArrayList();
if(map.get("templateList") != null){
templateList=(List)map.get("templateList");
}
if(map.get("masRankList")!=null)
{
	masRankList1 = (List) map.get("masRankList");

}
List visitlist = new ArrayList();

if(map.get("visit") != null){
	visitlist=(List)map.get("visit");
	System.out.println("visitlist jsp---"+visitlist.size());

	}
Visit visit=null;
if(visitlist!=null &&visitlist.size()>0)
{
 visit=(Visit)visitlist.get(0);
 System.out.println("getAge jsp---"+visit.getAge());
}

String url="";
if(map.get("url") != null){
	url = (String)map.get("url");
}
String jspheading=null;
if(map.get("jspheading") != null){
	jspheading = (String)map.get("jspheading");
}
List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
if(map.get("medExamList") != null){
	medExamList = (List<MasMedicalExaminationReportOnEntry>)map.get("medExamList");
}
MasMedicalExaminationReportOnEntry medExamObj = new MasMedicalExaminationReportOnEntry();
System.out.println("medExamList---- size---"+medExamList.size());
if(medExamList.size() > 0){
	medExamObj = medExamList.get(0);
}
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();	
if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
}
Set<PatientInvestigationDetails> patientInvestigationdetails=null;
PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
if(map.get("patientInvestigationHeader")!=null){
	
	patientInvestigationHeader=(PatientInvestigationHeader)map.get("patientInvestigationHeader");
	System.out.println(" patientInvestigationHeader is not null");
	patientInvestigationdetails=patientInvestigationHeader.getPatientInvestigationDetails();
}

Properties properties = new Properties();
String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
%>
function checkTemplateId(templateId){
	
    if(templateId=="0"){
      return true;
    }else{
      return true;
    }
  }
</script>
<% 
String message="";
if (map.get("message") != null) {
       message = (String) map.get("message");
      System.out.println("messssssss"+message);
   }
if(!message.equalsIgnoreCase("")){
	 System.out.println("messssssss bbbbbllllll"+message);
%>
<h4><%=message %></h4>
<%} %>


<!--main content placeholder starts here-->
<div class="titleBg">
<h2><%=jspheading %></h2>
</div>
<div class="clear"></div>
<form name="medicalBoardExaminationAnnual" action="" method="post">
<div class="clear paddingTop15"></div>


<div class="Block">
	<label class="Auto">Date Of Exam :</label>
<%if(medExamObj.getId()==null)
{%>	
	 <input tabindex="1" type="text"	name="<%=REPORTED_DATE %>" class="calDate" maxlength="10"  class="Auto"
		onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date %>"
		validate="Reported Date,date,no" /> 
<% }else{%>
	 <input tabindex="1" type="text"	name="<%=REPORTED_DATE %>" class="calDate" maxlength="10" disabled="disabled"
		onKeyUp="mask(this.value,this,'2,5','/');" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateOfReporting()) %>"
		validate="Reported Date,date,no" /> 

<% }%>
<img src="/hms/jsp/images/cal.gif"
		width="16" height="16" border="0" validate="Pick a date"
		class="calender"
		onclick="setdate('',medicalBoardExaminationAnnual.<%=REPORTED_DATE%>,event);" />
<%if(session.getAttribute("hospitalName")!=null){ %>
<label class="Auto">MEDICAL EXAMINATION HELD AT :</label> <label class="value"><%=((String)session.getAttribute("hospitalName")) %></label> 

<%}%>
<label class="Auto">Authority</label>
 <% if(medExamObj.getAuthority()!=null){%>
<input tabindex="1" type="text"  class="Auto" id="" name="<%=AUTHORITY_OF_BOARD %>"maxlength="100" value="<%=medExamObj.getAuthority() %>"
	onKeyUp="limitText(this,100);"  />

 <% }else{%>
<input tabindex="1" type="text"  class="Auto" id="" name="<%=AUTHORITY_OF_BOARD %>" maxlength="100" 
	onKeyUp="limitText(this,100);"  />

 <% }%>
  </div>

<div class="Block">
<input type="hidden" name="medExamId" value="<%=medExamObj.getId() %>"/>
<div class="Block">
<label>Service Number </label>
<% if(visit.getMedExamType()!=null){%>
 <input type="hidden"	value="<%= visit.getMedExamType() %>" name="medicalExamType" tabindex="2" maxlength="100" />
<% }else{%>
 <input type="hidden"	value="Annual Medical Exam(AFMSF-3B)" name="medicalExamType" tabindex="2" maxlength="100"/>
<% }%>
 <input type="text"	 name="<%=SERVICE_NO %>" tabindex="2" value="<%=visit.getHin().getServiceNo()%>"/>
 <label>Rank  </label> 
   <input type="text" value="<%= visit.getHin().getRank().getRankName() %>" name="<%=RANK%>"	tabindex="2" maxlength="100" />
  <input type="hidden" value="<%= visit.getHin().getRank().getId() %>" name="<%=RANK_ID%>"	tabindex="2" maxlength="100" />
 
 <label>Name  </label> 
  <input	type="text" value="<%= visit.getHin().getSFirstName() %>" name="<%=FULL_NAME%>"	tabindex="2" maxlength="100" />
 
 <div class="clear"></div>
 
 <label>Unit/Ship  </label> 
  <input	type="text" value="<%= visit.getHin().getUnit().getUnitName() %>" name="<%=UNIT%>"	tabindex="2" maxlength="100"/>
  <input type="hidden" value="<%= visit.getHin().getUnit().getId() %>" name="<%=UNIT_ID%>"	tabindex="2" maxlength="100"/>

 <label>Service IAF  </label> 
 <input	type="text" value="<%=  visit.getHin().getServiceType().getServiceTypeName() %>" name="serviceiaf"	tabindex="2" maxlength="100" />
  <input type="hidden" value="<%= visit.getHin().getServiceType().getId() %>" name="<%=SERVICE_TYPE_ID%>"	tabindex="2" maxlength="100" />
 <label>Branch/Trade  </label> 
<% if(visit.getHin().getTrade()!=null){%>
 <input	type="text"  name="<%=TRADE%>"	tabindex="2" maxlength="10" value="<%= visit.getHin().getTrade().getTradeName() %>"/>
  <input	type="hidden"  name="<%=TRADE_ID%>"	maxlength="10" tabindex="2" value="<%= visit.getHin().getTrade().getId() %>"/>

<% }else{%>
<input	type="text"  name="<%=TRADE%>"	tabindex="2" />
 <% }%>
 <div class="clear"></div>

 <label>DOB <span>*</span> </label>
 <% if(visit.getHin().getDateOfBirth()!=null){%>
  <input	tabindex="1" name="<%=DATE_OF_BIRTH %>" class="date" value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getDateOfBirth()) %>"
	validate="DOB,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
	<% }else{%>
<input	tabindex="1" name="<%=DATE_OF_BIRTH %>" class="date" value=""
	validate="DOB,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
	
	<% }%>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationAnnual.<%=DOB%>,event);" />

 <label>Age  </label> 
  <input	type="text" value="<%= visit.getAge() %>" name="apparentAge"	maxlength="50" tabindex="2" />

 <label>Type Of Comm <br /></label> 
<select name="typeOfCommunication" size="0" tabindex="1" id="typeOfCommunication">
<option value="0">select</option>
	<option value="PC">PC</option>
	<option value="SSC">SSC</option>
	
</select>
<script>
<%
if(medExamObj.getTypeofcommision()!= null){
%>
document.getElementById("typeOfCommunication").value='<%=medExamObj.getTypeofcommision()%>';

<%}%>
</script>
 <div class="clear"></div>
 
 <label>Date of Comm  </label> 
  <%if(visit.getHin().getCommissionDate()!=null)
 { %>
 <input	tabindex="1" name="<%=DATE_COMMENCEMENT %>" class="date"  value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getCommissionDate()) %>"	validate="Entry Date,date,no" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" />
 <% }else{%>
 <input	tabindex="1" name="<%=DATE_COMMENCEMENT %>" class="date" value="<%=date %>"	validate="Entry Date,date,no" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" />
 <% }%>
 <img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" 	onclick="setdate('',medicalBoardExaminationAnnual.<%=DATE_COMMENCEMENT%>,event);" />


 
 <label>Total Service  </label> 
  <%if(visit.getHin().getServiceYears()!=null)
 { %>
 <input	type="text" value="<%= visit.getHin().getServiceYears() %>" name="<%=TOTAL_SERVICE%>"	maxlength="100" tabindex="2" />
 <% }else{%>
 <input	type="text" value="" name="<%=TOTAL_SERVICE%>"	maxlength="100" tabindex="2" />
 <% }%>


 <label>Past Medical History  </label> 
 
 <% if(medExamObj.getPastmedicalhistory()!=null){%>
 
 <input	type="text" maxlength="20"  value="<%=medExamObj.getPastmedicalhistory() %>" name="<%=PAST_MEDICAL_HISTORY%>"	tabindex="2" />

 <% }else{%>
<input	type="text" maxlength="20"  value="" name="<%=PAST_MEDICAL_HISTORY%>"	tabindex="2" />

 <% }%>
 
 <div class="clear"></div>
 
 <label>Present Med Categ  </label> 
 <% if(medExamObj.getPresentmedicalhistory()!=null){%>
 
 <input	type="text" maxlength="20"  value="<%=medExamObj.getPresentmedicalhistory() %>" name="<%=PRESENT_MEDICAL_CATEGORY%>"	tabindex="2" />

 <% }else{%>
<input	type="text" maxlength="20"  value="" name="<%=PRESENT_MEDICAL_CATEGORY%>"	tabindex="2" />

 <% }%>

 
 
 <label >Last AME carried Out  </label> 
  <% if(medExamObj.getLastame()!=null){%>
 <input	type="text" maxlength="20"  value="<%=medExamObj.getLastame() %>" name="<%=LAST_AME%>"	tabindex="2" />
 <% }else{%>
<input	type="text" maxlength="20"  value="" name="<%=LAST_AME%>"	tabindex="2" />
 <% }%>
<label>Last AME carried On </label> 
<%if(visit.getHin().getCommissionDate()!=null)
 { %>
 <input	tabindex="1" name="<%=DATE_OF_AME %>" class="date"  value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getCommissionDate()) %>"	validate="Entry Date,date,no" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" />
 <% }else{%>
 <input	tabindex="1" name="<%=DATE_OF_AME %>" class="date" value="<%=date %>"	validate="Entry Date,date,no" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" />
 <% }%>
 <img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" 	onclick="setdate('',medicalBoardExaminationAnnual.<%=DATE_OF_AME%>,event);" />
</div>
 

</div>
<div class="clear paddingTop15"></div>
<h4>Dental <a href="javascript:animatedcollapse.toggle('slide1')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide1">
<div class="Block">
<div class="clear"></div>
<label >Total no. of Teeth</label>
  <% if(medExamObj.getTotalTeeth()!=null){%>
 
 <input tabindex="1"	type="text"   name="<%=TOTAL_NO_OF_TEETH %>" class="small" value="<%=medExamObj.getTotalTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" /> 

 <% }else{%>
<input tabindex="1"	type="text"  name="<%=TOTAL_NO_OF_TEETH %>" class="small"
	onKeyUp="isNumber(this)" maxlength="2" /> 

 <% }%>
 
	
<label class="auto">Total No. of Defective Teeth</label>
 <% if(medExamObj.getTotalDefectiveTeeth()!=null){%>
<input tabindex="1"	type="text"   name="<%=DEFECTIVE_TEETH %>" class="small" value="<%=medExamObj.getTotalDefectiveTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" /> 


 <% }else{%>
<input tabindex="1"	type="text"  name="<%=DEFECTIVE_TEETH %>" class="small"
	onKeyUp="isNumber(this)" maxlength="2" /> 


 <% }%>
	<label class="auto">Total no. of Dental Point</label> 
	<% if(medExamObj.getDenstlPoint()!=null){%>
	<input	tabindex="1" type="text"  name="<%=DENTSL_POINT %>" value="<%=medExamObj.getDenstlPoint() %>"
	onKeyUp="isNumber(this);" maxlength="2" /> 


 <% }else{%>
	<input	tabindex="1" type="text"  name="<%=DENTSL_POINT %>"
	onKeyUp="isNumber(this);" maxlength="2" />


 <% }%>

	<div class="clear"></div>
	
<label >Missing </label> 
	<% if(medExamObj.getMissingTeeth()!=null){%>
<input tabindex="1" type="text" 
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);" value="<%=medExamObj.getMissingTeeth() %>"
	maxlength="2" />
 <% }else{%>
<input tabindex="1" type="text"
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);"
	maxlength="2" />
 <% }%>
<label class="auto">Unservicable</label>
<% if(medExamObj.getUnservisableTeeth()!=null){%>
<input	tabindex="1" type="text"   name="<%=MISSING_UNSERVICABLE_TEETH %>" value="<%=medExamObj.getUnservisableTeeth() %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }else{%>
<input	tabindex="1" type="text"  name="<%=MISSING_UNSERVICABLE_TEETH %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }%> 
 <label class="auto">Condition of Gums</label>
<% if(medExamObj.getConditionOfGums()!=null){%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>" value="<%=medExamObj.getConditionOfGums() %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }else{%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }%> 
<div class="clear"></div>
	
<label >UR</label>
<input tabindex="1" type="checkbox"	name="<%=DUR_8%>" id="<%=DUR_8%>" value="" class="radioAuto"	onclick="chkValue(this);" />
<label class="smallAuto">8</label> 

<input tabindex="1" type="checkbox" name="<%=DUR_7%>" id="<%=DUR_7%>" value=""	class="radioAuto" onclick="chkValue(this);" />
<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox" name="<%=DUR_6%>" id="<%=DUR_6%>"	value="" class="radioAuto" onclick="chkValue(this);" /> 
<label class="smallAuto">6</label>

<input tabindex="1" type="checkbox"	name="<%=DUR_5%>" id="<%=DUR_5%>" value="" class="radioAuto"	onclick="chkValue(this);" />
<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox" name="<%=DUR_4%>" id="<%=DUR_4%>" value=""
	class="radioAuto" onclick="chkValue(this);" /> 
<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox" name="<%=DUR_3%>" id="<%=DUR_3%>"
	value="" class="radioAuto" onclick="chkValue(this);" /> 
<label class="smallAuto">3</label>

<input tabindex="1" type="checkbox"
	name="<%=DUR_2%>" id="<%=DUR_2%>" value="" class="radioAuto"
	onclick="chkValue(this);" /> 
<label class="smallAuto">2</label> 

<input	tabindex="1" type="checkbox" name="<%=DUR_1%>" id="<%=DUR_1%>" value=""	class="radioAuto" onclick="chkValue(this);" />
<label class="smallAuto">1</label>

<div class="clear"></div>
<label >UL</label>
<input tabindex="1" type="checkbox" name="<%=DUL_8%>" id="<%=DUL_8%>" value="" class="radioAuto"
	onclick="chkValue(this);" /> 
<label class="smallAuto">8</label> 


<input tabindex="1" type="checkbox" name="<%=DUL_7%>" id="<%=DUL_7%>" value="" class="radioAuto" onclick="chkValue(this);" /> 
<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox" name="<%=DUL_6%>" id="<%=DUL_6%>" value="" class="radioAuto" onclick="chkValue(this);" />
<label class="smallAuto">6</label> 

<input tabindex="1" type="checkbox" name="<%=DUL_5%>" id="<%=DUL_5%>" value="" class="radioAuto" onclick="chkValue(this);" />
<label class="smallAuto">5</label>
	
<input tabindex="1" type="checkbox" name="<%=DUL_4%>" id="<%=DUL_4%>" value="" class="radioAuto" onclick="chkValue(this);" />
<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox" name="<%=DUL_3%>" id="<%=DUL_3%>" value="" class="radioAuto" onclick="chkValue(this);" /> 
<label class="smallAuto">3</label> 

<input tabindex="1" type="checkbox" name="<%=DUL_2%>" id="<%=DUL_2%>" value="" class="radioAuto"
	onclick="chkValue(this);" /> 
<label class="smallAuto">2</label> 

<input tabindex="1" type="checkbox" name="<%=DUL_1%>" id="<%=DUL_1%>" value=""
	class="radioAuto" onclick="chkValue(this);" />
<label class="smallAuto">1</label> 


<div class="clear"></div>
<label >LR</label>

<input tabindex="1" type="checkbox" name="<%=DLR_8%>" id="<%=DLR_8%>" value="" class="radioAuto"
	onclick="chkValue(this);" />
<label class="smallAuto">8</label> 
	 
<input tabindex="1" type="checkbox" name="<%=DLR_7%>" id="<%=DLR_7%>" value=""
	class="radioAuto" onclick="chkValue(this);" />
<label class="smallAuto">7</label>
	 
<input tabindex="1" type="checkbox" name="<%=DLR_6%>" id="<%=DLR_6%>"
	value="" class="radioAuto" onclick="chkValue(this);" />
<label class="smallAuto">6</label>

<input tabindex="1" type="checkbox" name="<%=DLR_5%>" id="<%=DLR_5%>" value="" class="radioAuto"
	onclick="chkValue(this);" /> 
<label class="smallAuto">5</label>
	
<input tabindex="1" type="checkbox" name="<%=DLR_4%>" id="<%=DLR_4%>" value=""
	class="radioAuto" onclick="chkValue(this);" /> 
<label class="smallAuto">4</label> 
	
<input tabindex="1" type="checkbox" name="<%=DLR_3%>" id="<%=DLR_3%>"
	value="" class="radioAuto" onclick="chkValue(this);" /> 
<label class="smallAuto">3</label>

<input tabindex="1" type="checkbox" name="<%=DLR_2%>" id="<%=DLR_2%>" value="" class="radioAuto"
	onclick="chkValue(this);" /> 
<label class="smallAuto">2</label>	

<input tabindex="1" type="checkbox" name="<%=DLR_1%>" id="<%=DLR_1%>" value=""
	class="radioAuto" onclick="chkValue(this);" />
<label class="smallAuto">1</label>

<div class="clear"></div>
<label >LL</label>
<input tabindex="1" type="checkbox" name="<%=DLL_8%>" value="" id="<%=DLL_8%>" class="radioAuto"
	onclick="chkValue(this);" />
<label class="smallAuto">8</label>	

<input tabindex="1" type="checkbox" name="<%=DLL_7%>" value="" id="<%=DLL_7%>"
	class="radioAuto" onclick="chkValue(this);" />
<label class="smallAuto">7</label> 	
	 
<input tabindex="1" type="checkbox" name="<%=DLL_6%>" value=""
	id="<%=DLL_6%>" class="radioAuto" onclick="chkValue(this);" /> 
<label class="smallAuto">6</label> 

<input tabindex="1" type="checkbox" name="<%=DLL_5%>" value="" id="<%=DLL_5%>" class="radioAuto"
	onclick="chkValue(this);" /> 
<label class="smallAuto">5</label> 	

<input tabindex="1" type="checkbox" name="<%=DLL_4%>" value="" id="<%=DLL_4%>"
	class="radioAuto" onclick="chkValue(this);" /> 
<label class="smallAuto">4</label>	
	
<input tabindex="1" type="checkbox" name="<%=DLL_3%>" value=""
	id="<%=DLL_3%>" class="radioAuto" onclick="chkValue(this);" />
<label class="smallAuto">3</label>
	
<input tabindex="1" type="checkbox" name="<%=DLL_2%>" value="" id="<%=DLL_2%>" class="radioAuto"
	onclick="chkValue(this);" /> 
<label class="smallAuto">2</label> 	
	 
<input tabindex="1" type="checkbox" name="<%=DLL_1%>" value="" id="<%=DLL_1%>"
	class="radioAuto" onclick="chkValue(this);" />
<label class="smallAuto">1</label>

<div class="clear"></div>

<h4>Missing Teeth</h4>
<div class="clear"></div>
<label >UR</label>
<input tabindex="1" type="checkbox"
	name="<%=MUR_8%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MUR_7%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUR_6%>" value="" class="radioAuto" onclick="chkValue(this);" />
<label class="smallAuto">6</label> 	
<input tabindex="1" type="checkbox"
	name="<%=MUR_5%>" value="" class="radioAuto" onclick="chkValue(this);" />
<label class="smallAuto">5</label> 	

<input tabindex="1" type="checkbox"
	name="<%=MUR_4%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 	
	
<input tabindex="1" type="checkbox"
	name="<%=MUR_3%>" value="" class="radioAuto" onclick="chkValue(this);" />
<label class="smallAuto">3</label> 	
	
<input tabindex="1" type="checkbox"
	name="<%=MUR_2%>" value="" class="radioAuto" onclick="chkValue(this);" />
<label class="smallAuto">2</label> 	

<input tabindex="1" type="checkbox"
	name="<%=MUR_1%>" value="" class="radioAuto" onclick="chkValue(this);" />
<label class="smallAuto">1</label> 

<div class="clear"></div>
<label>UL</label>
<input tabindex="1" type="checkbox"
	name="<%=MUL_8%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MUL_7%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=MUL_6%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUL_5%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=MUL_4%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=MUL_3%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUL_2%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUL_1%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 


<div class="clear"></div>
<label >LR</label>
<input tabindex="1" type="checkbox"
	name="<%=MLR_8%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MLR_7%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLR_6%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLR_5%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLR_4%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLR_3%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLR_2%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLR_1%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 

<div class="clear"></div>
<label class=>LL</label>
<input tabindex="1" type="checkbox"
	name="<%=MLL_8%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MLL_7%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLL_6%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLL_5%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLL_4%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLL_3%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLL_2%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLL_1%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> <div class="clear"></div>


<h4>Unserviceable Teeth</h4>
<div class="clear"></div>
<label >UR</label>
<input tabindex="1" type="checkbox"
	name="<%=UUR_8%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=UUR_7%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUR_6%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUR_5%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUR_4%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUR_3%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUR_2%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUR_1%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>
	<div class="clear"></div>


<div class="clear"></div>
<label >UL</label>
<input tabindex="1" type="checkbox"
	name="<%=UUL_8%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=UUL_7%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUL_6%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUL_5%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUL_4%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUL_3%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUL_2%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUL_1%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 


<div class="clear"></div>
<label >LR</label>
<input tabindex="1" type="checkbox"
	name="<%=ULR_8%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=ULR_7%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULR_6%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULR_5%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULR_4%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULR_3%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULR_2%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULR_1%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 

<div class="clear"></div>
<label >LL</label>
<input tabindex="1" type="checkbox"
	name="<%=ULL_8%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=ULL_7%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULL_6%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULL_5%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULL_4%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULL_3%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULL_2%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULL_1%>" value="" class="radioAuto" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> 
<div class="clear"></div>
<label class="medium"> Remarks</label>
 <%
if(medExamObj.getRemarksTeath()!=null){%>
 <textarea rows="" cols=""	name="<%=DENTAL_REMARKS %>" class="large" onkeyup="chkLength(this,300);" value="<%=medExamObj.getRemarksTeath() %>"><%=medExamObj.getRemarksTeath() %></textarea>
 <% }else{%>
 <textarea rows="" cols=""	name="<%=DENTAL_REMARKS %>" class="large" onkeyup="chkLength(this,300);"></textarea>
 <% }%>

	
	<div class="clear"></div>
	<div class="clear"></div>
	</div>
</div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>


<h4> PHYSICAL DEVELOPMENT <a href="javascript:animatedcollapse.toggle('slide2')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide2">
<div class="Block">
<label >Height</label> 
  <% if(medExamObj.getHeight()!=null){%>
<input tabindex="1" type="text" id="height" class="date"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)" value="<%=medExamObj.getHeight() %>"
	maxlength="6" onblur="checkForWiegth(this.value,id);;calculateBMI();" /><label class="smallAuto">cm</label>

 <% }else{%>
<input tabindex="1" type="text"  id="height"	class="date"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)"
	maxlength="6" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="smallAuto">cm</label>

 <% }%>


<label	>Weight</label> 
  <% if(medExamObj.getActualweight()!=null){%>
<input tabindex="1" type="text"   id="weight" class="date"	name="<%=ACTUAL_WEIGHT %>" maxlength="6" value="<%=medExamObj.getActualweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="smallAuto">kg</label>

 <% }else{%>
<input tabindex="1" type="text"  id="weight" class="date"	name="<%=ACTUAL_WEIGHT %>" maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="smallAuto">kg</label>

 <% }%>


<label	>Ideal Weight</label> 
  <% if(medExamObj.getIdealweight()!=null){%>
<input tabindex="1" type="text"   id="" name="<%=IDEAL_WEIGHT %>" class="date"	maxlength="6" value="<%=medExamObj.getIdealweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }else{%>
<input tabindex="1" type="text"   id="" name="<%=IDEAL_WEIGHT %>" class="date"	maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }%>

<div class="clear"></div>
<label	>Over Weight</label> 
  <% if(medExamObj.getOverweight()!=null){%>
<input tabindex="1" type="text"   id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>" class="date"	maxlength="6" value="<%=medExamObj.getOverweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }else{%>
<input tabindex="1" type="text"   id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>"  class="date"	maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }%>


<label	>Waist</label> 
  <% if(medExamObj.getWaist()!=null){%>
<input tabindex="1" type="text"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="6" value="<%=medExamObj.getWaist() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }else{%>
<input tabindex="1" type="text"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }%>


<label	>Chest Full Expansion</label> 
  <% if(medExamObj.getChestfullexpansion()!=null){%>
<input tabindex="1" type="text"   id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" class="date"	 maxlength="6" value="<%=medExamObj.getChestfullexpansion() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20" /><label class="smallAuto">cm</label>

 <% }else{%>
<input tabindex="1" type="text"  id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" class="date"	 maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20"  /><label class="smallAuto">cm</label>

 <% }%>

<div class="clear"></div>
<label>Range Of Expansion</label> 
  <% if(medExamObj.getRangeofexpansion()!=null){%>
<input tabindex="1" type="text"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="6" value="<%=medExamObj.getRangeofexpansion() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }else{%>
<input tabindex="1" type="text"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }%>


<label	>BMI</label> 
  <% if(medExamObj.getBhi()!=null){%>
<input tabindex="1" type="text"  id="bmi" name="<%=BHI %>" maxlength="6" value="<%=medExamObj.getBhi() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }else{%>
<input tabindex="1" type="text"  id="bmi" name="<%=BHI %>" maxlength="6" 
	onKeyUp="limitText(this,6);"  class="auto" size="20" />

 <% }%>


<label	>Body Fat</label> 
  <% if(medExamObj.getBodyfat()!=null){%>
<input tabindex="1" type="text"  id="<%=BODY_FAT %>" name="<%=BODY_FAT %>"maxlength="6" value="<%=medExamObj.getBodyfat() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }else{%>
<input tabindex="1" type="text"  id="<%=BODY_FAT %>" name="<%=BODY_FAT %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }%>
<div class="clear"></div>
<label	>Skin Fold Thickness</label> 
  <% if(medExamObj.getSignfoldthickness()!=null){%>
<input tabindex="1" type="text"  id="<%=THICKNESS %>" name="<%=THICKNESS %>" maxlength="6" value="<%=medExamObj.getSignfoldthickness() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }else{%>
<input tabindex="1" type="text"   id="<%=THICKNESS %>" name="<%=THICKNESS %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }%>

<label>Sports Man</label>

<!-- Commented By Ritu as per testing at 412 AFS  Date: 22 June 2011-->


 <%-- <% if(medExamObj.getSportman()!=null){%>
<input tabindex="1" type="text"   id="<%=SPORTS %>" name="<%=SPORTS %>" maxlength="6" value="<%=medExamObj.getSportman() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />
 <% }else{%>
<input tabindex="1" type="text"  id="<%=SPORTS %>" name="<%=SPORTS %>"  maxlength="6"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }%>  --%> 
 
 <select name="<%=SPORTS %>"  id="<%=SPORTS %>" validate="Sports Man,stirng,no">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script type="text/javascript">
<% if(medExamObj.getSportman()!=null){%>
document.getElementById('sport').value = '<%=medExamObj.getSportman()%>'
<%}%>
</script>


</div>
</div>

<div class="clear paddingTop15"></div>


<h4>Vision  <a href="javascript:animatedcollapse.toggle('slide3')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide3">
<table width="50%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Distant Vision</th>
		<th scope="col">R</th>
		<th scope="col">L</th>
		<th scope="col">Near Vision</th>
		<th scope="col">R</th>
		<th scope="col">L</th>
		<th scope="col">CP</th>
	</tr>
	<tr>
		<td>Without Glasses</td>
		<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesLDistant()!=null){%>
 <input tabindex="1" type="text"   	name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="6" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text"  	name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="6" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesLDistant()!=null){%>
 <input tabindex="1" type="text"  	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="6" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text"   	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="6" />
 <% }%>
 </td>
		
		<td>Without Glasses</td>
			<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="6" value="<%=medExamObj.getWithoutGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="6" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="6" value="<%=medExamObj.getWithoutGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="6" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getNearVisionWithoutGlassCp()!=null){%>
 <input tabindex="1" type="text"  name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="6" value="<%=medExamObj.getNearVisionWithoutGlassCp()%>"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="6" />
 <% }%>
 </td>
		
	</tr>
	<tr>
		<td>With Glasses</td>
		<td width="10%">
	
  <% if(medExamObj.getWithGlassesRDistant()!=null){%>
 <input tabindex="1" type="text" name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="6" value="<%=medExamObj.getWithGlassesRDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text"	name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="6" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" 	name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="6" value="<%=medExamObj.getWithGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="6" />
 <% }%>
 </td>	
		
		<td>With Glasses</td>
			<td width="10%">
	
  <% if(medExamObj.getWithGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" name="<%=WITH_GLASSES_NEAR_R %>" maxlength="6" value="<%=medExamObj.getWithGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITH_GLASSES_NEAR_R %>" maxlength="6" />
 <% }%>
 </td>	
 	<td width="10%">
	
  <% if(medExamObj.getWithGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text"	name="<%=WITH_GLASSES_NEAR_L %>" maxlength="6" value="<%=medExamObj.getWithGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" name="<%=WITH_GLASSES_NEAR_L %>" maxlength="6" />
 <% }%>
 </td>	
 	<td width="10%">
	
  <% if(medExamObj.getNearVisionWithGlassCp()!=null){%>
 <input tabindex="1" type="text"  	name="<%=WITH_GLASSES_NEAR_CP %>" maxlength="6" value="<%=medExamObj.getNearVisionWithGlassCp()%>"/>
 <% }else{%>
<input tabindex="1" type="text" 	name="<%=WITH_GLASSES_NEAR_CP %>" maxlength="6" />
 <% }%>
 </td>	
		
	</tr>

</table>

	</div>

<div class="clear paddingTop15"></div>

<h4> Hearing <a	href="javascript:animatedcollapse.toggle('slide4')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide4">
<div class="Block">
<div class="clear"></div>

<label>Hearing <br /><span class="sublabel">RFW(Cms)</span></label> 
<% if(medExamObj.getEarHearingRfw() != null){ %>
<input tabindex="1" type="text" maxlength="20"  id="hrfw" name="<%=HEARING_R_F_W %>" value="<%=medExamObj.getEarHearingRfw()   %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	<%}else{ %>
	<input tabindex="1" type="text" maxlength="20"  id="hrfw" name="<%=HEARING_R_F_W %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	
	<%} %>
	<label>Hearing <br /><span class="sublabel">LFW(Cms)</span></label> 
<% if(medExamObj.getEarHearingLfw() != null){ %>	
<input tabindex="1" type="text" maxlength="20"  id="hlfw" value="<%=medExamObj.getEarHearingLfw()  %>" name="<%=HEARING_L_F_W%>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	<%}else{ %>
	<input tabindex="1" type="text" maxlength="20"  id="hlfw" name="<%=HEARING_L_F_W %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	
	<%} %>
	
	<label>Hearing Both <br /><span class="sublabel">FW(Cms)</span></label> 
	<% if(medExamObj.getEarHearingBothFw() != null){ %>
	<input tabindex="1" type="text" maxlength="20"  id="bothfw"	name="<%=HEARING_BOTH_FW %>" value="<%= medExamObj.getEarHearingBothFw() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<%}else{ %>
		<input tabindex="1" type="text" maxlength="20"  id="bothfw"	name="<%=HEARING_BOTH_FW %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
	
	<%} %>
	
<div class="clear"></div>

<label>Hearing <br /><span class="sublabel">RCV(Cms)</span></label>
<% if(medExamObj.getHearingRcv() != null){ %>
 <input tabindex="1" type="text" maxlength="20"  id="hrcv" name="<%=HEARING_R_C_V %>" value="<%= medExamObj.getHearingRcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<%}else{ %>	
	 <input tabindex="1" type="text" maxlength="20"  id="hrcv" name="<%=HEARING_R_C_V %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" />
	<%} %>
	 <label>Hearing <br /><span class="sublabel">LCV(Cms)</span></label>
	 
	 <% if(medExamObj.getHearingLcv() != null){ %>
	  <input tabindex="1" type="text" maxlength="20"  id="hlcv" name="<%=HEARING_L_C_V %>" value="<%= medExamObj.getHearingLcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" /> 
	  <%}else{ %>
	    <input tabindex="1" type="text" maxlength="20"  id="hlcv" name="<%=HEARING_L_C_V %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
	  <%} %>
	  <label>Hearing Both <br /><span class="sublabel">CV(Cms)</span></label> 
	  	 <% if(medExamObj.getHearingBothCv() != null){ %>
	  <input tabindex="1" type="text" maxlength="20"  id="bothcv" name="<%=HEARING_BOTH_CV %>" value="<%= medExamObj.getHearingBothCv()  %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<%}else{ %>
 <input tabindex="1" type="text" maxlength="20"  id="bothcv" name="<%=HEARING_BOTH_CV %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
<%} %>
<div class="clear"></div>
<label > Tympanic Membrance intact<br /><span class="sublabel">(Left)</span></label> 
<select name="<%=TYMPANIC_L %>" size="0" tabindex="1" id="tympanic_l">
<option value="0">select</option>
	<option value="Y">Y</option>
	<option value="N">N</option>
	
</select>
<script>
<%
if(medExamObj.getTympanicL()!= null){
%>
document.getElementById("tympanic_l").value='<%=medExamObj.getTympanicL()%>';

<%}%>
</script>
<label >Tympanic Membrance intact<br /><span class="sublabel">(Right)</span></label> 
<select name="<%=TYMPANIC_R %>" size="0" tabindex="1" id="tympanic_r">
<option value="0">select</option>
	<option value="Y">Y</option>
	<option value="N">N</option>
	
</select>
<script>
<%
if(medExamObj.getTympanicR()!= null){
%>
document.getElementById("tympanic_r").value='<%=medExamObj.getTympanicR()%>';

<%}%>
</script>
 <label>Mobility <br /><span class="sublabel">(Valsalva)</span></label> 
	  	 <% if(medExamObj.getMobilityL() != null){ %>
	  <input tabindex="1" type="text"  name="<%=MOBILITYL %>" maxlength="100"  value="<%= medExamObj.getMobilityL()  %>"  />
<%}else{ %>
 <input tabindex="1" type="text"  name="<%=MOBILITYL %>"  maxlength="100"  />
<%} %> 
<div class="clear"></div>
<label>Nose, Throat and Sinuses</label>
	  	 <% if(medExamObj.getNosethroat() != null){ %>
	  <input tabindex="1" type="text" maxlength="100"  id="bothcv" name="<%=NOSE_THROAT %>" value="<%= medExamObj.getNosethroat()  %>"  />
<%}else{ %>
 <input tabindex="1" type="text"   id="bothcv" name="<%=NOSE_THROAT %>"  maxlength="100"  />
<%} %>
<label>Audiometry Record <br /> <span class="sublabel">(If indicated)</span></label>
	  	 <% if(medExamObj.getAudiometryRecord() != null){ %>
	  <input tabindex="1" type="text" maxlength="10"  id="bothcv" name="<%=AUDIOMETRY_RECORD %>" value="<%= medExamObj.getAudiometryRecord()  %>"  />
<%}else{ %>
 <input tabindex="1" type="text"   id="bothcv" name="<%=AUDIOMETRY_RECORD %>"  maxlength="10"  />
<%} %>
</div>
</div>
<!-- fayaz added -->
<div class="clear paddingTop15"></div>
<h4>Investigation <a href="javascript:animatedcollapse.toggle('slide5')">(Click Here)</a></h4>
<div id="slide5">
<div class="Block">
<label >Template</label>
<div id="investigationDiv">
<select name="investigationTemplateId"	tabindex="1" onchange="showHideInvestigationTemplateCombo(this.value);">
	<option value="0">Select</option>
	<%
			   Iterator itr1=templateList.iterator();
			   while(itr1.hasNext())
			   {
				   OpdTemplate opdTemplate=(OpdTemplate)itr1.next();
				   String templateType=opdTemplate.getTemplateType();
				   if(templateType.equalsIgnoreCase("I"))
				   {
			%>
	<option value="<%=opdTemplate.getId()%>"><%=opdTemplate.getId()+" "+opdTemplate.getTemplateName()%></option>
	<%
		   }
	      }

		%>

</select>
</div>
<div id="createInvestigationDivToShowHide">
<input	name="investigationTemplate" type="button"	value="Create Template" tabindex="1" class="buttonBig" onclick="showCreateInvestigationTemplate();" />
</div>
<div id="copyPrevInvestigationTemplateDiv" style="display: none">
<input name="copyPrevInvestigationTemplate" tabindex="1" type="button"	value="Copy Previous" class="buttonBig"  />
</div>

<div id="investigationImportButton1" >
<input	name="investigationImportButton1" tabindex="1" type="button"	value="IMPORT" class="buttonBig"	onclick="getListForTreatment('investigationDiv');" />
</div>
</div>
<div class="clear"></div>
<div id="gridview">
<div id="ac2update"	style="display: none;" class="autocomplete"></div>

<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid1">
	<tr>
	<th scope="col">Clinical Notes</th>

</tr>
<tr>
	<td><input type="text" name="clinicalNotes1" tabindex="1" size="100" maxlength="45" /></td>
	
	</tr>
	</table>
	<div class="clear paddingTop15"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Test Name</th>
		<th scope="col">Add</th>
        <th scope="col">Delete</th>
		</tr>

<%int inc=1;
if(patientInvestigationHeader.getId()!=null)
{
%>
<input type="hidden" value="<%=patientInvestigationHeader.getId() %>" name="patientInvestigationHeaderId" id="patientInvestigationHeaderId" />
<% 
}else{%>
<input type="hidden"  name="patientInvestigationHeaderId" id="patientInvestigationHeaderId" />
<% }
if(patientInvestigationdetails!=null && patientInvestigationdetails.size()>0){


		    for(PatientInvestigationDetails patientInvestigation : patientInvestigationdetails){
				String investigationName="";
		    	investigationName=patientInvestigation.getChargeCode().getChargeCodeName()+"["+patientInvestigation.getChargeCode().getId()+"]";
			    %>
	<tr>
	<input type="hidden" value="<%=patientInvestigation.getId() %>" name="patientInvestigationdetailsId<%=inc %>"" id="patientInvestigationdetailsId" />
		<td><input type="text" value="<%=investigationName%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="chargeCodeName<%=inc %>"
			size="175" name="chargeCodeName<%=inc %>" />
</td>
<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation();" /></td>

		


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
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
			size="10" maxlength="6" validate="Qty,num,no" /> <input type="hidden"
			tabindex="1" id="chargeCode1" name="chargeCode1" size="10" readonly />
		<!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation();" /></td>


	</tr>
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />

<% }%>


</table>
</div>
</div>

<div class="Clear paddingTop15"></div>

<h4> CARDIO VASCULAR SYSTEM <a	href="javascript:animatedcollapse.toggle('slide6')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide6">
<div class="Block">
<div class="clear"></div>
<label>Pulse</label>
 <% if(medExamObj.getPulseRates()!=null){%>
  <input tabindex="1" type="text" maxlength="20"  name="<%=PULSE_RATES%>" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getPulseRates() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="20"  name="<%=PULSE_RATES%>" class="Auto" size="22" maxlength="20" />
 <% }%>
 <label>BP</label> 
<% if(medExamObj.getBp()!=null){%>
  <input tabindex="1" type="text" maxlength="20"  name="<%=BP1%>" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getBp() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="20"  name="<%=BP1%>" class="Auto" size="22" maxlength="20" />
 <% }%>
<label>Arterial Walls</label>
<% if(medExamObj.getArterialWalls()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%= ARTERIAL_WALLS%>" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getArterialWalls() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" maxlength="20" 	name="<%= ARTERIAL_WALLS%>" class="Auto" size="22" maxlength="20" />
 <% }%>


<div class="clear"></div>
<label>Heart Size</label>
<% if(medExamObj.getHeartSize()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%= HEART_SIZE%>" class="Auto" size="22" maxlength="20" value="<%=medExamObj.getHeartSize() %>"/>
 <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%= HEART_SIZE%>" class="Auto" size="22" maxlength="20" />
 <% }%>


 <label>Sounds</label>
 <% if(medExamObj.getSounds()!=null){%>
 <input tabindex="1" type="text" maxlength="20"  name="<%= SOUND%>" class="Auto"	size="22" maxlength="20" value="<%=medExamObj.getSounds() %>"/> 

 <% }else{%>
 <input tabindex="1" type="text" maxlength="20"  name="<%= SOUND%>" class="Auto"	size="22" maxlength="20" /> 
 <% }%>
<label>Rhythm</label>
<% if(medExamObj.getRhythm()!=null){%>
 <input tabindex="1" type="text" maxlength="20"  name="<%= RHYTHM%>" class="Auto"	size="22" maxlength="20" value="<%=medExamObj.getRhythm() %>"/> 

 <% }else{%>
 <input tabindex="1" type="text" maxlength="20"  name="<%= RHYTHM%>" class="Auto"	size="22" maxlength="20" /> 
 <% }%>


<div class="clear"></div>

</div>
</div>

<div class="clear paddingTop15"></div>

<h4>RESPIRATORY SYSTEM <a href="javascript:animatedcollapse.toggle('slide7')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide7">
<div class="Block">
<div class="clear"></div>
<label class="auto"> Respiratory System</label>
<% if(medExamObj.getRespiratorySystem()!=null){%>
  <input tabindex="1" type="text" maxlength="20" 	name="<%=RESPIRATORY_SYSTEM %>" class="Auto" size="120" maxlength="100" value="<%=medExamObj.getRespiratorySystem() %>"/>
   <% }else{%>
  <input tabindex="1" type="text" maxlength="20" 	name="<%=RESPIRATORY_SYSTEM %>" class="Auto" size="120" maxlength="100" />
 <% }%>


<div class="clear"></div>
</div>
</div>

<div class="clear paddingTop15"></div>


<h4>GASTRO INTESTINAL SYSTEM <a	href="javascript:animatedcollapse.toggle('slide8')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide8">
<div class="Block">
<div class="clear"></div>
<label > Liver Palpalable</label> 
<% if(medExamObj.getLiver()!=null){%>
  <input tabindex="1" type="text" maxlength="20" 	name="liver" class="Auto" size="120" maxlength="100" value="<%=medExamObj.getLiver() %>"/>
   <% }else{%>
  <input tabindex="1" type="text" maxlength="20" 	name="liver" class="Auto" size="120" maxlength="100" />
 <% }%>

<label class="auto"> Spleen Palpalable</label> 
<% if(medExamObj.getSpleen()!=null){%>
  <input tabindex="1" type="text" maxlength="20" 	name="spleen" class="Auto" size="120" maxlength="100" value="<%=medExamObj.getSpleen() %>"/>
   <% }else{%>
  <input tabindex="1" type="text" maxlength="20" 	name="spleen" class="Auto" size="120" maxlength="100" />
 <% }%>

<div class="clear"></div>
</div>
</div>
<div class="clear paddingTop15"></div>

<h4>CENTRAL NERVOUS SYSTEM <a href="javascript:animatedcollapse.toggle('slide9')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide9">
<div class="Block">
<div class="clear"></div>
<label > Higher Mental Func</label> 
<% if(medExamObj.getHigherMentalFunction()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=HIGHER_MENTAL_FUNCTION %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getHigherMentalFunction() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=HIGHER_MENTAL_FUNCTION %>" class="Auto" size="20" maxlength="20" />
 <% }%>

<label > Speech</label> 
<% if(medExamObj.getSpeech()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=SPEECH %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getSpeech() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=SPEECH %>" class="Auto" size="20" maxlength="20" />
 <% }%>


<label > Reflexes</label> 
<% if(medExamObj.getReflexes()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=REFLEXES %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getReflexes() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=REFLEXES %>" class="Auto" size="20" maxlength="20" />
 <% }%>


<div class="clear"></div>
<label > Tremors</label> 
<select name="<%=TREMORS %>" size="0" tabindex="1" id="tremors">
<option value="0">select</option>
	<option value="Nil">Nil</option>
	<option value="Fine">Fine</option>
	<option value="Coarse">Coarse</option>
</select>
<script>
<%
if(medExamObj.getTremors()!= null){
%>
document.getElementById("tremors").value='<%=medExamObj.getTremors()%>';

<%}%>
</script>

<label > Self Balancing Test</label> 

<select name="<%=SELF_BALANCING_TEST %>" size="0" tabindex="1" id="selfbalancingtest">
<option value="0">select</option>
	<option value="Fairly">Fairly</option>
	<option value="Steady">Steady</option>
	<option value="Unsteady">Unsteady</option>
</select>
<script>
<%
if(medExamObj.getSelfBalancingTest()!= null){
%>
document.getElementById("selfbalancingtest").value='<%=medExamObj.getSelfBalancingTest()%>';

<%}%>
</script>
<div class="clear"></div>
<div class="division"></div>

<div class="clear"></div>
<label >Locomoter System</label> 
<% if(medExamObj.getLocomoterSystem()!=null){%>
<input tabindex="1" type="text" name="locomoterSystem" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getLocomoterSystem() %>"/>
   <% }else{%>
<input tabindex="1" type="text" name="locomoterSystem" class="Auto" size="20" maxlength="10" />
 <% }%>
<label>Spine</label> 
<% if(medExamObj.getSpine()!=null){%>
<input tabindex="1" type="text" name="spine" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getSpine() %>"/>
   <% }else{%>

<input tabindex="1" type="text" name="spine" class="Auto" size="20" maxlength="10" />
 <% }%>


<label>Hernia</label> 
<% if(medExamObj.getHerniaMusic()!=null){%>
<input tabindex="1" type="text"  name="<%=HERNIA_MUSCLE %>" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getHerniaMusic() %>"/>
   <% }else{%>

<input tabindex="1" type="text" name="<%=HERNIA_MUSCLE %>" class="Auto" size="20" maxlength="10" />
 <% }%>


<div class="clear"></div>
<label>Hydrocele</label> 
<% if(medExamObj.getHydrocele()!=null){%>
<input tabindex="1" type="text" name="<%=HYDROCELE %>" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getHydrocele() %>"/>
   <% }else{%>
   
<input tabindex="1" type="text" name="<%=HYDROCELE %>" class="Auto" size="20" maxlength="10" />
 <% }%>


<label>Haemorrhoids</label> 
<% if(medExamObj.getHemorrhoids()!=null){%>
<input tabindex="1" type="text" name="<%=HEMONHOIDS %>" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getHemorrhoids() %>"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=HEMONHOIDS %>" class="Auto" size="20" maxlength="10" />
 <% }%>


<label>Breast</label> 
<% if(medExamObj.getBreasts()!=null){%>
<input tabindex="1" type="text" name="<%=BREASTS %>" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getBreasts() %>"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=BREASTS %>" class="Auto" size="20" maxlength="10" />
 <% }%>


<div class="clear"></div>

</div>
</div>
<div class="clear paddingTop15"></div>

<h4>GYNAECOLOGY EXAM <a href="javascript:animatedcollapse.toggle('slide10')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide10">
<div class="Block">
<label >Menstrual History</label>
<% if(medExamObj.getMenstrualHistory()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=MENSTRUAL_HISTORY %>" class="Auto" size="20" maxlength="30" value="<%=medExamObj.getMenstrualHistory() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=MENSTRUAL_HISTORY %>" class="Auto" size="20" maxlength="30" />
 <% }%>
 

<label>LMP</label>
<% if(medExamObj.getLmp()!=null){%>
<input tabindex="1" type="text"  	name="<%=LMP %>" class="Auto" size="20" maxlength="3" value="<%=medExamObj.getLmp() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=LMP %>" class="Auto" size="20" maxlength="3" />
 <% }%>

<label >No. of pregnancies</label>
<% if(medExamObj.getNoOfPregnancies()!=null){%>
<input tabindex="1" type="text" 	name="<%=NO_OF_PREGNANCY %>" class="Auto" size="20" maxlength="3" value="<%=medExamObj.getNoOfPregnancies() %>"  onkeyup="isNumber1(this)"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=NO_OF_PREGNANCY %>" class="Auto" size="20" maxlength="3"  onkeyup="isNumber1(this)"/>
 <% }%>
 
<div class="clear"></div>	
<label >No of Abortions</label>
<% if(medExamObj.getNoOfAbortions()!=null){%>
<input tabindex="1" type="text" id="noofabo"	name="<%=NO_OF_ABORTION %>" class="Auto" size="20" maxlength="3" value="<%=medExamObj.getNoOfAbortions() %>"  onkeyup="isNumber1(this)"/>
   <% }else{%>
<input tabindex="1" type="text" id="noofabo"	name="<%=NO_OF_ABORTION %>" class="Auto" size="20" maxlength="3"  onkeyup="isNumber1(this)"/>
 <% }%>
<label >No. of Children</label> 
<% if(medExamObj.getNoOfChildren()!=null){%>
<input tabindex="1" type="text" 	name="<%=NO_OF_CHILDREN %>" class="Auto" size="20" maxlength="3" value="<%=medExamObj.getNoOfChildren() %>"  onkeyup="isNumber1(this)"/>
   <% }else{%>
<input tabindex="1" type="text"  	name="<%=NO_OF_CHILDREN %>" class="Auto" size="20" maxlength="3"  onkeyup="isNumber1(this)"/>
 <% }%>


<label >Date <br /><span class="sublabel">(last confinement)</span></label>
<% if(medExamObj.getLastConfinementDate()!=null){%>
<input tabindex="1" type="text"  class="calDate" readonly="readonly " value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getLastConfinementDate()) %>"	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" /> 
   <% }else{%>
<input tabindex="1" type="text"  class="calDate" readonly="readonly "	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" /> 
 <% }%>


<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',medicalBoardExaminationAnnual.<%=DATE_OF_LASTCONFINEMENT%>,event);" />
<div class="clear"></div>
<label >Vaginal Discharge</label>
<% if(medExamObj.getVaginalDischarge()!=null){%>
<input tabindex="1" type="text" 	name="<%=VAGINAL_DISCHARGE %>" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getVaginalDischarge() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=VAGINAL_DISCHARGE %>" class="Auto" size="20" maxlength="10" />
 <% }%>
 

<label	>Prolapse</label> 
<% if(medExamObj.getProlapse()!=null){%>
<input tabindex="1" type="text" 	name="<%=PROLAPSE %>" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getProlapse() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=PROLAPSE %>" class="Auto" size="20" maxlength="10" />
 <% }%>


<label >USG Abdomen</label> 
<% if(medExamObj.getUsgAbdomen()!=null){%>
<input tabindex="1" type="text" name="<%=USG_ABORTION %>" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getUsgAbdomen() %>"/>
   <% }else{%>
<input tabindex="1" type="text" name="<%=USG_ABORTION %>" class="Auto" size="20" maxlength="10" />
 <% }%>



</div>
</div>

<div class="clear paddingTop15"></div>
<h4>IMMUNIZATION STATUS <a	href="javascript:animatedcollapse.toggle('slide11')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide11">
<div class="Block">
<div class="clear"></div>
<label > Give On</label> 
<% if(medExamObj.getGiveOn()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=GIVE_ON %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getGiveOn() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=GIVE_ON %>" class="Auto" size="20" maxlength="20" />
 <% }%>
<label >Batch No</label> 
<% if(medExamObj.getBatchNo()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=BATCH_NO %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getBatchNo() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=BATCH_NO %>" class="Auto" size="20" maxlength="20" />
 <% }%>


<label >DOM</label> 
<% if(medExamObj.getDom()!=null){%>
<input tabindex="1" type="text" maxlength="20"  class="calDate" readonly="readonly " name="<%=DOM %>" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" validate="DOM Date,date,no" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDom()) %>"/> 
   <% }else{%>
<input tabindex="1" type="text" maxlength="20"  class="calDate" readonly="readonly " name="<%=DOM %>" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" validate="DOM Date,date,no" />  <% }%>
<img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',medicalBoardExaminationAnnual.<%=DOM%>,event);" />

<div class="clear"></div>
</div>
</div>

<div class="clear paddingTop15"></div>
<h4>LIFE CYCLE FACTORS <a	href="javascript:animatedcollapse.toggle('slide12')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide12">
<div class="Block">
<div class="clear"></div>
<label> Coronary Risk Factors</label> 
<% if(medExamObj.getCoronaryRiskFactor()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=CORONORY_RISK_FACTOR %>"  size="20" maxlength="20" value="<%=medExamObj.getCoronaryRiskFactor() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=CORONORY_RISK_FACTOR %>" size="20" maxlength="20" />
 <% }%>




<label >F.M. of DM</label> 
<select name="<%=FM_DM %>" size="0" tabindex="1" id="fmdm">
<option value="0">select</option>
	<option value="Malignancy">Malignancy</option>
	<option value="HTM">HTM</option>
	<option value="Hyperlypidemia">Hyperlypidemia</option>
	<option value="Arthritis">Arthritis</option>
</select>
<script>
<%
if(medExamObj.getFmdm()!= null){
%>
document.getElementById("fmdm").value='<%=medExamObj.getFmdm()%>';

<%}%>
</script>

<label >Any Known Allergy</label> 
<% if(medExamObj.getAllergies()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=KNOWN_ALLERGY %>"  size="20" maxlength="20" value="<%=medExamObj.getAllergies() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=KNOWN_ALLERGY %>" size="20" maxlength="20" />
 <% }%>
 <div class="clear"></div>

<div class="clear"></div>
</div>
</div>
<div class="clear paddingTop15"></div>
<h4>NEXT APPOINTMENT</h4>
<div class="clear"></div>
<div class="Block">
<label>Date</label>
 <input tabindex="1" type="text"	name="<%=APPOINTMENT_DATE %>" class="calDate" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date %>"
	validate="APPOINTMENT_DATE ,date,no" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',medicalBoardExaminationAnnual.<%=APPOINTMENT_DATE%>,event);" />


  </div>

<div class="division"></div>
<div class="clear"></div>
<%if(medExamObj.getId()!=null)
{%>
<input tabindex="1" name="Button"	type="button" class="button" value="Update"	onClick="submitForm('medicalBoardExaminationAnnual','medicalExam?method=updateMedicalExamEntry');" />
<% }else{%>
<input type="button" onclick="submitdata()" value="Submit" class="button" name="Button" tabindex="1">
<% }%>
<input tabindex="1" class=button id=reset accessKey=r	onclick=resetCheck(); type=reset value=Reset name=Reset>
<input tabindex="1" name="Button"	type="button" class="button" value="Forward"	onClick="submitForm('medicalBoardExaminationAnnual','medicalExam?method=updateMedicalExamEntry&data=farwarded');" />
<!--  <input tabindex="1" class=button id=reset accessKey=r	onclick=resetCheck(); type=reset value=Appointment name=Reset>-->
<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
<div class="clear"></div>
<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<INPUT	type=hidden value="<%=userName%>" name="<%=LAST_CHANGED_BY%>">
<INPUT type=hidden value="<%=date%>" name="<%=LAST_CHANGED_DATE%>">
<INPUT type=hidden value="<%=time%>" name="<%=LAST_CHANGED_TIME%>">

</div>
<%if(visit.getDoctor() != null){ %>
<input name="empId" type="hidden" value="<%=visit.getDoctor().getId()%>" />
<%}%>
<%if(visit.getDepartment() != null){
	System.out.println("visit.getDepartment().getId()----"+visit.getDepartment().getId());%>
<input name="deptId" type="hidden" value="<%=visit.getDepartment().getId()%>" />
<%}%>
<%if(visit.getHin() != null){
	System.out.println("visit.getHin().getId()----"+visit.getHin().getId());%>
<input name="hinId" type="hidden" value="<%=visit.getHin().getId()%>" />
<%}%>
<%if(visit.getHin() != null){
	System.out.println("visit.getHin().getId()----"+visit.getHin().getId());%>
<input name="visitId" type="hidden" value="<%=visit.getId()%>" />
<%}%>

<!--Bottom labels starts--> <!--main content placeholder ends here--> <script
	type="text/javascript">
	function generateRowMdicalBoard1(idName) {
		 var d=document.getElementById(idName).getElementsByTagName("tr");
		
		lastTr = d[d.length-1]
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);
		lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
		var tblCtrl = d[d.length-1].getElementsByTagName("input"); 
		tblCtrl[0].value=d.length-2;
		document.getElementById('hiddenValue').value =d.length-2
		for(var i=4;i<tblCtrl.length;i++)
			tblCtrl[i].value="";
					
			
		}
    function removeRowMedicalBoard1()
	{
	  var tbl = document.getElementById('amcDetailId');
	 if(document.getElementById('hiddenValue').value >1){
	
	  document.getElementById('hiddenValue').value=document.getElementById('hiddenValue').value-1;
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	  }
	}
	</script> <script type="text/javascript">
function limitText(limitField, limitNum) {
    if (limitField.value.length > limitNum) {
         
        limitField.value = limitField.value.substring(0, limitNum);
      
    } 
}

function chkValue(field)
{
	if(!field.checked)
	{
	
	field.value="N";
	}
	else{
	
	field.value="Y";
	
	}
	
}
function isAlpha(argvalue) {
argvalue = argvalue.toString();
var validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

for (var n = 0; n < argvalue.length; n++) {
if (validChars.indexOf(argvalue.substring(n, n+1)) == -1)
return false;
}
return true;
}




</script> <script language="JavaScript" type="text/JavaScript"> 
function isNumber(field) { 
        var re = /^[0-9-'.'-',']*$/; 
        if (!re.test(field.value)) { 
            alert('please enter only numeric data'); 
            field.value = field.value.replace(/[^0-9-'.'-',']/g,""); 
        } 
    
    } 
  
    
</script> <script language="JavaScript" type="text/javascript">
  
  function isNumber1(field) { 
       var i=3;
        var re = /^[0-9-'.'-',']*$/; 
        if (!re.test(field.value)) { 
            alert('please enter only numeric data'); 
            field.value = field.value.replace(/[^0-9-'.'-',']/g,""); 
       
        } 
     var aa=field.value[1];
    if(field.value.indexOf(".")<4)
    {
 return true;
 }
 else
 {
     alert('please enter less than three digit before decimal point'+aa); 
		 field.value=''; 
 
	}




}

function checkForWiegth(val,id){
var index=val.indexOf(".");
if(index!=-1){
	var arr= val.split(".");
	if(arr[1].length>3){
	alert("pls check the decimal fractions");
	document.getElementById(id).value="";
	document.getElementById(id).focus();
	return false;
	}
	
	}
	else{
	
	if(val.length>3){
	alert("pls give the decimal point after three digit");
	document.getElementById(id).value="";
	document.getElementById(id).focus();
	return false;
	}
 
 }
 
 }
  function chkLength(field,maxLimit)
   {
   if(field.value.length > maxLimit)
   {
    alert('Maximum Limit is '+maxLimit+' characters.');
    var val=field.value.substring(0,maxLimit);
    field.value=val;
   }
}
  function showHideInvestigationTemplateCombo(valueOfTemplate){
		
		if(checkTemplateId(valueOfTemplate)){
			
		  	document.getElementById("copyPrevInvestigationTemplateDiv").style.display='none';
		  	
				submitProtoAjaxWithDivName('medicalBoardExaminationAnnual','/hms/hms/opd?method=showGridForInvestigation','gridview');
				
				}
	
	}
 function addRowForInvestigation(){
      
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;

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

	  						if(validateInvestigationAutoComplete(this.value,iteration)){checkForChargeCode(this.value,iteration,'chargeCodeVal'+iteration);}

	  					  };
	   var newdiv1 = document.createElement('div');
	  newdiv1.setAttribute('id', 'ac2update'+iteration);
	  newdiv1.setAttribute('class', 'autocomplete');
	  newdiv1.style.display = 'none';
	  					
	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  e0.setAttribute('tabindex','1');
	  //alert("name--"+e0.name)
	  e0.size = '100'
	  cellRight0.appendChild(newdiv1);
	  
	  cellRight0.appendChild(e0);
	
	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update'+iteration,'opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName'+iteration});	  var sel = document.createElement('input');
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

	 var cellRight1 = row.insertCell(1);
	  var e3 = document.createElement('input');
	  e3.type = 'button';
	  e3.className = 'buttonAdd';
	  e3.name='Button';
	  e3.setAttribute('onClick','addRowForInvestigation();');
	  cellRight1.appendChild(e3);

	  var cellRight2 = row.insertCell(2);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonDel';
	  e4.name='delete';
	  e4.setAttribute('onClick','removeRowForInvestigation();');
	  cellRight2.appendChild(e4);
	  
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
 function removeRowForInvestigation()
	{
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('investigationGrid');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hiddenValue');
	  	hdb.value=iteration

	  }
	}
 function openPopupForPatientInvestigation(visitNo,hinId){
	  //alert("in pop up window visit No---"+visitNo+"---- hin id ---"+hinId)


	if(visitNo >1){
	var url="/hms/hms/opd?method=showPatientPreviousInvestigation&visitNo="+visitNo+"&hinId="+hinId;
   newwindow=window.open(url,'name','left=2,top=0,height=500,width=1010,status=1,scrollbars=1,resizable=1');
   }else{
     alert("This is Patient's First Visit. ")
   }
}
 function showCreateInvestigationTemplate(){
     
     document.getElementById("investigationImportButton1").style.display='inline'
   	var url="/hms/hms/opd?method=showCreateInvestigationTemplate";
    newwindow=window.open(url,'investigation',"height=500,width=1010,status=1,top=0,left=2");
   

}
 function copyPrevInvestigationTempate(visitNo,hinId){
		document.getElementById('templateDivInvestigationToShowHide').style.display = 'none';
		document.getElementById('prevButtonDivInvestigationToShowHide').style.display = 'none';
		document.getElementById('createInvestigationDivToShowHide').style.display = 'none';

		var hdb = document.getElementById('hdb').value;
	    submitProtoAjaxWithDivName('medicalBoardExaminationAnnual','/hms/hms/opd?method=getPatientPreviousInvestigationForCopy&&visitNo='+visitNo+'&hinId='+hinId,'gridview');
}
 function getListForTreatment(val){
	 	if(val=='investigationDiv'){
			submitProtoAjaxWithDivName('medicalBoardExaminationAnnual','/hms/hms/opd?method=getListForTreatment&flag=investigation',val);
		}else if(val=='treatmentDiv'){
			submitProtoAjaxWithDivName('medicalBoardExaminationAnnual','/hms/hms/opd?method=getListForTreatment&flag=treatment',val);
		}
//		document.getElementById('prescriptionImportButton').style.display = 'none';
//		document.getElementById("investigationImportButton").style.display='none'
	 }
 function validateInvestigationAutoComplete( strValue,inc ) {

		var index1 = strValue.lastIndexOf("[");
	    var index2 = strValue.lastIndexOf("]");
	    index1++;
	    var id = strValue.substring(index1,index2);
	    //alert("id----"+id)

	    if(id =="")
	    {
	    		document.getElementById('chargeCodeName'+inc).value="";
				document.getElementById('chargeCode'+inc).value="";
				return ;
		}
		document.getElementById('qty'+inc).value="1";
		return true;
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
						document.getElementById('chargeCodeName'+inc).value=""
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
			//submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=fillChargeCodeForInvestigation&chargeCodeNAmeForAjax='+ tempChargeCodeString+'&rowVal=1',chargeCodeTdDiv);

			}else{
				document.getElementById('chargeCodeName'+inc).value = "";
				document.getElementById('qty'+inc).value = "";
				document.getElementById('chargeCode'+inc).value = "";
				//document.getElementById('qty'+inc).value = "";
				//document.getElementById('qty'+inc).value = "";
			}
		}
 function submitdata()
	{
		
		var charge=document.getElementById("chargeCodeName1").value;
     if(charge=="")
     {
      alert("Please Select Test Name");   
     }else{
     	submitForm('medicalBoardExaminationAnnual','medicalExam?method=addMedicalExaminationBoardAnnual');
     }
		
		//{submitForm('medicalBoardExaminationAnnual','medicalBoard?method=addMedicalBoardInit')}
	}
</script></form>
