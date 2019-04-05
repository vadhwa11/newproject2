
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
<%@page import="java.math.BigDecimal"%>
<%@page import="java.math.MathContext"%>
<%@page import="jkt.hms.util.RequestConstants"%>
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
	function getManufacturerNameByAjax(brandId,rowVal){
		
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
		    	  var manufacturerId ="manufacturerId"+rowVal;
		    	  obj1 = document.getElementById(manufacturerId); 
		  		obj1.length = 1;
		      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

		      	for (loop = 0; loop < items.childNodes.length; loop++) {
			   	    var item = items.childNodes[loop];
			        var manufacturerName  = item.getElementsByTagName("manufacturerName")[0];
			        var mId  = item.getElementsByTagName("mId")[0];
			 
			 
			 
			       obj1.options[obj1.length-1].value= mId.childNodes[0].nodeValue;
					obj1.options[obj1.length-1].text=manufacturerName.childNodes[0].nodeValue;
		        	//document.getElementById('manufacturerId'+rowVal).value =  manufacturerName.childNodes[0].nodeValue
		        	//document.getElementById('manufacturerIdTemp'+rowVal).value = mId.childNodes[0].nodeValue

		      	}
		      }
		    }
		     url="stores?method=getManufacturerNameInAjax&brandId="+brandId;
		    xmlHttp.open("GET",url,true);
		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(null);

		 }	</script>
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
		    	ajaxFunctionForAutoCompleteInGrn1('grnGrid','stores?method=fillItemsForGrn&requiredField=' + pvms + "&poId=" + poId , inc);
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
	function getSearchBlock()
	{

	document.getElementById('searchBlock').style.display = 'inline';
	}


	function checkit(){
		alert("check");}
	 </script>

<script language="javascript">
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
//			 var discount = isNaN(parseFloat(document.getElementById('discount'+i).value))==true?"0":parseFloat(document.getElementById('discount'+i).value);
//			 var tax = isNaN(parseFloat(document.getElementById('tax'+i).value))==true?"0":parseFloat(document.getElementById('tax'+i).value);

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
			// alert("grandTotal >"+grandTotal);
			 document.getElementById('total_amount').value = roundVal(grandTotal,2);
				}
}
</script>








<%
		String choice="";
		Map map= new HashMap();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<StoreIndentT> gridLoanInTList= new ArrayList<StoreIndentT>();
		List<MasStoreBrand> itemBrandList = new ArrayList<MasStoreBrand>();
		List<StoreIndentM> indentList1= new ArrayList<StoreIndentM>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		if(map.get("choice") != null){
			choice = (String)map.get("choice");
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
			//session.setAttribute("supplierList",supplierList);
		}/*else if(session.getAttribute("supplierList") != null){
			supplierList = (ArrayList)session.getAttribute("supplierList");
		}*/
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
				if(map.get("itemList") != null){
					itemList = (ArrayList) map.get("itemList");
					//session.setAttribute("itemList",itemList);
				}/*else if(session.getAttribute("itemList") != null){
					itemList = (ArrayList)session.getAttribute("itemList");
				}*/
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				if(map.get("employeeList") != null){
					employeeList = (ArrayList) map.get("employeeList");
					//session.setAttribute("employeeList",employeeList);
				}/*else if(session.getAttribute("employeeList") != null){
					employeeList = (ArrayList)session.getAttribute("employeeList");

				}*/
				List<StorePoHeader> poList = new ArrayList<StorePoHeader>();
				if(map.get("poList") != null){
					poList = (ArrayList) map.get("poList");
					//session.setAttribute("poList",poList);
				}/*else if(session.getAttribute("poList") != null){
					poList = (ArrayList)session.getAttribute("poList");

				}*/
				StoreGrnM storeGrnObj = null;
				List<StoreIndentM> indentList = new ArrayList<StoreIndentM>();
				if(map.get("indentList") != null){
					indentList = (ArrayList) map.get("indentList");
					//session.setAttribute("indentList",indentList);
				}/*else if(session.getAttribute("indentList") != null){
					indentList = (ArrayList)session.getAttribute("indentList");
				}*/
				List<MasUnitOfMeasurement> uomList = new ArrayList<MasUnitOfMeasurement>();
				if(map.get("uomList") != null){
					uomList = (ArrayList) map.get("uomList");
					//session.setAttribute("uomList",uomList);
				}/*else if(session.getAttribute("uomList") != null){
					uomList = (ArrayList)session.getAttribute("uomList");
				}*/
				List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
				if(map.get("manufacturerList") != null){
					manufacturerList = (ArrayList) map.get("manufacturerList");
					//session.setAttribute("manufacturerList",manufacturerList);
				}/*else if(session.getAttribute("manufacturerList") != null){
					manufacturerList = (ArrayList)session.getAttribute("manufacturerList");
				}*/
				List<MasStoreAirForceDepot> unitList = new ArrayList<MasStoreAirForceDepot>();
				if(map.get("unitList") != null){
					unitList = (ArrayList) map.get("unitList");
					//session.setAttribute("unitList",unitList);
				}/*else if(session.getAttribute("unitList") != null){
					unitList = (ArrayList)session.getAttribute("unitList");
				}*/
				List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
				if(map.get("brandList") != null){
					brandList = (ArrayList) map.get("brandList");
					//session.setAttribute("brandList",brandList);
				}/*else if(session.getAttribute("brandList") != null){
					brandList = (ArrayList)session.getAttribute("brandList");
				}*/
				List<StoreSupplyOrderEntry> supplyOrderList = new ArrayList<StoreSupplyOrderEntry>();
				if(map.get("supplyOrderList") != null){
					supplyOrderList = (ArrayList) map.get("supplyOrderList");
					//session.setAttribute("supplyOrderList",supplyOrderList);
				}/*else if(session.getAttribute("supplyOrderList") != null){
					supplyOrderList = (ArrayList)session.getAttribute("supplyOrderList");

				}*/
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

				String max="";
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


				indentList=(List)map.get("second_combo");
				map = (Map)request.getAttribute("map");
				if (map.get("choice")!=null)

					choice = map.get("choice").toString();
				if (choice.equalsIgnoreCase("P"))
				{
					indentList=(List)map.get("second_combo");
				}


				if(map.get("manufacturerList") != null){
					manufacturerList  = (List<MasManufacturer>)map.get("manufacturerList");
				}

				if(map.get("brandList") != null){
					brandList  = (List<MasStoreBrand>)map.get("brandList");
				}



					indentList1=(List)map.get("second_combo");

					System.out.println("IndentList-------"+indentList1);

				includedJsp = (String) map.get("includedJsp");


				int indentId=0;
				int supplierId=0;
				int checkedById=0;
				String sourceOfSupply="";
				String grnDate="";
				String receivedDate="";
				String invoiceDate1="";
				String invoiceNo="";
				String flag="";

				System.out.println("indentId-------"+map.get("indentId"));
				System.out.println("supplierId-------"+map.get("supplierId"));
				System.out.println("checkedById-------"+map.get("checkedById"));


				if(map.get("indentId")!=null)
				{
					indentId=(Integer)map.get("indentId");
				}

				if(map.get("supplierId")!=null)
				{
					supplierId=(Integer)map.get("supplierId");
				}

				if(map.get("checkedById")!=null)
				{
					checkedById=(Integer)map.get("checkedById");
				}

				if(map.get("sourceOfSupply")!=null)
				{
					sourceOfSupply=(String)map.get("sourceOfSupply");
				}

				if(map.get("grnDate")!=null)
				{
					grnDate=(String)map.get("grnDate");
				}


				if(map.get("receivedDate")!=null)
				{
					receivedDate=(String)map.get("receivedDate");
				}

				if(map.get("invoiceDate")!=null)
				{
					invoiceDate1=(String)map.get("invoiceDate");
				}



				if(map.get("invoiceNo")!=null)
				{
					invoiceNo=(String)map.get("invoiceNo");
				}


				if(map.get("flag")!=null)
				{
					flag=(String)map.get("flag");
				}






		%>
