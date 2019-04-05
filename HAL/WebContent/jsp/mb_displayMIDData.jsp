<%@ page import ="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>


<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%@page import="jkt.hms.masters.business.MasUnit"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<div class="clear"></div>

<%
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
	map=(Map<String, Object>)request.getAttribute("map");
}
List<MasMedicalExaminationDetail> medicalDetailList = new ArrayList<MasMedicalExaminationDetail>();
if(map.get("medicalDetailList") != null){
	medicalDetailList = (List<MasMedicalExaminationDetail>)map.get("medicalDetailList");
}
List<MasUnit> unitList = new ArrayList<MasUnit>();
if(map.get("unitList") != null){
	unitList = (List<MasUnit>)map.get("unitList");
}
int cnt=1;
	if(medicalDetailList.size() > 0){
%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>Date</th>
		<th>Disability</th>
		<th>Name</th>
		<th>Med Cat</th>
		<th>Height</th>
		<th>Weight</th>
		<th>Waist</th>
		<th>BP</th>
		<th>Unit</th>
		<th></th>
	</tr>
	<% int inc=0;
		for(MasMedicalExaminationDetail medicalExamDetail : medicalDetailList){
			++inc;
	%>
	<tr>
	<%if(medicalExamDetail.getMasMedicalReport().getDateOfReporting() !=null){ %>
		<td><%=HMSUtil.changeDateToddMMyyyy(medicalExamDetail.getMasMedicalReport().getDateOfReporting()) %></td>
		<%}else{ %>
		<td></td>
		<%} %>
		
		<%
			if(medicalExamDetail.getPrincipal()!= null){
		%>
		<td><%=medicalExamDetail.getPrincipal() %>
		</td>
		<%}else{ %>
		<td></td>
		<%} %>
		<td><%=medicalExamDetail.getMasMedicalReport().getNameInFull() %></td>
	<td><%=medicalExamDetail.getMasMedicalReport().getMedCatRec()!=null?medicalExamDetail.getMasMedicalReport().getMedCatRec():""%>
		<input type="hidden" value="<%=medicalExamDetail.getMasMedicalReport().getId() %>" name="medExamId<%=inc %>" id="medExamId<%=inc %>" />
		</td>
		<td><%=medicalExamDetail.getMasMedicalReport().getHeight()!=null?medicalExamDetail.getMasMedicalReport().getHeight():""%>
		</td>
		<td><%= medicalExamDetail.getMasMedicalReport().getWeight()!=null?medicalExamDetail.getMasMedicalReport().getWeight():""%>
		</td>
		<td><%= medicalExamDetail.getMasMedicalReport().getWaist()!=null?medicalExamDetail.getMasMedicalReport().getWaist():""%>
		</td>
		<td><%= medicalExamDetail.getMasMedicalReport().getBp()!=null?medicalExamDetail.getMasMedicalReport().getBp():""%>
		</td>
		<td>
		<select name="displayUnitId<%=inc %>" id="displayUnitId<%=inc %>"> 
		<option value="0">Select</option>
	<%
		 for(MasUnit masUnit : unitList){
			
		 %>
		
		<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
		
		<%} %>
		</select>
		<%
		 if(medicalExamDetail.getMasMedicalReport().getUnit() !=null){
		%>
		<script>
		document.getElementById('displayUnitId<%=inc %>').value='<%=medicalExamDetail.getMasMedicalReport().getUnit().getId()%>';
		</script>
		<%
			 }%>
			</td>
			
		<td><input type="Button" class="Button" value="Update" onclick="updateMIDData(<%=inc %>);"/></td>
	</tr>
	<%}
	} %>
</table>
