package dao;

import java.util.ArrayList;
import java.util.List;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import model.Client;
import static service.tables.TbClient.TB_CLIENT;

/**
 * 
 * @author alvesmarcos
 *
 */
public class ClientDAO extends BasicDAO {
	private Client client;
	
	public ClientDAO() {
		connect();
		this.client = null;
	}

	@Override
	public int add(Object e) {
		client = (Client) e;
		
		return context.insertInto(TB_CLIENT)
			          .set(TB_CLIENT.DATE_OF_BIRTH, client.getDateOfBirth())
			          .set(TB_CLIENT.PHONE, client.getPhone())
			          .set(TB_CLIENT.NAME, client.getName())
			          .set(TB_CLIENT.EMAIL, client.getEmail())
			          .set(TB_CLIENT.AMOUNT_SPENT, client.getBalance())
			          .set(TB_CLIENT.BALANCE, client.getBalance())
			          .execute();
	}
	
	@Override
	public int delete(Object e) {
		client = (Client) e;

		return context.deleteFrom(TB_CLIENT)
				      .where(TB_CLIENT.ID.equal(client.getId()))
				      .execute();
	}
	
	@Override
	public List<Client> getAll() {
		List<Client> clientList = new ArrayList<Client>();
		
		//Realizando a query utilizando o ORM JOOQ
		DSLContext query = DSL.using(connection, SQLDialect.POSTGRES); // Conectando ao DB e selecionando o SGBD
		
		//Executando um SELECT * na tabela Employee
		Result<Record> result =  query.select().from(TB_CLIENT).fetch();
		
		for(Record r: result){
			client = new Client(r.getValue(TB_CLIENT.ID),
								r.getValue(TB_CLIENT.NAME),
								r.getValue(TB_CLIENT.DATE_OF_BIRTH),
								r.getValue(TB_CLIENT.PHONE),
								r.getValue(TB_CLIENT.EMAIL),
								r.getValue(TB_CLIENT.AMOUNT_SPENT),
								r.getValue(TB_CLIENT.BALANCE));	
			clientList.add(client);
		}
		return clientList;
	}
	
	@Override
	public int update(Object e) {
		client = (Client) e;
		
		return context.update(TB_CLIENT)
					  .set(TB_CLIENT.DATE_OF_BIRTH, client.getDateOfBirth())
					  .set(TB_CLIENT.PHONE, client.getPhone())
					  .set(TB_CLIENT.NAME, client.getName())
					  .set(TB_CLIENT.EMAIL, client.getEmail())
					  .set(TB_CLIENT.AMOUNT_SPENT, client.getBalance())
		              .set(TB_CLIENT.BALANCE, client.getBalance()) 
			          .where(TB_CLIENT.ID.equal(client.getId()))
			          .execute();
	}
}
