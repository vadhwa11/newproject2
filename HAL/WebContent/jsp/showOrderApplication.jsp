<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascrip"	src="/hms/jsp/js/ajax.js"></script>
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
 	String message = "";
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
		
		
		
		if (map.get("message")!=null)
			message  = (String)map.get("message");

 %>
<h4><%=message%></h4>
<form name="changeOrderForm" method="post">
<div class="titleBg">
<h2>Change Order For Application</h2>
</div>
<div class="Clear"></div>
<h4>Change Order</h4>
<div class="Clear"></div>

<label>Hospital Name</label> 
<select	name="hospitalId" id="hospitalId"	onchange="submitProtoAjaxWithDivName('changeOrderForm','superAdmin?method=populateEmpGroup','testdiv1')" class="large2">
	<option value="0">Select</option>
	<%Iterator itr=hospitalList.iterator();
				while(itr.hasNext()){
			    	MasHospital masHospital= (MasHospital) itr.next();
			    	String hospitalName=masHospital.getHospitalName();
			    	int hospitalId=masHospital.getId();
					if(hospitalId==hospitalIdFromSession){%>
	<option value="<%=hospitalId%>" selected><%=hospitalName%></option>
	<%}		
				}%>
</select>
<div id="testdiv1">
<label>Application Group </label> 
<select	name="groupId" id="groupId" class="large2">
	<option value="0">Select</option>
</select></div>

<div class="Clear"></div>
</form>
<div class="Clear paddingTop15"></div>
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
	
	function checkHospitalId(){
		
		   var hospitalId=document.getElementById('hospitalId').value;
		   if(hospitalId=="0"){
		     alert("Please select the hospital.")
		   return false;
		   }else{
		     return true;
		   }
		
		}
	function checkBlank(){
     	
        var groupId=document.getElementById('groupId').value;
        var empGroup=document.getElementById('empGroup').value;
       if(groupId=="0"){
       
          alert("Please Select the Appplication Group.")
          return false;
       }
       
       return true;
     }
     function checkAssignModule(){
      for(var i = 0; i < document.getElementsByName('userId').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('userId')[i].checked == true)
              {
				
				return true;
			  }		
  		}
  		alert("Please select Atleast One User")
		return false;
  
  }
 
	function checkRadio(){
			
			 for(var i = 0; i < document.getElementsByName('appId').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('appId')[i].checked == true)
              {
				document.getElementById('appId').value=document.getElementsByName('appId')[i].value;
				document.getElementById('prevAppId').value = document.getElementsByName('appId')[i-1].value;
				alert("appId----"+document.getElementById('appId').value+"----prebApp Id==="+document.getElementById('prevAppId').value)
				
				return true;
			  }		
  		}
  		alert("Please select the Application.")
		return false;
		
	}
	
 	function swapApplication(){
			
			 for(var i = 0; i < document.getElementsByName('appIdToSwap').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('appId')[i].checked == true)
              {
				var temp = document.getElementsByName('appIdToSwap')[i].value;
				document.getElementsByName('appIdToSwap')[i].value = document.getElementsByName('appIdToSwap')[i-1].value;
				document.getElementsByName('appIdToSwap')[i-1].value = temp;
				
				var temp = document.getElementsByName('appName')[i].innerHTML;
				document.getElementsByName('appName')[i].innerHTML = document.getElementsByName('appName')[i-1].innerHTML;
				document.getElementsByName('appName')[i-1].innerHTML = temp;
				
				document.getElementsByName('appId')[i-1].checked = true;
				return true;
			  }		
  		}
  		alert("Please select the Application.")
		return false;
		
	}
	function swapSubApplication(){
		for(var i = 0; i < document.getElementsByName('subAppIdToSwap').length; i++){
			if(document.getElementsByName('subAppId')[i].checked == true) {
				var temp = document.getElementsByName('subAppIdToSwap')[i].value;
				document.getElementsByName('subAppIdToSwap')[i].value = document.getElementsByName('subAppIdToSwap')[i-1].value;
				document.getElementsByName('subAppIdToSwap')[i-1].value = temp;
				
				var temp = document.getElementsByName('subAppName')[i].innerHTML;
				document.getElementsByName('subAppName')[i].innerHTML = document.getElementsByName('subAppName')[i-1].innerHTML;
				document.getElementsByName('subAppName')[i-1].innerHTML = temp;
				
				document.getElementsByName('subAppId')[i-1].checked = true;
				return true;
			  }		
  		}
  		alert("Please select the Application.")
		return false;
		
	}
	function subMenuButtonAction(indexMenu){
		
		var subParentId = document.getElementsByName('appIdToSwap')[indexMenu-1].value;
		var subGroupId = document.getElementById('subGroupId').value;
		submitProtoAjaxWithDivName('changeOrderForm','superAdmin?method=showSubMenuForOrdering&subParentAppId='+subParentId+'&groupIdSub='+subGroupId,'subApplicationDiv')
	}
</script>
<script language="Javascript" type="text/javascript">
            	
            		submitProtoAjaxWithDivName('changeOrderForm','superAdmin?method=populateEmpGroup','testdiv1');
            	</script>

