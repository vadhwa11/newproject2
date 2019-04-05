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
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
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
    alert("Please first select the one Pvms/Niv NO!!! ");
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
	List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
	List<MasStoreBrand> gridBrandList = new ArrayList<MasStoreBrand>();
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
	brandList = (List<MasStoreBrand>)map.get("brandList");
	gridBrandList = (List<MasStoreBrand>)map.get("gridBrandList");
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
<div class="titleBg"><h2>PVMS Master</h2></div>
<div class="Clear"></div>
	  <div id="searcharea">
		  <div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
			  <label>PVMS No.</label>
			    <input type="radio" class="radioAuto" name="<%=SELECTED_RADIO  %>"   value="1" checked="unchecked" onclick="checkCriteria();"/>
			   
			    <label>Nomenclature</label>
					<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value="2"  checked="checked" onclick="checkCriteria();"/>
					<!-- -
				<label>Section Code</label>
					<input type="radio" class="radio" name="<%=SELECTED_RADIO %>"  id="radio3" value="3" onclick="checkCriteria();" />
                   <div id="sel" style="display: none;">
				   <select name="sectionCode" id="sectionCode" onchange="" tabindex=1>
				    <option value="0">Select</option>
				      <% for (MasStoreSection masStoreSection :sectionList) {  %>
				    <option value="<%=masStoreSection.getId ()%>"><%=masStoreSection.getSectionCode()%></option>
				      <%}%>
				   </select>
				    -->
				  
		            <div id="txt">
					 <input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Code,string,no"   MAXLENGTH="15" tabindex=1 onkeypress="return submitenter(this,event,'pharmacy?method=searchItem')" />
					 </div>
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','pharmacy?method=searchItem');" tabindex=1  />
                    <input type="reset" name ="add" id="reset" value ="Generate Report" class="buttonBig" onclick="submitForm('search','pharmacy?method=generateMedicineMasterReport');" accesskey="r"  tabindex=1 />
                    <input type="hidden" name="add" onclick="submitForm('search','pharmacy?method=generatePVMSExcel');" accesskey="r"  tabindex=1  value="Export To Excel" class="buttonBig">
 		             </div>
 		            <%--- Report Button   --%>  
 		            <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_item_list"> 
 		            <input type="hidden" name="itemType" value="1"/>
            </form>
			 </div>
		 </div>
