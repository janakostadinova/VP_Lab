package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Song {

    @Id
    @GeneratedValue
    private Long id;
    private String trackId;
    private String title;
    private String genre;
    private int releaseYear;
//    private List<Artist> performers = new ArrayList<>();

    @ManyToOne
    Album album;

    public Song(String title, String trackId, String genre, int releaseYear) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }
}
