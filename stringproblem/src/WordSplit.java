import java.util.*;

/**
 * @Author gaobaishun
 * @Date 2024/6/21 上午7:24
 * imformation：
 * 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * 作者：LeetCode
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions/xa503c/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class WordSplit {

    //存储计算结果，未计算为 -1，false 为 0， true 为 1
    public List<Integer> resultSave=null;

    public boolean wordBreak(String s, List<String> wordDict) {
        resultSave=new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            resultSave.add(-1);
        }
        List<List<String>> dict=new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            dict.add(new ArrayList<>());
        }
        for (String temp:
             wordDict) {
            if(s.indexOf(temp)>-1) {


                char c = temp.charAt(0);
                int index = c - 97;
                List<String> strings = dict.get(index);

                strings.add(temp);
            }
        }

        return wordBreakChildren(s,0,dict);

    }

    public boolean wordBreakChildren(String s,int start,List<List<String>> dict){


        if(start>=s.length()){

            return true;
        }
        Integer i = resultSave.get(start);
        if(i!=-1){
            return i==0?false:true;
        }
        char c=s.charAt(start);
        List<String> dictList=dict.get(c-97);
        for (String tempStr :
                dictList) {

            //判断s从start开始的字符串是否和tempStr相等
            //if (s.indexOf(tempStr, start) > -1&&s.substring(start,start+tempStr.length()).equals(tempStr)) {
            if (s.indexOf(tempStr, start)==start) {
                if(wordBreakChildren(s,start+tempStr.length(),dict)){
                    resultSave.set(start,1);
                    return true;
                }
            }
        }

        resultSave.set(start,0);
        return false;
    }

    public boolean wordBreakChildren(String s, int low, int high, LinkedList<String> wordDict ){
        System.out.println("开始差："+low+"-"+high);
        if(low>high){
            return false;
        }
        if(high>s.length()-1){
            return false;
        }


        String tempString = s.substring(low, high+1);
        for (int j = 0; j < wordDict.size(); j++) {

            String str = wordDict.get(j);
            if(str==null){
                continue;
            }
            int i = tempString.indexOf(str);

            if(i!=-1) {
                int length = str.length();
                Boolean leftBool = i==0||wordBreakChildren(s, low, i - 1+low, wordDict);
                Boolean rightBool = (low+i+length)==high+1||wordBreakChildren(s, low+i + length,high , wordDict);
                if (leftBool && rightBool) {
                    return true;
                }else{

                    wordDict.set(j,null);
                }
            }else{
                //wordDict.set(j,null);
            }
        }
        return false;
    }



    public static void main(String[] args) {
        String s="catsandog";
        List<String> wordDict= Arrays.asList(new String[]{"cats","dog","sand","and","cat"});
        System.out.println(new WordSplit().wordBreak(s,wordDict));
        LinkedList<String> list= new LinkedList<>(Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"}));
//        for (String string:
//             list) {
//            if(string.equals("cats")){
//                string=null;
//            }
//            //System.out.println(string);
//
//        }


//        Iterator<String> iterator = list.iterator();
//        while(iterator.hasNext()){
//            String string = iterator.next();
//            if(string.equals("cats")){
//               iterator.remove();
//            }
//
//        }

//        for (int i = 0; i < list.size(); i++) {
//            String string=list.get(i);
//                        if(string.equals("cats")){
//                list.remove(string);
//            }
//            System.out.println(string);
//        }

//        for (String str :
//                list) {
//            System.out.println(str);
//        }
        System.out.println('a'-0);
    }
}
