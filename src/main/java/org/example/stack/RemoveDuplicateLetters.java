package org.example.stack;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        // 统计每个字符出现的频率
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        // 用来记录栈中是否存在某个字符
        boolean[] inStack = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // 当前字符的计数减1，因为我们遍历了这个字符
            charCount[c - 'a']--;

            // 如果当前字符已经在栈中，跳过
            if (inStack[c - 'a']) {
                continue;
            }

            // 保证栈中的字符的字典序最小
            while (!stack.isEmpty() && stack.peek() > c && charCount[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() - 'a'] = false;
            }

            // 将当前字符压入栈，并标记其存在于栈中
            stack.push(c);
            inStack[c - 'a'] = true;
        }

        // 将栈中的字符组合成最终结果
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters solution = new RemoveDuplicateLetters();
        System.out.println(solution.removeDuplicateLetters("bcabc"));    // 输出: "abc"
        System.out.println(solution.removeDuplicateLetters("cbacdcbc")); // 输出: "acdb"
    }
}