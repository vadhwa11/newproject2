
<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * opdTemplateTreatment.jsp  
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
<%@page import="jkt.hms.masters.business.OpdTemplateTreatment"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.OpdInstructionTreatment"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
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
	
	
	List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
	frequencyList = (List<MasFrequency>)map.get("frequencyList");
	

	List<OpdInstructionTreatment> opdInstructionTreatmentList = new ArrayList<OpdInstructionTreatment>();
	opdInstructionTreatmentList = (List<OpdInstructionTreatment>)map.get("opdInstructionTreatmentList");
	
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int templateId=0;
	
	templateId=(Integer)map.get("templateId");
	System.out.println("templateId in JSP" + templateId);
	
	int deptId=0;
	deptId=(Integer)map.get("deptId");
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
	
		List showList=new ArrayList();
		try {
					showList=(List)map.get("showList");
					System.out.println("Size of set -------"+showList.size());
	
			
		} catch (Exception exp) {
				
					exp.printStackTrace();
		}
		
	
	%>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<form name="testOPD" method="post">

<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>



<script type="text/javascript" language="javascript">
		
		
		formFields = [[0, "<%= COMMON_ID%>", "id"], [1,"<%= DEPARTMENT_NAME%>"], [2,"<%= TEMAPLATE_NAME %>"], [3,"<%= PVMS_NO %>"], [4,"<%= NOMENCLATURE_OPD %>"],[5,"<%= DOSAGE_CALCULATION%>"], [6,"<%= FREQUENCY %>"],[7,"<%= NO_OF_DAYS %>"],[8,"<%=TOTAL_AMOUNT%>"],[9,"<%=INSTRUCTIONS%>"],[10,"<%=CHANGED_BY%>"],[11,"<%=CHANGED_DATE%>"],[12,"<%=CHANGED_TIME%>"],[13,"<%=ITEM_ID%>"],[14,"<%=STATUS%>"] ];
		 statusTd = 14;
	
	</script>
	</div>
<div id="edited"></div>
<div id="statusMessage" class="messagelabel">
<div class="clear"></div>
</div>

