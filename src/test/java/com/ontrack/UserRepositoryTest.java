package com.ontrack;

import static org.assertj.core.api.Assertions.assertThat;

import com.ontrack.users.User;
import com.ontrack.users.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
//@ContextConfiguration(locations =  {"classpath*:/spring/test-context.xml"})
class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    // test methods go below
    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("thematbat@gmail.com");
        user.setPassword("KingWilson6288");
        user.setFirstName("Matthew");
        user.setLastName("Wilson");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }
}