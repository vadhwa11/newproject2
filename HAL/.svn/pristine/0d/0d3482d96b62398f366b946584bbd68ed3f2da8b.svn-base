<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.DgOrgDtl"%>
<%@page import="jkt.hms.masters.business.MasAntibioticLab"%>
<%@page import="jkt.hms.masters.business.DgMasOrganism"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%
	Map map = new HashMap();
	int organismId = 0;
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<DgOrgDtl> organismDetailList = new ArrayList<DgOrgDtl>();
	List<DgMasOrganism> organismList = new ArrayList<DgMasOrganism>();
	
	organismList = (ArrayList)map.get("organismList");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
	if(map.get("organismId") != null && !map.get("organismId").equals("")){
		organismId = Integer.parseInt((String)map.get("organismId"));		
	}
	if(map.get("organismDetailList") != null && !map.get("organismDetailList").equals("")){
		organismDetailList = (List)map.get("organismDetailList");		
	}
%>
<div class="Clear"></div>
	
		<table 	id="organismGrid" colspan="7" id="chargeDetails"  cellpadding="0" cellspacing="0">
			<thead>
				<tr> 
					<th >SR No.</th>
					<th width="95%">Sensitivity</th>
				</tr>
			</thead>
			<tbody>
 		<%
    int inc = 1;
 		for (DgOrgDtl  dgOrgDtl : organismDetailList){ %>	
 					<tr> 
					<td width="5%">
						<input type="text" size="2"	value="<%=inc%>" id="<%=SR_NO%><%=inc%>" name="<%=SR_NO%>" readonly="readonly" />
					</td>
					<td width="95%">
						<input type="text" align="right" name="<%=ANTIBIOTIC_NAME%><%=inc%>"  
							tabindex="1" id="<%=ANTIBIOTIC_NAME%><%=inc%>" 
							value="<%=dgOrgDtl.getAntibioticLab().getAntibioticLabName()%>[<%=dgOrgDtl.getAntibioticLab().getId()%>]"
							size="180" onblur="checkForOrganism(this.value, '<%=inc %>');" />
						<div id="ac2update" style="display:none;"></div>
						<script type="text/javascript" language="javascript" charset="utf-8">
				    		new Ajax.Autocompleter(document.getElementById('<%=ANTIBIOTIC_NAME%><%=inc%>'),'ac2update','laboratory?method=getSensitivityListAutoComplete',{parameters:'requiredField=<%=ANTIBIOTIC_NAME%><%=inc%>'});
	    				</script>		  
	    			</td>
				</tr>
   <%
   	inc++;
 	}
	 for(;inc<=10;inc++){ %>
				<tr> 
					<td width="5%">
						<input type="text" size="2"	value="<%=inc%>" id="<%=SR_NO%><%=inc%>" name="<%=SR_NO%>" readonly="readonly" />
					</td>
					<td width="95%">
						<input type="text" align="right" name="<%=ANTIBIOTIC_NAME%><%=inc%>"  tabindex="1" id="<%=ANTIBIOTIC_NAME%><%=inc%>" size="180"  onblur="checkForOrganism(this.value, '<%=inc %>');" />
						<div id="ac2update" style=" display:none;"></div>
						<script type="text/javascript" language="javascript" charset="utf-8">
				    		new Ajax.Autocompleter(document.getElementById('<%=ANTIBIOTIC_NAME%><%=inc%>'),'ac2update','laboratory?method=getSensitivityListAutoComplete',{parameters:'requiredField=<%=ANTIBIOTIC_NAME%><%=inc%>'});
	    				</script>		  
	    			</td>
				</tr>
						<script  type="text/javascript">
							document.getElementById('<%=ANTIBIOTIC_NAME%>'+<%=inc%>).value='';
						</script>
		<%} 
    	int lastIndex = inc;  %>
 	<input type="hidden" value="<%=lastIndex%>" name="lastIndex" id="lastIndex" />     
	<input type="hidden" name="totalRowsCount" value="<%=lastIndex-1%>" id="totalRowsCount"/>	
	</tbody>

</table>
<div class="Clear"></div>
<input type="button" tabindex="1" class="button"  alt="Add" onclick="addRow();" value="Add Row" align="right" />
<div class="Clear"></div>
