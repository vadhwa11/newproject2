
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreTenderM"%>
<%@page import="jkt.hms.masters.business.StoreTenderCommHodRecom"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascrip"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<script>
		<%
			Calendar calendar=Calendar.getInstance();
			String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
			String date1=String.valueOf(calendar.get(Calendar.DATE));
			int year=calendar.get(calendar.YEAR);
			if(month.length()<2){
				month="0"+month;
			}
			if(date1.length()<2){
				date1="0"+date1;
			}
		%>
		serverdate = '<%=date1+"/"+month+"/"+year%>'
	</script>

<%
		String date = "";
		String time = "";
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		String manufacturer_lab_practice = "";
		String standing_certificate="";
		String no_conviction_issued="";
		String status="";
		String nomenclature="";
		String pvmsNo="";
		String noitem = "no";
		
		
		HashMap[] gridData =null;
		PagedArray pagedArray = null;
		Box box = HMSUtil.getBox(request);
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 	date = (String)utilMap.get("currentDate");	 
	 	time = (String)utilMap.get("currentTime");
	 	
	 	if(session.getAttribute("userName") != null)
	 	{
			userName = (String)session.getAttribute("userName");
		}
	 	
	  	Map map = new HashMap();
		List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
		List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
		List<MasStoreItem> masStoreItemList = new ArrayList<MasStoreItem>();
		List<StoreTenderCommHodRecom> storeTenderCommHodRecomList = new ArrayList<StoreTenderCommHodRecom>();
		if (request.getAttribute("map") != null) 
		{
			map = (Map) request.getAttribute("map");
			
			if (map.get("storeTenderMList") != null)
				storeTenderMList =   (ArrayList)map.get("storeTenderMList");
			
			
			if (map.get("masStoreGroupList") != null)
				masStoreGroupList = (ArrayList)map.get("masStoreGroupList");
			
			
			if (map.get("storeTenderCommHodRecomList") != null)
				storeTenderCommHodRecomList = (ArrayList)map.get("storeTenderCommHodRecomList");			
			
			
			if (map.get("masStoreItemList") != null)
				masStoreItemList = (ArrayList)map.get("masStoreItemList");
			
			
			if (map.get("status") != null)
				status = map.get("status").toString();
	
			if (map.get("noitem") != null)
				noitem = map.get("noitem").toString();
			
			if (map.get("nomenclature") != null)
				nomenclature = map.get("nomenclature").toString();
			
			if (map.get("pvmsNo") != null)
				pvmsNo = map.get("pvmsNo").toString();
			
			if (map.get("pagedArray") != null)
				pagedArray = (PagedArray)map.get("pagedArray");
			
	  }
		
		if (session.getAttribute("hospitalId") != null) {
			Integer temp =  (Integer)session.getAttribute("hospitalId");
			hospitalId = temp.intValue();
		}
		
		if (session.getAttribute("deptId") != null) {
			Integer temp =  (Integer)session.getAttribute("deptId");
			deptId = temp.intValue();
		}
		List<UserButtonRights> userRightsList= new ArrayList<UserButtonRights>();
		if (map.get("userRightsList") != null) {
			userRightsList = (List<UserButtonRights>)map.get("userRightsList") ;
		}
	%>
