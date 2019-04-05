package jkt.hms.enquiry.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.enquiry.dataservice.EnquiryDataService;
import jkt.hms.masters.business.MasDepartment;

public class EnquiryHandlerServiceImpl implements EnquiryHandlerService {

	EnquiryDataService enquiryDataService = null;

	public EnquiryDataService getEnquiryDataService() {
		return enquiryDataService;
	}

	public void setEnquiryDataService(EnquiryDataService enquiryDataService) {
		this.enquiryDataService = enquiryDataService;
	}

	// -----------------------------------------------------------------------------------------------
	public List<MasDepartment> getWardList() {
		return enquiryDataService.getWardList();
	}

	public Map<String, Object> getDoctorList(Map<String, Object> enquiryMap) {
		return enquiryDataService.getDoctorList(enquiryMap);
	}

	public Map<String, Object> getDetailsForEnquiry() {
		return enquiryDataService.getDetailsForEnquiry();
	}

	public Map<String, Object> getPatientDetailsForEnquiry(
			Map<String, Object> enquiryMap) {
		return enquiryDataService.getPatientDetailsForEnquiry(enquiryMap);
	}

	public Map<String, Object> getInPatientDetailsForEnquiry(
			Map<String, Object> enquiryMap) {
		return enquiryDataService.getInPatientDetailsForEnquiry(enquiryMap);
	}

	public Map<String, Object> getDetailsForSearch() {
		// TODO Auto-generated method stub
		return enquiryDataService.getDetailsForSearch();
	}

	public Map<String, Object> getInPatientDetailsForEnquiry2(
			Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		return enquiryDataService.getInPatientDetailsForEnquiry2(mapForDs);
	}

	public Map<String, Object> showPatientDetails(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return enquiryDataService.showPatientDetails(dataMap);
	}

	public Map<String, Object> getAdVisitDetails(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return enquiryDataService.getAdVisitDetails(dataMap);
	}

	public Map<String, Object> getAllEnquiry(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return enquiryDataService.getAllEnquiry(dataMap);
	}
	public Map<String, Object> getAllEnquiry1(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return enquiryDataService.getAllEnquiry1(dataMap);
	}

}
