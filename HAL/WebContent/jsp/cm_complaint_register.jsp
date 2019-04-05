<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>

<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.masters.business.MasComplaintRegister"%>
<%@ page import="jkt.hms.masters.business.MasComplaintsType"%>

<%@page import="jkt.hms.masters.business.MasSmq"%>
<%@page import="jkt.hms.masters.business.ComplaintRegister"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<SCRIPT language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></SCRIPT>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></SCRIPT>

<script language="javascript" type="text/javascript">

function limitText(limitField, limitNum) {
    if (limitField.value.length > limitNum) {
        alert("you can't Enter more data");  
        limitField.value = limitField.value.substring(0, limitNum);
      
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

function checkFilledRowNew()
{
var radios = document.getElementsByName("<%=COMPLAINT_CRITERIA%>");
var selection = "";
for (var i in radios)
{
if (radios[i].checked)
{
selection = radios[i].value;

}
}
if( selection=="repeat")
{
	if (document.getElementById("oldComplaintNo1").value == "" && document.getElementById("oldComplaintNo2").value == "" && document.getElementById("oldComplaintNo3").value == "" && document.getElementById("oldComplaintDate1").value == "" && document.getElementById("oldComplaintDate2").value == "" && document.getElementById("oldComplaintDate3").value == "")
	{
	alert("Please fill at least one row or select complaint criteria as new ");
	return false;
	}
	if(document.getElementById("oldComplaintNo1").value != "" && document.getElementById("oldComplaintDate1").value == "")
	{
	alert("Please fill old Complaint Date of row 1 or remove entered complaint no");
	return false;
	}
	else if(document.getElementById("oldComplaintDate1").value != "" && document.getElementById("oldComplaintNo1").value == "")
	{
	alert("Please fill old Complaint Number of row 1 or remove the corresponding date ");
	return false;
	}
	if(document.getElementById("oldComplaintNo2").value != "" && document.getElementById("oldComplaintDate2").value == "")
	{
	alert("Please fill old Complaint Date of row 2 or remove entered complaint no");
	return false;
	}
	else if(document.getElementById("oldComplaintDate2").value != "" && document.getElementById("oldComplaintNo2").value == "")
	{
	alert("Please fill old Complaint Number of row 2 or remove the corresponding date ");
	return false;
	}
	
	if(document.getElementById("oldComplaintNo3").value != "" && document.getElementById("oldComplaintDate3").value == "")
	{
	alert("Please fill old Complaint Date of row 3 or remove entered complaint no");
	return false;
	}
	else if(document.getElementById("oldComplaintDate3").value != "" && document.getElementById("oldComplaintNo3").value == "")
	{
	alert("Please fill old Complaint Number of row 3 or remove the corresponding date ");
	return false;
	}
	else
	{
	 return true;
	}
	}		
	else
	{
	 return true;
	}
  }
    
</script>

<script type='text/javascript'>	
function isAlphabet(field){
	var alphaExp = /^[a-zA-Z(\s)/]+$/;
	if(field.value.match(alphaExp)){
		return true;
	}else if(field.value=="")
	{
	return true;
	}
	else{
		alert('Please Enter Only Letters ');
		field.value="";
		elem.focus();
		return false;
	}
}

function handleRem() {
  if(document.getElementById('location').value == "residential")
  {
  document.getElementById('abc').style.display = "block";
   document.getElementById('xyz').style.display = "none";
  }
  else{
  document.getElementById('abc').style.display = "none";
   document.getElementById('xyz').style.display = "block";
  }
  }

</script>



<script language="JavaScript" type="text/javascript">
  function fillOldComplaintDetail(complaintNoId,dateId){
		if(complaintNoId.value != "")
		{
		
			var complaintNo = complaintNoId.value;
		document.getElementById(dateId).value="";
	//		alert('Old complaint '+complaintNoId.value+'complanit no'+complaintNo);
		ajaxFunctionForAutoCompleteComplaintNo('complaintRegister','complaint?method=fillComplaintNo&complaintNo=' +  complaintNo , dateId,complaintNoId);
		
		}else{
		//alert('Old complaint in else condition '+complaintNoId.value);
			document.getElementById(oldComplaintNo).value = "";
		}
}
function checkComplaint(complaintId,complaintDateId)
{
if(complaintId.value!="")
{
//setTimeout("alert('Checking for match in previous complaint.Please wait....')",4000);

if(complaintDateId.value=="")
{
alert('Sorry! No matching complaint found! Please try again.');

complaintId.value = "";
complaintDateId.value = "";
}
}
} 

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

function choose(radiobutton)

{

 var text = radiobutton.value; 
if( text=="repeat")
{
document.getElementById("tableHms").style.display="";
document.getElementById("tableHms").focus();
}
else
{
document.getElementById("tableHms").style.display="none";

}
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

<%
				int pageNo = 1;
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
				if (map.get("departmentList") != null) {
					System.out.println("departmentList");
					departmentList = (List) map.get("departmentList");
				}

				MasComplaintRegister masComplaintRegister = new MasComplaintRegister();
				ArrayList searchComplaintRegisterList = (ArrayList) map
						.get("searchComplaintRegisterList");

				List<MasComplaintRegister> ComplaintList = new ArrayList<MasComplaintRegister>();
				if (map.get("searchComplaintRegisterList") != null) {
					ComplaintList = (List) map.get("searchComplaintRegisterList");
				}

				List<MasComplaintsType> complaintTypeList = new ArrayList<MasComplaintsType>();
				if (map.get("complaintTypeList") != null) {
					complaintTypeList = (List) map.get("complaintTypeList");
				}

				List<MasSmq> smqList = new ArrayList<MasSmq>();
				if (map.get("smqList") != null) {
					smqList = (List) map.get("smqList");
				}
				String serviceNo ="";
int id=0;
				ArrayList gridDepartmentList = (ArrayList) map
						.get("gridDepartmentList");
				ArrayList gridComplaintList = (ArrayList) map
						.get("gridComplaintList");
				ArrayList gridSmqList = (ArrayList) map.get("gridSmqList");
				ArrayList<ComplaintRegister> complaintRegister = (ArrayList<ComplaintRegister>) map
						.get("complaintRegister");
				ArrayList<MasEmployee> masEmployee = (ArrayList<MasEmployee>) map
				.get("masEmployee");
				
				String userName = "";
				String servicePersonName = "";
				if (session.getAttribute("userName") != null) {
					userName = (String) session.getAttribute("userName");
					Users users = (Users) session.getAttribute("users");
					if (users != null) {
						//serviceNo = users.getLoginName();
						id=users.getEmployee().getId();
					for(MasEmployee maseployee: masEmployee)
					{
						if(maseployee.getId()==id)
						{
							servicePersonName=	maseployee.getFirstName()+" "+maseployee.getLastName();
							serviceNo=maseployee.getServiceNo();
							System.out.println("Service no:::::::"+serviceNo);
						}
					}
						
					}
					

				}System.out.println(":::::::::::::::"+serviceNo);

				String message = "";

				String complaintEntryNo = "";
				if (map.get("complaintEntryNo") != null) {
					complaintEntryNo = (String) map.get("complaintEntryNo");
				}
			%>
<%
		if (map.get("message") != null) {
			message = (String) map.get("message");

		}
		if (!message.equalsIgnoreCase("")) {
	%>
<h2><%=message%></h2>
<%
	}
%>
<div id="contentHolder">
<h6>Complaint Register</h6>
<div class="Clear"></div>

<div class="header">
<form name="search" method="post" action="">

<div class="Clear"></div>
<label class="medium">Complaint Number</label> <input type="radio"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radio" />

<label class="medium">Complaint Desc</label> <input type="radio"
	name="<%=SELECTED_RADIO %>" value="2" class="radio" /> <input
	type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""
	MAXLENGTH="12" tabindex=1
	onkeypress="return submitenter(this,event,'work?method=searchWorkCompletion')" />
<input type="button" name="search" value="Search" class="cmnButton"
	onclick="submitForm('search','complaint?method=searchComplaintRegister')"
	tabindex=1 /></form>
<div class="Clear"></div>
</div>
<div class="Clear"></div>


<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<div class="Clear"></div>



<%
										if (searchComplaintRegisterList != null
												&& searchComplaintRegisterList.size() > 0) {
											String strForCode = (String) map.get("complaintNo");
											String strForCodeDescription = (String) map.get("complaintDesc");
											if (strForCode != null && strForCode != ""
													|| strForCodeDescription != null
													&& strForCodeDescription != "") {
									%>
<h5><a href="/hms/hms/complaint?method=showComplaintRegisterJsp">Show
All Records</a></h5>
<%
			}
			}
			if (searchComplaintRegisterList.size() == 0
					&& map.get("search") != null) {
		%>
<h5><a href="/hms/hms/complaint?method=showComplaintRegisterJsp">Show
All Records</a></h5>

<%
					}
				%> <script type="text/javascript">			
			formFields = [[0, "<%= COMMON_ID%>" ], [1,"<%= COMPLAINT_NO%>"], [2,"<%= COMPLAINT_DESC%>"], [3,"<%= COMPLAINT_TYPE %>"],[4,"<%= COMPLAINT_DATE %>"],[5,"<%= COMPLAINT_TIME %>"],[6,"<%=DEPARTMENT_NAME %>"],[7,"<%=COMPLAINT_CRITERIA %>"],[8,"<%= SERVICE_NO%>"], [9,"<%= SERVICE_PERSON %>"],[10,"<%=  BUILDING_NO %>"],[11,"<%=COMPLAINT_DETAILS%>"],[12,"<%=STATUS%>"],[13,"<%= CHANGED_BY%>"],[14,"<%= CHANGED_DATE %>"],[15,"<%= CHANGED_TIME%>"],[16,"complaintId"],[17,"<%= REMARKS%>"],[18,"<%= COMMANDENT_REMARKS%>"],[19,"<%= PDC%>"],[20,"<%=COMPLAINT_LOCATION%>"]] ;
		 statusTd = 12;
			</script></div>
<div class="Clear"></div>
<form name="complaintRegister" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasComplaintRegister">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"
	value="ComplaintDetails"> <input type="hidden" name="title"
	value="WorkCompletion"> <input type="hidden"
	name="<%=JSP_NAME %>" value="complaintRegister">

<div class="blockFrame">
<div class="Clear"></div>
<label> MES Remark</label> <input type="text" class="value"
	readonly="true" name="<%=REMARKS %>" tabindex=1 /> <label>
CADO Remark</label> <input type="text" class="value" readonly="true"
	name="<%=COMMANDENT_REMARKS %>" tabindex=1 /> <label> PDC </label> <input
	type="text" class="value" readonly="true" name="<%=PDC %>" tabindex=1 />


<div class=Clear></div>
</div>

<div class="blockTitle">Complaint Register</div>
<div class="blockTitleCurve"></div>


<div class="blockFrame">
<div class="Clear"></div>
<label><span>*</span> Complaint Number</label> <input type="text"
	class="value" readonly="true" name="<%= COMPLAINT_NO %>"
	value="<%=complaintEntryNo %>" tabindex=1 /> <label><span>*</span>
Complaint Date</label> <input type="text" readonly="true"
	name="<%= COMPLAINT_DATE %>" value="<%=date %>" id="ComplaintDate"
	tabindex=1 /> <label><span>*</span> Complaint Time</label> <input
	type="text" readonly="true" name="<%= COMPLAINT_TIME %>"
	value="<%=time %>" tabindex=1 />

<div class="clear"></div>

<label><span>*</span> Complaint Type</label> <select
	name="<%= COMPLAINT_TYPE %>" validate="Complaint Type,string,yes"
	tabindex=1>

	<option value="0">Select</option>
	<%
			for (MasComplaintsType masComplaintsType : complaintTypeList) {
		%>

	<option value=<%=masComplaintsType.getId()%>><%=masComplaintsType.getComplaintTypeName()%></option>

	<%
				}
			%>
</select> <label><span>*</span> Complaint Criteria</label> <input type="radio"
	class="radio" name="<%=COMPLAINT_CRITERIA%>" id="radio1" value="new"
	onclick="choose(this);" checked="true" tabindex=1 /> <label
	class="small">New</label> <input type="radio" class="radio"
	name="<%=COMPLAINT_CRITERIA%>" id="radio1" value="repeat"
	onclick="choose(this);" tabindex=1 /> <label class="small">Repeat</label>


<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="tableHms" style="display: none">
	<thead>
		<tr>
			<th scope="col">Old Complaint Number</th>
			<th scope="col">Old Complaint Date</th>
		</tr>
	</thead>

	<tbody>


		<tr>
			<td><input type="text" name="<%= OLD_COMPLAINT_NUMBER %>"
				value="" id="oldComplaintNo1" tabindex=1
				onchange="fillOldComplaintDetail(this,'oldComplaintDate1')" /></td>
			<td><input type="text" id="oldComplaintDate1"
				style="margin-left: 100px; width: auto; height: 20px"
				name="<%=OLD_COMPLAINT_DATE%>" value="" readonly="readonly"
				class="calDate" MAXLENGTH="30" tabindex=1
				onblur="checkComplaint(oldComplaintNo1,oldComplaintDate1);" /> <!--  	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a from date,string,yes" onClick="setdate('',document.getElementById('oldComplaintDate1'),event)"/>
		--></td>
		</tr>
		<tr>
			<td><input type="text" name="<%= OLD_COMPLAINT_NUMBER %>"
				value="" id="oldComplaintNo2" tabindex=1
				onchange="fillOldComplaintDetail(this,'oldComplaintDate2')" /></td>
			<td><input type="text" id="oldComplaintDate2"
				style="margin-left: 100px; width: auto; height: 20px"
				name="<%=OLD_COMPLAINT_DATE%>" readonly="readonly" value=""
				class="calDate" tabindex=1
				onblur="checkComplaint(oldComplaintNo2,oldComplaintDate2);" /> <!--  	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a from date,string,yes" onClick="setdate('',document.getElementById('oldComplaintDate2'),event)"/>
	--></td>
		</tr>
		<tr>
			<td><input type="text" name="<%= OLD_COMPLAINT_NUMBER %>"
				value="" id="oldComplaintNo3" tabindex=1
				onchange="fillOldComplaintDetail(this,'oldComplaintDate3')" /></td>
			<td><input type="text" id="oldComplaintDate3"
				style="margin-left: 100px; width: auto; height: 20px"
				name="<%=OLD_COMPLAINT_DATE%>" readonly="readonly" value=""
				class="calDate" tabindex=1
				onblur="checkComplaint(oldComplaintNo3,oldComplaintDate3);" /> <!--  	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a from date,string,yes" onClick="setdate('',document.getElementById('oldComplaintDate3'),event)"/>
	--></td>
		</tr>

	</tbody>
</table>
</div>
<div class="Clear"></div>


<label><span>*</span> Complaint Location</label> <select id="location"
	name="<%=COMPLAINT_LOCATION %>"
	validate="Complaint Location,string,yes" tabindex="1"
	onchange="handleRem()">
	<option value="0">Select</option>
	<option value="departmental">Non-Residential</option>
	<option value="residential">Residential</option>
</select> <label><span>*</span> Service No</label> <input type="text"
	name="<%=SERVICE_NO%>" value="<%=serviceNo %>" readonly="readonly"
	validate="Service No,string,yes" tabindex=1 /> <label><span>*</span>
Complaint Person Name</label> <input type="text" id="letters"
	name="<%= SERVICE_PERSON %>" value="<%=servicePersonName %>"
	validate="Person Name,string,yes" onkeyup="isAlphabet(this)"
	onKeyDown="limitText(this,40);" tabindex=1 />
<div class="Clear"></div>
<div id="xyz" style="display: none;"><label>Department </label> <select
	name="<%=DEPARTMENT_NAME%>" tabindex=1>

	<option value="0">Select</option>
	<%
			for (MasDepartment masdepartment : departmentList) {
		%>

	<option value=<%=masdepartment.getId()%>><%=masdepartment.getDepartmentName()%></option>

	<%
				}
			%>
</select></div>
<div id="abc" style="display: none;"><label>SMQs No </label> <select
	name="<%=BUILDING_NO%>" tabindex=1>

	<option value="0">Select</option>
	<%
			for (MasSmq masSmq : smqList) {
				System.out.println("mascomplaint.getId()   " + masSmq.getId());
		%>

	<option value=<%=masSmq.getId()%>><%=masSmq.getSmqName()%></option>

	<%
				}
			%>
</select></div>
<div class="Clear"></div>
<label><span>*</span>Complaint Details</label> <textarea cols=""
	class="large" name="<%= COMPLAINT_DETAILS %>"
	onKeyUp="limitText(this,500);" validate="Complaint Details,string,yes"
	tabindex=1></textarea>

<div class=Clear></div>
</div>
<div class=Clear></div>

<div class="division"></div>
<div id="edited"></div>
<!--Bottom labels starts-->
<div class="bottom"><input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="if(checkFilledRowNew()){submitForm('complaintRegister','complaint?method=addComplaintRegister');}"
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
<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> <label>Changed
By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
</form>
<div class="Clear"></div>

</div>


<script type="text/javascript">
		data_header = new Array();	
	
		
		data_header[0] = new Array;
		data_header[0][0] = "Complaint Number "
		data_header[0][1] = "data";
		data_header[0][2] = "25%";
		data_header[0][3] = "<%= COMPLAINT_NO %>";
		
		data_header[1] = new Array;
		data_header[1][0] = "Complaint Description"
		data_header[1][1] = "data";
		data_header[1][2] = "15%";
		data_header[1][3] = "<%= COMPLAINT_DESC %>";
		
		data_header[2] = new Array;
		data_header[2][0] = "Complaint Type"
		data_header[2][1] = "data";
		data_header[2][2] = "10%";
		data_header[2][3] = "<%= COMPLAINT_TYPE %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Complaint Date"
		data_header[3][1] = "data";
		data_header[3][2] = "30%";
		data_header[3][3] = "<%= COMPLAINT_DATE%>";
		
		data_header[4] = new Array;
		data_header[4][0] = "Complaint Time"
		data_header[4][1] = "data";
		data_header[4][2] = "40%";
		data_header[4][3] = "<%=COMPLAINT_TIME %>";
		
		data_header[5] = new Array;
		data_header[5][0] = "Complaint Department"
		data_header[5][1] = "data";
		data_header[5][2] = "10%";
		data_header[5][3] = "<%=DEPARTMENT_NAME %>";
		
			data_header[6] = new Array;
		data_header[6][0] = ""
		data_header[6][1] = "hide";
		data_header[6][2] = "0";
		data_header[6][3] = "<%=COMPLAINT_CRITERIA%>";
		
		
		
		data_header[7] = new Array;
		data_header[7][0] = "Service No."
		data_header[7][1] = "hide";
		data_header[7][2] = "10%";
		data_header[7][3] = "<%=SERVICE_NO %>";
		
		data_header[8] = new Array;
		data_header[8][0] = "Person Name"
		data_header[8][1] = "hide";
		data_header[8][2] = "10%";
		data_header[8][3] = "<%=SERVICE_PERSON %>";
		
		data_header[9] = new Array;
		data_header[9][0] = "Building No."
		data_header[9][1] = "hide";
		data_header[9][2] = "10%";
		data_header[9][3] = "<%=BUILDING_NO %>";
		
		data_header[10] = new Array;
		data_header[10][0] = "Complaint Detail"
		data_header[10][1] = "hide";
		data_header[10][2] = "10%";
		data_header[10][3] = "<%=COMPLAINT_DETAILS %>";
		
		data_header[11] = new Array;
		data_header[11][0] = "Complaint Status"
		data_header[11][1] = "data";
		data_header[11][2] = "15%";
		data_header[11][3] = "<%=STATUS %>";
		
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
		data_header[15][0] = ""
		data_header[15][1] = "hide";
		data_header[15][2] = "0";
		data_header[15][3] = "complaintId";
	
	
		
		data_header[16] = new Array;
		data_header[16][0] = ""
		data_header[16][1] = "hide";
		data_header[16][2] = "0";
		data_header[16][3] = "<%=REMARKS%>";
		
		data_header[17] = new Array;
		data_header[17][0] = ""
		data_header[17][1] = "hide";
		data_header[17][2] = "0";
		data_header[17][3] = "<%=COMMANDENT_REMARKS%>";
		
		data_header[18] = new Array;
		data_header[18][0] = ""
		data_header[18][1] = "hide";
		data_header[18][2] = "0";
		data_header[18][3] = "<%=PDC%>";
		
		data_header[19] = new Array;
		data_header[19][0] = ""
		data_header[19][1] = "hide";
		data_header[19][2] = "0";
		data_header[19][3] = "<%=COMPLAINT_LOCATION%>";
		data_arr = new Array();
		
		<%
			Iterator itr=searchComplaintRegisterList.iterator();
		    int  counter=0;
		    while(itr.hasNext())
		    {			
		         MasComplaintRegister  masComplaintRegist= (MasComplaintRegister)itr.next(); 
		%>
			<% if(masComplaintRegist != null && masComplaintRegist.getServiceNo().equalsIgnoreCase(serviceNo)){ %>
		  	
		  		data_arr[<%= counter%>] = new Array();
					data_arr[<%= counter%>][0] = <%= masComplaintRegist.getId()%>
				<%if(masComplaintRegist.getComplaintNo() != null){%>
				data_arr[<%= counter%>][1] = "<%=masComplaintRegist.getComplaintNo()%>"
				<%}else{%>
				data_arr[<%= counter%>][1] = ""
				<%}%>
				

				<%if(masComplaintRegist.getComplaintDetails() != null){%>
				data_arr[<%= counter%>][2] = "<%=masComplaintRegist.getComplaintDetails()%>"
				<%}else{%>
				data_arr[<%= counter%>][2] = ""
				<%}%>
								
			   data_arr[<%= counter%>][3] = "<%=masComplaintRegist.getComplaintType().getComplaintTypeName() %>";
			
				<%if(masComplaintRegist.getComplaintDate() != null) {%>
				data_arr[<%= counter%>][4] ="<%= HMSUtil.convertDateToStringWithoutTime(masComplaintRegist.getComplaintDate()) %>"
				<%}else{%>
				data_arr[<%= counter%>][4] = ""
				<%}%>
				data_arr[<%= counter%>][5] = "<%= masComplaintRegist.getComplaintTime()%>"
			
			<%
			if(masComplaintRegist.getDepartment() != null)
			{
			%>
				data_arr[<%= counter%>][6] = "<%=masComplaintRegist.getDepartment().getDepartmentName()%>";	
			<%}
			else{%>
				data_arr[<%= counter%>][6] = "";		
	            
			<%}
				
				if(masComplaintRegist.getComplaintCriteria() != null) {%>	
		    data_arr[<%= counter%>][7] = "<%= masComplaintRegist.getComplaintCriteria()%>"
		    <%}else{%>
		    data_arr[<%= counter%>][7] = ""
		    <%}%>
		    
		    <%if(masComplaintRegist.getServiceNo() != null) {%>
			data_arr[<%= counter%>][8] = "<%= masComplaintRegist.getServiceNo()%>"
			<%}else{%>	
			data_arr[<%= counter%>][8] = ""
			<%}%>
			<%if(masComplaintRegist.getServicePersonName() != null){%>
			data_arr[<%= counter%>][9] = "<%= masComplaintRegist.getServicePersonName()%>"
			<%}else{%>
			data_arr[<%= counter%>][9] = ""
			<%}%>
			<%
			
		Iterator itrGridSmqList=gridSmqList.iterator();
		while(itrGridSmqList.hasNext())
		{
			MasSmq smqGrid = (MasSmq)itrGridSmqList.next();
			if(masComplaintRegist.getId().equals(smqGrid.getId()) && smqGrid.getStatus().equals("y")){%>
			data_arr[<%= counter%>][10] = "<%=smqGrid.getSmqName()%>";
			<%}else if(masComplaintRegist.getId().equals(smqGrid.getId()) && smqGrid.getStatus().equals("n")){%>
			data_arr[<%= counter%>][10] = "<font id='error'>*</font>Parent InActivated--<%=smqGrid.getId()%> <%= smqGrid.getSmqName()%>";
			<%}
		}
		
		%>
		<%if(masComplaintRegist.getStatus() != null && masComplaintRegist.getStatus().equalsIgnoreCase("p") ){%>
				data_arr[<%= counter%>][11] = "Pending"
				<%}else if(masComplaintRegist.getStatus() != null && masComplaintRegist.getStatus().equalsIgnoreCase("c")){%>
				data_arr[<%= counter%>][11] = "Completed"
				<%}%>
			<%if(masComplaintRegist.getLstChangedBy() != null){%>
		    data_arr[<%= counter%>][13] = "<%= masComplaintRegist.getLstChangedBy()%>"
		    <%}else{%>
		    data_arr[<%= counter%>][13] = ""
		    <%}%>
		    
		    <%if(masComplaintRegist.getLstChangedDate() != null){%>
			data_arr[<%= counter%>][14] = "<%= HMSUtil.convertDateToStringWithoutTime(masComplaintRegist.getLstChangedDate())%>"
			<%}else{%>
			data_arr[<%= counter%>][14] = ""
			<%}%>
			
			<%if(masComplaintRegist.getLstChangedTime() != null){%>
			data_arr[<%= counter%>][15] = "<%= masComplaintRegist.getLstChangedTime()%>"
			<%}else{%>
			data_arr[<%= counter%>][15] = ""
			<%}%>
			
			<%if(masComplaintRegist.getMesRemark() != null){%>
			data_arr[<%= counter%>][17] = "<%= masComplaintRegist.getMesRemark()%>"
			<%}else{%>
			data_arr[<%= counter%>][17] = ""
			<%}%>
			
			<%if(masComplaintRegist.getCadoRemark() != null){%>
			data_arr[<%= counter%>][18] = "<%= masComplaintRegist.getCadoRemark()%>"
			<%}else{%>
			data_arr[<%= counter%>][18] = ""
			<%}%>
			
			<%if(masComplaintRegist.getPdc() != null){%>
			data_arr[<%= counter%>][19] = "<%=HMSUtil.convertDateToStringWithoutTime(masComplaintRegist.getPdc())%>"
			<%}else{%>
			data_arr[<%= counter%>][19] = ""
			<%}%>
		
		<% if(masComplaintRegist.getStatus().equals("p")){ %>
						data_arr[<%= counter%>][12] = "Pending"
				<%}else if(masComplaintRegist.getStatus().equals("r")){%>
						data_arr[<%= counter%>][12] = "Pending"
						data_arr[<%= counter%>][16] = "red"
				<%}else{%>
					  data_arr[<%= counter%>][12] = "Completed"
					  <%
				}
		%>
		 data_arr[<%= counter%>][20] = "<%=masComplaintRegist.getComplaintLocation() %>";
		
			<%	     counter++;
			}
		    }
		%>	
		 formName = "complaintRegister"
		nonEditable = ['<%=COMMON_ID%>'];
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
		</script>

<script>
function check(){
	var complaintDate = document.getElementById("ComplaintDate").value;
	var completionDate = document.getElementById("CompletionDate").value;
	


	var	completionDate1 = new Date("CompletionDate");
	var complaintDate1 =new Date("ComplaintDate");

	if( completionDate1 < complaintDate1 )
	{
		alert("Please ensure that the Completion Date is greater than Complaint Date.");
		// document.calldate.next_day.focus();
		return false;
	}
}
</script>
