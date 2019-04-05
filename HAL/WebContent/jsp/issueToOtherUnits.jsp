<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<%--For AutoComplete--%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String curDate=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(curDate.length()<2){
		curDate="0"+curDate;
	}
%>
	serverdate = '<%=curDate+"/"+month1+"/"+year1%>'
</script>
<script language="javascript">

	function checkForIssueToOTAFU(val,a,inc)
{
		var pageNo =parseInt(document.getElementById('pageNo').value)
		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;

	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	   // for(i=start;i<=end;i++){
	   // if(pvms !="")
	   // if(document.getElementById('codeItem'+i).value==pvms){
	   // if(document.getElementById('codeItem'+inc).value!=pvms){
	    	//alert("Item already selected...!")
	    	//document.getElementById('nameItem'+inc).value=""
	    	//return false;
	    	//}
	    //}}
  if(pvms != "")
	  {
	 	 ajaxFunctionForAutoCompleteIssueToDispensary('issueToOtherUnitsForm','stores?method=fillItemsForIssueToDispensary&pvmsNo=' +  pvms , inc);
	  }
		
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

	//alert("rowVal--->"+rowVal);

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
submitForm('issueToOtherUnitsForm','stores?method=addNextOrSubmitIssueToOtherUnits&buttonName=goToPage');
}

function goRefresh()
{
var issueUnit = document.getElementById('issueId').value;
submitForm('issueToOtherUnitsForm','stores?method=searchIssueToOtherUnits&issueUnit='+issueUnit+ "&pageNo=1");
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
	int issueId =0;

	List<MasStoreBrand> masStoreBrandList= new ArrayList<MasStoreBrand>();
	List<MasEmployee> employeeList= new ArrayList<MasEmployee>();

	List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
	List<MasHospital> masStoreAirForceDepotList= new ArrayList<MasHospital>();
	List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
	List<Patient> patientList= new ArrayList<Patient>();
	List <StoreIssueM> searchListForPopup=new ArrayList<StoreIssueM>();
	List issueTList=new ArrayList();


		int maxIndentNo=0;
		String issueType="";
		Box box=HMSUtil.getBox(request);
		if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		}
		if(map.get("employeeList")!=null){
			employeeList = (List) map.get("employeeList");
		}

		if(map.get("box")!=null){
			box=(Box)map.get("box");
		}




		if(map.get("departmentList")!=null)
			departmentList = (List) map.get("departmentList");
		if(map.get("masStoreAirForceDepotList")!=null)
			masStoreAirForceDepotList = (List) map.get("masStoreAirForceDepotList");
		if(map.get("itemList")!=null)
			itemList = (List) map.get("itemList");
		if(map.get("patientList")!=null)
			patientList = (List) map.get("patientList");
		if(map.get("internalIndentId")!=null){
			internalIndentId=Integer.parseInt(""+map.get("internalIndentId"));
		}
		if(map.get("masStoreBrandList")!=null)
			masStoreBrandList = (List) map.get("masStoreBrandList");
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

		 if(box.get("issueId")!="")
		 issueId=Integer.parseInt(""+box.get("issueId"));

			if(map.get("issueTList")!=null){
				issueTList=(List)map.get("issueTList");
			}
			if(map.get("searchListForPopup")!=null){
				searchListForPopup=(List<StoreIssueM>)map.get("searchListForPopup");
			}

			List stockList= new ArrayList();
			if(map.get("stockList")!=null){
				stockList=(List)map.get("stockList");
			}

			 int totalPages=0;
			 if(map.get("totalPages")!=null){
				 totalPages=(Integer)map.get("totalPages");
				}

%>
<div class="clear"></div>
<div class="titleBg">
<h2>Issues To Other Units on Surplus</h2>
</div>


<!--<table class="tborder" width="100%" align="center">-->
<!--	<tr>-->
<!--		<td width="20%" nowrap="nowrap" class="vbmenu_control"-->
<!--			id="threadsearch"><a href="">Search</a> <script-->
<!--			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>-->
<!--		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>-->


<!--		</td>-->
<!--	</tr>-->
<!--</table>-->

<%--------------- Start of Search Panel ---------------------------%>
<!--<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">-->

<!--  javed khan -->
<div class="clear"></div>
<div id="searchBlock" style="display:none;">
<form name="OtherUnitCiv" method="post" action="">
<!-- <div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>  -->
<div class="clear"></div>
<h6>SEARCH</h6>
<!--
 <form name="searchPanel" method="post">

<div class="searchBlock" id="threadsearch_menu" style="display: none">
-->
<!--<table width="330" border="0" cellpadding="2" cellspacing="1"-->
<!--	style="border: 1px solid #245E83;">-->
<!--	<tr>-->
<!--		<td width="324" class="thead">Search Panel<a-->
<!--			name="goto_threadsearch"></a></td>-->
<!--	</tr>-->
<!--	<tr>-->
<!--		<td class="vbmenu_option" title="nohilite">
-->
<div class="clear"></div>
<div class="Block">
<form name="" method="">
<div class="clear"></div>
<label> Extern  IV No. </label>
<select
			name="<%= RequestConstants.ISSUE_UNIT_ID%>">
