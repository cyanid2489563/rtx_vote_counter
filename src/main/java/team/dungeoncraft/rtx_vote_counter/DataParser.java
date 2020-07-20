package team.dungeoncraft.rtx_vote_counter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataParser {

    private String url = "https://rtx.mcfallout.net/vote";

    List<Item> getWebPage() {
        try {
            Document doc = Jsoup.connect(url).get();
            Element defaultVoteArea = doc.getElementById("nv-vote-area-default");
            Elements elements = defaultVoteArea.getElementsByClass("title is-6 nv-green");

            List<Item> itemList = new ArrayList<>();
            int rank = 1;
            for (Element element : elements) {
                String name = element.text().split("　")[0];
                String votes = element.text().split("：")[1];
                int playerVotes = Integer.parseInt(votes) / 3;
                itemList.add(new Item(name, votes, String.valueOf(rank), String.valueOf(playerVotes)));
                rank++;
            }

            return itemList;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
