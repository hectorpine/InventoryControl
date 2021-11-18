package application.model;

public class Delete {
	
	
	public static int find(int key,ViewList list) {
		int i = 0;
		
		for(i=0; i < list.inventory.size(); ++i) {
			
			if(key == list.inventory.get(i).getId()) {
				
				System.out.println(list.inventory.get(i));
				return i;
			}
		}
		
		return -1;
		
	}
		
	

}
