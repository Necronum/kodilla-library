package com.kodillalibrary.library.domain.copies;

import com.kodillalibrary.library.domain.CopyStatus;
import com.kodillalibrary.library.domain.books.Books;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Year;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@Table(name = "COPIES")
public class Copies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="COPY_ID", unique = true)
    private Long id;

    @ManyToOne(targetEntity = Books.class,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_ID")
    private Books book;

    @Builder.Default
    @Enumerated(value = EnumType.STRING)
    private CopyStatus status = CopyStatus.AVAILABLE;
}
