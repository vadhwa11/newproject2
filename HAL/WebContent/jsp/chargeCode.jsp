<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * chargeCode.jsp  
 * Purpose of the JSP -  This is for Charge Code (Disease Type)
 * @author  Deepali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.11  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasChargeType"%>
<%@page import="jkt.hms.masters.business.MasSubTest"%>
<%@page import="jkt.hms.masters.business.MasSample"%>
<%@page import="jkt.hms.masters.business.MasUnitOfMeasurement"%>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	
	ArrayList  <MasSubChargecode> subChargecodeList = new ArrayList<MasSubChargecode>();
	subChargecodeList = (ArrayList)map.get("subChargecodeList");
	
	ArrayList  <MasMainChargecode> mainChargecodeList = new ArrayList<MasMainChargecode>();
	mainChargecodeList = (ArrayList)map.get("mainChargecodeList");
	
	
	List<MasChargeCode> searchChargeCodeList = new ArrayList<MasChargeCode>();
	searchChargeCodeList=(List)map.get("searchChargeCodeList");
	
	ArrayList<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	departmentList=(ArrayList)map.get("departmentList");
	
	ArrayList<MasChargeType> chargeTypeList = new ArrayList<MasChargeType> ();
	chargeTypeList=(ArrayList)map.get("chargeTypeList");
	
	List<MasSubTest> subTestList = new ArrayList<MasSubTest>();
	subTestList=(ArrayList)map.get("subTestList");
	
	ArrayList<MasSample> sampleList = new ArrayList<MasSample>();
	sampleList=(ArrayList)map.get("sampleList");
	
	ArrayList<MasUnitOfMeasurement> unitOfMeasurementList = new ArrayList<MasUnitOfMeasurement>();
	unitOfMeasurementList=(ArrayList)map.get("unitOfMeasurementList");
	
	session.setAttribute("unitOfResultMeasurementTypeFromCTDForSubTest",unitOfMeasurementList);

	String userName = "";
	if(session.getAttribute("userName") != null){
	  		userName = (String)session.getAttribute("userName");
	}
	int deptId =0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}

	int chargeTypeId =0;
	if(map.get("chargeTypeId") != null){
		chargeTypeId =(Integer) map.get("chargeTypeId");
	}
	int mainChargecodeId =0;
	if(map.get("mainChargecodeId") != null){
		mainChargecodeId =(Integer) map.get("mainChargecodeId");
	}
	int subChargecodeId =0;
	if(map.get("subChargecodeId") != null){
		subChargecodeId =(Integer) map.get("subChargecodeId");
	}
	String investigationName ="";
 	if(map.get("name") != null){
 		investigationName = (String)map.get("name");
 	}
 	int chargeCodeId =0;
 	if(map.get("chargeCodeId") != null){
 		chargeCodeId =(Integer) map.get("chargeCodeId");
	}
	String message ="";
 	if(map.get("message") != null){
 	message = (String)map.get("message");
		%> <label class="noWidth"><span><%=message %></span></label>
		 <%} %>
		  <%if(chargeTypeId == 2){%> <input type="button"
	class="button" value="Diagnostic" align="left"
	onClick="submitFormForButton('chargeCode','investigation?method=showInvestigationJsp&mainChargecodeId=<%=mainChargecodeId %>&subChargecodeId=<%=subChargecodeId %>&investigationName=<%=investigationName%>&chargeCodeId=<%=chargeCodeId %>');" />
<%}%> <%
	
	ArrayList gridSubChargecodeList = (ArrayList) map.get("gridSubChargecodeList");
	ArrayList gridMainChargecodeList = (ArrayList) map.get("gridMainChargecodeList");
	ArrayList gridDepartmentList = (ArrayList) map.get("gridDepartmentList");
	ArrayList gridChargeTypeList = (ArrayList) map.get("gridChargeTypeList");
	ArrayList gridSampleList = (ArrayList) map.get("gridSampleList");
	ArrayList gridSubTestList = (ArrayList) map.get("gridSubTestList");
	ArrayList gridUnitOfMeasurementList = (ArrayList) map.get("gridUnitOfMeasurementList");
	
	

