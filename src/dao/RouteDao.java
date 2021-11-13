package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Route;

public class RouteDao {
	
	public static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	public static final String SELECT_ALL = "select * from route";
	public static final String SELECT_ROUTE_BY_ID = "select * from route where id = ?";
	
	
	public static List<Route> selectAllRoutes(){
		List<Route> routes = new ArrayList<>();
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = connectionPool.checkOut();
			PreparedStatement prepare = DAOUtil.prepareStatement(connection, SELECT_ALL, false);
			rs = prepare.executeQuery();
			
			while(rs.next()) {
				Route route = new Route(rs.getInt("id"), rs.getString("origin_country"),rs.getString("origin_town"),rs.getString("destination_country"),rs.getString("destination_town"));
				routes.add(route);
			}
			prepare.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return routes;
	}
	
	
	public static Route selectRoute(int route_id) {
		Connection conn = null;
		ResultSet rs = null;
		Route route = null;
		
		try {
			conn = connectionPool.checkOut();
			PreparedStatement prepare = DAOUtil.prepareStatement(conn, SELECT_ROUTE_BY_ID, false, route_id);
			rs = prepare.executeQuery();
			
			while(rs.next()) {
				route = new Route(rs.getInt("id"), rs.getString("origin_country"),rs.getString("origin_town"),rs.getString("destination_country"),rs.getString("destination_town"));
			}
			prepare.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return route;
	}
	
	
}
