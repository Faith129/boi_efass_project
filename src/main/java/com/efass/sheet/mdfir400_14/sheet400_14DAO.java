package com.efass.sheet.mdfir400_14;

import lombok.Data;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "MDFIR400_14")
public class sheet400_14DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "ACCRUED_INTEREST_PAYABLE")
    public BigDecimal accrued_interest_payable;
    @Column(name = "AMOUNT_INVESTED")
    public BigDecimal amount_invested;
    @Column(name = "IMPAIRMENT")
    public BigDecimal impairment;
    @Column(name = "INTEREST_RATE")
    public BigDecimal  interest_rate;
    @Column(name = "INVESTED_CERTIFICATE_NUMBER")
    public BigDecimal invested_certificate_number ;
    @Column(name = "EFFECTIVE_DATE")
    public LocalDate effective_date ;
    @Column(name = "MATURITY_DATE")
    public LocalDate maturity_date ;

    @Column(name = "PRINCIPAL_PAYABLE")
    public BigDecimal principal_payable;
    @Column(name = "TENOR")
    public BigDecimal  tenor;
    @Column(name = "TIMES_ROLLED_OVER")
    public BigDecimal times_rolled_over ;

    @Column(name = "TYPES")
    public String type ;
    @Column(name = "UPFRONT_INTEREST_PAID")
    public BigDecimal upfront_interest_paid ;

    public sheet400_14DAO() {
    }
}
