<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />

<script type="text/javascript" src="/hms/jsp/js/autocomplete.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
var nameArray=new Array();
var codeArray=new Array();
</script>


<%
	
	 int pageNo=1;
	String buttonFlag="";
	
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<Patient> patientDetailsList = new ArrayList<Patient>();
	List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
	List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
	List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	if(map.get("buttonFlag") != null)
	{
		buttonFlag=(String)map.get("buttonFlag");
		
	}
	if(map.get("pageNo") != null)
	{
		pageNo=(Integer)map.get("pageNo");
		
	}
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date=(String)utilMap.get("currentDate");
	String time=(String)utilMap.get("currentTime");
	
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	if(map.get("patientDetailsList") != null){
		patientDetailsList = (List<Patient>)map.get("patientDetailsList");
	}
	if(map.get("mainChargeCodeList") != null){
		mainChargeCodeList = (List<MasMainChargecode>)map.get("mainChargeCodeList");
	}
	if(map.get("subChargeCodeList") != null){
		subChargeCodeList = (List<MasSubChargecode>)map.get("subChargeCodeList");
	}
	if(map.get("chargeCodeList") != null){
		chargeCodeList = (List<MasChargeCode>)map.get("chargeCodeList");
	}
	
	%>

<div id="testDiv"><br />

