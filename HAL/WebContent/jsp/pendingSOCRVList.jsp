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


<script type="text/javascript">
		var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
		var IMGDIR_MISC = "images/misc";
		var vb_disable_ajax = parseInt("0", 10);
		</script>
<%	
	Map map = new HashMap();
		List gridGrnHeaderList= new ArrayList();
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(map.get("objectList") != null){
	    	gridGrnHeaderList=(List)map.get("objectList");
		}
	
		System.out.println("gridGrnHeaderList  in JSP "+gridGrnHeaderList.size());
	
	%>
<div id="contentHolder">
<br>
<br>
<label style="width: 350px; FONT-SIZE: 14px; text-align: left;">CRV
List pending for Ledger Action</label> <br>
<jsp:include page="searchResultBlock.jsp" />
<form name="pendingSOCRVList" method="post" action="">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript" language="javascript">
	formFields = [
			[0, "<%= GRN_ID%>", "id"],[1, "<%= PO_NO%>"], [2,"<%= PO_DATE%>"], [3,"<%= SUPPLIER_NAME %>"], [4,"<%= PVMS_NO %>"],[5,"<%= AMOUNT %>"] ];
	 statusTd =5;
  </script></div>
</form>
<input type="button" name="details"	id="details" title="" align="right" class="cmnButton" value="Back" onClick="javaScript:history.back();" />
</div>


<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Radio"
		data_header[0][1] = "hide";
		data_header[0][2] = "20%";
		data_header[0][3] = "<%= RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "PO No"
		data_header[1][1] = "data";
		data_header[1][2] = "20%";
		data_header[1][3] = "<%= PO_NO%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "PO Date"
		data_header[2][1] = "data";
		data_header[2][2] = "25%";
		data_header[2][3] = "<%= PO_DATE %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Supplier Name"
		data_header[3][1] = "data";
		data_header[3][2] = "15%";
		data_header[3][3] = "<%=SUPPLIER_NAME  %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "Net Amount"
		data_header[4][1] = "data";
		data_header[4][2] = "15%";
		data_header[4][3] = "<%=AMOUNT %>";
				
		data_arr = new Array();
		
		<%String st="";
		Iterator itrrr=gridGrnHeaderList.iterator();
		          int  counter=0;
		          while(itrrr.hasNext())
		           {           
		        	  Object []storeGrnM = (Object [])itrrr.next(); 
		             %>
		
			data_arr[<%= counter%>] = new Array();
			
			data_arr[<%= counter%>][0] = <%=storeGrnM[0] %>
			data_arr[<%= counter%>][2] = "<%=storeGrnM[0] %>"
			data_arr[<%= counter%>][3] = "<%=HMSUtil.convertDateToStringWithoutTime((Date)storeGrnM[1]) %>"
			<%if(storeGrnM[2]== null){%>
			 data_arr[<%= counter%>][4]="-";
			<%}else{%>
			 data_arr[<%= counter%>][4]="<%= storeGrnM[2]%>" ;
			<%}%>
			data_arr[<%= counter%>][5]="<%= storeGrnM[3]%>"
			
		<% counter++;
			}
		%>
		 
		formName = "pendingSOCRVList"
		
		
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
