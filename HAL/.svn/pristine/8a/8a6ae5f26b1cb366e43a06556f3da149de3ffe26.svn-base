
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MbTypeOfEntryMaster"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>


<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgMasCollection"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%><script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>

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


<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<MbTypeOfEntryMaster> typeOfEntryMasterList = new ArrayList<MbTypeOfEntryMaster>();
List<MasUnit> masUnitList = new ArrayList<MasUnit>();
List<MasMaritalStatus> masMaritalStatusList = new ArrayList<MasMaritalStatus>();
List<MasRank> masRankList1 = new ArrayList<MasRank>();

List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();

try{
if(map.get("resultList") != null){
	resultList=(List)map.get("resultList");

	}
}catch(Exception e){
	e.printStackTrace();
}
String deptType="";
if(session.getAttribute("deptType") != null){
	deptType = (String)session.getAttribute("deptType");
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
}
%>
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
<div class="titleBg">
<h2>Primary Medical Examination Report(AFMSF-2A)</h2>
</div>
<div class="clear"></div>
<form name="medExamPrimaryMD" action="" method="post">
<!--Block One Starts-->
<div class="Block">
<input type="hidden" name="medExamId" value="<%=medExamObj.getId() %>"/>
<input type="hidden" name="flag" value="md"/>
<label>Service Number </label>
 <% if(medExamObj.getServiceNo()!=null){%>
 <input type="text"	 name="<%=SERVICE_NO %>" tabindex="2" value="<%=medExamObj.getServiceNo() %>"/>
 <% }else{%>
 <input type="text"	 name="<%=SERVICE_NO %>" tabindex="2" />
 <% }%>
 <label>Rank  </label>
  <% if(medExamObj.getRank()!=null){%>
 <input type="text"	 name="<%=RANK %>" tabindex="2" value="<%=medExamObj.getRank().getRankName() %>"/>
 <input type="hidden" value="<%=medExamObj.getRank().getId() %>" name="<%=RANK_ID%>"	tabindex="2" />
 <% }else{%>
 <input type="text"	 name="<%=RANK %>" tabindex="2" />
 <% }%>
  

 
 <label>Name  </label> 
  <% if(medExamObj.getNameInFull()!=null){%>
 <input type="text"	 name="<%=FULL_NAME %>" tabindex="2" value="<%=medExamObj.getNameInFull() %>" readonly="readonly"/>
 <% }else{%>
 <input type="text"	 name="<%=FULL_NAME %>" tabindex="2" />
 <% }%>
 
 <div class="clear"></div>
  <label>Father's Name  </label> 
  <%
  	if(medExamObj.getFatherName() != null){
  %>
   <input type="text" value="<%= medExamObj.getFatherName() %>" name="<%=FATHER_NAME%>"	tabindex="1" maxlength="50" readonly="readonly"/>
  <%}else{ %>
 <input	type="text" value="" name="<%=FATHER_NAME%>"	tabindex="1" maxlength="50"/>
 <%} %>
 
  <label>Date Of Birth <span>*</span> </label>
 <%
 if(medExamObj.getDateOfBirth() != null){
 %>
  <input tabindex="1" name="<%=DATE_OF_BIRTH %>" class="date" value="<%= HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateOfBirth()) %>"	validate="DOB,date,yes" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" />
	<%}else{ %>
	<input tabindex="1" name="<%=DATE_OF_BIRTH %>" class="date" value=""	validate="DOB,date,yes" maxlength="10"
	onKeyUp="mask(this.value,this,'2,5','/');" />
	<%} %>
	 <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',medicalExamPrimaryExtn.<%=DOB%>,event);" />
 <label>Age  </label> 
 <%
 	if(medExamObj.getVisit() != null){
 %>
 <input	type="text" value="<%= medExamObj.getVisit().getAge() %>" name="<%=AGE%>" readonly="readonly"	tabindex="1" />
 <%}else{ %>
  <input	type="text" value="" name="<%=AGE%>"	tabindex="1" />
 
 <%} %>
  <div class="clear"></div>
  <label>Apparent Age  </label> 
  <%
  	if(medExamObj.getApparentAge() != null){
  %>
 <input	type="text" value="<%= medExamObj.getApparentAge() %>" name="apparentAge" readonly="readonly" tabindex="1" />
 <%}else{ %>
  <input type="text" value="" name="apparentAge"	tabindex="1" />
 <%} %>
 
 <label>Service </label> 
 <input	type="text" value="<%= medExamObj.getServiceType().getServiceTypeName() %>" name="serviceiaf" readonly="readonly"	tabindex="1" />
  <input type="hidden" value="<%= medExamObj.getServiceType().getId() %>" name="<%=SERVICE_TYPE_ID  %>"	 />
 <label>Present Unit</label> 
 <%
 String unitName = "";
 int unitId = 0;
 	if( medExamObj.getUnit() != null){
 		unitName = medExamObj.getUnit().getUnitName();
 		unitId = medExamObj.getUnit().getId();
 	
 %>
 <input	type="text" value="<%=unitName %>" name="<%=UNIT%>"	tabindex="1" readonly="readonly"/>
  <input type="hidden" value="<%= unitId %>" name="<%=UNIT_ID%>"	/>
  <%}else{ %>
   <input	type="text" value="" name="<%=UNIT%>"	tabindex="1" readonly="readonly"/>
  <input type="hidden" value="" name="<%=UNIT_ID%>"	/>
  
  <%} %>
 <div class="clear"></div>
 <label>Branch/Trade  </label> 
 <%
 String tradeName = "";
 int tradeId = 0;
 	if( medExamObj.getTrade() != null){
 		tradeName = medExamObj.getTrade().getTradeName();
 		tradeId =medExamObj.getTrade().getId() ;
 	
 %>
 <input	type="text" value="<%= tradeName %>" name="<%=TRADE%>"	tabindex="1" readonly="readonly"/>
 <input	type="hidden" value="<%=tradeId %>" name="<%=TRADE_ID%>" />
 <%}else{ %>
  <input	type="text" value="" name="<%=TRADE%>"	tabindex="1" readonly="readonly" />
 <input	type="hidden" value="" name="<%=TRADE_ID%>" />
 <%} %>
 <label>Total Service  </label> 
 <input	type="text" value="<%= medExamObj.getTotalService()%>" name="<%=TOTAL_SERVICE%>" readonly="readonly"	tabindex="2" />
  <label>Permanent Address  </label> 
   <%
  	if(medExamObj.getParmanentAddress() != null){
  %>
   <textarea tabindex="1" name="<%=PERMANENT_ADDRESS %>" readonly="readonly" onkeyup="chkLength(this,100);"><%=medExamObj.getParmanentAddress() %></textarea>
  <%}else{ %>
 <textarea tabindex="1" name="<%=PERMANENT_ADDRESS %>" onkeyup="chkLength(this,100);"></textarea>
 <%} %>
   <div class="clear"></div>
  
  <label><span>*</span> ID Mark 1  </label> 
   <%
  	if(medExamObj.getIdentificationMarks1() != null){
  %>
   <input tabindex="1" name="<%=IDENTIFICATION_MARKS1 %>" type="text" readonly="readonly" value="<%= medExamObj.getIdentificationMarks1() %>"
	validate="Identification1,String,yes" maxlength="25" /> 
  <%}else{ %>
  <input tabindex="1" name="<%=IDENTIFICATION_MARKS1 %>" type="text" readonly="readonly"
	validate="Identification1,String,yes" maxlength="25" /> 
	<%} %>
	<label><span>*</span>  ID Mark 2 </label> 
	<%
  	if(medExamObj.getIdentificationMarks2() != null){
  %>
	<input tabindex="1" name="<%=IDENTIFICATION_MARKS2 %>" type="text" readonly="readonly" value="<%= medExamObj.getIdentificationMarks2() %> "
	validate="Identification2,String,yes" maxlength="25" /> 
	<%}else{ %>
  <input tabindex="1" name="<%=IDENTIFICATION_MARKS2 %>" type="text" readonly="readonly"
	validate="Identification2,String,yes" maxlength="25" /> 
	<%} %>
 <label>Past Medical History  </label> 
 <%
  	if(medExamObj.getPastmedicalhistory() != null){
  %>
 <input	type="text" value="<%= medExamObj.getPastmedicalhistory() %>" name="<%=PAST_MEDICAL_HISTORY%>" readonly="readonly"	tabindex="1" maxlength="20"/>
 <%}else{ %>
  <input	type="text" value="" name="<%=PAST_MEDICAL_HISTORY%>" readonly="readonly"	tabindex="1" maxlength="20"/>
 <%} %>
 <div class="clear"></div>
 
 <label>Relevant Family Hx  </label> 
 <%
 	if(medExamObj.getRelevantFamilyHistory() != null){
 %>
<input	type="text" value="<%=  medExamObj.getRelevantFamilyHistory() %>" name="<%=RELEVANT_FAMILY_HISTORY%>" readonly="readonly" tabindex="1" maxlength="100"/>
 <%}else{ %>
 <input	type="text" value="" name="<%=RELEVANT_FAMILY_HISTORY%>" readonly="readonly" tabindex="1" maxlength="100"/>
 <%} %>
  <div class="clear"></div>
