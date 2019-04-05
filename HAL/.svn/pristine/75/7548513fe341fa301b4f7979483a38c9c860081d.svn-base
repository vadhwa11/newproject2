<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * investigation.jsp  
 * Purpose of the JSP -  This is for Investigation Master 
 * @author  ABHA

 * Create Date:31july,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.11  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasChargeType"%>
<%@page import="jkt.hms.masters.business.MasSubTest"%>
<%@page import="jkt.hms.masters.business.MasSample"%>


<%

	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String,Object>) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	
	ArrayList  <MasSubChargecode> subChargecodeList = new ArrayList<MasSubChargecode>();
	subChargecodeList = (ArrayList)map.get("subChargecodeList");
	
	
	ArrayList  <MasMainChargecode> mainChargecodeList = new ArrayList<MasMainChargecode>();
	
	mainChargecodeList = (ArrayList)map.get("mainChargecodeList");
	
	
	
	List<DgMasInvestigation> searchInvestigationList = new ArrayList<DgMasInvestigation>();
	searchInvestigationList=(List)map.get("searchInvestigationList");
	
	
	ArrayList<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	departmentList=(ArrayList)map.get("departmentList");
	
	ArrayList<MasChargeType> chargeTypeList = new ArrayList<MasChargeType> ();
	chargeTypeList=(ArrayList)map.get("chargeTypeList");
	
	List<MasSubTest> subTestList = new ArrayList<MasSubTest>();
	subTestList=(ArrayList)map.get("subTestList");
	
	ArrayList<MasSample> sampleList = new ArrayList<MasSample>();
	sampleList=(ArrayList)map.get("sampleList");
	
	ArrayList<DgMasCollection> collectionList=new ArrayList<DgMasCollection>();
	collectionList=(ArrayList)map.get("collectionList");
	
	ArrayList<MasChargeCode>chargeCodeList = new ArrayList<MasChargeCode>();
	chargeCodeList=(ArrayList)map.get("chargeCodeList");
	
	ArrayList<DgUom> uomList = new ArrayList<DgUom>();
	uomList=(ArrayList)map.get("uomList");
	

			String userName = "";
			if (session.getAttribute("userName") != null) {
				userName = (String) session.getAttribute("userName");
			}
			int deptId = 0;
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
			}
			String deptType = "";
			if (session.getAttribute("deptType") != null) {
				deptType = (String) session.getAttribute("deptType");
			}
			System.out.println("deptType"+deptType);
			int mainChargecodeId =0;
			if(map.get("mainChargecodeId") != null){
				mainChargecodeId =(Integer) map.get("mainChargecodeId");
			}
			int subChargecodeId =0;
			if(map.get("subChargecodeId") != null){
				subChargecodeId =(Integer) map.get("subChargecodeId");
			
			}
			int pageNoTempFromBackButton =0;
			if(map.get("pageNoTempFromBackButton") != null){
				pageNoTempFromBackButton =(Integer) map.get("pageNoTempFromBackButton");
			
			}
			
			int chargeCodeId =0;
			if(map.get("chargeCodeId") != null){
				chargeCodeId =(Integer) map.get("chargeCodeId");
			}
			String investigationName ="";
		 	if(map.get("investigationName") != null){
		 		investigationName = (String)map.get("investigationName");
		 	}
			String message="";
			if(map.get("message") != null){
			 	message = (String)map.get("message");
					%> <br>

<h4><%=message %></h4>

<%} %> <%
	ArrayList gridSubChargecodeList = (ArrayList) map.get("gridSubChargecodeList");
	ArrayList gridMainChargecodeList = (ArrayList) map.get("gridMainChargecodeList");
	ArrayList gridChargeTypeList = (ArrayList) map.get("gridChargeTypeList");
	ArrayList gridSampleList = (ArrayList) map.get("gridSampleList");
	ArrayList gridUnitOfMeasurementList = (ArrayList) map.get("gridUnitOfMeasurementList");
	ArrayList gridChargeCodeList =(ArrayList)map.get("gridChargeCodeList");
	ArrayList gridCollectionList =(ArrayList)map.get("gridCollectionList");
	%> <script>
function disableValues(){
if(document.getElementById('normalValue').value != ""){
document.getElementById('minNormalValue').disabled = true;
document.getElementById('maxNormalValue').disabled = true;
}else{
document.getElementById('minNormalValue').disabled = false;
document.getElementById('maxNormalValue').disabled = false;
}
}
</script> <script>
	function openPopUp()
		{
			var investigationId = document.getElementById('investigationId').value;
				window.open('investigation?method=showInstructionsPopupJsp&investigationId='+investigationId,'mywindow','location=1,status=1,scrollbars=1,top=210,left=30,width=960,height=300');
			
		}
		

