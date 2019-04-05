<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.StoreQuotationReceiptM"%>
<%@ page errorPage="error.jsp"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
		var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
		var IMGDIR_MISC = "images/misc";
		var vb_disable_ajax = parseInt("0", 10);
		</script>
<%	
	Map map = new HashMap();
		List<StoreGrnM> gridGrnHeaderList= new ArrayList<StoreGrnM>();
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(map.get("storeGrnMList") != null){
	    	gridGrnHeaderList=(List)map.get("storeGrnMList");
		}
	
		System.out.println("gridGrnHeaderList  in JSP "+gridGrnHeaderList.size());
	
	%>
<div id="contentHolder"><br>
<br>
<label style="width: 350px; FONT-SIZE: 14px; text-align: left;">CRV
List pending for Ledger Action</label> <br>
<jsp:include page="searchResultBlock.jsp" />
<form name="pendingLATList" method="post" action="">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript" language="javascript">
	formFields = [
			[0, "<%= GRN_ID%>", "id"],[1, "<%= GRN_NO%>"], [2,"<%= GRN_DATE%>"], [3,"<%= STORE_SUPPLIER_ID %>"], [4,"<%= PO_ID %>"],[5,"<%= INDENT_ID %>"],[6,"<%= SUPPLY_ORDER_NO %>"],[7,"<%= GRN_VALUE %>"][8,"<%=STATUS%>"] ];
	 statusTd =8;
  </script></div>
</form>
</div>
<div id="contentHolder"><input type="button" name="details"
	id="details" title="" align="right" class="cmnButton" value="Back"
	onClick="javaScript:history.back();" /></div>


<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Radio"
		data_header[0][1] = "hide";
		data_header[0][2] = "15%";
		data_header[0][3] = "<%= RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "CRV No"
		data_header[1][1] = "data";
		data_header[1][2] = "15%";
		data_header[1][3] = "<%= GRN_NO%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "CRV Date"
		data_header[2][1] = "data";
		data_header[2][2] = "15%";
		data_header[2][3] = "<%= GRN_DATE %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "SUPPLIER"
		data_header[3][1] = "data";
		data_header[3][2] = "15%";
		data_header[3][3] = "<%=STORE_SUPPLIER_ID  %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "PO NO"
		data_header[4][1] = "data";
		data_header[4][2] = "15%";
		data_header[4][3] = "<%=PO_ID %>";
		
	
		data_header[5] = new Array;
		data_header[5][0] = "Indent NO"
		data_header[5][1] = "hide";
		data_header[5][2] = "15%";
		data_header[5][3] = "<%=INDENT_ID %>";
		
		data_header[6] = new Array;
		data_header[6][0] = "Supplier order NO"
		data_header[6][1] = "hide";
		data_header[6][2] = "15%";
		data_header[6][3] = "<%=SUPPLY_ORDER_NO %>";
		
		data_header[7] = new Array;
		data_header[7][0] = "CRV Value"
		data_header[7][1] = "data";
		data_header[7][2] = "15%";
		data_header[7][3] = "<%=GRN_VALUE %>";
		
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
			data_arr[<%= counter%>][1] = '<input type="radio"  name="parent" value="<%= storeGrnM.getId()%>" id="radio" />'
			data_arr[<%= counter%>][2] = "<%=storeGrnM.getGrnNo()%>"
			data_arr[<%= counter%>][3]="<%= storeGrnM.getGrnDate()%>"
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
			
			 	data_arr[<%= counter%>][8]="<%= storeGrnM.getInvoiceAmount()%>"
             	
				<%if(storeGrnM.getStatus().equals("o")){%>
						data_arr[<%= counter%>][9]="Active"
						<%}else{%>
						data_arr[<%= counter%>][9]="InActive"
						<%}%>
		<% counter++;
			}
		%>
		 
		formName = "pendingLATList"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
