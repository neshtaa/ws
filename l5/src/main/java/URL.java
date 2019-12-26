package main.java;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class URL {
    private String url = "https://ru.wikipedia.org/wiki/Николаев";
    private Document html;

    URL(String _url) {
        url = _url;
        try{
            html = Jsoup.connect(url).get();
        } catch (Exception e){
            System.out.println("Failed to connect to " + url);
            System.exit(1);
        }
    }

    URL() {
        try{
            html = Jsoup.connect(url).get();
        } catch (Exception e){
            System.out.println("Failed to connect to " + url);
            System.exit(1);
        }
    }

    public Map<String, Integer> countTags(){
        Elements elements = html.getAllElements();
        List<String> tags = new ArrayList<>();
        for(Element e: elements) {
            tags.add(e.tag().toString());
        }
        Map<String, Integer> frequencyOfTags = new HashMap<>();
        tags.remove("#root");
        for(String str: tags) {
            if(frequencyOfTags.containsKey(str))
                frequencyOfTags.compute(str,(k,v) -> v + 1);
            else
                frequencyOfTags.put(str, 1);
        }
        return frequencyOfTags;
    }

    public static void main(String[] args) {
        URL u1 = new URL();
        Map<String, Integer> frequencyOfTags = u1.countTags();
        System.out.println("Sorted by lexicographical oder:");
        frequencyOfTags.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
        System.out.println();
        System.out.println("Sorted by frequency:");
        frequencyOfTags.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }
}
