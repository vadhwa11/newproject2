<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * SuperAdminMenu.jsp  
 * Purpose of the JSP -  This is for Super Admin Menu.
 * @author  Deeplai
 * @author  Mansi
 * Create Date: 04th Oct,2007 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="java.util.Map"%>
<%@ include file="header.jsp"%>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<DIV id=resadjust>
<DIV id="menu"></DIV>
</div>
<script type="text/javascript">
			var menu = new Array();
  
  
menu[0] = new Array();
menu[0][0] ='A1'
menu[0][1] ='0'
menu[0][2] ='Security Module'
menu[0][3] =''
menu[1] = new Array();
menu[1][0] ='A2'
menu[1][1] ='A1'
menu[1][2] ='User Master'
menu[1][3] ='/hms/hms/user?method=showUserJsp'
menu[2] = new Array();
menu[2][0] ='A3'
menu[2][1] ='A1'
menu[2][2] ='UserHospital Maintainance'
menu[2][3] ='/hms/hms/user?method=showUserHospMaintenanceJsp'

menu[3] = new Array();
menu[3][0] ='A4'
menu[3][1] ='A1'
menu[3][2] ='Hospital Master'
menu[3][3] ='/hms/hms/superAdmin?method=showHospitalMasterJsp'

menu[4] = new Array();
menu[4][0] ='A5'
menu[4][1] ='A1'
menu[4][2] ='User Group'
menu[4][3] ='/hms/hms/user?method=showUserGroupsJsp'        

menu[5] = new Array();
menu[5][0] ='A6'
menu[5][1] ='A1'
menu[5][2] ='User Group Hospital'
menu[5][3] ='/hms/hms/user?method=showUsergroupHospitalJsp'          
           	makeMainMenu();
           	
  </script>

</DIV>


<%
		String contentJsp="";
        Map mainMap=(Map)request.getAttribute("map");
        if(mainMap.get("contentJsp")!=null)
        {
		  contentJsp=(String)mainMap.get("contentJsp");
		 }
		 if(contentJsp != ""){  
%>

<div id="content"><jsp:include page="<%=contentJsp%>" flush="true" />
</div>

<%
		}
		else{
  %>

<div id="content"><jsp:include page="default.jsp" flush="true" />
</div>

<% 
 		}

%>
<%@ include file="footer.jsp"%>