<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasTherapyType"%>
<%
		Map<String, Object> map = new HashMap<String, Object>();
	List<MasAllergyType> allergyTypeList = new ArrayList<MasAllergyType>();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("allergyTypeList")!= null){
			allergyTypeList = (List<MasAllergyType>)map.get("allergyTypeList");
		}
		int counter = 0;
		if(map.get("counter") != null){
			counter = (Integer)map.get("counter");
		}
		
		MasAllergyType allergyType = allergyTypeList.get(0);
System.out.println("allergyTypeList==in response=="+allergyTypeList.size());
%>



<%@page import="jkt.hms.masters.business.MasAllergyType"%>
<input type="hidden" id="allergyId<%=counter %>" name="allergyId<%=counter %>" value="<%=allergyType.getId() %>" >
