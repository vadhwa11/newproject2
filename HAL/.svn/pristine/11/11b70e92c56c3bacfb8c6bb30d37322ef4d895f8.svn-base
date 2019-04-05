<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgFixedValue"%>
<%@page import="java.net.URL"%>
<%

	Map<String,Object> map = new HashMap<String,Object>();
	List<DgResultEntryHeader> dgResultEntryHeaderByOrderNo = new ArrayList<DgResultEntryHeader>();
	DgResultEntryDetail dgResultEntryDetailForSingleResult = new DgResultEntryDetail();
	Map<String,Object> detailsMap1 = new HashMap<String,Object>();
	Integer resultEntryIndex = 0;
	DgResultEntryHeader dgResultEntryHeaderForReport = new DgResultEntryHeader();
	
	Set<DgResultEntryDetail> subSet1 = new HashSet<DgResultEntryDetail>();
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if (map.get("detailsMap1") != null){
		detailsMap1 =(Map)map.get("detailsMap1");
	}

	if (detailsMap1.get("dgResultEntryHeaderByOrderNo") != null) {
		dgResultEntryHeaderByOrderNo = (List<DgResultEntryHeader>) detailsMap1
				.get("dgResultEntryHeaderByOrderNo");
	}

	
	if(request.getParameter("resultEntryIndex") != null){
		resultEntryIndex = Integer.parseInt(request.getParameter("resultEntryIndex"));
	}
	
	int age=0;
	if(dgResultEntryHeaderByOrderNo.size() > 0 ){
		
		if(dgResultEntryHeaderByOrderNo.get(0).getPatient().getDateOfBirth() != null)
		{
			Date date_of_birth= dgResultEntryHeaderByOrderNo.get(0).getPatient().getDateOfBirth();
			
		//	Date d1= new Date();
			
			
			age = HMSUtil.calculateAgeInYears(date_of_birth);
		}
		
		
		subSet1 = dgResultEntryHeaderByOrderNo.get(resultEntryIndex)
											.getDgResultEntryDetails();
		dgResultEntryHeaderForReport = dgResultEntryHeaderByOrderNo.get(resultEntryIndex);
	}

	Set<DgResultEntryDetail> dgResultdetail = new LinkedHashSet<DgResultEntryDetail>();
	Set<DgResultEntryDetail> linkedHashSet = DgResultEntryComparatorByOrderNo.getApplicationTreeSet(); 
	for(DgResultEntryDetail dgResultEntryDetail : subSet1){
		linkedHashSet.add(dgResultEntryDetail);
	}
	dgResultdetail.addAll(linkedHashSet);

%>
<%@page import="jkt.hms.util.DgResultEntryComparatorByOrderNo"%>
<%@page import="java.text.DecimalFormat"%>
<div class="Clear"></div>
<!-- Table Starts -->
<div class="grid">
<table cellpadding="0" cellspacing="0">
<tr>

<th >Sl No. </th>
<th >Investigation</th>
<th >Result</th>
<th >UOM</th>
<th >Normal Range</th>
<th >Remarks</th>
</tr>
<% char i = 96;
	    Set<DgNormalValue>normalSet = new HashSet<DgNormalValue>();
	    
	    
	    for(DgResultEntryDetail dgDetail :dgResultdetail){
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
						if(nv != null && nv.getSex().equalsIgnoreCase("m") && age > nv.getFromAge() && age <= nv.getToAge()  ){
							System.out.println("inside male condition normal value  ");
							%>
							<tr>
<td><%=i %>)</td>
<%if(dgDetail.getSubInvestigation() !=null){ %>
<td ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td >-</td>
<%} %>
<%try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null 
		    			&& dgDetail.getNormal().getMaxNormalValue() != null){
		    		if(dgDetail.getResult() != null 
		    				&& !dgDetail.getResult().equals("")){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
<td > <%=result1%></td>
<% }else{ %>
<td style="font-weight: bold; font-size: 14px;"> <%=result1%></td>
<% }
					       }else{ %>
<td >-</td>
<% } 
		    		} else { 
		    		   if(dgDetail.getResult() != null){ %>
<td ><%=dgDetail.getResult()%></td>
<%}else {%>
<td >-</td>
<% }  %>
<%}
				}catch(Exception exception){ %>
<td > <%=dgDetail.getResult() %></td>
<% } %>
<%if(dgDetail.getUom() !=null){ %>
<td ><%=dgDetail.getUom().getUomName() %></td>
<%}else { %>
<td >-</td>
<%} %>
<%if(dgDetail.getNormal() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
<td ><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %>
<td >-</td>
<%}}else{ %>
<td >-</td>
<% } %>
<% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<td ><%=dgDetail.getRemarks()%></td>
<% } else { %>
<td >-</td>
<% } %>
<%
				}
					}
						}
				}
				} %>
