package jkt.hms.physiotherapy.handler;

import java.util.Map;

import jkt.hms.masters.business.MasTherapyType;
import jkt.hms.util.Box;

public interface PhysiotherapyHandlerService {

	Map<String, Object> showTherapyTypeJsp();

	Map<String, Object> searchTherapyType(String therapyTypeCode,
			String therapyTypeName);

	boolean addTherapyType(MasTherapyType therapyType);

	boolean editTherapyType(Map<String, Object> generalMap);

	boolean deleteTherapyType(int therapyTypeId, Map<String, Object> generalMap);

	Map<String, Object> getPhyWaitingList(Map<String, Object> mapForDS);

	Map<String, Object> getDetailsForPhysiotherapy(Box box);

	Map<String, Object> savePhysiotherapyDetails(Box box);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> getPhysiotherapyVisitDetails(Box box);

	Map<String, Object> getHinNoForAppointment(Box box);

	Map<String, Object> getDetailsForHinNo(Box box);

	Map<String, Object> showPhysiotherapyAppointmentJsp(Box box);

	Map<String, Object> savePhysiotherapyAppointment(Box box);

	Map<String, Object> searchPhyWaitingListJsp(Box box);

	Map<String, Object> getTherapyTypeListForAutoComplete(
			Map<String, Object> generalMap);

	Map<String, Object> getPhysioAppointmentDetails(Box box);

	Map<String, Object> savePhysioTheraphyAppointment(Box box);

	Map<String, Object> getDetailsForPhysiotherapyVisitForAppointement(Box box);

	Map<String, Object> saveVisitEntryForAppointmentDetails(Box box);

	Map<String, Object> getPatientDetailsFordirectVisitEntry(String serviceNo);

	Map<String, Object> getPatientDetails(Box box);

	Map<String, Object> showDirectTherapyVisitEntryJps(Box box);

	Map<String, Object> showPhyTreatmentRegisterJsp(int hospitalId);

	Map<String, Object> showPhysioTherapyTreatmentRegiterGraph(Box box);

	Map<String, Object> showPhysiotherapyAppointmentRegister(int hospitalId);

	Map<String, Object> showPhysiotherapyVisitWaitingList(int hospitalId);

	Map<String, Object> showPhyAppointmentRegisterReport(Box box);

}
