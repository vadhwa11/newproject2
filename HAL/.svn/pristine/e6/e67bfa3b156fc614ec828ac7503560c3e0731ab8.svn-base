<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientVisitSearch.jsp
	 * Tables Used         :
	 * Description         :
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By:
	 * @version 1.0

--%>


<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script>
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



<form name="patientVisitSearch" action="" method="post">

<script type="text/javascript">
function enableAppDate(checkObj){
	if(checkObj.checked){
		document.getElementById('appDateId').disabled = false;
		document.getElementById('calId').style.display = 'inline';
	}else{
		document.getElementById('appDateId').disabled = true;
		document.getElementById('calId').style.display = 'none';
	}

}

function checkAppointmentDate(){
	var appDateStr = document.getElementById('appDateId').value;
	var appDate = new Date(appDateStr.substring(6),(appDateStr.substring(3,5) - 1) ,appDateStr.substring(0,2));
	var currentDate = new Date();
	var month = currentDate.getMonth() + 1
 	var day = currentDate.getDate()
 	var year = currentDate.getFullYear()
 	var seperator = "/"
 	currentDate = new Date(month + seperator + day + seperator + year);
	if(appDate < currentDate){
		alert("Appointment Date Should  be greater than or equal to current date ");
		return false;
	}
	return true;
}

