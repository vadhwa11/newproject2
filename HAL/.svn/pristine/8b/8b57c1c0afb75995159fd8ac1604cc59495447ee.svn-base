<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants,java.math.BigDecimal"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueM"%>
<script type="text/javascript" src="/hms/jsp/js/autocomplete.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
	<script type="text/javascript">
			vBulletin_init();
	</script>
 
	<%
	 int pageNo=0;
	 Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}
	String deptName="";
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
		int deptId = (Integer)map.get("deptId");
		String date=(String)map.get("date");
		String time=(String)map.get("time");
		String fromDate=(String)map.get("fromDate");
		String toDate=(String)map.get("toDate");
	
	List listOfItemsInStock=new ArrayList();
	List issueNoList= new ArrayList();
	try {
					if(map.get("listOfItemsInStock") != null){
						listOfItemsInStock=(List)map.get("listOfItemsInStock");
					}
					if (map.get("issueNoList") != null) {
						issueNoList = (List)map.get("issueNoList");
					}
	} catch (Exception exp) {
		exp.printStackTrace();
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	%>
<!-- <div id="contentspace"> -->
<!-- <jsp:include page="searchResultPO.jsp" />-->
<!-- </form> -->
	<form name="wardConsumption" method="post">
	<div id="testDiv">
	 <input type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" />
	  <input type="hidden" name="date" id="date" value="<%=pageNo%>" />
	<!--  code to make the search panel -->
	<!--  code to make the search panel -->		
		<%
			List ipIssueNo=(List)map.get("ipIssueNo");
			StoreFyDocumentNo storeFyDocumentNo= (StoreFyDocumentNo)ipIssueNo.get(0);
			int issueNoOfWard=(Integer)map.get("issueNoOfWard");
		%>
		<div class="clear paddingTop15"></div>
		<div class="Block">
		<label>IP Issue No. </label>
		<label  class="value"><%=issueNoOfWard%></label>
		<input type="hidden" name="ipissueno1" id="ipissueno1" value="<%= issueNoOfWard%>"  />
 		<label>Page No.</label>
		<label  class="value">  <%=pageNo%></label>
		</div>  
			<div class="clear paddingTop15"></div>
	<h4>Ward Consumption Details</h4>
	<div class="cmntable">
    <table width="100%" colspan="7" id="stockDetails"  border="0" cellpadding="0" cellspacing="0">
     <thead>
    <tr>
      <th width="5%">SR No.</th>
	   <th width="15%">PVMS No.</th>
	  <th colspan="2">Nomenclature</th>
	     	<th width="15%">A/U</th>  
      <th width="46%">Total Quantity Issued </th>
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
      <input type="text" size="2"	value="<%=temp+inc%>"  name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
      <td width="15%">
	  <input type="text"   name="pvmsNo<%=inc%>"  id="pvmsNo<%=inc%>" readonly />
	   <input type="hidden"   name="itemId<%=inc%>" id="itemId<%=inc %>"  value="" />
	  </td>
      <td width="15%">
      	<input type="text" value=""	tabindex="1" id="brandName<%=inc%>" size="90"  name="brandName<%=inc%>" onblur="if(fillSrNo('<%=inc %>')){checkForBrandWardConsumption(this.value, '<%=inc %>','<%=deptId %>','<%=deptName %>');}" />
			<div id="ac2update" style="display:none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('brandName<%=inc%>','ac2update','ipd?method=getItemListForWardConsume',{parameters:'requiredField=brandName<%=inc%>'});
			</script>
		   </td>
	  <td width="2%">
	    <IMG SRC="/hms/jsp/images/search.gif" WIDTH="26" HEIGHT="26" style="cursor:pointer;float:right;" onClick="javascript:openpopforItemSearch('<%=inc%>');" title="Click here to Search for common name">
	  </td>
      <td width="19%">
      <input type="text" value="" 	id="nomenclature<%=inc%>"   name="<%=RequestConstants.NOMENCLATURE%>"  />     </td>
	 
      <td width="46%">
	  <input type="text" value=""  	name="<%=RequestConstants.QTY_ISSUED%>" id="qtyIssued<%=inc%>"   readonly /></td>
     </tr>
     <%	} %>
  </tbody>
 </table>
 </div>
		<div class="clear"></div>
		<div class="division"></div>
		<input type="hidden" id="storeFyDocumentNoId" value="<%= storeFyDocumentNo.getId()%>"  />
		<input type="hidden" id="frDate" name="frDate" value="<%=fromDate%>"/>
		<input type="hidden" id="toDate" name="toDate" value="<%=toDate%>"/>
  		<input type="button" class="button" value="Next"  onclick="if(checkForNext()){submitForm('wardConsumption','ipd?method=showWardList&buttonFlag=next&deptId=<%=deptId%>&issueNoOfWard=<%=issueNoOfWard%>&fromDate=<%=fromDate%>&toDate=<%=toDate%>');}" align="right" />
  		<input type="button" class="button"  value="Back" align="left" onClick="submitForm('wardConsumption','ipd?method=showPatientListJsp');" />
		<input type="button" class="button" value="Delete"  onclick="openPopupForDelete(<%=issueNoOfWard%>);" align="right" />
		<!-- if(checkForNext()){submitForm('wardConsumption','ipd?method=showWardConsumptionJsp&buttonFlag=next');} -->
		<input type="hidden" size="2"	value=""  name="noOfRecords" id="noOfRecords" />
		<!-- <input type="hidden" name="<%=RequestConstants.STORE_ITEM_BATCH_STOCK_ID %>" value="" id="hdb" /> -->
		<input type="hidden" value="<%= deptId%>"  name="deptId" id="deptId" />
 		<div class="clear"></div>
		<div class="division"></div>
</div>	
	</form>
	 <input type="hidden" name="rows" id="rr" value="1"/>
	
