package com.efass.sheet.mmfbr746;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMFBR746")
public class sheet746DAO {
	
	
	  

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		public int id;
		
		
		@Column(name = "NAME_OF_BENE")
		public String nameOfBen;
		
		@Column(name = "DATE_GRANTED")
		public String dateGranted;
		
		@Column(name = "TENOR")
		public String tenor;
		
		
		@Column(name = "AMOUNT_APPROVED")
		public String amountApproved;
		
		
		@Column(name = "OUTSTAND_BAL")
		public String outstandingBalance;
		
		@Column(name = "STATUS")
		public String status;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNameOfBen() {
			return nameOfBen;
		}

		public void setNameOfBen(String nameOfBen) {
			this.nameOfBen = nameOfBen;
		}

		public String getDateGranted() {
			return dateGranted;
		}

		public void setDateGranted(String dateGranted) {
			this.dateGranted = dateGranted;
		}

		public String getTenor() {
			return tenor;
		}

		public void setTenor(String tenor) {
			this.tenor = tenor;
		}

		public String getAmountApproved() {
			return amountApproved;
		}

		public void setAmountApproved(String amountApproved) {
			this.amountApproved = amountApproved;
		}

		public String getOutstandingBalance() {
			return outstandingBalance;
		}

		public void setOutstandingBalance(String outstandingBalance) {
			this.outstandingBalance = outstandingBalance;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		
		
		
		
		

}
