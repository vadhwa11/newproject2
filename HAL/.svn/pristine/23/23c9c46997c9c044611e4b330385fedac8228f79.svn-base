<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<%@page import="java.math.BigDecimal"%><script src="/erp/jsp/js/proto.js" type="text/javascript"></script>
<script src="/erp/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/erp/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/erp/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/erp/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/erp/jsp/js/common.js" type="text/javascript"></script>
<script src="/erp/jsp/js/hms.js" type="text/javascript"></script>
<script src="/erp/jsp/js/sorttableAccounts.js" type="text/javascript"></script>
<script type="text/javascript">

	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}

	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>
<form name="faAccountSubGroupBalance" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<Object[]> accountSubGrpList = new ArrayList<Object[]>();
		if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("accountSubGrpList") != null){
		accountSubGrpList = (List<Object[]>)map.get("accountSubGrpList");
	}

%> <%
	if(accountSubGrpList.size() > 0){
%>
<div class="titleBg">
<h2>Account Sub Group Balance</h2>
</div>
<div class="clear"></div>

<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>

<table  width="100%" border="0" id="accId" cellspacing="0" cellpadding="0" class="sortable">
	<tr>
		<th scope="col" width="5%">Code</th>
		<th scope="col">Sub Group</th>
		<th scope="col">Op-Dr</th>
        <th scope="col">Op-Cr</th>
        <th scope="col">YTD - Cr.</th>
        <th scope="col">YTD - Dr.</th>
        <th scope="col">Balance-Dr</th>
        <th scope="col">Balance-Cr</th>
	</tr>
	<tbody id="tableData">
		<%
		String trColor = "";
   	 		for(Object[] accountType : accountSubGrpList){
   	 			//if(accountType.getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Assets")){
   	 				//trColor="#D6FCA9";
   	 			//}else if(accountType.getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Liability")){
   	 				//trColor="#FDBFA1";
   	 			//} else if(accountType.getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Income")){
   	 			//	trColor="#C2F7FA";
   	 			//}else if(accountType.getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Expenditure")){
   	 			//	trColor="#FDF1B1";
   	 			//}
   	    %>
		<tr bgcolor="<%=trColor %>">
			<td class="rightTxt"><%=accountType[1] %></td>
			<td><%=accountType[2] %></td>
			<%
                   if(accountType[6] != null && ((BigDecimal)accountType[6]).compareTo(new BigDecimal(0)) > 0){
           %>
            <td class="rightTxt"><%=accountType[6]%></td>
            <%}else{ %>
            <td class="rightTxt">0.00</td>
            <%} %>
            <%
                   if(accountType[5] != null && ((BigDecimal)accountType[5]).compareTo(new BigDecimal(0)) > 0){
           %>
            <td class="rightTxt"><%=accountType[5] %></td>
           <%}else{ %>
            <td class="rightTxt">0.00</td>
            <%} %>
            
<%
                 if(accountType[4] != null && ((BigDecimal)accountType[4]).compareTo(new BigDecimal(0)) > 0){
         %>
          <td class="rightTxt"><%=accountType[4]%></td>
          <%}else{ %>
          <td class="rightTxt">0.00</td>
          <%} %>
          
          <%
                 if(accountType[3] != null && ((BigDecimal)accountType[3]).compareTo(new BigDecimal(0)) > 0){
         %>
          <td class="rightTxt"><%=accountType[3]%></td>
          <%}else{ %>
          <td class="rightTxt">0.00</td>
          <%} %>
			
 		<% if(accountType[9] != null && ((BigDecimal)accountType[9]).compareTo(new BigDecimal(0)) > 0){
                      %>
             <td class="rightTxt"><%=accountType[9]%></td>
             <%}else{ %>
             <td class="rightTxt">0.00</td>
             <%} %>
             
             <%
                    if(accountType[10] != null && ((BigDecimal)accountType[10]).compareTo(new BigDecimal(0)) > 0){
            %>
             <td class="rightTxt"><%=accountType[10]%></td>
             <%}else{ %>
             <td class="rightTxt">0.00</td>
             <%} %>
			
		</tr>
		<%
  } %>
	</tbody>
</table>
<div class="clear"></div>
<%}else{ %>
<div class="clear"></div>
<h4>No Record found!</h4>

<%} %>
<input type="button" name="Back" value="Back" class="button" onclick="submitForm('faAccountSubGroupBalance','account?method=showAccountSubGroup')" tabindex=1 />


<div class="paddingTop40"></div>
<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
	  </script>
