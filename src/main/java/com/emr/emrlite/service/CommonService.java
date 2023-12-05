package com.emr.emrlite.service;

import com.emr.emrlite.dto.LookUpDTO;
import com.emr.emrlite.dto.LookUpList;
import com.emr.emrlite.model.LookUpModel;
import com.emr.emrlite.repository.LookUpRepositaory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonService {
    private final LookUpRepositaory lookUpRepositaory;
    public HashMap<String, List<LookUpDTO>> getLookupData(List<String> lookuptype) {
        LookUpList mainList = new LookUpList();
        List<LookUpModel> list= lookUpRepositaory.getLookUpData(lookuptype);
        System.out.println("--------->0"+list.size());
        List<LookUpDTO> res = new ArrayList<>();
        HashMap<String, List<LookUpDTO>> hash_map = new HashMap<String, List<LookUpDTO>>();
        list.stream().forEach(item->{
            LookUpDTO lookup = new LookUpDTO();
            lookup.setLookupcode(item.getLookupcode());
            lookup.setLookupid(item.getLookupid());
            lookup.setLookupvalue(item.getLookupvalue());
            lookup.setLookupcode(item.getLookupcode());
           // res.add(lookup);
            if(hash_map.containsKey(item.getLookuptype())){
                List<LookUpDTO> res1 = hash_map.get(item.getLookuptype());
                res1.add(lookup);
                hash_map.put(item.getLookuptype(),res1);
            }else{
                List<LookUpDTO> res2 = new ArrayList<>();
                res2.add(lookup);
                hash_map.put(item.getLookuptype(),res2);
            }
            //hash_map.put(item.getLookuptype(),lookup);
            //return res;
        });
        return hash_map;
    }
}
