<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.MasIcdSubCategory"%>
<%@page import="java.util.Iterator"%>
<%--For AutoComplete Through Ajax--%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%><script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
</script>
<script type="text/javascript" language="javascript">
	<%Calendar calendar = Calendar.getInstance();
			String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
			String date = String.valueOf(calendar.get(Calendar.DATE));
			int year = calendar.get(calendar.YEAR);
			if (month.length() < 2) {
				month = "0" + month;
			}
			if (date.length() < 2) {
				date = "0" + date;
			}%>
		serverdate = '<%=date + "/" + month + "/" + year%>'
	</script>

<%
	
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	List<Object> icdList = new ArrayList<Object>();
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	int summary = 0;
	if (map.get("summary") != null) {
		summary = (Integer) map.get("summary");
	}
	if(summary==1){
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Disposition",
				"attachment;filename=\"disease_Wise_Patient_Summary.xls\"");
	}else if(summary==2){
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Disposition",
				"attachment;filename=\"disease_Wise_Patient_Detail.xls\"");
	}
	
	List<Object> patientList = new ArrayList<Object>();
	//List<MasIcd> icdList=new ArrayList<MasIcd>();
	if (map.get("patientList") != null) {
		patientList = (List) map.get("patientList");
	}
	if (map.get("icdList") != null) {
		icdList = (List) map.get("icdList");
	}
	
%> 
<form name="diseaseWisePatientDetails" method="post" >

<table border="1">
	<%
	int total=0;
	if(summary==1){
	if (patientList.size() > 0) {
			total=patientList.size();
			
	%>
	<tr>
		<th width="10%">Sr No.</th>
		<th width="45%">Patient Name</th>
		<th width="45%">ICD Name</th>
	</tr>
	<%
		int headerCount=0;	
	if (icdList.size() > 0) {
		for (Iterator iterator = icdList.iterator(); iterator
		.hasNext();) {
			Object[] objectIcd = (Object[]) iterator.next();
			int icdId=0;
			String icdName="";
			icdId=(Integer)objectIcd[0];
			icdName=(String)objectIcd[1];
				int header=0;
				int count = 0;
					for (Iterator iterator1 = patientList.iterator(); iterator1
							.hasNext();) {
						Object[] object = (Object[]) iterator1.next();
						int icdIdCh=0;
						icdIdCh=(Integer)object[0];			
						if (icdId==icdIdCh) {
							
						
							//patient = (Patient) object[2];

							String patientName = "";
							
							if (object[3] != null) {
								patientName = (String)object[3];
							}
							if (object[4] != null) {
								patientName =patientName+' '+(String)object[4];
							}
							if (object[5] != null) {
								patientName =patientName+' '+(String)object[5];
							}
						
							if(header==0){
								++header;
								++headerCount;
								++count;
								%>
								<tr>
									<td colspan="3" align="left"><strong><%=headerCount%>)   Disease Name --> <%=icdName%></strong></td>
								</tr>
								<tr>
									<td width="10%"><%=headerCount%>.<%=count%></td>
									<td width="45%"><%=patientName%></td>
									<td width="45%"><%=icdName%></td>
								</tr>
								<%	
							}else{
								++header;	
								++count;
								%>
								<tr>
									<td width="10%"><%=headerCount%>.<%=count%></td>
									<td width="45%"><%=patientName%></td>
									<td width="45%"><%=icdName%></td>
								</tr>
								<%
							}
							
					
		}
					}
				}
			}
		}
	}else if(summary==2){
		if (icdList.size() > 0) {
			total=icdList.size();
			
	%>
	<tr>
		<th width="10%">Sr No.</th>
		<th width="45%">Disease Name</th>
		<th width="45%">Total Patient</th>
	</tr>
	<%
			
	if (icdList.size() > 0) {
		int count = 0;
		for (Iterator iterator = icdList.iterator(); iterator
		.hasNext();) {
			Object[] objectIcd = (Object[]) iterator.next();
			long totalPatient=0;
			String icdName="";
			int icdIdtemp=0;
			totalPatient=(Long)objectIcd[0];
			icdName=(String)objectIcd[1];
			icdIdtemp=(Integer)objectIcd[2];
				++count;
				%>
				<tr>
					<td width="10%"><%=count%></td>
					<td width="45%"><%=icdName%></td>
					<td width="45%"><%=totalPatient%></td>
				</tr>
				<%
				}
			}
		}
	}
	%>
</table>
</form>