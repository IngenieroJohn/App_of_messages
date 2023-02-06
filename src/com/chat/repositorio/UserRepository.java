package com.chat.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import com.chat.domain.*;
import com.chat.gui.WinLogin;



public class UserRepository {
	
	WinLogin winlog = new WinLogin();
	private int id;
	public static Statement stm = justconnect();

	
	
List<UsersLocal> users = new ArrayList<UsersLocal>();
//	
//	public UserRepository() {
	
//	}
	
	public  UserRepository() {
//	try {
//		
////		UsersLocal jhon = new UsersLocal(1, "jhon", "123", "file:C:\\Users\\User\\OneDrive\\Universidad\\CI 2022-2023\\PAG\\Discord\\src\\com\\chat\\image\\ft1.jpg", "Active");
////		UsersLocal william = new UsersLocal(2, "william", "456", "file:C:\\Users\\User\\OneDrive\\Universidad\\CI 2022-2023\\PAG\\Discord\\src\\com\\chat\\image\\ft2.jpg", "Active");
////		UsersLocal diego = new UsersLocal(3, "diego", "789", "file:C:\\Users\\User\\OneDrive\\Universidad\\CI 2022-2023\\PAG\\Discord\\src\\com\\chat\\image\\ft3.jpg", "Active");
////		users.add(jhon);
////		users.add(william);
////		users.add(diego);
//	
////		String query = "SELECT * FROM \"Users\"";		
////		ResultSet rs = stm.executeQuery(query);
////		System.out.println(rs.toString());
////		if (rs.next()){
////			 UsersLocal user = new UsersLocal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
////			 users.add(getByUserName(stm, user.getUsername()));
////		}
//		for (int i=1; i<=3;i++) {
//			String query = "SELECT * FROM \"Users\" where  id="+i;		
//			ResultSet rs = stm.executeQuery(query);
//			if (rs.next()){
//				 UsersLocal user = new UsersLocal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
//				 users.add(getByUserName(stm, user.getUsername()));
//			}
//			
//		}
//	}
//	catch (SQLException e) {
//		System.out.println("error connection, en el constructor de userrepository");
//		e.printStackTrace();
//	}
		
		//------------------- part 2------------------------------
users.clear();
		
		String queryselect = "select * from messages order by id_sms desc limit 1";
		
		
		
		
		try {
			ResultSet rs0 = stm.executeQuery(queryselect);
			
			while (rs0.next()) {
				int id = rs0.getInt(1);
				UsersLocal ufrom = new UsersLocal(rs0.getInt(2));
				UsersLocal uto = new UsersLocal (rs0.getInt(3));
				String content = rs0.getString(4);
				LocalDateTime date = rs0.getTimestamp(5).toLocalDateTime();
				
				
			}
			
//				String query = "SELECT * FROM \"Users\" where  id="+result.getFrom().getId();

			
			
			
//			ResultSet rs = stm.executeQuery(query);
//			if (rs.next()){
//				 UsersLocal user = new UsersLocal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
//				 users.add(getByUserName(stm, user.getUsername()));
//			}
			for (int i=1; i<=3;i++) {
//				if(i!=result.getFrom().getId()) {
				String query2 = "SELECT * FROM \"Users\" where  id="+i;		
				ResultSet rs2 = stm.executeQuery(query2);
				if (rs2.next()){
					 UsersLocal user = new UsersLocal(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getString(5));
					 
					 users.add(user);
					 
//					 users.remove(result.getFrom().getId());
				}
//				}
		}
//			users.set(0, users.get(2));
//			users.set(1, users.get(1));
//			users.add(2,users.get(3));
//	


			}
		catch (SQLException e) {
			System.out.println("algo pasa en el refresh");
			e.printStackTrace();
		}

		
	}
	
//	public void refresh(Statement stm) {
//		users.clear();
//		
//		String queryselect = "select * from messages order by id_sms desc limit 1";
//		
//		
//		
//		
//		try {
//			ResultSet rs0 = stm.executeQuery(queryselect);
//			Message result=null;
//			
//			while (rs0.next()) {
//				int id = rs0.getInt(1);
//				UsersLocal ufrom = new UsersLocal(rs0.getInt(2));
//				UsersLocal uto = new UsersLocal (rs0.getInt(3));
//				String content = rs0.getString(4);
//				LocalDateTime date = rs0.getTimestamp(5).toLocalDateTime();
//				
//				
//				 result = new Message(id, ufrom, uto, content, date);
//			}
//			
//				String query = "SELECT * FROM \"Users\" where  id="+result.getFrom().getId();
//
//			
//			
//			
//			ResultSet rs = stm.executeQuery(query);
//			if (rs.next()){
//				 UsersLocal user = new UsersLocal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
//				 users.add(getByUserName(stm, user.getUsername()));
//			}
//			for (int i=1; i<=3;i++) {
////				if(i!=result.getFrom().getId()) {
//				String query2 = "SELECT * FROM \"Users\" where  id="+i;		
//				ResultSet rs2 = stm.executeQuery(query2);
//				if (rs2.next()){
//					 UsersLocal user = new UsersLocal(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getString(5));
//					 users.add(getByUserName(stm, user.getUsername()));
//				}
////				}
//		}
//			
//			}
//		catch (SQLException e) {
//			System.out.println("algo pasa en el refresh");
//			e.printStackTrace();
//		}
//
//		
//	}



	
	public UsersLocal Getuserlocal (int id) {
		UsersLocal user = null;
		try {
						
			String query = "SELECT id, username, password, image, estado FROM \"Users\" "
					+ "where id = '" + id + "';";		
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				
				user = new UsersLocal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("conexion erronea o algo pasa en la clase userrepository metodo getuserlocal");
			e.printStackTrace();
		}
		return user;
	}

	
	
