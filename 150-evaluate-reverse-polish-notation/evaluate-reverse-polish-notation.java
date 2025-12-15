class Solution {
    public int evalRPN(String[] tokens) {
        
        // int ans = 0;
        String op = "+-*/";
        Stack<String> stack = new Stack<String>();

        for(String i : tokens){
            if(!op.contains(i)){
                stack.push(i);
            }else{
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int j = op.indexOf(i);

                switch(j){
                    case 0 : stack.push(String.valueOf(a+b)); break;
                    case 1 : stack.push(String.valueOf(b-a)); break;
                    case 2 : stack.push(String.valueOf(a*b)); break;
                    case 3 : stack.push(String.valueOf(b/a)); break;
                }
            }
        }

        return (Integer.valueOf(stack.pop()));
    }
}