package dao;

import java.util.ArrayList;
import java.util.List;
import org.jooq.Record;
import org.jooq.Result;
import model.Category;
import service.tables.records.TbCategoryRecord;

import static service.tables.TbCategory.TB_CATEGORY;
/**
 * 
 * @author alvesmarcos
 *
 */
public class CategoryDAO extends BasicDAO {
	
	private Category category;
	private List<Category> categoryList;
	
	public CategoryDAO() {
		connect();
		category = null;
		categoryList = null;
	}
	
	@Override
	public int add(Object c) {
		category = (Category) c;
		
		return context.insertInto(TB_CATEGORY)
				      .set(TB_CATEGORY.NAME, category.getName())
				      .set(TB_CATEGORY.DESCRIPTION, category.getDescription())
				      .execute();
	}

	@Override
	public int delete(Object c) {
		category = (Category) c;

		return context.deleteFrom(TB_CATEGORY)
				      .where(TB_CATEGORY.ID.equal(category.getId()))
				      .execute();
	}

	@Override
	public List<Category> getAll() {
		
		Result<TbCategoryRecord> result =  context.selectFrom(TB_CATEGORY).fetch();
		
		inflate(result);
		
		return categoryList;
	}
	
	private void inflate(Result<TbCategoryRecord> result){
		categoryList = new ArrayList<>();
		
		for(Record r: result){
			category = new Category(r.getValue(TB_CATEGORY.ID),
									r.getValue(TB_CATEGORY.NAME),
									r.getValue(TB_CATEGORY.DESCRIPTION));
			categoryList.add(category);
		}
	}
	
	public Category findById(int id){
	
		Result<TbCategoryRecord> result = context.selectFrom(TB_CATEGORY)
										 		  .where(TB_CATEGORY.ID.equal(id))
										          .fetch();
		inflate(result);
		
		return categoryList.get(0);
	}
	
	public Category findByName(String name){
		
		Result<TbCategoryRecord> result = context.selectFrom(TB_CATEGORY)
										 		  .where(TB_CATEGORY.NAME.equal(name))
										 		  .orderBy(TB_CATEGORY.NAME)
										          .fetch();
		inflate(result);
		
		return categoryList.get(0);
	}
	
	@Override
	public int update(Object c) {
		category = (Category) c;
		
		return context.update(TB_CATEGORY)
				      .set(TB_CATEGORY.NAME, category.getName())
				      .set(TB_CATEGORY.DESCRIPTION, category.getDescription())
				      .where(TB_CATEGORY.ID.equal(category.getId()))
				      .execute();
	}
}
