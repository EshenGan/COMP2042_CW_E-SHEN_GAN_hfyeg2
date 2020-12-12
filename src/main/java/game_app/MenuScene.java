/**@Extension
 * new class for start scene and buttons
 */
package game_app;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MenuScene{
	private Button menuplay;
	private Button easyplay;
	private Button mediumplay;
	private Button hardplay;
	private Button menumanual;
	private Button menuexit;
	private Scene scenemenu;
	private Pane menuroot;
	private VBox playdropdown;
	private HBox menuhbox;
	private ImageView img4menu;
	private Rectangle menurect;

//***************************************************CONTROLLER***************************************************************
	MenuScene() {
		// main menu scene
        setMenuroot(new Pane());
        getMenuroot().setPrefSize(800, 600);
        Image menuimg = new Image("file:src/main/resources/wallpaper-frogger-boxart-800x600.jpg",800,600,true,true);
        setImg4menu(new ImageView(menuimg));
        getMenuroot().getChildren().addAll(getImg4menu());
	    
	    // menu bar buttons
	    setMenuhbox(new HBox(10));       
	    getMenuhbox().setTranslateX(15);
	    getMenuhbox().setTranslateY(300);
	    setMenuplay(new Button("PLAY",250,30));
	    setMenumanual(new Button("MANUAL",250,30));
	    setMenuexit(new Button("EXIT",250,30));
	    getMenuhbox().getChildren().addAll(getMenuplay(), getMenumanual(), getMenuexit());
	    
	    setPlaydropdown(new VBox(10));
	    getPlaydropdown().setTranslateX(15);
	    getPlaydropdown().setTranslateY(345);
	    setEasyplay(new Button("EASY",200,30));
	    setMediumplay(new Button("MEDIUM",200,30));
	    setHardplay(new Button("HARD",200,30));
	    getPlaydropdown().getChildren().addAll(getEasyplay(), getMediumplay(), getHardplay());
	    
	    setMenurect(new Rectangle(800, 600));
	    getMenurect().setFill(Color.BLUE);
	    getMenurect().setOpacity(0.2);
	    getMenuroot().getChildren().addAll(getMenurect(), getMenuhbox(),getPlaydropdown());
	    
	    setScenemenu(new Scene(getMenuroot()));
	    
	    getPlaydropdown().setVisible(false); 
	    getMenuplay().setOnMouseClicked(event -> {
			getPlaydropdown().setDisable(false);
			getPlaydropdown().setVisible(true);
	    });
		
	}

//***********************************************************MODEL***********************************************************
	public Scene getScenemenu() {
		return scenemenu;
	}
	
	public void setScenemenu(Scene scenemenu) {
		this.scenemenu = scenemenu;
	}

	public Button getMenuplay() {
		return menuplay;
	}


	public void setMenuplay(Button menuplay) {
		this.menuplay = menuplay;
	}


	public Button getMenumanual() {
		return menumanual;
	}


	public void setMenumanual(Button menumanual) {
		this.menumanual = menumanual;
	}


	public Button getMenuexit() {
		return menuexit;
	}


	public void setMenuexit(Button menuexit) {
		this.menuexit = menuexit;
	}

	public Pane getMenuroot() {
		return menuroot;
	}

	public void setMenuroot(Pane menuroot) {
		this.menuroot = menuroot;
	}

	public Button getEasyplay() {
		return easyplay;
	}

	public void setEasyplay(Button easyplay) {
		this.easyplay = easyplay;
	}

	public Button getMediumplay() {
		return mediumplay;
	}

	public void setMediumplay(Button mediumplay) {
		this.mediumplay = mediumplay;
	}

	public Button getHardplay() {
		return hardplay;
	}

	public void setHardplay(Button hardplay) {
		this.hardplay = hardplay;
	}

	public VBox getPlaydropdown() {
		return playdropdown;
	}

	public void setPlaydropdown(VBox playdropdown) {
		this.playdropdown = playdropdown;
	}

	public HBox getMenuhbox() {
		return menuhbox;
	}

	public void setMenuhbox(HBox menuhbox) {
		this.menuhbox = menuhbox;
	}

	public ImageView getImg4menu() {
		return img4menu;
	}

	public void setImg4menu(ImageView img4menu) {
		this.img4menu = img4menu;
	}

	public Rectangle getMenurect() {
		return menurect;
	}

	public void setMenurect(Rectangle menurect) {
		this.menurect = menurect;
	}

	

}