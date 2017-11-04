package org.ucsc.ewa.vasModule.rest;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ucsc.ewa.vasModule.model.VasActivation;
import org.ucsc.ewa.vasModule.model.VasFeature;
import org.ucsc.ewa.vasModule.service.VasFeatureService;




@RestController
@RequestMapping(value = "api/")
public class InitController {

    @Autowired
    private VasFeatureService personService;

    @RequestMapping(value = "getFeature/{featureId}", method = RequestMethod.GET)
    public VasFeature getVasFeature(@PathVariable("featureId") Long featureId) {

        return personService.findOneById(featureId);
    }
    
    @RequestMapping(value = "getAllFeatureList", method = RequestMethod.GET)
    public List<VasFeature> getAllVasFeatures() {

        return personService.findAll(true);
    }
    
    @RequestMapping(value = "getVasDetails/{mobileNo}", method = RequestMethod.GET)
    public List<VasActivation> findVasDetailsBymobileNo(@PathVariable("mobileNo") String mobileNo) {

        return personService.findAllFeaturesByMobileNo(mobileNo);
        
    }
    
    @RequestMapping(value = "activateVasService/{mobileNo}/{vasCode}", method = RequestMethod.GET)
    public String activateVasService(@PathVariable("mobileNo") String mobileNo, @PathVariable("vasCode") String vasCode) {
        VasActivation vas = new VasActivation();
        vas.setMobileNo(mobileNo);
        vas.setFeatureCode(vasCode);
        vas.setStatus(true);
        vas.setActivateDate(new Date());
        personService.activateService(vas);
        return "Successfully Activated";
        
    }
    
    @RequestMapping(value = "deactivateVasService/{mobileNo}/{vasCode}", method = RequestMethod.GET)
    public String deactivateVasService(@PathVariable("mobileNo") String mobileNo, @PathVariable("vasCode") String vasCode) {

        int a = personService.deactivateService(mobileNo, vasCode);
        if(a>0){
            return "Successfully Deactivated";
        }else{
            return "Error Occured";
        }               
    }
}
