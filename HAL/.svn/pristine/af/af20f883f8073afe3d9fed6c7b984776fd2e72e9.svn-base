<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * searchIndent.jsp  
 * Purpose of the JSP -  This is for Search of Indent.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 11th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.4
--%>


<%@ page import="jkt.hms.util.RequestConstants"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>


<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

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
<%		List<StoreIndentM> searchIndentList= new ArrayList<StoreIndentM>();
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
	System.out.println("This is Detail JSP");
	Map map = new HashMap();
		String includedJsp="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			
		}
		List<StoreIndentM> gridIndentHeaderList= new ArrayList<StoreIndentM>();
		List<StoreInternalIndentM> storeInternalIndentMList= new ArrayList<StoreInternalIndentM>();
		List<StoreInternalIndentM> storeInternalIndentMList1= new ArrayList<StoreInternalIndentM>();
		List<StoreInternalIndentM> objectList= new ArrayList();
		
		try{
			storeInternalIndentMList=(List<StoreInternalIndentM>)map.get("searchStoreInternalIndentMList");
		storeInternalIndentMList1=(List<StoreInternalIndentM>)map.get("storeInternalIndentMList");
			System.out.println(storeInternalIndentMList1.size()+"storeInternalIndentMList  in JSP "+storeInternalIndentMList.size());
			objectList = (List)map.get("objectList");
		}catch(Exception e){
			System.out.println("In catch");
		}
		
				
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	
	%>

<form name="createGrn" method="post" action="">

<div class="clear"></div>
<h6>SEARCH</h6>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


</form>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>

<div id="searchBlock" style="display:none;">
 
<form name="depIndent" method="post" action="">

<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<form name="" method="">
<!-- 
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div> -->
<div class="clear"></div>
<!-- <div class="searchBlock" id="threadsearch_menu" style="display: none"> -->
<!-- <form name="searchPanel" method="post"> -->
<label>From Date</label>

<input	type="text" name="<%= FROM_DATE %>" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date"  tabindex="1"	onClick="setdate('<%=currentDate%>',document.depIndent.<%=FROM_DATE%>,event)" />

<label>To	Date</label>
<input	type="text" name="<%= TO_DATE %>" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" tabindex="1"	onClick="setdate('<%=currentDate%>',document.depIndent.<%=TO_DATE%>,event)" />
<div class="clear"></div>

<div class="clear"></div>
<label> Indent	No. </label>
<select name="<%=DEMAND_NO%>">
			<option value="">Select Indent No</option>
			<%
				for (StoreInternalIndentM mObj :storeInternalIndentMList ) {
			%>
			<option value=<%=mObj.getId()%>><%=mObj.getDemandNo()%></option>
			<%
				}
			%>
</select>
		
		<input type="hidden" name="numOfRows" size="5" value="5">
		<input type="hidden" name="<%=FROM_WARD %>" value="<%=storeInternalIndentMList.get(0).getDepartment().getId()%>" />
		<input type="button" name="sss" class="button" value="SEARCH" onClick="jsDisplay();" />
		<input type="button" name="sss" class="button" value="CLOSE"  onClick="closeSearch();" />
		
		</td>
</form>
</div>
</form>
</div>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<!-- 
<jsp:include page="searchResultPO.jsp" />
 -->
<jsp:include page="searchResultBlock.jsp" />
<form name="searchIndent" method="post" action="">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>



</div>
<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage" class="messagelabel"><br />
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>

<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.INDENT_ID%>", "id"],[1, "<%= RequestConstants.INDENT_NO%>"], [2,"<%= RequestConstants.INDENT_DATE%>"] ];
	 statusTd =2;

</script>
<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = ""
		data_header[0][1] = "radio";
		data_header[0][2] = "15%";
		data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Indent No."
		data_header[1][1] = "data";
		data_header[1][2] = "15%";
		data_header[1][3] = "<%= RequestConstants.INDENT_NO%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Indent date"
		data_header[2][1] = "data";
		data_header[2][2] = "15%";
		data_header[2][3] = "<%= RequestConstants.INDENT_DATE %>";
		
		
	
		
		
		
		
		data_arr = new Array();
		
		<%String st="";
		//Iterator itrrr=objectList.iterator();
		          int  counter=0;
		        // while(itrrr.hasNext())
		        	// for(StoreInternalIndentM siim : storeInternalIndentMList1)
		        		for(StoreInternalIndentM siim : objectList)
		           {           
		        	  //StoreIndentM  storeIndentM = (StoreIndentM)itrrr.next(); 
		        	//  Object []  object = (Object[] )itrrr.next(); 
		             %>
		
			data_arr[<%= counter%>] = new Array();
			
			data_arr[<%= counter%>][0] = <%= siim.getId()%>
			data_arr[<%= counter%>][1] = '<input type="radio"  name="parent" value="<%= siim.getDemandNo()%>" id="radio" />'
			data_arr[<%= counter%>][2] = "<%=siim.getDemandNo()%>"
			data_arr[<%= counter%>][3]="<%= HMSUtil.changeDateToddMMyyyy(siim.getDemandDate())%>"
			
             	
				
		<% counter++;
			}
		%>
		 
		formName = "searchIndent"
		
		
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

<input type="button" name="print" type="submit" class="button" value="Print" onClick="showReport();">
<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" />
<script type="text/javascript">


function showReport()
{
 var deptId='24';
  
 	for(var i = 0; i < document.getElementsByName('parent').length; i++){
			  if(document.getElementsByName('parent')[i].checked == true)
              {
	              //alert(document.getElementsByName('parent')[i].value)
               
                submitForm('searchIndent','stores?method=printDispensaryToStoreJsp&demandNo='+document.getElementsByName('parent')[i].value);
                return true;
			  }		
  		}
  		alert("Please select the Indent No. !!!")
		return false;
  
}

function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
}

function closeSearch()
{

document.getElementById('searchBlock').style.display = 'none';
}
function jsDisplay() {
	var demandNo = document.depIndent.<%=DEMAND_NO%>.value	
	//if (demandNo == "")
	//{
	//alert('Pl. select Indent No....');
	//return;
	//}

	document.depIndent.method="post";
	<%--submitForm('depIndent','stores?method=getDepartmentIndentData&<%=DEMAND_NO%>='+demandNo);--%>
	submitForm('depIndent','stores?method=getDepartmentIndentSearchData&<%=DEMAND_NO%>='+demandNo);
}

</script>

</form>