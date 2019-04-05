<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response Age.
 * @author  Ritu
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.DietMenuItemFormula"%>
<%@page import="java.math.BigInteger"%>
<%@page import="java.math.BigDecimal"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<DietMenuItemFormula> itemQtyList = new ArrayList<DietMenuItemFormula>();
	List<BigInteger> totalBedPatientList = new ArrayList<BigInteger>();
	List<Object[]> eggQtyForBedPatientList = new ArrayList<Object[]>();
	
	int totalMessPatient = 0;
	int totalEggQtyForMess = 0;
	
	if(map.get("itemQtyList") != null){
		itemQtyList = (List<DietMenuItemFormula>)map.get("itemQtyList");
	}
	if(map.get("totalBedPatientList") != null){
		totalBedPatientList = (List<BigInteger>)map.get("totalBedPatientList");
	}
	if(map.get("eggQtyForBedPatientList") != null){
		eggQtyForBedPatientList = (List<Object[]>)map.get("eggQtyForBedPatientList");
	}
	if(map.get("totalMessPatient") != null){
		totalMessPatient = (Integer)map.get("totalMessPatient");
	}
	if(map.get("totalEggQty") != null){
		totalEggQtyForMess = (Integer)map.get("totalEggQty");
	}
	Integer qty = 0;
	Integer bedPatients =0;
	String itemName = "";
	for(DietMenuItemFormula menuItemFormula : itemQtyList){
		itemName = menuItemFormula.getDietItems().getDietItemsName(); 
		qty = menuItemFormula.getQuantity().intValueExact();
		bedPatients = Integer.parseInt(totalBedPatientList.get(0).toString());
		break;
	}
	int patientEggCount = 0;
	int eggQty =0; 
	int totalEggs = 0;
	int totalEggQtyForWard =0;
	for(Object[] obj : eggQtyForBedPatientList){
		patientEggCount =  Integer.parseInt(obj[0].toString());
		eggQty = ((BigDecimal)obj[1]).intValueExact();
		totalEggs = patientEggCount*eggQty;
		totalEggQtyForWard = totalEggQtyForWard+totalEggs;
	}
	
%>

<div class="division"></div>

<div class="Clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>&nbsp;</th>
		<th><%=itemName %></th>
		<th>Eggs</th>
	</tr>

	<tr>
		<td class="colHeader">Mess</td>

		<td><%=qty*totalMessPatient %> <input type="hidden"
			name="messItemQty" value="<%=qty*totalMessPatient %>" /></td>
		<td><%=totalEggQtyForMess %> <input type="hidden"
			name="messEggQty" value="<%=totalEggQtyForMess %>" /></td>
	</tr>

	<tr>
		<td class="colHeader">Ward</td>
		<td><%=qty*bedPatients %> <input type="hidden" name="wardItemQty"
			value="<%=qty*bedPatients %>" /></td>
		<td><%=totalEggQtyForWard %> <input type="hidden"
			name="wardEggQty" value="<%=totalEggQtyForWard %>" /></td>
	</tr>

</table>
</div>
