package com.efass.sheet.mmfbr762;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMFBR762")
public class sheet762DAO {

	  @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		public int id;
	  
	  
		@Column(name = "SECTOR")
	  	public String sector;
		
		

		@Column(name = "NO_OF_LOANS")
	  	public String noOfLoans;
	  

		@Column(name = "AMOUNT_GRANTED")
	  	public String amountGranted;
		
		

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getSector() {
			return sector;
		}

		public void setSector(String sector) {
			this.sector = sector;
		}

		public String getNoOfLoans() {
			return noOfLoans;
		}

		public void setNoOfLoans(String noOfLoans) {
			this.noOfLoans = noOfLoans;
		}

		public String getAmountGranted() {
			return amountGranted;
		}

		public void setAmountGranted(String amountGranted) {
			this.amountGranted = amountGranted;
		}

	
		
		
		
		
		
	  
}
