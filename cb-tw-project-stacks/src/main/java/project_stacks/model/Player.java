package project_stacks.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity(name = "tb_player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long leadership;

    @ManyToMany
    @JoinTable(
            name = "player_troops", // Nome da tabela associativa
            joinColumns = @JoinColumn(name = "player_id"), // Coluna de FK para Player
            inverseJoinColumns = @JoinColumn(name = "troops_id") // Coluna de FK para Troops
    )
    @JsonIgnoreProperties("player")
    private List<Troops> troops;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLeadership() {
        return leadership;
    }

    public void setLeadership(Long leadership) {
        this.leadership = leadership;
    }

    public List<Troops> getTroops() {
        return troops;
    }

    public void setTroops(List<Troops> troops) {
        this.troops = troops;
    }
}
