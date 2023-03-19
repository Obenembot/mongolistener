package com.example.demo.listeners;


import com.example.demo.repositories.EntityAuditEventRepository;

import com.example.demo.util.ConstantString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MongoLister<E> extends AbstractMongoEventListener<E> {

    private static final Logger LOG = LoggerFactory.getLogger(MongoLister.class);

    @Autowired
    private EntityAuditEventRepository entityAuditEventRepository;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<E> event) {
        LOG.info("{} ", event);
    }

    @Override
    public void onAfterSave(AfterSaveEvent<E> event) {
        String id = Objects.requireNonNull(event.getDocument().get("_id")).toString();
        String className = Objects.requireNonNull(event.getDocument().get("_class")).toString();
        String source = event.getSource().toString();
        LOG.info("MongoListener SAVING  :{} :{} :{} ", id, className, source);

        //  LIST OF ENTITIES THAT AUDITS EVENT ARE CREATED
        // TO LISTEN TO ANOTHER ENTITY, YOU NEED TO ADD IT TO THIS CONDITIONAL STATEMENT BELOW.
        if (Objects.equals(className, ConstantString.SAVING_PACKAGE)
                || Objects.equals(className, ConstantString.MEMBER_PACKAGE)
                || Objects.equals(className, ConstantString.ACHIEVEMENT_PACKAGE)
                || Objects.equals(className, ConstantString.BORN_HOUSE_PACKAGE)
                || Objects.equals(className, ConstantString.FUNERAL_PACKAGE)) {

            EntityAuditEvent entityAuditEvent = new EntityAuditEvent();
            entityAuditEvent.setEntityId(id);
            entityAuditEvent.setEntityPackage(className);
            entityAuditEvent.setEntityValue(source);

//Save the audit.
            entityAuditEventRepository.save(entityAuditEvent);
        }

    }
}