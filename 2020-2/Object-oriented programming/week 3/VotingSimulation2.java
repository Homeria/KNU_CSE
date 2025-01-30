package week3;

import java.util.Scanner;

/**
 * VotingMachine2를 테스트하는 프로그램
 * 옳은 값과 잘못된 값 입력에 따른 차이, 투표수 초기화가 정상작동하는지 보여준다.
 * @author CKH
 *
 */
public class VotingSimulation2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		VotingMachine2 voteMachine = new VotingMachine2();
		
		System.out.println("떡볶이를 입력하시오");
		System.out.print("pick : ");
		String a = input.next();
		voteMachine.vote(a);
		System.out.println("떡볶이 : " + voteMachine.getVotes("떡볶이"));
		System.out.println("순대 : " + voteMachine.getVotes("순대"));
		
		System.out.println("====================");
		
		System.out.println("순대를 입력하시오");
		System.out.print("pick : ");
		String b = input.next();
		voteMachine.vote(b);
		System.out.println("떡볶이 : " + voteMachine.getVotes("떡볶이"));
		System.out.println("순대 : " + voteMachine.getVotes("순대"));
		
		System.out.println("====================");
		
		System.out.println("떡볶이와 순대 외 다른 값을 입력하시오");
		System.out.print("pick : ");
		String c = input.next();
		voteMachine.vote(c);
		System.out.println("잘못된 득표수 반환 : " + voteMachine.getVotes(c));
		System.out.println("떡볶이 : " + voteMachine.getVotes("떡볶이"));
		System.out.println("순대 : " + voteMachine.getVotes("순대"));
		
		System.out.println("====================");
		
		System.out.println("초기화");
		voteMachine.clear();
		System.out.println("떡볶이 : " + voteMachine.getVotes("떡볶이"));
		System.out.println("순대 : " + voteMachine.getVotes("순대"));
		
		input.close();
		
	}

}
