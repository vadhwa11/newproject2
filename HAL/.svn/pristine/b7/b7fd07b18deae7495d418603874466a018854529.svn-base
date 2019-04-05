package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the cssd_material_stock_t
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="cssd_material_stock_t"
 */

public abstract class BaseCssdMaterialStockT implements Serializable {

	public static String REF = "CssdMaterialStockT";
	public static String PROP_QTY = "Qty";
	public static String PROP_STOCK_M = "StockM";
	public static String PROP_MATERIAL = "Material";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";

	// constructors
	public BaseCssdMaterialStockT() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCssdMaterialStockT(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCssdMaterialStockT(java.lang.Integer id,
			jkt.hms.masters.business.CssdMaterialMaster material,
			jkt.hms.masters.business.CssdMaterialStockM stockM,
			java.lang.Integer qty) {

		this.setId(id);
		this.setMaterial(material);
		this.setStockM(stockM);
		this.setQty(qty);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer qty;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.CssdMaterialMaster material;
	private jkt.hms.masters.business.CssdMaterialStockM stockM;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: qty
	 */
	public java.lang.Integer getQty() {
		return qty;
	}

	/**
	 * Set the value related to the column: qty
	 * 
	 * @param qty
	 *            the qty value
	 */
	public void setQty(java.lang.Integer qty) {
		this.qty = qty;
	}

	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Return the value associated with the column: material_id
	 */
	public jkt.hms.masters.business.CssdMaterialMaster getMaterial() {
		return material;
	}

	/**
	 * Set the value related to the column: material_id
	 * 
	 * @param material
	 *            the material_id value
	 */
	public void setMaterial(jkt.hms.masters.business.CssdMaterialMaster material) {
		this.material = material;
	}

	/**
	 * Return the value associated with the column: stock_m_id
	 */
	public jkt.hms.masters.business.CssdMaterialStockM getStockM() {
		return stockM;
	}

	/**
	 * Set the value related to the column: stock_m_id
	 * 
	 * @param stockM
	 *            the stock_m_id value
	 */
	public void setStockM(jkt.hms.masters.business.CssdMaterialStockM stockM) {
		this.stockM = stockM;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.CssdMaterialStockT))
			return false;
		else {
			jkt.hms.masters.business.CssdMaterialStockT cssdMaterialStockT = (jkt.hms.masters.business.CssdMaterialStockT) obj;
			if (null == this.getId() || null == cssdMaterialStockT.getId())
				return false;
			else
				return (this.getId().equals(cssdMaterialStockT.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}