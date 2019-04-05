package jkt.hms.medicalboard.dataservice;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MbResultOfAppealMedicalboardMaster;
import jkt.hms.masters.business.MbResultOfAppealMedicalboardUnfitExpl;
import jkt.hms.medicalboard.controller.ResultOfAppealMedicalboardUpdateDTO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ResultOfAppealMedicalboardUpdateDataServiceImpl extends
		HibernateDaoSupport implements
		ResultOfAppealMedicalboardUpdateDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> showResultOfAppealMedicalboardUpdateJsp(int Id) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MbResultOfAppealMedicalboardMaster> updateList2 = new ArrayList<MbResultOfAppealMedicalboardMaster>();
		List<MbResultOfAppealMedicalboardUnfitExpl> mbResultOfAppealMedicalboardUnfitExpl = new ArrayList<MbResultOfAppealMedicalboardUnfitExpl>();
		updateList2 = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MbResultOfAppealMedicalboardMaster as mwd where mwd.Id ='"
								+ Id + "'");
		mbResultOfAppealMedicalboardUnfitExpl = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MbResultOfAppealMedicalboardUnfitExpl as mwd where mwd.ResultOfAppealMedicalboardUnfitExpl ='"
								+ Id + "'");
		map.put("mbResultOfAppealMedicalboardUnfitExpl",
				mbResultOfAppealMedicalboardUnfitExpl);
		map.put("mbResultOfAppealMedicalboardMaster", updateList2);
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();
		masUnitList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasUnit");
		map.put("masUnitList", masUnitList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean editResultOfAppealMedicalboardUpdateToDatabase(
			Map<String, Object> generalMap) {
		boolean successfullyUpdated = false;
		int resultOfAppealMedicalboardUpdateId = 0;
		Session sess = (Session) getSession();
		Transaction tx = null;
		resultOfAppealMedicalboardUpdateId = Integer.parseInt(generalMap.get(
				"id").toString());
		// getting the updated entity
		MbResultOfAppealMedicalboardMaster mbResultOfAppealMedicalboardMaster = (MbResultOfAppealMedicalboardMaster) generalMap
				.get("masResultOfAppealMedicalboard");

		// getting the entity from the table
		MbResultOfAppealMedicalboardMaster mbResultOfAppealMedicalboardUpdate = (MbResultOfAppealMedicalboardMaster) getHibernateTemplate()
				.load(MbResultOfAppealMedicalboardMaster.class,
						resultOfAppealMedicalboardUpdateId);

		// updating table entity to the updated entity
		if (mbResultOfAppealMedicalboardMaster.getEntryDate() != null) {
			mbResultOfAppealMedicalboardUpdate
					.setEntryDate(mbResultOfAppealMedicalboardMaster
							.getEntryDate());
		}
		if (mbResultOfAppealMedicalboardMaster.getBatchNo() != null) {
			mbResultOfAppealMedicalboardUpdate
					.setBatchNo(mbResultOfAppealMedicalboardMaster.getBatchNo());
		}
		if (mbResultOfAppealMedicalboardMaster.getChestNo() != null) {
			mbResultOfAppealMedicalboardUpdate
					.setChestNo(mbResultOfAppealMedicalboardMaster.getChestNo());
		}
		if (mbResultOfAppealMedicalboardMaster.getName() != null) {
			mbResultOfAppealMedicalboardUpdate
					.setName(mbResultOfAppealMedicalboardMaster.getName());
		}
		if (mbResultOfAppealMedicalboardMaster
				.getAppealMedicalboardExamination() != null) {
			mbResultOfAppealMedicalboardUpdate
					.setAppealMedicalboardExamination(mbResultOfAppealMedicalboardMaster
							.getAppealMedicalboardExamination());
		}
		mbResultOfAppealMedicalboardUpdate
				.setLastChgBy(mbResultOfAppealMedicalboardMaster.getLastChgBy());
		mbResultOfAppealMedicalboardUpdate
				.setLastChgDate(mbResultOfAppealMedicalboardMaster
						.getLastChgDate());
		mbResultOfAppealMedicalboardUpdate
				.setLastChgTime(mbResultOfAppealMedicalboardMaster
						.getLastChgTime());

		// updating the record into the database
		org.springframework.orm.hibernate3.HibernateTemplate hbt1 = getHibernateTemplate();
		hbt1.setFlushModeName("FLUSH_EAGER");
		hbt1.setCheckWriteOperations(false);
		try {
			hbt1.update(mbResultOfAppealMedicalboardUpdate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// getting the second updated entity
		List<ResultOfAppealMedicalboardUpdateDTO> mbiList = (List<ResultOfAppealMedicalboardUpdateDTO>) generalMap
				.get("mbUnfitExplanationList");

		// getting entity from the table
		List<MbResultOfAppealMedicalboardUnfitExpl> mbiListFromDatabase = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MbResultOfAppealMedicalboardUnfitExpl as mwd where mwd.ResultOfAppealMedicalboardUnfitExpl ='"
								+ resultOfAppealMedicalboardUpdateId + "'");

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if (mbiListFromDatabase != null && mbiList != null) {
			tx = sess.beginTransaction();
			int counter;
			for (MbResultOfAppealMedicalboardUnfitExpl mbResultOfAppealMedicalboardUnfitExpl : mbiListFromDatabase) {
				counter = 1;
				for (ResultOfAppealMedicalboardUpdateDTO mbResultOfAppealMedicalboardUpdateDTO : mbiList) {
					if (!mbResultOfAppealMedicalboardUpdateDTO.getId().equals(
							"")
							&& mbResultOfAppealMedicalboardUnfitExpl.getId() == Integer
									.parseInt(mbResultOfAppealMedicalboardUpdateDTO
											.getId())) {

						try {
							MbResultOfAppealMedicalboardUnfitExpl mbResultOfAppealMedicalboardUnfitExplUpdate = (MbResultOfAppealMedicalboardUnfitExpl) getHibernateTemplate()
									.get(
											MbResultOfAppealMedicalboardUnfitExpl.class,
											mbResultOfAppealMedicalboardUnfitExpl
													.getId());
							mbResultOfAppealMedicalboardUnfitExplUpdate
									.setUnfitExplanation(mbResultOfAppealMedicalboardUpdateDTO
											.getUnfitExplanation());
							hbt
									.update(mbResultOfAppealMedicalboardUnfitExplUpdate);

							mbResultOfAppealMedicalboardUpdateDTO.setId("0");// updating
							// DTO in
							// mbiList
							counter++;
							break;

						} catch (Exception e) {
							e.printStackTrace();
						}
					} else if (mbResultOfAppealMedicalboardUpdateDTO.getId()
							.equals("0")
							&& mbiList.size() > counter) {
						counter++;
						continue;
					} else if (!mbResultOfAppealMedicalboardUpdateDTO.getId()
							.equals("")) {
						try {
							MbResultOfAppealMedicalboardUnfitExpl mbResultOfAppealMedicalboardUnfitExplUpdate = (MbResultOfAppealMedicalboardUnfitExpl) getHibernateTemplate()
									.get(
											MbResultOfAppealMedicalboardUnfitExpl.class,
											mbResultOfAppealMedicalboardUnfitExpl
													.getId());

							hbt
									.delete(mbResultOfAppealMedicalboardUnfitExplUpdate);
							break;
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					}
				}

			}

			for (ResultOfAppealMedicalboardUpdateDTO mbResultOfAppealMedicalboardUpdateDTO : mbiList) {
				if (mbResultOfAppealMedicalboardUpdateDTO.getId() != null
						&& mbResultOfAppealMedicalboardUpdateDTO.getId()
								.equals("")) {

					hbt.setCheckWriteOperations(false);
					MbResultOfAppealMedicalboardMaster mbResultOfAppealMedicalboardMaster1 = new MbResultOfAppealMedicalboardMaster();
					MbResultOfAppealMedicalboardUnfitExpl mbResultOfAppealMedicalboardUnfitExplUpdate = new MbResultOfAppealMedicalboardUnfitExpl();
					mbResultOfAppealMedicalboardUnfitExplUpdate
							.setUnfitExplanation(mbResultOfAppealMedicalboardUpdateDTO
									.getUnfitExplanation());
					mbResultOfAppealMedicalboardMaster1
							.setId(resultOfAppealMedicalboardUpdateId);
					mbResultOfAppealMedicalboardUnfitExplUpdate
							.setResultOfAppealMedicalboardUnfitExpl(mbResultOfAppealMedicalboardMaster1);
					hbt.save(mbResultOfAppealMedicalboardUnfitExplUpdate);
				}
			}
			tx.commit();
			successfullyUpdated = true;

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
