<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * detail.jsp  
 * Purpose of the JSP -  This is for Details
 * @author  Priyanka
 * Create Date: 11th Jan,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2  
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<%	
	System.out.println("This is Detail JSP");
	Map map = new HashMap();
		String includedJsp="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			
		}
		List<StoreIndentM> searchIndentList= new ArrayList<StoreIndentM>();
		List<StoreIndentM> gridIndentHeaderList= new ArrayList<StoreIndentM>();
		
		try{
			gridIndentHeaderList=(List)map.get("gridIndentHeaderList");
			System.out.println("searchSupplierList  in JSP "+gridIndentHeaderList.size());
			searchIndentList=(List)map.get("searchIndentList");
		}catch(Exception e){
			System.out.println("In Deatail Jsp");
		}
		
				
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	
	%>
<%@page import="java.util.Map"%>
<div id="contentspace"><script type="text/javascript"
	language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.INDENT_ID%>", "id"],[1, "<%= RequestConstants.INDENT_NO%>"], [2,"<%= RequestConstants.INDENT_DATE%>"], [3,"<%= RequestConstants.INDENT_FROM %>"], [4,"<%= RequestConstants.INDENT_TO %>"],[5,"<%=RequestConstants.STATUS%>"] ];
	 statusTd =5;

</script></div>
<form name="poDetails" method="post" action=""><script
	type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Radio"
		data_header[0][1] = "radio";
		data_header[0][2] = "15%";
		data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "INDENT No"
		data_header[1][1] = "data";
		data_header[1][2] = "15%";
		data_header[1][3] = "<%= RequestConstants.INDENT_NO%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "INDENT Date"
		data_header[2][1] = "data";
		data_header[2][2] = "15%";
		data_header[2][3] = "<%= RequestConstants.INDENT_DATE %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "INDENT FROM"
		data_header[3][1] = "data";
		data_header[3][2] = "15%";
		data_header[3][3] = "<%=RequestConstants.INDENT_FROM %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "INDENT TO"
		data_header[4][1] = "data";
		data_header[4][2] = "15%";
		data_header[4][3] = "<%=RequestConstants.INDENT_TO %>";
		
	
		
		
		data_header[5] = new Array;
		data_header[5][0] = "Status"
		data_header[5][1] = "data";
		data_header[5][2] = "15%";
		data_header[5][3] = "<%=RequestConstants.STATUS %>";
		
		data_arr = new Array();
		
		<%String st="";
		Iterator itrrr=gridIndentHeaderList.iterator();
		          int  counter=0;
		          while(itrrr.hasNext())
		           {           
		        	  StoreIndentM  storeIndentM = (StoreIndentM)itrrr.next(); 
		             %>
		
			data_arr[<%= counter%>] = new Array();
			
			data_arr[<%= counter%>][0] = <%= storeIndentM.getId()%>
			data_arr[<%= counter%>][1] = '<input type="radio"  name="parent" value="<%= storeIndentM.getId()%>" id="radio" />'
			data_arr[<%= counter%>][2] = "<%=storeIndentM.getIndentNo()%>"
			data_arr[<%= counter%>][3]="<%= storeIndentM.getIndentDate()%>"
			 data_arr[<%= counter%>][4]="<%= storeIndentM.getRequiredForm()%>"
			 data_arr[<%= counter%>][5]="<%= storeIndentM.getSuppliedBy()%>"
             	
				<%if(storeIndentM.getStatus().equals("y")){%>
						data_arr[<%= counter%>][6]="Active"
						<%}else{%>
						data_arr[<%= counter%>][6]="InActive"
						<%}%>
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