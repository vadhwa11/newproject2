<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
Map<String, Object> map = new HashMap<String, Object>();
List<Object[]> monitoringDetails = new ArrayList<Object[]>();

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("monitoringDetails") != null){
	monitoringDetails= (List<Object[]>)map.get("monitoringDetails");
}


Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String command="";
if(map.get("command")!= null && map.get("command")!=""){
	command=(String)map.get("command");

	}
else{
	command=(String)map.get("commandName");
		
}
int cmdId=0;
if(map.get("commandId") != null && map.get("commandId")!= "0" ){
	cmdId=(Integer)map.get("commandId");

}else
{
	cmdId=(Integer)map.get("cId");
}
	int hospitalId=0;
	if(map.get("hospitalId") != null){
		hospitalId=(Integer)map.get("hospitalId");

	}
	String hospital="";
	if(map.get("hospital") != null && map.get("hospital") !=""){
		hospital=(String)map.get("hospital");

	}
	else{
		hospital=(String)map.get("hospitalName");
			
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


<form name="statsSMC" method="post">

<div class="titleBg">
<h2>Stats Monitoring</h2>
</div>

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
<th onclick="submitForm('statsSMC','/hms/hms/mis?method=showSILDILRegisterReportJsp&hospitalId=<%=hospitalId %>');"><h4>SIL/DIL</h4></th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[17].equals("sildil")){
	%>

<td><a href="#" onclick="javascript:openPopupSilDil(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[2] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSilDil(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[3] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSilDil(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[4] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSilDil(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[5] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSilDil(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[6] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSilDil(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[7] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSilDil(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[8] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSilDil(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[9] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSilDil(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[10] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSilDil(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[11] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSilDil(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[12] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSilDil(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[13] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSilDil(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[14] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSilDil(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[15] %></u></a></td>

</tr>
	<%}
			}%>
			
</table>
<div class="Clear"></div>
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
<th onclick="submitForm('statsSMC','/hms/hms/mis?method=showEDReturnsJsp&jspName=EDReturnForm&hospitalId=<%=hospitalId %>');"><h4>Ed Returns</h4></th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[17].equals("EdReturns")){
	%>
<td><a href="#" onclick="javascript:openPopupEdReturns(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[2] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupEdReturns(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[3] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupEdReturns(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[4] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupEdReturns(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[5] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupEdReturns(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[6] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupEdReturns(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[7] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupEdReturns(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[8] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupEdReturns(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[9] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupEdReturns(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[10] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupEdReturns(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[11] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupEdReturns(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[12] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupEdReturns(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[13] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupEdReturns(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[14] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupEdReturns(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[15] %></u></a></td>

</tr>
	<%}
			}%>
			
</table> 
<div class="Clear"></div>


<div class="clear paddingTop15"></div>

<h4>AFMSF-1</h4>
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

<th onclick="submitForm('statsSMC','/hms/hms/mis?method=showDefeicientReportJsp&form=Deficient&hospitalId=<%=hospitalId%>');"><h4>Deficient</h4></th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[17].equals("deficient")){
	%>
<td><a href="#" onclick="javascript:openPopupDeficient(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[2] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupDeficient(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[3] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupDeficient(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[4] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupDeficient(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[5] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupDeficient(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[6] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupDeficient(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[7] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupDeficient(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[8] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupDeficient(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[9] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupDeficient(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[10] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupDeficient(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[11] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupDeficient(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[12] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupDeficient(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[13] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupDeficient(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[14] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupDeficient(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[15] %></u></a></td>

</tr>
	<%}
			}%>
			
	
<tr>
<th onclick="submitForm('statsSMC','/hms/hms/mis?method=showSurplusReportJsp&hospitalId=<%=hospitalId%>');"><h4>Surplus</h4></th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[17].equals("surplus")){
	%>
<td><a href="#" onclick="javascript:openPopupSurplus(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[2] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSurplus(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[3] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSurplus(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[4] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSurplus(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[5] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSurplus(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[6] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSurplus(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[7] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSurplus(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[8] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSurplus(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[9] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSurplus(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[10] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSurplus(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[11] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSurplus(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[12] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSurplus(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[13] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSurplus(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[14] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupSurplus(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[15] %></u></a></td>

</tr>
	<%}
			}%>
			
