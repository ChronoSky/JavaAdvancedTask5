import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Task5 {

    public static void main(String[] args) throws IOException {

        // получение списка слов
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/SomeWords.txt"));
        String line;
        while((line = br.readLine())!= null){
            sb.append(line);
        }
        String text = sb.toString();
        if (!text.equals("") || !text.isEmpty()){
            ArrayList<String> list = new ArrayList<>(Arrays.asList(text.replaceAll("[\\s]{2,}", " ").split(" ")));

            // сортировка по алфавиту
            Collections.sort(list);
//          for (String word : list){
//              System.out.println(word);
//          }

            // подсчет слов
            Map<String, Integer> mapList = new HashMap<>();
            for (String word : list) {
                if (!mapList.containsKey(word)) {
                    mapList.put(word, 1);
                } else {
                    int count = mapList.get(word);
                    mapList.put(word, count + 1);
                }
            }

            // вывод статистики
            for (Map.Entry<String,Integer> entry : mapList.entrySet()){
                System.out.printf("%s : %d\n", entry.getKey(), entry.getValue());
            }

            // поиск слова с наибольшим повторением
            Map.Entry<String,Integer> maxEntry = null;
            for (Map.Entry<String,Integer> entry : mapList.entrySet()){
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue())>0){
                    maxEntry = entry;
                }
            }

            if (maxEntry!=null){
                System.out.printf("Слово %s встречается в файле %d раз(а)", maxEntry.getKey() , maxEntry.getValue());
            }

        }else{
            System.out.println("Файл пустой");
        }

    }



}
