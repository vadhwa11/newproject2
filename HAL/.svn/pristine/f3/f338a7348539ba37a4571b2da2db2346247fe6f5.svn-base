
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MbTypeOfEntryMaster"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/calendar.js" type="text/javascript"></script>
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
var bankArray=new Array();
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
	}
Visit visit=null;
if(visitlist!=null &&visitlist.size()>0)
{
 visit=(Visit)visitlist.get(0);
}

String url="";
if(map.get("url") != null){
	url = (String)map.get("url");
}

List<MasServiceType> serviceTypeList =null;
List<MasState> stateList = null;
List<MasMaritalStatus> maritalStatusList = null;
	if(map.get("serviceTypeList") != null){
		serviceTypeList= (List<MasServiceType>)map.get("serviceTypeList");
	}
if(map.get("stateList") != null)	{
	stateList = (List<MasState>)map.get("stateList");
	}
if(map.get("maritalStatusList") != null){
		maritalStatusList = (List<MasMaritalStatus>)map.get("maritalStatusList");
}
List<MasMedicalExaminationReportOnEntry> medicalExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
if(map.get("medicalExamList") != null){
	medicalExamList = (List<MasMedicalExaminationReportOnEntry>)map.get("medicalExamList");
}
MasMedicalExaminationReportOnEntry medExamObj = new MasMedicalExaminationReportOnEntry();

if(medicalExamList.size() > 0){
	medExamObj = medicalExamList.get(0);
}
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
}
Set<PatientInvestigationDetails> patientInvestigationdetails=null;
PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
if(map.get("patientInvestigationHeader")!=null){
	patientInvestigationHeader=(PatientInvestigationHeader)map.get("patientInvestigationHeader");
	patientInvestigationdetails=patientInvestigationHeader.getPatientInvestigationDetails();
}

Properties properties = new Properties();
String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
DgOrderhd dgOrderhd=null;
Set<DgOrderdt> getDgOrderdts=null;
if(map.get("dgOrderhd")!=null){

	dgOrderhd=(DgOrderhd)map.get("dgOrderhd");
	getDgOrderdts=dgOrderhd.getDgOrderdts();
}
List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
if(map.get("resultList") != null){
	resultList=(List)map.get("resultList");
	}
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
   }
if(!message.equalsIgnoreCase("")){
%>
<h4><%=message %></h4>
<%} %>

<!--main content placeholder starts here-->
<div class="clear"></div>
<body onLoad="coolDental()">
<form name="medExamDetail" action="" method="post">


<h2>Dental <a href="javascript:animatedcollapse.toggle('slide4')"></a></h2>
<div class="clear"></div>
<div id="slide4">
<div class="Block">
<div class="clear"></div>
<input type="hidden"  name="medicalType" id="medicalType" value="<%=medExamObj.getMedicalType() %>"/>
<input type="hidden"  name="MissTeeth" id="MissTeeth" value=""/>
<input type="hidden"  name="UnserTeeth" id="UnserTeeth" value=""/>
<% if(medExamObj.getDentalValue()!=null){%>
<input type="hidden"  name="dentalValue" id="dentalValueId" value="<%=medExamObj.getDentalValue()%>"/>
<% }else{%>
<input type="hidden"  name="dentalValue" id="dentalValueId" value=""/>
<%} %>
<label >Total No. of Teeth</label>
  <% if(medExamObj.getTotalTeeth()!=null){%>

 <input tabindex="1"	type="text"  readonly="readonly"  name="<%=TOTAL_NO_OF_TEETH %>" class="small" value="<%=medExamObj.getTotalTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" />

 <% }else{%>
<input tabindex="1"	type="text"  name="<%=TOTAL_NO_OF_TEETH %>" class="small" readonly="readonly"
	onKeyUp="isNumber(this)" maxlength="2" />

 <% }%>


<label class="medium3">Total No. of Defective Teeth</label>
 <% if(medExamObj.getTotalDefectiveTeeth()!=null){%>
<input tabindex="1"	type="text"  readonly="readonly"   name="<%=DEFECTIVE_TEETH %>" class="small" value="<%=medExamObj.getTotalDefectiveTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" />


 <% }else{%>
<input tabindex="1"	type="text"  name="<%=DEFECTIVE_TEETH %>" class="small" readonly="readonly"
	onKeyUp="isNumber(this)" maxlength="2" />


 <% }%>
	<label class="medium3">Total No. of Dental Points</label>
	<% if(medExamObj.getDenstlPoint()!=null){%>
	<input	tabindex="1" type="text" readonly="readonly" name="<%=DENTSL_POINT %>" value="<%=medExamObj.getDenstlPoint() %>"
	onKeyUp="isNumber(this);" maxlength="2" />


 <% }else{%>
	<input	tabindex="1" type="text"  name="<%=DENTSL_POINT %>" readonly="readonly"
	onKeyUp="isNumber(this);" maxlength="2" />


 <% }%>

	<div class="clear"></div>

<label >Missing </label>
	<% if(medExamObj.getMissingTeeth()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);" value="<%=medExamObj.getMissingTeeth() %>"
	maxlength="2" />
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);"
	maxlength="2" />
 <% }%>
<label class="medium3">Unsaveable</label>

<% if(medExamObj.getUnservisableTeeth()!=null){%>
<input	tabindex="1" type="text"   name="<%=MISSING_UNSERVICABLE_TEETH %>" value="<%=medExamObj.getUnservisableTeeth() %>" readonly="readonly"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }else{%>
<input	tabindex="1" type="text"  name="<%=MISSING_UNSERVICABLE_TEETH %>"  readonly="readonly"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }%>
 <label class="medium3">Condition of Gums</label>

<% if(medExamObj.getConditionOfGums()!=null){%>
<input	tabindex="1" type="text"   readonly="readonly"   name="<%=CONDITION_OF_GUMS %>" value="<%=medExamObj.getConditionOfGums() %>"
	class="" onchange="return CheckAlpha(event);"  id="txtAlpha" maxlength="2" validate="Condition Of Gums,Alphabetic,Yes" />


 <% }else{%>
<input	tabindex="1" type="text" readonly="readonly"   name="<%=CONDITION_OF_GUMS %>"
	class="" onchange="return CheckAlpha(event);" id="txtAlpha" maxlength="2" validate="Condition Of Gums,Alphabetic,Yes"/>

 <% }%>
<div class="clear"></div>


