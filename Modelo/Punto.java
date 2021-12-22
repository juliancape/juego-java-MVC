package Modelo;

/**
 *@author Daniel Velasquez y Julian Cardenas
 * @since 12-08-2021
 * @version 1.0
 */
public class Punto {
    private int x;
    private int y;

    public Punto(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}
    
    
}
