package cn.jwm.community.dao;

import cn.jwm.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

@Mapper
@Deprecated
public interface LoginTicketMapper {

    @Insert({
            "insert into login_ticket(user_id,ticket,status,expired) ",
            "values(#{userId},#{ticket},#{status},#{expired})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")//自动生成主键注入id中
    int insertLoginTicket(LoginTicket loginTicket); // 登录成功插入一条凭证

    @Select({
            "select id,user_id,ticket,status,expired ",
            "from login_ticket where ticket=#{ticket}"
    })
    LoginTicket selectByTicket(String ticket);

    @Update({
            "<script>",
            "update login_ticket set status=#{status} where ticket=#{ticket} ",
            "<if test=\"ticket!=null\"> ",// \" 转义"
            "and 1=1 ",
            "</if>",
            "</script>"// 首位加script可以写if动态语句
    })
    int updateStatus(String ticket, int status);

}
