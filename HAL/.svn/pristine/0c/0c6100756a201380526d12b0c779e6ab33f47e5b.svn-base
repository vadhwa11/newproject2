<%@page import="java.util.*"%> 
<%@page import="java.io.*"%>  

<%  
	Map map = new HashMap(); 
	byte[] imgData =null; 
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}  
		
	if (map.get("signature") != null) {
		imgData = (byte[])map.get("signature");
	}
%>	
<body>
<%
if(imgData!=null){
response.setContentType("image/gif");
OutputStream o = response.getOutputStream();
o.write(imgData);
o.flush();
o.close();
}
%>   

</body>