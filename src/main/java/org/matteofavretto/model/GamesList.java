package org.matteofavretto.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GamesList {

    private String title;
    private String description;
    private List<Game> games;

}
