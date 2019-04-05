<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<%
Map<String, Object> map = new HashMap<String, Object>();
BigDecimal allotAmt = new BigDecimal("0");
BigDecimal soPlaced = new BigDecimal("0");
BigDecimal soBalance = new BigDecimal("0");

BigDecimal crvAmt = new BigDecimal("0");
BigDecimal crvBalance = new BigDecimal("0");
BigDecimal crvDone = new BigDecimal("0");
BigDecimal sopAmt = new BigDecimal("0");
BigDecimal PendingLATAmt = new BigDecimal("0");

String allot ="";
int pendingLAT = 0;

String soP = "";
String soP1 = "";
String soB = "";
String crvA = "";
String crvB = "";
String crvD = "";
String sopA = "";
String pLATA = "";
int sopN = 0;
String fromDate = null;
boolean status = false;

int dateOfMonth, month1, year1;
Calendar calendar1 = Calendar.getInstance();
String dateOnly = "";
month1 = calendar1.get(Calendar.MONTH) + 1;
if(month1 > 0 && month1 < 4){
	year1 = calendar1.get(Calendar.YEAR) - 1;	
}else{
	year1 = calendar1.get(Calendar.YEAR);	
}


dateOnly= dateOnly + (year1);
dateOnly= dateOnly + "-";
dateOnly= dateOnly + "04";
dateOnly= dateOnly + "-";
dateOnly= dateOnly + "01";


	if (request.getAttribute("map") != null) {
			map = (Map<String, Object>) request.getAttribute("map");
	}
	
	if(map.get("allotAmt") != null){
		allotAmt = (BigDecimal)map.get("allotAmt");	
	}
	
	if(map.get("pendingLAT") != null){
		pendingLAT = (Integer)map.get("pendingLAT");	
	}
	
	if(map.get("soPlaced") != null){
		soPlaced = (BigDecimal)map.get("soPlaced");	
	}
	
	if(map.get("soBalance") != null){
		soBalance = (BigDecimal)map.get("soBalance");	
	}
	
	if(map.get("crvAmt") != null){
		crvAmt = (BigDecimal)map.get("crvAmt");	
	}
	if(map.get("crvBalance") != null){
		crvBalance = (BigDecimal)map.get("crvBalance");	
	}
	
	if(map.get("crvDone") != null){
		crvDone = (BigDecimal)map.get("crvDone");	
	}
	if(map.get("soPendingAmt") != null){
		sopAmt = (BigDecimal)map.get("soPendingAmt");	
	}
	if(map.get("soPendingNo") != null){
		sopN = (Integer)map.get("soPendingNo");	
	}
	
	if(map.get("pendngLATAmt") != null){
		PendingLATAmt = (BigDecimal)map.get("pendngLATAmt");	
	}
	
	if(map.get("fromDate") != null){
		fromDate = (String) map.get("fromDate");
	}

	 if(fromDate.compareTo(dateOnly) > 0 || fromDate.compareTo(dateOnly) < 0){
	      status = true;
	 }
	 
	

		Locale loc = new Locale("en","IN");
		NumberFormat num = NumberFormat.getNumberInstance(loc);
		
		
	 
allot = new  DecimalFormat("0.##").format(Double.valueOf(allotAmt.toString()));

soP = new  DecimalFormat("0.##").format(Double.valueOf(soPlaced.toString()));
soB = new  DecimalFormat("0.##").format(Double.valueOf(soBalance.toString()));

crvA = new  DecimalFormat("0.##").format(Double.valueOf(crvAmt.toString()));
crvB = new  DecimalFormat("0.##").format(Double.valueOf(crvBalance.toString()));
crvD = new  DecimalFormat("0.##").format(Double.valueOf(crvDone.toString()));
sopA = new  DecimalFormat("0.##").format(Double.valueOf(sopAmt.toString()));
pLATA = new  DecimalFormat("0.##").format(Double.valueOf(PendingLATAmt.toString()));

soP1 = num.format(Double.valueOf(crvAmt.toString()));
%>
<%@page import="java.math.BigDecimal"%>
</br>
<div id="contentHolder">
<div
	style="width: 15px; height: 20px; BORDER-bottom: #3c8ad7 1px solid; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Details</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 74%; height: 230px; background-color: #f4f9fe;">
<br>
<label
	style="FONT-SIZE: 15px; COLOR: #0438A5; font-weight: bold; LINE-HEIGHT: 16px; font-family: Trebuchet MS, Tahoma, Arial Narrow, Arial; width: 300px;">
Total Allotment for the current F/Y : </label> <label
	style="FONT-SIZE: 13px; COLOR: black; font-weight: bold; width: 100px;"><%="RS "+allot %>
</label> <br>
<br>

