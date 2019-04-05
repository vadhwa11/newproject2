<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * soDetails.jsp  
 * Purpose of the JSP -  This is showing SO Details.
 * @author  Mansi
 * Create Date: 04th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.7
--%>

<%@page import=" static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.StoreStockTakingT"%>
<%@page import="jkt.hms.masters.business.StoreStockTakingM"%>
<%@page import="java.util.GregorianCalendar"%>



<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script>
function checkAdjustment(){

	if(document.getElementById('stockDate').value == ''){
		alert("Please enter in textfield Physical Stock Date");
		return false;
	}else
		return true;
}
</script>
<script>
<%
 Calendar calendar=Calendar.getInstance();
 String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
 String dateCal=String.valueOf(calendar.get(Calendar.DATE));
 int year=calendar.get(calendar.YEAR);
 if(month.length()<2){
  month="0"+month;
 }
 if(dateCal.length()<2){
  dateCal="0"+dateCal;
 }
%>
 serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>
<script type="text/javascript">
 function fillValuesPhysicalStock(inc)
  {
    	var incRemarks="incRemarks";
    	var incRemarksTemp="incRemarksTemp";
    	
    	if(document.getElementById(incRemarksTemp+inc).value!=''){
	      document.getElementById(incRemarks+inc).value=document.getElementById(incRemarksTemp+inc).value
    	 }
     	else
      		document.getElementById(incRemarks+inc).value="emptyString"
    
    	
  }
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
	
		int monthSearch = gregorianCalendar1.get(Calendar.MONTH) + 1;
		if (monthSearch < 10) {
			orderDateOnly.append("0");
			orderDateOnly.append(monthSearch);
		} else {
			orderDateOnly.append(monthSearch);
		}
	
		orderDateOnly.append("/");
		int year1 = gregorianCalendar1.get(Calendar.YEAR);
		orderDateOnly.append(year1);
		String currentDate = new String(orderDateOnly);
	%>

<%

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	Map<String,Object> map = new HashMap<String,Object>();

	List<StoreItemBatchStock> searchStoreItemBatchStockList = new ArrayList<StoreItemBatchStock>();
	List<StoreStockTakingT> searchStoreStockTakingTList= new ArrayList<StoreStockTakingT>();
	int departmentId=0;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
			
	if(map.get("searchStoreItemBatchStockList")!=null)
		searchStoreItemBatchStockList = (List) map.get("searchStoreItemBatchStockList");
	System.out.println("searchStoreItemBatchStockList in jsp " + searchStoreItemBatchStockList.size());
	
	if(map.get("departmentId")!=null)
		departmentId = (Integer) map.get("departmentId");
	
	if(map.get("searchStoreStockTakingTList")!=null)
		searchStoreStockTakingTList = (List) map.get("searchStoreStockTakingTList");
	
	
	List<StoreStockTakingM> searchStoreStockTakingMList= new ArrayList<StoreStockTakingM>();
	if(map.get("searchStoreStockTakingMList")!=null)
		searchStoreStockTakingMList = (List)map.get("searchStoreStockTakingMList");
		System.out.println("searchStoreStockTakingMList-----"+searchStoreStockTakingMList.size());
	
	
%>
<form name="stockTaking" method="post"><input type="hidden"
	name="<%=DEPARTMENT_ID%>" value="<%=departmentId %>"> <input
	type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <label
	style="width: 130px;">&nbsp;</label> <label style="width: 130px;">&nbsp;</label>
