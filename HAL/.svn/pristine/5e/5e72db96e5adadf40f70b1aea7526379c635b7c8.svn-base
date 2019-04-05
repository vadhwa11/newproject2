<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * indentBD.jsp  
 * Purpose of the JSP -  This is for indentBD.
 * @author  Dipali
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script language="javascript">
	
	function checkForIndentToDepot(val,a,inc){
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    for(i=start;i<=end;i++){
	    if(pvms !="")
	    if(document.getElementById('codeItem'+i).value==pvms){
	    if(document.getElementById('codeItem'+inc).value!=pvms){
	    	alert("Item already selected...!")
	    	document.getElementById('nameItem'+inc).value=""
	    	
	    	return false;
	    	}
	    }}
		ajaxFunctionForAutoCompleteIndentToDepot('indent','stores?method=fillItemsForIndentToDepot&pvmsNo=' +  pvms , inc);
}

	// add javed khan
function autocompleteBasedOnPvms(val,inc)
{

	 for(i=1;i<=8;i++){
			if(val !=""){
				if(document.getElementById("codeItem"+i)!=null){
					
					 if(document.getElementById("codeItem"+i).value==val && i!=inc){
						
					 alert("PVMS No. is already Selected");
					 document.getElementById("codeItem"+inc).value="";
					 return false;
					 }
					 }}}
	
		ajaxFunctionForAutoCompleteForGrn('indentGrid','stores?method=fillItemsCommon&pvmsNo=' +  val , inc);
ajaxFunctionForAutoCompleteIndentToDepot('indent','stores?method=fillItemsForIndentToDepot&pvmsNo=' +  val , inc);
		
}
function ajaxFunctionForAutoCompleteForGrn(formName,action,rowVal) 
{
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
    	alert(e)
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
    var url=action
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	
      	for (loop = 0; loop < items.childNodes.length; loop++) 
      	{
	   	    var item = items.childNodes[loop];
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var name  = item.getElementsByTagName("name")[0];
	    	document.getElementById('nameItem'+rowVal).value = name.childNodes[0].nodeValue + "[" + pvms.childNodes[0].nodeValue + "]"
      }
    }
  }
}


function fillSrNo(rowVal){

	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%8
   		if(rowVal==0){
   			rowVal=8
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	return true;
}
function test(){
	var errorMessage="";
	formName="indent"
	obj = eval('document.'+formName)
	if(document.getElementById('supplyDepot').value == 0)
		errorMessage=errorMessage+"Please Select supply Depot  \n"; 
	
	if(document.getElementById('typeOfIndent').value == "")
		errorMessage=errorMessage+"Please Select type Of Indent \n";
	
	if((document.getElementById('supplyDepot').value != 0)  &&(document.getElementById('typeOfIndent').value != "")){
		return true;
	}else{
		alert(errorMessage)
		return false
	}

}

//add javed khan
function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
}
//add javed khan
function closeSearch()
{

document.getElementById('searchBlock').style.display = 'none';
}

