<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_instructorMaster.jsp  
 * Purpose of the JSP -  This is for Instructor details 
 * @author  Rajendra
 * Create Date: 23rd Dec,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*" %>

<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.HrMasItaxSlab"%>


<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	
	List<HrMasItaxSurcharge> searchItaxSurchargeMasterList = new ArrayList<HrMasItaxSurcharge>();
	List<HrMasSurcharge> hrMasSurchargeList = new ArrayList<HrMasSurcharge>(); 
	List<MasStoreFinancial> hrMasFinancialYearList = new ArrayList<MasStoreFinancial>();
	if(map.get("searchItaxSurchargeMasterList")!=null)
	{
		searchItaxSurchargeMasterList =(List<HrMasItaxSurcharge>)map.get("searchItaxSurchargeMasterList");
	}
	if(map.get("hrMasSurchargeList")!=null)
	{
		hrMasSurchargeList =(List<HrMasSurcharge>)map.get("hrMasSurchargeList");
	}
	if(map.get("hrMasFinancialYearList")!=null)
	{
		hrMasFinancialYearList =(List<MasStoreFinancial>)map.get("hrMasFinancialYearList");
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
	%>
	



<h4><%=message %></h4>
		<%  }
%>
<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>

<%@page import="jkt.hms.masters.business.HrMasItaxSurcharge"%>
<%@page import="jkt.hms.masters.business.HrMasSurcharge"%>
<div class="titleBg"><h2>Income Tax Surcharge/Edu. Cess Master</h2></div>
<div class="clear"></div>
<div class="Block">	 
<div id="searcharea">
			<div id="searchbar">
		<form name="search" method="post" action="">
			<label>Financial Year</label> 
			
			<select name="<%= SEARCH_FIELD %>" id="searchField" validate="Financial Year,string,no" tabindex=1>
			<option value="0">Select</option>
			<%if(hrMasFinancialYearList != null)
			{
				for(MasStoreFinancial hrMasFinancial : hrMasFinancialYearList)	
				{%>
					<option value="<%=hrMasFinancial.getId()%>" ><%=hrMasFinancial.getFinancialYear() %></option>
				<% }
			}
			%>
			</select>		
			<!--<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Finacial Year,string,no" MAXLENGTH="9" tabindex=1 />--> 
			<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','payrollMasters?method=searchIncomeTaxSurchargeJsp','checkSearch')" tabindex=1 />
			<!-- <input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','payrollMasters?method=printSurchargeMaster','chkfYear');" accesskey="g" tabindex=1/> -->
			<div class="clear"></div>
			<label>Copy Year</label>
			<input type="checkbox" name="copy" id="copy" value="no" onClick="checkYear()" class="Checkbox"/>
			
			<div id="copyYear" style="display:none;">
				<div class="clear"></div>
				<label>Copied From Year</label>
				<select id="copyFromYearId" name="copyFromYear" validate="Copy From Year,string,no" >
				<option value="0">Select</option>
				 <%if(hrMasFinancialYearList != null)
			    {
				for(MasStoreFinancial hrMasFinancial : hrMasFinancialYearList)	
				{%>
					<option value="<%=hrMasFinancial.getId()%>" ><%=hrMasFinancial.getFinancialYear() %></option>
				<% }
			   }
			   %>
				</select>
				<label>Copied To Year</label>
				<select id="copyToYearId" name="copyToYear" validate="Copy To Year,string,no" >
				<option value="0">Select</option>
				 <%if(hrMasFinancialYearList != null)
			    {
				for(MasStoreFinancial hrMasFinancial : hrMasFinancialYearList)	
				{%>
					<option value="<%=hrMasFinancial.getId()%>" ><%=hrMasFinancial.getFinancialYear() %></option>
				<% }
			   }
			   %>
				</select>
				<input type="button" name="copyYear" value="Copy" class="button" onclick="submitForm('search','payrollMasters?method=copyIncomeTaxSurchargeJsp','checkCopyYear')" tabindex=1 />
			</div>


			
		</form>
	 </div>
	</div>

