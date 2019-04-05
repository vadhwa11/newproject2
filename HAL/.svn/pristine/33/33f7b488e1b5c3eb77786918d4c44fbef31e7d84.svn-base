<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.CODE"%>
<%@ page import="static jkt.hms.util.RequestConstants.SEARCH_NAME"%>


<%Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	List<OpdTemplateInvestigation> investigationTemplateList= null;
	List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
	if(map.get("investigationTemplateList") != null){
		investigationTemplateList = (List<OpdTemplateInvestigation>)map.get("investigationTemplateList");
	}
	if(map.get("frequencyList") != null){
		frequencyList = (List)map.get("frequencyList");
	}
	List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
	if(map.get("itemConversionList") != null){
		itemConversionList=(List)map.get("itemConversionList");
		}
	List<Object[]> stockList = new ArrayList<Object[]>();
	if(map.get("stockList") != null){
		stockList=(List<Object[]>)map.get("stockList");
		}
	
	List <MasItemClass> masItemClassList =new ArrayList<MasItemClass>();
    if(map.get("masItemClassList") != null){
    	masItemClassList = (List<MasItemClass>) map.get("masItemClassList");
    			}
    
    int hinId = 0;
    if(map.get("hinId") != null){
    	hinId = (Integer) map.get("hinId");
    }

        int totalRow = 0;
        if(map.get("totalRow") != null){
        	totalRow = (Integer) map.get("totalRow");
    			}
        String itemIdArray[] = {};
        if(map.get("itemIdArray") != null){
        	itemIdArray = (String[]) map.get("itemIdArray");
    			}
        List<Integer> itemIdList= new ArrayList<Integer>();
        for(int i=0; i<itemIdArray.length;i++){
        	if(!itemIdArray[i].isEmpty())
        	itemIdList.add(Integer.parseInt(itemIdArray[i]));}
        
		List<Integer> currentPrescriptionIdList = new ArrayList<Integer>();
        if(map.get("currentPrescriptionIdList") != null){
        	currentPrescriptionIdList = (List<Integer>) map.get("currentPrescriptionIdList");
        			}
	%>

<%@page import="jkt.hms.masters.business.OpdTemplateInvestigation"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>

<%@page import="jkt.hms.masters.business.MasStoreItemConversion"%>
<%@page import="java.math.BigDecimal"%>

	<%
	    int inc1=1;
	     //  Iterator itr=investigationTemplateList.iterator();
	       if(investigationTemplateList!=null&&investigationTemplateList.size()>0)
	       {
	   %>	 
	   <div class="Block">
<label> Template Code </label>
 <input type="text"	name="<%= CODE%>" id="code" value="<%=investigationTemplateList.get(0).getTemplate()!=null?investigationTemplateList.get(0).getTemplate().getTemplateCode():""%>" disabled="true"	readonly="readonly" validate="Template Code,string,yes" MAXLENGTH="8"	tabindex=1 />
 <label><span>*</span> Template Name</label>
 <input type="text" name="<%= SEARCH_NAME %>" id="<%= SEARCH_NAME%>" onblur="createTemplateCode();"  validate="Template Name,string,yes" MAXLENGTH="30" tabindex=1 value="<%=investigationTemplateList.get(0).getTemplate()!=null?investigationTemplateList.get(0).getTemplate().getTemplateName():""%>" />
   <script>
	document.prescriptionTemplate.<%=CODE%>.focus();
</script>
</div>
	   
	  <div class="Block">
<div id="gridview">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
	  	  <td colspan="3" >
	      	<div class="floatleft">
				<input type="radio" value="Lab" class="radioCheckCol2" style="margin-right:5px;"
					name="labradiologyCheck" checked="checked" onchange="" /><div class="labRadiologyDivfixed">LAB</div>			
				<input type="radio" value="Radio" class="radioCheckCol2" style="margin-right:5px;"
					name="labradiologyCheck" onchange="" /><div class="labRadiologyDivfixed">Radiology</div>
					 <input
					type="hidden" name="investigationCategory"
					id="investigationCategory" />
				<div class="clear"></div>
			</div>
			 </td>
	</tr>
	<tr>
		<th scope="col">Investigation </th>
		<!-- <th scope="col">Refer to MH</th> -->
		<th scope="col">Add</th>
		<th scope="col">Delete</th>
	</tr>

		
	<%int inc=1;
			String investigationName = "";
		
		for (OpdTemplateInvestigation patientInvestigation : investigationTemplateList) {
			investigationName = patientInvestigation
					.getChargeCode().getChargeCodeName()
					+ "["
					+ patientInvestigation.getChargeCode().getId()
					+ "]";
		
		
		%> 
		<tr>
		<td>	<input type="hidden" tabindex="1" id="templateInvesId<%=inc%>" name="templateInvesId<%=inc%>" value="<%=patientInvestigation.getId()%>"
			size="10" readonly /> 
		<input type="text" value="<%=investigationName %>" tabindex="1" 
			id="chargeCodeName<%=inc %>" size="100" name="chargeCodeName<%=inc %>" readonly="readonly"/>
			
 <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty1"
						size="10" maxlength="6" validate="Qty,num,no" />  <input
			type="hidden" tabindex="1" id="chargeCode<%=inc %>" name="chargeCode<%=inc %>"
			size="10" readonly /> 
			
			<!-- 	<input type="text"  name="chargeCodeId" id="chargeCodeId" value=""/> -->

		</td>
<%-- 		<%if(patientInvestigation.getReferToMh().equals("") && patientInvestigation.getReferToMh().equals("y") ){ %>
		<td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio" checked="checked" validate="Refer to MH,string,no" /></td>
		<%}else{ %>
		<td><input type="checkbox" name="referToMh<%=inc %>" tabindex="1" id="referToMhId<%=inc%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td>
		<%} %> --%>
			<td><input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRowForInvestigation();" /></td>
		<td>
		
		  <input type="button" name="delete" value="" class="buttonDel" tabindex="1" onclick="removeRow('investigationGrid','hiddenValue',this);" />
		
	
	    </td>


	</tr>
	<%inc++;}
		%>
		</table>
			<input type="hidden" value="<%=inc-1 %>" name="hiddenValue" id="hiddenValue" />
			
	<input type="button" name="add" id="addbutton" value="Save"	class="button" onClick="submitWindow();" accesskey="a" tabindex=1 />
	<input type="button" name="add" id="addbutton" value="Delete Template"	class="button" onClick="deleteTemplate();" accesskey="a" tabindex=1 />
	<input	type="reset" name="Reset" id="reset" value="Close" class="button"	onclick="closeWindow();" accesskey="r" />
		<%}%>
	</div>
	</div>
	


