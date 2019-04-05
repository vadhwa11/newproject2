<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasUnitOfMeasurement"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.StoreSupplyOrderEntry"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreDrugCost"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreDefectiveDrugM"%>
<%@page import="jkt.hms.masters.business.StoreCopyAddressList"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>

<%@page import="jkt.hms.util.RequestConstants"%><script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
		<!--
		var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
		var IMGDIR_MISC = "images/misc";
		var vb_disable_ajax = parseInt("0", 10);
		// -->
		</script>
<%

		StringBuffer orderDateOnly = new StringBuffer();
		GregorianCalendar gregorianCalendar1 = new GregorianCalendar();

		int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
		if (dateOfMonth < 10) {
			orderDateOnly.append("0");
			orderDateOnly.append(dateOfMonth);
		} else {
			orderDateOnly.append(dateOfMonth);
		}

		orderDateOnly.append("/");

		int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
		if (month < 10) {
			orderDateOnly.append("0");
			orderDateOnly.append(month);
		} else {
			orderDateOnly.append(month);
		}

		orderDateOnly.append("/");
		int year = gregorianCalendar1.get(Calendar.YEAR);
		orderDateOnly.append(year);
		String currentDate = new String(orderDateOnly);
	%>
<script>

<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
<%
	Map map = new HashMap();
		String includedJsp="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");

		}
		List<StoreDrugCost> storeDrugCostList = new ArrayList<StoreDrugCost>();
		try{
			storeDrugCostList=(List)map.get("storeDrugCostList");
			System.out.println("storeDrugCostList  in JSP "+storeDrugCostList.size());
			//searchDrugList=(List)map.get("searchDrugList");
		}catch(Exception e){
		}


		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");

		}
		List<MasManufacturer> manuList1 = new ArrayList<MasManufacturer>();
		if(map.get("manuList")!=null)
			manuList1 = (List) map.get("manuList");
		String  url = "/hms/hms/stores?method=drugCostEntry";

	%>


<!--<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">-->
<div class="clear"></div>

<div class="clear"></div>
<!--  <div class="searchBlock" id="threadsearch_menu" style="display: none">-->



<div id="searchBlock" style="display:none;">

<form name="createGrn" method="post" action="">
<!--<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">-->
<div class="clear"></div>
<h6>SEARCH</h6>
<!--  <div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>-->
<div class="clear"></div>
<div class="Block">
<form name="" method="">
<!--  <div class="searchBlock" id="threadsearch_menu" style="display: none">-->
<%String nameItem2="nameItem2";  %>
<label>PVMS/NIV No </label>
<input type="text" name="<%= ITEM_CODE %>" MAXLENGTH="30"  tabindex=1 />

<label>Nomenclature</label> <input type="text" value=""
	name="<%=nameItem2%>" id="<%=nameItem2%>"
	onblur="" />
<div id="ac2update1" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  		new Ajax.Autocompleter('<%=nameItem2%>','ac2update1','stores?method=getItemListForDefectiveDrugsByAutocomplete',{parameters:'requiredField=<%=nameItem2%>'});
			</script>
<div class="clear"></div>
<label >Manufacturer </label>
<!-- <input type="text" name="manu" MAXLENGTH="30"  tabindex=1 /> -->

<select id="manu"  tabindex="1" name="manu" >

<option value="0">Select</option>
	<%
	for (MasManufacturer mm : manuList1) {
	%>
	<option value="<%=mm.getId() %>"><%=mm.getManufacturerName() %></option>
	<%
	}
	%>
	</select>

 <input type="button" name="sss" class="button" value="SEARCH"  onClick="submitForm('createGrn','stores?method=searchDrugCost');" />


</div>
</form>
</form>
</div>





<!-- </div> -->
<!--  
<jsp:include page="searchResultPO.jsp" />
-->
<jsp:include page="searchResultBlock.jsp" />
<form name="searchDefectiveDrug22" method="post" action="">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>




</div>
<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage" class="messagelabel"><br />
</div>
<script type="text/javascript" language="javascript">

	formFields = [
			[0, "<%= ITEM_ID%>", "id"],[1, "<%= ITEM_CODE%>"],[2, "<%= ITEM_NAME%>"], [3,"<%= BRAND%>"], [4,"<%=MANUFACTURER%>"],[5,"<%= "Drug Cost"%>"]
			    ,[6,"<%= "Brand Name"%>"]   ];
	 statusTd =6;