function disableNormalValues(){
if(document.getElementById('minNormalValue').value != ""){
document.getElementById('normalValue').disabled = true;
}else{
document.getElementById('normalValue').disabled = false;
}
}
</script> <script>
function goToPageLocal(pageno){
	
	if(pageno == ""){
		alert("Please Enter Page No.")
		return false;
	}
	if( (pageno>totalPages) || (pageno<=0) || (pageno%1!=0) )
	{
		alert("Please Enter Correct Page No.")
	document.paging.pageno.value=""
	return false;
	}
	if(pageno == 1){
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="nextbuttondisabled"
		document.paging.prevpage.className="firstbuttondisabled"		
	
		document.paging.lastpage.disabled= false;
		document.paging.nextpage.disabled= false;
		document.paging.lastpage.className="lastbutton"
		document.paging.nextpage.className="nextbutton"	
	}
	else if(pageno == totalPages){
		document.paging.firstpage.disabled= false;
		document.paging.prevpage.disabled= false;
		document.paging.firstpage.className="firstbutton"
		document.paging.prevpage.className="previousbutton"		
	
		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="lastbuttondisabled"
		document.paging.nextpage.className="previousbuttondisabled"		
	}
	else{
		document.paging.firstpage.disabled= false;
		document.paging.prevpage.disabled= false;
		document.paging.firstpage.className="firstbutton"
		document.paging.prevpage.className="previousbutton"		
	
		document.paging.lastpage.disabled= false;
		document.paging.nextpage.disabled= false;
		document.paging.lastpage.className="lastbutton"
		document.paging.nextpage.className="nextbutton"		
	}
	if(pageno*rowsPerPage<data_arr.length)
		makeTable(pageno*rowsPerPage-rowsPerPage,pageno*rowsPerPage)
	else
		makeTable(pageno*rowsPerPage-rowsPerPage,data_arr.length)
		if(document.getElementById("rowsPerPageForItem")!=null)
		{

		if(document.getElementById("rowsPerPageForItem").value == 10){
	document.getElementById("currStart").innerHTML=(pageno-1)*10+1
		document.getElementById("currEnd").innerHTML=(pageno)*10
		}
		}
		else{
	document.getElementById("currStart").innerHTML=(pageno-1)*5+1
		document.getElementById("currEnd").innerHTML=(pageno)*5
		}
		
		
		document.getElementById("current").innerHTML=pageno
	
	
	document.paging.pageno.value=""	
	document.getElementById("pageNoTemp").value = document.getElementById("current").innerHTML;
	
}
function navigateLocal(obj){
	
	document.paging.firstpage.style.border = "none"
	document.paging.nextpage.style.border = "none"
	document.paging.lastpage.style.border = "none"
	document.paging.prevpage.style.border = "none"		
	//currentPage = document.paging.pageno.value;
	initTabButtons()
	if(obj.value == 'f' && data_arr.length>rowsPerPage){
	
		makeTable(0,rowsPerPage);
		//document.getElementById('pageno').value=1
		
		document.getElementById("current").innerHTML=1
	
		document.getElementById("currStart").innerHTML=1
		if(document.getElementById("rowsPerPageForItem")!=null)
		{

		if(document.getElementById("rowsPerPageForItem").value == 10){
		rowsPerPage = 10;
		document.getElementById("currEnd").innerHTML=10
		}
		}
		else{
		document.getElementById("currEnd").innerHTML=5
		}
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="nextbuttondisabled"
		document.paging.prevpage.className="firstbuttondisabled"	

		document.paging.lastpage.disabled= false;
		document.paging.nextpage.disabled= false;
		document.paging.lastpage.className="lastbutton"
		document.paging.nextpage.className="nextbutton"			
	}
	else if(obj.value == 'p'){
		if(start-rowsPerPage>=0){
			document.paging.lastpage.disabled= false;
			document.paging.nextpage.disabled= false;
			document.paging.lastpage.className="lastbutton"
			document.paging.nextpage.className="nextbutton"	
			if(start==rowsPerPage){
				document.paging.firstpage.disabled= true;
				document.paging.prevpage.disabled= true;
				document.paging.firstpage.className="nextbuttondisabled"
				document.paging.prevpage.className="firstbuttondisabled"	
			}
			else{
				document.paging.firstpage.disabled= false;
				document.paging.prevpage.disabled= false;
				document.paging.firstpage.className="firstbutton"
				document.paging.prevpage.className="previousbutton"	
			}
			makeTable(start-rowsPerPage,start);
			//document.getElementById('pageno').value--;
		if(document.getElementById("rowsPerPageForItem")!=null)
		{

			if(document.getElementById("rowsPerPageForItem").value == 10){
			rowsPerPage = 10;
		document.getElementById("currStart").innerHTML=(document.getElementById("current").innerHTML-2)*10+1
				document.getElementById("currEnd").innerHTML=(document.getElementById("current").innerHTML-1)*10
				document.getElementById("current").innerHTML--;
			}
		}
		else{
		document.getElementById("currStart").innerHTML=(document.getElementById("current").innerHTML-2)*5+1
				document.getElementById("currEnd").innerHTML=(document.getElementById("current").innerHTML-1)*5
				document.getElementById("current").innerHTML--;
		}
			
			
		}

	}
	else if(obj.value == 'n'){
		if(start+rowsPerPage*2<data_arr.length){
			makeTable(start+rowsPerPage,start+(rowsPerPage*2));
			
			//document.getElementById('pageno').value++;
			var tt=document.getElementById("current").innerHTML;
			if(document.getElementById("rowsPerPageForItem")!=null)
		{

		if(document.getElementById("rowsPerPageForItem").value == 10){
		document.getElementById("currStart").innerHTML=(tt)*10+1
				document.getElementById("currEnd").innerHTML=((tt*1)+1)*10
			document.getElementById("current").innerHTML++;
		}
		}
		else{
		document.getElementById("currStart").innerHTML=(tt)*5+1
				document.getElementById("currEnd").innerHTML=((tt*1)+1)*5
			document.getElementById("current").innerHTML++;
		}
			
			
			document.paging.firstpage.disabled= false;
			document.paging.prevpage.disabled= false;
			document.paging.firstpage.className="firstbutton"
			document.paging.prevpage.className="previousbutton"					
			
		}
		else if(start+rowsPerPage<data_arr.length){
			makeTable(start+rowsPerPage,data_arr.length);
			//document.getElementById('pageno').value++;
		if(document.getElementById("rowsPerPageForItem")!=null)
		{

		if(document.getElementById("rowsPerPageForItem").value == 10){
	document.getElementById("currStart").innerHTML=(document.getElementById("current").innerHTML)*10+1
		}
		}
		else{
	document.getElementById("currStart").innerHTML=(document.getElementById("current").innerHTML)*5+1
		}	
			
				document.getElementById("currEnd").innerHTML=data_arr.length
			document.getElementById("current").innerHTML++;	
			document.paging.lastpage.disabled= true;
			document.paging.nextpage.disabled= true;
			document.paging.lastpage.className="lastbuttondisabled"
			document.paging.nextpage.className="previousbuttondisabled"	
			
			document.paging.firstpage.disabled= false;
			document.paging.prevpage.disabled= false;
			document.paging.firstpage.className="firstbutton"
			document.paging.prevpage.className="previousbutton"								
		}
	}
	else if(obj.value == 'l'){
		if(data_arr.length % rowsPerPage == 0) {
			makeTable(data_arr.length - rowsPerPage, data_arr.length);
			//document.getElementById('pageno').value=totalPages;
			document.getElementById("currStart").innerHTML=data_arr.length-4
				document.getElementById("currEnd").innerHTML=data_arr.length
			document.getElementById("current").innerHTML=totalPages
		} else {
			makeTable((data_arr.length - (data_arr.length % rowsPerPage)), data_arr.length);
			//document.getElementById('pageno').value=totalPages;
			document.getElementById("currStart").innerHTML=data_arr.length-4
				document.getElementById("currEnd").innerHTML=data_arr.length
			document.getElementById("current").innerHTML=totalPages
		}
		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="lastbuttondisabled"
		document.paging.nextpage.className="previousbuttondisabled"	
		
		document.paging.firstpage.disabled= false;
		document.paging.prevpage.disabled= false;
		document.paging.firstpage.className="firstbutton"
		document.paging.prevpage.className="previousbutton"	
	}
	if(!obj.disabled){
		obj.style.border = "1px solid yellow"
	}
	
	document.getElementById("pageNoTemp").value = document.getElementById("current").innerHTML;
}

