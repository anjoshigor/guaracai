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
import service.tables.records.TbGoodsRecord;


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
public class TbGoods extends TableImpl<TbGoodsRecord> {

    private static final long serialVersionUID = 1276386681;

    /**
     * The reference instance of <code>public.tb_goods</code>
     */
    public static final TbGoods TB_GOODS = new TbGoods();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TbGoodsRecord> getRecordType() {
        return TbGoodsRecord.class;
    }

    /**
     * The column <code>public.tb_goods.id</code>.
     */
    public final TableField<TbGoodsRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('produto_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.tb_goods.code</code>.
     */
    public final TableField<TbGoodsRecord, Integer> CODE = createField("code", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.tb_goods.price</code>.
     */
    public final TableField<TbGoodsRecord, Float> PRICE = createField("price", org.jooq.impl.SQLDataType.REAL.nullable(false), this, "");

    /**
     * The column <code>public.tb_goods.name</code>.
     */
    public final TableField<TbGoodsRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>public.tb_goods.description</code>.
     */
    public final TableField<TbGoodsRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR.length(100), this, "");

    /**
     * The column <code>public.tb_goods.size</code>.
     */
    public final TableField<TbGoodsRecord, Integer> SIZE = createField("size", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.tb_goods.category_id</code>.
     */
    public final TableField<TbGoodsRecord, Integer> CATEGORY_ID = createField("category_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>public.tb_goods</code> table reference
     */
    public TbGoods() {
        this("tb_goods", null);
    }

    /**
     * Create an aliased <code>public.tb_goods</code> table reference
     */
    public TbGoods(String alias) {
        this(alias, TB_GOODS);
    }

    private TbGoods(String alias, Table<TbGoodsRecord> aliased) {
        this(alias, aliased, null);
    }

    private TbGoods(String alias, Table<TbGoodsRecord> aliased, Field<?>[] parameters) {
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
    public Identity<TbGoodsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_TB_GOODS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TbGoodsRecord> getPrimaryKey() {
        return Keys.GOODS_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TbGoodsRecord>> getKeys() {
        return Arrays.<UniqueKey<TbGoodsRecord>>asList(Keys.GOODS_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<TbGoodsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<TbGoodsRecord, ?>>asList(Keys.TB_GOODS__GOODS_CATEGORY_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TbGoods as(String alias) {
        return new TbGoods(alias, this);
    }

    /**
     * Rename this table
     */
    public TbGoods rename(String name) {
        return new TbGoods(name, null);
    }
}
