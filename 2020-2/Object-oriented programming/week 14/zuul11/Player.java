package w14.zuul11;

public class Player {
	
    private Room currentRoom;
    private Room recentRoom;
	
    
    public Player(Room startRoom) {
        currentRoom = startRoom;
        recentRoom = startRoom;
    }
    
    
    /**
     * 주어진 방향으로 옮겨간다.
     * 그 방향으로 출구가 없으면 현재 위치에 머문다
     * @param direction 옮겨갈 방향
     * @return 성공했으면 0, 실패했으면 -1
     */
    public int moveTo(String direction) {
    	
    	Room nextRoom = null;
        nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            return -1;
        }
        else {
        	recentRoom = currentRoom;
            currentRoom = nextRoom;     // 방을 변경
        }
    	return 0;
    }
    
    
    /**
     * 이전 방으로 돌아간다.
     */
    public void back() {
    	currentRoom = recentRoom;
    }
    
    /**
     * 선수가 현재 있는 방을 반환한다.
     */
    public Room getCurrentRoom() {
    	return currentRoom;
    }
    
}
