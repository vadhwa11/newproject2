<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
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
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
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


	function onChangeSourceOfSupply(sos)
	{
		alert("hello");
		alert("this is jsp proto"+sos);

		if (sos == "l")
		{
			document.getElementById("indentCombo").disabled = false;
		}
		else
		{
			document.getElementById("indentCombo").disabled = false;
		}
		submitProtoAjaxforSupplier('grnGrid','/hms/hms/stores?method=responseForList');	
	}
	

	</script>
 
	 
	 <script language="javascript">
	 function checkSos(sos){		
		 if(sos=="L"){
			 submitProtoAjaxforExel('grnGrid','/hms/hms/stores?method=responseExcelImp&sos='+sos);
			 }
		 }
	 function clearDiv(){
			 submitProtoAjaxforClearDiv('grnGrid','/hms/hms/stores?method=responseClearDiv');
		 }
	 </script>
<script language="javascript">

	function checkForGrn(val,a,inc)
	{
			//alert(document.getElementById('ratePerMdq'+inc).value);
			if (val=="")
			{
			document.getElementById('codeItem'+inc).value="";
			document.getElementById('idItem'+inc).value=0;
			document.getElementById('expiry'+inc).value="";
			document.getElementById('idAu'+inc).value="";
			document.getElementById('batchNo'+inc).value="";
		//	document.getElementById('lotNo'+inc).value="";
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

			document.getElementById('ratePerMdq'+inc).value=0;
			document.getElementById('unitRateVar'+inc).value=0;
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
		    var poId = document.getElementById('indentCombo').value;
		//    if (src=='l')
		    	ajaxFunctionForAutoCompleteInGrn('grnGrid','stores?method=fillItemsForGrn&requiredField=' + pvms + "&poId=" + poId , inc);
		  //  else
		      // ajaxFunctionForAutoCompleteInGrnGeneral('grnGrid','stores?method=fillItemsForGrn&requiredField=' + pvms + "&poId=" + poId , inc);

	}
	  function getsoitems(){
	  var so = document.getElementById('indentCombo').value;
	 // var loanIn = document.getElementById('loanInStatus').value;
	   	currPage=1;
		numOfRows=10;
		   if(so != 0 && so != ""){
		  	   var url="/hms/hms/stores?method=getSoItemDetails&currPage="+currPage+"&numOfRows=8&sos="+document.getElementById('sourceCombo').value+"&po_id="+so+"&pageType=add";
				newwindow=window.open(url,'name','top=0, left=5, height=675,width=1010,status=1');
			} else {
		 	 	alert("Please select SO No ..!!!");
		 	}
	 	
	  }
	  function getsoexcelitems(){
		  var file = document.getElementById('fileNameId').value;
		  alert(file);
		 // var loanIn = document.getElementById('loanInStatus').value;
		   	currPage=1;
			numOfRows=10;
			   if(file != 0 && file != ""){
			  	   var url="/hms/hms/stores?method=getSoExcelItemDetails&currPage="+currPage+"&numOfRows=8&file="+file+"&pageType=add";
				   newwindow=window.open(url,'name','top=0, left=5, height=675,width=1010,status=1');
				} else 
					{
			 	 	alert("Please select File ..!!!");
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
		   	 //  var sli  = item.getElementsByTagName("SLIStatus")[0];
		       //   document.getElementById('adjust').style.display = 'none';
		              document.getElementById('soItem').style.display = 'inline';
		         // document.getElementById('loanInStatus').value = "No";
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

		 document.getElementById('civDiv').style.display = 'inline';
	 }
	}

	function civgrid(unitId){

	  if(unitId !=""){
		 document.getElementById('civDiv').style.display = 'inline';
	  }

	}
	 </script>
	 
	 <script language="javascript">

	function jsImport()
	{

	if (document.getElementById('exlfileNameId').value == "")
	{
	alert('Pl. Select a .xml file to upload!.....');
	return;
	}
	var fname = document.getElementById('exlfileNameId').value;

	var ind1 = fname.lastIndexOf("\\");

	var filename = fname.substring(ind1+1);
	if(filename.lastIndexOf(".xls")==-1){
	alert("File Type is InCorrect choose Another");
	document.getElementById('fileNameId').value="";
	}else{
	document.attachPhoto.method="post";
	submitForm('attachPhoto','stores?method=showLPGrnForExlJsp&filename='+filename);
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
</script>



<%
		Map map= new HashMap();
		Map pre=new HashMap();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		int grnId=0;
		int poId=0;
		if(map.get("grnId")!=null){
			grnId=Integer.parseInt(""+map.get("grnId"));
		}
		if(map.get("Pre")!=null){
			pre=(Map) map.get("Pre");
		}
		if(map.get("poId")!=null){
			poId=Integer.parseInt(map.get("poId").toString());
		}
		
		System.out.print(pre.entrySet());

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
				}
				Object [][]obj=null;
				if(map.get("obj")!=null){
					obj=(Object[][])map.get("obj");
				}
				String SupplierNo=obj[3][1].toString();
				String SoDate=obj[3][4].toString();
				String BillNoAct="";
				String BillDate="";
				String BillAmt="";
				if(obj[3][7]!=null){
					BillNoAct=obj[3][7].toString();
				} 
				if(obj[4][1]!=null){
					BillDate=obj[4][1].toString();
				}
				if(obj[4][3]!=null){
					BillAmt=obj[4][3].toString();
				}
				System.out.println("this is supplier no"+SupplierNo);
				System.out.println("this is sodate"+SoDate);
				System.out.println("this is bill no"+BillNoAct);
				System.out.println("this is bill date"+BillDate);
				System.out.println("this is bill amt"+BillAmt);
				String max="";
				if(SupplierNo!=null){
					
					
				}
				if(map.get("max") != null){
					max = (String) map.get("max");
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
				int supplierId=0;
				if(map.get("supplierId")!=null){
					supplierId=Integer.parseInt(map.get("supplierId").toString());
				}
				
				System.out.println("this is on jsp supplier"+supplierId);

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
<%
if(map.get("messageTOBeVisibleToTheUser") != null){
	   String message = (String)map.get("messageTOBeVisibleToTheUser");
	    	   %>
<h4><%=message %></h4>
<% 
	  }

%>
<div class="titleBg">
<h2>CRV</h2>
</div>
<form name="createGrn" method="post" action=""enctype="multipart/form-data">
<div class="clear"></div>
<div class="search" id="threadsearch"><a href=""></a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div>
</form>

<!-- thread search menu -->
<!--<div class="searchBlock" id="threadsearch_menu" style="display: none">
<form name="searchPanel" method="post">
<div class="clear"></div>

<label>From Date</label> <input type="text" name="<%= FROM_DATE %>"
	class="date" maxlength="30" tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.createGrn.<%=FROM_DATE%>,event)" />

<label>To Date</label> <input type="text" name="<%= TO_DATE %>"
	class="date" maxlength="30" tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.createGrn.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<label>&nbsp;</label> <input type="hidden" name="<%=GRN_NO%>" value=""
	tabindex=1 MAXLENGTH="100" id="<%=GRN_NO%>" />
<div id="ac3update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=GRN_NO%>','ac3update','stores?method=getGrnNoListForAutoComplete',{parameters:'requiredField=<%=GRN_NO%>'});
			</script> <input name="button" type="button" class="button"
	onclick="submitForm('createGrn','stores?method=searchGrn');" value=" " />

</form>
</div>
--><div class="clear"></div>
<div class="Block">
<form name="attachPhoto" method="post" action="" enctype="multipart/form-data">
<label>Import Excel File</label>
<input type="file" name="<%=UPLOAD_FILENAME %>" id="exlfileNameId"  style="height: 28px; margin-right: 75PX " class="browse">
<input name="Submit13" type="button" class="button" value="IMPORT" onClick="jsImport();"/>
</form>
</div>
<div class="clear"></div>
<form name="grnGrid" method="post">
<input type="hidden"
	name="pageNo" value="<%=pageNo%>" id="pageNo" /> <input type="hidden"
	name="deptId" value="<%=deptId%>" /> <input type="hidden"
	name="hospitalId" size="5" value="<%=hospitalId%>">

<div class="Clear"></div>
<h4>CRV Details</h4>
<div class="Clear"></div>
<div class="Block"><label> <span>*</span>Source Of Supply</label>
<label class="value">Local Purchase</label>
<input type="hidden" name="<%=SOURCE_OF_SUPPLY%>" id="sourceCombo"	tabindex=1  validate='Dispensery Name,num,Yes' value="L">

<!--<div class="Block"><label> <span>*</span>Source of Supply</label>
<select name="<%=SOURCE_OF_SUPPLY%>" id="sourceCombo" tabindex=1
 onclick="clearDiv();"	onchange="onChangeSourceOfSupply(this.value);checkSos(this.value);"
	validate="Source of Supply,String,yes">
	<option value="0">Select</option>
	<option value="A">AFMSD</option>
	<option value="L">Local Purchase</option>
	<option value="P">Other Unit</option>
	<option value="G">Other Gov. Source</option>
	 -
	<option value="o">Other Units</option>
	<option value="i">AFMSD Without Indent</option>
	<option value="w">CRV without LPO</option> 
</select>
 --><label>
  <span>*</span> CRV No.</label> <% if(storeGrnObj != null){%> <input
	type="text" name="<%= GRN_NO %>" value="<%=storeGrnObj.getGrnNo()%>"
	readonly="readonly" tabindex=1 id="grnNo" /> <%}else{ %> <input
	id="grnNo" type="text" name="<%=GRN_NO %>" value="<%=max %>"
	readonly="readonly" tabindex=1 /> <%} %> <label><span>*</span>
CRV Date</label> <input type="text" class="date" name="<%=GRN_DATE%>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" tabindex=1
	id="grnDate" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.grnGrid.<%=GRN_DATE%>,event)" />

<input type="hidden" class="button" name="<%=BOO_ENTRY %>"
	value="BOO Entry"
	onclick="submitFormForButton('grnGrid','stores?method=showBooJsp');" />


<div class="clear"></div>

<!--<div id=suppDiv><label>Vendor Name</label> <select
	name="<%= SUPPLIER_ID%>" id="supplierCombo" tabindex=1>
</select>
</div>

-->

<label>Proforma B No.<span>*</span></label>
<select name="proformaNo" id="indentCombo" tabindex=1  onchange="submitForm('grnGrid','stores?method=showLPGrnForProformaJsp');">
<option value="">Select</option>
	
</select> 
<label>Proforma B Date<span>*</span></label>
<input type="text" name="proformaDate" value="">

<label>Vendor</label>
<select	name="<%=RequestConstants.SUPPLIER_ID %>" id="supplierCombo"	  tabindex=1>
	<option value="">Select</option>	
</select>

<label>Vendor<span>*</span></label>
<select	name="<%=RequestConstants.SUPPLIER_ID %>" id="supplierCombo"	validate="Vendor Name, String ,yes" onchange="submitProtoAjaxforIndent('grnGrid','/hms/hms/stores?method=responseIndentList');" tabindex=1>
	<option value="">Select</option>
	<%for (MasStoreSupplier masStoreSupplier1 : supplierList)
	  	   {
	  	   if(masStoreSupplier1.getId ()==supplierId){%>
	 <option value="<%=masStoreSupplier1.getId ()%>" selected="selected"><%=masStoreSupplier1.getSupplierName()%></option>
	  	   <%}else{%>
	<option value="<%=masStoreSupplier1.getId ()%>"><%=masStoreSupplier1.getSupplierName()%></option>
	<%}
	  	   }%>
</select> 


<div id=indentDiv><label><span>*</span>SO No.</label> <select
	name="<%=INDENT_ID %>" id="indentCombo" tabindex=1>
	<option value="<%=poId%>"><%=SupplierNo%></option>
</select> <!-- - 
<label>AT/SO No.</label> <% if(storeGrnObj != null){%> 
<input	id="test" type="text" name="<%=SUPPLY_ORDER_NO %>"	value="<%=storeGrnObj.getAtSoNo() %>" 
	MAXLENGTH="75" style="width: 350px;" tabindex=1/> 
<%}else{ %> <input id="test" type="text" name="<%=SUPPLY_ORDER_NO %>" value="" MAXLENGTH="75" tabindex=1>
<%} %>
<div id="atsoDateDiv"><label>AT/SO Date</label>
<input id="dateTest" type="text" name="<%=AT_SO_DATE%>" id="atSoDate"
	value="<%=currentDate %>"MAXLENGTH="30"
	readonly="readonly" tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.grnGrid.<%=AT_SO_DATE%>,event)" />-->
