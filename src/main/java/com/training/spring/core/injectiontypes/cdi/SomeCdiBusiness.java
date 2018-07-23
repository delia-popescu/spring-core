package com.training.spring.core.injectiontypes.cdi;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SomeCdiBusiness {

	@Inject
    SomeCdiDao someCdiDao;

	@Inject
	@Named("someCdiDao2")
//	@Qualifier("someCdiDao2")
            SomeCdiDao2 cdiDao;

	public SomeCdiDao getSomeCdiDao() {
		return someCdiDao;
	}

	public SomeCdiDao2 getCdiDao() {
		return cdiDao;
	}

	public int findGreatest() {
		int greatest = Integer.MIN_VALUE;
		int[] data = someCdiDao.getData();
		for (int value : data) {
			if (value > greatest) {
				greatest = value;
			}
		}
		return greatest;
	}

}
