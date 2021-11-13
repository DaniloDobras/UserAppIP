package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import dto.Flight;
import dto.Route;

public class FlightDao {
	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	private static final String SELECT_ALL = "select * from flight";
	
	public static ArrayList<Flight> getAllFlights(){
		ArrayList<Flight> flights = new ArrayList<>();
		Connection connection = null;
		ResultSet rs = null;
		Route route = null;
		try {
			connection = connectionPool.checkOut();
			PreparedStatement prepare = DAOUtil.prepareStatement(connection, SELECT_ALL, false);
			rs = prepare.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				int route_id = rs.getInt("route_id");
				Timestamp departure = rs.getTimestamp("departure");
				Timestamp return_ = rs.getTimestamp("return");
				int passengers = rs.getInt("passengers");
				String cargo = rs.getString("cargo");
				String file = rs.getString("file");
				route = RouteDao.selectRoute(route_id);
				flights.add(new Flight(id, route, departure, return_, passengers, cargo, file));
			}
			prepare.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flights;
	}
	
	public static void main(String args[]) {
		ArrayList<Flight> flights = getAllFlights();
		
		System.out.print(flights);
	}
	
}
