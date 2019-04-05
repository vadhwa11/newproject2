
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Collections"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="jkt.hms.masters.business.IpdHandTakeOver"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasBed"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Transfer"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>


 <script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

 <script	type="text/javascript" language="javascript">
<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date_to=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date_to.length()<2){
			date_to="0"+date_to;
		}
	%>
		serverdate = '<%=date_to+"/"+month+"/"+year%>'
</script>

<%

	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String currentTime = (String)utilMap.get("currentTime");
	
	%>
	 <%
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	if(map.get("employeeList")!=null){
		employeeList= (List<MasEmployee>)map.get("employeeList");
	}
	/* List<MasEmployee> employeeListDoctor = new ArrayList<MasEmployee>();
	if(map.get("employeeListDoctor")!=null){
		employeeListDoctor= (List<MasEmployee>)map.get("employeeListDoctor");
	}  */
	
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	if(map.get("departmentList")!=null){
		departmentList= (List<MasDepartment>)map.get("departmentList");
	}
	
	List<IpdHandTakeOver> ipdHandTakeOverList = new ArrayList<IpdHandTakeOver>();
	if(map.get("ipdHandTakeOverList")!=null){
		ipdHandTakeOverList= (List<IpdHandTakeOver>)map.get("ipdHandTakeOverList");
	}
	
	List<Object[]> doctorList = new ArrayList<Object[]>();
	if(map.get("doctorList")!=null){
		doctorList= (List<Object[]>)map.get("doctorList");
	}
	
	Patient patient = null;
	Inpatient inpatient=null;
	if(map.get("inpatient")!=null){
		inpatient= (Inpatient)map.get("inpatient");
		patient = inpatient.getHin();
	}
	String userName = "";
	int empId=0;
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(session.getAttribute("empId") != null){
		empId = Integer.parseInt(""+session.getAttribute("empId"));
	}
	String deptName = "";
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	if(map.get("message") != null){
		 String  message = (String)map.get("message");
%>
		   <h4><span><%=message %></span></h4>
		 <%} %>
<div class="titleBg">
<%--<h2>Hand over & Take over Entry </h2>
<input type="hidden" name="deptName" id="deptName"	value="<%=deptName %>" />
<div class="clear"></div>
</div>
 <form name="handtakeOver" method="post" action="">
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<%
		String entrySeqNo="";
		if(map.get("entrySeqNo") != null){
			entrySeqNo = (String)map.get("entrySeqNo");
		}
%> <label>Entry No.</label>
<input id="orderId" type=hidden	name="<%=ENTRY_NO %>" value="<%=entrySeqNo %>" title="Entry Number" tabindex="1"/>
<label class="value"> <%=entrySeqNo %></label>

<label>Entry Date</label>
<label class="value"><%=currentDate%></label>
<input type="hidden" value=<%=currentDate%> name="<%=ENTRY_DATE %>" id="entryDate"/>

<div class="clear"></div>
<label><span>*</span> From hand over</label>
<select	id="fromHandId" name=<%=FROM_HAND_OVER %> validate="From hand over,string,yes" tabindex="1">
		<option value="0">Select</option>

	<%
				         		if(employeeLoginList != null){
				         			for (Iterator iter = employeeLoginList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName() +" "+masEmployee.getLastName()%></option>
	<%
				        			}
				        		 }
				        %>
</select>

<label><span>*</span> To hand over</label>
<select	id="toHandId" name=<%=TO_HAND_OVER %> validate="To hand over,string,yes"tabindex="1" tabindex="1">
		<option value="0">Select</option>

	<%
				         		if(employeeList != null){
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         				if(empId==masEmployee.getId()){
				         					
				         				}else{
				         %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName() +" "+masEmployee.getLastName()%></option>
	<%	}
				        			}
				        		 }
				        %>
