package com.creandoUnaApiRest;

import com.creandoUnaApiRest.bean.*;
import com.creandoUnaApiRest.component.ComponentDependency2;
import com.creandoUnaApiRest.component.ComponentDependency;
import com.creandoUnaApiRest.entity.User;
import com.creandoUnaApiRest.pogo.UserPojo;
import com.creandoUnaApiRest.repository.UserRepository;
import com.creandoUnaApiRest.service.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;


@SpringBootApplication
public class creandoUnaApiRest implements CommandLineRunner {

	Log LOGGER = LogFactory.getLog(creandoUnaApiRest.class);

	private ComponentDependency componentDependency;

	private ComponentDependency2 componentDependency2;
	private MyBean myBean;
	private MyOperation myOperation;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanName myBeanName;
	private UserPojo userPojo;
	private MyBeanWithProperties myBeanWithProperties;

	private UserRepository userRepository;

    private UserService userService;

	public creandoUnaApiRest(ComponentDependency componentDependency, ComponentDependency2 componentDependency2, MyBean myBean,
								  MyOperation myOperation, MyBeanWithDependency myBeanWithDependency,
								  MyBeanName myBeanName, UserPojo userPojo,
								  MyBeanWithProperties myBeanWithProperties, UserRepository userRepository,
								  UserService userService) {
		this.componentDependency = componentDependency;
		this.componentDependency2 = componentDependency2;
		this.myBean = myBean;
		this.myOperation = myOperation;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanName = myBeanName;
		this.userPojo = userPojo;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userRepository= userRepository;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(creandoUnaApiRest.class, args);
	}

	public void Example() {
		componentDependency2.speak();
		componentDependency.say();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(userPojo.getEmail() + userPojo.getPassword());
		System.out.println(myBeanWithProperties.function());

		LOGGER.info("Hola, estos es la info del aplicativo");
	}

	@Override
	public void run(String... args) {
		Example();
		saveUserInDataBase();
		getInformationJpqlFromUser();
		saveWithErrorTransactional();
	}

	private void getInformationJpqlFromUser(){

        LOGGER.info("User with method findMyUserByEmail: "
				+ userRepository.findMyUserByEmail("Steven@hotmail.com")
				.orElseThrow(() -> new RuntimeException("No se encontró el usuario")));

		userRepository.findByAndSort("User", Sort.by("id").descending())
				.forEach(User -> LOGGER.info("Usuario con metodo sort " + User));

		userRepository.findByName("Rolando")
				.forEach((user -> LOGGER.info("usuario con query method" + user)));

	//LOGGER.info("User with method findUserByNameAndEmail: " + userRepository.findByEmailAndName("John", "john@domain.com")
		//		.orElseThrow(() -> new RuntimeException("No se encontro el usuario por el email dado")));

	}
    private void saveWithErrorTransactional(){

        User test1 = new User("TestTransactional1", "TestTransactional1@domain.com", LocalDate.now());
        User test2 = new User("TestTransactional2", "TestTransactional2@domain.com", LocalDate.now());
        User test3 = new User("TestTransactional3", "TestTransactional3@domain.com", LocalDate.now());
        User test4 = new User("TestTransactional4", "TestTransactional4@domain.com", LocalDate.now());

        List<User> users = asList(test1, test2, test3, test4);

        userService.saveTransactional(users);
		userService.getAllUsers()
				.forEach(user ->
						LOGGER.info("Este es el usuario del metodo transaccional " + user));

    }
	private void saveUserInDataBase(){
			User user1 = new User("Yeisson", "rola.com", LocalDate.of(2022, 4, 12));
			User user2 = new User("Rolando", "Yei@hotmail.com", LocalDate.of(2020, 12, 2));
			User user3 = new User("Caro", "Caro@hotmail.com", LocalDate.of(2000, 3, 6));
			User user4 = new User("Steven", "Steven@hotmail.com", LocalDate.of(1990, 5, 18));
			User user5 = new User("Anyi", "Anyi@hotmail.com", LocalDate.of(1991, 9, 18));

			List<User> list = Arrays.asList(user1,user2,user3, user4, user5);
			list.forEach(userRepository::save);
		}
}
