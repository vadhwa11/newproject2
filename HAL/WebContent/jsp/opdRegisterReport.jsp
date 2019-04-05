<%@page import="jkt.hms.masters.business.MasDivision"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasSection"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.MasDisposal"%>

<%@page import="jkt.hms.masters.business.MasRelation"%><script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script type="text/javascript"	language="javascript">

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
	</script> <%
			Map<String, Object> utilMap = new HashMap<String, Object>();
		 	
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		 	String currenDate = (String) utilMap.get("currentDate");
		 	Map<String, Object> map = new HashMap<String, Object>();
			if(request.getAttribute("map") != null){
				map = (Map<String, Object>)request.getAttribute("map");
			}
			List<MasRank> rankList = new ArrayList<MasRank>();
			List<MasServiceType> serviceTypeList =null;
			List<MasServiceStatus> serviceStatusList =null;
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<MasDivision> divisionList = null;
			List<Object[]> unitList = null;
			List<MasSection> sectionList = null;
			List<MasAdministrativeSex> sexList = null;
			List<MasMaritalStatus> maritalStatusList = null;
			List<MasEmployee> doctorList = null;
			List<MasDisposal> disposalList = null;
			//List<MasRelation> relationList= null;
			List<Object[]> relationList = new ArrayList<Object[]>();
			if(map.get("relationList") != null){
				relationList=(List<Object[]>)map.get("relationList");
				}
			if(map.get("rankList")!=null){
				rankList = (List<MasRank>)map.get("rankList");
			}
			if(map.get("serviceTypeList") != null){
				serviceTypeList= (List<MasServiceType>)map.get("serviceTypeList");
			}
			if(map.get("serviceStatusList") != null){
				serviceStatusList= (List<MasServiceStatus>)map.get("serviceStatusList");
			}
			if(map.get("departmentList")!=null){
				departmentList = (List<MasDepartment>)map.get("departmentList");
			}
			if(map.get("divisionList") != null){
				divisionList = (List<MasDivision>)map.get("divisionList");
			}
			if(map.get("unitList") != null){
				unitList= (List<Object[]>)map.get("unitList");
			}
			if(map.get("sectionList") != null){
				sectionList = (List<MasSection>)map.get("sectionList");
			}
			if(map.get("sexList") != null){
				sexList = (List<MasAdministrativeSex>)map.get("sexList");
			}
			if(map.get("maritalStatusList") != null){
				maritalStatusList = (List<MasMaritalStatus>)map.get("maritalStatusList");
			}
			if(map.get("employeeList") != null){
				doctorList = (List<MasEmployee>)map.get("employeeList");
			}
			if(map.get("disposalList") != null){
				disposalList = (List<MasDisposal>)map.get("disposalList");
			}
			/* if(map.get("relationList") != null){
				relationList = (List<MasRelation>)map.get("relationList");
			} */
			if(session.getAttribute("box")!=null)
				session.removeAttribute("box");
			int hospitalId = 0;
			if(map.get("hospitalId")!=null){
				hospitalId = (Integer)map.get("hospitalId");
			}
	%>

<div class="titleBg">
<h2>OPD Statistics</h2>
</div>
<div class="Clear"></div>
<form name="opdRegister" method="post" action="">
<div class="Block">
<label>Date</label>
<input type="hidden" name="hospitalId" value="<%=hospitalId %>" validate="hospital id,metachar,no">
<label class="medium"> From <span>*</span> </label> 
<input
	type="text" id="fromDateId" name="<%=FROM_DATE %>" 
	value="<%=currenDate %>" class="date" validate="From Date,frdate,yes"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currenDate %>',document.opdRegister.<%=FROM_DATE%>,event)" />

<label> To <span>*</span> </label> <input type="text" id="ToDateId" validate="To Date,frdate,yes"
	name="<%=TO_DATE %>" value="<%=currenDate %>" class="date"
	readonly="readonly" MAXLENGTH="30" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate %>',document.opdRegister.<%=TO_DATE%>,event)" />
