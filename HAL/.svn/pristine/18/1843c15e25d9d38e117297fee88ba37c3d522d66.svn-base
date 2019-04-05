<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.masters.business.*" %>

<%@page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%

Map map = new HashMap();
List<Object> applicationListGroupWise = new ArrayList<Object>();
List<Object>masApplicationList= new ArrayList<Object>();
List<Object>userUsergroupApplicationList= new ArrayList<Object>();
List<MasApplication> applicationList = new ArrayList<MasApplication>();
if(request.getAttribute("map") != null)
{
	map = (Map) request.getAttribute("map");
}

if (map.get("applicationListGroupWise") != null)
	applicationListGroupWise =(List)map.get("applicationListGroupWise");
	    
if (map.get("masApplicationList") != null)
	masApplicationList =(List)map.get("masApplicationList");

if (map.get("userUsergroupApplicationList") != null)
	userUsergroupApplicationList =(List)map.get("userUsergroupApplicationList");

if (map.get("applicationList") != null)
	applicationList =(List)map.get("applicationList");

int groupHospitalId= 0;
int userId=0;
int hospitalId=0;
String  parentAppId="";
if (map.get("groupHospitalId") != null)
	groupHospitalId =(Integer)map.get("groupHospitalId");

if (map.get("userId") != null)
	userId =(Integer)map.get("userId");

if (map.get("hospitalId") != null)
	hospitalId =(Integer)map.get("hospitalId");

if (map.get("parentAppId") != null)
	parentAppId =(String)map.get("parentAppId");

List<Object>userList= new ArrayList<Object>();
if (map.get("userList") != null)
	userList =(List)map.get("userList");
List<Integer> maxOrderNoList = new ArrayList<Integer>();
if (map.get("maxOrderNoList") != null)
	maxOrderNoList =(List<Integer>)map.get("maxOrderNoList");


