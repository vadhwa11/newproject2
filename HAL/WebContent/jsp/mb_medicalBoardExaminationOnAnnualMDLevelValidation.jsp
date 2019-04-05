
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
<%@page import="jkt.hms.masters.business.Users"%><script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
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
List patientDataList = new ArrayList();

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

try{
	
if(map.get("resultList") != null){
	resultList=(List)map.get("resultList");

	}
if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
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
String url="";
if(map.get("url") != null){
	url = (String)map.get("url");
}
List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
if(map.get("medExamList") != null){
	medExamList = (List<MasMedicalExaminationReportOnEntry>)map.get("medExamList");
	System.out.println("jsp item medExamList---"+medExamList.size());
}
MasMedicalExaminationReportOnEntry medExamObj = new MasMedicalExaminationReportOnEntry();

if(medExamList.size() > 0){
	medExamObj = medExamList.get(0);
}
Properties properties = new Properties();
URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
try {
	properties.load(resourcePath.openStream());
} catch (Exception e) {
 	e.printStackTrace();
}
 String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
 
%>
<% 

String jspheading=null;
if(map.get("jspheading") != null){
	jspheading = (String)map.get("jspheading");
}


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
<h2><%=jspheading %></h2>
</div>
<div class="clear"></div>
<form name="showCommandLevelJsp" action="" method="post">
<!--Block One Starts-->
<div class="Block">
<input type="hidden" name="medExamId" value="<%=medExamObj.getId() %>"/>
<input type="hidden" name="flag" value="md"/>

<label>Service Number </label>
 <% if(medExamObj.getServiceNo()!=null){%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=SERVICE_NO %>" tabindex="2" value="<%=medExamObj.getServiceNo() %>"/>
 <% }else{%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=SERVICE_NO %>" tabindex="2" />
 <% }%>
 <label>Rank  </label>
  <% if(medExamObj.getRank()!=null){%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=RANK %>" tabindex="2" value="<%=medExamObj.getRank().getRankName() %>"/>
 <input type="hidden" value="<%=medExamObj.getRank().getId() %>" name="<%=RANK_ID%>"	tabindex="2" />
 <% }else{%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=RANK %>" tabindex="2" />
 <% }%>
  

 
 <label>Name  </label> 
  <% if(medExamObj.getNameInFull()!=null){%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=FULL_NAME %>" tabindex="2" value="<%=medExamObj.getNameInFull() %>"/>
 <% }else{%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=FULL_NAME %>" tabindex="2" />
 <% }%>
 

 
 <div class="clear"></div>
 
 <label>Unit/Ship  </label> 
 <% if(medExamObj.getUnit()!=null){%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=UNIT %>" tabindex="2" value="<%=medExamObj.getUnit().getUnitName() %>"/>
 <input type="hidden" value="<%=medExamObj.getUnit().getId() %>" name="<%=UNIT_ID%>"	tabindex="2" />
 <% }else{%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=UNIT %>" tabindex="2" />
 <% }%>
 
 
 <label>Service IAF  </label> 
  <% if(medExamObj.getServiceType()!=null){%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="serviceiaf" tabindex="2" value="<%=medExamObj.getServiceType().getServiceTypeName() %>"/>
 
 <% }else{%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="serviceiaf" tabindex="2" />
 <% }%>
 
 
 <label>Branch/Trade  </label> 
  <% if(medExamObj.getTrade()!=null){%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=TRADE%>" tabindex="2" value="<%=medExamObj.getTrade().getTradeName() %>"/>
  <input	type="hidden"  name="<%=TRADE_ID%>"	tabindex="2" value="<%= medExamObj.getTrade().getId() %>"/>
 <% }else{%>
 <input type="text" readonly="readonly" maxlength="20" 	 name="<%=TRADE_ID%>" tabindex="2" />
 <% }%>
 

 
 <div class="clear"></div>

 <label>DOB  </label>
 <% if(medExamObj.getDateOfBirth()!=null){%>
 <input	tabindex="1" name="<%=DATE_OF_BIRTH %>" option value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateOfBirth())%>"	validate="Entry Date,date,yes" maxlength="10" class="date"	onKeyUp="mask(this.value,this,'2,5','/');" />

 <% }else{%>
<input	tabindex="1" name="<%=DATE_OF_BIRTH %>" option value=""	validate="Entry Date,date,yes" maxlength="10" class="date"	onKeyUp="mask(this.value,this,'2,5','/');" />

 <% }%>
  
  <img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" onclick="setdate('',showCommandLevelJsp.<%=DOB%>,event);" />
 
 <label>Age  </label> 
  <% if(medExamObj.getApparentAge()!=null){%>
<input	type="text" readonly="readonly" maxlength="20"  value="<%=medExamObj.getApparentAge() %>" name="apparentAge"	tabindex="2" />

 <% }else{%>
<input	type="text" readonly="readonly" maxlength="20"  value="" name="typeOfCommunication"	tabindex="2" />

 <% }%>
 

 <label>Type Of Comm <br /><span class="sublabel"> PC/SSC</span>  </label>
 <% if(medExamObj.getTypeofcommision()!=null){%>
<input	type="text" readonly="readonly" maxlength="20"  value="<%=medExamObj.getTypeofcommision() %>" name="typeOfCommunication"	tabindex="2" />

 <% }else{%>
<input	type="text" readonly="readonly" maxlength="20"  value="" name="typeOfCommunication"	tabindex="2" />

 <% }%>
 
 
 <div class="clear"></div>
 
 <label>Date of Comm  </label> 
 <% if(medExamObj.getDateofcommun()!=null){%>
 <input	tabindex="1" name="<%=DATE_COMMENCEMENT %>" option value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDateofcommun()) %>"	validate="Entry Date,date,no" maxlength="10" class="date"	onKeyUp="mask(this.value,this,'2,5','/');" />

 <% }else{%>
<input	tabindex="1" name="<%=DATE_COMMENCEMENT %>" value="<%=date %>"	validate="Entry Date,date,yes" maxlength="10" class="date"	onKeyUp="mask(this.value,this,'2,5','/');" />

 <% }%>
  <img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" 	onclick="setdate('',showCommandLevelJsp.<%=DATE_COMMENCEMENT%>,event);" />
 
 <label>Total Service  </label> 
 <% if(medExamObj.getTotalService()!=null){%>
 
 <input	type="text" readonly="readonly" maxlength="20"  value="<%=medExamObj.getTotalService() %>" name="<%=TOTAL_SERVICE%>"	tabindex="2" />

 <% }else{%>
<input	type="text" readonly="readonly" maxlength="20"  value="" name="<%=TOTAL_SERVICE%>"	tabindex="2" />

 <% }%>
 
 
 <label>Past Medical History  </label> 
 
 <% if(medExamObj.getPastmedicalhistory()!=null){%>
 
 <input	type="text" readonly="readonly" maxlength="20"  value="<%=medExamObj.getPastmedicalhistory() %>" name="<%=PAST_MEDICAL_HISTORY%>"	tabindex="2" />

 <% }else{%>
<input	type="text" readonly="readonly" maxlength="20"  value="" name="<%=PAST_MEDICAL_HISTORY%>"	tabindex="2" />

 <% }%>
 
 <div class="clear"></div>
 
 <label>Present Med Categ  </label> 
 <% if(medExamObj.getPresentmedicalhistory()!=null){%>
 
 <input	type="text" readonly="readonly" maxlength="20"  value="<%=medExamObj.getPresentmedicalhistory() %>" name="<%=PRESENT_MEDICAL_CATEGORY%>"	tabindex="2" />

 <% }else{%>
<input	type="text" readonly="readonly" maxlength="20"  value="" name="<%=PRESENT_MEDICAL_CATEGORY%>"	tabindex="2" />

 <% }%>

 
 
 <label >Last AME carried Out  </label> 
  <% if(medExamObj.getLastame()!=null){%>
 <input	type="text" readonly="readonly" maxlength="20"  value="<%=medExamObj.getLastame() %>" name="<%=LAST_AME%>"	tabindex="2" />
 <% }else{%>
<input	type="text" readonly="readonly" maxlength="20"  value="" name="<%=LAST_AME%>"	tabindex="2" />
 <% }%>
 
 <label >Sp Upload Date</label> 
