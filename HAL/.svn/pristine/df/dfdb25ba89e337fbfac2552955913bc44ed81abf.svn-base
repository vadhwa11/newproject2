package jkt.hms.mrd.controller;

import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.LOGIN_NAME;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.mrd.handler.MRDHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MRDController extends MultiActionController {

	MRDHandlerService mrdHandlerService = null;

	public MRDHandlerService getMrdHandlerService() {
		return mrdHandlerService;
	}

	public void setMrdHandlerService(MRDHandlerService mrdHandlerService) {
		this.mrdHandlerService = mrdHandlerService;
	}

	/**
	 * ------------------------------- CODE ---------------------------------
	 */

	Map<String, Object> map = new HashMap<String, Object>();
	String jsp = null;
	String title = null;

	/**
	 * ----------------------UPLOAD DOCUMENTS ---------------------------------
	 */

	public ModelAndView showUploadingDocumentsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int visitId = Integer.parseInt(request.getParameter("visitId"));
		map = mrdHandlerService.showUploadingDocumentsJsp(visitId);
		jsp = "mrd_uploadpatientdoc" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView viewPatientDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId;
		String userName = "";
		String jsp = "";
		String inputField = "";
		String flag = "";
		String flag1 = "";

		MultipartFormDataRequest mrequest = null;
		Box box = HMSUtil.getBox(request);
		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {

				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (mrequest.getParameter("inputField") != null
					&& !(mrequest.getParameter("inputField").equals(""))) {
				inputField = mrequest.getParameter("inputField");
			}

			if (mrequest.getParameter("flag") != null
					&& !(mrequest.getParameter("flag").equals(""))) {
				flag = mrequest.getParameter("flag");
			}
			if (mrequest.getParameter("flag1") != null
					&& !(mrequest.getParameter("flag1").equals(""))) {
				flag1 = mrequest.getParameter("flag1");
				if (mrequest.getParameter("hinNo") != null)
					inputField = mrequest.getParameter("hinNo");
				else
					inputField = mrequest.getParameter("adNo");
			}
		} else {

			if (request.getParameter("inputField") != null
					&& !(request.getParameter("inputField").equals(""))) {
				inputField = request.getParameter("inputField");
			}

			if (request.getParameter("flag") != null
					&& !(request.getParameter("flag").equals(""))) {
				flag = request.getParameter("flag");
			}
			if (request.getParameter("flag1") != null
					&& !(request.getParameter("flag1").equals(""))) {
				flag1 = request.getParameter("flag1");
				removeFilesInUploadFolder(request, response);
				if (request.getParameter("fieldValue") != null)
					inputField = request.getParameter("fieldValue");
				else
					inputField = request.getParameter("fieldValue");
			}
		}

		map.put("inputField", inputField);
		map.put("flag", flag);
		map.put("flag1", flag1);

		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
		String uploadURL = getServletContext().getRealPath("/upload/");
		File urlName = new File(getServletContext().getRealPath("/upload/"));
		String getPathName = urlName.getPath();

		map.put("uploadURL", uploadURL);
		map = mrdHandlerService.viewPatientDetails(map);

		if (flag.equals("upload") && !flag1.equals("viewDocuments")) {
			jsp = "mrd_uploadpatientdoc";
			jsp += ".jsp";
			title = "Cancel for Patient Appointments";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		} else if (flag.equals("view")) {
			jsp = "mrdViewPatientDoc";
			jsp += ".jsp";
			title = "Cancel for Patient Appointments";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		} else {
			jsp = "mrdViewDocumentsPopUp";
			// jsp += ".jsp";
			title = "Cancel for Patient Appointments";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView(jsp, "map", map);
		}

	}

	public ModelAndView submitUploadDocuments(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		MultipartFormDataRequest mrequest = null;
		String fileName = null;
		String message = null;
		String fileExtension = null;
		int hospitalId;
		String userName = "";
		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {

				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}

		Map<String, Object> uploadFileMap = new HashMap<String, Object>();
		// Vector noOfFiles=box.getVector(UPLOAD_FILENAME);

		String uploadURL = getServletContext().getRealPath("/upload/");
		List fileUploadedList = null;
		// //System.out.println("noOfFiles.size()=="+noOfFiles.size());
		int i = 1;
		for (i = 1; i <= 5; i++) {
			if (!request.getParameter("filename" + i).equals("")) {
				StringTokenizer strToken = new StringTokenizer(request
						.getParameter("filename" + i), ".");

				fileName = strToken.nextToken();
				fileExtension = strToken.nextToken();

				String whiteList = "*." + fileExtension;

				// Long fileSizeLimit = 2097152l;
				// RequestConstants.UPLOAD_FILENAME=box.getString("filename"+i);

				fileUploadedList = HMSUtil.uploadFile(mrequest, uploadURL,
						whiteList, request.getParameter("filename" + i), i);
				box.put("filename" + i, request.getParameter("filename" + i));
				box.put("description" + i, mrequest.getParameter("description"
						+ i));
			} else {
				box.put("filename" + i, "0");
			}
		}
		if (mrequest.getParameter("hin") != null)
			box.put("hinId", mrequest.getParameter("hin"));
		else
			box.put("hinId", 0);
		if (mrequest.getParameter("inpatientId") != null)
			box.put("inpatientId", mrequest.getParameter("inpatientId"));
		else
			box.put("inpatientId", 0);
		box.put("patientName", mrequest.getParameter("patientName"));
		box.put("sex", mrequest.getParameter("sex"));
		box.put("age", mrequest.getParameter("age"));
		if (mrequest.getParameter("address") != null)
			box.put("address", mrequest.getParameter("address"));
		Boolean fileUploaded = false;
		if (fileUploadedList != null && fileUploadedList.size() != 0) {
			fileUploaded = (Boolean) fileUploadedList.get(0);
		}
		box.put("uploadURL", uploadURL);
		map = mrdHandlerService.submitUploadDocuments(box);
		if (map.get("dataSaved").equals(true)) {
			message = "File Uploaded Sucessfully!!";
		} else {
			message = "Data Cannot be Saved !!";
		}
		map.put("message", message);
		jsp = "mrd_uploadpatientdoc";
		jsp += ".jsp";
		title = "Upload Documents";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView viewPatientDocuments(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		String filename = null;
		String fileExtension = null;
		MultipartFormDataRequest mrequest = null;

		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Map<String, Object> uploadFileMap = new HashMap<String, Object>();

		String uploadURL = getServletContext().getRealPath("/upload/");

		// String whiteList = "*.zip";
		// String whiteList = "*.jpg";

		// Long fileSizeLimit = 2097152l;

		/*
		 * List fileUploadedList = null; fileUploadedList =
		 * HMSUtil.uploadFile(mrequest,uploadURL, whiteList,
		 * box.getString("filename"));
		 * //System.out.println("fileUploadedList="+fileUploadedList.size());
		 * Boolean fileUploaded=false; if(fileUploadedList != null &&
		 * fileUploadedList.size()!=0) { fileUploaded = (Boolean)
		 * fileUploadedList.get(0); }
		 */
		//System.out.println("uploadURL==" + uploadURL);
		box.put("uploadURL", uploadURL);
		StringTokenizer st1 = new StringTokenizer(box.getString("filename"),
				".");
		filename = st1.nextToken();
		fileExtension = st1.nextToken();

		//System.out.println("box.getString(filename)==" + filename + "."+ fileExtension);
		box.put("filename", box.getString("filename"));
		// map = mrdHandlerService.viewUploadDocuments(box);
		try {
			if (fileExtension == "doc" || fileExtension == "docx") {
				response.setContentType("application/vnd.ms-word");
			} else if (fileExtension == "xls" || fileExtension == "xlsx") {
				response.setContentType("application/vnd.ms-excel");
			} else if (fileExtension == "pdf") {
				response.setContentType("application/pdf");
			} else if (fileExtension.trim().equalsIgnoreCase("txt")) {
				response.setContentType("text/plain");
			} else if (fileExtension.trim().equalsIgnoreCase("ppt")) {
				response.setContentType("application/ppt");
			} else if (fileExtension == "png") {
				response.setContentType("image/png");
			} else if (fileExtension == "jpeg") {
				//System.out.println("enteres JPEG");
				response.setContentType("image/jpeg");
			} else if (fileExtension == "wbmp") {
				response.setContentType("image/vnd.wap.wbmp");
			} else if (fileExtension == "gif") {
				response.setContentType("image/gif");
			} else if (fileExtension == "jpg") {
				//System.out.println("eneterd JPG");
				response.setContentType("image/jpg");
			} else {
				response.setContentType("application/octet-stream");
			}
			// set the header and also the Name by which user will be prompted
			// to save
			response.setHeader("Content-Disposition", "attachment;filename="
					+ java.net.URLEncoder.encode(box.getString("filename"))
					+ "");

			//System.out.println("box.getString(filename)==" + filename + "."+ fileExtension);
			// response.setContentType("image/"+fileExtension);
			// response.setHeader("Content-Disposition",
			// "attachment; filename="+filename+"."+fileExtension);

			File f = new File(uploadURL + "/" + filename + "." + fileExtension);
			InputStream in = new FileInputStream(f);
			response.getOutputStream().flush();
			ServletOutputStream outs = response.getOutputStream();

			long length = f.length();

			if (length > Integer.MAX_VALUE) {
				// File is too large
			}

			// Create the byte array to hold the data
			byte[] bytes = new byte[(int) length];

			int offset = 0;
			int numRead = 0;
			while (offset < bytes.length
					&& (numRead = in.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
			}

			if (offset < bytes.length) {
			}
			outs.write(bytes);
			in.close();

			/*
			 * int bit = 256; int i = 0; while ((in.available()) >= 0) { bit =
			 * in.read(); outs.write(bit); } outs.flush(); outs.close();
			 * in.close();
			 */
			// if (f.exists()) f.delete();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		jsp = "mrdViewPatientDoc";
		jsp += ".jsp";
		title = "Import CD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ----------------------VIEW DOCUMENTS ---------------------------------
	 */

	public ModelAndView showViewDocumentsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "mrdViewPatientDoc" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView removeFilesInUploadFolder(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		System.out
				.println("Removing files from upload directory...................");
		String filename = null;
		String fileExtension = null;
		Map<String, Object> uploadFileMap = new HashMap<String, Object>();

		String uploadURL = getServletContext().getRealPath("/upload/");

		//System.out.println("uploadURL==" + uploadURL);
		box.put("uploadURL", uploadURL);

		File f = new File(uploadURL);

		if (f.listFiles().length > 0) {
			File fd[] = f.listFiles();

			for (int i = 0; i < fd.length; i++) {
				if (fd[i].isFile())
					fd[i].delete();
			}
		}
		if (f.listFiles().length < 1) {
			if (!f.canWrite()) {
				/*
				 * if(f.isDirectory()|f.isFile()) f.delete();
				 */
			}
		}

		// if (f.exists()) f.delete();

		jsp = "mrdViewPatientDoc";
		jsp += ".jsp";
		title = "Import CD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

}
