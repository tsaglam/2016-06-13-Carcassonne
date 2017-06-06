package carcassonne.model.tile;

import static carcassonne.model.terrain.TerrainType.CASTLE;
import static carcassonne.model.terrain.TerrainType.FIELDS;
import static carcassonne.model.terrain.TerrainType.ROAD;

/**
 * Specific subclass of the class {@link Tile}.
 * @author Timur Saglam
 */
public class CastleWallRoad extends Tile {

    /**
     * Simple constructor that sets the terrain.
     */
    public CastleWallRoad() {
        super(CASTLE, ROAD, FIELDS, ROAD, FIELDS, FIELDS, FIELDS, FIELDS, ROAD);
    }
}