</div>

<div class="clear paddingTop15"></div>
<h4>Dental <a href="javascript:animatedcollapse.toggle('slide1')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide1">
<div class="Block">
<div class="clear"></div>
<label >Total no. of Teeth</label>
  <% if(medExamObj.getTotalTeeth()!=null){%>
 
 <input tabindex="1"	type="text" name="<%=TOTAL_NO_OF_TEETH %>" readonly="readonly" class="small" value="<%=medExamObj.getTotalTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" /> 

 <% }else{%>
<input tabindex="1"	type="text" name="<%=TOTAL_NO_OF_TEETH %>" class="small" readonly="readonly"
	onKeyUp="isNumber(this)" maxlength="2" /> 

 <% }%>
 
	
<label class="auto">Total No. of Defective Teeth</label>
 <% if(medExamObj.getTotalDefectiveTeeth()!=null){%>
<input tabindex="1"	type="text" name="<%=DEFECTIVE_TEETH %>" readonly="readonly" class="small" value="<%=medExamObj.getTotalDefectiveTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" /> 


 <% }else{%>
<input tabindex="1"	type="text" name="<%=DEFECTIVE_TEETH %>" class="small" readonly="readonly" 
	onKeyUp="isNumber(this)" maxlength="2" /> 


 <% }%>
	<label class="auto">Total no. of Dental Point</label> 
	<% if(medExamObj.getTotalNoDentalPoint()!=null){%>
	<input	tabindex="1" type="text" name="<%=DENTSL_POINT %>" readonly="readonly"  value="<%=medExamObj.getTotalNoDentalPoint() %>"
	onKeyUp="isNumber(this);" maxlength="2" /> 


 <% }else{%>
	<input	tabindex="1" type="text" name="<%=DENTSL_POINT %>" readonly="readonly" 
	onKeyUp="isNumber(this);" maxlength="2" />


 <% }%>

	<div class="clear"></div>
	
<label >Missing </label> 
	<% if(medExamObj.getMissingTeeth()!=null){%>
<input tabindex="1" type="text"
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);" readonly="readonly"  value="<%=medExamObj.getMissingTeeth() %>"
	maxlength="2" />
 <% }else{%>
<input tabindex="1" type="text"
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);" readonly="readonly" 
	maxlength="2" />
 <% }%>
<label class="auto">Unservicable</label>
<% if(medExamObj.getUnderscendedTest()!=null){%>
<input	tabindex="1" type="text" name="<%=MISSING_UNSERVICABLE_TEETH %>" readonly="readonly"  value="<%=medExamObj.getUnderscendedTest() %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }else{%>
<input	tabindex="1" type="text" name="<%=MISSING_UNSERVICABLE_TEETH %>" readonly="readonly" 
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
<label class="medium"> Remarks</label> <textarea rows="" cols=""
	name="<%=DENTAL_REMARKS %>" class="large" onkeyup="chkLength(this,50);"></textarea>
	
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
<input tabindex="1" type="text" id="height" class="date" readonly="readonly"	name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)" value="<%=medExamObj.getHeight() %>"
	maxlength="6" onblur="calculateBMI();" /><label class="smallAuto">cm</label>

 <% }else{%>
<input tabindex="1" type="text" id="height"	class="date" readonly="readonly" name="<%=HEIGHT_WITHOUT_SHOOSE %>" onkeyup="isNumber1(this)"
	maxlength="6" onblur="calculateBMI();" /><label class="smallAuto">cm</label>

 <% }%>


<label	>Weight</label> 
  <% if(medExamObj.getActualweight()!=null){%>
<input tabindex="1" type="text" id="weight"  class="date" readonly="readonly"  name="<%=ACTUAL_WEIGHT %>" maxlength="6" value="<%=medExamObj.getActualweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="smallAuto">kg</label>

 <% }else{%>
<input tabindex="1" type="text" id="weight"  class="date" readonly="readonly" name="<%=ACTUAL_WEIGHT %>"  maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="smallAuto">kg</label>

 <% }%>


<label	>Ideal Weight</label> 
  <% if(medExamObj.getIdealweight()!=null){%>
<input tabindex="1" type="text" id="" name="<%=IDEAL_WEIGHT %>"  readonly="readonly" class="date"  maxlength="6" value="<%=medExamObj.getIdealweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }else{%>
<input tabindex="1" type="text" id="" name="<%=IDEAL_WEIGHT %>"  readonly="readonly" class="date"  maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }%>

<div class="clear"></div>
<label	>Over Weight</label> 
  <% if(medExamObj.getOverweight()!=null){%>
<input tabindex="1" type="text" id="" name="<%=OVER_WEIGHT %>"  readonly="readonly" class="date" maxlength="6" value="<%=medExamObj.getOverweight() %>"
	onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }else{%>
<input tabindex="1" type="text" id="" name="<%=OVER_WEIGHT %>"  readonly="readonly" class="date"  maxlength="6" 
	onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }%>


