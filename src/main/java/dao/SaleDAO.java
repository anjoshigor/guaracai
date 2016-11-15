package dao;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import model.Sale;
import service.tables.records.TbSaleRecord;

import static service.tables.TbSale.TB_SALE;
/**
 * 
 * @author alvesmarcos
 *
 */
public class SaleDAO extends BasicDAO {
	
	private Sale sale;
	private List<Sale> saleList;
	
	public SaleDAO(){
		connect();
		sale = null;
		saleList = null;
	}
	
	@Override
	public int add(Object s) {
		sale = (Sale) s;
		
		return context.insertInto(TB_SALE)
					  .set(TB_SALE.DATE, sale.getDate())
					  .set(TB_SALE.OBSERVATION, sale.getObservation())
					  .set(TB_SALE.TOTAL, sale.getTotal())
					  .set(TB_SALE.DISCOUNT, sale.getDiscount())
					  .set(TB_SALE.CLIENT_ID, sale.getClientId())
					  .set(TB_SALE.EMPLOYEE_ID, sale.getEmployeeId())
					  .execute();
	}

	@Override
	public int delete(Object s) {
		sale = (Sale) s;
		
		return context.delete(TB_SALE)
					  .where(TB_SALE.ID.equal(sale.getId()))
					  .execute();
	}

	@Override
	public List<Sale> getAll() {
		
		Result<TbSaleRecord> result = context.selectFrom(TB_SALE).fetch();
		
		inflate(result);
		
		return saleList;
	}

	private void inflate(List<TbSaleRecord> result){
		saleList = new ArrayList<>();

		for(Record r: result){
			sale = new Sale(r.getValue(TB_SALE.ID),
							r.getValue(TB_SALE.DATE),
							r.getValue(TB_SALE.OBSERVATION),
							r.getValue(TB_SALE.TOTAL),
							r.getValue(TB_SALE.DISCOUNT),
							r.getValue(TB_SALE.CLIENT_ID),
							r.getValue(TB_SALE.EMPLOYEE_ID));
			saleList.add(sale);
		}
	}
	
	public List<Sale> findByClientId(int clientId){
		
		Result<TbSaleRecord> result = context.selectFrom(TB_SALE)
											.where(TB_SALE.CLIENT_ID.equal(clientId))
											.orderBy(TB_SALE.TOTAL)
											.fetch();
		
		inflate(result);
		
		return saleList;
	}
	
	public List<Sale> findByDate(String date){
		
		Result<TbSaleRecord> result = context.selectFrom(TB_SALE)
											.where(TB_SALE.DATE.equal(date))
											.orderBy(TB_SALE.TOTAL)
											.fetch();
		
		inflate(result);
		
		return saleList;
	}
	
	public List<Sale> findByDiscount(double discount){
		
		Result<TbSaleRecord> result = context.selectFrom(TB_SALE)
											.where(TB_SALE.DISCOUNT.equal(discount))
											.orderBy(TB_SALE.TOTAL)
											.fetch();
		
		inflate(result);
		
		return saleList;
	}
	
	public List<Sale> findByEmployeeId(int employeeId){
		
		Result<TbSaleRecord> result = context.selectFrom(TB_SALE)
											.where(TB_SALE.EMPLOYEE_ID.equal(employeeId))
											.orderBy(TB_SALE.TOTAL)
											.fetch();
		
		inflate(result);
		
		return saleList;
	}
	
	public List<Sale> findById(int id){
		
		Result<TbSaleRecord> result = context.selectFrom(TB_SALE)
											.where(TB_SALE.ID.equal(id))
											.orderBy(TB_SALE.TOTAL)
											.fetch();
		
		inflate(result);
		
		return saleList;
	}
	
	public List<Sale> findByTotal(double total){
		
		Result<TbSaleRecord> result = context.selectFrom(TB_SALE)
											.where(TB_SALE.TOTAL.equal(total))
											.orderBy(TB_SALE.TOTAL)
											.fetch();
		
		inflate(result);
		
		return saleList;
	}

	
	@Override
	public int update(Object s) {
		sale = (Sale) s;
		
		return context.update(TB_SALE)
				  .set(TB_SALE.DATE, sale.getDate())
				  .set(TB_SALE.OBSERVATION, sale.getObservation())
				  .set(TB_SALE.TOTAL, sale.getTotal())
				  .set(TB_SALE.DISCOUNT, sale.getDiscount())
				  .set(TB_SALE.CLIENT_ID, sale.getClientId())
				  .set(TB_SALE.EMPLOYEE_ID, sale.getEmployeeId())
				  .where(TB_SALE.ID.equal(sale.getId()))
				  .execute();
	}
}
