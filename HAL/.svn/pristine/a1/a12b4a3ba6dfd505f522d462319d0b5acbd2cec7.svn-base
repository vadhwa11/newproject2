<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	//Set<OpdTemplateInvestigation>investigationTemplateSet = new HashSet<OpdTemplateInvestigation>();
	Set<MasChargeCode> masChargeCodeSet = new HashSet<MasChargeCode>();
	if(map.get("masChargeCodeSet") != null){
		masChargeCodeSet = (Set)map.get("masChargeCodeSet");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String consultationDate = (String)utilMap.get("currentDate");
	//System.out.println("masChargeCodeSet==="+masChargeCodeSet.size());
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
        
        int totalRow = 0;
        if(map.get("totalRow") != null){
        	totalRow = (Integer) map.get("totalRow");
    			}
	%>

<%@page import="jkt.hms.masters.business.OpdTemplateTreatment"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.OpdTemplateInvestigation"%>


<%@page import="jkt.hms.masters.business.MasChargeCode"%>
	




	<%
	     
    int i=totalRow;
	if(masChargeCodeSet!= null && masChargeCodeSet.size()>0)
	    {
	  
	  
	      for(MasChargeCode masChargeCode:masChargeCodeSet){
	    	  if(itemIdList.contains(masChargeCode.getId()) || currentPrescriptionIdList.contains(masChargeCode.getId()) )
	                 continue;
	    	  if(masChargeCode.getDgMasInvestigations().iterator().next().getStatus().equalsIgnoreCase("y"))
	    	  {
	    	  System.out.println("chargecode id ="+masChargeCode.getId());
	   
	    %>
	<tr>
		<td><input type="text" name="chargeCodeName<%=i%>"
			id="chargeCodeName<%=i%>" tabindex="1"
			value="<%=masChargeCode.getChargeCodeName()%>[<%=masChargeCode.getId()%>]"
			readonly size="100" />
		<div id="ac2updatey"
			style="display: none; " class="autocomplete"></div>
		<input type="hidden" name="chargeCode<%=i%>" tabindex="1"
			value="<%=masChargeCode.getChargeCodeCode()%>"
			readonly size="10" /> <input type="hidden" name="qty<%=i%>"
			value=""
			tabindex="1" size="10" /></td>
	<%-- <td><input type="text" value="" readonly="readonly"
			readonly="readonly" tabindex="2" id="Result<%=i %>"
			 name="Result<%=i %>" /></td>--%>
		<%-- 	 <td><input type="checkbox" name="referToMh<%=i %>" tabindex="1" id="referToMhId<%=i%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td> --%>

				<td><input  type="text" class="calDate"  id="investigationDate<%=i%>" name="investigationDate<%=i%>" placeholder="DD/MM/YYYY" validate="LMP Date,string,no" value="<%=consultationDate%>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'investigationDate<%=i%>');" maxlength="10" style="width: 120px"/></td>
	<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>

	</tr>
	<%i++;}} %>
	<input type="hidden" name="hiddenValue" value="<%=i %>" id="hiddenValue" />
	<% }else{%>
	<tr>
		<td> <input type="text" value="" tabindex="1"
			id="chargeCodeName1" size="100" name="chargeCodeName1"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=i %>')){checkForChargeCode(this.value,'<%=i %>','chargeCodeVal');}" />
		<div id="ac2updatey" style="display: none;" class="autocomplete">
		</div>
		<!-- <script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
				</script> -->
						<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName1','ac2updatey','opd?method=getInvestigationListForAutoComplete',{minChars:3,
					  callback: function(element, entry) {
				            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
				        },
					  parameters:'requiredField=chargeCodeName1'});
				  
				</script>
				</td>
	<%-- <td><input type="checkbox" name="referToMh<%=i %>" tabindex="1" id="referToMhId<%=i%>" value="y" class="radio"  validate="Refer to MH,string,no" /></td> --%>
	<td><input  type="text" class="calDate"  id="investigationDate<%=i%>" name="investigationDate<%=i%>" placeholder="DD/MM/YYYY" validate="LMP Date,string,no" value="<%=consultationDate%>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'investigationDate<%=i%>');" maxlength="10" style="width: 120px"/></td>
<td><input name="Button" type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /></td>
	<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>
	</tr>
	<input type="hidden" name="hiddenValue" value="<%=i %>" id="hiddenValue" />
	<% }%>



