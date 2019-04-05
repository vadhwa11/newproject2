<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

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
	List<MasRelation> masRelationList = new ArrayList<MasRelation>();

	//List<Patient> patientListForInfoHIS = new ArrayList<Patient>();
	List <Object[]> patientListForInfoHIS=new ArrayList<Object[]>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String bldGroup="";
	int relationIdForUpdate=0;
	int serviceTypeId=0;
	int serviceStatusId=0;
	String serviceNoForUpdate="";
	String flag="";
	String referred="";
	int hinIdForAdmission=0;
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("serviceNo") != null){
		serviceNoForUpdate = (String)map.get("serviceNo");
	}
	if(map.get("flag") != null){
		flag = (String)map.get("flag");
		System.out.println("flag-->"+flag);
	}
	if(map.get("referred") != null){
		referred = (String)map.get("referred");
		System.out.println("referred-->"+referred);
	}
	
	if(map.get("patientListForInfo") != null){
		patientListForInfo = (List<Patient>)map.get("patientListForInfo");
	}
	if(map.get("masRelationList") != null){
		masRelationList = (List<MasRelation>)map.get("masRelationList");
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
	if(map.get("hinIdForAdmission") != null){
		hinIdForAdmission = Integer.parseInt(""+map.get("hinIdForAdmission"));
		
	}
	if(map.get("serviceStatusId") != null){
		serviceStatusId = Integer.parseInt(""+map.get("serviceStatusId"));
		
	}
	
%>
<div id="contentHolder">
<h6>MEDNET</h6>
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
			<th scope="col">New Hin No.</th>
			<th scope="col">Patient Name</th>
			<th scope="col">D.O.B</th>
			<th scope="col">Relation</th>
			<th scope="col">New Relation</th>
			
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
		  String pDOB=null;
		  if(PatientDetail!= null){
			  serviceNo=PatientDetail.getServiceNo();
			  hinNo=PatientDetail.getHinNo();
			  pName=PatientDetail.getPFirstName()+" "+((PatientDetail.getPMiddleName()!=null)?PatientDetail.getPMiddleName():"")+" "+((PatientDetail.getPLastName()!=null)?PatientDetail.getPLastName():"");
			  relation =PatientDetail.getRelation().getRelationName();
			  if(PatientDetail.getDateOfBirth()!=null)
			  {
				  pDOB=String.valueOf(PatientDetail.getDateOfBirth());

			  }
			  
			 // out.print("relation="+relation);
 %>
		<tr>
			
				<td><input type="checkbox" class="newCheckBox" value="<%=PatientDetail.getId()%>" id="HMS<%= i%>"
				name="HMS" onclick="setHinIdForHMS(<%=i %>);"/></td>
				<td><input type="text" id="ServiceNo<%=i %>"
				name="ServiceNo<%=i %>" value="<%=serviceNo%>" 
				readonly="readonly" /></td>
				
			<td><input type="text" id="HMShinNo<%=i %>"
				name="HMShinNo" value="<%=hinNo%>"
				readonly="readonly" />
				
				
				<input type="hidden" id="HMShinId<%=i %>"
				name="hinId" value="<%=PatientDetail.getId()%>"
				readonly="readonly" />
				
				</td>
				<td><input type="text" id="NewHMShinNo<%=i %>"
				name="newHMShinNo" value=""
				readonly="readonly" />
				
				</td>
				
			<td><input type="text" id="PName<%=i %>"
				name="PName"
				value="<%=pName%>"
				readonly="readonly" /></td>
			<td><input type="text" id="PDOB<%=i %>"
				name="PDOB"
				value="<%=pDOB==null?"":pDOB%>"
				readonly="readonly" /></td>
			<td><input type="text" id="relation<%=i %>" name="<%=RELATION_NAME%>"
				value="<%=relation %>" readonly="readonly" /></td>
			
				<td><input type="hidden" id="hinIdHMS<%=i %>"
				name="hinIdHMS" value=""
				readonly="readonly" /><input type="hidden" id="hinNoHMS<%=i %>"
				name="hinNoHMS" value=""
				readonly="readonly" />
				<input type="hidden" id="newhinNoHMS<%=i %>"
				name="newhinNoHMS" value=""
				readonly="readonly" />
				<input type="hidden" id="newHMSRelation<%=i %>"
				name="newHMSRelation" value=""
				readonly="readonly" />
				
				
				<select name="newRelationHMS" id="newRelationHMS<%=i%>" onchange="fillNewHin(this.value,'<%=i%>','HMS');">
	<option value="0">Select</option>

	<% 
	for (MasRelation  obj : masRelationList){		
%>
	<option value="<%=obj.getId()%>" title="<%=obj.getNewRelationName()%>"><%=obj.getNewRelationName()%></option>
	<%}%>
</select>
</td>
		</tr>
		<%i++;
    } %>
		<%}
	
							}%>

	</tbody>
	
