package com.aaa.xie.repast.test;

import com.aaa.xie.repast.model.Collect;
import com.aaa.xie.repast.model.Member;
import com.aaa.xie.repast.utils.DateUtil;
import com.aaa.xie.repast.utils.JSONUtil;
import com.aaa.xie.repast.utils.Map2BeanUtil;
import com.aaa.xie.repast.utils.StringUtil;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.aaa.xie.repast.staticstatus.StaticCode.FORMAT_DATE;

/*  @  时间    :  2020/3/13 17:06:21
 *  @  类名    :  Test
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
public class Test {
   static Map map = new HashMap();
   static Member member = new Member();
    public static void test() {
        member.setId(Long.valueOf(1));
        member.setCity("xiuer");

        Class<?> clazz = member.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            map.put(fieldName, 1);

        }
        System.out.println(map);
        String s = JSONUtil.toJsonString(map);
        System.out.println(s);

    }

    public static void main(String[] args) {
//        Map map = new HashMap();
//        map.put("id",1);
//        Member member = Map2BeanUtil.map2Bean(map, Member.class);

//        System.out.println(member.getId());
//        List<Integer> list = new ArrayList();
//        list.add(1);
//        list.add(2);
//        String s = JSONUtil.toJsonString(list);
//        System.out.println(s);
//        String dateString = DateUtil.formatDate(new Date(), FORMAT_DATE);
//        System.out.println(dateString);
//        String dateNow = DateUtil.getDateNow();
//        System.out.println(dateNow);
//        Date date = new Date();
//        System.out.println(date);
//        Date date1 = new Date();
//
////        System.currentTimeMillis();
//        int seconds = date1.getSeconds();
//        System.out.println(seconds);
//        System.out.println(date.getTime());
//        System.out.println(System.currentTimeMillis() > date.getTime());
//      Collect collect = new Collect();
////
//     System.out.println(StringUtil.isEmpty(collect));
////        System.out.println(collect.toString());
//      collect.setStatus(1);
//     System.out.println(StringUtil.isNull(collect));
////        System.out.println(collect.toString());
//            Object o = new Object();
    }
}
