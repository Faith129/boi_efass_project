package com.efass.sheet.efass_statement_ref;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "EFASS_STATEMENT_REF")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatementRef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer id;
    @Column(name = "STATEMENT_CODE")
    private String statementCode;
    @Column(name = "STATEMENT_DESCRIPTION")
    private String statementDesc;
    @Column(name = "CREATE_DT")
    private LocalDate created_dt;

}
