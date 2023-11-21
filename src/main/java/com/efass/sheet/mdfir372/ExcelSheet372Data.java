package com.efass.sheet.mdfir372;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExcelSheet372Data {
    public Integer id;

    public String customer_code;

    public String customer_name;

    public BigDecimal principal_granted;

    public String purpose;

    public LocalDate date_granted;

    public LocalDate due_date;

    public BigDecimal principal_outstanding;

    public BigDecimal interest_rate;

    public BigDecimal upfront_interest;

    public BigDecimal interest_payable;

    public BigDecimal unpaid_principal_interest;

    public BigDecimal times_rolled_over;

    public BigDecimal coll_or_value;
}