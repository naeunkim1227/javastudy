package tv;

public class TV {
	private boolean power;
	private int volume; //0~100
	private int channel; //1~255
	
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}


	public void status() {
		System.out.println("TV [power=" + (power? "on" : "off")  + ", volume=" + volume + ", channel=" + channel + "]");
	}


	public void power(boolean on) {
			power = on;
	}

	public void channel(int channel) {
		if(!power) return;
		
		if(channel > 255) {channel = 1; 
		}else if(channel<1){channel = 255;}
			
		this.channel = channel;
	}
	
	public void channel(boolean up) {
		channel += 1;
	}
	
	
	public void volume(int volume) {
		if(!power) return;
		
		if(volume > 100) {
			volume = 0;
		}else if(volume < 0){
			volume = 100;
		}
		this.volume = volume;
	}
	
	public void volume(boolean up) {
		
	}
	
	public boolean isPower() {
		return power;
	}


	public int getChannel() {
		return channel;
	}



	public int getVolume() {
		return volume;
	}


	
	
	
			

}