</script>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input
					type="hidden" name="Add" type="submit" value="Add"
					class="button">
				<input
					type="hidden" name="Modify" type="submit" value="Modify"
					class="button"
					onClick="">
				<input
					type="hidden" name="Reset" type="submit" value="Reset"
					class="button">
				<input
					type="hidden" name="Delete" type="submit" value="Delete"
					class="button">
				<input
					type="hidden" name="print" type="submit" class="button"
					value="print " onClick="">
<div class="clear"></div>

<div class="clear"></div>

<script type="text/javascript" language="javascript">

		data_header = new Array();

		data_header[0] = new Array;
		data_header[0][0] = "Item_ID"
		data_header[0][1] = "hide";
		data_header[0][2] = "15%";
		data_header[0][3] = "<%= ITEM_ID%>"

			data_header[1] = new Array;
		data_header[1][0] = "PVMS/NIV No."
		data_header[1][1] = "data";
		data_header[1][2] = "15%";
		data_header[1][3] = "<%= ITEM_CODE%>"

		data_header[2] = new Array;
		data_header[2][0] = "Nomenclature"
		data_header[2][1] = "data";
		data_header[2][2] = "15%";
		data_header[2][3] = "<%= ITEM_NAME%>"

		data_header[3] = new Array;
		data_header[3][0] = "BRAND"
		data_header[3][1] = "data";
		data_header[3][2] = "15%";
		data_header[3][3] = "<%= BRAND%>";





		data_header[4] = new Array;
		data_header[4][0] = "Manufacturer"
		data_header[4][1] = "data";
		data_header[4][2] = "15%";
		data_header[4][3] = "<%= MANUFACTURER%>";

		data_header[5] = new Array;
		data_header[5][0] = "Drug Cost"
		data_header[5][1] = "data";
		data_header[5][2] = "15%";
		data_header[5][3] = "<%= "Drug Cost"%>";

		





		data_arr = new Array();

		<%String st="";
		Iterator itr=storeDrugCostList.iterator();
		          int  counter=0;
		          while(itr.hasNext())
		           {
		        	  StoreDrugCost  storeDrugCost = (StoreDrugCost)itr.next();
		             %>

			data_arr[<%= counter%>] = new Array();
<%if(storeDrugCost.getId()!=null){ %>
			data_arr[<%= counter%>][0] = <%= storeDrugCost.getId()%>
<%}%>
<%if(storeDrugCost.getItem().getId()!=null){%>
	data_arr[<%= counter%>][1] = "<%= storeDrugCost.getItem().getId()%>"
<%}%>
<%if(storeDrugCost.getItem().getPvmsNo()!=null){%>
			data_arr[<%= counter%>][2] = "<%=storeDrugCost.getItem().getPvmsNo()%>"
<%}%>
	<%			if(storeDrugCost.getItem().getId()!=null){%>
			data_arr[<%= counter%>][3] = "<%=storeDrugCost.getItem().getNomenclature()%>"
<%				}%>
				<% if (storeDrugCost.getBrand() != null){%>
				data_arr[<%= counter%>][4]="<%= storeDrugCost.getBrand().getBrandName()%>"
					<%}else{%>
					data_arr[<%= counter%>][4]="-"
						<%}%>
						<% 
						if (storeDrugCost.getManufacturer() != null){%>
						data_arr[<%= counter%>][5]="<%= storeDrugCost.getManufacturer().getManufacturerName()%>"
							<%}else{%>
					data_arr[<%= counter%>][5]="-"
						<%}%>
						data_arr[<%= counter%>][6]="<%= storeDrugCost.getDrugCost()%>"




		<% counter++;
			} 
			
		%>

		formName = "searchDefectiveDrug22"


		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);

		intializeHover('searchresulttable', 'TR', ' tableover');
</script>
<script type="text/javascript">

function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
}

<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" />
<input type="button" value="Back" class="button" onClick="submitForm('searchDefectiveDrug22','<%=url%>');" />
</form>
</div>