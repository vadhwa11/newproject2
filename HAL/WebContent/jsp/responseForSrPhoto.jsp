<%@ page import ="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.UploadDocuments"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
	map=(Map<String, Object>)request.getAttribute("map");
}
List<Patient>documentList=new ArrayList<Patient>();
if(map.get("documentList") != null){
	documentList = (List<Patient>)map.get("documentList");
}

String imgSrc = "";
String imageDateTime = "";
if(documentList.size() > 0){
	for(int i=0;i<documentList.size();i++){
		String userHome = getServletContext().getRealPath("");
 		String fileSeparator = System.getProperty("file.separator");
 	//	String uploadURL = userHome.substring(0,userHome.lastIndexOf(fileSeparator))+fileSeparator+"photo"+fileSeparator;
 	//	String uploadURL = userHome+fileSeparator+"photo"+fileSeparator;
 		String uploadURL = request.getSession().getServletContext().getRealPath("/photo/");
 		if(documentList.get(0).getFileName()!=null){
 			Patient patient = new Patient();
 			patient = documentList.get(0);
 			System.out.println(uploadURL+"---jsp ---"+ request.getContextPath()+fileSeparator+"photo"+fileSeparator+patient.getFileName()+"."+patient.getImageFileExtension());
	 		String path=uploadURL+"/"+patient.getFileName();
	 		File f = new File(path);
 			if (f.exists()) {
 				//imgSrc = request.getSession().getServletContext().getRealPath("/photo/"+patient.getFileName()+"."+patient.getImageFileExtension());
 				imgSrc = request.getContextPath()+fileSeparator+"photo"+fileSeparator+patient.getFileName()+"."+patient.getImageFileExtension();
 			}else{
 				f.mkdir();
 				File someFile = new File(uploadURL+patient.getFileName()+"."+patient.getImageFileExtension());
 				FileOutputStream fos = new FileOutputStream(
 				someFile);
 				fos.write(patient.getPatientImage());
 				fos.flush();
 				fos.close();
 			imgSrc = request.getContextPath()+fileSeparator+"photo"+fileSeparator+patient.getFileName()+"."+patient.getImageFileExtension();
 				//imgSrc = request.getSession().getServletContext().getRealPath("/photo/"+patient.getFileName()+"."+patient.getImageFileExtension());
 			}
		 	imageDateTime = patient.getPatientImageDate()!=null?HMSUtil.convertDateToStringWithoutTime(patient.getPatientImageDate())+" "+patient.getPatientImageTime():"";
 		}
	}
}
 			System.out.println("imgSrc-- "+imgSrc);

%>


<%
if(!imgSrc.equals("")){
%>


<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%><input type="hidden" value="<%=imgSrc %>" name="img1"></input>

<img src="<%=imgSrc %>" name="img2" width="105" height="80" id="img1" />
<%=imageDateTime %>
<%}else{ %>
<img src="/hms/jsp/images/na.jpg" name="img1" width="105" height="80" id="img1" />
<span style="color:#707070">Date/ Time</span>
<%} %>
<div class="clear"></div>