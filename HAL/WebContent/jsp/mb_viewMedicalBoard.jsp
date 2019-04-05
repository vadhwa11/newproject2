<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<!--[if lt IE 9]>
        <link href="/hms/jsp/css/ie.css" rel="stylesheet" type="text/css" />
<![endif]-->

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
<%

Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
if(map.get("medExamList") != null){
	medExamList = (List<MasMedicalExaminationReportOnEntry>)map.get("medExamList");
}
MasMedicalExaminationReportOnEntry medExamObj = new MasMedicalExaminationReportOnEntry();

if(medExamList.size() > 0){
	medExamObj = medExamList.get(0);
}
List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = new ArrayList<MasMedicalExaminationDetail>();
if(map.get("masMedicalExaminationDetailList") != null){
	masMedicalExaminationDetailList = (List<MasMedicalExaminationDetail>)map.get("masMedicalExaminationDetailList");
} %>
<div class="titleBg">
<h2>MEDICAL BOARD OPINION</h2>
</div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<div class="Block">
<h4>Chronological List of the Disabilities <a href="javascript:animatedcollapse.toggle('slide14')"></a></h4>
<div class="clear"></div>
<div id="slide14">

	<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridIcdDisability">
	<tr>
		<th rowspan="2">Disability</TH>
		<TH rowspan="2">Date of Origin</TH>
		<TH rowspan="2">Rank of Indl</TH>
		<TH>Place</TH>
		<TH>Unit</TH>
	</tr>

	<tr>
		<th colspan="2">Where Serving at the Time</th>
	</tr>
	<% int inc=0;
	if(masMedicalExaminationDetailList!=null && masMedicalExaminationDetailList.size()>0)
	{
	for(MasMedicalExaminationDetail masMedicalExamDetails:masMedicalExaminationDetailList){
	if(masMedicalExamDetails.getPrincipal()!=null && masMedicalExamDetails.getParticular().equalsIgnoreCase("Cronical")){
		
			inc=inc+1;
			//int icdDisability=0;
			String icdCd="";
			String dateOfOrigin="";
			String rankDisablilty="";
			String placeServing="";
			int unitDisablilty=0;
		//	icdDisability=masMedicalExamDetails.getPrincipal();
			//if(masMedicalExamDetails.getSystemDiagnosis()!=null){
			if(masMedicalExamDetails.getMasIcd() !=null){
				icdCd=masMedicalExamDetails.getMasIcd().getIcdCode();
				//icdDisability=masMedicalExamDetails.getSystemDiagnosis().getId();
			}
			String disabilityStr="";
			disabilityStr=masMedicalExamDetails.getPrincipal()+"["+icdCd+"]";
			if(masMedicalExamDetails.getOrigindate()!=null){
				dateOfOrigin=HMSUtil.convertDateToStringTypeDateOnly(masMedicalExamDetails.getOrigindate());
			}
			if(masMedicalExamDetails.getRankDisability()!=null){
				rankDisablilty=masMedicalExamDetails.getRankDisability().getRankName();
			}
			if(masMedicalExamDetails.getUnitDisability()!=null){
				unitDisablilty=masMedicalExamDetails.getUnitDisability().getId();
			}
			if(masMedicalExamDetails.getPlaceDisability()!=null){
				placeServing=masMedicalExamDetails.getPlaceDisability();
			}
	%>
<tr>
<td>
<input type="text" readonly="readonly" abindex="1"	value="<%=disabilityStr%>" id="icdDisability<%=inc %>"   name="icdDisability<%=inc %>"	class="auto"  size="50" />
<input type="hidden" name="disablementServiceIdCronical<%=inc%>" value="<%=masMedicalExamDetails.getServiceid() %>" tabindex="1" readonly="readonly" />
	</td>
		<td>
			<input tabindex="1"  type="text" readonly="readonly"  value="<%=dateOfOrigin%>" name="<%=DATE_OF_ORIGIN+inc %>" maxlength="10" class="auto" size="11" id="dateOfOrigin<%=inc %>"/>
		</td>
		<td><input value="<%=rankDisablilty %>"/></td>
		<td>
		<input tabindex="1"  type="text" readonly="readonly"  value="<%=placeServing%>" name="placeServing<%=inc%>" id="placeServing<%=inc%>" maxlength="10" />
		</td>
		<td><input value="<%=unitDisablilty %>"/></td>
	</tr>
	<%
	}
	}
	}
	if(inc<=0){
	++inc;
	
	%>
<tr>
<td>
<input type="text" readonly="readonly" tabindex="1"	value="" id="icdDisability<%=inc %>"  name="icdDisability<%=inc %>"	class="auto"  size="50" />
<input type="hidden" name="disablementServiceIdCronical<%=inc%>" value="0" tabindex="1" readonly="readonly" />
	</td>
		<td>
			<input tabindex="1"  type="text"	readonly="readonly"  name="<%=DATE_OF_ORIGIN+inc %>" maxlength="10" class="auto" size="11" id="dateOfOrigin<%=inc %>"/>
		</td>
		<td><input name="rankDisablilty<%=inc%>" id="rankDisablilty<%=inc%>" tabindex="1" />
		</td>
		<td>
		<input tabindex="1"  type="text" readonly="readonly"  name="placeServing<%=inc%>" id="placeServing<%=inc%>" maxlength="10" />
		</td>
		<td><input name="unitDisablilty<%=inc%>" id="unitDisablilty<%=inc%>" tabindex="1" />
		</td>
	</tr>
	<%
	}
