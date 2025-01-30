package week3;

import java.util.Random;

/**
 * VotingMachine을 테스트하는 프로그램
 * @author 차경호
 */
public class VotingSimulation {

	public static void main(String[] args) {
		
		Random random = new Random();
		VotingMachine voteMachine = new VotingMachine();
		
		for(int i = 0; i < 1000; i++) {
			
			if(random.nextBoolean()) {
				voteMachine.voteForSun();
			} else {
				voteMachine.voteForDuk();
			}
			
		}
		
		System.out.println("순대 득표수 : " + voteMachine.getSunVotes());
		System.out.println("떡볶이 득표수 : " + voteMachine.getDukVotes());
		
	}

}
