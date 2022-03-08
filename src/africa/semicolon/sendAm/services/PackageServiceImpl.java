package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.models.PackageClass;
import africa.semicolon.sendAm.data.models.PackageDescription;
import africa.semicolon.sendAm.data.repositories.PackageRepository;
import africa.semicolon.sendAm.data.repositories.PackageRepositoryImpl;
import africa.semicolon.sendAm.dtos.requests.RegisterPackageRequest;
import africa.semicolon.sendAm.dtos.responses.RegisterPackageResponse;

public class PackageServiceImpl implements PackageService{
    private PackageRepository packageRepository = new PackageRepositoryImpl();
    @Override
    public RegisterPackageResponse register(RegisterPackageRequest packageRequest) {
        PackageClass packageClass = new PackageClass();
        PackageDescription description = new PackageDescription();
        description.setName(packageRequest.getName());
        description.setWeight(packageRequest.getWeight());
        packageClass.setDescription(description);

        packageRepository.save(packageClass);
        return null;
    }

    @Override
    public PackageRepository getRepository() {
        return packageRepository;
    }
}