%>
		<input type="hidden" name="hdbIcdCronicalDisability" value="<%=inc%>" id="hdbIcdCronicalDisability" />
</table>
</div>
</div>
<div class="clear paddingTop15"></div>
<h4>Clinical Details</h4>
<div class="clear paddingTop15"></div>
<div class="Block">

<label>Relevant Family History</label>
<%
	String releventFamHis="";
	String specialistReport="";
	String treatment="";
	if(medExamObj.getRelevantFamilyHistory() !=null){
		releventFamHis=medExamObj.getRelevantFamilyHistory();
	}
	if(medExamObj.getSpecialistReport() !=null){
		specialistReport=medExamObj.getSpecialistReport();
	}
	if(medExamObj.getTreatment() !=null){
		treatment=medExamObj.getTreatment();
	}
%>
<input type="text" readonly="readonly"  name="<%=RELEVENT_FAMILY_HISTORY %>" VALUE="<%=releventFamHis %>" maxlength="100"/>

<label>Specialist Report</label>
<input type="text" readonly="readonly" name="<%=SPECIALIST_REPORT %>" VALUE="<%=specialistReport %>" maxlength="50"/>

<div class="clear"></div>

<label>Treatment</label>
<input type="text" readonly="readonly"  name="<%=TREATMENT%>" VALUE="<%=treatment %>" maxlength="50"/>

<label>Present Condition</label>
<%String presentConds="";
if(medExamObj.getPresentCondition() !=null){
	presentConds=medExamObj.getPresentCondition();}%>
<input type="text"  readonly="readonly" name="presentCondition" value="<%=presentConds%>"/>
</div>

<div class="clear paddingTop15"></div>
<h4>Casual Relationship of the Disability with Service Conditions or Otherwise</h4>
<div class="clear paddingTop15"></div>

<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid" width="100%">
<tr>
<th rowspan="2">Disability</th>
<th rowspan="2">Attributable to Service</th>
<th rowspan="2">Aggravated by Service</th>
<th rowspan="2">Not Connected with Service</th>
<th rowspan="2">Reason/Cause/Specific Condition</th>
<th colspan="2">Period in Service</th>
</tr>
<tr>
<th>From</th>
<th>To</th>
</tr>
<% 
int incDisability2=0;
/*
if(medExamObj.getMasmedicaldetail()!=null)
{
	for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
	*/	
	if(masMedicalExaminationDetailList!=null && masMedicalExaminationDetailList.size()>0)
	{
	for(MasMedicalExaminationDetail masMedicalExamDetails:masMedicalExaminationDetailList){
	
		if(masMedicalExamDetails.getParticular()!=null && masMedicalExamDetails.getParticular().equalsIgnoreCase("detail"))
	{
			incDisability2=incDisability2+1;
			String reasonCause="";
			String principal="";
			String fromServicePeriod="";
			String toServicePeriod="";
			if(masMedicalExamDetails.getReasonVariation()!=null){
				reasonCause=masMedicalExamDetails.getReasonVariation();
			}
			if(masMedicalExamDetails.getFromServicePeriod()!=null){
				fromServicePeriod=masMedicalExamDetails.getFromServicePeriod();
			}
			if(masMedicalExamDetails.getToServicePeriod()!=null){
				toServicePeriod=masMedicalExamDetails.getToServicePeriod();
			}
			if(masMedicalExamDetails.getPrincipal() !=null){
				principal=masMedicalExamDetails.getPrincipal();
			}
			if(masMedicalExamDetails.getMasIcd() !=null){
				principal=principal+"["+masMedicalExamDetails.getMasIcd().getIcdCode()+"]";
			}
			
	%>
<tr>
<td>
<input type="text" readonly="readonly"  name="disabilityService<%=incDisability2%>" value="<%=principal%>"	id="disabilityService"<%=incDisability2%> tabindex="1" class="auto" size="35" readonly="readonly"/>
<input type="hidden" name="disabilityServiceId<%=incDisability2%>" value="<%=masMedicalExamDetails.getServiceid() %>"	id="disabilityServiceId<%=incDisability2%>" tabindex="1" /></td>

<td><select disabled="disabled" name="attributService<%=incDisability2%>" id="attributService<%=incDisability2%>">
<%String attributeService="";
String aggravarteService="";
String NotConnectService="";
if(masMedicalExamDetails.getAttributeService() !=null){
	attributeService=masMedicalExamDetails.getAttributeService();
}
if(masMedicalExamDetails.getAggravarteService() !=null){
	aggravarteService=masMedicalExamDetails.getAggravarteService();
}
if(masMedicalExamDetails.getNotConnectService() !=null){
	NotConnectService=masMedicalExamDetails.getNotConnectService();
}

if(attributeService.equalsIgnoreCase("y")){ %>
<option value="n">No</option><option value="y" selected="selected">Yes</option>
<%}else if(attributeService.equalsIgnoreCase("n")){ %>
<option value="n" selected="selected">No</option><option value="y">Yes</option>
<%}else{ %><option value="n">No</option><option value="y">Yes</option><%} %>
</select>
<td><select disabled="disabled" name="aggravateService<%=incDisability2%>" id="aggravateService<%=incDisability2%>">
<%if(aggravarteService.equalsIgnoreCase("y")){ %>
<option value="n">No</option><option value="y" selected="selected">Yes</option>
<%}else if(aggravarteService.equalsIgnoreCase("n")){ %>
<option value="n" selected="selected">No</option><option value="y">Yes</option>
<%}else{ %><option value="n">No</option><option value="y">Yes</option><%} %>
</select>
</td>
<td><select disabled="disabled" name="notConnectedService<%=incDisability2%>" id="notConnectedService<%=incDisability2%>">
<%if(NotConnectService.equalsIgnoreCase("y")){ %>
<option value="n">No</option><option value="y" selected="selected">Yes</option>
<%}else if(NotConnectService.equalsIgnoreCase("n")){ %>
<option value="n" selected="selected">No</option><option value="y">Yes</option>
<%}else{ %><option value="n">No</option><option value="y">Yes</option><%} %>
</select>
</td>
<td><input type="text" readonly="readonly" name="reasonCause<%=incDisability2%>" maxlength="49" value="<%=reasonCause%>"/></td>
<td><input type="text" readonly="readonly" name="fromServicePeriod<%=incDisability2%>" value="<%=fromServicePeriod%>" maxlength="12" class="date" class="auto" size="11" tabindex="1"/></td>
<td><input type="text" readonly="readonly" name="toServicePeriod<%=incDisability2%>" value="<%=toServicePeriod%>" maxlength="12" class="date" class="auto" size="11" tabindex="1"/></td>
</tr>
<%}}}if(incDisability2<=0){
	++incDisability2;%>
	<tr>
<td>
<input type="text" readonly="readonly" name="disabilityService<%=incDisability2%>" value=""	id="disabilityService"<%=incDisability2%> tabindex="1" class="auto" size="35" readonly="readonly"/>
<input type="hidden" name="disabilityServiceId<%=incDisability2%>" value="" id="disabilityServiceId<%=incDisability2%>" tabindex="1" /></td>

<td><select disabled="disabled" name="attributService<%=incDisability2%>" id="attributService<%=incDisability2%>">
<option value="n">No</option><option value="y">Yes</option>
</select></td>
<td><select disabled="disabled" name="aggravateService<%=incDisability2%>" id="aggravateService<%=incDisability2%>">
<option value="n">No</option><option value="y">Yes</option></select></td>
<td><select disabled="disabled" name="notConnectedService<%=incDisability2%>" id="notConnectedService<%=incDisability2%>">
<option value="n">No</option><option value="y">Yes</option></select></td>
<td><input type="text" readonly="readonly" name="reasonCause<%=incDisability2%>" maxlength="49" value=""/></td>
<td><input type="text" readonly="readonly" name="fromServicePeriod<%=incDisability2%>" value="" maxlength="12" class="date" class="auto" size="11" tabindex="1"/></td>
<td><input type="text" readonly="readonly" name="toServicePeriod<%=incDisability2%>" value="" maxlength="12" class="date" class="auto" size="11" tabindex="1"/></td>
</tr>

<%} %>
<input type="hidden" name="hdbDisabilityService" value="<%=incDisability2%>" id="hdbDisabilityService" />
</table>
</div>
<div class="clear paddingTop15"></div>
<div class="clear paddingTop15"></div>

