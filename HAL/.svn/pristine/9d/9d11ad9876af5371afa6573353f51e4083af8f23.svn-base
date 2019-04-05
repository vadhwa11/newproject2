<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
		String hinNo="";
	try {
		if(request.getParameter("hinNo2")!=null){
			hinNo=request.getParameter("hinNo2");
		}
		String userHome = getServletContext().getRealPath("");
 		String fileSeparator = System.getProperty("file.separator");
 		//String uploadURL = userHome.substring(0,userHome.lastIndexOf(fileSeparator))+fileSeparator+"photo"+fileSeparator;
 		String uploadURL = userHome+fileSeparator+"photo";
        String filePath = uploadURL+fileSeparator+hinNo+".jpg";
        String path="";
        path=uploadURL+fileSeparator+hinNo;
        File f = new File(path);
		try {
			if (f.exists()) {
				System.out.println("Directory Ctereated");
				f.delete();
				f.mkdir();
			}else{
				f.mkdir();
			}
			 InputStream inputStream = request.getInputStream();
				OutputStream out3 = new FileOutputStream(filePath);
				byte[] buf = new byte[1024];
				int len;
				while ((len = inputStream.read(buf)) > 0)
					out3.write(buf, 0, len);
				out3.close();
				inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	} catch (Exception e) {
		System.out.println(e);
	}
%>
<jsp:forward page="/hms/registration?method=updatePatientImage">
	<jsp:param value="<%=hinNo%>" name="hinNo"/>
</jsp:forward>
