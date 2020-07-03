package nz.co.indepth.infinity.entity;

import nz.co.indepth.infinity.listener.CustomerAuditRevisionListener;
import org.hibernate.envers.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
 *
 * And also show the REVCHANGES table
 */
@Entity
@Table(name = "REVINFO")
@RevisionEntity(CustomerAuditRevisionListener.class)
public class CustomTrackingRevisionEntity extends DefaultRevisionEntity {

    @ElementCollection
    @JoinTable(name = "REVCHANGES", joinColumns = @JoinColumn( name = "REV" ))
    @Column( name = "ENTITYNAME" )
    @ModifiedEntityNames
    private Set<String> modifiedEntityNames = new HashSet<>();

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getModifiedEntityNames() {
        return modifiedEntityNames;
    }
}
