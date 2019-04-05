<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.*"%>
<%@ page import="jkt.hms.masters.business.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<%	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	//System.out.println("This is User Management JSP");
	Map map = new HashMap();
		String includedJsp="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			
		}			
				
		String userName = "";
		
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		List userList = new ArrayList();
		if(map.get("userList") != null)
		{
			userList=(List) map.get("userList");
		}
		int userId=0;
		if(map.get("userId") != null)
		{
			userId=(Integer) map.get("userId");
		}
		int hospitalIdFromSession=0;
		if(map.get("hospitalId") != null)
		{
			hospitalIdFromSession=(Integer) map.get("hospitalId");
		}
		List hospitalIdList=new ArrayList();
		List hospitalNameList= new ArrayList();
		Set<MasHospital> hospitalList= new HashSet<MasHospital>();
	   if(userList != null)
	   {
		   String username= "";
		   String loginName= "";
		   String serviceNo=null;
		   Users userObj=(Users)userList.get(0);
		   
		   Set set=new HashSet();
		   set=userObj.getUserUsergroupHospitals();
		   Iterator itr= set.iterator();
		   while(itr.hasNext())
		   {
		   UserUsergroupHospital userUsergroupHospital=(UserUsergroupHospital)itr.next();
		   UsergroupHospital usergroupHospital=(UsergroupHospital)userUsergroupHospital.getGroupHospital();
		   int hospitalId=usergroupHospital.getHospital().getId();
		   String hospitalName=usergroupHospital.getHospital().getHospitalName();
		   hospitalIdList.add(hospitalId);
		   hospitalNameList.add(hospitalName);
		   hospitalList.add(usergroupHospital.getHospital());
		   }
		   		   
		   //String employeeCode=userObj.getEmployee().getEmployeeCode();
		   String employeeName=userObj.getEmployee().getFirstName();
		   if(userObj.getEmployee().getMiddleName()!=null){
			   employeeName=employeeName+" "+userObj.getEmployee().getMiddleName();
		   }
			if(userObj.getEmployee().getLastName()!=null){
				employeeName=employeeName+" "+userObj.getEmployee().getLastName();
		   }
		   String email=userObj.getEmailAddress();
		  
	     //  String patientName=inPatientDetail.getHin().getPFirstName()+inPatientDetail.getHin().getPMiddleName()+inPatientDetail.getHin().getPLastName();
	    	 if(userObj.getUserName() != null)
			   {
	    		 username=userObj.getUserName();
			   }
			
			if(userObj.getLoginName() != null)
			{
				loginName=userObj.getLoginName();	
			}
	%>

<div class="titleBg"><h2>User Management</h2></div>
<div class="Clear"></div>

<form name="userManagement" method="post" action="">
<input type="hidden" name="userId" value="<%=userId %>" />

<h4>User Details</h4>
<div class="Clear"></div>
<div class="Block">
<label>User Name</label> 
<label class="value"> <%= username %></label>
<label>Login Name</label> 
<label class="value"> <%=loginName %></label>
<label>Name</label> 
<%if(userObj.getEmployee() != null){ %> 
<label	class="value"> <%=employeeName %></label>
 <%}else{ %> 
<label	class="value">-</label> 
<%} %> 
<%--
<label>Email Add.</label> 
<%if(userObj.getEmailAddress() != null){ %>
<label class="value"> <%=email %></span> <%}else{ %> 
<label class="value">-</label>
<%} %>
<div class="Clear"></div>
 --%>
<%
			}
		%>

<%
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %> <h4><%=message%></h4> <%
		  }
    %>

<label class="common">SMC<span>*</span></label> 
<select name="hospitalId" onchange="submitProtoAjax('userManagement','superAdmin?method=getGroupList')" class="large">
	<option value="0">Select</option>

	<%
			   Set hospitalNameSet=new HashSet();
			   Set hospitalIdSet=new HashSet();
			   Set hospitalSet=new HashSet();
				Iterator itr=hospitalIdList.iterator();
				int j=0;
				while(itr.hasNext()){
			    	int hospitalId= (Integer) itr.next();
					String hospitalName=(String)hospitalNameList.get(j);
					//System.out.println("hospital id to be added in set---"+hospitalId+"----hospital name----"+hospitalName);
					hospitalNameSet.add(hospitalName);
					hospitalIdSet.add(hospitalId);
					
					j++;
				}
					
				
					List hospitalNameListFromSet=new ArrayList();
					boolean bool=hospitalNameListFromSet.addAll(hospitalNameSet);
					//System.out.println("size of  hospitalNameSet set-----"+hospitalNameSet.size()+"------size of  hospitalIdSet set----"+hospitalIdSet.size());
				int i=0;
			//	Iterator iter=hospitalIdSet.iterator();
			 //   while(iter.hasNext()){
			 //   	int hospitalId= (Integer) iter.next();
			//		String hospitalName=(String)hospitalNameListFromSet.get(i);	
			for(MasHospital hospital : hospitalList){
				//	if(hospitalId==hospitalIdFromSession){
					if(hospital.getId()==hospitalIdFromSession){
					
			%>
	<option value="<%=hospital.getId()%>" selected><%=hospital.getHospitalName()%></option>
	<%}	else{
		%>
		<option value="<%=hospital.getId()%>"><%=hospital.getHospitalName()%></option>
	<%}
			  i++;
			  
			 }
			%>
</select>
</div>
<div id="testDiv"></div>
</form>
<script type="text/javascript">
  
  	function getGroupList(formName,action){
  		
		var hospitalIdObj = eval('document.'+formName+'.hospitalId')
		var hospitalId = hospitalIdObj.value;
		errorMsg ="";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		if(hospitalId != ""){
			obj = eval('document.'+formName)
			       	obj.action = action;
		    	   	 var url=action+"&"+getNameAndData(formName)
		        	
		        	new Ajax.Updater('hinDiv',url,
					   {asynchronous:true, evalScripts:true }); 
		}	
		return true;
   }
  </script>
<script language="Javascript" type="text/javascript">
				var abc = window.onload;
            		window.onload = function(){if(abc)abc();submitProtoAjax('userManagement','superAdmin?method=getGroupList')}
            	</script>
            	