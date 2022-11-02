package com.xlsx.ReadXlsx.Sevice;

import com.xlsx.ReadXlsx.Repository.ReadRepository;
import com.xlsx.ReadXlsx.model.Custormer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
//@ComponentScan(basePackages = "com.xlsx.ReadXlsx.Repository.ReadRepository")
public class XlsReadService {

    @Autowired
    ReadRepository ReadRepository;

    public void createCustomer(Custormer custormer){

        ReadRepository.save(custormer);
    }
}
