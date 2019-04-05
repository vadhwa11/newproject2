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
	<div class="division"></div>
<h4>Power User/System Administrator Details</h4>
		<div class="Clear"></div>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}

	List<MasEmployee> existingMasEmployeeList = new ArrayList<MasEmployee>();
	if (map.get("existingMasEmployeeList") != null) {
		existingMasEmployeeList = (List<MasEmployee>) map
				.get("existingMasEmployeeList");
	}

	List<Users> usersList = new ArrayList<Users>();
	if (map.get("usersList") != null) {
		usersList = (List<Users>) map.get("usersList");
	}

	int cnt = 1;
	String serviceNo = "";
	int employeeId = 0;
	int rankId = 0;
	int titleId = 0;
	String firstName = "";
	String middleName = "";
	String lastName = "";
	int tradeId = 0;
	int employeeCategoryId = 0;
	int unitId = 0;
	int departmentId = 0;
	String offPhone = "";
	if (existingMasEmployeeList.size() > 0) {
		for (MasEmployee masEmployee : existingMasEmployeeList) {
			employeeId = masEmployee.getId();
			serviceNo = masEmployee.getServiceNo();
			if (masEmployee.getRank() != null) {
				rankId = masEmployee.getRank().getId();
			}
			if (masEmployee.getTitle() != null) {
				titleId = masEmployee.getTitle().getId();
			}
			firstName = masEmployee.getFirstName();
			if (masEmployee.getMiddleName() != null) {
				middleName = masEmployee.getMiddleName();
			}
			if (masEmployee.getLastName() != null) {
				lastName = masEmployee.getLastName();
			}
			if (masEmployee.getTrade() != null) {
				tradeId = masEmployee.getTrade().getId();
			}

			if (masEmployee.getEmpCategory() != null) {
				employeeCategoryId = masEmployee.getEmpCategory()
						.getId();
			}
			if (masEmployee.getUnit() != null) {
				unitId = masEmployee.getUnit().getId();
			}
			if (masEmployee.getDepartment() != null) {
				departmentId = masEmployee.getDepartment().getId();
			}
			if (masEmployee.getTelNoOffice() != null) {
				offPhone = masEmployee.getTelNoOffice();
			}
			int loginId = 0;
			String loginName = "";
			String password = "";
			if (usersList.size() > 0) {
				for (Users users : usersList) {
					if (users.getEmployee().getId() == employeeId) {
						loginId = users.getId();
						loginName = users.getLoginName();
						password = users.getLoginName();
					}
				}
			} 
%>

<div class="Block">

<input id="employeeId" type="hidden" readonly="readonly" name="<%=EMPLOYEE_ID%>" value="<%=employeeId%>"/>
<label>Service No.<span>*</span></label>
<input type="text" name="<%=SERVICE_NO%>" value="<%=serviceNo%>" validate="Service No.,string,yes" tabindex="1" MAXLENGTH="15" readonly="readonly"  id="serviceNo" onblur="setloginName(this.value);submitProtoAjaxWithDivName('hospital','/hms/hms/user?method=getServiceNoDetails&serviceNo='+this.value,'empDiv');"/>
<label >Rank<span>*</span></label>
<input type="text" name="rankId" value="<%=masEmployee.getRank().getRankName()%>" readonly="readonly"/>
		
<label >Title </label>
<input type="text" name="titleId" value="<%=masEmployee.getTitle() != null ? masEmployee
							.getTitle().getTitleName() : ""%>" readonly="readonly"/>				
<div class="Clear"></div>
<label>First Name<span>*</span></label>
<input type="text" id="firstName" name="<%=FIRST_NAME%>" value="<%=firstName%>"  tabindex="1" readonly="readonly" validate="First Name,name,yes"  MAXLENGTH="25"/>
<label>Middle Name</label>
<input type="text" id="middleName" name="<%=MIDDLE_NAME%>" value="<%=middleName%>"  tabindex="1" readonly="readonly" validate="Middle Name,name,no" MAXLENGTH="15" />
<label>Last Name<span>*</span></label>
<input type="text" id="lastName" name="<%=LAST_NAME%>" value="<%=lastName%>"  tabindex="1" readonly="readonly"  validate="Last Name,name,yes" MAXLENGTH="15" />
 <div class="Clear"></div>
			
<label>Trade/Branch<span>*</span></label>
<input type="text" name="tradeId" value="<%=masEmployee.getTrade() != null ? masEmployee
							.getTrade().getTradeName() : ""%>" readonly="readonly"/>

			      
<label>Category<span>*</span></label>
<input type="text" name="categoryId" value="<%=masEmployee.getEmpCategory() != null ? masEmployee
									.getEmpCategory().getEmpCategoryName()
									: ""%>" readonly="readonly"/>

<label>Unit<span>*</span></label>
<input type="text" name="unitId" value="<%=masEmployee.getUnit() != null ? masEmployee
							.getUnit().getUnitName() : ""%>" readonly="readonly"/>

<div class="Clear"></div>
            	
<label>Department<span>*</span></label>
<input type="text" name="departmentId" value="<%=masEmployee.getDepartment() != null ? masEmployee
							.getDepartment().getDepartmentName() : ""%>" readonly="readonly"/>

<label>Office Phone<span>*</span></label>
<input type="text" id="offPhone" name="<%=TELL_NO_OFFICE%>" value="<%=offPhone%>" readonly="readonly" tabindex="1" validate="Office Phone,alphanumeric,yes"  MAXLENGTH=12/ >

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
			<input type="hidden" id="status" name="<%=STATUS%>" value="" />
	    </div>
<%
	}

	}
%>			