<div class="Block">
<%
String	existDisability="";
String	routineMedExam="";
String	persistMaterialPeriod="";
String	aggravMaterialPeriod="";
String	individualMisconduct="";
String	inWay="";
if(medExamObj.getDisabilitybefore()!=null){
	existDisability=medExamObj.getDisabilitybefore();
}
if(medExamObj.getMedExamCarryTime()!=null){
	routineMedExam=medExamObj.getMedExamCarryTime();
}
if(medExamObj.getDisableAggravPersist()!=null){
	persistMaterialPeriod=medExamObj.getDisableAggravPersist();
}
if(medExamObj.getAggravMaterialPeriod()!=null){
	aggravMaterialPeriod=medExamObj.getAggravMaterialPeriod();
}
if(medExamObj.getIndividualMisconduct()!=null){
	individualMisconduct=medExamObj.getIndividualMisconduct();
}
if(medExamObj.getInWay()!=null){
	inWay=medExamObj.getInWay();
}
String	aggravatedMisconduct="";
String	inWay2="";
String	totalDisablement="";
String	refuseOperationTreat="";
String	individualReason="";
String	reducDisablePension="";

if(medExamObj.getAggravatedMisconduct()!=null){
	aggravatedMisconduct=medExamObj.getAggravatedMisconduct();
}
if(medExamObj.getInWay2()!=null){
	inWay2=medExamObj.getInWay2();
}
if(medExamObj.getPercentageDisable()!=null){
	totalDisablement=medExamObj.getPercentageDisable();
}
if(medExamObj.getRefuseOperationTreat()!=null){
	refuseOperationTreat=medExamObj.getRefuseOperationTreat();
}
if(medExamObj.getIndividualReason()!=null){
	individualReason=medExamObj.getIndividualReason();
}
if(medExamObj.getReductionDisablePension()!=null){
	reducDisablePension=medExamObj.getReductionDisablePension();
}

String	reducDisablePensionEntry="";
String	operationTreatCured="";
String	operationTreatCuredEntry="";
String	percentageDisableTreatment="";
String	individualRefusalTratment="";
String	operaTreatmentRecommend="";

