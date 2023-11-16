package com.efass.sheet.mdfir422;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;


@Entity
@Table(name = "MDFIR422")
public class sheet422DAO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

	@Column(name = "id")
	public Integer id;
    @Column(name = "ITEM_DESCRIPTION")
    public String description;
	@Column(name = "AMOUNT")
	public BigDecimal amount;

	public sheet422DAO() {
	}

	public sheet422DAO(Integer id,  String description,BigDecimal amount) {
		this.id = id;

		this.description = description;
        this.amount = amount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