<table>
	<tr>
		<td><label
			style="FONT-SIZE: 11px; COLOR: #0438A5; font-weight: bold; LINE-HEIGHT: 16px; font-family: Trebuchet MS, Tahoma, Arial Narrow, Arial; width: 15px;">1)</label>
		</td>
		<td style="padding-left: 18px; width: 40%;"><label
			style="FONT-SIZE: 11px; COLOR: #0438A5; font-weight: bold; LINE-HEIGHT: 16px; font-family: Trebuchet MS, Tahoma, Arial Narrow, Arial;">SO
		Placed : </label> <label
			style="FONT-SIZE: 11px; COLOR: black; font-weight: bold; text-align: left;"><%=soP%></label>
		</td>
		<td><label
			style="FONT-SIZE: 11px; COLOR: #0438A5; font-weight: bold; LINE-HEIGHT: 16px; padding-left: 65px;">
		Balance :</label> <label
			style="FONT-SIZE: 11px; COLOR: black; font-weight: bold; text-align: left;"><%=!status?soB:"N/A"%></label>
		</td>
	</tr>
	<tr>
		<td></td>
		<td style="padding-left: 75px; padding-top: 7px;"><input
			type="button" name="poreg" id="poreg" onclick="getPoReg();"
			value="Details" class="cmnButton"></td>
		<td style="padding-left: 50px;"><label
			style="FONT-SIZE: 11px; font-weight: bold; padding-bottom: 5px; padding-top: 5px;"></label>
		</td>
	</tr>

	<tr>
		<td><label
			style="FONT-SIZE: 11px; COLOR: #0438A5; font-weight: bold; LINE-HEIGHT: 16px; font-family: Trebuchet MS, Tahoma, Arial Narrow, Arial; width: 15px;">2)</label>
		</td>
		<td style="padding-left: 22px; width: 40%;"><label
			style="FONT-SIZE: 11px; COLOR: #0438A5; font-weight: bold; LINE-HEIGHT: 16px; font-family: Trebuchet MS, Tahoma, Arial Narrow, Arial; width: 75px;">CRV(SO)
		:</label> <label
			style="FONT-SIZE: 11px; COLOR: black; font-weight: bold; text-align: left;"><%=crvA %></label>
		</td>
		<td style="padding-left: 32px;"><label
			style="FONT-SIZE: 11px; COLOR: #0438A5; font-weight: bold; LINE-HEIGHT: 16px; font-family: Trebuchet MS, Tahoma, Arial Narrow, Arial; width: 120px;">
		So pending for CRV :</label> <label
			style="FONT-SIZE: 11px; COLOR: black; font-weight: bold; text-align: left; width: 200px;"><%="No:"+ sopN +"  , Amt : "%><%=!status?sopA:"N/A" %></label>
		</td>
	</tr>

	<tr>
		<td></td>
		<td style="padding-left: 75px; padding-top: 7px;"><input
			type="button" name="recReg" id="recReg" onclick="getRecReg();"
			value="Details" class="cmnButton"></td>
		<td style="padding-left: 100px; padding-top: 7px;">
		<input type="button" name="pendCRV" id="pendCRV" onclick="getSOPendCRV();"  value="Details" class="cmnButton">
		</td>
	</tr>

	<tr>
		<td><label
			style="FONT-SIZE: 11px; COLOR: #0438A5; font-weight: bold; LINE-HEIGHT: 16px; font-family: Trebuchet MS, Tahoma, Arial Narrow, Arial; width: 15px;">3)</label>
		</td>
		<td style="padding-left: 25px; width: 40%; text-align: left;"><label
			style="FONT-SIZE: 11px; COLOR: #0438A5; font-weight: bold; LINE-HEIGHT: 16px; font-family: Trebuchet MS, Tahoma, Arial Narrow, Arial; width: 70px;">LAT
		:</label> <label
			style="FONT-SIZE: 11px; COLOR: black; font-weight: bold; text-align: left;"><%=crvD %></label>
		</td>
		<td style="padding-left: 0px;"><label
			style="FONT-SIZE: 11px; COLOR: #0438A5; font-weight: bold; LINE-HEIGHT: 16px; font-family: Trebuchet MS, Tahoma, Arial Narrow, Arial; width: 153px;">CRV
		pending for LAT :</label> <label
			style="FONT-SIZE: 11px; COLOR: black; text-align: left; width: 200px;"><%="No:"+pendingLAT + " , Amt : " +pLATA%></label>
		</td>
	</tr>
	<tr>
		<td></td>
		<td style="padding-left: 25px;"><label
			style="FONT-SIZE: 11px; font-weight: bold; padding-bottom: 5px; padding-top: 5px;">
		</label></td>
		<td style="padding-left: 100px; padding-top: 7px;"><input
			type="button" name="penLAT" id="penLAT"
			onclick="getPendingLATDetails();" value="Details" class="cmnButton">
		</td>
	</tr>

</table>
</div>
</div>
