package com.zou.Config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {
    /**
     * @param metadataReader :读取到当前正在扫描的类的信息
     * @param metadataReaderFactory：可以获取到其他任何类的信息
     * @return true：满足条件，就扫描并加入ioc容器。false：不满足条件，不扫描。
     * @throws IOException
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类的类信息（类型，接口等）
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类的资源信息（累的路径）
        Resource resource = metadataReader.getResource();
        String name = classMetadata.getClassName();
        System.out.println("正在扫描的类---"+name);
        if (name.contains("er")){
            return true;
        }
        return false;
    }
}
