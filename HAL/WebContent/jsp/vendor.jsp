<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasVendor"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<script>
function checkSpecialChar(){
var code;
 code = document.getElementById('codeId').value;
 
 var name ;
 name= document.getElementById('search_name').value;
 
 var address;
 address= document.getElementById('address').value;
 
 var address1;
 address1= document.getElementById('address1').value;
 
 var address2;
 address2= document.getElementById('address2').value;
 
 if(code.match("\"") || name.match("\"") || address.match("\"") || address1.match("\"") || address2.match("\"")){
 alert('Please Do not enter " as Entry field')
 return false;
 }else if(code.match("\<") || name.match("\<") || address.match("\<") || address1.match("\<") || address2.match("\<")){
 alert('Please Do not enter < as Entry field')
 return false;
 }
 else{
 return true;
 }
}
</script>

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
	ArrayList<MasVendor> searchVendorList = (ArrayList<MasVendor>)map.get("searchVendorList");
	ArrayList<MasDistrict> districtList = (ArrayList<MasDistrict>)map.get("districtList");
	ArrayList<MasDistrict> gridDistrictList = (ArrayList<MasDistrict>)map.get("gridDistrictList");
	ArrayList<MasState> stateList = (ArrayList<MasState>)map.get("stateList");
	ArrayList<MasState> gridStateList = (ArrayList<MasState>)map.get("gridStateList");

	String userName = "";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}
	String message="";
	if(map.get("message") != null){
	 	message = (String)map.get("message");
%>

<h2><%=message %></h2>

<%} %>

<div id="contentHolder">
<div class="Clear"></div>
<h6>Vendor Master</h6>
<div class="Clear"></div>
<div class="header">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>VendorCode</label> <input type="radio" name="<%=SELECTED_RADIO  %>" class="radio"	value="1" checked="checked" /> 
<label>Vendor Name</label> <input	type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radio" /> 
<input	type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""	validate="Class Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'lib?method=searchVendor')" />
<input type="button" name="search" value="Search" class="cmnButton"	onclick="submitForm('search','lib?method=searchVendor','checkSearch')"	tabindex=1 />

