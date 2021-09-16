package cn.jwm.community.dao;

import cn.jwm.community.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {

    // 查询帖子
    List<Comment> selectCommentsByEntity(int entityType, int entityId, int offset, int limit);
    // 查询评论数量
    int selectCountByEntity(int entityType, int entityId);
    // 插入评论
    int insertComment(Comment comment);

    Comment selectCommentById(int id);

}
