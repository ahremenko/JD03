package by.htp.ahremenko.task51.domain;

import by.htp.ahremenko.task51.service.RobotFabriqueSimulationService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Fabrique extends Thread {

    private static volatile Fabrique instance;

    private List<Part> allParts = new ArrayList<>();
    private Random random = new Random();
    private volatile List<Part> enabledParts = new LinkedList<>();

    {
        BodyType[] bodyPartTypes = BodyType.values();
        for (int i = 0; i < bodyPartTypes.length; i++) {
            allParts.add(new BodyPart(bodyPartTypes[i]));
        }
        HardwareType[] hardwareTypes = HardwareType.values();
        for (int i = 0; i < hardwareTypes.length; i++) {
            allParts.add(new HardwarePart(hardwareTypes[i]));
        }
        enabledParts.addAll(generateParts(RobotFabriqueSimulationService.INITIAL_PARTS));
    }

    public static Fabrique getInstance() {
        Fabrique localInstance = instance;
        if (localInstance == null) {
            synchronized (Fabrique.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Fabrique();
                }
            }
        }

        return localInstance;
    }

    public List<Part> generateParts(Integer amountToGenerate) {
        int amount = amountToGenerate == null ? random.nextInt(RobotFabriqueSimulationService.MAX_GENERATED_PARTS) + 1 : amountToGenerate;
        List<Part> result = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            result.add(getRandomPart());
        }
        return result;
    }

    private Part getRandomPart() {
        return allParts.get(random.nextInt(allParts.size()));
    }

    @Override
    public void run() {
        for (int i = 0; i < RobotFabriqueSimulationService.MAX_PERIODS; i++) {
            enabledParts.addAll(generateParts(null));
            try {
                Thread.sleep(RobotFabriqueSimulationService.NIGHT_DURATION_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
