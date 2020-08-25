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
    private Fabrique fabrique;
    private final Random random = new Random();
    private List<Part> parts = new ArrayList<>();
    private Robot robotInProcess = new Robot();
    private List<Robot> robotsFinished = new ArrayList<>();

    public Assistant(String name, Fabrique fabrique) {
        this.assistantName = name;
        this.fabrique = fabrique;
    }

    @Override
    public void run() {
        for (int i = 0; i < RobotFabriqueSimulationService.MAX_PERIODS; i++) {
            gatherAndTry(fabrique.gatherParts(random.nextInt(RobotFabriqueSimulationService.MAX_GENERATED_PARTS) + 1));
            fabrique.sleep(RobotFabriqueSimulationService.NIGHT_DURATION_MS);
        }
    }

    public void gatherAndTry(List<Part> newParts) {
        parts.addAll(newParts);
        System.out.println("Assistant [" + assistantName + "] gathered " + newParts.size() + " parts: " + newParts);
        tryToMakeRobots();
    }

    private void tryToMakeRobots() {
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
}