<!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition male -->

<!--  when result type is SINGLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition Female  -->
<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("f") && age > nv.getFromAge() && age <= nv.getToAge()){
							%>
<td ><%=i %>)</td>
<%if(dgDetail.getSubInvestigation() !=null){ %>
<td ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td >-</td>
<%} %>
<%try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null 
		    			&& dgDetail.getNormal().getMaxNormalValue() != null){
		    		if(dgDetail.getResult() != null 
		    				&& !dgDetail.getResult().equals("")){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
<td > <%=result1%></td>
<% }else{ %>
<td style="font-weight: bold; font-size: 14px;"> <%=result1%></td>
<% }
					       }else{ %>
<td >-</td>
<% } 
		    		} else { 
		    		   if(dgDetail.getResult() != null){ %>
<td ><%=dgDetail.getResult()%></td>
<%}else {%>
<td >-</td>
<% }  %>
<%}
				}catch(Exception exception){ %>
<td > <%=dgDetail.getResult() %></td>
<% } %>
<%if(dgDetail.getUom() !=null){ %>
<td ><%=dgDetail.getUom().getUomName() %></td>
<%}else { %>
<td >-</td>
<%} %>
<%if(dgDetail.getNormal() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%>
<td ><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %>
<td >-</td>
<%}}else{ %>
<td >-</td>
<% } %>
<% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<td ><%=dgDetail.getRemarks()%></td>
<% } else { %>
<td >-</td>
<% } %>

<%}}
					}
					}
				} %>
<!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition female -->

<!--  when result type is SINGLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition None  -->
<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n") && age > nv.getFromAge() && age <= nv.getToAge()){
						%>
<td  ><%=i %>)</td>
<%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td  >-</td>
<%} %>
<%try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null 
		    			&& dgDetail.getNormal().getMaxNormalValue() != null){
		    		if(dgDetail.getResult() != null 
		    				&& !dgDetail.getResult().equals("")){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
<td  > <%=result1%></td>
<% }else{ %>
<td style="font-weight: bold; font-size: 14px;"
	 > <%=result1%></td>
<% }
					       }else{ %>
<td  >-</td>
<% } 
		    		} else { 
		    		   if(dgDetail.getResult() != null){ %>
<td  ><%=dgDetail.getResult()%></td>
<%}else {%>
<td  >-</td>
<% }  %>
<%}
				}catch(Exception exception){ %>
<td  > <%=dgDetail.getResult() %></td>
<% } %>
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
<td  ><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %>
<td  >-</td>
<%}}else{ %>
<td  >-</td>
<% } %>
<% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<td  ><%=dgDetail.getRemarks()%></td>
<% } else { %>
<td  >-</td>
<% } %>
<%}}
					}
					}
				} %>
<!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition NoNe -->

<!--  when result type is MULTIPLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition male fg  -->
<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	 %>
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
<% if(normalSet.size()>0){
					//for(DgNormalValue nv :normalSet){
						//if(nv != null && nv.getSex().equalsIgnoreCase("m")){
						%>
<td  ><%=i %>)666</td>
<%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td  >-</td>
<%} %>
<%try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null 
		    			&& dgDetail.getNormal().getMaxNormalValue() != null){
		    		if(dgDetail.getResult() != null 
		    				&& !dgDetail.getResult().equals("")){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
<td  > <%=result1%></td>
<% }else{ %>
<td style="font-weight: bold; font-size: 14px;"
	 > <%=result1%></td>
<% }
					       }else{ %>
<td  >-</td>
<% } 
		    		} else { 
		    		   if(dgDetail.getResult() != null){ %>
<td  ><%=dgDetail.getResult()%></td>
<%}else {%>
<td  >-</td>
<% }  %>
<%}
				}catch(Exception exception){ %>
<td  > <%=dgDetail.getResult() %></td>
<% } %>
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
<td  ><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %>
<td  >-</td>
<%}}else{ %>
<td  >-</td>
<% } %>
<% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<td  ><%=dgDetail.getRemarks()%></td>
<% } else { %>
<td  >-</td>
<% } %>
<%
				}
				//	}
				//		}
				}
				} %>
