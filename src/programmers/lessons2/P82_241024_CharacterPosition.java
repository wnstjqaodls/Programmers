package programmers.lessons2;

public class P82_241024_CharacterPosition {
    /*
    문제 설명
    머쓱이는 RPG게임을 하고 있습니다. 게임에는 up, down, left, right 방향키가 있으며
    각 키를 누르면 위, 아래, 왼쪽, 오른쪽으로 한 칸씩 이동합니다.
    예를 들어 [0,0]에서 up을 누른다면 캐릭터의 좌표는 [0, 1],
    down을 누른다면 [0, -1], left를 누른다면 [-1, 0], right를 누른다면 [1, 0]입니다.
    머쓱이가 입력한 방향키의 배열 keyinput와 맵의 크기 board이 매개변수로 주어집니다. 
    캐릭터는 항상 [0,0]에서 시작할 때 키 입력이 모두 끝난 뒤에 캐릭터의 좌표 [x, y]를 
    return하도록 solution 함수를 완성해주세요.

    [0, 0]은 board의 정 중앙에 위치합니다. 
    예를 들어 board의 가로 크기가 9라면 캐릭터는 왼쪽으로 최대 [-4, 0]까지 
    오른쪽으로 최대 [4, 0]까지 이동할 수 있습니다.

    제한사항
    - board은 [가로 크기, 세로 크기] 형태로 주어집니다.
    - board의 가로 크기와 세로 크기는 홀수입니다.
    - board의 크기를 벗어난 방향키 입력은 무시합니다.
    - 0 ≤ keyinput의 길이 ≤ 50
    - 1 ≤ board[0] ≤ 99
    - 1 ≤ board[1] ≤ 99
    - keyinput은 항상 up, down, left, right만 주어집니다.

    입출력 예
    keyinput                                     board       result
    ["left", "right", "up", "right", "right"]   [11, 11]   [2, 1]
    ["down", "down", "down", "down", "down"]    [7, 9]     [0, -4]
    */

    public static void main(String[] args) {
        
        P82_241024_CharacterPosition solution = new P82_241024_CharacterPosition();

        String[] keyinput1 = {"left", "right", "up", "right", "right"};
        int[] board1 = {11, 11};
        System.out.println("Test Case 1 - Expected: [2, 1]");
        int[] result1 = solution.solution(keyinput1, board1);
        System.out.println("Result: [" + result1[0] + ", " + result1[1] + "]");

        String[] keyinput2 = {"down", "down", "down", "down", "down"};
        int[] board2 = {7, 9};
        System.out.println("\nTest Case 2 - Expected: [0, -4]");
        int[] result2 = solution.solution(keyinput2, board2);
        System.out.println("Result: [" + result2[0] + ", " + result2[1] + "]");
    }

    public int[] solution(String[] keyinput, int[] board) {
        int[] position = {0, 0};
        int widthLength = board[0]/2;
        int heightLength = board[1]/2;

        for(String key : keyinput) {
        switch (key) {
            case "left":
                if(isInBoard(position[0]-1, widthLength)) {
                    position[0]--;
                }
                break;
            case "right":
                if(isInBoard(position[0]+1, widthLength)) { 
                    position[0]++;
                }
                break;
            case "down":
                if(isInBoard(position[1]-1, heightLength)) {
                    position[1]--;
                }
                break;
            case "up":
                if(isInBoard(position[1]+1, heightLength)) {
                    position[1]++;
                }
                break;
        }
    
    }
    return position;
    }

    // board 범위 체크 
    // 고려할것 : 정수 음수 범위 모두 체크해야하는데.. > 절대값으로 변경하여 체크
    // fixme : 부등호 비교시 초과 또는 이상으로 비교해도 경계값문제를 해결 불가능함.
    // fixme : 현재 위치만 체크하지말고, 이동 "할" 위치를 체크해야한다.
    public boolean isInBoard(int position, int board) {
        // if (Math.abs(position) > board) { 
        if (Math.abs(position) > board) { 
            return false;
        }
        return true;
    }


}