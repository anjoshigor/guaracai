package dao;

import java.util.ArrayList;
import java.util.List;
import org.jooq.Record;
import org.jooq.Result;
import model.Client;
import service.tables.records.TbClientRecord;
import static service.tables.TbClient.TB_CLIENT;

/**
 * 
 * @author alvesmarcos
 *
 */
public class ClientDAO extends BasicDAO {
	
	private Client client;
	List<Client> clientList;
	
	public ClientDAO() {
		connect();
		client = null;
		clientList = null;
	}

	@Override
	public int add(Object c) {
		client = (Client) c;
		
		return context.insertInto(TB_CLIENT)
			          .set(TB_CLIENT.DATE_OF_BIRTH, client.getDateOfBirth())
			          .set(TB_CLIENT.PHONE, client.getPhone())
			          .set(TB_CLIENT.NAME, client.getName())
			          .set(TB_CLIENT.EMAIL, client.getEmail())
			          .set(TB_CLIENT.AMOUNT_SPENT, client.getAmountSpent())
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
		Result<TbClientRecord> result = context.selectFrom(TB_CLIENT).fetch();
		
		inflate(result);
		
		return clientList;
	}
	
	private void inflate(Result<TbClientRecord> result){
		clientList = new ArrayList<Client>();

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
	}
	
	public List<Client> findByAmountSpent(double amountSpent){
		
		Result<TbClientRecord> result = context.selectFrom(TB_CLIENT)
		 		  							   .where(TB_CLIENT.AMOUNT_SPENT.equal(amountSpent))
		 		  							   .orderBy(TB_CLIENT.NAME)
		 		  							   .fetch();
		inflate(result);
		
		return clientList;
	}
	
	public List<Client> findByBalance(double balance){
		
		Result<TbClientRecord> result = context.selectFrom(TB_CLIENT)
		 		  							   .where(TB_CLIENT.BALANCE.like(balance+"%"))
		 		  							   .orderBy(TB_CLIENT.NAME)
		 		  							   .fetch();
		inflate(result);
		
		return clientList;
	}
	
	
	public List<Client> findByDateOfBirth(String dateOfBirth){
		
		Result<TbClientRecord> result = context.selectFrom(TB_CLIENT)
		 		  							   .where(TB_CLIENT.DATE_OF_BIRTH.equal(dateOfBirth))
		 		  							   .orderBy(TB_CLIENT.NAME)
		 		  							   .fetch();
		inflate(result);
		
		return clientList;
	}
	
	public Client findById(int id){
		
		Result<TbClientRecord> result = context.selectFrom(TB_CLIENT)
		 		  							   .where(TB_CLIENT.ID.equal(id))
		 		  							   .fetch();
		inflate(result);
		
		return clientList.get(0);
	}
	
	public List<Client> findByName(String name){
		
		Result<TbClientRecord> result = context.selectFrom(TB_CLIENT)
		 		  							   .where(TB_CLIENT.NAME.like("%"+name+"%"))
		 		  							   .orderBy(TB_CLIENT.NAME)
		 		  							   .fetch();
		inflate(result);
		
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
					  .set(TB_CLIENT.AMOUNT_SPENT, client.getAmountSpent())
		              .set(TB_CLIENT.BALANCE, client.getBalance()) 
			          .where(TB_CLIENT.ID.equal(client.getId()))
			          .execute();
	}
}
