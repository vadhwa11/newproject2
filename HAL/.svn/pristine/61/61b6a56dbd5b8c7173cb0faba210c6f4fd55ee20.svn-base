<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgFixedValue"%>
<%@page import="java.net.URL"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/report.css" />
<%

	

	String[] orderStatusMsg = null;
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	List<Map<String, Object>> resultDetailsMapList = new ArrayList<Map<String,Object>>();

	int initialHieght = 22;
	int mapIndex = 0;
	Map<String, Object> jspMap = new HashMap<String ,Object>(); 
	if(request.getAttribute("map") != null){
		jspMap = (Map) request.getAttribute("map");
	}
	
	if(jspMap.get("orderStatusMsg") != null){
		orderStatusMsg = (String[])jspMap.get("orderStatusMsg");
	}
	if (jspMap.get("resultDetailsMapList") != null){
		resultDetailsMapList =(List)jspMap.get("resultDetailsMapList");
	}
	if(request.getParameter("mapIndex") != null){
		mapIndex = Integer.parseInt(request.getParameter("mapIndex"));
	}
	Map<String, Object>  multipleResultMap = resultDetailsMapList.get(mapIndex);
	
	List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
	if(multipleResultMap.get("dgResultdetailList") != null){
		dgResultdetailList = (List<DgResultEntryDetail>)multipleResultMap.get("dgResultdetailList");
	}
	if(dgResultdetailList.size()>0){
		initialHieght = initialHieght + dgResultdetailList.size()*27;
	}
	List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
	try{
		if(multipleResultMap.get("fixedValList") != null){
			fixedValList=(List)multipleResultMap.get("fixedValList");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	try{
		if(multipleResultMap.get("resultList") != null){
			resultList=(List)multipleResultMap.get("resultList");
		}
	}catch(Exception e){
		e.printStackTrace();
	}

	DgResultEntryHeader dgResultEntryHeaderForReport = new DgResultEntryHeader();
		if(resultList != null && resultList.size()>0)	   {
		   dgResultEntryHeaderForReport = (DgResultEntryHeader) resultList.get(0);
		}

%>
<%@page import="java.text.DecimalFormat"%>

<!-- Table Starts -->


<div class="gridSmall">
<table width="100%" border="1" cellspacing="1" cellpadding="1">
	<thead>
	<tr>
<td>Sl. No. </td>
<td>Investigation</td>
<td>Result</td>
<td>UOM</td>
<td>Normal Range</td>
</tr>
</thead>
<tr>
<% char i = 96;
	    Set<DgNormalValue>normalSet = new HashSet<DgNormalValue>();
	    for(DgResultEntryDetail dgDetail :dgResultdetailList){
	    	i++;
	    %>

<!--  when result type is SINGLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition male  -->
<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %>

<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("m")){
							%>

<td><%=i %>)</td>

<%if(dgDetail.getSubInvestigation() !=null){ %>
<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
`<%}else { %> <td
	>-</td><%} %> <%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <td
	 > <%=dgDetail.getResult() %></td>
<% }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% }
					    	}else{%> <td 
	>-</td><%}
					       }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% } 
				    }catch(Exception exception){ %> <td 
	> <%=dgDetail.getResult() %></td>
<%} %> <%if(dgDetail.getUom() !=null){ %> <td 
	><%=dgDetail.getUom().getUomName() %></td>
<%}else { %> <td  >-</td>
<% } %> 
<%if(dgDetail.getNormal() != null){ %> 
<%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> 
			<td><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
</td><td> <%=dgDetail.getNormal().getId() %> </td><%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %>
 <td>-</td>
 <%}} %>


<%
				}
					}
						}
				}
				} %> <!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition male -->

<!--  when result type is SINGLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition Female  --> <%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%> <%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("f")){
							%> <td ><%=i %>)</td><%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %> <td 
	>-</td><%} %> <%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <td
	 > <%=dgDetail.getResult() %></td>
<% }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% }
					    	}else{%> <td 
	>-</td><%}
					       }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% } 
				    }catch(Exception exception){ %> <td 
	> <%=dgDetail.getResult() %></td>
<%} %> <%if(dgDetail.getUom() !=null){ %> <td 
	><%=dgDetail.getUom().getUomName() %></td>
<%}else { %> <td  >-</td>
<%} %> <%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <td  ><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %> <td  >-</td>
<%}} %>

<%}}
					}
					}
				} %> <!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition female -->

<!--  when result type is SINGLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition None  --> <%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%> <%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%> <td><%=i %>)</td><%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %> <td 
	>-</td><%} %> <%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <td
	 > <%=dgDetail.getResult() %></td>
<% }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% }
					    	}else{%> <td 
	>-</td><%}
					       }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% } 
				    }catch(Exception exception){ %> <td 
	> <%=dgDetail.getResult() %></td>
<%} %> <%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <td><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %> <td>-</td><%}} %>

<%}}
					}
					}
				} %> <!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition NoNe -->

<!--  when result type is MULTIPLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition male fg  --> <%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %> <%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
<% if(normalSet.size()>0){
					//for(DgNormalValue nv :normalSet){
						//if(nv != null && nv.getSex().equalsIgnoreCase("m")){
						%> <td ><%=i %>)</td><%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %> <td 
	>-</td><%} %> <%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <td
	 > <%=dgDetail.getResult() %></td>
<% }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% }
					    	}else{%> <td 
	>-</td><%}
					       }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% } 
				    }catch(Exception exception){ %> <td 
	> <%=dgDetail.getResult() %></td>
<%} %> <%if(dgDetail.getUom() !=null){ %> <td 
	><%=dgDetail.getUom().getUomName() %></td>
<%}else { %> <td  >-</td>
<%} %> <%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <td><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %> <td>-</td><%}} %>

<%
				}
				//	}
				//		}
				}
				} %> <!--  when result type is MULTIPLE PARAMETER and comaprison type NORMAL VALUE and condition male -->

<!--  when result type is MULTIPLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition Female  --> <%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %> <%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
<% if(normalSet.size()>0){
					//for(DgNormalValue nv :normalSet){
					//	if(nv != null && nv.getSex().equalsIgnoreCase("f")){
						%> <td><%=i %>)</td><%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %> <td 
	>-</td><%} %> <%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <td
	 > <%=dgDetail.getResult() %></td>
<% }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% }
					    	}else{%> <td 
	>-</td><%}
					       }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% } 
				    }catch(Exception exception){ %> <td 
	> <%=dgDetail.getResult() %></td>
<%} %> <%if(dgDetail.getUom() !=null){ %> <td 
	><%=dgDetail.getUom().getUomName() %></td>
<%}else { %> <td  >-</td>
<%} %> <%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <td><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %> <td>-</td><%}} %>
<%
				}
				//	}
				//		}
				}
				} %> <!--  when result type MULTIPLE PARAMETER and comaprison type NORMAL VALUE and condition fEmale -->

<!--  when result type is multiple PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition none  --> <%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%> <%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%> <td><%=i %>)</td>
    	  		
    	  		<%if(dgDetail.getSubInvestigation() !=null){ %>
				<td   ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
				<%}else { %>
				<td   >-</td>
				<%} %>	
	<%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
					 	<td  > <%=dgDetail.getResult() %></td>	
								<% }else{ %>
					 	<td  > <%=dgDetail.getResult() %></td>					    		
								<% }
					    	}else{%>
					 	<td  >-</td>
				    		<%}
					       }else{ %>
					 	<td  > <%=dgDetail.getResult() %></td>
				    	<% } 
				    }catch(Exception exception){ %>
					 	<td  > <%=dgDetail.getResult() %></td>
				<%} %>
			  <%if(dgDetail.getUom() !=null){ %>
				<td  ><%=dgDetail.getUom().getUomName() %></td>
			  <%}else { %>
				<td  >-</td>
			  <%} %>	

			
			<%if(dgDetail.getNormal() != null){ %>
              <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
			<td><%= dgDetail.getNormal().getNormalValue()%></td>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
			<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
			<%}}else{ %>
			<td>-</td>
			<%}} %>

			
			<%
				}
					}
						}
				}
				} %>
		    	 <!--  when result type is Multiple PARAMETER and comaprison type NORMAL VALUE and condition none -->

<!--  when result type is MULTIPLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition male  --> <%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %> <%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("m")){
							%> <td><%=i %>)</td><%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %> <td 
	>-</td><%} %> <%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <td
	 > <%=dgDetail.getResult() %></td>
<% }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% }
					    	}else{%> <td 
	>-</td><%}
					       }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% } 
				    }catch(Exception exception){ %> <td 
	> <%=dgDetail.getResult() %></td>
<%} %> <%if(dgDetail.getUom() !=null){ %> <td 
	><%=dgDetail.getUom().getUomName() %></td>
<%}else { %> <td  >-</td>
<%} %> <%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <td><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %> <td>-</td><%}} %>


<%
				}
					}
						}
				}
				} %> <!--  when result type is TEXT AREA  and comaprison type NORMAL VALUE and condition male -->

<!--  when result type is TEXT AREA and comparison type is NORMAL VALUE  -->
<!--  condition Female  --> <%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %> <%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("f")){
						%>
						 <td><%=i %>)</td><%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %> <td 
	>-</td><%} %> <%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <td
	 > <%=dgDetail.getResult() %></td>
<% }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% }
					    	}else{%> <td 
	>-</td><%}
					       }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% } 
				    }catch(Exception exception){ %> <td 
	> <%=dgDetail.getResult() %></td>
<%} %> <%if(dgDetail.getUom() !=null){ %> <td 
	><%=dgDetail.getUom().getUomName() %></td>
<%}else { %> <td  >-</td>
<%} %> <%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <td><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %> <td>-</td><%}} %>


<%
				}
					}
						}
				}
				} %> <!--  when result type TEXT AREA and comaprison type NORMAL VALUE and condition fEmale -->

<!--  when result type is TEXT AREA and comparison type is NORMAL VALUE  -->
<!--  condition none  --> <%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%> <%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%> <td><%=i %>)</td><%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %> <td 
	>-</td><%} %> <%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <td
	 > <%=dgDetail.getResult() %></td>
<% }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% }
					    	}else{%> <td 
	>-</td><%}
					       }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% } 
				    }catch(Exception exception){ %> <td 
	> <%=dgDetail.getResult() %></td>
<%} %> <%if(dgDetail.getUom() !=null){ %> <td 
	><%=dgDetail.getUom().getUomName() %></td>
<%}else { %> <td  >-</td>
<%} %> <%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <td><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %> <td>-</td><%}} %>

<%
				}
					}
						}
				}
				} %> <!--  when result type is TEXT AREA and comaprison type NORMAL VALUE and condition none -->

<!--  when result type is Range and comparison type is NORMAL VALUE  -->
<!--  condition male  --> <%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %> <%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("m")){
						%> <td><%=i %>)</td><%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %> <td 
	>-</td><%} %> <%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <td
	 > <%=dgDetail.getResult() %></td>
<% }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% }
					    	}else{%> <td 
	>-</td><%}
					       }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% } 
				    }catch(Exception exception){ %> <td 
	> <%=dgDetail.getResult() %></td>
<%} %> <%if(dgDetail.getUom() !=null){ %> <td 
	><%=dgDetail.getUom().getUomName() %></td>
<%}else { %> <td  >-</td>
<%} %> <%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <td><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %> <td>-</td><%}} %>


<%
				}
					}
						}
				}
				} %> <!--  when result type is Range and comaprison type NORMAL VALUE and condition male -->

<!--  when result type is RANGE and comparison type is NORMAL VALUE  -->
<!--  condition Female  --> <%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %> <%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("f")){
							%> <td><%=i %>)</td><%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %> <td 
	>-</td><%} %> <%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <td
	 > <%=dgDetail.getResult() %></td>
<% }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% }
					    	}else{%> <td 
	>-</td><%}
					       }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% } 
				    }catch(Exception exception){ %> <td 
	> <%=dgDetail.getResult() %></td>
<%} %> <%if(dgDetail.getUom() !=null){ %> <td 
	><%=dgDetail.getUom().getUomName() %></td>
<%}else { %> <td  >-</td>
<%} %> <%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <td><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %> <td>-</td><%}} %>

<%
				}
					}
						}
				}
				} %> <!--  when result type RANGE and comaprison type NORMAL VALUE and condition fEmale -->

<!--  when result type is RANGE and comparison type is NORMAL VALUE  -->
<!--  condition none  --> <%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%> <%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%> <td><%=i %>)</td><%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %> <td 
	>-</td><%} %> <%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <td
	 > <%=dgDetail.getResult() %></td>
<% }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% }
					    	}else{%> <td 
	>-</td><%}
					       }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% } 
				    }catch(Exception exception){ %> <td 
	> <%=dgDetail.getResult() %></td>
<%} %> <%if(dgDetail.getUom() !=null){ %> <td 
	><%=dgDetail.getUom().getUomName() %></td>
<%}else { %> <td  >-</td>
<%} %> <%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <td><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %> <td>-</td><%}} %>

<%
				}
					}
						}
				}
				} %> <!--  when result type is RANGE and comaprison type NORMAL VALUE and condition none -->

<!--  when result type is HEADING and comparison type is NONE --> <%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("h") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>

<td><%=i %>)</td><%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %> <td 
	>-</td><%} %> <td
	 >-</td><td
	 >-</td><td
	>-</td>

<%} %> <!--  end when result type is HEADING and comparison type is NONE  -->
<!--  when result type is HEADING and comparison type is FIXED VALUE -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("h") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>

<td><%=i %>)</td><%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %> <td 
	>-</td><%} %> <td
	 >-</td><td
	 >-</td><td
	>-</td><td>-</td>


<%} %> <!--  end when result type is HEADING and comparison type is FIXED VALUE -->
<!--  when result type is HEADING and comparison type is NORMAL VALUE  -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("h") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){ %>

<td><%=i %>)</td><%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %> <td 
	>-</td><%} %> <td
	 >-</td><td
	 >-</td><td
	>-</td>


<%} %> <!--  end of when result type is HEADING and comparison type is NORMAL VALUE  -->
<!--  when result type is SINGLE PARAMETER and COMPARISON TYPE is NONE  -->
<%if((dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n"))){ %>

<td><%=i %>)</td><%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %> <td 
	>-</td><%} %> <%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <td
	 > <%=dgDetail.getResult() %></td>
<% }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% }
					    	}else{%> <td 
	>-</td><%}
					       }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% } 
				    }catch(Exception exception){ %> <td 
	> <%=dgDetail.getResult() %></td>
<%} %> <%if(dgDetail.getUom() !=null){ %> <td 
	><%=dgDetail.getUom().getUomName() %></td>
<%}else { %> <td  >-</td>
<%} %> <%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <td><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %> <td>-</td><%}} %>



<%} %> <!--  end when result type is SINGLE PARAMETER and COMAPRISON TYPE is NONE -->

<!--  when result type is SINGLE PARAMAETER and comparison type is FIXED VALUE  -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>


<td><%=i %>)</td><%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %> <td 
	>-</td><%} %> <%System.out.println("<<< gDetail.getFixed().getFixedValue() >>>> "+dgDetail.getFixed().getFixedValue()); %>
<!-- frst if --> <%if(dgDetail.getFixed() != null){%> <td 
	><%=dgDetail.getFixed().getFixedValue() %></td>
<%}else{
			%> <td  >
-</td><%} %> <%if(dgDetail.getUom() !=null){ %> <td 
	><%=dgDetail.getUom().getUomName() %></td>
<%}else { %> <td  >-</td>
<%} %> <%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <td><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %> <td>-</td><%}} %>




<%} %> <!-- end of when result type is SINGLE PARAMAETER and comparison type is FIXED VALUE -->
<!--  when result type is MULTIPLE PARAMETER and comparison type is NONE  -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>

<td><%=i %>)</td><%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %> <td 
	>-</td><%} %> <%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <td
	 > <%=dgDetail.getResult() %></td>
<% }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% }
					    	}else{%> <td 
	>-</td><%}
					       }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% } 
				    }catch(Exception exception){ %> <td 
	> <%=dgDetail.getResult() %></td>
<%} %> <%if(dgDetail.getUom() !=null){ %> <td 
	><%=dgDetail.getUom().getUomName() %></td>
<%}else { %> <td  >-</td>
<%} %> <%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <td><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %> <td>-</td><%}} %>



<%} %> <!--  when result type is MULTIPLE PARAMETER and comparison type is NONE   -->
<!--  when result type is MULTIPLE PARAMETER and Comparison type is FIXED VALUE  -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f") ){ %>



<td><%=i %>)</td><%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %> <td 
	>-</td><%} %> <% if(dgDetail.getFixed() != null){	%>
<td  ><%=dgDetail.getFixed().getFixedValue() %></td>
<%}%> <%if(dgDetail.getUom() !=null){ %> <td 
	><%=dgDetail.getUom().getUomName() %></td>
<%}else { %> <td  >-</td>
<%} %> <%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <td><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %> <td>-</td><%}} %>

<%} %> <!-- end when result type is MULTIPLE PARAMETER and Comparison type is FIXED VALUE  -->

<!--  when result type is TEXT AREA and comparison type is NONE --> <%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>

<td><%=i %>)</td><%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %> <td 
	>-</td><%} %> <%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <td
	 > <%=dgDetail.getResult() %></td>
<% }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% }
					    	}else{%> <td 
	>-</td><%}
					       }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% } 
				    }catch(Exception exception){ %> <td 
	> <%=dgDetail.getResult() %></td>
<%} %> <%if(dgDetail.getUom() !=null){ %> <td 
	><%=dgDetail.getUom().getUomName() %></td>
<%}else { %> <td  >-</td>
<%} %> <%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <td><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>

<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %> <td>-</td><%}}else{ %> <td
	>-</td><%} %>

<%} %> <!-- end when result type is TEXT AREA and comparison type is NONE -->

<!--  when result type is TEXT AREA and comparison type is FIXED VALUE -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>

<td><%=i %>)</td><%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %> <td 
	>-</td><%} %> <%if(dgDetail.getFixed() != null){ %>
<td  
	><%=dgDetail.getFixed().getFixedValue() %></td>

<%}%> <%if(dgDetail.getUom() !=null){ %> <td 
	><%=dgDetail.getUom().getUomName() %></td>
<%}else { %> <td  >-</td>
<%} %> <%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <td><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %> <td>-</td><%}} %>


<%} %> <!-- end  when result type is TEXT AREA and comparison type is FIXED VALUE -->
<!--  when result type is Range and comparison type is NONE --> <%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>


<td><%=i %>)</td><%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %> <td 
	>-</td><%} %> <%    try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null
				    		&& dgDetail.getNormal().getMaxNormalValue() != null){ 
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    		if(dgDetail.getResult() != null 
				    				&& !dgDetail.getResult().equals("")){
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %> <td
	 > <%=dgDetail.getResult() %></td>
<% }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% }
					    	}else{%> <td 
	>-</td><%}
					       }else{ %> <td 
	> <%=dgDetail.getResult() %></td>
<% } 
				    }catch(Exception exception){ %> <td 
	> <%=dgDetail.getResult() %></td>
<%} %> <%if(dgDetail.getUom() !=null){ %> <td 
	><%=dgDetail.getUom().getUomName() %></td>
<%}else { %> <td  >-</td>
<%} %> <%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <td><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %> <td>-</td><%}} %>

<%} %> <!-- when result type is RANGE and comparison type is FIXED VALUE  -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>


<td><%=i %>)</td><%if(dgDetail.getSubInvestigation() !=null){ %>
<td><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %> <td>-</td><%} %> <%if(dgDetail.getFixed() != null){ %>
<td><%=dgDetail.getFixed().getFixedValue() %></td>
<%}%> <%if(dgDetail.getUom() !=null){ %> <td><%=dgDetail.getUom().getUomName() %></td>
<%}else { %> <td>-</td>
<%} %> <%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <td><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %> <td>-</td><%}}else{ %>
<td>-</td>
<%} %>



<%}
    	%>
    </tr>	
    	
    	 <%} %>
    	
    	</table>
    	</div>