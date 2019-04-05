<%@page import="jkt.hms.masters.business.MasItemClass"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil"%>	
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasStoreItemGeneric"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>	
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItemConversion"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasCompany"%>
<%@page import="jkt.hms.masters.business.MasUnitOfMeasurement"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>

<%@page import="jkt.hms.masters.business.MasStoreUnit"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script language="javascript">
function openPopupWindow(id)
{
  if(id == "")
  {
    alert("Please first select the one Mat. Code!!! ");
     }else{
    	 var pvms = document.getElementById('pvmsNo').value;
         var itemNAme = id+"["+pvms+"]";
    var url="/hms/hms/personnel?method=showBrandJspPopup&itemName="+itemNAme;
    newwindow=window.open(url,'','top=50, left=0, height=600,width=1000');  
   
  }  
}

function jsSetBrandData(brandCode, brandName)
{
var len = document.getElementById("item_master_brand").options.length;
document.getElementById("item_master_brand").options.length++;
document.getElementById("item_master_brand").options[len].text=brandName;
//document.getElementById("item_master_brand").options[len].value=brandCode;

}

function checkCriteria(){
if(document.getElementById('radio3').checked){
if(document.getElementById('radio3').value == "3"){
  document.getElementById('sel').style.display = 'inline';
  document.getElementById('txt').style.display = 'none';
}
}
else{
  document.getElementById('sel').style.display = 'none';
  document.getElementById('txt').style.display = 'inline';
}
}
function ValidationForCriteria(){
 if(document.getElementById('radio3').checked){
	
   if(document.getElementById('sectionCode').value == "0"){
    alert("please select Section Code.");
    return false; 
 }}else{
    if(document.getElementById('searchField').value == ""){
     alert("Please enter value in textfield");
     return false;
 }
}
return true;
}
</script>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
		map = (Map<String,Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasStoreItem> searchItemList = new ArrayList<MasStoreItem>();
	List<MasStoreItemGeneric> itemGenericList = new ArrayList<MasStoreItemGeneric>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasStoreSection> storeSectionList = new ArrayList<MasStoreSection>();
	List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
	List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
	List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
	List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
	List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
	List<MasItemClass> gridItemClassList = new ArrayList<MasItemClass>();
	List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
	List<MasCompany> companyList = new ArrayList<MasCompany>();
	List<MasStoreUnit> uomList=new ArrayList<MasStoreUnit>();
	
	searchItemList = (List<MasStoreItem>)map.get("searchItemList");
	itemGenericList = (List<MasStoreItemGeneric>)map.get("itemGenericList");
	departmentList = (List<MasDepartment>)map.get("departmentList");
	storeSectionList = (List<MasStoreSection>)map.get("storeSectionList");
	itemTypeList = (List<MasItemType>)map.get("itemTypeList");
	itemCategoryList = (List<MasItemCategory>)map.get("itemCategoryList");
	itemConversionList = (List<MasStoreItemConversion>)map.get("itemConversionList");
	companyList = (List<MasCompany>)map.get("companyList");
	masItemClassList = (List<MasItemClass>)map.get("masItemClassList");
	gridItemClassList = (List<MasItemClass>)map.get("gridItemClassList");
	uomList= (List<MasStoreUnit>)map.get("uomList");
	if(map.get("storeSectionList") != null){
	sectionList = (List<MasStoreSection>)map.get("storeSectionList");
	}
	if(map.get("groupList") != null){
		groupList = (List<MasStoreGroup>)map.get("groupList") ;
	}
		
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
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
<div class="titleBg"><h2>Drug Master</h2></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">

<label>Mat. Code</label>
 <input type="radio" class="radioAuto" name="<%=SELECTED_RADIO  %>"   value="1" checked="unchecked" onclick="checkCriteria();"/>
			   
			    <label>Nomenclature</label>
					<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value="2"  checked="checked" onclick="checkCriteria();"/>
				  
		            <div id="txt">
					 <input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Code,string,no"   MAXLENGTH="15" tabindex=1 onkeypress="return submitenter(this,event,'pharmacy?method=searchItem')" />
					 </div>
					 
					 <input	type="hidden" name="colCode" value="pvms_no"/>
<input	type="hidden" name="colName" value="nomenclature"/>
                    <input type="button" name="search" value="Search" class="button"   onclick="submitForm('search','pharmacy?method=searchItem','checkSearch')" tabindex=1  />
                    <div class="clear"></div>
                    <label>Prescribed From</label> 
<select name="prescribedFromR" validate="Prescribed From,string,no"	id="prescribedFromR" tabindex=1 >
	<option value="">Select</option>
	<option value="o">OPD</option>	
	<option value="H">Ward/OT ETC</option>	
</select>
                    <input type="reset" name ="add" id="reset" value ="Generate Report" class="button" onclick="submitForm('search','hospital?method=generateReportForGeneralMastersItem');" accesskey="r"  tabindex=1 />
                    <input type="hidden" name="add" onclick="submitForm('search','pharmacy?method=generatePVMSExcel');" accesskey="r"  tabindex=1  value="Export To Excel" class="buttonBig">
 		             </div>
 		            <%--- Report Button   --%>  
 		            <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_item_list"> 
 		            <input type="hidden" name="itemType" value="1"/>
           </form>
</div>
</div>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults">
<div id="searchtable"></div>

<%
if(searchItemList.size()>0)
{
String strForCode = (String)map.get("pvmsNo");
String strForCodeDescription = (String)map.get("nomenclature");
if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
{
%> <h4><a href="pharmacy?method=showItemJsp">Show All Records</a></h4> <%
 	}
 	}

 	if (searchItemList.size() == 0 && map.get("search") != null) {
 %><h4> <a href="pharmacy?method=showItemJsp">Show All Records</a></h4> <%
 	}
 %>

	
		 <script type="text/javascript">

formFields = [
[0, "<%= COMMON_ID%>", "id"],
[1,"<%= GROUP_ID %>"],
[2,"<%= ITEM_TYPE_ID %>"],
[3,"<%= SECTION_ID %>"],
[4,"<%= CODE%>"],
[5,"<%= SEARCH_NAME %>"],
[6,"commonName"],
[7,"<%= STORE_ITEM_CONVERSION_ID %>"],
[8,"<%= ITEM_CLASS_ID %>"],
[9,"<%= ITEM_CATEGORY_ID %>"],
[10,"<%= BRAND_GENERIC %>"],
[11,"<%= HIGH_VALUE_DRUG %>"],
[12,"<%= EXPIRY %>"],
[13,"<%= TEMPERATURE %>"],
[14,"minTemperature"],
[15,"maxTemperature"],
[16,"uomQty"],
[17,"dispensingUnit"],

[18,"<%= CHANGED_BY %>"],
[19,"<%= CHANGED_DATE %>"],
[20,"<%= CHANGED_TIME %>"],
[21,"<%= STATUS %>"],
[22,"insulin"],
[23,"IssueFrom"],
[24,"prescribedFrom"]]
statusTd = 21;
</script></div>
	  <form name="item" method="post" action="">
	   <input type="hidden" name="<%= HOSPITAL_ID %>" value = "0">
	  <input type="hidden" name="<%= POJO_NAME %>" value = "MasStoreItem">
	  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value = "Nomenclature">
	  <input type="hidden" name="<%=POJO_PROPERTY_CODE%>" value = "PvmsNo">
	  <input type="hidden" name="title" value = "Item">
	  <input type="hidden" name="<%=JSP_NAME %>" value = "item">
		<div class="Clear"></div>	
  
  <div class="paddingTop5"></div>
  <div class="Block">
<label><span>*</span> Group</label> 
<select id="<%= GROUP_ID %>"	name="<%= GROUP_ID %>" validate="Group,string,yes" tabindex=1 onblur="submitProtoAjaxWithDivName('item','pharmacy?method=getItemTypeGLList&group='+this.value,'nameDiv');" >
	<option value="0">Select</option>
	<%
		for (MasStoreGroup masStoreGroup : groupList) {
	%>
	<option value="<%=masStoreGroup.getId ()%>"><%=masStoreGroup.getGroupName()%></option>
	<%
		}
	%>

	
</select>

<div id="nameDiv">
<label><span>*</span> Item Type</label> 
<select id="<%= ITEM_TYPE_ID %>"	name="<%=ITEM_TYPE_ID %>" validate="Item Type,string,yes" tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasItemType masItemType : itemTypeList) {
	%>
	<option value="<%=masItemType.getId ()%>"><%=masItemType.getItemTypeName()%></option>
	<%
		}
	%>

	
