
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchStoreSectionList = (ArrayList)map.get("searchStoreSectionList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	 List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
		if(map.get("itemTypeList") != null){
			itemTypeList = (List)map.get("itemTypeList");
		}
%>
<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %>
	   <h4><%=message %></h4>
	   <% 
	  }

%>
<div class="titleBg"><h2>Item Section Master</h2></div>
<div class="Clear"></div>

<div id="searcharea">
<div class="Block">
			  <form name="search" method="post" action="">
			    <label class="auto">Section Code</label>
			    	<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO  %>"   value="1" checked="unchecked" />
						<label class="auto">Section Name</label>
					<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value="2" checked="checked" maxlength="2" />
				
				<input type="hidden" name="colCode" value="section_code">
					<input type="hidden" name="colName" value="section_name">
				
					 <input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Section Code,alphanumeric,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'pharmacy?method=searchStoreSection')" />
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','pharmacy?method=searchStoreSection','checkSearch')" tabindex=1  />
		            <%--- Report Button   --%>  <input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1/>
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_item_section">
		     </form>
 <div class="Clear"></div>
		 </div>
		
 </div>
			 	 
	<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
	
	<% 
		if(searchStoreSectionList.size()>0)
		 {
			String strForCode = (String)map.get("sectionCode");
			String strForCodeDescription = (String)map.get("sectionName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
    <h4> <a  href="pharmacy?method=showStoreSectionJsp">Show All Records</a></h4>
	<%
			}
		 }
	if(searchStoreSectionList.size()==0 && map.get("search") != null)
	  {
	 %>
			 <h4> <a  href="pharmacy?method=showStoreSectionJsp">Show All Records</a></h4>

	 <%
}
	%>

	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"itemTypeId"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script>
	</div>
	
  <form name="section" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "MasStoreSection">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="SectionName">
  <input type="hidden" name="title" value = "Section">
  <input type="hidden" name="<%=JSP_NAME %>" value = "section">
  <input type="hidden" name="pojoPropertyCode" value = "SectionCode">
		
	  <div class="Clear"></div>		
 	<div class="Block">

	  	<label > Section Code <span>*</span></label>
		<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Section Code,alphanumeric,yes"  MAXLENGTH="2" tabindex=1 />
  		<label > Section Name <span>*</span></label>
			<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Section Name,alphanumeric,yes"  MAXLENGTH="200" tabindex=1  onkeypress="return submitenter(this,event,'pharmacy?method=addStoreSection')"/>
			<script>
				document.storeSection.<%=CODE%>.focus();
			</script>
					
					
					<label><span>*</span> Item Type </label>
<select name="itemTypeId" id="itemTypeId"	validate="Item  Type,string,yes" tabindex=1>
	<option value="0">Select</option>
	<% 					
				for (MasItemType  masItemType : itemTypeList){
				%>
	<option value="<%=masItemType.getId()%>"><%=masItemType.getItemTypeName().trim()%></option>
	<%}%>
</select>
			</div>
<div class="Clear"></div>
<div class="division"></div>
		<div id="edited"></div>
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('section','pharmacy?method=addStoreSection');" accesskey="a" tabindex=1/>
			<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('section','pharmacy?method=editStoreSection')" accesskey="u" tabindex=1 />
			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('section','pharmacy?method=deleteStoreSection&flag='+this.value)" accesskey="d" tabindex=1/>		
				<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
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
	

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Section Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Section Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%= CHANGED_TIME %>";




data_header[5] = new Array;
data_header[5][0] = "Item Type"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "itemTypeId";

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchStoreSectionList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasStoreSection  masStoreSection = (MasStoreSection)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masStoreSection.getId()%>
data_arr[<%= counter%>][1] = "<%=masStoreSection.getSectionCode()%>"
data_arr[<%= counter%>][2] = "<%= masStoreSection.getSectionName()%>"

data_arr[<%= counter%>][3] = "<%= masStoreSection.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masStoreSection.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masStoreSection.getLastChgTime() %>"

	<%
	if(masStoreSection.getItemType()!= null){
	%>

	<%
	for(MasItemType masItemType :itemTypeList){
	     
		 if(masStoreSection.getItemType().getId().equals(masItemType.getId()) && masItemType.getStatus().equalsIgnoreCase("y")){%>
			data_arr[<%= counter%>][6] = "<%=masItemType.getItemTypeName().trim()%>"
		<%}else if(masStoreSection.getItemType().getId().equals(masItemType.getId()) && masItemType.getStatus().equalsIgnoreCase("n")){%>
			data_arr[<%= counter%>][6] = "<font id='error'>*</font>Parent InActivated--<%=masItemType.getItemTypeName().trim()%>";
		<%}
	}%>
	<%}else{
	%>
	data_arr[<%= counter%>][6] = "-"
	<%}%>

	

<% if(masStoreSection.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "section"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
