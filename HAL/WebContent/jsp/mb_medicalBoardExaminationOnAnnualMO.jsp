<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MbTypeOfEntryMaster"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.util.InvestigationDetailByInvestigationId"%>
<%@page import="jkt.hms.masters.business.Category"%>
<%@page import="jkt.hms.masters.business.MasMedicalExamInvestResult"%>
<%@page import="jkt.hms.masters.business.MasMedicalExamReportDt"%>
<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%>
<%@page import="jkt.hms.masters.business.MasMedicalExamFamilyHis"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<%@page import="jkt.hms.util.DgResultEntryComparatorByOrderNo"%>
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
		String time = (String) utilMap.get("currentTimeWithoutSc");
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';

	</script>


<script type="text/javascript">
<%
String Labresult="NotPresent";
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
List<PatientFamilyHistory> patientFamilyHistoryList=new ArrayList<PatientFamilyHistory>();
if(map.get("patientFamilyHistoryList")!=null)
{
	patientFamilyHistoryList = (List<PatientFamilyHistory>) map.get("patientFamilyHistoryList");

}
List<MasMedicalExamReportDt> masMedicalExamReportDtList=new ArrayList<MasMedicalExamReportDt>();
if(map.get("masMedicalExamReportDtList")!=null)
{
	masMedicalExamReportDtList = (List<MasMedicalExamReportDt>) map.get("masMedicalExamReportDtList");

}
String signedBy="";
List<MasEmployee> employeeMoList = new ArrayList<MasEmployee>();
if(map.get("employeeMoList")!=null)
{
	employeeMoList = (List<MasEmployee>) map.get("employeeMoList");

}
int departmentId = 0;
if(map.get("deptId") != null){
	departmentId=(Integer)map.get("deptId");
	}
if(employeeMoList.size()>0){
	for(MasEmployee masEmployee:employeeMoList){
		signedBy=masEmployee.getFirstName();
		if(masEmployee.getMiddleName()!=null){
			signedBy=signedBy+" "+masEmployee.getMiddleName();
		}
		if(masEmployee.getLastName()!=null){
			signedBy=signedBy+" "+masEmployee.getLastName();
		}
	}
}
List templateList= new ArrayList();
if(map.get("templateList") != null){
templateList=(List)map.get("templateList");
}
if(map.get("masRankList")!=null)
{
	masRankList1 = (List) map.get("masRankList");

}
List<MasMedicalExamInvestResult> masMedicalExamInvestResultList=null;
if(map.get("masMedicalExamInvestResultList")!=null)
{
	masMedicalExamInvestResultList = (List<MasMedicalExamInvestResult>) map.get("masMedicalExamInvestResultList");

}
List<MasMedicalExamFamilyHis> masMedicalExamFamilyHisList=new ArrayList<MasMedicalExamFamilyHis>();
if(map.get("masMedicalExamFamilyHisList")!=null)
{
	masMedicalExamFamilyHisList = (List<MasMedicalExamFamilyHis>) map.get("masMedicalExamFamilyHisList");

}
List visitlist = new ArrayList();

if(map.get("visit") != null){
	visitlist=(List)map.get("visit");

	}
Visit visit=null;
if(visitlist!=null &&visitlist.size()>0)
{
 visit=(Visit)visitlist.get(0);
 System.out.println("visit 3B Mo ==="+visit.getId());
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
if(medExamList.size() > 0){
	medExamObj = medExamList.get(0);
}
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
}
//Set<PatientInvestigationDetails> patientInvestigationdetails=null;
//PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
//if(map.get("patientInvestigationHeader")!=null){

	//patientInvestigationHeader=(PatientInvestigationHeader)map.get("patientInvestigationHeader");
	//patientInvestigationdetails=patientInvestigationHeader.getPatientInvestigationDetails();
//}
//List<PatientInvestigationDetails> patientInvestigationdetails=null;
//if(map.get("patientInvestigationDetailsList")!=null)
//{
	//patientInvestigationdetails=(List<PatientInvestigationDetails>)map.get("patientInvestigationDetailsList");
//}

Set<PatientInvestigationDetails> patientInvestigationdetails=null;
PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
if(map.get("patientInvestigationHeader")!=null){

	patientInvestigationHeader=(PatientInvestigationHeader)map.get("patientInvestigationHeader");
	patientInvestigationdetails=patientInvestigationHeader.getPatientInvestigationDetails();
}
DgOrderhd dgOrderhd=null;
//Set<DgOrderdt> getDgOrderdts=null;
if(map.get("dgOrderhd")!=null){

	dgOrderhd=(DgOrderhd)map.get("dgOrderhd");
	//getDgOrderdts=dgOrderhd.getDgOrderdts();

}
List<DgOrderdt> getDgOrderdts=null;
if(map.get("dgOrderdtList")!=null)
{
	getDgOrderdts=(List<DgOrderdt>)map.get("dgOrderdtList");
}
Properties properties = new Properties();
String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
if(map.get("resultList") != null){
	resultList=(List)map.get("resultList");
	}
String search=null;
if (map.get("search") != null) {
	search = (String) map.get("search");
   }
List<Category> categoryList= new ArrayList<Category>();
if(map.get("categoryList") != null){
	categoryList=(List)map.get("categoryList");
}
%>
function checkTemplateId(templateId){

    if(templateId=="0"){
      return true;
    }else{
      return true;
    }
  }
function checkFamilyOtherVal()
{

    var InvForm = document.forms.medicalBoardExaminationAnnual;
    var x = 0;
    for (x=0;x<=InvForm.fmdm.length;x++)
    {
       if (InvForm.fmdm[x].selected)
       {
        if(InvForm.fmdm[x]!=null)
        {
        if(document.getElementById("familyHistoryOther") && InvForm.fmdm[x].value==8)
        {
          document.getElementById("familyHistoryOther").style.display='inline';
        }
        }
       }
    }

}
function checkFamilyHistory()
{
  var selObj = document.getElementById('FamilyHistory');
  var i;
  for (i=0; i<selObj.options.length; i++)
  {
    if (selObj.options[i].selected)
    {
      if(document.getElementById("familyHistoryOther") && selObj.options[i].value==8)
      {
    	  document.getElementById("familyHistoryOther").style.display='inline';
       }
     }

   }
}
function checkForInvestigationMH(inc)
{
   if(document.getElementById('investigationReferToMH'+inc).checked==true)
   {
       document.getElementById('investigationReferToMH'+inc).value='y';
       document.getElementById('Result'+inc).readOnly=false;
       document.getElementById("uploadReport"+inc).style.display='inline';

   } else
   {
   	document.getElementById('investigationReferToMH'+inc).value='n';
   	 document.getElementById('Result'+inc).readOnly=true;
        document.getElementById("uploadReport"+inc).style.display='none';
   }
}
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
<div>
<input	name="investigationTemplate" type="button"	value="Previous Visits" tabindex="1" class="buttonBig2" onClick="openPopupPatientPreviousVisit();" />
<input	name="investigationTemplate" type="button"	value="Previous Medical Exams" tabindex="1" class="buttonBig2" onClick="getPrevMedExamFromHIC();"  />
<input	name="investigationTemplate" type="button"	value="Previous Medical Boards" tabindex="1" class="buttonBig2" onClick="getPrevMedBoardFromHIC();" />
<input	name="investigationTemplate" type="button"	value="Previous Hospitalizations" tabindex="1" class="buttonBig2" onClick="showPatientPreVisitHospitality();" />
</div>
<br/>
<br/>
<br/>
<div class="titleBg">
<%--<h2><%=jspheading %></h2> --%>
<h2>AFMSF-3B</h2>
</div>
<div class="clear"></div>
<body onload="coolDental();">
<form name="medicalBoardExaminationAnnual" action="" method="post">
<div class="Block">
	<label>Date of Exam2</label>
<%if(medExamObj.getId()==null)
{%>
	 <input tabindex="1" type="text"	name="<%=REPORTED_DATE %>"  maxlength="10"  class="auto"
		onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date %>"
		validate="Reported Date,date,no" />
<% }else{%>
	 <input tabindex="1" type="text"	name="<%=REPORTED_DATE %>"  maxlength="10" disabled="disabled"
		onKeyUp="mask(this.value,this,'2,5','/');" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateOfReporting()) %>"
		validate="Reported Date,date,no" />

<% }%>

<%if(session.getAttribute("hospitalName")!=null){ %>
<label >Place of Exam </label> <label class="valueAuto"><%=((String)session.getAttribute("hospitalName")) %></label>

<%}%>
<label class="medium">Authority</label>
 <% if(medExamObj.getAuthority()!=null){%>
<input tabindex="1" type="text"   id="" name="<%=AUTHORITY_OF_BOARD %>"maxlength="100" value="<%=medExamObj.getAuthority() %>" readonly="readonly"	onKeyUp="limitText(this,100);"  />

 <% }else{%>
<input tabindex="1" type="text"  class="" id="" name="<%=AUTHORITY_OF_BOARD %>" maxlength="100" readonly="readonly"	onKeyUp="limitText(this,100);" value="IAP4303(4th Ed)" />

 <% }%>
  </div>

<div class="clear paddingTop15"></div>
<%
int hin_id=0;
if(visit.getHin().getId()!= null)
{
	hin_id=visit.getHin().getId();
}
%>
<input type="hidden" name="hin_id" value="<%=hin_id %>"/>
<%
int medExamId = 0;
if(medExamObj.getId()!= null){

	medExamId = medExamObj.getId();
}
%>
<input type="hidden" name="medExamId" value="<%=medExamId %>"/>
<div class="Block">
<label>Service No. </label>
<% if(visit.getMedExamType()!=null){%>
 <input type="hidden"	value="<%= visit.getMedExamType() %>" name="medicalExamType" tabindex="2" maxlength="100" readonly="readonly"/>
<% }else{%>
 <input type="hidden"	value="Annual Medical Exam(AFMSF-3B)" name="medicalExamType" tabindex="2" maxlength="100"/>
<% }%>
 <input type="text"	 name="<%=SERVICE_NO %>" tabindex="2" value="<%=visit.getHin().getServiceNo()%>" readonly="readonly"/>
 <label>Rank  </label>
   <input type="text" value="<%= visit.getHin().getRank().getRankName() %>" name="<%=RANK%>"	tabindex="2" maxlength="100" readonly="readonly"/>
  <input type="hidden" value="<%= visit.getHin().getRank().getId() %>" name="<%=RANK_ID%>"	tabindex="2" maxlength="100" />

 <%
 String name =visit.getHin().getSFirstName();
 if(visit.getHin().getSMiddleName() != null){
	 name += " "+visit.getHin().getSMiddleName();
 }
 if(visit.getHin().getSLastName() != null){
	 name += " "+visit.getHin().getSLastName();
 }
 %>
 <label>Name  </label>
  <input readonly="readonly" type="text" value="<%= name %>" name="<%=FULL_NAME%>"	tabindex="2" maxlength="100" />

 <div class="clear"></div>

 <label>Unit/Ship  </label>
  <input	readonly="readonly" type="text" value="<%= visit.getHin().getUnit().getUnitName() %>" name="<%=UNIT%>"	tabindex="2" maxlength="100"/>
  <input type="hidden" value="<%= visit.getHin().getUnit().getId() %>" name="<%=UNIT_ID%>"	tabindex="2" maxlength="100"/>

 <label>Service  </label>
 <input	type="text" readonly="readonly" value="<%=  visit.getHin().getServiceType().getServiceTypeName() %>" name="serviceiaf"	tabindex="2" maxlength="100" />
  <input type="hidden" value="<%= visit.getHin().getServiceType().getId() %>" name="<%=SERVICE_TYPE_ID%>"	tabindex="2" maxlength="100" />
 <label>Branch/Trade  </label>
<% if(visit.getHin().getTrade()!=null){%>
 <input	type="text" readonly="readonly" name="<%=TRADE%>"	tabindex="2" maxlength="10" value="<%= visit.getHin().getTrade().getTradeName() %>"/>
  <input	type="hidden"  name="<%=TRADE_ID%>"	maxlength="10" tabindex="2" value="<%= visit.getHin().getTrade().getId() %>"/>

<% }else{%>
<input	type="text"  name="<%=TRADE%>"	tabindex="2" readonly="readonly"/>
 <% }%>
 <div class="clear"></div>

 <label>DOB</label>
 <% if(visit.getHin().getDateOfBirth()!=null){%>
  <input	tabindex="2" name="<%=DATE_OF_BIRTH %>" readonly="readonly"  value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getDateOfBirth()) %>"
	 maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" />

	<% }else{%>
<input	tabindex="2" name="<%=DATE_OF_BIRTH %>" readonly="readonly"  value=""
	 maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" />

	<% }%>

 <label>Age/Gender  </label>
 <%
     String ageAndGender=visit.getAge()+"/"+visit.getHin().getSex().getAdministrativeSexName();
 %>
 <input	type="text" value="<%= ageAndGender %>" name="apparentAge"	maxlength="50" tabindex="2" readonly="readonly"/>
<%if(visit.getAge()!= null){ %>
<input type="hidden" name="ageId" id="ageId" value="<%=visit.getAge() %>">
<%} %>
<%if(visit.getHin().getSex() != null){  %>
<input type="hidden" name="genderId" id="genderId" value="<%=visit.getHin().getSex().getId() %>">
<%} %>

 <label>Type of Commission</label>
