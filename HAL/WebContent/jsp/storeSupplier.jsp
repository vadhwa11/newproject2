<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * storeSupplier.jsp  
 * Purpose of the JSP -  This is for Store Supplier.
 * @author  Vivek
 * @author  Abha
 * Create Date: 21th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.10
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplierType"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasStoreVendorWiseManufacturer"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplierGroup"%>

<script language="javascript">
function printReport()
{
if (search.group.value==0)
{
	search.jasperFileName.value="Mas_vendor_list";
	submitForm('search','hospital?method=generateReportForGeneralMasters');
}
else
	{
	search.jasperFileName.value="Mas_vendor_list_Group_Wise";
	submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');
	}
}

function disableFDR(selectedValue)
{
	if (selectedValue=="D")
	document.getElementById("fdr1").style.display='none';
	else
	document.getElementById("fdr1").style.display='inline';
}
function  checkFieldForAmpersant(){
	var vendorName = document.getElementById('vendorNameCheck').value;
	
	var nomenclatureArrayAmpersant = vendorName.split('&');
	var nomenclatureArrayQutation = vendorName.split('"');

	if(nomenclatureArrayAmpersant.length > 1 || nomenclatureArrayQutation.length > 1 ){
		alert('Special Symbols like (& and ") are not allowed in Vandor Name.');
		document.getElementById('vendorNameCheck').focus();
		return false;
	}
	
	var faxNo = document.getElementById('faxNoCheck').value;
	
	var nomenclatureArrayAmpersant = faxNo.split('&');
	var nomenclatureArrayQutation = faxNo.split('"');

	if(nomenclatureArrayAmpersant.length > 1 || nomenclatureArrayQutation.length > 1 ){
		alert('Special Symbols like (& and ") are not allowed in Fax No.');
		document.getElementById('faxNo').focus();
		return false;
	}
	
	
	return true;
}

</script>

<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
 map = (Map) request.getAttribute("map");
 
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");

List<MasStoreSupplier> masStoreSupplierList = new ArrayList<MasStoreSupplier>();
List<MasStoreSupplierType> masStoreSupplierTypeList = new ArrayList<MasStoreSupplierType>();
List<MasStoreSupplierType> gridStoreSupplierTypeList = new ArrayList<MasStoreSupplierType>();

List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
List<MasStoreGroup> gridMasStoreGroupList = new ArrayList<MasStoreGroup>();
List<MasStoreSupplierGroup> masStoreSupplierGroupList = new ArrayList<MasStoreSupplierGroup>();
List<MasStoreVendorWiseManufacturer> masStoreVendorWiseManufacturerList = new ArrayList<MasStoreVendorWiseManufacturer>();

if(map.get("masStoreSupplierList")!= null){
	masStoreSupplierList = (List)map.get("masStoreSupplierList");
}
if(map.get("masStoreSupplierTypeList")!= null){
	masStoreSupplierTypeList = (List)map.get("masStoreSupplierTypeList");
}
if(map.get("gridStoreSupplierTypeList")!= null){
	gridStoreSupplierTypeList = (List)map.get("gridStoreSupplierTypeList");
}
if(map.get("masStoreSupplierGroupList")!= null){
	masStoreSupplierGroupList = (List)map.get("masStoreSupplierGroupList");
}
if(map.get("masStoreVendorWiseManufacturerList")!= null){
	masStoreVendorWiseManufacturerList = (List)map.get("masStoreVendorWiseManufacturerList");
}

List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
if(map.get("manufacturerList")!= null){
	manufacturerList = (List)map.get("manufacturerList");
}

List<MasManufacturer> gridManufacturerList = new ArrayList<MasManufacturer>();
if(map.get("gridManufacturerList")!= null){
	gridManufacturerList = (List)map.get("gridManufacturerList");
}


List<MasDistrict> districtList = new ArrayList<MasDistrict>();
if(map.get("districtList")!= null){
	districtList = (List)map.get("districtList");
}
List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();

if(map.get("gridDistrictList")!= null){
	gridDistrictList = (List)map.get("gridDistrictList");
}

List<MasState> stateList = new ArrayList<MasState>();
if(map.get("stateList")!= null){
	stateList = (List)map.get("stateList");
}

