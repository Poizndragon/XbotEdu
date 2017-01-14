package xbot.edubot.subsystems.drive.commands;

import com.google.inject.Inject;

import xbot.common.command.BaseCommand;
import xbot.edubot.subsystems.drive.DriveSubsystem;

public class DriveToPositionCommand extends BaseCommand {

	DriveSubsystem drive;
	
	double target;
	
	@Inject
	public DriveToPositionCommand(DriveSubsystem driveSubsystem) {
		this.drive = driveSubsystem;
	}
	
	public void setTargetPosition(double position) {
		target = position;
		// This method will be called by the test, and will give you a goal distance.
		// You'll need to remember this target position and use it in your calculations.
	}
	
	@Override
	public void initialize() {
		// If you have some one-time setup, do it here.
	}

	@Override
	public void execute() {
		if (drive.getPosition() < target)
			drive.tankDrive(1, 1);
		else
			drive.tankDrive(-1, -1);
		
		// Here you'll need to figure out a technique that:
		// - Gets the robot to move to the target position
		// - Gets the robot to stop (or at least be moving really really slowly) at the target position
		
		// How you do this is up to you. If you get stuck, ask a mentor or student for some hints!
	}
	
	@Override
	public boolean isFinished() {
		// Modify this to return true once you have met your goal, 
		// and you're moving fairly slowly (ideally stopped)
		if (Math.abs(drive.getPosition()- target) < 0.001)
		return true;
		else
			return false;
	}

}
