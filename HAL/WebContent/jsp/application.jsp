<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * application.jsp  
 * Purpose of the JSP -  This is for  Application Master.
 * @author Abha
 * Create Date: 16 June,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.math.BigInteger"%>
<%@page import="jkt.hms.masters.business.MasApplication"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.UsergroupHospital"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.math.BigDecimal"%>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script>
function displayNewGroup(){
				var group = document.getElementById('groupId').value;
				 if(group == 'new'){
						document.getElementById('newGroupDiv').style.display = 'inline';
					
					}else{
						document.getElementById('newGroupDiv').style.display = 'none';
					}
				
			}
	function displayNewSubGroup(){
				var subGroup = document.getElementById('subGroupId').value;
				 if(subGroup == 'new'){
						document.getElementById('newSubGroupDiv').style.display = 'inline';
					
					}else{
						document.getElementById('newSubGroupDiv').style.display = 'none';
					}
				
			}		
			
 function enterParentId(){

if(document.getElementById('parentId').value =='0'){
document.getElementById('url').value ="#"
document.getElementById('url').disabled = true;

} else{
document.getElementById('url').value="";
document.getElementById('url').disabled =false;
}
}

function fillUrl() {
var val =document.getElementById("applicationName").value
  	  var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var id = val.substring(index1,index2);
	    if(id !=""){
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
	       var empName  = item.getElementsByTagName("url")[0];
	       var sp = new Array();
	       	sp  = empName.childNodes[0].nodeValue.split("'");
	       var Finalurl = "";
	       for(var m=0; m<sp.length;m++)
		   {
		    if((sp.length-1) != m){
		       Finalurl = Finalurl+sp[m]+"&";
	        }else{
	           Finalurl = Finalurl+sp[m];
	        }
	       }
	      // document.getElementById("url").value=empName.childNodes[0].nodeValue
	      document.getElementById("url").value = Finalurl; 
	   } 
      }
    }
   var url="/hms/hms/user?method=getUrl&appId="+id
     
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
				}
  }
  
 function getparent(){
   var val =document.getElementById("prId").value
  	  var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var id = val.substring(index1,index2);
	    if(id !="" && id !="0"){
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
       
		obj =document.getElementById("subPrId"); 
		obj.length = 1;
		for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var application = item.getElementsByTagName("masApplicationLists")[0];
	      for(innerLoop = 0;innerLoop < application.childNodes.length;innerLoop++){
        		var app = application.childNodes[innerLoop];
	        	var appId  = app.getElementsByTagName("masApplicationId")[0];
	        	var appName  = app.getElementsByTagName("masApplicationName")[0];
	        	obj.length++;
				obj.options[obj.length-1].value=appId.childNodes[0].nodeValue;
				obj.options[obj.length-1].text=appName.childNodes[0].nodeValue;
	        }
      	}
      	//var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	  	//for (loop = 0; loop < items.childNodes.length; loop++) {
	   //	    var item = items.childNodes[loop];
	    //   var empName  = item.getElementsByTagName("url")[0];
	   //    document.getElementById("url").value=empName.childNodes[0].nodeValue
	  // } 
      }
    }
   
   var url="/hms/hms/user?method=getSubParentApplication&parentId="+id
     
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
	}
 
 }
</script> <%
	
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
	map = (Map<String,Object>) request.getAttribute("map");
	}
	String applicationId="";
	String parentId="";
	String parentName="";
	if(request.getParameter(APPLICATION_ID) != null && !(request.getParameter(APPLICATION_ID).equals(""))){
		applicationId = request.getParameter(APPLICATION_ID);
	}
	List<MasApplication> applicationList = new ArrayList<MasApplication>();
	if(map.get("applicationList") != null)
	{
	applicationList = (List<MasApplication>)map.get("applicationList");
	
	}
	
	List objectList = new ArrayList();
	if(map.get("objectList") != null){
	objectList = (List<MasApplication>)map.get("objectList");
	}
	int number;
	Object[] pair = (Object[]) objectList.get(objectList.size()-1);
