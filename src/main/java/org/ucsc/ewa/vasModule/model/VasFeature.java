package org.ucsc.ewa.vasModule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "vas_feature_list")

public class VasFeature extends BaseEntity {

    @Column(name = "vas_code")
    private String vasCode;

    @Column(name = "description")
    private String description;
    
    @Column(name = "status")
    private String status;

    public String getVasCode() {
        return vasCode;
    }

    public void setVasCode(String vasCode) {
        this.vasCode = vasCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
