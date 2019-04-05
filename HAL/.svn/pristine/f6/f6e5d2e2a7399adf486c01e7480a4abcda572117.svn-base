package jkt.hms.physiotherapy.handler;

import java.util.Map;

import jkt.hms.masters.business.MasTherapyType;
import jkt.hms.physiotherapy.dataservice.PhysiotherapyDataService;
import jkt.hms.util.Box;

public class PhysiotherapyHandlerServiceImpl implements PhysiotherapyHandlerService {

	PhysiotherapyDataService physiotherapyDataService = null;

	public PhysiotherapyDataService getPhysiotherapyDataService() {
		return physiotherapyDataService;
	}

	public void setPhysiotherapyDataService(
			PhysiotherapyDataService physiotherapyDataService) {
		this.physiotherapyDataService = physiotherapyDataService;
	}

	@Override
	public Map<String, Object> showTherapyTypeJsp() {
		return physiotherapyDataService.showTherapyTypeJsp();
	}

	@Override
	public Map<String, Object> searchTherapyType(String therapyTypeCode,
			String therapyTypeName) {
		return physiotherapyDataService.searchTherapyType(therapyTypeCode,therapyTypeName);
	}

	@Override
	public boolean addTherapyType(MasTherapyType therapyType) {
		return physiotherapyDataService.addTherapyType(therapyType);
	}

	@Override
	public boolean editTherapyType(Map<String, Object> generalMap) {
		return physiotherapyDataService.editTherapyType(generalMap) ;
	}

	@Override
	public boolean deleteTherapyType(int therapyTypeId,Map<String, Object> generalMap) {
		return physiotherapyDataService.deleteTherapyType(therapyTypeId,generalMap);
	}

	@Override
	public Map<String, Object> getPhyWaitingList(Map<String, Object> mapForDS) {
		return physiotherapyDataService.getPhyWaitingList(mapForDS);
	}

	@Override
	public Map<String, Object> getDetailsForPhysiotherapy(Box box) {
		return physiotherapyDataService.getDetailsForPhysiotherapy(box);
	}

	@Override
	public Map<String, Object> savePhysiotherapyDetails(Box box) {
		return physiotherapyDataService.savePhysiotherapyDetails(box);
	}

	@Override
	public Map<String, Object> getConnectionForReport() {
		return physiotherapyDataService.getConnectionForReport();
	}

	@Override
	public Map<String, Object> getPhysiotherapyVisitDetails(Box box) {
		return physiotherapyDataService.getPhysiotherapyVisitDetails(box);
	}

	@Override
	public Map<String, Object> getHinNoForAppointment(Box box) {
		return physiotherapyDataService.getHinNoForAppointment(box);
	}

	@Override
	public Map<String, Object> getDetailsForHinNo(Box box) {
		return physiotherapyDataService.getDetailsForHinNo(box);
	}

	@Override
	public Map<String, Object> showPhysiotherapyAppointmentJsp(Box box) {
		return physiotherapyDataService.showPhysiotherapyAppointmentJsp(box);
	}

	@Override
	public Map<String, Object> savePhysiotherapyAppointment(Box box) {
		return physiotherapyDataService.savePhysiotherapyAppointment(box);
	}

	@Override
	public Map<String, Object> searchPhyWaitingListJsp(Box box) {
		
		return physiotherapyDataService.searchPhyWaitingListJsp(box) ;
	}

	@Override
	public Map<String, Object> getTherapyTypeListForAutoComplete(
			Map<String, Object> generalMap) {
	
		return physiotherapyDataService.getTherapyTypeListForAutoComplete(generalMap);
	}

	@Override
	public Map<String, Object> getPhysioAppointmentDetails(Box box) {
		
		return physiotherapyDataService.getPhysioAppointmentDetails(box);
	}

	@Override
	public Map<String, Object> savePhysioTheraphyAppointment(Box box) {
		
		return physiotherapyDataService.savePhysioTheraphyAppointment(box);
	}

	@Override
	public Map<String, Object> getDetailsForPhysiotherapyVisitForAppointement(
			Box box) {
		
		return physiotherapyDataService.getDetailsForPhysiotherapyVisitForAppointement(box);
	}

	@Override
	public Map<String, Object> saveVisitEntryForAppointmentDetails(Box box) {
		
		return physiotherapyDataService.saveVisitEntryForAppointmentDetails(box);
	}

	@Override
	public Map<String, Object> getPatientDetailsFordirectVisitEntry(
			String serviceNo) {
		
		return physiotherapyDataService.getPatientDetailsFordirectVisitEntry(serviceNo);
	}

	@Override
	public Map<String, Object> getPatientDetails(Box box) {
		
		return physiotherapyDataService.getPatientDetails(box);
	}

	@Override
	public Map<String, Object> showDirectTherapyVisitEntryJps(Box box) {
		
		return physiotherapyDataService.showDirectTherapyVisitEntryJps(box);
	}

	@Override
	public Map<String, Object> showPhyTreatmentRegisterJsp(int hospitalId) {
		
		return physiotherapyDataService.showPhyTreatmentRegisterJsp(hospitalId);
	}

	@Override
	public Map<String, Object> showPhysioTherapyTreatmentRegiterGraph(Box box) {
		// TODO Auto-generated method stub
		return physiotherapyDataService.showPhysioTherapyTreatmentRegiterGraph(box);
	}

	@Override
	public Map<String, Object> showPhysiotherapyAppointmentRegister(
			int hospitalId) {
		
		return physiotherapyDataService.showPhysiotherapyAppointmentRegister(hospitalId);
	}

	@Override
	public Map<String, Object> showPhysiotherapyVisitWaitingList(int hospitalId) {
		return physiotherapyDataService.showPhysiotherapyVisitWaitingList(hospitalId);
	}

	@Override
	public Map<String, Object> showPhyAppointmentRegisterReport(Box box) {
		
		return physiotherapyDataService.showPhyAppointmentRegisterReport(box);
	}
	
}
