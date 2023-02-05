// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Spark m_frontLeftMotor;
  private Spark m_frontRightMotor;
  private Spark m_rearLeftMotor;
  private Spark m_rearRightMotor;
  private MotorControllerGroup m_leftMotors;
  private MotorControllerGroup m_rightMotors;
  private DifferentialDrive m_drivetrain;
  private Joystick m_joystick;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    //TODO: Go to the Constants file and set these correctly
    m_frontLeftMotor = new Spark(Constants.FRONT_LEFT_MOTOR_ID);
    m_frontRightMotor = new Spark(Constants.FRONT_RIGHT_MOTOR_ID);
    m_rearLeftMotor = new Spark(Constants.REAR_LEFT_MOTOR_ID);
    m_rearRightMotor = new Spark(Constants.REAR_RIGHT_MOTOR_ID);
    
    //group motors for left/right control together
    m_leftMotors = new MotorControllerGroup(m_frontLeftMotor, m_rearLeftMotor);
    m_rightMotors = new MotorControllerGroup(m_frontRightMotor, m_rearRightMotor);
    
    //combine motors into differential drive
    m_drivetrain = new DifferentialDrive(m_leftMotors,m_rightMotors);

    //TODO: Go to the Constants file and set these correctly. The value for this should
    // be able to be found in the driver station, See: https://docs.wpilib.org/en/stable/docs/software/basic-programming/joystick.html
    m_joystick = new Joystick(Constants.JOYSTICK_DEVICE_ID);
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {

  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    //Note: If you have two joysticks, you can new them both up and use
    //tank drive instead. Arcade works with on stick though. See: 
    //https://docs.wpilib.org/en/stable/docs/software/hardware-apis/motors/wpi-drive-classes.html
    m_drivetrain.arcadeDrive(m_joystick.getX(), m_joystick.getY());

  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
