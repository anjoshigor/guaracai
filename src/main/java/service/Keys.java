/**
 * This class is generated by jOOQ
 */
package service;


import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;

import service.tables.TbCategory;
import service.tables.TbClient;
import service.tables.TbEmployee;
import service.tables.TbExpenses;
import service.tables.TbGoods;
import service.tables.TbSale;
import service.tables.records.TbCategoryRecord;
import service.tables.records.TbClientRecord;
import service.tables.records.TbEmployeeRecord;
import service.tables.records.TbExpensesRecord;
import service.tables.records.TbGoodsRecord;
import service.tables.records.TbSaleRecord;


/**
 * A class modelling foreign key relationships between tables of the <code>public</code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<TbCategoryRecord, Integer> IDENTITY_TB_CATEGORY = Identities0.IDENTITY_TB_CATEGORY;
    public static final Identity<TbClientRecord, Integer> IDENTITY_TB_CLIENT = Identities0.IDENTITY_TB_CLIENT;
    public static final Identity<TbEmployeeRecord, Integer> IDENTITY_TB_EMPLOYEE = Identities0.IDENTITY_TB_EMPLOYEE;
    public static final Identity<TbExpensesRecord, Integer> IDENTITY_TB_EXPENSES = Identities0.IDENTITY_TB_EXPENSES;
    public static final Identity<TbGoodsRecord, Integer> IDENTITY_TB_GOODS = Identities0.IDENTITY_TB_GOODS;
    public static final Identity<TbSaleRecord, Integer> IDENTITY_TB_SALE = Identities0.IDENTITY_TB_SALE;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<TbCategoryRecord> CATEGORY_PKEY = UniqueKeys0.CATEGORY_PKEY;
    public static final UniqueKey<TbCategoryRecord> TB_CATEGORY_NAME_KEY = UniqueKeys0.TB_CATEGORY_NAME_KEY;
    public static final UniqueKey<TbClientRecord> CLIENT_PKEY = UniqueKeys0.CLIENT_PKEY;
    public static final UniqueKey<TbEmployeeRecord> EMPLOYEE_PKEY = UniqueKeys0.EMPLOYEE_PKEY;
    public static final UniqueKey<TbEmployeeRecord> TB_EMPLOYEE_CPF_KEY = UniqueKeys0.TB_EMPLOYEE_CPF_KEY;
    public static final UniqueKey<TbEmployeeRecord> TB_EMPLOYEE_USERNAME_KEY = UniqueKeys0.TB_EMPLOYEE_USERNAME_KEY;
    public static final UniqueKey<TbExpensesRecord> EXPENSES_PKEY = UniqueKeys0.EXPENSES_PKEY;
    public static final UniqueKey<TbGoodsRecord> GOODS_PKEY = UniqueKeys0.GOODS_PKEY;
    public static final UniqueKey<TbSaleRecord> SALE_PKEY = UniqueKeys0.SALE_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<TbExpensesRecord, TbEmployeeRecord> TB_EXPENSES__EXPENSES_EMPLOYEE_ID_FKEY = ForeignKeys0.TB_EXPENSES__EXPENSES_EMPLOYEE_ID_FKEY;
    public static final ForeignKey<TbGoodsRecord, TbCategoryRecord> TB_GOODS__GOODS_CATEGORY_ID_FKEY = ForeignKeys0.TB_GOODS__GOODS_CATEGORY_ID_FKEY;
    public static final ForeignKey<TbSaleRecord, TbEmployeeRecord> TB_SALE__SALE_EMPLOYEE_ID_FKEY = ForeignKeys0.TB_SALE__SALE_EMPLOYEE_ID_FKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<TbCategoryRecord, Integer> IDENTITY_TB_CATEGORY = createIdentity(TbCategory.TB_CATEGORY, TbCategory.TB_CATEGORY.ID);
        public static Identity<TbClientRecord, Integer> IDENTITY_TB_CLIENT = createIdentity(TbClient.TB_CLIENT, TbClient.TB_CLIENT.ID);
        public static Identity<TbEmployeeRecord, Integer> IDENTITY_TB_EMPLOYEE = createIdentity(TbEmployee.TB_EMPLOYEE, TbEmployee.TB_EMPLOYEE.ID);
        public static Identity<TbExpensesRecord, Integer> IDENTITY_TB_EXPENSES = createIdentity(TbExpenses.TB_EXPENSES, TbExpenses.TB_EXPENSES.ID);
        public static Identity<TbGoodsRecord, Integer> IDENTITY_TB_GOODS = createIdentity(TbGoods.TB_GOODS, TbGoods.TB_GOODS.ID);
        public static Identity<TbSaleRecord, Integer> IDENTITY_TB_SALE = createIdentity(TbSale.TB_SALE, TbSale.TB_SALE.ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<TbCategoryRecord> CATEGORY_PKEY = createUniqueKey(TbCategory.TB_CATEGORY, "category_pkey", TbCategory.TB_CATEGORY.ID);
        public static final UniqueKey<TbCategoryRecord> TB_CATEGORY_NAME_KEY = createUniqueKey(TbCategory.TB_CATEGORY, "tb_category_name_key", TbCategory.TB_CATEGORY.NAME);
        public static final UniqueKey<TbClientRecord> CLIENT_PKEY = createUniqueKey(TbClient.TB_CLIENT, "client_pkey", TbClient.TB_CLIENT.ID);
        public static final UniqueKey<TbEmployeeRecord> EMPLOYEE_PKEY = createUniqueKey(TbEmployee.TB_EMPLOYEE, "employee_pkey", TbEmployee.TB_EMPLOYEE.ID);
        public static final UniqueKey<TbEmployeeRecord> TB_EMPLOYEE_CPF_KEY = createUniqueKey(TbEmployee.TB_EMPLOYEE, "tb_employee_cpf_key", TbEmployee.TB_EMPLOYEE.CPF);
        public static final UniqueKey<TbEmployeeRecord> TB_EMPLOYEE_USERNAME_KEY = createUniqueKey(TbEmployee.TB_EMPLOYEE, "tb_employee_username_key", TbEmployee.TB_EMPLOYEE.USERNAME);
        public static final UniqueKey<TbExpensesRecord> EXPENSES_PKEY = createUniqueKey(TbExpenses.TB_EXPENSES, "expenses_pkey", TbExpenses.TB_EXPENSES.ID);
        public static final UniqueKey<TbGoodsRecord> GOODS_PKEY = createUniqueKey(TbGoods.TB_GOODS, "goods_pkey", TbGoods.TB_GOODS.ID);
        public static final UniqueKey<TbSaleRecord> SALE_PKEY = createUniqueKey(TbSale.TB_SALE, "sale_pkey", TbSale.TB_SALE.ID);
    }

    private static class ForeignKeys0 extends AbstractKeys {
        public static final ForeignKey<TbExpensesRecord, TbEmployeeRecord> TB_EXPENSES__EXPENSES_EMPLOYEE_ID_FKEY = createForeignKey(service.Keys.EMPLOYEE_PKEY, TbExpenses.TB_EXPENSES, "tb_expenses__expenses_employee_id_fkey", TbExpenses.TB_EXPENSES.EMPLOYEE_ID);
        public static final ForeignKey<TbGoodsRecord, TbCategoryRecord> TB_GOODS__GOODS_CATEGORY_ID_FKEY = createForeignKey(service.Keys.CATEGORY_PKEY, TbGoods.TB_GOODS, "tb_goods__goods_category_id_fkey", TbGoods.TB_GOODS.CATEGORY_ID);
        public static final ForeignKey<TbSaleRecord, TbEmployeeRecord> TB_SALE__SALE_EMPLOYEE_ID_FKEY = createForeignKey(service.Keys.EMPLOYEE_PKEY, TbSale.TB_SALE, "tb_sale__sale_employee_id_fkey", TbSale.TB_SALE.EMPLOYEE_ID);
    }
}
