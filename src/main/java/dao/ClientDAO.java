package dao;

import java.util.ArrayList;
import java.util.List;
import org.jooq.Record;
import org.jooq.Result;
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
	public int add(Object c) {
		client = (Client) c;
		
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
	public int delete(Object c) {
		client = (Client) c;

		return context.deleteFrom(TB_CLIENT)
				      .where(TB_CLIENT.ID.equal(client.getId()))
				      .execute();
	}
	
	@Override
	public List<Client> getAll() {
		List<Client> clientList = new ArrayList<Client>();
	
		//Executando um SELECT * na tabela Client
		Result<Record> result =  context.select().from(TB_CLIENT).fetch();
		
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
	public int update(Object c) {
		client = (Client) c;
		
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
