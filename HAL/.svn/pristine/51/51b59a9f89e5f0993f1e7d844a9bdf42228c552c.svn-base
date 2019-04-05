<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * issueToDispensaryManual.jsp  
 * Purpose of the JSP -  This is for Issue to Dispensary Manual.
 * @author  Vivek
 * Create Date: 7th April,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

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
	
	function checkForIssueToOTAFU(val,a,inc)
{
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*20)+1;
    	var end=((pageNo-1)*20)+20;
    	
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
	    
		ajaxFunctionForAutoCompleteIssueToDispensary('issueToOTAFU','stores?method=fillItemsForIssueToDispensary&pvmsNo=' +  pvms , inc);
}
 
	
	function test(){
		if(document.getElementById('mmfForTheYear').value ==0){
			alert("Please Select MMF Year..!");
			return false;
		}else{
			return true;
		}
}

function fillSrNo(rowVal){

	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%20
   		if(rowVal==0){
   			rowVal=20
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	return true;
}

  function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=printExternalIssueJsp";
  obj.submit();
}

function goPage()
{
var page = parseInt(document.getElementById('page').value);
var totalPages = parseInt(document.getElementById('totalPages').value);
if (page > totalPages)
{
alert('Kindly provide valid Page No!...');
document.getElementById('page').value="";
return;
}
submitForm('issueToOTAFU','stores?method=addNextOrSubmitIssueToOTAFU&buttonName=goToPage');
}

function goRefresh()
{
var issueUnit = document.getElementById('issueId').value;
submitForm('issueToOTAFU','stores?method=searchIssueToOTAFU&issueUnit='+issueUnit+ "&pageNo=1");
}

 </script>


<%
	Map map = new HashMap();
	String includedJsp = null;
	String previousPage="no";
	int nrs=0;
	String indentOption="";
	int pageNo=1;
	int indentId=0;
	int internalIndentId=0;
	int listSize=0;
	String userName="";
	String date="";
	String time="";
	String max="";
	List<MasStoreBrand> masStoreBrandList= new ArrayList<MasStoreBrand>();
	List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
	List issueTList=new ArrayList();
	List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
	List<MasUnit> masUnitList= new ArrayList<MasUnit>();
	List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
	List<Patient> patientList= new ArrayList<Patient>();
	List <StoreIssueM> searchListForPopup=new ArrayList<StoreIssueM>();
		int maxIndentNo=0;
		Box box=HMSUtil.getBox(request);
		if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		}
		if(map.get("employeeList")!=null){
			employeeList = (List) map.get("employeeList");
			System.out.print("employeeList      "+employeeList.size());
		}
		if(map.get("box")!=null){
			box=(Box)map.get("box");
		}
		if(map.get("departmentList")!=null)
			departmentList = (List) map.get("departmentList");
		if(map.get("masUnitList")!=null)
			masUnitList = (List) map.get("masUnitList");
		if(map.get("itemList")!=null)
			itemList = (List) map.get("itemList");
		if(map.get("patientList")!=null)
			patientList = (List) map.get("patientList");
		if(map.get("internalIndentId")!=null){
			internalIndentId=Integer.parseInt(""+map.get("internalIndentId"));
			System.out.println("internalIndentId  "+internalIndentId);
		}
		if(map.get("masStoreBrandList")!=null)
			masStoreBrandList = (List) map.get("masStoreBrandList");
		System.out.println("masStoreBrandList  "+masStoreBrandList.size());
		if(map.get("max")!=null)
			max = (String) map.get("max");
		
		if(map.get("pageNo")!=null)
			pageNo = Integer.parseInt(""+map.get("pageNo"));
	
		if(map.get("listSize")!=null)
			listSize = Integer.parseInt(""+map.get("listSize"));
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		 date = (String)utilMap.get("currentDate");	 
		 time = (String)utilMap.get("currentTime");
		 if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
		 
			if(map.get("issueTList")!=null){
				issueTList=(List)map.get("issueTList");
			}
			System.out.println("issueTList.,.,.,..............,.,.," + issueTList);
			if(map.get("searchListForPopup")!=null){
				searchListForPopup=(List<StoreIssueM>)map.get("searchListForPopup");
			}

			List stockList= new ArrayList();
			if(map.get("stockList")!=null){
				stockList=(List)map.get("stockList");
				System.out.println("Available stock list -------"+stockList.size());
			}
			
			 int totalPages=0;
			 if(map.get("totalPages")!=null){
				 totalPages=(Integer)map.get("totalPages");
				}