<script>
	
	//this function will be called by the Bean (not from JSP)
	function goPage(pidx) 
	{	
		CommercialBidForm.currPage.value = pidx;
		CommercialBidForm.method="post";
		submitForm('CommercialBidForm','tender?method=getTenderCommercialBidGrid');
	}
	
	
	function onChangeTender()
	{
	//CommercialBidForm.<%=TENDER_SUPPLIER_GROUP_ID%>.options.length=1;
	//CommercialBidForm.<%=TENDER_PVMS%>.options.length=1;
	CommercialBidForm.method="post";
	submitForm('CommercialBidForm','tender?method=getTenderGroupListForCommercial');
	}
	
	
	function onChangeGroup()
	{
	//CommercialBidForm.<%=TENDER_PVMS%>.options.length=1;
	CommercialBidForm.method="post";
	submitForm('CommercialBidForm','tender?method=getTenderItemListForCommercial');
	}
	
	function onChangeItem(flag) 
	{
		CommercialBidForm.method="post";	
		submitForm('CommercialBidForm','tender?method=getTenderCommercialBidGrid&flag='+flag);
	}
	
	function onUpdate()
	{
	CommercialBidForm.method="post";
	submitForm('CommercialBidForm','tender?method=updateCommBidGridItems');
	}
	
	function gotoPrevious()
	{
		var ind = CommercialBidForm.<%=TENDER_PVMS%>.selectedIndex;
		
		if (ind == '1' || ind =='0')
		{
		alert('Press Next to See Next Record');
		return;
		}
	
		ind = ind - 1;
		CommercialBidForm.<%=TENDER_PVMS%>.selectedIndex = ind;
		CommercialBidForm.method="post";	
		submitForm('CommercialBidForm','tender?method=getTenderCommercialBidGrid&flag=fresh');
	}
	
	
	function gotoNext()
	{
		var len = CommercialBidForm.<%=TENDER_PVMS%>.options.length;
		var ind = CommercialBidForm.<%=TENDER_PVMS%>.selectedIndex;
		if (ind == len-1)
		{
		alert('Press Previous to See Previous Record');
		return;
		}
	
		ind = ind + 1;
		CommercialBidForm.<%=TENDER_PVMS%>.selectedIndex = ind;
		CommercialBidForm.method="post";	
		submitForm('CommercialBidForm','tender?method=getTenderCommercialBidGrid&flag=fresh');
	}
	
	
	function mark()
	{
		CommercialBidForm.method="post";	
		submitForm('CommercialBidForm','tender?method=getTenderCommercialMarkingL1');
	}
	
	
	function addRecommendation()
	{
	var url="/hms/hms/tender?method=showHODRecommendationJsp&<%=TENDER_NO%>="+CommercialBidForm.<%=TENDER_NO%>.value + "&<%=TENDER_SUPPLIER_GROUP_ID%>=" + CommercialBidForm.<%=TENDER_SUPPLIER_GROUP_ID%>.value + "&<%=TENDER_PVMS%>=" + CommercialBidForm.<%=TENDER_PVMS%>.value;
	newwindow=window.open(url,'name','top=50, left=50, height=600,width=800,status=1');
	
	}
		function openPopupWindowForPvms()
		 {
		   var tenderId=document.CommercialBidForm.<%=TENDER_NO%>.value;
		   var groupId=document.CommercialBidForm.<%=TENDER_SUPPLIER_GROUP_ID%>.value;
		   //alert("value of tewnder id--"+tenderId+"--groupId==="+groupId)
		   if(tenderId !="" && groupId!= ""){
		   
		  	var url="/hms/hms/tender?method=showPvmsNomencaltureSearchJsp&tenderId="+tenderId+"&groupId="+groupId;
		  	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
		  }else{
		     alert("Please select Tender No And Group.")
		  }
		 }
		 function jsSetNomenclature(nomenclature)
		 {
		 	
			 for(var i=0;i<document.getElementById("nomenclature").length;i++)
			 {
			 
				 if (document.getElementById("nomenclature").options[i].value==nomenclature)
				 {
				   //alert("document.getElementById(nomenclature).length--------"+document.getElementById("nomenclature").options[i].value)
				 	document.getElementById("nomenclature").selectedIndex = i;
				 	onChangeItem('fresh');
				 }
				 
			 }
			
			} 
	</script>

<form name="CommercialBidForm"><input type="hidden"
	name="numOfRows" size="5" value="20"> <input type="hidden"
	name="pageCount" size="5" value="10"> <input type="hidden"
	name="hospitalId" size="5" value="<%=hospitalId%>"> <input
	type="hidden" name="deptId" size="5" value="<%=deptId%>"> <input
	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div id="contentHolder">
<h6>Tender - Commercial Bid</h6>
<div class="Clear"></div>
<h4><%=nomenclature%>[<%=pvmsNo%>]</h4>
<div class="Clear"></div>
<div class="blockTitle">Technical Bid</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Group</label> <select
	name="<%=TENDER_SUPPLIER_GROUP_ID%>" onChange="onChangeGroup();">
	<option value="">Select Group</option>
	<%
				for (Iterator iterator = masStoreGroupList.iterator(); iterator.hasNext();) 
				{
					MasStoreGroup masStoreGroup = (MasStoreGroup)iterator.next();
				%>
	<option value="<%=masStoreGroup.getId()%>"
		<%=HMSUtil.isSelected(masStoreGroup.getId(),Integer.valueOf(box.getInt(TENDER_SUPPLIER_GROUP_ID)))%>><%=masStoreGroup.getGroupName()%></option>
	<%
				}
				%>