</select>
<div class="clear"></div>
<label><span>*</span> Shift Start from</label>
<input type="text" name="<%=SHIFT_START_FROM %>" value="" maxlength="6" id="shiftFromId" tabindex="1"
 	onblur="checkTime1('handtakeOver','<%=SHIFT_START_FROM%>');" validate="Shift Start from,time,yes"/>
 	
 	<label><span>*</span>AM/PM</label>
<select style="width:50px" name="ampm" id="ampm">
<option value="AM">AM</option>
<option value="PM">PM</option>
</select>
 	

<label><span>*</span> Remarks Pending Work</label>
<textarea name="<%=REMARKS_PENDING_WORK %>" value="" id="remarksPendingId" onkeyup="chkLength(this,100);"
	validate="Remarks Pending Work,string,yes" tabindex="1"></textarea>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="Submit"	onclick="submitForm('handtakeOver','ipd?method=submitHandTakeOver');" />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<input type="button" class="button" value="View" onclick="submitProtoAjaxForHandTakeOver('handtakeOver','ipd?method=viewHandTakeOver');" />
<input type="button" class="buttonBig" value="Generate Report" onclick="submitDetails()"/>

<label><span>*</span> To Date</label> <input type="text" id="ToDateId"
	name="toDate" value="<%=currentDate %>" class="date"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.handtakeOver.<%=TO_DATE%>,event)" />
<div class="clear"></div>
</form>
<div class="clear"></div>
<div class="division"></div>
<div id="testDiv">
</div> 
<script type="text/javascript">
function chkLength(field,maxLimit)
	{
	if(field.value.length > maxLimit)
	{
	 alert('Maximum Limit is '+maxLimit+' characters.');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
	}
}
function submitProtoAjaxForHandTakeOver(formName,action){
	var toDate = document.getElementById("ToDateId").value;
  	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&toDate="+toDate;
     	       	new Ajax.Updater('testDiv',url,
			   {asynchronous:true, evalScripts:true });
			return true;
 }
function submitDetails(){

	    document.handtakeOver.action="ipd?method=reportHandTakeOver";
        document.handtakeOver.submit();
}
</script> --%>


<div class="titleBg"><h2>Care/Doctor Transfer</h2></div>

<%
/* URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in); */

String mmMasRequestStatusPending=null;
String	mmMasRequestStatusApproved=null;
String	mmMasRequestStatusReject=null;

URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");
try {
	Properties prop1 = new Properties();
	prop1.load(new FileInputStream(new File(resourcePath.getFile())));
	mmMasRequestStatusPending=prop1.getProperty("mmMasRequestStatusPending");
	mmMasRequestStatusApproved=prop1.getProperty("mmMasRequestStatusApproved");
	mmMasRequestStatusReject=prop1.getProperty("mmMasRequestStatusReject");
} catch (IOException e) {
	e.printStackTrace();
}
%>

<div class="Block">

<div class="clear"></div>

<%-- <label class="auto">Transfer No.</label> 
<label	class="valueAuto"><%=transferNo %></label>  --%>

<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp"  />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="admissionAcceptance" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"],[1, "uhid"], [2,"pname"], [3,"ipdno"], [4,"fdept"],[5,"funit"],[6,"tdept"],[7,"tunit"],[8,"fdoctor"],[9,"tdoctor"],[10,"remarks"],[11,"status"]];
	 statusTd = 12;
	</script><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
</div>

