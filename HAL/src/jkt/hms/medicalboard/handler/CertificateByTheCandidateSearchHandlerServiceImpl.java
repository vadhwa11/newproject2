package jkt.hms.medicalboard.handler;

import java.util.Map;

import jkt.hms.medicalboard.controller.CertificateByTheCandidateSearchDTO;
import jkt.hms.medicalboard.dataservice.CertificateByTheCandidateSearchDataService;

public class CertificateByTheCandidateSearchHandlerServiceImpl implements
		CertificateByTheCandidateSearchHandlerService {
	CertificateByTheCandidateSearchDataService certificateByTheCandidateSearchDataService = null;

	public Map<String, Object> showCertificateByTheCandidateSearchJsp() {
		return certificateByTheCandidateSearchDataService
				.showCertificateByTheCandidateSearchJsp();
	}

	public Map<String, Object> searchCertificateByTheCandidateSearch(
			CertificateByTheCandidateSearchDTO certificateByTheCandidateSearch) {
		return certificateByTheCandidateSearchDataService
				.searchCertificateByTheCandidateSearch(certificateByTheCandidateSearch);
	}

	// ------------------------------------------------------------

	public CertificateByTheCandidateSearchDataService getCertificateByTheCandidateSearchDataService() {
		return certificateByTheCandidateSearchDataService;
	}

	public void setCertificateByTheCandidateSearchDataService(
			CertificateByTheCandidateSearchDataService certificateByTheCandidateSearchDataService) {
		this.certificateByTheCandidateSearchDataService = certificateByTheCandidateSearchDataService;
	}

}
