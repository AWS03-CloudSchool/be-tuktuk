package com.example.tuktuk.stadium.domain.stadium;

import com.example.tuktuk.stadium.controller.dto.requestDto.stadium.StadiumUpdateRequestDto;
import com.example.tuktuk.stadium.domain.Location;
import com.example.tuktuk.stadium.domain.court.Court;
import com.example.tuktuk.user.domain.UserId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.properties.bind.DefaultValue;

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

    public void update(StadiumUpdateRequestDto requestDto){
        this.name=requestDto.getName();
        this.specificInfo=requestDto.getSpecificInfo();
    }
}