<label style="width: 130px;">&nbsp;</label> <label style="width: 130px;">&nbsp;</label>
<%
								String flag= "false";
	   							if(searchStoreStockTakingTList.size() >0)
	   							{
	   									
	   								flag="true"; 
	   				%> <label class="bodytextB_blue"><font id="error"></font>Physical
Stock As On Date:</label> <select name="<%=PHYSICAL_STOCK_DATE%>" id="stockDate">
	<option value="0">Select</option>
	<%
									for (StoreStockTakingM storeStockTakingM :searchStoreStockTakingMList ) 
									{											
					%>
	<option value=<%=storeStockTakingM.getId()%> selected="selected"><%=HMSUtil.changeDateToddMMyyyy(storeStockTakingM.getPhysicalDate())%></option>
	<%
									}
					%>
</select> <input type="button" name="adjustment" value="Adjustment"
	class="button"
	onclick="submitForm('zzzz','stores?method=showAdjustmentJsp')"
	tabindex=1 /> <%	
									if(flag.equals("false")){
					%> <label class="bodytextB_blue"><font id="error"></font>Physical
Stock As On Date:</label> <input type="text" name="<%=PHYSICAL_STOCK_DATE%>"
	readonly="readonly" value="<%=currentDate %>" class="readOnly"
	MAXLENGTH="30" /> <br />
<input type="button" name="adjustment" value="Adjustment" class="button"
	onclick="submitForm('zzzz','stores?method=showAdjustmentJsp')"
	tabindex=1 /> <%
									}
								}
	   							else 
								{
					%> <label class="bodytextB_blue"><font id="error"></font>Physical
Stock As On Date:</label> <input type="text" name="<%=PHYSICAL_STOCK_DATE%>"
	readonly="readonly" value="<%=currentDate %>" class="readOnly"
	MAXLENGTH="30" /> <br />
<%
								}
	   				%> <br>

<fieldset style="width: 99%; padding-left: 9px;"><legend>Certificate
of Stock-Taking</legend>

<div
	style="overflow: auto; width: 100%; height: 150px; padding-left: 9px;">
