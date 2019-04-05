package jkt.hms.medicalboard.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasMedicalBoardExaminationDetail;
import jkt.hms.masters.business.MasMedicalExaminationReportOnEntry;
import jkt.hms.medicalboard.controller.MedicalExaminationBoardSearchDTO;
import jkt.hms.medicalboard.dataservice.MedicalExaminationBoardDataService;

public class MedicalExaminationBoardHandlerServiceImpl implements
		MedicalExaminationBoardHandlerService {
	MedicalExaminationBoardDataService medicalExaminationBoardDataService = null;

	public Map<String, Object> showMedicalExaminationBoardJsp() {
		return medicalExaminationBoardDataService
				.showMedicalExaminationBoardJsp();
	}

	public boolean addMedicalExaminationBoard(
			MasMedicalExaminationReportOnEntry masMedicalExaminationReportOnEntry,
			List<MasMedicalBoardExaminationDetail> masMedicalBoardExaminationDetail) {
		return medicalExaminationBoardDataService.addMedicalExaminationBoard(
				masMedicalExaminationReportOnEntry,
				masMedicalBoardExaminationDetail);
	}

	public String generateMedicalEntryNumber(String userName) {
		return medicalExaminationBoardDataService
				.generateMedicalEntryNumber(userName);
	}

	public String generateMedicalEntryNumber1(String userName1) {
		return medicalExaminationBoardDataService
				.generateMedicalEntryNumber1(userName1);
	}

	// //////////////////////////////////
	// search
	// /////////////////////////////

	public Map<String, Object> showMedicalExaminationBoardsSearchJsp() {
		return medicalExaminationBoardDataService
				.showMedicalExaminationBoardsSearchJsp();
	}

	public Map<String, Object> searchMedicalExaminationBoardSearch(
			MedicalExaminationBoardSearchDTO medicalExaminationBoardSearchDTO) {
		return medicalExaminationBoardDataService
				.searchMedicalExaminationBoardSearch(medicalExaminationBoardSearchDTO);
	}

	// ///////////////////////////////////////////////////
	// update
	// ///////////////////////////////////////////////////

	public Map<String, Object> showMedicalExaminationBoardUpdateJsp(int Id) {
		return medicalExaminationBoardDataService
				.showMedicalExaminationBoardUpdateJsp(Id);
	}

	// /////////////////////////////////////////////////////////
	// connection for print
	// /////////////////////////////////////////////////////////

	public Map<String, Object> getConnectionForReport() {
		return medicalExaminationBoardDataService.getConnectionForReport();
	}

	public boolean medicalExaminationBoardUpdateToDatabase(
			Map<String, Object> generalMap) {
		return medicalExaminationBoardDataService
				.medicalExaminationBoardUpdateToDatabase(generalMap);
	}

	public MedicalExaminationBoardDataService getMedicalExaminationBoardDataService() {
		return medicalExaminationBoardDataService;
	}

	public void setMedicalExaminationBoardDataService(
			MedicalExaminationBoardDataService medicalExaminationBoardDataService) {
		this.medicalExaminationBoardDataService = medicalExaminationBoardDataService;
	}
}