<input	tabindex="1" name="<%=UPLOADED_DATE %>" id="uploadeddate" class="date" 	validate="DOB,date,no" maxlength="10"
	readonly="readonly"  onKeyUp="mask(this.value,this,'2,5','/');" value="<%=date %>"/> 
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" />      
 

</div>
<div class="clear paddingTop15"></div>
<h4>Dental <a href="javascript:animatedcollapse.toggle('slide1')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide1">
<div class="Block">
<div class="clear"></div>
<label >Total no. of Teeth</label>
  <% if(medExamObj.getTotalTeeth()!=null){%>
 
 <input tabindex="1"	type="text" readonly="readonly" maxlength="20"  name="<%=TOTAL_NO_OF_TEETH %>" class="small" value="<%=medExamObj.getTotalTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" /> 

 <% }else{%>
<input tabindex="1"	type="text" readonly="readonly" maxlength="20"  name="<%=TOTAL_NO_OF_TEETH %>" class="small"
	onKeyUp="isNumber(this)" maxlength="2" /> 

 <% }%>
 
	
<label class="auto">Total No. of Defective Teeth</label>
 <% if(medExamObj.getTotalDefectiveTeeth()!=null){%>
<input tabindex="1"	type="text" readonly="readonly" maxlength="20"  name="<%=DEFECTIVE_TEETH %>" class="small" value="<%=medExamObj.getTotalDefectiveTeeth() %>"
	onKeyUp="isNumber(this)" maxlength="2" /> 


 <% }else{%>
<input tabindex="1"	type="text" readonly="readonly" maxlength="20"  name="<%=DEFECTIVE_TEETH %>" class="small"
	onKeyUp="isNumber(this)" maxlength="2" /> 


 <% }%>
	<label class="auto">Total no. of Dental Point</label> 
	<% if(medExamObj.getDenstlPoint()!=null){%>
	<input	tabindex="1" type="text" readonly="readonly" maxlength="20"  name="<%=DENTSL_POINT %>" value="<%=medExamObj.getDenstlPoint() %>"
	onKeyUp="isNumber(this);" maxlength="2" /> 


 <% }else{%>
	<input	tabindex="1" type="text" readonly="readonly" maxlength="20"  name="<%=DENTSL_POINT %>"
	onKeyUp="isNumber(this);" maxlength="2" />


 <% }%>

	<div class="clear"></div>
	
