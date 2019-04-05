

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.*"%>

<%@page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%
	
		Map map = new HashMap();
		List<Object> applicationListGroupWise = new ArrayList<Object>();
		List<Object>masApplicationList= new ArrayList<Object>();
		List<UserUsergroupHospital> usersList= new ArrayList<UserUsergroupHospital>();
		List<UserEmpGroup> userEmpGroupList= new ArrayList<UserEmpGroup>();
		List<UserUsergroupApplication> userUGAppList= new ArrayList<UserUsergroupApplication>();
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("userEmpGroupList") != null)
			userEmpGroupList =(List<UserEmpGroup>)map.get("userEmpGroupList");
		
		List<MasButtonForm> buttonList= new ArrayList<MasButtonForm>();
		if (map.get("buttonList") != null){
			buttonList =(List<MasButtonForm>)map.get("buttonList");
		}
		String formName="";
		if (map.get("formName") != null)
			formName =(String)map.get("formName");
		
		System.out.println("Size of formName-----"+formName);
%>

<div class="Clear"></div>
<div class="Height10"></div>
<div style="float: left; margin-top: 15px; width: 950px;">
<div class="floatLeft">
<div class="tableHholder"
	style="width: 550px; height: 300px; float: left; overflow: auto;">
<table cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="15">S.No</th>
			<th>Button Name</th>
			<th><input type="checkbox" class="checkbox"
				onclick="checkAllForButton();" />Select Button</th>
		</tr>
	</thead>
	<tbody id="searchresulttable">
		<%	
           		Iterator iterator = buttonList.iterator();
           		MasButtonForm masButtonForm = null;
           		int i=0;
   				while (iterator.hasNext()) 
   				{
   					
   					masButtonForm = (MasButtonForm) iterator.next();
					
					
						i++;
	        %>
		<tr class="<% if(i %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=i%></td>
			<td><%=masButtonForm.getButtonName()%></td>
			<td><input type="checkbox" id="chkButton<%=i %>"
				value="<%=masButtonForm.getId()%>" name="buttonName" />
		</tr>
		<%}%>
	</tbody>
</table>
</div>
</div>

<!-- other new table -->
<div class="tableHholder"
	style="width: 380px; height: 300px; float: left; overflow: auto;">
<table cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="15">S.No</th>
			<th>Login Name</th>
			<th><input type="checkbox" class="checkbox"
				onclick="checkAll();" /> Select Users</th>
		</tr>
	</thead>
	<tbody id="searchresulttable">
		<%	
			  
			   int k=0;
				if(userEmpGroupList!= null && userEmpGroupList.size()>0){
					for(Iterator iterr=userEmpGroupList.iterator();iterr.hasNext();){
						  
						   UserEmpGroup userEmpGroup=(UserEmpGroup)iterr.next();
						
							
								k++;
								
						
			%>
		<tr class="<% if(k %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=k%></td>
			<td><%=userEmpGroup.getUser().getLoginName()%></td>
			<td><input type="checkbox" id="chk<%=k%>" name="userId"
				value="<%=userEmpGroup.getUser().getId()%>" class='checkbox' /></td>
		</tr>


		<%
				
				}}
			
           	%>
	</tbody>
</table>

</div>

<div class="Clear"></div>
<div class="Height10"></div>
<input type="hidden" id="countValForButton" value="<%=i%>" /> <input
	type="hidden" id="countVal" value="<%=k%>" /> <input type="hidden"
	id="formName" value="<%=formName%>" /> <input type="hidden"
	id="chkStatus" value="no" /> <input type="button" name="assignModule"
	value="Add Button Rights" class="buttonbig"
	onClick="if(checkBlank()){submitForm('assignButtonRightsForm','superAdmin?method=assignButtonRightsToEmpGroup','checkBlankForApplication');}" />
<input type="button" name="Back" value="Back" class="button"
	accesskey="b"
	onclick="submitFormForButton('assignButtonRightsForm','superAdmin?method=showAssignButtonRightsToEmpGroupJsp')"
	tabindex=1 />

<div class="Clear"></div>
</div>
<div class="Clear"></div>






