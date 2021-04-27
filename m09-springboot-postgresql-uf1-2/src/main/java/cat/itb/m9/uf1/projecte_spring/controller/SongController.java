package cat.itb.m9.uf1.projecte_spring.controller;

import cat.itb.m9.uf1.projecte_spring.model.song.Song;
import cat.itb.m9.uf1.projecte_spring.model.user.MyUser;
import cat.itb.m9.uf1.projecte_spring.service.SongService;
import cat.itb.m9.uf1.projecte_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@Controller
public class SongController {

    String name;
    @Autowired
    private UserService userservice;
    @Autowired
    private SongService songService;


    @GetMapping("/")
    public String start(Model m){
        m.addAttribute("songslist", songService.list());
        m.addAttribute("Song", new Song());
        return "home";
    }
    @GetMapping("/userList")
    public String listSongs(Model m){
        m.addAttribute("songslist", songService.list());
        return "home";
    }
    @RequestMapping(value="/delete/{name}", method = RequestMethod.POST)
    public String removeSong(@PathVariable("name") String song){
        songService.removeSong(song);
        return "redirect:/";
    }
    @RequestMapping("/add")
    public String addSong(Model model){
        model.addAttribute("Song", new Song());
        return "songForm";
    }

    @PostMapping("/songForm")
    public String addSong(@ModelAttribute("Song") Song s){
        songService.add(s);
        return "redirect:/";
    }
    @GetMapping("/users")
    public String list(Model m){
        m.addAttribute("userslist", userservice.list());
        return "userslist";
    }
    @RequestMapping(value = "/update/{name}", method = RequestMethod.POST)
    public String updateSong(@PathVariable("name") String song, Model m){
        name = song;
        m.addAttribute("Song", songService.findById(song));
        return "updateSong";
    }
    @PostMapping("/updateSong")
    public String updateSong(@ModelAttribute("Song") Song s){
        songService.updateSongbyName(s);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String showRegistrationForm(WebRequest request, Model m){
        m.addAttribute("user", new MyUser());
        return "register";
    }
    @PostMapping("/register")
    public String addUser(@ModelAttribute("user") MyUser u){
        u.setRol("USER");
        userservice.add(u);
        return "redirect:/login";
    }

}
