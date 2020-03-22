package com.aaa.xie.repast.staticstatus;

import java.lang.reflect.Field;
import java.util.List;

import static com.aaa.xie.repast.staticstatus.StaticCode.ZERO;

/*  @  时间    :  2020/3/22 09:51:20
 *  @  类名    :  IsEmpty
 *  @  创建人  :  Xie
 *  @  描述    :
 *
 */
public class IsEmpty {
    /*
     * @Author Xie
     * @Description 
     *       判断实体类是佛为空
     * @Date 9:53 2020/3/22
     * @Param [object]
     * @return java.lang.Boolean
     **/
    public static Boolean isEmpty(Object object){
        try {
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if(f.get(object) != null)return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /*
     * @Author Xie
     * @Description 
     *       判断list是佛为空
     * @Date 9:54 2020/3/22
     * @Param [list]
     * @return java.lang.Boolean
     **/
    public static Boolean isEmpty(List list){
        if (list.size()>ZERO&&null!=list){
            return true;
        }else {
            return false;
        }
    }
    /*
     * @Author Xie
     * @Description 
     *       判断值是佛为空或0
     * @Date 9:55 2020/3/22
     * @Param [integer]
     * @return java.lang.Boolean
     **/
    public static Boolean isEmpty(Integer integer){
        if(null==integer&&integer==0){
            return true;
        }
        return false;
    }
}