if(medExamObj.getReducDisablePensionEntry()!=null){
	reducDisablePensionEntry=medExamObj.getReducDisablePensionEntry();
}
if(medExamObj.getOperationTreatCured()!=null){
	operationTreatCured=medExamObj.getOperationTreatCured();
}
if(medExamObj.getOpernTreatCuredEntry()!=null){
	operationTreatCuredEntry=medExamObj.getOpernTreatCuredEntry();
}
if(medExamObj.getPercentageDisableTreatment()!=null){
	percentageDisableTreatment=medExamObj.getPercentageDisableTreatment();
}
if(medExamObj.getIndividualRefusalTratment()!=null){
	individualRefusalTratment=medExamObj.getIndividualRefusalTratment();
}
if(medExamObj.getOperaTreatmentRecommend()!=null){
	operaTreatmentRecommend=medExamObj.getOperaTreatmentRecommend();
}
%>
<label class="large3">Did the Disability exist before service</label>
<select disabled="disabled" id="existDisability" onchange="showHideExistDisability();" name="<%=EXIST_DISABILITY %>">
<option value="">Select</option>
<%if(existDisability.equalsIgnoreCase("y")){ %>
<option value="n">No</option>
<option value="y" selected="selected">Yes</option>
<%}else if(existDisability.equalsIgnoreCase("n")){ %>
<option value="n" selected="selected">No</option>
<option value="y">Yes</option><%}else{ %>
<option value="n">No</option>
<option value="y">Yes</option>
<%} %>
</select>
<%
if(existDisability.equalsIgnoreCase("y"))
{
	%>
	<div id="existDisabilityDiv" style="display: inline;">
  	<%
}else{
	%>
	<div id="existDisabilityDiv" style="display: none;">
  	<%
}
%>
<div class="clear"></div>

<label class="large3">Is it possible that it could not be detected during the routine medical examination carried out at the time of the entry</label>
<select disabled="disabled" name="<%=ROUTINE_MED_EXAM %>" id="routineMedExam">
<%if(routineMedExam.equalsIgnoreCase("y")){ %>
<option value="n">No</option>
<option value="y" selected="selected">Yes</option>
<%}else if(routineMedExam.equalsIgnoreCase("n")){ %>
<option value="n" selected="selected">No</option>
<option value="y">Yes</option><%}else{ %>
<option value="n">No</option>
<option value="y">Yes</option>
<%} %></select>
</div>
<label class="large3">In case of disability awarded Aggravation, whether the effects of such aggravation will persist</label>
<select disabled="disabled" name="<%=PERSIST_MATERIAL_PERIOD %>" id="persistMaterialPeriod">
<option value="">Select</option>
<%if(persistMaterialPeriod.equalsIgnoreCase("y")){ %>
<option value="n">No</option>
<option value="y" selected="selected">Yes</option>
<%}else if(persistMaterialPeriod.equalsIgnoreCase("n")){ %>
<option value="n" selected="selected">No</option>
<option value="y">Yes</option><%}else{ %>
<option value="n">No</option>
<option value="y">Yes</option>
<%} %>
</select>
<div class="clear"></div>

<label class="large3">Whether the effects of aggravation will persist for a material period</label>
<select disabled="disabled" name="<%=AGGRA_MATERIAL_PERIOD %>" id="aggravMaterialPeriod">
<option value="">Select</option>
<%if(aggravMaterialPeriod.equalsIgnoreCase("y")){ %>
<option value="n">No</option>
<option value="y" selected="selected">Yes</option>
<%}else if(aggravMaterialPeriod.equalsIgnoreCase("n")){ %>
<option value="n" selected="selected">No</option>
<option value="y">Yes</option><%}else{ %>
<option value="n">No</option>
<option value="y">Yes</option>
<%} %>
</select>
<div class="clear"></div>

<label class="large3">Was the Disability attributable to the Individual's own negligence or misconduct</label>
<select disabled="disabled" id="individualMisconduct" onchange="showHideDisabilityAttribute();" name="<%=INDIVIDUAL_MISCONDUCT %>">
<option value="">Select</option>
<%if(individualMisconduct.equalsIgnoreCase("y")){ %>
<option value="n">No</option>
<option value="y" selected="selected">Yes</option>
<%}else if(individualMisconduct.equalsIgnoreCase("n")){ %>
<option value="n" selected="selected">No</option>
<option value="y">Yes</option><%}else{ %>
<option value="n">No</option>
<option value="y">Yes</option>
<%} %>
</select>
<%
if(individualMisconduct.equalsIgnoreCase("y"))
{
	%>
	<div id="disabilityAttributeDiv" style="display: inline;">
  	<%
}else{
	%>
	<div id="disabilityAttributeDiv" style="display: none;">
  	<%
}
%>
<div class="clear"></div>

<label class="large3">In What Way</label>
<input type="text" readonly="readonly" name="<%=IN_WAY %>" maxlength="50" value="<%=inWay%>" />
</div>

<label class="large3">Was it Aggravated by Negligence of Misconduct</label>
<select disabled="disabled" id="aggravatedMisconduct" onchange="showHideAggravated();" name="<%=AGGRAVATED_MISCONDUCT %>">
<option value="">Select</option>
<%if(aggravatedMisconduct.equalsIgnoreCase("y")){ %>
<option value="n">No</option>
<option value="y" selected="selected">Yes</option>
<%}else if(aggravatedMisconduct.equalsIgnoreCase("n")){ %>
<option value="n" selected="selected">No</option>
<option value="y">Yes</option><%}else{ %>
<option value="n">No</option>
<option value="y">Yes</option>
<%} %>
</select>
<%
if(aggravatedMisconduct.equalsIgnoreCase("y"))
{
	%>
	<div id="aggravatedMisconductDiv" style="display: inline;">
  	<%
}else{
	%>
	<div id="aggravatedMisconductDiv" style="display: none;">
  	<%
}
%>
<div class="clear"></div>
<label>In What Way</label>
<input type="text" readonly="readonly" name="<%=IN_WAY2 %>" maxlength="50"  value="<%=inWay2%>" class="autoArial" size="79" />

