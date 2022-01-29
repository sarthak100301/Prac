class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        if(heights.size()==1)
            return heights[0];
        
        heights.push_back(0);
        // for(auto h:heights)
        //     cout << h << " " ;
        //cout << endl << endl;
        
        stack<int> s;
        int ans = 0;
        for(int i=0;i<heights.size();i++){
            while(!s.empty() && heights[s.top()] >= heights[i]){ //cur < top
                //cout << "now i: " << i << " top: " << s.top() << " h: " <<  heights[s.top()] << " ";
                int top_idx = s.top();
                s.pop();
                int width = s.empty() ? i : i- s.top()-1 ;
                //cout << " width: " << width << " w*h: " << width*heights[top_idx] << endl;
                ans = max(ans,width*heights[top_idx]);
            }
            s.push(i);
            
        }
        
        return ans;
    }
};