</select> <label>Tender No</label> <select name="<%=TENDER_NO%>"
	onChange="onChangeTender();">
	<option value="">Select Tender No</option>
	<%
			for (Iterator iterator = storeTenderMList.iterator(); iterator.hasNext();) 
			{
				StoreTenderM storeTenderM = (StoreTenderM)iterator.next();
			%>
	<option value="<%=storeTenderM.getId()%>"
		<%=HMSUtil.isSelected(storeTenderM.getId(),Integer.valueOf(box.getInt(TENDER_NO)))%>><%=storeTenderM.getTenderNo()%></option>
	<%
			}
			%>
</select> <label>Nomenclature</label> <select id="nomenclature"
	name="<%=TENDER_PVMS%>" onChange="onChangeItem('fresh');">
	<option value="">Select Item</option>
	<%
				for (Iterator iterator = masStoreItemList.iterator(); iterator.hasNext();) 
				{
					MasStoreItem masStoreItem = (MasStoreItem)iterator.next();
				%>
	<option value="<%=masStoreItem.getId()%>"
		<%=HMSUtil.isSelected(masStoreItem.getId(),Integer.valueOf(box.getInt(TENDER_PVMS)))%>><%=masStoreItem.getNomenclature()%></option>
	<%
				}
				%>
</select> <IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"
	style="cursor: pointer; float: left;"
	onClick="javascript:openPopupWindowForPvms();"
	title="Click here to Search Pvms/Niv">
<div class="Clear"></div>
</div>

<div class="Clear"></div>
<div class="bottom"><label>Changed By:</label> <label
	class="value"> <%=userName%> </label> <label class="bodytextB">Changed
