package by.htp.ahremenko.task51.domain;

import by.htp.ahremenko.task51.service.RobotFabriqueSimulationService;
import lombok.Getter;

import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.ArrayList;

public class Assistant implements Runnable {
    @Getter
    private String assistantName;

    private final Random random = new Random();

    private List<Part> parts = new ArrayList<>();

    private Robot robotInProcess = new Robot();

    private List<Robot> robotsFinished = new ArrayList<>();

    public Assistant(String name) {
        this.assistantName = name;
    }

    public void addParts(List<Part> newParts) {
        parts.addAll(newParts);
        System.out.println("Assistant [" + assistantName + "] gathered " + newParts.size() + " parts: " + newParts);
    }

    public void tryToMakeRobots() {
        ListIterator<Part> iterator = parts.listIterator();
        while (iterator.hasNext()) {
            Part part = iterator.next();
            if (robotInProcess.isPartSuitable(part)) {
                robotInProcess.addPart(part);
                iterator.remove();
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