</div>
<!--<div class="clear"></div>
<div class="division"></div>
<div>
	<label>Import Excel File</label>
	<input type="file" name="upload_filename" id="fileNameId" style="height: 28px; margin-right: 75PX " value="multiPartFileSingle"/>
	<input type="button" name="sss" align="right" class="button" value="IMPORT" onclick="getsoexcelitems();" />
</div>




<div class="division"></div>


-->
<label>Date Received</label> <input type="text" class="date" name="<%=RECEIVED_DATE%>" value="<%=currentDate %>"
	MAXLENGTH="30" readonly tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	class="calender" validate="Pick a date" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.grnGrid.<%=RECEIVED_DATE%>,event)" />
<label>Invoice No.</label> <%if(storeGrnObj != null){ %> <input
	type="text" name="<%=INVOICE_NO %>" id="<%=INVOICE_NO%>"
	value="<%=storeGrnObj.getInvoiceNo()%>"
	validate="Invoice No, String, no" maxlength="30" tabindex=1 /> <%}else{ %>
<input type="text" name="<%=INVOICE_NO %>" id="<%=INVOICE_NO%>" value="<%=BillNoAct%>"
	validate="Invoice No,String,no" MAXLENGTH="30" tabindex=1 /> <%} %> <label>Invoice
Date</label> <input type="text" class="date" name="<%=INVOICE_DATE%>" readonly
	id="invoiceDate" value="<%=BillDate %>" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.grnGrid.<%=INVOICE_DATE%>,event)" />
