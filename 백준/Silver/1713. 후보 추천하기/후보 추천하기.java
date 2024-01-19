import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Student {
    int stu_no;
    int like;
    int time;
    boolean isPosted;

    Student(int stu_no, int like, int time, boolean isPosted) {
        this.stu_no = stu_no;
        this.like = like;
        this.time = time;
        this.isPosted = isPosted;
    }

    public void increase() {
        this.like++;
    }
}

public class Main {
    static int i = 0;
    static List<Student> frame = new ArrayList<>();
    static Student[] students = new Student[101];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        while (i < cnt) {
            int stuNo = Integer.parseInt(st.nextToken());
            // 기존에 추천을 받은적이 있는지에 대한 상태 검사
            if (students[stuNo] == null) {
                students[stuNo] = new Student(stuNo, 0, 0, false);
            }

            // 이미 게시가 된 상태의 경우 추천 수 증가
            if (students[stuNo].isPosted) {
                students[stuNo].increase();
            }
            // 그전에 게시된 적 없을 경우
            else {
                // 액자 프레임이 꽉 찬 경우
                if (frame.size() == N) {
                    // 추천 수 기반 내림차순으로 정렬
                    frame.sort((o1, o2) -> {
                        // 좋아요가 같을 경우 등록된 순으로 정렬
                        if (o1.like == o2.like) {
                            return o1.time - o2.time;
                        }
                        return o1.like - o2.like;
                    });
                    // 오름차순 정렬이기 때문에 가장 앞사람을 제거
                    frame.get(0).isPosted = false;
                    frame.remove(0);
                }
                // 프레임이 꽉차거나 꽉차있지 않거나 하나 추가 ( 꽉 안차있는 경우는 이미 제거함)
                students[stuNo].time = i;
                students[stuNo].like = 1;
                students[stuNo].isPosted = true;
                frame.add(students[stuNo]);
            }
            i++;
        }

        // 최종 오름차순으로 출력하기 위한 정렬
        frame.sort(Comparator.comparingInt(o -> o.stu_no));
        for (Student student : frame) {
            sb.append(student.stu_no);
            sb.append(" ");
        }
        System.out.print(sb);
    }
}