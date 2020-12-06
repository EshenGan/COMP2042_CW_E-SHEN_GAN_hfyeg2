/**
 * @Refactor 
 *  rename package to game_app
 *  rename Main.java to FroggerApp.java
 *  remove unused imports
 *  move png  jpg piskel etc "media" files to src/main/resources
 *  edited background color for all digits and also edited background for game scenes
 * set up aggregated field here before instantiating as object in start(Stage primaryStage)
 * field data encapsulation - OO Core Concept
 * self encapsulating field to avoid direct access of field even within own class
 * create setter and getter for encapsulated field
 * method hiding for all setters and getters
 */
package game_app;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class FroggerApp extends Application {
	private int pauseflag1;
	private int pauseflag2;
	private int pauseflag3;
	private MenuPage menu;
	private ManualPage manual;
	private EasyScene easyscene;
	private MediumScene mediumscene;
	private HardScene hardscene;
	private GameSceneButtons gamescenebuttons1;
	private GameSceneButtons gamescenebuttons2;
	private GameSceneButtons gamescenebuttons3;
	private PauseScene pausescene1;
	private PauseScene pausescene2;
	private PauseScene pausescene3;

//*********************************************************************VIEW****************************************************************************
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * @Override
	 * method overriding on application class
	 */
	public void start(Stage primaryStage) throws Exception {
		setPauseflag1(0);
		setPauseflag2(0);
		setPauseflag3(0);
		primaryStage.getIcons().add(new Image("file:src/main/resources/icon-frogger-boxart-96x96.png")); 
		primaryStage.setTitle("FROGGER ARCADE GAME by E-Shen Gan"); 
		
		setMenu(new MenuPage()); //MENU SCREEN
		
  		setManual(new ManualPage()); // USER GUIDE / INFO SCREEN
       
        setEasyscene(new EasyScene());  //EASY MODE SCENE
		setGamescenebuttons1(new GameSceneButtons()); //EASY MODE SCENE BUTTONS
		getEasyscene().getGameroot1().getChildren().addAll(getGamescenebuttons1());
		setPausescene1(new PauseScene()); //PAUSE SCENE FOR EASY MODE 
 
		setMediumscene(new MediumScene()); //MEDIUM MODE SCENE 
		setGamescenebuttons2(new GameSceneButtons()); //MEDIUM MODE SCENE BUTTONS
		getMediumscene().getGameroot2().getChildren().addAll(getGamescenebuttons2());
		setPausescene2(new PauseScene()); //PAUSE SCENE FOR MEDIUM MODE
		
		setHardscene(new HardScene()); //HARD MODE SCENE
		setGamescenebuttons3(new GameSceneButtons()); //HARD MODE SCENE BUTTONS
		getHardscene().getGameroot3().getChildren().addAll(getGamescenebuttons3());
		setPausescene3(new PauseScene()); //PAUSE SCENE FOR HARD MODE

		primaryStage.setScene(getMenu().getScenemenu());     //START WITH MENU
		primaryStage.show();  
//******************************************************************CONTROLLER******************************************************************
		//BUTTONS ACTION FOR MENU SCREEN
		getMenu().getEasyplay().setOnMouseClicked(event -> { 
			primaryStage.setScene(getEasyscene().getScenegame1()); //easy level
			getEasyscene().start(); 
		});
		
		getMenu().getMediumplay().setOnMouseClicked(event -> { 
			primaryStage.setScene(getMediumscene().getScenegame2()); //medium level
			getMediumscene().start(); 
		});
		
		getMenu().getHardplay().setOnMouseClicked(event -> { 
			primaryStage.setScene(getHardscene().getScenegame3()); // hard level
			getHardscene().start(); 
		});

		getMenu().getMenumanual().setOnMouseClicked(event -> {
				primaryStage.setScene(getManual().getScenemanual()); // info screen
		});

		getMenu().getMenuexit().setOnMouseClicked(event -> {
				System.exit(0); //exit game
		});
			
		//BUTTONS ACTION FOR INFO SCREEN
	    getManual().getManualmenu().setOnMouseClicked(event -> {
	            primaryStage.setScene(getMenu().getScenemenu());
	    });

	    getManual().getManualexit().setOnMouseClicked(event -> {
	            System.exit(0); 
	    });
	    
	    //BUTTONS ACTION FOR EASY MODE SCENE
		getGamescenebuttons1().getGamepause().setOnMouseClicked(event ->{ 
			if(getPauseflag1() == 0) {
				getEasyscene().getGameroot1().getChildren().addAll(getPausescene1());
				setPauseflag1(1);
			}
			if(getGamescenebuttons1().getGamepause().isDisabled() == false) {
			getPausescene1().enable();
			getGamescenebuttons1().disable();
			getEasyscene().stop();

			}
		});

		getGamescenebuttons1().getGameexit().setOnMouseClicked(event ->{
			System.exit(0);
		});  
		
		getPausescene1().getGameresume().setOnMouseClicked(event ->{
			if(getPausescene1().getGameresume().isDisabled() == false) {
				getPausescene1().disable();
				primaryStage.setScene(getEasyscene().getScenegame1());
				getEasyscene().start();
				getGamescenebuttons1().enable();
			}			
		});
		
		//BUTTONS ACTION FOR EASY MODE PAUSE SCENE
		getPausescene1().getBacktomenu().setOnMouseClicked(event ->{
			primaryStage.setScene(getMenu().getScenemenu());
			getPausescene1().disable();
			getGamescenebuttons1().enable();
			getMenu().getPlaydropdown().setVisible(false);
		});
		
		getPausescene1().getGameExit().setOnMouseClicked(event ->{
			System.exit(0);
		});
		
		//BUTTONS ACTION FOR MEDIUM MODE SCENE
		getGamescenebuttons2().getGamepause().setOnMouseClicked(event ->{ 
			if(getPauseflag2() == 0) {
				getMediumscene().getGameroot2().getChildren().addAll(getPausescene2());
				setPauseflag2(1);
			}
			if(getGamescenebuttons2().getGamepause().isDisabled() == false) {
			getMediumscene().stop();
			getPausescene2().enable();
			getGamescenebuttons2().disable();
			}
		});

		getGamescenebuttons2().getGameexit().setOnMouseClicked(event ->{
			System.exit(0);
		});  
		
		//BUTTONS ACTION FOR MEDIUM MODE PAUSE SCENE
		getPausescene2().getGameresume().setOnMouseClicked(event ->{
			if(getPausescene2().getGameresume().isDisabled() == false) {
				getPausescene2().disable();
				primaryStage.setScene(getMediumscene().getScenegame2());
				getMediumscene().start();
				getGamescenebuttons2().enable();
			}			
		});
		
		getPausescene2().getBacktomenu().setOnMouseClicked(event ->{
			primaryStage.setScene(getMenu().getScenemenu());
			getPausescene2().disable();
			getGamescenebuttons2().enable();
			getMenu().getPlaydropdown().setVisible(false);
		});
		
		getPausescene2().getGameExit().setOnMouseClicked(event ->{
			System.exit(0);
		});
		
		//BUTTONS ACTION FOR HARD MODE SCENE
		getGamescenebuttons3().getGamepause().setOnMouseClicked(event ->{ //controller
			if(getPauseflag3() == 0) {
				getHardscene().getGameroot3().getChildren().addAll(getPausescene3());
				setPauseflag3(1);
			}
			if(getGamescenebuttons3().getGamepause().isDisabled() == false) {
			getHardscene().stop();
			getPausescene3().enable();
			getGamescenebuttons3().disable();
			}
		});

		getGamescenebuttons3().getGameexit().setOnMouseClicked(event ->{
			System.exit(0);
		});  
		
		//BUTTONS ACTION FOR HARD MODE PAUSE SCENE
		getPausescene3().getGameresume().setOnMouseClicked(event ->{
			if(getPausescene3().getGameresume().isDisabled() == false) {
				getPausescene3().disable();
				primaryStage.setScene(getHardscene().getScenegame3());
				getHardscene().start();
				getGamescenebuttons3().enable();
				}			
		});
		
		getPausescene3().getBacktomenu().setOnMouseClicked(event ->{
			primaryStage.setScene(getMenu().getScenemenu());
			getPausescene3().disable();
			getGamescenebuttons3().enable();
			getMenu().getPlaydropdown().setVisible(false);
		});
		
		getPausescene3().getGameExit().setOnMouseClicked(event ->{
			System.exit(0);
		});
	}
//******************************************************************MODEL***********************************************************************
	protected void setPauseflag1(int pauseflag1) {
		this.pauseflag1 = pauseflag1;
	}

	protected int getPauseflag1() {
		return pauseflag1;
	}

	protected void setPauseflag2(int pauseflag2) {
		this.pauseflag2 = pauseflag2;
	}
	
	protected int getPauseflag2() {
		return pauseflag2;
	}
	
	protected void setPauseflag3(int pauseflag3) {
		this.pauseflag3 = pauseflag3;
	}

	protected int getPauseflag3() {
		return pauseflag3;
	}

	protected void setMenu(MenuPage menu) {
		this.menu = menu;
	}

	protected MenuPage getMenu() {
		return menu;
	}

	protected void setManual(ManualPage manual) {
		this.manual = manual;
	}	

	protected ManualPage getManual() {
		return manual;
	}

	protected void setEasyscene(EasyScene easyscene) {
		this.easyscene = easyscene;
	}
	
	protected EasyScene getEasyscene() {
		return easyscene;
	}
	
	protected void setGamescenebuttons1(GameSceneButtons gamescenebuttons1) {
		this.gamescenebuttons1 = gamescenebuttons1;
	}

	protected GameSceneButtons getGamescenebuttons1() {
		return gamescenebuttons1;
	}

	protected void setPausescene1(PauseScene pausescene1) {
		this.pausescene1 = pausescene1;
	}
	
	protected PauseScene getPausescene1() {
		return pausescene1;
	}

	protected void setMediumscene(MediumScene mediumscene) {
		this.mediumscene = mediumscene;
	}

	protected MediumScene getMediumscene() {
		return mediumscene;
	}

	protected void setGamescenebuttons2(GameSceneButtons gamescenebuttons2) {
		this.gamescenebuttons2 = gamescenebuttons2;
	}
	
	protected GameSceneButtons getGamescenebuttons2() {
		return gamescenebuttons2;
	}

	protected void setPausescene2(PauseScene pausescene2) {
		this.pausescene2 = pausescene2;
	}
	
	protected PauseScene getPausescene2() {
		return pausescene2;
	}

	protected void setHardscene(HardScene hardscene) {
		this.hardscene = hardscene;
	}
	
	protected HardScene getHardscene() {
		return hardscene;
	}

	protected void setGamescenebuttons3(GameSceneButtons gamescenebuttons3) {
		this.gamescenebuttons3 = gamescenebuttons3;
	}
	
	protected GameSceneButtons getGamescenebuttons3() {
		return gamescenebuttons3;
	}

	protected void setPausescene3(PauseScene pausescene3) {
		this.pausescene3 = pausescene3;
	}

	protected PauseScene getPausescene3() {
		return pausescene3;
	}

}


 