<label class="auto">Percentage of the Total Disablement</label>
<input type="text" readonly="readonly"  name="<%=TOTAL_DISABLEMENT %>" id="totalDisablement" value="<%=totalDisablement %>" maxlength="9"/>
</div>
<div class="clear"></div>
<label class="large3">Has the Individual refused to undergo Operation/ Treatment</label>
<select disabled="disabled" id="refuseOperationTreat" onchange="showHideUndergoOperation();" name="<%=REFUSE_OPER_TREATMENT %>">
<option value="">Select</option>
<%if(refuseOperationTreat.equalsIgnoreCase("y")){ %>
<option value="n">No</option>
<option value="y" selected="selected">Yes</option>
<%}else if(refuseOperationTreat.equalsIgnoreCase("n")){ %>
<option value="n" selected="selected">No</option>
<option value="y">Yes</option><%}else{ %>
<option value="n">No</option>
<option value="y">Yes</option>
<%} %>
</select>
<%
if(refuseOperationTreat.equalsIgnoreCase("y"))
{
	%>
	<div id="refuseOperationTreatDiv" style="display: inline;">
  	<%
}else{
	%>
	<div id="refuseOperationTreatDiv" style="display: none;">
  	<%
}
%>
<div class="clear"></div>

<label>Individual's Reason</label>
<input type="text" readonly="readonly" name="individualReason" value="<%=individualReason%>" class="autoArial" size="123" />
<input type="button" name="upload" class="buttonBig" value="Upload Certificate" onClick="javascript:fileUploadViewWindow('CER');" />

</div>
<label class="large3">Has the effect of refusal been explained to and fully understood by him/her. Viz, a reduction in, or the entire withholding of any  disability pension to which he/she might otherwise might be entitled</label>
<select disabled="disabled" id="reducDisablePension" onchange="showHideRefusal();" name="<%=REDUCTION_DISABLE_PENSION %>">
<option value="">Select</option>
<%if(reducDisablePension.equalsIgnoreCase("y")){ %>
<option value="n">No</option>
<option value="y" selected="selected">Yes</option>
<%}else if(reducDisablePension.equalsIgnoreCase("n")){ %>
<option value="n" selected="selected">No</option>
<option value="y">Yes</option><%}else{ %>
<option value="n">No</option>
<option value="y">Yes</option>
<%} %>
</select>
<%
if(reducDisablePension.equalsIgnoreCase("y"))
{
	%>
	<div id="reducDisablePensionDiv" style="display: inline;">
  	<%
}else{
	%>
	<div id="reducDisablePensionDiv" style="display: none;">
  	<%
}
%>
<input type="text" readonly="readonly" name="<%=REDUC_DISABLE_PENSION_ENTRY %>" value="<%=reducDisablePensionEntry%>" maxlength="50"/>
</div>
<div class="clear"></div>
<label class="large3">Does the Medical Board consider it probable that the Operation/ Treatement would have cured the disability or reduced it's percentage</label>
<select disabled="disabled" name="<%=OPERATION_TREAT_CURED %>" id="operationTreatCured">
<option value="">Select</option>
<%if(operationTreatCured.equalsIgnoreCase("a")){ %>
<option value="a" selected="selected">Affirmative</option>
<option value="n">Negative</option><%}else if(operationTreatCured.equalsIgnoreCase("n")){ %>
<option value="a" >Affirmative</option>
<option value="n" selected="selected">Negative</option>
<%}else{ %>
<option value="a">Affirmative</option>
<option value="n">Negative</option>
<%} %>
</select>
<input type="text" readonly="readonly" name="<%=OPERATION_TREAT_CURED_ENTRY %>" maxlength="50" value="<%=operationTreatCuredEntry%>"/>

<label class="large3">What is the probable percentage to which the disablement could be reduced by Operation/ Treatement</label>
<input type="text" readonly="readonly" name="<%=PERCENTAGE_DISABLE_TREAT %>" value="<%=percentageDisableTreatment %>" maxlength="50"/>

<label class="large3">Does the Medical Board consider individual's refusal to submit to operation/ Treatment reasonable</label>
<select disabled="disabled" id="individualRefusalTratment" onchange="showHideOperationTreatment();" name="<%=PERCENTAGE_REFUSAL_TREAT %>">
<option value="">Select</option>
<%if(individualRefusalTratment.equalsIgnoreCase("y")){ %>
<option value="n">No</option>
<option value="y" selected="selected">Yes</option>
<%}else if(individualRefusalTratment.equalsIgnoreCase("n")){ %>
<option value="n" selected="selected">No</option>
<option value="y">Yes</option><%}else{ %>
<option value="n">No</option>
<option value="y">Yes</option>
<%} %>
</select>
<%
if(individualRefusalTratment.equalsIgnoreCase("y"))
{
	%>
	<div id="individualRefusalTratmentDiv" style="display: inline;">
  	<%
}else{
	%>
	<div id="individualRefusalTratmentDiv" style="display: none;">
  	<%
}
%>

<div class="clear"></div>
<label class="large3">Give reason in support of the opinion specifing the Operation/ Treatment recommended</label>
<textarea rows="" cols="" name="<%=OPERA_TREAT_RECOMMEND %>"  onkeyup="chkLength(this,50);"><%=operaTreatmentRecommend%></textarea>
</div>

