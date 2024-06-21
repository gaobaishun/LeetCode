/**
 * @CLassName: LongestString
 * @Description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @Author: gaobaishun
 * @Date: 2018/12/30 17:56
 * @Version 1.0
 **/
public class LongestString {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }else if(s.length()==1){
            return 1;
        }
        int len=1;
        int templen=1;
        String tempString=null;
        int beginIndex=0;
        for(int i=1;i<s.length();i++){
            tempString=s.substring(beginIndex,i);
            int j=containChar(tempString,s.charAt(i));
            if(j>=0){
                templen=tempString.length()-j;
                beginIndex=beginIndex+1+j;
            }else{
                templen++;
            }
            if(templen>len) {
                len = templen;
            }
        }
        return len;
    }

    private int containChar(String s,char c){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        String s="pwwkew";
        System.out.println(new LongestString().lengthOfLongestSubstring(s));
    }

}
