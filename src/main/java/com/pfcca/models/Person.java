package com.pfcca.models;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Réprésente une Personne (un utilisateur) de notre application.
 */
public class Person {
    @Id
    private String id;

    // Le nom d'utilisateur de la personne, doit être unique
    // Utilisé lors de l'authentification
    // Todo: garantir des noms d'utilisateurs uniques dans MongoDB
    private String username;

    private String firstName;
    private String lastName;
    private String mail;

    private String password;

    // Le token du téléphone de l'utilisateur
    // Todo: gérer plusieurs tokens, si jamais l'utilisateur possède plusieurs appareils
    // Todo: gérer aussi les tokens iOS
    private String fcmToken;

    /**
     * Les rôles de l'utilisateur. Permet de sécuriser l'application en restreignant l'accès à certaines fonctionnalités.
     * Par exemple, seuls les utilisateurs "RESPONSABLE" peuvent créer des topics avec TopicController.
     */
    private List<String> roles;

    /**
     * Constructeur par défaut
     */
    public Person() {

    }

    /**
     * Constructeur acceptant comme paramètres le nom d'utilisateur, le mot de passes ainsi que les rôles de l'utilisateur.
     * Utilisé surtout pour créer des utilisateurs de tests car ne possédant pas d'informations utiles représentant une
     * personne réelle.
     * @param username Le nom d'utilisateur de la personne, avec lequel il s'authentifie
     * @param password Le mot de passe de la personne, avec lequel il s'authentifie
     * @param roles Les rôles de la personne, déterminant les fonctionnalités auxquelles elle a accès
     */
    public Person(String username, String password, List<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Person(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.roles = new ArrayList<>();
        this.roles.add(role);
    }

    /**
     * Constructeur acceptant comme paramètres toutes les informations relatives à l'utilisateur, permettant de représenter
     * une personne réelle. Est le constructeur devant être utilisé hors des tests.
     * @param username Le nom d'utilisateur de la personne, avec lequel il s'authentifie
     * @param firstName Le prénom de la personne
     * @param lastName Le nom de famille de la personne
     * @param mail L'e-mail de la personne
     * @param password Le mot de passe de la personne, avec lequel il s'authentifie
     * @param fcmToken Le token FCM de l'appareil de l'utilisateur, utilisé pour recevoir les Push Notifications, récupérées
     *                 directement depuis l'appli mobile
     * @param roles Les rôles de la personne, déterminant les fonctionnalités auxquelles elle a accès
     */
    public Person(String username, String firstName, String lastName, String mail, String password, String fcmToken, List<String> roles) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.fcmToken = fcmToken;
        this.roles = roles;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
