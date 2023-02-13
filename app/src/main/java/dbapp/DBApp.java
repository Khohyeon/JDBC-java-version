package dbapp;

import java.sql.Connection;
import java.sql.SQLException;

import dbapp.config.DBConn;
import dbapp.service.ProductService;

public class DBApp {
    public static void main(String[] args) throws SQLException {
        // 스프링에서는 컴포넌트 스캔으로 자동으로 일어남
        // 1. 커넥션 가져오기
        Connection conn = DBConn.getConnection();
        // 2. DAO를 메모리에 올리기
        ProductRepository productRepository = new ProductRepository(conn);
        // 3. Service를 메모리에 올리기
        ProductService productService = new ProductService(productRepository, conn);
        productService.상품등록("apple", 2000, 5);
        productService.상품삭제(1);
        productService.상품수정(1, "sad", 200, 3);
        productRepository.findById(1);
    }
}
