package com.bp.cbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bp.cbe.domain.Billboard;

@Repository
public interface BillboardRepository extends JpaRepository<Billboard, Integer> {

}