<div class="clear"></div>



	</div>
	<div class="clear"></div>
    <div class="division"></div>				
	<jsp:include page="searchResultBlock.jsp" />
	<div class="clear"></div>
	
<form name="ancher" method="post">
</form>
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
 
	<%
 		if (searchItaxSurchargeMasterList.size() > 0) {
 			if (map.get("financialYear")!=null)  
 			{
 	%> 
	       <!--  <h4><a href="payrollMasters?method=showIncomeTaxSurchargeJsp">Show All Records</a></h4> -->
	       <h4><a href="javascript:void(0)" onclick="submitForm('ancher','payrollMasters?method=showIncomeTaxSurchargeJsp');">Show All Records</a></h4>
	<%
			}
		}
		if (searchItaxSurchargeMasterList.size() == 0
				&& map.get("search") != null) {
	%>
			<!-- <h4><a href="payrollMasters?method=showIncomeTaxSurchargeJsp">Show All Records</a></h4> -->
			<h4><a href="javascript:void(0)" onclick="submitForm('ancher','payrollMasters?method=showIncomeTaxSurchargeJsp');">Show All Records</a></h4>

    <%
    	}
    %>

	<script type="text/javascript">
	formFields = [
			[0, "<%= COMMON_ID%>", "id"],  [1,"<%= SEARCH_NAME %>"],  [2,"surchargeBase"], [3,"surchargeCode"], [4,"lowerLimit"],[5,"upperLimit"], [6,"perOne"],[7,"perTwo"],[8,"<%= CHANGED_BY%>"],[9,"<%= CHANGED_DATE %>"],[10,"<%= CHANGED_TIME %>"],[11,"<%=STATUS%>"],[12,"<%="minTaxSal"%>"]];
	 statusTd = 11;
	</script>
	</div>
    <div class="clear"></div>
    <div class="division"></div>
   
  <form name="incomeTaxsurcharge" method="post" action="">
 <div class="Block"> 
	
	
			
		
	    <label>  Financial Year<span>*</span></label>
			<select name="<%= SEARCH_NAME %>" validate="Financial Year,string,yes" tabindex=1>
			<option value="">Select</option>
			<%if(hrMasFinancialYearList != null)
			{
				for(MasStoreFinancial hrMasFinancial : hrMasFinancialYearList)	
				{%>
					<option value="<%=hrMasFinancial.getId()%>" ><%=hrMasFinancial.getFinancialYear() %></option>
				<% }
			}
			%>			    
			</select>	
			
		<label>Surcharge Code<span>*</span></label>
		
		<select name="surchargeCode" id="surchargeCode"  validate="Surcharge Code,string,yes" tabindex=1 onchange="displayField()">
			<option value="">Select</option>
			<%if(hrMasSurchargeList != null)
			{
				for(HrMasSurcharge hrMasSurcharge : hrMasSurchargeList)	
				{%>
					<option value="<%=hrMasSurcharge.getId()%>" id="<%=hrMasSurcharge.getId()%>" ><%=hrMasSurcharge.getSurchargeDescription() %></option>
				<% }
			}
			%>			    
			</select>
			<div class="clear"></div>	
			
			<label>Lower Limit<span>*</span></label>
			<input type="text" name="lowerLimit" value="" validate="Lower limit,floatWithoutZero,yes" class="textbox_size20" MAXLENGTH="9" tabindex=1/>
			
			<label>Upper Limit <span>*</span></label>
			<input type="text" name="upperLimit" value="" validate="Upper limit,floatWithoutZero,yes" class="textbox_size20" MAXLENGTH="13"/ tabindex=1/>
			
			<div id='minTaxSalDiv' style="display:none;">
			<label>Min. Taxable Salary<span>*</span> </label>
			<input type="text" name="minTaxSal" id='minTaxSal' value="" validate="Min. Taxable Salary ,floatWithoutZero,no" class="textbox_size20" MAXLENGTH="9"/ tabindex=1/>
			</div>
			
			<div class="clear"></div>
			
			<label>% One</label>
			<input type="text" name="perOne" value="" validate="% One,floatWithoutZero,no" class="textbox_size20" MAXLENGTH="5" tabindex=1/>
			
			<label>% Two</label>
			<input type="text" name="perTwo" value="" validate="% Two,floatWithoutZero,no" class="textbox_size20" MAXLENGTH="5"/ tabindex=1/>
			
			<label>Surcharge Base<span>*</span></label>
			<select name="surchargeBase" validate="Surcharge Base,string,yes" tabindex=1>
			<option value="">Select</option>
			<option value="s">Tax + Sucharge</option>
			<option value="t">Tax</option>
			</select>
			<script>
				//document.incomeTaxsurcharge.<%=SEARCH_FIELD%>.focus();
			</script>	
						
			<div class="clear"></div>
            </div>
            <div class="clear"></div>
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
				
			<div id="edited"></div>
			
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('incomeTaxsurcharge','payrollMasters?method=addIncomeTaxSurchargeJsp');" accesskey="a" tabindex=1/>
		
			<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('incomeTaxsurcharge','payrollMasters?method=editIncomeTaxSurchargeJsp')" accesskey="u" tabindex=1 />

			<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('incomeTaxsurcharge','payrollMasters?method=deleteIncomeTaxSurchargeJsp&flag='+this.value)" accesskey="d" tabindex=1/>		

			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onClick="submitFormForButton('incomeTaxsurcharge','payrollMasters?method=showIncomeTaxSurchargeJsp');" accesskey="r" />
		
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
		
	<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Financial Year"
