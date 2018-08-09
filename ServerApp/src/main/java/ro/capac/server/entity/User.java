package ro.capac.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "capac_user")
@SequenceGenerator(name="CAPAC_USER_ID_SEQ", sequenceName = "capac_user_id_seq", allocationSize = 1)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAPAC_USER_ID_SEQ")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email", unique = true)
    private String userEmail;

    @Column(name = "password")
    private String password;
}
