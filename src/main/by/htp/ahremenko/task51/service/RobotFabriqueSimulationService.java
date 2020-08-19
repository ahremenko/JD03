package by.htp.ahremenko.task51.service;

import by.htp.ahremenko.task51.domain.*;

public class RobotFabriqueSimulationService {

    public static final int MAX_GENERATED_PARTS = 4;
    public static final int MAX_PERIODS = 10;
    public static final int INITIAL_PARTS = 20;
    public static final int NIGHT_DURATION_MS = 100;

    public static int handle() {

        Fabrique fabrique = Fabrique.getInstance();
        Assistant assistant1 = new Assistant("Vasya");
        Assistant assistant2 = new Assistant("Lena");
        //for (int i = 0; i < RobotFabriqueSimulationService.MAX_PERIODS; i++) {
        new Thread(fabrique).start();
        //Thread assistant1Tread = new Thread(assistant1);
        //Thread assistant2Tread = new Thread(assistant2);
        //try {

            //fabriqueTread.start();
            //assistant1Tread.start();
            //assistant2Tread.start();
            //        Thread.sleep(RobotFabriqueSimulationService.NIGHT_DURATION_MS);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        //}
        return Math.max(assistant1.getAmountFinishedRobots(), assistant2.getAmountFinishedRobots());
    }
}
