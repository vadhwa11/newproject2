
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.AviCa34"%>
<%@page import="jkt.hms.masters.business.MasCaLicence"%><script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
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
<form name="appointmentForMedExam" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<AviCa34> medExamWaitingList = new ArrayList<AviCa34>();
		List<MasCaLicence> masCaLicenceList = new ArrayList<MasCaLicence>();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("detailsMap") !=null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}
		if(patientMap.get("medExamWaitingList") != null){
			medExamWaitingList= (List<AviCa34>)patientMap.get("medExamWaitingList");
		}
		if(map.get("masCaLicenceList") != null){
			masCaLicenceList= (List<MasCaLicence>)map.get("masCaLicenceList");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		Map<String, Object> dtmap = new HashMap<String, Object>();
		String message = "";
		if(map.get("message")!= null){
			message = (String)map.get("message");
		}
		Box box = HMSUtil.getBox(request);
	%> 

<h4><%=message %></h4>
<div class="Clear"></div>
<div class="titleBg">
<h2>Appointment For Med Exam</h2></div>
<div class="Clear"></div>

<div class="Block">

<label>From Date<span>*</span> </label>
<input type="text" name="fromAppDate" value="<%=currentDate %>" MAXLENGTH="20" class="date"	id="fromAppDate" validate="From Date,string,yes" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.appointmentForMedExam.fromAppDate,event)" /> 
<label>To Date <span>*</span></label>
<input type="text" name="toAppDate" value="<%=currentDate %>" MAXLENGTH="20" class="date"	id="toAppDate" validate="To Date,string,yes" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.appointmentForMedExam.toAppDate,event)" />
	 
	 <div class="Clear"></div>
<label>Licence Type  </label> 

<select id="<%=TYPE_OF_LICENCE %>" name="<%=TYPE_OF_LICENCE %>" validate="Licence Type ,metachar,no">
		<option value="0">Select</option>
		        <%
         		if(masCaLicenceList != null){ 	
         			for (Iterator iter = masCaLicenceList.iterator(); iter.hasNext();) {
         				MasCaLicence masCaLicence = (MasCaLicence) iter.next();
		         %>
				<option value="<%=masCaLicence.getId() %>"><%=masCaLicence.getCaLicenceName() %></option>           
		        <%		
	        			}
	        		 } 
		        %>
			      </select>
<%---
<label>Exam Due Date  </label> 
<input	type="text" readonly="readonly" value="" name="<%=EXAMINATION_DATE%>"	tabindex="2" maxlength="20" /> --%>
</div>
<div class="Clear"></div>
<div class="clear paddingTop15"></div>
<input type="hidden" name="search" 	onclick="searchTable();"	value="Search" class="button"/>
<input type="button" name="search" 	
onclick="if(validateFromToDate())submitProtoAjaxWithDivName('appointmentForMedExam','/hms/hms/aviationMedicine?method=searchMedExamWaitningList','searchTableDiv');" value="Search" class="button"/>
 
<input type="reset" name="Reset" value="Reset" class="button" tabindex="1" accesskey="r" />
<div class="Clear"></div>
<div class="clear paddingTop15"></div>
<div id="searchTableDiv"  >


</div>
</form>

<script type="text/javascript">
function searchTable(){

	  	document.getElementById("searchTableDiv").style.display='inline';
}

</script>
<script>
 function chekedAppointvalue(inc){
	if(document.getElementById('checkedAppoint'+inc).checked == true){
		document.getElementById('checkedAppointvalue'+inc).value='y'
	}else if(document.getElementById('checkedAppoint'+inc).checked == false){
		document.getElementById('checkedAppointvalue'+inc).value=''
	}
 }
 function validateFromToDate(){
		
		var nowDate=new Date();
		
		obj1 = eval(document.appointmentForMedExam.fromAppDate)
		obj2 = eval(document.appointmentForMedExam.toAppDate)
			
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