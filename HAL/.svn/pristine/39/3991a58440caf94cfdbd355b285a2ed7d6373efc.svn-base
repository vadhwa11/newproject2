<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%-- <%@ include file="headerForPopup.jsp"%>
<%@include file="common_to_all_jsp.jsp" %> --%>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<form name="popRelation" method="post" action="">
<input type="hidden" name="ctoken" value="<%=session.getAttribute("csrfToken")%>">
<%
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<Patient> patientList = new ArrayList<Patient>();
	List<Patient> patientListForInfo = new ArrayList<Patient>();
	//List<Patient> patientListForInfoHIS = new ArrayList<Patient>();
	List <Object[]> patientListForInfoHIS=new ArrayList<Object[]>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String bldGroup="";
	int relationIdForUpdate=0;
	int serviceTypeId=0;
	int serviceStatusId=0;
	String serviceNoForUpdate="";
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("serviceNo") != null){
		serviceNoForUpdate = (String)map.get("serviceNo");
	}
	
	if(map.get("patientListForInfo") != null){
		patientListForInfo = (List<Patient>)map.get("patientListForInfo");
	}
	if(map.get("patientListForInfoHIS") != null){
		patientListForInfoHIS=(List<Object[]>)map.get("patientListForInfoHIS");
	}
	if(map.get("relationIdForUpdate") != null){
		relationIdForUpdate = Integer.parseInt(""+map.get("relationIdForUpdate"));
		
	}
	if(map.get("serviceTypeId") != null){
		serviceTypeId = Integer.parseInt(""+map.get("serviceTypeId"));
		
	}
	if(map.get("serviceStatusId") != null){
		serviceStatusId = Integer.parseInt(""+map.get("serviceStatusId"));
		
	}
	
%>
<div id="contentHolder">
<h6>H.I.S</h6>
<div class="tableHolderPopup">
<% int hmsCount=0; 
if(patientListForInfo.size() == 0){
				out.println(" No Record Found!!!");
							}else{%>

<table width="100%" colspan="5" id="relationDetails" cellpadding="0"
	cellspacing="0">

	<thead>
		<tr>
			<th scope="col">Select</th>	
			<th scope="col">Service No.</th> 
			<th scope="col">Hin No.</th>
			<th scope="col">Patient Name</th>
			<th scope="col">DOB</th>
			<th scope="col">Relation</th>
			
		</tr>
	</thead>
	<tbody>
		<%
  int i=1;

		
	for(Patient PatientDetail :patientListForInfo){
		hmsCount=hmsCount+1;
 %>
		<%
		String serviceNo="";
		  String hinNo="";
		  String pName="";
		  String relation="";
		  Date dob=null;
		  if(PatientDetail!= null){
			  serviceNo=PatientDetail.getServiceNo();
			  hinNo=PatientDetail.getHinNo();
			  pName=PatientDetail.getPFirstName()+" "+((PatientDetail.getPMiddleName()!=null)?PatientDetail.getPMiddleName():"")+" "+((PatientDetail.getPLastName()!=null)?PatientDetail.getPLastName():"");
			  relation =PatientDetail.getRelation().getRelationName(); 
			  if(PatientDetail.getDateOfBirth()!=null)
			  {
				  dob=PatientDetail.getDateOfBirth();

			  }
 %>
		<tr>
			
				<td><input type="checkbox" class="newCheckBox" value="<%=PatientDetail.getId()%>" id="HMS<%= i%>"
				name="HMS" onclick="setHinIdForHMS(<%=i %>);"/></td>
				<td><input type="text" id="ServiceNo<%=i %>"
				name="ServiceNo<%=i %>" value="<%=serviceNo%>" 
				readonly="readonly" /></td>
				
			<td><input type="text" id="HMShinNo<%=i %>"
				name="hinNo" value="<%=hinNo%>"
				readonly="readonly" />
				
				
				<input type="hidden" id="HMShinId<%=i %>"
				name="hinId" value="<%=PatientDetail.getId()%>"
				readonly="readonly" />
				
				</td>
			<td><input type="text" id="PName<%=i %>"
				name="PName"
				value="<%=pName%>"
				readonly="readonly" /></td>
				<td><input type="text" id="dob<%=i %>" name="<%=DATE_OF_BIRTH%>"
				value="<%=dob==null?"":dob %>" readonly="readonly" /></td>
			<td><input type="text" id="relation<%=i %>" name="<%=RELATION_NAME%>"
				value="<%=relation %>" readonly="readonly" />
				
				
			
			<input type="hidden" id="hinIdHMS<%=i %>"
				name="hinIdHMS" value=""
				readonly="readonly" />
				<input type="hidden" id="hinNoHMS<%=i %>"
				name="hinNoHMS" value=""
				readonly="readonly" /></td>
				<%-- onclick="if(checkDuplicateBagNo(<%=i %>)){setBloodBagInParent(<%=i %>);window.close();}" --%> 
		</tr>
		<%i++;
    } %>
		<%}
	
							}%>

	</tbody>
	
