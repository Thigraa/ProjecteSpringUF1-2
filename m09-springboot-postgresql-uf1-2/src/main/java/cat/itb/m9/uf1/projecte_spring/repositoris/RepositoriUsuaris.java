package cat.itb.m9.uf1.projecte_spring.repositoris;

import cat.itb.m9.uf1.projecte_spring.model.user.MyUser;
import org.springframework.data.repository.CrudRepository;

public interface RepositoriUsuaris extends CrudRepository<MyUser, String> {

}
