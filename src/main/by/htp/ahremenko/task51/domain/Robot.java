package by.htp.ahremenko.task51.domain;

import lombok.NonNull;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString(callSuper = false)
public class Robot implements Robotable {
    private Map<Typable, Part> parts = new HashMap<>();

    @Override
    public boolean isPartSuitable(@NonNull Part part) {
        return !parts.containsKey(part.getPartType());
    }

    @Override
    public void addPart(@NonNull Part part) {
        if (isPartSuitable(part)) {
            parts.put(part.getPartType(), part);
        }
    }

    @Override
    public boolean isReady() {
        return (parts.size() == BodyType.values().length + HardwareType.values().length);
    }

    /*@Override
    public String toString() {
        return "Robot{" +
                "parts=" + parts +
                '}';
    }*/
}
