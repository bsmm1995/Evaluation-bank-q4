package com.bp.cbe.service.impl;

import com.bp.cbe.domain.dto.CustomerDto;
import com.bp.cbe.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @Override
    public List<CustomerDto> listAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CustomerDto findById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CustomerDto create(CustomerDto t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CustomerDto edit(CustomerDto t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub

    }
}
