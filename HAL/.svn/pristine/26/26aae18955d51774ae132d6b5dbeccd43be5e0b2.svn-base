
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MbTypeOfEntryMaster"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.net.URL"%>

<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgMasCollection"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%><script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>

<!-- -<script type="text/javascript"	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
 -->
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
animatedcollapse.addDiv('slide14', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide15', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide16', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()


</script>
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
	
}

</script>

<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<MbTypeOfEntryMaster> typeOfEntryMasterList = new ArrayList<MbTypeOfEntryMaster>();
List<MasUnit> masUnitList = new ArrayList<MasUnit>();

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


List templateList= new ArrayList();
if(map.get("templateList") != null){
templateList=(List)map.get("templateList");
}
if(map.get("masRankList")!=null)
{
	masRankList1 = (List) map.get("masRankList");

}
List patientDataList = new ArrayList();
List<MasMaritalStatus> maritalStatusList = null;
if(map.get("patientDataList") != null){
	patientDataList=(List)map.get("patientDataList");

	}
Visit visit=null;
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();	
if(patientDataList!=null&& patientDataList.size()>0)
{
 visit=(Visit)patientDataList.get(0);
}
List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
List<MasServiceType> serviceTypeList =null;
try{
	
if(map.get("resultList") != null){
	resultList=(List)map.get("resultList");

	}
if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
}


if(map.get("serviceTypeList") != null){
	serviceTypeList= (List<MasServiceType>)map.get("serviceTypeList");
}
}catch(Exception e){
	e.printStackTrace();
}
String deptType="";
if(session.getAttribute("deptType") != null){
	deptType = (String)session.getAttribute("deptType");
}
List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
if(map.get("investigationList") != null){
	investigationList = (ArrayList)map.get("investigationList");
}
if(map.get("maritalStatusList") != null){
	maritalStatusList = (List<MasMaritalStatus>)map.get("maritalStatusList");
}
String url="";
if(map.get("url") != null){
	url = (String)map.get("url");
}
List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
if(map.get("medExamList") != null){
	medExamList = (List<MasMedicalExaminationReportOnEntry>)map.get("medExamList");
}
MasMedicalExaminationReportOnEntry medExamObj = new MasMedicalExaminationReportOnEntry();

if(medExamList.size() > 0){
	medExamObj = medExamList.get(0);
	visit=medExamObj.getVisit();
}
int visitId=0;
if(map.get("visitId") != null){
	visitId = (Integer)map.get("visitId");
}
String search=null;
if (map.get("search") != null) {
	search = (String) map.get("search");
      System.out.println("jsp search"+search);
   }
Properties properties = new Properties();
URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
try {
	properties.load(resourcePath.openStream());
} catch (Exception e) {
 	e.printStackTrace();
}
 String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
 Set<PatientInvestigationDetails> patientInvestigationdetails=null;
 PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
 if(map.get("patientInvestigationHeader")!=null){
 	
 	patientInvestigationHeader=(PatientInvestigationHeader)map.get("patientInvestigationHeader");
 	System.out.println(" patientInvestigationHeader is not null");
 	patientInvestigationdetails=patientInvestigationHeader.getPatientInvestigationDetails();
 }
 DgOrderhd dgOrderhd=null;
 Set<DgOrderdt> getDgOrderdts=null;
 if(map.get("dgOrderhd")!=null){
 	
 	dgOrderhd=(DgOrderhd)map.get("dgOrderhd");
 	System.out.println(" dgOrderhd is not null");
 	getDgOrderdts=dgOrderhd.getDgOrderdts();
 	
 }

%>
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
<h2>AFMSF-18</h2>
</div>
<div class="clear"></div>
<body onLoad="coolDental()">
<form name="medicalBoardExaminationAnnual" action="" method="post" >
<input type="hidden" name="medExamId" value="<%=medExamObj.getId() %>"/>
<div class="Block">
<label>Authority Of Board</label>
 <% if(medExamObj.getAuthority()!=null){%>
<input tabindex="1" type="text" readonly="readonly"   id="" name="<%=AUTHORITY_OF_BOARD %>"maxlength="6" value="<%=medExamObj.getAuthority() %>"
	onKeyUp="limitText(this,6);"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  id="" name="<%=AUTHORITY_OF_BOARD %>" maxlength="6" 
	onKeyUp="limitText(this,6);"  />

 <% }%>
 
 <label>Place  </label> 
 <% if(medExamObj.getPlace()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" class="auto" size="50" id="" name="<%=PLACE %>"maxlength="6" value="<%=medExamObj.getPlace() %>"
	onKeyUp="limitText(this,6);"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=PLACE %>" maxlength="6" 
	onKeyUp="limitText(this,6);"  />

 <% }%>
 
  <label><span>*</span> Date </label>
  <% if(medExamObj.getDateDischarge()!=null){%>
<input	tabindex="1" name="<%=DATE_DISCHARGE %>" readonly="readonly" class="date" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateDischarge())%>"
	validate="DOB,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 

 <% }else{%>
<input	tabindex="1" name="<%=DATE_DISCHARGE %>" class="date" 
	validate="DOB,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 

 <% }%>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	 />
<div class="clear"></div>
  <label><span>*</span> Date of Release  </label>
  <% if(medExamObj.getDateRelease()!=null){%>
  <input	tabindex="1" name="<%=DATE_OF_RELEASE %>" readonly="readonly" class="date" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateRelease())%>"
	validate="DOB,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 

 <% }else{%>
  <input	tabindex="1" name="<%=DATE_OF_RELEASE %>" class="date" readonly="readonly" 
	validate="DOB,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
 <% }%>
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	 />
<label>Name  </label> 
<% if(medExamObj.getNameInFull()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=FULL_NAME %>"maxlength="100" value="<%=medExamObj.getNameInFull() %>"
	onKeyUp="limitText(this,100);"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=FULL_NAME %>" maxlength="100" 
	onKeyUp="limitText(this,100);"  />

 <% }%>
 
<% if(medExamObj.getMedicalExamType()!=null){%>
 <input type="hidden"	value="<%=medExamObj.getMedicalExamType() %>" name="medicalExamType" tabindex="2" />
<% }else{%>
 <input type="hidden"	value="Med. Exam On Release/Discharge(AFMSF-18)" name="medicalExamType" tabindex="2" />
<% }%>

 <label>Service Number </label>
<% if(medExamObj.getServiceNo()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=SERVICE_NO %>"maxlength="6" value="<%=medExamObj.getServiceNo() %>"
	onKeyUp="limitText(this,6);"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=SERVICE_NO %>" maxlength="6" 
	onKeyUp="limitText(this,6);"  />

 <% }%>
 <div class="clear"></div>
 <label>Rank  </label>
  <% if(medExamObj.getRank()!=null){%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=RANK %>" tabindex="2" value="<%=medExamObj.getRank().getRankName() %>"/>
 <input type="hidden" value="<%=medExamObj.getRank().getId() %>" name="<%=RANK_ID%>"	tabindex="2" />
 <% }else{%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=RANK %>" tabindex="2" />
 <% }%>
 
  <label><span>*</span> Date of Birth  </label>
  <% if(medExamObj.getDateOfBirth()!=null){%>
 <input	tabindex="1" name="<%=DATE_OF_BIRTH %>" readonly="readonly" option value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateOfBirth())%>"	validate="Entry Date,date,no" maxlength="10" class="date"	onKeyUp="mask(this.value,this,'2,5','/');" />

 <% }else{%>
<input	tabindex="1" name="<%=DATE_OF_BIRTH %>" readonly="readonly" option value=""	validate="Entry Date,date,no" maxlength="10" class="date"	onKeyUp="mask(this.value,this,'2,5','/');" />

 <% }%>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	 />

 <label>Unit/Ship  </label> 
 <% if(medExamObj.getUnit()!=null){%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=UNIT %>" tabindex="2" value="<%=medExamObj.getUnit().getUnitName() %>"/>
 <input type="hidden" value="<%=medExamObj.getUnit().getId() %>" name="<%=UNIT_ID%>"	tabindex="2" />
 <% }else{%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=UNIT %>" tabindex="2" />
 <% }%>
 
 <div class="clear"></div>
 <label>Service IAF  </label> 
 <% if(medExamObj.getServiceiaf()!=null){%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="serviceiaf" tabindex="2" value="<%=medExamObj.getServiceiaf() %>"/>
 
 <% }else{%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="serviceiaf" tabindex="2" />
 <% }%>
 
