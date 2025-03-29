constexpr int kMod = 1000'000'007;

vector<int> GetPrimes(int limit) {
  vector<int> not_prime(limit);
  vector<int> primes;
  for (int i = 2; i < limit; ++i) {
    if (not_prime[i]) {
      continue;
    }
    primes.push_back(i);
    for (int j = i * i; j < limit; j += i) {
      not_prime[j] = 1;
    }
  }
  return primes;
}

// 400 * 400 > 10^5
const vector<int> kPrimes = GetPrimes(400);

int PrimeScore(int n) {
  int score = 0;
  for (int p : kPrimes) {
    if (p * p > n) {
      break;
    }
    if (n % p != 0) {
      continue;
    }
    ++score;
    while (n % p == 0) {
      n /= p;
    }
  }
  score += n > 1;
  return score;
}

int ModPow(int64_t a, int x) {
  int64_t r = 1;
  while (x > 0) {
    if (x % 2 == 1) {
      r = r * a % kMod;
    }
    a = a * a % kMod;
    x /= 2;
  }
  return r;
}
class Solution {
public:
    int maximumScore(vector<int>& nums, int k) {
        const int N = nums.size();
    vector<pair<int, int>> score_and_indices;  // A stack for one-pass algorithm
    vector<pair<int, int64_t>> value_and_powers;  // Results of this one-pass algorithm
    for (int i = 0; i < N; ++i) {
      int score = PrimeScore(nums[i]);
      while (!score_and_indices.empty() && score_and_indices.back().first < score) {
        auto [s, index] = score_and_indices.back();
        score_and_indices.pop_back();
        int64_t left = score_and_indices.empty() ? -1 : score_and_indices.back().second;
        value_and_powers.push_back({nums[index], (index - left) * (i - index)});
      }
      score_and_indices.push_back({score, i});
    }
    while (!score_and_indices.empty()) {
      auto [s, index] = score_and_indices.back();
      score_and_indices.pop_back();
      int64_t left = score_and_indices.empty() ? -1 : score_and_indices.back().second;
      value_and_powers.push_back({nums[index], (index - left) * (N - index)});
    }
    
    std::sort(value_and_powers.begin(), value_and_powers.end());
    
    int64_t answer = 1;
    for (int i = value_and_powers.size() - 1; i >= 0 && k > 0; --i) {
      auto [value, power] = value_and_powers[i];
      k -= power;
      if (k < 0) {
        power += k;
      }
      answer = answer * ModPow(value, power) % kMod;
    }
    return answer;
    }
};