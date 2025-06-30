package ru.kirill.test.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kirill.test.orders.model.Order;
import ru.kirill.test.orders.model.ServiceType;
import ru.kirill.test.orders.model.Status;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatus(Status status);

    Optional<Order> findById(Long id);

}

