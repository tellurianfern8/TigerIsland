package main.players;
import main.*;
import main.enums.Direction;
import main.enums.OccupantType ;
import main.enums.TerrainType;
import main.enums.OccupantType;
import main.utils.SettlePointPair;

/**
 * Created by Rahul on 4/7/2017.
 */
public class Artificial_Intelligence extends Player
{
    private GameBoard game;
    private Player player;
    private Point point;
    private Settlement settle;
    private int row, collumn, rotation;
    //TESTING GIT ISH

    public Artificial_Intelligence(GameBoard game, int designator)
    {
        super(game, designator);
    }

    public void Place_Tile_By_AI()
    {
        ProjectionPack place;
        if(designator == 1)
        {
            game.setFirstTile();
            point = new Point(row, collumn); //Put the values
            tileHeld.setRotation(rotation);
            place = projectTilePlacement(tileHeld, point);
            place.projectedLevel = game.getProjectedHexLevel(place);
            if(game.isValidTilePlacement(place))
            {
                game.setTile(tileHeld,place);
            }
        }

        else
        {
            //HAVE SOME ISH IN HERE TO DO NUKING STUFF
        }
    }

    public void FindSettlement()
    {
        point = new Point(row, collumn);
        settle = new Settlement(game);
        if(game.isValidSettlementPosition(point))
        {
            game.setPiece(point, OccupantType.MEEPLE, settle);
        }
    }

    public void AI_ExpandSettlement()
    {
        for(SettlePointPair settlements : playerSettlements.values())
        {
            game.setPiece(point, OccupantType.MEEPLE, settlements.settlement);
        }
    }

    public void AI_PlaceTotoro()
    {
        point = new Point (row,collumn);
    }

}