<option value="0">Select</option>
			<%
			System.out.println("searchListForPopup----- "+searchListForPopup.size());
			for (StoreIssueM storeIssueM :searchListForPopup ) {%>
<option value=<%=storeIssueM.getId()%>><%=storeIssueM.getIssueNo()%></option>
			<%}%>
</select>
<!--
<input type="image" class="button" value=""
			onClick="submitForm('searchPanel', 'stores?method=searchIssueToOtherUnits');" />
			 -->

			<input type="button" name="sss" class="button" value="SEARCH" onClick="otherUnitCivDisplay();" />

<!--		</td>-->
<!--	</tr>-->
<!---->
<!--</table>-->
</form>
</div>
</form>
</div>


<%-------------------- End of Search Panel ---------------------------%>
<form name="issueToOtherUnitsForm" method="post">
<%if((""+box.get("issueId")).equals("")){%>
<input type="hidden" name="<%=RequestConstants.ISSUE_ID %>" value="0" id="issueId" />
 <%}else{ %>
<input type="hidden" name="<%=RequestConstants.ISSUE_ID %>"	value="<%=box.get("issueId") %>" id="issueId" /> <%} %>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<h4>Issue Details</h4>
<div class="clear"></div>
<div class="clear"></div>



<div class="Block">
<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" />
<label> Extern  IV No. </label>
<input type="text" name="<%=RequestConstants.ISSUE_NO %>" value="<%=max+box.get("issueNo") %>" id="issueNo"/>

<label >Issue Date </label>
<input	type="text"   name="<%=RequestConstants.ISSUE_DATE%>" readonly="readonly"
	value="<%=box.get("issuedDate").equals("")?date:box.get("issuedDate") %>" id="isssueDate" />
<img  id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=date%>',document.issueToOtherUnitsForm.<%=RequestConstants.ISSUE_DATE%>,event)" />
<div class="clear"></div>
<label>Unit Name </label>
<select	name="<%= RequestConstants.DEPARTMENT_ID_TEMP%>" id="departmentIdTemp" validate="Unit Name ,String,yes" >
	<option value="">Select</option>
	<%for (MasHospital masHospital :masStoreAirForceDepotList ) {%>
	<option value=<%=masHospital.getId()%>
		<%=HMSUtil.isSelected(masHospital.getId().toString(),box.get("departmentIdTemp")) %>><%=masHospital.getHospitalName()%></option>
	<%}%>
</select>


<label >Declared Surplus On</label>
<input	type="text" name="<%=RequestConstants.DECLARED_VIDE%>" value="<%=box.get(RequestConstants.DECLARED_VIDE) %>" id="decSur" validate="Surplus ,String,yes"/>

<label>Authority for Issue</label>
<input	type="text" name="<%= RequestConstants.AUTHORITY_FOR_ISSUE%>" value="<%=box.get(RequestConstants.AUTHORITY_FOR_ISSUE)%>" id="autFoIss" />
<div class="clear"></div>
<label >Consignee's Indent No.</label>
<input	type="text" name="<%= RequestConstants.COSIGNEESDEMANDNO%>" value="<%=box.get(RequestConstants.COSIGNEESDEMANDNO)%>" id="cosi"  validate="Consignee's Indent No./Demand No. ,String,yes"/>
<%--

<label >Reference No </label>
<input	type="text" name="<%= RequestConstants.DOC_NO%>" value="<%=box.get("docNo")%>" id="docNo" />

<label>Reference Date</label>
<input type="text"	id="refrenceDate" name="refrenceDate" readonly="readonly"
	value="<%=box.get("demandDate").equals("")?date:box.get("demandDate") %>"id="isssueDate" />

<img  id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=date%>',document.issueToOtherUnitsForm.refrenceDate,event)" />

<label>Approved By</label>
	<select	name="<%= RequestConstants.APPROVED_BY%>" id="approvedBy">
	<option value="">Select</option>
	<%for (MasEmployee masEmployee:employeeList ) {%>
	<option value=<%=masEmployee.getId()%>
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("approvedBy")) %>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select>
--%>

 <label >Issued By</label>
 <select name="<%= RequestConstants.ISSUED_BY%>" id="issuedBy">
	<option value="">Select</option>
	<%for (MasEmployee masEmployee:employeeList ) {%>
	<option value=<%=masEmployee.getId()%>
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("issuedBy")) %>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()+" "+masEmployee.getRank().getRankName()%></option>
	<%}%>
</select>
<label>Remarks</label>
<textarea value="<%=box.get(REMARKS)%>" name="<%=REMARKS %>" validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="200"/>
<%=box.get(REMARKS)%>
</textarea>


<input type="hidden" name="<%=RequestConstants.NO_OF_ROWS%>" id="rr" value="22" />
<input type="hidden" name="totalPages" id="totalPages"	value="<%=totalPages%>" />
</div>
<div class="clear"></div>




