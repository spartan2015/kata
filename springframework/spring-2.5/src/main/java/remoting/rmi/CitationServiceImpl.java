package remoting.rmi;

public class CitationServiceImpl implements CitationService{

	public String hello(String name) {		
		return "Hello " + name + "!";
	}

}
