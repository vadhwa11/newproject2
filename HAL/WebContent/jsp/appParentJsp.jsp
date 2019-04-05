<%@page import="jkt.hms.masters.business.MasApplicationgroup"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.GroupApplication"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>


<%
	String date = "";
	String time = "";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	Map<String,Object> map = new HashMap<String,Object>();
 	List<MasApplicationgroup> groupAppList = new ArrayList<MasApplicationgroup>();
 	List<GroupApplication> parentList = new ArrayList<GroupApplication>();
 	
 	if(request.getAttribute("map") != null){
		map = (Map<String,Object>) request.getAttribute("map");
	}
 	
 	if(map.get("parentList") != null)
 	{
 		parentList = (List<GroupApplication>)map.get("parentList");
	}
	if(map.get("groupAppList") != null)
	{
		groupAppList = (List<MasApplicationgroup>)map.get("groupAppList");
	}
	
	if (request.getAttribute("map") != null) 
	{
		map = (Map<String,Object>) request.getAttribute("map");
	}
%>
<%
String message ="";
if (map.get("message") != null) {
             message = (String) map.get("message");
      }
if(!message.equalsIgnoreCase("")){
%>
<h4><%=message %></h4>
<%} %>
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

function checkBlankAppGroup(){
     	var appGroup = document.getElementById('appGroupId').value;
       		if(appGroup == '')
       		{
         		 alert("Please Select the Application Group Name.")
          		 	return false;
      		}
     				return true;
     }
     
     
     function checkBlankParentApplication(){
      var user = false;
      var app = false;
      var errmsg = "";
  		for(var i = 0; i < document.getElementsByName('buttonName').length; i++){
			  if(document.getElementsByName('buttonName')[i].checked == true)
              {
				app = true;
			  }		
  		}
  		if(!app){
  		errmsg = errmsg + "\n Please select Atleast One Parent Application Name";
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
<div class="titleBg">
<h2>Assign Login Group</h2>
</div>

<h4>Assign Login Group</h4>
<div class="clear"></div>
<div class="Block">
<label class="noWidth" > &nbsp;Login Group Name </label>
<select name="appGroupId" id="appGroupId" class="large" onchange="submitProtoAjaxWithDivName('assignApplicationForm','user?method=showResponseAsssignParentJsp','AssignAppDiv')">
<option value="">Select Login Group Name</option>
	<%
				Iterator iter = groupAppList.iterator();
				while(iter.hasNext()){
	    	MasApplicationgroup masAppGrp = (MasApplicationgroup) iter.next();
			int appGroupId = masAppGrp.getId();
			%>
	<option value="<%=appGroupId%>"><%=masAppGrp.getApplicationgroupName()%></option>
	<% 			
				}
			%>
</select> 
</div>
<div class="clear"></div>
<div class="clear"></div>
<div id="AssignAppDiv">
<div class="clear"></div>
<div class="tableHholderCmnLarge2">
<div class="clear"></div>
<table cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="15">S.No</th>
			<th>Parent Application Name</th>
			<th><input type="checkbox" class="checkbox" onclick="checkSelect();"/>Select All</th>
		</tr>
	</thead>
	<tbody id="searchresulttable">
		<%	
           		Iterator iterator = parentList.iterator();
		GroupApplication masApplication = null;
           		int i=0;
   				while (iterator.hasNext()) 
   				{
   			masApplication = (GroupApplication) iterator.next();
					i++;
	        %>
		<tr class="<% if(i %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=i%></td>
			<td><%=masApplication.getApp().getName()%>
			<input type="hidden" name ="appId" id="appId<%=i%>" value="<%=masApplication.getApp().getId() %>" />
			</td>
			<td><input type="checkbox" id="chkButton<%=i %>" value="<%=masApplication.getApp().getId()%>" name="buttonName" />
		</tr>
		<%}%>
	</tbody>
</table>
</div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="removeRights" value="Save" class="button"	onclick="if(checkBlankAppGroup()&& checkBlankParentApplication()){submitForm('assignApplicationForm','user?method=submitParentAndGroup');}" />
 <input type="hidden" id="countVal1" value="" />
<input type="hidden" id="chkStatus1" value="no" />
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>