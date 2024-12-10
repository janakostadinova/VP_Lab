package mk.ukim.finki.wp.lab.data;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializr {

    private final AlbumRepository albumRepository;

    @PostConstruct
    public void initializeData() {
        for(int i=0;i<2;i++) {
            Album album = new Album("Name" + i, "Genre" + i, "Release year" + i);
            albumRepository.save(album);
        }
    }
}
