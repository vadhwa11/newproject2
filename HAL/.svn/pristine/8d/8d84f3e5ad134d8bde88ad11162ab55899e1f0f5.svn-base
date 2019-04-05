<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : pacsRight.jsp
	 * Tables Used         :
	 * Description         : Single Sign On User Rights
	 * @author Name        : Ranjesh Prasad
	 * Revision Date:
	 * Revision By:
	 * @version 1.0
--%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<script src="../jsp/pacs/js/jquery-1.8.2.js" type="text/javascript"></script>
<%@page import="jkt.hms.util.HMSUtil"%>

<script src="/hms/jsp/js/security/aes.js" type="text/javascript"></script>
<script src="/hms/jsp/js/security/pbkdf2.js" type="text/javascript"></script>
<script src="/hms/jsp/js/security/AesUtil.js" type="text/javascript"></script>
<script src="/hms/jsp/js/security/login.js" type="text/javascript"></script>
<style>
li {font-size:10px; color:#000; font-weight:normal;}
li:hover {font-size:10px; color:#1E90FF; cursor:pointer;}
</style>
<script>
$(document).ready(function(){
    $("#employeeFirstName").keyup(function(){
    	var loginName = $("#employeeFirstName").val();
    	$("#employeeList").css("display","none");
    	if(loginName!=''){
    		$("#employeeList").css("display","block");
    	}
        $.getJSON('/hms/hms/pacs?method=getUsers&loginName='+loginName , function (data) {
        	var listSize = data.usersList.length;
        	var employeeList='<ul>';
        	if(listSize>0){
        	for(i=0;i<listSize;i++){
        		firstName=data.usersList[i][3];
       			middleName='';
   				lastName='';
   				if(data.usersList[i][4]!=null){middleName=data.usersList[i][4];}
   				if(data.usersList[i][5]!=null){lastName=data.usersList[i][5];}
        		employeeList+='<li onclick=dataFill("'+data.usersList[i]+'") style="width: auto">'+firstName+' '+middleName+' '+lastName+'('+data.usersList[i][2]+')</li>';
        	}}else{employeeList+='<li style="color:red">--- No Data ---</li>';}
        	employeeList+='</ul>';
        	$("#employeeList").html(employeeList);
        });
    });
});

function dataFill(data){
	var data1=data.split(',');
	$("#employeeList").css("display","none");
	$("#employeeName").html(data1[3]+" "+data1[4]+" "+data1[5]);
	$("#loginName").html(data1[2]);
	$("#userId").val(data1[0]);
	$("#hospitalId").val(data1[1]);
	$("#loginName1").val(data1[2]);
	$("#employeeFirstName").val(data1[3]);
}

$(document).ready(function(){ 
    $("#save").click(function(){
    	var userId=$("#userId").val();
    	var hospitalId=$("#hospitalId").val();
    	var password=$("#password").val();
    	var repassword=$("#repassword").val();
    	var msg='Employee is not Valid!';
    	flag =true;
    	$("#msg").css('display','none');
    	if(userId==''){flag=false;}
    	if((flag==true) && hospitalId==''){flag=false;}
    	if((flag==true) && password==''){flag=false;msg="Password Empty!";}
    	if((flag==true) && (password!=''&& repassword=='')){flag=false;msg="Re-Password Empty!";}
    	if((flag==true) && password!=repassword){
    		msg="Password Not Match!";
    		$("#password").val('');
    		$("#repassword").val('');
    		flag=false;
    	}
    	if((flag==true) && $("#studyStatus").prop("checked")){
    		//var f=$("#signatureFile");
    		var x = document.getElementById("signatureFile");
    		var fileName='';
    		var fileEx='';
    		var fileSize=0;
    	    if ('files' in x) {
    	        if (x.files.length == 0) {
    	        	msg = "Signature not selected.";
    	        } else {
    	                var file = x.files[0];
    	                if ('name' in file) {
    	                	fileName= file.name;
    	                	fileEx=fileName.split('.');
    	                	if(fileEx[1]==='jpeg' || fileEx[1]=='jpg'){
    	                	}else{
    	                		msg="Only JPEG or JPG file supported!";
    	                		flag=false;
    	                	}
    	                }
    	                if ((flag==true)&&('size' in file)) {
    	                	fileSize=file.size/1024;
    	                	if(fileSize>50){
    	                		 msg=fileName+" more than 50kb!";
    	                 	    flag=false;
    	                	}
    	                }
    	            }
    	        }
    	    } 
    	if(flag==false){
    		$("#msg").css('display','block');
    		$("#msg").html(msg);
    		return flag;
    	}else{
    		return flag;
    	}
    });
});
function encriptFunction(id){
	var val= id.value;
	id.value=Encrypt(val);
 }
</script>
<%
	Map<String, Object> map=new HashMap<String, Object>();
	if(request.getAttribute("map")!=null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
	List<Object[]> users=new ArrayList<Object[]>();
	String msg="";
	if(map.get("msg")!=null){
		msg=(String)map.get("msg");
	}
	if(map.get("users")!=null){
		users=(List<Object[]>)map.get("users");
	}
%>
<div class="titleBg">
<h2>PACS Right</h2>
</div>
<div id="msg" class="error" style="display: none;"></div>
<form method="post" name="pacsRight" enctype="multipart/form-data" action="pacs?method=pacsRightSave">
<div class="Block">
	<div>
		<label>Employee Name</label>
		<label class="value" id="employeeName">...</label>
		<label>Login Name</label>
		<label class="value" id="loginName">...</label>
		<input type="hidden" name="loginName" id="loginName1" value="" />
		<input type="hidden" name="userId" id="userId" value="" />
		<input type="hidden" name="hospitalId" id="hospitalId" value="" />
	</div>
	<div class="clear"></div>
	<div style="width:315px; float:left; position: relative;"><label><span>*</span> Employee First Name</label>
	<input type="text" name="employeeFirstName"  autocomplete=off id="employeeFirstName"  maxlength="50"/>
	<div id="employeeList" class="autocomplete" style="width: 200px; display: none; 
	position: absolute;right: -41px; top: 23px;">
	</div>
	<div class="clear"></div>
	</div>
	<div style="width:640px; float:left;"><label><span>*</span> Password</label>
	<input type="password" name="password" autocomplete=off onfocus="if(this.value!=''){this.value=''}" onblur="if(this.value!=''){encriptFunction(this);}" id="password" maxlength="50"/>
	<label><span>*</span> Re-Password</label>
	<input type="password" id="repassword" autocomplete=off onfocus="if(this.value!=''){this.value=''}" onblur="if(this.value!=''){encriptFunction(this);}" maxlength="50"/>
	<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<label>Study Status.</label><input type="checkbox" name="studyStatus" id="studyStatus"/>
	<div id="signature" style="display: none"><label>Signature</label><input type="file" name="signature" id="signatureFile"  /></div>
	
</div>
<div class="clear"></div>
<input type="submit" class="button" id="save" value="Save"/>
<input type="reset" class="buttonHighlight" value="Reset"/>
</form>

<div class="clear"></div>
<div class="block">
	<table>
	<tr><th>S.No.</th><th>Users</th></tr>
	<% int count=1;
	if(users.size()>0){
		for(Object[] ob:users){
			System.out.println(""+ob[6]);
			InputStream inputStream = null;
					try{
					//inputStream=((byte[])ob[6]);
					}catch(Exception e){e.printStackTrace();}
		%>
	<tr><td><%=count %></td><td><%=ob[0] %> <%=ob[0] %></td></tr>
	<%++count;}} %>
	</table>
</div>
<script type="text/javascript">
$(document).ready(function(){
    $("#studyStatus").click(function(){
    	if($("#studyStatus").prop("checked")){
    		$("#signature").css('display', 'block');
    	}else{
    		$("#signature").css('display', 'none');
    	}
    });
});

	function funMsg(){
		var message='<%=msg%>';
			if(message.length>0){
			$("#msg").css('display','block');
			$("#msg").html(message);
			}
	}
	funMsg();
</script>