<!--<label >Page No:</label>-->
<!--<div class="changebydt" style="width: 65px;"><%=pageNo%></div>-->
<!--<td width="9%"><input type="text" name="ValueOfPage"-->
<!--	<%if(box.getString("pvmsNo1").equals("")){ %> value="<%=pageNo+1%>"-->
<!--	<%}else{%> value="" <%}%> id="page" class="textbox_small_size"-->
<!--	MAXLENGTH="3" /></td>-->
<!--<td width="21%"><input type="button" name="goToPage" value="Go"-->
<!--	onClick="goPage()" class="smbutton"-->
<!--	style="background: url(/hms/jsp/images/smbutton.gif) !important; width: 31px; height: 21px; font-size: 11px; color: #FFFFFF !important; margin-right: 8px; border: none;" />-->
<!--</td>-->
<!--</div>-->
<!--<label >Total Pages:</label>-->
<!--<div class="changebydt" style="width: 65px;"><%=totalPages%></div>-->
<!---->
<!--<input type="button" name="Refresh" value="Refresh"-->
<!--	onClick="goRefresh();" class="button">-->
	<input type="hidden" size="2"	value="20"  name="noOfRows" id="noOfRows" />
	<input type="hidden" name="<%=RequestConstants.INDENT_ID %>" value="<%=indentId%>" id="hdb" />

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
	<h4>Item Details</h4>
	<div class="clear"></div>
	<div class="clear"></div>
