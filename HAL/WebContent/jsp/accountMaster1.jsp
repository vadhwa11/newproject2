<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="java.math.BigDecimal"%>
<%@ include file="csrfToken.jsp"%>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
	List<FaMasAccountSubGroup> accountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
	List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
	List<FaMasAccount> accountMasterListForEdit = new ArrayList<FaMasAccount>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if(map.get("accountGroupList") != null){
		accountGroupList = (List<FaMasAccountGroup>)map.get("accountGroupList");
	}

	if(map.get("accountSubGroupList") != null){
		accountSubGroupList = (List<FaMasAccountSubGroup>)map.get("accountSubGroupList");
	}
	if(map.get("accountMasterListForEdit") != null){
		accountMasterListForEdit = (List<FaMasAccount>)map.get("accountMasterListForEdit");
	}
	if(map.get("accountList") != null){
		accountList = (List<FaMasAccount>)map.get("accountList");
	}
	
	Integer accCode = 0;
	if(map.get("accCode")!= null){
		accCode = (Integer)map.get("accCode");
	}
	String fYear = "";
	if(map.get("fYear")!= null){
		fYear = (String)map.get("fYear");
	}

	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
		%>
<h4><span><%=message %></span></h4>
	<%}
%>


<form name="accountMaster" method="post" action="">
<div class="clear"></div>
<%if(accountList.size()>0){ %>
<div class="paddingTop15"></div>
<div class="titleBg">
<h4>Account Master</h4>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<input type="radio" name="<%=SELECTED_RADIO %>" value="1" checked="checked"	class="radioAuto" />
<label>Code</label>
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="radioAuto" />
<label class="auto">Name</label>
<input type="text" id="searchField" name="<%=SEARCH_FIELD %>" value="" validate="Code,string,no" maxlength="8" tabindex=1 onkeypress="return submitenter(this,event,'account?method=searchAccountMaster')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('accountMaster','account?method=searchAccountMaster','checkSearch')" tabindex=1 />
<input type="button" name="Report" value="Generate Report" class="buttonBig" onclick="submitForm('accountMaster','account?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_fa_acc"/>

<div class="clear"></div>
</div>



<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<table width="100%" border="0" id="accId" cellspacing="0" cellpadding="0" class="sortable">
	<tr>
		<th scope="col">Select</th>
		<th scope="col">Code</th>
		<th scope="col">SubGroup</th>
		<th scope="col">Name</th>
		<%--
		<th scope="col">Opening Balance</th>
		<th scope="col">Ytd-Dr.</th>
		<th scope="col">Ytd-Cr.</th>
		<th scope="col">Closing Balance</th>
		 --%>

	</tr>
	<tbody id="tableData">
		<%
				  String trColor = "";
			  for(FaMasAccount masAccount :accountList){
		   	 			 if(masAccount.getAccountSubGroup()!= null){
				  if(masAccount.getAccountSubGroup().getAccountGroup()!= null){
		   	 			if(masAccount.getAccountSubGroup().getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Assets")){
		   	 				trColor="#D6FCA9";
		   	 			}else if(masAccount.getAccountSubGroup().getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Liability")){
		   	 				trColor="#FDBFA1";
		   	 			} else if(masAccount.getAccountSubGroup().getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Income")){
		   	 				trColor="#C2F7FA";
		   	 			}else if(masAccount.getAccountSubGroup().getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Expenditure")){
		   	 				trColor="#FDF1B1";
		   	 			}
		   	 			}
				  }

		%>
		<tr bgcolor="<%=trColor %>">
			<td><input type="radio" value="<%=masAccount.getId() %>" name="selecetedRecord"  class="radioAuto" /></td>
			<td><%=masAccount.getAccCode() %></td>
				<%if(accountSubGroupList.size()>0){
					for(FaMasAccountSubGroup faMasAccountSubGroup :accountSubGroupList){
						if(faMasAccountSubGroup.getId().equals(masAccount.getAccountSubGroup().getId())){

				%>
			<td><%=faMasAccountSubGroup.getAccountSubGroupName() %></td>
			<%}}}else{ %>
			<td>--</td>
			<%} %>
			<%if(masAccount.getAccDesc()!=null && !masAccount.getAccDesc().equals("")){ %>
			<td><%=masAccount.getAccDesc() %></td>
			<%}else{ %>
			<td>-</td>
			<%} %>
		
			<%--<%
	   	    	if(masAccount.getOpBalanceCr() != null && masAccount.getOpBalanceCr().compareTo(new BigDecimal(0)) > 0){
	   	    %>
			<td  class="right"><%=masAccount.getOpBalanceCr()%>  Cr</td>
			<%}else if(masAccount.getOpBalanceDr() !=null && masAccount.getOpBalanceDr().compareTo(new BigDecimal(0)) > 0){ %>
			<td class="right"><%=masAccount.getOpBalanceDr() %>   Dr</td>
			<%}else{ %>
			<td class="right">-</td>
			<%} %>

			<%if(masAccount.getYtdAmountDr() !=null && masAccount.getYtdAmountDr().compareTo(new BigDecimal(0)) > 0){ %>
			<td class="right"><%=masAccount.getYtdAmountDr() %>   Dr</td>
			<%}else{ %>
			<td class="right">-</td>
			<%} %>
			<%
	   	    	if(masAccount.getYtdAmountCr() != null && masAccount.getYtdAmountCr().compareTo(new BigDecimal(0)) > 0){
	   	    %>
			<td class="right"><%=masAccount.getYtdAmountCr()%>  Cr</td>
			<%}else{ %>
			<td class="right">-</td>
			<%} %>
			<%
	   	    	if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr().compareTo(new BigDecimal(0)) > 0){
	   	    %>
			<td class="right"><%=masAccount.getClBalanceCr()%>  Cr</td>
			<%}else if(masAccount.getClBalanceDr() !=null && masAccount.getClBalanceDr().compareTo(new BigDecimal(0)) > 0){ %>
			<td class="right"><%=masAccount.getClBalanceDr() %>   Dr</td>
			<%}else{ %>
			<td class="right">-</td>
			<%} %> --%>


		</tr>
	<%} %>
	</tbody>
