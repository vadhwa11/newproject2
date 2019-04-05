
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>

<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.masters.business.MasComplaintRegister"%>
<%@ page import="jkt.hms.masters.business.MasComplaintsType"%>

<%@page import="jkt.hms.masters.business.MasSmq"%>
<%@page import="jkt.hms.masters.business.MasComplaintRegister"%>
<SCRIPT language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></SCRIPT>

<script language="javascript" type="text/javascript">
function chkLength(field,maxLimit)
	{
	if(field.value.length > maxLimit)
	{
	 alert('Maximum Limit is '+maxLimit+' characters.');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
	}
}

function resetValue(){


}
</script>

<script type='text/javascript'>
function isAlphabet(field){
	var alphaExp = /^[a-zA-Z]+$/;
	if(field.value.match(alphaExp)){
		return true;
	}else{
		alert('Please Enter Only Letters ');
		elem.focus();
		return false;
	}
}
</script>


<script language="JavaScript" type="text/javascript">
  
  function isNumber1(field) { 
       var i=14;
        var re = /^[0-9-'.'-',']*$/; 
        if (!re.test(field.value)) { 
            alert('please enter only numeric data'); 
            field.value = field.value.replace(/[^0-9-'.'-',']/g,""); 
       
        } 
     var aa=field.value[1];
    if(field.value.indexOf(".")<15)
    {
 return true;
 }
 else
 {
     alert('please enter less than 14 digit before decimal point'+aa); 
		 field.value=''; 
 
	}




}

    
  
</script>