<!--  when result type is MULTIPLE PARAMETER and comaprison type NORMAL VALUE and condition male -->
<!--  when result type is MULTIPLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition Female  -->
<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	 %>
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
<% if(normalSet.size()>0){
					//for(DgNormalValue nv :normalSet){
					//	if(nv != null && nv.getSex().equalsIgnoreCase("f")){
						%>
<td  ><%=i %>)</td>
<%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td  >-</td>
<%} %>
<%try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null && dgDetail.getNormal().getMaxNormalValue() != null
				    		&& dgDetail.getResult() != null 
		    				&& !dgDetail.getResult().equals("")){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
<td  > <%=result1%></td>
<% }else{ %>
<td style="font-weight: bold; font-size: 14px;"
	 > <%=result1%></td>
<% }
					       }else{ %>
<td  >-</td>
<% } 
				}catch(Exception exception){ %>
<td  > <%=dgDetail.getResult() %></td>
<% } %>
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
<td  ><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %>
<td  >-</td>
<%}}else{ %>
<td  >-</td>
<% } %>
<% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<td  ><%=dgDetail.getRemarks()%></td>
<% } else { %>
<td  >-</td>
<% } %>
<%
				}
				//	}
				//		}
				}
				} %>
<!--  when result type MULTIPLE PARAMETER and comaprison type NORMAL VALUE and condition fEmale -->

<!--  when result type is multiple PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition none  -->
<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%>
<td  ><%=i %>)</td>
<%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td  >-</td>
<%} %>
<%try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null 
		    			&& dgDetail.getNormal().getMaxNormalValue() != null){
		    		if(dgDetail.getResult() != null 
		    				&& !dgDetail.getResult().equals("")){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
<td  > <%=result1%></td>
<% }else{ %>
<td
	 > <%=result1%></td>
<% }
					       }else{ %>
<td  >-</td>
<% } 
		    		} else { 
		    		   if(dgDetail.getResult() != null){ %>
<td  ><%=dgDetail.getResult()%></td>
<%}else {%>
<td  >-</td>
<% }  %>
<%}
				}catch(Exception exception){ %>
<td  > <%=dgDetail.getResult() %></td>
<% } %>
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
<td  ><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %>
<td  >-</td>
<%}}else{ %>
<td  >-</td>
<% } %>
<% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<td  ><%=dgDetail.getRemarks()%></td>
<% } else { %>
<td  >-</td>
<% } %>
<%
				}
					}
						}
				}
				} %>
<!--  when result type is Multiple PARAMETER and comaprison type NORMAL VALUE and condition none -->

<!--  when result type is MULTIPLE PARAMETER and comparison type is NORMAL VALUE  -->
<!--  condition male  -->
<% normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
			if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("m")){
							%>
<td  ><%=i %>)</td>
<%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td  >-</td>
<%} %>
<%try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null 
		    			&& dgDetail.getNormal().getMaxNormalValue() != null){
		    		if(dgDetail.getResult() != null 
		    				&& !dgDetail.getResult().equals("")){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
<td  > <%=result1%></td>
<% }else{ %>
<td style="font-weight: bold; font-size: 14px;"
	 > <%=result1%></td>
<% }
					       }else{ %>
<td  >-</td>
<% } 
		    		} else { 
		    		   if(dgDetail.getResult() != null){ %>
<td  ><%=dgDetail.getResult()%></td>
<%}else {%>
<td  >-</td>
<% }  %>
<%}
				}catch(Exception exception){ %>
<td  > <%=dgDetail.getResult() %></td>
<% } %>
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
<td  ><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %>
<td  >-</td>
<%}}else{ %>
<td  >-</td>
<% } %>
<% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<td  ><%=dgDetail.getRemarks()%></td>
<% } else { %>
<td  >-</td>
<% } %>
<%
				}
					}
						}
				}
				} %>
