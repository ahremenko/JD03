package by.htp.ahremenko.task51.domain;

import lombok.Getter;
import lombok.Setter;

public abstract class Part {
    @Getter
    @Setter
    private String name;

    @Override
    public String toString() {
        return "[" + this.name + "]";
    }
}