<% if(medExamObj.getTypeofcommision()!= null){%>
<input	type="text"  tabindex="2" value="<%=medExamObj.getTypeofcommision()%>" name="typeOfCommunication"	maxlength="50"  id="typeOfCommunication"/>
<%}else{%>
 <select name="typeOfCommunication"	 tabindex=2>
	<option value="PC" selected="selected" >PC </option>
	<option value="SSC">SSC</option>
	<option value="NA">NA</option>
</select>

 <% }%>

 <div class="clear"></div>

 <label>DOE/DOC  </label>
  <%if(visit.getHin().getCommissionDate()!=null)
 { %>
 <input	tabindex="2" readonly="readonly" name="<%=DATE_COMMENCEMENT %>"   value="<%= HMSUtil.convertDateToStringWithoutTime(visit.getHin().getCommissionDate()) %>"	 validate="Entry Date,date,no" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" />
 <% }else{%>
 <input	tabindex="2" name="<%=DATE_COMMENCEMENT %>"  value="<%=date %>"	validate="Entry Date,date,no" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" />

 <% }%>

 <label>Total Service  </label>
  <%if(visit.getHin().getServiceYears()!=null)
 { %>
 <input	type="text" readonly="readonly" value="<%= visit.getHin().getServiceYears()+" "+visit.getHin().getTotalServicePeriod() %>" name="<%=TOTAL_SERVICE%>"	maxlength="100" tabindex="2" />
 <% }else{%>
 <input	type="text" value="" name="<%=TOTAL_SERVICE%>"	maxlength="100" tabindex="2" />
 <% }%>


 <label>Past Medical History  </label>

 <% if(medExamObj.getPastmedicalhistory()!=null){%>
 <textarea cols="20" rows="2" tabindex="2"  maxlength="99" name="<%=PAST_MEDICAL_HISTORY%>" 
 onkeyup="chkLength(this,99);" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)"><%=medExamObj.getPastmedicalhistory() %></textarea>

 <% }else{%>
 <textarea cols="20" rows="2" tabindex="2"   maxlength="99" name="<%=PAST_MEDICAL_HISTORY%>" 
 onkeyup="chkLength(this,99);" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)"></textarea>

 <% }%>


 <div class="clear"></div>

 <label>Present Med Cat  </label>
 	<select 	name="<%= PRESENT_MEDICAL_CATEGORY %>"	validate="Signed By,string,no" tabindex=2>
 	 	<option value="0">Select</option>
	<%
	if(visit.getHin().getCategory()!=null)
	{
			for (Category category : categoryList) {

					if(visit.getHin().getCategory().getCategoryid().equals(category.getCategoryid()))
						{
				%>
	<option value="<%=category.getCategoryid()%>" selected="selected" ><%=category.getCategories()%> </option>
	<%} }
				}else{
		for (Category category : categoryList) {

		%>
	<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
	<%
		}
				}	%>
</select>



 <label>Last AME </label>
 <label class="">Place</label>
  <% if(medExamObj.getLastame()!=null){%>
 <input	type="text" maxlength="100"  value="<%=medExamObj.getLastame() %>" name="<%=LAST_AME%>"	tabindex="2" />
 <% }else{%>
<input	type="text" maxlength="100"  value="" name="<%=LAST_AME%>"	tabindex="2" />
 <% }%>

  <div class="clear"></div>
 <div class="paddLeft483">
<label class=""> Date </label>
<%if(medExamObj.getDateMedicalBoardSubsequent()!=null &&(!medExamObj.getDateMedicalBoardSubsequent().equals("")))
 { %>
 <input	tabindex="2" name="<%=DATE_OF_AME %>" class="date"  value="<%= HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateMedicalBoardSubsequent()) %>"	validate="Entry Date,date,no" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" />
 <% }else{%>
 <input	tabindex="2" name="<%=DATE_OF_AME %>" class="date" value=""	validate="Entry Date,date,no" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" />
 <% }%>
 <img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" 	onclick="setdate('',medicalBoardExaminationAnnual.<%=DATE_OF_AME%>,event);" />
</div>
</div>

<div class="clear paddingTop15"></div>
<h4>Dental <a href="javascript:animatedcollapse.toggle('slide1')"></a></h4>
<div class="clear"></div>
<div id="slide1">
<div class="Block">
<div class="clear"></div>
<% if(medExamObj.getDentalValue()!=null){%>
<input type="hidden"  name="dentalValue" id="dentalValueId" value="<%=medExamObj.getDentalValue()%>"/>
<% }else{%>
<input type="hidden"  name="dentalValue" id="dentalValueId" value=""/>
<%} %>
<label >Total No. of Teeth</label>
  <% if(medExamObj.getTotalTeeth()!=null){%>

 <input tabindex="2"	type="text"   name="<%=TOTAL_NO_OF_TEETH %>" class="small" value="<%=medExamObj.getTotalTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" />

 <% }else{%>
<input tabindex="2"	type="text"  name="<%=TOTAL_NO_OF_TEETH %>" class="small"
	onKeyUp="isNumber(this)" maxlength="2" />

 <% }%>


<label class="medium3">Total No. of Defective Teeth</label>
 <% if(medExamObj.getTotalDefectiveTeeth()!=null){%>
<input tabindex="2"	type="text"   name="<%=DEFECTIVE_TEETH %>" class="small" value="<%=medExamObj.getTotalDefectiveTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" />


 <% }else{%>
<input tabindex="2"	type="text"  name="<%=DEFECTIVE_TEETH %>" class="small"
	onKeyUp="isNumber(this)" maxlength="2" />


 <% }%>
	<label class="medium3">Total No. of Dental Points</label>
	<% if(medExamObj.getDenstlPoint()!=null){%>
	<input	tabindex="2" type="text"  name="<%=DENTSL_POINT %>" value="<%=medExamObj.getDenstlPoint() %>"
	onKeyUp="isNumber(this);" maxlength="2" />


 <% }else{%>
	<input	tabindex="2" type="text"  name="<%=DENTSL_POINT %>"
	onKeyUp="isNumber(this);" maxlength="2" />


 <% }%>

	<div class="clear"></div>

<label >Missing </label>
	<% if(medExamObj.getMissingTeeth()!=null){%>
<input tabindex="2" type="text"
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);" value="<%=medExamObj.getMissingTeeth() %>"
	maxlength="2" />
 <% }else{%>
<input tabindex="2" type="text"
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);"
	maxlength="2" />
 <% }%>
<label class="medium3">Unsaveable</label>

<% if(medExamObj.getUnservisableTeeth()!=null){%>
<input	tabindex="2" type="text"   name="<%=MISSING_UNSERVICABLE_TEETH %>" value="<%=medExamObj.getUnservisableTeeth() %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }else{%>
<input	tabindex="2" type="text"  name="<%=MISSING_UNSERVICABLE_TEETH %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }%>
 <label class="medium3">Condition of Gums</label>
<% if(medExamObj.getConditionOfGums()!=null){%>
<input	tabindex="2" type="text"  name="<%=CONDITION_OF_GUMS %>" value="<%=medExamObj.getConditionOfGums() %>"
	class="" onchange="return CheckAlpha(event);"  id="txtAlpha" maxlength="10" validate="Condition Of Gums,Alphabetic,Yes" />


 <% }else{%>
<input	tabindex="2" type="text"  name="<%=CONDITION_OF_GUMS %>"
	class="" onchange="return CheckAlpha(event);" id="txtAlpha" maxlength="10" validate="Condition Of Gums,Alphabetic,Yes"/>

 <% }%>
<div class="clear"></div>


<h4>Missing Teeth</h4>
<div class="clear"></div>
<label >UR</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_8%>" value="" class="radioAuto" id="d1" onclick="chkValue(this);"  />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_7%>" value="" class="radioAuto" id="d2" onclick="chkValue(this);" />
	<label class="smallAuto">7</label>
<input tabindex="1" type="checkbox"
	name="<%=MUR_6%>" value="" class="radioAuto" id="d3" onclick="chkValue(this);" />
<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox"
	name="<%=MUR_5%>" value="" class="radioAuto" id="d4" onclick="chkValue(this);" />
<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_4%>" value="" class="radioAuto" id="d5"  onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_3%>" value="" class="radioAuto" id="d6"  onclick="chkValue(this);" />
<label class="smallAuto">3</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_2%>" value="" class="radioAuto" id="d7" onclick="chkValue(this);" />
<label class="smallAuto">2</label>

<input tabindex="1" type="checkbox"
	name="<%=MUR_1%>" value="" class="radioAuto" id="d8"  onclick="chkValue(this);" />
<label class="smallAuto">1</label>

<div class="clear"></div>
<label>UL</label>
<input tabindex="1" type="checkbox"
	name="<%=MUL_8%>" value="" class="radioAuto" id="d9" onclick="chkValue(this);" />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox"
	name="<%=MUL_7%>" value="" class="radioAuto" id="d10" onclick="chkValue(this);" />
	<label class="smallAuto">7</label>

<input tabindex="1" type="checkbox"
	name="<%=MUL_6%>" value="" class="radioAuto" id="d11" onclick="chkValue(this);" />
	<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox"
	name="<%=MUL_5%>" value="" class="radioAuto" id="d12" onclick="chkValue(this);" />
	<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox"
	name="<%=MUL_4%>" value="" class="radioAuto" id="d13" onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox"
	name="<%=MUL_3%>" value="" class="radioAuto" id="d14" onclick="chkValue(this);" />
	<label class="smallAuto">3</label>
<input tabindex="1" type="checkbox"
	name="<%=MUL_2%>" value="" class="radioAuto" id="d15" onclick="chkValue(this);" />
	<label class="smallAuto">2</label>
<input tabindex="1" type="checkbox"
	name="<%=MUL_1%>" value="" class="radioAuto" id="d16" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>


<div class="clear"></div>
<label >LR</label>
<input tabindex="1" type="checkbox"
	name="<%=MLR_8%>" value="" class="radioAuto" id="d17"  onclick="chkValue(this);" />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox"
	name="<%=MLR_7%>" value="" class="radioAuto" id="d18"  onclick="chkValue(this);" />
	<label class="smallAuto">7</label>

<input tabindex="1" type="checkbox"
	name="<%=MLR_6%>" value="" class="radioAuto" id="d19" onclick="chkValue(this);" />
	<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox"
	name="<%=MLR_5%>" value="" class="radioAuto" id="d20" onclick="chkValue(this);" />
	<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox"
	name="<%=MLR_4%>" value="" class="radioAuto" id="d21" onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox"
	name="<%=MLR_3%>" value="" class="radioAuto" id="d22" onclick="chkValue(this);" />
	<label class="smallAuto">3</label>
<input tabindex="1" type="checkbox"
	name="<%=MLR_2%>" value="" class="radioAuto" id="d23" onclick="chkValue(this);" />
	<label class="smallAuto">2</label>
<input tabindex="1" type="checkbox"
	name="<%=MLR_1%>" value="" class="radioAuto" id="d24" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>

<div class="clear"></div>
<label class=>LL</label>
<input tabindex="1" type="checkbox"
	name="<%=MLL_8%>" value="" class="radioAuto" id="d25" onclick="chkValue(this);" />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox"
	name="<%=MLL_7%>" value="" class="radioAuto" id="d26" onclick="chkValue(this);" />
	<label class="smallAuto">7</label>

<input tabindex="1" type="checkbox"
	name="<%=MLL_6%>" value="" class="radioAuto" id="d27" onclick="chkValue(this);" />
	<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox"
	name="<%=MLL_5%>" value="" class="radioAuto" id="d28" onclick="chkValue(this);" />
	<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox"
	name="<%=MLL_4%>" value="" class="radioAuto" id="d29" onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox"
	name="<%=MLL_3%>" value="" class="radioAuto" id="d30" onclick="chkValue(this);" />
	<label class="smallAuto">3</label>
<input tabindex="1" type="checkbox"
	name="<%=MLL_2%>" value="" class="radioAuto" id="d31" onclick="chkValue(this);" />
	<label class="smallAuto">2</label>
<input tabindex="1" type="checkbox"
	name="<%=MLL_1%>" value="" class="radioAuto" id="d32" onclick="chkValue(this);" />
	<label class="smallAuto">1</label> <div class="clear"></div>


<h4>Unsaveable Teeth</h4>
<div class="clear"></div>
<label >UR</label>
<input tabindex="1" type="checkbox"
	name="<%=UUR_8%>" value="" class="radioAuto" id="d33" onclick="chkValue(this);" />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox"
	name="<%=UUR_7%>" value="" class="radioAuto" id="d34" onclick="chkValue(this);" />
	<label class="smallAuto">7</label>

<input tabindex="1" type="checkbox"
	name="<%=UUR_6%>" value="" class="radioAuto" id="d35" onclick="chkValue(this);" />
	<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox"
	name="<%=UUR_5%>" value="" class="radioAuto" id="d36" onclick="chkValue(this);" />
	<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox"
	name="<%=UUR_4%>" value="" class="radioAuto" id="d37" onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox"
	name="<%=UUR_3%>" value="" class="radioAuto" id="d38" onclick="chkValue(this);" />
	<label class="smallAuto">3</label>
<input tabindex="1" type="checkbox"
	name="<%=UUR_2%>" value="" class="radioAuto" id="d39" onclick="chkValue(this);" />
	<label class="smallAuto">2</label>
<input tabindex="1" type="checkbox"
	name="<%=UUR_1%>" value="" class="radioAuto" id="d40" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>
	<div class="clear"></div>


<div class="clear"></div>
<label >UL</label>
<input tabindex="1" type="checkbox"
	name="<%=UUL_8%>" value="" class="radioAuto" id="d41" onclick="chkValue(this);" />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox"
	name="<%=UUL_7%>" value="" class="radioAuto" id="d42" onclick="chkValue(this);" />
	<label class="smallAuto">7</label>

<input tabindex="1" type="checkbox"
	name="<%=UUL_6%>" value="" class="radioAuto" id="d43" onclick="chkValue(this);" />
	<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox"
	name="<%=UUL_5%>" value="" class="radioAuto" id="d44" onclick="chkValue(this);" />
	<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox"
	name="<%=UUL_4%>" value="" class="radioAuto" id="d45" onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox"
	name="<%=UUL_3%>" value="" class="radioAuto" id="d46" onclick="chkValue(this);" />
	<label class="smallAuto">3</label>
<input tabindex="1" type="checkbox"
	name="<%=UUL_2%>" value="" class="radioAuto" id="d47" onclick="chkValue(this);" />
	<label class="smallAuto">2</label>
<input tabindex="1" type="checkbox"
	name="<%=UUL_1%>" value="" class="radioAuto" id="d48" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>


<div class="clear"></div>
<label >LR</label>
<input tabindex="1" type="checkbox"
	name="<%=ULR_8%>" value="" class="radioAuto" id="d49" onclick="chkValue(this);" />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox"
	name="<%=ULR_7%>" value="" class="radioAuto" id="d50" onclick="chkValue(this);" />
	<label class="smallAuto">7</label>

<input tabindex="1" type="checkbox"
	name="<%=ULR_6%>" value="" class="radioAuto" id="d51" onclick="chkValue(this);" />
	<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox"
	name="<%=ULR_5%>" value="" class="radioAuto" id="d52" onclick="chkValue(this);" />
	<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox"
	name="<%=ULR_4%>" value="" class="radioAuto" id="d53" onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox"
	name="<%=ULR_3%>" value="" class="radioAuto" id="d54" onclick="chkValue(this);" />
	<label class="smallAuto">3</label>
<input tabindex="1" type="checkbox"
	name="<%=ULR_2%>" value="" class="radioAuto" id="d55" onclick="chkValue(this);" />
	<label class="smallAuto">2</label>
<input tabindex="1" type="checkbox"
	name="<%=ULR_1%>" value="" class="radioAuto" id="d56" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>

<div class="clear"></div>
<label >LL</label>
<input tabindex="1" type="checkbox"
	name="<%=ULL_8%>" value="" class="radioAuto" id="d57" onclick="chkValue(this);" />
	<label class="smallAuto">8</label>

<input tabindex="1" type="checkbox"
	name="<%=ULL_7%>" value="" class="radioAuto" id="d58" onclick="chkValue(this);" />
	<label class="smallAuto">7</label>

<input tabindex="1" type="checkbox"
	name="<%=ULL_6%>" value="" class="radioAuto" id="d59" onclick="chkValue(this);" />
	<label class="smallAuto">6</label>
<input tabindex="1" type="checkbox"
	name="<%=ULL_5%>" value="" class="radioAuto" id="d60" onclick="chkValue(this);" />
	<label class="smallAuto">5</label>

<input tabindex="1" type="checkbox"
	name="<%=ULL_4%>" value="" class="radioAuto" id="d61" onclick="chkValue(this);" />
	<label class="smallAuto">4</label>

<input tabindex="1" type="checkbox"
	name="<%=ULL_3%>" value="" class="radioAuto" id="d62" onclick="chkValue(this);" />
	<label class="smallAuto">3</label>
<input tabindex="1" type="checkbox"
	name="<%=ULL_2%>" value="" class="radioAuto" id="d63" onclick="chkValue(this);" />
	<label class="smallAuto">2</label>
<input tabindex="1" type="checkbox"
	name="<%=ULL_1%>" value="" class="radioAuto" id="d64" onclick="chkValue(this);" />
	<label class="smallAuto">1</label>
<div class="clear"></div>
	<label>Dental Officer </label> 

 <input type="text" 	value="<% if(medExamObj.getDentalOfficer()!=null) {out.print(medExamObj.getDentalOfficer());} %>"	name="DentalOfficer" maxlength="200" tabindex="2"  validate="DentalOfficer,string,yes" />
 
	<label>Dental Checkup Date</label> <%if(medExamObj.getDentalCheckupDate()==null)
{%> <input tabindex="1" type="text" name="<%=DENTAL_CHECKUP_DATE %>"
	class="calDate" maxlength="10" class="auto"
	onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date %>"
	validate="Dental Checkup Date,date,no" /> <% }else{%> <input tabindex="1"
	type="text" name="<%=DENTAL_CHECKUP_DATE %>" class="calDate" maxlength="10"
	disabled="disabled" onKeyUp="mask(this.value,this,'2,5','/');"
	value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDentalCheckupDate()) %>"
	validate="Dental Checkup Date,date,no" /> <% }%> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalBoardExaminationAnnual.<%=DENTAL_CHECKUP_DATE%>,event);" />
