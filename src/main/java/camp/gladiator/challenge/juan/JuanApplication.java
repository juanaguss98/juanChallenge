package camp.gladiator.challenge.juan;

import camp.gladiator.challenge.juan.model.Trainer;
import camp.gladiator.challenge.juan.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = {"camp.gladiator.challenge"})
public class JuanApplication {

	public static void main(String[] args) {
		SpringApplication.run(JuanApplication.class, args);
	}

}

@Component
class DemoCommandLineRunner implements CommandLineRunner {

	@Autowired
	private TrainerRepository trainerRepository;

	@Override
	public void run(String... args) throws Exception {
	}
}
