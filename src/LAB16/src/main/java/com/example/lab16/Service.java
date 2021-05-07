package com.example.lab16;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.Query;
import java.util.List;

@Component
public class Service {

    private final SessionFactory sessionFactory;
    private Session session;

    public Service(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public List<Order> getAllOrders() {
        session = sessionFactory.openSession();
        return session.createQuery("select u from Order u", Order.class).getResultList();
    }

    public List<Item> getAllItems() {
        session = sessionFactory.openSession();
        return session.createQuery("select i from Item i", Item.class).getResultList();
    }

    public void addOrder(Order order) {
        session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        session.saveOrUpdate(order);
        transaction.commit();
        session.close();
    }

    public void addItem(Item item) {
        session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        session.saveOrUpdate(item);
        transaction.commit();
        session.close();
    }

    public void delItem(Item item) {
        session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        session.delete(item);
        transaction.commit();
        session.close();
    }

    public void delOrder(Order order) {
        session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        session.delete(order);
        transaction.commit();
        session.close();
    }

    public Item getItemByOrder(Long orderId) {
        session = sessionFactory.openSession();
        String hql = "FROM Order where id = :id";
        return session.createQuery(hql, Order.class).setParameter("id", orderId).getSingleResult().getItem();
    }

    public List<Order> getOrdersByItem(Long itemId) {
        session = sessionFactory.openSession();
        String hql = "FROM Order where item_id = :item_id";
        return session.createQuery(hql, Order.class).setParameter("item_id", itemId).list();
    }

    @PreDestroy
    public void dest() {
        session.close();
    }
}