</script>
<%
	Map map = new HashMap();
	String includedJsp = null;
	String previousPage="no";
	int pageNo=1;
	String noDetailRecords="no";
	List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
	List<StoreIndentM> gridIndentMList = new ArrayList<StoreIndentM>();
	List<StoreIndentT> gridIndentTList = new ArrayList<StoreIndentT>();
	List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
	List<MasStoreAirForceDepot> masStoreAirForceDepotList= new ArrayList<MasStoreAirForceDepot>();
	List<MasStoreSection> storeSectionList = new ArrayList<MasStoreSection>();
	String maxIndentNo="";
	String date="";
	String time="";
	String userName = "";
	List objectList=new ArrayList();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	 if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	//--------Hearder Variables-------
	String indentNo="";
	int indentId=0;
	String indentFrom="";
	String indentDate="";
	int supplyDepot=0;
	int indentOption=0;
	String  nrs="";
	String authority="";
	String address="";
	String contactNo="";
	String CodeHead="";
	String TellNo="";
	String SelfLife="";
	String delete="";
	int totalNumberOfPages = 0 ;
	//--------End -------- Hearder Variables-------
	try{
	if (request.getAttribute("map") != null) 
		map = (Map) request.getAttribute("map");
	
	if(map.get("indentNo")!=null)
		indentNo=""+map.get("indentNo");
	if(map.get("indentId")!=null)
	indentId= Integer.parseInt(""+map.get("indentId")) ;
	if(map.get("indentFrom")!=null)
	indentFrom =""+ map.get(" indentFrom");
	if(map.get("indentDate")!=null)
	indentDate =""+ map.get("indentDate");
	if(map.get("supplyDepot")!=null)
	supplyDepot =Integer.parseInt(""+map.get("supplyDepot")) ;
	if(map.get("address")!=null)
		address=""+map.get("address");
	if(map.get("CodeHead")!=null)
		CodeHead=""+map.get("CodeHead");
	if(map.get("TellNo")!=null)
		TellNo=""+map.get("TellNo");
	if(map.get("SelfLife")!=null)
		SelfLife=""+map.get("SelfLife");
	if(map.get("indentOption")!=null)
		indentOption=Integer.parseInt(""+map.get("indentOption")) ;
	if(map.get("contactNo")!=null)
		contactNo =""+map.get("contactNo");
	if(map.get("CodeHead")!=null)
		CodeHead =""+map.get("CodeHead");
	System.out.println(contactNo+CodeHead);
    if(map.get("authority")!=null)
		authority =""+map.get("authority");
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}
	if (map.get("totalNumberOfPages") != null) {
		totalNumberOfPages = Integer.parseInt(""+map.get("totalNumberOfPages"));
	}
	if(map.get("maxIndentNo")!=null)
		maxIndentNo=(""+map.get("maxIndentNo"));
	
	
	
	if(map.get("objectList")!=null)
		objectList=(List) map.get("objectList");
	if(map.get("searchIndentList")!=null)
	searchIndentList = (List) map.get("searchIndentList");
	if(map.get("itemList")!=null)
		itemList=(List) map.get("itemList");
	if(map.get("gridIndentMList")!=null)
		gridIndentMList=(List) map.get("gridIndentMList");
	
	if(map.get("gridIndentTList")!=null)
		gridIndentTList=(List) map.get("gridIndentTList");
	if(map.get("noDetailRecords")!=null){
		noDetailRecords=(""+map.get("noDetailRecords"));
	}
	if(map.get("masStoreAirForceDepotList")!=null)
		masStoreAirForceDepotList=(List) map.get("masStoreAirForceDepotList");
	
	if(map.get("sectionList")!=null)
		storeSectionList = (List<MasStoreSection>)map.get("sectionList");
	if(map.get("delete")!=null){
		delete=map.get("delete").toString();
	}
	int gridLen=0;
	if(map.get("gridLen")!=null){
		gridLen=(Integer)map.get("gridLen");
	}

	}catch(Exception e){
		e.printStackTrace();
	}
	
%>


<div class="titleBg">
<h2>Indent To Depot</h2>
</div>
<form name="indent" method="post">
<!-- 
<div class="search" id="threadsearch">
<a href="">Search</a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div> -->
<div class="clear"></div>
<%-- Start of Search Panel--%>
 <div id="searchBlock" style="display:none;">
<form name="indent1" method="post">
<div class="clear"></div>
<h6>SEARCH</h6>
<div class="clear"></div>
<div class="Block">
<form name="" method="">
<!-- -
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<form name="searchPanel" method="post">-->
<label>Indent No.</label>
<select name="<%= RequestConstants.INDENT_NO_FOR_SEARCH%>">
			<option value="0">Select</option>
			<%	for (StoreIndentM storeIndentM :searchIndentList ) {	%>
			<option value=<%=storeIndentM.getId()%>><%=storeIndentM.getIndentNo()%></option>
			<% }%>
		</select>
<!-- <input type="button" name="sss" class="button" value="SEARCH" 	onClick="submitForm('indent','stores?method=searchIndentDepot');" /> -->

<input type="button" name="sss" class="button" value="SEARCH" 	onClick="submitForm('indent','stores?method=newSearchIndent');" />
<input type="button" name="sss" class="button" value="CLOSE"  onClick="closeSearch();" />

<!-- </form>
</div>
  -->
<%-- End of Search Panel--%> <br />
</form>
</div>
</form>
</div>
<form name="indentGrid" method="post">
<div id="testDiv">
<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" />
<input type="hidden" size="2" value="0" name="<%=RequestConstants.NO_OF_ROWS%>"	id="<%=RequestConstants.NO_OF_ROWS%>" />
<input type="hidden" name="<%=RequestConstants.INDENT_ID %>" value="<%=indentId%>"	id="indentId" />
<input type="hidden"	name="<%=RequestConstants.NO_DETAIL_RECORDS%>"	value="<%=noDetailRecords%>" />
<input type="hidden" value="0" name="<%=RequestConstants.DEPARTMENT_ID_TEMP%>" />
<input type="hidden" name="indentType" value="old">

