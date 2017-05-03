package design.patterns.web.dao;

import java.sql.Connection;
import java.util.List;

import design.patterns.web.model.Vehicle;

public class VehicleDAO {

	private Connection connection;

	private VehicleDAO(){
		
	}
	
	static class VehicleDAOHolder{
		static VehicleDAO vehicleDAO = new VehicleDAO();
	}
	
	public static VehicleDAO getInstance(){
		return VehicleDAOHolder.vehicleDAO;
	}
	
	
	public void save(Vehicle vehicle){
		if (vehicle == null){
			throw new RuntimeException();
		}
	}
	
	public List<Vehicle> findAll(){
		return null; 
	}
	
	public void remove(Vehicle vehicle){}
	
}
