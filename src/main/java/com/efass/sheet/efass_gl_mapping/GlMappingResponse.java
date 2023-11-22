package com.efass.sheet.efass_gl_mapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GlMappingResponse {
    private Integer id;
    private String statementCode;
    private String statementDesc;
    private String itemCode;
    private String itemDesc;
    private String category;
    private String ledgerNo;

}
