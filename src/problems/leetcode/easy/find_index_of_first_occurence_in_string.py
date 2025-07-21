class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        index = 0
        for i in range(len(haystack)):
            if haystack[i] == needle[index]:
                index += 1
            else:
                index = 0
            if index >= len(needle):
                return i - index + 1
        return -1
      

class Solution2:
  def strStr(self, haystack: str, needle: str) -> int:
    firstIndecis = []
    for i in range(len(haystack)):
      if haystack[i] == needle[0]:
        firstIndecis.append(i)
        
    for index in firstIndecis:
      if (len(haystack) - index) < len(needle):
        break
      for i in range(len(needle)):
        if needle[i] != haystack[index + i]:
          break
      else:
        return index
    return -1;
          
      
    
    
      
solution = Solution2()
print(solution.strStr("sadbutsad", "sad"))  # Output: 0
print(solution.strStr("butsadsad", "sad"))
print(solution.strStr("leetcode", "leeto"))
print(solution.strStr("abc", "c"))
print(solution.strStr("mississippi", "issipi"))