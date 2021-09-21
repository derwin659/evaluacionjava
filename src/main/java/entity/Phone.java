package entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="phone")
public class Phone {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false,length = 50)
    private String number;

    @Column(nullable=false,length = 50)
    private String cityCode;

    @Column(nullable=false,length = 50)
    private String countryCode;
    @OneToMany(mappedBy = "user",cascade =CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Phone> user =new ArrayList<>();
}
