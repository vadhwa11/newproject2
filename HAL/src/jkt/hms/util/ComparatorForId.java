package jkt.hms.util;

import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeSet;

import jkt.hms.masters.business.DgSampleCollectionDetails;

public class ComparatorForId implements Serializable,
		Comparator<DgSampleCollectionDetails> {

	public int compare(DgSampleCollectionDetails m1,
			DgSampleCollectionDetails m2) {
		Integer int1 = m1.getId();
		Integer int2 = m2.getId();

		return int1.compareTo(int2);
	}

	public static TreeSet<DgSampleCollectionDetails> getApplicationTreeSet() {
		return new TreeSet<DgSampleCollectionDetails>(new ComparatorForId());
	}
}