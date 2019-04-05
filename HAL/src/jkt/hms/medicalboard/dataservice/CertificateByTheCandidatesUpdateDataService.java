package jkt.hms.medicalboard.dataservice;

import java.util.Map;

public interface CertificateByTheCandidatesUpdateDataService {

	Map<String, Object> showCertificateByTheCandidatesUpdateJsp(int Id);

	boolean editCertificateByTheCandidatesUpdateToDatabase(
			Map<String, Object> generalMap);

	// connection method for print
	public Map<String, Object> getConnectionForReport();

}
