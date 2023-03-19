package com.example.demo.repositories;

import com.example.demo.listeners.EntityAuditEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data MongoRepository for the EntityAuditEvent entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EntityAuditEventRepository extends MongoRepository<EntityAuditEvent, String> {

    @Query("{ 'entityId' : ?0,'entityPackage' : ?1,'year' : ?2 }")
    List<EntityAuditEvent> findByEntityIdAndEntityPackageAndYear(String entityId, String entityPackage, Integer year);
}