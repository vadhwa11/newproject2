<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasTemplate"%>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
	 map = (Map<String,Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	List<MasTemplate> searchTemplateList = new ArrayList<MasTemplate>();
	searchTemplateList= (ArrayList)map.get("searchTemplateList");
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	
	List<MasEmpCategory> masEmpCategoryList = new ArrayList<MasEmpCategory>();
	List<MasTemplate> masTemplateList = new ArrayList<MasTemplate>();
	if(map.get("masEmpCategoryList")!=null){
		masEmpCategoryList= (ArrayList)map.get("masEmpCategoryList");
	}
	if(map.get("masTemplateList")!=null){
		masTemplateList= (ArrayList)map.get("masTemplateList");
	}
	if(map.get("message") != null){
	String message = (String)map.get("message");
%>
	
<%@page import="jkt.hms.masters.business.MasEmpCategory"%><h4><span><%=message%></span></h4>
<%		   
	}
%>
 
<div class="titleBg">
<h2>Template Creation</h2>
</div>
<div class="clear"></div>
<form name="search" method="post" action="">
<div class="Block">
<label>Template Code </label>
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" />
<label>Template Name </label>
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value="2" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>"	value="" validate="Template Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'user?method=searchTemplate')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','user?method=searchTemplate','checkSearch')"	tabindex=1 />
</div>
<div class="clear"></div>

</form>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
  if(searchTemplateList.size()>0)
   {
	  String strForCode = (String)map.get("templateCode");
		String strForCodeDescription = (String)map.get("templateName");
		if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
		{
 %>
<div class="clear"></div>
<h4><a href="user?method=showTemplateMaster">Show All Records</a></h4> <%
		
		  }
	   }
	 if(searchTemplateList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="user?method=showTemplateMaster">Show All Records</a></h4> <%
    }
	%> <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"],[1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%=HOSPITAL_ID%>"],[4,"<%=DEPARTMENT_ID%>"],[5,"<%=STATUS%>"],[6,"<%=EMPLOYEE_CATEGORY_ID%>"],[7,"parentId"]];
  statusTd =5;
 </script>
 </div>
<div class="clear"></div>
<form name="template" method="post" action="">
<input	type="hidden" name="<%=JSP_NAME %>" value="masTemplate">
<input	type="hidden" name="<%= POJO_NAME %>" value="MasTemplate">
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="TemplateName">
<input type="hidden" name="title" value="Template">
<input	type="hidden" name="pojoPropertyCode" value="TemplateCode">
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Template Code </label>
<input id="codeId"	type="text" name="<%= CODE%>" value=""	validate="Template Code,string,yes" MAXLENGTH="8" tabindex=1 />
<label> <span>*</span> Template Name </label>
<input type="text"	name="<%=SEARCH_NAME %>" id="<%=SEARCH_NAME %>" value="" validate="TemplateName,string,yes" maxlength="30" tabindex="1" />
<div class="clear"></div>
<%-- <label>  Employee Category </label>
<select name="<%=EMPLOYEE_CATEGORY_ID %>" size="0" tabindex="1" id="employeeCategoryId" >
<option value="0">Select</option>
	<%
		if(masEmpCategoryList.size()>0){
			for(MasEmpCategory masEmpCategory:masEmpCategoryList){
		%>
			<option value="<%=masEmpCategory.getId()%>"><%=masEmpCategory.getEmpCategoryName()%></option>
		<%				
			}
		}
	%>
</select>
<label> Parent Template</label>
<select name="parentId" size="0" tabindex="1" id="parentId" >
<option value="0">Select</option>
	<%
		if(masTemplateList.size()>0){
			for(MasTemplate masTemplate:masTemplateList){
		%>
			<option value="<%=masTemplate.getId()%>"><%=masTemplate.getTemplateName()%></option>
		<%				
			}
		}
	%>
</select> --%>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button"	onclick="submitForm('template','user?method=addTemplate');"	accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" class="button"	onClick="submitForm('template','user?method=editTemplate')"	accesskey="u" tabindex=1 />
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" onClick="submitForm('template','user?method=deleteTemplate&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input	type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label	class="value"><%=userName %></label>
<label>Changed Date:</label>
<label class="value"><%=date%></label>
<label>Changed Time:</label>
<label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName %>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<div class="Clear"></div>
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Template Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Template Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Hospital Id"
data_header[2][1] = "hide";
data_header[2][2] = "0%";
data_header[2][3] = "<%= HOSPITAL_ID %>";

data_header[3] = new Array;
data_header[3][0] = "Department Id"
data_header[3][1] = "hide";
data_header[3][2] = "50%";
data_header[3][3] = "<%=DEPARTMENT_ID%>";

data_header[4] = new Array;
data_header[4][0] = "Status"
data_header[4][1] = "data";
data_header[4][2] = "5%";
data_header[4][3] = "<%=STATUS %>";

data_header[5] = new Array;
data_header[5][0] = "Employee Category"
data_header[5][1] = "data";
data_header[5][2] = "5%";
data_header[5][3] = "<%=EMPLOYEE_CATEGORY_ID %>";

data_header[6] = new Array;
data_header[6][0] = "Parent Template"
data_header[6][1] = "data";
data_header[6][2] = "5%";
data_header[6][3] = "parentId";



data_arr = new Array();
<%
Iterator<MasTemplate> itr=searchTemplateList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
        	  MasTemplate  masTemplate = (MasTemplate)itr.next();       
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masTemplate.getId()%>
data_arr[<%= counter%>][1] = "<%=masTemplate.getTemplateCode()%>"
data_arr[<%= counter%>][2] = "<%=masTemplate.getTemplateName()%>"


data_arr[<%= counter%>][3] = "<%=masTemplate.getHospital().getHospitalName()%>"

data_arr[<%= counter%>][4] = "<%=masTemplate.getDept().getDepartmentName()%>"
<% if(masTemplate.getStatus().equals("y")){ %>
data_arr[<%= counter%>][5] = "Active"
<%}else{%>
data_arr[<%= counter%>][5] = "InActive"
<%}
String empCat="";
String parentTemplate="";
if(masTemplate.getEmpCategory()!=null){
	empCat=masTemplate.getEmpCategory().getEmpCategoryName();
}
if(masTemplate.getTemplate()!=null){
	parentTemplate=masTemplate.getTemplate().getTemplateName();
}
%>
data_arr[<%= counter%>][6] = "<%=empCat%>"
data_arr[<%= counter%>][7] = "<%=parentTemplate%>"

<%
		     counter++;
}
%>
 
formName = "template"

start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>