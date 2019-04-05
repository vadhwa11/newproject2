
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.net.URL"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
  function clearButton(formName)
  {
	 alert("cancel button"); 
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/opd?method=showDailyDepartmentWiseReportJsp";
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
var SDate = document.dailyDepartmentWise.<%= FROM_DATE%>.value;
var EDate = document.dailyDepartmentWise.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}

		function fillServiceType(){
			var obj = document.getElementById("employeeId");
			var val = obj.value;
			for(i=0;i<obj.length;i++)
			{
				if(obj.options[i].value == val)
				{
					serviceName = obj.options[i].text
					break;
				}
			}
			if(serviceName !="All"){
				document.getElementById("doctorName").value =serviceName
			}else{
				document.getElementById("doctorName").value ="0"
			}
			}
		var doctorArr;
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
<form name="dailyDepartmentWise" method="post" action=""><br />
<div class="titleBg"><h2>Daily Department Wise</h2>
</div>
<div class="Block">
<label> From Date <span>*</span> </label> 
<input type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>" class="date"
	MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />
<a
	href="javascript:setdate('<%=currentDate%>',document.dailyDepartmentWise.<%=FROM_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> 

<label> To Date <span>*</span> </label> 
<input type="text" name="<%=TO_DATE%>" value="<%=currentDate %>" class="date" MAXLENGTH="30"
	validate="Pick a to date,date,yes" readonly="readonly" /> 
<a
href="javascript:setdate('<%=currentDate%>',document.dailyDepartmentWise.<%=TO_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> 

<div class="clear"></div>
<label> Department <span>*</span></label> 
<select id="deptId" name="<%=DEPARTMENT_ID%>" onchange="populateDoctorName(this.value,'dailyDepartmentWise')"
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
</select>


 <script type="text/javascript">

		document.getElementById('deptId').value = '<%=deptId%>';

		</script>
<label>   Doctor Name</label>
<select name="<%=EMPLOYEE_ID %>"  onchange="fillServiceType();" id="employeeId">
	<option value="0">All</option>
	<%
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
	<option value="<%=emp.getId()%>"><%=emp.getFirstName().concat(" ").concat(mname).concat(" ").concat(lname) %></option>

	<%}
				}}%>
</select>
<input type="hidden" name="<%=DOCTOR_NAME %>" id="doctorName" value="0"/>
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
										mname=masEmployee.getMiddleName();
										lname=masEmployee.getLastName();
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
                                    
									doctorArr[<%=i%>][2] = "<%=masEmployee.getFirstName().concat(" ").concat(mname1).concat(" ").concat(lname1)%>";
                                            
								<%
								i++;
									}
								}
							}
						}
					}
				%>


			</script>
<div class="clear"></div>			 
<label>Summary</label>
<input type="radio" class="radio" name="<%=SELECTED_RADIO%>" value=1 checked="checked">
<label>Detail</label>
<input type="radio"  class="radio" name="<%=SELECTED_RADIO %>" value=2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<center> 
<input type="button" name="add" id="addbutton" value="Ok" class="button" onClick="submitForm('dailyDepartmentWise','opd?method=generateDailyDepartmentWiseReport','check()','checkTargetForYes');" accesskey="a" tabindex=1 />
<input type="button" name="clear" id="clearbutton" value="Cancel" class="button" onClick="submitForm('dailyDepartmentWise','opd?method=showDailyDepartmentWiseReportJsp','check()','checkTargetForNo');" accesskey="a" tabindex=1 />
</center>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>