<label	>Waist</label> 
  <% if(medExamObj.getWaist()!=null){%>
<input tabindex="1" type="text" id="" name="<%=WAIST %>"  readonly="readonly" maxlength="6" value="<%=medExamObj.getWaist() %>"
	onKeyUp="limitText(this,6);" size="20" class="auto"  />

 <% }else{%>
<input tabindex="1" type="text" id="" name="<%=WAIST %>"  readonly="readonly" maxlength="6" 
	onKeyUp="limitText(this,6);" size="20" class="auto" />

 <% }%>


<label	>Chest Full Expansion</label> 
  <% if(medExamObj.getChestfullexpansion()!=null){%>
<input tabindex="1" type="text" id="" name="<%=CHEST_FULL %>"  readonly="readonly" class="date"  maxlength="6" value="<%=medExamObj.getChestfullexpansion() %>"
	onKeyUp="limitText(this,6);"   /><label class="smallAuto">cm</label>

 <% }else{%>
<input tabindex="1" type="text" id="" name="<%=CHEST_FULL %>"  readonly="readonly" class="date" maxlength="6" 
	onKeyUp="limitText(this,6);"  /><label class="smallAuto">cm</label>

 <% }%>

<div class="clear"></div>
<label>Range Of Expansion</label> 
  <% if(medExamObj.getRangeofexpansion()!=null){%>
<input tabindex="1" type="text" id="" name="<%=RANGE_EXPANSION %>"  readonly="readonly" maxlength="6" value="<%=medExamObj.getRangeofexpansion() %>"
	onKeyUp="limitText(this,6);" size="20" class="auto"  />

 <% }else{%>
<input tabindex="1" type="text" id="" name="<%=RANGE_EXPANSION %>"  readonly="readonly" maxlength="6" 
	onKeyUp="limitText(this,6);" size="20" class="auto"  />

 <% }%>


<label	>BMI</label> 
  <% if(medExamObj.getBhi()!=null){%>
<input tabindex="1" type="text" id="bmi" name="<%=BHI %>" maxlength="6" value="<%=medExamObj.getBhi() %>" readonly="readonly" 
	onKeyUp="limitText(this,6);" size="20" class="auto" />

 <% }else{%>
<input tabindex="1" type="text" id="bmi" name="<%=BHI %>" maxlength="6" readonly="readonly" 
	onKeyUp="limitText(this,6);" size="20" class="auto" />

 <% }%>


<label	>Body Fat</label> 
  <% if(medExamObj.getBodyfat()!=null){%>
<input tabindex="1" type="text" id="" name="<%=BODY_FAT %>"  maxlength="6" value="<%=medExamObj.getBodyfat() %>"readonly="readonly" 
	onKeyUp="limitText(this,6);" size="20" class="auto"  />

 <% }else{%>
<input tabindex="1" type="text" id="" name="<%=BODY_FAT %>" maxlength="6" readonly="readonly" 
	onKeyUp="limitText(this,6);" size="20" class="auto"  />

 <% }%>
<div class="clear"></div>
<label	>Skin Fold Thickness</label> 
  <% if(medExamObj.getSignfoldthickness()!=null){%>
<input tabindex="1" type="text" id="" name="<%=THICKNESS %>"  maxlength="6" value="<%=medExamObj.getSignfoldthickness() %>" readonly="readonly" 
	onKeyUp="limitText(this,6);" size="20" class="auto"  />

 <% }else{%>
<input tabindex="1" type="text" id="" name="<%=THICKNESS %>" maxlength="6" readonly="readonly" 
	onKeyUp="limitText(this,6); " size="20" class="auto"  />

 <% }%>

<label	>Sports Man</label> 
  <% if(medExamObj.getSportman()!=null){%>
<input tabindex="1" type="text" id="" name="<%=SPORTS %>" maxlength="6" value="<%=medExamObj.getSportman() %>" readonly="readonly" 
	onKeyUp="limitText(this,6);" size="20" class="auto" />
 <% }else{%>
<input tabindex="1" type="text" id="" name="<%=SPORTS %>" maxlength="6" readonly="readonly" 
	onKeyUp="limitText(this,6);" size="20" class="auto" />

 <% }%>


</div>
</div>

<div class="clear paddingTop15"></div>


<h4> EYES <a href="javascript:animatedcollapse.toggle('slide3')">(Click Here)</a></h4>
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
 <input tabindex="1" type="text" readonly="readonly" 	name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" 	name="<%=WITHOUT_GLASSES_DISTANT_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" 	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" 	name="<%=WITHOUT_GLASSES_DISTANT_L %>" maxlength="10" />
 <% }%>
 </td>
		
		<td>Without Glasses</td>
			<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" 	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" 	name="<%=WITHOUT_GLASSES_NEAR_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithoutGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" 	name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="10" value="<%=medExamObj.getWithoutGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" 	name="<%=WITHOUT_GLASSES_NEAR_L %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getNearVisionWithoutGlassCp()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" 	name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="10" value="<%=medExamObj.getNearVisionWithoutGlassCp()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" 	name="<%=WITHOUT_GLASSES_NEAR_CP %>" maxlength="10" />
 <% }%>
 </td>
		
	</tr>
	<tr>
		<td>With Glasses</td>
		<td width="10%">
	
  <% if(medExamObj.getWithGlassesRDistant()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" 	name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="10" value="<%=medExamObj.getWithGlassesRDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" 	name="<%=WITH_GLASSES_DISTANT_R %>" maxlength="10" />
 <% }%>
 </td>
 	<td width="10%">
	
  <% if(medExamObj.getWithGlassesLDistant()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" 	name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="10" value="<%=medExamObj.getWithGlassesLDistant()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" 	name="<%=WITH_GLASSES_DISTANT_L %>" maxlength="10" />
 <% }%>
 </td>	
		
		<td>With Glasses</td>
			<td width="10%">
	
  <% if(medExamObj.getWithGlassesRNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" 	name="<%=WITH_GLASSES_NEAR_R %>" maxlength="10" value="<%=medExamObj.getWithGlassesRNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" 	name="<%=WITH_GLASSES_NEAR_R %>" maxlength="10" />
 <% }%>
 </td>	
 	<td width="10%">
	
  <% if(medExamObj.getWithGlassesLNearvision()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" 	name="<%=WITH_GLASSES_NEAR_L %>" maxlength="10" value="<%=medExamObj.getWithGlassesLNearvision()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" 	name="<%=WITH_GLASSES_NEAR_L %>" maxlength="10" />
 <% }%>
 </td>	
 	<td width="10%">
	
  <% if(medExamObj.getNearVisionWithGlassCp()!=null){%>
 <input tabindex="1" type="text" readonly="readonly" 	name="<%=WITH_GLASSES_NEAR_CP %>" maxlength="10" value="<%=medExamObj.getNearVisionWithGlassCp()%>"/>
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" 	name="<%=WITH_GLASSES_NEAR_CP %>" maxlength="10" />
 <% }%>
 </td>	
		
	</tr>

