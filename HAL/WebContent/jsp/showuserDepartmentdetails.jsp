<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="it.businesslogic.ireport.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>


	
	<%

	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	List<MasDepartment> departmentlist=new ArrayList<MasDepartment>();
	//departmentlist = (ArrayList)map.get("departmentList");
	System.out.println(departmentlist+"--departmentlistin beforjsp--");
	if(map.get("departmentlist") != null){
	departmentlist = (List<MasDepartment>)map.get("departmentlist");
	}
	System.out.println(departmentlist+"--departmentlistin jsp-->>>>>>>>>.   "+departmentlist.size());
	%>
<div class="titleBg">	
<h2>User Department </h2>
</div>
<form name="showUseeDepartment" target="_blank" action="" method="post">
<div class="Block">
<label><span>*</span> Ward </label> 
<select name="<%=RequestConstants.DEPARTMENT_ID%>"  tabindex="1" validate="Ward,yes" />
<option value="0" >Select</option>
			  <% 
				for (MasDepartment  masDept : departmentlist){
					%>			
<option value="<%=masDept.getId ()%>"><%=masDept.getDepartmentName()%></option>
			  <%}%>
</select>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('showUseeDepartment','superAdmin?method=generateUserDepartmentReport','validateFromToDate');" />
<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>


	