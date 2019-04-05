<%@page import="jkt.hms.masters.business.MasButtonForm"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasApplication"%>
<%@page import="jkt.hms.masters.business.MasTemplate"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascrip"  src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
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
 	int template = 0;
 	if(request.getAttribute("map") != null)
	{
		map = (Map<String,Object>) request.getAttribute("map");
	}
 	List<MasApplication> moduleList = new ArrayList<MasApplication>();
	if(map.get("moduleList") != null){
		moduleList = (List<MasApplication>)map.get("moduleList");
	}
	
	List<MasTemplate> templateList = new ArrayList<MasTemplate>();
	if(map.get("templateList") != null){
		templateList = (List<MasTemplate>)map.get("templateList");
	}
	
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	if(map.get("departmentList") != null){
		departmentList = (List<MasDepartment>)map.get("departmentList");
	}
	
	List<MasButtonForm> formList = new ArrayList<MasButtonForm>();
	if(map.get("formList") != null){
		formList = (List<MasButtonForm>)map.get("formList");
	}
	
	List<Object[]> templateModuleList=new ArrayList<Object[]>();
	if(map.get("tempModuleList") != null){
		templateModuleList = (List<Object[]>)map.get("tempModuleList");
	}
	
 	if (request.getAttribute("map") != null) 
	{
		map = (Map<String,Object>) request.getAttribute("map");
		
		if (map.get("userName")!=null)
		userName = (String)map.get("userName");
		
		if (map.get("deptName")!=null)
		deptName = (String)map.get("deptName");
		
		
		if (map.get("templateId")!=null)
			template = Integer.parseInt(""+map.get("templateId"));
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

function checkDepAll(){
  
   if(document.getElementById("chkStatus").value =="no"){
   	      document.getElementById("chkStatus").value = "yes"
   	      for(var i=1;i<=document.getElementById("countVal").value;i++){
   		   	document.getElementById("depChk"+i).checked =true
          }
          
          
   }else{
   		document.getElementById("chkStatus").value = "no"	
   		  for(var i=1;i<=document.getElementById("countVal").value;i++){
   		    	document.getElementById("depChk"+i).checked =false
          }
          
   }
   
 }
  </script>
  <script>
 function checkSelect(){

 if(document.getElementById("chkStatus1").value =="no"){
   document.getElementById("chkStatus1").value ="yes"
   for(var i=1;i<=document.getElementById("countVal1").value;i++){
    document.getElementById("chkButton"+i).checked =true
  }
  }else{
 document.getElementById("chkStatus1").value ="no"
   for(var i=1;i<=document.getElementById("countVal1").value;i++){
    document.getElementById("chkButton"+i).checked =false
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
     
     function checkBlankModule(){
     	
        var parentId=document.getElementById('parentId').value;
       if(parentId==''){
       
          alert("Please Select the Module Name.")
          return false;
       }
     
       return true;
     }
     
      function checkAssignModule(){
      var user = false;
      var app = false;
      var errmsg = "";
  		for(var i = 0; i < document.getElementsByName('appId').length; i++){
			  if(document.getElementsByName('appId')[i].checked == true)
              {
				app = true;
			  }		
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
  
  
  function displayApplication(){
				
				document.getElementById('Application').style.display = 'inline';
				document.getElementById('testdiv1').style.display = 'inline';
				document.getElementById('Button-rights').style.display = 'none';
				document.getElementById('indentDiv').style.display = 'none';
				document.getElementById('departmentDiv').style.display = 'none';
				
				
				
 }
 function displayButtonRight(){
				
				document.getElementById('Button-rights').style.display = 'inline';
				document.getElementById('Application').style.display = 'none';
				document.getElementById('testdiv1').style.display = 'none';
				document.getElementById('indentDiv').style.display = 'inline';
				document.getElementById('departmentDiv').style.display = 'none';
				
 }
 function displayDepartment(){
				
				document.getElementById('departmentDiv').style.display = 'inline';
				document.getElementById('Button-rights').style.display = 'none';
				document.getElementById('Application').style.display = 'none';
				document.getElementById('testdiv1').style.display = 'none';
				document.getElementById('indentDiv').style.display = 'none';
				
 }
			
			
     
     </script>

<form name="assignApplicationForm" method="post">
<div id="contentHolder">
<% 
			if(map.get("message") != null){
		   String message = (String)map.get("message");
%>
		  <h4><%=message%></h4>
<%		   
		  }
%>
<div class="titleBg">
<h2>Template Assignment</h2>
</div>
<div class="Clear"></div>
<div class="Block">
<label>Template Name</label>
 <select name="<%=TEMPLATE %>" id="<%=TEMPLATE %>" value=""
	maxlength="" validate=""
	onchange="if(checkBlankTemplate()){submitForm('assignApplicationForm','user?method=showTemplateModulesJsp');}"
	tabindex="1" />
	<option value="">Select Template Name</option>
	<%
				Iterator iter1=templateList.iterator();
				while(iter1.hasNext()){
	    	MasTemplate masTemplate= (MasTemplate) iter1.next();
			int templateId=masTemplate.getId();
			if(template == templateId && template != 0){ 	%>
	<option value="<%=templateId%>" selected="selected"><%=masTemplate.getTemplateName()%></option>
	<% }else{ %>
	<option value="<%=masTemplate.getId()%>"><%=masTemplate.getTemplateName()%></option>
	<% }
			} %>
</select>
<input type="button" name="application"   value="Application" tabindex="1" class="buttonBig" onClick="displayApplication();" />
<!--<input type="button" name="button-right"  value="Buttons Right" tabindex="1" class="buttonBig" onClick="displayButtonRight();" />
<input type="button" name="Department"    value="Department" tabindex="1" class="buttonBig" onClick="if(checkBlankTemplate()){submitProtoAjaxWithDivName('assignApplicationForm','user?method=getDepartmentListForTemplate','departmentDiv');displayDepartment();}" />-->
<div class="Clear"></div>
<div id="Application" style="display: none;">
<label>Module Name:</label>
<select name="parentId" id="parentId" class="large2"	onchange="if(checkBlankTemplate()){submitProtoAjaxWithDivName('assignApplicationForm','user?method=getApplicationListForTemplate','testdiv1');}">
	<option value="">Select Application Name</option>
	<!-- to display application list -->
	<%
				Iterator iter=moduleList.iterator();
				while(iter.hasNext()){
	    	MasApplication masApp= (MasApplication) iter.next();
			String parentId=masApp.getId();
			%>
	<option value="<%=parentId%>"><%=masApp.getName()%></option>
	<% 			
				}
			%>
</select> 
</div>
<div class="Clear"></div>
<div id="Button-rights" style="display: none;">
<label>Button Rights For The Form:</label>
<select name="formName" id="formName" class="large2" onchange="if(checkBlankTemplate()){submitProtoAjaxforIndent('assignApplicationForm','user?method=getButtonListForForm','indentDiv');}">>
	<option value="0">Select</option>

	<%
	
	Iterator iter3=formList.iterator();
	
	while(iter3.hasNext()){
    	String formName= (String) iter3.next();
    	
			%>
	<option value="<%=formName%>"><%=formName%></option>


	<% 			
				}
			%>

</select>
</div>
<% if(template != 0){ %>
<div class="Clear"></div>
<div class="cmntable">
<table cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="15">Sl No.</th>
			<th>Assigned Modules</th>
		</tr>
	</thead>
	<tbody id="searchresulttable">
		<%	int i=0;
	   for(Object[] templateModules : templateModuleList){
		   ++i;
		   %>
		<tr class="<% if(i %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=i%></td>
			<td><%=templateModules[2]%></td>
		</tr>
		<% } %>
	</tbody>
</table>
</div>
<div class="clear"></div>
<% } %>

<div id="testdiv1"></div>
<div id ="indentDiv"></div>
<div id ="departmentDiv"></div>




</div>


</div>
<div class="Clear"></div>

</form>


