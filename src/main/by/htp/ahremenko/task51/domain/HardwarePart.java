package by.htp.ahremenko.task51.domain;

public class HardwarePart extends Part {
    private HardwareType partType;

    public HardwarePart(HardwareType type) {
        this.partType = type;
        name = type.name();
    }
}
