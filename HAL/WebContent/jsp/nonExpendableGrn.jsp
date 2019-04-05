<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasUnitOfMeasurement"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.StoreSupplyOrderEntry"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>


<script>
		 var nameArray=new Array();
		 var itemsArray1=new Array();
	</script>

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
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year1=calendar.get(calendar.YEAR);
		if(month1.length()<2){
			month1="0"+month1;
		}
		if(date.length()<2){
			date="0"+date;
		}
	%>
		serverdate = '<%=date+"/"+month1+"/"+year1%>'
	</script>

<script type="text/javascript" language="javascript">


	function refreshGridonLoadinAdjust()
	{
	submitProtoAjaxforGrid('grnGrid','/hms/hms/stores?method=showLoanIn');
	}

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


	function checkForNext()
	{
		if(document.getElementById('noOfRows').value<30)
		{
		alert("All rows are not filled.To continue press Submit ")
		return false;
		}else{
		return true;
		}
	}

	 function checkForSubmit()
	 {

	    if(document.getElementById('loanInItem').value == "Yes"){
	     return true;
	    }else{
	 	 if(document.getElementById('noOfRows').value==0)
		 {
		 alert("There must be one detail row");
		 return false;
		 }else{
		 return true;
		 }
		}
	}

	function get_value(rowNo)
	{
	 var url="/hms/hms/stores?method=showInfoOfGrnJsp&rowNo="+rowNo;
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


	//===for  new Item addition on screen

	function openItemPopup()
	{
	 var url="/hms/hms/pharmacy?method=showItemJspForCRV";
	 popwindow(url);
	}

	var newwindow;
	function popwindow(url)
	{
	newwindow=window.open(url,'name','top=100,height=600,width=1000,status=1,scrollbars=1,resizable=0');
	if (window.focus)
	 {
	 newwindow.focus()
	 }
	newwindow.createPopup();
	}

	function openVendorPopup()
	{
	 var url="/hms/hms/pharmacy?method=showStoreSupplierJspForCRV";
	 popwindow(url);
	}

	function autocompleteBasedOnPvms(val,inc)
	{
			ajaxFunctionForAutoCompleteForGrn('grnGrid','stores?method=fillItemsCommon&pvmsNo=' +  val , inc);
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
<script language="javascript">

	function checkForGrn(val,a,inc)
	{
		//alert(val+">> val >> inc  "+ inc);
			if (val=="")
			{
			document.getElementById('codeItem'+inc).value="";
			document.getElementById('idItem'+inc).value=0;
			document.getElementById('expiry'+inc).value="";
			document.getElementById('idAu'+inc).value="";
			
			document.getElementById('lotNo'+inc).value="";
			document.getElementById('quanRec'+inc).value="";
			document.getElementById('freeQty'+inc).value="";
		
			
			//document.getElementById('manufacturerId'+inc).length=1;
			
			if(document.getElementById('sourceCombo').value=="a" || document.getElementById('sourceCombo').value=="i" )
			{
		
			document.getElementById('ratePerMdq'+inc).value=0;
			}
			else{

			
			document.getElementById('ratePerMdq'+inc).value="";
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
		    //var poId = document.getElementById('indentCombo').value;
		    
		  
		       ajaxFunctionForAutoCompleteInGrnGeneral1('grnGrid','stores?method=fillItemsForGrn&requiredField=' + pvms , inc);

	}
	  function getsoitems(){
	  var so = document.getElementById('indentCombo').value;
	  var loanIn = document.getElementById('loanInStatus').value;
	   	currPage=1;
		numOfRows=10;
		if(loanIn == "No"){
		   if(so != 0 && so != ""){
		  	   var url="/hms/hms/stores?method=getSoItemDetails&currPage="+currPage+"&numOfRows=8&sos="+document.getElementById('sourceCombo').value+"&po_id="+so+"&pageType=add";
				newwindow=window.open(url,'name','top=0, left=3, height=675,width=1010,status=1');
			} else {
		 	 	alert("Please select SONo ..!!!");
		 	}
	 	}else{
	 	        alert("Please adjust the loanin..!!!");
	 	}
	  }

	  function jsGetGrid(){

	  if((document.getElementById('item_id').value).length > 0){
	      var loanStatus = document.getElementById('adloanIn').value;
	     document.getElementById('temp').value = document.getElementById('item_id').value
	     document.getElementById('item_id').value = "";
	     var po_id = document.getElementById('indentCombo').value;
	     var sos = document.getElementById('sourceCombo').value;
	    submitProtoAjaxforGrid('grnGrid','/hms/hms/stores?method=responseSOGridList&sos='+sos+'&po_id='+po_id+'&items='+document.getElementById('temp').value+'&loanInStatus='+loanStatus);


	   }
	  }


	  function adjustment(){
	     var po_id = document.getElementById('indentCombo').value;
	     var sos = document.getElementById('sourceCombo').value;
	      var loanStatus = document.getElementById('adloanIn').value;
	      submitProtoAjaxforGrid('grnGrid','/hms/hms/stores?method=responseGridLoanInList&sos='+sos+'&po_id='+po_id+'&loanInStatus=Yes');
	      document.getElementById('loanInStatus').value = "No";
	      document.getElementById('adjust').style.display = 'none';

	  }

	 function loanAdjustment(soId){
	 if(soId != 0){
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
	      if(xmlHttp.readyState==4){

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

		  	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		   	   var sli  = item.getElementsByTagName("SLIStatus")[0];
		       if(sli.childNodes[0].nodeValue == 'YES'){
		          document.getElementById('adjust').style.display = 'inline';
		          document.getElementById('loanInStatus').value = "Yes";
		          document.getElementById('adloanIn').value = "Yes";
		            document.getElementById('soItem').style.display = 'none';
		       }else if(sli.childNodes[0].nodeValue == 'NO'){
		          document.getElementById('adjust').style.display = 'none';
		              document.getElementById('soItem').style.display = 'inline';
		          document.getElementById('loanInStatus').value = "No";
		       }
		   }
	      }
	    }

	   var url="/hms/hms/stores?method=findloanInItems&soId="+soId

	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	   }

	  }

	  function openPopupWindowForUnit()
	 {
	  var url="/hms/hms/adt?method=showUnitSearchJsp";
	  newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	 }

	 function jsSetUnitData(unitId,unitAddress)
	{
	 for(var i=0;i<document.getElementById("supplierCombo").length;i++)
	 {
		 if (document.getElementById("supplierCombo").options[i].value==unitId)
		 {
		 	document.getElementById("supplierCombo").selectedIndex = i;
		 }

		 document.getElementById('civDiv').style.display = 'inline';
	 }
	}

	function civgrid(unitId){

	  if(unitId !=""){
		 document.getElementById('civDiv').style.display = 'inline';
	  }

	}
	 </script>

<%
		Map map= new HashMap();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		int grnId=0;
		if(map.get("grnId")!=null){
			grnId=Integer.parseInt(""+map.get("grnId"));
		}
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String currentTime = (String)utilMap.get("currentTime");

		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		if(map.get("supplierList") != null){
			supplierList = (ArrayList) map.get("supplierList");
			session.setAttribute("supplierList",supplierList);
		}else if(session.getAttribute("supplierList") != null){
			supplierList = (ArrayList)session.getAttribute("supplierList");

		}
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
				if(map.get("itemList") != null){
					itemList = (ArrayList) map.get("itemList");
					session.setAttribute("itemList",itemList);
				}else if(session.getAttribute("itemList") != null){
					itemList = (ArrayList)session.getAttribute("itemList");

				}
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				if(map.get("employeeList") != null){
					employeeList = (ArrayList) map.get("employeeList");
					session.setAttribute("employeeList",employeeList);
				}else if(session.getAttribute("employeeList") != null){
					employeeList = (ArrayList)session.getAttribute("employeeList");

				}
				List<StorePoHeader> poList = new ArrayList<StorePoHeader>();
				if(map.get("poList") != null){
					poList = (ArrayList) map.get("poList");
					session.setAttribute("poList",poList);
				}else if(session.getAttribute("poList") != null){
					poList = (ArrayList)session.getAttribute("poList");

				}
				
				
				
				StoreGrnM storeGrnObj = null;
				List<StoreIndentM> indentList = new ArrayList<StoreIndentM>();
				if(map.get("indentList") != null){
					indentList = (ArrayList) map.get("indentList");
					session.setAttribute("indentList",indentList);
				}else if(session.getAttribute("indentList") != null){
					indentList = (ArrayList)session.getAttribute("indentList");

				}
				List<MasUnitOfMeasurement> uomList = new ArrayList<MasUnitOfMeasurement>();
				if(map.get("uomList") != null){
					uomList = (ArrayList) map.get("uomList");
					session.setAttribute("uomList",uomList);
				}else if(session.getAttribute("uomList") != null){
					uomList = (ArrayList)session.getAttribute("uomList");

				}
				List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
				if(map.get("manufacturerList") != null){
					manufacturerList = (ArrayList) map.get("manufacturerList");
					session.setAttribute("manufacturerList",manufacturerList);
				}else if(session.getAttribute("manufacturerList") != null){
					manufacturerList = (ArrayList)session.getAttribute("manufacturerList");

				}
				List<MasStoreAirForceDepot> unitList = new ArrayList<MasStoreAirForceDepot>();
				if(map.get("unitList") != null){
					unitList = (ArrayList) map.get("unitList");
					session.setAttribute("unitList",unitList);
				}else if(session.getAttribute("unitList") != null){
					unitList = (ArrayList)session.getAttribute("unitList");

				}
				List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
				if(map.get("brandList") != null){
					brandList = (ArrayList) map.get("brandList");
					session.setAttribute("brandList",brandList);
				}else if(session.getAttribute("brandList") != null){
					brandList = (ArrayList)session.getAttribute("brandList");

				}

				List<StoreSupplyOrderEntry> supplyOrderList = new ArrayList<StoreSupplyOrderEntry>();
				if(map.get("supplyOrderList") != null){
					supplyOrderList = (ArrayList) map.get("supplyOrderList");
					session.setAttribute("supplyOrderList",supplyOrderList);
				}else if(session.getAttribute("supplyOrderList") != null){
					supplyOrderList = (ArrayList)session.getAttribute("supplyOrderList");

				}
				List<StoreGrnM> searchGrnList= new ArrayList<StoreGrnM>();
				if(map.get("searchGrnList")!=null)
					searchGrnList = (List) map.get("searchGrnList");

				List<StoreGrnM> grnList= new ArrayList<StoreGrnM>();
				if(map.get("grnList")!=null)
					grnList = (List) map.get("grnList");

				List<UserButtonRights> userRightsList= new ArrayList<UserButtonRights>();
				if (map.get("userRightsList") != null) {
					userRightsList = (List<UserButtonRights>)map.get("userRightsList") ;
					System.out.println("userRightsList---in nonExpendableGrnJsp"+userRightsList.size());
				}
				List<MasStoreMeScale> meScaleList = new ArrayList<MasStoreMeScale>();
				if(map.get("meScaleList") != null){
					meScaleList = (ArrayList) map.get("meScaleList");
					session.setAttribute("meScaleList",meScaleList);
				}else if(session.getAttribute("meScaleList") != null){
					meScaleList = (ArrayList)session.getAttribute("meScaleList");
				}
				String message="";
				if(map.get("message") != null){
					message = (String)map.get("message");
				}
				String max="";
				String rvMax="";
				if(map.get("max") != null){
					max = (String) map.get("max");
				}
				
				if(map.get("rvMax") != null){
					rvMax = (String) map.get("rvMax");
				}
				
				String userName = "";
				if (session.getAttribute("userName") != null) {
					userName = (String) session.getAttribute("userName");
				}
				int deptId = 0;
				if (session.getAttribute("deptId") != null) {
					deptId = (Integer) session.getAttribute("deptId");
				}
				int hospitalId = 0;
				if (session.getAttribute("hospitalId") != null) {
					Integer temp =  (Integer)session.getAttribute("hospitalId");
					hospitalId = temp.intValue();
				}

				String time="";
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				 date = (String)utilMap.get("currentDate");
				 time = (String)utilMap.get("currentTime");
				int pageNo=1;
				if (map.get("pageNo") != null) {
					pageNo = Integer.parseInt(""+map.get("pageNo"));
				}
				String includedJsp = null;
				if (request.getAttribute("map") != null) {
					map = (Map) request.getAttribute("map");

				}
				includedJsp = (String) map.get("includedJsp");
		%>
<div class="titleBg">

</div>
<%
			if(map.get("messageTOBeVisibleToTheUser") != null){
			   out.println((String)map.get("messageTOBeVisibleToTheUser"));
			  }
	 %>

<form name="createGrn" method="post" action="">

<div id="searchBlock" style="display:none;">


<div class="clear"></div>
<h6>SEARCH</h6>
<div class="Block">
<form name="" method="">
<label>From Date</label> <input type="text" name="<%= FROM_DATE %>"
	class="date" maxlength="30" tabindex=1 /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	 validate="Date,metachar,no" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.createGrn.<%=FROM_DATE%>,event)" />
<label>To Date</label> <input type="text" name="<%= TO_DATE %>"
	class="date" maxlength="30" tabindex=1 /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Date,metachar,no" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.createGrn.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<label>CRV/RV No.</label> <input type="text" name="<%=GRN_NO%>" value=""
	tabindex=1 MAXLENGTH="100" id="<%=GRN_NO%>" />
<div id="ac3update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=GRN_NO%>','ac3update','stores?method=getGrnNoListForAutoComplete',{parameters:'requiredField=<%=GRN_NO%>'});
			</script>
			 <input name="button" type="button" class="button" value="SEARCH"
	onclick="submitForm('createGrn','neStores?method=searchGrn');" value=" " />
		
</form>
</div>

</div>


<h6>CRV/RV ENTRY</h6>
<form name="grnGrid" method="post" action=""><input type="hidden"
	name="pageNo" value="<%=pageNo%>" id="pageNo" /> <input type="hidden"
	name="deptId" value="<%=deptId%>" /> <input type="hidden"
	name="hospitalId" size="5" value="<%=hospitalId%>">


<div class="Clear"></div>

<div class="Block"><label>Source of supply<span>*</span></label>
<select name="<%=SOURCE_OF_SUPPLY%>" id="sourceCombo"
	onchange="onChangeSrcForNeGrn11(this.value);">
	<option value="0">Select</option>
	<option value="a">AFMSD</option>
	<option value="b">Local purchase</option>
	<option value="c"> DGAFMS</option>
	<option value="d">Other Sources (CWF, Gift, Others)</option>
	</select> 
	
<input type="hidden" id="crvMax" value="<%=max%>" />
 <input	type="hidden" id="rvMax" value="<%=rvMax%>" /> 
 <label id="crv">CRV/RV No.<span>*</span></label>
 <% if(storeGrnObj != null){%> <input type="text" name="<%= GRN_NO %>"
	value="<%=storeGrnObj.getGrnNo()%>" 
	validate="GRN Number,metachar,no" tabindex=1 id="grnNo1" /> <%}else{ %> <input
	id="grnNo1" type="text" name="<%= GRN_NO %>" value="<%=max %>"
	readonly="readonly" validate="GRN Number,metachar,no" tabindex=1 /> <%} %>

<label>CRV/RV Date<span>*</span></label>
 <input type="text"	name="<%=GRN_DATE%>" value="<%=currentDate %>" class="date"
	readonly="readonly" MAXLENGTH="30" tabindex=1 id="grnDate" /> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"onClick="setdate('<%=currentDate%>',document.grnGrid.<%=GRN_DATE%>,event)" />

<div class="clear"></div>

<div id=suppDiv>
<label>Vendor Name<span>*</span></label> <select
	name="<%= SUPPLIER_ID%>" id="supplierCombo" tabindex=1></select>

<label>SO No.</label> <select
	name="<%=INDENT_ID %>" id="indentCombo" tabindex=1>
</select>


</div>


<%--
<label>Technical Details</label> <%if(storeGrnObj != null){ %> <textarea
	value="<%=storeGrnObj.getTechnicalDetails()%>" readOnly
	name="<%=TECHNICAL_DETAILS %>" validate="Technical Details ,String,no"
	tabindex=1 onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="45" />
		</textarea> <%}else{ %> <textarea value="" name="<%=TECHNICAL_DETAILS %>"
	validate="Technical Details ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="45" />
		</textarea> <%} %>
		
	 --%>	
		

<%--<label>AT/SO No.</label> <% if(storeGrnObj != null){%> <input id="test"
	type="text" name="<%=SUPPLY_ORDER_NO %>"
	value="<%=storeGrnObj.getAtSoNo() %>" MAXLENGTH="75" tabindex=1 /> <%}else{ %>
<input id="test" type="text" name="<%=SUPPLY_ORDER_NO %>" value=""
	MAXLENGTH="75" tabindex=1> <%} %> 
	
	<label>ME SCALE </label> <select
	name="<%=ME_SCALE_ID %>" validate="ME Scale,string,yes">
	<option value="">Select</option>
	<%
			  	for (MasStoreMeScale masStoreMeScale : meScaleList) {
			%>

	<option value="<%=masStoreMeScale.getId ()%>"><%=masStoreMeScale.getMeScaleDescription()%></option>
	<% } %>

	<input type="button" class="button" name="<%=BOO_ENTRY %>"
		value="BOO Entry"
		onclick="submitFormForButton('grnGrid','stores?method=showBooJsp');" />
	<div class="clear paddingTop15"></div>
	<div id="atsoDateDiv"><label>AT/SO Date</label> <input
		id="dateTest" type="text" class="date" name="<%=AT_SO_DATE%>"
		id="atSoDate" value="<%=currentDate %>" MAXLENGTH="30"
		readonly="readonly" tabindex=1 /> <img src="/hms/jsp/images/cal.gif"
		width="16" height="16" border="0" validate="Pick a date" tabindex="1"
		onClick="setdate('<%=currentDate%>',document.grnGrid.<%=AT_SO_DATE%>,event)" />
	</div>
--%>
	<label>Date Received</label>
	<input type="text" name="<%=RECEIVED_DATE%>" value="<%=currentDate %>"
		readonly class="date" MAXLENGTH="30" size="25" tabindex=1 />

<div class="Clear"></div>
		<%--
	<label>R/R No </label>
	<% if(storeGrnObj != null){%>
	<input type="text" name="<%=RR_NO %>"
		value="<%=storeGrnObj.getRrNo() %>" MAXLENGTH="30" tabindex=1 />
	<%}else{ %>
	<input type="text" name="<%=RR_NO %>" value="" MAXLENGTH="30"
		tabindex=1 />
	<%} %>
	<div class="clear"></div>
	<label><span>*</span>Mode of Conv</label>
	<select name="<%=MODE_OF_CONVEYANCE%>"
		validate="Mode Of Conveyance,string,yes" tabindex=1>
		<option value="0">Select</option>
		<option value="1">Air</option>
		<option value="2">Bus</option>
		<option value="3">Train</option>
		<option value="4">By Hand</option>
	</select>
 --%>
<label>Invoice No.</label>
	<%if(storeGrnObj != null){ %>
	<input type="text" name="<%=INVOICE_NO %>" size="50" id="<%=INVOICE_NO%>"
		MAXLENGTH="30" value="<%=storeGrnObj.getInvoiceNo() %>"
		validate="Invoice No, String, no" tabindex=1 />
	<%}else{ %>
	<input type="text" name="<%=INVOICE_NO %>" id="<%=INVOICE_NO%>"
		value="" validate="Invoice No,metachar,no" MAXLENGTH="30" tabindex=1 />
	<%} %>
	<label>Invoice Date</label>
	<input type="text" class="date" name="<%=INVOICE_DATE%>" readonly
		id="invoiceDate" value="<%=currentDate %>" MAXLENGTH="30" tabindex=1 />
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
		validate="Pick a date" class="calender" tabindex="1"
		onClick="setdate('<%=currentDate%>',document.grnGrid.<%=INVOICE_DATE%>,event)" />
		
		
	<label>Unpacked-Checked by<span>*</span> </label>
	<select name="<%= EMPLOYEE_ID %>" validate="Unpac-Chk By,metachar,no"
		tabindex=1>
		<option value="">Select</option>
		<%String lastName="";
				  	for (MasEmployee masEmployee : employeeList) {
				  		if(masEmployee.getLastName() != null){
				  			lastName=masEmployee.getLastName();
				  		}
				%>

		<option value="<%=masEmployee.getId()%>"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+lastName %></option>
		<% } %>
	</select>
	<div class="Clear"></div>
	 <%--
	<label>How Received </label>
	<% if(storeGrnObj != null){%>
	<input type="text" name="<%=HOW_RECEIVED %>"
		value="<%=storeGrnObj.getHowReceived()%>" MAXLENGTH="50" tabindex=1 />
	<%}else{ %>
	<input type="text" name="<%=HOW_RECEIVED %>" value="" MAXLENGTH="50"
		tabindex=1 />
	<%} %>

	<div class="clear"></div>
	<label>Technical Spec</label>
	<%if(storeGrnObj != null){ %>
	<textarea value="<%=storeGrnObj.getTechnicalSpecification()%>" readOnly
		name="<%=TECHNICAL_SPECIFICATION %>"
		validate="Technical Specification ,String,no" tabindex=1
		onpaste="return checkOnPaste(this)"
		oninput="return checkMaxLengthMoz(this)"
		onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
		maxlength="45" />
		</textarea>
	<%}else{ %>
	<textarea value="" name="<%=TECHNICAL_SPECIFICATION %>"
		validate="Technical Specification,String,no" tabindex=1
		onpaste="return checkOnPaste(this)"
		oninput="return checkMaxLengthMoz(this)"
		onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
		maxlength="45" />
		</textarea>
	<%} %>
	<label class="bodytextB">AMC Contract</label>
	<%if(storeGrnObj != null){ %>
	<textarea value="<%=storeGrnObj.getAmcContract()%>" readOnly
		name="<%=AMC_CONTRACT %>" validate="AMC Contract ,String,no"
		tabindex=1 onpaste="return checkOnPaste(this)"
		oninput="return checkMaxLengthMoz(this)"
		onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
		maxlength="512" />
		</textarea>
	<%}else{ %>
	<textarea value="" name="<%=AMC_CONTRACT %>"
		validate="AMC Contract ,String,no" tabindex=1
		onpaste="return checkOnPaste(this)"
		oninput="return checkMaxLengthMoz(this)"
		onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
		maxlength="512" />
		</textarea>
	<%} %>
	<label>Remarks</label>
	<%if(storeGrnObj != null){ %>
	<textarea value="<%=storeGrnObj.getRemarks()%>" name="<%=REMARKS %>"
		validate="Remarks ,String,no" tabindex=1
		onpaste="return checkOnPaste(this)"
		oninput="return checkMaxLengthMoz(this)"
		onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
		maxlength="250" tabindex=1></textarea>
	<%}else{ %>
	<textarea value="" name="<%=REMARKS %>" validate="Remarks ,String,no"
		tabindex=1 onpaste="return checkOnPaste(this)"
		oninput="return checkMaxLengthMoz(this)"
		onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
		maxlength="250">
</textarea>
	<%} %>
	<div id=civDiv style="display: none;"><label>CIV No</label> <input
		type="text" name="civNo" id="civNo" value=""
		validate="civ No, String, no" MAXLENGTH="30" tabindex=1 /> <label>CIV
	Date</label> <input type="text" class="date" name="civDate" id="civDate"
		value="" readonly tabindex=1 /> <img id="calendar"
		src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
		validate="Pick a date" tabindex="1"
		onClick="setdate('',document.grnGrid.civDate,event)" /></div>
	<div class="clear"></div>
	
	 --%>
	
	<label>Invoice Amount</label>
	<%if(storeGrnObj != null){ %>
	<input type="text" name="<%=INVOICE_AMOUNT %>"
		id="<%=INVOICE_AMOUNT %>" value="<%=storeGrnObj.getInvoiceAmount() %>"
		validate="Invoice Amount ,metachar,no" MAXLENGTH="15" tabindex=1 onblur="getInvoiceAmt(this.value);" />
	<%}else{ %>
	<input type="text" name="<%=INVOICE_AMOUNT %>"
		id="<%=INVOICE_AMOUNT %>" value="" validate="Invoice Amount,float,no"
		MAXLENGTH="15" tabindex=1 onblur="getInvoiceAmt(this.value);"/>
	<%} %>
	<%--
	<div class="clear"></div>
	<label>Freight Duty</label>
	<%if(storeGrnObj != null){ %>
	<input type="text" name="<%=FREIGHT_DUTY %>"
		value="<%=storeGrnObj.getFreightDuty()%>" id="<%=FREIGHT_DUTY %>"
		validate="Freight Duty,float,no" MAXLENGTH="15" onblur="freight();"
		tabindex=1 />
	<%}else{ %>
	<input type="text" name="<%=FREIGHT_DUTY %>" id="<%=FREIGHT_DUTY %>"
		value="" validate="Freight Duty,float,no" MAXLENGTH="15"
		onblur="calculationInCRV();" tabindex=1 />
	<%} %>
	<label>Excise Duty</label>
	<%if(storeGrnObj != null){ %>
	<input type="text" name="<%=EXCISE_DUTY %>"
		value="<%=storeGrnObj.getExciseDuty()%>" id="<%=EXCISE_DUTY %>"
		validate="Excise Duty,float,no" MAXLENGTH="15" onblur="excise();"
		tabindex=1 />
	<%}else{ %>
	<input type="text" name="<%=EXCISE_DUTY %>" id="<%=EXCISE_DUTY %>"
		value="" validate="Excise Duty,float,no" MAXLENGTH="15"
		onblur="calculationInCRV();" tabindex=1 />
	<%} %>
	<label>Octroi</label>
	<%if(storeGrnObj != null){ %>
	<input type="text" name="<%=OCTROI %>"
		value="<%=storeGrnObj.getOctroi()%>" id="<%=OCTROI %>"
		validate="Octroi,float,no" MAXLENGTH="15" onblur="octroi();"
		tabindex=1 />
	<%}else{ %>
	<input type="text" name="<%=OCTROI %>" id="<%=OCTROI %>" value=""
		validate="Octroi,float,no" MAXLENGTH="15" onblur="calculationInCRV();"
		tabindex=1 />
	<%} %>
	<div class="clear"></div>
	<label>Insurance Charge</label>
	<%if(storeGrnObj != null){ %>
	<input type="text" name="<%=INSURANCE_CHARGES %>"
		value="<%=storeGrnObj.getInsuranceCharge()%>"
		id="<%=INSURANCE_CHARGES %>" validate="Insurance Charges,float,no"
		MAXLENGTH="15" onblur="insurance();" tabindex=1 />
	<%}else{ %>
	<input type="text" name="<%=INSURANCE_CHARGES %>"
		id="<%=INSURANCE_CHARGES %>" value=""
		validate="Insurance Charges,float,no" MAXLENGTH="15"
		onblur="calculationInCRV();" tabindex=1 />
	<%} %>
	<label>Other Charges</label>
	<%if(storeGrnObj != null){ %>
	<input type="text" name="<%=OTHER_CHARGES %>"
		value="<%=storeGrnObj.getOtherCharges()%>" id="<%=OTHER_CHARGES %>"
		validate="Other Charges,float,no" MAXLENGTH="15"
		onblur="otherCharges();" tabindex=1 />
	<%}else{ %>
	<input type="text" name="<%=OTHER_CHARGES %>" id="<%=OTHER_CHARGES %>"
		value="" validate="Other Charges,float,no" MAXLENGTH="15"
		onblur="calculationInCRV();" tabindex=1 />
	<%} %>
	<label>Custom Duty</label>
	<%if(storeGrnObj != null){ %>
	<input type="text" name="<%=CUSTOM_DUTY %>"
		value="<%=storeGrnObj.getCustomDuty()%>" id="<%=CUSTOM_DUTY %>"
		validate="Custom Duty,float,no" MAXLENGTH="15" onblur="custom();"
		tabindex=1 />
	<%}else{ %>
	<input type="text" name="<%=CUSTOM_DUTY %>" id="<%=CUSTOM_DUTY %>"
		value="" validate="Custom Duty,float,no" MAXLENGTH="15"
		onblur="calculationInCRV();" tabindex=1 />
	<%} %>
	<label >Discount(%)</label>
	<input type="text" name="<%=DISCOUNT%>" id="discount" value="0" MAXLENGTH="15"/  >
	<input type="hidden" name="discount1" id="discount1" value="0" MAXLENGTH="15"/  > 
	<label >VAT(%)</label>
	<input type="text" name="vat" id="vat" value="0" MAXLENGTH="15"/  >
	<input type="hidden" name="vat1" id="vat1" value="0" MAXLENGTH="15"/  >
	 --%>
	<label >CRV/RV Value<span>*</span></label>
	 <input type="text" name="<%=GRN_VALUE %>" id="<%=GRN_VALUE %>" value="" MAXLENGTH="15"    /> 
	


</div>

<div class="clear"></div>



<% for(UserButtonRights  userButtonRights : userRightsList){
				String buttonName=userButtonRights.getButton().getButtonName();
				if(userButtonRights.getButton().getFormName().equals("CRV Form")){
					String formulaUsed=userButtonRights.getButton().getFormulaUsed();

	    %> <input type="button" name="no"
	value="<%=userButtonRights.getButton().getButtonName() %>"
	class="<%=userButtonRights.getButton().getClassName() %>"
	onclick="<%=userButtonRights.getButton().getUrl()%>" /> <%}} %> <!-- <input type="button" name="sss" align="right" class="button" value="PVMS/NIV" onclick="openItemPopup();"/>
	    <input type="button" name="sss" align="right" class="button" value="Vendor" onclick="openVendorPopup();"/>-->
<input type="hidden" size="2" value="0" name="<%=NO_OF_ROWS %>"
	id="<%=NO_OF_ROWS %>" /> <input type="hidden" name="<%=GRN_ID %>"
	value="<%=grnId%>" id="hdb" />

<div id="gridDiv"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<label> Total Amount</label>
<input type="test" name="<%=TOTAL_AMOUNT %>" id="<%=TOTAL_AMOUNT%>"
	value=""> <input type="hidden" name="<%=CLOSING_STOCK %>"
	id="<%=CLOSING_STOCK%>" value=""> 
	
	<div class="Clear"></div>
	<div class="division"></div>
	<input type="button" name="sss" class="button" value="SAVE"
	onclick="if(checkForCRVGridForNe() && checkSave()&& checkForSubmit()){submitForm('grnGrid','neStores?method=submitGrn');}" />
	<input
	type="button" name="print" type="submit" class="button" value="Print"
	onClick="submitForm('createGrn','stores?method=showGrnReportJsp');">
	<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label></div>


<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <script
	type="text/javascript">
				<!--
					// Main vBulletin Javascript Initialization
					vBulletin_init();
				//-->
				</script> <input type="hidden" name="rows" id="rr" value="1" />

</form>
</form>
<script
	type="text/javascript">
function getSearchBlock()
{

document.getElementById('searchBlock').style.display = 'inline';
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
			var supplierCombo1=document.getElementById('supplierCombo').value;
			if(trimAll(invoiceNo1)=='<%=invoiceNo12%>' &&
				invoiceDate1=='<%=invoiceDate%>' &&
				supplierCombo1=='<%=supplierCombo1%>'){
				 alert("Duplicate Invoice  No For same vendor not allowed for the same date....");
				 document.getElementById('<%=INVOICE_NO%>').value='';
			 	return false;
			}
			<%}}%>
			return true;
}


