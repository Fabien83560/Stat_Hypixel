package org.Game.Skyblock.Stats.Crimson;

import org.json.JSONObject;

import java.time.Duration;

public class Dojo {
    String name;
    String points;
    String rank;
    String time;
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

    public String getName() {
        return name;
    }

    public String getPoints() {
        return points;
    }

    public String getRank() {
        return rank;
    }

    public String getTime() {
        return time;
    }
}
