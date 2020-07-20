package team.dungeoncraft.rtx_vote_counter;

public class Item {

    private String name;
    private String votes;
    private String rank;
    private String playerVotes;

    private Item() {

    }

    public Item(String name, String votes, String rank, String playerVotes) {
        this.name = name;
        this.votes = votes;
        this.rank = rank;
        this.playerVotes = playerVotes;
    }

    public String getName() {
        return name;
    }

    public String getVotes() {
        return votes;
    }

    public String getRank() {
        return rank;
    }

    public String getPlayerVotes() {
        return playerVotes;
    }

}
