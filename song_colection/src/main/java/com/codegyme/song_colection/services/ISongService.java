package com.codegyme.song_colection.services;

import com.codegyme.song_colection.models.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    Song findById(Long id);
}