<h4>Missing Teeth</h4>
<div class="clear"></div>
<label >UR</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MUR_8%>" value="" class="radioAuto" id="d1" onclick="chkValue(this);"  />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MUR_7%>" value="" class="radioAuto" id="d2" onclick="chkValue(this);" />
	<label class="smallAuto">7</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MUR_6%>" value="" class="radioAuto" id="d3" onclick="chkValue(this);" />
<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MUR_5%>" value="" class="radioAuto" id="d4" onclick="chkValue(this);" />
<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MUR_4%>" value="" class="radioAuto" id="d5"  onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MUR_3%>" value="" class="radioAuto" id="d6"  onclick="chkValue(this);" />
<label class="smallAuto">3</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MUR_2%>" value="" class="radioAuto" id="d7" onclick="chkValue(this);" />
<label class="smallAuto">2</label>

<input tabindex="1" type="checkbox"  disabled="disabled"
	name="<%=MUR_1%>" value="" class="radioAuto" id="d8"  onclick="chkValue(this);" />
<label class="smallAuto">1</label>

<div class="clear"></div>
<label>UL</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MUL_8%>" value="" class="radioAuto" id="d9" onclick="chkValue(this);" />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MUL_7%>" value="" class="radioAuto" id="d10" onclick="chkValue(this);" />
	<label class="smallAuto">7</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MUL_6%>" value="" class="radioAuto" id="d11" onclick="chkValue(this);" />
	<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MUL_5%>" value="" class="radioAuto" id="d12" onclick="chkValue(this);" />
	<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MUL_4%>" value="" class="radioAuto" id="d13" onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MUL_3%>" value="" class="radioAuto" id="d14" onclick="chkValue(this);" />
	<label class="smallAuto">3</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MUL_2%>" value="" class="radioAuto" id="d15" onclick="chkValue(this);" />
	<label class="smallAuto">2</label>
<input tabindex="1" type="checkbox"  disabled="disabled"
	name="<%=MUL_1%>" value="" class="radioAuto" id="d16" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>


<div class="clear"></div>
<label >LR</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MLR_8%>" value="" class="radioAuto" id="d17"  onclick="chkValue(this);" />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MLR_7%>" value="" class="radioAuto" id="d18"  onclick="chkValue(this);" />
	<label class="smallAuto">7</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MLR_6%>" value="" class="radioAuto" id="d19" onclick="chkValue(this);" />
	<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MLR_5%>" value="" class="radioAuto" id="d20" onclick="chkValue(this);" />
	<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MLR_4%>" value="" class="radioAuto" id="d21" onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MLR_3%>" value="" class="radioAuto" id="d22" onclick="chkValue(this);" />
	<label class="smallAuto">3</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MLR_2%>" value="" class="radioAuto" id="d23" onclick="chkValue(this);" />
	<label class="smallAuto">2</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MLR_1%>" value="" class="radioAuto" id="d24" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>

<div class="clear"></div>
<label class=>LL</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MLL_8%>" value="" class="radioAuto" id="d25" onclick="chkValue(this);" />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MLL_7%>" value="" class="radioAuto" id="d26" onclick="chkValue(this);" />
	<label class="smallAuto">7</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MLL_6%>" value="" class="radioAuto" id="d27" onclick="chkValue(this);" />
	<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MLL_5%>" value="" class="radioAuto" id="d28" onclick="chkValue(this);" />
	<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MLL_4%>" value="" class="radioAuto" id="d29" onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MLL_3%>" value="" class="radioAuto" id="d30" onclick="chkValue(this);" />
	<label class="smallAuto">3</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MLL_2%>" value="" class="radioAuto" id="d31" onclick="chkValue(this);" />
	<label class="smallAuto">2</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=MLL_1%>" value="" class="radioAuto" id="d32" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> <div class="clear"></div>


<h4>Unsaveable Teeth</h4>
<div class="clear"></div>
<label >UR</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=UUR_8%>" value="" class="radioAuto" id="d33" onclick="chkValue(this);" />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=UUR_7%>" value="" class="radioAuto" id="d34" onclick="chkValue(this);" />
	<label class="smallAuto">7</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=UUR_6%>" value="" class="radioAuto" id="d35" onclick="chkValue(this);" />
	<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=UUR_5%>" value="" class="radioAuto" id="d36" onclick="chkValue(this);" />
	<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=UUR_4%>" value="" class="radioAuto" id="d37" onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=UUR_3%>" value="" class="radioAuto" id="d38" onclick="chkValue(this);" />
	<label class="smallAuto">3</label>
<input tabindex="1" type="checkbox"  disabled="disabled"
	name="<%=UUR_2%>" value="" class="radioAuto" id="d39" onclick="chkValue(this);" />
	<label class="smallAuto">2</label>
<input tabindex="1" type="checkbox"  disabled="disabled"
	name="<%=UUR_1%>" value="" class="radioAuto" id="d40" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>
	<div class="clear"></div>


<div class="clear"></div>
<label >UL</label>
<input tabindex="1" type="checkbox"  disabled="disabled"
	name="<%=UUL_8%>" value="" class="radioAuto" id="d41" onclick="chkValue(this);" />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox"  disabled="disabled"
	name="<%=UUL_7%>" value="" class="radioAuto" id="d42" onclick="chkValue(this);" />
	<label class="smallAuto">7</label>

<input tabindex="1" type="checkbox"  disabled="disabled"
	name="<%=UUL_6%>" value="" class="radioAuto" id="d43" onclick="chkValue(this);" />
	<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=UUL_5%>" value="" class="radioAuto" id="d44" onclick="chkValue(this);" />
	<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=UUL_4%>" value="" class="radioAuto" id="d45" onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=UUL_3%>" value="" class="radioAuto" id="d46" onclick="chkValue(this);" />
	<label class="smallAuto">3</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=UUL_2%>" value="" class="radioAuto" id="d47" onclick="chkValue(this);" />
	<label class="smallAuto">2</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=UUL_1%>" value="" class="radioAuto" id="d48" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>


<div class="clear"></div>
<label >LR</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=ULR_8%>" value="" class="radioAuto" id="d49" onclick="chkValue(this);" />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=ULR_7%>" value="" class="radioAuto" id="d50" onclick="chkValue(this);" />
	<label class="smallAuto">7</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=ULR_6%>" value="" class="radioAuto" id="d51" onclick="chkValue(this);" />
	<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=ULR_5%>" value="" class="radioAuto" id="d52" onclick="chkValue(this);" />
	<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=ULR_4%>" value="" class="radioAuto" id="d53" onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=ULR_3%>" value="" class="radioAuto" id="d54" onclick="chkValue(this);" />
	<label class="smallAuto">3</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=ULR_2%>" value="" class="radioAuto" id="d55" onclick="chkValue(this);" />
	<label class="smallAuto">2</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=ULR_1%>" value="" class="radioAuto" id="d56" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>