</select>


<label><span>*</span> Section</label> 
<select id="sectionId"	name="<%= SECTION_ID %>" validate="Section,string,yes" 	tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasStoreSection masStoreSection : storeSectionList) {
	%>
	<option value="<%=masStoreSection.getId ()%>"><%=masStoreSection.getSectionName()%></option>
	<%
		}
	%>

	
</select>
<label><span>*</span>Class</label> 
<select	name="<%= ITEM_CLASS_ID %>" id="<%=ITEM_CLASS_ID %>" validate="Class Name,string,yes"	tabindex="1">
	<option value="0">Select</option>
	<%
			for (MasItemClass masItemClass : masItemClassList) {
		%>
	<option value="<%=masItemClass.getId ()%>"><%=masItemClass.getItemClassName()%></option>
	<%
			}
		%>
</select>
<label>Category</label> 
<select	name="<%= ITEM_CATEGORY_ID %>" id="<%=ITEM_CATEGORY_ID %>" validate="Category,string,no"	tabindex=1>
	<option value="0">Select</option>
	<%
			for (MasItemCategory masItemCategory : itemCategoryList) {
		%>
	<option value="<%=masItemCategory.getId ()%>"><%=masItemCategory.getItemCategoryName()%></option>
	<%
			}
		%>
</select>

