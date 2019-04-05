
<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * opdTemplateInvestigation.jsp  
	 * Purpose of the JSP -  This is for Nursing Care Entry Setup.
	 * Create Date: 20th Feb,2008 
	 * Revision Date:      
	 * Revision By: 
	 * @version 1.4
	--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>


<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.OpdTemplateInvestigation"%>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript">
		vBulletin_init();

		
		
	</script>

<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	departmentList = (List<MasDepartment>)map.get("departmentList");
	
	List<OpdTemplate> opdTemplateList = new ArrayList<OpdTemplate>();
	opdTemplateList = (List<OpdTemplate>)map.get("opdTemplateList");
	
	

	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	int templateId=0;
	
	templateId=(Integer)map.get("templateId");
	System.out.println("templateId in JSP" + templateId);
	
	int deptId=0;
	deptId=(Integer)map.get("deptId");
	
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
	
		List showInvList=new ArrayList();
		try {
			showInvList=(List)map.get("showInvList");
					System.out.println("Size of set -------"+showInvList.size());
	
			
		} catch (Exception exp) {
				
					exp.printStackTrace();
		}
		
	
	%>


<jsp:include page="searchResultBlock.jsp" />

<form name="OPDInves" method="post">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<script type="text/javascript" language="javascript">
		
		
		formFields = [[0, "<%= COMMON_ID%>", "id"], [1,"<%= DEPARTMENT_NAME%>"], [2,"<%= TEMAPLATE_NAME %>"], [3,"<%= "chargeCodeCode" %>"], [4,"chargeCodeName"],[5,"<%= CLINICAL_NOTE%>"], [6,"<%= QTY %>"],[7,"<%=CHANGED_BY%>"],[8,"<%=CHANGED_DATE%>"],[9,"<%=CHANGED_TIME%>"],[10,"<%=CHARGE_CODE_ID%>"],[11,"<%=STATUS%>"]];
		 statusTd = 11;
	
	</script></div>
<div id="edited"></div>
<div id="statusMessage" ></div>
<script type="text/javascript">
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Department Name"
	data_header[0][1] = "hide";
	data_header[0][2] = "25%";
	data_header[0][3] = "<%= DEPARTMENT_NAME%>"
	
	data_header[1] = new Array;
	data_header[1][0] = "Template Name"
	data_header[1][1] = "hide";
	data_header[1][2] = "40%";
	data_header[1][3] = "<%= TEMAPLATE_NAME %>";
	
	
	
	data_header[2] = new Array;
	data_header[2][0] = "Test Code"
	data_header[2][1] = "data";
	data_header[2][2] = "25%";
	data_header[2][3] = "chargeCodeCode"
	
	data_header[3] = new Array;
	data_header[3][0] = "Test Description"
	data_header[3][1] = "data";
	data_header[3][2] = "50%";
	data_header[3][3] = "chargeCodeName";
	
	
	
	data_header[4] = new Array;
	data_header[4][0] = "Clinical Notes"
	data_header[4][1] = "data";
	data_header[4][2] = "15%";
	data_header[4][3] = "<%= CLINICAL_NOTE%>"
	
	data_header[5] = new Array;
	data_header[5][0] = "Qty"
	data_header[5][1] = "data";
	data_header[5][2] = "15%";
	data_header[5][3] = "<%= QTY%>"
	
	
	
	data_header[6] = new Array;
	data_header[6][0] = ""
	data_header[6][1] = "hide";
	data_header[6][2] = 0;
	data_header[6][3] = "<%= CHANGED_BY%>"
	
	data_header[7] = new Array;
	data_header[7][0] = ""
	data_header[7][1] = "hide";
	data_header[7][2] = 0;
	data_header[7][3] = "<%= CHANGED_DATE%>"
	
	data_header[8] = new Array;
	data_header[8][0] = ""
	data_header[8][1] = "hide";
	data_header[8][2] = "15%";
	data_header[8][3] = "<%=CHANGED_TIME %>";
	
	
	data_header[9] = new Array;
	data_header[9][0] = "Charge Code Id"
	data_header[9][1] = "hide";
	data_header[9][2] = "15%";
	data_header[9][3] = "<%=CHARGE_CODE_ID %>";
	
	
	data_header[10] = new Array;
	data_header[10][0] = "Status"
	data_header[10][1] = "data";
	data_header[10][2] = "15%";
	data_header[10][3] = "<%=STATUS %>";
	
	
	
	data_arr = new Array();
	
	<%
				int  counter=0;
				Iterator iterator=showInvList.iterator();
			    while(iterator.hasNext())
			           {       
	
			        	  OpdTemplateInvestigation  opdTemplateInvestigation = (OpdTemplateInvestigation)iterator.next(); 
			%>
	
	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = "<%= opdTemplateInvestigation.getId()%>"
	
	<% if(opdTemplateInvestigation.getDepartment() != null){%>
	<%	Iterator itrGridDepartmentList = departmentList.iterator();
		 while(itrGridDepartmentList.hasNext())
	           {
	            MasDepartment masDepartment = (MasDepartment)itrGridDepartmentList.next(); 
			 if(opdTemplateInvestigation.getDepartment().getId().equals(masDepartment.getId()) && masDepartment.getStatus().equals("y")){
			 %>
				data_arr[<%= counter%>][1] = "<%=masDepartment.getDepartmentName()%>"
			<%}else if(opdTemplateInvestigation.getDepartment().getId().equals(masDepartment.getId()) && masDepartment.getStatus().equals("n")){%>
				data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=masDepartment.getDepartmentName()%>";
			<%}
	}	%>
	<%}%>
	
	<% if(opdTemplateInvestigation.getTemplate() != null){%>
	<%	Iterator itrGridTemplateList = opdTemplateList.iterator();
		 while(itrGridTemplateList.hasNext())
	           {
	            OpdTemplate opdTemplate = (OpdTemplate)itrGridTemplateList.next(); 
			 if(opdTemplateInvestigation.getTemplate().getId().equals(opdTemplate.getId()) && opdTemplate.getStatus().equals("y")){
			 %>
				data_arr[<%= counter%>][2] = "<%=opdTemplate.getTemplateName()%>"
			<%}else if(opdTemplateInvestigation.getTemplate().getId().equals(opdTemplate.getId()) && opdTemplate.getStatus().equals("n")){%>
				data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=opdTemplate.getTemplateName()%>";
			<%}
	}	%>
	<%}%>
	
		<% if(opdTemplateInvestigation.getChargeCode() != null){%>
	data_arr[<%= counter%>][3] ="<%= opdTemplateInvestigation.getChargeCode().getChargeCodeCode()%>";
		<%} else {%>
	data_arr[<%= counter%>][3] ="";
	<%}%>
		<% if(opdTemplateInvestigation.getChargeCode() != null){
		%>
	data_arr[<%= counter%>][4] ="<%= opdTemplateInvestigation.getChargeCode().getChargeCodeName()%>";
<%} else {%>
	data_arr[<%= counter%>][4] ="";
	<%}%>
	
	data_arr[<%= counter%>][5] = "<%= opdTemplateInvestigation.getClinicalNotes()%>"
	
	
	
	data_arr[<%= counter%>][6] =  "<%= opdTemplateInvestigation.getTemplateInvestigationQty()%>"
	

	data_arr[<%= counter%>][7] = "<%= opdTemplateInvestigation.getLastChgBy() %>"
	data_arr[<%= counter%>][8] = "<%= HMSUtil.convertDateToStringWithoutTime(opdTemplateInvestigation.getLastChgDate()) %>"
	data_arr[<%= counter%>][9] = "<%= opdTemplateInvestigation.getLastChgTime() %>"
	data_arr[<%= counter%>][10] ="<%= opdTemplateInvestigation.getChargeCode().getId()%>";
	<% if(opdTemplateInvestigation.getStatus().equals("y")){ %>
	data_arr[<%= counter%>][11] = "Active"
	<%}else{%>
	data_arr[<%= counter%>][11] = "InActive"
	<%}%>
	
		
	<%
			     counter++;
	}
	%>
