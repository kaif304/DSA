package Question;
import java.util.Stack;

public class SimplifyPath71 {
    static String simplifyPath(String path){
        Stack<String> stack = new Stack<>();
        String[] directories = path.split("/");

        for(String directory: directories){
            if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!directory.isEmpty() && !directory.equals(".")) {
                stack.push(directory);
            }
        }

        StringBuilder ans = new StringBuilder();
        for(String s : stack){
            ans.append("/").append(s);
        }

        if(ans.isEmpty()){
            return "/";
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(simplifyPath("/.../a/../b/c/../d/./"));
        System.out.println(simplifyPath("/home/"));
    }
}