<%
if(map.get("messageTOBeVisibleToTheUser") != null){
	   String message = (String)map.get("messageTOBeVisibleToTheUser");
	    	   %>
<h4><%=message %></h4>
<%
	  }

%>
<%if(session.getAttribute("deptId").toString().equals("24")){ %>
<div class="titleBg">
<h2>CRV/RV ENTRY</h2>
</div>

<div id="searchBlock" style="display:none;">
<form name="createGrn" method="post" >
<div class="clear"></div>
<h6>SEARCH</h6>
<div class="Block">
<form name="" method="">
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" />
<input type="hidden" name="do" value="process" />
<input type="hidden" name="searchthread" value="1" />
<input type="hidden" name="showposts" value="1" />
<input type="hidden" name="searchthreadid" value="85875" />
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
<label>CRV/RV No.</label> <input type="hidden" name="<%=GRN_NO%>" value=""
	tabindex=1 MAXLENGTH="100" id="<%=GRN_NO%>" />
<div id="ac3update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=GRN_NO%>','ac3update','stores?method=getGrnNoListForAutoComplete',{parameters:'requiredField=<%=GRN_NO%>'});
			</script>

<input type="text" name="supplyType"  id="supplyType" value="a">
<input name="button" type="button" class="button" onclick="submitForm('createGrn','stores?method=searchGrn');" value="SEARCH" />
<input name="button" type="button" class="button" onclick="closeSearchBlock();" value="CLOSE" />
</form>
</div>
</form>
</div>



<form name="grnForm" method="post">
<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" /> <input type="hidden"
	name="deptId" value="<%=deptId%>" /> <input type="hidden"
	name="hospitalId" size="5" value="<%=hospitalId%>">





<div class="Clear"></div>
<h4>CRV/RV Details</h4>
<div class="Clear"></div>
<div class="Block">


<label> Source<span>*</span></label>
<%if(flag.equalsIgnoreCase("true")){ %>
<label class="value">AFMSD</label>
<input type="hidden" name="<%=SOURCE_OF_SUPPLY%>" id="sourceCombo"	tabindex=1  validate='Dispensery Name,num,Yes' value="a">

<!--<select name="<%=SOURCE_OF_SUPPLY%>" id="sourceCombo" tabindex=1
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

-->
<label> CRV/RV No.<span>*</span></label> <% if(storeGrnObj != null){%> <input
	type="text" name="<%= GRN_NO %>" value="<%=storeGrnObj.getGrnNo()%>"
	readonly="readonly" tabindex=1 id="grnNo" /> <%}else{ %> <input
	id="grnNo" type="text" name="<%=GRN_NO %>" value="<%=max %>"
	 onblur="checkGrnNo(this.value);" validate="CRV/RV No.,string,yes" title="i.e. 10/12-13 or 111/12-13" tabindex=1 /> <%} %>


	<label>CRV/RV Date<span>*</span></label>
	 <input type="text" class="date" name="<%=GRN_DATE%>"	value="<%=grnDate %>" readonly="readonly" MAXLENGTH="30" tabindex=1
	id="grnDate" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.grnGrid.<%=GRN_DATE%>,event)" />

<input type="hidden" class="button" name="<%=BOO_ENTRY %>"
	value="BOO Entry"
	onclick="submitFormForButton('grnGrid','stores?method=showBooJsp');" />


<div class="clear"></div>



<!--<div id=suppDiv>
<label>Vendor Name</label>
<select name="<%= SUPPLIER_ID%>" id="supplierCombo" tabindex=1>
</select>
</div>
-->
<label>Depot Name</label>
<select name="<%=RequestConstants.SUPPLIER_ID %>"	id="supplierCombo" validate="Unit Name, String ,yes" onchange="submitProtoAjaxforIndentAMFSD('grnForm','/hms/hms/stores?method=responseIndentList');"
	tabindex=1>
	<option value="">Select</option>
	<% for (MasStoreAirForceDepot unit : unitList)
	  	   {
		if(supplierId!=0)
		{
			if(supplierId==unit.getId())
			{

		%>
	<option value="<%=unit.getId ()%>" selected="selected"><%=unit.getAirForceDepotName()%></option>
	<% }else{ %>

	<option value="<%=unit.getId ()%>" ><%=unit.getAirForceDepotName()%></option>
	<%}}} %>
</select>

<div id=indentDiv>
<label>SO/Indent No.<span>*</span></label>
<select name="<%=RequestConstants.INDENT_ID %>" id="indentCombo" onchange="submitForm('grnForm','stores?method=showGrnJspForAFMSD');" tabindex=1>
	<option value="0">Select</option>
	<% for (StoreIndentM storeIndent1 : indentList1)  {


		if(indentId!=0)
		{
			if(indentId==storeIndent1.getId())
			{
		%>
				<option value="<%=storeIndent1.getId ()%>" selected="selected"><%=storeIndent1.getIndentNo()%></option>
		<% }else{ %>


	<option value="<%=storeIndent1.getId()%>"><%=storeIndent1.getIndentNo()%></option>
	<%}}}%>
</select>
</div>
 <!-- -
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

<div id="exelImp"></div>

<label>Date Received</label>
<input type="text" class="date" name="<%=RECEIVED_DATE%>" value="<%=receivedDate %>"
	MAXLENGTH="30" readonly tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	class="calender" validate="Pick a date" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.grnGrid.<%=RECEIVED_DATE%>,event)" />
<!--  <label>Invoice No.</label>-->
 <%if(storeGrnObj != null){ %> <input
	type="hidden" name="<%=INVOICE_NO %>" id="<%=INVOICE_NO%>" value="<%=invoiceNo%>"
	validate="Invoice No, String, no" maxlength="30" tabindex=1 />
	 <%}else{ %>
<input type="hidden" name="<%=INVOICE_NO %>" id="<%=INVOICE_NO%>" value=""
	validate="Invoice No,String,no" MAXLENGTH="30" tabindex=1 /> <%} %> 
	<!--  <label>Invoice Date</label> -->
<input type="hidden" class="date" name="<%=INVOICE_DATE%>" readonly
	id="invoiceDate" value="<%=invoiceDate1 %>" maxlength="30" tabindex=1 />
<%-- <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.grnGrid.<%=INVOICE_DATE%>,event)" />--%>

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
<%-- 
<label><span>*</span> Mode Of Conv</label>
<select name="<%=MODE_OF_CONVEYANCE%>"	validate="Mode Of Conveyance,string,yes" tabindex=1>
	<option value="0">Select</option>
	<option value="1">Air</option>
	<option value="2">Bus</option>
	<option value="3">Train</option>
	<option value="4">By Hand</option>
