package com.ies.kentucky.admin.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.kentucky.admin.entity.PlanEntity;

public interface PlansRepository extends JpaRepository<PlanEntity, Serializable> {

}
