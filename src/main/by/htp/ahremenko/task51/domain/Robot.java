package by.htp.ahremenko.task51.domain;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Robot implements Robotable {
    private Map<String, Part> parts = new HashMap<>();

    @Override
    public boolean isPartSuitable(@NonNull Part part) {
        if (parts.containsKey(part.getName())) {
            return false;
        }
        return true;
    }

    @Override
    public void addPart(@NonNull Part part) {
        if (isPartSuitable(part)){
            parts.put(part.getName(), part);
        }
    }

    @Override
    public boolean isReady() {
         return (parts.size() == BodyType.values().length + HardwareType.values().length);
    }
}