</div>
	
		 	<div class="Clear"></div> 	
<label><span>*</span> Mat. Code</label>
<input type="text" id="pvmsNo" name="<%= CODE%>" value=""   validate="Mat. Code,string,yes"  onblur="checkPvmsForAlreadyExist();"  MAXLENGTH="20" tabindex=1 />
			
					<script>
				document.item.<%=CODE%>.focus();
			</script>
<label><span>*</span> Nomenclature</label>
<input type="text" id="nomenclatureToCheck" name="<%= SEARCH_NAME%>" value="" validate="Nomenclature,string,yes"  MAXLENGTH="250" class="large2" tabindex=1 style="width: 478px" />
			
<%-- <label class="bodytextB">Common Name</label>
<input type="text" id="commonName" name="<%=COMMON_NAME%>" value="" class="large2" MAXLENGTH="250" tabindex=1 /> --%>
				<div class="Clear"></div>
			
<label>Branded/Generic</label>
<select name="<%=BRAND_GENERIC%>"  tabindex=1>
<option value="0">Select</option>
<option value="B">Branded</option>
<option value="G">Generic</option>
</select> 
	
			
<label><span>*</span> A/U</label> 
<select	name="<%= STORE_ITEM_CONVERSION_ID %>" validate="A/U,string,yes"	tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasStoreItemConversion masStoreItemConversion : itemConversionList) {
	%>
	<option value="<%=masStoreItemConversion.getId ()%>"><%=masStoreItemConversion.getItemUnitName()%></option>
	<%
		}
	%>
</select>
				
	
<label><span>*</span>Dispensing Unit</label> 
<select	name="dispensingUnit" id="dispensingUnit" validate="Dispensing unit,string,yes"	tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasStoreItemConversion masStoreItemConversion : itemConversionList) {
	%>
	<option value="<%=masStoreItemConversion.getItemUnitName()%>"><%=masStoreItemConversion.getItemUnitName()%></option>
	<%
		}
	%>
</select>

	<div class="Clear"></div>
<label>UOM Qty</label> 
<input type="text"	name="uomQty"  	id="uomQty" value="" validate="UOM Qty,float,no"	MAXLENGTH="15" tabindex=1 />

	
	
<label>Expiry</label>
<select name="<%=EXPIRY%>"	>
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>

	

<label>High Value Drug</label>
<input	type="checkbox" name="<%=HIGH_VALUE_DRUG %>" value="y"	class="radioCheck" />
			
<div class="clear"></div>


<div class="clear"></div>
<label>Temperature</label> 
<select name="<%=TEMPERATURE %>"	id="<%=TEMPERATURE %>" tabindex=1 onchange="chaneTempField(this.value)">
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>


<label>Min Temperature</label> 
<input type="text" name="minTemperature" id="minTemperatureId"	value="" validate="Min Temperature,float,no" tabindex=1 />


<label>Max Temperature</label> 
<input	type="text" name="maxTemperature" id="maxTemperatureId" value=""	validate="Max Temperature,float,no" tabindex=1 />
<div class="Clear"></div>
		
		<label>Insulin</label> 
<select name="insulin"	id="insulin " tabindex=1 >
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>

		<label>Injection From<span>*</span></label> 
