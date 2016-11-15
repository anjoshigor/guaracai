package dao;

import java.util.ArrayList;
import java.util.List;
import org.jooq.Record;
import org.jooq.Result;
import model.Expenses;
import service.tables.records.TbExpensesRecord;
import static service.tables.TbExpenses.TB_EXPENSES;
/**
 * 
 * @author alvesmarcos
 *
 */
public class ExpensesDAO extends BasicDAO {
	
	private Expenses expenses;
	private List<Expenses> expensesList;
	
	public ExpensesDAO() {
		connect();
		expenses = null;
		expensesList = null;
	}
	
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
		
		Result<TbExpensesRecord> result =  context.selectFrom(TB_EXPENSES).fetch();
		
		inflate(result);
		
		return expensesList;
	}
	
	private void inflate(Result<TbExpensesRecord> result){
		expensesList = new ArrayList<>();
		
		for(Record r: result){
			expenses = new Expenses(r.getValue(TB_EXPENSES.ID),
									r.getValue(TB_EXPENSES.DESCRIPTION),
									r.getValue(TB_EXPENSES.COST),
									r.getValue(TB_EXPENSES.EMPLOYEE_ID));
			expensesList.add(expenses);
		}
	}
	
	public List<Expenses> findByCost(double cost){
		
		Result<TbExpensesRecord> result = context.selectFrom(TB_EXPENSES)
		 		  							   .where(TB_EXPENSES.COST.equal(cost))
		 		  							   .orderBy(TB_EXPENSES.ID)
		 		  							   .fetch();
		inflate(result);
		
		return expensesList;
	}
	
	public List<Expenses> findById(int id){
		
		Result<TbExpensesRecord> result = context.selectFrom(TB_EXPENSES)
		 		  							   .where(TB_EXPENSES.ID.equal(id))
		 		  							   .orderBy(TB_EXPENSES.ID)
		 		  							   .fetch();
		inflate(result);
		
		return expensesList;
	}
	
	public List<Expenses> findByEmployeeId(int employeeId){
		
		Result<TbExpensesRecord> result = context.selectFrom(TB_EXPENSES)
		 		  							   .where(TB_EXPENSES.EMPLOYEE_ID.equal(employeeId))
		 		  							   .orderBy(TB_EXPENSES.ID)
		 		  							   .fetch();
		inflate(result);
		
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