</table>
<%} %>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>


<div class="Block">
<div class="clear"></div>
<label><span>*</span>Account Code:</label>
 <input id="codeId" type="text"  size="5" name="<%=ACCOUNT_CODE%>" value=""  readonly="readonly"	validate="Account Code,string,no" MAXLENGTH="8" tabindex=1 >

<label>Account Name<span>*</span></label>

<input id="accountNameId" type="text" name="<%= ACCOUNT_NAME %>" value="" 	validate="Account Name,string,no" MAXLENGTH="45"  />


<label>Group Name<span>*</span></label>
<select id="accountGroupId" name="<%=ACCOUNT_GROUP_ID %>" validate="Account Group,string,no" onChange="populateSubGroup(this.value,'accountMaster')" />
	<option value="0">Select</option>
	<%if(accountGroupList.size()>0){
		for(FaMasAccountGroup faMasAccountGroup :accountGroupList){
		%>
		<option value="<%=faMasAccountGroup.getId() %>"><%=faMasAccountGroup.getAccountGroupDesc() %></option>
	<%}
		}%>
</select>

<script type="text/javascript">
          subGroupArray = new Array();
		<%
			int count = 0;
			for (FaMasAccountGroup faMasAccountGroup :accountGroupList)
			{

				for (FaMasAccountSubGroup faMasAccountSubGroup :accountSubGroupList)
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
<div class="clear"></div>
<label>Sub Group Name<span>*</span></label>
<select id="subGroupId" name="<%=ACCOUNT_SUB_GROUP_ID %>" validate="Account SubGroup,string,no" onchange="getAccCode(this.value),getBankName(),populateMainAccount(this.value,'accountMaster')" >
	<option value="0">Select</option>
	<%if(accountSubGroupList.size()>0){
		for(FaMasAccountSubGroup faMasAccountSubGroup :accountSubGroupList){
		%>
		<option value="<%=faMasAccountSubGroup.getId() %>"><%=faMasAccountSubGroup.getAccountSubGroupName() %></option>
	<%}
		}%>
</select>

	<script type="text/javascript">
          mainAccountArray = new Array();
		<%
			int count1 = 0;
		for (FaMasAccountSubGroup faMasAccountSubGroup :accountSubGroupList)
			{

				for (FaMasAccount faMasAccount:accountList)
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


<label> Main Account</label>
<select id="mainAccountId" name="<%=ACCOUNT_ID %>" validate="Account Type,string,no"  />
	<option value="0">Select</option>
	<%if(accountList.size()>0){
		for(FaMasAccount faMasAccount :accountList){
		%>
		<option value="<%=faMasAccount.getId() %>"><%=faMasAccount.getAccDesc() %></option>
	<%}
		}%>
</select>
<label> Parent Required</label>
<input id="parentStatusId" type="checkbox" name="parentStatus" value="" validate="Parent Required,string,no" tabindex=1 class="radioCheck" />
<div class="clear"></div>
<label> SL Required</label>
<input id="subLedgerId" type="checkbox" name="subLedgerStatus" value="" validate="SL Required,string,no" tabindex=1 class="radioCheck" />
<label>Opening Balance</label>
<input type="text" id="openingBalanceId" name="openingBalance" value=""  MAXLENGTH="11"   />
<select name="accountTypeA" class="small" />
			<option value="0">Select</option>
			<option value="Dr" selected="selected">Dr</option>
			<option value="Cr">Cr</option>
			</select>
<div class="clear"></div>

<div id="bankDiv" style="display: none">
<label>Bank Name</label>
<select id="bankId" name="bankId" validate="Bank Name,string,no"  />
	<option value="0">Select</option>
	
</select>
</div>
<label>Schedule</label>
<select id="scheduleId" name="schedule" validate="Schedule,string,yes"  />
	<option value="0">Select</option>
	<%
	
	for(int i=1; i<=30; i++){ %>
	<option value="<%=i %>"><%=i %></option>
	<%} %>
</select>
</div>
<div class="clear"></div>
<%-- 
<table id="branchDetails" style="display: none" ></table>
<input type="hidden" id="totalBranchId" name="totalBranchId"
	value="0" />--%>
<div class="clear"></div>

<input type="button" name="Submit11" id="addbutton" value="Add" class="button" onClick="submitForm('accountMaster','account?method=addAccountMaster','validateAccountMasterField');" accesskey="a" tabindex=1 />
<input type="button" name="Update" id="addbutton" value="Update" class="button" onClick="submitForm('accountMaster','account?method=editAccountMaster','validateRadio');" accesskey="a" tabindex=1 />
  <input type="reset" name="Reset" id="reset"  value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName %> </label>

<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
 <label class="value"><%=time%></label>
  <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName %>" />
   <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
    <input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>



<div class="clear"></div>
<div class="paddingTop40"></div>

<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);



		function openPopUpValue()
		{
				var url = 'account?method=showBranchBalancePopupJsp';
				url = url+'&'+tokenName+'='+tokenValue;
				var actionUrl = url;
				var formName = 'popUpForm';
				var formObj  = document.formName;
				formObj.action = actionUrl;
				window.open('', 'mywindow');
				document.getElementById('popUpForm').submit();
				
		}


	  </script>

<form id="popUpForm" name="popUpForm" method="post" target="mywindow">

</form>


<script type="text/javascript">
function validateRadio(){

	 for(var i = 0; i < document.getElementsByName('selecetedRecord').length; i++){
	  if(document.getElementsByName('selecetedRecord')[i].checked == true)
     {

		return true;
	  }
	}
	alert("Please select At least One Record")
return false;

}

function getAccCode(subGrpId){
var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
    	alert(e)
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }

    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){

      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var accCode  = item.getElementsByTagName("accCode")[0];
	        document.getElementById('codeId').value = accCode.childNodes[0].nodeValue
      	}
      }
      }
      var subGrpCode;
      	<%if(accountSubGroupList.size()>0){
		for(FaMasAccountSubGroup faMasAccountSubGroup :accountSubGroupList){
		%>
		if('<%=faMasAccountSubGroup.getId()%>' == subGrpId){
			subGrpCode = '<%=faMasAccountSubGroup.getAccountSubGroupCode()%>';

		}
		<%}
		}%>

    var url="/erp/erp/account?method=getAccCodeForAccSubGrp&subGrpCode="+subGrpCode+"&"+getNameAndData('accountMaster');

 //// xmlHttp.open("GET",url,true);
    // commented by amit das on 24-01-2017
    
	  // added by amit das on 24-01-2017
	  url = url+'&'+tokenName+'='+tokenValue;
     xmlHttp.open("POST",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

}

function validateAccountMasterField(){
var errMsg = "";
	var accountCodeId = document.getElementById('codeId').value;
	var accountNameId = document.getElementById('accountNameId').value;
	var accountGroupId = document.getElementById('accountGroupId').value;
	var accountSubGroupId = document.getElementById('subGroupId').value;

	if(accountSubGroupId == 0){
		errMsg += "Account Sub group can not be blank.\n";
	}
	if(accountGroupId == 0){
		errMsg += "Account Group can not be blank.\n";
	}
	if(accountNameId == ""){
		errMsg += "Account Name can not be blank.\n";
	}
	if(accountCodeId == ""){
		errMsg += "Account Code can not be blank.\n";
	}


	if(errMsg != ""){
		alert(errMsg);
		return false;
	}

	return true;
}


function getBankName(){
	
	<%
	if(accountSubGroupList.size()>0){
		for(FaMasAccountSubGroup faMasAccountSubGroup :accountSubGroupList){
		%>
	if('<%=faMasAccountSubGroup.getAccountSubGroupName()%>' == 'Bank A/C'){
		document.getElementById('bankDiv').style.display = "inline";
	   }
	<% 
		}
	 }
	%>
}

</script>

</form>