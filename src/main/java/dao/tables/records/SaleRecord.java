/**
 * This class is generated by jOOQ
 */
package dao.tables.records;


import dao.tables.Sale;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


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
public class SaleRecord extends UpdatableRecordImpl<SaleRecord> implements Record7<Integer, String, String, Float, Float, Integer, Integer> {

    private static final long serialVersionUID = -1069863462;

    /**
     * Setter for <code>public.sale.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.sale.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.sale.date</code>.
     */
    public void setDate(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.sale.date</code>.
     */
    public String getDate() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.sale.observation</code>.
     */
    public void setObservation(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.sale.observation</code>.
     */
    public String getObservation() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.sale.total</code>.
     */
    public void setTotal(Float value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.sale.total</code>.
     */
    public Float getTotal() {
        return (Float) get(3);
    }

    /**
     * Setter for <code>public.sale.discount</code>.
     */
    public void setDiscount(Float value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.sale.discount</code>.
     */
    public Float getDiscount() {
        return (Float) get(4);
    }

    /**
     * Setter for <code>public.sale.client_id</code>.
     */
    public void setClientId(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.sale.client_id</code>.
     */
    public Integer getClientId() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>public.sale.employee_id</code>.
     */
    public void setEmployeeId(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.sale.employee_id</code>.
     */
    public Integer getEmployeeId() {
        return (Integer) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, String, String, Float, Float, Integer, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, String, String, Float, Float, Integer, Integer> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Sale.SALE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Sale.SALE.DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Sale.SALE.OBSERVATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Float> field4() {
        return Sale.SALE.TOTAL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Float> field5() {
        return Sale.SALE.DISCOUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return Sale.SALE.CLIENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return Sale.SALE.EMPLOYEE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getObservation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Float value4() {
        return getTotal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Float value5() {
        return getDiscount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getClientId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getEmployeeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SaleRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SaleRecord value2(String value) {
        setDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SaleRecord value3(String value) {
        setObservation(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SaleRecord value4(Float value) {
        setTotal(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SaleRecord value5(Float value) {
        setDiscount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SaleRecord value6(Integer value) {
        setClientId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SaleRecord value7(Integer value) {
        setEmployeeId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SaleRecord values(Integer value1, String value2, String value3, Float value4, Float value5, Integer value6, Integer value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SaleRecord
     */
    public SaleRecord() {
        super(Sale.SALE);
    }

    /**
     * Create a detached, initialised SaleRecord
     */
    public SaleRecord(Integer id, String date, String observation, Float total, Float discount, Integer clientId, Integer employeeId) {
        super(Sale.SALE);

        set(0, id);
        set(1, date);
        set(2, observation);
        set(3, total);
        set(4, discount);
        set(5, clientId);
        set(6, employeeId);
    }
}