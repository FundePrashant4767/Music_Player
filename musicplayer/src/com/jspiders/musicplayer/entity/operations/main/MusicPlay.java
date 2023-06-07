package com.jspiders.musicplayer.entity.operations.main;
import java.util.*;
import com.jspiders.musicplayer.entity.operations.*;
public class MusicPlay {
	private static Scanner scanner = new Scanner(System.in);
	 private static ArrayList<Album> albums = new ArrayList<>();
	 private static LinkedList<com.jspiders.musicplayer.entity.Song> list1 = new LinkedList<>();
	 static Album alb = new Album("first");
	 static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		musicPlayerMenu();
		scanner.close();
	
	}
	private static void musicPlayerMenu() {
		System.out.println("please first add some songs\n");
		System.out.println("1.Play Song\n"+"2.Add/Remove Song\n"+"3.Exit");
		boolean quit = false;
		Scanner sc = new Scanner(System.in);
		while(!quit) {
			int action;
			int act;
			action  = sc.nextInt();
			
			sc.nextLine();
			switch(action) {
			
			case 1:System.out.println("1.play all songs\n"+"2.play random\n"+"3.Go Back\n");
			act  = sc.nextInt();
				switch(act) {
					case 1:System.out.println("playall");;
					Album.showAll(list1);
					break;
					case 2:System.out.println("play random");
					Album.chooseRandom(list1);
					break;
					case 3:System.out.println("go back");		
					break;
			}
			break;
			case 2:System.out.println("1.Add songs\n"+"2.remove song\n"+"3.Go Back\n");
			act  = sc.nextInt();
			switch(act) {
				case 1:Album.add(list1);;
				break;
				case 2:Album.delete(list1);	
				break;
				case 3:System.out.println("go back");
				break;
			}
			break;
			case 3:
			 System.out.println("Playlist complete");
            quit = true;
            break;
			}
		}	
	}
}
