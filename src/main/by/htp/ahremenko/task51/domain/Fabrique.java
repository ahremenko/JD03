package by.htp.ahremenko.task51.domain;

import by.htp.ahremenko.task51.service.RobotFabriqueSimulationService;

import java.util.*;
import java.util.stream.Collectors;

public class Fabrique implements Runnable {

    private static final Fabrique instance = new Fabrique();
    private List<Part> allParts;
    private final Random random = new Random();
    private List<Part> enabledParts = new ArrayList<>();

    {
        allParts = Arrays.stream(BodyType.values()).map(BodyPart::new).collect(Collectors.toList());
        allParts.addAll(Arrays.stream(HardwareType.values()).map(HardwarePart::new).collect(Collectors.toList()));
        enabledParts.addAll(generateParts(RobotFabriqueSimulationService.INITIAL_PARTS));
    }

    @Override
    public void run() {
        for (int i = 0; i < RobotFabriqueSimulationService.MAX_PERIODS; i++) {
            synchronized (enabledParts) {
                enabledParts.addAll(generateParts(random.nextInt(RobotFabriqueSimulationService.MAX_GENERATED_PARTS) + 1));
            }
            sleep(RobotFabriqueSimulationService.NIGHT_DURATION_MS);
        }
    }

    public static Fabrique getInstance() {
        return instance;
    }

    private List<Part> generateParts(int amountToGenerate) {
        List<Part> result = new ArrayList<>();
        for (int i = 0; i < amountToGenerate; i++) {
            result.add(getRandomPart());
        }
        System.out.println("Fabrique generates: " + result + ". Amount: " + result.size() + " parts,");
        return result;
    }

    private Part getRandomPart() {
        return allParts.get(random.nextInt(allParts.size()));
    }

    public List<Part> gatherParts(int count) {
        List<Part> result = new ArrayList<>();
        int size = enabledParts.size();
        if (size == 0) {
            return result;
        }
        if (size <= count) {
            synchronized (enabledParts) {
                result.addAll(enabledParts.stream().collect(Collectors.toList()));
                enabledParts.clear();
            }
        } else {
            int i = 0;
            synchronized (enabledParts) {
                while (i < count) {
                    size = enabledParts.size();
                    if (size == 0) {
                        break;
                    }
                    int j = 0;
                    if (size > 1) {
                        j = random.nextInt(size - 1);
                    }
                    result.add(enabledParts.get(j));
                    enabledParts.remove(j);
                    i++;
                }
            }
        }
        return result;
    }

    public void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