<!--<label>How Received </label>
<% if(storeGrnObj != null){%> 
<input type="text" name="<%=HOW_RECEIVED %>" value="<%=storeGrnObj.getHowReceived()%>" MAXLENGTH="50" tabindex=1 />
<%}else{ %>
<input	type="text" name="<%=HOW_RECEIVED %>" value=""	MAXLENGTH="50" tabindex=1 /> <%} %>
	
<label>R/R No </label> 
<% if(storeGrnObj != null){%> 
<input type="text" name="<%=RR_NO %>" value="<%=storeGrnObj.getRrNo() %>" MAXLENGTH="30" tabindex=1 /> 
<%}else{%> 
<input type="text" name="<%=RR_NO %>" value="" MAXLENGTH="30" tabindex=1 />
 <%}%> 
 -->
<div class="clear"></div>
<!-- -
<label><span>*</span> Mode Of Conv</label> 
<select name="<%=MODE_OF_CONVEYANCE%>"	validate="Mode Of Conveyance,string,yes" tabindex=1>
	<option value="0">Select</option>
	<option value="1">Air</option>
	<option value="2">Bus</option>
	<option value="3">Train</option>
	<option value="4">By Hand</option>
</select> --> <label>Unpack-Checked By<span>*</span></label> 
<select
	name="<%= EMPLOYEE_ID %>" validate="Unpack-Checked By, String ,yes" tabindex=1>
	<option value="">Select</option>
	<% 	
	String firstName="";
	String lastName="";
	for (MasEmployee masEmployee : employeeList) {	
	if(masEmployee.getLastName() != null){
		lastName=masEmployee.getLastName();
	}%>
	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()+" "+lastName %></option>
	<% } %>
