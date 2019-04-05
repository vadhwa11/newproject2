<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasTemplate"%>
<%@page import="jkt.hms.masters.business.EmpGroups"%>

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
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	Map<String,Object> map = new HashMap<String,Object>();
 	String userName = "";
 	String deptName = "";
 	String message  = "";
 	int hospitalId=0;
 	if(request.getAttribute("map") != null)
	{
		map = (Map<String,Object>) request.getAttribute("map");
	}
	List<MasTemplate> templateList = new ArrayList<MasTemplate>();
	if(map.get("templateList") != null){
		templateList = (List<MasTemplate>)map.get("templateList");
	}
	List empGroupList=new ArrayList();
	if (map.get("empGroupList")!=null)
		empGroupList  = (List)map.get("empGroupList");
	
 	if (request.getAttribute("map") != null) 
	{
		map = (Map<String,Object>) request.getAttribute("map");
		
		if (map.get("userName")!=null)
		userName = (String)map.get("userName");
		
		if (map.get("deptName")!=null)
		deptName = (String)map.get("deptName");
		
		
		if (map.get("hospitalId") != null){
			hospitalId =(Integer)map.get("hospitalId");
		} 
		
		if (map.get("message")!=null)
			message  = (String)map.get("message");
    }
%>
<script>
function checkAll(){
 if(document.getElementById("chkStatus").value =="no"){
   document.getElementById("chkStatus").value ="yes"
   for(var i=1;i<=document.getElementById("countVal").value;i++){
    document.getElementById("apChk"+i).checked =true
  }
  }else{
 document.getElementById("chkStatus").value ="no"
   for(var i=1;i<=document.getElementById("countVal").value;i++){
    document.getElementById("apChk"+i).checked =false
  }
  }
}
  </script>
<script>
  function checkBlankTemplate(){
     	
        var template=document.getElementById('template').value;
       if(template==''){
       
          alert("Please Select the Template Name.")
          return false;
       }
     
       return true;
     }
     
     function checkBlankEmpGroup(){
     	
        var empGroup=document.getElementById('empGroup').value;
       if(empGroup==''){
       
          alert("Please Select the Emp Group Name.")
          return false;
       }
     
       return true;
     }
 function checkAssignModule(){
      var user = false;
      var app = false;
      var errmsg = "";
  		for(var i = 0; i < document.getElementsByName('userId').length; i++){
			  if(document.getElementsByName('userId')[i].checked == true)
              {
				app = true;
			  }		
  		}
  		if(!app){
  		errmsg = errmsg + "\n Please select Atleast One User";
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

<form name="assignApplicationForm" method="post">

<h4><%=message %></h4>

<div class="titleBg">
<h2>Assign Template to User</h2>
</div>
<div class="clear"></div>
<div class="Block">
<input type="hidden" name="<%=hospitalId %>" id="<%=hospitalId %>"	value="<%=hospitalId %>" />
<label>Template Name </label>
<select	name="<%=TEMPLATE %>" id="<%=TEMPLATE %>" value=""	validate="Template Name ,string,yes" tabindex="1" />
<option value="">Select Template Name</option>
	<%
		String templateName="";
				Iterator<MasTemplate> iter1=templateList.iterator();
				while(iter1.hasNext()){
	    	MasTemplate masTemplate = (MasTemplate) iter1.next();
			int templateId = masTemplate.getId();
			templateName = masTemplate.getTemplateName();
			%>
<option value="<%=templateId%>"><%=masTemplate.getTemplateName()%></option>

	<% 			
			}
		%>
</select>
<label class="auto">Employee Group Name  </label>
<select name="empGroup" id="empGroup" validate="Employee Group Name,string,yes"	onchange="if(checkBlankTemplate()){submitProtoAjaxWithDivName('assignApplicationForm','user?method=getUsersList','testDiv');}"	class="large">
<option value="">Select</option>
	<%
			String empGroupName ="";
				Iterator itr1 = empGroupList.iterator();
				while(itr1.hasNext()){
			    	EmpGroups empGroups =(EmpGroups)itr1.next();
			    	int empGroupId = empGroups.getId();
			    	empGroupName	= empGroups.getEmpGroupName();
			%>
<option value=<%=empGroupId%>><%=empGroupName%></option>

	<% 			
				}
			%>

</select> 
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="View/ Delete" value="View/ Delete"	class="buttonBig" accesskey="b"	onclick="if(checkBlankTemplate() && checkBlankEmpGroup()){submitFormForButton('assignApplicationForm','user?method=viewAssignTemplateToUser');}" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="testDiv"></div>

<div class="clear"></div>
</form>


