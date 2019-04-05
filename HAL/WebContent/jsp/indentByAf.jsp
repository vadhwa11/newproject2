<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * indentByAf.jsp  
 * Purpose of the JSP -  This is for indent By AF.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 05th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.6
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%
	Map map = new HashMap();
	String includedJsp = null;
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList= new ArrayList<MasStoreSection>();
		List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
		int maxIndentNo=0;
		
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if(map.get("maxIndentNo")!=null)
		maxIndentNo=Integer.parseInt(""+map.get("maxIndentNo"));
	if(map.get("sectionList")!=null)
	sectionList=(List) map.get("sectionList");
	if(map.get("searchIndentList")!=null)
	searchIndentList = (List) map.get("searchIndentList");
	if(map.get("itemList")!=null)
		itemList=(List) map.get("itemList");
%>
<%
	StringBuffer orderDateOnly = new StringBuffer();
	GregorianCalendar gregorianCalendar1 = new GregorianCalendar();

	int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
	if (dateOfMonth < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(dateOfMonth);
	} else {
		orderDateOnly.append(dateOfMonth);
	}

	orderDateOnly.append("/");

	int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (month < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(month);
	} else {
		orderDateOnly.append(month);
	}

	orderDateOnly.append("/");
	int year = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year);
	String currentDate = new String(orderDateOnly);
	int pageNo=1;
	int indentId=0;
%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<input type="hidden" name="pageNo" value="<%=pageNo%>" />
<input type="hidden" name="pageNo" value="<%=pageNo%>" />
<label class="bodytextB_blue"><font id="error"></font> Indent
No: </label>
<input type="text" name="<%=RequestConstants.INDENT_NO %>"
	value="<%=maxIndentNo%>" readonly="readonly" class="textbox_size20"
	MAXLENGTH="8"/  >

<label class="bodytextB_blue"><font id="error"></font>Indent
From:</label>
<input type="text" readonly="readonly"
	name="<%=RequestConstants.INDENT_FROM %>" value="Airforce,Bangalore"
	class="textbox_size20" MAXLENGTH="20" />
<label class="bodytextB_blue"><font id="error"></font>Indent
Date:</label>
<input type="text" name="<%=RequestConstants.INDENT_DATE%>"
	readonly="readonly" value="<%=currentDate %>" class="textbox_size20"
	MAXLENGTH="30" />
<br />
<label class="bodytextB_blue"><font id="error"></font>Indent To:</label>
<select name="<%= RequestConstants.INDENT_TO%>">
	<option value="0">Select</option>
	<%
				for (MasStoreSection storeSection :sectionList ) {
			%>

	<option value=<%=storeSection.getSectionName()%>><%=storeSection.getSectionName()%></option>

	<%
				}
			%>
</select>
<label class="bodytextB_blue"><font id="error"></font>Type of
Indent:</label>

<select name="<%= RequestConstants.TYPE_OF_INDENT%>"
	validate="Type Of Indent,Strinf,yes">
	<option value="0">Select</option>
	<option value="1">Monthly</option>
	<option value="2">Yearly</option>

</select>
<label class="bodytextB_blue"><font id="error"></font>NRS:</label>
<input type="text" name="<%= RequestConstants.NRS %>" value=""
	class="textbox_size20" MAXLENGTH="30" validate="NRS,num,yes" />
<input type="hidden" name="<%=RequestConstants.NO_OF_ROWS%>" id="rr"
	value="22" />


<br />
<input type="hidden" class="button" value="Add Row"
	onclick="generateRow();" align="right" />
<input type="hidden" class="button" value="Remove Row"
	onclick="removeRow(this)" align="right" />
<input type="button" class="button" value="Previous" disabled="disabled"
	onclick="submitForm('indentGrid','stores?method=previousIndent');"
	align="right" />
<input type="button" class="button" value="Next"
	onclick="if(checkForNext()){submitForm('indentGrid','stores?method=nextIndent');}"
	align="right" />
<input type="button" name="sss" align="right" class="button"
	value="Submit"
	onclick="if(checkForSubmit()){submitForm('indentGrid','stores?method=submitIndent');}" />
