package com.example.demo.comtroller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 张彦培
 * @date 2021/2/2517:15
 */
//@RestController
//@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * @Description todo
     * @Param [java.lang.Integer]
     * @Return com.example.demo.entity.User
     * @Author zypz
     * @Date 17:23 2021/2/25
     */
    @GetMapping("/getUserById")
    public User getUserById(@RequestParam Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/getUserList")
    public List<User> getUserList() {
        return userService.getUserList();
    }

    public static void main(String[] args) {
        tranSanJiao(18);
    }


    /**
     * flatMap —— 接收一个函数作为参数，将流中的每个值都换成一个流，然后把所有流连接成一个流
     */
    @Test
    public void testFlatMap() {
        UserController s = new UserController();
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
//        list.stream().flatMap((e) -> s.filterCharacter(e)).forEach(System.out::println);

        //如果使用map则需要这样写
//        List<Stream<Character>> collect = list.stream().map((e) -> s.filterCharacter(e)).collect(Collectors.toList());
//   collect.forEach(e->System.out.println(e.collect(Collectors.toList()).toString()));
    }

    /**
     * 将一个字符串转换为流
     */
    @Test
    public void filterCharacter() {
        String str = "kdsjfgsdkljg";
        Character[] chars = {'f', 'e', 'h'};
        int[] ints = new int[]{2, 3, 4};
        List<Character> collect = Arrays.stream(chars).collect(Collectors.toList());
//        System.out.println(collect.get(2));
        ArrayList<Character> characters = new ArrayList<>(Arrays.asList(chars));
//        characters.forEach(System.out::println);
        System.out.println(characters.get(2));
//        List<char[]> chars1 = Arrays.asList(chars);
//        ArrayList<Character> arrayList = new ArrayList();
//        for(Character c:chars){
//            arrayList.add(c);
//        }
//        ArrayList<char[]> chars2 = new ArrayList<>(chars1);
//        System.out.println(chars2.get(2));
//        chars1.forEach(System.out::print);
    }

    @Test
    public void testArrayAsList() {
        List list = new ArrayList<>(Arrays.asList("5", "e", "t", "u"));
        System.out.println(list.get(2));
    }

    @Test
    public void testNewString() {
        String[] s = new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
//    List<String> list = Arrays.asList(s);
//    Collections.reverse(list);
//    s=list.toArray(new String[0]);//没有指定类型的话会报错
//    Arrays.stream(s).forEach(System.out::println);

    }

    private static void tranSanJiao(int num) {
        int sanjiao[][] = new int[num][];
        for (int i = 0; i < sanjiao.length; i++) {
            sanjiao[i] = new int[i + 1];
            for (int j = 0; j < sanjiao[i].length; j++) {
                if (j == 0 | j == sanjiao[i].length - 1) {
                    sanjiao[i][j] = 1;
                } else {
                    sanjiao[i][j] = sanjiao[i - 1][j - 1] + sanjiao[i - 1][j];
                }
                System.out.print(sanjiao[i][j] + "\t\t");
            }
            System.out.println();
        }
    }

    @Test
    public void testStreamFlatMap() {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));

        List<Student> studentList = Stream.of(students,
                Arrays.asList(new Student("艾斯", 25, 183),
                        new Student("雷利", 48, 176)))
                .flatMap(students1 -> students1.stream()).collect(Collectors.toList());
        System.out.println(studentList);
    }
    @Test
    public void testStreamMax(){
        Optional<Student> max = students.stream().max(Comparator.comparing(s -> s.getAge()));
        System.out.println(max.orElse(new Student()));
        Optional<Student> min = students.stream().min(Comparator.comparing(s -> s.getAge()));
        System.out.println(min.get());
        Stream<Student> studentStream = students.stream().filter(s -> s.getAge() == 9);
        System.out.println(studentStream.findFirst().orElse(new Student()));
    }
    List<Student> students = new ArrayList<>(3);
    @Before
    public void testBefore(){
        students.add(new Student("路飞", 22, 175,"sing"));
        students.add(new Student("红发", 40, 180,"dance"));
        students.add(new Student("白胡子", 50, 185,"KangFu"));
        students.add(new Student("黑胡子", 50, 185,"dance"));
    }
    @Test
    public void testReduce(){
        Integer reduce = Stream.of(1, 2, 4, 5).reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
        Double collect = students.stream().collect(Collectors.averagingInt(Student::getAge));
//        Double collect1 = students.stream().collect(Collectors.averagingInt(Student::getAge));

        System.out.println(collect);
    }
    @Test
    public void testStreamPartition(){
        Map<Boolean, List<Student>> sing = students.stream().collect(Collectors.partitioningBy(s -> s.getSpecialities().contains("sing")));
        Map<Boolean, List<Student>> collect = students.stream().collect(Collectors.groupingBy(s -> s.getSpecialities()));
        System.out.println(sing);
    }
    @Data
    class Student {
        private String name;
        private int age;
        private long stature;
        private String specialities;

        public Student() {
        }

        public Student(String name, int age, long stature) {
            this.name = name;
            this.age = age;
            this.stature = stature;
        }

        public Student(String name, int age, long stature, String specialities) {
            this.name = name;
            this.age = age;
            this.stature = stature;
            this.specialities = specialities;
        }
    }
}