</select>


<div class="clear"></div>
<!--<label>Remarks</label>
<%if(storeGrnObj != null){ %>
<textarea value="<%=storeGrnObj.getRemarks()%>" name="<%=REMARKS %>" validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="250" tabindex=1></textarea>
 <%}else{ %>
<textarea value="" name="<%=REMARKS %>" validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
  maxlength="250"></textarea> <%} %>
  

	 -->
<div class="clear"></div>
</div>
<div class="clear"></div>
<h4>CRV</h4>
<!-- -
  <br />
<div id=civDiv style="display: none;"><label>CIV
No</label> <input type="text" name="civNo" id="civNo" value=""
	validate="civ No, String, no"  MAXLENGTH="30"
	tabindex=1 /> <label>CIV Date</label> <input
	type="text" name="civDate" id="civDate" value="" readonly
	 tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('',document.grnGrid.civDate,event)" /> <br />
</div>
 <br />

<label>Freight Duty</label> <%if(storeGrnObj != null){ %>
<input type="text" name="<%=FREIGHT_DUTY %>"
	value="<%=storeGrnObj.getFreightDuty()%>" id="<%=FREIGHT_DUTY %>"
	validate="Freight Duty,float,no"  MAXLENGTH="15"
	onblur="freight();" tabindex=1 /> <%}else{ %> <input type="text"
	name="<%=FREIGHT_DUTY %>" id="<%=FREIGHT_DUTY %>" value=""
	validate="Freight Duty,float,no"  MAXLENGTH="15"
	onblur="calculationInCRV();" tabindex=1 /> <%} %> <label
	>Excise Duty</label> <%if(storeGrnObj != null){ %> <input
	type="text" name="<%=EXCISE_DUTY %>"
	value="<%=storeGrnObj.getExciseDuty()%>" id="<%=EXCISE_DUTY %>"
	validate="Excise Duty,float,no"  MAXLENGTH="15"
	onblur="excise();" tabindex=1 /> <%}else{ %> <input type="text"
	name="<%=EXCISE_DUTY %>" id="<%=EXCISE_DUTY %>" value=""
	 validate="Excise Duty,float,no" MAXLENGTH="15"
	onblur="calculationInCRV();" tabindex=1 /> <%} %> <label
	>Octroi</label> <%if(storeGrnObj != null){ %> <input
	type="text" name="<%=OCTROI %>" value="<%=storeGrnObj.getOctroi()%>"
	id="<%=OCTROI %>" validate="Octroi,float,no" 
	MAXLENGTH="15" onblur="octroi();" tabindex=1 /> <%}else{ %> <input
	type="text" name="<%=OCTROI %>" id="<%=OCTROI %>" value=""
	 validate="Octroi,float,no" MAXLENGTH="15"
	onblur="calculationInCRV();" tabindex=1 /> <%} %> <br />

