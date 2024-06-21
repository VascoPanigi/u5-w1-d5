package vascopanigi.u5_w1_d5.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "buildings")
public class Building {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String name;
    private String address;
    private String city;

    @OneToMany(mappedBy = "building")
    private List<Workspace> workspaces;
}
