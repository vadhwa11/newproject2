
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.TrainClassGroup"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />

<script type="text/javascript">

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
		
	List<TrainClassGroup> trainclassgroupList = new ArrayList<TrainClassGroup>();
	List<MasRankCategory> masrankcategoryList=new ArrayList<MasRankCategory>();
	List<MasRankCategory> searchmasrankcategoryList=new ArrayList<MasRankCategory>();
    List masUnitList = (List)map.get("masUnitList");
    if(map.get("trainclassgroupList")!=null)
    {
    	trainclassgroupList=(List)map.get("trainclassgroupList");
    }
    if(map.get("masrankcategoryList")!=null)
    {
    	masrankcategoryList=(List)map.get("masrankcategoryList");
    }
    if(map.get("searchmasrankcategoryList")!=null)
    {
    	searchmasrankcategoryList=(List)map.get("searchmasrankcategoryList");
    }
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
%>
<div id=contentspace">
<h2 align="left" class="style1">Train Class Group Master</h2>

<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action=""><font
	class="bodytextB_blue">RankCategory.:</font> <input type="text"
	id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="Search Field Required,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'generalMaster?method=searchCountry')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','hrOrderly?method=searchTrainClassGroupJsp','checkSearch')"
	tabindex=1 /></form>

</div>

</div>

<br />
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%=RANK_CATEGORY%>"], [2,"TrainClasses"],[3,"<%=STATUS%>"]];
	 statusTd = 3;
	</script> <%
	 if(map.get("search") != null)
	  {
	 %> <a href="hrOrderly?method=showTrainClassGroupJsp">Show All
Records</a> <%
     }
	%>
</div>
</div>
<br />
<div id="contentHolder">
<form name="traingroup" method="post" action="">


<div class=Clear></div>
<div class="division"></div>
<label><span>*</span>Rank Category</label> <select
	id="<%=RANK_CATEGORY%>" name="<%=RANK_CATEGORY%>" tabindex=1
	validate="Rank Category,string,yes">
	<option value="0">Select</option>
	<%if(masrankcategoryList!=null && masrankcategoryList.size()>0){
			for(MasRankCategory masrankcategory : masrankcategoryList){
		%>
	<option value="<%=masrankcategory.getId() %>"><%=masrankcategory.getRankCategoryName() %></option>
	<%}} %>
</select> <label><span>*</span>Train class</label> <select id="TrainClasses"
	multiple="multiple" size="6" class="listSm" name="TrainClasses"
	tabindex=1 validate=" Train Class,string,yes">
	<option value="0">Select</option>
	<option value="1AC">1AC</option>
	<option value="2AC">2AC</option>
	<option value="3AC">3AC</option>
	<option value="SL">SL</option>
	<option value="FC">FC</option>
</select>

<div class=Clear></div>
<div class="division"></div>
<div class=Clear></div>




<div class="clear"></div>
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName %></label> <label class="bodytextB">Changed
Date:</label> <label class="value"><%=date%></label> <label class="bodytextB">Changed
Time:</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="admin" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input type="hidden"
	name="Delete" value="" />


<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onclick="submitForm('traingroup','hrOrderly?method=addTrainClassGroupJsp');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('traingroup','hrOrderly?method=updateTrainClassGroupJsp')"
	accesskey="u" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="button" onclick="resetCheck();"
	accesskey="r" /> <input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" /></div>
<br />
</form>
</div>

<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "RankCategory"
data_header[0][1] = "data";
data_header[0][2] = "10%";
data_header[0][3] = "<%=RANK_CATEGORY%>"

data_header[1] = new Array;
data_header[1][0] = "TrainClasses"
data_header[1][1] = "data";
data_header[1][2] = "50%";
data_header[1][3] = "TrainClasses";

data_header[2] = new Array;
data_header[2][0] = "Status"
data_header[2][1] = "data";
data_header[2][2] = "10%";
data_header[2][3] = "<%=STATUS %>";


data_arr = new Array();

<%
if(searchmasrankcategoryList!=null){
Iterator itr=searchmasrankcategoryList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  MasRankCategory masrankcategory = (MasRankCategory)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= masrankcategory.getId()%>"
data_arr[<%= counter%>][1] = "<%=masrankcategory.getRankCategoryName()%>"

<%
 		  StringBuffer dept_names = new StringBuffer();
		  String status = "";
		  int temp =0;
		  if(trainclassgroupList!=null && trainclassgroupList.size()>0){
    	  for (Iterator iterator = trainclassgroupList.iterator(); iterator.hasNext();)
    	  {
    		  TrainClassGroup trainclassgroup = (TrainClassGroup)iterator.next();
    		  if (masrankcategory.getId() == trainclassgroup.getRankCategoryId().getId())
        	  {
    			  status = trainclassgroup.getStatus();
        		  
        		  if (dept_names.toString().length() > 0)
        		  {
        			  dept_names.append(",");
        			  if(temp ==7){
        				  temp=0;
        				  dept_names.append("\\n");
        				  dept_names.append(trainclassgroup.getTrainClasses());
        			  }else{
        			  dept_names.append(trainclassgroup.getTrainClasses());
        			  }
        		  }
        		  else
        		  {
        			  if(temp ==7){
        				  temp=0;
        				  dept_names.append("\\n");
        				  dept_names.append(trainclassgroup.getTrainClasses());
        			  }else{
        			  dept_names.append(trainclassgroup.getTrainClasses());
        			  }
        		  }

        		  temp++;
        	  }
    		 
	      }}
		  
    	  System.out.println("dept_names==========="+dept_names.toString());
    	  
    %>
data_arr[<%= counter%>][2] = "<%=dept_names.toString()%>"

<% if(masrankcategory.getStatus().equals("y")){ %>
data_arr[<%= counter%>][3] = "Active"
<%}else{%>
data_arr[<%= counter%>][3] = "InActive"
<%}%>
<%
		     counter++;
}}
%>
formName = "traingroup"


start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
