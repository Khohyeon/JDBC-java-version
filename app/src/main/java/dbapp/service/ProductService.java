package dbapp.service;

import java.sql.Connection;
import java.sql.SQLException;

import dbapp.ProductRepository;

public class ProductService {
    private ProductRepository productRepository;
    private Connection conn;

    public ProductService(ProductRepository productRepository, Connection conn) {
        this.productRepository = productRepository;
        this.conn = conn;
    }

    public void 상품등록(String name, int price, int qty) {
        // 트렌젝션 시작
        try {
            productRepository.insert(name, price, qty);
            productRepository.insert(name, price, qty);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        // 트렌젝션 종료

    }

    public void 상품삭제(int id) {
        // 트렌젝션 시작
        try {
            productRepository.deleteById(id);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        // 트렌젝션 종료

    }

    public void 상품수정(int id, String name, int price, int qty) {
        // 트렌젝션 시작
        try {
            productRepository.updateById(id, name, price, qty);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        // 트렌젝션 종료

    }
}
