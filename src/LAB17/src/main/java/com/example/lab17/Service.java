package com.example.lab17;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    public List<Item> getItemsBy(String filter) {
        session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Item> itemCriteriaQuery = builder.createQuery(Item.class);
        Root<Item> root = itemCriteriaQuery.from(Item.class);

        itemCriteriaQuery.select(root).orderBy(builder.asc(root.get(filter)));
        Query<Item> query = session.createQuery(itemCriteriaQuery);
        return query.getResultList();
    }
    
    public List<Order> getOrdersBy(String filter) {
        session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Order> orderCriteriaQuery = builder.createQuery(Order.class);
        Root<Order> root = orderCriteriaQuery.from(Order.class);

        orderCriteriaQuery.select(root).orderBy(builder.asc(root.get(filter)));
        Query<Order> query = session.createQuery(orderCriteriaQuery);
        return query.getResultList();
    }

    @PreDestroy
    public void dest() {
        session.close();
    }
}