<!--  when result type is TEXT AREA  and comaprison type NORMAL VALUE and condition male -->

<!--  when result type is TEXT AREA and comparison type is NORMAL VALUE  -->
<!--  condition Female  -->
<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	 %>
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("f")){
						%>
<td  ><%=i %>)</td>
<%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td  >-</td>
<%} %>
<%try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null 
		    			&& dgDetail.getNormal().getMaxNormalValue() != null){
		    		if(dgDetail.getResult() != null 
		    				&& !dgDetail.getResult().equals("")){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
<td  > <%=result1%></td>
<% }else{ %>
<td style="font-weight: bold; font-size: 14px;"
	 > <%=result1%></td>
<% }
					       }else{ %>
<td  >-</td>
<% } 
		    		} else { 
		    		   if(dgDetail.getResult() != null){ %>
<td  ><%=dgDetail.getResult()%></td>
<%}else {%>
<td  >-</td>
<% }  %>
<%}
				}catch(Exception exception){ %>
<td  > <%=dgDetail.getResult() %></td>
<% } %>
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
<td  ><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %>
<td  >-</td>
<%}}else{ %>
<td  >-</td>
<% } %>
<% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<td  ><%=dgDetail.getRemarks()%></td>
<% } else { %>
<td  >-</td>
<% } %>
<%
				}
					}
						}
				}
				} %>
<!--  when result type TEXT AREA and comaprison type NORMAL VALUE and condition fEmale -->

<!--  when result type is TEXT AREA and comparison type is NORMAL VALUE  -->
<!--  condition none  -->
<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%>
<td  ><%=i %>)</td>
<%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td  >-</td>
<%} %>
<%try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null 
		    			&& dgDetail.getNormal().getMaxNormalValue() != null){
		    		if(dgDetail.getResult() != null 
		    				&& !dgDetail.getResult().equals("")){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
<td  > <%=result1%></td>
<% }else{ %>
<td style="font-weight: bold; font-size: 14px;"
	 > <%=result1%></td>
<% }
					       }else{ %>
<td  >-</td>
<% } 
		    		} else { 
		    		   if(dgDetail.getResult() != null){ %>
<td  ><%=dgDetail.getResult()%></td>
<%}else {%>
<td  >-</td>
<% }  %>
<%}
				}catch(Exception exception){ %>
<td  > <%=dgDetail.getResult() %></td>
<% } %>
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
<td  ><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %>
<td  >-</td>
<%}}else{ %>
<td  >-</td>
<% } %>
<% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<td  ><%=dgDetail.getRemarks()%></td>
<% } else { %>
<td  >-</td>
<% } %>
<%
				}
					}
						}
				}
				} %>
<!--  when result type is TEXT AREA and comaprison type NORMAL VALUE and condition none -->

<!--  when result type is Range and comparison type is NORMAL VALUE  -->
<!--  condition male  -->
<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	 %>
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("m")){
						%>
<td  ><%=i %>)</td>
<%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td  >-</td>
<%} %>
<%try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null 
		    			&& dgDetail.getNormal().getMaxNormalValue() != null){
		    		if(dgDetail.getResult() != null 
		    				&& !dgDetail.getResult().equals("")){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
<td  > <%=result1%></td>
<% }else{ %>
<td style="font-weight: bold; font-size: 14px;"
	 > <%=result1%></td>
<% }
					       }else{ %>
<td  >-</td>
<% } 
		    		} else { 
		    		   if(dgDetail.getResult() != null){ %>
<td  ><%=dgDetail.getResult()%></td>
<%}else {%>
<td  >-</td>
<% }  %>
<%}
				}catch(Exception exception){ %>
<td  > <%=dgDetail.getResult() %></td>
<% } %>
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
<td  ><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %>
<td  >-</td>
<%}}else{ %>
<td  >-</td>
<% } %>
<% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<td  ><%=dgDetail.getRemarks()%></td>
<% } else { %>
<td  >-</td>
<% } %>
<%
				}
					}
						}
				}
				} %>
<!--  when result type is Range and comaprison type NORMAL VALUE and condition male -->

