package com.codegyme.song_colection.repositories;

import com.codegyme.song_colection.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Long> {
}
