package cat.itb.m9.uf1.projecte_spring.repositoris;

import cat.itb.m9.uf1.projecte_spring.model.song.Song;
import org.springframework.data.repository.CrudRepository;

public interface RepositoriSongs extends CrudRepository<Song, String> {
}