<!--  when result type is RANGE and comparison type is NORMAL VALUE  -->
<!--  condition Female  -->
<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	 %>
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("f")){
							%>
<td  ><%=i %>)</td>
<%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td  >-</td>
<%} %>
<%try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null 
		    			&& dgDetail.getNormal().getMaxNormalValue() != null){
		    		if(dgDetail.getResult() != null 
		    				&& !dgDetail.getResult().equals("")){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
<td  > <%=result1%></td>
<% }else{ %>
<td
	 > <%=result1%></td>
<% }
					       }else{ %>
<td  >-</td>
<% } 
		    		} else { 
		    		   if(dgDetail.getResult() != null){ %>
<td  ><%=dgDetail.getResult()%></td>
<%}else {%>
<td  >-</td>
<% }  %>
<%}
				}catch(Exception exception){ %>
<td  > <%=dgDetail.getResult() %></td>
<% } %>
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
<td  ><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %>
<td  >-</td>
<%}}else{ %>
<td  >-</td>
<% } %>
<% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<td  ><%=dgDetail.getRemarks()%></td>
<% } else { %>
<td  >-</td>
<% } %>
<%
				}
					}
						}
				}
				} %>
<!--  when result type RANGE and comaprison type NORMAL VALUE and condition fEmale -->

<!--  when result type is RANGE and comparison type is NORMAL VALUE  -->
<!--  condition none  -->
<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeaderForReport.getPatient().getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%>
<td  ><%=i %>)</td>
<%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td  >-</td>
<%} %>
<%try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null 
		    			&& dgDetail.getNormal().getMaxNormalValue() != null){
		    		if(dgDetail.getResult() != null 
		    				&& !dgDetail.getResult().equals("")){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
<td  > <%=result1%></td>
<% }else{ %>
<td style="font-weight: bold; font-size: 14px;"
	 > <%=result1%></td>
<% }
					       }else{ %>
<td  >-</td>
<% } 
		    		} else { 
		    		   if(dgDetail.getResult() != null){ %>
<td  ><%=dgDetail.getResult()%></td>
<%}else {%>
<td  >-</td>
<% }  %>
<%}
				}catch(Exception exception){ %>
<td  > <%=dgDetail.getResult() %></td>
<% } %>
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
<td  ><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %>
<td  >-</td>
<%}}else{ %>
<td  >-</td>
<% } %>
<% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<td  ><%=dgDetail.getRemarks()%></td>
<% } else { %>
<td  >-</td>
<% } %>
<%
				}
					}
						}
				}
				} %>
<!--  when result type is RANGE and comaprison type NORMAL VALUE and condition none -->

<!--  when result type is HEADING and comparison type is NONE -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("h") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>

<td  ><%=i %>)</td>

<%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td  >-</td>
<%} %>
<td  >-</td>

<td  >-</td>

<td>-</td>

<%} %>
<!--  end when result type is HEADING and comparison type is NONE  -->
<!--  when result type is HEADING and comparison type is FIXED VALUE -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("h") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>

<td  ><%=i %>)</td>

<%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td  >-</td>
<%} %>
<td  >-</td>
<td  >-</td>
<td>-</td>
<td>-</td>
<%} %>
<!--  end when result type is HEADING and comparison type is FIXED VALUE -->
<!--  when result type is HEADING and comparison type is NORMAL VALUE  -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("h") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){ %>

<td  ><%=i %>)</td>

<%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td  >-</td>
<%} %>
<td  >-</td>
<td  >-</td>
<td>-</td>
<%} %>
<!--  end of when result type is HEADING and comparison type is NORMAL VALUE  -->
<!--  when result type is SINGLE PARAMETER and COMPARISON TYPE is NONE  -->
<%if((dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n"))){ %>

<td  ><%=i %>)</td>
<%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td  >-</td>
<%} %>
<%try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null 
		    			&& dgDetail.getNormal().getMaxNormalValue() != null){
		    		if(dgDetail.getResult() != null 
		    				&& !dgDetail.getResult().equals("")){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
<td  > <%=result1%></td>
<% }else{ %>
<td style="font-weight: bold; font-size: 14px;"
	 > <%=result1%></td>
<% }
					       }else{ %>
<td  >-</td>
<% } 
		    		} else { 
		    		   if(dgDetail.getResult() != null){ %>
<td  ><%=dgDetail.getResult()%></td>
<%}else {%>
<td  >-</td>
<% }  %>
<%}
				}catch(Exception exception){ %>
<td  > <%=dgDetail.getResult() %></td>
<% } %>
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
<td  ><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %>
<td  >-</td>
<%}}else{ %>
<td  >-</td>
<% } %>
<% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<td  ><%=dgDetail.getRemarks()%></td>
<% } else { %>
<td  >-</td>
<% } %>
<%} %>
<!--  end when result type is SINGLE PARAMETER and COMAPRISON TYPE is NONE -->

