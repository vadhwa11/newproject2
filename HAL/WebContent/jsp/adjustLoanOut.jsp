<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * adjustLoanOut.jsp  
 * Purpose of the JSP -  This is for adjust the items that are given based on loan out
 * Table  store_issue_m
 * @author  Vivek
 * Create Date: 18th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>
<%
	Map map = new HashMap();
	List<StoreIssueT> storeIssueTList=new ArrayList<StoreIssueT>();
	int issueMId = 0;
	int toStoreId = 0;
	int srNo=1;
	int internalIndentId=0;
	Box box = null;
	
	
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		if (map.get("box") != null) {
			box = (Box) map.get("box");
		}
		if(map.get("storeIssueTList")!=null){
			storeIssueTList=(List<StoreIssueT>)map.get("storeIssueTList");
		}
		if(map.get("issueMId")!=null){
			issueMId=Integer.parseInt(""+map.get("issueMId")) ;
		}
		if(map.get("toStoreId")!=null){
			toStoreId=Integer.parseInt(""+map.get("toStoreId")) ;
		}
		if(map.get("internalIndentId")!=null){
			internalIndentId=Integer.parseInt(""+map.get("internalIndentId")) ;
		}
		
		
		
%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<%@page import="jkt.hms.masters.business.StoreIssueT"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.util.Box"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<div id="contentspace">
<form name="loanOut" method="post"><br />
<h2 align="left" class="style1">Adjust Loan Out</h2>



<%if(storeIssueTList.size()!=0){ %> <input
	name="<%=RequestConstants.ISSUE_ID%>" value="<%=issueMId%>"
	type="hidden" /> <input
	name="<%=RequestConstants.DEPARTMENT_ID_TEMP%>" value="<%=toStoreId%>"
	type="hidden" />
<div
	style="overflow: auto; width: 74%; height: 300px; padding-left: 9px;">
<table width="200px" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="5%"><label valign="left" class="gridsmlabel">SR
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">LoanOut
			Date</label></td>
			<td width="10%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="10%"><label valign="left" class="gridsmlabel">A/U</label></td>
			<!--   <td width="10%"><label valign="left" class="smalllabel">Req Qty</label></td> -->
			<td width="10%"><label valign="left" class="smalllabel">Loan
			Out Qty </label></td>
		</tr>
	</thead>

	<tbody>

		<%for(StoreIssueT issueT:  storeIssueTList) {%>
		<tr>
			<td width="10%"><input type="text" value="<%=srNo %>"
				class="smcaption" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=issueT.getIssueM().getIssueDate() %>" class="medcaption"
				readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=issueT.getItem().getPvmsNo() %>" class="medcaption"
				readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=issueT.getItem().getNomenclature() %>" class="bigcaption"
				readonly="readonly" /></td>
			<%if(issueT.getItem().getItemConversion() !=null){ %>
			<td width="10%"><input type="text"
				value="<%=issueT.getItem().getItemConversion().getItemUnitName() %>"
				class="medcaption" readonly="readonly" /></td>
			<%}else{ %>
			<td width="10%"><input type="text" value="" class="medcaption"
				readonly="readonly" /></td>
			<%} %>
			<!--  <td width="10%"> <input type="text" value="<%=issueT.getQtyRequest() %>" class="medcaption"  readonly="readonly"/> </td> -->
			<td width="10%"><input type="text"
				value="<%=issueT.getQtyIssued() %>" class="medcaption"
				readonly="readonly" /></td>
			</td>
		</tr>
		<%srNo++;} %>

	</tbody>

</table>
<br />

<!--  <input name="" value="Back" type="button"  class="button" onclick="submitForm('loanOut','stores?method=showIssueDispensaryJsp');" />
	 --></div>
<br />
<input name="" value="Ok" type="button" class="button"
	onclick="submitForm('loanOut','stores?method=adjustLoanOut');" /> <input
	name="" value="Print Loan Out" type="button" class="button"
	onclick="submitForm('loanOut','stores?method=printLoanOut&internalIndentId=<%=internalIndentId %>');" />

<%}else{%>
<div id="errorMsg"
	style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div
	style="margin-right: 0px; /*changed from 3px */ text-align: center; font-weight: bold; height: 23px; background-color: #FFE8E8; float: left; width: 100%; color: red; border: 1px solid red;">
Already Adjusted or No records found in LOANOUT</div>
</div>
<br />
<br />


<input name="" value="Back" type="button" class="button"
	onclick="submitForm('loanOut','stores?method=searchInternalIndentDetails');" />
<%}
	// System.out.println("box.get(issueNo)-----------------------"+box.get("issueNo")+"==================box.get(internalIndentId)====="+box.get("internalIndentId"));
	%> <input type="hidden" name="<%=RequestConstants.ISSUE_NO %>"
	id="issueNo" value="<%=box.get("issueNo")%>" class="textbox_size20"
	MAXLENGTH="8"/  > <input type="hidden"
	name="<%= RequestConstants.DEPARTMENT_ID_TEMP%>" id="departmentIdTemp"
	validate='Dispensery Name,num,Yes'
	value="<%=box.get("departmentIdTemp") %>"> <input
	type="hidden" name="<%= RequestConstants.REFERENCE %>" id="reference"
	value="<%=box.get("reference") %>" class="textbox_size20"
	MAXLENGTH="30" /> <input type="hidden"
	name="<%= RequestConstants.REQUEST_BY%>" id="requestBy"
	validate="Request By,String,Yes" value="<%=box.get("requestBy")%>">
<input type="hidden" name="<%= RequestConstants.APPROVED_BY%>"
	id="approvedBy" value="<%=box.get("approvedBy") %>"
	validate="Approved By,String,Yes"> <input type="hidden"
	name="<%= RequestConstants.ISSUED_BY%>" id="issuedBy"
	value="<%=box.get("issuedBy")%>"> <input type="hidden"
	name="<%= RequestConstants.REQUEST_NO%>" id="requestNo"
	value="<%=box.get("requestNo")%>"> <input type="hidden"
	name="<%= RequestConstants.REQUEST_DATE%>"
	id="<%= RequestConstants.REQUEST_DATE %>"
	value="<%=box.get("requestDate")%>"></form>
</div>
<%-- End of contentspace div--%>