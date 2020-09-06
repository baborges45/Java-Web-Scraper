import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Scraper {

    public static void main(String[] args) throws Exception{

        final Document document = Jsoup.connect(
                "https://www.amazon.com.br/gp/browse.html?node=6740748011&ref_=nav_em__books_all_0_2_22_2&nocache=1599374591556").get();
       // System.out.println(document.outerHtml());

        for (Element row : document.select("table.chart.full-width tr")) {
            final String titulo = row.select(".titleColumn a").text();
            final String rating = row.select(".imdbRating").text();
            System.out.println(titulo + " -> Rating " + rating);
        }
    }
}
