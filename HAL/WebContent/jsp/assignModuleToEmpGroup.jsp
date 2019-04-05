<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.*"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>



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
		
		if (map.get("hospitalId")!=null)
			hospitalIdFromSession = (Integer)map.get("hospitalId");
		
		List<MasHospital> hospitalList=new ArrayList<MasHospital>();
		if (map.get("hospitalList")!=null)
			hospitalList  = (List<MasHospital>)map.get("hospitalList");
			
		

%>
<form name="assignModuleForm" method="post">

<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %> <h4><span><%=message %></span></h4> <% 
	  }

%>

<div class="titleBg">
<h2>Assign Module To Employee Group</h2>
</div>
<div class="clear"></div>
<h4>Assign Module</h4>
<div class="clear"></div>
<div class="Block">
<label>Hospital Name</label> 
<select name="hospitalId" id="hospitalId" onchange="submitProtoAjaxWithDivName('assignModuleForm','superAdmin?method=populateEmpGroupAndAppGroupJsp','testdiv1')" class="large">
<option value="0">Select</option>

	<%
				
				Iterator itr=hospitalList.iterator();
				
				while(itr.hasNext()){
			    	MasHospital masHospital= (MasHospital) itr.next();
			    	String hospitalName=masHospital.getHospitalName();
			    	int hospitalId=masHospital.getId();
					
					
			%>
<option value="<%=hospitalId%>" selected><%=hospitalName%></option>


	<% 		
				}
			%>
</select>
<div class="clear"></div>
<label>Application Group</label> 
<select	name="groupId" id="groupId" class="large">
<option value="0">Select</option>
</select> 
<div class="clear"></div>
<label>Employee Group  </label> 
<select name="empGroup" id="empGroup" class="large">
<option value="0">Select</option>
</select>
</div>
<div class="clear"></div>
<div class="clear"></div>

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
	 function appCheckAll(){
		
	 if(document.getElementById('apChkStatus').value =="no"){
	   document.getElementById('apChkStatus').value ="yes"
	   for(var i=1;i<=document.getElementById('APCountVal').value;i++){
	    document.getElementById('apChk'+i).checked =true
	  }
	  }else{
		 document.getElementById('apChkStatus').value ="no"
	   	for(var i=1;i<=document.getElementById('APCountVal').value;i++){
	    	document.getElementById('apChk'+i).checked =false
	  	}
	  }
	} 
	
	function copyFromExist(){
	 for(var i=1;i<=document.getElementById('APCountVal').value;i++){
	   for(var j=1;j<=document.getElementById('userAppcnt').value;j++){
	      if(document.getElementById('apChk'+i).value == document.getElementById('userApp'+j).value){
	      document.getElementById('apChk'+i).checked = true;
	      }
	   }
	 }
	} 
	
	function checkHospitalId(){
		
		   var hospitalId=document.getElementById('hospitalId').value;
		   if(hospitalId=="0"){
		     alert("Please select the hospital.")
		   return false;
		   }else{
		     return true;
		   }
		
		}
	function checkBlank1(){
     	
        var groupId=document.getElementById('groupId').value;
        var empGroup=document.getElementById('empGroup').value;
       if(groupId=="0"){
       
          alert("Please Select the Appplication Group.")
          return false;
       }
     
       return true;
     }
     function checkAssignModule(){
      var user = false;
      var app = false;
      var errmsg = "";
      for(var i = 0; i < document.getElementsByName('userId').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('userId')[i].checked == true)
              {
				user = true;
			  }		
  		}
  		for(var i = 0; i < document.getElementsByName('appId').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('appId')[i].checked == true)
              {
				app = true;
			  }		
  		}
  		if(!user){
  		errmsg = errmsg + "\n Please select Atleast One User";
  		}
  		if(!app){
  		errmsg = errmsg + "\n Please select Atleast One Application";
  		}
  		if(errmsg != ""){
  		alert(errmsg);
  		return false;
  		}else{
  		return true;
  		}
  		
  		return false;
  
  }
</script>
<script language="Javascript" type="text/javascript">
submitProtoAjaxWithDivName('assignModuleForm','superAdmin?method=populateEmpGroupAndAppGroupJsp','testdiv1');
</script>

