package week7;

/**
 * 사용자가 몇 개의 몇각형을 그릴 것인지 임의로 설정하여 그림을 그리는 프로그램
 * @author 차경호
 */
public class TurtleDrive8 {

    public static void main(String[] args) {
    	
        // 생성자를 실행하여 거북이 인스턴스를 하나 생성한다.
        // (x, y)는 거북이의 초기 위치이며 theta는 거북이가 초기에 향하고 있는 방향이다.
        // 방향은 각도 단위이며 오른쪽이0도이고 위가 90도이다.
        // 평면의 왼쪽 아래 모서리 좌표는 (0.0, 0.0), 오른쪽 위 모서리 좌표는 (1.0, 1.0)이다.
        Turtle turtle  = new Turtle(0.5, 0.5, 0);	// (x, y, theta)
        
        final double SIZE = 0.2;		// 다각형의 변의 길이
        final int N = 5;				// 몇각형
        final int HOW_MANY = 30;		// 다각형 갯수
        
        for (int i = 1; i <= HOW_MANY; i++ ) {
        	drawNgon(turtle, N, SIZE);
        	turtle.turnLeft(360 / HOW_MANY);
        }

    }
    
    
    /**
     * 거북이의 현재 위치에 정다각형을 그림
     * 거북이가 현재 바라보고 있는 방향으로 우선 직진하여 한 변을 그리고
     * 왼쪽으로 돌면서 나머지 변들을 그림
     * @param turtle 거북이
     * @param n 몇각형을 그릴 것인가?
     * @param size 다각형의 변 길이
     */
    public static void drawNgon(Turtle turtle, int n, double size) {
    	
    	final double STEP = size;	// 이동 거리
        final int ANGLE = 360 / n;		// 회전 각도
        final int PAUSE = 100;		// 일시 정지 시간. milisecond 단위
    	
    	for (int i = 1; i <= n; i++) {
    		turtle.pause(PAUSE);
            turtle.goForward(STEP);
            turtle.turnLeft(ANGLE);
    	}
    	turtle.pause(PAUSE);
    	
    	
    	
    }


}
