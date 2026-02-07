package com.banking.admin_module.service;

import com.banking.admin_module.entity.BfsiGroup;
import com.banking.admin_module.repository.BankRepository;
import com.banking.admin_module.repository.BfsiRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BfsiGroupService {

    private final BfsiRepository bfsiRepository;
    private final BankRepository bankRepository;

    //Constructor injection
    public BfsiGroupService(BfsiRepository bfsiRepository, BankRepository bankRepository){
        this.bfsiRepository= bfsiRepository;
        this.bankRepository = bankRepository;
    }

    // get all bfsiGroup
    public List<BfsiGroup> getAllBfsiGroups(){
        return bfsiRepository.findAll();
    }

    // get bfsiGroup by id
    public BfsiGroup getBfsiGroupById(Long id){
        return bfsiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("id not found"));
    }

    // create bank
    public BfsiGroup createBfsiGroup( BfsiGroup bfsiGroup){
        return bfsiRepository.save(bfsiGroup);
    }

    //update bfsiGroup
    public BfsiGroup updateBfsiGroup(Long id, BfsiGroup updatedBfsiGroup){

        BfsiGroup existingBfsiGroup = bfsiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("this bfsi dont exists!"));

        // modify if there is a modification in name
        if (updatedBfsiGroup.getName() != null){
            existingBfsiGroup.setName(updatedBfsiGroup.getName());
        }

        // modify if there is a description
        if (updatedBfsiGroup.getDescription()!= null){
            existingBfsiGroup.setDescription(updatedBfsiGroup.getDescription());
        }
        return bfsiRepository.save(existingBfsiGroup) ;
    }

    // delete bfsi Group
    public void deleteBfsiGroup(Long id){
        if (!bfsiRepository.existsById(id)){
            throw new RuntimeException("this bfsi dont exixts");
        }
        bfsiRepository.deleteById(id);
    }

}
