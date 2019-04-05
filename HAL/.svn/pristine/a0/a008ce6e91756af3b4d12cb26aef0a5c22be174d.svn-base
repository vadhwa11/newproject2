var itemsArray1=new Array();
var itemsArray=new Array();
var indentArray=new Array();
var brandArray=new Array();
var numLinesAdded = 1;
var tt;
 
//-----------------------------------------------------------------------------------------------------------------
//------------------------------------Start of Functions Written By Vivek------------------------------------------
//-----------------------------------------------------------------------------------------------------------------
 
 	function fillItemsInDepot(nomenclature,rowVal){
		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idAu="idAu";
    	var nameItemForFocus="nameItem";
    	var stockInVar="stockInVar";
    	var oldNiv="oldNiv";
		var n="nameItem";
		var departmentId="departmentId";
		var  qtyInHandTemp="qtyInHandTemp";
		var mmfVarTemp="mmfVarTemp";
		var qtyInHand="qtyInHand";
		qtyInHand=qtyInHand+rowVal
		mmfVarTemp=mmfVarTemp+rowVal
    	idItem=idItem+rowVal;
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	idAu=idAu+rowVal
    	oldNiv=oldNiv+rowVal
    	qtyInHandTemp=qtyInHandTemp+rowVal
    	departmentId=departmentId+rowVal
    		if(nomenclature==""){
    		alert("Nomenclature Can not be empty")
    		document.getElementById(nameItem).focus();
			return false;
			}
	   	 	
    	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%8
   		
   		if(rowVal==0){
   			rowVal=8
   	 		
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
    	
		for(i=0;i<itemsArray1.length;i++){
		
		if(itemsArray1[i][2]==nomenclature){
		
			
			document.getElementById(idItem).value=itemsArray1[i][0]
			document.getElementById(codeItem).value=itemsArray1[i][1]
			document.getElementById(oldNiv).value=itemsArray1[i][5]
			document.getElementById(idAu).value=itemsArray1[i][7]
			if(itemsArray1[i][3]!="null"){
			document.getElementById(qtyInHand).value=itemsArray1[i][3]
			document.getElementById(qtyInHandTemp).value=itemsArray1[i][3]
			}
			else{
			document.getElementById(qtyInHand).value="0"
			document.getElementById(qtyInHandTemp).value="0"
			}
			if(itemsArray1[i][4]!="null"){
			document.getElementById(mmfVarTemp).value=itemsArray1[i][4]
			}else{
			document.getElementById(mmfVarTemp).value=0
			}
			
			
			
				}
		}
}


//This function is for filling items in Indent To SOC Grid
function fillItemsInSOC(nomenclature,rowVal){
		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idAu="idAu";
    	var nameItemForFocus="nameItem";
    	var stockInVar="stockInVar";
    	var oldNiv="oldNiv";
		var n="nameItem";
		var departmentId="departmentId";
		var  qtyInHandTemp="qtyInHandTemp";
		var mmfVarTemp="mmfVarTemp";
		var qtyInHand="qtyInHand";
		qtyInHand=qtyInHand+rowVal
		mmfVarTemp=mmfVarTemp+rowVal
    	idItem=idItem+rowVal;
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	idAu=idAu+rowVal
    	oldNiv=oldNiv+rowVal
    	qtyInHandTemp=qtyInHandTemp+rowVal
    	departmentId=departmentId+rowVal
    	
    	document.getElementById('currentRow').value=rowVal
    		if(nomenclature==""){
    		alert("Nomenclature Can not be empty")
    		document.getElementById(nameItem).focus();
			return false;
			}
	   	 	
    	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%8
   		
   		if(rowVal==0){
   			rowVal=8
   	 		
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
    	
		for(i=0;i<itemsArray.length;i++){
		
		if(itemsArray[i][2]==nomenclature){
		
			document.getElementById(idItem).value=itemsArray[i][0]
			document.getElementById(codeItem).value=itemsArray[i][1]
			document.getElementById(idAu).value=itemsArray[i][3]
			if(itemsArray[i][3]=="null"){
			document.getElementById(qtyInHand).value=itemsArray[i][3]
			document.getElementById(qtyInHandTemp).value=itemsArray[i][3]
			}
			else{
			document.getElementById(qtyInHand).value="0"
			document.getElementById(qtyInHandTemp).value="0"
			}
						
			
			
				}
		}
}


//This is to set item issued in hidden field
function setItemIsuued(itemIssued,rowVal){
	alert("setItemIsuued")
	var testVar=0
	for(i=0;i<itemsArray.length;i++){
	if(itemsArray[i][2]==itemIssued){
		testVar=testVar+1;
		document.getElementById('issuedItemId'+rowVal).value=itemsArray[i][0]
		return true;
		
	}
	}
	
	
}

//This is fuction to set Total Qty in Main form
function setTotalQty(noOfRows,rowVal){
	var totalQty=0;
	for(i=1;i<parseInt(noOfRows);i++){
	if(document.getElementById('issuedQty'+i).value!="")
		totalQty=totalQty+parseInt(document.getElementById('issuedQty'+i).value)
		else
		totalQty=totalQty+parseInt(0)
		
	}
	if(totalQty==0){
			alert("Can not issue brands without QUANTITY !");
			return false
	}

	if (totalQty < 0) 
	{
	alert("Negative quantity not Allowed!...");
	return;
	}
	
	window.opener.document.getElementById('qtyIssued'+rowVal).value=totalQty ;
	
	//batchNoTemp
	//lotNo
	return true;
}


	function openDeletePopupForIssueciv()
	{
	var issueId = document.getElementById('issueId').value;
	if (issueId==0)
	{
	alert("Pl. select the Issue No thru Search Option!....");
	return;
	}
	var url="/hms/hms/stores?method=openDeletePopupForIssueciv&issueId="+issueId+"&firstTime=1";
	  newwindow=window.open(url,'name',"height=500,width=870,status=1");
	
	}
function openDeletePopupForIssueToOtherUnits(){
var issueId = document.getElementById('issueId').value;
var url="/hms/hms/stores?method=openDeletePopupForIssueToOtherUnits&issueId="+ issueId + "&firstTime=1";
  newwindow=window.open(url,'name',"height=900,width=900,status=1");

}

function openDeletePopupForIssueLoanOut()
{
var issueId = document.getElementById('issueId').value;
var url="/hms/hms/stores?method=openDeletePopupForIssueLoanOut&issueId="+ issueId + "&firstTime=1";
newwindow=window.open(url,'name',"height=500,width=870,status=1");
}


function openDeletePopupForDepartmentIssueNE(){


var url="/hms/hms/nonExp?method=openDeletePopupForIssueLoanOut";
  newwindow=window.open(url,'name',"height=900,width=900,status=1");

var url="/hms/hms/nonExp?method=openDeletePopupForIssueLoanOut";
  newwindow=window.open(url,'name',"height=900,width=900,status=1");

}
function fillRemarksForIssueCiv(rowVal){

	if(document.getElementById('remarksTemp'+rowVal).value==''){
		document.getElementById('remarks'+rowVal).value="emptyString"
	}else{
		document.getElementById('remarks'+rowVal).value=document.getElementById('remarksTemp'+rowVal).value
	}

}




function fillQtyIssuedForIssueCiv(rowVal){


	if(parseInt(document.getElementById('stockIn'+rowVal).value) < parseInt(document.getElementById('issuedQtyTemp'+rowVal).value) ){
		alert("Quantity can not be greater than STOCK ...!")
		document.getElementById('issuedQtyTemp'+rowVal).value=""
		document.getElementById('issuedQtyTemp'+rowVal).focus();
		return false;
	}
	if(document.getElementById('issuedQtyTemp'+rowVal).value==''){
		document.getElementById('issuedQty'+rowVal).value = 0
	}else{
		document.getElementById('issuedQty'+rowVal).value=document.getElementById('issuedQtyTemp'+rowVal).value
	}

}


function fillIssueCivItems(nomenclature,rowVal){
		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idAu="idAu";
    	var issuedItemId="issuedItemId";
		var issuedName="issuedName";
    	idItem=idItem+rowVal;
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	idAu=idAu+rowVal
		issuedItemId=issuedItemId+rowVal
    	issuedName=issuedName+rowVal
    	
    	//document.getElementById('currentRow').value=rowVal
    		if(nomenclature==""){
    		alert("Nomenclature Can not be empty")
			return false;
			}
		for(i=0;i<itemsArray.length;i++){
		if(itemsArray[i][2]==nomenclature){
			document.getElementById(idItem).value=itemsArray[i][0]
			document.getElementById(codeItem).value=itemsArray[i][1]
			document.getElementById(idAu).value=itemsArray[i][3]
			document.getElementById(issuedItemId).value=itemsArray[i][0]
			document.getElementById(issuedName).value=nomenclature			
				}
		}
}




function checkDispencerySelected(){
	if(document.getElementById('departmentIdTemp').value==""){
		alert("Select Dispencery ..!")
		return false;
	}else{
	return true;
	}

}
function validateInteger( strValue ) {
  //alert("in validate integer")
   var objRegExp  =/^((\+|-)\d)?\d*(\d{2})?$/;
   return objRegExp.test(strValue);
 }
  function fillValuesForMMF(inc)
  {
	if(document.getElementById('mmfVarTemp'+inc).value!="")
	{ 
		validateInteger(document.getElementById('mmfVarTemp'+inc).value)
    	document.getElementById('mmfVar'+inc).value=document.getElementById('mmfVarTemp'+inc).value
    	}
  }
  
  
  function isYearSelected(){
  if(document.getElementById('mmfForTheYear').value=="0"){
  		alert("Select Year ...!")
  		return false
  }else{
  	return true
  }
  }
  
  //This used to fill item value in a row based on Code
	function fillItemsInDGFMSHQByCode(itemCode,rowVal){
		alert("fillItemsInDGFMSHQByCode")
		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idAu="idAu";
    	var idSection="idSection";
    	var nameSection="nameSection";
    	var stockInVar="stockInVar";
    	var stockInVarTemp="stockInVarTemp";
    	idItem=idItem+rowVal;
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	idAu=idAu+rowVal;
    	idSection=idSection+rowVal;
    	nameSection=nameSection+rowVal;
    	stockInVar=stockInVar+rowVal;
    	stockInVarTemp=stockInVarTemp+rowVal;
		for(i=0;i<itemsArray1.length;i++){
		
		if(itemsArray1[i][1]==itemCode){
			alert(itemsArray1[i][0])
			document.getElementById(idItem).value=itemsArray1[i][0]
			document.getElementById(nameItem).value=itemsArray1[i][2]
			document.getElementById(idAu).value=itemsArray1[i][3]
			document.getElementById(idSection).value=itemsArray1[i][5]
			document.getElementById(nameSection).value=itemsArray1[i][4]
			document.getElementById(stockInVar).value=itemsArray1[i][6]
			alert(itemsArray1[i][6])
			document.getElementById(stockInVarTemp).value=itemsArray1[i][6]
				}
		}
}

//This is the function to get the details of indent soc tracker
//In this function we are checking the selected Indent no ,Department,Item Name
//Based on the data we are calling AJAX submit method
	function checkAndCallAjaxSubmit(){
		var indentId=0;
		var departmentId=0;
		var itemId = 0;
		var errorMessage="";
		
		if(document.getElementById('indentId').value == 0)
			errorMessage=errorMessage+"Please Select Indent No \n"; 
		if(document.getElementById('departmentId').value == 0)
			errorMessage=errorMessage+"Please Select Department  \n";
		if(document.getElementById('itemId').value == "")
			errorMessage=errorMessage+"Please Select Item  \n";
			
		departmentId=document.getElementById('departmentId').value;
		indentId=document.getElementById('indentId').value; 
		itemId=document.getElementById('itemId').value;  
		if((indentId!=0)&&(departmentId!=0)&&(itemId!=0)){
		submitProtoAjax('indentSocTracker','/hms/hms/stores?method=getIndentSocTrackerDetails&departmentId='+departmentId+'&indentId='+indentId+'&itemId='+itemId);
		}else{
		alert(errorMessage);
		return false
		}
		if(errorMessage!=""){
		alert(errorMessage);
		return false
		}
	}
 //This used to fill item value in a row based on Nomenclature
	function fillItemsInPOByName(nomenclature,rowVal){
		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idAu="idAu";
    	
    	var pageNo=parseInt(document.getElementById('noOfRows').value);
     	rowVal=rowVal%10
     
     	if(rowVal==0){
      		rowVal=10
       }
     if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
      	document.getElementById('noOfRows').value=rowVal
   	 }
    	
    	idItem=idItem+rowVal;
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	idAu=idAu+rowVal;
    	
		for(i=0;i<itemsArray1.length;i++){
		
		if(itemsArray1[i][2]==nomenclature){
			
			document.getElementById(idItem).value=itemsArray1[i][0]
			document.getElementById(codeItem).value=itemsArray1[i][1]
			document.getElementById(idAu).value=itemsArray1[i][3]
			
				}
		}
}

function fillIndentDetails(indentId,rowVal){
		
		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idAu="idAu";
    	var qtyReqquested="qtyReqquested";
    	var incVar="incVar";
    	
    	var idItem2="idItem";
    	var codeItem2="codeItem";
    	var nameItem2="nameItem";
    	var idAu2="idAu";
    	var qtyReqquested2="qtyReqquested";
    	var incVar2="incVar";
    	j=0;
    	
    	
		for(i=0;i<indentArray.length;i++){
		
		if(indentArray[i][0]==indentId){
			
			idItem=idItem2+(rowVal+j);
			
    		codeItem=codeItem2+(rowVal+j);
    		nameItem=nameItem2+(rowVal+j);
    		idAu=idAu2+(rowVal+j);
    		qtyReqquested=qtyReqquested2+(rowVal+j);
    	
			document.getElementById(idItem).value=indentArray[i][6]
			document.getElementById(codeItem).value=indentArray[i][1]
			document.getElementById(nameItem).value=indentArray[i][2]
			document.getElementById(idAu).value=indentArray[i][3]
			document.getElementById(qtyReqquested).value=indentArray[i][4]
			j++;
		
		}
		
		 idItem="idItem";
    	 codeItem="codeItem";
    	 nameItem="nameItem";
    	 idAu="idAu";
    	 qtyReqquested="qtyReqquested";
    	 incVar="incVar";
    	
    	 idItem2="idItem";
    	 codeItem2="codeItem";
    	 nameItem2="nameItem";
    	 idAu2="idAu";
    	 qtyReqquested2="qtyReqquested";
    	 incVar2="incVar";
    	 
		for(i=j;i<8;i++){
			idItem=idItem2+(rowVal+i);
			codeItem=codeItem2+(rowVal+i);
    		nameItem=nameItem2+(rowVal+i);
    		idAu=idAu2+(rowVal+i);
			document.getElementById(idItem).value=""
			document.getElementById(codeItem).value=""
			document.getElementById(nameItem).value=""
			document.getElementById(idAu).value=""
			
		
		}
		
		}

}

function setHeaderValuesInWindow(){
	document.getElementById('requestType').value =window.opener.document.getElementById('requestType').value ; 
   document.getElementById('issueType').value=window.opener.document.getElementById('issueType').value ;
   document.getElementById('docType').value=window.opener.document.getElementById('docType').value ;
   document.getElementById('issueNo').value=window.opener.document.getElementById('issueNo').value ;
   document.getElementById('issueDate').value=window.opener.document.getElementById('issueDate').value ;
   document.getElementById('departmentId').value=window.opener.document.getElementById('departmentId').value ;
   document.getElementById('departmentIdTemp').value=window.opener.document.getElementById('departmentIdTemp').value ;
   document.getElementById('departmentIndentId').value=window.opener.document.getElementById('departmentIndentId').value ;
   document.getElementById('requestNo').value=window.opener.document.getElementById('requestNo').value ;
   document.getElementById('requestDate').value=window.opener.document.getElementById('requestDate').value ;
   document.getElementById('requestBy').value=window.opener.document.getElementById('requestBy').value ;
   document.getElementById('approvedBy').value=window.opener.document.getElementById('approvedBy').value ;
   document.getElementById('issuedBy').value=window.opener.document.getElementById('issuedBy').value ;
   document.getElementById('docNo').value=window.opener.document.getElementById('docNo').value ;
   
   
   return true;
}
function setHeaderValuesInWindowManual(){
	document.getElementById('requestType').value =window.opener.document.getElementById('requestType').value ; 
   document.getElementById('issueType').value=window.opener.document.getElementById('issueType').value ;
   document.getElementById('docType').value=window.opener.document.getElementById('docType').value ;
   document.getElementById('issueNo').value=window.opener.document.getElementById('issueNo').value ;
   document.getElementById('issueDate').value=window.opener.document.getElementById('issueDate').value ;
   document.getElementById('departmentId').value=window.opener.document.getElementById('departmentId').value ;
   document.getElementById('departmentIdTemp').value=window.opener.document.getElementById('departmentIdTemp').value ;
   document.getElementById('docNo').value=window.opener.document.getElementById('docNo').value ;
   document.getElementById('requestNo').value=window.opener.document.getElementById('requestNo').value ;
   document.getElementById('requestDate').value=window.opener.document.getElementById('requestDate').value ;
   document.getElementById('requestBy').value=window.opener.document.getElementById('requestBy').value ;
   document.getElementById('approvedBy').value=window.opener.document.getElementById('approvedBy').value ;
   document.getElementById('issuedBy').value=window.opener.document.getElementById('issuedBy').value ;
   return true;
}

function fillItemsInIssueManual(nameValue,rowVal){
		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idAu="idAu";
    	var issuedName="issuedName";
    	issuedName = issuedName+rowVal;
    	idItem=idItem+rowVal;
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	idAu=idAu+rowVal;
    	
		for(i=0;i<itemsArray1.length;i++){
		if(itemsArray1[i][2]==nameValue){
		document.getElementById(idItem).value=itemsArray1[i][0]
		document.getElementById(codeItem).value=itemsArray1[i][1]
		document.getElementById(idAu).value=itemsArray1[i][3]
		document.getElementById(issuedName).value=itemsArray1[i][2]
		
		}
		}

}
//This used to fill item value in a row based on Nomenclature
	function fillItemsInDGFMSHQByName(nomenclature,rowVal){
		
		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idAu="idAu";
    	var nameItemForFocus="nameItem";
    	var idSection="idSection";
    	var stockInVar="stockInVar";
		var n="nameItem";
    	idItem=idItem+rowVal;
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	idAu=idAu+rowVal
    	idSection=idSection+rowVal;
    	stockInVar=stockInVar+rowVal;
    	
    		if(nomenclature==""){
    		alert("Nomenclature Can not be empty")
    		document.getElementById(nameItem).focus();
			return false;
			}
	   	 	
    	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%8
   		
   		if(rowVal==0){
   			rowVal=8
   	 		
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
    	
		for(i=0;i<itemsArray1.length;i++){
		
		if(itemsArray1[i][2]==nomenclature){
			
			document.getElementById(idItem).value=itemsArray1[i][0]
			document.getElementById(codeItem).value=itemsArray1[i][1]
			document.getElementById(idAu).value=itemsArray1[i][3]
			
				}
		}
}

function fillItems(idVal,rowVal){
  		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idSection="idSection";
    	var nameSection="nameSection";
    	var idAu="idAu";
    	
    	idItem=idItem+rowVal;
    	
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	
    	idSection=idSection+rowVal;
    	nameSection=nameSection+rowVal;
    	idAu=idAu+rowVal;
    	
    	document.getElementById('noOfRows').value=rowVal
		for(i=0;i<itemsArray1.length;i++){
		if(itemsArray1[i][0]==idVal){
			
		document.getElementById(idItem).value=itemsArray1[i][0]
		document.getElementById(nameItem).value=itemsArray1[i][2]
		document.getElementById(idAu).value=itemsArray1[i][3]
		document.getElementById(nameSection).value=itemsArray1[i][4]
		document.getElementById(idSection).value=itemsArray1[i][5]
		}
		}
	
  }
  function fillItems2(idVal,rowVal){
  		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idSection="idSection";
    	var nameSection="nameSection";
    	var idAu="idAu";
    	
    	idItem=idItem+rowVal;
    	
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	
    	idSection=idSection+rowVal;
    	nameSection=nameSection+rowVal;
    	idAu=idAu+rowVal;
    	if(document.getElementById('noOfRows').value<rowVal)
    	document.getElementById('noOfRows').value=rowVal
		for(i=0;i<itemsArray1.length;i++){
		if(itemsArray1[i][0]==idVal){
			
		document.getElementById(idItem).value=itemsArray1[i][0]
		document.getElementById(nameItem).value=itemsArray1[i][2]
		document.getElementById(idAu).value=itemsArray1[i][3]
		
		}
		}
	openPopup(idVal,333);
  }
function fillValuesForMmf(inc)
  {
   	if(document.getElementById('mmfVarTemp'+inc).value!="")
    	document.getElementById('mmfVar'+inc).value=document.getElementById('mmfVarTemp'+inc).value
  }
  function fillValuesForDemand(inc)
  {
	  alert(document.getElementById('demandVar'+inc).value);
	if(document.getElementById('demandVar'+inc).value!="")
    	document.getElementById('demandVarTemp'+inc).value=document.getElementById('demandVar'+inc).value
  }
  function checkForNext()
  {
  if(document.getElementById('noOfRows').value<8)
  {
  	alert("All rows are not filled.To continue press Submit ")
  	return false;
  }else{
  return true;
  }
  }
  
 function checkForSubmit(){
  if(document.getElementById('noOfRows').value==0)
  {alert("There must be one detail row");
  return false;
  }else{
  return true;
  }
  }
  function openPopupForBrand(issuedItem,qtyRequested,rowVal,issueId,detailId)
 {

	var issuedQty = parseFloat(document.getElementById("qtyIssued"+rowVal).value);
	var nomenclature=document.getElementById("nameItem"+rowVal).value
	var pvms=document.getElementById("codeItem"+rowVal).value
	var departmentIdTemp=document.getElementById('departmentIdTemp').value
	if(nomenclature != "" && pvms !="" )
	{
		var issuedItemId=document.getElementById("issuedItemId"+rowVal).value
		var itemId=document.getElementById("idItem"+rowVal).value
		var qtyRequested=document.getElementById("qtyRequested"+rowVal).value

	//	var loanOutQty=document.getElementById("loanOutQty"+rowVal).value

		
		var issueNo=document.getElementById("issueNo").value
		var url="/hms/hms/stores?method=openItemBrandWindowJsp&itemId="+itemId+"&qtyRequest="+qtyRequested+"&rowVal="+rowVal+"&issuedItemId="+itemId+"&issueId="+issueId+"&detailId="+detailId+"&issueNo="+issueNo+"&nomenclature="+encodeURIComponent(nomenclature)+"&pvms="+pvms+"&issuedQty="+issuedQty+"&departmentIdTemp="+departmentIdTemp;
	 //  	popwindow(url);
	 newwindow=window.open(url,'name',"height=550,width=1000,status=1,scrollbars=1");
	}
	else
	{
	  alert("Please Enter pvms Or nomenclature to view Stock details")
	}
}
  
 	function openPopupForBrandForLoanOut(rowVal)
	{
	var issueNo=document.getElementById('issueNo').value
	var isssueDate=document.getElementById('isssueDate').value
	var departmentIdTemp=document.getElementById('departmentIdTemp').value
	//var patientName=document.getElementById('patientName').value
	var requestBy=document.getElementById('requestBy').value
	//var approvedBy=document.getElementById('approvedBy').value
	var issuedBy=document.getElementById('issuedBy').value
	//var docNo=document.getElementById('docNo').value
	var issueId=document.getElementById('issueId').value
	var errorMessage="";
			
		if(document.getElementById('issueNo').value == "")
			errorMessage=errorMessage+"Please Fill Issue No \n"; 
			
		if(document.getElementById('isssueDate').value == "")
			errorMessage=errorMessage+"Please fill  Isssue Date \n";
			
		if(document.getElementById('departmentIdTemp').value == "")
			errorMessage=errorMessage+"Please Select Department \n";
			
		
		if(document.getElementById('requestBy').value == "")
			errorMessage=errorMessage+"Please Select requestBy \n";
		
	//	if(document.getElementById('approvedBy').value == "")
		//	errorMessage=errorMessage+"Please Select approvedBy \n";
			
		if(document.getElementById('issuedBy').value == "")
			errorMessage=errorMessage+"Please Select issuedBy \n";
				
		//if(document.getElementById('docNo').value == "")
		//	errorMessage=errorMessage+"Please Fill reference no \n";			
		
		
	if(errorMessage!=""){
		alert(errorMessage)
		return false
	}else{
		if(document.getElementById("qtyIssued"+rowVal).value>0){
		alert("Already Issued..!")
	//return false
	}
	var itemId=document.getElementById("idItem"+rowVal).value
	alert("javed "+itemId)
	if(itemId==0){
	alert("Select Item First..!")
	return false;
	}

	//var url="/hms/hms/stores?method=openItemBrandWindowJspForLoanOut&itemId="+itemId+"&rowVal="+rowVal+"&issueNo="+issueNo+"&isssueDate="+isssueDate+"&departmentIdTemp="+departmentIdTemp+"&patientName="+patientName+"&requestBy="+requestBy+"&approvedBy="+approvedBy+"&issuedBy="+issuedBy+"&docNo="+docNo+"&issueId="+issueId;
	var url="/hms/hms/stores?method=openItemBrandWindowJspForLoanOut&itemId="+itemId+"&rowVal="+rowVal+"&issueNo="+issueNo+"&isssueDate="+isssueDate+"&departmentIdTemp="+departmentIdTemp+"&requestBy="+requestBy+"&issuedBy="+issuedBy+"&issueId="+issueId;
	
   popwindow(url);	
 }
}

function openPopupForBrandForOtherUnits(rowVal){
	var requestBy='';
	var qtyRequested='';
var issueNo=document.getElementById('issueNo').value
var isssueDate=document.getElementById('isssueDate').value

var nomenclature=document.getElementById("nameItem"+rowVal).value
var pvms=document.getElementById("codeItem"+rowVal).value
	
var departmentIdTemp=document.getElementById('departmentIdTemp').value
if(document.getElementById('requestBy'))
{
	requestBy=document.getElementById('requestBy').value
}
//this is has beean changed
//var approvedBy=document.getElementById('approvedBy').value
var issuedBy=document.getElementById('issuedBy').value
//var docNo=document.getElementById('docNo').value
var issueId=document.getElementById('issueId').value
if(document.getElementById('demandVar'+rowVal))
	qtyRequested=document.getElementById('demandVar'+rowVal).value
var errorMessage="";
		
		if(document.getElementById('issueNo').value == "")
			errorMessage=errorMessage+"Please Fill Issue No \n"; 
			
		if(document.getElementById('isssueDate').value == "")
			errorMessage=errorMessage+"Please fill  Isssue Date \n";
			
		if(document.getElementById('departmentIdTemp').value == "")
			errorMessage=errorMessage+"Please Select Department \n";
		
		if(document.getElementById('demandVar'+rowVal).value=='0' ){
			errorMessage=errorMessage+"Please Select Demand qty \n";
		}
		
		//if(document.getElementById('requestBy').value == "")
			//errorMessage=errorMessage+"Please Select requestBy \n";
		
	/*	if(document.getElementById('approvedBy').value == "")
			errorMessage=errorMessage+"Please Select approvedBy \n";
			*/
		if(document.getElementById('issuedBy').value == "")
			errorMessage=errorMessage+"Please Select issuedBy \n";
	/*			
		if(document.getElementById('docNo').value == "")
			errorMessage=errorMessage+"Please Fill reference no \n";		*/	
		
if(errorMessage!=""){
	alert(errorMessage)
	return false
}else{
		//if(document.getElementById("qtyIssued"+rowVal).value>0){
	//alert("Already Issued..!")
	//return false
	//}
	var itemId=document.getElementById("idItem"+rowVal).value
	if(itemId==0){
	alert("Select Item First..!")
	return false;
	}

	var url="/hms/hms/stores?method=openItemBrandWindowJspToOtherUnits&itemId="+itemId+"&rowVal="+rowVal+"&issueNo="+issueNo+"&isssueDate="+isssueDate+"&departmentIdTemp="+departmentIdTemp+"&requestBy="+requestBy+"&issuedBy="+issuedBy+"&issueId="+issueId+"&nomenclature="+encodeURIComponent(nomenclature)+"&pvms="+pvms+"&qtyRequest="+qtyRequested;
	
   popwindow(url);	
	}

}

function get_valueInModify(rowVal){
	document.getElementById('currentRow').value=rowVal
	var itemId=document.getElementById("idItem"+rowVal).value
	var detailId=document.getElementById("detailId"+rowVal).value
	var manuId=document.getElementById("manuId"+rowVal).value
	var brandId=document.getElementById("brandId"+rowVal).value
	if(itemId==0){
	alert("Plz Select Nomenclature")
	return false
	}
	var url="/hms/hms/stores?method=getBrandListForSOCModify&itemId="+itemId+"&detailId="+detailId+"&manuId="+manuId+"&brandId="+brandId;
   	popwindow(url);
	
}
function get_value(rowVal)
{


var itemId=document.getElementById("idItem"+rowVal).value
if(itemId==0){
alert("Plz Selsct Nomenclature")
return false
}
 var url="/hms/hms/stores?method=getBrandListForSOC&itemId="+itemId;
   popwindow(url);
 }  

var newwindow;
function popwindow(url)
{
 newwindow=window.open(url,'name',"height=550,width=950,status=1");
}

//=====================For Issue To OTAFU==================
function openPopupForBrandForOTAFU(rowVal){
var issueNo=document.getElementById('issueNo').value
var isssueDate=document.getElementById('isssueDate').value
var departmentIdTemp=document.getElementById('departmentIdTemp').value
var requestBy=document.getElementById('requestBy').value
var approvedBy=document.getElementById('approvedBy').value
var issuedBy=document.getElementById('issuedBy').value
var docNo=document.getElementById('docNo').value
var issueId=document.getElementById('issueId').value
var errorMessage="";
		
		if(document.getElementById('issueNo').value == "")
			errorMessage=errorMessage+"Please Fill Issue No \n"; 
			
		if(document.getElementById('isssueDate').value == "")
			errorMessage=errorMessage+"Please fill  Isssue Date \n";
			
		if(document.getElementById('departmentIdTemp').value == "")
			errorMessage=errorMessage+"Please Select Unit \n";
		
		if(document.getElementById('requestBy').value == "")
			errorMessage=errorMessage+"Please Select requestBy \n";
		
		if(document.getElementById('approvedBy').value == "")
			errorMessage=errorMessage+"Please Select approvedBy \n";
			
		if(document.getElementById('issuedBy').value == "")
			errorMessage=errorMessage+"Please Select issuedBy \n";
				
		if(document.getElementById('docNo').value == "")
			errorMessage=errorMessage+"Please Fill reference no \n";			
		
if(errorMessage!=""){
	alert(errorMessage)
	return false
}else{
		if(document.getElementById("qtyIssued"+rowVal).value>0){
	alert("Already Issued..!")
	return false
	}
	var itemId=document.getElementById("idItem"+rowVal).value
	if(itemId==0){
	alert("Select Item First..!")
	return false;
	}

	var url="/hms/hms/stores?method=openItemBrandWindowJspIssueToOTAFU&itemId="+itemId+"&rowVal="+rowVal+"&issueNo="+issueNo+"&isssueDate="+isssueDate+"&departmentIdTemp="+departmentIdTemp+"&requestBy="+requestBy+"&approvedBy="+approvedBy+"&issuedBy="+issuedBy+"&docNo="+docNo+"&issueId="+issueId;
	
   popwindow(url);	
	}

}

function openDeletePopupForIssueOTAFU()
{
	var issueId = document.getElementById('issueId').value;
	if (issueId==0)
	{
	alert("Pl. select the Issue No thru Search Option!....");
	return;
	}
	
	var url="/hms/hms/stores?method=openDeletePopupForIssueToOTAFU&issueId="+issueId+"&firstTime=1";
  	newwindow=window.open(url,'name',"height=900,width=900,status=1");

}
function calculateTotalForSoc(rowVal){
	if(document.getElementById('qtyTemp'+rowVal).value != ''){
	var quantity=parseInt(document.getElementById("qtyTemp"+rowVal).value)
	document.getElementById("lastRecpQty"+rowVal).value=parseInt(document.getElementById("qtyTemp"+rowVal).value)
	}
	else{
	var quantity=0
	document.getElementById("lastRecpQty"+rowVal).value =0
	}
	if(document.getElementById("unitRate"+rowVal).value != '')
	var unitRate=parseInt(document.getElementById("unitRate"+rowVal).value)
	else
	var unitRate=0
	document.getElementById("totalCost"+rowVal).value=unitRate*quantity
	document.getElementById("totalCostTemp"+rowVal).value=unitRate*quantity
	
	
}

 //-----------------------------------------------------------------------------------------------------------------
 //-------------------------------------End of Functions Written By Vivek-------------------------------------------
 //-----------------------------------------------------------------------------------------------------------------
 
 
 //-----------------------------------------------------------------------------------------------------------------
 //-------------------------------------Start of Functions Written By DEEPTI TEVATIA-------------------------------------------
 //-----------------------------------------------------------------------------------------------------------------
 
 
 //This used to fill item value in a row based on Nomenclature
	function fillItemsInPOByName(nomenclature,rowVal){
		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idAu="idAu";
    	
    	var pageNo=parseInt(document.getElementById('noOfRows').value);
     	rowVal=rowVal%10
     
     	if(rowVal==0){
      		rowVal=10
       }
     if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
      	document.getElementById('noOfRows').value=rowVal
   	 }
    	
    	idItem=idItem+rowVal;
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	idAu=idAu+rowVal;
    	
		for(i=0;i<itemsArray1.length;i++){
		
		if(itemsArray1[i][2]==nomenclature){
			
			document.getElementById(idItem).value=itemsArray1[i][0]
			document.getElementById(codeItem).value=itemsArray1[i][1]
			document.getElementById(idAu).value=itemsArray1[i][3]
			
				}
		}
}

function calculateAmount(rowVal){
var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*10)+1;
    	var end=((pageNo-1)*10)+10;
	var quantity = parseFloat(document.getElementById('quantityInVarTemp'+rowVal).value)
	var unitRate = parseFloat(document.getElementById('unitRateVarTemp'+rowVal).value)
	var ratePerMdq = parseFloat(document.getElementById('ratePerMdq'+rowVal).value)
	var discount = parseFloat(document.getElementById('discountVarTemp'+rowVal).value)
	var tax = parseFloat(document.getElementById('taxVarTemp'+rowVal).value)
	
	var pageTotal = parseFloat(document.getElementById('pageTotal').value)
	var overallTotal = parseFloat(document.getElementById('overallTotal').value)
	
	var total;
	var disc;
	var amountAfterdiscount;
	var amountAfterTax;
	var netAmount;
	total = quantity*ratePerMdq;
	
	if(!isNaN(quantity) && !isNaN(unitRate) && !isNaN(discount) && !isNaN(tax)){
		disc = total*(discount/100);
		amountAfterdiscount = total-disc;
		amountAfterTax = (amountAfterdiscount)*(tax/100)
		netAmount = amountAfterdiscount+amountAfterTax;
		document.getElementById('amountVarTemp'+rowVal).value=Math.round(netAmount*100)/100
	}else if(!isNaN(quantity) == "" && !isNaN(unitRate) == ""){
		//alert("Please Enter Both Quantity and Unit Rate.");
	}else if(!isNaN(quantity) != "" && !isNaN(unitRate) == ""){
		//alert("Please Enter Unit Rate.");
	}else if(!isNaN(quantity) == "" && !isNaN(unitRate) != ""){
		//alert("Please Enter Quantity.");
	}else if(!isNaN(discount) == "" && !isNaN(tax) == ""){
		document.getElementById('amountVarTemp'+rowVal).value=Math.round(total*100)/100
	}else if(!isNaN(discount) == "" || !isNaN(tax) != ""){
		netAmount = total+(total*(tax/100));
		document.getElementById('amountVarTemp'+rowVal).value=Math.round(netAmount*100)/100
	}
	else if(!isNaN(discount) != "" || !isNaN(tax) == ""){
		disc = total*(discount/100);
		amountAfterdiscount = total-disc;
		netAmount = amountAfterdiscount;
		document.getElementById('amountVarTemp'+rowVal).value=Math.round(netAmount*100)/100
	}

    var totalAmount =parseFloat(0);
    for(var r=1;r<=10;r++)
    {
	   	 if(document.getElementById('amountVarTemp'+r).value == "")
	   	 {
	   	 	
	   	 }
	   	 else
	   	 {
		   	 var freeItem = document.getElementById('freeItem'+r).value;
		   	 if (freeItem=='n') totalAmount = totalAmount +parseFloat(document.getElementById('amountVarTemp'+r).value)
		 }
    }
   
   
   if( document.getElementById('totalAmountTemp').value !=""){
	//document.getElementById('total_amount').value = parseFloat(document.getElementById('totalAmountTemp').value)+totalAmount
	document.getElementById('total_amount').value = (overallTotal - pageTotal) + totalAmount
	}else{
	document.getElementById('total_amount').value =totalAmount
	} 
	
	document.getElementById('amountVar'+rowVal).value = document.getElementById('amountVarTemp'+rowVal).value;
}

