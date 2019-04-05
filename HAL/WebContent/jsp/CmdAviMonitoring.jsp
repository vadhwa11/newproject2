<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>

<%
Map<String, Object> map = new HashMap<String, Object>();
List<Object[]> monitoringDetails = new ArrayList<Object[]>();

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("monitoringDetails") != null){
	monitoringDetails= (List<Object[]>)map.get("monitoringDetails");
}
List<MasHospital> hospitalList = new ArrayList<MasHospital>();
if(map.get("hospitalList") != null){
	hospitalList= (List<MasHospital>)map.get("hospitalList");
}
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String command="";
if(map.get("command") != null){
	command=(String)map.get("command");

}
int cmdId=0;
	if(map.get("commandId") != null){
		cmdId=(Integer)map.get("commandId");

	}

String yfDate="";
if(map.get("yfDate") != null){
	yfDate=(String)map.get("yfDate");

	}
String ytDate="";
if(map.get("ytDate") != null){
	ytDate=(String)map.get("ytDate");

	}

String jfDate="";
if(map.get("jfDate") != null){
	jfDate=(String)map.get("jfDate");

	}
String jtDate="";
if(map.get("jtDate") != null){
	jtDate=(String)map.get("jtDate");

	}

String ffDate="";
if(map.get("ffDate") != null){
	ffDate=(String)map.get("ffDate");

	}
String ftDate="";
if(map.get("ftDate") != null){
	ftDate=(String)map.get("ftDate");

	}


String mfDate="";
if(map.get("mfDate") != null){
	mfDate=(String)map.get("mfDate");

	}
String mtDate="";
if(map.get("mtDate") != null){
	mtDate=(String)map.get("mtDate");

	}


String afDate="";
if(map.get("afDate") != null){
	afDate=(String)map.get("afDate");

	}
String atDate="";
if(map.get("atDate") != null){
	atDate=(String)map.get("atDate");

	}

String mafDate="";
if(map.get("mafDate") != null){
	mafDate=(String)map.get("mafDate");

	}
String matDate="";
if(map.get("matDate") != null){
	matDate=(String)map.get("matDate");

	}

String jufDate="";
if(map.get("jufDate") != null){
	jufDate=(String)map.get("jufDate");

	}
String jutDate="";
if(map.get("jutDate") != null){
	jutDate=(String)map.get("jutDate");

	}

String jyfDate="";
if(map.get("jyfDate") != null){
	jyfDate=(String)map.get("jyfDate");

	}
String jytDate="";
if(map.get("jytDate") != null){
	jytDate=(String)map.get("jytDate");

	}

String aufDate="";
if(map.get("aufDate") != null){
	aufDate=(String)map.get("aufDate");

	}
String autDate="";
if(map.get("autDate") != null){
	autDate=(String)map.get("autDate");

	}
String sfDate="";
	if(map.get("sfDate") != null){
		sfDate=(String)map.get("sfDate");

		}
	String stDate="";
	if(map.get("stDate") != null){
		stDate=(String)map.get("stDate");

		}
	String ofDate="";
	if(map.get("ofDate") != null){
		ofDate=(String)map.get("ofDate");

		}
	String otDate="";
	if(map.get("otDate") != null){
		otDate=(String)map.get("otDate");

		}
	String nfDate="";
	if(map.get("nfDate") != null){
		nfDate=(String)map.get("nfDate");

		}
	String ntDate="";
	if(map.get("ntDate") != null){
		ntDate=(String)map.get("ntDate");

		}
	String dfDate="";
	if(map.get("dfDate") != null){
		dfDate=(String)map.get("dfDate");

		}
	String dtDate="";
	if(map.get("dtDate") != null){
		dtDate=(String)map.get("dtDate");

		}

%>
<form name="AviationMonitoring" method="post" >

<div class="titleBg">
<h2>Aviation Medicine</h2>
</div>


<div class="cmntable">

<table border="">
<tr>
<th colspan="2">Aviation Medicine</th>
<th>Today's</th>
<th>YTD</th>
<th>JAN</th>
<th>FEB</th>
<th>MAR</th>
<th>APR</th>
<th>MAY</th>
<th>JUN</th>
<th>JUL</th>
<th>AUG</th>
<th>SEP</th>
<th>OCT</th>
<th>NOV</th>
<th>DEC</th>
</tr>
<tr>
<th rowspan="<%=hospitalList.size() %>" class="module">Med Lecture </th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[17].equals("MedLecture")){
				int hospitalId = 0;
				if(hospitalList.size() >0 ){
					for(MasHospital hospital: hospitalList){
						if(monDetails[1].equals(hospital.getHospitalName())){
							hospitalId = hospital.getId();
							break;
						}
					}
				}
	%>
<th class="hosName" onclick="submitForm('AviationMonitoring','/hms/hms/monitoring?method=showSmcAviationJsp&commandId=<%=cmdId %>&command=<%=command%>&hospitalId=<%=hospitalId %>&hospital=<%=monDetails[1]%>')"><h4><%=monDetails[1] %></h4></th>
<td><a href="#" onclick="javascript:openPopupMedLecture(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[2] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMedLecture(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[3] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMedLecture(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[4] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMedLecture(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[5] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMedLecture(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[6] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMedLecture(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[7] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMedLecture(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[8] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMedLecture(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[9] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMedLecture(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[10] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMedLecture(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[11] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMedLecture(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[12] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMedLecture(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[13] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMedLecture(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[14] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMedLecture(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[15] %></u></a></td>
</tr>
	<%}
			}%>