<div class="Clear"></div>
	
	<jsp:include page="searchResultBlockForItemJsp.jsp" />
	<div class="Clear"></div>
	<div id="searchresults" >
	<div id="searchtable" ></div>
	<% 
		if(searchItemList.size()>0)
		 {
			String strForCode = (String)map.get("pvmsNo");
			String strForCodeDescription = (String)map.get("nomenclature");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
	  <!--  <h2> <a  href="pharmacy?method=showItemJsp">Show All Records</a></h2>  -->
	<%
			}
		 }
	 if(searchItemList.size()==0 && map.get("search") != null)
	 {
	%>
		<!--   <h2> <a  href="pharmacy?method=showItemJsp">Show All Records</a></h2>  -->
	<%
	}
	%>
	<script type="text/javascript">
		
		formFields = [
				[0, "<%= COMMON_ID%>", "id"], 
				[1,"sectionId"],
				[2,"<%= CODE%>"], 
				[3,"<%= OLD_NIV_NO%>"], 
				[4,"<%= SEARCH_NAME %>"],
				[5,"<%= STRENGTH %>"],
				[6,"<%= GROUP_ID %>"],
				[7,"<%= ITEM_GENERIC_ID %>"],
				[8,"<%= BRAND_ID %>"],
				[9,"<%= ITEM_TYPE_ID %>"],
				[10,"<%= ITEM_CATEGORY_ID %>"],
				[11,"<%= STORE_ITEM_CONVERSION_ID %>"],
				[12,"<%= DEPARTMENT_ID %>"],
				[13,"<%= COST_PRICE %>"],
				[14,"<%= PAC %>"],
				[15,"<%= PAC_NON_PAC %>"],
				[16,"<%= DANGEROUS_DRUG %>"],
				[17,"<%= CONTROLLED_DRUG %>"],
				[18,"<%= HIGH_VALUE_DRUG %>"],
				[19,"<%= RATE_CONTRACT_ITEM %>"],
				[20,"<%= SHELF_LIFE %>"],
				[21,"<%= ROL%>"], 
				[22,"<%= SALES_TAX %>"],
				[23,"<%= MAX_STOCK %>"],
				[24,"<%=MIN_STOCK%>"],
				[25,"<%=LEAD_TIME%>"],
				[26,"<%=LOCATION%>"],
				[27,"<%=SPECIFICATION%>"],
				[28,"<%=SOURCE_OF_SUPPLY%>"],
				[29,"<%=SLOW_MOVING_DAYS%>"],
				[30,"<%=FAST_MOVING_DAYS%>"],
				[31,"<%=NON_MOVING_DAYS%>"],
				[32,"<%=EXPIRY%>"],
				[33,"<%=ALLERGY%>"],
				[34,"<%= CHANGED_BY %>"], 
				[35,"<%= CHANGED_DATE %>"], 
				[36,"<%= CHANGED_TIME %>"], 
				[37,"<%= SOPHISTICATED_ITEM%>"],
				[38,"ppp_item"], 
				[39,"<%=COMMON_NAME%>"],
				[40,"<%= HIGH_RISK_MEDICNE %>"], 
				[41,"<%= ABC %>"],
				[42,"<%= VED %>"],
				 [43,"<%= GROUP_123 %>"],
				  [44,"typeOfItem"],
				  [45,"<%= STATUS %>"]
					  ];
				
		 statusTd = 45;
		</script>
		</div>
		
	  <form name="item" method="post" action="">
	   <input type="hidden" name="<%= HOSPITAL_ID %>" value = "0">
	  <input type="hidden" name="<%= POJO_NAME %>" value = "MasStoreItem">
	  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value = "Nomenclature">
	  <input type="hidden" name="<%=POJO_PROPERTY_CODE%>" value = "PvmsNo">
	  <input type="hidden" name="title" value = "Item">
	  <input type="hidden" name="<%=JSP_NAME %>" value = "item">
		<div class="Clear"></div>	
  <div class="Block">
			
				<label> Section Name<span>*</span></label>
				<%if(map.get("fromShowItem")!=null){%>
				<select id="sectionId" name="sectionId"  validate="Section Name,string,yes" onchange="populatePvmsNo(this.value)" tabindex=1>
				<%}else{ %>
				<select id="sectionId" name="sectionId" validate="Section Name,string,yes" tabindex=1>
				<% }%>
				<option value="0">Select</option>
				  <%
				  	for (MasStoreSection masStoreSection : storeSectionList) {
				  %>
				  <option value="<%=masStoreSection.getId()%>"><%=masStoreSection.getSectionName()%></option>
				  <%
				  	}
	  			  %>
				</select>
					<input type="hidden" value="1" name="<%= ITEM_TYPE_ID %>" id="itemTypeId"/>
			<!-- -	<select name="<%= ITEM_TYPE_ID %>" validate="Item Type,string,yes"  onchange="checkForNivItem(this.value)" tabindex=1>
				<option value="0">Select</option>
				  <%
				  	for (MasItemType masItemTypecode : itemTypeList) {
				  		if(masItemTypecode.getItemTypeName().equalsIgnoreCase("PVMS")){
				  %>
				  <option value="<%=masItemTypecode.getId ()%>"><%=masItemTypecode.getItemTypeName()%></option>
				  <%
				  		}
  				  	}
  				  %>
				</select> -->
			
		  	
		  	<label> PVMS No.<span>*</span></label>
			<input type="text" id="pvmsNo" name="<%= CODE%>" value="" validate="PVMS No.,string,yes"  onblur="checkPvmsForAlreadyExist();"  MAXLENGTH="20" tabindex=1 />
			<!-- 
			<label>Old NIV No.</label>
			<input type="text" id="oldNiv" name="<%= OLD_NIV_NO%>" value="" validate="Old NIV No,string,no"  MAXLENGTH="20" tabindex=1 />
			 -->
			
			<label> Nomenclature<span>*</span></label>
			<input type="text" id="nomenclatureToCheck" name="<%= SEARCH_NAME%>" value="" validate="Nomenclature,string,yes"  MAXLENGTH="250" class="large2" tabindex=1 />
			
			<label class="bodytextB">Common Name</label>
			<input type="text" id="nomenclatureToCheck" name="<%=COMMON_NAME%>" value="" class="large2" MAXLENGTH="250" tabindex=1 />
			
			<!-- -Comment by Dipali
			 
			 <label>Strength</label>
			<input type="text" name="<%= STRENGTH%>" value="" validate="Strength,string,no"  MAXLENGTH="30" tabindex=1 />
			<input type="hidden" name="<%=ITEM_GENERIC_ID%>"  />
			
		  	<div style="display:none;">						
			<select size="4" multiple="4" class="list" id="all_item_master_brand" >
				  <%
				  	for (MasStoreBrand masStoreBrand : brandList) {
				  %>
				  <option value="<%=masStoreBrand.getId ()%>"><%=masStoreBrand.getBrandName()%></option>
				  <%
				  	}
				  %>
		  	</select> 
		  	</div>	-->
		  			
		  	<div id="testDivForBrand">
		  							
	  		<label> Brand Name</label>
			
			<select name="<%= BRAND_ID %>" size="4" multiple="4" class="list" validate="Brand Name,string,no" tabindex=1 id="item_master_brand" >
			 <%
				  	for (MasStoreBrand masStoreBrand : brandList) {
				  %>
				  <option value="<%=masStoreBrand.getId ()%>"><%=masStoreBrand.getBrandName()%></option>
				  <%
				  	}
				  %>
		  	</select>
		  	</div>
		  
		  		<a  href="#" onclick="openPopupWindow(item.<%=SEARCH_NAME%>.value);">Add Brand</a>
		  	<div class="clear"></div>
		  			
		  	<div style="display:none;" id="addBrandId">		
				<label class="smallAuto" > <a  href="#" onclick="openPopupWindow(item.<%=COMMON_ID%>.value);">Add 2Brand</a></label>
				</div>
				<!--
					<label>Group</label>
				<select name="<%= GROUP_ID %>" validate="Groups,string,no"  tabindex=1>
				<option value="0">Select</option>
				  <%
				  	for (MasStoreGroup masStoreGroup : groupList) {
				  %>
				  <option value="<%=masStoreGroup.getId ()%>"><%=masStoreGroup.getGroupName()%></option>
				  <%
				   	}
				  %>
				</select>-->
						
				<label>Item Sub Category</label>
				<select name="<%= ITEM_CATEGORY_ID %>" validate="Item SubCategory,string,no" tabindex=1>
				<option value="0">Select</option>
				 <%
				  	for (MasItemCategory masItemCategory : itemCategoryList) {
				  %>
				  <option value="<%=masItemCategory.getId ()%>"><%=masItemCategory.getItemCategoryName()%></option>
				  <%
				  		  				  	}
				  		  				  %>
				  </select>
			<label>Branded/Generic</label>
			 <select name="<%=BRAND_GENERIC%>"  tabindex=1>
			  <option value="0">Select</option>
			  <option value="B">Branded</option>
			  <option value="G">Generic</option>
			  </select> 
	
			
				<label> A/U<span>*</span></label>
				<select name="<%= STORE_ITEM_CONVERSION_ID %>" validate="A/U,string,yes" tabindex=1>
				<option value="0">Select</option>
				 <%
				  	for (MasStoreItemConversion masStoreItemConversion : itemConversionList) {
				  %>
				  <option value="<%=masStoreItemConversion.getId ()%>"><%=masStoreItemConversion.getItemUnitName()%></option>
				  <%
				  	 	}
				   %>
				</select>
					<div class="Clear"></div>
		<label>Specification </label>
			<input type="text" name="<%= SPECIFICATION%>" value="" validate="Specn,string,no"  MAXLENGTH="50" tabindex=1 />
							 
		
			
			
		<label>Life Span</label> 
		<select value="0" name="<%= SHELF_LIFE%>"  validate="Life,string,no" tabindex=1>
		<option value="0">Select</option>
		<option value="LL">LL</option>
		<option value="SL">SL</option>

		</select>
			
			
			
	
			<label>Rate</label>
			<input type="text" name="<%= COST_PRICE%>" value="" validate="Rate,string,no"  MAXLENGTH="10" tabindex=1 />
					<div class="clear"></div>
			 <label> UOM </label>
			 <input type="text" value="" name="uom_id1" />
			  <input type="hidden" value="1" name="uom_id" />
			
			  <label>Source of supply</label>
			  <select name="<%=SOURCE_OF_SUPPLY%>"  tabindex=1>
			  <option value="0">Select</option>*
			  <option value="A">AFMSD</option>
			  <option value="L">Local purchase</option>
		      <option value="G">Other Government List</option>
			  <option value="O">Other Units</option>
			  </select>

		
			
			  <label>Remarks</label>
			  <input type="text" name="<%=REMARKS%>" id="remaeks" value="" maxlength="200" tabindex="1"/> 
			   <div class="clear"></div>
			  <label>Max Stock</label>
			<input type="text" name="<%= MAX_STOCK%>" value="" validate="Max Stock,float,no"   tabindex=1 />
			  <label>Min Stock</label>
			<input type="text" name="<%= MIN_STOCK%>" value="" validate="Min Stock,float,no"  tabindex=1 />

			
			
			
			 
			<label>ABC</label>
			<SELECT id="abc" name="<%=ABC%>" maxlength="30" tabindex="1">
			<option value="0">Select</option>
			<option value="A">A</option>
			<option value="B">B</option>
			<option value="C">C</option>
			</SELECT>
			<!--<input type="text" id="abc" name="<%=ABC %>" value="" maxlength="30" tabindex="1"/>
			-->
						<div class="clear"></div>
			<label>VED</label>
		    <SELECT id="ved" name="<%=VED %>"  maxlength="30" tabindex="1">
			   <option value="0">Select</option>
				<option value="D">D</option>
			    <option value="E">E</option>
			    <option value="V">V</option>
			</SELECT>
			<!--
			<input type="text" id="ved" name="<%=VED %>" value="" maxlength="30" tabindex="1"/>
		    -->
		    <!--<label>MMF</label>
			<input type="text" id="mmf" name="<%=MMF %>" value="" maxlength="30" tabindex="1"/>
			  --><!-- -
			<label>Group 1/2 3</label>
			<input type="text" id="group123" name="<%=GROUP_123 %>" value="" maxlength="30" tabindex="1"/>
		
			<input type="radio" class="radio" name="<%= PAC_NON_PAC%>" value="y"> 
			<label>PAC</label>
			<input type="radio" class="radio" name="<%= PAC_NON_PAC%>" value="n">
			<label >NON-PAC</label> 
	
  <div class="Clear"></div>
			<label>Dangerous Drug</label>
        	<input type="checkbox" class="radio" name="<%=DANGEROUS_DRUG %>" value="y" tabindex=1>
        
          	<label>High Risk Medicne</label>
        	<input type="checkbox" class="radio" name="<%=HIGH_RISK_MEDICNE %>" value="y" tabindex=1>
 
        	<label>Controlled Drug</label>			
			<input type="checkbox" class="radio" name="<%=CONTROLLED_DRUG %>" value="y" tabindex=1>
  	 <div class="Clear"></div>
			
			<label>High Value Drug</label>
			<input type="checkbox" class="radio" name="<%=HIGH_VALUE_DRUG %>" value="y" tabindex=1>
			
			<label>Rate Contract Item</label>
			<input type="checkbox" class="radio" name="<%=RATE_CONTRACT_ITEM %>" value="y" tabindex=1>  
		 -->
		<div class="Clear"></div>
		
			
			<!-- -
			<label>ROL (in days)</label>
			<input type="text" name="<%= ROL%>" value="" validate="ROL,string,no"  MAXLENGTH="25" tabindex=1 />
			
		<div class="Clear"></div>	
			
			<label>Sales tax</label>
			<input type="text" name="<%= SALES_TAX%>" value="" validate="Sales Tax,float,no"   tabindex=1 />
			
			<label>Lead Time(Days)</label>
			<input type="text" name="<%= LEAD_TIME%>" value="" validate="Lead Time,string,no"  MAXLENGTH="10" tabindex=1 />
			 -->
			
			
			<div class="Clear"></div>
			
			 	<!-- -
			
			 <label>Location</label>
			<input type="text" name="<%= LOCATION%>" value="" validate="Location,string,no"  MAXLENGTH="10" tabindex=1 />
			
			
			 	
			 <div class="Clear"></div>	
			 
			
			 	
			<label>Slow Moving Days</label>
			<input type="text" name="<%= SLOW_MOVING_DAYS%>" value="" validate="Slow Moving Days,int,no"  MAXLENGTH="50" tabindex=1 />
			
			<label>Fast Moving Days</label>
			<input type="text" name="<%= FAST_MOVING_DAYS%>" value="" validate="Fast Moving Days,int,no"  MAXLENGTH="50" tabindex=1 />
			<div class="Clear"></div>
			
			
			<label>Non Moving Days</label>
			<input type="text" name="<%= NON_MOVING_DAYS%>" value="" validate="Non Moving Days,int,no"  MAXLENGTH="50" tabindex=1 />
			<label>Expiry</label>
			 <select name="<%=EXPIRY%>" onkeypress="return submitenter(this,event,'pharmacy?method=addItem','checkPvmsNo')"  tabindex=1>
			  <option value="0">Select</option>
			  <option value="y">Yes</option>
			  <option value="n">No</option>
			  
			 </select>
