package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GamesList {

    private String listTitle;
    private String listDescription;
    private List<Game> games;

}