<script type="text/javascript" language="javascript">
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "UHID"
	data_header[0][1] = "data";
	data_header[0][2] = "15%";
	data_header[0][3] = "uhid";
	
	data_header[1] = new Array;
	data_header[1][0] = "Patient Name"
	data_header[1][1] = "data";
	data_header[1][2] = "30%";
	data_header[1][3] = "pname";
	
	
	data_header[2] = new Array;
	data_header[2][0] = "Ip No."
	data_header[2][1] = "data";
	data_header[2][2] = "30%";
	data_header[2][3] = "ipdno";
	
	data_header[3] = new Array;
	data_header[3][0] = "From Department"
	data_header[3][1] = "data";
	data_header[3][2] = "15%";
	data_header[3][3] = "fdept";
	
	data_header[4] = new Array;
	data_header[4][0] = "From Unit"
	data_header[4][1] = "data";
	data_header[4][2] = "20%";
	data_header[4][3] = "funit";
	
	data_header[5] = new Array;
	data_header[5][0] = "To Department"
	data_header[5][1] = "data";
	data_header[5][2] = "20%";
	data_header[5][3] = "tdept";
	
	
	data_header[6] = new Array;
	data_header[6][0] = "To unit"
	data_header[6][1] = "data";
	data_header[6][2] = "20%";
	data_header[6][3] = "tunit";
	
	data_header[7] = new Array;
	data_header[7][0] = "From Doctor"
	data_header[7][1] = "data";
	data_header[7][2] = "20%";
	data_header[7][3] = "fdoctor";
	
	
	data_header[8] = new Array;
	data_header[8][0] = "To Doctor"
	data_header[8][1] = "data";
	data_header[8][2] = "20%";
	data_header[8][3] = "tdoctor";
	
	data_header[9] = new Array;
	data_header[9][0] = "Remarks"
	data_header[9][1] = "data";
	data_header[9][2] = "20%";
	data_header[9][3] = "remmarks";
	
	data_header[10] = new Array;
	data_header[10][0] = "Status"
	data_header[10][1] = "data";
	data_header[10][2] = "20%";
	data_header[10][3] = "status";
	<%
	%>
	 data_arr = new Array();
	<%
	if(ipdHandTakeOverList.size()>0)
	{ 
		int handtakeCount=0;
		%>
		 data_arr = new Array();
		<%
		for(IpdHandTakeOver ipdHandTakeOver:ipdHandTakeOverList)
		{
			String transferPatientname=ipdHandTakeOver.getHin().getPFirstName();
			if(ipdHandTakeOver.getHin().getPMiddleName()!=null){
				transferPatientname += " "+ipdHandTakeOver.getHin().getPMiddleName();
			}
			if(ipdHandTakeOver.getHin().getPLastName()!=null){
				transferPatientname += " "+ipdHandTakeOver.getHin().getPLastName();
			}
			
			String fromDoctorName=ipdHandTakeOver.getHandBy().getFirstName();
			if(ipdHandTakeOver.getHandBy().getMiddleName()!=null){
				fromDoctorName += " "+ipdHandTakeOver.getHandBy().getMiddleName();
			}
			if(ipdHandTakeOver.getHandBy().getLastName()!=null){
				fromDoctorName += " "+ipdHandTakeOver.getHandBy().getLastName();
			}
			
			String toDoctorName=ipdHandTakeOver.getTakeBy().getFirstName();
			if(ipdHandTakeOver.getTakeBy().getMiddleName()!=null){
				toDoctorName += " "+ipdHandTakeOver.getTakeBy().getMiddleName();
			}
			if(ipdHandTakeOver.getTakeBy().getLastName()!=null){
				toDoctorName += " "+ipdHandTakeOver.getTakeBy().getLastName();
			}
			String status="";
					if(ipdHandTakeOver.getRequestStatus().getStatusCode().equalsIgnoreCase(mmMasRequestStatusPending))
					{
						status="Pending";
					}
					else if(ipdHandTakeOver.getRequestStatus().getStatusCode().equalsIgnoreCase(mmMasRequestStatusReject))
					{
						status="Rejected";
					}
					else
					{
						status="Pending";
					}
			
		%>
		
		    
			data_arr[<%=handtakeCount%>] = new Array();
			data_arr[<%=handtakeCount%>][0] = "<%=ipdHandTakeOver.getId()%>"
			data_arr[<%=handtakeCount%>][1] = '<%=ipdHandTakeOver.getHin().getHinNo()%>'
			data_arr[<%=handtakeCount%>][2] ="<%=transferPatientname%>"
			data_arr[<%=handtakeCount%>][3] = "<%=ipdHandTakeOver.getInpatient().getAdNo()%>"
			data_arr[<%=handtakeCount%>][4] = "<%=ipdHandTakeOver.getFromDepartment().getDepartmentName()%>"
			data_arr[<%=handtakeCount%>][5] = "-"
			data_arr[<%=handtakeCount%>][6] = "<%=ipdHandTakeOver.getDepartment().getDepartmentName()%>"
			data_arr[<%=handtakeCount%>][7] = "-"
			data_arr[<%=handtakeCount%>][8] = "<%=fromDoctorName%>"
			data_arr[<%=handtakeCount%>][9] = "<%=toDoctorName%>"
			data_arr[<%=handtakeCount%>][10] = "<%=ipdHandTakeOver.getRemarksPendingWork()!=null ? ipdHandTakeOver.getRemarksPendingWork() : ""%>"
			data_arr[<%=handtakeCount%>][11] = "<%=status%>"
			<%
			handtakeCount++;
			}
	}
	%>
	
	  /*   data_arr = new Array();
		data_arr[0] = new Array();
		data_arr[0][0] = ""
		data_arr[0][1] = ""
		data_arr[0][2] =""
		data_arr[0][3] = ""
		data_arr[0][4] = " "
		data_arr[0][5] = " "
		data_arr[0][6] = " "
		data_arr[0][7] = " "
		data_arr[0][8] = " "
		data_arr[0][9] = " "
		data_arr[0][10] = " "
		data_arr[0][11] = " "	
		
		data_arr[1] = new Array();
		data_arr[1][0] = ""
		data_arr[1][1] = ""
		data_arr[1][2] =""
		data_arr[1][3] = ""
		data_arr[1][4] = " "
		data_arr[1][5] = " "
		data_arr[1][6] = " "
		data_arr[1][7] = " "
		data_arr[1][8] = " "
		data_arr[1][9] = " "
		data_arr[1][10] = " "
		data_arr[1][11] = " " */
		
		
	
    formName = "admissionAcceptance"
	
	start = 0;
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	
		
	</script>
	<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<form name="handtakeOver" method="post">

