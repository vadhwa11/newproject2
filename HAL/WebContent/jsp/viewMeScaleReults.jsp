<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Collections"%>
<%@page import="jkt.hms.util.Box"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.masters.business.MasStoreMeScale"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />
<script type="text/javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<%
  Map<String,Object> map = new HashMap<String,Object>(); 
  List<MasStoreMeScale>meScaleDescriptionList = null;
  List<MasStoreItem> MeScaleDescriptionList2 = null;
      MasStoreMeScale masStoreMeScale = null;
     String includedJsp = null;
  String previousPage="no";
  int pageNo=1;
  Box box=HMSUtil.getBox(request);
    HashMap[] gridData =null;
  PagedArray pagedArray = null;
  String userName = "";
  String PvmsNo="";
  int ItemId = 0;
  if(request.getAttribute("map") != null)
  {
  map = (Map) request.getAttribute("map");
  pagedArray = (PagedArray) map.get("pagedArray");
  System.out.println("box values " + box);
  System.out.println("map values " + map);
  }
  if(request.getAttribute("map") != null){
   map = (Map) request.getAttribute("map");
  }
  Map<String,Object> utilMap = new HashMap<String,Object>();
  utilMap = (Map)HMSUtil.getCurrentDateAndTime();
  String date = (String)utilMap.get("currentDate");  
  String time = (String)utilMap.get("currentTime");
  String title=(String)map.get("title");
     MasStoreItem masStoreItem =null;
   MeScaleDescriptionList2 = (ArrayList)map.get("MeScaleDescriptionList2");
  System.out.println("MeScaleDescriptionList2"
+MeScaleDescriptionList2.size());
   for(int i = 0 ; i<MeScaleDescriptionList2.size();i++)
  masStoreItem= (MasStoreItem)MeScaleDescriptionList2.get(i);
  System.out.println("MeScaleDescriptionList2"
+masStoreItem.getId());
  Vector<HashMap> meScaleItems= null;
  if (request.getAttribute("map") != null) 
  {
  map = (Map) request.getAttribute("map");
  if (map.get("items_to_be_sent")!=null)
  meScaleItems = (Vector)map.get("items_to_be_sent");
  pagedArray = (PagedArray)map.get("pagedArray");
  MeScaleDescriptionList2 =   (ArrayList)map.get("MeScaleDescriptionList2");
    }
  if(session.getAttribute("userName") != null){
  userName = (String)session.getAttribute("userName");
   if(map.get("message") != null){
  String message = (String)map.get("message");
  out.println(message);
   }
   System.out.println("MeScaleDescriptionList2in view >>>>>>>>.."+MeScaleDescriptionList2.size());
   }
     String meScaleDesc= null;
    if(request.getAttribute("map") != null){
   map = (Map) request.getAttribute("map");
    }
    List  meScaleDescription = null;
  meScaleDescription=(List)map.get("MeScaleDescriptionList");
  masStoreMeScale= (MasStoreMeScale)meScaleDescription.get(0);
  meScaleDesc= masStoreMeScale.getMeScaleDescription();
   %>

<div id="testDiv"><label class="bodytextB">MeScaleDescription:
</label> <input type="text" name="<%=ME_SCALE_DESCRIPTION %>"
	value="<%=meScaleDesc%>" class="medcaption" readonly="readonly" />
<div style="float: left; padding-left: 15px; padding-bottom: 10px;">
<label class="bodytextB">Page No:</label>
<div class="changebydt" style="width: 65px;"><%=pageNo%></div>
</div>
<br />
<br>
<br />

<% if (pagedArray == null) { %>
<div
	style="overflow: hidden; width: 100%; height: 220px; padding-left: 9px;">
<table width="100%" colspan="7" id="viewMeScale" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="10%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Old
			PVMSNo</label></td>
			<td width="18%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="10%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="10%">
			<td><label valign="left" class="smalllabel">Section</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Quantity</label></td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=8>No Data Found</td>
		</tr>
	</tbody>
</table>
</div>
<% } else { %>
<div
	style="overflow: hidden; width: 100%; height: 220px; padding-left: 9px;">
<table width="100%" colspan="7" id="viewMeScale" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="10%"><label valign="left" class="smalllabel">SR
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Old
			PVMSNo</label></td>
			<td width="18%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="10%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="10%"><label valign="left" class="smalllabel">Section</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Quantity</label></td>
		</tr>
	</thead>
	<tbody>
		<td width="10%"><input type="text" name="<%=SR_NO %>" value=""
			class="medcaption" size="2" readonly="readonly" /></td>
		<td width="10%"><input type="text" name="<%=PVMS_NO %>" value=""
			class="medcaption" size="8" readonly="readonly" /></td>
		<td width="10%"><input type="text" name="<%=OLD_NIV_NO %>"
			value="" class="smcaption" size="8" readonly="readonly" /></td>
		<td width="18%"><input type="text" name="<%=NOMENCLATURE  %>"
			value="" class="medcaption" size="8" readonly="readonly" /></td>
		<td width="10%"><input type="text" name="<%=AU%>" value=""
			class="medcaption" size="8" readonly="readonly" /></td>
		<td width="10%"><input type="text" name="<%=SECTION_ID %>"
			value="" class="medcaption" size="8" readonly="readonly" /></td>
		<td width="10%"><input type="text" name="<%=QTY %>" value=""
			class="medcaption" /></td>
		</tr>
		</thead>
		<tbody>
			<%
       gridData = (HashMap[])pagedArray.getPagedArray();
    int iFirstRow = pagedArray.getFirstRowIdx();
       for(int i=0;i<gridData.length;i++)
       { %>
			<tr>
				<td width="5%"><input type="text" value="<%=iFirstRow++%>"
					class="smcaption" name="srno" readonly="readonly" /></td>
				<td width="10%"><input type="text"
					value="<%=gridData[i].get("pvms")%>" class="medcaption" name="pvms"
					readonly="readonly" /></td>
				<td width="10%"><input type="text"
					value="<%=gridData[i].get("oldPvms")%>" class="medcaption"
					name="oldPvms" readonly="readonly" /></td>
				<td width="40%"><input type="text"
					value="<%=gridData[i].get("nomenclature")%>" class="bigcaption"
					name="nomenclature" readonly="readonly" /></td>
				<td width="12%"><input type="text"
					value="<%=gridData[i].get("au")==null?"":gridData[i].get("au")%>"
					class="medcaption" name="au" readonly="readonly" /></td>
				<td width="12%"><input type="text"
					value="<%=gridData[i].get("mmf")%>" name="mmf"
					validate="mmf,float,no" readonly="readonly" /></td>
				<td width="10%"><input type="text"
					value="<%=gridData[i].get("section")%>" name="section"
					validate="section Qty,string,no" /></td>
			</tr>
			<% } %>
			<tr class="locatorArrow">
				<td colspan=8 align="center"><%= pagedArray.showIndex()%> <%=pagedArray.getPageIndexHiddenTag()%>
				</td>
			</tr>
		</tbody>
</table>
</div>
<% } %> <label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>
<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>
<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>
</form>
</div>
</div>