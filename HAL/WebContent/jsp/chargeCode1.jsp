<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * chargeCode1.jsp  
 * Purpose of the JSP -  This is for Charge Code
 * @author  Deepali
 * @author  Mansi
 * Create Date: 21th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.3 
--%>

<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasChargeType"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasSample"%>
<%@page import="jkt.hms.masters.business.MasSubTest"%>
<%@page import="jkt.hms.masters.business.MasUnitOfMeasurement"%>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<style type="text/css">
</style>
</HEAD>
<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0
	MARGINHEIGHT=0>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<div id="contentspace"><br />
<%  Date dateAndTime = null;
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	String message = "";
    int  counter=0;	
	if(map.get("errorMessageForExistence") != null && map.get("errorMessageForExistence") != "")
		 message = (String)map.get("errorMessageForExistence");
		 
	Map utilMap = new HashMap();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	Map  genericSearchMap=(Map)request.getAttribute("map");
	  	
	        ArrayList subChargeList = (ArrayList)genericSearchMap.get("searchSubChargeList");
		    ArrayList mainChargeList = (ArrayList)genericSearchMap.get("searchMainChargeList");
		    List<MasChargeCode> chargeCodeList = (List<MasChargeCode>)genericSearchMap.get("searchChargeCodeList");
		  	ArrayList departmentList = (ArrayList)genericSearchMap.get("searchDepartmentList");
		  	ArrayList chargeTypeList = (ArrayList)genericSearchMap.get("searchChargeTypeList");
		 	List searchSubTestList = (List)genericSearchMap.get("searchSubTestList");
		  	ArrayList sampleList = (ArrayList)genericSearchMap.get("searchSampleList");
		  	ArrayList unitOfMeasurementList = (ArrayList)genericSearchMap.get("searchUnitOfMeasurementList");
		  	session.setAttribute("unitOfResultMeasurementTypeFromCTDForSubTest",unitOfMeasurementList);
		  	
		  	
		  	
		  	
		  	
		  	
		  	String userName = "";
		  	if(session.getAttribute("userName") != null){
		  		userName = (String)session.getAttribute("userName");
		  	}

		  	if(map.get("message") != null){
		 	    message = (String)map.get("message");
		 	   out.println(message);
		 	  }
%>
<h2 align="left" class="style1">ChargeCode Master</h2>

<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action=""><input type="radio"
	name="<%=RequestConstants.SELECTED_RADIO  %>" value="1"
	checked="checked" /> <font class="bodytextB_blue">ChargeCode
Code:</font> <input type="radio" name="<%=RequestConstants.SELECTED_RADIO %>"
	value="2" /> <font class="bodytextB_blue">ChargeCode Name:</font> <input
	type="text" name="<%= RequestConstants.SEARCH_FIELD%>" value=""
	validate="ChargeCode Code,string,no" MAXLENGTH="8" tabindex=1 /> <input
	type="submit" name="search" value="Search" class="button"
	onclick="submitForm('search','hospital?method=searchChargeCode')"
	tabindex=1 /></form>

</div>

</div>

<br />
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<br />


<% 
			if(chargeCodeList.size() > 0 )
			 {
		     	String strForCode = (String)genericSearchMap.get("chargeCodeCode");
				String strForCodeName = (String)genericSearchMap.get("chargeCodeName");
				if(strForCode!= null && strForCode!= "" || strForCodeName!= null && strForCodeName!= "")
				 {
	%> <a href="/hms/hms/hospital?method=showChargeCodeJsp">Show All
Records</a> <%
				 }
			 }
			 if(chargeCodeList.size()== 0)
			  {
	%> <a href="/hms/hms/hospital?method=showChargeCodeJsp">Show All
Records</a> <%
			  }
	%> <script type="text/javascript">
<%--	if(location.href.indexOf('showChargeCodeJsp') == -1){
		document.write(' <a href="hospital?method=showChargeCodeJsp">Show All Records</a>');
	}	
