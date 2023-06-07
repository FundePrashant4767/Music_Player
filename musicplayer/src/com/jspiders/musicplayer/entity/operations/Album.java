package com.jspiders.musicplayer.entity.operations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import com.jspiders.musicplayer.entity.Song;

public class Album {
	 private static ArrayList<Album> albums = new ArrayList<>();
	 static Scanner sc = new Scanner(System.in);
	private String name;
	private String artist;
	private ArrayList<Song> songs;
	
	public Album(String name){
		this.name = name;
		
		this.songs = new ArrayList<Song>();
	}
	
	public Song findSong(String title) {
		for(Song checkSong:songs) {
			if(checkSong.getTitle().equals(title)) {
				return checkSong;
			}
			
		}
		return null;
	}
	
	public boolean addSong(String title, double duration,String singer){
        if(findSong(title) == null){
            songs.add(new Song(title,duration,singer));
            System.out.println(title + " successfully added to the list");
            return true;
        }
        else {
            System.out.println("Song with name "+ title+ " already exist in the list");
            return false;
        }
    }
	
	public boolean addToPlayList(String title,LinkedList<Song> PlayList) {
		for(Song checkSong:this.songs) {
			if(checkSong.getTitle().equals(title)) {
				PlayList.add(checkSong);
				return true;
			}
			
		}
		return false;
	}
	public static void add(LinkedList<Song> playList) {
		
		System.out.println("Enter the count:\n");
		int n = sc.nextInt();
		
		Album album = new Album("first");
		for(int i = 0;i<n;i++) {
			sc.nextLine();
			System.out.println("Enter name:\n");
			String name = sc.nextLine();
			
			System.out.println("Enter duration:\n");
			double duration = sc.nextDouble();
			sc.nextLine();
			System.out.println("Enter singer:\n");
			String singer = sc.nextLine();
			album.addSong(name, duration, singer);
			albums.add(album);
			albums.get(i).addToPlayList(name, playList);
		}
		System.out.println("1.Play Song\n"+"2.Add/Remove Song\n"+"3.Exit");
			
	}
	
	public static void showAll(LinkedList<Song> playList) {

		Iterator<Song> iterator = playList.iterator();
        System.out.println("-----------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(playList.size()); 

        System.out.println("-----------------");
        System.out.println("1.Play Song\n"+"2.Add/Remove Song\n"+"3.Exit");
		
	}
	
	public static void chooseRandom(LinkedList<Song> playList) {
		int n = (playList.size());
		System.out.println(n);
		int random = (int) (Math.random()*n);
        System.out.println("-----------------");
        System.out.println(playList.get(random));
        System.out.println(random);
        System.out.println("-----------------");
        System.out.println("1.Play Song\n"+"2.Add/Remove Song\n"+"3.Exit");
	}
	
	public static void delete(LinkedList<Song> playList) {
		ListIterator<Song> listIterator = playList.listIterator();
		listIterator.next();
		listIterator.remove();
		if(playList.size()>0) {
			if(listIterator.hasNext()){
                System.out.println("now playing "+listIterator.next().toString());
            }
            else {
                if(listIterator.hasPrevious())
                System.out.println("now playing "+listIterator.previous().toString());
            }
		}
		System.out.println("1.Play Song\n"+"2.Add/Remove Song\n"+"3.Exit");
	}
	
	
}
