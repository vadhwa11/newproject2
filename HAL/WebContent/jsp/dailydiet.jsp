<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDiet"%>
<%@page import="jkt.hms.masters.business.MasDietType"%>
<%@page import="jkt.hms.masters.business.MasDietIndentItem"%>
<%@page import="jkt.hms.masters.business.DietExtraItemFormula"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.math.BigInteger"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDietCombination"%>
<%@page import="jkt.hms.masters.business.DietDailyGeneralSummary"%>
<%@page import="jkt.hms.masters.business.DietDailySummary"%>
<!--Main div starts-->
<div  id="contentHolder">
<form name="dailyDiet" method="post" action="">

<%
	Map<String, Object> map = new HashMap<String, Object>();
	
	List<DietDailyGeneralSummary> dailyDietSummaryList = new ArrayList<DietDailyGeneralSummary>();
	List<MasDiet> dietList = new ArrayList<MasDiet>();
	List<MasDietType> dietTypeList = new ArrayList<MasDietType>();
	List<MasDietIndentItem> indentItemList = new ArrayList<MasDietIndentItem>();
	List<Object[]> totalOffList = new ArrayList<Object[]>();
	List<Object[]> totalOthList = new ArrayList<Object[]>();
	List<MasDiet> dietForGenList = new ArrayList<MasDiet>();
	List<MasDiet> dietForThrList = new ArrayList<MasDiet>();
	List<Object[]> countListForTherapeuticDiet = new ArrayList<Object[]>();
	List<Object[]> prevDaySupplementryDietList = new ArrayList<Object[]>();
	List<Object[]> transferInList = new ArrayList<Object[]>();
	List<Object[]> transferOutList = new ArrayList<Object[]>();
	List<Object[]> dischargeList = new ArrayList<Object[]>();
	List<Object[]> expiryList = new ArrayList<Object[]>();
	List<Object[]> wardWiseInpatientList = new ArrayList<Object[]>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasDietCombination> dietCombinationList = new ArrayList<MasDietCombination>();
	List<Object[]> currentDaySplmntryDietList = new ArrayList<Object[]>();
	List<DietDailySummary> dietDailySummaryList = new ArrayList<DietDailySummary>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	
	String time = (String)utilMap.get("currentTime");	
	
	String deptName="";
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	
	if(map.get("dailyDietSummaryList") != null){
		dailyDietSummaryList = (List<DietDailyGeneralSummary>)map.get("dailyDietSummaryList");
	}
	
	if(map.get("dietList") != null){
		dietList = (List<MasDiet>)map.get("dietList");
	}
	if(map.get("dietTypeList") != null){
		dietTypeList = (List<MasDietType>)map.get("dietTypeList");
	}
	if(map.get("indentItemList") != null){
		indentItemList = (List<MasDietIndentItem>)map.get("indentItemList");
	}
	if(map.get("totalOffList") != null){
		totalOffList = (List)map.get("totalOffList");
	}
	if(map.get("totalOthList") != null){
		totalOthList = (List)map.get("totalOthList");
	}
	if(map.get("countListForTherapeuticDiet") != null){
		countListForTherapeuticDiet = (List<Object[]>)map.get("countListForTherapeuticDiet");
	}
	if(map.get("transferInList") != null){
		transferInList = (List<Object[]>)map.get("transferInList");
	}
	if(map.get("transferOutList") != null){
		transferOutList = (List<Object[]>)map.get("transferOutList");
	}
	if(map.get("dischargeList") != null){
		dischargeList = (List<Object[]>)map.get("dischargeList");
	}
	if(map.get("expiryList") != null){
		expiryList = (List<Object[]>)map.get("expiryList");
	}
	if(map.get("wardWiseInpatientList") != null){
		wardWiseInpatientList = (List<Object[]>)map.get("wardWiseInpatientList");
	}
	if(map.get("employeeList") != null){
		employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	if(map.get("dietCombinationList") != null){
		dietCombinationList = (List<MasDietCombination>)map.get("dietCombinationList");
	}
	if(map.get("dietDailySummaryList") != null){
		dietDailySummaryList = (List<DietDailySummary>)map.get("dietDailySummaryList");
	}
	int moic = 0;
	int lime = 0;
	int duty = 0;
	String otherDiet = "";
	String specialDiet = "";
	
	 if(dietDailySummaryList.size() > 0){
	 	 DietDailySummary dietDailySummary = (DietDailySummary) dietDailySummaryList.get(0);
	 	 moic = dietDailySummary.getMedicalOfficer().getId();
	 	 lime = dietDailySummary.getLimeSugarPatients();
	 	 duty = dietDailySummary.getNightDutyPersons();
	 	otherDiet = dietDailySummary.getOtherDiet();
	 	 specialDiet = dietDailySummary.getSepcialDiet();
	 	 
	 }
	
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.DAY_OF_MONTH, +1);
	Date nextDate = cal.getTime();
	
	for(MasDiet diet : dietList){
		if(diet.getDietCategory().equals("G")){
			dietForGenList.add(diet);		
		}
		if(diet.getDietCategory().equals("T")){
			dietForThrList.add(diet);		
		}
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
%>

<h6>Daily Diet &amp; Extra Requisition</h6>
<div class="Clear"></div>
<input type="button" class="cmnButton"  name="refesh" value="Get Current Data" onclick="submitForm('dailyDiet','diet?method=updateDietDetailsForDailyDiet');"/>
<div class="Clear"></div>
<div class="blockFrame">
<label class="medium">Ward Name:</label>
<label class="value"><%=deptName %></label>

<label class="medium">MO i/c:</label>
<select name="<%=MEDICAL_OFFICER_ID %>" id="moicId" validate="MO i/c,string,no" onchange="populateDoctorName(this.value)">
<option value="0">Select</option>
<%
	for(MasEmployee employee :  employeeList){
		if(employee.getId() == moic){
%>
<option value="<%=employee.getId() %>" selected="selected"><%=employee.getFirstName()+" "+employee.getMiddleName()+" "+employee.getLastName() %></option>
<%}else{ %>
<option value="<%=employee.getId() %>"><%=employee.getFirstName()+" "+employee.getMiddleName()+" "+employee.getLastName() %></option>
<%}} %>
</select>
<input type="hidden" id="medicalOfficerNameId" name="medicalOfficerName" value=""/>
<script type="text/javascript">
function populateDoctorName(val){
<%
	for(MasEmployee employee :  employeeList){
%>
	if(val == <%=employee.getId()%>){
		document.getElementById('medicalOfficerNameId').value= '<%=employee.getFirstName()+" "+employee.getLastName()%>';
	}
	
	<%}%>
}

</script>

<label>Demand Date:</label>
<label class="valueNoWidth"><%=date %></label>
<input type="hidden" name="<%=DEMAND_DATE %>" value="<%=date %>">

<label class="medium">For Date:</label>
<label class="valueNoWidth"><%=HMSUtil.convertDateToStringWithoutTime(nextDate) %></label>
<input type="hidden" name="<%=FOR_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(nextDate) %>">

</div>

<div class="division"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th rowspan="2" scope="col">Diets</th>
    
 <!-----------------------Main loop for display diets---------------------->
    <%
    	for(MasDiet masDiet : dietForGenList){
    		
    %>
    <th colspan="2" scope="col"><%=masDiet.getDietName() %></th>
   
   <%
   }
    	%> 
     <th colspan="2" scope="col">Total</th>
    </tr>
  <tr>
  
  <%
  	for(int i=0; i<=dietForGenList.size() ;i++){
  %>
    <th scope="col">Offrs</th>
    <th scope="col">Ors</th>
    <%} %>
    
  </tr>
  
<!-----------------------Main loop for display diet types---------------------->
  
  <%
  int totalForNDiet = 0;
  		for(int j=0;j< dietTypeList.size();j++){
  			
  			MasDietType dietType = dietTypeList.get(j);
  %>
  
  <tr>
    <td class="colHeader"><%=dietType.getDietTypeName() %> </td>
     
   <%  
   
 //------------------ Display count for differnt diet and diet type and diet category---------------------------
   
 	boolean officerRecordfound=false;
   	boolean otherRecordfound=false;
    int count= 0;
    Integer[] countOffArr=new Integer[dietForGenList.size()];
    Integer[] countOthArr=new Integer[dietForGenList.size()];

    for(int k=0;k<dietForGenList.size();k++){
    	
    	countOffArr[k]=0;
    	countOthArr[k]=0;
    	
    	for(int l=0;l< dailyDietSummaryList.size();l++){	
    		
    		DietDailyGeneralSummary dailyDietSummary = dailyDietSummaryList.get(l);
    		
    		count = dailyDietSummary.getDietCount();
			if(dailyDietSummary.getDietType().equalsIgnoreCase(dietType.getDietTypeName()) && 
					dailyDietSummary.getDietCategory().equals("Officer")
  	 				&& dailyDietSummary.getDietCode().equals(dietForGenList.get(k).getDietCode()))
			{ 
				officerRecordfound=true;
	  	 	 	countOffArr[k]=count;
	  	 	}	
			else if(dailyDietSummary.getDietType().equalsIgnoreCase(dietType.getDietTypeName()) && 
					dailyDietSummary.getDietCategory().equals("Other")
  	 				&& dailyDietSummary.getDietCode().equals(dietForGenList.get(k).getDietCode()))
			 { 
  	 			otherRecordfound=true;
  	 			countOthArr[k]=count;
  	 		}
			
   		}
    	
//------------------ Generate <td> on the basis of count ---------------------------
    	   
     	if(officerRecordfound==false && otherRecordfound == false )
    	{
    
    %>
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
    
   
    <%	}else if(officerRecordfound==true && otherRecordfound==false) {
    			if(countOffArr[k] !=0){
    			%>
    			<td><%=countOffArr[k] %></td>
    			<%}else{ %>
    			<td>&nbsp;</td>
    			<%} %>
    			<td>&nbsp;</td>
    
  		<%}else if(officerRecordfound==false && otherRecordfound==true ){
  			%>
  		   <td>&nbsp;</td>
  		<%   if(countOthArr[k] !=0){
  			%>
  			<td><%=countOthArr[k] %></td>
  			<%}else{ %>
  			<td>&nbsp;</td>
  			<%} %>
  		  
    	<%}else if(officerRecordfound==true && otherRecordfound==true){
    		if(countOffArr[k] != 0){
    %>
   			 <td><%=countOffArr[k] %></td>
   			 <%}else{ %>
   			 <td>&nbsp;</td>
   			 <%} 
    		if(countOthArr[k] != 0){
   			 %>
    			<td><%=countOthArr[k] %></td>
    			<%}else{ %>
    			 <td>&nbsp;</td>
    			<%} %>
    <%
    	}
     	
  	}
    
//------------------ End of loop Diet Type ---------------------------


//------------------ For Displaying row wise total of count ---------------------------
    
 	int offTotalR = 0;
 	int othTotalR = 0;
 	
 	for(int m=0; m<dietForGenList.size(); m++){
 		offTotalR = offTotalR+countOffArr[m];	
 		othTotalR = othTotalR+countOthArr[m];
 	}
 
	if(offTotalR != 0){
 	%>
	<td><%=offTotalR %>	</td>
	<%}else{ %>
	<td>&nbsp;</td>
	<%} 
		if(othTotalR != 0){
	%>
 	<td> <%=othTotalR %>	</td>
 	<%}else{ %>
 	<td>&nbsp;</td>
 <%}
  		}
  %>
  <input type="hidden" name="totalForNDiet" value="<%=totalForNDiet %>" />
 </tr>
 <tr>
 <td class="colHeader">Total</td>
  <%
  
//------------------ For Displaying column wise total of count ---------------------------


  String diet = "";
  BigDecimal sum = new BigDecimal(0);
  int sumNOff = 0;
  int sumNOth = 0;
  
  BigDecimal sumOffArr[] = new BigDecimal[dietForGenList.size()]; 
  BigDecimal sumOthArr[] = new BigDecimal[dietForGenList.size()]; 
  
  	for(int n=0; n<dietForGenList.size() ;n++){
  		sumOffArr[n] = 	new BigDecimal(0);
  		sumOthArr[n] = 	new BigDecimal(0);
  		
  		for(Object[] obj : totalOffList){
  			  			
  			sum = (BigDecimal)obj[0];
  			diet = (String)obj[1];
  		
  			if(dietForGenList.get(n).getDietCode().equals(diet)){
  				sumOffArr[n] = sum;
  				if(dietForGenList.get(n).getDietCode().equalsIgnoreCase("N")){
  					sumNOff = Integer.parseInt(sum.toString());
  				}
  				break;
  			}
 		}
  		
  	for(Object[] obj : totalOthList){
  		  			
  			sum = (BigDecimal)obj[0];
  			diet = (String)obj[1];
  			
  			if(dietForGenList.get(n).getDietCode().equals(diet)){
  				sumOthArr[n] = sum;
  				if(dietForGenList.get(n).getDietCode().equalsIgnoreCase("N")){
  					sumNOth = Integer.parseInt(sum.toString());
  				}
  				break;
  			}
  		}
  	
    		
  	}
	
  	totalForNDiet = sumNOff+sumNOth;
  	
  	%>
  <%
  BigDecimal sumOff = new BigDecimal(0);
  BigDecimal sumOth = new BigDecimal(0);
	
  	for(int i=0; i<sumOffArr.length;i++){
  		sumOff = sumOffArr[i].add(sumOff);
  	 	sumOth = sumOthArr[i].add(sumOth);
  	 	
  		%>
  		<td><%=sumOffArr[i] %></td>
  		<td><%=sumOthArr[i] %></td>
  <%		
  	}
  
  %>
  	<td><%= sumOff%></td>
  	<td><%= sumOth%></td>
  	
 </tr>
</table>


</div>
<div class="division"></div>

<div class="blockFrame">
<label>Lime &amp; Sugar for</label>
<input name="<%=LIME_SUGAR_PATIENTS %>" type="text" value="<%=lime %>" class="calDate" maxlength="4"/>
<label class="unit">Patients</label>

<label>   Night Duty</label>
<input name="<%=NIGHT_DUTY_PERSONS %>" type="text" value="<%=duty%>" class="calDate" maxlength="4" />
<label class="unit">Persons</label>

<div class="Clear"></div>

<label>Other Diet</label>
<textarea name="otherDiet" class="textareasmall"  maxlength="50" cols="20" rows="3" tabindex="1"/><%=otherDiet%></textarea>

<label>Special Diet</label>
<textarea name="specialDiet" class="textareasmall"  maxlength="100" cols="30" rows="3" tabindex="1"/><%=specialDiet%></textarea>

<div class="Clear"></div>
<div class="blockTitle">Extras For N Diet</div><div class="blockTitleCurve"></div>
<div class="Clear"></div>

<%
//------------------ For Displaying Extra Items from master---------------------------

int counter = 0;
	for(int n=0; n< indentItemList.size();n++){
		
		MasDietIndentItem indentItem = indentItemList.get(n);
		Set<DietExtraItemFormula> extraItemFormula = new HashSet<DietExtraItemFormula>();
		
	%>
		
		<%
		if(indentItem.getDietExtraItemFormulas() != null){
			if(indentItem.getDietExtraItemFormulas() != null){
			extraItemFormula = indentItem.getDietExtraItemFormulas();
			for(DietExtraItemFormula itemFormula : extraItemFormula){
				if(itemFormula.getStatus().equals("y")){
					if(itemFormula.getUnit() != null){
						
		%>
		
		<label class="medium"><%=indentItem.getIndentItemName() %></label>
		<input type="hidden" name="<%= INDENT_ID %>" value="<%=indentItem.getId() %>" /> 
		<input id="extraScaleId<%=counter %>" name="<%=EXTRA_SCALE %>" type="text" value="" class="calDate" maxlength="9"/>
		<label class="unit"><%=itemFormula.getUnit().getUnitName() %></label>
		<input type="hidden" name="<%= UNIT_ID %>" value="<%=itemFormula.getUnit().getId() %>" /> 
		
		<script type="text/javascript">
			var totalForND = '<%=totalForNDiet%>';
			var extraScale = '<%=itemFormula.getExtraScale() %>';
		
			var totalExtraScale = totalForND*extraScale;
			document.getElementById('extraScaleId<%=counter%>').value = totalExtraScale;
					
		</script>
	
	<%}
			}
				}
				
			}
	
			}
		counter++;
	}
%>

</div>

<div class="division"></div>
<h5>Supplementary Diets</h5>
<div class="Clear"></div>
<div class="Height10"></div>
<div class="tableHolderAuto" >
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <%
	if(map.get("prevDaySupplementryDietList") != null){
		prevDaySupplementryDietList = (List<Object[]>)map.get("prevDaySupplementryDietList");
	}
        if(map.get("currentDaySplmntryDietList") != null){
    		currentDaySplmntryDietList = (List<Object[]>)map.get("currentDaySplmntryDietList");
    	}

	Calendar calendar = Calendar.getInstance();
	calendar.add(Calendar.DAY_OF_MONTH, -1);
	Date prevDate = calendar.getTime();
%>
        <tr> 
          <td width="26%" class="colHeader">Date</td>
          <td colspan="4" class="colHeader"><%=HMSUtil.convertDateToStringWithoutTime(prevDate) %></td>
          <td colspan="4" class="colHeader"><%=date %></td>
        </tr>
        <tr> 
          <td class="colHeader">Diet </td>
          <td colspan="2" scope="col" class="colHeader" >Officer</td>
          <td width="22%" colspan="2" scope="col" class="colHeader" >Other</td>
          <td width="12%" colspan="2" scope="col" class="colHeader" >Officer</td>
          <td width="23%" colspan="2" scope="col" class="colHeader" >Other</td>
        </tr>
         
  <%
  	Integer[] prevSplmtryOffCount = new Integer[dietCombinationList.size()];
  	Integer[] prevSplmtryOthCount = new Integer[dietCombinationList.size()];
  	Integer[] currentSplmtryOffCount = new Integer[dietCombinationList.size()];
  	Integer[] currentSplmtryOthCount = new Integer[dietCombinationList.size()];
	int prevOffTotal = 0;
	int prevOthTotal = 0;
	int currentOffTotal = 0;
	int currentOthTotal = 0;
	  	
  	for(int i=0; i<dietCombinationList.size(); i++){
  		
  		MasDietCombination dietObj = (MasDietCombination)dietCombinationList.get(i);
  		
  		prevSplmtryOffCount[i] = 0;
  		prevSplmtryOthCount[i] = 0;
  		currentSplmtryOffCount[i] = 0;
  		currentSplmtryOthCount[i] = 0;
  		
  		if(dietObj.getDemandDisplay().equals("n")){
  			for(Object[] obj : prevDaySupplementryDietList){
  	  			Integer count = Integer.parseInt(obj[0].toString());
  	  			int dietId = (Integer)obj[1];
  	  			String dietType = (String)obj[2];
  	  			String dietCategory = (String)obj[3];
  	  			
  	  			if(dietObj.getDiet().getId() == dietId 
  	  				&& dietObj.getDietType().getDietTypeName().equalsIgnoreCase(dietType)
  	  					&& dietCategory.equals("Officer")){
  	  					prevSplmtryOffCount[i] = count;
  	  					prevOffTotal = prevOffTotal+count;
  	  			}
  	  			if(dietObj.getDiet().getId() == dietId 
  	  				&& dietObj.getDietType().getDietTypeName().equalsIgnoreCase(dietType)
  	  					&& dietCategory.equals("Other")){
  	  					prevSplmtryOthCount[i] = count;
  	  					prevOthTotal = prevOthTotal+count;
  	  			}
  			}
  			
  			for(Object[] obj : currentDaySplmntryDietList){
  	  			Integer count = Integer.parseInt(obj[0].toString());
  	  			int dietId = (Integer)obj[1];
  	  			int dietType = (Integer)obj[2];
  	  			String dietCategory = (String)obj[3];
  	  			
  	  			if(dietObj.getDiet().getId() == dietId 
  	  				&& dietObj.getDietType().getId()==dietType
  	  					&& dietCategory.equals("Officer")){
  	  					currentSplmtryOffCount[i] = count;
  	  				currentOffTotal = currentOffTotal+count;
  	  			}
  	  			if(dietObj.getDiet().getId() == dietId 
  	  				&& dietObj.getDietType().getId()==dietType
  	  					&& dietCategory.equals("Other")){
  	  					currentSplmtryOthCount[i] = count;
  	  					currentOthTotal = currentOthTotal+count;
  	  			}
  			}
  		}
  		
  	}
    boolean flag1 = true;
  	boolean flag2 = true;
  	for(int k=0; k<dietCombinationList.size();k++){
  		
  		MasDietCombination dietObj = (MasDietCombination)dietCombinationList.get(k);
  	
  		if(dietObj.getDemandDisplay().equals("n")){
  			if(prevSplmtryOffCount[k] != 0 || prevSplmtryOthCount[k] != 0 || currentSplmtryOffCount[k] !=0 || currentSplmtryOthCount[k] != 0){
  		%>	
  	<tr> 
       <td class="colHeader"><%=dietObj.getDietCombinationName() %> 
       <input type="hidden" name="<%=DIET_ID %>" value="<%=dietObj.getId() %>">
       </td>
		<%
			if(prevSplmtryOffCount[k] != 0){
		%>
          <td colspan="2" ><%= prevSplmtryOffCount[k] %></td>
        <%}else{ %>
          <td colspan="2" >&nbsp;</td>
         <%} %>
         
         <%
         if(prevSplmtryOthCount[k] != 0){
         %>
          <td colspan="2" ><%=prevSplmtryOthCount[k]%></td>
          <%}else{ %>
            <td colspan="2" >&nbsp;</td>
         <%} %>
        <%
        if(flag1){
			if(currentSplmtryOffCount[k] != 0){
				flag1 = false;
		%>
          <td colspan="2" ><%=prevOffTotal%></td>
        <%}else{ 
               flag1 = false;
           %>
          <td colspan="2" ><%=prevOffTotal%></td>
         <%}}else{ %>
           <td colspan="2" >&nbsp;</td>
         <%} %>
           <%
           if(flag2){
         if(currentSplmtryOthCount[k] != 0){
              flag2 = false;
        	 %>
         <!--
          <td colspan="2" ><%=currentSplmtryOthCount[k]%></td>
          -->
          <td colspan="2" ><%=prevOthTotal%></td>
          <%}else{
        	  flag2 = false;
        	  %>
            <td colspan="2" ><%=prevOthTotal%></td>
         <%}}else{ %>
           <td colspan="2" >&nbsp;</td>
         <%} %> 
        
        </tr>
        <%}
  		}
        }
  		%>
  		<tr>
  		<td class="colHeader">Total</td>
  	  	<td colspan="2" scope="col" ><%=prevOffTotal %></td>
  	    <td colspan="2" scope="col" ><%=prevOthTotal %></td>
  	    <td colspan="2" scope="col" ><%=prevOffTotal %></td>
  	    <td colspan="2" scope="col" ><%=prevOthTotal %></td>
  	  </tr>
      </table>


</div>


<div class="division"></div>
<h5>Therapeutic Diet</h5>
<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th>Diet</th>
    <th>Officers</th>
    <th>Others</th>
    </tr>
  
   <%
   BigInteger countOffT[] = new BigInteger[dietForThrList.size()];
   BigInteger countOthT[] = new BigInteger[dietForThrList.size()];
   boolean offCount = false;
   boolean othCount = false;
   
 //------------------ Therapeutic Diet Loop---------------------------
   
  for(int j=0; j<dietForThrList.size(); j++){
	  MasDiet masDietObj = (MasDiet)dietForThrList.get(j);
	  countOffT[j] = new BigInteger("0");
	  countOthT[j] =  new BigInteger("0");
	 if(masDietObj.getDietCategory().equals("T")){
  %>
  <tr>
    <td class="colHeader"><%= masDietObj.getDietName() %> </td>
    	<%
    	BigInteger count = new BigInteger("0");
    	    String dietCategory = "";
    	    String dietCode = "";
    	   
    		for(Object[] obj : countListForTherapeuticDiet){
    			count = (BigInteger)obj[0];
    			dietCategory = (String)obj[1];
    			dietCode = (String)obj[2];
    			if(masDietObj.getDietCode().equals(dietCode)){
    				if(dietCategory.equals("Officer")){
    					countOffT[j] = count;
    					offCount = true;
    				}
    				if(dietCategory.equals("Other")){
    					countOthT[j] = count;
    					othCount = true;
    				}
    			}
    			
    		}
    		
//------------------ Displaying count value for Therapeutic Diet---------------------------
    		
    		if(offCount == true && othCount == true){
    	%>
    	<td><%=countOffT[j] %></td>
  		<td><%=countOthT[j] %></td>
  		<%}
    		if(offCount == true && othCount == false){
    		
    		%>
    		<td><%=countOffT[j] %></td>
  			<td>&nbsp;</td>
  			<%}
    		if(offCount == false && othCount == true){
    		%>
    		<td>&nbsp;</td>
  		<td><%=countOthT[j] %></td>
    <%} 	
    if(offCount == false && othCount == false){
		%>
		<td>&nbsp;</td>
	<td>&nbsp;</td>
<%} 

	 }
    }%>
 
</table>


</div>
<div class="division"></div>

<div class="blockFrame">
<label class="large">Bed State</label>
<%
	
	String dietCategory = "";
	
%>
<div class="paddLeft25"><label>Officers</label></div>
<label>Others</label>

<div class="Clear"></div>
<label class="large">Transfer In</label>
<label class="medium"></label>
<%
for(Object[] object : transferInList){
	BigInteger count = new BigInteger("0");
	count = (BigInteger)object[0];
	dietCategory = (String)object[1];

	if(dietCategory != null && dietCategory.equals("Officer")){
%>
<label class="value"><%=count %></label>
<input type="hidden" name="<%=TRANSFER_IN_OFF %>" value="<%=count %>">
<%}else if(dietCategory != null && dietCategory.equals("Other")){%>
 <label class="value"><%=count %></label>
<input type="hidden" name="<%=TRANSFER_IN_OTH %>" value="<%=count %>">
<%} else{%>
<label class="value"></label>
<%}
}%>
<div class="Clear"></div>

<label class="large">Transfer Out</label>
<label class="medium"></label>
<%
for(Object[] object : transferOutList){
	BigInteger count = new BigInteger("0");
	count = (BigInteger)object[0];
	dietCategory = (String)object[1];

	if(dietCategory != null && dietCategory.equals("Officer")){
%>
<label class="value"><%=count %></label>
<input type="hidden" name="<%=TRANSFER_OUT_OFF %>" value="<%=count %>">
<%}else if(dietCategory != null && dietCategory.equals("Other")){
	%>
 <label class="value"><%=count %></label>
<input type="hidden" name="<%=TRANSFER_OUT_OTH %>" value="<%=count %>">

<%} else{
%>
<label class="value"></label>
<%}
}%>

<div class="Clear"></div>

<label class="large">Discharge</label>
<label class="medium"></label>
<%
for(Object[] object : dischargeList){
	BigInteger count = new BigInteger("0");
	count = (BigInteger)object[0];
	dietCategory = (String)object[1];

	if(dietCategory != null && dietCategory.equals("Officer")){
%>
<label class="value"><%=count %></label>
<input type="hidden" name="<%=DISCHARGE_OFF %>" value="<%=count %>">
<%}else if(dietCategory != null && dietCategory.equals("Other")){%>
 <label class="value"><%=count %></label>
<input type="hidden" name="<%=DISCHARGE_OTH %>" value="<%=count %>">
<%} else{%>
<label class="value"></label>
<%}
}%>

<div class="Clear"></div>

<label class="large">Death</label>
<label class="medium"></label>
<%
for(Object[] object : expiryList){
	BigInteger count = new BigInteger("0");
	count = (BigInteger)object[0];
	dietCategory = (String)object[1];

	if(dietCategory != null && dietCategory.equals("Officer")){
%>
<label class="value"><%=count %></label>
<input type="hidden" name="<%=DEATH_OFF %>" value="<%=count %>">
<%}else if(dietCategory != null && dietCategory.equals("Other")){%>
 <label class="value"><%=count %></label>
<input type="hidden" name="<%=DEATH_OTH %>" value="<%=count %>">
<%} else{%>
<label class="value"></label>
<%}
}%>
<div class="Clear"></div>

<label class="large">Remaining</label>
<label class="medium"></label>
<%
BigInteger totalPatient = new BigInteger("0");

for(Object[] object : wardWiseInpatientList){
	BigInteger count = new BigInteger("0");
	count = (BigInteger)object[0];
	dietCategory = (String)object[1];
	if(dietCategory != null && dietCategory.equals("Officer")){
%>
<label class="value"><%=count %></label>
<input type="hidden" name="<%=REMAIN_OFF %>" value="<%=count %>">
<%}else if(dietCategory != null && dietCategory.equals("Other")){%>
<label class="value"><%=count %></label>
<input type="hidden" name="<%=REMAIN_OTH %>" value="<%=count %>">
<%} else{%>
<label class="value"></label>
<%}
	
	totalPatient = totalPatient.add(count);
}%>
<div class="Clear"></div>

<label class="large">Total Patient </label>
<label class="medium"></label>
<label class="value"><%=totalPatient%></label>
<input type="hidden" name="<%=TOTAL_PATIENT %>" value="<%=totalPatient %>">
<div class="Clear"></div>

</div>

<div class="division"></div>

<div class="bottom">
<input type="button" class="button"  name="Submit" value="Save" onclick="submitForm('dailyDiet','diet?method=saveDailyDietDetails','checkMoIc');"/>
<input type="reset" class="button" name="reset" value="Reset" /> 
<div class="Clear"></div>
<label>Changed By</label>
<label class="value"><%=userName%></label>

<label>Changed Date </label>
<label class="value"><%=date%></label>

<label>Changed time </label>
<label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />
</div>

<div class="Height10"></div>
<!--main div ends-->

<script type="text/javascript">
function checkMoIc(){
	var moic = document.getElementById('moicId').value;
	if(moic == "0"){
		alert("MO i/c can not be blank");
		return false;
	}
	return true;
}


</script>
</form>
</div>