<!--  when result type is SINGLE PARAMAETER and comparison type is FIXED VALUE  -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>
<td  ><%=i %>)</td>
<%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td  >-</td>
<%} %>
<%try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null 
		    			&& dgDetail.getNormal().getMaxNormalValue() != null){
		    		if(dgDetail.getResult() != null 
		    				&& !dgDetail.getResult().equals("")){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
<td  > <%=result1%></td>
<% }else{ %>
<td style="font-weight: bold; font-size: 14px;"
	 > <%=result1%></td>
<% }
					       }else{ %>
<td  >-</td>
<% } 
		    		} else { 
		    		   if(dgDetail.getResult() != null){ %>
<td  ><%=dgDetail.getResult()%></td>
<%}else {%>
<td  >-</td>
<% }  %>
<%}
				}catch(Exception exception){ %>
<td  > <%=dgDetail.getResult() %></td>
<% } %>
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
<td  ><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %>
<td  >-</td>
<%}}else{ %>
<td  >-</td>
<% } %>
<% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<td  ><%=dgDetail.getRemarks()%></td>
<% } else { %>
<td  >-</td>
<% } %>
<%} %>
<!-- end of when result type is SINGLE PARAMAETER and comparison type is FIXED VALUE -->
<!--  when result type is MULTIPLE PARAMETER and comparison type is NONE  -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>
<td  ><%=i %>)</td>
<%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td  >-</td>
<%} %>
<%try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null 
		    			&& dgDetail.getNormal().getMaxNormalValue() != null){
		    		if(dgDetail.getResult() != null 
		    				&& !dgDetail.getResult().equals("")){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
<td  > <%=result1%></td>
<% }else{ %>
<td style="font-weight: bold; font-size: 14px;"
	 > <%=result1%></td>
<% }
					       }else{ %>
<td  >-</td>
<% } 
		    		} else { 
		    		   if(dgDetail.getResult() != null){ %>
<td  ><%=dgDetail.getResult()%></td>
<%}else {%>
<td  >-</td>
<% }  %>
<%}
				}catch(Exception exception){ %>
<td  > <%=dgDetail.getResult() %></td>
<% } %>
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
<td  ><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %>
<td  >-</td>
<%}}else{ %>
<td  >-</td>
<% } %>
<% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<td  ><%=dgDetail.getRemarks()%></td>
<% } else { %>
<td  >-</td>
<% } %>
<%} %>
<!--  when result type is MULTIPLE PARAMETER and comparison type is NONE   -->
<!--  when result type is MULTIPLE PARAMETER and Comparison type is FIXED VALUE  -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f") ){ %>
<td  ><%=i %>)</td>
<%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td  >-</td>
<%} %>
<%try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null 
		    			&& dgDetail.getNormal().getMaxNormalValue() != null){
		    		if(dgDetail.getResult() != null 
		    				&& !dgDetail.getResult().equals("")){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
<td  > <%=result1%></td>
<% }else{ %>
<td style="font-weight: bold; font-size: 14px;"
	 > <%=result1%></td>
<% }
					       }else{ %>
<td  >-</td>
<% } 
		    		} else { 
		    		   if(dgDetail.getResult() != null){ %>
<td  ><%=dgDetail.getResult()%></td>
<%}else {%>
<td  >-</td>
<% }  %>
<%}
				}catch(Exception exception){ %>
<td  > <%=dgDetail.getResult() %></td>
<% } %>
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
<td  ><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %>
<td  >-</td>
<%}}else{ %>
<td  >-</td>
<% } %>
<% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<td  ><%=dgDetail.getRemarks()%></td>
<% } else { %>
<td  >-</td>
<% } %>
<%} %>
<!-- end when result type is MULTIPLE PARAMETER and Comparison type is FIXED VALUE  -->

