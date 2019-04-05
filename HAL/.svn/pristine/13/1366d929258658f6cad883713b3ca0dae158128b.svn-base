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
<%@page import="jkt.hms.masters.business.EmpGroups"%>


	<%

	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	List<EmpGroups> empGroupList=new ArrayList<EmpGroups>();
	//departmentlist = (ArrayList)map.get("departmentList");
	System.out.println(empGroupList+"--departmentlistin beforjsp--");
	if(map.get("empGroupList") != null){
		empGroupList = (List<EmpGroups>)map.get("empGroupList");
	}
	System.out.println(empGroupList+"--departmentlistin jsp-->>>>>>>>>.   "+empGroupList.size());
	%>
<div class="titleBg">
<h2>User Employee Group</h2>
</div>
<form name="showUserEmpGRp" target="_blank"  action="" method="post">
<div class="Block">
<label><span>*</span> Group Name </label> 
<select name="<%=RequestConstants.EMPLOYEE_GROUP_ID%>"  tabindex="1" validate="Ward,yes"/>
<option value="0">Select</option>
<% 
				for (EmpGroups  empGrp : empGroupList){
%>			
<option value="<%=empGrp.getId()%>"><%=empGrp.getEmpGroupName()%></option>
			  <%}%>
</select>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('showUserEmpGRp','superAdmin?method=generateEmpGrpDetailsRep','validateFromToDate');" />
<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>


	