function onChangeSourceOfSupply1(sos)
{
	
	document.getElementById("indentCombo").options.length=0;
	if(sos=="a" || sos=="o" || sos=="i")
	{
	 document.getElementById('rv').style.display = 'inline';
	 document.getElementById('crv').style.display = 'none';
	
	 var grnNo=document.getElementById('rvMax').value;
	 document.getElementById('grnNo1').value=grnNo; 
	}
	else
	{
		 
		document.getElementById('crv').style.display = 'inline';
		document.getElementById('rv').style.display = 'none';
		var grnNo=document.getElementById('crvMax').value;
		 document.getElementById('grnNo1').value=grnNo; 
	}
	 /*if (sos == "w")
	{
	document.getElementById("indentCombo").disabled = true;
	document.getElementById("supplierCombo").disabled = true;
	submitProtoAjaxforGrid('grnGrid','/hms/hms/stores?method=responseGridList');
	return;
	}*/
	
	if (sos == "w")
	{
		document.getElementById("indentCombo").disabled = true;
		if (document.getElementById("test").disabled == false)
		document.getElementById("test").disabled = true;
		submitProtoAjaxforSupplier('grnGrid','/hms/hms/stores?method=responseForList');
		submitProtoAjaxforGrid('grnGrid','/hms/hms/stores?method=responseGridList');
		return;
	}
	

	if (sos == "o" || sos == "l")
	{
		document.getElementById("indentCombo").disabled = true;
		if (document.getElementById("test").disabled == false)
		document.getElementById("test").disabled = true;
	}
	else
	{
		document.getElementById("indentCombo").disabled = false;

		if (document.getElementById("test").disabled == true)
		document.getElementById("test").disabled = false;
	}
	submitProtoAjaxforSupplier('grnGrid','/hms/hms/stores?method=responseForList');

	if(sos == "o")
	{
	submitProtoAjaxforGrid('grnGrid','/hms/hms/stores?method=responseGridList');
	}

	if(sos =="o" || sos == "a" ||sos == "p")
	{
	document.getElementById("invoiceNo").disabled = true;
	document.getElementById("invoiceAmount").disabled = true;
	document.getElementById("invoiceDate").disabled = true;
	}
	else
	{
	document.getElementById("invoiceNo").disabled = false;
	document.getElementById("invoiceAmount").disabled = false;
	document.getElementById("invoiceDate").disabled = false;
	}
	if(sos=="i"){
	document.getElementById("indentCombo").disabled = true;
	//submitProtoAjaxforSupplier('grnGrid','/hms/hms/stores?method=responseForList');
	submitProtoAjaxforGrid('grnGrid','/hms/hms/stores?method=responseGridList');
	}
}