//out.print(masStoreSupplierTypeList.size());



	List gridStateList = new ArrayList();
	if(map.get("gridStateList")!= null){
		gridStateList = (List)map.get("gridStateList");
	}
	
	List<MasDistrict> localDistrictList = new ArrayList<MasDistrict>();
	if(map.get("localDistrictList")!= null){
		localDistrictList = (List)map.get("localDistrictList");
	}
	
	List<MasDistrict> gridLocalDistrictList = new ArrayList<MasDistrict>();
	if(map.get("gridLocalDistrictList")!= null){
		gridLocalDistrictList = (List)map.get("gridLocalDistrictList");
	}
	List<MasState> localStateList = new ArrayList<MasState>();
	if(map.get("localStateList")!= null){
		localStateList = (List)map.get("localStateList");
	}
	List<MasState> gridLocalStateList = new ArrayList<MasState>();
	if(map.get("gridLocalStateList")!= null){
		gridLocalStateList = (List)map.get("gridLocalStateList");
	}
	
	
	
	
	if(map.get("masStoreGroupList") != null){
		masStoreGroupList = (List<MasStoreGroup>)map.get("masStoreGroupList") ;
	}
	if(map.get("gridMasStoreGroupList") != null){
		gridMasStoreGroupList = (List<MasStoreGroup>)map.get("gridMasStoreGroupList") ;
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	

	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
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
<script type="text/javascript">
		<%
			int counter1 = 0;
			for (MasState masState : stateList)
			{
				for (MasDistrict masDistrict : districtList) 
				{
					if(masDistrict.getState() != null){
						if(masState.getId().equals(masDistrict.getState().getId() )){
								%>
									districtArray[<%=counter1%>] = new Array();
									districtArray[<%=counter1%>][0]=<%=masState.getId()%>;
									districtArray[<%=counter1%>][1] = <%=masDistrict.getId()%>;									
									districtArray[<%=counter1%>][2] = "<%=masDistrict.getDistrictName()%>";

								<%
								counter1++;
						}
					}
				}
			}
			
		%>
		
		<%
			int counter2 = 0;
			for (MasState masStateLocal : localStateList)
			{
				for (MasDistrict masDistrictLocal : localDistrictList) 
				{
					if(masDistrictLocal.getState() != null){
						if(masStateLocal.getId().equals(masDistrictLocal.getState().getId() )){
								%>
									districtLocalArray[<%=counter2%>] = new Array();
									districtLocalArray[<%=counter2%>][0]=<%=masStateLocal.getId()%>;
									districtLocalArray[<%=counter2%>][1] = <%=masDistrictLocal.getId()%>;									
									districtLocalArray[<%=counter2%>][2] = "<%=masDistrictLocal.getDistrictName()%>";

								<%
								counter2++;
						}
					}
				}
			}
			
		%>
		</script>


<div class="titleBg">
<h2>Vendor</h2>
</div>



<form name="search" method="post" action="">
<div class="Block">

<label>Vendor Code</label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" class="radioAuto" checked="unchecked" />
 
<label>Vendor Name </label> 
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioAuto" checked="checked" /> 
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Vendor Code,alphanumeric,no" MAXLENGTH="8"	tabindex=1 /> 



<input type="hidden" name="colCode" value="supplier_code">
<input type="hidden" name="colName" value="supplier_name">



<input type="button" name="search" value="Search"	class="button"	onclick="submitForm('search','pharmacy?method=searchStoreSupplier','checkSearch')"	tabindex=1 />
<input type="button" name="Report" value="Generate Report"	class="buttonBig" onClick="printReport();" accesskey="g" tabindex=1 />


<input type="hidden" name="<%=JASPER_FILE_NAME%>"	value="Mas_vendor_list">
<input type="hidden" name="group" value="0"/>
<input type="hidden" name="vendor_code" value="<%=map.get("vendor_code")%>" />
<%-- <select name="group">
<option value="0">Select Group</option>
	<% for(MasStoreGroup masStoreGroup : masStoreGroupList) { %>
	<option value=<%=masStoreGroup.getId()%>><%=masStoreGroup.getGroupName()%></option>
	<% } %>
</select> --%>


</div>
</form>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<%
 try{
  if(masStoreSupplierList.size()>0 && masStoreSupplierTypeList.size() > 0)
   {
   String strForCode = (String)map.get("storeSupplierCode");
   String strForCodeDescription = (String)map.get("storeSupplierName");
   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %> <h4><a href="pharmacy?method=showStoreSupplierJsp">Show All Records</a></h4>
<%
   }
   }
   
 if(masStoreSupplierList.size()==0 && map.get("search") != null)
 {
%> <h4><a href="pharmacy?method=showStoreSupplierJsp">Show All Records</a></h4> <%
}
 }
 catch(Exception ex){
        System.out.println("Exception  "+ex);
       }
 %> <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= STORE_SUPPLIER_TYPE_ID %>"],[4,"<%= PIN_NUMBER %>"],[5,"<%= TIN_NUMBER %>"],[6,"<%= LICENCE_NO %>"],[7,"<%= TYPE_OF_REG %>"],[8,"<%= SALES_TAX_NO %>"],[9,"<%= ADDRESS1 %>"],[10,"<%= ADDRESS2 %>"],[11,"<%= STATE %>"],[12,"<%= DISTRICT %>"],[13,"<%= PHONE_NO %>"],[14,"<%= MOBILE_NO %>"],[15,"<%= PINCODE%>"],[16,"<%= EMAIL_ID%>"],[17,"<%= FAX_NO %>"],[18,"<%= URL %>"],[19,"<%= LOCAL_ADDRESS1 %>"],[20,"<%= LOCAL_ADDRESS2 %>"],[21,"<%= LOCAL_STATE %>"],[22,"<%= LOCAL_CITY %>"],[23,"<%= LOCAL_PINCODE %>"],[24,"<%= LOCAL_PHONE_NO %>"],[25,"<%= CF_DISTRIBUTOR_NAME%>"],[26,"<%= CF_DISTRIBUTOR_ADDRESS1%>"],[27,"<%= CF_DISTRIBUTOR_ADDRESS2%>"],[28,"<%= MANUFACTURER_ID%>"], [29,"<%=GROUP_ID%>"],[30,"<%= CHANGED_BY%>"], [31,"<%= CHANGED_DATE %>"],[32,"<%= CHANGED_TIME %>"],[33,"FDR"],[34,"<%=STATUS%>"] ];
	 statusTd = 34;
 </script>
 </div>