function calculateAmountForAdd(rowVal){
var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*10)+1;
    	var end=((pageNo-1)*10)+10;
	var quantity = parseFloat(document.getElementById('quantityInVarTemp'+rowVal).value)
	var unitRate = parseFloat(document.getElementById('unitRateVarTemp'+rowVal).value)
	var ratePerMdq = parseFloat(document.getElementById('ratePerMdq'+rowVal).value)
	var discount = parseFloat(document.getElementById('discountVarTemp'+rowVal).value)
	var tax = parseFloat(document.getElementById('taxVarTemp'+rowVal).value)
	var total;
	var disc;
	var amountAfterdiscount;
	var amountAfterTax;
	var netAmount;
	total = quantity*ratePerMdq;
	
	if(!isNaN(quantity) && !isNaN(ratePerMdq) && !isNaN(discount) && !isNaN(tax)){
		disc = total*(discount/100);
		amountAfterdiscount = total-disc;
		amountAfterTax = (amountAfterdiscount)*(tax/100)
		netAmount = amountAfterdiscount+amountAfterTax;
		document.getElementById('amountVarTemp'+rowVal).value=Math.round(netAmount*100)/100;
	}else if(!isNaN(quantity) == "" && !isNaN(ratePerMdq) == ""){
		//alert("Please Enter Both Quantity and Unit Rate.");
	}else if(!isNaN(quantity) != "" && !isNaN(ratePerMdq) == ""){
		//alert("Please Enter Unit Rate.");
	}else if(!isNaN(quantity) == "" && !isNaN(ratePerMdq) != ""){
		//alert("Please Enter Quantity.");
	}else if(!isNaN(discount) == "" && !isNaN(tax) == ""){
		document.getElementById('amountVarTemp'+rowVal).value=Math.round(total*100)/100;
	}else if(!isNaN(discount) == "" || !isNaN(tax) != ""){
		netAmount = total+(total*(tax/100));
		document.getElementById('amountVarTemp'+rowVal).value=Math.round(netAmount*100)/100;
	}
	else if(!isNaN(discount) != "" || !isNaN(tax) == ""){
		disc = total*(discount/100);
		amountAfterdiscount = total-disc;
		netAmount = amountAfterdiscount;
		document.getElementById('amountVarTemp'+rowVal).value=Math.round(netAmount*100)/100;
	}

	var totalAmount =parseFloat(0);
    for(var r=1;r<=10;r++)
    {
	   	 if(document.getElementById('amountVarTemp'+r).value == "")
	   	 {
	   	 	
	   	 }
	   	 else
	   	 {
		   	 var freeItem = document.getElementById('freeItem'+r).value;
		   	 if (freeItem=='n') totalAmount = totalAmount +parseFloat(document.getElementById('amountVarTemp'+r).value)
		 }
    }
   
   if( document.getElementById('totalAmountTemp').value !=""){
	document.getElementById('total_amount').value = parseFloat(document.getElementById('totalAmountTemp').value)+totalAmount
	}else{
	document.getElementById('total_amount').value =totalAmount
	}
	document.getElementById('amountVar'+rowVal).value =  document.getElementById('amountVarTemp'+rowVal).value;
}


