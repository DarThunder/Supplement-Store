
package com.proyecto.sistema.repository;

import com.proyecto.sistema.model.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    private final JdbcTemplate jdbcTemplate;

    public CategoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Category> mapper = (rs, rowNum) ->
        new Category(
            rs.getInt("ID_CATEGORY"),
            rs.getString("CAT_NAME"),
            rs.getString("CAT_DESC")
        );

    public List<Category> list() {
        String sql = "SELECT * FROM CATEGORY ORDER BY ID_CATEGORY";
        return jdbcTemplate.query(sql, mapper);
    }

    public Optional<Category> findByID(int id) {
        String sql = "SELECT * FROM CATEGORY WHERE ID_CATEGORY = ?";

        return jdbcTemplate.query(sql, mapper, id)
                .stream()
                .findFirst();
    }

    public int save(Category category) {
        String sql = """
            INSERT INTO CATEGORY (CAT_NAME, CAT_DESC)
            VALUES (?, ?)
            """;

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, category.getName());
            ps.setString(2, category.getDesc());

            return ps;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    public int update(Category categoria) {
        String sql = """
            UPDATE CATEGORY
            SET CAT_NAME = ?, CAT_DESC = ?
            WHERE ID_CATEGORY = ?
            """;

        return jdbcTemplate.update(
            sql,
            categoria.getName(),
            categoria.getDesc(),
            categoria.getIdCategory()
        );
    }

    public int remove(int id) {
        String sql = "DELETE FROM CATEGORY WHERE ID_CATEGORY = ?";
        return jdbcTemplate.update(sql, id);
    }
}
