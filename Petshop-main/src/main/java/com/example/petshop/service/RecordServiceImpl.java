package com.example.petshop.service;

import com.example.petshop.model.Record;
import com.example.petshop.repository.RecordRepository;
import com.example.petshop.web.dto.RecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordService{

    @Autowired
    private RecordRepository recordRepository;


    @Override
    public void save(Record record) {
        recordRepository.save(record);
    }
}