</script>

	<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<Patient> patientList = new ArrayList<Patient>();

		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("serviceTypeList") != null){
			serviceTypeList= (List<MasServiceType>)map.get("serviceTypeList");
		}
		if(map.get("rankList") != null){
			rankList= (List<MasRank>)map.get("rankList");
		}
		if(map.get("unitList") != null){
			unitList= (List<MasUnit>)map.get("unitList");
		}
		if(patientMap.get("patientList") != null){
			patientList= (List<Patient>)patientMap.get("patientList");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
	%>



	<div class="titleBg"><h2>Patient Search (Re-Visit)</h2></div>
	<div class="clear"></div>
	<div class="Block">
			<label>Hin</label>
			<input type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="50" />

			<label>Patient First Name</label>
			<input type="text" name="<%=P_FIRST_NAME %>"  value=""  MAXLENGTH="15" />

			<label>Patient Mid Name</label>
			<input type="text" name="<%=P_MIDDLE_NAME %>"  value=""  MAXLENGTH="15" />
			<div class="clear"></div>

			<label>Patient Last Name</label>
			<input type="text" name="<%=P_LAST_NAME%>"  value="" MAXLENGTH="15" />
			<label>Service No.</label>
			<input type="text" name="<%=SERVICE_NO %>" value=""  MAXLENGTH="20" />
			<label>Ser. First Name</label>
			<input type="text" name="<%=S_FIRST_NAME %>"  value=""  MAXLENGTH="15" />

			<div class="clear"></div>

			<label>Ser. Mid Name</label>
			<input type="text" name="<%=S_MIDDLE_NAME %>"  value="" MAXLENGTH="15" />

			<label>Ser. Last Name</label>
			<input type="text" name="<%=S_LAST_NAME%>"  value="" MAXLENGTH="15" />

			<label>Service Type</label>
			<select name="<%=SERVICE_TYPE_ID %>" class="NewSelectBox">
			<option value="0">Select Ser Type</option>
			<%
			for(MasServiceType masServiceType : serviceTypeList)
			{
			%>
			<option value="<%=masServiceType.getId()%>" ><%=masServiceType.getServiceTypeName()%></option>
			<%
			}
			%>
			</select>
			<div class="clear"></div>
			<label>Rank</label>
			<select name="<%=RANK_ID %>" >
			<option value="0">Select Rank</option>
			<% for(MasRank masRank : rankList)
			{
			%>
			<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
			<%
			}
			%>
			</select>

	 		<label>Unit</label>
			<select name="<%=UNIT_ID %>">
				<option value="0">Select Unit</option>
				<%

				for(MasUnit masUnit : unitList)
								{
									if(masUnit.getUnitName()!=null)
									{
								%>
								<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
								<%
									}else{%>
										<option value=""></option>
									<%}
								}
				%>
			</select>
			
			<input type="hidden" name="<%=APPOINTMENT_DATE %>" id="appDateId"
					value="<%=currentDate %>" class="calDate" readonly="readonly"
					 validate="Appointment Date,date,no"  MAXLENGTH="30"
					 />
		    <div id="calId" style="display: none;">
		    <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
		    		validate="Pick a date"
		    		onClick="setdate('<%=currentDate %>',document.patientVisitSearch.<%=APPOINTMENT_DATE%>,event)"/>
		    </div>

		    <div class="Clear"></div>

			
<div class="clear"></div>
	</div>

	</form>
<div class="clear"></div>
<input type="button" name="Submit" id="addbutton" onclick="submitForm('patientVisitSearch','/hms/hms/registration?method=showVisitDetails','checkAppointmentDate');"  value="Search" class="button" accesskey="a" />
<div class="clear"></div>

	<jsp:include page="searchResultBlock.jsp" />
	<div class="clear"></div>
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
	<form name="patientVisit" method="post" action="">
	<script type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"], [1,"servNo"], [2,"hin"], [3,"patName"], [4,"serviceType"], [5,"sPersonName"], [6,"rank"], [7,"unit"], [8,"add"]];
	 statusTd = 8;
</script>
		</form>
		<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</div>

	<script type="text/javascript" language="javascript">

	data_header = new Array();


	data_header[0] = new Array;
	data_header[0][0] = "Service No"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "servNo"

	data_header[1] = new Array;
	data_header[1][0] = "Hin"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "hin";

	data_header[2] = new Array;
	data_header[2][0] = "Patient Name"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "patName";

	data_header[3] = new Array;
	data_header[3][0] = "Service Type"
	data_header[3][1] = "data";
	data_header[3][2] = "10%";
	data_header[3][3] = "serviceType"

	data_header[4] = new Array;
	data_header[4][0] = "Service Person Name"
	data_header[4][1] = "data";
	data_header[4][2] = "15%";
	data_header[4][3] = "sPersonName";

	data_header[5] = new Array;
	data_header[5][0] = "Rank"
	data_header[5][1] = "data";
	data_header[5][2] = "10%";
	data_header[5][3] = "rank";

	data_header[6] = new Array;
	data_header[6][0] = "Unit"
	data_header[6][1] = "data";
	data_header[6][2] = "10%";
	data_header[6][3] = "unit"

	data_header[7] = new Array;
	data_header[7][0] = "Address"
	data_header[7][1] = "hide";
	data_header[7][2] = "30%";
	data_header[7][3] = "add";


	data_arr = new Array();
	<%

	    int  counter=0;
		if (patientList != null && patientList.size() > 0) { %>

	<% 	for(Patient patient : patientList){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= patient.getId()%>
			data_arr[<%= counter%>][1] = "<%=patient.getServiceNo()%>"
			data_arr[<%= counter%>][2] = "<%=patient.getHinNo()%>"
			<%
					String middleName = "";
					String lastName = "";
					if(patient.getPMiddleName() != null){
						middleName = patient.getPMiddleName();
					}
					if(patient.getPLastName() != null){
						lastName = patient.getPLastName();
					}

					%>
			data_arr[<%= counter%>][3] = "<%=patient.getPFirstName()%> <%=middleName%> <%=lastName%>"
			data_arr[<%= counter%>][4] = "<%=patient.getServiceType().getServiceTypeName()%> "
			<%
			if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){

				String sMiddleName = "";
				String sLastName = "";
				if(patient.getSMiddleName() != null){
					sMiddleName = patient.getSMiddleName();
				}
				if(patient.getSLastName() != null){
					sLastName = patient.getSLastName();
				}
				String sName = patient.getSFirstName()+" "+sMiddleName+" "+sLastName;
			%>
				data_arr[<%= counter%>][5] = "<%=sName%>"
				<%}else{%>
				data_arr[<%= counter%>][5] = ""
				<%}
				if(patient.getRank() != null){
				%>
				data_arr[<%= counter%>][6] = "<%=patient.getRank().getRankName()%> "
				<%}else{%>
				data_arr[<%= counter%>][6] = ""
				<%}
				if(patient.getUnit() != null && patient.getUnit().getUnitName()!=null){
					
				%>
				data_arr[<%= counter%>][7] = "<%=patient.getUnit().getUnitName()%> "
				<%}else{%>
				data_arr[<%= counter%>][7] = ""
				<%}%>
				<%
		if(patient.getAddress()!= null){
		%>
			data_arr[<%= counter%>][8] = ""
	<%	}else{%>
			data_arr[<%= counter%>][8] = ""
		<%
				}
				     counter++;
		    	}
			}
		%>

    formName = "patientVisit"

	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;

	}

	makeTable(start,end);


	</script>
