package com.camavilca.model.security;

import com.camavilca.zelper.enums.RoleNameEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "seg_rol")
public class Role implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60, name = "name")
    private String name;

//    @ManyToMany(mappedBy = "role")
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "roles")
//    private List<Usuario> usuario;
    private Set<Usuario> usuario;

    public Role() {
    }

    public Role(Object id) {
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

    public RoleNameEnum getRolEnum() {
        return RoleNameEnum.valueOf(name);
    }

    @JsonIgnore
    public void setRolEnum(RoleNameEnum rolEnum) {
        this.name = rolEnum.name();
    }

//    public List<Usuario> getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(List<Usuario> usuario) {
//        this.usuario = usuario;
//    }
    public Set<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(Set<Usuario> usuario) {
        this.usuario = usuario;
    }

}
