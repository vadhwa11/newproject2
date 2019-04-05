<%@ page import ="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>


<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasTitle"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.TransactionSequence"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<div class="clear"></div>

<%
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
	map=(Map<String, Object>)request.getAttribute("map");
}
/*List<MasEmployeeDependent> dependentList = new ArrayList<MasEmployeeDependent>();
if(map.get("dependentList") != null){
	dependentList = (List<MasEmployeeDependent>)map.get("dependentList");
}*/
List<MasEmployee> existingMasEmployeeList = new ArrayList<MasEmployee>();
if(map.get("existingMasEmployeeList") != null){
	existingMasEmployeeList = (List<MasEmployee>)map.get("existingMasEmployeeList");
}
//System.out.println("existingMasEmployeeList .size()-->"+existingMasEmployeeList .size());

List<Users> usersList = new ArrayList<Users>();
if(map.get("usersList") != null){
	usersList = (List<Users>)map.get("usersList");
}
String empcode = "";
		//Map<String,Object> map = new HashMap<String,Object>();
		//if(request.getAttribute("map") != null){
		//	mapEmployee = (Map<String,Object>) request.getAttribute("map");
		//}
		
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();

		List<TransactionSequence> seqList = new ArrayList<TransactionSequence>();
		
		
		if(map.get("titleList") != null){
			titleList = (List<MasTitle>)map.get("titleList");
			session.setAttribute("titleList", titleList);
		}else if(session.getAttribute("titleList") != null){
			titleList = (List<MasTitle>)session.getAttribute("titleList");
		}
		
		if(map.get("departmentList") != null){
			departmentList = (List<MasDepartment>)map.get("departmentList");
			session.setAttribute("departmentList", departmentList);
		}else if(session.getAttribute("departmentList") != null){
			departmentList = (List<MasDepartment>)session.getAttribute("departmentList");
		}
		
		
		
		if(map.get("empCategoryList") != null){
			empCategoryList = (List<MasEmpCategory>)map.get("empCategoryList");
			session.setAttribute("empCategoryList", empCategoryList);
		}else if(session.getAttribute("empCategoryList") != null){
			empCategoryList = (List<MasEmpCategory>)session.getAttribute("empCategoryList");
		}
	
		
		if(map.get("unitList") != null){
			unitList = (List<MasUnit>)map.get("unitList");
			session.setAttribute("unitList", unitList);
		}else if(session.getAttribute("unitList") != null){
			unitList = (List<MasUnit>)session.getAttribute("unitList");
		}
		if(map.get("rankList") != null){
			rankList = (List<MasRank>)map.get("rankList");
			session.setAttribute("rankList", rankList);
		}else if(session.getAttribute("rankList") != null){
			rankList = (List<MasRank>)session.getAttribute("rankList");
		}
		if(map.get("tradeList") != null){
			tradeList = (List<MasTrade>)map.get("tradeList");
			session.setAttribute("tradeList", tradeList);
		}else if(session.getAttribute("tradeList") != null){
			tradeList = (List<MasTrade>)session.getAttribute("tradeList");
		}
		
		if(map.get("seqList") != null){
			seqList = (List<TransactionSequence>)map.get("seqList");
			session.setAttribute("seqList", seqList);
		}else if(session.getAttribute("seqList") != null){
			seqList = (List<TransactionSequence>)session.getAttribute("seqList");
		}
		
		if(seqList.size() > 0){
		TransactionSequence	tran = (TransactionSequence)seqList.get(0);
		 empcode ="E"+(String.valueOf(""+tran.getTransactionSequenceNumber()));
		}
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			Integer temp =  (Integer)session.getAttribute("hospitalId");
			hospitalId = temp.intValue();
		}



