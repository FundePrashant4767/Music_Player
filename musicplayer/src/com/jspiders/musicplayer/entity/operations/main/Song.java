package com.jspiders.musicplayer.entity.operations.main;

public class Song {
	String title;
	double duration;
	String singer;
	
	public Song(String title,double duration,String singer){
		this.title = title;
		this.duration = duration;
		this.singer = singer;
	}
	
	@Override
	public String toString() {
		return "Title: "+title+" duration: "+duration+" singer: "+singer;
	}
	
	public String getTitle() {
		return title;
	}
}