<div class="clear"></div>

<label > Remarks</label>
 <%
if(medExamObj.getRemarksTeath()!=null){%>
 <textarea rows="" cols="60" tabindex="2"	name="<%=DENTAL_REMARKS %>" class="auto" maxlength="299" 
 onkeyup="chkLength(this,299);" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" value="<%=medExamObj.getRemarksTeath() %>"><%=medExamObj.getRemarksTeath() %></textarea>
 <% }else{%>
 <textarea rows="" cols="60" tabindex="2" maxlength="299"	name="<%=DENTAL_REMARKS %>" class="auto" 
 onkeyup="chkLength(this,299);" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)" onKeyDown="return checkMaxLength(this)"></textarea>
 <% }%>
<label class="auto"> Refer to MH</label>
<%	if(medExamObj.getReferToMH()!=null && medExamObj.getReferToMH().equalsIgnoreCase("yes")){%>

<input tabindex="1" type="checkbox" disabled="disabled" value="no" checked="checked" class="radioAuto"
			name="dentalReferToMH2" onclick="checkForDentalMH();"/>
<input tabindex="1" type="hidden" name="dentalReferToMH" value="yes"  id="dentalReferToMH" /><%}else{ %>
<input tabindex="1" type="checkbox" name="dentalReferToMH" value="no" class="radioAuto"
	  		id="dentalReferToMH"  onclick="checkForDentalMH();"/><%} %>
</div>
</div>
<div class="clear paddingTop15"></div>
<h4> PHYSICAL CAPACITY <a href="javascript:animatedcollapse.toggle('slide2')"></a></h4>
<div class="clear"></div>
<div id="slide2">
<div class="Block">
<label >Height</label>
<% if(medExamObj.getHeight()!=null){%>
<input tabindex="2" type="text" id="height" class="auto" size="10"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)" value="<%=medExamObj.getHeight() %>"
maxlength="5" onblur="calculateIdealWeight();checkForWiegth(this.value,id);calculateBMI();" /><label class="unit">cm</label>
 <% }else{%>
<input tabindex="2" type="text"  id="height"	class="auto" size="10"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)"
maxlength="5" onblur="calculateIdealWeight();checkForWiegth(this.value,id);calculateBMI();" /><label class="unit">cm</label>
 <% }%>

<label	>Weight</label>
  <% if(medExamObj.getActualweight()!=null){%>
<input tabindex="2" type="text"   id="weight" class="auto" size="10"	name="<%=ACTUAL_WEIGHT %>" maxlength="5" value="<%=medExamObj.getActualweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();calculateOverWeight();" /><label class="unit">kg</label>

 <% }else{%>
<input tabindex="2" type="text"  id="weight" class="auto" size="10"	name="<%=ACTUAL_WEIGHT %>" maxlength="5"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();calculateOverWeight();" /><label class="unit">kg</label>

 <% }%>

<label>SD</label>
	<%
	if(medExamObj.getSD()!=null){
	%>
<input type="text" value="<%=medExamObj.getSD() %>" tabindex="1" name="sd" id="sd" readonly="readonly" class="auto" size="10"/>
<%}else{ %>
<input type="text" value="" tabindex="1" name="sd" id="sd" readonly="readonly" class="auto" size="10"/>

<%} %>
<input type="hidden" value="" name="sdVal" id="sdVal"/>

<div class="clear"></div>
<label	>Ideal Weight</label>
  <% if(medExamObj.getIdealweight()!=null){%>
<input tabindex="1" type="text" readonly="readonly"  id="idealWeightId" name="<%=IDEAL_WEIGHT %>" class="auto" size="10"	maxlength="5" value="<%=medExamObj.getIdealweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateOverWeight();" /><label class="unit">kg</label>

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly"  id="idealWeightId" name="<%=IDEAL_WEIGHT %>" class="auto" size="10"	maxlength="5"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateOverWeight();" /><label class="unit">kg</label>

 <% }%>


<label	>Over Weight</label>
  <% if(medExamObj.getOverweight()!=null){%>
<input tabindex="1" type="text"  readonly="readonly" id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>" class="auto" size="10"	maxlength="5" value="<%=medExamObj.getOverweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="unit">%</label>

 <% }else{%>
<input tabindex="1" type="text"  readonly="readonly" id="<%=OVER_WEIGHT %>" name="<%=OVER_WEIGHT %>"  class="auto" size="10"	maxlength="5"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="unit">%</label>

 <% }%>


<label	>BMI</label>
  <% if(medExamObj.getBhi()!=null){%>
<input tabindex="1" type="text"  id="bmi" name="<%=BHI %>" maxlength="5" value="<%=medExamObj.getBhi() %>"
	onKeyUp="limitText(this,6);" class="auto" size="10" readonly="readonly" /><label class="unit">Kg/m<sup>2</sup></label>

 <% }else{%>
<input tabindex="1" type="text"  id="bmi" name="<%=BHI %>" maxlength="5"
	onKeyUp="limitText(this,6);"  class="auto" size="10" readonly="readonly" /><label class="unit">Kg/m<sup>2</sup></label>

 <% }%>

<div class="clear"></div>
<label	>Body Fat</label>
  <% if(medExamObj.getBodyfat()!=null){%>
<input tabindex="2" type="text"  id="<%=BODY_FAT %>" name="<%=BODY_FAT %>"maxlength="10" value="<%=medExamObj.getBodyfat() %>"
	onKeyUp="limitText(this,10);" class="auto" size="10" />

 <% }else{%>
<input tabindex="2" type="text"  id="<%=BODY_FAT %>" name="<%=BODY_FAT %>" maxlength="10"
	onKeyUp="limitText(this,10);" class="auto" size="10" />

 <% }%>
 <input type="text" class="transparent" size="6">
<label	>Waist</label>
  <% if(medExamObj.getWaist()!=null){%>
<input tabindex="2" type="text"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="5" value="<%=medExamObj.getWaist() %>"
	onKeyUp="limitText(this,6);" onblur="calculateWHR();" class="auto" size="10" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="2" type="text"  id="<%=WAIST %>" name="<%=WAIST %>" maxlength="5"
	onKeyUp="limitText(this,6);" onblur="calculateWHR();" class="auto" size="10" /><label class="unit">cm</label>

 <% }%>
<label	>Hip</label>
  <% if(medExamObj.getHips()!=null){%>
<input tabindex="2" type="text" maxlength="99"  id="hips" name="Hips" value="<%=medExamObj.getHips() %>"
	onKeyUp="limitText(this,100);" onblur="calculateWHR();" class="auto" size="10" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="2" type="text" maxlength="99"  id="hips" name="Hips"
	onKeyUp="limitText(this,100);" onblur="calculateWHR();" class="auto" size="10"  /><label class="unit">cm</label>

 <% }%>
<div class="clear"></div>
<label	>WHR</label>
  <% if(medExamObj.getWhr()!=null){%>
<input tabindex="1" readonly="readonly" type="text" maxlength="20"  id="WHR" name="WHR" maxlength="6" value="<%=medExamObj.getWhr() %>"
	onKeyUp="limitText(this,6);" class="auto" size="10" />

 <% }else{%>
<input tabindex="1" type="text" maxlength="20"  id="WHR" name="WHR" maxlength="6" readonly="readonly"
	onKeyUp="limitText(this,6);" class="auto" size="10"  />

 <% }%>
<input type="text" class="transparent" size="6">
<label	>Skin Fold Thickness</label>
  <% if(medExamObj.getSignfoldthickness()!=null){%>
<input tabindex="2" type="text"  id="<%=THICKNESS %>" name="<%=THICKNESS %>" maxlength="99" value="<%=medExamObj.getSignfoldthickness() %>"
	onKeyUp="limitText(this,6);" class="auto" size="10"  /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="2" type="text"   id="<%=THICKNESS %>" name="<%=THICKNESS %>" maxlength="99"
	onKeyUp="limitText(this,6);" class="auto" size="10" /><label class="unit">cm</label>

 <% }%>
<label	>Chest Full Expansion</label>
  <% if(medExamObj.getChestfullexpansion()!=null){%>
<input tabindex="2" type="text"   id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>"  maxlength="99" value="<%=medExamObj.getChestfullexpansion() %>"
	onKeyUp="limitText(this,6);" class="auto" size="10" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="2" type="text"  id="<%=CHEST_FULL %>" name="<%=CHEST_FULL %>" maxlength="99"
	onKeyUp="limitText(this,6);" class="auto" size="10"  /><label class="unit">cm</label>

 <% }%>

 <div class="clear"></div>
<label>Range of Expansion</label>
  <% if(medExamObj.getRangeofexpansion()!=null){%>
<input tabindex="2" type="text"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="99" value="<%=medExamObj.getRangeofexpansion() %>"
	onKeyUp="limitText(this,6);" class="auto" size="10" /><label class="unit">cm</label>

 <% }else{%>
<input tabindex="2" type="text"  id="<%=RANGE_EXPANSION %>" name="<%=RANGE_EXPANSION %>" maxlength="99"
	onKeyUp="limitText(this,6);" class="auto" size="10"  /><label class="unit">cm</label>

 <% }%>



<label>Sportsman</label>

<!-- Commented By Ritu as per testing at 412 AFS  Date: 22 June 2011-->


 <%-- <% if(medExamObj.getSportman()!=null){%>
<input tabindex="1" type="text"   id="<%=SPORTS %>" name="<%=SPORTS %>" maxlength="5" value="<%=medExamObj.getSportman() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />
 <% }else{%>
<input tabindex="1" type="text"  id="<%=SPORTS %>" name="<%=SPORTS %>"  maxlength="5"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }%>  --%>

 <select name="<%=SPORTS %>"  id="<%=SPORTS %>" tabindex="2" class="smaller" validate="Sports Man,stirng,no">
<option value="No">No</option>
<option value="Yes">Yes</option>

</select>
<script type="text/javascript">
<% if(medExamObj.getSportman()!=null){%>
document.getElementById('sport').value = '<%=medExamObj.getSportman()%>'
<%}%>
</script>


</div>
</div>

<div class="clear paddingTop15"></div>


<h4>Vision  <a href="javascript:animatedcollapse.toggle('slide3')"></a></h4>
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

  <% if(medExamObj.getWthoutGlassesRDistant()!=null){%>
 <input tabindex="2" type="text"  name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="5" value="<%=medExamObj.getWthoutGlassesRDistant()%>"/>
 <% }else{%>
<input tabindex="2" type="text"	name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="5" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithoutGlassesLDistant()!=null){%>
 <input tabindex="2" type="text"  	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="5" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="2" type="text"   	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="5" />
 <% }%>
 </td>

		<td>Without Glasses</td>
			<td width="10%">

  <% if(medExamObj.getWithoutGlassesRNearvision()!=null){%>
 <input tabindex="2" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="5" value="<%=medExamObj.getWithoutGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="2" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="5" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithoutGlassesLNearvision()!=null){%>
 <input tabindex="2" type="text" 	name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="5" value="<%=medExamObj.getWithoutGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="2" type="text" name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="5" />
 <% }%>
 </td>

 	<td width="10%" rowspan="2">

  <% if(medExamObj.getNearVisionWithoutGlassCp()!=null){%>
 <input tabindex="2" type="text"  name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="5" value="<%=medExamObj.getNearVisionWithoutGlassCp()%>"/>
 <% }else{%>
<input tabindex="2" type="text" name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="5" />
 <% }%>
 </td>

	</tr>
	<tr>
		<td>With Glasses</td>
		<td width="10%">

  <% if(medExamObj.getWithGlassesRDistant()!=null){%>
 <input tabindex="2" type="text" name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="5" value="<%=medExamObj.getWithGlassesRDistant()%>"/>
 <% }else{%>
<input tabindex="2" type="text"	name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="5" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithGlassesLDistant()!=null){%>
 <input tabindex="2" type="text" 	name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="5" value="<%=medExamObj.getWithGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="2" type="text" 	name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="5" />
 <% }%>
 </td>

		<td>With Glasses</td>
			<td width="10%">

  <% if(medExamObj.getWithGlassesRNearvision()!=null){%>
 <input tabindex="2" type="text" name="<%=WITH_GLASSES_NEAR_R %>" maxlength="5" value="<%=medExamObj.getWithGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="2" type="text" 	name="<%=WITH_GLASSES_NEAR_R %>" maxlength="5" />
 <% }%>
 </td>
 	<td width="10%">

  <% if(medExamObj.getWithGlassesLNearvision()!=null){%>
 <input tabindex="2" type="text"	name="<%=WITH_GLASSES_NEAR_L %>" maxlength="5" value="<%=medExamObj.getWithGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="2" type="text" name="<%=WITH_GLASSES_NEAR_L %>" maxlength="5" />
 <% }%>
 </td>

 	<%-- <td width="10%">

  <% if(medExamObj.getNearVisionWithGlassCp()!=null){%>
 <input tabindex="2" type="text"  name="<%=WITH_GLASSES_NEAR_CP %>" maxlength="5" value="<%=medExamObj.getNearVisionWithGlassCp()%>"/>
 <% }else{%>
<input tabindex="2" type="text" name="<%=WITH_GLASSES_NEAR_CP %>" maxlength="5" />
 <% }%>
 </td>	--%>

	</tr>

