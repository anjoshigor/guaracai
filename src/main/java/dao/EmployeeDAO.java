package dao;

import java.util.ArrayList;
import java.util.List;
import org.jooq.Record;
import org.jooq.Result;
import model.Address;
import model.Employee;
import static service.tables.TbEmployee.TB_EMPLOYEE;
/**
 * 
 * @author alvesmarcos
 *
 */
public class EmployeeDAO extends BasicDAO {
	
	private Employee employee;
	private Address adress;

	public EmployeeDAO() {
		connect();
		this.adress = null;
		this.employee = null;
	}

	@Override
	public int add(Object e) {
		employee = (Employee) e;
		
		return context.insertInto(TB_EMPLOYEE)
					  .set(TB_EMPLOYEE.COMPLEMENT, employee.getAddress().getComplement())
					  .set(TB_EMPLOYEE.CITY, employee.getAddress().getCity())
					  .set(TB_EMPLOYEE.STREET, employee.getAddress().getStreet())
					  .set(TB_EMPLOYEE.DISTRICT, employee.getAddress().getDistrict())
					  .set(TB_EMPLOYEE.NUMBER, employee.getAddress().getNumber())
					  .set(TB_EMPLOYEE.STATE, employee.getAddress().getState())
			          .set(TB_EMPLOYEE.NAME, employee.getUsername())
			          .set(TB_EMPLOYEE.DATA_OF_BIRTH, employee.getDateOfBirth())
			          .set(TB_EMPLOYEE.PHONE, employee.getPhone())
			          .set(TB_EMPLOYEE.CPF, employee.getCpf())
			          .set(TB_EMPLOYEE.USERNAME, employee.getUsername())
			          .set(TB_EMPLOYEE.AGENCY, employee.getAgency())
			          .set(TB_EMPLOYEE.COUNT, employee.getCount())
			          .set(TB_EMPLOYEE.TYPE, employee.getType())
			          .set(TB_EMPLOYEE.EMAIL, employee.getEmail())
			          .execute();
	}
	
	@Override
	public int delete(Object e) {
		employee = (Employee) e;

		return context.deleteFrom(TB_EMPLOYEE)
				      .where(TB_EMPLOYEE.ID.equal(employee.getId()))
				      .execute();
	}
	
	@Override
	public List<Employee> getAll() {
		List<Employee> employeeList = new ArrayList<Employee>();
		
		//Executando um SELECT * na tabela Employee
		Result<Record> result =  context.select().from(TB_EMPLOYEE).fetch();
		
		for(Record r: result){
			adress = new Address(r.getValue(TB_EMPLOYEE.COMPLEMENT),
							     r.getValue(TB_EMPLOYEE.CITY), 
							     r.getValue(TB_EMPLOYEE.STREET), 
							     r.getValue(TB_EMPLOYEE.DISTRICT), 
							     r.getValue(TB_EMPLOYEE.NUMBER), 
							     r.getValue(TB_EMPLOYEE.STATE));
			
			employee = new Employee(r.getValue(TB_EMPLOYEE.ID),
									r.getValue(TB_EMPLOYEE.NAME),
									r.getValue(TB_EMPLOYEE.DATA_OF_BIRTH),
									r.getValue(TB_EMPLOYEE.PHONE),
									r.getValue(TB_EMPLOYEE.CPF),
									r.getValue(TB_EMPLOYEE.USERNAME),
									adress,
									r.getValue(TB_EMPLOYEE.AGENCY),
									r.getValue(TB_EMPLOYEE.COUNT),
									r.getValue(TB_EMPLOYEE.TYPE),
									r.getValue(TB_EMPLOYEE.EMAIL));	
			employeeList.add(employee);
		}
		return employeeList;
	}
	
	public int checkUserPassword(String user, String password){
		
		return context.selectFrom(TB_EMPLOYEE)
					  .where(TB_EMPLOYEE.USERNAME.equal(user))
					  .and(TB_EMPLOYEE.PASSWORD.equal(password))
					  .execute();
	}
	
	@Override
	public int update(Object e) {
		employee = (Employee) e;
		
		return context.update(TB_EMPLOYEE)
					  .set(TB_EMPLOYEE.COMPLEMENT, employee.getAddress().getComplement())
					  .set(TB_EMPLOYEE.CITY, employee.getAddress().getCity())
					  .set(TB_EMPLOYEE.STREET, employee.getAddress().getStreet())
					  .set(TB_EMPLOYEE.DISTRICT, employee.getAddress().getDistrict())
					  .set(TB_EMPLOYEE.NUMBER, employee.getAddress().getNumber())
					  .set(TB_EMPLOYEE.STATE, employee.getAddress().getState())
			          .set(TB_EMPLOYEE.NAME, employee.getUsername())
			          .set(TB_EMPLOYEE.DATA_OF_BIRTH, employee.getDateOfBirth())
			          .set(TB_EMPLOYEE.PHONE, employee.getPhone())
			          .set(TB_EMPLOYEE.CPF, employee.getCpf())
			          .set(TB_EMPLOYEE.USERNAME, employee.getUsername())
			          .set(TB_EMPLOYEE.AGENCY, employee.getAgency())
			          .set(TB_EMPLOYEE.COUNT, employee.getCount())
			          .set(TB_EMPLOYEE.TYPE, employee.getType())
			          .set(TB_EMPLOYEE.EMAIL, employee.getEmail())
			          .where(TB_EMPLOYEE.ID.equal(employee.getId()))
			          .execute();
	}
}
