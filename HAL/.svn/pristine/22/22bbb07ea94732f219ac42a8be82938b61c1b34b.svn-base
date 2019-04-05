<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Collections"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.util.Box"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
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
	    for(i=1;i<=8;i++){
	    if(document.getElementById('codeItem'+i) !=null){
	    if(pvms !=""){
	    if(document.getElementById('codeItem'+i).value==pvms){
	    if(document.getElementById('codeItem'+inc).value!=pvms){
	    	alert("Item already selected...!")
	    	document.getElementById('nameItem'+inc).value=""
	    	
	    	return false;
	    	}
	    }}}}
		ajaxFunctionForAutoCompleteIndentToDepot('indent','stores?method=fillItemsForIndentToDepot&pvmsNo=' +  pvms , inc);
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
	if((document.getElementById('supplyDepot').value != 0)  &&(document.getElementById('typeOfIndent').value != "") )
		{
		return true;
	}else{
		alert(errorMessage)
		return false
	}

}

function autocompleteBasedOnPvms(val,inc)
{
		ajaxFunctionForAutoCompleteForGrn('indentGrid','stores?method=fillItemsCommon&pvmsNo=' +  val , inc);
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
</script>
<%
	Map map = new HashMap();
	String includedJsp = null;
	String previousPage="no";
	int pageNo=1;
	Box box=HMSUtil.getBox(request);
	String lifeType="";
	List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
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
	int indentId=0;
	int supplyDepot=0;
	int sectionId=0;
	int indentOption=0;
	String indentFrom="";
	String indentDate="";
	String indentNo="";
	String  nrs="";
	String authority="";
	String address="";
	int ctNo=0;
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
	
	if(map.get("indentOption")!=null)
		indentOption=Integer.parseInt(""+map.get("indentOption")) ;
	if(map.get("nrs")!=null)
	nrs=(""+map.get("nrs")) ;
	if(map.get("authority")!=null)
	authority=""+map.get("authority");
	if(map.get("address")!=null)
	address =""+map.get("address");
	if(map.get("contactNo") !=null)
	ctNo=(Integer)map.get("contactNo");
	
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}
	if(map.get("maxIndentNo")!=null)
		maxIndentNo=(""+map.get("maxIndentNo"));
	

	if(map.get("masStoreAirForceDepotList")!=null)
		masStoreAirForceDepotList=(List) map.get("masStoreAirForceDepotList");
	if(map.get("objectList")!=null)
		objectList=(List) map.get("objectList");
	if(map.get("searchIndentList")!=null)
	searchIndentList = (List<StoreIndentM>) map.get("searchIndentList");
	
	if(map.get("sectionList")!=null)
		storeSectionList = (List<MasStoreSection>)map.get("sectionList");


	}catch(Exception e){
		e.printStackTrace();
	}
	List objectList2 = new ArrayList();

	if (map.get("objectList2") != null) {
		objectList2 = (List)map.get("objectList2");
		System.out.println("objectList in jsp "+objectList2.size());

	}
	if(map.get("lifeType") !=null){
		lifeType =""+ map.get("lifeType");
		System.out.println("lifeType>"+lifeType);
		}
	List indentList = new ArrayList();
	if (map.get("indentList") != null) {
		indentList = (List)map.get("indentList");
		System.out.println("indentList in jsp "+indentList.size());

	}
	String hosNameAdd="";
	if (map.get("hosNameAdd") != null) {
		hosNameAdd = (String)map.get("hosNameAdd");
		System.out.println("hosNameAdd in jsp "+hosNameAdd);

	}
	
	
	 String section_Id="";
	  if(map.get("section") !=null){
			section_Id =""+ map.get("section");
			System.out.println("section createAuto >"+section_Id);
			}
%>


<div class="titleBg"><h2>Indent To Depot</h2></div>
<form name="indent" method="post">
<!-- -
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<form name="searchPanel" method="post">
<label>Indent No.</label>
<select name="<%= RequestConstants.INDENT_NO_FOR_SEARCH%>">
			<option value="0">Select</option>
			<%	for (StoreIndentM storeIndentM :searchIndentList ) {	%>
			<option value=<%=storeIndentM.getId()%>><%=storeIndentM.getIndentNo()%></option>
			<% }%>
		</select> 
<input type="image" class="button" value=" "	onClick="submitForm('indent','stores?method=searchIndentDepot');" />
		
</form>
</div>
 -->
