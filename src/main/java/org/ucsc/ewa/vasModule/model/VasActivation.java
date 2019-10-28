/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ucsc.ewa.vasModule.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author uththaras
 */

@Entity
@Table(name = "sc_vas_activation")
public class VasActivation extends BaseEntity{
    
    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "feature_code")
    private String featureCode;
    
    @Column(name = "status")
    private Boolean status;
    
    @Column(name = "activate_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date activateDate;

    @Column(name = "terminate_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date terminateDate;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getActivateDate() {
        return activateDate;
    }

    public void setActivateDate(Date activateDate) {
        this.activateDate = activateDate;
    }

    public Date getTerminateDate() {
        return terminateDate;
    }

    public void setTerminateDate(Date terminateDate) {
        this.terminateDate = terminateDate;
    }
    

}
