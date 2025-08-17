import time

# First: naive approach O(n) complexity
def add_up_to1(n):
  total = 0
  for i in range(1, n+1):
    total += i
  return total

# Second: math approach using formula O(1) complexity
def add_up_to2(n):
  return n * (n + 1) / 2

if __name__ == "__main__":
    number = 100000000
    start_time = time.time()
    total = add_up_to2(number)
    end_time = time.time()
    time_elapsed = end_time - start_time
    print(f"Total: {total}")
    print(f"Time elapsed: {time_elapsed} seconds")
