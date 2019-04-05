<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

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
	int hospitalId = 0;
	Box box = HMSUtil.getBox(request);
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	Map map = new HashMap();
 	String userName ="";
 	String deptName = "";
  	
 	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
	}
		if (map.get("userName")!=null)
		userName = (String)map.get("userName");
		
		if (map.get("deptName")!=null)
		deptName = (String)map.get("deptName");
		
		if (map.get("deptList")!=null)
			deptList  = (List)map.get("deptList");
		
		
%>

<form name="assignApplicationForm" method="post">

<div class="clear"></div>
<div class="titleBg">
<h2>Assign Application To Employee Group</h2>
</div>
<div class="clear"></div>
<h4>Assign Application</h4>

<div class="clear"></div>
<div class="Block">
<label>Application Name </label>
<input type="text" class="large2" validate="Application Name,string,yes" name="applicationName" id="applicationName" onblur="if(checkBlank()){submitProtoAjaxWithDivName('assignApplicationForm','superAdmin?method=getGroupListForAssignApplication','testdiv');}" />
<div id="ac2update" style="display: none;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
	  		new Ajax.Autocompleter('applicationName','ac2update','superAdmin?method=getApplicationForAutoComplete',{parameters:'applicationName='+this.value});
</script>

<div class="clear"></div>

<div id="testdiv">
<label>Group Name</label> 
<select name="hospitalId" id="hospitalId" class="large">
<option value="0">Select</option></select>
<div class="clear"></div>
<label>Hospital Name</label> 
<select name="hospitalId" id="hospitalId" class="large">
<option value="0">Select</option></select>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>

</form>

<script type="text/javascript">
     function checkBlank(){
     	
        var applName=document.getElementById('applicationName').value;
       
        var index1 = applName.lastIndexOf("[");
	    var index2 = applName.lastIndexOf("]");
	    index1++;
	    var appId = applName.substring(index1,index2);
	    
	    if(appId =="")
        {
        return;
        }
        return true;
     }
     
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
</script>

