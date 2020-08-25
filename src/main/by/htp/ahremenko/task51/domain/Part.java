package by.htp.ahremenko.task51.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = false)
public abstract class Part {
    @Getter
    @Setter
    private Typable partType;
}
