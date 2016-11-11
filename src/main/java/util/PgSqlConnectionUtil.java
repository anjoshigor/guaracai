package util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.BasicConfigurator;
import org.jooq.util.GenerationTool;
import org.jooq.util.jaxb.Configuration;
import org.jooq.util.jaxb.Database;
import org.jooq.util.jaxb.Generator;
import org.jooq.util.jaxb.Jdbc;
import org.jooq.util.jaxb.Target;
/**
 * 
 * @author marcos-alves
 *
 */
public abstract class PgSqlConnectionUtil {
	
	private static final String HOSTNAME = "localhost";
	private static final short PORT = 5432;
	private static final String DATABASE = "db_guaracai";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "admin";
	private static final String URL = "jdbc:postgresql://" + HOSTNAME + ":" + PORT + "/" + DATABASE;

	public static Connection getConnection(){
		Connection connection = null;
				
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}	
	
	public static boolean isConnected(Connection connection){
		if(connection == null)
			return false;
		else
			return true;
	}
	
	@SuppressWarnings("deprecation")
	public static void jooqConfig() throws Exception {
		Configuration configuration = new Configuration()
		    .withJdbc(new Jdbc()
		        .withDriver("org.postgresql.Driver")
		        .withUrl(PgSqlConnectionUtil.URL)
		        .withUser(PgSqlConnectionUtil.USERNAME)
		        .withPassword(PgSqlConnectionUtil.PASSWORD))
		    .withGenerator(new Generator()
		        .withName("org.jooq.util.DefaultGenerator")
		        .withDatabase(new Database()
		            .withName("org.jooq.util.postgres.PostgresDatabase")
		            .withIncludes(".*")
		            .withExcludes("")
		            .withInputSchema("public"))
		        .withTarget(new Target()
		            .withPackageName("service")
		            .withDirectory("src/main/java")));

		//Log configuration
		BasicConfigurator.configure();
		GenerationTool.main(configuration);	
	}
	
	public static void release(Connection connection) {
		try {
			if(connection!=null)
				connection.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void release(PreparedStatement pstatement) {
		try {
			if(pstatement!=null)
				pstatement.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void release(ResultSet resultset) {
		try {
			if(resultset!=null)
				resultset.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void releaseAll(Connection connection, ResultSet resultset, PreparedStatement pstatment){
		release(connection);
		release(resultset);
		release(pstatment);
	}
}