</table>
</div>
<h6>HIS</h6>
<div class="tableHolderPopup">
<%
int hisCount=0;
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
			<th scope="col">New Hin No.</th>
			<th scope="col">Patient Name</th>
			<th scope="col">D.O.B</th>		
			<th scope="col">Relation</th>	
			<th scope="col">New Relation</th>
			
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
		  String pDOB1=null;
		  if(pList!= null){
			  serviceNo=""+pList[1];
			  hinNo=""+pList[4];
			  pName=""+pList[8]+" "+((pList[9]!=null)?""+pList[9]:"")+" "+((pList[10]!=null)?""+pList[10]:"");
			  relation =""+pList[18];
			  if(pList[11]!=null)
			  {
				  pDOB1=pList[11].toString();

			  }
 %>
		<tr>
		
				<td><input type="checkbox" class="newCheckBox" value="<%=pList[0]+""%>" id="HIS<%=j%>"
				name="CHECKBOX_FOR_TABLE" onclick="setHinIdForHIS(<%=j %>);" /></td>
				
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
				<td><input type="text" id="NewHIShinNo<%=j%>"
				name="newHIShinNo" value=""
				readonly="readonly" />
				
				</td>
			<td><input type="text" id="PName<%=j %>"
				name="PName"
				value="<%=pName%>"
				readonly="readonly" /></td>
				<td><input type="text" id="PDOB<%=j %>"
				name="PDOB"
				value="<%=pDOB1==null?"":pDOB1%>"
				readonly="readonly" /></td>
			<td><input type="text" id="relation<%=j %>" name="<%=RELATION_NAME%>"
				value="<%=relation %>" readonly="readonly" /></td>
			
			<td><input type="hidden" id="hinIdHIS<%=j%>"
				name="hinIdHIS" value=""
				readonly="readonly" />
				<input type="hidden" id="hinNoHIS<%=j%>"
				name="hinNoHIS" value=""
				readonly="readonly" />
				<input type="hidden" id="newhinNoHIS<%=j%>"
				name="newhinNoHIS" value=""
				readonly="readonly" />
				<input type="hidden" id="newHISRelation<%=j%>"
				name="newHISRelation" value=""
				readonly="readonly" />
				
				<select name="newRelationHIS" id="newRelationHIS<%=j%>" onchange="fillNewHin(this.value,'<%=j%>','HIS');" >
	<option value="0">Select</option>

	<% 
	for (MasRelation  obj : masRelationList){		
%>
	<option value="<%=obj.getId()%>" title="<%=obj.getNewRelationName()%>"><%=obj.getNewRelationName()%></option>
	<%}%>
</select>
</td>
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
			<input type="hidden" id="hinIdForAdmission" name="hinIdForAdmission" value="<%=hinIdForAdmission%>" />
			<input type="hidden" id="hisCount" name="hisCount" value="<%=hisCount%>" />			
			<input type="hidden" id="hmsCount" name="hmsCount" value="<%=hmsCount%>" />
			<input type="hidden" id="flag" name="flag" value="<%=flag%>" />
			<input type="hidden" id="referred" name="referred" value="<%=referred%>" />
			
	<input type="button" name="SYNC" value="SYNC" class="button" onClick="if(checkupdateData()){syncRegistrationInfo('popRelation');}"/>
	<input type="button" name="Close" value="Close" class="button" onClick="closePopUp()"/>
</div>

</form>
<script>
function closePopUp(){
	   window.close();
	  

}


 function setHinIdForHIS(counter)
	{

		if(document.getElementById('HIS'+counter).checked == true)
      	{
			
      	    if(document.getElementById('newRelationHIS'+counter).value!=0){
			document.getElementById('hinIdHIS'+counter).value=document.getElementById('HIShinId'+counter).value;
			document.getElementById('hinNoHIS'+counter).value=document.getElementById('HIShinNo'+counter).value;
			document.getElementById('newhinNoHIS'+counter).value=document.getElementById('NewHIShinNo'+counter).value;
			document.getElementById('newHISRelation'+counter).value=document.getElementById('newRelationHIS'+counter).value;
      	    }else
      	    	{
      	    		 alert("Please select new relation!!");
     		  		 document.getElementById('HIS'+counter).checked = false;
     		  		 document.getElementById('hinIdHIS'+counter).value="";
     	     		 document.getElementById('hinNoHIS'+counter).value="";
     	     		 document.getElementById('newhinNoHIS'+counter).value="";
     		  		 document.getElementById('newRelationHIS'+counter).focus();
      	    	}
		
     	 }else
     	 {
     		 document.getElementById('hinIdHIS'+counter).value="";
     		 document.getElementById('hinNoHIS'+counter).value="";
     		 document.getElementById('newhinNoHIS'+counter).value="";
     	 }
		
	}
 function setHinIdForHMS(counter)
	{	
		
		if(document.getElementById('HMS'+counter).checked == true)
   		{
			if(document.getElementById('newRelationHMS'+counter).value!=0)
			{
		document.getElementById('hinIdHMS'+counter).value=document.getElementById('HMShinId'+counter).value;
		document.getElementById('hinNoHMS'+counter).value=document.getElementById('HMShinNo'+counter).value;
		document.getElementById('newhinNoHMS'+counter).value=document.getElementById('NewHMShinNo'+counter).value;
		document.getElementById('newHMSRelation'+counter).value=document.getElementById('newRelationHMS'+counter).value;
			}
			else
				{
				   alert("Please select new relation!!");
				   document.getElementById('HMS'+counter).checked = false;
				   document.getElementById('hinIdHMS'+counter).value="";
			  	     document.getElementById('hinNoHMS'+counter).value="";
			  	     document.getElementById('newhinNoHMS'+counter).value="";				   
				   document.getElementById('newRelationHMS'+counter).focus();
				}

   		}
		else
  	 	{
  	     document.getElementById('hinIdHMS'+counter).value="";
  	     document.getElementById('hinNoHMS'+counter).value="";
  	     document.getElementById('newhinNoHMS'+counter).value="";
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
	        	   // alert(syncHMS1.childNodes[0].nodeValue+"-----"+syncHIS1.childNodes[0].nodeValue+"---------"+newHinNo1.childNodes[0].nodeValue);    
	        if(syncHMS1.childNodes[0].nodeValue=='yes' && syncHIS1.childNodes[0].nodeValue=='yes'){
	        	alert("Registration data (MEDNET/HIS) Sync Successfully !!");
	        	closePopUp();
	        	
	        }
	        else if(syncHMS1.childNodes[0].nodeValue=="yes" && syncHIS1.childNodes[0].nodeValue=="no")
	        	{
	        	alert("Registration data (MEDNET) Sync Successfully !!");
	        	closePopUp();
	        	    
	        	}
	        else if(syncHMS1.childNodes[0].nodeValue=="no" && syncHIS1.childNodes[0].nodeValue=="yes")
        	{
	        	alert("Registration data (HIS) Sync Successfully !!");
	        	closePopUp();
        	}
	        else
	        	{
	        	   alert("Registration data not Sync!!");
	        	   closePopUp();
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
  /* function closePopUp()
  {
	    var hinIdForAdm=document.getElementById('hinIdForAdmission').value;
	    var flag=document.getElementById('flag').value;
	    var referred=document.getElementById('referred').value;
	    //alert(flag);
	    if(flag!=null && flag!="" && flag=="Visit")
	    {
	    	url = "/his/his/registration/registration?method=showVisitDetails&referred="+referred+"&hinId="+hinIdForAdm;
	    }
	    else
	    {
	    	url = "/his/his/adt/adt?method=searchPatientDetailsForAdmission&hinId="+hinIdForAdm;
	 
	    }
	    window.opener.location.href=url;
	    window.close();
  } */
  function fillNewHin(val,counter,db)
  {
	  var relation=val;
	  var serviceNo=document.getElementById('serviceNoForUpdate').value;
	  var serviceTypeId=document.getElementById('serviceTypeId').value;
	  var serviceStatusId=document.getElementById('serviceStatusId').value;
	  if(val!=0)
		  {
		     getNewHinNo(relation,serviceNo,serviceTypeId,serviceStatusId,counter,db);
		  }
	  else
		  {
		       if(db=='HMS')
		    	   {
		    	       document.getElementById('NewHMShinNo'+counter).value='';
		    	       document.getElementById('HMS'+counter).checked=false;
		    	   }
		       else
		    	   {
		    		   document.getElementById('NewHIShinNo'+counter).value='';
		    		   document.getElementById('HIS'+counter).checked=false;
		    	   }
		  }
  
  }
  function getNewHinNo(relation,serviceNo,serviceTypeId,serviceStatusId,counter,db)
  {
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
	        var NewHinNo  = item.getElementsByTagName('NewHinNo')[0];
	        if(db=='HMS')
	        	{
		       	 	document.getElementById('NewHMShinNo'+counter).value=NewHinNo.childNodes[0].nodeValue;

	        	}
	        else
	        	{
		        	document.getElementById('NewHIShinNo'+counter).value=NewHinNo.childNodes[0].nodeValue;

	        	}
	        	   
	   	} 
     }
   }
   var action='/hms/hms/registration?method=getNewHinNo&relationid='+relation+'&serviceNo='+serviceNo+'&serviceTypeId='+serviceTypeId+'&serviceStatusId='+serviceStatusId; 
   xmlHttp.open("POST",action,true);
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