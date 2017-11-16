package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Credit;

public class CreditDAOImpl implements CreditDAO {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public CreditDAOImpl() {
		getConnetion();
	}
	
	public Connection getConnetion() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/DB_Credit", "postgres", "1234");
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void createCredit(Credit credit) {
		try {
		if(connection != null) {
			preparedStatement = connection.prepareStatement("INSERT INTO credit (name, expeditionDate,"
									+ "type)values (?,?,?);");
			preparedStatement.setString(1,credit.getName() );
			preparedStatement.setString(2,credit.getExpeditionDate() );
			preparedStatement.setString(3,credit.getType());
			preparedStatement.execute();
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Credit readCredit(Long id) {
		Credit credit = null;
		try {
			if(connection != null) {
				preparedStatement = connection.prepareStatement("SELECT id, name, expeditiondate, type FROM credit WHERE id=?");
				
				preparedStatement.setLong(1, id);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					credit = new Credit(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
											resultSet.getString(4));
				}
				
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return credit;
	}

	@Override
	public List<Credit> readAllCredits() {
		List<Credit> credits = new ArrayList<Credit>();
		try {
		
				preparedStatement = connection.prepareStatement("SELECT id, name, expeditiondate, type FROM credit");
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					Credit credit = new Credit(
									resultSet.getLong(1), 
									resultSet.getString(2), 
									resultSet.getString(3),
									resultSet.getString(4));
					credits.add(credit);
				}
				
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return credits;
	}

	@Override
	public void updateCredit (Credit credit) {
		try {
			if(connection != null) {
				preparedStatement = connection.prepareStatement("UPDATE credit SET name=?, "
											+ "expeditionDate=?,"
										+ "type=? WHERE id=?;");
				preparedStatement.setString(1,credit.getName() );
				preparedStatement.setString(2,credit.getExpeditionDate() );
				preparedStatement.setString(3,credit.getType());
				preparedStatement.setLong(4, credit.getId());
				preparedStatement.execute();
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void deleteCredit(Long id) {
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement("DELETE FROM credit WHERE id=?;");
				preparedStatement.setLong(1, id);
				preparedStatement.execute();
				
			}catch(SQLException e){
				e.printStackTrace();
				
			}
		}
		
	}
	
	

}