<div class="Clear"></div>
</div>
			<label>Allergy</label>
			<input type="text" name="<%= ALLERGY%>" value="" validate="Allergy,String,no"  MAXLENGTH="50" tabindex=1 />


			<label>Sophisticated Item</label>
			 <select name="<%=SOPHISTICATED_ITEM%>" onkeypress="return submitenter(this,event,'pharmacy?method=addItem','checkPvmsNo')"  tabindex=1>
			  <option value="0">Select</option>
			  <option value="y">Yes</option>
			  <option value="n">No</option>
			 </select>

			<label>PPP Item</label>
 
			 <select name="ppp_item" tabindex=1>
			  <option value="0">Select</option>
			  <option value="y">Yes</option>
			  <option value="n">No</option>
			 </select>
			-->
			 <label>Expiry</label>
			 <select name="<%=EXPIRY%>" onkeypress="return submitenter(this,event,'pharmacy?method=addItem','checkPvmsNo')"  tabindex=1>
			  <option value="0">Select</option>
			  <option value="y">Yes</option>
			  <option value="n">No</option>
			  
			 </select>
			 <label>Allergy</label>
			<input type="text" name="<%= ALLERGY%>" value="" validate="Allergy,String,no"  MAXLENGTH="50" tabindex=1 />
			<label>PPP Item</label>
 
			 <select name="ppp_item" tabindex=1>
			  <option value="0">Select</option>
			  <option value="y">Yes</option>
			  <option value="n">No</option>
			 </select>
			 <div class="clear"></div>
			 <label>Temperature</label>
			 <input type="text" name="Temperature" value=""></input>
			  <label>Salt</label>
			 <input type="text" name="Salt" value=""></input>
			 <div class="clear"></div>
		      <label>Dispensing Unit Name</label>
			 <select name="DispUnName">
				  <%
				  	for (MasStoreUnit masStoreUnit : uomList) 
				  	{
				  %>
				  <option value="<%=masStoreUnit.getId ()%>"><%=masStoreUnit.getUnitName()%></option>
				  <%
				  	}
				  %>
		  	 </select> 
		  	 <label>Item Strength Qty</label>
			 <input type="text" name="ItemStrenQty" value=""/>	 
			 <label>Type of Item<span>*</span></label>
