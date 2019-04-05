 /*Grid for Ward Mgmt. By VIKAS------------*/  


showOnSamePage = true;
addAction = true;
rowsPerPage = 10;
totalPages =""
currentColor = "odd";
function makeGrid(starter, end){

    totalPages = Math.ceil(data_arr.length/rowsPerPage);
    document.getElementById("total").innerHTML=totalPages
    document.getElementById("totalRecs").value=data_arr.length
    if(totalPages==0){
	    document.getElementById('searchtable').style.width = "50%"
    	document.getElementById('searchtable').style.textAlign = "left"
        document.getElementById('searchtable').innerHTML = '<h4>No Records Found</h4>'
		document.getElementById('resultnavigation').style.display="none";
        return;
    }
    else if(totalPages == 1){
		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="nextDisable"
		document.paging.nextpage.className="singleNextDisable"    
    }
    document.getElementById('resultnavigation').style.display="inline";
    //document.getElementById('pageno').length=totalPages
    for(pg=1;pg<=totalPages;pg++){
        //document.getElementById('pageno')[pg-1].value = pg
        //document.getElementById('pageno')[pg-1].text = pg            
    }
    start = starter;
    if(data_header){
                tempTable = '<table border="0" cellspacing="0"  cellpadding="0" ><thead><tr>'
        for(cols=0;cols<data_header.length;cols++){
            if(data_header[cols][1]=="data"){
                tempTable += '<th class="gridheadtext" width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                //tempTable += '">'+data_header[cols][0]+'<a href="javascript:sortGrid('+cols+',\'up\')"><img src="/hms/jsp/images/arrowUp.gif" /></a><a href="javascript:sortGrid('+cols+',\'dn\')"><img src="/hms/jsp/images/arrowDown.gif" /></a></th>'
                tempTable += '">'+data_header[cols][0]+'</th>'
            }
            else if(data_header[cols][1]=="hide"){
                    tempTable += '<th class="hide">&nbsp;</th>'
            }else if(data_header[cols][1]=="radio"){
            		 tempTable += '<th class="gridheadtext" width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                tempTable += '">'+data_header[cols][0]+'</th>'
            	}
        }
        tempTable += '<tr></thead><tbody id="searchresulttable">'
        for(rows=start;rows<end; rows++){
                tempTable += '<tr id="'+data_arr[rows][0]+'" class="'
				if(rows%rowsPerPage == 0 && rows != 0){
					currentColor = "odd"	
				}

                tempTable += currentColor;   	            
				currentColor = (currentColor == "odd")?"even" : "odd";
                tempTable += '">'    
                for(columns=1;columns<=data_header.length;columns++){
                    tempTable += '<td '
                    if(data_header[columns-1][1] == "hide")
                        tempTable += 'class="hide"';
                    tempTable +='>'
                    if(showOnSamePage){
                    if(formName!="nursingCareEntryDetail"){                    
                    	tempTable += '<a href="javascript:editRecord(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                    	}
               		}else if(addAction){
                    	tempTable += '<a href="'+ goToUrl +'&id='+data_arr[rows][0]+'">';
               			//tempTable += '<a href="#" onclick="parent.location=\''+ goToUrl +'&id='+data_arr[rows][0]+'\'">';
               		}
                    else 
                    	tempTable += '<a href="'+ goToUrl +'&'+data_arr[rows][0]+'.action">';
                    
                    tempTable +=data_arr[rows][columns]
                    tempTable +='</a></td>'                    
                }
               tempTable += '</tr>'
        }
        tempTable += '</tbody></table>'
                            
        document.getElementById('searchtable').innerHTML = tempTable;
    }
    
    if(document.paging.pageno.value == 1){
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="previousDisable"
		document.paging.prevpage.className="singlePrevDisable"    
    
    }    
}
/*
  for editing the grid
  */
subtest_arr = new Array();
currentRowClicked=""
nonEditable="";


function editRecord(obj,formName){

	tmptext = ""	
	if(currentRowClicked != "" ){
		if(subtest_arr.length>0){
			document.chargeCode.multipleresults.checked= false;
			document.getElementById('multiplebutton').style.display = 'none';
		}
		if(nonEditable){
			for(m=0;m<nonEditable.length;m++){
				nonEditableObj = eval("document."+ formName + "."  + nonEditable[m])
				if(nonEditableObj){
					if(nonEditableObj.type == "select-one"){
						nonEditableObj.disabled = false;			
					}
					else
						nonEditableObj.readOnly = false;
				}
			}
		}
		if(document.getElementById(currentRowClicked))
			document.getElementById(currentRowClicked).style.backgroundColor = "";
		document.getElementById('edited').innerHTML = " "
		if(document.getElementById('addbutton'))
			document.getElementById('addbutton').style.display = 'none'
		if(document.getElementById('editbutton'))	
			document.getElementById('editbutton').style.display = 'none';	
		if(document.getElementById('deletebutton'))	
			document.getElementById('deletebutton').style.display = 'none';			
		for(i=0;i<formFields.length;i++){
			
			temp = eval("document."+ formName + "." +  formFields[i][1])
			if(temp){
				if(temp.type == "select-one")
					temp.selectedIndex = 0;
				else if(temp.type == "checkbox"){
						temp.checked = false;
				}
				else
					temp.value = "";
			}
		}
	}
	
	if(currentRowClicked != obj.id){
		
		if(document.getElementById('editbutton'))
			document.getElementById('editbutton').style.display = 'inline'
		if(document.getElementById('deletebutton'))
			document.getElementById('deletebutton').style.display = 'inline'		
		if(document.getElementById('addbutton'))	
			document.getElementById('addbutton').style.display = 'none';
		if(subtest_arr.length>0){
			chkMultipleTest(obj.id);
		}
		if(nonEditable){
			for(m=0;m<nonEditable.length;m++){
				nonEditableObj = eval("document."+ formName + "."  + nonEditable[m])
				if(nonEditableObj){
					if(nonEditableObj.type == "select-one"){
						nonEditableObj.disabled = true;			
					}
					else
						nonEditableObj.readOnly = true;
				}
			}
		}
		obj.style.backgroundColor = '#9CCEF8'
		currentRowClicked=obj.id;
		for(i=0;i<formFields.length;i++){
			temp = eval("document."+ formName + "."  +  formFields[i][1])
			if(formFields[i][1] == "addEditBy")
				tmptext += "<label style='float: left; width: 230px'>last Edited By:</label><span style='width: 180px'>"+ obj.cells[formFields[i][0]-1].childNodes[0].innerHTML +"</span>"
			if(formFields[i][1] == "addEditOn")
				tmptext += "<label style='float: left; width: 90px'>On:</label><span style='width: 180px'>"+ obj.cells[formFields[i][0]-1].childNodes[0].innerHTML +"</span>"				
			if(temp){
				if(temp.type == "select-one"){
					if(formName == "subTest")
						temp.selectedIndex = findElementIndex(temp, obj.cells[formFields[i][0]-1].innerHTML);
					else
						temp.selectedIndex = findElementIndex(temp, obj.cells[formFields[i][0]-1].childNodes[0].innerHTML);
				}
				else if(temp.type == "radio"){
					if(obj.cells[formFields[i][0]-1].childNodes[0].innerHTML == '1' || obj.cells[formFields[i][0]-1].childNodes[0].innerHTML == 'y')
						temp.checked = obj.cells[formFields[i][0]-1].childNodes[0].innerHTML;
				}
				else if(temp.type == "checkbox"){
					if(obj.cells[formFields[i][0]-1].childNodes[0].innerHTML == '1' || 	obj.cells[formFields[i][0]-1].childNodes[0].innerHTML=='y'){
						temp.checked = obj.cells[formFields[i][0]-1].childNodes[0].innerHTML;
					}
				}
				else{
					if(i==0)
						temp.value = obj.id;
					else{
						if(formName == "subTest"){
							temp.value = obj.cells[formFields[i][0]-1].innerHTML;
						}
						else
							temp.value = obj.cells[formFields[i][0]-1].childNodes[0].innerHTML;
						if(temp.value.indexOf('&amp;') != -1){
							temp.value = replaceSubstring(temp.value, '&amp;', '&')
						}
					}
				}
			}
		}
	}
	else if(currentRowClicked == obj.id){
		if(subtest_arr.length>0){
			document.chargeCode.multipleresults.checked= false;
			document.getElementById('multiplebutton').style.display = 'none';
		}
		currentRowClicked = "";
	}
	if(tmptext != ""){
		document.getElementById('edited').innerHTML = tmptext;	
	}
}
  
  /*
  for editing the grid
  */
  
  
  
  


function navigateIPD(obj){
	document.paging.firstpage.style.border = "none"
	document.paging.nextpage.style.border = "none"
	document.paging.lastpage.style.border = "none"
	document.paging.prevpage.style.border = "none"		
	//currentPage = document.paging.pageno.value;
	initTabButtons()
	if(obj.value == 'f' && data_arr.length>rowsPerPage){
		makeGrid(0,rowsPerPage);
		//document.getElementById('pageno').value=1
		
		document.getElementById("current").innerHTML=1
	
		document.getElementById("currStart").innerHTML=1
		document.getElementById("currEnd").innerHTML=5
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="previousDisable"
		document.paging.prevpage.className="singlePrevDisable"	

		document.paging.lastpage.disabled= false;
		document.paging.nextpage.disabled= false;
		document.paging.lastpage.className="next"
		document.paging.nextpage.className="singleNext"			
	}
	else if(obj.value == 'p'){
		if(start-rowsPerPage>=0){
			document.paging.lastpage.disabled= false;
			document.paging.nextpage.disabled= false;
			document.paging.lastpage.className="next"
			document.paging.nextpage.className="singleNext"	
			if(start==rowsPerPage){
				document.paging.firstpage.disabled= true;
				document.paging.prevpage.disabled= true;
				document.paging.firstpage.className="previousDisable"
				document.paging.prevpage.className="singlePrevDisable"	
			}
			else{
				document.paging.firstpage.disabled= false;
				document.paging.prevpage.disabled= false;
				document.paging.firstpage.className="previous"
				document.paging.prevpage.className="singlePrev"	
			}
			makeGrid(start-rowsPerPage,start);
			//document.getElementById('pageno').value--;
			document.getElementById("currStart").innerHTML=(document.getElementById("current").innerHTML-2)*5+1
				document.getElementById("currEnd").innerHTML=(document.getElementById("current").innerHTML-1)*5
				document.getElementById("current").innerHTML--;
			
		}

	}
	else if(obj.value == 'n'){
		if(start+rowsPerPage*2<data_arr.length){
			makeGrid(start+rowsPerPage,start+(rowsPerPage*2));
			
			//document.getElementById('pageno').value++;
			var tt=document.getElementById("current").innerHTML;
			
			document.getElementById("currStart").innerHTML=(tt)*5+1
				document.getElementById("currEnd").innerHTML=((tt*1)+1)*5
			document.getElementById("current").innerHTML++;
			
			document.paging.firstpage.disabled= false;
			document.paging.prevpage.disabled= false;
			document.paging.firstpage.className="previous"
			document.paging.prevpage.className="singlePrev"					
			
		}
		else if(start+rowsPerPage<data_arr.length){
			makeGrid(start+rowsPerPage,data_arr.length);
			//document.getElementById('pageno').value++;		
			document.getElementById("currStart").innerHTML=(document.getElementById("current").innerHTML)*5+1
				document.getElementById("currEnd").innerHTML=data_arr.length
			document.getElementById("current").innerHTML++;	
			document.paging.lastpage.disabled= true;
			document.paging.nextpage.disabled= true;
			document.paging.lastpage.className="nextDisable"
			document.paging.nextpage.className="singleNextDisable"	
			
			document.paging.firstpage.disabled= false;
			document.paging.prevpage.disabled= false;
			document.paging.firstpage.className="previous"
			document.paging.prevpage.className="singlePrev"								
		}
	}
	else if(obj.value == 'l'){
		if(data_arr.length % rowsPerPage == 0) {
			makeGrid(data_arr.length - rowsPerPage, data_arr.length);
			//document.getElementById('pageno').value=totalPages;
			document.getElementById("currStart").innerHTML=data_arr.length-4
				document.getElementById("currEnd").innerHTML=data_arr.length
			document.getElementById("current").innerHTML=totalPages
		} else {
			makeGrid((data_arr.length - (data_arr.length % rowsPerPage)), data_arr.length);
			//document.getElementById('pageno').value=totalPages;
			document.getElementById("currStart").innerHTML=data_arr.length-4
				document.getElementById("currEnd").innerHTML=data_arr.length
			document.getElementById("current").innerHTML=totalPages
		}
		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="nextDisable"
		document.paging.nextpage.className="singleNextDisable"	
		
		document.paging.firstpage.disabled= false;
		document.paging.prevpage.disabled= false;
		document.paging.firstpage.className="previous"
		document.paging.prevpage.className="singlePrev"	
	}
	if(!obj.disabled){
		obj.style.border = "1px solid yellow"
	}
}

var sortNo;
function sortGrid(no,dir){
	document.paging.firstpage.disabled= true;
	document.paging.prevpage.disabled= true;
	document.paging.firstpage.className="previousDisable"
	document.paging.prevpage.className="singlePrevDisable"	
	document.paging.lastpage.disabled= false;
	document.paging.nextpage.disabled= false;
	document.paging.lastpage.className="next"
	document.paging.nextpage.className="singleNext"		
    sortNo = no;
    data_arr.sort(mysortfn)
        if(dir == 'dn'){
            data_arr.reverse();
        }
      
    if(data_arr.length<rowsPerPage)    
  	  makeGrid(0,data_arr.length)
  	else
	    makeGrid(0,rowsPerPage)
    //document.getElementById('pageno').value=1
    document.getElementById("currStart").innerHTML=1
				document.getElementById("currEnd").innerHTML=5
    document.getElementById("current").innerHTML=1
}



function goToPageForPatient(pageno){
	
	if( (pageno>totalPages) || (pageno<=0) || (pageno%1!=0) )
	{
	alert("Please Enter Page No.")
	document.paging.pageno.value=""
	return false;
	}
	if(pageno == 1){
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="previousDisable"
		document.paging.prevpage.className="singlePrevDisable"		
	
		document.paging.lastpage.disabled= false;
		document.paging.nextpage.disabled= false;
		document.paging.lastpage.className="next"
		document.paging.nextpage.className="singleNext"	
	}
	else if(pageno == totalPages){
		document.paging.firstpage.disabled= false;
		document.paging.prevpage.disabled= false;
		document.paging.firstpage.className="previous"
		document.paging.prevpage.className="singlePrev"		
	
		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="nextDisable"
		document.paging.nextpage.className="singleNextDisable"		
	}
	else{
		document.paging.firstpage.disabled= false;
		document.paging.prevpage.disabled= false;
		document.paging.firstpage.className="previous"
		document.paging.prevpage.className="singlePrev"		
	
		document.paging.lastpage.disabled= false;
		document.paging.nextpage.disabled= false;
		document.paging.lastpage.className="next"
		document.paging.nextpage.className="singleNext"		
	}
	if(pageno*rowsPerPage<data_arr.length)
		makeGridForPatient(pageno*rowsPerPage-rowsPerPage,pageno*rowsPerPage)
	
	else
		makeGridForPatient(pageno*rowsPerPage-rowsPerPage,data_arr.length)
		
		document.getElementById("currStart").innerHTML=(pageno-1)*10+1
		document.getElementById("currEnd").innerHTML=(pageno)*10
		
		document.getElementById("current").innerHTML=pageno
		
		
	    document.paging.pageno.value=""	
	
}
/*Grid for Ward Mgmt. By VIKAS---------Ends*/



function makePopupGrid(starter, end){


    totalPages = Math.ceil(data_arr.length/rowsPerPage);
    document.getElementById("total").innerHTML=totalPages
    document.getElementById("totalRecs").innerHTML=data_arr.length
    if(totalPages==0){
	    document.getElementById('searchtable').style.width = "75%"
    	document.getElementById('searchtable').style.textAlign = "left"
        document.getElementById('searchtable').innerHTML = '<h4>No Records Found</h4>'
		document.getElementById('resultnavigation').style.display="none";
        return;
    }
    else if(totalPages == 1){
		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="nextDisable"
		document.paging.nextpage.className="singleNextDisable"    
    }
    document.getElementById('resultnavigation').style.display="inline";
    //document.getElementById('pageno').length=totalPages
    for(pg=1;pg<=totalPages;pg++){
        //document.getElementById('pageno')[pg-1].value = pg
        //document.getElementById('pageno')[pg-1].text = pg            
    }
    start = starter;
    if(data_header){
                tempTable = '<table border="0" cellspacing="0"  cellpadding="0" ><thead><tr>'
        for(cols=0;cols<data_header.length;cols++){
            if(data_header[cols][1]=="data"){
                tempTable += '<th  width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                tempTable += '">'+data_header[cols][0]+'<a href="javascript:sortGrid('+cols+',\'up\')"><img src="/hms/jsp/images/arrowUp.gif" /></a><a href="javascript:sortGrid('+cols+',\'dn\')"><img src="/hms/jsp/images/arrowDown.gif" /></a></th>'
            }
            else if(data_header[cols][1]=="hide"){
                    tempTable += '<th class="hide">&nbsp;</th>'
            }else if(data_header[cols][1]=="radio"){
            		 tempTable += '<th  width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                tempTable += '">'+data_header[cols][0]+'</th>'
            	}
        }
        tempTable += '<tr></thead><tbody id="searchresulttable">'
        for(rows=start;rows<end; rows++){
                tempTable += '<tr id="'+data_arr[rows][0]+'" class="'
				if(rows%rowsPerPage == 0 && rows != 0){
					currentColor = "odd"	
				}

                tempTable += currentColor;   	            
				currentColor = (currentColor == "odd")?"even" : "odd";
                tempTable += '">'    
                for(columns=1;columns<=data_header.length;columns++){
                    tempTable += '<td '
                    if(data_header[columns-1][1] == "hide")
                        tempTable += 'class="hide"';
                    tempTable +='>'
                    if(showOnSamePage)
                    	tempTable += '<a href="javascript:editRecord(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
               		else if(addAction){
                    	tempTable += '<a href="'+ goToUrl +'&id='+data_arr[rows][0]+'">';
               		//	tempTable += '<a href="#" onclick="parent.location=\''+ goToUrl +'&id='+data_arr[rows][0]+'\'">';
               		}
                    else 
                    	tempTable += '<a href="'+ goToUrl +'&'+data_arr[rows][0]+'.action">';
                    
                    tempTable +=data_arr[rows][columns]
                    tempTable +='</a></td>'                    
                }
               tempTable += '</tr>'
        }
        tempTable += '</tbody></table>'
                            
        document.getElementById('searchtable').innerHTML = tempTable;
    }
    
    if(document.paging.pageno.value == 1){
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="previousDisable"
		document.paging.prevpage.className="singlePrevDisable"    
    
    }    
}







function setHeaderValuesForWard(rowVal){
	//alert("in setHeaderValuesForWard "+window.opener.document.getElementById('time').value)
	//alert("hallo")
	document.getElementById('itemId').value =window.opener.document.getElementById('itemId'+rowVal).value ;
	document.getElementById('date').value=window.opener.document.getElementById('date').value ; 
	document.getElementById('time').value=window.opener.document.getElementById('time').value ;
	document.getElementById('fromDate').value=window.opener.document.getElementById('fromDate').value ;
	document.getElementById('toDate').value=window.opener.document.getElementById('toDate').value ;
	document.getElementById('ipissueno').value=window.opener.document.getElementById('ipissueno').value ;
	document.getElementById('storeFyDocumentNoId').value=window.opener.document.getElementById('storeFyDocumentNoId').value ;
	document.getElementById('deptId').value=window.opener.document.getElementById('deptId').value ;
 
   
   return true;
}
function setHeaderValuesForPatientIssue(rowVal){
	
	document.getElementById('itemId').value =window.opener.document.getElementById('itemId'+rowVal).value ;
	document.getElementById('date').value=window.opener.document.getElementById('date').value ; 
	document.getElementById('time').value=window.opener.document.getElementById('time').value ;
	document.getElementById('ipissueno').value=window.opener.document.getElementById('ipissueno').value ;
	document.getElementById('storeFyDocumentNoId').value=window.opener.document.getElementById('storeFyDocumentNoId').value ;
	document.getElementById('deptId').value=window.opener.document.getElementById('deptId').value ;
	document.getElementById('hinId').value=window.opener.document.getElementById('hinId').value ;
	document.getElementById('admissionNumber').value=window.opener.document.getElementById('admissionNumber').value ;
	
 
   
   return true;
}


function fillSrNo(rowVal){
		
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
   			rowVal=rowVal%8
   			if(rowVal==0){
   				rowVal=8
   	 			}
   		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	return true;
 }

	
     function validateConsultant(formName,rowVal) {
			formname=formName.name
			
			   //consultantName = eval('document.'+formname+'.amount' + i + '.value')
			   consultantName=eval('document.'+formname+'.consultingDoctor.value')
			   prescription=eval('document.'+formname+'.prescriptionNo.value')
			   fromDate = eval('document.'+formname+'.issue_date.value')
			   toDate = eval('document.'+formname+'.issue_to_date.value')
			 //  alert(consultantName)
			   
			   //alert("amount value=="+amountVal+"  issued quantity value=="+issQtyVal)
			   
				if(fromDate == ""){
				   alert("Please Select Issue From Date.")
				   document.getElementById('nomenclature'+rowVal).value=""
				   document.getElementById('lotNo'+rowVal).value=""
				   'document.'+formname+'.issue_date.focus()'
					return false
				}
				if(toDate == ""){
				   alert("Please Select Issue To Date.")
				   document.getElementById('nomenclature'+rowVal).value=""
				   document.getElementById('lotNo'+rowVal).value=""
				   'document.'+formname+'.issue_to_date.focus()'
					return false
				}
				
				if(fromDate != "" && toDate != ""){
				
					var fromDate1 = new Date(fromDate.substring(6),(fromDate.substring(3,5) - 1) ,fromDate.substring(0,2))
				    var toDate1 = new Date(toDate.substring(6),(toDate.substring(3,5) - 1) ,toDate.substring(0,2))
					if(toDate1 < fromDate1)
				    {
					alert("'Issue From Date' should not be greater than 'Issue To Date'.")
					 document.getElementById('nomenclature'+rowVal).value=""
				     document.getElementById('lotNo'+rowVal).value=""
					return false;
				    }
				}
				//if(consultantName == "0")
				//{
				//	alert("Please Select the Consultant Name ")
				//	document.getElementById('nomenclature'+rowVal).value=""
				//	document.getElementById('lotNo'+rowVal).value=""
				//	'document.'+formname+'.consultingDoctor.focus()'
				//	return false
				//}
				//if(prescription == "")
				//{
				//	alert("Please Enter the Prescription Number ")
				//	document.getElementById('nomenclature'+rowVal).value=""
				//	document.getElementById('lotNo'+rowVal).value=""
				//	'document.'+formname+'.prescriptionNo.focus()';
				//	return false
			//	}
		    fillSrNo(rowVal)
		return true
		}
		
		function fillSrNo(rowVal){
		
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
   			rowVal=rowVal%8
   			if(rowVal==0){
   				rowVal=8
   	 			}
   		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	return true;
}
		
		function fillValuesForLotNo(lotNo,inc,deptId,formName){
	
		if(lotNo != "")
		{
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;
	   }
	   
		ajaxFunctionForAutoCompleteLotNO('opdPatient','stores?method=fillItemsInGridForLotNo&lotNo=' +  lotNo , inc);
		
		document.getElementById('empId').value=document.getElementById('consultant').value;
		document.getElementById('prescription').value=document.getElementById('prescriptionNo').value;
		
		openPopupForLotNo(lotNo,inc,deptId);
		var nomenclature=document.getElementById('nomenclature'+inc)
			nomenclature.disabled = true
	  }
	
	 function openPopupForLotNo(lotNo,rowVal,deptId){
		var url="/hms/hms/stores?method=showRecordsForLotNo&lotNo="+lotNo+"&rowVal="+rowVal+"&deptId="+deptId;
        popwindow(url);
     }
     
     function popwindow(url)
	{
		 newwindow=window.open(url,'name',"height=400,width=700,status=1");
    }
	
	
		
/*
		Function to open pop up window
*/

/*
		To fill the items in the grid on onblur event
*/