<label>Branch/Trade  </label> 
  <% 
  if(medExamObj.getTrade()!=null){%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=TRADE%>" tabindex="2" value="<%=medExamObj.getTrade().getTradeName() %>"/>
  <input	type="hidden"  name="<%=TRADE_ID%>"	tabindex="2" value="<%=medExamObj.getTrade().getId() %>"/>
 <% }else{%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=TRADE_ID%>" tabindex="2" />
 <% }%>

  <label>Total Service  </label> 
 <% if(medExamObj.getTotalService()!=null){%>
 
 <input	type="text" readonly="readonly" maxlength="20"  value="<%=medExamObj.getTotalService() %>" name="<%=TOTAL_SERVICE%>"	tabindex="2" />

 <% }else{%>
<input	type="text" readonly="readonly" maxlength="20"  value="" name="<%=TOTAL_SERVICE%>"	tabindex="2" />

 <% }%>
 <div class="clear"></div> 

<label> Marital Status</label> 
<select name="<%=MARITAL_STATUS_ID%>" id="srmrstatus" validate="Marital Status of service Person,string,no"  tabindex="1" disabled="disabled">
      <option value="0">Select</option>
      <%
	 for(MasMaritalStatus masMaritalStatus : maritalStatusList){
		 	if ((medExamObj.getMaritalStatus()!=null)&&(masMaritalStatus.getId()==(medExamObj.getMaritalStatus().getId()))) {%>
		 <option value="<%=masMaritalStatus.getId ()%>" selected="selected"><%=masMaritalStatus.getMaritalStatusName()%>
		 </option>
		 <%}else{%><option value="<%=masMaritalStatus.getId ()%>"><%=masMaritalStatus.getMaritalStatusName()%>
		 	</option>
		 	<%	}}%>
    </select> 
<label >Permanent Address</label> 
 <%
 if(medExamObj.getParmanentAddress()!=null){
 %>
 <textarea readonly="readonly"  rows="" cols=""  class="medium" 	name="<%=PERMANENT_ADDRESS %>" class="large" onkeyup="chkLength(this,50);" ><%=medExamObj.getParmanentAddress() %></textarea>
 <% }else{%>
<textarea readonly="readonly" rows="" cols=""  class="medium" 	name="<%=PERMANENT_ADDRESS %>" class="large" onkeyup="chkLength(this,50);" ></textarea>

 <% }%>
 

 <label >Past Medical History</label> 
 <% if(medExamObj.getPastmedicalhistory()!=null){%>
 <input	type="text" readonly="readonly"  name="<%=PAST_MEDICAL_HISTORY%>"	tabindex="2"  value="<%=medExamObj.getPastmedicalhistory() %>" maxlength="20"/>
  <% }else{%>
<input	type="text" readonly="readonly"  name="<%=PAST_MEDICAL_HISTORY%>"	tabindex="2" maxlength="20" />
 <% }%>
 
 <div class="clear"></div>
 <label >Identification Marks</label> 
 <% if(medExamObj.getIdentificationMarks1()!=null){%>
<label class="valueAuto">1.)</label><input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=IDENTIFICATION_MARKS1 %>"maxlength="6" value="<%=medExamObj.getIdentificationMarks1() %>"
	onKeyUp="limitText(this,20);" class="auto" size="72"  />

 <% }else{%>
<label class="valueAuto">1.)</label><input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=IDENTIFICATION_MARKS1 %>" maxlength="6" 
	onKeyUp="limitText(this,20);" class="auto" size="72"  />

 <% }%>
<div class="clear"></div>
<label>&nbsp;</label>
<% if(medExamObj.getIdentificationMarks2()!=null){%>



<label class="valueAuto">2.)</label><input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=IDENTIFICATION_MARKS2 %>" value="<%=medExamObj.getIdentificationMarks2() %>"
	onKeyUp="limitText(this,20);" class="auto" size="72" />

 <% }else{%>
<label class="valueAuto">2.)</label><input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=IDENTIFICATION_MARKS2 %>"  
	onKeyUp="limitText(this,20);" class="auto" size="72"  />

 <% }%>
</div>
<div class="clear paddingTop15"></div>
<h4> PERSONAL STATEMENT SERVICE DETAILS <a href="javascript:animatedcollapse.toggle('slide1')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide1">
<div class="Block">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
<TH scope="col">S.No.</TH>
<TH scope="col">From</TH>
<TH scope="col">To</TH>
<TH scope="col">Place</TH>
<TH>P/F</TH>
<th>Add</th>
<th>Delete</th>
</tr>
<% int inc1=0;

if(medExamObj.getMasmedicaldetail()!=null)
{
	for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){

		if(setMedicalExam.getParticular()!=null && setMedicalExam.getParticular().equalsIgnoreCase("detail"))
	{
	
		inc1=inc1+1;
	%>

<TR>

<% if(setMedicalExam.getSerialno()!=null){
%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly" 	name="<%=SIRIAL_NO+inc1 %>" maxlength="10" value="<%=setMedicalExam.getSerialno() %>"/></td>
<% }else{
%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly" 	name="<%=SIRIAL_NO+inc1 %>" maxlength="10" /></td>

<% }%>
<% if(setMedicalExam.getAddressfrom()!=null && ! setMedicalExam.getAddressfrom().equalsIgnoreCase("null")){
%>
<td width="10%"><input tabindex="1" type="text" readonly="readonly" 	name="<%=FROM+inc1 %>" maxlength="10" value="<%=setMedicalExam.getAddressfrom() %>"/></td>
<% }else{
%>
<td width="10%"><input tabindex="1" type="text" readonly="readonly" 	name="<%=FROM+inc1 %>" maxlength="10" /></td>
<% }%>
<% if(setMedicalExam.getAddressto()!=null && ! setMedicalExam.getAddressto().equalsIgnoreCase("null")){%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly"  name="<%=TO+inc1 %>" maxlength="10" value="<%=setMedicalExam.getAddressto() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text" readonly="readonly" 	name="<%=TO+inc1 %>" maxlength="10" /></td>
<% }%>
<% if(setMedicalExam.getPlace()!=null && ! setMedicalExam.getPlace().equalsIgnoreCase("null")){%>
<td width="10%"><input tabindex="1" readonly="readonly" type="text"	name="<%=PLACE+inc1 %>" maxlength="10" value="<%=setMedicalExam.getPlace() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly"  name="<%=PLACE+inc1 %>" maxlength="10" /></td>
<% }%>
<% if(setMedicalExam.getPno()!=null && ! setMedicalExam.getPno().equalsIgnoreCase("null")){%>
<td width="10%"><input tabindex="1" type="text" readonly="readonly" 	name="<%=P_NO+inc1 %>" maxlength="10" value="<%=setMedicalExam.getPno() %>"/></td>
<% }else{%>
<td width="10%"><input tabindex="1" readonly="readonly"  type="text"	name="<%=P_NO+inc1 %>" maxlength="10" /></td>
<% }%>

<td>
<input name="Button" type="button" class="buttonAdd" value=""  tabindex="1" /> 
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel"  tabindex="1" />
</td>

</TR>
<input type=hidden name="<%=SERVICEID+inc1 %>" value="<%=setMedicalExam.getServiceid()%>" id="hdb" />

<%
	}
}}else{
inc1=1;%>
<TR>


<td width="10%"><input tabindex="1"  type="text" readonly="readonly" 	name="<%=SIRIAL_NO+inc1 %>" value=<%=inc1%> maxlength="10" /></td>
<td width="10%"><input tabindex="1" type="text"	readonly="readonly" name="<%=FROM+inc1 %>" maxlength="10" /></td>
<td width="10%"><input tabindex="1" type="text" readonly="readonly" 	name="<%=TO+inc1 %>" maxlength="10" /></td>
<td width="10%"><input tabindex="1" type="text" readonly="readonly" 	name="<%=PLACE+inc1 %>" maxlength="10" /></td>
<td width="10%"><input tabindex="1" type="text" readonly="readonly" 	name="<%=P_NO+inc1 %>" maxlength="10" /></td>
<td>
<input name="Button" type="button" class="buttonAdd" value=""  tabindex="1" /> 
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel"  tabindex="1" />
</td>

</TR>
<% }%>
<input type=hidden name="hdb" value="<%=inc1%>" id="hdb" />
</table>
</div>
</div>
<div class="clear"></div>

	
<!--Block Four Ends-->
<div class="clear paddingTop15"></div>
<h4> PREVIOUS SERVICE DETAILS <a href="javascript:animatedcollapse.toggle('slide2')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide2">
<div class="Block">
<label><span>*</span> Previous Service </label>