function singleParValidation(){
var errorMessage= "" ;
if(document.getElementById('investigationType').value =='s'){
	if(document.getElementById('normalValue').disabled == false && document.getElementById('normalValue').value == ""){
	errorMessage=errorMessage+"Please Enter Normal Value \n"; 
	}
	if(errorMessage !=""){
		alert(errorMessage);
		return false;
	}
	else{
		return true;		
	}	
		
	}else{
	return true;
	}
	}
</script> <script>
function investigation(obj){
	var url;
	var errorMessage= "" ;
	var mainChargecodeId = 0;
	var subChargeCodeId= 0;
	var chargeCodeId= 0;
	var investigationName="";
	var confidential="";
	var investigationType="";
	var dischargeSummary="";
	var sampleId="";
	var quantity ="";
	var collectionCenterId ="";
	obj = eval('document.'+formName)
	 if(document.getElementById('investigationType').value =="m"){
	
	if(document.getElementById('mainChargecodeId').value ==0)
	errorMessage=errorMessage+"Please Select Department \n"; 
	if(document.getElementById('subChargeCodeId').value == 0)
	errorMessage=errorMessage+"Please Select Modality  \n"
	if(document.getElementById('chargeCodeId').value == 0)
	errorMessage=errorMessage+"Please Select Test Name  \n"
	
		
		mainChargecodeId=document.getElementById('mainChargecodeId').value;
		subChargeCodeId=document.getElementById('subChargeCodeId').value; 
		chargeCodeId=document.getElementById('chargeCodeId').value;
		investigationName=document.getElementById('investigationName').value;
		confidential=document.getElementById('confidential').value;
		investigationType=document.getElementById('investigationType').value;
		dischargeSummary=document.getElementById('dischargeSummary').value;
		sampleId= document.getElementById('sample_id').value;
		quantity = document.getElementById('quantity').value;
		collectionCenterId = document.getElementById('collectionCenterId').value;
		

		if((mainChargecodeId!=0)&&(subChargeCodeId!=0)&&(chargeCodeId!=0)){
	 		document.getElementById('normalValue').disabled = true;
	 		document.getElementById('unitName').disabled = true;  
		 	document.getElementById('minNormalValue').disabled = true;  
		 	document.getElementById('maxNormalValue').disabled = true;  
			
			var printId = document.getElementById('submitWithInvestigationType');
			//printId.setAttribute("type","submit");
	 
 			url="investigation?method=showSubInvestigationJsp&mainChargecodeId="+document.getElementById('mainChargecodeId').value+'&subChargeCodeId='+document.getElementById('subChargeCodeId').value+'&chargeCodeId='+document.getElementById('chargeCodeId').value+'&investigationName='+document.getElementById('investigationName').value+'&confidential='+document.getElementById('confidential').value+'&investigationType='+document.getElementById('investigationType').value+'&dischargeSummary='+document.getElementById('dischargeSummary').value+'&sampleId='+document.getElementById('sample_id').value+'&quantity='+document.getElementById('quantity').value+'&collectionCenterId='+document.getElementById('collectionCenterId').value;
			obj.action=url;
			obj.submit();
		}else{
			alert(errorMessage);
			return false
		}
		if(errorMessage!=""){
		alert(errorMessage);
		return false
		}
}
else if(document.getElementById('investigationType').value == "t"){
	if(document.getElementById('mainChargecodeId').value ==0)
	errorMessage=errorMessage+"Please Select Department \n"; 
	if(document.getElementById('subChargeCodeId').value == 0)
	errorMessage=errorMessage+"Please Select Modality   \n"
	if(document.getElementById('chargeCodeId').value == 0)
	errorMessage=errorMessage+"Please Select Test Name  \n"
	
		
		mainChargecodeId=document.getElementById('mainChargecodeId').value;
		subChargeCodeId=document.getElementById('subChargeCodeId').value; 
		chargeCodeId=document.getElementById('chargeCodeId').value;
		investigationName=document.getElementById('investigationName').value;
		confidential=document.getElementById('confidential').value;
		investigationType=document.getElementById('investigationType').value;
		dischargeSummary=document.getElementById('dischargeSummary').value;
		sampleId= document.getElementById('sample_id').value;
		quantity = document.getElementById('quantity').value;
		collectionCenterId = document.getElementById('collectionCenterId').value;
		unitOfMeasurementId = document.getElementById('unitName').value;

		if((mainChargecodeId!=0)&&(subChargeCodeId!=0)&&(chargeCodeId!=0)){
	
	 	document.getElementById('normalValue').disabled = true;
	 	document.getElementById('unitName').disabled = true;  
		 document.getElementById('minNormalValue').disabled = true;  
		 document.getElementById('maxNormalValue').disabled = true;  
	 		var printId = document.getElementById('submitWithInvestigationType');
			//printId.setAttribute("type","submit");
	 
		url="/hms/hms/investigation?method=showTemplateJsp&mainChargecodeId="+document.getElementById('mainChargecodeId').value+'&subChargeCodeId='+document.getElementById('subChargeCodeId').value+'&chargeCodeId='+document.getElementById('chargeCodeId').value+'&investigationName='+document.getElementById('investigationName').value+'&confidential='+document.getElementById('confidential').value+'&investigationType='+document.getElementById('investigationType').value+'&dischargeSummary='+document.getElementById('dischargeSummary').value+'&sampleId='+document.getElementById('sample_id').value+'&quantity='+document.getElementById('quantity').value+'&collectionCenterId='+document.getElementById('collectionCenterId').value+'&unitOfMeasurementId='+document.getElementById('unitName').value;
		obj.action=url;
		obj.submit();
	
		}else{
			
			alert(errorMessage);
			
			return false
		}
		
		if(errorMessage!=""){
			alert(errorMessage);
			
			return false
		}
}
else
	{
 document.getElementById('normalValue').disabled = false;
 document.getElementById('unitName').disabled = false;
 document.getElementById('minNormalValue').disabled = false;  
 document.getElementById('maxNormalValue').disabled = false; 
 	}
}
function showHideGoButton(invObj){
	var invType = invObj.value;
	if(invType == 't' || invType == 'm' ){
		document.getElementById('goDiv').style.display = 'inline';
	}else{
		document.getElementById('goDiv').style.display = 'none';
	}
}
</script> <%if(map.get("message") != null){ %>
<div class="titleBg">
<h2>Diagnostic Master</h2></div>
<% }else{ %>
<div class="titleBg">
<h2>Diagnostic Master</h2></div>
<% } %> 