<select name="typeOfItem" id="typeOfItem" validate="Type of item,String,yes">
<option value="">Select</option>
<option value="E">Expendable</option>
<option value="NE">NonExpendable</option>
</select>
			 
</div>
<div class="Clear"></div>
<div class="division"></div>
			 <div id="edited"></div>
	<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('item','pharmacy?method=addItem','checkPvmsNo','checkFieldForAmpersant')" accesskey="a" tabindex=1 style="display:inline"/>
	<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('item','pharmacy?method=editItem&flag='+this.value,'checkPvmsNo','checkFieldForAmpersant')" accesskey="u" tabindex=1 style="display:none;"/>
	<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('item','pharmacy?method=deleteItem&flag='+this.value)" accesskey="d" tabindex=1/>		
	<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r"  tabindex=1 />
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
			<input type="hidden" name="rowsPerPageForItem" id="rowsPerPageForItem"  value="10" />
		</div>	
			

</form>			
<script>
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
		alert("Please Enter valid PVMS No. starting with Section Code")
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
data_header[0][0] = ""
data_header[0][1] = "hide";
data_header[0][2] = 0;
data_header[0][3] = "<%= SECTION_ID %>";

data_header[1] = new Array;
data_header[1][0] = "PVMS No."
data_header[1][1] = "data";
data_header[1][2] = "14%";
data_header[1][3] = "<%= CODE%>"

data_header[2] = new Array;
data_header[2][0] = "Old NIV No."
data_header[2][1] = "hide";
data_header[2][2] = "14%";
data_header[2][3] = "<%=OLD_NIV_NO %>";

data_header[3] = new Array;
data_header[3][0] = "Nomenclature"
data_header[3][1] = "data";
data_header[3][2] = 0;
data_header[3][3] = "<%= SEARCH_NAME %>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=STRENGTH %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=GROUP_ID %>"

data_header[6] = new Array;
data_header[6][0] = "Generic Name"
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%=ITEM_GENERIC_ID %>"

data_header[7] = new Array;
data_header[7][0] = "Brand_Ids"
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%=BRAND_ID %>";

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "0";
data_header[8][3] = "<%=ITEM_TYPE_ID %>"

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%=ITEM_CATEGORY_ID %>"

data_header[10] = new Array;
data_header[10][0] = "A/U"
data_header[10][1] = "data";
data_header[10][2] = 0;
data_header[10][3] = "<%=STORE_ITEM_CONVERSION_ID %>"

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "<%=DEPARTMENT_ID %>"

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "<%=COST_PRICE %>"

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = 0;
data_header[13][3] = "<%=PAC %>"

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = 0;
data_header[14][3] = "<%=PAC_NON_PAC %>"

