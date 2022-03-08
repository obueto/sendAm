package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.PackageClass;

import java.util.List;

public interface PackageRepository {
    PackageClass save (PackageClass aPackage);
    PackageClass findById(int id);
    void delete(PackageClass aPackage);
    void delete(int id);
    List<PackageClass> findAll();

    int count();
}
