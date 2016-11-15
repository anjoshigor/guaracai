package dao;

import java.util.ArrayList;
import java.util.List;
import org.jooq.Record;
import org.jooq.Result;
import model.Goods;
import service.tables.records.TbGoodsRecord;
import static service.tables.TbGoods.TB_GOODS;
/**
 * 
 * @author alvesmarcos
 *
 */
public class GoodsDAO extends BasicDAO {
	
	private Goods goods;
	private List<Goods> goodsList;
	
	public GoodsDAO(){
		connect();
		goods = null;
		goodsList = null;
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
			
		Result<TbGoodsRecord> result = context.selectFrom(TB_GOODS).fetch();
		
		inflate(result);
		
		return goodsList;
	}
	
	private void inflate(Result<TbGoodsRecord> result){
		goodsList = new ArrayList<Goods>();

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
	}
	
	public List<Goods> findByCategoryId(int categoryId){
		
		Result<TbGoodsRecord> result = context.selectFrom(TB_GOODS)
		 		  							   .where(TB_GOODS.CATEGORY_ID.equal(categoryId))
		 		  							   .orderBy(TB_GOODS.NAME)
		 		  							   .fetch();
		inflate(result);
		
		return goodsList;
	}
	
	public List<Goods> findByCode(int code){
		
		Result<TbGoodsRecord> result = context.selectFrom(TB_GOODS)
		 		  							   .where(TB_GOODS.CODE.equal(code))
		 		  							   .orderBy(TB_GOODS.NAME)
		 		  							   .fetch();
		inflate(result);
		
		return goodsList;
	}
	
	public Goods findById(int id){
		
		Result<TbGoodsRecord> result = context.selectFrom(TB_GOODS)
		 		  							   .where(TB_GOODS.ID.equal(id))
		 		  							   .orderBy(TB_GOODS.NAME)
		 		  							   .fetch();
		inflate(result);
		
		return goodsList.get(0);
	}
	
	
	public List<Goods> findByName(String name){
		
		Result<TbGoodsRecord> result = context.selectFrom(TB_GOODS)
		 		  							   .where(TB_GOODS.NAME.like("%"+name+"%"))
		 		  							   .orderBy(TB_GOODS.NAME)
		 		  							   .fetch();
		inflate(result);
		
		return goodsList;
	}
	
	public List<Goods> findByPrice(double price){
		
		Result<TbGoodsRecord> result = context.selectFrom(TB_GOODS)
		 		  							   .where(TB_GOODS.PRICE.like(price+"%"))
		 		  							   .orderBy(TB_GOODS.NAME)
		 		  							   .fetch();
		inflate(result);
		
		return goodsList;
	}
	
	public List<Goods> findBySize(int size){
		
		Result<TbGoodsRecord> result = context.selectFrom(TB_GOODS)
		 		  							   .where(TB_GOODS.SIZE.like(size+"%"))
		 		  							   .orderBy(TB_GOODS.NAME)
		 		  							   .fetch();
		inflate(result);
		
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
