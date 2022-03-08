package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    private UserRepository userRepository;
    @BeforeEach
    void setUp(){
        userRepository = new UserRepositoryImpl();
    }

    @Test
    void userRepositoryCanSaveTest(){
        User newUser = new User();
        String email = "jayamaks@gmail.com";
        newUser.setEmail(email);
        User savedUser = userRepository.save(newUser);
        assertEquals(email,savedUser.getEmail());
        assertEquals(1,userRepository.count());
    }

    @Test
    void userCanBeFoundByMailTest(){
        User firstUser = new User();
        firstUser.setEmail("debmarks@gmail.com");
        User secondUser = new User();
        secondUser.setEmail("cymaks@gmail.com");

        saveTwoUsers (firstUser,secondUser);
        User foundUser = userRepository.findByEmail("debmarks@gmail.com");
        assertEquals(firstUser,foundUser);
        assertEquals("debmarks@gmail.com",firstUser.getEmail());

    }

    private void saveTwoUsers(User firstUser, User secondUser) {
        userRepository.save(firstUser);
        userRepository.save(secondUser);

    }
    @Test
    void userCanDeleteByEmailTest(){
        User firstUser = new User();
        firstUser.setEmail("debmarks@gmail.com");
        User secondUser = new User();
        secondUser.setEmail("cymaks@gmail.com");
        saveTwoUsers (firstUser,secondUser);
        userRepository.delete("debmarks@gmail.com");
        assertEquals(1,userRepository.count());
    }
    @Test
    void findEmailWorksAfterDeleteTest(){
        User firstUser = new User();
        firstUser.setEmail("debmarks@gmail.com");
        User secondUser = new User();
        secondUser.setEmail("cymaks@gmail.com");
        saveTwoUsers (firstUser,secondUser);
        userRepository.delete("debmarks@gmail.com");

        User foundUser = userRepository.findByEmail("debmarks@gmail.com");
        assertNull(foundUser);
    }
    @Test
    void saveAfterADeleteGivesCorrectEmailTest(){
        User firstUser = new User();
        firstUser.setEmail("debmarks@gmail.com");
        User secondUser = new User();
        secondUser.setEmail("cymaks@gmail.com");
        saveTwoUsers (firstUser,secondUser);
        userRepository.delete("debmarks@gmail.com");

        User newUser = userRepository.save(new User());
        assertNull(newUser.getEmail());
    }
    @Test
    void deleteByUserTest(){
        User firstUser = new User();
        firstUser.setEmail("debmarks@gmail.com");
        User secondUser = new User();
        secondUser.setEmail("cymaks@gmail.com");
        saveTwoUsers (firstUser,secondUser);
        userRepository.delete(firstUser);
        assertEquals(1,userRepository.count());
        assertNull(userRepository.findByEmail("debmarks@gmail.com"));
    }

    @Test
    void findAllTest(){
        User firstUser = new User();
        firstUser.setEmail("debmarks@gmail.com");
        User secondUser = new User();
        secondUser.setEmail("cymaks@gmail.com");
        saveTwoUsers (firstUser,secondUser);
        List<User> all = userRepository.findAll();
        assertEquals(2,all.size());
    }

}