<%if(pageNo==1 || delete.equals("delete")){
				for(StoreIndentM storeIndentM:gridIndentMList){
			%>

<h4>Indent Details</h4>
<div class="clear"></div>
<div class="Block">
<label > Indent No.</label>
<input type="text" name="<%=RequestConstants.INDENT_NO %>"  value="<%=maxIndentNo%>" readonly="readonly" />
<!--<input	type="text" name="<%=RequestConstants.INDENT_NO %>"	value="<%=storeIndentM.getIndentNo()%>" readonly="readonly"	 MAXLENGTH="8" />
	--><!-- -<label>Indentor:</label>
	<input	type="text" readonly="readonly"	name="<%=RequestConstants.INDENT_FROM %>" value="Commandant,CHAFB"	class="textbox_size20" MAXLENGTH="20" />  -->
	<label>Indent Date</label>
	<input type="text"	name="<%=RequestConstants.INDENT_DATE%>" readonly="readonly"	value="<%=date%>"	 MAXLENGTH="30" />
	
	
	<label > Supply Depot</label> <select
	name="<%= RequestConstants.SUPPLY_DEPOT%>" tabindex="1"
	validate="Supply Depot,String,yes">
	<option value="0">Select</option>
	<%for(MasStoreAirForceDepot airForceDepot: masStoreAirForceDepotList){ 
					if(airForceDepot.getId()==storeIndentM.getSuppliedBy().getId()){
					%>
	<option value="<%=airForceDepot.getId() %>" selected="selected"><%=airForceDepot.getAirForceDepotName()%></option>
	<%}else{ %>
	<option value="<%=airForceDepot.getId() %>"><%=airForceDepot.getAirForceDepotName()%></option>
	<%}} %>
</select>
<div class="clear"></div>
<label >Type of Indent</label>
<select name="<%= RequestConstants.TYPE_OF_INDENT%>" tabindex="1"
	validate="Type Of Indent,num,yes">
	<option value="">Select</option>
	<%if(Integer.parseInt(""+1) ==1){ %>
	<option value="1" selected="selected">Emergent</option>
	<%}else{ %>
	<option value="1">Emergent</option>
	<%}%>
	<%if(Integer.parseInt(""+storeIndentM.getIndentOption())==2){ %>
	<option value="2" selected="selected">3 Months</option>
	<%}else{ %>
	<option value="2">3 Months</option>
	<%}%>
	<%if(Integer.parseInt(""+storeIndentM.getIndentOption())==3){ %>
	<option value="3" selected="selected">6 Months</option>
	<%}else{ %>
	<option value="3">Bi-Monthly</option>
	<%}%>
	<!--<%if(Integer.parseInt(""+storeIndentM.getIndentOption())==4){ %>
	<option value="4" selected="selected">Four Monthly</option>
	<%}else{ %>
	<option value="4">Four Monthly</option>
	<%}%>
--></select>
<label>Postal Address</label>
<%if(storeIndentM.getPatientDetails()!=null){ %>
<textarea	name="<%=RequestConstants.ADDRESS%>" rows="2" cols="30" tabindex="1"><%=storeIndentM.getPatientDetails() %></textarea>
<%}else{ %>
<textarea	name="<%=RequestConstants.ADDRESS%>" rows="2" cols="30" tabindex="1"></textarea>
<%} %>
<label >Authority</label>
<%if(storeIndentM.getAuthority()!=null){ %>
<textarea	name="<%=RequestConstants.AUTHORITY%>" cols="27" tabindex="1" rows="2"	><%=storeIndentM.getAuthority() %></textarea>
<%}else{%>
<textarea	name="<%=RequestConstants.AUTHORITY%>" cols="27" tabindex="1" rows="2"	></textarea>
<%} %>
<div class="clear"></div>
<!--<label >NRS</label>
<%if(storeIndentM.getNrs()  !=null){ %>
<input	type="text" name="<%= RequestConstants.NRS %>" tabindex="1"	value="<%=storeIndentM.getNrs() %>" MAXLENGTH="30" validate="NRS,String,no" />
<%} else{%>
<input	type="text" name="<%= RequestConstants.NRS %>" tabindex="1"	value="" MAXLENGTH="30" validate="NRS,String,yes" />
<%} %>
-->

<div class="clear"></div>
 <label>Life Span</label> 
		<select value="0" name="<%=SHELF_LIFE%>"  id="sl" validate="Life,string,no" tabindex=1>
		<option value="<%=storeIndentM.getSelfLife()%>" selected="selected"><%=storeIndentM.getSelfLife()%></option>
		<%if(!(storeIndentM.getSelfLife().toString().equalsIgnoreCase("SL"))){%>
		<option value="SL">SL</option>
		<%}%>
		<!--<%if(!(storeIndentM.getSelfLife().toString().equalsIgnoreCase("SLB"))){%>
		<option value="SLB">SLB</option>
		<%}%>
		--><%if(!(storeIndentM.getSelfLife().toString().equalsIgnoreCase("LL"))){%>
		<option value="LL">LL</option>
		<%}%>
</select>

<label>Section Name</label>
<%if(map.get("fromShowItem")!=null){%>
				<select id="sectionId1" name="sectionId"   onchange="populatePvmsNo(this.value)" tabindex=1>
				</select>
				<%}else{%>
				<select  name="sectionId" id="sectionId1"  onchange="setSecId();" tabindex=1>
			
				<option value="0">Select</option>
				  <%
				  for(MasStoreSection masStoreSection : storeSectionList) {
				  %>
				  <option value="<%=masStoreSection.getId()%>" ><%=masStoreSection.getSectionName()%></option>
				  <%}%>
				</select>
					<% }%>
				<input type="hidden" id="sectionId2" value="0" name="sec"/>

<!--
<label> NRS</label> 
<input	type="text" name="<%= RequestConstants.NRS %>" value="" MAXLENGTH="30" id="nrs" tabindex="1"/>
-->
<div class="clear"></div>

<label>Contact No.</label>
		<%if(storeIndentM.getTellNo() !=null){ %>
	<input type="text" name="<%=CONTACT_NUMBER %>" id="tellNo" value="<%=storeIndentM.getTellNo()%>" maxlength="10" />
	<%}else{ %>
	<input type="text" name="<%=CONTACT_NUMBER %>" id="tellNo" value="" maxlength="10"/>
	<%} %>
<label> Code Head</label> 
<%if(storeIndentM.getCodeHead()!=null){%>
<input	type="text" name="<%=CODE_HEAD%>" value="<%=storeIndentM.getCodeHead()%>" MAXLENGTH="50" id="codehead" tabindex="1"/>	
<%}else{%>
<input	type="text" name="<%=CODE_HEAD%>" value="" MAXLENGTH="30" id="codehead" tabindex="1"/>	
	<%}}}else
	{
	
	%>
	</div>
<div class="clear"></div>
<h4>Indent Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label > Indent No. </label> 
<input type="text" name="<%=RequestConstants.INDENT_NO %>" value="<%=indentNo%>" readonly="readonly" MAXLENGTH="8" /> 
<!--<label >Indentor</label> 
<input type="text" readonly="readonly" name="<%=RequestConstants.INDENT_FROM %>" value="Commandant,CHAFB" MAXLENGTH="20" /> 

-->
<label >Indent Date</label> 
<input type="text" name="" readonly="readonly" value="<%=date%>" 	MAXLENGTH="30" /> 
<input type="hidden"	name="<%=RequestConstants.INDENT_DATE%>" value="<%=date %>"	 MAXLENGTH="30" /> 
<label > Supply Depot </label>
<select name="<%= RequestConstants.SUPPLY_DEPOT%>"	validate="Supply Depot,String,yes">
	<option value="0">Select</option>
<%for(MasStoreAirForceDepot airForceDepot: masStoreAirForceDepotList){ 
						if(airForceDepot.getId()==supplyDepot){					%>
	<option value="<%=airForceDepot.getId() %>" selected="selected"><%=airForceDepot.getAirForceDepotName()%></option>
	<%}else{ %>
	<option value="<%=airForceDepot.getId() %>"><%=airForceDepot.getAirForceDepotName()%></option>
	<%}} %>
</select>
<div class="clear"></div>
<label >Type of Indent</label>
<select name="<%= RequestConstants.TYPE_OF_INDENT%>"	validate="Type Of Indent,num,yes">
<option value="">Select</option>
	<%if(indentOption==1){ %>
	<option value="1" selected="selected">Emergent</option>
	<%}else{ %>
	<option value="1">Emergent</option>
	<%}%>
	<%if(indentOption==2){ %>
	<option value="2" selected="selected">Monthly</option>
	<%}else{ %>
	<option value="2">Monthly</option>
	<%}%>
	<%if(indentOption==3){ %>
	<option value="3" selected="selected">Bi-Monthly</option>
	<%}else{ %>
	<option value="3">Bi-Monthly</option>
	<%}%>
	<%if(indentOption==4){ %>
	<option value="4" selected="selected">Four Monthly</option>
	<%}else{ %>
	<option value="4">Four Monthly</option>
	<%}%>
</select> 
<!--<label >NRS</label>
<input	type="text" readonly="readonly" name="nrs1" value="<%=nrs%>" MAXLENGTH="30" validate="NRS,String,yes" />
<input	type="hidden" name="<%= RequestConstants.NRS %>" value="<%=nrs%>" MAXLENGTH="30" /> 
-->
<label>Postal Address</label>
<textarea	name="address2" rows="2" cols="30" readonly="readonly"><%=address %></textarea>
<input type="hidden" name="<%=RequestConstants.ADDRESS %>"	value="<%=address %>" />


<label >Authority</label>
<textarea	name="Authority1" cols="27" rows="2" readonly="readonly" ><%=authority %></textarea>
<input type="hidden"	name="<%=RequestConstants.AUTHORITY %>" value="<%=authority %>" />

<div class="clear"></div>
 <label>Life Span</label> 
		<select value="0" name="<%=SHELF_LIFE%>"  id="sl" validate="Life,string,no" tabindex=1>
		<%if(SelfLife=="SL"){%>
		<option value="SL" selected="selected">SL</option>
		<%}else{%>
		<option value="SL">SL</option>
		<%}%>
		<!--<%if(SelfLife=="SLB"){%>
		<option value="SLB" selected="selected">SLB</option>
		<%}else{%>
		<option value="SLB">SLB</option>
		<%}%>
		-->
		<%if(SelfLife=="LL"){%>
		<option value="LL" selected="selected">LL</option>
		<%}else{%>
		<option value="LL" >LL</option>
		<%}%>
		
		</select>

<label>Section Name</label>
<%if(map.get("fromShowItem")!=null){%>
				<select id="sectionId1" name="sectionId"   onchange="populatePvmsNo(this.value)" tabindex=1>
				</select>
				<%}else{%>
				<select  name="sectionId" id="sectionId1"  onchange="setSecId();" tabindex=1>
			
				<option value="0">Select</option>
				  <%
				  for(MasStoreSection masStoreSection : storeSectionList) {
				  %>
				  <option value="<%=masStoreSection.getId()%>" ><%=masStoreSection.getSectionName()%></option>
				  <%}%>
				</select>
					<% }%>
				<input type="hidden" id="sectionId2" value="0" name="sec"/>

<!--
<label> NRS</label> 
<input	type="text" name="<%= RequestConstants.NRS %>" value="" MAXLENGTH="30" id="nrs" tabindex="1"/>
-->
<div class="clear"></div>








<label>Contact No.</label>
<input type="text" name="<%=CONTACT_NUMBER %>" id="conNo" value="<%=contactNo %>" maxlength="10" tabindex="1"/>
	 <label> Code Head</label> 

<input	type="text" name="<%=CODE_HEAD%>" value="<%=CodeHead%>" MAXLENGTH="50" id="codehead" tabindex="1"/>	
	<%
} %>
</div>
<!--
commented By:Ujjwal
<input type="button"	class="button" value="Next" 	onclick="if( checkSave()&&checkForNext()){submitForm('indentGrid','stores?method=updateNextOrSubmitIndentToDepot&buttonName=next');}" />
<input type="button" name="sss" class="button" value="Update"	onclick="if( checkSave()&&checkForSubmit()){submitForm('indentGrid','stores?method=updateNextOrSubmitIndentToDepot&buttonName=submit');}" />
<input type="button" name="sss" class="button" value="Delete"	onclick="submitForm('indentGrid','stores?method=deleteGridItemsForIndentDepo');" />
-->