%>
<br />
<h2 align="left" class="style1">Issues To other than Airforce Units
</h2>
<div id="contentspace">

<form name="issueToOTAFU" method="post"><input type="hidden"
	name="pageNo" value="<%=pageNo%>" id="pageNo" />


<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
		<table width="20%" align="right" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" value="Delete"
					class="toolbutton" onclick="openDeletePopupForIssueOTAFU();" /></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="print" type="submit" class="toolbutton"
					value="Print" onClick="showReport('issueToOTAFU');"></td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>

<%--------------- Start of Search Panel ---------------------------%>
<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">
<form name="searchPanel" method="post">
<table width="330" border="0" cellpadding="2" cellspacing="1"
	style="border: 1px solid #245E83;">
	<tr>
		<td width="324" class="thead">Search Panel<a
			name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><label
			class="bodytextB">Issue No:</label> <select
			name="<%= RequestConstants.ISSUE_UNIT_ID%>"">
			<option value="">Select</option>
			<%for (StoreIssueM storeIssueM :searchListForPopup ) {%>
			<option value=<%=storeIssueM.getId()%>><%=storeIssueM.getIssueNo()%></option>
			<%}%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('issueToOTAFU','stores?method=searchIssueToOTAFU');" />
		</td>
	</tr>

</table>
</form>
</div>
</div>
</div>
<%-------------------- End of Search Panel ---------------------------%>

</form>

<%if((""+box.get("issueId")).equals("")){%> <input type="hidden"
	name="<%=RequestConstants.ISSUE_ID %>" value="0" id="issueId" /> <%}else{ %>
<input type="hidden" name="<%=RequestConstants.ISSUE_ID %>"
	value="<%=box.get("issueId") %>" id="issueId" /> <%} %> <br />

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Issue Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 85px; background-color: #f4f9fe; padding-top: 10px; padding-bottom: 5px;">


<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" /> <label
	class="bodytextB"><font id="error"></font> Extern. IV No: </label> <input
	type="text" name="<%=RequestConstants.ISSUE_NO %>"
	value="<%=max+box.get("issueNo") %>" id="issueNo"
	class="textbox_size20" style="width: 140px;" MAXLENGTH="8"/  >

<label class="bodytextB"><font id="error"></font>Issue Date:</label> <input
	type="text" name="<%=RequestConstants.ISSUE_DATE%>" readonly="readonly"
	value="<%=box.get("issuedDate").equals("")?date:box.get("issuedDate") %>"
	class="textbox_size20" style="width: 140px;" id="isssueDate" /> <label
	class="bodytextB"><font id="error"></font>Unit Name :</label> <select
	name="<%= RequestConstants.DEPARTMENT_ID_TEMP%>" id="departmentIdTemp">
	<option value="">Select</option>
	<%for (MasUnit masStoreAirForceDepot :masUnitList ) {%>
	<option value=<%=masStoreAirForceDepot.getId()%>
		<%=HMSUtil.isSelected(masStoreAirForceDepot.getId().toString(),box.get("departmentIdTemp")) %>><%=masStoreAirForceDepot.getUnitName()%></option>
	<%}%>
</select> <br />
<label class="bodytextB"><font id="error"></font>Ref No:</label> <input
	type="text" name="<%= RequestConstants.DOC_NO%>"
	value="<%=box.get("docNo")%>" class="textbox_size20"
	style="width: 140px;" id="docNo" /> <label class="bodytextB"><font
	id="error"></font>Demand Date:</label> <input type="text"
	name="<%=RequestConstants.ISSUE_DATE%>" readonly="readonly"
	value="<%=box.get("demandDate").equals("")?date:box.get("demandDate") %>"
	class="textbox_size20" style="width: 140px;" id="isssueDate" /> <br />
