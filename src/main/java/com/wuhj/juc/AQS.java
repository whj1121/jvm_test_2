package com.wuhj.juc;

import org.w3c.dom.Node;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wuhaojie
 * @ClassName AQS
 * @createTime 2020/8/5
 */
public class AQS {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        lock.lock();

        lock.unlock();

        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();


        reentrantReadWriteLock.readLock().lock();
        reentrantReadWriteLock.readLock().lock();
        reentrantReadWriteLock.readLock().lock();
        reentrantReadWriteLock.readLock().lock();
        reentrantReadWriteLock.writeLock().lock();

        //Semaphore semaphore = new Semaphore(5);
    }

    public void a() {




    }

    /**
     * 当前线程持有锁后，释放锁，然后阻塞，唤醒后重新获取锁才能进行
     */
   /* public final void await() throws InterruptedException {
        // 先检查，如果线程被中断则抛出中断异常
        if (Thread.interrupted())
            throw new InterruptedException();
        // 创建新的节点，并将节点加到Condition队尾
        Node node = addConditionWaiter();
        // 必须先完全释放锁，并唤醒AQS队列中一个线程，返回之前的锁状态，因为有重入，还要恢复状态
        int savedState = fullyRelease(node);
        int interruptMode = 0;
        // 判断节点是否在AQS队列上，不在的话就阻塞自己
        // 第一次肯定是不在的，因为还没加入AQS队列，然后就阻塞自己
        while (!isOnSyncQueue(node)) {
            LockSupport.park(this);
            // Condition#signal或线程被中断导致唤醒，唤醒后检查节点在阻塞时是否被中断
            // 如果没有中断，说明是被Condition#signal唤醒的，此时节点已经被该方法转移到AQS队列里了，所以下次循环不会进来
            // 如果被中断了，说明线程是被中断导致唤醒的，那么将该节点放入AQS队列，直接跳出
            if ((interruptMode = checkInterruptWhileWaiting(node)) != 0)
                break;
        }
        // 被唤醒并重新加入AQS同步队列后，阻塞至重新获取到了锁
        if (acquireQueued(node, savedState) && interruptMode != THROW_IE)
            interruptMode = REINTERRUPT;

        // 如果节点的后继节点引用没置空，则清理Condition队列上的被取消的节点
        // 如果节点是因为Condition#signal唤醒的话，那么在Condition#doSignal已经置空了，这是处理因为中断而唤醒的情况
        if (node.nextWaiter != null)
            unlinkCancelledWaiters();

        // 如果线程被中断发生在Condition#signal之前，Condition#await必须在重新获取到锁后，抛出InterruptedException
        // 否则，如果中断发生在Condition#signal之后，Condition#await必须返回且不抛异常，同时再次中断，即保留中断标记
        if (interruptMode != 0)
            reportInterruptAfterWait(interruptMode);
    }

    private void reportInterruptAfterWait(int interruptMode) {
    }

    private void unlinkCancelledWaiters() {
    }

    private boolean acquireQueued(Node node, int savedState) {
    }

    private int checkInterruptWhileWaiting(Node node) {
    }

    private boolean isOnSyncQueue(Node node) {
    }

    private int fullyRelease(Node node) {
    }

    private Node addConditionWaiter() {
    }*/

}
