package org.Game.Skyblock.Stats.Crimson;

import org.json.JSONObject;
import java.time.Duration;

/**
 * This class implements the Dojo statistics of
 * a player's profile in Skyblock.
 */
public class Dojo {

    /**
     * String containing the name of the current Dojo in Skyblock.
     */
    String name;

    /**
     * String containing the number of points of the player in that dojo in Skyblock.
     */
    String points;

    /**
     * String containing the rank of the player in that dojo in Skyblock.
     */
    String rank;

    /**
     * String containing the time spent by the player to complete the Dojo in Skyblock.
     */
    String time;

    /**
     * Constructor of the Dojo class. The String parameter contains
     * the name of the dojo, The JSONObject parameter
     * contains all the statistics about the Dojo mode of the player
     * in Skyblock.
     * @param _name A String containing the name of the current dojo.
     * @param dojoObject A JSONObject containing the JSON of the wanted data.
     */
    public Dojo(String _name, JSONObject dojoObject) {
        name = _name;
        int point = dojoObject.getInt("dojo_points_" + _name);
        points = String.valueOf(point);
        if (point < 200)
            rank = "F";
        else if (point < 400)
            rank = "D";
        else if (point < 600)
            rank = "C";
        else if (point < 800)
            rank = "B";
        else if (point < 1000)
            rank = "A";
        else
            rank = "S";

        double dojoTime = Double.parseDouble(String.valueOf(dojoObject.get("dojo_time_" + _name)));
        Duration duration = Duration.ofMillis((long) dojoTime);
        long seconds = duration.toSecondsPart();
        time = String.valueOf(seconds);
    }

    /**
     * Gets the 'name' member of the class.
     * @return A String Object.
     * @see Dojo#name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the 'points' member of the class.
     * @return A String Object.
     * @see Dojo#points
     */
    public String getPoints() {
        return points;
    }

    /**
     * Gets the 'rank' member of the class.
     * @return A String Object.
     * @see Dojo#rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * Gets the 'time' member of the class.
     * @return A String Object.
     * @see Dojo#time
     */
    public String getTime() {
        return time;
    }
}