<!--<select id="serviceTypeId" name="<%=SERVICE_TYPE_ID %>" validate="Service Type,string,yes"  tabindex="1" onchange="populateRank('registration');populateRecordOfficeAddress(this.value,'registration');getServicePersonName('registration','registration?method=getServicePersonName');checkServiceType(this.value);getHin();">
		-->
	<select id="serviceTypeId" disabled="disabled" name="<%=SERVICE_TYPE_ID %>" validate="Service Type,string,no"  tabindex="1" onchange="populateRank('registration');getServicePersonName('registration','registration?method=getServicePersonName');checkServiceType(this.value);getHin();">
		<option value="0">Select</option>
		
		<% 
			for(MasServiceType masServiceType : serviceTypeList){
				if(masServiceType.getId() ==2){
					
if ((medExamObj.getServiceType()!=null)&&(masServiceType.getId()==(medExamObj.getServiceType().getId()))) {%>

		%>
		<option value="<%=masServiceType.getId() %>" selected="selected"><%=masServiceType.getServiceTypeName() %></option>
		<%}else{ %>
		<option value="<%=masServiceType.getId() %>"><%=masServiceType.getServiceTypeName() %></option>
		<%}}
				}%>
</select>
<label class="auto">Disability Pension</label> 
<select name="<%=DISABILITY %>" size="0" tabindex="1" id="disabilityPension" disabled="disabled">
	<option value="0">select</option>
	<option value="Yes">Yes</option>
	<option value="No">No</option>
</select>
<script>
<%
if(medExamObj.getDisabilitybefore()!= null){
%>
document.getElementById('disabilityPension').value='<%=medExamObj.getDisabilitybefore()%>';

<%}%>
</script>
</div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<h4> PERSONAL STATEMENT SERVICE DETAILS <a href="javascript:animatedcollapse.toggle('slide3')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide3">
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid1">
	<tr>
<TH scope="col">S.No.</TH>
<TH scope="col">Illness/wound</TH>
<TH scope="col" colspan="2">Date</TH>
<TH scope="col">Place/Ship</TH>
<TH>Rank Of Individual</TH>
<TH>Where Treated</TH>
<TH colspan="2">Aapproximate Date and Periods Treated</TH>
<th>Add</th>
<th>Delete</th>
</tr>
<% int inc11=0;
if(medExamObj.getMasmedicaldetail()!=null)
{
for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
	
	if(setMedicalExam.getParticular()!=null && setMedicalExam.getParticular().equalsIgnoreCase("particular")){
		inc11=inc11+1;
	%>

<TR>

 <% if(setMedicalExam.getSerialNo1()!=null){%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly" 	name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" value="<%=setMedicalExam.getSerialNo1() %>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" size="2" type="text"	readonly="readonly"  name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" /></td>
 <% }%>
 <% if(setMedicalExam.getIllness()!=null){%>
<td width="10%"><input tabindex="1" type="text" readonly="readonly" 	name="<%=ILLNESS+inc11 %>" maxlength="10" value="<%=setMedicalExam.getIllness() %>"/></td>
  <% }else{%>
  
<td width="10%"><input tabindex="1" type="text"	readonly="readonly"  name="<%=ILLNESS+inc11 %>" maxlength="10" /></td>
 <% }%>
<td width="10%">
 <% if(setMedicalExam.getParticulardate()!=null){%>
<input	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>" class="date" value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getParticulardate())%>"
	validate="DOB,date,no" maxlength="10" id="particulardate" readonly="readonly"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
  <% }else{%>
<input	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>" class="date" 	validate="DOB,date,no" maxlength="10" id="particulardate"
	onKeyUp="mask(this.value,this,'2,5','/');"  readonly="readonly"/> 
 <% }%>
 </td>
 <td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	 />

</td>
 
 <% if(setMedicalExam.getPlace1()!=null){%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1+inc11 %>" maxlength="10" value="<%=setMedicalExam.getPlace1()%>"/></td>
  <% }else{%>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1+inc11 %>" maxlength="10" /></td>
 <% }%>

<td width="10%">
<select disabled="disabled" name="<%=RANK_INDIVIDUAL_ID+inc11%>" id="srmrstatus" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <% int j=0;
      System.out.println("masRankList1---"+masRankList1.size());
	 for(MasRank masrank : masRankList1){
		 	if ((setMedicalExam.getRankIndividual()!=null)&&(masrank.getId()==(setMedicalExam.getRankIndividual().getId()))) {%>
		 <option value="<%=masrank.getId ()%>" selected="selected"><%=masrank.getRankName()%>
		 </option>
		 <%}else{%><option value="<%=masrank.getId ()%>"><%=masrank.getRankName()%>
		 	</option>
		 	<script>
		 	bankArray[<%=j%>]= new Array();
            bankArray[<%=j%>][0] = "<%=masrank.getId()%>";
            bankArray[<%=j%>][1] = "<%=masrank.getRankName()%>";
            </script>		 	
		 	<%	}
		 	j=j+1;
		 	}%>
    </select> 
 <% if(setMedicalExam.getTreated()!=null){%>
    <td width="10%"><input tabindex="1" type="text"	name="<%=TREATED+inc11 %>" maxlength="10" value="<%=setMedicalExam.getTreated() %>"/></td>
  <% }else{%>
    <td width="10%"><input tabindex="1" type="text"	name="<%=TREATED+inc11 %>" maxlength="10" /></td>
 <% }%>
    
<td width="10%">
 <% if(setMedicalExam.getApproximatedate()!=null){%>
<input	tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" id="approximatedate" class="date" value="<%=HMSUtil.convertDateToStringWithoutTime(setMedicalExam.getApproximatedate())%>"
	validate="DOB,date,no" maxlength="10" readonly="readonly"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
  <% }else{%>
<input	tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" id="approximatedate" class="date" 	validate="DOB,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');"  readonly="readonly"/> 
 <% }%>
  </td>
 <td>
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" 
	 />
</td>
<td>
<input name="Button" type="button" class="buttonAdd" value=""  tabindex="1" /> 
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel"  tabindex="1" />
</td>

</TR>
<input type=hidden name="<%=SERVICEID+inc11 %>" value="<%=setMedicalExam.getServiceid()%>"  />

<%
}}}else{
inc11=1;%>
<td width="10%"><input tabindex="1" size="2" type="text" readonly="readonly"	name="<%=SIRIAL_NO1+inc11 %>" maxlength="3" /></td>
<td width="10%"><input tabindex="1" type="text"	name="<%=ILLNESS+inc11 %>"  readonly="readonly" maxlength="10" /></td>
<td width="10%">
<input	tabindex="1" name="<%=PARTICULAR_DATE+inc11 %>" class="date" readonly="readonly" 	validate="DOB,date,no" maxlength="10" id="particulardate"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 

</td>
<td>
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	 />

</td>
<td width="10%"><input tabindex="1" type="text"	name="<%=PLACE1+inc11 %>" maxlength="10" /></td>
<td width="10%">
<select name="<%=RANK_INDIVIDUAL_ID+inc11%>" disabled="disabled" id="srmrstatus" validate="Marital Status of service Person,string,no"  tabindex="1">
      <option value="0">Select</option>
      <% int j=0;
      System.out.println("masRankList1---"+masRankList1.size());
	 for(MasRank masrank : masRankList1){
		 %><option value="<%=masrank.getId ()%>"><%=masrank.getRankName()%>
		 	</option>
		 	<script>
		 	bankArray[<%=j%>]= new Array();
            bankArray[<%=j%>][0] = "<%=masrank.getId()%>";
            bankArray[<%=j%>][1] = "<%=masrank.getRankName()%>";
            </script>		 	
		 	<%	
		 	j=j+1;
		 	}%>
    </select> 
</td>
<td width="10%"><input tabindex="1" type="text"	name="<%=TREATED+inc11 %>" maxlength="10" /></td>
<td width="10%">
<input	tabindex="1" name="<%=APPROXIMATE_DATE+inc11 %>" readonly="readonly" id="approximatedate" class="date" 	validate="DOB,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 

</td>

<td>
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" 
	 />
</td>
<td>
<input name="Button" type="button" class="buttonAdd" value=""  tabindex="1" /> 
</td>
<td>
<input type="button" name="delete" value="" class="buttonDel"  tabindex="1" />
</td>

</TR>

<% }%>
<input type=hidden name="hdb1" value="<%=inc11%>" id="hdb1" />
</table>
</div>
	</div>