<form name="storeSupplier" method="post" action="">
<input	type="hidden" name="<%= POJO_NAME %>" value="MasStoreSupplier">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"	value="SupplierName"> 
<input type="hidden" name="title"	value="StoreSupplier">
<input type="hidden"	name="<%=JSP_NAME %>" value="storeSupplier">
<input	type="hidden" name="pojoPropertyCode" value="SupplierCode"> 

<div class="Block">
<label >Vendor Code <span>*</span> </label> 

<input type="text" name="<%= CODE%>" value="<%=map.get("vendor_code")%>" validate="Vendor Code,alphanumeric,yes"  MAXLENGTH="8" tabindex=1 readonly="readonly" />
<label> Vendor Name <span>*</span> </label> 
<input type="text" id="vendorNameCheck" name="<%= SEARCH_NAME %>" value="" validate="Vendor Name,validateCompany,yes"  MAXLENGTH="75" tabindex=1 /> 
<label >Vendor Type <span>*</span> </label>
<select name="<%= STORE_SUPPLIER_TYPE_ID %>" validate="Vendor Type,alphanumeric,yes" tabindex=1> <option value="">Select</option>
	<% 
    
    for (MasStoreSupplierType  masStoreSupplierType : masStoreSupplierTypeList){
    %>

	<option value="<%=masStoreSupplierType.getId ()%>"><%=masStoreSupplierType.getSupplierTypeName()%></option>

	<%}%>
</select>

<div class="clear"></div>
 <label >PIN Number </label>
 <input type="text"	name="<%= PIN_NUMBER %>" value="" validate="Pin Number,num,no"	 MAXLENGTH="30" tabindex=1 /> 
<label >TIN Number </label>
<input type="text"	name="<%= TIN_NUMBER %>" value="" validate="TIN Number,alphanumeric,no"	 MAXLENGTH="30"  tabindex=1 />
<label>Drug Licence No. </label>
<input type="text"	name="<%= LICENCE_NO %>" value="" validate="Licence No,String,no"	 MAXLENGTH="30"  tabindex=1 />
<div class="clear"></div>
<input type="hidden"	name="<%= TYPE_OF_REG %>" value="" validate="Licence No,String,no"	 MAXLENGTH="30"  tabindex=1 />
<%-- <label> Type Of Registration </label>
<select name="<%=TYPE_OF_REG%>" tabindex=1 validate="Type of Registration,string,no" onChange="disableFDR(this.value)">
	<option value="0">Select</option>
	<option value="N">New</option>
	<option value="R">Renewal</option>
	<option value="D">DGRC Holder Firm</option>
	<option value="L">For LPO</option>
</select> --%>
<%-- <label >Sales Tax No.</label>
<input type="text"	name="<%= SALES_TAX_NO %>" value=""	validate="Sales Tax No,alphanumeric,no" MAXLENGTH="30" tabindex=1 /> --%> 
<label >Address 1 </label>
<input type="text"	name="<%= ADDRESS1 %>" value="" validate="Address1 ,string,no"	 MAXLENGTH="340" tabindex=1  style="width: 480px"/>
<div class="clear"></div>
<label>Address 2 </label>
<input type="text" name="<%= ADDRESS2 %>" value=""  MAXLENGTH="200" tabindex=1> 

