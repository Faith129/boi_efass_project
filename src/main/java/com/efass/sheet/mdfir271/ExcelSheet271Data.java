package com.efass.sheet.mdfir271;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExcelSheet271Data {

    public Integer id;

    public String bank_name;

    public String bank_code;


    public String account_number;


    public BigDecimal amount;

    public BigDecimal remarks;
}
