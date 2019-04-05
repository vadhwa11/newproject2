<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.MasIcdSubCategory"%>
<%@page import="java.util.Iterator"%>
<%--For AutoComplete Through Ajax--%>

<%@page import="java.math.BigDecimal"%><link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
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
	List<Object> patientList = new ArrayList<Object>();
	//List<MasIcd> icdList=new ArrayList<MasIcd>();
	if (map.get("patientList") != null) {
		patientList = (List) map.get("patientList");
	}
	if (map.get("icdList") != null) {
		icdList = (List) map.get("icdList");
	}
	//Set<MasIcd> icdSet = new HashSet<MasIcd>();
	//icdSet.addAll(icdList);
	String icdName1 = "";
	String icdName2 = "";
	String toDate = "";
	String fromDate = "";
	int summary = 0;
	if (map.get("icdName1") != null) {
		icdName1 = (String) map.get("icdName1");
	}
	if (map.get("icdName2") != null) {
		icdName2 = (String) map.get("icdName2");
	}
	if (map.get("toDate") != null) {
		toDate = (String) map.get("toDate");
	}
	if (map.get("fromDate") != null) {
		fromDate = (String) map.get("fromDate");
	}
	if (map.get("summary") != null) {
		summary = (Integer) map.get("summary");
	}
%> 
 <div class="titleBg">
<h2>Summary</h2>
</div> 
<div class="clear"></div>
<form name="diseaseWisePatientDetails" method="post" >
<div id="patientDetails1"></div>
<div class="Block">
<input type="hidden" name="icdName1" id="icdName1" value="<%=icdName1%>" />
<input type="hidden" name="icdName2" id="icdName2" value="<%=icdName2%>" />
<input	type="hidden" name="<%=FROM_DATE%>" value="<%=fromDate%>"/>
<input	type="hidden" name="<%=TO_DATE%>" value="<%=toDate%>"/>
<input	type="hidden" name="summary" id="summary" value="<%=summary%>"/>
<input	type="hidden" name="icdNameForSearch" id="icdNameForSearch" value=""/>

