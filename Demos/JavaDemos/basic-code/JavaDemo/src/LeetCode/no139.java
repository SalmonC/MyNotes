package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class no139 {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak("leetcode", wordDict));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        for(String tmp : wordDict){
            if(s.equals(tmp))return true;
            int len = tmp.length();
            if(s.length() < len)continue;
            String comp = s.substring(0, len);
            System.out.println("tmp="+tmp);
            System.out.println("copm="+comp);
            if(tmp.equals(comp)){
                String news = s.substring(len);
                if(wordBreak(news, wordDict))return true;

                System.out.println("news="+news);
            }
        }
        return false;
    }
}
