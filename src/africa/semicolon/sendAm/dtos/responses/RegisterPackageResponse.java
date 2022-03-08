package africa.semicolon.sendAm.dtos.responses;

import africa.semicolon.sendAm.data.models.PackageDescription;
import africa.semicolon.sendAm.data.models.Status;

public class RegisterPackageResponse {
    private int id;
    private PackageDescription description;
    private Status status;

    public void setId(int id) {
        this.id = id;
    }

    public PackageDescription getDescription() {
        return description;
    }

    public void setDescription(PackageDescription description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

public String getTrackId(){
        return ""  + id;
}

    public int getId() {
        return id;
    }
}