<script language="JavaScript" type="text/JavaScript"> 
function isNumber(field) { 
        var re = /^[0-9-'.'-',']*$/; 
        if (!re.test(field.value)) { 
            alert('please enter only numeric data'); 
            field.value = field.value.replace(/[^0-9-'.'-',']/g,""); 
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
    
</script>


<SCRIPT LANGUAGE="JavaScript" type="text/javascript">

function checkTime(formName,timeFieldName){
  
 objTime = eval('document.'+formName+'.'+timeFieldName);
   var chtime=objTime.value;
 if(chtime.trim()!=""){ 
    
 try{
   var indx = chtime.indexOf(':');
   
   if (indx != -1) {
   var pairs2 = chtime.substring(0,chtime.length).split(':');
   }
      
   if (pairs2.length!=2) { 
    alert("Invalid Time Format.It should be HH:MM")
    objTime.value=""
   return false;
   }
   
   if (pairs2[0].length != 2 || pairs2[1].length != 2 ) {
      alert("Invalid Time Format.It should be HH:MM")
      objTime.value=""
      return false;
    }
   
      val2=eval(pairs2[0]);
     
        if (val2<0 || val2>23) {
         alert("Hours should 00-23")
         objTime.value=""
         return false;}
         
         val3=eval(pairs2[1]);
     
         if (val3<0 || val3>59) {
         alert("Min should 00-59")
         objTime.value=""
         return false;}
       
     
 }catch(e2)
 { alert("Invalid Time")
 objTime.value=""
  return false;
 }
  }
return true;
}
</script>


<script>
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
			
		%>
			serverdate = '<%=dateCal+"/"+month+"/"+year%>'
			
		</script>

<script type="text/javascript" language="javascript">
			
function getRecords(formName)
{
var deptId=document.getElementById('dept').value
if(deptId=="0"){
alert()
return false;
}
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/complaint?method=getRecordsForWorkNotCompletion&deptId="+deptId+"";
  obj.submit();
}

function getComplaint(formName)
{
var complaintType = document.getElementById('complaint').value
if(complaintType=="0"){
alert()
return false;
}
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/complaint?method=getRecordsForWorkNotCompletion&complaintType="+complaintType+"";
  obj.submit();
}

			</script>

<script>
var poolSelected=false;
function chkLength(field,maxLimit)
	{
	if(field.value.length > maxLimit)
	{
	 alert('Maximum Limit is '+maxLimit+' characters.');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
	}
}
</script>


<!-- <script type="text/javascript" language="javascript">
	function saveforWork(){
			
			submitForm('workNotCompletion','complaint?method=addMasComplaintRegister');
			}
			</script>
	 -->
<%
		Map<String, Object> map = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
			
		}
		
		Box box = HMSUtil.getBox(request);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
	
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		if (map.get("gridDepartmentList") != null) {
			System.out.println("gridDepartmentList");
			departmentList = (List) map.get("gridDepartmentList");
		}
		
		List<MasDepartment> departmentNameList = new ArrayList<MasDepartment>();
		if (map.get("departmentNameList") != null) {
			System.out.println("departmentNameList");
			departmentNameList = (List) map.get("departmentNameList");
		}
	
		List<MasComplaintRegister> ComplaintList = new ArrayList<MasComplaintRegister>();
		if (map.get("complaintList") != null) {
			ComplaintList = (List) map.get("complaintList");
		}
		
		List<MasComplaintRegister> workCompletion=new ArrayList<MasComplaintRegister>();
		if (map.get("workCompletion") != null) {
			workCompletion = (List<MasComplaintRegister>) map.get("workCompletion");
			
		}
		
		List<MasComplaintRegister> workCompletionList = new ArrayList<MasComplaintRegister>();
		
		if(map.get("workCompletionList") != null)
		{
			workCompletionList = (List) map.get("workCompletionList");
		}
		
		List<MasComplaintRegister> complaintRegisterList=new ArrayList<MasComplaintRegister>();
		if (map.get("complaintRegisterList") != null) {
			complaintRegisterList = (List<MasComplaintRegister>) map.get("complaintRegisterList");
			
		}	
		
		List<MasComplaintsType> complaintTypeList = new ArrayList<MasComplaintsType>();
		if(map.get("complaintTypeList") != null)
		{
			complaintTypeList = (List)map.get("complaintTypeList");
		}
	
		List searchComplaintRegisterList = new ArrayList();
		if (map.get("searchComplaintRegisterList") != null) {
			searchComplaintRegisterList = (List) map
					.get("searchComplaintRegisterList");
		}
	
		ArrayList gridDepartmentList = (ArrayList) map.get("gridDepartmentList");
		ArrayList gridComplaintList = (ArrayList) map.get("gridComplaintList");
		ArrayList gridSmqList = (ArrayList) map.get("gridSmqList");
		
	
		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		
			String message = "";
			
		
	%>

<% 
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>

<div id="contentHolder">
<h6>Commandant Remark</h6>
<div class="Clear"></div>

<div class="blockFrame">
<form name="search" method="post" action="">

<div class="Clear"></div>


<label>Complaint Number</label> <input type="radio"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radio" />


<label>Complaint Desc</label> <input type="radio"
	name="<%=SELECTED_RADIO %>" value="2" class="radio" /> <input
	type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""
	MAXLENGTH="8" tabindex=1 /> <label>PDC Over</label> <input
	tabindex="1" id="<%=PDC_OVER%>" type="checkbox" name="<%=PDC_OVER%>"
	value="" onclick="checkCheckBox();" class="radio2" /> <script
	type="text/javascript">
	       function  checkCheckBox()
	       {
	       var value1=document.getElementById('<%=PDC_OVER%>').value;
	       
	       if(document.getElementById('<%=PDC_OVER%>').checked){
	       document.getElementById('<%=PDC_OVER%>').value='c';	     
	       }else{
	       document.getElementById('<%=PDC_OVER%>').value='n';	     
	       }
	       
	       
	       }   
	          
	          </script>




<div class="Clear"></div>

<label>Department </label> <select name="<%= DEPARTMENT_ID %>" id="dept"
	tabindex="1">

	<option value="0">Select</option>
	<%
		int deptId=(Integer)session.getAttribute("deptId");
		if(departmentList!= null){
		for (MasDepartment masDepartment : departmentList) {
			if(masDepartment.getId()==deptId){
		%>

	<option value=<%=masDepartment.getId()%>><%=masDepartment.getDepartmentName()%></option>
	<%}else{%>
	<option value=<%=masDepartment.getId()%>><%=masDepartment.getDepartmentName()%></option>
	<%
		}}}
		%>
</select> <label>Complaint Type</label> <select name="<%= COMPLAINT_TYPE %>"
	id="complaint" tabindex="1">

	<option value="0">Select</option>
	<%
		int complaintType =0;
		if(complaintTypeList!= null){
			for (MasComplaintsType masComplaintsType : complaintTypeList) {
				if(masComplaintsType.getId() == complaintType){
		%>
	<option value=<%=masComplaintsType.getId()%>><%=masComplaintsType.getComplaintTypeName()%></option>
	<%}else{ %>
	<option value=<%=masComplaintsType.getId()%>><%=masComplaintsType.getComplaintTypeName()%></option>
	<%
			}}}
		%>
</select> <input type="button" name="search" value="Search" class="cmnButton"
	onclick="submitForm('search','complaint?method=searchCommandantRemark')"
	tabindex=1 /></form>

</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<%
				if (searchComplaintRegisterList != null
						&& searchComplaintRegisterList.size() > 0) {
					String strForCode = (String) map.get("complaintNo");
					String strForCodeDescription = (String) map.get("complaintDesc");
					Integer dept = (Integer) map.get("deptId");
					Integer complaint = (Integer) map.get("complaintType");
					if (strForCode != null && strForCode != ""|| strForCodeDescription != null && strForCodeDescription != "" || dept != null && dept != 0 || complaint != null && complaint != 0) {
			%> <br />

<h5><a href="/hms/hms/complaint?method=showComandantRemarkJsp">Show
All Records</a></h5>
<%
			}
			}
			if (searchComplaintRegisterList.size() == 0
					&& map.get("search") != null) {
		%>
<h5><a href="/hms/hms/complaint?method=showComandantRemarkJsp">Show
All Records</a></h5>

<%
				}
			%> <script type="text/javascript">
			
			formFields = [[0, "<%= COMMON_ID%>","id" ],[1, "<%= COMMON_ID%>","id" ],[2,"<%= COMPLAINT_NO%>"], [3,"<%= COMPLAINT_DESC%>"], [4,"<%= COMPLAINT_TYPE %>"],[5,"<%= COMPLAINT_DATE %>"],[6,"<%= COMPLAINT_TIME %>"],[7,"<%=DEPARTMENT_NAME %>"],[8,"<%=COMPLAINT_CRITERIA %>"],[9,"<%= SERVICE_NO%>"], [10,"<%= SERVICE_PERSON %>"],[11,"<%=  BUILDING_NO %>"],[12,"<%=COMPLAINT_DETAILS%>"],[13,"<%= CHANGED_BY%>"],[14,"<%= CHANGED_DATE %>"],[15,"<%= CHANGED_TIME%>"],[16,"<%=STATUS%>"],[17,"complaintId"],[18,"<%=WORK_COMPLETION_ADMIN_REMARKS%>"],[19,"complaintId1"],
			[20,"<%=PDC_DATE%>"],[21,"<%=COMMANDENT_REMARKS%>"],[22,"<%=REMARKS%>"]];
		 statusTd = 16;
			</script></div>
<div class="Clear"></div>
<form name="commandantRemark" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasComplaintRegister">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"
	value="ComplaintDesc"> <input type="hidden" name="title"
	value="WorkCompletion"> <input type="hidden"
	name="<%=JSP_NAME %>" value="complaintRegister">

<div class="blockTitle">Complaint Register</div>
<div class="blockTitleCurve"></div>

<div class="blockFrame">
<div class="Clear"></div>
<label><span>*</span> Complaint Number</label> <input type="text"
	class="value" readonly="true" name="<%= COMPLAINT_NO %>" value="" />

<label><span>*</span> Complaint Date</label> <input type="text"
	readonly="true" name="<%= COMPLAINT_DATE %>" value=""
	id="ComplaintDate" /> <label><span>*</span> Complaint Time</label> <input
	type="text" readonly="true" name="<%= COMPLAINT_TIME %>" value="" />

<div class="Clear"></div>

<label>Complaint Type</label> <select name="<%= COMPLAINT_TYPE %>">

	<option value="0">Select</option>
	<%if(complaintTypeList!= null){
			for (MasComplaintsType masComplaintsType : complaintTypeList) {
		%>

	<option value=<%=masComplaintsType.getId()%>><%=masComplaintsType.getComplaintTypeName()%></option>

	<%
			}}
		%>
</select> <label>Complaint Criteria</label> <select id="<%=COMPLAINT_CRITERIA %>"
	name="<%=COMPLAINT_CRITERIA %>"
	validate="Complaint Criteria,string,yes">
	<option value="0">Select</option>
	<option value="new">New</option>
	<option value="regular">Regular</option>
</select> <label><span>*</span> Service No</label> <input type="text"
	name="<%= SERVICE_NO%>" validate="Service No,string,yes"
	readonly="true" />

<div class="Clear"></div>

<label><span>*</span> Complaint Person Name</label> <input type="text"
	name="<%= SERVICE_PERSON %>" validate="Person Name,string,yes"
	readonly="true" /> <label>Department </label> <select
	name="<%= DEPARTMENT_NAME %>" readonly="true">

	<option value="0">Select</option>
	<%
			for (MasDepartment masdepartment : departmentNameList) {
		%>

	<option value=<%=masdepartment.getId()%>><%=masdepartment.getDepartmentName()%></option>

	<%
			}
		%>
</select> <label>Building No. </label> <input type="text"
	name="<%= BUILDING_NO%>" readonly="true" />


<div class="Clear"></div>
<label>Complaint Details</label> <textarea cols="" class="large"
	name="<%= COMPLAINT_DETAILS %>" readonly="true"></textarea>

<div class="Clear"></div>

<label>MES Remarks</label> <textarea class="large"
	name="<%= WORK_COMPLETION_ADMIN_REMARKS %>" MAXLENGTH="30"
	readonly="true"> </textarea>

<div class="Clear"></div>
</div>
<div class="division"></div>
<div class="blockTitle">Admin Remarks</div>
<div class="blockTitleCurve"></div>
<div class="blockFrame"><label>PDC Date</label> <input type="text"
	id="pdcDate" name="<%=PDC_DATE%>" value="" class="calDate"
	readonly="readonly" MAXLENGTH="30" tabindex=1 /> <!--<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.workNotCompletion.<%=PDC_DATE%>,event)"; />
				
				--><!--<label><span>*</span> PDC Time</label>
	<input type="text"	name="<%= PDC_TIME %>" value="" id="time"	validate="Pdc Time,time,yes" onblur="checkTime('workNotCompletion','time');" MAXLENGTH="10" tabindex=1 onkeypress="return submitenter(this,event,'complaint?method=addMasComplaintRegister')"> 
	
	-->
