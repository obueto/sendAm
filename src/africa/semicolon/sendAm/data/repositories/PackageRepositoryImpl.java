package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.PackageClass;

import java.util.ArrayList;
import java.util.List;

public class PackageRepositoryImpl implements PackageRepository{
    private List<PackageClass> db = new ArrayList<>();
     private int id = 0;

    @Override
    public PackageClass save(PackageClass aPackage) {
        int id = generateId();
        aPackage.setId(id);
        db.add(aPackage);
        return aPackage;
    }

    private int generateId() {
        id = id+1;
        return id;
    }

    @Override
    public PackageClass findById(int id) {
        for (PackageClass aPackage : db){
            if (aPackage.getId()== id)
                return aPackage;
        }
        return null;
    }

    @Override
    public void delete(PackageClass aPackage) {
db.remove(aPackage);
    }

    @Override
    public void delete(int id) {
PackageClass foundPackage = findById(id);
delete(foundPackage);
    }

    @Override
    public List<PackageClass> findAll() {
        return db;
    }

    @Override
    public int count() {
        return db.size() ;
    }
}
