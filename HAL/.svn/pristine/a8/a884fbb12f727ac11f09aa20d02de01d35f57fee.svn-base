<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.Disability"%>
<%@page import="jkt.hms.masters.business.Disabilitygroup"%>
<%@page import="jkt.hms.masters.business.Category"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>

<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasSection"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%><script
	type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>

<!-- <link href="/hms/jsp/css/test.css" rel="stylesheet" type="text/css" /> -->

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
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

		function checkYear()
		{
			var year=document.getElementById('yearId').value;
			if(year=='0')
			{	
				alert("Please Select the Year");
               return false;
		    }
			else
			{
				return true;
			}			
		}	
	</script>

<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}

	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
	String userName = "";
	String message = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	List<MasRank> rankList = new ArrayList<MasRank>();
	if (map.get("rankList") != null) {
		rankList = (List) map.get("rankList");
	}

	List<MasMedicalExaminationReportOnEntry> medicalExamdetail = new ArrayList<MasMedicalExaminationReportOnEntry>();
	List<MasServiceType> serviceTypeList = null;
	List<MasServiceStatus> serviceStatusList = null;
	List<MasSection> sectionList = null;
	List<MasRankCategory> rankCategoryList = null;
	List<MasAdministrativeSex> genderList = null;
	if (map.get("patientDetailList") != null) {
		medicalExamdetail = (List) map.get("patientDetailList");
	}
	
	
	List<MasEmployee> patientList = new ArrayList<MasEmployee>();

	if (map.get("patientList") != null) {
		patientList = (List) map.get("patientList");
		
	}
	List<MasCommand> commandList = null;
	List<MasUnit> unitList = null;
	List<MasTrade> tradeList = null;
	List<Disability> DisabilityList = null;
	List<Disabilitygroup> DisabilitygroupList = null;
	List<Category> CategoryList = null;
	List<MasBloodGroup> bloodGroupList = null;
	List<MasIcd>itemList = null;
	if(map.get("commandList") != null){
					commandList = (List<MasCommand>)map.get("commandList");
				}
	if(map.get("unitList") != null){
					unitList= (List<MasUnit>)map.get("unitList");
				}
	if(map.get("genderList") != null){
		genderList= (List<MasAdministrativeSex>)map.get("genderList");
	}
	if(map.get("rankCategoryList") != null){
		rankCategoryList= (List<MasRankCategory>)map.get("rankCategoryList");
	}
	if(map.get("rankCategoryList") != null){
		rankCategoryList= (List<MasRankCategory>)map.get("rankCategoryList");
	}
	if(map.get("sectionList") != null){
		sectionList= (List<MasSection>)map.get("sectionList");
	}
	if(map.get("serviceTypeList") != null){
		serviceTypeList= (List<MasServiceType>)map.get("serviceTypeList");
	}
	if(map.get("serviceStatusList") != null){
		serviceStatusList= (List<MasServiceStatus>)map.get("serviceStatusList");
	}
	if(map.get("unitList") != null){
		unitList= (List<MasUnit>)map.get("unitList");
	}
	if(map.get("tradeList") != null){
					tradeList = (List<MasTrade>)map.get("tradeList");
				}
	if(map.get("DisabilityList") != null){
		DisabilityList = (List<Disability>)map.get("DisabilityList");
		
	}
	if(map.get("DisabilitygroupList") != null){
		DisabilitygroupList = (List<Disabilitygroup>)map.get("DisabilitygroupList");
	}
	if(map.get("CategoryList") != null){
		CategoryList = (List<Category>)map.get("CategoryList");
	}
	if(map.get("bloodGroupList") != null){
		bloodGroupList = (List<MasBloodGroup>)map.get("bloodGroupList");
	}
	if(map.get("itemList") != null)
	  {
		itemList = (List)map.get("itemList");
	  }
	if (map.get("message") != null) {
		message = (String) map.get("message");
	}
	String searchtype=null;
	if (map.get("searchtype") != null) {
		searchtype = (String) map.get("searchtype");
		
	}
  %>
