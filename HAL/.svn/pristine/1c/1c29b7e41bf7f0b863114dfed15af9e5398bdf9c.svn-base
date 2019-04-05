<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * indentS.jsp  
 * Purpose of the JSP -  This is for indentS.
 * @author  Mansis
 * @author  Deepali
 * Create Date: 21th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@page import="jkt.hms.util.RequestConstants"%>

<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.List"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>

<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.StringTokenizer"%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />

<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

<%--For AutoComplete--%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<%
	System.out.print("INdent TO SOC");
	String patientDetails=""; 
	int itemReqDept=0;
	String pacEqpt="";
	String pacJustification="";
	int dose=0;
	int days=0;
	int course=0;
	int duration=0;
	int durationType=0;
	String PvmsAlreadyPrescribed="";
	String justificationNiv="";
	String clinicalTrailReq="";
	
	
	
	Map map = new HashMap();
	String includedJsp = null;
	String userName="";
	int pageNo=1;
	int indentId=0;
	String date="";
	String time="";
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList= new ArrayList<MasStoreSection>();
		List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
		List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
		String  maxIndentNo="";
		try{
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if(map.get("indentId")!=null){
		indentId=Integer.parseInt(""+map.get("indentId"));
		System.out.print("  indentId    "+indentId);
	}
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
		System.out.println("pageNo  -----------------------                  "+pageNo);
	}

	//Header Information
	if(map.get("patientDetails")!=null)
		patientDetails=(""+map.get("patientDetails"));
	
	if(map.get("itemReqDept")!=null)
		itemReqDept=Integer.parseInt((""+map.get("itemReqDept"))) ;

	if(map.get("pacEqpt")!=null)
		pacEqpt=(""+map.get("pacEqpt"));

	if(map.get("pacJustification")!=null)
		pacJustification=(""+map.get("pacJustification"));

	if(map.get("dose")!=null)
		dose=Integer.parseInt((""+map.get("dose"))) ;

	if(map.get("days")!=null)
		days=Integer.parseInt((""+map.get("days"))) ;

	if(map.get("course")!=null)
		course=Integer.parseInt((""+map.get("course"))) ;

	if(map.get("duration")!=null)
		duration=Integer.parseInt((""+map.get("duration"))) ;

	if(map.get("durationType")!=null)
		days=Integer.parseInt((""+map.get("durationType"))) ;

	if(map.get("PvmsAlreadyPrescribed")!=null)
		PvmsAlreadyPrescribed=((""+map.get("PvmsAlreadyPrescribed"))) ;
	
	if(map.get("justificationNiv")!=null)
		justificationNiv=((""+map.get("justificationNiv"))) ;
	
	if(map.get("clinicalTrailReq")!=null)
		clinicalTrailReq=((""+map.get("clinicalTrailReq"))) ;

	
	//End of Header Information 
	if(map.get("maxIndentNo")!=null)
		maxIndentNo=(""+map.get("maxIndentNo"));
	
	if(map.get("sectionList")!=null)
	sectionList=(List) map.get("sectionList");
	if(map.get("departmentList")!=null)
		departmentList=(List) map.get("departmentList");
	if(map.get("searchIndentList")!=null)
	searchIndentList = (List) map.get("searchIndentList");
	if(map.get("itemList")!=null)
		itemList=(List) map.get("itemList");
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	 if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	 Set set=new HashSet();
	 String indentNo="";
	 
	 if(map.get("indentNo")!=null)
			indentNo=""+map.get("indentNo");
	 
		}catch(Exception ee){ee.printStackTrace();}
%>
<script type="text/javascript">
	var nameArray=new Array();
	var itemsArray=new Array();
</script>
<%int k=0;
  					if(itemList.size()>0)
 						for (MasStoreItem masStoreItem:itemList){
			 			%>
<script>
         		 
         		itemsArray[<%=k%>]= new Array();
         		itemsArray[<%=k%>][0] = "<%=masStoreItem.getId()%>";
				itemsArray[<%=k%>][1] = "<%=masStoreItem.getPvmsNo()%>";
				<%StringBuffer output_str = new StringBuffer();
				StringTokenizer s = new StringTokenizer(masStoreItem.getNomenclature().toString(),"\""); 
				
				while (s.hasMoreTokens())
				{
					output_str.append(s.nextToken());
					if (s.hasMoreTokens())
					{
					output_str.append("\\");
			 	        output_str.append("\"");
					}
				}
			
				%>
				<%
				if(masStoreItem.getStrength()!=null){
				%>
				nameArray[<%=k%>]="<%=output_str.toString()+masStoreItem.getStrength()%>"
				itemsArray[<%=k%>][2]="<%=output_str.toString()+masStoreItem.getStrength()%>"
				<%}else{%>
				nameArray[<%=k%>]="<%=output_str.toString()%>"
				itemsArray[<%=k%>][2]="<%=output_str.toString()%>"
				<%}%>
				
				itemsArray[<%=k%>][3] = "<%=masStoreItem.getItemConversion().getItemUnitName()%>";
         		itemsArray[<%=k%>][4] = "<%=masStoreItem.getSection().getSectionName()%>";
         		itemsArray[<%=k%>][5] = "<%=masStoreItem.getSection().getId()%>";
         		
         		</script>
<% k++;} %>

