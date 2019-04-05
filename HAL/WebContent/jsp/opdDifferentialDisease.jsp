<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap=(Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

%>

<form name="opdDifferentialDisease" method="post">
<%
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		  <h4><span><%=message %></span></h4>
		 
<% }%>

<div class="titleBg"><!-- start of titleBg -->
<h2>OPD Differential Disease</h2>
</div><!-- end of titleBg -->

<div class="clear"></div>


<div class="Block"><!-- start of Block -->
<label>Differential Disease Name</label>
<input type="text" name="<%=DIFFERENTIAL_DISEASE_NAME %>" class="auto" size="84" tabindex="1" id="differentialDiseaseName" value="" maxlength="500"/>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<label>SYNONYMS</label>

<textarea  name="<%=SYNONYMS %>" class="large" cols="0" rows="0" tabindex="1" id="<%=SYNONYMS %>" value="" maxlength="500" onkeyup="return ismaxlength(this)"></textarea>

<div class="clear"></div>
<label>SIGN SYMPTOMS</label>
<textarea  name="<%=SIGN_SYMPTOMS %>" class="large" cols="0" rows="0" tabindex="1" id="<%=SIGN_SYMPTOMS %>" value="" maxlength="500" onkeyup="return ismaxlength(this)"></textarea>

<div class="clear"></div>
<label>INVESTIGATION</label>
<textarea  name="<%=INVESTIGATION %>" class="large" cols="0" rows="0" tabindex="1" id="<%=INVESTIGATION %>" value="" maxlength="500" onkeyup="return ismaxlength(this)"></textarea>


<div class="clear"></div>
<label>TREATMENTS</label>
<textarea  name="<%=TREATMENTS %>" class="large" cols="0" rows="0" tabindex="1" id="<%=TREATMENTS %>" value="" maxlength="500" onkeyup="return ismaxlength(this)"></textarea>

<div class="clear"></div>
<label>DRUGS</label>
<textarea  name="<%=DRUGS %>" class="large" cols="0" rows="0" tabindex="1" id="<%=DRUGS %>" value="" maxlength="500" onkeyup="return ismaxlength(this)"></textarea>


<div class="clear"></div>
<label>SURGERY</label>
<textarea  name="<%=SURGERY %>" class="large" cols="0" rows="0" tabindex="1" id="<%=SURGERY %>" value="" maxlength="500" onkeyup="return ismaxlength(this)"></textarea>


<div class="clear"></div>
<label>OTHER_ADVICE</label>
<textarea  name="<%=OTHER_ADVICE %>" cols="0" class="large" rows="0" tabindex="1" id="<%=OTHER_ADVICE %>" value="" maxlength="500" onkeyup="return ismaxlength(this)"></textarea>

</div><!-- end of block -->

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" name="Submit11" value="Submit" class="button" tabindex="1" onClick="submitForm('opdDifferentialDisease','/hms/hms/opdMaster?method=submitDifferentialDisease');" />
<input type="reset" name="Reset" value="Reset" class="button" tabindex="1" onclick="location.reload();" accesskey="r" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>

<div class="bottom"><!-- start of bottom -->

<label>Changed By</label> 
<label class="value"><%=userName%></label> 

<label>Changed Date</label> 
<label class="value"><%=currentDate%></label> 

<label>Changed Time</label> 
<label class="value"><%=currentTime%></label> 

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" />

</div><!-- end of bottom -->
</form>