<script type="text/javascript">
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "DEPARTMENT ID"
	data_header[0][1] = "hide";
	data_header[0][2] = "25%";
	data_header[0][3] = "<%= DEPARTMENT_NAME%>"
	
	data_header[1] = new Array;
	data_header[1][0] = "Template Name"
	data_header[1][1] = "hide";
	data_header[1][2] = "40%";
	data_header[1][3] = "<%= TEMAPLATE_NAME %>";
	
	
	
	data_header[2] = new Array;
	data_header[2][0] = "PVMS NO"
	data_header[2][1] = "data";
	data_header[2][2] = "25%";
	data_header[2][3] = "<%= PVMS_NO%>"
	
	data_header[3] = new Array;
	data_header[3][0] = "NOMENCLATURE"
	data_header[3][1] = "data";
	data_header[3][2] = "50%";
	data_header[3][3] = "<%= NOMENCLATURE_OPD %>";
	
	
	
	data_header[4] = new Array;
	data_header[4][0] = "DOSAGE"
	data_header[4][1] = "data";
	data_header[4][2] = "15%";
	data_header[4][3] = "<%= DOSAGE_CALCULATION%>"
	
	data_header[5] = new Array;
	data_header[5][0] = "FREQUENCY"
	data_header[5][1] = "data";
	data_header[5][2] = "15%";
	data_header[5][3] = "<%= FREQUENCY%>"
	
	data_header[6] = new Array;
	data_header[6][0] = "NO OF DAYS"
	data_header[6][1] = "data";
	data_header[6][2] = "15%";
	data_header[6][3] = "<%=NO_OF_DAYS %>";
	
	
	data_header[7] = new Array;
	data_header[7][0] = "TOTAL AMOUNT"
	data_header[7][1] = "data";
	data_header[7][2] = "15%";
	data_header[7][3] = "<%=TOTAL_AMOUNT%>";
	
	data_header[8] = new Array;
	data_header[8][0] = "INSTRUCTIONS "
	data_header[8][1] = "data";
	data_header[8][2] = "40%";
	data_header[8][3] = "<%= INSTRUCTIONS %>";
	
	data_header[9] = new Array;
	data_header[9][0] = ""
	data_header[9][1] = "hide";
	data_header[9][2] = 0;
	data_header[9][3] = "<%= CHANGED_BY%>"
	
	data_header[10] = new Array;
	data_header[10][0] = ""
	data_header[10][1] = "hide";
	data_header[10][2] = 0;
	data_header[10][3] = "<%= CHANGED_DATE%>"
	
	data_header[11] = new Array;
	data_header[11][0] = ""
	data_header[11][1] = "hide";
	data_header[11][2] = "15%";
	data_header[11][3] = "<%=CHANGED_TIME %>";
	
	data_header[12] = new Array;
	data_header[12][0] = "item Id"
	data_header[12][1] = "hide";
	data_header[12][2] = "15%";
	data_header[12][3] = "<%=ITEM_ID %>";
	
	data_header[13] = new Array;
	data_header[13][0] = "Status"
	data_header[13][1] = "data";
	data_header[13][2] = "15%";
	data_header[13][3] = "<%=STATUS %>";
	
	

	
	data_arr = new Array();
	
	<%
				int  counter=0;
				Iterator iterator=showList.iterator();
			    while(iterator.hasNext())
			           {       
	
			        	  OpdTemplateTreatment  opdTemplateTreatment = (OpdTemplateTreatment)iterator.next(); 
			%>
	
	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = "<%= opdTemplateTreatment.getId()%>"
	
	<% if(opdTemplateTreatment.getDepartment() != null){%>
	<%	Iterator itrGridDepartmentList = departmentList.iterator();
		 while(itrGridDepartmentList.hasNext())
	           {
	            MasDepartment masDepartment = (MasDepartment)itrGridDepartmentList.next(); 
			 if(opdTemplateTreatment.getDepartment().getId().equals(masDepartment.getId()) && masDepartment.getStatus().equals("y")){
			 %>
				data_arr[<%= counter%>][1] = "<%=masDepartment.getDepartmentName()%>"
			<%}else if(opdTemplateTreatment.getDepartment().getId().equals(masDepartment.getId()) && masDepartment.getStatus().equals("n")){%>
				data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=masDepartment.getDepartmentName()%>";
			<%}
	}	%>
	<%}%>
	
	<% if(opdTemplateTreatment.getTemplate() != null){%>
	<%	Iterator itrGridTemplateList = opdTemplateList.iterator();
		 while(itrGridTemplateList.hasNext())
	           {
	            OpdTemplate opdTemplate = (OpdTemplate)itrGridTemplateList.next(); 
			 if(opdTemplateTreatment.getTemplate().getId().equals(opdTemplate.getId()) && opdTemplate.getStatus().equals("y")){
			 %>
				data_arr[<%= counter%>][2] = "<%=opdTemplate.getTemplateName()%>"
			<%}else if(opdTemplateTreatment.getTemplate().getId().equals(opdTemplate.getId()) && opdTemplate.getStatus().equals("n")){%>
				data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=opdTemplate.getTemplateName()%>";
			<%}
	}	%>
	<%}%>
	
		<% if(opdTemplateTreatment.getItem() != null){%>
	data_arr[<%= counter%>][3] ="<%= opdTemplateTreatment.getItem().getPvmsNo()%>";
		<%} else {%>
	data_arr[<%= counter%>][3] ="";
	<%}%>
		<% if(opdTemplateTreatment.getItem() != null){
		System.out.println("opdTemplateTreatment.getItem().getNomenclature()-->"+opdTemplateTreatment.getItem().getNomenclature());
		%>
	data_arr[<%= counter%>][4] ="<%= opdTemplateTreatment.getItem().getNomenclature()%>";
<%} else {%>
	data_arr[<%= counter%>][4] ="";
	<%}%>
	
	data_arr[<%= counter%>][5] = "<%= opdTemplateTreatment.getDosage()%>"
	
	
	<% if(opdTemplateTreatment.getFrequency() != null){%>
	<%	Iterator itrGridFrequencyList = frequencyList.iterator();
		 while(itrGridFrequencyList.hasNext())
	           {
	            MasFrequency masFrequency = (MasFrequency)itrGridFrequencyList.next(); 
			 if(opdTemplateTreatment.getFrequency().getId().equals(masFrequency.getId()) && masFrequency.getStatus().equals("y")){
			 %>
				data_arr[<%= counter%>][6] = "<%=masFrequency.getFrequencyName()%>"
			<%}else if(opdTemplateTreatment.getFrequency().getId().equals(masFrequency.getId()) && masFrequency.getStatus().equals("n")){%>
				data_arr[<%= counter%>][6] = "<font id='error'>*</font>Parent InActivated--<%=masFrequency.getFrequencyName()%>";
			<%}
	}	%>
	<%}%>
	
	data_arr[<%= counter%>][7] =  "<%= opdTemplateTreatment.getNoofdays()%>"
	data_arr[<%= counter%>][8] =  "<%= opdTemplateTreatment.getTotal()%>"


	<% if(opdTemplateTreatment.getOpdInstructionTreatment() != null){%>
	<%	Iterator itrGridOpdInstructionTreatmentList = opdInstructionTreatmentList.iterator();
		 while(itrGridOpdInstructionTreatmentList.hasNext())
	           {
	            OpdInstructionTreatment opdInstructionTreatment = (OpdInstructionTreatment)itrGridOpdInstructionTreatmentList.next(); 
			 if(opdTemplateTreatment.getOpdInstructionTreatment().getId().equals(opdInstructionTreatment.getId()) && opdInstructionTreatment.getStatus().equals("y")){
			 %>
				data_arr[<%= counter%>][9] = "<%=opdInstructionTreatment.getOpdInstructionTreatmentName()%>"
			<%}else if(opdTemplateTreatment.getOpdInstructionTreatment().getId().equals(opdInstructionTreatment.getId()) && opdInstructionTreatment.getStatus().equals("n")){%>
				data_arr[<%= counter%>][9] = "<font id='error'>*</font>Parent InActivated--<%=opdInstructionTreatment.getOpdInstructionTreatmentName()%>";
			<%}
	}	%>
	<%}%>
	

	data_arr[<%= counter%>][10] = "<%= opdTemplateTreatment.getLastChgBy() %>"
	data_arr[<%= counter%>][11] = "<%= HMSUtil.convertDateToStringWithoutTime(opdTemplateTreatment.getLastChgDate()) %>"
	data_arr[<%= counter%>][12] = "<%= opdTemplateTreatment.getLastChgTime() %>"
	data_arr[<%= counter%>][13] ="<%= opdTemplateTreatment.getItem().getId()%>";
	<% if(opdTemplateTreatment.getStatus().equals("y")){ %>
	data_arr[<%= counter%>][14] = "Active"
	<%}else{%>
	data_arr[<%= counter%>][14] = "InActive"
	<%}%>
	
		
	<%
			     counter++;
	}
	%>
	 
	 
	 
	formName = "testOPD"
	
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start,end);
	
	intializeHover('searchresulttable', 'TR', ' tableover');		
	</script>



