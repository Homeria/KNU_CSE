package week3;

/**
 * VotingMachine을 수정하여 사용자의 입력에 따라 투표를 할 수 있도록 한 투표기
 * @author 차경호
 *
 */
public class VotingMachine2 {
	
	private static int voteDuk;
	private static int voteSun;

	
	public VotingMachine2() {
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
	
	
	/**
	 * pick에 투표한다.
	 * @param pick 투표할 곳
	 */
	public void vote(String pick) {
		if (pick.equals("떡볶이")) {
			voteForDuk();
		} else if (pick.equals("순대")) {
			voteForSun();
		}
	}
	
	
	/**
	 * pick의 득표수를 반환한다.
	 * @param pick 득표수를 반환할 목표
	 * @return pick의 득표수. pick이 없다면 0
	 */
	public int getVotes(String pick) {
		if (pick.equals("떡볶이")) {
			return getDukVotes();
		} else if (pick.equals("순대")) {
			return getSunVotes();
		} else {
			return 0;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
