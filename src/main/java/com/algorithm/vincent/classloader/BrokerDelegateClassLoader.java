package com.algorithm.vincent.classloader;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class BrokerDelegateClassLoader extends ClassLoader{

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {

        synchronized (getClassLoadingLock(name)){
            Class<?> klass = findLoadedClass(name);
            if(klass == null) {
                if (name.startsWith("java.") || name.startsWith("javax.")) {
                    try {
                        klass = getSystemClassLoader().loadClass(name);
                    } catch (Exception e) {
                        //ignore
                    }
                } else {
                    // 这里是重点, 通过重写loadClass中
                    // findClass和 getParent().loadClass(name) / getSystemClassLoader().loadClass(name)
                    // 方法的先后顺序来打破双亲委派机制
                    try {
                        klass = this.findClass(name);

                    } catch (ClassNotFoundException e) {
                        //ignore
                    }
                    if (klass == null) {
                        if (getParent() != null) {
                            klass = getParent().loadClass(name);
                        } else {
                            klass = getSystemClassLoader().loadClass(name);
                        }
                    }
                }
            }
            if(null == klass){
                throw new ClassNotFoundException("The class " + name + "not found.");
            }
            if(resolve){
                resolveClass(klass);
            }
            return klass;
        }
    }
}