<label >Missing </label> 
	<% if(medExamObj.getMissingTeeth()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);" value="<%=medExamObj.getMissingTeeth() %>"
	maxlength="2" />
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 
	name="<%=MISSING_TEETH %>" class="small" onKeyUp="isNumber(this);"
	maxlength="2" />
 <% }%>
<label class="auto">Unservicable</label>
<% if(medExamObj.getUnservisableTeeth()!=null){%>
<input	tabindex="1" type="text" readonly="readonly" maxlength="20"  name="<%=MISSING_UNSERVICABLE_TEETH %>" value="<%=medExamObj.getUnservisableTeeth() %>"
	class="small" onKeyUp="isNumber(this);" maxlength="2" />

 <% }else{%>
<input	tabindex="1" type="text" readonly="readonly" maxlength="20"  name="<%=MISSING_UNSERVICABLE_TEETH %>"
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
 <% if(medExamObj.getRemarksTeath()!=null){%>
 <textarea rows="" cols=""  readonly="readonly"  readonly="readonly"  readonly="readonly"	name="<%=DENTAL_REMARKS %>" class="large" onkeyup="chkLength(this,50);" value="<%=medExamObj.getRemarksTeath() %>"></textarea>

 <% }else{%>
 <textarea rows="" cols=""  readonly="readonly"  readonly="readonly"  readonly="readonly"	name="<%=DENTAL_REMARKS %>" class="large" onkeyup="chkLength(this,50);"></textarea>
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
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="weight"class="date"	 name="<%=ACTUAL_WEIGHT %>" maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);calculateBMI();" /><label class="smallAuto">kg</label>

 <% }%>


<label	>Ideal Weight</label> 
  <% if(medExamObj.getIdealweight()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id=""class="date"	 name="<%=IDEAL_WEIGHT %>" maxlength="6" value="<%=medExamObj.getIdealweight() %>"
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" class="date"	name="<%=IDEAL_WEIGHT %>" maxlength="6" 
	onKeyUp="limitText(this,6);" onblur="checkForWiegth(this.value,id);" /><label class="smallAuto">kg</label>

 <% }%>

<div class="clear"></div>
<label	>Over Weight</label> 
  <% if(medExamObj.getOverweight()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=OVER_WEIGHT %>"class="date"	 maxlength="6" value="<%=medExamObj.getOverweight() %>"
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
	onKeyUp="limitText(this,6);"  /><label class="smallAuto">cm</label>

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=CHEST_FULL %>" class="date"	 maxlength="6" 
	onKeyUp="limitText(this,6);"  /><label class="smallAuto">cm</label>

 <% }%>

<div class="clear"></div>
<label>Range Of Expansion</label> 
  <% if(medExamObj.getRangeofexpansion()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=RANGE_EXPANSION %>" maxlength="6" value="<%=medExamObj.getRangeofexpansion() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=RANGE_EXPANSION %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }%>