%>
<div class="titleBg">
<h2>Test Master</h2>
</div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>Test Code</label><input type="radio" class="radioAuto"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> <label>Test
Name</label> <input type="radio" class="radioAuto"
	name="<%=SELECTED_RADIO %>" value="2" />  <input type="text" name="<%= SEARCH_FIELD%>" value=""
	validate="ChargeCode Code,string,no" MAXLENGTH="8" tabindex=1 /> <input
	type="submit" name="search" value="Search" class="button"
	onclick="submitForm('search','hospital?method=searchChargeCode')"
	tabindex=1 /> <%--- Report Button   --%> <input type="button"
	name="Report" value="Generate Report Based on Search" class="buttonBig3"
	onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');"
	accesskey="g" tabindex=1 /> <input type="hidden"
	name="<%=JASPER_FILE_NAME%>" value="Mas_charge_code"></div></form>
</div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<%
	if (searchChargeCodeList.size() > 0 ) {
		String strForCode = (String) map.get("chargeCodeCode");
		String strForCodeDescription = (String) map.get("chargeCodeName");
		if (strForCode != null && strForCode != "" || strForCodeDescription != null	&& strForCodeDescription != "") {
%> 
<h4><a href="hospital?method=showChargeCodeJsp">Show All Records</a></h4> <%
 	}
 	}
 if(searchChargeCodeList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="hospital?method=showChargeCodeJsp">Show All Records</a></h4> <%
    }
	%> <script type="text/javascript">
	
	formFields = [
	 			[0, "<%= CHARGE_CODE_ID%>", "id"], [1,"<%= CHARGE_CODE_CODE %>"], [2,"<%= CHARGE_CODE_NAME %>"],[3,"<%= CHARGE %>"], [4,"<%= MAIN_CHARGECODE_ID%>"], [5,"<%= SUB_CHARGECODE_ID%>"],[6,"<%= CHARGE_TYPE_ID%>"],[7,"<%= DEPARTMENT_ID%>"],[8,"<%= NORMAL_VALUE%>"],[9,"<%= CONFIDENTIAL%>"],[10,"<%= DSICHARGE_SUMMARY%>"],[11,"addEditBy"],[12,"addEditOn"], [13,"<%=STATUS%>"]
	    ];
	  statusTd = 13;
	</script></div>


<script type="text/javascript">
	
subtest_arr = new Array();
<%
			
			Iterator itr=subTestList.iterator();
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
		submitForm(chargeCode,contentHolder,'/hms/hms/hospital?method=deleteSubTest');
		
	}
	

function deleteChargeCode(){
var subChargeId1=document.chargeCode.<%= SUB_CHARGECODE_ID%>.options[document.chargeCode.<%= SUB_CHARGECODE_ID%>.selectedIndex].text;
var mainChargeId1=document.chargeCode.<%= MAIN_CHARGECODE_ID%>.options[document.chargeCode.<%= MAIN_CHARGECODE_ID%>.selectedIndex].text;

 if(mainChargeId1=="Select"){
alert('Parent is InActivated!');
}
else{
deleteForm('chargeCode','/hms/hms/hospital?method=deleteChargeCode');
}
}	
</script>

<form name="chargeCode" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasChargeCode"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="ChargeCodeName">
<input type="hidden" name="title" value="ChargeCode"> <input
	type="hidden" name="<%=JSP_NAME %>" value="chargeCode"> <input
	type="hidden" name="pojoPropertyCode" value="ChargeCodeCode"> 


<div class="Clear"></div>
<div class="Block">
<label> Main Type<span>*</span> </label> <select id="mainChargeName"
	name="<%=MAIN_CHARGECODE_ID %>" validate="Main Chargecode,string,yes"
	onChange="populateSubChargeCode(this.value,'chargeCode')" tabindex=1>
	<option value="">Select</option>
	<% 
				
				for (MasMainChargecode mainChargecode : mainChargecodeList){
				%>

	<option value="<%=mainChargecode.getId ()%>"><%=mainChargecode.getMainChargecodeName()%></option>

	<%}%>