data_header[0][1] = "data";
data_header[0][2] = "";
data_header[0][3] = "<%= SEARCH_NAME %>"

data_header[1] = new Array;
data_header[1][0] = "Surcharge Base"
data_header[1][1] = "hide";
data_header[1][2] = "";
data_header[1][3] = "surchargeBase";

data_header[2] = new Array;
data_header[2][0] = "Surcharge Code"
data_header[2][1] = "data";
data_header[2][2] = "";
data_header[2][3] = "surchargeCode";

data_header[3] = new Array;
data_header[3][0] = "Lower Limit"
data_header[3][1] = "data";
data_header[3][2] = "";
data_header[3][3] = "lowerLimit";

data_header[4] = new Array;
data_header[4][0] = "Upper Limit"
data_header[4][1] = "data";
data_header[4][2] = "";
data_header[4][3] = "upperLimit";

data_header[5] = new Array;
data_header[5][0] = "% One"
data_header[5][1] = "data";
data_header[5][2] = "";
data_header[5][3] = "perOne";

data_header[6] = new Array;
data_header[6][0] = "% Two"
data_header[6][1] = "data";
data_header[6][2] = "";
data_header[6][3] = "perTwo";



data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%=CHANGED_BY %>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%=CHANGED_DATE %>"

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "";
data_header[9][3] = "<%=CHANGED_TIME %>";

data_header[10] = new Array;
data_header[10][0] = "Status"
data_header[10][1] = "data";
data_header[10][2] = "";
data_header[10][3] = "<%=STATUS %>";

data_header[11] = new Array;
data_header[11][0] = "Min Taxable Salary"
data_header[11][1] = "hide";
data_header[11][2] = "";
data_header[11][3] = "<%="minTaxSal" %>";



data_arr = new Array();

<%
Iterator itr=searchItaxSurchargeMasterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  HrMasItaxSurcharge  hrMasItaxSurcharge = (HrMasItaxSurcharge)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasItaxSurcharge.getId()%>
<%
	for(MasStoreFinancial hrMasFinancialYear :hrMasFinancialYearList){
		if(hrMasItaxSurcharge.getFinancialYear().getId().equals(hrMasFinancialYear.getId())){
%>

data_arr[<%= counter%>][1] = "<%=hrMasFinancialYear.getFinancialYear()%>"
<% 
	}
   }		

%>
 