<label class="bodytextB"><font id="error"></font>Request By:</label> <select
	name="<%= RequestConstants.REQUEST_BY%>" id="requestBy">
	<option value="">Select</option>
	<%for (MasEmployee masEmployee:employeeList ) {	%>
	<option value=<%=masEmployee.getId()%>
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("requestBy")) %>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select> <label class="bodytextB"><font id="error"></font>Approved No:</label> <select
	name="<%= RequestConstants.APPROVED_BY%>" id="approvedBy">
	<option value="">Select</option>
	<%for (MasEmployee masEmployee:employeeList ) {%>
	<option value=<%=masEmployee.getId()%>
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("approvedBy")) %>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select> <label class="bodytextB"><font id="error"></font>Issued By:</label> <select
	name="<%= RequestConstants.ISSUED_BY%>" id="issuedBy">
	<option value="">Select</option>
	<%for (MasEmployee masEmployee:employeeList ) {%>
	<option value=<%=masEmployee.getId()%>
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("issuedBy")) %>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select> <input type="hidden" name="<%=RequestConstants.NO_OF_ROWS%>"
	id="<%=RequestConstants.NO_OF_ROWS%>" value="0" /> <input
	type="hidden" name="totalPages" id="totalPages" value="<%=totalPages%>" />
</div>
<br />


<div style="float: left; padding-left: 15px;"><input type="button"
	class="button" value="Next"
	onclick="submitForm('issueToOTAFU','stores?method=addNextOrSubmitIssueToOTAFU&buttonName=next');"
	align="right" /> <!-- 		<input type="button" name="sss" align="right" class="button" value="Submit" onclick="if(checkForSubmit()&&test()){{submitForm('issueToOTAFU','stores?method=addNextOrSubmitIssueToOtherUnits&buttonName=submit');}}"/>  -->
</div>


<div style="float: left; padding-left: 15px; padding-bottom: 10px;">
<label class="bodytextB">Page No:</label>
<div class="changebydt" style="width: 65px;"><%=pageNo%></div>
<td width="9%"><input type="text" name="ValueOfPage"
	<%if(box.getString("pvmsNo1").equals("")){ %> value="<%=pageNo+1%>"
	<%}else{%> value="" <%}%> id="page" class="textbox_small_size"
	MAXLENGTH="3" /></td>
<td width="21%"><input type="button" name="goToPage" value="Go"
	onClick="goPage()" class="smbutton"
	style="background: url(/hms/jsp/images/smbutton.gif) !important; width: 31px; height: 21px; font-size: 11px; color: #FFFFFF !important; margin-right: 8px; border: none;" />
</td>
</div>
<label class="bodytextB">Total Pages:</label>
<div class="changebydt" style="width: 65px;"><%=totalPages%></div>

