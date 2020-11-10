package Chess;

public class CoordinateRange extends Coordinate{

    private final int LIMIT_MINIM_RANGE = 8;
    private final int LIMIT_MAX_RANGE = 8;


    public CoordinateRange(int x, int y) {
        super(x, y);
    }

    public boolean isValid() {
        if (this.x >= LIMIT_MINIM_RANGE && this.x <= LIMIT_MAX_RANGE
                && this.y >= LIMIT_MINIM_RANGE && this.y <= LIMIT_MAX_RANGE){
            return true;
        }
        return false;
    }

    public Coordinate getUserOriginCoordinate(){

        //do {
            String origin = IO.getInstance().readText("Origen (separado por comas): ");
            String[] originArray = origin.split(",");
            int originX = Integer.parseInt(originArray[0]);
            int originY = Integer.parseInt(originArray[1]);
        //}while (this.isValid());
        return new Coordinate(originX,originY);
    }
}
