<%@ page import=" static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="jkt.hms.util.Box" %>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.math.MathContext"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="javax.swing.text.NumberFormatter"%>
<%@page import="java.text.NumberFormat"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link  rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
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

<%
	StringBuffer orderDateOnly = new StringBuffer();
	GregorianCalendar gregorianCalendar1 = new GregorianCalendar();

	int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
	if (dateOfMonth < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(dateOfMonth);
	} else {
		orderDateOnly.append(dateOfMonth);
	}

	orderDateOnly.append("/");

	int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (month < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(month);
	} else {
		orderDateOnly.append(month);
	}

	orderDateOnly.append("/");
	int year = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year);
	String currentDate = new String(orderDateOnly);
%>

<script type="text/javascript" language="javascript">
var itemsArray1=new Array();
 var numLinesAdded = 1;
  var tt;


  function checkForSubmit(){

  if(document.getElementById('noOfRows').value==0)
  {alert("There must be one detail row");
  return false;
  }else{
  return true;
  }
  }
function get_value(rowNo,detailId)
{

 var url="/hms/hms/stores?method=showInfoOfGrnJsp&detailId="+detailId+"&rowNo="+rowNo;
   popwindow(url);
 }

var newwindow;
function popwindow(url)
{

 newwindow=window.open(url,'name',"height=500,width=600,status=1");
 if (window.focus)
 {
 newwindow.focus()
 }
newwindow.createPopup();

}


</script>
<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date1=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date1.length()<2){
		date1="0"+date1;
	}
%>
	serverdate = '<%=date1+"/"+month1+"/"+year1%>'