</table>

	</div>

<div class="clear paddingTop15"></div>

<h4> Hearing <a	href="javascript:animatedcollapse.toggle('slide2')"></a></h4>
<div class="clear"></div>
<div id="slide2">

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
<input tabindex="2" class="auto" size="10" type="text" maxlength="5"  id="hrfw" name="<%=HEARING_R_F_W %>" value="<%=medExamObj.getEarHearingRfw()   %>" onkeyup="isNumber1(this)"  onblur="checkForWiegth(this.value,id);" />
	<%}else{ %>
	<input tabindex="2" value="600" class="auto" size="10" type="text" maxlength="5"  id="hrfw" name="<%=HEARING_R_F_W %>" onkeyup="isNumber1(this)"	onblur="checkForWiegth(this.value,id);" />

	<%} %>
	cm
	</td>
<td>
<% if(medExamObj.getEarHearingLfw() != null){ %>
<input tabindex="2" class="auto" size="10" type="text" maxlength="5"  id="hlfw" value="<%=medExamObj.getEarHearingLfw()  %>" name="<%=HEARING_L_F_W%>" onkeyup="isNumber1(this)" onblur="checkForWiegth(this.value,id);" />
	<%}else{ %>
	<input tabindex="2" value="600"  class="auto" size="10" type="text" maxlength="5"  id="hlfw" name="<%=HEARING_L_F_W %>" onkeyup="isNumber1(this)" onblur="checkForWiegth(this.value,id);" />

	<%} %>
	cm
	</td>
	<td>
	<% if(medExamObj.getEarHearingBothFw() != null){ %>
	<input tabindex="2" class="auto" size="10" type="text" maxlength="10"  id="bothfw"	name="<%=HEARING_BOTH_FW %>" value="<%= medExamObj.getEarHearingBothFw() %>" onkeyup="isNumber1(this)"  onblur="checkForWiegth(this.value,id);" />
<%}else{ %>
		<input tabindex="2" value="600"  class="auto" size="10" type="text" maxlength="10"  id="bothfw"	name="<%=HEARING_BOTH_FW %>" onkeyup="isNumber1(this)"  onblur="checkForWiegth(this.value,id);" />

	<%} %>
	cm
	</td>
</tr>
<tr>

<th>CV</th>
<td>
<% if(medExamObj.getHearingRcv() != null){ %>
 <input tabindex="2" type="text" class="auto" size="10" maxlength="10"  id="hrcv" name="<%=HEARING_R_C_V %>" value="<%= medExamObj.getHearingRcv() %>" onkeyup="isNumber1(this)" onblur="checkForWiegth(this.value,id);" />
<%}else{ %>
	 <input tabindex="2" value="600"  type="text" class="auto" size="10" maxlength="10"  id="hrcv" name="<%=HEARING_R_C_V %>" onkeyup="isNumber1(this)" onblur="checkForWiegth(this.value,id);" />
	<%} %>cm
	</td>

<td>

	 <% if(medExamObj.getHearingLcv() != null){ %>
	  <input tabindex="2" type="text" class="auto" size="10" maxlength="10"  id="hlcv" name="<%=HEARING_L_C_V %>" value="<%= medExamObj.getHearingLcv() %>" onkeyup="isNumber1(this)" maxlength="5" onblur="checkForWiegth(this.value,id);" />
	  <%}else{ %>
	    <input tabindex="2" type="text" value="600"  class="auto" size="10" maxlength="10"  id="hlcv" name="<%=HEARING_L_C_V %>" onkeyup="isNumber1(this)" maxlength="5" onblur="checkForWiegth(this.value,id);" />
	  <%} %>
	  cm
	  </td>
	  <td>

	  	 <% if(medExamObj.getHearingBothCv() != null){ %>
	  <input tabindex="2" type="text" class="auto" size="10" maxlength="10"  id="bothcv" name="<%=HEARING_BOTH_CV %>" value="<%= medExamObj.getHearingBothCv()  %>" onkeyup="isNumber1(this)" maxlength="5" onblur="checkForWiegth(this.value,id);" />
<%}else{ %>
 <input tabindex="2" type="text" value="600"  class="auto" size="10" maxlength="10"  id="bothcv" name="<%=HEARING_BOTH_CV %>" onkeyup="isNumber1(this)" maxlength="5" onblur="checkForWiegth(this.value,id);" />
<%} %>
cm
</td>
</tr>
<tr>
<th >TM</th>

<td >
<select name="<%=TYMPANIC_R %>" class="small2" size="0" tabindex="2" id="tympanic_r">
<option value="Intact">Intact</option>
<option value="No">Not Intact</option>
<%--
<%if(medExamObj.getTympanicR().equalsIgnoreCase("Intact")){ %>
<option value="Intact" selected="selected">Intact</option>
	<option value="Not Intact">Not Intact</option>
<%}else if(medExamObj.getTympanicR().equalsIgnoreCase("Not Intact")){ %>
<option value="Intact">Intact</option>
<option value="Not Intact" selected="selected">Not Intact</option>
<%}else{ %>
<option value="Intact">Intact</option>
<option value="Not Intact">Not Intact</option>
<%} %> --%>
</select>
</td>
<script>
<%
if(medExamObj.getTympanicR()!= null){
%>
document.getElementById("tympanic_r").value='<%=medExamObj.getTympanicR()%>';

<%}%>
</script> 
<td colspan="2">
<select name="<%=TYMPANIC_L %>" class="small2" size="0" tabindex="2" id="tympanic_l">
<option value="Intact">Intact</option>
<option value="No">Not Intact</option>
<%--
<%if(medExamObj.getTympanicL().equalsIgnoreCase("Intact")){ %>
<option value="Intact" selected="selected">Intact</option>
	<option value="Not Intact">Not Intact</option>
<%}else if(medExamObj.getTympanicL().equalsIgnoreCase("Not Intact")){ %>
<option value="Intact">Intact</option>
<option value="Not Intact" selected="selected">Not Intact</option>
<%}else{ %>
<option value="Intact">Intact</option>
<option value="Not Intact">Not Intact</option>
<%} %> --%>
</select>
</td>
<script>
<%
if(medExamObj.getTympanicL()!= null){
%>
document.getElementById("tympanic_l").value='<%=medExamObj.getTympanicL()%>';

<%}%>
</script> 
</tr>
<tr>
 <th>Mobility</th>

<td >
	  	 <% if(medExamObj.getMobilityR() != null){ %>
	  <input tabindex="2" type="text" class="auto" size="10" name="<%=MOBILITYR %>" maxlength="20"  value="<%= medExamObj.getMobilityR()  %>"  />


<%}else{ %>
 <input tabindex="2" type="text"  value="Normal"  class="auto" size="10" name="<%=MOBILITYR %>"  maxlength="20"  />


<%} %>
</td>

 <td colspan="2">
	  	 <% if(medExamObj.getMobilityL() != null){ %>
	  <input tabindex="2" type="text" class="auto" size="10" name="<%=MOBILITYL %>" maxlength="20"  value="<%= medExamObj.getMobilityL()  %>"  />
<%}else{ %>
 <input tabindex="2" type="text" value="Normal"  class="auto" size="10" name="<%=MOBILITYL %>"  maxlength="20"  />
<%} %>

</td>
</tr>
</table>
<div class="clear"></div>
<div class="Block">

<label>Nose, Throat &amp; Sinuses</label>
	  	 <% if(medExamObj.getNosethroat() != null){ %>
	  <input tabindex="2" type="text" class="auto" size="21" maxlength="20"  id="bothcv" name="<%=NOSE_THROAT %>" value="<%= medExamObj.getNosethroat()  %>"  />

<%}else{ %>
 <input tabindex="2" type="text" class="auto" size="21"  id="bothcv" name="<%=NOSE_THROAT %>"  maxlength="20" value="NAD" />

<%} %>

<label>Audiometry Record</label>
	  	 <% if(medExamObj.getAudiometryRecord() != null){ %>
	  <input tabindex="2" type="text" class="auto" size="19" maxlength="20"  id="bothcv" name="<%=AUDIOMETRY_RECORD %>" value="<%= medExamObj.getAudiometryRecord()  %>" validate="Audiometry Record,Alphabetic,Yes" />
<%}else{ %>
 <input tabindex="2" type="text" class="auto" size="19"  id="bothcv" name="<%=AUDIOMETRY_RECORD %>"  maxlength="20" validate="Audiometry Record,Alphabetic,Yes" />
<%} %>
<!--<input tabindex="1" name="Button"	type="button" class="button" value="UPLOAD"	onClick="submitForm('medicalBoardExaminationAnnual','medicalExam?method=displayFileUpload');" />
-->
<input name="Send" type="button"  class="button" value="UPLOAD/VIEW" onClick="javascript:FileUploadWindow();" />

</div>
</div>
<%	int count=1;
    if(getDgOrderdts!=null)
    {
	for(DgOrderdt dgOrderdt : getDgOrderdts){
%>
	<input type="hidden" value="<%=dgOrderdt.getId()%>"  name="dgOrderdtId<%=count%>" id="dgOrderdtId<%=count%>" />

<%count++;}
    }
%>
<!-- fayaz added -->
<% if(medExamObj.getVisit() !=null){%>
<INPUT type=hidden value="<%=medExamObj.getVisit().getHin().getHinNo()%>" name="hinNoForreport" id="hinNoForreport"/>
<% }%>
<input type="hidden" value="" name="deleatedValue" id="deleatedValue" />
<input type="hidden" value="" name="deleatedorderid" id="deleatedorderid" />
<div class="clear paddingTop15"></div>
<h4>Investigations <a href="javascript:animatedcollapse.toggle('slide5')"></a></h4>
<div id="slide5">
<%-- <div class="Block">
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
	--%>
	<div class="clear paddingTop15"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid">
<tr>
	<th scope="col">Investigation</th>
	<th scope="col">Refer to MH</th>
	<th scope="col">Result</th>
	<th scope="col">File Upload</th>
	<th scope="col">Add</th>
    <th scope="col">Delete</th>
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
if(dgOrderhd!=null)
{
%>
<input type="hidden" value="<%=dgOrderhd.getId() %>" name="dgOrderhdId" id="dgOrderhdId" />
<input type="hidden" value="<%=dgOrderhd.getOrderNo() %>" name="dgOrderhdOrderNo" id="dgOrderhdOrderNo" />
<%
}else{ %>
<input type="hidden"  name="dgOrderhdId" id="dgOrderhdId" />
<input type="hidden" value="" name="dgOrderhdOrderNo" id="dgOrderhdOrderNo" />
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
		    	int cnt=0;
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
		    	/**
		    	* For getting ordered sub investigations
		    	* Added by Ritu 
		    	*/
		    	Set<DgResultEntryDetail> linkedHashSet = DgResultEntryComparatorByOrderNo.getApplicationTreeSet(); 
		    	Set<DgResultEntryDetail> subSet1 = new LinkedHashSet<DgResultEntryDetail>();
				for(DgResultEntryDetail dgResultEntryDetail : dgEH.getDgResultEntryDetails()){
					linkedHashSet.add(dgResultEntryDetail);
				}
				subSet1.addAll(linkedHashSet);
		    	
		    //	for(DgResultEntryDetail dgre:dgEH.getDgResultEntryDetails())
		    	for(DgResultEntryDetail dgre:subSet1)
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

	<input type="hidden" value="<%=third.get(key) %>" name="patientInvestigationdetailsId<%=inc %>" id="patientInvestigationdetailsId<%=inc %>" />
		<td><input type="text" value="<%=key%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="chargeCodeName<%=inc %>"
			 name="chargeCodeName<%=inc %>" size="45" />
</td>
<%

if(second.get(first.get(key))!=null)
	{
	Labresult="present";
	String st=(String)second.get(first.get(key));
	String[] mySplitResult = st.split("/");
	if(!mySplitResult[0].equalsIgnoreCase("template"))
	{if(resultList!=null && resultList.size()>0){
		%>
		
		<td> <input tabindex="1" type="checkbox"
		name="investigationReferToMH<%=inc %>" value="y"  id="investigationReferToMH<%=inc %>"  
		onclick="checkForInvestigationMH(<%=inc %>);" disabled="disabled"/>
	 </td><%}else{ %>
	 <td> <input tabindex="1" type="checkbox"
		name="investigationReferToMH<%=inc %>" value="y"  id="investigationReferToMH<%=inc %>"  
		onclick="checkForInvestigationMH(<%=inc %>);" />
	 <%} %>
	<td><input type="text" value="<%=second.get(first.get(key))%>" readonly="readonly"
			readonly="readonly" tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>

<% }else{

%>
<td>&nbsp;</td>
	<td>
	<input name="resultIdTemplate<%=inc %>"	id="resultIdTemplate<%=inc %>" type="hidden"	value="<%=mySplitResult[1]%>"/>
	<input	type="Button" class="Button" value="Result"	onclick="openTemplateScreen(<%=inc %>);"  />
	</td>

<%}%>
	
	<td>
	<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
	</td>
	<%}else{

	String investigationVal=key;
	StringTokenizer st = new StringTokenizer(investigationVal, "[");
	st.nextToken();
	String val = st.nextToken();
	StringTokenizer st1 = new StringTokenizer(val, "]");
	String finalInvestVal=st1.nextToken();
	%>

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

	    		%>
	    	 <td>
 <input tabindex="1" type="checkbox" name="investigationReferToMH<%=inc %>" value="y" checked="checked"
	id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);" disabled="disabled"/></td>
<td><input type="text" value=""  tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>
<td>
<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: inline"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>
<% 	    	}else
            { %>
             <td>
            <input tabindex="1" type="checkbox"
	name="investigationReferToMH<%=inc %>" value="n"  id="investigationReferToMH<%=inc %>"
	onclick="checkForInvestigationMH(<%=inc %>);"/>
   </td>
    <td><input type="text" value="" readonly="readonly"	 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>
<td>
<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none"  onClick="javascript:jsViewFileUploadWindow();" />
</td>
            <%
             }
	    	}else
	    	{ %>
 <td>
	<input tabindex="1" type="checkbox"	name="investigationReferToMH<%=inc %>" value="y"  
	id="investigationReferToMH<%=inc %>" onclick="checkForInvestigationMH(<%=inc %>);" />
   </td>
    <td><input type="text" value="" readonly="readonly"
			 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
        </td>
        <td>
<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);"/>
</td>
	    <%	}
	    }
	%>
	<!--
	/*
	* Code by Mukesh
	* Date 01 Feb 2012
	*/
	 -->
	<%--<input type="text" value="<%=dgOrderdt.getId()%>" name="dgOrderdtId<%=inc%>" id="dgOrderdtId<%=inc%>" />
	 --%>
	<input type="hidden" value="<%=third.get(key) %>" name="patientInvestigationdetailsId<%=inc %>" id="patientInvestigationdetailsId<%=inc %>" />
	<!--
	/*
	* End of Code by Mukesh
	* Date 01 Feb 2012
	*/
	 -->
	<%
	}
	}else{
	%>
	<!--
	/*
	* Code by Mukesh
	* Date 01 Feb 2012
	*/
	 -->
<%--
<input type="hidden" value="0" name="dgOrderdtId<%=inc%>" id="dgOrderdtId<%=inc%>" />
 --%>
<input type="hidden" value="0" name="patientInvestigationdetailsId<%=inc %>" id="patientInvestigationdetailsId<%=inc %>" />
<!--
	/*
	* End of Code by Mukesh
	* Date 01 Feb 2012
	*/
	 -->
	 <td>
 <input tabindex="1" type="checkbox" name="investigationReferToMH<%=inc %>" value="n"
	id="investigationReferToMH<%=inc %>"  onclick="checkForInvestigationMH(<%=inc %>);"/></td>
<td><input type="text" value="" readonly="readonly"	 tabindex="2" id="Result<%=inc %>"
			 name="Result<%=inc %>" size="65" />
</td>
<td>
<input name="uploadReport<%=inc %>" id="uploadReport<%=inc %>" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" />
</td>
<% }%>