<label >State </label> <select name="<%=STATE%>" validate="State,alphanumeric,no"   onChange="populateDistrict(this.value,'storeSupplier','srcityId')" tabindex=1>
	<option value="0">Select</option>
	<%

				for(MasState masState : stateList){
				
						%>
	<option value="<%=masState.getId() %>"><%=masState.getStateName() %></option>
	<%			
					
				}%>
</select> 
<label >City/District </label> 
<select name="<%=DISTRICT%>"  id="srcityId" validate="District,alphanumeric,no" tabindex=1>
	<option value="0">Select</option>
	<%
				for(MasDistrict masDistrict : districtList){
				%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
	<%			
				}%>
</select> 
<div class="clear"></div>
<label > Phone Number</label> 
<input type="text" name="<%= PHONE_NO %>" validate="Phone Number,,no" value="" MAXLENGTH="10" tabindex=1 /> 

<label>Mobile No</label> 
<input type="text" name="<%= MOBILE_NO %>" validate="Mobile No ,phone,no" value="" MAXLENGTH="10" tabindex=1 /> 
<label>Pin Code No</label> <input type="text"name="<%= PINCODE %>" validate="Pin Code No ,num,no" value="" MAXLENGTH="8" tabindex=1 /> 
<div class="clear"></div>
<label> Email Id</label> <input type="text" name="<%= EMAIL_ID %>" validate="Email Id ,email,no" value="" MAXLENGTH="30"  tabindex=1> 

<label > Fax No</label> 
<input type="text" id="faxNoCheck" name="<%= FAX_NO %>" value=""  MAXLENGTH="15" tabindex=1>

<label >URL</label>
<input type="text" name="<%= URL %>" value=""  MAXLENGTH="30" tabindex=1>
<div class="clear"></div>
<label >Local Address1</label> <input type="text" name="<%= LOCAL_ADDRESS1 %>" value="" validate="Local Address1 ,string,no"  MAXLENGTH="200" tabindex=1 />
<label >Local Address2</label> <input type="text" name="<%= LOCAL_ADDRESS2 %>" value="" validate="Local Address2 ,string,no"  MAXLENGTH="200" tabindex=1 /> 
<label >Local Phone No</label> <input type="text" name="<%= LOCAL_PHONE_NO %>" validate="Local Phone No,,no" value="" MAXLENGTH="40" tabindex=1 /> <div class="clear"></div>
<label>Local State</label> 
<select name="<%=LOCAL_STATE%>" 	validate="Local State,alphanumeric,no"	onChange="populateDistrictLocal(this.value,'storeSupplier','localSrCityId')"  tabindex=1>
	<option value="0">Select</option>
	<%
				for(MasState masStateLocal : localStateList){
				
			%>
	<option value="<%=masStateLocal.getId() %>"><%=masStateLocal.getStateName() %></option>
	<%			
					
				}%>
</select> 
<label >Local City/District </label>
 <select name="<%=LOCAL_CITY%>" id="localSrCityId" validate="Local District,alphanumeric,no"	tabindex=1>
	<option value="0">Select</option>
	<%
				for(MasDistrict masDistrictlocal : localDistrictList){
				%>
	<option value="<%=masDistrictlocal.getId()%>"><%=masDistrictlocal.getDistrictName() %></option>
	<%			
				}%>
</select> 
<label >Local Pin Code No</label> <input type="text" name="<%= LOCAL_PINCODE %>" validate="Local Pin Code No ,num,no" value=""  MAXLENGTH="8" tabindex=1 /> 
<div class="clear"></div>
<label >C & F/Local Distributor Name</label> <input type="text" name="<%= CF_DISTRIBUTOR_NAME %>" value="" validate="C & F/Local Distributor Name ,string,no" MAXLENGTH="100" tabindex=1 /> 
<label>C & F/Local Distributor Address1</label> <input type="text" name="<%= CF_DISTRIBUTOR_ADDRESS1 %>" value="" validate="C & F/Local Distributor Address1 ,string,no" MAXLENGTH="200" tabindex=1 />
<label>C & F/Local Distributor Address2</label><input type="text" name="<%= CF_DISTRIBUTOR_ADDRESS2 %>" value="" validate="C & F/Local Distributor Address2 ,string,no" MAXLENGTH="200" tabindex=1 />
<div class="clear"></div>

<div id="fdr1"><label >FDR Attached</label> <select
	name="FDR">
	<option value="N">No</option>
	<option value="Y">Yes</option>
</select></div>

