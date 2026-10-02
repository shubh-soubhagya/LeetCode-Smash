class Solution {
public:
    bool isValid(string s) {

        unordered_map<char, char> um;
        um[')'] = '(';
        um['}'] = '{';
        um[']'] = '[';

        stack<char> stk;

        for(char c:s){
            if(um.find(c) == um.end()){
                stk.push(c);
            }else{
                if(stk.empty()){
                    return false;
                }if(stk.top()!=um[c]){
                    return false;
                }
                stk.pop();
            }
        }

        return stk.empty();
        
    }
};