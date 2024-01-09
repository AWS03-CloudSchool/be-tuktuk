package com.example.tuktuk.domain.stadium;

import com.example.tuktuk.domain.user.UserId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stadium")
public class Stadium {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "owner_id"))
    private UserId ownerId;

    @Embedded
    private Location location;

    @Comment("This column is stadium officials wrote about the stadium in detail")
    @Column(name = "specific_info", nullable = false, columnDefinition = "text")
    private String specificInfo;

    @OneToMany(mappedBy = "stadium", cascade = CascadeType.ALL)
    private List<Court> courts = new ArrayList<>();
}
