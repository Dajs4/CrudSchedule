package org.schedule.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Genera automáticamente los métodos getter para todos los atributos de la clase.
@Getter
//Genera automáticamente los métodos setter para todos los atributos de la clase.
@Setter
//Genera un constructor sin argumentos para la clase.
@NoArgsConstructor
//Genera un constructor con argumentos para todos los atributos de la clase.
@AllArgsConstructor
//Marca la clase como una entidad JPA, que se mapeará a una tabla en la base de datos.
@Entity
//(name = "instructores"): Especifica el nombre de la tabla en la base de datos (en este caso, "instructores").
@Table(name = "instructores")

public class Instructor {

    //Marca el campo como la clave primaria de la entidad.
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY): Indica que el valor de la clave primaria (id)
    // se generará automáticamente utilizando la estrategia de identidad. Esto significa que el valor
    // del ID se auto-incrementará al crear un nuevo registro en la base de datos.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "TipoContrato")
    private String TipoContrato;
}