function ajaxFunctionForAutoCompleteInGrnGeneral1(formName,action,rowVal) {
	 
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
	      if(xmlHttp.readyState==4){
	      
	      	var items = xmlHttp.responseXML.getElementsByTagName('items')[0];
	      
	      
		

			var manufacturerId ="manufacturerId"+rowVal;
			obj1 = document.getElementById(manufacturerId); 
		//	obj1.length = 1;
			
			
		
				
	      	for (loop = 0; loop < items.childNodes.length; loop++) 
	      	{
	      	 	var item = items.childNodes[loop];
		        var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		      
		        var formula = item.getElementsByTagName("formula")[0];
		        var conversionFactor = item.getElementsByTagName("conversionFactor")[0];
		        var name  = item.getElementsByTagName("name")[0];
		        var brandLength  = item.getElementsByTagName("brands")[0];
		        var expiry = item.getElementsByTagName("expiry")[0];
		        
	        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
	        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
	        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
	        	document.getElementById('expiry'+rowVal).value = expiry.childNodes[0].nodeValue
		       	document.getElementById('formula'+rowVal).value = formula.childNodes[0].nodeValue
	        	document.getElementById('conversionFactor'+rowVal).value = conversionFactor.childNodes[0].nodeValue
	        
				/*
	        	
	        	for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++)
	        	{
	        		var brand = brandLength.childNodes[innerLoop];
		      
		        	var manufacturerId = brand.getElementsByTagName("manufacturerId")[0];
		        
		        	var manufacturerName  = brand.getElementsByTagName("manufacturerName")[0];	        	
		        	
		        			
					
					obj1.length++;
					obj1.options[obj1.length-1].value=manufacturerId.childNodes[0].nodeValue;
					obj1.options[obj1.length-1].text=manufacturerName.childNodes[0].nodeValue;
		        	
	        	}*/
	      	} 
	      }
	    }
	   	 var url=action
	     
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	    
	  }


