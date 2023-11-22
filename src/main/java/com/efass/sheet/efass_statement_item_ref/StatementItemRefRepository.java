package com.efass.sheet.efass_statement_item_ref;

import com.efass.sheet.efass_statement_ref.StatementRef;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StatementItemRefRepository extends JpaRepository<StatementItemRef,Integer> {
    StatementItemRef findByStatementCode(String statementCode);

    StatementRef findByItemCode(String itemCode);


    void deleteByStatementCode(String statementCode);

    void deleteByItemCode(String itemCode);

    Optional<StatementRef> findByItemCodeAndStatementCode(String itemCode, String statementCode);
}
