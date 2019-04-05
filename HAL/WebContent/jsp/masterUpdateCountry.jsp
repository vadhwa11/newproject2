<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * masterUpdateCountry.jsp  
 * Purpose of the JSP -  This is for Master update Country.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 12th Nov,2007 
 * Revision Date:      
 * Revision By: 
 * @version 1.3
--%>

<%@ page
	import="java.util.*,jkt.hms.masters.business.*,java.text.SimpleDateFormat"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js">
</script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js">
</script>
<form name="countryUpdate" method="post" action="">
<%
	int id=Integer.parseInt(request.getParameter("hidName"));
	Map map = new HashMap();
	map = (Map) request.getAttribute("map");
	List userNameList = new ArrayList();
	Iterator userNameListitr;
	if(map.get("countryList") != null){
	    userNameList = (List)map.get("countryList");
			}
		 userNameListitr=userNameList.iterator();
	     int userId1;
	   	 String countryCode= null;
	 	 String countryName=null;
	 	 int status;
	 	 String currency=null;
	 	 String lashChgBy=null;
	 	 String lashChgDate=null;
	 	 String lastChgTime=null;
	 	 
	 	 
	 	while (userNameListitr.hasNext()){
        	MasterCountry masterCountry=(MasterCountry) userNameListitr.next();
        	userId1= masterCountry.getId();
        	if(id==userId1){
        		id= masterCountry.getId();
        		countryCode=masterCountry.getCountryCode();
        		countryName=masterCountry.getCountryName();
        		status=masterCountry.getStatus();
       	        currency=masterCountry.getCurrency();
       	 	    lashChgBy=masterCountry.getLastChgby();
       	   	String date4MySQL="";
       	 	SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
   		    SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
   		  try{
   		      date4MySQL=formatterOut.format(formatterIn.parse(masterCountry.getLastchgdate().toString()) );
   		  }catch(Exception ee)
   		  {
   			  
   		  }
       	 	    lashChgDate=date4MySQL;
       	 	    lastChgTime=masterCountry.getLastchgtime();
          
        	}
     	
	 	}
	 	
%> <b>
<center>Master Update Country Page</center>
</b> <br>
<br>
<br>
<br>
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

&nbsp;Country Code<label>&nbsp;</label> <input type="text"
	name="country_code" value="<%=countryCode%>" MAXLENGTH="5"
	validate="Country Code, string,yes" /></><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Country Name <input type="text" name="country_name"
	value="<%=countryName%>" MAXLENGTH="30"
	validate="Country Name, string,yes" /><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="hidden" name="hidName" " value="<%=id%>" MAXLENGTH="5" />
Currency<label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
<select name="currency"
	onchange="getCurrency('countryUpdate','currency','currency_name')">
	<option value="Select">Select</option>
	<option value="Rs">Rs</option>
	<option value="Doll">Doll</option>
</select>&nbsp;&nbsp;&nbsp; <input type="text" name="currency_name"
	value="<%=currency%>" size="10" MAXLENGTH="10"
	validate="Currency Name, string,yes" /><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

Status<label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
Active<input type="radio" name="status" value="1" class="checkbox"
	checked="checked" /> In-Active<input type="radio" name="status"
	value="0" class="checkbox" /><br>
<br>
<br>
<br>
<br>
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

Changed By<input type="text" name="changed_by" value="<%=lashChgBy%>"
	size="10" MAXLENGTH="12" / validate="Changed By, string,yes">&nbsp;&nbsp;
Changed Date<input type="text" name="changed_date"
	value="<%=lashChgDate%>" MAXLENGTH="10"
	validate="Changed Date, string,yes" /> &nbsp;&nbsp; Changed Time<input
	type="text" name="changed_time" value="<%=lastChgTime%>" MAXLENGTH="5"
	validate="Changed Time, string,yes" /> <br>
<br>
<br>
<br>
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" name="Update" value="Update"
	onclick="if(checkDate('countryUpdate','changed_date')&&checkTime('countryUpdate','changed_time')){submitForm('countryUpdate','/hms/hms/master?method=updateMasterCountry');}" />

</form>
