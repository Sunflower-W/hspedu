package com.hspedu;

public class CpuNum {
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        //获取当前电脑CPU/核心数
        int cpuNums = runtime.availableProcessors();
        System.out.println("当前 CPU 个数=" + cpuNums);

    }
}
