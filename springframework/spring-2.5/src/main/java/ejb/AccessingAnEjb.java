package ejb;

import remoting.rmi.CitationService;

public class AccessingAnEjb {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// EJB 2.1

		CitationService home = getCitationService();
		// CitationService trafficService = home.create(); // 2.1 style - weird
		/*
	    EJB 3 makes things a little bit easier. Instead of looking up the EJB’s home
	    interface from JNDI, you look up EJB 3 session beans directly from JNDI. 
		 */

	}

	private static CitationService citationService;

	private static CitationService getCitationService()
			throws javax.naming.NamingException {
		if (citationService != null)
			return citationService;
		javax.naming.InitialContext ctx = new javax.naming.InitialContext();
		try {
			Object objHome = ctx.lookup("citationService");
			CitationService home = (CitationService) javax.rmi.PortableRemoteObject
					.narrow(objHome, CitationService.class);
			citationService = home;
			return home;
		} finally {
			ctx.close();
		}
	}

}