</select> --%>
<div class="clear"></div>
<label> Unpacked-Checked By<span>*</span></label>
<select
	name="<%= EMPLOYEE_ID %>"    id="empId" tabindex=1>
	<option value="">Select</option>
	<%
	String firstName="";
	String lastName="";
	for (MasEmployee masEmployee : employeeList) {

	if(masEmployee.getLastName() != null){
		lastName=masEmployee.getLastName();
	}
	if(checkedById==masEmployee.getId())
	{

	%>
	<option value="<%=masEmployee.getId()%>" selected="selected"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+lastName %></option>
	<%}else{

	 %>
	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+lastName %></option>
<%}} %>

</select>

	 <%}else{ %>
	 <label class="value">AFMSD</label>
<input type="hidden" name="<%=SOURCE_OF_SUPPLY%>" id="sourceCombo"	tabindex=1  validate='Dispensery Name,num,Yes' value="a">

<!--<select name="<%=SOURCE_OF_SUPPLY%>" id="sourceCombo" tabindex=1
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

-->
<label>  CRV No.<span>*</span></label> <% if(storeGrnObj != null){%> <input
	type="text" name="<%= GRN_NO %>" value="<%=storeGrnObj.getGrnNo()%>"
	readonly="readonly" tabindex=1 id="grnNo" /> <%}else{ %> <input
	id="grnNo" type="text" name="<%=GRN_NO %>" value="<%=max %>"
	readonly="readonly" tabindex=1 /> <%} %>


	<label>
CRV Date<span>*</span></label> <input type="text" class="date" name="<%=GRN_DATE%>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" tabindex=1
	id="grnDate" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.grnGrid.<%=GRN_DATE%>,event)" />

<input type="hidden" class="button" name="<%=BOO_ENTRY %>"
	value="BOO Entry"
	onclick="submitFormForButton('grnGrid','stores?method=showBooJsp');" />


<div class="clear"></div>



<!--<div id=suppDiv>
<label>Vendor Name</label>
<select name="<%= SUPPLIER_ID%>" id="supplierCombo" tabindex=1>
</select>
</div>
-->
<label>Depot Name</label>
<select name="<%=RequestConstants.SUPPLIER_ID %>"	id="supplierCombo" validate="Unit Name, String ,yes" onchange="submitProtoAjaxforIndentAMFSD('grnForm','/hms/hms/stores?method=responseIndentList');"
	tabindex=1>
	<option value="">Select</option>
	<% for (MasStoreAirForceDepot unit : unitList)
	  	   {   %>
	<option value="<%=unit.getId ()%>"><%=unit.getAirForceDepotName()%></option>
	<% } %>
</select>

<div id=indentDiv>
<label>Indent No.</label>
<select name="<%=RequestConstants.INDENT_ID %>" id="indentCombo" onchange="submitProtoAjaxforGrid('grnForm','/hms/hms/stores?method=responseGridList');" tabindex=1>
	<option value="0">Select</option>
	<% for (StoreIndentM storeIndent1 : indentList1)  {   %>
	<option value="<%=storeIndent1.getId()%>"><%=storeIndent1.getIndentNo()%></option>
	<%}%>
</select>
</div>
 <!-- -
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
<div class="clear"></div>
<div id="exelImp"></div>
<div class="clear"></div>
<label>Date Received</label>
<input type="text" class="date" name="<%=RECEIVED_DATE%>" value="<%=currentDate %>"
	MAXLENGTH="30" readonly tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	class="calender" validate="Pick a date" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.grnGrid.<%=RECEIVED_DATE%>,event)" />
<label>Invoice No.</label> <%if(storeGrnObj != null){ %> <input
	type="text" name="<%=INVOICE_NO %>" id="<%=INVOICE_NO%>"
	value="<%=storeGrnObj.getInvoiceNo()%>"
	validate="Invoice No, String, no" maxlength="30" tabindex=1 /> <%}else{ %>
<input type="text" name="<%=INVOICE_NO %>" id="<%=INVOICE_NO%>" value=""
	validate="Invoice No,String,no" MAXLENGTH="30" tabindex=1 /> <%} %> <label>Invoice
Date</label> <input type="text" class="date" name="<%=INVOICE_DATE%>" readonly
	id="invoiceDate" value="<%=currentDate %>" maxlength="30" tabindex=1 />
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
</select> -->
 <label> Unpacked-Checked By</label> <select
	name="<%= EMPLOYEE_ID %>" validate="Unpacked-Chk By,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
	String firstName="";
	String lastName="";
	for (MasEmployee masEmployee : employeeList) {
	if(masEmployee.getLastName() != null){
		lastName=masEmployee.getLastName();
	}%>
		<option value="<%=masEmployee.getId()%>"><%=masEmployee.getRank().getRankName()+" "+masEmployee.getFirstName()+" "+lastName+"("+masEmployee.getRank().getRankName()+")" %></option>
	<% } %>
</select>



	 <%} %>

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

<div class="clear"></div>
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

<%

float Tot=0.0f;
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
String barCodeId="barCodeId";
String mrp="mrp";
String reasonForDemand="reasonForDemand";
String manufacturerIdTemp="manufacturerIdTemp";
%>

