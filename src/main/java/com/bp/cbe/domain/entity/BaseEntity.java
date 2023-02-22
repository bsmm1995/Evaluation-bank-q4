package com.bp.cbe.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "GENERATOR")
    private Integer id;
    @Column(nullable = false)
    private Boolean status = Boolean.TRUE;
}
