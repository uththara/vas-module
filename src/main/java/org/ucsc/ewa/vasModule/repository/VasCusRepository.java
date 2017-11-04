package org.ucsc.ewa.vasModule.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.ucsc.ewa.vasModule.model.VasFeature;
import org.springframework.stereotype.Repository;
import org.ucsc.ewa.vasModule.model.VasActivation;


@Repository
public interface VasCusRepository extends CrudRepository<VasActivation, Long>{

    
    @Query("select v from VasActivation v where v.mobileNo = ?1 and v.status='ACTIVE'")
    List<VasActivation> findAllFeaturesByMobileNo(String mobileNo);
    
    @Query("select v from VasActivation v where v.mobileNo = ?1 and v.featureCode =?2 and v.status=?3")
    public VasActivation findFeatureByVasCode(String mobileNo, String vasCode, Boolean activE);

   
}
