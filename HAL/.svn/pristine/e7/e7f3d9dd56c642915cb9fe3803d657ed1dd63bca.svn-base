package jkt.hms.medicalboard.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasMedicalBoardExaminationDetail;
import jkt.hms.masters.business.MasMedicalExaminationReportOnEntry;
import jkt.hms.medicalboard.controller.MedicalExaminationBoardSearchDTO;

public interface MedicalExaminationBoardHandlerService {
	public Map<String, Object> showMedicalExaminationBoardJsp();

	public boolean addMedicalExaminationBoard(
			MasMedicalExaminationReportOnEntry masMedicalExaminationReportOnEntry,
			List<MasMedicalBoardExaminationDetail> masMedicalBoardExaminationDetail);

	public String generateMedicalEntryNumber(String userName);

	public String generateMedicalEntryNumber1(String userName);

	// search
	Map<String, Object> showMedicalExaminationBoardsSearchJsp();

	Map<String, Object> searchMedicalExaminationBoardSearch(
			MedicalExaminationBoardSearchDTO medicalExaminationBoardSearchDTO);

	// update
	public Map<String, Object> showMedicalExaminationBoardUpdateJsp(int Id);

	public boolean medicalExaminationBoardUpdateToDatabase(
			Map<String, Object> generalMap);

	// connection method for print
	public Map<String, Object> getConnectionForReport();
}
