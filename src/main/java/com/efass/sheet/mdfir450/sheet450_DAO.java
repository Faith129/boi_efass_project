package com.efass.sheet.mdfir450;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;


@Entity
@Table(name = "MDFIR450")
public class sheet450_DAO {
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    @Column(name = "id")
//    public Integer id;
//    @Column(name = "ACCRUED_INTEREST_PAYABLE")
//    public BigDecimal accrued_interest_payable;
//    @Column(name = "AMOUNT_INVESTED")
//    public BigDecimal amount_invested;
//    @Column(name = "IMPAIRMENT")
//    public BigDecimal impairment;
//    @Column(name = "INTEREST_RATE")
//    public BigDecimal  interest_rate;
//    @Column(name = "INVESTED_CERTIFICATE_NUMBER")
//    public BigDecimal invested_certificate_number ;
//    @Column(name = "EFFECTIVE_DATE")
//    public LocalDate effective_date ;
//    @Column(name = "MATURITY_DATE")
//    public LocalDate maturity_date ;
//
//    @Column(name = "PRINCIPAL_PAYABLE")
//    public BigDecimal principal_payable;
//    @Column(name = "TENOR")
//    public BigDecimal  tenor;
//    @Column(name = "TIMES_ROLLED_OVER")
//    public BigDecimal times_rolled_over ;
//
//    @Column(name = "TYPES")
//    public String type ;
//    @Column(name = "UPFRONT_INTEREST_PAID")
//    public BigDecimal upfront_interest_paid ;
//
//
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public BigDecimal getAccrued_interest_payable() {
//		return accrued_interest_payable;
//	}
//	public void setAccrued_interest_payable(BigDecimal accrued_interest_payable) {
//		this.accrued_interest_payable = accrued_interest_payable;
//	}
//	public BigDecimal getAmount_invested() {
//		return amount_invested;
//	}
//	public void setAmount_invested(BigDecimal amount_invested) {
//		this.amount_invested = amount_invested;
//	}
//	public BigDecimal getImpairment() {
//		return impairment;
//	}
//	public void setImpairment(BigDecimal impairment) {
//		this.impairment = impairment;
//	}
//	public BigDecimal getInterest_rate() {
//		return interest_rate;
//	}
//	public void setInterest_rate(BigDecimal interest_rate) {
//		this.interest_rate = interest_rate;
//	}
//	public BigDecimal getInvested_certificate_number() {
//		return invested_certificate_number;
//	}
//	public void setInvested_certificate_number(BigDecimal invested_certificate_number) {
//		this.invested_certificate_number = invested_certificate_number;
//	}
//	public LocalDate getEffective_date() {
//		return effective_date;
//	}
//	public void setEffective_date(LocalDate effective_date) {
//		this.effective_date = effective_date;
//	}
//	public LocalDate getMaturity_date() {
//		return maturity_date;
//	}
//	public void setMaturity_date(LocalDate maturity_date) {
//		this.maturity_date = maturity_date;
//	}
//
//	public BigDecimal getPrincipal_payable() {
//		return principal_payable;
//	}
//	public void setPrincipal_payable(BigDecimal principal_payable) {
//		this.principal_payable = principal_payable;
//	}
//	public BigDecimal getTenor() {
//		return tenor;
//	}
//	public void setTenor(BigDecimal tenor) {
//		this.tenor = tenor;
//	}
//	public BigDecimal getTimes_rolled_over() {
//		return times_rolled_over;
//	}
//	public void setTimes_rolled_over(BigDecimal times_rolled_over) {
//		this.times_rolled_over = times_rolled_over;
//	}
//
//	public String getType() {
//		return type;
//	}
//	public void setType(String type) {
//		this.type = type;
//	}
//	public BigDecimal getUpfront_interest_paid() {
//		return upfront_interest_paid;
//	}
//	public void setUpfront_interest_paid(BigDecimal upfront_interest_paid) {
//		this.upfront_interest_paid = upfront_interest_paid;
//	}


    @Id
    @Column(name = "DESCRIPTION")
    public String item_description;
    @Column(name = "GOVERNMENT_BONDS_FEDERAL")
    public String government_bonds_federal;
    @Column(name = "GOVERNMENT_BONDS_AMCON")
    public String government_bonds_amcon;
    @Column(name = "GOVERNMENT_BONDS_STATE")
    public String  government_bonds_state;
    @Column(name = "GOVERNMENT_BONDS_LOCAL")
    public String government_bonds_local ;
    @Column(name = "CORPORATE_BONDS")
    public String corporate_bonds ;
    @Column(name = "TREASURY_BILLS")
    public String treasury_bills ;

    @Column(name = "TREASURY_CERTIFICATES")
    public String treasury_certificates;
    @Column(name = "CBN_CERTIFICATES")
    public String  cbn_certificates;
    @Column(name = "CERTIFICATES_OF_DEPOSITS_NON_NEGOTIABLE")
    public String certificates_of_deposits_non_negotiable ;

    @Column(name = "BANKERS_ACCEPTANCE")
    public String bankers_acceptance ;
    @Column(name = "PRINCIPAL_PAYABLE")
    public String principal_payable ;
    @Column(name = "COMMERCIAL_PAPERS")
    public String commercial_papers ;
    @Column(name = "PROMISSORY_NOTES")
    public String promissory_notes ;
    @Column(name = "ASSET_BACKED_SECURITIES")
    public String asset_backed_security ;
    @Column(name = "OTHER_INVESTMENTS")
    public String other_investments ;


    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public String getGovernment_bonds_federal() {
        return government_bonds_federal;
    }

    public void setGovernment_bonds_federal(String government_bonds_federal) {
        this.government_bonds_federal = government_bonds_federal;
    }

    public String getGovernment_bonds_amcon() {
        return government_bonds_amcon;
    }

    public void setGovernment_bonds_amcon(String government_bonds_amcon) {
        government_bonds_amcon = government_bonds_amcon;
    }

    public String getGovernment_bonds_state() {
        return government_bonds_state;
    }

    public void setGovernment_bonds_state(String government_bonds_state) {
        government_bonds_state = government_bonds_state;
    }

    public String getGovernment_bonds_local() {
        return government_bonds_local;
    }

    public void setGovernment_bonds_local(String government_bonds_local) {
        government_bonds_local = government_bonds_local;
    }

    public String getCorporate_bonds() {
        return corporate_bonds;
    }

    public void setCorporate_bonds(String corporate_bonds) {
        this.corporate_bonds = corporate_bonds;
    }

    public String getTreasury_bills() {
        return treasury_bills;
    }

    public void setTreasury_bills(String treasury_bills) {
        this.treasury_bills = treasury_bills;
    }

    public String getTreasury_certificates() {
        return treasury_certificates;
    }

    public void setTreasury_certificates(String treasury_certificates) {
        this.treasury_certificates = treasury_certificates;
    }

    public String getCbn_certificates() {
        return cbn_certificates;
    }

    public void setCbn_certificates(String cbn_certificates) {
        this.cbn_certificates = cbn_certificates;
    }

    public String getCertificates_of_deposits_non_negotiable() {
        return certificates_of_deposits_non_negotiable;
    }

    public void setCertificates_of_deposits_non_negotiable(String certificates_of_deposits_non_negotiable) {
        this.certificates_of_deposits_non_negotiable = certificates_of_deposits_non_negotiable;
    }

    public String getBankers_acceptance() {
        return bankers_acceptance;
    }

    public void setBankers_acceptance(String bankers_acceptance) {
        this.bankers_acceptance = bankers_acceptance;
    }

    public String getPrincipal_payable() {
        return principal_payable;
    }

    public void setPrincipal_payable(String principal_payable) {
        this.principal_payable = principal_payable;
    }

    public String getCommercial_papers() {
        return commercial_papers;
    }

    public void setCommercial_papers(String commercial_papers) {
        this.commercial_papers = commercial_papers;
    }

    public String getPromissory_notes() {
        return promissory_notes;
    }

    public void setPromissory_notes(String promissory_notes) {
        this.promissory_notes = promissory_notes;
    }

    public String getAsset_backed_security() {
        return asset_backed_security;
    }

    public void setAsset_backed_security(String asset_backed_security) {
        this.asset_backed_security = asset_backed_security;
    }

    public String getOther_investments() {
        return other_investments;
    }

    public void setOther_investments(String other_investments) {
        this.other_investments = other_investments;
    }
}
