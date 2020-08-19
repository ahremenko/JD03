package by.htp.ahremenko.task51.domain;

import by.htp.ahremenko.task51.service.RobotFabriqueSimulationService;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Assistant implements Runnable {
    @Getter
    private String assistantName;

    private List<Part> parts = new ArrayList<>();

    private List<Robot> robotsInProcess = new ArrayList<>();

    private List<Robot> robotsFinished = new ArrayList<>();

    public Assistant(String name) {
        this.assistantName = name;
    }

    public void addParts(List<Part> newParts) {
        parts.addAll(newParts);
        System.out.println("Assistant [" + assistantName + "] added " + newParts.size() + " parts.");
    }

    public void tryMakeRobots() {
        for (Robot robot : robotsInProcess) {
            for (Part part : parts) {
                if (robot.isPartSuitable(part)) {
                    robot.addPart(part);
                    parts.remove(part);
                }
            }
        }
        for (Robot robot : robotsInProcess) {
            if (robot.isReady()) {
                robotsFinished.add(robot);
                System.out.println("Assistant [" + assistantName + "] made robot: [" + robot + "]");
                robotsInProcess.remove(robot);
            }
        }
    }

    public int getAmountFinishedRobots() {
        return robotsFinished.size();
    }

    @Override
    public void run() {
        Random random = new Random();
        Fabrique fabrique = Fabrique.getInstance();
        for (int i = 0; i < RobotFabriqueSimulationService.MAX_PERIODS; i++) {
            addParts(fabrique.gatherParts(random.nextInt(RobotFabriqueSimulationService.MAX_GENERATED_PARTS) + 1));
            tryMakeRobots();
            System.out.println("Assistant [" + assistantName + "]: parts: " + parts.size() + ", robotsInProcess: " + robotsInProcess.size() + ", robotsFinished: " + robotsFinished.size());
            try {
                Thread.sleep(RobotFabriqueSimulationService.NIGHT_DURATION_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
