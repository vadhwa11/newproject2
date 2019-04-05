
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<ul>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	if(request.getAttribute("map")!=null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	String masterName = (String)map.get("masterName");
	if(map.get("masStoreBrandList")!=null){
		List<MasStoreBrand> masStoreBrandList = (List<MasStoreBrand>)map.get("masStoreBrandList");
		for(MasStoreBrand masStoreBrand:masStoreBrandList){
			out.write("<li style='width: auto;'>"+masStoreBrand.getBrandName()+"["+masStoreBrand.getId()+"]"+"</li>");
		}
	}
		 if(map.get("masManufacturerList")!=null){
			List<MasManufacturer> masManufacturerList = (List<MasManufacturer>)map.get("masManufacturerList");
			for(MasManufacturer masManufacturer:masManufacturerList){
				out.write("<li style='width: auto;'>"+masManufacturer.getManufacturerName()+"["+masManufacturer.getId()+"]"+"</li>");
			}
	}
%>
</ul>