</select> <script type="text/javascript">
          subChargeArray1 = new Array();
		<%
			int count = 0;
			for (Iterator iter = mainChargecodeList.iterator(); iter.hasNext();) 
			{
				MasMainChargecode mainChargecode = (MasMainChargecode) iter.next();
				for (Iterator iterSubChargecode = subChargecodeList.iterator(); iterSubChargecode.hasNext();) 
				{
					MasSubChargecode subChargecode = (MasSubChargecode) iterSubChargecode.next();
					if(mainChargecode.getId().equals(subChargecode.getMainChargecode().getId())){
								%>
									subChargeArray1[<%=count%>] = new Array();
									subChargeArray1[<%=count%>][0] = <%=mainChargecode.getId()%>;
									subChargeArray1[<%=count%>][1] = <%=subChargecode.getId()%>;									
									subChargeArray1[<%=count%>][2] = "<%=subChargecode.getSubChargecodeName()%>";

								<%
								count++;
						}
					}
				}
			
		%>
		</script> <label>  Sub
Type<span>*</span> </label> <select id="subChargeName" name="<%=SUB_CHARGECODE_ID %>"
	validate="Sub Chargecode Name,string,yes" tabindex=1>
	<option value="">Select</option>
	<% 
				
				for (MasSubChargecode subChargecode : subChargecodeList){
				%>

	<option value="<%=subChargecode.getId ()%>"><%=subChargecode.getSubChargecodeName()%></option>

	<%}%>

</select> <label> Test Type <span>*</span></label>
<select id="chargeTypeName" name="<%=CHARGE_TYPE_ID %>"
	validate="Charge Type,string,yes" tabindex=1>
	<option value="">Select</option>

	<% 
				
				for (MasChargeType chargeType : chargeTypeList){
				%>

	<option value="<%=chargeType.getId ()%>"><%=chargeType.getChargeTypeName()%></option>

	<%}%>

</select> 
<div class="Clear"></div>
<label> Department
Name <span>*</span> </label> <select id="depName" name="<%=DEPARTMENT_ID %>"
	validate="Department Name,string,yes" tabindex=1>
	<option value="">Select</option>
	<% 
				
				for (MasDepartment department : departmentList){
				%>

	<option value="<%=department.getId ()%>"><%=department.getDepartmentName()%></option>

	<%}%>


</select> <script type="text/javascript">
				document.getElementById('depName').value='<%=deptId%>';
			</script> <label> Test
Code <span>*</span> </label> <input type="text " name="<%= CHARGE_CODE_CODE%>" value=""
	validate="Charge Code,string,yes"  MAXLENGTH="8"
	/ tabindex=1>

<label> Test
Name<span>*</span></label>
<input type="text" name="<%= CHARGE_CODE_NAME %>" value=""
	validate="Charge Name,string,yes"  MAXLENGTH="300"
	/ tabindex=1> <script>document.chargeCode.<%=CHARGE_CODE_CODE%>.focus(); </script>

<label>Charge<span>*</span> </label>
<input type="text"	name="<%= CHARGE %>" value="" validate="Charge,floatWithoutSpaces,yes"	 maxlength="8" />


<!--  <span>Normal Value:</span>--> <input
	type="hidden" name="<%= NORMAL_VALUE%>" value=""
	validate="Normal Value,string,no"  maxlength="10" />



<!--  <span>Confidential:</span> --> <input
	type="hidden" name="<%= CONFIDENTIAL%>" value="1" class="radio"  />

<!--<span> Appear in discharge Summary:</span>   -->
<input type="hidden" name="<%= DSICHARGE_SUMMARY%>" value="1"
class="radio" /></div>
<div class="Clear"></div>
<div id="edited"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="multiple" id="multiplebutton"
	value="Multiple Results" style="display: none" class="buttonbig"
	onClick="checkMultiple()" accesskey="m" />
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('chargeCode','hospital?method=addChargeCode');"
	accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update"
	class="button"
	onClick="submitForm('chargeCode','hospital?method=editChargeCode','checkMainChargeForUpdate()')"
	accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate"
	class="button"
	onClick="submitForm('chargeCode','hospital?method=deleteChargeCode&flag='+this.value,'deleteChargeCode()')"
	accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="button"
	accesskey="r" onclick="resetCheck();" tabindex=1 />
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= CHARGE_CODE_ID%>" value="" />

<input type="hidden" name="subTest" value="" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName%></label>

<label>Changed Date:</label>
<label class="value"><%=date%></label>

<label>Changed Time:</label>
<label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>
</div>

<script type="text/javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Test Code"
data_header[0][1] = "data";
data_header[0][2] = 0;
data_header[0][3] = "<%= CHARGE_CODE_CODE %>"