<div class="clear"></div>
<h4>Item Details</h4>
<div id="pagination">
Page No.:
<span class="selected"><%=pageNo%></span>
</div>
<div class="clear"></div>
<div class="cmntable">
<table width="100%" colspan="7" id="indentDetails" border="0" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th width="5%">Sl No.</th>
			<th width="13%">PVMS No.</th>
			<th width="10%">Nomenclature</th>
			<th width="3%">A/U</th>
			<!--<th width="13%">Section</th>
			--><th width="13%"> MMF</th>
			<th width="13%">Qty in Stock </th>
			
			<th width="6%">Qty	Demanded</th>
			<th width="6%"></th>
		</tr>

	</thead>
	<tbody>
		<%
    	int inc=1;
    	int detailCounter=8; 
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String qtyInHandTemp="qtyInHandTemp";
    	String qtyInHand="qtyInHand";
    	String idAu="idAu";
    	String oldNiv="oldNiv";
    	String departmentId="departmentId";
    	
    	String stockInVar="stockInVar";
    	String mmfVar="mmfVar";
    	String demandVar="demandVar";
    	
    	String stockInVarTemp="stockInVarTemp";
    	String mmfVarTemp="mmfVarTemp";
    	String demandVarTemp="demandVarTemp";
    	String incVar="incVar";
    	
    	
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String qtyInHandTemp2="qtyInHandTemp";
    	String qtyInHand2="qtyInHand";
    	String idAu2="idAu";
    	String oldNiv2="oldNiv";
    	
    	String stockInVar2="stockInVar";
    	String mmfVar2="mmfVar";
    	String demandVar2="demandVar";

    	String stockInVarTemp2="stockInVarTemp";
    	String mmfVarTemp2="mmfVarTemp";
    	String demandVarTemp2="demandVarTemp";
    	String incVar2="incVar2";
    	String departmentId2="departmentId";
    	String section="section";
    	String section2="section";
    	if(pageNo!=1){
    	inc=((pageNo-1)*8)+1;
    	}
 	   
 	   int incTemp2=inc+8;
 	   for(StoreIndentT storeIndentT:gridIndentTList){
 		  if(inc<=incTemp2){
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		qtyInHandTemp=qtyInHandTemp2+(""+inc);
     		qtyInHand=qtyInHand2+(""+inc);
     		idAu=idAu2+(""+inc);
     		oldNiv=oldNiv2+(""+inc);
     		stockInVar=stockInVar2+(""+inc);
     		mmfVar=mmfVar2+(""+inc);
     		demandVar=demandVar2+(""+inc);
     		departmentId=departmentId2+(""+inc);

     		stockInVarTemp=stockInVarTemp2+(""+inc);
     		mmfVarTemp=mmfVarTemp2+(""+inc);
     		demandVarTemp=demandVarTemp2+(""+inc);
     		incVar=incVar2+(""+inc);
    	  %>
		<tr>
			<td width="5%">
			<input type="text" size="2" value="<%=inc%>"  name="<%=RequestConstants.SR_NO%>" readonly="readonly" />
			</td>
			<td width="10%">
			<%if(storeIndentT.getItem().getPvmsNo()!=null){%>
			 <input type="text"	value="<%=storeIndentT.getItem().getPvmsNo() %>"	name="<%=RequestConstants.NEW_NIV %>"  id="<%=codeItem%>" readonly="readonly"/>
			 <input type="hidden" value="<%=storeIndentT.getItem().getId() %>" name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" />
			 <input type="hidden" name="<%=RequestConstants.DETAIL_ID %>" value="<%=storeIndentT.getId() %>" id="hdb" />
			 <%}else{ %>
			 <input type="text" value="0" name="<%=RequestConstants.NEW_NIV %>" readonly="readonly" id="<%=codeItem%>" onblur="autocompleteBasedOnPvms(this.value,'<%=inc%>');" /> 
			 <input type="hidden" value="0" name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" />
			 <input type="hidden" name="<%=RequestConstants.DETAIL_ID %>" value="0" id="hdb" />
			 <%}%> 
			 </td>
			<td width="10%">
			<input type="text" value="<%=storeIndentT.getItem().getNomenclature() %>" tabindex="1" id="<%=nameItem%>" class="bigcaption"
			onblur="if(fillSrNo('<%=inc %>')){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=inc %>');}"				name="<%=nameItem%>" readonly="readonly" size="50" />
		<div id="ac2update" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		function eventCallback(element, entry){
			return entry + "&sec=" + document.getElementById('sectionId2').value+"&sl="+document.getElementById('sl').value;
		}
		  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForIndentToDepot',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentId').value, callback: eventCallback});
		</script>
			</td>
			<td width="3%">
			<input type="text" value="<%=storeIndentT.getItem().getItemConversion().getItemUnitName() %>"  onblur="fillValuesForDemand(<%=inc%>);" readonly="readonly"	name="<%=RequestConstants.AV%>" id="<%=idAu%>" />
			</td>
			<%try{ %><!--
			<td width="10%">
			<input type="text" value="<%=storeIndentT.getItem().getSection().getSectionCode() %>" id="<%=section%>" readonly="readonly" size="8">
			</td>
			--><%}catch(Exception e){ %>
			<td width="10%">
			<input type="text" id="<%=section%>" value="" size="8" >
			</td>
			<%} %>
			<%if(storeIndentT.getQtyInMmf()!=null){ %>
			<td width="10%">
			<input type="text" size="7" MAXLENGTH="7" value="<%=storeIndentT.getQtyInMmf() %>" tabindex=1 name="<%=RequestConstants.QTY_IN_MMF_TEMP%>" id="<%=mmfVarTemp%>" validate="Qty In MMF,floatWithoutSpaces,no"
				onblur="fillValuesForMmf(<%=inc%>);" size="8" /> 
			<input type="hidden" value="<%=storeIndentT.getQtyInMmf() %>" name="<%=RequestConstants.QTY_IN_MMF%>" tabindex="2" id="<%=mmfVar%>" size="8"/>
			</td>
			<%}else{ %>
			<td width="10%">
			<input type="text" size="7" MAXLENGTH="7" value="" tabindex=1 name="0" id="<%=mmfVarTemp%>" validate="Qty In MMF,num,no" onblur="fillValuesForMmf(<%=inc%>);" size="8"/>
			<input type="hidden" value="" name="0" tabindex="2" id="<%=mmfVar%>" size="8"/>
			</td>
			<%} %>
			<%if(storeIndentT.getStockIn()!=null){ %>
			<td width="10%">
			<input type="text" readonly="readonly" value="<%=storeIndentT.getStockIn() %>" name="<%=RequestConstants.QTY_IN_HAND%>" id="<%=qtyInHand%>" validate="Qty In Stock,num,no" size="8" /> 
			</td>
			<%}else{ %>
			<td width="10%">
			<input type="text" size="7" readonly="readonly" value="0" name="<%=RequestConstants.QTY_IN_HAND%>" id="<%=qtyInHand%>" validate="Qty In Stock,num,no" size="8"/> 
			</td>
			<%} %>
			
			<td width="10%">
			<input type="text" size="7" MAXLENGTH="7" value="<%=storeIndentT.getQtyInDemand() %>" name="<%=RequestConstants.QTY_DEMAND%>" tabindex="1"
				id="<%=demandVar%>"  validate="Qty In Demand,floatWithoutSpaces,no"size="8" /> 
			<input type="hidden" value="<%=storeIndentT.getQtyInDemand() %>"	name="<%=RequestConstants.QTY_DEMAND_TEMP%>" tabindex="2" id="<%=demandVarTemp%>" size="8"/>
			</td>
			<td align="center" width="10%"><input type="checkbox"
				name=<%=ITEMS_TO_BE_DELETED%> id="itemToBeDeleted" class="radio"
				value="<%=storeIndentT.getId()%>">
				
				
				</td>
		</tr>
		<% inc++;}}%>
		<script>
	    	 document.indentGrid.noOfRows.value=<%=inc-((pageNo-1)*8)-1%>
	    	 </script>

		<%if(inc<incTemp2){
			  for(;inc<incTemp2;inc++){
				  idItem=idItem2+(""+inc);
		     		codeItem=codeItem2+(""+inc);
		     		nameItem=nameItem2+(""+inc);
		     		qtyInHandTemp=qtyInHandTemp2+(""+inc);
		     		qtyInHand=qtyInHand2+(""+inc);
		     		idAu=idAu2+(""+inc);
		     		oldNiv=oldNiv2+(""+inc);
		     		stockInVar=stockInVar2+(""+inc);
		     		mmfVar=mmfVar2+(""+inc);
		     		demandVar=demandVar2+(""+inc);
		     		departmentId=departmentId2+(""+inc);

		     		stockInVarTemp=stockInVarTemp2+(""+inc);
		     		mmfVarTemp=mmfVarTemp2+(""+inc);
		     		demandVarTemp=demandVarTemp2+(""+inc);
		     		incVar=incVar2+(""+inc);
		     		section=section2+(""+inc);
			  %>
		<tr>
			<td width="5%">
			<input type="text" size="2" value="<%=temp+inc%>"  name="<%=RequestConstants.SR_NO%>"	readonly="readonly" />
			</td>
			<td width="10%">
			<input type="text" name="<%=RequestConstants.NEW_NIV %>" id="<%=codeItem%>" onblur="autocompleteBasedOnPvms(this.value,'<%=inc%>');" tabindex="1" />
			<input type="hidden" value="0" name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" />
		    </td>
			<td width="10%">
			<input type="text" value="" tabindex="1" id="<%=nameItem%>" class="bigcaption"

onblur="if(fillSrNo('<%=inc %>')){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=inc %>');}fillValuesForDemand(<%=inc%>);"
				name="<%=nameItem%>" tabindex="1" size="50"/>
				
				
			<div id="ac2update" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		function eventCallback(element, entry){
			return entry + "&sec=" + document.getElementById('sectionId2').value+"&sl="+document.getElementById('sl').value;
		}
		  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForIndentToDepot',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentId').value, callback: eventCallback});
		</script>
			</td>
			<td width="3%">
			<input type="text" value=""   name="<%=RequestConstants.AV%>" id="<%=idAu%>" onblur="fillValuesForDemand(<%=inc%>);" tabindex="1" />
			<input type="hidden" value="" id="<%=section%>" tabindex="1"  readonly="readonly" /></td>
			<!--<td width="10%">
			<input type="text" value="" id="<%=section%>" tabindex="1"  size="8"/>
			</td>
			-->
			<td width="10%">
			<input type="text" MAXLENGTH="7" value="" tabindex=1 name="<%=RequestConstants.QTY_IN_MMF_TEMP%>" id="<%=mmfVarTemp%>"	validate="Qty In MMF,floatWithoutSpaces,no"		onblur="fillValuesForMmf(<%=inc%>);" size="8"/>
				<input type="hidden" value="0" name="<%=RequestConstants.QTY_IN_MMF%>"
				tabindex="2" id="<%=mmfVar%>" size="8" />
			</td>
			
			<td width="10%">
			<input type="text" name="<%=RequestConstants.QTY_IN_HAND%>" id="<%=qtyInHand%>"  value="" size="8" MAXLENGTH="7" tabindex="1" /> 
			</td>

			
			<td width="10%">
			<input type="text" MAXLENGTH="7" value="0" name="<%=RequestConstants.QTY_DEMAND%>"
				 tabindex="1" id="<%=demandVar%>" onblur="fillValuesForDemand(<%=inc%>);" validate="Qty In Demand,floatWithoutSpaces,no" size="8"/> 
			<input type="hidden" value="0" name="<%=RequestConstants.QTY_DEMAND_TEMP%>" tabindex="2" id="<%=demandVarTemp%>" size="8"/>
			</td>
			<td align="center" width="10%"><input type="checkbox" name=<%=ITEMS_TO_BE_DELETED%> id="itemToBeDeleted" class="radio" value="">
			</td>

		</tr>

		<% }}%>

	</tbody>
