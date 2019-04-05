<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreQuotationReceiptM"%>

<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.StoreLoaninM"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<script type="text/javascript">
		<!--
		var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
		var IMGDIR_MISC = "images/misc";
		var vb_disable_ajax = parseInt("0", 10);
		// -->
		</script>
<%
List<StoreLoaninM> searchLoanInList= new ArrayList<StoreLoaninM>();
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
	String date1=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date1.length()<2){
		date1="0"+date1;
	}
%>
	serverdate = '<%=date1+"/"+month1+"/"+year1%>'
</script>
<%	
	Map map = new HashMap();
		String includedJsp="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			
		}
		List<StoreLoaninM> gridLoaninHeaderList= new ArrayList<StoreLoaninM>();
		
		try{
			gridLoaninHeaderList=(List)map.get("storeLoaninMList");
			System.out.println("gridLoaninHeaderList  in JSP "+gridLoaninHeaderList.size());
							
			
		}catch(Exception e){
		}
		
				
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	
	%>


<div id="contentHolder">
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="searchGrn" method="post">
<input type="hidden" name="Delete" value="Activate" />
<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.LOANIN_ID%>", "id"],[1, "<%= RequestConstants.LOANIN_NO%>"], [2,"<%= RequestConstants.LOANIN_DATE%>"], [3,"<%= RequestConstants.STORE_SUPPLIER_ID %>"], [4,"<%= RequestConstants.PO_ID %>"],[5,"<%=RequestConstants.STATUS%>"] ];
	 statusTd =5;

</script></form>
<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Loan In Id"
		data_header[0][1] = "data";
		data_header[0][2] = "15%";
		data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Loan In No"
		data_header[1][1] = "data";
		data_header[1][2] = "15%";
		data_header[1][3] = "<%= RequestConstants.LOANIN_NO%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Loan InDate"
		data_header[2][1] = "data";
		data_header[2][2] = "15%";
		data_header[2][3] = "<%= RequestConstants.LOANIN_DATE %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "SUPPLIER"
		data_header[3][1] = "data";
		data_header[3][2] = "15%";
		data_header[3][3] = "<%=RequestConstants.STORE_SUPPLIER_ID  %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "PO NO"
		data_header[4][1] = "data";
		data_header[4][2] = "15%";
		data_header[4][3] = "<%=RequestConstants.PO_ID %>";
		
		data_header[5] = new Array;
		data_header[5][0] = "Status"
		data_header[5][1] = "data";
		data_header[5][2] = "15%";
		data_header[5][3] = "<%=RequestConstants.STATUS %>";
		
		data_arr = new Array();
		
		<%String st="";
		Iterator itrrr=gridLoaninHeaderList.iterator();
		          int  counter=0;
		          while(itrrr.hasNext())
		           {           
		        	  StoreLoaninM  storeLoaninM = (StoreLoaninM)itrrr.next(); 
		             %>
		
			data_arr[<%= counter%>] = new Array();
			
			data_arr[<%= counter%>][0] = <%= storeLoaninM.getId()%>
			data_arr[<%= counter%>][1] = <%= storeLoaninM.getId()%>
			data_arr[<%= counter%>][2] = "<%=storeLoaninM.getLoaninNo()%>"
			data_arr[<%= counter%>][3]="<%= storeLoaninM.getLoaninDate()%>"
			 data_arr[<%= counter%>][4]="<%= storeLoaninM.getSupplier().getSupplierName()%>"
			 <% if(storeLoaninM.getPo()== null){%>
			 data_arr[<%= counter%>][5]="no Value"
			 <%}else{%>
			data_arr[<%= counter%>][5]="<%= storeLoaninM.getPo().getPoNumber()%>"
			<%}%>
		
		<%if(storeLoaninM.getStatus().equals("o")){%>
						data_arr[<%= counter%>][6]="Active"
						<%}else{%>
						data_arr[<%= counter%>][6]="InActive"
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
</div>
</div>