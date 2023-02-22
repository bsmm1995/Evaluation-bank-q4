package com.bp.cbe.service.impl;

import com.bp.cbe.domain.entity.CustomerEntity;
import com.bp.cbe.domain.dto.CustomerDto;
import com.bp.cbe.repository.CustomerRepository;
import com.bp.cbe.service.CustomerService;
import com.bp.cbe.service.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDto> listAll() {
        return customerRepository.findAll().stream().map(customerMapper::toBookingDto).toList();
    }

    @Override
    public CustomerDto findById(Integer id) {
        return customerRepository.findById(id).map(customerMapper::toBookingDto).orElseThrow(() -> new NoSuchElementException("Customer not found id " + id));
    }

    @Override
    public CustomerDto create(CustomerDto t) {
        CustomerEntity customer = customerMapper.toBooking(t);
        return customerMapper.toBookingDto(customerRepository.save(customer));
    }

    @Override
    public CustomerDto update(CustomerDto t) {
        Optional<CustomerEntity> optional = customerRepository.findById(t.getId());
        if (optional.isPresent()) {
            var entity = optional.get();
            entity.setAge(t.getAge());
            return customerMapper.toBookingDto(customerRepository.save(entity));
        } else {
                throw new NoSuchElementException("Customer not found id " + t.getId());
        }
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
