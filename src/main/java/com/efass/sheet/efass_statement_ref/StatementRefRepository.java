package com.efass.sheet.efass_statement_ref;

import com.efass.sheet.efass_statement_item_ref.StatementItemRef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatementRefRepository extends JpaRepository<StatementRef, Integer> {
    StatementRef findByStatementCode(String statementCode);

}