--%>	formFields = [
	 			[0, "<%= RequestConstants.CHARGE_CODE_ID%>", "id"], [1,"<%= RequestConstants.CHARGE_CODE_CODE %>"], [2,"<%= RequestConstants.CHARGE_CODE_NAME %>"],[3,"<%= RequestConstants.CHARGE %>"], [4,"<%= RequestConstants.MAIN_CHARGECODE_ID%>"], [5,"<%= RequestConstants.SUB_CHARGECODE_ID%>"],[6,"<%= RequestConstants.CHARGE_TYPE_ID%>"],[7,"<%= RequestConstants.DEPARTMENT_ID%>"],[8,"<%=RequestConstants.SAMPLE_ID%>"],[9,"<%= RequestConstants.NORMAL_VALUE%>"],[10,"<%= RequestConstants.UNIT_OF_MEASUREMENT_ID%>"],[11,"<%= RequestConstants.CONFIDENTIAL%>"],[12,"<%= RequestConstants.DSICHARGE_SUMMARY%>"],[13,"addEditBy"],[14,"addEditOn"], [15,"<%=RequestConstants.STATUS%>"]
	    ];
	  statusTd = 15;
	</script></div>
<br />


<script type="text/javascript">
	
subtest_arr = new Array();
<%
			
			Iterator itr=searchSubTestList.iterator();
            int  counter1=0;
          while(itr.hasNext())
           {
             MasSubTest subTest = (MasSubTest)itr.next(); 


%>

subtest_arr[<%= counter1%>] = new Array();
subtest_arr[<%= counter1%>][0] = <%= subTest.getId()%>
subtest_arr[<%= counter1%>][1] = "<%=subTest.getSubTestCode()%>"
subtest_arr[<%= counter1%>][2] = "<%= subTest.getSubTestName()%>"
subtest_arr[<%= counter1%>][3] = "<%= subTest.getChargeCode().getId() %>"
subtest_arr[<%= counter1%>][4] = "<%= subTest.getNormalValue () %>"
subtest_arr[<%= counter1%>][5] = "<%= subTest.getUnitOfResult () %>"
subtest_arr[<%= counter1%>][6] = "<%= subTest.getStatus() %>"




<%
		     counter1++;
}
%>

function testForm(){
		alert(document.chargeCode.action)
		submitForm(chargeCode,contentspace,'/hms/hms/hospital?method=deleteSubTest');
		
	}
	

function deleteChargeCode(){
var subChargeId1=document.chargeCode.<%= RequestConstants.SUB_CHARGECODE_ID%>.options[document.chargeCode.<%= RequestConstants.SUB_CHARGECODE_ID%>.selectedIndex].text;
var mainChargeId1=document.chargeCode.<%= RequestConstants.MAIN_CHARGECODE_ID%>.options[document.chargeCode.<%= RequestConstants.MAIN_CHARGECODE_ID%>.selectedIndex].text;

 if(mainChargeId1=="Select"){
alert('Parent is InActivated!');
}
else{
deleteForm('chargeCode','/hms/hms/hospital?method=deleteChargeCode');
}
}	
</script>

<fieldset style="width: 90%"><legend>Add Charge Code</legend>
<form name="chargeCode" method="post" action=""><input
	type="hidden" name="<%= RequestConstants.POJO_NAME %>"
	value="MasChargeCode"> <input type="hidden"
	name="<%=RequestConstants.POJO_PROPERTY_NAME %>" value="ChargeCodeName">
<input type="hidden" name="title" value="ChargeCode"> <input
	type="hidden" name="<%=RequestConstants.JSP_NAME %>" value="chargeCode">
<input type="hidden" name="pojoPropertyCode" value="ChargeCodeCode">

<br>


<div id=contentoperation><label><font id="error">*</font>
Main Charge:</label> <select id="mainChargeName"
	name="<%=RequestConstants.MAIN_CHARGECODE_ID %>"
	validate="Main Charge,string,yes"
	onChange="populateSubCharge(this.value,'chargeCode')">
	<option value="">Select</option>
	<%
           		if(mainChargeList != null){ 	
           			for (Iterator iter = mainChargeList.iterator(); iter.hasNext();) {
           				MasMainChargecode mainCharge = (MasMainChargecode) iter.next();
           %>
	<option value="<%=mainCharge.getId() %>"><%=mainCharge.getMainChargecodeName() %></option>
	<%		
          			}
          		 } 
          %>
