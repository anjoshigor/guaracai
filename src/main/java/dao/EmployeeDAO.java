package dao;

import java.util.ArrayList;
import java.util.List;
import org.jooq.Record;
import org.jooq.Result;
import model.Address;
import model.Employee;
import service.tables.records.TbEmployeeRecord;
import static service.tables.TbEmployee.TB_EMPLOYEE;
/**
 * 
 * @author alvesmarcos
 *
 */
public class EmployeeDAO extends BasicDAO {
	
	private Employee employee;
	private Address adress;
	private List<Employee> employeeList;

	public EmployeeDAO() {
		connect();
		adress = null;
		employee = null;
		employeeList = null;
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
			          .set(TB_EMPLOYEE.DATE_OF_BIRTH, employee.getDateOfBirth())
			          .set(TB_EMPLOYEE.PHONE, employee.getPhone())
			          .set(TB_EMPLOYEE.CPF, employee.getCpf())
			          .set(TB_EMPLOYEE.USERNAME, employee.getUsername())
			          .set(TB_EMPLOYEE.PASSWORD, employee.getPassword())
			          .set(TB_EMPLOYEE.AGENCY, employee.getAgency())
			          .set(TB_EMPLOYEE.COUNT, employee.getCount())
			          .set(TB_EMPLOYEE.TYPE, employee.getType())
			          .set(TB_EMPLOYEE.EMAIL, employee.getEmail())
			          .execute();
	}
	
	public int checkLogin(String user, String password){
		
		return context.selectFrom(TB_EMPLOYEE)
					  .where(TB_EMPLOYEE.USERNAME.equal(user))
					  .and(TB_EMPLOYEE.PASSWORD.equal(password))
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
		
		Result<TbEmployeeRecord> result =  context.selectFrom(TB_EMPLOYEE).fetch();
		
		inflate(result);
		
		return employeeList;
	}
	
	private void inflate(Result<TbEmployeeRecord> result){
		employeeList = new ArrayList<>();
		
		for(Record r: result){
			adress = new Address(r.getValue(TB_EMPLOYEE.COMPLEMENT),
							     r.getValue(TB_EMPLOYEE.CITY), 
							     r.getValue(TB_EMPLOYEE.STREET), 
							     r.getValue(TB_EMPLOYEE.DISTRICT), 
							     r.getValue(TB_EMPLOYEE.NUMBER), 
							     r.getValue(TB_EMPLOYEE.STATE));
			
			employee = new Employee(r.getValue(TB_EMPLOYEE.ID),
									r.getValue(TB_EMPLOYEE.NAME),
									r.getValue(TB_EMPLOYEE.DATE_OF_BIRTH),
									r.getValue(TB_EMPLOYEE.PHONE),
									r.getValue(TB_EMPLOYEE.CPF),
									r.getValue(TB_EMPLOYEE.USERNAME),
									r.getValue(TB_EMPLOYEE.PASSWORD),
									adress,
									r.getValue(TB_EMPLOYEE.AGENCY),
									r.getValue(TB_EMPLOYEE.COUNT),
									r.getValue(TB_EMPLOYEE.TYPE),
									r.getValue(TB_EMPLOYEE.EMAIL));	
			employeeList.add(employee);
		}
	}
	
	public List<Employee> findByCity(String city){
		
		Result<TbEmployeeRecord> result = context.selectFrom(TB_EMPLOYEE)
		 		  							   .where(TB_EMPLOYEE.CITY.equal(city))
		 		  							   .orderBy(TB_EMPLOYEE.NAME)
		 		  							   .fetch();
		inflate(result);
		
		return employeeList;
	}
	
	public List<Employee> findByCpf(String cpf){
		
		Result<TbEmployeeRecord> result = context.selectFrom(TB_EMPLOYEE)
		 		  							   .where(TB_EMPLOYEE.CPF.equal(cpf))
		 		  							   .orderBy(TB_EMPLOYEE.NAME)
		 		  							   .fetch();
		inflate(result);
		
		return employeeList;
	}
	
	public List<Employee> findByDateOfBirth(String dateOfBirth){
		
		Result<TbEmployeeRecord> result = context.selectFrom(TB_EMPLOYEE)
		 		  							   .where(TB_EMPLOYEE.DATE_OF_BIRTH.equal(dateOfBirth))
		 		  							   .orderBy(TB_EMPLOYEE.NAME)
		 		  							   .fetch();
		inflate(result);
		
		return employeeList;
	}
	
	public List<Employee> findByDistrict(String district){
		
		Result<TbEmployeeRecord> result = context.selectFrom(TB_EMPLOYEE)
		 		  							   .where(TB_EMPLOYEE.DISTRICT.equal(district))
		 		  							   .orderBy(TB_EMPLOYEE.NAME)
		 		  							   .fetch();
		inflate(result);
		
		return employeeList;
	}
	
	public Employee findById(int id){
		
		Result<TbEmployeeRecord> result = context.selectFrom(TB_EMPLOYEE)
		 		  							   .where(TB_EMPLOYEE.ID.equal(id))
		 		  							   .fetch();
		inflate(result);
		
		return employeeList.get(0);
	}
	
	public List<Employee> findByName(String name){
		
		Result<TbEmployeeRecord> result = context.selectFrom(TB_EMPLOYEE)
		 		  							   .where(TB_EMPLOYEE.NAME.like("%"+name+"%"))
		 		  							   .orderBy(TB_EMPLOYEE.NAME)
		 		  							   .fetch();
		inflate(result);
		
		return employeeList;
	}
	
	public List<Employee> findByState(String state){
		
		Result<TbEmployeeRecord> result = context.selectFrom(TB_EMPLOYEE)
		 		  							   .where(TB_EMPLOYEE.STATE.equal(state))
		 		  							   .orderBy(TB_EMPLOYEE.NAME)
		 		  							   .fetch();
		inflate(result);
		
		return employeeList;
	}
	
	public List<Employee> findByType(String type){
		
		Result<TbEmployeeRecord> result = context.selectFrom(TB_EMPLOYEE)
		 		  							   .where(TB_EMPLOYEE.TYPE.equal(type))
		 		  							   .orderBy(TB_EMPLOYEE.NAME)
		 		  							   .fetch();
		inflate(result);
		
		return employeeList;
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
			          .set(TB_EMPLOYEE.PASSWORD, employee.getPassword())
			          .set(TB_EMPLOYEE.DATE_OF_BIRTH, employee.getDateOfBirth())
			          .set(TB_EMPLOYEE.PHONE, employee.getPhone())
			          .set(TB_EMPLOYEE.CPF, employee.getCpf())
			          .set(TB_EMPLOYEE.USERNAME, employee.getUsername())
			          .set(TB_EMPLOYEE.PASSWORD, employee.getPassword())
			          .set(TB_EMPLOYEE.AGENCY, employee.getAgency())
			          .set(TB_EMPLOYEE.COUNT, employee.getCount())
			          .set(TB_EMPLOYEE.TYPE, employee.getType())
			          .set(TB_EMPLOYEE.EMAIL, employee.getEmail())
			          .where(TB_EMPLOYEE.ID.equal(employee.getId()))
			          .execute();
	}
}
