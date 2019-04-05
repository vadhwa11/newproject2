<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * country.jsp  
 * Purpose of the JSP -  This is for Country Details.
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.15  
--%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@page import="jkt.hms.masters.business.MasScheduleMaster"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript"	src="/erp/jsp/js/ajax.js"></script>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	List<FaMasAccountGroup> faMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
	if(map.get("faMasAccountGroupList")!=null){
		faMasAccountGroupList = (ArrayList)map.get("faMasAccountGroupList");
	}
	
	List<FaMasAccountSubGroup> gridMasAccountSubGroupList=new ArrayList<FaMasAccountSubGroup>();
	if(map.get("gridMasAccountSubGroupList")!=null){
	gridMasAccountSubGroupList = (ArrayList)map.get("gridMasAccountSubGroupList");
	}
	
	List<FaMasAccount> faMasAccountList=new ArrayList<FaMasAccount>();
	if(map.get("faMasAccountList")!=null){
		faMasAccountList=(List<FaMasAccount>)map.get("faMasAccountList");
	}
	
	List<FaMasAccountSubGroup> faMasAccountSubGroupList=new ArrayList<FaMasAccountSubGroup>();
	faMasAccountSubGroupList = (List<FaMasAccountSubGroup>)map.get("faMasAccountSubGroupList")	;
	
	
	ArrayList gridfaMasAccountGroupList =new ArrayList(); 
	if(map.get("gridMasAccountGroupList")!=null){
		gridfaMasAccountGroupList =(ArrayList)map.get("gridMasAccountGroupList");
	}
	
	List<FaMasAccount> mainAccountList=new ArrayList<FaMasAccount>();
	if(map.get("mainAccountList")!=null){
		mainAccountList=(List<FaMasAccount>)map.get("mainAccountList");
	}

	
	List<MasScheduleMaster> masScheduleList = new ArrayList<MasScheduleMaster>();
	if(map.get("existingScheduleList")!=null){
		masScheduleList = (ArrayList)map.get("existingScheduleList");
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println("<h4>"+message+"</h4>");
		  }
	
	String accountGroupName="";

	if(map.get("accountGroupName") != null){
		accountGroupName = (String)map.get("accountGroupName");
		  
		  }
 %>
<div class="titleBg">
<h2>Account  Master</h2>
</div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">

<label>Account Code</label> 
<input type="radio"	class="radioAuto" name="<%=SELECTED_RADIO  %>" value="1"  checked="checked" /> 

<label>Account Name</label> 
<input type="radio"	class="radioAuto" name="<%=SELECTED_RADIO %>" value="2"  checked="checked" />

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>"	value="" validate="Account Code,string,no" MAXLENGTH="8" tabindex=1 />

<input type="hidden" name="colCode" value="acc_code">
<input type="hidden" name="colName" value="acc_desc">

<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','account?method=searchAccountMaster','checkSearch')"	tabindex=1 />

	<input type="button" name="Report" value="Generate Report" class="buttonBig" onclick="submitForm('search','account?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_fa_acc"/>
</div>
</form>
</div>
</div>
<form name="ancher" method="post"></form>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<% 
		if(faMasAccountList.size()>0)
		 {
			String strForCode = (String)map.get("accCode");
			String strForCodeDescription = (String)map.get("accDesc");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
	 <h4><a href="javascript:void(0)" onclick="submitForm('ancher','account?method=showAccountMasterJsp');">Show All Records</a></h4>
<%
			}
		 }
	 if(faMasAccountList.size()==0 && map.get("search") != null)
	  {
	 %> 
 <h4><a href="javascript:void(0)" onclick="submitForm('ancher','account?method=showAccountMasterJsp');">Show All Records</a></h4>
<%
     }
	%> 
	<script type="text/javascript">
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= DISTRICT_ID %>"], [4,"subGroupName"],[5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"],[9,"parentStatus"]	,[10,"<%=ACCOUNT_ID%>"],[11,"subLedgerStatus"],[12,"schedule"],[13,"accountRight"]
			];
	 statusTd = 8;
	</script>
</div>

<form name="accountMaster" method="post" action="">

<input	type="hidden" name="<%= POJO_NAME %>" value="FaMasAccount"> 
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="AccDesc">
<input type="hidden" name="title" value="AccountMaster"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="accountMaster"> 
<input	type="hidden" name="pojoPropertyCode" value="AccCode"> 

<div class="Block">

<label> Account Code <span>*</span></label> 
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Account Code,int,yes" class="textbox_size20" MAXLENGTH="8"  tabindex=1> 

<label> Account Name<span>*</span></label>
<input type="text" id="accountNameId" name="<%= SEARCH_NAME %>" value=""	validate="Account Name,string,yes" class="textbox_size20"	MAXLENGTH="200"  tabindex=1> 
<script>
				document.accountMaster.<%=CODE%>.focus();
</script> 

