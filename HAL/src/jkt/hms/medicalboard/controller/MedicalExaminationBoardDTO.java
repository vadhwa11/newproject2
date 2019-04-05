package jkt.hms.medicalboard.controller;

public class MedicalExaminationBoardDTO {
	private String srNo;
	private String relation;
	private String age;
	private String health;
	private String couseOfDeath;
	private String died;

	private String id;

	public String getSrNo() {
		return srNo;
	}

	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public String getCouseOfDeath() {
		return couseOfDeath;
	}

	public void setCouseOfDeath(String couseOfDeath) {
		this.couseOfDeath = couseOfDeath;
	}

	public String getDied() {
		return died;
	}

	public void setDied(String died) {
		this.died = died;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
}
