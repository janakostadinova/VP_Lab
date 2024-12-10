package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;
    private final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping("/add")
    public String getAddSong(Model model) {
        model.addAttribute("album", albumService.findAll());
        return "add-song";
    }

    @GetMapping("/edit/{songId}")
    public String getEditSongPage(@PathVariable(name = "songId") Long SongId, Model model) throws Exception {
        model.addAttribute("album", albumService.findAll());
        model.addAttribute("song", songService.findSongById(SongId));
        return "add-song";
    }

    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String error,
                               @RequestParam(required = false) Long albumId,
                               Model model) {
        if (albumId != null) {
            model.addAttribute("songs", songService.findSongsByAlbumId(albumId));
        } else {
            model.addAttribute("songs", songService.listSongs());
        }

        model.addAttribute("albums", albumService.findAll());
        return "listSongs";
    }

    @PostMapping("/add")
    public String saveSong(@RequestParam(name = "title") String title,
                           @RequestParam(name = "trackId") String trackId,
                           @RequestParam(name = "genre") String genre,
                           @RequestParam(name = "releaseYear") int releaseYear,
                           @RequestParam(name = "albumId") Long AlbumId) throws Exception {
        songService.saveSong(title, trackId, genre, releaseYear, AlbumId);
        return "redirect:/songs";
    }

    @PostMapping("/edit/{songId}")
    public String editSong(@PathVariable(name = "songId") Long songId,
                           @RequestParam(name = "title") String title,
                           @RequestParam(name = "trackId") String trackId,
                           @RequestParam(name = "genre") String genre,
                           @RequestParam(name = "releaseYear") int releaseYear,
                           @RequestParam(name = "albumId") Long AlbumId) throws Exception {
        songService.editSong(songId, title, trackId, genre, releaseYear, AlbumId);

        return "redirect:/songs";
    }

    @GetMapping("/delete/{Id}")
    public String deleteSong(@PathVariable(name = "Id") Long Id) {
        songService.deleteSong(Id);

        return "redirect:/songs";
    }

    @GetMapping("/details")
    public String songDetails(@RequestParam String trackId, Model model) {
        Song song = songService.findByTrackId(trackId);
        model.addAttribute("song", song);
        return "songDetails";
    }
}