int cnt=1;
String serviceNo="";
int employeeId=0;
int rankId=0;
int titleId=0;
String firstName="";
String middleName="";
String lastName="";
int tradeId=0;
int employeeCategoryId=0;
int unitId=0;
int departmentId=0;
String offPhone="";
if(existingMasEmployeeList.size() > 0){
		for(MasEmployee masEmployee:existingMasEmployeeList){
			employeeId=masEmployee.getId();
			serviceNo=masEmployee.getServiceNo();	
			if(masEmployee.getRank()!=null){
				rankId=masEmployee.getRank().getId();
			}
			if(masEmployee.getTitle()!=null){
				titleId=masEmployee.getTitle().getId();
			}
			firstName=masEmployee.getFirstName();
			if(masEmployee.getMiddleName()!=null){
				middleName=masEmployee.getMiddleName();
			}
			if(masEmployee.getLastName()!=null){
				lastName=masEmployee.getLastName();
			}
			if(masEmployee.getTrade()!=null){
				tradeId=masEmployee.getTrade().getId();
			}
			
	        if(masEmployee.getEmpCategory()!=null){
	        	employeeCategoryId=masEmployee.getEmpCategory().getId();
			}
	        if(masEmployee.getUnit()!=null){
	        	unitId=masEmployee.getUnit().getId();
			}
	        if(masEmployee.getDepartment()!=null){
	        	departmentId=masEmployee.getDepartment().getId();
			}
	        if(masEmployee.getTelNoOffice()!=null){
	        	offPhone=masEmployee.getTelNoOffice();
			}
		}

	}else{
		if(map.get("serviceNo") != null){
			serviceNo = (String)map.get("serviceNo");
		}
		
	}
	int loginId=0;
	String loginName="";
	String password="";
	if(usersList.size()>0){
		for(Users users:usersList){
			loginId=users.getId();
			loginName=users.getLoginName();
			password=users.getLoginName();
		}
	}else{
		password=serviceNo;
		loginName=serviceNo;
	}
	%>
	<div class="division"></div>
<h4>Power User/System Administrator Details</h4>
		<div class="Clear"></div>
<div class="Block">

