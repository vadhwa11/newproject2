
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>
<%
Map<String, Object> map = new HashMap<String, Object>();
List<Object[]> monitoringDetails = new ArrayList<Object[]>();

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("monitoringDetails") != null){
	monitoringDetails= (List<Object[]>)map.get("monitoringDetails");
}
List<MasCommand> commandList = new ArrayList<MasCommand>();
if(map.get("commandList") != null){
	commandList= (List<MasCommand>)map.get("commandList");
}
List<Object[]> budgetList = new ArrayList<Object[]>();
if(map.get("budgetList") != null){
	budgetList= (List<Object[]>)map.get("budgetList");
}
%>


<%


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

		}%>

<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.util.HMSUtil"%><form name="airhqStore" method="post">

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
<th rowspan="<%=commandList.size() %>" class="module">Proforma B</th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[16].equals("ProformaB")){
				int cmdId = 0;
				if(commandList.size() >0 ){
					for(MasCommand command : commandList){
						if(monDetails[0].equals(command.getCommandName())){
							cmdId = command.getId();
							break;
						}
					}
				}
	%>
<th class="cmdName" onclick="submitForm('airhqStore','/hms/hms/monitoring?method=showCmdStoreMonitoringJsp&commandId=<%=cmdId %>&command=<%=monDetails[0] %>')"><h4><%=monDetails[0] %></h4></th>

	<td><a href="#" onclick="javascript:openPopupPerformaB(<%=cmdId%>,'<%=monDetails[0]%>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[1] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaB(<%=cmdId%>,'<%=monDetails[0]%>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[2] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaB(<%=cmdId%>,'<%=monDetails[0]%>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[3] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaB(<%=cmdId%>,'<%=monDetails[0]%>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[4] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaB(<%=cmdId%>,'<%=monDetails[0]%>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[5] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaB(<%=cmdId%>,'<%=monDetails[0]%>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[6] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaB(<%=cmdId%>,'<%=monDetails[0]%>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[7] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaB(<%=cmdId%>,'<%=monDetails[0]%>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[8] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaB(<%=cmdId%>,'<%=monDetails[0]%>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[9] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaB(<%=cmdId%>,'<%=monDetails[0]%>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[10] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaB(<%=cmdId%>,'<%=monDetails[0]%>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[11] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaB(<%=cmdId%>,'<%=monDetails[0]%>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[12] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaB(<%=cmdId%>,'<%=monDetails[0]%>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[13] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaB(<%=cmdId%>,'<%=monDetails[0]%>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[14] %></u></a></td>
</tr>
	<%}
			}%>