</table>

<div class="clear paddingTop15"></div>
<div class="Block">
<label class="large2">Any evidence of Trachoma <br /><span class="sublabel">(its complications or any other disease)</span></label> 
<% if(medExamObj.getAnyOtherEyeDisease()!=null){%>
 <textarea rows="" cols=""
	name="<%=ANY_EVIDENCE_OF_TRACHOMA %>" class="large" readonly="readonly"  value="<%=medExamObj.getAnyOtherEyeDisease() %>"
	onkeyup="chkLength(this,30);"></textarea>
 <% }else{%>
<textarea rows="" cols=""
	name="<%=ANY_EVIDENCE_OF_TRACHOMA %>" class="large" readonly="readonly" 
	onkeyup="chkLength(this,30);"></textarea>
 <% }%>
<div class="clear"></div>
<label class="large2">Binocular vision & Grade</label>
<% if(medExamObj.getBinocularVisionGrade()!=null){%>
<input
	tabindex="1" type="text" name="<%=BINOCULAR_VISION_GRADE %>" readonly="readonly"  value="<%=medExamObj.getBinocularVisionGrade() %>"
	class="large" maxlength="50" />
 <% }else{%>
<input
	tabindex="1" type="text" name="<%=BINOCULAR_VISION_GRADE %>" readonly="readonly" 
	class="large" maxlength="50" />
 <% }%>
 	</div>
	
<div class="clear paddingTop15"></div>
<h4>Special Examination When Applicable</h4>
<div class="clear"></div>
<div class="Block">
<label class="large">Manifest Hypermetropia, Myopia R & L</label> 
<% 
	if(medExamObj.getManifestHypermetropia()!= null){
%>
<input tabindex="1" type="text" name="<%=MANIFEST_HYPERMETROPIA %>" readonly="readonly" value="<%= medExamObj.getManifestHypermetropia() %>"	maxlength="10" />
	<%}else{ %>
	<input	tabindex="1" type="text" name="<%=MANIFEST_HYPERMETROPIA %>"	readonly="readonly" maxlength="10" />
	<%} %>
	 <label>Cover Test</label> 
	 <%
	 if(medExamObj.getCoverTest() != null){
	 %>
	 <input tabindex="1" type="text" name="<%=COVER_TEST %>" readonly="readonly" value="<%= medExamObj.getCoverTest()%>" maxlength="10" />
<%}else{ %>
 <input tabindex="1" type="text" name="<%=COVER_TEST %>" readonly="readonly" maxlength="10" />
<%} %>
<div class="clear"></div>

<label class="large">Diaphragm Test(PD M ddox Wing Test)</label>
<%
	if(medExamObj.getDiaphragmTest()!= null){
%> 
<input tabindex="1" type="text" name="<%=DIAPHRAGM_TEST %>" readonly="readonly" value="<%=medExamObj.getDiaphragmTest()  %>" maxlength="10" />
<%}else{ %>
<input tabindex="1" type="text" name="<%=DIAPHRAGM_TEST %>" readonly="readonly" maxlength="10" />
<%} %>
<label>Fund & Media</label> 
<% 
if(medExamObj.getFundAndMedia()!= null){
%>
<input tabindex="1" type="text" name="<%=FUND_MEDIA %>" readonly="readonly" value="<%= medExamObj.getFundAndMedia() %>" maxlength="10" />
<%}else{ %>
<input tabindex="1" type="text" name="<%=FUND_MEDIA %>" readonly="readonly" maxlength="10" />

<%} %>
<div class="clear"></div>

<label class="large">Fields</label> 
<% if(medExamObj.getFields() != null){ %>
<input tabindex="1" type="text" name="<%=FIELDS %>" value="<%= medExamObj.getFields() %>" readonly="readonly" maxlength="10" /> 
<%}else{ %>
<input tabindex="1" type="text" name="<%=FIELDS %>" value="" readonly="readonly" maxlength="10" />
<%} %>
<label>Night Visual Capacity</label> 
<% if(medExamObj.getNightVisualCapacity()!= null){ %>
<input tabindex="1" type="text" name="<%=NIGHT_VISUAL_CAPACITY %>" readonly="readonly" value="<%= medExamObj.getNightVisualCapacity() %>" maxlength="10" />
<%}else{ %>
<input tabindex="1" type="text" name="<%=NIGHT_VISUAL_CAPACITY %>" readonly="readonly" maxlength="10" />
<%} %>
<div class="clear"></div>

<label class="large">Convergence C(cms)</label> 
<% if(medExamObj.getConvergenceC()!= null){ %>
<input tabindex="1" type="text" id="convergence" name="<%=CONVERGENCE_C%>" readonly="readonly" value="<%= medExamObj.getConvergenceC() %>" onkeyup="isNumber1(this)" maxlength="6"/> 
	<%}else{ %>
	<input tabindex="1" type="text" id="convergence" name="<%=CONVERGENCE_C%>" readonly="readonly" onkeyup="isNumber1(this)" maxlength="6"/>
	<%} %>
	
<label>Convergence <br /><span class="sublabel">SC(cms)</span></label> 
<%if(medExamObj.getConvergenceSc() != null){ %>
<input tabindex="1" type="text" id="convergencesc" name="<%=CONVERGENCE_SC %>" readonly="readonly" value="<%= medExamObj.getConvergenceSc() %>" onkeyup="isNumber1(this)" maxlength="6" />
<%}else{ %>
<input tabindex="1" type="text" id="convergencesc" name="<%=CONVERGENCE_SC %>" readonly="readonly" onkeyup="isNumber1(this)" maxlength="6" />
<%} %>
<div class="clear"></div>

<label class="large">Accommodation R</label> 
<%if(medExamObj.getAccommodationR() != null){ %>
<input tabindex="1" type="text" name="<%=ACCOMMODATION_R %>" readonly="readonly" value="<%= medExamObj.getAccommodationR() %>" maxlength="20" /> 
<%}else{ %>
<input tabindex="1" type="text" name="<%=ACCOMMODATION_R %>" readonly="readonly" maxlength="20" />
<%} %>
<label>Accommodation L</label> 
<%if(medExamObj.getAccommodationL() != null){ %>
<input tabindex="1" type="text" name="<%=ACCOMMODATION_L %>" readonly="readonly" value="<%= medExamObj.getAccommodationL() %>" maxlength="20" />
<%}else{ %>
<input tabindex="1" type="text" name="<%=ACCOMMODATION_L %>" readonly="readonly" maxlength="20" />
<%} %>
<div class="clear"></div>
<label class="large">Remarks</label> 
<%if(medExamObj.getRemarksSpecialExam()!= null){ %>
<input tabindex="1" type="text" name="<%=EYE_REMARKS %>" readonly="readonly" value="<%= medExamObj.getRemarksSpecialExam() %>" maxlength="50" /> 
<%}else{ %>
<input tabindex="1" type="text" name="<%=EYE_REMARKS %>" readonly="readonly" maxlength="50" /> 
<%} %>
<label>Date</label> 
<%if(medExamObj.getDateSpecialExam() != null){ %>
<input tabindex="1" type="text" name="<%=EYE_DATE %>" readonly="readonly" class="calDate" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateSpecialExam()) %>"	maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');"	validate="EyeDate,date,no" /> 
	<%}else{ %>
<input tabindex="1" type="text" name="<%=EYE_DATE %>" readonly="readonly" class="calDate"	maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');"	validate="EyeDate,date,no" /> 
	
	<%} %>
	<img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',medExamPrimaryMD.<%=EYE_DATE%>,event);" />
	</div>