<!--Block Four Ends-->
<div class="clear paddingTop15"></div>
<h4> DISEASE<a href="javascript:animatedcollapse.toggle('slide4')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide4">
<div class="Block">
  <label>Date <span>*</span> </label>
<% if(medExamObj.getDateDisease()!=null){%>
<input	tabindex="1" name="<%=DATE_DISEASE %>" class="date" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateDisease())%>"
	validate="DOB,date,no" maxlength="10" readonly="readonly"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
	
 <% }else{%>
<input	tabindex="1" name="<%=DATE_DISEASE %>" class="date" 
	validate="DOB,date,no" maxlength="10" readonly="readonly"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
	 <% }%> 
  
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	 />
 
  <label >Place</label> 
<% if(medExamObj.getPlacedisease()!=null){%>
<input tabindex="1"	type="text" readonly="readonly" name="<%=PLACE_DISEASE %>"	 maxlength="20" value="<%=medExamObj.getPlacedisease() %>"/> 
 <% }else{%>
<input tabindex="1"	type="text" readonly="readonly" name="<%=PLACE_DISEASE %>"	 maxlength="20" /> 
 <% }%>	
<label >Where Treated</label>
<% if(medExamObj.getWheretreated()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=WHERE_TREATED %>"maxlength="20" value="<%=medExamObj.getWheretreated() %>"
	 />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=WHERE_TREATED %>" maxlength="20" 
	 />

 <% }%> 
 
	<div class="clear"></div>
	 <label>Approximate Date<span>*</span> </label>
<% if(medExamObj.getAppointmentDate()!=null){%>
<input	tabindex="1" name="<%=DATE_APPROXIMATE %>" class="date" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getAppointmentDate())%>"
	validate="DOB,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
	
 <% }else{%>
<input	tabindex="1" name="<%=DATE_APPROXIMATE %>" class="date" 
	validate="DOB,date,no" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" /> 
	 <% }%> 
  
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	 />
	
<label >Disability <br /><span class="sublabel">(Before Air Force)</span></label> 

<select name="<%=DISABILITY_BEFORE %>" size="0" tabindex="1" id="disabilitybefore" disabled="disabled">
	<option value="0">select</option>
	<option value="Yes">Yes</option>
	<option value="No">No</option>
</select>
<script>
<%
if(medExamObj.getDisabilitybefore()!= null){
%>
document.getElementById('disabilitybefore').value='<%=medExamObj.getDisabilitybefore()%>';

<%}%>
</script>

<label >Claiming Disability</label> 
<select name="<%=CLAMING_DISABILITY %>" size="0" tabindex="1" id="clamingdisability" disabled="disabled">
	<option value="0">select</option>
	<option value="Yes">Yes</option>
	<option value="No">No</option>
</select>
<script>
<%
if(medExamObj.getClamingdisability()!= null){
%>
document.getElementById('clamingdisability').value='<%=medExamObj.getClamingdisability()%>';

<%}%>
</script>
<div class="clear"></div>
<label >Other Health Information</label> 
 
<% if(medExamObj.getAnyOtherInformationAboutYourHealth()!=null){%>
<textarea readonly="readonly" rows="" cols="71" class="auto"   	name="<%=OTHER_INFORMATION %>" class="large" onkeyup="chkLength(this,50);" ><%=medExamObj.getAnyOtherInformationAboutYourHealth() %></textarea>
 <% }else{%>
<textarea readonly="readonly" rows="" cols="71" class="auto"  	name="<%=OTHER_INFORMATION %>" class="large" onkeyup="chkLength(this,50);" ></textarea>
 <% }%>
</div>
</div>
<div class="clear paddingTop15"></div>

<h4>Dental <a href="javascript:animatedcollapse.toggle('slide5')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide5">
<div class="Block">
<div class="clear"></div>
<% if(medExamObj.getDentalValue()!=null){%>
<input type="hidden"  name="dentalValue" id="dentalValueId" value="<%=medExamObj.getDentalValue()%>"/>
<% }else{%>
<input type="hidden"  name="dentalValue" id="dentalValueId" value=""/>
<%} %>
<label >Total no. of Teeth</label>
  <% if(medExamObj.getTotalTeeth()!=null){%>
 
 <input tabindex="1"	type="text"   name="<%=TOTAL_NO_OF_TEETH %>" readonly="readonly" class="small" value="<%=medExamObj.getTotalTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" /> 

 <% }else{%>
<input tabindex="1"	type="text"  name="<%=TOTAL_NO_OF_TEETH %>" class="small" readonly="readonly"
	onKeyUp="isNumber(this)" maxlength="2" /> 

 <% }%>
 
	
<label class="auto">Total No. of Defective Teeth</label>
 <% if(medExamObj.getTotalDefectiveTeeth()!=null){%>
<input tabindex="1"	type="text"   name="<%=DEFECTIVE_TEETH %>" class="small" readonly="readonly" value="<%=medExamObj.getTotalDefectiveTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" /> 


 <% }else{%>
<input tabindex="1"	type="text"  name="<%=DEFECTIVE_TEETH %>" class="small" readonly="readonly"
	onKeyUp="isNumber(this)" maxlength="2" /> 


 <% }%>
	<label class="auto">Total no. of Dental Points</label> 
	<% if(medExamObj.getDenstlPoint()!=null){%>
	<input	tabindex="1" type="text"  name="<%=DENTSL_POINT %>" value="<%=medExamObj.getDenstlPoint() %>" readonly="readonly"
	onKeyUp="isNumber(this);" maxlength="2" /> 


 <% }else{%>
	<input	tabindex="1" type="text"  name="<%=DENTSL_POINT %>" readonly="readonly"
	onKeyUp="isNumber(this);" maxlength="2" />


 <% }%>

	<div class="clear"></div>
	
<label >Missing </label> 
	<% if(medExamObj.getMissingTeeth()!=null){%>
<input tabindex="1" type="text" 
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);" value="<%=medExamObj.getMissingTeeth() %>" readonly="readonly"
	maxlength="2" />
 <% }else{%>
<input tabindex="1" type="text"
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);" readonly="readonly"
	maxlength="2" />
 <% }%>
<label class="auto">Unsaveable</label>
<% if(medExamObj.getUnservisableTeeth()!=null){%>
<input	tabindex="1" type="text"   name="<%=MISSING_UNSERVICABLE_TEETH %>" value="<%=medExamObj.getUnservisableTeeth() %>" readonly="readonly"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }else{%>
<input	tabindex="1" type="text"  name="<%=MISSING_UNSERVICABLE_TEETH %>" readonly="readonly"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }%> 
 <label class="auto">Condition of Gums</label>