<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>Investigation</label> 
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1"      class="radioAuto" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""	validate="Investigation Name,string,no" MAXLENGTH="10" tabindex=1 />
<input type="radio" name="<%=SELECTED_RADIO  %>" value="2"       class="radioAuto" />
<label> Modality </label> 
<select	id="searchModality" name="searchModality"	validate="Modality ,string,no" tabindex=1	>
	<option value="0">Select</option>
	<% 
				if(subChargecodeList.size() >0){
				for (MasSubChargecode subChargecode : subChargecodeList){
					
				%>
	
	<option value="<%=subChargecode.getId ()%>"><%=subChargecode.getSubChargecodeName()%></option>

	<%}}%>

</select> 
 
<input	type="submit" name="search" value="Search" class="button"	onclick="submitForm('search','investigation?method=searchInvestigation')"	tabindex=1 />
 <input type="button" name="Report" value="Generate Report" class="buttonBig3" onClick="submitForm('search','investigation?method=generateReportForInvestigationMasters');" accesskey="g" tabindex=1/>
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_diagostic">
<div class="Clear"></div>
</div>
</form>
</div>
</div>


<div class="Clear"></div>

<jsp:include page="searchResultBlock.jsp"></jsp:include>
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<%
	if (searchInvestigationList.size() > 0 ) {
		String strForCode = (String) map.get("investigationCode");
		String strForCodeDescription = (String) map.get("investigationName");
		if (strForCode != null && strForCode != "" || strForCodeDescription != null	&& strForCodeDescription != "") {
%>
<div class="Clear"></div>
<h4>
<a href="investigation?method=showInvestigationJsp">Show All Records</a></h4>
<%
 	}
 	}
 if(searchInvestigationList.size()==0 && map.get("search") != null)
	  {
	 %>
<h4> <a href="investigation?method=showInvestigationJsp">Show All Records</a></h4>  
<%
    }
	%> 
	
<script type="text/javascript">
	formFields = [
	 		[0, "<%= INVESTIGATION_ID%>", "id"],[1,"<%= INVESTIGATION_NAME %>"],[2,"<%= MAIN_CHARGECODE_ID %>"], [3,"<%= SUB_CHARGECODE_ID%>"], [4,"<%= CHARGE_CODE_ID%>"],[5,"<%=SAMPLE_ID %>"],[6,"<%= NORMAL_VALUE%>"],[7,"<%=UNIT_OF_MEASUREMENT_ID%>"],[8,"<%=CONFIDENTIAL %>"],[9,"<%= DSICHARGE_SUMMARY%>"],[10,"<%=QUANTITY%>"],[11,"<%=INVESTIGATION_TYPE%>"],[12,"<%= CHANGED_DATE %>"],[13,"<%= CHANGED_DATE %>"],[14,"<%=COLLECTION_CENTER_ID%>" ],[15,"<%=STATUS%>"],[16,"<%=MIN_NORMAL_VALUE%>"],[17,"<%=MAX_NORMAL_VALUE%>"],[18,"<%=NUMERIC_OR_STRING%>"],[19,"instructions"]
	 		];
	   statusTd = 15;
</script>
</div>
<div class="clear"></div>
<script type="text/javascript">
function deleteChargeCode(){
var subChargeId1=document.chargeCode.<%= SUB_CHARGECODE_ID%>.options[document.chargeCode.<%= SUB_CHARGECODE_ID%>.selectedIndex].text;
var mainChargeId1=document.chargeCode.<%= MAIN_CHARGECODE_ID%>.options[document.chargeCode.<%= MAIN_CHARGECODE_ID%>.selectedIndex].text;

 if(mainChargeId1=="Select"){
alert('Parent is InActivated!');
}
else{
deleteForm('chargeCode','/hms/hms/investigation?method=deleteInvestigation');
}
}	
</script>
<form name="chargeCode" method="post" action="">

<input	type="hidden" name="<%= POJO_NAME %>" value="DgMasInvestigation">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"	value="InvestigationName"> 
<input type="hidden" name="title"	value="Investigation"> 
<input type="hidden"	name="<%=JSP_NAME %>" value="investigation"> 
<input	type="hidden" name="pojoPropertyCode" value="InvestigationCode">
<input type="hidden" name="deptId" value="<%=deptId%>" /> 
<div class="clear paddingTop15"></div>

<div class="Block">
<label> Department <span>*</span></label> 
<select	id="<%=MAIN_CHARGECODE_ID %>" name="<%=MAIN_CHARGECODE_ID %>"	validate="Department,string,yes"	onChange="populateSubChargeCode(this.value,'chargeCode')" tabindex=1>
	<option value="">Select</option>
	<% if(mainChargecodeList.size()>0){
				for (MasMainChargecode mainChargecode : mainChargecodeList){
					if (mainChargecodeId ==(mainChargecode.getId())) {
				%>
	<option value="<%=mainChargecode.getId ()%>" selected="selected"><%=mainChargecode.getMainChargecodeName()%></option>
	<%}else{ %>
	<option value="<%=mainChargecode.getId ()%>"><%=mainChargecode.getMainChargecodeName()%></option>
	<%}}}%>