<div class="cmntable">
		<table width="100px" colspan="7" id="indentDetails"  border="0" cellpadding="0" cellspacing="0">
  <thead>
    <tr>

      <th>Sl No.</th>
      <th>PVMS/NIV No.</th>
      <th>Nomenclature</th>
      <th>A/U</th>
      <th>B/G</th>
      <th>Batch No.</th>
      <th>DOM</th>
      <th>DOE</th>
     <th>Source</th>
     <th>Batch Stock</th>
     <th>Qty in Stock</th>
      <th>Qty Demanded</th>
      <th>Qty Issued</th>
      <th>Balance</th>
      <th>&nbsp;</th>
     <!--  <th>Issue</th> -->
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
    	String issuedItemId="issuedItemId";
    	String issuedItemId2="issuedItemId";
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
     		issuedItemId=issuedItemId2+(""+inc);
     		lotNo=lotNo2+(""+inc);
   	  %>
   <tr>
      <td width="5%">
       <input type="hidden" name="tt8" id='issueQtyAndBatch<%=inc %>' value="blank" readonly="readonly"/>
	<input type="hidden" name="tt6" id="quantityToIssueOverAll<%=inc%>" value="" readonly="readonly"/>
	<input type="hidden" name="dtId" id="dtId<%=inc%>" value="<%= object[6] %>" readonly="readonly"/>
      <input type="text" size="2"	value="<%=temp+inc%>" class="smcaption" name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
      <td>
      <input type="text" size="10" name="<%=RequestConstants.ITEM_CODE%>" value="<%=object[1].toString()%>" readonly="readonly" class="medcaption" id="<%=codeItem%>"/>
      <input type="hidden" size="4"	value="<%= object[0] %>" class="smcaption" name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" />

      </td>
       <td>
      <input type="text"  tabindex="1" size="26" value="<%=object[2].toString()%>" 	id="<%=nameItem%>" class="bigcaption" name="<%=nameItem%>" readonly="readonly" />
	</td>
      <td>
      <input type="text" size="4" value="<%=object[3].toString()%>" class="smcaption"  name="<%=RequestConstants.AU%>" id="<%=idAu %>"  readonly="readonly" />
      </td>
        <td>
      <input type="text" size="3" value="<%=object[3].toString()%>" class="smcaption"  name="<%=RequestConstants.BRAND_GENERIC%>" id="idBG"  readonly="readonly" />
      </td>
       <td><input type="hidden" value=""	id="<%=issuedName%>" class="bigcaption"    />
       <input type="hidden" value=""	id="<%=issuedItemId%>" class="bigcaption"    />
       <!-- <input type="text" size="5" value="<%=object[10].toString()%>"	id="<%=lotNo%>" name="<%=lotNo %>" class="medcaption"  /> -->
        <input type="text" size="5" value="<%=object[11]%>"	id="batchId<%= inc %>" name="<%=BATCH_ID %>" class="medcaption"  />
       </td>

       <td>
       <input type="text" id="manuDate<%=inc %>" name="manuDate<%=inc %>"size="12" value="<%=HMSUtil.convertDateToStringWithoutTime((Date)object[9])%>"	validate="Manufacture Date,date,no" class="medcaption"  />
       <!--<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" validate="Pick a date"
			onClick="setdate('',document.issueToOtherUnitsForm.<%=MANUFACTURING_DATE%>,event)" />-->
			</td>

       <td>
       <input type="text" id="expiryDate<%=inc %>" name="expiryDate<%=inc %>"size="12"value="<%=HMSUtil.convertDateToStringWithoutTime((Date)object[9])%>"	validate="Expiry Date,date,no" class="medcaption"  />
      <!--   <img id="calendar" src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" validate="Pick a date"
			onClick="setdate('',document.issueToOtherUnitsForm.<%=EXPIRY_DATE%>,event)" />-->
			</td>
			<td>
      <input type="text" size="3" value="" class="smcaption"  name="<%=RequestConstants.SOURCE_FROM%>" id="source"  readonly="readonly" />
      </td>
      <td>
      <input type="text" size="3" value="" class="smcaption"  name="<%=RequestConstants.BATCH_WISE_STOCK%>" id="BStock"  readonly="readonly" />
      </td>
      <td width="3%">
      <input type="text" size="5" value="" class="smcaption"  name="qtyStock" id="qtyStock"  readonly="readonly" />
      </td>
         <td width="5%"><input type="text" id="<%=demandVar %>"
				name="<%=demandVar %>" size="7" tabindex="2"
				value="<%=object[7].toString()%>"
				validate="Qty Requested Year,floatWithoutSpaces,no"
				class="medcaption" /></td>
         <td width="5%"><input type="text"	id="<%=qtyIssued %>" name="<%=qtyIssued %>" size="7"   value="<%=object[8].toString()%>" class="medcaption" name="<%=RequestConstants.QTY_ISSUED%>"  readonly="readonly" id="<%=qtyIssued%>"
         onblur="if(checkQty(<%=inc %>)){setData(<%=inc %>)}"/>

      <!-- <td width="3%">
      <input type="button" class="buttonIssue" value="" tabindex="3" onclick="openPopupForBrandForOtherUnits(<%=inc%>);" name="Submit2"  />
         </td>-->
         <div id="ewe"></div>
          </tr>

       <% inc++;
       }
	}
 				  if(inc<=(pageNo-1)*20+20){
	    			 // for(;inc<=(pageNo-1)*20+20;inc++){
	    				  for(;inc<=1;inc++){
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
			     		issuedItemId=issuedItemId2+(""+inc);
			     		lotNo=lotNo2+(""+inc);
	    			  %>
   <tr>
    <input type="hidden" name="tt8" id='issueQtyAndBatch<%=inc %>' value="blank" readonly="readonly"/>
	<input type="hidden" name="tt6" id="quantityToIssueOverAll<%=inc%>" value="" readonly="readonly"/>

      <td width="5%"><input type="text" size="2"	value="<%=temp+inc%>" class="smcaption" name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
      <td width="10%">
      <input type="text" size="10" name="<%=RequestConstants.ITEM_CODE%>" value="" readonly="readonly" class="medcaption" id="<%=codeItem%>"/>
      <input type="hidden" size="4"	value="0" class="smcaption" name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" />
      

      </td>
       <td width="12%">
      <input type="text" value=""  size="35" tabindex="1"	id="<%=nameItem%>" class="bigcaption" onblur="if(fillSrNo(<%=inc %>)){checkForIssueToOTAFU(this.value, '<%=nameItem%>','<%=inc %>');}"  name="<%=nameItem%>" />
		<div id="ac2update" style="display:none;  " class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">

		 new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForIssueToDispensaryOtherUnits',{parameters:'requiredField=<%=nameItem%>'});

		</script>
		</td>
      <td width="10%">
      <input type="text" value="" size="4" class="smcaption"  name="<%=RequestConstants.AU%>" id="<%=idAu %>" tabindex="2" />
      </td>
        <td width="10%">
      <input type="text" value="" size="2" class="smcaption"  name="<%=RequestConstants.BRAND_GENERIC%>" id="idBG<%=inc %>" tabindex="2" />
      </td>
       <input type="hidden" value=""	id="<%=issuedName%>" class="bigcaption"    />
       	<input type="hidden" value=""	id="<%=issuedItemId%>" class="bigcaption"    />

       <td width="9%"><!-- <input type="hidden" size="14" value=""	id="<%=lotNo%>" name = "<%=lotNo%>" class="medcaption"  /> -->

       <select name="<%=lotNo%>" id="<%=lotNo%>"	onchange="getDataForBarcode(this.value,<%=inc%>)" tabindex="1">
				<option value="0">Select</option>
			</select>

       <input type="hidden" size="5" value=""	id="batchId<%= inc %>" name="<%=BATCH_ID %>" class="medcaption"  />
       </td>
       <td width="10%"><input type="text" value=""	size="10" id="manuDate<%=inc %>" name="manuDate<%=inc %>"  validate="Manufacture Date,date,no" class="medcaption"  />
           <!--  <img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0"
            validate="Pick a date"
			onClick="setdate('',document.issueToOtherUnitsForm.manuDate<%=inc %>,event)" /> -->
			</td>
        <td width="10%"><input type="text" value=""	size="10" id="expiryDate<%=inc %>" name="expiryDate<%=inc %>"  validate="Expiry Date,date,no" class="medcaption"  />
           <!--  <img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0"
            validate="Pick a date"
			onClick="setdate('',document.issueToOtherUnitsForm.expiryDate<%=inc %>,event)" />-->
			</td>
			 <td width="3%">
      <input type="text" size="4" value="" class="smcaption"  name="<%=RequestConstants.SOURCE_FROM%>" id="source<%=inc %>"  readonly="readonly" />
      </td>
			 <td width="8%">
      <input type="text" size="10" value="" class="smcaption"  name="<%=RequestConstants.BATCH_WISE_STOCK%>" id="BStock<%=inc %>"  readonly="readonly" />
      </td>
       <td width="4%">
      <input type="text" size="10" value="" class="smcaption"  name="qtyStock" id="qtyStock<%=inc %>"  readonly="readonly" />
      </td>
         <td width="4%"><input type="text" name="<%=demandVar %>" id="<%=demandVar %>" tabindex="1"  size="10" value="0"  tabindex="1" 	validate="Qty Requested Year,floatWithoutSpaces,no" class="medcaption"  /></td>
         <td width="5%"><input type="text" name="<%=qtyIssued %>" id="<%=qtyIssued %>"	size="8" value="" class="medcaption" name="<%=RequestConstants.QTY_ISSUED%>" tabindex="2"  id="<%=qtyIssued%>" validate="Qty Issued ,String,no"
         onblur="if(checkQty(<%=inc %>)){setData(<%=inc %>)}"/>
      </td>
       <td width="8%"><input type="text"  size="10" name="qtyAftrIssued<%=inc%>" id="qtyAftrIssued<%=inc%>" value="" />
      </td>
      <td> <input name="Button" type="button" class="buttonAdd" value="" onclick="generateRow();" /></td>
      <!--
      <td width="3%">
      <input type="button" class="buttonIssue" value="" tabindex="1" onclick="openPopupForBrandForOtherUnits(<%=inc%>);" name="Submit2"  />
         </td> -->
         <div id="ewe"></div>
          </tr>
<input type="hidden" name="counter" id="listsize"	value="<%=inc%>" />
	    			  <%}} }catch(Exception e ){e.printStackTrace();}
	    			  %>
         </tbody>



