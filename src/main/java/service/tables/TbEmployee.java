/**
 * This class is generated by jOOQ
 */
package service.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;

import service.Keys;
import service.Public;
import service.tables.records.TbEmployeeRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbEmployee extends TableImpl<TbEmployeeRecord> {

    private static final long serialVersionUID = -1036299655;

    /**
     * The reference instance of <code>public.tb_employee</code>
     */
    public static final TbEmployee TB_EMPLOYEE = new TbEmployee();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TbEmployeeRecord> getRecordType() {
        return TbEmployeeRecord.class;
    }

    /**
     * The column <code>public.tb_employee.id</code>.
     */
    public final TableField<TbEmployeeRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('employee_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.tb_employee.name</code>.
     */
    public final TableField<TbEmployeeRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(70).nullable(false), this, "");

    /**
     * The column <code>public.tb_employee.data_of_birth</code>.
     */
    public final TableField<TbEmployeeRecord, String> DATA_OF_BIRTH = createField("data_of_birth", org.jooq.impl.SQLDataType.CHAR.length(10).nullable(false), this, "");

    /**
     * The column <code>public.tb_employee.phone</code>.
     */
    public final TableField<TbEmployeeRecord, String> PHONE = createField("phone", org.jooq.impl.SQLDataType.CHAR.length(13).nullable(false), this, "");

    /**
     * The column <code>public.tb_employee.email</code>.
     */
    public final TableField<TbEmployeeRecord, String> EMAIL = createField("email", org.jooq.impl.SQLDataType.VARCHAR.length(60), this, "");

    /**
     * The column <code>public.tb_employee.cpf</code>.
     */
    public final TableField<TbEmployeeRecord, String> CPF = createField("cpf", org.jooq.impl.SQLDataType.CHAR.length(14).nullable(false), this, "");

    /**
     * The column <code>public.tb_employee.username</code>.
     */
    public final TableField<TbEmployeeRecord, String> USERNAME = createField("username", org.jooq.impl.SQLDataType.VARCHAR.length(15).nullable(false), this, "");

    /**
     * The column <code>public.tb_employee.password</code>.
     */
    public final TableField<TbEmployeeRecord, String> PASSWORD = createField("password", org.jooq.impl.SQLDataType.VARCHAR.length(10).nullable(false), this, "");

    /**
     * The column <code>public.tb_employee.type</code>.
     */
    public final TableField<TbEmployeeRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR.length(20).nullable(false), this, "");

    /**
     * The column <code>public.tb_employee.agency</code>.
     */
    public final TableField<TbEmployeeRecord, String> AGENCY = createField("agency", org.jooq.impl.SQLDataType.VARCHAR.length(8), this, "");

    /**
     * The column <code>public.tb_employee.count</code>.
     */
    public final TableField<TbEmployeeRecord, String> COUNT = createField("count", org.jooq.impl.SQLDataType.VARCHAR.length(12), this, "");

    /**
     * The column <code>public.tb_employee.complement</code>.
     */
    public final TableField<TbEmployeeRecord, String> COMPLEMENT = createField("complement", org.jooq.impl.SQLDataType.VARCHAR.length(10), this, "");

    /**
     * The column <code>public.tb_employee.number</code>.
     */
    public final TableField<TbEmployeeRecord, Integer> NUMBER = createField("number", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.tb_employee.city</code>.
     */
    public final TableField<TbEmployeeRecord, String> CITY = createField("city", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>public.tb_employee.street</code>.
     */
    public final TableField<TbEmployeeRecord, String> STREET = createField("street", org.jooq.impl.SQLDataType.VARCHAR.length(60).nullable(false), this, "");

    /**
     * The column <code>public.tb_employee.district</code>.
     */
    public final TableField<TbEmployeeRecord, String> DISTRICT = createField("district", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>public.tb_employee.state</code>.
     */
    public final TableField<TbEmployeeRecord, String> STATE = createField("state", org.jooq.impl.SQLDataType.CHAR.length(2).nullable(false), this, "");

    /**
     * Create a <code>public.tb_employee</code> table reference
     */
    public TbEmployee() {
        this("tb_employee", null);
    }

    /**
     * Create an aliased <code>public.tb_employee</code> table reference
     */
    public TbEmployee(String alias) {
        this(alias, TB_EMPLOYEE);
    }

    private TbEmployee(String alias, Table<TbEmployeeRecord> aliased) {
        this(alias, aliased, null);
    }

    private TbEmployee(String alias, Table<TbEmployeeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<TbEmployeeRecord, Integer> getIdentity() {
        return Keys.IDENTITY_TB_EMPLOYEE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TbEmployeeRecord> getPrimaryKey() {
        return Keys.EMPLOYEE_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TbEmployeeRecord>> getKeys() {
        return Arrays.<UniqueKey<TbEmployeeRecord>>asList(Keys.EMPLOYEE_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TbEmployee as(String alias) {
        return new TbEmployee(alias, this);
    }

    /**
     * Rename this table
     */
    public TbEmployee rename(String name) {
        return new TbEmployee(name, null);
    }
}
