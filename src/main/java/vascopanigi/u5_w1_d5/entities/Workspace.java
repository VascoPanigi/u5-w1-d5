package vascopanigi.u5_w1_d5.entities;

import jakarta.persistence.*;
import lombok.*;
import vascopanigi.u5_w1_d5.enums.WorkspaceType;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "workspaces")
public class Workspace {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String description;
    @Enumerated(EnumType.STRING)
    private WorkspaceType workspaceType;
    private int maxPeople;
    @OneToMany(mappedBy = "workspace")
    private List<Reservation> reservations;
    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    public Workspace(String description, WorkspaceType workspaceType, int maxPeople) {
        this.description = description;
        this.workspaceType = workspaceType;
        this.maxPeople = maxPeople;
    }
}

