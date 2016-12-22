/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author waiho
 */
@Entity
@Table(name = "STAFF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s"),
    @NamedQuery(name = "Staff.findByStaffId", query = "SELECT s FROM Staff s WHERE s.staffId = :staffId"),
    @NamedQuery(name = "Staff.findByStaffPwd", query = "SELECT s FROM Staff s WHERE s.staffPwd = :staffPwd"),
    @NamedQuery(name = "Staff.findByStaffName", query = "SELECT s FROM Staff s WHERE s.staffName = :staffName"),
    @NamedQuery(name = "Staff.findByStaffIc", query = "SELECT s FROM Staff s WHERE s.staffIc = :staffIc"),
    @NamedQuery(name = "Staff.findByStaffDob", query = "SELECT s FROM Staff s WHERE s.staffDob = :staffDob"),
    @NamedQuery(name = "Staff.findByStaffContactnum", query = "SELECT s FROM Staff s WHERE s.staffContactnum = :staffContactnum"),
    @NamedQuery(name = "Staff.findByStaffPosition", query = "SELECT s FROM Staff s WHERE s.staffPosition = :staffPosition"),
    @NamedQuery(name = "Staff.findByStaffStatus", query = "SELECT s FROM Staff s WHERE s.staffStatus = :staffStatus"),
    @NamedQuery(name = "Staff.findByStaffAddress", query = "SELECT s FROM Staff s WHERE s.staffAddress = :staffAddress"),
    @NamedQuery(name = "Staff.findByStaffEmail", query = "SELECT s FROM Staff s WHERE s.staffEmail = :staffEmail")})
public class Staff implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "STAFF_ID")
    private String staffId;
    @Column(name = "STAFF_PWD")
    private String staffPwd;
    @Column(name = "STAFF_NAME")
    private String staffName;
    @Column(name = "STAFF_IC")
    private String staffIc;
    @Column(name = "STAFF_DOB")
    private String staffDob;
    @Column(name = "STAFF_CONTACTNUM")
    private String staffContactnum;
    @Column(name = "STAFF_POSITION")
    private String staffPosition;
    @Column(name = "STAFF_STATUS")
    private String staffStatus;
    @Column(name = "STAFF_ADDRESS")
    private String staffAddress;
    @Column(name = "STAFF_EMAIL")
    private String staffEmail;
    @OneToMany(mappedBy = "staffId")
    private List<PaymentDetails> paymentDetailsList;

    public Staff() {
    }

    public Staff(String staffId, String staffPwd, String staffName, String staffIc, String staffDob, String staffContactnum, String staffPosition, String staffStatus, String staffAddress, String staffEmail) {
        this.staffId = staffId;
        this.staffPwd = staffPwd;
        this.staffName = staffName;
        this.staffIc = staffIc;
        this.staffDob = staffDob;
        this.staffContactnum = staffContactnum;
        this.staffPosition = staffPosition;
        this.staffStatus = staffStatus;
        this.staffAddress = staffAddress;
        this.staffEmail = staffEmail;
    }

    public Staff(String staffId, String staffName, String staffIc, String staffDob, String staffContactnum, String staffPosition, String staffStatus, String staffAddress, String staffEmail) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffIc = staffIc;
        this.staffDob = staffDob;
        this.staffContactnum = staffContactnum;
        this.staffPosition = staffPosition;
        this.staffStatus = staffStatus;
        this.staffAddress = staffAddress;
        this.staffEmail = staffEmail;
    }

    public Staff(String staffId, String staffPwd) {
        this.staffId = staffId;
        this.staffPwd = staffPwd;
    }

    

    public Staff(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffPwd() {
        return staffPwd;
    }

    public void setStaffPwd(String staffPwd) {
        this.staffPwd = staffPwd;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffIc() {
        return staffIc;
    }

    public void setStaffIc(String staffIc) {
        this.staffIc = staffIc;
    }

    public String getStaffDob() {
        return staffDob;
    }

    public void setStaffDob(String staffDob) {
        this.staffDob = staffDob;
    }

    public String getStaffContactnum() {
        return staffContactnum;
    }

    public void setStaffContactnum(String staffContactnum) {
        this.staffContactnum = staffContactnum;
    }

    public String getStaffPosition() {
        return staffPosition;
    }

    public void setStaffPosition(String staffPosition) {
        this.staffPosition = staffPosition;
    }

    public String getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    @XmlTransient
    public List<PaymentDetails> getPaymentDetailsList() {
        return paymentDetailsList;
    }

    public void setPaymentDetailsList(List<PaymentDetails> paymentDetailsList) {
        this.paymentDetailsList = paymentDetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffId != null ? staffId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.staffId == null && other.staffId != null) || (this.staffId != null && !this.staffId.equals(other.staffId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Staff[ staffId=" + staffId + " ]";
    }
    
}
