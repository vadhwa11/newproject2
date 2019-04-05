package jkt.hms.masters.dataservice;

import jkt.hms.masters.business.MasReference;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class RegistrationMasterDataServiceImpl extends HibernateDaoSupport
		implements RegistrationMasterDataService {

	// ------------------------------------------------- Reference by Mansi
	// ---------------------------------------

	public boolean addReference(MasReference masReference) {
		boolean dataSaved = false;
		getHibernateTemplate().save(masReference);
		return dataSaved;
	}

	public boolean updateReference(MasReference masReference) {
		Boolean dataSaved = false;
		getHibernateTemplate().update(masReference);
		dataSaved = true;
		return dataSaved;
	}

	public boolean deleteReference(int referenceId) {
		boolean dataDeleted = false;
		MasReference masReference = new MasReference();
		masReference = (MasReference) getHibernateTemplate().get(
				MasReference.class, referenceId);
		masReference.setStatus("n");
		getHibernateTemplate().update(masReference);
		dataDeleted = true;
		return dataDeleted;

	}
}