<div class="Clear"></div>

<label><span>*</span> C Adm O's Remark</label> <textarea
	name="<%=REMARKS %>" value="" readonly="readonly"
	validate="Remarks,string,no" class="large"
	onKeyDown="limitText(this,200);" tabindex=1
	onkeypress="return submitenter(this,event,'complaint?method=addCommandantRemark')"> </textarea>

<input type="hidden" name="complaintId" id="complaintId" value="" />

<div class="Clear"></div>
<label>Commandant Remarks</label> <textarea
	name="<%=COMMANDENT_REMARKS %>" value="" class="large"
	onKeyDown="limitText(this,200);" tabindex=1
	onkeypress="return submitenter(this,event,'complaint?method=addCommandantRemark')"> </textarea>

<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /></div>


<div class="division"></div>
<div id="edited"></div>
<!--Bottom labels starts-->
<div class="bottom"><input type="button" name="add" id="edited"
	value="Add" class="button"
	onClick="submitForm('commandantRemark','complaint?method=addCommandantRemark')"
	accesskey="a" tabindex=1 /> <input type="button" name="back" id="back"
	value="Back" class="button" onclick="javascript:history.back()"
	accesskey="b" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="button" onclick="resetCheck();"
	accesskey="r" tabindex=1 /> <input type="button"
	style="visibility: hidden" name="edit" id="editbutton" value="Update"
	class="button"
	onClick="submitForm('complaintRegister','complaint?method=editComplaintType')"
	accesskey="u" tabindex=1 /> <input type="button"
	style="visibility: hidden" name="Delete" id="deletebutton"
	value="Activate" class="button"
	onClick="submitForm('complaintRegister','complaint?method=deleteComplaintType&flag='+this.value)"
	accesskey="d" tabindex=1 />

