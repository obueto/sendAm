package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.dtos.requests.RegisterPackageRequest;
import africa.semicolon.sendAm.dtos.requests.RegisterUserRequest;
import africa.semicolon.sendAm.dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.dtos.responses.RegisterPackageResponse;
import africa.semicolon.sendAm.dtos.responses.RegisterUserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageServiceImplTest {

    private PackageService packageService;
    @BeforeEach
    public  void setUp(){
        packageService = new PackageServiceImpl();
    }

    @Test
    public void  afterPackageIsRegistered_repositoryContainsOneElement(){

        RegisterPackageRequest packageRequest = new RegisterPackageRequest();
        packageRequest.setName("Book");
        packageRequest.setWeight(30);
        packageService.register(packageRequest);
        assertEquals(1,packageService.getRepository().count());
    }

    @Test
    public void afterPackageIsRegistered_generateTrackingId(){
        RegisterPackageRequest packageRequest = new RegisterPackageRequest();
        packageRequest.setName("Book");
        packageRequest.setWeight(30);
        packageRequest.setQuantity(3);

        RegisterPackageResponse packageResponse = packageService.register(packageRequest);
        assertEquals(1,packageResponse.getId());
        assertEquals("",packageResponse.getTrackId());




    }
}