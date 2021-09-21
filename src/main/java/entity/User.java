package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user")
public class User  {
@Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false,length = 50)
    private String nombre;

    @Column(nullable=false,length = 50)
    private String correo;

    @Column(nullable=false,length = 50)
    private String contraseña;

    @Column(nullable=false,length = 50)
    private String contraseña;



}
