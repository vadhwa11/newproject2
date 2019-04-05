<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="jkt.hms.masters.business.FaMasSubLed"%>
<%@page import="java.math.BigDecimal"%>
<%@ include file="csrfToken.jsp"%>

<script src="/erp/jsp/js/proto.js" type="text/javascript"></script>
<script src="/erp/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/erp/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/erp/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/erp/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/erp/jsp/js/sorttableAccounts.js" type="text/javascript"></script>

<form name="accountSubLedger" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
	List<FaMasSubLed> searchSubLedList = new ArrayList<FaMasSubLed>();
	List<FaMasAccountGroup> accGrpList = new ArrayList<FaMasAccountGroup>();
	List<FaMasAccountSubGroup> subAccGrpList = new ArrayList<FaMasAccountSubGroup>();
	List<FaMasAccount> accList = new ArrayList<FaMasAccount>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("subLedList") != null){
		subLedList = (List<FaMasSubLed>)map.get("subLedList");
	}
	if(map.get("accGrpList") != null){
		accGrpList = (List<FaMasAccountGroup>)map.get("accGrpList");
	}
	if(map.get("subAccGrpList") != null){
		subAccGrpList = (List<FaMasAccountSubGroup>)map.get("subAccGrpList");
	}
	if(map.get("accList") != null){
		accList = (List<FaMasAccount>)map.get("accList");
	}
	if(map.get("searchSubLedList") != null){
		searchSubLedList = (List<FaMasSubLed>)map.get("searchSubLedList");
	}


String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
		%>
<h4><span><%=message %></span></h4>
	<%}
%>
<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="titleBg">
<h4>Account Sub Ledger</h4>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<form name="ancher" method="post">
</form>
<input type="radio" name="<%=SELECTED_RADIO %>" value="1" checked="checked"	class="radioAuto" />
<label>Code</label>
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="radioAuto" />
<label class="auto">Name</label>
<input type="text" id="searchField" name="<%=SEARCH_FIELD %>" value="" validate="Code,string,no" maxlength="15" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchTitle')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('accountSubLedger','account?method=searchAccountSubLedger','checkSearch')" tabindex=1 />
<input type="button" name="Report" value="Generate Report" class="buttonBig" onclick="submitForm('accountSubLedger','account?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_fa_acc_sub_ledger"/>
	<%-- <input type="button" name="report" value="Generate Report" class="buttonBig"/>--%>
	<div class="clear"></div>
	<%
if(map.get("searchCreteria")!= null )
		 {

%> 
<!-- <a href="account?method=showAccountSubLedgerJsp">Show All Records</a> --> 
<a href="javascript:void(0)" onclick="submitForm('accountSubLedger','account?method=showAccountSubLedgerJsp');">Show All Records</a>

<%

		 }%>
<div class="clear"></div>
</div>

