import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSplit2 {
    //存储计算结果，未计算为 -1，false 为 0， true 为 1
    public List<List<String>> resultSave=null;

    public List<String> wordBreak(String s, List<String> wordDict) {
        resultSave=new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            resultSave.add(null);
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

    public List<String> wordBreakChildren(String s,int start,List<List<String>> dict){
        List<String> result=new ArrayList<>();

//        if(start>=s.length()){
//
//            return new ArrayList<>();
//        }
        List<String> listStr = resultSave.get(start);
        if(listStr!=null){
            return listStr;
        }

        char c=s.charAt(start);
        List<String> dictList=dict.get(c-97);
        for (String tempStr :
                dictList) {

            //判断s从start开始的字符串是否和tempStr相等
            //if (s.indexOf(tempStr, start) > -1&&s.substring(start,start+tempStr.length()).equals(tempStr)) {
            if (s.indexOf(tempStr, start)==start) {
                if((start + tempStr.length())<s.length()){
                    List<String> strings = wordBreakChildren(s, start + tempStr.length(), dict);
                    if(strings!=null&&strings.size()>0){
                        List<String> tempRes=generateListStr(tempStr,strings);
                        result.addAll(tempRes);
                    }
                }else{

                    result.add(tempStr);


                }
            }
        }

        resultSave.set(start,result);
        return result;
    }

    private List<String> generateListStr(String str,List<String> stringList){
        List<String> objects = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String tempStr=stringList.get(i);

            StringBuilder sb=new StringBuilder(str);

            sb.append(" ");
            sb.append(tempStr);
            objects.add(sb.toString());

        }
        return objects;
    }

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("aa");
        list.add("bb");
        List<String> strings = new WordSplit2().generateListStr("cc", list);
        System.out.println(strings);

        String s="catsanddog";
        List<String> wordDict= Arrays.asList(new String[]{"cat","cats","and","sand","dog"});
        System.out.println(new WordSplit2().wordBreak(s,wordDict));
    }
}
