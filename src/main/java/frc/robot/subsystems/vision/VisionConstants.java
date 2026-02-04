package frc.robot.subsystems.vision;

import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;

public class VisionConstants {
    public static AprilTagFieldLayout aprilTagLayout =
            AprilTagFieldLayout.loadField(AprilTagFields.k2024Crescendo);


    public static double maxAmbiguity = 0.3;
    public static double maxZError = 0.75;

    public static double linearStdDevBaseline = 0.02; // Meters
    public static double angularStdDevBaseline = 0.06; // Radians

    public static double[] cameraStdDevFactors = new double[] {1.0, 1.0};

    public static double linearStdDevMegatag2Factor = 0.5;
    public static double angularStdDevMegatag2Factor = Double.POSITIVE_INFINITY;

    public static Transform3d frontCamTrans =
            new Transform3d(
                    new Translation3d(
                            Units.inchesToMeters(17),
                            Units.inchesToMeters(0),
                            Units.inchesToMeters(21)),
                    new Rotation3d(0, Math.toRadians(180), Math.toRadians(180)));
}
