package by.htp.ahremenko.task51.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Assistant extends Thread{
    @Getter
    private String name;

    private List<Part> parts = new ArrayList<>();

    private List<Robot> robotsInProcess = new ArrayList<>();

    private List<Robot> robotsFinished = new ArrayList<>();

    public void addParts(List<Part> newParts) {
        parts.addAll(newParts);
    }

    public void tryMakeRobots() {
        for( Robot robot : robotsInProcess) {
            for(Part part : parts) {
                if (robot.isPartSuitable(part)) {
                    robot.addPart(part);
                    parts.remove(part);
                }
            }
        }
        for( Robot robot : robotsInProcess) {
            if (robot.isReady()) {
                robotsFinished.add(robot);
                robotsInProcess.remove(robot);
            }
        }
    }

    public int getAmountFinishedRobots() {
        return robotsFinished.size();
    }

    @Override
    public void run() {

    }
}
