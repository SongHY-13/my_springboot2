package com.song.boot.converter;

import com.song.boot.bean.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Description:  自定义Converter，添加写功能：处理Person类型的数据，转换为自定义的application/x-guigu格式： 属性值;属性值;
 *               此处不涉及读功能的修改
 *
 * @Create : 2024/2/21 -10:48
 * @Version : v1.0
 */
public class GuiguMessageConverter implements HttpMessageConverter<Person> {
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override  //  返回的类型是Person时为true
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(Person.class);
    }

    /**
     *  重要： 服务器要统计所有MessageConverter都能写出哪些内容类型
     *   自定义媒体类型： application/x-guigu
     * @return
     */
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/x-guigu");
    }

    @Override
    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override  // 自定义协议数据的写出
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        // 自定义协议数据准备
        String data = person.getUserName() + ";" + person.getAge() + ";" + person.getBirth();

         // 写出去
        OutputStream body = outputMessage.getBody();
        body.write(data.getBytes());
        body.flush();
    }
}