<label >ManuFacturer Dealing With </label> 
<select	name="<%= MANUFACTURER_ID %>" size="4" class="list" multiple	validate="ManuFacturer,alphanumeric,no" tabindex=1>
	
	<% 
    
    for (MasManufacturer  masManufacturer : manufacturerList){
    %>

	<option value="<%=masManufacturer.getId ()%>"><%=masManufacturer.getManufacturerName()%></option>

	<%}%>
</select> 
<label >Groups</label> 
<select name="<%= GROUP_ID %>"
	size="4" class="list" multiple validate="Groups,alphanumeric,no"
	onkeypress="return submitenter(this,event,'pharmacy?method=addStoreSupplier')"
	tabindex=1>
	
	<% 
    
    for (MasStoreGroup  obj : masStoreGroupList){
    %>

	<option value="<%=obj.getId ()%>"><%=obj.getGroupName()%></option>

	<%}%>
</select>
</div> 
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
 <div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('storeSupplier','pharmacy?method=addStoreSupplier','checkFieldForAmpersant');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('storeSupplier','pharmacy?method=editStoreSupplier','checkFieldForAmpersant')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('storeSupplier','pharmacy?method=deleteStoreSupplier&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" value="Reset" class="button" onclick="location.reload();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" /> 
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
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
		<input type="hidden" name="<%=HOSPITAL_ID %>"  value="<%=hospitalId%>" /> 
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
data_header[2][0] = "Vendor Type"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=STORE_SUPPLIER_TYPE_ID %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= PIN_NUMBER %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= TIN_NUMBER %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= LICENCE_NO %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%=TYPE_OF_REG%>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%= SALES_TAX_NO %>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%=ADDRESS1%>"

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%=ADDRESS2%>"

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%=STATE%>"

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "<%=DISTRICT%>"

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "<%= PHONE_NO %>"

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = 0;
data_header[13][3] = "<%= MOBILE_NO %>"

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = 0;
data_header[14][3] = "<%= PINCODE %>"

data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = 0;
data_header[15][3] = "<%=EMAIL_ID%>"

data_header[16] = new Array;
data_header[16][0] = ""
data_header[16][1] = "hide";
data_header[16][2] = 0;
data_header[16][3] = "<%=FAX_NO%>"

data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = 0;
data_header[17][3] = "<%=URL%>"


data_header[18] = new Array;
data_header[18][0] = ""
data_header[18][1] = "hide";
data_header[18][2] = 0;
data_header[18][3] = "<%=LOCAL_ADDRESS1%>"

data_header[19] = new Array;
data_header[19][0] = ""
data_header[19][1] = "hide";
data_header[19][2] = 0;
data_header[19][3] = "<%=LOCAL_ADDRESS2%>"

data_header[20] = new Array;
data_header[20][0] = ""
data_header[20][1] = "hide";
data_header[20][2] = 0;
data_header[20][3] = "<%=LOCAL_STATE%>"

data_header[21] = new Array;
data_header[21][0] = ""
data_header[21][1] = "hide";
data_header[21][2] = 0;
data_header[21][3] = "<%=LOCAL_CITY%>"

data_header[22] = new Array;
data_header[22][0] = ""
data_header[22][1] = "hide";
data_header[22][2] = 0;
data_header[22][3] = "<%=LOCAL_PINCODE%>"

data_header[23] = new Array;
data_header[23][0] = ""
data_header[23][1] = "hide";
data_header[23][2] = 0;
data_header[23][3] = "<%=LOCAL_PHONE_NO%>"

data_header[24] = new Array;
data_header[24][0] = ""
data_header[24][1] = "hide";
data_header[24][2] = 0;
data_header[24][3] = "<%=CF_DISTRIBUTOR_NAME%>"

data_header[25] = new Array;
data_header[25][0] = ""
data_header[25][1] = "hide";
data_header[25][2] = 0;
data_header[25][3] = "<%=CF_DISTRIBUTOR_ADDRESS1%>"

data_header[26] = new Array;
data_header[26][0] = ""
data_header[26][1] = "hide";
data_header[26][2] = 0;
data_header[26][3] = "<%= CF_DISTRIBUTOR_ADDRESS2%>"

data_header[27] = new Array;
data_header[27][0] = ""
data_header[27][1] = "hide";
data_header[27][2] = 0;
data_header[27][3] = "<%=MANUFACTURER_ID%>"

data_header[28] = new Array;
data_header[28][0] = ""
data_header[28][1] = "hide";
data_header[28][2] = 0;
data_header[28][3] = "<%=GROUP_ID%>"

data_header[29] = new Array;
data_header[29][0] = "Admin"
data_header[29][1] = "hide";
data_header[29][2] = 0;
data_header[29][3] = "<%=CHANGED_BY%>"

data_header[30] = new Array;
data_header[30][0] = ""
data_header[30][1] = "hide";
data_header[30][2] = 0;
data_header[30][3] = "<%= CHANGED_DATE%>"

data_header[31] = new Array;
data_header[31][0] = ""
data_header[31][1] = "hide";
data_header[31][2] = 0;
data_header[31][3] = "<%= CHANGED_TIME %>"

data_header[32] = new Array;
data_header[32][0] = "FdrReceiptAttached"
data_header[32][1] = "hide";
data_header[32][2] = "15%";
data_header[32][3] = "FDR";

data_header[33] = new Array;
data_header[33][0] = "Status"
data_header[33][1] = "data";
data_header[33][2] = "15%";
data_header[33][3] = "<%=STATUS %>";



data_arr = new Array();

<%


Iterator itr=masStoreSupplierList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasStoreSupplier  masStoreSupplier = (MasStoreSupplier)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masStoreSupplier.getId()%>
data_arr[<%= counter%>][1] = "<%=masStoreSupplier.getSupplierCode()%>"
data_arr[<%= counter%>][2] = "<%= masStoreSupplier.getSupplierName()%>"
<% if(masStoreSupplier.getSupplierType() != null){
%>
<%
  Iterator itrgridStoreSupplierTypeList=gridStoreSupplierTypeList.iterator();
   while(itrgridStoreSupplierTypeList.hasNext())
            {
             MasStoreSupplierType  masStoreSupplierTypeGrid = (MasStoreSupplierType)itrgridStoreSupplierTypeList.next(); 
    if(masStoreSupplier.getSupplierType().getId().equals(masStoreSupplierTypeGrid.getId()) && masStoreSupplierTypeGrid.getStatus().equals("y")){%>
    data_arr[<%= counter%>][3] = "<%=masStoreSupplierTypeGrid.getSupplierTypeName()%>"
   <%}else if(masStoreSupplier.getId().equals(masStoreSupplierTypeGrid.getId()) && masStoreSupplierTypeGrid.getStatus().equals("n")){%>
    data_arr[<%= counter%>][3] = "<span>*</span>Parent InActivated--<%=masStoreSupplierTypeGrid.getSupplierTypeName()%>";
    
   <%}
            }
}%>
<% if(masStoreSupplier.getPinNo() != null){
%>
data_arr[<%= counter%>][4] = "<%= masStoreSupplier.getPinNo() %>"
<%}
else
{
	%>
	data_arr[<%= counter%>][4] = "";
	<%
}
%>
<% if(masStoreSupplier.getTinNo() != null){%>
data_arr[<%= counter%>][5] = "<%= masStoreSupplier.getTinNo() %>"
<%}
else
{
	%>
	data_arr[<%= counter%>][5] = "";
	<%
}
%>
<% if(masStoreSupplier.getLicenceNo() != null){%>
data_arr[<%= counter%>][6] = "<%= masStoreSupplier.getLicenceNo() %>"
<%}

else
{
	%>
	data_arr[<%= counter%>][6] = "";
	<%
}
%>
<% if(masStoreSupplier.getTypeOfReg() != null){%>
data_arr[<%= counter%>][7] = "<%= masStoreSupplier.getTypeOfReg() %>"
<%}
else
{
	%>
	data_arr[<%= counter%>][7] = "";
	<%
}
%>
<% if(masStoreSupplier.getSalesTaxNo() != null){%>
data_arr[<%= counter%>][8] = "<%= masStoreSupplier.getSalesTaxNo() %>"
<%}
else
{
	%>
	data_arr[<%= counter%>][8] = "";
	<%
}
%>


<%

String localAddress1=masStoreSupplier.getAddress1()!=null ? masStoreSupplier.getAddress1().trim():"";

localAddress1 = localAddress1.replace("\r", "$");
localAddress1 = localAddress1.replace("\n", "^"); 
localAddress1 = localAddress1.replace('"',' '); 

%>


var str_local1 = "<% out.print(localAddress1); %>";
 str_local1 = str_local1.split('$').join("\r");
str_local1 = str_local1.split('^').join("\n");	


str_local1 = decodeURIComponent(str_local1);	
  
data_arr[<%= counter%>][9] = str_local1;


<%

String localAddress2=masStoreSupplier.getAddress2()!=null ? masStoreSupplier.getAddress2().trim():"";

localAddress2 = localAddress2.replace("\r", "$");
localAddress2 = localAddress2.replace("\n", "^"); 
localAddress2 = localAddress2.replace('"',' '); 

%>


var str_local2 = "<% out.print(localAddress2); %>";
str_local2 = str_local2.split('$').join("\r");
str_local2 = str_local2.split('^').join("\n");	

str_local2 = decodeURIComponent(str_local2);	
  
data_arr[<%= counter%>][10] = str_local2;




<% if(masStoreSupplier.getState() != null){%>
<%
		Iterator itrGridStateList=gridStateList.iterator();
		 while(itrGridStateList.hasNext())
            {try{
             MasState  stateGrid = (MasState)itrGridStateList.next(); 
          if(masStoreSupplier.getState().getId().equals(stateGrid.getId()) && stateGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][11] = "<%=stateGrid.getId()%>"
			<%}else if(masStoreSupplier.getId().equals(stateGrid.getId()) && stateGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][11] = "<span>*</span>Parent InActivated--<%=stateGrid.getStateName()%>";
				
			<%}
            }catch(Exception e){System.out.println("Exception----> "+e);}}%>
