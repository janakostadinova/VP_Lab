package mk.ukim.finki.wp.lab.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import mk.ukim.finki.wp.lab.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }


}
