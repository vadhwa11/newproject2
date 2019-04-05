<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemBrandWindow.jsp  
 * Purpose of the JSP -  This is for Item Brand Window.
 * @author  Vivek
 * @author  Deepti
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />

<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<%
	Map map = new HashMap();
	Box box=HMSUtil.getBox(request);
	int itemId=0;
	String qtyRequested="";
	String Nomenclature = "";
	int rowVal=0;
	int issuedItemId=0;
	int issueId=0;
	int detailId=0;
	List<MasStoreBrand> masStoreBrandList= new ArrayList<MasStoreBrand>();
	List<MasStoreItem> masStoreItemList= new ArrayList<MasStoreItem>();
	MasStoreItem masStoreItem = new MasStoreItem();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	if(map.get("masStoreBrandList")!=null){masStoreBrandList = (List) map.get("masStoreBrandList");}
	
	if(map.get("masStoreItemList")!=null)
	{
		masStoreItemList = (List) map.get("masStoreItemList");
		if (masStoreItemList!=null && masStoreItemList.size()> 0)
		{
			masStoreItem = masStoreItemList.get(0);
			Nomenclature = masStoreItemList.get(0).getNomenclature();
		}
	}
	
	if(map.get("qtyRequested")!=null){qtyRequested = (""+map.get("qtyRequested"));}
	if(map.get("itemId")!=null){itemId = Integer.parseInt(""+map.get("itemId"));}
	if(map.get("rowVal")!=null){rowVal = Integer.parseInt(""+map.get("rowVal"));}
	if(map.get("issueId")!=null){issueId = Integer.parseInt(""+map.get("issueId"));}
	if(map.get("detailId")!=null){detailId = Integer.parseInt(""+map.get("detailId"));}
	
	String date="";
	String time="";
	String userName="";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		 date = (String)utilMap.get("currentDate");	 
		 time = (String)utilMap.get("currentTime");
		 if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
	%>
<script type="text/javascript">
	function cancelForm(){
  	 close();
   	}


</script>
<br />
<h2 align="left" class="style1">Loan Out Issue To Dispensary</h2>
<br>
<h2 align="left" class="style1"><%=Nomenclature%></h2>

