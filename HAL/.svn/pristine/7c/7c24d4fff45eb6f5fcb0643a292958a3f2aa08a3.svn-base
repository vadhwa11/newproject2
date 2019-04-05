<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemGeneric.jsp  
 * Purpose of the JSP -  This is for Item Generic.
 * @author  Abha
 * @author  Deepti
 * Create Date: 13st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.8
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasStoreItemGeneric"%>
<%@page import="jkt.hms.masters.business.MasStorePharmaIndex"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList searchItemGenericList = (ArrayList)map.get("searchItemGenericList");
	
	List<MasStorePharmaIndex> pharmaIndexList = new ArrayList<MasStorePharmaIndex>();
	pharmaIndexList = (ArrayList)map.get("pharamaIndexList");
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	
}
%>
<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %>
	   <h4><span><%=message %></span></h4>
	   <% 
	  }

%>
<div class="titleBg">
<h2>Generic Master</h2>
</div>
<div class="clear"></div>

<div id="searcharea">
<div id="searchbar">
			  <form name="search" method="post" action="">
			  <div class="Block">
			    <label>Generic Name </label>
				<input type="text" id="searchField" name="<%=SEARCH_NAME%>" value=""  validate="Generic Name,alphanumeric,no" MAXLENGTH="8" onkeypress="return submitenter(this,event,'pharmacy?method=searchItemGeneric')" />
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','pharmacy?method=searchItemGeneric','checkSearch')" tabindex=1  />
		            <%--- Report Button   --%>  <input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_store_generic">
		     <div class="clear"></div>
		     </div>
		     </form>
		 </div>
		  <div class="clear"></div>
</div>
 <div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
 <div id="searchresults" tabindex=2 >
 <div id="searchtable" tabindex=2 ></div>
 
 <% 
  if(searchItemGenericList.size()>0)
   {
   String strForCodeDescription = (String)map.get("itemGenericName");
   if(strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %> 
    <h4> <a  href="pharmacy?method=showItemGenericJsp">Show All Records</a></h2>
 <%
   }
   }
   
 if(searchItemGenericList.size()==0 && map.get("search") != null)
 {
%>
	 <h4> <a  href="pharmacy?method=showItemGenericJsp">Show All Records</a></h4>

<%
}
%>
 
 <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= PHARMA_INDEX_ID%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CONTRA_INDICATION %>"],[4,"<%= DOSAGE_CALCULATION %>"],[5,"<%= DRUG_INTERACTIONS %>"],[6,"<%= SPECIAL_PRECAUTION %>"],[7,"<%= SIDE_EFFECTS %>"],[8,"<%= CHANGED_BY %>"] [9,"<%= CHANGED_DATE %>"],[10,"<%= CHANGED_TIME %>"],[11,"<%=STATUS%>"] ];
  statusTd = 11;
 </script>
 </div>
  <div class="clear"></div>
  <form name="itemGeneric" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "MasStoreItemGeneric">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="GenericName">
  <input type="hidden" name="itemGeneric" value = "Generic">
  <input type="hidden" name="<%=JSP_NAME %>" value = "itemGeneric">
     <div class="clear"></div>
     <div class="clear"></div>
  <div class="Block">
  <label class="large"> PharmaIndex Name <span>*</span> </label>
		  <select name="<%=PHARMA_INDEX_ID %>" validate="Pharma Index Name,alphanumeric,yes" tabindex=1>
		  	<option value="">Select</option>
         <%
          		if(pharmaIndexList != null){ 	
          			for (Iterator iter = pharmaIndexList.iterator(); iter.hasNext();) {
          				MasStorePharmaIndex masStorePharmaIndex = (MasStorePharmaIndex) iter.next();
          %>
			<option value="<%=masStorePharmaIndex.getId() %>"><%=masStorePharmaIndex.getPharmaIndexName() %></option>           
         <%		
         			}
         		 } 
         %>
           </select>
   <label class="large">Generic Name <span>*</span> </label>
   <input type="text" name="<%= SEARCH_NAME %>" value="" validate="Generic Name,alphanumeric,yes"  MAXLENGTH="30" tabindex=1 />
   <script>
    document.itemGeneric.<%=SEARCH_NAME%>.focus();
   </script>
   <div class="clear"></div>
   
   <label class="large"> Contra Indication <span>*</span></label>
   <input type="text" name="<%= CONTRA_INDICATION%>" value="" validate="Contra Indication,alphanumeric,yes"  MAXLENGTH="200" />
		
		<label class="large"> Dosage Calculation <span>*</span></label>
		<input type="text" name="<%= DOSAGE_CALCULATION%>" value="" validate="Dosage Calculation,alphanumeric,yes"  MAXLENGTH="200" />
		<div class="clear"></div>
		
		<label class="large">Drug Interaction </label>
		<input type="text" name="<%= DRUG_INTERACTIONS%>" value="" validate="Drug Interaction,alphanumeric,no"  MAXLENGTH="200"/  >
		
		<label class="large">Special Precaution </label>
		<input type="text" name="<%= SPECIAL_PRECAUTION%>" value="" validate="Special Precaution,alphanumeric,no"  MAXLENGTH="200"/  >
		<div class="clear"></div>
		<label class="large">Side Effects </label>
		<input type="text" name="<%= SIDE_EFFECTS%>" value="" validate="Side Effects,alphanumeric,no"  MAXLENGTH="200" onkeypress="return submitenter(this,event,'pharmacy?method=addItemGeneric')" />
			</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
   <input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('itemGeneric','pharmacy?method=addItemGeneric');" accesskey="a" tabindex=1/>
   <input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('itemGeneric','pharmacy?method=editItemGeneric')" accesskey="u" tabindex=1 />
   <input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('itemGeneric','pharmacy?method=deleteItemGeneric&flag='+this.value)" accesskey="d" tabindex=1/>  
   <input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
   <input type="hidden" name="<%=STATUS %>" value="" />
   <input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By </label>   
			<label class="value"><%=userName%></label>
        
			<label>Changed Date </label>   
			<label class="value"><%=date%></label>
			 
			<label>Changed Time </label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />
			 </div> 
			 </form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Pharma Index Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= PHARMA_INDEX_ID%>"

