"""
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
			 
1.采用二分法进行处理		 
"""

class Solution:
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
#         if x == 0 or x == 1:
#             return x
#         minimum = 0
#         y = maximum = x // 2
#         while maximum - minimum > 0:
            
#             if maximum * maximum <= x and (maximum + 1) * (maximum + 1) > x:
#                 return maximum
#             elif minimum * minimum <= x and (minimum + 1) * (minimum + 1) > x:
#                 return minimum
#             else:
#                 y = (minimum + maximum) // 2
#                 if y * y <= x:
#                     minimum = y
#                 else:
#                     maximum = y
        if x == 0 or x == 1:
            return x
        minimum = 0
        maximum = x // 2
        while maximum - minimum != 1:
            y = (minimum + maximum) // 2
            if y * y > x :
                maximum = y
            else:
                minimum = y
        if maximum * maximum <= x:
            return maximum
        return minimum