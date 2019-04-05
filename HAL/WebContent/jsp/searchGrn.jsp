<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreQuotationReceiptM"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript">
		<!--
		var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
		var IMGDIR_MISC = "images/misc";
		var vb_disable_ajax = parseInt("0", 10);
		// -->
		</script>
<%
List<StoreGrnM> searchGrnList= new ArrayList<StoreGrnM>();
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
		List<StoreGrnM> gridGrnHeaderList= new ArrayList<StoreGrnM>();

		try{
			gridGrnHeaderList=(List)map.get("gridGrnHeaderList");
			System.out.println("gridGrnHeaderList  in JSP "+gridGrnHeaderList.size());
			searchGrnList=(List)map.get("searchGrnList");
		}catch(Exception e){
		}


		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}

	%>


<form name="searchGrn" method="post" action="">
<div class="search" id="threadsearch">
<!--<a href=""></a>
--><script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<div class="searchBlock" id="threadsearch_menu" style="display: none">
<form name="searchPanel" method="post">
<div class="clear"></div>
		<label>From Date </label>
	<input type="text" name="<%= FROM_DATE %>" class="date" style="border: 1px solid #7f9db7;" maxlength="30" / tabindex=1 />
	<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"  border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.searchGrn.<%=FROM_DATE%>,event)" />
<label>To Date</label>
<input type="text" name="<%= TO_DATE %>" class="date" style="border: 1px solid #7f9db7;" maxlength="30" / tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.searchGrn.<%=TO_DATE%>,event)" />
<input	type="hidden" name="<%=GRN_NO%>" value="" tabindex=1 MAXLENGTH="100" id="<%=GRN_NO%>" />
<div id="ac3update"	style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=GRN_NO%>','ac3update','stores?method=getGrnNoListForAutoComplete',{parameters:'requiredField=<%=GRN_NO%>'});
			</script>
<div class="clear"></div>
<input	name="button" type="button" class="button"	onclick="submitForm('searchGrn','stores?method=searchGrn');"	value=" " />
</form>
</div>


<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />

<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
</div>
<div id="edited"></div>
<div id="statusMessage" class="messagelabel">
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="Add" type="submit" value="Add" class="toolbutton">
<input type="hidden" name="View" type="submit" value="Modify" class="button" onClick="submitForm('searchGrn','stores?method=modifyGrn');">
<input type="hidden" name="Reset" type="submit" value="Reset" class="button">
<input type="hidden" name="Delete" type="submit" value="Delete" class="button">
<%Iterator itrr=gridGrnHeaderList.iterator();
		          int  counter1=0;
		          while(itrr.hasNext())
		           {
		        	  StoreGrnM  storeGrnM = (StoreGrnM)itrr.next(); 
		        	  }
		             %>




<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>



<script type="text/javascript" language="javascript">

	formFields = [
			[0, "<%= GRN_ID%>", "id"],[1, "<%= GRN_NO%>"], [2,"<%= GRN_DATE%>"], [3,"<%= STORE_SUPPLIER_ID %>"], [4,"<%= PO_ID %>"],[5,"<%= INDENT_ID %>"],[6,"<%= SUPPLY_ORDER_NO %>"],[7,"<%= GRN_VALUE %>"][8,"<%=STATUS%>"] ];
	 statusTd =8;

</script>

