package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.controller.PIDController;

public class DrivetrainSubsystem extends SubsystemBase {
    private ShuffleboardTab tab;

    DifferentialDrive drive;

    TalonSRX frontLeft;
    TalonSRX backLeft;
    TalonSRX frontRight;
    TalonSRX backRight;

    double controlForward = 0;
    double controlSide = 0;


    public DrivetrainSubsystem() {
        tab = Shuffleboard.getTab("example subsystem");

        frontLeft = new TalonSRX(DrivetrainConstants.frontLeftID);
        backLeft = new TalonSRX(DrivetrainConstants.backLeftID);
        frontRight = new TalonSRX(DrivetrainConstants.frontRightID);
        backRight = new TalonSRX(DrivetrainConstants.backRightID);

        frontLeft.configFactoryDefault();
        backLeft.configFactoryDefault();
        frontRight.configFactoryDefault();
        backRight.configFactoryDefault();

        backLeft.follow(frontLeft);
        backRight.follow(frontRight);

        frontLeft.setInverted(true);
        backLeft.setInverted(true);
        frontRight.setInverted(false);
        backRight.setInverted(false);

        drive = new DifferentialDrive();
    }

    @Override
    public void periodic() {
        
    }
    @Override
    public void simulationPeriodic() {}

    public void setForwardMovement(double v) {
        controlForward = v;
    }
    public void setSideMovement(double v) {
        controlSide = v;
    }
}
