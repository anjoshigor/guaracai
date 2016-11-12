package dao;

import java.util.ArrayList;
import java.util.List;
import org.jooq.Record;
import org.jooq.Result;
import model.Expenses;

import static service.tables.TbExpenses.TB_EXPENSES;
/**
 * 
 * @author alvesmarcos
 *
 */
public class ExpensesDAO extends BasicDAO {
	
	private Expenses expenses;
	
	@Override
	public int add(Object e) {
		expenses = (Expenses) e;
		
		return context.insertInto(TB_EXPENSES)
				      .set(TB_EXPENSES.DESCRIPTION, expenses.getDescription())
				      .set(TB_EXPENSES.COST, expenses.getCost()) 
				      .set(TB_EXPENSES.EMPLOYEE_ID, expenses.getEmployeeId())
				      .execute();
	}

	@Override
	public int delete(Object e) {
		expenses = (Expenses) e;

		return context.deleteFrom(TB_EXPENSES)
				      .where(TB_EXPENSES.ID.equal(expenses.getId()))
				      .execute();
	}

	@Override
	public List<Expenses> getAll() {
		List<Expenses> expensesList = new ArrayList<Expenses>();
		
		//Executando um SELECT * na tabela expenses
		Result<Record> result =  context.select().from(TB_EXPENSES).fetch();
		
		for(Record r: result){
			expenses = new Expenses(r.getValue(TB_EXPENSES.ID),
									r.getValue(TB_EXPENSES.DESCRIPTION),
									r.getValue(TB_EXPENSES.COST),
									r.getValue(TB_EXPENSES.ID));
			expensesList.add(expenses);
		}
		return expensesList;
	}

	@Override
	public int update(Object e) {
		expenses = (Expenses) e;
		
		return context.update(TB_EXPENSES)
				      .set(TB_EXPENSES.DESCRIPTION, expenses.getDescription())
				      .set(TB_EXPENSES.COST, expenses.getCost())
				      .set(TB_EXPENSES.EMPLOYEE_ID, expenses.getEmployeeId())
				      .where(TB_EXPENSES.ID.equal(expenses.getId()))
				      .execute();
	}
}
