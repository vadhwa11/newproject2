<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>


<%
Map<String, Object> map = new HashMap<String, Object>();
List<Object[]> monitoringDetails = new ArrayList<Object[]>();

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("monitoringDetails") != null){
	monitoringDetails= (List<Object[]>)map.get("monitoringDetails");
}
int hospitalId = 0;
if(map.get("hospitalId")!=null &&  !map.get("hospitalId").equals("0")){
	hospitalId = (Integer)map.get("hospitalId");
}
%>

<%

int commandId=0;
if(map.get("commandId")!=null && !map.get("commandId").equals("0"))
{
	commandId = (Integer)map.get("commandId");
}

String command="";
if(map.get("command") != null && !map.get("command").equals(""))
{
	command=(String)map.get("command");
}else
{	command=(String)map.get("commandName");
}


String hospName="";
if(map.get("hospName") != null && !map.get("hospName").equals(""))
{
	hospName=(String)map.get("hospName");
}else
{	hospName=(String)map.get("hospitalName");
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


<%@page import="jkt.hms.util.HMSUtil"%><form name="smcHealth" method="post">

<div class="titleBg">
<h2>Health Monitoring</h2>
</div>
<div class="cmntable">
	
	<table border="">
	<tr>
	<th></th>
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
	<th class="module"  onclick="submitForm('smcHealth','/hms/hms/registration?method=showOPDRegisterReportJsp&hospitalId=<%=hospitalId %>')"><h4>Visit</h4></th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[17].equals("visit")){
	%>
	<td><a href="#" onclick="javascript:openPopupRegS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[2] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupRegS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[3] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupRegS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[4] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupRegS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[5] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupRegS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[6] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupRegS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[7] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupRegS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[8] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupRegS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[9] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupRegS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[10] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupRegS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[11] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupRegS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[12] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupRegS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[13] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupRegS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[14] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupRegS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[15] %></u></a></td>
</tr>
	<%}
			}%>
			
			</table> 
			</div>
	<div class="Clear"></div>
	<div class="cmntable">
	<table border="">
	<tr>
	<th></th>
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
	<th class="module"   onclick="submitForm('smcHealth','/hms/hms/adt?method=showIpAdmissionRegisterReportJsp&hospitalId=<%=hospitalId %>')"><h4>Admission</h4></th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[17].equals("admission")){
	%>
	<td><a href="#" onclick="javascript:openPopupAdmissionS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[2] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAdmissionS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[3] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAdmissionS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[4] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAdmissionS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[5] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAdmissionS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[6] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAdmissionS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[7] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAdmissionS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[8] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAdmissionS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[9] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAdmissionS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[10] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAdmissionS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[11] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAdmissionS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[12] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAdmissionS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[13] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAdmissionS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[14] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAdmissionS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[15] %></u></a></td>
</tr>
	<%}
			}%>
	
	</table> 
	<div class="Clear"></div>
</div>

<div class="Clear"></div>
<div class="cmntable">
	
	<table border="">
	<tr>
	<th></th>
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
	<th class="module"  onclick="submitForm('smcHealth','/hms/hms/registration?method=showAircraftEmergencyRegisterJsp&hospitalId=<%=hospitalId %>')"><h4>Aircraft Emergency</h4></th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[17].equals("aircraft")){
	%>
	<td><a href="#" onclick="javascript:openPopupAirCraftS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[2] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAirCraftS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[3] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAirCraftS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[4] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAirCraftS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[5] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAirCraftS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[6] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAirCraftS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[7] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAirCraftS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[8] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAirCraftS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[9] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAirCraftS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[10] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAirCraftS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[11] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAirCraftS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[12] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAirCraftS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[13] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAirCraftS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[14] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupAirCraftS(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=hospName %>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[15] %></u></a></td>
</tr>
	<%}
			}%>
			
			</table> 
			</div>
</form>



<script>
function openPopupRegS(cmdId,command,hospId,hosp,f,t)
{
 var url="/hms/hms/monitoring?method=showServiceDetailsS&cmdId="+cmdId+"&command="+command+"&hospId="+hospId+"&hosp="+hosp+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=350,width=700,status=1,scrollbars=1,resizable=0");
}


function openPopupAdmissionS(cmdId,command,hospId,hosp,f,t)
{
 var url="/hms/hms/monitoring?method=showServiceDetailsAdmissionS&cmdId="+cmdId+"&command="+command+"&hospId="+hospId+"&hosp="+hosp+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=350,width=700,status=1,scrollbars=1,resizable=0");
}


function openPopupAirCraftS(cmdId,command,hospId,hosp,f,t)
{
 var url="/hms/hms/monitoring?method=showServiceDetailsAirCraftS&cmdId="+cmdId+"&command="+command+"&hospId="+hospId+"&hosp="+hosp+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=350,width=700,status=1,scrollbars=1,resizable=0");
}

</script>