</div>
<div class="clear paddingTop15"></div>

<h4> Ear <a	href="javascript:animatedcollapse.toggle('slide4')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide4">
<div class="Block">
<div class="clear"></div>

<label>Hearing <br /><span class="sublabel">RFW(Cms)</span></label> 
<% if(medExamObj.getEarHearingRfw() != null){ %>
<input tabindex="1" type="text" id="hrfw" name="<%=HEARING_R_F_W %>" readonly="readonly" value="<%=medExamObj.getEarHearingRfw()   %>" onkeyup="isNumber1(this)" maxlength="6" /> 
	<%}else{ %>
	<input tabindex="1" type="text" id="hrfw" name="<%=HEARING_R_F_W %>" readonly="readonly" onkeyup="isNumber1(this)"	maxlength="6"  /> 
	
	<%} %>
	<label>Hearing <br /><span class="sublabel">LFW(Cms)</span></label> 
<% if(medExamObj.getEarHearingLfw() != null){ %>	
<input tabindex="1" type="text" id="hlfw" value="<%=medExamObj.getEarHearingLfw()  %>" readonly="readonly" name="<%=HEARING_L_F_W%>" onkeyup="isNumber1(this)" maxlength="6"/> 
	<%}else{ %>
	<input tabindex="1" type="text" id="hrfw" name="<%=HEARING_L_F_W %>" readonly="readonly" onkeyup="isNumber1(this)"	maxlength="6"  /> 
	
	<%} %>
	
	<label>Hearing Both <br /><span class="sublabel">FW(Cms)</span></label> 
	<% if(medExamObj.getEarHearingBothFw() != null){ %>
	<input tabindex="1" type="text" id="bothfw"	name="<%=HEARING_BOTH_FW %>" readonly="readonly" value="<%= medExamObj.getEarHearingBothFw() %>" onkeyup="isNumber1(this)" maxlength="6"/>
<%}else{ %>
		<input tabindex="1" type="text" id="bothfw"	name="<%=HEARING_BOTH_FW %>" readonly="readonly" onkeyup="isNumber1(this)" maxlength="6"/>
	
	<%} %>
	
<div class="clear"></div>

<label>Hearing <br /><span class="sublabel">RCV(Cms)</span></label>
<% if(medExamObj.getHearingRcv() != null){ %>
 <input tabindex="1" type="text" id="hrcv" name="<%=HEARING_R_C_V %>" readonly="readonly" value="<%= medExamObj.getHearingRcv() %>" onkeyup="isNumber1(this)" maxlength="6" />
<%}else{ %>	
	 <input tabindex="1" type="text" id="hrcv" name="<%=HEARING_R_C_V %>" readonly="readonly" onkeyup="isNumber1(this)"	maxlength="6"  />
	<%} %>
	 <label>Hearing <br /><span class="sublabel">LCV(Cms)</span></label>
	 
	 <% if(medExamObj.getHearingLcv() != null){ %>
	  <input tabindex="1" type="text" id="hlcv" name="<%=HEARING_L_C_V %>" readonly="readonly" value="<%= medExamObj.getHearingLcv() %>" onkeyup="isNumber1(this)" maxlength="6"/> 
	  <%}else{ %>
	    <input tabindex="1" type="text" id="hlcv" name="<%=HEARING_L_C_V %>" readonly="readonly" onkeyup="isNumber1(this)" maxlength="6"/>
	  <%} %>
	  <label>Hearing Both <br /><span class="sublabel">CV(Cms)</span></label> 
	  	 <% if(medExamObj.getHearingBothCv() != null){ %>
	  <input tabindex="1" type="text" id="bothcv" name="<%=HEARING_BOTH_CV %>" readonly="readonly" value="<%= medExamObj.getHearingBothCv()  %>" onkeyup="isNumber1(this)" maxlength="6"/>
<%}else{ %>
 <input tabindex="1" type="text" id="bothcv" name="<%=HEARING_BOTH_CV %>" readonly="readonly" onkeyup="isNumber1(this)" maxlength="6"/>
<%} %>
<div class="clear"></div><!--

<label>External Ear (Wax)R</label> <input tabindex="1" type="text"
	name="<%=EXTERNAL_EAR_R %>" maxlength="10" /> <label>External
Ear(Wax)L</label> <input tabindex="1" type="text" name="<%=EXTERNAL_EAR_L %>"
	maxlength="10" />

<div class="clear"></div>

<label class="large2">Middle Ear(Tympanic Membrance &Eustachain
Tube)-R</label> <input tabindex="1" type="text" name="<%= MIDDLE_EAR_R%>"
	maxlength="10" /> <label class="large2">Middle Ear(Tympanic
Membrance &Eustachain Tube)-L</label> <input tabindex="1" type="text"
	name="<%=MIDDLE_EAR_L %>" maxlength="10" />

<div class="clear"></div>

<label class="large2">Inner Ear(Cochlea & Vestibular
Apparatus)-R</label> <input tabindex="1" type="text" name="<%=INNER_EAR_R %>"
	maxlength="10" /> <label class="large2">Inner Ear(Cochlea &
Vestibular Apparatus)-L</label> <input tabindex="1" type="text"
	name="<%=INNER_EAR_L %>" maxlength="10" />

<div class="clear"></div>

