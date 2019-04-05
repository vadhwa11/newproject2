<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Users"%>  
<%@page import="jkt.hms.masters.business.Patient"%> 
<%@page import="jkt.hms.util.Box"%>  
<%@page import="jkt.hms.masters.business.PacsTemplate"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.math.BigDecimal"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>
<script type="text/javascript" src="/hms/jsp/js/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/wysiwyg-color.js"></script>
<script type="text/javascript" src="/hms/jsp/js/wysiwyg-settings.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>


<%--For AutoComplete Through Ajax--%>
<%@page import="javax.swing.text.StyledEditorKit.BoldAction"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<% 
/* URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in); */
%>
<!-- 
Attach the editor on the textareas
-->
<script type="text/javascript">
// Use it to attach the editor to all textareas with full featured setup
//WYSIWYG.attach('all', full);

// Use it to attach the editor directly to a defined textarea

WYSIWYG.attach('abc', full); // full featured setup

// Use it to display an iframes instead of a textareas
//WYSIWYG.display('all', full);  
</script>
<script type="text/javascript">
	 
<%
Calendar calendar=Calendar.getInstance();
String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
String dateCal=String.valueOf(calendar.get(Calendar.DATE));
int year=calendar.get(calendar.YEAR);
if(month.length()<2){
month="0"+month;
}
if(dateCal.length()<2){
dateCal="0"+dateCal;
}
%>
serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>
<%
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map map = new HashMap();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String  userName="";
	String browse="";
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<PacsTemplate> templateList = new ArrayList<PacsTemplate>();
	if(map.get("templateList") != null){
		templateList = (List<PacsTemplate>)map.get("templateList");
	}  
	
	if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
	}
	String message="";
	if(map.get("message") != null){
		message = (String)map.get("message"); 
	}
	 
%>
<script type="text/javascript">
   history.forward();
</script>
<!--main content placeholder starts here-->

<form name="PacsTemplates" method="post" enctype="multipart/form-data" action="">
	<div class="clear"></div>
	<h4><span><%=message %></span></h4>
	<div class="clear"></div>
	<div class="titleBg">
		<h2>Result Entry</h2>
	</div>
	
	<div class="clear"></div>  
	<!-- Block for Search templates -->
	<div class="Block"> 
		<label>Template Name</label>
 		  <input tabindex="1" type="text" value="" id="TemplateName" size="65" name="TemplateName"   style="width: 400px;"/>
 		  <div id="ac2update1" style="display: none;width: 400px;" class="autocomplete" ></div>
		  <script type="text/javascript" language="javascript" charset="utf-8"> 
				  new Ajax.Autocompleter('TemplateName','ac2update1','pacs?method=getTemplatesForAutoComplete',{minChars:1,parameters:'requiredField=TemplateName'});
	      </script>	
	     <input type="button" tabindex="1" onclick="searchFunction()" class="button" value="Search" name="search">
    </div>
   
  	<!-- Block for form deetails -->
	<div class="clear"></div>  
	<div class="Block"> 
		  <label><span>*</span>Template Code </label>
		  <%if(templateList.size()!=0){%> <input type="text" id="tempcode" name="tempcode" value="<%=templateList.get(0).getCode()%>"   maxlength="130" />
		  <%}else{ %> <input type="text" id="tempcode" name="tempcode"   maxlength="130" /> <%} %> 
		  
		  <label><span>*</span>Template Name </label>
		  <%if(templateList.size()!=0){%> <input type="text" id="tempname" name="tempname"  value="<%=templateList.get(0).getTemplateName()%>"  maxlength="130"/>
		   <%}else{ %><input type="text" id="tempname" name="tempname"   maxlength="130"/><%} %>
		  
		  <label><span>*</span>Type </label> 
         	  <select id="temptype" name="temptype" >
			  		<option value="0">----Select Template Type----</option>  
	               	<option value="XA">X-RAY</option> 
	               	<option value="CT">CT</option>
	               	<option value="MRI">MRI</option>
	               	<option value="USG">USG</option> 
	           </select>   
          <div class="clear"></div>
          <!-- for charge code list -->
          <!-- <label><span>*</span>Investigation Code</label>
 		  <input tabindex="1" type="text" value="" id="chargeCodeName" size="65" name="chargeCodeName"   style="width: 400px;"/>
 		  <div id="ac2update1" style="display: none;" class="autocomplete"></div>
		  <script type="text/javascript" language="javascript" charset="utf-8"> 
				  new Ajax.Autocompleter('chargeCodeName','ac2update1','opd?method=getInvestigationListForAutoComplete',{minChars:3,parameters:'requiredField=chargeCodeName&fromOpd=fromOpd'});
	      </script>	 -->
 	</div>
 	 
 	<div class="clear"></div> 
	<!--Rich text editor-->
	<div id="rtf" style="width: 100%">
 	  <%if(templateList.size()!=0){%> 	
 	  		<textarea value="" id="abc" name="abc" class="tableTextareaEditor"><%=templateList.get(0).getDescription() %></textarea>
	<%}else{ %>
		<textarea value="" id="abc" name="abc"  class="tableTextareaEditor"> </textarea>
	<%} %>		
	</div>
	
	 <%if(templateList.size()!=0){%> 	
	 	<input type="button" class="button"  value="Update" onclick="validateupdateform();" />
	 	<input type="text" name="tempid" id="tempid" value="<%=templateList.get(0).getId()%>" style="display: none;">
	 <%}else{ %>
	 	<input type="button" class="button"  value="Save" onclick="validateform();" />
	 	<input type="reset" class="buttonHighlight" value="Reset"/> 
	 <%} %>
	
	
	<div class="clear"></div> 
		<div class="bottom">
			<label>Changed By</label> <label class="value"><%=userName%></label> 
			<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
				Time</label> <label class="value"><%=time%></label>
		</div>
		<div class="clear"></div>
		<div class="paddingTop40"></div> <!--Bottom labels starts-->
