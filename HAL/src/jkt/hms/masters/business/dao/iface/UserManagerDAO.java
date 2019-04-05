package jkt.hms.masters.business.dao.iface;

import java.io.Serializable;

public interface UserManagerDAO {
	public jkt.hms.masters.business.UserManager get(java.lang.Integer key);

	public jkt.hms.masters.business.UserManager load(java.lang.Integer key);

	public java.util.List<jkt.hms.masters.business.UserManager> findAll ();


	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param userManager a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(jkt.hms.masters.business.UserManager userManager);

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param userManager a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(jkt.hms.masters.business.UserManager userManager);

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param userManager a transient instance containing updated state
	 */
	public void update(jkt.hms.masters.business.UserManager userManager);

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(java.lang.Integer id);

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param userManager the instance to be removed
	 */
	public void delete(jkt.hms.masters.business.UserManager userManager);


}