</select> <script type="text/javascript">
          subChargeArray = new Array();
		<%
			int count = 0;
			for (Iterator iter = mainChargeList.iterator(); iter.hasNext();) 
			{
				MasMainChargecode mainCharge = (MasMainChargecode) iter.next();
				for (Iterator iterSubCharge = subChargeList.iterator(); iterSubCharge.hasNext();) 
				{
					MasSubChargecode subCharge = (MasSubChargecode) iterSubCharge.next();
					if(mainCharge.getId().equals(subCharge.getMainChargecode().getId())){
								%>
									subChargeArray[<%=count%>] = new Array();
									subChargeArray[<%=count%>][0] = <%=mainCharge.getId()%>;
									subChargeArray[<%=count%>][1] = <%=subCharge.getId()%>;									
									subChargeArray[<%=count%>][2] = "<%=subCharge.getSubChargecodeName()%>";

								<%
								count++;
						}
					}
				}
			
		%>
		</script> <label><font id="error">*</font> Sub Charge:</label> <select
	id="subChargeName" name="<%=RequestConstants.SUB_CHARGECODE_ID %>"
	validate="Sub Charge,string,yes">
	<option value="">Select</option>
	<%
           		if(subChargeList != null){ 	
           			for (Iterator iter = subChargeList.iterator(); iter.hasNext();) {
           				MasSubChargecode subCharge = (MasSubChargecode) iter.next();
           %>
	<option value="<%=subCharge.getId() %>"><%=subCharge.getSubChargecodeName() %></option>
	<%		
          			}
          		 } 
          %>
</select> <br />

<label><font id="error">*</font> Charge Type:</label> <select
	id="chargeTypeName" name="<%=RequestConstants.CHARGE_TYPE_ID %>"
	validate="Charge Type,string,yes">
	<option value="">Select</option>
	<%
           		if(chargeTypeList != null){ 	
           			for (Iterator iter = chargeTypeList.iterator(); iter.hasNext();) {
           				MasChargeType chargeType = (MasChargeType) iter.next();
           %>
	<option value="<%=chargeType.getId() %>"><%=chargeType.getChargeTypeName() %></option>
	<%		
          			}
          		 } 
          %>
</select> <label><font id="error">*</font> Department:</label> <select
	id="depName" name="<%=RequestConstants.DEPARTMENT_ID %>"
	validate="Department,string,yes">
	<option value="">Select</option>
	<%
           		if(departmentList != null){ 	
           			for (Iterator iter = departmentList.iterator(); iter.hasNext();) {
           				MasDepartment department = (MasDepartment) iter.next();
           %>
	<option value="<%=department.getId() %>"><%=department.getDepartmentName() %></option>
	<%		
          			}
          		 } 
          %>
</select> <br />

<label><font id="error"></font> Sample :</label> <select
	name="<%=RequestConstants.SAMPLE_ID %>" validate="Sample,string,no">
	<option value="">Select</option>
	<%
           		if(sampleList != null){ 	
           			for (Iterator iter = sampleList.iterator(); iter.hasNext();) {
           				MasSample sample = (MasSample) iter.next();
           %>
	<option value="<%=sample.getId() %>"><%=sample.getSampleDescription() %></option>
	<%		
          			}
          		 } 
          %>
</select> <br />
<br />

<label><font id="error">*</font> Charge Code:</label> <input type="text"
	name="<%= RequestConstants.CHARGE_CODE_CODE %>" value=""
	validate="Charge Code,string,yes" class="textbox_size20" maxlength="8" />
<label><font id="error">*</font>Charge Name:</label> <input type="text"
	name="<%= RequestConstants.CHARGE_CODE_NAME %>" value=""
	validate="Charge Name,string,yes" class="textbox_size20" maxlength="30" /><br />

<label><font id="error">*</font> Charge:</label> <input type="text"
	name="<%= RequestConstants.CHARGE %>" value=""
	validate="Charge,num,yes" class="textbox_size20" maxlength="8" /><br />
<br />

<label><font id="error"></font> Normal Value:</label> <input type="text"
	name="<%= RequestConstants.NORMAL_VALUE%>" value=""
	validate="Normal Value,string,no" class="textbox_size20" maxlength="10" />

<label><font id="error"></font>Unit Of Result:</label> <select
	name="<%=RequestConstants.UNIT_OF_MEASUREMENT_ID %>"
	validate="Unit Of Result,string,no">
	<option value="">Select</option>
	<%
           		if(unitOfMeasurementList != null){ 	
           			for (Iterator iter = unitOfMeasurementList.iterator(); iter.hasNext();) {
           				MasUnitOfMeasurement unitOfMeasurement = (MasUnitOfMeasurement) iter.next();
           %>
	<option value="<%=unitOfMeasurement.getId() %>"><%=unitOfMeasurement.getUnitOfMeasurementName() %></option>
	<%		
          			}
          		 } 
          %>