<div class="clear"></div>
<label >LL</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=ULL_8%>" value="" class="radioAuto" id="d57" onclick="chkValue(this);" />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=ULL_7%>" value="" class="radioAuto" id="d58" onclick="chkValue(this);" />
	<label class="smallAuto">7</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=ULL_6%>" value="" class="radioAuto" id="d59" onclick="chkValue(this);" />
	<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=ULL_5%>" value="" class="radioAuto" id="d60" onclick="chkValue(this);" />
	<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=ULL_4%>" value="" class="radioAuto" id="d61" onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=ULL_3%>" value="" class="radioAuto" id="d62" onclick="chkValue(this);" />
	<label class="smallAuto">3</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=ULL_2%>" value="" class="radioAuto" id="d63" onclick="chkValue(this);" />
	<label class="smallAuto">2</label>
<input tabindex="1" type="checkbox" disabled="disabled"
	name="<%=ULL_1%>" value="" class="radioAuto" id="d64" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>
<div class="clear"></div>
<label > Remarks</label>
 <%
if(medExamObj.getRemarksTeath()!=null){%>
 <textarea rows="" cols="60" name="<%=DENTAL_REMARKS %>" class="auto" onkeyup="chkLength(this,150);" value="<%=medExamObj.getRemarksTeath() %>" readonly="readonly"><%=medExamObj.getRemarksTeath() %></textarea>
 <% }else{%>
 <textarea rows="" cols="60" name="<%=DENTAL_REMARKS %>" class="auto" onkeyup="chkLength(this,150);" readonly="readonly"></textarea>
 <% }%>
<label class=""> Refer to MH</label>
<%	if(medExamObj.getReferToMH()!=null && medExamObj.getReferToMH().equalsIgnoreCase("yes")){ %>

<input tabindex="1" type="checkbox" disabled="disabled"
name="dentalReferToMH" value="no" checked="checked" class="radioAuto"  id="dentalReferToMH"  onclick="checkForDentalMH();"/>
	<%}else
		{%>
	<input tabindex="1" type="checkbox" disabled="disabled"
name="dentalReferToMH" value="no" class="radioAuto"  id="dentalReferToMH"  onclick="checkForDentalMH();"/>
	<%} %>
	<div class="clear"></div>

	<div class="clear"></div>
	<div class="clear"></div>
	</div>
</div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<%	int count=1;
String Labresult="NotPresent";
    if(getDgOrderdts!=null)
    {
	for(DgOrderdt dgOrderdt : getDgOrderdts){%>
	<input type="hidden" value="<%=dgOrderdt.getId()%>" name="dgOrderdtId<%=count%>" id="dgOrderdtId<%=count%>" />
<%count++;}
    } %>
<% //if(visit.getHin() !=null){%>
<INPUT type=hidden value="" name="hinNoForreport" id="hinNoForreport"/>
<% //}%>

<div class="clear paddingTop15"></div>

<h4> PHYSICAL CAPACITY<a href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div class="clear"></div>
<div id="slide5">
<div class="Block">
<label >Height</label>
  <% if(medExamObj.getHeight()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  size="18" id="height" class="auto"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)" value="<%=medExamObj.getHeight() %>"
	maxlength="6" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" size="18"  id="height"	class="auto"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)"
	maxlength="6" onblur="checkForWiegth(this.value,id);calculateBMI();"  /><label class="unit">cm</label>
 <% }%>

<label	>Weight</label>
  <% if(medExamObj.getActualweight()!=null){%>
<input tabindex="1" type="text"  readonly="readonly" id="weight" class="auto" size="18" name="<%=ACTUAL_WEIGHT %>" maxlength="6" value="<%=medExamObj.getActualweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="unit">kg</label>

 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly" id="weight" class="auto" size="18"	name="<%=ACTUAL_WEIGHT %>" maxlength="6"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="unit">kg</label>
 <% }%>

<label	>Ideal Weight</label>
  <% if(medExamObj.getIdealweight()!=null){%>
<input tabindex="1" type="text" readonly="readonly" size="18" id="<%=IDEAL_WEIGHT %>" name="<%=IDEAL_WEIGHT %>" class="auto"	maxlength="6" value="<%=medExamObj.getIdealweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="unit">kg</label>

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" size="18" id="<%=IDEAL_WEIGHT %>" name="<%=IDEAL_WEIGHT %>" class="auto"	maxlength="6"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="unit">kg</label>

 <% }%>

<div class="clear"></div>
<label	>Over Weight</label>
  <% if(medExamObj.getOverweight()!=null){%>
<input tabindex="1" type="text" readonly="readonly" size="18" id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>" class="auto"	maxlength="6" value="<%=medExamObj.getOverweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="unit">%</label>

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" size="18" id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>"  class="auto"	maxlength="6"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="unit">%</label>

 <% }%>
 <label	>BMI</label>
  <% if(medExamObj.getBhi()!=null){%>
<input tabindex="1" type="text"  readonly="readonly" id="bmi" size="18"  name="<%=BHI %>" maxlength="6" value="<%=medExamObj.getBhi() %>"
	onKeyUp="limitText(this,6);" class="auto" /><label class="unit">Kg/m<sup>2</sup></label>

 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly" id="bmi" name="<%=BHI %>" maxlength="6"
	onKeyUp="limitText(this,6);" size="18"  class="auto"  /><label class="unit">Kg/m<sup>2</sup></label>

 <% }%>


<label	>Body Fat</label>
  <% if(medExamObj.getBodyfat()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  id="" name="<%=BODY_FAT %>"maxlength="6" value="<%=medExamObj.getBodyfat() %>"
	onKeyUp="limitText(this,6);" class="auto" size="18"  /><input class="transparent" size="6">

 <% }else{%>
<input tabindex="1" type="text" id="" name="<%=BODY_FAT %>" maxlength="6" readonly="readonly"
	onKeyUp="limitText(this,6);"  class="auto" size="18" /><input class="transparent" size="6">

 <% }%>
<div class="clear"></div>


