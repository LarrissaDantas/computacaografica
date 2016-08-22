package br.edu.uepb.cg.retas;

/**
 * Representa um ponto
 *
 * @author Douglas Rafael
 */
public class Ponto {

    private float x;
    private float y;

    public Ponto(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Ponto)) {
            return false;
        }

        Ponto other = (Ponto) obj;

        if (Float.floatToIntBits(this.x) == Float.floatToIntBits(other.x)) {
            return false;
        }
        if (Float.floatToIntBits(this.y) != Float.floatToIntBits(other.y)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ponto{" + "x=" + x + ", y=" + y + '}';
    }
}