<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<table width="100%" border="0" id="accId" cellspacing="0" cellpadding="0" class="sortable">
	<tr>
		<th scope="col">Select</th>
		<th scope="col">Main Ledger</th>
		<th scope="col">Code</th>
		<th scope="col">Name</th>
		<th scope="col">Opening Balance</th>
		<th scope="col">Ytd-Dr.</th>
		<th scope="col">Ytd-Cr.</th>
		<th scope="col">Closing Balance</th>
	</tr>
	<tbody id="tableData">
		<%
		String trColor = "";
		if(subLedList.size() > 0){
				for(FaMasSubLed subLed : subLedList){
					if(subLed.getAccount()!= null){
					if(subLed.getAccount().getAccountSubGroup()!= null){
						  if(subLed.getAccount().getAccountSubGroup().getAccountGroup()!= null){
				   	 			if(subLed.getAccount().getAccountSubGroup().getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Assets")){
				   	 				trColor="#D6FCA9";
				   	 			}else if(subLed.getAccount().getAccountSubGroup().getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Liability")){
				   	 				trColor="#FDBFA1";
				   	 			} else if(subLed.getAccount().getAccountSubGroup().getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Income")){
				   	 				trColor="#C2F7FA";
				   	 			}else if(subLed.getAccount().getAccountSubGroup().getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Expenditure")){
				   	 				trColor="#FDF1B1";
				   	 			}
				   	 			}
						  }
					}


		%>
		<tr bgcolor="<%=trColor %>">
			<td><input type="radio" value="<%=subLed.getId() %>" name="selecetedRecord"  class="radioAuto" /></td>

			<%

			if(accList.size()>0){
				for(FaMasAccount faMasAccount :accList){
					if(subLed.getAccount()!= null){
						if(faMasAccount.getId().equals(subLed.getAccount().getId())){

				%>
			<td><%=faMasAccount.getAccDesc() %></td>
			<%}}}}else{ %>
			<td>--</td>
			<%} %>
			<td class="right"><%=subLed.getSubLedCode() %></td>
			<td><%=subLed.getSubLedDesc() %></td>
			<%
				if(subLed.getOpBalanceCr() != null && subLed.getOpBalanceCr().compareTo(new BigDecimal(0)) > 0){
			%>
			<td class="right"><%=subLed.getOpBalanceCr() %>  Cr</td>
			<%}else	if(subLed.getOpBalanceDr() != null && subLed.getOpBalanceDr().compareTo(new BigDecimal(0)) > 0){
			%>
				<td class="right"><%=subLed.getOpBalanceDr() %>  Dr</td>
			<%}else{ %>
			<td class="right">-</td>
			<%} %>



			<%if(subLed.getYtdAmountDr() != null && subLed.getYtdAmountDr().compareTo(new BigDecimal(0)) > 0){
			%>
				<td class="right"><%=subLed.getYtdAmountDr() %>  Dr</td>
			<%}else{ %>
			<td class="right">-</td>
			<%} %>

			<%
				if(subLed.getYtdAmountCr() != null && subLed.getYtdAmountCr().compareTo(new BigDecimal(0)) > 0){
			%>
			<td class="right"><%=subLed.getYtdAmountCr() %>  Cr</td>
			<%}else{ %>
			<td class="right">-</td>
			<%} %>
			<%
				if(subLed.getClBalanceCr() != null && subLed.getClBalanceCr().compareTo(new BigDecimal(0)) > 0){
			%>
			<td class="right"><%=subLed.getClBalanceCr() %>  Cr</td>
			<%}else	if(subLed.getClBalanceDr() != null && subLed.getClBalanceDr().compareTo(new BigDecimal(0)) > 0){
			%>
				<td class="right"><%=subLed.getClBalanceDr() %>  Dr</td>
			<%}else{ %>
			<td class="right">-</td>
			<%} %>



		</tr>
<%}
%>
	</tbody>
</table>
<%} %>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>

<label><span>*</span>Sub Ledger Name:</label>

<input id="subLedgerId" type="text" name="<%= SUB_LDEGER_NAME %>" value="" 	validate="Sub Ledger,string,no" MAXLENGTH="45" tabindex=1 />

<label> Group Name<span>*</span></label>
<select id="accountGroupId" name="<%=ACCOUNT_GROUP_ID %>" validate="Account Group,string,no" onChange="populateSubGroup(this.value,'accountSubLedger')" >
	<option value="0">Select</option>
	<%if(accGrpList.size()>0){
		for(FaMasAccountGroup faMasAccountGroup :accGrpList){
		%>
		<option value="<%=faMasAccountGroup.getId() %>"><%=faMasAccountGroup.getAccountGroupDesc() %></option>
	<%}
		}%>
</select>

<script type="text/javascript">
          subGroupArray = new Array();
		<%
			int count = 0;
			for (FaMasAccountGroup faMasAccountGroup :accGrpList)
			{

				for (FaMasAccountSubGroup faMasAccountSubGroup :subAccGrpList)
				{

					if(faMasAccountGroup.getId().equals(faMasAccountSubGroup.getAccountGroup().getId())){
								%>
									subGroupArray[<%=count%>] = new Array();
									subGroupArray[<%=count%>][0] = <%=faMasAccountGroup.getId()%>;
									subGroupArray[<%=count%>][1] = <%=faMasAccountSubGroup.getId()%>;
									subGroupArray[<%=count%>][2] = "<%=faMasAccountSubGroup.getAccountSubGroupName()%>";

								<%
								count++;
						}	} } %>
		</script>

