package com.alkemy.icons.icons.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pais")
@Getter
@Setter
public class PaisEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;
    private String denominacion;

    @Column(name = "cant_habitantes")
    // defino este Column para definir una columna, o asociar un atributo de esta clase a una columna de la tabla
    private Long cantidadHabitantes;

    private Long superficie; // m2

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // con la de arriba defino una relacion de muchos a uno -> muchos paises estarán en un continente, y un continente albergará muchos paises. cada pais estará en un unico continente
    // el fetchtype eager -> significa que la inicializacion del continente va a ser temprana, o sea, cuando creo un pais ya me va a venir con su continente
    // cascade all -> si hago un delete en el continente, elimino todos lospaises atados a el, creo.
    @JoinColumn(name = "continente_id", insertable = false, updatable = false)
    // Como voy a joinear esta entidad con la tabla continente? -> a traves del continente_id
    // insertable -> no le puedo insertar valor ni updatearlo, es solo para obtener la info -> por eso updatable false.
    private ContinenteEntity continente;

    @Column(name = "continente_id", nullable = false)
    // esto es para si quiero actualizar la info, el otro es para leerla nomas, va a traer
    // todo el continente entero lo anterior, esto solo trae el id de continente
    private Long continenteId;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "icon_pais",
            joinColumns = @JoinColumn(name = "pais_id"),
            inverseJoinColumns = @JoinColumn(name = "icon_id"))
    private Set<IconEntity> icons = new HashSet<>();




}