<% }%>
<!-- style="display: none;" -->

<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation(this);" /></td>
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
			id="chargeCodeName1" size="45" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal','parent')}" />
		<div id="ac2update2" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
			size="10" maxlength="5" validate="Qty,num,no" /> <input type="hidden"
			tabindex="1" id="chargeCode1" name="chargeCode1" size="10" readonly />
		<!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->
<%--<input type="hidden" value="0" name="dgOrderdtId1" id="dgOrderdtId1" /> --%>
		</td>
	<td>
<input tabindex="1" type="checkbox"
	name="investigationReferToMH1" value="n" id="investigationReferToMH1" onclick="checkForInvestigationMH(1);" />
</td>
<td>
<input type="text" value="" readonly="readonly" name="Result1" id="Result1" size="65" />
</td>
<!-- style="display: none;"  -->
<td><input name="uploadReport1" id="uploadReport1" type="button"  class="button" value="UPLOAD REPORT" style="display: none;"  onClick="javascript:fileUploadWindowInvestigation(<%=inc %>);" /></td>

<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRowForInvestigation(this);" /></td>


	</tr>
	<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<% }%>
</table>
</div>

<script>
checkForInvestReferToMH();

</script>
<input type="hidden" id="investigationDataStatus" name="investigationDataStatus" value="no"/>

<div class="Clear paddingTop15"></div>
<h4> CARDIO VASCULAR SYSTEM <a	href="javascript:animatedcollapse.toggle('slide6')"></a></h4>
<div class="clear"></div>
<div id="slide6">
<div class="Block">
<div class="clear"></div>
<label>Pulse</label>
 <% if(medExamObj.getPulseRates()!=null){%>
  <input tabindex="2" type="text" maxlength="10"  name="<%=PULSE_RATES%>" class="auto" size="17" maxlength="10"  value="<%=medExamObj.getPulseRates() %>"/>
  <label class="unit">/min</label>
 <% }else{%>
 <input tabindex="2" type="text" maxlength="10"  name="<%=PULSE_RATES%>" class="auto" size="17" maxlength="10" /><label class="unit">/min</label>
 <% }%>
 <label class="medium">BP</label>
<% if(medExamObj.getBp()!=null){%>
  <input tabindex="2" type="text" maxlength="7"  name="<%=BP1%>" class="auto" size="17"  value="<%=medExamObj.getBp() %>"/>
 <label class="unit">mm Hg</label>
 <% }else{%>
 <input tabindex="2" type="text" maxlength="7"  name="<%=BP1%>" class="auto" size="17"  />
 <label class="unit">mm Hg</label>
 <% }%>
<label>Peripheral Pulsations</label>
<% if(medExamObj.getArterialWalls()!=null){%>
<input tabindex="2" type="text" maxlength="50" 	name="<%= ARTERIAL_WALLS%>" class="auto" size="20"   value="<%=medExamObj.getArterialWalls() %>"/>
 <% }else{%>
 <input tabindex="2" type="text" maxlength="50" 	name="<%= ARTERIAL_WALLS%>" class="auto" size="20"  />
 <% }%>


<div class="clear"></div>
<label>Heart Size</label>
<% if(medExamObj.getHeartSize()!=null){%>
<input tabindex="2" type="text" maxlength="50" 	name="<%= HEART_SIZE%>" class="auto" size="26"  value="<%=medExamObj.getHeartSize() %>"/>

 <% }else{%>
<input tabindex="2" type="text" maxlength="50" 	name="<%= HEART_SIZE%>" class="auto" size="26"  />

 <% }%>


 <label class="medium">Sounds</label>
 <% if(medExamObj.getSounds()!=null){%>
 <input tabindex="2" type="text" maxlength="50"  name="<%= SOUND%>" class="auto"	size="27"  value="<%=medExamObj.getSounds() %>"/>

 <% }else{%>
 <input tabindex="2" type="text" maxlength="50"  name="<%= SOUND%>" class="auto"	size="27"  />

 <% }%>
<label>Rhythm</label>
<% if(medExamObj.getRhythm()!=null){%>
 <input tabindex="2" type="text" maxlength="50"  name="<%= RHYTHM%>" class="auto"	size="20"  value="<%=medExamObj.getRhythm() %>"/>

 <% }else{%>
 <input tabindex="2" type="text" maxlength="50"  name="<%= RHYTHM%>" class="auto"	size="20"  />
 <% }%>


<div class="clear"></div>

</div>

</div>
<div class="clear paddingTop15"></div>

<h4>RESPIRATORY SYSTEM <a href="javascript:animatedcollapse.toggle('slide7')"></a></h4>
<div class="clear"></div>
<div id="slide7">
<div class="Block">
<div class="clear"></div>
<label> Respiratory System</label>
<% if(medExamObj.getRespiratorySystem()!=null){%>
  <input tabindex="2" type="text" maxlength="100" 	name="<%=RESPIRATORY_SYSTEM %>" class="auto" size="120"  value="<%=medExamObj.getRespiratorySystem() %>"/>
   <% }else{%>
  <input tabindex="2" type="text" maxlength="100" 	name="<%=RESPIRATORY_SYSTEM %>" class="auto" size="120"  />
 <% }%>


<div class="clear"></div>
</div>
</div>

<div class="clear paddingTop15"></div>


<h4>GASTRO INTESTINAL SYSTEM <a	href="javascript:animatedcollapse.toggle('slide8')"></a></h4>
<div class="clear"></div>
<div id="slide8">
<div class="Block">
<div class="clear"></div>
<label > Liver</label>
<% if(medExamObj.getLiver()!=null){%>
  <input tabindex="2" type="text"  	name="liver" class="auto" size="120" maxlength="50" value="<%=medExamObj.getLiver() %>"/>
   <% }else{%>
  <input tabindex="2" type="text" 	name="liver" class="auto" size="120" maxlength="50" value="Not Palpable"/>
 <% }%>
<div class="clear"></div>
<label> Spleen</label>
<% if(medExamObj.getSpleen()!=null){%>
  <input tabindex="2" type="text"  	name="spleen" class="auto" size="120" maxlength="50" value="<%=medExamObj.getSpleen() %>"/>
   <% }else{%>
  <input tabindex="2" type="text" 	name="spleen" class="auto" size="120" maxlength="50" value="Not Palpable"/>
 <% }%>

<div class="clear"></div>
</div>
</div>
<div class="clear paddingTop15"></div>

<h4>CENTRAL NERVOUS SYSTEM <a href="javascript:animatedcollapse.toggle('slide9')"></a></h4>
<div class="clear"></div>
<div id="slide9">
<div class="Block">
<div class="clear"></div>
<label > Higher Mental Function</label>
<% if(medExamObj.getHigherMentalFunction()!=null){%>
<input tabindex="2" type="text" maxlength="50" 	name="<%=HIGHER_MENTAL_FUNCTION %>"   value="<%=medExamObj.getHigherMentalFunction() %>"/>
   <% }else{%>
<input tabindex="2" type="text" maxlength="50" 	name="<%=HIGHER_MENTAL_FUNCTION %>"   value="Normal"/>
 <% }%>

<label > Speech</label>
<% if(medExamObj.getSpeech()!=null){%>
<input tabindex="2" type="text" name="<%=SPEECH %>"  maxlength="50" value="<%=medExamObj.getSpeech() %>"/>
   <% }else{%>
<input tabindex="2" type="text" 	name="<%=SPEECH %>"  maxlength="50" value="Normal"/>
 <% }%>


<label > Reflexes</label>
<% if(medExamObj.getReflexes()!=null){%>
<input tabindex="2" type="text" name="<%=REFLEXES %>"  maxlength="50" value="<%=medExamObj.getReflexes() %>"/>
   <% }else{%>
<input tabindex="2" type="text" name="<%=REFLEXES %>"  maxlength="50" value="Normal"/>
 <% }%>


<div class="clear"></div>
<label > Tremors</label>
<select name="<%=TREMORS %>" size="0" tabindex="2" id="tremors">
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

<select name="<%=SELF_BALANCING_TEST %>" size="0" tabindex="2" id="selfbalancingtest">
<option value="0">select</option>
	<%if(medExamObj.getSelfBalancingTest().equalsIgnoreCase("Fairly Steady")){ %>
	<option value="Fairly Steady" selected="selected">Fairly Steady</option>
	<option value="Steady">Steady</option>
	<option value="Unsteady">Unsteady</option>
	<%}else if(medExamObj.getSelfBalancingTest().equalsIgnoreCase("Steady")){ %>
	<option value="Fairly Steady">Fairly Steady</option>
	<option value="Steady" selected="selected">Steady</option>
	<option value="Unsteady">Unsteady</option>
	<%}else if(medExamObj.getSelfBalancingTest().equalsIgnoreCase("Unsteady")){ %>
	<option value="Fairly Steady">Fairly Steady</option>
	<option value="Steady">Steady</option>
	<option value="Unsteady" selected="selected">Unsteady</option>
	<%}else{ %>
	<option value="Fairly Steady">Fairly Steady</option>
	<option value="Steady">Steady</option>
	<option value="Unsteady">Unsteady</option>
	<%} %>
</select>
<%----
<script>
<%
if(medExamObj.getSelfBalancingTest()!= null){
%>
document.getElementById("selfbalancingtest").value='<%=medExamObj.getSelfBalancingTest()%>';

<%}%>
</script> --%>
<div class="clear"></div>
<div class="division"></div>

<div class="clear"></div>
<label >Locomotor System</label>
<% if(medExamObj.getLocomoterSystem()!=null){%>
<input tabindex="2" type="text" name="locomoterSystem" size="20" maxlength="50" value="<%=medExamObj.getLocomoterSystem() %>"/>
   <% }else{%>
<input tabindex="2" type="text" name="locomoterSystem" size="20" maxlength="50" value="NAD"/>
 <% }%>
<label>Spine</label>
<% if(medExamObj.getSpine()!=null){%>
<input tabindex="2" type="text" name="spine"  size="20" maxlength="50" value="<%=medExamObj.getSpine() %>"/>
   <% }else{%>

<input tabindex="2" type="text" name="spine"  size="20" maxlength="50" value="NAD"/>
 <% }%>


<label>Hernia</label>
<% if(medExamObj.getHerniaMusic()!=null){%>
<input tabindex="2" type="text"  name="<%=HERNIA_MUSCLE %>" size="20" maxlength="50" value="<%=medExamObj.getHerniaMusic() %>"/>
   <% }else{%>

<input tabindex="2" type="text" name="<%=HERNIA_MUSCLE %>" size="20" maxlength="50" value="NIL"/>
 <% }%>


<div class="clear"></div>
<label>Hydrocele</label>
<% if(medExamObj.getHydrocele()!=null){%>
<input tabindex="2" type="text" name="<%=HYDROCELE %>"  size="20" maxlength="50" value="<%=medExamObj.getHydrocele() %>"/>
   <% }else{%>

<input tabindex="2" type="text" name="<%=HYDROCELE %>"  size="20" maxlength="50" value="NIL"/>
 <% }%>


<label>Haemorrhoids</label>
<% if(medExamObj.getHemorrhoids()!=null){%>
<input tabindex="2" type="text" name="<%=HEMONHOIDS %>" size="20" maxlength="50" value="<%=medExamObj.getHemorrhoids() %>"/>
   <% }else{%>
<input tabindex="2" type="text" name="<%=HEMONHOIDS %>"  size="20" maxlength="50" value="NIL"/>
 <% }%>


<label>Breast</label>
<% if(medExamObj.getBreasts()!=null){%>
<input tabindex="2" type="text" name="<%=BREASTS %>" class="" size="20" maxlength="50" value="<%=medExamObj.getBreasts() %>"/>
   <% }else{%>
<input tabindex="2" type="text" name="<%=BREASTS %>" class="" size="20" maxlength="50" value="NAD"/>
 <% }%>


<div class="clear"></div>