function setHeaderValuesForReturnDispensary(rowVal){
	document.getElementById('itemId').value =window.opener.document.getElementById('itemId'+rowVal).value ;
	document.getElementById('date').value=window.opener.document.getElementById('date').value ;
	document.getElementById('time').value=window.opener.document.getElementById('time').value ;
	document.getElementById('returnNo').value=window.opener.document.getElementById('returnNo').value ;
	document.getElementById('returnDate').value=window.opener.document.getElementById('returnDate').value ;
	document.getElementById('referenceNo').value=window.opener.document.getElementById('referenceNo').value ;
	document.getElementById('fromWard').value=window.opener.document.getElementById('fromWard').value ;
	document.getElementById('toWard').value=window.opener.document.getElementById('toWard').value ;
	
	document.getElementById('receiveBy').value=window.opener.document.getElementById('receiveBy').value ;
	document.getElementById('returnBy').value=window.opener.document.getElementById('returnBy').value ;
	
	document.getElementById('reason').value=window.opener.document.getElementById('reason').value ;
	document.getElementById('remarks').value=window.opener.document.getElementById('remarks').value ;
	
	document.getElementById('storeFyDocumentNoId').value=window.opener.document.getElementById('storeFyDocumentNoId').value ;
	//document.getElementById('deptId').value=window.opener.document.getElementById('deptId').value ;
 
   
   return true;
}
 
 function setHeaderValuesForVendorReturn(rowVal){
	document.getElementById('returnDate').value=window.opener.document.getElementById('returnDate').value ;
	document.getElementById('referenceNo').value=window.opener.document.getElementById('referenceNo').value ;
	document.getElementById('vendorId').value =window.opener.document.getElementById('vendorId').value ;
	document.getElementById('SONo').value =window.opener.document.getElementById('SONo').value ;
	document.getElementById('returnBy').value=window.opener.document.getElementById('returnBy').value ;
	document.getElementById('approvedBy').value=window.opener.document.getElementById('approvedBy').value ;
	document.getElementById('reason').value=window.opener.document.getElementById('reason').value ;
	document.getElementById('remarks').value=window.opener.document.getElementById('remarks').value ;
	document.getElementById('storeGrnReturnMId').value=window.opener.document.getElementById('storeGrnReturnMId').value ;
	document.getElementById('returnNo').value=window.opener.document.getElementById('returnNo').value ;
	document.getElementById('itemId').value =window.opener.document.getElementById('itemId'+rowVal).value ;
   return true;
}
 
 
 function fillValuesLocal(inc)
  {
  	 	var quantityInVar = "quantityInVar";
    	var taxVar = "taxVar";
    	var unitRateVar = "unitRateVar";
    	var amountVar = "amountVar";
    	var discountVar = "discountVar";
    	
    	var quantityInVarTemp = "quantityInVarTemp";
    	var taxVarTemp = "taxVarTemp";
    	var unitRateVarTemp = "unitRateVarTemp";
    	var amountVarTemp = "amountVarTemp";
    	var discountVarTemp = "discountVarTemp";
    	
    	document.getElementById(quantityInVar+inc).value=document.getElementById(quantityInVarTemp+inc).value
    	
    	if(document.getElementById(taxVarTemp+inc).value != ""){
    		document.getElementById(taxVar+inc).value=document.getElementById(taxVarTemp+inc).value
    	}else{
    		document.getElementById(taxVar+inc).value = 0;
    	}
    	
    	document.getElementById(unitRateVar+inc).value=document.getElementById(unitRateVarTemp+inc).value
    	if(document.getElementById(amountVarTemp+inc).value != ""){
    		document.getElementById(amountVar+inc).value=document.getElementById(amountVarTemp+inc).value
    	}else{
    		document.getElementById(amountVar+inc).value = 0;
    	}
    	if(document.getElementById(discountVarTemp+inc).value != ""){
    		document.getElementById(discountVar+inc).value=document.getElementById(discountVarTemp+inc).value
    	}else{
    		document.getElementById(discountVar+inc).value = 0;
    	}
  }
 
 
 
 //-----------------------------------------------------------------------------------------------------------------
 //-------------------------------------END of Functions Written By DEEPTI TEVATIA-------------------------------------------
 //-----------------------------------------------------------------------------------------------------------------
 
   //-----------------------------------------------------------------------------------------------------------------
 //-------------------------------------Start of Functions Written By Mansi-------------------------------------------
 //-----------------------------------------------------------------------------------------------------------------
 
 
