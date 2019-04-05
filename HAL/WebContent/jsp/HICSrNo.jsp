<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<form name="hic" method="post" action="">
<%
System.out.println("session  "+request.getParameter("session"));
%>
<div class="Block">
<div class="Clear"></div>
<label> Service No:</label>
<input type="text" id="srNoId" name="serviceNo" value="" class="calDate"MAXLENGTH="30" /> 

</div>
<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button"	onclick="submitForm('hic','/hms/hms/registration?method=getServiceNoDetailsFromHIC');" />
<div class="Clear"></div>

</form>
 