</div>
</div>
<div class="clear paddingTop15"></div>
<% if(visit.getHin().getSex().getAdministrativeSexName().equalsIgnoreCase("Female")){%>


<h4>GYNAECOLOGY EXAM <a href="javascript:animatedcollapse.toggle('slide10')"></a></h4>
<div class="clear"></div>
<div id="slide10">
<div class="Block">
<label >Menstrual History</label>
<% if(medExamObj.getMenstrualHistory()!=null){%>
<input tabindex="2" type="text" maxlength="50" 	name="<%=MENSTRUAL_HISTORY %>" class="" size="20"  value="<%=medExamObj.getMenstrualHistory() %>"/>
   <% }else{%>
<input tabindex="2" type="text" maxlength="50" 	name="<%=MENSTRUAL_HISTORY %>" class="" size="20"  />
 <% }%>


<label>LMP</label>
<% if(medExamObj.getLmp()!=null){%>
<input tabindex="2" type="text"  class="calDate" readonly="readonly "	name="<%=LMP %>"  size="20" maxlength="3" onKeyUp="mask(this.value,this,'2,5','/');" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getLmp()) %>"/>
   <% }else{%>
<input tabindex="2" type="text" class="calDate" readonly="readonly "	name="<%=LMP %>" onKeyUp="mask(this.value,this,'2,5','/');"  size="20" maxlength="3" />
 <% }%>
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',medicalBoardExaminationAnnual.<%=LMP%>,event);" />
<label >No. of pregnancies</label>
<% if(medExamObj.getNoOfPregnancies()!=null){%>
<input tabindex="2" type="text" 	name="<%=NO_OF_PREGNANCY %>" class="" size="20" maxlength="3" value="<%=medExamObj.getNoOfPregnancies() %>"  onkeyup="isNumber1(this)"/>
   <% }else{%>
<input tabindex="2" type="text" 	name="<%=NO_OF_PREGNANCY %>" class="" size="20" maxlength="3"  onkeyup="isNumber1(this)"/>
 <% }%>

<div class="clear"></div>
<label >No. of Abortions</label>
<% if(medExamObj.getNoOfAbortions()!=null){%>
<input tabindex="2" type="text" id="noofabo"	name="<%=NO_OF_ABORTION %>" class="" size="20" maxlength="3" value="<%=medExamObj.getNoOfAbortions() %>"  onkeyup="isNumber1(this)"/>
   <% }else{%>
<input tabindex="2" type="text" id="noofabo"	name="<%=NO_OF_ABORTION %>" class="" size="20" maxlength="3"  onkeyup="isNumber1(this)"/>
 <% }%>
<label >No. of Children</label>
<% if(medExamObj.getNoOfChildren()!=null){%>
<input tabindex="2" type="text" 	name="<%=NO_OF_CHILDREN %>" class="" size="20" maxlength="3" value="<%=medExamObj.getNoOfChildren() %>"  onkeyup="isNumber1(this)"/>
   <% }else{%>
<input tabindex="2" type="text"  	name="<%=NO_OF_CHILDREN %>" class="" size="20" maxlength="3"  onkeyup="isNumber1(this)"/>
 <% }%>


<label >Last Confinement on</label>
<% if(medExamObj.getLastConfinementDate()!=null){%>
<input tabindex="2" type="text"  class="calDate" readonly="readonly " value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getLastConfinementDate()) %>"	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" />
   <% }else{%>
<input tabindex="2" type="text"  class="calDate" readonly="readonly "	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" />
 <% }%>


<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',medicalBoardExaminationAnnual.<%=DATE_OF_LASTCONFINEMENT%>,event);" />
<div class="clear"></div>
<label >Vaginal Discharge</label>
<% if(medExamObj.getVaginalDischarge()!=null){%>
<input tabindex="2" type="text" 	name="<%=VAGINAL_DISCHARGE %>" class="" size="20" maxlength="50" value="<%=medExamObj.getVaginalDischarge() %>"/>
   <% }else{%>
<input tabindex="2" type="text" 	name="<%=VAGINAL_DISCHARGE %>" class="" size="20" maxlength="50" />
 <% }%>


<label	>Prolapse</label>
<% if(medExamObj.getProlapse()!=null){%>
<input tabindex="2" type="text" 	name="<%=PROLAPSE %>" class="" size="20" maxlength="50" value="<%=medExamObj.getProlapse() %>"/>
   <% }else{%>
<input tabindex="2" type="text" 	name="<%=PROLAPSE %>" class="" size="20" maxlength="50" />
 <% }%>


<label >USG Abdomen</label>
<% if(medExamObj.getUsgAbdomen()!=null){%>
<input tabindex="2" type="text" name="<%=USG_ABORTION %>" class="" size="20" maxlength="200" value="<%=medExamObj.getUsgAbdomen() %>"/>
   <% }else{%>
<input tabindex="2" type="text" name="<%=USG_ABORTION %>" class="" size="20" maxlength="200" />
 <% }%>
<div class="clear"></div>
 <input size="157" class="transparent" />
<input name="Send" type="button"  class="button" value="UPLOAD/VIEW" onClick="javascript:FileUploadWindowGynaecology();" />

</div>
</div>
<%} %>

<div class="Clear paddingTop15"></div>
<h4>IMMUNIZATION STATUS <a	href="javascript:animatedcollapse.toggle('slide11')"></a></h4>
<div class="Block">

<input tabindex="2" name="Button"	type="button" class="button" value="Immunization"	onClick="javascript:openPopupForImmunization();" />
</div>
<div class="clear"></div>


<div class="clear paddingTop15"></div>
<h4>LIFE STYLE FACTORS <a	href="javascript:animatedcollapse.toggle('slide12')"></a></h4>
<div class="clear"></div>
<div id="slide12">
<div class="Block">
<div class="clear"></div>
<label> Coronary Risk Factors</label>
<% if(medExamObj.getCoronaryRiskFactor()!=null){%>
<input tabindex="2" type="text" maxlength="50" 	name="<%=CORONORY_RISK_FACTOR %>"  size="20" maxlength="50"
	value="<%=medExamObj.getCoronaryRiskFactor() %>"/>
   <% }else{%>
<input tabindex="2" type="text" maxlength="50" 	name="<%=CORONORY_RISK_FACTOR %>" size="20" maxlength="50" />
 <% }%>

<label >Family History</label>
<%---
<select name="<%=FM_DM %>" multiple
	size="6" class="list"  tabindex=1 id="FamilyHistory" onclick="checkFamilyOtherVal();" >--%>
	<select name="<%=FM_DM %>" multiple
	size="6" class="list"  tabindex=2 id="FamilyHistory" maxlength="50" onclick="openOtherField(this.value);">

	<option value="0" >Select</option>
	<%
	          		if(patientFamilyHistoryList != null)
	          		{
	          			for(PatientFamilyHistory patientFamilyHistory:patientFamilyHistoryList )
	          			{	int no=0;
	          				for(MasMedicalExamFamilyHis masMedicalExamFamilyHis: masMedicalExamFamilyHisList)
	          				{
	          					if(patientFamilyHistory.getId()==masMedicalExamFamilyHis.getPatientFamilyHistory().getId())
	          					{
	          %>
	<option value="<%=patientFamilyHistory.getId() %>" selected="selected"><%=patientFamilyHistory.getPatientHistoryName() %></option>
	<%		                     no=1;
	                             break;
	          					}
	                       }
	          				if(no==0)
	          				{%>
	          		<option value="<%=patientFamilyHistory.getId() %>" ><%=patientFamilyHistory.getPatientHistoryName() %></option>

	          			<%	}

	         			}
	         		 }
	         %>
</select>

<%---
<%

if(medExamObj.getFmdm()!=null){ %>
<input type="text" value="<%=medExamObj.getFmdm() %>" name="familyHistoryOther" id="familyHistoryOther" style="display: none" />
<%}else{ %>
<input type="text" value="" name="familyHistoryOther" id="familyHistoryOther" style="display: none" />
<%} %>--%>

<%
	String otherFamilyHistory="";
if(visit.getHin().getFamilyHistory() !=null){
	otherFamilyHistory=visit.getHin().getFamilyHistory().getPatientHistoryName();
}else if(medExamObj.getHin().getOtherFamilyHistory() !=null){
	otherFamilyHistory=medExamObj.getHin().getOtherFamilyHistory();
 %>
 <div id="otherFamilyHistoryDiv" style="display: inline;">
<label>Other</label>
<input type="text" tabindex="2" name="otherFamilyHistory" id="otherFamilyHistory" value="<%=otherFamilyHistory%>"
maxlength="50"/></div>
<%}else{ %>
<div id="otherFamilyHistoryDiv" style="display: none;">
<label>Other</label>
<input type="text" tabindex="2" name="otherFamilyHistory" id="otherFamilyHistory" value="<%=otherFamilyHistory%>"
maxlength="50"/>
</div>
<%} %>
<script>
checkFamilyHistory();
</script>
 <div class="clear"></div>

<%
String smokerMore10="";
String smokerLess10="";
if(visit.getHin().getSmokerMore10() !=null){
smokerMore10=visit.getHin().getSmokerMore10();
}
if(visit.getHin().getSmokerLess10() !=null){
	smokerLess10=visit.getHin().getSmokerLess10();
	}
%>
<label>Smoker</label>
<label class="auto"><10</label>
<%if(smokerLess10.equalsIgnoreCase("y")){ %>
<input type="checkbox" name="smokerLess10" value="" class="radioAuto2" checked="checked"/>
<%}else{ %>
<input type="checkbox" name="smokerLess10" value="" class="radioAuto2" />
<%} %>
<label class="auto">>10</label>
<%if(smokerMore10.equalsIgnoreCase("y")){ %>
 <input type="checkbox" name="smokerMore10" class="radioAuto2" checked="checked"/>
 <%}else{ %>
 <input type="checkbox" name="smokerMore10" class="radioAuto2" />
 <%} %><label>Alcohol</label> <select name="alcohol"
	id="<%=COVER_TEST %>" tabindex="1">

<%
String alcohal="";
if(medExamObj.getHin() !=null){
if(medExamObj.getHin().getAlcohol() !=null){%>
   <option value=""><%=medExamObj.getHin().getAlcohol() %></option>
   <%
	 alcohal=medExamObj.getHin().getAlcohol();
  }%>
  <%  }

if(alcohal.equalsIgnoreCase("Non-drinker")){ %>
<option value="Non-drinker" selected="selected">Non-drinker</option>
<option value="Occasional">Occasional</option>
<option value="Moderate">Moderate</option>
<option value="Heavy">Heavy</option>
<%}else if(alcohal.equalsIgnoreCase("Occasional")){ %>
<option value="Non-drinker">Non-drinker</option>
<option value="Occasional" selected="selected">Occasional</option>
<option value="Moderate">Moderate</option>
<option value="Heavy">Heavy</option>
<%}else if(alcohal.equalsIgnoreCase("Moderate")){ %>
<option value="Non-drinker" >Non-drinker</option>
<option value="Occasional">Occasional</option>
<option value="Moderate" selected="selected">Moderate</option>
<option value="Heavy">Heavy</option>
<%}else if(alcohal.equalsIgnoreCase("Heavy")){ %>
<option value="Non-drinker">Non-drinker</option>
<option value="Occasional">Occasional</option>
<option value="Moderate">Moderate</option>
<option value="Heavy" selected="selected">Heavy</option>
<%} else{ %>
<option value="Non-drinker">Non-drinker</option>
<option value="Occasional">Occasional</option>
<option value="Moderate">Moderate</option>
<option value="Heavy">Heavy</option>
<%} %>
</select>
<script>
<%
if(medExamObj.getCoverTest()!= null){
%>
document.getElementById("<%=COVER_TEST %>").value='<%=medExamObj.getCoverTest()%>';

<%}%>
</script>
<!--<input tabindex="2" name="Button"	type="button" class="button" value="Allergies"	onClick="javascript:openPopupForAllergies();" />

-->
<div class="clear"></div>
<label>Allergy</label>
<%if(visit.getHin().getDrugAllergies() != null){ %>
<input name="allergies" type="text" tabindex="1" class="auto" value="<%=visit.getHin().getDrugAllergies() %>" maxlength="60" id="allergies" size="92"  />
<%}else{ %>
<input name="allergies" type="text" tabindex="1" class="auto" value="" maxlength="60" id="allergies" size="92" />
<%} %>
<div class="clear"></div>
</div>
</div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<h4>FINAL OBSERVATION AND MEDICAL CATEGORY</h4>
<div class="clear"></div>

<div class="Block">
<label >Final Observation</label>
<select name="<%=FINAL_OBSERVATION %>" id="finalObserv">
<option value="">Select</option>
<%String finalObservation="";
	if(medExamObj.getFinalObservation() !=null){
		finalObservation=medExamObj.getFinalObservation();
	} %>
<%if(finalObservation.equalsIgnoreCase("Fit")){ %>
<option value="Fit" selected="selected">Fit</option>
<option value="UnFit">UnFit</option>
<%}else if(finalObservation.equalsIgnoreCase("UnFit")){ %>
<option value="UnFit" selected="selected">UnFit</option>
<option value="Fit">Fit</option>
<%}else{ %>
<option value="Fit">Fit</option>
<option value="UnFit">UnFit</option>
<%} %>
</select>
<%---
<% if(medExamObj.getFinalObservation()!=null){%>
<input tabindex="1" type="text" 	name="<%=FINAL_OBSERVATION %>"  size="20" maxlength="100" value="<%=medExamObj.getFinalObservation() %>"/>
   <% }else{%>
<input tabindex="1" type="text" 	name="<%=FINAL_OBSERVATION %>"  size="20" maxlength="100" />
 <% }%> --%>
<label >Med Cat Rec</label>
<%--
<select name="<%= PAST_MEDICAL_CATEGORY  %>"	id="medCatRecId"validate="Signed By,string,no" tabindex="2">
<option value="0">Select</option>
<%
if( medExamObj.getPastMedicalCategory()!=null)
{
		for (Category category : categoryList) {
			if(category.getCategories().equalsIgnoreCase("A1G1")||category.getCategories().equalsIgnoreCase("A4G1"))
			{

			if( medExamObj.getPastMedicalCategory().getCategoryid().equals(category.getCategoryid()))
				{
			%>
<option value="<%=category.getCategoryid()%>"  selected="selected"><%=category.getCategories()%> </option>
<%}}}}else{
	for (Category category : categoryList)
	{
		if(category.getCategories().equalsIgnoreCase("A1G1")||category.getCategories().equalsIgnoreCase("A4G1"))
		{

%>
<option value="<%=category.getCategoryid()%>" ><%=category.getCategories()%> </option>
<%	}}}
		%>
</select> Commented by rahul bcz not saving data in medcatrec field...---%>