String applicationId = "";
if(applicationListGroupWise.size() > 0){
GroupApplication groupApplicationObj=(GroupApplication)applicationListGroupWise.get(0);
applicationId=groupApplicationObj.getApp().getId();
}
 if(userList != null)
   {
	   String username= "";
	   String loginName= "";
	   String serviceNo=null;
	   Users userObj=(Users)userList.get(0);
	   //String employeeCode=userObj.getEmployee().getEmployeeCode();
	   String employeeName=userObj.getEmployee().getFirstName();
	   if(userObj.getEmployee().getMiddleName()!=null){
		   employeeName=employeeName+" "+userObj.getEmployee().getMiddleName();
	   }
		if(userObj.getEmployee().getLastName()!=null){
			employeeName=employeeName+" "+userObj.getEmployee().getLastName();
	   }
	   String email=userObj.getEmailAddress();
	  
    	 if(userObj.getUserName() != null)
		   {
    		 username=userObj.getUserName();
		   }
		
		if(userObj.getLoginName() != null)
		{
			loginName=userObj.getLoginName();	
		}
%>
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

<div class="titleBg"><h2>User Application Management</h2></div>  
<div class="Clear"></div>
	<form name="groupApplication" method="post" action="">	
	
<h4>User Details</h4>
<div class="Clear"></div>

<div class="Block">
<div class="Clear"></div> 		  
		  
		<label>User Name</label>
	<label class="value"> <%= username %></label>
   
   <label>Login Name</label>	   
<label class="value"> <%=loginName %></label>	   
<label >Name</label>
  <%if(userObj.getEmployee() != null){ %>
<label class="value"><%=employeeName %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>
<%--
<label>Email Add.</label>
<%if(userObj.getEmailAddress() != null){ %>
<label class="value"> <%=email %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>

<div class="Clear"></div>
 --%>
<%
}
%>
<input type="hidden" value="<%=parentAppId %>" name="parentAppId" id="parentAppId"/>
		  </div>
<%
if(maxOrderNoList.size() > 0){
%>
<h4>Last Added Order No. : <%=maxOrderNoList.get(0) %></h4>
<%} %>
<div class="Clear"></div>
<div class="paddingTop15"></div>
	<div class="floatRight"></div>
	<div class="Clear"></div>
	<div class="tableHholderCmnLarge2">
	<table width="575" align="left" cellpadding="0" cellspacing="0">
		<thead>
		  <tr>
		  	<th width="15">Sl.No</th>
		  	<%--<th>Application Id</th> --%>
<th>Application</th>			
<th><input type="checkbox"   class="checkbox" onclick="checkAll();"/> Assign</th>
	
</tr>
</thead>
<tbody id="searchresulttable">
<%					
      		
      		Iterator iterator = applicationListGroupWise.iterator();
      		
      		GroupApplication groupApplication = null;
      		int i=0;
		while (iterator.hasNext()) 
		{
			
			groupApplication = (GroupApplication) iterator.next();
String masterAppId = groupApplication.getApp().getId();
if(!groupApplication.getApp().getId().equals("0"))
{
	i++;
    %>
<tr class="<% if(i %2 == 0){%>odd<%}else{%>even<%}%>">
<%--Added By Dipali For updating order no (2-may-2013) --%>
<%---<td><%=i%></td> --%>
<td><input type="text" name="order_no" value="<%=groupApplication !=null && groupApplication.getApp().getOrderNo()!=null?groupApplication.getApp().getOrderNo():"" %>" id="order_no<%=i%>" 
onblur="checkOrderNo(this.value,<%=i %>);checkDataOrderNo(this.value,<%=i %>);" validate="Order No.,int,yes" tabindex="3"/>
<input type="hidden" name="app_id" value="<%=groupApplication !=null && groupApplication.getApp().getId()!=null?groupApplication.getApp().getId():"" %>" id="app_id<%=i%>" /></td>
<%--<td><%=groupApplication.getApp().getId()%></td> --%>
<td>
<%
String parentId=null;
 	if(groupApplication.getApp().getUrl().equals("#"))
 	{
 		String appName=groupApplication.getApp().getName();
 		parentId=groupApplication.getApp().getParentId();
 		if(!parentId.equals("0")){
 			
 		
%>

       <em><b><%=groupApplication.getApp().getApplication().getName()%></b></em>  &nbsp;>>&nbsp;<%=groupApplication.getApp().getName()%>                  </td>
      <%
      	String bool="false";
      	for(Iterator itr=userUsergroupApplicationList.iterator();itr.hasNext();){
             
      	UserUsergroupApplication userUsergroupApplication=(UserUsergroupApplication)itr.next();
      	int groupAppId=userUsergroupApplication.getGroupApp().getId();
      	int hospitalIdFromTable=userUsergroupApplication.getGroupHospital().getHospital().getId();
      	if(hospitalIdFromTable==hospitalId){
      	if(groupAppId==groupApplication.getId()){
      	  bool="true";	
      	
      %>	
            
<td ><input type="checkbox" id="chk<%=i%>" name="groupApplicationId" value="<%=groupApplication.getId()%>" class="none" checked="true"/></td>
<td>
             
          <%
    	break;
    	}}}if(bool.equals("false")) {%>
    <td><input type="checkbox" id="chk<%=i%>" name="groupApplicationId" value="<%=groupApplication.getId()%>" class="none" /></td>
  
  <%
  	}}
    	else
    	{
    		
  %>
    	<b><i><%=groupApplication.getApp().getName()%></i></b>
    	</td>	
    	<%
     	String bool="false";
   	for(Iterator itr=userUsergroupApplicationList.iterator();itr.hasNext();){
             
   	UserUsergroupApplication userUsergroupApplication=(UserUsergroupApplication)itr.next();
   	int groupAppId=userUsergroupApplication.getGroupApp().getId();
   	int hospitalIdFromTable=userUsergroupApplication.getGroupHospital().getHospital().getId();
      	if(hospitalIdFromTable==hospitalId){
   	if(groupAppId==groupApplication.getId()){
   	  bool="true";	
    	%>
<td ><input type="checkbox" id="chk<%=i%>" name="groupApplicationId" value="<%=groupApplication.getId()%>" class="none" checked="true" /></td>
    	<%
    	    break;
    		}}}if(bool.equals("false")) {%>
    	 <td ><input type="checkbox" id="chk<%=i%>" name="groupApplicationId" value="<%=groupApplication.getId()%>" class="none" /></td>
  <%	
             	}}}
else{
	 String parentName=groupApplication.getApp().getApplication().getName();
	 String parentid=groupApplication.getApp().getApplication().getId();
	// System.out.println("paerent name where is some url----"+parentName+"---parent id-----"+parentid);
	
		for(Iterator itr=masApplicationList.iterator();itr.hasNext();)
		{
			MasApplication masApplication=(MasApplication)itr.next();
			String appId=masApplication.getId();
			String appName=masApplication.getName();
			String pId=masApplication.getParentId();
			if(appId.equals(parentid)){
				if(!pId.equals("0")){
					for(Iterator itr1=masApplicationList.iterator();itr1.hasNext();)
					{
						MasApplication masAppObj=(MasApplication)itr1.next();
			 				String appname=masAppObj.getName();
			 				String appid=masAppObj.getId();
			 				if(appid.equals(pId)){
					
				
				
			
			
           %>
      <b><i><%=appname%></i></b>&nbsp;>>&nbsp;<b><i><%=groupApplication.getApp().getApplication().getName()%></i></b>&nbsp;>>&nbsp;<%=groupApplication.getApp().getName()%>
       </td>
       <%
     	String bool="false";
   	for(Iterator iter=userUsergroupApplicationList.iterator();iter.hasNext();){
             
   	UserUsergroupApplication userUsergroupApplication=(UserUsergroupApplication)iter.next();
   	int groupAppId=userUsergroupApplication.getGroupApp().getId();
   	int hospitalIdFromTable=userUsergroupApplication.getGroupHospital().getHospital().getId();
      	if(hospitalIdFromTable==hospitalId){
   	if(groupAppId==groupApplication.getId()){
   	  bool="true";	
    	%>	
<td ><input type="checkbox" id="chk<%=i%>" name="groupApplicationId" value="<%=groupApplication.getId()%>" class="none" checked="true"/></td>
<%
     		 break;
      	}}}if(bool.equals("false")) {%>
        <td ><input type="checkbox" id="chk<%=i%>" name="groupApplicationId" value="<%=groupApplication.getId()%>" class="none" /></td>
  <%	
             }}}
}else{
%>
<b><i><%=groupApplication.getApp().getApplication().getName()%></i></b> &nbsp;>>&nbsp;<%=groupApplication.getApp().getName()%>
</td>
<%
     	String bool="false";
   	for(Iterator iter=userUsergroupApplicationList.iterator();iter.hasNext();){
             
   	UserUsergroupApplication userUsergroupApplication=(UserUsergroupApplication)iter.next();
   	int groupAppId=userUsergroupApplication.getGroupApp().getId();
   	int hospitalIdFromTable=userUsergroupApplication.getGroupHospital().getHospital().getId();
      	if(hospitalIdFromTable==hospitalId){
   	if(groupAppId==groupApplication.getId()){
   	  bool="true";	
    	%>		
<td ><input type="checkbox" id="chk<%=i%>" name="groupApplicationId" value="<%=groupApplication.getId()%>" class="none" checked="true" /></td>
<%
break;
          	}}}if(bool.equals("false")) {%>
<td ><input type="checkbox" id="chk<%=i%>" name="groupApplicationId" value="<%=groupApplication.getId()%>" class="none" /></td>
<%		  
} }
}
}}
 %>
</tr>

<%
	}
}
%>
  </tbody>
</table>
<input type="hidden" id="countVal" value="<%=i%>" />
<input type="hidden" id="chkStatus" value="no" />
<input type="hidden" name="applicationId" value="<%=applicationId %>" />
<input type="hidden" name="userId" value="<%=userId %>" />
<input name="userIdNew" id="userIdNew" type="hidden" value="<%=userId %>" />
<input type="hidden" name="groupHospitalId" value="<%=groupHospitalId %>"/>
<input type="hidden" name="hospitalId" value="<%=hospitalId %>"/>
  </div>
	
 </form>
<div class="Clear"></div>
 <div class="division"></div>
  
 
 <div class="Clear"></div>
 <input type="button" name="submit" value="Submit" class="button" onClick="submitForm('groupApplication','/hms/hms/superAdmin?method=submitUserWiseApplication');" />
<input type="button" name="Back" value="Back" class="button" onClick="submitForm('groupApplication','/hms/hms/superAdmin?method=showUserManagementJsp');" />
  
 <div class="Clear"></div>
<div class="division"></div>
  
		 <script type="text/javascript">
function checkDataOrderNo(obj,rowVal){	
<%		
if(applicationList != null && applicationList.size() > 0){
		for (MasApplication maasapApplication : applicationList) {%>
var invObj =<%= maasapApplication.getOrderNo()%>
if(invObj == obj){
	alert("Order No. already exist.");
	document.getElementById('order_no'+rowVal).value = '';
	}
	<%}}%>
					}
function checkOrderNo(val,inc){	
for(i=1;i<=inc;i++){
          
	if(inc != i){
			if(document.getElementById('order_no'+i) && document.getElementById('order_no'+i).value==val) {
			alert("Order No. already selected...!")
			document.getElementById('order_no'+inc).value=""
			var e=eval(document.getElementById('order_no'+inc));
			e.focus();
			return false;
		}
	}
}
}
	</script>

