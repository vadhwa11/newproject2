<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasPool"%>
<%@page import="jkt.hms.masters.business.MasPoolCategory"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.PoolRank"%>
<%
	Map<String ,Object> map = new HashMap<String ,Object>();
	if(request.getAttribute("map") != null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String ,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList<MasPool> searchPoolList = (ArrayList<MasPool>)map.get("searchPoolList");
	ArrayList<MasPoolCategory> poolCategoryList = (ArrayList<MasPoolCategory>)map.get("poolCategoryList");
	ArrayList<MasPoolCategory> gridPoolCategoryList = (ArrayList<MasPoolCategory>)map.get("gridPoolCategoryList");
	ArrayList<MasRank> rankList = (ArrayList<MasRank>)map.get("rankList");
	ArrayList<PoolRank> gridRankList = (ArrayList<PoolRank>)map.get("gridRankList");
	String userName = "";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}
	String message="";
	if(map.get("message") != null){
	 	message = (String)map.get("message");
%>

<h4><span><%=message %></span></h4>
<%} %>
<script>
function authorizationCheck(){
var auth;
auth = document.getElementById('<%=AUTHORISATION%>').value;
if(auth > 100){
alert("Authorisation cannot extend 100 %")
return false;
}else{
return true;
}
}
</script>
<script>
function checkSpecialChar(){
var code;
 code = document.getElementById('codeId').value;
 
 var name ;
 name= document.getElementById('search_name').value;
 if(code.match("\"")|| name.match("\"")){
 alert('Please Do not enter " as Entry field')
 return false;
 }else if(code.match("\<")|| name.match("\<")){
 alert('Please Do not enter < as Entry field')
 return false;
 }
 else{
 return true;
 }
}

</script>
<div class="titleBg">
<h2>Pool Master</h2>
</div>
<div class="Clear"></div>

<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>Pool Code</label> 
<input type="radio" name="<%=SELECTED_RADIO  %>" class="radioAuto"
	value="1" checked="checked" /> <label>Pool Name</label> <input
	type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioAuto" /> <input
	type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="Pool Code,string,no" MAXLENGTH="30" tabindex=1
	onkeypress="return submitenter(this,event,'accom?method=searchPool')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','accom?method=searchPool','checkSearch')"
	tabindex=1 /></form>
</div>
</div>
<div class="Clear"></div>
</div>

