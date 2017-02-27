import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		
		try{
			
			int i; //counter
			String str;
			String name;
			
			int attr;//on a scale of 10
			int intel;// Common to boys and girls
			int budget;// Boys only attribute
			int min_attr;// Common to boys and girls
			int maintain;// Girls only attribute
			int relation_criterion; //Girls only attribute
			
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
				
				
				Boy boy = new Boy(name, attr, intel, budget, min_attr);
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
				
				Girl girl = new Girl(name, attr, intel, maintain, relation_criterion);
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
			
			//Printing Couples made (Output)
			
			for(i = 0; i < k; i++){
				System.out.println(couple_arr.get(i).name);
			}
		}catch(IOException | NumberFormatException e){
			System.out.println(e);
		
		}
	}
}

	

