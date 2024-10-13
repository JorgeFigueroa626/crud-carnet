package bo.crud_carnet.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private Long ci;

    @NotEmpty
    private String name;

    @NotEmpty
    @Column(name = "last_names")
    private String lastNames;

    @NotNull
    @Column(name = "expiration_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp expirationDate;

    @NotNull
    @Column(name = "date_of_birth")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp dateOfBirth;

    @NotEmpty
    @Column(name = "marital_status")
    private String maritalStatus;

    @NotEmpty
    private String address;

    @ManyToOne
    @JoinColumn(name = "city_id",  referencedColumnName = "id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;
}
