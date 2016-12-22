/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Student
 */
@Entity
@Table(name = "CUSTCARD_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustcardDetails.findAll", query = "SELECT c FROM CustcardDetails c"),
    @NamedQuery(name = "CustcardDetails.findByCustcardId", query = "SELECT c FROM CustcardDetails c WHERE c.custcardId = :custcardId"),
    @NamedQuery(name = "CustcardDetails.findByCardNum", query = "SELECT c FROM CustcardDetails c WHERE c.cardNum = :cardNum"),
    @NamedQuery(name = "CustcardDetails.findByExpMonth", query = "SELECT c FROM CustcardDetails c WHERE c.expMonth = :expMonth"),
    @NamedQuery(name = "CustcardDetails.findByExpYear", query = "SELECT c FROM CustcardDetails c WHERE c.expYear = :expYear"),
    @NamedQuery(name = "CustcardDetails.findByCvv", query = "SELECT c FROM CustcardDetails c WHERE c.cvv = :cvv"),
    @NamedQuery(name = "CustcardDetails.findByNameOnCard", query = "SELECT c FROM CustcardDetails c WHERE c.nameOnCard = :nameOnCard")})
public class CustcardDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CUSTCARD_ID")
    private String custcardId;
    @Column(name = "CARD_NUM")
    private String cardNum;
    @Column(name = "EXP_MONTH")
    private String expMonth;
    @Column(name = "EXP_YEAR")
    private String expYear;
    @Column(name = "CVV")
    private String cvv;
    @Column(name = "NAME_ON_CARD")
    private String nameOnCard;

    public CustcardDetails() {
    }

    public CustcardDetails(String custcardId, String cardNum, String expMonth, String expYear, String cvv, String nameOnCard) {
        this.custcardId = custcardId;
        this.cardNum = cardNum;
        this.expMonth = expMonth;
        this.expYear = expYear;
        this.cvv = cvv;
        this.nameOnCard = nameOnCard;
    }

    public CustcardDetails(String custcardId) {
        this.custcardId = custcardId;
    }

    public String getCustcardId() {
        return custcardId;
    }

    public void setCustcardId(String custcardId) {
        this.custcardId = custcardId;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (custcardId != null ? custcardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustcardDetails)) {
            return false;
        }
        CustcardDetails other = (CustcardDetails) object;
        if ((this.custcardId == null && other.custcardId != null) || (this.custcardId != null && !this.custcardId.equals(other.custcardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.CustcardDetails[ custcardId=" + custcardId + " ]";
    }
    
}