<label class="large2">Audiometry Record(Special exam when
applicable</label> <input tabindex="1" type="text"
	name="<%=AUDIOMETRY_RECORD %>" maxlength="10" />

<div class="clear"></div>


<div class="clear"></div>

<label class="medium">Remarks</label> <textarea rows="" cols=""
	name="<%=EAR_REMARKS %>" class="large" onkeyup="chkLength(this,50);"></textarea>
-->
</div>
</div>
<!-- fayaz added -->

<div class="clear paddingTop15"></div>

<h4>Investigation <a href="javascript:animatedcollapse.toggle('slide5')">(Click Here)</a></h4>
<div id="slide5">
<div class="Block">
<table id="chargeDetails" width="100%" cellpadding="0" cellspacing="0">
<tr>
		<th width="7%">Sr No.</th>


		<th width="7%">Test Name</th>
		<th>Test Result</th>
	
<% 
    int index = 0;
    int indexForSingle = 0;
    int indexForMultiple = 0;
    
    for(DgResultEntryHeader dgResultEntryHeader2 : resultList){ 
 		if(dgResultEntryHeader2.getResultType() != null 
				&& dgResultEntryHeader2.getResultType().equalsIgnoreCase("S")){
 			DgResultEntryDetailSen dgDetail = dgResultEntryHeader2.getDgResultEntryDetailSen().iterator().next();
 			%>
		<tr>

			<td><%=index+1 %></td>
			<td>
			<%if(dgDetail.getInvestigation() !=null){ 
			              %> <label name="<%=INVESTIGATION_NAME %>"
				style="font-weight: bold;"><%=dgDetail.getInvestigation().getInvestigationName() %>
			</label> <%}else { %> <label style="font-weight: bold;">-</label> <%} %>
			</td>
			<td></td>
			<td><input name="resultIdSensitive"
				id="resultIdSensitive<%=index%>" type="hidden"
				value="<%=dgDetail.getResultEntry().getId()%>" /> <input
				type="button" class="cmnButton" style="width: auto;"
				value="Click Here To Fill Result"
				onclick="openSensitiveScreen('<%=index%>');" align="right" /></td>
			<td></td>

		</tr>

		<%	}else{
		   	DgResultEntryDetail dgDetail = dgResultEntryHeader2.getDgResultEntryDetails().iterator().next();

	    	if(dgDetail.getInvestigation().getInvestigationType().equals("s")){
				
			    %>
		<tr>
			<td><%=index+1 %></td>
			<td width="7%">
			<%if(dgDetail.getInvestigation() !=null){  %> <label
				style="font-weight: bold;"><%=dgDetail.getInvestigation().getInvestigationName()%></label>

			<%}else { %> <label style="font-weight: bold;">-</label> <%} %>
			</td>
			<td>
			<% 
				    try{
				    	if(dgDetail.getInvestigation().getMinNormalValue() != null
				    		&& dgDetail.getInvestigation().getMaxNormalValue() != null
				    		&& !dgDetail.getInvestigation().getMinNormalValue().equals("")
				    		&& !dgDetail.getInvestigation().getMaxNormalValue().equals("")){
				    		
				    		Float minValue = Float.parseFloat(dgDetail.getInvestigation().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getInvestigation().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <input
				name="<%=RESULT_SINGLE_VALUE %>" tabindex="1"
				onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');"
				id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>" value="<%=result %>" />
			<% }else{ %> <input name="<%=RESULT_SINGLE_VALUE %>" tabindex="1"
				onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');"
				id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>" class="highlight"
				value="<%=result %>" /> <% }
					    	}else{%> <input name="<%=RESULT_SINGLE_VALUE %>" tabindex="1"
				onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');"
				id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>" value="" />
			<%}
					       }else{ 
					          if(dgDetail.getResult() != null){%> <input
				name="<%=RESULT_SINGLE_VALUE %>" tabindex="1"
				onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');"
				id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>"
				value="<%=dgDetail.getResult()%>" /> <% }else { %> <input
				name="<%=RESULT_SINGLE_VALUE %>" tabindex="1"
				onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');"
				id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>" value="" />
			<% } %> <% } 
				    }catch(Exception exception){ %> <input
				name="<%=RESULT_SINGLE_VALUE %>" tabindex="1"
				onkeyup="submitAllExceptEnter(this,event,'','<%=index+1 %>');"
				id="<%=RESULT_SINGLE_VALUE %><%=index+1 %>"
				value="<%=dgDetail.getResult()%>" /> <% } %>
			</td>
			
		</tr>

		<% 
		 indexForSingle++;
		}else if(dgDetail.getInvestigation().getInvestigationType().equals("t")){ %>
		<tr>

			<td><%=index+1 %></td>
			<td>
			<%if(dgDetail.getInvestigation() !=null){ 
			              %> <label name="<%=INVESTIGATION_NAME %>"
				style="font-weight: bold;"><%=dgDetail.getInvestigation().getInvestigationName() %>
			</label> <%}else { %> <label style="font-weight: bold;">-</label> <%} %>
			</td>
			<td></td>
			<td><input name="resultIdTemplate"
				id="resultIdTemplate<%=index%>" type="hidden"
				value="<%=dgDetail.getResultEntry().getId()%>" /> <input
				type="button" class="cmnButton" style="width: auto;"
				value="Click Here To Fill Result"
				onclick="openTemplateScreen('<%=index%>');" align="right" /></td>
			<td></td>

		</tr>
		<%	
		
		}else if(dgDetail.getInvestigation().getInvestigationType().equals("m")){ 
		%>
		<jsp:include page="medicalexamMultipleTestType.jsp"
			flush="true">
			<jsp:param name="resultEntryIndex" value="<%=index%>" />
			<jsp:param name="resultEntryIndexForMultiple"
				value="<%=indexForMultiple%>" />
		</jsp:include>

		<%  
			indexForMultiple = indexForMultiple + dgResultEntryHeader2.getDgResultEntryDetails().size()+1;
		}
		}
 		index++;
    	} %>
	
</table>

</div>
</div>
<div class="clear paddingTop15"></div>


<h4>UPPER LIMBS AND LOCOMOTER SYSTEM <a	href="javascript:animatedcollapse.toggle('slide6')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide6">
<div class="Block">
<div class="clear"></div>
<label >Upper Limbs</label> 
<%
	if(medExamObj.getUpperLimbs() != null){
%>
<input tabindex="1" type="text"	name="upperLimbs" value="<%= medExamObj.getUpperLimbs() %>" class="Auto" size="20" readonly="readonly"  maxlength="100" />
<%}else{ %>
<input tabindex="1" type="text"	name="upperLimbs" class="Auto" size="20" readonly="readonly"  maxlength="100" />
<%} %>
<label class="auto"> Locomotion</label> 
<%
	if(medExamObj.getLocomotion() != null){
%>
<input tabindex="1" type="text"	name="locomotion" value="<%= medExamObj.getLocomotion() %>" class="Auto" size="20" readonly="readonly" maxlength="100" />
<%}else{ %>
<input tabindex="1" type="text"	name="locomotion" class="Auto" size="20" readonly="readonly" maxlength="100" />
<%} %>
<div class="clear"></div>
</div>
</div>
<div class="clear paddingTop15"></div>
<h4>RESPIRATORY SYSTEM <a href="javascript:animatedcollapse.toggle('slide7')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide7">
<div class="Block">
<div class="clear"></div>
<label class="auto"> Chest Measurment</label> 
<%
	if(medExamObj.getChestMeasurement() != null){
%>
<input tabindex="1" type="text" name="chestMeasurement" value="<%= medExamObj.getChestMeasurement()  %>" class="Auto" size="120" maxlength="40" readonly="readonly" />
	<%}else{ %>
<input tabindex="1" type="text" name="chestMeasurement" class="Auto" size="120" maxlength="40" readonly="readonly" />
<%} %>
	