</table>

</div>

<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <div class="clear"></div>
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<%
		if(issueTList.size() > 0){
	%>
	 <input type="button" name="update" align="right"	class="button" value="Update"
	onclick="if(test()){{submitForm('issueToOtherUnitsForm','stores?method=updateIssueToOtherUnit');}}" />

	<%}else{ %>

	  <input type="button" name="sss" align="right"	class="button" value="Submit"
	onclick="if(test()){{submitForm('issueToOtherUnitsForm','stores?method=submitIssueToOtherUnit&buttonName=submit');}}" />
	<%} %>
	<!--<input
					type="button" name="Delete" type="submit" value="Delete"
					class="button" onclick="openDeletePopupForIssueToOtherUnits();" />

				-->
				<input type="button" name="ss1" class="button" value="SEARCH" onclick="getSearchBlock1();" />

				<input
					type="button" name="print" type="submit" class="button"
					value="Print"
					onClick="submitForm('issueToOtherUnitsForm','stores?method=printIssueToOtherUnits&issueId='+<%=issueId%>);">

<!--					<input type="button" class="button" value="Next"-->
<!--	onclick="if(test()){submitForm('issueToOtherUnitsForm','stores?method=addNextOrSubmitIssueToOtherUnits&buttonName=next');}"-->
<!--	align="right" />-->

					<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>

<%--Start of Change Panel--%>
<div class="bottom">
<label>Changed By:</label>
			<label class="value"><%=userName%></label>

			<label>Changed Date:</label>
			<label class="value"><%=date%></label>

			<label>Changed Time:</label>
			<label class="value"><%=time%></label>

			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />
 </div>

</form>
<script type="text/javascript">

// add by javed khan

function otherUnitCivDisplay() {
	var civNo = document.OtherUnitCiv.<%= RequestConstants.ISSUE_UNIT_ID%>.value
	if (civNo == "0")
	{
	alert('Please select Extern  IV No.');
	return;
	}

	document.OtherUnitCiv.method="post";
	submitForm('OtherUnitCiv','stores?method=searchIssueToOtherUnits&<%= RequestConstants.ISSUE_UNIT_ID%>='+civNo);
}

function getSearchBlock1()
{

document.getElementById('searchBlock').style.display = 'inline';
}


function checkQty(rowVal)
{
	//alert("checkQty"+rowVal);
	//alert("issued "+document.getElementById('qtyIssued'+rowVal).value);
 	//alert("demand  "+document.getElementById('demandVar'+rowVal).value);

//if(parseInt(document.getElementById('qtyIssued'+rowVal).value) <= parseInt(document.getElementById('demandVar'+rowVal).value))
//{
	            //var a=document.getElementById('qtyIssued'+rowVal).value;
	           //var b=document.getElementById('batchStock'+rowVal).value;
	          //document.getElementById("qtyAftrIssued"+rowVal).value=b-a;
	 //return true;
//}else
	if(parseInt(document.getElementById('qtyIssued'+rowVal).value) > parseInt(document.getElementById('demandVar'+rowVal).value)){
	alert("Issued Quantity can't be greater than Demanded Quantity.");
	document.getElementById('qtyIssued'+rowVal).value="";
	document.getElementById("qtyIssued"+rowVal).focus();
	return false;
}

if(parseInt(document.getElementById('qtyIssued'+rowVal).value) > parseInt(document.getElementById('BStock'+rowVal).value))
{
	alert("Issued Quantity can't be greater than Batch Stock Quantity .");
	document.getElementById('qtyIssued'+rowVal).value="";
	document.getElementById("qtyIssued"+rowVal).focus();
	return false;
}

return true;
}



