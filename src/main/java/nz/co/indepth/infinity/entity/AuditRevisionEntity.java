package nz.co.indepth.infinity.entity;

import nz.co.indepth.infinity.listener.CustomerAuditRevisionListener;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import javax.persistence.*;

/**
 * https://adamzareba.github.io/Audit-entities-with-Hibernate-Envers/
 * https://golb.hplar.ch/2019/08/envers.html
 * https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#envers-basics
 *
 * Alter the default REVINFO table
 *
 * Default table is like the following
 * ---------------------
 * rev |   revtstmp
 * -----+---------------
 *
 * Now
 * -------------------------------
 * rev |   revtstmp |  username
 * -----+-----------+-------------
 */
@Entity
@RevisionEntity(CustomerAuditRevisionListener.class)
@Table(name = "REVINFO")
public class AuditRevisionEntity extends DefaultRevisionEntity {

    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
