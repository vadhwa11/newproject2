<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * investigationAppointments.jsp  
 * Purpose of the JSP -  This is for Appointment Setup Screen.
 * @author  Priyanka
 * Create Date: 10th july,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2  
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="static jkt.hms.util.RequestConstants.EMPLOYEE_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.PRESCRIPTION_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.PRESCRIPTION_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.PRESCRIPTION_NO"%>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
 
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js?n=1"></script>
<!--By Vishnu  -->
<title>Waiting List For Surgery</title>

<% 
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String currentTime = (String) utilMap.get("currentTime");
Map map = new HashMap();
int waitingCount = 0;
//String includedJsp = null;
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<OpdSurgeryHeader> pacList = new ArrayList<OpdSurgeryHeader>();
List sexList = new ArrayList();

if (map.get("pacList") != null) {
	pacList = (List) map.get("pacList");
}

if (map.get("sexList") != null) {
	sexList = (List) map.get("sexList");
}
 String userName = "";
if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
} 
			 	%>

<script	type="text/javascript" language="javascript">
	<%

	
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String getDate=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(getDate.length()<2){
		getDate="0"+getDate;
	}

%>
serverdate = '<%=getDate+"/"+month+"/"+year%>'

	


		
	</script>


<div class="clear"></div>
<div class="titleBg">
<h2>Pending List For Surgery Scheduling</h2>
</div>
<div class="clear"></div>


<div class="clear"></div>
<div class="Clear"></div>

<%-- <h4><span><%=message%></span></h4> --%>
<form name="search" action="" method="post">
<div class="Block">
<div class="clear"></div> 
<title>PAC Clearance List</title>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<!-- <label>HIN</label> <input type="text" id="uhid" name="uhid"  maxlength="15"> --></input>
 <label>Patient Name</label> <input type="text" id="pname" name="pname" maxlength="20"></input>
<!-- <label>IP No.</label> <input type="text" id="ipno" name="ipno" maxlength="20"></input> -->
<label>Employee No</label> <input type="text"  name="<%=EMPLOYEE_ID%>" maxlength="20"></input>
<label>Gender</label> 
<select id="gender" name="gender">
<option value="0">Select </option>
<%Iterator iterator=sexList.iterator();
while(iterator.hasNext())
{   
	  MasAdministrativeSex administrativeSex= (MasAdministrativeSex)iterator.next(); %>
	  <option value="<%=administrativeSex.getId()%>"><%=administrativeSex.getAdministrativeSexName() %></option>
	  
	  <%} %>
</select>
 <div class="clear"></div>
	<input type="button" name="Search" value="Search" class="button"
		onClick="submitForm('search','/hms/hms/ot?method=showPACClearanceList');" />
		
		<input type="button" name="Reset" value="Reset" class="button"
		onClick="submitForm('search','/hms/hms/ot?method=showPACClearanceList');" />
 </div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
 </form>

<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults">
<div id="searchtable"></div>
<form name="pacList" method="post" action="">
<script type="text/javascript">
	formFields = [
		[0, "surgeryId", "id"],[1,"<%=PRESCRIPTION_NO%>"],[2,"<%=PRESCRIPTION_DATE%>"],[3,"<%=PRESCRIPTION_TIME%>"],[4,"hin"],[5,"serviceType"],[6,"serNo"],[7,"sPerName"],[8,"relation"],[9,"patName"], [10,"age"], [11,"sex"],[12,"pType"],[13,"doct"]];
		statusTd = 13;
	</script></form>


<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" />
</div>

<script type="text/javascript" language="javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "S. No"
data_header[0][1] = "hide";
data_header[0][2] = "5%";
data_header[0][3] = "s_no";



data_header[1] = new Array;
data_header[1][0] = "Employee No"
data_header[1][1] = "data";
data_header[1][2] = "8%";
data_header[1][3] = "serNo";

data_header[2] = new Array;
data_header[2][0] = "Requested Date/Time"
data_header[2][1] = "data";
data_header[2][2] = "8%";
data_header[2][3] = "reqDate";  

 data_header[3] = new Array;
data_header[3][0] = "Patient Name"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "patName";

data_header[4] = new Array;
data_header[4][0] = "Relation"
data_header[4][1] = "data";
data_header[4][2] = "7%";
data_header[4][3] = "relation";



data_header[5] = new Array;
data_header[5][0] = "Age"
data_header[5][1] = "data";
data_header[5][2] = "10%";
data_header[5][3] = "age";

