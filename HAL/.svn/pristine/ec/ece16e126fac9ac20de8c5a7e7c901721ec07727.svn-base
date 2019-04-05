<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreVendorWiseManufacturer"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
	manufacturerList = (ArrayList)map.get("manufacturerList");
	ArrayList searchStoreVendorWiseManufacturerList = (ArrayList)map.get("searchStoreVendorWiseManufacturerList");
	ArrayList gridManufacturerList = (ArrayList)map.get("gridManufacturerList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		 String  message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%} %>
		 <div class="clear"></div>

<h2>Store Vendor Wise Manufacturer Master</h2>

<div class="clear"></div>
<!--Block One Starts-->
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Vendor Code </label> 
<input type="text" id="searchField" name="<%= CODE%>" value="" validate="Vendor Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'pharmacy?method=searchStoreVendorWiseManufacturer')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','pharmacy?method=searchStoreVendorWiseManufacturer','checkSearch')" tabindex=1 /> 
<%--- Report Button  --%> 
<input type="button"	name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> 

<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="mas_store_vendor_wise_manufacturer">
</form>
</div>		
</div>
</div>
<div class="clear"></div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
  if(searchStoreVendorWiseManufacturerList.size()>0)
   {
   String strForCode = (String)map.get("storeVendorWiseManufacturerCode");
   if(strForCode!= null && strForCode!= "")
   {
 %> <h4><a href="pharmacy?method=showStoreVendorWiseManufacturerJsp">Show All Records</a></h4> <%
   }
   }
 if(searchStoreVendorWiseManufacturerList.size()==0 && map.get("search") != null)
 {
%> <h4><a href="pharmacy?method=showStoreVendorWiseManufacturerJsp">Show All Records</a></h4> <%
 }
	%> <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= MANUFACTURER_ID %>"],[3,"<%= CHANGED_BY %>"],[4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%= STATUS %>"] ];
  statusTd = 6;
	</script>
	<div class="clear"></div>
 </div>

<form name="storeVendorWiseManufacturer" method="post" action=""><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<input type="hidden" name="<%= POJO_NAME %>"	value="MasStoreVendorWiseManufacturer"> 
<input type="hidden"	name="title" value="StoreVendorWiseManufacturer"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="storeVendorWiseManufacturer">
<input type="hidden" name="pojoPropertyCode" value="VendorCode">

<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Vendor Code </label> 
<input 	id="codeId" type="text" name="<%= CODE%>" value=""	validate="Vendor Code,string,yes" class="textbox_size20" MAXLENGTH="8"	 tabindex=1/> 
<script>
				document.storeVendorWiseManufacturer.<%=CODE%>.focus();
   </script> 
<label><span>*</span> Manufacturer Name</label> 
<select	name="<%= MANUFACTURER_ID %>" validate="Manufacturer Name,string,yes"	tabindex=1	onkeypress="return submitenter(this,event,'pharmacy?method=addStoreVendorWiseManufacturer')">
	<option value="">Select</option>
	<% 
				
				for (MasManufacturer  masManufacturer : manufacturerList){
				%>

	<option value="<%=masManufacturer.getId ()%>"><%=masManufacturer.getManufacturerName()%></option>

	<%}%>
</select>
<div class="clear"></div>
<div class="clear"></div>

</div>
<div class="division"></div>
<div class="clear"></div>

<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add"	class="button"	onClick="submitForm('storeVendorWiseManufacturer','pharmacy?method=addStoreVendorWiseManufacturer');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" style="display: none" class="button"	onClick="submitForm('storeVendorWiseManufacturer','pharmacy?method=editStoreVendorWiseManufacturer')"	accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" style="display: none" class="button"	onClick="submitForm('storeVendorWiseManufacturer','pharmacy?method=deleteStoreVendorWiseManufacturer&flag='+this.value)"	accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset"	value="Reset" class="buttonHighlight" onclick="location.reload();"	accesskey="r" /> <input type="hidden" name="<%=STATUS %>" value="" />

<input type="hidden" name="<%= COMMON_ID%>" value="" />


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom"><label>Changed By:</label> 
<label	class="value"><%=userName%></label>
<label>Changed Date:</label> 
<label	class="value"><%=date%></label>
<label>Changed Time:</label>
<label	class="value"><%=time%></label> 
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>




<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Vector Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Manufacturer Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= MANUFACTURER_ID %>";

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
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_TIME %>"

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchStoreVendorWiseManufacturerList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
             MasStoreVendorWiseManufacturer  masStoreVendorWiseManufacturer = (MasStoreVendorWiseManufacturer)itr.next();       
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masStoreVendorWiseManufacturer.getId()%>
<%if(masStoreVendorWiseManufacturer.getSupplier()!=null){%>
data_arr[<%= counter%>][1] = "<%=masStoreVendorWiseManufacturer.getSupplier().getSupplierCode()%>"
<%}else{%>
	data_arr[<%= counter%>][1] = "-";	
<%}%>
<%
		Iterator itrGridManufacturerList=gridManufacturerList.iterator();
		 while(itrGridManufacturerList.hasNext())
            {try{
             MasManufacturer  manufacturerGrid = (MasManufacturer)itrGridManufacturerList.next(); 
			 if(masStoreVendorWiseManufacturer.getManufacturer().getId().equals(manufacturerGrid.getId()) && manufacturerGrid.getStatus().equalsIgnoreCase("y")){%>
				data_arr[<%= counter%>][2] = "<%=manufacturerGrid.getManufacturerName()%>"
			<%}else if(masStoreVendorWiseManufacturer.getId().equals(manufacturerGrid.getId()) && manufacturerGrid.getStatus().equalsIgnoreCase("n")){%>
				data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=manufacturerGrid.getManufacturerName()%>";
				
			<%}
            }catch(Exception e){}}%>
            data_arr[<%= counter%>][3] = "<%= masStoreVendorWiseManufacturer.getLastChgBy()%>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.changeDateToddMMyyyy(masStoreVendorWiseManufacturer.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masStoreVendorWiseManufacturer.getLastChgTime() %>"
<% if(masStoreVendorWiseManufacturer.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "storeVendorWiseManufacturer"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>