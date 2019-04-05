<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchicon.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>

<script>
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
Map map = new HashMap();
Map<String,String> userlogin = new HashMap<String,String>();
List<String> UserNameList = null;
List<String> UserIpList = null;
List<String> SessionIdList = null;
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
List<String> username = new ArrayList<String>();
List<String> UserIp = new ArrayList<String>();
if(map.get("UserName")!=null)
{
	username=(List<String>)map.get("UserName");
}
if(map.get("UserIp")!=null){
	UserIp=(List<String>)map.get("UserIp");
	
}
if(map.get("UserNameList")!=null){
	UserNameList=(List<String>)map.get("UserNameList");
}
if(map.get("UserIpList")!=null){
	UserIpList=(List<String>)map.get("UserIpList");
}
if(map.get("SessionIdList")!=null){
	SessionIdList=(List<String>)map.get("SessionIdList");
}
System.out.println("UserNameList::"+UserNameList.size());
%>



<div class="titleBg">
<h2>User Name And It's IP Address</h2>
</div>
<%if(UserNameList!=null && UserIpList!=null && SessionIdList!=null){
if(SessionIdList.size()==UserIpList.size() && UserIpList.size()==UserNameList.size() && UserNameList.size()==SessionIdList.size()){
for(int i=0;i<SessionIdList.size();i++){
%>
<div class="clear"></div>
<div class="Block">
<label>User Name</label>
<label class="value">&nbsp;&nbsp;<%=(String)UserNameList.get(i)%></label>
<label>&nbsp;IP Address</label>
<div class="paddLeft55">
<label class="value paddLeft25">&nbsp;&nbsp;&nbsp;<%=(String)UserIpList.get(i) %></label>
<div class="clear"></div>

</div>
</div>
<%}}}%>
