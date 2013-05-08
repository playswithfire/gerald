package LogoGame;

import java.io.*;
import java.util.*;

public class NewClass {

	//comment does not affect anything
	public static void main(String[] args) {
		ArrayList<String> Pics = new ArrayList<String>();
		ArrayList<String> ans = new ArrayList<String>();
		
		File pictures = new File("pictures.txt");
		File answers = new File("answers.txt");
		
		try{
			Scanner in = new Scanner(pictures);
			
			while(in.hasNextLine()){
				Pics.add(in.nextLine());
			}
			in = new Scanner(answers);
			
			while(in.nextLine() != null){
				ans.add(in.nextLine());
			}
		}catch(Exception e){
			
		}System.out.println(Pics);
		System.out.println(ans);
	}

}