<label>Insurance Charge</label> <%if(storeGrnObj != null){ %>
<input type="text" name="<%=INSURANCE_CHARGES %>"
	value="<%=storeGrnObj.getInsuranceCharge()%>"
	id="<%=INSURANCE_CHARGES %>" validate="Insurance Charges,float,no"
	 MAXLENGTH="15" onblur="insurance();" tabindex=1 />
<%}else{ %> <input type="text" name="<%=INSURANCE_CHARGES %>"
	id="<%=INSURANCE_CHARGES %>" value="" 
	validate="Insurance Charges,float,no" MAXLENGTH="15"
	onblur="calculationInCRV();" tabindex=1 /> <%} %> <label
	>Other Charges</label> <%if(storeGrnObj != null){ %> <input
	type="text" name="<%=OTHER_CHARGES %>"
	value="<%=storeGrnObj.getOtherCharges()%>" id="<%=OTHER_CHARGES %>"
	validate="Other Charges,float,no"  MAXLENGTH="15"
	onblur="otherCharges();" tabindex=1 /> <%}else{ %> <input type="text"
	name="<%=OTHER_CHARGES %>" id="<%=OTHER_CHARGES %>" value=""
	 validate="Other Charges,float,no" MAXLENGTH="15"
	onblur="calculationInCRV();" tabindex=1 /> <%} %> <label
	>Custom Duty</label> <%if(storeGrnObj != null){ %> <input
	type="text" name="<%=CUSTOM_DUTY %>"
	value="<%=storeGrnObj.getCustomDuty()%>" id="<%=CUSTOM_DUTY %>"
	validate="Custom Duty,float,no"  MAXLENGTH="15"
	onblur="custom();" tabindex=1 /> <%}else{ %> <input type="text"
	name="<%=CUSTOM_DUTY %>" id="<%=CUSTOM_DUTY %>" value=""
	 validate="Custom Duty,float,no" MAXLENGTH="15"
	onblur="calculationInCRV();" tabindex=1 /> <%} %> <br />
	
	 -->
