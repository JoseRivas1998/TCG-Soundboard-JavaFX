package com.tcg.soundboard;

import com.tcg.soundboard.sounds.Sound;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private MediaPlayer bgSong;
	boolean bgPlaying;
	
	private Sound[] sounds = {
		new Sound("tru.mp3", "TRU"),
		new Sound("gimme-dat-pussy.mp3", "Gimme dat pussy"),
		new Sound("lemon.mp3", "I'M A LEMON"),
		new Sound("normies.mp3", "Fucking Normies"),
		new Sound("allahu-akbar.mp3", "ALLAHU AKBAR"),
		new Sound("nobody-gives-a-shit.mp3", "Nobody gives a shit"),
		new Sound("now-thats-edgy-as-fuck.mp3", "Edgy as fuck"),
		new Sound("fuck-you.mp3", "Fuck you"),
		new Sound("khaled-woo.mp3", "DJ Khaled Woo"),
		new Sound("bradberry.mp3", "I'M ETHAN BRADBERRY"),
		new Sound("you-mad-bro.mp3", "You mad bro?"),
		new Sound("prettygood.mp3", "That's pretty good"),
		new Sound("aint-having-that-shit.mp3", "I ain't having that shit"),
		new Sound("am-i-dead-yet.mp3", "Am I dead yet?"),
		new Sound("spirits-be-gone.mp3", "Spirits be gone from this house"),
		new Sound("schindlers-list-hd.mp3", "Schindler's List: HD Remix"),
		new Sound("1910-scary.mp3", "1910 times were SCARY"),
		new Sound("not-even-once.mp3", "NOT EVEN ONCE"),
		new Sound("here-comes-the-clarke.mp3", "Here Comes the Clarke"),
		new Sound("wednesday_1.mp3", "It is Wednesday, my dudes"),
		new Sound("wednesday_2.mp3", "Wednesday AH")
	};

	@Override
	public void start(Stage arg0) throws Exception {
		Stage window = arg0;
		window.setTitle("TCG Soundboard");
		
		bgSong = new MediaPlayer(new Media(getClass().getResource("DarudePumkin.mp3").toString()));
		bgSong.play();
		bgPlaying = true;
		
		Button[] buttons = new Button[sounds.length];
		
		for(int i = 0; i < sounds.length; i++) {
			buttons[i] = sounds[i].getButton();
		}
		
		Button playAll = new Button("Play All");
		playAll.setOnAction(e -> {
			for(Sound s : sounds) {
				s.play();
			}
		});
		
		Button playPause = new Button("Pause Song");
		playPause.setOnAction(e -> {
			if(bgPlaying) {
				bgSong.pause();
				playPause.setText("Play Soung");
			} else {
				bgSong.play();
				playPause.setText("Pause Soung");
			}
			bgPlaying = !bgPlaying;
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().add(playAll);
		layout.getChildren().addAll(buttons);
		layout.getChildren().add(playPause);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(20, 20, 20, 20));
		ScrollPane pane = new ScrollPane();
		pane.setContent(layout);
		pane.setHbarPolicy(ScrollBarPolicy.NEVER);
		pane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		Scene scene = new Scene(pane);
		window.setScene(scene);
		window.setMaxHeight(java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2);
		window.setResizable(false);
		window.show();
	}

}
