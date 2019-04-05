package jkt.hms.util;

import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeSet;

import jkt.hms.masters.business.DgSampleCollectionDetails;

public class ComparatorForTwoFields implements Serializable,
		Comparator<DgSampleCollectionDetails> {

	public int compare(DgSampleCollectionDetails m1,
			DgSampleCollectionDetails m2) {
		Integer int1 = m1.getInvestigation().getSubChargecode().getId();
		Integer int2 = m2.getInvestigation().getSubChargecode().getId();

		Integer sampleHeaderId1 = m1.getSampleCollectionHeader().getId();
		Integer sampleHeaderId2 = m1.getSampleCollectionHeader().getId();
		if (sampleHeaderId1 == sampleHeaderId2) {
			return int1.compareTo(int2);
		} else {
			return sampleHeaderId1.compareTo(sampleHeaderId2);
		}

	}

	public static TreeSet<DgSampleCollectionDetails> getApplicationTreeSet() {
		return new TreeSet<DgSampleCollectionDetails>(
				new ComparatorForTwoFields());
	}
}