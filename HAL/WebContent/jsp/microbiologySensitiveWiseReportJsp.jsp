<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgMasOrganism"%>
<%@page import="jkt.hms.masters.business.DgMasOrganismGroup"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetailSen"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasAntibioticLab"%>
<%@page import="jkt.hms.masters.business.DgOrgDtl"%>
<%@page import="jkt.hms.masters.business.DgOrgGrpDtl"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<%@page import="java.net.URL"%>
<div id="contentHolder"><script type="text/javascript"
	language="javascript">
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
	 	Box box = HMSUtil.getBox(request);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		List<DgMasOrganism> dgMasOrganismList = new ArrayList<DgMasOrganism>();
		List<DgMasOrganismGroup> dgMasOrganismGroupList = new ArrayList<DgMasOrganismGroup>();
		List<MasAntibioticLab> masAntibioticLabList = new ArrayList<MasAntibioticLab>();
		List<DgResultEntryDetailSen> dgResultEntryDetailSenList = new ArrayList<DgResultEntryDetailSen>();
		List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		List<DgOrgGrpDtl> dgOrgGrpDtlList = new ArrayList<DgOrgGrpDtl>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		int deptId= 0;
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}
		if(map.get("dgMasOrganismGroupList") != null){
			dgMasOrganismGroupList = (List<DgMasOrganismGroup>)map.get("dgMasOrganismGroupList");
		}
		if(map.get("dgMasOrganismList") != null){
			dgMasOrganismList = (List<DgMasOrganism>)map.get("dgMasOrganismList");
		}
		if(map.get("masAntibioticLabList") != null){
			masAntibioticLabList = (List<MasAntibioticLab>)map.get("masAntibioticLabList");
		}
		if(map.get("dgResultEntryDetailSenList") != null){
			dgResultEntryDetailSenList = (List<DgResultEntryDetailSen>)map.get("dgResultEntryDetailSenList");
		}
		if(map.get("departmentList") != null){
			departmentList = (List<MasDepartment>)map.get("departmentList");
		}
		if(map.get("employeeList") != null){
			employeeList = (List<MasEmployee>)map.get("employeeList");
		}
		if(map.get("dgOrgDtlList") != null){
			dgOrgDtlList = (List<DgOrgDtl>)map.get("dgOrgDtlList");
		}
		if(map.get("dgOrgGrpDtlList") != null){
			dgOrgGrpDtlList = (List<DgOrgGrpDtl>)map.get("dgOrgGrpDtlList");
		}
		if (map.get("deptId") != null) {
			deptId= (Integer) map.get("deptId");
			}
	%>

<h6>Microbiology Sensitive Wise Report</h6>
<form name="microSensitiveWise" target="_blank" action="" method="post">
<div class="blockFrame"><label><span>*</span>From Date</label> <input
	type="text" class="calDate" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.microSensitiveWise.<%=FROM_DATE%>,event)" />

<label><span>*</span>To Date</label> <input type="text" class="calDate"
	id="fromDateId" name="<%=TO_DATE %>" value="<%=currentDate %>"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.microSensitiveWise.<%=TO_DATE%>,event)" />
<div class="Clear"></div>

<label>Doctor</label> <select id="employee" name="<%=EMPLOYEE_ID%>">
	<option value="">Select</option>
	<% 
		for (MasEmployee  obj : employeeList){
		//	if(obj.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForParaMedical)){
			//System.out.println(employeeList.size()+"djsjkvnjsnvfsdjf");
				String doctorMiddleName = "";
				String doctorLastName = "";
				String rankName ="";
					doctorMiddleName = obj.getMiddleName();
					doctorLastName = obj.getLastName();
					if(obj.getRank() != null){
						rankName = obj.getRank().getRankName();
					}
				
	%>
	<option value="<%=obj.getId()%>"><%=obj.getFirstName()+" "+doctorMiddleName+" "+doctorLastName%>
	<%=rankName%></option>
	<% // }
	}%>
</select> <label>Ward Wise</label> <select id="wardId" name="">
	<option value="0">Select</option>
	<% 
		for (MasDepartment  obj : departmentList){
		if(obj.getId().intValue()==deptId)
		{		
	%>
	<option value="<%=obj.getId()%>" selected="selected"><%=obj.getDepartmentName()%></option>


	<%}else{%>
	<option value="<%=obj.getId()%>"><%=obj.getDepartmentName()%></option>

	<% }}%>
</select>
<div class="Clear"></div>

<label>Organism Group Wise</label> <select id="employee"
	name="organism_group" onchange="">
	<option value="">Select</option>

	<% 
		for (DgMasOrganismGroup  obj : dgMasOrganismGroupList){
		//if(obj.getId().intValue()==deptId)
	//	{		
	%>
	<option value="<%=obj.getId()%>"><%=obj.getOrganismGroupName()%></option>


	<%//}else{%>


	<% }//}%>
</select> <label>Organism Wise</label> <select id="organismId" name="organismId">
	<option value="0">Select</option>
	<%for (DgMasOrganism  obj : dgMasOrganismList){%>

	<option value="<%=obj.getId()%>"><%=obj.getOrganismName()%></option>
	<% }%>
</select> <label>Antibiotic Wise</label> <select id="employee" name="">
	<option value="">Select</option>
	<% 
		for (MasAntibioticLab  obj : masAntibioticLabList){
		//if(obj.getId().intValue()==deptId)
	//	{		
	%>
	<option value="<%=obj.getId()%>"><%=obj.getAntibioticLabName()%></option>


	<%//}else{%>


	<% }//}%>

</select>
<div class="Clear"></div>

</div>
<div class="bottom"><input type="button" name="OK" value="OK"
	class="button"
	onClick="submitForm('microSensitiveWise','lab?method=generateMicrobiologySensitiveWise','validateFromToDate');" />
<input type="reset" name="Reset" id="reset" value="Reset" class="button"
	onclick="resetCheck();" accesskey="r" /></div>
</form>
</div>

<script type="text/javascript" language="javascript">
	
	function validateFromToDate(){
		
		var nowDate=new Date();
		
		obj1 = eval(document.microSensitiveWise.fromDate)
		obj2 = eval(document.microSensitiveWise.toDate)
			
		if(obj1.value != "" && obj2.value != "")
		{
		
		 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
		 validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));
				
			if(validFromDate<=nowDate)
				{
					if(validFromDate > validToDate)
					{
							alert("From Date should be smaller than To Date\n");
							return false;
					}
				}
				
			else
				{
				alert("From Date should not be greater than Current date\n");
				return false;
				}
		
		}
		return true;
	}
</script>