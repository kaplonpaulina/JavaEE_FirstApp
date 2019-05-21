package models;

import java.io.Serializable;

public class UserCredentials implements Serializable {

    private String username;
    private String password;

    public UserCredentials() {
    }

    public UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User( "+this.username+", "+this.password+" )";
    }


}

//
//import javax.persistence.*;
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlRootElement;
//import java.util.Objects;
//
//
//@Entity
//@Table(name = "t_user")
//@NamedQueries({
//        @NamedQuery(name = UserCredentials.FIND_ALL, query = "SELECT u FROM UserCredentials u ORDER BY u.lastName DESC"),
//        @NamedQuery(name = UserCredentials.FIND_BY_LOGIN_PASSWORD, query = "SELECT u FROM UserCredentials u WHERE u.login = :login AND u.password = :password"),
//        @NamedQuery(name = UserCredentials.COUNT_ALL, query = "SELECT COUNT(u) FROM UserCredentials u")
//})
//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
//public class UserCredentials {
//
//    // ======================================
//    // =             Constants              =
//    // ======================================
//
//    public static final String FIND_ALL = "UserCreditials.findAll";
//    public static final String COUNT_ALL = "UserCReditials.countAll";
//    public static final String FIND_BY_LOGIN_PASSWORD = "UserCReditials.findByLoginAndPassword";
//
//    // ======================================
//    // =             Attributes             =
//    // ======================================
//
//    @Id
//    @Column(length = 10, nullable = false)
//    private String login;
//    @Column(length = 256, nullable = false)
//    private String password;
//
//
//    // ======================================
//    // =            Constructors            =
//    // ======================================
//
//    public UserCredentials() {
//    }
//
//    public UserCredentials(String login, String password) {
//        this.login = login;
//        this.password = password;
//    }
//
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserCredentials user = (UserCredentials) o;
//        return Objects.equals(login, user.login);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(login);
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "login" + login +
//                '}';
//    }
//}