<label	>Waist</label>
  <% if(medExamObj.getWaist()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="6" value="<%=medExamObj.getWaist() %>"
	onKeyUp="limitText(this,6);" onblur="calculateWHR();" class="auto" size="18"  /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="6" readonly="readonly"
	onKeyUp="limitText(this,6);" onblur="calculateWHR();" class="auto" size="18"  /><label class="unit">cm</label>

 <% }%>

<label	>Hip</label>
  <% if(medExamObj.getHips()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  maxlength="20"  id="hips" name="Hips" maxlength="6" value="<%=medExamObj.getHips() %>"
	onKeyUp="limitText(this,6);" onblur="calculateWHR();" class="auto" size="18" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="hips" name="Hips" maxlength="6"  readonly="readonly"
	onKeyUp="limitText(this,6);" onblur="calculateWHR();" class="auto" size="18"  /><label class="unit">cm</label>

 <% }%>

<label	>WHR</label>
  <% if(medExamObj.getWhr()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="WHR" name="WHR" maxlength="6" value="<%=medExamObj.getWhr() %>"
	onKeyUp="limitText(this,6);" class="auto" size="18" /><input class="transparent" size="6">

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="WHR" name="WHR" maxlength="6" readonly="readonly"
	onKeyUp="limitText(this,6);" class="auto" size="18"  /><input class="transparent" size="6">

 <% }%>
 <div class="clear"></div>
<label	>Skin Fold Thickness</label>
  <% if(medExamObj.getSignfoldthickness()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  id="" name="<%=THICKNESS %>" maxlength="6" value="<%=medExamObj.getSignfoldthickness() %>"
	onKeyUp="limitText(this,6);" class="auto" size="18"  /><input class="transparent" size="5">

 <% }else{%>
<input tabindex="1" type="text" id="" name="<%=THICKNESS %>" maxlength="6" readonly="readonly"
	onKeyUp="limitText(this,6);"  class="auto" size="18" />
	<input class="transparent" size="6">
 <% }%>

<label	>Chest Full Expansion</label>
  <% if(medExamObj.getChestfullexpansion()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" class="auto"	 maxlength="6" value="<%=medExamObj.getChestfullexpansion() %>"
	onKeyUp="limitText(this,6);" class="auto" size="18"  /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" class="auto"	 maxlength="6"
	onKeyUp="limitText(this,6);" class="auto" size="18" /><label class="unit">cm</label>

 <% }%>
<label>Range of Expansion</label>
  <% if(medExamObj.getRangeofexpansion()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="6" value="<%=medExamObj.getRangeofexpansion() %>"
	onKeyUp="limitText(this,6);" class="auto" size="18" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="6"
	onKeyUp="limitText(this,6);" class="auto" size="18"  /><label class="unit">cm</label>

 <% }%>
<div class="clear"></div>
<label>Sportsman</label>
 <select name="<%=SPORTS %>"  id="<%=SPORTS %>" class="smaller" disabled="disabled" validate="Sports Man,stirng,no">
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


<h4> Vision <a href="javascript:animatedcollapse.toggle('slide6')"></a></h4>
<div class="clear"></div>
<div id="slide6">
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
 <input tabindex="1" type="text" 	readonly="readonly"  name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithoutGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" readonly="readonly"  name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="10" />
 <% }%>
 </td>

		<td>Without Glasses</td>
			<td width="10%">

  <% if(medExamObj.getWithoutGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly"  name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text"	readonly="readonly"  name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithoutGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly"  name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="10" />
 <% }%>
 </td>

 	<td width="10%" rowspan="2">

  <% if(medExamObj.getNearVisionWithoutGlassCp()!=null){%>
 <input tabindex="1" type="text"  readonly="readonly"	name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="10" value="<%=medExamObj.getNearVisionWithoutGlassCp()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="10" />
 <% }%>
 </td>

	</tr>
	<tr>
		<td>With Glasses</td>
		<td width="10%">

  <% if(medExamObj.getWithGlassesRDistant()!=null){%>
 <input tabindex="1" type="text" readonly="readonly"  name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="10" value="<%=medExamObj.getWithGlassesRDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" readonly="readonly"  name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="10" value="<%=medExamObj.getWithGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="10" />
 <% }%>
 </td>

		<td>With Glasses</td>
			<td width="10%">

  <% if(medExamObj.getWithGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly"  name="<%=WITH_GLASSES_NEAR_R %>" maxlength="10" value="<%=medExamObj.getWithGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  name="<%=WITH_GLASSES_NEAR_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly"  name="<%=WITH_GLASSES_NEAR_L %>" maxlength="10" value="<%=medExamObj.getWithGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  name="<%=WITH_GLASSES_NEAR_L %>" maxlength="10" />
 <% }%>

</tr>
</table>
</div>
<div class="clear paddingTop15"></div>



<h4> Hearing <a	href="javascript:animatedcollapse.toggle('slide7')"></a></h4>
<div class="clear"></div>
<div id="slide7">