<script type="text/javascript" language="javascript">

		data_header = new Array();

		data_header[0] = new Array;
		data_header[0][0] = ""
		data_header[0][1] = "radio";
		data_header[0][2] = "15%";
		data_header[0][3] = "<%=RADIO_FOR_TABLE%>"

		data_header[1] = new Array;
		data_header[1][0] = "CRV No."
		data_header[1][1] = "data";
		data_header[1][2] = "15%";
		data_header[1][3] = "<%=GRN_NO%>"

		data_header[2] = new Array;
		data_header[2][0] = "CRV Date"
		data_header[2][1] = "data";
		data_header[2][2] = "15%";
		data_header[2][3] = "<%= GRN_DATE %>";

		data_header[3] = new Array;
		data_header[3][0] = "Vendor"
		data_header[3][1] = "data";
		data_header[3][2] = "15%";
		data_header[3][3] = "<%=STORE_SUPPLIER_ID  %>";

		data_header[4] = new Array;
		data_header[4][0] = "SO No."
		data_header[4][1] = "data";
		data_header[4][2] = "15%";
		data_header[4][3] = "<%=PO_ID %>";


		data_header[5] = new Array;
		data_header[5][0] = "Indent No."
		data_header[5][1] = "data";
		data_header[5][2] = "15%";
		data_header[5][3] = "<%=INDENT_ID %>";

		data_header[6] = new Array;
		data_header[6][0] = "Supplier Order No."
		data_header[6][1] = "hide";
		data_header[6][2] = "15%";
		data_header[6][3] = "<%=SUPPLY_ORDER_NO %>";

		data_header[7] = new Array;
		data_header[7][0] = "CRV Value"
		data_header[7][1] = "data";
		data_header[7][2] = "15%";
		data_header[7][3] = "<%=GRN_VALUE%>";

		data_header[8] = new Array;
		data_header[8][0] = "Status"
		data_header[8][1] = "data";
		data_header[8][2] = "15%";
		data_header[8][3] = "<%=STATUS %>";

		data_arr = new Array();

		<%String st="";
		Iterator itrrr=gridGrnHeaderList.iterator();
		          int  counter=0;
		          while(itrrr.hasNext())
		           {
		        	  StoreGrnM  storeGrnM = (StoreGrnM)itrrr.next();
		             %>

			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= storeGrnM.getId()%>
			data_arr[<%= counter%>][1] = '<input type="radio"  name="parent" value="<%=storeGrnM.getGrnNo()%>" id="radio" />'
			data_arr[<%= counter%>][2] = "<%=storeGrnM.getGrnNo()%>"
			data_arr[<%= counter%>][3]="<%=HMSUtil.convertDateToStringWithoutTime(storeGrnM.getGrnDate())%>"
			<%if(storeGrnM.getSupplier()== null){%>
			 data_arr[<%= counter%>][4]="no value";
			 <%}else{%>
			 data_arr[<%= counter%>][4]="<%= storeGrnM.getSupplier().getSupplierName()%>"
			 <%}%>

			 <%if ((storeGrnM.getPo()== null)&& (storeGrnM.getIndent()== null)){%>
			 data_arr[<%= counter%>][5]="No Value"
			data_arr[<%= counter%>][6]="No Value"

			<%}else if(storeGrnM.getIndent()==null){%>
			data_arr[<%= counter%>][5]="<%= storeGrnM.getPo().getPoNumber()%>"
			data_arr[<%= counter%>][6]="No Value"

			<%}else if(storeGrnM.getPo()==null){%>
			data_arr[<%= counter%>][5]="No Value"
			data_arr[<%= counter%>][6]="<%= storeGrnM.getIndent().getIndentNo()%>"

			<%}%>
			 		<%if((storeGrnM.getPo()==null)){%>
			 		data_arr[<%= counter%>][7]="No Value"
			 		<%}else{%>
			 		data_arr[<%= counter%>][7]="<%= storeGrnM.getAtSoNo()%>"
			<%}%>

			 	data_arr[<%= counter%>][8]="<%= storeGrnM.getGrnValue()%>"

				<%if(storeGrnM.getStatus().equals("o")){%>
						data_arr[<%= counter%>][9]="Active"
						<%}else{%>
						data_arr[<%= counter%>][9]="InActive"
						<%}%>
		<% counter++;
			}
		%>

		formName = "searchGrn"


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
<input type="button" name="print" type="submit" class="button" value="Print " onClick="printGrn();">
<script type="text/javascript">
function printGrn(){
	//alert(document.getElementsByName('parent').length);
	
	for(var i = 0; i < document.getElementsByName('parent').length; i++){
		  if(document.getElementsByName('parent')[i].checked == true)
        {

		var grn=document.getElementById('radio').value
		   //alert(document.getElementsByName('parent')[i].value)
	      submitForm('searchGrn','stores?method=printGrn&grnNo='+document.getElementsByName('parent')[i].value);
		  return true;
		  }
	}
		  alert("Please select the CRV No. !!!")
			return false;	

}
</script>


</form>