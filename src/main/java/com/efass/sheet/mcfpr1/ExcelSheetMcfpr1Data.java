package com.efass.sheet.mcfpr1;

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
public class ExcelSheetMcfpr1Data {
    public Integer id;

    public String address;

    public BigDecimal amount_claimed_1;

    public BigDecimal amount_claimed_2;

    public BigDecimal amount_refunded_1;

    public BigDecimal amount_refunded_2;

    public String category;

    public String complaint_ref_number;

    public LocalDate date_received;

    public LocalDate date_resolved;

    public String major_areas_of_disagreement;

    public String name_of_petitioner;

    public String resolution_efforts_made;

    public String subject;
}