<div id="contentspace">

<form name="indent" method="post"><br />
<h2 align="left" class="style1">Indent To DGAFMS in the form of SOC</h2>
<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>


		<table width="20%" align="right" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Add" type="submit" value="Add"
					class="toolbutton"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"
					onClick="submitForm('poMain','purchaseOrder?method=poModifyJsp');"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Reset" type="submit" value="Reset"
					class="toolbutton"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" value="Delete"
					class="toolbutton"></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="print" type="submit" class="toolbutton"
					value="Print"
					onClick="submitForm('indent','stores?method=showPrintIndentSocJsp');""></td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>



<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form name="searchPanel" method="post">
<table cellpadding="4" cellspacing="1" border="0">
	<tr>
		<td class="thead">Search Panel<a name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><input type="hidden"
			name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> <input
			type="hidden" name="do" value="process" /> <input type="hidden"
			name="searchthread" value="1" /> <input type="hidden"
			name="showposts" value="1" /> <input type="hidden"
			name="searchthreadid" value="85875" /> <label class="bodytextB_blue">Indent
		No:</label> <select name="<%= RequestConstants.INDENT_NO_FOR_SEARCH%>">
			<option value="0">Select</option>
			<%
					for (StoreIndentM storeIndentM :searchIndentList ) {
				%>

			<option value=<%=storeIndentM.getId()%>><%=storeIndentM.getIndentNo()%></option>

			<%
					}
				%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('indent','stores?method=searchIndentSOC');" /></td>
	</tr>

</table>
</form>
</div>
</div>
</div>
<jsp:include page="searchResultPO.jsp" /> <br />
</form>

<form name="indentGrid" method="post">


<div id="testDiv" size="height:500px;"><input type="hidden"
	name="pageNo" value="<%=pageNo%>" /> <label class="bodytextB_blue"><font
	id="error"></font> Indent No: </label> <input type="text"
	name="<%=RequestConstants.INDENT_NO %>" value="<%=maxIndentNo%>"
	readonly="readonly" class="textbox_size20" MAXLENGTH="8"/  > <label
	class="bodytextB_blue"><font id="error"></font>Date of SOC :</label> <input
	type="text" name="<%=RequestConstants.INDENT_DATE%>"
	readonly="readonly" value="<%=date%>" class="textbox_size20"
	MAXLENGTH="30" /> <br />
<label class="bodytextB_blue"><font id="error"></font>Command:</label> <input
	type="text" readonly="readonly"
	name="<%=RequestConstants.INDENT_FROM %>" value="CHAF,Bangalore"
	class="textbox_size20" MAXLENGTH="20" /> <label class="bodytextB_blue"><font
	id="error"></font>Hospital/Unit Address:</label> <input type="text"
	readonly="readonly" name="<%=RequestConstants.INDENT_FROM %>"
	value="CHAF,Bangalore" class="textbox_size20" MAXLENGTH="20" /> <br />
<label class="bodytextB_blue"><font id="error"></font>Item Dept:</label>
<select name="<%= RequestConstants.DEPARTMENT_ID_TEMP%>"
	validate="Item Dept,String,yes">
	<option value="0">Select</option>
	<%for(MasDepartment department:departmentList){ %>
	<option value="<%=department.getId() %>"><%=department.getDepartmentCode() %></option>
	<%} %>
</select> <br />
<label class="bodytextB_blue"><font id="error"></font>Details:</label> <textarea
	name="<%=RequestConstants.DETAIL_OF_PATIENT%>" cols="27" rows="2"
	validate="Patiet Details ,String,yes"></textarea> <label
	class="bodytextB_blue"><font id="error"></font>Indent To:</label> <input
	type="text" readonly="readonly"
	name="<%=RequestConstants.DEPARTMENT_ID %>" value="DGFMSHQ"
	class="textbox_size20" MAXLENGTH="30" /> <br />



<br />
<br />
<br />
<input type="button" class="button" value="Next" onclick=""
	align="right" /> <input type="button" name="sss" align="right"
	class="button" value="Submit"
	onclick="if(checkForSubmit()){submitForm('indentGrid','stores?method=addNextOrSubmitIndentToSOC&buttonName=submit');}" />
