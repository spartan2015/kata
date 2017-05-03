package design.patterns.web.model;

public class Vehicle {

	private String licenseNo;
	private String engine;
	private Integer wheels;

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public Integer getWheels() {
		return wheels;
	}

	public void setWheels(Integer wheels) {
		this.wheels = wheels;
	}
}