</table>
</div>
<h6>Mednet</h6>
<div class="tableHolderPopup">
<% int hisCount=0; 
if(patientListForInfoHIS.size() == 0){
				out.println(" No Record Found!!!");
							}else{%>

<table width="100%" colspan="5" id="relationDetails" cellpadding="0"
	cellspacing="0">

	<thead>
		<tr>
			<th scope="col">Select</th>
			<th scope="col">Service No.</th> 
			<th scope="col">Hin No.</th>
			<th scope="col">Patient Name</th>
			<th scope="col">DOB</th>
			<th scope="col">Relation</th>
			
		</tr>
	</thead>
	<tbody>
		<%
  int j=1;

		
/* 	for(Patient PatientDetail :patientListForInfoHIS){ */
		
		for (int i = 0; i < patientListForInfoHIS.size(); i++) {
			   Object[] pList = (Object[])patientListForInfoHIS.get(i);
			   hisCount=hisCount+1;
		
 %>
		<%
		  String serviceNo="";
		  String hinNo="";
		  String pName="";
		  String relation="";
		  Date dob1= null;
		  if(pList!= null){
			  serviceNo=""+pList[1];
			  hinNo=""+pList[4];
			  pName=""+pList[8]+" "+((pList[9]!=null)?""+pList[9]:"")+" "+((pList[10]!=null)?""+pList[10]:"");
			  relation =""+pList[18];
			  if(pList[17]!=null)
			  {
				  dob1=(Date)pList[17];
			  }
			  
 %>
		<tr>
		
				<td><input type="checkbox" class="newCheckBox" value="<%=pList[0]+""%>" id="HIS<%=j%>"
				name="CHECKBOX_FOR_TABLE"" onclick="setHinIdForHIS(<%=j %>);" /></td>
				
				<td><input type="text" id="ServiceNo<%=j %>"
				name="ServiceNo<%=j %>" value="<%=serviceNo%>" 
				readonly="readonly" /></td>
				
			<td>
			
			<input type="hidden" id="HIShinId<%=j %>"
				name="hinNo" value="<%=pList[0]+""%>"
				readonly="readonly" />
				
			<input type="text" id="HIShinNo<%=j %>"
				name="hinNo" value="<%=hinNo%>"
				readonly="readonly" /></td>
			<td><input type="text" id="PName<%=j %>"
				name="PName"
				value="<%=pName%>"
				readonly="readonly" /></td>
				<td><input type="text" id="relation<%=j %>" name="<%=DATE_OF_BIRTH%>"
				value="<%=dob1==null?"":dob1 %>" readonly="readonly" /></td>
			<td><input type="text" id="relation<%=j %>" name="<%=RELATION_NAME%>"
				value="<%=relation %>" readonly="readonly" />
			
		<input type="hidden" id="hinIdHIS<%=j%>"
				name="hinIdHIS" value=""
				readonly="readonly" />
				<input type="hidden" id="hinNoHIS<%=j%>"
				name="hinNoHIS" value=""
				readonly="readonly" /></td>
				<%-- onclick="if(checkDuplicateBagNo(<%=i %>)){setBloodBagInParent(<%=i %>);window.close();}" --%> 
		</tr>
		<%
    } %>
		<%
		
		j=j+1;}
		}%>

	</tbody>
	
</table>

<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" />




	
	</div>
	
	<div class="Clear"></div>
	<input type="hidden" id="relationIdForUpdate" name="relationIdForUpdate" value="<%=relationIdForUpdate%>" />
		<input type="hidden" id="serviceTypeId" name="serviceTypeId" value="<%=serviceTypeId%>" />
			<input type="hidden" id="serviceStatusId" name="serviceStatusId" value="<%=serviceStatusId%>" />
			<input type="hidden" id="serviceNoForUpdate" name="serviceNoForUpdate" value="<%=serviceNoForUpdate%>" />
			<input type="hidden" id="hisCount" name="hisCount" value="<%=hisCount%>" />			
						<input type="hidden" id="hmsCount" name="hmsCount" value="<%=hmsCount%>" />
	<input type="button" name="SYNC" value="SYNC" class="button" onClick="if(checkupdateData()){syncRegistrationInfo('popRelation');}"/>
	<input type="button" name="Close" value="Close" class="button" onClick="cancelForm()"/>
</div>

