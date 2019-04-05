<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map<String,Object>) request.getAttribute("map");
}

BigDecimal crvAmount = new BigDecimal(0);
BigDecimal totalAmount = new BigDecimal(0);
BigDecimal poAmount = new BigDecimal(0);
BigDecimal spendAmount = new BigDecimal(0);
BigDecimal balanceAmount = new BigDecimal(0);

	if(map.get("crvAmount") != null){
	   crvAmount = (BigDecimal)map.get("crvAmount");
	}
	if(map.get("totalAmount") != null){
	   totalAmount = (BigDecimal)map.get("totalAmount");
	}
	if(map.get("poAmount") != null){
	   poAmount = (BigDecimal)map.get("poAmount");
	}
	if(map.get("spendAmount") != null){
		spendAmount = (BigDecimal)map.get("spendAmount");
	}
	if(map.get("balanceAmount") != null){
		balanceAmount = (BigDecimal)map.get("balanceAmount");
	}

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";

	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	List budgetDetailsList = new ArrayList();

	if(map.get("budgetDetailsList")!=null){
		budgetDetailsList = (List) map.get("budgetDetailsList");
	}
%>
<%@page import="java.util.Iterator"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<h4>Budget Allotment Details</h4>
<div class="Clear"></div>

<div class="Clear"></div>

<div class="tableHolderAuto">
 <table width="100%" colspan="7" id="budgetEntryDetails" cellpadding="0" cellspacing="0">
  <thead>
    <tr>

      <th width="5%">SI No.</th>
      <th width="13%">Authority Letter No.      </th>
      <th width="10%">Projected Amount      </th>
      <th width="13%">Budgeted Amount      </th>
      <th width="13%">Additional Allocation</th>

    </tr>

  </thead>
  <tbody>

 
	<%

		int srNo = 1;
	for (Iterator iterator = budgetDetailsList.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();
		//int srNo = (Integer)object[0];
		String authorityLetterNo = (String)object[1];
		BigDecimal projectAmt = (BigDecimal)object[2];
		BigDecimal budgetedAmt = (BigDecimal)object[3];
		BigDecimal additionalAmt = (BigDecimal)object[4];


	%>
      <tr>
      <td width="5%">
      <input type="text" size="2" value="<%=srNo++%>"  name="" readonly="readonly" />
      </td>

      <td width="10%">
      <% if(authorityLetterNo != null){%>
      <input type="text" value="<%=authorityLetterNo%>" size="10" name="" readonly="readonly" tabindex="2"  />
      <%}else{ %>
      <input type="text" value="" size="10" name="" readonly="readonly" tabindex="2"  />
      <%} %>
      </td>

      <td width="10%">
      <% if(projectAmt != null){%>
      <input type="text" value="<%=projectAmt%>" size="10" name="" readonly="readonly" tabindex="2" />
      <%}else{ %>
      <input type="text" value="" size="10" name="" readonly="readonly" tabindex="2" />
      <%} %>
      </td>

      <td width="3%">
      <% if(budgetedAmt != null){%>
      <input type="text" size="10" value="<%=budgetedAmt%>" name="" readonly="readonly" tabindex="2" />
      <%}else{ %>
      <input type="text" size="10" value="" name="" readonly="readonly" tabindex="2" />
      <%} %>
      </td>

      <td width="3%">
      <% if(additionalAmt != null){%>
      <input type="text" size="10" value="<%=additionalAmt%>" name="" readonly="readonly" tabindex="2" />
      <%}else{ %>
      <input type="text" size="10" value="" name="" readonly="readonly" tabindex="2" />
      <%} %>
      </td>
          </tr>
          <input type="hidden" name="<%=SR_NO %>" value="<%=srNo %>" />
          <%} %>
  </tbody>

</table>
				</div>
				<div class="clear" ></div>



<h4><u>Budget Summary Details</u></h4>


			<label >Total Amount Allocated </label>
			<label class="value"><%=totalAmount %></label>
			<input type="hidden" id="totalAmt" name="<%=TOTAL_ALLOCATED_AMOUNT %>" value="<%=totalAmount %>" readonly="readonly"  MAXLENGTH="8" tabindex=1 />

			<label >Total Amount Booked </label>
			<label class="value"><%=crvAmount == null?"":crvAmount %></label>
			<input type="hidden" id="crvAmt" name="<%=CRV_COMMITTED_AMOUNT %>" value="<%=crvAmount == null?"":crvAmount %>" readonly="readonly"  MAXLENGTH="8" tabindex=1 />

			<div class="Clear"></div><!--

			<label >SO Amount Committed </label>
			<label class="value"><%=poAmount %></label>
			--><input type="hidden" id="soAmt" name="<%=PO_COMMITTED_AMOUNT %>" value="<%=poAmount %>" readonly="readonly"  MAXLENGTH="8" tabindex=1 />

			<label >Total Amount Spent </label>
			<label class="value"><%=spendAmount%></label>
			<input type="hidden" id="prevSpendAmt" name="<%=PREVIOUS_SPEND_AMOUNT %>" value="<%=spendAmount%>" readonly="readonly"  style="width: 120px;"  MAXLENGTH="8" tabindex=1 />
		<div class="Clear"></div>

		<!--<div style="display:none;">
		-->
		<%
		double d=0.0;
		if(totalAmount.doubleValue()!=0 && totalAmount!=null){

			d=(spendAmount.doubleValue()/totalAmount.doubleValue())*100;
			Double d1=new Double(d);
		   BigDecimal b=new BigDecimal(d);
		    b=b.setScale(2,BigDecimal.ROUND_HALF_UP);
		    d=b.doubleValue();
		}

		%>
		<label  >Amount Spent% </label>
		<input type="text" id="spendAmt" name="<%= SPEND_AMOUNT%>" value="<%=d%>" validate="Spent Amt,float,no"   MAXLENGTH="15" tabindex=1 /><!--
		</div>


		--><label  >Total Amount Balance </label>
		<label class="value"><%=balanceAmount%></label>
		<input type="hidden" id="balance" name="<%= BALANCE_AMOUNT%>" value="" readonly="readonly"  MAXLENGTH="15" tabindex=1 />

		<div ></div>



				<div class="Clear"></div>
</form>
	<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
	<input type="hidden" name="rows" id="rr" value="1"/>