data_header[1] = new Array;
data_header[1][0] = "Test Name"
data_header[1][1] = "data";
data_header[1][2] = 0;
data_header[1][3] = "<%= CHARGE_CODE_NAME%>";

data_header[2]=new Array;
data_header[2][0]="Charge"
data_header[2][1]="data";
data_header[2][2]=0;
data_header[2][3]="<%= CHARGE%>";

data_header[3]=new Array;
data_header[3][0]="Main Type"
data_header[3][1]="data";
data_header[3][2]=0;
data_header[3][3]="<%= MAIN_CHARGECODE_ID%>";

data_header[4]=new Array;
data_header[4][0]="Sub Type"
data_header[4][1]="data";
data_header[4][2]=0;
data_header[4][3]="<%= SUB_CHARGECODE_ID%>";

data_header[5]=new Array;
data_header[5][0]="Test Type"
data_header[5][1]="data";
data_header[5][2]=0;
data_header[5][3]="<%= CHARGE_TYPE_ID%>";

data_header[6]=new Array;
data_header[6][0]="Department"
data_header[6][1]="data";
data_header[6][2]=0;
data_header[6][3]="<%= DEPARTMENT_ID%>";

data_header[7]=new Array;
data_header[7][0]="Normal Value"
data_header[7][1]="hide";
data_header[7][2]=0;
data_header[7][3]="<%= NORMAL_VALUE%>";

data_header[8]=new Array;
data_header[8][0]="Confidential"
data_header[8][1]="hide";
data_header[8][2]=0;
data_header[8][3]="<%= CONFIDENTIAL %>";

data_header[9]=new Array;
data_header[9][0]="Appear In Discharge Summary"
data_header[9][1]="hide";
data_header[9][2]=0;
data_header[9][3]="<%= DSICHARGE_SUMMARY%>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "addEditBy"

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "addEditOn"


data_header[12] = new Array;
data_header[12][0] = "Status"
data_header[12][1] = "data";
data_header[12][2] = 0;
data_header[12][3] = "<%= STATUS %>"

