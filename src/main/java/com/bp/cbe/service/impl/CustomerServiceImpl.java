package com.bp.cbe.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bp.cbe.service.CustomerService;
import com.bp.cbe.service.dto.CustomerDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
	
	@Override
	public List<CustomerDto> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDto findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDto create(CustomerDto t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDto edit(CustomerDto t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

}
