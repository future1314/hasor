/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.hasor.core.provider;
import net.hasor.core.Provider;
/**
 * 线程单例对象的{@link Provider}封装形式。
 * @version : 2014年7月8日
 * @author 赵永春 (zyc@hasor.net)
 */
public class ThreadSingleProvider<T> implements Provider<T> {
    private volatile ThreadLocal<T> instance;
    //
    public ThreadSingleProvider(final Provider<T> provider) {
        this.instance = new ThreadLocal<T>() {
            @Override
            protected T initialValue() {
                return provider.get();
            }
        };
    }
    public T get() {
        return this.instance.get();
    }
    public String toString() {
        return "ThreadSingleProvider->" + instance.toString();
    }
}