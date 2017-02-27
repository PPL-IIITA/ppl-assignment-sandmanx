import java.io.*;

import java.io.FileReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		
		try{
			
			int i; //counter
			
			String name;
			
			int attr;//on a scale of 10
			int intel;// Common to boys and girls
			int budget;// Boys only attribute
			int min_attr;// Common to boys and girls
			int maintain;// Girls only attribute
			int relation_criterion; //Girls only attribute
			String type; // Common Property
			int price,value; //Property of Gifts
			
			String dir = System.getProperty("user.dir");
			
			//Info from boys.txt
			String location =(dir+"/src/boys.txt");
		
			Scanner br = new Scanner(new FileReader(location));
			ArrayList <Boy> boy_arr = new ArrayList<>();
			int no_of_boys = 10;
			
			//no_of_boys=10;
			for (i = 1; i <= no_of_boys; i++){
				
				
				name = br.next();
				attr = br.nextInt();
				intel = br.nextInt();
				budget = br.nextInt();
				min_attr = br.nextInt();
				type = br.next();
				
				
				Boy boy = new Boy(name, attr, intel, budget, min_attr, type);
				boy_arr.add(boy);
				
			}
			
			//Info from girls.txt
			
			
			location =(dir+"/src/girls.txt");
			br = new Scanner(new FileReader(location));
			ArrayList <Girl> girl_arr = new ArrayList<>();
			int no_of_girls = 6;
			
			//no_of_girls=Integer.parseInt(br.readLine());
			for (i = 1; i <= no_of_girls; i++){
				
				
				name = br.next();
				attr = br.nextInt();
				intel = br.nextInt();
				maintain = br.nextInt();
				relation_criterion = br.nextInt();
				type = br.next();
				
				Girl girl = new Girl(name, attr, intel, maintain, relation_criterion, type);
				girl_arr.add(girl);
				
			}
			
			// Making Couples
			ArrayList <Couple> couple_arr = new ArrayList<>();
			int j, k;
			for(i = 0, k = 0; i < no_of_boys; i++){
				for (j = 0; j < no_of_girls; j++){
					if (girl_arr.get(j).getCommitment() == false && boy_arr.get(i).getCommitment() == false && boy_arr.get(i).getBudget() >= girl_arr.get(j).getMaintain() && girl_arr.get(j).getAttraction() >= boy_arr.get(i).getMinimumAttraction() ){
						boy_arr.get(i).setCommitment(true);
						girl_arr.get(j).setCommit(true);
						
						Couple newCouple = new Couple(boy_arr.get(i), girl_arr.get(j));
						couple_arr.add(newCouple);
						k++;
						break;
						
					}
				}
			}
			
			// Reading from Gifts.txt
			
			location =(dir+"/src/gifts.txt");
			br = new Scanner(new FileReader(location));
			ArrayList <Gift> gift_arr = new ArrayList<>();
			int no_of_gifts = 7;
			
			
			for (i = 1; i <= no_of_gifts; i++){
				
				
				name = br.next();
				price = br.nextInt();
				value = br.nextInt();
				type = br.next();
				
				Gift gift = new Gift(name, price, value, type);
				
				gift_arr.add(gift);
				
			}
			//Printing Couples made (Output)
			
			/*for(i = 0; i < k; i++){
				System.out.println(couple_arr.get(i).name);
			}*/
			//Gift Distribution
			
			Collections.sort(gift_arr, new Comp());//Sorting according to the price
			int limit, cost;
			for(i = 0; i < couple_arr.size(); i++) {
				if(couple_arr.get(i).boy.getType() == "generous") {
					limit = couple_arr.get(i).boy.getBudget();
					cost = 0;
					k = 0;
					
					while(cost < limit){
						cost = cost + gift_arr.get(k).getCost();
						couple_arr.get(i).gift_arr.add(gift_arr.get(k));
						k++;
					}
					if (cost > couple_arr.get(i).boy.getBudget()){
						cost = cost - gift_arr.get(k-1).getCost();
						k--;
						couple_arr.get(i).gift_arr.remove(k);
						
					}
					couple_arr.get(i).price = cost;
				}
				
				else if( couple_arr.get(i).boy.getType() == "miser"){
					limit = couple_arr.get(i).girl.getMaintain();
					cost = 0;
					k=0;
					while(cost < limit) {
						cost += gift_arr.get(k).getCost();
						couple_arr.get(i).gift_arr.add(gift_arr.get(k));
						k++;
					}
					couple_arr.get(i).price = cost;
				}
				else{
					limit = couple_arr.get(i).boy.getBudget();
					cost = 0;
					k = 0;
					while(cost < limit){
						cost += gift_arr.get(k).getCost();
						couple_arr.get(i).gift_arr.add(gift_arr.get(k));
						k++;
					}
					couple_arr.get(i).price = cost;
				}
				
			}
			
			//Calculate Happiness and Compatibility
			
			int girl_happ = 0, boy_happ = 0, couple_happ = 0;
			int final_cost;
			for( i = 0; i<couple_arr.size();i++){
				
				price = couple_arr.get(i).price;
				final_cost = couple_arr.get(i).girl.getMaintain();
				
				if(couple_arr.get(i).girl.getType() == "choosy"){
					girl_happ = (int)Math.log10(price-final_cost);
					
				}
				else if(couple_arr.get(i).girl.getType() == "desparate"){
					girl_happ = (int)Math.exp(price-final_cost);
				}
				else if (couple_arr.get(i).girl.getType() == "normal"){
					girl_happ = (int)(price-final_cost);
				}
				
				
				
				if(couple_arr.get(i).boy.getType() == "generous"){
					boy_happ = girl_happ;
				}
				else if(couple_arr.get(i).boy.getType() == "miser"){
					boy_happ = couple_arr.get(i).boy.getBudget();
				}
				else if(couple_arr.get(i).boy.getType() == "geek"){
					boy_happ = couple_arr.get(i).girl.getIntelligence();
				}
				
				couple_happ = girl_happ + boy_happ;
				//couple_arr.get(i).girl.happiness = girl_happ;
				
			}
			
		}catch(IOException | NumberFormatException e){
			System.out.println(e);
		
		}
	}
}

	

