1941. Check if All Characters Have Equal Number of Occurrences


class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char c:s.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        HashSet<Integer> hs = new HashSet<>(hm.values());
        return hs.size()==1;
        
    }
}
Explanation:
Let's break down the code step-by-step in simple terms to help a beginner understand:

 Code Overview:
The function `areOccurrencesEqual` checks whether all characters in the string `s` appear the same number of times.

---

 Step-by-Step Explanation:
1. Define a `HashMap` to Count Character Frequencies**
```java
HashMap<Character, Integer> hm = new HashMap<>();
```
- A `HashMap` is like a storage box where you can associate a **key** with a **value**.
  - **Key**: Each character in the string.
  - **Value**: How many times the character appears in the string.

---

2. Count the Frequencies of Each Character
for (char c : s.toCharArray()) {
    hm.put(c, hm.getOrDefault(c, 0) + 1);
}
```
- **`s.toCharArray()`**:
  - Converts the string `s` into an array of characters so we can loop through each character one by one.
  
- Loop:
  - For every character `c` in the string:
    1. `hm.getOrDefault(c, 0)`: 
        - Check if the character `c` already exists in the `HashMap`.
        - If it does, get its current count.
        - If it doesn’t exist yet, use the default value `0`.
    2. Add `1` to the count and update the map using `hm.put(c, count)`.

- **Example**:
  For `s = "abacbc"`:
  - After processing:
    ```java
    hm = {a=2, b=2, c=2}
    ```

---

3. Extract All Frequencies into a `HashSet

HashSet<Integer> hs = new HashSet<>(hm.values());
```
- A `HashSet` is a collection that only stores unique values.
- **`hm.values()`**:
  - Gets all the values (frequencies) from the `HashMap`.
  - For `hm = {a=2, b=2, c=2}`, the values are `[2, 2, 2]`.
- **`new HashSet<>(...)`**:
  - Creates a `HashSet` from the values.
  - Since a `HashSet` only keeps unique elements:
    - For `[2, 2, 2]`, the `HashSet` becomes `{2}`.

---

4. Check if All Frequencies Are the Same
```java
return hs.size() == 1;
```
- **`hs.size()`**:
  - Counts how many unique values are in the `HashSet`.
- If the size of the `HashSet` is `1`, it means all characters in the string have the same frequency.

---

Example Walkthroughs:

Example 1:
**Input**: `s = "abacbc"`

1. Build the `HashMap`:
   ```java
   hm = {a=2, b=2, c=2}
   ```
2. Create the `HashSet`:
   ```java
   hs = {2}
   ```
3. Check `hs.size() == 1`:
   - True → All characters have the same frequency.
   - Output: `true`

Example 2:
**Input**: `s = "aaabb"`

1. Build the `HashMap`:
   ```java
   hm = {a=3, b=2}
   ```
2. Create the `HashSet`:
   ```java
   hs = {3, 2}
   ```
3. Check `hs.size() == 1`:
   - False → Frequencies are not the same.
   - Output: `false`

---

Why This Works:
1. The `HashMap` tracks how many times each character appears.
2. The `HashSet` ensures that we only look at the unique frequencies.
3. If there’s just one unique frequency, all characters appear the same number of times.

---

Complexity:
- Time Complexity:
  - Building the `HashMap`: \(O(n)\), where \(n\) is the length of the string.
  - Creating the `HashSet`: \(O(m)\), where \(m\) is the number of unique characters.
- Space Complexity:
  - \(O(m)\) for the `HashMap` and `HashSet`.

