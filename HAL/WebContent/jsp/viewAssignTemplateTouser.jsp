
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.UserEmpGroup"%>
<%@page import="jkt.hms.masters.business.UserTemplate"%>
<%@page import="jkt.hms.masters.business.MasTemplate"%>
<%@page import="jkt.hms.masters.business.EmpGroups"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
	</script>
<script>
	function checkAll(){
	if(document.getElementById("chkStatus").value =="no"){
   document.getElementById("chkStatus").value ="yes"
   for(var i=1;i<=document.getElementById("countVal").value;i++){
    document.getElementById("chk"+i).checked =true
  }
  }else{
 document.getElementById("chkStatus").value ="no"
   for(var i=1;i<=document.getElementById("countVal").value;i++){
    document.getElementById("chk"+i).checked =false
  }
  }
 }
</script>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map<String,Object>) request.getAttribute("map");
		}
		int empGroupId=0;
		if (map.get("empGroupId") != null){
			empGroupId =(Integer)map.get("empGroupId");
		}
		int templateId=0;
		if (map.get("templateId") != null){
			templateId =(Integer)map.get("templateId");
		}
		int buttonId=0;
		if (map.get("buttonId") != null){
			buttonId =(Integer)map.get("buttonId");
		}
		List<UserEmpGroup> empGrpList= new ArrayList<UserEmpGroup>();
		if (map.get("empGrpList") != null)
			empGrpList =(List<UserEmpGroup>)map.get("empGrpList");
		
		
		List<UserTemplate> userTemplateList= new ArrayList<UserTemplate>();
		if (map.get("userTemplateList") != null){
			userTemplateList =(List)map.get("userTemplateList");
		}
		
		List<MasTemplate> templateList = new ArrayList<MasTemplate>();
		if(map.get("templateList") != null){
			templateList = (List<MasTemplate>)map.get("templateList");
		}
		List<Integer> buttonTemplateList = new ArrayList<Integer>();
		if (map.get("buttonTemplateList") != null)
			buttonTemplateList =(List<Integer>)map.get("buttonTemplateList");
		
		List<EmpGroups> empGroupList=new ArrayList<EmpGroups>();
		if (map.get("empGroupList")!=null)
			empGroupList  = (List<EmpGroups>)map.get("empGroupList");
		
		 
			List<Object> grpAppList= new ArrayList<Object>();
			 grpAppList = (List<Object>) map.get("grpAppList");
		%>

<script>
function checkUser(){

		for(var i = 0; i < document.getElementsByName('userId').length; i++){
			if(document.getElementsByName('userId')[i].checked == false)
              {
				return true;
			  }		
  		}
  		alert("Please Delete the user.")
		return false;
	}

</script>
<form name="assignApplicationForm" method="post">
<% 
		 int j=0;
		   for (int i=0;i<grpAppList.size();i++){%>
<input type="hidden"	value="<%=grpAppList.get(i)%>" name="grpAppId<%=i%>" />
<input	type="hidden" name="counter1" value="<%=i %>" />
		   <% j++; }%> 
<input	type="hidden" name="counter" value="<%=j %>" />
		   <%List<Object> usrGrpHospList= new ArrayList<Object>();
	        	usrGrpHospList = (List<Object>) map.get("usrGrpHospList");
		      int m=0;
		      for (int n=0;n<usrGrpHospList.size();n++){%>
		   <input type="hidden"	value="<%=usrGrpHospList.get(n) %>" name="userGrpId<%=n%>" />
		   <% m++; }%>
<input type="hidden" name="counter1" value="<%=m %>" />
<%
String templateName="";
int tempId=0;
if(templateList != null){
for (MasTemplate masTemplate : templateList) 
{
	tempId=masTemplate.getId();
	if(templateId == tempId){
		templateId = masTemplate.getId();
		templateName = masTemplate.getTemplateName();
	%>
<div class="Block">
	<label >Template Name </label>
	<input type="text" name="templateName" id="templateName" value="<%=templateName %>" tabindex="1" readonly="readonly">
	<input	type="hidden" name="template" id="template" value="<%=templateId %>" />
<%}}} %> <%
String empGroupName="";
int empoGrpId=0;
if(empGroupList != null){
for (EmpGroups empGroups : empGroupList) 
{
	empoGrpId=empGroups.getId();
	if(empGroupId == empoGrpId){
		empGroupId = empGroups.getId();
		empGroupName = empGroups.getEmpGroupName();
	%>
	<label>Emp Group Name  </label>
	<input type="text" name="empGroupName" id="empGroupName" value="<%=empGroupName %>" tabindex="1" readonly="readonly">
	<input	type="hidden" name="empGroup" id="empGroup" value="<%=empGroupId %>" />
<%}}} %>
</div>
<div class="clear"></div>

<table cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="15">S.No</th>
			<th>Login Name</th>
			<th><input type="checkbox" class="checkbox"
				onclick="checkAll();" /> Select Users</th>
	</thead>
	<tbody id="searchresulttable">
		<%
	int k=0;
	if(userTemplateList != null && userTemplateList.size() >0  ){
	for(UserTemplate userTemplate : userTemplateList){
		k++;
	%>
		<tr class="<% if(k %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=k%></td>
			<td><%=userTemplate.getUser().getLoginName()%></td>
			<td><input type="checkbox" id="chk<%=k%>" name="userId"
				value="<%=userTemplate.getUser().getId()%>" class='checkbox' checked /></td>
		</tr>
		<%}
			}else{
			%>
		No Records Found
		<%} %>

	</tbody>
</table>






<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="empGroupId" value="<%=empGroupId %>" />
<input type="hidden" id="countVal" value="<%=k%>" />
<input type="hidden" id="chkStatus" value="no" />
<input type="hidden" id="chkStatus" value="no" />
<input type="button" name="assignTemplate" value="Assign Template"	class="buttonBig"	onClick="if(checkUser()){submitForm('assignApplicationForm','user?method=editAssignTemplateToUser');}" />
<input type="button" name="Back" value="Back" class="buttonBig"	accesskey="b"	onclick="submitFormForButton('assignApplicationForm','user?method=showAssignTemplateToUser')"	tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
</form>
<!-- </form> -->





