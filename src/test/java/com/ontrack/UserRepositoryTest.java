package com.ontrack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
//@ContextConfiguration(locations={"/application.properties"})
class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    @Autowired
    private ThreadRepository tRepo;

    @Autowired
    private PostRepository pRepo;

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
        Thread thread = new Thread();
        thread.setTitle("REEEEEEE");
        thread.setAuthor(1);
        Thread savedThread = tRepo.save(thread);
        Thread existThread = entityManager.find(Thread.class, savedThread.getId());

        Post post = new Post();
        post.setTitle("SEHGSEhaerjh");
        post.setBody("Sdhbassrh");
        post.setThread(1);
        Post savedPost = pRepo.save(post);
        Post existPost = entityManager.find(Post.class, savedPost.getId());
        assertThat(existThread.getId()).isEqualTo(existPost.getThread());
        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
    }
}