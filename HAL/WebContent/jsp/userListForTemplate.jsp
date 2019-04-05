
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.TemplateApplication"%>
<%@page import="jkt.hms.masters.business.UserUsergroupApplication"%>
<%@page import="jkt.hms.masters.business.UserEmpGroup"%>
<%@page import="jkt.hms.masters.business.UserTemplate"%>
<%@page import="jkt.hms.masters.business.MasTemplate"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
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
		List<Object[]> empGrpList= new ArrayList<Object[]>();
		if (map.get("empGrpList") != null)
			empGrpList =(List)map.get("empGrpList");
		
		
		List<TemplateApplication> tempAppList= new ArrayList<TemplateApplication>();
		if (map.get("tempAppList") != null)
			tempAppList =(List<TemplateApplication>)map.get("tempAppList");
		
		List<Integer> buttonTemplateList = new ArrayList<Integer>();
		if (map.get("buttonTemplateList") != null)
			buttonTemplateList =(List<Integer>)map.get("buttonTemplateList");
		
		List<UserTemplate> userTemplateList= new ArrayList<UserTemplate>();
		if (map.get("userTemplateList") != null){
			userTemplateList =(List)map.get("userTemplateList");
		}
		
		List<Object> grpAppList= new ArrayList<Object>();
		 grpAppList = (List<Object>) map.get("grpAppList");
		 
		 
		 int j=0;
		   for (int i=0;i<grpAppList.size();i++){%>
<input type="hidden" value="<%=grpAppList.get(i) %>" name="grpAppId<%=i%>" />
<% j++; }%>
<input type="hidden" name="counter" value="<%=j %>" />

<% 
		List<Object> usrGrpHospList= new ArrayList<Object>();
		usrGrpHospList = (List<Object>) map.get("usrGrpHospList");
		 int m=0;
		   for (int n=0;n<usrGrpHospList.size();n++){%>
<input type="hidden" value="<%=usrGrpHospList.get(n) %>"	name="userGrpId<%=n%>" />
<% m++; }%>
<input type="hidden" name="counter1" value="<%=m %>" />

<table cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="15">Sl No.</th>
			<th>Login Name</th>
			<th><input type="checkbox" class="checkbox"
				onclick="checkAll();" /> Select Users</th>
	</thead>
	<tbody id="searchresulttable">
		<%
	int k=0;
	if(empGrpList != null && empGrpList.size() >0  ){
	for(Object[] userEmpGroup : empGrpList){
		k++;
	%>
		<tr class="<% if(k %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=k%></td>
			<td><%=userEmpGroup[0]%></td>
			<td><input type="checkbox" id="chk<%=k%>" name="userId"
				value="<%=userEmpGroup[1]%>" class='checkbox' /></td>
		</tr>
		<%}
			}else{
			%>
		No Records Found
		<%} %>

	</tbody>
</table>

<label class="bodytextB_blue" style="display: none;">Application Name  </label> <select name="<%=APPLICATION_ID %>" class="large"
	style="display: none;">
	<option value="">Select</option>

	<%
				Iterator<TemplateApplication> iter=tempAppList.iterator();
				
				while(iter.hasNext()){
			    	TemplateApplication tempApp= (TemplateApplication) iter.next();
			    	String appId = "";
			    	String tempAppName ="";
			    	if(tempApp.getApp() != null)
					 appId=tempApp.getApp().getId();
			    	if(appId != "" && appId != null)
			    	tempAppName = tempApp.getApp().getName();
			    	
			%>
	<option value=<%=appId%>><%=tempAppName%></option>

	<%	
			}
				%>
</select>

<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="empGroupId" value="<%=empGroupId %>" />
<input type="hidden" id="countVal" value="<%=k%>" />
<input type="hidden" id="chkStatus" value="no" />
<input type="hidden" id="chkStatus" value="no" />

<input type="button" name="assignTemplate" value="Assign Template"	class="buttonBig"	onClick="if(checkAssignModule()){submitForm('assignApplicationForm','user?method=assignTemplateToUser');}" />
<input type="button" name="Back" value="Back" class="buttonBig"	accesskey="b"	onclick="submitFormForButton('assignApplicationForm','user?method=showAssignTemplateToUser')"	tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>