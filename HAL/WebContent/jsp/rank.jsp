<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * rank.jsp  
 * Purpose of the JSP -  This is for Rank.
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.8
--%>
<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
	serviceTypeList = (ArrayList)map.get("serviceTypeList");
	
	List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
	rankCategoryList = (ArrayList)map.get("rankCategoryList");
	
	List<MasServiceStatus> serviceStatusList = new ArrayList<MasServiceStatus>();
	serviceStatusList = (ArrayList)map.get("serviceStatusList");
	
	ArrayList searchRankList = (ArrayList)map.get("searchRankList");
	ArrayList gridServiceTypeList = (ArrayList)map.get("gridServiceTypeList");
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
<h2>Rank Master</h2>
</div>
<div id="searcharea">
<form name="search" method="post" action="">
<div class="Block">
<label>Rank Code</label>
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" />
<label>Rank  Name</label>
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value="2"  />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Rank Code,string,no"   MAXLENGTH="140" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=searchRank')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','personnel?method=searchRank','checkSearch')" tabindex=1  />
<input type="hidden" name="colCode" value="rank_code">
<input type="hidden" name="colName" value="rank_name">
<%--- Report Button   --%>  
<input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1/>
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_rank">
</div>
</form>
<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" >
<div id="searchtable" ></div>
	<% 
  if(searchRankList.size()>0)
   {
   String strForCode = (String)map.get("rankCode");
   String strForCodeDescription = (String)map.get("rankName");
   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %> 
  <br/>
  
   <h4> <a href="personnel?method=showRankJsp">Show All Records</a></h4>
	<%
			}
		 }
	 if(searchRankList.size()==0 && map.get("search") != null)
	  {
	 %>
				<h4><a href="personnel?method=showRankJsp">Show All Records</a></h4>

	 <%
     }
	%>
	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= RANK_CATEGORY_ID %>"],  [4,"<%=CHANGED_BY%>"], [5,"<%=CHANGED_DATE%>"],[6,"<%=CHANGED_TIME%>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script>
	</div>
	
  <form name="rank" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "MasRank">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value = "RankName">
  <input type="hidden" name="title" value = "Rank">
  <input type="hidden" name="<%=JSP_NAME %>" value = "rank">
  <input type="hidden" name="pojoPropertyCode" value = "RankCode">
		
	  		
	  		
	  	<div class="Clear"></div>	
 	<div class="Block">

	  	<label > Rank Code <span>*</span> </label>
		<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Rank Code,string,yes"  MAXLENGTH="140" tabindex=1 >
  		<label > Rank Name<span>*</span> </label>
			<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Rank Name,string,yes"  MAXLENGTH="140" tabindex=1 >
			<script>
				document.rank.<%=CODE%>.focus();
			</script>
			<label > Rank Category <span>*</span> </label>
		<select name="<%= RANK_CATEGORY_ID %>" validate="Rank Category,string,yes" tabindex=1>
			<option value="">Select</option>
			  <% 
				
				for (MasRankCategory  masRankCategory : rankCategoryList){
				%>
		    
			  <option value="<%=masRankCategory.getId ()%>"><%=masRankCategory.getRankCategoryName()%></option>
			  		  
			  <%}%>
			</select>
		<div class="Clear"></div>
			
		<%-- <label > Service Status <span>*</span></label>
		<select name="<%= SERVICE_STATUS_ID %>" validate="v,string,yes" tabindex=1>
			<option value="">Select</option>
			  <% 
				
				for (MasServiceStatus  masServiceStatus : serviceStatusList){
				%>
		    
			  <option value="<%=masServiceStatus.getId ()%>"><%=masServiceStatus.getServiceStatusName()%></option>
			  		  
			  <%}%>
			</select>
		
			<label >  Service Type <span>*</span></label>
			<select name="<%= SERVICE_TYPE_ID %>" validate="Service Type,string,yes" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=addRank')">
			<option value="">Select</option>
			  <% 
				
				for (MasServiceType  masServiceType : serviceTypeList){
				%>
		    
			  <option value="<%=masServiceType.getId ()%>"><%=masServiceType.getServiceTypeName()%></option>
			  		  
			  <%}%>
			</select>
			 --%>
			
			</div>
