package w14.zuul13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Player {
	
    private Room currentRoom;
    private Stack<Room> pastRooms;
    private ArrayList<Item> items;
    private int maxWeight;
	
    
    public Player(Room startRoom, int maxWeight) {
        currentRoom = startRoom;
        pastRooms = new Stack<Room>();
        items = new ArrayList<Item>();
        this.maxWeight = maxWeight;
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
        	pastRooms.push(currentRoom);
            currentRoom = nextRoom;     // 방을 변경
        }
    	return 0;
    }
    
    /**
     * 아이템을 집는다.
     * @param name 집어 들 아이템의 이름
     * @return 집어 든 아이템 (성공한 경우), null (실패한 경우)
     */
    public Item takeItem(String name) {
    	Item item = currentRoom.removeItem(name);
    	if (item != null) {
    		if (pickable(item)) {
    			items.add(item);
    		} else {
    			currentRoom.addItem(item);
    			return null;
    		}
    	} else {
    		return null;
    	}
    	return item;
    }
    
    /**
     * 지정된 아이템이 집어 들 수 있는 무게인지 판별한다.
     * 집어들 수 있나?
     * @param item 판별할 아이템
     * @return 집어들 수 있으면 true, 그렇지 않으면 false.
     */
    private boolean pickable(Item item) {
    	if ((totalWeight() + item.getWeight()) > maxWeight) {
    		return false;
    	} else {
    		return true;
    	}
    }
    
    /*
     * 이 선수가 가지고 있는 아이템들의 총 무게를 알아낸다.
     */
    private int totalWeight() {
    	int totalWeight = 0;
    	Iterator<Item> iter = items.iterator();
    	while(iter.hasNext()) {
    		totalWeight += iter.next().getWeight();
    	}
    	return totalWeight;
    }
    
    
    /**
     * 가지고 있는 아이템 중 하나를 내려 놓는다.
     * @param name 내려 놓을 아이템의 이름.
     * @return 내려 놓은 아이템 (성공한 경우), null (실패한 경우).
     */
    public Item dropItem(String name) {
    	Iterator<Item> iter = items.iterator();
    	Item item;
    	int count = 0;
    	while(iter.hasNext()) {
    		item = iter.next();
    		if (item.getName().equals(name)) {
    			items.remove(count);
    			currentRoom.addItem(item);
    			return item;
    		}
    		count++;
    	}
    	return null;
    	
    }
    
    /**
     * 선수가 가지고 있는 아이템들의 list를 반환한다.
     * 단, 반환되는 list는 수정할 수 없는 list이다.
     * @return 선수가 가지고 있는 아이템의 list.
     */
    public List<Item> getItems() {
    	return Collections.unmodifiableList(items);
    }
    
    /**
     * 이전 방으로 돌아간다.
     */
    public void back() {
    	if(!pastRooms.isEmpty()) {
    		currentRoom = pastRooms.pop();
    	}
    }
    
    /**
     * 선수가 현재 있는 방을 반환한다.
     */
    public Room getCurrentRoom() {
    	return currentRoom;
    }
    
    public int getMaxWeight() {
    	return maxWeight;
    }
    
}
