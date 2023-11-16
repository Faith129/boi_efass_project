package com.efass.sheet.mmfbr141;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMFBR141")
public class sheet141DAO {

	
	  
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		public int id;
		
		
		@Column(name = "DEPOSIT_TYPE")
		public String typeOfDeposit;
		
		
		@Column(name = "TOTAL")
		public String total;


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getTypeOfDeposit() {
			return typeOfDeposit;
		}


		public void setTypeOfDeposit(String typeOfDeposit) {
			this.typeOfDeposit = typeOfDeposit;
		}


		public String getTotal() {
			return total;
		}


		public void setTotal(String total) {
			this.total = total;
		}
		
		
}
