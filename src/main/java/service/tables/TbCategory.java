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
import service.tables.records.TbCategoryRecord;


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
public class TbCategory extends TableImpl<TbCategoryRecord> {

    private static final long serialVersionUID = -410672807;

    /**
     * The reference instance of <code>public.tb_category</code>
     */
    public static final TbCategory TB_CATEGORY = new TbCategory();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TbCategoryRecord> getRecordType() {
        return TbCategoryRecord.class;
    }

    /**
     * The column <code>public.tb_category.id</code>.
     */
    public final TableField<TbCategoryRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('category_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.tb_category.name</code>.
     */
    public final TableField<TbCategoryRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>public.tb_category.description</code>.
     */
    public final TableField<TbCategoryRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR.length(100), this, "");

    /**
     * Create a <code>public.tb_category</code> table reference
     */
    public TbCategory() {
        this("tb_category", null);
    }

    /**
     * Create an aliased <code>public.tb_category</code> table reference
     */
    public TbCategory(String alias) {
        this(alias, TB_CATEGORY);
    }

    private TbCategory(String alias, Table<TbCategoryRecord> aliased) {
        this(alias, aliased, null);
    }

    private TbCategory(String alias, Table<TbCategoryRecord> aliased, Field<?>[] parameters) {
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
    public Identity<TbCategoryRecord, Integer> getIdentity() {
        return Keys.IDENTITY_TB_CATEGORY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TbCategoryRecord> getPrimaryKey() {
        return Keys.CATEGORY_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TbCategoryRecord>> getKeys() {
        return Arrays.<UniqueKey<TbCategoryRecord>>asList(Keys.CATEGORY_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TbCategory as(String alias) {
        return new TbCategory(alias, this);
    }

    /**
     * Rename this table
     */
    public TbCategory rename(String name) {
        return new TbCategory(name, null);
    }
}