//	BigInteger lastNo = (BigInteger) pair[0];
	Integer lastNo = (Integer) pair[0];
	//Integer lastNo = (Integer.parseInt((String)pair[0])) ;
	number=lastNo.intValue();
	int lastNumber=number+1;
	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
	if(map.get("hospitalList") != null){
	hospitalList = (List<MasHospital>)map.get("hospitalList");
	}
	List<UsergroupHospital> groupList= new ArrayList<UsergroupHospital>();
	if(map.get("groupList") != null){
	groupList = (List<UsergroupHospital>)map.get("groupList");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	int nextID = applicationList.size()+1; 
	
	String message="";
	if(map.get("message") != null){
	message = (String)map.get("message");	
	}
	%>

<div class="titleBg"><h2>Add Forms/ Reports</h2></div>
<div class="Clear"></div>
<form name="application" method="post" action="">
<div class="Block"><label><span>*</span> Application Id </label> 
<input type="text" name="<%= APPLICATION_ID%>"
	value="<%="A"+lastNumber%>" tabindex=1 readonly="readonly" validate="Application Id,string,no" MAXLENGTH="6" /> 
	<label class="noWidth"><span>*</span> Application Name</label> 
	<input type="text" validate="Application Name,string,yes" class="large2" tabindex=1 name="applicationName" id="applicationName" onblur="fillUrl();" />
<div id="ac2update"  style="display: none;" class="autocomplete"></div>

<script type="text/javascript" language="javascript" charset="utf-8">
	  new Ajax.Autocompleter('applicationName','ac2update','user?method=getApplicationForAutoComplete',{parameters:'applicationName='+this.value});
	</script>
<div class="Clear"></div>

<label><span>*</span> Parent Id </label> 
<input type="text" validate="Parent Name,string,yes" class="large2" tabindex=1 name="prId"
	id="prId" onblur="getparent();" />
<div id="ac2update" style="display: none;" class="autocomplete"></div>

<script type="text/javascript" language="javascript" charset="utf-8">
	  new Ajax.Autocompleter('prId','ac2update','user?method=getParentApplication',{parameters:'prName='+this.value});
	</script>
	
<label>Sub Parent Id </label> 
<select id="subPrId" name="subPrId" tabindex=1 validate="Sub Parent,string,no" tabindex=1>
	<option value="">Select SubParent</option>
</select>
<div class="Clear"></div>

<%-- <label><span>*</span> Hospital Name</label>
 <select id="hospitalId" name="<%=HOSPITAL_ID%>" class="large2" tabindex=1 validate="Hospital Name,string,no">
	<option value="">Select Hospital Name</option>
	
	<!-- to display hospital list -->
	<%
		int hospitalId = 0;
		hospitalId = (Integer)session.getAttribute("hospitalId");
		for (MasHospital masHospital :hospitalList ) {
			if(masHospital.getId() == hospitalId){
		%>
	<option value=<%=masHospital.getId()%> ><%=masHospital.getHospitalName()%></option>
	<%}
		}
	%>
	<!--  end of for loop -->
</select>
<div class="Clear"></div>

<label><span>*</span> Group Name</label> <select name="<%=GROUP_ID%>"
	class="large2" id="groupId" validate="Group Name,string,yes" tabindex=1
	onchange="displayNewGroup();">
	<option value="">Select Group Name</option>
	
	<!-- to display hospital list -->
	<%
		for (UsergroupHospital usergroupHospital :groupList ) {
		%>
	<option value=<%=usergroupHospital.getGroup().getId()%>><%=usergroupHospital.getGroup().getGroupName()%></option>
	<%}
	%>
	<!--  end of for loop -->
</select>

<div id="newGroupDiv" style="display: none"><label> <span>*</span>New Group</label>
 <input id="newGroupId" class="large" type="text" name="newGroupId" validate="New Group,string,no" maxlength="30"
	tabindex="1" /></div>
<div class="Clear"></div> --%>

<label><span>*</span> URL</label> 
<input type="text" name="<%=URL%>" class="large2" value="" id="url" validate="URL,string,yes" MAXLENGTH="200" tabindex=1 readonly="readonly" /> <!-- 
	<label > <span>*</span>Order No:</label>
	<input type="text" name="<%= ORDER_NO %>" value="" id="orderNo" validate="Order No,int,yes" MAXLENGTH="3" tabindex=1 />
 
  --> <script>
   document.application.<%=APPLICATION_NAME%>.focus();
   </script> 
   
   <label>Status </label> 
   <label class="auto">Active</label>
    <input name=<%=STATUS  %> type="radio" class="radioAuto" tabindex=1 value="y" checked="checked" /> 
	<label class="auto">Inactive</label>
	 <input type="radio" name="<%=STATUS %>" value="n" tabindex=1 class="radioAuto" />

<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div class="paddingTop15"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="if(checkSave()){submitForm('application','user?method=addApplication','checkBlankForAddApplication');}"
	accesskey="a" tabindex=1 /> 
<input type="button" name="add" id="addbutton" value="Edit" class="button" onClick="submitFormForButton('application','user?method=searchAndEditApplication');"
	accesskey="e" tabindex=1 /> 
<input type="button" name="Back" value="Back" class="button" accesskey="b" onclick="submitFormForButton('application','superAdmin?method=showModuleManagementJsp')" tabindex=1 />
<div class="Clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By:</label>
 <label class="value">admin</label>
 <label>Changed Date:</label>
 <label class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="admin" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
	
</form>