</form>
<div class="clear"></div> 

<!--main content placeholder ends here-->

<script type="text/javascript">
function validateform()
{ 
	WYSIWYG.updateTextArea("abc"); 
	var tempcode= document.getElementById("tempcode").value;
	var tempname= document.getElementById("tempname").value;
	var temptype= document.getElementById("temptype").value;
	if(document.getElementById("tempcode").value==""  || document.getElementById("tempcode").value==" "){
		alert("Please Enter Template Code!!");
		document.getElementById("tempcode").focus();
		return false;
	}
	else if(document.getElementById("tempname").value==""  || document.getElementById("tempname").value==" "){
		alert("Please Enter Template Name!!");
		document.getElementById("tempname").focus();
		return false;
	}
	else if(document.getElementById("temptype").value=="0"){
		alert("Please Select Template Type!!");
		document.getElementById("temptype").focus();
		return false;
	} 
	else{
		submitForm("PacsTemplates","pacs?method=submitPacsTemplate&tempcode="+tempcode+"&tempname="+tempname+"&temptype="+temptype);
	}  
}

function searchFunction()
{  
	var tempname= document.getElementById("TemplateName").value; 
	if(document.getElementById("TemplateName").value==""  || document.getElementById("TemplateName").value==" "){
		alert("Please Enter Template Name!!");
		document.getElementById("TemplateName").focus();
		return false;
	} 
	else{ 
		submitForm("PacsTemplates","pacs?method=searchtemplates&tempname="+tempname);
	}  
}

function validateupdateform()
{
	WYSIWYG.updateTextArea("abc"); 
	var tempcode= document.getElementById("tempcode").value;
	var tempname= document.getElementById("tempname").value;
	var temptype= document.getElementById("temptype").value;
	var tempid= document.getElementById("tempid").value;
	if(document.getElementById("tempcode").value==""  || document.getElementById("tempcode").value==" "){
		alert("Please Enter Template Code!!");
		document.getElementById("tempcode").focus();
		return false;
	}
	else if(document.getElementById("tempname").value==""  || document.getElementById("tempname").value==" "){
		alert("Please Enter Template Name!!");
		document.getElementById("tempname").focus();
		return false;
	}
	else if(document.getElementById("temptype").value=="0"){
		alert("Please Select Template Type!!");
		document.getElementById("temptype").focus();
		return false;
	} 
	else{
		submitForm("PacsTemplates","pacs?method=updatePacsTemplate&tempcode="+tempcode+"&tempname="+tempname+"&temptype="+temptype+"&tempid="+tempid);
	}  
}

<%if(templateList.size()!=0){%> 	
	<%if(templateList.get(0).getTemplateType().equals("XA")){%>
		document.getElementById("temptype").value = "XA";
	<%}else if(templateList.get(0).getTemplateType().equals("CT")){%>	
		document.getElementById("temptype").value = "CT";
	<%}else if(templateList.get(0).getTemplateType().equals("MRI")){%>
		document.getElementById("temptype").value = "MRI";
	<%}else if(templateList.get(0).getTemplateType().equals("USG")){%>
		document.getElementById("temptype").value = "USG";
	<%}%>
<%}%>
 
</script>
<style>
.iframeText{
	height: 350px;
}	
</style>