Page No:<%=pageNo%> <input type="hidden" name="" value="222"
	id="currentRow" /> <input type="hidden" size="2" value="0"
	name="<%=RequestConstants.NO_OF_ROWS %>"
	id="<%=RequestConstants.NO_OF_ROWS %>" /> <input type="hidden"
	name="<%=RequestConstants.INDENT_ID %>" value="<%=indentId%>" id="hdb" />
<br />
<fieldset style="width: 99%; padding-left: 9px;"><legend>Indent
details</legend>


<div
	style="overflow: auto; width: 100%; height: 260px; padding-left: 9px;">
<table width="200px" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<td width="5%"><label valign="left" class="gridsmlabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="13%"><label valign="left" class="gridsmlabel">A/U</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">Stock
			in</label></td>
			<td width="3%">&nbsp;</td>
		</tr>

	</thead>
	<tbody>

		<td width="10%">
		<%
    	
    	int temp=0;
    	int detailCounter=8; 
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idSection="idSection";
    	String nameSection="nameSection";
    	String idAu="idAu";
    	
    	String stockInVar="stockInVar";
    	String mmfVar="mmfVar";
    	String demandVar="demandVar";
    	
    	String stockInVarTemp="stockInVarTemp";
    	String mmfVarTemp="mmfVarTemp";
    	String demandVarTemp="demandVarTemp";
    	String incVar="incVar";
    	String qtyInHandTemp="qtyInHandTemp";
    	String qtyInHand="qtyInHand";
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idSection2="idSection";
    	String nameSection2="nameSection";
    	String idAu2="idAu";
    	
    	String stockInVar2="stockInVar";
    	String mmfVar2="mmfVar";
    	String demandVar2="demandVar";

    	String stockInVarTemp2="stockInVarTemp";
    	String mmfVarTemp2="mmfVarTemp";
    	String demandVarTemp2="demandVarTemp";
    	String incVar2="incVar2";
    	
    	
    	String unitRate="unitRate";
    	String brandId="brandId";
    	String lastRecpDate="lastRecpDate";
    	String lastRecpQty="lastRecpQty";
    	String totalCost="totalCost";
    	String markBy="markBy";
    	
    	String unitRate2="unitRate";
    	String brandId2="brandId";
    	String lastRecpDate2="lastRecpDate";
    	String lastRecpQty2="lastRecpQty";
    	String totalCost2="totalCost";
    	String markBy2="markBy";
    	String qtyInHandTemp2="qtyInHandTemp";
    	String qtyInHand2="qtyInHand";
    	String manuId="manuId";
    	String manuId2="manuId";
    	
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=detailCounter;inc++){
     		 System.out.println("1111111111111");
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idSection=idSection2+(""+inc);
     		nameSection=nameSection2+(""+inc);
     		idAu=idAu2+(""+inc);
     		
     		stockInVar=stockInVar2+(""+inc);
     		mmfVar=mmfVar2+(""+inc);
     		demandVar=demandVar2+(""+inc);
     		
     		manuId=manuId2+(""+inc);
     		stockInVarTemp=stockInVarTemp2+(""+inc);
     		mmfVarTemp=mmfVarTemp2+(""+inc);
     		demandVarTemp=demandVarTemp2+(""+inc);
     		incVar=incVar2+(""+inc);
     		
     		
     		 unitRate=unitRate2+(""+inc);
        	 brandId=brandId2+(""+inc);
        	 lastRecpDate=lastRecpDate2+(""+inc);
        	 lastRecpQty=lastRecpQty2+(""+inc);
        	 totalCost=totalCost2+(""+inc);
        	 markBy=markBy2+(""+inc);
        	 
        	 qtyInHandTemp=qtyInHandTemp2+(""+inc);
     		qtyInHand=qtyInHand2+(""+inc);
     		
     	System.out.println("unitRate  "+unitRate);
    	  %>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=RequestConstants.SR_NO%>"
				readonly="readonly" /></td>
			<td width="10%"><input type="text" class="medcaption"
				name="<%=RequestConstants.ITEM_CODE %>" readonly="readonly"
				id="<%=codeItem%>" /> <input type="hidden" size="2" value="0"
				class="smcaption" name="<%=RequestConstants.ITEM_ID%>"
				id="<%=idItem%>" /></td>
			<td width="10%"><input type="text" value="" id="<%=nameItem%>"
				class="bigcaption" name="<%=RequestConstants.NOMENCLATURE%>"
				onblur="fillItemsInSOC(this.value,<%=inc%>);" /></td>
			<script>
		var obj = actb(document.getElementById('<%=nameItem%>'),nameArray);
		</script>
			<td width="10%"><input type="text" value="" class="smcaption"
				readonly="readonly" name="<%=RequestConstants.AV%>" id="<%=idAu%>" /></td>


			<td width="10%"><input type="text" readonly="readonly" value=""
				class="medcaption" name="" id="<%=qtyInHandTemp%>"
				validate="Qty In Stock,num,no" /> <input type="hidden" value="0"
				class="medcaption" name="<%=RequestConstants.QTY_IN_HAND%>"
				id="<%=qtyInHand%>" /></td>






			<td width="3%"><input type="hidden" value="0"
				name="<%=RequestConstants.UNIT_RATE %>" id="<%=unitRate %>" /> <input
				type="hidden" value="0" name="<%=RequestConstants.BRAND_ID %>"
				id="<%=brandId %>" /> <input type="hidden" value="0"
				name="<%=RequestConstants.MANUFACTURER_ID %>" id="<%=manuId %>" /> <input
				type="hidden" value="0" name="<%=RequestConstants.MARKETED_BY %>"
				id="<%=markBy %>" /> <input type="hidden" value="0"
				name="<%=RequestConstants.TOTAL_COST %>" id="<%=totalCost %>" /> <input
				type="hidden" value="0" name="<%=RequestConstants.LAST_RECP_QTY %>"
				id="<%=lastRecpQty %>" /> <input type="hidden" value="0"
				name="<%=RequestConstants.LAST_RECP_DATE %>" id="<%=lastRecpDate %>" />
			<input type="text" onclick="get_value(<%=inc %>);" name="Submit2"
				value="" class="morebutton" /></td>
		</tr>
		<%   } %>
		
	</tbody>

