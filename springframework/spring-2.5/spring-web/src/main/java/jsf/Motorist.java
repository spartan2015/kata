package jsf;

public class Motorist {
	public String register() {
		try {
			System.out.println("registration here ");
		} catch (Exception e) {
			return "error";
		}
		return "success";
	}

}
