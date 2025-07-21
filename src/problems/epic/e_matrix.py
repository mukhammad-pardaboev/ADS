import sys

def solve():
    try:
        n = int(sys.stdin.readline())
    except Exception:
        return

    base_e = [
        "EEE",
        "E..",
        "EEE",
        "E..",
        "EEE"
    ]
    base_dot = ["..."] * 5
    current_matrix = base_e[:]

    for _ in range(n):
        new_matrix = []
        for prev_row in current_matrix:
            for i in range(5):
                new_matrix.append(''.join(base_e[i] if c == 'E' else base_dot[i] for c in prev_row))
        current_matrix = new_matrix

    sys.stdout.write('\n'.join(current_matrix) + '\n')
