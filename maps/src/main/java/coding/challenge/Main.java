package coding.challenge;

public class Main {
    public static void main(String[] args){
        CustomMap<String, Integer> map = new CustomMap();
        map.put("Isaac", 1);
        map.put("Tom", 2);

        System.out.println("Isaac value is: " + map.get("Isaac"));

        map.remove("Tom");

        System.out.println(map);
    }
}