<label	>BMI</label> 
  <% if(medExamObj.getBhi()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="bmi" name="<%=BHI %>" maxlength="6" value="<%=medExamObj.getBhi() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="bmi" name="<%=BHI %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }%>


<label	>Body Fat</label> 
  <% if(medExamObj.getBodyfat()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=BODY_FAT %>"maxlength="6" value="<%=medExamObj.getBodyfat() %>"
	onKeyUp="limitText(this,6);"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=BODY_FAT %>" maxlength="6" 
	onKeyUp="limitText(this,6);"  />

 <% }%>
<div class="clear"></div>
<label	>Skin Fold Thickness</label> 
  <% if(medExamObj.getSignfoldthickness()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=THICKNESS %>" maxlength="6" value="<%=medExamObj.getSignfoldthickness() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=THICKNESS %>" maxlength="6" 
	onKeyUp="limitText(this,6);" class="auto" size="20"  />

 <% }%>

<label	>Sports Man</label> 
<!-- Commented By Ritu as per testing at 412 AFS  Date: 22 June 2011-->
<%--  <% if(medExamObj.getSportman()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=SPORTS %>" maxlength="6" value="<%=medExamObj.getSportman() %>"
	onKeyUp="limitText(this,6);" class="auto" size="20" />
 <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  id="" name="<%=SPORTS %>"  maxlength="6"
	onKeyUp="limitText(this,6);" class="auto" size="20" />

 <% }%> --%>
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
<div class="clear"></div>
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

<h4> Ear <a	href="javascript:animatedcollapse.toggle('slide4')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide4">
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
<tr>		
<% 
    int index = 0;
    int indexForSingle = 0;
    int indexForMultiple = 0;
    
   System.out.println("Size :"+resultList.size());
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
				value="<%=dgDetail.getResultEntry().getId()%>"> </input> <input
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
				value="<%=dgDetail.getResultEntry().getId()%>"> </input> <input
				type="button" class="cmnButton" style="width: auto;"
				value="Click Here To Fill Result"
				onclick="openTemplateScreen('<%=index%>');" align="right" /></td>
			<td></td>

		</tr>
		<%	
		
		}else if(dgDetail.getInvestigation().getInvestigationType().equals("m")){ 
		 System.out.println("resultEntryIndex::"+index);
		 System.out.println("resultEntryIndexForMultiple::"+indexForMultiple);
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

<div class="Clear paddingTop15"></div>

<h4> CARDIO VASCULAR SYSTEM <a	href="javascript:animatedcollapse.toggle('slide6')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide6">
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

<h4>RESPIRATORY SYSTEM <a href="javascript:animatedcollapse.toggle('slide7')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide7">
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


<h4>GASTRO INTESTINAL SYSTEM <a	href="javascript:animatedcollapse.toggle('slide8')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide8">
<div class="Block">
<div class="clear"></div>
<label > Liver Palpalable</label> 
<% if(medExamObj.getLiver()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="liver" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getLiver() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="liver" class="Auto" size="20" maxlength="20" />
 <% }%>


<label class="auto"> Spleen Palpalable</label> 
<select name="spleen" size="0" tabindex="1" id="spleenpalpalable" disabled="disabled">
	<option value="0">select</option>
	<option value="Yes">Yes</option>
	<option value="No">No</option>
</select>
<script>
<%
if(medExamObj.getSpleen()!= null){
%>
document.getElementById('spleenpalpalable').value='<%=medExamObj.getSpleen()%>';

<%}%>
</script>
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
	<option value="Fairly Steady">Fairly Steady</option>
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
</div>
</div>
<div class="clear paddingTop15"></div>

<h4>GYNAECOLOGY EXAM <a href="javascript:animatedcollapse.toggle('slide10')">(Click Here)</a></h4>
<div class="clear"></div>
<div id="slide10">
<div class="Block">

<label >Menstrual History</label>
<% if(medExamObj.getMenstrualHistory()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=MENSTRUAL_HISTORY %>" class="Auto" size="20" maxlength="30" value="<%=medExamObj.getMenstrualHistory() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=MENSTRUAL_HISTORY %>" class="Auto" size="20" maxlength="30" />
 <% }%>
 

<label>LMP</label>
<% if(medExamObj.getLmp()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=LMP %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getLmp() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=LMP %>" class="Auto" size="20" maxlength="20" />
 <% }%>

<label >No. of pregnancies</label>
<% if(medExamObj.getNoOfPregnancies()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=NO_OF_PREGNANCY %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getNoOfPregnancies() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=NO_OF_PREGNANCY %>" class="Auto" size="20" maxlength="20" />
 <% }%>

<div class="clear"></div>	
<label >No of Abortions</label>
<% if(medExamObj.getNoOfAbortions()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=NO_OF_ABORTION %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getNoOfAbortions() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=NO_OF_ABORTION %>" class="Auto" size="20" maxlength="20" />
 <% }%>
<label >No. of Children</label> 
<% if(medExamObj.getNoOfChildren()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=NO_OF_CHILDREN %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getNoOfChildren() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=NO_OF_CHILDREN %>" class="Auto" size="20" maxlength="20" />
 <% }%>


<label >Date <br /><span class="sublabel">(last confinement)</span></label>
<% if(medExamObj.getLastConfinementDate()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  class="calDate" readonly="readonly " value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getLastConfinementDate()) %>"	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" /> 
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  class="calDate" readonly="readonly "	name="<%=DATE_OF_LASTCONFINEMENT %>" maxlength="10" onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" /> 
 <% }%>