</select> 

<script type="text/javascript">
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
</script> 
		
<label> Modality <span>*</span></label> 
<select	id="<%=SUB_CHARGECODE_ID %>" name="subChargeCodeId"	validate="Modality ,string,yes" tabindex=1	onChange="populateCharge(this.value,'chargeCode')">
	<option value="">Select</option>
	<% 
				if(subChargecodeList.size() >0){
				for (MasSubChargecode subChargecode : subChargecodeList){
					if (subChargecodeId ==(subChargecode.getId())) {
				%>
	<option value="<%=subChargecode.getId ()%>" selected="selected"><%=subChargecode.getSubChargecodeName()%></option>
	<% }else{%>
	<option value="<%=subChargecode.getId ()%>"><%=subChargecode.getSubChargecodeName()%></option>

	<%}}}%>

</select> 

<script type="text/javascript">
          chargeCodeArray = new Array();
		<%
			int count1 = 0;
			for (Iterator iter = subChargecodeList.iterator(); iter.hasNext();) 
			{
				MasSubChargecode subChargecode = (MasSubChargecode) iter.next();
				for (Iterator iterChargecode = chargeCodeList.iterator(); iterChargecode.hasNext();) 
				{
					MasChargeCode chargeCode = (MasChargeCode) iterChargecode.next();
					if(subChargecode.getId().equals(chargeCode.getSubChargecode().getId())){
								%>
									chargeCodeArray[<%=count1%>] = new Array();
									chargeCodeArray[<%=count1%>][0] = <%=subChargecode.getId()%>;
									chargeCodeArray[<%=count1%>][1] = <%=chargeCode.getId()%>;									
									chargeCodeArray[<%=count1%>][2] = "<%=chargeCode.getChargeCodeName()%>";

								<%
								count1++;
						}
					}
				}
			
		%>
</script> 

<label>Investigation <span>*</span></label> 
<select id="<%=CHARGE_CODE_ID%>" name="<%=CHARGE_CODE_ID %>"	validate="Investigation Name,string,yes" tabindex=1	onchange="fillInvestigation(this.value)">
	<option value="">Select</option>
	
	<% 
				for (MasChargeCode masChargeCode : chargeCodeList){
					if (chargeCodeId ==(masChargeCode.getId())) {
				%>
	<option value="<%=masChargeCode.getId ()%>" selected="selected"><%=masChargeCode.getChargeCodeName()%></option>
	<%}else{ %>
	<option value="<%=masChargeCode.getId ()%>"><%=masChargeCode.getChargeCodeName()%></option>

	<%}}%>

</select>

<div class="Clear"></div>

 <%if(investigationName != null){ %>
<input type="hidden" name="<%= INVESTIGATION_NAME %>" value="<%=investigationName %>" id=<%=INVESTIGATION_NAME %>	validate="Investigation Na0me,string,yes" maxlength="30" tabindex=1 /> 
<%}else{ %>
<input type="text" name="<%= INVESTIGATION_NAME %>" value="" id=<%=INVESTIGATION_NAME %> validate="Investigation Name,string,yes"	maxlength="30" tabindex=1 /> 
<%} %> 
<input type="hidden" id="investigationId1" name="investigationId1"	value="<%=chargeCodeId %>"> 
<input type="hidden" id="investigationCode" name="investigationCode" value=""> 
<script	type="text/javascript">
				function fillInvestigation(obj){
				
		<%				for (MasChargeCode masChargeCode : chargeCodeList) 
								{
										%>
										var invObj =<%= masChargeCode.getId()%>
										if(invObj == obj){
 								
 							document.getElementById('investigationName').value="<%=masChargeCode.getChargeCodeName()%>"
 							document.getElementById('investigationId1').value="<%=masChargeCode.getId()%>"
 							document.getElementById('investigationCode').value="<%=masChargeCode.getChargeCodeCode()%>"
 							}
 					<%
 						} %>	
 						}
 </script> 
 
 <% if(!deptType.equalsIgnoreCase("radio")){
 %> 
 <label>Sample</label> 
 <select id="<%=SAMPLE_ID %>" name="<%=SAMPLE_ID %>"	validate="Sample,string,no" tabindex=1>
 	<option value="0">Select</option>
	<% 
				for (MasSample sample : sampleList){
				%>
	<option value="<%=sample.getId()%>"><%=sample.getSampleDescription()%></option>
	<%}%>
</select>
 <%}else{ 
%> 
<input type="hidden" value="0"	id="<%=SAMPLE_ID %>" name="<%=SAMPLE_ID %>"> 
<%} %> 
<% if(!deptType.equalsIgnoreCase("radio")){%>
<label >Container</label> 
<select	id="<%=COLLECTION_CENTER_ID %>" name="<%=COLLECTION_CENTER_ID %>"	validate="Collection,string,no" tabindex=1>
	<option value="0">Select</option>
	<% 
				for (DgMasCollection dgCollection : collectionList){
				%>
	<option value="<%=dgCollection.getId ()%>"><%=dgCollection.getCollectionName()%></option>
	<%}%>
</select> 

<label>UOM</label> 
<select id="unitName"	name="<%=UNIT_OF_MEASUREMENT_ID %>" validate="Unit Name,string,no"	tabindex=1>
	<option value="0">Select</option>
	<% 
				for (DgUom dgUom : uomList){
				%>
	<option value="<%=dgUom.getId ()%>"><%=dgUom.getUomName()%></option>
	<%}%>
</select> 
<div class="Clear"></div>
<label >No.of Sample </label> 
<input type="text"	name="<%= QUANTITY%>" value="1" id="quantity" class="text"	maxlength="10" validate="Sample Quantity,string,no" tabindex=1 /> 
<%}else{ %>
<input type="hidden" name="<%=COLLECTION_CENTER_ID %>"	id="<%=COLLECTION_CENTER_ID%>" value="0"> 
<input type="hidden" name="<%=UNIT_OF_MEASUREMENT_ID %>" id="unitName" value="0"> 
<input	type="hidden" name="<%= QUANTITY%>" value="1" id="quantity"	class="text" maxlength="10" validate="Sample Quantity,string,no"	tabindex=1 /> 
<%} %> 
<label> Result Type<span>*</span></label> 
<select	maxlength="10"	name="<%=INVESTIGATION_TYPE %>" id="<%=INVESTIGATION_TYPE %>"	tabindex=1 validate="Investigation Type,string,yes"	onchange="showHideGoButton(this);">

	<% if(deptType.equalsIgnoreCase("diag")){%>
	<option value="">Select</option>
	<option value="s">Single Parameter</option>
	<option value="m">Multiple Parameter</option>
	<option value="t">Template</option>
	<option value="v">Sensitive</option>
	<%}else{ %>
	<option value="">Select</option>
	<option value="t" selected="selected">Template</option>

	<%} %>