data_arr[<%= counter%>][2] = "<%= hrMasItaxSurcharge.getSurchargeBase()%>"

<%
	for(HrMasSurcharge hrMasSurcharge :hrMasSurchargeList){
		if(hrMasItaxSurcharge.getHrMasSurcharge().getId().equals(hrMasSurcharge.getId())){
			System.out.println(hrMasItaxSurcharge.getHrMasSurcharge().getId() + "--" +hrMasSurcharge.getId() );
			System.out.println(hrMasSurcharge.getSurchargeDescription());
%>

data_arr[<%= counter%>][3] = "<%=hrMasSurcharge.getSurchargeDescription()%>"
<% 
	}
   }		

%>


data_arr[<%= counter%>][4] = "<%=  hrMasItaxSurcharge.getLowerLimit()!=null?hrMasItaxSurcharge.getLowerLimit():"" %>"

data_arr[<%= counter%>][5] = "<%=  hrMasItaxSurcharge.getUpperLimit()!=null?hrMasItaxSurcharge.getUpperLimit():"" %>"



data_arr[<%= counter%>][6] = "<%=  hrMasItaxSurcharge.getPercentOne()!=null?hrMasItaxSurcharge.getPercentOne():"" %>"

data_arr[<%= counter%>][7] = "<%=  hrMasItaxSurcharge.getPercentTwo()!=null?hrMasItaxSurcharge.getPercentTwo():"" %>"

data_arr[<%= counter%>][8] = "<%= hrMasItaxSurcharge.getLastChgBy()!=null?(hrMasItaxSurcharge.getLastChgBy().getId()!=null?hrMasItaxSurcharge.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][9] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasItaxSurcharge.getLastChgDate()) %>"
data_arr[<%= counter%>][10] = "<%= hrMasItaxSurcharge.getLastChgTime() %>"
<% if(hrMasItaxSurcharge.getStatus().equals("y")){ %>
data_arr[<%= counter%>][11] = "Active"
<%}else{%>
data_arr[<%= counter%>][11] = "InActive"
<%}%>
<%if(hrMasItaxSurcharge.getMinTaxSal()!=null){%>
data_arr[<%= counter%>][12] = <%=hrMasItaxSurcharge.getMinTaxSal()%>
<%}else{%>
data_arr[<%= counter%>][12] = ""
<%}%>
<%
		     counter++;
}
%>
 
formName = "incomeTaxsurcharge"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	

<script>
function displayField(){
 
 var w = document.getElementById('surchargeCode').selectedIndex;
 var selectedText = document.getElementById('surchargeCode').options[w].text;
 
	 if(selectedText == "Salary Surcharge")
	{
	document.getElementById('minTaxSalDiv').style.display = 'block';
	//document.getElementById('minTaxSal').validate = 'Min Taxable Salary,float,yes';
	}
	else
	{
	document.getElementById('minTaxSalDiv').style.display = 'none';
	//document.getElementById('minTaxSal').validate = "Min Taxable Salary,float,no";
	}
	return;

}


function checkYear()
		{
		
		if(document.getElementById('copy').checked)
		{
			document.getElementById('copyYear').style.display='block';
		}
		else
		{
		    document.getElementById('copyYear').style.display='none';
		   
		}
		
	}
	
	
	function checkCopyYear()
		{
		
		if(document.getElementById('copyFromYearId').value == "0")
		{
		    alert("From Year can not be Blank");
			return false;
		}
		else if(document.getElementById('copyToYearId').value == "0")
		{
		    alert("To Year can not be Blank");
		    return false;
		   
		}
		else if(document.getElementById('copyToYearId').value == document.getElementById('copyFromYearId').value)
		{
		    alert("From Year and To Year can not be Same");
		    return false;
		   
		}
		return true;
		
	}
	
	function chkfYear(){
		var chk = document.getElementById('searchField').value;
		if(chk != 0 ){
		     return true;
		}
		else
		{
		  alert("Please Select Financial Year for Reports!!!");
		   return false;
		}
		return true;
	}	


</script>