<%-- End of Search Panel--%> <br />
</form>
<div class="clear"></div>
<form name="indentGrid" method="post">

<div id="testDiv">
<h4>Indent Details</h4>
<div class="clear"></div>
<div class="Block">
<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" /> 
<input type="hidden" size="2" value="0" name="<%=RequestConstants.NO_OF_ROWS%>"id="<%=RequestConstants.NO_OF_ROWS%>" />
<input type="hidden" name="<%=RequestConstants.INDENT_ID %>" value="<%=indentId%>" id="indentId" />

	 <%if(indentId==0){
	 %>

<label> Indent No. </label> 
 <input type="text" name="<%=RequestConstants.INDENT_NO %>" value="<%= maxIndentNo%>"  id="indentNo" readonly="readonly" />
 <!-- -
 <label	>Indentor :</label> 
 <input	type="text" readonly="readonly"	name="<%=RequestConstants.INDENT_FROM %>" value="Commandant,CHAFB"
	MAXLENGTH="20" />  -->
<label>Indent Date</label>
<input type="text" name="<%=RequestConstants.INDENT_DATE%>" readonly="readonly"value="<%=date %>" MAXLENGTH="30" />

<label> Supply Depot <span>*</span></label> 
<select	name="<%= RequestConstants.SUPPLY_DEPOT%>" id="supplyDepot"	validate="Supply Depot,string,yes" tabindex="1">
	<option value="0">Select</option>
	<%for(MasStoreAirForceDepot airForceDepot: masStoreAirForceDepotList){ %>
	<option value="<%=airForceDepot.getId() %>"
		<%=HMSUtil.isSelected(airForceDepot.getId().toString(),map.get("supplyDepot")) %>><%=airForceDepot.getAirForceDepotName()%></option>
	<%} %>
</select> 

<div class="clear"></div>

<label>Type of Indent<span>*</span></label>
<select name="<%= RequestConstants.TYPE_OF_INDENT%>" id="typeOfIndent"	tabindex="1">
	<option value="">Select</option>
	<option value="1">Emergent</option>
	<option value="2">3 Months</option>
	<option value="3">6 Months</option>
	<!-- <option value="4">Four Monthly</option>     --><!-- 28 marchjaved khan  -->
</select> 

<label>Postal Address</label>
<textarea name="<%=RequestConstants.ADDRESS%>" 	value="<%=hosNameAdd %>" MAXLENGTH="200" rows="2" cols="30" id="address" class="txtarea" tabindex="1"><%=hosNameAdd %></textarea>

<label> Authority</label>
<textarea name="<%=RequestConstants.AUTHORITY%>" MAXLENGTH="100" tabindex="1"
	cols="27" rows="2" id="Authority" class="txtarea" value="">
</textarea>
<!--
<label> NRS</label> 
<input	type="text" name="<%= RequestConstants.NRS %>" value="" MAXLENGTH="30" id="nrs" tabindex="1"/>
-->
<div class="clear"></div>
<label>Self Life</label>
<%if(!lifeType .equals("a")) {%>
<input type="text" name="shelfLife" id="shelfLife" value="<%=lifeType %>" maxlength="10" tabindex="1"/>
<%}else{ %>
<input type="text" name="shelfLife" id="shelfLife" value="" maxlength="10" tabindex="1"/>
<%}%>

<label>Section Name</label>
<%-- 
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
--%>
<%if(!section_Id.equals("0") && !section_Id.equals("")){%>
				<select id="sectionId1" name="sectionId"   onchange="" tabindex=1>
			
				
				  <%
				  for(MasStoreSection masStoreSection : storeSectionList) {
					 System.out.println(masStoreSection.getId()+"  out  "+section_Id);
					  if(masStoreSection.getId()==Integer.parseInt(section_Id)){
						  System.out.println(masStoreSection.getId()+" in "+sectionId+" -- "+masStoreSection.getSectionName());
				  %>
				  <option value="<%=masStoreSection.getId()%>"><%=masStoreSection.getSectionName()%></option>
				  <%}} %>
				  <%
				  for(MasStoreSection masStoreSection : storeSectionList) {
					
				  %>
				  <option value="<%=masStoreSection.getId()%>" ><%=masStoreSection.getSectionName()%></option>
				  <%}%>
				  	</select>
				<%}else{%>
				<select  name="sectionId" id="sectionId1"  onchange="" tabindex=1>

				<option value="0">Select</option>
				  <%
				  for(MasStoreSection masStoreSection : storeSectionList) {
				  %>
				  <option value="<%=masStoreSection.getId()%>" ><%=masStoreSection.getSectionName()%></option>
				  <%}%>
				</select>
					<% }%>
				<input type="hidden" id="sectionId2" value="0" name="sec"/>				

<div class="clear"></div>
<label>Contact No.</label>
<input type="text" name="<%=CONTACT_NUMBER %>" id="conNo" value="" maxlength="10" tabindex="1"/>
<label> Code Head<span>*</span></label> 
<input	type="text" name="<%= RequestConstants.CODE_HEAD%>" value="749/02" MAXLENGTH="30" id="codehead" validate="Code Head,string,yes" tabindex="1"/>
<%}else{ %>
<label>Indent No. </label>
<input type="text" name="<%=RequestConstants.INDENT_NO %>"	value="<%=indentNo%>" id="indentNo" onblur="duplicateIndent(this.value);"/> 
	
	<!-- 
<label>Indentor :</label>
<input type="text" readonly="readonly" name="<%=RequestConstants.INDENT_FROM %>" value="Commandant,CHAFB"MAXLENGTH="20" /> -->

<label>Indent Date</label> 
<input type="text" name=""	readonly="readonly" value="<%=date%>" MAXLENGTH="30" /> 
<input type="hidden" name="<%=RequestConstants.INDENT_DATE%>" value="<%=date %>" MAXLENGTH="30" /> 

<label>Supply Depot</label> <select
	name="<%= RequestConstants.SUPPLY_DEPOT%>" id="supplyDepot">
	<option value="0">Select</option>
	<%for(MasStoreAirForceDepot airForceDepot: masStoreAirForceDepotList){ 
					if(airForceDepot.getId()==supplyDepot){
					%>
	<option value="<%=airForceDepot.getId() %>" selected="selected"><%=airForceDepot.getAirForceDepotName()%></option>
	<%}else{ %>
	<option value="<%=airForceDepot.getId() %>"><%=airForceDepot.getAirForceDepotName()%></option>
	<%}} %>
</select> 

<div class="clear"></div>
<label>Type of Indent</label>
<select name="<%= RequestConstants.TYPE_OF_INDENT%>" id="typeOfIndent">
	<option value="">Select</option>
	<%if(indentOption==1){ %>
	<option value="1" selected="selected">Emergent</option>
	<%}else{ %>
	<option value="1">Emergent</option>
	<%}%>
	<%if(indentOption==2){ %>
	<option value="2" selected="selected">3 Months</option>
	<%}else{ %>
	<option value="2">3 Months</option>
	<%}%>
	<%if(indentOption==3){ %>
	<option value="3" selected="selected">6 Months</option>
	<%}else{ %>
	<option value="3">6 Months</option>
	<%}%>
	<!-- javed khan 28 march  -->
	
</select> 
<label>Postal Address</label> 
 <textarea name="address2" rows="2" cols="30" readonly="readonly" id="address" class="txtarea"><%=address %></textarea>
<input type="hidden" name="<%=RequestConstants.ADDRESS %>"	value="<%=address %>" />

<label>Authority</label>
<textarea name="Authority1" cols="27" rows="2" readonly="readonly" id="Authority" class="txtarea"><%=authority %>
</textarea>
 <input type="hidden" name="<%=RequestConstants.AUTHORITY %>" value="<%=authority %>" /> 
 
 <div class="clear"></div>
 
 <label>NRS</label>
<input	type="text" readonly="readonly" name="nrs1" value="<%=nrs%>" MAXLENGTH="30" id="nrs" /> 
<input type="hidden" name="<%= RequestConstants.NRS %>" value="<%=nrs%>" MAXLENGTH="30" />
 
<label>Contact No.</label>
<input type="text" id="conNo" name="<%=CONTACT_NUMBER %>" value="<%=ctNo %>" maxlength="10" tabindex="1" readonly="readonly"/>
 <%} %>
