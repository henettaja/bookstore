package hh.swd20.kirjakauppa.tehtC24;

import hh.swd20.kirjakauppa.tehtC24.domain.Category;
import hh.swd20.kirjakauppa.tehtC24.domain.CategoryRepository;
import hh.swd20.kirjakauppa.tehtC24.domain.User;
import hh.swd20.kirjakauppa.tehtC24.domain.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUsernameShouldReturnUser() {
        User user = userRepository.findByUsername("admin");

        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo("admin");
    }

    @Test
    public void createNewUser() {
        User user = new User("Henri", "lkjasjlöfdk", "USER");

        userRepository.save(user);
        assertThat(userRepository.findByUsername("Henri")).isEqualTo(user);
    }

    @Test
    public void deleteUser() {
        User user = new User("Henri", "lkjasjlöfdk", "USER");

        userRepository.save(user);
        assertThat(userRepository.findByUsername("Henri")).isEqualTo(user);

        userRepository.delete(user);
        assertThat(userRepository.findByUsername("Henri")).isNotEqualTo(user);
    }

}