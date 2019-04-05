<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
int commandId = 0;
if(map.get("commandId") != null && !map.get("commandId").equals("0"))
{     
	commandId = (Integer) map.get("commandId");
}


String command="";
if(map.get("command") != null && !map.get("command").equals(""))
{
	command=(String)map.get("command");
}else
{	command=(String)map.get("cmdName");
}


Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");

String yfDate="";
if(map.get("yfDate") != null)
{
	yfDate=(String)map.get("yfDate");
}

String ytDate="";
if(map.get("ytDate") != null)
{
	ytDate=(String)map.get("ytDate");
}

String jfDate="";
if(map.get("jfDate") != null)
{
	jfDate=(String)map.get("jfDate");
}

String jtDate="";
if(map.get("jtDate") != null)
{
	jtDate=(String)map.get("jtDate");
}

String ffDate="";
if(map.get("ffDate") != null)
{
	ffDate=(String)map.get("ffDate");
}

String ftDate="";
if(map.get("ftDate") != null)
{
	ftDate=(String)map.get("ftDate");
}

String mfDate="";
if(map.get("mfDate") != null)
{
	mfDate=(String)map.get("mfDate");
}

String mtDate="";
if(map.get("mtDate") != null)
{
	mtDate=(String)map.get("mtDate");
}

String afDate="";
if(map.get("afDate") != null)
{
	afDate=(String)map.get("afDate");
}

String atDate="";
if(map.get("atDate") != null)
{
	atDate=(String)map.get("atDate");
}

String mafDate="";
if(map.get("mafDate") != null)
{
	mafDate=(String)map.get("mafDate");
}

String matDate="";
if(map.get("matDate") != null)
{
	matDate=(String)map.get("matDate");
}

String jufDate="";
if(map.get("jufDate") != null)
{
	jufDate=(String)map.get("jufDate");

	}
String jutDate="";
if(map.get("jutDate") != null)
{
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



<%@page import="jkt.hms.util.HMSUtil"%><form name="examBoardCommand" method="post">

<div class="titleBg">
<h2>Medical Exam/ Board Monitoring</h2>
</div>


<h4>Medical Exam</h4>
<table border="">
<tr>
<th colspan="2"></th>
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
<th rowspan="<%=hospitalList.size() %>">MED Exam</th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[17].equals("MedExam")){
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
	<th onclick="submitForm('examBoardCommand','/hms/hms/monitoring?method=showMedExamBoardSMCJsp&hospitalId=<%=hospitalId %>&commandId=<%=commandId %>&hospName=<%=monDetails[1] %>&command=<%=command %>')"><h4><%=monDetails[1] %></h4></th>

	<td><a href="#" onclick="javascript:openPopupMEH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[2] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMEH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[3] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMEH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[4] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMEH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[5] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMEH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[6] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMEH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[7] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMEH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[8] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMEH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[9] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMEH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[10] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMEH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[11] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMEH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[12] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMEH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[13] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMEH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[14] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMEH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[15] %></u></a></td>
</tr>
	<%}
			}%>
			

<tr>
<th rowspan="<%=hospitalList.size() %>" onclick="submitForm('examBoardCommand','/hms/hms/medicalExam?method=showApprovingAWatingList');"><h4>Pending Approval</h4></th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[17].equals("PendingMedExam")){
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
	<th onclick="submitForm('examBoardCommand','/hms/hms/monitoring?method=showMedExamBoardSMCJsp&hospitalId=<%=hospitalId %>&commandId=<%=commandId %>&hospName=<%=monDetails[1] %>&command=<%=command %>')"><h4><%=monDetails[1] %></h4></th>
	<td><a href="#" onclick="javascript:openPopupMePendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[2] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMePendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[3] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMePendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[4] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMePendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[5] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMePendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[6] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMePendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[7] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMePendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[8] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMePendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[9] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMePendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[10] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMePendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[11] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMePendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[12] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMePendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[13] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMePendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[14] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMePendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[15] %></u></a></td>
</tr>
	<%}
			}%>
			
</table> 
<div class="Clear"></div>


<div class="clear paddingTop15"></div>

<h4>Medical Board</h4>
<table border="">
<tr>
<th colspan="2"></th>
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

<th rowspan="<%=hospitalList.size() %>">MED Board</th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[17].equals("MedBoard")){
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
	<th onclick="submitForm('examBoardCommand','/hms/hms/monitoring?method=showMedExamBoardSMCJsp&hospitalId=<%=hospitalId %>&commandId=<%=commandId %>&hospName=<%=monDetails[1] %>&command=<%=command %>')"><h4><%=monDetails[1] %></h4></th>
	<td><a href="#" onclick="javascript:openPopupMBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[2] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[3] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[4] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[5] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[6] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[7] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[8] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[9] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[10] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[11] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[12] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[13] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[14] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[15] %></u></a></td>
</tr>
	<%}
			}%>
			
	
<tr>
<th rowspan="<%=hospitalList.size() %>"  onclick="submitForm('examBoardCommand','/hms/hms/medicalBoard?method=showMedicalBoardApprovingAuthority');"><h4>Pending Approval</h4></th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[17].equals("PendingMedBoard")){
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
	<th onclick="submitForm('examBoardCommand','/hms/hms/monitoring?method=showMedExamBoardSMCJsp&hospitalId=<%=hospitalId %>&commandId=<%=commandId %>&hospName=<%=monDetails[1] %>&command=<%=command %>')"><h4><%=monDetails[1] %></h4></th>
	<td><a href="#" onclick="javascript:openPopupMbPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[2] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMbPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[3] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMbPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[4] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMbPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[5] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMbPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[6] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMbPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[7] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMbPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[8] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMbPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[9] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMbPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[10] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMbPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[11] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMbPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[12] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMbPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[13] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMbPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[14] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupMbPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[15] %></u></a></td>
</tr>
	<%}
			}%>
			
</table> 
<div class="Clear"></div>

<input type="hidden" name="commandId" value=<%= commandId %> ></input>
</form>



<script>
function openPopupMEH(cmdId,command,hospId,hosp,f,t)
{
 var url="/hms/hms/monitoring?method=showServiceDetailsMEH&commandId="+cmdId+"&command="+command+"&hospitalId="+hospId+"&hosp="+hosp+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=350,width=700,status=1,scrollbars=1,resizable=0");
}


function openPopupMePendH(cmdId,command,hospId,hosp,f,t)
{
 var url="/hms/hms/monitoring?method=showServiceDetailsMePendH&commandId="+cmdId+"&command="+command+"&hospitalId="+hospId+"&hosp="+hosp+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=350,width=700,status=1,scrollbars=1,resizable=0");
}


function openPopupMBH(cmdId,command,hospId,hosp,f,t)
{
 var url="/hms/hms/monitoring?method=showServiceDetailsMBH&commandId="+cmdId+"&command="+command+"&hospitalId="+hospId+"&hosp="+hosp+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=350,width=700,status=1,scrollbars=1,resizable=0");
}

function openPopupMbPendH(cmdId,command,hospId,hosp,f,t)
{
 var url="/hms/hms/monitoring?method=showServiceDetailsMbPendH&commandId="+cmdId+"&command="+command+"&hospitalId="+hospId+"&hosp="+hosp+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=350,width=700,status=1,scrollbars=1,resizable=0");
}

</script>