package ifpr.web.controledebiblioteca.domains.models;

import ifpr.web.controledebiblioteca.domains.enums.TypeUsers;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "tb_users")
public class User {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        @Column(length = 60, nullable = false)
        private String name;

        @Column()
        private String email;

        @Column()
        private String password;

        @Enumerated(value = EnumType.STRING)
        private TypeUsers type;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }


        public TypeUsers getType() {
            return type;
        }

        public void setType(TypeUsers type) {
            this.type = type;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }
}

