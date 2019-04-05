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
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<%@page import="jkt.hms.masters.business.MasCurrency"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
	currencyList = (ArrayList)map.get("currencyList");
	
	ArrayList searchCountryList = (ArrayList)map.get("searchCountryList");
	ArrayList gridCurrencyList = (ArrayList)map.get("gridCurrencyList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
%>
<%
if(map.get("message") != null){
		   String message = (String)map.get("message");
%>
<h4><%=message%></h4>
  <%
		  }
%>
<div class="titleBg">
<h2>Country Master</h2>
</div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>Country Code</label>
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" />
<label>Country Name</label>
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO %>" value="2"checked="checked" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>"	value="" validate="Country Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'generalMaster?method=searchCountry')" />

<%--- Report Button   --%>


<input type="hidden" name="colCode" value="country_code">
<input type="hidden" name="colName" value="country_name">

<input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_country">
</div>
</form>
</div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(searchCountryList.size()>0 && currencyList.size() > 0)
		 {
			String strForCode = (String)map.get("countryCode");
			String strForCodeDescription = (String)map.get("countryName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="generalMaster?method=showCountryJsp">Show All Records</a></h4> <%
			}
		 }
	 if(searchCountryList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="generalMaster?method=showCountryJsp">Show All Records</a></h4>

<%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CURRENCY_ID %>"], [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script>
	</div>
<div class="Clear paddingTop15"></div>
<form name="country" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value="MasCountry">
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="CountryName">
<input type="hidden" name="title" value="Country">
<input	type="hidden" name="<%=JSP_NAME %>" value="country">
<input	type="hidden" name="pojoPropertyCode" value="CountryCode">
<div class="Block">
<label> Country Code <span>*</span></label>
<input id="codeId" type="text"	name="<%= CODE%>" value="" validate="Country Code,string,yes" MAXLENGTH="8" tabindex=1 />
<label>Country Name <span>*</span></label>
<input type="text" name="<%= SEARCH_NAME %>" value=""	validate="Country Name,string,yes" MAXLENGTH="30" tabindex=1 />
<script>
document.country.<%=CODE%>.focus();
</script>

<label>Currency <span>*</span></label>
<select name="<%= CURRENCY_ID %>" validate="Currency,string,yes" tabindex=1	onkeypress="return submitenter(this,event,'generalMaster?method=addCountry')">
<option value="0">Select</option>
	<% 
				for (MasCurrency  masCurrency : currencyList){
				%>
<option value="<%=masCurrency.getId ()%>"><%=masCurrency.getCurrencyName()%></option>
	<%}%>
</select>
	</div>
<div class="Clear"></div>

<div id="edited"></div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="add" id="addbutton"	value="Add" class="button" onClick="submitForm('country','generalMaster?method=addCountry');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" class="button"	onClick="submitForm('country','generalMaster?method=editCountry')" accesskey="u" tabindex=1 />
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" onClick="submitForm('country','generalMaster?method=deleteCountry&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input	type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName%></label>

<label class="bodytextB">Changed Date:</label>
<label class="value"><%=date%></label>

<label class="bodytextB">Changed Time:</label>
<label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

</div>




</form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Country Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Country Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Currency "
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=CURRENCY_ID %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_TIME %>"

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchCountryList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasCountry  masCountry = (MasCountry)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masCountry.getId()%>
data_arr[<%= counter%>][1] = "<%=masCountry.getCountryCode()%>"
data_arr[<%= counter%>][2] = "<%= masCountry.getCountryName()%>"

<%
		Iterator itrGridCurrencyList=gridCurrencyList.iterator();
		 while(itrGridCurrencyList.hasNext())
            {try{
             MasCurrency  currencyGrid = (MasCurrency)itrGridCurrencyList.next(); 
			 if(masCountry.getCurrency().getId().equals(currencyGrid.getId()) && currencyGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=currencyGrid.getCurrencyName()%>"
			<%}else if(masCountry.getId().equals(currencyGrid.getId()) && currencyGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=currencyGrid.getCurrencyName()%>";
				
			<%}
            }catch(Exception e){System.out.println("Exception----> "+e);}}%>
data_arr[<%= counter%>][4] = "<%= masCountry.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masCountry.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masCountry.getLastChgTime() %>"
<% if(masCountry.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "country"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