<div class="clear"></div>
<input type="hidden" size="2" value="0" name="<%=ITEM_ID%>" id="itemId" />
<div class="clear"></div>
<div class="Block">
<label><span>*</span>  PVMS No.</label>
<input type="text"	name="pvmsNo" id="pvmsNo"	validate="PVMS No.And Nomenclature ,string,yes" readonly onmousedown="checkPVMSNo();" />
<label><span>*</span> Nomenclature </label>
<input type="text" value=""	validate="Nomenclature,string,no" tabindex="1" id="nomenclature" class="large" name="nomenclature" onblur="checkForPVMS(this.value);" />
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclature','ac2update','opdMaster?method=getItemList',{parameters:'requiredField=nomenclature'});
			</script>

<div class="Clear"></div>
<label ><span>*</span>  Dosage</label>
<input type="text"	name="<%= DOSAGE_CALCULATION%>" id="<%= DOSAGE_CALCULATION%>" value="" validate="Dosage,string,yes" MAXLENGTH="5" tabindex=1 onblur="callTotal();"/>
<label><span>*</span>  Frequency </label>
<select id="frequency" name="<%=FREQUENCY%>" onchange="callTotal();" validate="Frequency,string,yes" onkeypress="return submitenter(this,event,'opdMaster?method=addOpdTemplateTreatment')"	tabindex=1 />
	<option value="0">Select</option>
	<%
								  	for (MasFrequency masFrequency : frequencyList) {
					  %>
	<option
		value="<%=masFrequency.getId()%>"><%=masFrequency.getFrequencyName()%></option>

	<%
					  		  				  	}
					  		  				  %>
</select>
<label>Instruction </label>
<select	name="<%=INSTRUCTIONS%>" validate="Instruction,string,no" onkeypress="return submitenter(this,event,'opdMaster?method=addOpdTemplateTreatment')" tabindex=1 />
	<option value="0">Select</option>
	<%
								  	for (OpdInstructionTreatment opdInstructionTreatment : opdInstructionTreatmentList) {
					  %>

	<option value="<%=opdInstructionTreatment.getId ()%>"><%=opdInstructionTreatment.getOpdInstructionTreatmentName()%></option>

	<%
					  		  				  	}
					  		  				  %>
</select>
<div class="clear"></div>
<label ><span>*</span>  No. of Days</label>
<input type="text" name="<%= NO_OF_DAYS%>" id="<%= NO_OF_DAYS%>" value=""	validate="No.Of Days,num,yes" MAXLENGTH="3" tabindex=1	onblur="callTotal();" />
<label class="common"><span>*</span> Total</label>
<input type="text" id="totalId" name="<%= TOTAL_AMOUNT%>" value=""	validate="Total,num,yes" MAXLENGTH="4" tabindex=1 readonly="readonly" />
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button"	onClick="submitForm('testOPD','opdMaster?method=addOpdTemplateTreatment');"	accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" style="display:none;" value="Update" class="button"	onClick="submitForm('testOPD','opdMaster?method=editOpdTemplateTreatment')"	accesskey="d" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" style="display:none;" class="button" onClick="submitForm('testOPD','opdMaster?method=deleteOpdTemplateTreatment&flag='+this.value)"accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset"	value="Reset" style="display:none;" class="button" onclick="resetCheck();" accesskey="r"	tabindex=1 />
<input type="button" name="Back" id="back" value="Back"	class="button" onClick="showPage('testOPD');" accesskey="b" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<input type="hidden" name="<%= DEPARTMENT_ID%>" value="<%=deptId %>" />
<input type="hidden" name="<%= TEMPLATE_ID%>" value="<%=templateId %>" />

<div class="clear"></div>

<div class="bottom">
<label>Changed By </label>
<label	class="value"><%=userName %></label>
<label>Changed Date </label>
<label class="value"><%=date%></label>
<label>Changed Time </label>
<label class="value"><%=time%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	<input type="hidden" name="<%=HOSPITAL_ID %>"  value="<%=hospitalId%>" /> 
<input type="hidden" id="counter" value="<%=counter%>" />
<div class="clear"></div>
</div>
</form>



