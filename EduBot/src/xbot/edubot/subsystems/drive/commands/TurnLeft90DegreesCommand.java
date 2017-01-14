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
	XSpeedController frontLeft;
	XSpeedController frontRight;
	XSpeedController rearLeft;
	XSpeedController rearRight;
	
	boolean fullPower = true;
	
	public TurnLeft90DegreesCommand(WPIFactory factory) {
	gyro = new MockHeadingSensor();
	
	frontLeft = factory.getSpeedController(1);
	rearLeft = factory.getSpeedController(3);
	frontRight = factory.getSpeedController(2);
	rearRight = factory.getSpeedController(4);
}
	
	@Inject
	public TurnLeft90DegreesCommand(DriveSubsystem driveSubsystem) {
		this.drive = driveSubsystem;
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
	}



}