data_header[1] = new Array;
data_header[1][0] = "Generic Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%=CONTRA_INDICATION %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=DOSAGE_CALCULATION %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=DRUG_INTERACTIONS %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=SPECIAL_PRECAUTION %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%=SIDE_EFFECTS %>"

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
data_header[9][0] = "Admin"
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%=CHANGED_TIME %>"

data_header[10] = new Array;
data_header[10][0] = "Status"
data_header[10][1] = "data";
data_header[10][2] = "15%";
data_header[10][3] = "<%=STATUS %>";

data_arr = new Array();
<%
Iterator itr=searchItemGenericList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
        	  MasStoreItemGeneric  masStoreItemGeneric = (MasStoreItemGeneric)itr.next();       

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masStoreItemGeneric.getId()%>
<%
Iterator itrPharmaIndexList=pharmaIndexList.iterator();
while(itrPharmaIndexList.hasNext())
      {
       MasStorePharmaIndex  masPharmaIndexGrid = (MasStorePharmaIndex)itrPharmaIndexList.next(); 
	 if(masStoreItemGeneric.getPharmaIndex().getId().equals(masPharmaIndexGrid.getId()) && masPharmaIndexGrid.getStatus().equals("y")){%>
		data_arr[<%= counter%>][1] = "<%=masPharmaIndexGrid.getPharmaIndexName()%>"
	<%}else if(masStoreItemGeneric.getPharmaIndex().getId().equals(masPharmaIndexGrid.getId()) && masPharmaIndexGrid.getStatus().equals("n")){%>
		data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=masPharmaIndexGrid.getPharmaIndexName()%>";
	<%}
}%>
data_arr[<%= counter%>][2] = "<%= masStoreItemGeneric.getGenericName()%>"
data_arr[<%= counter%>][3] = "<%= masStoreItemGeneric.getContraIndication()%>"
data_arr[<%= counter%>][4] = "<%= masStoreItemGeneric.getDosageCalculation()%>"
data_arr[<%= counter%>][5] = "<%= masStoreItemGeneric.getDrugInteraction()%>"
data_arr[<%= counter%>][6] = "<%= masStoreItemGeneric.getSpecialPrecaution()%>"
data_arr[<%= counter%>][7] = "<%= masStoreItemGeneric.getSideEffects()%>"
data_arr[<%= counter%>][8] = "<%= masStoreItemGeneric.getLastChgBy() %>"
data_arr[<%= counter%>][9] = "<%= HMSUtil.convertDateToStringWithoutTime(masStoreItemGeneric.getLastChgDate()) %>"
data_arr[<%= counter%>][10] = "<%= masStoreItemGeneric.getLastChgTime() %>"
<% if(masStoreItemGeneric.getStatus().equals("y")){ %>
data_arr[<%= counter%>][11] = "Active"
<%}else{%>
data_arr[<%= counter%>][11] = "InActive"
<%}%>
<%
       counter++;
}
%>
 
formName = "itemGeneric"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>