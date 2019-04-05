<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showWardList.jsp  
 * Purpose of the JSP -  This is showing Ward List.
 * @author  Deepali
 * @author  Vikas
 * Create Date: 20th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>
<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueM"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script> 
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script> 
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script> 
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link  rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript">
 var nameArray=new Array();
 var codeArray=new Array();
<!--

//-->
</script>
<script type="text/javascript">

	vBulletin_init();

</script>
<%
   int pageNo=1;
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String timeInHHmm="";
	String [] temp = null;
	temp = time.split(":");
	for (int i = 0 ; i < temp.length-1 ; i++) {
		timeInHHmm=timeInHHmm+(String)temp[i];
    	 if(i==0)
    	 {
    		 timeInHHmm=timeInHHmm+":";
    	 }
	}
	List deptList = new ArrayList();
	try {
		deptList=(List)map.get("deptList");
		    session.setAttribute("deptList",deptList);
	} catch (Exception exp) {
		exp.printStackTrace();
	}
	String buttonFlag="";
	String fromDate="";
	String toDate="";
	int deptId=0;
	List issueNoList= new ArrayList();
	if(map.get("buttonFlag") != null)
	{
		buttonFlag=(String)map.get("buttonFlag");
		fromDate=(String)map.get("fromDate");
		toDate=(String)map.get("toDate");
	}
	if(map.get("pageNo") != null)
	{
		pageNo=(Integer)map.get("pageNo");
	}
	if (map.get("issueNoList") != null) {
		issueNoList = (List)map.get("issueNoList");
	}
	if(map.get("deptId") != null)
	{
		deptId=(Integer)map.get("deptId");
	}
	
	String deptName="";
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	
	String issueNoOfWard="";
	if (map.get("issueNoOfWard") != null) {
		issueNoOfWard = (String) map.get("issueNoOfWard");
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int issueNoOfPatient=0;
	if(map.get("issueNoOfPatient") !=null)
	 issueNoOfPatient=(Integer)map.get("issueNoOfPatient");
%>

	<script type="text/javascript" language="javascript">
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String getDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(getDate.length()<2){
			getDate="0"+getDate;
		}
	%>
		serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script>
	<div class="clear"></div>
	<div class="titleBg"><h2>Ward Consumption</h2></div>
	<div class="clear"></div>
	<form name="wardSearch" method="post">
	 <input type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" />
	  <input type="hidden" name="date" id="date" value="<%=pageNo%>" />
	<!--  code to make the search panel -->
	<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<!-- thread search menu -->
	<div class="searchBlock" id="threadsearch_menu" style="display: none">
<div class="clear"></div>	
 					<label>Issue Number</label>
					 <select name="issueNo" id="issueNo">
						<option value="0">Select</option>
						<%
						Iterator iterator=issueNoList.iterator();
			   			 while(iterator.hasNext()){
			    			StoreIpIssueM storeIpIssueM= (StoreIpIssueM) iterator.next();
						%>
						<option value=<%=storeIpIssueM.getIpIssueNo()%>><%=storeIpIssueM.getIpIssueNo()%></option>
					<% } %>
					</select> 
					<input type="button" class="button" value=" " onClick="openPopupForViewStock();" />
					
					
				
	
	</div>
	</form>	
	<!--
	<h4><%=deptName%> </h4>
	--><div class="paddingTop15"></div>
	<form name="deptList" method="post" action="">
		<h4>Ward Schedule</h4>
		   <div class="Block">
		     <label><span> *</span> From Date</label>
			<input type="text" id="fromDateId" name="<%=FROM_DATE %>" value="<%=fromDate %>" class="date" readonly="readonly" MAXLENGTH="30" />
			   <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
		onClick="setdate('<%=date %>',document.deptList.<%=FROM_DATE%>,event)" />
		
			<label ><span> *</span> To Date</label>
			<input type="text" id="ToDateId" name="<%=TO_DATE %>" value="<%=toDate %>" class="date"  MAXLENGTH="30" onblur="validateDate()" onchange="validateDate();" />
			   <img  src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
		 onClick="setdate('<%=date %>',document.deptList.<%=TO_DATE%>,event)" />
		    	<%
						if(map.get("deptId")== null){
					      MasDepartment masDepartment= (MasDepartment)deptList.get(0);
							 deptId=masDepartment.getId();
						}
				%> 
 					<label>Department/ Ward</label>
					<label  class="value" >	    <%=deptName %>  			    </label>
				
				<div class="clear"></div>
			    <label>Current Date</label>
			    <label  class="value" >   <%=date %> </label>
			     <input type="hidden" name="pageNo" value="<%=pageNo %>"  />
				   <input type="hidden" name="deptName" id="deptName"  value="<%=deptName %>" />
				   <input type="hidden" name="deptId" id="deptId"  value="<%=deptId %>" />
				   <input type="hidden" name="date" value="<%=date %>"  />
				   <input type="hidden" name="issueNoOfWard" value="<%=issueNoOfWard %>"  />
				   <input type="hidden" name="buttonFlag" value="<%=buttonFlag %>"  />
				   
				   <input type="hidden" id="storeFyDocumentNoId" value=""  />
		<input type="hidden" id="hinId" value=""  />
		<input type="hidden" id="admissionNumber" value=""  />
		<input type="hidden" name="ipissueno" id="ipissueno" value=""  />
		<input type="hidden" name="date" id="date"  value="<%=date %>"  />
	    <input type="hidden" name="time" id="time"   value="<%=timeInHHmm %>"  />
	    <input type="hidden" name="fromDateToDate" id="fromDateToDate"   value=""  />
				
				<label class="medium">Time </label><label class="small">(hh:mm)</label>
				
				 <label  class="value" >	    <%=timeInHHmm %> </label>
 			   	 <input type="hidden" name="time" value="<%=timeInHHmm %>"  />	
				 
			<!-- <label class="bodytextB">From Date to Date</label>	
				<input type="text" name="fromDateToDate" value=""   MAXLENGTH="30"  />
			-->
		  </div>
		</form>
		<div id="testDiv"></div>
		<script>
		<% if(buttonFlag.equals("next")) { %>
				submitProtoAjax('deptList','/hms/hms/ipd?method=showWardConsumptionJsp');			
		<% } %>
		</script>
<script type="text/javascript">
	/*	function validatePage(formName) {
			
			var counter=document.getElementById('counter').value;
			//alert(counter)
			formname=formName.name
			//alert(formname)
			 for(var i = 0; i < counter; i++)
			 {
			   amountVal = eval('document.'+formname+'.amount' + i + '.value')
			   issQtyVal=eval('document.'+formname+'.issueQty' + i + '.value')
			  // alert("amount value=="+amountVal+"  issued quantity value=="+issQtyVal)
				if(amountVal =="" && issQtyVal != "")
				{
					alert("Please Enter the correct value in Issued Quantity")
					return false
				}
				if(amountVal !="" && issQtyVal == "")
				{
					alert("Please Enter the Issued Quantity")
					return false
				}
		    }
		return true
		}
	*/	
	 
	
	function validateDate() {
			
			var fromDateString=document.getElementById("fromDateId").value
			var toDateString=document.getElementById("ToDateId").value
			var fromDate = new Date(fromDateString.substring(6),(fromDateString.substring(3,5) - 1) ,fromDateString.substring(0,2))
			var toDate = new Date(toDateString.substring(6),(toDateString.substring(3,5) - 1) ,toDateString.substring(0,2))
		if(fromDateString =="")
		{
			alert("Please select the from date first")
			document.getElementById("ToDateId").value="";
			return false;
		}	
		if(fromDateString !="" && toDateString != "" && fromDate>toDate)
		{
			 alert("To Date should be greater than or equal to the From Date.");
			document.getElementById("ToDateId").value="";
			return false;
		}	
		
		submitProtoAjax('deptList','/hms/hms/ipd?method=showWardConsumptionJsp');
		return true;
		}
	
	function fillSrNo(rowVal){
		if(document.getElementById("brandName"+rowVal).value != ""){
			if(document.getElementById("fromDateId").value == "" || document.getElementById("ToDateId").value == ""){
				alert("Please enter from date and to date.");
				return false;
			}
		}
		
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
	
	function checkForBrandWardConsumption(val,inc,deptId,deptName){
		var ipissueno = document.getElementById('ipissueno1').value
		if(val != "")
		{
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;
    	
	    var index1 = val.lastIndexOf("[");
	    var indexForBrandName=index1;
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvmsNo = val.substring(index1,index2);
	    var indexForBrandName=indexForBrandName--;
	    var brandName=val.substring(0,indexForBrandName);
	    if(pvmsNo =="")
	    {
	     return;
	    }	
	    for(i=1;i<inc;i++){
	    
	      if(inc != 1){
	        if(document.getElementById('pvmsNo'+i).value==pvmsNo)
	        {
	    		alert("Item already selected...!")
	    		document.getElementById('brandName'+inc).value=""
	    	var e=eval(document.getElementById('pvmsNo'+inc)); 
	    	e.focus();
	    	  return false;
	        }
	      }  
	   }
	 	ajaxFunctionForAutoCompleteWardConsumption('wardConsumption','ipd?method=fillItemsInGrid&pvmsNo=' +  pvmsNo , inc);
	  }
	}
		
	function fillItemsInGrid(brandId,rowVal,deptId){
		//alert("In fill method"+nameArray.length)
		for(var i=0;i<nameArray.length;i++){
		//alert("nameArray[i][4]=="+nameArray[i][4])
		if(nameArray[i][5]==brandId){
			//alert("in loop=="+i)
			document.getElementById('pvmsNo'+rowVal).value=nameArray[i][1]
			document.getElementById('itemId'+rowVal).value=nameArray[i][2]
			//alert("pvms number==="+document.getElementById('pvmsNo'+rowVal).value)
			document.getElementById('nomenclature'+rowVal).value=nameArray[i][6]
			document.getElementById('noOfRecords').value=rowVal+1;
			//document.getElementById('date').value=nameArray[i][4]
			/*document.getElementById('brandName'+rowVal).value=nameArray[i][3]
			document.getElementById('expiryDate'+rowVal).value=nameArray[i][5]
			*/
			}
		}
		openPopup(brandId,deptId,rowVal);
}	
	
	function openPopup(brandId,deptId,rowVal,deptName){
		var url="/hms/hms/ipd?method=showStockDetailsJsp&brandId="+brandId+"&deptId="+deptId+"&rowVal="+rowVal+"&deptName="+deptName;
        popwindow(url);
     }
	function popwindow(url)
	{
		 newwindow=window.open(url,'name',"height=400,width=1010,status=1");
    }
	function checkForNext(){
	  if(document.getElementById('noOfRecords').value<8)
	  {
	  	alert("All rows are not filled.Please Select the Brand Names to Enter ")
	  	return false;
	  }else{
	  return true;
	  }
  }
   function openPopupForDelete(ipIssueNo){
		var url="/hms/hms/ipd?method=modifyWardConsumptionJsp&ipIssueNo="+ipIssueNo;
        popwindowForDelete(url);
     }
     function openPopupForViewStock(){
     	var issueNo=document.getElementById("issueNo").value;
     	//alert("issueNo---:"+issueNo)
		var url="/hms/hms/ipd?method=viewStockDetailsJsp&issueNo="+issueNo;
        popwindowForDelete(url);
     }
   function popwindowForDelete(url)
	{
		// newwindow=window.open(url,'name',"height=500,width=700,status=1, scrollbars=yes ");
		 newwindow=window.open(url,'name','status=yes,resizable,scrollbars=1,height=400,width=1010,');
		 
    }	
    
     function openpopforItemSearch(count){
	    var url="/hms/hms/opd?method=showItemSearchJsp&count="+count;
	    newwindow=window.open(url,'name',"left=3,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=0");
	}
	
	function jsSetUnitData(id,pvms,nomenclature,count)
	{
	document.getElementById('brandName'+count).value = nomenclature+'['+pvms+']'
	document.getElementById('brandName'+count).focus();	
	}
</script>