<select name="IssueFrom" validate="Injection From,string,yes"	id="IssueFrom " tabindex=1 >
	<option value="">Select</option>
	<option value="d">CD Pharmacy</option>
	<option value="i">Injection Room</option>
</select>

<label>Prescribed From<span>*</span></label> 
<select name="prescribedFrom" validate="Prescribed From,string,yes"	id="prescribedFrom " tabindex=1 >
	<option value="">Select</option>
	<option value="o">OPD</option>	
	<option value="H">Ward/OT ETC</option>	
</select>
			
			
			
			 
</div>
<div class="Clear"></div>
<div id="edited"></div>
<div class="division"></div>
			 

	<input type="button" name="add" id="addbutton" value="Add"	class="button" onclick="submitForm('item','pharmacy?method=addItem','ValidateTemp')" accesskey="a" tabindex=1 style="display: inline" />
<input	type="button" name="edit" id="editbutton" value="Update"	style="display: none" class="button" onclick="submitForm('item','pharmacy?method=editItem&flag='+this.value,'ValidateTemp')"	accesskey="u" tabindex=1 />
	
	<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('item','pharmacy?method=deleteItem&flag='+this.value)" accesskey="d" tabindex=1/>		
		<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="submitFormForButton('item','pharmacy?method=showItemJsp)" accesskey="d"	tabindex=1 accesskey="r" />
	<input type="hidden" name="<%=STATUS %>" value="" />
	<input type="hidden" id="itemId" name="<%= COMMON_ID%>" value="" />
<div class="Clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label>   
			<label class="value"><%=userName%></label>
			<label>Changed Date</label>   
			<label class="value"><%=date%></label>
			<label>Changed Time</label>   
			<label class="value"><%=time%></label>
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />

		</div>	
			

</form>			
<script>

function ValidateTemp(){
	var min ="";
	var max = "";
	  min = document.getElementById('minTemperatureId').value;
	  max = document.getElementById('maxTemperatureId').value;

	 if(min != "" && max != ""){
		 if( parseFloat(min)>parseFloat(max) )
		  {
			  alert("Max. Temperature should be greater than Min Temperature")
		  document.getElementById('minTemperatureId').value ="";
			 document.getElementById('maxTemperatureId').value ="";
			  return false;
		  }
	  	}
	 
	 
	  return true;

	}
function populatePvmsNo(val){
	if(val != 0 && val < 10){
		document.getElementById('pvmsNo').value = 0+val;
	}else if(val >= 10){
		document.getElementById('pvmsNo').value = val;
	}else{
		document.getElementById('pvmsNo').value = "";
	}
}

function checkPvmsNo(){
	var sectionId = document.getElementById('sectionId').value
	var pvmsNo = document.getElementById('pvmsNo').value
	var pvmsNo1 = pvmsNo.substring(2,3);
	if(sectionId < 10){
		sectionId = 0+sectionId;
	}
	pvmsNo = pvmsNo.substring(0,2)
	
	if(sectionId == pvmsNo && pvmsNo1 != "" || pvmsNo == "NI"){
		return true
	}else{
		alert("Please Enter valid Mat. Code starting with Section Code")
	}
}

function  checkFieldForAmpersant(){
	var nomenclature = document.getElementById('nomenclatureToCheck').value;
	
	var nomenclatureArrayAmpersant = nomenclature.split('&');
	var nomenclatureArrayQutation = nomenclature.split('"');

	if(nomenclatureArrayAmpersant.length > 1 || nomenclatureArrayQutation.length > 1 ){
		alert('Special Symbols like (& and ") are not allowed.');
		document.getElementById('nomenclatureToCheck').focus();
		return false;
	}
	return true;
}

function checkForNivItem(val){
	var editstyle = document.getElementById('editbutton').style.display;
	var sectionId = document.getElementById('sectionId').value;
	if(sectionId < 10){
		sectionId = 0+sectionId;
	}
	if(val == 1 && editstyle=="inline")
	{
		document.getElementById('oldNiv').value = document.getElementById('pvmsNo').value 
		document.getElementById('pvmsNo').disabled = false;
		document.getElementById('pvmsNo').readOnly = true;
		document.getElementById('pvmsNo').value = "";
		document.getElementById('oldNiv').disabled = true;
	}
	if(val == 2){
		document.getElementById('pvmsNo').value = "NIV/";
	}else if(val == 1){
		document.getElementById('pvmsNo').value = sectionId;
	}

}

</script>