<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
</form>
</div>



<script type="text/javascript">
		data_header = new Array();
		data_header[0] = new Array;
		data_header[0][0] = "S No."
		data_header[0][1] = "data";
		data_header[0][2] = "20%";
		data_header[0][3] = "<%= COMMON_ID%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Complaint Number"
		data_header[1][1] = "data";
		data_header[1][2] = "20%";
		data_header[1][3] = "<%= COMPLAINT_NO%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Complaint Description "
		data_header[2][1] = "data";
		data_header[2][2] = "25%";
		data_header[2][3] = "<%= COMPLAINT_DESC %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Complaint Type"
		data_header[3][1] = "data";
		data_header[3][2] = "15%";
		data_header[3][3] = "<%= COMPLAINT_TYPE %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "Complaint Date"
		data_header[4][1] = "data";
		data_header[4][2] = "10%";
		data_header[4][3] = "<%= COMPLAINT_DATE %>";
		
		data_header[5] = new Array;
		data_header[5][0] = "Complaint Time"
		data_header[5][1] = "data";
		data_header[5][2] = "30%";
		data_header[5][3] = "<%= COMPLAINT_TIME%>";
		
		data_header[6] = new Array;
		data_header[6][0] = "Complaint Department"
		data_header[6][1] = "data";
		data_header[6][2] = "40%";
		data_header[6][3] = "<%=DEPARTMENT_NAME %>";
			
		data_header[7] = new Array;
		data_header[7][0] = ""
		data_header[7][1] = "hide";
		data_header[7][2] = "0";
		data_header[7][3] = "<%=COMPLAINT_CRITERIA%>";
			
		data_header[8] = new Array;
		data_header[8][0] = "Service No."
		data_header[8][1] = "hide";
		data_header[8][2] = "10%";
		data_header[8][3] = "<%=SERVICE_NO %>";
		
		data_header[9] = new Array;
		data_header[9][0] = "Person Name"
		data_header[9][1] = "hide";
		data_header[9][2] = "10%";
		data_header[9][3] = "<%=SERVICE_PERSON %>";
		
		data_header[10] = new Array;
		data_header[10][0] = "Building No."
		data_header[10][1] = "hide";
		data_header[10][2] = "10%";
		data_header[10][3] = "<%=BUILDING_NO %>";
		
		data_header[11] = new Array;
		data_header[11][0] = "Complaint Detail"
		data_header[11][1] = "hide";
		data_header[11][2] = "10%";
		data_header[11][3] = "<%=COMPLAINT_DETAILS %>";
		
		data_header[12] = new Array;
		data_header[12][0] = ""
		data_header[12][1] = "hide";
		data_header[12][2] = 0;
		data_header[12][3] = "<%=CHANGED_BY %>"
		
		data_header[13] = new Array;
		data_header[13][0] = "Admin"
		data_header[13][1] = "hide";
		data_header[13][2] = 0;
		data_header[13][3] = "<%=CHANGED_DATE %>"
		
		data_header[14] = new Array;
		data_header[14][0] = ""
		data_header[14][1] = "hide";
		data_header[14][2] = "0";
		data_header[14][3] = "<%=CHANGED_TIME %>";
		
		data_header[15] = new Array;
		data_header[15][0] = "Status"
		data_header[15][1] = "data";
		data_header[15][2] = "15%";
		data_header[15][3] = "<%=STATUS %>";
		
		data_header[16] = new Array;
		data_header[16][0] = ""
		data_header[16][1] = "hide";
		data_header[16][2] = "0";
		data_header[16][3] = "complaintId";
		
		data_header[17] = new Array;
		data_header[17][0] = ""
		data_header[17][1] = "hide";
		data_header[17][2] = "0";
		data_header[17][3] = "<%=WORK_COMPLETION_ADMIN_REMARKS%>";
		
		data_header[18] = new Array;
		data_header[18][0] = ""
		data_header[18][1] = "hide";
		data_header[18][2] = "0";
		data_header[18][3] = "complaintId1";
				
				data_header[19] = new Array;
		data_header[19][0] = ""
		data_header[19][1] = "hide";
		data_header[19][2] = "0";
		data_header[19][3] = "<%=PDC_DATE%>";
				
				data_header[20] = new Array;
		data_header[20][0] = ""
		data_header[20][1] = "hide";
		data_header[20][2] = "0";
		data_header[20][3] = "<%=COMMANDENT_REMARKS%>";		
				
				data_header[21] = new Array;
		data_header[21][0] = ""
		data_header[21][1] = "hide";
		data_header[21][2] = "0";
		data_header[21][3] = "<%=REMARKS%>";		
				
	
		data_arr = new Array();
		<%
		if(searchComplaintRegisterList!= null){
			Iterator itr=searchComplaintRegisterList.iterator();
		    int  counter=0;
		    while(itr.hasNext())
		    {			
		         MasComplaintRegister  masComplaintRegist= (MasComplaintRegister)itr.next(); 
		       
		%>
		  		
		  		<% if(masComplaintRegist != null && !masComplaintRegist.getStatus().equalsIgnoreCase("c")){ %>
		  			
		  		data_arr[<%= counter%>] = new Array();
					data_arr[<%= counter%>][0] = <%= masComplaintRegist.getId()%>
				data_arr[<%= counter%>][1] = <%= masComplaintRegist.getId()%>
				<%if(masComplaintRegist.getComplaintNo() != null){%>
				data_arr[<%= counter%>][2] = "<%=masComplaintRegist.getComplaintNo()%>"
				<%}else{%>
				data_arr[<%= counter%>][2] = " "
				<%}%>
				
				<%if(masComplaintRegist.getComplaintDetails() != null){%>
				data_arr[<%= counter%>][3] = "<%= masComplaintRegist.getComplaintDetails()%>"
				<%}else{%>
				data_arr[<%= counter%>][3] = " "
				<%}%>
	
		       data_arr[<%= counter%>][4] = "<%=masComplaintRegist.getComplaintType().getComplaintTypeName() %>";
			
				
				<%if(masComplaintRegist.getComplaintDate() != null){%>
				data_arr[<%= counter%>][5] ="<%= HMSUtil.convertDateToStringWithoutTime(masComplaintRegist.getComplaintDate()) %>"
				<%}else{%>
				data_arr[<%= counter%>]" " = " "
				<%}%>
				
				<%if(masComplaintRegist.getComplaintTime() != null){%>
				data_arr[<%= counter%>][6] = "<%= masComplaintRegist.getComplaintTime()%>"
				<%}else{%>
				data_arr[<%= counter%>][6] = " "
				<%}%>
			
		<%
			if(masComplaintRegist.getDepartment() != null)
			{
			%>
				data_arr[<%= counter%>][7] = "<%=masComplaintRegist.getDepartment().getDepartmentName()%>";		
            
				
			<%}
			else{%>
				data_arr[<%= counter%>][7] = " ";				
			
		<%}	
				
		   if(masComplaintRegist.getComplaintCriteria().equals("new")){%>
		    data_arr[<%= counter%>][8] = "New"
		    <%}else{%>
		     data_arr[<%= counter%>][8] = "Regular"
		     <%}%>
		
		 <%if(masComplaintRegist.getServiceNo() != null) {%>
			data_arr[<%= counter%>][9] = "<%= masComplaintRegist.getServiceNo()%>"
			<%}else{%>	
			data_arr[<%= counter%>][9] = " "
			<%}%>
			<%if(masComplaintRegist.getServicePersonName() != null){%>
			data_arr[<%= counter%>][10] = "<%= masComplaintRegist.getServicePersonName()%>"
			<%}else{%>
			data_arr[<%= counter%>][10] = " "
			<%}		
			
			
		if(masComplaintRegist.getSmqNo() != null){
		%>
			data_arr[<%= counter%>][11] = "<%=masComplaintRegist.getSmqNo().getSmqName()%>";
		<%}else{%>
				data_arr[<%= counter%>][11] = " ";
				
		<%	}
	
		
		%>
			<%if(masComplaintRegist.getComplaintDetails() != null){%>
			data_arr[<%= counter%>][12] = "<%= masComplaintRegist.getComplaintDetails()%>"
			<%}else{%>
			data_arr[<%= counter%>][12] = " "
			<%}%>
		  
		<%if(masComplaintRegist.getLstChangedBy() != null){%>
		    data_arr[<%= counter%>][13] = "<%= masComplaintRegist.getLstChangedBy()%>"
		    <%}else{%>
		    data_arr[<%= counter%>][13] = " "
		    <%}%>
		    
		    <%if(masComplaintRegist.getLstChangedDate() != null){%>
			data_arr[<%= counter%>][14] = "<%= HMSUtil.convertDateToStringWithoutTime(masComplaintRegist.getLstChangedDate())%>"
			<%}else{%>
			data_arr[<%= counter%>][14] = " "
			<%}%>
			
			<%if(masComplaintRegist.getLstChangedTime() != null){%>
			data_arr[<%= counter%>][15] = "<%= masComplaintRegist.getLstChangedTime()%>"
			<%}else{%>
			data_arr[<%= counter%>][15] = " "
			<%}%>
			
				<%if(masComplaintRegist.getPdc()!= null){%>
			data_arr[<%= counter%>][20] = "<%=HMSUtil.convertDateToStringWithoutTime(masComplaintRegist.getPdc())%>"
			<%}else{%>
			data_arr[<%= counter%>][20] = ""
			<%}%>
			
				<%if(masComplaintRegist.getCommandantRemark() != null){%>
			data_arr[<%= counter%>][21] = "<%= masComplaintRegist.getCommandantRemark()%>"
			<%}else{%>
			data_arr[<%= counter%>][21] = " "
			<%}%>
			<%if(masComplaintRegist.getCadoRemark() != null){%>
			data_arr[<%= counter%>][22] = "<%= masComplaintRegist.getCadoRemark()%>"
			<%}else{%>
			data_arr[<%= counter%>][22] = " "
			<%}%>
			
			
			
			
			
		<% if(masComplaintRegist.getStatus().equals("p")){ %>
						data_arr[<%= counter%>][16] = "Pending"
				<%}else if(masComplaintRegist.getStatus().equals("r")){%>
						data_arr[<%= counter%>][16] = "Pending"
							<%}else if(masComplaintRegist.getStatus().equals("c")){%>
								data_arr[<%= counter%>][16] = "Completed"
						data_arr[<%= counter%>][19] = "red"
				<%}
		%>
		data_arr[<%= counter%>][17] = <%= masComplaintRegist.getId()%>;
		
		<%
		String adminRemarks = "";
		if(masComplaintRegist.getMesRemark() != null){
		%>
		
				data_arr[<%= counter%>][18] = "<%=masComplaintRegist.getMesRemark()%>";
		
			<% }else{ %>
				data_arr[<%= counter%>][18] = "";
				<%} 
			
		    counter++;}
		    }
		}
		%>
		
				
		 formName = "commandantRemark"
		nonEditable = ['<%= WORK_COMPLETION_ID%>'];
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
		</script>

<script>
function checkd()
{
var SDate = document.commandantRemark.<%= WORK_COMPLETION_DATE%>.value;
var EDate = document.commandantRemark.<%=COMPLAINT_DATE%>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate < endDate)
{
alert("Please ensure that the Completion Date must be greater than Complaint Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>
