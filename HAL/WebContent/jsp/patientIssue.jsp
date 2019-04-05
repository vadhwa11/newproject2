<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants,java.math.BigDecimal"%>


<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<script type="text/javascript" src="/hms/jsp/js/autocomplete.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

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
vBulletin_init();
// -->
var nameArray=new Array();
var codeArray=new Array();
</script>
<style>
#contentspace label {
	text-align: right;
	width: 90px;
	float: left;
	height: 9px;
}
</style>
<%
	
	 int pageNo=1;
	String buttonFlag="";
	Map map = new HashMap();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	
	}
	if(map.get("buttonFlag") != null)
	{
		buttonFlag=(String)map.get("buttonFlag");
		
		//System.out.println( "===and button falg in jsp==="+buttonFlag);
	}
	if(map.get("pageNo") != null)
	{
		pageNo=(Integer)map.get("pageNo");
		
		//System.out.println( "===and page number in jsp==="+pageNo);
	}
	String deptName="";
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	
		int deptId = (Integer)map.get("deptId");
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date=(String)utilMap.get("currentDate");
		String time=(String)utilMap.get("currentTime");
		String timeInHHmm="";
		String [] tempArr = null;
		tempArr = time.split(":");
		for (int i = 0 ; i < tempArr.length-1 ; i++) {
			
			timeInHHmm=timeInHHmm+(String)tempArr[i];
	    	 if(i==0)
	    	 {
	    		 timeInHHmm=timeInHHmm+":";
	    	 }
	    	 
		}
		System.out.println("Date============"+date);
		System.out.println("Time============"+time);
		
	
	
	
	List inPatientDetailList = new ArrayList();
	try {
					
					if (map.get("inPatientDetailList") != null) {
						inPatientDetailList = (List)map.get("inPatientDetailList");
					}
		
	} catch (Exception exp) {
		exp.printStackTrace();
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	%>
<!-- <jsp:include page="searchResultPO.jsp" />-->

<!-- </form> -->

<form name="patientIssue" method="post">
<%
		String admissionNumber=null;
		int hinId=0;
		int inpatientId=0;
		if(inPatientDetailList != null)
		   {
			String patientName= "";
			String consultantName="";
			String serviceNo="";
			String maritialStatus="";
			String unitName="";
		    String rankName="";
		    String sex="";
		    String diagnosis="";
		    String initDiagnosis="";
			   Inpatient inPatientDetail=(Inpatient)inPatientDetailList.get(0);
			    hinId=inPatientDetail.getHin().getId();
			    inpatientId=inPatientDetail.getId();
			    MasIcd masIcd=(MasIcd)inPatientDetail.getDiagnosis();
			    if(inPatientDetail.getInitDiagnosis() !=null)
			    initDiagnosis =inPatientDetail.getInitDiagnosis();
			   if(inPatientDetail.getHin().getPFirstName() != null)
			   {
		       patientName=inPatientDetail.getHin().getPFirstName();
			   }
			   if(inPatientDetail.getHin().getPMiddleName() != null)
				   {
				   patientName +=" "+inPatientDetail.getHin().getPMiddleName();
				   }
			   if(inPatientDetail.getHin().getPLastName() != null)
				   {
				   patientName +=" "+inPatientDetail.getHin().getPLastName();
				   }
			   if(inPatientDetail.getDoctor().getFirstName()!= null)
			   {
				   consultantName=inPatientDetail.getDoctor().getFirstName();
			   }
			   if(inPatientDetail.getDoctor().getMiddleName() != null)
			   {
				   consultantName+=" "+inPatientDetail.getDoctor().getMiddleName();
			   }
			   if(inPatientDetail.getDoctor().getLastName() != null)
			   {
				  consultantName+= " "+inPatientDetail.getDoctor().getLastName();
			   }
			   
			   if(inPatientDetail.getHin().getServiceNo() != null && inPatientDetail.getHin().getServiceNo() != "")
			     {
			    	 serviceNo= inPatientDetail.getHin().getServiceNo();
			     }
			   else
			     {
				   serviceNo="-";			    	 
			     }
			   if(inPatientDetail.getDiagnosis() != null)
			   {
				   diagnosis=masIcd.getIcdName();
			   }else{
				   diagnosis="-";
			   }
			   
			   
		       if(inPatientDetail.getHin().getMaritalStatus() != null)
		       {
		        maritialStatus = inPatientDetail.getHin().getMaritalStatus().getMaritalStatusName();
		        
		       }
		       if(inPatientDetail.getAdNo() != null)
		       {
		    	   admissionNumber=inPatientDetail.getAdNo();   
		       }else{
		    	   admissionNumber="-";
		       }
		       
		      
		       if(inPatientDetail.getHin().getUnit() != null)
		       {
		        unitName=inPatientDetail.getHin().getUnit().getUnitName();
		       }else{
		    	   unitName="-";
		       }
		       if(inPatientDetail.getHin().getRank() != null)
		       {
		    	   
		        rankName=inPatientDetail.getHin().getRank().getRankName();
		       }else{
		    	   rankName="-";
		       }
		       if(inPatientDetail.getHin().getSex()!= null)
		       {
		    	   sex=inPatientDetail.getHin().getSex().getAdministrativeSexName();
		       }else{
		    	 sex="-";  
		       }
		       System.out.println("Unit name in jsp========***********************"+ unitName+"========Rank name in jsp==="+rankName);
		%> <br />
<div class="titleBg"><h2>Patient Issue</h2></div>
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="block">
<label>Patient Name</label>
<label class="value"> <%= patientName %></label>
<label>Service No.</label>
<label class="value"> <%=serviceNo%></label>
<label>Admission No.</label>
<label class="value"><%=admissionNumber %></label>


<div class="clear"></div>


<label>Ward Name</label> <%if(inPatientDetail.getDepartment().getDepartmentName() != null){%>
<label class="value"> <%=inPatientDetail.getDepartment().getDepartmentName() %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>
<label>Age</label>
<%if(inPatientDetail.getAge() != null){ %>
<label class="value"><%=inPatientDetail.getAge() %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>
<label>Sex</label>
<label class="value"><%=sex%></label>


<div class="clear"></div>


<label>Rank</label>
<label class="value"><%=rankName %></label>
<label>Unit</label>
<label class="value"><%=unitName %></label>
<label>Consultant</label>
<label class="value"><%=consultantName %></label>


<div class="clear"></div>


<label>Diagnosis</label>
<label class="valueAuto"><%=diagnosis%></label>


<div class="clear"></div>


<label>Init Diagnosis</label>
<label class="valueAuto"><%=initDiagnosis%></label>

<%}%>
</div>
<div class="clear paddingTop15"></div>

<input type="hidden"	name="pageNo" id="pageNo" value="<%=pageNo%>" />
<%
		List ipIssueNo=(List)map.get("ipIssueNo");
		StoreFyDocumentNo storeFyDocumentNo= (StoreFyDocumentNo)ipIssueNo.get(0);
		int issueNoOfPatient=(Integer)map.get("issueNoOfPatient");
	%> 
	<div id="testDiv">
<div class="Block">	
<label>IP Issue No. </label>
<label class="value"><%= issueNoOfPatient%></label>
<input type="hidden" id="storeFyDocumentNoId"	value="<%= storeFyDocumentNo.getId()%>" />
<input type="hidden" id="hinId" value="<%= hinId%>" />
<input type="hidden"	id="admissionNumber" value="<%= admissionNumber%>" />
<input	type="hidden" id="ipissueno" value="<%=issueNoOfPatient%>" />
<input	type="hidden" name="date" id="date" value="<%=date %>" />
<input	type="hidden" name="time" id="time" value="<%=timeInHHmm %>" />
<input	type="hidden" name="fromDateToDate" id="fromDateToDate" value="" />
	<label>Issue Date</label>
<label class="value"><%= date%></label>

<label>Time</label>
<label class="value"><%= timeInHHmm%></label>


<input type="hidden" size="2" value="" name="noOfRecords"	id="noOfRecords" />
<!-- <input type="hidden" name="<%=RequestConstants.STORE_ITEM_BATCH_STOCK_ID %>" value="" id="hdb" /> -->
<input type="hidden" value="<%= deptId%>" name="deptId" id="deptId" />
<!-- if(checkForNext()){submitForm('wardConsumption','ipd?method=showWardConsumptionJsp&buttonFlag=next');} -->
</div>
<div class="clear paddingTop15"></div>
<div id="pagination">
Page No.<span class="selected"><%=pageNo%></span></div>
<div class="cmntable">
<table width="100%" colspan="7" id="stockDetails" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="5%">	SR No 	</th>
			<th width="15%">PVMS No	</th>
			<th width="19%">Nomenclature</th>
			<th width="15%">A/U</th>
			<th>Total Quantity Issued </th>
		</tr>
	</thead>


	<tbody>
		<%
    	int detailCounter=8; 
    	int temp=0;
    	    	
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=8;inc++){
     		
     %>
		<tr>
			<td width="5%">
			<input type="text" size="2" value="<%=temp+inc%>" name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
			<td width="15%"><input type="text" 	name="pvmsNo<%=inc%>" id="pvmsNo<%=inc%>" readonly /><input
				type="hidden" name="itemId<%=inc%>" id="itemId<%=inc %>" value="" />
			</td>
			<td width="15%"><input type="text" value="" tabindex="1"
				id="brandName<%=inc%>" size="80" name="brandName<%=inc%>"
				onblur="if(fillSrNo('<%=inc %>')){checkForBrand(this.value, '<%=inc %>','<%=deptId %>','<%=deptName %>');}" />
			<div id="ac2update"	style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('brandName<%=inc%>','ac2update','ipd?method=getItemList',{parameters:'requiredField=brandName<%=inc%>'});
			</script></td>


			<td width="19%"><input type="text" value=""	id="nomenclature<%=inc%>" 
				name="<%=RequestConstants.NOMENCLATURE%>" /></td>

			<td width="46%"><input type="text" value="" name="<%=RequestConstants.QTY_ISSUED%>" id="qtyIssued<%=inc%>"
				readonly /></td>
		</tr>
		<%} %>
	</tbody>
</table>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Next" onclick="if(checkForNext()){submitForm('patientIssue','ipd?method=showPatientIssueJsp&buttonFlag=next&deptId=<%=deptId%>&parent=<%=inpatientId%>&issueNoOfPatient=<%=issueNoOfPatient%>&deptName=<%=deptName%>');}"	align="right" />
<input type="button" class="button" value="Back"	align="left"	onClick="submitForm('patientIssue','ipd?method=showPatientListJsp');" />
<input type="button" class="button" value="Delete"	onclick="openPopupForDelete(<%=issueNoOfPatient%>);" align="right" />
<input type="button" class="button" value="View" align="right"	onClick="openPopupForView('<%=admissionNumber%>');" />
<input	type="hidden" name="rows" id="rr" value="1" />
</div>
</form>
<div class="clear"></div>
<div class="division"></div>

<script type="text/javascript">

	


	function validatePage(formName) {
			
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
	
	function fillSrNo(rowVal){
		
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
   			rowVal=rowVal%8
   			if(rowVal==0){
   				rowVal=8
   	 			}
   		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
   	   		if(document.getElementById('brandName'+rowVal).value != "")
 		  		document.getElementById('noOfRecords').value=rowVal
			}
	return true;
}

function checkForBrand(val,inc,deptId,deptName){
	
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
	   		document.getElementById('pvmsNo'+inc).value = "";
	   		document.getElementById('brandName'+inc).value = "";
	   		document.getElementById('nomenclature'+inc).value = "";
	   		document.getElementById('qtyIssued'+inc).value = "";	
	      return;
	    }
	   
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
		ajaxFunctionForAutoCompletePatientIssue('patientIssue','ipd?method=fillItemsInGrid&pvmsNo='+pvmsNo,inc);
	
			//openPopupForPatientIssue(inc);
	  }
	 
	
	
	
	function popwindow(url)
	{
		 newwindow=window.open(url,'name',"height=500,width=800,status=1");
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
		var url="/hms/hms/ipd?method=showModifyPatientIssueJsp&ipIssueNo="+ipIssueNo;
        popwindowForDelete(url);
     }
	function popwindowForDelete(url)
	{
		// newwindow=window.open(url,'name',"height=500,width=700,status=1, scrollbars=yes ");
		 
		 newwindow=window.open(url,'name','status=yes,resizable,scrollbars=1,height=400,width=1010,');
		 
    }	
    function openPopupForView(admissionNumber){
     //alert(admissionNumber)
		var url="/hms/hms/ipd?method=viewPatientIssueJsp&admissionNumber="+admissionNumber;
        popwindowForDelete(url);
     }
		
</script>







