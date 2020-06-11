package com.camavilca.model.admin;

import com.camavilca.model.security.Usuario;
import com.camavilca.zelper.enums.EstadoEnum;
import com.camavilca.zelper.utils.DateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "admin_posts")
public class Post implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "url")
    private String url;

    @Column(name = "fecha_inicio")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaInicio;

    @Column(name = "fecha_final")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaFin;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_area_trabajo")
    private AreaTrabajo areaTrabajo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion_trabajo")
    private UbicacionTrabajo ubicacionTrabajo;

    public Post() {
    }

    public Post(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EstadoEnum getEstadoEnum() {
        return EstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoEnum estado) {
        this.estado = estado.name();
    }

    public AreaTrabajo getAreaTrabajo() {
        return areaTrabajo;
    }

    public void setAreaTrabajo(AreaTrabajo areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    public UbicacionTrabajo getUbicacionTrabajo() {
        return ubicacionTrabajo;
    }

    public void setUbicacionTrabajo(UbicacionTrabajo ubicacionTrabajo) {
        this.ubicacionTrabajo = ubicacionTrabajo;
    }

}
