package by.htp.ahremenko.task51.domain;

import by.htp.ahremenko.task51.service.RobotFabriqueSimulationService;
import lombok.Getter;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;


public class Assistant implements Runnable {
    @Getter
    private String assistantName;

    private final Random random = new Random();

    private volatile List<Part> parts = new CopyOnWriteArrayList<>();

    private Robot robotInProcess = new Robot();

    private volatile List<Robot> robotsFinished = new CopyOnWriteArrayList<>();

    public Assistant(String name) {
        this.assistantName = name;
    }

    public synchronized void addParts(List<Part> newParts) {
        parts.addAll(newParts);
        System.out.println("Assistant [" + assistantName + "] gathered " + newParts.size() + " parts: " + newParts);
    }

    public synchronized void tryToMakeRobots() {
        for (Part part : parts) {
            if (robotInProcess.isPartSuitable(part)) {
                robotInProcess.addPart(part);
                parts.remove(part);
            }
        }
        if (robotInProcess.isReady()) {
            System.out.println("Assistant [" + assistantName + "] made robot: [" + robotInProcess + "]");
            robotsFinished.add(robotInProcess);
            robotInProcess = new Robot();
        }
    }

    public int getAmountFinishedRobots() {
        return robotsFinished.size();
    }

    @Override
    public void run() {
        Fabrique fabrique = Fabrique.getInstance();
        for (int i = 0; i < RobotFabriqueSimulationService.MAX_PERIODS; i++) {
            addParts(fabrique.gatherParts(random.nextInt(RobotFabriqueSimulationService.MAX_GENERATED_PARTS) + 1));
            tryToMakeRobots();
            //System.out.println("Assistant [" + assistantName + "]: parts: " + parts + ", robotInProcess: " + robotInProcess + ", robotsFinished: " + robotsFinished.size());
            sleep(RobotFabriqueSimulationService.NIGHT_DURATION_MS);
        }
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
