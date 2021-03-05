
package com.efass.sheet.mmfbr300;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "MMFBR300")
public class sheet300DAO {

	
	  
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		public int id;
		
		
		
	

		@Column(name = "CODE")
		public String code;
		
		
		@Column(name = "DESCRIPTION")
		public String itemDescription;
		
		
		@Column(name = "AMOUNT_1")
		public String amount1;

	
		
		@Column(name = "AMOUNT_2")
		public String amount2;
		
		
		@Column(name = "AMOUNT_3")
		public String amount3;
		
		
		
		
		
		public String getCode() {
			return code;
		}


		public void setCode(String code) {
			this.code = code;
		}

		
		
		
		
		public String getItemDescription() {
			return itemDescription;
		}


		public void setItemDescription(String itemDescription) {
			this.itemDescription = itemDescription;
		}




		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getAmount1() {
			return amount1;
		}


		public void setAmount1(String amount1) {
			this.amount1 = amount1;
		}


		public String getAmount2() {
			return amount2;
		}


		public void setAmount2(String amount2) {
			this.amount2 = amount2;
		}


		public String getAmount3() {
			return amount3;
		}


		public void setAmount3(String amount3) {
			this.amount3 = amount3;
		}	
		
		
}

