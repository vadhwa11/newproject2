	<%if(session.getAttribute("hospitalId")!=null){
%>
<meta http-equiv="REFRESH" content="0;url=/hms/hms/login?method=showHomeJsp"/> 

<%}else{ %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>WELCOME TO IAF MEDNET</title>
<script src="/hms/jsp/js/AC_RunActiveContent.js" type="text/javascript"></script>
<style type="text/css">
body {background: url(/hms/jsp/images/wlcm-bg.gif) repeat-x #0714f8 top ;}

</style>

<meta http-equiv="REFRESH" content="6;url=/hms/hms/login?method=showInstructionJsp"> 

</head>
<body topmargin="0" leftmargin="0">

<table cellpadding="0" cellspacing="0" width="100%" height="100%">
<tr>
<td align="center" valign="middle">
  <script type="text/javascript">
AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0','width','720','height','600','src','WELCOME TO IAF MEDNET','quality','high','pluginspage','http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash','movie','/hms/jsp/WELCOME TO IAF MEDNET' ); //end AC code
</script><noscript><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0" width="720" height="600">
    <param name="movie" value="/hms/jsp/WELCOME TO IAF MEDNET.swf">
    <param name="quality" value="high">
    <embed src="/hms/jsp/WELCOME TO IAF MEDNET.swf" quality="high" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" width="720" height="600"></embed>
  </object></noscript></td>
</tr>
</table>
</body>
</html>
<%} %>