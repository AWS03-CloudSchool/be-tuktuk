package com.example.tuktuk.domain.slice.borrow;

import com.example.tuktuk.domain.slice.Slice;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "borrow")
public class Borrow {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "slice_id", nullable = false)
    private Slice slice;

    @Enumerated
    @Column(name = "status", nullable = false)
    private BorrowStatus borrowStatus;

    @Embedded
    private Borrower borrower;

}