data_header[6] = new Array;
data_header[6][0] = "Gender"
data_header[6][1] = "data";
data_header[6][2] = "5%";
data_header[6][3] = "sex";

data_header[7] = new Array;
data_header[7][0] = "Department"
data_header[7][1] = "data";
data_header[7][2] = "7%";
data_header[7][3] = "pType";

data_header[8] = new Array;
data_header[8][0] = "Doctor"
data_header[8][1] = "data";
data_header[8][2] = "7%";
data_header[8][3] = "admissiondate";

data_header[9] = new Array;
data_header[9][0] = "Procedure Name"
data_header[9][1] = "data";
data_header[9][2] = "7%";
data_header[9][3] = "pType";

/* data_header[9] = new Array;
data_header[9][0] = "Requested Date/Time"
data_header[9][1] = "data";
data_header[9][2] = "8%";
data_header[9][3] = "reqDate";   */

 data_header[10] = new Array;
data_header[10][0] = "Patient Type"
data_header[10][1] = "data";
data_header[10][2] = "8%";
data_header[10][3] = "pt";  

data_arr = new Array();
	<%
		int  i=0;
		try{
			 
			 iterator=pacList.iterator();
				String sPatientAge="-";
				int patientAge = 0;
				String age =null;
		          while(iterator.hasNext())
		           {   
		        	  OpdSurgeryHeader opdSurgeryHeader= (OpdSurgeryHeader)iterator.next();
		        	  String patientName="";
		        	  if(opdSurgeryHeader.getHin().getPFirstName()!= null)
		        	  {
		        		  patientName=opdSurgeryHeader.getHin().getPFirstName();
		        	  }
		        	  if(opdSurgeryHeader.getHin().getPMiddleName()!= null)
		        	  {
		        		  patientName +=" "+opdSurgeryHeader.getHin().getPMiddleName();
		        	  }
		        	  if(opdSurgeryHeader.getHin().getPLastName()!= null)
		        	  {
		        		  patientName +=" "+opdSurgeryHeader.getHin().getPLastName();
		        	  }
		        	  String requisitionDate =HMSUtil.changeDateToddMMyyyy(opdSurgeryHeader.getRequisitionDate());
		        	 
		%>
		
			data_arr[<%= i%>] = new Array();
			
			data_arr[<%= i%>][0] =<%=opdSurgeryHeader.getId()%>
			
			data_arr[<%= i%>][1] = '<input type="radio" class="radioCheck" name="opdSurgeryId" value="<%= opdSurgeryHeader.getId()%>" id="parent" />'
			
			<%
				if(opdSurgeryHeader.getPrescribedDepartment().getDepartmentName()!=null)
				{
			%>
			data_arr[<%= i%>][8] = "<%=opdSurgeryHeader.getPrescribedDepartment().getDepartmentName()%>"
			<%
				}else{
			%>
			data_arr[<%= i%>][8] = ""
			<%
				}
			   if(opdSurgeryHeader.getStatus()!= null)
			   {
			%>
			data_arr[<%= i%>][11]="<%=opdSurgeryHeader.getStatus()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][11]=""
			<%
				}
			   if(opdSurgeryHeader.getHin().getServiceNo() !=null )
			   {
			%>
			data_arr[<%= i%>][2] = "<%=opdSurgeryHeader.getHin().getServiceNo()%>"
			<%
			   }else{
			%> 
			data_arr[<%= i%>][2] = ""
			<%
			   }
			  
			   
			   	   
				   /*  if(opdSurgeryHeader.getInpatient()!= null  && opdSurgeryHeader.getInpatient().getVisit()!= null ) */
				    if(opdSurgeryHeader.getRequisitionDate()!= null)
				   {
				%>
				    data_arr[<%= i%>][3] = "<%=HMSUtil.convertDateToStringWithoutTime(opdSurgeryHeader.getRequisitionDate())%><%=opdSurgeryHeader.getRequisitionTime()!=null?"("+opdSurgeryHeader.getRequisitionTime()+")":""%>"
				<%
				   }else{
				%>
				data_arr[<%= i%>][3] = "-"
				<%
				   } 
			   
			   
			   if(patientName != null )
			   {
			%>
			data_arr[<%= i%>][4] = "<%=patientName%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][4] = ""
			<%
			   }
			   %>
			   
			   <%
				    if(opdSurgeryHeader.getHin()!= null )
				   {
					    if(opdSurgeryHeader.getHin().getDateOfBirth() != null)
					    {
					        Date date_of_birth= opdSurgeryHeader.getHin().getDateOfBirth();        
					        patientAge = HMSUtil.calculateAgeInYears(date_of_birth);
					        if(patientAge == 1 )
					            sPatientAge = patientAge +" Year";
					        else if(patientAge == 0 )
					        {
					        	sPatientAge= HMSUtil.getAgeFromDOB(opdSurgeryHeader.getHin().getDateOfBirth());
					        }
					        else
					            sPatientAge = patientAge +" Years";
					    }
				%>
			<%-- 	data_arr[<%= i%>][5] = "<%=opdSurgeryHeader.getInpatient().getAge()%>" --%>
			data_arr[<%= i%>][6] = "<%=sPatientAge%>"
				<%
				   }else{
				%>
				data_arr[<%= i%>][6] = ""
				<%
				   }
				   %>
				   
				   <%
				    if(opdSurgeryHeader.getHin().getSex().getAdministrativeSexName()!= null )
				   {
				%>
				data_arr[<%= i%>][7] = "<%=opdSurgeryHeader.getHin().getSex().getAdministrativeSexName()%>"
				<%
				   }else{
				%>
				data_arr[<%= i%>][7] = ""
				<%
				   }
				   %>
				   
				   <%
				    if(opdSurgeryHeader.getOpdSurgeryDetails() != null )
				   {
				    	Set<OpdSurgeryDetail> opdSuregryDetailsSet = new HashSet<OpdSurgeryDetail>();
						opdSuregryDetailsSet = opdSurgeryHeader.getOpdSurgeryDetails();
						
						String procedureName = "";
						 int count =0;
						for(OpdSurgeryDetail osd:opdSuregryDetailsSet){
						 if( osd.getAnestheisaPacStatus()!=null && !osd.getAnestheisaPacStatus().equalsIgnoreCase("y") && !osd.getAnestheisaPacStatus().equalsIgnoreCase("nc"))
							{ 
							if(count++>=1)
								procedureName = procedureName.concat(" | ");
							    procedureName =procedureName+ osd.getChargeCode().getChargeCodeName(); 
							}
						}
					%>
				data_arr[<%= i%>][10] = "<%=procedureName%>"
				<%
				   }else{
				%>
				data_arr[<%= i%>][10] = ""
				<%
				   }
				   %>
				   
			
				   
				   <%String patientType= null;
				   /*  if(opdSurgeryHeader.getInpatient()!= null  && opdSurgeryHeader.getInpatient().getVisit()!= null ) */
				    if(opdSurgeryHeader.getVisit()!= null || opdSurgeryHeader.getInpatient()!= null  )
				   {
				    	
				    	 if(opdSurgeryHeader.getInpatient()!= null)
					    		patientType ="IPD Patient";
				    	 else if(opdSurgeryHeader.getVisit()!= null)
				    		patientType ="OPD Patient";
				    		
				%>
				    data_arr[<%= i%>][11] = "<%=patientType%>"
				<%
				   }else{
				%>
				data_arr[<%= i%>][11] = "-"
				<%
				   } %>
				  
				   
				   <%
				   
				    if(opdSurgeryHeader.getEmployee()!= null )
				   {
				    	String FirName="";String midName=""; String lastName="";
						if(opdSurgeryHeader.getEmployee().getFirstName() !=null){
							FirName = opdSurgeryHeader.getEmployee().getFirstName();
							}
							if(opdSurgeryHeader.getEmployee().getMiddleName()!=null){
								midName = opdSurgeryHeader.getEmployee().getMiddleName();
							}
							if(opdSurgeryHeader.getEmployee().getLastName()!=null){
								lastName = opdSurgeryHeader.getEmployee().getLastName();
							}
							String name = FirName+" "+midName+" "+lastName;
				%>
				data_arr[<%= i%>][9] = "<%=name %>"
				<%
				   }else{
				%>
				data_arr[<%= i%>][9] = " "
				<%
				   }
				   %>
			    <%
				   if(opdSurgeryHeader.getHin()!= null && opdSurgeryHeader.getHin()!= null )
				   {
				%>
				data_arr[<%= i%>][5] = "<%=opdSurgeryHeader.getHin().getRelation().getNewRelationName()%>"
				<%
				   }else{
				%> 
				data_arr[<%= i%>][5] = ""
					<%
				   }
		 	i++;
		   }
		 }catch(Exception e){
		e.printStackTrace();	
	
		}
		%>
		 
		formName = "pacList"
			start = 0
			if(data_arr.length < rowsPerPage){
			end = data_arr.length;
			}
			else{
			end = rowsPerPage;

			}
			makeTable(start,end);
			</script>