<h4>CRV</h4>
<div class="Clear"></div>
<div style="height:350px; width:1000px; overflow-x:  scroll; overflow-y: scroll ;">
<table width="98%" colspan="7" id="grnDetails" 	border="0" cellpadding="0" cellspacing="0">
		<tr>
			<th>Sl No.</th>
			<th width="8%">PVMS/NIV	No.</td>
			<th width="9%">Nomenclature</th>
				<th width="9%">A/U</th>
			<th width="9%">Barcode</th>
			<th width="9%">B/G</th>
			<th width="9%">Brand Name</th>
			<th width="9%">Manufacturer </th>

			<th width="9%">Batch No.</th>
			<th width="9%" colspan="2">DOM</th>
			<th width="9%" colspan="2">DOE</th>

			<th width="9%">Qty Received</label></th>
			<th width="9%">Dispense Type</th>
		    <th width="9%">Packaging</th>
			<th>MRP per Pack </th>
			<th width="9%">MRP per A/U</th>
			<th width="9%">Disc(%)</th>
			<th width="9%">Tax(%)</th>
			<th width="9%">Cost</th>
			<th width="9%">Amount</th>
			<th width="9%">Reason for Demand</th>
			<th scope="col">Add </th>
			<th scope="col">Delete </th>
		</tr>
		<%

 		int noOfRows = 0;

	    if (map.get("gridLoanInTList")!=null)
	    {
	    	gridLoanInTList = (List) map.get("gridLoanInTList");
	    	noOfRows = gridLoanInTList.size();
	    }
	    if(map.get("itemBrandList")!= null){
	    	itemBrandList= (List)map.get("itemBrandList");
	    }
	    int inc = 0;
	   	if (gridLoanInTList != null && gridLoanInTList.size()>0)
	    {
    		 for(StoreIndentT storeLoaninT : gridLoanInTList)
	    	 {
    			 System.out.println("this is indent list");
    			 inc = inc + 1;
	    	 %>
	   <input type="hidden" name="gridSize" id="gridSize" value="<%=gridLoanInTList.size()%>"/>
		<tr>
		<td width="5%">
		<input type="text" size="2" value="<%=inc%>" name="<%=SR_NO%>" readonly="readonly" />
		</td>
		<td width="10%">
		<input type="hidden" name="flag" value="LoanIn" />
			<%if(storeLoaninT.getItem().getPvmsNo()!=null){ %>
		<input type="text"	value="<%=storeLoaninT.getItem().getPvmsNo() %>" name="<%=ITEM_CODE %>" size="8" readonly="readonly" id="<%=codeItem+""+inc%>" tabindex="1"/>
		<%}else{ %>
		<input type="text" value=" " name="<%=ITEM_CODE %>" size="8" readonly="readonly" id="<%=codeItem+""+inc%>" tabindex="1"/>
		<%} %>
		<input type="hidden" name="<%=DETAIL_ID %>"	value="<%=storeLoaninT.getId() %>" id="hdb" />
		<input type="hidden" value="<%=storeLoaninT.getItem().getId()%>" name="<%=ITEM_ID%>" id="<%=idItem+""+inc%>" />
		<input type="hidden" value=""  name=""	id="<%=expiry+""+inc%>" />
		<input type="hidden" value="<%=storeLoaninT.getItem().getItemConversion().getFormula()%>" name="" id="<%=formula+""+inc%>" />
		<input type="hidden" value="<%=storeLoaninT.getItem().getItemConversion().getConversionFactor1()%>"	 name="" id="<%=conversionFactor+""+inc%>" />
		<input type="hidden" name="loanInItem" value="Yes" id="loanInItem" />
		</td>

		<td width="10%">
			<input type="text"	value="<%=storeLoaninT.getItem().getNomenclature()%>" id="<%=nameItem+""+inc%>" size="50"	onblur="if(fillSrNo('<%=inc%>')){checkForGrn(this.value, '<%=nameItem%>','<%=inc%>');}"	name="<%=nameItem%>" tabindex="1" size="50" />
			<div id="ac2update"	style="display: none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('<%=nameItem+""+inc%>','ac2update','stores?method=getItemListForGrnByAutocomplete',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentCombo').value+'&sourceOfSupply= '+document.getElementById('sourceCombo').value});
			</script>
			</td>


		<td width="10%">
		<input type="text" size="8"	value="<%=storeLoaninT.getItem().getItemConversion().getItemUnitName() %>"	 readonly="readonly" name="<%=AV%>"	id="<%=idAu+""+inc%>" />
		</td>
		<td>
		<input type="text" name="barCodeNo" size="8" id=""<%=barCodeId+""+inc%>" value="" tabindex="1"/>
		</td>

		<td>
<%--Commented By Ujjwal --%>
		<%--<input type="text" name="BRAND_GEN" size="1" id=""<%="BrandGen"+""+inc%>" value="<%=storeLoaninT.getItem().getBrandedGeneric()%>" tabindex="1"/> --%>
		<select name="BRAND_GEN"  class="smallest" id=""<%="BrandGen"+""+inc%>" tabindex="1">
		<option value="S">Select</option>
		<option value="B">B</option>
		<option value="G" selected="selected">G</option>
		</select>
		</td>
<td width="10%">		
			
			<select name="<%=BRAND_ID%>" id="<%=brandId+""+inc%>" tabindex="1" class="small3" onchange="getManufacturerNameByAjax(this.value,<%=inc%>);">
			<%
			if(itemBrandList.size()>0){
				for(MasStoreBrand masStoreBrand :itemBrandList){
			if(storeLoaninT.getItem()!=null){
				if(storeLoaninT.getItem().getId().equals(masStoreBrand.getItem().getId())){
			%>
		<option value="">Select</option>
		<option value="<%=masStoreBrand.getId()%>" ><%=masStoreBrand.getBrandName()%>
		</option>
		<%}}}}else{%>
				<option value=""></option>

		<%}%>
			</select>
			</td>

			<td width="10%">
			<select name="<%=MANUFACTURER_ID %>" id=<%=manufacturerId+""+inc%> tabindex="1"  class="small3">
			<%if(storeLoaninT.getManufacture()!=null){%>
		<option value="">Select</option>
		<option value="<%=storeLoaninT.getManufacture().getId()%>"><%=storeLoaninT.getManufacture().getManufacturerName()%></option>
		<%}else{%>
				<option value=""></option>
		<%}%>
			</select></td>		<td width="10%">
		<input type="text"	value=""	size="8" name="<%=BATCH_NO %>" 	id="<%=batchNo+""+inc%>" tabindex="1"/>
		</td>
<td width="40%">
			<input type="text" value=""	name="<%=MANUFACTURING_DATE%>" size="10" id="<%=manufacturingDate+""+inc%>" MAXLENGTH="30"  readonly="readonly" tabindex="1"/>
			</td><td><img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" OnClick="setdate('<%=currentDate%>',document.getElementById('<%=manufacturingDate+""+inc%>'),event);" />
			</td>
<td width="40%">
			<input type="text" value=""	name="<%=EXPIRY_DATE%>" size="10" id="<%=expiryDate+""+inc %>" MAXLENGTH="30" tabindex="1" readonly="readonly" tabindex="1"/>
			</td><td><img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate%>',document.getElementById('<%=expiryDate+""+inc%>'),event);" />
			</td>
			<%
			BigDecimal tax = new BigDecimal(0);
	       	BigDecimal discount = new BigDecimal(0);
	       	BigDecimal qty = new BigDecimal(0);
	       	BigDecimal rate = new BigDecimal(0);
	       	BigDecimal amount  = new BigDecimal(0);
	       	BigDecimal amountAfterTax = new BigDecimal(0);
	      	BigDecimal amountAfterdis = new BigDecimal(0);
	       	BigDecimal mdqValue = new BigDecimal(0);
	       	String formulaValue = "";
	       	int conversionFactorValue = 0;

	        BigDecimal taxPercent = new BigDecimal(0);
		    BigDecimal discountPercent = new BigDecimal(0);


		    try
			{
		    	if(storeLoaninT.getQtyReceived() !=null){
				qty = storeLoaninT.getQtyReceived();
			}
		    }catch(Exception e)
			{
				qty = new BigDecimal(0);
			}
		    try
			{
		    	if(storeLoaninT.getUnitRate() !=null){
				rate = storeLoaninT.getUnitRate();
			}
		    }catch(Exception e)
			{
				rate = new BigDecimal(0);
			}


			try
			{
				formulaValue = storeLoaninT.getItem().getItemConversion().getFormula();
			}
			catch(Exception e)
			{
				formulaValue = "";
			}


			try
			{
				conversionFactorValue = storeLoaninT.getItem().getItemConversion().getConversionFactor1();
			}
			catch(Exception e)
			{
				conversionFactorValue = 0;
			}

			amount = qty.multiply(rate);
			//amountAfterTax = amount.add(tax);
			amountAfterdis = amount.subtract(discount);

			if(!discount.toString().equals("0.0000") && !amount.toString().equals("0")){
			discountPercent = (discount.multiply(new BigDecimal(100))).divide(amount,new MathContext(4));
			}
			BigDecimal convertedStockValue = new BigDecimal(0);

			if (formulaValue.equals("1"))
			{
			//	convertedStockValue = qty.multiply(mdqValue).divide(new BigDecimal(conversionFactorValue));
			}
			else if (formulaValue.equals("2"))
			{
				convertedStockValue = qty;
			}

			%>
			<td width="10%">
			<%if(storeLoaninT.getQtyReceived() !=null){ %>
			<input type="text" value="<%=storeLoaninT.getQtyReceived() %>" name="<%=QUANTITY_RECEIVED %>" size="8" tabindex="1" id="<%=quanRec+""+inc %>"	onblur="calculationInCRV();" tabindex="1"/>
			<%}else{ %>
			<input type="text" value="" name="quantityReceived" size="8" tabindex="1" id="<%=quanRec+""+inc %>"	onblur="calculationInCRV();" tabindex="1"/>
			<%} %>
			</td>
			</td>
				<td width="10%"><select name="dispenseType"
				id=<%=dispenseType+""+inc%> tabindex="1">
				<option value="<%=storeLoaninT.getItem().getItemConversion().getIntermediateUnit().getUnitName()%>"><%=storeLoaninT.getItem().getItemConversion().getIntermediateUnit().getUnitName()%></option>
			</select></td>
					<td width="10%"><input type="text"
				class="medcaption"
				name="mdq"  id="<%=mdq+""+inc%>" tabindex="2" size="6" onblur="calculationInCRV();" value="1" onfocus="calculateTotalCrvAmount(<%=inc%>);" size="5"/>
			</td>

					<td width="10%">
				<%if(storeLoaninT.getUnitRate() !=null){%>
				<input type="text" value="<%=storeLoaninT.getUnitRate()%>" name="ratePerMdq" size="8" id="<%=ratePerMdq+""+inc %>" tabindex="1" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=inc%>);" tabindex="1"/>
				<%}else{ %>
				<input type="text" value="" name="ratePerMdq" size="8" id="<%=ratePerMdq+""+inc %>" tabindex="1" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=inc%>);" tabindex="1"/>
				<%} %>
				</td>


				<td >
				<input type="text" value="" name="<%=MRP %>" size="8" id="<%=mrp+""+inc %>" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=inc%>);" tabindex="1"/>
				</td>
				<td width="3%">
				<input type="text"  value="" name="<%=DISCOUNT_PERCENTAGE%>" size="5" tabindex="1"	id="<%=discountVar+""+inc %>" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=inc%>);"	validate="Discount,float,no" tabindex="1"/>
				<input type="hidden" value="" name="discountAmount"	id="<%=discountAmount+""+inc %>" tabindex="1"/>
				</td>
					<%if(choice.equals("l")){
		%>
			<!--<td width="10%"><input type="text" value=""
				name="<%=TAX_AMT_MDQ %>" tabindex="2" onblur="calculationInCRV();"
				id="<%=TAX_AMT_MDQ +""+inc%>" />------>
			<td width="10%">
			<input type="text"  name="<%=TAX_PERCENT %>" value="" tabindex="1" size="6" id="<%=taxVar+""+inc %>" onblur="calculationInCRV();"  size="5" onfocus="calculateTotalCrvAmount(<%=inc%>);"  validate="Tax,float,no"/>
			<input type="hidden"  value="" name="taxAmount" id="<%=taxAmount+""+inc%>" />
			</td>
			<%} else { %>
			<td width="10%"><input type="text"
				name="<%=TAX_PERCENT %>" tabindex="1" size="6" id="<%=taxVar+""+inc%>" 
				onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=inc%>);"  size="5" validate="Tax,float,no" />
				 <input
				type="hidden"  value="" name="taxAmount"
				id="<%=taxAmount+""+inc%>" /></td>
			<%}%>
			<td width="10%">
			<input type="text" value="" name="<%= COST_PRICE %>" size="6"	id="<%=costPrice+""+inc%>"  size="5" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=inc%>);"/>
			</td>
			<td width="10%">
			<%if(storeLoaninT.getTotalCost() !=null){ %>
			<input type="hidden" value=""	 name="<%= COST_PRICE %>" id="<%=costPrice+""+inc %>" size="6" tabindex="1"/>
			<input type="text" value=""  name="<%=AMOUNT%>" size="8"	id="<%=amtVar+""+inc %>" readonly="readonly" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=inc%>);" tabindex="1" />
			<%}else{ %>
			<input type="hidden" value=""	size="6"  name="<%= COST_PRICE %>" id="<%=costPrice+""+inc %>" tabindex="1"/>
			<input type="text" value=""  name="<%=AMOUNT%>" size="8"	id="<%=amtVar+""+inc %>" readonly="readonly" onblur="calculationInCRV();"  onfocus="calculateTotalCrvAmount(<%=inc%>);" tabindex="1" />
			<%} %>
			</td>
			<td><input type="text" name="<%=reasonForDemand%>" value="" tabindex="1"/>
			<input type="hidden" name="PreId" id="<%="PreId"+""+inc%>" value="0"/>
			</td>