function onChangeSrcForNeGrn11(sos)
{
	

if(sos=="c" || sos=="b")
{
	
	submitProtoAjaxforSupplierForNe('grnGrid','/hms/hms/neStores?method=responseNeGrn');

}



//if(sos=="a" || sos=="d")
	if(sos=="a")
{
		
	submitProtoAjaxforSupplierForNe('grnGrid','/hms/hms/neStores?method=responseNeGrn');
	submitProtoAjaxforGridForNeGrn('grnGrid','/hms/hms/neStores?method=responseGridList');

}
	if(sos=="d")
	{    

		submitProtoAjaxforSupplierForNe('grnGrid','/hms/hms/neStores?method=responseNeGrn');
		submitProtoAjaxforGridForNeGrn('grnGrid','/hms/hms/neStores?method=responseGridListForOtherSource');

	}
}

function getgridItemForIndent(indentId)
{
	
	submitProtoAjaxforGridForNeGrn('grnGrid','/hms/hms/neStores?method=responseGridList&indentId='+indentId);	

}


function submitProtoAjaxforSupplierForNe(formName,action){
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)
    	   	
        	new Ajax.Updater('suppDiv',url,
			   {asynchronous:true, evalScripts:true });
	       	return true;
    	}    	


function submitProtoAjaxforGridForNeGrn(formName,action){
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)
        	
        	new Ajax.Updater('gridDiv',url,
			   {asynchronous:true, evalScripts:true }); 
	       	return true;
    	}