<table>
	<%
	int total=0;
	System.out.println("summary-jsp-"+summary);
	if(summary==1){
	if (patientList.size() > 0) {
			total=patientList.size();
			
	%>
	<tr>
	<td colspan="3">
	<input type="button" name="Submit" value="Export Into Excel" class="buttonBig" onclick="submitForm('diseaseWisePatientDetails','/hms/hms/opd?method=exportDiseaseWisePatient')" />
	&nbsp;&nbsp;&nbsp;&nbsp;<b> Total Patient &nbsp;&nbsp;<%=total %></b>
	</td>
	</tr>
	<tr>
		<th width="10%">Sr No.</th>
		<th width="45%">Patient Name</th>
		<th width="45%">ICD Name</th>
	</tr>
	<%
	//icdList=hbt.find("select icd.Id,icd.IcdName from jkt.hms.masters.business.DischargeIcdCode  as dic join dic.Icd as icd join dic.Hin as hin join hin.Hospital as hosp join dic.Visit as visit where hosp.Id="+hospitalId +" and dic.AddEditDate between '"+sdf.format(HMSUtil.convertStringTypeDateToDateType(fromDate))+"' and  '"+sdf.format(HMSUtil.convertStringTypeDateToDateType(toDate))+"'  "+sql+" group by icd.Id,icd.IcdName order by icd.IcdName");
	//patientList=hbt.find("select icd.Id,icd.IcdName,hin.Id,hin.PFirstName,hin.PMiddleName,hin.PLastName from jkt.hms.masters.business.DischargeIcdCode  as dic join dic.Icd as icd join dic.Hin as hin join hin.Hospital as hosp join dic.Visit as visit where hosp.Id="+hospitalId +" and dic.AddEditDate between '"+sdf.format(HMSUtil.convertStringTypeDateToDateType(fromDate))+"' and  '"+sdf.format(HMSUtil.convertStringTypeDateToDateType(toDate))+"'  "+sql+"  group by icd.Id,icd.IcdName,icd.Id,icd.IcdName,hin.Id,hin.PFirstName,hin.PMiddleName,hin.PLastName order by icd.Id");
			
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
	%>
	<input type="button" name="Submit" value="Export Into Excel" class="buttonBig" onclick="submitForm('diseaseWisePatientDetails','/hms/hms/opd?method=exportDiseaseWisePatient')" />
	&nbsp;&nbsp;&nbsp;&nbsp;<b> Total Patient&nbsp;&nbsp; <%=total %></b>
	<%
		}
	}else if(summary==3){
		if (patientList.size() > 0) {
			total=patientList.size();
			
	%>
	<tr>
		<th width="10%">Sr No.</th>
		<th width="45%">Patient Name</th>
		<th width="45%">ICD Name</th>
	</tr>
	<%
	//icdList=hbt.find("select icd.Id,icd.IcdName from jkt.hms.masters.business.DischargeIcdCode  as dic join dic.Icd as icd join dic.Hin as hin join hin.Hospital as hosp join dic.Visit as visit where hosp.Id="+hospitalId +" and dic.AddEditDate between '"+sdf.format(HMSUtil.convertStringTypeDateToDateType(fromDate))+"' and  '"+sdf.format(HMSUtil.convertStringTypeDateToDateType(toDate))+"'  "+sql+" group by icd.Id,icd.IcdName order by icd.IcdName");
	//patientList=hbt.find("select icd.Id,icd.IcdName,hin.Id,hin.PFirstName,hin.PMiddleName,hin.PLastName from jkt.hms.masters.business.DischargeIcdCode  as dic join dic.Icd as icd join dic.Hin as hin join hin.Hospital as hosp join dic.Visit as visit where hosp.Id="+hospitalId +" and dic.AddEditDate between '"+sdf.format(HMSUtil.convertStringTypeDateToDateType(fromDate))+"' and  '"+sdf.format(HMSUtil.convertStringTypeDateToDateType(toDate))+"'  "+sql+"  group by icd.Id,icd.IcdName,icd.Id,icd.IcdName,hin.Id,hin.PFirstName,hin.PMiddleName,hin.PLastName order by icd.Id");
			
		int count=0;	
		for (Iterator iterator1 = patientList.iterator(); iterator1
		.hasNext();) {
			++count;
	Object[] object = (Object[]) iterator1.next();
	int icdIdCh=0;
	icdIdCh=(Integer)object[0];			
		
	
		//patient = (Patient) object[2];

		String patientName = "";
		String icdName="";
		if (object[1] != null) {
			icdName = (String)object[1];
		}
		if (object[3] != null) {
			patientName = (String)object[3];
		}
		if (object[4] != null) {
			patientName =patientName+' '+(String)object[4];
		}
		if (object[5] != null) {
			patientName =patientName+' '+(String)object[5];
		}
	
		%>
		<tr>
			<td width="10%"><%=count%></td>
			<td width="45%"><%=patientName%></td>
			<td width="45%"><%=icdName%></td>
		</tr>
		<%	

}

		}
		
	}else if(summary==2){
		if (icdList.size() > 0) {
			total=icdList.size();
			
	%>
	<tr>
	<td colspan="3">
	<input type="button" name="Submit" value="Export Into Excel" class="buttonBig" onclick="submitForm('diseaseWisePatientDetails','/hms/hms/opd?method=exportDiseaseWisePatient')" />
	&nbsp;&nbsp;&nbsp;&nbsp;<b> Total Disease &nbsp;&nbsp;<%=total %></b>
	</td>
	</tr>
	<tr>
		<th width="10%">Sr No.</th>
		<th width="45%">Disease Name</th>
		<th width="45%">Total Patient</th>
	</tr>
	<%
	//icdList=hbt.find("select icd.Id,icd.IcdName from jkt.hms.masters.business.DischargeIcdCode  as dic join dic.Icd as icd join dic.Hin as hin join hin.Hospital as hosp join dic.Visit as visit where hosp.Id="+hospitalId +" and dic.AddEditDate between '"+sdf.format(HMSUtil.convertStringTypeDateToDateType(fromDate))+"' and  '"+sdf.format(HMSUtil.convertStringTypeDateToDateType(toDate))+"'  "+sql+" group by icd.Id,icd.IcdName order by icd.IcdName");
	//patientList=hbt.find("select icd.Id,icd.IcdName,hin.Id,hin.PFirstName,hin.PMiddleName,hin.PLastName from jkt.hms.masters.business.DischargeIcdCode  as dic join dic.Icd as icd join dic.Hin as hin join hin.Hospital as hosp join dic.Visit as visit where hosp.Id="+hospitalId +" and dic.AddEditDate between '"+sdf.format(HMSUtil.convertStringTypeDateToDateType(fromDate))+"' and  '"+sdf.format(HMSUtil.convertStringTypeDateToDateType(toDate))+"'  "+sql+"  group by icd.Id,icd.IcdName,icd.Id,icd.IcdName,hin.Id,hin.PFirstName,hin.PMiddleName,hin.PLastName order by icd.Id");
			
	if (icdList.size() > 0) {
		int count = 0;
		for (Iterator iterator = icdList.iterator(); iterator
		.hasNext();) {
			Object[] objectIcd = (Object[]) iterator.next();
			BigDecimal totalPatient=new BigDecimal(0);
			BigDecimal icdIdtemp=new BigDecimal(0);
			String icdName="";
			//int icdIdtemp=0;
			totalPatient=(BigDecimal)objectIcd[0];
			icdName=(String)objectIcd[1];
			icdIdtemp=(BigDecimal)objectIcd[2];
				++count;
				%>
				<tr>
					<td width="10%"><%=count%></td>
					<td width="45%"><a href="javascript:getDeseaseDetails('<%=icdIdtemp%>','<%=icdName1 %>','<%=icdName2 %>','<%=fromDate %>','<%=toDate %>')" ><%=icdName%></a></td>
					<td width="45%"><%=totalPatient%></td>
				</tr>
				<%
				}
			}
	%>
	<input type="button" name="Submit" value="Export Into Excel" class="buttonBig" onclick="submitForm('diseaseWisePatientDetails','/hms/hms/opd?method=exportDiseaseWisePatient')" />
	&nbsp;&nbsp;&nbsp;&nbsp;<b> Total Disease&nbsp;&nbsp; <%=total %></b>
	<%
		}
	}
	%>
</table>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<script type="text/javascript">
</script>

</form>