data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = 0;
data_header[15][3] = "<%=DANGEROUS_DRUG %>"

data_header[16] = new Array;
data_header[16][0] = ""
data_header[16][1] = "hide";
data_header[16][2] = 0;
data_header[16][3] = "<%=CONTROLLED_DRUG %>"

data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = 0;
data_header[17][3] = "<%=HIGH_VALUE_DRUG %>"

data_header[18] = new Array;
data_header[18][0] = ""
data_header[18][1] = "hide";
data_header[18][2] = 0;
data_header[18][3] = "<%=RATE_CONTRACT_ITEM %>"

data_header[19] = new Array;
data_header[19][0] = ""
data_header[19][1] = "hide";
data_header[19][2] = 0;
data_header[19][3] = "<%=SHELF_LIFE %>";

data_header[20] = new Array;
data_header[20][0] = ""
data_header[20][1] = "hide";
data_header[20][2] = 0;
data_header[20][3] = "<%=ROL %>";

data_header[21] = new Array;
data_header[21][0] = ""
data_header[21][1] = "hide";
data_header[21][2] = 0;
data_header[21][3] = "<%=SALES_TAX %>";

data_header[22] = new Array;
data_header[22][0] = ""
data_header[22][1] = "hide";
data_header[22][2] = 0;
data_header[22][3] = "<%=MAX_STOCK %>";

data_header[23] = new Array;
data_header[23][0] = ""
data_header[23][1] = "hide";
data_header[23][2] = 0;
data_header[23][3] = "<%=MIN_STOCK %>";

data_header[24] = new Array;
data_header[24][0] = ""
data_header[24][1] = "hide";
data_header[24][2] = 0;
data_header[24][3] = "<%=LEAD_TIME %>";

data_header[25] = new Array;
data_header[25][0] = ""
data_header[25][1] = "hide";
data_header[25][2] = 0;
data_header[25][3] = "<%=LOCATION %>";

data_header[26] = new Array;
data_header[26][0] = ""
data_header[26][1] = "hide";
data_header[26][2] = 0;
data_header[26][3] = "<%=SPECIFICATION %>";

data_header[27] = new Array;
data_header[27][0] = ""
data_header[27][1] = "hide";
data_header[27][2] = 0;
data_header[27][3] = "<%=SOURCE_OF_SUPPLY %>";

data_header[28] = new Array;
data_header[28][0] = ""
data_header[28][1] = "hide";
data_header[28][2] = 0;
data_header[28][3] = "<%=SLOW_MOVING_DAYS %>";

data_header[29] = new Array;
data_header[29][0] = ""
data_header[29][1] = "hide";
data_header[29][2] = 0;
data_header[29][3] = "<%=FAST_MOVING_DAYS %>";

data_header[30] = new Array;
data_header[30][0] = ""
data_header[30][1] = "hide";
data_header[30][2] = 0;
data_header[30][3] = "<%=NON_MOVING_DAYS %>";

data_header[31] = new Array;
data_header[31][0] = ""
data_header[31][1] = "hide";
data_header[31][2] = 0;
data_header[31][3] = "<%=EXPIRY %>";

data_header[32] = new Array;
data_header[32][0] = ""
data_header[32][1] = "hide";
data_header[32][2] = 0;
data_header[32][3] = "<%=ALLERGY %>";

data_header[33] = new Array;
data_header[33][0] = ""
data_header[33][1] = "hide";
data_header[33][2] = 0;
data_header[33][3] = "<%=CHANGED_BY %>";

data_header[34] = new Array;
data_header[34][0] = ""
data_header[34][1] = "hide";
data_header[34][2] = 0;
data_header[34][3] = "<%=CHANGED_DATE %>";

data_header[35] = new Array;
data_header[35][0] = ""
data_header[35][1] = "hide";
data_header[35][2] = 0;
data_header[35][3] = "<%=CHANGED_TIME %>";

data_header[36] = new Array;
data_header[36][0] = "Sophisticated"
data_header[36][1] = "hide";
data_header[36][2] = 0;
data_header[36][3] = "<%=SOPHISTICATED_ITEM%>";

data_header[37] = new Array;
data_header[37][0] = "PPP Item"
data_header[37][1] = "hide";
data_header[37][2] = 0;
data_header[37][3] = "ppp_item";

data_header[38] = new Array;
data_header[38][0] = "Common Name"
data_header[38][1] = "hide";
data_header[38][2] = 0;
data_header[38][3] = "<%=COMMON_NAME%>";

data_header[39] = new Array;
data_header[39][0] = "High Risk Medicne"
data_header[39][1] = "hide";
data_header[39][2] = 0;
data_header[39][3] = "<%=HIGH_RISK_MEDICNE %>";

data_header[40] = new Array;
data_header[40][0] = ""
data_header[40][1] = "hide";
data_header[40][2] = 0;
data_header[40][3] = "<%=ABC %>";

data_header[41] = new Array;
data_header[41][0] = "Status"
data_header[41][1] = "hide";
data_header[41][2] = 0;
data_header[41][3] = "<%=VED %>";

data_header[42] = new Array;
data_header[42][0] = ""
data_header[42][1] = "hide";
data_header[42][2] = 0;
data_header[42][3] = "<%=GROUP_123 %>";

data_header[43] = new Array;
data_header[43][0] = "Item Type"
data_header[43][1] = "data";
data_header[43][2] = 0;
data_header[43][3] = "typeOfItem";