<input type="button" name="Refresh" value="Refresh"
	onClick="goRefresh();" class="button" />
	<input type="hidden" name="<%=RequestConstants.INDENT_ID %>" value="<%=indentId%>" id="hdb" />
	<br/> <div style="width: 15px; height: 20px; float:left;"></div>
	<div style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid;  BORDER-LEFT: #9A9A9A 1px solid;   width: 187px; height: 20px; float:left;">
	<font class="boxtitle">Item Details</font>
	</div>
	<div style="width: 15px; float:left;"><img src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
	<br/>
	<table width="200px" colspan="7" id="indentDetails" class="grid_header" border="1" cellpadding="0" cellspacing="0">
  <thead>
    <tr>
      <td width="5%"><label valign="left" class="gridsmlabel">SR No</label></td>
      <td width="13%"><label valign="left" class="smalllabel">PVMS No</label>      </td>
      <td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>  </td>
      <td width="13%"><label valign="left" class="gridsmlabel">A/U</label>      </td>
        <td width="6%"><label valign="left" class="smalllabel">Lot/Batch No</label>      </td>
      <td width="6%"><label valign="left" class="smalllabel">Req Qty</label>      </td>
      <td width="10%"><label valign="left" class="smalllabel">Qty Issued</label>  </td>
      <td width="10%"><label valign="left" class="smalllabel">Issue</label>  </td>
    </tr>
  </thead>
  
   <tbody>
  
    	<%try{
        	int detailCounter=10; 
        	int temp=0;
        	String idItem="idItem";
        	String codeItem="codeItem";
        	String nameItem="nameItem";
        	String idSection="idSection";
        	String nameSection="nameSection";
        	String idAu="idAu";
        	
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
        	String idSection2="idSection";
        	String nameSection2="nameSection";
        	String idAu2="idAu";
        	
        	String stockInVar2="stockInVar";
        	String mmfVar2="mmfVar";
        	String demandVar2="demandVar";

        	String stockInVarTemp2="stockInVarTemp";
        	String mmfVarTemp2="mmfVarTemp";
        	String demandVarTemp2="demandVarTemp";
        	String incVar2="incVar2";
        	
        	
        	String issuedName = "issuedName";
        	String issuedName2 = "issuedName";
        	String qtyIssued="qtyIssued";
        	String qtyIssued2="qtyIssued";
        	String lotNo="lotNo";
        	String lotNo2="lotNo";

        	int inc=((pageNo-1)*20)+1;
     	    int incTemp2=inc+20;

 	   
 		for (Iterator iterator = issueTList.iterator(); iterator.hasNext();) 
		{
		 Object[] object = (Object[]) iterator.next();

 		  if(inc<=incTemp2)
 		  {
 				idItem=idItem2+(""+inc);
 	     		codeItem=codeItem2+(""+inc);
 	     		nameItem=nameItem2+(""+inc);
 	     		idSection=idSection2+(""+inc);
 	     		nameSection=nameSection2+(""+inc);
 	     		idAu=idAu2+(""+inc);
 	     		
 	     		stockInVar=stockInVar2+(""+inc);
 	     		mmfVar=mmfVar2+(""+inc);
 	     		demandVar=demandVar2+(""+inc);
 	     		

 	     		stockInVarTemp=stockInVarTemp2+(""+inc);
 	     		mmfVarTemp=mmfVarTemp2+(""+inc);
 	     		demandVarTemp=demandVarTemp2+(""+inc);
 	     		incVar=incVar2+(""+inc);
 	     		
 	     		issuedName = issuedName2+(""+inc);
 	     		qtyIssued=qtyIssued2+(""+inc);
 	     		lotNo=lotNo2+(""+inc);
     		//lotNo=lotNo2+(""+inc);
    	  %>
      <tr>
      <td width="5%"><input type="text" size="2" value="<%=temp+inc%>" class="smcaption" name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
      <td width="10%">
      <input type="text" name="<%=RequestConstants.ITEM_CODE%>" value="<%=object[1].toString()%>" readonly="readonly" class="medcaption" id="<%=codeItem%>"/>
      <input type="hidden" size="2"	value="0" class="smcaption" name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" />
      
      </td>
      <td width="10%">
      <input type="text" value="<%=object[2].toString()%>" tabindex="1"	id="<%=nameItem%>" class="bigcaption"  name="<%=nameItem%>"   readonly="readonly" />
	  </td>
      <td width="10%">
      <input type="text" value="<%=object[3].toString()%>" class="smcaption"  name="<%=RequestConstants.AU%>" id="<%=idAu %>" tabindex="2"  readonly="readonly" />
      </td>
       <input type="hidden" value=""	id="<%=issuedName%>" class="bigcaption"  />
       <td width="10%"><input type="text" value=""	id="<%=lotNo%>" class="medcaption"  readonly="readonly"  /></td>
         <td width="10%"><input type="text" value="<%=object[7].toString()%>" validate="Qty Requested Year,floatWithoutSpaces,no" MAXLENGTH="7"	 class="medcaption"  readonly="readonly" /></td>
         <td width="10%"><input type="text"	value="<%=object[8].toString()%>" class="medcaption" name="<%=RequestConstants.QTY_ISSUED%>" readonly="readonly" tabindex="2" id="<%=qtyIssued%>" />
      </td>
      <td width="3%">
      <input type="button" class="morebutton" tabindex="1" onclick="openPopupForBrandForOTAFU(<%=inc%>);" name="Submit2" value=" "  /> 
         </td>
         <div id="ewe">
         </div>
          </tr>
       <% inc++;}  } 
       					if(inc<=(pageNo-1)*20+20){
	    			  for(;inc<=(pageNo-1)*20+20;inc++){
	    					idItem=idItem2+(""+inc);
	    	 	     		codeItem=codeItem2+(""+inc);
	    	 	     		nameItem=nameItem2+(""+inc);
	    	 	     		idSection=idSection2+(""+inc);
	    	 	     		nameSection=nameSection2+(""+inc);
	    	 	     		idAu=idAu2+(""+inc);
	    	 	     		
	    	 	     		stockInVar=stockInVar2+(""+inc);
	    	 	     		mmfVar=mmfVar2+(""+inc);
	    	 	     		demandVar=demandVar2+(""+inc);
	    	 	     		

	    	 	     		stockInVarTemp=stockInVarTemp2+(""+inc);
	    	 	     		mmfVarTemp=mmfVarTemp2+(""+inc);
	    	 	     		demandVarTemp=demandVarTemp2+(""+inc);
	    	 	     		incVar=incVar2+(""+inc);
	    	 	     		
	    	 	     		issuedName = issuedName2+(""+inc);
	    	 	     		qtyIssued=qtyIssued2+(""+inc);
	    	 	     		lotNo=lotNo2+(""+inc);
	    			  %>
	    <tr>
      <td width="5%"><input type="text" size="2"	value="<%=temp+inc%>" class="smcaption" name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
      <td width="10%">
      <input type="text" name="<%=RequestConstants.ITEM_CODE%>" value="" readonly="readonly" class="medcaption" id="<%=codeItem%>"/>
      <input type="hidden" size="2"	value="0" class="smcaption" name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" />
      
      </td>
      <td width="10%">
      <input type="text" value="" tabindex="1"	id="<%=nameItem%>" class="bigcaption" onblur="if(fillSrNo(<%=inc %>)){checkForIssueToOTAFU(this.value, '<%=nameItem%>','<%=inc %>');}"  name="<%=nameItem%>" />
		<div id="ac2update" style="display:none;  padding-right: 550px;; background-color:white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForIssueToDispensary',{parameters:'requiredField=<%=nameItem%>&issueId='+document.getElementById('issueId').value});
		</script>
		</td>
      <td width="10%">
      <input type="text"	value="" class="smcaption"  name="<%=RequestConstants.AU%>" id="<%=idAu %>" tabindex="2" />
      </td>
       <input type="hidden" value=""	id="<%=issuedName%>" class="bigcaption"  />
       <td width="10%"><input type="text" value=""	id="<%=lotNo%>" class="medcaption" onblur="fillGridIssueToOTAFU('issueToOTAFU','stores?method=fillIssueToOTAFUBasedOnLotNo&lotNo='+this.value , <%=inc %>);" /></td>
         <td width="10%"><input type="text" value="0" validate="Qty Requested Year,floatWithoutSpaces,no" MAXLENGTH="7"	 class="medcaption"  /></td>
         <td width="10%"><input type="text"	value="" class="medcaption" name="<%=RequestConstants.QTY_ISSUED%>" readonly="readonly" tabindex="2" id="<%=qtyIssued%>" />
      </td>
      <td width="3%">
      <input type="button" class="morebutton" tabindex="1" onclick="openPopupForBrandForOTAFU(<%=inc%>);" name="Submit2" value=" "  /> 
         </td>
         <div id="ewe">
         </div>
          </tr>
	    			  <%}} }catch(Exception e ){e.printStackTrace();}
	    			  %>
         </tbody>
  
</table>
</form>
<br />
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <%--Start of Change Panel--%> <label class="bodytextB">Changed
By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" id="totalQty" /> <%--End of Change Panel--%>

</form>

</div>

<script type="text/javascript">

function test(){
	var errorMessage="";
	formName="issueDispensaryManualForm"
	obj = eval('document.'+formName)
	if(document.getElementById('issuedBy').value == "")
		errorMessage=errorMessage+"Please Select Issue By \n"; 
	if(document.getElementById('approvedBy').value == "")
		errorMessage=errorMessage+"Please Select Approved By \n";
	if(document.getElementById('requestBy').value == "")
		errorMessage=errorMessage+"Please Select Requested By \n";
	if(document.getElementById('departmentIdTemp').value == "")
		errorMessage=errorMessage+"Please Select Dispensary \n";
	if(document.getElementById('docNo').value == "")
		errorMessage=errorMessage+"Please Fill Reference No \n";
	
	if((document.getElementById('issuedBy').value != "") &&(document.getElementById('docNo').value != "") &&(document.getElementById('departmentIdTemp').value != "") &&(document.getElementById('requestBy').value != "")&&(document.getElementById('approvedBy').value != "")){
		return true;
	}else{
		alert(errorMessage)
		return false
	}

}
</script>