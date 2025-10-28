class Solution {
    // Class để lưu thông tin robot
    class Robot {
        int position; // vi tri
        int health; // mau
        char direction; // huong di chuyen 'L' hoac 'R'
        int index; // thu tu ban dau

        Robot(int pos, int hp, char dir, int idx) {
            this.position = pos;
            this.health = hp;
            this.direction = dir;
            this.index = idx;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] robots = new Robot[n];
        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }
        Arrays.sort(robots, (a, b) -> a.position - b.position);
        // Stack<Robot> stack = new Stack<>();
        Deque<Robot> stack = new ArrayDeque<>();
        for (Robot robot : robots) {
            if (robot.direction == 'R') {
                stack.push(robot);
            } else {
                boolean survived = true;
                while (!stack.isEmpty() && stack.peek().direction == 'R' && survived) {
                    Robot rightRobot = stack.peek();
                    if (rightRobot.health < robot.health) {
                        stack.pop();
                        robot.health--;
                    } else if (rightRobot.health > robot.health) {
                        rightRobot.health--;
                        survived = false;
                    } else {
                        stack.pop();
                        survived = false;
                    }
                }
                if (survived) {
                    stack.push(robot);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        Robot[] survivors = new Robot[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            survivors[i] = stack.pop();
        }
        Arrays.sort(survivors, (a, b) -> a.index - b.index);
        for (Robot survivor : survivors) {
            result.add(survivor.health);
        }

        return result;
    }
}