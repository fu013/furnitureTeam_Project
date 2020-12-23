package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SelectAllProductMapper {
    void SelectAllProduct();
}
