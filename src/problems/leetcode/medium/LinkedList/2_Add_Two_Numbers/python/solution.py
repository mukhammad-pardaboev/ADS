# Definition for singly-linked list.
from typing import Optional

class ListNode:
  def __init__(self, val =0, next =None):
    self.val = val
    self.next = next
    

class Solution:
  """
  LeetCode:
  2. Add Two Numbers
  """
  def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
    list1 = []
    node = l1
    while True:
      print(node.val)
      list1.append(node.val)
      if node.next == None:
        break
      node = node.next
          
    print(list1)
    
    list2 = []
    node = l2
    while True:
      print(node.val)
      list2.append(node.val)
      if node.next == None:
        break
      node = node.next
    print(list2)
    
    num1 = 0
    num2 = 0
    place_value = 1
    
    for digit in list1:
      num1 += digit * place_value
      place_value *= 10
    
    place_value = 1
    for digit in list2:
      num2 += digit * place_value
      place_value *= 10 
    
    print(num1, num2)
    num = num1 + num2
    print(num)
    current = None
    for i in str(num):
      current = ListNode(int(i), current)
      
    return current
  
  def addTwoNumbers2(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
    dummy_head = ListNode(0)
    current = dummy_head
    carry = 0
    while l1 is not None or l2 is not None or carry != 0:
      val1 = l1.val if l1 is not None else 0
      val2 = l2.val if l2 is not None else 0
      
      column_sum = val1 + val2 + carry
      new_digit = column_sum % 10
      carry = column_sum // 10
      
      current.next = ListNode(new_digit)
      
      current = current.next
      l1 = l1.next if l1 is not None else None
      l2 = l2.next if l2 is not None else None
      
    return dummy_head.next

l1_3 = ListNode(3, None)
l1_2 = ListNode(9, None)
l1 = ListNode(9, l1_2)

l2_3 = ListNode(4, None)
l2_2 = ListNode(6, l2_3)
l2 = ListNode(1, None)      
solution = Solution()
node = solution.addTwoNumbers2(l1, l2)
list_val = []

while node is not None:
  print(node.val)
  list_val.append(node.val)
  node = node.next
print(list_val)