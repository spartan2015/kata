package design.patterns.web.services;

import design.patterns.web.dao.VehicleDAO;
import design.patterns.web.model.Vehicle;

public class VehicleService {	
	/**
	 * Singleton
	 */
	private VehicleService() {
	}

	static class VehicleServiceHolder {
		static VehicleService service = new VehicleService();
	}

	public static VehicleService getInstance() {
		return VehicleServiceHolder.service;
	}

	private VehicleDAO dao = VehicleDAO.getInstance();

	void save(Vehicle vehicle) {
		// securitate
		dao.save(vehicle);
	}

	public Object findAll() {
		return dao.findAll();
	}
}
