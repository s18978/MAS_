package mini_project_1.model;

import mini_project_1.exception.ValidationException;
import java.io.Serializable;

public class ProductDimension implements Serializable {

    private double height;
    private double width;
    private double depth;
    private double screen;

    public ProductDimension(double height, double width, double depth, double screen) {
        setHeight(height);
        setWidth(width);
        setDepth(depth);
        setScreen(screen);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if(height <= 0) {
            throw new ValidationException("height can not be negative");
        }
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width <= 0) {
            throw new ValidationException("width can not be negative");
        }
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        if(depth <= 0) {
            throw new ValidationException("depth can not be negative");
        }
        this.depth = depth;
    }

    public double getScreen() {
        return screen;
    }

    public void setScreen(double screen) {
        if(screen <= 0) {
            throw new ValidationException("screen can not be negative");
        }
        this.screen = screen;
    }

    @Override
    public String toString() {
        return "ProductDimension{" +
                "height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                ", screen=" + screen +
                '}';
    }
}