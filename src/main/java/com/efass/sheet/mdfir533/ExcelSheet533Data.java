package com.efass.sheet.mdfir533;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExcelSheet533Data {
    public Integer id;
    public String code;
    public String description;
    public BigDecimal gross_amount;
    public BigDecimal  additions;
    public BigDecimal accumulated_depreciation ;
    public BigDecimal impairment ;
}
