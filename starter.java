
import java.util.Random;
import java.util.Scanner;

public class starter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length of the metal bar in meters:");
        double length = scanner.nextDouble();

        System.out.println("Enter the weight of the metal bar in Newtons:");
        double weight = scanner.nextDouble();

        System.out.println("Enter the number of torques you want to apply:");
        int numTorques = scanner.nextInt();

        double[] torqueMagnitudes = new double[numTorques];
        double[] torqueAngles = new double[numTorques];

        System.out.println("Enter the magnitudes and angles of the torques:");

        for (int i = 0; i < numTorques; i++) {
            System.out.println("Enter magnitude of torque " + (i + 1) + " in Newton-meters:");
            torqueMagnitudes[i] = scanner.nextDouble();

            System.out.println("Enter angle of torque " + (i + 1) + " in degrees:");
            torqueAngles[i] = scanner.nextDouble();
        }

        // Calculate the total torque
        double totalTorque = 0.0;
        for (int i = 0; i < numTorques; i++) {
            double torque = torqueMagnitudes[i] * Math.sin(Math.toRadians(torqueAngles[i]));
            totalTorque += torque;
        }

        // Find the locations that bring the bar back to static equilibrium
        System.out.println("Locations that bring the bar back to static equilibrium:");

        for (int i = 0; i < numTorques; i++) {
            double requiredTorque = -totalTorque + torqueMagnitudes[i] * Math.sin(Math.toRadians(torqueAngles[i]));
            double requiredDistance = requiredTorque / weight;
            double equilibriumPosition = length / 2 + requiredDistance;
            System.out.println("Torque " + (i + 1) + ": Distance from the left end of the bar = " + equilibriumPosition + " meters");
        }
    }
}