</table></div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button"	class="button" value="Next" 	onclick="if(checkForNext()){submitForm('indentGrid','stores?method=updateNextOrSubmitIndentToDepot&buttonName=next');}" />
<input type="button" name="sss" class="button" value="Update"	onclick="if( checkForSubmit()){submitForm('indentGrid','stores?method=updateNextOrSubmitIndentToDepot&buttonName=submit');}" />
<input type="button" name="sss" class="button" value="Delete"	onclick="submitForm('indentGrid','stores?method=deleteGridItemsForIndentDepo');" />
<input	type="button" name="Add" onClick="jsSubmit()" value="Submit"	class="button" />
<!--<input type="button" name="sss" class="button" value="Exit"	onclick="submitForm('indentGrid','login?method=showHomeJsp');" />

-->
<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" /> 
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label >Changed By:</label>
<label class="value"><%=userName%></label>
<label >Changed Date:</label>
<label class="value"><%=date%></label>
<label >Changed Time:</label>
<label class="value"><%=time%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>
<script type="text/javascript">
function jsSubmit()
{
	
		if(checkSaveSubmit()){
			submitForm('indentGrid','stores?method=updateNextOrSubmitIndentToDepot&buttonName=close');
			}
		//}
}
function checkSaveSubmit()
{
		if(confirm("After submit, you can't add new item or change existing item.Kindly confirm ?"))
			return true;
		else
			return false;
}
</script>



<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" />
<div class="paddingTop40"></div>
</form>