function getNameAndData(formName) {
	   var str="";
	   inputs = eval('document.'+formName+'.elements');
	   for(i=0;i<inputs.length;i++){
	   	str=str+inputs[i].name+"="+inputs[i].value+"&"
	   }
	   return str;
	}


function checkForCRVGridForNe()
{
	
    for(i=1;i<=60;i++)
	    {
		   if(document.getElementById('codeItem'+i) != null){
		    var pvms = document.getElementById('codeItem'+i).value;
		   
		    if(pvms !="")
		    {

			   
			    
			    if (document.getElementById('manufacturerId'+i).value=="")
			    { 
			    alert('Pl. Check Manufacturer in Row No:' + i);
			    document.getElementById('manufacturerId'+i).focus();
			    return false;
			    }
		
				
		   		if (document.getElementById('batchNo'+i).value=="")
			    { 
			    alert('Pl. Check Batch No in Row No:' + i);
			    document.getElementById('batchNo'+i).focus();
			    return false;
			    } 
				
			    if (document.getElementById('quanRec'+i).value=="" || isNaN(document.getElementById('quanRec'+i).value))
			    { 
			    alert('Pl. Check Quantity Received in Row No:' + i);
			    document.getElementById('quanRec'+i).focus();
			    return false;
			    }
			    
			  	
			    
			    
			    
			   // if(document.getElementById('sourceCombo').value=="a" || document.getElementById('sourceCombo').value=="i" || document.getElementById('sourceCombo').value=="o")
			  //  {
			  // 	return true;
			  //  }
			 //   else if (document.getElementById('ratePerMdq'+i).value=="" || document.getElementById('ratePerMdq'+i).value==0 || isNaN(document.getElementById('ratePerMdq'+i).value))
			//    { 
			//    alert('Pl. Check Rate / MDQ in Row No:' + i);
			//    document.getElementById('ratePerMdq'+i).focus();
			//    return false;
			//    }
			    
			    
			   // if(document.getElementById('sourceCombo').value=="a" ||document.getElementById('sourceCombo').value=="i" || document.getElementById('sourceCombo').value=="o")
			  //  {
			  //  return true;
			  //  }
			  //  else if (document.getElementById('amtVar'+i).value=="" || document.getElementById('amtVar'+i).value==0 || document.getElementById('amtVar'+i).value < 0)
			  //  { 
			   // alert('Pl. Check Amount in Row No:' + i);
			  //  return false;
			  //  }
			    
			    
/*			    if (document.getElementById('manufacturingDate'+i).value=="")
			    { 
			    alert('Manufacturing Date in Row No:' + i + ' is Mandatory!..');
			    document.getElementById('manufacturingDate'+i).focus();
			    return false;
			    }
			    else
			    {
					var strValue = document.getElementById('manufacturingDate'+i).value;
				 	dateOfJoining = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
					currentDate = new Date();
					var month = currentDate.getMonth() + 1
					var day = currentDate.getDate()
					var year = currentDate.getFullYear()
					var seperator = "/"
					currentDate = new Date(month + seperator + day + seperator + year);
					if(dateOfJoining > currentDate)
					{
						alert('Manufacturing Date is Not Valid in Row No: ' + i );
						return false;
					}
			    }
*/		


/*
			    if (document.getElementById('expiry'+i).value=='y')
			    {
			    	if (document.getElementById('expiryDate'+i).value=="")
			    	{
			    	  alert('Expiry Date in Row No:' + i + ' is Mandatory!..');
			    	  document.getElementById('expiryDate'+i).focus();
			    	  return false;
			    	}
			    	
					var strValue = document.getElementById('expiryDate'+i).value;
				    dateOfJoining = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
				 	currentDate = new Date();
					var month = currentDate.getMonth() + 1
					var day = currentDate.getDate()
					var year = currentDate.getFullYear()
					var seperator = "/"
					currentDate = new Date(month + seperator + day + seperator + year);
					if(dateOfJoining < currentDate)
				 	{
						alert('Expiry Date is Not Valid in Row No: ' + i );
						return false;
				 	}
			    }	

			    */
		    }
		    }
	    }
	   
	    return true;
}	    