function fillItemsInDepartmentIndent(nomenclature,rowVal){
	
		
		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idAu="idAu";
    	var nameItemForFocus="nameItem";
    	var stockInVar="stockInVar";
    	var n="nameItem";
		var departmentId="departmentId";
		var  qtyInHandTemp="qtyInHandTemp";
		var mmfVarTemp="mmfVarTemp";
		var qtyInHand="qtyInHand";
		qtyInHand=qtyInHand+rowVal
		mmfVarTemp=mmfVarTemp+rowVal
    	idItem=idItem+rowVal;
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	idAu=idAu+rowVal
      	qtyInHandTemp=qtyInHandTemp+rowVal
    	departmentId=departmentId+rowVal
    		if(nomenclature==""){
    		alert("Nomenclature Can not be empty")
    		document.getElementById(nameItem).focus();
			return false;
			}
	   	 	
	   	 	   	 	
    	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%8
   		
   		if(rowVal==0){
   			rowVal=8
   	 		
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
    	
		for(i=0;i<itemsArray1.length;i++){
		
		if(itemsArray1[i][2]==nomenclature){
		
			
			document.getElementById(idItem).value=itemsArray1[i][0]
			document.getElementById(codeItem).value=itemsArray1[i][1]
			document.getElementById(idAu).value=itemsArray1[i][6]
			if(itemsArray1[i][3]!="null"){
			document.getElementById(qtyInHand).value=itemsArray1[i][3]
			document.getElementById(qtyInHandTemp).value=itemsArray1[i][3]
			}
			else{
			document.getElementById(qtyInHand).value="0"
			document.getElementById(qtyInHandTemp).value="0"
			}
			if(itemsArray1[i][4]!="null"){
			document.getElementById(mmfVarTemp).value=itemsArray1[i][4]
			}else{
			document.getElementById(mmfVarTemp).value=0
			}
			
			
			
				}
		}
}

function fillItemsInOpeningBalance(nomenclature,rowVal){
	
		
		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idAu="idAu";
    	var nameItemForFocus="nameItem";
    	
    	var n="nameItem";
		
    	idItem=idItem+rowVal;
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	idAu=idAu+rowVal
      	
    		if(nomenclature==""){
    		alert("Nomenclature Can not be empty")
    		document.getElementById(nameItem).focus();
			return false;
			}
	   	 	
	   	 	   	 	
    	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%8
   		
   		if(rowVal==0){
   			rowVal=8
   	 		
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
    	
		for(i=0;i<itemsArray1.length;i++){
		
		if(itemsArray1[i][2]==nomenclature){
		
			
			document.getElementById(idItem).value=itemsArray1[i][0]
			document.getElementById(codeItem).value=itemsArray1[i][1]
			document.getElementById(idAu).value=itemsArray1[i][3]
			
			
			
			
				}
		}
}

function fillItemsInMmfDepartment(nomenclature,rowVal)
{
		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idAu="idAu";
    	var nameItemForFocus="nameItem";
    	idItem=idItem+rowVal;
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	idAu=idAu+rowVal
      		if(nomenclature==""){
    		alert("Nomenclature Can not be empty")
    		document.getElementById(nameItem).focus();
			return false;
			}
	   	 	
    	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%8
   		
   		if(rowVal==0){
   			rowVal=8
   	 		
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
    	
		for(i=0;i<itemsArray1.length;i++){
		
		if(itemsArray1[i][2]==nomenclature){
		
			
			document.getElementById(idItem).value=itemsArray1[i][0]
			document.getElementById(codeItem).value=itemsArray1[i][1]
			document.getElementById(idAu).value=itemsArray1[i][3]
			
			
			
				}
		}
}
function fillValuesRemarks(inc)
  {
    	
    	var remarksVar="remarksVar";
    	var remarksVarTemp="remarksVarTemp";
    	
    	
    	
    	   	
    if(document.getElementById(remarksVarTemp+inc).value!=""){
      		document.getElementById(remarksVar+inc).value=document.getElementById(remarksVarTemp+inc).value
     }
     else
      		document.getElementById(remarksVar+inc).value="emptyString";
     

   
    
  }
  
  function fillItemsInStoreBalance(nomenclature,rowVal){
  
  	 var idItem="idItem";
     var codeItem="codeItem";
     var nameItem="nameItem";
     var idAu="idAu";
     var idBrand="idBrand";
      var nameBrand="nameBrand";
  	 var rowValTemp=rowVal
     idItem=idItem+rowVal;
     codeItem=codeItem+rowVal;
     nameItem=nameItem+rowVal;
     idAu=idAu+rowVal;
     idBrand=idBrand+rowVal;
     nameBrand=nameBrand+rowVal;
     if(nomenclature==""){
      alert("Nomenclature Can not be empty")
      document.getElementById(nameItem).focus();
 	 return false;
 	  }
     
  for(i=0;i<itemsArray1.length;i++){
  
  if(itemsArray1[i][2]==nomenclature){
   
   var itemId= itemsArray1[i][0]
   document.getElementById(idItem).value=itemsArray1[i][0]
   document.getElementById(codeItem).value=itemsArray1[i][1]
   document.getElementById(idAu).value=itemsArray1[i][3]
   document.getElementById(idBrand).value=itemsArray1[i][5]
   
   
    }
  }
  
   var pageNo=parseInt(document.getElementById('noOfRows').value);
     rowVal=rowVal%8
     
     if(rowVal==0){
      rowVal=8
       
       }
     if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
      document.getElementById('noOfRows').value=rowVal
   }
  
 populateBrand(itemId,rowValTemp) 
 
}


 



function showLastDemandNo(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=lastDemandNo";
  obj.submit();
}

function showLastDocNo(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=lastDocNo";
  obj.submit();
}



function fillItemsInMMF(nomenclature,rowVal){
		
		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idAu="idAu";
    			
    	idItem=idItem+rowVal;
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	idAu=idAu+rowVal
    	
    		if(nomenclature==""){
    		alert("Nomenclature Can not be empty")
    		document.getElementById(nameItem).focus();
			return false;
			}
	   	 	
    	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%8
   		
   		if(rowVal==0){
   			rowVal=8
   	 		
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
    	
		for(i=0;i<itemsArray1.length;i++){
		
		if(itemsArray1[i][2]==nomenclature){
			
			document.getElementById(idItem).value=itemsArray1[i][0]
			document.getElementById(codeItem).value=itemsArray1[i][1]
			document.getElementById(idAu).value=itemsArray1[i][3]
			
				}
		}
}

   function fillValuesHand(inc)
  {
    	var qtyInHand="qtyInHand";
    	var qtyInHandTemp="qtyInHandTemp";
    	document.getElementById(qtyInHand+inc).value=document.getElementById(qtyInHandTemp+inc).value
  }
  
  function fillValues(inc)
  {
    	var mmfVar="mmfVar";
    	var mmfVarTemp="mmfVarTemp";
    	document.getElementById(mmfVar+inc).value=document.getElementById(mmfVarTemp+inc).value
  }
  function fillValuesForDemand(inc)
  {
	if(document.getElementById('demandVar'+inc).value!="")
    	document.getElementById('demandVarTemp'+inc).value=document.getElementById('demandVar'+inc).value
  }
  
   //-----------------------------------------------------------------------------------------------------------------
 //-------------------------------------End of Functions Written By Mansi-------------------------------------------
 //-----------------------------------------------------------------------------------------------------------------
 
 
 
 
 
 
 //===================================================================
 //======================NEW FUNCTIONS BY ABHA  ======================
 //===================================================================
 //This used to fill item value in a row based on Code
	function fillItemsInGrn(nomenclature,rowVal){
		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idAu="idAu";
    	var idBrand="idBrand";
    	var nameBrand="nameBrand";
    	var expiry ="expiry";
   
    	idItem=idItem+rowVal;
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	idAu=idAu+rowVal;
    	idBrand=idBrand+rowVal;
    	nameBrand=nameBrand+rowVal;
    	expiry = expiry+rowVal;
    	
    	
    	if(nomenclature==""){
      alert("Nomenclature Can not be empty")
      document.getElementById(nameItem).focus();
   return false;
   }
    
     var pageNo=parseInt(document.getElementById('noOfRows').value);
     rowVal=rowVal%10
     
     if(rowVal==0){
      rowVal=10
       
       }
     if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
      document.getElementById('noOfRows').value=rowVal
   }
     
  for(i=0;i<itemsArray1.length;i++){
  
  if(itemsArray1[i][2]==nomenclature){
   
			var itemId= itemsArray1[i][0]
			document.getElementById(idItem).value=itemsArray1[i][0]
			document.getElementById(codeItem).value=itemsArray1[i][1]
			document.getElementById(idAu).value=itemsArray1[i][3]
			//document.getElementById(idBrand).value=itemsArray1[i][5]
			document.getElementById(expiry).value=itemsArray1[i][6]
			
				}
		}
		
	populateBrand(itemId,rowVal)	
	
}


	
function populateBrand(itemId,rowVal)
{

var idBrand="idBrand"+rowVal;
obj =document.getElementById(idBrand); 
obj.length = 1;
for(i=0;i<brandArray.length;i++){
	
	
		if(brandArray[i][0]==itemId){
		
			obj.length++;
			obj.options[obj.length-1].value=brandArray[i][1];
			obj.options[obj.length-1].text=brandArray[i][2];			
		}
	}
}

function populateManufacturer(brandId,rowVal)
{
var idManufacturer="idManufacturer"+rowVal;

obj =document.getElementById(idManufacturer); 
obj.length = 1;
for(i=0;i<manufacturerArray.length;i++){
	
	
		if(manufacturerArray[i][0]==itemId){
		
			obj.length++;
			obj.options[obj.length-1].value=manufacturerArray[i][1];
			obj.options[obj.length-1].text=manufacturerArray[i][2];			
		}
	}
}


function rate(rateandQuan,rowVal)
{
var rate=0;
var closingStock=0;
var freeQty=document.getElementById('freeQty'+rowVal).value.trim()
var quantity = parseInt(document.getElementById('quanRecTemp'+rowVal).value)

if(freeQty !='')
{
	rate=(rateandQuan)/(quantity+parseInt(freeQty))
	closingStock=(freeQty+quantity)
	document.getElementById('closingStock').value = closingStock
}
}
 
 // on change of source of supply list changes


function disableSourceOfSupply()
{
document.getElementById("sourceCombo").disabled = true;
document.getElementById("supplierCombo").disabled = true;
}

 
 // check for loan in
   
 function checkloanin(){
	  var sos =document.getElementById('sourceCombo').value
	  
	 if(sos == "l" |  sos=="w"){
	 
	  var invoiceAmount = document.getElementById('invoiceAmount').value.trim()
	  var grnValue = document.getElementById('grnValue').value.trim()
	  
	   if(invoiceAmount != grnValue ){
	 		if(confirm("Invoice Amount and CRV Amount Is not Equal.Enter Correct Invoice Amount."))
			 return false;
			//return true;
		else
			return false;
 		}
 			
 		}
	 return true;
 	}
 
 //This used to fill item value in a row based on Code
	function fillItemsInDefectiveDrugs(nomenclature,rowVal){
		
		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idAu="idAu";
    	var idBrand="idBrand";
    	var nameBrand="nameBrand";
    	var expiry ="expiry";
    	//var expiryDate ="expiryDate";
    	var batchNo="batchNo";
    	
   
    	idItem=idItem+rowVal;
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	idAu=idAu+rowVal;
    	idBrand=idBrand+rowVal;
    	nameBrand=nameBrand+rowVal;
    	expiry = expiry+rowVal;
    	//expiryDate = expiryDate+rowVal;
    	batchNo=batchNo+rowVal;
    	
    	
    	
    	if(nomenclature==""){
      alert("Nomenclature Can not be empty")
      document.getElementById(nameItem).focus();
   return false;
   }
    
     var pageNo=parseInt(document.getElementById('noOfRows').value);
     rowVal=rowVal%10
     
     if(rowVal==0){
      rowVal=10
       
       }
     if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
      document.getElementById('noOfRows').value=rowVal
   }
     var itemId =0;
  for(i=0;i<itemsArray1.length;i++){
  
  if(itemsArray1[i][2]==nomenclature){
   
			 itemId= itemsArray1[i][0]
			document.getElementById(idItem).value=itemsArray1[i][0]
			document.getElementById(codeItem).value=itemsArray1[i][1]
			document.getElementById(idAu).value=itemsArray1[i][3]
			document.getElementById(idBrand).value=itemsArray1[i][5]
			document.getElementById(expiry).value=itemsArray1[i][6]
		
			//document.getElementById(expiryDate).value= itemsArray1[i][7]
			//document.getElementById(batchNo).value= itemsArray1[i][7]
			
	
				
			
				}
		}
		
	populateBrand(itemId,rowVal)
	
	
}
function checkForSubmit()
{
  if(document.getElementById('noOfRows').value==0)
  {
  alert("There must be one detail row");
  return false;
  }
  else
  {
  return true;
  }
}

  
function fillQuanForDefectiveDrug(rowVal)
{
	if(document.getElementById('quanRecTemp'+rowVal).value=='')
	{
 		document.getElementById('quanRec'+rowVal).value=0
 	}
 	else
 	{
  		document.getElementById('quanRec'+rowVal).value=document.getElementById('quanRecTemp'+rowVal).value
 	}
}
 
 
 function fillAuthyForDefectiveDrug(rowVal){
 if(document.getElementById('authyDecTemp'+rowVal).value==''){
  document.getElementById('authyDec'+rowVal).value=0
 }else{
  document.getElementById('authyDec'+rowVal).value=document.getElementById('authyDecTemp'+rowVal).value
 }

}

function fillDisposalForDefectiveDrug(rowVal){
if(document.getElementById('disposalTemp'+rowVal).value==''){
 document.getElementById('disposal'+rowVal).value=0
 }
 else
 {
  document.getElementById('disposal'+rowVal).value=document.getElementById('disposalTemp'+rowVal).value
 }

}

 function fillExpForDefectiveDrug(rowVal){
 if(document.getElementById('expiryDateTemp'+rowVal).value==''){
 }
 else{
  document.getElementById('expiryDate'+rowVal).value=document.getElementById('expiryDateTemp'+rowVal).value
 }
}
 function fillManForDefectiveDrug(rowVal){
	 if(document.getElementById('manufacturingDateTemp'+rowVal).value==''){
	 }
	 else{
	  document.getElementById('manufacturingDate'+rowVal).value=document.getElementById('manufacturingDate'+rowVal).value
	 }
	}
 
//================= functions for non expandable ==================

function onChangeSrc(sos)
{
document.getElementById("indentCombo").options.length=0;
if(sos == "p"|| sos =="g" || sos == "m")
{
document.getElementById("indentCombo").disabled = true;

submitProtoAjaxforSupplier('grnGrid','/hms/hms/neStores?method=responseNeGrn');
submitProtoAjaxforGrid('grnGrid','/hms/hms/neStores?method=responseGridList');
}
else 
{
document.getElementById("indentCombo").disabled = false;
submitProtoAjaxforSupplier('grnGrid','/hms/hms/neStores?method=responseNeGrn');
}

}


function fillNatureOfWorkInWorkOrder(rowVal){

if(document.getElementById('natOfWrkTemp'+rowVal).value == ''){
 document.getElementById('natOfWrk'+rowVal).value = 0
 }else
 {
  document.getElementById('natOfWrk'+rowVal).value=document.getElementById('natOfWrkTemp'+rowVal).value
 }

}

 function fillRemarksInWorkOrder(rowVal)
  {
  var remarks = "remarks";
  var remarksTemp = "remarksTemp";
 if(document.getElementById('remarksTemp'+rowVal).value == ''){
 document.getElementById('remarks'+rowVal).value =0
  }else{
   document.getElementById('remarks'+rowVal).value=document.getElementById('remarksTemp'+rowVal).value
   }
 }
  

  function testForGrn()
 {
	var errorMessage="";
	formName="grnGrid"
	obj = eval('document.'+formName)
	

	for(i=1;i<40;i++)
	{
		if(document.getElementById('idItem'+i) != null){
		if(document.getElementById('idItem'+i).value !=0)
		{
				if (document.getElementById('brandId'+i).value == "")
				{
				errorMessage=errorMessage+ "Please Select Brand Name for Item " + document.getElementById('nameItem'+i).value + " \n "; 
				} 
		}
	}
		
		if (errorMessage=="")
			return true;
		else
		{
			alert(errorMessage);
			return false;
		}
 }
}
 //===========================
 
  function validationForSerial()
{
	var errorMessage="";
	formName="grnGrid"
	obj = eval('document.'+formName)
	for(i=1;i<10;i++)
	{
	if(document.getElementById('batchNoTemp'+i).value !="")
	{
	if(document.getElementById('amcStartDate'+i).value ==0)
		errorMessage=errorMessage+"Please Select amcStartDate  \n";
	
	if(document.getElementById('amcEndDate'+i).value ==0)
		errorMessage=errorMessage+"Please Select amcEndDate  \n";
		
		if(document.getElementById('installationDate'+i).value ==0)
		errorMessage=errorMessage+"Please Select installationDate  \n";
			 
	}
		if(errorMessage != "")
		{	
			alert(errorMessage)
			return false
			}else{
			return true
			}
}

 }
 
function enterQuantityForSerial(rowVal){
if(document.getElementById('batchNoTemp'+rowVal).value !=""){
  var quantity;
  document.getElementById('quanRecTemp'+rowVal).value ="1"
   document.getElementById('quanRec'+rowVal).value ="1"
  document.getElementById('quanRecTemp'+rowVal).disabled = true;
  
 } else{
  document.getElementById('quanRecTemp'+rowVal).value="";
  document.getElementById('quanRecTemp'+rowVal).disabled =false;
 }
}

 function checkForSerialNo(value,rowVal){
 for(i=1;i<10;i++)
	{
	if(document.getElementById('batchNoTemp'+i).value !="" && value !="" && rowVal !=i)
	if(value==document.getElementById('batchNoTemp'+i).value)
	{
	alert("Serial No should be unique ...!")
	document.getElementById('batchNoTemp'+rowVal).value=""
	return false;
		}
		}
		
		return true
 }
 
  /// amount calculation for loanin 
 
 function calculateAmountForLoanIn(rowVal){
	var quantity = parseFloat(document.getElementById('quanRecTemp'+rowVal).value)
	var unitRate = parseFloat(document.getElementById('unitRateVarTemp'+rowVal).value)
	var discount = parseFloat(document.getElementById('discountVarTemp'+rowVal).value)
	var tax = parseFloat(document.getElementById('taxVarTemp'+rowVal).value)
	var total;
	var disc;
	var amountAfterdiscount;
	var amountAfterTax;
	var netAmount;
	total = quantity*unitRate;
	
	if(!isNaN(quantity) && !isNaN(unitRate) && !isNaN(discount) && !isNaN(tax)){
		disc = total*(discount/100);
		amountAfterdiscount = total-disc;
		amountAfterTax = (amountAfterdiscount)*(tax/100)
		netAmount = amountAfterdiscount+amountAfterTax;
		document.getElementById('amtVarTemp'+rowVal).value=roundVal(netAmount,2)
	}else if(!isNaN(quantity) == "" && !isNaN(unitRate) == ""){
		alert("Please Enter Both Quantity and Unit Rate.");
	}else if(!isNaN(quantity) != "" && !isNaN(unitRate) == ""){
		alert("Please Enter Unit Rate.");
	}else if(!isNaN(quantity) == "" && !isNaN(unitRate) != ""){
		alert("Please Enter Quantity.");
	}
	else if(!isNaN(discount) == "" && !isNaN(tax) == ""){
	
		document.getElementById('amtVarTemp'+rowVal).value=total
	}else  if(!isNaN(discount) == "" || !isNaN(tax) != ""){
		netAmount = total+(total*(tax/100));
		
		document.getElementById('amtVarTemp'+rowVal).value=roundVal(netAmount,2)
	}
	else  if(!isNaN(discount) != "" || !isNaN(tax) == ""){
	
		disc = total*(discount/100);
		amountAfterdiscount = total-disc;
		netAmount = amountAfterdiscount;
		document.getElementById('amtVarTemp'+rowVal).value=roundVal(netAmount,2)
	}
	
	
	
	var tempNetValue=0;
	for(i=1;i<=10;i++)
	{
		if(document.getElementById('amtVarTemp'+i).value.trim() !="")
		{
		var freeItem = document.getElementById('freeItem'+i).value;
	   	if (freeItem=='n')	tempNetValue=parseFloat(tempNetValue)+parseFloat(document.getElementById('amtVarTemp'+i).value);
	 	var rateForOne = 0;
	  	rateForOne = document.getElementById('amtVarTemp'+i).value.trim()
		var quantity = parseFloat(document.getElementById('quanRecTemp'+rowVal).value)
		var freeqty = parseFloat(document.getElementById('freeQty'+rowVal).value)
		var costPrice = (rateForOne)/(quantity+freeqty)
		document.getElementById('costPriceTemp'+i).value = roundVal(costPrice,3);
		}
	}
 
 document.getElementById('grnValue').value=roundVal(tempNetValue,2);
 
 fillAmountForGrn(rowVal);
 fillCostPriceForGrn(rowVal);
	
}




function roundVal(val,dec){
	var result = Math.round(val*Math.pow(10,dec))/Math.pow(10,dec);
	return result;
}

 
function calculateAmountForCrvWhenAdjust(rowVal){
	var quantity = parseFloat(document.getElementById('quanRecTemp'+rowVal).value)
	var unitRate = parseFloat(document.getElementById('unitRateVarTemp'+rowVal).value)
	var discount = parseFloat(document.getElementById('discountVarTemp'+rowVal).value)
	var tax = parseFloat(document.getElementById('taxVarTemp'+rowVal).value)
	var total;
	var disc;
	var amountAfterdiscount;
	var amountAfterTax;
	var netAmount;
	total = quantity*unitRate;
	
	if(!isNaN(quantity) && !isNaN(unitRate) && !isNaN(discount) && !isNaN(tax)){
		disc = total*(discount/100);
		amountAfterdiscount = total-disc;
		amountAfterTax = (amountAfterdiscount)*(tax/100)
		netAmount = amountAfterdiscount+amountAfterTax;
		document.getElementById('amtVarTemp'+rowVal).value=roundVal(netAmount,2)
	}else if(!isNaN(quantity) == "" && !isNaN(unitRate) == ""){
		alert("Please Enter Both Quantity and Unit Rate.");
	}else if(!isNaN(quantity) != "" && !isNaN(unitRate) == ""){
		alert("Please Enter Unit Rate.");
	}else if(!isNaN(quantity) == "" && !isNaN(unitRate) != ""){
		alert("Please Enter Quantity.");
	}
	else if(!isNaN(discount) == "" && !isNaN(tax) == ""){
	
		document.getElementById('amtVarTemp'+rowVal).value=total
	}else  if(!isNaN(discount) == "" || !isNaN(tax) != ""){
		netAmount = total+(total*(tax/100));
		
		document.getElementById('amtVarTemp'+rowVal).value=roundVal(netAmount,2)
	}
	else  if(!isNaN(discount) != "" || !isNaN(tax) == ""){
	
		disc = total*(discount/100);
		
		amountAfterdiscount = total-disc;
		netAmount = amountAfterdiscount;
		document.getElementById('amtVarTemp'+rowVal).value=roundVal(netAmount,2)
	}
		

 var abc=document.getElementById('grnValue').value
	 
	var total = parseFloat(abc)+parseFloat(document.getElementById('amtVarTemp'+rowVal).value);
	
	var tempNetValue=0;
	
 	tempNetValue=parseFloat(tempNetValue)+parseFloat(document.getElementById('amtVarTemp').value);

 document.getElementById('grnValue').value=roundVal(total,2);
	
}
 
 //========================================================================================================
 //======================FUNCTIONS END BY ABHA  ======================
 //========================================================================================================
 
 
 //========================================================================================================
 //======================AT BANGALORE======================
 //========================================================================================================
function calculationInCRV()
 {
	
	var sos = document.getElementById('sourceCombo').value
    	for(rowVal=1;rowVal<=40;rowVal++)
		{
    		
			if(document.getElementById('idItem'+rowVal) && document.getElementById('idItem'+rowVal).value!=0)
			{
			
    			var discount = parseFloat(0);
				var tax = parseFloat(0);
			//	var vatApplicable = document.getElementById('vatApplicable');
			
				//Calculation of Amount for the Current Row (rowVal)
    			if(document.getElementById('discountVar'+rowVal).value!='' && !validateFloat(document.getElementById('discountVar'+rowVal).value)){
    				alert("Disc(%) is not valid.");
    				document.getElementById('discountVar'+rowVal).value='0';
    				return false;
    			}
    			if(document.getElementById('taxVar'+rowVal).value!='' && !validateFloat(document.getElementById('taxVar'+rowVal).value)){
    				alert("Tax(%) is not valid.");
    				document.getElementById('taxVar'+rowVal).value='0';
    				return false;
    			}
				var quantity = isNaN(parseFloat(document.getElementById('quanRec'+rowVal).value))==true?"0":parseFloat(document.getElementById('quanRec'+rowVal).value);
			//	var freeQty = isNaN(parseFloat(document.getElementById('freeQty'+rowVal).value))==true?"0":parseFloat(document.getElementById('freeQty'+rowVal).value);
				var mdq = isNaN(parseFloat(document.getElementById('mdq'+rowVal).value))==true?"0":parseFloat(document.getElementById('mdq'+rowVal).value);
				var ratePerMdq = isNaN(parseFloat(document.getElementById('ratePerMdq'+rowVal).value))==true?"0":parseFloat(document.getElementById('ratePerMdq'+rowVal).value);
				var discount = isNaN(parseFloat(document.getElementById('discountVar'+rowVal).value))==true?"0":parseFloat(document.getElementById('discountVar'+rowVal).value);
				var tax = isNaN(parseFloat(document.getElementById('taxVar'+rowVal).value))==true?"0":parseFloat(document.getElementById('taxVar'+rowVal).value);
				//if(sos != 'l'){
				//var tax = isNaN(parseFloat(document.getElementById('taxVar'+rowVal).value))==true?"0":parseFloat(document.getElementById('taxVar'+rowVal).value);
				//}else{
			//	var taxAmt = isNaN(parseFloat(document.getElementById('tax_amt_mdq' + rowVal).value))==true?"0":parseFloat(document.getElementById('tax_amt_mdq' + rowVal).value);
			//	var ed = isNaN(parseFloat(document.getElementById('ed'+rowVal).value))==true?"0":parseFloat(document.getElementById('ed'+rowVal).value);
			//	}
				var total = parseFloat(0);
				var disc= parseFloat(0);
				var discMrp=parseFloat(0);
				var amountAfterdiscount= parseFloat(0);
				var amountAfterMrpdiscount= parseFloat(0);
				var taxAmount = parseFloat(0);
				var taxAmountMrp = parseFloat(0);
				var netAmount= parseFloat(0);
				var mrpPerAu=parseFloat(0);
				if(mdq!=0){
				mrpPerAu=parseFloat(ratePerMdq)/parseFloat(mdq);
				}
			//	if(sos != 'l'){
				     total = parseFloat(quantity)*parseFloat(ratePerMdq);
				//}else{
				     total = (parseFloat(quantity)* (parseFloat(ratePerMdq))) ;
				//}
				disc = total*(discount/100);
				discMrp=mrpPerAu*(discount/100);
				
				amountAfterdiscount = total-disc;
				amountAfterMrpdiscount=mrpPerAu-discMrp;
				
				
				
				taxAmount=amountAfterdiscount*(tax/100);
				taxAmountMrp=amountAfterMrpdiscount*(tax/100);
				
				
				amountAfterdiscount=amountAfterdiscount+taxAmount;
				amountAfterMrpdiscount=amountAfterMrpdiscount+taxAmountMrp;
				
				document.getElementById('mrp'+rowVal).value=roundVal(mrpPerAu,2);
				document.getElementById('amtVar'+rowVal).value=roundVal(amountAfterdiscount,2);
				document.getElementById('discountAmount'+rowVal).value=roundVal(disc,4);
				document.getElementById('costPrice'+rowVal).value=roundVal(amountAfterMrpdiscount,2);

				document.getElementById('taxAmount'+rowVal).value=roundVal(taxAmount,2);


				// Calculating converted Stock as Per Formula  & Conversion Login
			//	var formula = isNaN(parseFloat(document.getElementById('formula'+rowVal).value))==true?"0":parseFloat(document.getElementById('formula'+rowVal).value);
			//	var conversionFactor = isNaN(parseFloat(document.getElementById('conversionFactor'+rowVal).value))==true?"0":parseFloat(document.getElementById('conversionFactor'+rowVal).value);
			//	var convertedStock = parseFloat(0);
				
			//	quantity = parseFloat(quantity) + parseFloat(freeQty);

			}
		}
    	
	calculateGRNValue(sos);
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
  //Calculate Unit Rate in LoanIn
 function calculateUnitRateinLoanIn(inc)
 {
    	var mdq = "mdq";
    	var ratePerMdq = "ratePerMdq";
    	var unitRateVarTemp = "unitRateVarTemp";
    	var unitRateVar = "unitRateVar";
    	if (!isNaN(document.getElementById(mdq+inc).value) && !isNaN(document.getElementById(ratePerMdq+inc).value))
    	{
    		document.getElementById(unitRateVarTemp+inc).value = parseFloat(document.getElementById(ratePerMdq+inc).value) / parseFloat(document.getElementById(mdq+inc).value);
    		document.getElementById(unitRateVar+inc).value = document.getElementById(unitRateVarTemp+inc).value;
    	}
 }
 
 function fillQuantityForLoanIn(rowVal)
{
	 if(document.getElementById('quanRecTemp'+rowVal).value=='')
	 {
	 
	 }
	 else
	 {
	  document.getElementById('quanRec'+rowVal).value=document.getElementById('quanRecTemp'+rowVal).value
	  if (document.getElementById('mdq'+rowVal).value!='' && document.getElementById('ratePerMdq'+rowVal).value!='')
	  {
	  	    calculateUnitRateinLoanIn(rowVal);
	  	    calculateAmountForLoanIn(rowVal);
	  }
	 }
}
 
 function checkForLocalPurchaseGrid()
 {
 	var pageNo =parseInt(document.getElementById('pageNo').value) 
	var start=((pageNo-1)*10)+1;
    var end=((pageNo-1)*10)+10;
     for(i=start;i<=end;i++)
	    {
		   if(document.getElementById('codeItem'+i)){
		    var pvms = document.getElementById('codeItem'+i).value;
		    
		    if(pvms !="")
		    {
		    
			/*  if (document.getElementById('brandId'+i).value=="")
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
		    */
			    if (document.getElementById('quantityInVarTemp'+i).value=="" || isNaN(document.getElementById('quantityInVarTemp'+i).value))
			    { 
			    alert('Pl. Check Quantity in Row No:' + i);
			    document.getElementById('quantityInVarTemp'+i).focus();
			    return false;
			    }
			    
			  	    
			 //   if (document.getElementById('dispenseType'+i).value=="")
			   // { 
			 //   alert('Pl. Select Dispense Type in Row No:' + i);
			  //  document.getElementById('dispenseType'+i).focus();
			 //   return false;
			 //   }
			    
			  //  if (document.getElementById('mdq'+i).value=="" || document.getElementById('mdq'+i).value==0 || isNaN(document.getElementById('mdq'+i).value))
			  //  { 
			 //   alert('Pl. Check MDQ in Row No:' + i);
			  //  document.getElementById('mdq'+i).focus();
			  //  return false;
			   // }
			    
			 //   if (document.getElementById('ratePerMdq'+i).value=="" || document.getElementById('ratePerMdq'+i).value==0 || isNaN(document.getElementById('ratePerMdq'+i).value))
			//    { 
			   // alert('Pl. Check Rate / MDQ in Row No:' + i);
			  //  document.getElementById('ratePerMdq'+i).focus();
			  //  return false;
			 //   }
			    
			    if (document.getElementById('amountVarTemp'+i).value=="" || document.getElementById('amountVarTemp'+i).value==0 || document.getElementById('amountVarTemp'+i).value < 0)
			    { 
			    alert('Pl. Check Amount in Row No:' + i);
			    return false;
			    }
		    }
		   }
	    }
	    return true;
}	    


/*
 * function checkForLoanInGrid()
 {
 	var pageNo =parseInt(document.getElementById('pageNo').value) 
	var start=0;
    var end=document.getElementById('gridSize').value;
    
     for(i=start;i<end;i++)
	    {
    	 alert(document.getElementById('codeItem'+i).value);
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
			    
		
			    if (document.getElementById('quanRec'+i).value=="" || isNaN(document.getElementById('quanRec'+i).value))
			    { 
			    alert('Pl. Check Quantity Received in Row No:' + i);
			    document.getElementById('quanRecTemp'+i).focus();
			    return false;
			    }
			    
			  	    
			    if (document.getElementById('dispenseType'+i).value=="")
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
			    }
			    
			    if (document.getElementById('ratePerMdq'+i).value=="" || document.getElementById('ratePerMdq'+i).value==0 || isNaN(document.getElementById('ratePerMdq'+i).value))
			    { 
			    alert('Pl. Check Rate / MDQ in Row No:' + i);
			    document.getElementById('ratePerMdq'+i).focus();
			    return false;
			    }
			    
			    if (document.getElementById('amtVar'+i).value=="" || document.getElementById('amtVar'+i).value==0 || document.getElementById('amtVar'+i).value < 0)
			    { 
			    alert('Pl. Check Amount in Row No:' + i);
			    return false;
			    }
			    
			    if (document.getElementById('batchNo'+i).value=="")
			    { 
			    alert('Pl. Check Batch No in Row No:' + i);
			    document.getElementById('batchNoTemp'+i).focus();
			    return false;
			    }
			    
			    
			    if (document.getElementById('manufacturingDate'+i).value=="")
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
			    	
			    	
		    }
	    }
	    return true;
}	    
*/


function checkForCRVGrid()
 {

     for(i=1;i<=40;i++)
	    {
    	 
		   if(document.getElementById('codeItem'+i) != null){
		    var pvms = document.getElementById('codeItem'+i).value;
		   
		    if(pvms !="")
		    {

			   // if (document.getElementById('brandId'+i).value=="")
			    //{ 
			    //alert('Pl. Check Brand in Row No:' + i);
			    //document.getElementById('brandId'+i).focus();
			    //return false;
			    //}
			    
			    //if (document.getElementById('manufacturerId'+i).value=="")
			    //{ 
			    //alert('Pl. Check Manufacturer in Row No:' + i);
			    //document.getElementById('manufacturerId'+i).focus();
			    //return false;
			    //}
		
				
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
			    //else if (document.getElementById('ratePerMdq'+i).value=="" || document.getElementById('ratePerMdq'+i).value==null || document.getElementById('ratePerMdq'+i).value==0 || isNaN(document.getElementById('ratePerMdq'+i).value))
			   // { 
			   // alert('Pl. Check Rate / MDQ in Row No:' + i);
			   // document.getElementById('ratePerMdq'+i).focus();
			    //return false;
			    //}
			    if(document.getElementById('sourceCombo').value=="a" ||document.getElementById('sourceCombo').value=="i" || document.getElementById('sourceCombo').value=="o")
			    {
			    return true;
			    }
			    //else if (document.getElementById('amtVar'+i).value=="" || document.getElementById('amtVar'+i).value==0 || document.getElementById('amtVar'+i).value < 0)
			    //{ 
			    //alert('Pl. Check Amount in Row No:' + i);
			    //return false;
			    //}
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


function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode;
   if (charCode != 46 && charCode > 31 
     && (charCode < 48 || charCode > 57))
      return false;

   return true;
}
function validateFloatSupply( strValue ) {
 	//var objRegExp  =/^((\+|-)\d)?\d*(\.\d{2})?$/;
 //	var objRegExp  =/^([+\-])?\d*([\.])?\d*([eE]([+\-])?)?\d*$/;
	// commented by dipali var objRegExp  =/^d*([\.])?\d*([eE]([+\-])?)?\d*$/;
	//Added by Dipali
	var objRegExp  =/^[0-9]+(?:\.[0-9]+)?$/;
 	return objRegExp.test(strValue);
}
function gridCalculationLocalSupplyOrderAdd(rowVal)
{

/*	var pageNo =parseInt(document.getElementById('pageNo').value) 
	var start=((pageNo-1)*10)+1;
	var end=((pageNo-1)*10)+10;*/
	var quantity = 0;
	var mdq = 0;
	var ratePerMdq = 0;
	var unitRate = 0;
	var discount = 0;
	var mrp = 0;
	var tax = 0;
	var discountAmount = 0;
	var  discountAuAmount = 0;
	var taxAuAmount = 0;
//	var taxAmountOnMRP = 0;
	var totalAmount = 0;
	var totalAuAmount = 0;
	//var otherTaxes = 0;
	var grandTotal = 0;
	//var totalCarryForward = 0;
	var actualqty = 0;
	//var totRateforOq = 0;
	//var exciseDuty = 0;
//	var taxforOq = 0;
	//var remain = 0;
	
	if(!validateFloatSupply(document.getElementById('discountVarTemp'+rowVal).value)){
		alert("Disc(%) is not valid.");
		document.getElementById('discountVarTemp'+rowVal).value='0';
		return false;
	}
	if(!validateFloatSupply(document.getElementById('taxVarTemp'+rowVal).value)){
		alert("Tax(%) is not valid.");
		document.getElementById('taxVarTemp'+rowVal).value='0';
		return false;
	}

	if (!isNaN(document.getElementById('quantityInVarTemp'+rowVal).value))
	quantity = parseFloat(document.getElementById('quantityInVarTemp'+rowVal).value);
	
	if (!isNaN(document.getElementById('discountVarTemp'+rowVal).value))
		discount = parseFloat(document.getElementById('discountVarTemp'+rowVal).value);
		
	if (!isNaN(document.getElementById('mrp'+rowVal).value))
	mrp = parseFloat(document.getElementById('mrp'+rowVal).value);
	
	if (!isNaN(document.getElementById('mdq'+rowVal).value))
	mdq = parseFloat(document.getElementById('mdq'+rowVal).value);
	
//	if (!isNaN(document.getElementById('ratePerMdq'+rowVal).value))
	//ratePerMdq = parseFloat(document.getElementById('ratePerMdq'+rowVal).value);
	
if (!isNaN(document.getElementById('taxVarTemp'+rowVal).value))
	tax = parseFloat(document.getElementById('taxVarTemp'+rowVal).value);
	
	//if (!isNaN(document.getElementById('otherTaxes'+rowVal).value))
	//otherTaxes = parseFloat(document.getElementById('otherTaxes'+rowVal).value);
	
	//if (!isNaN(document.getElementById('totalCarryForward').value))
//	totalCarryForward = parseFloat(document.getElementById('totalCarryForward').value);
	
   if (!isNaN(document.getElementById('actualqtyin'+rowVal).value))
actualqty = parseFloat(document.getElementById('actualqtyin'+rowVal).value);
	
	// if (!isNaN(document.getElementById('exciseDuty'+rowVal).value))
	//exciseDuty = parseFloat(document.getElementById('exciseDuty'+rowVal).value);
	
	//remain = parseFloat(document.getElementById('totremain').value);
	
	var formula = isNaN(parseFloat(document.getElementById('formula'+rowVal).value))==true?"0":parseFloat(document.getElementById('formula'+rowVal).value);
	var conversionFactor = isNaN(parseFloat(document.getElementById('conversionFactor'+rowVal).value))==true?"0":parseFloat(document.getElementById('conversionFactor'+rowVal).value);
	// Amount Calculation
 if(mdq > 0 ){
	 var tempqty = parseFloat(0);
		if (formula !=0 && conversionFactor != 0 && mdq != 0)
		{
			if (formula==1)
				{
					tempqty = (actualqty * conversionFactor) / mdq;
				}
				else if (formula==2)
				{
					tempqty = quantity; 
				}
		}
	   tempqty = actualqty /  parseFloat(mdq);

	 document.getElementById('actualqty'+rowVal).value = actualqty;
	 document.getElementById('quantityInVar'+rowVal).value = parseInt(tempqty);
	 document.getElementById('quantityInVarTemp'+rowVal).value = parseInt(tempqty);
	 }
	if ( quantity > 0 && mrp >0)
	{
		unitRate = mrp / mdq;
		totalAuAmount=parseFloat(unitRate);
		totalAmount = parseFloat(parseInt(tempqty) * parseFloat(mrp)) ;
		if (discount > 0)
		{
			discountAmount = totalAmount * (discount / 100);
			discountAuAmount=unitRate * (discount / 100);
			totalAmount = totalAmount - discountAmount;
			totalAuAmount=unitRate-discountAuAmount;
		}
				var disc= parseFloat(0);
				var amountAfterdiscount= parseFloat(0);
				var taxAmount = parseFloat(0);
				var netAmount= parseFloat(0);
		if ( tax > 0){
		
			/*taxAmountOnMRP = quantity * (ratePerMdq / mdq) * (tax / 100);
			disc = totalAmount*(discount/100);
			amountAfterdiscount = totalAmount-disc;*/
			
			taxAmount = (totalAmount)*(tax/100)
			taxAuAmount=(totalAuAmount)*(tax/100)
			totalAuAmount=totalAuAmount+taxAuAmount;
			
			totalAmount = totalAmount + taxAmount;
	}
		
		//if (otherTaxes > 0)
	//	{
		//	totalAmount = totalAmount + otherTaxes;
		//}
		
		//Fill Calculated Amount in the Corresponding Row
	//	document.getElementById('taxOq'+rowVal).value = roundVal(parseFloat(tax / tempqty),2);

		document.getElementById('amountVarTemp'+rowVal).value =  totalAmount;
		document.getElementById('amountVar'+rowVal).value =totalAmount ;
		
		document.getElementById('costPrice'+rowVal).value =totalAuAmount ;
		document.getElementById('discountAmount'+rowVal).value =discountAmount ;
		document.getElementById('taxAmount'+rowVal).value =taxAmount ;
		
	//	document.getElementById('totRateOq'+rowVal).value =   parseInt(tempqty);
		//document.getElementById('unitRateVarTemp'+rowVal).value =  unitRate;

		
}
	else
	{
		return;
	}
	
	
	//Fill Values to Hidden Fields 
	
	//document.getElementById('amountVar'+rowVal).value =  document.getElementById('amountVarTemp'+rowVal).value;
	//document.getElementById('unitRateVar'+rowVal).value =  document.getElementById('unitRateVarTemp'+rowVal).value;
	//document.getElementById('taxAmount'+rowVal).value =  taxAmount;
	
	
	//for(var r=start;r<=end;r++)
   // {
	//   	 if(isNaN(document.getElementById('amountVarTemp'+r).value))
	 //  	 {
	 //  	 }
	 //  	 else
	 //  	 {
	//	   	 var freeItem = document.getElementById('freeItem'+r).value;
		//   	 if (freeItem=='n') grandTotal = grandTotal +parseFloat(document.getElementById('amountVarTemp'+r).value)
		// }
   // }
   
 //  grandTotal = grandTotal;// + totalCarryForward;
   
   //Fill Grand Total
   //document.getElementById('total_amount').value = grandTotal;
//document.getElementById('total_amount').value = grandTotal;
	//document.getElementById('remain').value = remain + grandTotal;
	
}


function gridCalculationLocalSupplyOrderEdit(rowVal)
{
	
	var pageNo =parseInt(document.getElementById('pageNo').value) 
	var start=((pageNo-1)*10)+1;
	var end=((pageNo-1)*10)+10;
	var quantity = 0;
	var discount = 0;
	var mrp = 0;
	var discountAmount = 0;
	var totalAmount = 0;
	var currAmount = 0;
	var tempAmount = 0;
//	var mdq = 0;
//	var ratePerMdq = 0;
	//var unitRate = 0;
	//var tax = 0;
	//var taxAmountOnMRP = 0;
	
//	var otherTaxes = 0;
	//var grandTotal = 0;
	//var totalCarryForward = 0;
//	var pageTotal = 0;
	
	//var amountToAdd =0;
	
 //   var actualqty = 0;
  //  var totRateforOq = 0;
	//var exciseDuty = 0;
//	var taxforOq = 0;
    
	if (!isNaN(document.getElementById('quantityInVarTemp'+rowVal).value))
	quantity = parseFloat(document.getElementById('quantityInVarTemp'+rowVal).value);
	//if (!isNaN(document.getElementById('mdq'+rowVal).value))
//	mdq = parseFloat(document.getElementById('mdq'+rowVal).value);
	//if (!isNaN(document.getElementById('ratePerMdq'+rowVal).value))
//	ratePerMdq = parseFloat(document.getElementById('ratePerMdq'+rowVal).value);

	if (!isNaN(document.getElementById('discountVarTemp'+rowVal).value))
	discount = parseFloat(document.getElementById('discountVarTemp'+rowVal).value);
	
	if (!isNaN(document.getElementById('mrp'+rowVal).value))
	mrp = parseFloat(document.getElementById('mrp'+rowVal).value);
	
	if (!isNaN(document.getElementById('taxVarTemp'+rowVal).value))
	//tax = parseFloat(document.getElementById('taxVarTemp'+rowVal).value);
	
	//if (!isNaN(document.getElementById('otherTaxes'+rowVal).value))
	//otherTaxes = parseFloat(document.getElementById('otherTaxes'+rowVal).value);
	
//	if (!isNaN(document.getElementById('totalCarryForward').value))
	//totalCarryForward = parseFloat(document.getElementById('totalCarryForward').value);
	
	if (!isNaN(document.getElementById('pageTotal').value))
	pageTotal = parseFloat(document.getElementById('pageTotal').value);
	
if (!isNaN(document.getElementById('amountVarTemp'+rowVal).value))
	tempAmount = parseFloat(document.getElementById('amountVarTemp'+rowVal).value);
	
	// if (!isNaN(document.getElementById('actualqtyin'+rowVal).value))
//	actualqty = parseFloat(document.getElementById('actualqtyin'+rowVal).value);
	
	// if (!isNaN(document.getElementById('exciseDuty'+rowVal).value))
	//exciseDuty = parseFloat(document.getElementById('exciseDuty'+rowVal).value);
	
	
	var formula = isNaN(parseFloat(document.getElementById('formula'+rowVal).value))==true?"0":parseFloat(document.getElementById('formula'+rowVal).value);
	var conversionFactor = isNaN(parseFloat(document.getElementById('conversionFactor'+rowVal).value))==true?"0":parseFloat(document.getElementById('conversionFactor'+rowVal).value);

	// Amount Calculation
	
	
	 //if(mdq > 0 ){
//	 var tempqty = parseFloat(0);
	// tempqty = actualqty /  parseFloat(mdq);
	 
	 //	if (formula !=0 && conversionFactor != 0 && mdq != 0)
	//	{
		//	if (formula==1)
		//		{
			//		tempqty = (actualqty * conversionFactor) / mdq;
			//	}
				//else if (formula==2)
			//	{
					tempqty = quantity; 
				//}
		//}
//	 document.getElementById('actualqty'+rowVal).value = actualqty;
	 document.getElementById('quantityInVar'+rowVal).value = parseInt(tempqty);
	 document.getElementById('quantityInVarTemp'+rowVal).value = parseInt(tempqty);
	// Amount Calculation
	
	if (quantity > 0 && mrp >0)
	{
		//unitRate = ratePerMdq / mdq;
		totalAmount = parseFloat(parseInt(tempqty) * parseFloat(mrp ));// + exciseDuty + tax;
	
		if (discount > 0)
		{
			discountAmount = totalAmount * (discount / 100);
			totalAmount = totalAmount - discountAmount;
		}
		//if (mrp > 0 && tax > 0)
	//	{
	//		taxAmountOnMRP = quantity * (mrp / mdq) * (tax / 100);
	//		totalAmount = totalAmount + taxAmountOnMRP;
	//	}
		
		
	//	var disc= parseFloat(0);
	//			var amountAfterdiscount= parseFloat(0);
		//		var taxAmount = parseFloat(0);
			//	var netAmount= parseFloat(0);
	
		//if (ratePerMdq > 0 && tax > 0)
		//{
		
		//	taxAmountOnMRP = quantity * (ratePerMdq / mdq) * (tax / 100);
			//disc = totalAmount*(discount/100);
		//	amountAfterdiscount = totalAmount-disc;
			//taxAmount = (amountAfterdiscount)*(tax/100)
		//	totalAmount = totalAmount + taxAmount;
		//}
		
		//if (otherTaxes > 0)
		//{
		//	totalAmount = totalAmount + otherTaxes;
		//}
		
		//Fill Calculated Amount in the Corresponding Row
		//document.getElementById('taxOq'+rowVal).value = roundVal(parseFloat(tax / tempqty),2);
		document.getElementById('amountVarTemp'+rowVal).value =  totalAmount;
		document.getElementById('amountVar'+rowVal).value=totalAmount;
		//document.getElementById('totRateOq'+rowVal).value =   parseFloat(parseInt(tempqty)) * (ratePerMdq);
	//	document.getElementById('unitRateVarTemp'+rowVal).value =  unitRate;
	
	  if(document.getElementById('detailId'+rowVal))
	   amountToAdd =totalAmount - tempAmount ;
	   
		
	}
	else
	{
		return;
	}
	
	
	//Fill Values to Hidden Fields 
	
	//document.getElementById('quantityInVar'+rowVal).value =  document.getElementById('quantityInVarTemp'+rowVal).value;
	document.getElementById('discountAmount'+rowVal).value =  discount;
	document.getElementById('amountVar'+rowVal).value =  document.getElementById('amountVarTemp'+rowVal).value;
	//document.getElementById('unitRateVar'+rowVal).value =  document.getElementById('unitRateVarTemp'+rowVal).value;
	//document.getElementById('taxAmount'+rowVal).value =  taxAmount;
	//grandTotal =parseFloat(document.getElementById('totalCarryForward').value);
	//currAmount =parseFloat(document.getElementById('currAmount').value);
//	grandTotal = grandTotal - currAmount;
	
	//for(var r=start;r<=end;r++)
   // {
	// if(isNaN(document.getElementById('amountVarTemp'+r).value))
	//   	 {
	//   	 }
	  // 	 else
	  // 	 {
	 	//   	 var freeItem = document.getElementById('freeItem'+r).value;
		//   	 if (freeItem=='n') grandTotal = grandTotal +parseFloat(document.getElementById('amountVarTemp'+r).value)
		// }
   // }
  // var freeItem = document.getElementById('freeItem'+rowVal).value;
  // grandTotal = grandTotal + (totalCarryForward - pageTotal);
   // grandTotal = grandTotal + totalCarryForward;
   //Fill Grand Total
  // document.getElementById('total_amount').value = grandTotal;
}
 

function testForLoanIn()
 {
	var errorMessage="";
	formName="grnGrid"
	obj = eval('document.'+formName)
	
	for(i=1;i<=10;i++)
	{
		if(document.getElementById('idItem'+i).value !=0)
		{
				if (document.getElementById('brandId'+i).value == "")
				{
				errorMessage=errorMessage+ "Please Select Brand Name for Item " + document.getElementById('nameItem'+i).value + " \n "; 
				} 
		}
	}
		
		if (errorMessage=="")
			return true;
		else
		{
			alert(errorMessage);
			return false;
		}
 }
 

function calculateGRNValue(sos)
 {
   
	//Calculation of Total GRN Value
// 	var exciseDuty=isNaN(parseFloat(document.getElementById('exciseDuty').value.trim()))==true?"0":parseFloat(document.getElementById('exciseDuty').value.trim());
////	var freightDuty=isNaN(parseFloat(document.getElementById('freightDuty').value.trim()))==true?"0":parseFloat(document.getElementById('freightDuty').value.trim());
	//var octroi=isNaN(parseFloat(document.getElementById('octroi').value.trim()))==true?"0":parseFloat(document.getElementById('octroi').value.trim());
	//var insuranceCharges=isNaN(parseFloat(document.getElementById('insuranceCharges').value.trim()))==true?"0":parseFloat(document.getElementById('insuranceCharges').value.trim());
	//var otherCharges=isNaN(parseFloat(document.getElementById('otherCharges').value.trim()))==true?"0":parseFloat(document.getElementById('otherCharges').value.trim());
//	var customDuty= isNaN(parseFloat(document.getElementById('customDuty').value.trim()))==true?"0":parseFloat(document.getElementById('customDuty').value.trim());
	
	var tempNetValue = parseFloat(0);
	var tempCostValue = parseFloat(0);
	var charge = parseFloat(0);
	var vat = parseFloat(0);
	var temp = 0;
	
	
	for(i=1;i<=40;i++)
	{
		if(document.getElementById('idItem'+i) && document.getElementById('idItem'+i).value!=0)
		{
		 	//var freeItem = document.getElementById('freeItem'+i).value;
			
				tempNetValue=parseFloat(tempNetValue)+parseFloat(document.getElementById('amtVar'+i).value);
				tempCostValue=parseFloat(tempCostValue)+parseFloat(document.getElementById('ratePerMdq'+i).value);
		}
	}
	
	// Update Cost Price of All Items in the Grid
	// (Duty + VAT) / Total Amt in Grid * Row Amount = Additional Tax
	// Row Amount = Row Amount + Additional Tax
	// Item Cost Price = Row Amount / Converted Stock

	//charge = parseFloat(freightDuty) + parseFloat(exciseDuty) + parseFloat(octroi) + parseFloat(insuranceCharges) + parseFloat(otherCharges) + parseFloat(customDuty);
	//var vat = isNaN(parseFloat(document.getElementById('vatTax').value))==true?"0":parseFloat(document.getElementById('vatTax').value);
	//var totDiscount = isNaN(parseFloat(document.getElementById('totDiscount').value))==true?"0":parseFloat(document.getElementById('totDiscount').value);
	//var vatApplicable = document.getElementById('vatApplicable');
	//if (vatApplicable.checked == false)	
	//	charge = parseFloat(charge) + parseFloat(vat); 
	//charge = parseFloat(charge) - parseFloat(totDiscount) 
	
	var rowAmt = parseFloat(0);
	var additionalTax = parseFloat(0);
	var convertedStock = parseFloat(0);
	var costPrice = parseFloat(0);
	
	/*for(i=1;i<=40;i++)
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
	}*/

	//Calculate Total Amount 
	tempNetValue = parseFloat(0);
	tempCostValue= parseFloat(0);
	
	for(i=1;i<=40;i++)
	{
		if(document.getElementById('idItem'+i) && document.getElementById('idItem'+i).value!=0)
		{
		 	//var freeItem = document.getElementById('freeItem'+i).value;
	       //  if (freeItem=='n') 
		     tempNetValue=parseFloat(tempNetValue)+parseFloat(document.getElementById('amtVar'+i).value);
		     tempCostValue=parseFloat(tempCostValue)+parseFloat(document.getElementById('ratePerMdq'+i).value);
		}
	}
	
	
	//document.getElementById('grnValue').value=roundVal(tempNetValue,2);
	var actualValue=tempNetValue;
	var costValue=tempCostValue;
	actualValue = roundVal(actualValue,2);
	costValue= roundVal(tempCostValue,2);
	//var valueAfterRounding=tempNetValue ;
//	var valueAfterRounding1 = roundVal(valueAfterRounding,0)
	//var roundOffAmount  = valueAfterRounding-valueAfterRounding1;
	
/*  if (vatApplicable.checked){
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

    }else{*/
  	    document.getElementById('total_amount').value=actualValue
  	  //document.getElementById('total_cost').value=costValue
	// }
	
	//document.getElementById('grnValue').value=valueAfterRounding
	//roundOffAmount=roundVal(roundOffAmount,3);
//	document.getElementById('roundOfValue').value=roundOffAmount
	//document.getElementById('actualGrnValue').value=actualValue
}

	
function roundNumber(number,decimal_points) {
        if(!decimal_points) return Math.round(number);
        if(number == 0) {
                var decimals = "";
                for(var i=0;i<decimal_points;i++) decimals += "0";
                return "0."+decimals;
        }

        var exponent = Math.pow(10,decimal_points);
        var num = Math.round((number * exponent)).toString();
        return num.slice(0,-1*decimal_points) + "." + num.slice(-1*decimal_points)
}

function calculationinLoanIn()
 {
    	
    	for(rowVal=1;rowVal<=25;rowVal++)
		{
			if(document.getElementById('idItem'+rowVal).value.trim()!=0)
			{
    			var discount = parseFloat(0);
				var tax = parseFloat(0);
			
				//Calculation of Amount for the Current Row (rowVal)
				
				var quantity = isNaN(parseFloat(document.getElementById('quanRec'+rowVal).value))==true?"0":parseFloat(document.getElementById('quanRec'+rowVal).value);
				var freeQty = isNaN(parseFloat(document.getElementById('freeQty'+rowVal).value))==true?"0":parseFloat(document.getElementById('freeQty'+rowVal).value);
				var ratePerMdq = isNaN(parseFloat(document.getElementById('ratePerMdq'+rowVal).value))==true?"0":parseFloat(document.getElementById('ratePerMdq'+rowVal).value);
				var discount = isNaN(parseFloat(document.getElementById('discountVar'+rowVal).value))==true?"0":parseFloat(document.getElementById('discountVar'+rowVal).value);
				var tax = isNaN(parseFloat(document.getElementById('taxVar'+rowVal).value))==true?"0":parseFloat(document.getElementById('taxVar'+rowVal).value);

				var total = parseFloat(0);
				var disc= parseFloat(0);
				var amountAfterdiscount= parseFloat(0);
				var taxAmount = parseFloat(0);
				var netAmount= parseFloat(0);
	
				total = parseFloat(quantity)* (parseFloat(ratePerMdq) + parseFloat(tax));
				disc = total*(discount/100);
				amountAfterdiscount = total-disc;
				taxAmount = (amountAfterdiscount)*(tax/100)
				netAmount = amountAfterdiscount;
				 
				document.getElementById('amtVar'+rowVal).value=roundVal(netAmount,2);
				//document.getElementById('taxAmount'+rowVal).value=roundVal(taxAmount,2);
				document.getElementById('discountAmount'+rowVal).value=roundVal(disc,2);

				// Calculating converted Stock as Per Formula  & Conversion Login
				var formula = isNaN(parseFloat(document.getElementById('formula'+rowVal).value))==true?"0":parseFloat(document.getElementById('formula'+rowVal).value);
				var conversionFactor = isNaN(parseFloat(document.getElementById('conversionFactor'+rowVal).value))==true?"0":parseFloat(document.getElementById('conversionFactor'+rowVal).value);
				var mdq = isNaN(parseFloat(document.getElementById('mdq'+rowVal).value))==true?"0":parseFloat(document.getElementById('mdq'+rowVal).value);
				var convertedStock = parseFloat(0);
				quantity = parseFloat(quantity) + parseFloat(freeQty); 
				if (formula !=0 && conversionFactor != 0 && mdq != 0)
				{
					if (formula==1)
					{
						convertedStock = (parseFloat(quantity) * parseFloat(mdq)) / parseFloat(conversionFactor);
					}
					else if (formula==2)
					{
						convertedStock = parseFloat(quantity); 
					}
					document.getElementById('convertedStock'+rowVal).value = parseFloat(convertedStock);
				}

			}
		}
		
		
		var rowAmt = parseFloat(0);
		var convertedStock = parseFloat(0);
		var costPrice = parseFloat(0);
	

		//Calculate cost price for all items in the Grid
		for(i=1;i<=25;i++)
		{
		if(document.getElementById('idItem'+i).value.trim()!=0)
		{
		    rowAmt = isNaN(parseFloat(document.getElementById('amtVar'+i).value))==true?0:parseFloat(document.getElementById('amtVar'+i).value);
		 	document.getElementById('amtVar'+i).value = roundVal(rowAmt,2);
		 	convertedStock = isNaN(parseFloat(document.getElementById('convertedStock'+i).value))==true?"0":parseFloat(document.getElementById('convertedStock'+i).value);
		 	if (convertedStock > 0) 
		 		costPrice = parseFloat(rowAmt) / parseFloat(convertedStock);
		 	else
		 		costPrice = parseFloat(0);
		 	document.getElementById('costPrice'+i).value = roundVal(costPrice,3);
		}
		}


	//Calculate Total Loan In Amount 
	var tempNetValue = parseFloat(0);
	for(i=1;i<=25;i++)
	{
		if(document.getElementById('idItem'+i).value.trim()!=0)
		{
		 	var freeItem = document.getElementById('freeItem'+i).value;
			if (freeItem=='n') 
				tempNetValue=parseFloat(tempNetValue)+parseFloat(document.getElementById('amtVar'+i).value);
		}
	}
	document.getElementById('loanInValue').value=roundVal(tempNetValue,2);
 }
 
 function calculationInCRVMod()
 {
 	var sos = document.getElementById('sourceCombo').value
    	for(rowVal=1;rowVal<=40;rowVal++)
		{
		  if(document.getElementById('idItem'+rowVal) != null){
			if(document.getElementById('idItem'+rowVal).value.trim()!=0)
			{
    			var discount = parseFloat(0);
				//var tax = parseFloat(0);
				//var vatApplicable = document.getElementById('vatApplicable');
			
				//Calculation of Amount for the Current Row (rowVal)
    		

				var quantity = isNaN(parseFloat(document.getElementById('quanRec'+rowVal).value))==true?"0":parseFloat(document.getElementById('quanRec'+rowVal).value);
				//var freeQty = isNaN(parseFloat(document.getElementById('freeQty'+rowVal).value))==true?"0":parseFloat(document.getElementById('freeQty'+rowVal).value);
				var ratePerMdq = isNaN(parseFloat(document.getElementById('ratePerMdq'+rowVal).value))==true?"0":parseFloat(document.getElementById('ratePerMdq'+rowVal).value);
				var discount = isNaN(parseFloat(document.getElementById('discountVar'+rowVal).value))==true?"0":parseFloat(document.getElementById('discountVar'+rowVal).value);
				//var tax = isNaN(parseFloat(document.getElementById('taxVar'+rowVal).value))==true?"0":parseFloat(document.getElementById('taxVar'+rowVal).value);

               // if(sos != 'l'){
				//  var tax = isNaN(parseFloat(document.getElementById('taxVar'+rowVal).value))==true?"0":parseFloat(document.getElementById('taxVar'+rowVal).value);
				//}else{
				//  var taxAmt = isNaN(parseFloat(document.getElementById('tax_amt_mdq' + rowVal).value))==true?"0":parseFloat(document.getElementById('tax_amt_mdq' + rowVal).value);
				//  var ed = isNaN(parseFloat(document.getElementById('ed'+rowVal).value))==true?"0":parseFloat(document.getElementById('ed'+rowVal).value);
				//}
				
				
				var total = parseFloat(0);
				var disc= parseFloat(0);
				var amountAfterdiscount= parseFloat(0);
				//var taxAmount = parseFloat(0);
				//var netAmount= parseFloat(0);
	
	
	          //  if(sos != 'l'){
				     total = parseFloat(quantity)*parseFloat(ratePerMdq);
			//	}else{
				// if(vatApplicable.checked){
				//     total = parseFloat(quantity)* parseFloat(ratePerMdq) + ed;
				//  }else{
				  //   total = (parseFloat(quantity)* (parseFloat(ratePerMdq) + parseFloat(taxAmt))) ;
				    // alert("quantity >"+quantity);
				    // alert("ratePerMdq >"+ratePerMdq);
				    // alert("asdasdasd total >"+total);
			//	}
				//}
				
				disc = total*(discount/100);
				amountAfterdiscount = total-disc;
			/*   if(sos != 'l'){
				taxAmount = (amountAfterdiscount)*(tax/100)
				if (vatApplicable.checked)
					{
				     netAmount = amountAfterdiscount;
				}
		 		else{
					 netAmount = amountAfterdiscount + taxAmount;
				 	}
				 }else{
				     netAmount = amountAfterdiscount;
				 }	 */
				 	
				document.getElementById('amtVar'+rowVal).value=roundVal(amountAfterdiscount,2);
				//if(sos != 'l'){
			//	document.getElementById('taxAmount'+rowVal).value=roundVal(taxAmount,4);
			//	}
				//document.getElementById('taxAmount'+rowVal).value=taxAmount;
				document.getElementById('discountAmount'+rowVal).value=roundVal(disc,4);
				//document.getElementById('discountAmount'+rowVal).value=disc;

				// Calculating converted Stock as Per Formula  & Conversion Login
			//	var formula = isNaN(parseFloat(document.getElementById('formula'+rowVal).value))==true?"0":parseFloat(document.getElementById('formula'+rowVal).value);
			//	var conversionFactor = isNaN(parseFloat(document.getElementById('conversionFactor'+rowVal).value))==true?"0":parseFloat(document.getElementById('conversionFactor'+rowVal).value);
				//var mdq = isNaN(parseFloat(document.getElementById('mdq'+rowVal).value))==true?"0":parseFloat(document.getElementById('mdq'+rowVal).value);
				//var convertedStock = parseFloat(0);
			//	quantity = parseFloat(quantity) + parseFloat(freeQty);
				quantity = parseFloat(quantity)
			/*	if (formula !=0 && conversionFactor != 0 && mdq != 0)
				{
					if (formula==1)
					{
						convertedStock = (parseFloat(quantity) * parseFloat(mdq)) / parseFloat(conversionFactor);
					}
					else if (formula==2)
					{
						convertedStock = parseFloat(quantity); 
					}
					document.getElementById('convertedStock'+rowVal).value = parseFloat(convertedStock);
				}*/

			}
		  }	
		}
		
		calculateGRNValueMod(sos);
 } 
function calculateGRNValueMod(sos)
 {//Calculation of Total GRN Value
// 	var exciseDuty=isNaN(parseFloat(document.getElementById('exciseDuty').value.trim()))==true?"0":parseFloat(document.getElementById('exciseDuty').value.trim());
////var freightDuty=isNaN(parseFloat(document.getElementById('freightDuty').value.trim()))==true?"0":parseFloat(document.getElementById('freightDuty').value.trim());
//var octroi=isNaN(parseFloat(document.getElementById('octroi').value.trim()))==true?"0":parseFloat(document.getElementById('octroi').value.trim());
//var insuranceCharges=isNaN(parseFloat(document.getElementById('insuranceCharges').value.trim()))==true?"0":parseFloat(document.getElementById('insuranceCharges').value.trim());
//var otherCharges=isNaN(parseFloat(document.getElementById('otherCharges').value.trim()))==true?"0":parseFloat(document.getElementById('otherCharges').value.trim());
//var customDuty= isNaN(parseFloat(document.getElementById('customDuty').value.trim()))==true?"0":parseFloat(document.getElementById('customDuty').value.trim());

var tempNetValue = parseFloat(0);
var tempCostValue = parseFloat(0);
var charge = parseFloat(0);
var vat = parseFloat(0);
var temp = 0;


for(i=1;i<=40;i++)
{
	if(document.getElementById('idItem'+i).value.trim()!=0)
	{
	 	//var freeItem = document.getElementById('freeItem'+i).value;
		
			tempNetValue=parseFloat(tempNetValue)+parseFloat(document.getElementById('amtVar'+i).value);
			tempCostValue=parseFloat(tempCostValue)+parseFloat(document.getElementById('ratePerMdq'+i).value);
	}
}

// Update Cost Price of All Items in the Grid
// (Duty + VAT) / Total Amt in Grid * Row Amount = Additional Tax
// Row Amount = Row Amount + Additional Tax
// Item Cost Price = Row Amount / Converted Stock

//charge = parseFloat(freightDuty) + parseFloat(exciseDuty) + parseFloat(octroi) + parseFloat(insuranceCharges) + parseFloat(otherCharges) + parseFloat(customDuty);
//var vat = isNaN(parseFloat(document.getElementById('vatTax').value))==true?"0":parseFloat(document.getElementById('vatTax').value);
//var totDiscount = isNaN(parseFloat(document.getElementById('totDiscount').value))==true?"0":parseFloat(document.getElementById('totDiscount').value);
//var vatApplicable = document.getElementById('vatApplicable');
//if (vatApplicable.checked == false)	
//	charge = parseFloat(charge) + parseFloat(vat); 
//charge = parseFloat(charge) - parseFloat(totDiscount) 

var rowAmt = parseFloat(0);
var additionalTax = parseFloat(0);
var convertedStock = parseFloat(0);
var costPrice = parseFloat(0);

/*for(i=1;i<=40;i++)
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
}*/

//Calculate Total Amount 
tempNetValue = parseFloat(0);
tempCostValue= parseFloat(0);

for(i=1;i<=40;i++)
{
	if(document.getElementById('idItem'+i).value.trim()!=0)
	{
	 	//var freeItem = document.getElementById('freeItem'+i).value;
       //  if (freeItem=='n') 
	     tempNetValue=parseFloat(tempNetValue)+parseFloat(document.getElementById('amtVar'+i).value);
	     tempCostValue=parseFloat(tempCostValue)+parseFloat(document.getElementById('ratePerMdq'+i).value);
	}
}


//document.getElementById('grnValue').value=roundVal(tempNetValue,2);
var actualValue=tempNetValue;
var costValue=tempCostValue;
actualValue = roundVal(actualValue,2);
costValue= roundVal(tempCostValue,2);
//var valueAfterRounding=tempNetValue ;
//var valueAfterRounding1 = roundVal(valueAfterRounding,0)
//var roundOffAmount  = valueAfterRounding-valueAfterRounding1;

/*  if (vatApplicable.checked){
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

}else{*/
	    document.getElementById('total_amount').value=actualValue
	  document.getElementById('total_cost').value=costValue
// }

//document.getElementById('grnValue').value=valueAfterRounding
//roundOffAmount=roundVal(roundOffAmount,3);
//document.getElementById('roundOfValue').value=roundOffAmount
//document.getElementById('actualGrnValue').value=actualValue
}
/** function to calculate amount in crv for library module **/
function calculateAmountForCrv(inc){

		
 var discount = parseFloat(0);
 var tax = parseFloat(0);
 var totalCarryForward = 0;
 var grandTotal = 0;

 var hdb = document.getElementById('hdb').value;
 
 if (!isNaN(document.getElementById('totalCarryForward').value))
	totalCarryForward = parseFloat(document.getElementById('totalCarryForward').value);
	
	for(var i=1 ;i<= inc;i++){	
 var quantity = isNaN(parseFloat(document.getElementById('quantity'+i).value))==true?"0":parseFloat(document.getElementById('quantity'+i).value);
 var price = isNaN(parseFloat(document.getElementById('price'+i).value))==true?"0":parseFloat(document.getElementById('price'+i).value);
 var discount = isNaN(parseFloat(document.getElementById('discount'+i).value))==true?"0":parseFloat(document.getElementById('discount'+i).value);
 var tax = isNaN(parseFloat(document.getElementById('tax'+i).value))==true?"0":parseFloat(document.getElementById('tax'+i).value);

 var total = parseFloat(0);
 var disc= parseFloat(0);
 var amountAfterdiscount= parseFloat(0);
 var taxAmount = parseFloat(0);
 var netAmount= parseFloat(0);
 
 total = parseFloat(quantity)*parseFloat(price);
 disc = total*(discount/100);
 amountAfterdiscount = total-disc;
 taxAmount = (amountAfterdiscount)*(tax/100)
 netAmount = amountAfterdiscount + taxAmount;
 
 document.getElementById('amount'+i).value=roundVal(netAmount,2);
 
}
 for(var r =1;r<=hdb;r++){
 grandTotal = grandTotal +parseFloat(document.getElementById('amount'+r).value)
 document.getElementById('total_amount').value = roundVal(grandTotal,2);
	}
 }
 

function calculateAmountTotalCrv(inc){

	alert("i am in calculate total amount");
	// var discount = parseFloat(0);
	// var tax = parseFloat(0);
	// var totalCarryForward = 0;
	 var grandTotal = 0;

	 var hdb = document.getElementById('hdb').value;
	 alert("hdb :"+hdb);
	// if (!isNaN(document.getElementById('totalCarryForward').value))
	//	totalCarryForward = parseFloat(document.getElementById('totalCarryForward').value);
		
	//	for(var i=1 ;i<= inc;i++){	
	// var quantity = isNaN(parseFloat(document.getElementById('quantity'+i).value))==true?"0":parseFloat(document.getElementById('quantity'+i).value);
	// var price = isNaN(parseFloat(document.getElementById('price'+i).value))==true?"0":parseFloat(document.getElementById('price'+i).value);
//	 var discount = isNaN(parseFloat(document.getElementById('discount'+i).value))==true?"0":parseFloat(document.getElementById('discount'+i).value);
//	 var tax = isNaN(parseFloat(document.getElementById('tax'+i).value))==true?"0":parseFloat(document.getElementById('tax'+i).value);

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
	 for(var r =1;r<=hdb;r++){
		// var totalAmt =document.getElementById('amtVar'+r).value;
		 var totalAmt= isNaN(parseFloat(document.getElementById('amtVar'+r).value))==true?"0":parseFloat(document.getElementById('amtVar'+r).value);
		 alert("r value >+"+r);
		 alert("totalAmt >"+totalAmt);
	 grandTotal = grandTotal +totalAmt;
	 alert("grandTotal >"+grandTotal);
	 document.getElementById('total_amount').value = roundVal(grandTotal,2);
		}
	 }
	 


//--------NON EXP-Localsupply----

function gridCalculationNonLSOAdd(rowVal)
{
	var pageNo =parseInt(document.getElementById('pageNo').value) 
	var start=((pageNo-1)*10)+1;
	var end=((pageNo-1)*10)+10;
	var quantity = 0;
	var unitRate = 0;
	var discount = 0;
	var mrp = 0;
	var tax = 0;
	var discountAmount = 0;
	var  discountAuAmount = 0;
	var taxAuAmount = 0;
	var totalAmount = 0;
	var totalAuAmount = 0;
	var grandTotal = 0;
	 var tempqty = parseFloat(0);

	if (!isNaN(document.getElementById('quantityInVarTemp'+rowVal).value))
	quantity = parseFloat(document.getElementById('quantityInVarTemp'+rowVal).value);
	
	if (!isNaN(document.getElementById('discountVarTemp'+rowVal).value))
		discount = parseFloat(document.getElementById('discountVarTemp'+rowVal).value);
		
	if (!isNaN(document.getElementById('mrp'+rowVal).value))
	mrp = parseFloat(document.getElementById('mrp'+rowVal).value);
	
if (!isNaN(document.getElementById('taxVarTemp'+rowVal).value))
	tax = parseFloat(document.getElementById('taxVarTemp'+rowVal).value);

	//if (!isNaN(document.getElementById('quantityInVarTemp'+rowVal).value))
	//	tempqty = parseFloat(document.getElementById('quantityInVarTemp'+rowVal).value);
	
	var formula = isNaN(parseFloat(document.getElementById('formula'+rowVal).value))==true?"0":parseFloat(document.getElementById('formula'+rowVal).value);
	var conversionFactor = isNaN(parseFloat(document.getElementById('conversionFactor'+rowVal).value))==true?"0":parseFloat(document.getElementById('conversionFactor'+rowVal).value);
	if ( quantity > 0 && mrp >0)
	{
		unitRate = mrp ;
		totalAuAmount=parseFloat(unitRate);
		totalAmount = parseFloat(parseInt(quantity) * parseFloat(mrp)) ;
		if (discount > 0)
		{
			discountAmount = totalAmount * (discount / 100);
			discountAuAmount=unitRate * (discount / 100);
			totalAmount = totalAmount - discountAmount;
			totalAuAmount=unitRate-discountAuAmount;
		}
				var disc= parseFloat(0);
				var amountAfterdiscount= parseFloat(0);
				var taxAmount = parseFloat(0);
				var netAmount= parseFloat(0);
		if ( tax > 0){
		
			taxAmount = (totalAmount)*(tax/100)
			taxAuAmount=(totalAuAmount)*(tax/100)
			totalAuAmount=totalAuAmount+taxAuAmount;
			
			totalAmount = totalAmount + taxAmount;
	}

		document.getElementById('quantityInVar'+rowVal).value = parseInt(quantity);
		document.getElementById('amountVarTemp'+rowVal).value =  totalAmount;
		document.getElementById('amountVar'+rowVal).value =totalAmount ;
		
		document.getElementById('costPrice'+rowVal).value =totalAuAmount ;
		document.getElementById('discountAmount'+rowVal).value =discountAmount ;
		document.getElementById('taxAmount'+rowVal).value =taxAmount ;
		
}
	else
	{
		return;
	}
	
}

