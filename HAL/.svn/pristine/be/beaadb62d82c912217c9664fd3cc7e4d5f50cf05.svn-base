package jkt.hms.mrd.dataservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MRDDataServiceImpl extends HibernateDaoSupport implements
		MRDDataService {
	private LobHandler lobHandler;

	/**
	 * -------------------------------- UPLOAD DOCUMENTS
	 * -------------------------
	 */

	public Map<String, Object> viewPatientDetails(Map<String, Object> map) {
		Session session = (Session) getSession();

		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Visit> visitList = new ArrayList<Visit>();

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");

		String inputField = (String) map.get("inputField");
		String flag = (String) map.get("flag");
		String flag1 = (String) map.get("flag1");
		String message = null;

		Criteria criteria = null;
		if (flag.equals("upload") && !flag1.equals("viewDocuments")) {
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("Status", "y")).add(
					Restrictions.eq("HinNo", inputField)).list();

			if (patientList.size() == 0) {
				inpatientList = session.createCriteria(Inpatient.class).add(
						Restrictions.eq("Status", "y")).add(
						Restrictions.eq("AdNo", inputField)).list();
			}

			if (visitList.size() == 0 && inpatientList.size() == 0
					&& patientList.size() == 0) {
				message = "No record Found !!";
			}
			map.put("message", message);
			map.put("patientList", patientList);
			map.put("inpatientList", inpatientList);

		} else if (flag.equals("view") || flag1.equals("viewDocuments")) {
			String uploadURL = (String) map.get("uploadURL");
			patientList = session.createCriteria(UploadDocuments.class)
					.createAlias("Hin", "p").add(
							Restrictions.eq("p.HinNo", inputField)).list();

			if (patientList.size() == 0) {
				inpatientList = session.createCriteria(UploadDocuments.class)
						.createAlias("Inpatient", "ip").add(
								Restrictions.eq("ip.AdNo", inputField)).list();
			}

			if (inpatientList.size() == 0 && patientList.size() == 0) {
				message = "No record Found !!";
			}
			map.put("message", message);
			map.put("patientList", patientList);
			map.put("inpatientList", inpatientList);
			String[] files = null;
			if (patientList.size() > 0) {
				files = new String[patientList.size()];
				Iterator iterator = patientList.iterator();
				int counter = 0;
				while (iterator.hasNext()) {
					UploadDocuments uploadDocuments = (UploadDocuments) iterator
							.next();
					files[counter] = uploadDocuments.getFileName() + "."
							+ uploadDocuments.getFileExtension();
					// //System.out.println("filename="+files[counter]);
					try {
						FileOutputStream is = new FileOutputStream(uploadURL
								+ "\\" + uploadDocuments.getFileName() + "."
								+ uploadDocuments.getFileExtension());
						is.flush();

						is.write(uploadDocuments.getPatientDocument());

						is.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					counter++;
				}

			}
			if (inpatientList.size() > 0) {
				files = new String[inpatientList.size()];
				Iterator iterator = inpatientList.iterator();
				int counter = 0;
				while (iterator.hasNext()) {
					UploadDocuments uploadDocuments = (UploadDocuments) iterator
							.next();
					files[counter] = uploadDocuments.getFileName() + "."
							+ uploadDocuments.getFileExtension();
					try {
						FileOutputStream is = new FileOutputStream(uploadURL
								+ "\\" + files[counter]);
						is.flush();

						is.write(uploadDocuments.getPatientDocument());

						is.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					counter++;
				}
			}

		}

		/*
		 * //System.out.println("IN DATA SERVICE patientList="+patientList.size());
		 * System
		 * .out.println("IN DATA SERVICE inpatientList="+inpatientList.size());
		 */
		return map;

	}

	public Map<String, Object> submitUploadDocuments(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<UploadDocuments> uploadDocumentsList = new ArrayList<UploadDocuments>();
		String fileName = null;
		String fileExtension = null;
		String patientName = box.getString("patientName");
		String age = box.getString("age");
		String sex = box.getString("sex");
		String hinNo = box.getString("hinNo");
		String address = box.getString("address");

		int hinId = box.getInt("hinId");
		int inpatientId = box.getInt("inpatientId");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		int hospitalId = box.getInt("hospitalId");
		String userName = box.getString("userName");
		// //System.out.println("fileName="+fileName);
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			// hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// hbt.setFetchSize(16*1024*1024);
			File file = null;
			for (int i = 1; i <= 5; i++) {
				if (!box.getString("filename" + i).equals("0")) {
					file = new File(box.getString("uploadURL") + "/"
							+ box.getString("filename" + i));
					FileInputStream is = new FileInputStream(file);
					long length = file.length();
					ByteBuffer byteBuff = null;
					// int modLength=length/
					if (length > Integer.MAX_VALUE) {
						// File is too large
					}

					// Create the byte array to hold the data
					byte[] bytes = new byte[(int) length];
					//System.out.println("bytes.length==" + bytes.length);
					int offset = 0;
					int numRead = 0;
					while (offset < bytes.length
							&& (numRead = is.read(bytes, offset, bytes.length
									- offset)) >= 0) {
						offset += numRead;

					}
					/*
					 * while (offset < bytes.length && (numRead=is.read(bytes,
					 * offset, )) >= 0) { offset += 1000;
					 * if(offset>bytes.length) offset=offset-bytes.length;
					 * 
					 * }
					 */

					if (offset < bytes.length) {
						throw new IOException("Could not completely read file "
								+ file.getName());

					}

					is.close();
					// Close the input stream and return bytes
					StringTokenizer strToken = new StringTokenizer(box
							.getString("filename" + i), ".");

					fileName = strToken.nextToken();
					fileExtension = strToken.nextToken();
					UploadDocuments uploadDocuments = new UploadDocuments();
					String dataInput = new String(bytes);
					uploadDocuments.setPatientDocument(bytes);
					// uploadDocuments.setPatientDocument(is.toString());
					uploadDocuments.setPatientName(patientName);
					uploadDocuments.setSex(sex);
					uploadDocuments.setAge(age);
					if (address != null)
						uploadDocuments.setAddress(address);
					uploadDocuments.setFileExtension(fileExtension);
					uploadDocuments.setFileName(fileName);

					if (hinId != 0) {
						Patient patient = new Patient();
						patient.setId(hinId);
						uploadDocuments.setHin(patient);
					}
					if (inpatientId != 0) {
						Inpatient inpatient = new Inpatient();
						inpatient.setId(inpatientId);
						uploadDocuments.setInpatient(inpatient);
					}
					uploadDocuments.setDescription(box.getString("description"
							+ i));
					uploadDocuments.setUploadDate(date);
					uploadDocuments.setLastChgDate(date);
					uploadDocuments.setLastChgTime(time);
					uploadDocuments.setLastChgBy(userName);
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					uploadDocuments.setHospital(masHospital);
					hbt.save(uploadDocuments);

					file.delete();
				}// end of 'IF'

			}// end of 'for' loop
		}// end of 'try' loop
		catch (Exception e) {
			//System.out.println("File not Saved....................");
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		map.put("dataSaved", true);

		return map;

	}

	public Map<String, Object> viewUploadDocuments(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<UploadDocuments> uploadDocumentsList = new ArrayList<UploadDocuments>();
		String filename = null;
		String fileExtension = null;
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			StringTokenizer st1 = new StringTokenizer(
					box.getString("filename"), ".");
			filename = st1.nextToken();
			fileExtension = st1.nextToken();
			uploadDocumentsList = session.createCriteria(UploadDocuments.class)
					.add(Restrictions.eq("FileName", filename)).list();
			//System.out.println("uploadDocumentsList=="+ uploadDocumentsList.size());
			if (uploadDocumentsList != null) {
				/*
				 * Iterator ite= uploadDocumentsList.iterator();
				 * while(ite.hasNext()) {
				 */
				// UploadDocuments uploadDocuments=(UploadDocuments) ite.next();
				//System.out.println("filename + fileExtension" + filename + "."+ fileExtension);

				// File outFile=new File(box.getString("uploadURL") + "/"
				// +filename + "."+fileExtension );

				//System.out.println("1111111111111");
				FileOutputStream is = new FileOutputStream(box
						.getString("uploadURL")
						+ "\\" + filename + "." + fileExtension);
				// FileOutputStream is = new FileOutputStream("c:\\upload\\" +
				// filename +"."+ fileExtension );
				is.flush();
				// Create the byte array to hold the data
				// byte[] theByteArray =
				// uploadDocumentsList.get(0).getPatientDocument();

				is.write(uploadDocumentsList.get(0).getPatientDocument());
				//System.out.println("22222222222222222");

				is.close();
				// Close the input stream and return bytes
				// }
				/*
				 * Writer output = null;
				 * 
				 * //String text = "Rajesh Kumar"; File file = new
				 * File(box.getString("uploadURL") + "\\" +filename +
				 * "."+fileExtension ); output = new BufferedWriter(new
				 * FileWriter(file));
				 * output.write(uploadDocumentsList.get(0).getPatientDocument
				 * ()); output.close();
				 */

			}
		} catch (Exception e) {
			// //System.out.println("File not Saved....................");
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

		return map;

	}

	public Map<String, Object> showUploadingDocumentsJsp(int visitId) {
		Session session = (Session) getSession();
		List<Visit> patientDataList = new ArrayList<Visit>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			patientDataList = session.createCriteria(Visit.class).add(
					Restrictions.eq("Id", visitId)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDataList", patientDataList);
		return map;
	}

	/**
	 * --------------------------- END OF CLASS
	 * ---------------------------------
	 */

}
