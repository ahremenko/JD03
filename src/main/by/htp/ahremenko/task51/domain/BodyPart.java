package by.htp.ahremenko.task51.domain;

public class BodyPart extends Part {
    private BodyType partType;

    public BodyPart(BodyType type) {
        this.partType = type;
        setName(type.name());
    }
}