<% if(medExamObj.getConditionOfGums()!=null){%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>" readonly="readonly" value="<%=medExamObj.getConditionOfGums() %>"
	class="small" onchange="return CheckAlpha(event);"  id="txtAlpha" maxlength="2" validate="Condition Of Gums,Alphabetic,Yes" />
	

 <% }else{%>
<input	tabindex="1" type="text"  name="<%=CONDITION_OF_GUMS %>" readonly="readonly"
	class="small" onchange="return CheckAlpha(event);" id="txtAlpha" maxlength="2" validate="Condition Of Gums,Alphabetic,Yes"/>

 <% }%> 
 <div class="clear"></div>


<h4>Missing Teeth</h4>
<div class="clear"></div>
<label >UR</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_8%>" value="" class="radioAuto" id="d1" onclick="chkValue(this);" disabled="disabled"  />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MUR_7%>" value="" class="radioAuto" id="d2" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">7</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUR_6%>" value="" class="radioAuto" id="d3" onclick="chkValue(this);" disabled="disabled" />
<label class="smallAuto">6</label> 	
<input tabindex="1" type="checkbox"
	name="<%=MUR_5%>" value="" class="radioAuto" id="d4" onclick="chkValue(this);" disabled="disabled" />
<label class="smallAuto">5</label> 	

<input tabindex="1" type="checkbox"
	name="<%=MUR_4%>" value="" class="radioAuto" id="d5"  onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">4</label> 	
	
<input tabindex="1" type="checkbox"
	name="<%=MUR_3%>" value="" class="radioAuto" id="d6"  onclick="chkValue(this);" disabled="disabled" />
<label class="smallAuto">3</label> 	
	
<input tabindex="1" type="checkbox"
	name="<%=MUR_2%>" value="" class="radioAuto" id="d7" onclick="chkValue(this);" disabled="disabled" />
<label class="smallAuto">2</label> 	

<input tabindex="1" type="checkbox"
	name="<%=MUR_1%>" value="" class="radioAuto" id="d8"  onclick="chkValue(this);" disabled="disabled" />
<label class="smallAuto">1</label> 

<div class="clear"></div>
<label>UL</label>
<input tabindex="1" type="checkbox"
	name="<%=MUL_8%>" value="" class="radioAuto" id="d9" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MUL_7%>" value="" class="radioAuto" id="d10" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=MUL_6%>" value="" class="radioAuto" id="d11" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUL_5%>" value="" class="radioAuto" id="d12" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=MUL_4%>" value="" class="radioAuto" id="d13" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=MUL_3%>" value="" class="radioAuto" id="d14" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUL_2%>" value="" class="radioAuto" id="d15" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=MUL_1%>" value="" class="radioAuto" id="d16" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">1</label> 


<div class="clear"></div>
<label >LR</label>
<input tabindex="1" type="checkbox"
	name="<%=MLR_8%>" value="" class="radioAuto" id="d17"  onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MLR_7%>" value="" class="radioAuto" id="d18"  onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLR_6%>" value="" class="radioAuto" id="d19" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLR_5%>" value="" class="radioAuto" id="d20" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLR_4%>" value="" class="radioAuto" id="d21" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLR_3%>" value="" class="radioAuto" id="d22" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLR_2%>" value="" class="radioAuto" id="d23" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLR_1%>" value="" class="radioAuto" id="d24" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">1</label> 

<div class="clear"></div>
<label class=>LL</label>
<input tabindex="1" type="checkbox"
	name="<%=MLL_8%>" value="" class="radioAuto" id="d25" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=MLL_7%>" value="" class="radioAuto" id="d26" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLL_6%>" value="" class="radioAuto" id="d27" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLL_5%>" value="" class="radioAuto" id="d28" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLL_4%>" value="" class="radioAuto" id="d29" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=MLL_3%>" value="" class="radioAuto" id="d30" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLL_2%>" value="" class="radioAuto" id="d31" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=MLL_1%>" value="" class="radioAuto" id="d32" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">1</label> <div class="clear"></div>


<h4>Unserviceable Teeth</h4>
<div class="clear"></div>
<label >UR</label>
<input tabindex="1" type="checkbox"
	name="<%=UUR_8%>" value="" class="radioAuto" id="d33" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=UUR_7%>" value="" class="radioAuto" id="d34" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUR_6%>" value="" class="radioAuto" id="d35" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUR_5%>" value="" class="radioAuto" id="d36" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUR_4%>" value="" class="radioAuto" id="d37" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUR_3%>" value="" class="radioAuto" id="d38" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUR_2%>" value="" class="radioAuto" id="d39" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUR_1%>" value="" class="radioAuto" id="d40" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">1</label>
	<div class="clear"></div>


<div class="clear"></div>
<label >UL</label>
<input tabindex="1" type="checkbox"
	name="<%=UUL_8%>" value="" class="radioAuto" id="d41" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=UUL_7%>" value="" class="radioAuto" id="d42" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUL_6%>" value="" class="radioAuto" id="d43" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUL_5%>" value="" class="radioAuto" id="d44" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUL_4%>" value="" class="radioAuto" id="d45" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=UUL_3%>" value="" class="radioAuto" id="d46" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUL_2%>" value="" class="radioAuto" id="d47" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=UUL_1%>" value="" class="radioAuto" id="d48" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">1</label> 


<div class="clear"></div>
<label >LR</label>
<input tabindex="1" type="checkbox"
	name="<%=ULR_8%>" value="" class="radioAuto" id="d49" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=ULR_7%>" value="" class="radioAuto" id="d50" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULR_6%>" value="" class="radioAuto" id="d51" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULR_5%>" value="" class="radioAuto" id="d52" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULR_4%>" value="" class="radioAuto" id="d53" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULR_3%>" value="" class="radioAuto" id="d54" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULR_2%>" value="" class="radioAuto" id="d55" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULR_1%>" value="" class="radioAuto" id="d56" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">1</label> 

<div class="clear"></div>
<label >LL</label>
<input tabindex="1" type="checkbox"
	name="<%=ULL_8%>" value="" class="radioAuto" id="d57" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">8</label> 
	
<input tabindex="1" type="checkbox"
	name="<%=ULL_7%>" value="" class="radioAuto" id="d58" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">7</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULL_6%>" value="" class="radioAuto" id="d59" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">6</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULL_5%>" value="" class="radioAuto" id="d60" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">5</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULL_4%>" value="" class="radioAuto" id="d61" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">4</label> 

<input tabindex="1" type="checkbox"
	name="<%=ULL_3%>" value="" class="radioAuto" id="d62" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">3</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULL_2%>" value="" class="radioAuto" id="d63" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">2</label> 
<input tabindex="1" type="checkbox"
	name="<%=ULL_1%>" value="" class="radioAuto" id="d64" onclick="chkValue(this);" disabled="disabled" />
	<label class="smallAuto">1</label> 
<div class="clear"></div>
<label class="medium"> Remarks</label>
 <%
if(medExamObj.getRemarksTeath()!=null){%>
 <textarea rows="" cols=""	name="<%=DENTAL_REMARKS %>" readonly="readonly" class="large" onkeyup="chkLength(this,299);" value="<%=medExamObj.getRemarksTeath() %>"><%=medExamObj.getRemarksTeath() %></textarea>
 <% }else{%>
 <textarea rows="" cols=""	name="<%=DENTAL_REMARKS %>" readonly="readonly" class="large" onkeyup="chkLength(this,299);"></textarea>
 <% }%>

	
	<div class="clear"></div>
	<div class="clear"></div>
	</div>
</div>
<div class="clear"></div>


<div class="clear paddingTop15"></div>
<% if(medExamObj.getVisit() !=null){%>
<INPUT type=hidden value="<%=medExamObj.getVisit().getHin().getHinNo()%>" name="hinNoForreport" id="hinNoForreport"/>
<% }%>
<input type="hidden" value="" name="deleatedValue" id="deleatedValue" />
<input type="hidden" value="" name="deleatedorderid" id="deleatedorderid" />
<div class="clear paddingTop15"></div>
<h4>Investigation <a href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div id="slide5">
<div class="Block">
<input type="button" name="printReport" id="print"	onclick="submitFormForPrescriptionReport();" value="print"	class="button" accesskey="a" />
<input name="Prevoius" type="button" tabindex="2" value="Prev Investigation"	class="buttonBig"	onclick="openPopupForPatientInvestigation('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')" />

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
		<th scope="col">Test Result</th>
		<th scope="col">Add</th>
        <th scope="col">Delete</th>
		</tr>

