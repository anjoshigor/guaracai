/**
 * This class is generated by jOOQ
 */
package dao.tables;


import dao.Keys;
import dao.Public;
import dao.tables.records.ClientRecord;

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
public class Client extends TableImpl<ClientRecord> {

    private static final long serialVersionUID = -1428293070;

    /**
     * The reference instance of <code>public.client</code>
     */
    public static final Client CLIENT = new Client();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ClientRecord> getRecordType() {
        return ClientRecord.class;
    }

    /**
     * The column <code>public.client.id</code>.
     */
    public final TableField<ClientRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('client_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.client.name</code>.
     */
    public final TableField<ClientRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(70).nullable(false), this, "");

    /**
     * The column <code>public.client.date_of_birth</code>.
     */
    public final TableField<ClientRecord, String> DATE_OF_BIRTH = createField("date_of_birth", org.jooq.impl.SQLDataType.CHAR.length(8), this, "");

    /**
     * The column <code>public.client.phone</code>.
     */
    public final TableField<ClientRecord, String> PHONE = createField("phone", org.jooq.impl.SQLDataType.CHAR.length(11), this, "");

    /**
     * The column <code>public.client.amount_spent</code>.
     */
    public final TableField<ClientRecord, Float> AMOUNT_SPENT = createField("amount_spent", org.jooq.impl.SQLDataType.REAL, this, "");

    /**
     * The column <code>public.client.balance</code>.
     */
    public final TableField<ClientRecord, Float> BALANCE = createField("balance", org.jooq.impl.SQLDataType.REAL, this, "");

    /**
     * Create a <code>public.client</code> table reference
     */
    public Client() {
        this("client", null);
    }

    /**
     * Create an aliased <code>public.client</code> table reference
     */
    public Client(String alias) {
        this(alias, CLIENT);
    }

    private Client(String alias, Table<ClientRecord> aliased) {
        this(alias, aliased, null);
    }

    private Client(String alias, Table<ClientRecord> aliased, Field<?>[] parameters) {
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
    public Identity<ClientRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CLIENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ClientRecord> getPrimaryKey() {
        return Keys.CLIENT_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ClientRecord>> getKeys() {
        return Arrays.<UniqueKey<ClientRecord>>asList(Keys.CLIENT_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Client as(String alias) {
        return new Client(alias, this);
    }

    /**
     * Rename this table
     */
    public Client rename(String name) {
        return new Client(name, null);
    }
}