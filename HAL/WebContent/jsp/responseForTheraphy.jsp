<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasTherapyType"%>
<%
		Map<String, Object> map = new HashMap<String, Object>();
	List<MasTherapyType> therapyTypeList  = new ArrayList<MasTherapyType>();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("therapyTypeList")!= null){
			therapyTypeList = (List<MasTherapyType>)map.get("therapyTypeList");
		}
		int counter = 0;
		if(map.get("counter") != null){
			counter = (Integer)map.get("counter");
		}
		
		MasTherapyType therapyType = therapyTypeList.get(0);
System.out.println("in response jsp tharaphyid======"+therapyType.getId());
%>


<input type="hidden" id="therapyId<%=counter %>" name="therapyId<%=counter %>" value="<%=therapyType.getId() %>" >
