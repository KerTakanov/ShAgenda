package com.pfcca.controllers;

import com.pfcca.models.Person;
import com.pfcca.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Permet de gérer via l'API REST de façon sécurisée les Person contenues dans notre BDD.
 * Définit plusieurs routes afin de manipuler les Person;
 *      - /person      : récupère la liste des Person avec leur données
 *      - /person/{id} : récupère les données d'un objet Person selon son id
 */
@RestController
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    /**
     * Récupère un objet Person selon son ID et le renvoie.
     * L'utilisateur doit avoir l'autorité "ADMIN" afin d'accéder aux données d'un objet Person, notamment à cause
     * des données sensibles qui sont exposées (mot de passe, nom, prénom, mail ...).
     * @param id L'id de l'objet Person nous intéressant
     * @return L'objet Person correspondant à l'id {id}, null si n'existant pas
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Person getPersonById(@PathVariable String id) {
        return personRepository.findOne(id);
    }

    /**
     * Récupère la liste de tous les objets Person stockés dans la BDD.
     * L'utilisateur doit avoir l'autorité "ADMIN" afin d'accéder aux objets Person, notamment à cause des données
     * sensibles qui sont exposées (mot de passe, nom, prénom, mail ...).
     * @return La liste des objets Person stockés dans la BDD
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    /**
     * Créé une nouvelle personne
     * @param person La personne a ajouter à la DB
     * @return La personne nouvellement créée
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> newTopic(@RequestBody Person person) {
        // Si la personne existe déjà, alors on renvoie une "erreur"
        if (personRepository.findByUsername(person.getUsername()) != null)
            return ResponseEntity.unprocessableEntity().build();

        // Sinon on l'ajoute et on renvoie une réponse contenant l'adresse de l'objet nouvellement créé
        Person result = personRepository.save(person);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}