</script>
<script type="text/javascript" language="javascript">
function fillSrNo(rowVal)
{
		var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%30
   		if(rowVal==0){
   			rowVal=30
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	return true;
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
function fillSrNo(rowVal){

	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%30
   		if(rowVal==0){
   			rowVal=30
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	return true;
}

function checkForGrn(val,a,inc)
{
		if (val=="")
		{
		document.getElementById('codeItem'+inc).value="";
		document.getElementById('idItem'+inc).value=0;
		document.getElementById('expiry'+inc).value="";
		document.getElementById('idAu'+inc).value="";
		document.getElementById('batchNo'+inc).value="";
		document.getElementById('lotNo'+inc).value="";
		document.getElementById('quanRec'+inc).value="";
		document.getElementById('freeQty'+inc).value="";
		document.getElementById('dispenseType'+inc).length=0;
		document.getElementById('brandId'+inc).length=1;
		document.getElementById('manufacturerId'+inc).length=1;
		document.getElementById('mdq'+inc).value="";
		if(document.getElementById('sourceCombo').value=="a" || document.getElementById('sourceCombo').value=="i" )
		{
		document.getElementById('ratePerMdq'+inc).value=0;
		document.getElementById('unitRateVar'+inc).value=0;
		}
		else{

		document.getElementById('ratePerMdq'+inc).value="";
		document.getElementById('unitRateVar'+inc).value="";
		}

		document.getElementById('discountVar'+inc).value="";
		document.getElementById('taxVar'+inc).value="";
		document.getElementById('amtVar'+inc).value="";
		document.getElementById('costPrice'+inc).value="";
		document.getElementById('manufacturingDate'+inc).value="";
		document.getElementById('expiryDate'+inc).value="";
		return;
		}

		var src = document.getElementById('sourceCombo').value;
    	var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	   var poId = 0;
	   if(document.getElementById('po_id')){
	     poId = document.getElementById('po_id').value;
	   }
	  // if (src=='l')
	    	ajaxFunctionForAutoCompleteInGrn('indentGrid','stores?method=fillItemsForGrn&requiredField=' + pvms + "&poId=" + poId , inc);
	   // else
	     //   ajaxFunctionForAutoCompleteInGrnGeneral('indentGrid','stores?method=fillItemsForGrn&requiredField=' + pvms + "&poId=" + poId , inc);

}

function generateRow(idName) {
		var d=document.getElementById(idName).getElementsByTagName("tr");
		lastTr = d[d.length-1]
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);
		lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
		var tblCtrl = d[d.length-1].getElementsByTagName("input");
		var tblCtrlsel = d[d.length-1].getElementsByTagName("select");
		tblCtrl[1].value=d.length-1;
		for(var i=0;i<tblCtrl.length;i++){
		   if(i == 0){
		   tblCtrl[i].value = parseFloat(tblCtrl[i].value) + parseFloat(1) ;
		   }else{
			tblCtrl[i].value="";
		   }
		}
  	    for(var i=0;i < tblCtrlsel.length;i++){
		   tblCtrlsel[i].options[0].value = "";
		   tblCtrlsel[i].options[0].text = "";

		}
 }

 function removeRow(argIndex,idName){
	         var table=document.getElementById(idName);
	         var tblRows  = table.getElementsByTagName("tr");
	         var check=0;

	         var temp1 = false;
	         for(i=tblRows.length-1;i>0;i--)
	        {
	         var tblCtrl =  tblRows[i].getElementsByTagName("input");
	               for(j=0;j<tblCtrl.length;j++)
	               {
	                  if(tblCtrl[j].type == 'checkbox')
	                   {
	                    if(tblCtrl [j].checked){
	                              check=check+1;
	                       temp1 = true;
	                     }
	                   }
	               }
	        }

	         if(tblRows.length-1==check){
	         	alert("Can not delete all rows")
	         	return false;
	         }

	          if(temp1){
	         if(confirm("Are You Sure,You want Delete ? ")){
			 }else{
				return false;
			 }
	         }
			var temp =true;
	        for(i=tblRows.length-1;i>0;i--)
	        {
	         var tblCtrl =  tblRows[i].getElementsByTagName("input");
	               for(j=0;j<tblCtrl.length;j++)
	               {
	                  if(tblCtrl[j].type == 'checkbox')
	                   {
	                    if(tblCtrl [j].checked){
	                        document.getElementById(idName).deleteRow(i);
	                         temp = false;
	                    }
	                   }
	               }
	        }
	        if(temp){
	        alert("Atleast should select one row");
	        }

	       tempNetValue = parseFloat(0);
	      for(i=1;i<=40;i++)
	      {

	      if(document.getElementById('idItem'+i) != null){
		   if(document.getElementById('idItem'+i).value.trim()!=0)
		    {
		 	 var freeItem = document.getElementById('freeItem'+i).value;
	          if (freeItem=='n')
		         tempNetValue=parseFloat(tempNetValue)+parseFloat(document.getElementById('amtVar'+i).value);

		    }
		   }
	      }


	var actualValue=roundVal(tempNetValue,2);
	var valueAfterRounding=roundNumber(tempNetValue,0);
	var roundOffAmount  = valueAfterRounding-actualValue;

	if (vatApplicable.checked){
	var vat = parseFloat(0);
	 vat = document.getElementById('vatTax').value;
	var vatgrn = parseFloat(0);
	if(vat == ""){
	vat = parseFloat(0);
	}

    var vatgrn1 = parseFloat(valueAfterRounding)+parseFloat(vat);

	vatgrn=roundVal(vatgrn1,0);
	roundOffAmount=vatgrn1-vatgrn;
	document.getElementById('grnValue').value =vatgrn
	}else{
  	document.getElementById('grnValue').value=valueAfterRounding
	}

	//document.getElementById('grnValue').value=valueAfterRounding
	roundOffAmount=roundVal(roundOffAmount,3);
	document.getElementById('roundOfValue').value=roundOffAmount
	document.getElementById('actualGrnValue').value=actualValue

  }

  function getsoitems(){
     var so = document.getElementById('indentCombo').value;

   	currPage=1;
	numOfRows=10;
   if(so != 0 && so != ""){
  	   var url="/hms/hms/stores?method=getSoItemDetails&currPage="+currPage+"&numOfRows=8&sos="+document.getElementById('sourceCombo').value+"&po_id="+so+"&pageType=mod";
		newwindow=window.open(url,'name','top=50, left=50, height=675,width=850,status=1');
	} else {
 	 	alert("Please select SONo ..!!!");
 	}
  }

   function jsGetGrid(){
    if((document.getElementById('item_id').value).length > 0){
     document.getElementById('temp').value = document.getElementById('item_id').value
     document.getElementById('item_id').value = "";
     var po_id = document.getElementById('indentCombo').value;
     var sos = document.getElementById('sourceCombo').value;
     submitForm('indentGrid','stores?method=modifyGrn&sos='+sos+'&po_id='+po_id+'&items='+document.getElementById('temp').value);
     // submitForm('searchGrn','stores?method=modifyGrn');
    }
   }

   function openPopupWindowForUnit()
 {
  var url="/hms/hms/adt?method=showUnitSearchJsp";
  newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
 }

 function jsSetUnitData(unitId,unitAddress)
{
 for(var i=0;i<document.getElementById("supplierCombo").length;i++)
 {
	 if (document.getElementById("supplierCombo").options[i].value==unitId)
	 {
	 	document.getElementById("supplierCombo").selectedIndex = i;
	 }

	// document.getElementById('civDiv').style.display = 'inline';
 }
}
</script>
<%
	Map map = new HashMap();
	String includedJsp = null;
	String previousPage="no";
	String validationMessage ="LEDGER ACCOUNT DONE";
	int pageNo=1;
	int grnId=0;
		List<StoreGrnM> searchGrnList = new ArrayList<StoreGrnM>();
		List<MasStoreSection> sectionList= new ArrayList<MasStoreSection>();
		List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
		List<StoreGrnM> previousStoreGrnMList=new ArrayList<StoreGrnM>();
		List<StoreGrnT> gridGrnTList=new ArrayList<StoreGrnT>();
		List<StoreGrnM> gridGrnMList= new ArrayList<StoreGrnM>();
		List<StorePoDetail> poList = new ArrayList<StorePoDetail>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		int maxGrnNo=0;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	List<StoreGrnM> grnList= new ArrayList<StoreGrnM>();
	if(map.get("grnList")!=null)
		grnList = (List) map.get("grnList");
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	if(map.get("supplierList") != null){
		supplierList = (ArrayList) map.get("supplierList");
		session.setAttribute("supplierList",supplierList);
	}else if(session.getAttribute("supplierList") != null){
		supplierList = (ArrayList)session.getAttribute("supplierList");
	}
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	if(map.get("employeeList") != null){
		employeeList = (ArrayList) map.get("employeeList");
		session.setAttribute("employeeList",employeeList);
	}else if(session.getAttribute("employeeList") != null){
		employeeList = (ArrayList)session.getAttribute("employeeList");

	}
	List<StoreIndentM> indentList = new ArrayList<StoreIndentM>();
	if(map.get("indentList") != null){
		indentList = (ArrayList) map.get("indentList");
		session.setAttribute("indentList",indentList);
	}else if(session.getAttribute("indentList") != null){
		indentList = (ArrayList)session.getAttribute("indentList");

	}
	if(map.get("grnId")!=null){
		grnId=Integer.parseInt(""+map.get("grnId"));
	}

	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}

	if(map.get("maxGrnNo")!=null)
		maxGrnNo=Integer.parseInt(""+map.get("maxGrnNo"));

	if(map.get("sectionList")!=null)
	sectionList=(List) map.get("sectionList");

	if(map.get("previousStoreGrnMList")!=null)
		previousStoreGrnMList=(List) map.get("previousStoreGrnMList");

	if(map.get("gridGrnTList")!=null){
		gridGrnTList=(List) map.get("gridGrnTList");

	}

	if(map.get("poList")!=null){
		poList=(List) map.get("poList");
	}

	if(map.get("brandList")!=null){
		brandList=(List) map.get("brandList");
	}

	if(map.get("gridGrnMList")!=null)
		gridGrnMList=(List) map.get("gridGrnMList");
	String noDetailRecords="no";
	if(map.get("noDetailRecords")!=null){
		noDetailRecords=(""+map.get("noDetailRecords"));
	}

	if(map.get("searchGrnList")!=null)
		searchGrnList = (List) map.get("searchGrnList");
	if(map.get("itemList")!=null)
		itemList=(List) map.get("itemList");

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	String time="";
	String date="";
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");
	 time = (String)utilMap.get("currentTime");
%>



<div id="contentspace">

	<form name="indent" method="post">
	<br />

	<table class="tborder" width="100%" align="center" >
	<tr>
	   <td width="20%" nowrap="nowrap" class="vbmenu_control" id="threadsearch">
	   <a href="">Search</a>
	    <script type="text/javascript"> vbmenu_register("threadsearch"); </script>		</td>
	    <td width="80%">    <label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>


	      <table width="20%" align="right" border="0" cellpadding="0" cellspacing="0"  >
					<tr>
					</tr>
					  </table>
	    			</td>
		</tr>
		</table>
			<div align="center">
			<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
			<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

			<form name="searchPanel" method="post">
			<table width="684" border="0" cellpadding="0" cellspacing="0" style="border: 1px solid #7f9db7;" >
					<tr>
						<td  height="35" colspan="9" class="thead">Search Panel<a name="goto_threadsearch"></a></td>
					</tr>
			<tr  class="vbmenu_option">
			   <td width="74" height="24" valign="middle"   title="nohilite">
						<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" />
						<input type="hidden" name="do" value="process" />
						<input type="hidden" name="searchthread" value="1" />
						<input type="hidden" name="showposts" value="1" />
						<input type="hidden" name="searchthreadid" value="85875" />
			   <span  style="width: 110px; text-align: left;">From Date: </span>
			   </td>
			   <td width="144" valign="middle"   title="nohilite">
				<input type="text" name="<%= FROM_DATE %>"	class="textbox_date" MAXLENGTH="30"  tabindex=1 />
			   </td>
			   <td width="144" valign="middle"   title="nohilite">
                     <img 	id="calendar"   src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1"
                    onClick="setdate('<%=currentDate%>',document.indent.<%= FROM_DATE%>,event)" />
               </td>
			   <td width="144" valign="middle"   title="nohilite">
			   <span   style="width: 110px; text-align: left">To Date :</span></td>
	           <td width="144" valign="middle"   title="nohilite">
			    <input type="text" name="<%= TO_DATE %>" class="textbox_date" MAXLENGTH="30"  tabindex=1 />
			   </td>
			   <td width="144" valign="middle"   title="nohilite">
				 <img 	id="calendar"   src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1"
	               onClick="setdate('<%=currentDate%>',document.indent.<%= TO_DATE%>,event)" />
	           </td>
	           <!-- -
		       <td width="144" valign="middle"   title="nohilite">
				  <span   style="width: 110px; text-align: left">CRV NO:</span>
			   </td>
			   
		       <td width="144" valign="middle"   title="nohilite">
		        <input type="text" name="<%=GRN_NO%>" value="" class="bigcaption1" tabindex=1 MAXLENGTH="100" id="<%=GRN_NO%>" />
				    <div id="ac5update" style="display:none; padding-right: 550px; background-color:white;"></div>
					<script type="text/javascript" language="javascript" charset="utf-8">
				       new Ajax.Autocompleter('<%=GRN_NO%>','ac5update','stores?method=getGrnNoListForAutoComplete',{parameters:'requiredField=<%=GRN_NO%>'});
					</script>
		       </td> -->
		     <td width="144" valign="middle"   title="nohilite">
		     	<input type="button" class="smbutton" value="Go!" onClick="submitForm('indent','stores?method=searchGrn');" />
			 </td>
	</tr></table>
			</form>
			</div></div></div>
	<br/>
	</form>

	<form name="indentGrid" method="post">

	<%String sos = ""; %>
		<div id="testDiv" size="height:500px;">
	<%if(previousPage.equals("no")){ %>

	<%
	if (map.get("gridGrnMList") != null) {
		gridGrnMList = (List<StoreGrnM>)map.get("gridGrnMList");
	}
	StoreGrnM grnMObj = null;

	String mode = "0";
	System.out.println("grnMObj.getReceiveType()1"+gridGrnMList.size());
	
	if(gridGrnMList.size() > 0){
		System.out.println("grnMObj.getReceiveType()2");
		grnMObj = (StoreGrnM)gridGrnMList.get(0);
		sos = grnMObj.getReceiveType();
		grnId = grnMObj.getId();
		mode = grnMObj.getModeOfConveyance();
		System.out.println("grnMObj.getReceiveType()3 "+mode);
	}
	List<MasUnit> otherUnitList = new ArrayList<MasUnit>();
	List<MasStoreAirForceDepot> masStoreAirForceDepot = new ArrayList<MasStoreAirForceDepot>();
	System.out.println("grnMObj.getReceiveType()"+grnMObj.getReceiveType());
	if(grnMObj.getReceiveType() !=null  && !grnMObj.getReceiveType().equals("")){
	if(grnMObj.getReceiveType().equals("o")){
	if(map.get("otherunitList")!=null){
		otherUnitList=(List) map.get("otherunitList");
	}
	System.out.println("in modify grn >"+otherUnitList.size());
	}else if(grnMObj.getReceiveType().equals("a") || grnMObj.getReceiveType().equals("i")){
		if(map.get("unitList")!=null){
			masStoreAirForceDepot=(List) map.get("unitList");
		}
	}
	}
	%>
<div id="errorMsg" style="width: 100%; padding-top: 4px;  padding-bottom: 4px;">
<!-- -
	<div style="margin-right: 0px; /*changed from 3px */ text-align: center; font-weight:bold; height: 23px; background-color: #FFE8E8;  float : left;  width : 100%; color: red; border: 1px solid red;">
    	<%="*Note: CRV can be printed only after completion of Ledger Action" %>
	</div> -->
 </div>
 <br/>

 <div class="Clear"></div>
 <div class="blockTitle">CRV Details</div><div class="blockTitleCurve"></div>
 <div class="Clear"></div>

	<div style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid;
			    width: 100%; height:auto;  background-color: #f4f9fe;">

			    <br/>

 <label >Source of Supply</label>
 <select name="<%=SOURCE_OF_SUPPLY%>" id="sourceCombo" tabindex=1  validate="Source of Supply,String,yes">
	<% if(grnMObj != null){
		if(grnMObj.getReceiveType().equals("l")){
	%>
	<option value=<%=grnMObj.getReceiveType()%>><%="Local Purchase"%></option>
	<%}else if(grnMObj.getReceiveType().equals("p")){ %>
	<option value=<%=grnMObj.getReceiveType()%>><%="PVMS By DGRC"%></option>
	<%}else if(grnMObj.getReceiveType().equals("a")){ %>
	<option value=<%=grnMObj.getReceiveType()%> ><%="AFMSD"%></option>
	<%}else if(grnMObj.getReceiveType().equals("o")){ %>
	<option value=<%=grnMObj.getReceiveType()%> ><%="Other Units"%></option>
	<!-- -
	<%}else if(grnMObj.getReceiveType().equals("w")){ %>
	<option value=<%=grnMObj.getReceiveType()%> ><%="CRV without LPO"%></option>
	<%}else if(grnMObj.getReceiveType().equals("i")){ %>
	<option value=<%=grnMObj.getReceiveType()%> ><%="AFMSD Without Indent"%></option>
	<%}%> -->
 	<%}%>
</select>
<label >CRV Number</label>
<% if(grnMObj.getGrnNo() != null){ %>
 <input	type="text"  name="<%= GRN_NO %>" value="<%=grnMObj.getGrnNo()%>" readonly="readonly" validate="GRN Number ,String,no" tabindex=1 />
 <input	type="hidden" name="parent" id="parent" value="<%=grnMObj.getId()%>" validate="" tabindex=1 />
<%}else{ %>
 <input	type="text"  name="<%= GRN_NO %>" value="" validate="GRN Number ,String,no" tabindex=1 />
<%} %>

<label >CRV Date :</label>
<%if(grnMObj.getGrnDate() != null){ %>
<input type="text"  name="<%=GRN_DATE%>"	value="<%=HMSUtil.convertDateToStringWithoutTime(grnMObj.getGrnDate()) %>" readonly="readonly" tabindex=1 validate="GRN Date ,String,no"/>
<%}else{ %>
<input type="text"  name="<%=GRN_DATE%>"	value="<%=currentDate %>" readonly="readonly" tabindex=1 validate="GRN Date ,String,no"/>
<%} %>
<div class="Clear"></div>
 	<%
	if(grnMObj.getReceiveType().equals("o")){
		%>
		<table width="30%"><tr><td>
		<label >Unit/Vendor Name</label>
		<select name="<%=SUPPLIER_ID %>" id="supplierCombo" onClick="civgrid(this.value);" validate="Unit/Vendor Name,String ,yes" tabindex=1>
		<option value="">Select</option>
		<% for (MasUnit unit : otherUnitList)
	  	   {
			if(grnMObj.getOtherUnit().getId() == unit.getId()){
			%>
		   <option value="<%=unit.getId ()%>" selected="selected"><%=unit.getUnitName()%></option>
		   <%}else{ %>
		   <option value="<%=unit.getId ()%>"><%=unit.getUnitName()%></option>
		<% }} %>
   	    </select>
   	  </td>
   	  <!-- -
   	  <td>
   <IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26" style="cursor:pointer;" onClick="javascript:openPopupWindowForUnit();" title="Click here to Search Unit">
   </td> --></tr>
   </table>
  <%}else if(grnMObj.getReceiveType().equals("a") || grnMObj.getReceiveType().equals("i")){ %>
		<label >Unit/Vendor Name</label>
		<select name="<%=SUPPLIER_ID %>" id="supplierCombo"  onClick="civgrid(this.value);" validate="Unit Name, String ,yes" tabindex=1>
		<option value="">Select</option>
		<%
		 for (MasStoreAirForceDepot unit : masStoreAirForceDepot)
	  	   {
			if(grnMObj.getUnit().getId() == unit.getId()){
			%>
		   <option value="<%=unit.getId ()%>" selected="selected"><%=unit.getAirForceDepotName()%></option>
		   <%}else{ %>
		   <option value="<%=unit.getId ()%>"><%=unit.getAirForceDepotName()%></option>
		<% }} %>
   	    </select>

  <% }else{  %>
	  <label >Unit/Vendor Name:</label>
	 <%  if(!grnMObj.getReceiveType().equals("l")){%>
	<select	name="<%= SUPPLIER_ID %>" id="<%= SUPPLIER_ID%>" validate="Unit/Vendor Name,string,yes" tabindex=1>
	<%
	for(MasStoreSupplier masSupplier:supplierList){
		if(grnMObj.getSupplier()!=null){
	   if(grnMObj.getSupplier().getId().equals(masSupplier.getId())){
		%>
		<option value="<%=masSupplier.getId() %>" selected="selected"><%=masSupplier.getSupplierName()%></option>
	<%}}else{ %>
		<option value="<%=masSupplier.getId() %>"><%=masSupplier.getSupplierName()%></option>
	<%}}%>
	</select>
	<%}else{ %>
	<select	name="<%= SUPPLIER_ID %>" id="<%= SUPPLIER_ID%>" validate="Unit/Ven.Name,string,no" disabled="disabled" tabindex=1>
	<%for(MasStoreSupplier masSupplier:supplierList){
		if(grnMObj.getSupplier()!=null){
	   if(grnMObj.getSupplier().getId().equals(masSupplier.getId())){
		%>
		<option value="<%=masSupplier.getId() %>" selected="selected"><%=masSupplier.getSupplierName()%></option>
	<%}}else{ %>
		<option value="<%=masSupplier.getId() %>"><%=masSupplier.getSupplierName()%></option>
	<%}}%>
	</select>
	<%}

	}%>

	<%if(grnMObj.getReceiveType().equals("l")){%>
	 <label >SO No</label>
	 <input type="text" name="<%=PO_ID%>" id="SONo"  readonly tabindex=1 value="<%=grnMObj.getPo().getPoNumber() %>" />
	 <input type="hidden" name="po_id1" id="indentCombo"  readonly tabindex=1 value="<%=grnMObj.getPo().getId() %>" />
	 <input type="hidden" name="po_id2" id="po_id"  readonly tabindex=1 value="<%=grnMObj.getPo().getId() %>" />
	 <input type="hidden" name="item_id" id="item_id" value="" />
   	<input type="hidden" name="temp" id="temp" value="" />
   	 <% if(!grnMObj.getStatus().equalsIgnoreCase("v")) {%>
	<div id="contentHolder">
	  <input type="button" name="details" id="details" title="SUPPLY ORDER Items" align="right" class="cmnButton" onblur="jsGetGrid()"; value="Get SO Items" onclick="getsoitems();" />
	</div>

	<%}} %>

	<%if(grnMObj.getIndent()!=null && (grnMObj.getReceiveType().equals("p") || grnMObj.getReceiveType().equals("a"))) { %>
	 <label >Indent No:</label>
	 <input type="text" name="<%=INDENT_ID %>" id="indentCombo"  readonly id="<%=INDENT_ID %>" value="<%=grnMObj.getIndent().getId() %>"/>
	<%}else{ %>
	 <input type="hidden" name="<%=INDENT_ID %>" id="indentCombo"  readonly id="<%=INDENT_ID %>" value=""/>
	<%} %>
<br />
<!-- 


<label >AT/SO Date :</label>
<input type="text"  name="<%=AT_SO_DATE%>" value="" readonly="readonly" tabindex=1 validate="GRN Date ,String,no"/>

<img  id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1"
   onClick="setdate('<%=currentDate%>',document.indentGrid.<%=AT_SO_DATE%>,event);" />
 -->
<label >Date Rec/Surp:</label>
<%if(grnMObj.getDateReceivedSurplus()!= null) {%>
<input type="text"  readonly="readonly" name="<%=RECEIVED_DATE%>" value="<%=HMSUtil.convertDateToStringWithoutTime(grnMObj.getDateReceivedSurplus())%>"  tabindex=1 validate="surplus Date ,String,no"/>
<%}else{ %>
<input type="text"  name="<%=RECEIVED_DATE%>" value="" readonly="readonly" tabindex=1 validate="surplus Date ,String,no"/>
<%} %>
<img  id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1"
   onClick="setdate('<%=currentDate%>',document.indentGrid.<%=RECEIVED_DATE%>,event);" />

<label >How Received</label>
<% if(grnMObj.getHowReceived() != null){ %>
 <input	type="text"  maxlength="50" name="<%= HOW_RECEIVED %>" value="<%=grnMObj.getHowReceived()%>"  tabindex=1 />
<%}else{ %>
 <input	type="text"  maxlength="50" name="<%= HOW_RECEIVED %>" value=""  tabindex=1 />
<%} %>


	<br/><br/>
	
	<label >R/R No </label>
<% if(grnMObj.getRrNo()	!= null){ %>
 <input	type="text"  name="<%=RR_NO %>" value="<%=grnMObj.getRrNo()%>" validate="rr Number ,String,no" tabindex=1 />
<%}else{ %>
 <input	type="text"  name="<%=RR_NO %>" value=""  tabindex=1 />
<%} %>
	 <label >Unpac-Chk By:</label>
	 <select name="<%=EMPLOYEE_ID%>" validate="Employee Name,string,no" tabindex=1>
	<%
	for(MasEmployee masEmployee:employeeList){

	   if(grnMObj.getEmployee().getId().equals(masEmployee.getId())){
		%>
		<option value="<%=masEmployee.getId() %>" selected="selected"><%=masEmployee.getFirstName() + " " + masEmployee.getLastName()%></option>
	<%}else{ %>
		<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+ " " +masEmployee.getLastName()%></option>
	<%}}%>
	</select>
	<!-- -


<label >Mode Of Convey.</label>
<select id="modeoOfConv" name="<%=MODE_OF_CONVEYANCE%>"  value="4"  validate="Mode Of Conveyance,string,yes" tabindex=1>
      <option value="0">Select</option>
	  <option value="1">Air</option>
	  <option value="2">Bus</option>
	  <option value="3">Train</option>
	  <option value="4">By Hand</option>
</select> -->
<br />
<script>
	document.getElementById("modeoOfConv").value ='<%=mode%>';
</script>
<br />


<label >Remarks</label>
		<%if(grnMObj.getRemarks() != null){ %>
		<textarea value="<%=grnMObj.getRemarks()%>"  name="<%=REMARKS %>" validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" style="width: 310px;" onkeyup="finalCheck(this)" maxlength="250">
		</textarea>
		<%}else{ %>
		<textarea value="" name="<%=REMARKS %>" validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" style="width: 310px;" maxlength="250">
		</textarea>
		<%} %>
<br />

<% if(grnMObj.getReceiveType().equals("o")){%>
<label >CIV No</label>
 <input	type="text"  maxlength="30" name="civNo" id="civNo" value="<%=grnMObj.getCivNo()==null?"":grnMObj.getCivNo()%>" tabindex=1 />

<label >CIV Date</label>
 <input	type="text"  name="civDate" id="civDate" value="<%=grnMObj.getCivdate()==null?"": HMSUtil.convertDateToStringWithoutTime(grnMObj.getCivdate())%>" tabindex=1 />
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
  validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('civDate'),event);"/>
 <input	type="hidden"  name="<%= INVOICE_AMOUNT %>" id="<%=INVOICE_AMOUNT %>" value=""  tabindex=1 />
<%}else{ %>

<% if(grnMObj.getInvoiceNo() != null && !grnMObj.getInvoiceNo().equals("")){ %>
<label >Invoice No</label>
<input	type="text"  maxlength="30" name="<%= INVOICE_NO %>" id="<%= INVOICE_NO %>" value="<%=grnMObj.getInvoiceNo()==null?"":grnMObj.getInvoiceNo()%>" tabindex=1 onchange="checkInvoiceNo();"/>
<%}%>

<% if(grnMObj.getInvoiceDate() != null){ %>
<label >Invoice Date</label>
 <input	type="text"  readonly name="<%= INVOICE_DATE %>" id="invoiceDate" value="<%=HMSUtil.convertDateToStringWithoutTime(grnMObj.getInvoiceDate())%>" tabindex=1 />
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=INVOICE_DATE%>'),event);"/>
<%}%>
<!-- -
<%
if(grnMObj.getInvoiceAmount() != null){ %>
<label >Invoice Amt</label>
 <input	type="text"  name="<%= INVOICE_AMOUNT %>" id="<%=INVOICE_AMOUNT %>" value="<%=grnMObj.getInvoiceAmount()==null?"":grnMObj.getInvoiceAmount()%>"  tabindex=1 />
<%}%> -->
<%
} %> 
<br/>

<!-- -
				 <label >Freight Duty</label>
				 <input type="text" name="<%=FREIGHT_DUTY %>" id="<%=FREIGHT_DUTY %>" value="<%=grnMObj.getFreightDuty()==null?"":grnMObj.getFreightDuty() %>"  onblur="calculationInCRVMod();"  tabindex=1 MAXLENGTH="8"/  >

	  	  	  	 <label >Excise Duty</label>
				 <input type="text" name="<%=EXCISE_DUTY %>" id="<%=EXCISE_DUTY %>" value="<%=grnMObj.getExciseDuty()==null?"":grnMObj.getExciseDuty() %>" onblur="calculationInCRVMod();"   tabindex=1 MAXLENGTH="8"/  >

	  	  	   	 <label ></font>Octori</label>
				 <input type="text" name="<%=OCTROI %>" id="<%=OCTROI %>" value="<%= grnMObj.getOctroi()==null?"":grnMObj.getOctroi()%>"  onblur="calculationInCRVMod();"  tabindex=1 MAXLENGTH="8"/  >
	  	  	   	   	<br />

	  	  	   	 <label >Insurance Charge</label>
				 <input type="text" name="<%=INSURANCE_CHARGES %>" id="<%=INSURANCE_CHARGES %>" value="<%=grnMObj.getInsuranceCharge()==null?"":grnMObj.getInsuranceCharge() %>" onblur="calculationInCRVMod();"  tabindex=1 MAXLENGTH="8"/  >

	  	  	   	 <label ></font>Other Charges</label>
				 <input type="text" name="<%=OTHER_CHARGES %>" id="<%=OTHER_CHARGES %>" value="<%=grnMObj.getOtherCharges()==null?"":grnMObj.getOtherCharges() %>" onblur="calculationInCRVMod();"  tabindex=1 MAXLENGTH="8"/  >

	  	  	   	 <label >Custom Duty</label>
				 <input type="text" name="<%=CUSTOM_DUTY %>" id="<%=CUSTOM_DUTY %>" value="<%=grnMObj.getCustomDuty()==null?"":grnMObj.getCustomDuty() %>" onblur="calculationInCRVMod();"  tabindex=1 MAXLENGTH="8"/  >

		<br/>
		<br/>
<br/>
 -->
		</div>
	 <div class="clear"></div>
	  <%if(!grnMObj.getStatus().equalsIgnoreCase("v")) {%>
	   <div id="contentHolder">
	 	 <table><tr>
	 	 <td>
	 	 <input type="button" name="sss" align="right" title="UPDATE" class="cmnButton" value="Update" onclick="if(checkForCRVGrid() && testForGrn()&& checkloanin()&& checkSave()&&checkForSubmit()){submitForm('indentGrid','stores?method=updateCrv&validate=f');}"/>
		 </td>
		 	<input type="button" class="delbutton" value="" title="DELETE ITEMS" onclick="removeRow(this,'purchaseDetails');" align="right" />
		 <!-- -
		 <td>
		 <input type="button" name="validate" align="right" title="LEDGER ACC DONE" class="cmnButton" value="LEDGER ACTION" onclick="if(checkForCRVGrid() && testForGrn()&& checkloanin()&& checkSave()&& checkForSubmit()){submitForm('indentGrid','stores?method=updateCrv&validate=t&po_id=');}"/>
	     </td> 
	     <td width="600"> </td>
	     <td>
	     <input type="button" name="sss" align="right"  title="REFRESH CRV CALCULATIONS" class="cmnButton" value="Refresh Calculation" onclick="calculationInCRVMod()"/>
		 </td>-->
		 </tr>
		</table>
	   </div>
	   <%}else{%>
	   	<div style="width: 100%; padding-top: 4px;  padding-bottom: 4px;">
			<div class="mesg" style="width: 100%; font-weight:bold; height: 23px;">
				<%=validationMessage %>
			</div>
 		</div>
	   <%} %>
	 	<input type="hidden" name="<%=NO_DETAIL_RECORDS%>" value="<%=noDetailRecords%>" />
		<input type="hidden" size="2"	value="10"  name="<%=NO_OF_ROWS %>"id="<%=NO_OF_ROWS %>" />
		<input type="hidden" name="<%=GRN_ID %>" id="<%=GRN_ID%>" value="<%=grnId%>" id="hdb" />

		<br/>
		<br/>

		<div style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid;
			    width: 100%; float:left; height:48px;  background-color: #f4f9fe;">
		<br>
		<!-- -
		<label > Total VAT Amt </label>
		<input type="text" name="vatTax" id="vatTax" value="<%=grnMObj.getVat()%>" class="textbox_small_size"  MAXLENGTH="15" validate="Total VAT,float,no" onblur="calculationInCRVMod()" tabindex="1"/>

		<label > Total Discount </label>
		<input type="text" name="totDiscount" id="totDiscount" value="<%=grnMObj.getDiscount() %>" class="textbox_small_size"  MAXLENGTH="15" validate="Total Discount,float,no" onblur="calculationInCRVMod()" tabindex="1"/>

		<label > CRV Value </label>
		<input type="text" name="grnValue" id="grnValue" value="<%=grnMObj.getInvoiceAmount()==null?"":grnMObj.getInvoiceAmount()%>"  class="textbox_size_medium"  MAXLENGTH="15"  validate="CRV Value,float,no" tabindex="1"/>

		<label > Round Off Value </label>
		<input type="text" name="roundOfValue" id="roundOfValue" value="<%=grnMObj.getRoundOffValue()==null?"":grnMObj.getRoundOffValue()%>"  class="textbox_small_size"  MAXLENGTH="15" tabindex="1"/>
		<input type="hidden" name="actualGrnValue" id="actualGrnValue" value="" />

		<%if(grnMObj.getVat().intValue() != 0){ %>
		<label >VAT Added</label>
		<input type="checkbox" name="vatApplicable" id="vatApplicable" value="1" checked tabindex=1 onClick="calculationInCRVMod();"/>
		<%}else{ %>
		<label >VAT Added</label>
		<input type="checkbox" name="vatApplicable" id="vatApplicable" value="1" tabindex=1 onClick="calculationInCRVMod();"/>


		<%} %>
	  </div>
 -->
		<% } %>

	     <table>
	     <tr>
	      <td>
	     <div class="Clear"></div>
         <div class="blockTitle">CRV </div><div class="blockTitleCurve"></div>
           <div class="Clear"></div>
		</td>
	   </td>
	   </tr>
	   </table>
	<div style="overflow: auto; width: 100%; height: 280px;padding-left: 9px; BORDER: #9A9A9A 1px solid;">
 <table width="200px" colspan="7" id="purchaseDetails" class="grid_header" border="1" cellpadding="0" cellspacing="0">
  <thead>
    <tr>

			<tr>
			<td width="5%"></td>
			<!-- -<th>SR No.</th> -->
			<th width="8%">PVMS/NIV
			No</label></td>
			<th width="9%">Nomenclature</th>
			<th width="9%">Brand
			Name</th>
			<th width="9%">Company Name</th>
			<th width="9%">A/U</th>
			<th width="9%">Batch
			No</th>
			<!--<th width="9%">Lot No</th>
						-->
			<!-- -
			<th width="9%">Free
			Qty</th> 
			<th width="9%">Dispen.Type</th>
			<th width="9%">MDQ</th>-->
			<!-- -
			<%//if(choice.equals("l")){ %>
			<th width="9%">ED
			for QR</th>
			<%//} %>
			<th width="9%">Converted
			Stock</th> -->
			
			<!-- -
			<%//if(choice.equals("l")){ %>
			<th width="9%">TaxAmt/MDQ</th>
			<%//}else{ %>
			<th width="9%">Tax(%)</th>
			<%//} %> -->
			
			<!-- -
			<th width="9%">Free
			Item</th> -->
			<th width="9%">Manuf.
			Date</th>
			<th width="9%">Expiry
			Date</th>
			<th width="9%">Quan
			Recd(QR)</label></td>
			<th>MRP</th>
			<th width="9%">Cost</th>
			<th width="9%">Disc(%)</th>
			<th width="9%">Total</th>
		</tr>


    </tr>

  </thead>
  <tbody>
   <td width="10%">
   	<%
  		int detailCounter=40;
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idAu="idAu";
    	String idBrand="idBrand";
    	String dispenseType = "dispenseType";
    	String mdq = "mdq";
    	String ratePerMdq = "ratePerMdq";
    	String quantityInVar="quantityInVar";
    	String taxVar="taxVar";
    	String amountVar="amountVar";
    	String unitRateVar="unitRateVar";
    	String discountVar="discountVar";
    	String idSection="idSection";
    	String costPrice ="costPrice";
    	String freeQty="freeQty";
    	String manufacturerId="manufacturerId";
    	String freeItem="freeItem";
    	String manufacturingDate="manufacturingDate";
    	String expiryDate="expiryDate";
    	String brandId="brandId";
    	String nameBrand="nameBrand";
    	String batchNo="batchNo";
    	String quanRec="quanRec";
    	String amtVar="amtVar";
    	String stockInVarTemp="stockInVarTemp";
    	String lotNo="lotNo";
    	String shelfLife="shelfLife";
    	String expiry ="expiry";
    	String vatTax="vatTax";
    	String convertedStock = "convertedStock";
    	String formula = "formula";
    	String conversionFactor = "conversionFactor";
    	String discountAmount = "discountAmount";
    	String taxAmount = "taxAmount";
    	String ed = "ed";

    	if(previousPage.equals("no")){
			int inc=((pageNo-1)*40)+1;
	    	   int incTemp2=inc+40;

	    	   for(StoreGrnT storeGrnT : gridGrnTList){


	    		  if(inc<incTemp2){
   %>
   <td width="10%">
   <%

    %>
   <tr>
     <td width="5%"> <input type="checkbox" class="checkbox" name="checkbox" value="" /> </td>
      <!--<td width="5%"><input type="text" size="2"	value="<%=storeGrnT.getSerialNo()%>" class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>
     --><td width="10%">
      <%if(storeGrnT.getItem().getPvmsNo()!=null){ %>
	<input type="text" value="<%=storeGrnT.getItem().getPvmsNo() %>" class="medcaption" name="<%=ITEM_CODE %>" onblur="autocompleteBasedOnPvms(this.value,'<%=inc%>');" id="<%=codeItem+""+inc%>" />
	<%}else{ %>
	<input type="text" value=" " class="medcaption" name="<%=ITEM_CODE %>"  id="<%=codeItem+""+inc%>" />
	<%} %>
		<input type="hidden" name="flag" value="Grn" />

		    <input type="hidden" name="<%=DETAIL_ID %>" value="<%=storeGrnT.getId() %>" id="hdb" />
			<input type="hidden" value="<%=storeGrnT.getItem().getId()%>" class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem+""+inc%>" />
			<input type="hidden" value="<%=storeGrnT.getItem().getExpiry() %>" class="smcaption" name="" id="<%=expiry+""+inc%>" />
			
			<input type="hidden" value="<%=storeGrnT.getItem().getItemConversion().getFormula()%>" class="smcaption" name="" id="<%=formula+""+inc%>" />
			
			<input type="hidden" value="<%=storeGrnT.getItem().getItemConversion().getConversionFactor1() %>" class="smcaption" name="" id="<%=conversionFactor+""+inc%>" />
<!-- -
			<%if(storeGrnT.getLoanInItem() != null){ %>
			<input type="hidden" name="loanInItem" value="<%=storeGrnT.getLoanInItem()%>" id="loanInItem" />
			<%}else{ %>
			<input type="hidden" name="loanInItem" value="n" id="loanInItem" />
			<%} %> -->

	</td>

       <td width="10%">
      	 <input type="text" value="<%=storeGrnT.getItem().getNomenclature() %>"	id="<%=nameItem+""+inc%>" class="bigcaption" onblur="if(fillSrNo('<%=inc %>')){checkForGrn(this.value, '<%=nameItem%>','<%=inc %>');}" name="<%=nameItem%>" />
	   <div id="ac2update" style="display:none; border:1px solid black; padding-right: 450px; background-color:white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem+""+inc%>','ac2update','stores?method=getItemListForGrnByAutocomplete',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentCombo').value+'&sourceOfSupply= '+document.getElementById('sourceCombo').value});
		</script>
		</td>


	   <td width="10%">
	   <select name="<%=BRAND_ID%>"  id="<%=brandId+""+inc%>">
	   <option value="<%=storeGrnT.getBrand().getId()%>"><%=storeGrnT.getBrand().getBrandName()%></option>
	   </select>
	   </td>

      <td width="10%">
      <select name="<%=MANUFACTURER_ID %>" id=<%=manufacturerId+""+inc%> tabindex="1">
      <option value="<%=storeGrnT.getManufacturer().getId()%>"><%=storeGrnT.getManufacturer().getManufacturerName()%></option>
      </select>

      <td width="10%">
      <input type="text" value="<%=storeGrnT.getItem().getItemConversion().getPurchaseUnit().getUnitName() %>"	class="smcaption"  readonly="readonly" name="<%=AV%>"  id="<%=idAu+""+inc%>"/></td>

      <td width="10%">
      <input type="text" value="<%=storeGrnT.getBatchNo() %>" class="medcaption" name="<%=BATCH_NO %>" id="<%=batchNo+""+inc %>" tabindex="2" />
      </td>

 
      <td width="40%">
      <input type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(storeGrnT.getExpiryDate())%>" name="<%=EXPIRY_DATE%>" id="<%=expiryDate+""+inc %>" class="medcaption"  MAXLENGTH="30" tabindex="1" readonly="readonly"/>
      <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=expiryDate+""+inc %>'),event);"/>
      </td>
      <td width="40%">
      <input type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(storeGrnT.getManufacturerDate())%>" name="<%=MANUFACTURING_DATE%>" id="<%=manufacturingDate+""+inc%>" class="medcaption"  MAXLENGTH="30" tabindex="1" readonly="readonly"/>
     <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufacturingDate+""+inc %>'),event);"/>
      </td>


      <td width="10%">
      <input type="text" value="<%=storeGrnT.getReceivedQty() %>" class="medcaption" name="<%=QUANTITY_RECEIVED %>" id="<%=quanRec+""+inc %>" tabindex="1" />
      </td>
      <!-- -
      <td width="10%">
      <input type="text" value="<%=storeGrnT.getFreeQty() %>" name="<%=FREE_QTY %>" id="<%=freeQty+""+inc %>" class="smcaption" readonly="readonly" />
      </td> MRP-->
       <td width="10%">
      <input type="text" value="1" name="<%=FREE_QTY %>" id="<%=freeQty+""+inc %>" class="smcaption" readonly="readonly" />
      </td>
      <!-- -
      <td width="10%">
      <select name="dispenseType" id=<%=dispenseType+""+inc%> tabindex="1">
      <option value="<%=storeGrnT.getDispType()%>"><%=storeGrnT.getDispType()%></option>
      </select>
      <td width="10%">
      <input type="text" value="<%=storeGrnT.getMdqValue()%>" class="medcaption" name="mdq"  id="<%=mdq+""+inc%>" tabindex="1" />
      <input type="hidden" value="" class="medcaption" name="" readonly="readonly" tabindex="2" id="<%=mdq%>"/>
      </td> -->
      <td width="10%">
      <input type="text" value="<%=storeGrnT.getRatePerMdq()%>" class="medcaption" name="ratePerMdq"  id="<%=ratePerMdq+""+inc%>" onblur="calculationInCRVMod()"  tabindex="1" />
      <input type="hidden" value="" class="medcaption" name="" readonly="readonly" tabindex="2" id="<%=ratePerMdq+""+inc%>"/>
      </td>
      <!-- -
       <%if(sos.equalsIgnoreCase("l")){%>
      <td width="10%">
	   <input type="text" value="<%=storeGrnT.getExciseDuty() == null?"0":storeGrnT.getExciseDuty()%>" class="medcaption" name="ed" onblur="calculationInCRVMod();"  id="<%=ed+""+inc%>" tabindex="2" />
	  </td>
	  <%} %>

	 	<%
			BigDecimal tax = new BigDecimal(0);
	       	BigDecimal discount = new BigDecimal(0);
	       	BigDecimal qty = new BigDecimal(0);
	       	BigDecimal rate = new BigDecimal(0);
	       	BigDecimal amount  = new BigDecimal(0);
	       	BigDecimal amountAfterTax = new BigDecimal(0);
	       	BigDecimal amountAfterdis = new BigDecimal(0);
	       	BigDecimal totamount  = new BigDecimal(0);
	    	BigDecimal totamountMdq  = new BigDecimal(0);

	       	BigDecimal mdqValue = new BigDecimal(0);
	       	String formulaValue = "";
	       	int conversionFactorValue = 0;

		    BigDecimal taxPercent = new BigDecimal(0);
		    BigDecimal discountPercent = new BigDecimal(0);

		    try
			{
				qty = storeGrnT.getReceivedQty();
			}
			catch(Exception e)
			{
				qty = new BigDecimal(0);
			}

		    try
			{
				rate = storeGrnT.getRatePerMdq();
			}
			catch(Exception e)
			{
				rate = new BigDecimal(0);
			}

		    try
			{
		    	if(sos.equalsIgnoreCase("l")){
		    		totamountMdq = storeGrnT.getTaxAmt_mdq();
				}else{
				    tax = storeGrnT.getTax();
				}

			}
			catch(Exception e)
			{
				if(sos.equalsIgnoreCase("l")){
		    		totamountMdq = new BigDecimal(0);
				}else{
					tax = new BigDecimal(0);
				}
			}

			try
			{
				discount = storeGrnT.getDiscount();
			}
			catch(Exception e)
			{
				discount = new BigDecimal(0);
			}

			try
			{
				formulaValue = storeGrnT.getItem().getItemConversion().getFormula();
			}
			catch(Exception e)
			{
				formulaValue = "";
			}


			try
			{
				conversionFactorValue = storeGrnT.getItem().getItemConversion().getConversionFactor1();
			}
			catch(Exception e)
			{
				conversionFactorValue = 0;
			}

			try
			{
				mdqValue = storeGrnT.getMdqValue();
			}
			catch(Exception e)
			{
				mdqValue = new BigDecimal(0);
			}

			try
			{
				totamount = storeGrnT.getAmountValue();
			}
			catch(Exception e)
			{
				totamount = new BigDecimal(0);
			}


			amount = qty.multiply(rate);
			amountAfterTax = amount.add(tax);
			amountAfterdis = totamount.subtract(discount);


			if(!discount.toString().equals("0.0000")){
			discountPercent = (discount.multiply(new BigDecimal(100))).divide(amount,new MathContext(4));
			}

			if(!tax.toString().equals("0.0000")){
			  taxPercent =  (tax.multiply(new BigDecimal(100))).divide(amount,new MathContext(4));
			}

			BigDecimal convertedStockValue = new BigDecimal(0);
			if (formulaValue.equals("1"))
			{
				convertedStockValue = qty.multiply(mdqValue).divide(new BigDecimal(conversionFactorValue));
			}
			else if (formulaValue.equals("2"))
			{
				convertedStockValue = qty;
			}
			BigDecimal freeQtyValue = new BigDecimal(0);
			if(storeGrnT.getFreeQty() != null){
				freeQtyValue =  new BigDecimal(storeGrnT.getFreeQty());
			}
			%>

      <td width="3%">
      <input type="text" class="medcaption" value="<%= convertedStockValue.add(freeQtyValue)%>" name="convertedStock" tabindex="1" id="<%=convertedStock+""+inc%>" />
      <input type="hidden" class="medcaption" value="<%=storeGrnT.getUnitRate() %>" name="<%=UNIT_RATE%>" tabindex="2" id="<%=unitRateVar+""+inc%>"/>
      </td>
 -->
       <td width="3%">
      <input type="text" class="medcaption" value="<%=discountPercent %>"  name="<%=DISCOUNT_PERCENTAGE%>" onblur="calculationInCRVMod()"  tabindex="1" id="<%=discountVar+""+inc%>" />
      <input type="hidden" class="medcaption" value="<%=storeGrnT.getDiscount() %>" name="discountAmount" tabindex="2" id="<%=discountAmount+""+inc%>"/>
      </td>
<!-- -
     <%if(sos.equalsIgnoreCase("l")){%>
      <td width="10%">
      <input type="text" value="<%=storeGrnT.getTaxAmt_mdq() %>" class="medcaption" name="<%=TAX_AMT_MDQ %>"  tabindex="1" onblur="calculationInCRVMod()"  id="<%=TAX_AMT_MDQ+""+inc%>" />
      <!--<input type="text" value="<%=taxPercent %>" class="medcaption" name="<%=TAX_PERCENT %>"  tabindex="1" onblur="calculationInCRVMod()"  id="<%=taxVar+""+inc%>" />
      <input type="hidden"	value="<%=storeGrnT.getTax() %>" class="medcaption" name="taxAmount" tabindex="2" id="<%=taxAmount+""+inc%>"/>
      
      </td>
      <%}else{%>
      <td width="10%">
      <input type="text" value="<%=taxPercent %>" class="medcaption" name="<%=TAX_PERCENT %>"  tabindex="1" onblur="calculationInCRVMod()"  id="<%=taxVar+""+inc%>" />
      <input type="hidden"	value="<%=storeGrnT.getTax() %>" class="medcaption" name="taxAmount" tabindex="2" id="<%=taxAmount+""+inc%>"/>
      </td>
      <%}%> -->
      <td width="10%">
       <input type="hidden" value="<%=storeGrnT.getAmountValue() %>" class="medcaption" name="<%= COST_PRICE %>" id="<%=costPrice+""+inc%>"/>
	   <input type="text"	value="<%=storeGrnT.getAmountValue() %>" class="medcaption" name="<%=AMOUNT%>" id="<%=amtVar+""+inc%>" readonly="readonly"/>
<!-- -
      <input type="hidden" value="<%=storeGrnT.getFreeQty() %>" name="<%=FREE_QTY %>" id="<%=freeQty+""+inc %>"/> -->
      </td>
<!-- -
      <td width="10%">
      <select name="<%=FREE_ITEM %>" id="<%=freeItem+""+inc %>"  tabindex="1" class="smcaption">
	  <option value="n" <%=HMSUtil.isSelected(storeGrnT.getFreeItem(),"n")%>>No</option>
	  <option value="y" <%=HMSUtil.isSelected(storeGrnT.getFreeItem(),"y")%>>Yes</option>
      </select>
      </td>
       -->

      

       </tr>
	<% inc++;
     	 }
     	 }
	    	   %>
	    	   <script>

	    	 document.indentGrid.noOfRows.value=<%=inc-((pageNo-1)*10)-1%>
	    	 </script>

	
	       <%
	    	detailCounter=10;
	       	temp=0;
	       	 idItem="idItem";
	       	 codeItem="codeItem";
	       	 nameItem="nameItem";
	       	 idAu="idAu";
	       	 idBrand="idBrand";
	       	 dispenseType = "dispenseType";
	       	 mdq = "mdq";
	       	 ratePerMdq = "ratePerMdq";
	       	 quantityInVar="quantityInVar";
	       	 taxVar="taxVar";
	       	 amountVar="amountVar";
	       	 unitRateVar="unitRateVar";
	       	 discountVar="discountVar";
	       	 idSection="idSection";
	       	 costPrice ="costPrice";
	       	 freeQty="freeQty";
	       	 manufacturerId="manufacturerId";
	       	 freeItem="freeItem";
	       	 manufacturingDate="manufacturingDate";
	       	 expiryDate="expiryDate";
	       	 brandId="brandId";
	       	 nameBrand="nameBrand";
	       	 batchNo="batchNo";
	       	 quanRec="quanRec";
	       	 amtVar="amtVar";
	       	 stockInVarTemp="stockInVarTemp";
	       	 lotNo="lotNo";
	       	 shelfLife="shelfLife";
	       	 expiry ="expiry";
	       	 vatTax="vatTax";
	       	 convertedStock = "convertedStock";
	       	 formula = "formula";
	       	 conversionFactor = "conversionFactor";
	       	 discountAmount = "discountAmount";
	       	 taxAmount = "taxAmount";
	       	 ed = "ed";



	    		  if(inc<incTemp2){
	    			  for(;inc<incTemp2;inc++){
	    		  %>
	<tr>
			<td width="5%"> <input type="checkbox" class="checkbox" name="checkbox" value="" /> </td>
			<!-- - 
	<td width="5%">
	<input type="text" size="2" value="<%=inc%>" name="<%=SR_NO%>" readonly="readonly" /></td>-->
	<td width="10%"><!--<input type="text"  name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem+""+inc%>" />	-->
	<input type="text"  name="<%=ITEM_CODE %>"	id="<%=codeItem+""+inc%>"
		onblur="autocompleteBasedOnPvms(this.value,'<%=inc%>');"validate="PVMS No,String,no" tabindex="1" /> 
				
	<input type="hidden" name="flag" value="Grn" /> 
				
	<input type="hidden" size="2" value="0"	 name="<%=ITEM_ID%>" id="<%=idItem+""+inc%>" /> 
	<input type="hidden" name="<%=DETAIL_ID %>" value="<%=inc%>" id="hdb" />
	
	<input type="hidden" value=""  name=""	id="<%=expiry+""+inc%>" />
	<!-- -
	<input type="hidden" value="" name="" id="<%=formula+""+inc%>" /> 
	<input type="hidden" value=""  name="" id="<%=conversionFactor+""+inc%>" />
	<input type="hidden" name="loanInItem" value="No" id="loanInItem" /> --></td>
	<td width="10%"><input type="text" value="" id="<%=nameItem+""+inc%>" class="bigcaption"
		onblur="if(fillSrNo('<%=inc%>')){checkForGrn(this.value, '<%=nameItem%>','<%=inc%>');}"
			name="<%=nameItem%>" tabindex="1" />
			<div id="ac2update"	style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('<%=nameItem+""+inc%>','ac2update','stores?method=getItemListForGrnByAutocomplete',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentCombo').value+'&sourceOfSupply= '+document.getElementById('sourceCombo').value});
			</script></td>
	<td width="10%">
	<select name="<%=BRAND_ID%>" id="<%=brandId+""+inc%>" tabindex="1">
				<option value="">--Select Brand--</option>
			</select></td>

			<td width="10%"><select name="<%=MANUFACTURER_ID %>"
				id=<%=manufacturerId+""+inc%> tabindex="1">
				<option value="">--Select Manuf--</option>
			</select></td>

			<td width="10%"><input type="text" value="" 
				readonly="readonly" tabindex="1" name="<%=AV%>" id="<%=idAu+""+inc%>" /></td>

			<td width="10%"><input type="text" value="" 
				name="<%=BATCH_NO %>" tabindex="1" id="<%=batchNo+""+inc%>"	maxlength="25" /></td>

			<td width="50%"><input type="text" name="<%=MANUFACTURING_DATE%>" id="<%=manufacturingDate+""+inc%>"
				tabindex="1"  readonly="readonly" />
			 <img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date" 
				onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufacturingDate+""+inc%>'),event);" />
			</td>

			<td width="40%"><input type="text" name="<%=EXPIRY_DATE%>"
				id="<%=expiryDate+""+inc %>" tabindex="1"  readonly="readonly" /> 
				<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
				onClick="setdate('<%=currentDate%>',document.getElementById('<%=expiryDate+""+inc %>'),event);" />
			</td>
			<td width="10%"><input type="text" value="0" 
				name="<%=QUANTITY_RECEIVED %>" tabindex="1" id="<%=quanRec+""+inc%>"
				onblur="calculationInCRV();" /></td>
			
			<td ><input type="text" value="" name="<%=MRP %>" id="mrp"/></td>
			<td width="10%"><input type="text" value="" name="ratePerMdq" id="<%=ratePerMdq+""+inc%>" 
				tabindex="1" onblur="calculationInCRV();" /></td>
				
			<td width="3%"><input type="text"  value=""	name="<%=DISCOUNT_PERCENTAGE%>" tabindex="1" id="<%=discountVar+""+inc%>"
				onblur="calculationInCRV();" validate="Discount,float,no" />
		 	<input type="hidden" value="" name="discountAmount"	id="<%=discountAmount+""+inc%>" tabindex="1"/></td>
				
			<td width="10%"><input type="hidden" value="0" name="<%= COST_PRICE %>" id="<%=costPrice+""+inc%>" />
			<input type="text" value="0"  name="<%=AMOUNT%>" id="<%=amtVar+""+inc%>" readonly="readonly" tabindex="1" /></td>
		</tr>
   <% }
   		  }
   	    %>

	   <%}//this is if(previousPage.equals("no")) end
       %>
  </tbody>

</table>
	</div>
<%	StoreGrnM storGrnMObj = null;

	if(gridGrnMList.size() > 0){
		storGrnMObj = (StoreGrnM)gridGrnMList.get(0);
	%>
<label>Total Cost</label>
<%if(storGrnMObj.getTotalCost() !=null){ %>
<input type="text" id="total_cost" name="totalCost" value="<%=storGrnMObj.getTotalCost() %>" readonly="readonly" tabindex="1"/>
<%}else{ %>
<input type="text" id="total_cost" name="totalCost" value="" readonly="readonly" tabindex="1"/>
<%} %>
<label>total Amount</labe>
<%if(storGrnMObj.getGrnValue() !=null){ %>
<input type="text" id="total_amount" name="actualGrnValue" value="<%=storGrnMObj.getGrnValue() %>" readonly="readonly" tabindex="1"/>
<%}else{ %>
<input type="text" id="total_amount" name="actualGrnValue" value="" readonly="readonly" tabindex="1"/>
<%} %>
<%} %>
</div>
		<%
	if (map.get("gridGrnMList") != null) {
		gridGrnMList = (List<StoreGrnM>)map.get("gridGrnMList");
	}
		StoreGrnM grnMObj = null;

	if(gridGrnMList.size() > 0){
		grnMObj = (StoreGrnM)gridGrnMList.get(0);
		grnId = grnMObj.getId();
	}	%>
		<br/>

		 <div id="contentHolder">
			<div class="bottom">
			<label>Changed By:</label>
			<label class="value"><%=userName%></label>

			<label>Changed Date:</label>
			<label class="value"><%=date%></label>

			<label>Changed Time:</label>
			<label class="value"><%=time%></label>

			<div class="Clear"></div>
	      </div>
	</div>
	<br/>
		<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
		<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
		<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />


	</form>
	<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
	<input type="hidden" name="rows" id="rr" value="1"/>



</div>

     <script>

     function checkId(){


     }
function checkInvoiceNo(){

	<%
	if(grnList != null && grnList.size() > 0){
			for (StoreGrnM storesGrnM : grnList) {
			String invoiceNo12="";
			String invoiceDate=null;
			int supplierCombo1=0;
			if(storesGrnM.getInvoiceNo()!=null){
			invoiceNo12=storesGrnM.getInvoiceNo();
			}
			if(storesGrnM.getInvoiceDate()!=null){
			invoiceDate=HMSUtil.convertDateToStringWithoutTime(storesGrnM.getInvoiceDate());
	        }
			if(storesGrnM.getSupplier()!=null && !storesGrnM.getSupplier().equals("0")){
			supplierCombo1=storesGrnM.getSupplier().getId();
			}
			%>
			var invoiceNo1=document.getElementById('<%=INVOICE_NO%>').value;
			var invoiceDate1=document.getElementById('invoiceDate').value;
			var supplierCombo1=document.getElementById('<%= SUPPLIER_ID%>').value;
			if(invoiceNo1=='<%=invoiceNo12%>' &&
				invoiceDate1=='<%=invoiceDate%>' &&
				supplierCombo1=='<%=supplierCombo1%>'){
				 alert("Duplicate Invoice  No For same vendor not allowed for the same date....");
				 document.getElementById('<%=INVOICE_NO%>').value='';
				 return false;
			}
			<%}}%>
			return true;
}
</script>