Date:</label> <label class="value"> <%=date%> </label> <label class="bodytextB">Changed
Time:</label> <label class="value"> <%=time%> </label></div>
<div class="Clear"></div>
<% if (pagedArray !=null && status.equalsIgnoreCase("o")) 
			{ %>
<div class="Clear"></div>
<input type="button" name="Submit" onClick="onUpdate()" value="Update"
	class="button" accesskey="u" /> <input type="button" name="Previous"
	onClick="gotoPrevious()" value="Previous" class="button" accesskey="p" />
<input type="button" name="Next" onClick="gotoNext()" value="Next"
	class="button" accesskey="n" />
<div class="Clear"></div>
<% 
	   		for(UserButtonRights  userButtonRights : userRightsList){
				String buttonName=userButtonRights.getButton().getButtonName();
			    if(userButtonRights.getButton().getFormName().equals("Tender Commercial Bid Form")){
				String formulaUsed=userButtonRights.getButton().getFormulaUsed();	
			
            %>
<div class="Clear"></div>
<input type="button" name="no"
	value="<%=userButtonRights.getButton().getButtonName() %>"
	class="<%=userButtonRights.getButton().getClassName() %>"
	onclick="<%=userButtonRights.getButton().getUrl()%>" />
<div class="Clear"></div>
<%}} %> <!-- <input type="button" name="Mark" onClick="mark()" value="Mark L1" class="button" accesskey="m" /> -->
<% } else if (pagedArray !=null) { %>
<div class="Clear"></div>
<input type="button" name="Previous" onClick="gotoPrevious()"
	value="Previous" class="button" accesskey="p" /> <input type="button"
	name="Next" onClick="gotoNext()" value="Next" class="button"
	accesskey="n" />
<div class="Clear"></div>
<% } else if( noitem.equalsIgnoreCase("yes")) { %>
<div class="Clear"></div>
<input type="button" name="Previous" onClick="gotoPrevious()"
	value="Previous" class="button" accesskey="p" /> <input type="button"
	name="Next" onClick="gotoNext()" value="Next" class="button"
	accesskey="n" />
<div class="Clear"></div>
<%} %> <% if (storeTenderCommHodRecomList!=null && storeTenderCommHodRecomList.size()>0)
			{ %>
<div class="Clear"></div>
<div class="blockTitle">HOD's Recommendations</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" colspan="7" cellpadding="0" class="grid_header"
	cellspacing="0">
	<thead>
		<tr>
			<th>Sr No</th>
			<th>Firm Name</th>
			<th>Remarks</th>
			<th>Specialist</th>
		</tr>
	</thead>
	<tbody>
		<%			for (Iterator iterator = storeTenderCommHodRecomList.iterator(); iterator.hasNext();) 
						{
							StoreTenderCommHodRecom  storeTenderCommHodRecom = (StoreTenderCommHodRecom)iterator.next();
						%>


		<tr>
			<td><%=storeTenderCommHodRecom.getId()%></td>
			<td><%=storeTenderCommHodRecom.getSupplier().getSupplierName()%></td>
			<td><%=storeTenderCommHodRecom.getRemarks()%></td>
			<td><%=storeTenderCommHodRecom.getSpecialist().getFirstName()%></td>
		</tr>
		<% } %>

		<% if (pagedArray!=null) {  %>
		<tr>
			<td colspan=4><input type="button" name="Add_Recommendation"
				onClick="addRecommendation()" value="Add Recomm." class="cmnButton" />
			</td>
		</tr>
		<% } %>
	</tbody>
</table>
</div>
<%} else { %>
<div class="blockTitle">HOD's Recommendations</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" colspan="7" cellpadding="0" class="grid_header"
	cellspacing="0">
	<thead>
		<tr>
			<th>Sr No</th>
			<th>Firm Name</th>
			<th>Remarks</th>
			<th>Specialist</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=4 align="center">No Items Found</td>
		</tr>

		<% if (pagedArray!=null) {  %>
		<tr>
			<td colspan=4><input type="button" name="Add_Recommendation"
				onClick="addRecommendation()" value="Add Recomm." class="cmnButton" />
			</td>
		</tr>
		<% } %>
	</tbody>
</table>
</div>
<% } %>
<div class="Clear"></div>
<h6>Tender - Commercial Bid</h6>
<div class="Clear"></div>
<h4><%=nomenclature%>[<%=pvmsNo%>]</h4>
<div class="Clear"></div>
<%
			if (pagedArray == null) {
			%>
<div class="blockTitle">Vendor/Supplier Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="tableHolderAuto">
<table width="100%" colspan="7" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>Sr No</th>
			<th>Firm Name</th>
			<th>Brand Name</th>
			<th>Manufacturer Name</th>
			<th>Composition</th>
			<th>Dispens. Type</th>
			<th title="Minimum Dispensable Quantity">MDQ</th>
			<th>Tax(%)</th>
			<th>Rate Per MDQ</th>
			<th>Tax Amount per Mdq</th>
			<th>Total Rate per Mdq(Incl. Taxes)</th>
			<th title="Maximum Retail Price">MRP</th>
			<th>Comp Rate</th>
			<th>L Cat</th>
			<th>Remarks</th>
			<th>Disqual.</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=14 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
</div>


<%  } else { %>
<div class="blockTitle">Vendor/Supplier Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="tableHolderAuto">
<table width="100%" colspan="7" cellpadding="0" class="grid_header"
	cellspacing="0">
	<thead>
		<tr>
			<th>Sr No</th>
			<th>Firm Name</th>
			<th>Brand Name</th>
			<th>Manufacturer Name</th>
			<th>Composition</th>
			<th>Dispens. Type</th>
			<th title="Minimum Dispensable Quantity">MDQ</th>
			<th>Tax(%)</th>
			<th>Rate Per MDQ</th>
			<th>Tax Amount per Mdq</th>
			<th>Total Rate </br>
			per Mdq (Incl. Taxes)</th>
			<th title="Maximum Retail Price">MRP</th>
			<th>Comp Rate</th>
			<th>L Cat</th>
			<th>Remarks</th>
			<th>Disqual.</th>
		</tr>
	</thead>
	<tbody>


		<%
				    gridData = (HashMap[])pagedArray.getPagedArray();
				  int iFirstRow = pagedArray.getFirstRowIdx();
				    for(int i=0;i<gridData.length;i++)
				    {
				    	
				    	String checked = "";
				    	if (gridData[i].get(TENDER_CB_DISQUALIFIED)!=null && gridData[i].get(TENDER_CB_DISQUALIFIED).toString().equalsIgnoreCase("N")) checked = "checked";
				    %>
		<tr>
			<td><input type="text" value="<%=iFirstRow++%>"
				name="<%=TENDER_CB_SLNO%>" readonly="readonly" size="3" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_CB_FIRM_NAME)%>"
				name="<%=TENDER_CB_FIRM_NAME%>" readonly="readonly" size="50" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_CB_BRAND_NAME)%>"
				name="<%=TENDER_CB_BRAND_NAME%>" readonly="readonly" size="15" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_CB_MANF_NAME)==null?"":gridData[i].get(TENDER_CB_MANF_NAME)%>"
				name="<%=TENDER_CB_MANF_NAME%>" readonly="readonly" size="16" /></td>


			<!-- 
					<td>
					<select name="<%=TENDER_CB_DISP_TYPE%>" class="medcaption"/>
					<option value="">--Select--</option>				
					<option value="Bottle of (gm)" <%=HMSUtil.isSelected("Bottle of (gm)",gridData[i].get(TENDER_CB_DISP_TYPE).toString())%>>Bottle of (gm)</option>
					<option value="Bottle of (ml)" <%=HMSUtil.isSelected("Bottle of (ml)",gridData[i].get(TENDER_CB_DISP_TYPE).toString())%>>Bottle of (ml)</option>
					<option value="Each" <%=HMSUtil.isSelected("Each",gridData[i].get(TENDER_CB_DISP_TYPE).toString())%>>Each</option>				
					<option value="Jar of (gm)" <%=HMSUtil.isSelected("Jar of (gm)",gridData[i].get(TENDER_CB_DISP_TYPE).toString())%>>Jar of (gm)</option>
					<option value="Kit of (Tests)" <%=HMSUtil.isSelected("Kit of (Tests)",gridData[i].get(TENDER_CB_DISP_TYPE).toString())%>>Kit of (Tests)</option>
					<option value="No" <%=HMSUtil.isSelected("No",gridData[i].get(TENDER_CB_DISP_TYPE).toString())%>>No</option>
					<option value="Pack of (No)" <%=HMSUtil.isSelected("Pack of (No)",gridData[i].get(TENDER_CB_DISP_TYPE).toString())%>>Pack of (No)</option>
					<option value="Reel of (Mtr)" <%=HMSUtil.isSelected("Reel of (Mtr)",gridData[i].get(TENDER_CB_DISP_TYPE).toString())%>>Reel of (Mtr)</option>
					<option value="Strip of (No)" <%=HMSUtil.isSelected("Strip of (No)",gridData[i].get(TENDER_CB_DISP_TYPE).toString())%>>Strip of (No)</option>
					<option value="Tests" <%=HMSUtil.isSelected("Tests",gridData[i].get(TENDER_CB_DISP_TYPE).toString())%>>Tests</option>
					</select>
					</td>
					 -->
			<td><input type="text"
				value="<%=gridData[i].get("composition")%>"
				name="<%="composition"%>" size="10" readonly /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_CB_DISP_TYPE)==null?"":gridData[i].get(TENDER_CB_DISP_TYPE)%>"
				name="<%=TENDER_CB_DISP_TYPE%>" size="10" readonly="readonly" /></td>


			<td><input type="text"
				value="<%=gridData[i].get(TENDER_CB_MDQ)==null?"":gridData[i].get(TENDER_CB_MDQ)%>"
				name="<%=TENDER_CB_MDQ%>" readonly="readonly" size="5" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_CB_VAT)==null?"":gridData[i].get(TENDER_CB_VAT)%>"
				name="<%=TENDER_CB_VAT%>" readonly="readonly" size="8" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_CB_RATE_PER_MDQ)==null?"":gridData[i].get(TENDER_CB_RATE_PER_MDQ)%>"
				name="<%=TENDER_CB_RATE_PER_MDQ%>" readonly="readonly" size="10" /></td>
			<td><input type="text" value="<%=gridData[i].get("taxAmount")%>"
				name="<%="taxAmount"%>" size="10" readonly /></td>
			<td><input type="text" value="<%=gridData[i].get("totAmount")%>"
				name="<%="totAmount"%>" size="10" readonly /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_CB_MRP)%>"
				name="<%=TENDER_CB_MRP%>" size="12" class="medcaption" readonly /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_CB_COMP_RATE)%>"
				name="<%=TENDER_CB_COMP_RATE%>" readonly="readonly" size="8" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_CB_LCAT)%>"
				name="<%=TENDER_CB_LCAT%>" readonly="readonly" size="5" /></td>
			<td><input type="text"
				value="<%=gridData[i].get(TENDER_CB_REMARKS)%>"
				name="<%=TENDER_CB_REMARKS%>" size="30" maxlength="250" /></td>
			<td><input type="checkbox" name="<%=TENDER_CB_DISQUALIFIED%>"
				value="<%=gridData[i].get(TENDER_CB_SUPPLIER_ID)%>" <%=checked%> />
			</td>
			<td><input type="hidden" name="<%=TENDER_CB_SUPPLIER_ID%>"
				value="<%=gridData[i].get(TENDER_CB_SUPPLIER_ID)%>" /></td>
		</tr>
		<% } %>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<div id="pagination"><%= pagedArray.showIndex()%> <%= pagedArray.getPageIndexHiddenTag()%>
</div>
<% } %>
</div>
</form>
