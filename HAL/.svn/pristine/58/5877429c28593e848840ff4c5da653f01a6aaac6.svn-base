<%@page import="java.net.URL"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<script src="../jsp/pacs/js/jquery-1.8.2.js" type="text/javascript"></script>
<style>
.error-div {
    background: #ebccd1;
    color: #a94442;
    float: left;
    font-size: 14px;
    margin: 1.7% 0 0 0.8%;
    padding: 0.7% 1%;
    width: 95.4%;
    height:auto;
    font-size: 14px;
    font-family: Verdana,sans-serif;
}
</style>

<div style="overflow: hidden; width:100%; height:100%;">
<jsp:include page="pacsHeader.jsp"></jsp:include>

<%
	Map<String, Object> map=new HashMap<String, Object>();
	if(request.getAttribute("map")!=null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
	boolean flag=false;
	String userName="";
	String pass="";
	String msg="";
	String appURL="";
	if(map.get("flag")!=null){
		flag=(Boolean)map.get("flag");
	}
	if(map.get("msg")!=null){
		msg=(String)map.get("msg");
	}
	if(map.get("userName")!=null){
		userName=(String)map.get("userName");
	}
	if(map.get("userPassword")!=null){
		pass=(String)map.get("userPassword");
	}
	if(map.get("appURL")!=null){
		appURL=(String)map.get("appURL");
	}
	if(flag){
%>
<script type="text/javascript">
	var myFun1=setTimeout(fun1, 0);
	var myFun2=setTimeout(fun2, 2000);
	var myFun3=setTimeout(fun3, 5000);
	function fun1(){$("#pacs").attr('src', '<%=appURL%>?wicket:interface=:0:modules:logout::ILinkListener::');
				$("#pacs").css('display', 'none');}
	function fun2(){$("#pacs").attr('src', '<%=appURL%>j_security_check?j_username=<%=userName%>&j_password=<%=pass%>');
				$("#pacs").css('display', 'none');}
	function fun3(){
				$("#processing").css('display', 'none');
				$("#pacs").attr('src', '<%=appURL%>');
				$("#pacs").css('display', 'block');}
</script>
 <div id="processing" style="padding-top: 10%; text-align: center; width:100%;"><img alt="PACS Loading..." src="/hms/jsp/pacs/images/pacs_loading.gif"></div>
 <iframe id='pacs' src='#' style="border: none;" width='100%' height='100%'></iframe>

 <%}else{ %>
 <div class="error-div"> <%=msg %></div>
 <%} %>
 
 </div>
 