<title>Loan Out Issue To Dispensary</title>
<div id="contentspace">
<div style="padding-left: 15px;"><br />
<form name="itemBrandForm" method="post">
<%if(masStoreBrandList.size()!=0) { %> <input type="hidden"
	name="<%=RequestConstants.ITEM_ID %>" value="<%=box.get("itemId") %>" />
<input type="hidden" name="<%=RequestConstants.ISSUE_NO %>"
	value="<%=box.get("issueNo") %>" /> <input type="hidden"
	name="<%=RequestConstants.ISSUE_DATE %>"
	value="<%=box.get("isssueDate") %>" /> <input type="hidden"
	name="<%=RequestConstants.DEPARTMENT_ID_TEMP %>"
	value="<%=box.get("departmentIdTemp") %>" /> <input type="hidden"
	name="<%=RequestConstants.REQUEST_BY %>"
	value="<%=box.get("requestBy") %>" /> <input type="hidden"
	name="<%=RequestConstants.APPROVED_BY %>"
	value="<%=box.get("approvedBy") %>" /> <input type="hidden"
	name="<%=RequestConstants.ISSUED_BY %>"
	value="<%=box.get("issuedBy") %>" /> <input type="hidden"
	name="<%=RequestConstants.DOC_NO %>" value="<%=box.get("docNo") %>" />
<input type="hidden" name="<%=RequestConstants.PATIENT_NAME %>"
	value="<%=box.get("patientName") %>" /> <input type="hidden"
	name="<%=RequestConstants.ISSUE_ID %>" value="<%=box.get("issueId")%>" />


<div
	style="overflow: auto; width: 80%; height: 350px; border: 1px solid #232323;">
<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>

		<tr>

			<td width="5%"><label valign="left" class="smalllabel">Barand
			Name</label></td>
			<td width="13%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="10%"><label valign="left" class="smalllabel">Batch
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Exp
			Date</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Stock
			In</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Qty
			Issued</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Remarks</label></td>


		</tr>

	</thead>
	<tbody>
		<input type="hidden" name="<%=RequestConstants.DETAIL_ID %>"
			value="<%=detailId%>" />
		<input type="hidden" name="<%=RequestConstants.ITEM_ID %>"
			value="<%=itemId%>" />
		<input type="hidden" name="<%=RequestConstants.ISSUED_ITEM %>"
			value="<%=issuedItemId%>" />
		<input type="hidden" name="<%=RequestConstants.ISSUE_ID %>"
			value="<%=issueId%>" />
		<%
  String issuedQty="issuedQty";
  String issuedQty2="issuedQty";
  
  String issuedQtyTemp="issuedQtyTemp";
  String issuedQtyTemp2="issuedQtyTemp";
  
  String remarks="remarks";
  String remarks2="remarks";
  
  String remarksTemp="remarksTemp";
  String remarksTemp2="remarksTemp";
  
  String stockIn="stockIn";
  String stockIn2="stockIn";
	int inc=1;
  try{
	  for (Iterator iterator = masStoreBrandList.iterator(); iterator.hasNext();) {
	  issuedQty=issuedQty2+(""+inc);
	  issuedQtyTemp=issuedQtyTemp2+(""+inc);
	  remarks=remarks2+(""+inc);
	  remarksTemp=remarksTemp2+(""+inc);
	  stockIn=stockIn2+(""+inc);
	  Object[] object = (Object[]) iterator.next();
  %>
		<tr>
			<td width="5%"><input type="hidden"
				name="<%=RequestConstants.BRAND_ID %>" value="<%=object[0]%>" /> <input
				type="text" name="<%=RequestConstants.BRAND_NAME %>"
				class="medcaption" readonly="readonly" value="<%=object[1] %>" /></td>
			<td width="13%"><input type="text"
				name="<%=RequestConstants.AU %>" class="medcaption"
				readonly="readonly"
				value="<%=masStoreItem.getItemConversion().getPurchaseUnit().getUnitName()%>" />
			</td>
			<td width="10%"><input type="text" readonly="readonly"
				class="medcaption1" value="<%=object[2] %>" /> <input type="hidden"
				name="<%=RequestConstants.BATCH_NO %>" class="medcaption"
				value="<%=object[2] %>" /></td>
			<% 
  	 	SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
	 	SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
	 	String date4MySQL ="";
	 	try{
	 	 date4MySQL=formatterOut.format(formatterIn.parse(""+object[3]));
	 	}catch(Exception e){}
	 	%>
			<td width="13%"><input type="text" readonly="readonly"
				class="medcaption" value="<%=date4MySQL %>" /> <input type="hidden"
				name="<%=RequestConstants.EXPIRY_DATE %>" class="medcaption"
				value="<%=date4MySQL %>" /></td>
			<td width="13%"><input value="<%=""+object[4]%>"
				id="<%=stockIn%>" readonly="readonly" /> <input type="hidden"
				value="<%=""+object[5]%>" name="<%=RequestConstants.COST_PRICE %>" />
			</td>
			<td width="13%"><input type="text"
				name="<%=RequestConstants.QTY_ISSUED_TEMP%>" re
				validate='Issued Quantity ,floatWithoutSpaces,no' class="medcaption"
				id="<%=issuedQtyTemp %>"
				onblur="fillQtyIssuedForIssueCiv('<%=inc %>')" /> <input
				type="hidden" name="<%=RequestConstants.QTY_ISSUED%>"
				class="medcaption" value="0" id="<%=issuedQty %>" /></td>
			<td width="13%"><input type="text"
				name="<%=RequestConstants.REMARKS_TEMP%>" id="<%=remarksTemp %>"
				class="medcaption" validate='Remarks,String,no'
				onchange="fillRemarksForIssueCiv('<%=inc %>')" /> <input
				type="hidden" name="<%=RequestConstants.REMARKS%>"
				value="emptyString" class="medcaption" id="<%=remarks %>" /></td>

			<tr />
				<% inc++;}
  	 }catch(Exception w){w.printStackTrace();}%>
			
	</tbody>
</table>
</div>


<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div id="edited"></div>
<input id="save" property="save" type="button" name="save" value="Save"
	class="button"
	onclick="if(submitFormSOC('itemBrandForm','')&&setTotalQty(<%=inc%>,<%=rowVal%>)){submitForm('itemBrandForm','/hms/hms/stores?method=addBrandDetailsForLoanOut');}" />
<%}else{ %>
<h2><font id="error">Records not Found</font></h2>
<br />
<%} %> <input type="button" name="cancel" tabindex="1" id="addbutton"
	value="Cancel" class="button" onClick="cancelForm();" accesskey="a"
	tabindex=1 /></form>
</div>