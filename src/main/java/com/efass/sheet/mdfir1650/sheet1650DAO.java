package com.efass.sheet.mdfir1650;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MDFIR1650")
public class sheet1650DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "CUSTOMER_CODE")
    public String customer_code;
    @Column(name = "CUSTOMER_NAME")
    public String customer_name;
    @Column(name = "ACCOUNT_NUMBER")
    public String account_number;
    @Column(name = "RELATIONSHIP_TO_INSTITUTION")
    public String  relationship_to_institution;
    @Column(name = "AMOUNT_GRANTED")
    public BigDecimal amount_granted;
    @Column(name = "DATE_GRANTED")
    public LocalDate date_granted;
    @Column(name = "EXPIRY_DATE")
    public LocalDate expiry_date;
    @Column(name = "TOTAL_OUTSTANDING_CREDIT")
    public BigDecimal total_outstanding_credit;
    @Column(name = "PERFORMING")
    public String performing;
    @Column(name = "NON_PERFORMING")
    public String non_performing;
    @Column(name = "RATE_OF_INTEREST")
    public BigDecimal rate_of_interest;
    @Column(name = "NATURE")
    public String nature;
    @Column(name = "VALUE")
    public BigDecimal value;
    @Column(name = "DATE_OF_VALUATION")
    public LocalDate date_of_valuation;
    @Column(name = "AMOUNT")
    public BigDecimal amount;
    @Column(name = "REMARKS")
    public BigDecimal remarks;
}
