class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // Stack<Integer> stack = new Stack<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            int absAsteroid = asteroid < 0 ? -asteroid : asteroid;
            boolean check = true;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int top = stack.peek();
                if (top < absAsteroid) {
                    stack.pop();
                } else if (top == absAsteroid) {
                    stack.pop();
                    check = false;
                    break;
                } else {
                    check = false;
                    break;
                }
            }

            if (check) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    // Cach tham khao
    // public int[] asteroidCollision(int[] asteroids) {
    // int[] stack = new int[asteroids.length];
    // int top = -1;
    // for (int asteroid : asteroids) {
    // boolean check = true;
    // while (check && top >= 0 && stack[top] > 0 && asteroid < 0) {
    // int absAsteroid = -asteroid;

    // if (stack[top] < absAsteroid) {
    // top--;
    // } else if (stack[top] == absAsteroid) {
    // top--;
    // check = false;
    // } else {
    // check = false;
    // }
    // }

    // if (check) {
    // stack[++top] = asteroid;
    // }
    // }

    // int[] result = new int[top + 1];
    // System.arraycopy(stack, 0, result, 0, top + 1);
    // return result;
    // }
}