<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',showCommandLevelJsp.<%=DATE_OF_LASTCONFINEMENT%>,event);" />
<div class="clear"></div>
<label >Vaginal Discharge</label>
<% if(medExamObj.getVaginalDischarge()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=VAGINAL_DISCHARGE %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getVaginalDischarge() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=VAGINAL_DISCHARGE %>" class="Auto" size="20" maxlength="20" />
 <% }%>
 

<label	>Prolapse</label> 
<% if(medExamObj.getProlapse()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=PROLAPSE %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getProlapse() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=PROLAPSE %>" class="Auto" size="20" maxlength="20" />
 <% }%>


<label >USG Abdomen</label> 
<% if(medExamObj.getUsgAbdomen()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=USG_ABORTION %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getUsgAbdomen() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=USG_ABORTION %>" class="Auto" size="20" maxlength="20" />
 <% }%>

<div class="clear"></div>


<label>Date</label>
<% if(medExamObj.getGynaecologyDate()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  class="calDate"	name="<%=GYANAECOLOGY_DATE%>" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');"	validate="Dental Date,date,no" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getGynaecologyDate()) %>"/> 
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  class="calDate"	name="<%=GYANAECOLOGY_DATE%>" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');"	validate="Dental Date,date,no" /> 
 <% }%>


<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	class="date"
	onclick="setdate('',showCommandLevelJsp.<%=GYANAECOLOGY_DATE%>,event);" />
<label >Remarks</label> 
<% if(medExamObj.getRemarksGynaecology()!=null){%>
 <textarea rows="" cols="71"  readonly="readonly"  name="<%=GYANAECOLOGY_RAMARKS %>" class="auto" onkeyup="chkLength(this,50);" value="<%=medExamObj.getRemarksGynaecology() %>"></textarea>

 <% }else{%>
 <textarea rows="" cols="71"  readonly="readonly"  name="<%=GYANAECOLOGY_RAMARKS %>" class="auto" onkeyup="chkLength(this,50);"></textarea>
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
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=GIVE_ON %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getGiveOn() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=GIVE_ON %>" class="Auto" size="20" maxlength="20" />
 <% }%>
<label >Batch No</label> 
<% if(medExamObj.getBatchNo()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=BATCH_NO %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getBatchNo() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=BATCH_NO %>" class="Auto" size="20" maxlength="20" />
 <% }%>


<label >DOM</label> 
<% if(medExamObj.getDom()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  class="calDate" readonly="readonly " name="<%=DOM %>" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" value="<%=HMSUtil.convertDateToStringWithoutTime(medExamObj.getDom()) %>"/> 
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20"  class="calDate" readonly="readonly " name="<%=DOM %>" maxlength="10"	onKeyUp="mask(this.value,this,'2,5','/');" validate="Dental Date,date,no" />  <% }%>
<img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',showCommandLevelJsp.<%=DOM%>,event);" />

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
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=CORONORY_RISK_FACTOR %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getCoronaryRiskFactor() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=CORONORY_RISK_FACTOR %>" class="Auto" size="20" maxlength="20" />
 <% }%>


<label class="auto">F.M. of DM/Malignancy/HTM/Hyperlypidemia/Arthritis</label> 
<% if(medExamObj.getFmdm()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=FM_DM %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getFmdm() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=FM_DM %>" class="Auto" size="20" maxlength="20" />
 <% }%>
