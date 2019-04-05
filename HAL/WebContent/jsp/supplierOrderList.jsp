<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.net.URL"%>
<%
	 	Box box = HMSUtil.getBox(request);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	%>

<div class="titleBg">
<h2>Supply Order List</h2>
</div>
<form name="supplierOrderList" target="_blank" action="" method="post">
<div class="Block">
<div class="clear"></div>
<label>SO NO</label> 
<input type="text" id="SoNFrom" name="soNo" value="" class="textbox_date" MAXLENGTH="30" /> 
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('supplierOrderList','stores?method=generateSupplyOrderPrint');" />
<input type="reset"	name="Reset" id="reset" value="Reset" class="button" onclick="resetCurrentValues();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>