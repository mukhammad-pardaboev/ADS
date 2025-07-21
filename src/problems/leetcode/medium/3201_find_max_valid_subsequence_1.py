class Solution(object):
    def maximumLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        list_one = []
        for j in range(len(nums)-1):
            list_one.append((nums[j]+nums[j+1])%2)

        my_operator=max(list_one, key=list_one.count)

        juft=[]
        toq=[]
        for i in nums:
            if i%2==1:
                toq.append(i)
            else:
                juft.append(i)
        if my_operator==1:
            if len(juft)>len(toq):
                return min(len(juft),len(toq))*2
                
            else:
                return len(nums)
               
        else:
            return max(len(juft),len(toq))
          
class Solution2(object):
    def maximumLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        list_one = []
        for j in range(len(nums)-1):
            list_one.append((nums[j]+nums[j+1])%2)
            
        print(list_one)
        
        juft = 0
        toq = 0
        for i in list_one:
          if i == 1:
            toq +=1
          else: 
            juft +=1
        
        maxSub = max(juft, toq)
        
        if len(list_one) % 2 == 0:
          maxSub += 1  
        
        return maxSub;

my_obj=Solution2()
print(my_obj.maximumLength([1,5,9,4,2]))