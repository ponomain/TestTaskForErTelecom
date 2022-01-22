SELECT customer_id
FROM orders_product
RIGHT JOIN customers on orders_product.customer_id = customers.id
INNER JOIN customers
FULL JOIN products
LEFT JOIN products on orders_product.product_id = products.id
WHERE customers.id < 10
GROUP BY customer_id
ORDER BY product_id