<script type="text/javascript" language="javascript">
function PrintGraph()
{
	var year1=document.getElementById('yearId').value;
	var url="/hms/hms/medicalExam?method=showMedicalExamRegisterGraph&year="+year1;
	window.open(url,'name',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=1");
	}
	function createSillyWindow()
	{
		//window.open("about:blank", "mySillyWindow","left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	}

function submitOne()
{
	var xmlHttp;
	alert("1 ");
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
  alert("2");
    xmlHttp.onreadystatechange=function()
    {
    if (xmlHttp.readyState>0 && xmlHttp.readyState<4){
     document.getElementById(tab).innerHTML='<font id="error">Loading...</font>'
      document.getElementById(tab).innerHTML=""
    }else
      if(xmlHttp.readyState==4){
         document.getElementById(tab).innerHTML = xmlHttp.responseText;
        
      }
    }
    alert("3-1");
    var so = new SWFObject("/hms/jsp/chart/amcolumn.swf", "amcolumn", "290", "230", "8", "#FFFFFF");
    alert("3-2");
	so.addVariable("path", "/hms/jsp/chart/");
	 alert("3-3");
	so.addVariable("settings_file", encodeURIComponent("/hms/jsp/chart/amcolumn_settings.xml"));
	 alert("3-4");
	so.addVariable("data_file",  encodeURIComponent("/hms/jsp/chart/amcolumn_data.xml"));
	so.addVariable("preloader_color", "#999999");
	so.write("flashcontent");
	alert("4");
	
	xmlHttp.open("GET","/hms/hms/medicalExam?method=pendingMDWatingList&searchtype=graphInjsp",true);
    
	xmlHttp.send(document.patientSearch);
	alert("5");
	
//	document.patientSearch.action = "/hms/hms/medicalExam?method=pendingMDWatingList&searchtype=graphInjsp";
//	document.patientSearch.submit();
//	createSillyWindow();
}

</script>
<%
	
	if (!message.equalsIgnoreCase("")) {
%>
<h4><%=message%></h4>
<%
	}
%>
<script type="text/javascript" language="javascript">
function SetInterval()
		{
        var  curr1=new Date();
	     	
		var interval=document.getElementById("IntervalId").value;
		var serviceStartDate=document.getElementById('IntervalTo').value;
		var elem = serviceStartDate.split('/');
		var currDay1 = elem[0];
		var monthNow1 = elem[1];
		var yearNow1 = elem[2];
		
		
		if(interval=="12")
		{
			 yearNow1 = parseInt(yearNow1) - 1;
			
		}else if(interval=="4"){
			monthNow1=monthNow1-4;
			if(monthNow1<0)
			{
				monthNow1=0;
				yearNow1 = parseInt(yearNow1)- 1;
			}
		}else{
			monthNow1 = parseInt(monthNow1)- 1;
			if(monthNow1>12)
			{
				monthNow1=0;
				yearNow1 = parseInt(yearNow1)+ 1;
			}
		}
		if(monthNow1.toString().length<2){
			monthNow1="0"+monthNow1;
		}
		if(currDay1.toString().length<2){
			currDay1="0"+currDay1;
		}
		  var   currDateStr   = currDay1 + "/" + monthNow1 + "/" + yearNow1;
	     document.getElementById("IntervalFrom").value=currDateStr;
	  }

</script>

<h4>Search By Any Field Name</h4>
<form name="patientSearch" action="" method="post">
<div class="Block"><label>Choose Disability</label> <input
	type="text" tabindex="1" value="" id="icd" name="icd" size="27"
	class="auto" />
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
  new Ajax.Autocompleter('icd','ac2update','medicalBoard?method=getSystemDiagList',{parameters:'requiredField=icd'});
   //document.getElementById('slide0').style.display="hide"
  </script> <%--<input type="text" name="Disability" tabindex="1" class="autoArial" size="6">
<select id="disabilityid" name="disabilityId"  tabindex="1" validate="Unit,string,no"  >

<option value="0">Select</option>
		<%
			if(DisabilityList!=null && DisabilityList.size() > 0){
				for(Disability Disability : DisabilityList){
		%>
		<option value="<%= Disability.getDisabilityid() %>"><%=Disability.getDisability() %></option>
		<%
				}
				} %>
				</select>

--%> <!--<input type="text" tabindex="1"	value="" id="icd"  name="icd"	class="autoArial"  size="25" onblur="fillDiagnosisCombo(this.value);" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','medicalExam?method=getICDList',{parameters:'requiredField=icd'});
		   //document.getElementById('slide0').style.display="hide"
</script>

--> <!--<select name="typeOfCommunication" size="0" tabindex="1" id="typeOfCommunication">
<option value="0">< itemList %> </option>
	
	
</select>
--> <!--<label class="auto">Disabilities(%)</label> 
<input type="text" name="Disability" tabindex="1" class="autoArial" size="6">
--> <%-- <select id="disabilityid" name="disabilityId"  tabindex="1" validate="Unit,string,no"  >

<option value="0">Select</option>
		<%
			if(DisabilityList!=null && DisabilityList.size() > 0){
				for(Disability Disability : DisabilityList){
		%>
		<option value="<%= Disability.getDisabilityid() %>"><%=Disability.getDisability() %></option>
		<%
				}
				} %>
				</select>
--%> <!--<label class="auto">Disability Group (%)</label> 
<input type="text" name="Disabilitygroup" tabindex="1" class="autoArial" size="1">
--> <%--<select id="disabilityid" name="disabilityGroupId" tabindex="1" validate="Unit,string,no"  >
<option value="0">Select</option>
		<%
			if(DisabilitygroupList!=null && DisabilitygroupList.size() > 0){
				for(Disabilitygroup Disabilitygroup : DisabilitygroupList){
		%>
		<option value="<%= Disabilitygroup.getGroupid() %>"><%=Disabilitygroup.getDiseaseGroups() %></option>
		<%
				}
				} %>
				</select>

 --%>
 <div class="clear"></div>
 <label>Date</label>

<label class="medium"> From <span>*</span> </label> 
<input
	type="text" id="fromDateId" name="<%=FROM_DATE %>" 
	value="<%=currentDate%>" class="date" readonly="readonly"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=FROM_DATE%>,event)" />

<label> To <span>*</span> </label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" class="date"
	readonly="readonly" MAXLENGTH="30" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<label>Rank </label>
<label class="medium">From </label>
 <select id="searchField2" name="fromrankId" id ="fromrankId" tabindex="1" class="select_adt">
	<option value="0">Select</option>
	<%
		for (MasRank masRank : rankList) {
	%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
		}
	%>
</select>
<label>To </label> 
	<select	id="torankId" name="toRankId" tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasRank masRank : rankList) 
				{
			 		%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			 		}%>
