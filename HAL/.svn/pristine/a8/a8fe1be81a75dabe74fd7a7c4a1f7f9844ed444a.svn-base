package jkt.hms.mrd.handler;

import java.util.Map;

import jkt.hms.mrd.dataservice.MRDDataService;
import jkt.hms.util.Box;

public class MRDHandlerServiceImpl implements MRDHandlerService {

	MRDDataService mrdDataService = null;

	public MRDDataService getMrdDataService() {
		return mrdDataService;
	}

	public void setMrdDataService(MRDDataService mrdDataService) {
		this.mrdDataService = mrdDataService;
	}

	/**
	 * --------------------------- CODE -----------------------------
	 */

	public Map<String, Object> submitUploadDocuments(Box box) {
		return mrdDataService.submitUploadDocuments(box);
	}

	public Map<String, Object> viewUploadDocuments(Box box) {
		return mrdDataService.viewUploadDocuments(box);
	}

	public Map<String, Object> viewPatientDetails(Map<String, Object> map) {
		return mrdDataService.viewPatientDetails(map);
	}

	public Map<String, Object> showUploadingDocumentsJsp(int visitId) {
		return mrdDataService.showUploadingDocumentsJsp(visitId);
	}

}
