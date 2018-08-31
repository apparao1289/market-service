package com.test.vegetable.enums;

/**
 * Enum for supplier names.
 * 
 * @author apparao
 *
 */
public enum SupplierEnum {

	DE_COSTA("De Costa"), DIRK("Dirk"), ALBERT_HEIGN("Albert Heign"), ALDI("Aldi");

	private String suppilerName;

	SupplierEnum(String suppilerName) {
		this.suppilerName = suppilerName;
	}

	public static Boolean getSupplierName(String suppilerName) {
		for (SupplierEnum supplierEnum : SupplierEnum.values()) {
			if (null != suppilerName && suppilerName.equalsIgnoreCase(supplierEnum.suppilerName)) {
				return true;
			}
		}
		return false;
	}
}
