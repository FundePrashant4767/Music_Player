package music_players_jdbc.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class MusicCrud {

	private PreparedStatement PreparedStatement;

	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {

		FileInputStream fileInputStream = new FileInputStream("dbconfigure.properties");

		Properties properties = new Properties();

		properties.load(fileInputStream);

		Class.forName(properties.getProperty("className"));

		Connection connection = DriverManager.getConnection(properties.getProperty("url"),

				properties.getProperty("user"), properties.getProperty("password"));

		return connection;

	}

	public void saveMusic(MusicCrud music) throws ClassNotFoundException, IOException, SQLException {

		Connection connection = getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO musicplayer VALUES(?,?,?,?)");

		preparedStatement.setInt(1, music.getId());

		preparedStatement.setString(2, music.getName());

		preparedStatement.setString(3, music.getSingure());

		preparedStatement.setString(4, music.getLanguage());

		int count = preparedStatement.executeUpdate();

		if (count == 1) {

			System.out.println("Inserted");

		} else {

			System.out.println("Not Inserted");

		}

		connection.close();

	}

	private String getLanguage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateMusicapp(MusicCrud music) throws SQLException, ClassNotFoundException, IOException {
		Connection connection = getConnection();
		PreparedStatement = connection
				.prepareStatement("UPDATE musicplayer SET NAME=? , SINGURE=? , LANGUAGE=?  WHERE ID=?");
		PreparedStatement.setString(1, music.getName());
		PreparedStatement.setString(2, music.getSingure());
		PreparedStatement.setNString(3, music.getLanguage());
		PreparedStatement.setInt(4, music.getId());
		int count = PreparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Updated");
		} else {
			System.out.println("Not Updated");

		}
		connection.close();
	}

	private String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getSingure() {
		// TODO Auto-generated method stub
		return null;
	}

	private int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deleteMusicapp(MusicCrud music) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = getConnection();
		PreparedStatement = connection.prepareStatement("Delete from musicplayer where id=?");
		PreparedStatement.setInt(1, music.getId());
		int count = PreparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Deleted..!!");
		} else {
			System.out.println("Not Deleted..!!");
		}
		connection.close();
	}

	public void getMusicappById(int id) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = getConnection();
		PreparedStatement = connection.prepareStatement("SELECT * FROM musicplayer WHERE  id = ?");
		PreparedStatement.setInt(1, id);
		ResultSet resultset = PreparedStatement.executeQuery();
		while (resultset.next()) {
			System.out.println(" ID : " + resultset.getInt(1));
			System.out.println(" Music Name : " + resultset.getString(2));
			System.out.println(" Singure Name : " + resultset.getString(3));
			System.out.println(" Music Language : " + resultset.getString(4));
		}

		connection.close();

	}

	public void fetchMusicapp(MusicCrud music) throws SQLException, ClassNotFoundException, IOException {
		Connection connection = getConnection();
		PreparedStatement = connection.prepareStatement("SELECT * FROM musicplayer ");
		ResultSet resultset = PreparedStatement.executeQuery();
		while (resultset.next()) {
			System.out.println(resultset.getInt(1));
			System.out.println(resultset.getString(2));
			System.out.println(resultset.getString(3));
			System.out.println(resultset.getString(4));
		}
		connection.close();

	}

	public void playmusic(MusicCrud music) throws Exception {
		Connection connection = getConnection();
		PreparedStatement = connection.prepareStatement("SELECT * FROM musicplayer  where id = ? ");
		PreparedStatement.setInt(1, getId());
		ResultSet resultSet = PreparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println("Id " + resultSet.getInt(1));
			System.out.println("Name : " + resultSet.getString(2) );
			System.out.println(" Singure Name : " + resultSet.getString(3));
			System.out.println(" Music Language : " + resultSet.getString(4)+ "is Started");
		}
		connection.close();
	}

	public void setName(String name) {
		// TODO Auto-generated method student

	}

	public void setSingure(String singure) {
		// TODO Auto-generated method stub

	}

	public void setLanguage(String language) {
		// TODO Auto-generated method stub

	}

	public void setId(int id) {
		// TODO Auto-generated method stub

	}

}
