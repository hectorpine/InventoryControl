package application.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Update {
	
	
	
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
	
	public static void updateCsv(ViewList newList) {
		

		try {
			Files.write(Paths.get("data/groceries.csv"), ("").getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < newList.getInventory().size(); ++i) {
			
			Item addition = newList.getInventory().get(i);
			try {
				Files.write(Paths.get("data/groceries.csv"), (addition.getId()+","+addition.getName()+"\n").getBytes(), StandardOpenOption.APPEND);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
