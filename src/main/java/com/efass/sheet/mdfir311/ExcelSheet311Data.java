package com.efass.sheet.mdfir311;

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
public class ExcelSheet311Data {
    public Integer id;
    public String bankName;
    public String bankCode;
    public String type_of_placements;
    public String account_number;
    public BigDecimal amount;
    public BigDecimal amount_2;
    public String tenor;
    public LocalDate effective_date;
    public LocalDate maturity_date;
    public BigDecimal interest_rate;
    public BigDecimal upfront_interest_received;
    public BigDecimal accrued_interest_receivable;
    public BigDecimal times_rolled_over;
    public String remarks;
}