</table>
</fieldset>


</div>
<label class="bodytextB_blue"><font id="error"></font>PAC Eqpt</label> <select
	name="<%= RequestConstants.PAC%>" validate="PAC ,String,yes">
	<option value="">Select</option>
	<option value="NA">NA</option>
	<option value="Yes">Yes</option>
</select> <label class="bodytextB_blue"><font id="error"></font>If PAC,
General Detail justification:</label> <textarea
	name="<%=RequestConstants.PAC_JUSTIFICATION%>" rows="2" cols="30"
	validate="If PAC, General Detail justification ,num,yes"></textarea> <br />


<div style="float: left; width: 180px;"><span class="bodytextB">Dose
(for drugs) Day/ Course:</span></div>
<div style="float: left;"><input type="text"
	name="<%=RequestConstants.DOSE %>" class="smcaption"
	validate="Dose ,num,yes" /></div>
<div style="float: left;"><font class="wardspan">For</font></div>
<div style="float: left;"><input
	name="<%=RequestConstants.DAYS %>" class="smcaption"
	validate="Days ,num,yes" /></div>
<div style="float: left;"><font class="wardspan">Days</font></div>
<div style="float: left;"><input
	name="<%=RequestConstants.COURSE %>" class="smcaption"
	validate="Corse ,num,yes" /></div>
<div style="float: left;"><font class="wardspan">Course</font></div>
<div style="float: left;"><input
	name="<%=RequestConstants.DURATION%>" class="smcaption"
	validate="Duration ,num,yes" /></div>
<div style="float: left;"><select
	name="<%= RequestConstants.DURATION_TYPE%>"
	validate="Duration Type,String,yes">
	<option value="0">Select</option>
	<option value="Yearly">Yearly</option>
	<option value="Monthly">Monthly</option>
	<option value="Weekly">Weekly</option>
	<option value="Others">Others</option>

</select></div>


<br />

<br />
<br />
<br />
<label class="bodytextB_blue"><font id="error"></font>PVMS / NIV
drugs substitute already prescribed:</label> <textarea
	name="<%=RequestConstants.PVMS_ALREADY_PRESCRIBED%>" rows="2" cols="30"
	validate="PVMS / NIV drugs substitute already prescribed,String,yes"></textarea>
<br />
<br />
<label class="bodytextB_blue"><font id="error"></font>Justification
of using NIV item:</label> <textarea
	name="<%=RequestConstants.JUSTIFICATION_NIV  %>" rows="2" cols="25"
	validate="Justification of using NIV item,String,yes"></textarea> <br />
<br />
<br />
<label class="bodytextB_blue"><font id="error"></font>DClinical
:</label> <select name="<%= RequestConstants.CLINICAL_TRAIL_REQ%>"
	validate="Clinical,String,yes">
	<option value="">Select</option>
	<option value="Y">Yes</option>
	<option value="N">No</option>
</select> <br />
<br />
<span class="bodytextB_blue">Changed By:</span> <input type="text"
	name="<%=RequestConstants.CHANGED_BY%>" value="<%=userName%>"
	class="textbox_size20" readonly="readonly" MAXLENGTH="8" / tabindex=3 />

<span class="bodytextB_blue"> Changed Date:</span> <input type="text"
	name="<%=RequestConstants.CHANGED_DATE %>" value="<%=date%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /> <span
	class="bodytextB_blue">Changed Time:</span> <input type="text"
	name="<%=RequestConstants.CHANGED_TIME %>" value="<%=time%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /></form>

<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script></div>
</form>

</div>
