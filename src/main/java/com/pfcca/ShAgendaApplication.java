package com.pfcca;

import com.pfcca.models.Person;
import com.pfcca.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ShAgendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShAgendaApplication.class, args);
	}

	@Bean
	CommandLineRunner init(final PersonRepository personRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... arg0) throws Exception {
                personRepository.deleteAll();

                ArrayList<String> roles = new ArrayList<>();
                roles.add("ADMIN");
                roles.add("USER");
                roles.add("RESPONSABLE");

                Person admin = new Person("admin", "admin", roles);

                personRepository.save(admin);
            }
        };
    }
}
