package by.htp.ahremenko.task51.domain;

import lombok.Getter;

public abstract class Part {
    @Getter
    String name;

    @Override
    public String toString() {
        return super.toString() + " " + this.name;
    }
}