</select> 
<div class="clear"></div>
<label>Age</label>
<label class="medium">From</label>
 <input name="AgeFrom" class ="smallest" size="1" id="AgeFrom" type="text" tabindex="1" maxlength="7" />
 <select id="fromageUnitId" name="fromAgeUnit"	 tabindex="1" class="small">
	<option value="">Select</option>
	<option value="Years" selected="selected">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 
<label>To</label>
 <input name="<%=TO %>" id="AgeTo" type="text" class="smallest" size="2" tabindex="1" maxlength="7" />
 <select id="toageUnitId" name="toAgeUnit"	tabindex="1" class="small">
	<option value="">Select</option>
	<option value="Years" selected="selected">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 
<div class="Clear"></div>
<label>Total Service:</label>
<label class="medium"> From </label>

<select id="fromServId"	name="fromServ" tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="fromServUnitId" name="fromServUnit"	 tabindex="1" class="small">
	<option value="">Select</option>
	<option value="Years" selected="selected">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 

<label> To </label>

<select id="toServId"	name="toServ"  tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="toServUnitId" name="toServUnit"	tabindex="1" class="small">
	<option value="">Select</option>
	<option value="Years" selected="selected">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 
<div class="clear"></div>
<div class="Clear"></div>	
<label>Service Type </label> 
<input type="text" class="transparent" size="14">
<select id="serviceTypeId" name="<%=SERVICE_TYPE_ID %>"	tabindex="1">
	<option value="0">Select</option>

	<% 
			for(MasServiceType masServiceType : serviceTypeList){
		%>
	<option value="<%=masServiceType.getId() %>"><%=masServiceType.getServiceTypeName() %></option>
	<%
				}%>