<table width="50%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col"></th>
		<th scope="col">R</th>
		<th scope="col">L</th>
		<th scope="col">Both</th>
		</tr>
	<tr>
		<th>FW</th>

		<td>
			<% if(medExamObj.getEarHearingRfw() != null){ %>
			<input tabindex="1" type="text"  readonly="readonly"   maxlength="20"  id="hrfw" name="<%=HEARING_R_F_W %>" value="<%=medExamObj.getEarHearingRfw()   %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
			<%}else{ %>
			<input tabindex="1" type="text" readonly="readonly"  maxlength="20"  id="hrfw" name="<%=HEARING_R_F_W %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" />
			cm
			<%} %>
		</td>

		<td>
			<% if(medExamObj.getEarHearingLfw() != null){ %>
			<input tabindex="1" type="text" readonly="readonly"  maxlength="20"  id="hlfw" value="<%=medExamObj.getEarHearingLfw()  %>" name="<%=HEARING_L_F_W%>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
			<%}else{ %>
			<input tabindex="1" type="text" readonly="readonly"  maxlength="20"  id="hlfw" name="<%=HEARING_L_F_W %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" />
			cm
			<%} %>
		</td>

		<td>
			<% if(medExamObj.getEarHearingBothFw() != null){ %>
			<input tabindex="1" type="text" readonly="readonly"  maxlength="20"  id="bothfw"	name="<%=HEARING_BOTH_FW %>" value="<%= medExamObj.getEarHearingBothFw() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
			<%}else{ %>
			<input tabindex="1" type="text" readonly="readonly"  maxlength="20"  id="bothfw"	name="<%=HEARING_BOTH_FW %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
			cm
			<%} %>
		</td>
	</tr>


	<tr>

		<th>CV</th>

		<td>
			<% if(medExamObj.getHearingRcv() != null){ %>
 			<input tabindex="1" type="text" readonly="readonly"  maxlength="20"  id="hrcv" name="<%=HEARING_R_C_V %>" value="<%= medExamObj.getHearingRcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
			<%}else{ %>
			<input tabindex="1" type="text" readonly="readonly"  maxlength="20"  id="hrcv" name="<%=HEARING_R_C_V %>" onkeyup="isNumber1(this)"	maxlength="6" onblur="checkForWiegth(this.value,id);" />
			cm
			<%} %>
		</td>

		<td>
			 <% if(medExamObj.getHearingLcv() != null){ %>
			 <input tabindex="1" type="text" readonly="readonly"  maxlength="20"  id="hlcv" name="<%=HEARING_L_C_V %>" value="<%= medExamObj.getHearingLcv() %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
	  		 <%}else{ %>
	   		 <input tabindex="1" type="text" readonly="readonly"  maxlength="20"  id="hlcv" name="<%=HEARING_L_C_V %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
	   		 cm
			  <%} %>
		</td>

		<td>
	  		 <% if(medExamObj.getHearingBothCv() != null){ %>
	 		 <input tabindex="1" type="text" readonly="readonly"  maxlength="20"  id="bothcv" name="<%=HEARING_BOTH_CV %>" value="<%= medExamObj.getHearingBothCv()  %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
			 <%}else{ %>
 			 <input tabindex="1" type="text" readonly="readonly"  maxlength="20"  id="bothcv" name="<%=HEARING_BOTH_CV %>" onkeyup="isNumber1(this)" maxlength="6" onblur="checkForWiegth(this.value,id);" />
 			 cm
			 <%} %>

		</td>
	</tr>

	<tr>
		<th>TM</th>
		<td>
			<select name="<%=TYMPANIC_L %>" class="smaller" size="0" disabled="disabled" tabindex="1" id="tympanic_l">
				<option value="Intact">Intact</option>
				<option value="NO">Not Intact</option>

			</select>
			<script>
				<%
					if(medExamObj.getTympanicL()!= null){
				%>
				document.getElementById("tympanic_l").value='<%=medExamObj.getTympanicL()%>';

				<%}%>
			</script>
		</td>
		<td>
			<select name="<%=TYMPANIC_R %>" class="smaller" size="0" disabled="disabled" tabindex="1" id="tympanic_r">
				<option value="Intact">Intact</option>
				<option value="NO">Not Intact</option>

			</select>
			<script>
				<%
				if(medExamObj.getTympanicR()!= null){
				%>
				document.getElementById("tympanic_r").value='<%=medExamObj.getTympanicR()%>';

				<%}%>
			</script>

		</td>

		<td></td>
</tr>

<tr>
		<th>Mobility</th>
		<td>
	  	 	<% if(medExamObj.getMobilityL() != null){ %>
	 		 <input tabindex="1" type="text" readonly="readonly"  class="auto" size="27" name="<%=MOBILITYL %>" maxlength="100"  value="<%= medExamObj.getMobilityL()  %>"  />
			<%}else{ %>
 			<input tabindex="1" type="text" readonly="readonly"  class="auto" size="27" name="<%=MOBILITYL %>"  maxlength="100"  />
			<%} %>

		</td>
		<td>
	  	 	<% if(medExamObj.getMobilityR() != null){ %>
	  		<input tabindex="1" type="text" readonly="readonly"  class="auto" size="27" name="<%=MOBILITYR %>" maxlength="100"  value="<%= medExamObj.getMobilityR()  %>"  />

			<%}else{ %>
 			<input tabindex="1" type="text" readonly="readonly" class="auto" size="27" name="<%=MOBILITYR %>"  maxlength="100"  />
			<%} %>


		</td>

	    <td></td>
</tr>

</table>



<div class="Block">
<label>Nose, Throat &amp; Sinuses</label>
	  	 <% if(medExamObj.getNosethroat() != null){ %>
	  <input tabindex="1" type="text" readonly="readonly"  maxlength="100"  id="bothcv" name="<%=NOSE_THROAT %>" value="<%= medExamObj.getNosethroat()  %>"  />
<%}else{ %>
 <input tabindex="1" type="text"   readonly="readonly"  id="bothcv" name="<%=NOSE_THROAT %>"  maxlength="100"  />
<%} %>
<label>Audiometry Record </label>
	  	 <% if(medExamObj.getAudiometryRecord() != null){ %>
	  <input tabindex="1" type="text" readonly="readonly"  maxlength="10"  id="bothcv" name="<%=AUDIOMETRY_RECORD %>" value="<%= medExamObj.getAudiometryRecord()  %>"  />
<%}else{ %>
 <input tabindex="1" type="text"   readonly="readonly"  id="bothcv" name="<%=AUDIOMETRY_RECORD %>"  maxlength="10"  />
<%} %>
</div>

</div>


<input type="hidden" value="" name="deleatedValue" id="deleatedValue" />
<input type="hidden" value="" name="deleatedorderid" id="deleatedorderid" />
<div class="clear paddingTop15"></div>
<h4>Investigations <a href="javascript:animatedcollapse.toggle('slide8')"></a></h4>
<div id="slide8">
<div class="Block">
<label >Template</label>
<div id="investigationDiv">
<select name="investigationTemplateId"	tabindex="1" onchange="showHideInvestigationTemplateCombo(this.value);"  disabled="disabled" >
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
<input type="hidden" name="printReport" id="print"	onclick="submitFormForPrescriptionReport();" value="print"	class="button" accesskey="a" />
<input name="Prevoius" type="button" tabindex="2" value="Prev Investigations"	class="buttonBig"	onclick="openPopupForPatientInvestigation()" />

</div>
<div class="clear"></div>
<div id="gridview">
	<div class="clear paddingTop15"></div>
<div id="gridview">
<div id="ac2update"	style="display: none;" class="autocomplete"></div>

<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid1">
	<tr>
	<th scope="col">Clinical Notes</th>

</tr>
<tr>
	<td><input type="text" name="clinicalNotes1" tabindex="1" value="AME" size="100" maxlength="45" readonly="readonly" /></td>

	</tr>
	</table>
	<div class="clear paddingTop15"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">Investigation Name</th>
		<th scope="col">Refer to MH</th>
		<th scope="col">Investigation Result</th>
		<th scope="col">File Upload</th>
		</tr>

