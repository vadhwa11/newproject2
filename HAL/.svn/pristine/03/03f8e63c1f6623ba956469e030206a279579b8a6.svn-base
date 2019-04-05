<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%
		int pageNo=1;
		Map<String,Object> map = new HashMap<String,Object>();
		List<DgResultEntryDetail> dgResultdetailListForSingleResult = new ArrayList<DgResultEntryDetail>();
		DgResultEntryDetail dgResultEntryDetailForSingleResult = new DgResultEntryDetail();
		Map<String,Object> orderDetailMap = new HashMap<String,Object>();
		Integer resultEntryIndex = 0;
		String requestFlag = "";
		
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(request.getParameter("resultEntryIndex") != null){
			resultEntryIndex = Integer.parseInt(request.getParameter("resultEntryIndex"));
		}
		if(request.getParameter("requestFlag") != null){
			requestFlag = request.getParameter("requestFlag");
		}
		if(requestFlag.equalsIgnoreCase("fromOrderStatusReport")){
			if (map.get("orderDetailMap") != null){
				orderDetailMap =(Map)map.get("orderDetailMap");
			}

			if (orderDetailMap.get("dgResultEntryDetailLabList") != null) {
				dgResultdetailListForSingleResult = (List<DgResultEntryDetail>) orderDetailMap
						.get("dgResultEntryDetailLabList");
			}
		}else{
			if (map.get("dgResultdetailList") != null) {
				dgResultdetailListForSingleResult = (List<DgResultEntryDetail>) map
						.get("dgResultdetailList");
			}
		}
		if(dgResultdetailListForSingleResult.size() > 0 ){
			dgResultEntryDetailForSingleResult = dgResultdetailListForSingleResult.get(resultEntryIndex);
		}
		
	%>
<!-- Table Starts -->

<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<div class="Clear"></div>
<label style="width: 50px; padding-left: 35px; font-size: 11px;">Sr
No. </label>
<label style="padding-left: 40px; width: 50px; font-size: 11px;">Result</label>
<label style="padding-left: 44px; width: 50px; font-size: 11px;">UOM</label>
<label style="padding-left: 50px; font-size: 11px;">Normal Range</label>
<div class="Clear"></div>
<label class="value" style="width: 10px;">a)</label>
<% 
    try{
    	if(dgResultEntryDetailForSingleResult.getInvestigation().getMinNormalValue() != null
    		&& dgResultEntryDetailForSingleResult.getInvestigation().getMaxNormalValue() != null){ 
    		Float minValue = Float.parseFloat(dgResultEntryDetailForSingleResult.getInvestigation().getMinNormalValue());
    		Float maxValue = Float.parseFloat(dgResultEntryDetailForSingleResult.getInvestigation().getMaxNormalValue());
    		Float result1 = (float)0.0;
    		String resultWhenBlank = "";
    		if(dgResultEntryDetailForSingleResult.getResult() != null 
    				&& !dgResultEntryDetailForSingleResult.getResult().equals("")){
    			result1   = Float.parseFloat(dgResultEntryDetailForSingleResult.getResult());	
    		}
    		
    		if(result1 == 0.0){ %>
<label class="value" style="width: 80px; padding-left: 70px;"><%=resultWhenBlank%></label>
<%	}else{
	    		String result = new DecimalFormat("0.##").format((double)result1);
	    		if(result1 <= maxValue && result1 >= minValue ){ %>
<label class="value" style="width: 80px; padding-left: 70px;"><%=result%></label>
<% }else{ %>
<label class="value"
	style="width: 80px; font-weight: bold; padding-left: 70px;"><%=result %></label>
<% }
    		}    		
    		%>
<% }else{ %>
<label class="value" style="width: 80px; padding-left: 70px;"><%=dgResultEntryDetailForSingleResult.getResult()%></label>
<% } 
    }
    catch(Exception exception){ %>
<label class="value" style="width: 90px; padding-left: 65px;"><%=dgResultEntryDetailForSingleResult.getResult()%></label>
<%}
    %>


<% if(dgResultEntryDetailForSingleResult.getInvestigation().getUom() != null){ %>
<label class="value" style="width: 60px; padding-left: 10px;"><%=dgResultEntryDetailForSingleResult.getInvestigation().getUom().getUomName()%></label>
<% }else{ %>
<label class="value" style="width: 60px; padding-left: 10px;">-</label>
<% } %>


<% if(dgResultEntryDetailForSingleResult.getInvestigation().getMinNormalValue() != null
    		&& dgResultEntryDetailForSingleResult.getInvestigation().getMaxNormalValue() != null){ 
     		Float minValue1 = Float.parseFloat(dgResultEntryDetailForSingleResult.getInvestigation().getMinNormalValue());
    		Float maxValue1 = Float.parseFloat(dgResultEntryDetailForSingleResult.getInvestigation().getMaxNormalValue());
    		String minValue = new DecimalFormat("0.##").format((double)minValue1);
    		String maxValue = new DecimalFormat("0.##").format((double)maxValue1);
    		%>
<label class="value" style="width: 170px;"><%=minValue%> - <%=maxValue %>
</label>


<% }else{ %>
<label class="value" style="width: 170px;">-</label>
<% } %>