	public List<UsersLocal> getUsuarios(){
		
		return users;
	}
	
//	public UsersLocal getUsuarios2() {
//		UsersLocal user = null;
//		try {
//						
//			String query = "SELECT id, username, password, image, estado FROM \"Users\"";		
//			ResultSet rs = justconnect().executeQuery(query);
//			if (rs.next()) {
//				
//				user = new UsersLocal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
//				
//				return user;
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("conexion erronea o algo pasa en la clase userrepository metodo getuserlocal");
//			e.printStackTrace();
//		}
//		return user;
//	}
	
	

	public int getId () {
//		try {
//			String query = "Select id from \"Users\" ";
//			id =justconnect().executeUpdate(query);
//			return id;
//		}
//		catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("conexion erronea o algo pasa en la clase userrepository metodo getuserlocal");
//			e.printStackTrace();
//		}		
		return id;
	}


	
	public UsersLocal getByUserName(String username) {
		UsersLocal user = null;
		try {
			
			String query = "SELECT id, username, password, image, estado FROM \"Users\" "
					+ "where username = '" + username + "';";
						
			ResultSet rs = stm.executeQuery(query);
			
			if (rs.next()) {
				user = new UsersLocal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("conexion erronea o algo pasa en la clase userrepository metodo getbyusername");
			e.printStackTrace();
		}
		return user;
	}
	
	
	
	
	public static Statement justconnect() {
		try {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Discord", "postgres", "2113");
		Statement stm = conn.createStatement();
		return stm;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("conexion erronea o algo pasa en la clase userrepository metodo justconnect");
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	public UsersLocal login(String username, String password) {
		UsersLocal user = null;
		
		try {
			// "esto es un string \"()\""
			//
			
			String query = "SELECT id, username, password, image, estado FROM \"Users\" "
					+ "where username = '" + username + "' and password='" + password + "';";
			
			
			
			ResultSet rs = stm.executeQuery(query);
			
			if (rs.next()) {
				
				user = new UsersLocal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("conexion erronea, error de logeo -> userrepositori met: login");
			e.printStackTrace();
		}
		
		return user;
	}
	

}
