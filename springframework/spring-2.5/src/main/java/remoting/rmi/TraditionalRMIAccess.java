package remoting.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class TraditionalRMIAccess {

	
	public static void main(String[] args) throws Exception {
		
		CitationService cs = new TraditionalRMIAccess().lookupCitationService();
		
	}
	
	private String citationUrl = "rmi:/citation/CitationService";
	
	public CitationService lookupCitationService()	throws RemoteException, NotBoundException,	MalformedURLException {
		CitationService citationService = (CitationService)
		Naming.lookup(citationUrl);
		return citationService;
	}
	
}