<select name="<%= MED_CAT_REC  %>"	id="medCatRecId"validate="Signed By,string,no" tabindex="2" onchange="setMedCatId(this.value)">
<option value="0">Select</option>
<%
System.out.println("cat1="+medExamObj.getPastMedicalCategory());
System.out.println("cat="+medExamObj.getMedCatRec());
if( medExamObj.getPastMedicalCategory()!=null)
{
	out.print("cat="+medExamObj.getMedCatRec());
		for (Category category : categoryList)
		{
			if(medExamObj.getServiceType().getServiceTypeName().equalsIgnoreCase("Air Force"))
			{
				if(category.getCategories().equalsIgnoreCase("A1G1")||category.getCategories().equalsIgnoreCase("A4G1"))
				{
	
					if( medExamObj.getMedCatRec().equals(category.getCategories()))
					 {
						%>
							<option value="<%=category.getCategories()%>"  selected="selected"><%=category.getCategories()%> </option>
						<%
					 }
				}
			}
			
			if(medExamObj.getServiceType().getServiceTypeName().equalsIgnoreCase("Army"))
			{
				if(category.getCategories().equalsIgnoreCase("Shape-1A")||category.getCategories().equalsIgnoreCase("Shape-1B"))
				{
	
					if( medExamObj.getMedCatRec().equals(category.getCategories()))
					 {
						%>
							<option value="<%=category.getCategories()%>"  selected="selected"><%=category.getCategories()%> </option>
						<%
					 }
				}
			}
			
			if(medExamObj.getServiceType().getServiceTypeName().equalsIgnoreCase("Navy"))
			{
				if(category.getCategories().equalsIgnoreCase("S1A1")||category.getCategories().equalsIgnoreCase("S2A1"))
				{
	
					if( medExamObj.getMedCatRec().equals(category.getCategories()))
					 {
						%>
							<option value="<%=category.getCategories()%>"  selected="selected"><%=category.getCategories()%> </option>
						<%
					 }
				}
			}
		}
		
}
else
{
	for (Category category : categoryList)
	{
		if(medExamObj.getServiceType().getServiceTypeName().equalsIgnoreCase("Air Force"))
		{
			if(category.getCategories().equalsIgnoreCase("A1G1")||category.getCategories().equalsIgnoreCase("A4G1"))
			{

				%>
					<option value="<%=category.getCategories()%>" ><%=category.getCategories()%> </option>
				<%	
			}
		}
		
		if(medExamObj.getServiceType().getServiceTypeName().equalsIgnoreCase("Army"))
		{
			if(category.getCategories().equalsIgnoreCase("Shape-1A")||category.getCategories().equalsIgnoreCase("Shape-1B"))
			{

				%>
					<option value="<%=category.getCategories()%>" ><%=category.getCategories()%> </option>
				<%	
			}
		}
		
		if(medExamObj.getServiceType().getServiceTypeName().equalsIgnoreCase("Navy"))
		{
			if(category.getCategories().equalsIgnoreCase("S1A1")||category.getCategories().equalsIgnoreCase("S2A1"))
			{

				%>
					<option value="<%=category.getCategories()%>" ><%=category.getCategories()%> </option>
				<%	
			}
		}
		
	}
}
		%>
</select> 
<input name="medCat" type="hidden" id="catId" tabindex="1" class="auto" value="" />
<script type="text/javascript">
	function setMedCatId(medCategory){
	 <%
	 String catName = "";
	 int catId = 0;
	 if(categoryList.size()>0){
	 for(Category cat :categoryList){
		 catName = cat.getCategories();
		 catId = cat.getCategoryid();
	 %>
	 if(medCategory == '<%=catName%>'){
	document.getElementById('catId').value = <%=catId%>	
	 }
	<%}
	 }%>
	}


</script>

<label class="">Admission</label>
<%if(medExamObj.getAdmissionStatus()!=null)
{
if(medExamObj.getAdmissionStatus().equalsIgnoreCase("y")){ %>
<input tabindex="2" type="checkbox"
	name="admissionStatus" value="y" class="radioAuto" id="admissionStatus" checked="checked" onclick="checkForAdmissionSpecial();"/>

<%}else{ %>
<input tabindex="2" type="checkbox"
	name="admissionStatus" value="n" class="radioAuto" id="admissionStatus" onclick="checkForAdmissionSpecial();" />
<%}}else{ %>
<input tabindex="2" type="checkbox"
	name="admissionStatus" value="n" class="radioAuto" id="admissionStatus" onclick="checkForAdmissionSpecial();" />
	<%} %>
<div class="clear"></div>
<label class="auto">Specialist Opinion</label>
<%if(medExamObj.getSpecialistOpinnionStatus()!=null)
{
if(medExamObj.getSpecialistOpinnionStatus().equalsIgnoreCase("y")){ %>
<input tabindex="2" type="checkbox"
	name="specialistOpinion" value="y" checked="checked" class="radioAuto" id="specialistOpinion" onclick="checkForAdmissionSpecial();" />
<input name="Send" type="button"  class="button" value="UPLOAD/VIEW" onClick="javascript:fileUploadForSpecialistOpinion();" />
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="Print Medical Case Sheet"	onclick="submitFormForButton('medicalBoardExaminationAnnual','/hms/hms/medicalExam?method=printMedicalCaseSheetForMedicalExam')" />

<%}else{ %>
<input tabindex="2" type="checkbox" name="specialistOpinion" value="n" class="radioAuto" id="specialistOpinion" onclick="checkForAdmissionSpecial();" />
<input tabindex="1" name="Button" type="button" class="buttonBig2" value="Forward to Specialist"	onclick="openPopupForSpecialistOpinionForward('<%=visit.getId()%>','<%=medExamId %>');" />

<%}}else{ %>
<input tabindex="2" type="checkbox" name="specialistOpinion" value="n" class="radioAuto" id="specialistOpinion" onclick="checkForAdmissionSpecial();" />
	<input tabindex="1" name="Button" type="button" class="buttonBig2" value="Forward to Specialist"	onclick="openPopupForSpecialistOpinionForward('<%=visit.getId()%>','<%=medExamId %>');" />
	
<%} %>

<label >Signed by</label>
<input tabindex="2" type="text" id="signidBy" name="<%= SIGNED_BY %>"  size="20" maxlength="100" value="<%=signedBy %>" readonly="readonly" validate="Signed By,string,no"/>
<%--
<label >Send To</label>
<%
String sendTo="";

if(medExamObj.getMedicalExamType().equalsIgnoreCase("Annual Medical Exam(AFMSF-3B)"))
{

if(medExamObj.getHin().getRank().getRankCategory().getRankCategoryCode().equalsIgnoreCase("JCO")||medExamObj.getHin().getRank().getRankCategory().getRankCategoryCode().equalsIgnoreCase("NC"))
{
	if(medExamObj.getHin().getRank().getRankName().equalsIgnoreCase("SGT")||medExamObj.getHin().getRank().getRankName().equalsIgnoreCase("CPL")||medExamObj.getHin().getRank().getRankName().equalsIgnoreCase("LAC")||medExamObj.getHin().getRank().getRankName().equalsIgnoreCase("AC"))
	{
	    sendTo="SMO";
	}else if(medExamObj.getHin().getRank().getRankName().equalsIgnoreCase("JWO")||medExamObj.getHin().getRank().getRankName().equalsIgnoreCase("WO")||medExamObj.getHin().getRank().getRankName().equalsIgnoreCase("MWO"))
	{
	    sendTo="Command";
	}
}else if(medExamObj.getHin().getRank().getRankCategory().getRankCategoryCode().equalsIgnoreCase("Officer"))
{
	sendTo="Command";

}
}

%>
<input tabindex="1" type="text" id="sendTo" name="<%= SEND_TO %>"  size="20" maxlength="100" value="<%=sendTo %>" readonly="readonly" />
 --%>
 <div class="clear"></div>
<label >Remarks</label>
<% if(medExamObj.getRemarks()!=null){%>
<input tabindex="2" type="text"  maxlength="100"  id="remarks"	name="<%=MEDICIN_REMARKS %>" size="20"  value="<%=medExamObj.getRemarks() %>"/>
   <% }else{%>
<input tabindex="2" type="text"  maxlength="100" id="remarks"	name="<%=MEDICIN_REMARKS %>" size="20"  value=""/>
 <% }%>
 
<div class="clear" style="padding-top: 3px;"></div>

<%
  if(medExamObj.getDoctorAdviceFlag() != null)
 {
	if(medExamObj.getDoctorAdviceFlag().equalsIgnoreCase("y"))
	{
		%>
			
			<label class="biglarge">Advice to reduce weight by diet control and regular exercise</label>
			<input	type="checkbox"  name="DoctorAdviceFlag" id="DoctorAdviceFlag" value="y"	checked/>
			
		<%
	}
	else
	{
		%>
		
		<label class="biglarge">Advice to reduce weight by diet control and regular exercise</label>
		<input	type="checkbox"  name="DoctorAdviceFlag" id="DoctorAdviceFlag" value="y"	/>
		
		<%
	}
	
}
  else
	{
		%>
		
		<label class="biglarge">Advice to reduce weight by diet control and regular exercise</label>
		<input	type="checkbox"  name="DoctorAdviceFlag" id="DoctorAdviceFlag" value="y"	/>
		
		<%
	}
%>
<div class="clear"></div>

  </div>
  
  
<div class="clear paddingTop15"></div>
<%
  if(medExamObj.getApprovAuthRemarks()!=null){
  		%>
  		 <div class="clear paddingTop15"></div>

<h4>Rejection Remark</h4>
<div class="clear"></div>

<div class="Block">
<label >Final Observation</label>
<% if(medExamObj.getAprovAuthFinalObservation()!=null){%>
<input tabindex="1" type="text" name="aaFinalObservation" value="<%=medExamObj.getAprovAuthFinalObservation() %>"   readonly="readonly"  size="20" maxlength="100" />
  <% }else{%>
 <input tabindex="1" readonly="readonly" type="text" name="aaFinalObservation" value=""  size="20" maxlength="100" />

  <% }%>
  <label >Remarks</label>
  <% if(medExamObj.getApprovAuthRemarks()!=null){%>
<textarea cols="20" rows="2" tabindex="2" maxlength="100" name="aaRemarks" tabindex="1" readonly="readonly"
onkeyup="chkLength(this,99);" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)"><%=medExamObj.getApprovAuthRemarks() %></textarea>
  <% }else{%>
 <textarea cols="20" rows="2" tabindex="2" maxlength="100" name="aaRemarks" tabindex="1" readonly="readonly"
 onkeyup="chkLength(this,99);" onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)"></textarea>

  <% }%>
<label >Signed by</label>
<% if(medExamObj.getApprovAuthSignedBy()!=null){%>
<input tabindex="1" type="text" readonly="readonly" name="aaSignedBy"  size="20" maxlength="100" value="<%=medExamObj.getApprovAuthSignedBy() %>"  readonly="readonly"/>
  <% }else{%>
 <input tabindex="1" type="text" readonly="readonly" name="aaSignedBy"  size="20" maxlength="100" value=""  readonly="readonly"/>

  <% }%>

  </div>
  		<%
  	}
  %>
  <div class="clear paddingTop15"></div>
<div class="division"></div>
<div class="clear"></div>
<% if(search.equalsIgnoreCase("false")){%>

<input tabindex="2" name="Button"	type="button" class="button" value="Update"	onclick="updateData();"
	<%-- onClick="submitForm('medicalBoardExaminationAnnual','medicalExam?method=updateMedicalExamEntry&Labresult=<%=Labresult %>');" --%>/>
<input tabindex="2" class=button id=reset accessKey=r	onclick=resetCheck(); type=reset value=RESET name=Reset>
<%if(medExamObj.getStatus().equalsIgnoreCase("m") || (medExamObj.getVisit().getReportingFor().equalsIgnoreCase("MedBoard") && medExamObj.getStatus().equalsIgnoreCase("f"))){ %>
<input tabindex="2" name="Button" id="validateId"	type="button" class="button" value="VALIDATE"	onClick="submitForm('medicalBoardExaminationAnnual','medicalExam?method=validateMedExam');" />
<%} %>
<input tabindex="2" name="Button"	type="button" class="button" value="REJECT"	onClick="if(checkRemarks()){submitForm('medicalBoardExaminationAnnual','medicalExam?method=rejectMedExam');}" />
 <input tabindex="2" name="Button"	type="button" class="buttonBig2" value="Initiate New Medical Exam"	onClick="submitForm('medicalBoardExaminationAnnual','medicalExam?method=initiateNewMedicalExam');" />
 <%if(dgOrderhd.getOrderStatus().equalsIgnoreCase("A")){ %>
 <input tabindex="2" name="Button"	type="button" class="buttonBig" value="Print Investigations"	onClick="submitForInvestigationPrintOut();" />
 <%} %>
  <% }%>
<%if(medExamObj.getSpecialistOpinnionStatus()!=null)
{
if(medExamObj.getSpecialistOpinnionStatus().equalsIgnoreCase("y")){ %>
 <input tabindex="2" name="Button"	type="button" class="buttonBig2" value="Print Specialist Opinion"	onClick="submitForm('medicalBoardExaminationAnnual','medicalExam?method=printSpecialistOpinionForMedicalExam');" />

  <%
  }
}
  if(medExamObj.getApprovAuthRemarks()!=null){
  		%>
<input tabindex="2" name="Button"	type="button" class="button" value="Initiate New Medical Exam"	onClick="submitForm('medicalBoardExaminationAnnual','medicalExam?method=updateMedicalExamEntry&Labresult=<%=Labresult %>');" />

  <%} %>
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
<input type="hidden" name="fstatus" id="fstatus" value="">
<%if(visit.getDoctor() != null){ %>
<input name="empId" type="hidden" value="<%=visit.getDoctor().getId()%>" />
<%}%>
<%if(visit.getDepartment() != null){%>
<input name="deptId" type="hidden" value="<%=visit.getDepartment().getId()%>" />
<%}%>
<%if(visit.getHin() != null){	%>
<input name="hinId" id="hinId" type="hidden" value="<%=visit.getHin().getId()%>" />
<%}%>
<%if(visit.getHin() != null){%>
<input name="visitId" type="hidden" value="<%=visit.getId()%>" />
<input name="visitNumberForReport" type="hidden" value="<%=visit.getVisitNo()%>" />
<%}%>

<input type="hidden"  name="medicalType" id="medicalType" value="<%=medExamObj.getMedicalType() %>"/>
<input type="hidden"  name="MissTeeth" id="MissTeeth123" value=""/>
<input type="hidden"  name="UnserTeeth" id="UnserTeeth123" value=""/>

<!--Bottom labels starts--> <!--main content placeholder ends here--> <script
	type="text/javascript">
function updateData(){

	submitForm('medicalBoardExaminationAnnual','medicalExam?method=updateMedicalExamEntry&Labresult=<%=Labresult %>');
	if(document.getElementById('admissionStatus').checked){
	submitForm('medicalBoardExaminationAnnual','opd?method=showOPDMainJsp&visitId=<%=visit.getId() %>&token=<%=visit.getTokenNo()%>&deptId=<%=departmentId%>');
	}
}