<div class="clear"></div>
<label >Any Known Allergy</label> 
<% if(medExamObj.getAllergies()!=null){%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=KNOWN_ALLERGY %>" class="Auto" size="20" maxlength="20" value="<%=medExamObj.getAllergies() %>"/>
   <% }else{%>
<input tabindex="1" type="text" readonly="readonly" maxlength="20" 	name="<%=KNOWN_ALLERGY %>" class="Auto" size="20" maxlength="20" />
 <% }%>


<label >Approved By</label>

<select id="<%=APPROVED_BY %>"	disabled="disabled" name="<%= APPROVED_BY %>" 	validate="Approved By,string,no" tabindex=1>
	<option value="">Select</option>
	<%
		Users user = (Users)session.getAttribute("users");
		Integer userId =user.getEmployee().getId();
		String mname=" ";
		System.out.println("employeeListjsp--"+employeeList.size());
			for (MasEmployee masEmployeecode : employeeList) {
				if(masEmployeecode.getEmpCategory() != null){
					if( masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor) ){
						if ((medExamObj.getApprovedBy()!=null)&&(masEmployeecode.getId()==Integer.parseInt(medExamObj.getApprovedBy()))) {
					if(masEmployeecode.getMiddleName()!=null)
					{
						mname=masEmployeecode.getMiddleName();
					}
					System.out.println("hi");
		%>
	<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=mname%>
	<%=masEmployeecode.getLastName()%></option>
	<%}else{
		System.out.println("hi1");
		%>
	<option value="<%=masEmployeecode.getId ()%>"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=mname%>
	<%=masEmployeecode.getLastName()%></option>
	<%	}}	}}	%>
</select> 

<div class="clear"></div>

<label class="">Signed By</label> 

<select id="signidBy" value="<%=medExamObj.getSignedBy() %>"	disabled="disabled" name="<%= SIGNED_BY %>"	validate="Signed By,string,no" tabindex=1>
	<option value="">Select</option>
	<%
		Users user1 = (Users)session.getAttribute("users");
		Integer userId1 =user1.getEmployee().getId();
		String mname1=" ";
		System.out.println("employeeListjsp--"+employeeList.size());
			for (MasEmployee masEmployeecode : employeeList) {
				if(masEmployeecode.getEmpCategory() != null){
					if( masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor) ){
					
				if ((medExamObj.getSignedBy()!=null)&&(masEmployeecode.getId()==Integer.parseInt(medExamObj.getSignedBy()))) {
					if(masEmployeecode.getMiddleName()!=null)
					{
						mname1=masEmployeecode.getMiddleName();
					}
				%>
	<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=mname1%>
	<%=masEmployeecode.getLastName()%></option>
	<%}else{%><option value="<%=masEmployeecode.getId ()%>"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=mname1%>
	<%=masEmployeecode.getLastName()%></option>
	<%	}}	}}	%>
</select> 




<label>Send To</label> 

<select name="<%=SEND_TO %>" size="0" tabindex="1" id="sendto" disabled="disabled" >
	<option value="0">select</option>
	<option value="AFRO">AFRO</option>
	<option value="MO">MO</option>
	<option value="DPMO-COMMAND">DPMO-COMMAND</option>
	<option value="CO/ST CDR">CO/ST CDR</option>
	<option value="No">No</option>
</select>
<script>
<%
if(medExamObj.getSendTo()!= null){
%>
document.getElementById('sendto').value='<%=medExamObj.getSendTo()%>';

<%}%>
</script>
<div class="clear"></div>
 
<label > Remarks</label>
<% if(medExamObj.getCommandRemarks()!=null){%>
<textarea rows="" cols="71"  readonly="readonly"  readonly="readonly"  readonly="readonly"	name="cmMdRemarks" class="auto" onkeyup="chkLength(this,50);"><%=medExamObj.getCommandRemarks()%></textarea>
   <% }else{%>
<textarea rows="" cols="71"  readonly="readonly"  readonly="readonly"  readonly="readonly"	name="cmMdRemarks" class="auto" onkeyup="chkLength(this,50);"></textarea>
 <% }%>
<div class="clear"></div>
</div>
</div>

  
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input tabindex="1" name="Button"	type="button" class="button" value="VALIDATE"	onClick="submitForm('showCommandLevelJsp','medicalExam?method=validateMedExam');" />
<input tabindex="1" name="Button"	type="button" class="button" value="REJECT"	onClick="submitForm('showCommandLevelJsp','medicalExam?method=rejectMedExam');" />
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