<input type="hidden" name="<%=HIN_ID %>" value="<%=inpatient.getHin().getId() %>" validate="hinId,int,no"/>
<input type="hidden" name="<%=AD_NO %>" value="<%=inpatient.getAdNo()%>" validate="adNo,metachar,no"/>
<input type="hidden" name="<%=INPATIENT_ID%>" value="<%=inpatient.getId()%>" validate="inpatientId,int,no"/>
<label ><span>*</span> Transfer Date</label> 
<input type="text" id="tdate" name="<%=TRANSFER_DATE %>" tabindex="1" value="<%=currentDate %>" class="date" readonly="readonly" validate="Transfer Date,date,yes" MAXLENGTH="30"  />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="javascript:setdate('<%=currentDate %>',document.handtakeOver.<%=TRANSFER_DATE%>,event)"	tabindex="1" />
<label class="">Transfer Time</label>
<input	type="text" class="date" name="<%=TRANSFER_TIME%>" value="<%=currentTime%>"	onKeyUp="mask(this.value,this,'2,5',':');" validate="Transfer Time,string,no"	onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" />
<label>Admission Date</label> 
<label class="value"><%=HMSUtil.convertDateToStringWithoutTime(inpatient.getDateOfAddmission()) %></label>
<div class="clear"></div>
<label >Admission Time
</label> <label class="value"><%=inpatient.getTimeOfAddmission() %></label>



<div class="paddingTop25"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>

<%@include file="PatientDetails.jsp" %>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>


<div class="clear"></div>
<h4>Transfer Details</h4>
<div class="clear"></div>