formName = "OPDInves"

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<div class="Block">
<div class="clear"></div>
<input	type="hidden" size="2" value="0" class="smcaption" name="<%=CHARGE_CODE_ID%>" id="chargeCodeId" />
<label><span>*</span>  Test Code</label>
<input	type="text"  name="chargeCodeCode" id="chargeCodeCode" validate="Test Code And Description,string,yes" onmousedown="checkTestCode();" readonly />
<label><span>*</span>  Test Description </label>
<input type="text" value=""	validate=" Test Description,string,no" tabindex="1" id="chargeCodeName"	class="large" name="chargeCodeName" onblur="checkForChargeCodeCode(this.value);" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('chargeCodeName','ac2update','opdMaster?method=getChargeCodeList',{parameters:'requiredField=chargeCodeName'});
			</script>
			
<label><span>*</span>  Qty</label>
<input	type="text" id="qty" name="<%= QTY%>" value="1" validate="Qty,num,yes" MAXLENGTH="3" tabindex=1 />
<div class="clear"></div>
<label><span>*</span> Clinical Notes</label>
<textarea name="<%= CLINICAL_NOTE%>" id="clinical" cols="0" rows="4"  validate="Clinical Notes,string,yes" maxlength="300"	tabindex="1" onkeyup="return ismaxlength(this)"></textarea>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton"	value="Add" class="button"	onClick="submitForm('OPDInves','opdMaster?method=addOpdTemplateInvestigation');" accesskey="a" tabindex=1 />
	<input type="button" name="edit" style="display:none;" id="editbutton" value="Update" class="button"	onClick="submitForm('OPDInves','opdMaster?method=editOpdTemplateInvestigation')" accesskey="u" tabindex=1 />
	<input type="button" name="Delete"	style="display:none;" id="deletebutton" value="Activate" class="button"	onClick="submitForm('OPDInves','opdMaster?method=deleteOpdTemplateInvestigation&flag='+this.value)"	accesskey="d" tabindex=1 />
	<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="resetCheck();" accesskey="r"	tabindex=1 />
	<input type="button" name="Back" id="back" value="Back"	class="button" onClick="showPage('OPDInves');" accesskey="b" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<input type="hidden" name="<%= DEPARTMENT_ID%>" value="<%=deptId %>" />
<input type="hidden" name="<%= TEMPLATE_ID%>" value="<%=templateId %>" />

<div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName %></label>

<label>Changed Date</label>
<label class="value"><%=date%></label>

<label>Changed Time</label>
<label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
 <input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
 <input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
  	<input type="hidden" name="<%=HOSPITAL_ID %>"  value="<%=hospitalId%>" /> 
 <input	type="hidden" id="counter" value="<%=counter%>" />
</div>



</form>


