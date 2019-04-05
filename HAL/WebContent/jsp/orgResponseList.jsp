
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.DgMasOrganism"%>
<%@page import="jkt.hms.masters.business.DgMasOrganismGroup"%>

<%@page import="jkt.hms.masters.business.DgOrgGrpDtl"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<DgMasOrganismGroup> organismGroupList = new ArrayList<DgMasOrganismGroup>();
	List<DgMasOrganism> organismList = new ArrayList<DgMasOrganism>();
	List<DgOrgGrpDtl> organismGroupDetailList  = new ArrayList<DgOrgGrpDtl>();
	
	organismList = (ArrayList)map.get("organismList");
	organismGroupList = (ArrayList)map.get("organismGroupList");
	Integer organismGroupId = 0;
	
	if(map.get("organismGroupDetailList") != null){
		organismGroupDetailList = (List)map.get("organismGroupDetailList");		
	}
	if(map.get("organismGroupId") != null && !map.get("organismGroupId").equals("")){
		organismGroupId = Integer.parseInt((String)map.get("organismGroupId"));		
	}

	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
%>

		<div class="tableHholderCmn">
		<table id="organismGrid" colspan="7" id="chargeDetails"  cellpadding="0" cellspacing="0">
			<thead>
				<tr > 
					<th >SR No.</th>
					<th width="95%">Organism</th>
				</tr>
			</thead>
			<tbody>
 		<%
    int inc = 1;
 	for(DgOrgGrpDtl dgOrgGrpDtl : organismGroupDetailList){ %>	
 					<tr> 
					<td width="5%">
						<input type="text" size="2"	value="<%=inc%>" id="<%=SR_NO%><%=inc%>" name="<%=SR_NO%>" readonly="readonly" />
					</td>
					<td width="95%">
						<input type="text" size="180"  name="<%=ORGANISM_NAME%><%=inc%>"  
							tabindex="1" id="<%=ORGANISM_NAME%><%=inc%>" 
							value="<%=dgOrgGrpDtl.getOrganism().getOrganismName()%>[<%=dgOrgGrpDtl.getOrganism().getId()%>]"
							onblur="checkForOrganism(this.value, '<%=inc %>');" />
						<div id="ac2update" style="display:none;"></div>
						
						<script type="text/javascript" language="javascript" charset="utf-8">
				    		new Ajax.Autocompleter(document.getElementById('<%=ORGANISM_NAME%><%=inc%>'),'ac2update','laboratory?method=getOrganismListAutoComplete',{parameters:'requiredField=<%=ORGANISM_NAME%><%=inc%>'});
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
						<input type="text" name="<%=ORGANISM_NAME%><%=inc%>"  tabindex="1" id="<%=ORGANISM_NAME%><%=inc%>" size="180" onblur="checkForOrganism(this.value, '<%=inc %>');" />
						<div id="ac2update" style="display:none;"></div>
						<script type="text/javascript" language="javascript" charset="utf-8">
				    		new Ajax.Autocompleter(document.getElementById('<%=ORGANISM_NAME%><%=inc%>'),'ac2update','laboratory?method=getOrganismListAutoComplete',{parameters:'requiredField=<%=ORGANISM_NAME%><%=inc%>'});
	    				</script>		  
	    			</td>
				</tr>
						<script  type="text/javascript">
							document.getElementById('<%=ORGANISM_NAME%>'+<%=inc%>).value='';
						</script>
		<%} 
    	int lastIndex = inc;  %>
 	<input type="hidden" value="<%=lastIndex%>" name="lastIndex" id="lastIndex" />     
	<input type="hidden" name="totalRowsCount" value="<%=lastIndex-1%>" id="totalRowsCount"/>
	
	</tbody>

</table>
<div class="Clear"></div>
<input type="button" tabindex="1"  class="button"  	alt="Add" onclick="addRow();" value="Add Row" align="right" />
<div class="Clear"></div>
</div>