</div>
<div class="clear paddingTop15"></div>
<h4>What is present degree of disablement as compared with a healthy person of the same age and gender</h4>
<div class="clear paddingTop15"></div>

<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">

<tr>
<th >Disability</th>
<th>Percentage of <br> Disablement</th>
<th colspan="2">Duration</th>
<th >Composite Assessment for <br /> all Disability (Max 100%)</th>
<th colspan="">Disability qualifying for <br />disability pension</th>
<th colspan="2">Duration</th>
<th colspan="">Net Assessement qualifying for <br> Disability Pension (Max 100%)</th>
<th colspan="2">Duration</th> 
</tr>

<% 
int incDisability3=0;
/*
if(medExamObj.getMasmedicaldetail()!=null)
{
	for(MasMedicalExaminationDetail setMedicalExam:medExamObj.getMasmedicaldetail()){
		*/
		if(masMedicalExaminationDetailList!=null && masMedicalExaminationDetailList.size()>0)
		{
		for(MasMedicalExaminationDetail masMedicalExamDetails:masMedicalExaminationDetailList){
		
		if(masMedicalExamDetails.getParticular()!=null && masMedicalExamDetails.getParticular().equalsIgnoreCase("detail"))
	{
			incDisability3=incDisability3+1;
			
			String percenDisablement="";
			String disablementYear="";
			String disablementMonth="";
			String compositeAssessment="";
			String disablityPension="";
			String disablityPensionYear="";
			String disablityPensionMonth="";
			String netAssessment="";
			String netAssessmentYear="";
			String netAssessmentMonth="";
			if(masMedicalExamDetails.getDisablementPercentage()!=null){
				percenDisablement=masMedicalExamDetails.getDisablementPercentage();
			}
			if(masMedicalExamDetails.getDisablementYear()!=null){
				disablementYear=masMedicalExamDetails.getDisablementYear();
			}
			if(masMedicalExamDetails.getDisablementMonth()!=null){
				disablementMonth=masMedicalExamDetails.getDisablementMonth();
			}
			if(masMedicalExamDetails.getDisablityCompositeAssessment()!=null){
				compositeAssessment=masMedicalExamDetails.getDisablityCompositeAssessment();
			}
			if(masMedicalExamDetails.getDisablityPension()!=null){		
				disablityPension=masMedicalExamDetails.getDisablityPension();
			}
			if(masMedicalExamDetails.getDisablityPensionYear()!=null){		
				disablityPensionYear=masMedicalExamDetails.getDisablityPensionYear();
			}
			if(masMedicalExamDetails.getDisablityPensionMonth()!=null){
				disablityPensionMonth=masMedicalExamDetails.getDisablityPensionMonth();
			}
			if(masMedicalExamDetails.getDisablityNetAssessment()!=null){
				netAssessment=masMedicalExamDetails.getDisablityNetAssessment();
			}
			if(masMedicalExamDetails.getDisablityAssessmentYear()!=null){
				netAssessmentYear=masMedicalExamDetails.getDisablityAssessmentYear();
			}
			if(masMedicalExamDetails.getDisablityAssessmentMonth()!=null){
				netAssessmentMonth=masMedicalExamDetails.getDisablityAssessmentMonth();
			}
			String principal2="";
			if(masMedicalExamDetails.getPrincipal() !=null){
				principal2=masMedicalExamDetails.getPrincipal();
			}
			if(masMedicalExamDetails.getMasIcd() !=null){
				principal2=principal2+"["+masMedicalExamDetails.getMasIcd().getIcdCode()+"]";
			}
	%>
	<tr>
<td><input type="text"	readonly="readonly"  name="disablementService<%=incDisability3%>" value="<%=principal2 %>" tabindex="1" class="auto" size="35" readonly="readonly" />
<input type="hidden" name="disablementServiceId<%=incDisability3%>" value="<%=masMedicalExamDetails.getServiceid() %>" tabindex="1" readonly="readonly" /><br/></td>

<td><input type="text" readonly="readonly" value="<%=percenDisablement%>" name="percenDisablement<%=incDisability3%>" id="percenDisablement<%=incDisability3%>" maxlength="50" tabindex="1" size="2"/></td>
<td><input type="text" readonly="readonly" value="<%=disablementYear%>" name="disablementYear<%=incDisability3%>" id="disablementYear<%=incDisability3%>" class="auto" size="2" maxlength="5" tabindex="1"/><label>Years</label></td>
<td><input type="text" readonly="readonly" value="<%=disablementMonth%>"  name="disablementMonth<%=incDisability3%>" id="disablementMonth<%=incDisability3%>" class="auto" size="2" maxlength="5" tabindex="1"/>Months</td>

<td><input type="text" readonly="readonly" value="<%=compositeAssessment%>"  name="compositeAssessment<%=incDisability3%>" id="compositeAssessment<%=incDisability3%>" maxlength="50" size="3" tabindex="1"/> </td>
<td><input maxlength="50" type="text" readonly="readonly" value="<%=disablityPension%>"  tabindex="1" maxlength="5" name="disablityPension<%=incDisability3%>" id="disablityPension<%=incDisability3%>"></td>
<td><input type="text" readonly="readonly" value="<%=disablityPensionYear%>"  name="disablityPensionYear<%=incDisability3%>" id="disablityPensionYear<%=incDisability3%>" class="auto" size="3" maxlength="5" tabindex="1"/>Years</td>
<td><input type="text" readonly="readonly" value="<%=disablityPensionMonth%>"  name="disablityPensionMonth<%=incDisability3%>" name="disablityPensionMonth<%=incDisability3%>" class="auto" size="3" maxlength="5" tabindex="1"/>Months</td>

<td><input type="text" readonly="readonly" value="<%=netAssessment%>"  name="netAssessment<%=incDisability3%>" id="netAssessment<%=incDisability3%>" maxlength="50" tabindex="1"/></td>

<td><input type="text" readonly="readonly" value="<%=netAssessmentYear%>"  name="netAssessmentYear<%=incDisability3%>" id="netAssessmentYear<%=incDisability3%>" class="auto" size="2" maxlength="5" tabindex="1" />Years</td>
<td><input type="text" readonly="readonly" value="<%=netAssessmentMonth%>"  name="netAssessmentMonth<%=incDisability3%>" id="netAssessmentMonth<%=incDisability3%>" class="auto" size="2" maxlength="5" tabindex="1" />Months</td>
</tr>
<%} } }if(incDisability3 <=0){
	++incDisability3;%>

	<tr>
<td><input type="text"	readonly="readonly" name="disablementService<%=incDisability3%>" value="" tabindex="1" class="auto" size="40" readonly="readonly" />
<input type="hidden" name="disablementServiceId<%=incDisability3%>" value="" tabindex="1" readonly="readonly" /><br/></td>
<td><input type="text" readonly="readonly" value="" name="percenDisablement<%=incDisability3%>" id="percenDisablement<%=incDisability3%>" maxlength="50" tabindex="1" size="5"/></td>
<td><input type="text" readonly="readonly" value="" name="disablementYear<%=incDisability3%>" id="disablementYear<%=incDisability3%>" class="auto" size="2" maxlength="5" tabindex="1"/><label>Years</label></td>
<td><input type="text" readonly="readonly" value=""  name="disablementMonth<%=incDisability3%>" id="disablementMonth<%=incDisability3%>" class="auto" size="2" maxlength="5" tabindex="1"/>Months</td>

<td><input type="text" readonly="readonly" value=""  name="compositeAssessment<%=incDisability3%>" id="compositeAssessment<%=incDisability3%>" maxlength="50" size="3" tabindex="1"/> </td>
<td><input maxlength="50" type="text" value=""  tabindex="1" maxlength="5" name="disablityPension<%=incDisability3%>" id="disablityPension<%=incDisability3%>"></td>
<td><input type="text" readonly="readonly" value=""  name="disablityPensionYear<%=incDisability3%>" id="disablityPensionYear<%=incDisability3%>" class="auto" size="2" maxlength="5" tabindex="1"/>Years</td>
<td><input type="text" readonly="readonly" value=""  name="disablityPensionMonth<%=incDisability3%>" name="disablityPensionMonth<%=incDisability3%>" class="auto" size="2" maxlength="5" tabindex="1"/>Months</td>

<td><input type="text" readonly="readonly" value=""  name="netAssessment<%=incDisability3%>" id="netAssessment<%=incDisability3%>" maxlength="50" tabindex="1"/></td>

<td><input type="text" readonly="readonly" value=""  name="netAssessmentYear<%=incDisability3%>" id="netAssessmentYear<%=incDisability3%>" class="auto" size="2" maxlength="5" tabindex="1" />Years</td>
<td><input type="text" readonly="readonly" value=""  name="netAssessmentMonth<%=incDisability3%>" id="netAssessmentMonth<%=incDisability3%>" class="auto" size="2" maxlength="5" tabindex="1" />Months</td>
</tr>
<%} %>
<input type="hidden" name="hdbDisabilityPresent" value="<%=incDisability3 %>" id="hdbDisabilityPresent" />
</table>
</div>

