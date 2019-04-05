

<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasImpanneledHospital"%>
<%@page import="jkt.hms.masters.business.MasDivision"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/controls.js?n=1"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>


<%
    String pageTitle = "";
String toDate = "&nbsp;";
String fromDate = "&nbsp;";	
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<Object[]> seedCategoryList = new ArrayList<Object[]>();
	List<Object[]> financialYearList = new ArrayList<Object[]>();
	
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	

	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName"); 
	 
	}
	
	if (map.get("toDate") != null) {
		toDate = (String)map.get("toDate");
	}
	if (map.get("fromDate") != null) {
		fromDate = (String)map.get("fromDate");
	}
	
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId =  (Integer)session.getAttribute("hospitalId");
	}
	
	    List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		
		if(map.get("doctorList") != null){
			doctorList = (List<MasEmployee>)map.get("doctorList");
		}
		
		 List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			
			if(map.get("departmentList") != null){
				departmentList = (List<MasDepartment>)map.get("departmentList");
			}
	
	     List<MasImpanneledHospital> impHospitalList = new ArrayList<MasImpanneledHospital>();
		
		if(map.get("impHospitalList") != null){
			impHospitalList = (List<MasImpanneledHospital>)map.get("impHospitalList");
		}
		
		 List<MasDivision> divisionList = new ArrayList<MasDivision>();
			
			if(map.get("divisionList") != null){
				divisionList = (List<MasDivision>)map.get("divisionList");
			}
	
	//out.print("hospitalId="+hospitalId);
	
	
	
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId =  (Integer)session.getAttribute("deptId");
	}

%>
<form name="searchMedicalExam" method="post" action="">
<div class="titleBg">
<h2>Billing Excel Report</h2>
</div>
<!-- <div class="page_title">Medical Exam waiting List</div> -->

<div class="Block">
<label class="">From Date<span>*</span></label> 
<input type="text" id="fromDate" name="fromDate"  MAXLENGTH="10" class="calDate" placeholder="DD/MM/YYYY" validate="From Date,date,yes" onkeyup="mask(this.value,this,'2,5','/');" />


<label class="">To Date <span>*</span></label> 
<input type="text" id="toDate"  name="toDate"   MAXLENGTH="10" class="calDate" placeholder="DD/MM/YYYY" validate="To Date,date,yes" onkeyup="mask(this.value,this,'2,5','/');" />
<div class="clear"></div>
<label>Doctor</label>

<select name ="doctorId" id="doctorId"  >
<option value="0">Select</option>
	<%
		if(doctorList.size()>0)
		{
			for(MasEmployee emp: doctorList)
			{
				%>
					<option value="<%=emp.getId()%>"><%=emp.getFirstName()%></option>
				<%
			}
		}
	%>
	</select>
	
	<label>Department</label>

<select name ="departmentId" id="departmentId" >
<option value="0">Select</option>
	<%
		if(departmentList.size()>0)
		{
			for(MasDepartment dept: departmentList)
			{
				%>
					<option value="<%=dept.getId()%>"><%=dept.getDepartmentName()%></option>
				<%
			}
		}
	%>
</select>
<div class="clear"></div>

<label>Division</label>

<select name ="divisionId" id="divisionId"  >
<option value="0">Select</option>
	<%
		if(divisionList.size()>0)
		{
			for(MasDivision md: divisionList)
			{
				%>
					<option value="<%=md.getId()%>"><%=md.getDivisionName()%></option>
				<%
			}
		}
	%>
	</select>
	
	<label>Hospital</label>

<select name ="impHospitalId" id="impHospitalId" class="large" >
<option value="0">Select</option>
	<%
		if(impHospitalList.size()>0)
		{
			for(MasImpanneledHospital meh: impHospitalList)
			{
				%>
					<option value="<%=meh.getId()%>"><%=meh.getImpanneledHospitalName()%></option>
				<%
			}
		}
	%>
</select>
<div class="clear"></div>



<input type="button" name="add" id="addbutton" value="Print" class="button" onClick="submitForm('searchMedicalExam','referral?method=generateReferralExcelBillingReport');" accesskey="a" tabindex=1 />


 

</form>


<script language="javascript">

</script>

