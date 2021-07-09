package com.example.demo;

import com.example.demo.service.AsyncService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author 张彦培
 * @date 2021/5/1415:26
 */
public class AsyncTest {

//    @Autowired
    private final AsyncService asyncService=new AsyncService();

    @Test
    public void testAsync() throws InterruptedException {
        long time=System.currentTimeMillis();
        Future<String> stringFuture = asyncService.async1();
        Future<String> stringFuture1 = asyncService.async2();

        while (true) {
            if (stringFuture.isDone() && stringFuture1.isDone() && stringFuture.isDone()) {
                break;
            }
            Thread.sleep(100);
        }
        System.out.println(System.currentTimeMillis()-time);
    }

    @Test
    public void testTrackback(){
        int[] ins={1,2,3,4};
        trackBack(ins);
        System.out.println(res);
    }
    List<List<Integer>> res=new ArrayList<>();
    private void trackBack(int[] nums){
        LinkedList<Integer> ls=new LinkedList();
        subTrackBack(nums,ls);
    }
   private void subTrackBack(int[] nums,LinkedList<Integer> ls){
        if(nums.length==ls.size()){
            res.add(new LinkedList<>(ls));
            return;
        }
       for (int num : nums) {
           if(ls.contains(num)){
               continue;
           }
           ls.add(num);
           subTrackBack(nums , ls);
           ls.removeLast();
       }
    }

    public int erFenFa(int[] ins,int target){
        int min=0;
        int max=ins.length-1;
        int count=0;
        while(min<=max){
            count++;

            int med=min+(max-min)/2;
            if(ins[med]<target){
                min=med+1;
            }else if(ins[med]>target){
                max=med-1;
            }else {
                System.out.println(count);
                return med;
            }
        }
        System.out.println(count);
        return -1;
    }
    @Test
    public void testErFenFa(){
        int[] ins={1,2,3,4,5,6,7,33,44};
        int tar=erFenFa(ins,6);
        System.out.println(tar);
    }
}