</div>


<div class="clear"></div>
<!-- <input type="button" class="button" value="Next"	onclick="if( test()&&checkForNext()&&checkSave()){submitForm('indentGrid','stores?method=addNextOrSubmitIndentToDepot&buttonName=next');}"/> 
<input type="button" name="sss" class="button" value="Submit" onclick="if(test()){submitForm('indentGrid','stores?method=submitAutoIndentToDepot&buttonName=submit');}" />
<input type="button" name="sss" class="button" value="Exit"	onclick="submitForm('indentGrid','login?method=showHomeJsp');" />-->
</div>
<div id=flagDiv>



</div>


<h4>Item Details</h4>
<div id="pagination">
Page No.
<span class="selected"><%=pageNo%></span>
</div>
<div class="clear"></div>
<!-- 
<table width="100%" colspan="7" id="indentDetails" border="0" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>SR No</th>
			
      
			<th width="5%">PVMS No.</th>
			<th width="15%">Nomenclature</th>
			<th width="3%">A/U</th>
			<th width="15%">Section</th>
			<th width="15%">Quantity In Stock </th>
			<th width="15%">Quantity	in MMF</th>
			<th width="24%">Quantity Demand</th>
		</tr>
	</thead>
	<tbody>
		<%
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
    	String section="section";    	
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
    	String section2="section";
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=detailCounter;inc++){
     		 
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
		<td width="3%"><input type="text" size="2" value="<%=temp+inc%>"  name="<%=RequestConstants.SR_NO%>"
			readonly="readonly" /></td>

		<td width="5%">
		<input name="<%=RequestConstants.ITEM_CODE %>" type="text"  id="<%=codeItem%>"
			size="8" onblur="autocompleteBasedOnPvms(this.value,'<%=inc%>');" tabindex="1"/>
		<input type="hidden" value="0" name="<%=RequestConstants.ITEM_ID%>"id="<%=idItem%>" /> 
		<input type="hidden" value="0" name="<%=RequestConstants.DEPARTMENT_ID_TEMP%>"id="<%=departmentId%>" />
		</td>
			
		<td width="15%"><input type="text" value="" id="<%=nameItem%>"  name="<%=nameItem%>"
			onblur="if(fillSrNo('<%=inc %>')){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=inc %>');}"
			 tabindex="1" />
		<div id="ac2update" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForIndentToDepot',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentId').value });
		</script></td>
		<td width="3%"><input name="<%=RequestConstants.AV%>" type="text" tabindex="1"  id="<%=idAu%>" value=""
			size="4" readonly="readonly" /></td>
		<td width="15%"><input type="text" value="" id="<%=section%>" tabindex="1"  readonly="readonly" /></td>
		<td width="15%"><input type="text" value="0" 
			tabindex="1" name="<%=RequestConstants.QTY_IN_HAND%>" MAXLENGTH="7"
			id="<%=qtyInHand%>" validate="Qty In Stock,num,no"  readonly/> </td>

		<td width="15%"><input type="text" tabindex="1" value=""  tabindex=1
			name="<%=RequestConstants.QTY_IN_MMF_TEMP%>" MAXLENGTH="7"
			id="<%=mmfVarTemp%>" validate="Qty In MMF,floatWithoutSpaces,no"
			onblur="fillValuesForMmf(<%=inc%>);" />
	  <input type="hidden"	value="0"  name="<%=RequestConstants.QTY_IN_MMF%>"
			tabindex="2" id="<%=mmfVar%>" /></td>
			
		<td width="24%"><input type="text" size="7" tabindex="1"  value=""
			 name="<%=RequestConstants.QTY_DEMAND%>" MAXLENGTH="7" tabindex="1" id="<%=demandVar%>"
			onblur="fillValuesForDemand(<%=inc%>);" validate="Qty In Demand,floatWithoutSpaces,no" />
			<input type="hidden"  value="0" name="<%=RequestConstants.QTY_DEMAND_TEMP%>" tabindex="2"
			id="<%=demandVarTemp%>" /></td>
	</tr>
	<% }   %>
	
