package com.kodillalibrary.library.domain.rents;

import com.kodillalibrary.library.domain.copies.Copies;
import com.kodillalibrary.library.domain.readers.Readers;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@Table(name = "RENTS")
public class Rents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="RENT_ID", unique = true)
    private Long id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "COPY_ID")
    private Copies copy;

    @ManyToOne(targetEntity = Readers.class,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "READER_ID")
    private Readers reader;

    @NotNull
    @CreatedDate
    private LocalDate borrowDate;

    @LastModifiedDate
    private LocalDate returnDate;
}