<%}%>
<% if(masStoreSupplier.getCity() != null){%>

<%
		Iterator itrGridDistrictList=gridDistrictList.iterator();
		 while(itrGridDistrictList.hasNext())
            {try{
             MasDistrict  districtGrid = (MasDistrict)itrGridDistrictList.next(); 
			 if(masStoreSupplier.getCity().getId().equals(districtGrid.getId()) && districtGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][12] = "<%=districtGrid.getId()%>"
			<%}else if(masStoreSupplier.getId().equals(districtGrid.getId()) && districtGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][12] = "<span>*<span>Parent InActivated--<%=districtGrid.getDistrictName()%>";
				
			<%}
            }catch(Exception e){System.out.println("Exception----> "+e);}}%>


<%}%>

<% if(masStoreSupplier.getPhoneNo() != null){%>
data_arr[<%= counter%>][13] = "<%= masStoreSupplier.getPhoneNo() %>"
<%}
else
{
	%>
	data_arr[<%= counter%>][13] = "";
	<%
}
%>
<% if(masStoreSupplier.getMobileNo() != null){%>
data_arr[<%= counter%>][14] = "<%= masStoreSupplier.getMobileNo() %>"
<%}
else
{
	%>
	data_arr[<%= counter%>][14] = "";
	<%
}
%>
<% if(masStoreSupplier.getPinCode() != null){%>
data_arr[<%= counter%>][15] = "<%= masStoreSupplier.getPinCode() %>"
<%}
else
{
	%>
	data_arr[<%= counter%>][15] = "";
	<%
}
%>
<% if(masStoreSupplier.getEmailId() != null){%>
data_arr[<%= counter%>][16] = "<%= masStoreSupplier.getEmailId() %>"
<%}
else
{
	%>
	data_arr[<%= counter%>][16] = "";
	<%
}
%>
<% if(masStoreSupplier.getFaxNumber() != null){%>
data_arr[<%= counter%>][17] = "<%= masStoreSupplier.getFaxNumber() %>"
<%}

