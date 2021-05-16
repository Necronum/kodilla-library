package com.kodillalibrary.library.domain.books;

import com.kodillalibrary.library.domain.copies.Copies;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@Table(name = "BOOKS")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="BOOK_ID", unique = true)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    private Year yearOfPublish;

    @OneToMany(
            targetEntity = Copies.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "book"
    )
    private List<Copies> copiesList = new ArrayList<>();
}
