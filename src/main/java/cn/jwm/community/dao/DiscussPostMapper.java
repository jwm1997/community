package cn.jwm.community.dao;

import cn.jwm.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    // @param 注解用于给参数取别名， 如果只有一个参数并且在<if> 里使用，必须使用别名。
    int selectDiscussPostRows(@Param("userId") int userIs);
    //插入一条新帖子
    int insertDiscussPost(DiscussPost discussPost);
    // 查询帖子详情
    DiscussPost selectDiscussPostById(int id);

    int updateCommentCount(int id, int commentCount);
    int updateType(int id, int type);
    int updateStatus(int id, int status);
    int updateScore(int id, int score);


}