<script type="text/javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Item Group"
data_header[0][1] = "data";
data_header[0][2] = 0;
data_header[0][3] = "<%= GROUP_ID %>";

data_header[1] = new Array;
data_header[1][0] = "Item Type"
data_header[1][1] = "data";
data_header[1][2] = 0;
data_header[1][3] = "<%= ITEM_TYPE_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Section"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%= SECTION_ID %>";

data_header[3] = new Array;
data_header[3][0] = "Mat. Code"
data_header[3][1] = "data";
data_header[3][2] = "14%";
data_header[3][3] = "<%= CODE%>"

data_header[4] = new Array;
data_header[4][0] = "Nomenclature"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= SEARCH_NAME %>";


data_header[5] = new Array;
data_header[5][0] = "Common Name"
data_header[5][1] = "hide";
data_header[5][2] = "14%";
data_header[5][3] = "commonName";



data_header[6] = new Array;
data_header[6][0] = "Unit"
data_header[6][1] = "data";
data_header[6][2] = 0;
data_header[6][3] = "<%=STORE_ITEM_CONVERSION_ID %>"


data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%=ITEM_CLASS_ID %>"


data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%=ITEM_CATEGORY_ID %>"


data_header[9] = new Array;
data_header[9][0] = "Brand/Generic"
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%=BRAND_GENERIC %>"

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%=HIGH_VALUE_DRUG %>"


data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "<%=EXPIRY %>";




data_header[12] = new Array;
data_header[12][0] = "TEMPERATURE"
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "<%=TEMPERATURE %>";

data_header[13] = new Array;
data_header[13][0] = "Min TEMPERATURE"
data_header[13][1] = "hide";
data_header[13][2] = 0;
data_header[13][3] = "minTemperature";


data_header[14] = new Array;
data_header[14][0] = "Max TEMPERATURE"
data_header[14][1] = "hide";
data_header[14][2] = 0;
data_header[14][3] = "maxTemperature";

data_header[15] = new Array;
data_header[15][0] = "uomQty"
data_header[15][1] = "hide";
data_header[15][2] = 0;
data_header[15][3] = "uomQty";

data_header[16] = new Array;
data_header[16][0] = "dispensingUnit"
data_header[16][1] = "hide";
data_header[16][2] = 0;
data_header[16][3] = "dispensingUnit";


data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = 0;
data_header[17][3] = "<%=CHANGED_BY %>";

data_header[18] = new Array;
data_header[18][0] = ""
data_header[18][1] = "hide";
data_header[18][2] = 0;
data_header[18][3] = "<%=CHANGED_DATE %>";

data_header[19] = new Array;
data_header[19][0] = ""
data_header[19][1] = "hide";
data_header[19][2] = 0;
data_header[19][3] = "<%=CHANGED_TIME %>";


data_header[20] = new Array;
data_header[20][0] = "Status"
data_header[20][1] = "data";
data_header[20][2] = 0;
data_header[20][3] = "<%=STATUS %>";




data_header[21] = new Array;
data_header[21][0] = "insulin"
data_header[21][1] = "hide";
data_header[21][2] = 0;
data_header[21][3] = "insulin";

data_header[22] = new Array;
data_header[22][0] = "IssueFrom"
data_header[22][1] = "hide";
data_header[22][2] = 0;
data_header[22][3] = "IssueFrom";

data_header[23] = new Array;
data_header[23][0] = "prescribedFrom"
data_header[23][1] = "hide";
data_header[23][2] = 0;
data_header[23][3] = "prescribedFrom";

data_arr = new Array();

