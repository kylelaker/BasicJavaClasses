/*
 * Copyright (c) 2016 Kyle Laker
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

/**
 * A list of all 50 states (plus DC) and their abbreviations.
 *
 * @author Kyle Laker
 * @version 20160120
 */
public enum State {
    ALABAMA         ("Alabama",              "AL"),
    ALASKA          ("Alaska",               "AZ"),
    ARKANSAS        ("Arkansas",             "AK"),
    ARIZONA         ("Arizona",              "AZ"),
    CALIFORNIA      ("California",           "CA"),
    COLORADO        ("Colorado",             "CO"),
    CONNECTICUT     ("Connecticut",          "CT"),
    DC              ("District of Columbia", "DC"),
    DELAWARE        ("Delaware",             "DE"),
    FLORIDA         ("Florida",              "FL"),
    GEORGIA         ("Georgia",              "GA"),
    HAWAII          ("Hawaii",               "HI"),
    IDAHO           ("Idaho",                "ID"),
    ILLINOIS        ("Illinois",             "IL"),
    INDIANA         ("Indiana",              "IN"),
    IOWA            ("Iowa",                 "IA"),
    KANSAS          ("Kansas",               "KS"),
    KENTUCKY        ("Kentucky",             "KY"),
    LOUISIANA       ("Louisiana",            "LA"),
    MAINE           ("Maine",                "MA"),
    MARYLAND        ("Maryland",             "MD"),
    MASSACHUSETTS   ("Massachusetts",        "MA"),
    MICHIGAN        ("Michigan",             "MI"),
    MINNESOTA       ("Minnesota",            "MN"),
    MISSISSIPPI     ("Mississippi",          "MS"),
    MISSOURI        ("Missouri",             "MO"),
    MONTANA         ("Montana",              "MT"),
    NEBRASKA        ("Nebraska",             "NE"),
    NEVADA          ("Nevada",               "NV"),
    NEW_HAMPSHIRE   ("New Hampshire",        "NH"),
    NEW_JERSEY      ("New Jersey",           "NJ"),
    NEW_MEXICO      ("New Mexico",           "NM"),
    NEW_YORK        ("New York",             "NY"),
    NORTH_CAROLINA  ("North Carolina",       "NC"),
    NORTH_DAKOTA    ("North Dakota",         "ND"),
    OHIO            ("Ohio",                 "OH"),
    OKLAHOMA        ("Oklahoma",             "OK"),
    OREGON          ("Oregon",               "OR"),
    PENNSYLVANIA    ("Pennsylvania",         "PA"),
    RHODE_ISLAND    ("Rhode Island",         "RI"),
    SOUTH_CAROLINA  ("South Carolina",       "SC"),
    SOUTH_DAKOTA    ("South Dakota",         "SD"),
    TENNESSEE       ("Tennessee",            "TN"),
    TEXAS           ("Texas",                "TX"),
    UTAH            ("Utah",                 "UT"),
    VERMONT         ("Vermont",              "VT"),
    VIRGINIA        ("Virginia",             "VA"),
    WASHINGTON      ("Washington",           "WA"),
    WEST_VIRGINIA   ("West Virginia",        "WV"),
    WISCONSIN       ("Wisconsin",            "WI"),
    WYOMING         ("Wyoming",              "WY");

    private final String name;
    private final String abbreviation;

    State(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.abbreviation + " - " + this.name;
    }

    /**
     * Provides a state from a String. Matches either the name or abbreviation.
     *
     * @param s The String to parse
     * @return If the String matches a state, then the state it matches;
     * otherwise null
     */
    public static State parseState(String s) {
        for (State state : State.values()) {
            if (state.getName().equals(s) || state.getAbbreviation().equals(s)) {
                return state;
            }
        }
        return null;
    }

}
