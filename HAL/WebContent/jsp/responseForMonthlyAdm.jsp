<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>



<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}
List<Object[]> admList = new ArrayList<Object[]>();
if(map.get("admList")!=null){
	admList = (List<Object[]>)map.get("admList");
}
List<Object[]> diagList = new ArrayList<Object[]>();
if(map.get("diagList")!=null){
	diagList = (List<Object[]>)map.get("diagList");
}
List<MonthlySickAdmDetails> monthlyAdmList = new ArrayList<MonthlySickAdmDetails>();
if(map.get("monthlyAdmList")!=null){
	monthlyAdmList = (List<MonthlySickAdmDetails>)map.get("monthlyAdmList");
}

int monthlySickAdmHdId= 0;
if(monthlyAdmList.size() > 0){
	for(MonthlySickAdmDetails obj : monthlyAdmList){
		monthlySickAdmHdId = obj.getMonthlySickAdmHeader().getId();
		break;
	}
}
%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Date"%>
<%@page import="jkt.hms.masters.business.MonthlySickAdmDetails"%>
<input type="hidden" name="monthlySickAdmHdId" value="<%=monthlySickAdmHdId %>"/>
<div class="cmntable">
<table  width="100%" border="0" cellspacing="0" cellpadding="0" id="grid">
<thead>
	<tr>
		<th>Service No.</th>
		<th>A&D No.</th>
		<th>Rank</th>
		<th>Name</th>
		<th>Age</th>
		<th>Unit</th>
		<th>Trade/Branch</th>
		<th>Diagnosis</th>
		<th colspan="2">Date of Admission</th>
		<th>How disposed off</th>
		<th colspan="2">Date of Discharge</th>
		<th>No. of Days</th>
		<th>Remarks by SMO</th>
		<th>Add</th>
		<th>Delete</th>
	</tr>
	</thead>
		<tbody>
		<%
		int i=1;
			if(monthlyAdmList.size() > 0){
				for(MonthlySickAdmDetails moSickAdmDetails : monthlyAdmList){
					String name= moSickAdmDetails.getHin().getPFirstName()+" "+(moSickAdmDetails.getHin().getPMiddleName()!=null?moSickAdmDetails.getHin().getPMiddleName():"")+" "+(moSickAdmDetails.getHin().getPLastName()!=null?moSickAdmDetails.getHin().getPLastName():"");
					String currentAge = "";
					String age = moSickAdmDetails.getHin().getAge();
					currentAge = HMSUtil.calculateAgeForADT(age, moSickAdmDetails.getHin().getRegDate());
					
		
		%>
		<tr>
		<td><input type="text" name="serviceNo<%=i %>" readonly="readonly" value="<%=(moSickAdmDetails.getHin().getServiceNo()!=null?moSickAdmDetails.getHin().getServiceNo():"") %>" size="7"/></td>
		<td><input type="text" name="adNo<%=i %>" readonly="readonly" value="<%=(moSickAdmDetails.getAdNo()!=null?moSickAdmDetails.getAdNo():"") %>" size="7"/></td>
		<td><input type="text" name="rank<%=i %>" readonly="readonly" value="<%=(moSickAdmDetails.getHin().getRank()!=null?moSickAdmDetails.getHin().getRank().getRankName():"") %>" size="5"/></td>
		<td><input type="text" name="name<%=i %>" readonly="readonly" value="<%=name%>" size=""/></td>
		<td><input type="text" name="age<%=i %>" readonly="readonly" value="<%=(currentAge) %>" size="4"/></td>
		<td><input type="text" name="unit<%=i %>" readonly="readonly" value="<%=(moSickAdmDetails.getHin().getUnit()!=null?moSickAdmDetails.getHin().getUnit().getUnitName():"") %>" size="5"/></td>
		<td><input type="text" name="trade<%=i %>" readonly="readonly" value="<%=(moSickAdmDetails.getHin().getTrade()!=null?moSickAdmDetails.getHin().getTrade().getTradeName():"") %>" size="9"/></td>
		
		<td><input type="text" name="diagnosis<%=i %>" value="<%=moSickAdmDetails.getDiagnosis()!=null?moSickAdmDetails.getDiagnosis():""%>" size="25" maxlength="1000"/></td>
		
		<td><input type="text" id="doa<%=i %>" name="doa<%=i %>" readonly="readonly" size="8" value="<%=(moSickAdmDetails.getDateOfAdmission()!=null?HMSUtil.convertDateToStringWithoutTime(moSickAdmDetails.getDateOfAdmission()):"") %>" onblur="getNoOfDays('<%=i %>')"/></td>
		<td><img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" class="calender"	onClick="setdate('',document.monthlySick.doa<%=i %>,event)" /></td>
		<td><input type="text" name="disposedOff<%=i %>" maxlength="100" value="<%=(moSickAdmDetails.getDisposedOff()!=null?moSickAdmDetails.getDisposedOff():"") %>"/></td>
		<td><input type="text" id="dod<%=i %>" name="dod<%=i %>" readonly="readonly" size="8" value="<%=(moSickAdmDetails.getDateOfDischarge()!=null?HMSUtil.convertDateToStringWithoutTime(moSickAdmDetails.getDateOfDischarge()):"") %>" onblur="getNoOfDays('<%=i %>')"/></td>
		<td><img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" class="calender"	onClick="setdate('',document.monthlySick.dod<%=i %>,event)" /></td>
		<td><input type="text" id="noOfDays<%=i %>" name="noOfDays<%=i %>"  size="2" value="<%=(moSickAdmDetails.getNoOfDays()!=null?moSickAdmDetails.getNoOfDays():"") %>"/>
		<input type="hidden" name="monthlyAdmDtId<%=i %>" value="<%=moSickAdmDetails.getId()%>" id="monthlyAdmDtId<%=i %>">
		<input type="hidden" name="hinId<%=i %>" value="<%=moSickAdmDetails.getHin().getId()%>" id="hinId<%=i %>">
		<input type="hidden" name="inpatientId<%=i %>" value="<%=moSickAdmDetails.getInpatient()!=null?moSickAdmDetails.getInpatient().getId():0%>" id="inpatientId<%=i %>">
		</td>
		<td><input type="text" name="remarks<%=i %>" maxlength="200" value="<%=(moSickAdmDetails.getRemarks()!=null?moSickAdmDetails.getRemarks():"") %>"/></td>
		
		<td>
		<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
		</td>
		<td>
		<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow(this);"  disabled="disabled"/>
		</td>
	
		</tr>
		<% i++;
		}
			}else if(admList.size() > 0){
				for(Object[] obj : admList){
		%>
		<tr>
		<td><input type="text" name="serviceNo<%=i %>" readonly="readonly" value="<%=(obj[6]!=null?obj[6]:"") %>" size="7"/></td>
		<td><input type="text" name="adNo<%=i %>" readonly="readonly" value="<%=(obj[14]!=null?obj[14]:"") %>" size="7"/></td>
		<td><input type="text" name="rank<%=i %>" readonly="readonly" value="<%=(obj[2]!=null?obj[2]:"") %>" size="5"/></td>
		<td><input type="text" name="name<%=i %>" readonly="readonly" value="<%=(obj[1]!=null?obj[1]:"") %>" size=""/></td>
		<td><input type="text" name="age<%=i %>" readonly="readonly" value="<%=(obj[4]!=null?obj[4]:"") %>" size="4"/></td>
		<td><input type="text" name="unit<%=i %>" readonly="readonly" value="<%=(obj[5]!=null?obj[5]:"") %>" size="5"/></td>
		<td><input type="text" name="trade<%=i %>" readonly="readonly" value="<%=(obj[3]!=null?obj[3]:"") %>" size="9"/></td>
		<%
			String diag = "";
			if(diagList.size() > 0){
				for(Object[] diagObj : diagList){
					if(obj[0].equals(diagObj[1])){
						if(!diag.equals("")){
							diag += ",";
						}
						diag += diagObj[0].toString();
					}
				}
		%>
		
		<td><input type="text" name="diagnosis<%=i %>" value="<%=diag %>" size="25" maxlength="1000"/></td>
		<%}else{ %>
		<td></td>
		<%} %>
		<td><input type="text" id="doa<%=i %>" name="doa<%=i %>" readonly="readonly" size="8" value="<%=(obj[7]!=null?HMSUtil.convertDateToStringWithoutTime((Date)obj[7]):"") %>" onblur="getNoOfDays('<%=i %>')"/></td>
		<td><img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" class="calender"	onClick="setdate('',document.monthlySick.doa<%=i %>,event)" /></td>
		<td><input type="text" id="disposedOff<%=i %>" name="disposedOff<%=i %>" value="" maxlength="100"/></td>
		<td><input type="text" id="dod<%=i %>" name="dod<%=i %>" readonly="readonly" size="8" value="<%=(obj[8]!=null?HMSUtil.convertDateToStringWithoutTime((Date)obj[8]):"") %>" onblur="getNoOfDays('<%=i %>')"/></td>
		<td><img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" class="calender"	onClick="setdate('',document.monthlySick.dod<%=i %>,event)" /></td>
		<td><input type="text" id="noOfDays<%=i %>"  name="noOfDays<%=i %>" readonly="readonly" size="2" value="<%=(obj[12]!=null?Integer.parseInt(obj[12].toString())+1:"") %>"/>
		<input type="hidden" name="monthlyAdmDtId<%=i %>" value="0" id="monthlyAdmDtId<%=i %>">
		<input type="hidden" name="hinId<%=i %>" value="<%=obj[13]%>" id="hinId<%=i %>">
		<input type="hidden" name="inpatientId<%=i %>" value="<%=obj[0]%>" id="inpatientId<%=i %>">
		</td>
		<td><input type="text" name="remarks<%=i %>" maxlength="200" value=""/></td>
	
		<td>
		<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" tabindex="1" /> 
		</td>
		<td>
		<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow(this);" disabled="disabled" />
		</td>
		</tr>
		<% i++;
		}
			}
		%>
		</tbody>
</table>
<input type="hidden" name="cnt" value="<%=i-1 %>" id="cnt">
<div class="Clear"></div>
</div>
<input type="button" name="save" value="submit" onclick="submitForm('monthlySick','/hms/hms/mis?method=submitMonthlySickAdmission');"/>
<input type="button" name="print" value="Print" onclick="submitForm('monthlySick','/hms/hms/mis?method=searchMonthlySickReport');"/>