</select>

<label>Service Status </label> 
<select id="serviceStatusId" name="<%=SERVICE_STATUS_ID %>"	tabindex="1">
	<option value="0">Select</option>

	<% 
			for(MasServiceStatus masServiceStatus : serviceStatusList){
		%>
	<option value="<%=masServiceStatus.getId() %>"><%=masServiceStatus.getServiceStatusName() %></option>
	<%
				}%>
</select>


<div class="Clear"></div>
<div class="Clear"></div>
<label>Rank Category</label> 
<input type="text" class="transparent" size="14">
	<select	id="rankCatId" name="<%=RANK_CATEGORY_ID%>" tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasRankCategory masRankCat : rankCategoryList) 
				{
			 		%>
	<option value="<%=masRankCat.getId()%>"><%=masRankCat.getRankCategoryName()%></option>
	<%
			 		}%>
</select> 
<label> Trade/ Branch</label> <select id="tradeId" name="<%=TRADE_ID%>"
	validate="Trade,string,no" tabindex="1">
	<option value="0">Select</option>
	<% if(tradeList!= null){
			for(MasTrade trade :tradeList){ %>
	<option value=<%=trade.getId()%>><%=trade.getTradeName() %></option>
	<%}} %>
	<!--<option value="other">Other</option>-->
</select> 
  <%--  <fieldset>
 
<legend>Weight Details</legend> 
<label>Ideal Wt.</label>
<select id="searchField2"	name="<%=WEIGHT %>" tabindex="1" class="small" >
	<option value="0">Select</option>
	<%
		for (int i=1;i<100 ;i++) {
	%>
	<option value="<%=i%>"><%=i%></option>
	<%
		}
	%>
	</select>
<label>Co-morbidity</label>
<select id="searchField2" 	name="<%=WEIGHT %>" tabindex="1" class="small">
	<option value="0">Select</option>
	<%
		for (int i=1;i<100 ;i++) {
	%>
	<option value="<%=i%>"><%=i%></option>
	<%
		}
	%>
	</select>

<label>Life Style Factors</label>
<select id="searchField2"	name="LifeStyleFactor" tabindex="1" class="small">
	<option value="0">Select</option>
	<%
		for (int i=1;i<4 ;i++) {
	%>
	<option value="<%=i%>"><%=i%></option>
	<%
		}
	%>
	</select>
<label>Blood Group</label>
<select id="searchField2"	name="<%=BLOOD_GROUP_ID %>" tabindex="1" class="small">
	<option value="0">Select</option>
	<%
		for (MasBloodGroup  MasBloodGr : bloodGroupList ) {
	%>
	<option value="<%=MasBloodGr.getId()%>"><%=MasBloodGr.getBloodGroupName()%></option>
	<%
		}
	%>
	</select>
	</fieldset>
<div class="clear"></div>
<label>Gender</label> 
<select name="Gender" size="0" tabindex="1" id="GenderId">
<option value="">select</option>
	<option value="Male">Male</option>
	<option value="Female">Female</option>
	
</select>



<div class="clear"></div>

<fieldset class="small">
<div class="clear"></div>
<input type="checkbox" name="SearchOverDue" class="radioAuto" value="Search Over Due" />
 <label> Search Over Due </label> 
<div class="clear"></div>

</fieldset>
--%>
<div class="clear"></div>
 <label>Category(% or LMC)</label> 
 <input type="text" class="transparent" size="14">
 <select id="disabilityid"
	name="CategoryId" tabindex="1" validate="Unit,string,no">
	<option value="">Select</option>
	<%
			if(CategoryList != null &&    CategoryList.size() > 0 ){
				for(Category Category : CategoryList){
		%>
	<option value="<%=Category.getCategories() %>"><%=Category.getCategories() %></option>
	<%
				}
				} %>
</select>
<label>Gender</label> 
<select name="<%=GENDER %>" size="0" tabindex="1" id="GenderId">
<option value="">select</option>
<%if(genderList.size()>0){
	for(MasAdministrativeSex gender : genderList){
	%>
	<option value="<%=gender.getId() %>"><%=gender.getAdministrativeSexName() %></option>
	<%}} %>
	