function openPopupForSpecialistOpinionForward(visitId,medExamId){
	//document.getElementById('specialistOpinionForward').style.display='none';
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
	        var msg  = item.getElementsByTagName("msg")[0];
			//if(msg.childNodes[0]!='undefined'){
				alert(msg.childNodes[0].nodeValue);
				document.getElementById('fstatus').value='s'
		//	}

      	}
      }
    }
    var url="/hms/hms/medicalExam?method=forwardMedExamSpecialOpinion&visitId="+visitId+"&flagForward=s&medExamId="+medExamId;   
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
//   newwindow=window.open(url,'mbSpecialistOpinion','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}


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
function openPopupForImmunization(){
	 newwindow = window.open('/hms/hms/registration?method=openPopupForImmunization&hinId='+document.getElementById('hinId').value+'&flag=medicalExam','windowRef','width=1000,height=400,scrollbars = yes');
}

function openPopupForAllergies(){
	 newwindow = window.open('/hms/hms/registration?method=openPopupForAllergies&hinId='+document.getElementById('hinId').value+'&flag=medicalExam','allergy','width=1000,height=400,scrollbars = yes');
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
function fileUploadForSpecialistOpinion()
{

	 var medicalExamId='<%=medExamId%>';
	 	if(medicalExamId=='0')
	 	{
	 	 	alert("file can not be uploaded; first submit form then upload the file");
	 	 	return false;
	 	}else
	 	{

			var folderName='specialistOpinion';
				var url="/hms/hms/medicalExam?method=displayFileUpload&hinId=<%=visit.getHin().getId()%>&visitId=<%=visit.getId()%>&hinNo=<%=visit.getHin().getHinNo()%>&folder="+folderName+"&masExamId=<%=medExamId%>";;

				newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
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


function CheckAlpha()
{

    var txt=document.getElementById('txtAlpha');
    var filter=/^[a-zA-Z]+$/;
    var test_bool = filter.test(txt.value);
    if (test_bool==false)
    {
        alert('Please Enter Only Alphabets');
        txt.focus();
        return false;
    }
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

				submitProtoAjaxWithDivName('medicalBoardExaminationAnnual','/hms/hms/opd?method=showGridForInvestigation&flag=Exam','gridview');

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
	  e1.name = 'result1' + iteration;
	  e1.id = 'result1' + iteration;
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

	   var e3= row.insertCell(3)
	   e3.type='hidden';
	   var e3 = document.createElement('hidden');
	   e3.setAttribute('tabindex','1');
	   cellRight1.appendChild(e3);

	 var cellRight1 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'button';
	  e4.className = 'buttonAdd';
	  e4.name='Button';
	  e4.setAttribute('onClick','addRowForInvestigation();');
	  cellRight1.appendChild(e4);

	  var cellRight2 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'button';
	  e5.className = 'buttonDel';
	  e5.name='delete';
	  e5.setAttribute('onClick','removeRowForInvestigation();');
	  cellRight2.appendChild(e5);

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
	  document.getElementById('investigationDataStatus').value="yes";
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

	  var pid = document.getElementById('patientInvestigationdetailsId'+lastRow ).value;

      var dv=document.getElementById('deleatedValue').value;
      var val;

      if(dv=="")
      {

    	  val=pid+",";
	  document.getElementById('deleatedValue').value = val;
      }else{
    	  val=dv+pid+","
    	  document.getElementById('deleatedValue').value = val;
      }

	  var pid1 = document.getElementById('dgOrderdtId'+lastRow ).value;

      var dv1=document.getElementById('deleatedorderid').value;
      var val1;

      if(dv1=="")
      {

    	  val1=pid1+",";
	  document.getElementById('deleatedorderid').value = val1;
      }else{
    	  val1=dv1+pid1+","
    	  document.getElementById('deleatedorderid').value = val1;
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

 function addRowForImmunization()
 {

	  var tbl = document.getElementById('immunizationGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenImmunizationValue');
	  hdb.value=iteration
	  // alert("iteration row--"+iteration)
     var cellRight1 = row.insertCell(0);
	 var e1 = document.createElement('input');
	 e1.type = 'text';
	 e1.name = 'giveon' + iteration;
	 e1.id = 'giveon' + iteration;
     e1.className = 'date';
     e1.setAttribute('maxlength', 10);
	 e1.setAttribute('tabindex','1');
     cellRight1.appendChild(e1);
   //  var cellRight1 = row.insertCell(0);
	  var e2 = document.createElement('img');
	  e2.src = '/hms/jsp/images/cal.gif';
	  // e3.style.display ='none';
	  e2.id = 'calId'+iteration;
	  e2.onclick = function(event){
	  setdate('',document.getElementById('giveon'+iteration),event) };
	  cellRight1.appendChild(e2);

      var cellRight3 = row.insertCell(1);
	  var e3 = document.createElement('input');
 	  e3.type = 'text';
	  e3.name = 'batchNo' + iteration;
	  e3.id = 'batchNo' + iteration;
      e3.size = '20';
      e3.setAttribute('maxlength', 10);
	  e3.setAttribute('tabindex','1');
      cellRight3.appendChild(e3);

      var cellRight4 = row.insertCell(2);
 	  var e4 = document.createElement('input');
 	  e4.type = 'text';
 	  e4.name = 'dom' + iteration;
 	  e4.id = 'dom' + iteration;
      e4.className = 'date';
      e4.setAttribute('maxlength', 10);
 	  e4.setAttribute('tabindex','1');
      cellRight4.appendChild(e4);
    //  var cellRight1 = row.insertCell(0);
 	  var e41 = document.createElement('img');
 	  e41.src = '/hms/jsp/images/cal.gif';
 	  // e3.style.display ='none';
 	  e41.id = 'calId'+iteration;
 	  e41.onclick = function(event){
 	  setdate('',document.getElementById('dom'+iteration),event) };
 	  cellRight4.appendChild(e41);


	  var cellRight6 = row.insertCell(3);
		 var e6 = document.createElement('input');
		  e6.type = 'text';
		  e6.name = 'entryDate' + iteration;
		  e6.id = 'entryDate' + iteration;
	     e6.className = 'date';
	     e6.setAttribute('maxlength', 10);
		  e6.setAttribute('tabindex','1');
	     cellRight6.appendChild(e6);
	   //  var cellRight1 = row.insertCell(0);
		  var e61 = document.createElement('img');
		  e61.src = '/hms/jsp/images/cal.gif';
		  // e3.style.display ='none';
		  e61.id = 'calId'+iteration;
		  e61.onclick = function(event){
		  setdate('',document.getElementById('entryDate'+iteration),event) };
		  cellRight6.appendChild(e61);

		var cellRight7 = row.insertCell(4);
		var e7 = document.createElement('input');
		e7.type = 'button';
		e7.className = 'buttonAdd';
		e7.name='Button';
		e7.setAttribute('onClick','addRowForImmunization();');
		cellRight7.appendChild(e7);
        var cellRight8 = row.insertCell(5);
		var e8 = document.createElement('input');
		e8.type = 'button';
		e8.className = 'buttonDel';
		e8.name='delete';
		e8.setAttribute('onClick','removeRowForImmunization();');
		cellRight8.appendChild(e8);


	}
 function removeRowForImmunization()
	{
	  var tbl = document.getElementById('immunizationGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	  	tbl.deleteRow(lastRow - 1);
	  	var tbl = document.getElementById('immunizationGrid');
	  	var lastRow = tbl.rows.length;
		  // if there's no header row in the table, then iteration = lastRow + 1
	 	var iteration = lastRow - 1;
	  	var hdb = document.getElementById('hiddenImmunizationValue');
	  	hdb.value=iteration

	  }
	}


 function checkForChargeCode(val,inc,chargeCodeTdDiv,source){
	 //  alert("source--"+source);
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

			/*for(i=1;i<inc;i++){

				if(inc != 1){
					if(document.getElementById('chargeCodeName'+i).value==val) {
						alert("Test name already selected...!")
						if(source=="child")
						{

							newwindow.close();
						}
						document.getElementById('chargeCodeName'+inc).value=""
						var e=eval(document.getElementById('chargeCodeName'+inc));
						e.focus();

						return false;

					}
				}
			}*/
			//  alert("ok ");
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

 function fileUploadWindowInvestigation(rowVal)
 {

	 var medicalExamId='<%=medExamId%>';
	 	if(medicalExamId=='0')
	 	{
	 	 	alert("file can not be uploaded; refferred to MH");
	 	 	return false;
	 	}else{
	 		var val=document.getElementById('chargeCodeName'+rowVal).value;
	 	 	var index1 = val.lastIndexOf("[");
	 	 	var index2 = val.lastIndexOf("]");
	 	 	index1++;

	 	var invest_id = val.substring(index1,index2);
	 		var url="/hms/hms/medicalExam?method=displayFileUploadInvestigation&hinId=<%=visit.getHin().getId()%>&hinNo=<%=visit.getHin().getHinNo() %>&invest_id="+invest_id+"&masExamId=<%=medExamId%>";
	 		newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	 	}
 }
 function FileUploadWindow()
 {
	 var medicalExamId='<%=medExamId%>';
	 	if(medicalExamId=='0')
	 	{
	 	 	alert("file can not be uploaded; first submit form then upload the file");
	 	 	return false;
	 	}else
	 	{
		   var folderName='hearing';
			var url="/hms/hms/medicalExam?method=displayFileUpload&hinId=<%=visit.getHin().getId()%>&visitId=<%=visit.getId()%>&hinNo=<%=visit.getHin().getHinNo()%>&folder="+folderName+"&masExamId=<%=medExamId%>";

			newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	 	}

 }
 function FileUploadWindowGynaecology()
 {

	 var medicalExamId='<%=medExamId%>';
	 	if(medicalExamId=='0')
	 	{
	 	 	alert("file can not be uploaded; first submit form then upload the file");
	 	 	return false;
	 	}else
	 	{

			var folderName='gynaecology';
				var url="/hms/hms/medicalExam?method=displayFileUpload&hinId=<%=visit.getHin().getId()%>&visitId=<%=visit.getId()%>&hinNo=<%=visit.getHin().getHinNo()%>&folder="+folderName+"&masExamId=<%=medExamId%>";;

				newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
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
	//var dstr="";
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
 function coolDental1()
	{
	 alert("cool");
	 

	}
 function messingTeeth(mm)
 {

 	var name=document.getElementById(mm).name;

 	var mval=document.getElementById('MissTeeth123').value;
 	var uval=document.getElementById('UnserTeeth123').value;
 	if(name[0]=='m')
 	{
 		mval=mval+" "+name.substring(1,name.length).toUpperCase();
 		document.getElementById('MissTeeth123').value=mval;
 	}
 	if(name[0]=='u')
 	{
 		uval=uval+" "+name.substring(1,name.length).toUpperCase();
 		document.getElementById('UnserTeeth123').value=uval;
 	}
 }
 function openTemplateScreen(index){
 		var resultId = document.getElementById('resultIdTemplate'+index).value;
       // alert("resultId---"+resultId);
 	//	submitForm('medicalBoardExaminationAnnual','investigation?method=searchPatientForResultValidation&resultId='+resultId+'&flagForLab=fromLab');
       	var url="/hms/hms/investigation?method=searchPatientForResultValidation&resultId="+resultId+"&flagForLab=fromExam";
	    newwindow=window.open(url,'ar',"left=2,top=100,height=500,width=500,status=1,scrollbars=1,resizable=0");

 }
 function submitFormForPrescriptionReport(){
	  var hinNoForreport=document.getElementById('hinNoForreport').value;
      <%if(medExamObj.getVisit()!=null){%>
	  var url='/hms/hms/opd?method=showPatientInvestigationReport&visitNumberForReport='+<%=medExamObj.getVisit().getVisitNo()%>+'&hinNoForReport='+hinNoForreport+'&serviceNoForReport='+<%=medExamObj.getVisit().getHin().getServiceNo()%>;
      newwindow=window.open(url,'ar',"left=2,top=100,height=500,width=500,status=1,scrollbars=1,resizable=0");
	<%}%>
	}
function checkRemarks()
{
		var remarks=document.getElementById('remarks').value;
		if(remarks=='')
		{
		  alert("Please Enter the Remarks");
		   return false;
		}
		return true;
}
function checkForAdmissionSpecial()
{
	if(document.getElementById('specialistOpinion').checked == true ||
		document.getElementById('admissionStatus').checked == true){
		document.getElementById('finalObserv').disabled = true;
		document.getElementById('medCatRecId').disabled = true;
		//document.getElementById('remarks').disabled = true;
		document.getElementById('validateId').disabled = true;

	}else {
		document.getElementById('finalObserv').disabled = false;
		document.getElementById('medCatRecId').disabled = false;
		//document.getElementById('remarks').disabled = false;
		document.getElementById('validateId').disabled = false;
	}

}
function openOtherField(familyHistoryId){
	if(familyHistoryId == '8'){
		document.getElementById('otherFamilyHistoryDiv').style.display = 'block';
	}else{
	//	document.getElementById('familyHistoryId').style.display = 'none';
	}

}
function openPopupPatientPreviousVisit()
{
	var url="/hms/hms/medicalBoard?method=showPatientPreviousVisitForViewScreen&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>";
   	newwindow=window.open(url,'opdPatientPrevVisitForViewScreen','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}
function getPrevMedExamFromHIC()
{
	//var url="/hms/hms/medicalBoard?method=getPrevMedExamFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>";
	var url="/hms/hms/medicalBoard?method=getPrevMedExamFromHIC&serviceNo=<%=visit.getHin().getServiceNo() %>";
   	newwindow=window.open(url,'opd_previousVisitForMedicalExampVal','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}
function getPrevMedBoardFromHIC()
{
	var url="/hms/hms/medicalBoard?method=getPrevMedBoardFromHIC&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>";
   	newwindow=window.open(url,'opd_previousVisitForMedicalBoard','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}
function showPatientPreVisitHospitality()
{
	var url="/hms/hms/medicalBoard?method=showPatientPreVisitHospitality&visitId=<%=visit.getId()%>&visitNo=<%=visit.getVisitNo()%>&hinId=<%=visit.getHin().getId()%>&token=<%=visit.getTokenNo()%>";
   	newwindow=window.open(url,'opd_previousVisitForHospitality','left=0,top=0,height=800,width=1002,status=1,scrollbars=1,resizable=1');
}

function submitForInvestigationPrintOut()
{
	var orderNo=document.getElementById('dgOrderhdId').value;
	var flag="MO";
	var hinId= document.getElementById('hinId').value;
	if(orderNo!=null && orderNo!="" && hinId!=null && hinId!=""){
		submitFormForButton('medicalBoardExaminationAnnual','/hms/hms/investigation?method=printResultValidationLab&parent='+orderNo+'&hinId='+hinId+'&flag='+flag);
		}
}

//alert(document.getElementById('dentalValueId').value);
//alert(document.getElementById('hiddenValue').value);
coolDental();

</script></form>
</body>