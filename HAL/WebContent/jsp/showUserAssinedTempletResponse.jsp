<%--
 * Copyright 2011 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showUserAssinedTemplet.jsp  
 * Purpose of the JSP   This is for Assigned Templet To User 
 * @author  Mukesh Narayan Singh
 * Create Date: 6th Jun,2012 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<%@page import="jkt.hms.masters.business.UserTemplate"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
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
	//System.out.println("masEmpCategoryList.size()-response-->"+masEmpCategoryList.size());
	List<UserTemplate> userTemplateList = new ArrayList<UserTemplate>();
	if(map.get("userTemplateList")!=null){
		userTemplateList =(List) map.get("userTemplateList");
	}
	%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasTemplate"%>
<div class="clear"></div>
<div id="slide5">
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
	<%
	//System.out.println("hrEmpRosterList---->"+hrEmpRosterList.size());
	if(masTemplateList.size()>0){
		
		%>
		<th>Employee Name</th>
		<%
		for(MasTemplate masTemplate :masTemplateList){
	%>
	<!-- day+"/"+month+"/"+year -->
	<th><%=masTemplate.getTemplateName()%></th>
	<%
	}
	}
	
	%>
	</tr>
	<%
	int counter=0;
	//System.out.println("masEmployeeList---->"+masEmployeeList.size());
	if(masEmployeeList.size()>0){
		//for(MasEmployee masEmployee:masEmployeeList){
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
			<td>&nbsp;&nbsp;<%=employeeName %>
			<input type="hidden" name="empId<%=counter%>" id="empId<%=counter%>" value="<%=masEmployee.getId()%>" />
			<input type="hidden" name="userId<%=counter%>" id="userId<%=counter%>" value="<%=user.getId()%>" />
			
			</td>
		<%
		int templetCnt=0;
		if(masTemplateList.size()>0){
			for(MasTemplate masTemplate :masTemplateList){
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
							//preTempletId=templateIdTemp;
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
		<input type="checkbox" checked="checked" name="templetId<%=templetCnt%><%=counter%>" id="templetId<%=templetCnt%><%=counter%>" value="<%=masTemplate.getId()%>" />
		<%}else{ %>
		<input type="checkbox"  name="templetId<%=templetCnt%><%=counter%>" id="templetId<%=templetCnt%><%=counter%>" value="<%=masTemplate.getId()%>"  />
		<%} %>
		<input type="hidden" name="preTempletId<%=templetCnt%><%=counter%>" id="preTempletId<%=templetCnt%><%=counter%>" value="<%=preTempletId%>" />
		</td>
		<%
		}
		}
		%>
			
		</tr>
	<%		
		}
	}
	%>
	<input type="hidden" name="counter" id="counter" value="<%=counter%>" />
	<input type="hidden" name="templetCnt" id="templetCnt" value="<%=masTemplateList.size()%>" />
</table>
</div>
</div>