</select> <br />

<label>Confidential:</label> <input type="checkbox"
	name="<%= RequestConstants.CONFIDENTIAL%>" value="1" class="checkbox" />
<label>&nbsp;</label> <br />
<label>Appear in discharge Summary:</label> <input type="checkbox"
	name="<%= RequestConstants.DSICHARGE_SUMMARY%>" value="1"
	class="checkbox" /><br />


<input name=<%=RequestConstants.CHANGED_BY%> type="hidden"
	value="<%=userName %>" class="textbox_size20_disb" readonly="readonly"
	tabindex="1"> <input name=<%=RequestConstants.CHANGED_DATE%>
	type="hidden" value="<%=date%>" class="textbox_size20_disb"
	readonly="readonly" tabindex="1"> <input
	name=<%=RequestConstants.CHANGED_TIME%> type="hidden" value="<%=time%>"
	class="textbox_size20_disb" readonly="readonly" tabindex="1"> <label>Multiple
Results:</label> <input type="checkbox" name="multipleresults" value="1"
	class="checkbox" onclick="multipleResults(this);" /><br />

</div>
<br>
<div id="edited"></div>
<br>
<label>&nbsp;</label> <input type="button" name="multiple"
	id="multiplebutton" value="Multiple Results" style="display: none"
	class="buttonbig" onClick="checkMultiple()" accesskey="m" /> <input
	type="button" class="button" id="addbutton" name="add" value="Add"
	onClick="submitForm('chargeCode','/hms/hms/hospital?method=addChargeCode');"
	accesskey="a" /> <input type="button" name="edit" id="editbutton"
	value="Update" class="button" onClick="checkMainChargeForUpdate()"
	accesskey="u" /> <input type="button" name="Delete" id="deletebutton"
	value="InActivate" class="button" onClick="deleteChargeCode()"
	accesskey="d" /> <input type="reset" name="Reset" value="Reset"
	class="button" accesskey="r" onclick="clearRecords(this)" /> <input
	type="hidden" name="<%= RequestConstants.CHARGE_CODE_ID%>" value="" />
<input type="hidden" name="<%= RequestConstants.STATUS %>" value="" />
<input type="hidden" name="subTest" value="" /></form>
</fieldset>
</div>



<script type="text/javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Charge Code"
data_header[0][1] = "data";
data_header[0][2] = 0;
data_header[0][3] = "<%= RequestConstants.CHARGE_CODE_CODE %>"

data_header[1] = new Array;
data_header[1][0] = "Charge Name"
data_header[1][1] = "data";
data_header[1][2] = 0;
data_header[1][3] = "<%= RequestConstants.CHARGE_CODE_NAME%>";

data_header[2]=new Array;
data_header[2][0]="Charge"
data_header[2][1]="data";
data_header[2][2]=0;
data_header[2][3]="<%= RequestConstants.CHARGE%>";

data_header[3]=new Array;
data_header[3][0]="Main Charge"
data_header[3][1]="data";
data_header[3][2]=0;
data_header[3][3]="<%= RequestConstants.MAIN_CHARGECODE_ID%>";

data_header[4]=new Array;
data_header[4][0]="Sub Charge"
data_header[4][1]="data";
data_header[4][2]=0;
data_header[4][3]="<%= RequestConstants.SUB_CHARGECODE_ID%>";

data_header[5]=new Array;
data_header[5][0]="Charge Type"
data_header[5][1]="data";
data_header[5][2]=0;
data_header[5][3]="<%= RequestConstants.CHARGE_TYPE_ID%>";

data_header[6]=new Array;
data_header[6][0]="Department"
data_header[6][1]="data";
data_header[6][2]=0;
data_header[6][3]="<%= RequestConstants.DEPARTMENT_ID%>";

data_header[7]=new Array;
data_header[7][0]="Sample"
data_header[7][1]="hide";
data_header[7][2]=0;
data_header[7][3]="<%= RequestConstants.SAMPLE_ID%>";

data_header[8]=new Array;
data_header[8][0]="Normal Value"
data_header[8][1]="hide";
data_header[8][2]=0;
data_header[8][3]="<%= RequestConstants.NORMAL_VALUE%>";