//add by javed khan
function setData(rowVal)
{
	//alert("setData"+rowVal);
	var sum = 0;
  	var totalQtyInHand = 0;
  	var totalAmt = 0;
  	var saleTax = 0;
	var saleTaxAmt = 0;
	var netSaleTax = 0;
	var uom ='';
	var qq="";
	var ss="";
	var inSum=0;
	//var totalRows=parseInt(document.getElementById('counter').value);

	//var rowVal=parseInt(document.getElementById('rowVal').value);
	//var issueQty = parseInt(document.getElementById('issueQty').value);
 	for(var index = rowVal; index <= rowVal; index++ ){

 		var qtyIssuedObj = eval(document.getElementById('qtyIssued'+index));
 		//alert("totalRows3>>"+document.getElementById('qtyIssued'+index).value)
 		//alert(document.getElementById('qtyIssued'+index).value+"------"+document.getElementById('bbatch'+index).value)
			//sum = parseFloat(sum) + parseInt(qtyIssuedObj.value);
 			if(parseInt(document.getElementById('qtyIssued'+index).value)!="0" ){
 	 			//alert("setData"+document.getElementById('qtyIssued'+index).value);
 	 			//alert("setData"+document.getElementById('batchId'+index).value);
			qq=qq+','+document.getElementById('qtyIssued'+index).value
								+'@'+
								document.getElementById('lotNo'+index).value
								+'@'+
								document.getElementById('expiryDate'+index).value
								+'@'+
								document.getElementById('batchId'+index).value
								+'@'+'null';
								//document.getElementById('costPrice'+index).value;
 				}
 			//alert(qq.length+" setData >>"+qq)

		document.getElementById('issueQtyAndBatch'+rowVal).value = qq.substring(1,qq.length);

 			//alert("yes5 >>"+document.getElementById('issueQtyAndBatch'+rowVal).value)
		}

		if(qq.length == 0){
			//alert("yes 1>>"+qq)
			document.getElementById('issueQtyAndBatch'+rowVal).value = "blank";
		} else{
			//alert("yes 2>>"+qq)
			document.getElementById('issueQtyAndBatch'+rowVal).value = qq.substring(1,qq.length);
		}

		var totalQtyIssued = eval(document.getElementById('quantityToIssueOverAll'));
		if(sum == 0){
			totalQtyIssued.value = sum;
		}else{
			totalQtyIssued.value = sum;
		}

		//if(parseInt(totalQtyIssued.value)>parseInt(document.getElementById("reqQty").value)){
			//alert('Qty Issued Value Should be less than or Equal to Requested Qty');
		// return false;
		//}
 		//window.opener.document.getElementById('qtyIssued'+rowVal).value=totalQtyIssued.value;

		//close();
 		return true;
}


function getDataForBarcode(val,rowVal)
{

    var itemId=document.getElementById('issuedItemId'+rowVal).value;

	submitProtoAjaxForBarcodeData('issueToOtherUnitsForm','stores?method=getDataForBarcode&barCode='+val+'&itemId='+itemId,rowVal);
}