<%int inc=1;
String Labresult="NotPresent";
if(patientInvestigationHeader.getId()!=null)
{
%>
<input type="hidden" value="<%=patientInvestigationHeader.getId() %>" name="patientInvestigationHeaderId" id="patientInvestigationHeaderId" />
<% 
}else{%>
<input type="hidden"  name="patientInvestigationHeaderId" id="patientInvestigationHeaderId" />
<% }
if(dgOrderhd!=null)
{
%>
<input type="hidden" value="<%=dgOrderhd.getId() %>" name="dgOrderhdId" id="dgOrderhdId" />
<% 
}else{%>
<input type="hidden"  name="dgOrderhdId" id="dgOrderhdId" />
<% }
String template="";
int resultid=0;
if(patientInvestigationdetails!=null && patientInvestigationdetails.size()>0){
	   HashMap first = new HashMap();
	   HashMap second = new HashMap();
	   HashMap third = new HashMap();
	   int inc12=1;
		    for(PatientInvestigationDetails patientInvestigation : patientInvestigationdetails){
				String investigationName="";
		    	investigationName=patientInvestigation.getChargeCode().getChargeCodeName()+"["+patientInvestigation.getChargeCode().getId()+"]";
		    	first.put(investigationName,patientInvestigation.getChargeCode().getId());    
		    	third.put(investigationName,patientInvestigation.getId());
		    	String val="";
		    	String val1="";
		    	String val2="";
		    	int investigationId=0;
		    	
		    	if(resultList.size()>0 && inc12<=resultList.size())
		    	{
		    	DgResultEntryHeader dgEH=(DgResultEntryHeader)resultList.get(inc12-1);
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
		    	++inc12;
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
<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation();" /></td>


	</tr>
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
	

<% }%>


</table>
</div>
</div>


<div class="clear paddingTop15"></div>

<h4> PHYSICAL DEVELOPMENT <a href="javascript:animatedcollapse.toggle('slide7')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide7">
<div class="Block">
<label >Height</label> 
  <% if(medExamObj.getHeight()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="height" class="date"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)" value="<%=medExamObj.getHeight() %>"
	maxlength="6" onblur="calculateBMI();" /><label class="smallAuto">cm</label>

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="height"	class="date"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)"
	maxlength="6" onblur="calculateBMI();" /><label class="smallAuto">cm</label>

 <% }%>


<label	>Weight</label> 
  <% if(medExamObj.getActualweight()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="weight" class="date"	name="<%=ACTUAL_WEIGHT %>" maxlength="6" value="<%=medExamObj.getActualweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="smallAuto">kg</label>

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="weight" class="date"	name="<%=ACTUAL_WEIGHT %>" maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="smallAuto">kg</label>

 <% }%>