<label class="auto"> Full Expiration</label> 
<%
	if(medExamObj.getFullExpiration() != null){
%>	
<input tabindex="1" type="text" name="fullExpiration" value="<%= medExamObj.getFullExpiration() %>" class="Auto" size="120" maxlength="100" readonly="readonly" />
<%}else{ %>
<input tabindex="1" type="text" name="fullExpiration" class="Auto" size="120" maxlength="100" readonly="readonly" />
<%} %>

<label class="auto"> Abnormalities</label> 
<%
	if(medExamObj.getAbnormalities() != null){
%>	
<input tabindex="1" type="text" name="abnormalities" value="<%=medExamObj.getAbnormalities()  %>" class="Auto" size="120" maxlength="100" readonly="readonly" />
	<%}else{ %>
<input tabindex="1" type="text" name="abnormalities" class="Auto" size="120" maxlength="100" readonly="readonly" />
<%} %>
<div class="clear"></div>
</div>
</div>

<div class="clear paddingTop15"></div>


<h4>GENTIO URINARY SYSTEM<a	href="javascript:animatedcollapse.toggle('slide8')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide8">
<div class="Block">
<div class="clear"></div>
<label > Albumen</label> 
<%
	if(medExamObj.getAlbumin() != null){
%>
<input tabindex="1" type="text"	name="<%=ALBUMIN %>" value="<%= medExamObj.getAlbumin() %>" class="Auto" size="20" maxlength="20" readonly="readonly" />
<%}else{ %>
<input tabindex="1" type="text"	name="<%=ALBUMIN %>" class="Auto" size="20" maxlength="20" readonly="readonly" />
<%} %>
<label class="auto"> Sugar</label> 
<%
	if(medExamObj.getSugar() != null){
%>
<input tabindex="1" type="text"	name="<%=SUGAR %>" value="<%= medExamObj.getSugar() %>" class="Auto" size="20" maxlength="20" readonly="readonly" />
<%}else{ %>
<input tabindex="1" type="text"	name="<%=SUGAR %>" class="Auto" size="20" maxlength="20" readonly="readonly" />
<%} %>
<label class="auto"> Other Abnormalities</label> 
<%
	if(medExamObj.getAnyOtheAbnormalities() != null){
%>
<input tabindex="1" type="text"	name="otherAbnormalities" value="<%= medExamObj.getAnyOtheAbnormalities()  %>" class="Auto" size="20" maxlength="20" readonly="readonly" />
<%}else{ %>
<input tabindex="1" type="text"	name="otherAbnormalities" value="" class="Auto" size="20" maxlength="20" readonly="readonly" />
<%} %>
<div class="clear"></div>
<label>Any Evidence Of Skin</label> 
<%
	if(medExamObj.getAnyEvidenceOfSkin() != null){
%>
<input tabindex="1" type="text"	name="anyEvidenceOfSkin" value="<%= medExamObj.getAnyEvidenceOfSkin() %>" class="Auto" size="20" maxlength="100" readonly="readonly" />
<%}else{ %>
<input tabindex="1" type="text"	name="anyEvidenceOfSkin" class="Auto" size="20" maxlength="100" readonly="readonly" />
<%} %>
</div>
</div>

<div class="clear paddingTop15"></div>

<h4> CARDIO VASCULAR SYSTEM <a	href="javascript:animatedcollapse.toggle('slide9')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide9">
<div class="Block">
<div class="clear"></div>
<label>Pulse</label>
 <% if(medExamObj.getPulseRates()!=null){%>
  <input tabindex="1" type="text" name="<%=PULSE_RATES%>" class="Auto" size="22" maxlength="20"  readonly="readonly" value="<%=medExamObj.getPulseRates() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" name="<%=PULSE_RATES%>" class="Auto" size="22" maxlength="20" readonly="readonly" />
 <% }%>
 <label>BP</label> 
<% if(medExamObj.getBp()!=null){%>
  <input tabindex="1" type="text" name="<%=BP1%>" class="Auto" size="22" maxlength="20" readonly="readonly"   value="<%=medExamObj.getBp() %>"/>
 <% }else{%>
 <input tabindex="1" type="text" name="<%=BP1%>" class="Auto" size="22" maxlength="20" readonly="readonly" />
 <% }%>

<div class="clear"></div>

</div>
</div>

