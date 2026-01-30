package in.sp.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entities.User;

public interface UserRepositories extends JpaRepository<User, Integer> {

    User findByEmail(String email,String password);

    User findByEmailAndPassword(String email, String password);

}
