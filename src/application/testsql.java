package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testsql {
	
	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Date date = new Date();
		 Date date2 = new Date();
		 System.out.println(date2);
		 
		 System.out.println(dateFormat.format(date));
		
		try {
			//se conecta a sql
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Discord", "postgres", "2113");
			Statement stm = conn.createStatement();
			System.out.println("succesfull connection");
			//borra todos los registros
			String querydelete = "Delete FROM \"Users\"";
			String querydeletesms = "truncate table Messages";
			stm.executeUpdate(querydeletesms);
			stm.executeUpdate(querydelete);
		
			
			// se añaden los usuarios
			String queryInsert= "INSERT INTO \"Users\"(id, username, password, image, estado) VALUES (1, 'jhon', '123', 'file:C:\\Users\\User\\OneDrive\\Universidad\\CI 2022-2023\\PAG\\Discord\\src\\com\\chat\\image\\ft1.jpg', 'Active');";
			String queryInsert2= "INSERT INTO \"Users\"(id, username, password, image, estado) VALUES (2, 'william', '456', 'file:C:\\Users\\User\\OneDrive\\Universidad\\CI 2022-2023\\PAG\\Discord\\src\\com\\chat\\image\\ft2.jpg', 'Active');";
			String queryInsert3= "INSERT INTO \"Users\"(id, username, password, image, estado) VALUES (3, 'diego', '789', 'file:C:\\Users\\User\\OneDrive\\Universidad\\CI 2022-2023\\PAG\\Discord\\src\\com\\chat\\image\\ft3.jpg', 'Active');";
			
			stm.executeUpdate(queryInsert);
			stm.executeUpdate(queryInsert2);
			stm.executeUpdate(queryInsert3);
			System.out.println("succesfull insert");
			
			//se añaden los sms
//			entre jhon y will jhon 1 y will 2
			String queryInsertsms1="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (2, 1, 'Hola jhon ayudame con el deber de programacion', '2022/08/25 8:30');";
			String queryInsertsms2="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (1, 2, 'Como estas diego, claro ya te ayudo con eso dame unos segundos xd', '2022/08/25 8:30');";
			String queryInsertsms3="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (2, 1, 'Dale aqui te espero, no te vayas a olvidar','2022/08/25 8:30');";
			String queryInsertsms4="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (2, 1, 'Por cierto que otros deberes mandaron', '2022/08/25 8:30');";
			String queryInsertsms5="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (1, 2, 'Estadistica creo y el proyecto de programa :v',  '2022/08/25 8:30');";
			String queryInsertsms6="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (2, 1, 'Ya con programa es como tener 10 deberes xd', '2022/08/25 8:30');";
			String queryInsertsms7="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (2, 1, 'Ojala me lleve el diablo jaja', '2022/08/25 8:30');";
			String queryInsertsms8="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (1, 2, 'jajaja oye tu si que eres dramatica ya le pusiste 10 deberes :v', '2022/08/25 8:30');";
			
			// entre jhon y diego
			String queryInsertsms9="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 1, 'hola crack', '2022/08/25 8:30');";
			String queryInsertsms10="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (1, 3, 'Hola diego', '2022/08/25 8:30');";
			String queryInsertsms11="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 1, 'Hola jhon ayudame con el deber de programacion', '2022/08/25 8:30');";
			String queryInsertsms12="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 1, 'está complicado', '2022/08/25 8:30');";
			String queryInsertsms13="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (1, 3, 'con gusto', '2022/08/25 8:30');";
			String queryInsertsms14="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (1, 3, 'estamos en el mismo team', '2022/08/25 8:30');";
			String queryInsertsms15="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 1, 'aprecio tu ayuda', '2022/08/25 8:30');";
			String queryInsertsms16="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 1, 'Hablamos', '2022/08/25 8:30');";
			
			// entre diego y will
			String queryInsertsms17="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 2, 'Hola', '2022/08/25 8:30');";
			String queryInsertsms18="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (2, 3, 'Hola men', '2022/08/25 8:30');";
			String queryInsertsms19="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 2, 'todo bien?', '2022/08/25 8:30');";
			String queryInsertsms20="INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 2, 'pa jugar xd', '2022/08/25 8:30');";

			
//			for(int i=1; i<=20; i++) {
//				String stringdinamico= "queryInsertsms"+ i;
//				System.out.println("si funciona xd "+stringdinamico);
//				stm.executeUpdate(stringdinamico);
//				System.out.println("si funciona xd "+stringdinamico);
//				i++;
//			}
			stm.executeUpdate(queryInsertsms1);
			stm.executeUpdate(queryInsertsms2);
			stm.executeUpdate(queryInsertsms3);
			stm.executeUpdate(queryInsertsms4);
			stm.executeUpdate(queryInsertsms5);
			stm.executeUpdate(queryInsertsms6);
			stm.executeUpdate(queryInsertsms7);
			stm.executeUpdate(queryInsertsms8);
			stm.executeUpdate(queryInsertsms9);
			stm.executeUpdate(queryInsertsms10);
			stm.executeUpdate(queryInsertsms11);
			stm.executeUpdate(queryInsertsms12);
			stm.executeUpdate(queryInsertsms13);
			stm.executeUpdate(queryInsertsms14);
			stm.executeUpdate(queryInsertsms15);
			stm.executeUpdate(queryInsertsms16);
			stm.executeUpdate(queryInsertsms17);
			stm.executeUpdate(queryInsertsms18);
			stm.executeUpdate(queryInsertsms19);
			stm.executeUpdate(queryInsertsms20);
			
			
			
		}
		catch (SQLException e) {
			System.out.println("error connection");
			e.printStackTrace();
		}

	}

}
