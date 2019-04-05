<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.HrMasLeaveTypeMediator"%>
<%
	session.setAttribute("save", true);
	Map map=(Map)request.getAttribute("map");
	List mgr=(List)map.get("manager");
	request.getSession(true);
	Users loggedUser =(Users)session.getAttribute(USERS);
	UserManager manager=null;
	if(mgr!=null && mgr.size()>0)
	{
		 manager=(UserManager)mgr.get(0);
	}
	
	List listOfHolidays=(List)map.get("listOfHolidays"); 
    List<Integer> empDependents = new ArrayList<Integer>();
    String status1 ="";
    String status2="";
    List<HrMasLeaveTypeMediator> leaveTypeList=new ArrayList<HrMasLeaveTypeMediator>();
    List<Object> empPatMatAvailedOrNot = new ArrayList<Object>();
    
    if(map.get("leaveTypeList")!=null){
    	leaveTypeList = (List)map.get("leaveTypeList");
    	
    }
    if(map.get("empDependents")!=null){
    	empDependents = (List)map.get("empDependents");
    }
    int childrenCount = empDependents.get(0);
    if(map.get("empPatMatAvailedOrNot")!=null){
    	empPatMatAvailedOrNot = (List)map.get("empPatMatAvailedOrNot");
    }
    if(empPatMatAvailedOrNot.size()>0){
        Object[] arrayFirst = (Object[])empPatMatAvailedOrNot.get(0);
       	status1 = (String)arrayFirst[0];
        //Integer id = (Integer)arrayFirst[1];
        
        Object[] arraySecond = (Object[])empPatMatAvailedOrNot.get(0);
        status2 = (String)arraySecond[0];
    }

    boolean halfDay =false;
%>
<%
String sex ="";
String maritalStatusCode ="";
//if(loggedUser.getEmployee().getPersonalDetails() != null){
	//sex = loggedUser.getEmployee().getPersonalDetails().getGender().getAdministrativeSexName();
	//maritalStatusCode = loggedUser.getEmployee().getPersonalDetails().getMaritalStatus().getMaritalStatusCode();
//}
%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.UserManager"%>
<%@page import="java.util.ArrayList"%>
<div id="selectType" style="display:block;">
		<label><span>*</span>Leave Type</label> 
		<select id="leaveType" name="<%=TYPE%>"  readonly validate="Type,nothing,yes" onkeyup="showLeaveBalance(this.value);" onchange="availedBirthdayLeave(this.value);manageDates(this.value);manageCalendar(this.value);showLeaveBalance(this.value);chkForPL(this.value);chkForPaternity(this.value);chkForEncashment(this.value);chkForOptionalLeave(this.value);">
		
		<option value="">Select</option>
		<%for(HrMasLeaveTypeMediator hrMasLeaveType:leaveTypeList){ 
			if(hrMasLeaveType.getLeaveType().getStatus().equals("y")
					&& !hrMasLeaveType.getLeaveType().getLeaveType().getId().equals(20)){
	    			if(maritalStatusCode.equalsIgnoreCase("M") 
	    					&& sex.equalsIgnoreCase("male") && hrMasLeaveType.getLeaveType().getLeaveType().getId().equals(4)){ 
	    				if(childrenCount < 3 && status1.equals("n") ){%>
		    				<option value="<%=hrMasLeaveType.getLeaveType().getLeaveType().getId()%>"><%=hrMasLeaveType.getLeaveType().getLeaveType().getDescription()%></option>	    				
	    				<%}%>
	    			<%} else if(maritalStatusCode.equalsIgnoreCase("M") 
	    					&& sex.equalsIgnoreCase("female") &&  hrMasLeaveType.getLeaveType().getLeaveType().getId().equals(3)){
		    				if(childrenCount < 3 && status2.equals("n") ){ %>
		    					<option value="<%=hrMasLeaveType.getLeaveType().getLeaveType().getId()%>"><%=hrMasLeaveType.getLeaveType().getLeaveType().getDescription()%></option>		    					
		    			<%	} %>
	    			<%} else { 
	    				if(!hrMasLeaveType.getLeaveType().getLeaveType().getId().equals(4)
	    					&&  !hrMasLeaveType.getLeaveType().getLeaveType().getId().equals(3) && hrMasLeaveType.getLeaveType().getLeaveType().getStatus().equalsIgnoreCase("y")){ %>
								<option value="<%=hrMasLeaveType.getLeaveType().getLeaveType().getId()%>"><%=hrMasLeaveType.getLeaveType().getLeaveType().getDescription()%></option>	    					
	    				<%}%>
				   <%}}}%>
	    </select>
	  
    </div>