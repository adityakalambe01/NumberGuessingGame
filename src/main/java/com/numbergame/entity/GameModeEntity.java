package com.numbergame;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "game_mode")
public class GameModeEntity {
    @Id
    @Column(name = "level_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameLevelId;

    @Column(name = "level_name")
    private String gameLevelName;

    @Column(name = "level_chances")
    private int gameLevelChances;
}