</form>
<script>
 function cancelForm(){
   	   window.close();
   	  
   
  }
 function setHinIdForHIS(counter)
	{
		
		if(document.getElementById('HIS'+counter).checked == true)
      {
		document.getElementById('hinIdHIS'+counter).value=document.getElementById('HIShinId'+counter).value;
		document.getElementById('hinNoHIS'+counter).value=document.getElementById('HIShinNo'+counter).value;
		
      }else
     	 {
     	 document.getElementById('hinIdHIS'+counter).value="";
     	 document.getElementById('hinNoHIS'+counter).value="";
     	 }
	}
 function setHinIdForHMS(counter)
	{	
		//alert(document.getElementById('parent'+counter).checked);
		/*  if(document.getElementsByName('parent')[counter].checked == true) */
		//alert(hinNo);
		//alert(val);
		if(document.getElementById('HMS'+counter).checked == true)
   {
		document.getElementById('hinIdHMS'+counter).value=document.getElementById('HMShinId'+counter).value;
		document.getElementById('hinNoHMS'+counter).value=document.getElementById('HMShinNo'+counter).value;;
   }else
  	 {
  	     document.getElementById('hinIdHMS'+counter).value="";
  	     document.getElementById('hinNoHMS'+counter).value="";
  	 }
	}
	
  </script>
  <script>
  function syncRegistrationInfo(formName)
  {

  //alert("enter");
	  var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
   xmlHttp.onreadystatechange=function()
   {
     if(xmlHttp.readyState==4){
     
     	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		
     	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var syncHMS1  = item.getElementsByTagName('syncHMS')[0];
	        var syncHIS1 = item.getElementsByTagName('syncHIS')[0];
	        var newHinNo1  = item.getElementsByTagName('newHinNo')[0];
	        	   // alert(syncHMS1.childNodes[0].nodeValue+"-----"+syncHIS1.childNodes[0].nodeValue+"---------"+newHinNo1.childNodes[0].nodeValue);    
	        if(syncHMS1.childNodes[0].nodeValue=='yes' && syncHIS1.childNodes[0].nodeValue=='yes'){
	        	alert("Registration data (HMS/HIS) Sync Successfully with HIN NO. "+newHinNo1.childNodes[0].nodeValue+"!!");
	        	//window.opener.location.reload();
	        	window.opener.location.href ="/his/his/registration/registration?method=showRegistrationJsp&jspName=registration&title=Registration";
	        	window.close();
	        	
	        }
	        else if(syncHMS1.childNodes[0].nodeValue=="yes" && syncHIS1.childNodes[0].nodeValue=="no")
	        	{
	        	alert("Registration data (HMS) Sync Successfully with HIN NO. "+newHinNo1.childNodes[0].nodeValue+"!!");
	        	//window.opener.location.reload();
	        	window.opener.location.href ="/hms/hms/registration?method=showRegistrationJsp&jspName=registration&title=Registration";
	        	window.close();
	        	    
	        	}
	        else if(syncHMS1.childNodes[0].nodeValue=="no" && syncHIS1.childNodes[0].nodeValue=="yes")
        	{
	        	alert("Registration data (HIS) Sync Successfully with HIN NO. "+newHinNo1.childNodes[0].nodeValue+"!!");
	        	window.close();
        	}
	        else
	        	{
	        	 alert("Registration data not Sync!!");
	        	   window.close();
	        	}
	   	} 
     }
   }
     
	 var action='/hms/hms/registration?method=updateHinNo'; 
	 var url=action+"&"+getNameAndData(formName);
   xmlHttp.open("POST",url,true);
   xmlHttp.setRequestHeader("Content-Type", "text/xml");
   xmlHttp.send(null);
   
  }
  function checkupdateData()
  {
	     var hisCount=document.getElementById('hisCount').value;
	     var hmsCount=document.getElementById('hmsCount').value;
         var hisflag=false;
         var hmsflag=false;
	      if(hisCount!=0 && hmsCount!=0)
	    	  {
	    	       for(ii=1;ii<=hisCount; ii++)
	    	    	   {
	    	    	         if(document.getElementById('HIS'+ii).checked == true)
	    	    	        	 {
	    	    	        		 hisflag=true;
	    	    	        	 }
	    	    	   }
	    	       for(ii=1;ii<=hmsCount; ii++)
    	    	   	   {
	    	    		   if(document.getElementById('HMS'+ii).checked == true)
	    	        		 {
	    	    			      hmsflag=true;
	    	        		 }
    	    	  	   }
	    	  }
	      else if(hisCount!=0 && hmsCount==0)
	    	  {
	    	 	 for(ii=1;ii<=hisCount; ii++)
	    	   		{
	    	         if(document.getElementById('HIS'+ii).checked == true)
	    	        	 {
	    	        		 hisflag=true;
	    	        	 }
	    	  		 }
	    	  }
	      else if (hisCount==0 && hmsCount!=0)
	    	  {
	    	  for(ii=1;ii<=hmsCount; ii++)
   	   	   		{
	    		   if(document.getElementById('HMS'+ii).checked == true)
	        		 {
	    			      hmsflag=true;
	        		 }
   	  	  		 }
	    	  }
	      
	      if(hisflag==false && hmsflag==false)
	    	  {
	    	       alert("Please select any one recoed to Sync!!");
	    	       return false;
	    	  }
	      else
	    	  {
	    	      return true;
	    	  }
	      
	      
  
  }
  </script>