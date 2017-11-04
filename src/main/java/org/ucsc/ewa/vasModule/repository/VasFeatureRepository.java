package org.ucsc.ewa.vasModule.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.ucsc.ewa.vasModule.model.VasFeature;
import org.springframework.stereotype.Repository;
import org.ucsc.ewa.vasModule.model.VasActivation;


@Repository
public interface VasFeatureRepository extends JpaRepository<VasFeature, Long> {
    
    @Query("select v from VasFeature v where v.status = ?1")
    List<VasFeature> findAll(Boolean status);
    
    @Query("select v from VasFeature v where v.status = ?1")
    List<VasActivation> findAllFeaturesByMobileNo(String mobileNo);
}