else
{
	%>
	data_arr[<%= counter%>][17] = "";
	<%
}
%>
<% if(masStoreSupplier.getUrl() != null){%>
data_arr[<%= counter%>][18] = "<%= masStoreSupplier.getUrl() %>"
<%}
else
{
	%>
	data_arr[<%= counter%>][18] = "";
	<%
}
%>
<% if(masStoreSupplier.getLocalAddress1() != null){%>
data_arr[<%= counter%>][19] = "<%= masStoreSupplier.getLocalAddress1() %>"
<%}
else
{
	%>
	data_arr[<%= counter%>][19] = "";
	<%
}
%>
<% if(masStoreSupplier.getLocalAddress2() != null){%>
data_arr[<%= counter%>][20] = "<%= masStoreSupplier.getLocalAddress2() %>"
<%}
else
{
	%>
	data_arr[<%= counter%>][20] = "";
	<%
}
%>
<% if(masStoreSupplier.getLocalState() != null){%>
<%
		Iterator itrGridLocalStateList=gridLocalStateList.iterator();
		 while(itrGridLocalStateList.hasNext())
            {try{
             MasState  stateLocalGrid = (MasState)itrGridLocalStateList.next(); 
			 if(masStoreSupplier.getState().getId().equals(stateLocalGrid.getId()) && stateLocalGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][21] = "<%=stateLocalGrid.getId()%>"
			<%}else if(masStoreSupplier.getId().equals(stateLocalGrid.getId()) && stateLocalGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][21] = "<span>*<span>Parent InActivated--<%=stateLocalGrid.getStateName()%>";
				
			<%}
            }catch(Exception e){System.out.println("Exception----> "+e);}}%>



