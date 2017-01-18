package xbot.edubot.subsystems.drive.commands;

import com.google.inject.Inject;

import edu.wpi.first.wpilibj.MockDistanceSensor;
import xbot.common.command.BaseCommand;
import xbot.common.controls.actuators.XSpeedController;
import xbot.common.injection.wpi_factories.WPIFactory;
import xbot.edubot.rotation.MockHeadingSensor;
import xbot.edubot.subsystems.drive.DriveSubsystem;

public class TurnLeft90DegreesCommand extends BaseCommand {
	
	DriveSubsystem drive;
	public MockHeadingSensor gyro;
	
	double target;
	double previousYaw;
		
	
	@Inject
	public TurnLeft90DegreesCommand(DriveSubsystem driveSubsystem) {
		this.drive = driveSubsystem;
		gyro = drive.gyro;

	}
	
	@Override
	public void initialize() {
		double yaw = drive.gyro.getYaw();
		target = yaw + 90;
		previousYaw = yaw;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		double yaw = drive.gyro.getYaw();
		double error = target - yaw;
		double velocity = (yaw - previousYaw);
		double power = .13 * error ; //- 1 * velocity;
		System.out.println("error =" + error);
		
		drive.tankDrive(-power,power);
	}
	
	public boolean isFinished() {
		double yaw = drive.gyro.getYaw();
		if ((Math.abs(yaw - target) < 2)
		&&	(Math.abs(yaw - previousYaw) < 0.1))
		return true;
		else
		{
			previousYaw = yaw;
			return false;
		}
	}


}
