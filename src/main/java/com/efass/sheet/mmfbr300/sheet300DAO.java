package com.efass.sheet.mmfbr300;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "MMFBR300")

public class sheet300DAO implements Serializable{


	
	  
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		public int id;
		

		@Column(name = "CODE")
		public String code;
		
		
		@Column(name = "DESCRIPTION")
		public String description;

		
		
		@Column(name = "AMOUNT_1")
		public String col_1;

	
		
		@Column(name = "AMOUNT_2")
		public String col_2;
		
		
		@Column(name = "AMOUNT_3")
		public String col_3;
		

		public sheet300DAO() {

		}
		
		public sheet300DAO(int id, String code, String description, String col_1, String col_2, String col_3) {
			super();
			this.id = id;
			this.code = code;
			this.description = description;
			this.col_1 = col_1;
			this.col_2 = col_2;
			this.col_3 = col_3;
		}

		
		
		public String getCode() {
			return code;
		}


		public void setCode(String code) {
			this.code = code;
		}

		
		
		
		
		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}




		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getCol_1() {
			return col_1;
		}


		public void setCol_1(String col_1) {
			this.col_1 = col_1;
		}


		public String getCol_2() {
			return col_2;
		}


		public void setCol_2(String col_2) {
			this.col_2 = col_2;
		}


		public String getCol_3() {
			return col_3;
		}


		public void setCol_3(String col_3) {
			this.col_3 = col_3;
		}	
		
		
}