</select> 

<% if(!deptType.equalsIgnoreCase("radio")){ %>
<div id="goDiv" style="display: none;">
<% }else{ %>
<div id="goDiv" style="display: inline;">
<% } %> 
<input type="button" name="search"	id="submitWithInvestigationType" value="Go" class="buttonSm"	 onclick="investigation(this);"	tabindex=1 />
</div>



<% if(!deptType.equalsIgnoreCase("radio")){%> 
<div class="Clear"></div>
<label calss="auto">Normal Value</label> 
<input type="text" name="<%= NORMAL_VALUE%>" value=""	id="<%= NORMAL_VALUE%>" validate="Normal Value,string,no"	maxlength="20" tabindex=1 onblur="disableValues();" /> 

<label>Min Value</label> 
<input type="text"	name="<%=MIN_NORMAL_VALUE%>" value="" id="<%=MIN_NORMAL_VALUE%>"	validate="Min Value,string,no" maxlength="20" tabindex=1	onblur="disableNormalValues();" /> 
<label >Max Value</label> 
<input type="text" name="<%=MAX_NORMAL_VALUE%>" value="" id="<%=MAX_NORMAL_VALUE%>" validate="Max Value,string,no"	maxlength="20" tabindex=1 />


<%}else{ %> 
<input type="hidden" name="<%= NORMAL_VALUE%>" value="0"id="<%= NORMAL_VALUE%>" validate="Normal Value,string,no"	maxlength="20" tabindex=1 onblur="disableValues();" /> 
<input	type="hidden" name="<%= MIN_NORMAL_VALUE%>" value="0"	id="<%= MIN_NORMAL_VALUE%>" validate="Min Value,string,no"	maxlength="20" tabindex=1 onblur="disableNormalValues();" /> 
<input	type="hidden" name="<%= MAX_NORMAL_VALUE%>" value="0"	id="<%= MAX_NORMAL_VALUE%>" validate="Max Value,string,no"	maxlength="20" tabindex=1 /> 
<input type="hidden"	name="<%=NUMERIC_OR_STRING%>" id="<%=NUMERIC_OR_STRING%>" tabindex="1"	value=""> 
<%} %>
<div class="Clear"></div>	
<label >Confidential</label> 
<input	type="checkbox" name="<%=CONFIDENTIAL%>" id="<%=CONFIDENTIAL%>"	value="y"  class="radio" tabindex="1"/>

<label class="auto"> Appear in Discharge Summary</label>
<input type="checkbox" name="<%=DSICHARGE_SUMMARY%>"id="<%= DSICHARGE_SUMMARY%>" value="y"style="margin-right:121px;" tabindex="1"  />
<label>Instructions</label>
<input type="text" name="instructions" value="" id="instructions"  maxlength="100" />

<div class="clear"></div>
</div>

<input type="hidden" name="pageNoTemp" value="0" id="pageNoTemp"	validate="Page No,string,no" maxlength="20" tabindex=1 />
	<div class="Clear"></div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add"	class="button"	onClick="if(singleParValidation()){submitForm('chargeCode','investigation?method=addInvestigation');}"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"id="editbutton" value="Update" class="button"onClick="submitForm('chargeCode','investigation?method=editInvestigation')"accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button"	onClick="submitForm('chargeCode','investigation?method=deleteInvestigation&flag='+this.value)"	accesskey="d" tabindex=1 /> 
<!--<input type="button" name="Instruction" id="Instructions" value="Instructions" class="button" onClick="openPopUp();" accesskey="a" tabindex=1 />-->
<input type="reset" name="Reset"	id="reset" value="Reset" class="button" accesskey="r"	onclick="resetCheck();" tabindex=1 /> 
<input type="hidden"	name="<%=STATUS%>" value="" /> 
<input type="hidden" id="investigationId"	name="<%= INVESTIGATION_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
	
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
<div class="clear"></div>
<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
<INPUT	type=hidden value="<%=userName%>" name="<%=LAST_CHANGED_BY%>">
<INPUT type=hidden value="<%=date%>" name="<%=LAST_CHANGED_DATE%>">
<INPUT type=hidden value="<%=time%>" name="<%=LAST_CHANGED_TIME%>">
</div>

</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Investigation Name"
data_header[0][1] = "data";
data_header[0][2] = "14%";
data_header[0][3] = "<%=INVESTIGATION_NAME%>";

data_header[1]=new Array;
data_header[1][0]="Department"
data_header[1][1]="data";
data_header[1][2]="14%";
data_header[1][3]="<%=MAIN_CHARGECODE_ID%>";

data_header[2]=new Array;
data_header[2][0]="Modality"
data_header[2][1]="data";
data_header[2][2]="14%";
data_header[2][3]="<%=SUB_CHARGECODE_ID%>";

data_header[3]=new Array;
data_header[3][0]="Test Name"
data_header[3][1]="hide";
data_header[3][2]="14%";
data_header[3][3]="<%=CHARGE_CODE_ID%>";

data_header[4]=new Array;
data_header[4][0]="Sample"
<% if(!deptType.equalsIgnoreCase("radio")){ %>
	data_header[4][1]="data";
<% }else{%>
 	data_header[4][1]="hide";
 <%}%>
data_header[4][2]="14%";
data_header[4][3]="<%=SAMPLE_ID%>";

