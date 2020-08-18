package by.htp.ahremenko.task51.domain;

public interface Robotable {
    boolean isPartSuitable(Part part);

    void addPart(Part part);

    boolean isReady();

}
