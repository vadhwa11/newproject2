<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascrip"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%
	String date = "";
	String time = "";
	int hospitalId = 0;
	Box box = HMSUtil.getBox(request);
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	Map map = new HashMap();
 	String userName ="";
 	String deptName = "";
 	String message = "";
 	
 	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
	}
		if (map.get("userName")!=null)
		userName = (String)map.get("userName");
		
		if (map.get("deptName")!=null)
		deptName = (String)map.get("deptName");
		
		List<UsergroupHospital> groupHospitalList=new ArrayList<UsergroupHospital>();
		if (map.get("groupHospitalList")!=null)
			groupHospitalList  = (List<UsergroupHospital>)map.get("groupHospitalList");
		
		List empGroupList=new ArrayList();
		if (map.get("empGroupList")!=null)
			empGroupList  = (List)map.get("empGroupList");
		
		if (map.get("message")!=null)
			message  = (String)map.get("message");

%>

<label>Application Group </label>
<select name="groupId" id="groupId"
	onchange="submitProtoAjaxWithDivName('changeOrderForm','superAdmin?method=getApplicationListForOrdering','testDiv')"
	class="large2">
	<option value="0">Select</option>
	<%  Iterator itr=groupHospitalList.iterator();
				while(itr.hasNext()){
			    	UsergroupHospital usergroupHospital= (UsergroupHospital) itr.next();
			    	String groupName=usergroupHospital.getGroup().getGroupName();
			    	int groupHospitalId=usergroupHospital.getId();
			    	int groupId=usergroupHospital.getGroup().getId();%>
	<option value=<%=groupId+","+groupHospitalId%>><%=groupName%></option>
	<%}%>
</select>

<div class="clear"></div>
<div id="testDiv"></div>
