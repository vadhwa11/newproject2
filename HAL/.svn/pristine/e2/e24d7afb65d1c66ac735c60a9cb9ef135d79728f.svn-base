<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/IPDGrid.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
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
		
		List<MasButtonForm> buttonList= new ArrayList<MasButtonForm>();
		if (map.get("buttonList") != null){
			buttonList =(List<MasButtonForm>)map.get("buttonList");
		}
		
%>
<script>
function checkSelect(){
 if(document.getElementById("chkStatus1").value =="no"){
   document.getElementById("chkStatus1").value ="yes"
   for(var i=1;i<=document.getElementById("countVal1").value;i++){
    document.getElementById("chkButton"+i).checked =true
  }
  }else{
 document.getElementById("chkStatus1").value ="no"
   for(var i=1;i<=document.getElementById("countVal1").value;i++){
    document.getElementById("chkButton"+i).checked =false
  }
  }
}
  </script>

<div class="tableHholder" style="width:600px; height: 300px; float: left;">
<div class="Clear"></div>
<table cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="15">S.No</th>
			<th>Button Name</th>
			<th><input type="checkbox" class="checkbox"
				onclick="checkSelect();" />Select Button</th>
		</tr>
	</thead>
	<tbody id="searchresulttable">

		
	<%	
           		Iterator iterator = buttonList.iterator();
           		MasButtonForm masButtonForm = null;
           		int i=0;
   				while (iterator.hasNext()) 
   				{
   					masButtonForm = (MasButtonForm) iterator.next();
					i++;
	        %>
		<tr class="<% if(i %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=i%></td>
			<td><%=masButtonForm.getButtonName()%></td>
			<td><input type="checkbox" id="chkButton<%=i %>"
				value="<%=masButtonForm.getId()%>" name="buttonName" />
		</tr>
		<%}%>
	</tbody>
</table>
</div>
<div class="Clear"></div>
<input type="button" name="removeRights" value="Save" class="cmnButton"	onClick="if(checkBlankTemplate()&& checkBlankModule() && checkAssignModule()){submitForm('assignApplicationForm','user?method=submitApplicationWiseTemplate');}" />
<input type="button" name="Back" value="Back" class="cmnButton"	accesskey="b" onclick="submitFormForButton('assignApplicationForm','user?method=showTemplateJsp')" tabindex=1 />
<div class="Clear"></div>
<div style="padding-top: 10px;"></div>
<input type="hidden" name="userIdNew" value="<%=userId%>" /> 
<input type="hidden" id="formName" value="<%=formName%>" /> 
<input type="hidden" id="countVal1" value="<%=i%>" /> 
<input type="hidden" id="chkStatus1" value="no" />
 

<div class="Clear"></div>
<div style="padding-top: 10px;"></div>
<div class="Clear"></div>
