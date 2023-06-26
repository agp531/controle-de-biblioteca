package ifpr.web.controledebiblioteca.services;

import ifpr.web.controledebiblioteca.domains.models.User;
import ifpr.web.controledebiblioteca.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginService {

    public void validateLogin(String email,String password, HttpServletRequest request) throws Exception {
        UserRepository userRepository = new UserRepository();

        try{
            userRepository.findByEmail(email);
        } catch (Exception e) {
            System.out.println("Invalid email or not registered.");
            throw new Exception("Invalid email or not registered.");
        }

        User userLogin = userRepository.findByEmail(email);

        System.out.println("Loging with: " + userLogin.getEmail());

        if(email == null || email.isEmpty()){
            System.out.println("Email can't be null.");
            throw new Exception("Email can't be null.");
        }

        if(password == null || password.isEmpty()){
            System.out.println("Password can't be null.");
            throw new Exception("Password can't be null.");
        }

        if(email.equals(userLogin.getEmail()) && password.equals(userLogin.getPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("is_logged_in", true);
            session.setAttribute("user", userLogin);
            System.out.println("Loging");
        }else {
            System.out.println("Wrong email or password.");
            throw new Exception("Wrong email or password.");
        }
    }
}
