<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreBalanceM"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

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

<%		List<StoreBalanceM> searchStoreBalanceMList= new ArrayList<StoreBalanceM>();
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
<%	
	Map<String,Object> map = new HashMap<String,Object>();
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			
		}
		List<StoreBalanceM> gridIndentHeaderList= new ArrayList<StoreBalanceM>();
		
		try{
			gridIndentHeaderList=(List)map.get("indentHeaderList");
			System.out.println("gridIndentHeaderList>>"+gridIndentHeaderList.size());
			searchStoreBalanceMList=(List)map.get("searchStoreBalanceMList");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		ArrayList gridApprovedByList = (ArrayList)map.get("approvedByEmployeeList");
		
			
		
	%>

<div class="clear"></div>



<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />

<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>



</div>
<div id="edited"></div>

<div id="statusMessage" class="messagelabel"><br />
</div>
<form name="storeBalanceSearch" method="post">
<!--  
<input name="Back" type="button" tabindex="1"align="right" onclick="submitForm('storeBalanceSearch','/hms/hms/stores?method=showBalanceJsp')" class="button" value="Back" />
-->
</form>

<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= BALANCE_ID%>", "id"],[1, "<%= BALANCE_NO%>"], [2,"<%= BALANCE_DATE%>"], [3,"<%= APPROVED_BY_EMPLOYEE_ID_BALANCE %>"],[4,"<%=REMARKS%>"] ];
	 statusTd =4;

</script>

 <form name="searchBalance1" method="post" action="">
<script type="text/javascript" language="javascript">
		function checkRadio(id){
		
		document.getElementById("tempRadioValue").value =id
		
		}
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = ""
		data_header[0][1] = "data";
		data_header[0][2] = "15%";
		data_header[0][3] = "<%= RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Balance No."
		data_header[1][1] = "data";
		data_header[1][2] = "15%";
		data_header[1][3] = "<%= BALANCE_NO%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Balance Date"
		data_header[2][1] = "data";
		data_header[2][2] = "15%";
		data_header[2][3] = "<%= BALANCE_DATE %>";
		
			
		data_header[3] = new Array;
		data_header[3][0] = "Approved By"
		data_header[3][1] = "data";
		data_header[3][2] = "15%";
		data_header[3][3] = "<%=APPROVED_BY_EMPLOYEE_ID_BALANCE %>";
		
		
		data_header[4] = new Array;
		data_header[4][0] = "Remarks"
		data_header[4][1] = "data";
		data_header[4][2] = "15%";
		data_header[4][3] = "<%=REMARKS %>";
		
		data_arr = new Array();
		
		<%String st="";
		Iterator itrrr=gridIndentHeaderList.iterator();
		          int  counter=0;
		          while(itrrr.hasNext())
		           {           
		        	  StoreBalanceM  storeBalanceM = (StoreBalanceM)itrrr.next(); 
		             %>
		
			data_arr[<%= counter%>] = new Array();
			
			data_arr[<%= counter%>][0] = <%= storeBalanceM.getId()%>
			data_arr[<%= counter%>][1] = '<input type="radio"  name="parent" value="<%= storeBalanceM.getBalanceNo()%>"  id="radio" />'
			data_arr[<%= counter%>][2] = "<%=storeBalanceM.getBalanceNo()%>"
			data_arr[<%= counter%>][3]= "<%= HMSUtil.changeDateToddMMyyyy(storeBalanceM.getBalanceDate())%>"
			
	
            
             <%
		Iterator itrGridApprovedByList=gridApprovedByList.iterator();
		 while(itrGridApprovedByList.hasNext())
            {try{
             MasEmployee  approvedByGrid = (MasEmployee)itrGridApprovedByList.next(); 
			 if(storeBalanceM.getApprovedBy().getId().equals(approvedByGrid.getId()) && approvedByGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][4] = "<%=approvedByGrid.getFirstName()%> <%=approvedByGrid.getLastName()%>"
			<%}else if(storeBalanceM.getId().equals(approvedByGrid.getId()) && approvedByGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=approvedByGrid.getFirstName()%> <%=approvedByGrid.getLastName()%>";
				
			<%}
            }catch(Exception e){
            	e.printStackTrace();
            	
            }}%>
            
   
            <%
            	if(storeBalanceM.getRemarks() != null){
            %>
            	data_arr[<%= counter%>][5] = "<%=storeBalanceM.getRemarks()%>"
            <%}else{%>
            data_arr[<%= counter%>][5] = "";
			<%}%>
			
		<% counter++;
			}
		%>
		 
		formName = "searchBalance1"
		
		
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
-->
</script>
<div class="clear"></div>
<input type="button" name="print" type="submit" class="button" value="Print" onClick="showReport();">
<!-- <input type="button" name="Modify" type="submit" value="Modify" 	class="button" onClick="if(requiredFields()){submitForm('searchBalance1','stores?method=modifyBalance&balanceId ='+document.getElementsByName('parent')[i].value)}"> 
<input type="button" name="Modify" type="submit" value="Modify" 	class="button" onClick="requiredFields();">-->
<input name="Back" type="button" tabindex="1"align="right" onclick="submitForm('searchBalance1','/hms/hms/stores?method=showBalanceJsp')" class="button" value="Back" />
</div>


<script type="text/javascript">
function showReport()
{
 
  
 	for(var i = 0; i < document.getElementsByName('parent').length; i++){
			  if(document.getElementsByName('parent')[i].checked == true)
              {
	             // alert(document.getElementsByName('parent')[i].value)
                submitForm('searchBalance1','stores?method=printOpeningBalanceJsp&balanceNo='+document.getElementsByName('parent')[i].value);
                return true;
			  }		
  		}
  		alert("Please select the Balance No. !!!")
		return false;
  
}

function requiredFields(){
	//alert("requiredFields")
	 for(var i = 0; i < document.getElementsByName('parent').length; i++){
				  if(document.getElementsByName('parent')[i].checked == true)
	              {	//alert("requiredFields "+document.getElementsByName('parent')[i].value)
					  submitForm('searchBalance1','stores?method=modifyBalance&balanceId='+document.getElementsByName('parent')[i].value);
	                return true;
				  }		
	  		}
	  		alert("Please select the  Balance No. !!")
			return false;
	}

</script>
</form>