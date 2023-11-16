package com.efass.sheet.mdfir292_3;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "QDFIR292_3")
public class sheetQdfir292_3DAO {
    @Id
    @Column(name = "id")
    public Integer id;
    @Column(name = "CARRYING_VALUE")
    public BigDecimal carrying_value;
    @Column(name = "DERIVATIVE_FINANCIAL_LIABILITIES")
    public String derivative_financial_liabilities;
    @Column(name = "NOTIONAL_AMOUNT  ")
    public BigDecimal notional_amount;

    public sheetQdfir292_3DAO() {
    }

    public sheetQdfir292_3DAO(Integer id, BigDecimal carrying_value, String derivative_financial_liabilities, BigDecimal notional_amount) {
        this.id = id;
        this.carrying_value = carrying_value;
        this.derivative_financial_liabilities = derivative_financial_liabilities;
        this.notional_amount = notional_amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getCarrying_value() {
        return carrying_value;
    }

    public void setCarrying_value(BigDecimal carrying_value) {
        this.carrying_value = carrying_value;
    }

    public String getDerivative_financial_liabilities() {
        return derivative_financial_liabilities;
    }

    public void setDerivative_financial_liabilities(String derivative_financial_liabilities) {
        this.derivative_financial_liabilities = derivative_financial_liabilities;
    }

    public BigDecimal getNotional_amount() {
        return notional_amount;
    }

    public void setNotional_amount(BigDecimal notional_amount) {
        this.notional_amount = notional_amount;
    }
}
