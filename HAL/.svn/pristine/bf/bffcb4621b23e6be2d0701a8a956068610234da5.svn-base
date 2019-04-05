package jkt.hms.medicalboard.handler;

import java.util.Map;

import jkt.hms.medicalboard.dataservice.CertificateByTheCandidatesUpdateDataService;

public class CertificateByTheCandidatesUpdateHandlerServiceImpl implements
		CertificateByTheCandidatesUpdateHandlerService {
	CertificateByTheCandidatesUpdateDataService certificateByTheCandidatesUpdateDataService = null;

	public Map<String, Object> showCertificateByTheCandidatesUpdateJsp(int Id) {
		return certificateByTheCandidatesUpdateDataService
				.showCertificateByTheCandidatesUpdateJsp(Id);
	}

	public boolean editCertificateByTheCandidatesUpdateToDatabase(
			Map<String, Object> generalMap) {
		return certificateByTheCandidatesUpdateDataService
				.editCertificateByTheCandidatesUpdateToDatabase(generalMap);
	}

	// get Connection for Print the Report
	public Map<String, Object> getConnectionForReport() {
		return certificateByTheCandidatesUpdateDataService
				.getConnectionForReport();
	}

	// ------------------------------------------------------------

	public CertificateByTheCandidatesUpdateDataService getCertificateByTheCandidatesUpdateDataService() {
		return certificateByTheCandidatesUpdateDataService;
	}

	public void setCertificateByTheCandidatesUpdateDataService(
			CertificateByTheCandidatesUpdateDataService certificateByTheCandidatesUpdateDataService) {
		this.certificateByTheCandidatesUpdateDataService = certificateByTheCandidatesUpdateDataService;
	}

}
