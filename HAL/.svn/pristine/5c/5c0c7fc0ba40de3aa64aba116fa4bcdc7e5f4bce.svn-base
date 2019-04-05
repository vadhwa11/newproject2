package jkt.hms.medicalboard.dataservice;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MbInstructionToCandidateMaster;
import jkt.hms.masters.business.MbInstructionToCandidateUnfitExpl;
import jkt.hms.medicalboard.controller.InstructionToCandidateUpdateDTO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class InstructionToCandidatesUpdateDataServiceImpl extends
		HibernateDaoSupport implements InstructionToCandidatesUpdateDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> showInstructionToCandidatesUpdateJsp(int Id) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MbInstructionToCandidateMaster> updateList2 = new ArrayList<MbInstructionToCandidateMaster>();
		List<MbInstructionToCandidateUnfitExpl> mbInstructionToCandidateUnfitExpl = new ArrayList<MbInstructionToCandidateUnfitExpl>();
		updateList2 = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MbInstructionToCandidateMaster as mwd where mwd.Id ='"
								+ Id + "'");
		mbInstructionToCandidateUnfitExpl = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MbInstructionToCandidateUnfitExpl as mwd where mwd.IntructionToCandidateUnfitExplanation ='"
								+ Id + "'");
		map.put("mbInstructionToCandidateUnfitExpl",
				mbInstructionToCandidateUnfitExpl);
		map.put("mbInstructionToCandidateMaster", updateList2);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean editInstructionToCandidatesUpdateToDatabase(
			Map<String, Object> generalMap) {
		boolean successfullyUpdated = false;

		int instructionToCandidatesUpdateId = 0;
		Session sess = (Session) getSession();
		Transaction tx = null;
		instructionToCandidatesUpdateId = Integer.parseInt(generalMap.get("id")
				.toString());
		// getting the updated entity
		MbInstructionToCandidateMaster mbInstructionToCandidateMaster = (MbInstructionToCandidateMaster) generalMap
				.get("masInstructionToCandidate");

		// getting the entity from the table
		MbInstructionToCandidateMaster mbInstructionToCandidatesUpdate = (MbInstructionToCandidateMaster) getHibernateTemplate()
				.load(MbInstructionToCandidateMaster.class,
						instructionToCandidatesUpdateId);

		// updating table entity to the updated entity
		if (mbInstructionToCandidateMaster.getEntryDate() != null) {
			mbInstructionToCandidatesUpdate
					.setEntryDate(mbInstructionToCandidateMaster.getEntryDate());
		}
		if (mbInstructionToCandidateMaster.getBatchNo() != null) {
			mbInstructionToCandidatesUpdate
					.setBatchNo(mbInstructionToCandidateMaster.getBatchNo());
		}
		if (mbInstructionToCandidateMaster.getChestNo() != null) {
			mbInstructionToCandidatesUpdate
					.setChestNo(mbInstructionToCandidateMaster.getChestNo());
		}
		if (mbInstructionToCandidateMaster.getName() != null) {
			mbInstructionToCandidatesUpdate
					.setName(mbInstructionToCandidateMaster.getName());
		}

		mbInstructionToCandidatesUpdate
				.setLastChgBy(mbInstructionToCandidateMaster.getLastChgBy());
		mbInstructionToCandidatesUpdate
				.setLastChgDate(mbInstructionToCandidateMaster.getLastChgDate());
		mbInstructionToCandidatesUpdate
				.setLastChgTime(mbInstructionToCandidateMaster.getLastChgTime());

		// updating the record into the database
		org.springframework.orm.hibernate3.HibernateTemplate hbt1 = getHibernateTemplate();
		hbt1.setFlushModeName("FLUSH_EAGER");
		hbt1.setCheckWriteOperations(false);
		try {
			hbt1.update(mbInstructionToCandidatesUpdate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// getting the second updated entity
		List<InstructionToCandidateUpdateDTO> mbiList = (List<InstructionToCandidateUpdateDTO>) generalMap
				.get("mbUnfitExplanationList");

		// getting entity from the table
		List<MbInstructionToCandidateUnfitExpl> mbiListFromDatabase = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MbInstructionToCandidateUnfitExpl as mwd where mwd.IntructionToCandidateUnfitExplanation ='"
								+ instructionToCandidatesUpdateId + "'");

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if (mbiListFromDatabase != null && mbiList != null) {
			tx = sess.beginTransaction();
			int counter;
			for (MbInstructionToCandidateUnfitExpl mbInstructionToCandidateUnfitExpl : mbiListFromDatabase) {
				counter = 1;
				for (InstructionToCandidateUpdateDTO mbInstructionToCandidateUpdateDTO : mbiList) {
					if (!mbInstructionToCandidateUpdateDTO.getId().equals("")
							&& mbInstructionToCandidateUnfitExpl.getId() == Integer
									.parseInt(mbInstructionToCandidateUpdateDTO
											.getId())) {

						try {
							MbInstructionToCandidateUnfitExpl mbInstructionToCandidateUnfitExplUpdate = (MbInstructionToCandidateUnfitExpl) getHibernateTemplate()
									.get(
											MbInstructionToCandidateUnfitExpl.class,
											mbInstructionToCandidateUnfitExpl
													.getId());
							mbInstructionToCandidateUnfitExplUpdate
									.setUnfitExplanation(mbInstructionToCandidateUpdateDTO
											.getUnfitExplanation());
							hbt.update(mbInstructionToCandidateUnfitExplUpdate);
							mbInstructionToCandidateUpdateDTO.setId("0");
							counter++;
							break;

						} catch (Exception e) {
							e.printStackTrace();
						}
					} else if (mbInstructionToCandidateUpdateDTO.getId()
							.equals("0")
							&& mbiList.size() > counter) {
						counter++;
						continue;
					} else if (!mbInstructionToCandidateUpdateDTO.getId()
							.equals("")) {
						try {
							MbInstructionToCandidateUnfitExpl mbInstructionToCandidateUnfitExplUpdate = (MbInstructionToCandidateUnfitExpl) getHibernateTemplate()
									.get(
											MbInstructionToCandidateUnfitExpl.class,
											mbInstructionToCandidateUnfitExpl
													.getId());

							hbt.delete(mbInstructionToCandidateUnfitExplUpdate);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					}
				}
			}
			for (InstructionToCandidateUpdateDTO mbInstructionToCandidateUpdateDTO : mbiList) {
				if (mbInstructionToCandidateUpdateDTO.getId() != null
						&& mbInstructionToCandidateUpdateDTO.getId().equals("")) {

					hbt.setCheckWriteOperations(false);
					MbInstructionToCandidateMaster mbInstructionToCandidateMaster1 = new MbInstructionToCandidateMaster();
					MbInstructionToCandidateUnfitExpl mbInstructionToCandidateUnfitExplUpdate = new MbInstructionToCandidateUnfitExpl();
					mbInstructionToCandidateUnfitExplUpdate
							.setUnfitExplanation(mbInstructionToCandidateUpdateDTO
									.getUnfitExplanation());
					mbInstructionToCandidateMaster1
							.setId(instructionToCandidatesUpdateId);
					mbInstructionToCandidateUnfitExplUpdate
							.setIntructionToCandidateUnfitExplanation(mbInstructionToCandidateMaster1);
					hbt.save(mbInstructionToCandidateUnfitExplUpdate);
				}
			}
			successfullyUpdated = true;
			tx.commit();
		}
		return successfullyUpdated;
	}

	@SuppressWarnings("deprecation")
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}
}
