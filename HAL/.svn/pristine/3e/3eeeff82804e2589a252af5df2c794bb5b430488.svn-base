package jkt.hms.masters.dataservice;

import java.util.Map;

import jkt.hms.masters.business.DgCollectionCenter;
import jkt.hms.masters.business.DgMasCollection;
import jkt.hms.masters.business.DgMasOrganism;
import jkt.hms.masters.business.DgMasOrganismGroup;
import jkt.hms.masters.business.DgOrgDtl;
import jkt.hms.masters.business.DgOrgGrpDtl;
import jkt.hms.masters.business.DgUom;
import jkt.hms.masters.business.MasAntibioticLab;
import jkt.hms.masters.business.MasBiopsyLab;
import jkt.hms.masters.business.MasDiagnosisConclusion;
import jkt.hms.masters.business.MasParameter;
import jkt.hms.masters.business.MasSample;

public interface LaboratoryMasterDataService {

	// ------------------------- Diagnosis
	// Conclusion--------------------------------

	boolean addDiagnosisConclusion(MasDiagnosisConclusion masDiagnosisConclusion);

	boolean editDiagnosisConclusionToDatabase(Map<String, Object> generalMap);

	Map<String, Object> showDiagnosisConclusionJsp();

	Map<String, Object> searchDiagnosisConclusion(
			String diagnosisConclusionCode, String diagnosisConclusionName);

	boolean deleteDiagnosisConclusion(int conclusionId,
			Map<String, Object> generalMap);

	// ---------------------------Biopsy Lab------------------------------------

	boolean addBiopsyLab(MasBiopsyLab masBiopsyLab);

	boolean editBiopsyLabToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchBiopsyLab(String biopsyLabCode,
			String biopsyLabName);

	Map<String, Object> showBiopsyLabJsp();

	boolean deleteBiopsyLab(int biopsyLabId, Map<String, Object> generalMap);

	// ---------------------------------- Sample
	// -------------------------------------
	boolean addSample(MasSample masSample);

	boolean deleteSample(int sampleId, Map<String, Object> generalMap);

	boolean editSampleToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchSample(String sampleCode, String sampleName);

	Map<String, Object> showSampleJsp();

	// ----------------------SampleCollection----------------------------------
	boolean addSampleCollection(DgMasCollection dgMasCollection);

	boolean deleteSampleCollection(int collectionId,
			Map<String, Object> generalMap);

	boolean editSampleCollectionToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchSampleCollection(String collectionCode,
			String collectionName);

	Map<String, Object> showSampleCollectionJsp();

	// ---------------------------------Investigation
	// UOM------------------------
	boolean addInvestigationUom(DgUom dgUom);

	boolean editInvestigationUomToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchInvestigationUom(String uomCode, String uomName);

	Map<String, Object> showInvestigationUomJsp();

	boolean deleteInvestigationUom(int uomId, Map<String, Object> generalMap);

	// -------------------------------Collection
	// Center--------------------------

	boolean addCollectionCenter(DgCollectionCenter dgCollectionCenter);

	boolean deleteCollectionCenter(int collectionCenterId,
			Map<String, Object> generalMap);

	boolean editCollectionCenterToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchCollectionCenter(String collectionCenterCode,
			String collectionCenterName);

	Map<String, Object> showCollectionCenterJsp();

	// ---------------------------Antibiotic by
	// Vishal------------------------------------
	Map<String, Object> searchAntibioticLab(String antibioticCode,
			String antibioticName);

	Map<String, Object> showAntibioticLabJsp();

	boolean addAntibioticLab(MasAntibioticLab masAntibioticLab);

	boolean editAntibioticLabToDatabase(Map<String, Object> generalMap);

	boolean deleteAntibioticLab(int antibioticLabId,
			Map<String, Object> generalMap);

	// ---------------------------Code End By
	// Vishal------------------------------------
	Map<String, Object> showParameterJsp();

	boolean addParameterMaster(MasParameter masParameter);

	boolean deleteParameterMaster(int parameterId,
			Map<String, Object> generalMap);

	boolean editParametermaster(Map<String, Object> generalMap);

	boolean addOrganismGroup(DgMasOrganismGroup dgMasOrganismGroup);

	boolean addOrganism(DgMasOrganism dgMasOrganism);

	boolean deleteOrganism(int organismId, Map<String, Object> generalMap);

	boolean deleteOrganismGroup(int organismGroupId,
			Map<String, Object> generalMap);

	boolean editOrganism(Map<String, Object> generalMap);

	Map<String, Object> searchOrganismGroup(String organismGroupCode,
			String organismGroupName);

	Map<String, Object> searchOrganism(String organismCode, String organismName);

	Map<String, Object> showOrganismGroupJsp();

	Map<String, Object> showOrganismJsp();

	Map<String, Object> getConnection();

	boolean addOrganismGroupDetail(DgOrgGrpDtl dgOrgGrpDtl);

	boolean deleteOrganismGroupDetail(int groupDetailId,
			Map<String, Object> generalMap);

	boolean editOrganismGroupDetail(Map<String, Object> generalMap);

	Map<String, Object> showOrganismGroupDetailJsp();

	boolean addOrganismDetail(DgOrgDtl dgOrgDtl);

	boolean editOrganismDetail(Map<String, Object> generalMap);

	Map<String, Object> showOrganismDetailJsp();

	boolean editOrganismGroupToDatabase(Map<String, Object> generalMap);

	boolean deleteOrganismDetail(int detailId, Map<String, Object> generalMap);

	Map<String, Object> searchOrganismGroupDetail(String organismGroup);

	Map<String, Object> getOrganismListAutoComplete(
			Map<String, Object> parameterMap);

	Map<String, Object> searchOrganismDetail(Map<String, Object> mapForDs);

	Map<String, Object> getSensitivityListAutoComplete(
			Map<String, Object> parameterMap);
}
