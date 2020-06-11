package com.camavilca.model.security;

import com.camavilca.zelper.enums.EstadoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "seg_user", uniqueConstraints = {
    @UniqueConstraint(columnNames = {
        "username"
    })
    ,
        @UniqueConstraint(columnNames = {
        "email"
    })
})
public class Usuario implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "estado")
    private String estado;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_persona")
//    private Persona persona;
//
//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = CascadeType.PERSIST)
//    @JoinTable(name = "seg_rol_has_user",
//            joinColumns = {
//                @JoinColumn(name = "id_user", referencedColumnName = "id",
//                        nullable = false, updatable = false)
//            },
//            inverseJoinColumns = {
//                @JoinColumn(name = "id_rol", referencedColumnName = "id",
//                        nullable = false, updatable = false)
//            })
////    private List<Role> roles;
//    private Set<Role> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Usuario(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EstadoEnum getEstadoEnum() {
        return EstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoEnum estado) {
        this.estado = estado.name();
    }

}
