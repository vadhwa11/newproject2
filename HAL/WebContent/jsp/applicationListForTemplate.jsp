<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.GroupApplication"%><script type="text/javascript" language="javascript" src="/erp/jsp/js/proto.js"></script>
<script src="/erp/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/erp/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/erp/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/erp/jsp/js/unittest.js" type="text/javascript"></script>
<%
	
		Map<String,Object> map = new HashMap<String,Object>();
		if(request.getAttribute("map") != null)
		{
			map = (Map<String,Object>) request.getAttribute("map");
		}
		List<Object[]> applicationNameList=new ArrayList<Object[]>();
		List<Object[]> existingNameList=new ArrayList<Object[]>();
		if (map.get("applicationNameList") != null){
			applicationNameList =(List<Object[]>)map.get("applicationNameList");
		}
		
		if (map.get("existingNameList") != null){
			existingNameList =(List<Object[]>)map.get("existingNameList");
		}
		
		List<GroupApplication> appList=new ArrayList<GroupApplication>();
		if (map.get("appList") != null){
			appList =(List<GroupApplication>)map.get("appList");
		}
		String formName="";
		if (map.get("formName") != null)
			formName =(String)map.get("formName");
		
		int userId=0;
		if (map.get("userId") != null)
			userId =(Integer)map.get("userId");
		
%>
<script>
function checkAll(){
 if(document.getElementById("chkStatus").value =="no"){
   document.getElementById("chkStatus").value ="yes"
   for(var i=1;i<=document.getElementById("countVal").value;i++){
    document.getElementById("apChk"+i).checked =true
  }
  }else{
 document.getElementById("chkStatus").value ="no"
   for(var i=1;i<=document.getElementById("countVal").value;i++){
    document.getElementById("apChk"+i).checked =false
  }
  }
}
  </script>

<div class="cmntableWithHeight">
<div class="Clear"></div>
<table cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="15">Sl No.</th>
			<th>Application Name</th>
			<th> <input type="checkbox" class="checkbox" onclick="checkAll();" />Select All</th>
		</tr>
	</thead>
	<tbody id="searchresulttable">

		<%	
           		int i=0;
   				
   					for(Object[] masApplication : applicationNameList){
					
   						if(!(masApplication[2]).equals("0"))
					{
						i++;
	        
		  	   String parentId=null;
		  	
		  			%>
		  			<tr class="<% if(i %2 == 0){%>odd<%}else{%>even<%}%>">
		  				<td><%=i%></td>
		  				
		  				<%
		  			String appName =(String)masApplication[0];
		  			
		  			parentId =(String)masApplication[1];
		  			if(!parentId.equals("0")){
		  	%> <td><em><b><%=(String)masApplication[4]%></b></em>&nbsp;>>&nbsp;<%=(String)masApplication[0]%>
			
			</td>
			<td>
			<%
				String bool="false";
				for(Object[] existApplication : existingNameList){
				  if(masApplication[2].equals(existApplication[1])){
				    bool ="true"; %>
				    
			    <input type="checkbox" id="apChk<%=i%>" name="appId" value="<%=(String)masApplication[2]%>" class='checkbox' checked="true" />
			  	<% 	break; } 
		     	 } 	if(bool.equals("false")){	%>
			    <input type="checkbox" id="apChk<%=i%>" name="appId" value="<%=(String)masApplication[2]%>" class='checkbox' />
				 <%} %>
				 
			</td>
			<%     	} else {
				%>
				<td>
					<%
				if(masApplication[4]!=null){
					%>
					<b><i><%=(String)masApplication[4]%></i></b>
					<%	
				}else{
			%>
			<b><i><%=appName%></i></b>
			<%		
				}
				%>
			</td>
			<td>
				<%
				String bool="false";
				for(Object[] existApplication : existingNameList){
				  if(masApplication[2].equals(existApplication[1])){
				    bool ="true"; %>
				    <input type="checkbox" id="apChk<%=i%>" name="appId" value="<%=(String)masApplication[2]%>" class='checkbox' checked="true" />
			  	<% 	break; } 
		     	 } 	if(bool.equals("false")){
				%>
			 <input type="checkbox" id="apChk<%=i%>" name="appId" value="<%=(String)masApplication[2]%>" class='checkbox' checked="true" />
			 <%} %>
			 
			</td>
			<%	
                     }
		  
		  	 	 %>
		</tr>
		<%}}%>
	</tbody>
</table>
</div>

<div class="clear"></div>
<input type="hidden" name="userIdNew" value="<%=userId%>" /> 
<input type="hidden" id="formName" value="<%=formName%>" /> 
<input type="hidden" id="countVal" value="<%=i%>" /> 
<input type="hidden" id="chkStatus" value="no" />
 <div class="clear"></div>
<input type="button" name="removeRights" value="Save" class="button"	onClick="if(checkBlankTemplate()&& checkBlankModule() && checkAssignModule()){submitForm('assignApplicationForm','user?method=submitApplicationWiseTemplate');}" />
<input type="button" name="Back" value="Back" class="button"	accesskey="b" onclick="submitFormForButton('assignApplicationForm','security?method=showTemplateJsp')" tabindex=1 />
<div class="Clear"></div>
