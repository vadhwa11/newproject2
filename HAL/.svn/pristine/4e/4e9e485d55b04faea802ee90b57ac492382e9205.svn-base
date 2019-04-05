<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
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

		List<Integer> existingNameList=new ArrayList();
		
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		if(map.get("departmentList") != null){
			departmentList = (List)map.get("departmentList");
		}
		

		
		if (map.get("existingNameList") != null){
			existingNameList =(List<Integer>)map.get("existingNameList");
		}
		//System.out.println("existingNameList--"+existingNameList.size());
	
%>
<script>

  </script>

<div class="cmntable">
<div class="Clear"></div>
<% int i =0; 
   String flag1 = "";%>
<table cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="15">Sl No.</th>
			<th>Department Name</th>
			<th> <input type="checkbox" class="checkbox" onclick="checkDepAll();" />Select All</th>
		</tr>
	</thead>
	<tbody id="searchresulttable">

		<%	
           		for(MasDepartment masDepartment : departmentList){
           			//System.out.println("outer loop-");
           			i++;
		%>
		<tr>
		<td><%=i%></td>
		<td>
			<%=masDepartment.getDepartmentName()%>
			<input type="hidden" id="depId<%=i%>" name="depId<%=i%>" value="<%=masDepartment.getId()%>"/>
		</td>
		<td>
		<%
		for(int k=0; k < existingNameList.size();k++){
			  if(masDepartment.getId().equals(existingNameList.get(k))){
				  flag1 = "true"; 
				  //System.out.println("inner loop--"+i);
				  break;
				  
			  }else{
				  flag1 = "false";
			  }
			  
		}
		if(flag1  == "true"){
		%>
		
		   <input type="checkbox" id="depChk<%=i%>" name="depChk<%=i%>" value = "yes" class="checkbox" checked="true"  /></td>
		<% }else{ %>
		   <input type="checkbox" id="depChk<%=i%>" name="depChk<%=i%>" value = "yes" class="checkbox"   /></td>	
		<% }
     }
		%>
			
			</tr>
			
	</tbody>
</table>
</div>

<div class="clear"></div>
<input type="hidden" id="countVal" name="countVal" value="<%=i%>" /> 
<input type="hidden" id="chkStatus" value="no" /> 
<input type="button" name="depart" value="Save" class="button"	onClick="if(checkBlankTemplate()){submitForm('assignApplicationForm','user?method=submitDepartmentWiseTemplate');}" />
<input type="button" name="Back" value="Back" class="button"	accesskey="b" onclick="submitFormForButton('assignApplicationForm','user?method=showTemplateJsp')" tabindex=1 />
<div class="clear"></div>
