package com.efass.sheet.efass_gl_mapping;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "EFASS_GL_MAPPING")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EfassGlMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer id;
    @Column(name = "STATEMENT_CODE")
    private String statementCode;
    @Column(name = "STATEMENT_DESCRIPTION")
    private String statementDesc;
    @Column(name = "ITEM_CODE")
    private String itemCode;
    @Column(name = "ITEM_DESCRIPTION")
    private String itemDesc;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "LEDGER_NO")
    private String ledgerNo;
}