<label	>Ideal Weight</label> 
  <% if(medExamObj.getIdealweight()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=IDEAL_WEIGHT %>" class="date"	maxlength="6" value="<%=medExamObj.getIdealweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=IDEAL_WEIGHT %>" class="date"	maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }%>

<div class="clear"></div>
<label	>Over Weight</label> 
  <% if(medExamObj.getOverweight()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=OVER_WEIGHT %>" class="date"	maxlength="6" value="<%=medExamObj.getOverweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=OVER_WEIGHT %>"  class="date"	maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }%>


<label	>Waist</label> 
  <% if(medExamObj.getWaist()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=WAIST %>" maxlength="6" value="<%=medExamObj.getWaist() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=WAIST %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }%>


<label	>Chest Full Expansion</label> 
  <% if(medExamObj.getChestfullexpansion()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=CHEST_FULL %>" class="date"	 maxlength="6" value="<%=medExamObj.getChestfullexpansion() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  /><label class="smallAuto">cm</label>

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=CHEST_FULL %>" class="date"	 maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20" /><label class="smallAuto">cm</label>

 <% }%>

<div class="clear"></div>
<label>Range Of Expansion</label> 
  <% if(medExamObj.getRangeofexpansion()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=RANGE_EXPANSION %>" maxlength="6" value="<%=medExamObj.getRangeofexpansion() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=RANGE_EXPANSION %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }%>


<label	>BMI</label> 
  <% if(medExamObj.getBhi()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="bmi" name="<%=BHI %>" maxlength="6" value="<%=medExamObj.getBhi() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="bmi" name="<%=BHI %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }%>


<label	>Body Fat</label> 
  <% if(medExamObj.getBodyfat()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=BODY_FAT %>"maxlength="6" value="<%=medExamObj.getBodyfat() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=BODY_FAT %>" maxlength="6" 
	onKeyUp="limitText(this,6);"  class="auto" size="20" />

 <% }%>
<div class="clear"></div>
<label	>Skin Fold Thickness</label> 
  <% if(medExamObj.getSignfoldthickness()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=THICKNESS %>" maxlength="6" value="<%=medExamObj.getSignfoldthickness() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=THICKNESS %>" maxlength="6" 
	onKeyUp="limitText(this,6);"  class="auto" size="20" />

 <% }%>

<label	>Sports Man</label> 
  <% if(medExamObj.getSportman()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=SPORTS %>" maxlength="6" value="<%=medExamObj.getSportman() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=SPORTS %>"  maxlength="6"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }%>


</div>
</div>


<div class="Clear paddingTop15"></div>

<h4> CARDIO VASCULAR SYSTEM <a	href="javascript:animatedcollapse.toggle('slide8')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide8">
<div class="Block">
<div class="clear"></div>
<label>Pulse</label>
 <% if(medExamObj.getPulseRates()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" maxlength="20"  name="<%=PULSE_RATES%>" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getPulseRates() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="20"  name="<%=PULSE_RATES%>" class="Auto" size="22" maxlength="20" />
 <% }%>
 <label>BP</label> 
<% if(medExamObj.getBp()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" maxlength="20"  name="<%=BP1%>" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getBp() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="20"  name="<%=BP1%>" class="Auto" size="22" maxlength="20" />
 <% }%>
<label>Arterial Walls</label>
<% if(medExamObj.getArterialWalls()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%= ARTERIAL_WALLS%>" class="Auto" size="22" maxlength="20"  value="<%=medExamObj.getArterialWalls() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%= ARTERIAL_WALLS%>" class="Auto" size="22" maxlength="20" />
 <% }%>


<div class="clear"></div>
<label>Heart Size</label>
<% if(medExamObj.getHeartSize()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%= HEART_SIZE%>" class="Auto" size="22" maxlength="20" value="<%=medExamObj.getHeartSize() %>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%= HEART_SIZE%>" class="Auto" size="22" maxlength="20" />
 <% }%>


 <label>Sounds</label>
 <% if(medExamObj.getSounds()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="20"  name="<%= SOUND%>" class="Auto"	size="22" maxlength="20" value="<%=medExamObj.getSounds() %>"/> 

 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="20"  name="<%= SOUND%>" class="Auto"	size="22" maxlength="20" /> 
 <% }%>
<label>Rhythm</label>
<% if(medExamObj.getRhythm()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="20"  name="<%= RHYTHM%>" class="Auto"	size="22" maxlength="20" value="<%=medExamObj.getRhythm() %>"/> 

 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="20"  name="<%= RHYTHM%>" class="Auto"	size="22" maxlength="20" /> 
 <% }%>


<div class="clear"></div>

</div>
</div>
<div class="clear paddingTop15"></div>

<h4>RESPIRATORY SYSTEM <a href="javascript:animatedcollapse.toggle('slide9')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide9">
<div class="Block">
<div class="clear"></div>
<label class="auto"> Respiratory System</label>
<% if(medExamObj.getRespiratorySystem()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=RESPIRATORY_SYSTEM %>" class="Auto" size="120" maxlength="100" value="<%=medExamObj.getRespiratorySystem() %>"/>
   <% }else{%>
  <input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=RESPIRATORY_SYSTEM %>" class="Auto" size="120" maxlength="100" />
 <% }%>


<div class="clear"></div>
</div>
</div>

<div class="clear paddingTop15"></div>


<h4>GASTRO INTESTINAL SYSTEM <a	href="javascript:animatedcollapse.toggle('slide10')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide10">
<div class="Block">
<div class="clear"></div>
<label > Liver Palpalable</label> 
<% if(medExamObj.getLiver()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="liver" class="Auto" size="20" maxlength="100" value="<%=medExamObj.getLiver() %>"/>
   <% }else{%>
  <input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="liver" class="Auto" size="20" maxlength="100" />
 <% }%>

<label class="auto"> Spleen Palpalable</label> 
<% if(medExamObj.getSpleen()!=null){%>
  <input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="spleen" class="Auto" size="20" maxlength="100" value="<%=medExamObj.getSpleen() %>"/>
   <% }else{%>
  <input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="spleen" class="Auto" size="20" maxlength="100" />
 <% }%>


<div class="clear"></div>
</div>
</div>
<div class="clear paddingTop15"></div>

<h4>CENTRAL NERVOUS SYSTEM <a href="javascript:animatedcollapse.toggle('slide11')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide11">
<div class="Block">
<div class="clear"></div>
<label > Higher Mental Func</label> 
<% if(medExamObj.getHigherMentalFunction()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=HIGHER_MENTAL_FUNCTION %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getHigherMentalFunction() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=HIGHER_MENTAL_FUNCTION %>" class="Auto" size="20" maxlength="20" />
 <% }%>

<label > Speech</label> 
<% if(medExamObj.getSpeech()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=SPEECH %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getSpeech() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=SPEECH %>" class="Auto" size="20" maxlength="20" />
 <% }%>


<label > Reflexes</label> 
<% if(medExamObj.getReflexes()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=REFLEXES %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getReflexes() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=REFLEXES %>" class="Auto" size="20" maxlength="20" />
 <% }%>


<div class="clear"></div>
<label > Tremors</label> 
<% if(medExamObj.getTremors()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=TREMORS %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getTremors() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=TREMORS %>" class="Auto" size="20" maxlength="20" />
 <% }%>



<label > Self Balancing Test</label> 

<select name="<%=SELF_BALANCING_TEST %>" size="0" tabindex="1" id="selfbalancingtest" disabled="disabled">
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
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="locomoterSystem" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getLocomoterSystem() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="locomoterSystem" class="Auto" size="20" maxlength="10" />
 <% }%>
<label>Spine</label> 
<% if(medExamObj.getSpine()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="spine" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getSpine() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="spine" class="Auto" size="20" maxlength="10" />
 <% }%>


<label>Hernia</label> 
<% if(medExamObj.getHerniaMusic()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=HERNIA_MUSCLE %>" class="Auto" size="20" maxlength="100" value="<%=medExamObj.getHerniaMusic() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=HERNIA_MUSCLE %>" class="Auto" size="20" maxlength="100" />
 <% }%>


<div class="clear"></div>
<label>Hydrocele</label> 
<% if(medExamObj.getHydrocele()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=HYDROCELE %>" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getHydrocele() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=HYDROCELE %>" class="Auto" size="20" maxlength="10" />
 <% }%>


<label>Haemorrhoids</label> 
<% if(medExamObj.getHemorrhoids()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=HEMONHOIDS %>" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getHemorrhoids() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=HEMONHOIDS %>" class="Auto" size="20" maxlength="10" />
 <% }%>


<label>Breast</label> 
<% if(medExamObj.getBreasts()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=BREASTS %>" class="Auto" size="20" maxlength="10" value="<%=medExamObj.getBreasts() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=BREASTS %>" class="Auto" size="20" maxlength="10" />
 <% }%>



<div class="clear"></div>
</div>
</div>

<div class="clear paddingTop15"></div>

<h4>GYNAECOLOGY EXAM <a href="javascript:animatedcollapse.toggle('slide12')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide12">
<div class="Block">

<label >Menstrual History</label>
<% if(medExamObj.getMenstrualHistory()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=MENSTRUAL_HISTORY %>" class="Auto" size="20" maxlength="30" value="<%=medExamObj.getMenstrualHistory() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=MENSTRUAL_HISTORY %>" class="Auto" size="20" maxlength="30" />
 <% }%>
 

<label>LMP</label>
<% if(medExamObj.getLmp()!=null){%>
<input tabindex="1" type="text" readonly="readonly"  	name="<%=LMP %>" class="Auto" size="20" maxlength="6" value="<%=medExamObj.getLmp() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" 	name="<%=LMP %>" class="Auto" size="20" maxlength="6" />
 <% }%>

<label >No. of pregnancies</label>
<% if(medExamObj.getNoOfPregnancies()!=null){%>
<input tabindex="1" type="text" readonly="readonly"  	name="<%=NO_OF_PREGNANCY %>" class="Auto" size="20" maxlength="6" value="<%=medExamObj.getNoOfPregnancies() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  	name="<%=NO_OF_PREGNANCY %>" class="Auto" size="20" maxlength="6" />
 <% }%>
 
<div class="clear"></div>	
<label >No of Abortions</label>
<% if(medExamObj.getNoOfAbortions()!=null){%>
<input tabindex="1" type="text" readonly="readonly" 	name="<%=NO_OF_ABORTION %>" class="Auto" size="20" maxlength="6" value="<%=medExamObj.getNoOfAbortions() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  	name="<%=NO_OF_ABORTION %>" class="Auto" size="20" maxlength="6" />
 <% }%>
<label >No. of Children</label> 
<% if(medExamObj.getNoOfChildren()!=null){%>
<input tabindex="1" type="text" readonly="readonly" 	name="<%=NO_OF_CHILDREN %>" class="Auto" size="20" maxlength="6" value="<%=medExamObj.getNoOfChildren() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  	name="<%=NO_OF_CHILDREN %>" class="Auto" size="20" maxlength="6" />
 <% }%>


<label >Date <br /><span class="sublabel">(last confinement)</span></label>
<% if(medExamObj.getLastConfinementDate()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  class="calDate" readonly="readonly " value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getLastConfinementDate()) %>"	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" /> 
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  class="calDate" readonly="readonly "	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" /> 
 <% }%>


<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	 />
<div class="clear"></div>
<label >Vaginal Discharge</label>
<% if(medExamObj.getVaginalDischarge()!=null){%>
<input tabindex="1" type="text" readonly="readonly"  	name="<%=VAGINAL_DISCHARGE %>" class="Auto" size="20" maxlength="6" value="<%=medExamObj.getVaginalDischarge() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  	name="<%=VAGINAL_DISCHARGE %>" class="Auto" size="20" maxlength="6" />
 <% }%>
 

<label	>Prolapse</label> 
<% if(medExamObj.getProlapse()!=null){%>
<input tabindex="1" type="text" readonly="readonly"  	name="<%=PROLAPSE %>" class="Auto" size="20" maxlength="6" value="<%=medExamObj.getProlapse() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" 	name="<%=PROLAPSE %>" class="Auto" size="20" maxlength="6" />
 <% }%>


<label >USG Abdomen</label> 
<% if(medExamObj.getUsgAbdomen()!=null){%>
<input tabindex="1" type="text" readonly="readonly"  	name="<%=USG_ABORTION %>" class="Auto" size="20" maxlength="6" value="<%=medExamObj.getUsgAbdomen() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" 	name="<%=USG_ABORTION %>" class="Auto" size="20" maxlength="6" />
 <% }%>

<div class="clear"></div>
</div>
</div>

<div class="clear paddingTop15"></div>


<h4> Vision <a href="javascript:animatedcollapse.toggle('slide13')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide13">
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
 <input tabindex="1" type="text" readonly="readonly" maxlength="20"  	name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  	name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="20"  	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="10" />
 <% }%>
 </td>
		
		<td>Without Glasses</td>
			<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="20"  	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="20"  	name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  	name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getNearVisionWithoutGlassCp()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="20"  	name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="10" value="<%=medExamObj.getNearVisionWithoutGlassCp()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  	name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="10" />
 <% }%>
 </td>
		
	</tr>
	<tr>
		<td>With Glasses</td>
		<td width="10%">
	
  <% if(medExamObj.getWithGlassesRDistant()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="20"  	name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="10" value="<%=medExamObj.getWithGlassesRDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  	name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="20"  	name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="10" value="<%=medExamObj.getWithGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  	name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="10" />
 <% }%>
 </td>	
		
		<td>With Glasses</td>
			<td width="10%">
	
  <% if(medExamObj.getWithGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="20"  	name="<%=WITH_GLASSES_NEAR_R %>" maxlength="10" value="<%=medExamObj.getWithGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  	name="<%=WITH_GLASSES_NEAR_R %>" maxlength="10" />
 <% }%>
 </td>	
 	<td width="10%">
	
  <% if(medExamObj.getWithGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="20"  	name="<%=WITH_GLASSES_NEAR_L %>" maxlength="10" value="<%=medExamObj.getWithGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  	name="<%=WITH_GLASSES_NEAR_L %>" maxlength="10" />
 <% }%>
 </td>	
 	<td width="10%">
	
  <% if(medExamObj.getNearVisionWithGlassCp()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="20"  	name="<%=WITH_GLASSES_NEAR_CP %>" maxlength="10" value="<%=medExamObj.getNearVisionWithGlassCp()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  	name="<%=WITH_GLASSES_NEAR_CP %>" maxlength="10" />
 <% }%>
 </td>	
		
	</tr>