<div class="Clear"></div>
<%-- <label>Designation</label>
<label class="medium">From </label> 
	<select	id="fromrankId" name="fromRankId" tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasRank masRank : rankList) 
				{
			 		%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			 		}%>
</select> 
	
	<label>To </label> 
	<select	id="torankId" name="toRankId"tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasRank masRank : rankList) 
				{
			 		%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%
			 		}%>
</select> 	 --%>
<div class="Clear"></div>
<label>Age</label>
<label class="medium"> From </label>

<select id="fromageId"	name="fromAge" tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="fromageUnitId" name="fromAgeUnit"	 tabindex="1" class="small">
	<option value="">Select</option>
	<option value="Years" selected="selected">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 

<label> To </label>

<select id="toageId"	name="toAge"  tabindex="1"	class="smallest" >
	<option value="">Select</option>
	<%
				for(int age1 = 1;age1<=100;age1++){
				%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select> 

<select id="toageUnitId" name="toAgeUnit"	tabindex="1" class="small">
	<option value="">Select</option>
	<option value="Years" selected="selected">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select> 
<%-- <div class="Clear"></div>
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
<div class="Clear"></div>	 --%>
<%-- <label>Service Type </label> 
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
 --%>
<%-- <label>Service Status </label> 
<select id="serviceStatusId" name="<%=SERVICE_STATUS_ID %>"	tabindex="1">
	<option value="0">Select</option>

	<% 
			for(MasServiceStatus masServiceStatus : serviceStatusList){
		%>
	<option value="<%=masServiceStatus.getId() %>"><%=masServiceStatus.getServiceStatusName() %></option>
	<%
				}%>
</select> --%>


<div class="Clear"></div>
<label>Department</label> 
<input type="text" class="transparent" size="14">
	<select	id="departmentId" name="<%=DEPARTMENT_ID%>" tabindex="1" validate="Department,string,yes">
	<option value="0">Select</option>
	<%
			 	for (MasDepartment d : departmentList) 
				{
			 		%>
	<option value="<%=d.getId()%>"><%=d.getDepartmentName()%></option>
	<%
			 		}%>
</select> 
<label> Division </label> 
<select id=division name="divisionId"	validate="Division,string,no" tabindex="1">
	<option value="0">Select</option>
	<%for(MasDivision dv :divisionList){ %>
	<option value=<%=dv.getId()%>><%=dv.getDivisionName() %></option>
	<%} %>
	
</select>
<%-- <label> Trade/Branch</label> 
<select id="tradeId" name="<%=TRADE_ID%>"	validate="Trade,string,no" tabindex="1">
	<option value="0">Select</option>
	<%for(MasTrade trade :tradeList){ %>
	<option value=<%=trade.getId()%>><%=trade.getTradeName() %></option>
	<%} %>
	
</select>
<div class="Clear"></div>
<label>Unit </label> 
<input type="text" class="transparent" size="14">
<select id="unitId" name="<%=UNIT_ID %>" tabindex="1"	validate="Unit,string,no" >
	<option value="0">Select</option>
	<%
		 for(Object[] masUnit : unitList){
		 %>
	<option value="<%=masUnit[0]%>"><%=masUnit[1]%></option>
	<%
	 }%>
	
</select> --%>
<%-- <label>Section</label> 
<select id="sectionId" name="<%=SECTION_ID%>" tabindex="1">
	<option value="0">Select</option>
	<%
	 for(MasSection masSection : sectionList){
		
	 %>
	<option value="<%=masSection.getId()%>"><%=masSection.getSectionName()%></option>

	<%}
	%>

</select> --%>
<div class="Clear"></div>
<label> Employee No.</label>
<input type="text" class="transparent" size="14">
<input type="text" name="<%=SERVICE_NO %>" value=""MAXLENGTH="30" validate="Service No,metachar,no"/>

<label>  Relation</label>

<select	name="<%=RELATION_ID %>" validate="Relation,String,no"	id="relId">
	<option value="">Select</option>

	<% 
	  for(Object[] obj : relationList){
	%>
	<option value="<%=obj[0]%>"><%=obj[1]%></option>
	<% 				
	}%>
</select>
<div class="Clear"></div>
<label>Gender </label>
<input type="text" class="transparent" size="14">
<select name="<%=SEX_ID %>" id="srSexId" validate="" tabindex="1">
<option value="0">Select</option>
	<%
		   	 		for(MasAdministrativeSex masAdministrativeSex : sexList){
			%>
	
	<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
	<%
				
		   	 	} %>
</select> 
<%-- 
<label> Marital Status</label>
<select name="<%=MARITAL_STATUS_ID %>"	id="mrstatus"  tabindex="1">
	<option value="0">Select</option>
	<%
	 for(MasMaritalStatus masMaritalStatus : maritalStatusList){
	
	%>
	<option value="<%=masMaritalStatus.getId()%>"><%=masMaritalStatus.getMaritalStatusName()%></option>
	<%}%>
</select> 
<div class="Clear"></div>
 --%>

<label>Doctor</label> 

<select	id="consultingDocId" name="<%=CONSULTING_DOCTOR %>"	tabindex="1"  validate="Doctor Name ,string,yes">
	<option value="0">Select</option>
	<%

for(MasEmployee masEmployee : doctorList){
	
%>
	<option value="<%=masEmployee.getId() %>"><%= masEmployee.getFirstName()+" "+masEmployee.getLastName() %>(<%= masEmployee.getRank().getRankName() %>)</option>
	<%				
} %>
</select> 

<%-- 
<label>Disposal</label>
<select name="disposal" validate="Disposal,metachar,no">
<option value="">Select</option>
<%
	if(disposalList.size() > 0){
		for(MasDisposal disposal : disposalList){
%>
<option value="<%=disposal.getDisposalName() %>"><%=disposal.getDisposalName() %></option>
<%} 
}%>
</select> --%>
<div class="Clear"></div>


<label>ICD No.</label>
<input type="text" class="transparent" size="14">
<input type="text" name="icdNo" value="" id="icdNo" validate="ICD No,icd,no" onblur="getICDID('opdRegister',this.value);"/>
<input type="hidden" name="icdId" value="" id="icdId" validate="ICD Id,num,no" />

<div class="Clear"></div>

<label>ICD Diagnosis</label>
<input type="text" class="transparent" size="14"> 
<input type="text" tabindex="1"	value="" id="icd"  name="icd"	class="auto"  size="77"  validate="ICD Diagnosis,icd,no"/>
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDForIdList',{parameters:'requiredField=icd'});
</script>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<!-- <input type="button" name="OK" value="OK" class="button" onClick="submitForm('opdRegister','registration?method=showOPDRegisterOnScreen');" /> -->
<input type="reset" name="Reset" value="Reset" class="button" onclick="location.reload();" accesskey="r" />
<input type="button" name="print" value="Print" class="button" onClick="submitForm('opdRegister','registration?method=showOPDRegisterReport')" />
<input type="button" name="graph" value="Show Graph" class="button" onClick="openGraph();" />

</form>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>

<script>
function openGraph(){

	/*var inputs = eval('document.opdRegister.elements');
	
	errors = "";
	
	for(i=0;i<inputs.length;i++){
		if(inputs[i].name!='fromDate' && inputs[i].name!='toDate' && !validateMetaCharacters(inputs[i].value)){
			return false;
		}else if(inputs[i].name=='fromDate' && inputs[i].name=='toDate' && !isGoodDate(inputs[i].value)){
			return false;
		}
	}*/
	var url = "registration?method=showOPDStatisticsGraph&"+getNameAndData('opdRegister');
	
	window.open(url,'windowRef','width=600,height=400,scrollbars = yes');
}


</script>



