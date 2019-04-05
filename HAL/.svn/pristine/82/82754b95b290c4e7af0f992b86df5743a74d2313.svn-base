<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>

<%@page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Properties"%>
<%

		Map<String,Object> map = new HashMap<String,Object>();
		List<DgResultEntryHeader> dgResultEntryHeaderByOrderNo = new ArrayList<DgResultEntryHeader>();
		DgResultEntryDetail dgResultEntryDetailForSingleResult = new DgResultEntryDetail();
		Map<String,Object> detailsMap1 = new HashMap<String,Object>();
		Integer resultEntryIndex = 0;
		
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(request.getParameter("resultEntryIndex") != null){
			resultEntryIndex = Integer.parseInt(request.getParameter("resultEntryIndex"));
		}
		if (map.get("detailsMap1") != null){
			detailsMap1 =(Map)map.get("detailsMap1");
		}

		if (detailsMap1.get("dgResultEntryHeaderByOrderNo") != null) {
			dgResultEntryHeaderByOrderNo = (List<DgResultEntryHeader>) detailsMap1
					.get("dgResultEntryHeaderByOrderNo");
		}
		if(dgResultEntryHeaderByOrderNo.size() > 0 ){
			dgResultEntryDetailForSingleResult = dgResultEntryHeaderByOrderNo.get(resultEntryIndex)
												.getDgResultEntryDetails().iterator().next();
		}
		
	%>
<!-- Table Starts -->

<%@page import="java.text.DecimalFormat"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<div class="Clear"></div>
<div class="grid">
<table cellpadding="0" cellspacing="0">
<tr>
<th>Sl No. </th>
<th>Investigation</th>
<th >Result</th>
<th >UOM</th>
<th >Normal Range</th>
<th >Remarks</th>
</tr>
<tr>
<td >a)</td>
<%if(dgResultEntryDetailForSingleResult.getInvestigation() !=null){ %>
<td ><%=dgResultEntryDetailForSingleResult.getInvestigation().getInvestigationName() %></td>
<%}else { %> <td >-</td>
<%} %> <% 
    try{
    	if(dgResultEntryDetailForSingleResult.getInvestigation().getMinNormalValue() != null
    		&& dgResultEntryDetailForSingleResult.getInvestigation().getMaxNormalValue() != null
    		&& dgResultEntryDetailForSingleResult.getResult() != null 
			&& !dgResultEntryDetailForSingleResult.getResult().equals("")){ 
    		Float minValue = Float.parseFloat(dgResultEntryDetailForSingleResult.getInvestigation().getMinNormalValue());
    		Float maxValue = Float.parseFloat(dgResultEntryDetailForSingleResult.getInvestigation().getMaxNormalValue());
    		//if(dgResultEntryDetailForSingleResult.getResult() != null 
    		//		&& !dgResultEntryDetailForSingleResult.getResult().equals("")){
    			
    			String[] InvestigationId = null;
    			Properties properties = new Properties();
    			URL resourcePath = Thread.currentThread().getContextClassLoader()
    					.getResource("adt.properties");
		    			try {
		    				 properties.load(resourcePath.openStream());
		    				//String [] wardDepartmentTypeCode = (String []) properties.get("a");
		    				InvestigationId = properties.getProperty("InvetigationIdforWithoutDecimalResultPrinting").trim().split(",");
		    				//departmentTypeCode = properties.getProperty("departmentTypeCodeForOpd");
		    				
		    			} catch (Exception e) {
		    				e.printStackTrace();
		    			}		    			
		    			
		    			List<String> inv = new ArrayList<String>(Arrays.asList(InvestigationId));
		    			Float floatResult1   = Float.parseFloat(dgResultEntryDetailForSingleResult.getResult());
		    			String finalResult="";
		    			if(inv.contains(dgResultEntryDetailForSingleResult.getInvestigation().getId().toString()))
		    			{
		    				 finalResult = new DecimalFormat("0.##").format((double)floatResult1); // without decimal
		    			}
		    			else
		    			{
		    				 finalResult = floatResult1.toString(); // with decimal
		    			}

    			Float result1   = Float.parseFloat(dgResultEntryDetailForSingleResult.getResult());
	    		String result = new DecimalFormat("0.##").format((double)result1);
	    		if(result1 <= maxValue && result1 >= minValue ){ %> <td  ><%=finalResult%></td>
<% }else{ %> <td style="font-weight: bold; font-size: 14px;"><%=finalResult %></td>
<% }
    		//}else{%> <!-- <td  style="width: 80px;padding-left: 93px;">No Result Entered</td> -->
<%//}
	       }else{ %> <td>-</td> <% } 
    }catch(Exception exception){ %> <td><%=dgResultEntryDetailForSingleResult.getResult()%></td>
<% } %> <% if(dgResultEntryDetailForSingleResult.getInvestigation().getUom() != null){ %>
<td ><%=dgResultEntryDetailForSingleResult.getInvestigation().getUom().getUomName()%></td>
<% }else{ %> <td >-</td>
<% } %> <% if(dgResultEntryDetailForSingleResult.getInvestigation().getMinNormalValue() != null
    		&& dgResultEntryDetailForSingleResult.getInvestigation().getMaxNormalValue() != null
    		&& !dgResultEntryDetailForSingleResult.getInvestigation().getMinNormalValue().equals("")
    		&& !dgResultEntryDetailForSingleResult.getInvestigation().getMaxNormalValue().equals("")
    		){
    	    Float minValue1 = Float.parseFloat(dgResultEntryDetailForSingleResult.getInvestigation().getMinNormalValue());
    		Float maxValue1 = Float.parseFloat(dgResultEntryDetailForSingleResult.getInvestigation().getMaxNormalValue());
    		String minValue = new DecimalFormat("0.##").format((double)minValue1);
    		String maxValue = new DecimalFormat("0.##").format((double)maxValue1);
    		%> <td ><%=minValue%>
- <%=maxValue %> </td>
 <% }else{ %> <td>-</td> <% } %> <% if(dgResultEntryDetailForSingleResult.getRemarks() != null 
    		&& !dgResultEntryDetailForSingleResult.getRemarks().equals("")){ %>
<td ><%=dgResultEntryDetailForSingleResult.getRemarks()%></td>
<% } else { %> <td>-</td> <% } %>
</tr>
</table>
</div>