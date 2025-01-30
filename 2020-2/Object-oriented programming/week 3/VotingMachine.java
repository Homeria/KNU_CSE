package week3;

/**
 * 인기 투표기
 * @author 차경호
 */
public class VotingMachine {
	
	private static int voteDuk;
	private static int voteSun;
	
	
	public VotingMachine() {
		voteDuk = 0;
		voteSun = 0;
	}
	
	
	/**
	 * 떡볶이에 투표
	 */
	public void voteForDuk() {
		++voteDuk;
	}
	
	
	/**
	 * 순대에 투표
	 */
	public void voteForSun() {
		++voteSun;
	}
	
	
	/**
	 * 지금까지의 투표 내용을 모두 삭제
	 */
	public void clear() {
		voteDuk = 0;
		voteSun = 0;
	}
	
	
	/**
	 * 떡볶이 득표수를 반환
	 * @return 떡볶이 득표수
	 */
	public int getDukVotes() {
		return voteDuk;
	}
	
	
	/**
	 * 순대 득표수를 반환
	 * @return 순대 득표수
	 */
	public int getSunVotes() {
		return voteSun;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