<div class="clear"></div>
<div class="cmntableWithHeight">
<table >
	<thead>
		<tr>
			<th>SR No.</th>
			<th width="8%">PVMS/NIV	No</td>
			<th width="9%">Nomenclature</th>
			<th width="9%">BarCode No.</th>
			<th width="9%">B/G</th>
			<th width="9%">Brand Name</th>
			<th width="9%">Company Name</th>
			<th width="9%">A/U</th>
			<th width="9%">Batch No</th>
			<th width="9%" colspan="2">Manuf.Date</th>	 
			<th width="9%" colspan="2">Expiry Date</th>
			<th width="9%">Quan Recd(QR)</label></td>
			<th width="9%">Dispen.Type</th>
			<th width="9%">Packaging </th>
			<th width="9%">Rate Per MDQ</th>
			<th width="9%">Disc(%)</th>
			<th width="9%">Tax(%)</th>
			<th width="9%">Cost</th>
			<th style="width: 15px;">
			<input type="checkbox" name="checkAll" id="chk_all" value="" onclick="addAll()">
			ADD ALL
			</th>
		 </tr>
	</thead>
	<tbody>
		<%String idItem="idItem";
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
		String barCodeId="barCodeId";
		String mrp="mrp";
		String bg="bg";
		
		int inc = 0;
			   // gridData = (HashMap[])pagedArray.getPagedArray();
				//int iFirstRow = pagedArray.getFirstRowIdx();
			if(obj!=null)
				{
				for(int i=7;i<obj.length;i++){
					inc = inc + 1;
			%>
		 <tr>
			<td width="10%"><input type="text" value="<%=obj[i][0]%>" class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>
			<%
				String item[]=obj[i][1].toString().split("_");
			    String brand[]=obj[i][5].toString().split("_");
			    String manu[]=obj[i][6].toString().split("_");
			    String actBrand[]=brand[0].split(":");
			%>
			<td width="10%">
			<input type="hidden" value="<%=item[0]%>" class="medcaption" id="<%=idItem+""+inc%>" name="<%=ITEM_ID%>" readonly="readonly" />
			<input type="text" value="<%=item[1]%>" class="medcaption" id="<%=codeItem+""+inc%>"  name="<%=ITEM_CODE %>" readonly="readonly" /></td>
			<td width="55%"><input type="text" value='<%=obj[i][2]%>' class="bigcaption" id="<%=nameItem+""+inc%>" name="<%=nameItem%>"   readonly="readonly" /></td>
			<td width="25%"><input type="text" value="" id=""<%=barCodeId+""+inc%>" name="barCodeNo"  class="medcaption" /></td>
			
			<td width="25%"><input type="text" value="<%=obj[i][4]%>" name="<%=BG%>"  id="<%=bg+""+inc%>" name="<%=BRAND_ID%>"  class="medcaption"readonly="readonly" /></td>
			
			<td width="25%">
			<%if(actBrand.length>1){%>
			<input type="text" value="<%=actBrand[1]%>" id="" name="<%=BRAND%>"  class="medcaption"readonly="readonly" />
			<%}else{%>
			<input type="text" value="" id="" name="<%=BRAND%>"  class="medcaption"readonly="readonly" />
			<%}%>
			<%if(brand.length>1){%>
			<input type="hidden" value="<%=brand[1]%>" id="<%=brandId+""+inc%>" name="<%=BRAND_ID%>"  class="medcaption"readonly="readonly" />
			<%}else{%>
			<input type="hidden" value="" id="<%=brandId+""+inc%>" name="<%=BRAND_ID%>"  class="medcaption"readonly="readonly" />
			<%}%>
			</td>
			<td width="25%">
				<%if(manu[0].equals("na")||manu.length<1){%>
				<input type="text" value="" id="" name="<%=MANUFACTURER_NAME%>" class="medcaption"readonly="readonly" />
				<%}else{%>
				<input type="text" value="<%=manu[0]%>" id="" name="<%=MANUFACTURER_NAME%>" class="medcaption"readonly="readonly" />
				<%}%>
				<%if(manu.length>1){%>
				<input type="hidden" value="<%=manu[1]%>" id=<%=manufacturerId+""+inc%> name="<%=MANUFACTURER_ID %>" class="medcaption"readonly="readonly" />
				<%}else{%>	
				<input type="hidden" value="" id=<%=manufacturerId+""+inc%> name="<%=MANUFACTURER_ID %>" class="medcaption"readonly="readonly" />
				<%}%>		
			</td>
			<td width="25%"><input type="text" value="<%=obj[i][3]%>" id="<%=idAu+""+inc%>" name="<%=AV%>" class="medcaption"readonly="readonly" /></td>
			<td width="25%"><input type="text" value="<%=obj[i][11]%>" id="<%=batchNo+""+inc%>" name="<%=BATCH_NO %>"  class="medcaption"readonly="readonly" /></td>
			<td width="25%"><input type="text" value="<%=obj[i][12]%>" id="<%=manufacturingDate+""+inc%>" name="<%=MANUFACTURING_DATE%>" class="medcaption"readonly="readonly" /></td>
			<td width="0%"><input type="hidden" value="<%=obj[i][12]%>"  class="medcaption"readonly="readonly" /></td>
			<td width="25%"><input type="text" value="<%=obj[i][14]%>" id="<%=expiryDate+""+inc %>" name="<%=EXPIRY_DATE%>"  class="medcaption"readonly="readonly" /></td>
			<td width="0%"><input type="hidden" value="<%=obj[i][14]%>" name="<%=AU%>" class="medcaption"readonly="readonly" /></td>
			<td width="25%"><input type="text" value="<%=obj[i][10]%>" name="<%=QUANTITY_RECEIVED %>" size="8" tabindex="1" id="<%=quanRec+""+inc%>"	onblur="calculationInCRV();" tabindex="1" class="medcaption"readonly="readonly" class="medcaption" /></td>
			<td width="25%"><input type="text" value="<%=obj[i][8]%>" name="dispenseType" id=<%=dispenseType+""+inc%> class="medcaption"readonly="readonly" /></td>
			<td width="25%"><input type="text" value="<%=obj[i][9]%>" name="mdq" id="<%=mdq+""+inc%>" tabindex="1" class="medcaption"readonly="readonly" /></td>
			<td width="25%"><input type="text" value="<%=obj[i][16]%>" name="ratePerMdq" size="8" id="<%=ratePerMdq+""+inc%>" tabindex="1" onblur="calculationInCRV();" tabindex="1" class="medcaption"readonly="readonly" /></td>
			<td width="25%"><input type="text" value="<%=obj[i][17]%>" name="<%=DISCOUNT_PERCENTAGE%>" size="5" tabindex="1"	id="<%=discountVar+""+inc%>" onblur="calculationInCRV();" class="medcaption"readonly="readonly" />
			<%
			double d=0.0;
			if(obj[i][17]!=null){
			double j=Double.parseDouble(obj[i][17].toString());
		    d=j;
			}
			%>
			<input type="hidden" value="<%=d%>" name="discountAmount"	id="<%=discountAmount+""+inc %>" tabindex="1"/></td>
			
			<td width="25%"><input type="text" value="<%=obj[i][18]%>" name="<%=TAX_PERCENT %>" tabindex="1" id="<%=taxVar+""+inc%>" onblur="calculationInCRV();"/></td>
			<td width="25%">
			<input type="hidden" value="0"	 name="<%= COST_PRICE %>" id="<%=costPrice+""+inc%>" tabindex="1"/>
			<input type="text"  value="<%=obj[i][19]%>"  name="<%=AMOUNT%>" size="8"	id="<%=amtVar+""+inc%>" readonly="readonly" tabindex="1" />
			<input type="hidden" name="loanInItem" value="Yes" id="loanInItem" />
			 	 <%if(pre.get(item[0]).toString().equals("na")){%>
			<input type="hidden" name="PreId" id="<%="PreId"+""+inc%>" value="0"/>
			<%}else{%>
		   <input type="hidden" name="PreId" id="<%="PreId"+""+inc%>" value="<%=pre.get(item[0]).toString()%>"/>
			<%}%></td>
			 <td><input type="checkbox" name="check_one" id="chk" value="" /></td>
			 
		
			 
		 </tr>
		<%}
}%>
	</tbody>
