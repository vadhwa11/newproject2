
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasApplication"%>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	List<MasApplication> applicationList= new ArrayList<MasApplication>();
	if(map.get("applicationList") != null){
		applicationList = (List<MasApplication>)map.get("applicationList");
	}
	
	List<MasApplication> allApplicationList= new ArrayList<MasApplication>();
	if(map.get("allApplicationList") != null){
		allApplicationList = (List<MasApplication>)map.get("allApplicationList");
	}
	//System.out.println("Size of aplication list-----"+applicationList.size());
	%>

<ul>
	<%	if(applicationList.size() !=0){
		for(MasApplication application1 : applicationList){
			if(!application1.getParentId().equals("0")){
				String parentId=application1.getParentId();
				//System.out.println("parent id==="+parentId+"---application id---"+application1.getId());
				for(MasApplication applicationObj2 : allApplicationList){
					if(applicationObj2.getId().equals(parentId)){
						//System.out.println("applicationObj2 becomes equal with parentid--"+applicationObj2.getId());
						String appName=applicationObj2.getName();
						
					%>
	<li style="width: auto;"><%=application1.getName()+"["+application1.getId()+"]"%>--<%=appName %></li>
	<%		
						
					}
				}
			}else{
			%>
	<li style="width: auto;"><%=application1.getName()+"["+application1.getId()+"]"%></li>

	<%  
		}}}else{%>
	<li style="width: auto;">----------No applications
	found-------------</li>
	<%} %>
</ul>
