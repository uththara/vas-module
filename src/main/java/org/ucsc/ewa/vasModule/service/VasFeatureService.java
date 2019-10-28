package org.ucsc.ewa.vasModule.service;

import java.util.List;
import org.ucsc.ewa.vasModule.model.VasActivation;
import org.ucsc.ewa.vasModule.model.VasFeature;


public interface VasFeatureService {

    VasFeature findOneById(Long id);
    
    List<VasFeature> findAll(Boolean status);

    List<VasActivation> findAllFeaturesByMobileNo(String mobileNo);
    
    void activateService(VasActivation vas);
    
    int deactivateService(String mobileNo, String vasCode);
}