<%int inc=1;
if(resultList!=null && resultList.size()>0)
{%>
	 <input	type="hidden"  name="Investigated"	tabindex="2" value="yes"/>
<% }else{%>
	 <input	type="hidden"  name="Investigated"	tabindex="2" value="No"/>
<%  }


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
	   int inc1=1;
		    for(PatientInvestigationDetails patientInvestigation : patientInvestigationdetails)
		    {

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
			    for (Iterator i = new InvestigationDetailByInvestigationId().sortByValue(first).iterator(); i.hasNext(); ) {
            String key = (String) i.next();



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
	String st=(String)second.get(first.get(key));
	String[] mySplitResult = st.split("/");
	if(!mySplitResult[0].equalsIgnoreCase("template"))
	{
	%>
	<td> <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" value="n"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
 </td>
	<td><input type="text" value="<%=second.get(first.get(key))%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
</td>

<% }else{

%>
	<td><input name="resultIdTemplate<%=inc %>"
		id="resultIdTemplate<%=inc %>" type="hidden"
		value="<%=mySplitResult[1]%>"/>
		<input	type="Button" class="Button" value="Result"
		onclick="openTemplateScreen(<%=inc %>);"  /></td>

<%}}else{

	String investigationVal=key;
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
	    			name="investigationReferToMH<%=inc %>" value="y" checked="checked" id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>

<td><input type="text" value=""  tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
</td>
<% 	    	}else
            { %>
            <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" value="n"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
    <td><input type="text" value="" readonly="readonly"
			 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
</td>
            <%

             }
	    	}else
	    	{%>
	    		<input tabindex="1" type="checkbox"
	    			name="investigationReferToMH<%=inc %>" value="n"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
    <td><input type="text" value="" readonly="readonly"
			 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
        </td>
	    <%	}
	    }
	}}else{
	%>
<input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" value="n"  id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/>
<td><input type="text" value="" readonly="readonly"
			 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" />
</td>
<% }%>
</td>


<% }%>
<td><input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>
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
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal','parent')}" />
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
<input tabindex="1" type="checkbox"
	name="investigationReferToMH1" value="n" id="investigationReferToMH1" onclick="checkForInvestigationMH(1);" />
</td>
<td>
<input type="text" value="" readonly="readonly" name="Result1" id="Result1" />
</td>
<td><input name="uploadReport1" id="uploadReport1" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(1);" /></td>
	</tr>
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<% }%>
</table>
</div>
</div>
</div>
<script>
checkForInvestReferToMH();

</script>
<input type="hidden" id="investigationDataStatus" name="investigationDataStatus" value="no"/>
<div class="Clear paddingTop15"></div>

<h4> CARDIO VASCULAR SYSTEM <a	href="javascript:animatedcollapse.toggle('slide9')"></a></h4>
<div class="clear"></div>
<div id="slide9">
<div class="Block">
<div class="clear"></div>
<label>Pulse</label>
 <% if(medExamObj.getPulseRates()!=null){%>
  <input tabindex="1" type="text" maxlength="18"  readonly="readonly"  name="<%=PULSE_RATES%>" class="auto" size="18"   value="<%=medExamObj.getPulseRates() %>"/><label class="unit">/min</label>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly"  maxlength="18" value="Normal" name="<%=PULSE_RATES%>" class="auto" size="18"  /><label class="unit">/min</label>
 <% }%>
 <label>BP</label>
<% if(medExamObj.getBp()!=null){%>
  <input tabindex="1" type="text" readonly="readonly"  maxlength="18"  name="<%=BP1%>" class="auto" size="18"   value="<%=medExamObj.getBp() %>"/><label class="unit">mm Hg</label>
 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly"  maxlength="18" value="Normal"  name="<%=BP1%>" class="auto" size="18"  /><label class="unit">mm Hg</label>
 <% }%>
<label>Peripheral Pulsations</label>
<% if(medExamObj.getArterialWalls()!=null){%>
<input tabindex="1" type="text" readonly="readonly"  maxlength="18" 	name="<%= ARTERIAL_WALLS%>"    value="<%=medExamObj.getArterialWalls() %>"/>
 <% }else{%>
 <input tabindex="1" type="text"  readonly="readonly"   maxlength="18" 	value="Normal"  name="<%= ARTERIAL_WALLS%>"   />
 <% }%>


<div class="clear"></div>
<label>Heart Size</label>
<% if(medExamObj.getHeartSize()!=null){%>
<input tabindex="1" type="text" readonly="readonly"  maxlength="18" 	name="<%= HEART_SIZE%>" class="auto" size="27"  value="<%=medExamObj.getHeartSize() %>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  maxlength="18"  value="Normal"	name="<%= HEART_SIZE%>" class="auto" size="27" />
 <% }%>


 <label>Sounds</label>
 <% if(medExamObj.getSounds()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="18"  name="<%= SOUND%>" class="auto"	size="28"  value="<%=medExamObj.getSounds() %>"/>

 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="18"  value="Normal"  name="<%= SOUND%>" class="auto"	size="28"  />
 <% }%>
<label>Rhythm</label>
<% if(medExamObj.getRhythm()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" maxlength="18"  name="<%= RHYTHM%>" class="auto"	size="27"  value="<%=medExamObj.getRhythm() %>"/>

 <% }else{%>
 <input tabindex="1" type="text" readonly="readonly"    value="Regular"   maxlength="18"  name="<%= RHYTHM%>" class="auto"	size="27"  />
 <% }%>


<div class="clear"></div>

</div>
</div>
<div class="clear paddingTop15"></div>

<h4>RESPIRATORY SYSTEM <a href="javascript:animatedcollapse.toggle('slide10')"></a></h4>
<div class="clear"></div>
<div id="slide10">
<div class="Block">
<div class="clear"></div>
<label> Respiratory System</label>
<% if(medExamObj.getRespiratorySystem()!=null){%>
  <input tabindex="1" type="text" readonly="readonly"  maxlength="20" 	name="<%=RESPIRATORY_SYSTEM %>" class="auto" size="120" maxlength="100" value="<%=medExamObj.getRespiratorySystem() %>"/>
   <% }else{%>
  <input tabindex="1" type="text" readonly="readonly"  maxlength="20" 	name="<%=RESPIRATORY_SYSTEM %>" class="auto" size="120" maxlength="100" />
 <% }%>


<div class="clear"></div>
</div>
</div>