<input id="codeId" type="hidden" readonly="readonly" name="<%= EMPLOYEE_CODE%>" value="<%=empcode%>" validate="Employee Code,string,no"  MAXLENGTH="12"/  >
<input id="employeeId" type="hidden" readonly="readonly" name="<%= EMPLOYEE_ID%>" value="<%=employeeId%>"/>
<input id="loginId" type="hidden" readonly="readonly" name="loginId" value="<%=loginId%>"/>
<label>Service No.<span>*</span></label>
<input type="text" name="<%= SERVICE_NO%>" value="<%=serviceNo%>" validate="Service No.,string,yes" tabindex="1" MAXLENGTH="15"   id="serviceNo" onblur="setloginName(this.value);submitProtoAjaxWithDivName('hospital','/hms/hms/user?method=getServiceNoDetails&serviceNo='+this.value,'empDiv');"/>
<label >Rank<span>*</span></label>
<select id="rankId" name=<%=RANK_ID %> validate="Rank,string,yes" tabindex="1">
				<option value="0">Select</option>
				            
				        <%
				         		if(rankList != null){ 	
				         			for (Iterator iter = rankList.iterator(); iter.hasNext();) {
				         				MasRank masRank = (MasRank) iter.next();
				         				if(masRank.getId().equals(rankId)){
				         					 %>
				     						<option value="<%=masRank.getId() %>" selected="selected"><%=masRank.getRankName() %></option>           
				     				        <%					
				         				}else{
								         %>
										<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>           
								        <%		
				         				}
				         				}
				        		 } 
				        %>
			      </select>
	<script>
	document.getElementById('rankId').focus();
	</script>		
			<label >Title </label>
				<select id="titleId" name=<%=TITLE_ID %> validate="Title,string,no" tabindex="1">
				<option value="0">Select</option>
				            
				        <%
				         		if(titleList != null){ 	
				         			for (Iterator iter = titleList.iterator(); iter.hasNext();) {
				         				MasTitle masTitle = (MasTitle) iter.next();
				         				if(masTitle.getId().equals(titleId)){
				         					%>
				    						<option value="<%=masTitle.getId() %>" selected="selected"><%=masTitle.getTitleName() %></option>           
				    				        <%							
				         				}else{
				         %>
						<option value="<%=masTitle.getId() %>"><%=masTitle.getTitleName() %></option>           
				        <%		
				         				}
				        			}
				        		 } 
				        
				        %>
			      </select>
	             <div class="Clear"></div>
            <label>First Name<span>*</span></label>
			<input type="text" id="firstName" name="<%=FIRST_NAME %>" value="<%=firstName %>"  tabindex="1" validate="First Name,name,yes"  MAXLENGTH="25"/>
			<label>Middle Name</label>
			<input type="text" id="middleName" name="<%=MIDDLE_NAME%>" value="<%=middleName%>"  tabindex="1" validate="Middle Name,name,no" MAXLENGTH="15" />
			<label>Last Name<span>*</span></label>
			<input type="text" id="lastName" name="<%=LAST_NAME %>" value="<%=lastName%>"  tabindex="1"  validate="Last Name,name,yes" MAXLENGTH="15" />
				  <div class="Clear"></div>
			
			<label>Trade/Branch<span>*</span></label>
				<select id="TradeId" name=<%=TRADE_ID %> validate="Trade/Branch,string,yes" tabindex="1">
				<option value="0">Select</option>
				            
				        <%
				        
				         		if(tradeList != null){ 	
				         			for (Iterator iter = tradeList.iterator(); iter.hasNext();) {
				         				MasTrade masTrade = (MasTrade) iter.next();
				         				if(masTrade.getId().equals(tradeId)){
				         					%>
				    						<option value="<%=masTrade.getId() %>" selected="selected"><%=masTrade.getTradeName() %></option>           
				    				        <%							
				         				}else{
				         %>
						<option value="<%=masTrade.getId() %>"><%=masTrade.getTradeName() %></option>           
				        <%		
				         				}
				        			}
				        		 } 
				        %>
			      </select>
			      
			<label>Category<span>*</span></label>
				  <select id="employeeCategoryId" name=<%=EMPLOYEE_CATEGORY_ID %>  tabindex="1" validate="Category,string,yes">
				  	<option value="0">Select</option>
				        <%
				         		if(empCategoryList != null){ 	
				         			for (Iterator iter = empCategoryList.iterator(); iter.hasNext();) {
				         				MasEmpCategory masEmpCategory = (MasEmpCategory) iter.next();
				         				if(masEmpCategory.getId().equals(employeeCategoryId)){
				         					%>
				    						<option value="<%=masEmpCategory.getId() %>" selected="selected"><%=masEmpCategory.getEmpCategoryName() %></option>           
				    				        <%					
				         				}else{
				         %>
						<option value="<%=masEmpCategory.getId() %>"><%=masEmpCategory.getEmpCategoryName() %></option>           
				        <%		
				         				}
				        			}
				        		 } 
				        %>
	             </select>
	        			       
		<label>Unit<span>*</span></label>
		<select id="unitId" name=<%=UNIT_ID %> validate="Unit,string,yes" tabindex="1">
			<option value="0">Select</option>
				        <%
				         		if(unitList != null){ 	
				         			for (Iterator iter = unitList.iterator(); iter.hasNext();) {
				         				MasUnit masUnit = (MasUnit) iter.next();
				         				if(masUnit.getId().equals(unitId)){
				         					 %>
				     						<option value="<%=masUnit.getId() %>" selected="selected"><%=masUnit.getUnitName() %></option>           
				     				        <%		
				         				}else{
				         %>
						<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>           
				        <%		
				         				}
				        			}
				        		 } 
				        %>
			      </select>
	         <div class="Clear"></div>
            	
            <label>Department<span>*</span></label>
				  <select id="departmentId" name=<%=DEPARTMENT_ID %> validate="Department,string,yes" tabindex="1">
					 <option value="0">Select</option>
			              
			          <%
			           		if(departmentList != null){ 	
			           			for (Iterator iter = departmentList.iterator(); iter.hasNext();) {
			           				MasDepartment masDepartment = (MasDepartment) iter.next();
			           				if(masDepartment.getId().equals(departmentId)){
			           					%>
										<option value="<%=masDepartment.getId() %>" selected="selected"><%=masDepartment.getDepartmentName() %></option>           
						          <%							
			           				}else{
			           %>
							<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>           
			          <%		
			           				}
			          			}
			          		 } 
			          %>
	            </select>
	            
	            
			
			<label>Office Phone<span>*</span></label>
			<input type="text" id="offPhone" name="<%= TELL_NO_OFFICE%>" value="<%=offPhone%>" tabindex="1" validate="Office Phone,alphanumeric,yes"  MAXLENGTH=12/ >
			
			<div class="Clear"></div>
	   </div>
	   
	   	 <div class="Clear"></div>
		<%--
		<h4>Login Details<input type="checkbox" name="loginRequired" id="loginRequired" onclick="getLoginRequired()" checked="checked"/>(If Required)</h4>
		 --%>
		<div class="Clear"></div>
	    <div class="Block">
	    	<label> Login Name<span>*</span></label>
	    	<input type="text" name="loginName" id="loginName" value="<%=loginName%>" tabindex="1" readonly="readonly" validate="Login Name,string,yes" />
   			<label>Password<span>*</span>  </label> 
			<input id="password" name=<%=PASSWORD%> type="password" value="<%=password%>" maxlength="15" tabindex="1" readonly="readonly" validate="Password,string,yes" /> 
<%--End of Code for Login Menu Assign  --%>
	<div class="division"></div>
			<input type="hidden" id="status" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
			
	    </div>
