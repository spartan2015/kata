package dwr;

public class TrafficInfoServiceImpl implements TrafficInfoService{

	public TrafficInfo[] getTrafficInfo(String zipCode) {
		TrafficInfo[] ti = new TrafficInfo[2];
		for(int i =0; i<2; i++){
			ti[i] = new TrafficInfo();
			ti[i].setName("name " + 1);
			ti[i].setLocation("location " + zipCode + " " + 1);
		}
		return ti;
	}

}
