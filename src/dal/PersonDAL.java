package dal;

import java.nio.file.attribute.AclEntry;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import contrac.Person;
import core.CoreHelper;
import interfaces.DALInterfaces;

public class PersonDAL extends CoreHelper implements DALInterfaces<Person> {

	Statement statement = null;
	Connection connection = null;
	ResultSet rs = null;

	@Override
	public boolean insert(Person entity) throws SQLException {
		// TODO Auto-generated method stub
		connection = getConnection();
		statement = connection.createStatement();
		boolean control = false;
		String query = "insert into iletisim(ad,soyad, tel, email, adres) values('" + entity.getAd() + "', '"
				+ entity.getSoyad() + "', '" + entity.getTel() + "','" + entity.getEmail() + "', '" + entity.getAdres()
				+ "')";

		try {
			statement.execute(query);
			control = true;
		} catch (Exception e) {
			control = false;
			// TODO: handle exception
		} finally {
			connection.close();
			statement.close();
		}
		return control;
	}

	@Override
	public List<Person> getAll() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Person> list = new ArrayList<>();

		connection = getConnection();
		statement = connection.createStatement();

		String query = "SELECT * FROM iletisim";
		Person person;
		try {

			rs = statement.executeQuery(query);
			while (rs.next()) {
				person = new Person(rs.getInt("id"), rs.getString("ad"), rs.getString("soyad"), rs.getString("tel"),
						rs.getString("email"), rs.getString("adres"));
				list.add(person);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			statement.close();
			rs.close();
		}
		return list;
	}

	@Override
	public boolean delete(int id) throws SQLException {

		connection = getConnection();
		statement = connection.createStatement();
		String query = "DELETE FROM iletisim 	WHERE id=" + id;
		try {
			statement.executeUpdate(query);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

			connection.close();
			statement.close();
		}

	}

	@Override
	public boolean update(Person entity) throws SQLException {
		// TODO Auto-generated method stub

		connection = getConnection();
		statement = connection.createStatement();

		String query = "UPDATE iletisim SET ad='" + entity.getAd() + "', soyad='" + 
		entity.getSoyad() +
				"', tel='"
				+ entity.getTel() + "', email='" + entity.getEmail() + "', adres='" + 
				entity.getAdres() +
				"' WHERE id="
				+ entity.getId();
		try {
			statement.executeUpdate(query);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			connection.close();
			statement.close();
		}

		
	}

	@Override
	public List<Person> getBySearch(String search) throws SQLException {


		
		ArrayList<Person> list = new ArrayList<>();

		connection = getConnection();
		statement = connection.createStatement();

		 String query = "SELECT * FROM iletisim WHERE LOWER(ad) like '%" + search.toLowerCase()
         + "%' or LOWER(soyad) like '%" + search.toLowerCase() + "%' or tel like '%" + search
         + "%' or LOWER(email) like '%" + search.toLowerCase() + "%' or LOWER(ad) like '%" + search.toLowerCase()
         + "%'";
		 Person person;
		try {

			rs = statement.executeQuery(query);
			while (rs.next()) {
				person = new Person(rs.getInt("id"), rs.getString("ad"), rs.getString("soyad"), rs.getString("tel"),
						rs.getString("email"), rs.getString("adres"));
				list.add(person);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			statement.close();
			rs.close();
		}
		return list;
		
		
		
		
	}

}
