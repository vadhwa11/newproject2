package jkt.hms.medicalboard.handler;

import java.util.Map;

import jkt.hms.medicalboard.dataservice.CertificateByTheCandidateDataService;

public class CertificateByTheCandidateHandlerServiceImpl implements
		CertificateByTheCandidateHandlerService {
	CertificateByTheCandidateDataService certificateByTheCandidatedataservice = null;

	public Map<String, Object> showCertificateByTheCandidateJsp() {
		return certificateByTheCandidatedataservice
				.showCertificateByTheCandidateJsp();
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public boolean addCertificateByTheCandidate(Map certificateByTheCandidateno) {
		return certificateByTheCandidatedataservice
				.addCertificateByTheCandidate(certificateByTheCandidateno);
	}

	public CertificateByTheCandidateDataService getMinorworkdetaildataservice() {
		return certificateByTheCandidatedataservice;
	}

	public void setCertificateByTheCandidateDataService(
			CertificateByTheCandidateDataService certificateByTheCandidatedataservice) {
		this.certificateByTheCandidatedataservice = certificateByTheCandidatedataservice;
	}

	public String generateCertificateByCandidateNo(String userName) {
		return certificateByTheCandidatedataservice
				.generateCertificateByCandidateNo(userName);
	}

}
