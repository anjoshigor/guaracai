package dao;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import model.Sale;
import static service.tables.TbSale.TB_SALE;
/**
 * 
 * @author alvesmarcos
 *
 */
public class SaleDAO extends BasicDAO {
	
	private Sale sale;
	
	public SaleDAO(){
		connect();
		sale = null;
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
		List<Sale> saleList = new ArrayList<Sale>();
		
		Result<Record> result = context.select().from(TB_SALE).fetch();
		
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
