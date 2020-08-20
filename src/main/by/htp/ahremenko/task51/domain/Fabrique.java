package by.htp.ahremenko.task51.domain;

import by.htp.ahremenko.task51.service.RobotFabriqueSimulationService;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Queue;

public class Fabrique implements Runnable {

    private static volatile Fabrique instance;

    private List<Part> allParts = new ArrayList<>();
    private final Random random = new Random();
    private Queue<Part> enabledParts = new LinkedList<>();

    @Setter
    private List<Assistant> assistants = new ArrayList<>();

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

    private List<Part> generateParts(int amountToGenerate) {
        List<Part> result = new ArrayList<>();
        for (int i = 0; i < amountToGenerate; i++) {
            result.add(getRandomPart());
        }
        System.out.println("Fabrique generates " + result + " parts " + "(" + result.size() + ")");
        return result;
    }

    private Part getRandomPart() {
        return allParts.get(random.nextInt(allParts.size()));
    }

    public synchronized List<Part> gatherParts(int count) {
        List<Part> result = new ArrayList<>();
        int avialableParts = Math.min(enabledParts.size(), count);
        for (int i = 0; i < avialableParts; i++) {
            result.add(enabledParts.remove());
        }
        return result;
    }

    @Override
    public void run() {
        for (int i = 0; i < RobotFabriqueSimulationService.MAX_PERIODS; i++) {
            enabledParts.addAll(generateParts(random.nextInt(RobotFabriqueSimulationService.MAX_GENERATED_PARTS) + 1));
            assistants.forEach( assistant -> assistant.gatherAndTry(gatherParts(random.nextInt(RobotFabriqueSimulationService.MAX_GENERATED_PARTS) + 1)));
            //System.out.println("Enabled parts " + enabledParts.size() + ": " + enabledParts);
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
