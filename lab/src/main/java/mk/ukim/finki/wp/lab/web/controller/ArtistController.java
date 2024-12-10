package mk.ukim.finki.wp.lab.web.controller;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songDetails")
public class ArtistController {

    private final ArtistService artistService;
    private final SongService songService;

    public ArtistController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }

    @PostMapping("")
    public String addArtistToSong(@RequestParam String trackId, @RequestParam Long artistId) {
        Artist artist = artistService.findById(artistId);
        Song song = songService.findByTrackId(trackId);

        if (artist != null && song != null) {
            songService.addArtistToSong(artist, song);
        }

        return "redirect:/songs/details?trackId=" + trackId;
    }
}

