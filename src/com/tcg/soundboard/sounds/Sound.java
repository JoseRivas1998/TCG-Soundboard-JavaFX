package com.tcg.soundboard.sounds;

import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound {

	private String fileName;
	private String title;
	private Media media;
	private Button button;
	
	public Sound(String fileName, String title) {
		this.fileName = fileName;
		this.title = title;
		media = new Media(getClass().getResource(this.fileName).toString());
		button = new Button(this.title);
		button.setOnAction(e -> {
			this.play();
		});
	}
	
	public void play() {
		MediaPlayer mediaPlayer = new MediaPlayer(this.media);
		mediaPlayer.play();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}
	
}
