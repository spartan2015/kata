package org.mseco.learning.jpaejb;

import javax.ejb.Remote;

@Remote
public interface StatelessBean {
	public void doATransaction();
}
