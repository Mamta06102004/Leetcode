class Solution {
public:

    bool isVowel(char ch)
    {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    long long countOfSubstrings(string word, int k) {
        int n  = word.size();
        int left = 0 ;
        long long count = 0;
        int vowelCount = 0 ;
        int constCount = 0 ;
        unordered_map<char ,int>hash;
        vector<int>indx(n);
        int nextconst = n;
        for(int i = n-1 ; i >= 0;i--)
        {
            indx[i] = nextconst;
            if(!isVowel(word[i]))
            {
                nextconst = i;
            }
        }
        for(int right = 0 ; right < word.size() ; right++)
        {
            if(isVowel(word[right]))
            {
                if(hash[word[right]] == 0) 
                {
                    vowelCount++;
                }
                hash[word[right]]++;
            }
            else
            {
                constCount++;
            }
            while(constCount > k)
             {
                if(isVowel(word[left]))
                {
                    hash[word[left]] --;
                    if(hash[word[left]] == 0)
                    {
                       vowelCount--;
                    }          
                }
                else
                {
                    constCount--;
                }
                left++;
            }
            while(vowelCount == 5 && constCount == k)
            {
                count += (indx[right] - right)  ;
                 char ch = word[left];
                 if(isVowel(ch))
                 {
                    hash[ch]--;
                    if(hash[ch] == 0)
                    {
                        vowelCount--;
                    }
                 }
                 else
                 {
                    constCount--;
                 }
                 left++;
            }
        }
        return count;
    }
};
    