<div class="clear paddingTop15"></div>


<h4>GASTRO INTESTINAL SYSTEM <a	href="javascript:animatedcollapse.toggle('slide11')"></a></h4>
<div class="clear"></div>
<div id="slide11">
<div class="Block">
<div class="clear"></div>
<label > Liver </label>
<% if(medExamObj.getLiver()!=null){%>
  <input tabindex="1" type="text" readonly="readonly"  maxlength="120" 	name="liver" class="auto" size="120" maxlength="100" value="<%=medExamObj.getLiver() %>"/>
   <% }else{%>
  <input tabindex="1" type="text" readonly="readonly"  maxlength="20" 	name="liver" class="auto" size="120" maxlength="100" value="Not Palpable"/>
 <% }%>
<div class="clear"></div>
<label > Spleen </label>
<% if(medExamObj.getSpleen()!=null){%>
  <input tabindex="1" type="text" readonly="readonly"  maxlength="120" 	name="spleen" class="auto" size="120" maxlength="100" value="<%=medExamObj.getSpleen() %>"/>
   <% }else{%>
  <input tabindex="1" type="text" readonly="readonly"  maxlength="120" 	name="spleen" class="auto" size="120" maxlength="100" value="Not Palpable"/>
 <% }%>


<div class="clear"></div>
</div>
</div>
<div class="clear paddingTop15"></div>

<h4>CENTRAL NERVOUS SYSTEM <a href="javascript:animatedcollapse.toggle('slide12')"></a></h4>
<div class="clear"></div>
<div id="slide12">
<div class="Block">
<div class="clear"></div>
<label > Higher Mental Func</label>
<% if(medExamObj.getHigherMentalFunction()!=null){%>
<input tabindex="1" type="text" readonly="readonly"  maxlength="20" 	name="<%=HIGHER_MENTAL_FUNCTION %>" class="" size="20"  value="<%=medExamObj.getHigherMentalFunction() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  maxlength="20" 	name="<%=HIGHER_MENTAL_FUNCTION %>" class="" size="20"  value="Normal"/>
 <% }%>

<label > Speech</label>
<% if(medExamObj.getSpeech()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=SPEECH %>" class="" size="20"  readonly="readonly" value="<%=medExamObj.getSpeech() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=SPEECH %>" class="" size="20"   readonly="readonly"  value="Normal"/>
 <% }%>


<label > Reflexes</label>
<% if(medExamObj.getReflexes()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=REFLEXES %>" class="" size="20"  readonly="readonly"  value="<%=medExamObj.getReflexes() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=REFLEXES %>" class="" size="20" readonly="readonly" value="Normal"/>
 <% }%>


<div class="clear"></div>
<label > Tremors</label>
<% if(medExamObj.getTremors()!=null){%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=TREMORS %>" class="" size="20" readonly="readonly" value="<%=medExamObj.getTremors() %>"/>
   <% }else{%>
<input tabindex="1" type="text" maxlength="20" 	name="<%=TREMORS %>" class="" size="20" readonly="readonly" />
 <% }%>



<label > Self Balancing Test</label>

<select name="<%=SELF_BALANCING_TEST %>" size="0" tabindex="1" id="selfbalancingtest" disabled="disabled" disabled="disabled">
<option value="0">Steady</option>
	<option value="Fairly">Fairly Steady</option>
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
<label >Locomotor System</label>
<% if(medExamObj.getLocomoterSystem()!=null){%>
<input tabindex="1" type="text"	readonly="readonly"  name="locomoterSystem" class="" size="20" maxlength="10" value="<%=medExamObj.getLocomoterSystem() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	readonly="readonly"  name="locomoterSystem" class="" size="20" maxlength="10" value="NAD"/>
 <% }%>
<label>Spine</label>
<% if(medExamObj.getSpine()!=null){%>
<input tabindex="1" type="text" readonly="readonly"  name="spine" class="" size="20" maxlength="10" value="<%=medExamObj.getSpine() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  name="spine" class="" size="20" maxlength="10" value="NAD"/>
 <% }%>


<label>Hernia</label>
<% if(medExamObj.getHerniaMusic()!=null){%>
<input tabindex="1" type="text" readonly="readonly"  name="<%=HERNIA_MUSCLE %>" class="" size="20" maxlength="10" value="<%=medExamObj.getHerniaMusic() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  name="<%=HERNIA_MUSCLE %>" class="" size="20" maxlength="10" value="Nil"/>
 <% }%>


<div class="clear"></div>
<label>Hydrocele</label>
<% if(medExamObj.getHydrocele()!=null){%>
<input tabindex="1" type="text" readonly="readonly"  name="<%=HYDROCELE %>" class="" size="20" maxlength="10" value="<%=medExamObj.getHydrocele() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  name="<%=HYDROCELE %>" class="" size="20" maxlength="10" value="Nil"/>
 <% }%>


<label>Haemorrhoids</label>
<% if(medExamObj.getHemorrhoids()!=null){%>
<input tabindex="1" type="text" readonly="readonly"  name="<%=HEMONHOIDS %>" class="" size="20" maxlength="10" value="<%=medExamObj.getHemorrhoids() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  name="<%=HEMONHOIDS %>" class="" size="20" maxlength="10" value="Nil"/>
 <% }%>


<label>Breast</label>
<% if(medExamObj.getBreasts()!=null){%>
<input tabindex="1" type="text" readonly="readonly"  name="<%=BREASTS %>" class="" size="20" maxlength="10" value="<%=medExamObj.getBreasts() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  name="<%=BREASTS %>" class="" size="20" maxlength="10" value="NAD"/>
 <% }%>
