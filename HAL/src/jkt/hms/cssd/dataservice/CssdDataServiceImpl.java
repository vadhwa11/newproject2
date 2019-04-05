/**  
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class  
 *  
 * Tables Used: 
 * @author  Create Date: 20.05.2009  Name: Othivadivel K R 
 * Revision Date:      		Revision By: 
 * @version 1.0  
 * @see 
 **/

package jkt.hms.cssd.dataservice;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import jkt.hms.masters.business.CssdAutoclaveEntryM;
import jkt.hms.masters.business.CssdAutoclaveEntryT;
import jkt.hms.masters.business.CssdAutoclaveReceiptM;
import jkt.hms.masters.business.CssdAutoclaveReceiptT;
import jkt.hms.masters.business.CssdAutoclaveRequestM;
import jkt.hms.masters.business.CssdAutoclaveRequestT;
import jkt.hms.masters.business.CssdInstrumentMaster;
import jkt.hms.masters.business.CssdMaterialMaster;
import jkt.hms.masters.business.CssdMaterialStockM;
import jkt.hms.masters.business.CssdMaterialStockT;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CssdDataServiceImpl extends HibernateDaoSupport implements
		CssdDataService {

	public Map<String, Object> showInstrumentMasterJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<CssdInstrumentMaster> instrumentMasterList = new ArrayList<CssdInstrumentMaster>();
		instrumentMasterList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.CssdInstrumentMaster c ");
		map.put("instrumentMasterList", instrumentMasterList);
		return map;
	}

	public boolean addInstrumentMaster(CssdInstrumentMaster cssdInstrumentMaster) {
		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(cssdInstrumentMaster);
			successfullyAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
			successfullyAdded = false;
		}
		return successfullyAdded;
	}

	public Map checkForExistingMasters(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List duplicateGeneralNameList = new ArrayList();
		List duplicateGeneralCodeList = new ArrayList();
		String pojoPropertyCode = "";
		String pojoPropertyName = "";

		String code = (String) generalMap.get("code");
		String name = (String) generalMap.get("name");
		String pojoName = (String) generalMap.get("pojoName");

		if (generalMap.get("pojoPropertyName") != null)
			pojoPropertyName = (String) generalMap.get("pojoPropertyName");
		if (generalMap.get("pojoPropertyCode") != null)
			pojoPropertyCode = (String) generalMap.get("pojoPropertyCode");

		if (!pojoPropertyCode.equals(""))
			duplicateGeneralCodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business." + pojoName
							+ " as g where g." + pojoPropertyCode + " ='"
							+ code + "'");
		if (!pojoPropertyName.equals(""))
			duplicateGeneralNameList = getHibernateTemplate().find(
					"from jkt.hms.masters.business." + pojoName
							+ " as g where g." + pojoPropertyName + " = '"
							+ name + "'");

		map.put("duplicateGeneralNameList", duplicateGeneralNameList);
		map.put("duplicateGeneralCodeList", duplicateGeneralCodeList);

		return map;
	}

	public Map<String, Object> searchInstrumentMaster(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<CssdInstrumentMaster> instrumentMasterList = new ArrayList<CssdInstrumentMaster>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		try {
			if ((map.get("code") != null)) {
				instrumentMasterList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.CssdInstrumentMaster c where c.InstrumentCode like '"
										+ map.get("code").toString()
										+ "%' order by c.InstrumentCode");
			} else {
				instrumentMasterList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.CssdInstrumentMaster c where c.InstrumentName like '%"
										+ map.get("name").toString()
										+ "%' order by c.InstrumentName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		paramMap.put("instrumentMasterList", instrumentMasterList);
		return paramMap;
	}

	public boolean editInstrumentMaster(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String changedBy = "";
		String instrumentCode = null;
		String instrumentName = null;
		int deptId = 0;
		int id = 0;
		try {
			id = (Integer) generalMap.get("id");
			instrumentCode = (String) generalMap.get("code");
			instrumentName = (String) generalMap.get("name");
			deptId = (Integer) generalMap.get("deptId");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			e.printStackTrace();
		}

		CssdInstrumentMaster cssdInstrumentMaster = (CssdInstrumentMaster) getHibernateTemplate()
				.get(CssdInstrumentMaster.class, id);

		cssdInstrumentMaster.setInstrumentName(instrumentName);
		cssdInstrumentMaster.setLastChgBy(changedBy);
		cssdInstrumentMaster.setLastChgDate(currentDate);
		cssdInstrumentMaster.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(cssdInstrumentMaster);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteInstrumentMaster(Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		CssdInstrumentMaster cssdInstrumentMaster = new CssdInstrumentMaster();
		cssdInstrumentMaster = (CssdInstrumentMaster) getHibernateTemplate()
				.get(CssdInstrumentMaster.class, (Integer) generalMap.get("id"));
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				cssdInstrumentMaster.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				cssdInstrumentMaster.setStatus("y");
				dataDeleted = false;
			}
		}
		cssdInstrumentMaster.setLastChgBy(changedBy);
		cssdInstrumentMaster.setLastChgDate(currentDate);
		cssdInstrumentMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(cssdInstrumentMaster);
		return dataDeleted;
	}

	public Map<String, Object> showMaterialStockEntryJsp(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		List<CssdMaterialStockM> cssdMaterialStockMList = new ArrayList<CssdMaterialStockM>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			masDepartmentList = hbt
					.find("from jkt.hms.masters.business.MasDepartment m where m.Id="
							+ box.getInt("deptId") + " and m.Status='y'");
			masEmployeeList = hbt
					.find("from jkt.hms.masters.business.MasEmployee m where m.Status='y' and m.Department.Id = "
							+ box.getInt("deptId"));
			cssdMaterialStockMList = hbt
					.find("from jkt.hms.masters.business.CssdMaterialStockM m where m.Department.Id="
							+ box.getInt("deptId") + " order by m.Id desc");
			map.put("masDepartmentList", masDepartmentList);
			map.put("masEmployeeList", masEmployeeList);
			map.put("cssdMaterialStockMList", cssdMaterialStockMList);
			map.put("entryNo", getDepartmentStockEntryNo(box.getInt("deptId")));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getMaterialNamesForAutocomplete(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<CssdMaterialMaster> cssdMaterialMasterList = new ArrayList<CssdMaterialMaster>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String queryString = null;
			String str = "%" + dataMap.get("autoHint") + "%";
			Criteria c = session.createCriteria(CssdMaterialMaster.class);
			c = c.add(Restrictions.like("MaterialName", str));// .createAlias("Department",
																// "dt").add(Restrictions.eq("dt.Id",
																// (Integer)
																// dataMap.get("deptId")))
			c.setFirstResult(0);
			c.setMaxResults(10);
			cssdMaterialMasterList = c.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("cssdMaterialMasterList", cssdMaterialMasterList);
		return map;
	}

	public String getDepartmentStockEntryNo(Integer deptId) {
		String entryNo = "";
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		String currentYear = "" + gregorianCalendar.get(Calendar.YEAR);
		List<CssdMaterialStockM> cssdInstrumentStockMList = new ArrayList<CssdMaterialStockM>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			cssdInstrumentStockMList = hbt
					.find("from jkt.hms.masters.business.CssdMaterialStockM m where m.Department.Id="
							+ deptId + " order by m.Id desc");
			if (cssdInstrumentStockMList != null
					&& cssdInstrumentStockMList.size() > 0) {
				entryNo = cssdInstrumentStockMList.get(0).getEntryNo();
				int no = Integer.parseInt(entryNo.substring(0, entryNo
						.indexOf("/")));
				no++;
				entryNo = no + "/" + currentYear;
			} else {
				entryNo = "1" + "/" + currentYear;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entryNo;
	}

	public Map<String, Object> addAndRefreshGrid(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<CssdMaterialStockM> cssdMaterialStockMList = new ArrayList<CssdMaterialStockM>();
		List<CssdMaterialMaster> cssdMaterialMasterList = new ArrayList<CssdMaterialMaster>();
		List<CssdMaterialStockT> cssdMaterialStockTList = new ArrayList<CssdMaterialStockT>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			cssdMaterialStockMList = hbt
					.find("from jkt.hms.masters.business.CssdMaterialStockM m where m.Department.Id="
							+ box.getInt("deptId")
							+ " and m.EntryNo = '"
							+ box.getString("entryNo") + "'");
			cssdMaterialMasterList = hbt
					.find("from jkt.hms.masters.business.CssdMaterialMaster m where  m.MaterialCode = '"
							+ box.getString("materialCode") + "'");
			// m.Department.Id="+ box.getInt("deptId") + " and
			if (cssdMaterialStockMList != null
					&& cssdMaterialStockMList.size() > 0) {

				CssdMaterialStockT CssdMaterialStockT = new CssdMaterialStockT();
				CssdMaterialStockT.setMaterial(cssdMaterialMasterList.get(0));
				CssdMaterialStockT.setStockM(cssdMaterialStockMList.get(0));
				CssdMaterialStockT.setQty(box.getInt("qty"));
				CssdMaterialStockT.setRemarks(box.getString("remarks"));
				hbt.save(CssdMaterialStockT);
				hbt.refresh(CssdMaterialStockT);
			} else {
				CssdMaterialStockM CssdMaterialStockM = new CssdMaterialStockM();
				CssdMaterialStockM.setEntryNo(box.getString("entryNo"));
				CssdMaterialStockM.setDepartment(new MasDepartment(box
						.getInt("deptId")));
				CssdMaterialStockM.setApprovedBy(new MasEmployee(box
						.getInt("approvedBy")));
				CssdMaterialStockM.setLastChgBy(box.getString("lastChgBy"));
				CssdMaterialStockM.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("lastChgDate")));
				CssdMaterialStockM.setLastChgTime(box.getString("lastChgTime"));
				hbt.save(CssdMaterialStockM);
				hbt.refresh(CssdMaterialStockM);

				CssdMaterialStockT CssdMaterialStockT = new CssdMaterialStockT();
				CssdMaterialStockT.setMaterial(cssdMaterialMasterList.get(0));
				CssdMaterialStockT.setStockM(CssdMaterialStockM);
				CssdMaterialStockT.setQty(box.getInt("qty"));
				CssdMaterialStockT.setRemarks(box.getString("remarks"));
				hbt.save(CssdMaterialStockT);
				hbt.refresh(CssdMaterialStockT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getStockGridData(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<CssdMaterialStockM> cssdMaterialStockMList = new ArrayList<CssdMaterialStockM>();
		List<CssdMaterialStockT> cssdMaterialStockTList = new ArrayList<CssdMaterialStockT>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			cssdMaterialStockMList = hbt
					.find("from jkt.hms.masters.business.CssdMaterialStockM m where m.Department.Id="
							+ box.getInt("deptId")
							+ " and m.EntryNo = '"
							+ box.getString("entryNo") + "'");
			int pageno = 1;
			int numOfRows = 5;
			try {
				if (box.get("pageno") != null) {
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			} catch (Exception e) {
				// e.printStackTrace();
				pageno = 1;
			}

			try {
				if (box.get("numOfRows") != null && box.get("numOfRows") != "") {
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			map.put("pageno", pageno);
			map.put("numOfRows", numOfRows);

			int first = (pageno - 1) * numOfRows;
			int totalRecords = 0;
			if (cssdMaterialStockMList != null
					&& cssdMaterialStockMList.size() > 0) {
				int cssdMaterialStockMId = cssdMaterialStockMList.get(0)
						.getId();

				String qry = "SELECT count(*) FROM cssd_material_stock_t where stock_m_id = "
						+ cssdMaterialStockMId;
				try {
					totalRecords = Integer.parseInt(session.createSQLQuery(qry)
							.list().get(0).toString());
				} catch (Exception e) {
					totalRecords = 0;
				}

				map.put("totalRecords", totalRecords);

				double totalPages = 0.0;
				totalPages = (double) totalRecords / (double) numOfRows;
				Double d = new Double(Math.ceil(totalPages));
				map.put("totalPages", d.intValue());

				Criteria c = session
						.createCriteria(CssdMaterialStockT.class)
						.add(Restrictions.eq("StockM.Id", cssdMaterialStockMId));
				c.setFirstResult(first);

				if (totalRecords < numOfRows)
					c.setMaxResults(totalRecords);
				else
					c.setMaxResults(numOfRows);

				cssdMaterialStockTList = c.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (!box.contains("numOfRows"))
				box.put("numOfRows", 5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("cssdMaterialStockMList", cssdMaterialStockMList);
		map.put("cssdMaterialStockTList", cssdMaterialStockTList);
		return map;
	}

	public Map<String, Object> showAutoclaveRequestJsp(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		List<CssdAutoclaveRequestM> cssdAutoclaveRequestMList = new ArrayList<CssdAutoclaveRequestM>();
		List<CssdInstrumentMaster> cssdInstrumentMasterList = new ArrayList<CssdInstrumentMaster>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			masDepartmentList = hbt
					.find("from jkt.hms.masters.business.MasDepartment m where m.Id="
							+ box.getInt("deptId") + " and m.Status='y'");
			masEmployeeList = hbt
					.find("from jkt.hms.masters.business.MasEmployee m where m.Status='y' and m.Department.Id = "
							+ box.getInt("deptId"));
			cssdAutoclaveRequestMList = hbt
					.find("from jkt.hms.masters.business.CssdAutoclaveRequestM m where m.Department.Id="
							+ box.getInt("deptId") + " order by m.Id desc");
			cssdInstrumentMasterList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.CssdInstrumentMaster c where c.Status = 'y'");

			map.put("masDepartmentList", masDepartmentList);
			map.put("masEmployeeList", masEmployeeList);
			map.put("cssdAutoclaveRequestMList", cssdAutoclaveRequestMList);
			map.put("cssdInstrumentMasterList", cssdInstrumentMasterList);
			map
					.put("orderNo", getAutoclaveRequestOrderNo(box
							.getInt("deptId")));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return map;
	}

	public String getAutoclaveRequestOrderNo(Integer deptId) {
		String orderNo = "";
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		String currentYear = "" + gregorianCalendar.get(Calendar.YEAR);
		List<CssdAutoclaveRequestM> cssdAutoclaveRequestMList = new ArrayList<CssdAutoclaveRequestM>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			cssdAutoclaveRequestMList = hbt
					.find("from jkt.hms.masters.business.CssdAutoclaveRequestM m where m.Department.Id="
							+ deptId + " order by m.Id desc");
			if (cssdAutoclaveRequestMList != null
					&& cssdAutoclaveRequestMList.size() > 0) {
				orderNo = cssdAutoclaveRequestMList.get(0).getOrderNo();
				int no = Integer.parseInt(orderNo.substring(0, orderNo
						.indexOf("/")));
				no++;
				orderNo = no + "/" + currentYear;
			} else {
				orderNo = "1" + "/" + currentYear;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderNo;
	}

	public String getAutoclaveReceiptNo(Integer deptId) {
		String receiptNo = "";
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		String currentYear = "" + gregorianCalendar.get(Calendar.YEAR);
		List<CssdAutoclaveReceiptM> cssdAutoclaveReceiptMList = new ArrayList<CssdAutoclaveReceiptM>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			cssdAutoclaveReceiptMList = hbt
					.find("from jkt.hms.masters.business.CssdAutoclaveReceiptM m where m.Department.Id="
							+ deptId + " order by m.Id desc");
			if (cssdAutoclaveReceiptMList != null
					&& cssdAutoclaveReceiptMList.size() > 0) {
				receiptNo = cssdAutoclaveReceiptMList.get(0).getReceiptNo();
				int no = Integer.parseInt(receiptNo.substring(0, receiptNo
						.indexOf("/")));
				no++;
				receiptNo = no + "/" + currentYear;
			} else {
				receiptNo = "1" + "/" + currentYear;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return receiptNo;
	}

	public Map<String, Object> getAutoclaveRequestMaterialNamesForAutocomplete(
			Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<CssdMaterialMaster> cssdMaterialMasterList = new ArrayList<CssdMaterialMaster>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String queryString = null;
			String str = "%" + dataMap.get("autoHint") + "%";
			String orderNo = dataMap.get("orderNo").toString();
			int deptId = Integer.parseInt(dataMap.get("deptId").toString());
			String qry1 = "SELECT distinct t.material_id FROM cssd_autoclave_request_t t, cssd_autoclave_request_m m where m.order_no ='"
					+ orderNo
					+ "' and m.request_id = t.request_m_id and m.department_id = "
					+ deptId;
			List objectList1 = (List) session.createSQLQuery(qry1).list();

			String qry2 = "SELECT distinct b.material_id FROM cssd_material_stock_m a, cssd_material_stock_t b where a.department_id = "
					+ deptId;
			List objectList2 = (List) session.createSQLQuery(qry2).list();
			Criteria c = null;

			if (objectList2 != null && objectList2.size() > 0) {
				if (objectList1 != null && objectList1.size() > 0) {
					c = session.createCriteria(CssdMaterialMaster.class).add(
							Restrictions.like("MaterialName", str)).add(
							Restrictions.in("Id", objectList2)).add(
							Restrictions
									.not(Restrictions.in("Id", objectList1)));// .add(Restrictions.eq("Department.Id",
																				// deptId))
				} else {
					c = session.createCriteria(CssdMaterialMaster.class).add(
							Restrictions.like("MaterialName", str)).add(
							Restrictions.in("Id", objectList2));// .add(Restrictions.eq("Department.Id",
																// deptId))
				}
				c.setFirstResult(0);
				c.setMaxResults(10);
				cssdMaterialMasterList = c.list();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("cssdMaterialMasterList", cssdMaterialMasterList);
		return map;
	}

	public Map<String, Object> addAndRefreshAutoclaveRequestGrid(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<CssdAutoclaveRequestM> cssdAutoclaveRequestMList = new ArrayList<CssdAutoclaveRequestM>();
		List<CssdInstrumentMaster> cssdInstrumentMasterList = new ArrayList<CssdInstrumentMaster>();
		List<CssdMaterialMaster> cssdMaterialMasterList = new ArrayList<CssdMaterialMaster>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			cssdAutoclaveRequestMList = hbt
					.find("from jkt.hms.masters.business.CssdAutoclaveRequestM m where m.Department.Id="
							+ box.getInt("deptId")
							+ " and m.OrderNo = '"
							+ box.getString("orderNo") + "'");
			cssdInstrumentMasterList = hbt
					.find("from jkt.hms.masters.business.CssdInstrumentMaster m where m.InstrumentCode = '"
							+ box.getString("instrumentCode") + "'");
			cssdMaterialMasterList = hbt
					.find("from jkt.hms.masters.business.CssdMaterialMaster m where m.Department.Id="
							+ box.getInt("deptId")
							+ " and m.MaterialCode = '"
							+ box.getString("materialCode") + "'");

			if (cssdAutoclaveRequestMList != null
					&& cssdAutoclaveRequestMList.size() > 0) {

				CssdAutoclaveRequestT cssdAutoclaveRequestT = new CssdAutoclaveRequestT();
				cssdAutoclaveRequestT.setInstrument(cssdInstrumentMasterList
						.get(0));
				cssdAutoclaveRequestT
						.setMaterial(cssdMaterialMasterList.get(0));
				cssdAutoclaveRequestT.setRequestM(cssdAutoclaveRequestMList
						.get(0));
				cssdAutoclaveRequestT.setQty(box.getInt("qty"));
				cssdAutoclaveRequestT.setRemarks(box.getString("remarks"));
				cssdAutoclaveRequestT.setStatus("o");
				hbt.save(cssdAutoclaveRequestT);
				hbt.refresh(cssdAutoclaveRequestT);
			} else {
				CssdAutoclaveRequestM cssdAutoclaveRequestM = new CssdAutoclaveRequestM();
				cssdAutoclaveRequestM.setOrderNo(box.getString("orderNo"));
				cssdAutoclaveRequestM.setDepartment(new MasDepartment(box
						.getInt("deptId")));
				cssdAutoclaveRequestM.setOrderBy(new MasEmployee(box
						.getInt("orderBy")));
				// cssdAutoclaveRequestM.setIssuedTo(new
				// MasEmployee(box.getInt("issueTo")));
				cssdAutoclaveRequestM.setOrderDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("orderDate")));
				cssdAutoclaveRequestM.setOrderTime(box.getString("orderTime"));
				cssdAutoclaveRequestM.setLastChgBy(box.getString("lastChgBy"));
				cssdAutoclaveRequestM.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("lastChgDate")));
				cssdAutoclaveRequestM.setLastChgTime(box
						.getString("lastChgTime"));
				cssdAutoclaveRequestM.setStatus("o");
				hbt.save(cssdAutoclaveRequestM);
				hbt.refresh(cssdAutoclaveRequestM);

				CssdAutoclaveRequestT cssdAutoclaveRequestT = new CssdAutoclaveRequestT();
				cssdAutoclaveRequestT.setInstrument(cssdInstrumentMasterList.get(0));
				cssdAutoclaveRequestT.setMaterial(cssdMaterialMasterList.get(0));
				cssdAutoclaveRequestT.setRequestM(cssdAutoclaveRequestM);
				cssdAutoclaveRequestT.setQty(box.getInt("qty"));
				cssdAutoclaveRequestT.setRemarks(box.getString("remarks"));
				cssdAutoclaveRequestT.setStatus("o");
				hbt.save(cssdAutoclaveRequestT);
				hbt.refresh(cssdAutoclaveRequestT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getAutoclaveRequestStockGridData(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		List<CssdAutoclaveRequestM> cssdAutoclaveRequestMList = new ArrayList<CssdAutoclaveRequestM>();
		List<CssdAutoclaveRequestT> cssdAutoclaveRequestTList = new ArrayList<CssdAutoclaveRequestT>();
		List<CssdInstrumentMaster> cssdInstrumentMasterList = new ArrayList<CssdInstrumentMaster>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			cssdAutoclaveRequestMList = hbt
					.find("from jkt.hms.masters.business.CssdAutoclaveRequestM m where m.Department.Id="
							+ box.getInt("deptId")
							+ " and m.OrderNo = '"
							+ box.getString("orderNo") + "'");

			cssdInstrumentMasterList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.CssdInstrumentMaster c where c.Status = 'y'");

			int pageno = 1;
			int numOfRows = 5;
			try {
				if (box.get("pageno") != null) {
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			} catch (Exception e) {
				// e.printStackTrace();
				pageno = 1;
			}

			try {
				if (box.get("numOfRows") != null && box.get("numOfRows") != "") {
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			map.put("pageno", pageno);
			map.put("numOfRows", numOfRows);

			int first = (pageno - 1) * numOfRows;
			int totalRecords = 0;
			if (cssdAutoclaveRequestMList != null
					&& cssdAutoclaveRequestMList.size() > 0) {
				int cssdAutoclaveRequestMId = cssdAutoclaveRequestMList.get(0)
						.getId();

				String qry = "SELECT count(*) FROM cssd_autoclave_request_t where request_m_id = "
						+ cssdAutoclaveRequestMId;
				try {
					totalRecords = Integer.parseInt(session.createSQLQuery(qry)
							.list().get(0).toString());

				} catch (Exception e) {
					totalRecords = 0;
				}

				map.put("totalRecords", totalRecords);

				double totalPages = 0.0;
				totalPages = (double) totalRecords / (double) numOfRows;
				Double d = new Double(Math.ceil(totalPages));
				map.put("totalPages", d.intValue());

				Criteria c = session
						.createCriteria(CssdAutoclaveRequestT.class).add(
								Restrictions.eq("RequestM.Id",
										cssdAutoclaveRequestMId));

				c.setFirstResult(first);

				if (totalRecords < numOfRows)
					c.setMaxResults(totalRecords);
				else
					c.setMaxResults(numOfRows);

				cssdAutoclaveRequestTList = c.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (!box.contains("numOfRows"))
				box.put("numOfRows", 5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("cssdAutoclaveRequestMList", cssdAutoclaveRequestMList);
		map.put("cssdAutoclaveRequestTList", cssdAutoclaveRequestTList);
		map.put("cssdInstrumentMasterList", cssdInstrumentMasterList);
		return map;
	}

	public Map<String, Object> showAutoclaveEntryJsp(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<CssdAutoclaveRequestM> cssdAutoclaveRequestMList = new ArrayList<CssdAutoclaveRequestM>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			cssdAutoclaveRequestMList = hbt
					.find("from jkt.hms.masters.business.CssdAutoclaveRequestM m where m.Status='o'");
			map.put("cssdAutoclaveRequestMList", cssdAutoclaveRequestMList);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> showAutoclaveEntryDetailJsp(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<CssdAutoclaveRequestM> cssdAutoclaveRequestMList = new ArrayList<CssdAutoclaveRequestM>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		Session session = (Session) getSession();
		try {
			Vector requestId = box.getVector("requestId");
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();

			List objectList = new ArrayList();

			for (int i = 0; i < requestId.size(); i++) {
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				String hql2 = "update from jkt.hms.masters.business.CssdAutoclaveRequestT as a set a.Status = 'o'"
						+ " where a.RequestM.Id= "
						+ Integer.parseInt(requestId.get(i).toString())
						+ " and a.Status='t'";
				Query query2 = session.createQuery(hql2);
				int row2 = query2.executeUpdate();
				objectList.add(Integer.valueOf(requestId.get(i).toString()));
			}

			cssdAutoclaveRequestMList = session.createCriteria(
					CssdAutoclaveRequestM.class).add(
					Restrictions.in("Id", objectList)).list();

			box.put("objectList", objectList);

			/*
			 * cssdAutoclaveRequestMList = hbt.find("from
			 * jkt.hms.masters.business.CssdAutoclaveRequestM m where m.Id =" +
			 * box.getInt("requestId"));
			 */
			masEmployeeList = hbt
					.find("from jkt.hms.masters.business.MasEmployee m where m.Status='y' and m.Department.Id = "
							+ box.getInt("deptId"));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map = getAutoclaveRequestEntryGridDataForAutoclaveEntry(box);
		map.put("masEmployeeList", masEmployeeList);
		map.put("entryNo", getAutoclaveEntryNo(box.getInt("deptId")));
		map.put("lotNo", getAutoclaveEntryLotNo(box.getInt("deptId")));
		return map;
	}

	public String getAutoclaveEntryNo(Integer deptId) {
		String entryNo = "";
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		String currentYear = "" + gregorianCalendar.get(Calendar.YEAR);
		List<CssdAutoclaveEntryM> cssdAutoclaveEntryMList = new ArrayList<CssdAutoclaveEntryM>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			cssdAutoclaveEntryMList = hbt
					.find("from jkt.hms.masters.business.CssdAutoclaveEntryM m order by m.Id desc");
			if (cssdAutoclaveEntryMList != null
					&& cssdAutoclaveEntryMList.size() > 0) {
				entryNo = cssdAutoclaveEntryMList.get(0).getEntryNo();
				int no = Integer.parseInt(entryNo.substring(0, entryNo
						.indexOf("/")));
				no++;
				entryNo = no + "/" + currentYear;
			} else {
				entryNo = "1" + "/" + currentYear;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entryNo;
	}

	public String getAutoclaveEntryLotNo(Integer deptId) {
		String lotNo = "";
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		StringBuffer currentYear = new StringBuffer();

		if (gregorianCalendar.get(Calendar.DATE) < 10) {
			currentYear.append("0");
			currentYear.append(gregorianCalendar.get(Calendar.DATE));
		} else {
			currentYear.append(gregorianCalendar.get(Calendar.DATE));
		}

		if (gregorianCalendar.get(Calendar.MONTH) + 1 < 10) {
			currentYear.append("0");
			currentYear.append(gregorianCalendar.get(Calendar.MONTH) + 1);
		} else {
			currentYear.append(gregorianCalendar.get(Calendar.MONTH) + 1);
		}

		currentYear.append(gregorianCalendar.get(Calendar.YEAR));

		List<CssdAutoclaveEntryM> cssdAutoclaveEntryMList = new ArrayList<CssdAutoclaveEntryM>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			cssdAutoclaveEntryMList = hbt
					.find("from jkt.hms.masters.business.CssdAutoclaveEntryM m where m.LotNo like '%"
							+ currentYear.toString() + "%' order by m.Id desc");
			if (cssdAutoclaveEntryMList != null
					&& cssdAutoclaveEntryMList.size() > 0) {
				lotNo = cssdAutoclaveEntryMList.get(0).getLotNo();
				int no = Integer.parseInt(lotNo
						.substring(lotNo.indexOf("/") + 4));
				no++;
				lotNo = currentYear.toString() + "/Lot" + no;
			} else {
				lotNo = currentYear.toString() + "/Lot" + "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lotNo;
	}

	public Map<String, Object> getAutoclaveRequestEntryGridDataForAutoclaveEntry(
			Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		List<CssdAutoclaveRequestM> cssdAutoclaveRequestMList = new ArrayList<CssdAutoclaveRequestM>();
		List<CssdAutoclaveRequestT> cssdAutoclaveRequestTList = new ArrayList<CssdAutoclaveRequestT>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			List objectList = new ArrayList();
			Vector requestId = box.getVector("requestId");
			for (int i = 0; i < requestId.size(); i++) {
				objectList.add(Integer.valueOf(requestId.get(i).toString()));
			}

			cssdAutoclaveRequestMList = session.createCriteria(
					CssdAutoclaveRequestM.class).add(
					Restrictions.in("Id", objectList)).list();

			int pageno = 1;
			int numOfRows = 5;
			try {
				if (box.get("pageno") != null) {
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			} catch (Exception e) {
				// e.printStackTrace();
				pageno = 1;
			}

			try {
				if (box.get("numOfRows") != null && box.get("numOfRows") != "") {
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			map.put("pageno", pageno);
			map.put("numOfRows", numOfRows);
			map.put("requestId", box.getInt("requestId"));

			int totalRecords = 0;
			if (cssdAutoclaveRequestMList != null
					&& cssdAutoclaveRequestMList.size() > 0) {
				int cssdAutoclaveRequestMId = cssdAutoclaveRequestMList.get(0)
						.getId();

				Criteria crit = session.createCriteria(
						CssdAutoclaveRequestT.class).add(
						Restrictions.eq("Status", "o")).add(
						Restrictions.in("RequestM.Id", objectList));
				crit.setProjection(Projections.rowCount());

				List results = crit.list();

				try {
					totalRecords = Integer.parseInt(results.get(0).toString());
				} catch (Exception e) {
					totalRecords = 0;
				}

				map.put("totalRecords", totalRecords);

				double totalPages = 0.0;
				totalPages = (double) totalRecords / (double) numOfRows;
				Double d = new Double(Math.ceil(totalPages));
				map.put("totalPages", d.intValue());

				Criteria c = session
						.createCriteria(CssdAutoclaveRequestT.class).add(
								Restrictions.eq("Status", "o")).add(
								Restrictions.in("RequestM.Id", objectList));

				int first = (pageno - 1) * numOfRows;

				c.setFirstResult(first);

				if (totalRecords < numOfRows)
					c.setMaxResults(totalRecords);
				else
					c.setMaxResults(numOfRows);

				cssdAutoclaveRequestTList = c.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (!box.contains("numOfRows"))
				box.put("numOfRows", 5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("cssdAutoclaveRequestMList", cssdAutoclaveRequestMList);
		map.put("cssdAutoclaveRequestTList", cssdAutoclaveRequestTList);
		return map;
	}

	public Map<String, Object> submitEntryDetails(Box box) {
		// TODO Auto-generated method stub
		String date = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		String[] currentDate = date.split("/");
		String currentMonth = currentDate[0];
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<CssdAutoclaveRequestM> cssdAutoclaveRequestMList = new ArrayList<CssdAutoclaveRequestM>();
		List<CssdAutoclaveRequestT> cssdAutoclaveRequestTList = new ArrayList<CssdAutoclaveRequestT>();
		List<CssdInstrumentMaster> cssdInstrumentMasterList = new ArrayList<CssdInstrumentMaster>();
		List<CssdAutoclaveEntryM> cssdAutoclaveEntryMList = new ArrayList<CssdAutoclaveEntryM>();
		List<CssdAutoclaveEntryT> cssdAutoclaveEntryTList = new ArrayList<CssdAutoclaveEntryT>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			List objectList = new ArrayList();
			Vector requestId = box.getVector("requestId");
			for (int i = 0; i < requestId.size(); i++) {
				objectList.add(Integer.valueOf(requestId.get(i).toString()));
			}

			cssdAutoclaveRequestTList = session.createCriteria(
					CssdAutoclaveRequestT.class).add(
					Restrictions.in("RequestM.Id", objectList)).add(
					Restrictions.eq("Status", "o")).list();

			CssdAutoclaveEntryM cssdAutoclaveEntryM = new CssdAutoclaveEntryM();
			cssdAutoclaveEntryM.setEntryNo(box.getString("entryNo"));
			cssdAutoclaveEntryM.setEntryBy(new MasEmployee(box
					.getInt("autoclaveBy")));
			cssdAutoclaveEntryM.setChemicalIndicator(box
					.getString("chemical_indicator"));
			cssdAutoclaveEntryM.setCycleNo(box.getString("cycle_no"));
			cssdAutoclaveEntryM.setEntryStatus(box.getString("entry_status"));
			cssdAutoclaveEntryM.setLotNo(box.getString("lot_no"));
			cssdAutoclaveEntryM.setPressure(box.getString("pressure"));
			cssdAutoclaveEntryM.setSterilizationType(box
					.getString("sterilization_type"));
			cssdAutoclaveEntryM.setTemperature(box.getString("temperature"));
			cssdAutoclaveEntryM.setTotalTime(box.getString("total_time"));
			cssdAutoclaveEntryM.setEntryDate(HMSUtil.dateFormatterDDMMYYYY(box
					.getString("autoclaveDate")));
			cssdAutoclaveEntryM.setEntryTime(box.getString("autoclaveTime"));
			cssdAutoclaveEntryM.setLastChgBy(box.getString("lastChgBy"));
			cssdAutoclaveEntryM.setLastChgDate(HMSUtil
					.dateFormatterDDMMYYYY(box.getString("lastChgDate")));
			cssdAutoclaveEntryM.setLastChgTime(box.getString("lastChgTime"));
			hbt.save(cssdAutoclaveEntryM);
			hbt.refresh(cssdAutoclaveEntryM);

			// org.springframework.orm.hibernate3.HibernateTemplate hbt2 =
			// getHibernateTemplate();
			// hbt.setFlushModeName("FLUSH_EAGER");
			// hbt.setCheckWriteOperations(false);
			List<TransactionSequence> minorWorkNoList = new ArrayList<TransactionSequence>();
			minorWorkNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "BCN")).list();

			if (minorWorkNoList.size() > 0) {
				for (TransactionSequence transactionSequence : minorWorkNoList) {
					TransactionSequence obj = transactionSequence;
					int id1 = obj.getId();
					int seqNo = obj.getTransactionSequenceNumber();
					TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
							.load(TransactionSequence.class, id1);
					// transactionSequenceObj.setTransactionSequenceNumber(++seqNo);

					if (!currentMonth.equalsIgnoreCase(transactionSequenceObj
							.getMonth().toString())) {
						transactionSequenceObj.setTransactionSequenceNumber(1);
						transactionSequenceObj.setMonth(Integer
								.parseInt(currentMonth));
						seqNo = 1;
					} else {
						transactionSequenceObj
								.setTransactionSequenceNumber(++seqNo);
					}

					hbt.update(transactionSequenceObj);
				}
			}

			if (cssdAutoclaveRequestTList != null
					&& cssdAutoclaveRequestTList.size() > 0) {
				for (CssdAutoclaveRequestT cssdAutoclaveRequestT : cssdAutoclaveRequestTList) {
					CssdAutoclaveEntryT cssdAutoclaveEntryT = new CssdAutoclaveEntryT();
					cssdAutoclaveEntryT.setEntryM(cssdAutoclaveEntryM);
					cssdAutoclaveEntryT.setMaterial(cssdAutoclaveRequestT
							.getMaterial());
					cssdAutoclaveEntryT.setInstrument(cssdAutoclaveRequestT
							.getInstrument());
					cssdAutoclaveEntryT.setReceiptStatus("o");
					cssdAutoclaveEntryT.setRequest(cssdAutoclaveRequestT
							.getRequestM());
					cssdAutoclaveEntryT.setQty(cssdAutoclaveRequestT.getQty());
					cssdAutoclaveEntryT.setRemarks(cssdAutoclaveRequestT
							.getRemarks());
					hbt.save(cssdAutoclaveEntryT);
					hbt.refresh(cssdAutoclaveEntryT);
				}
			}

			for (int i = 0; i < requestId.size(); i++) {
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				String hql2 = "update from jkt.hms.masters.business.CssdAutoclaveRequestT as a set a.Status = 'p'"
						+ " where a.RequestM.Id= "
						+ Integer.parseInt(requestId.get(i).toString())
						+ " and a.Status='o'";
				Query query2 = session.createQuery(hql2);
				int row2 = query2.executeUpdate();
			}

			for (int i = 0; i < requestId.size(); i++) {
				Criteria c = session
						.createCriteria(CssdAutoclaveRequestT.class)
						.add(
								Restrictions.eq("RequestM.Id", Integer
										.parseInt(requestId.get(i).toString())))
						.add(Restrictions.eq("Status", "t"));
				cssdAutoclaveRequestTList = c.list();

				if (cssdAutoclaveRequestTList != null
						&& cssdAutoclaveRequestTList.size() > 0) {
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					String hql1 = "update from jkt.hms.masters.business.CssdAutoclaveRequestT as a set a.Status = 'o'"
							+ " where a.RequestM.Id= "
							+ Integer.parseInt(requestId.get(i).toString())
							+ " and a.Status='t'";
					Query query1 = session.createQuery(hql1);
					int row1 = query1.executeUpdate();
				} else {
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					CssdAutoclaveRequestM cssdAutoclaveRequestM = (CssdAutoclaveRequestM) hbt
							.load(CssdAutoclaveRequestM.class, Integer
									.parseInt(requestId.get(i).toString()));
					cssdAutoclaveRequestM.setStatus("p");
					hbt.update(cssdAutoclaveRequestM);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> deleteCssdEntryGridItems(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<CssdAutoclaveRequestT> cssdAutoclaveRequestTList = new ArrayList<CssdAutoclaveRequestT>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			cssdAutoclaveRequestTList = session.createCriteria(
					CssdAutoclaveRequestT.class).add(
					Restrictions.eq("RequestM.Id", box.getInt("request_m_id")))
					.add(Restrictions.eq("Id", box.getInt("request_t_id")))
					.list();

			if (cssdAutoclaveRequestTList != null
					&& cssdAutoclaveRequestTList.size() > 0) {
				CssdAutoclaveRequestT cssdAutoclaveRequestT = (CssdAutoclaveRequestT) cssdAutoclaveRequestTList
						.get(0);
				cssdAutoclaveRequestT.setStatus("t");
				hbt.update(cssdAutoclaveRequestT);
				hbt.refresh(cssdAutoclaveRequestT);

			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return map;

	}

	public Map<String, Object> showMaterialMasterJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<CssdMaterialMaster> materialMasterList = new ArrayList<CssdMaterialMaster>();
		materialMasterList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.CssdMaterialMaster c where c.Department.Id = "
						+ box.getInt("deptId"));
		map.put("materialMasterList", materialMasterList);
		return map;
	}

	public boolean addMaterialMaster(CssdMaterialMaster cssdMaterialMaster) {
		boolean successfullyAdded = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(cssdMaterialMaster);
			successfullyAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
			successfullyAdded = false;
		}
		return successfullyAdded;
	}

	public boolean deleteMaterialMaster(Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		CssdMaterialMaster cssdMaterialMaster = new CssdMaterialMaster();
		cssdMaterialMaster = (CssdMaterialMaster) getHibernateTemplate().get(
				CssdMaterialMaster.class, (Integer) generalMap.get("id"));
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				cssdMaterialMaster.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				cssdMaterialMaster.setStatus("y");
				dataDeleted = false;
			}
		}
		cssdMaterialMaster.setLastChgBy(changedBy);
		cssdMaterialMaster.setLastChgDate(currentDate);
		cssdMaterialMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(cssdMaterialMaster);
		return dataDeleted;
	}

	public boolean editMaterialMaster(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String changedBy = "";
		String materialCode = null;
		String materialName = null;
		int deptId = 0;
		int id = 0;
		try {
			id = (Integer) generalMap.get("id");
			materialCode = (String) generalMap.get("code");
			materialName = (String) generalMap.get("name");
			deptId = (Integer) generalMap.get("deptId");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			e.printStackTrace();
		}

		CssdMaterialMaster cssdMaterialMaster = (CssdMaterialMaster) getHibernateTemplate()
				.get(CssdMaterialMaster.class, id);

		cssdMaterialMaster.setMaterialName(materialName);
		cssdMaterialMaster.setLastChgBy(changedBy);
		cssdMaterialMaster.setLastChgDate(currentDate);
		cssdMaterialMaster.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(cssdMaterialMaster);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public Map<String, Object> searchMaterialMaster(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<CssdMaterialMaster> materialMasterList = new ArrayList<CssdMaterialMaster>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		try {
			if ((map.get("code") != null)) {
				materialMasterList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.CssdMaterialMaster c where c.MaterialCode like '"
										+ map.get("code").toString()
										+ "%' order by c.MaterialCode");
			} else {
				materialMasterList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.CssdMaterialMaster c where c.MaterialName like '%"
										+ map.get("name").toString()
										+ "%' order by c.MaterialName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		paramMap.put("materialMasterList", materialMasterList);
		return paramMap;
	}

	public Map<String, Object> showAutoclaveReceiptJsp(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		List<CssdAutoclaveRequestM> cssdAutoclaveRequestMList = new ArrayList<CssdAutoclaveRequestM>();
		List<CssdAutoclaveReceiptM> cssdAutoclaveReceiptMList = new ArrayList<CssdAutoclaveReceiptM>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			masEmployeeList = hbt
					.find("from jkt.hms.masters.business.MasEmployee m where m.Status='y' and m.Department.Id = "
							+ box.getInt("deptId"));

			cssdAutoclaveRequestMList = hbt
					.find("from jkt.hms.masters.business.CssdAutoclaveRequestM m where m.Department.Id="
							+ box.getInt("deptId")
							+ " and m.Status='p' order by m.Id desc");

			cssdAutoclaveRequestMList = hbt
					.find("select distinct m.Request from jkt.hms.masters.business.CssdAutoclaveEntryT m "
							+ "where m.ReceiptStatus='o' and "
							+ "m.Request.Department.Id=" + box.getInt("deptId"));

			cssdAutoclaveReceiptMList = hbt
					.find("from jkt.hms.masters.business.CssdAutoclaveReceiptM m where m.Department.Id="
							+ box.getInt("deptId") + " order by m.Id desc");

			map.put("masEmployeeList", masEmployeeList);
			map.put("cssdAutoclaveRequestMList", cssdAutoclaveRequestMList);
			map.put("cssdAutoclaveReceiptMList", cssdAutoclaveReceiptMList);
			map.put("receiptNo", getAutoclaveReceiptNo(box.getInt("deptId")));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> addAndRefreshAutoclaveReceiptGrid(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<CssdAutoclaveRequestM> cssdAutoclaveRequestMList = new ArrayList<CssdAutoclaveRequestM>();
		List<CssdAutoclaveEntryT> cssdAutoclaveEntryTList = new ArrayList<CssdAutoclaveEntryT>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			cssdAutoclaveRequestMList = hbt
					.find("from jkt.hms.masters.business.CssdAutoclaveRequestM m where m.Department.Id="
							+ box.getInt("deptId")
							+ " and m.Id = '"
							+ box.getInt("orderNo") + "'");

			if (cssdAutoclaveRequestMList != null
					&& cssdAutoclaveRequestMList.size() > 0) {
				CssdAutoclaveReceiptM cssdAutoclaveReceiptM = new CssdAutoclaveReceiptM();
				cssdAutoclaveReceiptM.setDepartment(new MasDepartment(box
						.getInt("deptId")));
				cssdAutoclaveReceiptM.setLastChgBy(box.getString("lastChgBy"));
				cssdAutoclaveReceiptM.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("lastChgDate")));
				cssdAutoclaveReceiptM.setLastChgTime(box
						.getString("lastChgTime"));
				cssdAutoclaveReceiptM.setReceiptDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("receiptDate")));
				cssdAutoclaveReceiptM.setReceiptNo(getAutoclaveReceiptNo(box
						.getInt("deptId")));
				cssdAutoclaveReceiptM.setReceivedBy(new MasEmployee(box
						.getInt("receivedBy")));
				cssdAutoclaveReceiptM.setRequest(cssdAutoclaveRequestMList
						.get(0));
				hbt.save(cssdAutoclaveReceiptM);
				hbt.refresh(cssdAutoclaveReceiptM);
				cssdAutoclaveEntryTList = session.createCriteria(
						CssdAutoclaveEntryT.class).add(
						Restrictions.eq("Request.Id", cssdAutoclaveRequestMList
								.get(0).getId())).add(
						Restrictions.eq("ReceiptStatus", "o")).list();

				CssdAutoclaveReceiptT cssdAutoclaveReceiptT = null;
				CssdAutoclaveEntryT cssdAutoclaveEntryT = null;
				for (int i = 0; i < cssdAutoclaveEntryTList.size(); i++) {
					cssdAutoclaveReceiptT = new CssdAutoclaveReceiptT();
					cssdAutoclaveReceiptT.setEntryM(cssdAutoclaveEntryTList
							.get(i).getEntryM());
					cssdAutoclaveReceiptT.setInstrument(cssdAutoclaveEntryTList
							.get(i).getInstrument());
					cssdAutoclaveReceiptT.setIntegrator("N");
					cssdAutoclaveReceiptT.setMaterial(cssdAutoclaveEntryTList
							.get(i).getMaterial());
					cssdAutoclaveReceiptT.setQty(cssdAutoclaveEntryTList.get(i)
							.getQty());
					cssdAutoclaveReceiptT.setRecallStatus("");
					cssdAutoclaveReceiptT.setReceiptM(cssdAutoclaveReceiptM);
					cssdAutoclaveReceiptT.setResult("");
					hbt.save(cssdAutoclaveReceiptT);
					hbt.refresh(cssdAutoclaveReceiptT);
					cssdAutoclaveEntryT = cssdAutoclaveEntryTList.get(i);
					cssdAutoclaveEntryT.setReceiptStatus("p");
					hbt.update(cssdAutoclaveEntryT);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getAutoclaveReceiptStockGridData(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		List<CssdAutoclaveReceiptM> cssdAutoclaveReceiptMList = new ArrayList<CssdAutoclaveReceiptM>();
		List<CssdAutoclaveReceiptT> cssdAutoclaveReceiptTList = new ArrayList<CssdAutoclaveReceiptT>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			cssdAutoclaveReceiptMList = hbt
					.find("from jkt.hms.masters.business.CssdAutoclaveReceiptM m where"
							+ " m.Department.Id="
							+ box.getInt("deptId")
							+ " and m.ReceiptNo = '"
							+ box.getString("receiptNo") + "'");

			int pageno = 1;
			int numOfRows = 5;
			try {
				if (box.get("pageno") != null) {
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			} catch (Exception e) {
				// e.printStackTrace();
				pageno = 1;
			}

			try {
				if (box.get("numOfRows") != null && box.get("numOfRows") != "") {
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			map.put("pageno", pageno);
			map.put("numOfRows", numOfRows);

			int first = (pageno - 1) * numOfRows;
			int totalRecords = 0;
			if (cssdAutoclaveReceiptMList != null
					&& cssdAutoclaveReceiptMList.size() > 0) {
				int cssdAutoclaveReceiptMId = cssdAutoclaveReceiptMList.get(0)
						.getId();

				Criteria crit = session.createCriteria(
						CssdAutoclaveReceiptT.class)
						.add(
								Restrictions.eq("ReceiptM.Id",
										cssdAutoclaveReceiptMId));
				crit.setProjection(Projections.rowCount());

				List results = crit.list();

				try {
					totalRecords = Integer.parseInt(results.get(0).toString());
				} catch (Exception e) {
					totalRecords = 0;
				}

				map.put("totalRecords", totalRecords);

				double totalPages = 0.0;
				totalPages = (double) totalRecords / (double) numOfRows;
				Double d = new Double(Math.ceil(totalPages));
				map.put("totalPages", d.intValue());

				Criteria c = session
						.createCriteria(CssdAutoclaveReceiptT.class).add(
								Restrictions.eq("ReceiptM.Id",
										cssdAutoclaveReceiptMId));

				c.setFirstResult(first);

				if (totalRecords < numOfRows)
					c.setMaxResults(totalRecords);
				else
					c.setMaxResults(numOfRows);

				cssdAutoclaveReceiptTList = c.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (!box.contains("numOfRows"))
				box.put("numOfRows", 5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("cssdAutoclaveReceiptMList", cssdAutoclaveReceiptMList);
		map.put("cssdAutoclaveReceiptTList", cssdAutoclaveReceiptTList);
		return map;
	}

	public Map<String, Object> updateAutoclaveReceiptGridData(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<CssdAutoclaveReceiptT> cssdAutoclaveReceiptTList = new ArrayList<CssdAutoclaveReceiptT>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector receiptTId = box.getVector("receiptTId");
			Vector integrator = box.getVector("integrator");
			Vector result = box.getVector("result");
			int deptId = box.getInt("deptId");
			String receiptNo = box.getString("receiptNo");
			CssdAutoclaveReceiptT cssdAutoclaveReceiptT = null;
			for (int i = 0; i < receiptTId.size(); i++) {
				cssdAutoclaveReceiptTList = session.createCriteria(
						CssdAutoclaveReceiptT.class).createAlias("ReceiptM",
						"ReceiptMaster").add(
						Restrictions.eq("Id", Integer.parseInt(receiptTId
								.get(i).toString()))).add(
						Restrictions.eq("ReceiptMaster.ReceiptNo", receiptNo))
						.add(
								Restrictions.eq("ReceiptMaster.Department.Id",
										deptId)).list();
				cssdAutoclaveReceiptT = cssdAutoclaveReceiptTList.get(0);
				if (integrator.get(i).toString().equalsIgnoreCase("Y")) {
					cssdAutoclaveReceiptT.setIntegrator(integrator.get(i)
							.toString());
					cssdAutoclaveReceiptT.setResult(result.get(i).toString());
					if (result.get(i).toString().equalsIgnoreCase("Fail")) {
						cssdAutoclaveReceiptT.setRecallStatus("Not Received");
					}
				} else {
					cssdAutoclaveReceiptT.setIntegrator(integrator.get(i)
							.toString());
					cssdAutoclaveReceiptT.setResult("");
				}
				hbt.update(cssdAutoclaveReceiptT);

			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return map;

	}

	public Map<String, Object> getAutoclaveRecallGridData(Box box) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		List<CssdAutoclaveReceiptT> cssdAutoclaveReceiptTList = new ArrayList<CssdAutoclaveReceiptT>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			int pageno = 1;
			int numOfRows = 5;
			try {
				if (box.get("pageno") != null) {
					pageno = Integer.parseInt(box.getString("pageno"));
				}
			} catch (Exception e) {
				// e.printStackTrace();
				pageno = 1;
			}

			try {
				if (box.get("numOfRows") != null && box.get("numOfRows") != "") {
					numOfRows = Integer.parseInt(box.getString("numOfRows"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			map.put("pageno", pageno);
			map.put("numOfRows", numOfRows);

			int first = (pageno - 1) * numOfRows;
			int totalRecords = 0;

			Criteria c = session.createCriteria(CssdAutoclaveReceiptT.class)
					.add(Restrictions.eq("Result", "Fail")).add(
							Restrictions.eq("RecallStatus", "Not Received"));
			c.setProjection(Projections.rowCount());

			List results = c.list();

			try {
				totalRecords = Integer.parseInt(results.get(0).toString());
			} catch (Exception e) {
				totalRecords = 0;
			}

			map.put("totalRecords", totalRecords);

			double totalPages = 0.0;
			totalPages = (double) totalRecords / (double) numOfRows;
			Double d = new Double(Math.ceil(totalPages));
			map.put("totalPages", d.intValue());

			Criteria crit = session.createCriteria(CssdAutoclaveReceiptT.class)
					.add(Restrictions.eq("Result", "Fail")).add(
							Restrictions.eq("RecallStatus", "Not Received"));

			crit.setFirstResult(first);

			if (totalRecords < numOfRows)
				crit.setMaxResults(totalRecords);
			else
				crit.setMaxResults(numOfRows);

			cssdAutoclaveReceiptTList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (!box.contains("numOfRows"))
				box.put("numOfRows", 5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("cssdAutoclaveReceiptTList", cssdAutoclaveReceiptTList);
		return map;
	}

	public Map<String, Object> updateAutoclaveRecallGridData(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<CssdAutoclaveReceiptT> cssdAutoclaveReceiptTList = new ArrayList<CssdAutoclaveReceiptT>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector receiptTId = box.getVector("receiptTId");
			Vector receiptMId = box.getVector("receiptMId");
			Vector status = box.getVector("status");
			CssdAutoclaveReceiptT cssdAutoclaveReceiptT = null;
			for (int i = 0; i < receiptTId.size(); i++) {
				cssdAutoclaveReceiptTList = session.createCriteria(
						CssdAutoclaveReceiptT.class).add(
						Restrictions.eq("Id", Integer.parseInt(receiptTId
								.get(i).toString()))).add(
						Restrictions.eq("ReceiptM.Id", Integer
								.parseInt(receiptMId.get(i).toString())))
						.list();

				cssdAutoclaveReceiptT = cssdAutoclaveReceiptTList.get(0);
				if (status.get(i).toString().equalsIgnoreCase("Received")) {
					cssdAutoclaveReceiptT.setRecallStatus(status.get(i)
							.toString());
				}
				hbt.update(cssdAutoclaveReceiptT);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return map;

	}

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

	public Map<String, Object> showAutoclaveMaterialList(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<CssdAutoclaveEntryM> cssdAutoclaveEntryMList = new ArrayList<CssdAutoclaveEntryM>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			cssdAutoclaveEntryMList = hbt
					.find("from jkt.hms.masters.business.CssdAutoclaveEntryM m order by m.LotNo desc");
			map.put("cssdAutoclaveEntryMList", cssdAutoclaveEntryMList);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return map;

	}

	@SuppressWarnings("unchecked")
	public String generateBatchNo(String userName) {
		List<TransactionSequence> minorWorkNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String minorWorkNo = "";
		String date = "";
		date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String[] currentDate = date.split("/");
		String currentMonth = currentDate[0];
		minorWorkNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "BCN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (minorWorkNoList.size() > 0) {
			for (TransactionSequence transactionSequence : minorWorkNoList) {
				TransactionSequence obj = transactionSequence;
				int id = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				minorWorkNo = minorWorkNo.concat(String.valueOf(seqNo));
				// minorWorkNo = minorWorkNo.concat("/").concat(currentMonth);
				// minorWorkNo = minorWorkNo.concat("/").concat(currentYear);
			}
		} else if (minorWorkNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("CssdAutoclaveEntryM");
			tsObj.setTransactionPrefix("BCN");
			tsObj.setTransactionSequenceName("Batch No");
			tsObj.setMonth(Integer.parseInt(currentMonth));
			tsObj.setTransactionSequenceNumber(1);
			hbt.save(tsObj);
		}
		return minorWorkNo;
	}
}