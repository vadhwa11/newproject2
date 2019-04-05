package jkt.hms.masters.business.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import jkt.hms.masters.business.dao.iface.StoreIssueMDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseStoreIssueMDAO extends jkt.hms.masters.business.dao._RootDAO {

	public BaseStoreIssueMDAO () {}
	
	public BaseStoreIssueMDAO (Session session) {
		super(session);
	}

	// query name references


	public static StoreIssueMDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static StoreIssueMDAO getInstance () {
		if (null == instance) instance = new jkt.hms.masters.business.dao.StoreIssueMDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return jkt.hms.masters.business.StoreIssueM.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a jkt.hms.masters.business.StoreIssueM
	 */
	public jkt.hms.masters.business.StoreIssueM cast (Object object) {
		return (jkt.hms.masters.business.StoreIssueM) object;
	}

	public jkt.hms.masters.business.StoreIssueM get(java.lang.Integer key)
	{
		return (jkt.hms.masters.business.StoreIssueM) get(getReferenceClass(), key);
	}

	public jkt.hms.masters.business.StoreIssueM get(java.lang.Integer key, Session s)
	{
		return (jkt.hms.masters.business.StoreIssueM) get(getReferenceClass(), key, s);
	}

	public jkt.hms.masters.business.StoreIssueM load(java.lang.Integer key)
	{
		return (jkt.hms.masters.business.StoreIssueM) load(getReferenceClass(), key);
	}

	public jkt.hms.masters.business.StoreIssueM load(java.lang.Integer key, Session s)
	{
		return (jkt.hms.masters.business.StoreIssueM) load(getReferenceClass(), key, s);
	}

	public jkt.hms.masters.business.StoreIssueM loadInitialize(java.lang.Integer key, Session s) 
	{ 
		jkt.hms.masters.business.StoreIssueM obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<jkt.hms.masters.business.StoreIssueM> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<jkt.hms.masters.business.StoreIssueM> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<jkt.hms.masters.business.StoreIssueM> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param storeIssueM a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(jkt.hms.masters.business.StoreIssueM storeIssueM)
	{
		return (java.lang.Integer) super.save(storeIssueM);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param storeIssueM a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(jkt.hms.masters.business.StoreIssueM storeIssueM, Session s)
	{
		return (java.lang.Integer) save((Object) storeIssueM, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param storeIssueM a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(jkt.hms.masters.business.StoreIssueM storeIssueM)
	{
		saveOrUpdate((Object) storeIssueM);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param storeIssueM a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(jkt.hms.masters.business.StoreIssueM storeIssueM, Session s)
	{
		saveOrUpdate((Object) storeIssueM, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param storeIssueM a transient instance containing updated state
	 */
	public void update(jkt.hms.masters.business.StoreIssueM storeIssueM) 
	{
		update((Object) storeIssueM);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param storeIssueM a transient instance containing updated state
	 * @param the Session
	 */
	public void update(jkt.hms.masters.business.StoreIssueM storeIssueM, Session s)
	{
		update((Object) storeIssueM, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(java.lang.Integer id)
	{
		delete((Object) load(id));
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param id the instance ID to be removed
	 * @param s the Session
	 */
	public void delete(java.lang.Integer id, Session s)
	{
		delete((Object) load(id, s), s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param storeIssueM the instance to be removed
	 */
	public void delete(jkt.hms.masters.business.StoreIssueM storeIssueM)
	{
		delete((Object) storeIssueM);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param storeIssueM the instance to be removed
	 * @param s the Session
	 */
	public void delete(jkt.hms.masters.business.StoreIssueM storeIssueM, Session s)
	{
		delete((Object) storeIssueM, s);
	}
	
	/**
	 * Re-read the state of the given instance from the underlying database. It is inadvisable to use this to implement
	 * long-running sessions that span many business tasks. This method is, however, useful in certain special circumstances.
	 * For example 
	 * <ul> 
	 * <li>where a database trigger alters the object state upon insert or update</li>
	 * <li>after executing direct SQL (eg. a mass update) in the same session</li>
	 * <li>after inserting a Blob or Clob</li>
	 * </ul>
	 */
	public void refresh (jkt.hms.masters.business.StoreIssueM storeIssueM, Session s)
	{
		refresh((Object) storeIssueM, s);
	}


}