<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
	<TBODY>
		<TR>
			<TD height="6" bgColor=#ffffff></TD>
		</TR>
		<TR>
			<TD align=right>
			<TABLE width=* border=0 align="left" cellPadding=0 cellSpacing=0>
				<TBODY>
					<TR>
						<TD rowSpan=2><IMG height=8 src="images/spacer.gif" width=8></TD>
						<TD bgColor=#95bfea rowSpan=2><IMG height=1
							src="images/spacer.gif" width=1></TD>
						<TD bgColor=#95bfea><IMG height=1 src="images/spacer.gif"
							width=1></TD>
						<TD rowSpan=2><IMG height=21
							src="/hms/jsp/images/tab_edge_ltbl.gif" width=25></TD>
					</TR>
					<TR>
						<TD
							style="PADDING-RIGHT: 4px; PADDING-LEFT: 8px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px color :   #1D0E63;"
							vAlign=center noWrap align=middle bgColor=#D3E8FD><strong>Patient
						Details</strong> <%
   	if(patientDetailsList.size() > 0){
   		for(Patient patient : patientDetailsList){
   %>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
		<TR>
			<TD>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" bgColor=#d3e8fd
				border=0>
				<TBODY>
					<TR>
						<TD rowSpan=2><IMG height=7 src="/hms/jsp/images/pt_001.gif"
							width=7></TD>
						<TD width="100%" bgColor=#3c8ad7><IMG height=1
							src="/hms/jsp/images/spacer.gif" width="100%"></TD>
						<TD align=right rowSpan=2><IMG height=7
							src="/hms/jsp/images/pt_007.gif" width=7></TD>
					</TR>
					<TR>
						<TD><IMG height=6 src="/hms/jsp/images/grad_blue_opp.gif"
							width="100%"></TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
	</TBODY>
</TABLE>

<table cellspacing=0 cellpadding=0 width="100%" bgcolor=#d3e8fd border=0>
	<tbody>
		<tr>
			<td width=7 background="/hms/jsp/images/pt_002.gif"><img
				height=1 src="/hms/jsp/images/spacer.gif" width=1></td>
			<td>
			<table cellspacing=0 cellpadding=2 width="100%" border=0>
				<tbody>
					<tr>
						<td
							style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px"
							bgcolor=#ffffff height=1><img height=1
							src="Images/spacer.gif" width=1></td>
					</tr>
					<tr bgcolor=#d3e8fd>
						<td height="10" align=left valign=center
							style="BORDER-LEFT: #ffffff 1px solid"></td>
					</tr>
					<tr>
						<td
							style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px"
							bgcolor=#3c8ad7 height=1><img height=1
							src="/hms/jsp/images/spacer.gif" width=1></td>
					</tr>
					<tr valign=top bgcolor=#ffffff>
						<td valign=center align=middle colspan=2 bgcolor="#f4f9fe">

						<div><label class="bodytextB">Visit No:</label> <%
	    if(patient.getCurrentVisitNo() != null)
	    {
	    	
	    %> <span class="wardspan"> <%=patient.getCurrentVisitNo()%></span>
						<%
	       }else
	       {
	    %> <span class="wardspan"> -</span> <%
	       }
	    %> <label class="bodytextB">Patient Name:</label> <%
			if(patient.getPFirstName() != null)
			{
		%> <span class="wardspan"> <%= patient.getPFirstName() %> <%= patient.getPLastName()%></span>
						<%
		}%> <label class="bodytextB">Age:</label> <span class="wardspan">
						<%=patient.getAge() %></span> <label class="bodytextB">Sex:</label> <span
							class="wardspan"> <%=patient.getSex().getAdministrativeSexName() %></span>


						<br />
						<label class="bodytextB">Service Person Name:</label> <%
			if(patient.getSFirstName() != null)
			{
		%> <span class="wardspan"> <%= patient.getSFirstName() %> <%= patient.getSLastName()%></span>
						<%
		}else{
		%> <span class="wardspan"> -</span> <%} %> <label class="bodytextB">Service
						Type:</label> <%
	    if(patient.getServiceType()!= null){
	    %> <span class="wardspan"> <%=patient.getServiceType().getServiceTypeName() %></span>
						<%
		   }else{
		%> <span class="wardspan"> -</span> <%} %> <label class="bodytextB">Service
						Status:</label> <%if(patient.getServiceStatus() != null){%> <span
							class="wardspan"> <%=patient.getServiceStatus().getServiceStatusName() %></span>
						<%}else{ %> <span class="wardspan"> -</span> <%} %> <label
							class="bodytextB">Relation:</label> <%if(patient.getNextOfKinRelation() != null){%>
						<span class="wardspan"> <%=patient.getNextOfKinRelation().getRelationName() %></span>
						<%}else{ %> <span class="wardspan"> -</span> <%} %> <br />

						<%} 
		}%>
						</div>
						</td>
					</tr>
					<input type=hidden value=0 name=pagecounter2>
			</table>
			</td>

			<td width=7 background="/hms/jsp/images/pt_005.gif"><img
				height=1 src="/hms/jsp/images/spacer.gif" width=1></td>
		</tr>
		<tr>
			<td rowspan=2><img height=7 src="/hms/jsp/images/pt_003.gif"
				width=7></td>
			<td
				style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px"
				bgcolor=#ffffff><img height=6 src="/hms/jsp/images/pt_006.gif"
				width="100%"></td>
			<td rowspan=2><img height=7 src="/hms/jsp/images/pt_004.gif"
				width=7></td>
		</tr>
		<tr>
			<td
				style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px"
				bgcolor=#3c8ad7><img height=1 src="/hms/jsp/images/spacer.gif"
				width="100%"></td>
		</tr>
	</TBODY>