<div class="clear paddingTop15"></div>
<%
String individualTreatment="y";
String individualNature="";
String treatmentYear="";
String treatmentMonth="";
String individualAttendent="";
String attendentYear="";
String attendentMonth="";
String flcDate="";
String medBoardOpinion="";


if(medExamObj.getIndividual_further_tratment()!=null){
	individualTreatment=medExamObj.getIndividual_further_tratment();
}
if(medExamObj.getIndividualNature()!=null){
	individualNature=medExamObj.getIndividualNature();
}
if(medExamObj.getTreatmentYear()!=null){
	treatmentYear=medExamObj.getTreatmentYear();
}
if(medExamObj.getTreatmentMonth()!=null){
	treatmentMonth=medExamObj.getTreatmentMonth();
}
if(medExamObj.getIndividualAttendent()!=null){
	individualAttendent=medExamObj.getIndividualAttendent();
}
if(medExamObj.getAttendentYear()!=null){
	attendentYear=medExamObj.getAttendentYear();
}
if(medExamObj.getAttendentMonth()!=null){
	attendentMonth=medExamObj.getAttendentMonth();
}

if(medExamObj.getFlcDate()!=null){
	flcDate=HMSUtil.convertDateToStringTypeDateOnly(medExamObj.getFlcDate());
}
if(medExamObj.getOpinion()!=null){
	medBoardOpinion=medExamObj.getOpinion();
}

%>