<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
		if(searchPoolList.size()>0)
		 {
			String strForCode = (String)map.get("poolCode");
			String strForCodeDescription = (String)map.get("poolName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%>
<div class="Clear"></div>
<h4><a href="accom?method=showPoolMasterJsp">Show All Records</a></h4>
<div class="Clear"></div>
<%
			}
		 }
	 if(searchPoolList.size()==0 && map.get("search") != null)
	  {
	 %>
<div class="Clear"></div>
<h4><a href="accom?method=showPoolMasterJsp">Show All Records</a></h4>
<div class="Clear"></div>
<%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= RANK_ID %>"],[3,"<%= SEARCH_NAME %>"],[4,"<%= AUTHORISATION %>"],[5,"<%= RANK_NAME %>"],[6,"<%= POOL_CATEGORY_ID %>"],[7,"<%= CHANGED_BY%>"], [8,"<%= CHANGED_DATE %>"],[9,"<%= CHANGED_TIME %>"],[10,"<%=STATUS%>"] ];
	 statusTd =10;
	</script></div>
<div class="Clear"></div>
<form name="poolCategory" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasPool"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="PoolName">
<input type="hidden" name="title" value="Pool"> <input
	type="hidden" name="<%=JSP_NAME %>" value="pool"> <input
	type="hidden" name="pojoPropertyCode" value="PoolCode">

<div class="Block">
<label class="common"><span>*</span> Pool Code</label> <input
	id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Pool Code,string,yes" maxlength="8" tabindex=1 /> <label
	class="common"><span>*</span> Pool Name</label> <input type="text"
	name="<%= SEARCH_NAME %>" id="<%=SEARCH_NAME %>" value=""
	validate="Pool Name,string,yes" maxlength="30" tabindex=1
	onkeypress="return submitenter(this,event,'accom?method=addPool')" />
<script>
				document.poolCategory.<%=CODE%>.focus();
			</script> <label class="common">Authorisation(%) </label> <input
	id="<%= AUTHORISATION%>" type="text" name="<%=AUTHORISATION%>" value=""
	validate="Authorisation,int,no" maxlength="3" tabindex=1 />
<div class="Clear"></div>
<label class="common"><span>*</span> Rank</label> <select
	name="<%= RANK_ID %>" id="rank_id" size="4"
	style="height: 110; width: 130;" validate="rank,string,yes" multiple
	class="list" tabindex=1 />
	<option value="0">Select</option>
	<% 
    			for (MasRank  masRank : rankList){
    		%>
	<option value="<%=masRank.getId ()%>"><%=masRank.getRankName()%></option>

	<%}%>
</select> <label class="common"><span>*</span> Pool Category</label> <select
	name="<%= POOL_CATEGORY_ID %>" tabindex=1
	validate="pool category,string,yes" />
	<option value="0">Select</option>
	<% 
    			for (MasPoolCategory  masPoolCategory : poolCategoryList){
    		%>
	<option value="<%=masPoolCategory.getId ()%>"><%=masPoolCategory.getPoolCategoryName()%></option>

	<%}%>
</select>
<div class="clear"></div>
</div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton"
	value="Save" class="button"
	onClick="if(authorizationCheck() && checkSpecialChar()){submitForm('poolCategory','accom?method=addPool');}"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="if(authorizationCheck() && checkSpecialChar()){submitForm('poolCategory','accom?method=editPool');}"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('poolCategory','accom?method=deletePool&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r"
	tabindex="1" /> <input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="Clear"></div>

<div id="edited"></div>



<div class="Clear"></div>
</form>



<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Pool Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Rank Id"
data_header[1][1] = "hide";
data_header[1][2] = "40%";
data_header[1][3] = "<%= RANK_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Pool Name"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= SEARCH_NAME %>";

data_header[3] = new Array;
data_header[3][0] = "Authorisation"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%= AUTHORISATION %>";

data_header[4] = new Array;
data_header[4][0] = "Rank Name"
data_header[4][1] = "data";
data_header[4][2] = "40%";
data_header[4][3] = "<%= RANK_NAME %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "40%";
data_header[5][3] = "<%= POOL_CATEGORY_ID %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_BY %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%= CHANGED_DATE %>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "15%";
data_header[8][3] = "<%= CHANGED_TIME %>";

data_header[9] = new Array;
data_header[9][0] = "Status"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator<MasPool> itr=searchPoolList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            MasPool  masPool = (MasPool)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= masPool.getId()%>"
data_arr[<%= counter%>][1] = "<%=masPool.getPoolCode()%>"

<%
 		  StringBuffer rank_ids = new StringBuffer();
		  StringBuffer rank_names = new StringBuffer();
    	  for (Iterator<PoolRank> iterator = gridRankList.iterator();  iterator.hasNext();)
    	  {
    		  PoolRank poolRank = (PoolRank) iterator.next();
    		  if (masPool.getId() == poolRank.getPool().getId())
        	  {
           		  if (rank_ids.toString().length() > 0)
        		  {
        			  rank_ids.append(",");
        			  rank_ids.append(poolRank.getRank().getId());
        		  }
        		  else
        		  {
        			  rank_ids.append(poolRank.getRank().getId());
        		  }
        		  
        		  if (rank_names.toString().length() > 0)
        		  {
        			  rank_names.append(",");
        			  rank_names.append(poolRank.getRank().getRankName());
        		  }
        		  else
        		  {
        			  rank_names.append(poolRank.getRank().getRankName());
        		  }

        		  
        	  }
	      }
    %>

data_arr[<%= counter%>][2] = "<%=rank_ids.toString()%>"
data_arr[<%= counter%>][3] = "<%= masPool.getPoolName()%>"
data_arr[<%= counter%>][4] = "<%= masPool.getAuthorisation()%>"
data_arr[<%= counter%>][5] = "<%=rank_names.toString()%>"


<%
		Iterator<MasPoolCategory> itrGridPoolCategoryList=gridPoolCategoryList.iterator();
		 while(itrGridPoolCategoryList.hasNext())
            {try{
             MasPoolCategory  poolCategoryGrid = (MasPoolCategory)itrGridPoolCategoryList.next(); 
			 if(masPool.getPoolCategory().getId().equals(poolCategoryGrid.getId()) && poolCategoryGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][6] = "<%=poolCategoryGrid.getPoolCategoryName()%>"
			<%}else if(masPool.getPoolCategory().getId().equals(poolCategoryGrid.getId()) && poolCategoryGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][6] = "<font id='error'>*</font>Parent InActivated--<%=poolCategoryGrid.getPoolCategoryName()%>";
				
			<%}
            }catch(Exception e){}}
%>

data_arr[<%= counter%>][7] = "<%= masPool.getLastChgBy() %>"
data_arr[<%= counter%>][8] = "<%= HMSUtil.convertDateToStringWithoutTime(masPool.getLastChgDate()) %>"
data_arr[<%= counter%>][9] = "<%= masPool.getLastChgTime() %>"
<% if(masPool.getStatus().equals("y")){ %>
data_arr[<%= counter%>][10] = "Active"
<%}else{%>
data_arr[<%= counter%>][10] = "InActive"
<%}%>
<%
		     counter++;
}
          
%>
 
formName = "poolCategory"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
