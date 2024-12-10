package mk.ukim.finki.wp.lab.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;


    @Override
    public List<Song> listSongs() {

        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
//        return songRepository.addArtistToSong(artist, song);
        return null;
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }

    @Override
    public void saveSong(String title, String TrackId, String genre, int releaseYear, Long AlbumId) throws Exception {
        Album album = albumRepository.findById(AlbumId).orElseThrow(Exception::new);
        Song song = new Song(title, TrackId, genre, releaseYear);
        song.setAlbum(album);
        songRepository.save(song);
    }

    @Override
    public void editSong(Long songId, String title, String TrackId, String genre, int releaseYear, Long AlbumId) throws Exception {
        Song song = songRepository.findById(songId).orElseThrow(Exception::new);
        Album album = albumRepository.findById(AlbumId).orElseThrow(Exception::new);
        song.setTitle(title);
        song.setTrackId(TrackId);
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);
        song.setAlbum(album);
        songRepository.save(song);
    }

    @Override
    public void deleteSong(Long Id) {
        songRepository.deleteById(Id);
    }

    @Override
    public Song findSongById(Long Id) throws Exception {
        return songRepository.findById(Id).orElseThrow(Exception::new);
    }

    @Override
    public List<Song> findSongsByAlbumId(Long albumId) {
        return songRepository.findAllByAlbumId(albumId);
    }
}
