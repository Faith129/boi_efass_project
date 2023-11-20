package com.efass.sheet.mdfir333;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExcelSheet333Data {
    public Integer id;
    public String investee_name;
    public String type_of_investment;
    public String  investment_cert_number;
    public BigDecimal amount_invested;
    public BigDecimal fair_value_gains;
    public BigDecimal impairment;
    public BigDecimal carrying_value_unquoted_eq_inv;
}