<label> Account Group Name <span>*</span></label>
<select name="<%=DISTRICT_ID %>" id="agnId" validate="Account Group Name ,string,yes" onChange="displayMainAccSchulde();submitProtoAjaxWithDivName('accountMaster','account?method=getScheduleList&accountGroup='+this.value+'&formName=accountMaster','nameDiv'); submitProtoAjaxWithDivName('accountMaster','account?method=getSubGroupList&accountGroup='+this.value+'&formName=accountMaster','SubgrpNameDiv');" tabindex=1 >
<option value="0">Select</option>
	<% 
	for (FaMasAccountGroup  faMasAccountGroup : faMasAccountGroupList){
				%>
	<option value="<%=faMasAccountGroup.getId()%>"><%=faMasAccountGroup.getAccountGroupDesc().trim()%></option>
	<%}%>
</select>


<div class="clear"></div>
<div id="SubgrpNameDiv">
<label> Account Sub Group Name <span>*</span></label>
<select id="subGroupName" name="subGroupName" validate="Account Sub Group Name ,string,yes" tabindex=1 >
<option value="0">Select</option>
	<% 
	for (FaMasAccountSubGroup  faMasAccountSubGroup : faMasAccountSubGroupList){
				%>
	<option value="<%=faMasAccountSubGroup.getId()%>"><%=faMasAccountSubGroup.getAccountSubGroupName()%></option>
	<%}%>
</select>

</div>
<div id="nameDiv"  style="display: none;">
<label>Schedule</label>
<%--  <select id="scheduleId" name="schedule" validate="Schedule,string,no" >
	<option value="0">Select</option>
	<%
	for(MasScheduleMaster masSchedule : masScheduleList){
	 %>
	<option value="<%=masSchedule.getScheduleCode()%>"><%=masSchedule.getScheduleCode()%></option>
	<%} %>
</select> --%>
<input type="text" id="scheduleId" name="schedule" />
</div>

<div class="clear"></div>

<div id="parentDiv" style="display: inline;">

<label> Parent Required</label>
<input id="parentStatusId" type="checkbox" name="parentStatus" value="" validate="Parent Required,string,no" tabindex=1 class="radioCheck" onclick="displayMainAcc();" />

<div id="mainAccountDiv" style="display: none;">

<label> Main Account</label>
<select id="<%=ACCOUNT_ID %>" name="<%=ACCOUNT_ID %>" validate="Account Type,string,no"  >
	<option value="0">Select</option>
	<%if(mainAccountList.size()>0){
		for(FaMasAccount faMasAccount :mainAccountList){
		%>
		<option value="<%=faMasAccount.getId() %>"><%=faMasAccount.getAccDesc() %></option>
	<%}
		}%>
</select>
</div>

<div class="clear"></div>

<label> SL Required</label>
<input id="subLedgerId" type="checkbox" name="subLedgerStatus" value="" validate="SL Required,string,no" tabindex=1 class="radioCheck" />

<%--<label>Opening Balance</label>
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
	
</select>--%>

<label>Account Rights</label>
<select name="accountRight">
<option value="AL">All</option>
<option value="CN">Centres</option>
<option value="HO">HO</option>
</select>

</div>

</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Submit11" id="addbutton" value="Add" class="button" onClick="submitForm('accountMaster','account?method=addAccountMaster','validateAccountMasterField');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" style="display: none" class="button" onClick="submitForm('accountMaster','account?method=editAccountMaster')"	accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" style="display: none" class="button"	onClick="submitForm('accountMaster','account?method=deleteAccount&flag='+this.value)"	accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="submitFormForButton('search','account?method=showAccountMasterJsp')" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input	type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label>   
			<label class="value"><%=userName%></label>
			        
			<label>Changed Date:</label>   
			<label class="value"><%=date%></label>
			 
			<label>Changed Time:</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
   </div>	
</form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Account Code";
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>";

data_header[1] = new Array;
data_header[1][0] = "Account Name";
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Account Group Name";
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=DISTRICT_ID %>";

data_header[3] = new Array;
data_header[3][0] = "Account Sub Group Name";
data_header[3][1] = "data";
data_header[3][2] = 0;
data_header[3][3] = "subGroupName";

data_header[4] = new Array;
data_header[4][0] = "";
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY %>";

data_header[5] = new Array;
data_header[5][0] = "";
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE %>";

data_header[6] = new Array;
data_header[6][0] = "";
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_TIME %>";

data_header[7] = new Array;
data_header[7][0] = "Status";
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";


data_header[8] = new Array;
data_header[8][0] = "parentStatus";
data_header[8][1] = "hide";
data_header[8][2] = "15%";
data_header[8][3] = "parentStatus";
data_arr = new Array();



data_header[9] = new Array;
data_header[9][0] = "";
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] ="<%=ACCOUNT_ID %>";
data_arr = new Array();


data_header[10] = new Array;
data_header[10][0] = "";
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "subLedgerStatus";
data_arr = new Array();



data_header[11] = new Array;
data_header[11][0] = "";
data_header[11][1] = "hide";
data_header[11][2] = "15%";
data_header[11][3] = "schedule";
data_arr = new Array();


data_header[12] = new Array;
data_header[12][0] = "";
data_header[12][1] = "hide";
data_header[12][2] = "15%";
data_header[12][3] = "accountRight";
data_arr = new Array();