function calculationInCRV()
{
	
   	var sos = document.getElementById('sourceCombo').value
  
   	for(rowVal=1;rowVal<=60;rowVal++)
		{
		//alert(document.getElementById('idItem'+rowVal).value.trim())
			if(document.getElementById('idItem'+rowVal).value.trim()!=0)
			{
   			var discount = parseFloat(0);
				var tax = parseFloat(0);
				var vatApplicable = document.getElementById('vatApplicable');
			
				//Calculation of Amount for the Current Row (rowVal)
				
				var quantity = isNaN(parseFloat(document.getElementById('quanRec'+rowVal).value))==true?"0":parseFloat(document.getElementById('quanRec'+rowVal).value);
				
			//	var freeQty = isNaN(parseFloat(document.getElementById('freeQty'+rowVal).value))==true?"0":parseFloat(document.getElementById('freeQty'+rowVal).value);
				var ratePerMdq = isNaN(parseFloat(document.getElementById('ratePerMdq'+rowVal).value))==true?"0":parseFloat(document.getElementById('ratePerMdq'+rowVal).value);
				var discount = isNaN(parseFloat(document.getElementById('discountVar'+rowVal).value))==true?"0":parseFloat(document.getElementById('discountVar'+rowVal).value);
				if(sos != 'l'){
				//var tax = isNaN(parseFloat(document.getElementById('taxVar'+rowVal).value))==true?"0":parseFloat(document.getElementById('taxVar'+rowVal).value);
				}else{
				//var taxAmt = isNaN(parseFloat(document.getElementById('tax_amt_mdq' + rowVal).value))==true?"0":parseFloat(document.getElementById('tax_amt_mdq' + rowVal).value);
				//var ed = isNaN(parseFloat(document.getElementById('ed'+rowVal).value))==true?"0":parseFloat(document.getElementById('ed'+rowVal).value);
				}

				var total = parseFloat(0);
				var disc= parseFloat(0);
				var amountAfterdiscount= parseFloat(0);
				var taxAmount = parseFloat(0);
				var netAmount= parseFloat(0);
	
				if(sos != 'l'){
				     total = parseFloat(quantity)*parseFloat(ratePerMdq);
				}else{
				  if(vatApplicable.checked){
				     //total = (parseFloat(quantity)* parseFloat(ratePerMdq)) + parseFloat(ed);
					  total = (parseFloat(quantity)* parseFloat(ratePerMdq));
				  }else{
				     //total = (parseFloat(quantity)* (parseFloat(ratePerMdq) + parseFloat(taxAmt))) + parseFloat(ed);
				     total = (parseFloat(quantity)* (parseFloat(ratePerMdq) + parseFloat(taxAmt)));
				}
				}
				
				disc = total*(discount/100);
				amountAfterdiscount = total-disc;
				
			   if(sos != 'l'){
				taxAmount = (amountAfterdiscount)*(tax/100)
				if (vatApplicable.checked)
					{
				     netAmount = amountAfterdiscount;
				
		 			}
		 		else{
					 netAmount = amountAfterdiscount + taxAmount;
				 	}
				} else {
				     netAmount = amountAfterdiscount;
				} 	
				 	 
				document.getElementById('amtVar'+rowVal).value=roundVal(netAmount,2);
				if(sos != 'l'){
				//document.getElementById('taxAmount'+rowVal).value=roundVal(taxAmount,4);
				}
				//alert(disc)
				document.getElementById('discountAmount'+rowVal).value=roundVal(disc,4);

				// Calculating converted Stock as Per Formula  & Conversion Login
				var formula = isNaN(parseFloat(document.getElementById('formula'+rowVal).value))==true?"0":parseFloat(document.getElementById('formula'+rowVal).value);
				var conversionFactor = isNaN(parseFloat(document.getElementById('conversionFactor'+rowVal).value))==true?"0":parseFloat(document.getElementById('conversionFactor'+rowVal).value);
				//var mdq = isNaN(parseFloat(document.getElementById('mdq'+rowVal).value))==true?"0":parseFloat(document.getElementById('mdq'+rowVal).value);
				var convertedStock = parseFloat(0);
				
				//quantity = parseFloat(quantity) + parseFloat(freeQty);
				if (formula !=0 && conversionFactor != 0 )
				{
					//if (formula==1)
					//{
						//convertedStock = (parseFloat(quantity) * parseFloat(mdq)) / parseFloat(conversionFactor);
					//}
					 if (formula==2)
					{
						convertedStock = parseFloat(quantity);
					}
					document.getElementById('convertedStock'+rowVal).value = parseFloat(convertedStock);
				}

			}
		}
		
		calculateGRNValue(sos);
}
function calculateGRNValue(sos)
{

	//Calculation of Total GRN Value
	var exciseDuty=isNaN(parseFloat(document.getElementById('exciseDuty').value.trim()))==true?"0":parseFloat(document.getElementById('exciseDuty').value.trim());
	var freightDuty=isNaN(parseFloat(document.getElementById('freightDuty').value.trim()))==true?"0":parseFloat(document.getElementById('freightDuty').value.trim());
	var octroi=isNaN(parseFloat(document.getElementById('octroi').value.trim()))==true?"0":parseFloat(document.getElementById('octroi').value.trim());
	var insuranceCharges=isNaN(parseFloat(document.getElementById('insuranceCharges').value.trim()))==true?"0":parseFloat(document.getElementById('insuranceCharges').value.trim());
	var otherCharges=isNaN(parseFloat(document.getElementById('otherCharges').value.trim()))==true?"0":parseFloat(document.getElementById('otherCharges').value.trim());
	var customDuty= isNaN(parseFloat(document.getElementById('customDuty').value.trim()))==true?"0":parseFloat(document.getElementById('customDuty').value.trim());
	
	var tempNetValue = parseFloat(0);
	var charge = parseFloat(0);
	var vat = parseFloat(0);
	var temp = 0;
	
	
	for(i=1;i<=40;i++)
	{
		if(document.getElementById('idItem'+i).value.trim()!=0)
		{
		 	var freeItem = document.getElementById('freeItem'+i).value;
			if (freeItem=='n') 
				tempNetValue=parseFloat(tempNetValue)+parseFloat(document.getElementById('amtVar'+i).value);
		}
	}
	
	// Update Cost Price of All Items in the Grid
	// (Duty + VAT) / Total Amt in Grid * Row Amount = Additional Tax
	// Row Amount = Row Amount + Additional Tax
	// Item Cost Price = Row Amount / Converted Stock

	charge = parseFloat(freightDuty) + parseFloat(exciseDuty) + parseFloat(octroi) + parseFloat(insuranceCharges) + parseFloat(otherCharges) + parseFloat(customDuty);
	var vat = isNaN(parseFloat(document.getElementById('vatTax').value))==true?"0":parseFloat(document.getElementById('vatTax').value);
	var totDiscount = isNaN(parseFloat(document.getElementById('totDiscount').value))==true?"0":parseFloat(document.getElementById('totDiscount').value);
	var vatApplicable = document.getElementById('vatApplicable');
	//if (vatApplicable.checked == false)	
	//	charge = parseFloat(charge) + parseFloat(vat); 
	charge = parseFloat(charge) - parseFloat(totDiscount) 
	
	var rowAmt = parseFloat(0);
	var additionalTax = parseFloat(0);
	var convertedStock = parseFloat(0);
	var costPrice = parseFloat(0);
	
	for(i=1;i<=40;i++)
	{
		if(document.getElementById('idItem'+i).value.trim()!=0)
		{
		    rowAmt = isNaN(parseFloat(document.getElementById('amtVar'+i).value))==true?0:parseFloat(document.getElementById('amtVar'+i).value);

		    if (parseFloat(tempNetValue) > 0 && parseFloat(rowAmt) > 0)
		 		additionalTax = (parseFloat(charge) / parseFloat(tempNetValue)) * parseFloat(rowAmt);

		 	rowAmt = rowAmt + additionalTax;
		 	//document.getElementById('amtVar'+i).value = roundVal(rowAmt,2);
		 	convertedStock = isNaN(parseFloat(document.getElementById('convertedStock'+i).value))==true?"0":parseFloat(document.getElementById('convertedStock'+i).value);
		 	if (convertedStock > 0) 
		 		costPrice = parseFloat(rowAmt) / parseFloat(convertedStock);
		 	else
		 		costPrice = parseFloat(0);
		 	document.getElementById('costPrice'+i).value = roundVal(costPrice,3);
		}
	}

	//Calculate Total Amount 
	tempNetValue = parseFloat(0);
	
	for(i=1;i<=40;i++)
	{
		if(document.getElementById('idItem'+i).value.trim()!=0)
		{
		 	var freeItem = document.getElementById('freeItem'+i).value;
	         if (freeItem=='n') 
		     tempNetValue=parseFloat(tempNetValue)+parseFloat(document.getElementById('amtVar'+i).value);
			 
		}
	}
	
	
	//document.getElementById('grnValue').value=roundVal(tempNetValue,2);
	var actualValue=tempNetValue+charge;
	actualValue = roundVal(actualValue,2);
	var valueAfterRounding=tempNetValue + charge;
	var valueAfterRounding1 = roundVal(valueAfterRounding,0)
	var roundOffAmount  = valueAfterRounding-valueAfterRounding1;
	
  if (vatApplicable.checked){
	var vat = parseFloat(0);
	 vat = document.getElementById('vatTax').value;
	var vatgrn = parseFloat(0);
	  if(vat == ""){
	   vat = parseFloat(0);
	  }
	    var vatgrn1 =charge + tempNetValue + parseFloat(vat);
	    vatgrn=roundVal(vatgrn1,0);
	    roundOffAmount=vatgrn1-vatgrn;
	
      document.getElementById('grnValue').value =vatgrn 

   }else{
 	    document.getElementById('grnValue').value=valueAfterRounding1
	 }
	
	//document.getElementById('grnValue').value=valueAfterRounding
	roundOffAmount=roundVal(roundOffAmount,3);
	document.getElementById('roundOfValue').value=roundOffAmount
	document.getElementById('actualGrnValue').value=actualValue
}