data_header[5]=new Array;
data_header[5][0]="Normal Value"
data_header[5][1]="hide";
data_header[5][2]=0;
data_header[5][3]="<%=NORMAL_VALUE %>";

data_header[6]=new Array;
data_header[6][0]="Unit"
data_header[6][1]="hide";
data_header[6][2]=0;
data_header[6][3]="<%=UNIT_OF_MEASUREMENT_ID%>";

data_header[7]=new Array;
data_header[7][0]="Confidential"
data_header[7][1]="hide";
data_header[7][2]=0;
data_header[7][3]="<%=CONFIDENTIAL%>";

data_header[8]=new Array;
data_header[8][0]="Discharge Summary"
data_header[8][1]="hide";
data_header[8][2]=0;
data_header[8][3]="<%=DSICHARGE_SUMMARY%>";

data_header[9] = new Array;
data_header[9][0] = "Quantity"
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%=QUANTITY %>"

data_header[10] = new Array;
data_header[10][0] = "Investigation Type"
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%=INVESTIGATION_TYPE %>"

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "<%=CHANGED_DATE%>"

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "<%=CHANGED_TIME%>"

data_header[13] = new Array;
data_header[13][0] = "Collection"
<% if(!deptType.equalsIgnoreCase("radio")){ %>
data_header[13][1] = "data";
<%}else{%>
data_header[13][1] = "hide";
<%}%>
data_header[13][2] = "14%";
data_header[13][3] = "<%=COLLECTION_CENTER_ID %>"

data_header[14] = new Array;
data_header[14][0] = "Status"
data_header[14][1] = "data";
data_header[14][2] = "14%";
data_header[14][3] = "<%=STATUS %>"

data_header[15] = new Array;
data_header[15][0] = "MinValue"
data_header[15][1] = "hide";
data_header[15][2] = "14%";
data_header[15][3] = "<%=MIN_NORMAL_VALUE%>"

data_header[16] = new Array;
data_header[16][0] = "MaxValue"
data_header[16][1] = "hide";
data_header[16][2] = "14%";
data_header[16][3] = "<%=MAX_NORMAL_VALUE%>"

data_header[17] = new Array;
data_header[17][0] = "NumericOrString"
data_header[17][1] = "hide";
data_header[17][2] = "14%";
data_header[17][3] = "<%=NUMERIC_OR_STRING%>"

data_header[18] = new Array;
data_header[18][0] = ""
data_header[18][1] = "hide";
data_header[18][2] = "14%";
data_header[18][3] = "instructions"



