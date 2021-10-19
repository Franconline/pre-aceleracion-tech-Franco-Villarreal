package com.alkemy.icons.icons.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
// para indicar que esto es una entidad
@Table(name = "continente")
// indico cual es la tabla que va a usar esta entidad
@Getter
@Setter
// estos ultimos 2 crea por cada uno de los atributos un getter y un setter


public class ContinenteEntity {

    @Id
    // Para definir un id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    // este generatedvalue es para determinar como voy a generar los ID, y defino la estrategia ->  como secuencia
    // tipo autoincremental, 1 - 2 - 3
    private Long id;

    private String imagen;
    private String denominacion;
}