//Calculate Unit Rate in LPO
function calculateUnitRateinLocalSupplyOrder(inc)
{
   	var mdq = "mdq";
   	var ratePerMdq = "ratePerMdq";
   	var unitRateVarTemp = "unitRateVarTemp";
   	var unitRateVar = "unitRateVar";
   	if (!isNaN(document.getElementById(mdq+inc).value) && !isNaN(document.getElementById(ratePerMdq+inc).value))
   	{
   		document.getElementById(unitRateVarTemp+inc).value = parseFloat(document.getElementById(ratePerMdq+inc).value) / parseFloat(document.getElementById(mdq+inc).value);
   		var result = parseFloat(document.getElementById(unitRateVarTemp+inc).value);
   		document.getElementById(unitRateVar+inc).value = roundVal(result,2);
			calculateAmountForAdd(inc);
   	}
}

function getManufId(val,t)
{

	document.getElementById('manufacturerId1'+t).value=val
}
function getManufacturer(rowVal)
{
	var itemId=document.getElementById('idItem'+rowVal).value;
	  ajaxFunctionForAutoCompleteManufacturer('grnGrid','neStores?method=fillItemsForManufacturer&requiredField=' + itemId,rowVal);
}

function ajaxFunctionForAutoCompleteManufacturer(formName,action,rowVal) {
	 
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
	      if(xmlHttp.readyState==4){
	      
	      	var items = xmlHttp.responseXML.getElementsByTagName('items')[0];
	      
	      	
			var manufacturerId ="manufacturerId"+rowVal;
			obj1 = document.getElementById(manufacturerId); 
			obj1.length = 1;
			
		
				
	      	for (loop = 0; loop < items.childNodes.length; loop++) 
	      	{
	      		
	      	  var item = items.childNodes[loop];
	      	 
		     //  var id  = item.getElementsByTagName("id")[0];
		       
	        	var manufacturerId = item.getElementsByTagName("manufacturerId")[0];
	        
	        	var manufacturerName  = item.getElementsByTagName("manufacturerName")[0];	        	
	        	
	        			
				
				obj1.length++;
				obj1.options[obj1.length-1].value=manufacturerId.childNodes[0].nodeValue;
				obj1.options[obj1.length-1].text=manufacturerName.childNodes[0].nodeValue;
	        		
		        	
		        	
	        	
	      	} 
	      }
	    }
	   	 var url=action
	     
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	    
	  }

function getSupplierNo(val)

{

submitProtoAjaxforSupplierForNeGrn('grnGrid','/hms/hms/neStores?method=responseSupplierNoForNeGrn&supplierId='+val);	

}


function submitProtoAjaxforSupplierForNeGrn(formName,action){
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)
    	   	
        	new Ajax.Updater('suppNoDiv',url,
			   {asynchronous:true, evalScripts:true });
	       	return true;
    	}    	

function getSOItems(poId)
{
submitProtoAjaxforGridForNeGrn('grnGrid','/hms/hms/neStores?method=responseGridListForPO&poId='+poId);
}



function getSOItemsForDGAFMS()
{
submitProtoAjaxforGridForNeGrn('grnGrid','/hms/hms/neStores?method=responseGridListForDGAFMS');
}

function getInvoiceAmt(val)
{
	var grnValue=document.getElementById('<%=GRN_VALUE%>').value;
	//alert(grnValue);
	
}
function calculateTotalCrvAmount(inc)
{

// var discount = parseFloat(0);
// var tax = parseFloat(0);
// var totalCarryForward = 0;
 var grandTotal = 0;

 var hdb = document.getElementById('hdb').value;
 //alert("hdb :"+hdb);
// if (!isNaN(document.getElementById('totalCarryForward').value))
//	totalCarryForward = parseFloat(document.getElementById('totalCarryForward').value);

//	for(var i=1 ;i<= inc;i++){
// var quantity = isNaN(parseFloat(document.getElementById('quantity'+i).value))==true?"0":parseFloat(document.getElementById('quantity'+i).value);
// var price = isNaN(parseFloat(document.getElementById('price'+i).value))==true?"0":parseFloat(document.getElementById('price'+i).value);
// var discount = isNaN(parseFloat(document.getElementById('discount'+i).value))==true?"0":parseFloat(document.getElementById('discount'+i).value);
// var tax = isNaN(parseFloat(document.getElementById('tax'+i).value))==true?"0":parseFloat(document.getElementById('tax'+i).value);

// var total = parseFloat(0);
 //var disc= parseFloat(0);
// var amountAfterdiscount= parseFloat(0);
//// var taxAmount = parseFloat(0);
 var netAmount= parseFloat(0);
 // total = parseFloat(quantity)*parseFloat(price);
// disc = total*(discount/100);
// amountAfterdiscount = total-disc;
// taxAmount = (amountAfterdiscount)*(tax/100)
// netAmount = amountAfterdiscount + taxAmount;

// document.getElementById('amount'+i).value=roundVal(netAmount,2);

//}
 for(var r =1;r<=inc;r++){
	// var totalAmt =document.getElementById('amtVar'+r).value;
	 var totalAmt= isNaN(parseFloat(document.getElementById('amtVar'+r).value))==true?"0":parseFloat(document.getElementById('amtVar'+r).value);
	// alert("r value >+"+r);
	// alert("totalAmt >"+totalAmt);
 grandTotal = grandTotal +totalAmt;
 //alert("grandTotal >"+grandTotal);
 //document.getElementById('total_amount').value = roundVal(grandTotal,2);
 document.getElementById('totalAmount').value = roundVal(grandTotal,2);
	}
}


//add  javed khan
function addRow(){

	  var tbl = document.getElementById('grnDetails');
	 
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  hdb.value=iteration

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size = '1';
	  e0.name='<%=SR_NO%>';
	  e0.readOnly=true;
	  e0.value=iteration;
	  cellRight0.appendChild(e0);

	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='pvmsNo1'+iteration;
	  e1.id='pvmsNo'+iteration
	  e1.onblur=function(){checkForReturnDispensary1(this.value, document.getElementById('pvmsNo'+iteration).value,iteration)}
	  e1.size='10';
	  e1.setAttribute('tabindex','1');
	 // e1.onblur=function(){readOnlyNomenclature(this.value,iteration)};
	  cellRight1.appendChild(e1);

	  var sel11 = document.createElement('input');
	  sel11.type = 'hidden';
	  sel11.name='itemId'+iteration;
	  sel11.id='itemId'+iteration
	  sel11.size = '10';
	  sel11.setAttribute('tabindex','1');
	  cellRight1.appendChild(sel11);
	  
	  
	//  alert("1---");
	  var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	 
	 // e0.innerHTML = iteration+':'
	//  alert("2---");
	e2.name = 'Nomenclature' + iteration;
	  e2.id = 'nomenclature' + iteration;
	  e2.onblur=function(){checkForReturnDispensary(this.value, document.getElementById('nomenclature'+iteration).value,iteration)}
	  var newdiv = document.createElement('div');
	newdiv.setAttribute('id', 'ac2update'+iteration);
	newdiv.setAttribute('class', 'autocomplete');
 	newdiv.style.display = 'none';
	
e2.size = '30';
	//  alert("3-1--");
	  e2.setAttribute('tabindex','1');
	//  alert("3-2--");
	            cellRight2.appendChild(newdiv);
	  cellRight2.appendChild(e2);
	  e2.focus();
	
	//  alert("3--3-"+iteration);
	 new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'stores?method=getItemListForDepartmentReturn',{parameters:'requiredField=Nomenclature'+iteration});
	   //alert("name--"+e0.name)