// add by javed khan
function generateRow()
{
	  var tbl = document.getElementById('indentDetails');
	  var lastRow = tbl.rows.length;
	  //var deptId = document.getElementById('deptId').value;
	  var listSize=document.getElementById('listsize').value;
	  listSize=(parseInt(listSize))+1;
	  var iteration = listSize;

	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration
	  
	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size = '2';
	  e0.name='<%=SR_NO%>';
	  e0.readOnly=true;
	  e0.value=iteration;
	  cellRight0.appendChild(e0);


	  var e1111 = document.createElement('input');
	  e1111.type = 'text';
	  e1111.name="tt8";
	  
	  e1111.id = 'issueQtyAndBatch'+iteration;
	  e1111.value="blank"; 
	

	  var e11111 = document.createElement('input');
	  e11111.type = 'hidden';
	  e11111.name='tt6';
	  e11111.id = 'quantityToIssueOverAll'+iteration;
	  e11111.value=""; 
	 // cellRight0.appendChild(e1111);
	  cellRight0.appendChild(e11111);


	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='codeItem'+iteration;
	  e1.id = 'codeItem'+iteration;
	  e1.size='10';
	  //e1.value=document.getElementById('pvmsNo'+rowVal).value;
	  e1.readOnly=true;
	  var e11 = document.createElement('input');
	  e11.type = 'hidden';
	  e11.name='itemId';
	  e11.id = 'idItem'+iteration;
	 // e11.value=document.getElementById('itemId'+rowVal).value;
	  cellRight1.appendChild(e1);
	 cellRight1.appendChild(e11);

	  var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name = 'nameItem' + iteration;
	  e2.id = 'nameItem' + iteration;
	  e2.size = '35';
	 // e2.value=document.getElementById('nomenclature'+rowVal).value;
	  //e2.readOnly=true;

	  e2.onblur = function(){if(fillSrNo(iteration)){checkForIssueToOTAFU(this.value, 'nameItem',iteration)}};
	  //e2.onblur = function(){if(validateConsultant(opdPatient,iteration)){checkForNomenclature(this.value, iteration,deptId,'prescription');}};

	  // cellRight2.appendChild(e2);
	  var newdiv = document.createElement('div');
 	  newdiv.setAttribute('id', 'ac2update'+iteration);
 	 newdiv.setAttribute('class', 'autocomplete');
 	 newdiv.style.display = 'none';
 	var iy='nameItem'+iteration;
	  cellRight2.appendChild(e2);
	  cellRight2.appendChild(newdiv);
	 // new Ajax.Autocompleter('nameItem'+iteration,'ac2update','stores?method=getItemListForIssueToDispensaryOtherUnits',{parameters:'requiredField=nameItem'+iteration'&issueId='+document.getElementById('issueId').value});
	  new Ajax.Autocompleter('nameItem'+iteration,'ac2update','stores?method=getItemListForIssueToDispensaryOtherUnits',{parameters:'requiredField=nameItem'+iteration});







	  var cellRight22 = row.insertCell(3);
	  var e22 = document.createElement('input');
	  e22.type = 'text';
	  e22.name = 'idAu';
	  e22.id = 'idAu' + iteration;
	  e22.size = '7';
	  e22.readOnly=true;
	  cellRight22.appendChild(e22);


	  var cellRight222 = row.insertCell(4);
	  var e222 = document.createElement('input');
	  e222.type = 'text';
	  e222.name = 'brandGeneric';
	  e222.id = 'idBG' + iteration;
	  e222.size = '2';
	 // e222.value=document.getElementById('BG'+rowVal).value;
	  e222.readOnly=true;
	  cellRight222.appendChild(e222);

	  var e1111 = document.createElement('input');
	  e1111.type = 'hidden';
	  e1111.name='issuedName'+iteration;
	  e1111.id = 'issuedName'+iteration;

	  var e11111 = document.createElement('input');
	  e11111.type = 'hidden';
	  e11111.name='issuedItemId'+iteration;
	  e11111.id = 'issuedItemId'+iteration;

	  cellRight222.appendChild(e1111);
	  cellRight222.appendChild(e11111);




	/*  var cellRight21 = row.insertCell(4);
	  var e21 = document.createElement('input');
	  e21.type = 'text';
	  e21.name = 'barCodeNo' + iteration;
	  e21.id = 'barCodeNo' + iteration;
	  e21.size = '8';
	  e21.onblur = function(){getDataForBarcode(this.value,iteration);};
	  e21.onchange=function(){getDataForBarcode(this.value,iteration);};
	  cellRight21.appendChild(e21);*/



	  //var cellRight23 = row.insertCell(6);
	  //var e23 = document.createElement('input');
	  //e23.type = 'text';
	  //e23.name = 'batchNo' + iteration;
	  //e23.id = 'batchNo' + iteration;
	  //e23.size = '10';
	 // e23.readOnly=true;




	  var cellRight23 = row.insertCell(5);
	  var e23 = document.createElement('Select');
	e23.name = 'lotNo' + iteration;
	  e23.id = 'lotNo' + iteration;
	  e23.options[0] = new Option('Select Batch', '0');
	  e23.onchange=function(){
		  getDataForBarcode(this.value,iteration)};
// var li=document.getElementById('list'+rowVal).value;
		  //alert(li);
//for(var i = 0;i<li;i++ ){
//e23.options[i+1] = new Option(batchArray[i][1],batchArray [i][0]);

	  // var yu='batchNo'+rowVal;
	  // alert(yu);
	   //alert(document.issueDispensaryForm.yu.options[i].value);
	    // e23.options[i+1] = new Option(document.issueDispensaryForm.yu.options[i].value);
		// e23.options[i+1] = new Option(document.getElementById('batchNo'+rowVal).option[document.getElementById('batchNo'+rowVal).selectedIndex].innerHTML,document.getElementById('batchNo'+rowVal)option[document.getElementById('batchNo'+rowVal).selectedIndex].innerHTML);
//}

  var e242 = document.createElement('input');
  e242.type = 'hidden';
  e242.name = 'batchId';
  e242.id = 'batchId' + iteration;
  e242.size = '10';

	  var e24 = document.createElement('input');
	  e24.type = 'hidden';
	  e24.name = 'brandId' + iteration;
	  e24.id = 'brandId' + iteration;
	  e24.size = '10';
	  cellRight23.appendChild(e23);
	  cellRight23.appendChild(e24);
	  cellRight23.appendChild(e242);

	  var cellRight251 = row.insertCell(6);
	  var e251 = document.createElement('input');
	  e251.type = 'text';
	  e251.name = 'manuDate' + iteration;
	  e251.id = 'manuDate' + iteration;
	  e251.size = '10';
	  e251.readOnly=true;
	  cellRight251.appendChild(e251);

	  var cellRight25 = row.insertCell(7);
	  var e25 = document.createElement('input');
	  e25.type = 'text';
	  e25.name = 'expiryDate' + iteration;
	  e25.id = 'expiryDate' + iteration;
	  e25.size = '10';
	  e25.readOnly=true;
	  cellRight25.appendChild(e25);

	  var cellRight25 = row.insertCell(8);
	  var e25 = document.createElement('input');
	  e25.type = 'text';
	  e25.name = 'source' + iteration;
	  e25.id = 'source' + iteration;
	  e25.size = '4';
	  e25.readOnly=true;
	  cellRight25.appendChild(e25);


	  var cellRight6 = row.insertCell(9);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.name = 'BatchWiseStock';
	  e6.id = 'BStock' + iteration;
	  e6.size = '10';
	 // e6.value=document.getElementById('stockAvailable'+rowVal).value;
	  e6.readOnly=true;
	  cellRight6.appendChild(e6);



	  var cellRight613 = row.insertCell(10);
	  var e613 = document.createElement('input');
	  e613.type = 'text';
	  e613.name = 'qtyStock';
	  e613.id = 'qtyStock' + iteration;
	  e613.size = '10';
	  e613.readOnly=true;
	  cellRight613.appendChild(e613);

	  var cellRight34 = row.insertCell(11);
	  var e34 = document.createElement('input');
	  e34.type = 'text';
	  e34.name = 'demandVar' + iteration;
	  e34.id = 'demandVar' + iteration;
	  e34.size = '10';



	 /* if(document.getElementById('qtyIssued'+rowVal).value=="")
	  {
	   e34.value=parseInt(document.getElementById('qtyRequested'+rowVal).value);
	  }else
		  e34.value=parseInt(document.getElementById('qtyRequested'+rowVal).value)-parseInt(document.getElementById('qtyIssued'+rowVal).value);
	   */
	   cellRight34.appendChild(e34);

	   /*  var cellRight341 = row.insertCell(12);
		  var e341 = document.createElement('input');
		  e341.type = 'text';
		  e341.name = 'qtyOnLoan' + iteration;
		  e341.id = 'qtyOnLoan' + iteration;
		  e341.size = '10';
		  cellRight341.appendChild(e341);*/

	  var cellRight35 = row.insertCell(12);
	  var e35 = document.createElement('input');
	  e35.type = 'text';
	  e35.name = 'qtyIssued' + iteration;
	  e35.id = 'qtyIssued' + iteration;
	  e35.size = '10';
	  e35.onblur = function(){if(checkQty(iteration)){setData(iteration)}};
	  cellRight35.appendChild(e35);




	  var cellRight13 = row.insertCell(13);
	  var e13 = document.createElement('input');
	  e13.type = 'text';
	  e13.name = 'qtyAftrIssued' + iteration;
	  e13.id = 'qtyAftrIssued' + iteration;
	  e13.size = '10';
	 // e6.value=document.getElementById('stockAvailable'+rowVal).value;
	  e13.readOnly=true;
	  cellRight13.appendChild(e13);

	  var cellRight10 = row.insertCell(14);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonAdd';
	  e8.name='remarks'+iteration;
	  // e8.onClick = function(){generateRowIssueCIV(iteration)};
	  e8.setAttribute('onClick', 'generateRow();');
	  e8.setAttribute('tabindex','1');
	  cellRight10.appendChild(e8);


	 document.getElementById('listsize').value=listSize;
}