<tr>
<th rowspan="<%=commandList.size() %>" class="module">Pending Proforma B</th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[16].equals("PendingProformaB")){
				int cmdId = 0;
				if(commandList.size() >0 ){
					for(MasCommand command : commandList){
						if(monDetails[0].equals(command.getCommandName())){
							cmdId = command.getId();
							break;
						}
					}
				}
	%>
<th class="cmdName" onclick="submitForm('airhqStore','/hms/hms/monitoring?method=showCmdStoreMonitoringJsp&commandId=<%=cmdId %>')"><h4><%=monDetails[0] %></h4></th>
	<td><a href="#" onclick="javascript:openPopupPerformaBPend(<%=cmdId%>,'<%=monDetails[0]%>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[1] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPend(<%=cmdId%>,'<%=monDetails[0]%>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[2] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPend(<%=cmdId%>,'<%=monDetails[0]%>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[3] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPend(<%=cmdId%>,'<%=monDetails[0]%>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[4] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPend(<%=cmdId%>,'<%=monDetails[0]%>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[5] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPend(<%=cmdId%>,'<%=monDetails[0]%>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[6] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPend(<%=cmdId%>,'<%=monDetails[0]%>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[7] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPend(<%=cmdId%>,'<%=monDetails[0]%>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[8] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPend(<%=cmdId%>,'<%=monDetails[0]%>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[9] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPend(<%=cmdId%>,'<%=monDetails[0]%>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[10] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPend(<%=cmdId%>,'<%=monDetails[0]%>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[11] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPend(<%=cmdId%>,'<%=monDetails[0]%>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[12] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPend(<%=cmdId%>,'<%=monDetails[0]%>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[13] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupPerformaBPend(<%=cmdId%>,'<%=monDetails[0]%>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[14] %></u></a></td>
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
<th rowspan="<%=commandList.size() %>" class="module">Defective Drugs</th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[16].equals("DefectiveDrugs")){
				int cmdId = 0;
				if(commandList.size() >0 ){
					for(MasCommand command : commandList){
						if(monDetails[0].equals(command.getCommandName())){
							cmdId = command.getId();
							break;
						}
					}
				}
	%>
<th class="cmdName" onclick="submitForm('airhqStore','/hms/hms/monitoring?method=showCmdStoreMonitoringJsp&commandId=<%=cmdId %>')"><h4><%=monDetails[0] %></h4></th>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrug(<%=cmdId%>,'<%=monDetails[0]%>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[1] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrug(<%=cmdId%>,'<%=monDetails[0]%>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[2] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrug(<%=cmdId%>,'<%=monDetails[0]%>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[3] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrug(<%=cmdId%>,'<%=monDetails[0]%>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[4] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrug(<%=cmdId%>,'<%=monDetails[0]%>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[5] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrug(<%=cmdId%>,'<%=monDetails[0]%>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[6] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrug(<%=cmdId%>,'<%=monDetails[0]%>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[7] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrug(<%=cmdId%>,'<%=monDetails[0]%>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[8] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrug(<%=cmdId%>,'<%=monDetails[0]%>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[9] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrug(<%=cmdId%>,'<%=monDetails[0]%>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[10] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrug(<%=cmdId%>,'<%=monDetails[0]%>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[11] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrug(<%=cmdId%>,'<%=monDetails[0]%>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[12] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrug(<%=cmdId%>,'<%=monDetails[0]%>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[13] %></u></a></td>
	<td><a href="#" onclick="javascript:openPopupDefectiveDrug(<%=cmdId%>,'<%=monDetails[0]%>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[14] %></u></a></td>
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
<th rowspan="<%=commandList.size() %>" class="module" >Budget Allotment</th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[16].equals("DefectiveDrugs")){
				int cmdId = 0;
				if(commandList.size() >0 ){
					for(MasCommand command : commandList){
						if(monDetails[0].equals(command.getCommandName())){
							cmdId = command.getId();
							break;
						}
					}
				}
				
				BigDecimal allotedAmt= new BigDecimal(0);
			BigDecimal balanceAmt= new BigDecimal(0);
				for(Object[] obj : budgetList){
					if(obj[2].equals(cmdId)){
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
<th class="cmdName" onclick="submitForm('airhqStore','/hms/hms/monitoring?method=showCmdStoreMonitoringJsp&commandId=<%=cmdId %>')"><h4><%=monDetails[0] %></h4></th>
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
function openPopupPerformaB(cmdId,command,f,t)
{
 var url="/hms/hms/monitoring?method=showPerformaB&cmdId="+cmdId+"&command="+command+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=350,width=700,status=1,scrollbars=1,resizable=0");
}


function openPopupPerformaBPend(cmdId,command,f,t)
{
 var url="/hms/hms/monitoring?method=showPerformaBPend&cmdId="+cmdId+"&command="+command+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=350,width=700,status=1,scrollbars=1,resizable=0");
}


function openPopupDefectiveDrug(cmdId,command,f,t)
{
 var url="/hms/hms/monitoring?method=showDefectiveDrug&cmdId="+cmdId+"&command="+command+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=350,width=700,status=1,scrollbars=1,resizable=0");
}



</script>
