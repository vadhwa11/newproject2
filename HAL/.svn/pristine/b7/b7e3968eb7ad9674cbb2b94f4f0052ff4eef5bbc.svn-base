<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hrInsuranceDetails.jsp  
 * Purpose of the JSP -  This is for Insurance Master details 
 * @author  Mansi
 * Create Date: 18th Dec,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>


<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@page import="jkt.hms.masters.business.HrMasInsurance"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.HrInsuranceDetails"%>
<script type="text/javascript" language="javascript" src="/erp/jsp/js/common.js?n=1"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.common.js"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.datePicker.js"></script>


<script language="javascript">

var $j = jQuery.noConflict();
</script>


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
			
	if (map.get("faMasAccountGroupList") != null)
	{
		faMasAccountGroupList = (List)map.get("faMasAccountGroupList");
	}
	
	
	List<HrMasInsurance> hrMasInsuranceList = new ArrayList<HrMasInsurance>();
	
	if (map.get("hrMasInsuranceList") != null)
	{
		hrMasInsuranceList = (List)map.get("hrMasInsuranceList");
	}
	
	
	
				
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String accountGroupName="";
	
if (map.get("accountGroupName") != null)
{
	accountGroupName = (String)map.get("accountGroupName");
}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println("<h4>"+message+"</h4>");
		  }
	
	
%>

	
<div class="titleBg"><h2>Account Group Master</h2></div>

<div class="Block">	 
 <div id="searcharea">
  <div id="searchbar">
			   <form name="search" method="post" action="">
	
	
					<label>Account Group Description</label>
					 <input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Account Group Name,string,no"   MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'account?method=searchAccountGroupNew')" />
					<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','account?method=searchAccountGroupNew','checkSearch')" tabindex=1  />
					<input type="hidden" name="colName" value="f.insurance_name">
<%--					 <input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','masters?method=generateNameOnlyReportForGeneralMasters');"	accesskey="g" tabindex=1 /> --%>
					 <input type="button" name="Report" value="Generate Report" class="buttonBig" onclick="submitForm('search','account?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 />
                    
                    <%--<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="hr_mas_insrance_details"> --%>
  <input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_fa_acc_group"/>
		     </form>
		 </div>
		 <form name="ancher" method="post">
</form>
 </div>
 <div class="clear"></div>
</div>	
<div class="clear"></div>
<div class="division"></div>	
	<jsp:include page="searchResultBlock.jsp" />
	<div class="clear"></div>
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
 
	<% 
		if(faMasAccountGroupList.size()>0 && accountGroupName!="" && accountGroupName!= null)
		 {
			
	%> 
      <h4><a href="javascript:void(0)" onclick="submitForm('ancher','account?method=showAccountsGroupMasterJsp');">Show All Records</a></h4>
	<%} if(faMasAccountGroupList.size()==0 && map.get("search") != null){ %>
        
         <h4><a href="javascript:void(0)" onclick="submitForm('ancher','account?method=showAccountsGroupMasterJsp');">Show All Records</a></h4>
<%} %>	

	<script type="text/javascript">
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME%>"],[2,"discription"], [3,"detailsDate"],[4,"cover"],[5,"premium"],[6,"amount"],[7,"nextPremiumDate"],[8,"insuranceTypeId"],[9,"<%= CHANGED_BY %>"], [10,"<%= CHANGED_DATE %>"],[11,"<%= CHANGED_TIME %>"],[12,"<%=STATUS%>"] ];
	 statusTd = 12;
	</script>
	</div>
	<div class="clear"></div>
    <div class="division"></div>
	<div class="Block">
	<form name="insuranceDetails" method="post" action="">
	
	<input type="hidden" name="<%= POJO_NAME %>" value = "HrInsuranceDetails">
    <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="InsuranceName">
    <input type="hidden" name="title" value = "Insurance Details">
    <input type="hidden" name="<%=JSP_NAME %>" value = "hrInsuranceDetails">
    <input type="hidden" name="pojoPropertyName" value = "InsuranceName">
	
	
 		
    <label> Account Group Code</label>
	<input type="text" name="<%=SEARCH_NAME %>" id="<%= SEARCH_NAME %>" value="" validate="Account Group Code,int,yes" MAXLENGTH="32" tabindex=1 >
	<script>
			document.insuranceDetails.<%=SEARCH_NAME%>.focus();
	</script>
			
		
	<label>Account Group Description<span>*</span> </label>
	<input type="text" name="discription" value="" validate="Account Group Description,string,yes" MAXLENGTH="30" tabindex=1 >
	

	
		<div class="clear"></div>
		</div>
		
		<div class="division"></div>
			<div id="edited"></div>
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('insuranceDetails','account?method=addAccountGroupNew');" accesskey="a" tabindex=1/>
		
			<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('insuranceDetails','account?method=updateAccountGroupNew')" accesskey="u" tabindex=1 />

			<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('insuranceDetails','account?method=deleteAccountGroupNew&flag='+this.value)" accesskey="d" tabindex=1/>		

			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="submitFormForButton('insuranceDetails', 'account?method=showAccountsGroupMasterJsp');" accesskey="r" />
         
            <div class="division"></div>
			<div class="bottom">
			<label>Changed By</label>   
			<label class="value"><%=userName%></label>
			        
			<label>Changed Date</label>   
			<label class="value"><%=date%></label>
			 
			<label>Changed Time</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
   			</div>		
			<div class="division"></div>
		
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
			
	
<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Account Group Code"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= SEARCH_NAME%>";

