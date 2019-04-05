package jkt.hms.util;

import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeSet;

import jkt.hms.masters.business.DgResultEntryDetailSen;

public class OrganismGroupComparator implements Serializable,
		Comparator<DgResultEntryDetailSen> {

	public int compare(DgResultEntryDetailSen m1, DgResultEntryDetailSen m2) {
		Integer organismGroup1 = m1.getOrganismGroup().getId();
		Integer organismGroup2 = m2.getOrganismGroup().getId();
		/*
		 * if(organismGroup1 == organismGroup2){ Integer organism1 =
		 * m1.getOrganism().getId(); Integer organism2 =
		 * m2.getOrganism().getId(); if(organism1 == organism2){ Integer
		 * sensitivity1 = m1.getSensitivity().getId(); Integer sensitivity2 =
		 * m2.getSensitivity().getId(); return
		 * sensitivity1.compareTo(sensitivity2); }else{ return
		 * organism2.compareTo(organism2); } }else{
		 */
		return organismGroup1.compareTo(organismGroup2);
		// }
	}

	public static TreeSet<DgResultEntryDetailSen> getApplicationTreeSet() {
		return new TreeSet<DgResultEntryDetailSen>(
				new OrganismGroupComparator());
	}
}