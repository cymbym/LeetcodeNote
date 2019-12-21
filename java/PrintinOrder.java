/*
Suppose we have a class:

public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
The same instance of Foo will be passed to three different threads.
 Thread A will call first(), thread B will call second(), and thread C will call third().
 Design a mechanism and modify the program to ensure that second() is executed after first(),
 and third() is executed after second().

 

Example 1:

Input: [1,2,3]
Output: "firstsecondthird"
Explanation: There are three threads being fired asynchronously.
             The input [1,2,3] means thread A calls first(), thread B calls second(),
             and thread C calls third().
             "firstsecondthird" is the correct output.
Example 2:

Input: [1,3,2]
Output: "firstsecondthird"
Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(),
             and thread C calls second(). "firstsecondthird" is the correct output.
 

Note:

We do not know how the threads will be scheduled in the operating system,
 even though the numbers in the input seems to imply the ordering.
 The input format you see is mainly to ensure our tests' comprehensiveness.
 
1.法一用了volatile关键字声明变量。这个关键字使得各个线程都能同时读写这个变量，使得多个并发机制之间相互可控。
2.*****************可以看看CountDownLatch百米赛跑中倒计时计算器的用法*****************
  法二引用了闭锁对象CountDownLatch，当count的值为0时，该线程继续运行，它允许一个或多个线程等待直到在其他线程中一组操作执行完成。
  在需要等待的线程的开头加入(new CountDownLatch(x)).await();，在率先执行的x个线程末尾加入(new CountDownLatch(x)).countDown();。
  一旦率先执行的x个线程都执行完，将count从x减到了0，则这个等待的线程也可以开始执行。
  
*/

class Foo {

    private volatile boolean wait1;
    private volatile boolean wait2;
    
    public Foo() {
        wait1=true;
        wait2=true;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        wait1=false;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        while(wait1);                   //当wait1变成false后，进程开始运行下一步。
        printSecond.run();
        wait2=false;
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        while(wait1 || wait2);          //当wait1和wait2都变成false后，进程开始运行下一步。
        printThird.run();
    }
}

class Foo {
    CountDownLatch cd1;
    CountDownLatch cd2;
    public Foo() {
        cd1 = new CountDownLatch(1);
        cd2 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        cd1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        cd1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        cd2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        cd2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}