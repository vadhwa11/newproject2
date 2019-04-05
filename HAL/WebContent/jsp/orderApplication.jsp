<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%
	
		Map map = new HashMap();
		List<GroupApplication> applicationListGroupWise = new ArrayList<GroupApplication>();
		List<MasApplication> masApplicationList= new ArrayList<MasApplication>();
		
		List<UserEmpGroup> userEmpGroupList= new ArrayList<UserEmpGroup>();
		
		if(request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("applicationListGroupWise") != null)
			applicationListGroupWise =(List)map.get("applicationListGroupWise");
  	    
		if (map.get("masApplicationList") != null)
			masApplicationList =(List)map.get("masApplicationList");
		
		
	    String value="";
		if (map.get("value") != null)
			value =(String)map.get("value");
		if(value.equals("true")){
			if (map.get("userEmpGroupList") != null){
				userEmpGroupList =(List<UserEmpGroup>)map.get("userEmpGroupList");
			}
		}
		
		int groupHospitalId= 0;
		String parentAppId="";
		int hospitalId=0;
		int groupId =0;
		if (map.get("groupHospitalId") != null)
			groupHospitalId =(Integer)map.get("groupHospitalId");
	
		
		if (map.get("groupId") != null)
			groupId =(Integer)map.get("groupId");
		
		if (map.get("parentAppId") != null)
			parentAppId =(String)map.get("parentAppId");
		
		System.out.println("Group Id :"+groupId);
		System.out.println("Parent App Id :" + parentAppId);
%>
<div class="clear paddingTop15"></div>
<div class="cmntable">
<table cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="15">S.No.</th>
			<th>Application Id</th>
			<th>Application Description</th>
			<th>Select Application To Move</th>
			<th>Order Sub Menu</th>
		</tr>
	</thead>
	<tbody id="searchresulttable">
		<%	
           		//Iterator iterator = applicationListGroupWise.iterator();
				System.out.println("applicationListGroupWise.size(); --------"+applicationListGroupWise.size());   
           		//GroupApplication groupApplication = null;
           		int i=0;
   				for (GroupApplication groupApplication : applicationListGroupWise) {
					if(groupApplication.getApp().getParentId().equals(parentAppId)) {
						i++;%>
		<tr class="<% if(i %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><input type="text" id="srNo<%=i%>" name="srNo"
				value="<%=i%>" size="2" class="noBorder" /></td>
			<td><input type="text" readonly="readonly"
				id="appIdToSwap<%=i%>" name="appIdToSwap"
				value="<%=groupApplication.getApp().getId()%>" size="3"
				class="noBorder" /></td>
			<td>
			<%
		  			// Code Commented For Ordering Issue
		  			//String parentid=groupApplication.getApp().getApplication().getId();
                    
		  			//for(MasApplication masApplication :masApplicationList) {
		  				//String appId=masApplication.getId();
		  			 	//String pId=masApplication.getParentId();
		  			 	
		 				//if(appId.equals(parentid)){
		 					//if(!pId.equals("0")){
		 						//for(MasApplication masAppObj : masApplicationList) {
		  			 				//MasApplication masAppObj=(MasApplication)itr1.next();
		  			  			 	//String appname=masAppObj.getName();
		  			  			 //	String appid=masAppObj.getId();
		  			  			 //	if(appid.equals(pId)){
			  			%> <!-- print application order and name by  groupApplication.getApp().getOrderNo()-->
			<%//}
		  			  	//		}
		  			 	 // 	}else{ 
		  			 		 %> <!-- print application order and name by  groupApplication.getApp().getOrderNo()-->
			<%//}
		 				//}
		 			//} %> <input type="hidden" id="orderNo<%=i%>" name="orderNo"
				value="<%=groupApplication.getApp().getOrderNo() %>" /> <!--   <input type="text" readonly="readonly" id= "appName<%=i%>" name ="appName"  value="<%=groupApplication.getApp().getName() %>"  class="noBorder" /> -->
			<label id="appName<%=i%>" name="appName" class="Tlabel"><%=groupApplication.getApp().getName() %></label>
			</td>
			<td><input type="radio" name="appId" class="radio"
				value="<%=groupApplication.getApp().getId() %>" /></td>
			<td><input type="button" name="orderSubMenu"
				value="Order Sub Menu" class="buttonBig"
				onclick="subMenuButtonAction('<%=i %>');" /> <!--   <input type="button" name="orderSubMenu" value="Order Sub Menu"  class="Tbutton"  onclick="submitProtoAjaxWithDivName('changeOrderForm','superAdmin?method=showSubMenuForOrdering&subParentAppId='+'<%=groupApplication.getApp().getId()%>'+'&groupIdSub='+'<%=groupId%>','subApplicationDiv')" /> -->
			</td>

		</tr>
		<%} %>

		<%}%>
	</tbody>
</table>
</div>
<div id="subApplicationDiv"></div>
<div class="clear"></div>
<input type="hidden" id="subGroupId" name="subGroupId" value="<%=groupId %>" /> 
<input type="hidden" name="groupHospitalId" value="<%=groupHospitalId %>" /> 
<input type="hidden" name="groupId"	value="<%=groupId %>" /> 
<input type="hidden" id="appId" value="" /> 
<input	type="hidden" id="prevAppId" value="" />
<input type="hidden" id="chkStatus" value="no" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="moveApp" value="Move UP " class="button"	onClick="swapApplication();" /> 
<input type="button" value="Submit" class="button" onClick="submitForm('changeOrderForm','superAdmin?method=submitSwapApplication')" />
<input type="button" name="Back" value="Back" class="button"	accesskey="b" onclick="submitFormForButton('changeOrderForm','superAdmin?method=showModuleManagementJsp')" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>







