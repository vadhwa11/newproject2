<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascrip" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%
	String date = "";
	String time = "";
	
	Box box = HMSUtil.getBox(request);
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	Map map = new HashMap();
 	Users user =null;
 	String deptName = "";
 	String message = "";
 	int hospitalIdFromSession=0;
 	
 	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
	}
		
		
		
		
		if(map.get("hospitalId")!=null)
			hospitalIdFromSession = (Integer)map.get("hospitalId");
		
		List<MasHospital> hospitalList=new ArrayList<MasHospital>();
		if (map.get("hospitalList")!=null)
			hospitalList  = (List<MasHospital>)map.get("hospitalList");
		
		List<MasButtonForm> formList=new ArrayList<MasButtonForm>();
		if (map.get("formList")!=null)
			formList  = (List<MasButtonForm>)map.get("formList");
		
		if (map.get("message")!=null)
			message  = (String)map.get("message");
	
		if (map.get("user")!=null)
			user = (Users)map.get("user");
%>
<h4><%=message%></h4>
<form name="removeButtonRightsForm" method="post">
<div class="titleBg">
<h2>Remove Button Rights</h2>
</div>
<div class="Clear"></div>
<h4>User Details</h4>
<div class="Clear"></div>
<div class="Block">
<label>User Name</label> 
<label class="value"> <%= user.getUserName() %></label>
<input type="hidden" value="<%=user.getId() %>" name="userId" /> 
<label>Login Name</label> 
<label class="value"> <%=user.getLoginName() %></label> 
<label>Employee Name</label> 
<% String empName="";
	  	if(user.getEmployee() != null){
		  if(user.getEmployee().getFirstName()!= null)
			  empName=user.getEmployee().getFirstName();
		  if(user.getEmployee().getMiddleName()!= null)
			  empName=empName+" "+user.getEmployee().getMiddleName();
		  if(user.getEmployee().getLastName()!= null)
			  empName=empName+" "+user.getEmployee().getLastName();
	  %> 
<label class="value"> <%=empName %></label> 
<%}else{ %> 
<label	class="value">-</label> <%} %> 
<label>Email Add</label> 
<%if(user.getEmailAddress() != null){ %>
<label class="value"> 
<%=user.getEmailAddress() %> </label> 
<%}else{ %> 
<label	class="value">-</label> 
<%} %>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<h4>Remove Rights</h4>
<div class="Clear"></div>
<div class="Block">
<label>Hospital Name</label> 
<select	name="hospitalId" id="hospitalId" class="large2">
	<option value="0">Select</option>

	<%
				
				Iterator itr=hospitalList.iterator();
				
				while(itr.hasNext()){
			    	MasHospital masHospital= (MasHospital) itr.next();
			    	String hospitalName=masHospital.getHospitalName();
			    	int hospitalId=masHospital.getId();
					if(hospitalId==hospitalIdFromSession){
					
			%>
	<option value="<%=hospitalId%>" selected><%=hospitalName%></option>


	<% 	}		
				}
			%>
</select>
<label>Form Name</label> 
<select name="formName" id="formName"	class="large2"	onchange="submitProtoAjaxWithDivName('removeButtonRightsForm','superAdmin?method=getButtonDetailsForRemoveRights','testdiv')">
	<option value="0">Select</option>
	<%
				Iterator iter=formList.iterator();
				while(iter.hasNext()){
			    	String formName= (String) iter.next();
			%>
	<option value="<%=formName%>"><%=formName%></option>
	<% 			
				}
			%>
</select></div>
<div class="Clear"></div>
<div id="testdiv"></div>
<div class="Clear"></div>
</form>
<script type="text/javascript">
      function checkBlank(){
     	
       
			 for(var i = 0; i < document.getElementsByName('userButtonId').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('userButtonId')[i].checked == true)
              {
				
				return true;
			  }		
  		}
  		alert("Please select the Button for Removing Rights.")
		return false;
     }
     function checkAll(){

	 if(document.getElementById('chkStatus').value =="no"){
	   document.getElementById('chkStatus').value ="yes"
	   for(var i=1;i<=document.getElementById('countValForButton').value;i++){
	    document.getElementById('chk'+i).checked =true
	  }
	  }else{
		 document.getElementById('chkStatus').value ="no"
	   	for(var i=1;i<=document.getElementById('countValForButton').value;i++){
	    	document.getElementById('chk'+i).checked =false
	  	}
	  }
	}  
</script>


