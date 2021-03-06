
package game_app;

/**<b>REFACTOR</b>:
 * <p>. FactoryMethodDesignPattern : factory for all type of sprite available<br>
 * . Replace constructors with factory method<br>
 * . Factory class to create different type of sprites in game scenes</p>
 */
public class SpriteFactory {

//******************************************************VIEW*****************************************************************	

	public static Frog createFrog(String imageLink, String mode) { 
 		return new Frog(imageLink,mode);
 	}
	public static BackgroundImage createBackgroundImage(String imageLink) {
		return new BackgroundImage(imageLink);
	}
	public static Digit createDigit(int n, int dim, int x, int y) {
		return new Digit(n, dim, x, y);
	}
	public static Home createHome(int x, int y) {
		return new Home(x, y);
	}
	public static Log createLog(String imageLink, int size, int xpos, int ypos, double s) {
		return new Log(imageLink, size, xpos, ypos, s);
	}
	public static Vehicles createVehicles(String imageLink, int xpos, int ypos, int s, int w, int h) {
		return new Vehicles(imageLink, xpos, ypos, s, w, h);
	}
	public static Turtle createTurtle(int xpos, int ypos, int s, int w, int h,int dir) {
		return new Turtle(xpos, ypos, s, w, h,dir);
	}
	public static WetTurtle createWetTurtle(int xpos, int ypos, int s, int w, int h,int dir) {
		return new WetTurtle(xpos, ypos, s, w, h,dir);
	}
	public static Snake createSnake(int xpos, int ypos, int s, int w, int h,int dir) {
		return new Snake(xpos, ypos, s, w, h,dir);
	}
	
	

}