//alert("4---");
	    
	//  alert("5---");
	
	 var cellRight3 = row.insertCell(3);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.name='AV'+iteration;
	  e11.id='idAu'+iteration
	  e11.size='6';
	  e11.setAttribute('tabindex','1');
	  //e11.onblur=function(){readOnlyNomenclature(this.value,iteration)};
	  cellRight3.appendChild(e11);
	  
	  

	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='pvmsNo'+iteration;
	  sel.id='pvmsNo'+iteration
	  sel.size = '5';
	  sel.setAttribute('tabindex','1');
	  cellRight3.appendChild(sel);
	
	 
	  var cellRight5 = row.insertCell(4);
	  var e21 = document.createElement('input');
	  e21.name='batchNo'+iteration;
	  e21.id='batchNo'+iteration;
	  //e21.classname='smalllabel';
	 // e21.setAttribute('tabindex','1');
	  e21.size = '7';
	  e21.onBlur=function(){getExpiryDateByAjax(this.value,iteration,document.getElementById('itemId'+iteration).value)};
	  cellRight5.appendChild(e21);
	 
	 
	 
	 
	  var cellRight51 = row.insertCell(5);
	  var e215 = document.createElement('Select');
	  e215.name='batchId'+iteration;
	  e215.id='batchId'+iteration;
	
	  //e215.className='small3';
	 // e21.setAttribute('tabindex','1');
	  e215.options[0] = new Option('Select', '0');
	  e215.onchange=function(){getExpiryDateByAjax(this.value,iteration,document.getElementById('itemId'+iteration).value)};
	  cellRight51.appendChild(e215);
	  



	   

	  var cellRight611 = row.insertCell(6);
	  var e51 = document.createElement('input');
	  e51.type = 'text';
	  e51.name='quantityReceived'+iteration;
	  e51.id='quanRec'+iteration;
	  e51.size='8';
	  e51.setAttribute('maxlength', 10); 
	  e51.setAttribute('tabindex','1');
	  cellRight611.appendChild(e51);


	  var cellRight711 = row.insertCell(7);
	  var e711 = document.createElement('input');
	  e711.type = 'text';
	  e711.name='mrp'+iteration;
	  e711.id='mrp'+iteration
	  e711.size='4';
	  e711.setAttribute('tabindex','1');
	  //e11.onblur=function(){readOnlyNomenclature(this.value,iteration)};
	  cellRight711.appendChild(e711);

	  var cellRight811 = row.insertCell(8);
	  var e811 = document.createElement('input');
	  e811.type = 'text';
	  e811.name='unitRate'+iteration;
	  e811.id='ratePerMdq'+iteration
	  e811.size='4';
	  e811.setAttribute('tabindex','1');
	  //e11.onblur=function(){readOnlyNomenclature(this.value,iteration)};
	  cellRight811.appendChild(e811);

	  var cellRight911 = row.insertCell(9);
	  var e911 = document.createElement('input');
	  e911.type = 'text';
	  e911.name='discountPercentage'+iteration;
	  e911.id='discountVar'+iteration
	  e911.size='5';
	  e911.setAttribute('tabindex','1');
	  //e11.onblur=function(){readOnlyNomenclature(this.value,iteration)};
	  cellRight911.appendChild(e911);

	  var cellRight1011 = row.insertCell(10);
	  var e1011 = document.createElement('input');
	  e1011.type = 'text';
	  e1011.name='amount'+iteration;
	  e1011.id='amtVar'+iteration
	  e1011.size='7';
	  e1011.setAttribute('tabindex','1');
	  //e11.onblur=function(){readOnlyNomenclature(this.value,iteration)};
	  cellRight1011.appendChild(e1011);

	  var cellRight1111 = row.insertCell(11);
	  e1111 = document.createElement('input');
	  e1111.type = 'text';
	  e1111.name='reasonForDemand'+iteration;
	  e1111.id='reasonForDemand'+iteration
	  e1111.size='7';
	  e1111.setAttribute('tabindex','1');
	  //e11.onblur=function(){readOnlyNomenclature(this.value,iteration)};
	  cellRight1111.appendChild(e1111);

	  
	  

	  var cellRight61 = row.insertCell(12);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.className='date';
	  e5.name='expiryDate'+iteration;
	  e5.id='expiryDate'+iteration;
	  e5.size='8';
	  e5.setAttribute('maxlength', 10); 
	  e5.setAttribute('tabindex','1');
	  cellRight61.appendChild(e5);

	  var cellRight612 = row.insertCell(13);
	  var e512 = document.createElement('input');
	  e512.type = 'text';
	  e512.className='date';
	  e512.name='manuf'+iteration;
	  e512.id='manuf'+iteration;
	  e512.size='10';
	  e512.setAttribute('maxlength', 10); 
	  e512.setAttribute('tabindex','1');
	  cellRight612.appendChild(e512);

/*

	 // var cellRight311 = row.insertCell(6);
		 var e311 = document.createElement('img');
	     e311.src = '/hms/jsp/images/cal.gif';
	    // e3.style.display ='none';
	     e311.id = 'calId'+iteration;
	     e311.onclick = function(event){
	     setdate('',document.getElementById('expiryDate'+iteration),event) };
	     cellRight61.appendChild(e311);
		 */


		 var cellRight612 = row.insertCell(14);
		  var e612 = document.createElement('input');
		  e612.type = 'text';
		  e612.name = 'stockAvailable' + iteration;
		  e612.id = 'stockAvailable' + iteration;
		  e612.size = '5';
		  //e6.value=document.getElementById('stockAvailable'+rowVal).value;
		  e612.readOnly=true;
		  cellRight612.appendChild(e612);
		  
	  var cellRight6 = row.insertCell(15);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='issueQty'+iteration;
	  e4.id='qtyIssued'+iteration;
	  e4.size='6';
	  e4.setAttribute('maxlength', 3); 
	  e4.setAttribute('tabindex','1');
	  e4.setAttribute('validate','noOfDays,int,yes');
	  e4.onblur = function(){checkQty(iteration)};
	  cellRight6.appendChild(e4);

	  var e5 = document.createElement('input');
	  e5.type = 'hidden';
	  e5.name='total'+iteration;
	  e5.id='total'+iteration;
	  e5.size='5';
	  e5.setAttribute('tabindex','1');
	  cellRight6.appendChild(e5);




	  var cellRight10 = row.insertCell(16);
	  var e8 = document.createElement('input');
	  e8.type = 'button';
	  e8.className = 'buttonAdd';
	  e8.name='remarks'+iteration;
	  e8.setAttribute('onClick', 'addRow();'); 
	  e8.setAttribute('tabindex','1');
	  cellRight10.appendChild(e8);

	  var cellRight11 = row.insertCell(17);
	  var e9 = document.createElement('input');
	  e9.type = 'button';
	  e9.className = 'buttonDel';
	  e9.name='remarks'+iteration;
	  e9.setAttribute('onClick', 'removeRow("grnDetails","hdb",this);'); 
	  e9.setAttribute('tabindex','1');
	  cellRight11.appendChild(e9);

	 
	  
	   //added - fayaz
	//  var cellRight9 = row.insertCell(9);
 //   var e9 = document.createElement('input');
//     e9.id = 'a'
//     e9.type = 'checkbox';
//    cellRight9.appendChild(e9);


	  

	}






function isNumberKey(evt)
{
var charCode = (evt.which) ? evt.which : event.keyCode
if (charCode > 31 && (charCode < 46 || charCode > 57))
return false;

return true;
}
function checkDate(inc){
	var date=document.getElementById("currdate").value;
	//alert("date>>>>>>>>>>>>>>>>>>"+date);
	var manuDate=document.getElementById("manufacturingDate"+inc).value;
	//alert("manuDate>>>>>>>>>>>>>>>>>>"+manuDate);
	if(manuDate >date )
	{
		alert ("Please enter valid DOM.")
		document.getElementById("manufacturingDate"+inc).value = '';
		return false;
	}
		
	}

function checkWarantyDate(inc){
	var WarrantyDate=document.getElementById("warrantyDate"+inc).value;
	//alert("date>>>>>>>>>>>>>>>>>>"+WarrantyDate);
	var WarrantyEndDate=document.getElementById("WarrantyEndDate"+inc).value;
	//alert("manuDate>>>>>>>>>>>>>>>>>>"+manuDate);
	if(WarrantyDate >WarrantyEndDate )
	{
		alert ("Warranty End Date should be greater than Warranty Start Date.")
		document.getElementById("WarrantyEndDate"+inc).value = '';
		return false;
	}
		
	}

function checkAmc(inc){
	
	var WarrantyEndDate=document.getElementById("WarrantyEndDate"+inc).value;
	//alert("manuDate>>>>>>>>>>>>>>>>>>"+manuDate);
	var amcDate=document.getElementById("amcStartDate"+inc).value;
	//alert("date>>>>>>>>>>>>>>>>>>"+WarrantyDate);
	if(amcDate < WarrantyEndDate )
	{
		alert ("Amc Start Date should be greater than Warranty End Date.")
		document.getElementById("amcStartDate"+inc).value = '';
		return false;
	}
		
	}
</script>

