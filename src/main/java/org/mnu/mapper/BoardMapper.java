package org.mnu.mapper;

import org.apache.ibatis.annotations.Select;
import org.mnu.domain.BoardVO;

import java.util.List;

public interface BoardMapper {

    public List<BoardVO> getList();
}