<%	int counter = 0;
for(MasStoreItem masStoreItem : searchItemList){

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masStoreItem.getId()%>

<% if(masStoreItem.getGroup() != null){ %>
<%	Iterator itrGroupList = groupList.iterator();
while(itrGroupList.hasNext())
{
MasStoreGroup masStoreGroup = (MasStoreGroup)itrGroupList.next();
if(masStoreItem.getGroup().getId().equals(masStoreGroup.getId()) && masStoreGroup.getStatus().equalsIgnoreCase("y")){
%>
data_arr[<%= counter%>][1] = "<%=masStoreGroup.getGroupName()%>"
<%}else if(masStoreItem.getId().equals(masStoreGroup.getId()) && masStoreGroup.getStatus().equals("n")){%>
data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=masStoreGroup.getGroupName()%>";
<%}
}	%>
<%}%>




<% 



if(masStoreItem.getItemType() != null){%>
<%
Iterator itrGridTypeList =itemTypeList.iterator();


while(itrGridTypeList.hasNext())
{
MasItemType masItemType = (MasItemType)itrGridTypeList.next();

if(masStoreItem.getItemType().getId().equals(masItemType.getId()) && masItemType.getStatus().equalsIgnoreCase("y")){

%>
data_arr[<%= counter%>][2] = "<%=masItemType.getItemTypeName()%>"
<%}else if(masStoreItem.getItemType().getId().equals(masItemType.getId()) && masItemType.getStatus().equalsIgnoreCase("n")){%>
data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=masItemType.getItemTypeName()%>";
<%} }	%>
<%}%>

<% if(masStoreItem.getSection() != null){%>
<%
Iterator itrGridSectionList =storeSectionList.iterator();
while(itrGridSectionList.hasNext())
{
MasStoreSection masStoreSection = (MasStoreSection)itrGridSectionList.next();
if(masStoreItem.getSection().getId().equals(masStoreSection.getId()) && masStoreSection.getStatus().equalsIgnoreCase("y")){
%>
data_arr[<%= counter%>][3] = "<%=masStoreSection.getSectionName()%>"
<%}else if(masStoreItem.getId().equals(masStoreSection.getId()) && masStoreSection.getStatus().equals("n")){%>
data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masStoreSection.getSectionName()%>";
<%} }	%>
<%}%>

<% if(masStoreItem.getPvmsNo() != null){%>
data_arr[<%= counter%>][4] = "<%= masStoreItem.getPvmsNo() %>"
<%}%>



<% if(masStoreItem.getNomenclature() != null){
StringBuffer output_str = new StringBuffer();
StringTokenizer s = new StringTokenizer(masStoreItem.getNomenclature().toString(),"\"");

while (s.hasMoreTokens())
{
output_str.append(s.nextToken());
if (s.hasMoreTokens())
{
output_str.append("\\");
output_str.append("\"");
}
}
%>
data_arr[<%= counter%>][5] = "<%= output_str.toString()%>";
<%}%>

<% if(masStoreItem.getCommonName() != null){%>
data_arr[<%= counter%>][6] = "<%= masStoreItem.getCommonName()%>"
<%}else{%>
data_arr[<%= counter%>][6] = ""
<%}%>


<% if(masStoreItem.getItemConversion() != null){
%>
<%	Iterator itrGridItemConversionList = itemConversionList.iterator();
while(itrGridItemConversionList.hasNext())
{
MasStoreItemConversion masStoreItemConversion = (MasStoreItemConversion)itrGridItemConversionList.next();
if(masStoreItem.getItemConversion().getId().equals(masStoreItemConversion.getId()) && masStoreItemConversion.getStatus().equalsIgnoreCase("y")){
%>
data_arr[<%= counter%>][7] = "<%=masStoreItemConversion.getItemUnitName()%>";
<%}else if(masStoreItem.getId().equals(masStoreItemConversion.getId()) && masStoreItemConversion.getStatus().equalsIgnoreCase("n")){%>
data_arr[<%= counter%>][7] = "<font id='error'>*</font>Parent InActivated--<%=masStoreItemConversion.getItemUnitName()%>";
<%}
}	%>
<%}%>

<% if(masStoreItem.getItemClass() != null){%>
<%	Iterator itrGridItemClassList = masItemClassList.iterator();
while(itrGridItemClassList.hasNext())
{
MasItemClass masItemClass = (MasItemClass)itrGridItemClassList.next();
if(masStoreItem.getItemClass().getId().equals(masItemClass.getId()) && masItemClass.getStatus().equalsIgnoreCase("y")){
%>
data_arr[<%= counter%>][8] = "<%=masItemClass.getItemClassName()%>"
<%}else if(masStoreItem.getItemClass().getId().equals(masItemClass.getId()) && masItemClass.getStatus().equalsIgnoreCase("n")){%>
data_arr[<%= counter%>][8] = "<font id='error'>*</font>Parent InActivated--<%=masItemClass.getItemClassName()%>";
<%}
}	%>
<%}%>

<% if(masStoreItem.getItemCategory() != null){%>
<%	Iterator itrGridItemCategoryList = itemCategoryList.iterator();
while(itrGridItemCategoryList.hasNext())
{
MasItemCategory masItemCategory = (MasItemCategory)itrGridItemCategoryList.next();
if(masStoreItem.getItemCategory().getId().equals(masItemCategory.getId()) && masItemCategory.getStatus().equalsIgnoreCase("y")){
%>
data_arr[<%= counter%>][9] = "<%=masItemCategory.getItemCategoryName()%>"
<%}else if(masStoreItem.getId().equals(masItemCategory.getId()) && masItemCategory.getStatus().equalsIgnoreCase("n")){%>
data_arr[<%= counter%>][9] = "<font id='error'>*</font>Parent InActivated--<%=masItemCategory.getItemCategoryName()%>";
<%}
}	%>
<%}%>
data_arr[<%= counter%>][10] = "<%=masStoreItem.getBrandedGeneric()%>";

<% if(masStoreItem.getHighValueDrug() != null){%>
data_arr[<%= counter%>][11] = "<%= masStoreItem.getHighValueDrug() %>"
<%}%>



<% if(masStoreItem.getExpiry() != null){%>
data_arr[<%= counter%>][12] = "<%= masStoreItem.getExpiry() %>"
<%}else{%>
data_arr[<%= counter%>][12] = ""
<%}%>


<% if(masStoreItem.getTemperature() != null){%>
data_arr[<%= counter%>][13] = "<%= masStoreItem.getTemperature() %>"
<%}else{%>
data_arr[<%= counter%>][13] = ""
<%}%>



<% if(masStoreItem.getMinStock() != null){%>
data_arr[<%= counter%>][14] = "<%= masStoreItem.getMinStock() %>"
<%}else{%>
data_arr[<%= counter%>][14] = "0.00";
<%}%>
<% if(masStoreItem.getMaxStock() != null){%>
data_arr[<%= counter%>][15] = "<%= masStoreItem.getMaxStock() %>"
	<%}else{%>
data_arr[<%= counter%>][15] = "0.00";
<%}%>
	
	<% if(masStoreItem.getADispQty() != null){%>
	data_arr[<%= counter%>][16] = "<%= masStoreItem.getADispQty() %>"
		<%}else{%>
		data_arr[<%= counter%>][16] = "";
		<%}%>
	<% if(masStoreItem.getDispUnit() != null){%>
	data_arr[<%= counter%>][17] = "<%= masStoreItem.getDispUnit() %>"
		<%}else{%>
data_arr[<%= counter%>][17] = "";
<%}%>
		
	
	
<%if(masStoreItem.getLastChgBy()!=null){%>
data_arr[<%= counter%>][18] = "<%= masStoreItem.getLastChgBy().getFirstName() %>"
<%}else{
	%>
	data_arr[<%= counter%>][18] = "<%=userName%>";
<%}	%>


<%if(masStoreItem.getLastChgDate()!=null){%>
data_arr[<%= counter%>][19] = "<%= HMSUtil.convertDateToStringWithoutTime(masStoreItem.getLastChgDate()) %>"
<%}else{%>
	data_arr[<%= counter%>][19] = "<%=(String)HMSUtil.getCurrentDateAndTime().get("currentDate")%>";

<%}%>
<%if(masStoreItem.getLastChgTime()!=null){%>
data_arr[<%= counter%>][20] = "<%= masStoreItem.getLastChgTime() %>"
<%}else{
	%>
	data_arr[<%= counter%>][20] = "<%=(String)HMSUtil.getCurrentDateAndTime().get("currentTime")%>";
<%}%>


<% if(masStoreItem.getStatus().equalsIgnoreCase("Y") || masStoreItem.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][21] = "Active"
<%}else{%>
data_arr[<%= counter%>][21] = "InActive"
<%}%>

<% if(masStoreItem.getInsulinInjection() != null){%>
data_arr[<%= counter%>][22] = "<%= masStoreItem.getInsulinInjection() %>"
<%}else{%>
data_arr[<%= counter%>][22] = ""
<%}%>


<% if(masStoreItem.getIssueFrom() != null){%>
data_arr[<%= counter%>][23] = "<%= masStoreItem.getIssueFrom() %>"
<%}else{%>
data_arr[<%= counter%>][23] = ""
<%}%>

<% if(masStoreItem.getPrescribedFrom() != null){%>
data_arr[<%= counter%>][24] = "<%= masStoreItem.getPrescribedFrom() %>"
<%}else{%>
data_arr[<%= counter%>][24] = ""
<%}%>

<%
counter++;
}
%>

formName = "item"


start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>

	  