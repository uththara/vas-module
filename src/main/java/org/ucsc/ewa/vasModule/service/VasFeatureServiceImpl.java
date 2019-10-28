package org.ucsc.ewa.vasModule.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.ucsc.ewa.vasModule.model.VasActivation;
import org.ucsc.ewa.vasModule.model.VasFeature;
import org.ucsc.ewa.vasModule.repository.VasCusRepository;
import org.ucsc.ewa.vasModule.repository.VasFeatureRepository;

@Service
public class VasFeatureServiceImpl implements VasFeatureService {

    @Autowired
    private VasFeatureRepository personRepository;

    @Autowired
    private VasCusRepository vasCusRepository;

    @Override
    public VasFeature findOneById(Long id) {

        VasFeature one = personRepository.findOne(id);
        return one;
    }
    
    @Override
    public List<VasFeature> findAll(Boolean status) {

        List<VasFeature> list = personRepository.findAll(status);
        return list;
    }
    
    @Override
    public List<VasActivation> findAllFeaturesByMobileNo(String mobileNo) {

        List<VasActivation> list = vasCusRepository.findAllFeaturesByMobileNo(mobileNo);
        List<VasFeature> featureList = personRepository.findAll(true);
        
        List<VasActivation> tempList = new ArrayList<VasActivation>();
        boolean hasFeature = false;
        for(int i=0; i<featureList.size(); i++){
            for(int j=0;j<list.size();j++){
                if(featureList.get(i).getVasCode().equals(list.get(j).getFeatureCode())){
                    hasFeature = true;
                    tempList.add(list.get(j));
                    break;
                }
                hasFeature = false;
            }
            if(!hasFeature){
                VasActivation vas = new VasActivation();
                vas.setFeatureCode(featureList.get(i).getVasCode());
                vas.setMobileNo(mobileNo);
                vas.setStatus(false);
                tempList.add(vas);
            }
        }
        return tempList;
    }
    
    @Override
    public void activateService(VasActivation vas){        
        vasCusRepository.save(vas);
    }
    
    @Override
    public int deactivateService(String mobileNo, String vasCode){
        int update = 0;
        VasActivation vasActObj = vasCusRepository.findFeatureByVasCode(mobileNo,vasCode, true);
        if(vasActObj != null){
            vasActObj.setStatus(false);
            vasActObj.setTerminateDate(new Date());
            vasCusRepository.save(vasActObj);
            update = 1;
        }
        return update;
    }
    
}
