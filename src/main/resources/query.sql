SELECT customer_id, product_id
FROM orders_product
RIGHT JOIN customers on orders_product.customer_id = customers.id
WHERE customers.id < 10
GROUP BY product_id