</table>

	</div>

<div class="clear paddingTop15"></div>

<h4> Hearing <a	href="javascript:animatedcollapse.toggle('slide14')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide14">
<div class="Block">
<div class="clear"></div>

<label>Hearing <br /><span class="sublabel">RFW(Cms)</span></label> 
<% if(medExamObj.getEarHearingRfw() != null){ %>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="hrfw" name="<%=HEARING_R_F_W %>" value="<%=medExamObj.getEarHearingRfw()   %>" onkeyup="isNumber1(this)" maxlength="6" /> 
	<%}else{ %>
	<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="hrfw" name="<%=HEARING_R_F_W %>" onkeyup="isNumber1(this)"	maxlength="6"  /> 
	
	<%} %>
	<label>Hearing <br /><span class="sublabel">LFW(Cms)</span></label> 
<% if(medExamObj.getEarHearingLfw() != null){ %>	
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="hlfw" value="<%=medExamObj.getEarHearingLfw()  %>" name="<%=HEARING_L_F_W%>" onkeyup="isNumber1(this)" maxlength="6"/> 
	<%}else{ %>
	<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="hrfw" name="<%=HEARING_L_F_W %>" onkeyup="isNumber1(this)"	maxlength="6"  /> 
	
	<%} %>
	
	<label>Hearing Both <br /><span class="sublabel">FW(Cms)</span></label> 
	<% if(medExamObj.getEarHearingBothFw() != null){ %>
	<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="bothfw"	name="<%=HEARING_BOTH_FW %>" value="<%= medExamObj.getEarHearingBothFw() %>" onkeyup="isNumber1(this)" maxlength="6"/>
<%}else{ %>
		<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="bothfw"	name="<%=HEARING_BOTH_FW %>" onkeyup="isNumber1(this)" maxlength="6"/>
	
	<%} %>
	
<div class="clear"></div>

<label>Hearing <br /><span class="sublabel">RCV(Cms)</span></label>
<% if(medExamObj.getHearingRcv() != null){ %>
 <input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="hrcv" name="<%=HEARING_R_C_V %>" value="<%= medExamObj.getHearingRcv() %>" onkeyup="isNumber1(this)" maxlength="6" />
<%}else{ %>	
	 <input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="hrcv" name="<%=HEARING_R_C_V %>" onkeyup="isNumber1(this)"	maxlength="6"  />
	<%} %>
	 <label>Hearing <br /><span class="sublabel">LCV(Cms)</span></label>
	 
	 <% if(medExamObj.getHearingLcv() != null){ %>
	  <input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="hlcv" name="<%=HEARING_L_C_V %>" value="<%= medExamObj.getHearingLcv() %>" onkeyup="isNumber1(this)" maxlength="6"/> 
	  <%}else{ %>
	    <input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="hlcv" name="<%=HEARING_L_C_V %>" onkeyup="isNumber1(this)" maxlength="6"/>
	  <%} %>
	  <label>Hearing Both <br /><span class="sublabel">CV(Cms)</span></label> 
	  	 <% if(medExamObj.getHearingBothCv() != null){ %>
	  <input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="bothcv" name="<%=HEARING_BOTH_CV %>" value="<%= medExamObj.getHearingBothCv()  %>" onkeyup="isNumber1(this)" maxlength="6"/>
<%}else{ %>
 <input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="bothcv" name="<%=HEARING_BOTH_CV %>" onkeyup="isNumber1(this)" maxlength="6"/>
<%} %>
<div class="clear"></div>
<label > Tympanic Membrance intact<br /><span class="sublabel">(Left)</span></label> 
<select name="<%=TYMPANIC_L %>" size="0" tabindex="1" id="tympanic_l" disabled="disabled">
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
<select name="<%=TYMPANIC_R %>" size="0" tabindex="1" id="tympanic_r" disabled="disabled">
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
	  	 <% if(medExamObj.getMobilityV() != null){ %>
	  <input tabindex="1" type="text" readonly="readonly"  name="<%=MOBILITYV %>" maxlength="100"  value="<%= medExamObj.getMobilityV()  %>"  />
<%}else{ %>
 <input tabindex="1" type="text" readonly="readonly"  name="<%=MOBILITYV %>"  maxlength="100"  />
<%} %> 
<div class="clear"></div>
<label>Nose, Throat and Sinuses</label>
	  	 <% if(medExamObj.getNosethroat() != null){ %>
	  <input tabindex="1" type="text" readonly="readonly" maxlength="100"  id="bothcv" name="<%=NOSE_THROAT %>" value="<%= medExamObj.getNosethroat()  %>"  />
<%}else{ %>
 <input tabindex="1" type="text" readonly="readonly"   id="bothcv" name="<%=NOSE_THROAT %>"  maxlength="100"  />
<%} %>
<label>Audiometry Record <br /> <span class="sublabel">(If indicated)</span></label>
	  	 <% if(medExamObj.getAudiometryRecord() != null){ %>
	  <input tabindex="1" type="text" readonly="readonly" maxlength="10"  id="bothcv" name="<%=AUDIOMETRY_RECORD %>" value="<%= medExamObj.getAudiometryRecord()  %>"  />
<%}else{ %>
 <input tabindex="1" type="text" readonly="readonly"   id="bothcv" name="<%=AUDIOMETRY_RECORD %>"  maxlength="10"  />
<%} %>

</div>
</div>
  
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Back" type="button"	alt="Back" value="Back" class="button"	onclick="history.go(-1);return false;" /></form>
<% if(search.equalsIgnoreCase("false")){%>
<input tabindex="1" name="Button"	type="button" class="button" value="VALIDATE"	onClick="submitForm('medicalBoardExaminationAnnual','medicalExam?method=validateMedExam');" />
<input tabindex="1" name="Button"	type="button" class="button" value="REJECT"	onClick="submitForm('medicalBoardExaminationAnnual','medicalExam?method=rejectMedExam');" />
   <% }%>
 <input	type="hidden"  name="visitId"	tabindex="2" value="<%=visitId %>"/>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

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
		  	
				submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=showGridForInvestigation','gridview');
				
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
	    submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=getPatientPreviousInvestigationForCopy&&visitNo='+visitNo+'&hinId='+hinId,'gridview');
}
 
	function coolDental()
	{
	 var dentalValue=document.getElementById('dentalValueId').value;
	 
	 var mySplitResult = dentalValue.split(",");
	 for(i=1;i<mySplitResult.length;i++)
	 {
		 document.getElementById(mySplitResult[i]).checked="checked";
		
	 }
	
	}

</script></form>
</body>