<!--  when result type is TEXT AREA and comparison type is NONE -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>
<td  ><%=i %>)</td>
<%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td  >-</td>
<%} %>
<%try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null 
		    			&& dgDetail.getNormal().getMaxNormalValue() != null){
		    		if(dgDetail.getResult() != null 
		    				&& !dgDetail.getResult().equals("")){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
<td  > <%=result1%></td>
<% }else{ %>
<td style="font-weight: bold; font-size: 14px;"
	 > <%=result1%></td>
<% }
					       }else{ %>
<td  >-</td>
<% } 
		    		} else { 
		    		   if(dgDetail.getResult() != null){ %>
<td  ><%=dgDetail.getResult()%></td>
<%}else {%>
<td  >-</td>
<% }  %>
<%}
				}catch(Exception exception){ %>
<td  > <%=dgDetail.getResult() %></td>
<% } %>
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
<td  ><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %>
<td  >-</td>
<%}}else{ %>
<td  >-</td>
<% } %>
<% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<td  ><%=dgDetail.getRemarks()%></td>
<% } else { %>
<td  >-</td>
<% } %>
<%} %>
<!-- end when result type is TEXT AREA and comparison type is NONE -->

<!--  when result type is TEXT AREA and comparison type is FIXED VALUE -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>

<td  ><%=i %>)</td>
<%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td  >-</td>
<%} %>
<%if(dgDetail.getFixed() != null){ %>
<td class="value"
	 ><%=dgDetail.getFixed().getFixedValue() %></td>
<%}%>


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
<td  ><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %>
<td  >-</td>
<%}}else{ %>
<td  >-</td>
<% } %>
<% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<td  ><%=dgDetail.getRemarks()%></td>
<% } else { %>
<td  >-</td>
<% } %>
<div class="Clear"></div>
<%} %>
<!-- end  when result type is TEXT AREA and comparison type is FIXED VALUE -->
<!--  when result type is Range and comparison type is NONE -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>
<td  ><%=i %>)</td>
<%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td  >-</td>
<%} %>
<%try{
		    	if(dgDetail.getNormal() != null && dgDetail.getNormal().getMinNormalValue() != null 
		    			&& dgDetail.getNormal().getMaxNormalValue() != null){
		    		if(dgDetail.getResult() != null 
		    				&& !dgDetail.getResult().equals("")){
				    		Float minValue = Float.parseFloat(dgDetail.getNormal().getMinNormalValue());
				    		Float maxValue = Float.parseFloat(dgDetail.getNormal().getMaxNormalValue());
				    			Float result1   = Float.parseFloat(dgDetail.getResult());
					    		String result = new DecimalFormat("0.##").format((double)result1);
					    		if(result1 <= maxValue && result1 >= minValue ){ %>
<td  > <%=result1%></td>
<% }else{ %>
<td style="font-weight: bold; font-size: 14px;"
	 > <%=result1%></td>
<% }
					       }else{ %>
<td  >-</td>
<% } 
		    		} else { 
		    		   if(dgDetail.getResult() != null){ %>
<td  ><%=dgDetail.getResult()%></td>
<%}else {%>
<td  >-</td>
<% }  %>
<%}
				}catch(Exception exception){ %>
<td  > <%=dgDetail.getResult() %></td>
<% } %>
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
<td  ><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %>
<td  >-</td>
<%}}else{ %>
<td  >-</td>
<% } %>
<% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<td  ><%=dgDetail.getRemarks()%></td>
<% } else { %>
<td  >-</td>
<% } %>

<%} %>

<!-- when result type is RANGE and comparison type is FIXED VALUE  -->
<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>

<td  ><%=i %>)</td>
<%if(dgDetail.getSubInvestigation() !=null){ %>
<td  ><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></td>
<%}else { %>
<td  >-</td>
<%} %>
<%if(dgDetail.getFixed() != null){ %>
<td class="value"
	 ><%=dgDetail.getFixed().getFixedValue() %></td>
<%}%>


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
<td  ><%= dgDetail.getNormal().getNormalValue()%></td>
<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
<td  ><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%></td>
<%}}else{ %>
<td  >-</td>
<%}}else{ %>
<td  >-</td>
<% } %>
<% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<td  ><%=dgDetail.getRemarks()%></td>
<% } else { %>
<td  >-</td>
<% } %>
<%}
    	%>
</tr>
<%} %>
</table>
</div>
<div class="Clear"></div>