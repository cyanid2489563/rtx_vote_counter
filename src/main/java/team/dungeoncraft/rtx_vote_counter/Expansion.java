package team.dungeoncraft.rtx_vote_counter;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class Expansion extends PlaceholderExpansion {
    private Rtx_vote_counter plugin;

    Expansion(Rtx_vote_counter plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getIdentifier() {
        return "voteCounter";
    }

    @Override
    public String getAuthor() {
        return "Cyanide";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public boolean persist(){
        return true;
    }

    @Override
    public boolean canRegister(){
        return true;
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        String args = identifier.toLowerCase().replace("voteCounter_", "");
        /*
        if (args.contains("playerVotes")) {
            return plugin.getItem(args.replace("_playerVotes", "")).getPlayerVotes();
        }
        */
        if (args.contains("votes")) {
            return plugin.getItem(args.replace("_votes", "")).getVotes();
        }
        if (args.contains("rank")) {
            return plugin.getItem(args.replace("_rank", "")).getRank();
        }
        return "";
    }
}
