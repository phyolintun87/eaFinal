package mum.ea.dto;

import mum.ea.domain.Command;

public class ResourceDTO {
	private Command command;
	private Object payLoad;
	 
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
	public Object getPayLoad() {
		return payLoad;
	}
	public void setPayLoad(Object payLoad) {
		this.payLoad = payLoad;
	}		
	
}