data_header[1] = new Array;
data_header[1][0] = "Account Group Description"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "discription";

data_header[2] = new Array;
data_header[2][0] = "Date"
data_header[2][1] = "hide";
data_header[2][2] = "40%";
data_header[2][3] = "detailsDate";



data_header[3] = new Array;
data_header[3][0] = "Cover"
data_header[3][1] = "hide";
data_header[3][2] = "40%";
data_header[3][3] = "cover";



data_header[4] = new Array;
data_header[4][0] = "Premium"
data_header[4][1] = "hide";
data_header[4][2] = "40%";
data_header[4][3] = "premium";




data_header[5] = new Array;
data_header[5][0] = "Amount"
data_header[5][1] = "hide";
data_header[5][2] = "40%";
data_header[5][3] = "amount";



data_header[6] = new Array;
data_header[6][0] = "Next Premium Date"
data_header[6][1] = "hide";
data_header[6][2] = "40%";
data_header[6][3] = "nextPremiumDate";


data_header[7] = new Array;
data_header[7][0] = "Insurance Type Name"
data_header[7][1] = "hide";
data_header[7][2] = "40%";
data_header[7][3] = "insuranceTypeId";



data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%=CHANGED_BY %>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%=CHANGED_DATE %>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "<%=CHANGED_TIME %>";

data_header[11] = new Array;
data_header[11][0] = "Status"
data_header[11][1] = "data";
data_header[11][2] = "15%";
data_header[11][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=faMasAccountGroupList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             FaMasAccountGroup  hrInsuranceDetails = (FaMasAccountGroup)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrInsuranceDetails.getId()%>
data_arr[<%= counter%>][1] = "<%= hrInsuranceDetails.getAccountGroupCode()%>"
data_arr[<%= counter%>][2] = "<%= hrInsuranceDetails.getAccountGroupDesc()%>"
	data_arr[<%= counter%>][3] = "<%= HMSUtil.convertDateToStringWithoutTime(hrInsuranceDetails.getLastChgDate()) %>"
data_arr[<%= counter%>][4] = ""
	data_arr[<%= counter%>][5] = ""
		data_arr[<%= counter%>][6] = ""
		
		
		
			data_arr[<%= counter%>][7] = ""
								
				data_arr[<%= counter%>][8] = ""
					data_arr[<%= counter%>][9] = ""
						data_arr[<%= counter%>][10] = ""


				
			data_arr[<%= counter%>][11] = "";
<% if(hrInsuranceDetails.getStatus().equals("y")){ %>
data_arr[<%= counter%>][12] = "Active"
<%}else{%>
data_arr[<%= counter%>][12] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "insuranceDetails"

nonEditable = ['<%=SEARCH_NAME%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