<table width="98%" colspan="7" id="tblSample" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">

	<thead>
		<tr>
			<td width="10%"><label valign="left" class="smalllabel">S.No.</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label></td>
			<td width="10%"><label valign="left" class="smalllabel">A/V</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Brand
			Name</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Batch
			No.</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Expiry
			Date</label></td>
			<td width="13%"><font
				style="word-wrap: break-word; font-size: 10px; width: auto; height: 1px; left: 0"
				rowspan="2" valign="top"> <b>Computed<br />
			Stock</b> </font></td>

			<td width="20%"><font
				style="word-wrap: break-word; font-size: 10px; width: 100px; height: 1px; left: 0"
				rowspan="2" valign="top"> <b>Stock in <br />
			Store Service</b> </font></td>
			<td width="20%"><font
				style="word-wrap: break-word; font-size: 10px; width: 100px; height: 1px; left: 0"
				rowspan="2" valign="top"> <b>Stock in <br />
			Store Defective</b> </font></td>
			<td width="13%"><label valign="left" class="smalllabel">Surplus</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Deficient</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Remarks</label></td>


		</tr>
	</thead>
	<tbody>

		<%
		
		int temp=0;
		
		
		String computedStock="computedStock";
    	String stockInStores="stockInStores";
    	String storeStockDefective="storeStockDefective";
    	String surplus="surplus";
    	String deficient="deficient";
    	String incVar="incVar";
    	String computedStock2="computedStock";
    	String stockInStores2="stockInStores";
    	String storeStockDefective2="storeStockDefective";
    	String surplus2="surplus";
    	String deficient2="deficient";
    	    	
    	String incRemarks="incRemarks";
    	String incRemarksTemp="incRemarksTemp";
    	
    	  	
    	String incRemarks2="incRemarks";
		String incRemarksTemp2="incRemarksTemp";
    	
    	String incVar2="incVar2";
    	
		StoreItemBatchStock  storeItemBatchStock = new StoreItemBatchStock();
		if (searchStoreItemBatchStockList.size() != 0 && searchStoreItemBatchStockList != null)
			
				for (int i = 0; i < searchStoreItemBatchStockList.size(); i++) 
				{
					for(int inc=1;inc<=8;inc++)
					{
						
					computedStock=computedStock2+(""+inc);
					stockInStores=stockInStores2+(""+inc);
					storeStockDefective=storeStockDefective2+(""+inc);
					surplus=surplus2+(""+inc);
					deficient=deficient2+(""+inc);
					
					
					incRemarks=incRemarks2+(""+inc);
			 		incRemarksTemp=incRemarksTemp2+(""+inc);
			 		
		     		incVar=incVar2+(""+inc);
					
		     		storeItemBatchStock = (StoreItemBatchStock) searchStoreItemBatchStockList.get(i);
		
		
		%>
		<tr>


			<td width="10%"><input type="text" size="2" class="smalllabel"
				value="<%=temp+inc%>" name="<%=SR_NO%>" readonly="readonly" id="" />
			</td>

			<td width="13%"><input type="text" class="smalllabel" size="2"
				name="<%=ITEM_PVMS_NO%>"
				value="<%=storeItemBatchStock.getItem().getPvmsNo()%>"
				readonly="readonly" id="" /> <input type="hidden"
				name="<%=ITEM_ID_PVMS_NO%>"
				value="<%=storeItemBatchStock.getItem().getId()%>"></td>

			<td width="10%"><input type="text" class="smalllabel" size="2"
				value="<%=storeItemBatchStock.getItem().getNomenclature()%>"
				name="<%=ITEM_NOMENCLATURE%>" readonly="readonly" id="" /> <input
				type="hidden" name="<%=ITEM_ID_NOMENCLATURE%>"
				value="<%=storeItemBatchStock.getItem().getId()%>"></td>

			<%	String itemUnitName = "";
				int itemUnitId=0;
				if(storeItemBatchStock.getItem().getItemConversion() != null){
					itemUnitName = storeItemBatchStock.getItem().getItemConversion().getItemUnitName();
					itemUnitId = storeItemBatchStock.getItem().getItemConversion().getId();
				}
			%>
			<td width="13%"><input type="text" class="smalllabel" size="2"
				value="<%=itemUnitName%>" name="<%=ITEM_AV%>" readonly="readonly"
				id="" /> <input type="hidden" name="<%=ITEM_ID_AV%>"
				value="<%=itemUnitId%>"></td>

			<%	String brandName = "";
				int brandId=0;
				if(storeItemBatchStock.getBrand() != null){
					brandName = storeItemBatchStock.getBrand().getBrandName();
					brandId = storeItemBatchStock.getBrand().getId();
				}
			%>
			<td width="13%"><input type="text" class="smalllabel" size="2"
				value="<%=brandName%>" name="<%=BRAND_NAME%>" readonly="readonly"
				id="" /> <input type="hidden" name="<%=BRAND_ID%>"
				value="<%=brandId%>"></td>



			<td width="5%"><input type="text"
				value="<%=storeItemBatchStock.getBatchNo() %>" name="<%=BATCH%>"
				class="smalllabel" id="" /> <input type="hidden" size="2"
				value="<%=storeItemBatchStock.getBatchNo() %>" name="<%=BATCH_NO%>" /></td>



			<td width="20%"><input type="text" name="<%=EXPIRY_DATE %>"
				value="<%=HMSUtil.changeDateToddMMyyyy(storeItemBatchStock.getExpiryDate()) %>"
				class="smalllabel" readonly="readonly" /></td>

			<td width="10%"><input type="text"
				value="<%=storeItemBatchStock.getClosingStock() %>"
				name="<%=COMPUTED_STOCK_TEMP%>" class="smalllabel"
				id="<%=computedStock %>" /> <input type="hidden" size="2"
				value="<%=storeItemBatchStock.getClosingStock() %>"
				name="<%=COMPUTED_STOCK%>" /></td>

			<input type="hidden" size="2"
				value="<%=storeItemBatchStock.getCostPrice() %>"
				name="<%=COST_PRICE%>" />

			<%
			if (searchStoreStockTakingTList.size() > 0 ){
			//for (StoreStockTakingT storeStockTakingT : searchStoreStockTakingTList) {
				StoreStockTakingT storeStockTakingT =(StoreStockTakingT)searchStoreStockTakingTList.get(i);
				
				if(storeItemBatchStock.getItem().getId().equals(storeStockTakingT.getItem().getId())){
					
				
				%>

			<input type="hidden" name="<%=PHYSICAL_STOCK_ID %>"
				value="<%=storeStockTakingT.getStockTakingM().getId() %>"> <input
				type="hidden" name="<%=PHYSICAL_STOCK_T_ID %>"
				value="<%=storeStockTakingT.getId() %>" />



			<td width="20%"><input type="text" id="<%=stockInStores%>"
				readonly="readonly"
				value="<%=storeStockTakingT.getStoreStockService()%>"
				class="smalllabel" name="<%=STOCK_IN_STORES %>" tabindex="2"
				validate="Stock in Stores Service,num,no" MAXLENGTH="8"
				onblur="calulateStock('<%=inc %>')" /></td>

			<td width="20%"><input type="text" id="<%=storeStockDefective%>"
				readonly="readonly"
				value="<%=storeStockTakingT.getStoreStockDefective()%>"
				class="smalllabel" name="<%=STOCK_IN_DEFECTIVE %>" tabindex="2"
				validate="Stock in Stores Defective,num,no" MAXLENGTH="8"
				onblur="calulateStock('<%=inc %>')" /></td>


			<td width="5%"><input type="text" readonly="readonly"
				value="<%=storeStockTakingT.getStockSurplus()%>"
				name="<%=SURPLUS_STOCK %>" class="smalllabel" id="<%=surplus%>"
				MAXLENGTH="8" /></td>

			<td width="5%"><input type="text" readonly="readonly"
				value="<%=storeStockTakingT.getStockDeficient()%>"
				name="<%=DEFICIENT %>" class="smalllabel" id="<%=deficient%>"
				MAXLENGTH="8" /></td>


			<td width="10%"><input type="text" value="" tabindex="1"
				name="<%=REMARKS_TEMP %>" readonly="readonly"
				id="<%=incRemarksTemp%>"
				onblur="fillValuesPhysicalStock(<%=inc %>);" MAXLENGTH="30" /> <input
				type="hidden" size="2" value="emptyString" name="<%=REMARKS %>"
				id="<%=incRemarks%>" validate="Remarks,string,no" /></td>




			<%
				} else{
					
					%>





			<td width="20%"><input type="text" id="<%=stockInStores%>"
				validate="stock In Stores,num,no" value="" class="smalllabel"
				name="<%=STOCK_IN_STORES%>" tabindex="2"
				validate="Stock in Stores,num,no" MAXLENGTH="8"
				onblur="calulateStock('<%=inc %>')" /></td>

			<td width="20%"><input type="text" id="<%=storeStockDefective%>"
				validate="stock In defective,num,no" value="" class="smalllabel"
				name="<%=STOCK_IN_DEFECTIVE %>" tabindex="2"
				validate="Stock in Stores Defective,num,no" MAXLENGTH="8"
				onblur="calulateStock('<%=inc %>')" /></td>

			<td width="5%"><input type="text" readonly="readonly" value=""
				name="<%=SURPLUS_STOCK%>" class="smalllabel" id="<%=surplus%>"
				MAXLENGTH="8" /></td>

			<td width="5%"><input type="text" readonly="readonly" value=""
				name="<%=DEFICIENT%>" class="smalllabel" id="<%=deficient%>" /></td>

			<td width="10%"><input type="text" tabindex="1" value=""
				name="<%=REMARKS_TEMP%>" id="<%=incRemarksTemp%>"
				onblur="fillValuesPhysicalStock(<%=inc %>);" MAXLENGTH="30" /> <input
				type="hidden" size="2" value="emptyString" name="<%=REMARKS%>"
				id="<%=incRemarks%>" validate="Remarks,string,no" /></td>
			<%
     	 }
			
		//}
	}
	else
	{

				
				%>





			<td width="20%"><input type="text" id="<%=stockInStores%>"
				validate="stock In Stores,num,no" value="" class="smalllabel"
				name="<%=STOCK_IN_STORES%>" tabindex="2"
				validate="Stock in Stores,num,no" MAXLENGTH="8"
				onblur="calulateStock('<%=inc %>')" /></td>

			<td width="20%"><input type="text" id="<%=storeStockDefective%>"
				value="" validate="stock In defective,num,no" class="smalllabel"
				name="<%=STOCK_IN_DEFECTIVE %>" tabindex="2"
				validate="Stock in Stores Defective,num,no" MAXLENGTH="8"
				onblur="calulateStock('<%=inc %>')" /></td>

			<td width="5%"><input type="text" readonly="readonly" value=""
				name="<%=SURPLUS_STOCK%>" class="smalllabel" id="<%=surplus%>"
				MAXLENGTH="8" /></td>

			<td width="5%"><input type="text" readonly="readonly" value=""
				name="<%=DEFICIENT%>" class="smalllabel" id="<%=deficient%>" /></td>
			<td width="10%"><input type="text" value="" tabindex="1"
				name="<%=REMARKS_TEMP%>" id="<%=incRemarksTemp%>"
				onblur="fillValuesPhysicalStock(<%=inc %>);" MAXLENGTH="30" /> <input
				type="hidden" size="2" value="emptyString" name="<%=REMARKS%>"
				id="<%=incRemarks%>" validate="Remarks,string,no" /></td>

			<%
				
			}
			inc++;	
				}
		}
			
			%>
			
		</tr>

	</tbody>
</table>
</br>
<script type="text/javascript">


</script>



</fieldset>

</div></form>