<!-- -
			<td width="10%"><input type="text" value="0"
				name="ed" readonly="readonly" id="<%=ed+""+inc%>" tabindex="2" /></td>



			<td width="3%"><input type="text"
				value="<%=convertedStockValue%>" name="convertedStock"
				id="<%=convertedStock+""+inc%>" readonly="readonly" /></td>
				 -->

				<td>
			    <input name="Button" type="button" class="buttonAdd" value="" onclick="addRow('grnDetails');" tabindex="1" />
		   </td>
		   <td>
				<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('grnDetails',<%=inc %>,this);" tabindex="1" />

		   </td>

		</tr>
		<% }
	} //for loop ends here %>

</table>
</div>
</div>

<div class="clear"></div>
<div class="Block">
<!-- -
<label>Total Cost</label>
<input type="text" id="total_cost" name="totalCost" value="" readonly="readonly" tabindex="1"/> -->
<label>Total Amount</label>
<input type="text" id="total_amount" name="actualGrnValue" value="<%=Tot%>" readonly="readonly"    tabindex="1"/>
</div>


<div class="clear"></div>
<input type="hidden" name="<%=TOTAL_AMOUNT %>" id="<%=TOTAL_AMOUNT%>"
	value="" /> <input type="hidden" name="<%=CLOSING_STOCK %>"
	id="<%=CLOSING_STOCK%>" value="" />
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="sss" align="right" class="button" id="checkEmp" 
	value="Submit"
	onclick="if(testEmp() && checkSave()&& checkForSubmit() && checkInvoiceNo()){submitForm('grnForm','stores?method=submitGrnwithprint');}" />
<input type="button" name="sss" class="button" value="SEARCH" onclick="getSearchBlock();" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	<input type="hidden" name="checkJsp" value="grn"/>

	</form>

	<script type="text/javascript">


				<!--
					// Main vBulletin Javascript Initialization
					vBulletin_init();
				//-->
				</script> <input type="hidden" name="rows" id="rr" value="1" /> <br />



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
<%}else{ %>
<h4>Access Denied ! </h4>
<%}%>


