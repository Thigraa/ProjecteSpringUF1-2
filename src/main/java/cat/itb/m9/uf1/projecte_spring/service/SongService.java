package cat.itb.m9.uf1.projecte_spring.service;

import cat.itb.m9.uf1.projecte_spring.model.song.Song;
import cat.itb.m9.uf1.projecte_spring.repositoris.RepositoriSongs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SongService {

    @Autowired
    public RepositoriSongs repositoriSongs;





    public void add(Song s){
        repositoriSongs.save(s);
    }
    public List<Song> list(){
       return (List<Song>) repositoriSongs.findAll();
    }
    public Song findById(String name){
        return repositoriSongs.findById(name).orElse(null);
    }
    public void removeSong(String name){
        repositoriSongs.deleteById(name);
    }
    public void updateSongbyName(Song s){
        repositoriSongs.save(s);
    }

    @PostConstruct
    public void init(){
        repositoriSongs.saveAll(
                Arrays.asList(
                        new Song("Hotline Bling", "Drake", "Views"),
                        new Song("One Dance", "Drake", "Views")
        ));
    }
}
