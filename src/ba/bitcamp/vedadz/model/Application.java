package ba.bitcamp.vedadz.model;
import java.sql.*;

/**
 * Class which connects to our database.
 * Also this class execute all the queries we want.
 * Any direct connection to database or any actions on database
 * are from this class.
 * @author vedad
 *
 */
public class Application {

	protected static  Connection db;
	
	/**
	 * Static method for initial connecting to db.
	 * @throws SQLException
	 */
	public static void init(String databaseName) throws SQLException{
		db = DriverManager.getConnection("jdbc:sqlite:" +databaseName +".db");
		
	}
	
	/**
	 * Method which is searching in our db.
	 * It has 2 parameters. ID of item we want
	 * and table name which we're searching.
	 * @param id	- ID of element we're searching
	 * @param tableName -table name we're searching in.
	 * @return	ResultSet as result of our search.
	 */
	protected static ResultSet find(int id, String tableName){
	try {
		Statement stmt = db.createStatement();	//This way we create statement in our databse.
		String sql =String.format("SELECT * FROM %s WHERE id = '%d';", tableName, id);
		return stmt.executeQuery(sql);	//executeQuery which returns ResultSet.
	} catch (SQLException e) {
		System.err.println(e.getMessage());
		return null;
	}		
	}
	
	/**
	 * Method for saving into our database.
	 * It actually execute INSERT query.
	 * @param tableName - name of table we're inserting in.
	 * @param values 	- values we're inserting
	 * @return			- true if saving went good or false if it failed.
	 */
	protected static int save(String tableName, String values){
		Statement stmt = null;
		try {
			 stmt = db.createStatement();
			String sql = String.format("INSERT INTO %s VALUES %s ;", tableName, values);
			stmt.execute("begin;");
			stmt.execute(sql);
			stmt.execute("commit;");
			
			sql = String.format("SELECT max(id) AS last FROM %s" ,tableName);
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			return rs.getInt(1);			
		} catch (SQLException e) {
			if(stmt != null){
				try {
					stmt.execute("rollback;");	//if saving went wrong we rollback.
				} catch (SQLException e1) {
					System.err.println(e.getMessage());
					return -1; //if we still got error, we return false.
				}
			}
			System.err.println(e.getMessage());			
			return -1;
		}
	}
	
	/**
	 * Method which returns all items(columns) user send as parameter.
	 * Similar to find method.
	 * @param tableName	-name of table we're searching.
	 * @param columns	-columns we want to get ( *  should be acceptable)
	 * @return  
	 */
	protected static ResultSet all(String tableName, String columns){
		try {
			Statement stmt = db.createStatement();
			String sql = String.format("SELECT %s FROM %s ;", columns, tableName);
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	public static void update(String tableName, int id, String values) {
		try {
			Statement stmt = db.createStatement();
			String sql = String.format("UPDATE %s SET %s where id= '%d';",tableName, values, id);
			stmt.execute(sql);
		} catch (SQLException e) {
			System.err.println("FAILED TO UPDATE");
		}
	}

	public static void delete(String tableName, int id) {
		try {
			Statement stmt = db.createStatement();
			String sql = String.format("DELETE FROM %s where id= '%d';",tableName, id);
			stmt.execute(sql);
		} catch (SQLException e) {
			System.err.println("FAILED TO DELETE");
		}
		
	}
}
