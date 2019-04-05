<%@page import="java.util.*"%> 
<%@page import="java.io.*"%>  
<%@page import="com.sun.org.apache.xerces.internal.impl.dv.util.Base64"%> 
<%@page import="jkt.hms.pacs.controller.PrintPacsReport"%>  

<html>
<%  
	Map map = new HashMap(); 
	List<PrintPacsReport> printPacsReportList=new ArrayList<PrintPacsReport>();
	
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}  
		
	if (map.get("printPacsReportList") != null) {
		printPacsReportList = (List<PrintPacsReport>)map.get("printPacsReportList");
	}  
	
	String regNo = printPacsReportList.get(0).getRegno();
	String temprelation=regNo.substring(regNo.length()-3, regNo.length());
	String relation="NA";
	if(temprelation.indexOf("01") !=-1)
	{
		relation="Father";
	}
	if(temprelation.indexOf("02") !=-1)
	{
		relation="Mother";
	}
	if(temprelation.indexOf("03") !=-1)
	{
		relation="Wife";
	}
	if(temprelation.indexOf("04") !=-1)
	{
		relation="Husband";
	}
	if(temprelation.indexOf("06") !=-1)
	{
		relation="Self";
	}
	if(temprelation.indexOf("07") !=-1)
	{
		relation="Son";
	}
	if(temprelation.indexOf("08") !=-1)
	{
		relation="Daughter";
	}
 
%> 
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=printPacsReportList.get(0).getPatientname()%> Report</title>
</head>  

<body> 
  
	<table style="width: 650px;border: none;padding-top: 10px;">
			<tr>
			<td class="historytd">Reg.No :&nbsp;<b><%=printPacsReportList.get(0).getRegno()%></b></td>
				<td class="historytd">Name : <b><%=printPacsReportList.get(0).getPatientname() %></b></td>				
				<td class="historytd">Relation : <b><%=relation%></b></td> 
				 
			</tr>
			<tr>
				<td class="historytd">Investigation Name : <b><%=printPacsReportList.get(0).getInvestigation() !=null? printPacsReportList.get(0).getInvestigation():"NA"%></b></td>
				<td class="historytd">Modality : <b><%=printPacsReportList.get(0).getMods()%></b></td>
				<td class="historytd">Gender : <b><%=printPacsReportList.get(0).getSex()%></b></td>
			</tr>
			<tr>
				<td class="historytd">Study Date : <b><%=printPacsReportList.get(0).getStudydate()%></b></td>
				<td class="historytd">Report Date : <b><%=printPacsReportList.get(0).getRepordate()%></b></td>
				<td class="historytd">&nbsp;</td>
			</tr> 
	</table> 
	<hr>
	<table style="width: 660px;border: none;padding-top: 10px;">
			<tr>
				<td class="desctd"><%=printPacsReportList.get(0).getDescription()%></td> 
			</tr> 
	</table> 
	<div class="clear"></div>
	<table style="width: 340px;border: none;padding-top: 20px;">
			<tr>
				 <%-- <%String  url="/hms/hms/pacs?method=getimageReport&userId="+printPacsReportList.get(0).getUserId();%> 
 				<td calss="signtd" style="text-align: center;"> <img src="<%=url%>" width="100" height="50" /></td> --%> 
			</tr> 
			<tr>
				<td class="signtd"></td> 
			</tr>
			<tr>
				<td class="signtd"></td> 
			</tr>
			<tr>
				<td class="signtd"></td> 
			</tr>
			<tr>
				<td class="signtd"><b><%=printPacsReportList.get(0).getDoctorname()%></b></td> 
			</tr>
			<tr> 
				<td class="signtd"><b><%=printPacsReportList.get(0).getDesignation()%></b>&nbsp;&nbsp;(<%=printPacsReportList.get(0).getDepartment()%>)</td> 
			</tr> 
			<tr> 
				<td class="signtd"><b><%=printPacsReportList.get(0).getHospitalname()%></b></td> 
			</tr>
	</table>  
	
</body> 
</html>
<script>
 window.menubar.visible;
 
 </script>
<style>
.historytd{ 
	border:none;
	font: 14px Tahoma;
	padding-left: 4px;
	text-align: left;
	padding-bottom: 6px;
	padding-top: 6px;
	}
.desctd{
	border:none;
	font: 14px Tahoma;
	padding-left: 4px;
	text-align: left;
	padding-bottom: 6px;
	padding-top: 6px;
}

.signtd{
	border:none;
	font: 14px Tahoma;
	padding-left:4px;
	text-align: center;
	padding-bottom: 1px;
	padding-top: 1px;
}	
</style>