</select>

<div class="clear"></div>
<label>Unit</label>
<input type="text" class="transparent" size="14">
 <select id="unitId" name="<%=UNIT_ID %>"
	tabindex="1" validate="Unit,string,no">
	<option value="0">Select</option>
	<%   if(unitList != null)
			     {
					 for(MasUnit masUnit : unitList){
					
					 %>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>

	<%
					 }}%>
	<!--<option value="other">Other</option>
-->
</select> <label>Command</label> <select id="commandId" name="<%=COMMAND %>"
	validate="Command,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
			if(commandList != null && commandList.size() > 0){
				for(MasCommand command : commandList){
		%>
	<option value="<%= command.getId() %>"><%=command.getCommandName() %></option>
	<%
				}
				} %>

	<!--<option value="other">Other</option>	
-->
</select>
<div class="clear"></div>
<label>Section</label> 
<input type="text" class="transparent" size="14">
<select id="sectionId" name="<%=SECTION_ID%>" tabindex="1">
	<option value="0">Select</option>
	<%
	 for(MasSection masSection : sectionList){
		
	 %>
	<option value="<%=masSection.getId()%>"><%=masSection.getSectionName()%></option>

	<%}
	%>

</select>



<%-- <label>Date as on </label> <input tabindex="1" type="text"
	name="DateAson" class="calDate" maxlength="10" id="DateAson"
	onKeyUp="mask(this.value,this,'2,5','/');"
	validate="Reported Date,date,no" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender" onclick="setdate('',patientSearch.DateAson,event);" />--%>
<label> Service No.</label>
 <input type="text" name="<%=SERVICE_NO %>" id="serviceNo" value="" MAXLENGTH="30" validate="Service No,alphanumeric,no" />
<div class="clear"></div>
<label>Over Weight</label>
<input type="checkbox" name="overWeight" tabindex="1" class="radioAuto"  value = "y"/>
<label>Overdue</label>
<input type="checkbox" name="overdue" tabindex="1" class="radioAuto"   value = "y"/>
<label>Rejection</label>
<input type="checkbox" name="rejection" tabindex="1" id="rejectId" class="radioAuto" value="r" />
<div class="clear"></div>
<h4>Trend Analysis</h4>
<div class="clear"></div>
<%--<label class="">Trend Analysis</label>  
<input type="checkbox" name="TrendAnalysis" value="Trend Analysis" class="radioAuto"/> --%>
<label class="">Year </label> <select name="year" size="0" tabindex="1"
	id="yearId">
	<option value="0">select</option>
	<% int month1=Integer.parseInt(month);
       for(int i=2000;i<=year;i++)
 	   {
 		 if(month1>3)
 		 {	 
 			String nextYear=""+i+"-"+(i+1); 
 	     %>
	<option value="<%=nextYear %>"><%=nextYear %></option>
	<%}else
 		 {
 		   if((i-1)>=2011)
 		   {	   
 			String nextYear=""+(i-1)+"-"+i; 
 			%>
	<option value="<%=nextYear %>"><%=nextYear %></option>

	<% } 
 		  }
 		 
        }
		 %>
</select> <input type="button" name="Search" value="Print" tabindex="1"
	class="buttonGraph" accesskey="a"
	onclick="if(checkYear()){PrintGraph();}" />
<div class="clear"></div>
<%-- <label class="medium">From  </label> 
	<input tabindex="1" type="text"	name="IntervalFrom" class="calDate" maxlength="10"  id="IntervalFrom" value=<%=currentDate %>
		onKeyUp="mask(this.value,this,'2,5','/');" 	validate="Reported Date,date,no" /> 
<img src="/hms/jsp/images/cal.gif"
		width="16" height="16" border="0" validate="Pick a date"
		class="calender"
		onclick="setdate('',patientSearch.IntervalFrom,event);" />
		<div class="clear"></div>
	 <label class="medium">To  </label> 
	 <input tabindex="1" type="text" id="IntervalTo"	name="IntervalTo" class="calDate" maxlength="10"  value=<%=currentDate %>
		onKeyUp="mask(this.value,this,'2,5','/');" 	validate="Reported Date,date,no" /> 