</form>
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
		if(searchVendorList.size()>0)
		 {
			String strForCode = (String)map.get("vendorCode");
			String strForCodeDescription = (String)map.get("vendorName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%>
<div class="Clear"></div>
<h5><a href="lib?method=showVendorMaster">Show All Records</a></h5>
<div class="Clear"></div>
<%
			}
		 }
	 if(searchVendorList.size()==0 && map.get("search") != null)
	  {
	 %>
<div class="Clear"></div>
<h5><a href="lib?method=showVendorMaster">Show All Records</a></h5>
<div class="Clear"></div>
<%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"],[1,"<%= CODE%>"],[2,"<%= SEARCH_NAME %>"],[3,"<%= DISTRICT_ID %>"],[4,"<%= STATE_ID %>"],[5,"<%= PINCODE %>"],[6,"<%= ADDRESS %>"],[7,"<%= ADDRESS1 %>"],[8,"<%= ADDRESS2 %>"],[9,"<%= CHANGED_BY%>"], [10,"<%= CHANGED_DATE %>"],[11,"<%= CHANGED_TIME %>"],[12,"<%=STATUS%>"] ];
	 statusTd =12;
	</script></div>
<div class="Clear"></div>
<form name="bookClass" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasVendor"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="VendorName">
<input type="hidden" name="title" value="Vendor"> <input
	type="hidden" name="<%=JSP_NAME %>" value="vendor"> <input
	type="hidden" name="pojoPropertyCode" value="VendorCode">

<div class="division"></div>
<label class="common"><span>*</span> Vendor Code</label> <input
	id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Vendor Code,string,yes" maxlength="10" tabindex=1 /> <label
	class="common"><span>*</span> Vendor Name</label> <input type="text"
	name="<%= SEARCH_NAME %>" id="<%=SEARCH_NAME %>" value=""
	validate="Vendor Name,string,yes" maxlength="30" tabindex=1 /> <script>
				document.bookClass.<%=CODE%>.focus();
			</script>
<div class="Clear"></div>
<label class="common"><span>*</span> Address(Line1)</label> <input
	type="text" name="<%= ADDRESS %>" id="<%= ADDRESS %>" value=""
	validate="Address(Line1),string,yes" maxlength="30" tabindex=1 /> <label
	class="common">Address(Line2)</label> <input type="text"
	name="<%= ADDRESS1 %>" id="<%= ADDRESS1 %>" value=""
	validate="Address2,string,no" maxlength="30" tabindex=1 /> <label
	class="common">Address(Line3)</label> <input type="text"
	name="<%= ADDRESS2 %>" id="<%= ADDRESS2 %>" value=""
	validate="Address3,string,no" maxlength="30" tabindex=1 />

<div class="Clear"></div>
<label class="common">City</label> <select name="<%= DISTRICT_ID %>"
	tabindex=1 validate="City,string,no"
	onChange="populateState(this.value,'bookClass')" />
	<option value="0">Select</option>
	<% 
    			for (MasDistrict  masDistrict : districtList){
    		%>
	<option value="<%=masDistrict.getId ()%>"><%=masDistrict.getDistrictName()%></option>

	<%}%>
</select> <script type="text/javascript">
		<%
			int counter1 = 0;
			for (MasDistrict masDistrict : districtList)
			{
				for (MasState masState : stateList) 
				{
					if(masDistrict.getState() != null){
						if(masState.getId().equals(masDistrict.getState().getId() )){
								%>
									districtArray[<%=counter1%>] = new Array();
									districtArray[<%=counter1%>][0]=<%=masDistrict.getId()%>;
									districtArray[<%=counter1%>][1] = <%=masDistrict.getState().getId()%>;									
									districtArray[<%=counter1%>][2] = "<%=masDistrict.getState().getStateName()%>";

								<%
								counter1++;
						}
					}
				}
			}
			
		%>
		</script> <label class="common">State</label> <select name="<%= STATE_ID %>"
	tabindex=1 validate="State,string,no" />
	<option value="0">Select</option>
	<% 
    			for (MasState  masState : stateList){
    		%>
	<option value="<%=masState.getId ()%>"><%=masState.getStateName()%></option>

	<%}%>
</select> <label class="common">Pin</label> <input type="text"
	name="<%= PINCODE %>" id="<%= PINCODE %>" value=""
	validate="Pin,numWithoutSpaces,no" maxlength="6" tabindex=1 />
<div class="Clear"></div>
<div class="division"></div>

<div class="bottom"><input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="if(checkSpecialChar()){submitForm('bookClass','lib?method=addVendor');}"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="if(checkSpecialChar()){submitForm('bookClass','lib?method=editVendor');}"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('bookClass','lib?method=deleteVendor&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r"
	tabindex="1" /> <input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" />

<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="Clear"></div>

<div id="edited"></div>



<div class="Clear"></div>
</form>

</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Vendor Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Vendor Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "District Name"
data_header[2][1] = "hide";
data_header[2][2] = "40%";
data_header[2][3] = "<%=DISTRICT_ID %>";

data_header[3] = new Array;
data_header[3][0] = "State Name"
data_header[3][1] = "hide";
data_header[3][2] = "40%";
data_header[3][3] = "<%=STATE_ID %>";

data_header[4] = new Array;
data_header[4][0] = "Pincode"
data_header[4][1] = "hide";
data_header[4][2] = "40%";
data_header[4][3] = "<%=PINCODE %>";

data_header[5] = new Array;
data_header[5][0] = "Address"
data_header[5][1] = "hide";
data_header[5][2] = "40%";
data_header[5][3] = "<%=ADDRESS %>";

data_header[6] = new Array;
data_header[6][0] = "Address1"
data_header[6][1] = "hide";
data_header[6][2] = "40%";
data_header[6][3] = "<%=ADDRESS1 %>";

data_header[7] = new Array;
data_header[7][0] = "Address2"
data_header[7][1] = "hide";
data_header[7][2] = "40%";
data_header[7][3] = "<%=ADDRESS2 %>";

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%= CHANGED_BY %>"

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%= CHANGED_DATE %>"

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "<%= CHANGED_TIME %>";

data_header[11] = new Array;
data_header[11][0] = "Status"
data_header[11][1] = "data";
data_header[11][2] = "15%";
data_header[11][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator<MasVendor> itr=searchVendorList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            MasVendor  vendor = (MasVendor)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= vendor.getId()%>"
data_arr[<%= counter%>][1] = "<%=vendor.getVendorCode()%>"
data_arr[<%= counter%>][2] = "<%= vendor.getVendorName()%>"


<%
		Iterator<MasDistrict> itrGridDistrictList=gridDistrictList.iterator();
		 while(itrGridDistrictList.hasNext())
            {try{
             MasDistrict  districtGrid = (MasDistrict)itrGridDistrictList.next(); 
			 if(vendor.getDistrict().getId().equals(districtGrid.getId()) && districtGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=districtGrid.getDistrictName()%>"
			<%}else if(vendor.getDistrict().getId().equals(districtGrid.getId()) && districtGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=districtGrid.getDistrictName()%>";
				
			<%}
            }catch(Exception e){System.out.println("Exception in poolCategory ----> "+e);}}
%>

<%
		Iterator<MasState> itrGridStateList=gridStateList.iterator();
		 while(itrGridStateList.hasNext())
            {try{
             MasState  stateGrid = (MasState)itrGridStateList.next(); 
			 if(vendor.getState().getId().equals(stateGrid.getId()) && stateGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][4] = "<%=stateGrid.getStateName()%>"
			<%}else if(vendor.getState().getId().equals(stateGrid.getId()) && stateGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=stateGrid.getStateName()%>";
				
			<%}
            }catch(Exception e){System.out.println("Exception in poolCategory ----> "+e);}}
%>
<%if(vendor.getPincode()!= null){%>
data_arr[<%= counter%>][5] = "<%= vendor.getPincode() %>"
<%}%>
<%if(vendor.getAddress1()!= null){%>
data_arr[<%= counter%>][6] = "<%= vendor.getAddress1() %>"
<%}%>
<%if(vendor.getAddress2()!= null){%>
data_arr[<%= counter%>][7] = "<%= vendor.getAddress2() %>"
<%}%>
<%if(vendor.getAddress3()!= null){%>
data_arr[<%= counter%>][8] = "<%= vendor.getAddress3() %>"
<%}%>

data_arr[<%= counter%>][9] = "<%= vendor.getLastChgBy() %>"
data_arr[<%= counter%>][10] = "<%= HMSUtil.convertDateToStringWithoutTime(vendor.getLastChgDate()) %>"
data_arr[<%= counter%>][11] = "<%= vendor.getLastChgTime() %>"
<% if(vendor.getStatus().equals("y")){ %>
data_arr[<%= counter%>][12] = "Active"
<%}else{%>
data_arr[<%= counter%>][12] = "InActive"
<%}%>
<%
		     counter++;
}
          
%>
 
formName = "bookClass"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