<%}%>
<% if(masStoreSupplier.getLocalCity() != null){%>

<%
		Iterator itrGridLocalDistrictList=gridLocalDistrictList.iterator();
		 while(itrGridLocalDistrictList.hasNext())
            {try{
             MasDistrict  districLocaltGrid = (MasDistrict)itrGridLocalDistrictList.next(); 
			 if(masStoreSupplier.getLocalCity().getId().equals(districLocaltGrid.getId()) && districLocaltGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][22] = "<%=districLocaltGrid.getId()%>"
			<%}else if(masStoreSupplier.getId().equals(districLocaltGrid.getId()) && districLocaltGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][22] = "<span>*<span>Parent InActivated--<%=districLocaltGrid.getDistrictName()%>";
				
			<%}
            }catch(Exception e){System.out.println("Exception----> "+e);}}%>



<%}%>
<% if(masStoreSupplier.getLocalPinCode() != null){%>
data_arr[<%= counter%>][23] = "<%= masStoreSupplier.getLocalPinCode() %>"
<%}

else
{
	%>
	data_arr[<%= counter%>][23] = "";
	<%
}
%>
<% if(masStoreSupplier.getLocalPhoneNo() != null){%>
data_arr[<%= counter%>][24] = "<%= masStoreSupplier.getLocalPhoneNo() %>"
<%}
else
{
	%>
	data_arr[<%= counter%>][24] = "";
	<%
}
%>
<% if(masStoreSupplier.getCfLocalDistributorName() != null){%>
data_arr[<%= counter%>][25] = "<%= masStoreSupplier.getCfLocalDistributorName() %>"
<%}
else
{
	%>
	data_arr[<%= counter%>][25] = "";
	<%
}
%>
<% if(masStoreSupplier.getCfLocalDistributorAddress1() != null){%>
data_arr[<%= counter%>][26] = "<%= masStoreSupplier.getCfLocalDistributorAddress1() %>"
<%}
else
{
	%>
	data_arr[<%= counter%>][26] = "";
	<%
}
%>
<% if(masStoreSupplier.getCfLocalDistributorAddress2() != null){%>
data_arr[<%= counter%>][27] = "<%= masStoreSupplier.getCfLocalDistributorAddress2() %>"
<%}%>

<%
 		  StringBuffer manuf_ids = new StringBuffer();
 
    	  for (Iterator iterator = masStoreVendorWiseManufacturerList.iterator(); iterator.hasNext();)
    	  {
    		  MasStoreVendorWiseManufacturer masStoreVendorWiseManufacturer = (MasStoreVendorWiseManufacturer)iterator.next();
    		  if(masStoreVendorWiseManufacturer.getSupplier() != null){
    		  if (masStoreSupplier.getId() == masStoreVendorWiseManufacturer.getSupplier().getId()) 
        	  {
        		  if (manuf_ids.toString().length() > 0)
        		  {
        			  manuf_ids.append(",");
        			  manuf_ids.append(masStoreVendorWiseManufacturer.getManufacturer().getId());
        		  }
        		  else
        		  {
        			  manuf_ids.append(masStoreVendorWiseManufacturer.getManufacturer().getId());
        		  }
        	  }
    	  }
	      }

    %>
      data_arr[<%= counter%>][28] = "<%=manuf_ids.toString()%>"


 <%
 		  StringBuffer group_ids = new StringBuffer();
 
    	  for (Iterator iterator = masStoreSupplierGroupList.iterator(); iterator.hasNext();)
    	  {
    		  MasStoreSupplierGroup masStoreSupplierGroup = (MasStoreSupplierGroup)iterator.next();
    		  if (masStoreSupplier.getId() == masStoreSupplierGroup.getSupplier().getId())
        	  {
        		  if (group_ids.toString().length() > 0)
        		  {
        			  group_ids.append(",");
        			  group_ids.append(masStoreSupplierGroup.getGroup().getId());
        		  }
        		  else
        		  {
        			  group_ids.append(masStoreSupplierGroup.getGroup().getId());
        		  }
        	  }
	      }

    %>
      data_arr[<%= counter%>][29] = "<%=group_ids.toString()%>"


data_arr[<%= counter%>][30] = "<%= masStoreSupplier.getLastChgBy() %>"
data_arr[<%= counter%>][31] = "<%= HMSUtil.convertDateToStringWithoutTime(masStoreSupplier.getLastChgDate()) %>"
data_arr[<%= counter%>][32] = "<%= masStoreSupplier.getLastChgTime() %>"
data_arr[<%=counter%>][33] = "<%=masStoreSupplier.getFdrReceiptAttached()%>";
<% if(masStoreSupplier.getStatus().equals("y")){ %>
data_arr[<%= counter%>][34] = "Active"
<%}else{%>
data_arr[<%= counter%>][34] = "InActive"
<%}%>
<%
		counter++;
}
%>
 
formName = "storeSupplier"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>