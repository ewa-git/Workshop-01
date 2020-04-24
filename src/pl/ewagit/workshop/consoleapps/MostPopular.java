package pl.ewagit.workshop.consoleapps;

import jdk.swing.interop.SwingInterOpUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class MostPopular {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        StringBuilder sb = new StringBuilder();
        Path path = Paths.get("popular_words.txt");
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            System.out.println("nie udało się stworzyć pliku");
        }
        Connection connect = Jsoup.connect("http://wwww.onet.pl/");
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");

            for (Element elem : links) {
//                System.out.println(elem.text());
                sb.append(elem.text()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.writeString(path, sb);
        } catch (IOException e) {
            System.out.println("nie mozna zapiac pliku");
        }
        String line = sb.toString();
        String[] popularWords = line.split("[ .,!?:\"\n]");
        String[] excludedWords = {"ponieważ", "oraz", "gdyby", "jest", "było", "można", "może", "chciał", "chciała"};
        boolean isTrue;
        try {
            FileWriter fileWriter = new FileWriter("filtered_popular_words.txt");
            for (int i = 0; i < popularWords.length; i++) {
                isTrue = true;
                if (popularWords[i].length() > 3) {
                    for (int j = 0; j < excludedWords.length; j++) {
                        if (popularWords[i].equalsIgnoreCase(excludedWords[j])) {
                            isTrue = false;
                            break;
                        }
                    }
                    if (isTrue == true) {
                        fileWriter.append(popularWords[i]).append(" ").append("\n");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("wystąpił błąd zapisu");
            e.printStackTrace();
        }
    }


}