</table>
</div>
<div class="clear"></div>

<!-- -
<label>Total Cost</label>
<input type="text" id="total_cost" name="totalCost" value="" readonly="readonly" tabindex="1"/> -->
<label>Total Amount</label>
<%if(BillAmt!=null){%>
<input type="text" id="total_amount" name="actualGrnValue" value="<%=BillAmt%>" readonly="readonly" tabindex="1"/>
<%}else{%>
<input type="text" id="total_amount" name="actualGrnValue" value="" readonly="readonly" tabindex="1"/>
<%}%>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="sss" align="right" class="button"
	value="Save"
	onclick="if( checkSave()&& checkForSubmit() && checkInvoiceNo()){submitForm('grnGrid','stores?method=submitGrnwithprint');}" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<% for(UserButtonRights  userButtonRights : userRightsList){
				String buttonName=userButtonRights.getButton().getButtonName();
				if(userButtonRights.getButton().getFormName().equals("CRV Form")){
					String formulaUsed=userButtonRights.getButton().getFormulaUsed();
%> <!--<input type="button" name="no" class="button"
	value="<%=userButtonRights.getButton().getButtonName() %>"
	class="<%=userButtonRights.getButton().getClassName() %>"
	onclick="<%=userButtonRights.getButton().getUrl()%>" /> <%}} %> 
	
<!--<input type="button" name="sss" align="right" class="button" value="PVMS/NIV" onclick="openItemPopup();"/> -->
<!--<input type="button" name="sss" align="right" class="button" value="Vendor" onclick="openVendorPopup();"/> -->
<div class="clear"></div>

<input type="hidden" size="2" value="0" name="<%=NO_OF_ROWS %>"
	id="<%=NO_OF_ROWS %>" /> <input type="hidden" name="<%=GRN_ID %>"
	value="<%=grnId%>" id="hdb" />

<div id="gridDiv"></div>
<div class="clear"></div>

<input type="hidden" name="<%=TOTAL_AMOUNT %>" id="<%=TOTAL_AMOUNT%>"
	value=""></input> <input type="hidden" name="<%=CLOSING_STOCK %>"
	id="<%=CLOSING_STOCK%>" value="" />
<div class="clear"></div>

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	<input type="hidden" name="checkJsp" value="crvLocalPurchase"/>  
	<script type="text/javascript">
				<!--
					// Main vBulletin Javascript Initialization
					vBulletin_init();
				//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" /> <br />

</form>

<script>
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
</script>