<script type="text/javascript">
function addRow(idName) {

	  var tbl =  document.getElementById(idName);
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('gridSize');
	  hdb.value=iteration
	  var el=0;

	  var cellRight0 = row.insertCell(el);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.size = '2';
	  e0.name='<%=SR_NO%>';
	  e0.setAttribute('tabindex', 1);
	  e0.readOnly=true;
	  e0.value=iteration;
	  cellRight0.appendChild(e0);

	  var ee5 = document.createElement('input');
	  ee5.type = 'hidden';
	  ee5.name='<%=ITEM_ID%>';
	  ee5.id = 'idItem'+iteration;

	  var ee1 = document.createElement('input');
	  ee1.type = 'hidden';
	  ee1.name='<%=DETAIL_ID%>';
	  ee1.id = 'hdb'+iteration;
	  ee1.value=iteration;

	  var ee2 = document.createElement('input');
	  ee2.type = 'hidden';
	  ee2.name='';
	  ee2.id = 'expiry'+iteration;

	  var ee3 = document.createElement('input');
	  ee3.type = 'hidden';
	  ee3.name='';
	  ee3.id = 'formula'+iteration;


	  var ee4 = document.createElement('input');
	  ee4.type = 'hidden';
	  ee4.name='';
	  ee4.id = 'conversionFactor'+iteration;


	  var ee6 = document.createElement('input');
	  ee6.type = 'hidden';
	  ee6.name='loanInItem';
	  ee6.id = 'loanInItem'+iteration;
	  ee6.value='No'

	  var cellRight1 = row.insertCell(++el);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='<%=ITEM_CODE%>';
	  e1.id = 'codeItem'+iteration;
	  e1.size='8';
	  e1.setAttribute('tabindex', 1);
	  cellRight1.appendChild(ee1);
	  cellRight1.appendChild(ee2);
	  cellRight1.appendChild(ee3);
	  cellRight1.appendChild(ee4);
	  cellRight1.appendChild(ee5);
	  cellRight1.appendChild(ee6);
	  cellRight1.appendChild(e1);




	  var cellRight2 = row.insertCell(++el);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name = 'nameItem';
	  e2.id = 'nameItem' + iteration;
	  e2.size = '50';
	  e2.setAttribute('tabindex', 1);
	  e2.onblur = function(){if(fillSrNo(iteration)){checkForGrn(this.value, 'nameItem',iteration)}};



	 var newdiv = document.createElement('div');
 	  newdiv.setAttribute('id', 'ac2update'+iteration);
 	 newdiv.style.display = 'none';
 	  newdiv.className = "autocomplete";
	  cellRight2.appendChild(e2);
	  cellRight2.appendChild(newdiv);
	  new Ajax.Autocompleter('nameItem'+iteration,'ac2update','stores?method=getItemListForGrnByAutocomplete&sourceOfSupply=a',{parameters:'requiredField=nameItem'});


	  var cellRight3 = row.insertCell(++el);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='<%=AV%>';
	  e3.id = 'idAu'+iteration;
	  e3.setAttribute('tabindex', 1);
	e3.size='8';
	   cellRight3.appendChild(e3);


	   var cellRight4 = row.insertCell(++el);
	   var e4 = document.createElement('input');
		  e4.type = 'text';
		  e4.name='barCodeNo';
		  e4.id = 'barCodeId'+iteration;
		  e4.setAttribute('tabindex', 1);

		 e4.size='8';
		   cellRight4.appendChild(e4);


	   var cellRight5 = row.insertCell(++el);
	   var e5 = document.createElement('Select');
		e5.name='BRAND_GEN';
		e5.id = 'BrandGen'+iteration;
		e5.className='smallest';
		e5.setAttribute('tabindex', 1);
		e5.options[0] = new Option('Select', 'S');
	    e5.options[1] = new Option('B', 'B');
        e5.options[2] = new Option('G', 'G');
	    cellRight5.appendChild(e5);

		var cellRight6 = row.insertCell(++el);
		  var e6 = document.createElement('Select');
		  e6.name = '<%=BRAND_ID%>';
		  e6.id = 'brandId' + iteration;
		  e6.setAttribute('tabindex', 1);
		  e6.className='small3';
		  e6.options[0] = new Option('--Select Brand--', '');
		  cellRight6.appendChild(e6);


			var cellRight7 = row.insertCell(++el);
			  var e7 = document.createElement('Select');
			  e7.name = '<%=MANUFACTURER_ID%>';
			  e7.id = 'manufacturerId' + iteration;
			  e7.setAttribute('tabindex', 1);
			  e7.className='small3';
			  e7.options[0] = new Option('--Select Manuf--', '');
			  cellRight7.appendChild(e7);

			  var cellRight8 = row.insertCell(++el);
			   var e8 = document.createElement('input');
				e8.type = 'text';
				e8.name='<%=BATCH_NO %>';
				e8.id = 'batchNo'+iteration;
				e8.setAttribute('tabindex', 1);
				e8.setAttribute('maxlength', 25);
				 e8.size='8';
				 cellRight8.appendChild(e8);



	  var cellRight9 = row.insertCell(++el);
	  var e9 = document.createElement('input');
	  e9.type = 'text';
	  e9.name='<%=MANUFACTURING_DATE%>';
	  e9.id = 'manufacturingDate'+iteration;
	  e9.size='10';
	  cellRight9.appendChild(e9);


     var cellRight99 = row.insertCell(++el);
     var eImg = document.createElement('img');
   	eImg.src = '/hms/jsp/images/cal.gif';
   eImg.name = '' ;
   eImg.id = '';
   eImg.WIDTH = '16';
   eImg.HEIGHT = '16';
   //eImg.id = 'billDateId'+iteration;
   eImg.onclick = function(event){
		  setdate('',document.getElementById('<%="manufacturingDate"%>'+iteration),event) };
   cellRight99.appendChild(eImg);

	var cellRight110 = row.insertCell(++el);
	var e110 = document.createElement('input');
	e110.type = 'text';
	e110.name='<%=EXPIRY_DATE%>';
	e110.id = 'expiryDate'+iteration;
	e110.size='10';
	cellRight110.appendChild(e110);



	 var cellRight999 = row.insertCell(++el);
     var eImg1 = document.createElement('img');
   	eImg1.src = '/hms/jsp/images/cal.gif';
   eImg1.name = '' ;
   eImg1.id = '';
   eImg1.WIDTH = '16';
   eImg1.HEIGHT = '16';
   //eImg.id = 'billDateId'+iteration;
   eImg1.onclick = function(event){
		  setdate('',document.getElementById('<%="expiryDate"%>'+iteration),event) };
   cellRight999.appendChild(eImg1);

	var cellRight11 = row.insertCell(++el);
	var e11 = document.createElement('input');
	e11.type = 'text';
	e11.name='<%=QUANTITY_RECEIVED%>';
	e11.id = 'quanRec'+iteration;
	e11.size='8';
	e11.value='0'
	e11.setAttribute('tabindex', 1);
	cellRight11.appendChild(e11);


	var cellRight12 = row.insertCell(++el);
	var e12 = document.createElement('Select');
	e12.name = 'dispenseType';
	e12.id = 'dispenseType' + iteration;
	e12.setAttribute('tabindex', 1);
	e12.options[0] = new Option('DispenseType', '0');
	cellRight12.appendChild(e12);

	var cellRight13 = row.insertCell(++el);
	var e13 = document.createElement('input');
	e13.type = 'text';
	e13.name='mdq';
	e13.id = 'mdq'+iteration;
	e13.size='5';
	e13.value='1'
	e13.onblur = function(){calculationInCRV()};
	e13.onfocus=function(){calculateTotalCrvAmount(iteration)};

	e13.setAttribute('tabindex', 2);
	cellRight13.appendChild(e13);



	var cellRight15 = row.insertCell(++el);
	var e15 = document.createElement('input');
	e15.type = 'text';
	e15.name='ratePerMdq';
	e15.id = 'ratePerMdq'+iteration;
	e15.size='8';
	e15.value=''
	e15.setAttribute('tabindex', 1);

	e15.onblur = function(){calculationInCRV()};
	e15.onfocus=function(){calculateTotalCrvAmount(iteration)};
	cellRight15.appendChild(e15);


	var cellRight14 = row.insertCell(++el);
	var e14 = document.createElement('input');
	e14.type = 'text';
	e14.name='<%=MRP %>';
	e14.id = 'mrp'+iteration;
	e14.size='8';
	e14.value=''
	e14.onblur = function(){calculationInCRV()};
	e14.onfocus=function(){calculateTotalCrvAmount(iteration)};
	e14.setAttribute('tabindex', 1);
	cellRight14.appendChild(e14);

	var ee16 = document.createElement('input');
	ee16.type = 'hidden';
	ee16.name='discountAmount';
	ee16.id = 'discountAmount'+iteration;
	ee16.value='';


	var cellRight16 = row.insertCell(++el);
	var e16 = document.createElement('input');
	e16.type = 'text';
	e16.name='<%=DISCOUNT_PERCENTAGE%>';
	e16.id = 'discountVar'+iteration;
	e16.size='5';
	e16.value=''
	e16.setAttribute('tabindex', 1);
	e16.onblur = function(){calculationInCRV()};
	e16.onfocus=function(){calculateTotalCrvAmount(iteration)};
	cellRight16.appendChild(ee16);
	cellRight16.appendChild(e16);

	var ee17 = document.createElement('input');
	ee17.type = 'hidden';
	ee17.name='taxAmount';
	ee17.id = 'taxAmount'+iteration;
	ee17.value='';

	var cellRight17 = row.insertCell(++el);
	var e17 = document.createElement('input');
	e17.type = 'text';
	e17.name='<%=TAX_PERCENT%>';
	e17.id = 'taxVar'+iteration;
	e17.size='6';
	e17.value=''
	e17.setAttribute('tabindex', 1);
	e17.onblur = function(){calculationInCRV()};
	e17.onfocus=function(){calculateTotalCrvAmount(iteration)};
	cellRight17.appendChild(ee17);
	cellRight17.appendChild(e17);

	var cellRight18 = row.insertCell(++el);
	var e18 = document.createElement('input');
	e18.type = 'text';
	e18.name='<%=COST_PRICE%>';
	e18.id = 'costPrice'+iteration;
	e18.size='6';
	e18.value='0'
	e18.onblur = function(){calculationInCRV()};
	e18.onfocus=function(){calculateTotalCrvAmount(iteration)};
	e18.setAttribute('tabindex', 1);
	cellRight18.appendChild(e18);

	var cellRight19 = row.insertCell(++el);
	var e19 = document.createElement('input');
	e19.type = 'text';
	e19.name='<%=AMOUNT%>';
	e19.id = 'amtVar'+iteration;
	e19.size='8'
	e19.value='0'
	e19.onblur = function(){calculationInCRV()};
	e19.onfocus=function(){calculateTotalCrvAmount(iteration)};
	e19.setAttribute('tabindex', 1);
	cellRight19.appendChild(e19);

	var ee20 = document.createElement('input');
	ee20.type = 'hidden';
	ee20.name='PreId';
	ee20.id = 'PreId'+iteration;
	ee20.value='0';

	var cellRight20 = row.insertCell(++el);
	var e20 = document.createElement('input');
	e20.type = 'text';
	e20.name='reasonForDemand';
	e20.value=''
	e20.setAttribute('tabindex', 1);
	e20.onblur = function(){calculationInCRV()};
	cellRight20.appendChild(ee20);
	cellRight20.appendChild(e20);


	  var cellRight21 = row.insertCell(++el);
	  var e21 = document.createElement('input');
	  e21.type = 'button';
	  e21.name='remarks'+iteration;
	  e21.className = 'buttonAdd';
	  e21.setAttribute('tabindex', 1);
	  e21.onclick= function(){addRow('grnDetails')};
	  cellRight21.appendChild(e21);

	  var cellRight22 = row.insertCell(++el);
	  var e22 = document.createElement('input');
	  e22.type = 'button';
	  e22.name='remarks'+iteration;
	  e22.setAttribute('tabindex', 1);
	  e22.className = 'buttonDel';
	  e22.onclick= function(){removeRow('grnDetails',iteration,this)};
	  cellRight22.appendChild(e22);

}
function removeRow(idName,inc,obj)
{

    try {
        var table = document.getElementById(idName);
        var rowCount = table.rows.length;
        var gridSize=document.getElementById('gridSize').value;

    	for(var i=rowCount-1; i>0; i++)
        {
        	var row = table.rows[i];
            if(i>1)
            {
                var i=obj.parentNode.parentNode.rowIndex;
                table.deleteRow(i);
            	//table.deleteRow(i);
              	document.getElementById('gridSize').value=(parseInt(gridSize))-1;
              return true;
             }
            else
            {
            	alert("At Least One Row  Should Be There");
                return false;
             }
               rowCount--;
                i--;


       }
       }catch(e)
       	{
           alert(e);
       }

}
function ajaxFunctionForAutoCompleteInGrn1(formName,action,rowVal) {

	 var sos = document.getElementById('sourceCombo').value
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

	      	var brandId="brandId"+rowVal;
			obj = document.getElementById(brandId);
			obj.length = 1;

			var manufacturerId ="manufacturerId"+rowVal;
			obj1 = document.getElementById(manufacturerId);
			obj1.length = 1;

		//	var dispenseType ="dispenseType"+rowVal;
		//	obj2 = document.getElementById(dispenseType);

	      	for (loop = 0; loop < items.childNodes.length; loop++)
	      	{
	      	 	var item = items.childNodes[loop];
		        var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		        var BrandGen  = item.getElementsByTagName("BrandGen")[0];

		      //  var formula  = item.getElementsByTagName("formula")[0];
		       // var conversionFactor  = item.getElementsByTagName("conversionFactor")[0];
		        var name  = item.getElementsByTagName("name")[0];

		        var brandLength  = item.getElementsByTagName("brands")[0];
		        var brandLength  = item.getElementsByTagName("brands")[0];
		        var poRate  = item.getElementsByTagName("poRate")[0];
		        var poTax = item.getElementsByTagName("poTax")[0];
		      //  var poDiscount = item.getElementsByTagName("poDiscount")[0];
		        var dispType = item.getElementsByTagName("dispType")[0];
		        var idBranGen=item.getElementsByTagName("idBranGen")[0];







		        var dispenseType ="dispenseType"+rowVal;
	            obj2 = document.getElementById(dispenseType);
	         	obj2.length=1;
				obj2.options[obj2.length-1].value = dispType.childNodes[0].nodeValue;
				obj2.options[obj2.length-1].text  = dispType.childNodes[0].nodeValue;




		        //var poMdqValue = item.getElementsByTagName("poMdqValue")[0];
		        var poRatePerMdq = item.getElementsByTagName("poRatePerMdq")[0];
		        var poBrandId = item.getElementsByTagName("poBrandId")[0];
		        var poManufacturerId = item.getElementsByTagName("poManufacturerId")[0];
		     //   var poFreeQty = item.getElementsByTagName("poFreeQty")[0];
		     //   var poFreeItem = item.getElementsByTagName("poFreeItem")[0];
		     //   var expiry = item.getElementsByTagName("expiry")[0];


	        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
	        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
	        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue

	        	document.getElementById('BrandGen'+rowVal).value = idBranGen.childNodes[0].nodeValue


				//document.getElementById('idBranGen1'+rowVal).value = idBranGen.childNodes[0].nodeValue;




	        //	document.getElementById('freeQty'+rowVal).value = poFreeQty.childNodes[0].nodeValue
	        //	document.getElementById('expiry'+rowVal).value = expiry.childNodes[0].nodeValue
	        	//document.getElementById('formula'+rowVal).value = formula.childNodes[0].nodeValue
	        //	document.getElementById('conversionFactor'+rowVal).value = conversionFactor.childNodes[0].nodeValue


	        	//obj2.length=1;
				//obj2.options[obj2.length-1].value = poDispType.childNodes[0].nodeValue;
				//obj2.options[obj2.length-1].text  = poDispType.childNodes[0].nodeValue;



	        	for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++)
	        	{
	        		var brand = brandLength.childNodes[innerLoop];
		        	var brandId  = brand.getElementsByTagName("brandId")[0];
		        	var brandName  = brand.getElementsByTagName("brandName")[0];
		        	var manufacturerId = brand.getElementsByTagName("manufacturerId")[0];
		        	var manufacturerName  = brand.getElementsByTagName("manufacturerName")[0];

		        	obj.length++;
					obj.options[obj.length-1].value=brandId.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=brandName.childNodes[0].nodeValue;


					obj1.length++;
					obj1.options[obj1.length-1].value=manufacturerId.childNodes[0].nodeValue;
					obj1.options[obj1.length-1].text=manufacturerName.childNodes[0].nodeValue;

	        	}
	        	//document.getElementById('discountVar'+rowVal).value =poDiscount.childNodes[0].nodeValue
	        //	document.getElementById('tax_amt_mdq'+rowVal).value =poTax.childNodes[0].nodeValue
	        	//document.getElementById('mdq'+rowVal).value =poMdqValue.childNodes[0].nodeValue
	        //	document.getElementById('ratePerMdq'+rowVal).value =poRatePerMdq.childNodes[0].nodeValue


	        	var brandCombo = document.getElementById('brandId'+rowVal);

	        /*	for(var i=0;i<brandCombo.length;i++)
	        	{
	        		if (brandCombo[i].value == poBrandId.childNodes[0].nodeValue)
	        			brandCombo.selectedIndex = i;
	        	}


	        	var manufacturerCombo = document.getElementById('manufacturerId'+rowVal);

	        	for(var i=0;i<manufacturerCombo.length;i++)
	        	{
	        		if (manufacturerCombo[i].value == poManufacturerId.childNodes[0].nodeValue)
	        			manufacturerCombo.selectedIndex = i;
	        	}*/

	        //	var freeItemCombo = document.getElementById('freeItem'+rowVal);

	        	//for(var i=0;i<freeItemCombo.length;i++)
	        //	{
	        //		if (freeItemCombo[i].value == poFreeItem.childNodes[0].nodeValue)
	        		//	freeItemCombo.selectedIndex = i;
	        //	}

	      	}
	      }
	    }
	   	 var url=action

	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	  }