<label>From Deapartment</label> 
<input type="text" value="<%=inpatient.getDepartment().getDepartmentName()%>"class="readOnly" readonly="readonly">
	<input type="hidden" name="<%=FROM_WARD%>" value="<%=inpatient.getDepartment().getId()%>" validate="fromWard,metachar,no"/>

<label><span>*</span>  To Department</label> <select name="<%=TO_WARD %>" 
	onchange="onDepartmentChange();" id="wardId"
	validate="To Department,metachar,yes">
	<option value="0">Select</option>
	
	<%
		for (MasDepartment  obj : departmentList){
				
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getDepartmentName()%></option>
	<% 
	}%> 
</select> 


 <label><span>*</span> Authorized By</label> 
 
 <select
	name="<%=AUTHORIZER_ID %>" validate="Authorized By,metachar,yes" >
	<option value="0">Select</option>
	<%
		for (MasEmployee  obj : employeeList){
				String doctorMiddleName = "";
				String doctorLastName = "";
				if(obj.getMiddleName()!= null){
					doctorMiddleName = obj.getMiddleName();
				}
				if(obj.getLastName()!= null){
					doctorLastName = obj.getLastName();
				}
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getFirstName()+" "+doctorMiddleName+" "+doctorLastName%></option>
	<% 
	}%> 
</select>


<label>From Doctor</label> 
<label class="value"><%=inpatient.getDoctor().getFirstName()%>
<input type="hidden" name="fromDoctor" value="<%=inpatient.getDoctor().getId()%>" validate="fromDoctor,int,no"/>
</label>
<label><span>*</span>  To Doctor</label> <select name="doctorId" onchange="" id="doctorId" 	validate="To Doctor,metachar,yes"> 
	<option value="0">Select</option>
	
	<%
		for (MasEmployee  obj : employeeList){
				String doctorMiddleName = "";
				String doctorLastName = "";
				if(obj.getMiddleName()!= null){
					doctorMiddleName = obj.getMiddleName();
				}
				if(obj.getLastName()!= null){
					doctorLastName = obj.getLastName();
				}
				System.out.println(obj.getFirstName()+" "+doctorMiddleName+" "+doctorLastName);
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getFirstName()+" "+doctorMiddleName+" "+doctorLastName%></option>
	<% 
	}%> 
</select> 
<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>


<input type="button" name="Submit" value="Submit" class="button" onclick="submitForm('handtakeOver','ipd?method=submitHandTakeOver');" />
<input type="reset" class="button" name="reset" value="Reset" onclick="submitFormForButton('handtakeOver','ipd?method=showHandTakeJsp');"/>
<input type="reset" class="button" name="reset" value="Back" onclick="submitFormForButton('handtakeOver','ipd?method=showPatientListNurseJsp');"/>

	
	<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="clear"></div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<div class="clear"></div>
<div class="paddingTop40"></div>

<script type="text/javascript">

function onDepartmentChange()
{
	var doctorElemnt=document.getElementById("doctorId");
	doctorElemnt.options.length = 0;
	doctorElemnt.options[0] = new Option("select","0");
	var i=1;
	<%-- alert(<%=doctorList.size()%>); --%>
	<%	
	for (Object[]  obj : doctorList){
		int doctorDepartment=(Integer)obj[2];
		//System.out.println("doctorDepartment=="+doctorDepartment);
	    //String[] departments=doctorDepartment.split(",");
	    List<Integer> departmentList1=Arrays.asList(doctorDepartment);
	%>
	    var departmentMatched=false;
	    <%
	    for (Integer  department : departmentList1){
	    	%>
	    	if(document.getElementById("wardId").value!=""&& parseInt(document.getElementById("wardId").value)==parseInt('<%=department%>')){
	    		departmentMatched=true;
	    	}
	    	<%
	    }%>
	if(departmentMatched)
	{
		doctorElemnt.options[i] = new Option("<%=(String)obj[1]%>","<%=(Integer)obj[0]%>");
		i++;
	}

	<%
	
	}%> 
}
onDepartmentChange();
</script>


 