data_header[44] = new Array;
data_header[44][0] = "Status"
data_header[44][1] = "data";
data_header[44][2] = 0;
data_header[44][3] = "<%=STATUS %>";

data_arr = new Array();

<%	int counter = 0;
//System.out.println(searchItemList.size());
	for(MasStoreItem masStoreItem : searchItemList){
		System.out.println("item type===="+masStoreItem.getTypeOfItem());
%>

	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = <%= masStoreItem.getId()%>
<% if(masStoreItem.getSection() != null){%>
<%
Iterator itrGridSectionList =storeSectionList.iterator();
 while(itrGridSectionList.hasNext())
       {
          MasStoreSection masStoreSection = (MasStoreSection)itrGridSectionList.next(); 
          
 if(masStoreItem.getSection().getId().equals(masStoreSection.getId()) && masStoreSection.getStatus().equals("y")){
	//System.out.println("id:::1::::"+masStoreSection.getId()); 
	//System.out.println("id:::2::::"+masStoreSection.getSectionName());
 %>
	data_arr[<%= counter%>][1] = "<%=masStoreItem.getSection().getId()%>"
<%}else if(masStoreItem.getSection().getId()== masStoreSection.getId() && masStoreSection.getStatus().equals("n")){
	//System.out.println("id:::2::::"+masStoreSection.getId());
%>
	data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=masStoreSection.getSectionName()%>";
<%} %>
   <%  
 }	%>
<%}%>
		
	<% if(masStoreItem.getPvmsNo() != null){%>
	data_arr[<%= counter%>][2] = "<%= masStoreItem.getPvmsNo() %>"
	<%}else{ %>
	data_arr[<%= counter%>][2] = ""
	<%}%>
	
	<% if(masStoreItem.getOldNivNo() != null){%>
	data_arr[<%= counter%>][3] = "<%= masStoreItem.getOldNivNo()%>"
	<%}else{%>
	data_arr[<%= counter%>][3] = ""
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
	data_arr[<%= counter%>][4] = "<%= output_str.toString()%>";
<%}%>

<% if(masStoreItem.getStrength() != null){%>
	data_arr[<%= counter%>][5] = "<%= masStoreItem.getStrength()%>"
	<%}else{%>
	data_arr[<%= counter%>][5] = ""
	<%}%>
	
<% if(masStoreItem.getGroup() != null){%>	
<%	Iterator itrGroupList = groupList.iterator();
	 while(itrGroupList.hasNext())
           {
            MasStoreGroup masStoreGroup = (MasStoreGroup)itrGroupList.next(); 
            if(masStoreItem.getGroup().getId()!=null){
		 if(masStoreItem.getGroup().getId().equals(masStoreGroup.getId()) && masStoreGroup.getStatus().equals("y")){
		 %>
			data_arr[<%= counter%>][6] = "<%=masStoreGroup.getId()%>"
		<%}else if(masStoreItem.getId().equals(masStoreGroup.getId()) && masStoreGroup.getStatus().equals("n")){%>
			data_arr[<%= counter%>][6] = "<font id='error'>*</font>Parent InActivated--<%=masStoreGroup.getGroupName()%>";
		<%}
}	}%>
<%}%>

<% if(masStoreItem.getItemGeneric() != null){%>	
<%	Iterator itrGridItemGenericList = itemGenericList.iterator();
	 while(itrGridItemGenericList.hasNext())
           {
            MasStoreItemGeneric masStoreItemGeneric = (MasStoreItemGeneric)itrGridItemGenericList.next(); 
            if(masStoreItem.getItemGeneric().getId()!=null){
		 if(masStoreItem.getItemGeneric().getId().equals(masStoreItemGeneric.getId()) && masStoreItemGeneric.getStatus().equals("y")){
		 %>//System.out.println("in if");
			data_arr[<%= counter%>][7] = "<%=masStoreItemGeneric.getGenericName()%>"
		<%}else if(masStoreItem.getId().equals(masStoreItemGeneric.getId()) && masStoreItemGeneric.getStatus().equals("n")){%>
		//System.out.println("in else if");
			data_arr[<%= counter%>][7] = "<font id='error'>*</font>Parent InActivated--<%=masStoreItemGeneric.getGenericName()%>";
		<%}
}}	%>
<%}else{%>
	data_arr[<%= counter%>][7] = ""
	//	System.out.println("in else ");
<%}%>
	

<% if(masStoreItem.getMasStoreBrands() != null)
{ StringBuffer brand_ids = new StringBuffer(); 
%>
 <%
  	Set<MasStoreBrand> brandSet = (Set<MasStoreBrand>)masStoreItem.getMasStoreBrands();
     for (Iterator iterator = brandSet.iterator(); iterator.hasNext();) 
      {
    	  MasStoreBrand masStoreBrand = (MasStoreBrand) iterator.next();
    	  if (masStoreItem.getId() == masStoreBrand.getItem().getId())
    	  {
    		  if (brand_ids.toString().length() > 0)
    		  {
    			  brand_ids.append(",");
    			  brand_ids.append(masStoreBrand.getId());
    		  }
    		  else
    		  {
    			  brand_ids.append(masStoreBrand.getId());
    		  }
    	  }
      }
      %>
      data_arr[<%= counter%>][8] = "<%=brand_ids.toString()%>"
<%}
else
{%>
data_arr[<%= counter%>][8] = "----------"
<%}%>


<% if(masStoreItem.getItemType() != null){
%>
<%	Iterator itrGridItemTypeList = itemTypeList.iterator();
		 while(itrGridItemTypeList.hasNext())
            {
             MasItemType masItemType = (MasItemType)itrGridItemTypeList.next(); 
             if(masStoreItem.getItemType().getId()!=null){
			 if(masStoreItem.getItemType().getId().equals(masItemType.getId()) && masItemType.getStatus().equals("y")){
			 %>
				data_arr[<%= counter%>][9] = "<%=masItemType.getItemTypeName()%>"
			<%}else if(masStoreItem.getId().equals(masItemType.getId()) && masItemType.getStatus().equals("n")){%>
				data_arr[<%= counter%>][9] = "<font id='error'>*</font>Parent InActivated--<%=masItemType.getItemTypeName()%>";
			<%}
}	}%>
<%}%>
	
<% if(masStoreItem.getItemCategory() != null){%>
<%	Iterator itrGridItemCategoryList = itemCategoryList.iterator();
	 while(itrGridItemCategoryList.hasNext())
           {
            MasItemCategory masItemCategory = (MasItemCategory)itrGridItemCategoryList.next(); 
            if(masStoreItem.getItemCategory().getId()!=null){
		 if(masStoreItem.getItemCategory().getId().equals(masItemCategory.getId()) && masItemCategory.getStatus().equals("y")){
		 %>
			data_arr[<%= counter%>][10] = "<%=masItemCategory.getItemCategoryName()%>"
		<%}else if(masStoreItem.getId().equals(masItemCategory.getId()) && masItemCategory.getStatus().equals("n")){%>
			data_arr[<%= counter%>][10] = "<font id='error'>*</font>Parent InActivated--<%=masItemCategory.getItemCategoryName()%>";
		<%}
}}	%>
<%}%>


<% if(masStoreItem.getItemConversion() != null){
%>
<%	Iterator itrGridItemConversionList = itemConversionList.iterator();
	 while(itrGridItemConversionList.hasNext())
           {
            MasStoreItemConversion masStoreItemConversion = (MasStoreItemConversion)itrGridItemConversionList.next(); 
            if(masStoreItem.getItemConversion().getId()!=null){
		 if(masStoreItem.getItemConversion().getId().equals(masStoreItemConversion.getId()) && masStoreItemConversion.getStatus().equals("y")){
		 %>
			data_arr[<%= counter%>][11] = "<%=masStoreItemConversion.getItemUnitName()%>"
		<%}else if(masStoreItem.getId().equals(masStoreItemConversion.getId()) && masStoreItemConversion.getStatus().equals("n")){%>
			data_arr[<%= counter%>][11] = "<font id='error'>*</font>Parent InActivated--<%=masStoreItemConversion.getItemUnitName()%>";
		<%}
}}	%>
<%}%>
<%if(masStoreItem.getDepartment() != null){
%>
<%	Iterator itrGridDepartmentList = departmentList.iterator();
	 while(itrGridDepartmentList.hasNext())
           {
            MasDepartment masDepartment = (MasDepartment)itrGridDepartmentList.next(); 
            if(masStoreItem.getDepartment().getId()!=null){
		 if(masStoreItem.getDepartment().getId().equals(masDepartment.getId()) && masDepartment.getStatus().equals("y")){
		 %>
			data_arr[<%= counter%>][12] = "<%=masDepartment.getDepartmentName()%>"
		<%}else if(masStoreItem.getId().equals(masDepartment.getId()) && masDepartment.getStatus().equals("n")){%>
		data_arr[<%= counter%>][12] = "<font id='error'>*</font>Parent InActivated--<%=masDepartment.getDepartmentName()%>";
		<%}
}	
}%>
<%}%>	
<% if(masStoreItem.getCostPrice() != null)
{
%>
data_arr[<%= counter%>][13] = "<%= masStoreItem.getCostPrice() %>"
<%
}else{
%>
data_arr[<%= counter%>][13] = ""
<%}%>

<% if(masStoreItem.getPac() != null){%>
data_arr[<%= counter%>][14] = "<%= masStoreItem.getPac() %>"
<%}else{%>
data_arr[<%= counter%>][14] = ""
<%}%>

<% if(masStoreItem.getNonPac() != null){%>
data_arr[<%= counter%>][15] = "<%= masStoreItem.getNonPac() %>"
<%}else{%>
data_arr[<%= counter%>][15] = ""
<%}%>

<% if(masStoreItem.getDangerousDrug() != null){ %>
     data_arr[<%= counter%>][16] = "<%= masStoreItem.getDangerousDrug() %>"
<%}%>

<% if(masStoreItem.getControlledDrug() != null){%>
data_arr[<%= counter%>][17] = "<%= masStoreItem.getControlledDrug() %>"
<%}%>


<% if(masStoreItem.getHighValueDrug() != null){%>
data_arr[<%= counter%>][18] = "<%= masStoreItem.getHighValueDrug() %>"
<%}%>
<% if(masStoreItem.getRateContractItem() != null){%>
data_arr[<%= counter%>][19] = "<%= masStoreItem.getRateContractItem() %>"
<%}%>


<% if(masStoreItem.getSelfLife() != null){%>
data_arr[<%= counter%>][20] = "<%= masStoreItem.getSelfLife() %>"
<%}else{%>
data_arr[<%= counter%>][20] = ""
<%}%>

<% if(masStoreItem.getRol() != null){%>
data_arr[<%= counter%>][21] = "<%= masStoreItem.getRol() %>"
<%}else{%>
data_arr[<%= counter%>][21] = ""
<%}%>

<% if(masStoreItem.getSalesTax() != null){%>
data_arr[<%= counter%>][22] = "<%= masStoreItem.getSalesTax() %>"
<%}else{%>
data_arr[<%= counter%>][22] = ""
<%}%>

<% if(masStoreItem.getMaxStock() != null){%>
data_arr[<%= counter%>][23] = "<%= masStoreItem.getMaxStock() %>"
<%}else{%>
data_arr[<%= counter%>][23] = ""
<%}%>

<% if(masStoreItem.getMinStock() != null){%>
data_arr[<%= counter%>][24] = "<%= masStoreItem.getMinStock() %>"
<%}else{%>
data_arr[<%= counter%>][24] = ""
<%}%>

<% if(masStoreItem.getLeadTime() != null){%>
data_arr[<%= counter%>][25] = "<%= masStoreItem.getLeadTime() %>"
<%}else{%>
data_arr[<%= counter%>][25] = ""
<%}%>

<% if(masStoreItem.getLocation() != null){%>
data_arr[<%= counter%>][26] = "<%= masStoreItem.getLocation() %>"
<%}else{%>
data_arr[<%= counter%>][26] = ""
<%}%>

<% if(masStoreItem.getSpecification() != null){%>
data_arr[<%= counter%>][27] = "<%= masStoreItem.getSpecification() %>"
<%}else{%>
data_arr[<%= counter%>][27] = ""
<%}%>

<% if(masStoreItem.getSourceOfSupply() != null){%>
data_arr[<%= counter%>][28] = "<%= masStoreItem.getSourceOfSupply() %>"
<%}else{%>
data_arr[<%= counter%>][28] = ""
<%}%>

<% if(masStoreItem.getSlowMovingDays() != null){%>
data_arr[<%= counter%>][29] = "<%= masStoreItem.getSlowMovingDays() %>"
<%}else{%>
data_arr[<%= counter%>][29] = ""
<%}%>

<% if(masStoreItem.getFastMovingDays() != null){%>
data_arr[<%= counter%>][30] = "<%= masStoreItem.getFastMovingDays() %>"
<%}else{%>
data_arr[<%= counter%>][30] = ""
<%}%>

<% if(masStoreItem.getNonMovingDays() != null){%>
data_arr[<%= counter%>][31] = "<%= masStoreItem.getNonMovingDays() %>"
<%}else{%>
data_arr[<%= counter%>][31] = ""
<%}%>


<% if(masStoreItem.getExpiry() != null){%>
data_arr[<%= counter%>][32] = "<%= masStoreItem.getExpiry() %>"
<%}else{%>
data_arr[<%= counter%>][32] = ""
<%}%>

<% if(masStoreItem.getAllergy() != null){%>
data_arr[<%= counter%>][33] = "<%= masStoreItem.getAllergy() %>"
<%}else{%>
data_arr[<%= counter%>][33] = ""
<%}if(!masStoreItem.getLastChgBy().equals("")&&masStoreItem.getLastChgDate()!=null&&!masStoreItem.getLastChgTime().equals("")){%>

data_arr[<%= counter%>][34] = "<%= masStoreItem.getLastChgBy() %>"
data_arr[<%= counter%>][35] = "<%= HMSUtil.convertDateToStringWithoutTime(masStoreItem.getLastChgDate()) %>"
data_arr[<%= counter%>][36] = "<%= masStoreItem.getLastChgTime() %>"

data_arr[<%= counter%>][37] = "<%= masStoreItem.getSophisticatedItem()%>"
data_arr[<%= counter%>][38] = "<%= masStoreItem.getPppItem()%>"
<% }
if(masStoreItem.getCommonName() != null){
	StringBuffer output_str1 = new StringBuffer();
	StringTokenizer s = new StringTokenizer(masStoreItem.getCommonName().toString(),"\""); 
	
	while (s.hasMoreTokens())
	{
		output_str1.append(s.nextToken());
		if (s.hasMoreTokens())
		{
		output_str1.append("\\");
 	        output_str1.append("\"");
		}
	}
%>
	data_arr[<%= counter%>][39] = "<%= output_str1.toString()%>";
<%}else{%>
    data_arr[<%= counter%>][39] = "<%= ""%>";

<%} 

 if(masStoreItem.getHighRiskMedicne() != null){ 
    System.out.println("masStoreItem.getHighRiskMedicne()--"+masStoreItem.getHighRiskMedicne());
    System.out.println("counter--"+counter);%>
    data_arr[<%=counter%>][40] = "<%= masStoreItem.getHighRiskMedicne() %>";
<%}%>
<%	 if(masStoreItem.getAbc() != null){ %>
data_arr[<%=counter%>][41] = "<%= masStoreItem.getAbc() %>";
<%}else{%>
data_arr[<%=counter%>][41] = ""
<%}%>
<%	 if(masStoreItem.getVed() != null){ %>
data_arr[<%=counter%>][42] = "<%= masStoreItem.getVed() %>";
<%}else{%>
data_arr[<%=counter%>][42] = ""
<%}%>
<%	 if(masStoreItem.getGroup123() != null){ %>
data_arr[<%=counter%>][43] = "<%= masStoreItem.getGroup123() %>";
<%}else{%>
data_arr[<%=counter%>][43] = ""
<%}%>
<%	

if(masStoreItem.getTypeOfItem() != null && !masStoreItem.getTypeOfItem().equals("")){
if(masStoreItem.getTypeOfItem().equals("E")){ %>
data_arr[<%=counter%>][44] = "Expendable";
<%}else{%>
data_arr[<%=counter%>][44] = "NonExpendable"
<%}}else{%>
data_arr[<%=counter%>][44] = ""
<%}%>

<%
if(masStoreItem.getStatus().equals("y")){ %>
data_arr[<%= counter%>][45] = "Active"
<%}else{%>
data_arr[<%= counter%>][45] = "InActive"
<%}%>

<%
     counter++;
}
%>
 
	formName = "item"
	
	nonEditable = ['<%= CODE%>'];
	start = 0
	rowsPerPage = 10;
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = 10;
	makeTable(start,end);
	
	intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  