<div class="Block">
<label class="large3">Is the Individual in need of further treatment</label>
<select disabled="disabled" id="individualTreatment" name="<%=INDIVIDUAL_FURTHER_TREAT %>" onchange="showHideIndividualTreatment();">
<option value="">Select</option>
<%if(individualTreatment.equalsIgnoreCase("y")){ %>
<option value="n">No</option>
<option value="y" selected="selected">Yes</option>
<%}else if(individualTreatment.equalsIgnoreCase("n")){ %>
<option value="n" selected="selected">No</option>
<option value="y">Yes</option><%}else{ %>
<option value="n">No</option>
<option value="y">Yes</option>
<%} %>
</select>
<div class="clear"></div>
<div id="individualTreatmentDiv" style="display: inline;">
<label>What Nature</label>
<input type="text" readonly="readonly" name="<%=INDIVIDUAL_NATURE%>" maxlength="50" value="<%=individualNature%>"/>
<label>How long Required</label>
<input type="text" readonly="readonly" class="auto" size="16" name="<%=TREATMET_YEAR %>" value="<%=treatmentYear %>"/><label class="unit">Year(s)</label>
<input type="text" readonly="readonly" class="auto" size="16" name="<%=TREATMET_MONTH %>" value="<%=treatmentMonth%>" /><label class="auto">Month(s)</label>
</div>
<label class="large3">Does the individual require an attendent</label>
<select disabled="disabled" name="<%=INDIVIDUAL_ATTENDENT %>" id="individualAttendent" onchange="showHideIndividualAttendent();">
<option value="">Select</option>
<%if(individualAttendent.equalsIgnoreCase("y")){ %>
<option value="n">No</option>
<option value="y" selected="selected">Yes</option>
<%}else if(individualAttendent.equalsIgnoreCase("n")){ %>
<option value="n" selected="selected">No</option>
<option value="y">Yes</option><%}else{ %>
<option value="n">No</option>
<option value="y">Yes</option>
<%} %>
</select>
<div class="clear"></div>
<%
if(individualAttendent.equalsIgnoreCase("y"))
{
	%>
	<div id="individualAttendentDiv" style="display: inline;">
  	<%
}else{
	%>
	<div id="individualAttendentDiv" style="display: none;">
  	<%
}
%>

<label>How long Required</label>
<input type="text" readonly="readonly" class="auto" name="<%=ATTENDENT_YEAR %>" value="<%=attendentYear%>"/><label class="unit">Year(s)</label>
<input type="text" readonly="readonly" class="auto" name="<%=ATTENDENT_MONTH %>" value="<%=attendentMonth%>"/><label class="auto">Month(s)</label>
</div>
</div>

<div class="clear paddingTop15"></div>
<div class="clear paddingTop15"></div>

<div class="Block">

<label class="large">Invalidment/ Realease in Medical Category</label>
<%if(medExamObj.getReleaseMedCatValue() !=null){ %>
<input type="hidden" class="large" name="<%=INVALID_RELEASE_MED_CAT %>" value="<%=medExamObj.getReleaseMedCatValue() %>" readonly="readonly"/>
<%}else{ %><input type="hidden" class="large" name="<%=INVALID_RELEASE_MED_CAT %>" readonly="readonly"/><%} %>

<%if(medExamObj.getMedCatRelease() !=null){ %>
<input type="text" name="<%=INVALIDMENT_RELEASE_MED_CAT %>" value="<%=medExamObj.getMedCatRelease().getCategories() %>" readonly="readonly"/>
<%}else{%>
<input type="text" name="<%=INVALIDMENT_RELEASE_MED_CAT %>" value=""/><%} %>
<div class="clear"></div>

<label class="large">Medical Board Opinion</label>
<input type="text" readonly="readonly" class="large" name="<%=MED_BOARD_OPINION %>" value="<%=medBoardOpinion %>"/>

<div class="clear"></div>

<label>Member 1</label>
<%
String member1="";

if(medExamObj.getMedDetailMember1() !=null){
	member1=medExamObj.getMedDetailMember1().getFirstName();
	if(medExamObj.getMedDetailMember1().getLastName() !=null){
		member1=member1+" "+medExamObj.getMedDetailMember1().getLastName();
	}
	%>

<input name="member1" id="member1"	tabindex="1"value="<%=member1 %>" /><%}else{ %>
<input name="member1" id="member1"	tabindex="1" /><%} %>


<label>Member2</label>
<%
String member2="";

if(medExamObj.getMedDetailMember1() !=null){
	member2=medExamObj.getMedDetailMember1().getFirstName();
	if(medExamObj.getMedDetailMember1().getLastName() !=null){
		member2=member2+" "+medExamObj.getMedDetailMember1().getLastName();
	}
	%>

<input name="member1" id="member2"	tabindex="1"value="<%=member2 %>" /><%}else{ %>
<input name="member1" id="member2"	tabindex="1" /><%} %>

<label class="auto">Signature of President</label>
<%
String president="";

if(medExamObj.getMedDetailPresident() !=null){
	president=medExamObj.getMedDetailPresident().getFirstName();
	if(medExamObj.getMedDetailPresident().getLastName() !=null){
		president=president+" "+medExamObj.getMedDetailPresident().getLastName();
	}
	%>
<input name="president" id="president" value="<%=president %>"	tabindex="1" /><%}else{ %>
<input name="president" id="president"	tabindex="1" />
<%} %>

</div>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<div class="clear"></div>
<input type="button" name="Close" value="Close" class="button" onclick="window.close()" tabindex="1" />


<script>
function fileUploadViewWindow(flag)
{
	var url="/hms/hms/medicalBoard?method=viewUploadDocuments&visitId=<%=medExamObj.getVisit().getId()%>&medExamId=<%=medExamObj.getId()%>&flag="+flag;
	newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");

}


</script>