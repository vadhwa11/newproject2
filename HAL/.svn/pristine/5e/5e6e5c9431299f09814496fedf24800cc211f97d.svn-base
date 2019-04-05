
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/opd?method=showDailyDoctorWiseReportJsp";
  obj.submit();
  }
</script>
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
	</script>

<script type="text/javascript">
function check(){
var SDate = document.dailyDoctorWise.<%= FROM_DATE%>.value;
var EDate = document.dailyDoctorWise.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>
<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasDepartment> searchMasDepartmentList = new ArrayList<MasDepartment>();
	List<MasEmployee> searchMasEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("searchMasDepartmentList")!=null)
		searchMasDepartmentList = (List) map.get("searchMasDepartmentList");
	if(map.get("searchMasEmployeeList")!=null)
		searchMasEmployeeList = (List) map.get("searchMasEmployeeList");

	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
%>
<form name="dailyDoctorWise" method="post" action=""><br />
<div class="titleBg"><h2>Daily Doctor Wise</h2>
</div>
<div class="Block">
<label> From Date <span>*</span> </label> 
<input type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>" class="auto" size="15"
	MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />
<a
	href="javascript:setdate('<%=currentDate%>',document.dailyDoctorWise.<%=FROM_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> 
<label >To Date<span>*</span> </label> 
<input type="text" name="<%=TO_DATE%>" value="<%=currentDate %>" class="auto" size="15" MAXLENGTH="30"
	validate="Pick a to date,date,yes" readonly="readonly" /> <a
	href="javascript:setdate('<%=currentDate%>',document.dailyDoctorWise.<%=TO_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> 
<label > Department <span>*</span> </label> 
<select
	id="deptId" name="<%=DEPARTMENT_ID%>"
	onchange="populateDoctorName(this.value,'dailyDoctorWise')"
	validate="Department,string,yes">
	<option value="0">Select</option>
	<%
				for (MasDepartment masDepartment :searchMasDepartmentList ) {

				%>
	<option value=<%=masDepartment.getId()%>><%=masDepartment.getDepartmentName()%>
	</option>
	<%
					}


				%>
</select> <script type="text/javascript">

		document.getElementById('deptId').value = '<%=deptId%>';

</script> 

<div class="clear"></div>
<label > Doctor Name <span>*</span></label> 
<select name="<%=EMPLOYEE_ID %>" class="small" validate="Doctor Name,string,yes">
	<option value="0">Select</option>
	<%
	 System.out.println("before");
	String mname="";
	String lname="";
			for(MasEmployee emp : searchMasEmployeeList){
				if(emp.getDepartment()!=null){
				if(emp.getDepartment().getId() == deptId){
					mname=emp.getMiddleName();
					lname=emp.getLastName();

					if(emp.getMiddleName()==null)
				    {
					   mname="";
				    }
					if(emp.getLastName()==null)
					{
						lname="";
					}

			   		%>
	<option value="<%=emp.getId() %>"><%=emp.getRank().getRankName().concat(" ").concat(emp.getFirstName()).concat(" ").concat(mname).concat(" ").concat(lname) %></option>

	<%}
				}}%>
</select> 
<script type="text/javascript">
			<%
				int i = 0;
			String mname1="";
			String lname1="";
			for(MasDepartment masDepartment : searchMasDepartmentList){
						for (MasEmployee masEmployee : searchMasEmployeeList)
						{
							if(masEmployee.getDepartment() != null){
								if(masDepartment.getId().equals(masEmployee.getDepartment().getId())){
									if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
										mname1=masEmployee.getMiddleName();
										lname1=masEmployee.getLastName();
										if(masEmployee.getMiddleName()==null)
									    {
										   mname1="";
									    }
										if(masEmployee.getLastName()==null)
										{
											lname1="";
										}
								%>
									doctorArr[<%=i%>] = new Array();
									doctorArr[<%=i%>][0] = <%=masDepartment.getId()%>;
									doctorArr[<%=i%>][1] = <%=masEmployee.getId()%>;
									doctorArr[<%=i%>][2] = "<%=masEmployee.getRank().getRankName().concat(" ").concat(masEmployee.getFirstName()).concat(" ").concat(mname1).concat(" ").concat(lname1)%>";

								<%
								i++;
									}
								}
							}
						}
					}
				%>


</script>

<input class="transparent" size="2" />

<label class="auto">Summary</label> 
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO%>" value=1 checked="checked">
<label class="auto">Detail</label>
<input type="radio" class="radio" name="<%=SELECTED_RADIO %>" value=2>

</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<center>
<input type="button" name="add" id="addbutton" value="Ok" class="button" onClick="submitForm('dailyDoctorWise','opd?method=generateDailyDoctorWiseReport','check()','checkTargetForYes');" accesskey="a" tabindex=1 /> 
<input type="button" name="clear" id="clearbutton" value="Cancel" class="button" onClick="submitForm('dailyDoctorWise','opd?method=showDailyDoctorWiseReportJsp','check()','checkTargetForNo');" accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</form>






