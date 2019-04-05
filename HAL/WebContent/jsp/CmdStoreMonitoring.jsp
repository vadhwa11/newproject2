
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
List<Object[]> budgetList = new ArrayList<Object[]>();
if(map.get("budgetList") != null){
	budgetList= (List<Object[]>)map.get("budgetList");
}
%>

<%
int commandId = 0;
if(map.get("commandId") != null)
{     
	commandId = (Integer) map.get("commandId");
}


String command="";
if(map.get("command") != null && map.get("command") != "")
{
	command=(String)map.get("command");
}else
{	command=(String)map.get("commandName");
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

<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.util.HMSUtil"%><form name="cmdStore" method="post">

<div class="titleBg">
<h2>Med Store Monitoring</h2>
</div>

<div class="cmntable">
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
<th rowspan="<%=hospitalList.size() %>" class="module">Proforma B</th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[17].equals("ProformaB")){
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
<th class="hosName" onclick="submitForm('cmdStore','/hms/hms/monitoring?method=showSMCStoreMonitoringJsp&hospitalId=<%=hospitalId %>&commandId=<%=commandId %>&hospName=<%=monDetails[1] %>&command=<%=command %>')"><h4><%=monDetails[1] %></h4></th>
	<td><a href="#" onclick="javascript:openPopupPerformaBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[2] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[3] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[4] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[5] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[6] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[7] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[8] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[9] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[10] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[11] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[12] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[13] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[14] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[15] %></u></a></td>
</tr>
	<%}
			}%>
<tr>
<th rowspan="<%=hospitalList.size() %>">Pending Proforma B</th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[17].equals("PendingProformaB")){
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
<th onclick="submitForm('cmdStore','/hms/hms/monitoring?method=showSMCStoreMonitoringJsp&hospitalId=<%=hospitalId %>&commandId=<%=commandId %>&hospName=<%=monDetails[1] %>&command=<%=command %>')"><h4><%=monDetails[1] %></h4></th>
	<td><a href="#" onclick="javascript:openPopupPerformaBPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[2] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[3] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[4] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[5] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[6] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[7] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[8] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[9] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[10] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[11] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[12] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[13] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[14] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[15] %></u></a></td>
</tr>
	<%}
			}%>
</table> 
<div class="Clear"></div>
</div>

<div class="clear paddingTop15"></div>

<div class="cmntable">
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
<th rowspan="<%=hospitalList.size() %>" class="module">Defective Drugs</th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[17].equals("DefectiveDrugs")){
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
<th class="hosName" onclick="submitForm('cmdStore','/hms/hms/monitoring?method=showSMCStoreMonitoringJsp&hospitalId=<%=hospitalId %>&commandId=<%=commandId %>&hospName=<%=monDetails[1] %>&command=<%=command %>')"><h4><%=monDetails[1] %></h4></th>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[2] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[3] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[4] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[5] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[6] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[7] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[8] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[9] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[10] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[11] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[12] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[13] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[14] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[15] %></u></a></td>
</tr>
	<%}
			}%>
<tr>	
<th rowspan="<%=hospitalList.size() %>" class="module">Pending Defective Drugs</th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[17].equals("PendingDefectDrug")){
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
<th class="hosName" onclick="submitForm('cmdStore','/hms/hms/monitoring?method=showSMCStoreMonitoringJsp&hospitalId=<%=hospitalId %>&commandId=<%=commandId %>&hospName=<%=monDetails[1] %>&command=<%=command %>')"><h4><%=monDetails[1] %></h4></th>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[2] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[3] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[4] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[5] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[6] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[7] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[8] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[9] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[10] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[11] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[12] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[13] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[14] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrugPendH(<%=commandId%>,'<%=command%>',<%=hospitalId %>,'<%=monDetails[1] %>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[15] %></u></a></td>
</tr>
	<%}
			}%>
</table> 
<div class="Clear"></div>
</div> 



<div class="clear paddingTop15"></div>

<div class="cmntable">
<table border="">
<tr>
<th colspan="2"></th>
<th>Alloted Amount</th>
<th>Balance Amount</th>
</tr>
<tr>
<th rowspan="<%=hospitalList.size()  %>" class="module">Budget Allotment</th>
	<%
	for(Object[] monDetails :monitoringDetails){
		if(monDetails[17].equals("ProformaB")){
			int hospitalId = 0;
			if(hospitalList.size() >0 ){
				for(MasHospital hospital: hospitalList){
					if(monDetails[1].equals(hospital.getHospitalName())){
						hospitalId = hospital.getId();
						break;
					}
				}
			}
				BigDecimal allotedAmt= new BigDecimal(0);
			BigDecimal balanceAmt= new BigDecimal(0);
				for(Object[] obj : budgetList){
					if(obj[2].equals(hospitalId)){
						if(obj[0]!=null){
							allotedAmt = (BigDecimal)obj[0];
						}
						if(obj[1]!=null){
							balanceAmt = (BigDecimal)obj[1];
						}
						break;
					}
				}
			
	%>
<th class="cmdName" onclick="submitForm('cmdStore','/hms/hms/monitoring?method=showSMCStoreMonitoringJsp&hospitalId=<%=hospitalId %>')"><h4><%=monDetails[1] %></h4></th>
<td><%=allotedAmt %></td>
<td><%=balanceAmt %></td>
</tr>
	<%}
			}%>
	

</table> 
<div class="Clear"></div>
</div> 
<div class="Clear"></div>

</form>



<script>
function openPopupPerformaBH(cmdId,command,hospId,hosp,f,t)
{
 var url="/hms/hms/monitoring?method=showPerformaBH&cmdId="+cmdId+"&command="+command+"&hospitalId="+hospId+"&hosp="+hosp+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=350,width=700,status=1,scrollbars=1,resizable=0");
}


function openPopupPerformaBPendH(cmdId,command,hospId,hosp,f,t)
{
 var url="/hms/hms/monitoring?method=showPerformaBPendH&cmdId="+cmdId+"&command="+command+"&hospitalId="+hospId+"&hosp="+hosp+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=350,width=700,status=1,scrollbars=1,resizable=0");
}


function openPopupDefectiveDrugH(cmdId,command,hospId,hosp,f,t)
{
 var url="/hms/hms/monitoring?method=showDefectiveDrugH&cmdId="+cmdId+"&command="+command+"&hospitalId="+hospId+"&hosp="+hosp+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=350,width=700,status=1,scrollbars=1,resizable=0");
}

function openPopupDefectiveDrugPendH(cmdId,command,hospId,hosp,f,t)
{
 var url="/hms/hms/monitoring?method=showDefectiveDrugPendH&cmdId="+cmdId+"&command="+command+"&hospitalId="+hospId+"&hosp="+hosp+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=350,width=700,status=1,scrollbars=1,resizable=0");
}

</script>