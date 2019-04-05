<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * masterAddCountry.jsp  
 * Purpose of the JSP -  This is for Master add Country.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 28th Jun,2007 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>

<%@ page import="java.util.*,jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js" />
 <form name="countryAdd" method="post" action=""  >
	<%	 
	Map map = new HashMap();
	map = (Map) request.getAttribute("map");
	List userNameList = new ArrayList();
	if(map.get("countryList") != null)
	    userNameList = (List)map.get("countryList");
		 Iterator userNameListitr=userNameList.iterator();
	     int userId;
	 	 String country_code= null;
	 	 	 	while (userNameListitr.hasNext()){
        	MasterCountry masterCountry=(MasterCountry) userNameListitr.next();
          userId= masterCountry.getId();
          country_code=masterCountry.getCountryCode();
     	 }
	 	
%>
		<center><label for="male" ></label><br></center>
	<b><center>Master Add Country Page</center></b>
	<br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	&nbsp;Country Code<label>&nbsp;</label>
	
	
	<input type="text" name="country_code" value="" MAXLENGTH="5" validate = "Country Code, string,yes"/><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	Country Name
	<input type="text" name="country_name" value="" MAXLENGTH="30" validate = "Country Name, string,yes"/><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	Currency<label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
				<select name="currency"  onchange="getCurrency('countryAdd','currency','currency_name')">
				  <option value="Select">Select</option>
				  <option value="Rs">Rs</option>			
	 			  <option value="Doll">Doll</option>
	 			</select>&nbsp;&nbsp;&nbsp;
	 			
	 <input type="text" name="currency_name"  size ="10" MAXLENGTH="10" validate = "Currency Name, string,yes" /><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	 Status<label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
	 Active<input type="radio" name="status" value="1" class="checkbox" checked="checked" />
	  In-Active<input type="radio" name="status" value="0" class="checkbox" /><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   
	    Changed By	<input type="text" name="changed_by" value="" size ="10" MAXLENGTH="12" validate = "changed_by, string,yes" />&nbsp;&nbsp;
		Changed Date<input type="text" name="changed_date" value="" MAXLENGTH="10" validate = "changed_date, string,yes"  /> &nbsp;&nbsp;
		Changed Time<input type="text" name="changed_time" value="" MAXLENGTH="5" validate = "changed_time, string,yes" /> <br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" name="Add" value="Add" 
						onclick="if(checkDate('countryAdd','changed_date') && checkTime('countryAdd','changed_time')){submitForm('countryAdd','/hms/hms/master?method=addMasterCountry');}"/>
	
	
</form>