</table> 
<div class="Clear"></div>

<div class="clear paddingTop15"></div>


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
<th onclick="submitForm('statsSMC','/hms/hms/mis?method=showSILDILRegisterReportJsp&hospitalId=<%=hospitalId %>');"><h4>Monthly Sick Details</h4></th>
	<%
		for(Object[] monDetails :monitoringDetails){
			if(monDetails[17].equals("sildil")){
	%>
<td><a href="#" onclick="javascript:openPopupMonthlySickDetails(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=currentDate %>','<%=currentDate %>')"><u><%=monDetails[2] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMonthlySickDetails(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=yfDate %>','<%=ytDate %>')"><u><%=monDetails[3] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMonthlySickDetails(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=jfDate %>','<%=jtDate %>')"><u><%=monDetails[4] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMonthlySickDetails(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=ffDate %>','<%=ftDate %>')"><u><%=monDetails[5] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMonthlySickDetails(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=mfDate %>','<%=mtDate %>')"><u><%=monDetails[6] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMonthlySickDetails(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=afDate %>','<%=atDate %>')"><u><%=monDetails[7] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMonthlySickDetails(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=mafDate %>','<%=matDate %>')"><u><%=monDetails[8] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMonthlySickDetails(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=jufDate %>','<%=jutDate %>')"><u><%=monDetails[9] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMonthlySickDetails(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=jyfDate %>','<%=jytDate %>')"><u><%=monDetails[10] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMonthlySickDetails(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=aufDate %>','<%=autDate %>')"><u><%=monDetails[11] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMonthlySickDetails(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=sfDate %>','<%=stDate %>')"><u><%=monDetails[12] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMonthlySickDetails(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=ofDate %>','<%=otDate %>')"><u><%=monDetails[13] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMonthlySickDetails(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=nfDate %>','<%=ntDate %>')"><u><%=monDetails[14] %></u></a></td>
<td><a href="#" onclick="javascript:openPopupMonthlySickDetails(<%=cmdId%>,'<%=command%>',<%=hospitalId%>,'<%=hospital%>','<%=dfDate %>','<%=dtDate %>')"><u><%=monDetails[15] %></u></a></td>

</tr>
	<%}
			}%>
			
</table>



</form>


<script>
function openPopupSilDil(cmdId,command,hospitalId,hospital,f,t)
{
 var url="/hms/hms/monitoring?method=showSilDilPopCH&cmdId="+cmdId+"&command="+command+"&hospitalId="+hospitalId+"&hospital="+hospital+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=150,width=700,status=1,scrollbars=1,resizable=0");

}
function openPopupEdReturns(cmdId,command,hospitalId,hospital,f,t)
{
 var url="/hms/hms/monitoring?method=showEdReturnsPopCH&cmdId="+cmdId+"&command="+command+"&hospitalId="+hospitalId+"&hospital="+hospital+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=150,width=700,status=1,scrollbars=1,resizable=0");

}
function openPopupDeficient(cmdId,command,hospitalId,hospital,f,t)
{
 var url="/hms/hms/monitoring?method=showDeficientPopCH&cmdId="+cmdId+"&command="+command+"&hospitalId="+hospitalId+"&hospital="+hospital+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=150,width=700,status=1,scrollbars=1,resizable=0");

}
function openPopupSurplus(cmdId,command,hospitalId,hospital,f,t)
{
 var url="/hms/hms/monitoring?method=showSurplusPopCH&cmdId="+cmdId+"&command="+command+"&hospitalId="+hospitalId+"&hospital="+hospital+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=150,width=700,status=1,scrollbars=1,resizable=0");

}
function openPopupMonthlySickDetails(cmdId,command,hospitalId,hospital,f,t)
{
 var url="/hms/hms/monitoring?method=showMonthlySickDetailsPopCH&cmdId="+cmdId+"&command="+command+"&hospitalId="+hospitalId+"&hospital="+hospital+"&f="+f+"&t="+t;
 newwindow=window.open(url,'name',"left=2,top=100,height=150,width=700,status=1,scrollbars=1,resizable=0");

}
</script>