package org.fw.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by frank-weapon on 15-3-20.
 */
public class ReflectUtil {
    public static Class<?> getGenericParameterType(Class<?> clazz){
        //返回表示此Class所表示的实体（类、接口、基本类型或 void）的直接超类的Type。如果超类是参数化类型，则返回的Type对象必须准确反映源代码中所使用的实际类型参数。
        Type type = clazz.getGenericSuperclass();
        //强制转化为参数化类型：Collection<String>
        ParameterizedType pt = (ParameterizedType) type;
        //返回表示此类型的实际类型参数的 Type 对象的数组。
        Type[] types = pt.getActualTypeArguments();
        return (Class<?>) types[0];
    }
}