<div class="clear paddingTop15"></div>
<h4>CENTRAL NERVOUS SYSTEM <a href="javascript:animatedcollapse.toggle('slide10')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide10">
<div class="Block">
<div class="clear"></div>
<label > CNS <br /><span class="sublabel">(Central Nervous System</span></label> 
 <% if(medExamObj.getCentralNervousSystem()!=null){%>
<input tabindex="1" type="text"	name="centralNervousSystem" value="<%= medExamObj.getCentralNervousSystem() %>" class="Auto" size="20" maxlength="100" readonly="readonly" />
<%}else{ %>
<input tabindex="1" type="text"	name="centralNervousSystem" class="Auto" size="20" maxlength="100" readonly="readonly" />
<%} %>
<label > Abdomen</label> 
 <% if(medExamObj.getAbdomen()!=null){%>
<input tabindex="1" type="text"	name="<%=ABDOMEN %>" value="<%= medExamObj.getAbdomen() %>" class="Auto" size="20" maxlength="50" readonly="readonly" />
<%}else{ %>
<input tabindex="1" type="text"	name="<%=ABDOMEN %>" class="Auto" size="20" maxlength="50" readonly="readonly" />
<%} %>
<label > Liver</label> 
 <% if(medExamObj.getLiver()!=null){%>
<input tabindex="1" type="text"	name="liver" class="Auto" value="<%= medExamObj.getLiver() %>" size="20" maxlength="100" readonly="readonly" />
<%}else{ %>
<input tabindex="1" type="text"	name="liver" class="Auto" size="20" maxlength="100" readonly="readonly" />
<%} %>
<div class="clear"></div>
<label > Spleen</label> 
 <% if(medExamObj.getSpleen()!=null){%>
<input tabindex="1" type="text"	name="spleen" class="Auto" value="<%= medExamObj.getSpleen() %>" size="20" maxlength="100" readonly="readonly" />
<%}else{ %>
<input tabindex="1" type="text"	name="spleen" class="Auto" size="20" maxlength="100" readonly="readonly" />
<%} %>

<div class="clear"></div>
</div>
</div>

<div class="clear paddingTop15"></div>
<h4>MENTAL CAPACITY AND EMOTIONAL STABILITY <a	href="javascript:animatedcollapse.toggle('slide11')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide11">
<div class="Block">
<div class="clear"></div>
<label > Speech</label> 
 <% if(medExamObj.getSpeech()!=null){%>
<input tabindex="1" type="text"	name="<%=SPEECH %>" class="Auto" value="<%= medExamObj.getSpeech() %>" size="20" maxlength="100" readonly="readonly" />
<%}else{ %>
<input tabindex="1" type="text"	name="<%=SPEECH %>" class="Auto" size="20" maxlength="100" readonly="readonly" />
<%} %>
<label >Mental Instability</label> 
 <% if(medExamObj.getMentalInstability()!=null){%>
<input tabindex="1" type="text"	name="mentalInstability" value="<%= medExamObj.getMentalInstability() %>" class="Auto" size="20" maxlength="100" readonly="readonly" />
<%}else{ %>
<input tabindex="1" type="text"	name="mentalInstability" class="Auto" size="20" maxlength="100" readonly="readonly" />
<%} %>
<label >Essential Instability</label> 
 <% if(medExamObj.getEssentialInstability()!=null){%>
<input tabindex="1" type="text"	name="essentialInstability" value="<%= medExamObj.getEssentialInstability() %>" class="Auto" size="20" maxlength="100" readonly="readonly" />
<%}else{ %>
<input tabindex="1" type="text"	name="essentialInstability" class="Auto" size="20" maxlength="100" readonly="readonly" />
<%} %>
<div class="clear"></div>
</div>
</div>


<div class="Clear paddingTop15"></div>
<div class="Block">
<div class="clear"></div>
<label >Smoker</label> 
<select name="smoker" id="smoker" tabindex="1" disabled="disabled">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>
<script>
<%
if(medExamObj.getSmoker()!= null){
%>
document.getElementById('smoker').value='<%=medExamObj.getSmoker()%>';

<%}%>
</script>
<label>Drinker</label> 
<select name="drinker" id="drinker" tabindex="1" disabled="disabled">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>
<script>
<%
if(medExamObj.getDrinker()!= null){
%>
document.getElementById('drinker').value='<%=medExamObj.getDrinker()%>';

<%}%>
</script>

<label>Allergies</label> 
 <% if(medExamObj.getAllergies()!=null){%>
<input tabindex="1" type="text"	name="allergies" value="<%= medExamObj.getAllergies() %>" class="Auto" size="20" maxlength="100" readonly="readonly" />
<%}else{ %>
<input tabindex="1" type="text"	name="allergies" class="Auto" size="20" maxlength="100" readonly="readonly" />
<%} %>
<div class="clear"></div>
<label >Locomoter System</label> 
 <% if(medExamObj.getLocomoterSystem()!=null){%>
 
<input tabindex="1" type="text"	name="locomoterSystem" value="<%= medExamObj.getLocomoterSystem() %>" class="Auto" size="20" maxlength="10" readonly="readonly" />
<%}else{ %>
<input tabindex="1" type="text"	name="locomoterSystem" class="Auto" size="20" maxlength="10" readonly="readonly" />
<%} %>
<label>Spine</label> 

 <% if(medExamObj.getSpine()!=null){%>
 <input tabindex="1" type="text" value="<%= medExamObj.getSpine() %>"	name="spine" class="Auto" size="20" maxlength="10" readonly="readonly" />
<%}else{ %>
<input tabindex="1" type="text"	name="spine" class="Auto" size="20" maxlength="10" readonly="readonly" />
<%} %>
<label>Hernia</label> 
 <% if(medExamObj.getHerniaMusic()!=null){%>

<input tabindex="1" type="text"	name="<%= HERNIA_MUSCLE %>" value="<%= medExamObj.getHerniaMusic() %>" class="Auto" size="20" maxlength="100" readonly="readonly" />
<%}else{ %>
<input tabindex="1" type="text"	name="<%= HERNIA_MUSCLE %>" class="Auto" size="20" maxlength="100" readonly="readonly" />
<%} %>
<div class="clear"></div>
<label >Hydrocele</label> 
 <% if(medExamObj.getHydrocele()!=null){%>
<input tabindex="1" type="text"	name="<%= HYDROCELE %>" value="<%= medExamObj.getHydrocele() %>" class="Auto" size="20" maxlength="10" readonly="readonly" />
<%}else{ %>
<input tabindex="1" type="text"	name="<%= HYDROCELE %>" class="Auto" size="20" maxlength="10" readonly="readonly" />
<%} %>
<label>Haemorrhoids</label> 
 <% if(medExamObj.getHemorrhoids()!=null){%>
<input tabindex="1" type="text"	name="<%=HEMONHOIDS %>" value="<%= medExamObj.getHemorrhoids() %>" class="Auto" size="20" maxlength="10" readonly="readonly" />
<%}else{ %>
<input tabindex="1" type="text"	name="<%=HEMONHOIDS %>" class="Auto" size="20" maxlength="10" readonly="readonly" />
<%} %>
<label>Breast</label> 
 <% if(medExamObj.getBreasts()!=null){%>
<input tabindex="1" type="text"	name="<%=BREASTS  %>" value="<%= medExamObj.getBreasts() %>" class="Auto" size="20" maxlength="10"readonly="readonly"  />
<%}else{ %>
<input tabindex="1" type="text"	name="<%=BREASTS  %>" class="Auto" size="20" maxlength="10"readonly="readonly"  />
<%} %>
<div class="clear"></div>
<label >Tympanic Membrance Intact</label>
 <% if(medExamObj.getTympanicMembranceIntact()!=null){%>
  
<input tabindex="1" type="text"	name="tympanicMembranceIntact" value="<%= medExamObj.getTympanicMembranceIntact() %>" class="Auto" size="20" maxlength="10" readonly="readonly" />
<%}else{ %>
<input tabindex="1" type="text"	name="tympanicMembranceIntact" class="Auto" size="20" maxlength="10" readonly="readonly" />
<%} %>
<label>Mobility</label>
 <% if(medExamObj.getMobility()!=null){%> 
<input tabindex="1" type="text"	name="mobility" value="<%=medExamObj.getMobility()  %>" class="Auto" size="20" maxlength="10" readonly="readonly" />
<%}else{ %>
<input tabindex="1" type="text"	name="mobility" class="Auto" size="20" maxlength="10" readonly="readonly" />
<%} %>
<label>Nose/Throat/Sinuses</label> 
 <% if(medExamObj.getNoseThroatSinuses()!=null){%>
<input tabindex="1" type="text"	name="noseThroatSinuses" value="<%= medExamObj.getNoseThroatSinuses() %>" class="Auto" size="20" maxlength="10" readonly="readonly" />
<%}else{ %>
<input tabindex="1" type="text"	name="noseThroatSinuses" class="Auto" size="20" maxlength="10" readonly="readonly" />
<%} %>
<div class="clear"></div>

<label> Remarks</label> <textarea rows="" cols="71"
	name="cmMdRemarks" class="auto" onkeyup="chkLength(this,50);"></textarea>
<div class="clear"></div>
</div>
  
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input tabindex="1" name="Button"	type="button" class="button" value="VALIDATE"	onClick="submitForm('medExamPrimaryMD','medicalExam?method=validateMedExam');" />
<input tabindex="1" name="Button"	type="button" class="button" value="REJECT"	onClick="submitForm('medExamPrimaryMD','medicalExam?method=rejectMedExam');" />
<input tabindex="1" class=button id=reset accessKey=r	onclick=resetCheck(); type=reset value=RESET name=Reset> 
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
	    submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=getPatientPreviousInvestigationForCopy&&visitNo='+visitNo+'&hinId='+hinId,'gridview');
}


</script></form>
