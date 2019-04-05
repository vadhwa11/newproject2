<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasPool"%>
<%@page import="jkt.hms.masters.business.MasPoolCategory"%>
<%@page import="jkt.hms.masters.business.MasSmq"%>
<%@page import="jkt.hms.masters.business.MasLocation"%>
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
	ArrayList<MasSmq> searchSmqList = null;
	if(map.get("searchSmqList")!=null){
		searchSmqList = (ArrayList<MasSmq>)map.get("searchSmqList");
	}
	ArrayList<MasPoolCategory> poolCategoryList = null;
	if(map.get("poolCategoryList")!=null){
		poolCategoryList = (ArrayList<MasPoolCategory>)map.get("poolCategoryList");
	}
	ArrayList<MasPoolCategory> gridPoolCategoryList = null;
	if(map.get("gridPoolCategoryList")!=null){
		gridPoolCategoryList = (ArrayList<MasPoolCategory>)map.get("gridPoolCategoryList");
	}
	ArrayList<MasPool> poolList = null;
	if(map.get("poolList")!=null){
		poolList = (ArrayList<MasPool>)map.get("poolList");
	}
	ArrayList<MasPool> gridPoolList = null;
	if(map.get("gridPoolList")!=null){
		gridPoolList = (ArrayList<MasPool>)map.get("gridPoolList");
	}
	ArrayList<MasLocation> locationList = null;
	if(map.get("locationList")!=null){
		locationList = (ArrayList<MasLocation>)map.get("locationList");
	}
	ArrayList<MasLocation> gridLocationList = null;
	if(map.get("gridLocationList")!=null){
		gridLocationList = (ArrayList<MasLocation>)map.get("gridLocationList");
	}
	String SmqCode ="";
	if(map.get("SmqCode")!=null ){
		SmqCode= (String)map.get("SmqCode");
	}
	String userName = "";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}
	String message="";
	if(map.get("message") != null){
	 	message = (String)map.get("message");
%>

<h4><span><%=message %></span></h2>
<div class="Clear"></div>
<%} %>
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
<h2>SMQ Master</h2>
</div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>SMQ Code</label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1"  checked="checked" class="radioAuto" /> 
<label>SMQ Name</label> 
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radio"  /> 
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="SMQ Code,string,no" MAXLENGTH="30" tabindex=1
	onkeypress="return submitenter(this,event,'accom?method=searchSmqMaster')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','accom?method=searchSmqMaster','checkSearch')"
	tabindex=1 /></div></form>
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
		if(searchSmqList.size()>0)
		 {
			String strForCode = (String)map.get("smqCode");
			String strForCodeDescription = (String)map.get("smqName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%>
<div class="Clear"></div>
<h4><a href="accom?method=showSMQJsp">Show All Records</a></h4>
<div class="Clear"></div>
<%
			}
		 }
	 if(searchSmqList.size()==0 && map.get("search") != null)
	  {
	 %>
<div class="Clear"></div>
<h4><a href="accom?method=showSMQJsp">Show All Records</a></h4>
<div class="Clear"></div>

<%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= LOCATION_ID %>"],[4,"<%= SMQ_TYPE %>"],[5,"<%= POOL_CATEGORY_ID %>"],[6,"<%=POOL_ID%>"],[7,"<%=SMQ_STATUS%>"],[8,"<%= CHANGED_BY%>"], [9,"<%= CHANGED_DATE %>"],[10,"<%= CHANGED_TIME %>"],[11,"<%=STATUS%>"] ];
	 statusTd = 11;
	</script></div>
<form name="poolCategory" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value="MasSmq"> 
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="SmqName">
<input type="hidden" name="title" value="SMQ"> 
<input type="hidden" name="<%=JSP_NAME %>" value="smq"> 
<input type="hidden" name="pojoPropertyCode" value="SmqCode">
<div class="Block"> 
<label class="common"><span>*</span> SMQ Code</label> 
<input type="text" id="codeId" type="text" name="<%= CODE%>" value="<%=SmqCode %>" validate="SMQ Code,string,yes" maxlength="8" tabindex=1 readonly="readonly"/> 
<label class="common"><span>*</span> SMQ Name</label> 
<input type="text" name="<%= SEARCH_NAME %>" id="<%= SEARCH_NAME %>" value="" validate="SMQ Name,string,yes" maxlength="30" tabindex=1 /> 
<script>
	document.poolCategory.<%= SEARCH_NAME %>.focus();
</script> 
<label class="common"><span>*</span> Location</label> 
<select name="<%= LOCATION_ID %>" validate="Location,string,yes" tabindex=1 />
	<option value="0">Select</option>
	<%
	    	 	if(locationList.size() >0){
	    			for (MasLocation  masLocation : locationList){
	    		%>
	<option value="<%=masLocation.getId ()%>"><%=masLocation.getLocationName()%></option>

	<%}}%>
</select>
<div class="Clear"></div>

<label class="common"><span>*</span> SMQ Type</label> <select
	name="<%=SMQ_TYPE %>" id="<%=SMQ_TYPE %>" tabindex="1"
	validate="SMQ Type,string,yes" />
	<option value="">Select</option>
	<option value="t">Temporary</option>
	<option value="p">Permanent</option>
</select> <label class="common"><span>*</span> Pool Category</label> <select
	name="<%= POOL_CATEGORY_ID %>" validate="Pool Category,string,yes"
	onChange="populatePoolCode(this.value,'poolCategory')" tabindex="1" />
	<option value="0">Select</option>
	<% if(poolCategoryList.size()>0){
    	 		for (MasPoolCategory  masPoolCategory : poolCategoryList){
    		 %>
	<option value="<%=masPoolCategory.getId ()%>"><%=masPoolCategory.getPoolCategoryName()%></option>
	<%}}%>
</select> <script type="text/javascript">
   			poolArray1 = new Array();
			<%
			int count = 0;
			for (Iterator<MasPoolCategory> iter = poolCategoryList.iterator(); iter.hasNext();) 
			{
				MasPoolCategory masPoolCategory = (MasPoolCategory) iter.next();
				for (Iterator<MasPool> iterPool = poolList.iterator(); iterPool.hasNext();) 
				{
					MasPool pool = (MasPool) iterPool.next();
					if(masPoolCategory.getId().equals(pool.getPoolCategory().getId())){
								%>
									poolArray1[<%=count%>] = new Array();
									poolArray1[<%=count%>][0] = <%=masPoolCategory.getId()%>;
									poolArray1[<%=count%>][1] = <%=pool.getId()%>;									
									poolArray1[<%=count%>][2] = "<%=pool.getPoolName()%>";

								<%
								count++;
						}
					}
				}
			
		%>
		</script> <label class="common"><span>*</span> Pool Code</label> <select
	name="<%= POOL_ID %>" id="<%=POOL_ID %>"
	validate="Pool Code,string,yes" tabindex="1" />
	<option value="0">Select</option>
	<% 
    			for (MasPool  masPool : poolList){
    		%>
	<option value="<%=masPool.getId ()%>"><%=masPool.getPoolName()%></option>

	<%}%>
</select>
<div class="Clear"></div>
<label class="common" id="smq"><span>*</span> SMQ Status</label> <select
	name="<%=SMQ_STATUS %>" id="<%=SMQ_STATUS %>" tabindex="1"
	validate="SMQ Status,string,yes"
	onkeypress="return submitenter(this,event,'accom?method=addSmqMaster')" />
	<option value="">Select</option>
	<option value="v">Vacant</option>
	<option value="m">Maintenance</option>
</select>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton"
	value="Save" class="button"
	onClick="if(checkSpecialChar()){submitForm('poolCategory','accom?method=addSmqMaster');}"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="if(checkSpecialChar()){submitForm('poolCategory','accom?method=editSMQ');}"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('poolCategory','accom?method=deleteSmqMaster&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheckForSmq();"
	accesskey="r" tabindex="1" /> <input type="hidden" name="<%=STATUS %>"
	value="" /> <input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label> <label class="value"><%=userName%></label> <label>Changed
Date:</label> <label class="value"><%=date%></label> <label>Changed Time:</label>
<label class="value"><%=time%></label></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="Clear"></div>

<div id="edited"></div>

<div class="Clear"></div>
</form>

</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "SMQ Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "SMQ Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Location"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= LOCATION_ID %>";

data_header[3] = new Array;
data_header[3][0] = "SMQ Type"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%= SMQ_TYPE%>";

data_header[4] = new Array;
data_header[4][0] = "Pool Category"
data_header[4][1] = "data";
data_header[4][2] = "40%";
data_header[4][3] = "<%= POOL_CATEGORY_ID %>";

data_header[5] = new Array;
data_header[5][0] = "Pool Code"
data_header[5][1] = "data";
data_header[5][2] = "40%";
data_header[5][3] = "<%= POOL_ID%>";

data_header[6] = new Array;
data_header[6][0] = "SMQ Status"
data_header[6][1] = "data";
data_header[6][2] = "40%";
data_header[6][3] = "<%= SMQ_STATUS %>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%= CHANGED_BY %>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%= CHANGED_DATE %>"

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "<%= CHANGED_TIME %>";

data_header[10] = new Array;
data_header[10][0] = "Status"
data_header[10][1] = "data";
data_header[10][2] = "15%";
data_header[10][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator<MasSmq> itr=searchSmqList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            MasSmq  masSmq = (MasSmq)itr.next(); 
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masSmq.getId()%>
data_arr[<%= counter%>][1] = "<%=masSmq.getSmqCode()%>"
data_arr[<%= counter%>][2] = "<%= masSmq.getSmqName()%>"

<%
		Iterator<MasLocation> itrGridLocationList=gridLocationList.iterator();
		 while(itrGridLocationList.hasNext())
            {try{
             MasLocation  locationGrid = (MasLocation)itrGridLocationList.next(); 
			 if(masSmq.getLocation().getId().equals(locationGrid.getId()) && locationGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=locationGrid.getLocationName()%>"
			<%}else if(masSmq.getLocation().getId().equals(locationGrid.getId()) && locationGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=locationGrid.getLocationName()%>";
				
			<%}
            }catch(Exception e){System.out.println("Exception in Location ----> "+e);}}
%>
<%		if(masSmq.getSmqType().equalsIgnoreCase("t")){%>
		data_arr[<%= counter%>][4] = "Temporary"
		<%}if(masSmq.getSmqType().equalsIgnoreCase("p")){%>
		data_arr[<%= counter%>][4] = "Permanent"
		<%}
%>
<%
		Iterator<MasPoolCategory> itrGridPoolCategoryList=gridPoolCategoryList.iterator();
		 while(itrGridPoolCategoryList.hasNext())
            {try{
             MasPoolCategory  poolCategoryGrid = (MasPoolCategory)itrGridPoolCategoryList.next(); 
			 if(masSmq.getPoolCategory().getId().equals(poolCategoryGrid.getId()) && poolCategoryGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][5] = "<%=poolCategoryGrid.getPoolCategoryName()%>"
			<%}else if(masSmq.getPoolCategory().getId().equals(poolCategoryGrid.getId()) && poolCategoryGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=poolCategoryGrid.getPoolCategoryName()%>";
				
			<%}
            }catch(Exception e){}}
%>

<%
		Iterator<MasPool> itrGridPoolList=gridPoolList.iterator();
		 while(itrGridPoolList.hasNext())
            {try{
             MasPool  poolGrid = (MasPool)itrGridPoolList.next(); 
			 if(masSmq.getPool().getId().equals(poolGrid.getId()) && poolGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][6] = "<%=poolGrid.getPoolName()%>"
			<%}else if(masSmq.getPool().getId().equals(poolGrid.getId()) && poolGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][6] = "<font id='error'>*</font>Parent InActivated--<%=poolGrid.getPoolName()%>";
				
			<%}
            }catch(Exception e){}}
%>
	<%		if(masSmq.getSmqStatus().equalsIgnoreCase("o")){%>
			data_arr[<%= counter%>][7] = "Occupied"
			<%}if(masSmq.getSmqStatus().equalsIgnoreCase("v")){%>
			data_arr[<%= counter%>][7] = "Vacant"
			<%}if(masSmq.getSmqStatus().equalsIgnoreCase("m")){%>
			data_arr[<%= counter%>][7] = "Maintenance"
			<%}
%>
			data_arr[<%= counter%>][8] = "<%= masSmq.getLastChgBy() %>"
			data_arr[<%= counter%>][9] = "<%= HMSUtil.convertDateToStringWithoutTime(masSmq.getLastChgDate()) %>"
			data_arr[<%= counter%>][10] = "<%= masSmq.getLastChgTime() %>"
	<% 		if(masSmq.getStatus().equals("y")){ %>
			data_arr[<%= counter%>][11] = "Active"
			<%}else{%>
			data_arr[<%= counter%>][11] = "InActive"
			<%}
%>
<%
		 counter++;
}
%>
 
formName = "poolCategory"

nonEditable = ['<%= CODE%>'] 

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);
intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
