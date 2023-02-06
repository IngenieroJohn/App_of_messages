package com.chat.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;


import com.chat.domain.Message;
import com.chat.domain.UsersLocal;



public class RepositoryMessages {
	
//	List<Message> listaMensajes = new ArrayList<Message>();
//	
	UserRepository usuarios = new UserRepository();
	public Statement stm = usuarios.justconnect();

	
	public RepositoryMessages() {
		
		
//		Statement stm = usuarios.justconnect();
//		String querydeletesms = "truncate table Messages";
//		try {
//		stm.executeUpdate(querydeletesms);
//		System.out.println("se ejecuta el reposimessages constructor");
//		
//
////		
//		//se añaden los sms
////		entre jhon y will jhon 1 y will 2
//		String queryInsertsms1="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (2, 1, 'Hola jhon ayudame con el deber de programacion', '2022/08/25 8:30');";
//		String queryInsertsms2="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (1, 2, 'Como estas diego, claro ya te ayudo con eso dame unos segundos xd', '2022/08/25 8:30');";
//		String queryInsertsms3="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (2, 1, 'Dale aqui te espero, no te vayas a olvidar','2022/08/25 8:30');";
//		String queryInsertsms4="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (2, 1, 'Por cierto que otros deberes mandaron', '2022/08/25 8:30');";
//		String queryInsertsms5="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (1, 2, 'Estadistica creo y el proyecto de programa :v',  '2022/08/25 8:30');";
//		String queryInsertsms6="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (2, 1, 'Ya con programa es como tener 10 deberes xd', '2022/08/25 8:30');";
//		String queryInsertsms7="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (2, 1, 'Ojala me lleve el diablo jaja', '2022/08/25 8:30');";
//		String queryInsertsms8="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (1, 2, 'jajaja oye tu si que eres dramatica ya le pusiste 10 deberes :v', '2022/08/25 8:30');";
//		
//		// entre jhon y diego
//		String queryInsertsms9="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 1, 'hola crack', '2022/08/25 8:30');";
//		String queryInsertsms10="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (1, 3, 'Hola diego', '2022/08/25 8:30');";
//		String queryInsertsms11="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 1, 'Hola jhon ayudame con el deber de programacion', '2022/08/25 8:30');";
//		String queryInsertsms12="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 1, 'está complicado', '2022/08/25 8:30');";
//		String queryInsertsms13="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (1, 3, 'con gusto', '2022/08/25 8:30');";
//		String queryInsertsms14="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (1, 3, 'estamos en el mismo team', '2022/08/25 8:30');";
//		String queryInsertsms15="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 1, 'aprecio tu ayuda', '2022/08/25 8:30');";
//		String queryInsertsms16="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 1, 'Hablamos', '2022/08/25 8:30');";
//		
//		// entre diego y will
//		String queryInsertsms17="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 2, 'Hola', '2022/08/25 8:30');";
//		String queryInsertsms18="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (2, 3, 'Hola men', '2022/08/25 8:30');";
//		String queryInsertsms19="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 2, 'todo bien?', '2022/08/25 8:30');";
//		String queryInsertsms20="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 2, 'pa jugar xd', '2022/08/25 8:30');";
//		
//		stm.executeUpdate(queryInsertsms1);
//		stm.executeUpdate(queryInsertsms2);
//		stm.executeUpdate(queryInsertsms3);
//		stm.executeUpdate(queryInsertsms4);
//		stm.executeUpdate(queryInsertsms5);
//		stm.executeUpdate(queryInsertsms6);
//		stm.executeUpdate(queryInsertsms7);
//		stm.executeUpdate(queryInsertsms8);
//		stm.executeUpdate(queryInsertsms9);
//		stm.executeUpdate(queryInsertsms10);
//		stm.executeUpdate(queryInsertsms11);
//		stm.executeUpdate(queryInsertsms12);
//		stm.executeUpdate(queryInsertsms13);
//		stm.executeUpdate(queryInsertsms14);
//		stm.executeUpdate(queryInsertsms15);
//		stm.executeUpdate(queryInsertsms16);
//		stm.executeUpdate(queryInsertsms17);
//		stm.executeUpdate(queryInsertsms18);
//		stm.executeUpdate(queryInsertsms19);
//		stm.executeUpdate(queryInsertsms20);
//		
//		}
//		catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("conexion erronea o algo pasa en la clase smsrepository");
//			e.printStackTrace();
//		}
	

		
	}
	

public List<Message> getMensajes(int from, int to){
	List<Message> result = new ArrayList<>();
	
	try {
		
		String query = "select * from messages "
				+ "where idfrom = " + from + " and idto = " + to + " or idfrom = " + to + " and idto = " + from;
		
		
		ResultSet rs = stm.executeQuery(query);
		
		while (rs.next()) {
			int id = rs.getInt(1);
			UsersLocal ufrom = new UsersLocal(rs.getInt(2));
			UsersLocal uto = new UsersLocal (rs.getInt(3));
			String content = rs.getString(4);
			LocalDateTime date = rs.getTimestamp(5).toLocalDateTime();
			
			Message msg = new Message(id, ufrom, uto, content, date);
			result.add(msg);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("conexion erronea en reposi messages getmessage");
		e.printStackTrace();
	}
	

	return result;
}







public Message getlastsms(int usuario, int contacto) {
try {
		
		String queryselect = "select * from messages "
				+ "where idfrom = " + usuario + " and idto = " + contacto + " or idfrom = " + contacto + " and idto = " + usuario+ "order by id_sms desc limit 1";
		
		
		ResultSet rs = stm.executeQuery(queryselect);
		
		while (rs.next()) {
			int id = rs.getInt(1);
			UsersLocal ufrom = new UsersLocal(rs.getInt(2));
			UsersLocal uto = new UsersLocal (rs.getInt(3));
			String content = rs.getString(4);
			LocalDateTime date = rs.getTimestamp(5).toLocalDateTime();
			
			
			Message result = new Message(id, ufrom, uto, content, date);
			return result;
			
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("conexion erronea en reposi messages getmessage");
		e.printStackTrace();
	}
	
	return null;
	
}



public void addsms (Message mensajes) {
	
	UsersLocal from = mensajes.getFrom();
	UsersLocal to = mensajes.getTo();
	String content = mensajes.getContent();
	LocalDateTime date = mensajes.getDate();
	try {
	String queryInsertsms="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES("+from.getId() +','+ to.getId()+",'"+ content+"' , '"+ date+"')";
	stm.executeUpdate(queryInsertsms);
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("conexion erronea o algo pasa en la clase smsrepository metodo addsms");
		e.printStackTrace();
	}
	
}
	


public void addsms2(UsersLocal envia, UsersLocal recibe, String mensajes, LocalDateTime hours) {
//	String h2= hours+"";
	String queryInsertsms="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES("+envia.getId() +","+ recibe.getId()+","+ "'"+mensajes+"'"+", '"+ hours+"')";
	System.out.println(queryInsertsms + "syso del addms2");
	try {
		stm.executeUpdate(queryInsertsms);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("conexion erronea o algo pasa en la clase smsrepository metodo addsms");
			e.printStackTrace();
		}
}
	


}
