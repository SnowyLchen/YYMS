package com.ct.service.Impl;


import com.ct.mapper.AddressMapper;
import com.ct.pojo.Address;
import com.ct.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;


    @Override
    public boolean insAddress(Address address) {
        try {
            int row=addressMapper.INSAddress(address);
            if (row==0){
                return false;
            }else return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean UpdateAddress(Address address) {
        try {
           boolean ua=addressMapper.UpdateAddress(address);
           if (ua){
               return true;
           }else return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
