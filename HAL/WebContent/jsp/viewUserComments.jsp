<%-- 
    * Copyright 2008 JK Technosoft Ltd. All rights reserved.
    * Use is subject to license terms.
    * File Name           : userComments.jsp 
    * Tables Used         : 
    * Description         : 
    * @author  Create Date: 15.07.2009    Name: Vineet Kumar
    * Revision Date:      Revision By: 
    * @version 1.0  
    
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%><%@ page import="jkt.hms.util.HMSUtil"%>

<%@ page import="jkt.hms.masters.business.MasWorkType"%>
<%@ page import="jkt.hms.masters.business.MasWorkCategory"%>
<%@page import="jkt.hms.masters.business.MasMinorWorkProposal"%>
<%@page import="jkt.hms.masters.business.MasDepartmentType"%>

<%@page import="jkt.hms.masters.business.WorkNoDepartment"%>
<%@page import="jkt.hms.masters.business.MasMinorWorkDetail"%>
<SCRIPT language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"
	type=text/javascript></SCRIPT>


<SCRIPT>
   <%

      Calendar calendar=Calendar.getInstance();
      String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
      String dateCal=String.valueOf(calendar.get(Calendar.DATE));
      int year=calendar.get(calendar.YEAR);
      if(month.length()<2){
         month="0"+month;
      }
      if(dateCal.length()<2){
         dateCal="0"+dateCal;
      }
         
   %>
   serverdate = '<%=dateCal+"/"+month+"/"+year%>';
   
<% String   userName="";
   Map<String,Object> map = new HashMap<String,Object>();
   if (request.getAttribute("map") != null) {
      map = (Map) request.getAttribute("map");
   }
   if(session.getAttribute("userName")!=null){
      userName=(String)session.getAttribute("userName");
   }
   
   String deptName="";
      if(session.getAttribute("deptName")!=null){
         deptName=(String)session.getAttribute("deptName");
         }
   Map<String, Object> utilMap = new HashMap<String, Object>();
   utilMap = (Map) HMSUtil.getCurrentDateAndTime();
   String date = (String) utilMap.get("currentDate");
   //String Session=(String) utilMap.get("session");
   String time = (String) utilMap.get("currentTime");
   
   List<MasDepartmentType> departmentTypeList = new ArrayList<MasDepartmentType>();
   if (map.get("departmentTypeList") != null) {
      System.out.println("departmentTypeList");
      departmentTypeList = (List) map.get("departmentTypeList");
   }
   List<MasMinorWorkDetail> searchMinorWorkDetailSearchList = new ArrayList<MasMinorWorkDetail>();
    
      if(map.get("minorWorkDetailList")!=null)
      {
         searchMinorWorkDetailSearchList = (List) map.get("minorWorkDetailList");
      }
   
   
   String sessionPeriod="";
   if(map.get("session")!=null)
   {
      sessionPeriod=(String) map.get("session");
   }
   
   
   
   List<MasWorkCategory> workCategoryList = new ArrayList<MasWorkCategory>();
      
   if(map.get("workCategoryList")!=null)
   {
      workCategoryList = (List) map.get("workCategoryList");
   }
   
   List<MasWorkType> worktypeList = new ArrayList<MasWorkType>();
   if(map.get("workTypeList")!=null)
   {
   worktypeList = (List) map.get("workTypeList");
   }  
   List<WorkNoDepartment> gridTypeList = new ArrayList<WorkNoDepartment>();
   
   if (map.get("gridTypeList") != null) {
       System.out.println("gridTypeList");
       gridTypeList = (List) map.get("gridTypeList");
    }
   %>
      
   </SCRIPT>

<% String minorWorkNo ="";
   if(map.get("minorWorkNo") != null){
      minorWorkNo = (String)map.get("minorWorkNo");
     }
   String message ="";
      %>

<% 
   if (map.get("message") != null) {
          message = (String) map.get("message");
         
      }
   if(!message.equalsIgnoreCase("")){
   %>
<h2><%=message %></h2>
<%} %>

<div class="Clear"></div>
<DIV id="contentHolder">
<FORM name="userComments" action="" method=post>
<h6>User Comments</h6>
<div class="Clear"></div>

<div class="blockFrame"><Label> Minor Work No </Label> <%if(searchMinorWorkDetailSearchList !=null && searchMinorWorkDetailSearchList.size()>0){ %>
<INPUT validate="Minor Work No,string,yes"
	value="<%=searchMinorWorkDetailSearchList.get(0).getMinorWorkDetailNo() %>"
	id="proposalNo" name="<%=MINOR_WORK_PROPOSAL_NO_SEARCH %>" /> <%} else if(minorWorkNo != null) { %>
<input tabindex="1" name="<%=MINOR_WORK_PROPOSAL_NO_SEARCH%>"
	id="proposalNo" value="<%=minorWorkNo %>" readonly="true" /> <%} else { %>
<INPUT value="" name="<%=MINOR_WORK_PROPOSAL_NO_SEARCH %>"
	id="proposalNo" /> <%} %> <Label> Financial Year<span>*</span> </Label>
<select disabled="disabled" name="<%=MINOR_WORK_FINENTIAL_YEAR%>"
	validate="Financial year,string,yes" tabindex=1>

	<option
		value="<%=searchMinorWorkDetailSearchList.get(0).getFinancialYear()%>"><%=searchMinorWorkDetailSearchList.get(0).getFinancialYear()%></option>


</select>
<div class="Clear"></div>

<LABEL>Minor Work Date<span>*</span> </LABEL> <INPUT tabindex="1"
	readonly="readonly"
	value="<%=searchMinorWorkDetailSearchList.get(0).getMinorWorkDetailDate()%>"
	name="<%=MINOR_WORK_DATE %>" /> <INPUT type=hidden
	value="<%=userName%>" name="<%=LAST_CHANGED_BY%>"> <INPUT
	type=hidden value="<%=date%>" name="<%=LAST_CHANGED_DATE%>"> <INPUT
	type=hidden value="<%=time%>" name="<%=LAST_CHANGED_TIME%>"> <label>User
Comments<span>*</span> </Label> <%if(searchMinorWorkDetailSearchList !=null && searchMinorWorkDetailSearchList.size()>0 && searchMinorWorkDetailSearchList.get(0).getUserComments() != null && !searchMinorWorkDetailSearchList.get(0).getUserComments().trim().equalsIgnoreCase("")){ %>

<textarea maxlength="100" class="large" name="<%= USER_COMMENTS %>"
	readonly="readonly"><%=searchMinorWorkDetailSearchList.get(0).getUserComments()%> </textarea>
<%}else{ %> <textarea maxlength="100" class="large"
	name="<%= USER_COMMENTS %>" readonly="readonly">No User Comments For this minor work</textarea>
<%} %>
</div>



<div class="division"></div>
<!--Bottom labels starts-->
<div class="bottom"><INPUT class=button id=back accessKey=b
	onClick="javascript:history.back()" type=button value=Back name=back />
<INPUT type=hidden name="<%=STATUS %>"> <INPUT type=hidden
	name="<%= COMMON_ID%>">

<div class="division"></div>

<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> <label>Changed
By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

</form>
<DIV class="Clear"></DIV>
</DIV>

