class Solution {
public:
    bool solve(vector<pair<int, int>>& arr)
    {
        if(arr.empty()) return false;
        sort(arr.begin() , arr.end());
        
        int last_end = -1;
        int sections = 0;
        for( auto arrs : arr)
        {
            int st = arrs.first;
            int end = arrs.second;
            if(st >= last_end)
            {
                last_end = end;
                sections++;
            }
            else
            {
                last_end = max(last_end , end);
            }
        }
         return (sections>= 3);
    }

    bool checkValidCuts(int n, vector<vector<int>>& rectangles) {
        vector<pair<int,int>>horizontal ,vertical;
        for(auto &rect : rectangles)
        {
            horizontal.push_back({rect[1] , rect[3]});
            vertical.push_back({rect[0] , rect[2]});
        }
        return solve(horizontal) || solve(vertical);
   
    }
};