</tbody>
</table>
-->
<%if(objectList2.size()>0){ %>
 <div style="height:350px; width:1000px; overflow-x:  scroll; overflow-y: scroll ;">
<table id="cmntableWithHeight">
	<thead>
		<tr>
			<th>Sl No.</th>
			<th>PVMS NO.</th>
			<th>Nomenclature</th>
			<th>A/U</th>
			 <!-- <th>Section</th>  -->
			 <th>Qty in Stock</th>
			<th>MMF</th>
			<th>Qty Demanded</th>
			
		</tr>
	</thead>

	<% if(indentList.size()>0){int r=0;
	//if(objectList2.size()>0){int r=0;
	
		for(int i=0; i<indentList.size() ; i++){
			//Object[]	ob=(Object[])objectList2.get(i);
			
			Object[] ob=(Object[])indentList.get(i);
			
			
		//	System.out.println("indent trn-- "+ob[0]+"  "+ob[1]+"  "+ob[2]+"  "+ob[3]+"  "+ob[4]);
			//System.out.println(" object trn-- "+ob[0]+"  "+ob[1]+"  "+ob[2]+"  "+ob[3]+"  "+ob[4]);

			
			%>	
	
	
<tr>
<td width="3%">
<input type="text" size="5" value="<%=i+1%>5555"  name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
<td><input type="text" value="<%= ob[0]%>" name="dt" id="dt" size="6" readonly="readonly"/>
<input type="hidden" value="<%=ob[7]%>" name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" />
<input type="hidden" value="0" name="<%=RequestConstants.DEPARTMENT_ID_TEMP%>" id="<%=departmentId%>" />
</td>
<td><input type="text" value="<%=ob[1]%>" name="doc" size="80" id="doc" readonly="readonly"/></td> 

<td><input type="text" size="7" value="<%=ob[2]%>" name="<%=RequestConstants.AV%>" id="au" readonly="readonly"/></td>
<!-- <td><input type="text" value="<%=ob[8]%>" name="sect" id="sect" readonly="readonly"/></td> -->
<td><input type="text" size="7" value="<%=ob[5]%>" name="<%=RequestConstants.QTY_IN_HAND%>" id="<%=qtyInHand%>" readonly="readonly"/></td>
<td><input type="text" size="7" value="<%=ob[4]%>" name="<%=RequestConstants.QTY_IN_MMF%>" id="<%=mmfVarTemp%>" readonly="readonly"/></td>

<%/* 
int indentQty=0;
int mmfForIndent=0;
int mmf=((BigDecimal)ob[3]).intValue();

							int closingStock=((BigDecimal)ob[4]).intValue();
							if(lifeType.equals("SLB")){
							 mmfForIndent=6*mmf;
							}else if(lifeType.equals("SLA")){
								mmfForIndent=5*mmf;
							}else if(lifeType.equals("LL"))
							{
								mmfForIndent=9*mmf;
							}
							if(mmfForIndent>closingStock)
							{
								System.out.println("IN IF");
								indentQty=mmfForIndent-closingStock;
								 //objectList1.add(indentQty);
							}
							else{
								System.out.println("IN ELSE");
								//objectList1.remove(iterator.next());
							}*/
							%>
 <td><input type="text" size="7" value="<%=ob[6]%>" name="<%=RequestConstants.QTY_DEMAND%>" id="bal" readonly="readonly"/></td>
</tr>
<%}} %>

</table>
</div>
<%} %>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<input type="button" class="button" value="Next"	onclick="if( test()){submitForm('indentGrid','stores?method=submitAutoIndentToDepot&buttonName=next');}"/>
<input type="button" name="sss" class="button" value="Update" onclick="if(test()&& checkSave()){submitForm('indentGrid','stores?method=submitAutoIndentToDepot&buttonName=submit');}" />
<input type="button" name="sss" class="button" value="Submit" onclick="if(test()){submitForm('indentGrid','stores?method=submitAutoIndentToDepot&buttonName=close');}" />

<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName%></label>

<label>Changed Date:</label>
<label class="value"><%=date%></label>

<label>Changed Time:</label>
<label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<div class="clear"></div>
</form>
<script type="text/javascript">vBulletin_init();</script> 
<input	type="hidden" name="rows" id="rr" value="1" /></div>
<Script>

// javed khan
function submitProtoAjaxdiv11(formName,action){
	//alert(formName);
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
//	alert(action);
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 //var url=action+"&"+getNameAndData(formName)
	var url=action
    	   	//alert(url);
        	new Ajax.Updater('flagDiv',url,{asynchronous:false, evalScripts:true }); 
			return true;
    	} 	

function duplicateIndent(indentNo)
{
//alert(indentNo)
	
	submitProtoAjaxdiv11('indentGrid','stores?method=responseForIndentNoList&indentNo='+indentNo)
	var flag=document.getElementById('existIndentNo').value;
	if(flag=="true")
	{
	alert("IndentNo already Exist pls Check Your Entered IndentNo!!!!!");
	document.getElementById('indentNo').value="";
	document.getElementById('indentNo').focus();
	}

}


</Script>
