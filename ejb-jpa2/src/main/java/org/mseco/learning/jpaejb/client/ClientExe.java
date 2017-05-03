package org.mseco.learning.jpaejb.client;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.mseco.learning.jpaejb.StatelessBean;

public class ClientExe {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {
		InitialContext ctx = new InitialContext();
		StatelessBean sb = (StatelessBean)ctx.lookup("StatelessBeanImpl/remote");
		
		sb.doATransaction();
		

	}

}
