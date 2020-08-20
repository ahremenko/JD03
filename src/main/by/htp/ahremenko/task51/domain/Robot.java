package by.htp.ahremenko.task51.domain;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Robot implements Robotable {
    private Map<String, Part> parts = new HashMap<>();

    @Override
    public boolean isPartSuitable(@NonNull Part part) {
        return parts.containsKey(part.getName()) ? false : true;
    }

    @Override
    public void addPart(@NonNull Part part) {
        if (isPartSuitable(part)) {
            parts.put(part.getName(), part);
        }
    }

    @Override
    public boolean isReady() {
        return (parts.size() == BodyType.values().length + HardwareType.values().length);
    }

    @Override
    public String toString() {
        return "Robot{" +
                "parts=" + parts +
                '}';
    }
}