<tr>
<th rowspan="<%=hospitalList.size() %>">Pre Flight Med Checkup</th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[17].equals("PreFlight")){
				int hospitalId = 0;
				if(hospitalList.size() >0 ){
					for(MasHospital hospital: hospitalList){
						if(monDetails[1].equals(hospital.getHospitalName())){
							hospitalId = hospital.getId();
							break;
						}
					}
				}
	%>
<th onclick="submitForm('AviationMonitoring','/hms/hms/monitoring?method=showSmcAviationJsp&commandId=<%=cmdId %>&command=<%=command%>&hospitalId=<%=hospitalId %>&hospital=<%=monDetails[1]%>')"><h4><%=monDetails[1] %></h4></th>
<td><a href="#" onclick="javascript:openPopupPreFlightMedCheckUpPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[2] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupPreFlightMedCheckUpPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[3] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupPreFlightMedCheckUpPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[4] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupPreFlightMedCheckUpPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[5] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupPreFlightMedCheckUpPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[6] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupPreFlightMedCheckUpPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[7] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupPreFlightMedCheckUpPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[8] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupPreFlightMedCheckUpPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[9] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupPreFlightMedCheckUpPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[10] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupPreFlightMedCheckUpPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[11] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupPreFlightMedCheckUpPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[12] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupPreFlightMedCheckUpPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[13] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupPreFlightMedCheckUpPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[14] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupPreFlightMedCheckUpPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[15] %></u></a></td>
</tr>
	<%}
			}%>
</table> 
</div>
<div class="Clear"></div>
<div class="cmntable">
<table border="">
<tr>
<th colspan="2">Civil Aviation</th>
<th>Today's</th>
<th>YTD</th>
<th>JAN</th>
<th>FEB</th>
<th>MAR</th>
<th>APR</th>
<th>MAY</th>
<th>JUN</th>
<th>JUL</th>
<th>AUG</th>
<th>SEP</th>
<th>OCT</th>
<th>NOV</th>
<th>DEC</th>
</tr>
<tr>
<th rowspan="<%=hospitalList.size() %>" class="module">Medical Exam</th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[17].equals("AvMedExam")){
				int hospitalId = 0;
				if(hospitalList.size() >0 ){
					for(MasHospital hospital: hospitalList){
						if(monDetails[1].equals(hospital.getHospitalName())){
							hospitalId = hospital.getId();
							break;
						}
					}
				}
	%>

<th class="hosName" onclick="submitForm('AviationMonitoring','/hms/hms/monitoring?method=showSmcAviationJsp&commandId=<%=cmdId %>&command=<%=command%>&hospitalId=<%=hospitalId %>&hospital=<%=monDetails[1]%>')"><h4><%=monDetails[1] %></h4></th>
<td><a href="#" onclick="javascript:openPopupCivilAviationPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[2] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupCivilAviationPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[3] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupCivilAviationPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[4] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupCivilAviationPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[5] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupCivilAviationPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[6] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupCivilAviationPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[7] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupCivilAviationPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[8] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupCivilAviationPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[9] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupCivilAviationPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[10] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupCivilAviationPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[11] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupCivilAviationPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[12] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupCivilAviationPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[13] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupCivilAviationPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[14] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupCivilAviationPop(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=monDetails[1]%>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[15] %></u></a></td>
</tr>
<%}
			}%>

</table> 
<div class="Clear"></div>
</div>

</form>
<script>
function openPopupMedLecture(cmdId,command,hospitalId,hospital,f,t)
{
 var url="/hms/hms/monitoring?method=showMedLecturePopH&cmdId="+cmdId+"&command="+command+"&hospitalId="+hospitalId+"&hospital="+hospital+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=150,width=700,status=1,scrollbars=1,resizable=0");

}
function openPopupPreFlightMedCheckUpPop(cmdId,command,hospitalId,hospital,f,t)
{
 var url="/hms/hms/monitoring?method=showPreFlightMedCheckUpPopH&cmdId="+cmdId+"&command="+command+"&hospitalId="+hospitalId+"&hospital="+hospital+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=150,width=700,status=1,scrollbars=1,resizable=0");

}
function openPopupCivilAviationPop(cmdId,command,hospitalId,hospital,f,t)
{
 var url="/hms/hms/monitoring?method=showCivilAviationPopH&cmdId="+cmdId+"&command="+command+"&hospitalId="+hospitalId+"&hospital="+hospital+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=150,width=700,status=1,scrollbars=1,resizable=0");

}
</script>
