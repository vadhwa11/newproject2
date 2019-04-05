package jkt.hms.masters.business.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import jkt.hms.masters.business.dao.iface.UserManagerDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseUserManagerDAO extends jkt.hms.masters.business.dao._RootDAO {

	public BaseUserManagerDAO () {}
	
	public BaseUserManagerDAO (Session session) {
		super(session);
	}

	// query name references


	public static UserManagerDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static UserManagerDAO getInstance () {
		if (null == instance) instance = new jkt.hms.masters.business.dao.UserManagerDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return jkt.hms.masters.business.UserManager.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a jkt.hms.masters.business.UserManager
	 */
	public jkt.hms.masters.business.UserManager cast (Object object) {
		return (jkt.hms.masters.business.UserManager) object;
	}

	public jkt.hms.masters.business.UserManager get(java.lang.Integer key)
	{
		return (jkt.hms.masters.business.UserManager) get(getReferenceClass(), key);
	}

	public jkt.hms.masters.business.UserManager get(java.lang.Integer key, Session s)
	{
		return (jkt.hms.masters.business.UserManager) get(getReferenceClass(), key, s);
	}

	public jkt.hms.masters.business.UserManager load(java.lang.Integer key)
	{
		return (jkt.hms.masters.business.UserManager) load(getReferenceClass(), key);
	}

	public jkt.hms.masters.business.UserManager load(java.lang.Integer key, Session s)
	{
		return (jkt.hms.masters.business.UserManager) load(getReferenceClass(), key, s);
	}

	public jkt.hms.masters.business.UserManager loadInitialize(java.lang.Integer key, Session s) 
	{ 
		jkt.hms.masters.business.UserManager obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<jkt.hms.masters.business.UserManager> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<jkt.hms.masters.business.UserManager> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<jkt.hms.masters.business.UserManager> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param userManager a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(jkt.hms.masters.business.UserManager userManager)
	{
		return (java.lang.Integer) super.save(userManager);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param userManager a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(jkt.hms.masters.business.UserManager userManager, Session s)
	{
		return (java.lang.Integer) save((Object) userManager, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param userManager a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(jkt.hms.masters.business.UserManager userManager)
	{
		saveOrUpdate((Object) userManager);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param userManager a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(jkt.hms.masters.business.UserManager userManager, Session s)
	{
		saveOrUpdate((Object) userManager, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param userManager a transient instance containing updated state
	 */
	public void update(jkt.hms.masters.business.UserManager userManager) 
	{
		update((Object) userManager);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param userManager a transient instance containing updated state
	 * @param the Session
	 */
	public void update(jkt.hms.masters.business.UserManager userManager, Session s)
	{
		update((Object) userManager, s);
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
	 * @param userManager the instance to be removed
	 */
	public void delete(jkt.hms.masters.business.UserManager userManager)
	{
		delete((Object) userManager);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param userManager the instance to be removed
	 * @param s the Session
	 */
	public void delete(jkt.hms.masters.business.UserManager userManager, Session s)
	{
		delete((Object) userManager, s);
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
	public void refresh (jkt.hms.masters.business.UserManager userManager, Session s)
	{
		refresh((Object) userManager, s);
	}


}