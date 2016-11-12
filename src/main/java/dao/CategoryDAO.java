package dao;

import java.util.ArrayList;
import java.util.List;
import org.jooq.Record;
import org.jooq.Result;
import model.Category;
import static service.tables.TbCategory.TB_CATEGORY;
/**
 * 
 * @author alvesmarcos
 *
 */
public class CategoryDAO extends BasicDAO {
	
	private Category category;
	
	public CategoryDAO() {
		connect();
		category = null;
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
		List<Category> categoryList = new ArrayList<Category>();
		
		//Executando um SELECT * na tabela Category
		Result<Record> result =  context.select().from(TB_CATEGORY).fetch();
		
		for(Record r: result){
			category = new Category(r.getValue(TB_CATEGORY.ID),
									r.getValue(TB_CATEGORY.NAME),
									r.getValue(TB_CATEGORY.DESCRIPTION));
			categoryList.add(category);
		}
		return categoryList;
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
