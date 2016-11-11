package dao;

import java.sql.Connection;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import util.PgSqlConnectionUtil;

/**
 * 
 * @author alvesmarcos
 *
 */
public abstract class BasicDAO {
	
	protected Connection connection;
	protected DSLContext context;
	
	public void connect(){
		connection = PgSqlConnectionUtil.getConnection();
		context = DSL.using(connection, SQLDialect.POSTGRES);
	}
	
	public void disconnect(){
		PgSqlConnectionUtil.release(connection);
	}
	
	// metodos básicos que TODAS as classes do pacote DAO devem implementar
	
	public abstract int add(Object o);
	
	public abstract int delete(Object o);

	public abstract List<?> getAll();
	
	public abstract int update(Object o);
}