data_header[9]=new Array;
data_header[9][0]="Unit Of Result"
data_header[9][1]="hide";
data_header[9][2]=0;
data_header[9][3]="<%= RequestConstants.UNIT_OF_MEASUREMENT_ID%>";

data_header[10]=new Array;
data_header[10][0]="Confidential"
data_header[10][1]="hide";
data_header[10][2]=0;
data_header[10][3]="<%= RequestConstants.CONFIDENTIAL %>";

data_header[11]=new Array;
data_header[11][0]="Appear In Discharge Summary"
data_header[11][1]="hide";
data_header[11][2]=0;
data_header[11][3]="<%= RequestConstants.DSICHARGE_SUMMARY%>";

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "addEditBy"

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = 0;
data_header[13][3] = "addEditOn"


data_header[14] = new Array;
data_header[14][0] = "Status"
data_header[14][1] = "data";
data_header[14][2] = 0;
data_header[14][3] = "<%= RequestConstants.STATUS %>"

data_arr = new Array();
<% 

	Map<Integer,MasChargeType> chargeTypeMap = new HashMap<Integer,MasChargeType>();
			for(int i=0;i<chargeTypeList.size();i++)
		{
				chargeTypeMap.put(((MasChargeType)chargeTypeList.get(i)).getId(),(MasChargeType)chargeTypeList.get(i));
		}			


	Map<Integer,MasDepartment> departmentMap = new HashMap<Integer,MasDepartment>();
		for(int i=0;i<departmentList.size();i++)
		{
				departmentMap.put(((MasDepartment)departmentList.get(i)).getId(),(MasDepartment)departmentList.get(i));
		}					
		
     Map<Integer,MasMainChargecode> mainChargeMap = new HashMap<Integer,MasMainChargecode>() ;
       
         
        for(int i=0;i<mainChargeList.size();i++)
		{
				mainChargeMap.put(((MasMainChargecode)mainChargeList.get(i)).getId(),(MasMainChargecode)mainChargeList.get(i));
		}
        Iterator itrCC=chargeCodeList.iterator();
        counter=0;
          while(itrCC.hasNext())
           {
             MasChargeCode  chargeCode = (MasChargeCode)itrCC.next(); 
			String inActive = "";
 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= chargeCode.getId()%>
data_arr[<%= counter%>][1] = "<%=chargeCode.getChargeCodeCode()%>"
data_arr[<%= counter%>][2] = "<%= chargeCode.getChargeCodeName()%>"
data_arr[<%= counter%>][3]="<%= chargeCode.getCharge()%>"   
<%

inActive = "";
if((mainChargeMap.get(chargeCode.getMainChargecode().getId())).getStatus().equals("n")){
   inActive = "<font id='error'>*</font>";
 }
%> 

data_arr[<%= counter%>][4]  = "<%=inActive%><%=(mainChargeMap.get(chargeCode.getMainChargecode().getId())).getMainChargecodeName()%>"
<%

inActive = "";
if(chargeCode.getSubChargecode().getStatus().equals("n")){
   inActive = "<font id='error'>*</font>";
 }
%> 
 
data_arr[<%= counter%>][5]  ="<%=inActive%><%=chargeCode.getSubChargecode().getSubChargecodeName()%>"

	
		<%
			            
	   inActive = "";
if( (chargeTypeMap.get(chargeCode.getChargeType().getId())).getStatus().equals("n")){
   inActive = "<font id='error'>*</font>";
 }
	             
	    %>         
	             
	             
         data_arr[<%= counter%>][6] ="<%=inActive%><%=(chargeTypeMap.get(chargeCode.getChargeType().getId())).getChargeTypeName()%>"
			 	
				
<%

inActive = "";
if( (departmentMap.get(chargeCode.getDepartment().getId())).getStatus().equals("n")){
   inActive = "<font id='error'>*</font>";
 }

%> 								
				
			data_arr[<%= counter%>][7]  ="<%=inActive%><%=(departmentMap.get(chargeCode.getDepartment().getId())).getDepartmentName()%>"

				  
		
	<%
			 Iterator itrSampleForPrintingList=sampleList.iterator();
		 	    while(itrSampleForPrintingList.hasNext())
        	   {
        	   
            	 MasSample  sample = (MasSample)itrSampleForPrintingList.next(); 
				   if(chargeCode.getSample().getId()!=null && sample.getId().compareTo(chargeCode.getSample().getId())==0)
            	 {
	             %>
    	         data_arr[<%= counter%>][8] ="<%=chargeCode.getSample().getId()%>"
			 	<%}
				  }
				%>	
			
			<%
				String strForNormalValue = chargeCode.getNormalValue();
			
				if(strForNormalValue==null)
				 {
				    strForNormalValue = "";
				 }
				
			%>
			
							
			data_arr[<%= counter%>][9] ="<%= strForNormalValue %>"
		
<% 
		Iterator itrUnitOfMeasurementForPrintingList=unitOfMeasurementList.iterator();
	 	       while(itrUnitOfMeasurementForPrintingList.hasNext())
        	   {
        	  	 MasUnitOfMeasurement  unitOfMeasurement = (MasUnitOfMeasurement)itrUnitOfMeasurementForPrintingList.next(); 
        	  	 if(chargeCode.getUnitOfMeasurement().getId()== null)
        	  	  {
        	 %>
        	 data_arr[<%= counter%>][10]= ""
        	 
        	 <% } else { 
            	 
            	 
            	 Integer unitOfResultIdInInteger = Integer.valueOf(chargeCode.getUnitOfMeasurement().getId());  
               	 if(unitOfMeasurement.getId().compareTo(unitOfResultIdInInteger)==0)
            	  {%>
            	 	data_arr[<%= counter%>][10] ="<%=unitOfMeasurement.getUnitOfMeasurementName ()%>"
		<%}}}%>	

		
			data_arr[<%= counter%>][11] ="<%= chargeCode.getConfidential()%>"
			data_arr[<%= counter%>][12] ="<%= chargeCode.getAppearInDischargeSummary() %>"				
			data_arr[<%= counter%>][13] ="<%= chargeCode.getLastChgBy() %> "	
			
			
<%
	dateAndTime = chargeCode.getLastChgDate ();
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(dateAndTime);
	
	StringBuffer dateTimeOnly = new StringBuffer();
			   
	int dateOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
	int month=0,year=0,hour=0,minute =0,second=0;
	int amPm = 0;
						  
						  
	 if(dateOfMonth<10)
	   {
			dateTimeOnly.append("0");
	   		dateTimeOnly.append(dateOfMonth);
	   }
	 else
	   {
			dateTimeOnly.append(dateOfMonth);
	   }
			   
		   dateTimeOnly.append("/");
			   
		   month = calendar.get(Calendar.MONTH)+1;
	  if(month<10)
		{
			dateTimeOnly.append("0");
			dateTimeOnly.append(month);
		 }
	 else
		{
	  		dateTimeOnly.append(month);
	    }	
			   
	   dateTimeOnly.append("/");
	   year = calendar.get(Calendar.YEAR);
	   dateTimeOnly.append(year);
	   
	   dateTimeOnly.append("      ");
	   
	  
	 String currentDate = new String(dateTimeOnly);

%>

			data_arr[<%= counter%>][14] ="<%=currentDate %> , <%= chargeCode.getLastChgTime() %> "		
			
				
			<% if(chargeCode.getStatus().equals("y")){ 
			%>
			data_arr[<%= counter%>][15] = "Active"
			<%}else{%>
			data_arr[<%= counter%>][15] = "InActive"
			<%}%>
				
<%
		     counter++;
}
%>			


function checkMainChargeForUpdate(){
var mainChargeForUpdateButton=document.chargeCode.<%= RequestConstants.MAIN_CHARGECODE_ID%>.options[document.chargeCode.<%= RequestConstants.MAIN_CHARGECODE_ID%>.selectedIndex].text;
var subChargeForUpdateButton=document.chargeCode.<%= RequestConstants.SUB_CHARGECODE_ID%>.options[document.chargeCode.<%= RequestConstants.SUB_CHARGECODE_ID%>.selectedIndex].text;
	if(mainChargeForUpdateButton != "Select" ){
		editForm('chargeCode','/hms/hms/hospital?method=editChargeCode')
	}else{
	alert("Parent is InActivated!")
	}
}

formName = "chargeCode"
nonEditable = ['<%= RequestConstants.CHARGE_CODE_CODE %>'];
start = 0

if(data_arr.length < rowsPerPage)
{
	end = data_arr.length;
}else{
	end = rowsPerPage;
	}

makeTable(start,end);
nonEditable = ['<%= RequestConstants.MAIN_CHARGECODE_ID%>']


intializeHover('searchresulttable', 'TR', ' tableover');

</script>