<div class="Clear"></div>
<div id="edited"></div>
<div class="division"></div>
<div class="Clear"></div>

			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('rank','personnel?method=addRank');" accesskey="a" tabindex=1/>
			<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('rank','personnel?method=editRank')" accesskey="u" tabindex=1 />
			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('rank','personnel?method=deleteRank&flag='+this.value)" accesskey="d" tabindex=1/>		
			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />	
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom">
<label >Changed By:</label>   
			<label class="value"><%=userName%></label>
			        
			<label >Changed Date:</label>   
			<label class="value"><%=date%></label>
			 
			<label >Changed Time:</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />		   			
   </div>	
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Rank Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Rank Name"
data_header[1][1] = "data";
data_header[1][2] = "30%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Rank Category"
data_header[2][1] = "data";
data_header[2][2] = "30%";
data_header[2][3] = "<%= RANK_CATEGORY_ID %>";

<%-- data_header[3] = new Array;
data_header[3][0] = "Service Status"
data_header[3][1] = "data";
data_header[3][2] = "20%";
data_header[3][3] = "<%= SERVICE_STATUS_ID %>";

data_header[4] = new Array;
data_header[4][0] = "Service Type"
data_header[4][1] = "data";
data_header[4][2] = "35%";
data_header[4][3] = "<%=SERVICE_TYPE_ID %>"; --%>

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] =  "<%=CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] ="<%=CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] =  "<%=CHANGED_TIME %>"

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%

Iterator itr=searchRankList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasRank  masRank = (MasRank)itr.next(); 
  %>            

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%=masRank.getId()%>"
	<%
	String rankcode=masRank.getRankCode()!=null ? masRank.getRankCode().trim():"";
	rankcode = rankcode.replace("\r", "$");
	rankcode = rankcode.replace("\n", "^");
	%>
		var rankcode = "<% out.print(rankcode); %>";		
		rankcode = rankcode.split('$').join("\r");
		rankcode = rankcode.split('^').join("\n");	  
	  
	data_arr[<%= counter%>][1] = rankcode;

	<%
	String rankname=masRank.getRankCode()!=null ? masRank.getRankCode().trim():"";
	rankname = rankname.replace("\r", "$");
	rankname = rankname.replace("\n", "^");
	%>

	var rankname = "<% out.print(rankname); %>";	
	rankname = rankname.split('$').join("\r");
	rankname = rankname.split('^').join("\n");	 

	data_arr[<%= counter%>][2] = rankname;
<%
	Iterator itrRankCategoryList=rankCategoryList.iterator();
	 while(itrRankCategoryList.hasNext())
           {
            MasRankCategory  masRankCategoryGrid = (MasRankCategory)itrRankCategoryList.next(); 
		 if(masRank.getRankCategory().getId().equals(masRankCategoryGrid.getId()) && masRankCategoryGrid.getStatus().equals("y")){%>
			data_arr[<%= counter%>][3] = "<%=masRankCategoryGrid.getRankCategoryName()%>"
		<%}else if(masRank.getRankCategory().getId().equals(masRankCategoryGrid.getId()) && masRankCategoryGrid.getStatus().equals("n")){%>
			data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masRankCategoryGrid.getRankCategoryName()%>";
			
		<%}
}%>
<%-- <%
	Iterator itrServiceStatusList=serviceStatusList.iterator();
	 while(itrServiceStatusList.hasNext())
           {
            MasServiceStatus  masServiceStatusGrid = (MasServiceStatus)itrServiceStatusList.next(); 
		 if(masRank.getServiceStatus().getId().equals(masServiceStatusGrid.getId()) && masServiceStatusGrid.getStatus().equals("y")){%>
			data_arr[<%= counter%>][4] = "<%=masServiceStatusGrid.getServiceStatusName()%>"
		<%}else if(masRank.getServiceStatus().getId().equals(masServiceStatusGrid.getId()) && masServiceStatusGrid.getStatus().equals("n")){%>
			data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=masServiceStatusGrid.getServiceStatusName()%>";
			
		<%}
}%>

<%
		Iterator itrGridServiceTypeList=gridServiceTypeList.iterator();
		 while(itrGridServiceTypeList.hasNext())
            {try{
             MasServiceType  serviceTypeGrid = (MasServiceType)itrGridServiceTypeList.next(); 
			 if(masRank.getServiceType().getId().equals(serviceTypeGrid.getId()) && serviceTypeGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][5] = "<%=serviceTypeGrid.getServiceTypeName()%>"
			<%}else if(masRank.getId().equals(serviceTypeGrid.getId()) && serviceTypeGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=serviceTypeGrid.getServiceTypeName()%>";
				
			<%}
            }catch(Exception e){e.printStackTrace();}}%> --%>
data_arr[<%= counter%>][4] = "<%= masRank.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masRank.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masRank.getLastChgTime() %>"
<% if(masRank.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "rank"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  