<label> Sub Group<span>*</span> </label>
<select id="subGroupId" name="<%=ACCOUNT_SUB_GROUP_ID %>" validate="Account Sub Group,string,no" onchange="populateMainAccount(this.value,'accountSubLedger')"  >
	<option value="0">Select</option>
	<%if(subAccGrpList.size()>0){
		for(FaMasAccountSubGroup faMasAccountSubGroup :subAccGrpList){
		%>
		<option value="<%=faMasAccountSubGroup.getId() %>"><%=faMasAccountSubGroup.getAccountSubGroupName() %></option>
	<%}
		}%>
</select>

<script type="text/javascript">
          mainAccountArray = new Array();
		<%
			int count1 = 0;
		for (FaMasAccountSubGroup faMasAccountSubGroup :subAccGrpList)
			{

				for (FaMasAccount faMasAccount:accList)
				{

					if(faMasAccountSubGroup.getId().equals(faMasAccount.getAccountSubGroup().getId())){
								%>
									mainAccountArray[<%=count1%>] = new Array();
									mainAccountArray[<%=count1%>][0] = <%=faMasAccountSubGroup.getId()%>;
									mainAccountArray[<%=count1%>][1] = <%=faMasAccount.getId()%>;
									mainAccountArray[<%=count1%>][2] = "<%=faMasAccount.getAccDesc()%>";

								<%
								count1++;
						}	} } %>
		</script>
<div class="clear"></div>
<label> Main Account<span>*</span></label>
<select id="mainAccountId"  name="<%=ACCOUNT_ID %>" validate="Main Account ,string,no">
	<option value="0">Select</option>
	<%if(accList.size()>0){
		for(FaMasAccount faMasAccount :accList){
		%>
		<option value="<%=faMasAccount.getId() %>"><%=faMasAccount.getAccDesc() %></option>
	<%}
		}%>
</select>

<label>Opening Balance</label>
<input type="text" name="openingBalance"  value="" id="openingBalanceId"	 MAXLENGTH="11"  />
<select name="accountTypeA" class="small" />
			<option value="Dr" selected="selected">Dr</option>
			<option value="Cr">Cr</option>
			</select>
<div class="clear"></div>
</div>
<div class="clear"></div>
<table id="branchDetails" style="display: none" ></table>
<input type="hidden" id="totalBranchId" name="totalBranchId"
	value="0" />
<div class="clear"></div>

<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('accountSubLedger','account?method=addAccountSubLedger','validateAccountMasterField');" accesskey="a" tabindex=1 />
<input type="button" name="Update" id="addbutton" value="Update" class="button" onClick="submitForm('accountSubLedger','account?method=editAccountSubLedger');" accesskey="a" tabindex=1 />
  <input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="paddingTop40"></div>
<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);

		function openPopUpValue()
		{
				/* window.open('account?method=showBranchSubLedBalancePopupJsp','mywindow','location=1,status=1,scrollbars=1,top=210,left=30,width=960,height=300'); */
			openPopUp("account?method=showBranchSubLedBalancePopupJsp");
		}



function validateAccountMasterField(){
	var errMsg = "";
	var subLedgerId = document.getElementById('subLedgerId').value;
	var accountGroupId = document.getElementById('accountGroupId').value;
	var accountSubGroupId = document.getElementById('subGroupId').value;
	var mainAccountId = document.getElementById('mainAccountId').value;

	if(subLedgerId == 0){
		errMsg += "Sub Ledger Name can not be blank.\n";
	}
	if(accountGroupId == 0){
		errMsg += "Account Group can not be blank.\n";
	}
	if(accountSubGroupId == 0){
		errMsg += "Account Sub Group can not be blank.\n";
	}
	if(mainAccountId == 0){
		errMsg += " Main Account can not be blank.\n";
	}


	if(errMsg != ""){
		alert(errMsg);
		return false;
	}

	return true;
}
</script>
</form>

 <form id="popUpForm" name="popUpForm" method="post" target="mywindow">

</form>