</table>
<script type="text/javascript">
		<%
			int counter1 = 0;
			for (MasMainChargecode mainChargecode : mainChargeCodeList)
			{
				for (MasSubChargecode subChargecode : subChargeCodeList) 
				{
					if(subChargecode.getMainChargecode() != null){
						if(mainChargecode.getId().equals(subChargecode.getMainChargecode().getId() )){
								%>
									subChargeArray[<%=counter1%>] = new Array();
									subChargeArray[<%=counter1%>][0]=<%=mainChargecode.getId()%>;
									subChargeArray[<%=counter1%>][1] = <%=subChargecode.getId()%>;									
									subChargeArray[<%=counter1%>][2] = "<%=subChargecode.getSubChargecodeName()%>";
								<%
								counter1++;
						}
					}
				}
			}
			
		%>
		
		<%
			int counter = 0;
				for (MasSubChargecode subChargecode : subChargeCodeList) 
				{
					for (MasChargeCode masChargeCode : chargeCodeList)
					{
					if(masChargeCode.getSubChargecode() != null){
						if(subChargecode.getId().equals(masChargeCode.getSubChargecode().getId() )){
								%>
									chargeArray[<%=counter%>] = new Array();
									chargeArray[<%=counter%>][0]=<%=subChargecode.getId()%>;
									chargeArray[<%=counter%>][1] = <%=masChargeCode.getId()%>;									
									chargeArray[<%=counter%>][2] = "<%=masChargeCode.getChargeCodeName()%>";
								<%
								counter++;
						}
					}
				}
			}
			
		%>
		</script> <input type="hidden" name="pageNo" value="<%=pageNo%>" /> <br />
<label class="bodytextB">Main Charge:</label> <span class="wardspan">
<select name="<%=MAIN_CHARGECODE_ID %>"
	onchange="populateSubCharge(this.value,'search');showChargeCodePopUp(this.value,this.name);">
	<option value="0">Select</option>
	<%
				for(MasMainChargecode mainChargecode : mainChargeCodeList){
			%>
	<option value="<%=mainChargecode.getId() %>"><%=mainChargecode.getMainChargecodeName() %></option>
	<%}%>
</select></span> <label class="bodytextB">Sub Charge:</label> <span class="wardspan">
<select name="<%=SUB_CHARGECODE_ID %>"
	onchange="populateCharge(this.value,'search');showChargeCodePopUp(this.value,this.name);">
	<option value="0">Select</option>
	<%
				for(MasSubChargecode subChargecode : subChargeCodeList){
			%>
	<option value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>
	<%}%>
</select></span> <label class="bodytextB">Charge:</label> <span class="wardspan">
<select id="selectChargeCodeId" name="<%=CHARGE_CODE_ID %>"
	onchange="populateAmt(this.value,'search');setChargeCode('search');">
	<option value="0">Select</option>
	<%
				for(MasChargeCode chargecode : chargeCodeList){
			%>
	<option value="<%=chargecode.getId() %>"><%=chargecode.getChargeCodeName() %></option>
	<%}%>
</select></span> <script type="text/javascript">
		<%
			int count = 0;
					for (MasChargeCode masChargeCode : chargeCodeList)
					{
					%>
									amtArray[<%=count%>] = new Array();
									amtArray[<%=count%>][0]=<%=masChargeCode.getId()%>;
									amtArray[<%=count%>][1] = <%=masChargeCode.getCharge()%>;									
								
								<%
								count++;
					}
		%>
		</script> <input type="hidden" id="amountId" name="amount" value="" /> <br />
</div>


<div style="overflow: auto; height: 260px; padding-left: 9px;">
<p>
<table width="100%" colspan="7" id="chargeDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="3%">
			<div align="left"><font valign="left" class="gridsmlabel">SR
			No</font></div>
			</td>
			<td width="10%">
			<div align="left"><font valign="left" class="smalllabel">Charge
			Code</font></div>
			</td>
			<td width="7%">
			<div align="left"><font valign="left" class="smalllabel">Qty</font>
			</div>
			</td>
			<td width="7%">
			<div align="left"><font valign="left" class="smalllabel">Amount</font>
			</div>
			</td>
			<td width="7%">
			<div align="left"><font valign="left" class="smalllabel">Discount
			Amount</font></div>
			</td>
			<td width="7%">
			<div align="left"><font valign="left" class="smalllabel">Net
			Amount</font></div>
			</td>

		</tr>
	</thead>


	<tbody>
		<%
    	int detailCounter=5; 
    	int temp=0;
    	    	
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	} %>

	</tbody>
</table>

</p>
<table width="100%" colspan="7" id="totalDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
</table>

</div>

