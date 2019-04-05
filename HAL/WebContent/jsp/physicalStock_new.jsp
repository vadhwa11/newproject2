<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="java.math.BigDecimal"%>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

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
	String currentDate = date1+"/"+month1+"/"+year1 ;
%>
	serverdate = '<%=date1+"/"+month1+"/"+year1%>'
</script>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
  	List<Object[]> itemBatchStockList  = new ArrayList<Object[]>();
  	List<Object[]> employeeList = new ArrayList<Object[]>();
	 List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		
	if(request.getAttribute("map") != null)
	{
	 map = (Map) request.getAttribute("map");
	}
	if(map.get("departmentList")!=null)
	{
		departmentList = (List)map.get("departmentList");
	}
	if(map.get("itemBatchStockList") != null){
		itemBatchStockList = (List)map.get("itemBatchStockList");
	}

	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	int departmentId = 0;
	if(session.getAttribute("departmentId") != null){
		departmentId = (Integer)session.getAttribute("departmentId");
	}

	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   //out.println(message);
	 }	
	boolean flag = false;
	String message = "";
	if(map.get("message") != null)
	{
		 message =  (String)map.get("message");	  
		   
	 }	 

	if(map.get("saved") != null)
	{
		 
		flag =  (Boolean)map.get("saved");
	}
int stockTakingMId=0;
	if(map.get("stockTakingMId") != null)
	{
		 
		stockTakingMId =  (Integer)map.get("stockTakingMId");
	}
	

		if(flag)
		{
				
				out.println("<h4 id='divResult' class='success'>" + message+ "</h4><a href='#' onclick='submitFormForButton(\"stockAdjustment\",\"stores?method=printStockAdjustmentRpt&stockTakingMId="+stockTakingMId+"\")'>Yes</a>");
		}
		else
		{
			 out.println("<h4 id='divResult' class='failure'>"+message+"</h4>");
		} 

%>



<div class="titleBg">
<h2>Physical Stock Taking </h2>
</div>
<div class="Block">

<form name="srch" method="post" action="">

<input type="hidden" name="pvmsId" value="" id="pvmsId" validate="PVMS/NIV NO.,metachar,num,no" /> 
<label>Nomenclature </label> 
<input type="text" value="" id="nomenclature" class="bigcaption1" name="nomenclature" validate="Nomenclature,string,yes" onblur="populatePVMS(this.value,'')" />

<div id="ac2update" style="display: none; " class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
if(validateMetaCharacters(this.value))
{new Ajax.Autocompleter('nomenclature','ac2update','stores?method=getItemListForBINCardByAutocomplete',{parameters:'requiredField=nomenclature'})};
</script> 
<input type="hidden"	value="" id="itemId"  name="itemId" /> 

<input type="button" class="button" value="Search" onclick="submitForm('srch','stores?method=showPhysicalStock&selectedAppId=A1736');"/>
<div class="Clear"></div>
</form>
<form name="stockAdjustment" method="post" action="">
<label>Reason for Stock Taking<span>*</span></label>
<textarea  name="remarks" MAXLENGTH="490" validate="Reason for Stock Taking,string,yes" style="width: 250px; height: 50px;"></textarea>

<div class="Clear"></div>



