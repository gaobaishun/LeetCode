import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author gaobaishun
 * @Date 2024/6/21 上午4:59
 * imformation：
 * 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 */
public class SplitHuiWenString {
    public Map<Integer,Boolean> result=new HashMap<>();

    public List<List<String>> partition(String s) {
        int hi=s.length()-1;
        char[] charArray = s.toCharArray();
        return childrenString(hi,charArray);
    }

    //查找以s[hi]字母组成的回文字符串
    public List<List<String>> childrenString(int hi,char[] charArray){


        String huiWen=null;
        List<List<String>> lists = new ArrayList<>();
        if(hi<0){
            return lists;
        }
        int findHuiWen=0;
        for (int i = hi; i >=0; i--) {

            if(i==hi){
                huiWen=String.valueOf(charArray[i]);
                findHuiWen=1;
            }else{
                if(isHuiWen(i,hi,charArray)){
                    huiWen=String.valueOf(charArray,i,hi-i+1);
                    findHuiWen=1;
                }
            }

            if(findHuiWen==1){
                List<List<String>> tempLists = childrenString(i - 1, charArray);
                if(tempLists.size()==0){
                    tempLists.add(new ArrayList<>());
                }
                for (List<String> stringList :
                        tempLists) {
                    stringList.add(huiWen);
                    lists.add(stringList);
                }
                findHuiWen=0;
            }
        }
        return lists;
    }

    public Boolean isHuiWen(int start,int end,char[] charArray){
        int key=start*charArray.length+end;
        if (result.containsKey(key)) {
            return result.get(key);
        }

        while(start<end){
            if(charArray[start++]!=charArray[end--]){
                result.put(key,false);
                return false;
            }
        }
        result.put(key,true);
        return true;
    }

    public static void main(String[] args) {
        Integer i=10;
        new SplitHuiWenString().test1(i);
        System.out.println(i);

        System.out.println(new SplitHuiWenString().partition("a"));
    }

    public void test1(Integer i){
        i=i-1;
        System.out.println(i);
    }
}
