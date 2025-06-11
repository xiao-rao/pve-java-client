package io.github.pve.client.util;

import java.util.function.Supplier;

/**
 * 一个线程安全的、延迟加载的包装类。
 * 包装的值仅在第一次调用 get() 方法时才会被创建。
 * 这个类是final的，以确保其行为不可被继承修改。
 * @param <T> 需要被延迟初始化的对象的类型。
 */
public final class Lazy<T> {
    private final Supplier<T> supplier;
    private volatile T value;

    public Lazy(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    /**
     * 获取包装的值。如果值尚未创建，则会触发创建过程。
     * 此方法是线程安全的。
     * @return 初始化的值
     */
    public T get() {
        if (value == null) {
            // 使用双重检查锁定模式确保线程安全和高性能
            synchronized (this) { // 在Lazy实例自身上同步，是安全的
                if (value == null) {
                    value = supplier.get();
                }
            }
        }
        return value;
    }
}