function checkForCRVGrid1()
{

    for(i=1;i<=40;i++)
	    {

		   if(document.getElementById('codeItem'+i) != null){
		    var pvms = document.getElementById('codeItem'+i).value;

		    if(pvms !="")
		    {

			    if (document.getElementById('brandId'+i).value=="")
			    {
			    alert('Pl. Check Brand in Row No:' + i);
			    document.getElementById('brandId'+i).focus();
			    return false;
			    }

			    if (document.getElementById('manufacturerId'+i).value=="")
			    {
			    alert('Pl. Check Manufacturer in Row No:' + i);
			    document.getElementById('manufacturerId'+i).focus();
			    return false;
			    }


		   		/*if (document.getElementById('batchNo'+i).value=="")
			    {
			    alert('Pl. Check Batch No in Row No:' + i);
			    document.getElementById('batchNo'+i).focus();
			    return false;
			    }*/

			    if (document.getElementById('quanRec'+i).value=="" || isNaN(document.getElementById('quanRec'+i).value))
			    {
			    alert('Pl. Check Quantity Received in Row No:' + i);
			    document.getElementById('quanRec'+i).focus();
			    return false;
			    }
				if (document.getElementById('expiryDate'+i).value=="")
		    	{
		    	  alert('Expiry Date in Row No:' + i + ' is Mandatory!..');
		    	  document.getElementById('expiryDate'+i).focus();
		    	  return false;
		    	}
				var strValue = document.getElementById('expiryDate'+i).value;
			    dateOfJoining = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
			 	var strValue1= document.getElementById('manufacturingDate'+i).value;
			    //currentDate = new Date();
				//var month = currentDate.getMonth() + 1
				//var day = currentDate.getDate()
				//var year = currentDate.getFullYear()
				//var seperator = "/"
				//currentDate = new Date(month + seperator + day + seperator + year);
			 	currentDate=new Date(strValue1.substring(6),(strValue1.substring(3,5) - 1) ,strValue1.substring(0,2));
			 	if(dateOfJoining < currentDate)
			 	{
					alert('Expiry Date is Not Valid in Row No: ' + i );
					return false;
			 	}


			   /* if (document.getElementById('dispenseType'+i).value=="")
			    {
			    alert('Pl. Select Dispense Type in Row No:' + i);
			    document.getElementById('dispenseType'+i).focus();
			    return false;
			    }

			    if (document.getElementById('mdq'+i).value=="" || document.getElementById('mdq'+i).value==0 || isNaN(document.getElementById('mdq'+i).value))
			    {
			    alert('Pl. Check MDQ in Row No:' + i);
			    document.getElementById('mdq'+i).focus();
			    return false;
			    }*/



			    if(document.getElementById('sourceCombo').value=="a" || document.getElementById('sourceCombo').value=="i" || document.getElementById('sourceCombo').value=="o")
			    {
			   	return true;
			    }
			    else if (document.getElementById('ratePerMdq'+i).value=="" || document.getElementById('ratePerMdq'+i).value==null || document.getElementById('ratePerMdq'+i).value==0 || isNaN(document.getElementById('ratePerMdq'+i).value))
			    {
			    alert('Pl. Check Rate / MDQ in Row No:' + i);
			    document.getElementById('ratePerMdq'+i).focus();
			    return false;
			    }
			    if(document.getElementById('sourceCombo').value=="a" ||document.getElementById('sourceCombo').value=="i" || document.getElementById('sourceCombo').value=="o")
			    {
			    return true;
			    }
			    else if (document.getElementById('amtVar'+i).value=="" || document.getElementById('amtVar'+i).value==0 || document.getElementById('amtVar'+i).value < 0)
			    {
			    alert('Pl. Check Amount in Row No:' + i);
			    return false;
			    }
		    }
		   }
	    }

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
			  //  if (document.getElementById('expiry'+i).value=='y')
			//   {

			  //  }




	    return true;
}


</script>
<script type="text/javascript">
function testEmp(){
	if(document.getElementById('checkEmp').value=='Submit'){
	 if(document.getElementById('empId').value=='')
		 {
		 alert("Please select Unpack-Checked By ");
		 return false;
		 }else{
		 return true;
		 }
	 }
}

</script>


