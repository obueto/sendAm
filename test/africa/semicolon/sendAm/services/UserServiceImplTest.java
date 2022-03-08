package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.dtos.requests.RegisterUserRequest;
import africa.semicolon.sendAm.dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.exceptions.SendAmAppException;
import africa.semicolon.sendAm.exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private UserService userService;
    @BeforeEach
    public void TestSetUp(){
        userService = new UserServiceImpl();
    }
    @Test
    void afterRegister_repositoryContainsOneElement(){
        RegisterUserRequest registerForm = createRegisterForm();

        userService.register(registerForm);

        assertEquals(1,userService.getRepository().count());
    }

    private RegisterUserRequest createRegisterForm() {
        RegisterUserRequest registerForm = new RegisterUserRequest();
        registerForm.setFirstName("Jay");
        registerForm.setLastName("amaks");
        registerForm.setPhoneNumber("+44788912339");
        registerForm.setEmailAddress("jay@gmail.com");
        registerForm.setAddress("5a permabiri street");
        return registerForm;
    }
    @Test
    void duplicateEmail_throwExceptionTest(){
        RegisterUserRequest form = createRegisterForm();
        //when
        userService.register(form);
        form.setEmailAddress("jay@gmail.com");
        //assert
        assertThrows(SendAmAppException.class,()->userService.register(form));

    }
    @Test
    void registrationReturnCorrectResponseTest(){
        RegisterUserRequest form =createRegisterForm();
        RegisterUserResponse response = userService.register(form);
        assertEquals("Jay amaks",response.getFullName());
        assertEquals("jay@gmail.com",response.getEmail());

    }
    @Test
    void findRegisteredUserByEmailTest(){
        RegisterUserRequest form = createRegisterForm();
        userService.register(form);
        FindUserResponse result = userService.findUserByEmail(form.getEmailAddress().toLowerCase());
        assertEquals("Jay amaks",result.getFullName());
        assertEquals("jay@gmail.com",result.getEmail());
    }
    @Test
    void findingUnregisteredEmailThrowsException(){
        RegisterUserRequest form = createRegisterForm();
        userService.register(form);
        assertThrows(UserNotFoundException.class, () -> userService.findUserByEmail("emma@gmail.com"));
    }





@Test
void findByUserEmailIsNotCaseSensitiveTest() {
    RegisterUserRequest form = createRegisterForm();
    userService.register(form);

    FindUserResponse response = userService.findUserByEmail("jaY@gmail.com");

    assertEquals("Jay amaks", response.getFullName());
    assertEquals("jay@gmail.com", response.getEmail());

}
}