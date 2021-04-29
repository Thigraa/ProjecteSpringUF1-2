package cat.itb.m9.uf1.projecte_spring.service;

import cat.itb.m9.uf1.projecte_spring.model.user.MyUser;
import cat.itb.m9.uf1.projecte_spring.repositoris.RepositoriUsuaris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    public RepositoriUsuaris repositoriUsuaris;

    public void add(MyUser u){
        u.setPassword(passwordEncoder(u.getPassword()));
        repositoriUsuaris.save(u);
    }

    public MyUser findById(String s){
        return repositoriUsuaris.findById(s).orElse(null);
    }
    public List<MyUser> list(){
         return (List<MyUser>) repositoriUsuaris.findAll();
    }
    public void removeUser(String username){
       repositoriUsuaris.deleteById(username);
    }

    @PostConstruct
    public void init(){
        repositoriUsuaris.saveAll(
                Arrays.asList(
                        new MyUser("joan", passwordEncoder("joan"), "ADMIN"),
                        new MyUser("montse", passwordEncoder("montse"), "USER")
                )
        );
    }


    public String passwordEncoder(String s){
        return new BCryptPasswordEncoder().encode(s);
    }
}
