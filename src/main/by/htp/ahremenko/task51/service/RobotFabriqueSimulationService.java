package by.htp.ahremenko.task51.service;

import by.htp.ahremenko.task51.domain.*;

public class RobotFabriqueSimulationService {

    public static final int MAX_GENERATED_PARTS = 4;
    public static final int MAX_PERIODS = 100;
    public static final int INITIAL_PARTS = 20;
    public static final int NIGHT_DURATION_MS = 100;

    public int handle() {

        Fabrique fabrique = Fabrique.getInstance();
        fabrique.run();

        Assistant assistant1 = new Assistant();
        Assistant assistant2 = new Assistant();
        assistant1.run();
        assistant2.run();



        return 0;
    }
}