<img src="/hms/jsp/images/cal.gif"
		width="16" height="16" border="0" validate="Pick a date"
		class="calender"
		onclick="setdate('',patientSearch.IntervalTo,event);" />
	<div class="clear"></div>
	<label class="medium">Interval </label> 
	<select name="Interval" size="0" tabindex="1" id="IntervalId" onchange="SetInterval()">
	<option value="0">select</option>
	<option value="12">Annualy</option>
	<option value="4">Quarterly</option>
	<option value="1">Monthly</option>
	</select>
 --%></div>
</form>

<div class="clear"></div>
<div class="division"></div>
<input type="button" name="Search"
	onclick="if(checkBlankSearch()){submitForm('patientSearch','medicalExam?method=serchPendingMDWatingList');}"
	value="Search" tabindex="1" class="button" accesskey="a" />
<input type="button" name="Refresh" value="Refresh" tabindex="1"
	class="button" accesskey="a" />
<%-- <input type="button" name="Print" value="Print" tabindex="1"
	class="button" accesskey="a" />--%>
<div class="clear"></div>
<script>	
function getIcd(){
	var icdCode =document.getElementById("icdCode").value

	 if(icdCode !="")
	  {
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
	         icdString  = item.getElementsByTagName('icdString')[0];
	         document.getElementById('icd').value =icdString.childNodes[0].nodeValue
	         document.getElementById('icdCode').value="";
	         fillDiagnosisCombo(document.getElementById('icd').value);
      }
      }
      }
    var url="/hms/hms/adt?method=getIcdWithIcdCode&icdCode="+encodeURIComponent(icdCode)
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  	}
  }
function fillDiagnosisCombo(val) {

    //alert("Fill DiagnosisCombo");
	  var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var id = val.substring(index1,index2);
	   
	    if(id ==""){
		  return;
		}else{
		   		obj =document.getElementById('diagnosisId');
				obj.length = document.getElementById('diagnosisId').length;
              var valu=obj.options[obj.length-1].value;
				var b="false";
				for(var i=1;i<obj.length;i++){
						    
	                    	var val1=obj.options[i].value;
	                    	var length=obj.length-1;
                          	
	                    	if(id==val1)
	                    	{
	                        	alert("ICD  Already taken");
	                        	document.getElementById('icd').value =""
	                        	b=true;
	                       	}
	                              	
	                    }
              
	                    if(b=="false")
	                    {
	                    	obj.length++;
	    					obj.options[obj.length-1].value=id
	    					obj.options[obj.length-1].text=val
	    					obj.options[obj.length-1].selected=true
	    					document.getElementById('icd').value =""
	    			                    
	                    }
			}
}
</script>
<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("icd").value;
	errorMsg=errorMsg+document.getElementById("AgeFrom").value;
	errorMsg=errorMsg+document.getElementById("AgeTo").value;
	if(document.getElementById("disabilityid").value !=0)
	errorMsg=errorMsg+document.getElementById("disabilityid").value;
	if(document.getElementById("unitId").value !=0)
		errorMsg=errorMsg+document.getElementById("unitId").value;
	if(document.getElementById("commandId").value !=0)
		errorMsg=errorMsg+document.getElementById("commandId").value;
	if(document.getElementById("tradeId").value !=0)
		errorMsg=errorMsg+document.getElementById("tradeId").value;
	if(document.getElementById("searchField2").value !=0)
		errorMsg=errorMsg+document.getElementById("searchField2").value;
	if(!document.getElementById("serviceNo").value == "")
		errorMsg=errorMsg+document.getElementById("serviceNo").value;
	if(!document.getElementById("rejectId").value == "")
		errorMsg=errorMsg+document.getElementById("rejectId").value;
	if(!document.getElementById("fromDateId").value == "")
		errorMsg=errorMsg+document.getElementById("fromDateId").value;
	if(!document.getElementById("ToDateId").value == "")
		errorMsg=errorMsg+document.getElementById("ToDateId").value;
	if(errorMsg==""){
		alert("Please fill any one of value...!");
		return false
	}else{
		return true
	}
}
</script>
