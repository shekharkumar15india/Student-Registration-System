package in.sp.main.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entities.User;
import in.sp.main.repositories.UserRepositories;
@Service
public class UserServiceImpl  implements UserService{
     @Autowired
    private UserRepositories userRepositories;
    @Override
    public boolean registerUser(User user) {
     try {
        
        userRepositories.save(user); 
        
        return true;
     } catch (Exception e) {
        e.printStackTrace();
     }
     
        return false;
    }

    @Override
    public User loginUser(String email, String password) 
    {
       User validUser = userRepositories.findByEmailAndPassword(email, password); 

         if(validUser != null) {
            return validUser;
         }
        return null;
    }

}

