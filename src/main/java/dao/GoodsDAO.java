package dao;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import model.Goods;
import static service.tables.TbGoods.TB_GOODS;
/**
 * 
 * @author alvesmarcos
 *
 */
public class GoodsDAO extends BasicDAO {
	
	private Goods goods;
	
	public GoodsDAO(){
		connect();
		goods = null;
	}

	@Override
	public int add(Object g) {
		goods = (Goods) g;

		return context.insertInto(TB_GOODS)
					   .set(TB_GOODS.ID, goods.getId())
					   .set(TB_GOODS.CODE, goods.getCode())
					   .set(TB_GOODS.PRICE, goods.getPrice())
					   .set(TB_GOODS.NAME, goods.getName())
					   .set(TB_GOODS.DESCRIPTION, goods.getDescription())
					   .set(TB_GOODS.SIZE, goods.getSize())
					   .set(TB_GOODS.CATEGORY_ID, goods.getCategoryId())
					   .execute();
	}

	@Override
	public int delete(Object g) {
		goods = (Goods) g;
		
		return context.delete(TB_GOODS)
					  .where(TB_GOODS.ID.equal(goods.getId())) 
				      .execute();
	}

	@Override
	public List<Goods> getAll() {
		List<Goods> goodsList = new ArrayList<Goods>();
		
		Result<Record> result = context.select().from(TB_GOODS).fetch();
		
		for(Record r: result){
			goods = new Goods(r.getValue(TB_GOODS.ID),
							  r.getValue(TB_GOODS.CODE),
							  r.getValue(TB_GOODS.PRICE), 
							  r.getValue(TB_GOODS.NAME),
							  r.getValue(TB_GOODS.DESCRIPTION),
							  r.getValue(TB_GOODS.SIZE), 
							  r.getValue(TB_GOODS.CATEGORY_ID));
				   
			goodsList.add(goods);
		}
		
		return goodsList;
	}

	@Override
	public int update(Object g) {
		goods = (Goods) g;
		
		return context.update(TB_GOODS)
				   .set(TB_GOODS.ID, goods.getId())
				   .set(TB_GOODS.CODE, goods.getCode())
				   .set(TB_GOODS.PRICE, goods.getPrice())
				   .set(TB_GOODS.NAME, goods.getName())
				   .set(TB_GOODS.DESCRIPTION, goods.getDescription())
				   .set(TB_GOODS.SIZE, goods.getSize())
				   .set(TB_GOODS.CATEGORY_ID, goods.getCategoryId())
				   .where(TB_GOODS.ID.equal(goods.getId())) 
				   .execute();
	}
}