<%

if(faMasAccountList != null)
{
	
Iterator itr=faMasAccountList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             FaMasAccount  faMasAccount = (FaMasAccount)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= faMasAccount.getId()%>;
data_arr[<%= counter%>][1] = "<%=faMasAccount.getAccCode()%>";
data_arr[<%= counter%>][2] = "<%= faMasAccount.getAccDesc()%>";
		
			<%
			Iterator itrGridFaMasAccountGroupList=faMasAccountGroupList.iterator();
			 while(itrGridFaMasAccountGroupList.hasNext())
	            {
				 try{
	             FaMasAccountGroup  faMasAccountGroup = (FaMasAccountGroup)itrGridFaMasAccountGroupList.next(); 
				 if(faMasAccount.getAccountSubGroup().getAccountGroup().getId().equals(faMasAccountGroup.getId()) && faMasAccountGroup.getStatus().equalsIgnoreCase("y")){%>
					data_arr[<%= counter%>][3] = "<%=faMasAccountGroup.getAccountGroupDesc().trim()%>";
				<%}else if(faMasAccount.getAccountSubGroup().getAccountGroup().getId().equals(faMasAccountGroup.getId()) && faMasAccountGroup.getStatus().equalsIgnoreCase("n")){%>
					data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=faMasAccountGroup.getAccountGroupDesc().trim()%>";
					
				<%}
	            }catch(Exception e){}}%>
	            
	            <%
				Iterator itrGridSubGroup=gridMasAccountSubGroupList.iterator();
				 while(itrGridSubGroup.hasNext())
		            {
					 try{
		             FaMasAccountSubGroup  subGroup = (FaMasAccountSubGroup)itrGridSubGroup.next(); 
					 if(faMasAccount.getAccountSubGroup().getId().equals(subGroup.getId()) && subGroup.getStatus().equals("y")){%>
						data_arr[<%= counter%>][4] = "<%=subGroup.getAccountSubGroupName()%>";
					<%}else if(faMasAccount.getAccountSubGroup().getId().equals(subGroup.getId()) && subGroup.getStatus().equals("n")){%>
						data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=subGroup.getAccountSubGroupName()%>";
						
					<%}
		            }catch(Exception e){}}%>
	            
	            
	            
	                 
	            
data_arr[<%= counter%>][5] = "<%= faMasAccount.getLastChgBy()!=null?(faMasAccount.getLastChgBy().getId()!=null?faMasAccount.getLastChgBy().getId():"0" ):"0"%>";
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(faMasAccount.getLastChgDate()) %>";
data_arr[<%= counter%>][7] = "<%= faMasAccount.getLastChgTime() %>";

<% if(faMasAccount.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active";
<%}else{%>
data_arr[<%= counter%>][8] = "InActive";
<%}%>

data_arr[<%= counter%>][9] = "<%= faMasAccount.getParentStatus()!=null?(faMasAccount.getParentStatus()!=null?faMasAccount.getParentStatus():"" ):""%>";
	 
	 <%
		Iterator mainAccountGrid=mainAccountList.iterator();
		 while(mainAccountGrid.hasNext())
         {
			 try{
          FaMasAccount  f = (FaMasAccount)mainAccountGrid.next(); 
			 if(faMasAccount.getParent().getId().equals(f.getId()) && f.getStatus().equals("y")){%>
				data_arr[<%= counter%>][10] = "<%=f.getAccDesc()%>";
			<%}else if(faMasAccount.getParent().getId().equals(f.getId()) && f.getStatus().equals("n")){%>
				data_arr[<%= counter%>][10] = "<font id='error'>*</font>Parent InActivated--<%=f.getAccDesc()%>";
				
			<%}
         }catch(Exception e){}}%>
         
         
data_arr[<%= counter%>][11] = "<%= faMasAccount.getSubLedger()!=null?(faMasAccount.getSubLedger()!=null?faMasAccount.getSubLedger():"" ):""%>";
data_arr[<%= counter%>][12] ="<%= faMasAccount.getSchedule()!=null?(faMasAccount.getSchedule()!=null?faMasAccount.getSchedule():"0" ):"0"%>" ; 
data_arr[<%= counter%>][13] ="<%= faMasAccount.getAccountRight()!=null?(faMasAccount.getAccountRight()!=null?faMasAccount.getAccountRight():"" ):""%>";
<%
		     counter++;
}
          }
%>
formName = "accountMaster";

nonEditable = ['<%= CODE%>'];
start = 0;
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<script>
function displayMainAcc(){
if(document.getElementById("parentStatusId").checked==true){
	document.getElementById("mainAccountDiv").style.display="inline";
}else if(document.getElementById("parentStatusId").checked==false){
	document.getElementById("mainAccountDiv").style.display="none";
	}
}
</script>

<script>
function displayMainAccSchulde(){
if(document.getElementById("agnId").value!="0"){
	document.getElementById("nameDiv").style.display="inline";
}else{	document.getElementById("nameDiv").style.display="none";
	}
}
</script>