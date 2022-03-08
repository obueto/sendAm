package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.PackageClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PackageRepositoryImplTest {
    private PackageRepository packageRepository;
    @BeforeEach
    void setUp(){
        packageRepository = new PackageRepositoryImpl();

    }

    @Test
    void repositorySaveTest() {
        PackageClass aPackage = new PackageClass();
        PackageClass savedPackage = packageRepository.save(aPackage);
        assertEquals(1,savedPackage.getId());
        assertEquals(1,packageRepository.count());
    }
private void saveThreePackages(){
    PackageClass firstPackage = new PackageClass();
    PackageClass secondPackage = new PackageClass();
    PackageClass thirdPackage = new PackageClass();
    packageRepository.save(firstPackage);
    packageRepository.save(secondPackage);
    packageRepository.save(thirdPackage);
}
    @Test
    void repositoryFindByIdTest(){
        PackageClass firstPackage = new PackageClass();
        PackageClass secondPackage = new PackageClass();
        PackageClass thirdPackage = new PackageClass();
        packageRepository.save(firstPackage);
        packageRepository.save(secondPackage);
        packageRepository.save(thirdPackage);

        PackageClass foundPackage = packageRepository.findById(2);
        assertEquals(secondPackage,foundPackage);
        assertEquals(2,foundPackage.getId());
    }
    @Test
    void deleteByIdTest(){
        saveThreePackages();
        packageRepository.delete(2);
        assertEquals(2,packageRepository.count());
    }

    @Test
    void findByIdWorks_afterADeleteTest(){
        saveThreePackages();
        packageRepository.delete(2);
        PackageClass foundPackage = packageRepository.findById(2);
        assertNull(foundPackage);
    }

    @Test
    void saveAfterDelete_givesCorrect(){
saveThreePackages();
packageRepository.delete(1);
PackageClass savePackage = packageRepository.save(new PackageClass());
assertEquals(4,savePackage.getId());


    }

    @Test
    void  deleteByPackageTest(){
        PackageClass firstPackage = new PackageClass();
        PackageClass secondPackage = new PackageClass();
        PackageClass thirdPackage = new PackageClass();
        packageRepository.save(firstPackage);
        packageRepository.save(secondPackage);
        packageRepository.save(thirdPackage);

        packageRepository.delete(secondPackage);
        assertEquals(2,packageRepository.count());
        assertNull(packageRepository.findById(2));

    }
    @Test
    void findAllTest(){
        saveThreePackages();
        List<PackageClass>all =packageRepository.findAll();
        assertEquals(3,all.size());
    }
}