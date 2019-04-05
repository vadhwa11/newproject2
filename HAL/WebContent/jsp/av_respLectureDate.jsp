<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.AviAircrewMedicalLectures"%>
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
<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<AviAircrewMedicalLectures> medLectureList = new ArrayList<AviAircrewMedicalLectures>();
	if(map.get("medLectureList") != null){
		medLectureList=(List)map.get("medLectureList");
		}
		
		%>
		
<label>Lecture</label>
<select name="<%=MO_NAME %>"  id="<%=MO_NAME %>" class="small">
<option value="0">Select</option>
	<%
for(AviAircrewMedicalLectures medLectureObj : medLectureList){
%>
	<option value="<%=medLectureObj.getAircrewDate() %>"><%=HMSUtil.changeDateToddMMyyyy(medLectureObj.getAircrewDate()) %></option>
	<%	}%>
</select>