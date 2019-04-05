<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.LibBookIssueDetail"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<LibBookIssueDetail> issueDtList = new ArrayList<LibBookIssueDetail>();
	if(map.get("issueDtList") != null){
		issueDtList=(List<LibBookIssueDetail>)map.get("issueDtList");
	}
	System.out.println("issueDtList  ::"+issueDtList.size());
	
%>
<%				
				if(issueDtList.size() == 0){
				out.println("Book Already returned !");
							}else{
	%>
<div class="tableHolderAuto">

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetails">
	<thead>
		<tr>
			<th scope="col">Sr No.</th>
			<th scope="col">Book No.</th>
			<th scope="col">Name Of Book</th>
			<th scope="col">Quantity</th>
			<th scope="col">Return</th>
		</tr>
	</thead>
	<tbody>

		<%
					
		int inc=1;
		for(LibBookIssueDetail libBookIssueDetail :issueDtList){ 
			inc++;
	%>

		<tr>
			<td width="5%">
				<input type="text" size="2" value="<%=inc%>" name="<%=SR_NO%><%=inc%>" readonly="readonly" />
			</td>
			<td>	
				<input type="text" name="<%=BOOK_NO%>" id="accountNo<%=inc %>" value="<%=libBookIssueDetail.getBook().getBookNo() %>" size="30" align="right" tabindex="1" readonly="readonly"/>
			</td>
			<td>
				<input type="text" tabindex="1" align="right" name="<%=BOOK_NAME%>" size="30" id="bookName<%=inc %>" value="<%=libBookIssueDetail.getBook().getBookName() %>" readonly="readonly"/> 
				<input type="hidden" name="<%=BOOK_ISSUE_DETAIL_ID%>" id="issueDtId<%=inc %>" value="<%=libBookIssueDetail.getId() %>" />
			</td>

			<td>
				<input type="text" name="<%=QUANTITY%>"	id="quantity<%=inc %>" value="<%=libBookIssueDetail.getQuantity() %>" size="4" align="right" tabindex="1" readonly="readonly"/></td>
			<td>
				<input id="returnId<%=inc %>" name="<%=RETURN%>" type="checkbox" value="y" class="check" />
			<td>
		</tr>
		<%} %>
		<input type="hidden" value="<%=inc %>" name="hiddenValueCharge"	id="hiddenValueCharge" />
		<% }%>
	</tbody>
</table>
</div>



