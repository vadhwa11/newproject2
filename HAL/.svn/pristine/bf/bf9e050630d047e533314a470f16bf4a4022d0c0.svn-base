<%@ page import ="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Patient"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<div class="clear"></div>

<%
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
	map=(Map<String, Object>)request.getAttribute("map");
}
List<Object[]> dependentList = new ArrayList<Object[]>();
if (map.get("dependentList") != null)
	dependentList =(List)map.get("dependentList");




		if (dependentList!=null && dependentList.size() > 0 ) 
     	{ 
     		for (Object[] obj : dependentList) {
     			
     			
     			
     			
     		
%>


	<label> Rank <span>*</span></label> 
	<%if(obj[1]!=null){ %>
<input id="rankId" name="<%=RANK_ID %>" type="hidden" value="<%=obj[1]%>"/>
<input id="rankName" type="text" name="<%=RANK_NAME%>" validate="Rank,string,yes"  value="<%=obj[2]%>" tabindex="1" title="Rank,regName,yes" MAXLENGTH="15"	readonly="readonly"/> 

<%}else{ %>
<input id="rankId" name="<%=RANK_ID %>" type="hidden" value="0"/>
<input id="rankName" type="text" name="<%=RANK_NAME%>" validate="Rank,string,yes"  value="" tabindex="1" title="Rank,regName,yes" MAXLENGTH="15" readonly="readonly"	/> 

<%} %>

<label>Name <span>*</span></label> 
<%if(obj[3]!=null){ %>   
<input id="pName" type="text" name="<%=FULL_NAME %>" validate="Name,string,yes"  readonly="readonly" value="<%=(String)obj[3]+" "+((String)obj[4]!=null?obj[4]:"")+" "+(obj[5]!=null?obj[5]:"")%>" tabindex="1"/> 
<%}else{ %>
<input id="pName" type="text" name="<%=FULL_NAME %>" validate="Name,string,yes"  value="" tabindex="1" readonly="readonly"/>
<%} %>

<label> Trade/Branch</label>
<%if(obj[6]!=null){ %> 
<input id="tradeId" name="<%=TRADE_ID %>" type="hidden" value="<%=obj[6] %>"/>
<input id="tradeName" type="text" name="<%=TRADE_NAME%>" validate="Trade,string,yes"  value="<%=obj[7]%>" tabindex="1" title="Rank,regName,yes" MAXLENGTH="15"	 readonly="readonly"/> 
<%}else{ %>
<input id="tradeId" name="<%=TRADE_ID %>" type="hidden" value="0"/>
<input id="tradeName" type="text" name="<%=TRADE_NAME%>"  validate="Trade,string,yes"  value="" tabindex="1" title="Trade,regName,yes" MAXLENGTH="15"	 readonly="readonly"/> 

<%} %>
<%break;} }else{
	%>
<label> Rank <span>*</span></label> 

<input id="rankId" name="<%=RANK_ID %>" type="hidden" value="0"/>
<input id="rankName" type="text" name="<%=RANK_NAME%>" value="" validate="Rank,string,yes"  tabindex="1" title="Rank,regName,yes" MAXLENGTH="15"	readonly="readonly" /> 

<label>Name <span>*</span></label> 

<input id="pName" type="text" name="<%=FULL_NAME %>" value="" validate="Name,string,yes"  tabindex="1"/>


<label> Trade/Branch<span>*</span></label>
<input id="tradeId" name="<%=TRADE_ID %>" type="hidden" value="0"/>
<input id="tradeName" type="text" name="<%=TRADE_NAME%>"  value="" validate="Trade,string,yes"  tabindex="1" title="Trade,regName,yes" MAXLENGTH="15" readonly="readonly"	 /> 

<%}%>