package ifpr.web.controledebiblioteca.services;

import ifpr.web.controledebiblioteca.domains.enums.TypeUsers;
import ifpr.web.controledebiblioteca.domains.models.User;
import ifpr.web.controledebiblioteca.repository.UserRepository;


import java.net.PasswordAuthentication;

public class UserService {

    public void create_user(String name, String email, String password, String type ) throws Exception {
        UserRepository userRepository = new UserRepository();

        User user = userRepository.findByEmail(email);
        if(user != null){
            throw new Exception("Account already exists with " + user.getEmail());
        }

        if (name.equals("") || name == null || name.isEmpty()){
            throw new Exception("Name can't be null");
        }

        if (email.equals("") || email == null || email.isEmpty()) {
            throw new Exception("Email can't be null");
        }

        if (password.equals("") ||password == null || password.isEmpty()) {
            throw new Exception("Password can't be null.");
        }

        if (type.equals("") || type == null || type.isEmpty()) {
            throw new Exception("Type can't be null.");
        }

        try {
            User newUser = new User();

            newUser.setName(name);
            newUser.setEmail(email);
            newUser.setPassword(password);
            newUser.setType(TypeUsers.valueOf(type));

            userRepository.create(newUser);
        } catch (Exception e) {
            throw new Exception("Error creating a new user.");
        }
    }

}