data_arr = new Array();
<%
	Iterator itrCC=searchInvestigationList.iterator();
        int  counter=0;
          while(itrCC.hasNext())
           {
             DgMasInvestigation  dgmasInvestigation = (DgMasInvestigation)itrCC.next(); 
             

      //       if(dgmasInvestigation.getMainChargecode().getDepartment().getId()==deptId){

 
%>

		data_arr[<%= counter%>] = new Array();
		data_arr[<%= counter%>][0] = <%= dgmasInvestigation.getId()%>
		data_arr[<%= counter%>][1] = "<%= dgmasInvestigation.getInvestigationName()%>"

		<%
		Iterator itrGridMainChargeCodeList=gridMainChargecodeList.iterator();
		while(itrGridMainChargeCodeList.hasNext())
            {
			 try
			 {
             MasMainChargecode  mainChargecodeGrid = (MasMainChargecode)itrGridMainChargeCodeList.next(); 
			 if(dgmasInvestigation.getMainChargecode().getId().equals(mainChargecodeGrid.getId()) && mainChargecodeGrid.getStatus().equals("y"))
			 {
			 %> 
				data_arr[<%= counter%>][2] = "<%=mainChargecodeGrid.getMainChargecodeName()%>"
				
			<%
			}
			 else if(dgmasInvestigation.getMainChargecode().getId().equals(mainChargecodeGrid.getId()) && mainChargecodeGrid.getStatus().equals("n"))
			{
			%>
			data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=mainChargecodeGrid.getMainChargecodeName()%>";
			<%
			}
           }
			catch(Exception e)
			{
				e.printStackTrace();
			} 
			}%>		
			

		<%
		Iterator itrGridSubChargeCodeList=gridSubChargecodeList.iterator();
		 while(itrGridSubChargeCodeList.hasNext())
            {
			 try
			 {
             MasSubChargecode  subChargecodeGrid = (MasSubChargecode)itrGridSubChargeCodeList.next(); 
			 if(dgmasInvestigation.getSubChargecode().getId().equals(subChargecodeGrid.getId()) && subChargecodeGrid.getStatus().equals("y"))
			 {
			 %>
				data_arr[<%= counter%>][3] = "<%=subChargecodeGrid.getSubChargecodeName()%>"
			<%
			}
			 else if(dgmasInvestigation.getSubChargecode().getId().equals(subChargecodeGrid.getId()) && subChargecodeGrid.getStatus().equals("n"))
			{
			%>
			data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=subChargecodeGrid.getSubChargecodeName()%>";
			<%
			}
           		}
			catch(Exception e)
			{
				e.printStackTrace();
			} 
			}%>
		
		
		<%
		Iterator itrGridChargeCodeList=gridChargeCodeList.iterator();
		 while(itrGridChargeCodeList.hasNext())
            {
			 try
			 {
             MasChargeCode  chargeCodeGrid = (MasChargeCode)itrGridChargeCodeList.next(); 

			 if((dgmasInvestigation.getChargeCode().getId().equals(chargeCodeGrid.getId())) && chargeCodeGrid.getStatus().equalsIgnoreCase("y"))
			 {
			 %>
				data_arr[<%= counter%>][4] = "<%=chargeCodeGrid.getChargeCodeName()%>"
			<%
			}
			 else if(dgmasInvestigation.getId().equals(chargeCodeGrid.getId()) && chargeCodeGrid.getStatus().equals("n"))
			{
			%>
			data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=chargeCodeGrid.getChargeCodeName()%>";
			<%
			}
           }
			catch(Exception e)
			{
				e.printStackTrace();
			} }
			%>
			
			
			<%
			Iterator itrGridSampleList=sampleList.iterator();
			try
			 {
			 while(itrGridSampleList.hasNext())
            {
			 MasSample  sampleGrid = (MasSample)itrGridSampleList.next(); 
             if(dgmasInvestigation.getSample() != null && !dgmasInvestigation.getSample().equals("")){
            	if(dgmasInvestigation.getSample().getId().equals(sampleGrid.getId()) && sampleGrid.getStatus().equalsIgnoreCase("y"))
			 {
			 %>
				data_arr[<%= counter%>][5] = "<%=sampleGrid.getSampleDescription()%>"
			<%
			}
			 else if(dgmasInvestigation.getSample().getId().equals(sampleGrid.getId()) && sampleGrid.getStatus().equalsIgnoreCase("n"))
			{
			%>
				data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=sampleGrid.getSampleDescription()%>";
			<%	}
            		}
           else{
           %>
           data_arr[<%= counter%>][5] = "-"
           <%}}}
			catch(Exception e)
			{
				e.printStackTrace();
			} %>
		
	
			<%if (dgmasInvestigation.getNormalValue() != null){%>
			data_arr[<%= counter%>][6] ="<%= dgmasInvestigation.getNormalValue()%>"
			<%}else{%>
			data_arr[<%= counter%>][6] =""
			<%}%>
			
			
			
			<%
			Iterator itrGridUomList=gridUnitOfMeasurementList.iterator();
			try
			 {
			 while(itrGridUomList.hasNext())
            {
			 DgUom  uomGrid = (DgUom)itrGridUomList.next(); 
             if(dgmasInvestigation.getUom() != null && !dgmasInvestigation.getUom().equals("")){
            	if(dgmasInvestigation.getUom().getId().equals(uomGrid.getId()) && uomGrid.getStatus().equals("y"))
			 {
			 %>
				data_arr[<%= counter%>][7] = "<%=uomGrid.getUomName()%>"
			<%
			}
			 else if(dgmasInvestigation.getUom().getId().equals(uomGrid.getId()) && uomGrid.getStatus().equals("n"))
			{
			%>
				data_arr[<%= counter%>][7] = "<font id='error'>*</font>Parent InActivated--<%=uomGrid.getUomName()%>";
			<%	}
            		}
           else{
           %>
           data_arr[<%= counter%>][7] = "-"
           <%}}}
			catch(Exception e)
			{
				e.printStackTrace();
			} %>
		
		
			data_arr[<%= counter%>][8] ="<%= dgmasInvestigation.getConfidential()%>"
			data_arr[<%= counter%>][9] ="<%= dgmasInvestigation.getAppearInDischargeSummary()%>"	
			<%if(dgmasInvestigation.getQuantity() != null){
			%>
			data_arr[<%= counter%>][10] = "<%=dgmasInvestigation.getQuantity()%>"
			<%}else{%>
			data_arr[<%= counter%>][10] = ""
			<%}%>
			
			<%if(dgmasInvestigation.getInvestigationType() != null){%>
			data_arr[<%= counter%>][11] = "<%=dgmasInvestigation.getInvestigationType()%>"
			<%}else{%>
			data_arr[<%= counter%>][11] = ""
			<%}%>
			data_arr[<%= counter%>][12] = "<%=dgmasInvestigation.getLastChgBy()%>"
			data_arr[<%= counter%>][13] = "<%=dgmasInvestigation.getLastChgBy()%>"
			
			<%
			Iterator itrGridCollectionList=gridCollectionList.iterator();
			try
			 {
			 while(itrGridCollectionList.hasNext())
            {
				 DgMasCollection  collectionGrid = (DgMasCollection)itrGridCollectionList.next(); 
             if(dgmasInvestigation.getContainer() != null && !dgmasInvestigation.getContainer().equals("")){
            	if(dgmasInvestigation.getContainer().getId().equals(collectionGrid.getId()) && collectionGrid.getStatus().equals("y"))
			 {
			 %>
				data_arr[<%= counter%>][14] = "<%=collectionGrid.getCollectionName()%>"
			<%
			}
			 else if(dgmasInvestigation.getContainer().getId().equals(collectionGrid.getId()) && collectionGrid.getStatus().equals("n"))
			{
			%>
				data_arr[<%= counter%>][14] = "<font id='error'>*</font>Parent InActivated--<%=collectionGrid.getCollectionName()%>";
			<%	}
            		}
           else{
           %>
           data_arr[<%= counter%>][14] = "-"
           <%}}}
			catch(Exception e)
			{
				e.printStackTrace();
			} %>
			
			<%if(dgmasInvestigation.getStatus().equals("y")){ %>
			data_arr[<%= counter%>][15] = "Active"
			<%}else{%>
			data_arr[<%= counter%>][15] = "InActive"
			<%}%>
		
			<%if(dgmasInvestigation.getMinNormalValue() != null){
			%>
			data_arr[<%= counter%>][16] = "<%=dgmasInvestigation.getMinNormalValue()%>"
			<%}else{%>
			data_arr[<%= counter%>][16] = ""
			<%}%>
			
			<%if(dgmasInvestigation.getMaxNormalValue() != null){
			%>
			data_arr[<%= counter%>][17] = "<%=dgmasInvestigation.getMaxNormalValue()%>"
			<%}else{%>
			data_arr[<%= counter%>][17] = ""
			<%}%>
			
			<%if(dgmasInvestigation.getNumericOrString() != null){
			%>
			data_arr[<%= counter%>][18] = "<%=dgmasInvestigation.getNumericOrString()%>"
			<%}else{%>
			data_arr[<%= counter%>][18] = ""
			<%}%>
			
			<%if(dgmasInvestigation.getInstructions() != null){
				%>
				data_arr[<%= counter%>][19] = "<%=dgmasInvestigation.getInstructions()%>"
				<%}else{%>
				data_arr[<%= counter%>][19] = ""
				<%}%>

			<%
		     counter++;
       //    }
           }
			%>

 
formName = "chargeCode"

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);
intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<script type="text/javascript">
   <% 
   		if(pageNoTempFromBackButton > 1){ %>
   				goToPageLocal('<%=pageNoTempFromBackButton%>');
    <%	}
   %>
</script>