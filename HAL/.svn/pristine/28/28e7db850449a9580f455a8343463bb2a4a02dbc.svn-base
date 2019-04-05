<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.*"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

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
 	String userName ="";
 	String deptName = "";
 	int hospitalIdFromSession=0;
 	
 	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
	}
		if (map.get("userName")!=null)
		userName = (String)map.get("userName");
		
		if (map.get("deptName")!=null)
		deptName = (String)map.get("deptName");
		
		if(map.get("hospitalId")!=null)
			hospitalIdFromSession = (Integer)map.get("hospitalId");
		
		List<MasHospital> hospitalList=new ArrayList<MasHospital>();
		if (map.get("hospitalList")!=null)
			hospitalList  = (List<MasHospital>)map.get("hospitalList");
		
		List<EmpGroups> empGroupList=new ArrayList<EmpGroups>();
		if (map.get("empGroupList")!=null)
			empGroupList  = (List<EmpGroups>)map.get("empGroupList");
		
		List<MasButtonForm> formList=new ArrayList<MasButtonForm>();
		if (map.get("formList")!=null)
			formList  = (List<MasButtonForm>)map.get("formList");
		
		%>
<form name="assignButtonRightsForm" method="post">

<%
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %> <label class="noWidth"><span><%=message%></span></label> <%
		  }
    %>
<div class="titleBg">    
<h2>Assign Button Rights To Employee Group</h2>
</div>
<div class="clear"></div>
<h4>Assign Rights</h4>
<div class="clear"></div>
<div class="Block">
<label>Hospital Name</label> 
<select name="hospitalId" id="hospitalId" class="large2">
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

<div class="clear"></div>

<label>Form Name </label>
<select name="formName" id="formName" class="large2">
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

</select>

<div class="clear"></div>

<label>Employee Group </label> 
<select name="empGroup" id="empGroup" class="large2" onchange="if(checkHospitalId()){submitProtoAjaxWithDivName('assignButtonRightsForm','superAdmin?method=getButtonDetailsWithUsersList','testdiv1');}">
<option value="0">ALL</option>
	<%
				
				Iterator itr1=empGroupList.iterator();
				
				while(itr1.hasNext()){
			    	EmpGroups empGroups= (EmpGroups) itr1.next();
			    	String empGroupName=empGroups.getEmpGroupName();
			    	int empGroupId=empGroups.getId();
					
					
			%>
<option value="<%=empGroupId%>"><%=empGroupName%></option>


	<% 			
				}
			%>

</select>
</div>

<div class="clear"></div>

<div id="testdiv1"></div>

</form>

<script type="text/javascript">
     
     
     function checkAll(){
		
	 if(document.getElementById('chkStatus').value =="no"){
	   document.getElementById('chkStatus').value ="yes"
	   for(var i=1;i<=document.getElementById('countVal').value;i++){
	    document.getElementById('chk'+i).checked =true
	  }
	  }else{
		 document.getElementById('chkStatus').value ="no"
	   	for(var i=1;i<=document.getElementById('countVal').value;i++){
	    	document.getElementById('chk'+i).checked =false
	  	}
	  }
	}  
	
	function checkAllForButton(){
		
	 if(document.getElementById('chkStatus').value =="no"){
	   document.getElementById('chkStatus').value ="yes"
	   for(var i=1;i<=document.getElementById('countValForButton').value;i++){
	    document.getElementById('chkButton'+i).checked =true
	  }
	  }else{
		 document.getElementById('chkStatus').value ="no"
	   	for(var i=1;i<=document.getElementById('countValForButton').value;i++){
	    	document.getElementById('chkButton'+i).checked =false
	  	}
	  }
	}  
	
	function checkHospitalId(){
		
		   var hospitalId=document.getElementById('hospitalId').value;
		   if(hospitalId=="0"){
		     alert("Please select the hospital.")
		     document.assignButtonRightsForm.empGroup.options[0].selected="true";
		   return false;
		   }else{
		     return true;
		   }
		
		}
	function checkBlank(){
     	
         for(var i = 0; i < document.getElementsByName('userId').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('userId')[i].checked == true)
              {
				
				return true;
			  }		
  		}
  		alert("Please select the User To Assign Rights")
		return false;
		} 
		
		function checkBlankForApplication(){
     	
         for(var i = 0; i < document.getElementsByName('buttonName').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('buttonName')[i].checked == true)
              {
				
				return true;
			  }		
  		}
  		alert("Please select Atleast One Button to Assign Rights!! ")
		return false;
		}        
    
</script>