Page No:<%=pageNo%>

<input type="text" size="2" value="0" name="noOfRecords"
	id="noOfRecords" />
<input type="hidden" name="<%=RequestConstants.INDENT_ID %>"
	value="<%=indentId%>" id="hdb" />
<br />
<fieldset style="width: 99%; padding-left: 9px;"><legend>Indent
details</legend>


<div
	style="overflow: auto; width: 100%; height: 260px; padding-left: 9px;">
<table width="200px" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<td width="5%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">Section</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Stock
			in</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Qty
			in MMF</label></td>
			<td width="6%"><label valign="left" class="smalllabel">Qty
			Demand</label></td>

		</tr>

	</thead>
	<tbody>

		<td width="10%">
		<%
    	int detailCounter=10; 
    	int temp=0;
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
    	
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=10;inc++){
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idSection=idSection2+(""+inc);
     		nameSection=nameSection2+(""+inc);
     		idAu=idAu2+(""+inc);
     		
     		stockInVar=stockInVar2+(""+inc);
     		mmfVar=mmfVar2+(""+inc);
     		demandVar=demandVar2+(""+inc);
     		

     		stockInVarTemp=stockInVarTemp2+(""+inc);
     		mmfVarTemp=mmfVarTemp2+(""+inc);
     		demandVarTemp=demandVarTemp2+(""+inc);
     		incVar=incVar2+(""+inc);
    	  %>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=RequestConstants.SR_NO%>"
				readonly="readonly" /></td>
			<td width="10%"><select name="<%= RequestConstants.ITEM_CODE%>"
				onchange="fillItems(this.value,this.id)" id="<%=inc%>">
				<option value="0">Select</option>
				<%
					for (MasStoreItem masStoreItem :itemList ) {
				%>

				<option value=<%=masStoreItem.getId()%>><%=masStoreItem.getPvmsNo()%></option>

				<%
					}
				%>

				<input type="hidden" size="2" value="0" class="smcaption"
					name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" /></td>
			<td width="10%"><input type="text" value="" id="<%=nameItem%>"
				class="bigcaption" readonly="readonly"
				name="<%=RequestConstants.NOMENCLATURE%>" /></td>
			<td width="10%"><input type="text" value="" class="smcaption"
				readonly="readonly" name="<%=RequestConstants.AV%>" id="<%=idAu%>" /></td>
			<td width="10%"><input type="text" value="" class="medcaption"
				readonly="readonly" name="<%=RequestConstants.SECTION%>"
				id="<%=nameSection%>" /> <input type="hidden" value="4"
				class="medcaption" readonly="readonly"
				name="<%=RequestConstants.SECTION_ID%>" id="<%=idSection%>" /></td>
			<td width="10%"><input type="text" value="" class="medcaption"
				name="<%=RequestConstants.STOCK_IN_TEMP%>" id="<%=stockInVarTemp %>"
				tabindex="2" /> <input type="hidden" value="0" class="medcaption"
				name="<%=RequestConstants.STOCKING%>" tabindex="2"
				id="<%=stockInVar%>" /></td>
			<td width="10%"><input type="text" value="" class="medcaption"
				name="<%=RequestConstants.QTY_IN_MMF_TEMP%>" tabindex="2"
				id="<%=mmfVarTemp%>" /> <input type="hidden" value="0"
				class="medcaption" name="<%=RequestConstants.QTY_IN_MMF%>"
				tabindex="2" id="<%=mmfVar%>" /></td>
			<td width="3%"><input type="text" class="medcaption" value=""
				name="<%=RequestConstants.QTY_DEMAND_TEMP%>" tabindex="2"
				id="<%=demandVarTemp%>" onblur="fillValues(<%=inc%>);" /> <input
				type="hidden" class="medcaption" value="0"
				name="<%=RequestConstants.QTY_DEMAND%>" tabindex="2"
				id="<%=demandVar%>" /></td>
		</tr>
		<%   } %>
		
	</tbody>

</table>
</fieldset>

