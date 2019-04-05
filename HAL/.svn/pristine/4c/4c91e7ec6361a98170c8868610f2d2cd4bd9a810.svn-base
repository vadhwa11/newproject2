<%--
 * Copyright 2011 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showUserAssinedTemplet.jsp  
 * Purpose of the JSP   This is for Assigned Templet To User 
 * @author  Mukesh Narayan Singh
 * Create Date: 1st Jun,2012 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>
<%@page import="java.net.URL"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>


<%@page import="jkt.hms.masters.business.UserTemplate"%><script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/jquery.min1.js" type="text/javascript"></script>
<script src="/hms/jsp/js/jquery.ba-throttle-debounce.min.js" type="text/javascript"></script>
<script src="/hms/jsp/js/jquery.stickyheader.js" type="text/javascript"></script>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	//List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
	List<Object[]> masEmployeeList = new ArrayList<Object[]>();
	List<MasTemplate> masTemplateList = new ArrayList<MasTemplate>();
	
	if(map.get("masEmployeeList")!=null){
		masEmployeeList =(List) map.get("masEmployeeList");
		
	}
	if(map.get("masTemplateList")!=null){
		masTemplateList =(List) map.get("masTemplateList");
	}
	List<MasEmpCategory> masEmpCategoryList = new ArrayList<MasEmpCategory>();
	if(map.get("masEmpCategoryList")!=null){
		masEmpCategoryList =(List) map.get("masEmpCategoryList");
	}
	//System.out.println("masEmpCategoryList.size()--->"+masEmpCategoryList.size());
	List<UserTemplate> userTemplateList = new ArrayList<UserTemplate>();
	if(map.get("userTemplateList")!=null){
		userTemplateList =(List) map.get("userTemplateList");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	
	String message="";
	if(map.get("message")!=null){
		message=(String)map.get("message");
	}
	
	List<Object[]> hospitalList = new ArrayList<Object[]>();
	hospitalList = (ArrayList)map.get("hospitalList");
	
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String superUserServiceNo = properties.getProperty("superUserServiceNo");
	
	String userName = "";
	if(session.getAttribute("userName")!=null){
		userName = (String)session.getAttribute("userName");
	}
	int hospitalId = 0;
	if(request.getParameter("hospitalId")!=null){
		hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
	}
	else
	{
		if(session.getAttribute("hospitalId") != null)
		{
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
	
	}
	%>


<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>


<%@page import="jkt.hms.masters.business.MasTemplate"%>
<form name="search" id="search" method="post" action="">
<%
if(!message.equalsIgnoreCase("")){
%>
<h4><%=message %></h4>
<%} %>

<div class="titleBg">
<h2>User Rights</h2>
</div>
<div id="searcharea">
	
		<div class="Block">
			<label>Employee Id/PB NO.</label> <input type="radio"
				class="radioAuto" name="<%=SELECTED_RADIO  %>" value="1"
				checked="checked" /> <label>First Name</label> <input type="radio"
				class="radioAuto" name="<%=SELECTED_RADIO %>" value="2" /> <input type="hidden" class="radioAuto"
				name="<%=SELECTED_RADIO %>" value="3" /> <input type="text"
				id="searchField" name="<%= SEARCH_FIELD%>" value=""
				validate="Employee Code,string,no" MAXLENGTH="8"
				onkeypress="return submitenter(this,event,'user?method=showUserAssignedTemplet')" />
			<input type="button"  value="Search" class="button"
				onclick="submitForm('search','user?method=showUserAssignedTemplet','checkSearch')"
				tabindex=1 />
			
		</div>
	
	<div class="Clear"></div>
</div>
</form>
<form name="showUserAssinedTemplet" method="post">
<%if(masEmployeeList.size()>0){ %>
<div class="Block">
<div class="floatRight">
<input type="button" name="assignTemplate" value="Assign Rights"	class="buttonBig"	onClick="submitForm('showUserAssinedTemplet','user?method=saveUserAssignedTemplet');" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<%
	if(userName.equals(superUserServiceNo) || userName.equals("jktuser")){
%>
<label><span>*</span> Hospital Name </label> 
<select name="<%=HOSPITAL_ID %>" validate="Hospital Name,string,yes" tabindex=1	onchange="callAgain(this.value);">
	<option value="0">Select</option>
	<%
          		if(hospitalList != null){ 	
          			for (Object[] obj : hospitalList) {
          %>
	<option value="<%=obj[0]%>" <%if(String.valueOf(hospitalId).equals(obj[0].toString())){%>selected<%} %>><%=obj[1] %></option>
	<%		
         			}
         		 } 
         %>
</select>

<%} %>

<div class="Clear"></div>
<div class="paddingTop5"></div>
</div>
<%} %>
<div class="Clear"></div>
<%if(masEmployeeList.size()>0){ %>
<div id="divEmployee">
<div class="Clear"></div>
<div class="tableForUserRight">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
<thead>
	<tr>
	<%
	
	if(masTemplateList.size()>0){
		
		%>
		<th>Name</th>
		<%
		for(MasTemplate masTemplate :masTemplateList){
			
			if(masTemplate.getTemplateName().equalsIgnoreCase("admin"))
			{
				if(userName.equals(superUserServiceNo) || userName.equals("jktuser"))
				{
					%>
					
					<th><%=masTemplate.getTemplateName()%></th>
					<%
				}			
			
			}
			else
			{
				%>
				
				<th><%=masTemplate.getTemplateName()%></th>
				<%
			}		
	
	}
	}
	
	%>
	</tr>
	</thead>
	<tbody>
	<%
	int counter=0;
	int chgCnt = 0;
	
		
			for (Iterator iterator = masEmployeeList.iterator(); iterator.hasNext();) {
				Object[] objects = (Object[]) iterator.next();
				MasEmployee masEmployee=new MasEmployee();
				Users user=new Users();
				masEmployee=(MasEmployee)objects[0];
				user=(Users)objects[1];
			++counter;
			String employeeName="";
			
			if(masEmployee.getRank()!=null){
				employeeName=masEmployee.getRank().getRankName();
			}
			employeeName=employeeName+" "+masEmployee.getFirstName();
			if(masEmployee.getMiddleName()!=null){
				employeeName=employeeName+" "+masEmployee.getMiddleName();
			}
			if(masEmployee.getLastName()!=null){
				employeeName=employeeName+" "+masEmployee.getLastName();
			}
			String toolTip="";
			toolTip=employeeName;
	%>
		<tr>
			<th>&nbsp;&nbsp;<%=employeeName %>
			<input type="hidden" name="empId<%=counter%>" id="empId<%=counter%>" value="<%=masEmployee.getId()%>" />
			<input type="hidden" name="userId<%=counter%>" id="userId<%=counter%>" value="<%=user.getId()%>" />
			
			</th>
		<%
		int templetCnt=0;
		if(masTemplateList.size()>0){
			for(MasTemplate masTemplate :masTemplateList)
			{
				
				
				 if(masTemplate.getTemplateName().equalsIgnoreCase("admin"))
				{
					if(!userName.equals(superUserServiceNo) && !userName.equals("jktuser"))
					{
						continue;
					}
					
					
				
				} 
			
				
			
				++templetCnt;
				boolean assignedTemplate=false;
				String assignedTemplateName="";
				assignedTemplateName=masTemplate.getTemplateName();
				int preTempletId=0;
				if(userTemplateList.size()>0){
					int templateIdMain=masTemplate.getId();
					
					for(UserTemplate userTemplate:userTemplateList){
						int templateIdTemp=0;
						if(userTemplate.getTemplate().getTemplate()!=null){
							templateIdTemp=userTemplate.getTemplate().getTemplate().getId();
						}else{
							templateIdTemp=userTemplate.getTemplate().getId();
						}
						if(userTemplate.getUser().getId().equals(user.getId()) && templateIdTemp==templateIdMain){
							preTempletId=userTemplate.getTemplate().getId();
							assignedTemplate=true;
							break;
						}
					}
				}
				assignedTemplateName=toolTip+" # "+assignedTemplateName+" ";
		%>
		<td align="center" title="<%=assignedTemplateName%>">
		<%if(assignedTemplate){ %>
		
		<input type="checkbox" checked="checked" name="templetId<%=templetCnt%>" id="templetId<%=templetCnt%><%=counter%>" value="<%=masTemplate.getId()%>"  onclick="setHiddenTempId(this,<%=templetCnt%><%=counter%>,'<%=masTemplate.getTemplateName() %>',<%=chgCnt %>)"/>
		<input type="hidden" name="templetIdHidden<%=counter%>" id="<%=masTemplate.getTemplateName() %><%=templetCnt%><%=counter%>" value="<%=masTemplate.getId()%>" />
		<%}else{ %>		
		<input type="checkbox"  name="templetId<%=templetCnt%>" id="templetId<%=templetCnt%><%=counter%>" value="<%=masTemplate.getId()%>" onclick="setHiddenTempId(this,<%=templetCnt%><%=counter%>,'<%=masTemplate.getTemplateName() %>',<%=chgCnt %>)" />
			<input type="hidden" name="templetIdHidden<%=counter%>" id="<%=masTemplate.getTemplateName() %><%=templetCnt%><%=counter%>" value="0" />
	<%} %>
	 	<input type="hidden" name="preTempletId<%=counter%>" id="preTempletId<%=templetCnt%><%=counter%>" value="<%=preTempletId%>" />
		<input type="hidden" name="changeFlag<%=counter%>" id="changeFlag<%=chgCnt %><%=templetCnt%><%=counter%>" value="no" />
	
		</td>
		<%
		}
		}
		%>			
		</tr>
	<%		chgCnt++;
		}
	
	%>
</tbody>	
</table>
	<input type="hidden" name="counter" id="counter" value="<%=counter%>" />
	<input type="hidden" name="templetCnt" id="templetCnt" value="<%=masTemplateList.size()%>" />
</div>
</div>
<%} %>
<script>
function setHiddenTempId(obj,cnt,fieldName,chgCnt){
	if(obj.checked){
		
		document.getElementById(fieldName+cnt).value=obj.value;
	}else{
		document.getElementById(fieldName+cnt).value=0;
		}
	document.getElementById('changeFlag'+chgCnt+cnt).value='yes';
}

function callAgain(hospitalId)
{
	window.location = "user?method=showUserAssignedTemplet&hospitalId="+hospitalId
}

</script>
</form>