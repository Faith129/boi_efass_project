package com.efass.sheet.mdfir371_3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExcelSheet371_3Data {
    public Integer id;
    public BigDecimal carrying_value;
    public String derivative_financial_assets;
    public BigDecimal notional_amount;
}