function submitProtoAjaxForBarcodeData(formName,action,rowVal)
{
	  //alert("submitProtoAjax in issue other unit");
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
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4)
		  {

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

	      	if(items.childNodes.length!=0)
		    {
	      	for (loop = 0; loop < items.childNodes.length; loop++)
		    {
		   	    var item = items.childNodes[loop];
		      //  var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		        //var name  = item.getElementsByTagName("name")[0];
		       var batchNo=item.getElementsByTagName("batchNo")[0];
		       var batchId=item.getElementsByTagName("batchId")[0];
		       //var barcodeNo=item.getElementsByTagName("barCodeNo")[0];
		       var availableStock=item.getElementsByTagName("availableStock")[0];

		       var brandId=item.getElementsByTagName("brandId")[0];
		       var expiryDate=item.getElementsByTagName("expiryDate")[0];
		       var manuDate=item.getElementsByTagName("dom")[0];
		       var source=item.getElementsByTagName("source")[0];

		     //  var costPrice=item.getElementsByTagName("costPrice")[0];

	        	//document.getElementById("au"+rowVal).value=au.childNodes[0].nodeValue;
	        	//document.getElementById("batchNo"+rowVal).value=batchNo.childNodes[0].nodeValue;
	        	document.getElementById("batchId"+rowVal).value=batchId.childNodes[0].nodeValue;
	        	document.getElementById("expiryDate"+rowVal).value=expiryDate.childNodes[0].nodeValue;
	        	//document.getElementById("qtyStock"+rowVal).value=availableStock.childNodes[0].nodeValue;
	        	document.getElementById("BStock"+rowVal).value=availableStock.childNodes[0].nodeValue;
	        	document.getElementById("source"+rowVal).value=source.childNodes[0].nodeValue;
	        	alert("brand  "+brandId.childNodes[0].nodeValue)
	        	document.getElementById("brandId"+rowVal).value=brandId.childNodes[0].nodeValue;
	        	//document.getElementById("costPrice"+rowVal).value=costPrice.childNodes[0].nodeValue;

	        	document.getElementById("manuDate"+rowVal).value=manuDate.childNodes[0].nodeValue;

	        	document.getElementById("qtyIssued"+rowVal).focus();


	      	 }
	      	}
	      	else{
	      		 document.getElementById("barCodeNo"+rowVal).value="";
	      	alert("Invalid Barcode ");

	      	}
	      }
	    }
	    
	    //var url=action+"&"+getNameAndData(formName)
	    
	    var url=action;

	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

	  }

<!--
function test(){
	var errorMessage="";
	formName="issueDispensaryManualForm"
	obj = eval('document.'+formName)
	if(document.getElementById('issuedBy').value == "")
		errorMessage=errorMessage+"Please Select Issue By \n";
	//if(document.getElementById('approvedBy').value == "")
	//	errorMessage=errorMessage+"Please Select Approved By \n";

	if(document.getElementById('departmentIdTemp').value == "")
		errorMessage=errorMessage+"Please Select Dispensary \n";
	//if(document.getElementById('docNo').value == "")
	//	errorMessage=errorMessage+"Please Fill Reference No \n";

	if((document.getElementById('issuedBy').value != "")  &&(document.getElementById('departmentIdTemp').value != "") ){
		return true;
	}else{
		alert(errorMessage)
		return false
	}

}
--></script>