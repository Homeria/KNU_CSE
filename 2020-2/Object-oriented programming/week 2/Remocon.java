package week2;

import java.util.Scanner;

public class Remocon {

	private int volume = 0;
	private int channel = 0;
	public final static int MAX_VOLUME = 3;
	public final static int MAX_CHANNEL = 3;
	
	/**
	 * 음량을 한 단계 높인다.
	 * 현재 음량이 최대이면 음량이 바뀌지 않는다.
	 */
	public void volumeUp() {
		if (volume != MAX_VOLUME) {
			volume++;
		}
		display();
	}
	
	
	/**
	 * 음량을 한 단계 낮춘다.
	 * 현재 음량이 0이면 음량이 바뀌지 않는다.
	 */
	public void volumeDown() {
		if(volume != 0) {
			volume--;
		}
		display();
	}
	
	
	/**
	 * 한 단계 높은 번호로 채널을 변경한다.
	 * 현재 가장 높은 번호의 채널에 있다면 0번 채널로 이동한다.
	 */
	public void channelUp() {
		if (channel != MAX_CHANNEL) {
			channel++;
		} else {
			channel = 0;
		}
		display();
	}
	
	
	/**
	 * 한 단계 낮은 번호로 채널을 변경한다.
	 * 현재 0번 채널에 있다면 가장 높은 번호의 채널로 이동한다.
	 */
	public void channelDown() {
		if (channel != 0) {
			channel--;
		} else {
			channel = MAX_CHANNEL;
		}
		display();
	}
	
	
	/**
	 * 현재의 volume, channel 상태를 화면에 보여준다.
	 */
	public void display() {
		System.out.println("Volume = " + volume + ", Channel = " + channel);
	}
	
	
}
