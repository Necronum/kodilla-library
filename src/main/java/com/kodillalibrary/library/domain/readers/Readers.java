package com.kodillalibrary.library.domain.readers;

import com.kodillalibrary.library.domain.rents.Rents;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@Table(name = "READERS")
public class Readers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="READER_ID", unique = true)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @CreatedDate
    private LocalDate creationDate;

    @OneToMany(
            targetEntity = Rents.class,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
            fetch = FetchType.LAZY,
            mappedBy = "reader"
    )
    private List<Rents> rentsList = new ArrayList<>();
}
