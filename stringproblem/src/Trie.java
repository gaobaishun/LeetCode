import java.util.HashMap;
import java.util.Map;

/**
 * @Author gaobaishun
 * @Date 2024/6/23 上午7:54
 * imformation：
 */
public class Trie {
    public Trie() {

    }

    private Node rootNode=new Node(null);

    private class Node{
        public Node(Character character){
            this.value=character;
        }

        private Character value;

        private Boolean tailNode=false;

        private Map<Character,Node> childrenMap=new HashMap<>();

        public Character getValue() {
            return value;
        }

        public void setValue(Character value) {
            this.value = value;
        }

        public Boolean getTailNode() {
            return tailNode;
        }

        public void setTailNode(Boolean tailNode) {
            this.tailNode = tailNode;
        }

        public Map<Character, Node> getChildrenMap() {
            return childrenMap;
        }

        public void addChildren(Character c){
            childrenMap.put(c,new Node(c));
        }
    }

    public void insert(String word) {
        Node node=rootNode;
        for (int i = 0; i < word.length(); i++) {
            Character character=word.charAt(i);
            Map<Character, Node> childrenMap = node.getChildrenMap();
            if(!childrenMap.containsKey(character)){
                childrenMap.put(character,new Node(character));
            }
            node=node.getChildrenMap().get(character);
        }
        node.setTailNode(true);
    }

    public boolean search(String word) {
        Node node=rootNode;
        for (int i = 0; i < word.length(); i++) {
            Map<Character, Node> childrenMap = node.getChildrenMap();
            node = childrenMap.get(word.charAt(i));
            if(node==null){
                return false;
            }
        }
        return node.getTailNode();
    }

    public boolean startsWith(String prefix) {

        Node node=rootNode;
        for (int i = 0; i < prefix.length(); i++) {
            Map<Character, Node> childrenMap = node.getChildrenMap();
            node = childrenMap.get(prefix.charAt(i));
            if(node==null){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("dd");
        Trie trie=new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
