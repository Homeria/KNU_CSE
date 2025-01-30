package week1;

import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TicTacToe5 {
	
	
	//게임 상태를 나타내는 상수
	static final int PLAYING = 0;
	static final int DRAW = 1;
	static final int CROSS_WON = 2;
	static final int NOUGHT_WON = 3;
	
	static final int SIZE = 5;
	
	static char[][] board = new char [SIZE][SIZE];
	static Scanner scan = new Scanner(System.in);
	
	static char currentMark;
	static int x, y;
	static int state;

	
	/**
	 * 판의 사이즈를 조절할 수 있는 TicTacToe 게임. 전역변수를 사용해서 TicTacToe 2 ~ 4 내의 함수보다 더 깔끔하다.
	 * @author 차경호
	 */
	public static void main(String[] args) throws InterruptedException {
		
		
		System.out.println("Tic-Tac-Toe 게임입니다.");
		System.out.println("사람이 X, 컴퓨터가 O 입니다.");
 
		initGame();
		
		printBoard();
		
		boolean end = false;
		
		while (!end) {
			
			humanPlay();
			printBoard();
			checkGame();
			
			if (state != PLAYING) {
				end = true;
				continue;
			}
			
			TimeUnit.SECONDS.sleep(1);
			
			computerPlay();
			printBoard();
			checkGame();
			if (state != PLAYING) {
				end = true;
			}
		}
		
		printResult();
		
		scan.close();
			
		
	}
	
	
	/**
	 * 바둑판을 화면에 그린다.
	 * @param board 바둑판.
	 */
	static void printBoard() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (j == SIZE - 1) {
					System.out.println("  " + board[i][j]);
				} else {
					System.out.print("  " + board[i][j] + "|");
				}
				
			}
			for (int j = 0; j < SIZE; j++) {
				if (j != SIZE - 1) {
					System.out.print("---|");
				} else {
					System.out.println("---");
				}
					
			}
		}
		System.out.println("");
	}
	
	
	/**
	 * 변수들과 보드의 값을 초기화 한다.
	 */
	static void initGame() {
		//보드를 빈칸으로 초기화
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = ' ';
			}
		}
	}
	
	
	/**
	 * 바둑판이 꽉 찼는가?
	 * @return 꽉 찼으면 true, 그렇지 않으면 false.
	 */
	static boolean boardFull() {
		int num = 0;
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (board[i][j] != ' ') {
					num++;
				}
			}
		}
		if (num == SIZE * SIZE) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * 돌은 놓은 직후, 누가 이겼는지 검사한다.
	 * @param board 현재 바둑판 상태.
	 * @param x 놓은 점의 x 좌표
	 * @param y 놓은 점의 y 좌표
	 * @param mark 누가 승리했는지 알기 위해 바둑판 위에 그려진 마크
	 * @return 사람이 이기면 1, 컴퓨터가 이기면 0, 승패가 결정되지 않으면 -1.
	 */
	static int winOrLose() {
		
		int win = -1;
		
		//가로줄 검사
		boolean notAll = true;
		for (int i = 0; i < SIZE; i++) {
			if (board[x][i] != currentMark) {
				notAll = false;
			}
		}
		if (notAll) {
			if (currentMark == 'X') {
				win = 1;
			} else if (currentMark == 'O') {
				win = 0;
			}
		}
		
		
		//세로줄 검사
		notAll = true;
		for (int i = 0; i < SIZE; i++) {
			if (board[i][y] != currentMark) {
				notAll = false;
			}
		}
		if (notAll) {
			if (currentMark == 'X') {
				win = 1;
			} else if (currentMark == 'O') {
				win = 0;
			}
		}
		
		
		//대각선 검사 1
		if (x == y) {
			notAll = true;
			for (int i = 0; i < SIZE; i++) {
				if (board[i][i] != currentMark) {
					notAll = false;
				}
			}
			if (notAll) {
				if (currentMark == 'X') {
					win = 1;
				} else if (currentMark == 'O') {
					win = 0;
				}
			}
		}
		
		//대각선 검사2
		if (x == SIZE - (y + 1)) {
			notAll = true;
			for (int i = 0; i < SIZE; i++) {
				if (board[i][SIZE - (i + 1)] != currentMark) {
					notAll = false;
				}
			}
			if (notAll) {
				if (currentMark == 'X') {
					win = 1;
				} else if (currentMark == 'O') {
					win = 0;
				}
			}
		}
		
		return win;
	}
	
	
	
	/**
	 * 유저가 이겼는지 졌는지 무승부인지를 구분해준다.
	 */
	static void checkGame() {
		
		if (winOrLose() == 1) {
			state = CROSS_WON;
		} else if (winOrLose() == 0) {
			state = NOUGHT_WON;
		} else if (boardFull()) {
			state = DRAW;
		}
	}
	
	
	/**
	 * 게임이 끝났을 때 결과를 보여준다.
	 */
	static void printResult() {
		if (state == 2) {
			System.out.println("당신이 이겼습니다. 축하합니다.");
		} else if (state == 3) {
			System.out.println("당신이 졌습니다. 다시 도전하세요.");
		} else if (state == 1) {
			System.out.println("비겼습니다. 막상막하군요.");
		} else {
			System.out.println("[Error] printResult");
		}
	}
	
	
	/**
	 * 현재 바둑판 상태에서 (x, y)가 돌을 놓을 수 있는 점인가?
	 * @param board 현재 바둑판 상태.
	 * @param x 돌을 놓을 점의 x 좌표.
	 * @param y 돌을 놓을 점의 y 좌표.
	 * @return 가능한 점이면 true, 그렇지 않으면 false.
	 */
	static boolean isInputValid() {
		boolean valid = true;
		if ((x < 0) || (x > SIZE - 1) || (y < 0) || (y > SIZE - 1)) {
			return false;
		} else if (board[x][y] != ' ') {
			return false;
		}
		
		return valid;
	}
	
	
	/**
	 * 현재 바둑판 상태에서 사람이 돌을 놓을 자리를 입력받아 결정한다.
	 */
	static void humanPlay() {
		System.out.print("좌표(0-2 범위 정수 두 개)를 입력하세요 : ");
		x = scan.nextInt();
		y = scan.nextInt();
		
		while (!isInputValid()) {
			System.out.print("그 곳에는 놓을 수 없습니다. 좌표를 다시 입력하세요 : ");
			x = scan.nextInt();
			y = scan.nextInt();
		}
		board[x][y] = 'X';
	}
	
	
	/**
	 * 현재 바둑판 상태에서 컴퓨터가 돌을 놓을 자리를 결정한다.
	 * 값 두 개를 반환해야 하므로 두 값을 배열에 넣어 반환한다.
	 */
	static void computerPlay() {
		Random random = new Random();
		
		do {
			x = random.nextInt(SIZE);
			y = random.nextInt(SIZE);
		} while (board[x][y] != ' ');
		
		board[x][y] = 'O';
	}
	
}
