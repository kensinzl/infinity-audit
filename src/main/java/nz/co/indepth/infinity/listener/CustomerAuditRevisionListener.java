package nz.co.indepth.infinity.listener;

import nz.co.indepth.infinity.entity.AuditRevisionEntity;
import org.hibernate.envers.RevisionListener;


public class CustomerAuditRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        if(revisionEntity instanceof AuditRevisionEntity) {
            AuditRevisionEntity audit = (AuditRevisionEntity) revisionEntity;
            /**
             * TODO: how mintaka embrace this one
             */
            audit.setUsername("Admin");
        }
    }
}
