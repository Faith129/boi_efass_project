package com.efass.sheet.mdfir382;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExcelSheet382Data {
    public Integer id;

    public String customer_code;

    public String customer_name;

    public BigDecimal principal_granted;

    public String purpose;

    public LocalDate date_granted;

    public BigDecimal principal_outstanding;

    public BigDecimal interest_rate;

    public BigDecimal upfront_interest;

    public BigDecimal interest_payable;

    public LocalDate due_date;

    public BigDecimal unpaid_principal_interest;

    public String times_rolled_over;

    public String coll_or_value;
}
