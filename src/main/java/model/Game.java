package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class Game {

    public enum  Genre {
        ACTION,
        ACTION_RPG,
        SOULSLIKE,
        RACING
    }
    public enum Status {
        BACKLOG,
        WISHLIST,
        PLAYING,
        PLAYED,
        DROPPED
    }

    public static class Log {
        public String logText;
        public LocalDateTime logTimestamp;
    }

    private String title;
    private String publisher;
    private Genre genre;
    private Status status;
    private Long score; // Out of 100
    private List<Log> logs;
    private BufferedImage coverArt;
}
