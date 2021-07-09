package com.example.demo.comtroller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张彦培
 * @date 2021/3/2415:58
 */
public class ILinkedList<T> {
    public static void main(String[] args) {
//        Data data1 = new Data("11", "111", 1);
//        Data data2 = new Data("11", "666", 2);
//        Data data3 = new Data("11", "111", 3);
//        Data data4 = new Data("11", "111", 4);
//        Data data5 = new Data("11", "111", 5);
//        Data data6 = new Data("11", "111", 6);
//        Data data7 = new Data("11", "111", 7);
//        Data data8 = new Data("11", "111", 8);
//        SLType slType = new SLType();
//        slType.slAdd(data1 );
//        System.out.println(slType.slLength(slType));
//        slType.slAdd(data2 );
//        slType.slAdd(data3 );
//        slType.slAdd(data4 );
//        slType.slAdd(data5 );
//        slType.slAdd(data6 );
//        slType.slAdd(data7 );
//        slType.delData( 3);
//        slType.slInsert(4, data8);
//        slType.slAll();
//        System.out.println( slType.findByName( "666"));

        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        list1.add("g");
        list1.add("s");
        list1.add("a");
        list1.add("f");
        list2.add("g");
        list2.add("c");
        list2.add("b");
        list2.add("a");
        list1.retainAll(list2);
        System.out.print(list1);
    }
}
@lombok.Data
@lombok.AllArgsConstructor
class Data{
    private String key;
    private String name;
    private int age;
}
class SLType{
    static final int MAXLEN=100;
    int listLen;
    Data[] listData=new Data[MAXLEN];
    void slInit(){
        this.listLen=0;
    }
    int slLength(){
        return this.listLen;
    }
    int slAdd(Data data){
        if (this.listLen==MAXLEN){
            return 0;
        }
        this.listData[listLen]=data;
        this.listLen++;
        return 1;
    }
    /**
     *@Description 插入
     *@Param [com.example.demo.comtroller.SLType, int, com.example.demo.comtroller.Data]
     *@Return int
     *@Author zypz
     *@Date 16:14 2021/3/24
     */
    int slInsert(int n,Data data){
        if(this.listLen>=MAXLEN){
            return 0;
        }
        if(n<0||n>this.listLen){
            return 0;
        }
        //
        for (int i=this.listLen-1;i>=n;i--) {
            this.listData[i+1]=this.listData[i];
        }
        this.listData[n]=data;
        this.listLen++;
        return 1;
    }
    int delData(int n){
        if(n<0||n>=this.listLen){
            return 0;
        }
        if (n==this.listLen-1){
            this.listLen--;
            return 1;
        }
        for (int i=n;i<this.listLen;i++) {
            this.listData[i]=this.listData[i+1];
        }
        this.listLen--;
        return 1;
    }
    Data findByNum(int n){
        if(n<0||n>this.listLen){
            return null;
        }
        return this.listData[n];
    }
    Data findByName(String name){
        for (Data listDatum : this.listData) {
            if (listDatum.getName().equals(name)){
                return listDatum;
            }
        }
        return null;
    }
    void slAll(){
        for (int i=0;i<this.listLen;i++) {
            System.out.println(this.listData[i]);
        }
    }
}