data_arr = new Array();
<% 

        Iterator itrCC=searchChargeCodeList.iterator();
        int  counter=0;
          while(itrCC.hasNext())
           {
             MasChargeCode  masChargeCode = (MasChargeCode)itrCC.next(); 
      //       if(masChargeCode.getDepartment().getId()== deptId){
 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masChargeCode.getId()%>
data_arr[<%= counter%>][1] = "<%=masChargeCode.getChargeCodeCode()%>"
data_arr[<%= counter%>][2] = "<%= masChargeCode.getChargeCodeName()%>"
data_arr[<%= counter%>][3]="<%= masChargeCode.getCharge()%>" 



			
	<%
		Iterator itrGridMainChargeCodeList=gridMainChargecodeList.iterator();
		 while(itrGridMainChargeCodeList.hasNext())
            {
			 try
			 {
             MasMainChargecode  mainChargecodeGrid = (MasMainChargecode)itrGridMainChargeCodeList.next(); 
			 if(masChargeCode.getMainChargecode().getId().equals(mainChargecodeGrid.getId()) && mainChargecodeGrid.getStatus().equals("y"))
			 {
			 %>
				
				data_arr[<%= counter%>][4] = "<%=mainChargecodeGrid.getMainChargecodeName()%>"
				
			<%
			}
			 else if(masChargeCode.getId().equals(mainChargecodeGrid.getId()) && mainChargecodeGrid.getStatus().equals("n"))
			{
			%>
			
				data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=mainChargecodeGrid.getMainChargecodeName()%>";
				
			<%
			}
           }
			catch(Exception e)
			{
				System.out.println("ssssssss "+e);
			} }%>		
			

<%
		Iterator itrGridSubChargeCodeList=gridSubChargecodeList.iterator();
		 while(itrGridSubChargeCodeList.hasNext())
            {
			 try
			 {
             MasSubChargecode  subChargecodeGrid = (MasSubChargecode)itrGridSubChargeCodeList.next(); 
			 if(masChargeCode.getSubChargecode().getId().equals(subChargecodeGrid.getId()) && subChargecodeGrid.getStatus().equals("y"))
			 {
			 %>
				
				data_arr[<%= counter%>][5] = "<%=subChargecodeGrid.getSubChargecodeName()%>"
				
			<%
			}
			 else if(masChargeCode.getId().equals(subChargecodeGrid.getId()) && subChargecodeGrid.getStatus().equals("n"))
			{
			%>
			
				data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=subChargecodeGrid.getSubChargecodeName()%>";
				
			<%
			}
           }
			catch(Exception e)
			{
				System.out.println("ssssssss "+e);
			} }%>
			
			
			<%
		Iterator itrGridChargeTypeList=gridChargeTypeList.iterator();
		 while(itrGridChargeTypeList.hasNext())
            {
			 try
			 {
             MasChargeType  chargeTypeGrid = (MasChargeType)itrGridChargeTypeList.next(); 
			 if(masChargeCode.getChargeType().getId().equals(chargeTypeGrid.getId()) && chargeTypeGrid.getStatus().equals("y"))
			 {
			 %>
				
				data_arr[<%= counter%>][6] = "<%=chargeTypeGrid.getChargeTypeName()%>"
				
			<%
			}
			 else if(masChargeCode.getId().equals(chargeTypeGrid.getId()) && chargeTypeGrid.getStatus().equals("n"))
			{
			%>
			
				data_arr[<%= counter%>][6] = "<font id='error'>*</font>Parent InActivated--<%=chargeTypeGrid.getChargeTypeName()%>";
				
			<%
			}
           }
			catch(Exception e)
			{
				System.out.println("ssssssss "+e);
			} }%>
			
			
			
			<%
		Iterator itrGridDepartmentList=gridDepartmentList.iterator();
		 while(itrGridDepartmentList.hasNext())
            {
			 try
			 {
             MasDepartment  departmentGrid = (MasDepartment)itrGridDepartmentList.next(); 
			 if(masChargeCode.getDepartment().getId().equals(departmentGrid.getId()) && departmentGrid.getStatus().equals("y"))
			 {
			 %>
				
				data_arr[<%= counter%>][7] = "<%=departmentGrid.getDepartmentName()%>"
				
			<%
			}
			 else if(masChargeCode.getDepartment().getId().equals(departmentGrid.getId()) && departmentGrid.getStatus().equals("n"))
			{
			%>
			
				data_arr[<%= counter%>][7] = "<font id='error'>*</font>Parent InActivated--<%=departmentGrid.getDepartmentName()%>";
				
			<%
			}
           }
			catch(Exception e)
			{
				System.out.println("ssssssss "+e);
			} }%>
			
			
		
		<%
				String strForNormalValue = masChargeCode.getNormalValue();
			
				if(strForNormalValue==null)
				 {
				    strForNormalValue = "";
				 }
				
			%>
			
							
			data_arr[<%= counter%>][8] ="<%= strForNormalValue %>"
		
		
			
			data_arr[<%= counter%>][9] ="<%= masChargeCode.getConfidential()%>"
			data_arr[<%= counter%>][10] ="<%= masChargeCode.getAppearInDischargeSummary() %>"				
			data_arr[<%= counter%>][11] ="<%= masChargeCode.getLastChgBy() %> "	
				<%if(masChargeCode.getLastChgDate()!=null){%>
			data_arr[<%= counter%>][12] = "<%= HMSUtil.convertDateToStringWithoutTime(masChargeCode.getLastChgDate()) %>"
				<%}%>
<% if(masChargeCode.getStatus().equals("y")){ %>
data_arr[<%= counter%>][13] = "Active"
<%}else{%>
data_arr[<%= counter%>][13] = "InActive"
<%}%>
<%
		     counter++;
         //  }
}
%>
function checkMainChargeForUpdate(){
var mainChargeForUpdateButton=document.chargeCode.<%= MAIN_CHARGECODE_ID%>.options[document.chargeCode.<%= MAIN_CHARGECODE_ID%>.selectedIndex].text;
var subChargeForUpdateButton=document.chargeCode.<%= SUB_CHARGECODE_ID%>.options[document.chargeCode.<%= SUB_CHARGECODE_ID%>.selectedIndex].text;
	if(mainChargeForUpdateButton != "Select" ){
		editForm('chargeCode','/hms/hms/hospital?method=editChargeCode')
	}else{
	alert("Parent is InActivated!")
	}
}
 
formName = "chargeCode"

//nonEditable = ['<%= CHARGE_CODE_CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);


intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
