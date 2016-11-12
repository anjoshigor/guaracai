/**
 * This class is generated by jOOQ
 */
package service.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;

import service.Keys;
import service.Public;
import service.tables.records.TbSaleRecord;


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
public class TbSale extends TableImpl<TbSaleRecord> {

    private static final long serialVersionUID = -584614760;

    /**
     * The reference instance of <code>public.tb_sale</code>
     */
    public static final TbSale TB_SALE = new TbSale();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TbSaleRecord> getRecordType() {
        return TbSaleRecord.class;
    }

    /**
     * The column <code>public.tb_sale.id</code>.
     */
    public final TableField<TbSaleRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('sale_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.tb_sale.date</code>.
     */
    public final TableField<TbSaleRecord, String> DATE = createField("date", org.jooq.impl.SQLDataType.CHAR.length(10).nullable(false), this, "");

    /**
     * The column <code>public.tb_sale.observation</code>.
     */
    public final TableField<TbSaleRecord, String> OBSERVATION = createField("observation", org.jooq.impl.SQLDataType.VARCHAR.length(100), this, "");

    /**
     * The column <code>public.tb_sale.total</code>.
     */
    public final TableField<TbSaleRecord, Float> TOTAL = createField("total", org.jooq.impl.SQLDataType.REAL.nullable(false), this, "");

    /**
     * The column <code>public.tb_sale.discount</code>.
     */
    public final TableField<TbSaleRecord, Float> DISCOUNT = createField("discount", org.jooq.impl.SQLDataType.REAL.nullable(false), this, "");

    /**
     * The column <code>public.tb_sale.client_id</code>.
     */
    public final TableField<TbSaleRecord, Integer> CLIENT_ID = createField("client_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.tb_sale.employee_id</code>.
     */
    public final TableField<TbSaleRecord, Integer> EMPLOYEE_ID = createField("employee_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>public.tb_sale</code> table reference
     */
    public TbSale() {
        this("tb_sale", null);
    }

    /**
     * Create an aliased <code>public.tb_sale</code> table reference
     */
    public TbSale(String alias) {
        this(alias, TB_SALE);
    }

    private TbSale(String alias, Table<TbSaleRecord> aliased) {
        this(alias, aliased, null);
    }

    private TbSale(String alias, Table<TbSaleRecord> aliased, Field<?>[] parameters) {
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
    public Identity<TbSaleRecord, Integer> getIdentity() {
        return Keys.IDENTITY_TB_SALE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TbSaleRecord> getPrimaryKey() {
        return Keys.SALE_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TbSaleRecord>> getKeys() {
        return Arrays.<UniqueKey<TbSaleRecord>>asList(Keys.SALE_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<TbSaleRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<TbSaleRecord, ?>>asList(Keys.TB_SALE__SALE_EMPLOYEE_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TbSale as(String alias) {
        return new TbSale(alias, this);
    }

    /**
     * Rename this table
     */
    public TbSale rename(String name) {
        return new TbSale(name, null);
    }
}