</div>
<div class="clear paddingTop15"></div>
<%if(itemBatchStockList.size()>0)
	{%>
<div class="cmntable">
<table>

<tr>
<th>Sl No.</th>
<th>Mat Code</th>
<th>Nomenclature</th>

<!-- <th>A/U</th> -->
<th>Batch No.</th>
<th>Expiry Date</th>
<th>Computed Stock</th>
<th>Physical Stock</th>
<th>Surplus</th>
<th>Deficient</th>

<th>Remarks</th>
</tr>
<tbody id="tableData">
<%
int inc = 1;

 for(Object[] obj: itemBatchStockList){	
	
%>
<tr>
<td><%=inc %>
<input type="hidden" name="itemId<%=inc %>" id="itemId<%=inc %>"  value="<%=obj[0]%>" readonly="readonly"/></td>
<td><input type="text" name="pvmsNo<%=inc %>" id="pvmsNoId<%=inc %>"  value="<%=obj[1]%>" size="7" readonly="readonly"/></td>
<td><input type="text" size="40" name="nomenclature<%=inc %>" id="nomencaltureId<%=inc %>"  value="<%=obj[2]%>" readonly="readonly"/></td>


<%-- <td><input type="text" name="au<%=inc %>" id="auId<%=inc %>"  value="<%=obj[3] %>" readonly="readonly" size="10"/>
<input type="hidden" name="itemConversionId<%=inc %>" id="itemConversionId<%=inc %>"  value="<%=(obj[8]!= null?obj[8]:"") %>" readonly="readonly" size="10"/></td> --%>
<td><input type="text" name="batchNo<%=inc %>" id="batchNo<%=inc %>"  value="<%=(obj[5]!= null?obj[5]:"") %>" readonly="readonly"  size="7"/>
<input type="hidden" name="batchId<%=inc %>" id="batchId<%=inc %>"  value="<%=(obj[6]!= null?obj[6]:"") %>" readonly="readonly"  /></td>

<td><input type="text" name="expiryDate<%=inc %>" id="expiryDateId<%=inc %>"  value="<%=(obj[4]!=null?HMSUtil.convertDateToStringWithoutTime((Date)obj[4]):"") %>" readonly="readonly" size="10" />
</td>

<td>
<input type="text" name="computedStock<%=inc %>" id="computedStock<%=inc %>"  value="<%=(obj[7]!= null?((BigDecimal)obj[7]).doubleValue():"") %>" readonly="readonly" size="14"/></td>
<td><input type="text" name="physicalStock<%=inc %>" id="physicalStock<%=inc %>" value="<%=(obj[7]!= null?((BigDecimal)obj[7]).doubleValue():"") %>" size="14" onblur="calulateStock(this,'<%=inc %>');"  onkeypress ="return isNumber(event);"  /></td>
<td><input type="text"	value="" size="8" name="surplus<%=inc %>" id="surplus<%= inc%>" readonly="readonly" /></td>
<td><input type="text" value="" size="8" name="deficient<%=inc %>"	id="deficient<%= inc%>" readonly="readonly" /></td>

<td><input type="text" name="remarks<%=inc %>" MAXLENGTH="399" id="remarks<%=inc %>" validate="Remarks,string,yes" value="" size="15" style="width: 200px; height: 40px;"/></td>
</tr>
<%inc++;} %>
</tbody>
</table>
<input type="hidden" name="counter" id="counter" value="<%=inc-1%>" />
<div id="pageNavPosition"></div>
</div>
<div class="Clear"></div>

<div class="Clear"></div>

<input type="button" class="button" value="Submit" onclick="submitForm('stockAdjustment','stores?method=submitPhysicalStockTaking');"/>
<input type="button" class="button" value="Reset" onclick="submitFormForButton('stockAdjustment','stores?method=showPhysicalStock&selectedAppId=A1736');" />
<%} %>
<div class="Clear"></div>
<div class="division"></div>

<div class="bottom">

<label>Changed By:</label>
<label class="value"><%=userName %></label>

<label>Changed Date:</label>
<label class="value"><%=date%></label> 

<label>Changed Time:</label>
<label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="admin" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	   
<div class="Clear"></div>
</div> 
<div class="Clear"></div>
<script type="text/javascript">

function calulateStock(obj,row)
{
	var computedStockCal = parseFloat(document.getElementById('computedStock'+row).value);
	var physicalStock = parseFloat(document.getElementById('physicalStock'+row).value);
	//var storeStockDefectiveCal = parseFloat(document.getElementById('stockDefective'+row).value);
	var surplusStockCal = parseFloat(document.getElementById('surplus'+row).value);
	var deficientCal = parseFloat(document.getElementById('deficient'+row).value);
	if (isNaN(computedStockCal) || isNaN(physicalStock))
	{
	alert('Please Check the Inputs!....');
	return;
	}
	var difference = parseFloat(physicalStock) - parseFloat(computedStockCal);


	if (difference > 0)
	{
		document.getElementById('surplus'+row).value=parseFloat(difference);
		document.getElementById('deficient'+row).value="0";
	}

	if (difference < 0)
	{
		document.getElementById('deficient'+row).value=parseFloat(difference) * -1;
		document.getElementById('surplus'+row).value="0";
	}

	if (difference == 0)
	{
		document.getElementById('deficient'+row).value="0";
		document.getElementById('surplus'+row).value="0";
	}

}

function populatePVMS(val,inc){

	if(val != "")
	{
	    var index1 = val.lastIndexOf("[");
	    var indexForBrandName=index1;
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvmsNo = val.substring(index1,index2);
	    var indexForBrandName=indexForBrandName--;
	    var brandName=val.substring(0,indexForBrandName);
	   //  alert("pvms no--"+pvmsNo)



  if(pvmsNo == "")
  {
   // alert("pvms no1111--"+pvmsNo)
   	document.getElementById('nomenclature'+inc).value="";
   
   return false;
   }
   else
	   {
	   
	      return true;

	   }
    

 }
	else
		{
		 return false;
		}
}


var pager = new Pager('tableData',10);
pager.init();
pager.showPageNav('pager', 'pageNavPosition');
pager.showPage(1);
</script>	

</form>
