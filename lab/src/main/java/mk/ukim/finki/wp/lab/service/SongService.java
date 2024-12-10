package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    public Song findByTrackId(String trackId);
    void saveSong(String title, String TrackId, String genre, int releaseYear, Long AlbumId) throws Exception;
    void editSong(Long singId, String title, String TrackId, String genre, int releaseYear, Long AlbumId) throws Exception;
    void deleteSong(Long Id);
    Song findSongById(Long Id) throws Exception;
    List<Song> findSongsByAlbumId(Long albumId);

}