<div class="clear"></div>
</div>
</div>
<div class="clear paddingTop15"></div>
<%
if(medExamObj.getVisit() !=null){

if(medExamObj.getVisit().getHin().getSex().getAdministrativeSexName().equalsIgnoreCase("Female")){ %>
<h4>GYNAECOLOGY EXAM <a href="javascript:animatedcollapse.toggle('slide13')"></a></h4>
<div class="clear"></div>
<div id="slide13">
<div class="Block">

<label >Menstrual History</label>
<% if(medExamObj.getMenstrualHistory()!=null){%>
<input tabindex="1" type="text"   readonly="readonly"  maxlength="20" 	name="<%=MENSTRUAL_HISTORY %>" class="auto" size="20" maxlength="30" value="<%=medExamObj.getMenstrualHistory() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  maxlength="20" 	name="<%=MENSTRUAL_HISTORY %>" class="auto" size="20" maxlength="30" />
 <% }%>

<label>LMP</label>
<% if(medExamObj.getLmp()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"  class="calDate" readonly="readonly "	name="<%=LMP %>"  size="20" maxlength="3" onKeyUp="mask(this.value,this,'2,5','/');" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getLmp()) %>"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly" class="calDate" readonly="readonly "	name="<%=LMP %>" onKeyUp="mask(this.value,this,'2,5','/');"  size="20" maxlength="3" />
 <% }%>
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',medExamDetail.<%=LMP%>,event);" />

<label >No. of pregnancies</label>
<% if(medExamObj.getNoOfPregnancies()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"	name="<%=NO_OF_PREGNANCY %>"  maxlength="6" value="<%=medExamObj.getNoOfPregnancies() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"	name="<%=NO_OF_PREGNANCY %>"  maxlength="6" />
 <% }%>

<div class="clear"></div>
<label >No of Abortions</label>
<% if(medExamObj.getNoOfAbortions()!=null){%>
<input tabindex="1" type="text"  readonly="readonly" 	name="<%=NO_OF_ABORTION %>" class="auto" size="20" maxlength="6" value="<%=medExamObj.getNoOfAbortions() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"	name="<%=NO_OF_ABORTION %>" class="auto" size="20" maxlength="6" />
 <% }%>
<label >No. of Children</label>
<% if(medExamObj.getNoOfChildren()!=null){%>
<input tabindex="1" type="text"   readonly="readonly"	name="<%=NO_OF_CHILDREN %>" class="" size="20" maxlength="6" value="<%=medExamObj.getNoOfChildren() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"	name="<%=NO_OF_CHILDREN %>" class="" size="20" maxlength="6" />
 <% }%>


<label >Last Confinement on</label>
<% if(medExamObj.getLastConfinementDate()!=null){%>
<input tabindex="1" type="text" maxlength="20"  class="calDate" readonly="readonly" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getLastConfinementDate()) %>"	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" />
   <% }else{%>
<input tabindex="1" type="text" maxlength="20"  class="calDate" readonly="readonly"	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" value=""/>
 <% }%>


<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',medExamDetail.<%=DATE_OF_LASTCONFINEMENT%>,event);" />
<div class="clear"></div>
<label >Vaginal Discharge</label>
<% if(medExamObj.getVaginalDischarge()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"	name="<%=VAGINAL_DISCHARGE %>" class="auto" size="20" maxlength="6" value="<%=medExamObj.getVaginalDischarge() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"	name="<%=VAGINAL_DISCHARGE %>" class="auto" size="20" maxlength="6" />
 <% }%>


<label	>Prolapse</label>
<% if(medExamObj.getProlapse()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"	name="<%=PROLAPSE %>" class="" size="20" maxlength="6" value="<%=medExamObj.getProlapse() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly"	name="<%=PROLAPSE %>" class="" size="20" maxlength="6" />
 <% }%>


<label >USG Abdomen</label>
<% if(medExamObj.getUsgAbdomen()!=null){%>
<input tabindex="1" type="text"  readonly="readonly"	name="<%=USG_ABORTION %>"  maxlength="6" value="<%=medExamObj.getUsgAbdomen() %>"/>
   <% }else{%>
<input tabindex="1" type="text"  readonly="readonly"	name="<%=USG_ABORTION %>"  maxlength="6" />
 <% }%>
 <input class="transparent" size="150">
<input name="Send" type="hidden"  class="button" value="Upload" onClick="javascript:FileUploadWindowGynaecology();" />
<div class="clear"></div>
</div>
</div><%}
}%>

<div class="clear"></div>
<input type="button" name="Close" value="Close" class="button" onclick="window.close()" tabindex="1" />
</form>
</body>
<script type="text/javascript">
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
function chkValue(Obj)
	{
		var newdentalValue="";
		var duplicate = new Boolean(false)
		var dstr=document.getElementById('dentalValueId').value;
		 var mySplitResult = dstr.split(",");
		 for(i=1;i<mySplitResult.length;i++)
		 {
			 if(mySplitResult[i]==Obj.id)
			 {
				 duplicate=true;
			 }else{
				 newdentalValue=newdentalValue+","+mySplitResult[i];
			 }
		 }
		 if(duplicate==false)
		 {
		dstr=dstr+","+Obj.id;
		document.getElementById('dentalValueId').value = dstr;
		 }else{
				document.getElementById('dentalValueId').value = newdentalValue;
		 }

	}
 function coolDental()
	{
	 var dentalValue=document.getElementById('dentalValueId').value;

	 var mySplitResult = dentalValue.split(",");
	 for(i=1;i<mySplitResult.length;i++)
	 {
		 document.getElementById(mySplitResult[i]).checked="checked";
		 messingTeeth(mySplitResult[i]);
	 }

	}
 function messingTeeth(mm)
 {
 	var name=document.getElementById(mm).name;
 	var mval=document.getElementById('MissTeeth').value;
 	var uval=document.getElementById('UnserTeeth').value;
 	if(name[0]=='m')
 	{
 		mval=mval+" "+name.substring(1,name.length).toUpperCase();
 		document.getElementById('MissTeeth').value=mval;
 	}
 	if(name[0]=='u')
 	{
 		uval=uval+" "+name.substring(1,name.length).toUpperCase();
 		document.getElementById('UnserTeeth').value=uval;
 	}
 	function messingTeeth(mm)
 	 {
 	 	var name=document.getElementById(mm).name;
 	 	var mval=document.getElementById('MissTeeth').value;
 	 	var uval=document.getElementById('UnserTeeth').value;
 	 	if(name[0]=='m')
 	 	{
 	 		mval=mval+" "+name.substring(1,name.length).toUpperCase();
 	 		document.getElementById('MissTeeth').value=mval;
 	 	}
 	 	if(name[0]=='u')
 	 	{
 	 		uval=uval+" "+name.substring(1,name.length).toUpperCase();
 	 		document.getElementById('UnserTeeth').value=uval;
 	 	}
 	 }
 } function openPopupForPatientInvestigation(visitNo,hinId){

	if(visitNo >1){
	var url="/hms/hms/opd?method=showPatientPreviousInvestigation&visitNo="+visitNo+"&hinId="+hinId;
   newwindow=window.open(url,'name','left=2,top=0,height=500,width=1010,status=1,scrollbars=1,resizable=1');
   }else{
     alert("This is Patient's First Visit. ")
   }
}
</script>