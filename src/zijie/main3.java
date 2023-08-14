package zijie;

import easy.AddBinary;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dictionary root = new Dictionary();
        root.setName(".");
        root.setChildren(new HashMap<>());
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] strings = sc.nextLine().split("/");
            addTree(root,strings,0);
        }

        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++){
            String[] strings = sc.nextLine().split(" ");
            move(root, strings[1], strings[2]);
        }
        Map<String,Integer> map = new TreeMap<>();
        addMap(root,map);
        System.out.println(map.size() - 1);
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            if (!entry.getKey().equals(".")){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    public static void addTree(Dictionary root, String[] strings, int index){
        if (index == strings.length - 1){
            return;
        }
        if (root.getName().equals(strings[index])){
            Map<String, Dictionary> children = root.getChildren();
            if (children.containsKey(strings[index + 1])){
                addTree(root.getChildren().get(strings[index + 1]), strings,++index);
            }else {
                Dictionary dictionary = new Dictionary();
                dictionary.setName(strings[index + 1]);
                dictionary.setChildren(new HashMap<>());
                children.put(strings[index + 1], dictionary);
                addTree(dictionary,strings,++index);
            }
        }
        else {
            addTree(root, strings, ++index);
        }
    }
    public static void move(Dictionary root, String dir1, String dir2){
        Dictionary src = getMoveToSrc(root,dir1);
        Dictionary to = getMoveTo(root,dir2);
        Map<String,Dictionary> children = to.getChildren();
        children.put(src.getName(),src);
    }
    public static Dictionary getMoveTo(Dictionary root, String s){
        if (root == null){
            return null;
        }
        Dictionary res = null;
        if (root.getName().equals(s)){
            res = root;
        }else {
            for (Map.Entry<String, Dictionary> entry : root.getChildren().entrySet()){
                res = getMoveTo(entry.getValue(), s);
            }
        }
        return res;
    }
    public static  void addMap(Dictionary root, Map<String, Integer> map){
        if (root == null){
            return;
        }
        int size = getCount(root);
        map.put(root.getName(),size);
        for (Map.Entry<String,Dictionary> entry : root.getChildren().entrySet()){
            addMap(entry.getValue(),map);
        }
    }
    public static int getCount(Dictionary root){
        if (root == null){
            return 0;
        }
        int size = 0;
        for (Map.Entry<String,Dictionary> entry : root.getChildren().entrySet()){
            size += getCount(entry.getValue());
        }
        return size + root.getChildren().size();
    }
    public static Dictionary getMoveToSrc(Dictionary root, String s){
        if (root.getChildren() == null || root.getChildren().size() == 0){
            return root;
        }
        Map<String, Dictionary> children = root.getChildren();
        if (children.containsKey(s)){
            Dictionary dictionary = children.get(s);
            children.remove(s);
            return dictionary;
        } else {
            for (Map.Entry<String,Dictionary> entry : root.getChildren().entrySet()){
                return getMoveToSrc(entry.getValue(),s);
            }
        }
        return null;
    }

}
class Dictionary{
    private String name;
    private Map<String, Dictionary> children;
    public Dictionary(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Dictionary> getChildren() {
        return children;
    }

    public void setChildren(Map<String, Dictionary> children) {
        this.children = children;
    }
}
