package com.findmefood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRestExampleApplication {

//    private final Faker faker = new Faker();

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestExampleApplication.class, args);
	}

//    @Bean
//    public CommandLineRunner initializeDb(PieRepository repository){
//        return (args) -> {
//            repository.deleteAll();
//            //Insert some random pies
//            for(int i = 0; i < 20; i++) {
//                repository.save(new Pie(faker.lorem().word(), faker.lorem().sentence()));
//            }
//        };
//    }

}
